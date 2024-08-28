package com.iii.pel.forms.PILM036_APAC;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
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

public class PM_IL_SUB_PLAN_GROUP_ACTION extends CommonAction{

	private PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN;
	
	public PILM036_APAC_COMPOSITE_ACTION compositeAction;

	private PM_IL_SUB_PLAN_GROUP_HELPER helper;
	
	
	private HtmlOutputLabel COMP_SPG_CODE_LABEL;

	private HtmlInputText COMP_SPG_CODE;
	
	private HtmlOutputLabel COMP_SPG_DESC_LABEL;

	private HtmlInputText COMP_SPG_DESC;

	private HtmlOutputLabel COMP_SPG_MEMB_TYPE_LABEL;

	private HtmlInputText COMP_SPG_MEMB_TYPE;
	
	private HtmlInputText COMP_SPG_MEMB_DESC;
	
	private HtmlOutputLabel COMP_SPG_MEMB_COUNT_LABEL;
	
	private HtmlInputText COMP_SPG_MEMB_COUNT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_1;
	
	

	private List<PM_IL_SUB_PLAN_GROUP> dataList_PM_IL_SUB_PLAN_GROUP = new ArrayList<PM_IL_SUB_PLAN_GROUP>();

	private UIData dataTable;
		
	private List<SelectItem> listSPLAN_GROUP_YN = new ArrayList<SelectItem>();
	
	
	public List<SelectItem> getListSPLAN_GROUP_YN() {
		return listSPLAN_GROUP_YN;
	}

