package com.hearthstone.controller;

import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.User;
import com.hearthstone.persistence.GenericDao;
import org.apache.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        urlPatterns = {"/addDeck"}
)

/**
 * This servlet is responsible for adding a deck into the DB
 * @author jaherrmann
 */
public class AddDeck extends HttpServlet{
    Logger logger = Logger.getLogger(this.getClass());

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String card1 = request.getParameter("card1");
        String card2 = request.getParameter("card2");
        String card3 = request.getParameter("card3");
        String card4 = request.getParameter("card4");
        String card5 = request.getParameter("card5");
        String card6 = request.getParameter("card6");
        String card7 = request.getParameter("card7");
        String card8 = request.getParameter("card8");
        String card9 = request.getParameter("card9");
        String card10 = request.getParameter("card10");
        String card11 = request.getParameter("card11");
        String card12 = request.getParameter("card12");
        String card13 = request.getParameter("card13");
        String card14 = request.getParameter("card14");
        String card15 = request.getParameter("card15");
        String card16 = request.getParameter("card16");
        String card17 = request.getParameter("card17");
        String card18 = request.getParameter("card18");
        String card19 = request.getParameter("card19");
        String card20 = request.getParameter("card20");
        String card21 = request.getParameter("card21");
        String card22 = request.getParameter("card22");
        String card23 = request.getParameter("card23");
        String card24 = request.getParameter("card24");
        String card25 = request.getParameter("card25");
        String card26 = request.getParameter("card26");
        String card27 = request.getParameter("card27");
        String card28 = request.getParameter("card28");
        String card29 = request.getParameter("card29");
        String card30 = request.getParameter("card30");
        String name = request.getParameter("name");



        GenericDao findUser = new GenericDao(User.class);
        User user = (User) findUser.getByID(1);

        GenericDao dao = new GenericDao(Decklist.class);
        Decklist decklist = new Decklist(name, user,  card1, card2, card3, card4, card5, card6, card7, card8, card9,
                card10, card11, card12, card13, card14, card15, card16, card17, card18, card19, card20, card21,
                card22, card23, card24, card25, card26, card27, card28, card29, card30);

        try {
            dao.add(decklist);

            RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
            dispatcher.forward(request, response);
        }
    }


}
