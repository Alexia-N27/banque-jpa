package fr.banque.bo.entite;

import jakarta.persistence.*;

@Entity
@Table(name = "LivretA")
public class LivretA extends Compte {

    @Column(name = "taux")
    private Double taux;

    public LivretA() {
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
