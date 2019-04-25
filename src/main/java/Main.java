import model.Game;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restapi");
        EntityManager em = emf.createEntityManager();

        Game game = new Game("jakis tytul", "FPS");
        game.setId(666L);

        em.getTransaction().begin();
        em.persist(game);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
