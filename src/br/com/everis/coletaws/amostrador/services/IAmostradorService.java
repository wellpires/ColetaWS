package br.com.everis.coletaws.amostrador.services;

import br.com.everis.coletaws.amostrador.model.Amostrador;
import java.util.List;

/**
 *
 * @author Wellington Gon�alves Pires
 */
public interface IAmostradorService {
    
    public List<Amostrador> buscarAmostradores() throws Exception;
    
}
