package fr.banque;

import fr.banque.bo.entite.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            insertCompteWithTwoClients(em, transaction);
            Client clientWithMultipleComptes = insertClientWithMultipleComptes(em, transaction);
            insertVirementOperation(em, transaction, clientWithMultipleComptes.getComptes().iterator().next().getId());
            insertGeneralOperation(em, transaction, clientWithMultipleComptes.getComptes().iterator().next().getId());
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

    private static void insertCompteWithTwoClients(EntityManager em, EntityTransaction transaction) {
        transaction.begin();

        // Création des clients
        Client client1 = new Client();
        Client client2 = new Client();

        // Création du compte courant
        Courant compte = new Courant();
        compte.setNumero("C12345");
        compte.setSolde(1000.0);
        compte.setDecouvert(500.0);

        // Associer les clients au compte
        client1.setComptes(Set.of(compte));
        client2.setComptes(Set.of(compte));

        em.persist(client1);
        em.persist(client2);
        em.persist(compte);

        transaction.commit();
    }

    private static Client insertClientWithMultipleComptes(EntityManager em, EntityTransaction transaction) {
        transaction.begin();

        // Création du client
        Client client = new Client();

        // Création des comptes
        AssuranceVie assuranceVie = new AssuranceVie();
        assuranceVie.setNumero("AV56789");
        assuranceVie.setSolde(5000.0);
        assuranceVie.setTaux(2.0);
        assuranceVie.setDateFin(LocalDate.of(2030, 12, 31));

        LivretA livretA = new LivretA();
        livretA.setNumero("LA67890");
        livretA.setSolde(3000.0);
        livretA.setTaux(1.5);

        // Associer les comptes au client
        client.setComptes(Set.of(assuranceVie, livretA));

        em.persist(client);
        em.persist(assuranceVie);
        em.persist(livretA);

        transaction.commit();

        return client;
    }

    private static void insertVirementOperation(EntityManager em, EntityTransaction transaction, Integer compteId) {
        transaction.begin();

        // Récupérer le compte
        Compte compte = em.find(Compte.class, compteId);

        // Création du virement
        Virement virement = new Virement();
        virement.setMontant(200.0);
        virement.setMotif("Remboursement");
        virement.setLocalDateTime(LocalDateTime.now());
        virement.setBeneficiaire("Jean Dupont");

        em.persist(virement);
        transaction.commit();
    }

    private static void insertGeneralOperation(EntityManager em, EntityTransaction transaction, Integer compteId) {
        transaction.begin();

        // Récupérer le compte
        Compte compte = em.find(Compte.class, compteId);

        // Création de l'opération
        Operation operation = new Operation();
        operation.setMontant(100.0);
        operation.setMotif("Achat en ligne");
        operation.setLocalDateTime(LocalDateTime.now());

        em.persist(operation);
        transaction.commit();
    }

}





