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
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_MED_EXAM_DTL_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PMED_EXAM_CODE_LABEL;

	private HtmlInputText COMP_PMED_EXAM_CODE;

	private HtmlOutputLabel COMP_PMED_CLINIC_CODE_LABEL;

	private HtmlInputText COMP_PMED_CLINIC_CODE;

	private HtmlOutputLabel COMP_UI_M_CLINIC_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CLINIC_CODE_DESC;

	private HtmlOutputLabel COMP_PMED_DEL_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_PMED_DEL_FLAG;

	private HtmlOutputLabel COMP_PMED_PVT_LC_AMT_LABEL;

	private HtmlInputText COMP_PMED_PVT_LC_AMT;

	private HtmlOutputLabel COMP_PMED_GOVT_LC_AMT_LABEL;

	private HtmlInputText COMP_PMED_GOVT_LC_AMT;

	private HtmlOutputLabel COMP_PMED_STATUS_LABEL;

	private HtmlSelectOneMenu COMP_PMED_STATUS;

	private HtmlOutputLabel COMP_PMED_REP_REC_DT_LABEL;

	private HtmlCalendar COMP_PMED_REP_REC_DT;

	private HtmlOutputLabel COMP_UI_M_SUM_PVT_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_SUM_PVT_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_SUM_GOVT_LC_AMT_LABEL;

	private HtmlInputText COMP_UI_M_SUM_GOVT_LC_AMT;

	private HtmlOutputLabel COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_MED_EXAM_CODE_DESC;

	private PT_IL_POL_MED_EXAM_DTL_1 PT_IL_POL_MED_EXAM_DTL_1_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_MED_EXAM_DTL_1_HELPER helper;

	private List<PT_IL_POL_MED_EXAM_DTL_1> dataList_PT_IL_POL_MED_EXAM_DTL_1 = new ArrayList<PT_IL_POL_MED_EXAM_DTL_1>();

	private UIData dataTable;

	private List<SelectItem> listPMED_STATUS = new ArrayList<SelectItem>();

	public PT_IL_POL_MED_EXAM_DTL_1_ACTION() {

		PT_IL_POL_MED_EXAM_DTL_1_BEAN = new PT_IL_POL_MED_EXAM_DTL_1();
		helper = new PT_IL_POL_MED_EXAM_DTL_1_HELPER();
		instantiateAllComponent();
		preparDropDownList();
	}
	public void preparDropDownList(){
   	 Connection connection = null;
   	 try{
   	 connection = CommonUtils.getConnection();
   	 
   	 /* listPMED_STATUS = ListItemUtil.getDropDownListValue(
   			    connection, "PILT002_APAC", "PT_IL_POL_MED_EXAM_DTL_1",
   			    "PT_IL_POL_MED_EXAM_DTL_1.PMED_STATUS", "YESNO");*/
   	 
 	listPMED_STATUS = ListItemUtil.getDropDownListValue(connection,
			"PILT002_APAC", "PT_IL_POL_MED_EXAM_DTL",
			"PT_IL_POL_MED_EXAM_DTL.PMED_STATUS", "CHKLST_STS");
   	
   	 
   	 }catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
   	 
    }

	public PT_IL_POL_MED_EXAM_DTL_1 getPT_IL_POL_MED_EXAM_DTL_1_BEAN() {
		return PT_IL_POL_MED_EXAM_DTL_1_BEAN;
	}

	public void setPT_IL_POL_MED_EXAM_DTL_1_BEAN(
			PT_IL_POL_MED_EXAM_DTL_1 PT_IL_POL_MED_EXAM_DTL_1_BEAN) {
		this.PT_IL_POL_MED_EXAM_DTL_1_BEAN = PT_IL_POL_MED_EXAM_DTL_1_BEAN;
	}

	public List<PT_IL_POL_MED_EXAM_DTL_1> getDataList_PT_IL_POL_MED_EXAM_DTL_1() {
		return dataList_PT_IL_POL_MED_EXAM_DTL_1;
	}

	public void setDataListPT_IL_POL_MED_EXAM_DTL_1(
			List<PT_IL_POL_MED_EXAM_DTL_1> dataList_PT_IL_POL_MED_EXAM_DTL_1) {
		this.dataList_PT_IL_POL_MED_EXAM_DTL_1 = dataList_PT_IL_POL_MED_EXAM_DTL_1;
	}

	public void addRow(ActionEvent event) {
		String message = null;
		getErrorMap().clear();
		getWarningMap().clear();
		try {
			if (isINSERT_ALLOWED()) {
				
				PT_IL_POL_MED_EXAM_DTL_1_BEAN = new PT_IL_POL_MED_EXAM_DTL_1();
				helper.whenCreateRecord(getPT_IL_POL_MED_EXAM_DTL_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN()
								.getPT_IL_POLICY_BEAN());
				COMP_PMED_EXAM_CODE.setDisabled(false);
				resetAllComponent();
				
				/*Modified by Janani on 07.05.2018 for Fidelity as suggested by Sivaram*/
				//resetSelectedRow();
				
				resetRowAtCreate();
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");

				/*End*/
				
				
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed");
				getErrorMap().put("addRow", message);

				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

			}

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				helper.keyDelRec(this, compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN());
				new CRUDHandler().executeDelete(PT_IL_POL_MED_EXAM_DTL_1_BEAN,
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
				dataList_PT_IL_POL_MED_EXAM_DTL_1
						.remove(PT_IL_POL_MED_EXAM_DTL_1_BEAN);
				if (dataList_PT_IL_POL_MED_EXAM_DTL_1.size() > 0) {

					PT_IL_POL_MED_EXAM_DTL_1_BEAN = dataList_PT_IL_POL_MED_EXAM_DTL_1
							.get(0);
				} else if (dataList_PT_IL_POL_MED_EXAM_DTL_1.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setRowSelected(true);
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
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		String message = null;
		
		/*Added by Janani for Fidelity on 08.05.2018*/
		CommonUtils.clearMaps(this);
		/*End*/
		
		try {
			
			/*Added by Janani for Fidelity on 08.05.2018*/
			if(!CommonUtils.nvl(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getPMED_CLINIC_CODE(), "temp").equals("temp"))
			{
				
				if(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getPMED_REP_REC_DT() != null && 
						PT_IL_POL_MED_EXAM_DTL_1_BEAN.getPMED_REP_REC_DT().after(new CommonUtils().getCurrentDate())){
					System.out.println("Enter into date checking condition");
					String message1="Date Should not exceed current date";
					getErrorMap().put("current", message1);
				}else{
					
			/*End*/
			
			if (PT_IL_POL_MED_EXAM_DTL_1_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(getPT_IL_POL_MED_EXAM_DTL_1_BEAN(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());

				new CRUDHandler().executeInsert(PT_IL_POL_MED_EXAM_DTL_1_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				getWarningMap().put("postRecord", message);

				dataList_PT_IL_POL_MED_EXAM_DTL_1
						.add(PT_IL_POL_MED_EXAM_DTL_1_BEAN);
			} else if (PT_IL_POL_MED_EXAM_DTL_1_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				/*Added by Janani for Fidelity on 08.05.2018*/
				
				if(PT_IL_POL_MED_EXAM_DTL_1_BEAN.isUPDATE_ALL())
				{
					/*
					 * COMMENTED BY DHINESH ON 19-06-2017 FOR SSP CALL ID 
					 * 
					 * CommonUtils.updateAllRecords(dataList_PT_IL_POL_MED_EXAM_DTL, PT_IL_POL_MED_EXAM_DTL_1_BEAN.getStartIndex(), PT_IL_POL_MED_EXAM_DTL_1_BEAN.getEndindex());*/
					
					CommonUtils.updateAllRecords(dataList_PT_IL_POL_MED_EXAM_DTL_1, PT_IL_POL_MED_EXAM_DTL_1_BEAN.getStartIndex(), dataList_PT_IL_POL_MED_EXAM_DTL_1.size());
				}
				else
				{
				
				/*End*/
				helper.preUpdate(getPT_IL_POL_MED_EXAM_DTL_1_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_MED_EXAM_DTL_1_BEAN,
						CommonUtils.getConnection());
				}
			message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				/*getWarningMap().put("postRecord", message);*/

			}

			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setRowSelected(true);
			CommonUtils.getConnection().commit();
			
				
			}
			
			}
			
			else
			{
				System.out.println("Enter the post condition");
				String message1="Enter the clinic code";
				getErrorMap().put("current", message1);
			}
			
			
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
			PT_IL_POL_MED_EXAM_DTL_1_BEAN = (PT_IL_POL_MED_EXAM_DTL_1) dataTable
					.getRowData();
			helper.postQuery(this, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			helper.whenNewRecordInstance(this);
		
           PT_IL_POL_MED_EXAM_DTL_1_BEAN.setRowSelected(true);
           
           /*Added by Janani on 07.05.2018 for Fidelity as suggested by Sivaram*/
		
           enableFields();			
           
           /*End*/
           
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	public void validatePMED_REP_REC_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_REP_REC_DT((Date) value);
			PMED_REP_REC_DT_WHEN_VALIDATE_ITEM(compositeAction);
			getCOMP_PMED_REP_REC_DT().setRendered(true);

			//COMP_PMED_REP_REC_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PMED_REP_REC_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void PMED_REP_REC_DT_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		Date POL_START_DT = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_START_DT();
		Date PMED_REP_REC_DT = compositeAction
				.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN()
				.getPT_IL_POL_MED_EXAM_DTL_1_BEAN().getPMED_REP_REC_DT();

		if ((PMED_REP_REC_DT.before(POL_START_DT))
				|| (PMED_REP_REC_DT.after(new CommonUtils().getCurrentDate()))) {
			try {
				//throw new Exception("Rec Date should between" +POL_START_DT +"and"+ new CommonUtils().getCurrentDate());
				throw new Exception("Rec date must fall within policy start date and system date");
						
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}

		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_MED_EXAM_DTL_1> PT_IL_POL_MED_EXAM_DTL_1_ITR = dataList_PT_IL_POL_MED_EXAM_DTL_1
				.iterator();
		while (PT_IL_POL_MED_EXAM_DTL_1_ITR.hasNext()) {
			
			/*Modified by Janani on 07.05.2018 for Fidelity as suggested by Sivaram*/

			//PT_IL_POL_MED_EXAM_DTL_1_ITR.next().setRowSelected(false);
			PT_IL_POL_MED_EXAM_DTL_1_BEAN = PT_IL_POL_MED_EXAM_DTL_1_ITR.next();
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setRowSelected(false);

			/*End*/
			
		}
	}

	private void resetAllComponent() {
		COMP_PMED_EXAM_CODE.resetValue();
		////COMP_PMED_EXAM_CODE.resetValue();
		COMP_PMED_CLINIC_CODE.resetValue();
		//COMP_PMED_CLINIC_CODE.resetValue();
		COMP_UI_M_CLINIC_CODE_DESC.resetValue();
		//COMP_UI_M_CLINIC_CODE_DESC.resetValue();
		COMP_PMED_PVT_LC_AMT.resetValue();
		//COMP_PMED_PVT_LC_AMT.resetValue();
		COMP_PMED_GOVT_LC_AMT.resetValue();
		//COMP_PMED_GOVT_LC_AMT.resetValue();
		COMP_PMED_STATUS.resetValue();
		//COMP_PMED_STATUS.resetValue();
		COMP_PMED_REP_REC_DT.resetValue();
		//COMP_PMED_REP_REC_DT.resetValue();
		COMP_UI_M_SUM_PVT_LC_AMT.resetValue();
		//COMP_UI_M_SUM_PVT_LC_AMT.resetValue();
		COMP_UI_M_SUM_GOVT_LC_AMT.resetValue();
		//COMP_UI_M_SUM_GOVT_LC_AMT.resetValue();
		///COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
		COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
		COMP_PMED_DEL_FLAG.resetValue();
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
			getWarningMap().put(
					"postRecord",
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

	public HtmlOutputLabel getCOMP_PMED_EXAM_CODE_LABEL() {
		return COMP_PMED_EXAM_CODE_LABEL;
	}

	public void setCOMP_PMED_EXAM_CODE_LABEL(
			HtmlOutputLabel comp_pmed_exam_code_label) {
		COMP_PMED_EXAM_CODE_LABEL = comp_pmed_exam_code_label;
	}

	public HtmlInputText getCOMP_PMED_EXAM_CODE() {
		return COMP_PMED_EXAM_CODE;
	}

	public void setCOMP_PMED_EXAM_CODE(HtmlInputText comp_pmed_exam_code) {
		COMP_PMED_EXAM_CODE = comp_pmed_exam_code;
	}

	public HtmlOutputLabel getCOMP_PMED_CLINIC_CODE_LABEL() {
		return COMP_PMED_CLINIC_CODE_LABEL;
	}

	public void setCOMP_PMED_CLINIC_CODE_LABEL(
			HtmlOutputLabel comp_pmed_clinic_code_label) {
		COMP_PMED_CLINIC_CODE_LABEL = comp_pmed_clinic_code_label;
	}

	public HtmlInputText getCOMP_PMED_CLINIC_CODE() {
		return COMP_PMED_CLINIC_CODE;
	}

	public void setCOMP_PMED_CLINIC_CODE(HtmlInputText comp_pmed_clinic_code) {
		COMP_PMED_CLINIC_CODE = comp_pmed_clinic_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLINIC_CODE_DESC_LABEL() {
		return COMP_UI_M_CLINIC_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CLINIC_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_clinic_code_desc_label) {
		COMP_UI_M_CLINIC_CODE_DESC_LABEL = comp_ui_m_clinic_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_CLINIC_CODE_DESC() {
		return COMP_UI_M_CLINIC_CODE_DESC;
	}

	public void setCOMP_UI_M_CLINIC_CODE_DESC(
			HtmlInputText comp_ui_m_clinic_code_desc) {
		COMP_UI_M_CLINIC_CODE_DESC = comp_ui_m_clinic_code_desc;
	}

	public HtmlOutputLabel getCOMP_PMED_PVT_LC_AMT_LABEL() {
		return COMP_PMED_PVT_LC_AMT_LABEL;
	}

	public void setCOMP_PMED_PVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_pmed_pvt_lc_amt_label) {
		COMP_PMED_PVT_LC_AMT_LABEL = comp_pmed_pvt_lc_amt_label;
	}

	public HtmlInputText getCOMP_PMED_PVT_LC_AMT() {
		return COMP_PMED_PVT_LC_AMT;
	}

	public void setCOMP_PMED_PVT_LC_AMT(HtmlInputText comp_pmed_pvt_lc_amt) {
		COMP_PMED_PVT_LC_AMT = comp_pmed_pvt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_PMED_GOVT_LC_AMT_LABEL() {
		return COMP_PMED_GOVT_LC_AMT_LABEL;
	}

	public void setCOMP_PMED_GOVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_pmed_govt_lc_amt_label) {
		COMP_PMED_GOVT_LC_AMT_LABEL = comp_pmed_govt_lc_amt_label;
	}

	public HtmlInputText getCOMP_PMED_GOVT_LC_AMT() {
		return COMP_PMED_GOVT_LC_AMT;
	}

	public void setCOMP_PMED_GOVT_LC_AMT(HtmlInputText comp_pmed_govt_lc_amt) {
		COMP_PMED_GOVT_LC_AMT = comp_pmed_govt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_PMED_STATUS_LABEL() {
		return COMP_PMED_STATUS_LABEL;
	}

	public void setCOMP_PMED_STATUS_LABEL(HtmlOutputLabel comp_pmed_status_label) {
		COMP_PMED_STATUS_LABEL = comp_pmed_status_label;
	}

	public HtmlSelectOneMenu getCOMP_PMED_STATUS() {
		return COMP_PMED_STATUS;
	}

	public void setCOMP_PMED_STATUS(HtmlSelectOneMenu comp_pmed_status) {
		COMP_PMED_STATUS = comp_pmed_status;
	}

	public HtmlOutputLabel getCOMP_PMED_REP_REC_DT_LABEL() {
		return COMP_PMED_REP_REC_DT_LABEL;
	}

	public void setCOMP_PMED_REP_REC_DT_LABEL(
			HtmlOutputLabel comp_pmed_rep_rec_dt_label) {
		COMP_PMED_REP_REC_DT_LABEL = comp_pmed_rep_rec_dt_label;
	}

	public HtmlCalendar getCOMP_PMED_REP_REC_DT() {
		return COMP_PMED_REP_REC_DT;
	}

	public void setCOMP_PMED_REP_REC_DT(HtmlCalendar comp_pmed_rep_rec_dt) {
		COMP_PMED_REP_REC_DT = comp_pmed_rep_rec_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_PVT_LC_AMT_LABEL() {
		return COMP_UI_M_SUM_PVT_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_SUM_PVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_sum_pvt_lc_amt_label) {
		COMP_UI_M_SUM_PVT_LC_AMT_LABEL = comp_ui_m_sum_pvt_lc_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_SUM_PVT_LC_AMT() {
		return COMP_UI_M_SUM_PVT_LC_AMT;
	}

	public void setCOMP_UI_M_SUM_PVT_LC_AMT(
			HtmlInputText comp_ui_m_sum_pvt_lc_amt) {
		COMP_UI_M_SUM_PVT_LC_AMT = comp_ui_m_sum_pvt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUM_GOVT_LC_AMT_LABEL() {
		return COMP_UI_M_SUM_GOVT_LC_AMT_LABEL;
	}

	public void setCOMP_UI_M_SUM_GOVT_LC_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_sum_govt_lc_amt_label) {
		COMP_UI_M_SUM_GOVT_LC_AMT_LABEL = comp_ui_m_sum_govt_lc_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_SUM_GOVT_LC_AMT() {
		return COMP_UI_M_SUM_GOVT_LC_AMT;
	}

	public void setCOMP_UI_M_SUM_GOVT_LC_AMT(
			HtmlInputText comp_ui_m_sum_govt_lc_amt) {
		COMP_UI_M_SUM_GOVT_LC_AMT = comp_ui_m_sum_govt_lc_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_MED_EXAM_CODE_DESC_LABEL() {
		return COMP_UI_M_MED_EXAM_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MED_EXAM_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_med_exam_code_desc_label) {
		COMP_UI_M_MED_EXAM_CODE_DESC_LABEL = comp_ui_m_med_exam_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_MED_EXAM_CODE_DESC() {
		return COMP_UI_M_MED_EXAM_CODE_DESC;
	}

	public void setCOMP_UI_M_MED_EXAM_CODE_DESC(
			HtmlInputText comp_ui_m_med_exam_code_desc) {
		COMP_UI_M_MED_EXAM_CODE_DESC = comp_ui_m_med_exam_code_desc;
	}

	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_MED_EXAM_DTL_1_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_MED_EXAM_DTL_1_HELPER helper) {
		this.helper = helper;
	}

	public List<SelectItem> getListPMED_STATUS() {
		return listPMED_STATUS;
	}

	public void setListPMED_STATUS(List<SelectItem> listPMED_STATUS) {
		this.listPMED_STATUS = listPMED_STATUS;
	}

	public void setDataList_PT_IL_POL_MED_EXAM_DTL_1(
			List<PT_IL_POL_MED_EXAM_DTL_1> dataList_PT_IL_POL_MED_EXAM_DTL_1) {
		this.dataList_PT_IL_POL_MED_EXAM_DTL_1 = dataList_PT_IL_POL_MED_EXAM_DTL_1;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				/*Added by Janani on 07.05.2018 for Fidelity as suggested by Sivaram*/
				prepareCLINIC_CODElov();
				
				/*End*/
				helper.whenNewBlockInstance(compositeAction);
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getROWID() != null){
				helper.postQuery(this, compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				}
				else{
				helper.whenCreateRecord(compositeAction.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN()
						.getPT_IL_POL_MED_EXAM_DTL_1_BEAN(), compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
				}
				
				helper.whenNewRecordInstance(this);
				
				PT_IL_POL_MED_EXAM_DTL_1_BEAN.setDataTable(dataTable);
				
				setBlockFlag(false);
				
				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS().equalsIgnoreCase("N"))
				{
					setUPDATE_ALLOWED(true);
					PT_IL_POL_MED_EXAM_DTL_1_BEAN.setUPDATE_ALL(true);
				}
		
			}
			
			
			
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()!=null &&
					   compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("Y")){
				
				disableAllComponent(true);
			}
			else if(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getPMED_STATUS().equalsIgnoreCase("Y"))
			{
				disableAllComponent(true);
				COMP_PMED_STATUS.setDisabled(false);
				COMP_PMED_REP_REC_DT.setDisabled(false);
				
				
			}else
			{
				disableAllComponent(false);
				COMP_PMED_EXAM_CODE.setDisabled(true);
			}	
			
			//helper.whenNewRecordInstance(this);
			if(this.getPT_IL_POL_MED_EXAM_DTL_1_BEAN().getROWID()==null){
				COMP_PMED_EXAM_CODE.setDisabled(false);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_PMED_DEL_FLAG_LABEL() {
		return COMP_PMED_DEL_FLAG_LABEL;
	}

	public void setCOMP_PMED_DEL_FLAG_LABEL(
			HtmlOutputLabel comp_pmed_del_flag_label) {
		COMP_PMED_DEL_FLAG_LABEL = comp_pmed_del_flag_label;
	}

	public HtmlSelectBooleanCheckbox getCOMP_PMED_DEL_FLAG() {
		return COMP_PMED_DEL_FLAG;
	}

	public void setCOMP_PMED_DEL_FLAG(
			HtmlSelectBooleanCheckbox comp_pmed_del_flag) {
		COMP_PMED_DEL_FLAG = comp_pmed_del_flag;
	}

	public void PMED_EXAM_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			String prevValue = getPT_IL_POL_MED_EXAM_DTL_1_BEAN().getPMED_EXAM_CODE();
			String currValue = (String) value;
			if(!currValue.equalsIgnoreCase(prevValue)){
			getPT_IL_POL_MED_EXAM_DTL_1_BEAN() 
					.setPMED_EXAM_CODE((String) value);
			helper.PMED_EXAM_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_MED_EXAM_DTL_1_BEAN());
			getCOMP_UI_M_MED_EXAM_CODE_DESC().resetValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String str=null;
		try {
			getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setPMED_CLINIC_CODE(
					(String) value);
			 str = helper.PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_MED_EXAM_DTL_1_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			getCOMP_UI_M_CLINIC_CODE_DESC().resetValue();
			getWarningMap().put("mess", str);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
			
		}
	}

	public void PMED_STATUS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setPMED_STATUS((String) value);
			/*helper.PMED_STATUS_WHEN_VALIDATE_ITEM(this);*/
			
			helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN(),compositeAction);
			

			COMP_PMED_REP_REC_DT.resetValue();

			
			/*Added by Ameen on 07-06-2017 for ZBILQC-1726894*/
			if("Y".equalsIgnoreCase(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getPMED_STATUS())){
				//COMP_PMED_REP_REC_DT.setRequired(true);
				
				disableAllComponent(true);
				COMP_PMED_STATUS.setDisabled(false);
				COMP_PMED_REP_REC_DT.setDisabled(false);
			}else{
				//COMP_PMED_REP_REC_DT.setRequired(false);

				disableAllComponent(false);
				COMP_PMED_STATUS.setDisabled(false);
				

			}
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_EXAM_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_MED_EXAM_DTL_1";
		String fieldName = "PMED_EXAM_CODE";
		Object param1 = "IL_MED_EXM";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_CLINIC_CODE(Object object) {
		/*ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_MED_EXAM_DTL_1";
		String fieldName = "PMED_CLINIC_CODE";
		Object param1 = "HOSPITALS";
		Object param2 = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE();
		Object param3 = "HOSPITALS";
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,
					param1, param2, param3, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;*/
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
    	ListItemUtil listitemutil = new ListItemUtil();
    	Object[] values = null;
		String currentValue = (String) object;
		
    	//String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
        String mainQry=
      
                " SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER " +
                " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, " +
                " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) " +
                " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' " +
                " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE " +
                " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) " +
                " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (CUST_CODE LIKE ?  OR CUST_NAME LIKE ? OR CUST_BL_NAME LIKE ? ) " +
                " AND ROWNUM < 20 ORDER BY 1 "; 

				System.out.println(mainQry);
		    try{
		    currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
    
    	    mainQry=prepareCustomerQuery(mainQry,new Object[]{"HOSPITALS"});
    	    	  values =new Object[]{"HOSPITALS",compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
    	    			  currentValue,currentValue,currentValue};
    	    	  suggestionList = ListItemUtil.prepareSuggestionList(mainQry, values);
		    } catch (Exception e) {
    	    e.printStackTrace();
    	}
    	return suggestionList;
	}
	 public String prepareCustomerQuery(String CustCodeQuery,Object[] values) {
			ResultSet resultSet=null;
			CRUDHandler handler=new CRUDHandler();
			String query_input="";
			String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
			try {
				Connection connection = CommonUtils.getConnection();
				resultSet=handler.executeSelectStatement(subQry, connection,values);
				if(resultSet.next()) {
					query_input = resultSet.getString("PS_CODE_DESC"); 
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
			CustCodeQuery=CustCodeQuery.replaceFirst("#",query_input);
			return CustCodeQuery;
		}
		

		/**
		 * Disables all components in PT_IL_POL_MED_EXAM_DTL_1_ACTION
		 */
		public void disableAllComponent(boolean disabled){
			// Disabling HtmlInputText
			COMP_PMED_EXAM_CODE.setDisabled(disabled);
			COMP_PMED_CLINIC_CODE.setDisabled(disabled);
			//COMP_UI_M_CLINIC_CODE_DESC.setDisabled(disabled);
			COMP_PMED_PVT_LC_AMT.setDisabled(disabled);
			COMP_PMED_GOVT_LC_AMT.setDisabled(disabled);
			COMP_UI_M_SUM_PVT_LC_AMT.setDisabled(disabled);
			COMP_UI_M_SUM_GOVT_LC_AMT.setDisabled(disabled);
			//COMP_UI_M_MED_EXAM_CODE_DESC.setDisabled(disabled);

			// Disabling HtmlSelectOneMenu
			COMP_PMED_STATUS.setDisabled(disabled);

			// Disabling HtmlCalendar
			COMP_PMED_REP_REC_DT.setDisabled(disabled);

		}


		/**
		 * Instantiates all components in PT_IL_POL_MED_EXAM_DTL_1_ACTION
		 */
		public void instantiateAllComponent(){
			// Instantiating HtmlInputText
			COMP_PMED_EXAM_CODE				 = new HtmlInputText();
			COMP_PMED_CLINIC_CODE				 = new HtmlInputText();
			COMP_UI_M_CLINIC_CODE_DESC			 = new HtmlInputText();
			COMP_PMED_PVT_LC_AMT				 = new HtmlInputText();
			COMP_PMED_GOVT_LC_AMT				 = new HtmlInputText();
			COMP_UI_M_SUM_PVT_LC_AMT			 = new HtmlInputText();
			COMP_UI_M_SUM_GOVT_LC_AMT			 = new HtmlInputText();
			COMP_UI_M_MED_EXAM_CODE_DESC			 = new HtmlInputText();

			// Instantiating HtmlOutputLabel
			COMP_PMED_EXAM_CODE_LABEL			 = new HtmlOutputLabel();
			COMP_PMED_CLINIC_CODE_LABEL			 = new HtmlOutputLabel();
			COMP_UI_M_CLINIC_CODE_DESC_LABEL		 = new HtmlOutputLabel();
			COMP_PMED_DEL_FLAG_LABEL			 = new HtmlOutputLabel();
			COMP_PMED_PVT_LC_AMT_LABEL			 = new HtmlOutputLabel();
			COMP_PMED_GOVT_LC_AMT_LABEL			 = new HtmlOutputLabel();
			COMP_PMED_STATUS_LABEL				 = new HtmlOutputLabel();
			COMP_PMED_REP_REC_DT_LABEL			 = new HtmlOutputLabel();
			COMP_UI_M_SUM_PVT_LC_AMT_LABEL			 = new HtmlOutputLabel();
			COMP_UI_M_SUM_GOVT_LC_AMT_LABEL			 = new HtmlOutputLabel();
			COMP_UI_M_MED_EXAM_CODE_DESC_LABEL		 = new HtmlOutputLabel();

			// Instantiating HtmlSelectOneMenu
			COMP_PMED_STATUS				 = new HtmlSelectOneMenu();

			// Instantiating HtmlCalendar
			COMP_PMED_REP_REC_DT				 = new HtmlCalendar();
			
			COMP_PMED_DEL_FLAG    = new HtmlSelectBooleanCheckbox();
			

		}

		
		/*Added by Dhinesh on 02.05.2018 for Fidelity as suggested by Vinoth*/

		
		public void fireFieldValidationChk(ActionEvent actionEvent) {
			try {

				if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG() != null && 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getUI_POL_FRZ_FLAG().equals("N"))
				{

					UIInput input = (UIInput) actionEvent.getComponent().getParent();
					System.out.println("Welcome to PACOND_DFLT_YN_ALL_Validator");
					boolean chkFlag = false;
					chkFlag = (boolean)input.getSubmittedValue();
					String defChk = "N";
					if(chkFlag)
					{
						defChk = "Y";
					}
					
					System.out.println("defChk        "+defChk+"       "+PT_IL_POL_MED_EXAM_DTL_1_BEAN.getCOMP_DT_SCROLLER().getPage()+"      "+dataTable.getRows());
					
					CommonUtils.setPageIndexing(PT_IL_POL_MED_EXAM_DTL_1_BEAN,PT_IL_POL_MED_EXAM_DTL_1_BEAN.getCOMP_DT_SCROLLER(),dataTable);
					
					System.out.println("page Start from "+PT_IL_POL_MED_EXAM_DTL_1_BEAN.getStartIndex()+"    Ended to    "+PT_IL_POL_MED_EXAM_DTL_1_BEAN.getEndindex());
					
					setDataList_PT_IL_POL_MED_EXAM_DTL_1(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL_1(), "PMED_STATUS", defChk,
							PT_IL_POL_MED_EXAM_DTL_1_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL_1().size()));
					if(chkFlag)
					{
						setDataList_PT_IL_POL_MED_EXAM_DTL_1(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL_1(), "PMED_REP_REC_DT", new CommonUtils().getCurrentDate(),
								PT_IL_POL_MED_EXAM_DTL_1_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL_1().size()));

						getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setPMED_REP_REC_DT(new CommonUtils().getCurrentDate());
						COMP_PMED_REP_REC_DT.resetValue();
					}
					else
					{

						setDataList_PT_IL_POL_MED_EXAM_DTL_1(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL_1(), "PMED_REP_REC_DT", null,
								PT_IL_POL_MED_EXAM_DTL_1_BEAN.getStartIndex(),getDataList_PT_IL_POL_MED_EXAM_DTL_1().size()));

						getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setPMED_REP_REC_DT(null);
						COMP_PMED_REP_REC_DT.resetValue();
					}
					getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setPMED_STATUS(defChk);
					COMP_PMED_STATUS.resetValue();
					getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setUPDATE_ALL(true);
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}  
		}

		public void setPMED_STATUS_Editable(ActionEvent event) {
			try
			{
			CommonUtils.clearMaps(this);
			String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			int currentIndex=this.dataTable.getRowIndex();
			PT_IL_POL_MED_EXAM_DTL_1_BEAN=(PT_IL_POL_MED_EXAM_DTL_1)dataList_PT_IL_POL_MED_EXAM_DTL_1.get(currentIndex);
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_STATUS(status);
			
			/*helper.PMED_STATUS_WHEN_VALIDATE_ITEM(this);*/
			
			helper.PMED_STATUS_WHEN_VALIDATE_ITEM(compositeAction
					.getPT_IL_POL_MED_EXAM_DTL_1_ACTION_BEAN(),compositeAction);
			
			if(status != null && status.equals("Y"))
			{
				COMP_PMED_CLINIC_CODE.setDisabled(true);
				COMP_UI_M_CLINIC_CODE_DESC.setDisabled(true);
			}
			else
			{
				COMP_PMED_CLINIC_CODE.setDisabled(false);
				
				/*Commented by DHinesh on 16.05.2018 for clinic code desc getting enabled when chosen status as No in grid*/
				//COMP_UI_M_CLINIC_CODE_DESC.setDisabled(false);
				/*End*/
			}
			
			COMP_PMED_CLINIC_CODE.resetValue();
			//COMP_UI_M_CLINIC_CODE_DESC.resetValue();
			COMP_PMED_REP_REC_DT.resetValue();
			COMP_PMED_STATUS.resetValue();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("postRecord", e.getMessage());	
			}
		}
		
/*End*/
		/*Added by Janani on 07.05.2018 for Fidelity as suggested by Sivaram*/
		
		private List<SelectItem> listCLINIC_CODE = new ArrayList<SelectItem>();
		
		public List<SelectItem> getListCLINIC_CODE() {
			return listCLINIC_CODE;
		}
		public void setListCLINIC_CODE(List<SelectItem> listCLINIC_CODE) {
			this.listCLINIC_CODE = listCLINIC_CODE;
		}
		
		public void setPMED_CLINIC_CODE_Editable(ActionEvent event) {
			String str = null;
			try
			{
			CommonUtils.clearMaps(this);
			String clinicCode=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			int currentIndex=this.dataTable.getRowIndex();
			
	 

			PT_IL_POL_MED_EXAM_DTL_1_BEAN=(PT_IL_POL_MED_EXAM_DTL_1)dataList_PT_IL_POL_MED_EXAM_DTL_1.get(currentIndex);
			if(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getPMED_STATUS() != null && PT_IL_POL_MED_EXAM_DTL_1_BEAN.getPMED_STATUS().equals("N"))
			{
				
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setPMED_CLINIC_CODE(clinicCode);
			
	Iterator<SelectItem> listCLINIC_CODE_itr = listCLINIC_CODE.iterator();
	while(listCLINIC_CODE_itr.hasNext())
	{
		SelectItem item = (SelectItem)listCLINIC_CODE_itr.next();
		if(item.getValue() != null && item.getValue().equals(clinicCode))
		{
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setUI_M_CLINIC_CODE_DESC((String)item.getLabel());
		}
	}
	System.out.println(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getUI_M_CLINIC_CODE_DESC());
	COMP_PMED_CLINIC_CODE.resetValue();
	//COMP_UI_M_CLINIC_CODE_DESC.resetValue();

			}


			}
	catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				e.getMessage());
		getErrorMap().put("postRecord", e.getMessage());	
	}
			
	}
		
		
		private void enableFields()
		{
			if(PT_IL_POL_MED_EXAM_DTL_1_BEAN.getRowSelected() != null && PT_IL_POL_MED_EXAM_DTL_1_BEAN.getRowSelected().equals("dataTableSelectedRow"))
			{
				System.out.println("PT_IL_POL_ADDL_COVER_BEAN.getRowSelected()      "+PT_IL_POL_MED_EXAM_DTL_1_BEAN.getRowSelected()+" "+
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()+"     "+
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS()+"     "+
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_CODE());
				if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG() != null && 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equals("Y")))
				{
					PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
					PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
				}
				else
				{
					PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");
					PT_IL_POL_MED_EXAM_DTL_1_BEAN.setFIELD2_ENABLE("dataTableSelectedRow");
				}
			}
		}	
		
		
		  private void resetRowAtCreate() {
		    	Iterator<PT_IL_POL_MED_EXAM_DTL_1> PT_IL_POL_MED_EXAM_DTL_ITR = dataList_PT_IL_POL_MED_EXAM_DTL_1
						.iterator();
				while (PT_IL_POL_MED_EXAM_DTL_ITR.hasNext()) {
					PT_IL_POL_MED_EXAM_DTL_ITR.next().setRowSelected(false);;
					
				}
			}
		  
		  
		  public void prepareCLINIC_CODElov() {

				ArrayList<SelectItem> suggestionList = new ArrayList<SelectItem>();
				
				Object[] values = null;
				String currentValue = "*";
				SelectItem selectItem =null;
				 
				String mainQry =

						
						/*Row count has been removed for displaying default clinic code while loading by Janani on 29.05.2018 for Fidelity*/

						/*" SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
								+ " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
								+ " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) "
								+ " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' "
								+ " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE "
								+ " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) "
								+ " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (UPPER(CUST_CODE) LIKE UPPER(?)  OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?) ) "
								+ " AND ROWNUM < 20 ORDER BY 1 ";*/

						" SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
						+ " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
						+ " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) "
						+ " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' "
						+ " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE "
						+ " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) "
						+ " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (UPPER(CUST_CODE) LIKE UPPER(?)  OR UPPER(CUST_NAME) LIKE UPPER(?) OR UPPER(CUST_BL_NAME) LIKE UPPER(?) ) "
						+ " ORDER BY 1 ";

				/*End of fidleity changes*/
				
				
				
				/*end*/
				System.out.println(mainQry);
				try {
					
					currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

					mainQry = prepareCustomerQuery(mainQry,
							new Object[] { "HOSPITALS" });
					values = new Object[] {
							"HOSPITALS",
							compositeAction.getPT_IL_POLICY_ACTION_BEAN()
									.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),
							currentValue, currentValue, currentValue };
					ResultSet rs = new CRUDHandler().executeSelectStatement(mainQry, CommonUtils.getConnection(),values);
					while(rs.next())
					{
						System.out.println(rs.getString("CUST_NAME")+"        "+rs.getString("CUST_CODE"));
						selectItem = new SelectItem();
						selectItem.setLabel(rs.getString("CUST_NAME"));
						selectItem.setValue(rs.getString("CUST_CODE"));
						suggestionList.add(selectItem);
					}
					setListCLINIC_CODE(suggestionList);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 
			}
	/*End*/	
		  
		  
		
		
}
