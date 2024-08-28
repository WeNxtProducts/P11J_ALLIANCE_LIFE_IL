package com.iii.pel.forms.PILT021;

import java.sql.Connection;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT021.PT_IL_DOC_TODO_LIST_STATUS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_DOC_TODO_LIST_STATUS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DTLS_SR_NO_LABEL;

	private HtmlInputText COMP_DTLS_SR_NO;

	private HtmlOutputLabel COMP_DTLS_TODO_LIST_ITEM_LABEL;

	private HtmlInputText COMP_DTLS_TODO_LIST_ITEM;

	private HtmlOutputLabel COMP_DTLS_MANDATORY_YN_LABEL;

	private HtmlSelectOneMenu COMP_DTLS_MANDATORY_YN;

	private HtmlOutputLabel COMP_DTLS_APPR_STS_LABEL;

	private HtmlSelectOneMenu COMP_DTLS_APPR_STS;

	private HtmlOutputLabel COMP_DTLS_DOC_REC_DT_LABEL;

	private HtmlCalendar COMP_DTLS_DOC_REC_DT;

	private HtmlOutputLabel COMP_DTLS_REMARKS_LABEL;

	private HtmlInputText COMP_DTLS_REMARKS;

	private PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;

	private PT_IL_DOC_TODO_LIST_STATUS_HELPER helper;

	private List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS = new ArrayList<PT_IL_DOC_TODO_LIST_STATUS>();

	private UIData dataTable;

	private List<SelectItem> listDTLS_MANDATORY_YN = new ArrayList<SelectItem>();

	private List<SelectItem> listDTLS_APPR_STS = new ArrayList<SelectItem>();

	Connection connection = null;
	
	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlAjaxCommandButton COMP_DEL_ROW;
	private HtmlAjaxCommandButton COMP_POST_ROW;
	private HtmlCommandButton COMP_UI_M_BACK;

	public HtmlCommandButton getCOMP_UI_M_BACK() {
		return COMP_UI_M_BACK;
	}

	public void setCOMP_UI_M_BACK(HtmlCommandButton comp_ui_m_back) {
		COMP_UI_M_BACK = comp_ui_m_back;
	}

	public PILT021_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT021_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_DOC_TODO_LIST_STATUS_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_DOC_TODO_LIST_STATUS_HELPER helper) {
		this.helper = helper;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}

	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton comp_add_row) {
		COMP_ADD_ROW = comp_add_row;
	}

	public HtmlAjaxCommandButton getCOMP_DEL_ROW() {
		return COMP_DEL_ROW;
	}

	public void setCOMP_DEL_ROW(HtmlAjaxCommandButton comp_del_row) {
		COMP_DEL_ROW = comp_del_row;
	}

	public HtmlAjaxCommandButton getCOMP_POST_ROW() {
		return COMP_POST_ROW;
	}

	public void setCOMP_POST_ROW(HtmlAjaxCommandButton comp_post_row) {
		COMP_POST_ROW = comp_post_row;
	}

	public void setDataList_PT_IL_DOC_TODO_LIST_STATUS(
			List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS) {
		this.dataList_PT_IL_DOC_TODO_LIST_STATUS = dataList_PT_IL_DOC_TODO_LIST_STATUS;
	}

	public PT_IL_DOC_TODO_LIST_STATUS_ACTION() {
		PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
		helper = new PT_IL_DOC_TODO_LIST_STATUS_HELPER();
		populateDropDowns();
	}

	public HtmlOutputLabel getCOMP_DTLS_SR_NO_LABEL() {
		return COMP_DTLS_SR_NO_LABEL;
	}

	public HtmlInputText getCOMP_DTLS_SR_NO() {
		return COMP_DTLS_SR_NO;
	}

	public void setCOMP_DTLS_SR_NO_LABEL(HtmlOutputLabel COMP_DTLS_SR_NO_LABEL) {
		this.COMP_DTLS_SR_NO_LABEL = COMP_DTLS_SR_NO_LABEL;
	}

	public void setCOMP_DTLS_SR_NO(HtmlInputText COMP_DTLS_SR_NO) {
		this.COMP_DTLS_SR_NO = COMP_DTLS_SR_NO;
	}

	public HtmlOutputLabel getCOMP_DTLS_TODO_LIST_ITEM_LABEL() {
		return COMP_DTLS_TODO_LIST_ITEM_LABEL;
	}

	public HtmlInputText getCOMP_DTLS_TODO_LIST_ITEM() {
		return COMP_DTLS_TODO_LIST_ITEM;
	}

	public void setCOMP_DTLS_TODO_LIST_ITEM_LABEL(
			HtmlOutputLabel COMP_DTLS_TODO_LIST_ITEM_LABEL) {
		this.COMP_DTLS_TODO_LIST_ITEM_LABEL = COMP_DTLS_TODO_LIST_ITEM_LABEL;
	}

	public void setCOMP_DTLS_TODO_LIST_ITEM(
			HtmlInputText COMP_DTLS_TODO_LIST_ITEM) {
		this.COMP_DTLS_TODO_LIST_ITEM = COMP_DTLS_TODO_LIST_ITEM;
	}

	public HtmlOutputLabel getCOMP_DTLS_MANDATORY_YN_LABEL() {
		return COMP_DTLS_MANDATORY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DTLS_MANDATORY_YN() {
		return COMP_DTLS_MANDATORY_YN;
	}

	public void setCOMP_DTLS_MANDATORY_YN_LABEL(
			HtmlOutputLabel COMP_DTLS_MANDATORY_YN_LABEL) {
		this.COMP_DTLS_MANDATORY_YN_LABEL = COMP_DTLS_MANDATORY_YN_LABEL;
	}

	public void setCOMP_DTLS_MANDATORY_YN(
			HtmlSelectOneMenu COMP_DTLS_MANDATORY_YN) {
		this.COMP_DTLS_MANDATORY_YN = COMP_DTLS_MANDATORY_YN;
	}

	public HtmlOutputLabel getCOMP_DTLS_APPR_STS_LABEL() {
		return COMP_DTLS_APPR_STS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_DTLS_APPR_STS() {
		return COMP_DTLS_APPR_STS;
	}

	public void setCOMP_DTLS_APPR_STS_LABEL(
			HtmlOutputLabel COMP_DTLS_APPR_STS_LABEL) {
		this.COMP_DTLS_APPR_STS_LABEL = COMP_DTLS_APPR_STS_LABEL;
	}

	public void setCOMP_DTLS_APPR_STS(HtmlSelectOneMenu COMP_DTLS_APPR_STS) {
		this.COMP_DTLS_APPR_STS = COMP_DTLS_APPR_STS;
	}

	public HtmlOutputLabel getCOMP_DTLS_DOC_REC_DT_LABEL() {
		return COMP_DTLS_DOC_REC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_DTLS_DOC_REC_DT() {
		return COMP_DTLS_DOC_REC_DT;
	}

	public void setCOMP_DTLS_DOC_REC_DT_LABEL(
			HtmlOutputLabel COMP_DTLS_DOC_REC_DT_LABEL) {
		this.COMP_DTLS_DOC_REC_DT_LABEL = COMP_DTLS_DOC_REC_DT_LABEL;
	}

	public void setCOMP_DTLS_DOC_REC_DT(HtmlCalendar COMP_DTLS_DOC_REC_DT) {
		this.COMP_DTLS_DOC_REC_DT = COMP_DTLS_DOC_REC_DT;
	}

	public HtmlOutputLabel getCOMP_DTLS_REMARKS_LABEL() {
		return COMP_DTLS_REMARKS_LABEL;
	}

	public HtmlInputText getCOMP_DTLS_REMARKS() {
		return COMP_DTLS_REMARKS;
	}

	public void setCOMP_DTLS_REMARKS_LABEL(
			HtmlOutputLabel COMP_DTLS_REMARKS_LABEL) {
		this.COMP_DTLS_REMARKS_LABEL = COMP_DTLS_REMARKS_LABEL;
	}

	public void setCOMP_DTLS_REMARKS(HtmlInputText COMP_DTLS_REMARKS) {
		this.COMP_DTLS_REMARKS = COMP_DTLS_REMARKS;
	}

	public PT_IL_DOC_TODO_LIST_STATUS getPT_IL_DOC_TODO_LIST_STATUS_BEAN() {
		return PT_IL_DOC_TODO_LIST_STATUS_BEAN;
	}

	public void setPT_IL_DOC_TODO_LIST_STATUS_BEAN(
			PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN) {
		this.PT_IL_DOC_TODO_LIST_STATUS_BEAN = PT_IL_DOC_TODO_LIST_STATUS_BEAN;
	}

	public List<PT_IL_DOC_TODO_LIST_STATUS> getDataList_PT_IL_DOC_TODO_LIST_STATUS() {
		return dataList_PT_IL_DOC_TODO_LIST_STATUS;
	}

	public void setDataListPT_IL_DOC_TODO_LIST_STATUS(
			List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS) {
		this.dataList_PT_IL_DOC_TODO_LIST_STATUS = dataList_PT_IL_DOC_TODO_LIST_STATUS;
	}

	public void addRow(ActionEvent event) {
		try {
			
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
				COMP_DTLS_SR_NO.setDisabled(false);
		    	COMP_DTLS_TODO_LIST_ITEM.setDisabled(false);
		    	COMP_DTLS_DOC_REC_DT.setDisabled(false);
		    	COMP_DTLS_REMARKS.setDisabled(false);
		    	COMP_DTLS_MANDATORY_YN.setDisabled(false);
		    	/*End*/
				PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
				/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
				helper.whenCreateRecord(compositeAction);
				/*End*/
				resetAllComponent();
				resetRowAtCreate();
				/*Added by saritha  on 07-12-2017 for ssp call id ZBLIFE-1457793*/
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
				/*End*/
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
				/*Parameter modified by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
				//helper.KEY_DELREC(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_MANDATORY_YN());
				//end
				/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
				helper.KEY_DELREC(PT_IL_DOC_TODO_LIST_STATUS_BEAN,compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				//end
				new CRUDHandler().executeDelete(
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
						.getConnection());
				/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
				CommonUtils.getConnection().commit();
				//end
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
				dataList_PT_IL_DOC_TODO_LIST_STATUS
				.remove(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
				if (dataList_PT_IL_DOC_TODO_LIST_STATUS.size() > 0) {

					PT_IL_DOC_TODO_LIST_STATUS_BEAN = dataList_PT_IL_DOC_TODO_LIST_STATUS
					.get(0);
				} else if (dataList_PT_IL_DOC_TODO_LIST_STATUS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
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
		CommonUtils.clearMaps(this);
		try {
			if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				new CRUDHandler().executeInsert(
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
						.getConnection());
				/*warning message modified by gopi for ssp call id ZBLIFE-1457793 on 09-12-2017*/
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				//end
				dataList_PT_IL_DOC_TODO_LIST_STATUS
				.add(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			} else if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				/*Added by saritha on on 12-12-2017 for ssp call id ZBLIFE-1457793*/
				if(getPT_IL_DOC_TODO_LIST_STATUS_BEAN().isUPDATE_ALL()){
					CommonUtils.updateAllRecords(dataList_PT_IL_DOC_TODO_LIST_STATUS, PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(), dataList_PT_IL_DOC_TODO_LIST_STATUS.size());
					
				}else{
					new CRUDHandler().executeUpdate(
							PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
							.getConnection());
				}
				/*new CRUDHandler().executeUpdate(
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
						.getConnection());*/
				/*End*/
				
				/*warning message modified by gopi for ssp call id ZBLIFE-1457793 on 09-12-2017*/
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				//end
			}

			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
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
			PT_IL_DOC_TODO_LIST_STATUS_BEAN = (PT_IL_DOC_TODO_LIST_STATUS) dataTable
			.getRowData();
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
			/*Added by saritha on 12-12-2017 for ssp call id ZBLIFE-1457793*/
			enableFields();
			/*End*/
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
		.iterator();
		while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
			/*Modified by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
			//PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);
			PT_IL_DOC_TODO_LIST_STATUS_BEAN = PT_IL_DOC_TODO_LIST_STATUS_ITR.next();
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD2_ENABLE("dataTableNonSelectedRow");
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(false);
			//end
		}
	}

	private void resetAllComponent() {
		COMP_DTLS_SR_NO.resetValue();
		COMP_DTLS_TODO_LIST_ITEM.resetValue();
		COMP_DTLS_MANDATORY_YN.resetValue();
		COMP_DTLS_APPR_STS.resetValue();
		COMP_DTLS_DOC_REC_DT.resetValue();
		COMP_DTLS_REMARKS.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
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

	private void populateDropDowns() {
		try {
			connection = CommonUtils.getConnection();

			listDTLS_APPR_STS = ListItemUtil.getDropDownListValue(connection,
					"PILT021", "PT_IL_DOC_TODO_LIST_STATUS",
					"PT_IL_DOC_TODO_LIST_STATUS.DTLS_APPR_STS", "YESNO");
			listDTLS_MANDATORY_YN = ListItemUtil.getDropDownListValue(
					connection, "PILT021", "PT_IL_DOC_TODO_LIST_STATUS",
					"PT_IL_DOC_TODO_LIST_STATUS.DTLS_MANDATORY_YN", "YESNO");
		} catch (DBException e) {
			e.printStackTrace();
		}
	}

	public List<SelectItem> getListDTLS_MANDATORY_YN() {
		if (listDTLS_MANDATORY_YN.size() == 0) {
			listDTLS_MANDATORY_YN.clear();
			try {
				listDTLS_MANDATORY_YN = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listDTLS_MANDATORY_YN;
	}

	public void setListDTLS_MANDATORY_YN(List<SelectItem> listDTLS_MANDATORY_YN) {
		this.listDTLS_MANDATORY_YN = listDTLS_MANDATORY_YN;
	}

	public List<SelectItem> getListDTLS_APPR_STS() {
		if (listDTLS_APPR_STS.size() == 0) {
			listDTLS_APPR_STS.clear();
			try {
				listDTLS_APPR_STS = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listDTLS_APPR_STS;
	}

	public void setListDTLS_APPR_STS(List<SelectItem> listDTLS_APPR_STS) {
		this.listDTLS_APPR_STS = listDTLS_APPR_STS;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
			resetAllComponent();
			//end
			if (isBlockFlag()) {
				helper.WHEN_NEW_BLOCK_INSTANCE();
				helper.executeQuery(compositeAction);
				/*Added by saritha on 12-12-2017 for ssp call id ZBLIFE-1457793*/
				resetAllComponent();
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDataTable(dataTable);
				/*End*/
				setBlockFlag(false);
				/*Added by saritha on 12-12-2017 for ssp call id ZBLIFE-1457793*/
				enableFields();
				/*End*/
			}
			if("A".equals(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS())){
				disableAllComponent(true);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void validateDTLS_APPR_STS(FacesContext context,
			UIComponent component, Object value) {
		try {
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS((String) value);
			/*added by raja on 12-07-2017 for ZBILQC-1731237*/
			helper.WHEN_VALIDATE_DTLS_APPR_STS((String) value, this,compositeAction);
			/*end*/
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	private void disableAllComponent(boolean disabled ){
		COMP_ADD_ROW.setDisabled(disabled);
		COMP_DEL_ROW.setDisabled(disabled);
		COMP_POST_ROW.setDisabled(disabled);
		COMP_DTLS_SR_NO.setDisabled(disabled);
		COMP_DTLS_TODO_LIST_ITEM.setDisabled(disabled);
		COMP_DTLS_MANDATORY_YN.setDisabled(disabled);
		COMP_DTLS_APPR_STS.setDisabled(disabled);
		COMP_DTLS_DOC_REC_DT.setDisabled(disabled);
		COMP_DTLS_REMARKS.setDisabled(disabled);
	}
	
	public String backButton()
	{
		String outcome=compositeAction.callPM_IL_DOC_TODO_GROUP();
		compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().setBlockFlag(true);
		return outcome;
	}
	/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
	public void setDTLS_APPR_STS_Editable(ActionEvent event) {
		try
		{
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		//int currentIndex=this.dataTable.getRowIndex();
		//PT_IL_DOC_TODO_LIST_STATUS_BEAN=(PT_IL_DOC_TODO_LIST_STATUS)dataList_PT_IL_DOC_TODO_LIST_STATUS.get(currentIndex);
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS(status);
		
		System.out.println("status      "+status);
		if(status != null && status.equalsIgnoreCase("Y"))
		{
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
			COMP_DTLS_DOC_REC_DT.setDisabled(false);
		}
		else
		{
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT(null);
			COMP_DTLS_DOC_REC_DT.setDisabled(true);
		}
		COMP_DTLS_DOC_REC_DT.resetValue();
		COMP_DTLS_APPR_STS.resetValue();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
	}
	
	 private void resetRowAtCreate() {
	    	Iterator<PT_IL_DOC_TODO_LIST_STATUS> PT_IL_DOC_TODO_LIST_STATUS_ITR = dataList_PT_IL_DOC_TODO_LIST_STATUS
	    			.iterator();
			while (PT_IL_DOC_TODO_LIST_STATUS_ITR.hasNext()) {
				PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);;
				
			}
		}
	 
		 
	 public void fireFieldValidationChk(ActionEvent actionEvent) {
		 try {

			 System.out.println("Enters into fireFieldValidationChk          "+compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS());

			 if((compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS()!=null && 
					 compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS().equalsIgnoreCase("N"))){

				 UIInput input = (UIInput) actionEvent.getComponent().getParent();

				 boolean chkFlag = false;
				 chkFlag = (boolean)input.getSubmittedValue();
				 String defChk = "N";
				 if(chkFlag)
				 {
					 defChk = "Y";
					 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
				 }else{
					 defChk = "N";
					 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
				 }
				 COMP_DTLS_DOC_REC_DT.resetValue();

				
				 
				 if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDataTable() == null)
				 {
					 PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDataTable(new UIData());
							 
				 }
				 
				 CommonUtils.setPageIndexing(getPT_IL_DOC_TODO_LIST_STATUS_BEAN(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getCOMP_DT_SCROLLER(),dataTable);

				 System.out.println("defChk        "+defChk+"       "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getCOMP_DT_SCROLLER().getPage()+"      "+dataTable.getRows());
				 System.out.println("page Start from "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex()+"    Ended to    "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getEndindex());


				 setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_APPR_STS", defChk,
						 PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(),getDataList_PT_IL_DOC_TODO_LIST_STATUS().size()));

				 setDataList_PT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_DOC_REC_DT", 
						 PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT(),getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getStartIndex(),getDataList_PT_IL_DOC_TODO_LIST_STATUS().size()));

				
				 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_APPR_STS(defChk);
				 COMP_DTLS_APPR_STS.resetValue();
				 
				 
				 getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setUPDATE_ALL(true);	 

			 }
		 } catch (Exception e) {
			 e.printStackTrace();
			 throw new ValidatorException(new FacesMessage(e.getMessage()));
		 }  


	 }

	 
	 private void enableFields()
	 {
		 if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected() != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getRowSelected().equals("dataTableSelectedRow"))
		 {
			 PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableSelectedRow");

			 if((compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS()!=null && 
					 compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS().equalsIgnoreCase("A"))){

				 PT_IL_DOC_TODO_LIST_STATUS_BEAN.setFIELD1_ENABLE("dataTableNonSelectedRow");

			 }

		 }

	 }
	 
	 public void validateDTLS_DOC_REC_DT(FacesContext context, UIComponent component, Object value) throws Exception {
			try{
				
				System.out.println("enters into validateDTLS_DOC_REC_DT                "+value);
				if(value!=null){
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_DOC_REC_DT((Date) value);
					
					System.out.println("getDTLS_DOC_REC_DT             "+PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT());
					
					if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_DOC_REC_DT().after(new CommonUtils().getCurrentDate())){
						throw new Exception("Date should be less than system date");
					}
				}
			}catch(Exception exception){
				exception.printStackTrace();
				throw new ValidatorException(new FacesMessage(exception.getMessage()));
			}
		}
	 
	 /*End*/
	 
}
