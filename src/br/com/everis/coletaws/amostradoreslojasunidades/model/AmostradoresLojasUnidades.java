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
 * @author Wellington Gon�alves Pires
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

    @EmbeddedId
    public AmostradoresLojasUnidadesPK getAmostradoresLojasUnidadesPK() {
        return amostradoresLojasUnidadesPK;
    }

    public void setAmostradoresLojasUnidadesPK(AmostradoresLojasUnidadesPK amostradoresLojasUnidadesPK) {
        this.amostradoresLojasUnidadesPK = amostradoresLojasUnidadesPK;
    }
    
    
    
}
