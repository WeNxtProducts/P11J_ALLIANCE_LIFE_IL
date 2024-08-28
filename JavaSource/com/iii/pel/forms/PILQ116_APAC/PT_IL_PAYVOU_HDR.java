package com.iii.pel.forms.PILQ116_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PT_IL_PAYVOU_HDR")
public class PT_IL_PAYVOU_HDR extends BaseValueBean {

	@Column(name = "PAH_SYS_ID")
	private Long PAH_SYS_ID;

	@Column(name = "PAH_CONTROL_NO")
	private String PAH_CONTROL_NO;

	@Column(name = "PAH_TYPE")
	private String PAH_TYPE;

	@Column(name = "PAH_FM_DT")
	private Date PAH_FM_DT;

	@Column(name = "PAH_TO_DT")
	private Date PAH_TO_DT;

	@Column(name = "PAH_PRO_DT")
	private Date PAH_PRO_DT;

	@Column(name = "PAH_FREEZE_FLAG")
	private String PAH_FREEZE_FLAG;

	@Column(name = "PAH_APPRV_DT")
	private Date PAH_APPRV_DT;

	@Column(name = "PAH_APPRV_STATUS")
	private String PAH_APPRV_STATUS;

	@Column(name = "PAH_MATCH_STATUS")
	private String PAH_MATCH_STATUS;

	@Column(name = "PAH_CR_DT")
	private Date PAH_CR_DT;

	@Column(name = "PAH_CR_UID")
	private String PAH_CR_UID;

	@Column(name = "PAH_UPD_DT")
	private Date PAH_UPD_DT;

	@Column(name = "PAH_UPD_UID")
	private String PAH_UPD_UID;

	@Column(name = "PAH_REF_NO")
	private String PAH_REF_NO;

	public void setPAH_SYS_ID(Long PAH_SYS_ID) {
		this.PAH_SYS_ID = PAH_SYS_ID;
	}

	public Long getPAH_SYS_ID() {
		return PAH_SYS_ID;
	}

	public void setPAH_UPD_DT(Date PAH_UPD_DT) {
		this.PAH_UPD_DT = PAH_UPD_DT;
	}

	public Date getPAH_UPD_DT() {
		return PAH_UPD_DT;
	}

	public void setPAH_CR_UID(String PAH_CR_UID) {
		this.PAH_CR_UID = PAH_CR_UID;
	}

	public String getPAH_CR_UID() {
		return PAH_CR_UID;
	}

	public void setPAH_UPD_UID(String PAH_UPD_UID) {
		this.PAH_UPD_UID = PAH_UPD_UID;
	}

	public String getPAH_UPD_UID() {
		return PAH_UPD_UID;
	}

	public void setPAH_REF_NO(String PAH_REF_NO) {
		this.PAH_REF_NO = PAH_REF_NO;
	}

	public String getPAH_REF_NO() {
		return PAH_REF_NO;
	}

	public void setPAH_PRO_DT(Date PAH_PRO_DT) {
		this.PAH_PRO_DT = PAH_PRO_DT;
	}

	public Date getPAH_PRO_DT() {
		return PAH_PRO_DT;
	}

	public void setPAH_TO_DT(Date PAH_TO_DT) {
		this.PAH_TO_DT = PAH_TO_DT;
	}

	public Date getPAH_TO_DT() {
		return PAH_TO_DT;
	}

	public void setPAH_APPRV_STATUS(String PAH_APPRV_STATUS) {
		this.PAH_APPRV_STATUS = PAH_APPRV_STATUS;
	}

	public String getPAH_APPRV_STATUS() {
		return PAH_APPRV_STATUS;
	}

	public void setPAH_CONTROL_NO(String PAH_CONTROL_NO) {
		this.PAH_CONTROL_NO = PAH_CONTROL_NO;
	}

	public String getPAH_CONTROL_NO() {
		return PAH_CONTROL_NO;
	}

	public void setPAH_FREEZE_FLAG(String PAH_FREEZE_FLAG) {
		this.PAH_FREEZE_FLAG = PAH_FREEZE_FLAG;
	}

	public String getPAH_FREEZE_FLAG() {
		return PAH_FREEZE_FLAG;
	}

	public void setPAH_CR_DT(Date PAH_CR_DT) {
		this.PAH_CR_DT = PAH_CR_DT;
	}

	public Date getPAH_CR_DT() {
		return PAH_CR_DT;
	}

	public void setPAH_TYPE(String PAH_TYPE) {
		this.PAH_TYPE = PAH_TYPE;
	}

	public String getPAH_TYPE() {
		return PAH_TYPE;
	}

	public void setPAH_MATCH_STATUS(String PAH_MATCH_STATUS) {
		this.PAH_MATCH_STATUS = PAH_MATCH_STATUS;
	}

	public String getPAH_MATCH_STATUS() {
		return PAH_MATCH_STATUS;
	}

	public void setPAH_FM_DT(Date PAH_FM_DT) {
		this.PAH_FM_DT = PAH_FM_DT;
	}

	public Date getPAH_FM_DT() {
		return PAH_FM_DT;
	}

	public void setPAH_APPRV_DT(Date PAH_APPRV_DT) {
		this.PAH_APPRV_DT = PAH_APPRV_DT;
	}

	public Date getPAH_APPRV_DT() {
		return PAH_APPRV_DT;
	}

}