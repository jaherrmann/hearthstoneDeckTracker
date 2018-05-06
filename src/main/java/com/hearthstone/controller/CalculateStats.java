package com.hearthstone.controller;


import com.hearthstone.entity.Stats;
import com.hearthstone.entity.User;
import com.hearthstone.persistence.GenericDao;
import com.hearthstone.persistence.StatsDao;
import org.apache.log4j.Logger;
import sun.net.www.content.text.Generic;

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
        urlPatterns = {"/calculateStats"}
)

public class CalculateStats extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StatsDao dao = new StatsDao();
        List<Stats> stats;

        String wins = request.getParameter("wins");
        String losses = request.getParameter("losses");
        int deckId =  (Integer) session.getAttribute("deckId");

        int calculateWins = Integer.parseInt(wins);
        int calculateLosses = Integer.parseInt(losses);

        stats = dao.getStatsFromDeckId(deckId);

        logger.info(stats);

        dao.getStatsFromDeckId(deckId);

        logger.info(deckId);

//        if(calculateWins != 0){
//            dao.addWin(calculateWins);
//        }
//
//
//
//
//
//
//        try {
//            dao.(user);
//
//            userId = user.getId();
//            Integer.toString(userId);
//            logger.info(userId);
//
//            session.setAttribute("userName", userId);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
//            dispatcher.forward(request, response);
//        } catch (Exception ex){
//            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
//            dispatcher.forward(request, response);
//        }
    }

}
