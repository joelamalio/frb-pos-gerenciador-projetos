package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author brunomsc
 */

@Stateless
public class LoginServiceImpl implements LoginService {

    @EJB
    GenericDao dao;
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void sair(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public Usuario logar(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
