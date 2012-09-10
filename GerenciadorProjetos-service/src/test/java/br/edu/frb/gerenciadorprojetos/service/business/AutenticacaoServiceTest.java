package br.edu.frb.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import org.junit.Test;

/**
 * @author joelamalio
 */
public class AutenticacaoServiceTest {

    private AutenticacaoService autenticacaoService;

    @Test
    public void quandoUsuarioSolicitarAutenticacaoComDadosValidosDevePassarComSucesso() throws Exception {
        final Usuario usuario = new Usuario();
        usuario.setEmail("joel.amalio@gmail.com");
        usuario.setSenha("teste");
        //this.autenticacaoService.logon(usuario);
    }
}
