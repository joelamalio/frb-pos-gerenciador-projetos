package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.common.entity.GrauInstrucao;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.service.business.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author antoniojunior87
 */
@ManagedBean(name = "profissionalBean")
@ViewScoped
public class ProfissionalBean {

    //@javax.inject.Inject
    private Service service;
    private Profissional profissional;
    private List<Profissional> listaProfissional;

    public ProfissionalBean() {
        profissional = new Profissional();
    }

    public String salvar() {
        service.getDao().persist(profissional);
        return "listaProfissional";
    }

    public String novo() {
        return "cadastroProfissional";
    }

    public void pesquisar() {
        listaProfissional = new ArrayList<Profissional>();
        listaProfissional.add(new Profissional("João"));
        listaProfissional.add(new Profissional("Maria"));
        listaProfissional.add(new Profissional("Jesus"));
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public List<GrauInstrucao> getListaGrauInstrucao() {
        List<GrauInstrucao> lista = new ArrayList<GrauInstrucao>(Arrays.asList(GrauInstrucao.values()));
        return lista;
    }

    public List<Profissional> getListaProfissional() {
        return listaProfissional;
    }

    public void setListaProfissional(List<Profissional> listaProfissional) {
        this.listaProfissional = listaProfissional;
    }

    public List<Funcao> getListaFuncao() {
        List<Funcao> lista = new ArrayList<Funcao>();
        lista.add(new Funcao("Analista JR"));
        lista.add(new Funcao("Analista Pleno"));
        lista.add(new Funcao("Analista Senior"));
        lista.add(new Funcao("Programador"));
        lista.add(new Funcao("Gerente"));
        return lista;
    }
}