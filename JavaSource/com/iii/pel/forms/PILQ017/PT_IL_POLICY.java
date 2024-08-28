package com.iii.pel.forms.PILQ017;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POLICY")
public class PT_IL_POLICY extends BaseValueBean {

	@Id
	@Column(name="ROWID")
	private String ROWID;
	
	@Column(name="POL_NO")
	private String POL_NO;

	@Column(name="POL_PROD_CODE")
	private String POL_PROD_CODE;

	@Column(name="POL_TRAN_DT")
	private Date POL_TRAN_DT;

	@Column(name="POL_ISSUE_DT")
	private Date POL_ISSUE_DT;
	
	@Column(name="POL_DS_TYPE")
	private String POL_DS_TYPE;
	
	private String UI_M_POL_PROP;

	@Column(name="POL_ADDL_STATUS")
	private String POL_ADDL_STATUS;

	private String UI_M_PROD_DESC;

	private String UI_M_STATUS_DESC;

	private boolean CHECK_BOX;


	public String getPOL_NO() {
		return POL_NO;
	}

	public void setPOL_NO(String POL_NO) {
		this.POL_NO = POL_NO;
	}

	public String getPOL_PROD_CODE() {
		return POL_PROD_CODE;
	}

	public void setPOL_PROD_CODE(String POL_PROD_CODE) {
		this.POL_PROD_CODE = POL_PROD_CODE;
	}

	public Date getPOL_TRAN_DT() {
		 return POL_TRAN_DT;
	}

	public void setPOL_TRAN_DT(Date POL_TRAN_DT) {
		this.POL_TRAN_DT = POL_TRAN_DT;
	}

	public String getUI_M_POL_PROP() {
		return UI_M_POL_PROP;
	}

	public void setUI_M_POL_PROP(String UI_M_POL_PROP) {
		this.UI_M_POL_PROP = UI_M_POL_PROP;
	}

	public String getPOL_ADDL_STATUS() {
		return POL_ADDL_STATUS;
	}

	public void setPOL_ADDL_STATUS(String POL_ADDL_STATUS) {
		this.POL_ADDL_STATUS = POL_ADDL_STATUS;
	}

	public String getUI_M_PROD_DESC() {
		return UI_M_PROD_DESC;
	}

	public void setUI_M_PROD_DESC(String UI_M_PROD_DESC) {
		this.UI_M_PROD_DESC = UI_M_PROD_DESC;
	}

	public String getUI_M_STATUS_DESC() {
		return UI_M_STATUS_DESC;
	}

	public void setUI_M_STATUS_DESC(String UI_M_STATUS_DESC) {
		this.UI_M_STATUS_DESC = UI_M_STATUS_DESC;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}


	public String getPOL_DS_TYPE() {
		return POL_DS_TYPE;
	}


	public void setPOL_DS_TYPE(String pol_ds_type) {
		POL_DS_TYPE = pol_ds_type;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Date getPOL_ISSUE_DT() {
		return POL_ISSUE_DT;
	}

	public void setPOL_ISSUE_DT(Date pol_issue_dt) {
		POL_ISSUE_DT = pol_issue_dt;
	}
}
