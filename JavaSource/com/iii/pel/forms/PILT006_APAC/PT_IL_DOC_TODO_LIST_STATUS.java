package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_DOC_TODO_LIST_STATUS")
public class PT_IL_DOC_TODO_LIST_STATUS extends BaseValueBean {

	@Column(name = "DTLS_SYS_ID")
	private Long DTLS_SYS_ID;
	/* Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017 */
	@Column(name = "DTLS_POL_SYS_ID")
	private Long DTLS_POL_SYS_ID;
	/*End*/

	@Column(name = "DTLS_END_NO_IDX")
	private Double DTLS_END_NO_IDX;

	@Column(name = "DTLS_CLM_SYS_ID")
	private Long DTLS_CLM_SYS_ID;

	@Column(name = "DTLS_SR_NO")
	private Long DTLS_SR_NO;

	@Column(name = "DTLS_TODO_LIST_ITEM")
	private String DTLS_TODO_LIST_ITEM;

	@Column(name = "DTLS_MANDATORY_YN")
	private String DTLS_MANDATORY_YN;

	@Column(name = "DTLS_APPR_STS")
	private String DTLS_APPR_STS;

	@Column(name = "DTLS_REMARKS")
	private String DTLS_REMARKS;

	@Column(name = "DTLS_CR_DT")
	private Date DTLS_CR_DT;

	@Column(name = "DTLS_CR_UID")
	private String DTLS_CR_UID;

	@Column(name = "DTLS_UPD_DT")
	private Date DTLS_UPD_DT;

	@Column(name = "DTLS_UPD_UID")
	private String DTLS_UPD_UID;

	@Column(name = "DTLS_GROUP_CODE")
	private String DTLS_GROUP_CODE;

	@Column(name = "DTLS_DOC_REC_DT")
	private Date DTLS_DOC_REC_DT;

	@Column(name = "DTLS_SMV_SYS_ID")
	private Double DTLS_SMV_SYS_ID;

	@Column(name = "DTLS_WD_SYS_ID")
	private Double DTLS_WD_SYS_ID;

	
	/* Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017 */

	public Long getDTLS_POL_SYS_ID() {
		return DTLS_POL_SYS_ID;
	}

	public void setDTLS_POL_SYS_ID(Long dTLS_POL_SYS_ID) {
		DTLS_POL_SYS_ID = dTLS_POL_SYS_ID;
	}
/*End*/
	/**
	 * @return the dTLS_END_NO_IDX
	 */
	public Double getDTLS_END_NO_IDX() {
		return DTLS_END_NO_IDX;
	}

	/**
	 * @param dtls_end_no_idx
	 *            the dTLS_END_NO_IDX to set
	 */
	public void setDTLS_END_NO_IDX(Double dtls_end_no_idx) {
		DTLS_END_NO_IDX = dtls_end_no_idx;
	}

	

	

	/**
	 * @return the dTLS_SR_NO
	 */
	public Long getDTLS_SR_NO() {
		return DTLS_SR_NO;
	}

	/**
	 * @param dtls_sr_no the dTLS_SR_NO to set
	 */
	public void setDTLS_SR_NO(Long dtls_sr_no) {
		DTLS_SR_NO = dtls_sr_no;
	}

	/**
	 * @return the dTLS_TODO_LIST_ITEM
	 */
	public String getDTLS_TODO_LIST_ITEM() {
		return DTLS_TODO_LIST_ITEM;
	}

	/**
	 * @param dtls_todo_list_item
	 *            the dTLS_TODO_LIST_ITEM to set
	 */
	public void setDTLS_TODO_LIST_ITEM(String dtls_todo_list_item) {
		DTLS_TODO_LIST_ITEM = dtls_todo_list_item;
	}

	/**
	 * @return the dTLS_MANDATORY_YN
	 */
	public String getDTLS_MANDATORY_YN() {
		return DTLS_MANDATORY_YN;
	}

	/**
	 * @param dtls_mandatory_yn
	 *            the dTLS_MANDATORY_YN to set
	 */
	public void setDTLS_MANDATORY_YN(String dtls_mandatory_yn) {
		DTLS_MANDATORY_YN = dtls_mandatory_yn;
	}

	/**
	 * @return the dTLS_APPR_STS
	 */
	public String getDTLS_APPR_STS() {
		return DTLS_APPR_STS;
	}

	/**
	 * @param dtls_appr_sts
	 *            the dTLS_APPR_STS to set
	 */
	public void setDTLS_APPR_STS(String dtls_appr_sts) {
		DTLS_APPR_STS = dtls_appr_sts;
	}

	/**
	 * @return the dTLS_REMARKS
	 */
	public String getDTLS_REMARKS() {
		return DTLS_REMARKS;
	}

	/**
	 * @param dtls_remarks
	 *            the dTLS_REMARKS to set
	 */
	public void setDTLS_REMARKS(String dtls_remarks) {
		DTLS_REMARKS = dtls_remarks;
	}

