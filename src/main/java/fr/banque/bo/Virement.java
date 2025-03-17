package fr.banque.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "Virement")
public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiaire")
    private String beneficiaire;

    public Virement() {
    }

    public String getBeneficiaire() {
        return beneficiaire;
    }

    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
}
