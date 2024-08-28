package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_MED_EXAM_DTL")
public class PT_IL_POL_MED_EXAM_DTL extends BaseValueBean {

	@Column(name="PMED_SYS_ID")
	private Long PMED_SYS_ID;

	@Column(name="PMED_POL_SYS_ID")
	private Long PMED_POL_SYS_ID;

	@Column(name="PMED_END_NO_IDX")
	private Integer PMED_END_NO_IDX;

	@Column(name="PMED_POAD_SYS_ID")
	private Long PMED_POAD_SYS_ID;

	@Column(name="PMED_EXAM_CODE")
	private String PMED_EXAM_CODE;

	@Column(name="PMED_STATUS")
	private String PMED_STATUS;

	@Column(name="PMED_CR_DT")
	private Date PMED_CR_DT;

	@Column(name="PMED_CR_UID")
	private String PMED_CR_UID;

	@Column(name="PMED_UPD_DT")
	private Date PMED_UPD_DT;

	@Column(name="PMED_UPD_UID")
	private String PMED_UPD_UID;

	@Column(name="PMED_CLINIC_CODE")
	private String PMED_CLINIC_CODE;

	@Column(name="PMED_PVT_LC_AMT")
	private Double PMED_PVT_LC_AMT;

	@Column(name="PMED_GOVT_LC_AMT")
	private Double PMED_GOVT_LC_AMT;

	@Column(name="PMED_REP_REC_DT")
	private Date PMED_REP_REC_DT;

	@Column(name="PMED_DEL_FLAG")
	private String PMED_DEL_FLAG;

	private String UI_M_CLINIC_CODE_DESC;
	
	private Double UI_M_SUM_PVT_LC_AMT;
	
	private Double UI_M_SUM_GOVT_LC_AMT;
	
	private String UI_M_MED_EXAM_CODE_DESC;
	
	public void setPMED_STATUS(String PMED_STATUS) {
		this.PMED_STATUS = PMED_STATUS;
	}
	public String getPMED_STATUS() {
		 return PMED_STATUS;
	}
	public void setUI_M_SUM_PVT_LC_AMT(Double UI_M_SUM_PVT_LC_AMT) {
		this.UI_M_SUM_PVT_LC_AMT = UI_M_SUM_PVT_LC_AMT;
	}
	public Double getUI_M_SUM_PVT_LC_AMT() {
		 return UI_M_SUM_PVT_LC_AMT;
	}
	public void setPMED_REP_REC_DT(Date PMED_REP_REC_DT) {
		this.PMED_REP_REC_DT = PMED_REP_REC_DT;
	}
	public Date getPMED_REP_REC_DT() {
		 return PMED_REP_REC_DT;
	}
	public void setPMED_CR_UID(String PMED_CR_UID) {
		this.PMED_CR_UID = PMED_CR_UID;
	}
	public String getPMED_CR_UID() {
		 return PMED_CR_UID;
	}
	public void setUI_M_MED_EXAM_CODE_DESC(String UI_M_MED_EXAM_CODE_DESC) {
		this.UI_M_MED_EXAM_CODE_DESC = UI_M_MED_EXAM_CODE_DESC;
	}
	public String getUI_M_MED_EXAM_CODE_DESC() {
		 return UI_M_MED_EXAM_CODE_DESC;
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
	public void setUI_M_CLINIC_CODE_DESC(String UI_M_CLINIC_CODE_DESC) {
		this.UI_M_CLINIC_CODE_DESC = UI_M_CLINIC_CODE_DESC;
	}
	public String getUI_M_CLINIC_CODE_DESC() {
		 return UI_M_CLINIC_CODE_DESC;
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
	public void setUI_M_SUM_GOVT_LC_AMT(Double UI_M_SUM_GOVT_LC_AMT) {
		this.UI_M_SUM_GOVT_LC_AMT = UI_M_SUM_GOVT_LC_AMT;
	}
	public Double getUI_M_SUM_GOVT_LC_AMT() {
		 return UI_M_SUM_GOVT_LC_AMT;
	}
	public void setPMED_END_NO_IDX(Integer PMED_END_NO_IDX) {
		this.PMED_END_NO_IDX = PMED_END_NO_IDX;
	}
	public Integer getPMED_END_NO_IDX() {
		 return PMED_END_NO_IDX;
	}
	public void setPMED_POL_SYS_ID(Long PMED_POL_SYS_ID) {
		this.PMED_POL_SYS_ID = PMED_POL_SYS_ID;
	}
	public Long getPMED_POL_SYS_ID() {
		 return PMED_POL_SYS_ID;
	}

}
