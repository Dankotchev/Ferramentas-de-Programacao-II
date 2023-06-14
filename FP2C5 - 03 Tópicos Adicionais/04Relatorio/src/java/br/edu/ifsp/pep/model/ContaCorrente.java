package br.edu.ifsp.pep.model;

import java.util.Objects;

public class ContaCorrente {
    
    private Integer numero;
    private Double saldo;
    
    //
    public ContaCorrente() {
    }

    public ContaCorrente(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final ContaCorrente other = (ContaCorrente) obj;
        return Objects.equals(this.numero, other.numero);
    }
}
