package br.com.everis.coletaws.coletaAmostra.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.coletaAmostra.dao.IColetaAmostraDAO;
import br.com.everis.coletaws.coletaAmostra.model.ColetaAmostra;
import br.com.everis.coletaws.coletaAmostra.service.IColetaAmostraService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class ColetaAmostraServiceImpl implements IColetaAmostraService{

	@Autowired
    private IColetaAmostraDAO coletaAmostraDAO = null;
    
    @Override
    public void gravarColeta(ColetaAmostra coletaAmostra) {
        coletaAmostraDAO.persist(coletaAmostra);
    }
    
}
