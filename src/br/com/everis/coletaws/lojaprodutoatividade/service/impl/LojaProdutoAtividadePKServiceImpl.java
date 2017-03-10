package br.com.everis.coletaws.lojaprodutoatividade.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.lojaprodutoatividade.dao.ILojaProdutoAtividadePKDAO;
import br.com.everis.coletaws.lojaprodutoatividade.model.LojaProdutosAtividade;
import br.com.everis.coletaws.lojaprodutoatividade.service.ILojaProdutoAtividadePKService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class LojaProdutoAtividadePKServiceImpl implements ILojaProdutoAtividadePKService{

	@Autowired
    private ILojaProdutoAtividadePKDAO lojaProdutoAtividadePKDAO = null;
    
    @Override
    public List<LojaProdutosAtividade> buscarLojaProdutoAtividade() throws Exception {
        return lojaProdutoAtividadePKDAO.buscarLojaProdutoAtividade();
    }
    
}
