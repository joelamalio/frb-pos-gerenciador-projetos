package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.business.FuncaoService;
import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.common.entity.GrauInstrucao;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
@ManagedBean(name = "profissionalBean")
@SessionScoped
public class ProfissionalBean implements Serializable {

    private Profissional profissional;
    private List<Profissional> listaProfissional;
    @EJB
    private ProfissionalService profissionalService;
    @EJB
    private FuncaoService funcaoService;

    public ProfissionalBean() {
    }

    @PostConstruct
    public void init() {
        profissional = new Profissional();
        profissional.setUsuario(new Usuario());
    }

    public String salvar() {
        profissional.setUsuario(null);
        profissional.setTarefas(null);
        profissionalService.salvar(profissional);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Profissional Salvo"));
        return initPesquisa();
    }

    public String novo() {
        profissional = new Profissional();
        profissional.setUsuario(new Usuario());
        return "cadastroProfissional";
    }

    public void pesquisar() {
        listaProfissional = profissionalService.listar(profissional);
    }

    public String initPesquisa() {
        this.profissional = new Profissional();
        this.listaProfissional = new ArrayList<Profissional>();
        return "listaProfissional";
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public List<GrauInstrucao> getListaGrauInstrucao() {
        List<GrauInstrucao> lista = new ArrayList<GrauInstrucao>(Arrays.asList(GrauInstrucao.values()));
        return lista;
    }

    public List<Profissional> getListaProfissional() {
        return listaProfissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setListaProfissional(List<Profissional> listaProfissional) {
        this.listaProfissional = listaProfissional;
    }

    public List<Funcao> getListaFuncao() {
        return funcaoService.listar();
    }
}