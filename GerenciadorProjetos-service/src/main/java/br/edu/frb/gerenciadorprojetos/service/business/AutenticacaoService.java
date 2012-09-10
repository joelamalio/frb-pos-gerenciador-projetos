package br.edu.frb.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import java.io.Serializable;
import javax.ejb.Remote;

/**
 * @author joelamalio
 */
@Remote
public interface AutenticacaoService extends Serializable {

    void logon(Usuario usuario) throws Exception;

    void logout(Usuario usuario) throws Exception;
}
