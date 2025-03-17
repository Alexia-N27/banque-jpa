package fr.banque.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "Courant")
public class Courant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
