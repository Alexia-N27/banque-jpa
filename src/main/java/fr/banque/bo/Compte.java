package fr.banque.bo;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name= "Compte")
public class Compte {
    @Column(name = "id")
    protected Integer id;
    @Column(name = "numero")
    protected String numero;
    @Column(name = "solde")
    protected Double solde;

    @ManyToMany(mappedBy = "comptes")
    private Set<Client>clients;

    @ManyToOne
    @JoinColumn(name="OPE_ID")
    private Operation operation ;

    public Compte() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}

