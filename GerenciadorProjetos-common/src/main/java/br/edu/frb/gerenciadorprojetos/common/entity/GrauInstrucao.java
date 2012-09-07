package br.edu.frb.gerenciadorprojetos.common.entity;

import java.io.Serializable;

/**
 * @author antoniojunior87
 * @author joelamalio
 */
public enum GrauInstrucao implements Serializable {

    TECNICO("TEC", "TECNICO"),
    SUPERIOR("SUP", "SUPERIOR"),
    MESTRADO("MES", "MESTRADO"),
    DOUTORADO("DOU", "DOUTORADO");
    private String id;
    private String descricao;

    private GrauInstrucao(final String id, final String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static GrauInstrucao from(final String valor) {
        for (GrauInstrucao gi : values()) {
            if (gi.getId().equalsIgnoreCase(valor) || gi.getDescricao().equalsIgnoreCase(valor)) {
                return gi;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}
