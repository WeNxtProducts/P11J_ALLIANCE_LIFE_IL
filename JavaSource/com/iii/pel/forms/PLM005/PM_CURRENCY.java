package com.iii.pel.forms.PLM005;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;


@Table(name = "PM_CURRENCY")
public class PM_CURRENCY extends BaseValueBean{
	
	@Column(name = "CURR_CODE")
	private String CURR_CODE;

	@Column(name = "CURR_NAME")
	private String CURR_NAME;

	@Column(name = "CURR_SHORT_NAME")
	private String CURR_SHORT_NAME;

	@Column(name = "CURR_UNIT_NAME")
	private String CURR_UNIT_NAME;

	@Column(name = "CURR_DECIMAL")
	private int CURR_DECIMAL;
	
	@Column(name = "CURR_CR_UID")
	private String CURR_CR_UID;
	
	@Column(name = "CURR_CR_DT")
	private Date CURR_CR_DT;
	
	@Column(name = "CURR_UPD_UID")
	private String CURR_UPD_UID;
	
	@Column(name = "CURR_UPD_DT")
	private Date CURR_UPD_DT;
	
	
	@Column(name="CURR_FRZ_FLAG")
	private String CURR_FRZ_FLAG ;
	
private boolean UI_CURR_FRZ_FLAG;
	
	
	public boolean isUI_CURR_FRZ_FLAG() {
	return UI_CURR_FRZ_FLAG;
}
public void setUI_CURR_FRZ_FLAG(boolean uI_CURR_FRZ_FLAG) {
	CURR_FRZ_FLAG = CommonUtils.booleanToStriingConvertor(uI_CURR_FRZ_FLAG);
	UI_CURR_FRZ_FLAG = uI_CURR_FRZ_FLAG;
}
	
	public String getCURR_FRZ_FLAG() {
		return CURR_FRZ_FLAG;
	}
	public void setCURR_FRZ_FLAG(String cURR_FRZ_FLAG) {
		
		UI_CURR_FRZ_FLAG = CommonUtils.stringToBooleanConvertor(cURR_FRZ_FLAG);
		CURR_FRZ_FLAG = cURR_FRZ_FLAG;
	}
	public String getCURR_CODE() {
		return CURR_CODE;
	}

	public void setCURR_CODE(String cURR_CODE) {
		CURR_CODE = cURR_CODE;
	}

	public String getCURR_NAME() {
		return CURR_NAME;
	}

	public void setCURR_NAME(String cURR_NAME) {
		CURR_NAME = cURR_NAME;
	}

	
	public String getCURR_SHORT_NAME() {
		return CURR_SHORT_NAME;
	}

	public void setCURR_SHORT_NAME(String cURR_SHORT_NAME) {
		CURR_SHORT_NAME = cURR_SHORT_NAME;
	}
	
	
	public String getCURR_UNIT_NAME() {
		return CURR_UNIT_NAME;
	}

	public void setCURR_UNIT_NAME(String cURR_UNIT_NAME) {
		CURR_UNIT_NAME = cURR_UNIT_NAME;
	}

	public int getCURR_DECIMAL() {
		return CURR_DECIMAL;
	}

	public void setCURR_DECIMAL(int cURR_DECIMAL) {
		CURR_DECIMAL = cURR_DECIMAL;
	}

	public String getCURR_CR_UID() {
		return CURR_CR_UID;
	}

	public void setCURR_CR_UID(String cURR_CR_UID) {
		CURR_CR_UID = cURR_CR_UID;
	}

	public Date getCURR_CR_DT() {
		return CURR_CR_DT;
	}

	public void setCURR_CR_DT(Date cURR_CR_DT) {
		CURR_CR_DT = cURR_CR_DT;
	}

	public String getCURR_UPD_UID() {
		return CURR_UPD_UID;
	}

	public void setCURR_UPD_UID(String cURR_UPD_UID) {
		CURR_UPD_UID = cURR_UPD_UID;
	}

	public Date getCURR_UPD_DT() {
		return CURR_UPD_DT;
	}

	public void setCURR_UPD_DT(Date cURR_UPD_DT) {
		CURR_UPD_DT = cURR_UPD_DT;
	}

	



}
