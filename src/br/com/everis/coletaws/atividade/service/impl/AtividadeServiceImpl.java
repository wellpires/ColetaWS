package br.com.everis.coletaws.atividade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.atividade.dao.IAtividadeDAO;
import br.com.everis.coletaws.atividade.model.Atividade;
import br.com.everis.coletaws.atividade.service.IAtividadeService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class AtividadeServiceImpl implements IAtividadeService{

	@Autowired
    private IAtividadeDAO atividadeDAO = null;
    
    @Override
    public List<Atividade> buscarAtividades() throws Exception {
        return atividadeDAO.buscarAtividades();
    }
}
