package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.business.FuncaoService;
import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.LoginService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * @author joelamalio
 */
@ManagedBean(name = "cargaBean")
@SessionScoped
public class CargaBean implements Serializable {
    
    @EJB
    private FuncaoService funcaoService;
    @EJB
    private LoginService loginService;
    private boolean iniciado = false;
    
    public String prepararBanco() {
        this.inserirUsuario();
        this.inserirProfissional();
        this.iniciado = true;
        return this.redirecionarParaLogin();
    }
    
    public String redirecionarParaLogin () {
        return "login";
    }

    public boolean isIniciado() {
        return iniciado;
    }
    
    private void inserirProfissional() {
        this.funcaoService.salvar(new Funcao("ANALISTA-JUNIOR"));
        this.funcaoService.salvar(new Funcao("ANALISTA-PLENO"));
        this.funcaoService.salvar(new Funcao("ANALISTA-SENIOR"));
        this.funcaoService.salvar(new Funcao("GERENTE"));
        this.funcaoService.salvar(new Funcao("PROGRAMADOR"));
    }
    
    private void inserirUsuario() {
        final Usuario usuario1 = new Usuario();
        usuario1.setEmail("admin@frb.edu.br");
        usuario1.setSenha("admin");
        this.loginService.salvarUsuario(usuario1);
    }
    
}
