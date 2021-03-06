package br.edu.frb.gerenciadorprojetos.web.faces;

import br.edu.frb.gerenciadorprojetos.common.business.FuncaoService;
import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.business.ProjetoService;
import br.edu.frb.gerenciadorprojetos.common.business.TarefaService;
import br.edu.frb.gerenciadorprojetos.common.entity.*;
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
    @EJB
    private ProjetoService projetoService;
    @EJB
    private TarefaService tarefaService;
    private boolean iniciado = false;
    
    public String prepararBanco() {
        this.inserirFuncao();
        this.inserirUsuario();
        this.inserirProfissional();
        this.inserirProjeto();
        this.inserirTarefa();
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
        profissional2.setGrauInstrucao(GrauInstrucao.SUPERIOR);
        profissional2.setCpf("999.999.999-22");
        profissional2.setDataNascimento(new Date(92, 1, 1));
        profissional2.setDataAdmissao(new Date(112, 2, 22));
        this.profissionalService.salvar(profissional2);
        final Usuario usuarioGerente1 = new Usuario();
        usuarioGerente1.setEmail("gerente1@frb.edu.br");
        usuarioGerente1.setSenha("gerente1");
        this.loginService.salvarUsuario(usuarioGerente1);
        final Profissional gerente1 = new Profissional();
        gerente1.setFuncao(this.funcaoService.listar(new Funcao("GERENTE")).get(0));
        gerente1.setUsuario(usuarioGerente1);
        gerente1.setNome("Gerente 1");
        gerente1.setGrauInstrucao(GrauInstrucao.MESTRADO);
        gerente1.setCpf("999.999.999-99");
        gerente1.setDataNascimento(new Date(82, 2, 2));
        gerente1.setDataAdmissao(new Date(100, 2, 22));
        this.profissionalService.salvar(gerente1);
        final Usuario usuarioGerente2 = new Usuario();
        usuarioGerente2.setEmail("gerente2@frb.edu.br");
        usuarioGerente2.setSenha("gerente2");
        this.loginService.salvarUsuario(usuarioGerente1);
        final Profissional gerente2 = new Profissional();
        gerente2.setFuncao(this.funcaoService.listar(new Funcao("GERENTE")).get(0));
        gerente2.setUsuario(usuarioGerente2);
        gerente2.setNome("Gerente 2");
        gerente2.setGrauInstrucao(GrauInstrucao.MESTRADO);
        gerente2.setCpf("999.999.999-88");
        gerente2.setDataNascimento(new Date(82, 2, 2));
        gerente2.setDataAdmissao(new Date(100, 2, 22));
        this.profissionalService.salvar(gerente2);
    }
    
    private void inserirProjeto() {
        final Projeto projeto1 = new Projeto();
        projeto1.setCodigo("PROJ-1");
        projeto1.setNome("PROJETO 1");
        projeto1.setDataAbertura(new Date(112, 6, 1));
        projeto1.setDataPrevisaoTermino(new Date(112, 10, 1));
        projeto1.setDataFechamento(new Date(112, 9, 18));
        projeto1.setGerente(this.profissionalService.listar(new Profissional("Gerente 1")).get(0));
        this.projetoService.salvar(projeto1);
        final Projeto projeto2 = new Projeto();
        projeto2.setCodigo("PROJ-2");
        projeto2.setNome("PROJETO 2");
        projeto2.setDataAbertura(new Date(112, 1, 1));
        projeto2.setDataPrevisaoTermino(new Date(112, 12, 1));
        projeto2.setGerente(this.profissionalService.listar(new Profissional("Gerente 2")).get(0));
        this.projetoService.salvar(projeto2);
    }
    
    private void inserirTarefa() {
        final Tarefa tarefa1 = new Tarefa();
        tarefa1.setDataInicio(new Date(112, 1, 1));
        tarefa1.setDataTermino(new Date(112, 1, 1));
        tarefa1.setDescricao("Tarefa de configuracao do ambiente de desenvolvimento.");
        tarefa1.setResponsavel(this.profissionalService.listar(new Profissional("Usuário 2")).get(0));
        tarefa1.setProjeto(this.projetoService.obterProjetoPorCodigo("PROJ-2"));
        this.tarefaService.salvar(tarefa1);
    }
    
}
