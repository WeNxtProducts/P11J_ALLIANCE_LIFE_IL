package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT021.PT_IL_WITHDRAWAL_CHARGE;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PremiaLib;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_ASSR_FAMILY_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAFD_REL_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PAFD_REL_TYPE;

	private HtmlCommandButton COMP_POAC_BACK;

	private HtmlOutputLabel COMP_PAFD_AGE_LABEL;

	private HtmlInputText COMP_PAFD_AGE;

	private HtmlOutputLabel COMP_PAFD_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_PAFD_STATUS;
	
	private HtmlOutputLabel COMP_PAFD_REASON_LABEL;

	private HtmlInputText COMP_PAFD_REASON;
	
	private HtmlOutputLabel COMP_PAFD_HEALTH_YN_LABEL;

	private HtmlSelectOneMenu COMP_PAFD_HEALTH_YN;
	
	private HtmlOutputLabel COMP_PAFD_ADVERSITY_LABEL;

	private HtmlInputText COMP_PAFD_ADVERSITY;
	
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	
	private HtmlAjaxCommandButton COMP_DEL_ROW;
	
	private HtmlAjaxCommandButton COMP_POST_ROW;


	private ArrayList<PT_IL_POL_ASSR_FAMILY_DTLS> list = new ArrayList<PT_IL_POL_ASSR_FAMILY_DTLS>();

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ASSR_FAMILY_DTLS_HELPER helper;

	private PT_IL_POL_ASSR_FAMILY_DTLS PT_IL_POL_ASSR_FAMILY_DTLS_BEAN;


	private List<SelectItem> listPAFD_REL_TYPE = new ArrayList<SelectItem>();
	
	private List<SelectItem> listPAFD_STATUS = new ArrayList<SelectItem>();
	
	private List<SelectItem> listPAFD_HEALTH_YN = new ArrayList<SelectItem>();
	
	

	private List<PT_IL_POL_ASSR_FAMILY_DTLS> dataList_PT_IL_POL_ASSR_FAMILY_DTLS = new ArrayList<PT_IL_POL_ASSR_FAMILY_DTLS>();

	private UIData dataTable;



	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}


	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton cOMP_ADD_ROW) {
		COMP_ADD_ROW = cOMP_ADD_ROW;
	}


	public HtmlAjaxCommandButton getCOMP_DEL_ROW() {
		return COMP_DEL_ROW;
	}


	public void setCOMP_DEL_ROW(HtmlAjaxCommandButton cOMP_DEL_ROW) {
		COMP_DEL_ROW = cOMP_DEL_ROW;
	}


	public HtmlAjaxCommandButton getCOMP_POST_ROW() {
		return COMP_POST_ROW;
	}


	public void setCOMP_POST_ROW(HtmlAjaxCommandButton cOMP_POST_ROW) {
		COMP_POST_ROW = cOMP_POST_ROW;
	}


	public List<SelectItem> getListPAFD_HEALTH_YN() {
		return listPAFD_HEALTH_YN;
	}


	public void setListPAFD_HEALTH_YN(List<SelectItem> listPAFD_HEALTH_YN) {
		this.listPAFD_HEALTH_YN = listPAFD_HEALTH_YN;
	}


	public HtmlOutputLabel getCOMP_PAFD_ADVERSITY_LABEL() {
		return COMP_PAFD_ADVERSITY_LABEL;
	}


	public void setCOMP_PAFD_ADVERSITY_LABEL(
			HtmlOutputLabel cOMP_PAFD_ADVERSITY_LABEL) {
		COMP_PAFD_ADVERSITY_LABEL = cOMP_PAFD_ADVERSITY_LABEL;
	}


	public HtmlInputText getCOMP_PAFD_ADVERSITY() {
		return COMP_PAFD_ADVERSITY;
	}


	public void setCOMP_PAFD_ADVERSITY(HtmlInputText cOMP_PAFD_ADVERSITY) {
		COMP_PAFD_ADVERSITY = cOMP_PAFD_ADVERSITY;
	}


	public HtmlOutputLabel getCOMP_PAFD_HEALTH_YN_LABEL() {
		return COMP_PAFD_HEALTH_YN_LABEL;
	}


	public void setCOMP_PAFD_HEALTH_YN_LABEL(
			HtmlOutputLabel cOMP_PAFD_HEALTH_YN_LABEL) {
		COMP_PAFD_HEALTH_YN_LABEL = cOMP_PAFD_HEALTH_YN_LABEL;
	}


	public HtmlSelectOneMenu getCOMP_PAFD_HEALTH_YN() {
		return COMP_PAFD_HEALTH_YN;
	}


	public void setCOMP_PAFD_HEALTH_YN(HtmlSelectOneMenu cOMP_PAFD_HEALTH_YN) {
		COMP_PAFD_HEALTH_YN = cOMP_PAFD_HEALTH_YN;
	}


	public HtmlOutputLabel getCOMP_PAFD_REASON_LABEL() {
		return COMP_PAFD_REASON_LABEL;
	}


	public void setCOMP_PAFD_REASON_LABEL(HtmlOutputLabel cOMP_PAFD_REASON_LABEL) {
		COMP_PAFD_REASON_LABEL = cOMP_PAFD_REASON_LABEL;
	}


	public HtmlInputText getCOMP_PAFD_REASON() {
		return COMP_PAFD_REASON;
	}


	public void setCOMP_PAFD_REASON(HtmlInputText cOMP_PAFD_REASON) {
		COMP_PAFD_REASON = cOMP_PAFD_REASON;
	}


	public List<SelectItem> getListPAFD_STATUS() {
		return listPAFD_STATUS;
	}


	public void setListPAFD_STATUS(List<SelectItem> listPAFD_STATUS) {
		this.listPAFD_STATUS = listPAFD_STATUS;
	}


	public HtmlOutputLabel getCOMP_PAFD_STATUS_LABEL() {
		return COMP_PAFD_STATUS_LABEL;
	}


	public void setCOMP_PAFD_STATUS_LABEL(HtmlOutputLabel cOMP_PAFD_STATUS_LABEL) {
		COMP_PAFD_STATUS_LABEL = cOMP_PAFD_STATUS_LABEL;
	}


	public HtmlSelectOneMenu getCOMP_PAFD_STATUS() {
		return COMP_PAFD_STATUS;
	}


	public void setCOMP_PAFD_STATUS(HtmlSelectOneMenu cOMP_PAFD_STATUS) {
		COMP_PAFD_STATUS = cOMP_PAFD_STATUS;
	}


	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public PT_IL_POL_ASSR_FAMILY_DTLS_HELPER getHelper() {
		return helper;
	}


	public void setHelper(PT_IL_POL_ASSR_FAMILY_DTLS_HELPER helper) {
		this.helper = helper;
	}


	public HtmlOutputLabel getCOMP_PAFD_AGE_LABEL() {
		return COMP_PAFD_AGE_LABEL;
	}


	public void setCOMP_PAFD_AGE_LABEL(HtmlOutputLabel cOMP_PAFD_AGE_LABEL) {
		COMP_PAFD_AGE_LABEL = cOMP_PAFD_AGE_LABEL;
	}


	public HtmlInputText getCOMP_PAFD_AGE() {
		return COMP_PAFD_AGE;
	}


	public void setCOMP_PAFD_AGE(HtmlInputText cOMP_PAFD_AGE) {
		COMP_PAFD_AGE = cOMP_PAFD_AGE;
	}


	public HtmlCommandButton getCOMP_POAC_BACK() {
		return COMP_POAC_BACK;
	}


	public void setCOMP_POAC_BACK(HtmlCommandButton cOMP_POAC_BACK) {
		COMP_POAC_BACK = cOMP_POAC_BACK;
	}


	public ArrayList<PT_IL_POL_ASSR_FAMILY_DTLS> getList() {
		return list;
	}


	public void setList(ArrayList<PT_IL_POL_ASSR_FAMILY_DTLS> list) {
		this.list = list;
	}

	public List<PT_IL_POL_ASSR_FAMILY_DTLS> getDataList_PT_IL_POL_ASSR_FAMILY_DTLS() {
		return dataList_PT_IL_POL_ASSR_FAMILY_DTLS;
	}


	public void setDataList_PT_IL_POL_ASSR_FAMILY_DTLS(
			List<PT_IL_POL_ASSR_FAMILY_DTLS> dataList_PT_IL_POL_ASSR_FAMILY_DTLS) {
		this.dataList_PT_IL_POL_ASSR_FAMILY_DTLS = dataList_PT_IL_POL_ASSR_FAMILY_DTLS;
	}


	public UIData getDataTable() {
		return dataTable;
	}


	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public List<SelectItem> getListPAFD_REL_TYPE() {
		return listPAFD_REL_TYPE;
	}


	public void setListPAFD_REL_TYPE(List<SelectItem> listPAFD_REL_TYPE) {
		this.listPAFD_REL_TYPE = listPAFD_REL_TYPE;
	}


	public HtmlOutputLabel getCOMP_PAFD_REL_TYPE_LABEL() {
		return COMP_PAFD_REL_TYPE_LABEL;
	}


	public void setCOMP_PAFD_REL_TYPE_LABEL(HtmlOutputLabel cOMP_PAFD_REL_TYPE_LABEL) {
		COMP_PAFD_REL_TYPE_LABEL = cOMP_PAFD_REL_TYPE_LABEL;
	}


	public HtmlSelectOneMenu getCOMP_PAFD_REL_TYPE() {
		return COMP_PAFD_REL_TYPE;
	}


	public void setCOMP_PAFD_REL_TYPE(HtmlSelectOneMenu cOMP_PAFD_REL_TYPE) {
		COMP_PAFD_REL_TYPE = cOMP_PAFD_REL_TYPE;
	}


	public PT_IL_POL_ASSR_FAMILY_DTLS getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN() {
		return PT_IL_POL_ASSR_FAMILY_DTLS_BEAN;
	}


	public void setPT_IL_POL_ASSR_FAMILY_DTLS_BEAN(
			PT_IL_POL_ASSR_FAMILY_DTLS pT_IL_POL_ASSR_FAMILY_DTLS_BEAN) {
		PT_IL_POL_ASSR_FAMILY_DTLS_BEAN = pT_IL_POL_ASSR_FAMILY_DTLS_BEAN;
	}


	public PT_IL_POL_ASSR_FAMILY_DTLS_ACTION() {

		PT_IL_POL_ASSR_FAMILY_DTLS_BEAN = new PT_IL_POL_ASSR_FAMILY_DTLS();
		helper = new PT_IL_POL_ASSR_FAMILY_DTLS_HELPER();
		setlistValues();
		instantiateAllComponent();


	}


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {

			if (isBlockFlag()) {

				//helper.whenNewBlockInstance(compositeAction);

				helper.executeQuery(compositeAction);

				setBlockFlag(false);
			}
			
			if(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.getPAFD_STATUS() != null && 
					PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.getPAFD_STATUS().equalsIgnoreCase("L"))
			{
				COMP_PAFD_REASON.setDisabled(true);
			}
			else
			{
				COMP_PAFD_REASON.setDisabled(false);
			}
			
			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("Y")) ||
					CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS(),"N").equalsIgnoreCase("A"))
			{
				disableAllComponent(true);
				
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


	public void setlistValues() {

		try {
			setListPAFD_REL_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSR_FAMILY_DTLS",
					"PT_IL_POL_ASSR_FAMILY_DTLS.PAFD_REL_TYPE",
					"IL_ASSR_MEMB"));
			
			setListPAFD_STATUS(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSR_FAMILY_DTLS",
					"PT_IL_POL_ASSR_FAMILY_DTLS.PAFD_STATUS",
					"IL_ASSR_STAT"));
			
			setListPAFD_HEALTH_YN(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS",
					"PT_IL_POL_ASSURED_DTLS.POAD_ALCHOHALIC_YN",
					"YESNO"));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void instantiateAllComponent() {

		COMP_PAFD_REL_TYPE_LABEL = new HtmlOutputLabel();
		COMP_PAFD_REL_TYPE = new HtmlSelectOneMenu();
		COMP_PAFD_AGE_LABEL = new HtmlOutputLabel();
		COMP_PAFD_AGE = new HtmlInputText();
		COMP_POAC_BACK = new HtmlCommandButton();
		COMP_PAFD_REASON_LABEL = new HtmlOutputLabel();
		COMP_PAFD_REASON = new HtmlInputText();
		COMP_PAFD_HEALTH_YN_LABEL = new HtmlOutputLabel();
		COMP_PAFD_HEALTH_YN = new HtmlSelectOneMenu();
		COMP_PAFD_ADVERSITY_LABEL = new HtmlOutputLabel();
		COMP_PAFD_ADVERSITY = new HtmlInputText();
		COMP_PAFD_STATUS = new HtmlSelectOneMenu();
		COMP_ADD_ROW = new HtmlAjaxCommandButton();
		COMP_DEL_ROW = new HtmlAjaxCommandButton();
		COMP_POST_ROW = new HtmlAjaxCommandButton();
	}

	
	public void resetAllComponent() {
		
		COMP_PAFD_REL_TYPE.resetValue();
		COMP_PAFD_AGE.resetValue();
		COMP_PAFD_REASON.resetValue();
		COMP_PAFD_HEALTH_YN.resetValue();
		COMP_PAFD_ADVERSITY.resetValue();
		COMP_PAFD_STATUS.resetValue();
		
	}
	
	public void disableAllComponent(boolean disabled){
			
		COMP_PAFD_REL_TYPE.setDisabled(disabled);
		COMP_PAFD_AGE.setDisabled(disabled);
		COMP_PAFD_REASON.setDisabled(disabled);
		COMP_PAFD_HEALTH_YN.setDisabled(disabled);
		COMP_PAFD_ADVERSITY.setDisabled(disabled);
		COMP_PAFD_STATUS.setDisabled(disabled);
		COMP_ADD_ROW.setDisabled(disabled);
		COMP_DEL_ROW.setDisabled(disabled);
		COMP_POST_ROW.setDisabled(disabled);
	}

	public String back(){
		String outcome = null;
		this.setBlockFlag(true);
		compositeAction.getPT_IL_POL_ASSR_FAMILY_DTLS_ACTION_BEAN().setBlockFlag(true);
		outcome = "PILT002_APAC_PT_IL_POL_ASSURED_DTLS";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN = (PT_IL_POL_ASSR_FAMILY_DTLS) dataTable
			.getRowData();
			//helper.postQuery(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN);
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}


	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();


			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN,compositeAction);
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN = new PT_IL_POL_ASSR_FAMILY_DTLS();
				resetAllComponent();
				resetSelectedRow();

			} else {
				getErrorMap().put("addRow",
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
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}


	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {


				new CRUDHandler().executeDelete(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN,
						CommonUtils.getConnection());
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
				dataList_PT_IL_POL_ASSR_FAMILY_DTLS
				.remove(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN);
				if (dataList_PT_IL_POL_ASSR_FAMILY_DTLS.size() > 0) {

					PT_IL_POL_ASSR_FAMILY_DTLS_BEAN = dataList_PT_IL_POL_ASSR_FAMILY_DTLS
					.get(0);
				} else if (dataList_PT_IL_POL_ASSR_FAMILY_DTLS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setRowSelected(true);
			

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


			CommonUtils.getConnection().commit();
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public String postRecord() {
		String message = null;
		try {
			if (PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(compositeAction,PT_IL_POL_ASSR_FAMILY_DTLS_BEAN);
			
				new CRUDHandler().executeInsert(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN,
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
				
				dataList_PT_IL_POL_ASSR_FAMILY_DTLS
				.add(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN);
				
			}
			else if (PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				helper.preUpdate(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN);
				
				new CRUDHandler().executeUpdate(PT_IL_POL_ASSR_FAMILY_DTLS_BEAN,
						CommonUtils.getConnection());
			
				getWarningMap().put("SAVE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
			}
			
			CommonUtils.getConnection().commit();
		
			PT_IL_POL_ASSR_FAMILY_DTLS_BEAN.setRowSelected(true);

		} catch (Exception exc) {
			exc.printStackTrace(); 
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		return "";

	}


	public void saveRecord() {
		String message = null;
		try {


		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	
	private void resetSelectedRow() {
		Iterator<PT_IL_POL_ASSR_FAMILY_DTLS> PT_IL_POL_ASSR_FAMILY_DTLS_ITR = dataList_PT_IL_POL_ASSR_FAMILY_DTLS.iterator();
		while (PT_IL_POL_ASSR_FAMILY_DTLS_ITR.hasNext()) {
			PT_IL_POL_ASSR_FAMILY_DTLS_ITR.next().setRowSelected(false);
		}
	}
	
	

	public void PAFD_REL_TYPE_WHEN_LIST_CHANGED(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().setPAFD_REL_TYPE((String) value);

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PAFD_AGE_Validator(FacesContext context,
			UIComponent component, Object value){

		int min_age = 0;
		int max_age = 99;
		int age = (int) value;
		
		try {
			
			System.out.println("age                  "+age);
			if(age > max_age || age < min_age)
			{
				throw new Exception("Age should be between 0 to 99");
			}else
			{
			
				getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().setPAFD_AGE((int) age);
			
			}
			
			System.out.println("getPAFD_AGE                    "+getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().getPAFD_AGE());
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public void PAFD_STATUS_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().setPAFD_STATUS((String) value);
			
			System.out.println("getPAFD_STATUS              "+getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().getPAFD_STATUS());
			
			if(getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().getPAFD_STATUS().equalsIgnoreCase("L"))
			{
				COMP_PAFD_REASON.setDisabled(true);
			}
			else
			{
				COMP_PAFD_REASON.setDisabled(false);
			}
			

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PAFD_REASON_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().setPAFD_REASON((String) value);

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void PAFD_HEALTH_YN_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().setPAFD_HEALTH_YN((String) value);

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PAFD_ADVERSITY_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_FAMILY_DTLS_BEAN().setPAFD_ADVERSITY((String) value);

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}