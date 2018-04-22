package com.hearthstone.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.hearthstone.persistence.DeckDao;

@WebServlet(
        urlPatterns = {"/searchDeck"}
)

public class SearchDeck extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = req.getServletContext();

        String searchTerm = req.getParameter("searchTerm");

        DeckDao deckDao = new DeckDao();

        req.setAttribute("cards", deckDao.getAllCards());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/results.jsp");
        dispatcher.forward(req, resp);
    }
}