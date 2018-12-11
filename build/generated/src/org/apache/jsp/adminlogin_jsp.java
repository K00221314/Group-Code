package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Admin;

public final class adminlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!doctype html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <title>Untitled Document</title>\n");
      out.write("    <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/css/forms.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("      <meta name=\"viewport\" content=\"width=device-width , initial-scale=1.0\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("<div class=\"login-page\">\n");
      out.write("           <div class=\"logo\">\n");
      out.write("                    <a href=\"index.html\">\n");
      out.write("                        <img class=\"logohome\" src=\"img/logo1.png\" alt=\"LIT Gallery Logo\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            <h1>Sign In</h1>\n");
      out.write("            <div class=\"form\">\n");
      out.write("                <form action=\"Admin2Controller\" method=\"get\" class=\"login-form\" name=\"Login\"> \n");
      out.write("\n");
      out.write("\n");
      out.write("                    <label for=\"username\">username</label>\n");
      out.write("                        <input type=\"username\" name=\"username\" id=\"username\">\n");
      out.write("                        <br>\n");
      out.write("                        <label for=\"password\">Password</label>\n");
      out.write("                        <input type=\"password\" name=\"password\" id=\"password\">\n");
      out.write("                        <br>\n");
      out.write("                        <p class=\"message\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${message}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</p>               \n");
      out.write("                        <input type=\"submit\" name=\"menu\" value=\"Process Login\" />\n");
      out.write("                    <a href=\"index.html\">Sign In</a>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
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
