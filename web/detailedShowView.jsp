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
            <h1>Edit Show</h1>
            <div class="form">
                <form action="ShowsController" method="post" class="show-form" name="shows">


                     <br>
                    <label>Title</label>
                    <input type="text" name="title" id="title" value="${shows.title}" />
                    <br>
                    <label>Description</label>
                    <input type="text" name="description" id="description" value="${shows.description}" />
                   
                    <br>
<!--                    <label>Date of Show</label>
                    <input type="text" name="date_of_show" id="date_of_show" />
                    <br>-->
<!--                    <label>Duration</label>
                    <input type="text" name="duration" id="duration" />
                    <br>-->
                    <label>Image</label>
                    <input type="text" name="image" id="image" value="${shows.image}" />
                    <br>


                    <input type="submit" name="menu" value="Update" />
                <input type="submit" name="menu" value="Delete" />

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

