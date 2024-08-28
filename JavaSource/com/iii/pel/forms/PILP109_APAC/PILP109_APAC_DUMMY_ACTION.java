/**
 * 
 */
package com.iii.pel.forms.PILP109_APAC;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

/**
 * @author 55368
 *
 */
public class PILP109_APAC_DUMMY_ACTION extends CommonAction{
	
	private PILP109_APAC_DUMMY DUMMY_BEAN=null;
	
	private HtmlInputText COMP_UFD_PROD_FM;
	
	private HtmlInputText COMP_UFD_PROD_TO;
	
	private HtmlOutputLabel COMP_UFD_PROD_FM_LABEL;
	
	private HtmlOutputLabel COMP_UFD_PROD_TO_LABEL;
	
	private HtmlCommandButton COMP_PROD_PROCESS;

	private PILP109_APAC_DUMMY_HELPER helper;
	
	public PILP109_APAC_DUMMY_ACTION() {
		DUMMY_BEAN = new PILP109_APAC_DUMMY();
		helper = new PILP109_APAC_DUMMY_HELPER();
	}

	/**
	 * @return the dUMMY_BEAN
	 */
	public PILP109_APAC_DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	/**
	 * @param dummy_bean the dUMMY_BEAN to set
	 */
	public void setDUMMY_BEAN(PILP109_APAC_DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	/**
	 * @return the cOMP_UFD_PROD_FM
	 */
	public HtmlInputText getCOMP_UFD_PROD_FM() {
		return COMP_UFD_PROD_FM;
	}

	/**
	 * @param comp_ufd_prod_fm the cOMP_UFD_PROD_FM to set
	 */
	public void setCOMP_UFD_PROD_FM(HtmlInputText comp_ufd_prod_fm) {
		COMP_UFD_PROD_FM = comp_ufd_prod_fm;
	}

	/**
	 * @return the cOMP_UFD_PROD_TO
	 */
	public HtmlInputText getCOMP_UFD_PROD_TO() {
		return COMP_UFD_PROD_TO;
	}

	/**
	 * @param comp_ufd_prod_to the cOMP_UFD_PROD_TO to set
	 */
	public void setCOMP_UFD_PROD_TO(HtmlInputText comp_ufd_prod_to) {
		COMP_UFD_PROD_TO = comp_ufd_prod_to;
	}

	/**
	 * @return the cOMP_UFD_PROD_FM_LABEL
	 */
	public HtmlOutputLabel getCOMP_UFD_PROD_FM_LABEL() {
		return COMP_UFD_PROD_FM_LABEL;
	}

	/**
	 * @param comp_ufd_prod_fm_label the cOMP_UFD_PROD_FM_LABEL to set
	 */
	public void setCOMP_UFD_PROD_FM_LABEL(HtmlOutputLabel comp_ufd_prod_fm_label) {
		COMP_UFD_PROD_FM_LABEL = comp_ufd_prod_fm_label;
	}

	/**
	 * @return the cOMP_UFD_PROD_TO_LABEL
	 */
	public HtmlOutputLabel getCOMP_UFD_PROD_TO_LABEL() {
		return COMP_UFD_PROD_TO_LABEL;
	}

	/**
	 * @param comp_ufd_prod_to_label the cOMP_UFD_PROD_TO_LABEL to set
	 */
	public void setCOMP_UFD_PROD_TO_LABEL(HtmlOutputLabel comp_ufd_prod_to_label) {
		COMP_UFD_PROD_TO_LABEL = comp_ufd_prod_to_label;
	}

	/**
	 * @return the cOMP_PROD_PROCESS
	 */
	public HtmlCommandButton getCOMP_PROD_PROCESS() {
		return COMP_PROD_PROCESS;
	}

	/**
	 * @param comp_prod_process the cOMP_PROD_PROCESS to set
	 */
	public void setCOMP_PROD_PROCESS(HtmlCommandButton comp_prod_process) {
		COMP_PROD_PROCESS = comp_prod_process;
	}
	
	/**
	 * 
	 * @param phaseEvent
	 */
	public void onLoad(PhaseEvent phaseEvent){
		
	}

	/**
	 * Process button action.
	 * @return
	 */
	public String buttonPressProcess(){
		String productFrom = DUMMY_BEAN.getPT_PROD_FROM();
		String productTo = DUMMY_BEAN.getPT_PROD_TO();
		
		System.out.println("Product From========>"+productFrom);
		System.out.println("Product To========>"+productTo);
		
		try{
			helper.buttonProcess(DUMMY_BEAN);
			getWarningMap().put("current", "Process Uploaded Sucessfully");
			
		}catch(Exception exception){
			exception.getMessage();
			getErrorMap().put("current", exception.getMessage());
		}
		
		
		return null;
	}
	
	/**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
    public void validatePOL_PROD_FM(FacesContext facesContext,
    		UIComponent component, Object value) throws ValidatorException {
    	CommonUtils.clearMaps(this);
    	try {
    		DUMMY_BEAN.setPT_PROD_FROM((String)value);
    		if(DUMMY_BEAN.getPT_PROD_FROM()==null 
    				|| "".equalsIgnoreCase(DUMMY_BEAN.getPT_PROD_FROM())){
    			//COMP_UFD_PROD_FM.setSubmittedValue("0");
    			DUMMY_BEAN.setPT_PROD_FROM("0");
    			//COMP_UFD_PROD_FM.resetValue();
    		}
    		
    		if(!"0".equalsIgnoreCase(DUMMY_BEAN.getPT_PROD_FROM())){
    			helper.validateProductCode(DUMMY_BEAN.getPT_PROD_FROM());
    		}
    		
    	} catch (Exception exception) {
    		exception.printStackTrace();
    		throw new ValidatorException(new FacesMessage(exception
    				.getMessage()));
    	}
    }

    /**
     * 
     * @param actionEvent
     */
    public void listenerPOL_PROD_FM(ActionEvent actionEvent) {
		try {
			getWarningMap().clear();
			UIInput htmlInputText = (UIInput) actionEvent.getComponent()
					.getParent();
			String inputValue = (String) htmlInputText.getSubmittedValue();
			if (inputValue.isEmpty()) {
				getCOMP_UFD_PROD_FM().setSubmittedValue("0");
				DUMMY_BEAN.setPT_PROD_FROM("0");
			} else {
				DUMMY_BEAN.setPT_PROD_FROM(inputValue);
				ErrorHelpUtil.validate(htmlInputText, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}

    /**
     * 
     * @param actionEvent
     */
    public void listenerPOL_PROD_TO(ActionEvent actionEvent) {
    	try {
			getWarningMap().clear();
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String inputValue = (String) input.getSubmittedValue();
			if (inputValue.isEmpty()) {
				String claimNumFm = DUMMY_BEAN.getPT_PROD_FROM();
				if (!claimNumFm.trim().equals("0")) {
					getCOMP_UFD_PROD_TO().setSubmittedValue(claimNumFm);
					DUMMY_BEAN.setPT_PROD_TO(claimNumFm);
				} else {
					getCOMP_UFD_PROD_TO().setSubmittedValue("zzzzzzzzzz");
					DUMMY_BEAN.setPT_PROD_TO("zzzzzzzzzz");
				}
			} else {
				DUMMY_BEAN.setPT_PROD_TO(inputValue);
				ErrorHelpUtil.validate(input, getErrorMap());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		}
    
    public void fireFieldValidation(ActionEvent actionEvent) {
    	UIInput input = (UIInput) actionEvent.getComponent().getParent();
    	ErrorHelpUtil.validate(input, getErrorMap());
    }

    /**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
    public void validatePOL_PROD_TO(FacesContext facesContext,
    		UIComponent component, Object value) throws ValidatorException {
    	CommonUtils.clearMaps(this);
    	try {
    		DUMMY_BEAN.setPT_PROD_TO((String)value);
    		if(DUMMY_BEAN.getPT_PROD_TO()==null 
    				|| "".equalsIgnoreCase(DUMMY_BEAN.getPT_PROD_TO())){
    			COMP_UFD_PROD_TO.setSubmittedValue("zzzzzzzzzzzz");
    			DUMMY_BEAN.setPT_PROD_TO("zzzzzzzzzzzz");
    			COMP_UFD_PROD_TO.resetValue();
    		}
    		
    		if(!"zzzzzzzzzzzz".equalsIgnoreCase(DUMMY_BEAN.getPT_PROD_TO())){
    			helper.validateProductCode(DUMMY_BEAN.getPT_PROD_TO());
    		}

    	} catch (Exception exception) {
    		exception.printStackTrace();
    		throw new ValidatorException(new FacesMessage(exception
    				.getMessage()));
    	}
    }

	/**
	 * @return the helper
	 */
	public PILP109_APAC_DUMMY_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PILP109_APAC_DUMMY_HELPER helper) {
		this.helper = helper;
	}
    
	/**
	 * 
	 * @param currValue
	 * @return
	 */
	 public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_CODE(Object currValue) {
	    	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
	    	ListItemUtil listitemutil = new ListItemUtil();
	    	try {
	    		suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
	    				"PT_IL_POLICY", "POL_PROD_CODE", null, null, null, null,
	    				null, (String) currValue);
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
	    	return suggestionList;
	    }
}
