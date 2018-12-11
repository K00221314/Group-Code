package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Admin;
import model.Shows;

public final class AdminHomepage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>LIT Gallery - Home Page</title>\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/styles.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css?family=Roboto\" rel=\"stylesheet\">\n");
      out.write("    <!-- Add icon library -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("    <link rel=\"icon\" type=\"image/png\" href=\"img/sss.png\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width , initial-scale=1.0\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("    <div class=\"pageWrapper\">\n");
      out.write("\n");
      out.write("        <div class=\"grid\">\n");
      out.write("            <div class=\"header\">\n");
      out.write("\n");
      out.write("                <div class=\"loginSignUp\">\n");
      out.write("                    <a class=\"username\" href=\"profile.html\"><img src=\"img/039.jpeg\" alt=\"Profile Picture\">User Name</a>\n");
      out.write("                    <a href=\"signIn.html\">Sign In</a>\n");
      out.write("                    <a href=\"signUp.html\">Sign Up</a>\n");
      out.write("                    <a href=\"#\">Log Out</a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\">\n");
      out.write("                        <img class=\"logohome\" src=\"img/logo1.png\" alt=\"LIT Gallery Logo\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"nav\">\n");
      out.write("                    <label for=\"toggle\">&#9776;</label>\n");
      out.write("                    <input type=\"checkbox\" id=\"toggle\" />\n");
      out.write("                    <div class=\"menu\">\n");
      out.write("                        <a href=\"index.html\">Home</a>\n");
      out.write("                        <a href=\"profile.html\">Profile</a>\n");
      out.write("                        <a href=\"gallery.html\">Gallery</a>\n");
      out.write("                        <a href=\"showpage.html\">Show</a>\n");
      out.write("\n");
      out.write("                        <a class=\"active\" href=\"adminMenu.html\">Admin Area</a>\n");
      out.write("                        <input class=\"search\" type=\"text\" placeholder=\"Search..\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"breadCrumb\">\n");
      out.write("                <ul class=\"breadcrumb\">\n");
      out.write("                    <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                     <li><a href=\"#\">Admin Area</a></li>    \n");
      out.write("                    <li>Menu</li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("             <div class=\"slideshow\">\n");
      out.write("                <img class=\"slideshowImg\" src=\"img/banner2.png\" alt=\"Banner Pic\">\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"title\">\n");
      out.write("                <h3>Admin Menu</h3>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"main\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"panelMenu\">\n");
      out.write("                    <div class=\"adminMenu\">\n");
      out.write("                        <a href=\"manageUsers.html\">Manage Users</a>\n");
      out.write("                        <a href=\"manageTags.html\">Manage Tags</a>\n");
      out.write("                        <a href=\"deleteProfile.html\">Delete Profile</a>\n");
      out.write("                        <a href=\"AddShow.jsp\">Create Show</a>\n");
      out.write("                        <a href=\"deleteShow.jsp\">Delete Show</a>\n");
      out.write("                         <a href=\"#\">Edit Banner</a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            .\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <p>Terms and Conditions</p>\n");
      out.write("                <div class=\"logos\">\n");
      out.write("                    <a href=\"#\"><img src=\"img/facebook-logo-circle-transparent.png\" alt=\"Facebook Logo\"></a>\n");
      out.write("                    <a href=\"#\"><img src=\"img/twitterTP.png\" alt=\"Twitter Logo\"></a>\n");
      out.write("                    <a href=\"#\"><img src=\"img/litTP.png\" alt=\"LIT Logo\"></a>\n");
      out.write("                    <a href=\"#\"><img src=\"img/instaTP.jpg.png\" alt=\"Instagram Logo\"></a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
