package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import dao.GameHibernate;
import model.Game;
import model.Webpage;
import javax.persistence.*;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
    GameHibernate gameHibernate = new GameHibernate();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getRequestURI().equals("/allgames")) {
            List<Game> gameList = gameHibernate.getGames();
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(gameList));
        }

        if (request.getRequestURI().length() < 5) {
            try {
                long gameId = Long.parseLong(request.getRequestURI().split("/")[1]);
                Game game = gameHibernate.getGameById(gameId);
                ObjectMapper mapper = new ObjectMapper();
                response.getWriter().write(mapper.writeValueAsString(game));
            } catch (NoResultException e) {
                response.getWriter().write("No game with this id");
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String title = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        String address = request.getParameter("address");

        Webpage webpage = new Webpage();
        webpage.setAddress(address);
        Game newGame = new Game();
        newGame.setId(id);
        newGame.setTitle(title);
        newGame.setPublisher(publisher);
        newGame.setWebpage(webpage);

        gameHibernate.addGameToDatabase(newGame);

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(newGame));

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        String newTitle = request.getParameter("title");
        String publisher = request.getParameter("publisher");
        String address = request.getParameter("address");

        Webpage webpage = new Webpage();
        webpage.setAddress(address);
        Game updatedGame = new Game();
        updatedGame.setId(id);
        updatedGame.setTitle(newTitle);
        updatedGame.setPublisher(publisher);
        updatedGame.setWebpage(webpage);

        gameHibernate.updateGameTitleById(id, updatedGame);

        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(updatedGame));
    }

    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id = Long.parseLong(request.getParameter("id"));
        Game game = gameHibernate.getGameById(id);

        gameHibernate.deleteGameFromDatabase(game);

        Gson gson = new Gson();
        response.getWriter().write(gson.toJson("Game deleted"));
    }

}