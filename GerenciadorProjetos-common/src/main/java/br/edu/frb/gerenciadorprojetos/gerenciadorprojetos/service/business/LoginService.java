package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;

/**
 *
 * @author brunomsc
 */
public interface LoginService {
    
    void sair(Usuario usuario);
    
    Usuario logar(Usuario usuario);
}
