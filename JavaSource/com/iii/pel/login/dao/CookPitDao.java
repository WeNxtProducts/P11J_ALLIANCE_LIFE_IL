package com.iii.pel.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.login.model.MenuParameter;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class CookPitDao {
	
	public String getMenuAction(HttpSession session, ServletContext context, String menuId) {
		String menuAction = null;
		String query = "SELECT MENU_ACTION FROM MENU_MENUS WHERE MENU_ID = ?";
		if(menuId!=null){
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			ResultSet rst = null;
			try {
				connection = getConnection(session, context);
				rst = handler.executeSelectStatement(query, connection, new Object[]{menuId});
				while(rst.next()){
					menuAction = rst.getString(1);
				}
			} catch (Exception e) {
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
				}
			}
			
		}
		return menuAction;
	}
	
	public String getMenuScreenURL(HttpSession session, ServletContext context, String actionType) {
		String navigationScreen = null;
		String query = "SELECT MENU_NAVI_URL FROM MENU_MODULE_URL WHERE MENU_ACTION = ?";
		if(actionType!=null){
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			ResultSet rst = null;
			try {
				connection = getConnection(session, context);
				rst = handler.executeSelectStatement(query, connection, new Object[]{actionType});
				while(rst.next()){
					navigationScreen = rst.getString(1);
				}
			} catch (Exception e) {
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
				}
			}
			
		}
		return navigationScreen;
	}
	
	public Connection getConnection(HttpSession session, ServletContext context) throws DBException {
		Connection connectionCreate = null;
		String clientId = null;
		try {
			if(session != null){
				clientId = (String) session.getAttribute("CLIENT_ID");
				connectionCreate = ((SimpleConnectionAgent) context
						.getAttribute("connectionAgent")).getConnection(clientId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DBException("101", e.getMessage());
		}
		return connectionCreate;
	}
	
	public MenuParameter getCookPitMenuParameters(String menuId, String userGroup, HttpServletRequest request, ServletContext context) {
		String selectQuery = "SELECT MENU_SCR_NAME, MENU_ACTION, MENU_PARAMETER_1, MENU_PARAMETER_2,MENU_PARAMETER_3, "
				+ "MENU_PARAMETER_4,MENU_PARAMETER_5, MENU_PARAMETER_6,MENU_PARAMETER_7, MENU_PARAMETER_8,"
				+ "MENU_PARAMETER_9, MENU_PARAMETER_10,MENU_PARAMETER_11, MENU_PARAMETER_12,MENU_PARAMETER_13, "
				+ "MENU_PARAMETER_14,MENU_PARAMETER_15, MENU_PARAMETER_16,MENU_PARAMETER_17, "
				+ "MENU_PARAMETER_18,MENU_PARAMETER_19, MENU_PARAMETER_20 "
				+ "FROM MENU_MENUS, MENU_USER_MENUS "
				+ "WHERE UM_MENU_ID=MENU_ID AND MENU_ID=? AND UM_GROUP_ID=?";
		Object[] values = {menuId, userGroup};
		Connection connection = null;
		CRUDHandler handler = null;
		MenuParameter menuParameter = null;
		ResultSet rst = null;
		try {
			connection = getConnection(request.getSession(), context);
			handler = new CRUDHandler();
			rst = handler.executeSelectStatement(selectQuery,
					connection, values);
			while (rst.next()) {
				menuParameter = new MenuParameter();
//				menuParameter.setMENU_SCR_NAME(rst.getString(1));
				menuParameter.setMENU_ACTION(rst.getString("MENU_ACTION"));
				menuParameter.setMENU_PARAMETER_1(rst
						.getString("MENU_PARAMETER_1"));
				menuParameter.setMENU_PARAMETER_2(rst
						.getString("MENU_PARAMETER_2"));
				menuParameter.setMENU_PARAMETER_3(rst
						.getString("MENU_PARAMETER_3"));
				menuParameter.setMENU_PARAMETER_4(rst
						.getString("MENU_PARAMETER_4"));
				menuParameter.setMENU_PARAMETER_5(rst
						.getString("MENU_PARAMETER_5"));
				menuParameter.setMENU_PARAMETER_6(rst
						.getString("MENU_PARAMETER_6"));
				menuParameter.setMENU_PARAMETER_7(rst
						.getString("MENU_PARAMETER_7"));
				menuParameter.setMENU_PARAMETER_8(rst
						.getString("MENU_PARAMETER_8"));
				menuParameter.setMENU_PARAMETER_9(rst
						.getString("MENU_PARAMETER_9"));
				menuParameter.setMENU_PARAMETER_10(rst
						.getString("MENU_PARAMETER_10"));
				menuParameter.setMENU_PARAMETER_11(rst
						.getString("MENU_PARAMETER_11"));
				menuParameter.setMENU_PARAMETER_12(rst
						.getString("MENU_PARAMETER_12"));
				menuParameter.setMENU_PARAMETER_13(rst
						.getString("MENU_PARAMETER_13"));
				menuParameter.setMENU_PARAMETER_14(rst
						.getString("MENU_PARAMETER_14"));
				menuParameter.setMENU_PARAMETER_15(rst
						.getString("MENU_PARAMETER_15"));
				menuParameter.setMENU_PARAMETER_16(rst
						.getString("MENU_PARAMETER_16"));
				menuParameter.setMENU_PARAMETER_17(rst
						.getString("MENU_PARAMETER_17"));
				menuParameter.setMENU_PARAMETER_18(rst
						.getString("MENU_PARAMETER_18"));
				menuParameter.setMENU_PARAMETER_19(rst
						.getString("MENU_PARAMETER_19"));
				menuParameter.setMENU_PARAMETER_20(rst
						.getString("MENU_PARAMETER_20"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return menuParameter;
	}
	
	public String getProgramCode (HttpSession session, ServletContext context, String instanceCode) {
		String sql_C1 = "SELECT INST_PROG_CODE " +
				"FROM IM_INSTANCE " +
				"WHERE INST_CODE =  RTRIM(LTRIM(?))";
		ResultSet rst_C1 = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String programCode = null;
		try {
			connection = getConnection(session, context);
			handler = new CRUDHandler();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection,
					new Object[] {instanceCode});
			while (rst_C1.next()) {
				programCode = rst_C1.getString(1);
			}
			CommonUtils.closeCursor(rst_C1);
		} catch (Exception e) {
		} finally {
			try {
				CommonUtils.closeCursor(rst_C1);
			} catch (Exception e) {
			}
		}
		return programCode;
	}

}
