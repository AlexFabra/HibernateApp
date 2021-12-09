import entity.FamiliaEntity;
import entity.PlantasEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class insertPlanta {
    public static void main(String[] args) {

        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció

        try {
            transaction.begin(); //Iniciem transacció
            PlantasEntity p = new PlantasEntity("Geranio", "Geranium", "Asia");
            FamiliaEntity f = new FamiliaEntity("Geranium");

            p.setFamilia_id(f); //Fem la relació

            entityManager.persist(p);
            transaction.commit();

            System.out.println("Fet");

        } finally {
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
    }
}
