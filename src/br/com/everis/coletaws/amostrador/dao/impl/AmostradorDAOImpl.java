package br.com.everis.coletaws.amostrador.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.everis.coletaws.amostrador.dao.IAmostradorDAO;
import br.com.everis.coletaws.amostrador.model.Amostrador;
import br.com.everis.coletaws.dao.JpaDao;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public class AmostradorDAOImpl extends JpaDao<Integer, Amostrador> implements IAmostradorDAO {

    @Override
    public List<Amostrador> buscarAmostradores() throws Exception {
        try {
        	TypedQuery<Amostrador> amostradorQuery = entityManager.createQuery("FROM " + entityClass.getName(), Amostrador.class);
        	amostradorQuery.setHint("org.hibernate.cacheable", "true");
            return amostradorQuery.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
