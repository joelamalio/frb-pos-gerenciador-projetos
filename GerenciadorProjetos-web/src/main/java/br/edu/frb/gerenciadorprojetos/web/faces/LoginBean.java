package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.LoginService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author brunomsc
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

    private Usuario usuario;
    @EJB()
    private LoginService service;

    public LoginBean() {
        usuario = new Usuario();
    }

    public String sair() {
        usuario = new Usuario();
        return "login";
    }

    public String logar() {
        service.logar(usuario);
        return "logar";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
