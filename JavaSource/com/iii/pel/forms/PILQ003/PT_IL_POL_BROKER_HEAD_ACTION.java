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
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_BROKER_HEAD_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POBH_SRNO_LABEL;

	private HtmlInputText COMP_POBH_SRNO;

	private HtmlOutputLabel COMP_POBH_BROKER_CODE_LABEL;

	private HtmlInputText COMP_POBH_BROKER_CODE;

	private HtmlOutputLabel COMP_POBH_COMM_CODE_LABEL;

	private HtmlInputText COMP_POBH_COMM_CODE;

	private HtmlOutputLabel COMP_POBH_COVER_CODE_LABEL;

	private HtmlInputText COMP_POBH_COVER_CODE;

	private HtmlOutputLabel COMP_POBH_APPLY_ON_SRNO_LABEL;

	private HtmlInputText COMP_POBH_APPLY_ON_SRNO;

	private HtmlOutputLabel COMP_POBH_BROKER_CURR_CODE_LABEL;

	private HtmlInputText COMP_POBH_BROKER_CURR_CODE;

	private HtmlOutputLabel COMP_POBH_ACTING_AGENT_YN_LABEL;

	private HtmlSelectOneMenu COMP_POBH_ACTING_AGENT_YN;

	private HtmlOutputLabel COMP_POBH_REMARKS_LABEL;

	private HtmlInputText COMP_POBH_REMARKS;

	private HtmlOutputLabel COMP_UI_M_POBH_BROKER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_BROKER_DESC;

	private HtmlOutputLabel COMP_UI_M_POBH_COVER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_COVER_DESC;

	private HtmlOutputLabel COMP_UI_M_POBH_CURR_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POBH_CURR_DESC;

	private HtmlOutputLabel COMP_UI_M_PS_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PS_DESC;

	
	private HtmlCommandButton COMP_UI_M_BUT_SHOW_AGENT;
	
	private PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BROKER_HEAD_HELPER helper;

	private List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD = new ArrayList<PT_IL_POL_BROKER_HEAD>();

	private UIData dataTable;

	private List<SelectItem> listPOBH_ACTING_AGENT_YN = new ArrayList<SelectItem>();

	public PT_IL_POL_BROKER_HEAD_ACTION() {
		PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();
		helper = new PT_IL_POL_BROKER_HEAD_HELPER();
		instantiateAllComponent();
		prepareDropDownList();
	}
	
	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listPOBH_ACTING_AGENT_YN = ListItemUtil.getDropDownListValue(connection, "PILT002_APAC", 
					"PT_IL_POL_BROKER_HEAD", "PT_IL_POL_BROKER_HEAD.POBH_ACTING_AGENT_YN", "YESNO");

		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_POBH_SRNO_LABEL() {
		return COMP_POBH_SRNO_LABEL;
	}

	public void setCOMP_POBH_SRNO_LABEL(HtmlOutputLabel comp_pobh_srno_label) {
		COMP_POBH_SRNO_LABEL = comp_pobh_srno_label;
	}

	public HtmlInputText getCOMP_POBH_SRNO() {
		return COMP_POBH_SRNO;
	}

	public void setCOMP_POBH_SRNO(HtmlInputText comp_pobh_srno) {
		COMP_POBH_SRNO = comp_pobh_srno;
	}

	public HtmlOutputLabel getCOMP_POBH_BROKER_CODE_LABEL() {
		return COMP_POBH_BROKER_CODE_LABEL;
	}

	public void setCOMP_POBH_BROKER_CODE_LABEL(
			HtmlOutputLabel comp_pobh_broker_code_label) {
		COMP_POBH_BROKER_CODE_LABEL = comp_pobh_broker_code_label;
	}

	public HtmlInputText getCOMP_POBH_BROKER_CODE() {
		return COMP_POBH_BROKER_CODE;
	}

	public void setCOMP_POBH_BROKER_CODE(HtmlInputText comp_pobh_broker_code) {
		COMP_POBH_BROKER_CODE = comp_pobh_broker_code;
	}

	public HtmlOutputLabel getCOMP_POBH_COMM_CODE_LABEL() {
		return COMP_POBH_COMM_CODE_LABEL;
	}

	public void setCOMP_POBH_COMM_CODE_LABEL(
			HtmlOutputLabel comp_pobh_comm_code_label) {
		COMP_POBH_COMM_CODE_LABEL = comp_pobh_comm_code_label;
	}

	public HtmlInputText getCOMP_POBH_COMM_CODE() {
		return COMP_POBH_COMM_CODE;
	}

	public void setCOMP_POBH_COMM_CODE(HtmlInputText comp_pobh_comm_code) {
		COMP_POBH_COMM_CODE = comp_pobh_comm_code;
	}

	public HtmlOutputLabel getCOMP_POBH_COVER_CODE_LABEL() {
		return COMP_POBH_COVER_CODE_LABEL;
	}

	public void setCOMP_POBH_COVER_CODE_LABEL(
			HtmlOutputLabel comp_pobh_cover_code_label) {
		COMP_POBH_COVER_CODE_LABEL = comp_pobh_cover_code_label;
	}

	public HtmlInputText getCOMP_POBH_COVER_CODE() {
		return COMP_POBH_COVER_CODE;
	}

	public void setCOMP_POBH_COVER_CODE(HtmlInputText comp_pobh_cover_code) {
		COMP_POBH_COVER_CODE = comp_pobh_cover_code;
	}

	public HtmlOutputLabel getCOMP_POBH_APPLY_ON_SRNO_LABEL() {
		return COMP_POBH_APPLY_ON_SRNO_LABEL;
	}

	public void setCOMP_POBH_APPLY_ON_SRNO_LABEL(
			HtmlOutputLabel comp_pobh_apply_on_srno_label) {
		COMP_POBH_APPLY_ON_SRNO_LABEL = comp_pobh_apply_on_srno_label;
	}

	public HtmlInputText getCOMP_POBH_APPLY_ON_SRNO() {
		return COMP_POBH_APPLY_ON_SRNO;
	}

	public void setCOMP_POBH_APPLY_ON_SRNO(HtmlInputText comp_pobh_apply_on_srno) {
		COMP_POBH_APPLY_ON_SRNO = comp_pobh_apply_on_srno;
	}

	public HtmlOutputLabel getCOMP_POBH_BROKER_CURR_CODE_LABEL() {
		return COMP_POBH_BROKER_CURR_CODE_LABEL;
	}

	public void setCOMP_POBH_BROKER_CURR_CODE_LABEL(
			HtmlOutputLabel comp_pobh_broker_curr_code_label) {
		COMP_POBH_BROKER_CURR_CODE_LABEL = comp_pobh_broker_curr_code_label;
	}

	public HtmlInputText getCOMP_POBH_BROKER_CURR_CODE() {
		return COMP_POBH_BROKER_CURR_CODE;
	}

	public void setCOMP_POBH_BROKER_CURR_CODE(
			HtmlInputText comp_pobh_broker_curr_code) {
		COMP_POBH_BROKER_CURR_CODE = comp_pobh_broker_curr_code;
	}

	public HtmlOutputLabel getCOMP_POBH_ACTING_AGENT_YN_LABEL() {
		return COMP_POBH_ACTING_AGENT_YN_LABEL;
	}

	public void setCOMP_POBH_ACTING_AGENT_YN_LABEL(
			HtmlOutputLabel comp_pobh_acting_agent_yn_label) {
		COMP_POBH_ACTING_AGENT_YN_LABEL = comp_pobh_acting_agent_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_POBH_ACTING_AGENT_YN() {
		return COMP_POBH_ACTING_AGENT_YN;
	}

	public void setCOMP_POBH_ACTING_AGENT_YN(
			HtmlSelectOneMenu comp_pobh_acting_agent_yn) {
		COMP_POBH_ACTING_AGENT_YN = comp_pobh_acting_agent_yn;
	}

	public HtmlOutputLabel getCOMP_POBH_REMARKS_LABEL() {
		return COMP_POBH_REMARKS_LABEL;
	}

	public void setCOMP_POBH_REMARKS_LABEL(
			HtmlOutputLabel comp_pobh_remarks_label) {
		COMP_POBH_REMARKS_LABEL = comp_pobh_remarks_label;
	}

	public HtmlInputText getCOMP_POBH_REMARKS() {
		return COMP_POBH_REMARKS;
	}

	public void setCOMP_POBH_REMARKS(HtmlInputText comp_pobh_remarks) {
		COMP_POBH_REMARKS = comp_pobh_remarks;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_BROKER_DESC_LABEL() {
		return COMP_UI_M_POBH_BROKER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_BROKER_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pobh_broker_desc_label) {
		COMP_UI_M_POBH_BROKER_DESC_LABEL = comp_ui_m_pobh_broker_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POBH_BROKER_DESC() {
		return COMP_UI_M_POBH_BROKER_DESC;
	}

	public void setCOMP_UI_M_POBH_BROKER_DESC(
			HtmlInputText comp_ui_m_pobh_broker_desc) {
		COMP_UI_M_POBH_BROKER_DESC = comp_ui_m_pobh_broker_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_COVER_DESC_LABEL() {
		return COMP_UI_M_POBH_COVER_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_COVER_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pobh_cover_desc_label) {
		COMP_UI_M_POBH_COVER_DESC_LABEL = comp_ui_m_pobh_cover_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POBH_COVER_DESC() {
		return COMP_UI_M_POBH_COVER_DESC;
	}

	public void setCOMP_UI_M_POBH_COVER_DESC(
			HtmlInputText comp_ui_m_pobh_cover_desc) {
		COMP_UI_M_POBH_COVER_DESC = comp_ui_m_pobh_cover_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_POBH_CURR_DESC_LABEL() {
		return COMP_UI_M_POBH_CURR_DESC_LABEL;
	}

	public void setCOMP_UI_M_POBH_CURR_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_pobh_curr_desc_label) {
		COMP_UI_M_POBH_CURR_DESC_LABEL = comp_ui_m_pobh_curr_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POBH_CURR_DESC() {
		return COMP_UI_M_POBH_CURR_DESC;
	}

	public void setCOMP_UI_M_POBH_CURR_DESC(
			HtmlInputText comp_ui_m_pobh_curr_desc) {
		COMP_UI_M_POBH_CURR_DESC = comp_ui_m_pobh_curr_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_PS_DESC_LABEL() {
		return COMP_UI_M_PS_DESC_LABEL;
	}

	public void setCOMP_UI_M_PS_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_ps_desc_label) {
		COMP_UI_M_PS_DESC_LABEL = comp_ui_m_ps_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_PS_DESC() {
		return COMP_UI_M_PS_DESC;
	}

	public void setCOMP_UI_M_PS_DESC(HtmlInputText comp_ui_m_ps_desc) {
		COMP_UI_M_PS_DESC = comp_ui_m_ps_desc;
	}

	public PILQ003_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_BROKER_HEAD_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_BROKER_HEAD_HELPER helper) {
		this.helper = helper;
	}

	public void setDataList_PT_IL_POL_BROKER_HEAD(
			List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD) {
		this.dataList_PT_IL_POL_BROKER_HEAD = dataList_PT_IL_POL_BROKER_HEAD;
	}

	public PT_IL_POL_BROKER_HEAD getPT_IL_POL_BROKER_HEAD_BEAN() {
		return PT_IL_POL_BROKER_HEAD_BEAN;
	}

	public void setPT_IL_POL_BROKER_HEAD_BEAN(
			PT_IL_POL_BROKER_HEAD PT_IL_POL_BROKER_HEAD_BEAN) {
		this.PT_IL_POL_BROKER_HEAD_BEAN = PT_IL_POL_BROKER_HEAD_BEAN;
	}

	public List<PT_IL_POL_BROKER_HEAD> getDataList_PT_IL_POL_BROKER_HEAD() {
		return dataList_PT_IL_POL_BROKER_HEAD;
	}

	public void setDataListPT_IL_POL_BROKER_HEAD(
			List<PT_IL_POL_BROKER_HEAD> dataList_PT_IL_POL_BROKER_HEAD) {
		this.dataList_PT_IL_POL_BROKER_HEAD = dataList_PT_IL_POL_BROKER_HEAD;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_BROKER_HEAD_BEAN = new PT_IL_POL_BROKER_HEAD();
				helper.whenCreateRecord(this, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow", Messages.getString(
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
				helper.preDelete(getPT_IL_POL_BROKER_HEAD_BEAN());
				helper.keyDelRec(getPT_IL_POL_BROKER_HEAD_BEAN(),
						dataList_PT_IL_POL_BROKER_HEAD);
				new CRUDHandler().executeDelete(PT_IL_POL_BROKER_HEAD_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete");
				getWarningMap().put("deleteRow", message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				dataList_PT_IL_POL_BROKER_HEAD
						.remove(PT_IL_POL_BROKER_HEAD_BEAN);
				if (dataList_PT_IL_POL_BROKER_HEAD.size() > 0) {

					PT_IL_POL_BROKER_HEAD_BEAN = dataList_PT_IL_POL_BROKER_HEAD
							.get(0);
				} else if (dataList_PT_IL_POL_BROKER_HEAD.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
			} else {
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed");
				getErrorMap().put("deleteRow", message);
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
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
			if (PT_IL_POL_BROKER_HEAD_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.preInsert(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						getPT_IL_POL_BROKER_HEAD_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), 
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_BROKER_HEAD_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("postRecord", message);
				dataList_PT_IL_POL_BROKER_HEAD.add(PT_IL_POL_BROKER_HEAD_BEAN);
			} else if (PT_IL_POL_BROKER_HEAD_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.preUpdate(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
						.getPT_IL_POLICY_BEAN(),
						 getPT_IL_POL_BROKER_HEAD_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN()
								.getDUMMY_BEAN(), compositeAction
								.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_POL_BROKER_HEAD_BEAN,
						CommonUtils.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("postRecord", message);
			}

			PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
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
			PT_IL_POL_BROKER_HEAD_BEAN = (PT_IL_POL_BROKER_HEAD) dataTable.getRowData();
			helper.postQuery(getPT_IL_POL_BROKER_HEAD_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			PT_IL_POL_BROKER_HEAD_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BROKER_HEAD> PT_IL_POL_BROKER_HEAD_ITR = dataList_PT_IL_POL_BROKER_HEAD
				.iterator();
		while (PT_IL_POL_BROKER_HEAD_ITR.hasNext()) {
			PT_IL_POL_BROKER_HEAD_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_POBH_SRNO.resetValue();
		COMP_POBH_SRNO.resetValue();
		COMP_POBH_BROKER_CODE.resetValue();
		COMP_POBH_BROKER_CODE.resetValue();
		COMP_POBH_COMM_CODE.resetValue();
		COMP_POBH_COMM_CODE.resetValue();
		COMP_POBH_COVER_CODE.resetValue();
		COMP_POBH_COVER_CODE.resetValue();
		COMP_POBH_APPLY_ON_SRNO.resetValue();
		COMP_POBH_APPLY_ON_SRNO.resetValue();
		COMP_POBH_BROKER_CURR_CODE.resetValue();
		COMP_POBH_ACTING_AGENT_YN.resetValue();
		COMP_POBH_ACTING_AGENT_YN.resetValue();
		COMP_POBH_REMARKS.resetValue();
		COMP_POBH_REMARKS.resetValue();
		COMP_POBH_BROKER_CURR_CODE.resetValue();
		COMP_UI_M_POBH_BROKER_DESC.resetValue();
		COMP_UI_M_POBH_BROKER_DESC.resetValue();
		COMP_UI_M_POBH_COVER_DESC.resetValue();
		COMP_UI_M_POBH_COVER_DESC.resetValue();
		COMP_UI_M_POBH_CURR_DESC.resetValue();
		COMP_UI_M_POBH_CURR_DESC.resetValue();
		COMP_UI_M_PS_DESC.resetValue();
		COMP_UI_M_PS_DESC.resetValue();
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

	public List<SelectItem> getListPOBH_ACTING_AGENT_YN() {
		if (listPOBH_ACTING_AGENT_YN.size() == 0) {
			listPOBH_ACTING_AGENT_YN.clear();
			try {
				listPOBH_ACTING_AGENT_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
				getErrorMap().put("ListPOBH_ACTING_AGENT_YN", e.getMessage());
			}
		}
		return listPOBH_ACTING_AGENT_YN;
	}

	public void setListPOBH_ACTING_AGENT_YN(
			List<SelectItem> listPOBH_ACTING_AGENT_YN) {
		this.listPOBH_ACTING_AGENT_YN = listPOBH_ACTING_AGENT_YN;
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
				if(PT_IL_POL_BROKER_HEAD_BEAN.getROWID() != null){
					helper.postQuery(getPT_IL_POL_BROKER_HEAD_BEAN(),
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				}else{
					helper.whenCreateRecord(this, compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SHOW_AGENT() {
		return COMP_UI_M_BUT_SHOW_AGENT;
	}

	public void setCOMP_UI_M_BUT_SHOW_AGENT(
			HtmlCommandButton comp_ui_m_but_show_agent) {
		COMP_UI_M_BUT_SHOW_AGENT = comp_ui_m_but_show_agent;
	}

	public void POBH_BROKER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_BROKER_CODE((String) value);
			helper.POBH_BROKER_CODE_WHEN_VALIDATE_ITEM(this, compositeAction
					.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN()
							.getDUMMY_BEAN());

			COMP_POBH_COMM_CODE.resetValue();
			COMP_UI_M_POBH_BROKER_DESC.resetValue();
			COMP_POBH_COVER_CODE.resetValue();
			COMP_POBH_BROKER_CURR_CODE.resetValue();
			COMP_POBH_APPLY_ON_SRNO.resetValue();
			
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_COMM_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_COMM_CODE((String) value);
			helper.POBH_COMM_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN(), compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN());
			
			COMP_UI_M_PS_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_COVER_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_COVER_CODE((String) value);
			helper.POBH_COVER_CODE_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
			COMP_UI_M_POBH_COVER_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_APPLY_ON_SRNO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_APPLY_ON_SRNO((Integer) value);
			helper.POBH_APPLY_ON_SRNO_WHEN_VALIDATE_ITEM(getPT_IL_POL_BROKER_HEAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBH_ACTING_AGENT_YN_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_ACTING_AGENT_YN(
					(String) value);
			helper.POBH_ACTING_AGENT_YN_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_HEAD_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void POBH_BROKER_CURR_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component,Object value)throws ValidatorException{
		try {
			getPT_IL_POL_BROKER_HEAD_BEAN().setPOBH_BROKER_CURR_CODE((String)value);
			helper.POBH_BROKER_CURR_CODE_WHEN_VALIDATE_ITEM(getPT_IL_POL_BROKER_HEAD_BEAN());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_BROKER_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		Connection connection = null;
		ResultSet resultSet = null;
		String currentValue = (String) object;
		String query1value = null;
		String query1 = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'LOV_CUST' " +
				"AND PS_CODE = 'IL_BROKER'";
		String query2 = null;

		try {
			connection = CommonUtils.getConnection();
    	    resultSet = new CRUDHandler().executeSelectStatement(query1, connection);
    	    if(resultSet.next()){
    	    	query1value = resultSet.getString(1);
    	    }
    	    query2 = "SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER WHERE CUST_CLASS " +
    	    	"IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM WHERE DECODE " +
    	    	"(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN ("+query1value+") AND PS_CODE = 'IL_BROKER' " +
    	    	"AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' AND ((CUST_CODE IN (SELECT " +
    	    	"CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = NVL(?, CDIV_DIVN_CODE) AND " +
    	    	"CUST_APPL_ALL_BRAN_YN = 'N'))OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND " +
    	    	"(CUST_CODE LIKE ? OR  CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?) AND ROWNUM < 25 ORDER BY 1";
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = ListItemUtil.prepareSuggestionList(query2, 
				new Object[]{compositeAction.getPT_IL_POLICY_ACTION_BEAN()
					.getPT_IL_POLICY_BEAN().getPOL_DIVN_CODE(),currentValue,currentValue,currentValue});
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	public ArrayList<LovBean> prepareSuggestionList_BROKER_CURR_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BROKER_HEAD";
		String fieldName = "POBH_BROKER_CURR_CODE";
		

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,null,
					null, null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	public ArrayList<LovBean> prepareSuggestionList_COMM_CODE(Object object)
			throws Exception {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BROKER_HEAD";
		String fieldName = "POBH_COMM_CODE";
		Object param1 = "IL_COMM_HIER";
		String qry = "SELECT BCH_CODE, BCH_DESC FROM PM_BROKER_COMM_HDR WHERE " +
				"(BCH_CODE LIKE ? OR BCH_DESC LIKE ?)";
		
		DUMMY dummybean = null;

		try {
			dummybean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			if(dummybean.getUI_M_IL_BROK_CALC() == 1){
				lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
						null, null, null, currentValue);
			}else{
				lovList = ListItemUtil.prepareSuggestionList(qry, new Object[]{currentValue,currentValue});
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lovList;
	}

	public ArrayList<LovBean> prepareSuggestionList_COVER_CODE(Object object)
			throws Exception {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();

		String currentValue = (String) object;
		String moduleName = "PILT002_APAC";
		String blockName = "PT_IL_POL_BROKER_HEAD";
		String fieldName = "POBH_COVER_CODE";
		Object param1 = String.valueOf(compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				.getPT_IL_POLICY_BEAN().getPOL_SYS_ID());

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName, param1, null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return lovList;
	}
	
	 

	/**
	 * Disables all components in PT_IL_POL_BROKER_HEAD_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_POBH_SRNO.setDisabled(disabled);
		COMP_POBH_BROKER_CODE.setDisabled(disabled);
		COMP_POBH_COMM_CODE.setDisabled(disabled);
		COMP_POBH_COVER_CODE.setDisabled(disabled);
		COMP_POBH_APPLY_ON_SRNO.setDisabled(disabled);
		COMP_POBH_BROKER_CURR_CODE.setDisabled(disabled);
		COMP_POBH_REMARKS.setDisabled(disabled);
		COMP_UI_M_POBH_BROKER_DESC.setDisabled(disabled);
		COMP_UI_M_POBH_COVER_DESC.setDisabled(disabled);
		COMP_UI_M_POBH_CURR_DESC.setDisabled(disabled);
		COMP_UI_M_PS_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_POBH_ACTING_AGENT_YN.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_SHOW_AGENT.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_BROKER_HEAD_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POBH_SRNO					 = new HtmlInputText();
		COMP_POBH_BROKER_CODE				 = new HtmlInputText();
		COMP_POBH_COMM_CODE				 = new HtmlInputText();
		COMP_POBH_COVER_CODE				 = new HtmlInputText();
		COMP_POBH_APPLY_ON_SRNO				 = new HtmlInputText();
		COMP_POBH_BROKER_CURR_CODE			 = new HtmlInputText();
		COMP_POBH_REMARKS				 = new HtmlInputText();
		COMP_UI_M_POBH_BROKER_DESC			 = new HtmlInputText();
		COMP_UI_M_POBH_COVER_DESC			 = new HtmlInputText();
		COMP_UI_M_POBH_CURR_DESC			 = new HtmlInputText();
		COMP_UI_M_PS_DESC				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POBH_SRNO_LABEL				 = new HtmlOutputLabel();
		COMP_POBH_BROKER_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POBH_COMM_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POBH_COVER_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_POBH_APPLY_ON_SRNO_LABEL			 = new HtmlOutputLabel();
		COMP_POBH_BROKER_CURR_CODE_LABEL		 = new HtmlOutputLabel();
		COMP_POBH_ACTING_AGENT_YN_LABEL			 = new HtmlOutputLabel();
		COMP_POBH_REMARKS_LABEL				 = new HtmlOutputLabel();
		COMP_UI_M_POBH_BROKER_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_UI_M_POBH_COVER_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POBH_CURR_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_PS_DESC_LABEL				 = new HtmlOutputLabel();

		// Instantiating HtmlSelectOneMenu
		COMP_POBH_ACTING_AGENT_YN			 = new HtmlSelectOneMenu();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_SHOW_AGENT			 = new HtmlCommandButton();

	}


}
