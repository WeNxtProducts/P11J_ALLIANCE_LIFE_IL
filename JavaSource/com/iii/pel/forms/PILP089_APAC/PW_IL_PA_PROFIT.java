package com.iii.pel.forms.PILP089_APAC;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.Table;
import com.iii.apps.persistence.Column;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;


@Table(name="pw_il_pa_profit")
public class PW_IL_PA_PROFIT extends BaseValueBean {

	@Column(name="PP_POL_NO")
	private String PP_POL_NO;

	@Column(name="PP_POL_PROD_CODE")
	private String PP_POL_PROD_CODE;

	@Column(name="PP_POL_END_NO")
	private String PP_POL_END_NO;

	@Column(name="PP_POL_SYS_ID")
	private Long PP_POL_SYS_ID;

	@Column(name="PP_POL_PLAN_CODE")
	private String PP_POL_PLAN_CODE;

	@Column(name="PP_POL_APPRV_DT")
	private Date PP_POL_APPRV_DT;

	@Column(name="PP_PROCESS_YN")
	private String PP_PROCESS_YN;

	public void setPP_POL_END_NO(String PP_POL_END_NO) {
		this.PP_POL_END_NO = PP_POL_END_NO;
	}
	public String getPP_POL_END_NO() {
		 return PP_POL_END_NO;
	}
	public void setPP_POL_PLAN_CODE(String PP_POL_PLAN_CODE) {
		this.PP_POL_PLAN_CODE = PP_POL_PLAN_CODE;
	}
	public String getPP_POL_PLAN_CODE() {
		 return PP_POL_PLAN_CODE;
	}
	public void setPP_PROCESS_YN(String PP_PROCESS_YN) {
		this.PP_PROCESS_YN = PP_PROCESS_YN;
	}
	public String getPP_PROCESS_YN() {
		 return PP_PROCESS_YN;
	}
	public void setPP_POL_APPRV_DT(Date PP_POL_APPRV_DT) {
		this.PP_POL_APPRV_DT = PP_POL_APPRV_DT;
	}
	public Date getPP_POL_APPRV_DT() {
		 return PP_POL_APPRV_DT;
	}
	
	public String getUI_PP_POL_APPRV_DT(){
		String UI_PP_POL_APPRV_DT=CommonUtils.dateToPELStringFormatter(PP_POL_APPRV_DT);
		return UI_PP_POL_APPRV_DT;
	}
	public void setPP_POL_NO(String PP_POL_NO) {
		this.PP_POL_NO = PP_POL_NO;
	}
	public String getPP_POL_NO() {
		 return PP_POL_NO;
	}
	public void setPP_POL_SYS_ID(Long PP_POL_SYS_ID) {
		this.PP_POL_SYS_ID = PP_POL_SYS_ID;
	}
	public Long getPP_POL_SYS_ID() {
		 return PP_POL_SYS_ID;
	}
	public void setPP_POL_PROD_CODE(String PP_POL_PROD_CODE) {
		this.PP_POL_PROD_CODE = PP_POL_PROD_CODE;
	}
	public String getPP_POL_PROD_CODE() {
		 return PP_POL_PROD_CODE;
	}

}