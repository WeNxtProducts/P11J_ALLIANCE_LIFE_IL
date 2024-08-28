package com.iii.pel.forms.PILQ108_APAC;

import java.sql.SQLException;
import java.util.List;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.PhaseEvent;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {
	
	private static final Log log = LogFactory.getLog(DUMMY_ACTION.class);
	
	private DUMMY DUMMY_BEAN ;
	
	public PILQ108_APAC_COMPOSITE_ACTION compositeAction;
	
	private List<LovBean> suggestionLOV = null;
	
	private DUMMY_HELPER helper = null;
	
	private HtmlOutputLabel COMP_NEW_LC_NO_LABEL;
	
	private HtmlInputText COMP_NEW_LC_NO;
	
	private HtmlInputText COMP_OLD_LC_NO;
	
	private HtmlOutputLabel COMP_OLD_LC_NO_LABEL;

	private HtmlCommandButton BUT_PRESS;
	
	private HtmlCommandButton BUT_MAIN;

	/**
	 * @return the bUT_PRESS
	 */
	public HtmlCommandButton getBUT_PRESS() {
		return BUT_PRESS;
	}

	/**
	 * @param but_press the bUT_PRESS to set
	 */
	public void setBUT_PRESS(HtmlCommandButton but_press) {
		BUT_PRESS = but_press;
	}

	/**
	 * 
	 */
	public DUMMY_ACTION(){
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
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

	/**
	 * @return the compositeAction
	 */
	public PILQ108_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILQ108_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	/**
	 * 
	 * @param disabled
	 */
	public void disableAllComponent(boolean disabled){
		
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> newICNumberSugg(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILQ108_APAC", "DUMMY", "POAD_ASSRD_REF_ID1", 
					null, null, 
					null, null, null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	} 
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> oldICNumberSugg(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILQ108_APAC", "DUMMY", "POAD_ASSRD_REF_ID2", 
					null, null, 
					null, null, null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	} 
	
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event){
		
		try {
			if (isFormFlag()) {
				helper.preForm(compositeAction);
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				setBlockFlag(false);
			}
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ON_LOAD", e.getMessage());
		}
		
	}
	
	/**
	 * @throws Exception 
	 * 
	 */
	public void buttonPress() throws Exception{
		String newICNo = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOAD_ASSRD_REF_ID1();
		String oldICNo = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOAD_ASSRD_REF_ID2();
		
		log.info("New IC NO "+newICNo);
		log.info("Old IC NO "+oldICNo);
		
		compositeAction.getPOLICY_DETAILS_ACTION_BEAN().onLoad(null);
		compositeAction.getPOLICY_DETAILS_ACTION_BEAN().setBlockFlag(true);
		
	}

	public String buttonBack (){
		//ADDED BY AKASH TO BACK TO WITHDRAWL SCREEN
		if("PILT021".equals(CommonUtils.getGlobalVariable("PILT021"))){
			CommonUtils.setGlobalVariable("PILT021", null);
			return "PILT021_PT_IL_WITHDRAWAL" ;
		}else{
			return "PILT013_PT_IL_SURR_MAT_VALUES";
		}
		
	}
	
	
	public void setPCI_NEW_NO_SUGGESTION_VALUE(){
		try{
			String newICNo = (String)COMP_NEW_LC_NO.getSubmittedValue();
			log.info("=======>New Number======="+newICNo);
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setPOAD_ASSRD_REF_ID1(newICNo);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}

	public void setPCI_OLD_NO_SUGGESTION_VALUE(){
		try{
			String oldICNo = (String)COMP_OLD_LC_NO.getSubmittedValue();
			log.info("=======>Old Number======="+oldICNo);
			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setPOAD_ASSRD_REF_ID2(oldICNo);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		
	}
	
	/**
	 * @return the suggestionLOV
	 */
	public List<LovBean> getSuggestionLOV() {
		return suggestionLOV;
	}

	/**
	 * @param suggestionLOV the suggestionLOV to set
	 */
	public void setSuggestionLOV(List<LovBean> suggestionLOV) {
		this.suggestionLOV = suggestionLOV;
	}

	/**
	 * @return the helper
	 */
	public DUMMY_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(DUMMY_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the cOMP_NEW_LC_NO_LABEL
	 */
	public HtmlOutputLabel getCOMP_NEW_LC_NO_LABEL() {
		return COMP_NEW_LC_NO_LABEL;
	}

	/**
	 * @param comp_new_lc_no_label the cOMP_NEW_LC_NO_LABEL to set
	 */
	public void setCOMP_NEW_LC_NO_LABEL(HtmlOutputLabel comp_new_lc_no_label) {
		COMP_NEW_LC_NO_LABEL = comp_new_lc_no_label;
	}



	/**
	 * @return the cOMP_NEW_LC_NO
	 */
	public HtmlInputText getCOMP_NEW_LC_NO() {
		return COMP_NEW_LC_NO;
	}

	/**
	 * @param comp_new_lc_no the cOMP_NEW_LC_NO to set
	 */
	public void setCOMP_NEW_LC_NO(HtmlInputText comp_new_lc_no) {
		COMP_NEW_LC_NO = comp_new_lc_no;
	}

	/**
	 * @return the cOMP_OLD_LC_NO
	 */
	public HtmlInputText getCOMP_OLD_LC_NO() {
		return COMP_OLD_LC_NO;
	}

	/**
	 * @param comp_old_lc_no the cOMP_OLD_LC_NO to set
	 */
	public void setCOMP_OLD_LC_NO(HtmlInputText comp_old_lc_no) {
		COMP_OLD_LC_NO = comp_old_lc_no;
	}

	/**
	 * @return the cOMP_OLD_LC_NO_LABEL
	 */
	public HtmlOutputLabel getCOMP_OLD_LC_NO_LABEL() {
		return COMP_OLD_LC_NO_LABEL;
	}

	/**
	 * @param comp_old_lc_no_label the cOMP_OLD_LC_NO_LABEL to set
	 */
	public void setCOMP_OLD_LC_NO_LABEL(HtmlOutputLabel comp_old_lc_no_label) {
		COMP_OLD_LC_NO_LABEL = comp_old_lc_no_label;
	}

	/**
	 * @return the log
	 */
	public static Log getLog() {
		return log;
	}

	public HtmlCommandButton getBUT_MAIN() {
		return BUT_MAIN;
	}

	public void setBUT_MAIN(HtmlCommandButton but_main) {
		BUT_MAIN = but_main;
	}
	
	
	
}