	/**
	 * @return the dTLS_CR_DT
	 */
	public Date getDTLS_CR_DT() {
		return DTLS_CR_DT;
	}

	/**
	 * @param dtls_cr_dt
	 *            the dTLS_CR_DT to set
	 */
	public void setDTLS_CR_DT(Date dtls_cr_dt) {
		DTLS_CR_DT = dtls_cr_dt;
	}

	/**
	 * @return the dTLS_CR_UID
	 */
	public String getDTLS_CR_UID() {
		return DTLS_CR_UID;
	}

	/**
	 * @param dtls_cr_uid
	 *            the dTLS_CR_UID to set
	 */
	public void setDTLS_CR_UID(String dtls_cr_uid) {
		DTLS_CR_UID = dtls_cr_uid;
	}

	/**
	 * @return the dTLS_UPD_DT
	 */
	public Date getDTLS_UPD_DT() {
		return DTLS_UPD_DT;
	}

	/**
	 * @param dtls_upd_dt
	 *            the dTLS_UPD_DT to set
	 */
	public void setDTLS_UPD_DT(Date dtls_upd_dt) {
		DTLS_UPD_DT = dtls_upd_dt;
	}

	/**
	 * @return the dTLS_UPD_UID
	 */
	public String getDTLS_UPD_UID() {
		return DTLS_UPD_UID;
	}

	/**
	 * @param dtls_upd_uid
	 *            the dTLS_UPD_UID to set
	 */
	public void setDTLS_UPD_UID(String dtls_upd_uid) {
		DTLS_UPD_UID = dtls_upd_uid;
	}

	/**
	 * @return the dTLS_GROUP_CODE
	 */
	public String getDTLS_GROUP_CODE() {
		return DTLS_GROUP_CODE;
	}

	/**
	 * @param dtls_group_code
	 *            the dTLS_GROUP_CODE to set
	 */
	public void setDTLS_GROUP_CODE(String dtls_group_code) {
		DTLS_GROUP_CODE = dtls_group_code;
	}

	/**
	 * @return the dTLS_DOC_REC_DT
	 */
	public Date getDTLS_DOC_REC_DT() {
		return DTLS_DOC_REC_DT;
	}

	/**
	 * @param dtls_doc_rec_dt
	 *            the dTLS_DOC_REC_DT to set
	 */
	public void setDTLS_DOC_REC_DT(Date dtls_doc_rec_dt) {
		DTLS_DOC_REC_DT = dtls_doc_rec_dt;
	}

	/**
	 * @return the dTLS_SMV_SYS_ID
	 */
	public Double getDTLS_SMV_SYS_ID() {
		return DTLS_SMV_SYS_ID;
	}

	/**
	 * @param dtls_smv_sys_id
	 *            the dTLS_SMV_SYS_ID to set
	 */
	public void setDTLS_SMV_SYS_ID(Double dtls_smv_sys_id) {
		DTLS_SMV_SYS_ID = dtls_smv_sys_id;
	}

	/**
	 * @return the dTLS_WD_SYS_ID
	 */
	public Double getDTLS_WD_SYS_ID() {
		return DTLS_WD_SYS_ID;
	}

	/**
	 * @param dtls_wd_sys_id
	 *            the dTLS_WD_SYS_ID to set
	 */
	public void setDTLS_WD_SYS_ID(Double dtls_wd_sys_id) {
		DTLS_WD_SYS_ID = dtls_wd_sys_id;
	}

	/**
	 * @return the dTLS_SYS_ID
	 */
	public Long getDTLS_SYS_ID() {
		return DTLS_SYS_ID;
	}

	/**
	 * @param dtls_sys_id the dTLS_SYS_ID to set
	 */
	public void setDTLS_SYS_ID(Long dtls_sys_id) {
		DTLS_SYS_ID = dtls_sys_id;
	}

	/**
	 * @return the dTLS_CLM_SYS_ID
	 */
	public Long getDTLS_CLM_SYS_ID() {
		return DTLS_CLM_SYS_ID;
	}

	/**
	 * @param dtls_clm_sys_id the dTLS_CLM_SYS_ID to set
	 */
	public void setDTLS_CLM_SYS_ID(Long dtls_clm_sys_id) {
		DTLS_CLM_SYS_ID = dtls_clm_sys_id;
	}
	/*Added by saranya for Avoidance of POST button required in all screens on 21/02/2017*/
	private String FIELD1_ENABLE;
	private String FIELD2_ENABLE;
	public String getFIELD1_ENABLE() {
		return FIELD1_ENABLE;
	}
	public void setFIELD1_ENABLE(String fIELD1_ENABLE) {
		FIELD1_ENABLE = fIELD1_ENABLE;
	}
	public String getFIELD2_ENABLE() {
		return FIELD2_ENABLE;
	}
	public void setFIELD2_ENABLE(String fIELD2_ENABLE) {
		FIELD2_ENABLE = fIELD2_ENABLE;
	}
	/*End*/
}
