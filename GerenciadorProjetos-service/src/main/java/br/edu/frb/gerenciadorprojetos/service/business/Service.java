package br.edu.frb.gerenciadorprojetos.service.business;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author alunoruy
 */
@Stateful
public class Service {

    @PersistenceContext(name = "")
    private EntityManager em;

    public EntityManager getDao() {
        return em;
    }
}
