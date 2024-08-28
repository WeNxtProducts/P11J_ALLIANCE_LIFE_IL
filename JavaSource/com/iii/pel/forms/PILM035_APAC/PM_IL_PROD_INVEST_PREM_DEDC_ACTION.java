package com.iii.pel.forms.PILM035_APAC;

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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_INVEST_PREM_DEDC_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PIPD_SRNO_LABEL;
	private HtmlInputText COMP_PIPD_SRNO;
	private HtmlOutputLabel COMP_PIPD_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_PIPD_TYPE;
	private HtmlOutputLabel COMP_PIPD_CODE_LABEL;
	private HtmlInputText COMP_PIPD_CODE;
	private HtmlInputText COMP_UI_M_PIPD_CODE_DESC;
	private HtmlOutputLabel COMP_PIPD_INCL_PREM_YN_LABEL;
	private HtmlSelectOneMenu COMP_PIPD_INCL_PREM_YN;
	private HtmlOutputLabel COMP_PIPD_DEDC_YN_LABEL;
	private HtmlSelectOneMenu COMP_PIPD_DEDC_YN;

	private PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PROD_INVEST_PREM_DEDC_HELPER helper;

	private List<PM_IL_PROD_INVEST_PREM_DEDC> dataList_PM_IL_PROD_INVEST_PREM_DEDC = new ArrayList<PM_IL_PROD_INVEST_PREM_DEDC>();

	private List<SelectItem> listPIPD_TYPE = new ArrayList<SelectItem>();
	private List<SelectItem> listPIPD_INCL_PREM_YN = new ArrayList<SelectItem>();
	private List<SelectItem> listPIPD_DEDC_YN = new ArrayList<SelectItem>();

	private UIData dataTable;

	public PM_IL_PROD_INVEST_PREM_DEDC_ACTION() {

		PM_IL_PROD_INVEST_PREM_DEDC_BEAN = new PM_IL_PROD_INVEST_PREM_DEDC();
		helper = new PM_IL_PROD_INVEST_PREM_DEDC_HELPER();
		instantiateAllComponent();

		List<SelectItem> listValues = new ArrayList<SelectItem>();
		listValues.add(new SelectItem("Y", "Yes"));
		listValues.add(new SelectItem("N", "No"));
		setListPIPD_INCL_PREM_YN(listValues);
		setListPIPD_DEDC_YN(listValues);

		try {
			setlistPIPD_TYPE(ListItemUtil.getDropDownListValue_1(CommonUtils
					.getConnection(), "PILM035",
					"PM_IL_PROD_INVEST_PREM_DEDC",
					"PM_IL_PROD_INVEST_PREM_DEDC.PIPD_TYPE", "IL_DEDC_TYP"));
		} catch (DBException e) {
			e.printStackTrace();
		}

	}

	public PM_IL_PROD_INVEST_PREM_DEDC getPM_IL_PROD_INVEST_PREM_DEDC_BEAN() {
		return PM_IL_PROD_INVEST_PREM_DEDC_BEAN;
	}

	public void setPM_IL_PROD_INVEST_PREM_DEDC_BEAN(
			PM_IL_PROD_INVEST_PREM_DEDC PM_IL_PROD_INVEST_PREM_DEDC_BEAN) {
		this.PM_IL_PROD_INVEST_PREM_DEDC_BEAN = PM_IL_PROD_INVEST_PREM_DEDC_BEAN;
	}

	public List<PM_IL_PROD_INVEST_PREM_DEDC> getDataList_PM_IL_PROD_INVEST_PREM_DEDC() {
		return dataList_PM_IL_PROD_INVEST_PREM_DEDC;
	}

	public void setDataListPM_IL_PROD_INVEST_PREM_DEDC(
			List<PM_IL_PROD_INVEST_PREM_DEDC> dataList_PM_IL_PROD_INVEST_PREM_DEDC) {
		this.dataList_PM_IL_PROD_INVEST_PREM_DEDC = dataList_PM_IL_PROD_INVEST_PREM_DEDC;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN = new PM_IL_PROD_INVEST_PREM_DEDC();
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(
						PM_IL_PROD_INVEST_PREM_DEDC_BEAN, CommonUtils
								.getConnection());
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
				dataList_PM_IL_PROD_INVEST_PREM_DEDC
						.remove(PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
				if (dataList_PM_IL_PROD_INVEST_PREM_DEDC.size() > 0) {

					PM_IL_PROD_INVEST_PREM_DEDC_BEAN = dataList_PM_IL_PROD_INVEST_PREM_DEDC
							.get(0);
				} else if (dataList_PM_IL_PROD_INVEST_PREM_DEDC.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setRowSelected(true);
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
			if (PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(
						PM_IL_PROD_INVEST_PREM_DEDC_BEAN, CommonUtils
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
								"errorPanel$message$save"));

				dataList_PM_IL_PROD_INVEST_PREM_DEDC
						.add(PM_IL_PROD_INVEST_PREM_DEDC_BEAN);

			} else if (PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(
						PM_IL_PROD_INVEST_PREM_DEDC_BEAN, CommonUtils
								.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}
				
			PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_INVEST_PREM_DEDC_BEAN = (PM_IL_PROD_INVEST_PREM_DEDC) dataTable
					.getRowData();
			PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setRowSelected(true);
			
			/*changed by raja on 30-05-2017 for ZBILQC-1726955 */
			/*helper.POST_QUERY(compositeAction);*/
			helper.POST_QUERY(PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
			/*end*/
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	

	/**
	 * Disables all components in PM_IL_PROD_INVEST_PREM_DEDC_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PIPD_SRNO.setDisabled(disabled);
		COMP_PIPD_CODE.setDisabled(disabled);
		COMP_UI_M_PIPD_CODE_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_PIPD_TYPE.setDisabled(disabled);
		COMP_PIPD_INCL_PREM_YN.setDisabled(disabled);
		COMP_PIPD_DEDC_YN.setDisabled(disabled);

	}



	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_INVEST_PREM_DEDC> PM_IL_PROD_INVEST_PREM_DEDC_ITR = dataList_PM_IL_PROD_INVEST_PREM_DEDC
				.iterator();
		while (PM_IL_PROD_INVEST_PREM_DEDC_ITR.hasNext()) {
			PM_IL_PROD_INVEST_PREM_DEDC_ITR.next().setRowSelected(false);
		}
	}


	/**
	 * Resets all components in PM_IL_PROD_INVEST_PREM_DEDC_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PIPD_SRNO.resetValue();
		COMP_PIPD_CODE.resetValue();
		COMP_UI_M_PIPD_CODE_DESC.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_PIPD_TYPE.resetValue();
		COMP_PIPD_INCL_PREM_YN.resetValue();
		COMP_PIPD_DEDC_YN.resetValue();

	}
	

	/**
	 * Instantiates all components in PM_IL_PROD_INVEST_PREM_DEDC_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PIPD_SRNO					 = new HtmlInputText();
		COMP_PIPD_CODE					 = new HtmlInputText();
		COMP_UI_M_PIPD_CODE_DESC			 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_PIPD_TYPE					 = new HtmlSelectOneMenu();
		COMP_PIPD_INCL_PREM_YN				 = new HtmlSelectOneMenu();
		COMP_PIPD_DEDC_YN				 = new HtmlSelectOneMenu();

	}

	public void PIPD_SRNO_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		Integer currValue = (Integer)value;
		PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_SRNO(currValue);
		try {
			/*helper
					.cbenBankCodeWhenValidateItem((String) value,
							compositeAction);*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}



	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));

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

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				helper.executeQuery(compositeAction);
				if (PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getROWID() != null) {
					/*changed by raja on 30-05-2017 for ZBILQC-1726955 */
					/*helper.POST_QUERY(compositeAction);*/
					helper.POST_QUERY(PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
					/*end*/
				} else {
					helper.whenCreateRecord(PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
				}
				helper.whenNewRecordInstance(this);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


	public String navigationEnabled() {
		getErrorMap().clear();
		return "";

	}

	public List<SelectItem> getlistPIPD_TYPE() {
		if (listPIPD_TYPE.size() == 0) {
			listPIPD_TYPE.clear();
			try {
				listPIPD_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPIPD_TYPE;
	}

	public void setlistPIPD_TYPE(List<SelectItem> listPIPD_TYPE) {
		this.listPIPD_TYPE = listPIPD_TYPE;
	}

	public HtmlInputText getCOMP_PIPD_CODE() {
		return COMP_PIPD_CODE;
	}

	public void setCOMP_PIPD_CODE(HtmlInputText comp_pipd_code) {
		COMP_PIPD_CODE = comp_pipd_code;
	}

	public HtmlOutputLabel getCOMP_PIPD_SRNO_LABEL() {
		return COMP_PIPD_SRNO_LABEL;
	}

	public void setCOMP_PIPD_SRNO_LABEL(HtmlOutputLabel comp_pipd_srno_label) {
		COMP_PIPD_SRNO_LABEL = comp_pipd_srno_label;
	}

	public HtmlInputText getCOMP_PIPD_SRNO() {
		return COMP_PIPD_SRNO;
	}

	public void setCOMP_PIPD_SRNO(HtmlInputText comp_pipd_srno) {
		COMP_PIPD_SRNO = comp_pipd_srno;
	}

	public HtmlOutputLabel getCOMP_PIPD_TYPE_LABEL() {
		return COMP_PIPD_TYPE_LABEL;
	}

	public void setCOMP_PIPD_TYPE_LABEL(HtmlOutputLabel comp_pipd_type_label) {
		COMP_PIPD_TYPE_LABEL = comp_pipd_type_label;
	}

	public HtmlSelectOneMenu getCOMP_PIPD_TYPE() {
		return COMP_PIPD_TYPE;
	}

	public void setCOMP_PIPD_TYPE(HtmlSelectOneMenu comp_pipd_type) {
		COMP_PIPD_TYPE = comp_pipd_type;
	}

	public HtmlOutputLabel getCOMP_PIPD_CODE_LABEL() {
		return COMP_PIPD_CODE_LABEL;
	}

	public void setCOMP_PIPD_CODE_LABEL(HtmlOutputLabel comp_pipd_code_label) {
		COMP_PIPD_CODE_LABEL = comp_pipd_code_label;
	}

	public HtmlInputText getCOMP_UI_M_PIPD_CODE_DESC() {
		return COMP_UI_M_PIPD_CODE_DESC;
	}

	public void setCOMP_UI_M_PIPD_CODE_DESC(
			HtmlInputText comp_ui_m_pipd_code_desc) {
		COMP_UI_M_PIPD_CODE_DESC = comp_ui_m_pipd_code_desc;
	}

	public HtmlOutputLabel getCOMP_PIPD_INCL_PREM_YN_LABEL() {
		return COMP_PIPD_INCL_PREM_YN_LABEL;
	}

	public void setCOMP_PIPD_INCL_PREM_YN_LABEL(
			HtmlOutputLabel comp_pipd_incl_prem_yn_label) {
		COMP_PIPD_INCL_PREM_YN_LABEL = comp_pipd_incl_prem_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_PIPD_INCL_PREM_YN() {
		return COMP_PIPD_INCL_PREM_YN;
	}

	public void setCOMP_PIPD_INCL_PREM_YN(
			HtmlSelectOneMenu comp_pipd_incl_prem_yn) {
		COMP_PIPD_INCL_PREM_YN = comp_pipd_incl_prem_yn;
	}

	public HtmlOutputLabel getCOMP_PIPD_DEDC_YN_LABEL() {
		return COMP_PIPD_DEDC_YN_LABEL;
	}

	public void setCOMP_PIPD_DEDC_YN_LABEL(
			HtmlOutputLabel comp_pipd_dedc_yn_label) {
		COMP_PIPD_DEDC_YN_LABEL = comp_pipd_dedc_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_PIPD_DEDC_YN() {
		return COMP_PIPD_DEDC_YN;
	}

	public void setCOMP_PIPD_DEDC_YN(HtmlSelectOneMenu comp_pipd_dedc_yn) {
		COMP_PIPD_DEDC_YN = comp_pipd_dedc_yn;
	}

	public List<SelectItem> getListPIPD_TYPE() {
		return listPIPD_TYPE;
	}

	public void setListPIPD_TYPE(List<SelectItem> listPIPD_TYPE) {
		this.listPIPD_TYPE = listPIPD_TYPE;
	}

	public void setDataList_PM_IL_PROD_INVEST_PREM_DEDC(
			List<PM_IL_PROD_INVEST_PREM_DEDC> dataList_PM_IL_PROD_INVEST_PREM_DEDC) {
		this.dataList_PM_IL_PROD_INVEST_PREM_DEDC = dataList_PM_IL_PROD_INVEST_PREM_DEDC;
	}

	public List<SelectItem> getListPIPD_INCL_PREM_YN() {
		return listPIPD_INCL_PREM_YN;
	}

	public void setListPIPD_INCL_PREM_YN(List<SelectItem> listPIPD_INCL_PREM_YN) {
		this.listPIPD_INCL_PREM_YN = listPIPD_INCL_PREM_YN;
	}

	public List<SelectItem> getListPIPD_DEDC_YN() {
		return listPIPD_DEDC_YN;
	}

	public void setListPIPD_DEDC_YN(List<SelectItem> listPIPD_DEDC_YN) {
		this.listPIPD_DEDC_YN = listPIPD_DEDC_YN;
	}
	
	public List<LovBean> lovUI_M_PIPD_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		
		
		
		if ("*".equals(code)) {
			object = new Object[] {
					PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE(),
					PELConstants.suggetionRecordSize,
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_PLAN_CODE(),
					PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE(),
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_PLAN_CODE(),
					PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE()
					};
			/*query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_CHARGE' AND  " +
					"ROWNUM < ? ORDER BY 1";*/
			
			query = " SELECT PC_CODE, PC_DESC  FROM PM_CODES WHERE PC_TYPE = 'IL_CHARGE'   AND ?  IN ('3', '8')   AND ROWNUM < ?   UNION "
					+ " SELECT COVER_CODE, COVER_DESC  FROM PM_IL_COVER WHERE COVER_CODE IN (SELECT PAC_COVER_CODE  FROM PM_IL_PROD_APPL_COVER"
					+ " WHERE PAC_PROD_CODE = ? )  AND ? = '2' UNION SELECT COVER_CODE, COVER_DESC  FROM PM_IL_COVER WHERE COVER_CODE IN"
					+ " (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = ? )   AND ? = '1' ORDER BY 1";
		} else {
			/* object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_CHARGE' AND " +
					"(PC_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";*/
			
			object = new Object[] { PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE(),code + "%",PELConstants.suggetionRecordSize, 
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_PLAN_CODE(),code + "%",
					PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE(),
					compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN().getPROD_PLAN_CODE(),code + "%",
					PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE()};
			
			query = " SELECT PC_CODE, PC_DESC  FROM PM_CODES WHERE PC_TYPE = 'IL_CHARGE'   AND ?  IN ('3', '8')  AND PC_CODE LIKE ?  AND ROWNUM < ?   UNION "
					+ " SELECT COVER_CODE, COVER_DESC  FROM PM_IL_COVER WHERE COVER_CODE IN (SELECT PAC_COVER_CODE  FROM PM_IL_PROD_APPL_COVER"
					+ " WHERE PAC_PROD_CODE = ? ) AND COVER_CODE LIKE ?   AND ? = '2' UNION SELECT COVER_CODE, COVER_DESC  FROM PM_IL_COVER WHERE COVER_CODE IN"
					+ " (SELECT PROD_PLAN_CODE FROM PM_IL_PRODUCT WHERE PROD_CODE = ? )  AND COVER_CODE LIKE ?  AND ? = '1' ORDER BY 1";
			
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CHARGE_CODE", e.getMessage());
		}
		return suggestionList;
	}
	
	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}  finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}
	
	public void validatePIPD_CODE(FacesContext context,UIComponent component ,Object value){
		try{
			String pipdCode = (String)value;
			PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_CODE(pipdCode);
			
			//helper.whenValidatePIPD_CODE(pipdCode, PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*NEWLY ADDED BY DHINESH ON 11-07-2017  for ssp call id : ZBILQC-1731235 */
	/*public void validatePIPD_TYPE(FacesContext context,UIComponent component ,Object value){*/
		
	public void validatePIPD_TYPE(ActionEvent event)	
	{
	try{
			String pipdType = (String)COMP_PIPD_TYPE.getSubmittedValue();
			
			if(PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE()==null || !(PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE().equalsIgnoreCase(pipdType)))
			{
				PM_IL_PROD_INVEST_PREM_DEDC_BEAN.setPIPD_TYPE(pipdType);
			helper.whenValidatePIPD_TYPE(pipdType, PM_IL_PROD_INVEST_PREM_DEDC_BEAN);
		
			if(PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE().equalsIgnoreCase("1"))
			{
			helper.whenvalidate_defaultpipe_code((String) PM_IL_PROD_INVEST_PREM_DEDC_BEAN.getPIPD_TYPE(),compositeAction);
			}
			else
			{
				compositeAction.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN().getPM_IL_PROD_INVEST_PREM_DEDC_BEAN().setPIPD_CODE(null);
				compositeAction.getPM_IL_PROD_INVEST_PREM_DEDC_ACTION_BEAN().getPM_IL_PROD_INVEST_PREM_DEDC_BEAN().setUI_M_PIPD_CODE_DESC(null);
			}
			}
			COMP_PIPD_CODE.resetValue();
			COMP_UI_M_PIPD_CODE_DESC.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			//throw new ValidatorException(new FacesMessage(e.getMessage()));
			getErrorMap().put("current",e.getMessage());
		}
	}
	/*END*/
}
