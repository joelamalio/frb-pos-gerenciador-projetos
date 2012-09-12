package br.edu.frb.gerenciadorprojetos.common.entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
@Entity(name = "PROFISSIONAL")
@Table(name = "PROFISSIONAL")
public class Profissional implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROF_ID")
    private Long id;
    @Column(name = "PROF_NOME")
    private String nome;
    @Column(name = "PROF_CPF")
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name = "PROF_DT_NASCIMENTO")
    private Date dataNascimento;
    @Temporal(TemporalType.DATE)
    @Column(name = "PROF_DT_ADMISSAO")
    private Date dataAdmissao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FUNC_ID", referencedColumnName = "FUNC_ID")
    private Funcao funcao = new Funcao();
    @Enumerated(value = EnumType.STRING)
    @Column(name = "PROF_GRAU_INSTRUCAO")
    private GrauInstrucao grauInstrucao;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUA_ID", referencedColumnName = "USUA_ID")
    private Usuario usuario = new Usuario();
    @OneToMany(mappedBy = "responsavel", fetch = FetchType.LAZY)
    private Set<Tarefa> tarefas = new HashSet<Tarefa>();

    public Profissional() {
        usuario = new Usuario();
    }

    public Profissional(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public GrauInstrucao getGrauInstrucao() {
        return grauInstrucao;
    }

    public String getNome() {
        return nome;
    }

    public Set<Tarefa> getTarefas() {
        return Collections.unmodifiableSet(tarefas);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    public void setGrauInstrucao(GrauInstrucao grauInstrucao) {
        this.grauInstrucao = grauInstrucao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void adicionar(final Tarefa tarefa) {
        if (this.tarefas == null) {
            this.tarefas = new HashSet<Tarefa>();
        }
        this.tarefas.add(tarefa);
    }

    public void remover(final Tarefa tarefa) {
        if (this.tarefas == null) {
            this.tarefas = new HashSet<Tarefa>();
        }
        this.tarefas.remove(tarefa);
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profissional other = (Profissional) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.cpf == null) ? (other.cpf != null) : !this.cpf.equals(other.cpf)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.cpf != null ? this.cpf.hashCode() : 0);
        return hash;
    }
}
