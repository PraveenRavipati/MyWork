
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		UserPoperty usp=new UserPoperty();
		UserDetails d=new UserDetails();
		PrintWriter out=response.getWriter();
		d.setName(request.getParameter("name"));
		d.setUserName(request.getParameter("uname"));
		d.setEmail(request.getParameter("email"));
		d.setPwd(request.getParameter("pwd"));
		d.setPhoto(request.getParameter("uname"));
		if(!usp.UserExist(d.getUserName())){
			System.out.println("in");
			usp.setUserProperty(d.getUserName(), d);
			System.out.println("property setted");
			out.println("Registration Successfull");
			response.setHeader("refresh", "4 url=./home.html");
		}
		else {
			out.println("User name exist try another ....!");
			response.setHeader("refresh", "4 url=./Register.html");
		}
	}

}

