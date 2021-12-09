import entity.PlantasEntity;

import javax.persistence.*;
import java.util.List;

public class deletePlanta {
    public static void main(String[] args) {
        //Creació dels objectes per iniciar les transaccion
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció

        try {
            transaction.begin(); //Iniciem transacció

            try {
                int id = 21;

                //Update
                Query q = entityManager.createNativeQuery("DELETE FROM plantas WHERE id = :id", PlantasEntity.class)
                        .setParameter("id", id);
                q.executeUpdate();
                System.out.println("El registre s'ha eliminat correcatment.");

            } catch (Exception e) {
                System.out.println(e);
            }


            transaction.commit();


        } finally {
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
    }
}
