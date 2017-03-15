package br.com.everis.coletaws.loja.dao;

import java.util.List;

import br.com.everis.coletaws.dao.Dao;
import br.com.everis.coletaws.loja.model.Loja;


/**
 *
 * @author Wellington Gon�alves Pires
 */
public interface ILojaDAO extends Dao<Integer, Loja> {
    
    public List<Loja> buscarLojas() throws Exception;
    
}
