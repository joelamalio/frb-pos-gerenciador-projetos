package br.edu.frb.gerenciadorprojetos.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
@Entity(name = "TAREFA")
@NamedQueries({
    @NamedQuery(name = "Tarefa.findById",
    query = "SELECT tare FROM TAREFA tare LEFT JOIN FETCH tare.responsavel resp LEFT JOIN FETCH tare.projeto proj WHERE tare.id = :id "),
    @NamedQuery(name = "Tarefa.findByDescricao",
    query = "SELECT tare FROM TAREFA tare LEFT JOIN FETCH tare.responsavel resp LEFT JOIN FETCH tare.projeto proj WHERE tare.descricao LIKE :descricao ORDER BY tare.descricao ASC ")})
public class Tarefa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TARE_ID")
    private Long id;
    @Column(name = "TARE_DESCRICAO")
    private String descricao;
    @Temporal(TemporalType.DATE)
    @Column(name = "TARE_DT_INICIO")
    private Date dataInicio;
    @Temporal(TemporalType.DATE)
    @Column(name = "TARE_DT_PREVISAO_TERMINO")
    private Date dataPrevisaoTermino;
    @Temporal(TemporalType.DATE)
    @Column(name = "TARE_DT_TERMINO")
    private Date dataTermino;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROF_ID", referencedColumnName = "PROF_ID")
    private Profissional responsavel;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROJ_ID", referencedColumnName = "PROJ_ID")
    private Projeto projeto;

    public Tarefa() {
    }

    public Long getId() {
        return id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataPrevisaoTermino() {
        return dataPrevisaoTermino;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public Profissional getResponsavel() {
        return responsavel;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataPrevistaTermino(Date dataPrevisaoTermino) {
        this.dataPrevisaoTermino = dataPrevisaoTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setResponsavel(Profissional responsavel) {
        this.responsavel = responsavel;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
