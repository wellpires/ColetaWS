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
 
    private LojaProdutoAtividadePK lojaProdutoAtividadePK = new LojaProdutoAtividadePK();
    private Long idLoja = null;
    private Long idProduto = null;
    private Long idAtividade = null;
    
    public LojaProdutosAtividade(){
        
    }
    public LojaProdutosAtividade(Long idLoja, Long idProduto, Long idAtividade){
    	this.idLoja = idLoja;
    	this.idProduto = idProduto;
    	this.idAtividade = idAtividade;
    }

    @EmbeddedId
    public LojaProdutoAtividadePK getLojaProdutoAtividadePK() {
        return lojaProdutoAtividadePK;
    }

    public void setLojaProdutoAtividadePK(LojaProdutoAtividadePK lojaProdutoAtividadePK) {
        this.lojaProdutoAtividadePK = lojaProdutoAtividadePK;
    }
	public Long getIdLoja() {
		return idLoja;
	}
	public void setIdLoja(Long idLoja) {
		this.idLoja = idLoja;
	}
	public Long getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}
	public Long getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(Long idAtividade) {
		this.idAtividade = idAtividade;
	}
    
}
