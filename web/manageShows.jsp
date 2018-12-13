3<%--  
   
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Shows"%>



<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Untitled Document</title>
    <link href="${pageContext.request.contextPath}/css/forms.css" rel="stylesheet" type="text/css">
      <meta name="viewport" content="width=device-width , initial-scale=1.0">
</head>
<body>

<div class="login-page">
           <div class="logo">
                    <a href="index.html">
                        <img class="logohome" src="img/logo1.png" alt="LIT Gallery Logo">
                    </a>
                </div>
            <h1>Manage Shows</h1>
            <div class="form">
                


                     <table id="m">
                    <tr>             
                        <td>image</td>
                        <td>show title</td>
                    </tr>
                    <c:forEach var="shows" items="${allshows}">                  
                        <tr>                                            
                            
                            <td ><img src="${pageContext.request.contextPath}/images/${shows.image}" alt="shows" width="40" height="40"></td>
                            <td ><a href="ShowsController?menu=getShowView&show_id=${shows.show_id}">${shows.title}</a> </td>
                            <td ><a href="ShowsController?menu=deleteShow&show_id=${shows.show_id}">Delete</a> </td>
                            <td ><a href="ShowsController?menu=updateShow&show_id=${shows.show_id}">Update</a> </td>
                         </tr>
                    </c:forEach> 
                     </table>
                </form>
            </div>
        </div>
    </body>
    
</html>

