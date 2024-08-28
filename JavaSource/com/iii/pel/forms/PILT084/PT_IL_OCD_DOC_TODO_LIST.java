package com.iii.pel.forms.PILT084;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_OCD_DOC_TODO_LIST")
public class PT_IL_OCD_DOC_TODO_LIST extends BaseValueBean {

	@Column(name = "OCD_DTL_SYS_ID")
	private Long OCD_DTL_SYS_ID;

	@Column(name = "OCD_DTL_POL_SYS_ID")
	private Long OCD_DTL_POL_SYS_ID;

	@Column(name = "OCD_DTL_END_NO_IDX")
	private Integer OCD_DTL_END_NO_IDX;

	@Column(name = "OCD_DTL_CLM_SYS_ID")
	private Long OCD_DTL_CLM_SYS_ID;

	@Column(name = "OCD_DTL_SR_NO")
	private Double OCD_DTL_SR_NO;

	@Column(name = "OCD_DTL_TODO_LIST_ITEM")
	private String OCD_DTL_TODO_LIST_ITEM;

	@Column(name = "OCD_DTL_MANDATORY_YN")
	private String OCD_DTL_MANDATORY_YN;

	@Column(name = "OCD_DTL_APPR_STS")
	private String OCD_DTL_APPR_STS;

	@Column(name = "OCD_DTL_REMARKS")
	private String OCD_DTL_REMARKS;

	@Column(name = "OCD_DTL_CR_DT")
	private Date OCD_DTL_CR_DT;

	@Column(name = "OCD_DTL_CR_UID")
	private String OCD_DTL_CR_UID;

	@Column(name = "OCD_DTL_UPD_DT")
	private Date OCD_DTL_UPD_DT;

	@Column(name = "OCD_DTL_UPD_UID")
	private String OCD_DTL_UPD_UID;

	@Column(name = "OCD_DTL_GROUP_CODE")
	private String OCD_DTL_GROUP_CODE;

	@Column(name = "OCD_DTL_DOC_REC_DT")
	private Date OCD_DTL_DOC_REC_DT;

	@Column(name = "OCD_DTL_SMV_SYS_ID")
	private Long OCD_DTL_SMV_SYS_ID;

	@Column(name = "OCD_DTL_WD_SYS_ID")
	private Long OCD_DTL_WD_SYS_ID;

	public String getUI_M_GRP_CHKLST_DESC() {
		return UI_M_GRP_CHKLST_DESC;
	}

	public Long getOCD_DTL_SYS_ID() {
		return OCD_DTL_SYS_ID;
	}

	public void setOCD_DTL_SYS_ID(Long oCD_DTL_SYS_ID) {
		OCD_DTL_SYS_ID = oCD_DTL_SYS_ID;
	}

	public Long getOCD_DTL_POL_SYS_ID() {
		return OCD_DTL_POL_SYS_ID;
	}

	public void setOCD_DTL_POL_SYS_ID(Long oCD_DTL_POL_SYS_ID) {
		OCD_DTL_POL_SYS_ID = oCD_DTL_POL_SYS_ID;
	}

	public Integer getOCD_DTL_END_NO_IDX() {
		return OCD_DTL_END_NO_IDX;
	}

	public void setOCD_DTL_END_NO_IDX(Integer oCD_DTL_END_NO_IDX) {
		OCD_DTL_END_NO_IDX = oCD_DTL_END_NO_IDX;
	}

	public Long getOCD_DTL_CLM_SYS_ID() {
		return OCD_DTL_CLM_SYS_ID;
	}

	public void setOCD_DTL_CLM_SYS_ID(Long oCD_DTL_CLM_SYS_ID) {
		OCD_DTL_CLM_SYS_ID = oCD_DTL_CLM_SYS_ID;
	}

	public Double getOCD_DTL_SR_NO() {
		return OCD_DTL_SR_NO;
	}

	public void setOCD_DTL_SR_NO(Double oCD_DTL_SR_NO) {
		OCD_DTL_SR_NO = oCD_DTL_SR_NO;
	}

	public String getOCD_DTL_TODO_LIST_ITEM() {
		return OCD_DTL_TODO_LIST_ITEM;
	}

	public void setOCD_DTL_TODO_LIST_ITEM(String oCD_DTL_TODO_LIST_ITEM) {
		OCD_DTL_TODO_LIST_ITEM = oCD_DTL_TODO_LIST_ITEM;
	}

