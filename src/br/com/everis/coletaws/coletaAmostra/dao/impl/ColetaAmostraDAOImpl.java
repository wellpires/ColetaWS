package br.com.everis.coletaws.coletaAmostra.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.coletaws.coletaAmostra.dao.IColetaAmostraDAO;
import br.com.everis.coletaws.coletaAmostra.model.ColetaAmostra;
import br.com.everis.coletaws.dao.JpaDao;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Repository
@Transactional
public class ColetaAmostraDAOImpl extends JpaDao<Integer, ColetaAmostra> implements IColetaAmostraDAO {

	@Override
	public void persist(ColetaAmostra entity) {
		try {
			entityManager.persist(entity);
		} finally {
			entityManager.close();
		}
	}
}
