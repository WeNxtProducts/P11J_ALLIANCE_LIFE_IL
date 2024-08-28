package com.iii.pel.forms.PILQ003;

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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POL_FUND_DTL_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POFD_FUND_CODE_LABEL;

	private HtmlInputText COMP_POFD_FUND_CODE;

	private HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL;

	private HtmlInputText COMP_UI_M_FUND_DESC;

	private HtmlOutputLabel COMP_POFD_FUND_PERC_LABEL;

	private HtmlInputText COMP_POFD_FUND_PERC;

	private HtmlOutputLabel COMP_POFD_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_POFD_EFF_FM_DT;

	private HtmlOutputLabel COMP_POFD_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_POFD_EFF_TO_DT;
	
	private HtmlCommandButton  COMP_UI_M_BUT_FUND_DTL;
	
	private HtmlCommandButton  COMP_UI_M_BUT_MAIN;

	private PT_IL_POL_FUND_DTL_1 PT_IL_POL_FUND_DTL_1_BEAN;
	
	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_FUND_DTL_1_HELPER helper;

	private List<PT_IL_POL_FUND_DTL_1> dataList_PT_IL_POL_FUND_DTL_1 = new ArrayList<PT_IL_POL_FUND_DTL_1>();

	private UIData dataTable;

	public PT_IL_POL_FUND_DTL_1_ACTION() {

		PT_IL_POL_FUND_DTL_1_BEAN = new PT_IL_POL_FUND_DTL_1();
		helper = new PT_IL_POL_FUND_DTL_1_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_POFD_FUND_CODE_LABEL() {
		return COMP_POFD_FUND_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POFD_FUND_CODE() {
		return COMP_POFD_FUND_CODE;
	}

	public void setCOMP_POFD_FUND_CODE_LABEL(
			HtmlOutputLabel COMP_POFD_FUND_CODE_LABEL) {
		this.COMP_POFD_FUND_CODE_LABEL = COMP_POFD_FUND_CODE_LABEL;
	}

	public void setCOMP_POFD_FUND_CODE(HtmlInputText COMP_POFD_FUND_CODE) {
		this.COMP_POFD_FUND_CODE = COMP_POFD_FUND_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FUND_DESC_LABEL() {
		return COMP_UI_M_FUND_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FUND_DESC() {
		return COMP_UI_M_FUND_DESC;
	}

	public void setCOMP_UI_M_FUND_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_FUND_DESC_LABEL) {
		this.COMP_UI_M_FUND_DESC_LABEL = COMP_UI_M_FUND_DESC_LABEL;
	}

	public void setCOMP_UI_M_FUND_DESC(HtmlInputText COMP_UI_M_FUND_DESC) {
		this.COMP_UI_M_FUND_DESC = COMP_UI_M_FUND_DESC;
	}

	public HtmlOutputLabel getCOMP_POFD_FUND_PERC_LABEL() {
		return COMP_POFD_FUND_PERC_LABEL;
	}

	public HtmlInputText getCOMP_POFD_FUND_PERC() {
		return COMP_POFD_FUND_PERC;
	}

	public void setCOMP_POFD_FUND_PERC_LABEL(
			HtmlOutputLabel COMP_POFD_FUND_PERC_LABEL) {
		this.COMP_POFD_FUND_PERC_LABEL = COMP_POFD_FUND_PERC_LABEL;
	}

	public void setCOMP_POFD_FUND_PERC(HtmlInputText COMP_POFD_FUND_PERC) {
		this.COMP_POFD_FUND_PERC = COMP_POFD_FUND_PERC;
	}

	public HtmlOutputLabel getCOMP_POFD_EFF_FM_DT_LABEL() {
		return COMP_POFD_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POFD_EFF_FM_DT() {
		return COMP_POFD_EFF_FM_DT;
	}

	public void setCOMP_POFD_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_POFD_EFF_FM_DT_LABEL) {
		this.COMP_POFD_EFF_FM_DT_LABEL = COMP_POFD_EFF_FM_DT_LABEL;
	}

	public void setCOMP_POFD_EFF_FM_DT(HtmlCalendar COMP_POFD_EFF_FM_DT) {
		this.COMP_POFD_EFF_FM_DT = COMP_POFD_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_POFD_EFF_TO_DT_LABEL() {
		return COMP_POFD_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POFD_EFF_TO_DT() {
		return COMP_POFD_EFF_TO_DT;
	}

	public void setCOMP_POFD_EFF_TO_DT_LABEL(
			HtmlOutputLabel COMP_POFD_EFF_TO_DT_LABEL) {
		this.COMP_POFD_EFF_TO_DT_LABEL = COMP_POFD_EFF_TO_DT_LABEL;
	}

	public void setCOMP_POFD_EFF_TO_DT(HtmlCalendar COMP_POFD_EFF_TO_DT) {
		this.COMP_POFD_EFF_TO_DT = COMP_POFD_EFF_TO_DT;
	}

	public PT_IL_POL_FUND_DTL_1 getPT_IL_POL_FUND_DTL_1_BEAN() {
		return PT_IL_POL_FUND_DTL_1_BEAN;
	}

	public void setPT_IL_POL_FUND_DTL_1_BEAN(
			PT_IL_POL_FUND_DTL_1 PT_IL_POL_FUND_DTL_1_BEAN) {
		this.PT_IL_POL_FUND_DTL_1_BEAN = PT_IL_POL_FUND_DTL_1_BEAN;
	}

	public List<PT_IL_POL_FUND_DTL_1> getDataList_PT_IL_POL_FUND_DTL_1() {
		return dataList_PT_IL_POL_FUND_DTL_1;
	}

	public void setDataListPT_IL_POL_FUND_DTL_1(
			List<PT_IL_POL_FUND_DTL_1> dataList_PT_IL_POL_FUND_DTL_1) {
		this.dataList_PT_IL_POL_FUND_DTL_1 = dataList_PT_IL_POL_FUND_DTL_1;
	}

	public void addRow(ActionEvent event) {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				PT_IL_POL_FUND_DTL_1_BEAN = new PT_IL_POL_FUND_DTL_1();
				helper.WHEN_CREATE_RECORD(PT_IL_POL_FUND_DTL_1_BEAN);
				resetAllComponent();
				resetSelectedRow();
			} else {
				getErrorMap().put("addRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}
	}

	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				new CRUDHandler().executeDelete(PT_IL_POL_FUND_DTL_1_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$delete"));
				dataList_PT_IL_POL_FUND_DTL_1.remove(PT_IL_POL_FUND_DTL_1_BEAN);
				if (dataList_PT_IL_POL_FUND_DTL_1.size() > 0) {
					PT_IL_POL_FUND_DTL_1_BEAN = dataList_PT_IL_POL_FUND_DTL_1.get(0);
				} else if (dataList_PT_IL_POL_FUND_DTL_1.size() == 0) {
					addRow(null);
				}
				resetAllComponent();
				PT_IL_POL_FUND_DTL_1_BEAN.setRowSelected(true);
			} else {

				getErrorMap().put("deleteRow",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
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
			if (PT_IL_POL_FUND_DTL_1_BEAN.getROWID() == null
					&& isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(PT_IL_POL_FUND_DTL_1_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				dataList_PT_IL_POL_FUND_DTL_1.add(PT_IL_POL_FUND_DTL_1_BEAN);
			} else if (PT_IL_POL_FUND_DTL_1_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(PT_IL_POL_FUND_DTL_1_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(
					PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update"));
			}
			PT_IL_POL_FUND_DTL_1_BEAN.setRowSelected(true);
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
			PT_IL_POL_FUND_DTL_1_BEAN = (PT_IL_POL_FUND_DTL_1) dataTable
			.getRowData();
			helper.POST_QUERY(compositeAction);
			helper.WHEN_NEW_RECORD_INSTANCE(this);
			PT_IL_POL_FUND_DTL_1_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_POL_FUND_DTL_1> PT_IL_POL_FUND_DTL_1_ITR = 
			dataList_PT_IL_POL_FUND_DTL_1.iterator();
		while (PT_IL_POL_FUND_DTL_1_ITR.hasNext()) {
			PT_IL_POL_FUND_DTL_1_ITR.next().setRowSelected(false);
		}
	}

	private void resetAllComponent() {
		COMP_POFD_FUND_CODE.resetValue();
		COMP_UI_M_FUND_DESC.resetValue();
		COMP_POFD_FUND_PERC.resetValue();
		COMP_POFD_EFF_FM_DT.resetValue();
		COMP_POFD_EFF_TO_DT.resetValue();
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
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String goToFundAction() {
	    return "PILT002_APAC_PT_IL_POL_FUND_DTL";
	}
	public String goToPolicy() {
	    return "PILT002_APAC_PT_IL_POLICY";
	}
	/*public List<LovBean> lovPOFD_FUND_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('PT_IL_POL_FUND_DTL_1.POFD_FUND_CODE',:PT_IL_POLICY.POL_PROD_CODE,'T');
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POL_FUND_DTL_1", "POFD_FUND_CODE",
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN()
					.getPOL_PROD_CODE() ,"T",null,null, null, (String) currValue);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("lovPOFD_FUND_CODE", e.getMessage());
		}
		return suggestionList;
	}
*/
	
	public List<LovBean> lovPOFD_FUND_CODE(Object obj) throws Exception {
    	ArrayList<LovBean> suggestionList = null;
    
    	String currentValue = (String) obj;
    	String lovQuery = "SELECT FS_CODE,FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE "
    		+ "IN (SELECT PAF_FUND_CODE  FROM PM_IL_PROD_APPL_FUND WHERE PAF_PROD_CODE= ? "
    		+ "AND PAF_FUND_DIR_TYPE='P')  AND (FS_CODE LIKE ? OR  FS_DESC LIKE ? ) AND ROWNUM < 25 ORDER BY 1 ";
    
    	currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
    	Object[] value = {
    		compositeAction.getPT_IL_POLICY_ACTION_BEAN()
    			.getPT_IL_POLICY_BEAN().getPOL_PROD_CODE(),currentValue, currentValue };
    	try {
    	    suggestionList = ListItemUtil
    		    .prepareSuggestionList(lovQuery, value);
    
    	} catch (Exception e) {
    
    	}
    	return suggestionList;
}
	// CALL THE Validator

	public void validatePOFD_FUND_CODE(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_FUND_CODE((String) value);
			helper.POFD_FUND_CODE_WHEN_VALIDATE_ITEM( compositeAction, (String) value);
			COMP_POFD_FUND_CODE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_FUND_CODE", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOFD_FUND_PERC(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_FUND_PERC((Double) value);
			helper.POFD_FUND_PERC_WHEN_VALIDATE_ITEM( (Double) value);
			COMP_POFD_FUND_PERC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_FUND_PERC", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validatePOFD_EFF_FM_DT(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			Date curDate = (Date) value;
			PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_EFF_FM_DT(curDate);
			helper.POFD_EFF_FM_DT_WHEN_VALIDATE_ITEM( compositeAction, curDate);
			COMP_POFD_EFF_FM_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_EFF_FM_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validatePOFD_EFF_TO_DT(FacesContext facesContext,
			UIComponent component, Object value){

		try {
			Date curDate = (Date) value;
			PT_IL_POL_FUND_DTL_1_BEAN.setPOFD_EFF_TO_DT(curDate);
			helper.POFD_EFF_TO_DT_WHEN_VALIDATE_ITEM( compositeAction, curDate);
			COMP_POFD_EFF_TO_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POFD_EFF_TO_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			helper.PRE_BLOCK(compositeAction);
			if (isBlockFlag()) {
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.PRE_QUERY(compositeAction);
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_FUND_DTL_1_BEAN.getROWID() !=null){
					helper.POST_QUERY(compositeAction);
				}else{
					helper.WHEN_CREATE_RECORD(PT_IL_POL_FUND_DTL_1_BEAN);
				}
				helper.WHEN_NEW_RECORD_INSTANCE(this);
				setBlockFlag(false);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_DTL() {
	    return COMP_UI_M_BUT_FUND_DTL;
	}

	public void setCOMP_UI_M_BUT_FUND_DTL(HtmlCommandButton comp_ui_m_but_fund_dtl) {
	    COMP_UI_M_BUT_FUND_DTL = comp_ui_m_but_fund_dtl;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
	    return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
	    COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}

	/**
	 * Disables all components in PT_IL_POL_FUND_DTL_1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_POFD_FUND_CODE.setDisabled(disabled);
		COMP_UI_M_FUND_DESC.setDisabled(disabled);
		COMP_POFD_FUND_PERC.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_POFD_EFF_FM_DT.setDisabled(disabled);
		COMP_POFD_EFF_TO_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_FUND_DTL.setDisabled(disabled);
		COMP_UI_M_BUT_MAIN.setDisabled(disabled);

	}
	

	/**
	 * Instantiates all components in PT_IL_POL_FUND_DTL_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_POFD_FUND_CODE				 = new HtmlInputText();
		COMP_UI_M_FUND_DESC				 = new HtmlInputText();
		COMP_POFD_FUND_PERC				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_POFD_FUND_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_FUND_DESC_LABEL			 = new HtmlOutputLabel();
		COMP_POFD_FUND_PERC_LABEL			 = new HtmlOutputLabel();
		COMP_POFD_EFF_FM_DT_LABEL			 = new HtmlOutputLabel();
		COMP_POFD_EFF_TO_DT_LABEL			 = new HtmlOutputLabel();

		// Instantiating HtmlCalendar
		COMP_POFD_EFF_FM_DT				 = new HtmlCalendar();
		COMP_POFD_EFF_TO_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_FUND_DTL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_MAIN				 = new HtmlCommandButton();

	}



}
