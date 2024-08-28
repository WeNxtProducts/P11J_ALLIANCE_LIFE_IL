package com.iii.pel.forms.PILPSTM001;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class DUMMY extends BaseValueBean {

	
	private String UI_M_PRO_FOR;
	
	private String UI_M_POLICY_FM;
	
	private String UI_M_POLICY_TO;
	
	private Date UI_M_TO_DT;

	/**
	 * @return the uI_M_PRO_FOR
	 */
	public String getUI_M_PRO_FOR() {
		return UI_M_PRO_FOR;
	}

	/**
	 * @param ui_m_pro_for the uI_M_PRO_FOR to set
	 */
	public void setUI_M_PRO_FOR(String ui_m_pro_for) {
		UI_M_PRO_FOR = ui_m_pro_for;
	}

	/**
	 * @return the uI_M_POLICY_FM
	 */
	public String getUI_M_POLICY_FM() {
		return UI_M_POLICY_FM;
	}

	/**
	 * @param ui_m_policy_fm the uI_M_POLICY_FM to set
	 */
	public void setUI_M_POLICY_FM(String ui_m_policy_fm) {
		UI_M_POLICY_FM = ui_m_policy_fm;
	}

	/**
	 * @return the uI_M_POLICY_TO
	 */
	public String getUI_M_POLICY_TO() {
		return UI_M_POLICY_TO;
	}

	/**
	 * @param ui_m_policy_to the uI_M_POLICY_TO to set
	 */
	public void setUI_M_POLICY_TO(String ui_m_policy_to) {
		UI_M_POLICY_TO = ui_m_policy_to;
	}

	/**
	 * @return the uI_M_TO_DT
	 */
	public Date getUI_M_TO_DT() {
		return UI_M_TO_DT;
	}

	/**
	 * @param ui_m_to_dt the uI_M_TO_DT to set
	 */
	public void setUI_M_TO_DT(Date ui_m_to_dt) {
		UI_M_TO_DT = ui_m_to_dt;
	}



	
}
