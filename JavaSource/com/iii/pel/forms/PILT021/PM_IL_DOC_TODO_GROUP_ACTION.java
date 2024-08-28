package com.iii.pel.forms.PILT021;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_DTG_GROUP_TYPE_LABEL;

	private HtmlInputText COMP_DTG_GROUP_TYPE;

	private HtmlOutputLabel COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_DTG_GROUP_CODE_DESC;

	private HtmlOutputLabel COMP_DTG_GROUP_CODE_LABEL;

	private HtmlInputText COMP_DTG_GROUP_CODE;

	private HtmlOutputLabel COMP_DTG_GROUP_DESC_LABEL;

	private HtmlInputText COMP_DTG_GROUP_DESC;

	private PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN;

	public PILT021_COMPOSITE_ACTION compositeAction;

	private PM_IL_DOC_TODO_GROUP_HELPER helper;

	private List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP = new ArrayList<PM_IL_DOC_TODO_GROUP>();

	private UIData dataTable;

	private HtmlAjaxCommandButton COMP_ADD_ROW;
	private HtmlAjaxCommandButton COMP_DEL_ROW;
	private HtmlAjaxCommandButton COMP_POST_ROW;
	private HtmlCommandButton COMP_UI_M_CHECK_DTLS;


	public HtmlCommandButton getCOMP_UI_M_CHECK_DTLS() {
		return COMP_UI_M_CHECK_DTLS;
	}

	public void setCOMP_UI_M_CHECK_DTLS(HtmlCommandButton comp_ui_m_check_dtls) {
		COMP_UI_M_CHECK_DTLS = comp_ui_m_check_dtls;
	}

	public PILT021_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT021_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PM_IL_DOC_TODO_GROUP_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PM_IL_DOC_TODO_GROUP_HELPER helper) {
		this.helper = helper;
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

	public void setDataList_PM_IL_DOC_TODO_GROUP(
			List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP) {
		this.dataList_PM_IL_DOC_TODO_GROUP = dataList_PM_IL_DOC_TODO_GROUP;
	}

	public PM_IL_DOC_TODO_GROUP_ACTION(){


		PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
		helper = new PM_IL_DOC_TODO_GROUP_HELPER();
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_TYPE_LABEL() {
		return COMP_DTG_GROUP_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_TYPE() {
		return COMP_DTG_GROUP_TYPE;
	}

	public void setCOMP_DTG_GROUP_TYPE_LABEL(HtmlOutputLabel COMP_DTG_GROUP_TYPE_LABEL) {
		this.COMP_DTG_GROUP_TYPE_LABEL = COMP_DTG_GROUP_TYPE_LABEL;
	}

	public void setCOMP_DTG_GROUP_TYPE(HtmlInputText COMP_DTG_GROUP_TYPE) {
		this.COMP_DTG_GROUP_TYPE = COMP_DTG_GROUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL() {
		return COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DTG_GROUP_CODE_DESC() {
		return COMP_UI_M_DTG_GROUP_CODE_DESC;
	}

	public void setCOMP_UI_M_DTG_GROUP_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL) {
		this.COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL = COMP_UI_M_DTG_GROUP_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_DTG_GROUP_CODE_DESC(HtmlInputText COMP_UI_M_DTG_GROUP_CODE_DESC) {
		this.COMP_UI_M_DTG_GROUP_CODE_DESC = COMP_UI_M_DTG_GROUP_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_CODE_LABEL() {
		return COMP_DTG_GROUP_CODE_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_CODE() {
		return COMP_DTG_GROUP_CODE;
	}

	public void setCOMP_DTG_GROUP_CODE_LABEL(HtmlOutputLabel COMP_DTG_GROUP_CODE_LABEL) {
		this.COMP_DTG_GROUP_CODE_LABEL = COMP_DTG_GROUP_CODE_LABEL;
	}

	public void setCOMP_DTG_GROUP_CODE(HtmlInputText COMP_DTG_GROUP_CODE) {
		this.COMP_DTG_GROUP_CODE = COMP_DTG_GROUP_CODE;
	}

	public HtmlOutputLabel getCOMP_DTG_GROUP_DESC_LABEL() {
		return COMP_DTG_GROUP_DESC_LABEL;
	}

	public HtmlInputText getCOMP_DTG_GROUP_DESC() {
		return COMP_DTG_GROUP_DESC;
	}

	public void setCOMP_DTG_GROUP_DESC_LABEL(HtmlOutputLabel COMP_DTG_GROUP_DESC_LABEL) {
		this.COMP_DTG_GROUP_DESC_LABEL = COMP_DTG_GROUP_DESC_LABEL;
	}

	public void setCOMP_DTG_GROUP_DESC(HtmlInputText COMP_DTG_GROUP_DESC) {
		this.COMP_DTG_GROUP_DESC = COMP_DTG_GROUP_DESC;
	}

	public PM_IL_DOC_TODO_GROUP getPM_IL_DOC_TODO_GROUP_BEAN() {
		return PM_IL_DOC_TODO_GROUP_BEAN;
	}

	public void setPM_IL_DOC_TODO_GROUP_BEAN(PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN) {
		this.PM_IL_DOC_TODO_GROUP_BEAN = PM_IL_DOC_TODO_GROUP_BEAN;
	}

	public List<PM_IL_DOC_TODO_GROUP> getDataList_PM_IL_DOC_TODO_GROUP() {
		return dataList_PM_IL_DOC_TODO_GROUP;
	}

	public void setDataListPM_IL_DOC_TODO_GROUP(List<PM_IL_DOC_TODO_GROUP> dataList_PM_IL_DOC_TODO_GROUP) {
		this.dataList_PM_IL_DOC_TODO_GROUP = dataList_PM_IL_DOC_TODO_GROUP;
	}

	public void addRow(ActionEvent event){
		try{
			CommonUtils.clearMaps(this);
			if (isINSERT_ALLOWED()){

				PM_IL_DOC_TODO_GROUP_BEAN = new PM_IL_DOC_TODO_GROUP();
				resetAllComponent();
				resetSelectedRow();
			}else{

				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insertnotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow",exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event){
		try{
			if (isDELETE_ALLOWED()){
				helper.preDelete(PM_IL_DOC_TODO_GROUP_BEAN.getDTG_GROUP_CODE());
				new CRUDHandler().executeDelete(PM_IL_DOC_TODO_GROUP_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				dataList_PM_IL_DOC_TODO_GROUP.remove(PM_IL_DOC_TODO_GROUP_BEAN);
				if(dataList_PM_IL_DOC_TODO_GROUP.size()>0){

					PM_IL_DOC_TODO_GROUP_BEAN=dataList_PM_IL_DOC_TODO_GROUP.get(0);
				}else if(dataList_PM_IL_DOC_TODO_GROUP.size()==0){

					addRow(null);
				}

				resetAllComponent();
				PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			}else{

				getErrorMap().put("deleteRow",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$deletenotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}

	}

	public void postRecord(ActionEvent event){
		CommonUtils.clearMaps(this);
		try{
			if(PM_IL_DOC_TODO_GROUP_BEAN.getROWID()==null && isINSERT_ALLOWED()){
				new CRUDHandler().executeInsert(PM_IL_DOC_TODO_GROUP_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
				dataList_PM_IL_DOC_TODO_GROUP.add(PM_IL_DOC_TODO_GROUP_BEAN);
			}else if(PM_IL_DOC_TODO_GROUP_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){

				new CRUDHandler().executeUpdate(PM_IL_DOC_TODO_GROUP_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
			}

			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: "+exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
		}
	}

	public void displayRecords(){
		CommonUtils.clearMaps(this);try{
			resetSelectedRow();
			PM_IL_DOC_TODO_GROUP_BEAN = (PM_IL_DOC_TODO_GROUP)dataTable.getRowData();
			helper.postQuery(PM_IL_DOC_TODO_GROUP_BEAN);
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			resetAllComponent();
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords",exc.getMessage());
		}

	}

	private void resetSelectedRow(){
		Iterator<PM_IL_DOC_TODO_GROUP> PM_IL_DOC_TODO_GROUP_ITR = dataList_PM_IL_DOC_TODO_GROUP.iterator();while (PM_IL_DOC_TODO_GROUP_ITR.hasNext()) {
			PM_IL_DOC_TODO_GROUP_ITR.next().setRowSelected(false);}
	}

	private void resetAllComponent(){
		COMP_DTG_GROUP_TYPE.resetValue();
		COMP_UI_M_DTG_GROUP_CODE_DESC.resetValue();
		COMP_DTG_GROUP_CODE.resetValue();
		COMP_DTG_GROUP_DESC.resetValue();
	}

	public void setDataTable(UIData dataTable) {this.dataTable = dataTable;
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


	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.preQuery(PM_IL_DOC_TODO_GROUP_BEAN);
				helper.executeQuery(compositeAction);
				if(PM_IL_DOC_TODO_GROUP_BEAN.getROWID() != null){
					helper.postQuery(PM_IL_DOC_TODO_GROUP_BEAN);
				}
				setBlockFlag(false);
				/*Added by saritha for ssp call id ZBLIFE-1457793 on 07-12-2017*/
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().onLoad(null);
				//end
			}
			if("A".equals(compositeAction.getPT_IL_WITHDRAWAL_ACTION_BEAN().getPT_IL_WITHDRAWAL_BEAN().getWD_APPRV_STATUS())){
				disableAllComponent(true);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}

	
	private void disableAllComponent(boolean disabled){
		COMP_ADD_ROW.setDisabled(disabled);
		COMP_DEL_ROW.setDisabled(disabled);
		COMP_POST_ROW.setDisabled(disabled);
		COMP_DTG_GROUP_TYPE.setDisabled(disabled);
		COMP_UI_M_DTG_GROUP_CODE_DESC.setDisabled(disabled);
		COMP_DTG_GROUP_CODE.setDisabled(disabled);
		COMP_DTG_GROUP_DESC.setDisabled(disabled);
		/*Added by ganesh for hands on feedback on 11-05-2017 */
		COMP_DTG_SAVE.setDisabled(disabled);
		COMP_DTG_SAVE_DOWN.setDisabled(disabled);
		/*end*/
	}
	public  String callToDoChecklist()
	{
		String outcome=compositeAction.callPT_IL_DOC_TODO_LIST_STATUS();
		compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.setBlockFlag(true);
		return outcome;
	}
	
	/* Added by Ganesh for hands on feedback on 11-05-2017 */
	private HtmlCommandLink COMP_DTG_SAVE;
	public HtmlCommandLink getCOMP_DTG_SAVE() {
		return COMP_DTG_SAVE;
	}

	public void setCOMP_DTG_SAVE(HtmlCommandLink cOMP_DTG_SAVE) {
		COMP_DTG_SAVE = cOMP_DTG_SAVE;
	}

	public HtmlCommandLink getCOMP_DTG_SAVE_DOWN() {
		return COMP_DTG_SAVE_DOWN;
	}

	public void setCOMP_DTG_SAVE_DOWN(HtmlCommandLink cOMP_DTG_SAVE_DOWN) {
		COMP_DTG_SAVE_DOWN = cOMP_DTG_SAVE_DOWN;
	}

	private HtmlCommandLink COMP_DTG_SAVE_DOWN;
	/*end*/
}
