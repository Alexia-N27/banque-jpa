package fr.banque.bo.entite;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Type")
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    protected Integer id;
    @Column(name= "montant")
    protected Double montant;
    @Column(name = "motif")
    protected String motif;
    @Column(name = "localDateTime")
    protected LocalDateTime localDateTime;

    @ManyToOne
    @JoinColumn(name = "COMPTE_ID")
    protected Compte compte;

    public Operation() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Compte getCompte() {
        return this.compte;
    }

    public void setComptes(Compte compte) {
        this.compte = compte;
    }
}
