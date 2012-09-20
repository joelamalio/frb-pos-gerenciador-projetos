package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.FuncaoService;
import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
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
public class FuncaoServiceImpl implements FuncaoService {

    @EJB
    GenericDao dao;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public List<Funcao> listar() {
        return dao.listarTodos(Funcao.class);
    }

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Funcao> listar(final Funcao funcao) {
        final Map<String, Object> param = new HashMap<String, Object>();
        final String descricao;
        if (funcao.getDescricao() == null || funcao.getDescricao().isEmpty()) {
            descricao = "";
        } else {
            descricao = funcao.getDescricao().trim();
        }

        param.put("descricao", "%" + descricao + "%");
        return dao.buscarPorNamedQuery("Funcao.findByDescricao", param);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void salvar(Funcao funcao) {
        dao.salvar(funcao);
    }
}
