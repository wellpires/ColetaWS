package br.com.everis.coletaws.lojaprodutoatividade.model;

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
@Table(name = "lojas_produtos_atividades")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@AssociationOverrides({
    @AssociationOverride(name = "lojaProdutoAtividadePK.loja", joinColumns = @JoinColumn(name ="id_loja")),
    @AssociationOverride(name = "lojaProdutoAtividadePK.produto", joinColumns = @JoinColumn(name ="id_produto")),
    @AssociationOverride(name = "lojaProdutoAtividadePK.atividade", joinColumns = @JoinColumn(name ="id_atividade"))
})
public class LojaProdutosAtividade implements Serializable{
    private static final long serialVersionUID = 1L;
 
    public LojaProdutosAtividade(){
        
    }

    private LojaProdutoAtividadePK lojaProdutoAtividadePK = new LojaProdutoAtividadePK();

    @EmbeddedId
    public LojaProdutoAtividadePK getLojaProdutoAtividadePK() {
        return lojaProdutoAtividadePK;
    }

    public void setLojaProdutoAtividadePK(LojaProdutoAtividadePK lojaProdutoAtividadePK) {
        this.lojaProdutoAtividadePK = lojaProdutoAtividadePK;
    }
    
}
