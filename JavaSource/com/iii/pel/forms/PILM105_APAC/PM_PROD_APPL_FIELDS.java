package com.iii.pel.forms.PILM105_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_PROD_APPL_FIELDS")
public class PM_PROD_APPL_FIELDS extends BaseValueBean {

	@Column(name="PPAF_PROD_CODE")
	private String PPAF_PROD_CODE;

	@Column(name="PPAF_COL_CODE")
	private String PPAF_COL_CODE;
	
	private String PPAF_COL_CODE_DESC;

	@Column(name="PPAF_COL_NAME")
	private String PPAF_COL_NAME;

	@Column(name="PPAF_MAND_YN")
	private String PPAF_MAND_YN;

	@Column(name="PPAF_CR_DT")
	private Date PPAF_CR_DT;

	@Column(name="PPAF_CR_UID")
	private String PPAF_CR_UID;

	@Column(name="PPAF_UPD_DT")
	private Date PPAF_UPD_DT;

	@Column(name="PPAF_UPD_UID")
	private String PPAF_UPD_UID;

	@Column(name="PPAF_FLEX1")
	private String PPAF_FLEX1;

	@Column(name="PPAF_FLEX2")
	private String PPAF_FLEX2;

	@Column(name="PPAF_FLEX3")
	private String PPAF_FLEX3;

	@Column(name="PPAF_FLEX4")
	private String PPAF_FLEX4;

	@Column(name="PPAF_FLEX5")
	private String PPAF_FLEX5;

	@Column(name="PPAF_FLEX6")
	private String PPAF_FLEX6;

	@Column(name="PPAF_FLEX7")
	private String PPAF_FLEX7;

	@Column(name="PPAF_FLEX8")
	private String PPAF_FLEX8;

	@Column(name="PPAF_FLEX9")
	private String PPAF_FLEX9;

	@Column(name="PPAF_FLEX10")
	private String PPAF_FLEX10;

	@Column(name="PPAF_NMAND_YN")
	private String PPAF_NMAND_YN;

	public void setPPAF_CR_DT(Date PPAF_CR_DT) {
		this.PPAF_CR_DT = PPAF_CR_DT;
	}
	public Date getPPAF_CR_DT() {
		 return PPAF_CR_DT;
	}
	public void setPPAF_COL_NAME(String PPAF_COL_NAME) {
		this.PPAF_COL_NAME = PPAF_COL_NAME;
	}
	public String getPPAF_COL_NAME() {
		 return PPAF_COL_NAME;
	}
	public void setPPAF_FLEX1(String PPAF_FLEX1) {
		this.PPAF_FLEX1 = PPAF_FLEX1;
	}
	public String getPPAF_FLEX1() {
		 return PPAF_FLEX1;
	}
	public void setPPAF_MAND_YN(String PPAF_MAND_YN) {
		this.PPAF_MAND_YN = PPAF_MAND_YN;
	}
	public String getPPAF_MAND_YN() {
		 return PPAF_MAND_YN;
	}
	public void setPPAF_UPD_UID(String PPAF_UPD_UID) {
		this.PPAF_UPD_UID = PPAF_UPD_UID;
	}
	public String getPPAF_UPD_UID() {
		 return PPAF_UPD_UID;
	}
	public void setPPAF_FLEX2(String PPAF_FLEX2) {
		this.PPAF_FLEX2 = PPAF_FLEX2;
	}
	public String getPPAF_FLEX2() {
		 return PPAF_FLEX2;
	}
	public void setPPAF_NMAND_YN(String PPAF_NMAND_YN) {
		this.PPAF_NMAND_YN = PPAF_NMAND_YN;
	}
	public String getPPAF_NMAND_YN() {
		 return PPAF_NMAND_YN;
	}
	public void setPPAF_FLEX6(String PPAF_FLEX6) {
		this.PPAF_FLEX6 = PPAF_FLEX6;
	}
	public String getPPAF_FLEX6() {
		 return PPAF_FLEX6;
	}
	public void setPPAF_FLEX5(String PPAF_FLEX5) {
		this.PPAF_FLEX5 = PPAF_FLEX5;
	}
	public String getPPAF_FLEX5() {
		 return PPAF_FLEX5;
	}
	public void setPPAF_UPD_DT(Date PPAF_UPD_DT) {
		this.PPAF_UPD_DT = PPAF_UPD_DT;
	}
	public Date getPPAF_UPD_DT() {
		 return PPAF_UPD_DT;
	}
	public void setPPAF_FLEX4(String PPAF_FLEX4) {
		this.PPAF_FLEX4 = PPAF_FLEX4;
	}
	public String getPPAF_FLEX4() {
		 return PPAF_FLEX4;
	}
	public void setPPAF_FLEX3(String PPAF_FLEX3) {
		this.PPAF_FLEX3 = PPAF_FLEX3;
	}
	public String getPPAF_FLEX3() {
		 return PPAF_FLEX3;
	}
	public void setPPAF_FLEX9(String PPAF_FLEX9) {
		this.PPAF_FLEX9 = PPAF_FLEX9;
	}
	public String getPPAF_FLEX9() {
		 return PPAF_FLEX9;
	}
	public void setPPAF_FLEX8(String PPAF_FLEX8) {
		this.PPAF_FLEX8 = PPAF_FLEX8;
	}
	public String getPPAF_FLEX8() {
		 return PPAF_FLEX8;
	}
	public void setPPAF_FLEX7(String PPAF_FLEX7) {
		this.PPAF_FLEX7 = PPAF_FLEX7;
	}
	public String getPPAF_FLEX7() {
		 return PPAF_FLEX7;
	}
	public void setPPAF_PROD_CODE(String PPAF_PROD_CODE) {
		this.PPAF_PROD_CODE = PPAF_PROD_CODE;
	}
	public String getPPAF_PROD_CODE() {
		 return PPAF_PROD_CODE;
	}
	public void setPPAF_FLEX10(String PPAF_FLEX10) {
		this.PPAF_FLEX10 = PPAF_FLEX10;
	}
	public String getPPAF_FLEX10() {
		 return PPAF_FLEX10;
	}
	public void setPPAF_CR_UID(String PPAF_CR_UID) {
		this.PPAF_CR_UID = PPAF_CR_UID;
	}
	public String getPPAF_CR_UID() {
		 return PPAF_CR_UID;
	}
	public void setPPAF_COL_CODE(String PPAF_COL_CODE) {
		this.PPAF_COL_CODE = PPAF_COL_CODE;
	}
	public String getPPAF_COL_CODE() {
		 return PPAF_COL_CODE;
	}
	/**
	 * @return the pPAF_COL_CODE_DESC
	 */
	public String getPPAF_COL_CODE_DESC() {
		return PPAF_COL_CODE_DESC;
	}
	/**
	 * @param ppaf_col_code_desc the pPAF_COL_CODE_DESC to set
	 */
	public void setPPAF_COL_CODE_DESC(String ppaf_col_code_desc) {
		PPAF_COL_CODE_DESC = ppaf_col_code_desc;
	}

}