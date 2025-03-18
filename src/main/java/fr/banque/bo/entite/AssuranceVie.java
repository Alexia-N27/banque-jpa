package fr.banque.bo.entite;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AssuranceVie")
public class AssuranceVie extends Compte {

    @Column(name = "dateFin")
    private LocalDate dateFin;
    @Column(name = "taux")
    private Double taux;

    public AssuranceVie() {
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
