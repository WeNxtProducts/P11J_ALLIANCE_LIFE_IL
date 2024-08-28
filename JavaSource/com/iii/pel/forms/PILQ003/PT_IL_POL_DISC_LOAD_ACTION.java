package com.iii.pel.forms.PILQ003;

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

public class PT_IL_POL_DISC_LOAD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PDL_SRNO_LABEL;

	private HtmlInputText COMP_PDL_SRNO;

	private HtmlOutputLabel COMP_PDL_DISC_LOAD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_PDL_DISC_LOAD_TYPE;

	private HtmlOutputLabel COMP_PDL_DISC_LOAD_CODE_LABEL;

	private HtmlInputText COMP_PDL_DISC_LOAD_CODE;

	private HtmlOutputLabel COMP_PDL_APPL_PERC_LABEL;

	private HtmlInputText COMP_PDL_APPL_PERC;

	private HtmlOutputLabel COMP_PDL_APPLIED_ON_LABEL;

	private HtmlSelectOneMenu COMP_PDL_APPLIED_ON;

	private HtmlOutputLabel COMP_PDL_COVER_CODE_LABEL;

	private HtmlInputText COMP_PDL_COVER_CODE;

	private HtmlOutputLabel COMP_PDL_APPLY_UPTO_SRNO_LABEL;

	private HtmlInputText COMP_PDL_APPLY_UPTO_SRNO;

	private HtmlOutputLabel COMP_PDL_RATE_LABEL;

	private HtmlInputText COMP_PDL_RATE;

	private HtmlOutputLabel COMP_PDL_RATE_PER_LABEL;

	private HtmlInputText COMP_PDL_RATE_PER;

	private HtmlOutputLabel COMP_PDL_FC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_PDL_FC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_UI_M_DISCLOAD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DISCLOAD_DESC;

	private HtmlOutputLabel COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;

	private HtmlInputText COMP_PDL_LC_DISC_LOAD_VALUE;

	private HtmlOutputLabel COMP_UI_M_DLCVR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DLCVR_DESC;

	private PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_DISC_LOAD_HELPER helper;

	private List<PT_IL_POL_DISC_LOAD> dataList_PT_IL_POL_DISC_LOAD = new ArrayList<PT_IL_POL_DISC_LOAD>();

	private UIData dataTable;

	private List<SelectItem> listPDL_DISC_LOAD_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listPDL_APPLIED_ON = new ArrayList<SelectItem>();

	public PT_IL_POL_DISC_LOAD_ACTION() {

		PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
		helper = new PT_IL_POL_DISC_LOAD_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
	}

	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listPDL_DISC_LOAD_TYPE = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_DISC_LOAD", "PT_IL_POL_DISC_LOAD.PDL_DISC_LOAD_TYPE", "IL_DISCLOAD");

			listPDL_APPLIED_ON = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_DISC_LOAD", "PT_IL_POL_DISC_LOAD.PDL_APPLIED_ON", "IL_APPLIEDON");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_DLCVR_DESC_LABEL() {
		return COMP_UI_M_DLCVR_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DLCVR_DESC() {
		return COMP_UI_M_DLCVR_DESC;
	}

	public void setCOMP_UI_M_DLCVR_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_DLCVR_DESC_LABEL) {
		this.COMP_UI_M_DLCVR_DESC_LABEL = COMP_UI_M_DLCVR_DESC_LABEL;
	}

	public void setCOMP_UI_M_DLCVR_DESC(HtmlInputText COMP_UI_M_DLCVR_DESC) {
		this.COMP_UI_M_DLCVR_DESC = COMP_UI_M_DLCVR_DESC;
	}

	public PT_IL_POL_DISC_LOAD getPT_IL_POL_DISC_LOAD_BEAN() {
		return PT_IL_POL_DISC_LOAD_BEAN;
	}

	public void setPT_IL_POL_DISC_LOAD_BEAN(
			PT_IL_POL_DISC_LOAD PT_IL_POL_DISC_LOAD_BEAN) {
		this.PT_IL_POL_DISC_LOAD_BEAN = PT_IL_POL_DISC_LOAD_BEAN;
	}

	public List<PT_IL_POL_DISC_LOAD> getDataList_PT_IL_POL_DISC_LOAD() {
		return dataList_PT_IL_POL_DISC_LOAD;
	}

	public void setDataListPT_IL_POL_DISC_LOAD(
			List<PT_IL_POL_DISC_LOAD> dataList_PT_IL_POL_DISC_LOAD) {
		this.dataList_PT_IL_POL_DISC_LOAD = dataList_PT_IL_POL_DISC_LOAD;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_DISC_LOAD_BEAN = new PT_IL_POL_DISC_LOAD();
				helper.whenCreateRecord(getPT_IL_POL_DISC_LOAD_BEAN(), 
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
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
				helper.keyDelRec(this, compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(), 
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN(), 
					compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeDelete(PT_IL_POL_DISC_LOAD_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
				"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				dataList_PT_IL_POL_DISC_LOAD.remove(PT_IL_POL_DISC_LOAD_BEAN);
				if (dataList_PT_IL_POL_DISC_LOAD.size() > 0) {

					PT_IL_POL_DISC_LOAD_BEAN = dataList_PT_IL_POL_DISC_LOAD
					.get(0);
				} else if (dataList_PT_IL_POL_DISC_LOAD.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
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
			if (PT_IL_POL_DISC_LOAD_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_DISC_LOAD_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$insert");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord", message);
				dataList_PT_IL_POL_DISC_LOAD.add(PT_IL_POL_DISC_LOAD_BEAN);
			} else if (PT_IL_POL_DISC_LOAD_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
						.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_DISC_LOAD_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,message);
				getWarningMap().put("postRecord", message);
			}
			PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);
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
			PT_IL_POL_DISC_LOAD_BEAN = (PT_IL_POL_DISC_LOAD) dataTable.getRowData();
			helper.postQuery(this);
			helper.whenNewBlockInstance(compositeAction);
			PT_IL_POL_DISC_LOAD_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_DISC_LOAD> PT_IL_POL_DISC_LOAD_ITR = dataList_PT_IL_POL_DISC_LOAD
		.iterator();
		while (PT_IL_POL_DISC_LOAD_ITR.hasNext()) {
			PT_IL_POL_DISC_LOAD_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PDL_SRNO.resetValue();
		COMP_PDL_SRNO.resetValue();
		COMP_PDL_DISC_LOAD_TYPE.resetValue();
		COMP_PDL_DISC_LOAD_TYPE.resetValue();
		COMP_PDL_DISC_LOAD_CODE.resetValue();
		COMP_PDL_DISC_LOAD_CODE.resetValue();
		COMP_PDL_APPL_PERC.resetValue();
		COMP_PDL_APPL_PERC.resetValue();
		COMP_PDL_APPLIED_ON.resetValue();
		COMP_PDL_APPLIED_ON.resetValue();
		COMP_PDL_COVER_CODE.resetValue();
		COMP_PDL_COVER_CODE.resetValue();
		COMP_PDL_APPLY_UPTO_SRNO.resetValue();
		COMP_PDL_APPLY_UPTO_SRNO.resetValue();
		COMP_PDL_RATE.resetValue();
		COMP_PDL_RATE.resetValue();
		COMP_PDL_RATE_PER.resetValue();
		COMP_PDL_RATE_PER.resetValue();
		COMP_PDL_FC_DISC_LOAD_VALUE.resetValue();
		COMP_PDL_FC_DISC_LOAD_VALUE.resetValue();
		COMP_UI_M_DISCLOAD_DESC.resetValue();
		COMP_UI_M_DISCLOAD_DESC.resetValue();
		COMP_PDL_LC_DISC_LOAD_VALUE.resetValue();
		COMP_PDL_LC_DISC_LOAD_VALUE.resetValue();
		COMP_UI_M_DLCVR_DESC.resetValue();
		COMP_UI_M_DLCVR_DESC.resetValue();
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

	public HtmlOutputLabel getCOMP_PDL_SRNO_LABEL() {
		return COMP_PDL_SRNO_LABEL;
	}

	public void setCOMP_PDL_SRNO_LABEL(HtmlOutputLabel comp_pdl_srno_label) {
		COMP_PDL_SRNO_LABEL = comp_pdl_srno_label;
	}

	public HtmlInputText getCOMP_PDL_SRNO() {
		return COMP_PDL_SRNO;
	}

	public void setCOMP_PDL_SRNO(HtmlInputText comp_pdl_srno) {
		COMP_PDL_SRNO = comp_pdl_srno;
	}

	public HtmlOutputLabel getCOMP_PDL_DISC_LOAD_TYPE_LABEL() {
		return COMP_PDL_DISC_LOAD_TYPE_LABEL;
	}

	public void setCOMP_PDL_DISC_LOAD_TYPE_LABEL(
			HtmlOutputLabel comp_pdl_disc_load_type_label) {
		COMP_PDL_DISC_LOAD_TYPE_LABEL = comp_pdl_disc_load_type_label;
	}

	public HtmlSelectOneMenu getCOMP_PDL_DISC_LOAD_TYPE() {
		return COMP_PDL_DISC_LOAD_TYPE;
	}

	public void setCOMP_PDL_DISC_LOAD_TYPE(
			HtmlSelectOneMenu comp_pdl_disc_load_type) {
		COMP_PDL_DISC_LOAD_TYPE = comp_pdl_disc_load_type;
	}

	public HtmlOutputLabel getCOMP_PDL_DISC_LOAD_CODE_LABEL() {
		return COMP_PDL_DISC_LOAD_CODE_LABEL;
	}

	public void setCOMP_PDL_DISC_LOAD_CODE_LABEL(
			HtmlOutputLabel comp_pdl_disc_load_code_label) {
		COMP_PDL_DISC_LOAD_CODE_LABEL = comp_pdl_disc_load_code_label;
	}

	public HtmlInputText getCOMP_PDL_DISC_LOAD_CODE() {
		return COMP_PDL_DISC_LOAD_CODE;
	}

	public void setCOMP_PDL_DISC_LOAD_CODE(HtmlInputText comp_pdl_disc_load_code) {
		COMP_PDL_DISC_LOAD_CODE = comp_pdl_disc_load_code;
	}

	public HtmlOutputLabel getCOMP_PDL_APPL_PERC_LABEL() {
		return COMP_PDL_APPL_PERC_LABEL;
	}

	public void setCOMP_PDL_APPL_PERC_LABEL(
			HtmlOutputLabel comp_pdl_appl_perc_label) {
		COMP_PDL_APPL_PERC_LABEL = comp_pdl_appl_perc_label;
	}

	public HtmlInputText getCOMP_PDL_APPL_PERC() {
		return COMP_PDL_APPL_PERC;
	}

	public void setCOMP_PDL_APPL_PERC(HtmlInputText comp_pdl_appl_perc) {
		COMP_PDL_APPL_PERC = comp_pdl_appl_perc;
	}

	public HtmlOutputLabel getCOMP_PDL_APPLIED_ON_LABEL() {
		return COMP_PDL_APPLIED_ON_LABEL;
	}

	public void setCOMP_PDL_APPLIED_ON_LABEL(
			HtmlOutputLabel comp_pdl_applied_on_label) {
		COMP_PDL_APPLIED_ON_LABEL = comp_pdl_applied_on_label;
	}

	public HtmlSelectOneMenu getCOMP_PDL_APPLIED_ON() {
		return COMP_PDL_APPLIED_ON;
	}

	public void setCOMP_PDL_APPLIED_ON(HtmlSelectOneMenu comp_pdl_applied_on) {
		COMP_PDL_APPLIED_ON = comp_pdl_applied_on;
	}

	public HtmlOutputLabel getCOMP_PDL_COVER_CODE_LABEL() {
		return COMP_PDL_COVER_CODE_LABEL;
	}

	public void setCOMP_PDL_COVER_CODE_LABEL(
			HtmlOutputLabel comp_pdl_cover_code_label) {
		COMP_PDL_COVER_CODE_LABEL = comp_pdl_cover_code_label;
	}

	public HtmlInputText getCOMP_PDL_COVER_CODE() {
		return COMP_PDL_COVER_CODE;
	}

	public void setCOMP_PDL_COVER_CODE(HtmlInputText comp_pdl_cover_code) {
		COMP_PDL_COVER_CODE = comp_pdl_cover_code;
	}

	public HtmlOutputLabel getCOMP_PDL_APPLY_UPTO_SRNO_LABEL() {
		return COMP_PDL_APPLY_UPTO_SRNO_LABEL;
	}

	public void setCOMP_PDL_APPLY_UPTO_SRNO_LABEL(
			HtmlOutputLabel comp_pdl_apply_upto_srno_label) {
		COMP_PDL_APPLY_UPTO_SRNO_LABEL = comp_pdl_apply_upto_srno_label;
	}

	public HtmlInputText getCOMP_PDL_APPLY_UPTO_SRNO() {
		return COMP_PDL_APPLY_UPTO_SRNO;
	}

	public void setCOMP_PDL_APPLY_UPTO_SRNO(
			HtmlInputText comp_pdl_apply_upto_srno) {
		COMP_PDL_APPLY_UPTO_SRNO = comp_pdl_apply_upto_srno;
	}

	public HtmlOutputLabel getCOMP_PDL_RATE_LABEL() {
		return COMP_PDL_RATE_LABEL;
	}

	public void setCOMP_PDL_RATE_LABEL(HtmlOutputLabel comp_pdl_rate_label) {
		COMP_PDL_RATE_LABEL = comp_pdl_rate_label;
	}

	public HtmlInputText getCOMP_PDL_RATE() {
		return COMP_PDL_RATE;
	}

	public void setCOMP_PDL_RATE(HtmlInputText comp_pdl_rate) {
		COMP_PDL_RATE = comp_pdl_rate;
	}

	public HtmlOutputLabel getCOMP_PDL_RATE_PER_LABEL() {
		return COMP_PDL_RATE_PER_LABEL;
	}

	public void setCOMP_PDL_RATE_PER_LABEL(
			HtmlOutputLabel comp_pdl_rate_per_label) {
		COMP_PDL_RATE_PER_LABEL = comp_pdl_rate_per_label;
	}

	public HtmlInputText getCOMP_PDL_RATE_PER() {
		return COMP_PDL_RATE_PER;
	}

	public void setCOMP_PDL_RATE_PER(HtmlInputText comp_pdl_rate_per) {
		COMP_PDL_RATE_PER = comp_pdl_rate_per;
	}

	public HtmlOutputLabel getCOMP_PDL_FC_DISC_LOAD_VALUE_LABEL() {
		return COMP_PDL_FC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_PDL_FC_DISC_LOAD_VALUE_LABEL(
			HtmlOutputLabel comp_pdl_fc_disc_load_value_label) {
		COMP_PDL_FC_DISC_LOAD_VALUE_LABEL = comp_pdl_fc_disc_load_value_label;
	}

	public HtmlInputText getCOMP_PDL_FC_DISC_LOAD_VALUE() {
		return COMP_PDL_FC_DISC_LOAD_VALUE;
	}

	public void setCOMP_PDL_FC_DISC_LOAD_VALUE(
			HtmlInputText comp_pdl_fc_disc_load_value) {
		COMP_PDL_FC_DISC_LOAD_VALUE = comp_pdl_fc_disc_load_value;
	}

	public HtmlOutputLabel getCOMP_UI_M_DISCLOAD_DESC_LABEL() {
		return COMP_UI_M_DISCLOAD_DESC_LABEL;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_discload_desc_label) {
		COMP_UI_M_DISCLOAD_DESC_LABEL = comp_ui_m_discload_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_DISCLOAD_DESC() {
		return COMP_UI_M_DISCLOAD_DESC;
	}

	public void setCOMP_UI_M_DISCLOAD_DESC(HtmlInputText comp_ui_m_discload_desc) {
		COMP_UI_M_DISCLOAD_DESC = comp_ui_m_discload_desc;
	}

	public HtmlOutputLabel getCOMP_PDL_LC_DISC_LOAD_VALUE_LABEL() {
		return COMP_PDL_LC_DISC_LOAD_VALUE_LABEL;
	}

	public void setCOMP_PDL_LC_DISC_LOAD_VALUE_LABEL(
			HtmlOutputLabel comp_pdl_lc_disc_load_value_label) {
		COMP_PDL_LC_DISC_LOAD_VALUE_LABEL = comp_pdl_lc_disc_load_value_label;
	}

	public HtmlInputText getCOMP_PDL_LC_DISC_LOAD_VALUE() {
		return COMP_PDL_LC_DISC_LOAD_VALUE;
	}

	public void setCOMP_PDL_LC_DISC_LOAD_VALUE(
			HtmlInputText comp_pdl_lc_disc_load_value) {
		COMP_PDL_LC_DISC_LOAD_VALUE = comp_pdl_lc_disc_load_value;
	}

	public PILQ003_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_DISC_LOAD_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_DISC_LOAD_HELPER helper) {
		this.helper = helper;
	}

	public List<SelectItem> getListPDL_DISC_LOAD_TYPE() {
		return listPDL_DISC_LOAD_TYPE;
	}

	public void setListPDL_DISC_LOAD_TYPE(
			List<SelectItem> listPDL_DISC_LOAD_TYPE) {
		this.listPDL_DISC_LOAD_TYPE = listPDL_DISC_LOAD_TYPE;
	}

	public List<SelectItem> getListPDL_APPLIED_ON() {
		return listPDL_APPLIED_ON;
	}

	public void setListPDL_APPLIED_ON(List<SelectItem> listPDL_APPLIED_ON) {
		this.listPDL_APPLIED_ON = listPDL_APPLIED_ON;
	}

	public void setDataList_PT_IL_POL_DISC_LOAD(
			List<PT_IL_POL_DISC_LOAD> dataList_PT_IL_POL_DISC_LOAD) {
		this.dataList_PT_IL_POL_DISC_LOAD = dataList_PT_IL_POL_DISC_LOAD;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_DISC_LOAD_BEAN.getROWID() != null){
					helper.postQuery(this);
				}else{
					helper.whenCreateRecord(getPT_IL_POL_DISC_LOAD_BEAN(), 
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID());
				}
				helper.whenNewBlockInstance(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void PDL_SRNO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_SRNO((Integer) value);
			helper.PDL_SRNO_WHEN_VALIDATE_ITEM(getPT_IL_POL_DISC_LOAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_DISC_LOAD_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_DISC_LOAD_CODE((String) value);
			helper.PDL_DISC_LOAD_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN());
			COMP_UI_M_DISCLOAD_DESC.resetValue();
			COMP_PDL_APPL_PERC.resetValue();
			COMP_PDL_RATE.resetValue();
			COMP_PDL_RATE_PER.resetValue();
			COMP_PDL_APPLIED_ON.resetValue(); 
			COMP_PDL_APPLY_UPTO_SRNO.resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_APPL_PERC_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_APPL_PERC((Double) value);
			helper
			.PDL_APPL_PERC_WHEN_VALIDATE_ITEM(getPT_IL_POL_DISC_LOAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_APPLIED_ON_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_APPLIED_ON((String) value);
			helper.PDL_APPLIED_ON_WHEN_VALIDATE_ITEM(this, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_COVER_CODE((String) value);
			helper.PDL_COVER_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN()
					.getPT_IL_POL_ASSURED_DTLS_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_APPLY_UPTO_SRNO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN()
			.setPDL_APPLY_UPTO_SRNO((Integer) value);
			helper
			.PDL_APPLY_UPTO_SRNO_WHEN_VALIDATE_ITEM(getPT_IL_POL_DISC_LOAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_RATE((Double) value);
			helper.PDL_RATE_WHEN_VALIDATE_ITEM(getPT_IL_POL_DISC_LOAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_RATE_PER((Double) value);
			helper
			.PDL_RATE_PER_WHEN_VALIDATE_ITEM(getPT_IL_POL_DISC_LOAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_FC_DISC_LOAD_VALUE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_FC_DISC_LOAD_VALUE(
					(Double) value);
			helper.PDL_FC_DISC_LOAD_VALUE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PDL_LC_DISC_LOAD_VALUE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_DISC_LOAD_BEAN().setPDL_LC_DISC_LOAD_VALUE(
					(Double) value);
			helper.PDL_LC_DISC_LOAD_VALUE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_DISC_LOAD_BEAN(), compositeAction
					.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN(), compositeAction
					.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_PDL_DISC_LOAD_CODE0(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_DISC_LOAD";
		String fieldName = "PDL_DISC_LOAD_CODE";
		Object param1 = "IL_DISC";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_PDL_DISC_LOAD_CODE1(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_DISC_LOAD";
		String fieldName = "PDL_DISC_LOAD_CODE";
		Object param1 = "IL_LOAD";

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> main_prepareSuggestionList_PDL_DISC_LOAD_CODE(
			Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		try {
			if ("D".equals(getPT_IL_POL_DISC_LOAD_BEAN()
					.getPDL_DISC_LOAD_TYPE())) {
				lovList = prepareSuggestionList_PDL_DISC_LOAD_CODE0(object);
			} else {
				lovList = prepareSuggestionList_PDL_DISC_LOAD_CODE1(object);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_PDL_COVER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_DISC_LOAD";
		String fieldName = "PDL_COVER_CODE";
		Object param1 = compositeAction.getPT_IL_POLICY_ACTION_BEAN()
		.getPT_IL_POLICY_BEAN().getPOL_SYS_ID();
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}

	/**
	 * Disables all components in PT_IL_POL_DISC_LOAD_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PDL_SRNO.setDisabled(disabled);
		COMP_PDL_DISC_LOAD_CODE.setDisabled(disabled);
		COMP_PDL_APPL_PERC.setDisabled(disabled);
		COMP_PDL_COVER_CODE.setDisabled(disabled);
		COMP_PDL_APPLY_UPTO_SRNO.setDisabled(disabled);
		COMP_PDL_RATE.setDisabled(disabled);
		COMP_PDL_RATE_PER.setDisabled(disabled);
		COMP_PDL_FC_DISC_LOAD_VALUE.setDisabled(disabled);
		COMP_UI_M_DISCLOAD_DESC.setDisabled(disabled);
		COMP_PDL_LC_DISC_LOAD_VALUE.setDisabled(disabled);
		COMP_UI_M_DLCVR_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_PDL_DISC_LOAD_TYPE.setDisabled(disabled);
		COMP_PDL_APPLIED_ON.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_DISC_LOAD_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PDL_SRNO					 = new HtmlInputText();
		COMP_PDL_DISC_LOAD_CODE				 = new HtmlInputText();
		COMP_PDL_APPL_PERC				 = new HtmlInputText();
		COMP_PDL_COVER_CODE				 = new HtmlInputText();
		COMP_PDL_APPLY_UPTO_SRNO			 = new HtmlInputText();
		COMP_PDL_RATE					 = new HtmlInputText();
		COMP_PDL_RATE_PER				 = new HtmlInputText();
		COMP_PDL_FC_DISC_LOAD_VALUE			 = new HtmlInputText();
		COMP_UI_M_DISCLOAD_DESC				 = new HtmlInputText();
		COMP_PDL_LC_DISC_LOAD_VALUE			 = new HtmlInputText();
		COMP_UI_M_DLCVR_DESC				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PDL_SRNO_LABEL				 = new HtmlOutputLabel();
		COMP_PDL_DISC_LOAD_TYPE_LABEL			 = new HtmlOutputLabel();
		COMP_PDL_DISC_LOAD_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PDL_APPL_PERC_LABEL			 = new HtmlOutputLabel();
		COMP_PDL_APPLIED_ON_LABEL			 = new HtmlOutputLabel();
		COMP_PDL_COVER_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PDL_APPLY_UPTO_SRNO_LABEL			 = new HtmlOutputLabel();
		COMP_PDL_RATE_LABEL				 = new HtmlOutputLabel();
		COMP_PDL_RATE_PER_LABEL				 = new HtmlOutputLabel();
		COMP_PDL_FC_DISC_LOAD_VALUE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_DISCLOAD_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_PDL_LC_DISC_LOAD_VALUE_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_DLCVR_DESC_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_PDL_DISC_LOAD_TYPE				 = new HtmlSelectOneMenu();
		COMP_PDL_APPLIED_ON				 = new HtmlSelectOneMenu();

	}


}
