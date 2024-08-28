package com.iii.pel.login.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.login.constant.LoginConstant;
import com.iii.pel.login.model.MenuToolbar;
import com.iii.pel.login.model.PremiaMenu;
import com.iii.pel.login.service.MenuItemService;
import com.iii.pel.login.util.PropertyManager;

/**
 * Servlet implementation class for Servlet: MenuServlet
 *
 */
@Deprecated
 public class MenuServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuItemService menuItemService = new MenuItemService();
		String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		MenuToolbar menuToolbar = menuItemService.getMenuNode(userGroup, PropertyManager.getValue("pel_menu_level"), "1", request);
		menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_1);
		PremiaMenu premiaMenu = new PremiaMenu();
		premiaMenu.setMenuOne(menuToolbar);
		
		menuToolbar = new MenuToolbar();
		menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_2);
		premiaMenu.setMenuTwo(menuToolbar);
		
		menuToolbar = new MenuToolbar();
		menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_3);
		premiaMenu.setMenuThree(menuToolbar);
		
		request.getSession().setAttribute("premiaMenu", premiaMenu);
		String homePage = "/jsf/jsp/home.jsp";
		request.getSession().setAttribute("MENU_ID_SCREEN_NAME", homePage);
		request.getRequestDispatcher(homePage).forward(request, response);
	}   	  	    
}
