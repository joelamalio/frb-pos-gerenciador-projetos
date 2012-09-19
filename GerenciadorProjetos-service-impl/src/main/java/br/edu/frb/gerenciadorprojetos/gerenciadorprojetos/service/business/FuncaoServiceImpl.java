package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.FuncaoService;
import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import java.util.List;
import javax.ejb.*;

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

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void salvar(Funcao funcao) {
        dao.salvar(funcao);
    }
}
