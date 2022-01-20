package br.com.everis.coletaws.atividade.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.coletaws.atividade.dao.IAtividadeDAO;
import br.com.everis.coletaws.atividade.model.Atividade;
import br.com.everis.coletaws.dao.JpaDao;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Repository
@Transactional
public class AtividadeDAOImpl extends JpaDao<Integer, Atividade> implements IAtividadeDAO {

    @Override
    public List<Atividade> buscarAtividades() throws Exception {
        try {
            TypedQuery<Atividade> atividadeQuery = entityManager.createQuery("FROM " + entityClass.getName(), Atividade.class);
            atividadeQuery.setHint("org.hibernate.cacheable", "true");
            return atividadeQuery.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
