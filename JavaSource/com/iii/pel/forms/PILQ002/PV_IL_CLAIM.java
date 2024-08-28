package com.iii.pel.forms.PILQ002;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PV_IL_CLAIM")
public class PV_IL_CLAIM extends BaseValueBean{
	
	@Column(name="ROWID")
	private String ROWID;

	@Column(name="CLAIM_NO")
	private String CLAIM_NO;

	@Column(name="CLAIM_TYPE")
	private String CLAIM_TYPE;

	@Column(name="CLAIM_STATUS")
	private String CLAIM_STATUS;

	@Column(name="CP_FC_PAID_AMT")
	private Double CP_FC_PAID_AMT;

	@Column(name="CP_LC_PAID_AMT")
	private Double CP_LC_PAID_AMT;

	@Column(name="CP_PAID_DT")
	private Date CP_PAID_DT;

	@Column(name="CBEN_BNF_TYPE")
	private String CBEN_BNF_TYPE;

	private String UI_M_TYPE_DESC;

	@Column(name="CBEN_RELATION_CODE")
	private String CBEN_RELATION_CODE;

	@Column(name="CBEN_BNF_NAME")
	private String CBEN_BNF_NAME;

	@Column(name="CBEN_FC_PAID_AMT")
	private Double CBEN_FC_PAID_AMT;

	@Column(name="CBEN_LC_PAID_AMT")
	private Double CBEN_LC_PAID_AMT;



	public String getCLAIM_NO() {
		return CLAIM_NO;
	}

	public void setCLAIM_NO(String CLAIM_NO) {
		this.CLAIM_NO = CLAIM_NO;
	}

	public String getCLAIM_TYPE() {
		return CLAIM_TYPE;
	}

	public void setCLAIM_TYPE(String CLAIM_TYPE) {
		this.CLAIM_TYPE = CLAIM_TYPE;
	}

	public String getCLAIM_STATUS() {
		return CLAIM_STATUS;
	}

	public void setCLAIM_STATUS(String CLAIM_STATUS) {
		this.CLAIM_STATUS = CLAIM_STATUS;
	}

	public Double getCP_FC_PAID_AMT() {
		return CP_FC_PAID_AMT;
	}

	public void setCP_FC_PAID_AMT(Double CP_FC_PAID_AMT) {
		this.CP_FC_PAID_AMT = CP_FC_PAID_AMT;
	}

	public Double getCP_LC_PAID_AMT() {
		return CP_LC_PAID_AMT;
	}

	public void setCP_LC_PAID_AMT(Double CP_LC_PAID_AMT) {
		this.CP_LC_PAID_AMT = CP_LC_PAID_AMT;
	}

	public Date getCP_PAID_DT() {
		 return CP_PAID_DT;
	}

	public void setCP_PAID_DT(Date CP_PAID_DT) {
		this.CP_PAID_DT = CP_PAID_DT;
	}

	public String getCBEN_BNF_TYPE() {
		return CBEN_BNF_TYPE;
	}

	public void setCBEN_BNF_TYPE(String CBEN_BNF_TYPE) {
		this.CBEN_BNF_TYPE = CBEN_BNF_TYPE;
	}

	public String getUI_M_TYPE_DESC() {
		return UI_M_TYPE_DESC;
	}

	public void setUI_M_TYPE_DESC(String UI_M_TYPE_DESC) {
		this.UI_M_TYPE_DESC = UI_M_TYPE_DESC;
	}

	public String getCBEN_RELATION_CODE() {
		return CBEN_RELATION_CODE;
	}

	public void setCBEN_RELATION_CODE(String CBEN_RELATION_CODE) {
		this.CBEN_RELATION_CODE = CBEN_RELATION_CODE;
	}

	public String getCBEN_BNF_NAME() {
		return CBEN_BNF_NAME;
	}

	public void setCBEN_BNF_NAME(String CBEN_BNF_NAME) {
		this.CBEN_BNF_NAME = CBEN_BNF_NAME;
	}

	public Double getCBEN_FC_PAID_AMT() {
		return CBEN_FC_PAID_AMT;
	}

	public void setCBEN_FC_PAID_AMT(Double CBEN_FC_PAID_AMT) {
		this.CBEN_FC_PAID_AMT = CBEN_FC_PAID_AMT;
	}

	public Double getCBEN_LC_PAID_AMT() {
		return CBEN_LC_PAID_AMT;
	}

	public void setCBEN_LC_PAID_AMT(Double CBEN_LC_PAID_AMT) {
		this.CBEN_LC_PAID_AMT = CBEN_LC_PAID_AMT;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}
	
	/*Added by Janani on 4.03.2017 for status desc*/
	
	private String UI_M_STATUS_DESC;


	public String getUI_M_STATUS_DESC() {
		return UI_M_STATUS_DESC;
	}

	public void setUI_M_STATUS_DESC(String uI_M_STATUS_DESC) {
		UI_M_STATUS_DESC = uI_M_STATUS_DESC;
	}
	
	
	
	/*end*/
	
}
