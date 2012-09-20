package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author antoniojunior87
 */
@Stateful
public class ProfissionalServiceImpl implements ProfissionalService {

    @EJB
    GenericDao dao;

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Profissional> listar() {
        return dao.listarTodos(Profissional.class);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Profissional> listar(Profissional profissional) {
        final Map<String, Object> param = new HashMap<String, Object>();
        final String nome;
        if (profissional.getNome() == null || profissional.getNome().isEmpty()) {
            nome = "";
        } else {
            nome = profissional.getNome().trim();
        }

        param.put("nome", "%" + nome + "%");
        return dao.buscarPorNamedQuery("Profissional.findByNome", param);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void salvar(Profissional profissional) {
        dao.salvar(profissional);
    }
}
