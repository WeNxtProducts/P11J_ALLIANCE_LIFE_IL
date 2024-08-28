package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
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

import org.ajax4jsf.component.html.HtmlAjaxRegion;
import org.ajax4jsf.renderkit.html.AjaxRegionRenderer;
import org.ajax4jsf.taglib.html.jsp.AjaxRegion;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_CHARGE_ACTION extends CommonAction {
	
	//Added by saritha
	
	private HtmlOutputLabel COMP_POC_RATE_PERCENT_LABEL;

	public HtmlOutputLabel getCOMP_POC_RATE_PERCENT_LABEL() {
		return COMP_POC_RATE_PERCENT_LABEL;
	}

	public void setCOMP_POC_RATE_PERCENT_LABEL(
			HtmlOutputLabel cOMP_POC_RATE_PERCENT_LABEL) {
		COMP_POC_RATE_PERCENT_LABEL = cOMP_POC_RATE_PERCENT_LABEL;
	}
	
	//End

	private HtmlOutputLabel COMP_POC_TYPE_LABEL;
	
	private HtmlAjaxRegion COMP_FORMULA_ID;

	private HtmlSelectOneMenu COMP_POC_TYPE;

	private HtmlOutputLabel COMP_POC_CHRG_CODE_LABEL;

	private HtmlInputText COMP_POC_CHRG_CODE;

	private HtmlOutputLabel COMP_POC_RATE_LABEL;

	private HtmlInputText COMP_POC_RATE;

	private HtmlOutputLabel COMP_POC_RATE_PER_LABEL;

	private HtmlInputText COMP_POC_RATE_PER;

	private HtmlOutputLabel COMP_POC_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_POC_APPLIED_ON;

	private HtmlOutputLabel COMP_POC_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_POC_CUST_SHARE_PERC;

	private HtmlOutputLabel COMP_POC_APPLY_PERIOD_LABEL;

	private HtmlSelectOneMenu COMP_POC_APPLY_PERIOD;

	private HtmlOutputLabel COMP_POC_FC_VALUE_LABEL;

	private HtmlInputText COMP_POC_FC_VALUE;

	private HtmlOutputLabel COMP_POC_LC_VALUE_LABEL;

	private HtmlInputText COMP_POC_LC_VALUE;

	private HtmlOutputLabel COMP_UI_M_POC_CHARGE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POC_CHARGE_DESC;

	private PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_CHARGE_HELPER helper;
	
	boolean region_render_flag = true;

	private List<PT_IL_POL_CHARGE> dataList_PT_IL_POL_CHARGE = new ArrayList<PT_IL_POL_CHARGE>();

	private UIData dataTable;

	private List<SelectItem> listPOC_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPOC_APPLIED_ON = new ArrayList<SelectItem>();

	private List<SelectItem> listPOC_APPLY_PERIOD = new ArrayList<SelectItem>();

	public boolean show= false;

	public String BACK_CHARGE(){
		String outcome = null;
		this.setBlockFlag(true);		
		
		//added code to hide the rate field when click edit option in premium breakup details screen by ganesh
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_PDL_RATE().setRendered(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_LOD_LABEL().setRendered(false);
			
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate().setRendered(false);
		compositeAction.getPT_IL_POL_ADDL_COVER_ACTION_BEAN().getCOMP_UI_M_POL_Rate_DIS_LABEL().setRendered(false);
		//END	
		
		
		
		outcome = "PILT002_APAC_PT_IL_POL_CHARGE";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		show = true;
		return outcome;
		}
	
	public PT_IL_POL_CHARGE_ACTION() {
		PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
		helper = new PT_IL_POL_CHARGE_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
	}

	public PT_IL_POL_CHARGE getPT_IL_POL_CHARGE_BEAN() {
		return PT_IL_POL_CHARGE_BEAN;
	}

	public void setPT_IL_POL_CHARGE_BEAN(PT_IL_POL_CHARGE PT_IL_POL_CHARGE_BEAN) {
		this.PT_IL_POL_CHARGE_BEAN = PT_IL_POL_CHARGE_BEAN;
	}

	public List<PT_IL_POL_CHARGE> getDataList_PT_IL_POL_CHARGE() {
		return dataList_PT_IL_POL_CHARGE;
	}

	public void setDataListPT_IL_POL_CHARGE(
			List<PT_IL_POL_CHARGE> dataList_PT_IL_POL_CHARGE) {
		this.dataList_PT_IL_POL_CHARGE = dataList_PT_IL_POL_CHARGE;
	}

	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listPOC_APPLIED_ON = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_CHARGE", "PT_IL_POL_CHARGE.POC_APPLIED_ON", "IL_CHGAPPLON");

			listPOC_APPLY_PERIOD = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_CHARGE", "PT_IL_POL_CHARGE.POC_APPLY_PERIOD", "IL_CHG_PRD");

			listPOC_TYPE = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_CHARGE", "PT_IL_POL_CHARGE.POC_TYPE", "IL_CHARTAX");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			setPostClick(true);
			if (isINSERT_ALLOWED()) {
				COMP_POC_APPLY_PERIOD.setDisabled(false);
				PT_IL_POL_CHARGE_BEAN = new PT_IL_POL_CHARGE();
				helper.whenCreateRecord(getPT_IL_POL_CHARGE_BEAN());
				resetAllComponent();
				resetSelectedRow();
				//Added by saritha
				COMP_POC_RATE_PERCENT_LABEL.setValue("");
				//End
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
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {
				helper.keyDelRec(getPT_IL_POL_CHARGE_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				new CRUDHandler().executeDelete(PT_IL_POL_CHARGE_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$delete");
				getWarningMap().put("deleteRow",message);

				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

				dataList_PT_IL_POL_CHARGE.remove(PT_IL_POL_CHARGE_BEAN);
				if (dataList_PT_IL_POL_CHARGE.size() > 0) {

					PT_IL_POL_CHARGE_BEAN = dataList_PT_IL_POL_CHARGE.get(0);
				} else if (dataList_PT_IL_POL_CHARGE.size() == 0) {

					//addRow(null);
				}

				
				PT_IL_POL_CHARGE_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$deletenotallowed"); 
				getErrorMap().put("deleteRow",message);

				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

			}

		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			 
			if (PT_IL_POL_CHARGE_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.preInsert(getPT_IL_POL_CHARGE_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_CHARGE_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$insert"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

				getWarningMap().put("postRecord",message);
				dataList_PT_IL_POL_CHARGE.add(PT_IL_POL_CHARGE_BEAN);
			} else if (PT_IL_POL_CHARGE_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(getPT_IL_POL_CHARGE_BEAN(), 
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_CHARGE_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update"); 
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);

				getWarningMap().put("postRecord",message);

			}

			PT_IL_POL_CHARGE_BEAN.setRowSelected(true);
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
			PT_IL_POL_CHARGE_BEAN = (PT_IL_POL_CHARGE) dataTable.getRowData();
			helper.postQuery(getPT_IL_POL_CHARGE_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			/*if ("F".equals(PT_IL_POL_CHARGE_BEAN.getPOC_APPLY_PERIOD())) {
				region_render_flag=true;
				}else{*/
					region_render_flag=true;
			//	}
		//	COMP_POC_APPLY_PERIOD.setDisabled(true);
			PT_IL_POL_CHARGE_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_CHARGE> PT_IL_POL_CHARGE_ITR = dataList_PT_IL_POL_CHARGE
		.iterator();
		while (PT_IL_POL_CHARGE_ITR.hasNext()) {
			PT_IL_POL_CHARGE_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_POC_TYPE.resetValue();
		COMP_POC_TYPE.resetValue();
		COMP_POC_CHRG_CODE.resetValue();
		COMP_POC_CHRG_CODE.resetValue();
		COMP_POC_RATE.resetValue();
		COMP_POC_RATE.resetValue();
		COMP_POC_RATE_PER.resetValue();
		COMP_POC_RATE_PER.resetValue();
		COMP_POC_APPLIED_ON.resetValue();
		COMP_POC_APPLIED_ON.resetValue();
		COMP_POC_CUST_SHARE_PERC.resetValue();
		COMP_POC_CUST_SHARE_PERC.resetValue();
		COMP_POC_APPLY_PERIOD.resetValue();
		COMP_POC_APPLY_PERIOD.resetValue();
		COMP_POC_FC_VALUE.resetValue();
		COMP_POC_FC_VALUE.resetValue();
		COMP_POC_LC_VALUE.resetValue();
		COMP_POC_LC_VALUE.resetValue();
		COMP_UI_M_POC_CHARGE_DESC.resetValue();
		COMP_UI_M_POC_CHARGE_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CommonUtils.getConnection().commit();
			
			if (dataList_PT_IL_POL_CHARGE.size() == 0) {

				addRow(null);
			}
			resetAllComponent();
			
			getWarningMap().put("deleteRow",Messages.getString(
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

	public HtmlOutputLabel getCOMP_POC_TYPE_LABEL() {
		return COMP_POC_TYPE_LABEL;
	}

	public void setCOMP_POC_TYPE_LABEL(HtmlOutputLabel comp_poc_type_label) {
		COMP_POC_TYPE_LABEL = comp_poc_type_label;
	}

	public HtmlSelectOneMenu getCOMP_POC_TYPE() {
		return COMP_POC_TYPE;
	}

	public void setCOMP_POC_TYPE(HtmlSelectOneMenu comp_poc_type) {
		COMP_POC_TYPE = comp_poc_type;
	}

	public HtmlOutputLabel getCOMP_POC_CHRG_CODE_LABEL() {
		return COMP_POC_CHRG_CODE_LABEL;
	}

	public void setCOMP_POC_CHRG_CODE_LABEL(
			HtmlOutputLabel comp_poc_chrg_code_label) {
		COMP_POC_CHRG_CODE_LABEL = comp_poc_chrg_code_label;
	}

	public HtmlInputText getCOMP_POC_CHRG_CODE() {
		return COMP_POC_CHRG_CODE;
	}

	public void setCOMP_POC_CHRG_CODE(HtmlInputText comp_poc_chrg_code) {
		COMP_POC_CHRG_CODE = comp_poc_chrg_code;
	}

	public HtmlOutputLabel getCOMP_POC_RATE_LABEL() {
		return COMP_POC_RATE_LABEL;
	}

	public void setCOMP_POC_RATE_LABEL(HtmlOutputLabel comp_poc_rate_label) {
		COMP_POC_RATE_LABEL = comp_poc_rate_label;
	}

	public HtmlInputText getCOMP_POC_RATE() {
		return COMP_POC_RATE;
	}

	public void setCOMP_POC_RATE(HtmlInputText comp_poc_rate) {
		COMP_POC_RATE = comp_poc_rate;
	}

	public HtmlOutputLabel getCOMP_POC_RATE_PER_LABEL() {
		return COMP_POC_RATE_PER_LABEL;
	}

	public void setCOMP_POC_RATE_PER_LABEL(
			HtmlOutputLabel comp_poc_rate_per_label) {
		COMP_POC_RATE_PER_LABEL = comp_poc_rate_per_label;
	}

	public HtmlInputText getCOMP_POC_RATE_PER() {
		return COMP_POC_RATE_PER;
	}

	public void setCOMP_POC_RATE_PER(HtmlInputText comp_poc_rate_per) {
		COMP_POC_RATE_PER = comp_poc_rate_per;
	}

	public HtmlOutputLabel getCOMP_POC_APPLIED_ON_LABEL() {
		return COMP_POC_APPLIED_ON_LABEL;
	}

	public void setCOMP_POC_APPLIED_ON_LABEL(
			HtmlOutputLabel comp_poc_applied_on_label) {
		COMP_POC_APPLIED_ON_LABEL = comp_poc_applied_on_label;
	}

	public HtmlSelectOneMenu getCOMP_POC_APPLIED_ON() {
		return COMP_POC_APPLIED_ON;
	}

	public void setCOMP_POC_APPLIED_ON(HtmlSelectOneMenu comp_poc_applied_on) {
		COMP_POC_APPLIED_ON = comp_poc_applied_on;
	}

	public HtmlOutputLabel getCOMP_POC_CUST_SHARE_PERC_LABEL() {
		return COMP_POC_CUST_SHARE_PERC_LABEL;
	}

	public void setCOMP_POC_CUST_SHARE_PERC_LABEL(
			HtmlOutputLabel comp_poc_cust_share_perc_label) {
		COMP_POC_CUST_SHARE_PERC_LABEL = comp_poc_cust_share_perc_label;
	}

	public HtmlInputText getCOMP_POC_CUST_SHARE_PERC() {
		return COMP_POC_CUST_SHARE_PERC;
	}

	public void setCOMP_POC_CUST_SHARE_PERC(
			HtmlInputText comp_poc_cust_share_perc) {
		COMP_POC_CUST_SHARE_PERC = comp_poc_cust_share_perc;
	}

	public HtmlOutputLabel getCOMP_POC_APPLY_PERIOD_LABEL() {
		return COMP_POC_APPLY_PERIOD_LABEL;
	}

	public void setCOMP_POC_APPLY_PERIOD_LABEL(
			HtmlOutputLabel comp_poc_apply_period_label) {
		COMP_POC_APPLY_PERIOD_LABEL = comp_poc_apply_period_label;
	}

	public HtmlSelectOneMenu getCOMP_POC_APPLY_PERIOD() {
		return COMP_POC_APPLY_PERIOD;
	}

	public void setCOMP_POC_APPLY_PERIOD(HtmlSelectOneMenu comp_poc_apply_period) {
		COMP_POC_APPLY_PERIOD = comp_poc_apply_period;
	}

	public HtmlOutputLabel getCOMP_POC_FC_VALUE_LABEL() {
		return COMP_POC_FC_VALUE_LABEL;
	}

	public void setCOMP_POC_FC_VALUE_LABEL(
			HtmlOutputLabel comp_poc_fc_value_label) {
		COMP_POC_FC_VALUE_LABEL = comp_poc_fc_value_label;
	}

	public HtmlInputText getCOMP_POC_FC_VALUE() {
		return COMP_POC_FC_VALUE;
	}

	public void setCOMP_POC_FC_VALUE(HtmlInputText comp_poc_fc_value) {
		COMP_POC_FC_VALUE = comp_poc_fc_value;
	}

	public HtmlOutputLabel getCOMP_POC_LC_VALUE_LABEL() {
		return COMP_POC_LC_VALUE_LABEL;
	}

	public void setCOMP_POC_LC_VALUE_LABEL(
			HtmlOutputLabel comp_poc_lc_value_label) {
		COMP_POC_LC_VALUE_LABEL = comp_poc_lc_value_label;
	}

	public HtmlInputText getCOMP_POC_LC_VALUE() {
		return COMP_POC_LC_VALUE;
	}

	public void setCOMP_POC_LC_VALUE(HtmlInputText comp_poc_lc_value) {
		COMP_POC_LC_VALUE = comp_poc_lc_value;
	}

	public HtmlOutputLabel getCOMP_UI_M_POC_CHARGE_DESC_LABEL() {
		return COMP_UI_M_POC_CHARGE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POC_CHARGE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poc_charge_desc_label) {
		COMP_UI_M_POC_CHARGE_DESC_LABEL = comp_ui_m_poc_charge_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POC_CHARGE_DESC() {
		return COMP_UI_M_POC_CHARGE_DESC;
	}

	public void setCOMP_UI_M_POC_CHARGE_DESC(
			HtmlInputText comp_ui_m_poc_charge_desc) {
		COMP_UI_M_POC_CHARGE_DESC = comp_ui_m_poc_charge_desc;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_CHARGE_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_CHARGE_HELPER helper) {
		this.helper = helper;
	}

	public List<SelectItem> getListPOC_TYPE() {
		return listPOC_TYPE;
	}

	public void setListPOC_TYPE(List<SelectItem> listPOC_TYPE) {
		this.listPOC_TYPE = listPOC_TYPE;
	}

	public List<SelectItem> getListPOC_APPLIED_ON() {
		return listPOC_APPLIED_ON;
	}

	public void setListPOC_APPLIED_ON(List<SelectItem> listPOC_APPLIED_ON) {
		this.listPOC_APPLIED_ON = listPOC_APPLIED_ON;
	}

	public List<SelectItem> getListPOC_APPLY_PERIOD() {
		return listPOC_APPLY_PERIOD;
	}

	public void setListPOC_APPLY_PERIOD(List<SelectItem> listPOC_APPLY_PERIOD) {
		this.listPOC_APPLY_PERIOD = listPOC_APPLY_PERIOD;
	}

	public void setDataList_PT_IL_POL_CHARGE(
			List<PT_IL_POL_CHARGE> dataList_PT_IL_POL_CHARGE) {
		this.dataList_PT_IL_POL_CHARGE = dataList_PT_IL_POL_CHARGE;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	private HtmlCommandButton COMP_UI_back_PremiumDtls;
	
	public HtmlCommandButton getCOMP_UI_back_PremiumDtls() {
		return COMP_UI_back_PremiumDtls;
	}

	public void setCOMP_UI_back_PremiumDtls(
			HtmlCommandButton cOMP_UI_back_PremiumDtls) {
		COMP_UI_back_PremiumDtls = cOMP_UI_back_PremiumDtls;
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				setPostClick(false);
				if(show)
				{
					COMP_UI_back_PremiumDtls.setRendered(true);
					
					show=false;
				}
				else
				{
					COMP_UI_back_PremiumDtls.setRendered(false);
					
				}
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_CHARGE_BEAN.getROWID() != null){
					helper.postQuery(PT_IL_POL_CHARGE_BEAN, compositeAction
							.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				}else{
					helper.whenCreateRecord(PT_IL_POL_CHARGE_BEAN);
				}
				setBlockFlag(false);
			}
			
			enableFields();
			
			//Added by saritha on 08.6.16
			rateperlabel();
			//End
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	//Added by saritha on 8.6.16
	private void rateperlabel()
	{
		System.out.println("inside the rateperlabel function");
		Double rateper=getPT_IL_POL_CHARGE_BEAN().getPOC_RATE_PER();
		System.out.println("value of rateper value ---------->"+rateper);
		if(rateper==100.00)
			/*rateper.equals("100.00")*/
		{
			System.out.println("inside 1st if");
			COMP_POC_RATE_PERCENT_LABEL.setRendered(true);
		
			COMP_POC_RATE_PERCENT_LABEL.setValue("Percentage");
		}
		else if(rateper==1000.00)
		{
			System.out.println("inside 2st if");
			COMP_POC_RATE_PERCENT_LABEL.setRendered(true);
		
			COMP_POC_RATE_PERCENT_LABEL.setValue("Per mile");
		}
		else
		{
			System.out.println("inside else");
			COMP_POC_RATE_PERCENT_LABEL.setValue("");
			
		}
		
		                                                                                                                    
	}

//End

	public void validatePOL_TYPE(FacesContext context,
			UIComponent component, Object value)  {

		try {
			PT_IL_POL_CHARGE_BEAN.setPOC_TYPE((String) value);
			if(PT_IL_POL_CHARGE_BEAN.getPOC_TYPE().equalsIgnoreCase("T")){
				COMP_POC_CUST_SHARE_PERC.setDisabled(true);
				
				System.out.println("HI------>"+"inside true");
			}
			else{
				System.out.println("HI------>"+"inside false");
				COMP_POC_CUST_SHARE_PERC.setDisabled(false);
			}

           
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public void whenPoctypechanged(ActionEvent event){
		
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
	}
	
	
	
	
	
	
	
	public void POC_CHRG_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			PT_IL_POL_CHARGE_BEAN.setPOC_CHRG_CODE((String) value);

			helper.POC_CHRG_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POC_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			PT_IL_POL_CHARGE_BEAN.setPOC_RATE((Double) value);
			/*Newly added if condition by pidugu raj dt: 12-12-2020 as suggested by Abhilash and Ashok for Alliance IL*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SRC_OF_BUS().equalsIgnoreCase("075")){
			helper.POC_RATE_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE_BEAN);
			}
			/*End Newly added if condition by pidugu raj dt: 12-12-2020 as suggested by Abhilash and Ashok for Alliance IL*/
			helper.POC_APPLIED_ON_WHEN_VALIDATE_ITEM(
					PT_IL_POL_CHARGE_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POC_FC_VALUE.resetValue();
			COMP_POC_LC_VALUE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POC_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			
			System.out.println("Charge Details---------------------->");
			PT_IL_POL_CHARGE_BEAN.setPOC_RATE_PER((Double) value);

			helper.POC_RATE_PER_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE_BEAN);
			helper.POC_APPLIED_ON_WHEN_VALIDATE_ITEM(
					PT_IL_POL_CHARGE_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POC_FC_VALUE.resetValue();
			COMP_POC_LC_VALUE.resetValue();
			//Added by saritha on 08.6.16
			rateperlabel();
			//End
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POC_APPLIED_ON_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			//As per Ganesh Requirement when Appied when  value is Fixed then Rate per  Defaulted 1
			PT_IL_POL_CHARGE_BEAN.setPOC_APPLIED_ON((String) value);
			if ("3".equals(PT_IL_POL_CHARGE_BEAN.getPOC_APPLIED_ON())) {
				PT_IL_POL_CHARGE_BEAN.setPOC_RATE_PER(1.00);
				COMP_POC_RATE_PER.setDisabled(true);
			}else{
				COMP_POC_RATE_PER.setDisabled(false);
			}
		
			COMP_POC_RATE_PER.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value)  {

		try {
			PT_IL_POL_CHARGE_BEAN.setPOC_CUST_SHARE_PERC((Double) value);

			helper.POC_CUST_SHARE_PERC_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

/*  select PC_CODE  from pm_codes where pc_type='IL_CHARGE'
           and  not exists  (select th_tax_type from PM_LIFE_TAX_HEADER where th_tax_type=pc_code)
		 
		 select th_tax_type from PM_LIFE_TAX_HEADER  */
	
	
	
	
	
	public List<LovBean> prepareSuggestionList_CHRG_CODE(Object event) {
		 String code = (String) event;
			List<LovBean> suggestionList = null;
			Object[] object = {};
			String query = null;
			
			System.out.println(PT_IL_POL_CHARGE_BEAN.getPOC_TYPE());
			
			
			if("C".equalsIgnoreCase(PT_IL_POL_CHARGE_BEAN.getPOC_TYPE())){
				
				if ("*".equals(code)) {
				
				object = new Object[] { PELConstants.suggetionRecordSize };
		
				query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_CHARGE' AND NOT EXISTS(SELECT TH_TAX_TYPE FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE = PC_CODE)AND " +
						" ROWNUM < ? ORDER BY 1";
				
			} else {
				object = new Object[] { code + "%",
						PELConstants.suggetionRecordSize };
				/*
				 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105
				 * 
				 * 
				 * query =  "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_CHARGE' AND NOT EXISTS(SELECT TH_TAX_TYPE FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE = PC_CODE) AND"  +
					"(PC_CODE LIKE ? ) " +
						"AND ROWNUM < ? ORDER BY 1";*/
				 /*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105*/
				query =  "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE LIKE 'IL_CHARGE' AND NOT EXISTS(SELECT TH_TAX_TYPE FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE = PC_CODE) AND"  +
						"(UPPER(PC_CODE) LIKE UPPER(?) ) " +
							"AND ROWNUM < ? ORDER BY 1";
							
				/*END*/
			}
			}else{
				if ("*".equals(code)) {
					
					object = new Object[] { PELConstants.suggetionRecordSize };
			
					query = "SELECT TH_TAX_TYPE,TH_TAX_DESC FROM PM_LIFE_TAX_HEADER  WHERE  TH_TAX_TYPE IN (SELECT PC_CODE  FROM PM_CODES WHERE PC_TYPE='IL_CHARGE') AND" +
							" ROWNUM < ? ORDER BY 1";
				} else {
					object = new Object[] { code + "%",
							PELConstants.suggetionRecordSize };
					/*
					 * 
					 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105
					 * 
					 * 
					 * query ="SELECT TH_TAX_TYPE,TH_TAX_DESC FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE IN (SELECT PC_CODE  FROM PM_CODES WHERE PC_TYPE='IL_CHARGE') AND" +
						"(TH_TAX_TYPE LIKE ? ) " +
							"AND ROWNUM < ? ORDER BY 1";*/
					 /*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105*/
					query ="SELECT TH_TAX_TYPE,TH_TAX_DESC FROM PM_LIFE_TAX_HEADER WHERE TH_TAX_TYPE IN (SELECT PC_CODE  FROM PM_CODES WHERE PC_TYPE='IL_CHARGE') AND" +
							"(UPPER(TH_TAX_TYPE) LIKE UPPER(?) ) " +
								"AND ROWNUM < ? ORDER BY 1";
					/*END*/
				}
				
			}
			try {
				suggestionList = prepareLovList(query, object);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("Dept Code Suggestion", e.getMessage());
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
	

	/**
	 * Disables all components in PT_IL_POL_CHARGE_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_POC_CHRG_CODE.setDisabled(disabled);
		COMP_POC_RATE.setDisabled(disabled);
		COMP_POC_RATE_PER.setDisabled(disabled);
		COMP_POC_CUST_SHARE_PERC.setDisabled(disabled);
		COMP_POC_FC_VALUE.setDisabled(disabled);
		COMP_POC_LC_VALUE.setDisabled(disabled);
		COMP_UI_M_POC_CHARGE_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POC_TYPE.setDisabled(disabled);
		COMP_POC_APPLIED_ON.setDisabled(disabled);
		COMP_POC_APPLY_PERIOD.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_CHARGE_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POC_CHRG_CODE				 = new HtmlInputText();
		COMP_POC_RATE					 = new HtmlInputText();
		COMP_POC_RATE_PER				 = new HtmlInputText();
		COMP_POC_CUST_SHARE_PERC			 = new HtmlInputText();
		COMP_POC_FC_VALUE				 = new HtmlInputText();
		COMP_POC_LC_VALUE				 = new HtmlInputText();
		COMP_UI_M_POC_CHARGE_DESC			 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POC_TYPE_LABEL				 = new HtmlOutputLabel();
		COMP_POC_CHRG_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POC_RATE_LABEL				 = new HtmlOutputLabel();
		COMP_POC_RATE_PER_LABEL				 = new HtmlOutputLabel();
		COMP_POC_APPLIED_ON_LABEL			 = new HtmlOutputLabel();
		COMP_POC_CUST_SHARE_PERC_LABEL			 = new HtmlOutputLabel();
		COMP_POC_APPLY_PERIOD_LABEL			 = new HtmlOutputLabel();
		COMP_POC_FC_VALUE_LABEL				 = new HtmlOutputLabel();
		COMP_POC_LC_VALUE_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_POC_CHARGE_DESC_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_POC_TYPE					 = new HtmlSelectOneMenu();
		COMP_POC_APPLIED_ON				 = new HtmlSelectOneMenu();
		COMP_POC_APPLY_PERIOD				 = new HtmlSelectOneMenu();

	}
	public void POC_FC_VALUE_VALIDATOR(FacesContext context, UIComponent component, Object value){
		try {
			getPT_IL_POL_CHARGE_BEAN().setPOC_FC_VALUE((Double)value);
			getPT_IL_POL_CHARGE_BEAN().setPOC_LC_VALUE(getPT_IL_POL_CHARGE_BEAN().getPOC_FC_VALUE());
			COMP_POC_LC_VALUE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public Boolean getRegion_render_flag() {
		return region_render_flag;
	}

	public void setRegion_render_flag(Boolean region_render_flag) {
		this.region_render_flag = region_render_flag;
	}

	public HtmlAjaxRegion getCOMP_FORMULA_ID() {
		return COMP_FORMULA_ID;
	}

	public void setCOMP_FORMULA_ID(HtmlAjaxRegion comp_formula_id) {
		COMP_FORMULA_ID = comp_formula_id;
	}
	
	private boolean postClick;
	
	public boolean isPostClick() {
		return postClick;
	}

	public void setPostClick(boolean postClick) {
		this.postClick = postClick;
	}

	public void setPOC_RATE_Editable(ActionEvent event) {
		try
		{
		setPostClick(false);
		System.out.println("Welcome to setPOAC_PERIOD_Editable");
		
		
		CommonUtils.clearMaps(this);
		String POAC_PERIOD=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		System.out.println("currentIndex in POAC_PERIOD         "+currentIndex);
		PT_IL_POL_CHARGE_BEAN=(PT_IL_POL_CHARGE)dataList_PT_IL_POL_CHARGE.get(currentIndex);
		PT_IL_POL_CHARGE_BEAN.setPOC_RATE(Double.parseDouble(POAC_PERIOD));
		dataList_PT_IL_POL_CHARGE.set(currentIndex, PT_IL_POL_CHARGE_BEAN);
		COMP_POC_RATE.resetValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}

	}
	
	
	public void setPOC_RATE_PER_Editable(ActionEvent event) {
		try
		{
		setPostClick(false);
		System.out.println("Welcome to setPOC_RATE_PER_Editable");
		
		
		CommonUtils.clearMaps(this);
		String POAC_PERIOD=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		System.out.println("currentIndex in POAC_PERIOD         "+currentIndex);
		PT_IL_POL_CHARGE_BEAN=(PT_IL_POL_CHARGE)dataList_PT_IL_POL_CHARGE.get(currentIndex);
		PT_IL_POL_CHARGE_BEAN.setPOC_RATE_PER(Double.parseDouble(POAC_PERIOD));
		dataList_PT_IL_POL_CHARGE.set(currentIndex, PT_IL_POL_CHARGE_BEAN);
		COMP_POC_RATE_PER.resetValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}

	}
	
	public void setPOC_APPLY_PERIOD_Editable(ActionEvent event) {
		try
		{
		setPostClick(false);
		System.out.println("Welcome to setPOC_RATE_PER_Editable");
		
		
		CommonUtils.clearMaps(this);
		String POC_APPLY_PERIOD=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		System.out.println("currentIndex in POAC_PERIOD         "+currentIndex);
		PT_IL_POL_CHARGE_BEAN=(PT_IL_POL_CHARGE)dataList_PT_IL_POL_CHARGE.get(currentIndex);
		PT_IL_POL_CHARGE_BEAN.setPOC_APPLIED_ON(POC_APPLY_PERIOD);
		
		dataList_PT_IL_POL_CHARGE.set(currentIndex, PT_IL_POL_CHARGE_BEAN);
		
		COMP_POC_APPLIED_ON.resetValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}

	}
	
	public String saveCurrentRecord(){
		CommonUtils.clearMaps(this);
		String outcome = null;
		int rowIndex = dataTable.getRowIndex();
System.out.println("rowIndex      "+rowIndex);
		try{
			if(rowIndex > -1){
				// Calling last Column listener
				updateRecord();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	
	public void updateRecord(){
		String message = null;
		String str = null;
		try { 
			System.out.println("Welcome to updateRecord     "+PT_IL_POL_CHARGE_BEAN.getPOC_RATE()+"      "+
					PT_IL_POL_CHARGE_BEAN.getPOC_RATE_PER());
			 
			helper.POC_RATE_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE_BEAN);
			helper.POC_APPLIED_ON_WHEN_VALIDATE_ITEM(
					PT_IL_POL_CHARGE_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			COMP_POC_FC_VALUE.resetValue();
			COMP_POC_LC_VALUE.resetValue();
			
			helper.POC_RATE_PER_WHEN_VALIDATE_ITEM(PT_IL_POL_CHARGE_BEAN);
			helper.POC_APPLIED_ON_WHEN_VALIDATE_ITEM(
					PT_IL_POL_CHARGE_BEAN, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			
			
			helper.preUpdate(getPT_IL_POL_CHARGE_BEAN(), 
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			new CRUDHandler().executeUpdate(PT_IL_POL_CHARGE_BEAN,
					CommonUtils.getConnection());
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"); 
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord",message);
	    
			
			CommonUtils.getConnection().commit();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$update");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
			getWarningMap().put("postRecord", message);
			 
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
		}
	}
	
	
	/*Newly Added By Dhinesh on 6-7-2017 */
	
	private void enableFields()
	{
		if(PT_IL_POL_CHARGE_BEAN.getRowSelected() != null && PT_IL_POL_CHARGE_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		{
			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
				compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
			{
				PT_IL_POL_CHARGE_BEAN.setFIELD1_ENABLE("true");
			}
			else
			{
				PT_IL_POL_CHARGE_BEAN.setFIELD1_ENABLE("false");
			}
		}
	}
     /* End */
	
}

