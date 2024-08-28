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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.ajax4jsf.taglib.html.jsp.AjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM007.PILM007_QUERYCONSTANTS;
import com.iii.pel.forms.PILM007.PM_IL_CLM_REPAY_HELPER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_BROKER_DEDUCTION_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_PBDED_CODE_LABEL;

	private HtmlInputText COMP_PBDED_CODE;
	
	private HtmlInputText COMP_UI_M_PBDED_CODE_DESC;
	

	private HtmlOutputLabel COMP_PBDED_RATE_LABEL;

	private HtmlInputText COMP_PBDED_RATE;

	private HtmlOutputLabel COMP_PBDED_RATE_PER_LABEL;

	private HtmlInputText COMP_PBDED_RATE_PER;
     
	private HtmlCommandButton COMP_UI_M_BTN_MAIN;
	

	private HtmlCommandButton COMP_UI_M_ADD;
	
	private HtmlCommandButton COMP_UI_M_DEL;
	
	private HtmlCommandButton COMP_UI_M_POST;
	

	private PT_IL_POL_BROKER_DEDUCTION PT_IL_POL_BROKER_DEDUCTION_BEAN;

	public PILT002_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_BROKER_DEDUCTION_HELPER helper;

	private List<PT_IL_POL_BROKER_DEDUCTION> dataList_PT_IL_POL_BROKER_DEDUCTION = new ArrayList<PT_IL_POL_BROKER_DEDUCTION>();

	private UIData dataTable;

	public PT_IL_POL_BROKER_DEDUCTION_ACTION() {

		PT_IL_POL_BROKER_DEDUCTION_BEAN = new PT_IL_POL_BROKER_DEDUCTION();
		helper = new PT_IL_POL_BROKER_DEDUCTION_HELPER();
		instantiateAllComponent();
	}

	public PT_IL_POL_BROKER_DEDUCTION getPT_IL_POL_BROKER_DEDUCTION_BEAN() {
		return PT_IL_POL_BROKER_DEDUCTION_BEAN;
	}

	public void setPT_IL_POL_BROKER_DEDUCTION_BEAN(
			PT_IL_POL_BROKER_DEDUCTION PT_IL_POL_BROKER_DTL_BEAN) {
		this.PT_IL_POL_BROKER_DEDUCTION_BEAN = PT_IL_POL_BROKER_DEDUCTION_BEAN;
	}

	public List<PT_IL_POL_BROKER_DEDUCTION> getDataList_PT_IL_POL_BROKER_DEDUCTION() {
		return dataList_PT_IL_POL_BROKER_DEDUCTION;
	}

	public void setDataListPT_IL_POL_BROKER_DEDUCTION(
			List<PT_IL_POL_BROKER_DEDUCTION> dataList_PT_IL_POL_BROKER_DEDUCTION) {
		this.dataList_PT_IL_POL_BROKER_DEDUCTION = dataList_PT_IL_POL_BROKER_DEDUCTION;
	}

	/*public void setDataList_PT_IL_POL_BROKER_DEDUCTION(
			List<PT_IL_POL_BROKER_DEDUCTION> dataList_PT_IL_POL_BROKER_DTLPT_IL_POL_BROKER_DEDUCTION) {
		this.dataList_PT_IL_POL_BROKER_DEDUCTION = dataList_PT_IL_POL_BROKER_DEDUCTION;
	}*/
	public void addRow(ActionEvent event) {
		try {
			
			if (isINSERT_ALLOWED()) {

				PT_IL_POL_BROKER_DEDUCTION_BEAN = new PT_IL_POL_BROKER_DEDUCTION();
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
				
				new CRUDHandler().executeDelete(PT_IL_POL_BROKER_DEDUCTION_BEAN,
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
				dataList_PT_IL_POL_BROKER_DEDUCTION.remove(PT_IL_POL_BROKER_DEDUCTION_BEAN);
				if (dataList_PT_IL_POL_BROKER_DEDUCTION.size() > 0) {

					PT_IL_POL_BROKER_DEDUCTION_BEAN = dataList_PT_IL_POL_BROKER_DEDUCTION
							.get(0);
				} else if (dataList_PT_IL_POL_BROKER_DEDUCTION.size() == 0) {

					addRow(null);
				}

				resetAllComponent();
				PT_IL_POL_BROKER_DEDUCTION_BEAN.setRowSelected(true);
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
			
			//helper.whenValidateRecord(PT_IL_POL_BROKER_DEDUCTION_BEAN);
			if (PT_IL_POL_BROKER_DEDUCTION_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				
				helper.preInsert(compositeAction
						.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getPT_IL_POL_BROKER_HEAD_BEAN(),
						PT_IL_POL_BROKER_DEDUCTION_BEAN, compositeAction
								.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(PT_IL_POL_BROKER_DEDUCTION_BEAN,
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
				dataList_PT_IL_POL_BROKER_DEDUCTION.add(PT_IL_POL_BROKER_DEDUCTION_BEAN);
			} else if (PT_IL_POL_BROKER_DEDUCTION_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
			
				helper.preUpdate(compositeAction
						.getPT_IL_POL_BROKER_HEAD_ACTION_BEAN()
						.getPT_IL_POL_BROKER_HEAD_BEAN(),
						PT_IL_POL_BROKER_DEDUCTION_BEAN, compositeAction
								.getCTRL_ACTION_BEAN().getCTRL_BEAN());

				new CRUDHandler().executeUpdate(PT_IL_POL_BROKER_DEDUCTION_BEAN,
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

			PT_IL_POL_BROKER_DEDUCTION_BEAN.setRowSelected(true);
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
			PT_IL_POL_BROKER_DEDUCTION_BEAN = (PT_IL_POL_BROKER_DEDUCTION) dataTable
					.getRowData();
			PT_IL_POL_BROKER_DEDUCTION_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_BROKER_DEDUCTION> PT_IL_POL_BROKER_DEDUCTION_ITR = dataList_PT_IL_POL_BROKER_DEDUCTION
				.iterator();
		while (PT_IL_POL_BROKER_DEDUCTION_ITR.hasNext()) {
			PT_IL_POL_BROKER_DEDUCTION_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_PBDED_CODE.resetValue();
		COMP_PBDED_RATE.resetValue();
		COMP_PBDED_RATE_PER.resetValue();
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
				CommonUtils.clearMaps(this);
				//helper.whenNewBlockInstance(this, compositeAction);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}helper.setcodedesc(PT_IL_POL_BROKER_DEDUCTION_BEAN);
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

	

	public void PBDED_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_DEDUCTION_BEAN().setPBDED_CODE((String)value);
			helper.setcodedesc(PT_IL_POL_BROKER_DEDUCTION_BEAN);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}



	public void PBDED_RATE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_DEDUCTION_BEAN().setPBDED_RATE((Double) value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PBDED_RATE_PER_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_POL_BROKER_DEDUCTION_BEAN().setPBDED_RATE_PER((Double)value);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * Disables all components in PT_IL_POL_BROKER_DTL_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_PBDED_CODE.setDisabled(disabled);
		COMP_PBDED_RATE.setDisabled(disabled);
		COMP_PBDED_RATE_PER.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_BROKER_DTL_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_PBDED_CODE			 = new HtmlInputText();
		COMP_PBDED_RATE					 = new HtmlInputText();
		COMP_PBDED_RATE_PER				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_PBDED_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_PBDED_RATE_LABEL				 = new HtmlOutputLabel();
		COMP_PBDED_RATE_PER_LABEL			 = new HtmlOutputLabel();
		
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

	public HtmlOutputLabel getCOMP_PBDED_CODE_LABEL() {
		return COMP_PBDED_CODE_LABEL;
	}

	public void setCOMP_PBDED_CODE_LABEL(HtmlOutputLabel comp_pbded_code_label) {
		COMP_PBDED_CODE_LABEL = comp_pbded_code_label;
	}

	public HtmlInputText getCOMP_PBDED_CODE() {
		return COMP_PBDED_CODE;
	}

	public void setCOMP_PBDED_CODE(HtmlInputText comp_pbded_code) {
		COMP_PBDED_CODE = comp_pbded_code;
	}

	public HtmlOutputLabel getCOMP_PBDED_RATE_LABEL() {
		return COMP_PBDED_RATE_LABEL;
	}

	public void setCOMP_PBDED_RATE_LABEL(HtmlOutputLabel comp_pbded_rate_label) {
		COMP_PBDED_RATE_LABEL = comp_pbded_rate_label;
	}

	public HtmlInputText getCOMP_PBDED_RATE() {
		return COMP_PBDED_RATE;
	}

	public void setCOMP_PBDED_RATE(HtmlInputText comp_pbded_rate) {
		COMP_PBDED_RATE = comp_pbded_rate;
	}

	public HtmlOutputLabel getCOMP_PBDED_RATE_PER_LABEL() {
		return COMP_PBDED_RATE_PER_LABEL;
	}

	public void setCOMP_PBDED_RATE_PER_LABEL(
			HtmlOutputLabel comp_pbded_rate_per_label) {
		COMP_PBDED_RATE_PER_LABEL = comp_pbded_rate_per_label;
	}

	public HtmlInputText getCOMP_PBDED_RATE_PER() {
		return COMP_PBDED_RATE_PER;
	}

	public void setCOMP_PBDED_RATE_PER(HtmlInputText comp_pbded_rate_per) {
		COMP_PBDED_RATE_PER = comp_pbded_rate_per;
	}

	public HtmlInputText getCOMP_UI_M_PBDED_CODE_DESC() {
		return COMP_UI_M_PBDED_CODE_DESC;
	}

	public void setCOMP_UI_M_PBDED_CODE_DESC(HtmlInputText comp_ui_m_pbded_code_desc) {
		COMP_UI_M_PBDED_CODE_DESC = comp_ui_m_pbded_code_desc;
	}

	public List<LovBean> lovDED_CODE(Object obj) throws Exception {
		String DedCode = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		ResultSet rs=null;
		LovBean lovBean = null;
		List<LovBean> list =new ArrayList<LovBean>();
		try{
			Connection con= CommonUtils.getConnection();
			CRUDHandler handler= new CRUDHandler();
		if ("*".equals(DedCode)) {
			object = new Object[] {PELConstants.suggetionRecordSize};
			query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='COMM_TAX' AND PS_VALUE=2 AND ROWNUM <= ? ORDER BY 1";
		
		} else {
			object = new Object[] {
			// CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"),
					DedCode + "%",DedCode + "%" ,PELConstants.suggetionRecordSize};
			/*commented and added by ameen for FALCONLIFE-1344105 on 21-10-2016
			 * 
			 * query ="SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='COMM_TAX' AND PS_VALUE=2 AND (PS_CODE LIKE ? OR PS_CODE_DESC LIKE ?) AND ROWNUM <= ? ORDER BY 1";*/
			query ="SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='COMM_TAX' AND PS_VALUE=2 AND (UPPER(PS_CODE) LIKE UPPER(?) OR UPPER(PS_CODE_DESC) LIKE UPPER(?)) AND ROWNUM <= ? ORDER BY 1";
		}
		suggestionList=prepareLovList(query, object);
		/*rs=handler.executeSelectStatement(query, con, object);
	while(rs.next()){
		LovBean = new LovBean();
		PT_IL_POL_BROKER_DEDUCTION_BEAN.setPBDED_CODE(rs.getInt(1));
		PT_IL_POL_BROKER_DEDUCTION_BEAN.setUI_M_PBDED_CODE_DESC(rs.getString(2));
		
		list.add(PT_IL_POL_BROKER_DEDUCTION_BEAN);
	}
	setListDED_LIST(list);*/
	}catch(Exception e){
		e.printStackTrace();
		throw e;
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
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return suggestionList;
	}

	
}
