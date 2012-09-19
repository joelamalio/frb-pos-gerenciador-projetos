package br.edu.frb.gerenciadorprojetos.web.converter;

import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import br.edu.frb.gerenciadorprojetos.common.entity.GrauInstrucao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author joelamalio
 */
@FacesConverter("GrauInstrucaoConverter")
public class GrauInstrucaoConverter implements Converter {

    @Override
    public Object getAsObject(final FacesContext context, final UIComponent component, final String value) {
        if (value == null || value.equals("")) {
            return null;
        }

        try {
            return GrauInstrucao.from(value);
        } catch (Exception ex) {
            final String texto = String.format("Não foi possível aplicar conversão de item com valor [%s] no componente [%s]", value, component.getId());
            throw new ConverterException(texto, ex);
        }
    }

    @Override
    public String getAsString(final FacesContext context, final UIComponent component, final Object value) {
        if (value != null && value instanceof GrauInstrucao) {
            final GrauInstrucao grauInstrucao = (GrauInstrucao) value;
            return grauInstrucao.toString();
        }
        return "";
    }
}
