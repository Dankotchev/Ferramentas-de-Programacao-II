package br.edu.ifsp.pep.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "tarefa")
@NamedQueries({
    @NamedQuery(name = "Tarefa.findAll",
            query = "SELECT t FROM Tarefa t") })
public class Tarefa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;

    @Basic(optional = false)
    @Column(name = "data_cadastro")
    @Temporal(TemporalType.DATE)
    private Date dataCadastro;

    @Column(name = "data_modificacao")
    @Temporal(TemporalType.DATE)
    private Date dataModificacao;

    @Basic(optional = false)
    @Column(name = "status")
    private String status;

    public Tarefa() {
    }

    public Tarefa(Integer id) {
        this.id = id;
    }

    public Tarefa(Integer id, String descricao, Date dataCadastro, String status) {
        this.id = id;
        this.descricao = descricao;
        this.dataCadastro = dataCadastro;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(Date dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tarefa))
            return false;
        Tarefa other = (Tarefa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "br.edu.ifsp.pep.model.Tarefa[ id=" + id + " ]";
    }

}
