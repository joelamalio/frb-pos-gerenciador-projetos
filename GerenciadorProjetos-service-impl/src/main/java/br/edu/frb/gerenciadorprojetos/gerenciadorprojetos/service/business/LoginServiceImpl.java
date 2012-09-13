package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import java.util.List;
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
        List<Object> usuarios = (List<Object>)dao.buscarPorNativeQuery(this.retornarBuscaUsuario(usuario));
        
        if (!usuarios.isEmpty()) {
            return (Usuario)usuarios.get(0);
        }else return null;
        
    }
    
    private String retornarBuscaUsuario(Usuario usuario){
        String sql = "SELECT u.* FROM Usuario u ";
        sql += " WHERE u.USUA_EMAIL = '" + usuario.getEmail() + "'";
        sql += " AND u.USUA_SENHA = '" + usuario.getSenha() + "'";
        return sql;
    }
    
}
