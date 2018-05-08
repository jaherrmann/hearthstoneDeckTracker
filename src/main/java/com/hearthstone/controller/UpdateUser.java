package com.hearthstone.controller;


import com.hearthstone.entity.User;
import com.hearthstone.persistence.GenericDao;
import com.hearthstone.persistence.UserDao;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        urlPatterns = {"/updateUser"}
)
/**
 * This class will update a user
 * @author jeff
 */
public class UpdateUser extends HttpServlet {
    Logger logger = Logger.getLogger(this.getClass());

    /**
     * This will make a call to the user table and return a user based on creds
     * @param request request
     * @param response response
     * @throws ServletException exception
     * @throws IOException exception
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        GenericDao dao = new GenericDao(User.class);
        int userId = 0;
        String userName = request.getParameter("userId");
        userId = Integer.parseInt(userName);
        session.setAttribute("userId", userId);
        List<User> user = new ArrayList<>();
        User retrievedUser = (User) dao.getByID(userId);
        user.add(retrievedUser);

        logger.info(user);

        try {
            session.setAttribute("user", user);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/updateUser.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
            dispatcher.forward(request, response);
        }
    }

}
