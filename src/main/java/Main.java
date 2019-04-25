import model.Game;
import model.Webpage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("restapi");
        EntityManager em = emf.createEntityManager();

        Game game = new Game();
        Webpage doomWebpage = new Webpage();

        game.setTitle("DOOM");
        game.setPublisher("Bethesda");

        Game game1 = new Game();
        game1.setTitle("Battlefield");
        game1.setPublisher("EA");
        Webpage battlefieldWebpage = new Webpage();
        game1.setWebpage(battlefieldWebpage);

        doomWebpage.setAddress("www.doom.com");
        game.setWebpage(doomWebpage);

        em.getTransaction().begin();
        em.persist(game);
        em.persist(doomWebpage);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
