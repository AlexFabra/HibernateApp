import entity.FamiliaEntity;
import entity.PlantasEntity;
import javax.persistence.*;
import java.util.List;

public class updatePlanta {
    public static void main(String[] args) {
        //Creació dels objectes per iniciar les transaccion
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció

        try {
            transaction.begin(); //Iniciem transacció

            try {
                int id = 21;
                String nombre = "Hola";
                String especie = "";
                String localizacion = "";
                //Todo: no fa l'update
                //Update
                Query q = entityManager.createNativeQuery("UPDATE plantas SET nombre = :nombre ,especie = :especie, localizacion = :localizacion   WHERE id = :id", PlantasEntity.class)
                        .setParameter("id", id).setParameter("nombre", nombre).setParameter("especie", especie).setParameter("localizacion", localizacion);
                q.executeUpdate();

                System.out.println("El registre s'ha modificat correcatment.");

                //Select i l'impressió del resultat
                List <PlantasEntity> result = entityManager.createNativeQuery("SELECT * FROM plantas WHERE id = :id",PlantasEntity.class)
                        .setParameter("id",id).getResultList();
                System.out.println("Resultat: " + result);

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
