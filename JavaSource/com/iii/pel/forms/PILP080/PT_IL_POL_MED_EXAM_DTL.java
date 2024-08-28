package com.iii.pel.forms.PILP080;

import java.io.*;
import java.util.*;
import com.iii.apps.persistence.*;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PT_IL_POL_MED_EXAM_DTL")
public class PT_IL_POL_MED_EXAM_DTL extends BaseValueBean {

	@Column(name = "PMED_SYS_ID")
	private Long PMED_SYS_ID;

	@Column(name = "PMED_POL_SYS_ID")
	private Long PMED_POL_SYS_ID;

	@Column(name = "PMED_END_NO_IDX")
	private Double PMED_END_NO_IDX;

	@Column(name = "PMED_POAD_SYS_ID")
	private Long PMED_POAD_SYS_ID;

	@Column(name = "PMED_EXAM_CODE")
	private String PMED_EXAM_CODE;

	@Column(name = "PMED_STATUS")
	private String PMED_STATUS;

	@Column(name = "PMED_CR_DT")
	private Date PMED_CR_DT;

	@Column(name = "PMED_CR_UID")
	private String PMED_CR_UID;

	@Column(name = "PMED_UPD_DT")
	private Date PMED_UPD_DT;

	@Column(name = "PMED_UPD_UID")
	private String PMED_UPD_UID;

	@Column(name = "PMED_CLINIC_CODE")
	private String PMED_CLINIC_CODE;

	@Column(name = "PMED_PVT_LC_AMT")
	private Double PMED_PVT_LC_AMT;

	@Column(name = "PMED_GOVT_LC_AMT")
	private Double PMED_GOVT_LC_AMT;

	@Column(name = "PMED_REP_REC_DT")
	private Date PMED_REP_REC_DT;

	@Column(name = "PMED_DEL_FLAG")
	private String PMED_DEL_FLAG;

	@Column(name = "PMED_EXAM_DT")
	private Date PMED_EXAM_DT;
	
	@Column(name = "PMED_INVOICE_NO")
	private String PMED_INVOICE_NO;
	
	@Column(name = "PMED_FLEX_03")
	private String PMED_FLEX_03;
	
	@Column(name = "PMED_MEDICAL_FEES")
	private Double PMED_MEDICAL_FEES;
	
	private Double UI_M_TOT_TDS_FEES;
	private Double UI_M_TOT_MEDICAL_FEES;
	private String UI_PMED_EXAM_DT;

	public String getUI_PMED_EXAM_DT() {
		return UI_PMED_EXAM_DT;
	}

	public void setUI_PMED_EXAM_DT(String ui_pmed_exam_dt) {
		UI_PMED_EXAM_DT = ui_pmed_exam_dt;
	}

	public void setPMED_STATUS(String PMED_STATUS) {
		this.PMED_STATUS = PMED_STATUS;
	}

	public String getPMED_STATUS() {
		return PMED_STATUS;
	}

	public void setPMED_REP_REC_DT(Date PMED_REP_REC_DT) {
		this.PMED_REP_REC_DT = PMED_REP_REC_DT;
	}

	public Date getPMED_REP_REC_DT() {
		return PMED_REP_REC_DT;
	}

	public void setUI_M_TOT_MEDICAL_FEES(Double UI_M_TOT_MEDICAL_FEES) {
		this.UI_M_TOT_MEDICAL_FEES = UI_M_TOT_MEDICAL_FEES;
	}

	public Double getUI_M_TOT_MEDICAL_FEES() {
		return UI_M_TOT_MEDICAL_FEES;
	}

	public void setPMED_CR_UID(String PMED_CR_UID) {
		this.PMED_CR_UID = PMED_CR_UID;
	}

	public String getPMED_CR_UID() {
		return PMED_CR_UID;
	}

	public void setPMED_EXAM_CODE(String PMED_EXAM_CODE) {
		this.PMED_EXAM_CODE = PMED_EXAM_CODE;
	}

	public String getPMED_EXAM_CODE() {
		return PMED_EXAM_CODE;
	}

	public void setPMED_GOVT_LC_AMT(Double PMED_GOVT_LC_AMT) {
		this.PMED_GOVT_LC_AMT = PMED_GOVT_LC_AMT;
	}

