package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.business.ProjetoService;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
@ManagedBean(name = "projetoBean")
@SessionScoped
public class ProjetoBean implements Serializable {

    @EJB
    private ProjetoService projetoService;
    @EJB
    private ProfissionalService profissionalService;
    private Projeto projeto;
    private List<Projeto> listaProjeto;
    private Integer tamanhoListaProjeto;

    public ProjetoBean() {
    }

    public String abrirProjeto() {
        projeto = new Projeto();
        return "cadastroProjeto";
    }

    public String salvar() {
        projetoService.salvar(projeto);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Projeto aberto com sucesso!"));
        return initPesquisa();
    }

    public void pesquisar() {
        listaProjeto = projetoService.listar(projeto);
        this.tamanhoListaProjeto = this.listaProjeto.size();
    }

    public String initPesquisa() {
        this.projeto = new Projeto();
        this.listaProjeto = new ArrayList<Projeto>();
        this.tamanhoListaProjeto = 0;
        return "listaProjeto";
    }

    public String initEncerrar(final Long id) {
        this.projeto = this.projetoService.obterPorId(id);
        return "encerraProjeto";
    }

    public String encerrar() {
        if (projeto != null) {
            if (projeto.getDataAbertura().after(projeto.getDataFechamento())) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "A 'Data de Fechamento' não pode ser menor que a 'Data de Abertura'"));
            } else {
                projetoService.atualizar(projeto);
                return this.resumo(projeto.getId());
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", "Projeto com ID nulo."));
        }
        return null;
    }
    
    public String resumo(final Long id) {
        this.projeto = this.projetoService.obterPorId(id);
        return "resumoEncerraProjeto";
        
    }

    public List<Profissional> getListaProfissional() {
        return profissionalService.listar();
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public Integer getTamanhoListaProjeto() {
        return tamanhoListaProjeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getListaProjeto() {
        return listaProjeto;
    }

    public void setListaProjeto(List<Projeto> listaProjeto) {
        this.listaProjeto = listaProjeto;
    }
}