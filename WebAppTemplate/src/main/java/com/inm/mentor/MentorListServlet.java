package com.inm.mentor;

import com.inm.school.domain.UserServiceImpl;
import com.inm.school.domain.entityes.Users;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Нюта
 */
public class MentorListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int page = getPageNumber(request);
        int offset = 10;
        int start = offset * (page-1);
        UserServiceImpl uServive = new UserServiceImpl();
        List<Users> uList = uServive.getMentors(start, offset);
        int pages = uServive.getUsersCount(Users.Roles.MENTOR.name());
        request.setAttribute("users", uList);
        request.setAttribute("pages", getPagesCount(pages,offset));
        request.getRequestDispatcher("WEB-INF/mentors/mentors.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
    
    private int getPagesCount(int qty, int offset){
        int pages = qty/offset;
        if((qty - pages*offset) > 0){
            pages += 1;
        }
        return pages;
    }
    
    private int getPageNumber (HttpServletRequest request){
        int page;
        try {
            page = Integer.parseInt(request.getParameter("page"));
        }catch(Exception e){
            page = 1;
        }
        return page;
    }

}
