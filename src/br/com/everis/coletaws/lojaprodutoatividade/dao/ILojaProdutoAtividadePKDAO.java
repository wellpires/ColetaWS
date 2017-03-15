package br.com.everis.coletaws.lojaprodutoatividade.dao;

import br.com.everis.coletaws.dao.Dao;
import br.com.everis.coletaws.lojaprodutoatividade.model.LojaProdutosAtividade;
import java.util.List;

/**
 *
 * @author Wellington Gon�alves Pires
 */
public interface ILojaProdutoAtividadePKDAO extends Dao<Integer, LojaProdutosAtividade>{
    
    public List<LojaProdutosAtividade> buscarLojaProdutoAtividade() throws Exception;
    
}
