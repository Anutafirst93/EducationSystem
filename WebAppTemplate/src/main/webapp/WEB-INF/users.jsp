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
        </style>
        
        
<!--        <script type="text/javascript">
           
                function checkFields () {
                    var login = $("#login").val();
                    var pass = $("#pass").val();
                    var firstname = $("#firstname").val();
                    var lastname = $("#lastname").val();
                    var role = $("#role").val();
                    var email = $("#email").val();
                    login.trim();
                    pass.trim();
                    firstname.trim();
                    lastname.trim();
                    role.trim();
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
                    if(role === undefined || role.length === 0){
                        alert ("role shouldn`t be empty");
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
                    if (role.length > 32){
                        alert ("role shouldn`t be more then 32 chars");
                        return false;
                    }
                     if (email.length > 32){
                        alert ("email shouldn`t be more then 32 chars");
                        return false;
                    }
                    return true;
                }
                
                
                function deleteUser(id){ 
                        var url = "deleteuser"; 
                                        $.get( 
                            url, 
                            {id:id}, 
                function(data){ 
                        $("#item"+id).remove(); 
                return false; 
                        }
                    ); 
                return false; 
                        }
           
            </script>-->
    </head>
    <body>
        <form method="post" action="adduser">
            <input type="text" name="login" id="login"/>
            <input type="text" name="pass" id="pass"/>
            <input type="text" name="firstname" id="firstname"/>
            <input type="text" name="lastname" id="lastname"/>
            <!--<input type="text" name="role" id="role"/>-->
            <select name ="role">
                <option selected="" value="">Выберите значение</option>
                <option value="stud">Student</option>
                <option value="menthor">Menthor</option>
                <option value="admin">Admin</option>
                <input type="email" value="" name="email" id="email"/>
            <input type="submit" name="adduser" value="add user" />
            <!--onclick="return checkFields()"-->
        </form>
        <table>
            <tr>
                <td>id</td>
                <td>login</td>
                <td>pass</td>
                <td>firstname</td>
                <td>lastname</td>
                <td>role</td>
                <td>email</td>
                <td>editlink</td>
                <td>deletelink</td>
            </tr>
            
            <c:forEach var="item" items="${userlist}">
                <tr id="item${item.id}">
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.login}"/></td>
                    <td><c:out value="${item.pass}"/></td>
                    <td><c:out value="${item.firstname}"/></td>
                    <td><c:out value="${item.lastname}"/></td>
                    <td><c:out value="${item.role}"/></td>
                    <td><c:out value="${item.email}"/></td>
                    <td><a href="edituser?id=${item.id}">edit</a></td>
                    <td><a href="deleteuser?id=${item.id}" onclick="return deleteUser(${item.id})">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
