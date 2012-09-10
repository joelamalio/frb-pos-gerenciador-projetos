package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import br.edu.frb.gerenciadorprojetos.common.util.Util;
import br.edu.frb.gerenciadorprojetos.service.business.AutenticacaoService;
import javax.ejb.Stateful;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

/**
 * @author joelamalio
 */
@Stateful
@TransactionManagement(TransactionManagementType.BEAN)
public class AutenticacaoServiceImpl implements AutenticacaoService {
    
    @Override
    public void logon(final Usuario usuario) throws Exception {
        this.verficarCampos(usuario);
        // autenticar usuario
        // incluir usuario na sessao
    }

    @Override
    public void logout(final Usuario usuario) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void verficarCampos(final Usuario usuario) throws Exception {
        if (Util.isNullOrEmpty(usuario.getEmail())) {
            throw new Exception("O campo E-mail é ogrigatório");
        }
        if (Util.isNullOrEmpty(usuario.getSenha())) {
            throw new Exception("O campo Senha é ogrigatório");
        }

    }
}
