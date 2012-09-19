package br.edu.frb.gerenciadorprojetos.common.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author antoniojunior87
 */
@Remote
public interface ProfissionalService extends Serializable {

    List<Profissional> listar();

    void salvar(Profissional profissional);
}
