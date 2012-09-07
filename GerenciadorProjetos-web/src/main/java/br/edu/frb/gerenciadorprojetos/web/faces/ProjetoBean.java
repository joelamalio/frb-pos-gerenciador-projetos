package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author antoniojunior87
 */
@ManagedBean(name = "projetoBean")
@ViewScoped
public class ProjetoBean {

    private Projeto projeto;
    private List<Projeto> listaProjeto;

    public ProjetoBean() {
        projeto = new Projeto();
    }

    public void salvar() {
    }

    public void pesquisar() {
        listaProjeto = new ArrayList<Projeto>();
        listaProjeto.add(new Projeto("Projeto 1"));
        listaProjeto.add(new Projeto("Projeto 2"));
        listaProjeto.add(new Projeto("Projeto 3"));
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