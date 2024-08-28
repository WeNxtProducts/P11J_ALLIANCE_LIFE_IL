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
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_POLICY_NR;
import com.iii.pel.utils.PremiaLib;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_ASSR_OCCU_DTLS_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PAOD_COMP_NAME_LABEL;

	private HtmlInputText COMP_PAOD_COMP_NAME;

	private HtmlOutputLabel COMP_PAOD_JOB_LABEL;

	private HtmlInputText COMP_PAOD_JOB;

	private HtmlOutputLabel COMP_PAOD_PERIOD_LABEL;

	private HtmlInputText COMP_PAOD_PERIOD;

	private HtmlCommandButton COMP_PAOD_BACK;

	private HtmlAjaxCommandButton COMP_ADD_ROW;

	private HtmlAjaxCommandButton COMP_DEL_ROW;

	private HtmlAjaxCommandButton COMP_POST_ROW;



	private ArrayList<PT_IL_POL_ASSR_OCCU_DTLS> list = new ArrayList<PT_IL_POL_ASSR_OCCU_DTLS>();

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ASSR_OCCU_DTLS_HELPER helper;

	private PT_IL_POL_ASSR_OCCU_DTLS PT_IL_POL_ASSR_OCCU_DTLS_BEAN;



	private List<PT_IL_POL_ASSR_OCCU_DTLS> dataList_PT_IL_POL_ASSR_OCCU_DTLS = new ArrayList<PT_IL_POL_ASSR_OCCU_DTLS>();

	private UIData dataTable;



	public HtmlAjaxCommandButton getCOMP_ADD_ROW() {
		return COMP_ADD_ROW;
	}


	public void setCOMP_ADD_ROW(HtmlAjaxCommandButton cOMP_ADD_ROW) {
		COMP_ADD_ROW = cOMP_ADD_ROW;
	}


	public HtmlAjaxCommandButton getCOMP_DEL_ROW() {
		return COMP_DEL_ROW;
	}


	public void setCOMP_DEL_ROW(HtmlAjaxCommandButton cOMP_DEL_ROW) {
		COMP_DEL_ROW = cOMP_DEL_ROW;
	}


	public HtmlAjaxCommandButton getCOMP_POST_ROW() {
		return COMP_POST_ROW;
	}


	public void setCOMP_POST_ROW(HtmlAjaxCommandButton cOMP_POST_ROW) {
		COMP_POST_ROW = cOMP_POST_ROW;
	}


	public PT_IL_POL_ASSR_OCCU_DTLS getPT_IL_POL_ASSR_OCCU_DTLS_BEAN() {
		return PT_IL_POL_ASSR_OCCU_DTLS_BEAN;
	}


	public void setPT_IL_POL_ASSR_OCCU_DTLS_BEAN(
			PT_IL_POL_ASSR_OCCU_DTLS pT_IL_POL_ASSR_OCCU_DTLS_BEAN) {
		PT_IL_POL_ASSR_OCCU_DTLS_BEAN = pT_IL_POL_ASSR_OCCU_DTLS_BEAN;
	}


	public HtmlOutputLabel getCOMP_PAOD_COMP_NAME_LABEL() {
		return COMP_PAOD_COMP_NAME_LABEL;
	}


	public List<PT_IL_POL_ASSR_OCCU_DTLS> getDataList_PT_IL_POL_ASSR_OCCU_DTLS() {
		return dataList_PT_IL_POL_ASSR_OCCU_DTLS;
	}


	public void setDataList_PT_IL_POL_ASSR_OCCU_DTLS(
			List<PT_IL_POL_ASSR_OCCU_DTLS> dataList_PT_IL_POL_ASSR_OCCU_DTLS) {
		this.dataList_PT_IL_POL_ASSR_OCCU_DTLS = dataList_PT_IL_POL_ASSR_OCCU_DTLS;
	}


	public void setCOMP_PAOD_COMP_NAME_LABEL(
			HtmlOutputLabel cOMP_PAOD_COMP_NAME_LABEL) {
		COMP_PAOD_COMP_NAME_LABEL = cOMP_PAOD_COMP_NAME_LABEL;
	}


	public HtmlInputText getCOMP_PAOD_COMP_NAME() {
		return COMP_PAOD_COMP_NAME;
	}


	public void setCOMP_PAOD_COMP_NAME(HtmlInputText cOMP_PAOD_COMP_NAME) {
		COMP_PAOD_COMP_NAME = cOMP_PAOD_COMP_NAME;
	}


	public HtmlOutputLabel getCOMP_PAOD_JOB_LABEL() {
		return COMP_PAOD_JOB_LABEL;
	}


	public void setCOMP_PAOD_JOB_LABEL(HtmlOutputLabel cOMP_PAOD_JOB_LABEL) {
		COMP_PAOD_JOB_LABEL = cOMP_PAOD_JOB_LABEL;
	}


	public HtmlInputText getCOMP_PAOD_JOB() {
		return COMP_PAOD_JOB;
	}


	public void setCOMP_PAOD_JOB(HtmlInputText cOMP_PAOD_JOB) {
		COMP_PAOD_JOB = cOMP_PAOD_JOB;
	}


	public HtmlOutputLabel getCOMP_PAOD_PERIOD_LABEL() {
		return COMP_PAOD_PERIOD_LABEL;
	}


	public void setCOMP_PAOD_PERIOD_LABEL(HtmlOutputLabel cOMP_PAOD_PERIOD_LABEL) {
		COMP_PAOD_PERIOD_LABEL = cOMP_PAOD_PERIOD_LABEL;
	}


	public HtmlInputText getCOMP_PAOD_PERIOD() {
		return COMP_PAOD_PERIOD;
	}


	public void setCOMP_PAOD_PERIOD(HtmlInputText cOMP_PAOD_PERIOD) {
		COMP_PAOD_PERIOD = cOMP_PAOD_PERIOD;
	}


	public HtmlCommandButton getCOMP_PAOD_BACK() {
		return COMP_PAOD_BACK;
	}


	public void setCOMP_PAOD_BACK(HtmlCommandButton cOMP_PAOD_BACK) {
		COMP_PAOD_BACK = cOMP_PAOD_BACK;
	}


	public ArrayList<PT_IL_POL_ASSR_OCCU_DTLS> getList() {
		return list;
	}


	public void setList(ArrayList<PT_IL_POL_ASSR_OCCU_DTLS> list) {
		this.list = list;
	}


	public PILT002_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}


	public void setCompositeAction(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}


	public PT_IL_POL_ASSR_OCCU_DTLS_HELPER getHelper() {
		return helper;
	}


	public void setHelper(PT_IL_POL_ASSR_OCCU_DTLS_HELPER helper) {
		this.helper = helper;
	}


	public UIData getDataTable() {
		return dataTable;
	}


	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public PT_IL_POL_ASSR_OCCU_DTLS_ACTION() {

		PT_IL_POL_ASSR_OCCU_DTLS_BEAN = new PT_IL_POL_ASSR_OCCU_DTLS();
		helper = new PT_IL_POL_ASSR_OCCU_DTLS_HELPER();
		instantiateAllComponent();


	}


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {

			if (isBlockFlag()) {

				helper.executeQuery(compositeAction);

				setBlockFlag(false);

			}

			if((compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_FRZ_FLAG().equalsIgnoreCase("Y")) ||
					CommonUtils.nvl(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_APPRV_STATUS(),"N").equalsIgnoreCase("A"))
			{
				disableAllComponent(true);
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}




	public void instantiateAllComponent() {

		COMP_PAOD_COMP_NAME_LABEL = new HtmlOutputLabel();
		COMP_PAOD_COMP_NAME = new HtmlInputText();
		COMP_PAOD_JOB_LABEL = new HtmlOutputLabel();
		COMP_PAOD_JOB = new HtmlInputText();
		COMP_PAOD_PERIOD_LABEL = new HtmlOutputLabel();
		COMP_PAOD_PERIOD = new HtmlInputText();
		COMP_PAOD_BACK = new HtmlCommandButton();
		COMP_ADD_ROW = new HtmlAjaxCommandButton();
		COMP_DEL_ROW = new HtmlAjaxCommandButton();
		COMP_POST_ROW = new HtmlAjaxCommandButton();
		
		/*Added by Janani on 06.05.2018 for FSD_IL_FLA_008*/
		
		COMP_PAOD_PERIOD_FM = new HtmlCalendar();
		COMP_PAOD_PERIOD_TO = new HtmlCalendar();
		COMP_PAOD_PERIOD_TO_LABEL = new HtmlOutputLabel();
		
		/*eND*/
	}


	public void resetAllComponent() {

		COMP_PAOD_COMP_NAME.resetValue();
		COMP_PAOD_JOB.resetValue();
		COMP_PAOD_PERIOD.resetValue();
		
		/*Added by Janani on 06.05.2018 for FSD_IL_FLA_008*/
		
		COMP_PAOD_PERIOD_FM.resetValue();
		COMP_PAOD_PERIOD_TO.resetValue();
		
		/*eND*/

	}

	public void disableAllComponent(boolean disabled){

		COMP_PAOD_COMP_NAME.setDisabled(disabled);
		COMP_PAOD_JOB.setDisabled(disabled);
		COMP_PAOD_PERIOD.setDisabled(disabled);
		COMP_ADD_ROW.setDisabled(disabled);
		COMP_DEL_ROW.setDisabled(disabled);
		COMP_POST_ROW.setDisabled(disabled);
		
		/*Added by Janani on 06.05.2018 for FSD_IL_FLA_008*/
		
		COMP_PAOD_PERIOD_FM.setDisabled(disabled);
		COMP_PAOD_PERIOD_TO.setDisabled(disabled);
		
		/*eND*/
	}

	public String back(){
		String outcome = null;
		this.setBlockFlag(true);
		compositeAction.getPT_IL_POL_ASSR_OCCU_DTLS_ACTION_BEAN().setBlockFlag(true);
		outcome = "PILT002_APAC_PT_IL_POL_ASSURED_DTLS";
		//CommonUtils.setGlobalObject("POAD_SYS_ID", null);
		return outcome;
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_POL_ASSR_OCCU_DTLS_BEAN = (PT_IL_POL_ASSR_OCCU_DTLS) dataTable
					.getRowData();
			//helper.postQuery(PT_IL_POL_ASSR_OCCU_DTLS_BEAN);
			PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}


	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();


			if (isINSERT_ALLOWED()) {
				helper.WHEN_CREATE_RECORD(PT_IL_POL_ASSR_OCCU_DTLS_BEAN);
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN = new PT_IL_POL_ASSR_OCCU_DTLS();
				resetAllComponent();
				resetSelectedRow();

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
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}


	public void deleteRow(ActionEvent event) {
		String message = null;
		try {
			if (isDELETE_ALLOWED()) {


				new CRUDHandler().executeDelete(PT_IL_POL_ASSR_OCCU_DTLS_BEAN,
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
				dataList_PT_IL_POL_ASSR_OCCU_DTLS
				.remove(PT_IL_POL_ASSR_OCCU_DTLS_BEAN);
				if (dataList_PT_IL_POL_ASSR_OCCU_DTLS.size() > 0) {

					PT_IL_POL_ASSR_OCCU_DTLS_BEAN = dataList_PT_IL_POL_ASSR_OCCU_DTLS
							.get(0);
				} else if (dataList_PT_IL_POL_ASSR_OCCU_DTLS.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setRowSelected(true);


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


			CommonUtils.getConnection().commit();

		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	public String postRecord() {
		String message = null;
		try {
			if (PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {

			/*	if((!PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getPAOD_COMP_NAME().isEmpty() &&
								!PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getPAOD_JOB().isEmpty() &&
								!PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getPAOD_PERIOD_FM().equals("")) ||
								
								(!PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getPAOD_COMP_NAME().isEmpty() ||
										!PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getPAOD_JOB().isEmpty() ||
										!PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getPAOD_PERIOD_FM().equals(""))
						)
				{
*/
					helper.preInsert(compositeAction,PT_IL_POL_ASSR_OCCU_DTLS_BEAN);

					new CRUDHandler().executeInsert(PT_IL_POL_ASSR_OCCU_DTLS_BEAN,
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

					dataList_PT_IL_POL_ASSR_OCCU_DTLS
					.add(PT_IL_POL_ASSR_OCCU_DTLS_BEAN);

				}
				/*else
				{
					getErrorMap().put("addRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}	*/			
			
			else if(PT_IL_POL_ASSR_OCCU_DTLS_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {

				helper.preUpdate(PT_IL_POL_ASSR_OCCU_DTLS_BEAN);

				new CRUDHandler().executeUpdate(PT_IL_POL_ASSR_OCCU_DTLS_BEAN,
						CommonUtils.getConnection());

				getWarningMap().put("SAVE",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));

			}

			CommonUtils.getConnection().commit();

			PT_IL_POL_ASSR_OCCU_DTLS_BEAN.setRowSelected(true);



		} catch (Exception exc) {
			exc.printStackTrace(); 
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("postRecord", exc.getMessage());
		}
		return "";

	}


	private void resetSelectedRow() {
		Iterator<PT_IL_POL_ASSR_OCCU_DTLS> PT_IL_POL_ASSR_OCCU_DTLS_ITR = dataList_PT_IL_POL_ASSR_OCCU_DTLS.iterator();
		while (PT_IL_POL_ASSR_OCCU_DTLS_ITR.hasNext()) {
			PT_IL_POL_ASSR_OCCU_DTLS_ITR.next().setRowSelected(false);
		}
	}




	public void PAOD_COMP_NAME_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_OCCU_DTLS_BEAN().setPAOD_COMP_NAME((String) value);

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAOD_JOB_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_OCCU_DTLS_BEAN().setPAOD_JOB((String) value);

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAOD_PERIOD_Validator(FacesContext context,
			UIComponent component, Object value){

		try {
			getPT_IL_POL_ASSR_OCCU_DTLS_BEAN().setPAOD_PERIOD((String) value);

			//helper.POAC_WOP_FLAG_WHEN_LIST_CHANGED(PT_IL_POL_ADDL_COVER_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	/*Added by Janani on 06.05.2018 for FSD_IL_FLA_008*/
	
	private HtmlCalendar COMP_PAOD_PERIOD_FM;
	
	private HtmlCalendar COMP_PAOD_PERIOD_TO;

	private HtmlOutputLabel COMP_PAOD_PERIOD_TO_LABEL;
	
	
	public HtmlOutputLabel getCOMP_PAOD_PERIOD_TO_LABEL() {
		return COMP_PAOD_PERIOD_TO_LABEL;
	}


	public void setCOMP_PAOD_PERIOD_TO_LABEL(
			HtmlOutputLabel cOMP_PAOD_PERIOD_TO_LABEL) {
		COMP_PAOD_PERIOD_TO_LABEL = cOMP_PAOD_PERIOD_TO_LABEL;
	}


	public HtmlCalendar getCOMP_PAOD_PERIOD_FM() {
		return COMP_PAOD_PERIOD_FM;
	}


	public void setCOMP_PAOD_PERIOD_FM(HtmlCalendar cOMP_PAOD_PERIOD_FM) {
		COMP_PAOD_PERIOD_FM = cOMP_PAOD_PERIOD_FM;
	}


	public HtmlCalendar getCOMP_PAOD_PERIOD_TO() {
		return COMP_PAOD_PERIOD_TO;
	}


	public void setCOMP_PAOD_PERIOD_TO(HtmlCalendar cOMP_PAOD_PERIOD_TO) {
		COMP_PAOD_PERIOD_TO = cOMP_PAOD_PERIOD_TO;
	}

	
	
	public void PAOD_PERIOD_FM_Validator(FacesContext context,
			UIComponent component, Object value){

		Date dtValue = (Date) value;

		try {
			
			getPT_IL_POL_ASSR_OCCU_DTLS_BEAN().setPAOD_PERIOD_FM((Date) value);

			helper.PAOD_PERIOD_FM_WHEN_VALIDATE(compositeAction,PT_IL_POL_ASSR_OCCU_DTLS_BEAN,dtValue);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void PAOD_PERIOD_TO_Validator(FacesContext context,
			UIComponent component, Object value){

		Date dt_to_Value = (Date) value;
		
		try {
			getPT_IL_POL_ASSR_OCCU_DTLS_BEAN().setPAOD_PERIOD_TO((Date) value);

			helper.PAOD_PERIOD_TO_WHEN_VALIDATE(compositeAction,PT_IL_POL_ASSR_OCCU_DTLS_BEAN,dt_to_Value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	/*End*/
}