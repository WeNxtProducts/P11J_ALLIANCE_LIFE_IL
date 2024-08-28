package com.iii.pel.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.login.service.LoginService;

/**
 * Servlet implementation class for Servlet: InvalidateSessionServlet
 *
 */
 public class InvalidateSessionServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		new LoginService().invalidateSessionAction(request, getServletContext());
	}   	  	    
}
