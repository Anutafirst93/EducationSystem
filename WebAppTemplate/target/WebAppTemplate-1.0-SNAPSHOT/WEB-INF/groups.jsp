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
        <script type="text/javascript">
           
                function checkFields () {
                    var firstname = $("#firstname").val();
                    var lastname = $("#lastname").val();
                    firstname.trim();
                    lastname.trim();
                    if(firstname === undefined || firstname.length === 0){
                        alert ("firstname shouldn`t be empty");
                        return false;
                    }
                    
                    if(lastname === undefined || lastname.length === 0){
                        alert ("lastname shouldn`t be empty");
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
           
            </script>
    </head>
    <body>
        <form method="post" action="adduser">
            <input type="text" name="firstname" id="firstname"/>
            <input type="text" name="lastname" id="lastname"/>
            <input type="submit" name="submit" value="add user" onclick="return checkFields()"/>
        </form>
        <table>
            <tr>
                <td>id</td>
                <td>firstname</td>
                <td>lastname</td>
                <td>editlink</td>
                <td>deletelink</td>
            </tr>
            
            <c:forEach var="item" items="${userlist}">
                <tr id="item${item.id}">
                    <td><c:out value="${item.id}"/></td>
                    <td><c:out value="${item.firstname}"/></td>
                    <td><c:out value="${item.lastname}"/></td>
                    <td><a href="edituser?id=${item.id}">edit</a></td>
                    <td><a href="deleteuser?id=${item.id}" onclick="return deleteUser(${item.id})">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
