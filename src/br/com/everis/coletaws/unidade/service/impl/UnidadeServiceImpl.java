package br.com.everis.coletaws.unidade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.unidade.dao.IUnidadeDAO;
import br.com.everis.coletaws.unidade.model.Unidade;
import br.com.everis.coletaws.unidade.service.IUnidadeService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class UnidadeServiceImpl implements IUnidadeService {

	@Autowired
    private IUnidadeDAO unidadeDAO = null;

    @Override
    public List<Unidade> buscarUnidades() throws Exception {
        return unidadeDAO.buscarUnidades();
    }

}
