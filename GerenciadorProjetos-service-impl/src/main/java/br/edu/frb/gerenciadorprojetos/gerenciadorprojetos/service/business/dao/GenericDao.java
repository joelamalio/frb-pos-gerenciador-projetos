package br.edu.frb.gerenciadorprojetos.gerenciadorprojetos.service.business.dao;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 * @author antoniojunior87
 */
@Singleton
public class GenericDao {

    @PersistenceContext(name = "pu_gerenciador_projetos")
    private EntityManager entityManager;
    private Session session;

    public void salvar(Object objeto) {
        getSession().save(objeto);
        getSession().flush();
    }

    public void salvarOuAtualizar(Object objeto) {
        getSession().saveOrUpdate(objeto);
        getSession().flush();
    }

    public void salvarEmLote(List<Object> pLista) {
        for (Object item : pLista) {
            getSession().saveOrUpdate(item);
        }
        getSession().flush();
    }

    public <T> T carregarLoad(Class<T> clazz, Serializable id) {
        Session lSession = (Session) getEntityManager().getDelegate();
        return (T) lSession.load(clazz, id);
    }

    public <T> T carregarGet(Class<T> clazz, Serializable id) {
        Session lsession = (Session) getEntityManager().getDelegate();
        return (T) lsession.get(clazz, id);
    }

    public List listarTodos(Class<?> clazz) {
        Criteria criteria = getSession().createCriteria(clazz);
        return criteria.list();
    }

    public void remover(Object objeto) {
        objeto = entityManager.merge(objeto);
        getSession().delete(objeto);
    }

    public List<Object> buscarPorNamedQuery(String namedQuery) {
        return buscarPorNamedQuery(namedQuery, null);
    }

    public List<Object> buscarPorNamedQuery(String namedQuery, Map<String, Object> parametros) {
        if (parametros == null) {
            return getEntityManager().createNamedQuery(namedQuery).getResultList();
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
            getEntityManager().createNamedQuery(namedQuery);
        } else {
            Query query = createQuery(namedQuery, parametros);
            query.executeUpdate();
        }
    }

    public List<Object> buscarPorNativeQuery(String sql) {
        return entityManager.createNativeQuery(sql).getResultList();
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
        Query query = entityManager.createNamedQuery(namedQuery);
        while (it.hasNext()) {
            String parametroIdentifier = it.next();
            query.setParameter(parametroIdentifier, parametros.get(parametroIdentifier));
        }
        return query;
    }

    private Session getSession() {
        if (session == null || !session.isOpen()) {
            if (entityManager.getDelegate() instanceof org.hibernate.ejb.HibernateEntityManager) {
                session = ((org.hibernate.ejb.HibernateEntityManager) entityManager.getDelegate()).getSession();
            } else {
                session = (org.hibernate.Session) entityManager.getDelegate();
            }
        }
        return session;
    }

    private EntityManager getEntityManager() {
        return entityManager;
    }
}
