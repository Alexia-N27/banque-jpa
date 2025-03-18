package fr.banque.bo.entite;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue(value = "Virement")
public class Virement extends Operation {

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
