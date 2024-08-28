package com.iii.pel.forms.PP0100;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT002_APAC.DUMMY_ACTION;
import com.iii.pel.forms.PILT002_APAC.PT_IL_DOC_TODO_LIST_STATUS_DELEGATE;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BENEFICIARY;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;



public class PP0100_PT_IL_POLICY_ACTION extends CommonAction{
	
	private HtmlOutputLabel COMP_POL_NO_LABEL;
	
	private HtmlInputText COMP_POL_NO;
	
	private HtmlOutputLabel COMP_POL_DISPATCH_DT_LABEL;
	
	private HtmlCalendar COMP_POL_DISPATCH_DT;

	private HtmlOutputLabel COMP_POL_DOC_ACK_DT_LABEL;
	
	private HtmlCalendar COMP_POL_DOC_ACK_DT;
	
	private HtmlCommandLink COMP_BTN_SAVE;
	
	public PP0100_COMPOSITE_ACTION compositeAction;
	
	private PT_IL_POLICY PT_IL_POLICY_BEAN;
	
	public PP0100_PT_IL_POLICY_ACTION() {
		// TODO Auto-generated constructor stub
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel cOMP_POL_NO_LABEL) {
		COMP_POL_NO_LABEL = cOMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO(HtmlInputText cOMP_POL_NO) {
		COMP_POL_NO = cOMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_DISPATCH_DT_LABEL() {
		return COMP_POL_DISPATCH_DT_LABEL;
	}

	public void setCOMP_POL_DISPATCH_DT_LABEL(
			HtmlOutputLabel cOMP_POL_DISPATCH_DT_LABEL) {
		COMP_POL_DISPATCH_DT_LABEL = cOMP_POL_DISPATCH_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_DISPATCH_DT() {
		return COMP_POL_DISPATCH_DT;
	}

	public void setCOMP_POL_DISPATCH_DT(HtmlCalendar cOMP_POL_DISPATCH_DT) {
		COMP_POL_DISPATCH_DT = cOMP_POL_DISPATCH_DT;
	}

	public HtmlOutputLabel getCOMP_POL_DOC_ACK_DT_LABEL() {
		return COMP_POL_DOC_ACK_DT_LABEL;
	}

	public void setCOMP_POL_DOC_ACK_DT_LABEL(
			HtmlOutputLabel cOMP_POL_DOC_ACK_DT_LABEL) {
		COMP_POL_DOC_ACK_DT_LABEL = cOMP_POL_DOC_ACK_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_DOC_ACK_DT() {
		return COMP_POL_DOC_ACK_DT;
	}

	public void setCOMP_POL_DOC_ACK_DT(HtmlCalendar cOMP_POL_DOC_ACK_DT) {
		COMP_POL_DOC_ACK_DT = cOMP_POL_DOC_ACK_DT;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY pT_IL_POLICY_BEAN) {
		PT_IL_POLICY_BEAN = pT_IL_POLICY_BEAN;
	}

	public HtmlCommandLink getCOMP_BTN_SAVE() {
		return COMP_BTN_SAVE;
	}

	public void setCOMP_BTN_SAVE(HtmlCommandLink cOMP_BTN_SAVE) {
		COMP_BTN_SAVE = cOMP_BTN_SAVE;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void validatePOL_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		String qry = "SELECT POL_DISPATCH_DT,POL_DOC_ACK_DT FROM PT_IL_POLICY WHERE POL_NO = ?";
		ResultSet rs = null;
		try{
			PT_IL_POLICY_BEAN.setPOL_NO((String)value);
			rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection(),new Object[]{PT_IL_POLICY_BEAN.getPOL_NO()});
			if(rs.next()){
				if(rs.getDate("POL_DISPATCH_DT") != null){
					PT_IL_POLICY_BEAN.setPOL_DISPATCH_DT(rs.getDate("POL_DISPATCH_DT"));
				}
				if(rs.getDate("POL_DOC_ACK_DT") != null){
				    PT_IL_POLICY_BEAN.setPOL_DOC_ACK_DT(rs.getDate("POL_DOC_ACK_DT"));
				}
			}else{
				System.out.println("Date rs in empty");
			}
			/*COMP_POL_DISPATCH_DT.resetValue();
			COMP_POL_DOC_ACK_DT.resetValue();*/
			
			System.out.println("POL_DISPATCH_DT ::" + PT_IL_POLICY_BEAN.getPOL_DISPATCH_DT() + "::POL_DOC_ACK_DT::" + PT_IL_POLICY_BEAN.getPOL_DOC_ACK_DT());
			if(PT_IL_POLICY_BEAN.getPOL_DISPATCH_DT() != null){
				COMP_POL_DISPATCH_DT.setDisabled(true);
			}else{
				COMP_POL_DISPATCH_DT.setDisabled(false);
			}
			if(PT_IL_POLICY_BEAN.getPOL_DOC_ACK_DT() != null){
				COMP_POL_DOC_ACK_DT.setDisabled(true);
			}else{
				COMP_POL_DOC_ACK_DT.setDisabled(false);
			}
		}catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	public void validatePOL_DISPATCH_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try{
			PT_IL_POLICY_BEAN.setPOL_DISPATCH_DT((Date)value);
			System.out.println("hi 22:::::" + PT_IL_POLICY_BEAN.getPOL_DISPATCH_DT());
		
		}catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	
	/*public void validatePOL_DISPATCH_DT(ActionEvent actionEvent) throws ValidatorException {
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try{
			
			PT_IL_POLICY_BEAN.setPOL_DISPATCH_DT((Date)value);
			System.out.println("hi 22:::::" + PT_IL_POLICY_BEAN.getPOL_DISPATCH_DT());
		
		}catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}*/
	
	public void validatePOL_DOC_ACK_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try{
			PT_IL_POLICY_BEAN.setPOL_DOC_ACK_DT((Date)value);
			System.out.println("hello ::::" +PT_IL_POLICY_BEAN.getPOL_DOC_ACK_DT());
		
		}catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} 
	}
	public void saveRecord() {
		
		String message = null;
		CommonUtils.clearMaps(this);
		String UpdateQuery= "UPDATE PT_IL_POLICY SET POL_DISPATCH_DT=?,POL_DOC_ACK_DT=? WHERE POL_NO=?";
		try {
			if (getPT_IL_POLICY_BEAN().getPOL_NO() != null) {
				System.out.println("INSIDE POL_NO NOT NULL");
				
					new CRUDHandler().executeUpdateStatement(UpdateQuery,CommonUtils.getConnection(),
							new Object[]{PT_IL_POLICY_BEAN.getPOL_DISPATCH_DT(),PT_IL_POLICY_BEAN.getPOL_DOC_ACK_DT(),PT_IL_POLICY_BEAN.getPOL_NO()});
					
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				CommonUtils.getConnection().commit();
			} 			 
	    } catch (Exception e) {
			e.printStackTrace();
			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);

		}
	}
}
