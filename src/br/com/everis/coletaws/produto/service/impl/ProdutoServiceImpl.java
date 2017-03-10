package br.com.everis.coletaws.produto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.produto.dao.IProdutoDAO;
import br.com.everis.coletaws.produto.model.Produto;
import br.com.everis.coletaws.produto.service.IProdutoService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class ProdutoServiceImpl implements IProdutoService {

	@Autowired
    private IProdutoDAO produtoDAO = null;

    @Override
    public List<Produto> buscarProdutos() throws Exception {
        return produtoDAO.buscarProdutos();
    }
}
