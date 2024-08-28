package com.iii.pel.login.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DropDownItem implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nodeLevel;
	private String name;
	private String screenId;
	private String parent;
	private String popup;
	private String nodeId;
	private String actionType;
	private ArrayList<MenuBuilder> menuItemList;
	public String getNodeLevel() {
		return nodeLevel;
	}
	public void setNodeLevel(String nodeLevel) {
		this.nodeLevel = nodeLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	public String getPopup() {
		return popup;
	}
	public void setPopup(String popup) {
		this.popup = popup;
	}
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public ArrayList<MenuBuilder> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(ArrayList<MenuBuilder> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public String getActionType() {
		return actionType;
	}
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}
	
}
