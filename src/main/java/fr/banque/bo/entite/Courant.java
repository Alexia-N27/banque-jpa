package fr.banque.bo.entite;

import jakarta.persistence.*;

@Entity
@Table(name = "Courant")
public class Courant extends Compte {

    @Column(name = "decouvert")
    private Double decouvert;

    public Courant() {
    }

    public Double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(Double decouvert) {
        this.decouvert = decouvert;
    }


}
