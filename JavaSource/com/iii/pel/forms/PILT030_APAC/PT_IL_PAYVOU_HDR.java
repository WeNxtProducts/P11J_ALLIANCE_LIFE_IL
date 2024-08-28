package com.iii.pel.forms.PILT030_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_PAYVOU_HDR")
public class PT_IL_PAYVOU_HDR extends BaseValueBean{

	@Column(name="PAH_FM_DT")
	private Date PAH_FM_DT;

	@Column(name="PAH_TO_DT")
	private Date PAH_TO_DT;

	@Column(name="PAH_CONTROL_NO")
	private String PAH_CONTROL_NO;

	@Column(name="PAH_APPRV_DT")
	private Date PAH_APPRV_DT;

	@Column(name="PAH_FREEZE_FLAG")
	private String PAH_FREEZE_FLAG;
	
	/*@Column(name="PAPD_CHQ_DT")
	private Date PAPD_CHQ_DT;*/
	
	/*@Column(name="PAPD_DOC_NO")
	private Double PAPD_DOC_NO;*/
	
	//@Column(name="PAPD_DOC_DT")
	//private Date PAPD_DOC_DT;
	
	@Column(name="PAH_SYS_ID")
	private Integer PAH_SYS_ID;
	
	@Column(name="PAH_TYPE")
	private String PAH_TYPE;
	
	@Column(name="PAH_PRO_DT")
	private Date PAH_PRO_DT;
	
	@Column(name="PAH_APPRV_STATUS")
	private String PAH_APPRV_STATUS;
	
	@Column(name="PAH_MATCH_STATUS")
	private String PAH_MATCH_STATUS;
	
	@Column(name="PAH_REF_NO")
	private String PAH_REF_NO;
	
	private String UI_M_APPRV_STATUS;
	
	private String UI_M_CLAIM_POL_NO;
	
	@Column(name="PAH_CR_DT")
	private Date PAH_CR_DT;
	        	      
	@Column(name="PAH_CR_UID")
	private String PAH_CR_UID; 
	

	public String getUI_M_CLAIM_POL_NO() {
		return UI_M_CLAIM_POL_NO;
	}

	public void setUI_M_CLAIM_POL_NO(String ui_m_claim_pol_no) {
		UI_M_CLAIM_POL_NO = ui_m_claim_pol_no;
	}

	public String getUI_M_APPRV_STATUS() {
		return UI_M_APPRV_STATUS;
	}

	public void setUI_M_APPRV_STATUS(String ui_m_apprv_status) {
		UI_M_APPRV_STATUS = ui_m_apprv_status;
	}

	public Integer getPAH_SYS_ID() {
		return PAH_SYS_ID;
	}

	public void setPAH_SYS_ID(Integer pah_sys_id) {
		PAH_SYS_ID = pah_sys_id;
	}

	public Date getPAH_FM_DT() {
		 return PAH_FM_DT;
	}

	public void setPAH_FM_DT(Date PAH_FM_DT) {
		this.PAH_FM_DT = PAH_FM_DT;
	}

	public Date getPAH_TO_DT() {
		 return PAH_TO_DT;
	}

	public void setPAH_TO_DT(Date PAH_TO_DT) {
		this.PAH_TO_DT = PAH_TO_DT;
	}

	public String getPAH_CONTROL_NO() {
		return PAH_CONTROL_NO;
	}

	public void setPAH_CONTROL_NO(String PAH_CONTROL_NO) {
		this.PAH_CONTROL_NO = PAH_CONTROL_NO;
	}

	public Date getPAH_APPRV_DT() {
		 return PAH_APPRV_DT;
	}

	public void setPAH_APPRV_DT(Date PAH_APPRV_DT) {
		this.PAH_APPRV_DT = PAH_APPRV_DT;
	}

	public String getPAH_FREEZE_FLAG() {
		return PAH_FREEZE_FLAG;
	}

	public void setPAH_FREEZE_FLAG(String PAH_FREEZE_FLAG) {
		this.PAH_FREEZE_FLAG = PAH_FREEZE_FLAG;
	}

	/*public Date getPAPD_CHQ_DT() {
		return PAPD_CHQ_DT;
	}

	public void setPAPD_CHQ_DT(Date papd_chq_dt) {
		PAPD_CHQ_DT = papd_chq_dt;
	}*/

	/*public Double getPAPD_DOC_NO() {
		return PAPD_DOC_NO;
	}

	public void setPAPD_DOC_NO(Double papd_doc_no) {
		PAPD_DOC_NO = papd_doc_no;
	}*/

	//public Date getPAPD_DOC_DT() {
	//	return PAPD_DOC_DT;
	//}

	//public void setPAPD_DOC_DT(Date papd_doc_dt) {
	//	PAPD_DOC_DT = papd_doc_dt;
	//}

	public String getPAH_TYPE() {
		return PAH_TYPE;
	}

	public void setPAH_TYPE(String pah_type) {
		PAH_TYPE = pah_type;
	}

	public Date getPAH_PRO_DT() {
		return PAH_PRO_DT;
	}

	public void setPAH_PRO_DT(Date pah_pro_dt) {
		PAH_PRO_DT = pah_pro_dt;
	}

	public String getPAH_APPRV_STATUS() {
		return PAH_APPRV_STATUS;
	}

	public void setPAH_APPRV_STATUS(String pah_apprv_status) {
		PAH_APPRV_STATUS = pah_apprv_status;
	}

	public String getPAH_MATCH_STATUS() {
		return PAH_MATCH_STATUS;
	}

	public void setPAH_MATCH_STATUS(String pah_match_status) {
		PAH_MATCH_STATUS = pah_match_status;
	}

	public String getPAH_REF_NO() {
		return PAH_REF_NO;
	}

	public void setPAH_REF_NO(String pah_ref_no) {
		PAH_REF_NO = pah_ref_no;
	}

	public Date getPAH_CR_DT() {
		return PAH_CR_DT;
	}

	public void setPAH_CR_DT(Date pah_cr_dt) {
		PAH_CR_DT = pah_cr_dt;
	}

	public String getPAH_CR_UID() {
		return PAH_CR_UID;
	}

	public void setPAH_CR_UID(String pah_cr_uid) {
		PAH_CR_UID = pah_cr_uid;
	}
}
