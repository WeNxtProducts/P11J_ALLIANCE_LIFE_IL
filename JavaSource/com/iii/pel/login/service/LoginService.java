package com.iii.pel.login.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.SimpleConnectionAgent;

public class LoginService {
	
	public void invalidateSessionAction(HttpServletRequest request, ServletContext context){
		Connection connection = (Connection) request.getSession().getAttribute("CONNECTION.LOGIN");
		if(connection!=null)
			try {
				connection.rollback();
				connection.close();
				System.out.println("closed connection");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		String clientId = (String) request.getSession().getAttribute("CLIENT_ID");
		try {
			((SimpleConnectionAgent) context.getAttribute("connectionAgent")).getConnection(clientId).rollback();
			((SimpleConnectionAgent) context.getAttribute("connectionAgent")).close(clientId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getSession().invalidate();
		System.out.println("Session invalidated");
	}

}
