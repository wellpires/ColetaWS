package br.com.everis.coletaws.amostradoreslojasunidades.dao.impl;

import br.com.everis.coletaws.amostradoreslojasunidades.dao.IAmostradoresLojasUnidadesDAO;
import br.com.everis.coletaws.amostradoreslojasunidades.model.AmostradoresLojasUnidades;
import br.com.everis.coletaws.dao.JpaDao;
import java.util.List;

import javax.persistence.TypedQuery;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public class AmostradoresLojasUnidadesDAOImpl extends JpaDao<Integer, AmostradoresLojasUnidades> implements IAmostradoresLojasUnidadesDAO{

    @Override
    public List<AmostradoresLojasUnidades> buscarAmostradoresLojasUnidades() {
        try{
        	TypedQuery<AmostradoresLojasUnidades> amostradoresLojasUnidadesQuery = entityManager.createQuery("FROM " + entityClass.getName(), AmostradoresLojasUnidades.class);
            return amostradoresLojasUnidadesQuery.getResultList();
        }finally{
            entityManager.close();
        }
    }
}
