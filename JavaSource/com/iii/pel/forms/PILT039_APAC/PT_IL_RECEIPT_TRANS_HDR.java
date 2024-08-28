package com.iii.pel.forms.PILT039_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_RECEIPT_TRANS_HDR")
public class PT_IL_RECEIPT_TRANS_HDR extends BaseValueBean {
	
	/*@Column(name="RTH_SYS_ID")
	private int  RTH_SYS_ID;
	
	public int getRTH_SYS_ID() {
		return RTH_SYS_ID;
	}

	
	
	


	public void setRTH_SYS_ID(int rTH_SYS_ID) {
		RTH_SYS_ID = rTH_SYS_ID;
	}

	@Column(name="RTH_SRC_POL_NO")
	private String RTH_SRC_POL_NO;

	@Column(name="RTH_SRC_POL_SYS_ID")
	private String RTH_SRC_POL_SYS_ID;
	
	public String getRTH_SRC_POL_SYS_ID() {
		return RTH_SRC_POL_SYS_ID;
	}

	public void setRTH_SRC_POL_SYS_ID(String rTH_SRC_POL_SYS_ID) {
		RTH_SRC_POL_SYS_ID = rTH_SRC_POL_SYS_ID;
	}

	private String WP_CUST_CODE;
	private String WP_CUST_CODE_DESC;
	
	public String getWP_CUST_CODE_DESC() {
		return WP_CUST_CODE_DESC;
	}

	public void setWP_CUST_CODE_DESC(String wP_CUST_CODE_DESC) {
		WP_CUST_CODE_DESC = wP_CUST_CODE_DESC;
	}

	public String getRTH_SRC_POL_NO() {
		return RTH_SRC_POL_NO;
	}

	public void setRTH_SRC_POL_NO(String rTH_SRC_POL_NO) {
		RTH_SRC_POL_NO = rTH_SRC_POL_NO;
	}

	
	public Date getRTH_APPRV_DT() {
		return RTH_APPRV_DT;
	}

	public void setRTH_APPRV_DT(Date rTH_APPRV_DT) {
		RTH_APPRV_DT = rTH_APPRV_DT;
	}

	@Column(name="RTH_APPRV_DT")
	private Date RTH_APPRV_DT;

	public String getWP_CUST_CODE() {
		return WP_CUST_CODE;
	}

	public void setWP_CUST_CODE(String wP_CUST_CODE) {
		WP_CUST_CODE = wP_CUST_CODE;
	}
	*/
	
	/*added by nadhiya*/
	
	

	@Column(name="RTH_SYS_ID")
	private int  RTH_SYS_ID;
	
	
	@Column(name="RTH_CR_UID")
	private String  RTH_CR_UID;
	@Column(name="RTH_CR_DT")
	private Date  RTH_CR_DT;
	
	
	public String getRTH_CR_UID() {
		return RTH_CR_UID;
	}

	public void setRTH_CR_UID(String rTH_CR_UID) {
		RTH_CR_UID = rTH_CR_UID;
	}

	public Date getRTH_CR_DT() {
		return RTH_CR_DT;
	}

	public void setRTH_CR_DT(Date rTH_CR_DT) {
		RTH_CR_DT = rTH_CR_DT;
	}

	public int getRTH_SYS_ID() {
		return RTH_SYS_ID;
	}

	public void setRTH_SYS_ID(int rTH_SYS_ID) {
		RTH_SYS_ID = rTH_SYS_ID;
	}

	@Column(name="RTH_SRC_POL_NO")
	private String RTH_SRC_POL_NO;

	@Column(name="RTH_SRC_POL_SYS_ID")
	private int RTH_SRC_POL_SYS_ID;
	
	
	public int getRTH_SRC_POL_SYS_ID() {
		return RTH_SRC_POL_SYS_ID;
	}

	public void setRTH_SRC_POL_SYS_ID(int rTH_SRC_POL_SYS_ID) {
		RTH_SRC_POL_SYS_ID = rTH_SRC_POL_SYS_ID;
	}

	private String WP_CUST_CODE;
	private String WP_CUST_CODE_DESC;
	
	public String getWP_CUST_CODE_DESC() {
		return WP_CUST_CODE_DESC;
	}

	public void setWP_CUST_CODE_DESC(String wP_CUST_CODE_DESC) {
		WP_CUST_CODE_DESC = wP_CUST_CODE_DESC;
	}

	public String getRTH_SRC_POL_NO() {
		return RTH_SRC_POL_NO;
	}

	public void setRTH_SRC_POL_NO(String rTH_SRC_POL_NO) {
		RTH_SRC_POL_NO = rTH_SRC_POL_NO;
	}

	
	public Date getRTH_APPRV_DT() {
		return RTH_APPRV_DT;
	}

	public void setRTH_APPRV_DT(Date rTH_APPRV_DT) {
		RTH_APPRV_DT = rTH_APPRV_DT;
	}

	@Column(name="RTH_APPRV_DT")
	private Date RTH_APPRV_DT;

	public String getWP_CUST_CODE() {
		return WP_CUST_CODE;
	}

	public void setWP_CUST_CODE(String wP_CUST_CODE) {
		WP_CUST_CODE = wP_CUST_CODE;
	}
	
	/*UI Message*/
private String UI_STATUS;
	
	@Column(name="RTH_APPRV_USER")
	private String RTH_APPRV_USER;

	public String getUI_STATUS() {
		return UI_STATUS;
	}

	public void setUI_STATUS(String uI_STATUS) {
		UI_STATUS = uI_STATUS;
	}

	public String getRTH_APPRV_USER() {
		return RTH_APPRV_USER;
	}

	public void setRTH_APPRV_USER(String rTH_APPRV_USER) {
		RTH_APPRV_USER = rTH_APPRV_USER;
	}
	
	@Column(name="RTH_APPRV_STATUS")
	private String RTH_APPRV_STATUS;


	public String getRTH_APPRV_STATUS() {
		return RTH_APPRV_STATUS;
	}

	public void setRTH_APPRV_STATUS(String rTH_APPRV_STATUS) {
		RTH_APPRV_STATUS = rTH_APPRV_STATUS;
	}
	
}

	
	
	

