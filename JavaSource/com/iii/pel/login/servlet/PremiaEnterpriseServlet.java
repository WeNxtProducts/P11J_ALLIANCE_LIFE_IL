package com.iii.pel.login.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.login.model.MenuParameter;
import com.iii.pel.login.service.MenuItemService;

/**
 * Servlet implementation class for Servlet: PremiaEnterpriseServlet
 *
 */

@Deprecated
 public class PremiaEnterpriseServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
   static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MenuItemService menuService = new MenuItemService();
		String screenId = request.getParameter("screenId");
		System.out.println("PremiaEnterpriseServlet: "+screenId);
		String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		String jspPageName = null;
		if(screenId!=null){
 			jspPageName = menuService.getScreenName(screenId, request);
			deallocateSessionObject(request, response);
			if(jspPageName!=null)
				request.getSession().setAttribute("MENU_ID_SCREEN_NAME", jspPageName);
			MenuParameter menuParameter = menuService.getMenuParameter(screenId, userGroup, request);

			/*
			 * Added by Kavitha for Ref.
			 * IL MENU PARAMETERS
			  *****************
				POLICY DOCUMENT SETUP CODE -- MENU_PARAMETER_1
				POLICY CLASS CODE  -- MENU_PARAMETER_2
				POLICY PLAN CODE -- MENU_PARAMETER_3
				POLICY COVER CODE -- MENU_PARAMETER_4
				POLICY MODE OF PAYMENT - MENU_PARAMETER_5
				POLICY PRODUCT CODE -- MENU_PARAMETER_6
				MORTGAGE POLICIES (X) --  MENU_PARAMETER_7
				REPRESENTS POLICY OR PROPOSAL -- MENU_PARAMETER_11
				POLICY OR PROPOSAL OR QUOTATION -- MENU_PARAMETER_13
				FROM 12 REPORT NAMES --  MENU_PARAMETER_12
				PACKAGE POLICY OR NORMAL BY USING PRODUCT CODE -- MENU_PARAMETER_18
				
			*/
			
			if(menuParameter!=null){
				request.getSession().setAttribute("MENU.MENU_PARAMETER_1", menuParameter.getMENU_PARAMETER_1());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_2", menuParameter.getMENU_PARAMETER_2());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_3", menuParameter.getMENU_PARAMETER_3());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_4", menuParameter.getMENU_PARAMETER_4());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_5", menuParameter.getMENU_PARAMETER_5());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_6", menuParameter.getMENU_PARAMETER_6());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_7", menuParameter.getMENU_PARAMETER_7());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_8", menuParameter.getMENU_PARAMETER_8());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_9", menuParameter.getMENU_PARAMETER_9());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_10", menuParameter.getMENU_PARAMETER_10());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_11", menuParameter.getMENU_PARAMETER_11());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_12", menuParameter.getMENU_PARAMETER_12());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_13", menuParameter.getMENU_PARAMETER_13());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_14", menuParameter.getMENU_PARAMETER_14());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_15", menuParameter.getMENU_PARAMETER_15());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_16", menuParameter.getMENU_PARAMETER_16());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_17", menuParameter.getMENU_PARAMETER_17());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_18", menuParameter.getMENU_PARAMETER_18());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_19", menuParameter.getMENU_PARAMETER_19());
				request.getSession().setAttribute("MENU.MENU_PARAMETER_20", menuParameter.getMENU_PARAMETER_20());
				request.getSession().setAttribute("GLOBAL.M_PARAM_1", menuParameter.getMENU_PARAMETER_1());
				request.getSession().setAttribute("GLOBAL.M_PARAM_2", menuParameter.getMENU_PARAMETER_2());
				request.getSession().setAttribute("GLOBAL.M_PARAM_3", menuParameter.getMENU_PARAMETER_3());
				request.getSession().setAttribute("GLOBAL.M_PARAM_4", menuParameter.getMENU_PARAMETER_4());
				request.getSession().setAttribute("GLOBAL.M_PARAM_5", menuParameter.getMENU_PARAMETER_5());
				request.getSession().setAttribute("GLOBAL.M_PARAM_6", menuParameter.getMENU_PARAMETER_6());
				request.getSession().setAttribute("GLOBAL.M_PARAM_7", menuParameter.getMENU_PARAMETER_7());
				request.getSession().setAttribute("GLOBAL.M_PARAM_8", menuParameter.getMENU_PARAMETER_8());
				request.getSession().setAttribute("GLOBAL.M_PARAM_9", menuParameter.getMENU_PARAMETER_9());
				request.getSession().setAttribute("GLOBAL.M_PARAM_10", menuParameter.getMENU_PARAMETER_10());
				request.getSession().setAttribute("GLOBAL.M_PARAM_11", menuParameter.getMENU_PARAMETER_11());
				request.getSession().setAttribute("GLOBAL.M_PARAM_12", menuParameter.getMENU_PARAMETER_12());
				request.getSession().setAttribute("GLOBAL.M_PARAM_13", menuParameter.getMENU_PARAMETER_13());
				request.getSession().setAttribute("GLOBAL.M_PARAM_14", menuParameter.getMENU_PARAMETER_14());
				request.getSession().setAttribute("GLOBAL.M_PARAM_15", menuParameter.getMENU_PARAMETER_15());
				request.getSession().setAttribute("GLOBAL.M_PARAM_16", menuParameter.getMENU_PARAMETER_16());
				request.getSession().setAttribute("GLOBAL.M_PARAM_17", menuParameter.getMENU_PARAMETER_17());
				request.getSession().setAttribute("GLOBAL.M_PARAM_18", menuParameter.getMENU_PARAMETER_18());
				request.getSession().setAttribute("GLOBAL.M_PARAM_19", menuParameter.getMENU_PARAMETER_19());
				request.getSession().setAttribute("GLOBAL.M_PARAM_20", menuParameter.getMENU_PARAMETER_20());
				request.getSession().setAttribute("GLOBAL.M_MODULE_NAME", menuParameter.getMENU_ACTION());
			}
			request.getSession().setAttribute("CALLING_FORM", "");
		}
		System.out.println(jspPageName);
		/*if(jspPageName!=null){
			String temp = jspPageName;
			int len = jspPageName.length();
			temp = jspPageName.substring(0, len);
			jspPageName = temp+"p";
		}*/
		String forwardTo = (String) request.getSession().getAttribute("MENU_ID_SCREEN_NAME");
		System.out.println(forwardTo);
		if(forwardTo==null)
			forwardTo = "/jsf/jsp/home.jsp";
		request.getRequestDispatcher(forwardTo).forward(request, response);
	}   
	
	public void deallocateSessionObject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Enumeration<String> sessionAttr = request.getSession().getAttributeNames();
		String clientId = (String) request.getSession().getAttribute("CLIENT_ID");
		while(sessionAttr.hasMoreElements()){
			String sessionAttrName = sessionAttr.nextElement();
			System.out.print(sessionAttrName+"   >>>>>>>>>>>>>      ");
			if(!(sessionAttrName.equals("CONNECTION.LOGIN") || sessionAttrName.equals("ctrlbean") || 
					sessionAttrName.equals("username") || sessionAttrName.equals("premiaMenu") || 
					sessionAttrName.startsWith("GLOBAL.") || sessionAttrName.startsWith("DUMMY.") || 
					sessionAttrName.equals("connectionAgent") || sessionAttrName.startsWith("MENU") ||
					sessionAttrName.equals("CLIENT_ID") || sessionAttrName.equals(clientId))){
				request.getSession().removeAttribute((String)sessionAttrName);
				System.out.println("removed");
			}
			System.out.println();
		}
	}
}
