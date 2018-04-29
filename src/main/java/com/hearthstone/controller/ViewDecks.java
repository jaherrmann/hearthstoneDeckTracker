package com.hearthstone.controller;


import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.User;
import com.hearthstone.persistence.GenericDao;
import com.hearthstone.persistence.UserDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 */
public class ViewDecks extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao dao = new GenericDao(Decklist.class);

        HttpSession session = request.getSession();
        ServletContext context = request.getServletContext();
        String searchTerm = request.getParameter("name");

        UserDao user = new UserDao();
        User retrievedUser = user.getUserFromId(1);
        List<Decklist> decks = user.getDeckByUserId(retrievedUser);

        request.setAttribute("decks", decks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/manage.jsp");
        dispatcher.forward(request, response);
    }
}
