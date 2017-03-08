package br.com.everis.coletaws.amostrador.dao;

import br.com.everis.coletaws.amostrador.model.Amostrador;
import br.com.everis.coletaws.dao.Dao;
import java.util.List;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public interface IAmostradorDAO extends Dao<Integer, Amostrador>{
    
    public List<Amostrador> buscarAmostradores() throws Exception;
    
}
