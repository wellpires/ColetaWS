package br.com.everis.coletaws.lojaprodutoatividade.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.lojaprodutoatividade.dao.ILojaProdutoAtividadePKDAO;
import br.com.everis.coletaws.lojaprodutoatividade.model.LojaProdutosAtividade;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Repository
@Transactional
public class LojaProdutoAtividadePKDAOImpl extends JpaDao<Integer, LojaProdutosAtividade>
		implements ILojaProdutoAtividadePKDAO {

	@Override
	public List<LojaProdutosAtividade> buscarLojaProdutoAtividade() throws Exception {
		try {
			TypedQuery<LojaProdutosAtividade> lojaProdutosAtividadeQuery = entityManager
					.createQuery("SELECT new LojaProdutosAtividade(LPA.lojaProdutoAtividadePK.loja.idLoja,"
							+ "LPA.lojaProdutoAtividadePK.produto.idProduto,"
							+ "LPA.lojaProdutoAtividadePK.atividade.idAtividade) FROM " + entityClass.getName()
							+ " LPA", LojaProdutosAtividade.class);
			lojaProdutosAtividadeQuery.setHint("org.hibernate.cacheable", "true");
			return lojaProdutosAtividadeQuery.getResultList();
		} finally {
			entityManager.close();
		}
	}
}
