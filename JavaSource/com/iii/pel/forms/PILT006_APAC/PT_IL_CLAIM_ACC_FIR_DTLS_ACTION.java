package com.iii.pel.forms.PILT006_APAC;

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

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_CLAIM_ACC_FIR_DTLS_ACTION extends CommonAction {
	
	private static final Log log = LogFactory.getLog(PT_IL_CLAIM_ACC_FIR_DTLS_ACTION.class);

	private HtmlOutputLabel COMP_CAFD_ACC_TYPE_LABEL;

	private HtmlInputText COMP_CAFD_ACC_TYPE;
	
	private HtmlOutputLabel COMP_CAFD_STA_CODE_LABEL;

	private HtmlInputText COMP_CAFD_STA_CODE;

	private HtmlOutputLabel COMP_CAFD_FIR_NO_LABEL;

	private HtmlInputText COMP_CAFD_FIR_NO;

	private HtmlOutputLabel COMP_CAFD_INJ_TYPE_LABEL;

	private HtmlInputText COMP_CAFD_INJ_TYPE;

	private HtmlOutputLabel COMP_CAFD_ACC_PLACE_LABEL;

	private HtmlInputText COMP_CAFD_ACC_PLACE;

	private HtmlOutputLabel COMP_CAFD_REG_DT_LABEL;

	private HtmlCalendar COMP_CAFD_REG_DT;

	private HtmlOutputLabel COMP_CAFD_ACC_DATE_LABEL;

	private HtmlCalendar COMP_CAFD_ACC_DATE;

	private HtmlOutputLabel COMP_UI_M_CAFD_ACC_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CAFD_ACC_TYPE_DESC;

	private HtmlOutputLabel COMP_UI_M_CAFD_STA_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CAFD_STA_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CAFD_INJ_TYPE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CAFD_INJ_TYPE_DESC;

	private HtmlCommandButton COMP_UI_M_LOV_BUT_CAFD_ACC_TYPE;

	private HtmlCommandButton COMP_UI_M_LOV_BUT_CAFD_INJ_TYPE;

	private HtmlCommandButton COMP_UI_M_LOV_BUT_CAFD_STA_CODE;

	private HtmlCommandButton COMP_PUSH_BUTTON967;

	private PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN;

	public PILT006_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_CLAIM_ACC_FIR_DTLS_HELPER helper;
	
	private List<LovBean> suggestionLOV = null;

	private List<PT_IL_CLAIM_ACC_FIR_DTLS> dataList_PT_IL_CLAIM_ACC_FIR_DTLS = new ArrayList<PT_IL_CLAIM_ACC_FIR_DTLS>();

	private UIData dataTable;
	
	private String filterByCAFD_FIR_NO;
	private String filterByCAFD_STA_CODE;
	private String filterByCAFD_ACC_TYPE;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	
	private HtmlAjaxCommandButton UI_M_BUT_DEL;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	private HtmlCommandButton UI_M_BUT_BACK;
	
	/**
	 * @return the uI_M_BUT_BACK
	 */
	public HtmlCommandButton getUI_M_BUT_BACK() {
		return UI_M_BUT_BACK;
	}


	/**
	 * @param ui_m_but_back the uI_M_BUT_BACK to set
	 */
	public void setUI_M_BUT_BACK(HtmlCommandButton ui_m_but_back) {
		UI_M_BUT_BACK = ui_m_but_back;
	}


	/**
	 * @return the suggestionLOV
	 */
	public List<LovBean> getSuggestionLOV() {
		return suggestionLOV;
	}


	/**
	 * @param suggestionLOV the suggestionLOV to set
	 */
	public void setSuggestionLOV(List<LovBean> suggestionLOV) {
		this.suggestionLOV = suggestionLOV;
	}


	/**
	 * @return the filterByCAFD_FIR_NO
	 */
	public String getFilterByCAFD_FIR_NO() {
		return filterByCAFD_FIR_NO;
	}


	/**
	 * @param filterByCAFD_FIR_NO the filterByCAFD_FIR_NO to set
	 */
	public void setFilterByCAFD_FIR_NO(String filterByCAFD_FIR_NO) {
		this.filterByCAFD_FIR_NO = filterByCAFD_FIR_NO;
	}


	/**
	 * @return the filterByCAFD_STA_CODE
	 */
	public String getFilterByCAFD_STA_CODE() {
		return filterByCAFD_STA_CODE;
	}


	/**
	 * @param filterByCAFD_STA_CODE the filterByCAFD_STA_CODE to set
	 */
	public void setFilterByCAFD_STA_CODE(String filterByCAFD_STA_CODE) {
		this.filterByCAFD_STA_CODE = filterByCAFD_STA_CODE;
	}


	/**
	 * @return the filterByCAFD_ACC_TYPE
	 */
	public String getFilterByCAFD_ACC_TYPE() {
		return filterByCAFD_ACC_TYPE;
	}


	/**
	 * @param filterByCAFD_ACC_TYPE the filterByCAFD_ACC_TYPE to set
	 */
	public void setFilterByCAFD_ACC_TYPE(String filterByCAFD_ACC_TYPE) {
		this.filterByCAFD_ACC_TYPE = filterByCAFD_ACC_TYPE;
	}


	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}


	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}


	/**
	 * @return the uI_M_BUT_DEL
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DEL() {
		return UI_M_BUT_DEL;
	}


	/**
	 * @param ui_m_but_del the uI_M_BUT_DEL to set
	 */
	public void setUI_M_BUT_DEL(HtmlAjaxCommandButton ui_m_but_del) {
		UI_M_BUT_DEL = ui_m_but_del;
	}


	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}


	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}


	/**
	 * @return the log
	 */
	public static Log getLog() {
		return log;
	}


	/**
	 * 
	 */
	public PT_IL_CLAIM_ACC_FIR_DTLS_ACTION() {

		PT_IL_CLAIM_ACC_FIR_DTLS_BEAN = new PT_IL_CLAIM_ACC_FIR_DTLS();
		helper = new PT_IL_CLAIM_ACC_FIR_DTLS_HELPER();
		instantiateAllComponent();
	}

	
	public PT_IL_CLAIM_ACC_FIR_DTLS getPT_IL_CLAIM_ACC_FIR_DTLS_BEAN() {
		return PT_IL_CLAIM_ACC_FIR_DTLS_BEAN;
	}

	public void setPT_IL_CLAIM_ACC_FIR_DTLS_BEAN(
			PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR_DTLS_BEAN) {
		this.PT_IL_CLAIM_ACC_FIR_DTLS_BEAN = PT_IL_CLAIM_ACC_FIR_DTLS_BEAN;
	}

	public List<PT_IL_CLAIM_ACC_FIR_DTLS> getDataList_PT_IL_CLAIM_ACC_FIR_DTLS() {
		return dataList_PT_IL_CLAIM_ACC_FIR_DTLS;
	}

	public void setDataListPT_IL_CLAIM_ACC_FIR_DTLS(
			List<PT_IL_CLAIM_ACC_FIR_DTLS> dataList_PT_IL_CLAIM_ACC_FIR_DTLS) {
		this.dataList_PT_IL_CLAIM_ACC_FIR_DTLS = dataList_PT_IL_CLAIM_ACC_FIR_DTLS;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN = new PT_IL_CLAIM_ACC_FIR_DTLS();
				resetAllComponent();
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
	
	/**
	 * 
	 * @param event
	 */
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,
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
				dataList_PT_IL_CLAIM_ACC_FIR_DTLS
						.remove(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
				if (dataList_PT_IL_CLAIM_ACC_FIR_DTLS.size() > 0) {

					PT_IL_CLAIM_ACC_FIR_DTLS_BEAN = dataList_PT_IL_CLAIM_ACC_FIR_DTLS
							.get(0);
					PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setRowSelected(true);
					setPT_IL_CLAIM_ACC_FIR_DTLS_BEAN(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
				} else if (dataList_PT_IL_CLAIM_ACC_FIR_DTLS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				//PT_IL_CLAIM_ACC_FIR_DTLS.setRowSelected(true);
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
		try {
			if (PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,
								 compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN(), 
								 compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				
				new CRUDHandler().executeInsert(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				dataList_PT_IL_CLAIM_ACC_FIR_DTLS
						.add(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
			} else if (PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				
				helper.preUpdate(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN, 
								 compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeUpdate(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN,
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

			if(dataList_PT_IL_CLAIM_ACC_FIR_DTLS!=null 
					&& dataList_PT_IL_CLAIM_ACC_FIR_DTLS.size()>0){
				for(int i=0;i<dataList_PT_IL_CLAIM_ACC_FIR_DTLS.size();i++){
					PT_IL_CLAIM_ACC_FIR_DTLS PT_IL_CLAIM_ACC_FIR = dataList_PT_IL_CLAIM_ACC_FIR_DTLS.get(i);
					if(i==0){
						PT_IL_CLAIM_ACC_FIR.setRowSelected(true);
					}else{
						PT_IL_CLAIM_ACC_FIR.setRowSelected(false);
					}
					setPT_IL_CLAIM_ACC_FIR_DTLS_BEAN(PT_IL_CLAIM_ACC_FIR);
				}
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}

	}
	/**
	 * 
	 */
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_CLAIM_ACC_FIR_DTLS_BEAN = (PT_IL_CLAIM_ACC_FIR_DTLS) dataTable
					.getRowData();
			PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
			setPT_IL_CLAIM_ACC_FIR_DTLS_BEAN(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	
	/**
	 * 
	 */
	private void resetSelectedRow() {
		Iterator<PT_IL_CLAIM_ACC_FIR_DTLS> PT_IL_CLAIM_ACC_FIR_DTLS_ITR = dataList_PT_IL_CLAIM_ACC_FIR_DTLS
				.iterator();
		while (PT_IL_CLAIM_ACC_FIR_DTLS_ITR.hasNext()) {
			PT_IL_CLAIM_ACC_FIR_DTLS_ITR.next().setRowSelected(false);
		}
	}
	/**
	 * 
	 */
	private void resetAllComponent() {
		COMP_CAFD_ACC_TYPE.resetValue();
		COMP_CAFD_ACC_TYPE.resetValue();
		COMP_CAFD_STA_CODE.resetValue();
		COMP_CAFD_STA_CODE.resetValue();
		COMP_CAFD_FIR_NO.resetValue();
		COMP_CAFD_FIR_NO.resetValue();
		COMP_CAFD_INJ_TYPE.resetValue();
		COMP_CAFD_INJ_TYPE.resetValue();
		COMP_CAFD_ACC_PLACE.resetValue();
		COMP_CAFD_ACC_PLACE.resetValue();
		COMP_CAFD_REG_DT.resetValue();
		COMP_CAFD_REG_DT.resetValue();
		COMP_CAFD_ACC_DATE.resetValue();
		COMP_CAFD_ACC_DATE.resetValue();
		COMP_UI_M_CAFD_ACC_TYPE_DESC.resetValue();
		COMP_UI_M_CAFD_ACC_TYPE_DESC.resetValue();
		COMP_UI_M_CAFD_STA_CODE_DESC.resetValue();
		COMP_UI_M_CAFD_STA_CODE_DESC.resetValue();
		COMP_UI_M_CAFD_INJ_TYPE_DESC.resetValue();
		COMP_UI_M_CAFD_INJ_TYPE_DESC.resetValue();
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
			String message ="";
			message = Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$save");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
								message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	/**
	 * 
	 * @param event
	 */
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				if(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.getROWID()!=null){
					helper.executeQuery(compositeAction);
					helper.postQuery(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}


	/**
	 * Instantiates all components in PT_IL_CLAIM_ACC_FIR_DTLS_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_CAFD_ACC_TYPE				 = new HtmlInputText();
		COMP_CAFD_STA_CODE				 = new HtmlInputText();
		COMP_CAFD_FIR_NO				 = new HtmlInputText();
		COMP_CAFD_INJ_TYPE				 = new HtmlInputText();
		COMP_CAFD_ACC_PLACE				 = new HtmlInputText();
		COMP_UI_M_CAFD_ACC_TYPE_DESC			 = new HtmlInputText();
		COMP_UI_M_CAFD_STA_CODE_DESC			 = new HtmlInputText();
		COMP_UI_M_CAFD_INJ_TYPE_DESC			 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_CAFD_REG_DT				 = new HtmlCalendar();
		COMP_CAFD_ACC_DATE				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_LOV_BUT_CAFD_ACC_TYPE			 = new HtmlCommandButton();
		COMP_UI_M_LOV_BUT_CAFD_INJ_TYPE			 = new HtmlCommandButton();
		COMP_UI_M_LOV_BUT_CAFD_STA_CODE			 = new HtmlCommandButton();
		COMP_PUSH_BUTTON967				 = new HtmlCommandButton();

	}


	/**
	 * Disables all components in PT_IL_CLAIM_ACC_FIR_DTLS_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_CAFD_ACC_TYPE.setDisabled(disabled);
		COMP_CAFD_STA_CODE.setDisabled(disabled);
		COMP_CAFD_FIR_NO.setDisabled(disabled);
		COMP_CAFD_INJ_TYPE.setDisabled(disabled);
		COMP_CAFD_ACC_PLACE.setDisabled(disabled);
		COMP_UI_M_CAFD_ACC_TYPE_DESC.setDisabled(disabled);
		COMP_UI_M_CAFD_STA_CODE_DESC.setDisabled(disabled);
		COMP_UI_M_CAFD_INJ_TYPE_DESC.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_CAFD_REG_DT.setDisabled(disabled);
		COMP_CAFD_ACC_DATE.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_LOV_BUT_CAFD_ACC_TYPE.setDisabled(disabled);
		COMP_UI_M_LOV_BUT_CAFD_INJ_TYPE.setDisabled(disabled);
		COMP_UI_M_LOV_BUT_CAFD_STA_CODE.setDisabled(disabled);
		COMP_PUSH_BUTTON967.setDisabled(disabled);

	}


	/**
	 * @return the cOMP_CAFD_ACC_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CAFD_ACC_TYPE_LABEL() {
		return COMP_CAFD_ACC_TYPE_LABEL;
	}


	/**
	 * @param comp_cafd_acc_type_label the cOMP_CAFD_ACC_TYPE_LABEL to set
	 */
	public void setCOMP_CAFD_ACC_TYPE_LABEL(HtmlOutputLabel comp_cafd_acc_type_label) {
		COMP_CAFD_ACC_TYPE_LABEL = comp_cafd_acc_type_label;
	}


	/**
	 * @return the cOMP_CAFD_ACC_TYPE
	 */
	public HtmlInputText getCOMP_CAFD_ACC_TYPE() {
		return COMP_CAFD_ACC_TYPE;
	}


	/**
	 * @param comp_cafd_acc_type the cOMP_CAFD_ACC_TYPE to set
	 */
	public void setCOMP_CAFD_ACC_TYPE(HtmlInputText comp_cafd_acc_type) {
		COMP_CAFD_ACC_TYPE = comp_cafd_acc_type;
	}


	/**
	 * @return the cOMP_CAFD_STA_CODE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CAFD_STA_CODE_LABEL() {
		return COMP_CAFD_STA_CODE_LABEL;
	}


	/**
	 * @param comp_cafd_sta_code_label the cOMP_CAFD_STA_CODE_LABEL to set
	 */
	public void setCOMP_CAFD_STA_CODE_LABEL(HtmlOutputLabel comp_cafd_sta_code_label) {
		COMP_CAFD_STA_CODE_LABEL = comp_cafd_sta_code_label;
	}


	/**
	 * @return the cOMP_CAFD_STA_CODE
	 */
	public HtmlInputText getCOMP_CAFD_STA_CODE() {
		return COMP_CAFD_STA_CODE;
	}


	/**
	 * @param comp_cafd_sta_code the cOMP_CAFD_STA_CODE to set
	 */
	public void setCOMP_CAFD_STA_CODE(HtmlInputText comp_cafd_sta_code) {
		COMP_CAFD_STA_CODE = comp_cafd_sta_code;
	}


	/**
	 * @return the cOMP_CAFD_FIR_NO_LABEL
	 */
	public HtmlOutputLabel getCOMP_CAFD_FIR_NO_LABEL() {
		return COMP_CAFD_FIR_NO_LABEL;
	}


	/**
	 * @param comp_cafd_fir_no_label the cOMP_CAFD_FIR_NO_LABEL to set
	 */
	public void setCOMP_CAFD_FIR_NO_LABEL(HtmlOutputLabel comp_cafd_fir_no_label) {
		COMP_CAFD_FIR_NO_LABEL = comp_cafd_fir_no_label;
	}


	/**
	 * @return the cOMP_CAFD_FIR_NO
	 */
	public HtmlInputText getCOMP_CAFD_FIR_NO() {
		return COMP_CAFD_FIR_NO;
	}


	/**
	 * @param comp_cafd_fir_no the cOMP_CAFD_FIR_NO to set
	 */
	public void setCOMP_CAFD_FIR_NO(HtmlInputText comp_cafd_fir_no) {
		COMP_CAFD_FIR_NO = comp_cafd_fir_no;
	}


	/**
	 * @return the cOMP_CAFD_INJ_TYPE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CAFD_INJ_TYPE_LABEL() {
		return COMP_CAFD_INJ_TYPE_LABEL;
	}


	/**
	 * @param comp_cafd_inj_type_label the cOMP_CAFD_INJ_TYPE_LABEL to set
	 */
	public void setCOMP_CAFD_INJ_TYPE_LABEL(HtmlOutputLabel comp_cafd_inj_type_label) {
		COMP_CAFD_INJ_TYPE_LABEL = comp_cafd_inj_type_label;
	}


	/**
	 * @return the cOMP_CAFD_INJ_TYPE
	 */
	public HtmlInputText getCOMP_CAFD_INJ_TYPE() {
		return COMP_CAFD_INJ_TYPE;
	}


	/**
	 * @param comp_cafd_inj_type the cOMP_CAFD_INJ_TYPE to set
	 */
	public void setCOMP_CAFD_INJ_TYPE(HtmlInputText comp_cafd_inj_type) {
		COMP_CAFD_INJ_TYPE = comp_cafd_inj_type;
	}


	/**
	 * @return the cOMP_CAFD_ACC_PLACE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CAFD_ACC_PLACE_LABEL() {
		return COMP_CAFD_ACC_PLACE_LABEL;
	}


	/**
	 * @param comp_cafd_acc_place_label the cOMP_CAFD_ACC_PLACE_LABEL to set
	 */
	public void setCOMP_CAFD_ACC_PLACE_LABEL(
			HtmlOutputLabel comp_cafd_acc_place_label) {
		COMP_CAFD_ACC_PLACE_LABEL = comp_cafd_acc_place_label;
	}


	/**
	 * @return the cOMP_CAFD_ACC_PLACE
	 */
	public HtmlInputText getCOMP_CAFD_ACC_PLACE() {
		return COMP_CAFD_ACC_PLACE;
	}


	/**
	 * @param comp_cafd_acc_place the cOMP_CAFD_ACC_PLACE to set
	 */
	public void setCOMP_CAFD_ACC_PLACE(HtmlInputText comp_cafd_acc_place) {
		COMP_CAFD_ACC_PLACE = comp_cafd_acc_place;
	}


	/**
	 * @return the cOMP_CAFD_REG_DT_LABEL
	 */
	public HtmlOutputLabel getCOMP_CAFD_REG_DT_LABEL() {
		return COMP_CAFD_REG_DT_LABEL;
	}


	/**
	 * @param comp_cafd_reg_dt_label the cOMP_CAFD_REG_DT_LABEL to set
	 */
	public void setCOMP_CAFD_REG_DT_LABEL(HtmlOutputLabel comp_cafd_reg_dt_label) {
		COMP_CAFD_REG_DT_LABEL = comp_cafd_reg_dt_label;
	}


	/**
	 * @return the cOMP_CAFD_REG_DT
	 */
	public HtmlCalendar getCOMP_CAFD_REG_DT() {
		return COMP_CAFD_REG_DT;
	}


	/**
	 * @param comp_cafd_reg_dt the cOMP_CAFD_REG_DT to set
	 */
	public void setCOMP_CAFD_REG_DT(HtmlCalendar comp_cafd_reg_dt) {
		COMP_CAFD_REG_DT = comp_cafd_reg_dt;
	}


	/**
	 * @return the cOMP_CAFD_ACC_DATE_LABEL
	 */
	public HtmlOutputLabel getCOMP_CAFD_ACC_DATE_LABEL() {
		return COMP_CAFD_ACC_DATE_LABEL;
	}


	/**
	 * @param comp_cafd_acc_date_label the cOMP_CAFD_ACC_DATE_LABEL to set
	 */
	public void setCOMP_CAFD_ACC_DATE_LABEL(HtmlOutputLabel comp_cafd_acc_date_label) {
		COMP_CAFD_ACC_DATE_LABEL = comp_cafd_acc_date_label;
	}


	/**
	 * @return the cOMP_CAFD_ACC_DATE
	 */
	public HtmlCalendar getCOMP_CAFD_ACC_DATE() {
		return COMP_CAFD_ACC_DATE;
	}


	/**
	 * @param comp_cafd_acc_date the cOMP_CAFD_ACC_DATE to set
	 */
	public void setCOMP_CAFD_ACC_DATE(HtmlCalendar comp_cafd_acc_date) {
		COMP_CAFD_ACC_DATE = comp_cafd_acc_date;
	}


	/**
	 * @return the cOMP_UI_M_CAFD_ACC_TYPE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CAFD_ACC_TYPE_DESC_LABEL() {
		return COMP_UI_M_CAFD_ACC_TYPE_DESC_LABEL;
	}


	/**
	 * @param comp_ui_m_cafd_acc_type_desc_label the cOMP_UI_M_CAFD_ACC_TYPE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CAFD_ACC_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cafd_acc_type_desc_label) {
		COMP_UI_M_CAFD_ACC_TYPE_DESC_LABEL = comp_ui_m_cafd_acc_type_desc_label;
	}


	/**
	 * @return the cOMP_UI_M_CAFD_ACC_TYPE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CAFD_ACC_TYPE_DESC() {
		return COMP_UI_M_CAFD_ACC_TYPE_DESC;
	}


	/**
	 * @param comp_ui_m_cafd_acc_type_desc the cOMP_UI_M_CAFD_ACC_TYPE_DESC to set
	 */
	public void setCOMP_UI_M_CAFD_ACC_TYPE_DESC(
			HtmlInputText comp_ui_m_cafd_acc_type_desc) {
		COMP_UI_M_CAFD_ACC_TYPE_DESC = comp_ui_m_cafd_acc_type_desc;
	}


	/**
	 * @return the cOMP_UI_M_CAFD_STA_CODE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CAFD_STA_CODE_DESC_LABEL() {
		return COMP_UI_M_CAFD_STA_CODE_DESC_LABEL;
	}


	/**
	 * @param comp_ui_m_cafd_sta_code_desc_label the cOMP_UI_M_CAFD_STA_CODE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CAFD_STA_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cafd_sta_code_desc_label) {
		COMP_UI_M_CAFD_STA_CODE_DESC_LABEL = comp_ui_m_cafd_sta_code_desc_label;
	}


	/**
	 * @return the cOMP_UI_M_CAFD_STA_CODE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CAFD_STA_CODE_DESC() {
		return COMP_UI_M_CAFD_STA_CODE_DESC;
	}


	/**
	 * @param comp_ui_m_cafd_sta_code_desc the cOMP_UI_M_CAFD_STA_CODE_DESC to set
	 */
	public void setCOMP_UI_M_CAFD_STA_CODE_DESC(
			HtmlInputText comp_ui_m_cafd_sta_code_desc) {
		COMP_UI_M_CAFD_STA_CODE_DESC = comp_ui_m_cafd_sta_code_desc;
	}


	/**
	 * @return the cOMP_UI_M_CAFD_INJ_TYPE_DESC_LABEL
	 */
	public HtmlOutputLabel getCOMP_UI_M_CAFD_INJ_TYPE_DESC_LABEL() {
		return COMP_UI_M_CAFD_INJ_TYPE_DESC_LABEL;
	}


	/**
	 * @param comp_ui_m_cafd_inj_type_desc_label the cOMP_UI_M_CAFD_INJ_TYPE_DESC_LABEL to set
	 */
	public void setCOMP_UI_M_CAFD_INJ_TYPE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cafd_inj_type_desc_label) {
		COMP_UI_M_CAFD_INJ_TYPE_DESC_LABEL = comp_ui_m_cafd_inj_type_desc_label;
	}


	/**
	 * @return the cOMP_UI_M_CAFD_INJ_TYPE_DESC
	 */
	public HtmlInputText getCOMP_UI_M_CAFD_INJ_TYPE_DESC() {
		return COMP_UI_M_CAFD_INJ_TYPE_DESC;
	}


	/**
	 * @param comp_ui_m_cafd_inj_type_desc the cOMP_UI_M_CAFD_INJ_TYPE_DESC to set
	 */
	public void setCOMP_UI_M_CAFD_INJ_TYPE_DESC(
			HtmlInputText comp_ui_m_cafd_inj_type_desc) {
		COMP_UI_M_CAFD_INJ_TYPE_DESC = comp_ui_m_cafd_inj_type_desc;
	}


	/**
	 * @return the cOMP_UI_M_LOV_BUT_CAFD_ACC_TYPE
	 */
	public HtmlCommandButton getCOMP_UI_M_LOV_BUT_CAFD_ACC_TYPE() {
		return COMP_UI_M_LOV_BUT_CAFD_ACC_TYPE;
	}


	/**
	 * @param comp_ui_m_lov_but_cafd_acc_type the cOMP_UI_M_LOV_BUT_CAFD_ACC_TYPE to set
	 */
	public void setCOMP_UI_M_LOV_BUT_CAFD_ACC_TYPE(
			HtmlCommandButton comp_ui_m_lov_but_cafd_acc_type) {
		COMP_UI_M_LOV_BUT_CAFD_ACC_TYPE = comp_ui_m_lov_but_cafd_acc_type;
	}


	/**
	 * @return the cOMP_UI_M_LOV_BUT_CAFD_INJ_TYPE
	 */
	public HtmlCommandButton getCOMP_UI_M_LOV_BUT_CAFD_INJ_TYPE() {
		return COMP_UI_M_LOV_BUT_CAFD_INJ_TYPE;
	}


	/**
	 * @param comp_ui_m_lov_but_cafd_inj_type the cOMP_UI_M_LOV_BUT_CAFD_INJ_TYPE to set
	 */
	public void setCOMP_UI_M_LOV_BUT_CAFD_INJ_TYPE(
			HtmlCommandButton comp_ui_m_lov_but_cafd_inj_type) {
		COMP_UI_M_LOV_BUT_CAFD_INJ_TYPE = comp_ui_m_lov_but_cafd_inj_type;
	}


	/**
	 * @return the cOMP_UI_M_LOV_BUT_CAFD_STA_CODE
	 */
	public HtmlCommandButton getCOMP_UI_M_LOV_BUT_CAFD_STA_CODE() {
		return COMP_UI_M_LOV_BUT_CAFD_STA_CODE;
	}


	/**
	 * @param comp_ui_m_lov_but_cafd_sta_code the cOMP_UI_M_LOV_BUT_CAFD_STA_CODE to set
	 */
	public void setCOMP_UI_M_LOV_BUT_CAFD_STA_CODE(
			HtmlCommandButton comp_ui_m_lov_but_cafd_sta_code) {
		COMP_UI_M_LOV_BUT_CAFD_STA_CODE = comp_ui_m_lov_but_cafd_sta_code;
	}


	/**
	 * @return the cOMP_PUSH_BUTTON967
	 */
	public HtmlCommandButton getCOMP_PUSH_BUTTON967() {
		return COMP_PUSH_BUTTON967;
	}


	/**
	 * @param comp_push_button967 the cOMP_PUSH_BUTTON967 to set
	 */
	public void setCOMP_PUSH_BUTTON967(HtmlCommandButton comp_push_button967) {
		COMP_PUSH_BUTTON967 = comp_push_button967;
	}


	/**
	 * @return the compositeAction
	 */
	public PILT006_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	/**
	 * @param compositeAction the compositeAction to set
	 */
	public void setCompositeAction(PILT006_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	/**
	 * @return the helper
	 */
	public PT_IL_CLAIM_ACC_FIR_DTLS_HELPER getHelper() {
		return helper;
	}


	/**
	 * @param helper the helper to set
	 */
	public void setHelper(PT_IL_CLAIM_ACC_FIR_DTLS_HELPER helper) {
		this.helper = helper;
	}


	/**
	 * @param dataList_PT_IL_CLAIM_ACC_FIR_DTLS the dataList_PT_IL_CLAIM_ACC_FIR_DTLS to set
	 */
	public void setDataList_PT_IL_CLAIM_ACC_FIR_DTLS(
			List<PT_IL_CLAIM_ACC_FIR_DTLS> dataList_PT_IL_CLAIM_ACC_FIR_DTLS) {
		this.dataList_PT_IL_CLAIM_ACC_FIR_DTLS = dataList_PT_IL_CLAIM_ACC_FIR_DTLS;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<LovBean> lovAccType(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM_ACC_FIR_DTLS", "CAFD_ACC_TYPE", 
					"IL_ACC_TYPE",
					null,
					null, 
					null, 
					null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	} 
	/**
	 * 
	 */
	public void setAcctTypeDesc(){
		try{
			String acctType = (String) this.getCOMP_CAFD_ACC_TYPE().getSubmittedValue().toString();
			this.PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_ACC_TYPE(acctType);
			
			if(suggestionLOV!=null){
				Iterator<LovBean> claimIterator = suggestionLOV.iterator();
				while(claimIterator.hasNext()){
					LovBean lovBean = claimIterator.next();
					if(acctType!=null && acctType.equals(lovBean.getCode())){
						this.getCOMP_UI_M_CAFD_ACC_TYPE_DESC().setSubmittedValue(lovBean.getName());
						this.PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setUI_M_CAFD_ACC_TYPE_DESC(lovBean.getName());
						return;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorAcctType(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			if(value!=null){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_ACC_TYPE((String)value);
				helper.whenValidateAcctType(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<LovBean> lovInjType(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM_ACC_FIR_DTLS", "CAFD_INJ_TYPE", 
					"IL_INJ_TYPE",
					null,
					null, 
					null, 
					null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	} 
	
	/**
	 * 
	 */
	public void setInjTypeDesc(){
		try{
			String injType = (String) this.getCOMP_CAFD_INJ_TYPE().getSubmittedValue().toString();
			this.PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_INJ_TYPE(injType);
			
			if(suggestionLOV!=null){
				Iterator<LovBean> claimIterator = suggestionLOV.iterator();
				while(claimIterator.hasNext()){
					LovBean lovBean = claimIterator.next();
					if(injType!=null && injType.equals(lovBean.getCode())){
						this.getCOMP_UI_M_CAFD_INJ_TYPE_DESC().setSubmittedValue(lovBean.getName());
						this.PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setUI_M_CAFD_INJ_TYPE_DESC(lovBean.getName());
						return;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorInjType(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			if(value!=null){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_INJ_TYPE((String)value);
				helper.whenValidateInjType(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorRegDate(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			if(value!=null){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_REG_DT((Date)value);
				helper.whenValidateCAFDRegDate(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN, 
												compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorAcctDate(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			if(value!=null){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_ACC_DATE((Date)value);
				helper.whenValidateCAFDAcctDate(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN, 
												compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public List<LovBean> lovSTACode(Object event){
		ListItemUtil itemUtil = new ListItemUtil();
		try {
			suggestionLOV = itemUtil.P_CALL_LOV("PILT006_APAC", "PT_IL_CLAIM_ACC_FIR_DTLS", "CAFD_STA_CODE", 
					"IL_STA_CODE",
					null,
					null, 
					null, 
					null, (String) event);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return suggestionLOV;
	} 
	
	/**
	 * 
	 */
	public void setSTACodeDesc(){
		try{
			String staCode = (String) this.getCOMP_CAFD_STA_CODE().getSubmittedValue().toString();
			this.PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_STA_CODE(staCode);
			
			if(suggestionLOV!=null){
				Iterator<LovBean> claimIterator = suggestionLOV.iterator();
				while(claimIterator.hasNext()){
					LovBean lovBean = claimIterator.next();
					if(staCode!=null && staCode.equals(lovBean.getCode())){
						this.getCOMP_UI_M_CAFD_STA_CODE_DESC().setSubmittedValue(lovBean.getName());
						this.PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setUI_M_CAFD_STA_CODE_DESC(lovBean.getName());
						return;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws ValidatorException
	 */
	public void validatorSTACode(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			if(value!=null){
				PT_IL_CLAIM_ACC_FIR_DTLS_BEAN.setCAFD_STA_CODE((String)value);
				helper.whenValidateSTACode(PT_IL_CLAIM_ACC_FIR_DTLS_BEAN);
			}
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	/*
	 * 
	 */
	public String whenUI_M_BUT_BACK_PRESS(){
		return "claimsEntry";
	}
}
