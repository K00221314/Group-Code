<%-- 
    Document   : index
    Created on : 19-Dec-2016, 18:30:35
    Author     : AMarie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Admin"%>
<%@page import="model.Shows"%>


<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>LIT Gallery - Home Page</title>
    <link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
    <!-- Add icon library -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="icon" type="image/png" href="img/sss.png">
    <meta name="viewport" content="width=device-width , initial-scale=1.0">
</head>

<body>
    <div class="pageWrapper">

        <div class="grid">
            <div class="header">

                <div class="loginSignUp">
                    <a class="username" href="profile.html"><img src="img/039.jpeg" alt="Profile Picture">User Name</a>
                    <a href="signIn.html">Sign In</a>
                    <a href="signUp.html">Sign Up</a>
                    <a href="#">Log Out</a>
                </div>

                <div class="logo">
                    <a href="index.html">
                        <img class="logohome" src="img/logo1.png" alt="LIT Gallery Logo">
                    </a>
                </div>

                <div class="nav">
                    <label for="toggle">&#9776;</label>
                    <input type="checkbox" id="toggle" />
                    <div class="menu">
                        <a href="index.html">Home</a>
                        <a href="profile.html">Profile</a>
                        <a href="gallery.html">Gallery</a>
                        <a href="showpage.html">Show</a>

                        <a class="active" href="adminMenu.html">Admin Area</a>
                        <input class="search" type="text" placeholder="Search..">
                    </div>
                </div>

            </div>


            <div class="breadCrumb">
                <ul class="breadcrumb">
                    <li><a href="index.html">Home</a></li>
                     <li><a href="#">Admin Area</a></li>    
                    <li>Menu</li>
                </ul>
            </div>
             <div class="slideshow">
                <img class="slideshowImg" src="img/banner2.png" alt="Banner Pic">
            
            
            <div class="title">
                <h3>Admin Menu</h3>
            </div>


            <div class="main">



                <div class="panelMenu">
                    <div class="adminMenu">
                        <a href="manageUsers.html">Manage Users</a>
                        <a href="manageTags.html">Manage Tags</a>
                        <a href="deleteProfile.html">Delete Profile</a>
                        <a href="AddShow.jsp">Create Show</a>
                        <a href="deleteShow.jsp">Delete Show</a>
                        <a href="manageShows.jsp">Manage Show</a>
                         
                        
                    </div>
                </div>

            </div>
            .
            <div class="footer">
                <p>Terms and Conditions</p>
                <div class="logos">
                    <a href="#"><img src="img/facebook-logo-circle-transparent.png" alt="Facebook Logo"></a>
                    <a href="#"><img src="img/twitterTP.png" alt="Twitter Logo"></a>
                    <a href="#"><img src="img/litTP.png" alt="LIT Logo"></a>
                    <a href="#"><img src="img/instaTP.jpg.png" alt="Instagram Logo"></a>
                </div>
            </div>

        </div>
    </div>

</body>

</html>
