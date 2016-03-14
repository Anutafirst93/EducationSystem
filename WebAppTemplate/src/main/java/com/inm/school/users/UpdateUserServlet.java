/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.users;

import com.inm.school.domain.UserServiceImpl;
import com.inm.school.domain.entityes.Users;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Нюта
 */
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Users u = new UserServiceImpl().getUser(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("currentUser", u);
        request.setAttribute("acceptedRoles", Users.acceptedRoles);
        request.getRequestDispatcher("WEB-INF/edituser.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String login = request.getParameter("login");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String roles = request.getParameter("roles");
        String email = request.getParameter("email");
        Users user = new UserServiceImpl().getUser(Integer.parseInt(request.getParameter("id")));
        user.setLogin(login);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setRoles(roles);
        user.setEmail(email);
        
        new UserServiceImpl().updateUser(user);
        response.sendRedirect("users"); 
    }
}
