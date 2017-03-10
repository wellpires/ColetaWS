package br.com.everis.coletaws.funcionario.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.coletaws.funcionario.dao.IFuncionarioDAO;
import br.com.everis.coletaws.funcionario.model.Funcionario;
import br.com.everis.coletaws.funcionario.services.IFuncionarioService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Service
public class FuncionarioServiceImpl implements IFuncionarioService{

	@Autowired
    private IFuncionarioDAO funcionarioDAO = null;

    @Override
    public List<Funcionario> buscarFuncionarios() {
        return funcionarioDAO.buscarFuncionarios();
    }
    
}
