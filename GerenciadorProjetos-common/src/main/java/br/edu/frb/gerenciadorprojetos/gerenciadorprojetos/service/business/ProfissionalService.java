package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author antoniojunior87
 */
@Remote
public interface ProfissionalService {

    List<Profissional> listar();

    void salvar(Profissional profissional);
}
