import entity.FamiliaEntity;
import entity.PlantasEntity;

import javax.persistence.*;
import java.util.List;

public class Crud {
    String tipusOp;
    String taula;
    String comanda;
    String condicions;
    public Crud(){}
    public Crud(String tipusOp,String taula, String comanda, String condicions){
        tipusOp=this.tipusOp;
        taula=this.taula;
        comanda=this.comanda;
        condicions=this.condicions;
    }

    public List delete(String taula, String condicions){
        //Creació dels objectes per iniciar les transaccion
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció
        String cmd="";
        String select="select * from "+ taula + ";";
        List<PlantasEntity> result = null;
        try {
            transaction.begin(); //Iniciem transacció
            try {
                cmd = "delete from " + taula + " where " + condicions;
                System.out.println(cmd);
                //Update
                Query q = entityManager.createNativeQuery(cmd, PlantasEntity.class);
                q.executeUpdate();
                System.out.println("El registre s'ha eliminat correctament.");

                //Select i l'impressió del resultat
                result = entityManager.createNativeQuery(select,PlantasEntity.class).getResultList();
                System.out.println("Resultat: " + result);

            } catch (Exception e) {
                System.out.println(e);
            }
            transaction.commit();
        } finally {
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
        return result;
    }
    public List update(String taula, String comanda, String condicions){
        //Creació dels objectes per iniciar les transaccion
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció
        String cmd="";
        String select="select * from "+ taula + ";";
        List<PlantasEntity> result = null;
        try {
            transaction.begin(); //Iniciem transacció
            try {
                cmd = "update " + taula + " set " + comanda + " where " + condicions;
                //Update
                Query q = entityManager.createNativeQuery(cmd, PlantasEntity.class);
                q.executeUpdate();

                System.out.println("El registre s'ha modificat correctament.");

                //Select i l'impressió del resultat
                result = entityManager.createNativeQuery(select,PlantasEntity.class).getResultList();
                System.out.println("Resultat: " + result);

            } catch (Exception e) {
                System.out.println(e);
            }
            transaction.commit();
        } finally {
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
        return result;
    }
    
    public List insert(String taula, String comanda, String condicions){
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció
        List<PlantasEntity> result = null;
        try {

        } finally {
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
        return result;
    }
    
    public List select(String taula, String comanda, String condicions){
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction(); //Objecte d'inici de transacció
        String cmd="select "+comanda+" from "+taula+ " where "+condicions;
        List<PlantasEntity> result = null;
        try {
            transaction.begin(); //Iniciem transacció
            result = entityManager.createNativeQuery(cmd, PlantasEntity.class).getResultList();
            transaction.commit();
        } finally {
            //Neteja de recursos
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
        return result;
    }
}