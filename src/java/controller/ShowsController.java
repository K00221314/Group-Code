/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Admin;
import model.Shows;

/**
 *
 * @author k00221314
 */
@WebServlet(name = "ShowsController", urlPatterns = {"/ShowsController"})
public class ShowsController extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession session = request.getSession();
//        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        
        System.out.println("Show 1");
//        List<FileItem> items = null;     
        Admin user = (Admin) session.getAttribute("user");
        if (user == null) {
            user = new Admin();
            session.setAttribute("user", user);
        }
        Shows shows = (Shows) session.getAttribute("shows");
        if(shows == null){
            shows = new Shows();
            session.setAttribute("shows", shows);
        }
        
        String menu="home";
        menu = request.getParameter("menu");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if (menu == null) {
            System.out.println("menu is null");
            menu = "home";
        }
        
//         String menu =request.getParameter("menu");
        switch (menu) {
             
//            case "Add":
//               
//                gotoPage("/AddShows.jsp", request, response);
//                break;

            case "home":
                System.out.println("Show 3");
                Shows show = new Shows();
                ArrayList<Shows> allshows = new ArrayList<>();
                allshows = show.getAllShows();
                session.setAttribute("allshows", allshows);
                gotoPage("/manageShows.jsp", request, response);
                break;
                
            case "Save Show":
                System.out.println("in process save switch");
                ProcessSave(request, session);
                gotoPage("/AdminHomepage.jsp", request, response);
                break;
                
            case "deleteShow":
                String snid = request.getParameter("show_id");
                int nid = Integer.parseInt(snid);
                Shows show2 = new Shows();
                boolean worked = show2.deleteShows(nid);
                
                ArrayList<Shows> allshows2 = new ArrayList<>();
                allshows2 = show2.getAllShows();
               
                session.setAttribute("allshows", allshows2);
                gotoPage("/AdminHomepage.jsp", request, response);
                
                break; 
            case "updateShow":
                gotoPage("/detailedShowView.jsp", request, response);
                break; 
            case "Update":
                ProcessUpdate(request, session, shows);
                gotoPage("/AdminHomepage.jsp", request, response);                
                break;
            case "Delete":
                ProcessDelete(request, session, shows);
                
                break;
//            case "Create Notice":
//                //get request data
//                String shortdes = getMultiRequest(items, "ShortDescription");
//                System.out.println("shortdes" + shortdes);
//                String longdes = getMultiRequest(items, "LongDescription");
//
//                //upload file
//                String image = doFileUpload(items, response);
//                System.out.println("image" + image);
//                System.out.println("request data" + shortdes + " " + longdes + " " + image);
//                //create notice
//                Notices notice = new Notices(image, shortdes, longdes, user.getUserid());
//                notice.saveToDatabase();
//
//                gotoPage("/UserHomePage.jsp", request, response);
//                break;       
            case "getShowView":
                
                String showid = request.getParameter("show_id");
                int show_id = Integer.parseInt(showid);
                System.out.println("show_id"+show_id);
                
                Shows s = new Shows();
                s = s.getShowDetails(show_id);
                
                if (s != null) {
                    
                    session.setAttribute("shows", s);
                    System.out.println("sesion contents"+session.getAttribute("shows"));
                     Admin u = new Admin();
                    System.out.println("get user details " + u.getUser_id() );
                    u = u.getUserDetails(s.getShow_id());
                    if(u!=null) {
                        System.out.println("shows" + u.getUsername());
                        session.setAttribute("showUsername", u);
                    }
                    else{
                        System.out.println("user details null");
                    }
                    
                }
                gotoPage("/detailedShowView.jsp", request, response);
                break;
            default:
                gotoPage("/invalid.jsp", request, response);
                break;
        }
    }
//   private String doFileUpload(List<FileItem> items,
//            HttpServletResponse response) {
//        
//        String fileName=null;
//        FileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//
//        try {
//            List items = upload.parseRequest(request);
//          iterator();
//            Iterator iterator = items.iterator;
//            while (iterator.hasNext()) {
//                FileItem item = (FileItem) iterator.next();
//
//                if (!item.isFormField()) {
//
//                    fileName = item.getName();
//
//                    String root = getServletContext().getRealPath("/");
//                    File path = new File(root + "/images");
//                    if (!path.exists()) {
//                        boolean status = path.mkdirs();
//                    }
//
//                    File uploadedFile = new File(path + "/" + fileName);
//                    System.out.println(uploadedFile.getAbsolutePath());
//                    item.write(uploadedFile);
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        }
//        return fileName;
//    }
//   private String getMultiRequest(List<FileItem> items, String fieldnameRequired) {
//      
//        String fname = null;
//
//        
//        for (FileItem uploadItem : items) {
//         
//            String fieldName = uploadItem.getFieldName();
//           
//            if (fieldnameRequired.equals(fieldName)) {
//                System.out.println(uploadItem.getString());
//                return uploadItem.getString();
//            }
//
//        }
//
//        return fname;
//    }
    private void gotoPage(String url,
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }
    
    private void ProcessSave(HttpServletRequest request, HttpSession session) {
        System.out.println("in process save show");
        String date_of_show = request.getParameter("date_of_show");
        String duration = request.getParameter("duration");
        String title = request.getParameter("title");
         String description = request.getParameter("description");
          String image = request.getParameter("image");
        Admin user = (Admin) session.getAttribute("user");
        System.out.println("User_id " + user.getUser_id());
        Shows shows = new Shows(user.getUser_id(),date_of_show,duration,title,description,image);
        
        shows = shows.saveToDatabase();

        session.setAttribute("shows", shows);
        System.out.println("show_id" + shows.getShow_id());
    }
        public void ProcessUpdate(HttpServletRequest request, HttpSession session, Shows shows){
       String date_of_show = request.getParameter("date_of_show");
        String duration = request.getParameter("duration");
        String title = request.getParameter("title");
         String description = request.getParameter("description");
          String image = request.getParameter("image");
        System.out.println("show_id " + shows.getShow_id());
        
        Shows not = new Shows(shows.getShow_id(),date_of_show,duration,title,description,image);
        
        not = not.update();

        session.setAttribute("shows", shows);
        System.out.println("show_id" + shows.getShow_id());
        
        
    }
        private void ProcessDelete(HttpServletRequest request, HttpSession session, Shows shows) {
//        Notices notice = new Notices();
        shows.deleteShows(shows.getShow_id());
        session.setAttribute("shows", shows);
        System.out.println("show_id" + shows.getShow_id());  
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

}
