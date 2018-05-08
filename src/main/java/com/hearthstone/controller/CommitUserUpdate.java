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
import java.util.List;

@WebServlet(
        urlPatterns = {"/commitUpdateUser"}
)
/**
 * This class will update a user
 * @author jeff
 */
public class CommitUserUpdate extends HttpServlet {
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
        GenericDao genericDao = new GenericDao(User.class);
        String newUserName = request.getParameter("newUserName");
        int userId = (int) session.getAttribute("userId");

        User updateUser = (User)genericDao.getByID(userId);
        updateUser.setUser_name(newUserName);
        genericDao.update(updateUser);
        logger.info(updateUser);

        try {
            session.setAttribute("user", updateUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/allUsers.jsp");
            dispatcher.forward(request, response);
        } catch (Exception ex){
            RequestDispatcher dispatcher = request.getRequestDispatcher("/failure.jsp");
            dispatcher.forward(request, response);
        }
    }

}
