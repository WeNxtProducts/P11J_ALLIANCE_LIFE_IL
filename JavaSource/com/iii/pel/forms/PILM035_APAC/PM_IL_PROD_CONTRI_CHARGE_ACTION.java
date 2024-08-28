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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_DISC_LOAD;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_PROD_CONTRI_CHARGE_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_PCC_CHRG_CODE_LABEL;
	private HtmlInputText COMP_PCC_CHRG_CODE;

	private HtmlOutputLabel COMP_UI_M_PCC_CHRG_CODE_DESC_LABEL;
	private HtmlInputText COMP_UI_M_PCC_CHRG_CODE_DESC;

	private HtmlOutputLabel COMP_PCC_PREM_TOPUP_FLAG_LABEL;
	private HtmlSelectOneMenu COMP_PCC_PREM_TOPUP_FLAG;

	private HtmlOutputLabel COMP_PCC_MODE_OF_PYMT_LABEL;
	private HtmlSelectOneMenu COMP_PCC_MODE_OF_PYMT;

	private HtmlOutputLabel COMP_PCC_CHRG_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_PCC_CHRG_TYPE;

	private HtmlOutputLabel COMP_PCC_CON_LMT_FM_LABEL;
	private HtmlInputText COMP_PCC_CON_LMT_FM;

	private HtmlOutputLabel COMP_PCC_CON_LMT_TO_LABEL;
	private HtmlInputText COMP_PCC_CON_LMT_TO;

	private HtmlOutputLabel COMP_PCC_POL_YR_FM_LABEL;
	private HtmlInputText COMP_PCC_POL_YR_FM;

	private HtmlOutputLabel COMP_PCC_POL_YR_TO_LABEL;
	private HtmlInputText COMP_PCC_POL_YR_TO; 

	private HtmlOutputLabel COMP_PCC_RATE_LABEL;
	private HtmlInputText COMP_PCC_RATE;

	private HtmlOutputLabel COMP_PCC_RATE_PER_LABEL;
	private HtmlInputText COMP_PCC_RATE_PER;

	private HtmlOutputLabel COMP_PCC_FIXED_AMT_LABEL;
	private HtmlInputText COMP_PCC_FIXED_AMT;

	private HtmlOutputLabel COMP_PCC_FLEX_01_LABEL;
	private HtmlInputText COMP_PCC_FLEX_01;

	private HtmlOutputLabel COMP_PCC_SR_NO_LABEL;
	private HtmlInputText  COMP_PCC_SR_NO;

	private HtmlOutputLabel COMP_PCC_APPLIED_ON_LABEL;
	private HtmlSelectOneMenu COMP_PCC_APPLIED_ON;

	private HtmlOutputLabel COMP_PCC_SRC_OF_BUS_LABEL;
	private HtmlInputText  COMP_PCC_SRC_OF_BUS;

	private HtmlOutputLabel COMP_PCC_EFF_FM_DT_LABEL;
	private HtmlCalendar COMP_PCC_EFF_FM_DT;

	private HtmlOutputLabel COMP_PCC_EFF_TO_DT_LABEL;
	private HtmlCalendar COMP_PCC_EFF_TO_DT;

	private HtmlInputText COMP_UI_M_PROD_SRC_OF_BUS_DESC; 

	private HtmlInputText COMP_UI_M_FLEX1;

	private HtmlOutputLabel COMP_UI_M_FLEX1_LABEL;

	private HtmlInputText COMP_UI_M_FORMULA_CODE_DESC;

	private HtmlOutputLabel COMP_PCC_COV_CHARGE_LABEL;
	private HtmlSelectOneMenu COMP_PCC_COV_CHARGE;

	private UIData dataTable;

	private List<PM_IL_PROD_CONTRI_CHARGE> dataList_PM_IL_PROD_CONTRI_CHARGE = new ArrayList<PM_IL_PROD_CONTRI_CHARGE>();

	private List<SelectItem> listPCC_PREM_TOPUP_FLAG = new ArrayList<SelectItem>();

	private List<SelectItem> listPCC_MODE_OF_PYMT =  new ArrayList<SelectItem>();

	private List<SelectItem> listPCC_CHRG_TYPE =  new ArrayList<SelectItem>();

	private List<SelectItem> listPCC_APPLIED_ON =  new ArrayList<SelectItem>();

	private List<SelectItem> listPCC_COVER_CHARGE =  new ArrayList<SelectItem>();


	private PM_IL_PROD_CONTRI_CHARGE PM_IL_PROD_CONTRI_CHARGE_BEAN;

	private PM_IL_PROD_CONTRI_CHARGE_HELPER helper;

	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	public PM_IL_PROD_CONTRI_CHARGE_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PM_IL_PROD_CONTRI_CHARGE_HELPER helper) {
		this.helper = helper;
	}
	public PILM035_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public PM_IL_PROD_CONTRI_CHARGE getPM_IL_PROD_CONTRI_CHARGE_BEAN() {
		return PM_IL_PROD_CONTRI_CHARGE_BEAN;
	}
	public void setPM_IL_PROD_CONTRI_CHARGE_BEAN(
			PM_IL_PROD_CONTRI_CHARGE pm_il_prod_contri_charge_bean) {
		PM_IL_PROD_CONTRI_CHARGE_BEAN = pm_il_prod_contri_charge_bean;
	}
	public HtmlOutputLabel getCOMP_PCC_CHRG_CODE_LABEL() {
		return COMP_PCC_CHRG_CODE_LABEL;
	}
	public void setCOMP_PCC_CHRG_CODE_LABEL(HtmlOutputLabel comp_pcc_chrg_code_label) {
		COMP_PCC_CHRG_CODE_LABEL = comp_pcc_chrg_code_label;
	}
	public HtmlInputText getCOMP_PCC_CHRG_CODE() {
		return COMP_PCC_CHRG_CODE;
	}
	public void setCOMP_PCC_CHRG_CODE(HtmlInputText comp_pcc_chrg_code) {
		COMP_PCC_CHRG_CODE = comp_pcc_chrg_code;
	}
	public HtmlOutputLabel getCOMP_PCC_PREM_TOPUP_FLAG_LABEL() {
		return COMP_PCC_PREM_TOPUP_FLAG_LABEL;
	}
	public void setCOMP_PCC_PREM_TOPUP_FLAG_LABEL(
			HtmlOutputLabel comp_pcc_prem_topup_flag_label) {
		COMP_PCC_PREM_TOPUP_FLAG_LABEL = comp_pcc_prem_topup_flag_label;
	}
	public HtmlSelectOneMenu getCOMP_PCC_PREM_TOPUP_FLAG() {
		return COMP_PCC_PREM_TOPUP_FLAG;
	}
	public void setCOMP_PCC_PREM_TOPUP_FLAG(
			HtmlSelectOneMenu comp_pcc_prem_topup_flag) {
		COMP_PCC_PREM_TOPUP_FLAG = comp_pcc_prem_topup_flag;
	}
	public HtmlOutputLabel getCOMP_PCC_MODE_OF_PYMT_LABEL() {
		return COMP_PCC_MODE_OF_PYMT_LABEL;
	}
	public void setCOMP_PCC_MODE_OF_PYMT_LABEL(
			HtmlOutputLabel comp_pcc_mode_of_pymt_label) {
		COMP_PCC_MODE_OF_PYMT_LABEL = comp_pcc_mode_of_pymt_label;
	}
	public HtmlSelectOneMenu getCOMP_PCC_MODE_OF_PYMT() {
		return COMP_PCC_MODE_OF_PYMT;
	}
	public void setCOMP_PCC_MODE_OF_PYMT(HtmlSelectOneMenu comp_pcc_mode_of_pymt) {
		COMP_PCC_MODE_OF_PYMT = comp_pcc_mode_of_pymt;
	}
	public HtmlOutputLabel getCOMP_PCC_CHRG_TYPE_LABEL() {
		return COMP_PCC_CHRG_TYPE_LABEL;
	}
	public void setCOMP_PCC_CHRG_TYPE_LABEL(HtmlOutputLabel comp_pcc_chrg_type_label) {
		COMP_PCC_CHRG_TYPE_LABEL = comp_pcc_chrg_type_label;
	}
	public HtmlSelectOneMenu getCOMP_PCC_CHRG_TYPE() {
		return COMP_PCC_CHRG_TYPE;
	}
	public void setCOMP_PCC_CHRG_TYPE(HtmlSelectOneMenu comp_pcc_chrg_type) {
		COMP_PCC_CHRG_TYPE = comp_pcc_chrg_type;
	}
	public HtmlOutputLabel getCOMP_PCC_CON_LMT_FM_LABEL() {
		return COMP_PCC_CON_LMT_FM_LABEL;
	}
	public void setCOMP_PCC_CON_LMT_FM_LABEL(
			HtmlOutputLabel comp_pcc_con_lmt_fm_label) {
		COMP_PCC_CON_LMT_FM_LABEL = comp_pcc_con_lmt_fm_label;
	}
	public HtmlInputText getCOMP_PCC_CON_LMT_FM() {
		return COMP_PCC_CON_LMT_FM;
	}
	public void setCOMP_PCC_CON_LMT_FM(HtmlInputText comp_pcc_con_lmt_fm) {
		COMP_PCC_CON_LMT_FM = comp_pcc_con_lmt_fm;
	}
	public HtmlOutputLabel getCOMP_PCC_CON_LMT_TO_LABEL() {
		return COMP_PCC_CON_LMT_TO_LABEL;
	}
	public void setCOMP_PCC_CON_LMT_TO_LABEL(
			HtmlOutputLabel comp_pcc_con_lmt_to_label) {
		COMP_PCC_CON_LMT_TO_LABEL = comp_pcc_con_lmt_to_label;
	}
	public HtmlInputText getCOMP_PCC_CON_LMT_TO() {
		return COMP_PCC_CON_LMT_TO;
	}
	public void setCOMP_PCC_CON_LMT_TO(HtmlInputText comp_pcc_con_lmt_to) {
		COMP_PCC_CON_LMT_TO = comp_pcc_con_lmt_to;
	}
	public HtmlOutputLabel getCOMP_PCC_POL_YR_FM_LABEL() {
		return COMP_PCC_POL_YR_FM_LABEL;
	}
	public void setCOMP_PCC_POL_YR_FM_LABEL(HtmlOutputLabel comp_pcc_pol_yr_fm_label) {
		COMP_PCC_POL_YR_FM_LABEL = comp_pcc_pol_yr_fm_label;
	}
	public HtmlInputText getCOMP_PCC_POL_YR_FM() {
		return COMP_PCC_POL_YR_FM;
	}
	public void setCOMP_PCC_POL_YR_FM(HtmlInputText comp_pcc_pol_yr_fm) {
		COMP_PCC_POL_YR_FM = comp_pcc_pol_yr_fm;
	}
	public HtmlOutputLabel getCOMP_PCC_RATE_LABEL() {
		return COMP_PCC_RATE_LABEL;
	}
	public void setCOMP_PCC_RATE_LABEL(HtmlOutputLabel comp_pcc_rate_label) {
		COMP_PCC_RATE_LABEL = comp_pcc_rate_label;
	}
	public HtmlInputText getCOMP_PCC_RATE() {
		return COMP_PCC_RATE;
	}
	public void setCOMP_PCC_RATE(HtmlInputText comp_pcc_rate) {
		COMP_PCC_RATE = comp_pcc_rate;
	}
	public HtmlOutputLabel getCOMP_PCC_RATE_PER_LABEL() {
		return COMP_PCC_RATE_PER_LABEL;
	}
	public void setCOMP_PCC_RATE_PER_LABEL(HtmlOutputLabel comp_pcc_rate_per_label) {
		COMP_PCC_RATE_PER_LABEL = comp_pcc_rate_per_label;
	}
	public HtmlInputText getCOMP_PCC_RATE_PER() {
		return COMP_PCC_RATE_PER;
	}
	public void setCOMP_PCC_RATE_PER(HtmlInputText comp_pcc_rate_per) {
		COMP_PCC_RATE_PER = comp_pcc_rate_per;
	}
	public HtmlOutputLabel getCOMP_PCC_FIXED_AMT_LABEL() {
		return COMP_PCC_FIXED_AMT_LABEL;
	}
	public void setCOMP_PCC_FIXED_AMT_LABEL(HtmlOutputLabel comp_pcc_fixed_amt_label) {
		COMP_PCC_FIXED_AMT_LABEL = comp_pcc_fixed_amt_label;
	}
	public HtmlInputText getCOMP_PCC_FIXED_AMT() {
		return COMP_PCC_FIXED_AMT;
	}
	public void setCOMP_PCC_FIXED_AMT(HtmlInputText comp_pcc_fixed_amt) {
		COMP_PCC_FIXED_AMT = comp_pcc_fixed_amt;
	}
	public HtmlOutputLabel getCOMP_PCC_FLEX_01_LABEL() {
		return COMP_PCC_FLEX_01_LABEL;
	}
	public void setCOMP_PCC_FLEX_01_LABEL(HtmlOutputLabel comp_pcc_flex_01_label) {
		COMP_PCC_FLEX_01_LABEL = comp_pcc_flex_01_label;
	}
	public HtmlInputText getCOMP_PCC_FLEX_01() {
		return COMP_PCC_FLEX_01;
	}
	public void setCOMP_PCC_FLEX_01(HtmlInputText comp_pcc_flex_01) {
		COMP_PCC_FLEX_01 = comp_pcc_flex_01;
	}
	public HtmlOutputLabel getCOMP_UI_M_PCC_CHRG_CODE_DESC_LABEL() {
		return COMP_UI_M_PCC_CHRG_CODE_DESC_LABEL;
	}
	public void setCOMP_UI_M_PCC_CHRG_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pcc_chrg_code_desc_label) {
		COMP_UI_M_PCC_CHRG_CODE_DESC_LABEL = comp_ui_m_pcc_chrg_code_desc_label;
	}
	public HtmlInputText getCOMP_UI_M_PCC_CHRG_CODE_DESC() {
		return COMP_UI_M_PCC_CHRG_CODE_DESC;
	}
	public void setCOMP_UI_M_PCC_CHRG_CODE_DESC(
			HtmlInputText comp_ui_m_pcc_chrg_code_desc) {
		COMP_UI_M_PCC_CHRG_CODE_DESC = comp_ui_m_pcc_chrg_code_desc;
	}
	/**
	 * 
	 */
	public PM_IL_PROD_CONTRI_CHARGE_ACTION() {
		PM_IL_PROD_CONTRI_CHARGE_BEAN = new PM_IL_PROD_CONTRI_CHARGE();
		helper = new PM_IL_PROD_CONTRI_CHARGE_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
	}

	private void prepareDropDownList() {
		try {
			setListPCC_PREM_TOPUP_FLAG(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_CONTRI_CHARGE",
					"PM_IL_PROD_CONTRI_CHARGE.PCC_PREM_TOPUP_FLAG",
					"PREM_TOPUP"));
			setListPCC_MODE_OF_PYMT(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_CONTRI_CHARGE",
					"PM_IL_PROD_CONTRI_CHARGE.PCC_MODE_OF_PYMT", "MOP"));
			setListPCC_APPLIED_ON(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_CONTRI_CHARGE",
					"PM_IL_PROD_CONTRI_CHARGE.PCC_APPLIED_ON", "APPLIED_ON"));
			setListPCC_CHRG_TYPE(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_CONTRI_CHARGE",
					"PM_IL_PROD_CONTRI_CHARGE.PCC_CHRG_TYPE", "CHARGE_TYPE"));
			setListPCC_COVER_CHARGE(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_CONTRI_CHARGE",
					"PM_IL_PROD_CONTRI_CHARGE.PCC_TYPE", "COVER_CHARGE"));
			
			/*Added by saritha on 17-04-2018 for KIC Need to introduce policy fee for GOLDA. 0.2% of initial face amount with max cap of KD 200*/
			
			setListPCC_APPLY_PERIOD(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PILM035_APAC",
					"PM_IL_PROD_CONTRI_CHARGE",
					"PM_IL_PROD_CONTRI_CHARGE.PCC_APPLY_PERIOD", "APPLY_PERIOD"));
			
			/*End*/

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					"Save",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void postRecord(ActionEvent event) {
		try {
			if (PM_IL_PROD_CONTRI_CHARGE_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(PM_IL_PROD_CONTRI_CHARGE_BEAN,compositeAction);
				new CRUDHandler().executeInsert(PM_IL_PROD_CONTRI_CHARGE_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				dataList_PM_IL_PROD_CONTRI_CHARGE.add(PM_IL_PROD_CONTRI_CHARGE_BEAN);
			} else if (PM_IL_PROD_CONTRI_CHARGE_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(PM_IL_PROD_CONTRI_CHARGE_BEAN);
				new CRUDHandler().executeUpdate(PM_IL_PROD_CONTRI_CHARGE_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}

			PM_IL_PROD_CONTRI_CHARGE_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}

	public String deleteRow() {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PM_IL_PROD_CONTRI_CHARGE_BEAN,
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
				dataList_PM_IL_PROD_CONTRI_CHARGE
				.remove(PM_IL_PROD_CONTRI_CHARGE_BEAN);
				if (dataList_PM_IL_PROD_CONTRI_CHARGE.size() > 0) {

					PM_IL_PROD_CONTRI_CHARGE_BEAN = dataList_PM_IL_PROD_CONTRI_CHARGE
							.get(0);
				} else if (dataList_PM_IL_PROD_CONTRI_CHARGE.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PM_IL_PROD_CONTRI_CHARGE_BEAN.setRowSelected(true);
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

		return null;

	}

	private void resetSelectedRow() {
		Iterator<PM_IL_PROD_CONTRI_CHARGE> PM_IL_PROD_CONTRI_CHARGE_ITR = dataList_PM_IL_PROD_CONTRI_CHARGE
				.iterator();
		while (PM_IL_PROD_CONTRI_CHARGE_ITR.hasNext()) {
			PM_IL_PROD_CONTRI_CHARGE_ITR.next().setRowSelected(false);
		}
	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				PM_IL_PROD_CONTRI_CHARGE_BEAN = new PM_IL_PROD_CONTRI_CHARGE();
				helper.whenCreateRecord(getPM_IL_PROD_CONTRI_CHARGE_BEAN());

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

	public void onLoad(PhaseEvent ae){
		try{
			if(isBlockFlag()){
				helper.executeQuery(compositeAction);
				if(PM_IL_PROD_CONTRI_CHARGE_BEAN.getROWID() != null){
					helper.postQuery(PM_IL_PROD_CONTRI_CHARGE_BEAN);
				}else{
					helper.whenCreateRecord(PM_IL_PROD_CONTRI_CHARGE_BEAN);
				}
				helper.whenNewRecordInstance(this);
				setBlockFlag(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("ONLOAD", e.getMessage());
		}
	}


	/**
	 * Instantiates all components in PM_IL_PROD_CONTRI_CHARGE_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PCC_CHRG_CODE				 = new HtmlInputText();
		COMP_UI_M_PCC_CHRG_CODE_DESC	 = new HtmlInputText();
		COMP_PCC_CON_LMT_FM				 = new HtmlInputText();
		COMP_PCC_CON_LMT_TO				 = new HtmlInputText();
		COMP_PCC_POL_YR_FM				 = new HtmlInputText();
		COMP_PCC_POL_YR_TO				 = new HtmlInputText();
		COMP_PCC_RATE					 = new HtmlInputText();
		COMP_PCC_RATE_PER				 = new HtmlInputText();
		COMP_PCC_FIXED_AMT				 = new HtmlInputText();
		COMP_PCC_FLEX_01				 = new HtmlInputText();
		COMP_PCC_SR_NO					 = new HtmlInputText();
		COMP_PCC_SRC_OF_BUS				 = new HtmlInputText();
		COMP_UI_M_PROD_SRC_OF_BUS_DESC	 = new HtmlInputText();
		COMP_UI_M_FORMULA_CODE_DESC		 = new HtmlInputText();

		/*Added by Janani on 06.06.2017 for Fund allocation issue(204) as per Siva's suggestion*/

		COMP_PCC_CUST_SHARE_PERC 		= new HtmlInputText();

		/*End*/



		// Instantiating HtmlSelectOneMenu
		COMP_PCC_PREM_TOPUP_FLAG		 = new HtmlSelectOneMenu();
		COMP_PCC_MODE_OF_PYMT			 = new HtmlSelectOneMenu();
		COMP_PCC_CHRG_TYPE				 = new HtmlSelectOneMenu();
		COMP_PCC_APPLIED_ON				 = new HtmlSelectOneMenu();
		COMP_PCC_COV_CHARGE				 = new HtmlSelectOneMenu();	
		
		/*Added by saritha on 17-04-2018 for KIC Need to introduce policy fee for GOLDA. 0.2% of initial face amount with max cap of KD 200*/
		
		COMP_PCC_APPLY_PERIOD            = new HtmlSelectOneMenu();
		
		/*End*/
		
		// Instantiating HtmlCalendar
		COMP_PCC_EFF_FM_DT				 = new HtmlCalendar();
		COMP_PCC_EFF_TO_DT				 = new HtmlCalendar();

	}



	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PM_IL_PROD_CONTRI_CHARGE_BEAN = (PM_IL_PROD_CONTRI_CHARGE) dataTable
					.getRowData();
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setRowSelected(true);
			helper.postQuery(PM_IL_PROD_CONTRI_CHARGE_BEAN);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	public void validatePCC_CHRG_CODE(FacesContext context,UIComponent component ,Object value){
		try{
			String chargeCode = (String)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CHRG_CODE(chargeCode);
			helper.whenValidatePCC_CHRG_CODE(chargeCode, PM_IL_PROD_CONTRI_CHARGE_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validatePCC_CHRG_TYPE(FacesContext context,UIComponent component ,Object value){
		try{
			String chargeTyp = (String)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CHRG_TYPE(chargeTyp);
			helper.whenValidatePCC_CHRG_TYPE(this);
			//COMP_PCC_RATE_PER.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePCC_RATE(FacesContext context,UIComponent component ,Object value){
		try{
			Double rate = (Double)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_RATE(rate);
			helper.whenValidatePCC_RATE(PM_IL_PROD_CONTRI_CHARGE_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void validatePCC_RATE_PER(FacesContext context,UIComponent component ,Object value){
		try{
			Double rateper = (Double)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_RATE_PER(rateper);

		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}




	public void validatePCC_CON_LMT_FM(FacesContext context,UIComponent component,Object value){
		try{
			Double val = (Double)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CON_LMT_FM(val);
			helper.whenValidatePCC_CON_LMT_FM(val, PM_IL_PROD_CONTRI_CHARGE_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validatePCC_CON_LMT_TO(FacesContext context,UIComponent component,Object value){
		try{
			Double val = (Double)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CON_LMT_TO(val);
			helper.whenValidatePCC_CON_LMT_TO(val, PM_IL_PROD_CONTRI_CHARGE_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}



	public List<SelectItem> getListPCC_PREM_TOPUP_FLAG() {
		return listPCC_PREM_TOPUP_FLAG;
	}
	public void setListPCC_PREM_TOPUP_FLAG(List<SelectItem> listPCC_PREM_TOPUP_FLAG) {
		this.listPCC_PREM_TOPUP_FLAG = listPCC_PREM_TOPUP_FLAG;
	}
	public HtmlOutputLabel getCOMP_PCC_SR_NO_LABEL() {
		return COMP_PCC_SR_NO_LABEL;
	}
	public void setCOMP_PCC_SR_NO_LABEL(HtmlOutputLabel comp_pcc_sr_no_label) {
		COMP_PCC_SR_NO_LABEL = comp_pcc_sr_no_label;
	}
	public HtmlInputText getCOMP_PCC_SR_NO() {
		return COMP_PCC_SR_NO;
	}
	public void setCOMP_PCC_SR_NO(HtmlInputText comp_pcc_sr_no) {
		COMP_PCC_SR_NO = comp_pcc_sr_no;
	}
	public HtmlOutputLabel getCOMP_PCC_APPLIED_ON_LABEL() {
		return COMP_PCC_APPLIED_ON_LABEL;
	}
	public void setCOMP_PCC_APPLIED_ON_LABEL(
			HtmlOutputLabel comp_pcc_applied_on_label) {
		COMP_PCC_APPLIED_ON_LABEL = comp_pcc_applied_on_label;
	}
	public HtmlSelectOneMenu getCOMP_PCC_APPLIED_ON() {
		return COMP_PCC_APPLIED_ON;
	}
	public void setCOMP_PCC_APPLIED_ON(HtmlSelectOneMenu comp_pcc_applied_on) {
		COMP_PCC_APPLIED_ON = comp_pcc_applied_on;
	}
	public HtmlOutputLabel getCOMP_PCC_SRC_OF_BUS_LABEL() {
		return COMP_PCC_SRC_OF_BUS_LABEL;
	}
	public void setCOMP_PCC_SRC_OF_BUS_LABEL(
			HtmlOutputLabel comp_pcc_src_of_bus_label) {
		COMP_PCC_SRC_OF_BUS_LABEL = comp_pcc_src_of_bus_label;
	}
	public HtmlInputText getCOMP_PCC_SRC_OF_BUS() {
		return COMP_PCC_SRC_OF_BUS;
	}
	public void setCOMP_PCC_SRC_OF_BUS(HtmlInputText comp_pcc_src_of_bus) {
		COMP_PCC_SRC_OF_BUS = comp_pcc_src_of_bus;
	}
	public HtmlOutputLabel getCOMP_PCC_POL_YR_TO_LABEL() {
		return COMP_PCC_POL_YR_TO_LABEL;
	}
	public void setCOMP_PCC_POL_YR_TO_LABEL(HtmlOutputLabel comp_pcc_pol_yr_to_label) {
		COMP_PCC_POL_YR_TO_LABEL = comp_pcc_pol_yr_to_label;
	}
	public HtmlInputText getCOMP_PCC_POL_YR_TO() {
		return COMP_PCC_POL_YR_TO;
	}
	public void setCOMP_PCC_POL_YR_TO(HtmlInputText comp_pcc_pol_yr_to) {
		COMP_PCC_POL_YR_TO = comp_pcc_pol_yr_to;
	}
	public HtmlCalendar getCOMP_PCC_EFF_FM_DT() {
		return COMP_PCC_EFF_FM_DT;
	}
	public void setCOMP_PCC_EFF_FM_DT(HtmlCalendar comp_pcc_eff_fm_dt) {
		COMP_PCC_EFF_FM_DT = comp_pcc_eff_fm_dt;
	}
	public HtmlCalendar getCOMP_PCC_EFF_TO_DT() {
		return COMP_PCC_EFF_TO_DT;
	}
	public void setCOMP_PCC_EFF_TO_DT(HtmlCalendar comp_pcc_eff_to_dt) {
		COMP_PCC_EFF_TO_DT = comp_pcc_eff_to_dt;
	}
	public HtmlOutputLabel getCOMP_PCC_EFF_FM_DT_LABEL() {
		return COMP_PCC_EFF_FM_DT_LABEL;
	}
	public void setCOMP_PCC_EFF_FM_DT_LABEL(HtmlOutputLabel comp_pcc_eff_fm_dt_label) {
		COMP_PCC_EFF_FM_DT_LABEL = comp_pcc_eff_fm_dt_label;
	}

	public HtmlOutputLabel getCOMP_PCC_EFF_TO_DT_LABEL() {
		return COMP_PCC_EFF_TO_DT_LABEL;
	}
	public void setCOMP_PCC_EFF_TO_DT_LABEL(HtmlOutputLabel comp_pcc_eff_to_dt_label) {
		COMP_PCC_EFF_TO_DT_LABEL = comp_pcc_eff_to_dt_label;
	}
	public HtmlInputText getCOMP_UI_M_PROD_SRC_OF_BUS_DESC() {
		return COMP_UI_M_PROD_SRC_OF_BUS_DESC;
	}
	public void setCOMP_UI_M_PROD_SRC_OF_BUS_DESC(
			HtmlInputText comp_ui_m_prod_src_of_bus_desc) {
		COMP_UI_M_PROD_SRC_OF_BUS_DESC = comp_ui_m_prod_src_of_bus_desc;
	}

	public List<LovBean> lovUI_M_SRC_BUS(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND  " +
					"ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND " +
					"(PC_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SRC_CODE", e.getMessage());
		}
		return suggestionList;
	}


	public List<LovBean> lovUI_M_CHARGE_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_CHARGE' AND  " +
					"ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE='IL_CHARGE' AND " +
					"(PC_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";
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


	public List<LovBean> lovUI_M_FORMULA_CODE(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE " +
					"ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT FRM_CODE,FRM_DESC FROM PM_IL_FORMULA WHERE  " +
					"(FRM_CODE LIKE ? ) " +
					"AND ROWNUM < ? ORDER BY 1";
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("FORMULA_CODE", e.getMessage());
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


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void validatePCC_SRC_OF_BUS(FacesContext context,UIComponent component ,Object value){
		try{
			String srcCode = (String)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_SRC_OF_BUS(srcCode);
			helper.whenValidatePCC_SRC_OF_BUS(srcCode, PM_IL_PROD_CONTRI_CHARGE_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateFormulaCode(FacesContext context,UIComponent component ,Object value){
		try{
			String formulaCode=(String)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_FLEX_01(formulaCode);
			helper.whenValidateFormulaCode(formulaCode,PM_IL_PROD_CONTRI_CHARGE_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateAPPLIED_ON(FacesContext context,UIComponent component ,Object value){
		try{
			String appliedOn = (String)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_APPLIED_ON(appliedOn);
			helper.whenValidateAPPLIED_ON(appliedOn, compositeAction);
			COMP_PCC_RATE.resetValue();
			COMP_PCC_RATE_PER.resetValue();
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateCOVER_CHARGE(FacesContext context,UIComponent component ,Object value){
		try{
			String coverCharge = (String)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_TYPE(coverCharge);

		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * Resets all components in PM_IL_PROD_CONTRI_CHARGE_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PCC_CHRG_CODE.resetValue();
		COMP_UI_M_PCC_CHRG_CODE_DESC.resetValue();
		COMP_PCC_CON_LMT_FM.resetValue();
		COMP_PCC_CON_LMT_TO.resetValue();
		COMP_PCC_POL_YR_FM.resetValue();
		COMP_PCC_POL_YR_TO.resetValue();
		COMP_PCC_RATE.resetValue();
		COMP_PCC_RATE_PER.resetValue();
		COMP_PCC_FIXED_AMT.resetValue();
		COMP_PCC_FLEX_01.resetValue();
		COMP_PCC_SR_NO.resetValue();
		COMP_PCC_SRC_OF_BUS.resetValue();
		COMP_UI_M_PROD_SRC_OF_BUS_DESC.resetValue();
		COMP_UI_M_FORMULA_CODE_DESC.resetValue();

		/*Added by Janani on 06.06.2017 for Fund allocation issue(204) as per Siva's suggestion*/

		COMP_PCC_CUST_SHARE_PERC.resetValue();

		/*End*/


		// Reseting HtmlSelectOneMenu
		COMP_PCC_PREM_TOPUP_FLAG.resetValue();
		COMP_PCC_MODE_OF_PYMT.resetValue();
		COMP_PCC_CHRG_TYPE.resetValue();
		COMP_PCC_APPLIED_ON.resetValue();
		COMP_PCC_COV_CHARGE.resetValue();

		// Reseting HtmlCalendar
		COMP_PCC_EFF_FM_DT.resetValue();
		COMP_PCC_EFF_TO_DT.resetValue();
		
		/*Added by saritha on 17-04-2018 for KIC Need to introduce policy fee for GOLDA. 0.2% of initial face amount with max cap of KD 200*/
		COMP_PCC_APPLY_PERIOD.resetValue();		
		/*End*/
		

	}

	public List<SelectItem> getListPCC_MODE_OF_PYMT() {
		return listPCC_MODE_OF_PYMT;
	}
	public void setListPCC_MODE_OF_PYMT(List<SelectItem> listPCC_MODE_OF_PYMT) {
		this.listPCC_MODE_OF_PYMT = listPCC_MODE_OF_PYMT;
	}
	public List<SelectItem> getListPCC_CHRG_TYPE() {
		return listPCC_CHRG_TYPE;
	}
	public void setListPCC_CHRG_TYPE(List<SelectItem> listPCC_CHRG_TYPE) {
		this.listPCC_CHRG_TYPE = listPCC_CHRG_TYPE;
	}
	public List<SelectItem> getListPCC_APPLIED_ON() {
		return listPCC_APPLIED_ON;
	}
	public void setListPCC_APPLIED_ON(List<SelectItem> listPCC_APPLIED_ON) {
		this.listPCC_APPLIED_ON = listPCC_APPLIED_ON;
	}
	public List<PM_IL_PROD_CONTRI_CHARGE> getDataList_PM_IL_PROD_CONTRI_CHARGE() {
		return dataList_PM_IL_PROD_CONTRI_CHARGE;
	}
	public void setDataList_PM_IL_PROD_CONTRI_CHARGE(
			List<PM_IL_PROD_CONTRI_CHARGE> dataList_PM_IL_PROD_CONTRI_CHARGE) {
		this.dataList_PM_IL_PROD_CONTRI_CHARGE = dataList_PM_IL_PROD_CONTRI_CHARGE;
	}
	public HtmlInputText getCOMP_UI_M_FLEX1() {
		return COMP_UI_M_FLEX1;
	}
	public void setCOMP_UI_M_FLEX1(HtmlInputText comp_ui_m_flex1) {
		COMP_UI_M_FLEX1 = comp_ui_m_flex1;
	}
	public HtmlOutputLabel getCOMP_UI_M_FLEX1_LABEL() {
		return COMP_UI_M_FLEX1_LABEL;
	}
	public void setCOMP_UI_M_FLEX1_LABEL(HtmlOutputLabel comp_ui_m_flex1_label) {
		COMP_UI_M_FLEX1_LABEL = comp_ui_m_flex1_label;
	}
	public HtmlInputText getCOMP_UI_M_FORMULA_CODE_DESC() {
		return COMP_UI_M_FORMULA_CODE_DESC;
	}
	public void setCOMP_UI_M_FORMULA_CODE_DESC(
			HtmlInputText comp_ui_m_formula_code_desc) {
		COMP_UI_M_FORMULA_CODE_DESC = comp_ui_m_formula_code_desc;
	}
	public HtmlOutputLabel getCOMP_PCC_COV_CHARGE_LABEL() {
		return COMP_PCC_COV_CHARGE_LABEL;
	}
	public void setCOMP_PCC_COV_CHARGE_LABEL(
			HtmlOutputLabel comp_pcc_cov_charge_label) {
		COMP_PCC_COV_CHARGE_LABEL = comp_pcc_cov_charge_label;
	}
	public HtmlSelectOneMenu getCOMP_PCC_COV_CHARGE() {
		return COMP_PCC_COV_CHARGE;
	}
	public void setCOMP_PCC_COV_CHARGE(HtmlSelectOneMenu comp_pcc_cov_charge) {
		COMP_PCC_COV_CHARGE = comp_pcc_cov_charge;
	}
	public List<SelectItem> getListPCC_COVER_CHARGE() {
		return listPCC_COVER_CHARGE;
	}
	public void setListPCC_COVER_CHARGE(List<SelectItem> listPCC_COVER_CHARGE) {
		this.listPCC_COVER_CHARGE = listPCC_COVER_CHARGE;
	}



	/*Added by Janani on 06.06.2017 for Fund allocation issue(204) as per Siva's suggestion*/

	private HtmlOutputLabel COMP_PCC_CUST_SHARE_PERC_LABEL;

	private HtmlInputText COMP_PCC_CUST_SHARE_PERC;


	private boolean postClick;

	public boolean isPostClick() {
		return postClick;
	}

	public void setPostClick(boolean postClick) {
		this.postClick = postClick;
	}

	public HtmlOutputLabel getCOMP_PCC_CUST_SHARE_PERC_LABEL() {
		return COMP_PCC_CUST_SHARE_PERC_LABEL;
	}
	public void setCOMP_PCC_CUST_SHARE_PERC_LABEL(
			HtmlOutputLabel cOMP_PCC_CUST_SHARE_PERC_LABEL) {
		COMP_PCC_CUST_SHARE_PERC_LABEL = cOMP_PCC_CUST_SHARE_PERC_LABEL;
	}
	public HtmlInputText getCOMP_PCC_CUST_SHARE_PERC() {
		return COMP_PCC_CUST_SHARE_PERC;
	}
	public void setCOMP_PCC_CUST_SHARE_PERC(HtmlInputText cOMP_PCC_CUST_SHARE_PERC) {
		COMP_PCC_CUST_SHARE_PERC = cOMP_PCC_CUST_SHARE_PERC;
	}


	public void validationPCC_CUST_SHARE_PERC(FacesContext context,UIComponent component,Object value){
		try{
			Double val = (Double)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_CUST_SHARE_PERC(val);
			helper.whenValidatePCC_CUST_SHARE_PERC(this, PM_IL_PROD_CONTRI_CHARGE_BEAN);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	public void setPCC_MODE_OF_PYMT_UPDATE(ActionEvent event) {

		setPostClick(false);
		System.out.println("Welcome to setPCC_MODE_OF_PYMT_UPDATE");
		CommonUtils.clearMaps(this);
		String documentType=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		PM_IL_PROD_CONTRI_CHARGE_BEAN = (PM_IL_PROD_CONTRI_CHARGE)dataList_PM_IL_PROD_CONTRI_CHARGE.get(currentIndex);
		PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_MODE_OF_PYMT(documentType);

		dataList_PM_IL_PROD_CONTRI_CHARGE.set(currentIndex, PM_IL_PROD_CONTRI_CHARGE_BEAN);

		COMP_PCC_MODE_OF_PYMT.resetValue();

		System.out.println("dataList_PM_IL_PROD_CONTRI_CHARGE       "+((PM_IL_PROD_CONTRI_CHARGE)dataList_PM_IL_PROD_CONTRI_CHARGE.get(currentIndex)).getPCC_MODE_OF_PYMT());
	}



	/*End*/
	
	/*Added by saritha on 17-04-2018 for KIC Need to introduce policy fee for GOLDA. 0.2% of initial face amount with max cap of KD 200*/
	
	private HtmlOutputLabel COMP_PCC_APPLY_PERIOD_LABEL;

	public HtmlOutputLabel getCOMP_PCC_APPLY_PERIOD_LABEL() {
		return COMP_PCC_APPLY_PERIOD_LABEL;
	}
	public void setCOMP_PCC_APPLY_PERIOD_LABEL(
			HtmlOutputLabel cOMP_PCC_APPLY_PERIOD_LABEL) {
		COMP_PCC_APPLY_PERIOD_LABEL = cOMP_PCC_APPLY_PERIOD_LABEL;
	}

	private HtmlSelectOneMenu COMP_PCC_APPLY_PERIOD;

	public HtmlSelectOneMenu getCOMP_PCC_APPLY_PERIOD() {
		return COMP_PCC_APPLY_PERIOD;
	}
	public void setCOMP_PCC_APPLY_PERIOD(HtmlSelectOneMenu cOMP_PCC_APPLY_PERIOD) {
		COMP_PCC_APPLY_PERIOD = cOMP_PCC_APPLY_PERIOD;
	} 

	private List<SelectItem> listPCC_APPLY_PERIOD =  new ArrayList<SelectItem>();

	public List<SelectItem> getListPCC_APPLY_PERIOD() {
		return listPCC_APPLY_PERIOD;
	}
	public void setListPCC_APPLY_PERIOD(List<SelectItem> listPCC_APPLY_PERIOD) {
		this.listPCC_APPLY_PERIOD = listPCC_APPLY_PERIOD;
	}

	public void validatePCC_APPLY_PERIOD(FacesContext context,UIComponent component ,Object value){
		try{
			String applyPeriod = (String)value;
			PM_IL_PROD_CONTRI_CHARGE_BEAN.setPCC_APPLY_PERIOD(applyPeriod);

		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	/*End*/
	

}
