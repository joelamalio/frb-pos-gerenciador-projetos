package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.business.FuncaoService;
import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.common.entity.GrauInstrucao;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Usuario;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.LoginService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    @EJB
    private ProfissionalService profissionalService;
    private boolean iniciado = false;
    
    public String prepararBanco() {
        this.inserirFuncao();
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
    
    private void inserirFuncao() {
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
    
    private void inserirProfissional() {
        final List<Funcao> funcoes = this.funcaoService.listar();
        final Usuario usuario1 = new Usuario();
        usuario1.setEmail("usuario1@frb.edu.br");
        usuario1.setSenha("usuario1");
        this.loginService.salvarUsuario(usuario1);
        final Profissional profissional1 = new Profissional();
        profissional1.setFuncao(funcoes.get(1));
        profissional1.setUsuario(usuario1);
        profissional1.setNome("Usuário 1");
        profissional1.setGrauInstrucao(GrauInstrucao.TECNICO);
        profissional1.setCpf("999.999.999-11");
        profissional1.setDataNascimento(new Date(90, 1, 1));
        profissional1.setDataAdmissao(new Date(111, 11, 1));
        this.profissionalService.salvar(profissional1);
        final Usuario usuario2 = new Usuario();
        usuario2.setEmail("usuario2@frb.edu.br");
        usuario2.setSenha("usuario2");
        this.loginService.salvarUsuario(usuario1);
        final Profissional profissional2 = new Profissional();
        profissional2.setFuncao(funcoes.get(2));
        profissional2.setUsuario(usuario2);
        profissional2.setNome("Usuário 2");
        profissional2.setGrauInstrucao(GrauInstrucao.TECNICO);
        profissional2.setCpf("999.999.999-22");
        profissional2.setDataNascimento(new Date(92, 1, 1));
        profissional2.setDataAdmissao(new Date(112, 2, 22));
        this.profissionalService.salvar(profissional2);
    }
    
}
