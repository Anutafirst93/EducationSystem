package com.so.webapptemplate.users;

import com.inm.school.domain.entityes.Users;
import com.inm.school.HibernateUtil;
import com.inm.school.domain.UserServiceImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author stan
 */
public class AddUsersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        Users user = new Users();
        user.setLastname(login);
        user.setLastname(pass);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setLastname(role);
        user.setLastname(email);
        
        int id = new UserServiceImpl().addUser(user);
        
        if(id > 0){
            response.sendRedirect("users");
        }else{
            response.sendRedirect("404.html");
        }
        
    }
    
}
