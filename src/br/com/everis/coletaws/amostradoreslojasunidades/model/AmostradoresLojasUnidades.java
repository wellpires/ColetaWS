package br.com.everis.coletaws.amostradoreslojasunidades.model;

import java.io.Serializable;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Entity
@Table(name = "amostradores_lojas_unidades")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AssociationOverrides({
    @AssociationOverride(name = "amostradoresLojasUnidadesPK.amostrador", joinColumns = @JoinColumn(name ="id_amostrador")),
    @AssociationOverride(name = "amostradoresLojasUnidadesPK.loja", joinColumns = @JoinColumn(name ="id_loja")),
    @AssociationOverride(name = "amostradoresLojasUnidadesPK.unidade", joinColumns = @JoinColumn(name ="id_unidade"))
})
public class AmostradoresLojasUnidades implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private AmostradoresLojasUnidadesPK amostradoresLojasUnidadesPK = new AmostradoresLojasUnidadesPK();
    private Long idAmostrador = null;
    private Long idLoja = null;
    private Long idUnidade = null;

    public AmostradoresLojasUnidades(){
    	
    }
    
    public AmostradoresLojasUnidades(Long idAmostrador, Long idLoja, Long idUnidade) {
    	this.idAmostrador = idAmostrador;
    	this.idLoja = idLoja;
    	this.idUnidade = idUnidade;
	}
    
    @EmbeddedId
    public AmostradoresLojasUnidadesPK getAmostradoresLojasUnidadesPK() {
        return amostradoresLojasUnidadesPK;
    }

    public void setAmostradoresLojasUnidadesPK(AmostradoresLojasUnidadesPK amostradoresLojasUnidadesPK) {
        this.amostradoresLojasUnidadesPK = amostradoresLojasUnidadesPK;
    }

	public Long getIdAmostrador() {
		return idAmostrador;
	}

	public void setIdAmostrador(Long idAmostrador) {
		this.idAmostrador = idAmostrador;
	}

	public Long getIdLoja() {
		return idLoja;
	}

	public void setIdLoja(Long idLojas) {
		this.idLoja = idLojas;
	}

	public Long getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(Long idUnidades) {
		this.idUnidade = idUnidades;
	}
    
}
