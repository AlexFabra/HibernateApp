
import entity.FamiliaEntity;
import entity.PlantasEntity;

import javax.persistence.*;
import java.util.List;

public class selectPlanta {
    public static void main(String[] args) {
        //Creació dels objectes per iniciar les transaccion
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció

        try {
            transaction.begin(); //Iniciem transacció


            List<PlantasEntity> result = entityManager.createNativeQuery("SELECT * FROM plantas WHERE id = 20;", PlantasEntity.class).getResultList();
            System.out.println(result);

            transaction.commit();
        } finally {
            //Neteja de recursos
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
    }
}
