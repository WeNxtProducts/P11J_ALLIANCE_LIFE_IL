package com.iii.pel.forms.PILP008;

import javax.faces.event.ActionEvent;

public class ApprovalBean {
	private String clm_no ;

	public String getclm_no() {
		return clm_no;
	}

	public void setclm_no(String clm_no) {
		this.clm_no = clm_no;
	}
	public void validate(ActionEvent ae) {
		System.out.println("ApprovalBean.validate()"+ae.getComponent().getId());
	} 
}
