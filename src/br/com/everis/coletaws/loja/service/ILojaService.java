package br.com.everis.coletaws.loja.service;

import br.com.everis.coletaws.loja.model.Loja;
import java.util.List;

/**
 *
 * @author Wellington Gon�alves Pires
 */
public interface ILojaService {
    
    public List<Loja> buscarLojas() throws Exception;
    
}
