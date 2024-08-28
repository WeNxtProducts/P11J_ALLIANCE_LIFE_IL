package com.iii.pel.forms.PM0100_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name="PM_AGENT_CONTRACT_MAINT_DTL")
public class PM_AGENT_CONTRACT_MAINT_DTL extends BaseValueBean{

	@Column(name="ACMD_RANK_CODE")
	private String ACMD_RANK_CODE;

	@Column(name="ACMD_PROD_TYPE")
	private String ACMD_PROD_TYPE;

	@Column(name="ACMD_NO_OF_POL")
	private Integer ACMD_NO_OF_POL;

	@Column(name="ACMD_LC_NBPICK_FYC")
	private Double ACMD_LC_NBPICK_FYC;

	@Column(name="ACMD_LC_PICKUP_FYC")
	private Double ACMD_LC_PICKUP_FYC;

	@Column(name="ACMD_LC_NBSUB_FYC")
	private Double ACMD_LC_NBSUB_FYC;

	@Column(name="ACMD_LC_TOT_FYC")
	private Double ACMD_LC_TOT_FYC;

	@Column(name="ACMD_MANPOWER")
	private Integer ACMD_MANPOWER;

	@Column(name="ACMD_PRODN_YEAR")
	private Integer ACMD_PRODN_YEAR;

	@Column(name="ACMD_FM_DT")
	private Date ACMD_FM_DT;

	@Column(name="ACMD_TO_DT")
	private Date ACMD_TO_DT;

	@Column(name="ACMD_ACT_NO_OF_POL")
	private Integer ACMD_ACT_NO_OF_POL;

	@Column(name="ACMD_ACT_LC_FYC")
	private Double ACMD_ACT_LC_FYC;

//	The below code is hard coded for customization
	@Column(name="ACMD_CR_DT")
	private Date ACMD_CR_DT;

	@Column(name="ACMD_CR_UID")
	private String ACMD_CR_UID;
	
	
	@Column(name="ACMD_UPD_DT")
	private Date ACMD_UPD_DT;
	
	@Column(name="ACMD_UPD_UID")
	private String ACMD_UPD_UID;

	private String UI_M_ACMD_RANK_CODE_DESC;
	
	private boolean CHECK_BOX;
	
	private String focus;
	
	@Id
	@Column(name="ROWID")
	private String ROWID;

	public String getACMD_RANK_CODE() {
		return ACMD_RANK_CODE;
	}

	public void setACMD_RANK_CODE(String ACMD_RANK_CODE) {
		this.ACMD_RANK_CODE = ACMD_RANK_CODE;
	}

	public String getACMD_PROD_TYPE() {
		return ACMD_PROD_TYPE;
	}

	public void setACMD_PROD_TYPE(String ACMD_PROD_TYPE) {
		this.ACMD_PROD_TYPE=ACMD_PROD_TYPE;
		if("Personal".equalsIgnoreCase(ACMD_PROD_TYPE)){
			this.ACMD_PROD_TYPE="P";
		}if("Direct Group".equalsIgnoreCase(ACMD_PROD_TYPE)){
			this.ACMD_PROD_TYPE="DG";
		}if("Group".equalsIgnoreCase(ACMD_PROD_TYPE)){
			this.ACMD_PROD_TYPE="G";
		}		
	}

	public Integer getACMD_NO_OF_POL() {
		return ACMD_NO_OF_POL;
	}

	public void setACMD_NO_OF_POL(Integer ACMD_NO_OF_POL) {
		this.ACMD_NO_OF_POL = ACMD_NO_OF_POL;
	}

	public Double getACMD_LC_NBPICK_FYC() {
		return ACMD_LC_NBPICK_FYC;
	}

	public void setACMD_LC_NBPICK_FYC(Double ACMD_LC_NBPICK_FYC) {
		this.ACMD_LC_NBPICK_FYC = ACMD_LC_NBPICK_FYC;
	}

