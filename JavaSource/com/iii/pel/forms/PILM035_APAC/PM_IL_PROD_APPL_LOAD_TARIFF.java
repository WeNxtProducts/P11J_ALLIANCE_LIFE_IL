package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROD_APPL_LOAD_TARIFF")
public class PM_IL_PROD_APPL_LOAD_TARIFF extends BaseValueBean {

	@Column(name = "PALT_SRNO")
	private Integer PALT_SRNO;

	@Column(name = "PALT_APPLIED_ON")
	private String PALT_APPLIED_ON;

	@Column(name = "PALT_TH_PARAM_TYPE")
	private String PALT_TH_PARAM_TYPE;

	@Column(name = "PALT_TH_CODE")
	private String PALT_TH_CODE;

	private String UI_M_PALT_TH_CODE_DESC;

	@Column(name = "PALT_LOAD_APPL_PERC")
	private Double PALT_LOAD_APPL_PERC = 100.0;

	@Column(name = "PALT_APPL_UPTO")
	private String PALT_APPL_UPTO;

	@Column(name = "PALT_DEFAULT_YN")
	private String PALT_DEFAULT_YN;

	@Column(name = "PALT_PROD_CODE")
	private String PALT_PROD_CODE;

	@Column(name = "PALT_CR_DT")
	private Date PALT_CR_DT;

	@Column(name = "PALT_CR_UID")
	private String PALT_CR_UID;

	@Column(name = "PALT_UPD_DT")
	private Date PALT_UPD_DT;

	@Column(name = "PALT_UPD_UID")
	private String PALT_UPD_UID;
	
	//added by agalya
	@Column(name = "PALT_COVER_CODE")
	private String PALT_COVER_CODE;
	
	

	public String getPALT_COVER_CODE() {
		return PALT_COVER_CODE;
	}



	public void setPALT_COVER_CODE(String pALT_COVER_CODE) {
		PALT_COVER_CODE = pALT_COVER_CODE;
	}
	private String UI_M_PALT_COVER_CODE_DESC;

   

	public String getUI_M_PALT_COVER_CODE_DESC() {
		return UI_M_PALT_COVER_CODE_DESC;
	}



	public void setUI_M_PALT_COVER_CODE_DESC(String uI_M_PALT_COVER_CODE_DESC) {
		UI_M_PALT_COVER_CODE_DESC = uI_M_PALT_COVER_CODE_DESC;
	}
	
	 //end
	private boolean CHECK_BOX;
	
	private boolean ChangeCompProperty;

	public PM_IL_PROD_APPL_LOAD_TARIFF() {
		// Setting default values for the lists
//		this
//				.setPALT_APPLIED_ON(PM_IL_PROD_APPL_LOAD_TARIFF_CONSTANTS.DEFAULT_APPLIED_ON);
//		this
//				.setPALT_TH_PARAM_TYPE(PM_IL_PROD_APPL_LOAD_TARIFF_CONSTANTS.DEFAULT_PARAM_TYPE);
//		this
//				.setPALT_DEFAULT_YN(PM_IL_PROD_APPL_LOAD_TARIFF_CONSTANTS.DEFAULT_DEFAULT_YN);
	}

	

	public String getPALT_APPLIED_ON() {
		return PALT_APPLIED_ON;
	}

	public void setPALT_APPLIED_ON(String PALT_APPLIED_ON) {
		this.PALT_APPLIED_ON = PALT_APPLIED_ON;
	}

	public String getPALT_TH_PARAM_TYPE() {
		return PALT_TH_PARAM_TYPE;
	}

	public void setPALT_TH_PARAM_TYPE(String PALT_TH_PARAM_TYPE) {
		this.PALT_TH_PARAM_TYPE = PALT_TH_PARAM_TYPE;
	}

	public String getPALT_TH_CODE() {
		return PALT_TH_CODE;
	}

	public void setPALT_TH_CODE(String PALT_TH_CODE) {
		this.PALT_TH_CODE = PALT_TH_CODE;
	}

	public String getUI_M_PALT_TH_CODE_DESC() {
		return UI_M_PALT_TH_CODE_DESC;
	}

	public void setUI_M_PALT_TH_CODE_DESC(String UI_M_PALT_TH_CODE_DESC) {
		this.UI_M_PALT_TH_CODE_DESC = UI_M_PALT_TH_CODE_DESC;
	}

	public Double getPALT_LOAD_APPL_PERC() {
		return PALT_LOAD_APPL_PERC;
	}

	public void setPALT_LOAD_APPL_PERC(Double PALT_LOAD_APPL_PERC) {
		this.PALT_LOAD_APPL_PERC = PALT_LOAD_APPL_PERC;
	}

	public String getPALT_APPL_UPTO() {
		return PALT_APPL_UPTO;
	}

	public void setPALT_APPL_UPTO(String PALT_APPL_UPTO) {
		this.PALT_APPL_UPTO = PALT_APPL_UPTO;
	}

	public String getPALT_DEFAULT_YN() {
		return PALT_DEFAULT_YN;
	}

	public void setPALT_DEFAULT_YN(String PALT_DEFAULT_YN) {
		this.PALT_DEFAULT_YN = PALT_DEFAULT_YN;
	}

	public String getPALT_PROD_CODE() {
		return PALT_PROD_CODE;
	}

	public void setPALT_PROD_CODE(String palt_prod_code) {
		PALT_PROD_CODE = palt_prod_code;
	}

	public Date getPALT_CR_DT() {
		return PALT_CR_DT;
	}

	public void setPALT_CR_DT(Date palt_cr_dt) {
		PALT_CR_DT = palt_cr_dt;
	}

	public String getPALT_CR_UID() {
		return PALT_CR_UID;
	}

	public void setPALT_CR_UID(String palt_cr_uid) {
		PALT_CR_UID = palt_cr_uid;
	}

	public Date getPALT_UPD_DT() {
		return PALT_UPD_DT;
	}

	public void setPALT_UPD_DT(Date palt_upd_dt) {
		PALT_UPD_DT = palt_upd_dt;
	}

	public String getPALT_UPD_UID() {
		return PALT_UPD_UID;
	}

	public void setPALT_UPD_UID(String palt_upd_uid) {
		PALT_UPD_UID = palt_upd_uid;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public boolean isChangeCompProperty() {
		return ChangeCompProperty;
	}

	public void setChangeCompProperty(boolean changeCompProperty) {
		ChangeCompProperty = changeCompProperty;
	}



	public Integer getPALT_SRNO() {
		return PALT_SRNO;
	}



	public void setPALT_SRNO(Integer palt_srno) {
		PALT_SRNO = palt_srno;
	}

	
	/*Added by Janani for Fidelity on 25.04.2018 as suggested by Ajay */
	
	@Column(name = "PALT_FORMULA_CODE")
	private String PALT_FORMULA_CODE;

	public String getPALT_FORMULA_CODE() {
		return PALT_FORMULA_CODE;
	}
	public void setPALT_FORMULA_CODE(String pALT_FORMULA_CODE) {
		PALT_FORMULA_CODE = pALT_FORMULA_CODE;
	}
	
	private String UI_M_FORMULA_CODE_DESC;


	public String getUI_M_FORMULA_CODE_DESC() {
		return UI_M_FORMULA_CODE_DESC;
	}

	public void setUI_M_FORMULA_CODE_DESC(String uI_M_FORMULA_CODE_DESC) {
		UI_M_FORMULA_CODE_DESC = uI_M_FORMULA_CODE_DESC;
	}
	
	
	/*End*/

	
	
	
}
