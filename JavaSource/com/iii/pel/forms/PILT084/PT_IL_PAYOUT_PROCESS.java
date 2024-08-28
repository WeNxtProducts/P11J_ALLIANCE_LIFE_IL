package com.iii.pel.forms.PILT084;

import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PAYOUT_PROCESS")
public class PT_IL_PAYOUT_PROCESS extends BaseValueBean{

	@Column(name="PP_SYS_ID")
	private Long PP_SYS_ID;
	
	@Column(name="PP_PAYOUT_DT")
	private Date PP_PAYOUT_DT;
	
	@Column (name="PP_PAYOUT_TYPE")
	private String PP_PAYOUT_TYPE;
	
	@Column (name="PP_PAYOUT_AMT")
	private Double PP_PAYOUT_AMT;
	
	@Column(name="PP_PAYOUT_STATUS")
	private String PP_PAYOUT_STATUS;

	@Column(name="PP_PAYOUT_REMARK")
	private String PP_PAYOUT_REMARK;

	public Long getPP_SYS_ID() {
		return PP_SYS_ID;
	}

	public void setPP_SYS_ID(Long pP_SYS_ID) {
		PP_SYS_ID = pP_SYS_ID;
	}

	public Date getPP_PAYOUT_DT() {
		return PP_PAYOUT_DT;
	}

	public void setPP_PAYOUT_DT(Date pP_PAYOUT_DT) {
		PP_PAYOUT_DT = pP_PAYOUT_DT;
	}

	public String getPP_PAYOUT_TYPE() {
		return PP_PAYOUT_TYPE;
	}

	public void setPP_PAYOUT_TYPE(String pP_PAYOUT_TYPE) {
		PP_PAYOUT_TYPE = pP_PAYOUT_TYPE;
	}

	public Double getPP_PAYOUT_AMT() {
		return PP_PAYOUT_AMT;
	}

	public void setPP_PAYOUT_AMT(Double pP_PAYOUT_AMT) {
		PP_PAYOUT_AMT = pP_PAYOUT_AMT;
	}

	public String getPP_PAYOUT_STATUS() {
		return PP_PAYOUT_STATUS;
	}

	public void setPP_PAYOUT_STATUS(String pP_PAYOUT_STATUS) {
		PP_PAYOUT_STATUS = pP_PAYOUT_STATUS;
	}

	public String getPP_PAYOUT_REMARK() {
		return PP_PAYOUT_REMARK;
	}

	public void setPP_PAYOUT_REMARK(String pP_PAYOUT_REMARK) {
		PP_PAYOUT_REMARK = pP_PAYOUT_REMARK;
	}
	
	@Column(name="PP_CR_DT")
	private Date PP_CR_DT;

	@Column(name="PP_CR_UID")
	private String PP_CR_UID;

	@Column(name="PP_UPD_DT")
	private Date PP_UPD_DT;

	public Date getPP_CR_DT() {
		return PP_CR_DT;
	}

	public void setPP_CR_DT(Date pP_CR_DT) {
		PP_CR_DT = pP_CR_DT;
	}

	public String getPP_CR_UID() {
		return PP_CR_UID;
	}

	public void setPP_CR_UID(String pP_CR_UID) {
		PP_CR_UID = pP_CR_UID;
	}

	public Date getPP_UPD_DT() {
		return PP_UPD_DT;
	}

	public void setPP_UPD_DT(Date pP_UPD_DT) {
		PP_UPD_DT = pP_UPD_DT;
	}

	public String getPP_UPD_UID() {
		return PP_UPD_UID;
	}

	public void setPP_UPD_UID(String pP_UPD_UID) {
		PP_UPD_UID = pP_UPD_UID;
	}

	@Column(name="PP_UPD_UID")
	private String PP_UPD_UID;
	
	@Column(name="PP_POL_SYS_ID")
	private Long PP_POL_SYS_ID;
	
	public Long getPP_POL_SYS_ID() {
		return PP_POL_SYS_ID;
	}

	public void setPP_POL_SYS_ID(Long pP_POL_SYS_ID) {
		PP_POL_SYS_ID = pP_POL_SYS_ID;
	}

	public Long getPP_TRANS_SYS_ID() {
		return PP_TRANS_SYS_ID;
	}

	public void setPP_TRANS_SYS_ID(Long pP_TRANS_SYS_ID) {
		PP_TRANS_SYS_ID = pP_TRANS_SYS_ID;
	}

	public String getUI_M_PAYOUT_STATUS() {
		return UI_M_PAYOUT_STATUS;
	}

	public void setUI_M_PAYOUT_STATUS(String uI_M_PAYOUT_STATUS) {
		UI_M_PAYOUT_STATUS = uI_M_PAYOUT_STATUS;
	}

	public String getUI_M_REMARKS() {
		return UI_M_REMARKS;
	}

	public void setUI_M_REMARKS(String uI_M_REMARKS) {
		UI_M_REMARKS = uI_M_REMARKS;
	}

	@Column(name="PP_TRANS_SYS_ID")
	private Long PP_TRANS_SYS_ID;
	
	private String UI_M_PAYOUT_STATUS;
	private String UI_M_REMARKS;

	/*Added by saritha on 03-01-2020 for ORIENT- OCD Payout Process Policy No&Payee Name column added*/
	
	@Column(name="PP_POL_NO")
	private String PP_POL_NO;
	
	@Column(name="PP_PAYEE_NAME")
	private String PP_PAYEE_NAME;

	public String getPP_POL_NO() {
		return PP_POL_NO;
	}

	public void setPP_POL_NO(String pP_POL_NO) {
		PP_POL_NO = pP_POL_NO;
	}

	public String getPP_PAYEE_NAME() {
		return PP_PAYEE_NAME;
	}

	public void setPP_PAYEE_NAME(String pP_PAYEE_NAME) {
		PP_PAYEE_NAME = pP_PAYEE_NAME;
	}
	
	/*End*/
	/*Commented and modified by senthilnathan on 25.06.2020
	 *  issues desc: Net amount should be shown instead of Gross amount*/
	
	@Column (name="PP_PAYOUT_NET_AMT")
	private Double PP_PAYOUT_NET_AMT;

	public Double getPP_PAYOUT_NET_AMT() {
		return PP_PAYOUT_NET_AMT;
	}

	public void setPP_PAYOUT_NET_AMT(Double pP_PAYOUT_NET_AMT) {
		PP_PAYOUT_NET_AMT = pP_PAYOUT_NET_AMT;
	}
	
	/*End*/
	
	

}
