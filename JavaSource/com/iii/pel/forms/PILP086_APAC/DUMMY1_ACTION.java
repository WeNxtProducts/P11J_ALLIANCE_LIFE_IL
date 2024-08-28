package com.iii.pel.forms.PILP086_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY1_ACTION extends CommonAction {
	
	private HtmlOutputLabel COMP_HFH_POL_NO_FM_LABEL;

	private HtmlInputText COMP_HFH_POL_NO_FM;

	private HtmlOutputLabel COMP_HFH_POL_NO_TO_LABEL;

	private HtmlInputText COMP_HFH_POL_NO_TO;

	private HtmlOutputLabel COMP_HFH_DATE_FM_LABEL;

	private HtmlCalendar COMP_HFH_DATE_FM;
	
	private HtmlCommandButton UI_BUT_FETCH_RECORD;
	
	private HtmlCommandButton UI_BUT_FETCH_PROCESS;

	private DUMMY1 DUMMY1_BEAN;

	public PILP086_APAC_COMPOSITE_ACTION compositeAction;

	private DUMMY1_HELPER helper;

	private List<LovBean> suggestionLOV = null;
	
	public DUMMY1_ACTION() {

		DUMMY1_BEAN = new DUMMY1();
		helper = new DUMMY1_HELPER();
	}

	public HtmlOutputLabel getCOMP_HFH_POL_NO_FM_LABEL() {
		return COMP_HFH_POL_NO_FM_LABEL;
	}

	public HtmlInputText getCOMP_HFH_POL_NO_FM() {
		return COMP_HFH_POL_NO_FM;
	}

	public void setCOMP_HFH_POL_NO_FM_LABEL(
			HtmlOutputLabel COMP_HFH_POL_NO_FM_LABEL) {
		this.COMP_HFH_POL_NO_FM_LABEL = COMP_HFH_POL_NO_FM_LABEL;
	}

	public void setCOMP_HFH_POL_NO_FM(HtmlInputText COMP_HFH_POL_NO_FM) {
		this.COMP_HFH_POL_NO_FM = COMP_HFH_POL_NO_FM;
	}

	public HtmlOutputLabel getCOMP_HFH_POL_NO_TO_LABEL() {
		return COMP_HFH_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_HFH_POL_NO_TO() {
		return COMP_HFH_POL_NO_TO;
	}

	public void setCOMP_HFH_POL_NO_TO_LABEL(
			HtmlOutputLabel COMP_HFH_POL_NO_TO_LABEL) {
		this.COMP_HFH_POL_NO_TO_LABEL = COMP_HFH_POL_NO_TO_LABEL;
	}

	public void setCOMP_HFH_POL_NO_TO(HtmlInputText COMP_HFH_POL_NO_TO) {
		this.COMP_HFH_POL_NO_TO = COMP_HFH_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_HFH_DATE_FM_LABEL() {
		return COMP_HFH_DATE_FM_LABEL;
	}

	public HtmlCalendar getCOMP_HFH_DATE_FM() {
		return COMP_HFH_DATE_FM;
	}

	public void setCOMP_HFH_DATE_FM_LABEL(HtmlOutputLabel COMP_HFH_DATE_FM_LABEL) {
		this.COMP_HFH_DATE_FM_LABEL = COMP_HFH_DATE_FM_LABEL;
	}

	public void setCOMP_HFH_DATE_FM(HtmlCalendar COMP_HFH_DATE_FM) {
		this.COMP_HFH_DATE_FM = COMP_HFH_DATE_FM;
	}

	public DUMMY1 getDUMMY1_BEAN() {
		return DUMMY1_BEAN;
	}

	public void setDUMMY1_BEAN(DUMMY1 DUMMY1_BEAN) {
		this.DUMMY1_BEAN = DUMMY1_BEAN;
	}

	public void saveRecord() {
		try {
			/*
			 * if (getDUMMY1_BEAN().getROWID() != null) { new
			 * CRUDHandler().executeInsert(getDUMMY1_BEAN(),
			 * CommonUtils.getConnection()); } else { new
			 * CRUDHandler().executeInsert(getDUMMY1_BEAN(),
			 * CommonUtils.getConnection()); }
			 */
			CommonUtils.getConnection().commit();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param actionEvent
	 */
	public void validatePolicyFrom(ActionEvent actionEvent) {
		DUMMY1_BEAN.setHFH_POL_NO_FM(COMP_HFH_POL_NO_FM.getSubmittedValue()!=null ? COMP_HFH_POL_NO_FM.getSubmittedValue().toString() : "");
		
		String C1 = "SELECT POL_ADDL_STATUS FROM   PT_IL_POLICY WHERE POL_NO = ?";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		Connection connection =null;
		String M_POL_ADDL_STATUS = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			

			if(DUMMY1_BEAN.getHFH_POL_NO_FM()==null ||
					"".equalsIgnoreCase(DUMMY1_BEAN.getHFH_POL_NO_FM())){
				DUMMY1_BEAN.setHFH_POL_NO_FM("0");
				COMP_HFH_POL_NO_FM.setSubmittedValue("0");
				COMP_HFH_POL_NO_FM.resetValue();
			}else{
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY1_BEAN.getHFH_POL_NO_FM()});
				if(C1_REC.next()){
					M_POL_ADDL_STATUS = C1_REC.getString(1);
				}
				if(!"H".equalsIgnoreCase(M_POL_ADDL_STATUS)){
					throw new Exception("Policy Already Settled For Hibah");
				}
			}
			
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.preBlock(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				helper.whenCreateRecord(DUMMY1_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	

	/**
	 * 
	 * @param value
	 * @return
	 */
	public List<LovBean> policyFromLov(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILP086_APAC", "DUMMY1", "HFH_POL_NO_FM", 
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
	 * @param value
	 * @return
	 */
	public List<LovBean> policyToLov(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILP086_APAC", "DUMMY1", "HFH_POL_NO_TO", 
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
	 */
	public void fetchRecord(){
		try {
			compositeAction.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN().onLoad(null);
			compositeAction.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN().setFormFlag(true);
			compositeAction.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN().setBlockFlag(true);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}

	/**
	 * 
	 */
	public void processRecord() {
		try {
			compositeAction.getPT_IL_HIBAH_FEE_PRCSS_ACTION_BEAN().processButton();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
		}
	}
	/**
	 * @return the uI_BUT_FETCH_RECORD
	 */
	public HtmlCommandButton getUI_BUT_FETCH_RECORD() {
		return UI_BUT_FETCH_RECORD;
	}

	/**
	 * @param ui_but_fetch_record the uI_BUT_FETCH_RECORD to set
	 */
	public void setUI_BUT_FETCH_RECORD(HtmlCommandButton ui_but_fetch_record) {
		UI_BUT_FETCH_RECORD = ui_but_fetch_record;
	}
	
	
	public void whenValidateHFH_DATE_FM(ActionEvent actionEvent) {

		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());

		if (input.isValid()) {
			this.DUMMY1_BEAN.setHFH_DATE_FM((Date) input.getValue());
		}
	}

	/**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 */
	public void policyFromValidation(FacesContext facesContext,
			UIComponent component, Object value) {
		DUMMY1_BEAN.setHFH_POL_NO_FM((String)value);
		String C1 = "SELECT POL_ADDL_STATUS FROM   PT_IL_POLICY WHERE POL_NO = ?";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		Connection connection =null;
		String M_POL_ADDL_STATUS = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(!"0".equalsIgnoreCase(DUMMY1_BEAN.getHFH_POL_NO_FM())){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY1_BEAN.getHFH_POL_NO_FM()});
				if(C1_REC.next()){
					M_POL_ADDL_STATUS = C1_REC.getString(1);
				}
				if(!"H".equalsIgnoreCase(M_POL_ADDL_STATUS)){
					throw new Exception("Policy Already Settled For Hibah");
				}
			}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
		
	}
	
	/**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 */
	public void policyToValidation(FacesContext facesContext,
			UIComponent component, Object value) {
		DUMMY1_BEAN.setHFH_POL_NO_TO((String)value);
		String C1 = "SELECT POL_ADDL_STATUS FROM   PT_IL_POLICY WHERE POL_NO = ?";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		Connection connection =null;
		String M_POL_ADDL_STATUS = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(!"zzzz".equalsIgnoreCase(DUMMY1_BEAN.getHFH_POL_NO_TO())){
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY1_BEAN.getHFH_POL_NO_TO()});
				if(C1_REC.next()){
					M_POL_ADDL_STATUS = C1_REC.getString(1);
				}
				if(!"H".equalsIgnoreCase(M_POL_ADDL_STATUS)){
					throw new Exception("Policy Already Settled For Hibah");
				}
			}
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
		
	}
	
	/**
	 * 
	 * @param facesContext
	 * @param component
	 * @param value
	 */
	public void validatePolicyTO(ActionEvent event) {
		DUMMY1_BEAN.setHFH_POL_NO_TO(COMP_HFH_POL_NO_TO.getSubmittedValue()!=null ? COMP_HFH_POL_NO_TO.getSubmittedValue().toString() : "");
		String C1 = "SELECT POL_ADDL_STATUS FROM   PT_IL_POLICY WHERE POL_NO = ?";
		ResultSet C1_REC = null;
		CRUDHandler handler = null;
		Connection connection =null;
		String M_POL_ADDL_STATUS = null;
		try{
			if((DUMMY1_BEAN.getHFH_POL_NO_FM()!=null &&
					"0".equalsIgnoreCase(DUMMY1_BEAN.getHFH_POL_NO_FM())) ||
					(DUMMY1_BEAN.getHFH_POL_NO_TO()==null || "".equalsIgnoreCase(DUMMY1_BEAN.getHFH_POL_NO_TO()) )){
				DUMMY1_BEAN.setHFH_POL_NO_TO("zzzz");
				COMP_HFH_POL_NO_TO.setSubmittedValue("zzzz");
				COMP_HFH_POL_NO_TO.resetValue();
			}else{
				connection = CommonUtils.getConnection();
				handler = new CRUDHandler();
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{DUMMY1_BEAN.getHFH_POL_NO_TO()});
				if(C1_REC.next()){
					M_POL_ADDL_STATUS = C1_REC.getString(1);
				}
				if(!"H".equalsIgnoreCase(M_POL_ADDL_STATUS)){
					throw new Exception("Policy Already Settled For Hibah");
				}
			}
			
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
		
	}
	

	/**
	 * @return the uI_BUT_FETCH_PROCESS
	 */
	public HtmlCommandButton getUI_BUT_FETCH_PROCESS() {
		return UI_BUT_FETCH_PROCESS;
	}

	/**
	 * @param ui_but_fetch_process the uI_BUT_FETCH_PROCESS to set
	 */
	public void setUI_BUT_FETCH_PROCESS(HtmlCommandButton ui_but_fetch_process) {
		UI_BUT_FETCH_PROCESS = ui_but_fetch_process;
	}
}
