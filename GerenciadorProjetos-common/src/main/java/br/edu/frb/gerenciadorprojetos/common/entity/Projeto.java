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
@Entity(name = "PROJETO")
@NamedQueries({
    @NamedQuery(name = "Projeto.findById",
    query = "SELECT pr FROM PROJETO pr LEFT JOIN FETCH pr.gerente g LEFT JOIN FETCH pr.tarefas t WHERE pr.id = :id "),
@NamedQuery(name = "Projeto.findByNome",
    query = "SELECT pr FROM PROJETO pr LEFT JOIN FETCH pr.gerente g LEFT JOIN FETCH pr.tarefas t WHERE pr.nome LIKE :nome ORDER BY pr.nome ASC ")})
public class Projeto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJ_ID")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROF_ID", referencedColumnName = "PROF_ID")
    private Profissional gerente;
    @Column(name = "PROJ_CODIGO")
    private String codigo;
    @Column(name = "PROJ_NOME")
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "PROJ_DT_ABERTURA")
    private Date dataAbertura;
    @Temporal(TemporalType.DATE)
    @Column(name = "PROJ_DT_PREVISAO_TERMINO")
    private Date dataPrevisaoTermino;
    @Temporal(TemporalType.DATE)
    @Column(name = "PROJ_DT_FECHAMENTO")
    private Date dataFechamento;
    @OneToMany(mappedBy = "projeto", fetch = FetchType.LAZY)
    private Set<Tarefa> tarefas;

    public Projeto() {
    }

    public Projeto(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public Date getDataPrevisaoTermino() {
        return dataPrevisaoTermino;
    }

    public Profissional getGerente() {
        return gerente;
    }

    public String getNome() {
        return nome;
    }

    public Set<Tarefa> getTarefas() {
        return Collections.unmodifiableSet(tarefas);
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public void setDataPrevisaoTermino(Date dataPrevisaoTermino) {
        this.dataPrevisaoTermino = dataPrevisaoTermino;
    }

    public void setGerente(Profissional gerente) {
        this.gerente = gerente;
    }

    public void setNome(final String nome) {
        if (nome != null) {
            this.nome = nome.toUpperCase();
        }
    }

    public void setTarefas(Set<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtdDiasAtraso() {
        if (this.dataFechamento != null && this.dataPrevisaoTermino != null) {
            if (this.dataFechamento.after(this.dataPrevisaoTermino)) {
                return null;
            }
        }
        return 0;
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
    
    public boolean isEncerrado() {
        if (this.dataFechamento == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Projeto other = (Projeto) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.codigo == null) ? (other.codigo != null) : !this.codigo.equals(other.codigo)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 79 * hash + (this.codigo != null ? this.codigo.hashCode() : 0);
        return hash;
    }
}
