package com.iii.pel.login.model;

import java.io.Serializable;
import java.util.ArrayList;

public class DropDownMenu implements Serializable, Cloneable {
	
	private static final long serialVersionUID = 1L;
	
	private String screenId;
	private ArrayList<DropDownItem> toolbarList;
	public String getScreenId() {
		return screenId;
	}
	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}
	public ArrayList<DropDownItem> getToolbarList() {
		return toolbarList;
	}
	public void setToolbarList(ArrayList<DropDownItem> toolbarList) {
		this.toolbarList = toolbarList;
	}

}