	public String getOCD_DTL_MANDATORY_YN() {
		return OCD_DTL_MANDATORY_YN;
	}

	public void setOCD_DTL_MANDATORY_YN(String oCD_DTL_MANDATORY_YN) {
		OCD_DTL_MANDATORY_YN = oCD_DTL_MANDATORY_YN;
	}

	public String getOCD_DTL_APPR_STS() {
		return OCD_DTL_APPR_STS;
	}

	public void setOCD_DTL_APPR_STS(String oCD_DTL_APPR_STS) {
		OCD_DTL_APPR_STS = oCD_DTL_APPR_STS;
	}

	public String getOCD_DTL_REMARKS() {
		return OCD_DTL_REMARKS;
	}

	public void setOCD_DTL_REMARKS(String oCD_DTL_REMARKS) {
		OCD_DTL_REMARKS = oCD_DTL_REMARKS;
	}

	public Date getOCD_DTL_CR_DT() {
		return OCD_DTL_CR_DT;
	}

	public void setOCD_DTL_CR_DT(Date oCD_DTL_CR_DT) {
		OCD_DTL_CR_DT = oCD_DTL_CR_DT;
	}

	public String getOCD_DTL_CR_UID() {
		return OCD_DTL_CR_UID;
	}

	public void setOCD_DTL_CR_UID(String oCD_DTL_CR_UID) {
		OCD_DTL_CR_UID = oCD_DTL_CR_UID;
	}

	public Date getOCD_DTL_UPD_DT() {
		return OCD_DTL_UPD_DT;
	}

	public void setOCD_DTL_UPD_DT(Date oCD_DTL_UPD_DT) {
		OCD_DTL_UPD_DT = oCD_DTL_UPD_DT;
	}

	public String getOCD_DTL_UPD_UID() {
		return OCD_DTL_UPD_UID;
	}

	public void setOCD_DTL_UPD_UID(String oCD_DTL_UPD_UID) {
		OCD_DTL_UPD_UID = oCD_DTL_UPD_UID;
	}

	public String getOCD_DTL_GROUP_CODE() {
		return OCD_DTL_GROUP_CODE;
	}

	public void setOCD_DTL_GROUP_CODE(String oCD_DTL_GROUP_CODE) {
		OCD_DTL_GROUP_CODE = oCD_DTL_GROUP_CODE;
	}

	public Date getOCD_DTL_DOC_REC_DT() {
		return OCD_DTL_DOC_REC_DT;
	}

	public void setOCD_DTL_DOC_REC_DT(Date oCD_DTL_DOC_REC_DT) {
		OCD_DTL_DOC_REC_DT = oCD_DTL_DOC_REC_DT;
	}

	public Long getOCD_DTL_SMV_SYS_ID() {
		return OCD_DTL_SMV_SYS_ID;
	}

	public void setOCD_DTL_SMV_SYS_ID(Long oCD_DTL_SMV_SYS_ID) {
		OCD_DTL_SMV_SYS_ID = oCD_DTL_SMV_SYS_ID;
	}

	public Long getOCD_DTL_WD_SYS_ID() {
		return OCD_DTL_WD_SYS_ID;
	}

	public void setOCD_DTL_WD_SYS_ID(Long oCD_DTL_WD_SYS_ID) {
		OCD_DTL_WD_SYS_ID = oCD_DTL_WD_SYS_ID;
	}

	public void setUI_M_GRP_CHKLST_DESC(String uI_M_GRP_CHKLST_DESC) {
		UI_M_GRP_CHKLST_DESC = uI_M_GRP_CHKLST_DESC;
	}

	private String UI_M_GRP_CHKLST_DESC;

	private String UI_M_CHKLST_STATUS;

	public String getUI_M_CHKLST_STATUS() {
		return UI_M_CHKLST_STATUS;
	}

	public void setUI_M_CHKLST_STATUS(String uI_M_CHKLST_STATUS) {
		UI_M_CHKLST_STATUS = uI_M_CHKLST_STATUS;
	}
	
	@Column(name = "OCD_DTL_TRANS_SYS_ID")
	private Long OCD_DTL_TRANS_SYS_ID;

	public Long getOCD_DTL_TRANS_SYS_ID() {
		return OCD_DTL_TRANS_SYS_ID;
	}

	public void setOCD_DTL_TRANS_SYS_ID(Long oCD_DTL_TRANS_SYS_ID) {
		OCD_DTL_TRANS_SYS_ID = oCD_DTL_TRANS_SYS_ID;
	}

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
}
