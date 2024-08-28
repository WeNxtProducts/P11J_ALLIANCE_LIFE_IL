package com.iii.pel.forms.PILM031;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.pel.forms.PM102_A_TISB.PM_AGENT_PF_ACNT_TYPE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_DISC_AGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DA_ADDL_RISK_CODE_LABEL;

	private HtmlInputText COMP_DA_ADDL_RISK_CODE;

	private HtmlOutputLabel COMP_DA_CATG_CODE_LABEL;

	private HtmlInputText COMP_DA_CATG_CODE;

	private HtmlOutputLabel COMP_DA_UW_AGE_LABEL;

	private HtmlInputText COMP_DA_UW_AGE;

	private HtmlOutputLabel COMP_DA_RI_AGE_LABEL;

	private HtmlInputText COMP_DA_RI_AGE;

	private HtmlOutputLabel COMP_DA_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_DA_EFF_FM_DT;

	private HtmlOutputLabel COMP_DA_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_DA_EFF_TO_DT;

	private HtmlOutputLabel COMP_UI_M_DA_ADDL_RISK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DA_ADDL_RISK_DESC;

	private HtmlOutputLabel COMP_UI_M_DA_CATG_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DA_CATG_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_DA_ADDL_RISK_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_DA_CATG_CODE_LOV;

	private PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN;

	public PILM031_COMPOSITE_ACTION compositeAction;

	private PM_IL_DISC_AGE_HELPER helper;

	CRUDHandler handler = new CRUDHandler();

	private List<PM_IL_DISC_AGE> dataList_PM_IL_DISC_AGE = new ArrayList<PM_IL_DISC_AGE>();

	private UIDataTable dataTable;

	public PM_IL_DISC_AGE_ACTION() {

		PM_IL_DISC_AGE_BEAN = new PM_IL_DISC_AGE();
		helper = new PM_IL_DISC_AGE_HELPER();
	}

	public HtmlOutputLabel getCOMP_DA_ADDL_RISK_CODE_LABEL() {
		return COMP_DA_ADDL_RISK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DA_ADDL_RISK_CODE() {
		return COMP_DA_ADDL_RISK_CODE;
	}

	public void setCOMP_DA_ADDL_RISK_CODE_LABEL(
			HtmlOutputLabel COMP_DA_ADDL_RISK_CODE_LABEL) {
		this.COMP_DA_ADDL_RISK_CODE_LABEL = COMP_DA_ADDL_RISK_CODE_LABEL;
	}

	public void setCOMP_DA_ADDL_RISK_CODE(HtmlInputText COMP_DA_ADDL_RISK_CODE) {
		this.COMP_DA_ADDL_RISK_CODE = COMP_DA_ADDL_RISK_CODE;
	}

	public HtmlOutputLabel getCOMP_DA_CATG_CODE_LABEL() {
		return COMP_DA_CATG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DA_CATG_CODE() {
		return COMP_DA_CATG_CODE;
	}

	public void setCOMP_DA_CATG_CODE_LABEL(
			HtmlOutputLabel COMP_DA_CATG_CODE_LABEL) {
		this.COMP_DA_CATG_CODE_LABEL = COMP_DA_CATG_CODE_LABEL;
	}

	public void setCOMP_DA_CATG_CODE(HtmlInputText COMP_DA_CATG_CODE) {
		this.COMP_DA_CATG_CODE = COMP_DA_CATG_CODE;
	}

	public HtmlOutputLabel getCOMP_DA_UW_AGE_LABEL() {
		return COMP_DA_UW_AGE_LABEL;
	}

	public HtmlInputText getCOMP_DA_UW_AGE() {
		return COMP_DA_UW_AGE;
	}

	public void setCOMP_DA_UW_AGE_LABEL(HtmlOutputLabel COMP_DA_UW_AGE_LABEL) {
		this.COMP_DA_UW_AGE_LABEL = COMP_DA_UW_AGE_LABEL;
	}

	public void setCOMP_DA_UW_AGE(HtmlInputText COMP_DA_UW_AGE) {
		this.COMP_DA_UW_AGE = COMP_DA_UW_AGE;
	}

	public HtmlOutputLabel getCOMP_DA_RI_AGE_LABEL() {
		return COMP_DA_RI_AGE_LABEL;
	}

	public HtmlInputText getCOMP_DA_RI_AGE() {
		return COMP_DA_RI_AGE;
	}

	public void setCOMP_DA_RI_AGE_LABEL(HtmlOutputLabel COMP_DA_RI_AGE_LABEL) {
		this.COMP_DA_RI_AGE_LABEL = COMP_DA_RI_AGE_LABEL;
	}

	public void setCOMP_DA_RI_AGE(HtmlInputText COMP_DA_RI_AGE) {
		this.COMP_DA_RI_AGE = COMP_DA_RI_AGE;
	}

	public HtmlOutputLabel getCOMP_DA_EFF_FM_DT_LABEL() {
		return COMP_DA_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DA_EFF_FM_DT() {
		return COMP_DA_EFF_FM_DT;
	}

	public void setCOMP_DA_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_DA_EFF_FM_DT_LABEL) {
		this.COMP_DA_EFF_FM_DT_LABEL = COMP_DA_EFF_FM_DT_LABEL;
	}

	public void setCOMP_DA_EFF_FM_DT(HtmlCalendar COMP_DA_EFF_FM_DT) {
		this.COMP_DA_EFF_FM_DT = COMP_DA_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_DA_EFF_TO_DT_LABEL() {
		return COMP_DA_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DA_EFF_TO_DT() {
		return COMP_DA_EFF_TO_DT;
	}

	public void setCOMP_DA_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_DA_EFF_TO_DT_LABEL) {
		this.COMP_DA_EFF_TO_DT_LABEL = COMP_DA_EFF_TO_DT_LABEL;
	}

	public void setCOMP_DA_EFF_TO_DT(HtmlCalendar COMP_DA_EFF_TO_DT) {
		this.COMP_DA_EFF_TO_DT = COMP_DA_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_DA_ADDL_RISK_DESC_LABEL() {
		return COMP_UI_M_DA_ADDL_RISK_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DA_ADDL_RISK_DESC() {
		return COMP_UI_M_DA_ADDL_RISK_DESC;
	}

	public void setCOMP_UI_M_DA_ADDL_RISK_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DA_ADDL_RISK_DESC_LABEL) {
		this.COMP_UI_M_DA_ADDL_RISK_DESC_LABEL = COMP_UI_M_DA_ADDL_RISK_DESC_LABEL;
	}

	public void setCOMP_UI_M_DA_ADDL_RISK_DESC(
			HtmlInputText COMP_UI_M_DA_ADDL_RISK_DESC) {
		this.COMP_UI_M_DA_ADDL_RISK_DESC = COMP_UI_M_DA_ADDL_RISK_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_DA_CATG_DESC_LABEL() {
		return COMP_UI_M_DA_CATG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DA_CATG_DESC() {
		return COMP_UI_M_DA_CATG_DESC;
	}

	public void setCOMP_UI_M_DA_CATG_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DA_CATG_DESC_LABEL) {
		this.COMP_UI_M_DA_CATG_DESC_LABEL = COMP_UI_M_DA_CATG_DESC_LABEL;
	}

	public void setCOMP_UI_M_DA_CATG_DESC(HtmlInputText COMP_UI_M_DA_CATG_DESC) {
		this.COMP_UI_M_DA_CATG_DESC = COMP_UI_M_DA_CATG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DA_CATG_CODE_LOV() {
		return COMP_UI_M_BUT_DA_CATG_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_DA_CATG_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DA_CATG_CODE_LOV) {
		this.COMP_UI_M_BUT_DA_CATG_CODE_LOV = COMP_UI_M_BUT_DA_CATG_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DA_ADDL_RISK_LOV() {
		return COMP_UI_M_BUT_DA_ADDL_RISK_LOV;
	}

	public void setCOMP_UI_M_BUT_DA_ADDL_RISK_LOV(
			HtmlCommandButton COMP_UI_M_BUT_DA_ADDL_RISK_LOV) {
		this.COMP_UI_M_BUT_DA_ADDL_RISK_LOV = COMP_UI_M_BUT_DA_ADDL_RISK_LOV;
	}

	public PM_IL_DISC_AGE getPM_IL_DISC_AGE_BEAN() {
		return PM_IL_DISC_AGE_BEAN;
	}

	public void setPM_IL_DISC_AGE_BEAN(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN) {
		this.PM_IL_DISC_AGE_BEAN = PM_IL_DISC_AGE_BEAN;
	}

	public List<PM_IL_DISC_AGE> getDataList_PM_IL_DISC_AGE() {
		return dataList_PM_IL_DISC_AGE;
	}

	public void setDataListPM_IL_DISC_AGE(
			List<PM_IL_DISC_AGE> dataList_PM_IL_DISC_AGE) {
		this.dataList_PM_IL_DISC_AGE = dataList_PM_IL_DISC_AGE;
	}


	//List<PM_IL_DISC_AGE> beanList = new ArrayList<PM_IL_DISC_AGE>();

	/*public List<PM_IL_DISC_AGE> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<PM_IL_DISC_AGE> beanList) {
		this.beanList = beanList;
	}
	*/
	private List<SelectItem> APAT_CODE_LIST = new ArrayList<SelectItem>();

	public List<SelectItem> getAPAT_CODE_LIST() throws Exception {
		return APAT_CODE_LIST;
	}

	public void setAPAT_CODE_LIST(List<SelectItem> apat_code_list) {
		APAT_CODE_LIST = apat_code_list;
	}


	int rowIndex = 0;

	Connection conn;
	Map<String, Object> session = null;
	// ControlBean ctrlBean = null;
	FacesContext ctx = FacesContext.getCurrentInstance();

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_DISC_AGE_BEAN = new PM_IL_DISC_AGE();
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

	public String saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put("commkey", "Save successful");
			getWarningMap().put("current", "Record saved successfully");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("commkey", "Error on commit, cause: "+e.getMessage());
			getErrorMap().put("current", "Error on commit");
		}
		return null;
	}	

	public void lastColumnListener() throws Exception {

		int currRowIndex = getDataTable().getRowIndex();
		int rowUpdated = 0;
		PM_IL_DISC_AGE pm_il_disc_age = null;
		try {

			// Get the bean based on row index
			pm_il_disc_age = (PM_IL_DISC_AGE) getDataList_PM_IL_DISC_AGE().get(currRowIndex);

			// Update the record to database
			if (pm_il_disc_age.getROWID() != null) {
				PRE_UPDATE(pm_il_disc_age);
				rowUpdated = new PM_IL_DISC_AGE_DELEGATE()
				.updateData(pm_il_disc_age);
				if (rowUpdated > 0) {
					getWarningMap().put("current",
					"Record Updated Successfully");
					getWarningMap().put("details",
					"Record Updated Successfully");
		
				}
			} else {
				PRE_INSERT(pm_il_disc_age);
				rowUpdated = new PM_IL_DISC_AGE_DELEGATE()
				.updateData(pm_il_disc_age);
				if (rowUpdated > 0) {
					getWarningMap().put("current",
					"Record Inserted Successfully");
					getWarningMap().put("details",
					"Record Updated Successfully");
				}
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void PRE_INSERT(PM_IL_DISC_AGE pm_il_disc_age)
	throws ValidatorException, ParseException {
		String TEMPID = new PM_IL_DISC_AGE_DELEGATE()
		.duplicateCheck(pm_il_disc_age);
		if (new CommonUtils().isDuplicate(pm_il_disc_age.getROWID(), TEMPID)) {
			throw new ValidatorException(Messages.getMessage(
					PELConstants.pelErrorMessagePath, "60018_1"));
		}
		pm_il_disc_age.setDA_UPD_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		pm_il_disc_age.setDA_UPD_DT(new CommonUtils().getCurrentDate());
	}

	public void PRE_UPDATE(PM_IL_DISC_AGE pm_il_disc_age) throws ParseException {
		pm_il_disc_age.setDA_UPD_UID(CommonUtils.getControlBean()
				.getM_USER_ID());
		pm_il_disc_age.setDA_UPD_DT(new CommonUtils().getCurrentDate());
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		getWarningMap().clear();
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if (PM_IL_DISC_AGE_BEAN.getROWID() != null) {
					helper.postQuery(PM_IL_DISC_AGE_BEAN);
				}
				setBlockFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public void validatorRISK_CODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_IL_DISC_AGE_BEAN.setDA_ADDL_RISK_CODE((String) value);
			helper.whenValidateDA_ADDL_RISK_CODE(PM_IL_DISC_AGE_BEAN);
			COMP_UI_M_DA_ADDL_RISK_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatorCTG_CODE(FacesContext context, UIComponent component,
			Object value) {
		try {
			PM_IL_DISC_AGE_BEAN.setDA_CATG_CODE((String) value);
			helper.whenValidateDA_CATG_CODE(PM_IL_DISC_AGE_BEAN);
			COMP_UI_M_DA_CATG_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatorDA_EFF_FM_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_DISC_AGE_BEAN.setDA_EFF_FM_DT((Date) value);
			helper.whenValidateDA_EFF_FM_DT(PM_IL_DISC_AGE_BEAN);
			COMP_DA_EFF_FM_DT.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatorDA_EFF_TO_DT(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_IL_DISC_AGE_BEAN.setDA_EFF_TO_DT((Date) value);
			helper.whenValidateDA_EFF_TO_DT(PM_IL_DISC_AGE_BEAN);
			COMP_DA_EFF_TO_DT.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> RISK_CODE_KEY_LISTVAL(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM031",
					"PM_IL_DISC_AGE", "DA_ADDL_RISK_CODE", "IL_ADDL_RISK",
					null, null, null, null, (String) currValue);
			System.out.println(" LIST " + suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public ArrayList<LovBean> CATG_CODE_KEY_LISTVAL(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM031",
					"PM_IL_DISC_AGE", "DA_CATG_CODE", "CATG", null, null, null,
					null, (String) currValue);
			System.out.println(" LIST " + suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_DISC_AGE_BEAN = (PM_IL_DISC_AGE) dataTable.getRowData();
			helper.postQuery(PM_IL_DISC_AGE_BEAN);
			PM_IL_DISC_AGE_BEAN.setRowSelected(true);
			resetAllComponent();
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("displayRecords", e.getMessage());
		}
	}

	
	 
	public void pm_il_disc_age_pre_insert(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
	throws Exception {
		String sql_C1 = "SELECT ROWID FROM  PM_IL_DISC_AGE  WHERE  DA_ADDL_RISK_CODE = ?";
		ResultSet vembu_C1 = null;
		String TEMP = null;
		conn = CommonUtils.getConnection();
		try {
			vembu_C1 = handler
			.executeSelectStatement(sql_C1, conn,
					new Object[] { PM_IL_DISC_AGE_BEAN
					.getDA_ADDL_RISK_CODE() });
			/*
			if (vembu_C1.next()) {
				TEMP = vembu_C1.getString(1);
				if (CommonUtils.isDuplicate(PM_IL_DISC_AGE_BEAN.getROWID(),
						TEMP))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60018_1"));
			}
			*/
			PM_IL_DISC_AGE_BEAN.setDA_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_IL_DISC_AGE_BEAN.setDA_CR_DT(new CommonUtils().getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void pm_il_disc_age_pre_update(PM_IL_DISC_AGE PM_IL_DISC_AGE_BEAN)
	throws Exception {
		String sql_C1 = "SELECT 'X' FROM PM_IL_DISC_AGE WHERE DA_ADDL_RISK_CODE=?"
			+ " AND   ROWID <>?";
		ResultSet vembu_C1 = null;
		String TEMP = null;
		conn = CommonUtils.getConnection();
		try {
			vembu_C1 = handler.executeSelectStatement(sql_C1, conn,
					new Object[] { PM_IL_DISC_AGE_BEAN.getDA_ADDL_RISK_CODE(),
					PM_IL_DISC_AGE_BEAN.getROWID() });
			if (vembu_C1.next()) {
				TEMP = vembu_C1.getString(1);
				if (CommonUtils.isDuplicate(PM_IL_DISC_AGE_BEAN.getROWID(),
						TEMP))
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60018_1"));
			}
			PM_IL_DISC_AGE_BEAN.setDA_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			PM_IL_DISC_AGE_BEAN.setDA_CR_DT(new CommonUtils().getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void postRecord(ActionEvent ae) {
		try {
			if (PM_IL_DISC_AGE_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					pm_il_disc_age_pre_update(PM_IL_DISC_AGE_BEAN);
					new CRUDHandler().executeUpdate(PM_IL_DISC_AGE_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$Grid$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$Grid$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$updatenotallowed"));
				}
			} else {
				if (isINSERT_ALLOWED()) {
					pm_il_disc_age_pre_insert(PM_IL_DISC_AGE_BEAN);
					new CRUDHandler().executeInsert(PM_IL_DISC_AGE_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insert"));
					dataList_PM_IL_DISC_AGE.add(PM_IL_DISC_AGE_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			}
			PM_IL_DISC_AGE_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	public void resetAllComponent() {
		// Reseting HtmlInputText
		COMP_DA_ADDL_RISK_CODE.resetValue();
		COMP_DA_CATG_CODE.resetValue();
		COMP_DA_EFF_FM_DT.resetValue();
		COMP_DA_EFF_TO_DT.resetValue();
		COMP_DA_RI_AGE.resetValue();
		COMP_DA_UW_AGE.resetValue();
		COMP_UI_M_DA_ADDL_RISK_DESC.resetValue();
		COMP_UI_M_DA_CATG_DESC.resetValue();
	}

	private void resetSelectedRow() {
		Iterator<PM_IL_DISC_AGE> iterator = dataList_PM_IL_DISC_AGE.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void AddRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PM_IL_DISC_AGE_BEAN = new PM_IL_DISC_AGE();
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PM_IL_DISC_AGE_BEAN.getROWID() != null) {
					new CRUDHandler().executeDelete(PM_IL_DISC_AGE_BEAN,
							CommonUtils.getConnection());
					dataList_PM_IL_DISC_AGE.remove(PM_IL_DISC_AGE_BEAN);
				}

				if (dataList_PM_IL_DISC_AGE.size() > 0) {
					setPM_IL_DISC_AGE_BEAN(dataList_PM_IL_DISC_AGE.get(0));
					PM_IL_DISC_AGE_BEAN.setRowSelected(true);
				} else {
					AddRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$Grid$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$Grid$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

}
