package br.edu.frb.gerenciadorprojetos.common.business;

import br.edu.frb.gerenciadorprojetos.common.entity.Funcao;
import java.io.Serializable;
import java.util.List;
import javax.ejb.Remote;

/**
 * @author joelamalio
 */
@Remote
public interface FuncaoService extends Serializable {

    List<Funcao> listar();

    List<Funcao> listar(Funcao funcao);

    void salvar(Funcao funcao);
}