package br.com.everis.coletaws.unidade.service;

import br.com.everis.coletaws.unidade.model.Unidade;
import java.util.List;

/**
 *
 * @author Wellington Gon�alves Pires
 */
public interface IUnidadeService {
    
    public List<Unidade> buscarUnidades() throws Exception;
    
}
