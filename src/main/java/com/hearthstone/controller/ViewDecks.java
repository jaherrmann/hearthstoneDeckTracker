package com.hearthstone.controller;


import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.User;
import com.hearthstone.persistence.UserDao;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(
        urlPatterns = {"/viewDecks"}
)

/**
 * This class will allow the user to view all of their decks, it will also consume a web api that will
 * retrieve stats and charateristics of specific cards.
 * @author jeff
 */
public class ViewDecks extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This will make the request to the decklist table and return a collection of all decks a user has
     * @param request request
     * @param response response
     * @throws ServletException exception
     * @throws IOException exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UserDao user = new UserDao();

        try{
            int userId = (Integer) session.getAttribute("userName");
            logger.info(userId);
            User retrievedUser = user.getUserFromId(userId);

            List<Decklist> decks = user.getDeckByUserId(retrievedUser);

            request.setAttribute("decks", decks);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/manage.jsp");
            dispatcher.forward(request, response);
        } catch(Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
            dispatcher.forward(request, response);
        }

    }
}
