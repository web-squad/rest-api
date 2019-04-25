package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.GameHibernate;
import model.Game;
import org.hibernate.Session;
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

    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //if (request.getRequestURI().equals("/json-generator")) {
            response.getWriter().write("tu kiedys bedzie put");

        //}
    }

}