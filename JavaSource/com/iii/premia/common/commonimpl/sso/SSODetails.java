package com.iii.premia.common.commonimpl.sso;

import java.util.ArrayList;

public class SSODetails{
	private SSOAppDetailsBean fromAppDetails;
	private ArrayList<SSOAppDetailsBean> toAppDetailsList;
	
	public SSODetails(){
		fromAppDetails = new SSOAppDetailsBean();
		toAppDetailsList = new ArrayList<SSOAppDetailsBean>();
	}
	
	public SSOAppDetailsBean getFromAppDetails() {
		return fromAppDetails;
	}
	public void setFromAppDetails(SSOAppDetailsBean fromAppDetails) {
		this.fromAppDetails = fromAppDetails;
	}
	public ArrayList<SSOAppDetailsBean> getToAppDetailsList() {
		return toAppDetailsList;
	}
	public void setToAppDetailsList(ArrayList<SSOAppDetailsBean> toAppDetailsList) {
		this.toAppDetailsList = toAppDetailsList;
	}
	public int getToAppDetailsListSize(){
		return getToAppDetailsList().size(); 
	}
}
