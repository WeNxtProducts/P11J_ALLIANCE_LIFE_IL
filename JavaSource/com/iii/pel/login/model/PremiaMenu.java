package com.iii.pel.login.model;

import java.io.Serializable;
import java.util.ArrayList;

public class PremiaMenu implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private MenuToolbar menuOne;
	private MenuToolbar menuTwo;
	private MenuToolbar menuThree;
	private ArrayList<DropDownMenu> dropDownMenu;
	private ArrayList<String> dropDownScreenIdList;
	public MenuToolbar getMenuOne() {
		return menuOne;
	}
	public void setMenuOne(MenuToolbar menuOne) {
		this.menuOne = menuOne;
	}
	public MenuToolbar getMenuTwo() {
		return menuTwo;
	}
	public void setMenuTwo(MenuToolbar menuTwo) {
		this.menuTwo = menuTwo;
	}
	public MenuToolbar getMenuThree() {
		return menuThree;
	}
	public void setMenuThree(MenuToolbar menuThree) {
		this.menuThree = menuThree;
	}
	public ArrayList<DropDownMenu> getDropDownMenu() {
		return dropDownMenu;
	}
	public void setDropDownMenu(ArrayList<DropDownMenu> dropDownMenu) {
		this.dropDownMenu = dropDownMenu;
	}
	public ArrayList<String> getDropDownScreenIdList() {
		return dropDownScreenIdList;
	}
	public void setDropDownScreenIdList(ArrayList<String> dropDownScreenIdList) {
		this.dropDownScreenIdList = dropDownScreenIdList;
	}
}
