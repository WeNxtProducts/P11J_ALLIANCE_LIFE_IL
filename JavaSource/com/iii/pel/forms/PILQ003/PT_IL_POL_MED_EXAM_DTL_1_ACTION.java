package com.iii.pel.forms.PILQ003;

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

	public PILQ003_COMPOSITE_ACTION compositeAction;

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
   	 listPMED_STATUS = ListItemUtil.getDropDownListValue(
   			    connection, "PILT002_APAC", "PT_IL_POL_MED_EXAM_DTL_1",
   			    "PT_IL_POL_MED_EXAM_DTL_1.PMED_STATUS", "YESNO");
   	 
   			    
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
				resetAllComponent();
				resetSelectedRow();
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed");
				getErrorMap().put("addRow", message);

				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

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
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event) {
		String message = null;
		try {
			if (PT_IL_POL_MED_EXAM_DTL_1_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(getPT_IL_POL_MED_EXAM_DTL_1_BEAN(),
						compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());

				new CRUDHandler().executeInsert(PT_IL_POL_MED_EXAM_DTL_1_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				getWarningMap().put("postRecord", message);

				dataList_PT_IL_POL_MED_EXAM_DTL_1
						.add(PT_IL_POL_MED_EXAM_DTL_1_BEAN);
			} else if (PT_IL_POL_MED_EXAM_DTL_1_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(getPT_IL_POL_MED_EXAM_DTL_1_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_MED_EXAM_DTL_1_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);

				getWarningMap().put("postRecord", message);

			}

			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setRowSelected(true);
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
			PT_IL_POL_MED_EXAM_DTL_1_BEAN = (PT_IL_POL_MED_EXAM_DTL_1) dataTable
					.getRowData();
			helper.postQuery(this, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN());
			helper.whenNewRecordInstance(this);
			PT_IL_POL_MED_EXAM_DTL_1_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_MED_EXAM_DTL_1> PT_IL_POL_MED_EXAM_DTL_1_ITR = dataList_PT_IL_POL_MED_EXAM_DTL_1
				.iterator();
		while (PT_IL_POL_MED_EXAM_DTL_1_ITR.hasNext()) {
			PT_IL_POL_MED_EXAM_DTL_1_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PMED_EXAM_CODE.resetValue();
		COMP_PMED_EXAM_CODE.resetValue();
		COMP_PMED_CLINIC_CODE.resetValue();
		COMP_PMED_CLINIC_CODE.resetValue();
		COMP_UI_M_CLINIC_CODE_DESC.resetValue();
		COMP_UI_M_CLINIC_CODE_DESC.resetValue();
		COMP_PMED_PVT_LC_AMT.resetValue();
		COMP_PMED_PVT_LC_AMT.resetValue();
		COMP_PMED_GOVT_LC_AMT.resetValue();
		COMP_PMED_GOVT_LC_AMT.resetValue();
		COMP_PMED_STATUS.resetValue();
		COMP_PMED_STATUS.resetValue();
		COMP_PMED_REP_REC_DT.resetValue();
		COMP_PMED_REP_REC_DT.resetValue();
		COMP_UI_M_SUM_PVT_LC_AMT.resetValue();
		COMP_UI_M_SUM_PVT_LC_AMT.resetValue();
		COMP_UI_M_SUM_GOVT_LC_AMT.resetValue();
		COMP_UI_M_SUM_GOVT_LC_AMT.resetValue();
		COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
		COMP_UI_M_MED_EXAM_CODE_DESC.resetValue();
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

	public PILQ003_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
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
				setBlockFlag(false);
			}
		} catch (Exception e) {
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
			getPT_IL_POL_MED_EXAM_DTL_1_BEAN()
					.setPMED_EXAM_CODE((String) value);
			helper.PMED_EXAM_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_MED_EXAM_DTL_1_BEAN());
			getCOMP_UI_M_MED_EXAM_CODE_DESC().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setPMED_CLINIC_CODE(
					(String) value);
			helper.PMED_CLINIC_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_MED_EXAM_DTL_1_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			getCOMP_UI_M_CLINIC_CODE_DESC().resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PMED_STATUS_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {

		try {
			getPT_IL_POL_MED_EXAM_DTL_1_BEAN().setPMED_STATUS((String) value);
			helper.PMED_STATUS_WHEN_VALIDATE_ITEM(this);

		} catch (Exception e) {
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
			COMP_UI_M_CLINIC_CODE_DESC.setDisabled(disabled);
			COMP_PMED_PVT_LC_AMT.setDisabled(disabled);
			COMP_PMED_GOVT_LC_AMT.setDisabled(disabled);
			COMP_UI_M_SUM_PVT_LC_AMT.setDisabled(disabled);
			COMP_UI_M_SUM_GOVT_LC_AMT.setDisabled(disabled);
			COMP_UI_M_MED_EXAM_CODE_DESC.setDisabled(disabled);

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

		}



}
