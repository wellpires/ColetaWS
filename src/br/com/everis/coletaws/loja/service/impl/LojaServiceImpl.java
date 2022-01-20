package br.com.everis.coletaws.loja.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.loja.dao.ILojaDAO;
import br.com.everis.coletaws.loja.model.Loja;
import br.com.everis.coletaws.loja.service.ILojaService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class LojaServiceImpl implements ILojaService {

	@Autowired
    private ILojaDAO lojaDAO = null;

    @Override
    public List<Loja> buscarLojas() throws Exception {
        return lojaDAO.buscarLojas();
    }

}
