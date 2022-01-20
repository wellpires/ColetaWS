package br.com.everis.coletaws.amostradoreslojasunidades.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.amostradoreslojasunidades.dao.IAmostradoresLojasUnidadesDAO;
import br.com.everis.coletaws.amostradoreslojasunidades.model.AmostradoresLojasUnidades;
import br.com.everis.coletaws.amostradoreslojasunidades.service.IAmostradoresLojasUnidadesService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class AmostradoresLojasUnidadesServiceImpl implements IAmostradoresLojasUnidadesService{

	@Autowired
    private IAmostradoresLojasUnidadesDAO amostradoresLojasUnidadesDAO = null;
    
    @Override
    public List<AmostradoresLojasUnidades> buscarAmostradoresLojasUnidades() {
        return amostradoresLojasUnidadesDAO.buscarAmostradoresLojasUnidades();
    }
    
}
