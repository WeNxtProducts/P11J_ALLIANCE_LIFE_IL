package com.iii.pel.login.model;

import java.io.Serializable;

public class NavigationParameter implements Serializable {
	
	private String screenId;
	private String nodeId;
	private String nodeLevel;
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
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

}
