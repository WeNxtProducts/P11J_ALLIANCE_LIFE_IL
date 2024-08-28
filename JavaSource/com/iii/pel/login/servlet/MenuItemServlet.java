package com.iii.pel.login.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.login.constant.LoginConstant;
import com.iii.pel.login.model.DropDownMenu;
import com.iii.pel.login.model.MenuToolbar;
import com.iii.pel.login.model.PremiaMenu;
import com.iii.pel.login.service.MenuItemService;

/**
 * Servlet implementation class for Servlet: MenuItemServlet
 *
 */
@Deprecated
 public class MenuItemServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String screenId = request.getParameter("screenId");
		String nodeId = request.getParameter("nodeId");
		String nodeLevel = request.getParameter("nodeLevel");
		System.out.println("Node Level: "+nodeLevel);
		String userGroup = (String)request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		String servletPath = request.getServletPath();
		System.out.println("<<<<<<<<<<<<<<<<<ServletPath>>>>>>>>>>>>>>>>>>>>"+servletPath);
//		request.getSession().setAttribute("MENU_ID_SCREEN_NAME", servletPath);
		MenuItemService menuItemService = new MenuItemService();
		MenuToolbar menuToolbar = menuItemService.getMenuItem(userGroup, nodeId, nodeLevel, request);
		ArrayList toolbarList = menuToolbar.getMenuItemList();
		ArrayList<DropDownMenu> dropDownMenuList = null;
		ArrayList<String> dropDownScreenIdList = null;
		if(toolbarList!=null)
			if(nodeLevel.equals("2") && toolbarList.size()>0){
				dropDownMenuList = menuItemService.getDropDownMenu(userGroup, toolbarList, request);
				dropDownScreenIdList = menuItemService.getDropDownList(dropDownMenuList);
			}
		PremiaMenu premiaMenu = (PremiaMenu) request.getSession().getAttribute("premiaMenu");
		if(toolbarList!=null){
			if(toolbarList.size()>0){
				if(nodeLevel.equals("1")){
					MenuToolbar menuToolbarOne = premiaMenu.getMenuOne();
					menuToolbarOne.setActiveMenu(screenId);
					menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_2);
					premiaMenu.setMenuTwo(menuToolbar);
					premiaMenu.setMenuThree(null);
				}else if(nodeLevel.equals("2")){
					MenuToolbar menuToolbarTwo = premiaMenu.getMenuTwo();
					menuToolbarTwo.setActiveMenu(screenId);
					menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_3);
					premiaMenu.setMenuThree(menuToolbar);
					premiaMenu.setDropDownMenu(dropDownMenuList);
					if(dropDownScreenIdList!=null)
						if(dropDownScreenIdList.size()>0)
							premiaMenu.setDropDownScreenIdList(dropDownScreenIdList);
						else
							premiaMenu.setDropDownScreenIdList(null);
					else
						premiaMenu.setDropDownScreenIdList(null);
				}
				/*ControlBean controlBean = (ControlBean) request.getSession().getAttribute("ctrlbean");
				String menuId = controlBean.getM_MENU_ID();*/
				if(screenId!=null)
					request.getRequestDispatcher("PremiaEnterpriseServlet?screenId="+screenId).forward(request, response);
				else
					request.getRequestDispatcher("PremiaEnterpriseServlet").forward(request, response);
			}else{
				if(nodeLevel.equals("1")){
					MenuToolbar menuToolbarOne = premiaMenu.getMenuOne();
					menuToolbarOne.setActiveMenu(screenId);
					premiaMenu.setMenuTwo(null);
					premiaMenu.setMenuThree(null);
					premiaMenu.setDropDownMenu(null);
					premiaMenu.setDropDownScreenIdList(null);
				}else if(nodeLevel.equals("2")){
					MenuToolbar menuToolbarTwo = premiaMenu.getMenuTwo();
					menuToolbarTwo.setActiveMenu(screenId);
					premiaMenu.setMenuThree(null);
					premiaMenu.setDropDownMenu(null);
					premiaMenu.setDropDownScreenIdList(null);
				}
				request.getRequestDispatcher("PremiaEnterpriseServlet").forward(request, response);
			}
		}else{
			if(nodeLevel.equals("1")){
				MenuToolbar menuToolbarOne = premiaMenu.getMenuOne();
				menuToolbarOne.setActiveMenu(screenId);
				premiaMenu.setMenuTwo(null);
				premiaMenu.setMenuThree(null);
				premiaMenu.setDropDownMenu(null);
				premiaMenu.setDropDownScreenIdList(null);
			}else if(nodeLevel.equals("2")){
				MenuToolbar menuToolbarTwo = premiaMenu.getMenuTwo();
				menuToolbarTwo.setActiveMenu(screenId);
				premiaMenu.setMenuThree(null);
				premiaMenu.setDropDownMenu(null);
				premiaMenu.setDropDownScreenIdList(null);
			}
			request.getRequestDispatcher("PremiaEnterpriseServlet?screenId="+screenId+"&nodeId="+nodeId).forward(request, response);
		}
	}
	
}
