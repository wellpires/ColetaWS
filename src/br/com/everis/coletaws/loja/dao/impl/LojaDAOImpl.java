package br.com.everis.coletaws.loja.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.loja.dao.ILojaDAO;
import br.com.everis.coletaws.loja.model.Loja;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public class LojaDAOImpl extends JpaDao<Integer, Loja> implements ILojaDAO {

    @Override
    public List<Loja> buscarLojas() throws Exception {
        try {
        	TypedQuery<Loja> lojaQuery = entityManager.createQuery("FROM " + entityClass.getName(), Loja.class);
        	lojaQuery.setHint("org.hibernate.cacheable", "true");
            return lojaQuery.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
