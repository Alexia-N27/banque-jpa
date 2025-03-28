package fr.banque.bo.entite;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "Client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    @Column(name = "montant")
    protected Double montant;
    @Column(name = "motif")
    protected String motif;
    @Column(name = "LocalDateTime")
    protected LocalDateTime LocalDateTime;

    @OneToOne
    protected Adresse adresse;

    @ManyToOne
    @JoinColumn(name="BANQUE_ID")
    private Banque banque;

    @ManyToMany
    @JoinTable(name="CLI_COM",
            joinColumns = @JoinColumn(name="ID_CLI", referencedColumnName="id"),
            inverseJoinColumns= @JoinColumn(name="ID_COM", referencedColumnName="id")
    )
    private Set<Compte> comptes;

    public Client() {
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public LocalDateTime getLocalDateTime() {
        return LocalDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        LocalDateTime = localDateTime;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public Banque getBanque() {
        return banque;
    }

    public void setBanque(Banque banque) {
        this.banque = banque;
    }

    public Set<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(Set<Compte> comptes) {
        this.comptes = comptes;
    }
}
