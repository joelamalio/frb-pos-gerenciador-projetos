package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.business.TarefaService;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import br.edu.frb.gerenciadorprojetos.common.entity.Tarefa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author joelamalio
 */
@ManagedBean(name = "tarefaBean")
@SessionScoped
public class TarefaBean implements Serializable {

    @EJB
    private TarefaService tarefaService;
    @EJB
    private ProfissionalService profissionalService;
    private Tarefa tarefa;
    private List<Tarefa> listaTarefa;

    public TarefaBean() {
    }
    
    @PostConstruct
    public void init() {
        tarefa = new Tarefa();
        tarefa.setProjeto(new Projeto());
        tarefa.setResponsavel(new Profissional());
        pesquisar();
    }

    public String abrirTarefa() {
        tarefa = new Tarefa();
        return "cadastroTarefa";
    }

    public String salvar() {
        return "cadastroTarefa";
    }

    public void pesquisar() {
        listaTarefa = tarefaService.obterPorFiltro(tarefa);
    }

    public String initPesquisa() {
        this.tarefa = new Tarefa();
        this.listaTarefa = new ArrayList<Tarefa>();
        return "listaTarefa";
    }

    public List<Profissional> getListaProfissional() {
        return profissionalService.listar();
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    public List<Tarefa> getListaTarefa() {
        return listaTarefa;
    }

    public void setListaTarefa(List<Tarefa> listaTarefa) {
        this.listaTarefa = listaTarefa;
    }
}