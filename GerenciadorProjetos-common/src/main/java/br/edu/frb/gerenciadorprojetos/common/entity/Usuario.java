package br.edu.frb.gerenciadorprojetos.common.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
@Entity(name = "USUARIO")
public class Usuario implements Serializable {

    @Id
    @SequenceGenerator(name = "USUA_ID", allocationSize = 1, initialValue = 1, sequenceName = "USUA_ID")
    @GeneratedValue(generator = "USUA_ID", strategy = GenerationType.SEQUENCE)
    @Column(name = "USUA_ID")
    private Long id;
    @Column(name = "USUA_EMAIL")
    private String email;
    @Column(name = "USUA_SENHA")
    private String senha;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROF_ID", referencedColumnName = "PROF_ID")
    private Profissional profissional;

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public Profissional getProfissional() {
        return profissional;
    }

    public void setEmail(final String email) {
        if (email != null) {
            this.email = email.toLowerCase();
        }
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProfissional(Profissional profissional) {
        this.profissional = profissional;
    }

    @Override
    public String toString() {
        return this.email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.email == null) ? (other.email != null) : !this.email.equals(other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 53 * hash + (this.email != null ? this.email.hashCode() : 0);
        return hash;
    }
}
