package com.iii.pel.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: LogoutServlet
 *
 */
 public class LogoutServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*Connection connection = (Connection) request.getSession().getAttribute("CONNECTION.LOGIN");
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		String clientId = (String) request.getSession().getAttribute("CLIENT_ID");
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		try {
			((SimpleConnectionAgent) context.getAttribute("connectionAgent")).close(clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().invalidate();*/
		
		request.getRequestDispatcher("/InvalidateSessionServlet").include(request, response);
		request.getRequestDispatcher("/jsf/jsp/login.jsf").forward(request, response);
	}   	  	    
}
