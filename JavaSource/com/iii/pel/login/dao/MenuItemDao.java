package com.iii.pel.login.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.commonimpl.pmenuimpl.PMenuItem;
import com.iii.pel.login.model.DropDownItem;
import com.iii.pel.login.model.MenuBuilder;
import com.iii.pel.login.model.MenuParameter;
import com.iii.pel.login.model.MenuSearchBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class MenuItemDao {

	public ArrayList<MenuBuilder> getMenuNodes(String userGroup,
			String parentId, String nodeLevel, HttpServletRequest request) {
		Connection connection = null;
		ArrayList<MenuBuilder> menuBuilderList = null;
		MenuBuilder menuBuilder = null;
		String selectQuery = "SELECT MENU_ID, MENU_SCR_NAME, INITCAP(MENU_OPTION_DESC), MENU_ACTION, "
				+ "MENU_ACTION_TYPE, MENU_PARENT_ID, MENU_DISP_SEQ_NO "
				+ "FROM MENU_MENUS "
				+ "WHERE MENU_PARENT_ID=? "
				+ "AND MENU_ID IN ("
				+ "SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE  UM_GROUP_ID = ?) "
				+ "ORDER BY MENU_DISP_SEQ_NO";
		Object[] values = {parentId, userGroup};
		System.out.println(selectQuery);
		CRUDHandler crudHandler = new CRUDHandler();
		ResultSet rst = null;
		try {
			connection = ConnectionManager.getConnection(request);
			rst = crudHandler.executeSelectStatement(selectQuery,
					connection, values);
			menuBuilderList = new ArrayList<MenuBuilder>();
			while (rst.next()) {
				menuBuilder = new MenuBuilder();
				menuBuilder.setName(rst.getString(3));
				menuBuilder.setNodeLevel(nodeLevel);
				menuBuilder.setParent(rst.getString("MENU_PARENT_ID"));
				menuBuilder.setPopup(rst.getString("MENU_ACTION_TYPE"));
				menuBuilder.setScreenId(rst.getString("MENU_ID"));
				menuBuilder.setNodeId(rst.getString("MENU_ACTION"));
				menuBuilderList.add(menuBuilder);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return menuBuilderList;
	}

	public ArrayList<MenuBuilder> getMenuItem(String userGroup,
			String parentId, String nodeLevel, javax.servlet.http.HttpServletRequest request) {
		Connection connection = null;
		MenuBuilder menuBuilder = null;
		ArrayList<MenuBuilder> menuBuilderList = null;
		CRUDHandler crudHandler = new CRUDHandler();
		String queryString = "SELECT MENU_ID, MENU_SCR_NAME, INITCAP(MENU_OPTION_DESC), MENU_ACTION, MENU_ACTION_TYPE, "
				+ "MENU_PARENT_ID, MENU_DISP_SEQ_NO "
				+ "FROM MENU_MENUS WHERE MENU_PARENT_ID = ? AND MENU_ID IN ("
				+ "SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE  UM_GROUP_ID = ?) " +
						"ORDER BY MENU_DISP_SEQ_NO";
		System.out.println(queryString);
		System.out.println(parentId+"     "+userGroup);
		Object[] values = {parentId, userGroup};
		ResultSet rst = null;
		try {
			connection = ConnectionManager.getConnection(request);
			rst = crudHandler.executeSelectStatement(queryString,connection, values);
			menuBuilderList = new ArrayList<MenuBuilder>();
			while (rst.next()) {
				menuBuilder = new MenuBuilder();
				menuBuilder.setName(rst.getString(3));
				String menuLevel = new Integer(Integer.parseInt(nodeLevel) + 1)
						.toString();
				menuBuilder.setNodeLevel(menuLevel);
				menuBuilder.setParent(rst.getString("MENU_PARENT_ID"));
				menuBuilder.setPopup(rst.getString("MENU_ACTION_TYPE"));
				menuBuilder.setScreenId(rst.getString("MENU_ID"));
				menuBuilder.setNodeId(rst.getString("MENU_ACTION"));
				menuBuilderList.add(menuBuilder);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return menuBuilderList;
	}

	public ArrayList<DropDownItem> getDropDownItem(String userGroup,
			String parentId, String nodeLevel, HttpServletRequest request) {
		Connection connection = null;
		DropDownItem dropDownItem = null;
		ArrayList<DropDownItem> dropDownItemList = null;
		CRUDHandler crudHandler = new CRUDHandler();
		String queryString = "SELECT MENU_ID, MENU_SCR_NAME, INITCAP(MENU_OPTION_DESC), MENU_ACTION_TYPE, "
				+ "MENU_PARENT_ID, MENU_DISP_SEQ_NO "
				+ "FROM MENU_MENUS WHERE MENU_PARENT_ID = ? AND MENU_ID IN ("
				+ "SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE  UM_GROUP_ID = ?) " +
						"ORDER BY MENU_DISP_SEQ_NO";
		Object[] values = {parentId, userGroup};
		ResultSet rst = null;
		try {
			connection = ConnectionManager.getConnection(request);
			rst = crudHandler.executeSelectStatement(queryString,
					connection, values);
			dropDownItemList = new ArrayList<DropDownItem>();
			while (rst.next()) {
				dropDownItem = new DropDownItem();
				String menuScreenId = rst.getString("MENU_ID");
				String menuNodeId = rst.getString("MENU_ACTION");
				dropDownItem.setName(rst.getString(3));
				String menuLevel = new Integer(Integer.parseInt(nodeLevel) + 1)
						.toString();
				dropDownItem.setNodeLevel(menuLevel);
				dropDownItem.setParent(rst.getString("MENU_PARENT_ID"));
				String actionType = rst.getString("MENU_ACTION_TYPE");
				dropDownItem.setPopup(actionType);
				dropDownItem.setScreenId(menuScreenId);
				dropDownItem.setNodeId(menuNodeId);
				ArrayList<MenuBuilder> menuBuilderList = null;
				if (!actionType.equals("U")) {
					menuBuilderList = getMenuItem(userGroup, menuScreenId,
							menuLevel, request);
				}
				if (menuBuilderList != null) {
					if (menuBuilderList.size() > 0)
						dropDownItem.setMenuItemList(menuBuilderList);
					else
						dropDownItem.setMenuItemList(null);
				} else
					dropDownItem.setMenuItemList(null);
				dropDownItemList.add(dropDownItem);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dropDownItemList;
	}

	public MenuParameter getMenuParameters(String menuId, String userGroup, HttpServletRequest request) {
		String selectQuery = " SELECT MENU_ACTION, MENU_PARAMETER_1, MENU_PARAMETER_2,MENU_PARAMETER_3, "
				+ " MENU_PARAMETER_4,MENU_PARAMETER_5, MENU_PARAMETER_6,MENU_PARAMETER_7, MENU_PARAMETER_8, "
				+ " MENU_PARAMETER_9, MENU_PARAMETER_10,MENU_PARAMETER_11, MENU_PARAMETER_12,MENU_PARAMETER_13, "
				+ " MENU_PARAMETER_14,MENU_PARAMETER_15, MENU_PARAMETER_16,MENU_PARAMETER_17, "
				+ " MENU_PARAMETER_18,MENU_PARAMETER_19, MENU_PARAMETER_20,INITCAP(MENU_OPTION_DESC) MENU_OPT_DESC "
				+ " FROM MENU_MENUS,MENU_USER_MENUS "
				+ " WHERE UM_MENU_ID=MENU_ID AND MENU_ID=? AND UM_GROUP_ID=? ";
		Object[] values = {menuId, userGroup};
		Connection connection = null;
		CRUDHandler handler = null;
		MenuParameter menuParameter = null;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rst = handler.executeSelectStatement(selectQuery,
					connection, values);
			while (rst.next()) {
				menuParameter = new MenuParameter();
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
				menuParameter.setMENU_OPTION_DESC(rst
						.getString("MENU_OPT_DESC"));
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

	public String getMenuScreen(String menuId, HttpServletRequest request) {
		String screenName = null;
		Connection connection = null;
		CRUDHandler handler = null;
		String selectQuery = "SELECT MSM_MENU_SCREEN FROM MENU_SCREEN_MASTER WHERE MSM_MENU_ID=?";
		Object[] values = {menuId};
		ResultSet rst = null;
		try {
			connection = ConnectionManager.getConnection(request);
			handler = new CRUDHandler();
			rst = handler.executeSelectStatement(selectQuery,
					connection, values);
			while (rst.next()) {
				screenName = rst.getString("MSM_MENU_SCREEN");
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
		return screenName;
	}

	public void setGlobalParameters(HttpServletRequest request) {
		Connection connection = null;
		CallableStatement callable = null;
		try {
			connection = ConnectionManager.getConnection(request);
			callable = connection
					.prepareCall("call PCOPK_SYS_VARS.P_SET_PARA_VALUES(?,?,?,?,?,?,?,?,?)");
			callable.setString(1, "ENG");
			callable.setString(2, "");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getScreenName(String screenId, HttpServletRequest request){
		String screenName = null;
		Connection connection = null;
		String selectQuery = "SELECT MSM_MENU_SCREEN FROM MENU_SCREEN_MASTER WHERE MSM_MENU_ID=?";
		Object[] values = {screenId};
		CRUDHandler handler = null;
		ResultSet rst = null;
		try {
			connection = ConnectionManager.getConnection(request);
			handler = new CRUDHandler();
			rst = handler.executeSelectStatement(selectQuery, connection, values);
			while(rst.next()){
				screenName = rst.getString("MSM_MENU_SCREEN");
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
		return screenName;
	}
	
	public List<MenuSearchBean> getMenuActionScreenList(HttpServletRequest request, String userGroup, String screenName, String parentId){
		if(screenName!=null){
			if(screenName.equals("*"))
				screenName = "%";
			else
				screenName += "%";
		}
		String query = "SELECT DISTINCT MENU_ID,MENU_SCR_NAME,INITCAP(MENU_OPTION_DESC)," +
				"MENU_ACTION_TYPE,MENU_ACTION,MENU_PARENT_ID " +
				"FROM MENU_MENUS " +
				"WHERE MENU_ACTION_TYPE = 'U' " +
				"AND MENU_ACTION IS NOT NULL " +
				"AND MENU_ID IN(" +
				"SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE UM_GROUP_ID = ?) " +
				"AND INITCAP(MENU_OPTION_DESC) LIKE INITCAP(?) " +
				"START WITH MENU_PARENT_ID = ? " +
				"CONNECT BY PRIOR MENU_ID = MENU_PARENT_ID " +
				"ORDER BY INITCAP(MENU_OPTION_DESC)";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet rst = null;
		List<MenuSearchBean> menuActionScreenList = null;
		try {
			connection = ConnectionManager.getConnection(request);
			rst = handler.executeSelectStatement(query, connection, new Object[]{userGroup, screenName, parentId});
			menuActionScreenList = new ArrayList<MenuSearchBean>();
			while(rst.next()){
				MenuSearchBean searchBean = new MenuSearchBean();
				searchBean.setMENU_ID(rst.getString("MENU_ID"));
				searchBean.setMENU_SCR_NAME(rst.getString("MENU_SCR_NAME"));
				searchBean.setMENU_OPTION_DESC(rst.getString("INITCAP(MENU_OPTION_DESC)"));
				searchBean.setMENU_ACTION_TYPE(rst.getString("MENU_ACTION_TYPE"));
				searchBean.setMENU_ACTION(rst.getString("MENU_ACTION"));
				searchBean.setMENU_PARENT_ID(rst.getString("MENU_PARENT_ID"));
				menuActionScreenList.add(searchBean);
			}
		} catch (Exception e) {
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
		return menuActionScreenList;
	}
	
	public String getMenuIdPath(HttpServletRequest request, String menuId, String parentId){
		String connectPath = null;
		String query = "SELECT SYS_CONNECT_BY_PATH(MENU_ID,',') " +
				"FROM   MENU_MENUS " +
				"WHERE MENU_ID=? " +
				"START WITH MENU_PARENT_ID = ? " +
				"CONNECT BY PRIOR MENU_ID = MENU_PARENT_ID";
		if(menuId!=null){
			Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			ResultSet rst = null;
			try {
				connection = ConnectionManager.getConnection(request);
				rst = handler.executeSelectStatement(query, connection, new Object[]{menuId, parentId});
				while(rst.next()){
					connectPath = rst.getString(1);
				}
			} catch (Exception e) {
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
				}
			}
			
		}
		return connectPath;
	}

	// [ Added for new Premia Menu
	public ArrayList<PMenuItem> buildMenuTree(String userGroup, String parentId, String moduleId) throws Exception{
		ArrayList<PMenuItem> menuItemList = new ArrayList<PMenuItem>();
		Iterator<PMenuItem> childIteartor = null;
		PMenuItem menuItem = null;

		menuItemList = getMenuItems(userGroup, parentId, moduleId);
		childIteartor = menuItemList.iterator();
		while(childIteartor.hasNext()){
			menuItem = childIteartor.next();
			// Iterate for the child menu
			menuItem.setChildren(buildMenuTree(userGroup, menuItem.getMenuId(), moduleId));
		}
		
		return menuItemList;
	}
	
	public ArrayList<PMenuItem> getMenuItems(String userGroup,
			String parentId,
			String moduleId) throws Exception {
		Connection connection = null;
		PMenuItem menuItem = null;
		ArrayList<PMenuItem> menuItemList = null;
		CRUDHandler crudHandler = new CRUDHandler();
		/*Changed by Ram on 08/12/2016 for Menu Display from DB control
		 * 
		 * String queryString = "SELECT MENU_ID, MENU_SCR_NAME, INITCAP(MENU_OPTION_DESC), MENU_ACTION_TYPE, MENU_ACTION, "
				+ "MENU_PARENT_ID, MENU_DISP_SEQ_NO, MENU_ICON_PATH "
				//+ "FROM MENU_MENUS WHERE MENU_PARENT_ID = ? AND MENU_MODULE_ID IN (?,?) AND MENU_ID IN ("
				+ "FROM MENU_MENUS WHERE MENU_PARENT_ID = ? AND MENU_MODULE_ID = ? AND MENU_ID IN ("
				+ "SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE  UM_GROUP_ID = ?) " +
						"ORDER BY MENU_DISP_SEQ_NO";*/
		
		
		String queryString = "SELECT MENU_ID, MENU_SCR_NAME, (MENU_OPTION_DESC), MENU_ACTION_TYPE, MENU_ACTION, "
				+ "MENU_PARENT_ID, MENU_DISP_SEQ_NO, MENU_ICON_PATH "
				//+ "FROM MENU_MENUS WHERE MENU_PARENT_ID = ? AND MENU_MODULE_ID IN (?,?) AND MENU_ID IN ("
				+ "FROM MENU_MENUS WHERE MENU_PARENT_ID = ? AND MENU_MODULE_ID = ? AND MENU_ID IN ("
				+ "SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE  UM_GROUP_ID = ?) " +
						"ORDER BY MENU_DISP_SEQ_NO";
		Object[] values = {parentId, 
				moduleId,
				//PELConstants.MENU_COMMON_MODULE_ID,
				userGroup};
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			rst = crudHandler.executeSelectStatement(queryString,
					connection, values);
			menuItemList = new ArrayList<PMenuItem>();
			while (rst.next()) {
				menuItem = new PMenuItem();
				menuItem.setMenuId(rst.getString("MENU_ID"));
				menuItem.setMenuScrName(rst.getString("MENU_SCR_NAME"));
				menuItem.setMenuOptionDesc(rst.getString(3));
				menuItem.setMenuActionType(rst.getString("MENU_ACTION_TYPE"));
				menuItem.setMenuAction(rst.getString("MENU_ACTION"));
				menuItem.setMenuParentId(rst.getString("MENU_PARENT_ID"));
				menuItem.setMenuDispSeqNo(rst.getInt("MENU_DISP_SEQ_NO"));
				menuItem.setMenuIconPath(rst.getString("MENU_ICON_PATH"));
				menuItemList.add(menuItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {CommonUtils.closeCursor(rst);} catch (Exception e) {}

		}
		return menuItemList;
	}
	
	public ArrayList<PMenuItem> getSearchMenuList(String screenName,
			String userGroup, 
			String topLevelParentId, 
			String moduleId) throws Exception{
		
		if(screenName!=null){
			if(screenName.equals("*"))
				screenName = "%";
			else
				screenName += "%";
		}
		/*String query = "SELECT DISTINCT MENU_ID, "+ //MENU_SCR_NAME, INITCAP(MENU_OPTION_DESC)," +
				//"MENU_ACTION_TYPE,MENU_ACTION,MENU_PARENT_ID " +
				"INITCAP(MENU_OPTION_DESC) || '-' || SYS_CONNECT_BY_PATH(INITCAP(MENU_OPTION_DESC),'>')  MENU_PATH " +
				"FROM MENU_MENUS " +
				"WHERE MENU_ACTION_TYPE = 'U' " +
				"AND MENU_ACTION IS NOT NULL " +
				"AND MENU_MODULE_ID IN (?,?) "+
				"AND MENU_ID IN(" +
				"SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE UM_GROUP_ID = ?) " +
				"AND UPPER(MENU_OPTION_DESC) LIKE UPPER(?) AND ROWNUM <= ? " +
				"START WITH MENU_PARENT_ID = ? " +
				"CONNECT BY PRIOR MENU_ID = MENU_PARENT_ID " +
				"ORDER BY MENU_PATH ";*/
		String query = "SELECT DISTINCT MENU_ID, " + //MENU_SCR_NAME,INITCAP(MENU_OPTION_DESC), +
			//"MENU_ACTION_TYPE,MENU_ACTION,MENU_PARENT_ID + 
			"INITCAP(MENU_OPTION_DESC) || '-' || SYS_CONNECT_BY_PATH(INITCAP(MENU_OPTION_DESC),'>')  MENU_PATH " +
			"FROM MENU_MENUS " +
			"WHERE MENU_ACTION_TYPE = 'U' " +
			"AND MENU_ACTION IS NOT NULL " +
			"AND MENU_MODULE_ID IN (?,?) " +
			"AND MENU_ID IN(SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE UM_GROUP_ID = ?) " +
			"AND UPPER(MENU_OPTION_DESC) LIKE UPPER(?) AND ROWNUM <= ? " +
			"START WITH MENU_PARENT_ID = ? " +
			"CONNECT BY PRIOR MENU_ID = MENU_PARENT_ID " +
			//"ORDER BY MENU_PATH " +
			"UNION " +
			"SELECT DISTINCT MENU_ID, " +  //MENU_SCR_NAME,INITCAP(MENU_OPTION_DESC), " +
			//"MENU_ACTION_TYPE,MENU_ACTION,MENU_PARENT_ID " +
			"INITCAP(MENU_OPTION_DESC) || '-' || SYS_CONNECT_BY_PATH(INITCAP(MENU_OPTION_DESC),'>')  MENU_PATH " +
			"FROM MENU_MENUS " +
			"WHERE MENU_ACTION_TYPE = 'U' " +
			"AND MENU_ACTION IS NOT NULL " +
			//"AND MENU_MODULE_ID IN (?,?) " +
			"AND MENU_MODULE_ID = ? " +
			"AND MENU_ID IN(SELECT UM_MENU_ID FROM MENU_USER_MENUS WHERE UM_GROUP_ID = ?) " +
			"AND UPPER(MENU_OPTION_DESC) LIKE UPPER(?) AND ROWNUM <= ? " + 
			"START WITH MENU_PARENT_ID = ? " +
			"CONNECT BY PRIOR MENU_ID = MENU_PARENT_ID " +
			"ORDER BY MENU_PATH ";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet rst = null;
		ArrayList<PMenuItem> menuActionScreenList = null;
		Object[] values = null;
		
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{moduleId, 
					PELConstants.MENU_COMMON_MODULE_ID,
					userGroup, 
					screenName, 
					PELConstants.suggetionRecordSize,
					topLevelParentId,
					
					PELConstants.MENU_COMMON_MODULE_ID,
					userGroup, 
					screenName,
					PELConstants.suggetionRecordSize,
					PELConstants.MENU_COMMON_TOP_LEVEL_PARENT_ID
					};
			rst = handler.executeSelectStatement(query, connection, values);
			menuActionScreenList = new ArrayList<PMenuItem>();
			while(rst.next()){
				PMenuItem searchBean = new PMenuItem();
				searchBean.setMenuId(rst.getString("MENU_ID"));
				//searchBean.setMenuScrName(rst.getString("MENU_SCR_NAME"));
				//searchBean.setMenuOptionDesc(rst.getString("INITCAP(MENU_OPTION_DESC)"));
				searchBean.setMenuOptionDesc(rst.getString("MENU_PATH"));
				//searchBean.setMenuActionType(rst.getString("MENU_ACTION_TYPE"));
				//searchBean.setMenuAction(rst.getString("MENU_ACTION"));
				//searchBean.setMenuParentId(rst.getString("MENU_PARENT_ID"));
				menuActionScreenList.add(searchBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {
			try {CommonUtils.closeCursor(rst);} catch (Exception e){}
		}
		return menuActionScreenList;
	}

	public PMenuItem getMenuDetails(String menuId, String userGroup, String moduleId) {
		String selectQuery = "SELECT MENU_MENUS.* "
				+ "FROM MENU_MENUS, MENU_USER_MENUS "
				+ "WHERE UM_MENU_ID=MENU_ID AND MENU_ID=? AND UM_GROUP_ID=? AND MENU_MODULE_ID=? "; 
		
			/*"SELECT MENU_ACTION, MENU_PARAMETER_1, MENU_PARAMETER_2,MENU_PARAMETER_3, "
				+ "MENU_PARAMETER_4,MENU_PARAMETER_5, MENU_PARAMETER_6,MENU_PARAMETER_7, MENU_PARAMETER_8,"
				+ "MENU_PARAMETER_9, MENU_PARAMETER_10,MENU_PARAMETER_11, MENU_PARAMETER_12,MENU_PARAMETER_13, "
				+ "MENU_PARAMETER_14,MENU_PARAMETER_15, MENU_PARAMETER_16,MENU_PARAMETER_17, "
				+ "MENU_PARAMETER_18,MENU_PARAMETER_19, MENU_PARAMETER_20 "
				+ "FROM MENU_MENUS, MENU_USER_MENUS "
				+ "WHERE UM_MENU_ID=MENU_ID AND MENU_ID=? AND UM_GROUP_ID=? AND MENU_MODULE_ID=? ";*/
		Object[] values = {menuId, userGroup, moduleId};
		Connection connection = null;
		CRUDHandler handler = null;
		PMenuItem menuItem = null;
		ResultSet rst = null;
		
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rst = handler.executeSelectStatement(selectQuery,
					connection, values);
			
			while (rst.next()) {
				menuItem = new PMenuItem();
				menuItem.setMenuAction(rst.getString("MENU_ACTION"));
				menuItem.setMenuParameter1(rst.getString("MENU_PARAMETER_1"));
				menuItem.setMenuParameter2(rst.getString("MENU_PARAMETER_2"));
				menuItem.setMenuParameter3(rst.getString("MENU_PARAMETER_3"));
				menuItem.setMenuParameter4(rst.getString("MENU_PARAMETER_4"));
				menuItem.setMenuParameter5(rst.getString("MENU_PARAMETER_5"));
				menuItem.setMenuParameter6(rst.getString("MENU_PARAMETER_6"));
				menuItem.setMenuParameter7(rst.getString("MENU_PARAMETER_7"));
				menuItem.setMenuParameter8(rst.getString("MENU_PARAMETER_8"));
				menuItem.setMenuParameter9(rst.getString("MENU_PARAMETER_9"));
				menuItem.setMenuParameter10(rst.getString("MENU_PARAMETER_10"));
				/*menuItem.setMenuParameter11(rst.getString("MENU_PARAMETER_11"));
				menuItem.setMenuParameter12(rst.getString("MENU_PARAMETER_12"));
				menuItem.setMenuParameter13(rst.getString("MENU_PARAMETER_13"));
				menuItem.setMenuParameter14(rst.getString("MENU_PARAMETER_14"));
				menuItem.setMenuParameter15(rst.getString("MENU_PARAMETER_15"));
				menuItem.setMenuParameter16(rst.getString("MENU_PARAMETER_16"));
				menuItem.setMenuParameter17(rst.getString("MENU_PARAMETER_17"));
				menuItem.setMenuParameter18(rst.getString("MENU_PARAMETER_18"));
				menuItem.setMenuParameter19(rst.getString("MENU_PARAMETER_19"));
				menuItem.setMenuParameter20(rst.getString("MENU_PARAMETER_20"));*/
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
		return menuItem;
	}

	// Added for new Premia Menu ]
}
