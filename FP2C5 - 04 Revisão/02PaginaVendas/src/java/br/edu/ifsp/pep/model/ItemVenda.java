package br.edu.ifsp.pep.model;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "item_venda", catalog = "db_sistemavendas", schema = "")
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT i FROM ItemVenda i"),
    @NamedQuery(name = "ItemVenda.findByProdutoId",
            query = "SELECT i FROM ItemVenda i WHERE i.itemVendaPK.produtoId = :produtoId"),
    @NamedQuery(name = "ItemVenda.findByVendaId",
            query = "SELECT i FROM ItemVenda i WHERE i.itemVendaPK.vendaId = :vendaId"),
    @NamedQuery(name = "ItemVenda.findByQuantidade",
            query = "SELECT i FROM ItemVenda i WHERE i.quantidade = :quantidade"),
    @NamedQuery(name = "ItemVenda.findBySubtotal", query = "SELECT i FROM ItemVenda i WHERE i.subtotal = :subtotal") })
public class ItemVenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected ItemVendaPK itemVendaPK;
    @Basic(optional = false)
    @Column(nullable = false)
    private int quantidade;

    @Min(value = 0)
    @Basic(optional = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal subtotal;

    @JoinColumn(name = "produto_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    @JoinColumn(name = "venda_id", referencedColumnName = "id",
            nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(ItemVendaPK itemVendaPK) {
        this.itemVendaPK = itemVendaPK;
    }

    public ItemVenda(ItemVendaPK itemVendaPK, int quantidade, BigDecimal subtotal) {
        this.itemVendaPK = itemVendaPK;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
    }

    public ItemVenda(int produtoId, int vendaId) {
        this.itemVendaPK = new ItemVendaPK(produtoId, vendaId);
    }

    public ItemVendaPK getItemVendaPK() {
        return itemVendaPK;
    }

    public void setItemVendaPK(ItemVendaPK itemVendaPK) {
        this.itemVendaPK = itemVendaPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemVendaPK != null ? itemVendaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemVenda))
            return false;
        ItemVenda other = (ItemVenda) object;
        if ((this.itemVendaPK == null && other.itemVendaPK != null) || (this.itemVendaPK != null && !this.itemVendaPK.equals(
                other.itemVendaPK)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "crud.model.ItemVenda[ itemVendaPK=" + itemVendaPK + " ]";
    }

}
