/**
 * 
 */
package com.iii.pel.forms.PILT006_APAC;

import java.text.ParseException;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.ajax4jsf.taglib.html.jsp.AjaxCommandButton;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class DUMMY_ACTION {
	private HtmlCommandButton M_BUTT_ACC_FIR_DTLS;
	
	private HtmlAjaxCommandButton COMP_UI_M_BUT_REOPEN;
	
	private HtmlCommandButton COMP_UI_M_BUT_CLOSE;
	
	private HtmlCommandButton COMP_UI_M_BUT_SETTLEMENT;
	
	private HtmlCommandButton COMP_UI_M_BUT_STAUS_CHANGE;
	
	private HtmlCommandButton M_BUT_FRZ;
	
	private HtmlCommandButton UI_M_BUT_DEDUCTION;
	private HtmlCommandButton UI_M_BUT_BONUS;
	private HtmlCommandButton UI_M_BUT_MAIN_1;
	private HtmlCommandButton COMP_UI_M_BUT_BONUS_MAIN;
	public PILT006_APAC_COMPOSITE_ACTION compositeAction;
	
	private DUMMY DUMMY_BEAN ;
	
	public DUMMY_ACTION(){
		DUMMY_BEAN = new DUMMY();
		instantiateAllComponent();
	}

	

	
	/**
	 * @return the m_BUTT_ACC_FIR_DTLS
	 */
	public HtmlCommandButton getM_BUTT_ACC_FIR_DTLS() {
		return M_BUTT_ACC_FIR_DTLS;
	}

	/**
	 * @param m_butt_acc_fir_dtls the m_BUTT_ACC_FIR_DTLS to set
	 */
	public void setM_BUTT_ACC_FIR_DTLS(HtmlCommandButton m_butt_acc_fir_dtls) {
		M_BUTT_ACC_FIR_DTLS = m_butt_acc_fir_dtls;
	}

	/**
	 * @return the m_BUT_FRZ
	 */
	public HtmlCommandButton getM_BUT_FRZ() {
		return M_BUT_FRZ;
	}

	/**
	 * @param m_but_frz the m_BUT_FRZ to set
	 */
	public void setM_BUT_FRZ(HtmlCommandButton m_but_frz) {
		M_BUT_FRZ = m_but_frz;
	}


	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlCommandButton
		M_BUTT_ACC_FIR_DTLS				 = new HtmlCommandButton();
		COMP_UI_M_BUT_REOPEN					 = new HtmlAjaxCommandButton();
		COMP_UI_M_BUT_CLOSE					 	 = new HtmlCommandButton();
		COMP_UI_M_BUT_SETTLEMENT				 = new HtmlCommandButton();
		COMP_UI_M_BUT_STAUS_CHANGE				 = new HtmlCommandButton();
		M_BUT_FRZ					 	 = new HtmlCommandButton();
		
		UI_M_BUT_DEDUCTION				 = new HtmlCommandButton();
		UI_M_BUT_BONUS				 	 = new HtmlCommandButton();
		UI_M_BUT_MAIN_1					 = new HtmlCommandButton();
		COMP_UI_M_BUT_BONUS_MAIN		 = new HtmlCommandButton();
		
		/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
		COMP_UI_M_BUS_RUL                = new HtmlCommandButton();
		/*End*/

	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_REOPEN() {
		return COMP_UI_M_BUT_REOPEN;
	}




	public void setCOMP_UI_M_BUT_REOPEN(HtmlAjaxCommandButton comp_ui_m_but_reopen) {
		COMP_UI_M_BUT_REOPEN = comp_ui_m_but_reopen;
	}




	public HtmlCommandButton getCOMP_UI_M_BUT_CLOSE() {
		return COMP_UI_M_BUT_CLOSE;
	}




	public void setCOMP_UI_M_BUT_CLOSE(HtmlCommandButton comp_ui_m_but_close) {
		COMP_UI_M_BUT_CLOSE = comp_ui_m_but_close;
	}




	public HtmlCommandButton getCOMP_UI_M_BUT_SETTLEMENT() {
		return COMP_UI_M_BUT_SETTLEMENT;
	}




	public void setCOMP_UI_M_BUT_SETTLEMENT(
			HtmlCommandButton comp_ui_m_but_settlement) {
		COMP_UI_M_BUT_SETTLEMENT = comp_ui_m_but_settlement;
	}




	/**
	 * Disables all components in DUMMY_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlCommandButton
		M_BUTT_ACC_FIR_DTLS.setDisabled(disabled);
		COMP_UI_M_BUT_REOPEN.setDisabled(disabled);
		COMP_UI_M_BUT_CLOSE.setDisabled(disabled);
		COMP_UI_M_BUT_SETTLEMENT.setDisabled(disabled);
		COMP_UI_M_BUT_STAUS_CHANGE.setDisabled(disabled);
		M_BUT_FRZ.setDisabled(disabled);

	}
	
	public String whenButtonPressedStatusChange(){
		String outcome = null;
		
		try {
			compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getPT_IL_CLAIM_STATUS_BEAN().setCS_STATUS_DT(
					new CommonUtils().getCurrentDate());
			compositeAction.getPT_IL_CLAIM_STATUS_ACTION_BEAN().getCOMP_CS_STATUS_DT().setDisabled(true);
			outcome = "PILT006_APAC_PT_IL_CLAIM_STATUS_CHANGE";
		} catch (ParseException e) {
			e.printStackTrace();
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getErrorMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getErrorMap().put(
					"STATUS_CHANGE", e.getMessage());
		}
		
		return outcome;
	}

	/**
	 * @return the dUMMY_BEAN
	 */
	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	/**
	 * @param dummy_bean the dUMMY_BEAN to set
	 */
	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public HtmlCommandButton getUI_M_BUT_DEDUCTION() {
		return UI_M_BUT_DEDUCTION;
	}

	public void setUI_M_BUT_DEDUCTION(HtmlCommandButton ui_m_but_deduction) {
		UI_M_BUT_DEDUCTION = ui_m_but_deduction;
	}

	public HtmlCommandButton getUI_M_BUT_BONUS() {
		return UI_M_BUT_BONUS;
	}

	public void setUI_M_BUT_BONUS(HtmlCommandButton ui_m_but_bonus) {
		UI_M_BUT_BONUS = ui_m_but_bonus;
	}

	public HtmlCommandButton getUI_M_BUT_MAIN_1() {
		return UI_M_BUT_MAIN_1;
	}

	public void setUI_M_BUT_MAIN_1(HtmlCommandButton ui_m_but_main_1) {
		UI_M_BUT_MAIN_1 = ui_m_but_main_1;
	}

	// Button Actions
	public String whenButtonPressedUI_M_BUT_DEDUCTION(){
		String outcome = "PILT006_APAC_PT_IL_CLAIM_ESTIMATE_1";
		return outcome;
	}

	public String whenButtonPressedUI_M_BUT_BONUS(){
		String outcome = "PILT006_APAC_PT_IL_BONUS";
		return outcome;
	}

	public String whenButtonPressedUI_M_BUT_MAIN_1(){
		String outcome = "PILT006_APAC_PT_IL_CLAIM_ESTIMATE";
		return outcome;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BONUS_MAIN() {
		return COMP_UI_M_BUT_BONUS_MAIN;
	}

	public void setCOMP_UI_M_BUT_BONUS_MAIN(
			HtmlCommandButton comp_ui_m_but_bonus_main) {
		COMP_UI_M_BUT_BONUS_MAIN = comp_ui_m_but_bonus_main;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_STAUS_CHANGE() {
		return COMP_UI_M_BUT_STAUS_CHANGE;
	}

	public void setCOMP_UI_M_BUT_STAUS_CHANGE(
			HtmlCommandButton comp_ui_m_but_staus_change) {
		COMP_UI_M_BUT_STAUS_CHANGE = comp_ui_m_but_staus_change;
	}
	
	
	/*Added by saritha on 21-07-2017 for ssp call id ZBILQC-1732436*/
	private HtmlCommandButton COMP_UI_M_BUS_RUL;

	public HtmlCommandButton getCOMP_UI_M_BUS_RUL() {
		return COMP_UI_M_BUS_RUL;
	}

	public void setCOMP_UI_M_BUS_RUL(HtmlCommandButton cOMP_UI_M_BUS_RUL) {
		COMP_UI_M_BUS_RUL = cOMP_UI_M_BUS_RUL;
	}
	/*End*/
	
}
