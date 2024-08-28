	package com.iii.pel.forms.PILM072_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_IF_ACCNT_SETUP_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PIFD_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_PIFD_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_PIFD_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_PIFD_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_PIFD_DRCR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PIFD_DRCR_FLAG;

	private HtmlOutputLabel COMP_PIFD_DIVN_CODE_LABEL;

	private HtmlInputText COMP_PIFD_DIVN_CODE;

	private HtmlOutputLabel COMP_PIFD_DEPT_CODE_LABEL;

	private HtmlInputText COMP_PIFD_DEPT_CODE;

	private HtmlOutputLabel COMP_PIFD_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_PIFD_ANLY_CODE_1;

	private HtmlOutputLabel COMP_PIFD_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_PIFD_ANLY_CODE_2;

	private HtmlOutputLabel COMP_PIFD_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_PIFD_ACTY_CODE_1;

	private HtmlOutputLabel COMP_PIFD_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_PIFD_ACTY_CODE_2;

	private HtmlOutputLabel COMP_PIFD_PS_CODE_LABEL;

	private HtmlInputText COMP_PIFD_PS_CODE;

	private HtmlOutputLabel COMP_UI_M_PIFD_ANLY_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PIFD_ANLY_CODE_1_DESC;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_PIFD_ANLY_CODE_2_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PIFD_ANLY_CODE_2_DESC;

	private HtmlOutputLabel COMP_UI_M_PIFD_ACTY_CODE_1_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PIFD_ACTY_CODE_1_DESC;

	private HtmlOutputLabel COMP_UI_M_PIFD_ACTY_CODE_2_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PIFD_ACTY_CODE_2_DESC;

	private PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN;

	public PILM072_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_IF_ACCNT_SETUP_DTL_HELPER helper;

	private List<PM_IL_IF_ACCNT_SETUP_DTL> dataList_PM_IL_IF_ACCNT_SETUP_DTL = new ArrayList<PM_IL_IF_ACCNT_SETUP_DTL>();

	 private UIData dataTable;

	private List<SelectItem> listPIFD_DRCR_FLAG = new ArrayList<SelectItem>();
	
	List<LovBean> suggestionList = null;



	public PM_IL_IF_ACCNT_SETUP_DTL_ACTION() {

		PM_IL_IF_ACCNT_SETUP_DTL_BEAN = new PM_IL_IF_ACCNT_SETUP_DTL();
		helper = new PM_IL_IF_ACCNT_SETUP_DTL_HELPER();
		instantiateAllComponent();
		setListPIFD_DRCR_FLAG(ListItemUtil.getDropDownListValue(
				getConnection(), "PILM072_APAC", "PM_IL_IF_ACCNT_SETUP_DTL",
				"PM_IL_IF_ACCNT_SETUP_DTL.PIFD_DRCR_FLAG", "C/D"));
	}
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
		} catch (Exception e) {
			
		}
		return connection;
	}

	public HtmlOutputLabel getCOMP_PIFD_MAIN_ACNT_CODE_LABEL() {
		return COMP_PIFD_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_MAIN_ACNT_CODE() {
		return COMP_PIFD_MAIN_ACNT_CODE;
	}

	public void setCOMP_PIFD_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_PIFD_MAIN_ACNT_CODE_LABEL) {
		this.COMP_PIFD_MAIN_ACNT_CODE_LABEL = COMP_PIFD_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_PIFD_MAIN_ACNT_CODE(HtmlInputText COMP_PIFD_MAIN_ACNT_CODE) {
		this.COMP_PIFD_MAIN_ACNT_CODE = COMP_PIFD_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_PIFD_SUB_ACNT_CODE_LABEL() {
		return COMP_PIFD_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_SUB_ACNT_CODE() {
		return COMP_PIFD_SUB_ACNT_CODE;
	}

	public void setCOMP_PIFD_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_PIFD_SUB_ACNT_CODE_LABEL) {
		this.COMP_PIFD_SUB_ACNT_CODE_LABEL = COMP_PIFD_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_PIFD_SUB_ACNT_CODE(HtmlInputText COMP_PIFD_SUB_ACNT_CODE) {
		this.COMP_PIFD_SUB_ACNT_CODE = COMP_PIFD_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_PIFD_DRCR_FLAG_LABEL() {
		return COMP_PIFD_DRCR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PIFD_DRCR_FLAG() {
		return COMP_PIFD_DRCR_FLAG;
	}

	public void setCOMP_PIFD_DRCR_FLAG_LABEL(HtmlOutputLabel COMP_PIFD_DRCR_FLAG_LABEL) {
		this.COMP_PIFD_DRCR_FLAG_LABEL = COMP_PIFD_DRCR_FLAG_LABEL;
	}

	public void setCOMP_PIFD_DRCR_FLAG(HtmlSelectOneMenu COMP_PIFD_DRCR_FLAG) {
		this.COMP_PIFD_DRCR_FLAG = COMP_PIFD_DRCR_FLAG;
	}

	public HtmlOutputLabel getCOMP_PIFD_DIVN_CODE_LABEL() {
		return COMP_PIFD_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_DIVN_CODE() {
		return COMP_PIFD_DIVN_CODE;
	}

	public void setCOMP_PIFD_DIVN_CODE_LABEL(HtmlOutputLabel COMP_PIFD_DIVN_CODE_LABEL) {
		this.COMP_PIFD_DIVN_CODE_LABEL = COMP_PIFD_DIVN_CODE_LABEL;
	}

	public void setCOMP_PIFD_DIVN_CODE(HtmlInputText COMP_PIFD_DIVN_CODE) {
		this.COMP_PIFD_DIVN_CODE = COMP_PIFD_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_PIFD_DEPT_CODE_LABEL() {
		return COMP_PIFD_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_DEPT_CODE() {
		return COMP_PIFD_DEPT_CODE;
	}

	public void setCOMP_PIFD_DEPT_CODE_LABEL(HtmlOutputLabel COMP_PIFD_DEPT_CODE_LABEL) {
		this.COMP_PIFD_DEPT_CODE_LABEL = COMP_PIFD_DEPT_CODE_LABEL;
	}

	public void setCOMP_PIFD_DEPT_CODE(HtmlInputText COMP_PIFD_DEPT_CODE) {
		this.COMP_PIFD_DEPT_CODE = COMP_PIFD_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_PIFD_ANLY_CODE_1_LABEL() {
		return COMP_PIFD_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_ANLY_CODE_1() {
		return COMP_PIFD_ANLY_CODE_1;
	}

	public void setCOMP_PIFD_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_PIFD_ANLY_CODE_1_LABEL) {
		this.COMP_PIFD_ANLY_CODE_1_LABEL = COMP_PIFD_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_PIFD_ANLY_CODE_1(HtmlInputText COMP_PIFD_ANLY_CODE_1) {
		this.COMP_PIFD_ANLY_CODE_1 = COMP_PIFD_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_PIFD_ANLY_CODE_2_LABEL() {
		return COMP_PIFD_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_ANLY_CODE_2() {
		return COMP_PIFD_ANLY_CODE_2;
	}

	public void setCOMP_PIFD_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_PIFD_ANLY_CODE_2_LABEL) {
		this.COMP_PIFD_ANLY_CODE_2_LABEL = COMP_PIFD_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_PIFD_ANLY_CODE_2(HtmlInputText COMP_PIFD_ANLY_CODE_2) {
		this.COMP_PIFD_ANLY_CODE_2 = COMP_PIFD_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_PIFD_ACTY_CODE_1_LABEL() {
		return COMP_PIFD_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_ACTY_CODE_1() {
		return COMP_PIFD_ACTY_CODE_1;
	}

	public void setCOMP_PIFD_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_PIFD_ACTY_CODE_1_LABEL) {
		this.COMP_PIFD_ACTY_CODE_1_LABEL = COMP_PIFD_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_PIFD_ACTY_CODE_1(HtmlInputText COMP_PIFD_ACTY_CODE_1) {
		this.COMP_PIFD_ACTY_CODE_1 = COMP_PIFD_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_PIFD_ACTY_CODE_2_LABEL() {
		return COMP_PIFD_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_ACTY_CODE_2() {
		return COMP_PIFD_ACTY_CODE_2;
	}

	public void setCOMP_PIFD_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_PIFD_ACTY_CODE_2_LABEL) {
		this.COMP_PIFD_ACTY_CODE_2_LABEL = COMP_PIFD_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_PIFD_ACTY_CODE_2(HtmlInputText COMP_PIFD_ACTY_CODE_2) {
		this.COMP_PIFD_ACTY_CODE_2 = COMP_PIFD_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_PIFD_PS_CODE_LABEL() {
		return COMP_PIFD_PS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PIFD_PS_CODE() {
		return COMP_PIFD_PS_CODE;
	}

	public void setCOMP_PIFD_PS_CODE_LABEL(HtmlOutputLabel COMP_PIFD_PS_CODE_LABEL) {
		this.COMP_PIFD_PS_CODE_LABEL = COMP_PIFD_PS_CODE_LABEL;
	}

	public void setCOMP_PIFD_PS_CODE(HtmlInputText COMP_PIFD_PS_CODE) {
		this.COMP_PIFD_PS_CODE = COMP_PIFD_PS_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PIFD_ANLY_CODE_1_DESC_LABEL() {
		return COMP_UI_M_PIFD_ANLY_CODE_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PIFD_ANLY_CODE_1_DESC() {
		return COMP_UI_M_PIFD_ANLY_CODE_1_DESC;
	}

	public void setCOMP_UI_M_PIFD_ANLY_CODE_1_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PIFD_ANLY_CODE_1_DESC_LABEL) {
		this.COMP_UI_M_PIFD_ANLY_CODE_1_DESC_LABEL = COMP_UI_M_PIFD_ANLY_CODE_1_DESC_LABEL;
	}

	public void setCOMP_UI_M_PIFD_ANLY_CODE_1_DESC(HtmlInputText COMP_UI_M_PIFD_ANLY_CODE_1_DESC) {
		this.COMP_UI_M_PIFD_ANLY_CODE_1_DESC = COMP_UI_M_PIFD_ANLY_CODE_1_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL() {
		return COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_CODE_DESC() {
		return COMP_UI_M_MAIN_ACNT_CODE_DESC;
	}

	public void setCOMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL = COMP_UI_M_MAIN_ACNT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_CODE_DESC(HtmlInputText COMP_UI_M_MAIN_ACNT_CODE_DESC) {
		this.COMP_UI_M_MAIN_ACNT_CODE_DESC = COMP_UI_M_MAIN_ACNT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_CODE_DESC_LABEL() {
		return COMP_UI_M_SUB_ACNT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_CODE_DESC() {
		return COMP_UI_M_SUB_ACNT_CODE_DESC;
	}

	public void setCOMP_UI_M_SUB_ACNT_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_SUB_ACNT_CODE_DESC_LABEL) {
		this.COMP_UI_M_SUB_ACNT_CODE_DESC_LABEL = COMP_UI_M_SUB_ACNT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_CODE_DESC(HtmlInputText COMP_UI_M_SUB_ACNT_CODE_DESC) {
		this.COMP_UI_M_SUB_ACNT_CODE_DESC = COMP_UI_M_SUB_ACNT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PIFD_ANLY_CODE_2_DESC_LABEL() {
		return COMP_UI_M_PIFD_ANLY_CODE_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PIFD_ANLY_CODE_2_DESC() {
		return COMP_UI_M_PIFD_ANLY_CODE_2_DESC;
	}

	public void setCOMP_UI_M_PIFD_ANLY_CODE_2_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PIFD_ANLY_CODE_2_DESC_LABEL) {
		this.COMP_UI_M_PIFD_ANLY_CODE_2_DESC_LABEL = COMP_UI_M_PIFD_ANLY_CODE_2_DESC_LABEL;
	}

	public void setCOMP_UI_M_PIFD_ANLY_CODE_2_DESC(HtmlInputText COMP_UI_M_PIFD_ANLY_CODE_2_DESC) {
		this.COMP_UI_M_PIFD_ANLY_CODE_2_DESC = COMP_UI_M_PIFD_ANLY_CODE_2_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PIFD_ACTY_CODE_1_DESC_LABEL() {
		return COMP_UI_M_PIFD_ACTY_CODE_1_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PIFD_ACTY_CODE_1_DESC() {
		return COMP_UI_M_PIFD_ACTY_CODE_1_DESC;
	}

	public void setCOMP_UI_M_PIFD_ACTY_CODE_1_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PIFD_ACTY_CODE_1_DESC_LABEL) {
		this.COMP_UI_M_PIFD_ACTY_CODE_1_DESC_LABEL = COMP_UI_M_PIFD_ACTY_CODE_1_DESC_LABEL;
	}

	public void setCOMP_UI_M_PIFD_ACTY_CODE_1_DESC(HtmlInputText COMP_UI_M_PIFD_ACTY_CODE_1_DESC) {
		this.COMP_UI_M_PIFD_ACTY_CODE_1_DESC = COMP_UI_M_PIFD_ACTY_CODE_1_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_PIFD_ACTY_CODE_2_DESC_LABEL() {
		return COMP_UI_M_PIFD_ACTY_CODE_2_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PIFD_ACTY_CODE_2_DESC() {
		return COMP_UI_M_PIFD_ACTY_CODE_2_DESC;
	}

	public void setCOMP_UI_M_PIFD_ACTY_CODE_2_DESC_LABEL(HtmlOutputLabel COMP_UI_M_PIFD_ACTY_CODE_2_DESC_LABEL) {
		this.COMP_UI_M_PIFD_ACTY_CODE_2_DESC_LABEL = COMP_UI_M_PIFD_ACTY_CODE_2_DESC_LABEL;
	}

	public void setCOMP_UI_M_PIFD_ACTY_CODE_2_DESC(HtmlInputText COMP_UI_M_PIFD_ACTY_CODE_2_DESC) {
		this.COMP_UI_M_PIFD_ACTY_CODE_2_DESC = COMP_UI_M_PIFD_ACTY_CODE_2_DESC;
	}

	public PM_IL_IF_ACCNT_SETUP_DTL getPM_IL_IF_ACCNT_SETUP_DTL_BEAN() {
		return PM_IL_IF_ACCNT_SETUP_DTL_BEAN;
	}

	public void setPM_IL_IF_ACCNT_SETUP_DTL_BEAN(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN) {
		this.PM_IL_IF_ACCNT_SETUP_DTL_BEAN = PM_IL_IF_ACCNT_SETUP_DTL_BEAN;
	}

	public List<PM_IL_IF_ACCNT_SETUP_DTL> getDataList_PM_IL_IF_ACCNT_SETUP_DTL() {
		return dataList_PM_IL_IF_ACCNT_SETUP_DTL;
	}

	public void setDataListPM_IL_IF_ACCNT_SETUP_DTL(List<PM_IL_IF_ACCNT_SETUP_DTL> dataList_PM_IL_IF_ACCNT_SETUP_DTL) {
		this.dataList_PM_IL_IF_ACCNT_SETUP_DTL = dataList_PM_IL_IF_ACCNT_SETUP_DTL;
	}
		/**
		 * 
		 * @param event
		 */
		public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_IF_ACCNT_SETUP_DTL_BEAN = new PM_IL_IF_ACCNT_SETUP_DTL();
				resetAllComponent();
				resetSelectedRow();
			} else {

				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

		/**
		 * 
		 */
	public void saveRecord() {
		String message = null;
		try {
			if (PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					CommonUtils.getConnection().commit();
					message = Messages.getString("messageProperties",
							"errorPanel$message$update");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
							getWarningMap().put("UPDATE", message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
				}
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}


	public List<SelectItem> getListPIFD_DRCR_FLAG() {
		if (listPIFD_DRCR_FLAG.size() == 0) {
			listPIFD_DRCR_FLAG.clear();
			try {
				listPIFD_DRCR_FLAG = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPIFD_DRCR_FLAG;
	}

	public void setListPIFD_DRCR_FLAG(List<SelectItem> listPIFD_DRCR_FLAG) {
		this.listPIFD_DRCR_FLAG = listPIFD_DRCR_FLAG;
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
							" AND MAIN_ACNT_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_MAIN_ACNT_CODE((String) value);
			helper.whenValidateMainAcctCode(this, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
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
							" AND MS_SUB_ACNT_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_SUB_ACNT_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
			}
			System.out.println(suggestQuery);
			ResultSet rsSug1 = handler.executeSelectStatement(suggestQuery, CommonUtils.getConnection(),new Object[]{PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE()});
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_SUB_ACNT_CODE((String) value);
			helper.whenValidateSubAcctCode(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
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
							" AND DIVN_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_DIVN_CODE((String) value);
			helper.whenValidateDivisionCode(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
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
				object = new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(),PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(),PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE()};
			}else{
				suggestQuery="SELECT DEPT_CODE,DEPT_NAME FROM FM_DEPARTMENT WHERE NVL(DEPT_FRZ_FLAG,'N') != 'Y' AND DEPT_COMP_CODE = ? AND ((?) IS NULL OR DEPT_DIVN_CODE = NVL(?,DEPT_DIVN_CODE)) " +
							" AND DEPT_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DEPT_CODE() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
				object = new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(),PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(),PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(),PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DEPT_CODE()};
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_DEPT_CODE((String) value);
			helper.whenValidateDeptCode(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
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
							" AND ANLY_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ANLY_CODE_1((String) value);
			helper.whenValidateAnlyCode_1(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
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
							" AND ANLY_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ANLY_CODE_2((String) value);
			helper.whenValidateAnlyCode_2(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
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
							" AND AVAL_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_1() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ACTY_CODE_1((String) value);
			helper.whenValidateActyCode_1(PM_IL_IF_ACCNT_SETUP_DTL_BEAN,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
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
							" AND AVAL_CODE LIKE '%"+PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_2() +"%' AND ROWNUM < 20 ORDER BY 1 ASC";
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
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setPIFD_ACTY_CODE_2((String) value);
			helper.whenValidateActyCode_2(PM_IL_IF_ACCNT_SETUP_DTL_BEAN,compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
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
				helper.executeQuery(compositeAction);
				if (PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getROWID() != null) {
					helper.postQuery(PM_IL_IF_ACCNT_SETUP_DTL_BEAN, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				} else {
					helper.whenCreateRecord(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
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
	
	/**
	 * 
	 * @param event
	 */
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				int i = new CRUDHandler().executeDelete(PM_IL_IF_ACCNT_SETUP_DTL_BEAN,
						CommonUtils.getConnection());
				if(i==1){
					CommonUtils.getConnection().commit();
					getWarningMap().put(
							"deleteRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
					dataList_PM_IL_IF_ACCNT_SETUP_DTL.remove(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
				}
				if (dataList_PM_IL_IF_ACCNT_SETUP_DTL.size() > 0) {

					PM_IL_IF_ACCNT_SETUP_DTL_BEAN = dataList_PM_IL_IF_ACCNT_SETUP_DTL
							.get(0);
				} else if (dataList_PM_IL_IF_ACCNT_SETUP_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	
	public void postRecord(ActionEvent event) {
		try {
			setValues();
			if (PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getROWID() == null) {
				if (isINSERT_ALLOWED()) {
					if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE()!=null 
							|| !"".equalsIgnoreCase(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE())){
						helper.preInsert(PM_IL_IF_ACCNT_SETUP_DTL_BEAN,
								compositeAction
										.getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN()
										.getPM_IL_IF_ACCNT_SETUP_HDR_BEAN());
						
						new CRUDHandler().executeInsert(
								PM_IL_IF_ACCNT_SETUP_DTL_BEAN, CommonUtils
										.getConnection());
						getWarningMap().put(
								PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insert"));
						getWarningMap().put(
								"postRecord",
								Messages.getString(
										PELConstants.pelMessagePropertiesPath,
										"errorPanel$message$insert"));
						dataList_PM_IL_IF_ACCNT_SETUP_DTL
								.add(PM_IL_IF_ACCNT_SETUP_DTL_BEAN);
						
					}
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}

			} else if (PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.preUpdate(PM_IL_IF_ACCNT_SETUP_DTL_BEAN,
							compositeAction
									.getPM_IL_IF_ACCNT_SETUP_HDR_ACTION_BEAN()
									.getPM_IL_IF_ACCNT_SETUP_HDR_BEAN());
					new CRUDHandler().executeUpdate(
							PM_IL_IF_ACCNT_SETUP_DTL_BEAN, CommonUtils
									.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"postRecord",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$Grid$update"));
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			}
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	/**
	 * 
	 */
	private void setValues() {
		if (PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DRCR_FLAG() == null) {
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN
					.setPIFD_DRCR_FLAG(COMP_PIFD_DRCR_FLAG
							.getSubmittedValue() != null ? COMP_PIFD_DRCR_FLAG
							.getSubmittedValue().toString()
							: "");
		}
		if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_2()==null){
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN
			.setPIFD_ACTY_CODE_2(COMP_PIFD_ACTY_CODE_2
					.getSubmittedValue() != null ? COMP_PIFD_ACTY_CODE_2
					.getSubmittedValue().toString()
					: "");
		}
		
		if(PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_PS_CODE()==null){
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN
			.setPIFD_PS_CODE(COMP_PIFD_PS_CODE
					.getSubmittedValue() != null ? COMP_PIFD_PS_CODE
					.getSubmittedValue().toString()
					: "");
		}
	}
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN = (PM_IL_IF_ACCNT_SETUP_DTL) dataTable
					.getRowData();
			PM_IL_IF_ACCNT_SETUP_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	private void resetSelectedRow() {
		Iterator<PM_IL_IF_ACCNT_SETUP_DTL> PM_IL_IF_ACCNT_SETUP_DTL_ITR = dataList_PM_IL_IF_ACCNT_SETUP_DTL
				.iterator();
		while (PM_IL_IF_ACCNT_SETUP_DTL_ITR.hasNext()) {
			PM_IL_IF_ACCNT_SETUP_DTL_ITR.next().setRowSelected(false);
		}
	}


	/**
	 * Instantiates all components in PM_IL_IF_ACCNT_SETUP_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PIFD_MAIN_ACNT_CODE			 = new HtmlInputText();
		COMP_PIFD_SUB_ACNT_CODE				 = new HtmlInputText();
		COMP_PIFD_DIVN_CODE				 = new HtmlInputText();
		COMP_PIFD_DEPT_CODE				 = new HtmlInputText();
		COMP_PIFD_ANLY_CODE_1				 = new HtmlInputText();
		COMP_PIFD_ANLY_CODE_2				 = new HtmlInputText();
		COMP_PIFD_ACTY_CODE_1				 = new HtmlInputText();
		COMP_PIFD_ACTY_CODE_2				 = new HtmlInputText();
		COMP_PIFD_PS_CODE				 = new HtmlInputText();
		COMP_UI_M_PIFD_ANLY_CODE_1_DESC			 = new HtmlInputText();
		COMP_UI_M_MAIN_ACNT_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_SUB_ACNT_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_PIFD_ANLY_CODE_2_DESC			 = new HtmlInputText();
		COMP_UI_M_PIFD_ACTY_CODE_1_DESC			 = new HtmlInputText();
		COMP_UI_M_PIFD_ACTY_CODE_2_DESC			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_PIFD_DRCR_FLAG				 = new HtmlSelectOneMenu();

	}
	

	/**
	 * Resets all components in PM_IL_IF_ACCNT_SETUP_DTL_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PIFD_MAIN_ACNT_CODE.resetValue();
		COMP_PIFD_SUB_ACNT_CODE.resetValue();
		COMP_PIFD_DIVN_CODE.resetValue();
		COMP_PIFD_DEPT_CODE.resetValue();
		COMP_PIFD_ANLY_CODE_1.resetValue();
		COMP_PIFD_ANLY_CODE_2.resetValue();
		COMP_PIFD_ACTY_CODE_1.resetValue();
		COMP_PIFD_ACTY_CODE_2.resetValue();
		COMP_PIFD_PS_CODE.resetValue();
		COMP_UI_M_PIFD_ANLY_CODE_1_DESC.resetValue();
		COMP_UI_M_MAIN_ACNT_CODE_DESC.resetValue();
		COMP_UI_M_SUB_ACNT_CODE_DESC.resetValue();
		COMP_UI_M_PIFD_ANLY_CODE_2_DESC.resetValue();
		COMP_UI_M_PIFD_ACTY_CODE_1_DESC.resetValue();
		COMP_UI_M_PIFD_ACTY_CODE_2_DESC.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_PIFD_DRCR_FLAG.resetValue();

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
	public PM_IL_IF_ACCNT_SETUP_DTL_HELPER getHelper() {
		return helper;
	}

	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PM_IL_IF_ACCNT_SETUP_DTL_HELPER helper) {
		this.helper = helper;
	}

	/**
	 * @return the dataTable
	 */
	public UIData getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable the dataTable to set
	 */
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
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

	/**
	 * @param dataList_PM_IL_IF_ACCNT_SETUP_DTL the dataList_PM_IL_IF_ACCNT_SETUP_DTL to set
	 */
	public void setDataList_PM_IL_IF_ACCNT_SETUP_DTL(
			List<PM_IL_IF_ACCNT_SETUP_DTL> dataList_PM_IL_IF_ACCNT_SETUP_DTL) {
		this.dataList_PM_IL_IF_ACCNT_SETUP_DTL = dataList_PM_IL_IF_ACCNT_SETUP_DTL;
	}




}
