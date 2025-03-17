package fr.banque.bo;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "AssuranceVie")
public class AssuranceVie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localDate")
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
