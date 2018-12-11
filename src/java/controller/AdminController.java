/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;

/**
 *
 * 
 */
public class AdminController extends HttpServlet {

//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin user = (Admin) session.getAttribute("user");
        if (user == null) {
            user = new Admin();
            session.setAttribute("user", user);
        }

        String menu = request.getParameter("menu");

        switch (menu) {
            case "Login":
                gotoPage("/login.jsp", request, response);
                break;
            case "SignUp":
                gotoPage("/adminSignup.jsp", request, response);
                break;
            case "Save":
                ProcessSave(request, session);
                gotoPage("/AdminHomepage.jsp", request, response);
                break;
            case "logout":
                gotoPage("/Homepage.jsp", request, response);
                break;
            case "Update":
                ProcessUpdate(request, session, user);
                gotoPage("/AdminHomepage.jsp", request, response);
                break;
            case "update":
                gotoPage("/Update.jsp", request, response);
                break; 
            case "DeleteUser":
                ProcessDelete(request, session, user);
                gotoPage("/adminlogin.jsp", request, response);
                break;   
            case "AddNotice":
                gotoPage("/AddNotice.jsp", request, response);
                break;
//            case "delete":
//                gotoPage("/login.jsp", request, response);
//                break; 
            case "Process Login":
                boolean validLogin = ProcessLogin(request, session);
                if (!validLogin) {
                    String message = "invalid logon details.. try again";
                    session.setAttribute("message", message);
                    gotoPage("/adminlogin.jsp", request, response);
                } else {

                    gotoPage("/AdminHomepage.jsp", request, response);
                }
                break;

//            default:
//                gotoPage("/invalid.jsp", request, response);
//                break;
        }
    }

    private boolean ProcessLogin(HttpServletRequest request, HttpSession session) {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Admin us = new Admin(username, password);
        us.Login(username, password);
        session.setAttribute("user", us);
       
        if (us.getUser_id()!=0) {
            return true;
        } else {
            return false;
        }
    }

    private void ProcessSave(HttpServletRequest request, HttpSession session) {
        
        
        String f_name = request.getParameter("f_name");
        String l_name = request.getParameter("l_name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String profile_pic = request.getParameter("profile_pic");
        String password = request.getParameter("password");
        
        String bio = request.getParameter("bio");
        
        
        Admin us = new Admin( f_name,  l_name,email,username, profile_pic, password, bio);
        us.saveToDatabase();

        session.setAttribute("user", us);
        System.out.println("userid" + us.getUser_id());
    }

    private void gotoPage(String url,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void ProcessUpdate(HttpServletRequest request, HttpSession session, Admin user){
        String f_name = request.getParameter("f_name");
        String l_name = request.getParameter("l_name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String profile_pic = request.getParameter("profile_pic");
        String password = request.getParameter("password");
        
        String bio = request.getParameter("bio");
        
       Admin us = new Admin( f_name,  l_name,email,username, profile_pic, password, bio);
        
        us.update();
        session.setAttribute("user", us);
        System.out.println("userid" + us.getUser_id());
    }

    private void ProcessDelete(HttpServletRequest request, HttpSession session, Admin user) {
        Admin us = new Admin(user.getUser_id());
        us.delete(user.getUser_id());
        session.setAttribute("user", us);
        System.out.println("userid" + us.getUser_id());   
    }

}
