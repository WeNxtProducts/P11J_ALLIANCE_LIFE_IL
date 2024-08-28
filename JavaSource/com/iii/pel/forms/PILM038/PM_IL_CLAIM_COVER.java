package com.iii.pel.forms.PILM038;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CLAIM_COVER")
public class PM_IL_CLAIM_COVER extends BaseValueBean {

	@Column(name="CC_COVER_CODE")
	private String CC_COVER_CODE;

	private String UI_M_CC_PROD_CODE_DESC;
	
	private String UI_M_CC_COVER_CODE_DESC;

	@Column(name="CC_EFF_FM_DT")
	private Date CC_EFF_FM_DT;

	@Column(name="CC_UPD_DT")
	private Date CC_UPD_DT;
	
	@Column(name="CC_UPD_UID")
	private String CC_UPD_UID;
	
	@Column(name="CC_CLAIM_TYPE")
	private String CC_CLAIM_TYPE;
	
	@Column(name="CC_EFF_TO_DT")
	private Date CC_EFF_TO_DT;

	@Column(name="CC_CR_DT")
	private Date CC_CR_DT;
	
	@Column(name="CC_CR_UID")
	private String CC_CR_UID;
	
	@Column(name="CC_FLEX_01")
	private Integer CC_FLEX_01;
		
	@Column(name="ROWID")
	private String ROWID;
	

	public String getROWID() {
	  return ROWID;
	}

	public void setROWID(String rowid) {
	  ROWID = rowid;
	}
	
	private boolean rendered=false;

	private boolean insertMode=true;
	
	private boolean CHECK_BOX = false;
	
	private boolean selected;
	
	private boolean claimTypeDisableFlag=false;

	public boolean isRendered() {
		return rendered;
	}

	public void setRendered(boolean rendered) {
		this.rendered = rendered;
	}

	public boolean isInsertMode() {
		return insertMode;
	}

	public void setInsertMode(boolean insertMode) {
		this.insertMode = insertMode;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public String getCC_COVER_CODE() {
		return CC_COVER_CODE;
	}

	public void setCC_COVER_CODE(String CC_COVER_CODE) {
		this.CC_COVER_CODE = CC_COVER_CODE;
	}

	public String getUI_M_CC_COVER_CODE_DESC() {
		return UI_M_CC_COVER_CODE_DESC;
	}

	public void setUI_M_CC_COVER_CODE_DESC(String UI_M_CC_COVER_CODE_DESC) {
		this.UI_M_CC_COVER_CODE_DESC = UI_M_CC_COVER_CODE_DESC;
	}

	public Date getCC_EFF_FM_DT() {
		 return CC_EFF_FM_DT;
	}

	public void setCC_EFF_FM_DT(Date CC_EFF_FM_DT) {
		this.CC_EFF_FM_DT = CC_EFF_FM_DT;
	}

	public Date getCC_EFF_TO_DT() {
		 return CC_EFF_TO_DT;
	}

	public void setCC_EFF_TO_DT(Date CC_EFF_TO_DT) {
		this.CC_EFF_TO_DT = CC_EFF_TO_DT;
	}

	public Date getCC_CR_DT() {
		return CC_CR_DT;
	}

	public void setCC_CR_DT(Date cc_cr_dt) {
		CC_CR_DT = cc_cr_dt;
	}

	public String getCC_CR_UID() {
		return CC_CR_UID;
	}

	public void setCC_CR_UID(String cc_cr_uid) {
		CC_CR_UID = cc_cr_uid;
	}

	public String getCC_CLAIM_TYPE() {
		return CC_CLAIM_TYPE;
	}

	public void setCC_CLAIM_TYPE(String cc_claim_type) {
		CC_CLAIM_TYPE = cc_claim_type;
	}

	public Date getCC_UPD_DT() {
		return CC_UPD_DT;
	}

	public void setCC_UPD_DT(Date cc_upd_dt) {
		CC_UPD_DT = cc_upd_dt;
	}

	public String getCC_UPD_UID() {
		return CC_UPD_UID;
	}

	public void setCC_UPD_UID(String cc_upd_uid) {
		CC_UPD_UID = cc_upd_uid;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public String getUI_M_CC_PROD_CODE_DESC() {
		return UI_M_CC_PROD_CODE_DESC;
	}

	public void setUI_M_CC_PROD_CODE_DESC(String ui_m_cc_prod_code_desc) {
		UI_M_CC_PROD_CODE_DESC = ui_m_cc_prod_code_desc;
	}

	public boolean isClaimTypeDisableFlag() {
		return claimTypeDisableFlag;
	}

	public void setClaimTypeDisableFlag(boolean claimTypeDisableFlag) {
		this.claimTypeDisableFlag = claimTypeDisableFlag;
	}

	public Integer getCC_FLEX_01() {
		return CC_FLEX_01;
	}

	public void setCC_FLEX_01(Integer cc_flex_01) {
		CC_FLEX_01 = cc_flex_01;
	}
}