<%--  
    Document   : AddNotice
    Created on : 12-Nov-2018, 12:50:37
    Author     : K00215515
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
                <form action="ShowsController" method="post" class="show-form" name="shows">


                     <table id="m">
                    <tr>             
                        <td>image</td>
                        <td>short Description</td>
                    </tr>
                    <c:forEach var="shows" items="${allshows}">                  
                        <tr>                                            
                            
                            <td ><img src="${pageContext.request.contextPath}/images/${shows.image}" alt="student work" width="40" height="40"></td>
                            <td ><a href="ShowsController?menu=getShowView&show_id=${shows.show_id}">${shows.title}</a> </td>
                            <td ><a href="ShowsController?menu=deleteShow&show_id=${shows.show_id}">Delete</a> </td>
                            <td ><a href="ShowsController?menu=updateShow&show_id=${shows.show_id}">Update</a> </td>
                         </tr>
                    </c:forEach>


                    

                </form>
            </div>
        </div>


        <script
            src="https://code.jquery.com/jquery-1.12.4.js"
            integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
        crossorigin="anonymous"></script>
        <script src="js/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/form-validation.js"></script>
    </body>
</html>

