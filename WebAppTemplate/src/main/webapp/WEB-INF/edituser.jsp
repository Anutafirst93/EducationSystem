<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="js/jquery-2.2.0.js"></script>
        <style type="text/css">
            table, tr, td{
                border:1px solid black;
                border-collapse: collapse;                 
            }
            table{
                margin-bottom: 10px;
                margin-left: auto;
                margin-right: auto;
            }
            td {
                text-align: center; 
            }
           </style>
           
        <script type="text/javascript">
           
                function checkFields () {
                    var login = $("#login").val();
                    var pass = $("#pass").val();
                    var firstname = $("#firstname").val();
                    var lastname = $("#lastname").val();
                    var roles = $("#roles").val();
                    var email = $("#email").val();
                    login.trim();
                    pass.trim();
                    firstname.trim();
                    lastname.trim();
                    roles.trim();
                    email.trim();
                    if(login === undefined || login.length === 0){
                        alert ("login shouldn`t be empty");
                        return false;
                    }
                    if(pass === undefined || pass.length === 0){
                        alert ("pass shouldn`t be empty");
                        return false;
                    }
                    if(firstname === undefined || firstname.length === 0){
                        alert ("firstname shouldn`t be empty");
                        return false;
                    }
                    if(lastname === undefined || lastname.length === 0){
                        alert ("lastname shouldn`t be empty");
                        return false;
                    }
                    if(email === undefined || email.length === 0){
                        alert ("email shouldn`t be empty");
                        return false;
                    }
                    if (login.length > 32){
                        alert ("login shouldn`t be more then 32 chars");
                        return false;
                    }
                     if (pass.length > 32){
                        alert ("pass shouldn`t be more then 32 chars");
                        return false;
                    }
                    if (firstname.length > 32){
                        alert ("firstname shouldn`t be more then 32 chars");
                        return false;
                    }
                     if (lastname.length > 32){
                        alert ("lastname shouldn`t be more then 32 chars");
                        return false;
                    }
                     if (email.length > 32){
                        alert ("email shouldn`t be more then 32 chars");
                        return false;
                    }
                    return true;
                }
            </script>
    </head>
    <body>
            <text>Изменение информации о пользователе:  </text>
            <form method="post" action="edituser">
                <input type="hidden" name="id" value="${currentUser.id}"/>
            <table>
                
                <tr>
                    <th>
                        Login: 
                    </th>
                    <td>
                        <input type="text" value="${currentUser.login}" name="login" id="login"/>
                    </td>                  
                </tr>
                <tr>
                    <th>
                        Firstname:
                    </th>
                    <td>
                        <input type="text" value="${currentUser.firstname}" name="firstname" id="firstname"/>
                    </td> 
                </tr>
                <tr>
                    <th>
                        Lastname:
                    </th>
                    <td>
                        <input type="text" value="${currentUser.lastname}" name="lastname" id="lastname"/>
                    </td> 
                </tr>
                <tr>
                    <th>
                        Your role:
                    </th>
                    <td>
                        <select name ="roles">
                            <c:forEach var="item" items="${acceptedRoles}">
                                <c:choose>
                                    <c:when test="${currentUser.roles == item}">
                                        <option value="${item}" selected="selected">${item}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${item}">${item}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </td> 
                </tr>
                <tr>
                    <th>
                        Email:
                    </th>
                    <td>
                       <input type="email" value="${currentUser.email}" name="email" id="email"/>
                    </td> 
                </tr>
                <tr>
                    <td colspan="2">
                        <p> <input type="submit" name="edituser" value="edit user" /> </p>
                    </td>               
                </tr>
            </table>
        </form>
    </body>
</html>
