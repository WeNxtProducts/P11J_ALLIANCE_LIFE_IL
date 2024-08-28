package com.iii.premia.common.commonimpl.dms;

import java.util.ArrayList;

public class DMSDetails{
	private DMSAppDetailsBean fromAppDetails;
	private ArrayList<DMSAppDetailsBean> toAppDetailsList;
	
	public DMSDetails(){
		fromAppDetails = new DMSAppDetailsBean();
		toAppDetailsList = new ArrayList<DMSAppDetailsBean>();
	}
	
	public DMSAppDetailsBean getFromAppDetails() {
		return fromAppDetails;
	}
	public void setFromAppDetails(DMSAppDetailsBean fromAppDetails) {
		this.fromAppDetails = fromAppDetails;
	}
	public ArrayList<DMSAppDetailsBean> getToAppDetailsList() {
		return toAppDetailsList;
	}
	public void setToAppDetailsList(ArrayList<DMSAppDetailsBean> toAppDetailsList) {
		this.toAppDetailsList = toAppDetailsList;
	}
	public int getToAppDetailsListSize(){
		return getToAppDetailsList().size(); 
	}
}
