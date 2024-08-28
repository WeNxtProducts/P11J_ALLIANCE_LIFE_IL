package com.iii.pel.forms.PILP233;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILP233_DUMMY_ACTION extends CommonAction {
	
	 private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;
	 
	 private HtmlInputText COMP_UI_M_POL_NO_FM;
	 
	 private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;
	 
	 private HtmlInputText COMP_UI_M_POL_NO_TO;
	 
	 private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;
	 
	 private HtmlCalendar COMP_UI_M_PROCESS_DT;
	 
	 private HtmlAjaxCommandButton COMP_UI_M_PROC_BTN;
	 
	 private PILP233_DUMMY PILP233_DUMMY_BEAN;
	
	 public PILP233_DUMMY_ACTION() {
		// TODO Auto-generated constructor stub
		 PILP233_DUMMY_BEAN = new PILP233_DUMMY();
	 }

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(
			HtmlOutputLabel cOMP_UI_M_POL_NO_FM_LABEL) {
		COMP_UI_M_POL_NO_FM_LABEL = cOMP_UI_M_POL_NO_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText cOMP_UI_M_POL_NO_FM) {
		COMP_UI_M_POL_NO_FM = cOMP_UI_M_POL_NO_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel cOMP_UI_M_POL_NO_TO_LABEL) {
		COMP_UI_M_POL_NO_TO_LABEL = cOMP_UI_M_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText cOMP_UI_M_POL_NO_TO) {
		COMP_UI_M_POL_NO_TO = cOMP_UI_M_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel cOMP_UI_M_PROCESS_DT_LABEL) {
		COMP_UI_M_PROCESS_DT_LABEL = cOMP_UI_M_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar cOMP_UI_M_PROCESS_DT) {
		COMP_UI_M_PROCESS_DT = cOMP_UI_M_PROCESS_DT;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_PROC_BTN() {
		return COMP_UI_M_PROC_BTN;
	}

	public void setCOMP_UI_M_PROC_BTN(HtmlAjaxCommandButton cOMP_UI_M_PROC_BTN) {
		COMP_UI_M_PROC_BTN = cOMP_UI_M_PROC_BTN;
	}

	public PILP233_DUMMY getPILP233_DUMMY_BEAN() {
		return PILP233_DUMMY_BEAN;
	}

	public void setPILP233_DUMMY_BEAN(PILP233_DUMMY pILP233_DUMMY_BEAN) {
		PILP233_DUMMY_BEAN = pILP233_DUMMY_BEAN;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void actionListenerM_POL_NO_FROM(ActionEvent actionEvent) throws Exception 
	{
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		try {
			if (inputValue.isEmpty()) {
				COMP_UI_M_POL_NO_FM
						.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
				PILP233_DUMMY_BEAN.setUI_M_POL_NO_FM(PELConstants.PROCESS_TOVALUE);
			} else {
				PILP233_DUMMY_BEAN.setUI_M_POL_NO_FM(inputValue);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public void actionListenerM_POL_NO_TO(ActionEvent actionEvent) throws Exception
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)inputText.getSubmittedValue();
		try{
		if(inputTextString == "")
		{
			if(!PELConstants.PROCESS_FROMVALUE.equals(PILP233_DUMMY_BEAN.getUI_M_POL_NO_FM()))
			{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(PILP233_DUMMY_BEAN.getUI_M_POL_NO_FM());
				PILP233_DUMMY_BEAN.setUI_M_POL_NO_TO(PILP233_DUMMY_BEAN.getUI_M_POL_NO_FM());
			}else{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				PILP233_DUMMY_BEAN.setUI_M_POL_NO_TO(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			PILP233_DUMMY_BEAN.setUI_M_POL_NO_TO(inputTextString);
		}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	
	public void whenButtonPressedUI_M_BUT_OK(ActionEvent event)throws Exception {
		CommonUtils.clearMaps(this);
			
		try {
			System.out.println("INSIDE whenButtonPressedUI_M_BUT_OK  >>>>>>>>>>>>>>>>>>>>>>>>>>>");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
			String pDate = sdf.format(PILP233_DUMMY_BEAN.getUI_M_PROCESS_DT());
			System.out.println("test : " + PILP233_DUMMY_BEAN.getUI_M_PROCESS_DT() + " pDate " + pDate);
			P_CLIENT_NET_FUND(PILP233_DUMMY_BEAN.getUI_M_POL_NO_FM(),PILP233_DUMMY_BEAN.getUI_M_POL_NO_TO(),pDate);
			
			getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Process Done Successfully");
			getWarningMap().put("UPDATE", "Process Done Successfully");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			getErrorMap()
					.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							"Please check the Process");
			getErrorMap().put("UPDATE", "Please check the Process");
		}
	}
	
	public void validatorUI_M_POL_NO_FM(FacesContext context, UIComponent component,
			Object value) {
		try {
			PILP233_DUMMY_BEAN.setUI_M_POL_NO_FM((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validatorUI_M_POL_NO_TO(FacesContext context, UIComponent component,
			Object value) {
		try {
			PILP233_DUMMY_BEAN.setUI_M_POL_NO_TO((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public void validatorUI_M_PROCESS_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			PILP233_DUMMY_BEAN.setUI_M_PROCESS_DT((Date) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));

		}
	}
	
	public ArrayList<OracleParameter> P_CLIENT_NET_FUND(
			String P_POL_NO_FM, 
			String P_POL_NO_TO, 
			String P_PROCESS_DT
			) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN", P_POL_NO_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN", P_POL_NO_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "Date", "IN", P_PROCESS_DT);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"P9ILPK_POLICY_NR.P_CLIENT_NET_FUND");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP014",
					"DUMMY", "M_POL_NO_FM", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
}
