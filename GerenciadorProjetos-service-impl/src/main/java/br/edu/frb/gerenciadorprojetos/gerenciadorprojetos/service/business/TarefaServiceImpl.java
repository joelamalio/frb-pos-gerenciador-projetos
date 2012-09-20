package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.TarefaService;
import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import br.edu.frb.gerenciadorprojetos.common.entity.Tarefa;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @joelamalio
 */
@Stateless
public class TarefaServiceImpl implements TarefaService {

    @EJB
    GenericDao dao;

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Tarefa> obterTodos() {
        return dao.listarTodos(Tarefa.class);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public Tarefa obterPorId(final Long id) {
        final Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", id);
        return (Tarefa) dao.buscarPorNamedQuery("Tarefa.findById", param).get(0);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Tarefa> obterPorFiltro(final Tarefa tarefa) {
        final Map<String, Object> param = new HashMap<String, Object>();
        final String descricao;
        if (tarefa.getDescricao() == null || tarefa.getDescricao().isEmpty()) {
            descricao = "";
        } else {
            descricao = tarefa.getDescricao().trim();
        }

        param.put("descricao", "%" + descricao + "%");
        return dao.buscarPorNamedQuery("Tarefa.findByDescricao", param);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void salvar(Tarefa tarefa) {
        dao.salvar(tarefa);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void atualizar(Tarefa tarefa) {
        dao.atualizar(tarefa);
    }
}
