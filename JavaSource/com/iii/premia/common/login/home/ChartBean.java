package com.iii.premia.common.login.home;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author 53057
 * Chart id,userid,order,width,height,frequency(H/D/W/M/Y) 
 */
public class ChartBean {
	private String chartId;
	private ArrayList<String> userList;
	private int width;
	private int height;
	private char frequency;

	private Date createdDate;
	private String imageTag;
	private String _chartConfig;
	
	public String get_chartConfig() {
		return _chartConfig;
	}
	public void set_chartConfig(String config) {
		_chartConfig = config;
	}
	public String getChartId() {
		return chartId;
	}
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}
	public ArrayList<String> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<String> userList) {
		this.userList = userList;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public char getFrequency() {
		return frequency;
	}
	public void setFrequency(char frequency) {
		this.frequency = frequency;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getImageTag() {
		return imageTag;
	}
	public void setImageTag(String imageTag) {
		this.imageTag = imageTag;
	}
	
	
}
