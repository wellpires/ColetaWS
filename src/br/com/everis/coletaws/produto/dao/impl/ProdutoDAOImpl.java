package br.com.everis.coletaws.produto.dao.impl;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.produto.dao.IProdutoDAO;
import br.com.everis.coletaws.produto.model.Produto;
import java.util.List;

import javax.persistence.TypedQuery;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public class ProdutoDAOImpl extends JpaDao<Integer, Produto> implements IProdutoDAO {

    @Override
    public List<Produto> buscarProdutos() throws Exception {
        try {
            TypedQuery<Produto> queryProduto = entityManager.createQuery("FROM " + entityClass.getName(), Produto.class);
            return queryProduto.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
