package com.iii.pel.forms.PILT013;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_DOC_TODO_LIST_STATUS")
public class PT_IL_DOC_TODO_LIST_STATUS extends BaseValueBean {

	@Column(name = "DTLS_SYS_ID")
	private Long DTLS_SYS_ID;

	@Column(name = "DTLS_POL_SYS_ID")
	private Long DTLS_POL_SYS_ID;

	@Column(name = "DTLS_END_NO_IDX")
	private Integer DTLS_END_NO_IDX;

	@Column(name = "DTLS_CLM_SYS_ID")
	private Long DTLS_CLM_SYS_ID;

	@Column(name = "DTLS_SR_NO")
	private Integer DTLS_SR_NO;

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
	private Long DTLS_SMV_SYS_ID;

	@Column(name = "DTLS_WD_SYS_ID")
	private Long DTLS_WD_SYS_ID;

	public void setDTLS_TODO_LIST_ITEM(String DTLS_TODO_LIST_ITEM) {
		this.DTLS_TODO_LIST_ITEM = DTLS_TODO_LIST_ITEM;
	}

	public String getDTLS_TODO_LIST_ITEM() {
		return DTLS_TODO_LIST_ITEM;
	}

	public void setDTLS_CR_UID(String DTLS_CR_UID) {
		this.DTLS_CR_UID = DTLS_CR_UID;
	}

	public String getDTLS_CR_UID() {
		return DTLS_CR_UID;
	}

	public void setDTLS_WD_SYS_ID(Long DTLS_WD_SYS_ID) {
		this.DTLS_WD_SYS_ID = DTLS_WD_SYS_ID;
	}

	public Long getDTLS_WD_SYS_ID() {
		return DTLS_WD_SYS_ID;
	}

	public void setDTLS_UPD_DT(Date DTLS_UPD_DT) {
		this.DTLS_UPD_DT = DTLS_UPD_DT;
	}

	public Date getDTLS_UPD_DT() {
		return DTLS_UPD_DT;
	}

	public void setDTLS_DOC_REC_DT(Date DTLS_DOC_REC_DT) {
		this.DTLS_DOC_REC_DT = DTLS_DOC_REC_DT;
	}

	public Date getDTLS_DOC_REC_DT() {
		return DTLS_DOC_REC_DT;
	}

	public void setDTLS_CLM_SYS_ID(Long DTLS_CLM_SYS_ID) {
		this.DTLS_CLM_SYS_ID = DTLS_CLM_SYS_ID;
	}

	public Long getDTLS_CLM_SYS_ID() {
		return DTLS_CLM_SYS_ID;
	}

	public void setDTLS_SR_NO(Integer DTLS_SR_NO) {
		this.DTLS_SR_NO = DTLS_SR_NO;
	}

	public Integer getDTLS_SR_NO() {
		return DTLS_SR_NO;
	}

	public void setDTLS_POL_SYS_ID(Long DTLS_POL_SYS_ID) {
		this.DTLS_POL_SYS_ID = DTLS_POL_SYS_ID;
	}

	public Long getDTLS_POL_SYS_ID() {
		return DTLS_POL_SYS_ID;
	}

	public void setDTLS_APPR_STS(String DTLS_APPR_STS) {
		this.DTLS_APPR_STS = DTLS_APPR_STS;
	}

	public String getDTLS_APPR_STS() {
		return DTLS_APPR_STS;
	}

	public void setDTLS_MANDATORY_YN(String DTLS_MANDATORY_YN) {
		this.DTLS_MANDATORY_YN = DTLS_MANDATORY_YN;
	}

	public String getDTLS_MANDATORY_YN() {
		return DTLS_MANDATORY_YN;
	}

	public void setDTLS_GROUP_CODE(String DTLS_GROUP_CODE) {
		this.DTLS_GROUP_CODE = DTLS_GROUP_CODE;
	}

	public String getDTLS_GROUP_CODE() {
		return DTLS_GROUP_CODE;
	}

	public void setDTLS_END_NO_IDX(Integer DTLS_END_NO_IDX) {
		this.DTLS_END_NO_IDX = DTLS_END_NO_IDX;
	}

	public Integer getDTLS_END_NO_IDX() {
		return DTLS_END_NO_IDX;
	}

	public void setDTLS_UPD_UID(String DTLS_UPD_UID) {
		this.DTLS_UPD_UID = DTLS_UPD_UID;
	}

	public String getDTLS_UPD_UID() {
		return DTLS_UPD_UID;
	}

	public void setDTLS_SMV_SYS_ID(Long DTLS_SMV_SYS_ID) {
		this.DTLS_SMV_SYS_ID = DTLS_SMV_SYS_ID;
	}

	public Long getDTLS_SMV_SYS_ID() {
		return DTLS_SMV_SYS_ID;
	}

	public void setDTLS_REMARKS(String DTLS_REMARKS) {
		this.DTLS_REMARKS = DTLS_REMARKS;
	}

	public String getDTLS_REMARKS() {
		return DTLS_REMARKS;
	}

	public void setDTLS_SYS_ID(Long DTLS_SYS_ID) {
		this.DTLS_SYS_ID = DTLS_SYS_ID;
	}

	public Long getDTLS_SYS_ID() {
		return DTLS_SYS_ID;
	}

	public void setDTLS_CR_DT(Date DTLS_CR_DT) {
		this.DTLS_CR_DT = DTLS_CR_DT;
	}

	public Date getDTLS_CR_DT() {
		return DTLS_CR_DT;
	}

}
