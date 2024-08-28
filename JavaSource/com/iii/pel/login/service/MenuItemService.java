package com.iii.pel.login.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iii.pel.login.dao.MenuItemDao;
import com.iii.pel.login.model.DropDownItem;
import com.iii.pel.login.model.DropDownMenu;
import com.iii.pel.login.model.MenuBuilder;
import com.iii.pel.login.model.MenuParameter;
import com.iii.pel.login.model.MenuToolbar;
import com.iii.pel.login.util.PropertyManager;

public class MenuItemService {
	
	public MenuToolbar getMenuNode(String userGroup, String parentId, String nodeLevel, HttpServletRequest request){
		MenuItemDao menuItemDao = new MenuItemDao();
		ArrayList<MenuBuilder> menuBuilderList = menuItemDao.getMenuNodes(userGroup, parentId, nodeLevel, request);
		MenuToolbar menuToolbar = new MenuToolbar();
		menuToolbar.setMenuItemList(menuBuilderList);
		return menuToolbar;
	}
	
	public MenuToolbar getMenuItem(String userGroup, String parentId, String nodeLevel, HttpServletRequest request){
		MenuItemDao menuItemDao = new MenuItemDao();
		ArrayList<MenuBuilder> menuItemList = menuItemDao.getMenuItem(userGroup, parentId, nodeLevel, request);
		MenuToolbar menuToolbar = new MenuToolbar();
		menuToolbar.setMenuItemList(menuItemList);
		return menuToolbar;
	}
	
	public ArrayList<DropDownMenu> getDropDownMenu(String userGroup, ArrayList<MenuBuilder> menuItemList, HttpServletRequest request){
		MenuItemDao menuItemDao = null;
		DropDownMenu dropDownMenu = null;
		ArrayList<DropDownMenu> dropDownMenuList = new ArrayList<DropDownMenu>();
		for(int i=0;i<menuItemList.size();i++){
			MenuBuilder menuBuilder = menuItemList.get(i);
			String screenId = menuBuilder.getScreenId();
			String nodeId = menuBuilder.getNodeId();
			String nodeLevel = menuBuilder.getNodeLevel();
			menuItemDao = new MenuItemDao();
			dropDownMenu = new DropDownMenu();
			ArrayList<DropDownItem> dropDownItemList = menuItemDao.getDropDownItem(userGroup, nodeId, nodeLevel, request);
			dropDownMenu.setScreenId(screenId);
			dropDownMenu.setToolbarList(dropDownItemList);
			dropDownMenuList.add(dropDownMenu);
		}
		return dropDownMenuList;
	}
	
	public ArrayList<String> getDropDownList(ArrayList<DropDownMenu> dropDownMenuList){
		ArrayList<String> dropDownScreenIdList = null;
		if(dropDownMenuList!=null){
			if(dropDownMenuList.size()>0){
				dropDownScreenIdList = new ArrayList<String>();
				Iterator<DropDownMenu> dropDownMenuItr = dropDownMenuList.iterator();
				while(dropDownMenuItr.hasNext()){
					DropDownMenu dropDownMenuBean = dropDownMenuItr.next();
					String screenId = dropDownMenuBean.getScreenId();
					ArrayList<DropDownItem> dropDownListItem = dropDownMenuBean.getToolbarList();
					if(screenId!=null)
						if(dropDownListItem!=null)
							if(dropDownListItem.size()>0)
								dropDownScreenIdList.add(screenId);
				}
			}
		}
		return dropDownScreenIdList;
	}
	
	public MenuParameter getMenuParameter(String screenId, String userGroup, HttpServletRequest request){
		MenuItemDao menuDao = new MenuItemDao();
		return menuDao.getMenuParameters(screenId, userGroup, request);
	}
	
	public String getScreenName(String screenId, HttpServletRequest request){
		return new MenuItemDao().getMenuScreen(screenId, request);
	}
	
	public List<String> menuConnectingPath(HttpServletRequest request, String screenId){
		String connectingPath = new MenuItemDao().getMenuIdPath(request, screenId, PropertyManager.getValue("pel_menu_level"));
		List<String> menuIdList = null;
		if(connectingPath!=null){
			String[] menuIdArray = connectingPath.split(",");
			menuIdList = new ArrayList<String>();
			for(int i=0;i<menuIdArray.length;i++){
				if(!menuIdArray[i].trim().isEmpty()){
					menuIdList.add(menuIdArray[i]);
				}
			}
		}
		return menuIdList;
	}

}
