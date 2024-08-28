package com.iii.pel.forms.PILP006;

import java.util.Date;

public class DUMMY_LOV_BEAN {
	
	private String POL_NO;
	
	private String CLAIM_NO;
	
	private Date CLAIM_LOSS_DT;

	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String pol_no) {
		POL_NO = pol_no;
	}

	public Date getCLAIM_LOSS_DT() {
		return CLAIM_LOSS_DT;
	}

	public void setCLAIM_LOSS_DT(Date claim_loss_dt) {
		CLAIM_LOSS_DT = claim_loss_dt;
	}

	public String getCLAIM_NO() {
		return CLAIM_NO;
	}

	public void setCLAIM_NO(String claim_no) {
		CLAIM_NO = claim_no;
	}
}
