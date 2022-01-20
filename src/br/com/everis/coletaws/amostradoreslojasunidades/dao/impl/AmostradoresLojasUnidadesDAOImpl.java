package br.com.everis.coletaws.amostradoreslojasunidades.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.coletaws.amostradoreslojasunidades.dao.IAmostradoresLojasUnidadesDAO;
import br.com.everis.coletaws.amostradoreslojasunidades.model.AmostradoresLojasUnidades;
import br.com.everis.coletaws.dao.JpaDao;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Repository
@Transactional
public class AmostradoresLojasUnidadesDAOImpl extends JpaDao<Integer, AmostradoresLojasUnidades> implements IAmostradoresLojasUnidadesDAO{

    @Override
    public List<AmostradoresLojasUnidades> buscarAmostradoresLojasUnidades() {
        try{
        	TypedQuery<AmostradoresLojasUnidades> amostradoresLojasUnidadesQuery = entityManager
    				.createQuery("SELECT new AmostradoresLojasUnidades(ALU.amostradoresLojasUnidadesPK.amostrador.idAmostrador,"
    						+ " ALU.amostradoresLojasUnidadesPK.loja.idLoja,"
    						+ " ALU.amostradoresLojasUnidadesPK.unidade.idUnidade) FROM "
    						+ entityClass.getName() + " ALU", AmostradoresLojasUnidades.class);
        	
        	amostradoresLojasUnidadesQuery.setHint("org.hibernate.cacheable", "true");
        	return amostradoresLojasUnidadesQuery.getResultList();
        }finally{
            entityManager.close();
        }
    }
}
