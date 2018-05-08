package com.hearthstone.controller;


import com.hearthstone.entity.Decklist;
import com.hearthstone.entity.User;
import com.hearthstone.persistence.GenericDao;
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
        urlPatterns = {"/viewAllUsers"}
)

/**
 * this class will allow the admin to view all the users
 * @author jeff
 */
public class ViewAllUsers extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This will make the request to the user and return a collection of all users
     * @param request request
     * @param response response
     * @throws ServletException exception
     * @throws IOException exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GenericDao dao = new GenericDao(User.class);
        List<User> users = dao.getAll();

        try{
            session.setAttribute("users", users);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/allUsers.jsp");
            dispatcher.forward(request, response);
        } catch(Exception ex) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
            dispatcher.forward(request, response);
        }

    }
}
