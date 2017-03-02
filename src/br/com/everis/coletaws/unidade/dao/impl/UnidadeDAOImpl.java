package br.com.everis.coletaws.unidade.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.unidade.dao.IUnidadeDAO;
import br.com.everis.coletaws.unidade.model.Unidade;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public class UnidadeDAOImpl extends JpaDao<Integer, Unidade> implements IUnidadeDAO {

	@Override
	public List<Unidade> buscarUnidades() throws Exception {
		try {
			TypedQuery<Unidade> unidadeQuery = entityManager.createQuery("SELECT new Unidade(U.idUnidade, U.nomeUnidade, U.loja.idLoja) FROM "
							+ entityClass.getName() + " U", Unidade.class);
			return unidadeQuery.getResultList();
		} finally {
			entityManager.close();
		}
	}
}
