package fr.banque.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "LivretA")
public class LivretA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
