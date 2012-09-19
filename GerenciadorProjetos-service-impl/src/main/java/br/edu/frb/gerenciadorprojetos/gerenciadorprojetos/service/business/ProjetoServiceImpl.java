package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business;

import br.edu.frb.gerenciadorprojetos.common.business.ProfissionalService;
import br.edu.frb.gerenciadorprojetos.common.business.ProjetoService;
import br.edu.frb.gerenciadorprojetos.common.entity.Profissional;
import br.edu.frb.gerenciadorprojetos.common.entity.Projeto;
import br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao.GenericDao;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 * @author antoniojunior87
 */
@Stateless
public class ProjetoServiceImpl implements ProjetoService {

    @EJB
    GenericDao dao;

    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @Override
    public List<Projeto> listar() {
        return dao.listarTodos(Projeto.class);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public void salvar(Projeto projeto) {
        dao.salvar(projeto);
    }
}
