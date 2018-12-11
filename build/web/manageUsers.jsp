<%-- 
    Document   : register
    Created on : 07-Dec-2016, 21:39:41
    Author     : AMarie
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Admin"%>


<!DOCTYPE html>
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
            <h1>Manage Users</h1>
            <div class="form">
                <form action="Admin2Controller" method="get" class="register-form" name="registration">


                   <c:forEach var="users" items="${allusers}">                  
                        <tr>                                            
                            
                            <td ><img src="${pageContext.request.contextPath}/images/${users.image}" alt="student work" width="40" height="40"></td>
                            <td ><a href="Admin2Controller?menu=getNoticeView&noticeId=${notices.noticeId}">${notices.shortDescription}</a> </td>
                            <td ><a href="Admin2Controller?menu=deleteNotice&noticeId=${notices.noticeId}">Delete</a> </td>
                            <td ><a href="Admin2Controller?menu=updateNotice&noticeId=${notices.noticeId}">Update</a> </td>
                         </tr>
                    </c:forEach>
                    


                    <input type="submit" name="menu" value="Save" />
                     <a href="index.html">Sign Up</a>

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
