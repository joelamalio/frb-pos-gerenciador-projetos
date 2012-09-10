package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
@ManagedBean(name = "projetoBean")
@SessionScoped
public class ProjetoBean implements Serializable {

    private Projeto projeto;
    private List<Projeto> listaProjeto;
    private Integer tamanhoListaProjeto;

    public ProjetoBean() {
    }

    public void salvar() {
    }

    public void pesquisar() {
        listaProjeto = new ArrayList<Projeto>();
        listaProjeto.add(new Projeto("Projeto 1"));
        listaProjeto.add(new Projeto("Projeto 2"));
        listaProjeto.add(new Projeto("Projeto 3"));
        this.tamanhoListaProjeto = this.listaProjeto.size();
    }
    
    public String initPesquisa() {
        this.projeto = new Projeto();
        this.listaProjeto = new ArrayList<Projeto>();
        this.tamanhoListaProjeto = 0;
        return "listaProjeto";
    }

    public List<Profissional> getListaProfissional() {
        List<Profissional> lista = new ArrayList<Profissional>();
        lista.add(new Profissional("João"));
        lista.add(new Profissional("Maria"));
        lista.add(new Profissional("Jesus"));
        return lista;
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