	public Double getPMED_GOVT_LC_AMT() {
		return PMED_GOVT_LC_AMT;
	}

	public void setPMED_DEL_FLAG(String PMED_DEL_FLAG) {
		this.PMED_DEL_FLAG = PMED_DEL_FLAG;
	}

	public String getPMED_DEL_FLAG() {
		return PMED_DEL_FLAG;
	}

	public void setPMED_CLINIC_CODE(String PMED_CLINIC_CODE) {
		this.PMED_CLINIC_CODE = PMED_CLINIC_CODE;
	}

	public String getPMED_CLINIC_CODE() {
		return PMED_CLINIC_CODE;
	}

	public void setPMED_UPD_DT(Date PMED_UPD_DT) {
		this.PMED_UPD_DT = PMED_UPD_DT;
	}

	public Date getPMED_UPD_DT() {
		return PMED_UPD_DT;
	}

	public void setPMED_SYS_ID(Long PMED_SYS_ID) {
		this.PMED_SYS_ID = PMED_SYS_ID;
	}

	public Long getPMED_SYS_ID() {
		return PMED_SYS_ID;
	}

	public void setUI_M_TOT_TDS_FEES(Double UI_M_TOT_TDS_FEES) {
		this.UI_M_TOT_TDS_FEES = UI_M_TOT_TDS_FEES;
	}

	public Double getUI_M_TOT_TDS_FEES() {
		return UI_M_TOT_TDS_FEES;
	}

	public void setPMED_POAD_SYS_ID(Long PMED_POAD_SYS_ID) {
		this.PMED_POAD_SYS_ID = PMED_POAD_SYS_ID;
	}

	public Long getPMED_POAD_SYS_ID() {
		return PMED_POAD_SYS_ID;
	}

	public void setPMED_UPD_UID(String PMED_UPD_UID) {
		this.PMED_UPD_UID = PMED_UPD_UID;
	}

	public String getPMED_UPD_UID() {
		return PMED_UPD_UID;
	}

	public void setPMED_CR_DT(Date PMED_CR_DT) {
		this.PMED_CR_DT = PMED_CR_DT;
	}

	public Date getPMED_CR_DT() {
		return PMED_CR_DT;
	}

	public void setPMED_PVT_LC_AMT(Double PMED_PVT_LC_AMT) {
		this.PMED_PVT_LC_AMT = PMED_PVT_LC_AMT;
	}

	public Double getPMED_PVT_LC_AMT() {
		return PMED_PVT_LC_AMT;
	}

	public void setPMED_END_NO_IDX(Double PMED_END_NO_IDX) {
		this.PMED_END_NO_IDX = PMED_END_NO_IDX;
	}

	public Double getPMED_END_NO_IDX() {
		return PMED_END_NO_IDX;
	}

	public void setPMED_POL_SYS_ID(Long PMED_POL_SYS_ID) {
		this.PMED_POL_SYS_ID = PMED_POL_SYS_ID;
	}

	public Long getPMED_POL_SYS_ID() {
		return PMED_POL_SYS_ID;
	}

	public Date getPMED_EXAM_DT() {
		return PMED_EXAM_DT;
	}

	public void setPMED_EXAM_DT(Date pmed_exam_dt) {
		PMED_EXAM_DT = pmed_exam_dt;
		setUI_PMED_EXAM_DT(CommonUtils.dateToStringFormatter(pmed_exam_dt));
	}

	public String getPMED_INVOICE_NO() {
		return PMED_INVOICE_NO;
	}

	public void setPMED_INVOICE_NO(String pmed_invoice_no) {
		PMED_INVOICE_NO = pmed_invoice_no;
	}

	public String getPMED_FLEX_03() {
		return PMED_FLEX_03;
	}

	public void setPMED_FLEX_03(String pmed_flex_03) {
		PMED_FLEX_03 = pmed_flex_03;
	}

	public Double getPMED_MEDICAL_FEES() {
		return PMED_MEDICAL_FEES;
	}

	public void setPMED_MEDICAL_FEES(Double pmed_medical_fees) {
		PMED_MEDICAL_FEES = pmed_medical_fees;
	}

}