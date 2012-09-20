package br.edu.frb.gerenciadorprojetos.common.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Tarefa;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * @joelamalio
 */
@Remote
public interface TarefaService extends Serializable {

    List<Tarefa> obterTodos();
    
    List<Tarefa> obterPorFiltro(Tarefa tarefa);
    
    Tarefa obterPorId(Long id);
    
    void salvar(Tarefa tarefa);
    
    void atualizar(Tarefa tarefa);
}
