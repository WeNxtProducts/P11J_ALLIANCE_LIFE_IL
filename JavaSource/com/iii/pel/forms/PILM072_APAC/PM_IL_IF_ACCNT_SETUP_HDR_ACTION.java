package com.iii.pel.forms.PILM072_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;


/**
 * @author 51240
 *
 */
public class PM_IL_IF_ACCNT_SETUP_HDR_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_PIFH_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PIFH_FRZ_FLAG;

	private HtmlOutputLabel COMP_PIFH_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_PIFH_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_PIFH_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_PIFH_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;

	private HtmlOutputLabel COMP_PIFH_DIVN_CODE_LABEL;

	private HtmlInputText COMP_PIFH_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_PIFH_DEPT_CODE_LABEL;

	private HtmlInputText COMP_PIFH_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_PIFH_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_PIFH_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_PIFH_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_PIFH_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_PIFH_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_PIFH_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_PIFH_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_PIFH_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

	private HtmlOutputLabel COMP_PIFH_DRCR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PIFH_DRCR_FLAG;

	private PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN;

	public PILM072_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_IF_ACCNT_SETUP_HDR_HELPER helper;

	private List<SelectItem> listPIFH_DRCR_FLAG = new ArrayList<SelectItem>();
	
	private HtmlGraphicImage COMP_PIFH_SUB_ACNT_IMG;

	
	List<LovBean> suggestionList = null;

	public PM_IL_IF_ACCNT_SETUP_HDR_ACTION() {

		PM_IL_IF_ACCNT_SETUP_HDR_BEAN = new PM_IL_IF_ACCNT_SETUP_HDR();
		helper = new PM_IL_IF_ACCNT_SETUP_HDR_HELPER();
		setListPIFH_DRCR_FLAG(ListItemUtil.getDropDownListValue(
				getConnection(), "PILM072_APAC", "PM_IL_IF_ACCNT_SETUP_HDR",
				"PM_IL_IF_ACCNT_SETUP_HDR.PIFH_DRCR_FLAG", "C/D"));
	}

	public HtmlOutputLabel getCOMP_PIFH_FRZ_FLAG_LABEL() {
		return COMP_PIFH_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PIFH_FRZ_FLAG() {
		return COMP_PIFH_FRZ_FLAG;
	}

	public void setCOMP_PIFH_FRZ_FLAG_LABEL(
			HtmlOutputLabel COMP_PIFH_FRZ_FLAG_LABEL) {
		this.COMP_PIFH_FRZ_FLAG_LABEL = COMP_PIFH_FRZ_FLAG_LABEL;
	}

	public void setCOMP_PIFH_FRZ_FLAG(
			HtmlSelectBooleanCheckbox COMP_PIFH_FRZ_FLAG) {
		this.COMP_PIFH_FRZ_FLAG = COMP_PIFH_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_PIFH_MAIN_ACNT_CODE_LABEL() {
		return COMP_PIFH_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_MAIN_ACNT_CODE() {
		return COMP_PIFH_MAIN_ACNT_CODE;
	}

	public void setCOMP_PIFH_MAIN_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_PIFH_MAIN_ACNT_CODE_LABEL) {
		this.COMP_PIFH_MAIN_ACNT_CODE_LABEL = COMP_PIFH_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_PIFH_MAIN_ACNT_CODE(
			HtmlInputText COMP_PIFH_MAIN_ACNT_CODE) {
		this.COMP_PIFH_MAIN_ACNT_CODE = COMP_PIFH_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_NAME_LABEL() {
		return COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_NAME_LABEL = COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(
			HtmlInputText COMP_UI_M_MAIN_ACNT_NAME) {
		this.COMP_UI_M_MAIN_ACNT_NAME = COMP_UI_M_MAIN_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_PIFH_SUB_ACNT_CODE_LABEL() {
		return COMP_PIFH_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_SUB_ACNT_CODE() {
		return COMP_PIFH_SUB_ACNT_CODE;
	}

	public void setCOMP_PIFH_SUB_ACNT_CODE_LABEL(
			HtmlOutputLabel COMP_PIFH_SUB_ACNT_CODE_LABEL) {
		this.COMP_PIFH_SUB_ACNT_CODE_LABEL = COMP_PIFH_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_PIFH_SUB_ACNT_CODE(HtmlInputText COMP_PIFH_SUB_ACNT_CODE) {
		this.COMP_PIFH_SUB_ACNT_CODE = COMP_PIFH_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_NAME_LABEL() {
		return COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_NAME() {
		return COMP_UI_M_SUB_ACNT_NAME;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL) {
		this.COMP_UI_M_SUB_ACNT_NAME_LABEL = COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME(HtmlInputText COMP_UI_M_SUB_ACNT_NAME) {
		this.COMP_UI_M_SUB_ACNT_NAME = COMP_UI_M_SUB_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_PIFH_DIVN_CODE_LABEL() {
		return COMP_PIFH_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_DIVN_CODE() {
		return COMP_PIFH_DIVN_CODE;
	}

	public void setCOMP_PIFH_DIVN_CODE_LABEL(
			HtmlOutputLabel COMP_PIFH_DIVN_CODE_LABEL) {
		this.COMP_PIFH_DIVN_CODE_LABEL = COMP_PIFH_DIVN_CODE_LABEL;
	}

	public void setCOMP_PIFH_DIVN_CODE(HtmlInputText COMP_PIFH_DIVN_CODE) {
		this.COMP_PIFH_DIVN_CODE = COMP_PIFH_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_NAME_LABEL() {
		return COMP_UI_M_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
		this.COMP_UI_M_DIVN_NAME_LABEL = COMP_UI_M_DIVN_NAME_LABEL;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText COMP_UI_M_DIVN_NAME) {
		this.COMP_UI_M_DIVN_NAME = COMP_UI_M_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_PIFH_DEPT_CODE_LABEL() {
		return COMP_PIFH_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_DEPT_CODE() {
		return COMP_PIFH_DEPT_CODE;
	}

	public void setCOMP_PIFH_DEPT_CODE_LABEL(
			HtmlOutputLabel COMP_PIFH_DEPT_CODE_LABEL) {
		this.COMP_PIFH_DEPT_CODE_LABEL = COMP_PIFH_DEPT_CODE_LABEL;
	}

	public void setCOMP_PIFH_DEPT_CODE(HtmlInputText COMP_PIFH_DEPT_CODE) {
		this.COMP_PIFH_DEPT_CODE = COMP_PIFH_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_NAME_LABEL() {
		return COMP_UI_M_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
		this.COMP_UI_M_DEPT_NAME_LABEL = COMP_UI_M_DEPT_NAME_LABEL;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText COMP_UI_M_DEPT_NAME) {
		this.COMP_UI_M_DEPT_NAME = COMP_UI_M_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_PIFH_ANLY_CODE_1_LABEL() {
		return COMP_PIFH_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_ANLY_CODE_1() {
		return COMP_PIFH_ANLY_CODE_1;
	}

	public void setCOMP_PIFH_ANLY_CODE_1_LABEL(
			HtmlOutputLabel COMP_PIFH_ANLY_CODE_1_LABEL) {
		this.COMP_PIFH_ANLY_CODE_1_LABEL = COMP_PIFH_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_PIFH_ANLY_CODE_1(HtmlInputText COMP_PIFH_ANLY_CODE_1) {
		this.COMP_PIFH_ANLY_CODE_1 = COMP_PIFH_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_LABEL() {
		return COMP_UI_M_ANLY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME() {
		return COMP_UI_M_ANLY_NAME;
	}

	public void setCOMP_UI_M_ANLY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL) {
		this.COMP_UI_M_ANLY_NAME_LABEL = COMP_UI_M_ANLY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME(HtmlInputText COMP_UI_M_ANLY_NAME) {
		this.COMP_UI_M_ANLY_NAME = COMP_UI_M_ANLY_NAME;
	}

	public HtmlOutputLabel getCOMP_PIFH_ANLY_CODE_2_LABEL() {
		return COMP_PIFH_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_ANLY_CODE_2() {
		return COMP_PIFH_ANLY_CODE_2;
	}

	public void setCOMP_PIFH_ANLY_CODE_2_LABEL(
			HtmlOutputLabel COMP_PIFH_ANLY_CODE_2_LABEL) {
		this.COMP_PIFH_ANLY_CODE_2_LABEL = COMP_PIFH_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_PIFH_ANLY_CODE_2(HtmlInputText COMP_PIFH_ANLY_CODE_2) {
		this.COMP_PIFH_ANLY_CODE_2 = COMP_PIFH_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_1_LABEL() {
		return COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME_1() {
		return COMP_UI_M_ANLY_NAME_1;
	}

	public void setCOMP_UI_M_ANLY_NAME_1_LABEL(
			HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL) {
		this.COMP_UI_M_ANLY_NAME_1_LABEL = COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME_1(HtmlInputText COMP_UI_M_ANLY_NAME_1) {
		this.COMP_UI_M_ANLY_NAME_1 = COMP_UI_M_ANLY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_PIFH_ACTY_CODE_1_LABEL() {
		return COMP_PIFH_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_ACTY_CODE_1() {
		return COMP_PIFH_ACTY_CODE_1;
	}

	public void setCOMP_PIFH_ACTY_CODE_1_LABEL(
			HtmlOutputLabel COMP_PIFH_ACTY_CODE_1_LABEL) {
		this.COMP_PIFH_ACTY_CODE_1_LABEL = COMP_PIFH_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_PIFH_ACTY_CODE_1(HtmlInputText COMP_PIFH_ACTY_CODE_1) {
		this.COMP_PIFH_ACTY_CODE_1 = COMP_PIFH_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_LABEL() {
		return COMP_UI_M_ACTY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME() {
		return COMP_UI_M_ACTY_NAME;
	}

	public void setCOMP_UI_M_ACTY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL) {
		this.COMP_UI_M_ACTY_NAME_LABEL = COMP_UI_M_ACTY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME(HtmlInputText COMP_UI_M_ACTY_NAME) {
		this.COMP_UI_M_ACTY_NAME = COMP_UI_M_ACTY_NAME;
	}

	public HtmlOutputLabel getCOMP_PIFH_ACTY_CODE_2_LABEL() {
		return COMP_PIFH_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PIFH_ACTY_CODE_2() {
		return COMP_PIFH_ACTY_CODE_2;
	}

	public void setCOMP_PIFH_ACTY_CODE_2_LABEL(
			HtmlOutputLabel COMP_PIFH_ACTY_CODE_2_LABEL) {
		this.COMP_PIFH_ACTY_CODE_2_LABEL = COMP_PIFH_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_PIFH_ACTY_CODE_2(HtmlInputText COMP_PIFH_ACTY_CODE_2) {
		this.COMP_PIFH_ACTY_CODE_2 = COMP_PIFH_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_1_LABEL() {
		return COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME_1() {
		return COMP_UI_M_ACTY_NAME_1;
	}

	public void setCOMP_UI_M_ACTY_NAME_1_LABEL(
			HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL) {
		this.COMP_UI_M_ACTY_NAME_1_LABEL = COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME_1(HtmlInputText COMP_UI_M_ACTY_NAME_1) {
		this.COMP_UI_M_ACTY_NAME_1 = COMP_UI_M_ACTY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_PIFH_DRCR_FLAG_LABEL() {
		return COMP_PIFH_DRCR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PIFH_DRCR_FLAG() {
		return COMP_PIFH_DRCR_FLAG;
	}

	public void setCOMP_PIFH_DRCR_FLAG_LABEL(
			HtmlOutputLabel COMP_PIFH_DRCR_FLAG_LABEL) {
		this.COMP_PIFH_DRCR_FLAG_LABEL = COMP_PIFH_DRCR_FLAG_LABEL;
	}

	public void setCOMP_PIFH_DRCR_FLAG(HtmlSelectOneMenu COMP_PIFH_DRCR_FLAG) {
		this.COMP_PIFH_DRCR_FLAG = COMP_PIFH_DRCR_FLAG;
	}

	public PM_IL_IF_ACCNT_SETUP_HDR getPM_IL_IF_ACCNT_SETUP_HDR_BEAN() {
		return PM_IL_IF_ACCNT_SETUP_HDR_BEAN;
	}

	public void setPM_IL_IF_ACCNT_SETUP_HDR_BEAN(
			PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) {
		this.PM_IL_IF_ACCNT_SETUP_HDR_BEAN = PM_IL_IF_ACCNT_SETUP_HDR_BEAN;
	}

	public void validatePIFH_FRZ_FLAG(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN
						.setPIFH_FRZ_FLAG(PELConstants.CHECKBOX_CHECKED);
			} else {
				PM_IL_IF_ACCNT_SETUP_HDR_BEAN
						.setPIFH_FRZ_FLAG(PELConstants.CHECKBOX_UNCHECKED);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Save the current instance record.
	 */
	public String saveRecord() {
		String message = null;

		try {
			if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
					new CRUDHandler().executeInsert(PM_IL_IF_ACCNT_SETUP_HDR_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$update");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("UPDATE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$updatenotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("UPDATE", message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					helper.preInsert(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
					
					new CRUDHandler().executeInsert(PM_IL_IF_ACCNT_SETUP_HDR_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$insertnotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("SAVE", message);
				}
			}


		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}finally{
			try{
				CommonUtils.getConnection().commit();
			}catch(Exception exception){exception.printStackTrace();}
		}

		return null;
	}

	

	/**
	 * @return the listPIFH_DRCR_FLAG
	 */
	public List<SelectItem> getListPIFH_DRCR_FLAG() {
		return listPIFH_DRCR_FLAG;
	}

	/**
	 * @param listPIFH_DRCR_FLAG the listPIFH_DRCR_FLAG to set
	 */
	public void setListPIFH_DRCR_FLAG(List<SelectItem> listPIFH_DRCR_FLAG) {
		this.listPIFH_DRCR_FLAG = listPIFH_DRCR_FLAG;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> mainAccountLov(Object event){
		suggestionList = new ArrayList<LovBean>();
	
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT  WHERE FM_MAIN_ACCOUNT.MAIN_FRZ_FLAG = 'N' AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT  WHERE FM_MAIN_ACCOUNT.MAIN_FRZ_FLAG = 'N' " +
							" AND MAIN_ACNT_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(rsSug1.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(rsSug1.getString(1));
				lovBean.setName(rsSug1.getString(2));
				suggestionList.add(lovBean);
			}
			CommonUtils.closeCursor(rsSug1);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Product Code Suggestion", e.getMessage());
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorMainAcctCode(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_MAIN_ACNT_CODE((String) value);
			helper.whenValidateMainAcctCode(this, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> subAccountLov(Object event){
		suggestionList = new ArrayList<LovBean>();
	
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT MS_SUB_ACNT_CODE,MS_SUB_ACNT_NAME FROM FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = ? AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT MS_SUB_ACNT_CODE,MS_SUB_ACNT_NAME FROM FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = ? " +
							" AND MS_SUB_ACNT_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SUB_ACNT_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection(),new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE()});
			while(rsSug1.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(rsSug1.getString(1));
				lovBean.setName(rsSug1.getString(2));
				suggestionList.add(lovBean);
			}
			CommonUtils.closeCursor(rsSug1);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Sub Account Code Suggestion", e.getMessage());
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorSubAcctCode(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_SUB_ACNT_CODE((String) value);
			helper.whenValidateSubAcctCode(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> divisionCodeLov(Object event){
		suggestionList = new ArrayList<LovBean>();
		ResultSet resultSet = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT DIVN_CODE,DIVN_NAME FROM FM_DIVISION WHERE NVL(DIVN_FRZ_FLAG,'N') != 'Y' AND DIVN_COMP_CODE= ? AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT DIVN_CODE,DIVN_NAME FROM FM_DIVISION WHERE NVL(DIVN_FRZ_FLAG,'N') != 'Y' AND DIVN_COMP_CODE= ? " +
							" AND DIVN_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			resultSet = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection(),new Object[]{CommonUtils.getControlBean().getM_COMP_CODE()});
			while(resultSet.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				suggestionList.add(lovBean);
			}
			
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Division Code Suggestion", e.getMessage());
			}finally{
				try{
					CommonUtils.closeCursor(resultSet);		
				}catch(Exception exception){
					exception.printStackTrace();
				}
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorDivisionCode(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_DIVN_CODE((String) value);
			helper.whenValidateDivisionCode(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> departmentCodeLov(Object event){
		suggestionList = new ArrayList<LovBean>();
		ResultSet resultSet = null;
		Object[] object = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT DEPT_CODE,DEPT_NAME FROM FM_DEPARTMENT WHERE NVL(DEPT_FRZ_FLAG,'N') != 'Y' AND DEPT_COMP_CODE = ? AND ((?) IS NULL OR DEPT_DIVN_CODE = NVL(?,DEPT_DIVN_CODE)) AND ROWNUM < 20 ORDER BY 1 ASC";
				object = new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(),PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(),PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE()};
			}else{
				suggestQuery="SELECT DEPT_CODE,DEPT_NAME FROM FM_DEPARTMENT WHERE NVL(DEPT_FRZ_FLAG,'N') != 'Y' AND DEPT_COMP_CODE = ? AND ((?) IS NULL OR DEPT_DIVN_CODE = NVL(?,DEPT_DIVN_CODE)) " +
							" AND DEPT_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DEPT_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
				object = new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(),PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(),PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(),PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DEPT_CODE()};
			}
			System.out.println(suggestQuery);
			resultSet = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection(),object);
			while(resultSet.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				suggestionList.add(lovBean);
			}
			
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Division Code Suggestion", e.getMessage());
			}finally{
				try{
					CommonUtils.closeCursor(resultSet);		
				}catch(Exception exception){
					exception.printStackTrace();
				}
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorDepartmentCode(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_DEPT_CODE((String) value);
			helper.whenValidateDeptCode(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> anlyCode_1Lov(Object event){
		suggestionList = new ArrayList<LovBean>();
		ResultSet resultSet = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE FM_ANALYSIS.ANLY_FRZ_FLAG = 'N' AND ANLY_HEAD_NO = '1'  AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE FM_ANALYSIS.ANLY_FRZ_FLAG = 'N' AND ANLY_HEAD_NO = '1' " +
							" AND ANLY_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			resultSet = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(resultSet.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				suggestionList.add(lovBean);
			}
			
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Division Code Suggestion", e.getMessage());
			}finally{
				try{
					CommonUtils.closeCursor(resultSet);		
				}catch(Exception exception){
					exception.printStackTrace();
				}
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorAnlyCode_1(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ANLY_CODE_1((String) value);
			helper.whenValidateAnlyCode_1(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> anlyCode_2Lov(Object event){
		suggestionList = new ArrayList<LovBean>();
		ResultSet resultSet = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE FM_ANALYSIS.ANLY_FRZ_FLAG = 'N' AND ANLY_HEAD_NO = '2'  AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE FM_ANALYSIS.ANLY_FRZ_FLAG = 'N' AND ANLY_HEAD_NO = '2' " +
							" AND ANLY_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			resultSet = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(resultSet.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				suggestionList.add(lovBean);
			}
			
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Division Code Suggestion", e.getMessage());
			}finally{
				try{
					CommonUtils.closeCursor(resultSet);		
				}catch(Exception exception){
					exception.printStackTrace();
				}
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorAnlyCode_2(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ANLY_CODE_2((String) value);
			helper.whenValidateAnlyCode_2(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> actyCode_1Lov(Object event){
		suggestionList = new ArrayList<LovBean>();
		ResultSet resultSet = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE FM_ACTY_VALUE.AVAL_FRZ_FLAG = 'N' AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE FM_ACTY_VALUE.AVAL_FRZ_FLAG = 'N' " +
							" AND AVAL_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_1() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			resultSet = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(resultSet.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				suggestionList.add(lovBean);
			}
			
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Activity Code Suggestion", e.getMessage());
			}finally{
				try{
					CommonUtils.closeCursor(resultSet);		
				}catch(Exception exception){
					exception.printStackTrace();
				}
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorActyCode_1(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ACTY_CODE_1((String) value);
			helper.whenValidateActyCode_1(PM_IL_IF_ACCNT_SETUP_HDR_BEAN,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 * @return
	 */
	public List<LovBean> actyCode_2Lov(Object event){
		suggestionList = new ArrayList<LovBean>();
		ResultSet resultSet = null;
		try {
			CRUDHandler handler = new CRUDHandler();
			String suggestQuery = null;
			if(event!=null && event.toString().equals("*")){
				suggestQuery="SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE FM_ACTY_VALUE.AVAL_FRZ_FLAG = 'N' AND ROWNUM < 20 ORDER BY 1 ASC";
			}else{
				suggestQuery="SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE FM_ACTY_VALUE.AVAL_FRZ_FLAG = 'N' " +
							" AND AVAL_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_2() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			resultSet = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection());
			while(resultSet.next()){
				LovBean lovBean = new LovBean();
				lovBean.setCode(resultSet.getString(1));
				lovBean.setName(resultSet.getString(2));
				suggestionList.add(lovBean);
			}
			
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Activity Code Suggestion", e.getMessage());
			}finally{
				try{
					CommonUtils.closeCursor(resultSet);		
				}catch(Exception exception){
					exception.printStackTrace();
				}
			}
			return suggestionList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorActyCode_2(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_IF_ACCNT_SETUP_HDR_BEAN.setPIFH_ACTY_CODE_2((String) value);
			helper.whenValidateActyCode_2(PM_IL_IF_ACCNT_SETUP_HDR_BEAN,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			
			if (isFormFlag()) {
				setFormFlag(false);
			}
				
			
			if (isBlockFlag()) {
				helper.preBlock(compositeAction.getCTRL_ACTION_BEAN()
						.getCTRL_BEAN());
				helper.executeQuery(compositeAction);
				if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getROWID() != null) {
					helper.postQuery(PM_IL_IF_ACCNT_SETUP_HDR_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				} else {
					helper.whenCreateRecord(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
				}
				helper.whenNewRecordInstance(this, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public String deleteRecord() {
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();
		setErrorMessages(null);
		try {
			if (isDELETE_ALLOWED()) {
				if (PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getROWID() != null) {
					helper.onCheckDeleteMaster(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
					helper.preDelete(PM_IL_IF_ACCNT_SETUP_HDR_BEAN);
					new CRUDHandler().executeDelete(PM_IL_IF_ACCNT_SETUP_HDR_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN = new PM_IL_IF_ACCNT_SETUP_HDR();
					message = Messages.getString("messageProperties",
							"errorPanel$message$delete");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							message);
					getWarningMap().put("DELETE", message);
				}

				
			} /*else {
				message = Messages.getString("messageProperties",
						"errorPanel$message$deletenotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getErrorMap().put("DELETE", message);
			}*/

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}

		return null;
	}

	public String backToSearch(){
		return  SearchConstants.BACK_TO_SEARCH_PAGE;
		
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception e) {
			
		}
		return connection;
	}

	/**
	 * @return the compositeAction
	 */
	public PILM072_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILM072_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	/**
	 * @return the helper
	 */
	public PM_IL_IF_ACCNT_SETUP_HDR_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PM_IL_IF_ACCNT_SETUP_HDR_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the suggestionList
	 */
	public List<LovBean> getSuggestionList() {
		return suggestionList;
	}

	/**
	 * @param suggestionList the suggestionList to set
	 */
	public void setSuggestionList(List<LovBean> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public HtmlGraphicImage getCOMP_PIFH_SUB_ACNT_IMG() {
		return COMP_PIFH_SUB_ACNT_IMG;
	}

	public void setCOMP_PIFH_SUB_ACNT_IMG(HtmlGraphicImage comp_pifh_sub_acnt_img) {
		COMP_PIFH_SUB_ACNT_IMG = comp_pifh_sub_acnt_img;
	}
}
