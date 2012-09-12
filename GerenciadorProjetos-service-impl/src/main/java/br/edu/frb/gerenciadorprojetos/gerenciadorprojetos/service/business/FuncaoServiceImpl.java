package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.FuncaoService;
import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author antoniojunior87
 */
@Stateless
public class FuncaoServiceImpl implements FuncaoService {

    @EJB
    GenericDao dao;

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Funcao> listar() {
        return dao.listarTodos(Funcao.class);
    }
}
