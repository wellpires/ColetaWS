package br.com.everis.coletaws.produto.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.produto.dao.IProdutoDAO;
import br.com.everis.coletaws.produto.model.Produto;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Repository
@Transactional
public class ProdutoDAOImpl extends JpaDao<Integer, Produto> implements IProdutoDAO {

    @Override
    public List<Produto> buscarProdutos() throws Exception {
        try {
            TypedQuery<Produto> produtoQuery = entityManager.createQuery("FROM " + entityClass.getName(), Produto.class);
            produtoQuery.setHint("org.hibernate.cacheable", "true");
            return produtoQuery.getResultList();
        } finally {
            entityManager.close();
        }
    }
}
