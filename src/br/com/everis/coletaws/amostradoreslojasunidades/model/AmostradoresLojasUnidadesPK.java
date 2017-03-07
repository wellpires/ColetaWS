package br.com.everis.coletaws.amostradoreslojasunidades.model;

import br.com.everis.coletaws.amostrador.model.Amostrador;
import br.com.everis.coletaws.loja.model.Loja;
import br.com.everis.coletaws.unidade.model.Unidade;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author Wellington Gon�alves Pires
 */
@Embeddable
public class AmostradoresLojasUnidadesPK implements Serializable {

    private static final long serialVersionUID = 1L;

    private Amostrador amostrador = null;

    private Loja loja = null;

    private Unidade unidade = null;

    @ManyToOne
    @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public Amostrador getAmostrador() {
        return amostrador;
    }

    public void setAmostrador(Amostrador amostrador) {
        this.amostrador = amostrador;
    }

    @ManyToOne
    @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    @ManyToOne
    @Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.amostrador);
        hash = 97 * hash + Objects.hashCode(this.loja);
        hash = 97 * hash + Objects.hashCode(this.unidade);
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
        final AmostradoresLojasUnidadesPK other = (AmostradoresLojasUnidadesPK) obj;
        if (!Objects.equals(this.amostrador, other.amostrador)) {
            return false;
        }
        if (!Objects.equals(this.loja, other.loja)) {
            return false;
        }
        if (!Objects.equals(this.unidade, other.unidade)) {
            return false;
        }
        return true;
    }
}
