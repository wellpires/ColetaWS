package br.com.everis.coletaws.produto.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@Entity
@Table(name = "produtos")
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    public Produto() {
    }

    public Produto(Long idProduto, String nomeProduto) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Long idProduto = null;

    @Column(name = "produto", nullable = false, length = 60)
    private String nomeProduto = null;

    
    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.idProduto);
        hash = 17 * hash + Objects.hashCode(this.nomeProduto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.nomeProduto, other.nomeProduto)) {
            return false;
        }
        if (!Objects.equals(this.idProduto, other.idProduto)) {
            return false;
        }
        return true;
    }
}
