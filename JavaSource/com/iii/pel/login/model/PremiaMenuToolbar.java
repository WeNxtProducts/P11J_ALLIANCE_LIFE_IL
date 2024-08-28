package com.iii.pel.login.model;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ajax4jsf.component.html.HtmlAjaxCommandLink;
import org.richfaces.component.html.HtmlSuggestionBox;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.commonimpl.pmenuimpl.PMenuItem;
import com.iii.pel.commonimpl.pmenuimpl.UIPMenu;
import com.iii.pel.login.constant.LoginConstant;
import com.iii.pel.login.dao.MenuItemDao;
import com.iii.pel.login.service.LoginService;
import com.iii.pel.login.service.MenuItemService;
import com.iii.pel.login.util.PropertyManager;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PremiaMenuToolbar implements Serializable {
	
	private List<MenuBuilder> firstLevel;
	
	private List<MenuBuilder> secondLevel;
	
	private List<MenuBuilder> thirdLevel;
	
	private HtmlAjaxCommandLink FIRST_LEVEL_LT;
	
	private HtmlAjaxCommandLink FIRST_LEVEL_RT;
	
	private HtmlAjaxCommandLink SECOND_LEVEL_LT;
	
	private HtmlAjaxCommandLink SECOND_LEVEL_RT;
	
	private HtmlAjaxCommandLink THIRD_LEVEL_LT;
	
	private HtmlAjaxCommandLink THIRD_LEVEL_RT;
	
	private String MENU_LEVEL_1_SCRID;
	
	private String MENU_LEVEL_2_SCRID;
	
	private String MENU_LEVEL_3_SCRID;
	
	private boolean onLoadFlag = false;
	
	private String left = "<<";
	
	private String right = ">>";
	
	private String activeScreen;
	
	private NavigationParameter navigationParameter;
	
	private MenuSearchBean menuSearchBean;
	
	private List<MenuSearchBean> menuActionScreenList;
	
	private PremiaMenu premiaMenu;
	
	public PremiaMenu getPremiaMenu() {
		return premiaMenu;
	}

	public void setPremiaMenu(PremiaMenu premiaMenu) {
		this.premiaMenu = premiaMenu;
	}

	public PremiaMenuToolbar(){
		/*firstLevel = new ArrayList<MenuBuilder>();
		secondLevel = new ArrayList<MenuBuilder>();
		thirdLevel = new ArrayList<MenuBuilder>();
		navigationParameter = new NavigationParameter();
		menuSearchBean = new MenuSearchBean();
		premiaMenu = new PremiaMenu();
		firstLevel();*/
		
		// Prepare toolbar
		/*try {
			//menuSearchBean = new MenuSearchBean();
			toolBar = new HtmlToolBar();
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
			buildMenuList(userGroup, Messages.getString("login", "premia$menu$toplevel$parent"), toolBar);
			System.out.println("-----8<---- menu count: "+PremiaMenuToolbar.menucount);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		resetMenuDefault();
	}
	
	public String getActiveScreen() {
		return activeScreen;
	}

	public void setActiveScreen(String activeScreen) {
		this.activeScreen = activeScreen;
	}

	public boolean isOnLoadFlag() {
		return onLoadFlag;
	}

	public void setOnLoadFlag(boolean onLoadFlag) {
		this.onLoadFlag = onLoadFlag;
	}

	public List<MenuBuilder> getFirstLevel() {
		return firstLevel;
	}

	public void setFirstLevel(List<MenuBuilder> firstLevel) {
		this.firstLevel = firstLevel;
	}

	public List<MenuBuilder> getSecondLevel() {
		return secondLevel;
	}

	public void setSecondLevel(List<MenuBuilder> secondLevel) {
		this.secondLevel = secondLevel;
	}

	public List<MenuBuilder> getThirdLevel() {
		return thirdLevel;
	}

	public void setThirdLevel(List<MenuBuilder> thirdLevel) {
		this.thirdLevel = thirdLevel;
	}

	public HtmlAjaxCommandLink getFIRST_LEVEL_LT() {
		return FIRST_LEVEL_LT;
	}

	public void setFIRST_LEVEL_LT(HtmlAjaxCommandLink first_level_lt) {
		FIRST_LEVEL_LT = first_level_lt;
	}

	public HtmlAjaxCommandLink getFIRST_LEVEL_RT() {
		return FIRST_LEVEL_RT;
	}

	public void setFIRST_LEVEL_RT(HtmlAjaxCommandLink first_level_rt) {
		FIRST_LEVEL_RT = first_level_rt;
	}

	public HtmlAjaxCommandLink getSECOND_LEVEL_LT() {
		return SECOND_LEVEL_LT;
	}

	public void setSECOND_LEVEL_LT(HtmlAjaxCommandLink second_level_lt) {
		SECOND_LEVEL_LT = second_level_lt;
	}

	public HtmlAjaxCommandLink getSECOND_LEVEL_RT() {
		return SECOND_LEVEL_RT;
	}

	public void setSECOND_LEVEL_RT(HtmlAjaxCommandLink second_level_rt) {
		SECOND_LEVEL_RT = second_level_rt;
	}

	public HtmlAjaxCommandLink getTHIRD_LEVEL_LT() {
		return THIRD_LEVEL_LT;
	}

	public void setTHIRD_LEVEL_LT(HtmlAjaxCommandLink third_level_lt) {
		THIRD_LEVEL_LT = third_level_lt;
	}

	public HtmlAjaxCommandLink getTHIRD_LEVEL_RT() {
		return THIRD_LEVEL_RT;
	}

	public void setTHIRD_LEVEL_RT(HtmlAjaxCommandLink third_level_rt) {
		THIRD_LEVEL_RT = third_level_rt;
	}

	public String getMENU_LEVEL_1_SCRID() {
		return MENU_LEVEL_1_SCRID;
	}

	public void setMENU_LEVEL_1_SCRID(String menu_level_1_scrid) {
		MENU_LEVEL_1_SCRID = menu_level_1_scrid;
	}

	public String getMENU_LEVEL_2_SCRID() {
		return MENU_LEVEL_2_SCRID;
	}

	public void setMENU_LEVEL_2_SCRID(String menu_level_2_scrid) {
		MENU_LEVEL_2_SCRID = menu_level_2_scrid;
	}

	public String getMENU_LEVEL_3_SCRID() {
		return MENU_LEVEL_3_SCRID;
	}

	public void setMENU_LEVEL_3_SCRID(String menu_level_3_scrid) {
		MENU_LEVEL_3_SCRID = menu_level_3_scrid;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public void firstLevel(){
		if(!isOnLoadFlag()){
			MenuItemService menuItemService = new MenuItemService();
			HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
			String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
			MenuToolbar menuToolbar = menuItemService.getMenuNode(userGroup, PropertyManager.getValue("pel_menu_level"), "1", request);
			menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_1);
			//PremiaMenu premiaMenu = new PremiaMenu();
			premiaMenu.setMenuOne(menuToolbar);
			
			menuToolbar = new MenuToolbar();
			menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_2);
			premiaMenu.setMenuTwo(menuToolbar);
			
			menuToolbar = new MenuToolbar();
			menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_3);
			premiaMenu.setMenuThree(menuToolbar);
			
			request.getSession().setAttribute("premiaMenu", premiaMenu);
			String homePage = "/jsf/login/home.xhtml";
			request.getSession().setAttribute("MENU_ID_SCREEN_NAME", homePage);
			menuOneList();
			setOnLoadFlag(true);
		}
	}
	
	public String menuItemAction(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String screenId = request.getParameter("screenId");
		String actionType = request.getParameter("nodeId");
		String nodeLevel = request.getParameter("nodeLevel");
		return menuItemAction(screenId, actionType, nodeLevel);
	}
	
	public String menuItemAction(String screenId, String actionType, String nodeLevel){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		PremiaMenu premiaMenu = (PremiaMenu) request.getSession().getAttribute("premiaMenu");
		String nodeId = screenId;
		if(actionType!=null && !actionType.equals("null") && !actionType.equals("")){
			if(nodeLevel.equals("1")){
				setMENU_LEVEL_1_SCRID(screenId);
			}else if(nodeLevel.equals("2")){
				setMENU_LEVEL_2_SCRID(screenId);
			}else if(nodeLevel.equals("3")){
				setMENU_LEVEL_3_SCRID(screenId);
			}
			setMenuParameters(screenId);
			setActiveScreen(actionType);
			return actionType;
		}
		String userGroup = (String)request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		MenuItemService menuItemService = new MenuItemService();
		MenuToolbar menuToolbar = menuItemService.getMenuItem(userGroup, nodeId, nodeLevel, request);
		ArrayList toolbarList = menuToolbar.getMenuItemList();
		ArrayList<DropDownMenu> dropDownMenuList = null;
		if(toolbarList!=null)
			if(nodeLevel.equals("2") && toolbarList.size()>0){
				dropDownMenuList = menuItemService.getDropDownMenu(userGroup, toolbarList, request);
//				dropDownScreenIdList = menuItemService.getDropDownList(dropDownMenuList);
			}
		if(toolbarList!=null){
			if(toolbarList.size()>0){
				if(nodeLevel.equals("1")){
					setMENU_LEVEL_1_SCRID(screenId);
					menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_2);
					premiaMenu.setMenuTwo(menuToolbar);
					premiaMenu.setMenuThree(null);
					menuTwoList();
				}else if(nodeLevel.equals("2")){
					setMENU_LEVEL_2_SCRID(screenId);
					menuToolbar.setIncrement(LoginConstant.MENU_LEVEL_3);
					premiaMenu.setMenuThree(menuToolbar);
					premiaMenu.setDropDownMenu(dropDownMenuList);
					menuThreeList();
				}else if(nodeLevel.equals("3")){
					setMENU_LEVEL_3_SCRID(screenId);
				}
			}else{
				if(nodeLevel.equals("1")){
					setMENU_LEVEL_1_SCRID(screenId);
					premiaMenu.setMenuTwo(null);
					premiaMenu.setMenuThree(null);
					premiaMenu.setDropDownMenu(null);
					premiaMenu.setDropDownScreenIdList(null);
					menuOneList();
				}else if(nodeLevel.equals("2")){
					setMENU_LEVEL_2_SCRID(screenId);
					premiaMenu.setMenuThree(null);
					premiaMenu.setDropDownMenu(null);
					premiaMenu.setDropDownScreenIdList(null);
					menuTwoList();
				}else if(nodeLevel.equals("3")){
					setMENU_LEVEL_3_SCRID(screenId);
//					menuThreeList();
				}
			}
		}else{
			if(nodeLevel.equals("1")){
				setMENU_LEVEL_1_SCRID(screenId);
				premiaMenu.setMenuTwo(null);
				premiaMenu.setMenuThree(null);
				premiaMenu.setDropDownMenu(null);
				premiaMenu.setDropDownScreenIdList(null);
				menuOneList();
			}else if(nodeLevel.equals("2")){
				setMENU_LEVEL_2_SCRID(screenId);
				premiaMenu.setMenuThree(null);
				premiaMenu.setDropDownMenu(null);
				premiaMenu.setDropDownScreenIdList(null);
				menuTwoList();
			}else if(nodeLevel.equals("3")){
				setMENU_LEVEL_3_SCRID(screenId);
			}
		}
		setActiveScreen(null);
		return "premia-home";
	}
	
	// Return type modified for PMenu
	public MenuParameter setMenuParameters(String screenId){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		MenuItemService menuService = new MenuItemService();
		String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		String jspPageName = null;
		deallocateSessionObject(request);
		MenuParameter menuParameter = null;
		
		if(screenId!=null){
			menuParameter = menuService.getMenuParameter(screenId, userGroup, request);
			if(menuParameter!=null){
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
				request.getSession().setAttribute("GLOBAL.M_SCR_NAME", menuParameter.getMENU_OPTION_DESC());
				ControlBean ctrlBean = (ControlBean) request.getSession().getAttribute("ctrlbean");
			}
			request.getSession().setAttribute("CALLING_FORM", "");
		}
		
		return menuParameter;
	}
	
	public void paginationAction(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
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
		System.out.println("Start:>>>>>>>>>>>>>>>>>>>>>>"+start+" towards "+pageIndex+" for level "+menuLevel);
		if(pageIndex.equals("left")){
			menuToolbar.setStart(start-1);
		}else if(pageIndex.equals("right")){
			menuToolbar.setStart(start+1);
		}
		if(menuLevel.equals("1")){
			menuOneList();
		}else if(menuLevel.equals("2")){
			menuTwoList();
		}else if(menuLevel.equals("3")){
			menuThreeList();
		}
	}
	
	public void menuOneList(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PremiaMenu premiaMenu = (PremiaMenu) sessionMap.get("premiaMenu");
		List<MenuBuilder> menuItemList = premiaMenu.getMenuOne().getMenuItemList();
		if(menuItemList==null){
			firstLevel.clear();
			return;
		}
		firstLevel.clear();
		int length = menuItemList.size();
		int start = premiaMenu.getMenuOne().getStart();
		if(length>=LoginConstant.MENU_LEVEL_1){
			for(int i=start;i<start+LoginConstant.MENU_LEVEL_1;i++){
				if(i<length){
					firstLevel.add(menuItemList.get(i));
				}else{
					premiaMenu.getMenuOne().setStart(i);
					return;
				}
			}
		}else{
			firstLevel = menuItemList;
		}
	}
	
	public void menuTwoList(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PremiaMenu premiaMenu = (PremiaMenu) sessionMap.get("premiaMenu");
		if(premiaMenu.getMenuTwo()!=null){
			List<MenuBuilder> menuItemList = premiaMenu.getMenuTwo().getMenuItemList();
			if(menuItemList==null){
				secondLevel.clear();
				return;
			}
			secondLevel.clear();
			int length = menuItemList.size();
			int start = premiaMenu.getMenuTwo().getStart();
			if(length>LoginConstant.MENU_LEVEL_2){
				for(int i=start;i<start+LoginConstant.MENU_LEVEL_2;i++){
					if(i<length){
						secondLevel.add(menuItemList.get(i));
					}else{
						premiaMenu.getMenuTwo().setStart(i);
						return;
					}
				}
			}else
				secondLevel = menuItemList;
		}
	}
	
	public void menuThreeList(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PremiaMenu premiaMenu = (PremiaMenu) sessionMap.get("premiaMenu");
		if(premiaMenu.getMenuThree()!=null){
			List<MenuBuilder> menuItemList = premiaMenu.getMenuThree().getMenuItemList();
			if(menuItemList==null){
				thirdLevel.clear();
				return;
			}
			thirdLevel.clear();
			int length = menuItemList.size();
			int start = premiaMenu.getMenuThree().getStart();
			if(length>LoginConstant.MENU_LEVEL_3){
				for(int i=start;i<start+LoginConstant.MENU_LEVEL_3;i++){
					if(i<length){
						thirdLevel.add(menuItemList.get(i));
					}else{
						premiaMenu.getMenuThree().setStart(i);
						return;
					}
				}
			}else
				thirdLevel = menuItemList;
		}
	}
	
	public void deallocateSessionObject(HttpServletRequest request) {
		try {
			Enumeration<String> sessionAttr = request.getSession().getAttributeNames();
			String clientId = (String) request.getSession().getAttribute("CLIENT_ID");
			Connection connection = CommonUtils.getConnection();
			connection.rollback();
			while(sessionAttr.hasMoreElements()){
				String sessionAttrName = sessionAttr.nextElement();
				if(!(sessionAttrName.equals("CONNECTION.LOGIN") || sessionAttrName.equals("ctrlbean") || 
						sessionAttrName.equals("username") || sessionAttrName.equals("premiaMenu") || 
						sessionAttrName.startsWith("GLOBAL.") || sessionAttrName.startsWith("DUMMY.") || 
						sessionAttrName.equals("connectionAgent") || sessionAttrName.startsWith("MENU") ||
						sessionAttrName.equals("CLIENT_ID") || sessionAttrName.equals(clientId) ||
						sessionAttrName.equals("PremiaMenuToolbar") || sessionAttrName.equals("pageLocale")
						|| sessionAttrName.equals("skinInfoBean") || sessionAttrName.equals("loginManagedBean"))){
					request.getSession().removeAttribute((String)sessionAttrName);
				}
			}
		} catch (Exception e) {
		}
	}
	
	/*public String logoutAction(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		new LoginService().invalidateSessionAction(request, context);
		return "premia-logout";
	}*/
	
	
	//Method change By Akash To solve the vacrd Vanish Problem click on Logout button... 
	
	public String logoutAction(){
		String outcome = null;
		String requestURL = null;
		String loginRedirectURL = null; 
		String contextPath = null;
		int contextPathIndex = -1;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		ServletContext context = (ServletContext) facesContext.getExternalContext().getContext();
		
		try {
			new LoginService().invalidateSessionAction(request, context);
			contextPath = request.getContextPath();
			requestURL = request.getRequestURL().toString();
			contextPathIndex = requestURL.indexOf(contextPath);
			loginRedirectURL = requestURL.substring(0, contextPathIndex+contextPath.length());
			response.sendRedirect(loginRedirectURL);
			facesContext.responseComplete();
		} catch (IOException e) {
			e.printStackTrace();
			facesContext.addMessage("LOGOUT ERROR", new FacesMessage(e.getMessage()));
		}
		
		return outcome;
	}
	
	public NavigationParameter getNavigationParameter() {
		return navigationParameter;
	}

	public void setNavigationParameter(NavigationParameter navigationParameter) {
		this.navigationParameter = navigationParameter;
	}

	public MenuSearchBean getMenuSearchBean() {
		return menuSearchBean;
	}

	public void setMenuSearchBean(MenuSearchBean menuSearchBean) {
		this.menuSearchBean = menuSearchBean;
	}

	public String confirmationModalPanel(){
		return menuItemAction(navigationParameter.getScreenId(), navigationParameter.getNodeId(), navigationParameter.getNodeLevel());
	}
	
	public void setNavigationParameter(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String screenId = request.getParameter("screenId");
		String nodeId = request.getParameter("nodeId");
		String nodeLevel = request.getParameter("nodeLevel");
		getNavigationParameter().setScreenId(screenId);
		getNavigationParameter().setNodeId(nodeId);
		getNavigationParameter().setNodeLevel(nodeLevel);
	}
	
	public List<MenuSearchBean> getScreenList(Object value){
		setMenuSearchBean(new MenuSearchBean());
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		menuActionScreenList = new MenuItemDao().getMenuActionScreenList(request, userGroup, (String) value, PropertyManager.getValue("pel_menu_level"));
		return menuActionScreenList;
	}
	
	public void menuSearchAction(ActionEvent event){
		UIComponent component = (UIComponent) event.getComponent().getParent();
		HtmlSuggestionBox menuSuggestionBox = (HtmlSuggestionBox) component;
		int rowIndex = menuSuggestionBox.getRowIndex();
		if(rowIndex>=0){
			MenuSearchBean searchBean = menuActionScreenList.get(rowIndex);
			setMenuSearchBean(searchBean);
			menuActionScreenList = null;
		}
	}
	
	public String setSearchScreen1(){
		MenuSearchBean searchBean = getMenuSearchBean();
		String actionType = null;
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if(searchBean!=null){
			String screenId = searchBean.getMENU_ID();
			String menuAction = searchBean.getMENU_ACTION();
			if(screenId!=null){
				List<String> menuIdList = new MenuItemService().menuConnectingPath(request, screenId);
				int levelSize = menuIdList.size();
				/*if(levelSize>0){
					actionType = menuItemAction(screenId, menuAction, levelSize+"");
				}*/
				PremiaMenu premiaMenu = (PremiaMenu) request.getSession().getAttribute("premiaMenu");
				for(int i=0;i<levelSize;i++){
					int nodeLevel = i+1;
					if(i!=levelSize-1){
						actionType = menuItemAction(menuIdList.get(i), null, nodeLevel+"");
					} else {
						actionType = menuItemAction(menuIdList.get(i), menuAction, nodeLevel+"");
					}
					if(nodeLevel==2){
						MenuToolbar toolBar = premiaMenu.getMenuTwo();
						if(toolBar!=null){
							List<MenuBuilder> menuItemList = toolBar.getMenuItemList();
							int listSize = menuItemList.size();
							if(menuItemList!=null && listSize>LoginConstant.MENU_LEVEL_2){
								for(int item = 0;item<listSize;item++){
									MenuBuilder menuBuilder = menuItemList.get(item);
									String activeLink = menuBuilder.getActiveLink();
									if(activeLink!=null && activeLink.equals("activeLink")){
										if(item>listSize-LoginConstant.MENU_LEVEL_2){
											premiaMenu.getMenuTwo().setStart(listSize-LoginConstant.MENU_LEVEL_2);
										}else{
											premiaMenu.getMenuTwo().setStart(item);
										}
										menuTwoList();
										item = menuItemList.size();
									}
								}
							}
						}
					}
					if(nodeLevel==3){
						MenuToolbar toolBar = premiaMenu.getMenuThree();
						if(toolBar!=null){
							List<MenuBuilder> menuItemList = toolBar.getMenuItemList();
							int listSize = menuItemList.size();
							if(menuItemList!=null && listSize>LoginConstant.MENU_LEVEL_3){
								for(int item = 0;item<listSize;item++){
									MenuBuilder menuBuilder = menuItemList.get(item);
									String activeLink = menuBuilder.getActiveLink();
									if(activeLink!=null && activeLink.equals("activeLink")){
										if(item>listSize-LoginConstant.MENU_LEVEL_3){
											premiaMenu.getMenuThree().setStart(listSize-LoginConstant.MENU_LEVEL_3);
										}else{
											premiaMenu.getMenuThree().setStart(item);
										}
										menuThreeList();
										item = menuItemList.size();
									}
								}
							}
						}
					}
				}
			}
		}
		setMenuSearchBean(new MenuSearchBean());
		return actionType;
	}
	
	// [ Added for new Premia menu
	private PMenuItem searchMenuItem = null;
	private ArrayList<PMenuItem> suggestions = null;

	public String menuAction(){
		String outcome = null;
		Boolean chkFlag = false;
		ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
        Map requestParams = external.getRequestParameterMap();
        String clickedMenuId = (String)requestParams.get(UIPMenu.MENU_ID_KEY);
        MenuParameter menuParameter = null;
        
        menuParameter = setMenuParameters(clickedMenuId);
        outcome = menuParameter.getMENU_ACTION();
/*added by janani on 5.8.2016*/
        
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
				
				sessionMap.put("GLOBAL.M_MODULE_ID", outcome);
				sessionMap.put("GLOBAL.M_MENU_ID", clickedMenuId);

        /*end*/
		        
        CommonUtils.setGlobalObject("CAPTION_MAP", null);
        //Added By Akash to set caption run time .
        chkMenusAndSetCaption(outcome);
        /*Added by Janani on 18.10.2016 for IC no length validation ssp call id FALCONLIFE-1344818*/
        
        getICNOFieldlength();
        
        /*end*/
        
        /*Added by Ram on 28/11/2016 for MenuCation Global Object*/
        CommonUtils.setGlobalObject("MENU_ACTION", outcome);
        System.out.println("-->Menu Action: "+outcome);
        /*End*/
        
 /*Added by Janani on 14.10.2016 for IC no length validation*/
        
        getICNOFieldlength();
        
        /*end*/
        
        
		return outcome;
	}
	/*Added by Janani on 18.10.2016 for IC no length validation ssp call id FALCONLIFE-1344818*/
	
	public int ICnoLength()
	{
		System.out.println("enters into ICnoLength");
		
		int M_PS_VALUE=0;
		try{
			String query= "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'CUSTREFFMT'";
			ResultSet resultSet=  null;

			CRUDHandler handler = new CRUDHandler();
			CommonUtils commonUtils = new CommonUtils();
			Connection connection = null;

			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query,connection);

			while(resultSet.next())
			{
				M_PS_VALUE=resultSet.getInt(1);
			}

		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		CommonUtils.setGlobalObject("M_PS_VALUE", M_PS_VALUE);
		
		System.out.println("M_PS_VALUE in menutoolbar                           "+CommonUtils.getGlobalObject("M_PS_VALUE"));
		
		return M_PS_VALUE;
	}
	public void getICNOFieldlength(){
		String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE LIKE ?";
		
		int M_PS_VALUE =ICnoLength();
		
		Object[] values = {M_PS_VALUE};
		CRUDHandler handler = new CRUDHandler();
		ResultSet lengthResultset = null;
		String message = null;
		int fieldLength = 0;
		try {
			Connection conn = CommonUtils.getConnection();
			lengthResultset = handler.executeSelectStatement(query, conn, new Object[]{"REF_ID_"+M_PS_VALUE});
			if(lengthResultset.next()){
				fieldLength = lengthResultset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		CommonUtils.setGlobalObject("FIELD_LENGTH", fieldLength);
		System.out.println("FIELD_LENGTH in menutoolbar                           "+CommonUtils.getGlobalObject("FIELD_LENGTH"));
		
	}
	
	/*end*/
	

	public ArrayList<PMenuItem> getMenuList(){
		MenuItemDao menuDao = new MenuItemDao();
		ArrayList<PMenuItem> menuList = new ArrayList<PMenuItem>();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		String topLevelParentId = Messages.getString("login", "premia_menu_top_level_parent_id");
		String moduleCode = Messages.getString("login", "premia_menu_module_id");;
		//System.out.println("------8<------- RenderKit: "+FacesContext.getCurrentInstance().getRenderKit());
		
		try {
			menuList = menuDao.buildMenuTree(userGroup, topLevelParentId, moduleCode);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return menuList;
	}

	public String menuSearchGoAction() {
		String outcome = null;
		MenuParameter menuParameter = null;

		if(searchMenuItem.getMenuId() != null && !searchMenuItem.getMenuId().trim().isEmpty()){
			menuParameter = setMenuParameters(searchMenuItem.getMenuId());
			outcome = menuParameter.getMENU_ACTION();
		}
		System.out.println("-->Search Menu Action: " + outcome);
		resetMenuDefault();
		
		return outcome;
	}
	
	public ArrayList<PMenuItem> menuSuggestions(Object userValue){
		//ArrayList<PMenuItem> suggestions = new ArrayList<PMenuItem>();
		MenuItemDao menuDao = new MenuItemDao();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String userGroup = (String) request.getSession().getAttribute("GLOBAL.M_USER_GROUP");
		String topLevelParentId = Messages.getString("login", "premia_menu_top_level_parent_id");
		String moduleCode = Messages.getString("login", "premia_menu_module_id");;

		try {
			// Check for jsf internal call restriction with null userValue
			if(userValue != null){
				suggestions = menuDao.getSearchMenuList((String) userValue, 
						userGroup, 
						topLevelParentId, 
						moduleCode);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return suggestions;
	}
	
	private void resetMenuDefault(){
		searchMenuItem = new PMenuItem();
		searchMenuItem.setMenuOptionDesc(Messages.getString("login", 
			"premia_menu_search_caption"));
	}
	
	public void menuSearchSelectionListener(ActionEvent event){
		UIComponent component = (UIComponent) event.getComponent().getParent();
		HtmlSuggestionBox menuSuggestionBox = (HtmlSuggestionBox) component;
		//searchMenuItem = (PMenuItem) menuSuggestionBox.getRowData();
		
		if(suggestions != null){
			System.out.println("--> Listener suggestions: "+suggestions.hashCode()+", size: "+suggestions.size());
			searchMenuItem = suggestions.get(menuSuggestionBox.getRowIndex());
		}else{
			resetMenuDefault();
		}
	}

	public PMenuItem getSearchMenuItem() {
		return searchMenuItem;
	}

	public void setSearchMenuItem(PMenuItem searchMenuItem) {
		this.searchMenuItem = searchMenuItem;
	}
	// Added for new Premia menu ]
	
	
	
	public void setCaptionForBlock(String menu_action){
		Map<String, Map<String, String>> captionSetMap = new HashMap<String, Map<String, String>>();
		ResultSet resultSet = null;
		ResultSet resultSet_1 = null;
		Connection connection = null;
		Map<String, String> setFieldMap = new HashMap<String, String>();
		String calcParamValue = null;
		CRUDHandler handler = new CRUDHandler();
 		String blkname = null; 
		String blkNameQuery = "SELECT DISTINCT PFL_BLK_NAME FROM IM_PROG_FIELD_LABEL WHERE   " +
						" PFL_PROG_CODE= ? ";
		String query = "SELECT PFL_FIELD_NAME,PFL_LABEL FROM IM_PROG_FIELD_LABEL WHERE   " +
						" PFL_PROG_CODE= ? AND PFL_BLK_NAME = ? " +
						" AND PFL_LANG_CODE = ? AND PFL_CALC_MTHD = ? ";
		
			try {
				connection = CommonUtils.getConnection();
				calcParamValue = getSystemCalcParamValue();
				resultSet = handler.executeSelectStatement(blkNameQuery, connection,new Object[]{menu_action});
				while(resultSet.next()){
					blkname = resultSet.getString(1);
					resultSet_1 = new CRUDHandler().executeSelectStatement(query, connection,
							new Object[]{menu_action,blkname,
								CommonUtils.nvl(CommonUtils.getControlBean().getM_LANG_CODE(), "ENG"),
								calcParamValue});
						while(resultSet_1.next()){
							setFieldMap.put(resultSet_1.getString(1), resultSet_1.getString(2));
					
						}
						try{CommonUtils.closeCursor(resultSet_1);}catch (Exception e) {}
						captionSetMap.put(blkname, setFieldMap);	
				}
				HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
				request.getSession().setAttribute("CAPTION_MAP", captionSetMap);
				
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {e.printStackTrace();}
				try{CommonUtils.closeCursor(resultSet_1);}catch (Exception e) {}
			}
		
	}
	
	
	public void chkMenusAndSetCaption(String menuAction){
		List<String> menuList = new ArrayList<String>();
		String[] values = null;
		final  String VALUE_SEPRATOR = ",";
		values = Messages.getString("login", "dyanmic_caption_from_id").split(VALUE_SEPRATOR);
		for(int index=0, size=values.length; index<size; index++){
			menuList.add(values[index]);
		}
		System.out.println("List Of values ---->" + menuList.toArray());
		if(menuList.contains(menuAction)){
			setCaptionForBlock(menuAction);
		}
	}
	
	
	
	
	public   String getSystemCalcParamValue() throws Exception{
		String paramValue = null;
		Connection connection = null;
		ResultSet resultSet = null;
		String query="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_CALC_MTHD'";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection);
			if(resultSet.next()){
				paramValue = String.valueOf(resultSet.getInt(1));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		return paramValue;
	}

}
