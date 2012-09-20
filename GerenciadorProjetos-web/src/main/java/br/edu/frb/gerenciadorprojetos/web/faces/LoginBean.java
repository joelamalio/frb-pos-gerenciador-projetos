package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.LoginService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
        Usuario usuarioLogado = service.logar(usuario);
        if(null != usuarioLogado){
            return "index";
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuário não existe!"));
        return "login";
    }
    
    public String salvarUsuario() {
        service.salvarUsuario(usuario);
        usuario = new Usuario();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Usuário cadastrado com sucesso!"));
        return "index";
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public String novoUsuario() {
        return "cadastroUsuario";
    }
}
