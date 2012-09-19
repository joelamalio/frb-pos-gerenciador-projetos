package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
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
 */
@Stateless
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
        if (profissional.getNome() == null || profissional.getNome().isEmpty()) {
            return listar();
        }

        Map<String, Object> param = new HashMap<String, Object>();
        param.put("nome", profissional.getNome());
        return dao.buscarPorNamedQuery("Profissional.findByNome", param);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void salvar(Profissional profissional) {
        dao.salvar(profissional);
    }
}
