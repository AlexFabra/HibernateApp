import entity.FamiliaEntity;
import entity.PlantasEntity;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;
import javax.swing.*;

public class App extends JFrame{

    public static void main(String[] args) {

        //entityFactory i entityManager inicia la transacció i després neteja els recursos
        EntityManagerFactory entiyEntityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entiyEntityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Frame fr = new Frame();
                fr.setVisible(true);
            }
        });

//        //Conectem amb el frame que hem creat i el mostrem en el monitor quan s'executi, donant-li un tamany i fent-lo visible.
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                JFrame frame = new MainFrame();
//                frame.setSize(600,600);
//                frame.setVisible(true);
//            }
//        });

        try {
//            transaction.begin();
//            PlantasEntity menta = new PlantasEntity();
//            PlantasEntity albahaca = new PlantasEntity();
//            // romero.setId(1);
//            menta.setNombre("menta");
//            menta.setEspecie("mentae");
//            menta.setLocalizacion("mediterráneo");
//            entityManager.persist(menta);
//            transaction.commit();
//
//            albahaca.setNombre("Albahaca");
//            albahaca.setEspecie("Albahacae");
//            albahaca.setLocalizacion("Mi casa");
//            entityManager.persist(albahaca);
//            transaction.commit();

            TypedQuery<PlantasEntity> query = entityManager.createNamedQuery("selectlocalizacion",PlantasEntity.class);
            query.setParameter("localizacion", "mediterráneo");
//            PlantasEntity result = query.getSingleResult();
//            System.out.printf(String.valueOf(result));
            for (PlantasEntity plantasEntity : query.getResultList()) {
                System.out.println(plantasEntity);
            }

        } finally {
            if (transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            entiyEntityManagerFactory.close();
        }
    }
}