	public Double getACMD_LC_PICKUP_FYC() {
		return ACMD_LC_PICKUP_FYC;
	}

	public void setACMD_LC_PICKUP_FYC(Double ACMD_LC_PICKUP_FYC) {
		this.ACMD_LC_PICKUP_FYC = ACMD_LC_PICKUP_FYC;
	}

	public Double getACMD_LC_NBSUB_FYC() {
		return ACMD_LC_NBSUB_FYC;
	}

	public void setACMD_LC_NBSUB_FYC(Double ACMD_LC_NBSUB_FYC) {
		this.ACMD_LC_NBSUB_FYC = ACMD_LC_NBSUB_FYC;
	}

	public Double getACMD_LC_TOT_FYC() {
		return ACMD_LC_TOT_FYC;
	}

	public void setACMD_LC_TOT_FYC(Double ACMD_LC_TOT_FYC) {
		this.ACMD_LC_TOT_FYC = ACMD_LC_TOT_FYC;
	}

	public Integer getACMD_MANPOWER() {
		return ACMD_MANPOWER;
	}

	public void setACMD_MANPOWER(Integer ACMD_MANPOWER) {
		this.ACMD_MANPOWER = ACMD_MANPOWER;
	}

	public Integer getACMD_PRODN_YEAR() {
		return ACMD_PRODN_YEAR;
	}

	public void setACMD_PRODN_YEAR(Integer ACMD_PRODN_YEAR) {
		this.ACMD_PRODN_YEAR = ACMD_PRODN_YEAR;
	}

	public Date getACMD_FM_DT() {
		return ACMD_FM_DT;
	}

	public void setACMD_FM_DT(Date ACMD_FM_DT) {
		this.ACMD_FM_DT = ACMD_FM_DT;
	}

	public Date getACMD_TO_DT() {
		return ACMD_TO_DT;
	}

	public void setACMD_TO_DT(Date ACMD_TO_DT) {
		this.ACMD_TO_DT = ACMD_TO_DT;
	}

	public Integer getACMD_ACT_NO_OF_POL() {
		return ACMD_ACT_NO_OF_POL;
	}

	public void setACMD_ACT_NO_OF_POL(Integer ACMD_ACT_NO_OF_POL) {
		this.ACMD_ACT_NO_OF_POL = ACMD_ACT_NO_OF_POL;
	}

	public Double getACMD_ACT_LC_FYC() {
		return ACMD_ACT_LC_FYC;
	}

	public void setACMD_ACT_LC_FYC(Double ACMD_ACT_LC_FYC) {
		this.ACMD_ACT_LC_FYC = ACMD_ACT_LC_FYC;
	}

	public String getUI_M_ACMD_RANK_CODE_DESC() {
		return UI_M_ACMD_RANK_CODE_DESC;
	}

	public void setUI_M_ACMD_RANK_CODE_DESC(String UI_M_ACMD_RANK_CODE_DESC) {
		this.UI_M_ACMD_RANK_CODE_DESC = UI_M_ACMD_RANK_CODE_DESC;
	}

	public Date getACMD_CR_DT() {
		return ACMD_CR_DT;
	}

	public void setACMD_CR_DT(Date acmd_cr_dt) {
		ACMD_CR_DT = acmd_cr_dt;
	}

	public String getACMD_CR_UID() {
		return ACMD_CR_UID;
	}

	public void setACMD_CR_UID(String acmd_cr_uid) {
		ACMD_CR_UID = acmd_cr_uid;
	}

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public Date getACMD_UPD_DT() {
		return ACMD_UPD_DT;
	}

	public void setACMD_UPD_DT(Date acmd_upd_dt) {
		ACMD_UPD_DT = acmd_upd_dt;
	}

	public String getACMD_UPD_UID() {
		return ACMD_UPD_UID;
	}

	public void setACMD_UPD_UID(String acmd_upd_uid) {
		ACMD_UPD_UID = acmd_upd_uid;
	}
}
