package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao;

import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import org.apache.derby.jdbc.ClientDriver;

/**
 * @author antoniojunior87
 */
@Singleton
public class GenericDao {

    @PersistenceUnit(name = "gerenciador_projetos_pu")
    private EntityManagerFactory session;

    @PostConstruct
    public void init() {
        try {
            DriverManager.registerDriver(new ClientDriver());
        } catch (SQLException ex) {
            Logger.getLogger(GenericDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void salvar(Object objeto) {
        getSession().persist(objeto);
        getSession().flush();
    }

    public void salvarEmLote(List<Object> pLista) {
        for (Object item : pLista) {
            getSession().persist(item);
        }
        getSession().flush();
    }

    public <T> T carregarLoad(Class<T> clazz, Serializable id) {
        return (T) getSession().find(clazz, id);
    }

    public List listarTodos(Class<?> clazz) {
        CriteriaQuery query = getSession().getCriteriaBuilder().createQuery(clazz);
        query.select(query.from(clazz));
        return getSession().createQuery(query).getResultList();
    }

    public void remover(Object objeto) {
        objeto = getSession().merge(objeto);
        getSession().remove(objeto);
    }

    public List<Object> buscarPorNamedQuery(String namedQuery) {
        return buscarPorNamedQuery(namedQuery, null);
    }

    public List<Object> buscarPorNamedQuery(String namedQuery, Map<String, Object> parametros) {
        if (parametros == null) {
            return getSession().createQuery(namedQuery).getResultList();
        } else {
            Query query = createQuery(namedQuery, parametros);
            try {
                List<Object> result = query.getResultList();
                return result;
            } catch (NoResultException nre) {
                return null;
            }
        }
    }

    public void executarNamedQuery(String namedQuery, Map<String, Object> parametros) {
        if (parametros == null) {
            getSession().createQuery(namedQuery);
        } else {
            Query query = createQuery(namedQuery, parametros);
            query.executeUpdate();
        }
    }

    public List<Object> buscarPorNativeQuery(String sql) {
        return getSession().createNativeQuery(sql).getResultList();
    }

    public Object buscarEntidadePorNamedQuery(String namedQuery, Map<String, Object> parametros) {
        Query query = createQuery(namedQuery, parametros);
        try {
            Object result = query.getSingleResult();
            return result;
        } catch (NoResultException nre) {
            return null;
        }
    }

    private Query createQuery(String namedQuery, Map<String, Object> parametros) {
        Iterator<String> it = parametros.keySet().iterator();
        Query query = getSession().createNamedQuery(namedQuery);
        while (it.hasNext()) {
            String parametroIdentifier = it.next();
            query.setParameter(parametroIdentifier, parametros.get(parametroIdentifier));
        }
        return query;
    }

    private EntityManager getSession() {
        return session.createEntityManager();
    }
}