	public List<SelectItem> setListSPLAN_GROUP_YN(List<SelectItem> listSPLAN_GROUP_YN) {
		if (listSPLAN_GROUP_YN.size() == 0) {
			listSPLAN_GROUP_YN.clear();
			try {
				listSPLAN_GROUP_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		return listSPLAN_GROUP_YN;
	}


	public PM_IL_SUB_PLAN_GROUP getPM_IL_SUB_PLAN_GROUP_BEAN() {
		return PM_IL_SUB_PLAN_GROUP_BEAN;
	}

	public void setPM_IL_SUB_PLAN_GROUP_BEAN(
			PM_IL_SUB_PLAN_GROUP PM_IL_SUB_PLAN_GROUP_BEAN) {
		PM_IL_SUB_PLAN_GROUP_BEAN = PM_IL_SUB_PLAN_GROUP_BEAN;
	}

	public PM_IL_SUB_PLAN_GROUP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_SUB_PLAN_GROUP_HELPER helper) {
		this.helper = helper;
	}

	public HtmlOutputLabel getCOMP_SPG_CODE_LABEL() {
		return COMP_SPG_CODE_LABEL;
	}

	public void setCOMP_SPG_CODE_LABEL(HtmlOutputLabel cOMP_SPG_CODE_LABEL) {
		COMP_SPG_CODE_LABEL = cOMP_SPG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_SPG_CODE() {
		return COMP_SPG_CODE;
	}

	public void setCOMP_SPG_CODE(HtmlInputText cOMP_SPG_CODE) {
		COMP_SPG_CODE = cOMP_SPG_CODE;
	}

	public HtmlOutputLabel getCOMP_SPG_DESC_LABEL() {
		return COMP_SPG_DESC_LABEL;
	}

	public void setCOMP_SPG_DESC_LABEL(HtmlOutputLabel cOMP_SPG_DESC_LABEL) {
		COMP_SPG_DESC_LABEL = cOMP_SPG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_SPG_DESC() {
		return COMP_SPG_DESC;
	}

	public void setCOMP_SPG_DESC(HtmlInputText cOMP_SPG_DESC) {
		COMP_SPG_DESC = cOMP_SPG_DESC;
	}

	public HtmlOutputLabel getCOMP_SPG_MEMB_TYPE_LABEL() {
		return COMP_SPG_MEMB_TYPE_LABEL;
	}

	public void setCOMP_SPG_MEMB_TYPE_LABEL(HtmlOutputLabel cOMP_SPG_MEMB_TYPE_LABEL) {
		COMP_SPG_MEMB_TYPE_LABEL = cOMP_SPG_MEMB_TYPE_LABEL;
	}

	
	public HtmlInputText getCOMP_SPG_MEMB_TYPE() {
		return COMP_SPG_MEMB_TYPE;
	}

	public void setCOMP_SPG_MEMB_TYPE(HtmlInputText cOMP_SPG_MEMB_TYPE) {
		COMP_SPG_MEMB_TYPE = cOMP_SPG_MEMB_TYPE;
	}

	public HtmlInputText getCOMP_SPG_MEMB_DESC() {
		return COMP_SPG_MEMB_DESC;
	}

	public void setCOMP_SPG_MEMB_DESC(HtmlInputText cOMP_SPG_MEMB_DESC) {
		COMP_SPG_MEMB_DESC = cOMP_SPG_MEMB_DESC;
	}

	public HtmlOutputLabel getCOMP_SPG_MEMB_COUNT_LABEL() {
		return COMP_SPG_MEMB_COUNT_LABEL;
	}

	public void setCOMP_SPG_MEMB_COUNT_LABEL(
			HtmlOutputLabel cOMP_SPG_MEMB_COUNT_LABEL) {
		COMP_SPG_MEMB_COUNT_LABEL = cOMP_SPG_MEMB_COUNT_LABEL;
	}

	public HtmlInputText getCOMP_SPG_MEMB_COUNT() {
		return COMP_SPG_MEMB_COUNT;
	}

	public void setCOMP_SPG_MEMB_COUNT(HtmlInputText cOMP_SPG_MEMB_COUNT) {
		COMP_SPG_MEMB_COUNT = cOMP_SPG_MEMB_COUNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_1() {
		return COMP_UI_M_BUT_MAIN_1;
	}

	public void setCOMP_UI_M_BUT_MAIN_1(HtmlCommandButton cOMP_UI_M_BUT_MAIN_1) {
		COMP_UI_M_BUT_MAIN_1 = cOMP_UI_M_BUT_MAIN_1;
	}

	public List<PM_IL_SUB_PLAN_GROUP> getDataList_PM_IL_SUB_PLAN_GROUP() {
		return dataList_PM_IL_SUB_PLAN_GROUP;
	}

	public void setDataList_PM_IL_SUB_PLAN_GROUP(
			List<PM_IL_SUB_PLAN_GROUP> dataList_PM_IL_SUB_PLAN_GROUP) {
		this.dataList_PM_IL_SUB_PLAN_GROUP = dataList_PM_IL_SUB_PLAN_GROUP;
	}

	public PILM036_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	public void setCompositeAction(PILM036_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	


	public PM_IL_SUB_PLAN_GROUP_ACTION() {
		
		PM_IL_SUB_PLAN_GROUP_BEAN = new PM_IL_SUB_PLAN_GROUP();
		helper = new PM_IL_SUB_PLAN_GROUP_HELPER();
		setListItemValues();
	}
	
	
	public void onLoad(PhaseEvent event) {
		
		try {

			if (isBlockFlag()) {

				helper.executeQuery(compositeAction);
				PM_IL_SUB_PLAN_GROUP_BEAN.setRowSelected(true);
				/*Added by Janani on 10.07.2018 for FLALIFEQC-1754262 */
				displayRecords();
				/*End of FLALIFEQC-1754262 */
				
				/* Newly Added By Dhinesh on 13-06-2018 for FLA ssp call id  : FLALIFEQC-1754262 */
				resetAllComponent();
				/* End */
				
				setBlockFlag(false);
			}
									
			
		} catch (Exception e) {
		    e.printStackTrace();		
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public void setListItemValues() {
		Connection connection = null;
		try 
		{
			connection = CommonUtils.getConnection();

			setListSPLAN_GROUP_YN(ListItemUtil.getDropDownListValue(
					connection, "PILT002_APAC", "PT_IL_POLICY",
					"PT_IL_POLICY.POL_JOINT_LIFE_YN", "YESNO"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {

				PM_IL_SUB_PLAN_GROUP_BEAN = new PM_IL_SUB_PLAN_GROUP();
								
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

				new CRUDHandler().executeDelete(PM_IL_SUB_PLAN_GROUP_BEAN,
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
				dataList_PM_IL_SUB_PLAN_GROUP
						.remove(PM_IL_SUB_PLAN_GROUP_BEAN);
				if (dataList_PM_IL_SUB_PLAN_GROUP.size() > 0) {

					PM_IL_SUB_PLAN_GROUP_BEAN = dataList_PM_IL_SUB_PLAN_GROUP
							.get(0);
				} else if (dataList_PM_IL_SUB_PLAN_GROUP.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_SUB_PLAN_GROUP_BEAN.setRowSelected(true);
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
			if (PM_IL_SUB_PLAN_GROUP_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PM_IL_SUB_PLAN_GROUP_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				/*getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));*/
				dataList_PM_IL_SUB_PLAN_GROUP.add(PM_IL_SUB_PLAN_GROUP_BEAN);
			} else if (PM_IL_SUB_PLAN_GROUP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PM_IL_SUB_PLAN_GROUP_BEAN,
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

			/*Added by Janani on 19.05.2018 for records getting saved in table*/
			CommonUtils.getConnection().commit();
			
			PM_IL_SUB_PLAN_GROUP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			exc.printStackTrace();
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
			PM_IL_SUB_PLAN_GROUP_BEAN = (PM_IL_SUB_PLAN_GROUP) dataTable
					.getRowData();
			PM_IL_SUB_PLAN_GROUP_BEAN.setRowSelected(true);
			helper.POST_QUERY(compositeAction);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
			exc.printStackTrace();
		}

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_SUB_PLAN_GROUP> PM_IL_SUB_PLAN_GROUP_ITR = dataList_PM_IL_SUB_PLAN_GROUP
				.iterator();
		while (PM_IL_SUB_PLAN_GROUP_ITR.hasNext()) {
			PM_IL_SUB_PLAN_GROUP_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_SPG_CODE.resetValue();
		COMP_SPG_DESC.resetValue();
		COMP_SPG_MEMB_TYPE.resetValue();
		COMP_SPG_MEMB_DESC.resetValue();
		
		/* Newly Added By Dhinesh on 13-06-2018 for FLA ssp call id  : FLALIFEQC-1754262 */
		COMP_SPG_MEMB_COUNT.resetValue();
		/* End */
		
	}
	
	private void intiateAllComponents(){
		
		COMP_SPG_CODE_LABEL = new HtmlOutputLabel();
		COMP_SPG_CODE = new HtmlInputText();
		COMP_SPG_DESC_LABEL = new HtmlOutputLabel();
		COMP_SPG_DESC = new HtmlInputText();
		COMP_SPG_MEMB_TYPE_LABEL = new HtmlOutputLabel();
		COMP_SPG_MEMB_TYPE = new HtmlInputText();
		COMP_SPG_MEMB_COUNT_LABEL = new HtmlOutputLabel();
		COMP_SPG_MEMB_COUNT = new HtmlInputText();
		COMP_SPG_MEMB_DESC = new HtmlInputText();
		COMP_UI_M_BUT_MAIN_1 = new HtmlCommandButton();
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
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void validateSPG_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_SUB_PLAN_GROUP_BEAN().setSPG_CODE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
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

	
	public void validateSPG_DESC(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			
			getPM_IL_SUB_PLAN_GROUP_BEAN().setSPG_DESC((String) value);
		} catch (Exception e) {
			e.printStackTrace();
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
	
	public void SPG_MEMB_TYPE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {

			getPM_IL_SUB_PLAN_GROUP_BEAN().setSPG_MEMB_TYPE((String) value);
		} catch (Exception e) {
			e.printStackTrace();
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

	public void validateSPG_MEMB_COUNT(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {

			getPM_IL_SUB_PLAN_GROUP_BEAN().setSPG_MEMB_COUNT((int) value);
			
		} catch (Exception e) {
			e.printStackTrace();
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
	
	
	public List<LovBean> lovSPG_MEMB_TYPE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POL_FUNERAL_MEMB_DTLS", "PFMD_RELATION_TYPE",
					"IL_PAR_MEMB", null, null, null, null, (String) currValue);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
	public String backAction(){
		return "PILM036_APAC_PM_IL_SUB_PLAN";
	}
}
