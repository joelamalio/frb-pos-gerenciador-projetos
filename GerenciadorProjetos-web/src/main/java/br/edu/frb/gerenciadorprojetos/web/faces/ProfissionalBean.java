package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.common.entity.GrauInstrucao;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.ProfissionalService;
import java.util.ArrayList;
import java.util.Arrays;
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
@ManagedBean(name = "profissionalBean")
@SessionScoped
public class ProfissionalBean {

    private Profissional profissional;
    private List<Profissional> listaProfissional;
    private Integer tamanhoListaProfissional;
    @EJB()
    private ProfissionalService service;

    public ProfissionalBean() {
        profissional = new Profissional();
    }

    public String salvar() {
        service.salvar(profissional);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Profissional Salvo"));
        return "listaProfissional";
    }

    public String novo() {
        return "cadastroProfissional";
    }

    public void pesquisar() {
        listaProfissional = service.listar();
//        listaProfissional = new ArrayList<Profissional>();
//        listaProfissional.add(new Profissional("João"));
//        listaProfissional.add(new Profissional("Maria"));
//        listaProfissional.add(new Profissional("Jesus"));
//        this.tamanhoListaProfissional = this.listaProfissional.size();
    }

    public String initPesquisa() {
        this.profissional = new Profissional();
        this.listaProfissional = new ArrayList<Profissional>();
        this.tamanhoListaProfissional = 0;
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

    public Integer getTamanhoListaProfissional() {
        return tamanhoListaProfissional;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
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