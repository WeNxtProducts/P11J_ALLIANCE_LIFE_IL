package com.iii.pel.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.login.model.MenuToolbar;
import com.iii.pel.login.model.PremiaMenu;

/**
 * Servlet implementation class for Servlet: MenuPaginationServlet
 *
 */

@Deprecated
 public class MenuPaginationServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageIndex = request.getParameter("page");
		String menuLevel = request.getParameter("level");
		PremiaMenu premiaMenu = (PremiaMenu) request.getSession().getAttribute("premiaMenu");
		MenuToolbar menuToolbar = null;
		if(menuLevel.equals("1")){
			menuToolbar = premiaMenu.getMenuOne();
		}else if(menuLevel.equals("2")){
			menuToolbar = premiaMenu.getMenuTwo();	
		}else if(menuLevel.equals("3")){
			menuToolbar = premiaMenu.getMenuThree();
		}
		int start = menuToolbar.getStart();
		if(pageIndex.equals("left")){
			menuToolbar.setStart(start-1);
		}else if(pageIndex.equals("right")){
			menuToolbar.setStart(start+1);
		}
		String forwardTo = (String) request.getSession().getAttribute("MENU_ID_SCREEN_NAME");
		request.getRequestDispatcher(forwardTo).forward(request, response);
	}   	  	    
}
