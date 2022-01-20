package br.com.everis.coletaws.amostrador.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.amostrador.dao.IAmostradorDAO;
import br.com.everis.coletaws.amostrador.model.Amostrador;
import br.com.everis.coletaws.amostrador.services.IAmostradorService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class AmostradorServiceImpl implements IAmostradorService {
    
	@Autowired
    private IAmostradorDAO amostradorDAO = null;
    
    @Override
    public List<Amostrador> buscarAmostradores() throws Exception {
        return amostradorDAO.buscarAmostradores();
    }
}
