/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.53
 * Generated at: 2014-06-05 05:54:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Company_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Company</title>\n");
      out.write("<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\n");
      out.write("</head>\n");
      out.write("<body>");

try{
HttpSession hs=request.getSession();
String name=hs.getAttribute("uname").toString();
if(name!=null){
    
      out.write("\n");
      out.write("    <table border=\"1\" width=\"1000\" align=\"center\">\n");
      out.write("        <tr height=\"200\">\n");
      out.write("            <td>Head</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr height=\"50\">\n");
      out.write("            <td><div id=\"templatemo_menu\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"home.jsp\" class=\"current\">Home</a></li>\n");
      out.write("                    <li><a href=\"profile.jsp\">Profile</a></li>\n");
      out.write("                    <li><a href=\"Services.jsp\">Services</a></li>\n");
      out.write("                    <li><a href=\"toDay.jsp\">toDay</a></li>\n");
      out.write("                    <li><a href=\"Company.jsp\">Company</a></li>\n");
      out.write("                    <li><a href=\"Contactus.jsp\">Contact</a></li>\n");
      out.write("                    <li><a href=\"logout.jsp\" class=\"last\">Logout</a></li>\n");
      out.write("                </ul> \n");
      out.write("            </div></td>\n");
      out.write("        </tr>\n");
      out.write("        <tr height=\"500\">\n");
      out.write("            <td>Body</td>\n");
      out.write("        </tr>\n");
      out.write("        <tr height=\"50\">\n");
      out.write("            <td>footer</td>\n");
      out.write("        </tr>\n");
      out.write("    </table>");

}
else{
	
      out.write("\n");
      out.write("    <h2>Session Expire <a href=\"Login.html\">click here</a> to Login</h2>\n");
      out.write("    \n");
      out.write("    ");

    
    }
}
catch(Exception e){
	
      out.write("\n");
      out.write("    <h2>Session Expire <a href=\"Login.html\">click here</a> to Login</h2>\n");
      out.write("    \n");
      out.write("    ");

}
    
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}