package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
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

public class PM_IL_PLAN_AGE_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAS_JOINT_LIFE_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAS_JOINT_LIFE_YN;

	private HtmlOutputLabel COMP_PAS_AGE_BASIS_LABEL;

	private HtmlSelectOneMenu COMP_PAS_AGE_BASIS;

	private HtmlOutputLabel COMP_PAS_CATG_FM_CODE_LABEL;

	private HtmlInputText COMP_PAS_CATG_FM_CODE;

	private HtmlOutputLabel COMP_PAS_CATG_TO_CODE_LABEL;

	private HtmlInputText COMP_PAS_CATG_TO_CODE;

	private HtmlOutputLabel COMP_PAS_ASSRD_AGE_FM_LABEL;

	private HtmlInputText COMP_PAS_ASSRD_AGE_FM;

	private HtmlOutputLabel COMP_PAS_ASSRD_AGE_TO_LABEL;

	private HtmlInputText COMP_PAS_ASSRD_AGE_TO;

	private HtmlOutputLabel COMP_PAS_MIN_AGE_LABEL;

	private HtmlInputText COMP_PAS_MIN_AGE;

	private HtmlOutputLabel COMP_PAS_MAX_AGE_LABEL;

	private HtmlInputText COMP_PAS_MAX_AGE;

	private HtmlOutputLabel COMP_PAS_MIN_PERIOD_LABEL;

	private HtmlInputText COMP_PAS_MIN_PERIOD;

	private HtmlOutputLabel COMP_PAS_MAX_PERIOD_LABEL;

	private HtmlInputText COMP_PAS_MAX_PERIOD;

	private HtmlOutputLabel COMP_PAS_MAX_AGE_ON_MAT_LABEL;

	private HtmlInputText COMP_PAS_MAX_AGE_ON_MAT;

	private HtmlOutputLabel COMP_PAS_MIN_AGE_ON_MAT_LABEL;

	private HtmlInputText COMP_PAS_MIN_AGE_ON_MAT;

	private PM_IL_PLAN_AGE_SETUP PM_IL_PLAN_AGE_SETUP_BEAN;

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_PLAN_AGE_SETUP_HELPER helper;

	private List<PM_IL_PLAN_AGE_SETUP> dataList_PM_IL_PLAN_AGE_SETUP = new ArrayList<PM_IL_PLAN_AGE_SETUP>();

	private UIData dataTable;
	
	private List<LovBean> lovList = new ArrayList<LovBean>();

	private List<SelectItem> listPAS_JOINT_LIFE_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listPAS_AGE_BASIS = new ArrayList<SelectItem>();

	public PM_IL_PLAN_AGE_SETUP_ACTION() {

		PM_IL_PLAN_AGE_SETUP_BEAN = new PM_IL_PLAN_AGE_SETUP();
		helper = new PM_IL_PLAN_AGE_SETUP_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
	}
	
	public void prepareDropDownList(){
		Connection connection;
		try{
			connection = CommonUtils.getConnection();
			listPAS_JOINT_LIFE_YN = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN_AGE_SETUP",
					"PM_IL_PLAN_AGE_SETUP.PAS_JOINT_LIFE_YN", "YESNO");
			
			listPAS_AGE_BASIS = ListItemUtil.getDropDownListValue(
					connection, "PILM003_APAC", "PM_IL_PLAN_AGE_SETUP",
					"PM_IL_PLAN_AGE_SETUP.PAS_AGE_BASIS", "IL_ASSR_TYP");
			
		}catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PAS_JOINT_LIFE_YN_LABEL() {
		return COMP_PAS_JOINT_LIFE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAS_JOINT_LIFE_YN() {
		return COMP_PAS_JOINT_LIFE_YN;
	}

	public void setCOMP_PAS_JOINT_LIFE_YN_LABEL(
			HtmlOutputLabel COMP_PAS_JOINT_LIFE_YN_LABEL) {
		this.COMP_PAS_JOINT_LIFE_YN_LABEL = COMP_PAS_JOINT_LIFE_YN_LABEL;
	}

	public void setCOMP_PAS_JOINT_LIFE_YN(
			HtmlSelectOneMenu COMP_PAS_JOINT_LIFE_YN) {
		this.COMP_PAS_JOINT_LIFE_YN = COMP_PAS_JOINT_LIFE_YN;
	}

	public HtmlOutputLabel getCOMP_PAS_AGE_BASIS_LABEL() {
		return COMP_PAS_AGE_BASIS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PAS_AGE_BASIS() {
		return COMP_PAS_AGE_BASIS;
	}

	public void setCOMP_PAS_AGE_BASIS_LABEL(
			HtmlOutputLabel COMP_PAS_AGE_BASIS_LABEL) {
		this.COMP_PAS_AGE_BASIS_LABEL = COMP_PAS_AGE_BASIS_LABEL;
	}

	public void setCOMP_PAS_AGE_BASIS(HtmlSelectOneMenu COMP_PAS_AGE_BASIS) {
		this.COMP_PAS_AGE_BASIS = COMP_PAS_AGE_BASIS;
	}

	public HtmlOutputLabel getCOMP_PAS_CATG_FM_CODE_LABEL() {
		return COMP_PAS_CATG_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_CATG_FM_CODE() {
		return COMP_PAS_CATG_FM_CODE;
	}

	public void setCOMP_PAS_CATG_FM_CODE_LABEL(
			HtmlOutputLabel COMP_PAS_CATG_FM_CODE_LABEL) {
		this.COMP_PAS_CATG_FM_CODE_LABEL = COMP_PAS_CATG_FM_CODE_LABEL;
	}

	public void setCOMP_PAS_CATG_FM_CODE(HtmlInputText COMP_PAS_CATG_FM_CODE) {
		this.COMP_PAS_CATG_FM_CODE = COMP_PAS_CATG_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_CATG_TO_CODE_LABEL() {
		return COMP_PAS_CATG_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_CATG_TO_CODE() {
		return COMP_PAS_CATG_TO_CODE;
	}

	public void setCOMP_PAS_CATG_TO_CODE_LABEL(
			HtmlOutputLabel COMP_PAS_CATG_TO_CODE_LABEL) {
		this.COMP_PAS_CATG_TO_CODE_LABEL = COMP_PAS_CATG_TO_CODE_LABEL;
	}

	public void setCOMP_PAS_CATG_TO_CODE(HtmlInputText COMP_PAS_CATG_TO_CODE) {
		this.COMP_PAS_CATG_TO_CODE = COMP_PAS_CATG_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_PAS_ASSRD_AGE_FM_LABEL() {
		return COMP_PAS_ASSRD_AGE_FM_LABEL;
	}

	public HtmlInputText getCOMP_PAS_ASSRD_AGE_FM() {
		return COMP_PAS_ASSRD_AGE_FM;
	}

	public void setCOMP_PAS_ASSRD_AGE_FM_LABEL(
			HtmlOutputLabel COMP_PAS_ASSRD_AGE_FM_LABEL) {
		this.COMP_PAS_ASSRD_AGE_FM_LABEL = COMP_PAS_ASSRD_AGE_FM_LABEL;
	}

	public void setCOMP_PAS_ASSRD_AGE_FM(HtmlInputText COMP_PAS_ASSRD_AGE_FM) {
		this.COMP_PAS_ASSRD_AGE_FM = COMP_PAS_ASSRD_AGE_FM;
	}

	public HtmlOutputLabel getCOMP_PAS_ASSRD_AGE_TO_LABEL() {
		return COMP_PAS_ASSRD_AGE_TO_LABEL;
	}

	public HtmlInputText getCOMP_PAS_ASSRD_AGE_TO() {
		return COMP_PAS_ASSRD_AGE_TO;
	}

	public void setCOMP_PAS_ASSRD_AGE_TO_LABEL(
			HtmlOutputLabel COMP_PAS_ASSRD_AGE_TO_LABEL) {
		this.COMP_PAS_ASSRD_AGE_TO_LABEL = COMP_PAS_ASSRD_AGE_TO_LABEL;
	}

	public void setCOMP_PAS_ASSRD_AGE_TO(HtmlInputText COMP_PAS_ASSRD_AGE_TO) {
		this.COMP_PAS_ASSRD_AGE_TO = COMP_PAS_ASSRD_AGE_TO;
	}

	public HtmlOutputLabel getCOMP_PAS_MIN_AGE_LABEL() {
		return COMP_PAS_MIN_AGE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_MIN_AGE() {
		return COMP_PAS_MIN_AGE;
	}

	public void setCOMP_PAS_MIN_AGE_LABEL(HtmlOutputLabel COMP_PAS_MIN_AGE_LABEL) {
		this.COMP_PAS_MIN_AGE_LABEL = COMP_PAS_MIN_AGE_LABEL;
	}

	public void setCOMP_PAS_MIN_AGE(HtmlInputText COMP_PAS_MIN_AGE) {
		this.COMP_PAS_MIN_AGE = COMP_PAS_MIN_AGE;
	}

	public HtmlOutputLabel getCOMP_PAS_MAX_AGE_LABEL() {
		return COMP_PAS_MAX_AGE_LABEL;
	}

	public HtmlInputText getCOMP_PAS_MAX_AGE() {
		return COMP_PAS_MAX_AGE;
	}

	public void setCOMP_PAS_MAX_AGE_LABEL(HtmlOutputLabel COMP_PAS_MAX_AGE_LABEL) {
		this.COMP_PAS_MAX_AGE_LABEL = COMP_PAS_MAX_AGE_LABEL;
	}

	public void setCOMP_PAS_MAX_AGE(HtmlInputText COMP_PAS_MAX_AGE) {
		this.COMP_PAS_MAX_AGE = COMP_PAS_MAX_AGE;
	}

	public HtmlOutputLabel getCOMP_PAS_MIN_PERIOD_LABEL() {
		return COMP_PAS_MIN_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_PAS_MIN_PERIOD() {
		return COMP_PAS_MIN_PERIOD;
	}

	public void setCOMP_PAS_MIN_PERIOD_LABEL(
			HtmlOutputLabel COMP_PAS_MIN_PERIOD_LABEL) {
		this.COMP_PAS_MIN_PERIOD_LABEL = COMP_PAS_MIN_PERIOD_LABEL;
	}

	public void setCOMP_PAS_MIN_PERIOD(HtmlInputText COMP_PAS_MIN_PERIOD) {
		this.COMP_PAS_MIN_PERIOD = COMP_PAS_MIN_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PAS_MAX_PERIOD_LABEL() {
		return COMP_PAS_MAX_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_PAS_MAX_PERIOD() {
		return COMP_PAS_MAX_PERIOD;
	}

	public void setCOMP_PAS_MAX_PERIOD_LABEL(
			HtmlOutputLabel COMP_PAS_MAX_PERIOD_LABEL) {
		this.COMP_PAS_MAX_PERIOD_LABEL = COMP_PAS_MAX_PERIOD_LABEL;
	}

	public void setCOMP_PAS_MAX_PERIOD(HtmlInputText COMP_PAS_MAX_PERIOD) {
		this.COMP_PAS_MAX_PERIOD = COMP_PAS_MAX_PERIOD;
	}

	public HtmlOutputLabel getCOMP_PAS_MAX_AGE_ON_MAT_LABEL() {
		return COMP_PAS_MAX_AGE_ON_MAT_LABEL;
	}

	public HtmlInputText getCOMP_PAS_MAX_AGE_ON_MAT() {
		return COMP_PAS_MAX_AGE_ON_MAT;
	}

	public void setCOMP_PAS_MAX_AGE_ON_MAT_LABEL(
			HtmlOutputLabel COMP_PAS_MAX_AGE_ON_MAT_LABEL) {
		this.COMP_PAS_MAX_AGE_ON_MAT_LABEL = COMP_PAS_MAX_AGE_ON_MAT_LABEL;
	}

	public void setCOMP_PAS_MAX_AGE_ON_MAT(HtmlInputText COMP_PAS_MAX_AGE_ON_MAT) {
		this.COMP_PAS_MAX_AGE_ON_MAT = COMP_PAS_MAX_AGE_ON_MAT;
	}

	public HtmlOutputLabel getCOMP_PAS_MIN_AGE_ON_MAT_LABEL() {
		return COMP_PAS_MIN_AGE_ON_MAT_LABEL;
	}

	public HtmlInputText getCOMP_PAS_MIN_AGE_ON_MAT() {
		return COMP_PAS_MIN_AGE_ON_MAT;
	}

	public void setCOMP_PAS_MIN_AGE_ON_MAT_LABEL(
			HtmlOutputLabel COMP_PAS_MIN_AGE_ON_MAT_LABEL) {
		this.COMP_PAS_MIN_AGE_ON_MAT_LABEL = COMP_PAS_MIN_AGE_ON_MAT_LABEL;
	}

	public void setCOMP_PAS_MIN_AGE_ON_MAT(HtmlInputText COMP_PAS_MIN_AGE_ON_MAT) {
		this.COMP_PAS_MIN_AGE_ON_MAT = COMP_PAS_MIN_AGE_ON_MAT;
	}

	public PM_IL_PLAN_AGE_SETUP getPM_IL_PLAN_AGE_SETUP_BEAN() {
		return PM_IL_PLAN_AGE_SETUP_BEAN;
	}

	public void setPM_IL_PLAN_AGE_SETUP_BEAN(
			PM_IL_PLAN_AGE_SETUP PM_IL_PLAN_AGE_SETUP_BEAN) {
		this.PM_IL_PLAN_AGE_SETUP_BEAN = PM_IL_PLAN_AGE_SETUP_BEAN;
	}

	public List<PM_IL_PLAN_AGE_SETUP> getDataList_PM_IL_PLAN_AGE_SETUP() {
		return dataList_PM_IL_PLAN_AGE_SETUP;
	}

	public void setDataListPM_IL_PLAN_AGE_SETUP(
			List<PM_IL_PLAN_AGE_SETUP> dataList_PM_IL_PLAN_AGE_SETUP) {
		this.dataList_PM_IL_PLAN_AGE_SETUP = dataList_PM_IL_PLAN_AGE_SETUP;
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_IL_PLAN_AGE_SETUP_BEAN = new PM_IL_PLAN_AGE_SETUP();
				helper.whenCreateRecord(PM_IL_PLAN_AGE_SETUP_BEAN);
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

				new CRUDHandler().executeDelete(PM_IL_PLAN_AGE_SETUP_BEAN,
						CommonUtils.getConnection());
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
				dataList_PM_IL_PLAN_AGE_SETUP.remove(PM_IL_PLAN_AGE_SETUP_BEAN);
				if (dataList_PM_IL_PLAN_AGE_SETUP.size() > 0) {

					PM_IL_PLAN_AGE_SETUP_BEAN = dataList_PM_IL_PLAN_AGE_SETUP
							.get(0);
				} else if (dataList_PM_IL_PLAN_AGE_SETUP.size() == 0) {

					addRow(null);
				}
				resetAllComponent();
				PM_IL_PLAN_AGE_SETUP_BEAN.setRowSelected(true);
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
		   getErrorMap().clear();
		   getWarningMap().clear();
		try {
			if (PM_IL_PLAN_AGE_SETUP_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PM_IL_PLAN_AGE_SETUP_BEAN, compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PLAN_AGE_SETUP_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PM_IL_PLAN_AGE_SETUP.add(PM_IL_PLAN_AGE_SETUP_BEAN);
			} else if (PM_IL_PLAN_AGE_SETUP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_IL_PLAN_AGE_SETUP_BEAN, compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_PLAN_AGE_SETUP_BEAN,
						CommonUtils.getConnection());
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

			PM_IL_PLAN_AGE_SETUP_BEAN.setRowSelected(true);
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
			PM_IL_PLAN_AGE_SETUP_BEAN = (PM_IL_PLAN_AGE_SETUP) dataTable
					.getRowData();
			PM_IL_PLAN_AGE_SETUP_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PLAN_AGE_SETUP> PM_IL_PLAN_AGE_SETUP_ITR = dataList_PM_IL_PLAN_AGE_SETUP
				.iterator();
		while (PM_IL_PLAN_AGE_SETUP_ITR.hasNext()) {
			PM_IL_PLAN_AGE_SETUP_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PAS_JOINT_LIFE_YN.resetValue();
		COMP_PAS_AGE_BASIS.resetValue();
		COMP_PAS_CATG_FM_CODE.resetValue();
		COMP_PAS_CATG_TO_CODE.resetValue();
		COMP_PAS_ASSRD_AGE_FM.resetValue();
		COMP_PAS_ASSRD_AGE_TO.resetValue();
		COMP_PAS_MIN_AGE.resetValue();
		COMP_PAS_MAX_AGE.resetValue();
		COMP_PAS_MIN_PERIOD.resetValue();
		COMP_PAS_MAX_PERIOD.resetValue();
		COMP_PAS_MAX_AGE_ON_MAT.resetValue();
		COMP_PAS_MIN_AGE_ON_MAT.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		
		getWarningMap().clear();
		getErrorMap().clear();
		
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public List<SelectItem> getListPAS_JOINT_LIFE_YN() {
		if (listPAS_JOINT_LIFE_YN.size() == 0) {
			listPAS_JOINT_LIFE_YN.clear();
			try {
				listPAS_JOINT_LIFE_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAS_JOINT_LIFE_YN;
	}

	public void setListPAS_JOINT_LIFE_YN(List<SelectItem> listPAS_JOINT_LIFE_YN) {
		this.listPAS_JOINT_LIFE_YN = listPAS_JOINT_LIFE_YN;
	}

	public List<SelectItem> getListPAS_AGE_BASIS() {
		if (listPAS_AGE_BASIS.size() == 0) {
			listPAS_AGE_BASIS.clear();
			try {
				listPAS_AGE_BASIS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listPAS_AGE_BASIS;
	}

	public void setListPAS_AGE_BASIS(List<SelectItem> listPAS_AGE_BASIS) {
		this.listPAS_AGE_BASIS = listPAS_AGE_BASIS;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			helper.whenNewBlockInstance(compositeAction);
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if(PM_IL_PLAN_AGE_SETUP_BEAN.getROWID() == null){
					helper.whenCreateRecord(PM_IL_PLAN_AGE_SETUP_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	public List<LovBean> preparePAS_CATG_FM_CODE(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM003_APAC", "PM_IL_PLAN_AGE_SETUP",
					"PAS_CATG_FM_CODE", "CATG", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PAS_CATG_FM_CODE_SUGGESTION", e.getMessage());
		}
		return lovList;
	}

	public List<LovBean> preparePAS_CATG_TO_CODE(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovList = itemUtil.P_CALL_LOV("PILM003_APAC", "PM_IL_PLAN_AGE_SETUP",
					"PAS_CATG_TO_CODE", "CATG", null, null, null, null,
					(String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PAS_CATG_TO_CODE_SUGGESTION", e.getMessage());
		}
		return lovList;
	}
	
	public void validatePAS_JOINT_LIFE_YN(FacesContext context,
			UIComponent component, Object value){
		try{
			String PAS_JOINT_LIFE_YN = (String)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_JOINT_LIFE_YN(PAS_JOINT_LIFE_YN);
			helper.whenValidate_PAS_JOINT_LIFE_YN(this, PAS_JOINT_LIFE_YN);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_AGE_BASIS(FacesContext context,
			UIComponent component, Object value){
		try{
			String PAS_AGE_BASIS = (String)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_AGE_BASIS(PAS_AGE_BASIS);
			helper.whenValidate_PAS_AGE_BASIS(compositeAction, PAS_AGE_BASIS);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_CATG_FM_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String PAS_CATG_FM_CODE = (String)value;
			System.out.println("PAS_CATG_FM_CODE valueeeeeeeeeeeeeeeeeeee........................"+PAS_CATG_FM_CODE);
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_CATG_FM_CODE(PAS_CATG_FM_CODE);
			helper.whenValidate_PAS_CATG_FM_CODE(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_CATG_FM_CODE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_CATG_TO_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String PAS_CATG_TO_CODE = (String)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_CATG_TO_CODE(PAS_CATG_TO_CODE);
			helper.whenValidatePAS_CATG_TO_CODE(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_CATG_TO_CODE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_ASSRD_AGE_FM(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_ASSRD_AGE_FM = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_ASSRD_AGE_FM(PAS_ASSRD_AGE_FM);
			helper.whenValiadate_PAS_ASSRD_AGE_FM(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_ASSRD_AGE_FM);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_ASSRD_AGE_TO(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_ASSRD_AGE_TO = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_ASSRD_AGE_TO(PAS_ASSRD_AGE_TO);
			helper.whenValiadate_PAS_ASSRD_AGE_TO(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_ASSRD_AGE_TO);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_MIN_AGE(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_MIN_AGE = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MIN_AGE(PAS_MIN_AGE);
			helper.whenValiadate_PAS_MIN_AGE(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_MIN_AGE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_MAX_AGE(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_MAX_AGE = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MAX_AGE(PAS_MAX_AGE);
			helper.whenValiadate_PAS_MAX_AGE(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_MAX_AGE);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_MIN_PERIOD(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_MIN_PERIOD = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MIN_PERIOD(PAS_MIN_PERIOD);
			helper.whenValidate_PAS_MIN_PERIOD(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_MIN_PERIOD);
			COMP_PAS_MAX_AGE_ON_MAT.resetValue();
			COMP_PAS_MIN_AGE_ON_MAT.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validatePAS_MAX_PERIOD(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_MAX_PERIOD = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MAX_PERIOD(PAS_MAX_PERIOD);
			helper.whenValidate_PAS_MAX_PERIOD(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_MAX_PERIOD);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_MIN_AGE_ON_MAT(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_MIN_AGE_ON_MAT = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MIN_AGE_ON_MAT(PAS_MIN_AGE_ON_MAT);
			helper.whenValidate_PAS_MIN_AGE_ON_MAT(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_MIN_AGE_ON_MAT);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatePAS_MAX_AGE_ON_MAT(FacesContext context,
			UIComponent component, Object value){
		try{
			Integer PAS_MAX_AGE_ON_MAT = (Integer)value;
			PM_IL_PLAN_AGE_SETUP_BEAN.setPAS_MAX_AGE_ON_MAT(PAS_MAX_AGE_ON_MAT);
			helper.whenValidate_PAS_MAX_AGE_ON_MAT(PM_IL_PLAN_AGE_SETUP_BEAN, PAS_MAX_AGE_ON_MAT);
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public List<LovBean> lovPAS_CATG_FM_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM003_APAC",
					"PM_IL_PLAN_AGE_SETUP", "PAS_CATG_FM_CODE",
					"CATG", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovPAS_CATG_TO_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM003_APAC",
					"PM_IL_PLAN_AGE_SETUP", "PAS_CATG_TO_CODE",
					"CATG", null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	

	/**
	 * Instantiates all components in PM_IL_PLAN_AGE_SETUP_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PAS_CATG_FM_CODE				 = new HtmlInputText();
		COMP_PAS_CATG_TO_CODE				 = new HtmlInputText();
		COMP_PAS_ASSRD_AGE_FM				 = new HtmlInputText();
		COMP_PAS_ASSRD_AGE_TO				 = new HtmlInputText();
		COMP_PAS_MIN_AGE				 = new HtmlInputText();
		COMP_PAS_MAX_AGE				 = new HtmlInputText();
		COMP_PAS_MIN_PERIOD				 = new HtmlInputText();
		COMP_PAS_MAX_PERIOD				 = new HtmlInputText();
		COMP_PAS_MAX_AGE_ON_MAT				 = new HtmlInputText();
		COMP_PAS_MIN_AGE_ON_MAT				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_PAS_JOINT_LIFE_YN				 = new HtmlSelectOneMenu();
		COMP_PAS_AGE_BASIS				 = new HtmlSelectOneMenu();

	}


}
