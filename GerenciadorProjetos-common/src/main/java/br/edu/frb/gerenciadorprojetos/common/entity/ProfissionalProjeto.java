package br.edu.frb.gerenciadorprojetos.common.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
public class ProfissionalProjeto implements Serializable {

    @Id
    @Column(name = "PRPR_ID")
    private Long id;
    @Transient
    private Projeto projeto;
    @Transient
    private Profissional profissional;
    @Column(name = "PRPR_DT_ENTRADA")
    private Date dataEntrada;
    @Column(name = "PRPR_DT_DESLIGAMENTO")
    private Date dataDesligamento;

    public ProfissionalProjeto() {
    }

    public Long getId() {
        return id;
    }

    public Date getDataDesligamento() {
        return dataDesligamento;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setDataDesligamento(Date dataDesligamento) {
        this.dataDesligamento = dataDesligamento;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
