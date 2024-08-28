package com.iii.pel.forms.PILM107;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;







import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PM006_A_APAC.PM006_A_APAC_DELEGATE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_BANK_ACTION extends CommonAction{

	public PILM107_COMPOSITE_ACTION compositeAction;
	
	private PM_BANK_HELPER helper;
	
	private PM_BANK_DELEGATE delegate;
	
	private PM_BANK PM_BANK_BEAN;
	
	
	public PM_BANK_ACTION()
	{
		PM_BANK_BEAN=new PM_BANK();
		helper=new PM_BANK_HELPER();
		delegate=new PM_BANK_DELEGATE();
		/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
		initializeAllComponents();
		
		itemListName = getDropDownListValue(
				"PILM107", "PM_BANK", "PM_BANK.BANK_FLEX_10",
				"TITLE");
		/*end*/
	}
	
	public void onLoad(PhaseEvent event){
		try {
			if(isBlockFlag())
			{
				helper.executeQuery(compositeAction);
				/*Added by ganesh on 30-5-2017, ZBILQC-1724500, to resolve in edit mode use */
				if(PM_BANK_BEAN.getROWID()==null){
					helper.whenNewCreateInstance(compositeAction);
				}
				/*end*/
				setBlockFlag(false);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private HtmlInputText COMP_BANK_CODE;
	
	private HtmlInputText COMP_BANK_NAME;
	
	private HtmlInputText COMP_BANK_UNIVERSAL_CODE;
	
	private HtmlInputText COMP_BANK_BR_CODE;
	
	private HtmlInputText COMP_BANK_SHORT_NAME;
	
	private HtmlInputText COMP_BANK_ADDR1;
	
	private HtmlInputText COMP_BANK_ADDR2;
	
	private HtmlInputText COMP_BANK_ADDR3;
	
	private HtmlInputText COMP_BANK_ZIP;
	
	private HtmlInputText COMP_BANK_PHONE;
	
	private HtmlInputText COMP_BANK_FAX;
	
	private HtmlInputText COMP_BANK_EMAIL;
	
	private HtmlInputText COMP_BANK_WEB_SITE;
	
	private HtmlInputText COMP_BANK_SWIFT_CODE;
	
	private HtmlSelectBooleanCheckbox COMP_BANK_FRZ_FLAG_NUM;
	
	private List<PM_BANK> dataTableList = new ArrayList<PM_BANK>();

	private UIData dataTable;

	public HtmlSelectBooleanCheckbox getCOMP_BANK_FRZ_FLAG_NUM() {
		return COMP_BANK_FRZ_FLAG_NUM;
	}

	public void setCOMP_BANK_FRZ_FLAG_NUM(
			HtmlSelectBooleanCheckbox cOMP_BANK_FRZ_FLAG_NUM) {
		COMP_BANK_FRZ_FLAG_NUM = cOMP_BANK_FRZ_FLAG_NUM;
	}

		
	public List<PM_BANK> getDataTableList() {
		return dataTableList;
	}

	public void setDataTableList(List<PM_BANK> dataTableList) {
		this.dataTableList = dataTableList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PM_BANK getPM_BANK_BEAN() {
		return PM_BANK_BEAN;
	}

	public void setPM_BANK_BEAN(PM_BANK pM_BANK_BEAN) {
		PM_BANK_BEAN = pM_BANK_BEAN;
	}

	public HtmlInputText getCOMP_BANK_CODE() {
		return COMP_BANK_CODE;
	}

	public void setCOMP_BANK_CODE(HtmlInputText cOMP_BANK_CODE) {
		COMP_BANK_CODE = cOMP_BANK_CODE;
	}

	public HtmlInputText getCOMP_BANK_NAME() {
		return COMP_BANK_NAME;
	}

	public void setCOMP_BANK_NAME(HtmlInputText cOMP_BANK_NAME) {
		COMP_BANK_NAME = cOMP_BANK_NAME;
	}

	public HtmlInputText getCOMP_BANK_UNIVERSAL_CODE() {
		return COMP_BANK_UNIVERSAL_CODE;
	}

	public void setCOMP_BANK_UNIVERSAL_CODE(HtmlInputText cOMP_BANK_UNIVERSAL_CODE) {
		COMP_BANK_UNIVERSAL_CODE = cOMP_BANK_UNIVERSAL_CODE;
	}

	public HtmlInputText getCOMP_BANK_BR_CODE() {
		return COMP_BANK_BR_CODE;
	}

	public void setCOMP_BANK_BR_CODE(HtmlInputText cOMP_BANK_BR_CODE) {
		COMP_BANK_BR_CODE = cOMP_BANK_BR_CODE;
	}

	public HtmlInputText getCOMP_BANK_SHORT_NAME() {
		return COMP_BANK_SHORT_NAME;
	}

	public void setCOMP_BANK_SHORT_NAME(HtmlInputText cOMP_BANK_SHORT_NAME) {
		COMP_BANK_SHORT_NAME = cOMP_BANK_SHORT_NAME;
	}

	public HtmlInputText getCOMP_BANK_ADDR1() {
		return COMP_BANK_ADDR1;
	}

	public void setCOMP_BANK_ADDR1(HtmlInputText cOMP_BANK_ADDR1) {
		COMP_BANK_ADDR1 = cOMP_BANK_ADDR1;
	}

	public HtmlInputText getCOMP_BANK_ADDR2() {
		return COMP_BANK_ADDR2;
	}

	public void setCOMP_BANK_ADDR2(HtmlInputText cOMP_BANK_ADDR2) {
		COMP_BANK_ADDR2 = cOMP_BANK_ADDR2;
	}

	public HtmlInputText getCOMP_BANK_ADDR3() {
		return COMP_BANK_ADDR3;
	}

	public void setCOMP_BANK_ADDR3(HtmlInputText cOMP_BANK_ADDR3) {
		COMP_BANK_ADDR3 = cOMP_BANK_ADDR3;
	}

	public HtmlInputText getCOMP_BANK_ZIP() {
		return COMP_BANK_ZIP;
	}

	public void setCOMP_BANK_ZIP(HtmlInputText cOMP_BANK_ZIP) {
		COMP_BANK_ZIP = cOMP_BANK_ZIP;
	}

	public HtmlInputText getCOMP_BANK_PHONE() {
		return COMP_BANK_PHONE;
	}

	public void setCOMP_BANK_PHONE(HtmlInputText cOMP_BANK_PHONE) {
		COMP_BANK_PHONE = cOMP_BANK_PHONE;
	}

	public HtmlInputText getCOMP_BANK_FAX() {
		return COMP_BANK_FAX;
	}

	public void setCOMP_BANK_FAX(HtmlInputText cOMP_BANK_FAX) {
		COMP_BANK_FAX = cOMP_BANK_FAX;
	}

	public HtmlInputText getCOMP_BANK_EMAIL() {
		return COMP_BANK_EMAIL;
	}

	public void setCOMP_BANK_EMAIL(HtmlInputText cOMP_BANK_EMAIL) {
		COMP_BANK_EMAIL = cOMP_BANK_EMAIL;
	}

	public HtmlInputText getCOMP_BANK_WEB_SITE() {
		return COMP_BANK_WEB_SITE;
	}

	public void setCOMP_BANK_WEB_SITE(HtmlInputText cOMP_BANK_WEB_SITE) {
		COMP_BANK_WEB_SITE = cOMP_BANK_WEB_SITE;
	}

	public HtmlInputText getCOMP_BANK_SWIFT_CODE() {
		return COMP_BANK_SWIFT_CODE;
	}

	public void setCOMP_BANK_SWIFT_CODE(HtmlInputText cOMP_BANK_SWIFT_CODE) {
		COMP_BANK_SWIFT_CODE = cOMP_BANK_SWIFT_CODE;
	}
	
	public void resetAllComponent()
	{
		COMP_BANK_CODE.resetValue();
		COMP_BANK_NAME.resetValue();
		COMP_BANK_UNIVERSAL_CODE.resetValue();
		COMP_BANK_BR_CODE.resetValue();
		COMP_BANK_SHORT_NAME.resetValue();
		COMP_BANK_ADDR1.resetValue();
		COMP_BANK_ADDR2.resetValue();
		COMP_BANK_ADDR3.resetValue();
		COMP_BANK_ZIP.resetValue();
		COMP_BANK_PHONE.resetValue();
		COMP_BANK_FAX.resetValue();
		COMP_BANK_EMAIL.resetValue();
		COMP_BANK_WEB_SITE.resetValue();
		COMP_BANK_SWIFT_CODE.resetValue();
		COMP_BANK_FRZ_FLAG_NUM.resetValue();
		/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
		COMP_BANK_CONTACT_PERSON.resetValue();
		COMP_BANK_MOBILE.resetValue();
		COMP_BANK_SORT_CODE.resetValue();
		COMP_BANK_LEAD_TIME.resetValue();
		/*end*/
		/*Added by ganesh on 26-10-2017, bank issue details */
		COMP_BANK_ACCOUNT_NO.resetValue();
		COMP_BANK_COLLECTION_COMMSN.resetValue();
		COMP_BANK_PHONE_AREA_CODE.resetValue();
		COMP_BANK_MOBILE_AREA_CODE.resetValue();
		COMP_BANK_FAX_AREA_CODE.resetValue();
		COMP_BANK_CONTACT_TITLE.resetValue();
		/*end*/
	}
	
	public void initializeAllComponents()
	{
		COMP_BANK_CODE=new HtmlInputText();
		COMP_BANK_NAME=new HtmlInputText();
		COMP_BANK_UNIVERSAL_CODE=new HtmlInputText();
		COMP_BANK_BR_CODE=new HtmlInputText();
		COMP_BANK_SHORT_NAME=new HtmlInputText();
		COMP_BANK_ADDR1=new HtmlInputText();
		COMP_BANK_ADDR2=new HtmlInputText();
		COMP_BANK_ADDR3=new HtmlInputText();
		COMP_BANK_ZIP=new HtmlInputText();
		COMP_BANK_PHONE=new HtmlInputText();
		COMP_BANK_FAX=new HtmlInputText();
		COMP_BANK_EMAIL=new HtmlInputText(); 
		COMP_BANK_WEB_SITE=new HtmlInputText();
		COMP_BANK_SWIFT_CODE=new HtmlInputText();
		COMP_BANK_FRZ_FLAG_NUM=new HtmlSelectBooleanCheckbox(); 
		/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
		COMP_BANK_CONTACT_PERSON = new HtmlInputText();
		COMP_BANK_MOBILE = new HtmlInputText();
		COMP_BANK_SORT_CODE = new HtmlInputText();
		COMP_BANK_LEAD_TIME = new HtmlInputText();
		/*end*/
		
		/*Added by ganesh on 26-10-2017 for bank issue details*/
		COMP_BANK_ACCOUNT_NO = new HtmlInputText();
		COMP_BANK_COLLECTION_COMMSN = new HtmlInputText();
		COMP_BANK_PHONE_AREA_CODE = new HtmlInputText();
		COMP_BANK_MOBILE_AREA_CODE = new HtmlInputText();
		COMP_BANK_FAX_AREA_CODE = new HtmlInputText();
		itemListName = new ArrayList<SelectItem>();
		COMP_BANK_CONTACT_TITLE = new HtmlSelectOneMenu();
		/*end*/
	}
	
	
	private void resetSelectedRow() {
		Iterator<PM_BANK> PM_BANK_ITR = dataTableList.iterator();
		while (PM_BANK_ITR.hasNext()) {
			PM_BANK_ITR.next().setRowSelected(false);
		}
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_BANK_BEAN = (PM_BANK) dataTable.getRowData();
			/*Added by ganesh on 26-10-2017, bank issue details */
			compositeAction.getPM_BANK_ACTION_BEAN().getCOMP_BANK_FRZ_FLAG_NUM().setSelected(PM_BANK_BEAN.isUI_M_FREEZE());
			disableAllComponents(PM_BANK_BEAN.isUI_M_FREEZE());
			/*compositeAction.getPM_BANK_BRANCH_ACTION_BEAN().setINSERT_ALLOWED(!PM_BANK_BEAN.isUI_M_FREEZE());
			compositeAction.getPM_BANK_BRANCH_ACTION_BEAN().setUPDATE_ALLOWED(!PM_BANK_BEAN.isUI_M_FREEZE());
			compositeAction.getPM_BANK_BRANCH_ACTION_BEAN().setDELETE_ALLOWED(!PM_BANK_BEAN.isUI_M_FREEZE());
			compositeAction.getPM_BANK_BRANCH_ACTION_BEAN().disableAllComponents(PM_BANK_BEAN.isUI_M_FREEZE());*/
			/*end*/
			PM_BANK_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	
	public void addRow(ActionEvent event) {
		String message = null;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PM_BANK_BEAN = new PM_BANK();
				/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
				helper.whenNewCreateInstance(compositeAction);
				/*end*/
				disableAllComponents(false);
				resetAllComponent();
				resetSelectedRow();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"); 
				getErrorMap().put("addRow",message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			}

		} catch (Exception exc) {
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
			exc.printStackTrace();
		}

	}
	
	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
		
				new CRUDHandler().executeDelete(PM_BANK_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"); 
				dataTableList.remove(PM_BANK_BEAN);
				if (dataTableList.size() > 0) {
					PM_BANK_BEAN = dataTableList.get(0);
				} 
				/* commented by R. Raja on 02-12-2016 for RM018T - FSD_IL_ZB Life_020-Beneficiary and Assignee*/
				else if (dataTableList.size() == 0) {
				addRow(null);
			}
				/*end*/
				resetAllComponent();
				PM_BANK_BEAN.setRowSelected(true);
				CommonUtils.getConnection().commit();
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"); 
			}

			getWarningMap().put("deleteRow",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}
	
	public void saveRecords(ActionEvent event) {
		String message = null;
		CommonUtils.clearMaps(this);
		try {
			if (PM_BANK_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preinsert(this,PM_BANK_BEAN);
				new CRUDHandler().executeInsert(PM_BANK_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				dataTableList.add(PM_BANK_BEAN);

			} else if (PM_BANK_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {
				
				new CRUDHandler().executeUpdate(PM_BANK_BEAN,CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			}
						
			PM_BANK_BEAN.setRowSelected(true);
	
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().put("SAVE",message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validatorBANK_PHONE(FacesContext context,
			UIComponent component, Object value){

		try {
			helper.BANK_PHONE_WHEN_VALIDATE_ITEM(value.toString());
			PM_BANK_BEAN.setBANK_PHONE((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
	public void validatorBANK_CODE(FacesContext context,
			UIComponent component, Object value){

		try {
			CommonUtils.clearMaps(this);
			PM_BANK_BEAN.setBANK_CODE((String) value);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validatorBANK_NAME(FacesContext context,
			UIComponent component, Object value){

		try {
			String short_desc=null;
			CommonUtils.clearMaps(this);
			PM_BANK_BEAN.setBANK_NAME((String) value);
			if(PM_BANK_BEAN.getBANK_NAME().length()>30)
			{
			short_desc=PM_BANK_BEAN.getBANK_NAME().substring(0, 29);
			System.out.println("short_desc  ===> "+short_desc);
			PM_BANK_BEAN.setBANK_SHORT_NAME(short_desc);
			}
			else
			{
				PM_BANK_BEAN.setBANK_SHORT_NAME(PM_BANK_BEAN.getBANK_NAME());
			}
			COMP_BANK_SHORT_NAME.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public void validateBANK_FRZ_FLAG_NUM(ActionEvent event){

		try {
			String short_desc=null;
			CommonUtils.clearMaps(this);
			PM_BANK_BEAN.setUI_M_FREEZE((Boolean)COMP_BANK_FRZ_FLAG_NUM.getSubmittedValue());
			if(PM_BANK_BEAN.isUI_M_FREEZE()){
				disableAllComponents(true);
			}else{
				disableAllComponents(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}

	
	
	
	/*Added by Raja on 13/04/2017*/
	public void validatorBANK_UNIVERSAL_CODE(FacesContext context,UIComponent component, Object value)
	{
		try {
			String validBankUniversalCodeQuery ="";
			Object[] objParam={};
			/*Modified by ganesh on 30-05-2017, for invalid bank even in edit mode. ZBILQC-1724500*/
			/*String query="select 'X' from pm_bank where BANK_UNIVERSAL_CODE=?";
			ResultSet resultset=new CRUDHandler().executeSelectStatement(
					query, CommonUtils.getConnection(), new Object[]{value.toString()});*/
			
			if(PM_BANK_BEAN.getROWID()==null){
				validBankUniversalCodeQuery = "select 'X' from pm_bank where BANK_UNIVERSAL_CODE=?";
				objParam = new Object[]{value.toString()}; 
			}else{
				validBankUniversalCodeQuery = "select 'X' from pm_bank where BANK_UNIVERSAL_CODE=? and ROWID <> ?";
				objParam = new Object[]{value.toString(), PM_BANK_BEAN.getROWID()}; 
			}
			ResultSet resultset=new CRUDHandler().executeSelectStatement(
					validBankUniversalCodeQuery, CommonUtils.getConnection(), objParam);
			/*end*/
			if(resultset.next())
			{
				throw new Exception("Duplicate Bank ID");
			}
			
			PM_BANK_BEAN.setUI_M_FREEZE((Boolean)COMP_BANK_FRZ_FLAG_NUM.isSelected());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	/*End*/
	
	/*Added by ganesh on 30-5-2017, ZBILQC-1724500 */
	private HtmlInputText COMP_BANK_CONTACT_PERSON;
	private HtmlInputText COMP_BANK_MOBILE;
	private HtmlInputText COMP_BANK_SORT_CODE;
	private HtmlInputText COMP_BANK_LEAD_TIME;


	public HtmlInputText getCOMP_BANK_CONTACT_PERSON() {
		return COMP_BANK_CONTACT_PERSON;
	}

	public void setCOMP_BANK_CONTACT_PERSON(HtmlInputText cOMP_BANK_CONTACT_PERSON) {
		COMP_BANK_CONTACT_PERSON = cOMP_BANK_CONTACT_PERSON;
	}

	public HtmlInputText getCOMP_BANK_MOBILE() {
		return COMP_BANK_MOBILE;
	}

	public void setCOMP_BANK_MOBILE(HtmlInputText cOMP_BANK_MOBILE) {
		COMP_BANK_MOBILE = cOMP_BANK_MOBILE;
	}

	public HtmlInputText getCOMP_BANK_SORT_CODE() {
		return COMP_BANK_SORT_CODE;
	}

	public void setCOMP_BANK_SORT_CODE(HtmlInputText cOMP_BANK_SORT_CODE) {
		COMP_BANK_SORT_CODE = cOMP_BANK_SORT_CODE;
	}

	public HtmlInputText getCOMP_BANK_LEAD_TIME() {
		return COMP_BANK_LEAD_TIME;
	}

	public void setCOMP_BANK_LEAD_TIME(HtmlInputText cOMP_BANK_LEAD_TIME) {
		COMP_BANK_LEAD_TIME = cOMP_BANK_LEAD_TIME;
	} 
	/*end*/
	
	//Added by ganesh on 26-10-2017 for bank detail requirment 
	public String applBranch(){
		
		compositeAction.getPM_BANK_BRANCH_ACTION_BEAN().setBlockFlag(true);
		return "PILM107_PM_IL_BANK_BRANCH";
		
	}
	
	private HtmlInputText COMP_BANK_ACCOUNT_NO;
	private HtmlInputText COMP_BANK_COLLECTION_COMMSN;


	public HtmlInputText getCOMP_BANK_ACCOUNT_NO() {
		return COMP_BANK_ACCOUNT_NO;
	}

	public void setCOMP_BANK_ACCOUNT_NO(HtmlInputText cOMP_BANK_ACCOUNT_NO) {
		COMP_BANK_ACCOUNT_NO = cOMP_BANK_ACCOUNT_NO;
	}

	public HtmlInputText getCOMP_BANK_COLLECTION_COMMSN() {
		return COMP_BANK_COLLECTION_COMMSN;
	}

	public void setCOMP_BANK_COLLECTION_COMMSN(
			HtmlInputText cOMP_BANK_COLLECTION_COMMSN) {
		COMP_BANK_COLLECTION_COMMSN = cOMP_BANK_COLLECTION_COMMSN;
	}
	
	private HtmlInputText COMP_BANK_PHONE_AREA_CODE;
	private HtmlInputText COMP_BANK_MOBILE_AREA_CODE;
	private HtmlInputText COMP_BANK_FAX_AREA_CODE;


	public HtmlInputText getCOMP_BANK_PHONE_AREA_CODE() {
		return COMP_BANK_PHONE_AREA_CODE;
	}

	public void setCOMP_BANK_PHONE_AREA_CODE(HtmlInputText cOMP_BANK_PHONE_AREA_CODE) {
		COMP_BANK_PHONE_AREA_CODE = cOMP_BANK_PHONE_AREA_CODE;
	}

	public HtmlInputText getCOMP_BANK_MOBILE_AREA_CODE() {
		return COMP_BANK_MOBILE_AREA_CODE;
	}

	public void setCOMP_BANK_MOBILE_AREA_CODE(
			HtmlInputText cOMP_BANK_MOBILE_AREA_CODE) {
		COMP_BANK_MOBILE_AREA_CODE = cOMP_BANK_MOBILE_AREA_CODE;
	}

	public HtmlInputText getCOMP_BANK_FAX_AREA_CODE() {
		return COMP_BANK_FAX_AREA_CODE;
	}

	public void setCOMP_BANK_FAX_AREA_CODE(HtmlInputText cOMP_BANK_FAX_AREA_CODE) {
		COMP_BANK_FAX_AREA_CODE = cOMP_BANK_FAX_AREA_CODE;
	}
	public void disableAllComponents(boolean disabled)
	{
		COMP_BANK_CODE.setDisabled(disabled);
		COMP_BANK_NAME.setDisabled(disabled);
		COMP_BANK_UNIVERSAL_CODE.setDisabled(disabled);
		COMP_BANK_BR_CODE.setDisabled(disabled);
		COMP_BANK_SHORT_NAME.setDisabled(disabled);
		COMP_BANK_ADDR1.setDisabled(disabled);
		COMP_BANK_ADDR2.setDisabled(disabled);
		COMP_BANK_ADDR3.setDisabled(disabled);
		COMP_BANK_ZIP.setDisabled(disabled);
		COMP_BANK_PHONE.setDisabled(disabled);
		COMP_BANK_FAX.setDisabled(disabled);
		COMP_BANK_EMAIL.setDisabled(disabled);
		COMP_BANK_WEB_SITE.setDisabled(disabled);
		COMP_BANK_SWIFT_CODE.setDisabled(disabled);
		//COMP_BANK_FRZ_FLAG_NUM.setDisabled(disabled);		
		COMP_BANK_CONTACT_PERSON.setDisabled(disabled);
		COMP_BANK_MOBILE.setDisabled(disabled);
		COMP_BANK_SORT_CODE.setDisabled(disabled);
		COMP_BANK_LEAD_TIME.setDisabled(disabled);
		COMP_BANK_ACCOUNT_NO.setDisabled(disabled);
		COMP_BANK_COLLECTION_COMMSN.setDisabled(disabled);
		COMP_BANK_PHONE_AREA_CODE.setDisabled(disabled);
		COMP_BANK_MOBILE_AREA_CODE.setDisabled(disabled);
		COMP_BANK_FAX_AREA_CODE.setDisabled(disabled);	
		COMP_BANK_CONTACT_TITLE.setDisabled(disabled);
	}
	
	List<SelectItem> itemListName = null;
	public List<SelectItem> getItemListName() {
		return itemListName;
	}

	public void setItemListName(List<SelectItem> itemListName) {
		this.itemListName = itemListName;
	}

	public void validatorBANK_CONTACT_TITLE(FacesContext context, UIComponent component,
			Object value) {
		try {	
			PM_BANK_BEAN.setBANK_CONTACT_TITLE((String)value);
			
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public static List<SelectItem> getDropDownListValue(String formName,
			String blockName, String blockFieldName, String filedName) {
		List<SelectItem> listValues = null;
		try {
			listValues = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), formName, blockName, blockFieldName,filedName);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return listValues;
	}
	private HtmlSelectOneMenu COMP_BANK_CONTACT_TITLE;


	public HtmlSelectOneMenu getCOMP_BANK_CONTACT_TITLE() {
		return COMP_BANK_CONTACT_TITLE;
	}

	public void setCOMP_BANK_CONTACT_TITLE(HtmlSelectOneMenu cOMP_BANK_CONTACT_TITLE) {
		COMP_BANK_CONTACT_TITLE = cOMP_BANK_CONTACT_TITLE;
	}
	
}


