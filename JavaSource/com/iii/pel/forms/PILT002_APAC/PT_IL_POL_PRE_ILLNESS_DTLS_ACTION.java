package com.iii.pel.forms.PILT002_APAC;

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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_PRE_ILLNESS_DTLS_ACTION extends CommonAction {

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;
	private List<PT_IL_POL_PRE_ILLNESS_DTLS> dataList_PT_IL_POL_PRE_ILLNESS_DTLS = new ArrayList<PT_IL_POL_PRE_ILLNESS_DTLS>();
	private PT_IL_POL_PRE_ILLNESS_DTLS  PT_IL_POL_PRE_ILLNESS_DTLS_BEAN;
	private PT_IL_POL_PRE_ILLNESS_DTLS_DELEGATE delegate; 
	private PT_IL_POL_PRE_ILLNESS_DTLS_HELPER helper; 
	private HtmlCalendar COMP_PPID_PRE_ILNS_DT;
	private HtmlOutputLabel COMP_PPID_PRE_ILNS_DT_LABLE;
	private HtmlOutputLabel COMP_PPID_PRE_ILNS_CODE_LABLE;
	private HtmlInputText COMP_PPID_PRE_ILNS_CODE;
	private HtmlInputText COMP_UI_PPID_PRE_ILNS_CODE_DESC;
	private UIData dataTable;
	private HtmlCommandButton COMP_POAC_BACK;
	public HtmlCommandButton getCOMP_POAC_BACK() {
		return COMP_POAC_BACK;
	}



	public void setCOMP_POAC_BACK(HtmlCommandButton cOMP_POAC_BACK) {
		COMP_POAC_BACK = cOMP_POAC_BACK;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public PT_IL_POL_PRE_ILLNESS_DTLS_ACTION()
	{
		PT_IL_POL_PRE_ILLNESS_DTLS_BEAN=new PT_IL_POL_PRE_ILLNESS_DTLS();

		helper=new PT_IL_POL_PRE_ILLNESS_DTLS_HELPER();
		initiateAllComponents();
	}

	void initiateAllComponents(){
		COMP_PPID_PRE_ILNS_DT= new HtmlCalendar(); 
		COMP_PPID_PRE_ILNS_CODE =new HtmlInputText();
		COMP_PPID_PRE_ILNS_CODE_LABLE = new HtmlOutputLabel();
		COMP_PPID_PRE_ILNS_DT_LABLE = new HtmlOutputLabel();
		COMP_UI_PPID_PRE_ILNS_CODE_DESC=new HtmlInputText();
		COMP_POAC_BACK=new HtmlCommandButton();
	}

	
	public String back(){
		String outcome = null;
	
		compositeAction.getPT_IL_POL_FUNERAL_MEMB_DTLS_ACTION_BEAN().setBlockFlag(true);
		outcome = "PILT002_APAC_PT_IL_POL_FUNERAL_MEMB_DTLS";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}
	public HtmlInputText getCOMP_UI_PPID_PRE_ILNS_CODE_DESC() {
		return COMP_UI_PPID_PRE_ILNS_CODE_DESC;
	}

	public void setCOMP_UI_PPID_PRE_ILNS_CODE_DESC(
			HtmlInputText cOMP_UI_PPID_PRE_ILNS_CODE_DESC) {
		COMP_UI_PPID_PRE_ILNS_CODE_DESC = cOMP_UI_PPID_PRE_ILNS_CODE_DESC;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetAllComponent();
			resetRowAtCreate();
			PT_IL_POL_PRE_ILLNESS_DTLS_BEAN = (PT_IL_POL_PRE_ILLNESS_DTLS) dataTable
					.getRowData();
			
			PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	


	public HtmlCalendar getCOMP_PPID_PRE_ILNS_DT() {
		return COMP_PPID_PRE_ILNS_DT;
	}

	public void setCOMP_PPID_PRE_ILNS_DT(HtmlCalendar cOMP_PPID_PRE_ILNS_DT) {
		COMP_PPID_PRE_ILNS_DT = cOMP_PPID_PRE_ILNS_DT;
	}

	public HtmlOutputLabel getCOMP_PPID_PRE_ILNS_DT_LABLE() {
		return COMP_PPID_PRE_ILNS_DT_LABLE;
	}

	public void setCOMP_PPID_PRE_ILNS_DT_LABLE(
			HtmlOutputLabel cOMP_PPID_PRE_ILNS_DT_LABLE) {
		COMP_PPID_PRE_ILNS_DT_LABLE = cOMP_PPID_PRE_ILNS_DT_LABLE;
	}

	public HtmlOutputLabel getCOMP_PPID_PRE_ILNS_CODE_LABLE() {
		return COMP_PPID_PRE_ILNS_CODE_LABLE;
	}

	public void setCOMP_PPID_PRE_ILNS_CODE_LABLE(
			HtmlOutputLabel cOMP_PPID_PRE_ILNS_CODE_LABLE) {
		COMP_PPID_PRE_ILNS_CODE_LABLE = cOMP_PPID_PRE_ILNS_CODE_LABLE;
	}

	public HtmlInputText getCOMP_PPID_PRE_ILNS_CODE() {
		return COMP_PPID_PRE_ILNS_CODE;
	}

	public void setCOMP_PPID_PRE_ILNS_CODE(HtmlInputText cOMP_PPID_PRE_ILNS_CODE) {
		COMP_PPID_PRE_ILNS_CODE = cOMP_PPID_PRE_ILNS_CODE;
	}

	public PT_IL_POL_PRE_ILLNESS_DTLS getPT_IL_POL_PRE_ILLNESS_DTLS_BEAN() {
		return PT_IL_POL_PRE_ILLNESS_DTLS_BEAN;
	}

	public void setPT_IL_POL_PRE_ILLNESS_DTLS_BEAN(
			PT_IL_POL_PRE_ILLNESS_DTLS pT_IL_POL_PRE_ILLNESS_DTLS_BEAN) {
		PT_IL_POL_PRE_ILLNESS_DTLS_BEAN = pT_IL_POL_PRE_ILLNESS_DTLS_BEAN;
	}

	public List<PT_IL_POL_PRE_ILLNESS_DTLS> getDataList_PT_IL_POL_PRE_ILLNESS_DTLS() {
		return dataList_PT_IL_POL_PRE_ILLNESS_DTLS;
	}

	public void setDataList_PT_IL_POL_PRE_ILLNESS_DTLS(
			List<PT_IL_POL_PRE_ILLNESS_DTLS> dataList_PT_IL_POL_PRE_ILLNESS_DTLS) {
		this.dataList_PT_IL_POL_PRE_ILLNESS_DTLS = dataList_PT_IL_POL_PRE_ILLNESS_DTLS;
	}
	
	
	public void onLoad(PhaseEvent event) {
		try {


			if (isBlockFlag()) {
				getErrorMap().clear();
				getWarningMap().clear();
				helper.executeQuery(compositeAction);
				
				if (PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.getROWID() == null) {
					/*Added by Ameen on 31-05-2016 as per siva sugg.*/
					addRow(null);
					/*End*/
					helper.preInsert(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN,compositeAction);
					resetAllComponent();
				}
				/*Added by Ameen on 31-05-2016 as per siva sugg.*/
				if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
					{
						setINSERT_ALLOWED(false);
						setUPDATE_ALLOWED(false);
						setDELETE_ALLOWED(false);
						COMP_PPID_PRE_ILNS_CODE.setDisabled(true);
						COMP_PPID_PRE_ILNS_DT.setDisabled(true);
					}
				/*End*/
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN,
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
				dataList_PT_IL_POL_PRE_ILLNESS_DTLS.remove(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN);
				if (dataList_PT_IL_POL_PRE_ILLNESS_DTLS.size() > 0) {

					PT_IL_POL_PRE_ILLNESS_DTLS_BEAN = dataList_PT_IL_POL_PRE_ILLNESS_DTLS.get(0);
				} else if (dataList_PT_IL_POL_PRE_ILLNESS_DTLS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setRowSelected(true);
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
		if (PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
			
			new CRUDHandler().executeInsert(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN,
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
			dataList_PT_IL_POL_PRE_ILLNESS_DTLS.add(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN);
		} else if (PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.getROWID() != null
				&& isUPDATE_ALLOWED()) {
			helper.preUpdate(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN,compositeAction);
			new CRUDHandler().executeUpdate(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN,
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
		CommonUtils.getConnection().commit();
		PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setRowSelected(true);
	} catch (Exception exc) {
	
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Record not Inserted/Updated :: " + exc.getMessage());
		getErrorMap().put("postRecord",
				"Record not Inserted/Updated :: " + exc.getMessage());
	}
}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();


			if (isINSERT_ALLOWED()) {

				PT_IL_POL_PRE_ILLNESS_DTLS_BEAN = new PT_IL_POL_PRE_ILLNESS_DTLS();
				helper.preInsert(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN,compositeAction);
				resetAllComponent();
				resetRowAtCreate();


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
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void validatePPID_PRE_ILNS_DT(FacesContext context,
			UIComponent component, Object value){
		try{
			Date Value = (Date)value;
			PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_PRE_ILNS_DT(Value);
			COMP_PPID_PRE_ILNS_DT.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void validatePPID_PRE_ILNS_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String Value = (String)value;
			PT_IL_POL_PRE_ILLNESS_DTLS_BEAN.setPPID_PRE_ILNS_CODE(Value);
			helper.PAID_ILLNESS_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_PRE_ILLNESS_DTLS_BEAN,compositeAction);
			COMP_PPID_PRE_ILNS_CODE.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	private void resetAllComponent() {
		COMP_PPID_PRE_ILNS_DT.resetValue();
		COMP_PPID_PRE_ILNS_CODE.resetValue();
		COMP_UI_PPID_PRE_ILNS_CODE_DESC.resetValue();
	}
	
	public void disableAllComponents(boolean disabled){
		COMP_PPID_PRE_ILNS_DT.setDisabled(disabled);
		COMP_PPID_PRE_ILNS_CODE.setDisabled(disabled);
		COMP_UI_PPID_PRE_ILNS_CODE_DESC.setDisabled(disabled);
		
	}

	private void resetRowAtCreate() {
		Iterator<PT_IL_POL_PRE_ILLNESS_DTLS> PT_IL_POL_PRE_ILLNESS_DTLS_ITR = dataList_PT_IL_POL_PRE_ILLNESS_DTLS
				.iterator();
		while (PT_IL_POL_PRE_ILLNESS_DTLS_ITR.hasNext()) {
			PT_IL_POL_PRE_ILLNESS_DTLS_ITR.next().setRowSelected(false);;

		}
	}
	
	public ArrayList<LovBean> prepareSuggestionList_PAID_ILLNESS_CODE(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_ASSR_ILLNESS_DTLS";
		String fieldName = "PAID_ILLNESS_CODE";
		Object param1 = "IL_ILL_CODE";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList =	itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

}
