package br.com.everis.coletaws.funcionario.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.coletaws.dao.JpaDao;
import br.com.everis.coletaws.funcionario.dao.IFuncionarioDAO;
import br.com.everis.coletaws.funcionario.model.Funcionario;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Repository
@Transactional
public class FuncionarioDAOImpl extends JpaDao<Integer, Funcionario> implements IFuncionarioDAO {

	@Override
	public List<Funcionario> buscarFuncionarios() {
		try {
			String strQuery = "SELECT new Funcionario(F.idFuncionario, F.nomeFuncionario,F.cargo, F.unidade.idUnidade) "
					+ "FROM " + entityClass.getName() + " F";
			TypedQuery<Funcionario> funcionarioQuery = entityManager.createQuery(strQuery, Funcionario.class);
			funcionarioQuery.setHint("org.hibernate.cacheable", "true");
			return funcionarioQuery.getResultList();
		} finally {
			entityManager.close();
		}
	}
}
