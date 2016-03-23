<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mentors</title>
        <style type="text/css">
            li{
                list-style: none;
                display: inline;
                margin-right: 5px;
            }
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
             function deleteUser(id){ 
                        var url = "deleteuser"; 
                                        $.get( 
                            url, 
                            {id:id}, 
                function(data){ 
                        $("#users"+id).remove(); 
                return false; 
                        }
                    ); 
                return false; 
                        }
//             onclick="return checkFields()"
            </script>
        
        
    </head>
    <body>
        <table>
            <tr>
                <td>id</td>
                <td>login</td>
                <td>firstname</td>
                <td>lastname</td>
                <td>roles</td>
                <td>email</td>
                <td>deletelink</td>

            </tr>
            <c:forEach var="mentor" items="${users}">
                <tr>
                    <td>${mentor.id}</td>
                    <td>${mentor.login}</td>
                    <td>${mentor.firstname}</td>
                    <td>${mentor.lastname}</td>
                    <td>${mentor.roles}</td>
                    <td>${mentor.email}</td>
                    <td><a href="deleteuser?id=${mentor.id}" onclick="return deleteUser(${mentor.id})">delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <ul>
            <c:forEach var="page" step="1" begin="1" end="${pages}">
                <li>
                    <a href="mentors?page=${page}">${page}</a>
                </li>
            </c:forEach>
        </ul>
    </body>
</html>
