package dao;
import model.Game;

import javax.persistence.*;
import java.util.List;

public class GameHibernate {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("restapi");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public Game getGameById(long id) throws NoResultException {
        TypedQuery<Game> query = entityManager.createQuery("select d from Game d WHERE id =:idtofind", Game.class);
        long idToFind = id;
        query.setParameter("idtofind", idToFind);
        return query.getSingleResult();
    }

    public List<Game> getGames() {
        TypedQuery<Game> query = entityManager.createQuery("select d from Game d", Game.class);
        List<Game> gameList = query.getResultList();
        return gameList;
    }
}
