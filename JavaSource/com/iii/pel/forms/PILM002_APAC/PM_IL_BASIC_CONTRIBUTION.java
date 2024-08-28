package com.iii.pel.forms.PILM002_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_BASIC_CONTRIBUTION")
public class PM_IL_BASIC_CONTRIBUTION extends BaseValueBean {
	
	@Column(name="BC_COVER_CODE")
	private String BC_COVER_CODE;
    
	@Column(name="BC_AGE_FROM")
	private Integer BC_AGE_FROM;

	@Column(name="BC_AGE_TO")
	private Integer	BC_AGE_TO;
	
	@Column(name="BC_LC_BASIC_CONTRIB")
	private Integer	BC_LC_BASIC_CONTRIB;

	
	
	public String getBC_COVER_CODE() {
		return BC_COVER_CODE;
	}
	public void setBC_COVER_CODE(String bc_cover_code) {
		BC_COVER_CODE = bc_cover_code;
	}
	public Integer getBC_AGE_FROM() {
		return BC_AGE_FROM;
	}
	public void setBC_AGE_FROM(Integer bc_age_from) {
		BC_AGE_FROM = bc_age_from;
	}
	public Integer getBC_AGE_TO() {
		return BC_AGE_TO;
	}
	public void setBC_AGE_TO(Integer bc_age_to) {
		BC_AGE_TO = bc_age_to;
	}
	public Integer getBC_LC_BASIC_CONTRIB() {
		return BC_LC_BASIC_CONTRIB;
	}
	public void setBC_LC_BASIC_CONTRIB(Integer bc_lc_basic_contrib) {
		BC_LC_BASIC_CONTRIB = bc_lc_basic_contrib;
	}
	
}
