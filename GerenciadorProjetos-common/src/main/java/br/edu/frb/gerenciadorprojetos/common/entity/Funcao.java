package br.edu.frb.gerenciadorprojetos.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
@Entity(name = "FUNCAO")
@NamedQueries({
    @NamedQuery(name = "Funcao.findByDescricao",
    query = "SELECT f FROM FUNCAO f WHERE f.descricao LIKE :descricao ORDER BY f.descricao ASC")})
public class Funcao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FUNC_ID")
    private Long id;
    @Column(name = "FUNC_DESCRICAO")
    private String descricao;

    public Funcao() {
    }

    public Funcao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (id != null) {
            return id.toString();
        }
        return "";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Funcao other = (Funcao) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }
}
