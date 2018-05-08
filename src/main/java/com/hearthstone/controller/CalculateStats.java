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
import java.util.Objects;

/**
 * States the servlet
 */
@WebServlet(
        urlPatterns = {"/calculateStats"}
)
/**
 * This class will calculate the wins and losses taken from the front-end
 * @author jeff
 */
public class CalculateStats extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This will add the stats to the db
     * @param request request
     * @param response response
     * @throws ServletException exception
     * @throws IOException exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        StatsDao statsDao = new StatsDao();
        GenericDao dao = new GenericDao(Stats.class);
        Stats stats;
        int calculateWins = 0;
        int calculateLosses = 0;

        String wins = request.getParameter("wins");
        String losses = request.getParameter("losses");
        int deckId =  (Integer) session.getAttribute("deckId");

        //do a little null exception handling
        if(!(Objects.equals(wins, ""))){
            calculateWins = Integer.parseInt(wins);
        } else{
            calculateWins = 0;
        }

        if(!(Objects.equals(losses, ""))) {
            calculateLosses = Integer.parseInt(losses);
        } else {
            calculateLosses = 0;
        }

        logger.info("Wins: " + wins);
        logger.info("Losses: " + losses);

        //get the stat object to be calculated by deckId
        stats = (Stats) dao.getByID(deckId);

        logger.info(stats);
        logger.info(deckId);

        try {
            //set the stat values of the stat object
            statsDao.addWin(stats, calculateWins);
            statsDao.addLoss(stats, calculateLosses);
            statsDao.caluculateWinPercentage(stats);

            session.setAttribute("stats", stats);
            logger.info(stats);

            response.sendRedirect(request.getContextPath() + "/manageDeck");

        } catch (Exception ex){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
            dispatcher.forward(request, response);
        }
    }

}
