package com.iii.pel.forms.PILT002_APAC;

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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POBD_YEAR_FROM_LABEL;

	private HtmlInputText COMP_POBD_YEAR_FROM;

	private HtmlOutputLabel COMP_POBD_YEAR_TO_LABEL;

	private HtmlInputText COMP_POBD_YEAR_TO;

	private HtmlOutputLabel COMP_POBD_RATE_LABEL;

	private HtmlInputText COMP_POBD_RATE;

	private HtmlOutputLabel COMP_POBD_RATE_PER_LABEL;

	private HtmlInputText COMP_POBD_RATE_PER;
	
	private HtmlCommandButton COMP_UI_M_BTN_MAIN;
	
	private HtmlCommandButton COMP_UI_M_ADD;
	
	private HtmlCommandButton COMP_UI_M_DEL;
	
	private HtmlCommandButton COMP_UI_M_POST;

	private PT_IL_POL_BROKER_DTL PT_IL_POL_BROKER_DTL_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BROKER_DTL_HELPER helper;

	private List<PT_IL_POL_BROKER_DTL> dataList_PT_IL_POL_BROKER_DTL = new ArrayList<PT_IL_POL_BROKER_DTL>();

	private UIData dataTable;

	public PT_IL_POL_BROKER_DTL_ACTION() {

		PT_IL_POL_BROKER_DTL_BEAN = new PT_IL_POL_BROKER_DTL();
		helper = new PT_IL_POL_BROKER_DTL_HELPER();
		instantiateAllComponent();
	}

	public PT_IL_POL_BROKER_DTL getPT_IL_POL_BROKER_DTL_BEAN() {
		return PT_IL_POL_BROKER_DTL_BEAN;
	}

	public void setPT_IL_POL_BROKER_DTL_BEAN(
			PT_IL_POL_BROKER_DTL PT_IL_POL_BROKER_DTL_BEAN) {
		this.PT_IL_POL_BROKER_DTL_BEAN = PT_IL_POL_BROKER_DTL_BEAN;
	}

	public List<PT_IL_POL_BROKER_DTL> getDataList_PT_IL_POL_BROKER_DTL() {
		return dataList_PT_IL_POL_BROKER_DTL;
	}

	public void setDataListPT_IL_POL_BROKER_DTL(
			List<PT_IL_POL_BROKER_DTL> dataList_PT_IL_POL_BROKER_DTL) {
		this.dataList_PT_IL_POL_BROKER_DTL = dataList_PT_IL_POL_BROKER_DTL;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {

				PT_IL_POL_BROKER_DTL_BEAN = new PT_IL_POL_BROKER_DTL();
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

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {
				
				new CRUDHandler().executeDelete(PT_IL_POL_BROKER_DTL_BEAN,
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
				dataList_PT_IL_POL_BROKER_DTL.remove(PT_IL_POL_BROKER_DTL_BEAN);
				if (dataList_PT_IL_POL_BROKER_DTL.size() > 0) {

					PT_IL_POL_BROKER_DTL_BEAN = dataList_PT_IL_POL_BROKER_DTL
							.get(0);
				} else if (dataList_PT_IL_POL_BROKER_DTL.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_BROKER_DTL_BEAN.setRowSelected(true);
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
			
			helper.whenValidateRecord(PT_IL_POL_BROKER_DTL_BEAN,compositeAction);
			if (PT_IL_POL_BROKER_DTL_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(compositeAction
						.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getPT_IL_POL_BROKER_HEAD_BEAN(),
						getPT_IL_POL_BROKER_DTL_BEAN(), compositeAction
								.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_BROKER_DTL_BEAN,
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
								"errorPanel$message$insert"));
				dataList_PT_IL_POL_BROKER_DTL.add(PT_IL_POL_BROKER_DTL_BEAN);
			} else if (PT_IL_POL_BROKER_DTL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
			
				helper.preUpdate(compositeAction
						.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getPT_IL_POL_BROKER_HEAD_BEAN(),
						getPT_IL_POL_BROKER_DTL_BEAN(), compositeAction
								.getCTRL_ACTION_BEAN().getCTRL_BEAN());

				new CRUDHandler().executeUpdate(PT_IL_POL_BROKER_DTL_BEAN,
						CommonUtils.getConnection());
				
				/*Newly Added By Dhinesh on 22-06-2017 */
				
				CommonUtils.getConnection().commit();
				
				/*End*/
				
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

			PT_IL_POL_BROKER_DTL_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(true);
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("KMAN001")){
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(false);
			}
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
			PT_IL_POL_BROKER_DTL_BEAN = (PT_IL_POL_BROKER_DTL) dataTable
					.getRowData();
			PT_IL_POL_BROKER_DTL_BEAN.setRowSelected(true);
			
			compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(true);
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("KMAN001")){
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(false);
			}
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BROKER_DTL> PT_IL_POL_BROKER_DTL_ITR = dataList_PT_IL_POL_BROKER_DTL
				.iterator();
		while (PT_IL_POL_BROKER_DTL_ITR.hasNext()) {
			PT_IL_POL_BROKER_DTL_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_POBD_YEAR_FROM.resetValue();
		COMP_POBD_YEAR_FROM.resetValue();
		COMP_POBD_YEAR_TO.resetValue();
		COMP_POBD_YEAR_TO.resetValue();
		COMP_POBD_RATE.resetValue();
		COMP_POBD_RATE_PER.resetValue();
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

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			
			if (isBlockFlag()) {
				/*Added By Jagadeesh*/
				PT_IL_POL_BROKER_DTL_BEAN = new PT_IL_POL_BROKER_DTL();
				/*End*/
				helper.whenNewBlockInstance(this, compositeAction);
				helper.executeQuery(compositeAction);
				/*Added By Jagadeesh*/
				resetAllComponent();
				/*End*/
				
				setBlockFlag(false);
			}
			String asd_char_value = helper.checkModifyRate(compositeAction);
			if("Y".equalsIgnoreCase(asd_char_value)){
				if(!("Y".equalsIgnoreCase
						(compositeAction.getPT_IL_POLICY_ACTION_BEAN().
								getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG()))){
				this.COMP_POBD_RATE.setDisabled(false);
				}
			}
			/*Newly added by pidugu raj dt: 15-12-2020 as suggested by Abhilash and kk for Alliance IL*/
			if(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE().equalsIgnoreCase("KMAN001")){
				compositeAction.getPT_IL_POL_BROKER_DTL_ACTION_BEAN().getCOMP_POBD_RATE().setDisabled(false);
			}
			/*End Newly added by pidugu raj dt: 15-12-2020 as suggested by Abhilash and kk for Alliance IL*/
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
		
	
	public String mainAction(){
		setBlockFlag(true);
		return "PILT002_APAC_PT_IL_POL_BROKER_HEAD";
	}

	public HtmlOutputLabel getCOMP_POBD_YEAR_FROM_LABEL() {
		return COMP_POBD_YEAR_FROM_LABEL;
	}

	public void setCOMP_POBD_YEAR_FROM_LABEL(
			HtmlOutputLabel comp_pobd_year_from_label) {
		COMP_POBD_YEAR_FROM_LABEL = comp_pobd_year_from_label;
	}

	public HtmlInputText getCOMP_POBD_YEAR_FROM() {
		return COMP_POBD_YEAR_FROM;
	}

	public void setCOMP_POBD_YEAR_FROM(HtmlInputText comp_pobd_year_from) {
		COMP_POBD_YEAR_FROM = comp_pobd_year_from;
	}

	public HtmlOutputLabel getCOMP_POBD_YEAR_TO_LABEL() {
		return COMP_POBD_YEAR_TO_LABEL;
	}

	public void setCOMP_POBD_YEAR_TO_LABEL(
			HtmlOutputLabel comp_pobd_year_to_label) {
		COMP_POBD_YEAR_TO_LABEL = comp_pobd_year_to_label;
	}

	public HtmlInputText getCOMP_POBD_YEAR_TO() {
		return COMP_POBD_YEAR_TO;
	}

	public void setCOMP_POBD_YEAR_TO(HtmlInputText comp_pobd_year_to) {
		COMP_POBD_YEAR_TO = comp_pobd_year_to;
	}

	public HtmlOutputLabel getCOMP_POBD_RATE_LABEL() {
		return COMP_POBD_RATE_LABEL;
	}

	public void setCOMP_POBD_RATE_LABEL(HtmlOutputLabel comp_pobd_rate_label) {
		COMP_POBD_RATE_LABEL = comp_pobd_rate_label;
	}

	public HtmlInputText getCOMP_POBD_RATE() {
		return COMP_POBD_RATE;
	}

	public void setCOMP_POBD_RATE(HtmlInputText comp_pobd_rate) {
		COMP_POBD_RATE = comp_pobd_rate;
	}

	public HtmlOutputLabel getCOMP_POBD_RATE_PER_LABEL() {
		return COMP_POBD_RATE_PER_LABEL;
	}

	public void setCOMP_POBD_RATE_PER_LABEL(
			HtmlOutputLabel comp_pobd_rate_per_label) {
		COMP_POBD_RATE_PER_LABEL = comp_pobd_rate_per_label;
	}

	public HtmlInputText getCOMP_POBD_RATE_PER() {
		return COMP_POBD_RATE_PER;
	}

	public void setCOMP_POBD_RATE_PER(HtmlInputText comp_pobd_rate_per) {
		COMP_POBD_RATE_PER = comp_pobd_rate_per;
	}

	public void setDataList_PT_IL_POL_BROKER_DTL(
			List<PT_IL_POL_BROKER_DTL> dataList_PT_IL_POL_BROKER_DTL) {
		this.dataList_PT_IL_POL_BROKER_DTL = dataList_PT_IL_POL_BROKER_DTL;
	}

	public void POBD_YEAR_FROM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_DTL_BEAN().setPOBD_YEAR_FROM((Integer) value);
			helper.POBD_YEAR_FROM_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_DTL_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBD_YEAR_TO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_DTL_BEAN().setPOBD_YEAR_TO((Integer) value);
			helper.POBD_YEAR_TO_WHEN_VALIDATE_ITEM(
					getPT_IL_POL_BROKER_DTL_BEAN(), compositeAction
							.getPT_IL_POLICY_ACTION_BEAN()
							.getPT_IL_POLICY_BEAN());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBD_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_DTL_BEAN().setPOBD_RATE((Double) value);
			helper.POBD_RATE_WHEN_VALIDATE_ITEM(getPT_IL_POL_BROKER_DTL_BEAN());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void POBD_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_DTL_BEAN().setPOBD_RATE_PER((Double) value);
			helper
					.POBD_RATE_PER_WHEN_VALIDATE_ITEM(getPT_IL_POL_BROKER_DTL_BEAN());

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * Disables all components in PT_IL_POL_BROKER_DTL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_POBD_YEAR_FROM.setDisabled(disabled);
		COMP_POBD_YEAR_TO.setDisabled(disabled);
		COMP_POBD_RATE.setDisabled(disabled);
		COMP_POBD_RATE_PER.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_BROKER_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POBD_YEAR_FROM				 = new HtmlInputText();
		COMP_POBD_YEAR_TO				 = new HtmlInputText();
		COMP_POBD_RATE					 = new HtmlInputText();
		COMP_POBD_RATE_PER				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POBD_YEAR_FROM_LABEL			 = new HtmlOutputLabel();
		COMP_POBD_YEAR_TO_LABEL				 = new HtmlOutputLabel();
		COMP_POBD_RATE_LABEL				 = new HtmlOutputLabel();
		COMP_POBD_RATE_PER_LABEL			 = new HtmlOutputLabel();
		
		COMP_UI_M_ADD=new HtmlCommandButton();
		COMP_UI_M_DEL=new HtmlCommandButton();
		COMP_UI_M_POST=new HtmlCommandButton();

	}

	public HtmlCommandButton getCOMP_UI_M_BTN_MAIN() {
		return COMP_UI_M_BTN_MAIN;
	}

	public void setCOMP_UI_M_BTN_MAIN(HtmlCommandButton comp_ui_m_btn_main) {
		COMP_UI_M_BTN_MAIN = comp_ui_m_btn_main;
	}

	public HtmlCommandButton getCOMP_UI_M_ADD() {
		return COMP_UI_M_ADD;
	}

	public void setCOMP_UI_M_ADD(HtmlCommandButton comp_ui_m_add) {
		COMP_UI_M_ADD = comp_ui_m_add;
	}

	public HtmlCommandButton getCOMP_UI_M_DEL() {
		return COMP_UI_M_DEL;
	}

	public void setCOMP_UI_M_DEL(HtmlCommandButton comp_ui_m_del) {
		COMP_UI_M_DEL = comp_ui_m_del;
	}

	public HtmlCommandButton getCOMP_UI_M_POST() {
		return COMP_UI_M_POST;
	}

	public void setCOMP_UI_M_POST(HtmlCommandButton comp_ui_m_post) {
		COMP_UI_M_POST = comp_ui_m_post;
	}



}
