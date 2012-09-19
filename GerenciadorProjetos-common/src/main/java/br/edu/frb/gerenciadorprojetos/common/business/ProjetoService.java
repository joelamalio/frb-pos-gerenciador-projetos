package br.edu.frb.gerenciadorprojetos.common.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author brunomsc
 */
@Remote
public interface ProjetoService extends Serializable {

    List<Projeto> listar();

    void salvar(Projeto projeto);
}
