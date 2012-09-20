package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.business.ProjetoService;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author antoniojunior87
 * @joelamalio
 */
@Stateless
public class ProjetoServiceImpl implements ProjetoService {

    @EJB
    GenericDao dao;

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Projeto> listar() {
        return dao.listarTodos(Projeto.class);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public Projeto obterPorId(final Long id) {
        final Map<String, Object> param = new HashMap<String, Object>();

        param.put("id", id);
        return (Projeto) dao.buscarPorNamedQuery("Projeto.findById", param).get(0);
    }
    
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Projeto> listar(final Projeto projeto) {
        final Map<String, Object> param = new HashMap<String, Object>();
        final String nome;
        if (projeto.getNome() == null || projeto.getNome().isEmpty()) {
            nome = "";
        } else {
            nome = projeto.getNome().trim();
        }

        param.put("nome", "%" + nome + "%");
        return dao.buscarPorNamedQuery("Projeto.findByNome", param);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void salvar(Projeto projeto) {
        dao.salvar(projeto);
    }
}
