package br.edu.frb.gerenciadorprojetos.common.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author brunomsc
 * @joelamalio
 */
@Remote
public interface ProjetoService extends Serializable {

    List<Projeto> listar();
    
    List<Projeto> listar(Projeto projeto);
    
    Projeto obterPorId(Long id);

    void salvar(Projeto projeto);
}
