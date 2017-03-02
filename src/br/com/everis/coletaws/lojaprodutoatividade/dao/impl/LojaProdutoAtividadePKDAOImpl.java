package br.com.everis.coletaws.lojaprodutoatividade.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.lojaprodutoatividade.dao.ILojaProdutoAtividadePKDAO;
import br.com.everis.coletaws.lojaprodutoatividade.model.LojaProdutosAtividade;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public class LojaProdutoAtividadePKDAOImpl extends JpaDao<Integer, LojaProdutosAtividade>
		implements ILojaProdutoAtividadePKDAO {

	@Override
	public List<LojaProdutosAtividade> buscarLojaProdutoAtividade() throws Exception {
		try {
			TypedQuery<LojaProdutosAtividade> lojaProdutosAtividadeQuery = entityManager.createQuery(
					"FROM " + entityClass.getName() + " AS LPA JOIN FETCH LPA.lojaProdutoAtividadePK.loja"
							+ " JOIN FETCH LPA.lojaProdutoAtividadePK.produto"
							+ " JOIN FETCH LPA.lojaProdutoAtividadePK.atividade", LojaProdutosAtividade.class);
			return lojaProdutosAtividadeQuery.getResultList();
		} finally {
			entityManager.close();
		}
	}
}
