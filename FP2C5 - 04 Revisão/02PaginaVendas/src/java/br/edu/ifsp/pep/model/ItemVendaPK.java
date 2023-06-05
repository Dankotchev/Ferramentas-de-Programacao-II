package br.edu.ifsp.pep.model;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ItemVendaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "produto_id", nullable = false)
    private int produtoId;
    
    @Basic(optional = false)
    @Column(name = "venda_id", nullable = false)
    private int vendaId;

    public ItemVendaPK() {
    }

    public ItemVendaPK(int produtoId, int vendaId) {
        this.produtoId = produtoId;
        this.vendaId = vendaId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getVendaId() {
        return vendaId;
    }

    public void setVendaId(int vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoId;
        hash += (int) vendaId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVendaPK))
            return false;
        ItemVendaPK other = (ItemVendaPK) object;
        if (this.produtoId != other.produtoId)
            return false;
        if (this.vendaId != other.vendaId)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "crud.model.ItemVendaPK[ produtoId=" + produtoId + ", vendaId=" + vendaId + " ]";
    }

}
