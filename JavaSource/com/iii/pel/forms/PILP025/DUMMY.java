package com.iii.pel.forms.PILP025;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String UI_M_POLICY_FM;

	private String UI_M_POLICY_TO;

	private String UI_M_DIVN_FM;

	private String UI_M_DIVN_TO;

	private String UI_M_DEPT_FM;

	private String UI_M_DEPT_TO;

	private Date UI_M_FM_DT;

	private Date UI_M_TO_DT;

	private String UI_M_CERT_PRINT_YN;
	
	private boolean CERT_PRINT_YN;

	private String UI_M_PROP_DRIP_YN;
	
	private boolean PROP_DRIP_YN;

	private String UI_M_EXE_PREMIUM_YN;
	
	private boolean EXE_PREMIUM_YN;

	public String getUI_M_POLICY_FM() {
		return UI_M_POLICY_FM;
	}

	public void setUI_M_POLICY_FM(String UI_M_POLICY_FM) {
		this.UI_M_POLICY_FM = UI_M_POLICY_FM;
	}

	public String getUI_M_POLICY_TO() {
		return UI_M_POLICY_TO;
	}

	public void setUI_M_POLICY_TO(String UI_M_POLICY_TO) {
		this.UI_M_POLICY_TO = UI_M_POLICY_TO;
	}

	public String getUI_M_DIVN_FM() {
		return UI_M_DIVN_FM;
	}

	public void setUI_M_DIVN_FM(String UI_M_DIVN_FM) {
		this.UI_M_DIVN_FM = UI_M_DIVN_FM;
	}

	public String getUI_M_DIVN_TO() {
		return UI_M_DIVN_TO;
	}

	public void setUI_M_DIVN_TO(String UI_M_DIVN_TO) {
		this.UI_M_DIVN_TO = UI_M_DIVN_TO;
	}

	public String getUI_M_DEPT_FM() {
		return UI_M_DEPT_FM;
	}

	public void setUI_M_DEPT_FM(String UI_M_DEPT_FM) {
		this.UI_M_DEPT_FM = UI_M_DEPT_FM;
	}

	public String getUI_M_DEPT_TO() {
		return UI_M_DEPT_TO;
	}

	public void setUI_M_DEPT_TO(String UI_M_DEPT_TO) {
		this.UI_M_DEPT_TO = UI_M_DEPT_TO;
	}

	public Date getUI_M_FM_DT() {
		 return UI_M_FM_DT;
	}

	public void setUI_M_FM_DT(Date UI_M_FM_DT) {
		this.UI_M_FM_DT = UI_M_FM_DT;
	}

	public Date getUI_M_TO_DT() {
		 return UI_M_TO_DT;
	}

	public void setUI_M_TO_DT(Date UI_M_TO_DT) {
		this.UI_M_TO_DT = UI_M_TO_DT;
	}

	public String getUI_M_CERT_PRINT_YN() {
		return UI_M_CERT_PRINT_YN;
	}

	public void setUI_M_CERT_PRINT_YN(String UI_M_CERT_PRINT_YN) {
		this.UI_M_CERT_PRINT_YN = UI_M_CERT_PRINT_YN;
	}

	public String getUI_M_PROP_DRIP_YN() {
		return UI_M_PROP_DRIP_YN;
	}

	public void setUI_M_PROP_DRIP_YN(String UI_M_PROP_DRIP_YN) {
		this.UI_M_PROP_DRIP_YN = UI_M_PROP_DRIP_YN;
	}

	public String getUI_M_EXE_PREMIUM_YN() {
		return UI_M_EXE_PREMIUM_YN;
	}

	public void setUI_M_EXE_PREMIUM_YN(String UI_M_EXE_PREMIUM_YN) {
		this.UI_M_EXE_PREMIUM_YN = UI_M_EXE_PREMIUM_YN;
	}

	public boolean isCERT_PRINT_YN() {
		if(PELConstants.CHECKBOX_CHECKED.equals(CERT_PRINT_YN)) {
			CERT_PRINT_YN  = true;
		} else {
			CERT_PRINT_YN  = false;
		}
		return CERT_PRINT_YN;
	}

	public void setCERT_PRINT_YN(boolean CERT_PRINT_YN) {
		this.CERT_PRINT_YN = CERT_PRINT_YN;
	}

	public boolean isPROP_DRIP_YN() {
		if(PELConstants.CHECKBOX_CHECKED.equals(PROP_DRIP_YN)) {
			PROP_DRIP_YN  = true;
		} else {
			PROP_DRIP_YN  = false;
		}
		return PROP_DRIP_YN;
	}

	public void setPROP_DRIP_YN(boolean PROP_DRIP_YN) {
		this.PROP_DRIP_YN = PROP_DRIP_YN;
	}

	public boolean isEXE_PREMIUM_YN() {
		if(PELConstants.CHECKBOX_CHECKED.equals(EXE_PREMIUM_YN)) {
			EXE_PREMIUM_YN  = true;
		} else {
			EXE_PREMIUM_YN  = false;
		}
		return EXE_PREMIUM_YN;
	}

	public void setEXE_PREMIUM_YN(boolean EXE_PREMIUM_YN) {
		this.EXE_PREMIUM_YN = EXE_PREMIUM_YN;
	}
}
