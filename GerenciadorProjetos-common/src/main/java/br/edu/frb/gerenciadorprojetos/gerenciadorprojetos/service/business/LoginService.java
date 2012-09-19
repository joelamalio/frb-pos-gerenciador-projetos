package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import javax.ejb.Remote;

/**
 *
 * @author brunomsc
 */
@Remote
public interface LoginService {

    void sair(Usuario usuario);

    Usuario logar(Usuario usuario);

    void salvarUsuario(Usuario usuario);
}
