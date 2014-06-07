package com.vl.register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (SerialException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws SerialException,IOException{
		/*String user=request.getParameter("user");
		String email=request.getParameter("email");
		String pwd=request.getParameter("pwd");
		String conpwd=request.getParameter("conpwd");
		String fname=request.getParameter("fname");*/
		PrintWriter out= response.getWriter();
		out.println("The Records are:");
		out.println("User name:"+request.getParameter("user"));
		out.println("Email:"+request.getParameter("email"));
		out.println("Password:"+request.getParameter("pwd"));
		out.println("Father name:"+request.getParameter("fname"));
	}
}
