package br.com.everis.coletaws.loja.service.impl;

import java.util.List;

import br.com.everis.coletaws.loja.dao.ILojaDAO;
import br.com.everis.coletaws.loja.dao.impl.LojaDAOImpl;
import br.com.everis.coletaws.loja.model.Loja;
import br.com.everis.coletaws.loja.service.ILojaService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
public class LojaServiceImpl implements ILojaService {

    private ILojaDAO lojaDAO = null;

    @Override
    public List<Loja> buscarLojas() throws Exception {
        lojaDAO = new LojaDAOImpl();
        return lojaDAO.buscarLojas();
    }

}
