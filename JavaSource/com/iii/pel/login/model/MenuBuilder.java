package com.iii.pel.login.model;

import java.io.Serializable;
import java.util.Map;

import javax.faces.context.FacesContext;

public class MenuBuilder implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	private String nodeLevel;
	private String name;
	private String screenId;
	private String parent;
	private String popup;
	private String nodeId;
	private String activeId;
	private String activeLink;
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
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
	public String getActiveId() {
		return activeId;
	}
	public void setActiveId(String activeId) {
		this.activeId = activeId;
	}
	public String getActiveLink(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PremiaMenuToolbar menuToolbar = (PremiaMenuToolbar) sessionMap.get("PremiaMenuToolbar");
		if(nodeLevel.equals("1")) {
			activeId = menuToolbar.getMENU_LEVEL_1_SCRID();
		} else if(nodeLevel.equals("2")) {
			activeId = menuToolbar.getMENU_LEVEL_2_SCRID();
		} else if(nodeLevel.equals("3")) {
			activeId = menuToolbar.getMENU_LEVEL_3_SCRID();
		}
		
		if(screenId.equals(activeId)){
			if(nodeLevel.equals("1")) {
				activeLink = "active";
			} else if(nodeLevel.equals("2")) {
				activeLink =  "activeLink";
			} else if(nodeLevel.equals("3")) {
				activeLink = "activeLink";
			}
		}
		else
			activeLink="";
		return activeLink;
	}

}
