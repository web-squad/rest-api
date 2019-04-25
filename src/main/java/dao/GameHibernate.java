package dao;
import model.Game;

import javax.persistence.*;
import java.util.List;

public class GameHibernate {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restapi");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

//    public Game getGameById(long id) throws NoResultException { /// to nie dziala poki co
//        TypedQuery<Game> query = entityManager.createQuery("SELECT e FROM Game e WHERE e.title = DOOM", Game.class);
//        //Query query = entityManager.createQuery("select * from game  where id = 1");
//        //query.setParameter("id",id);
//        return query.getSingleResult();
//    }

    public List<Game> getGames() {
        TypedQuery<Game> query = entityManager.createQuery("select d from Game d", Game.class);
        List<Game> gameList = query.getResultList();
        return gameList;
    }
}
