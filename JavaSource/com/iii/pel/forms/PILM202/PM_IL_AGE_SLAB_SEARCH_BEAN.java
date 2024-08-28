package com.iii.pel.forms.PILM202;

import com.iii.premia.common.bean.BaseValueBean;

public class PM_IL_AGE_SLAB_SEARCH_BEAN extends BaseValueBean {
	
	
	private String ASS_CODE;
	
	private String ASS_DESC;
	
	private Integer ASS_MAX_AGE;
	
	private boolean CHECK_BOX;


	private Integer ASS_MIN_AGE;

	public PM_IL_AGE_SLAB_SEARCH_BEAN(){

	}

	public String getASS_CODE() {
		return ASS_CODE;
	}

	public void setASS_CODE(String ass_code) {
		ASS_CODE = ass_code;
	}

	public String getASS_DESC() {
		return ASS_DESC;
	}

	public void setASS_DESC(String ass_desc) {
		ASS_DESC = ass_desc;
	}

	public Integer getASS_MAX_AGE() {
		return ASS_MAX_AGE;
	}

	public void setASS_MAX_AGE(Integer ass_max_age) {
		ASS_MAX_AGE = ass_max_age;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Integer getASS_MIN_AGE() {
		return ASS_MIN_AGE;
	}

	public void setASS_MIN_AGE(Integer ass_min_age) {
		ASS_MIN_AGE = ass_min_age;
	}

	

	 

}
