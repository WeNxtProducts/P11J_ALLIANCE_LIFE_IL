package com.iii.pel.login.service;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.pel.login.dao.CookPitDao;
import com.iii.pel.login.model.MenuParameter;

public class CookPitService {
	
	public String getMenuAction(HttpSession session, ServletContext context, String menuId) {
		return new CookPitDao().getMenuAction(session, context, menuId);
	}
	
	public String getMenuScreenURL(HttpSession session, ServletContext context, String actionType) {
		return new CookPitDao().getMenuScreenURL(session, context, actionType);
	}
	
	public MenuParameter getMenuParameter(String screenId, String userGroup, HttpServletRequest request, ServletContext context){
		CookPitDao menuDao = new CookPitDao();
		return menuDao.getCookPitMenuParameters(screenId, userGroup, request, context);
	}
	
	public String getProgramCode(HttpSession session, ServletContext context, String instanceCode) {
		return new CookPitDao().getProgramCode(session, context, instanceCode);
	}

}
