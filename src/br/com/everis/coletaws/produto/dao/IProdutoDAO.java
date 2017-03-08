package br.com.everis.coletaws.produto.dao;

import br.com.everis.coletaws.dao.Dao;
import br.com.everis.coletaws.produto.model.Produto;
import java.util.List;

/**
 *
 * @author Wellington Gon�alves Pires
 */
public interface IProdutoDAO extends Dao<Integer, Produto> {
    
    public List<Produto> buscarProdutos() throws Exception;
    
}
