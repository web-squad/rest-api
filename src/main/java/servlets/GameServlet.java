package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Game;

@WebServlet("/game")
public class GameServlet extends HttpServlet {

    GameHibernate gameHibernate = new GameHibernate();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Game game = new Game();
//        game.setTitle("Battlefield 5");
//        game.setPublisher("EA");

        response.setContentType("application/json");
        String[] requestedURI = request.getRequestURI().split("/");
        List<Game> gameList =

        ObjectMapper obj = new ObjectMapper();

        try {
            // get Oraganisation object as a json string
            String jsonStr = obj.writeValueAsString(game);

            // Displaying JSON String
            System.out.println(jsonStr);
        }

        catch (IOException e) {
            e.printStackTrace();
        }

        //response.getWriter().write();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}