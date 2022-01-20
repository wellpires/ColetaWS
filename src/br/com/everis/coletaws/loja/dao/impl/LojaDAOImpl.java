package br.com.everis.coletaws.loja.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.loja.dao.ILojaDAO;
import br.com.everis.coletaws.loja.model.Loja;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Repository
@Transactional
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
