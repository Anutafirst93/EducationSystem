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
//                    if(roles === undefined || roles.length === 0){
//                        alert ("roles shouldn`t be empty");
//                        return false;
//                    }
                    
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
//                    if (roles.length > 32){
//                        alert ("roles shouldn`t be more then 32 chars");
//                        return false;
//                    }
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
//             onclick="return checkFields()"
            </script>
    </head>
    <body>
        
            <text>Регистрация пользователя:  </text>
            <form method="post" action="adduser">
            <table>
                
                <tr>
                    <th>
                        Login: 
                    </th>
                    <td>
                        <input type="text" name="login" id="login"/>
                    </td>                  
                </tr>
                <tr>
                    <th>
                        Password:
                    </th>
                    <td>
                        <input type="text" name="pass" id="pass"/>
                    </td> 
                </tr>
                <tr>
                    <th>
                        Firstname:
                    </th>
                    <td>
                        <input type="text" name="firstname" id="firstname"/>
                    </td> 
                </tr>
                <tr>
                    <th>
                        Lastname:
                    </th>
                    <td>
                        <input type="text" name="lastname" id="lastname"/>
                    </td> 
                </tr>
                <tr>
                    <th>
                        Your role:
                    </th>
                    <td>
                        <select name ="roles">
                            <option selected="" value="">Выберите значение</option>
                            <option value="stud">Student</option>
                            <option value="menthor">Menthor</option>
                            <option value="admin">Admin</option>
                        </select>
                    </td> 
                </tr>
                <tr>
                    <th>
                        Email:
                    </th>
                    <td>
                       <input type="email" value="" name="email" id="email"/>
                    </td> 
                </tr>
                <tr>
                    <td colspan="2">
                        <p> <input type="submit" name="adduser" value="add user" onclick="return checkFields()"/> </p>
                    </td>               
                </tr>
            
                
            </table>
        </form>
            
        <table>
            <tr>
                <td>id</td>
                <td>login</td>
                <td>pass</td>
                <td>firstname</td>
                <td>lastname</td>
                <td>roles</td>
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
                    <td><c:out value="${item.roles}"/></td>
                    <td><c:out value="${item.email}"/></td>
                    <td><a href="edituser?id=${item.id}">edit</a></td>
                    <td><a href="deleteuser?id=${item.id}" onclick="return deleteUser(${item.id})">delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
