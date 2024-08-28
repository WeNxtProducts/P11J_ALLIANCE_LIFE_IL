package com.iii.pel.forms.PILP039_APAC;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "")
public class RI_CLOSING extends BaseValueBean {

	private String UI_M_PROD_FM;

	private String UI_M_PROD_FM_DESC;

	private String UI_M_PROD_TO;

	private String UI_M_PROD_TO_DESC;

	private Integer UI_M_FIN_QTR;

	private Integer UI_M_RD_YEAR;

	private String UI_M_RI_PREM;

	private String UI_M_RI_CLAIM ="N";

	private String UI_M_CLAIM_OS_YN="N";
	
	private String UI_M_POST_YN="Y";

	private String UI_M_STATUS;

	private Date UI_M_POL_DT_FM;
	private Date UI_M_POL_DT_TO;
	private Date UI_M_RI_ALLOC_TO_DT;
	private Date UI_M_PRCR_PRD_TO_DT ;
	private Date UI_M_PRCR_PRD_FM_DT ;
	private int rowCount;

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public Date getUI_M_PRCR_PRD_FM_DT() {
		return UI_M_PRCR_PRD_FM_DT;
	}

	public void setUI_M_PRCR_PRD_FM_DT(Date ui_m_prcr_prd_fm_dt) {
		UI_M_PRCR_PRD_FM_DT = ui_m_prcr_prd_fm_dt;
	}

	public Date getUI_M_PRCR_PRD_TO_DT() {
		return UI_M_PRCR_PRD_TO_DT;
	}

	public void setUI_M_PRCR_PRD_TO_DT(Date ui_m_prcr_prd_to_dt) {
		UI_M_PRCR_PRD_TO_DT = ui_m_prcr_prd_to_dt;
	}

	public Date getUI_M_POL_DT_FM() {
		return UI_M_POL_DT_FM;
	}

	public void setUI_M_POL_DT_FM(Date ui_m_pol_dt_fm) {
		UI_M_POL_DT_FM = ui_m_pol_dt_fm;
	}

	public Date getUI_M_POL_DT_TO() {
		return UI_M_POL_DT_TO;
	}

	public void setUI_M_POL_DT_TO(Date ui_m_pol_dt_to) {
		UI_M_POL_DT_TO = ui_m_pol_dt_to;
	}

	public Date getUI_M_RI_ALLOC_TO_DT() {
		return UI_M_RI_ALLOC_TO_DT;
	}

	public void setUI_M_RI_ALLOC_TO_DT(Date ui_m_ri_alloc_to_dt) {
		UI_M_RI_ALLOC_TO_DT = ui_m_ri_alloc_to_dt;
	}

	public String getUI_M_PROD_FM() {
		return UI_M_PROD_FM;
	}

	public void setUI_M_PROD_FM(String UI_M_PROD_FM) {
		this.UI_M_PROD_FM = UI_M_PROD_FM;
	}

	public String getUI_M_PROD_FM_DESC() {
		return UI_M_PROD_FM_DESC;
	}

	public void setUI_M_PROD_FM_DESC(String UI_M_PROD_FM_DESC) {
		this.UI_M_PROD_FM_DESC = UI_M_PROD_FM_DESC;
	}

	public String getUI_M_PROD_TO() {
		return UI_M_PROD_TO;
	}

	public void setUI_M_PROD_TO(String UI_M_PROD_TO) {
		this.UI_M_PROD_TO = UI_M_PROD_TO;
	}

	public String getUI_M_PROD_TO_DESC() {
		return UI_M_PROD_TO_DESC;
	}

	public void setUI_M_PROD_TO_DESC(String UI_M_PROD_TO_DESC) {
		this.UI_M_PROD_TO_DESC = UI_M_PROD_TO_DESC;
	}

	 
	public Integer getUI_M_FIN_QTR() {
	    return UI_M_FIN_QTR;
	}

	public void setUI_M_FIN_QTR(Integer ui_m_fin_qtr) {
	    UI_M_FIN_QTR = ui_m_fin_qtr;
	}

	public Integer getUI_M_RD_YEAR() {
	    return UI_M_RD_YEAR;
	}

	public void setUI_M_RD_YEAR(Integer ui_m_rd_year) {
	    UI_M_RD_YEAR = ui_m_rd_year;
	}

	public String getUI_M_RI_PREM() {
		return UI_M_RI_PREM;
	}

	public void setUI_M_RI_PREM(String UI_M_RI_PREM) {
		this.UI_M_RI_PREM = UI_M_RI_PREM;
	}

	public String getUI_M_RI_CLAIM() {
		return UI_M_RI_CLAIM;
	}

	public void setUI_M_RI_CLAIM(String UI_M_RI_CLAIM) {
		this.UI_M_RI_CLAIM = UI_M_RI_CLAIM;
	}

	public String getUI_M_CLAIM_OS_YN() {
		return UI_M_CLAIM_OS_YN;
	}

	public void setUI_M_CLAIM_OS_YN(String UI_M_CLAIM_OS_YN) {
		this.UI_M_CLAIM_OS_YN = UI_M_CLAIM_OS_YN;
	}

	public String getUI_M_STATUS() {
		return UI_M_STATUS;
	}

	public void setUI_M_STATUS(String UI_M_STATUS) {
		this.UI_M_STATUS = UI_M_STATUS;
	}

	public String getUI_M_POST_YN() {
		return UI_M_POST_YN;
	}

	public void setUI_M_POST_YN(String ui_m_post_yn) {
		UI_M_POST_YN = ui_m_post_yn;
	}
}
