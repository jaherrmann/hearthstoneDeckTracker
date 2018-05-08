package com.hearthstone.controller;


import com.hearthstone.entity.User;
import com.hearthstone.persistence.GenericDao;
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

@WebServlet(
        urlPatterns = {"/addUser"}
)
/**
 * This class will add a user to the user table
 * @author jeff
 */
public class AddUser extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This doget will add a user to the user table
     * @param request the request
     * @param response the response
     * @throws ServletException exception
     * @throws IOException exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int userId = 0;
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        GenericDao dao = new GenericDao(User.class);
        User user = new User(userName, password);

        try {
            dao.add(user);

            userId = user.getId();
            Integer.toString(userId);
            logger.info(userId);

            session.setAttribute("userName", userId);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/success.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
            dispatcher.forward(request, response);
        }
    }
}
