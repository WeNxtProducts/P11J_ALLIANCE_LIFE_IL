package com.iii.pel.login.model;

import java.io.Serializable;
import java.util.ArrayList;

public class MenuToolbar implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<MenuBuilder> menuItemList;
	private String activeMenu;
	private int length;
	private int start = 0;
	private int increment = 0;
	private boolean activeLeftArrow;
	private boolean activeRightArrow;
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getIncrement() {
		return increment;
	}
	public void setIncrement(int increment) {
		this.increment = increment;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public ArrayList<MenuBuilder> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(ArrayList<MenuBuilder> menuItemList) {
		this.menuItemList = menuItemList;
		setLength(menuItemList.size());
	}
	public String getActiveMenu() {
		return activeMenu;
	}
	public void setActiveMenu(String activeMenu) {
		this.activeMenu = activeMenu;
	}
	public boolean isActiveLeftArrow() {
		if (start > 0)
			return true;
		return false;
	}
	public boolean isActiveRightArrow() {
		if (start < (length - increment))
			return true;
		return false;
	}
}
