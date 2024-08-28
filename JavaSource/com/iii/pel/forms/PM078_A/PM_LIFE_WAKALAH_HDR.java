package com.iii.pel.forms.PM078_A;

import com.iii.apps.persistence.BaseValueBean;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.constants.PELConstants;

@Table(name="")
public class PM_LIFE_WAKALAH_HDR extends BaseValueBean {

	private String WAKS_MODULE;

	private String WAKS_PRODUCT_CODE;

	private String UI_M_WAKS_PRODUCT_CODE;

	private String WAKS_FRZ_FLAG;

	private boolean CHECK_WAKS_FRZ_FLAG;



	public String getWAKS_MODULE() {
		return WAKS_MODULE;
	}

	public void setWAKS_MODULE(String WAKS_MODULE) {
		this.WAKS_MODULE = WAKS_MODULE;
	}

	public String getWAKS_PRODUCT_CODE() {
		return WAKS_PRODUCT_CODE;
	}

	public void setWAKS_PRODUCT_CODE(String WAKS_PRODUCT_CODE) {
		this.WAKS_PRODUCT_CODE = WAKS_PRODUCT_CODE;
	}

	public String getUI_M_WAKS_PRODUCT_CODE() {
		return UI_M_WAKS_PRODUCT_CODE;
	}

	public void setUI_M_WAKS_PRODUCT_CODE(String UI_M_WAKS_PRODUCT_CODE) {
		this.UI_M_WAKS_PRODUCT_CODE = UI_M_WAKS_PRODUCT_CODE;
	}

	public String getWAKS_FRZ_FLAG() {
		return WAKS_FRZ_FLAG;
	}

	public boolean isCHECK_WAKS_FRZ_FLAG() {
		if(PELConstants.CHECKBOX_CHECKED.equals(WAKS_FRZ_FLAG)) {
			CHECK_WAKS_FRZ_FLAG  = true;
		} else {
			CHECK_WAKS_FRZ_FLAG  = false;
		}
		return CHECK_WAKS_FRZ_FLAG;
	}

	public void setWAKS_FRZ_FLAG(String WAKS_FRZ_FLAG) {
		this.WAKS_FRZ_FLAG = WAKS_FRZ_FLAG;
	}

	public void setCHECK_WAKS_FRZ_FLAG(boolean CHECK_WAKS_FRZ_FLAG) {
		this.CHECK_WAKS_FRZ_FLAG = CHECK_WAKS_FRZ_FLAG;
	}
}