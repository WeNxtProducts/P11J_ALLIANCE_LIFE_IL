package com.iii.pel.forms.PM091_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BENEFIT_APPL_RANK")
public class PM_AGENT_BENEFIT_APPL_RANK extends BaseValueBean {
	
	
	@Column(name="ABAR_ABH_BNF_CODE")
	private String ABAR_ABH_BNF_CODE;

	

	@Column(name="ABAR_RANK_CODE")
	private String ABAR_RANK_CODE;

	@Column(name="ABAR_UPD_DT")
	private Date ABAR_UPD_DT;
	
	
	@Column(name="ABAR_UPD_UID")
	private String ABAR_UPD_UID;
	
	@Column(name="ABAR_CR_DT")
	private Date ABAR_CR_DT;
	
	@Column(name="ABAR_CR_UID")
	private String ABAR_CR_UID;
	
	private String UI_M_ABAR_RANK_CODE_DESC;
	
	private boolean selected;



	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		System.out.println("PM_AGENT_BENEFIT_APPL_RANK.setSelected()---["+selected+"]");
		this.selected = selected;
	}

	public String getABAR_RANK_CODE() {
		return ABAR_RANK_CODE;
	}

	public void setABAR_RANK_CODE(String ABAR_RANK_CODE) {
		this.ABAR_RANK_CODE = ABAR_RANK_CODE;
	}

	public String getUI_M_ABAR_RANK_CODE_DESC() {
		return UI_M_ABAR_RANK_CODE_DESC;
	}

	public void setUI_M_ABAR_RANK_CODE_DESC(String UI_M_ABAR_RANK_CODE_DESC) {
		this.UI_M_ABAR_RANK_CODE_DESC = UI_M_ABAR_RANK_CODE_DESC;
	}

	public String getABAR_ABH_BNF_CODE() {
		return ABAR_ABH_BNF_CODE;
	}

	public void setABAR_ABH_BNF_CODE(String abar_abh_bnf_code) {
		ABAR_ABH_BNF_CODE = abar_abh_bnf_code;
	}

	

	public Date getABAR_UPD_DT() {
		return ABAR_UPD_DT;
	}

	public void setABAR_UPD_DT(Date abar_upd_dt) {
		ABAR_UPD_DT = abar_upd_dt;
	}

	public String getABAR_UPD_UID() {
		return ABAR_UPD_UID;
	}

	public void setABAR_UPD_UID(String abar_upd_uid) {
		ABAR_UPD_UID = abar_upd_uid;
	}

	public Date getABAR_CR_DT() {
		return ABAR_CR_DT;
	}

	public void setABAR_CR_DT(Date abar_cr_dt) {
		ABAR_CR_DT = abar_cr_dt;
	}

	public String getABAR_CR_UID() {
		return ABAR_CR_UID;
	}

	public void setABAR_CR_UID(String abar_cr_uid) {
		ABAR_CR_UID = abar_cr_uid;
	}
}
