package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.Date;
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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.fileupload.FileUploadAction;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_MED_EXAM_DTL;
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

	public PILT013_COMPOSITE_ACTION compositeAction;

	private PT_IL_DOC_TODO_LIST_STATUS_HELPER helper;

	private List<PT_IL_DOC_TODO_LIST_STATUS> dataList_PT_IL_DOC_TODO_LIST_STATUS = new ArrayList<PT_IL_DOC_TODO_LIST_STATUS>();

	private UIData dataTable;

	private List<SelectItem> listDTLS_MANDATORY_YN;

	private List<SelectItem> listDTLS_APPR_STS;

	public PT_IL_DOC_TODO_LIST_STATUS_ACTION() {

		PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
		helper = new PT_IL_DOC_TODO_LIST_STATUS_HELPER();
		prepareListItemValues();
		
		/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
		
		initializeAllComponent();
		
		/*End*/
		
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
			if (isINSERT_ALLOWED()) {

				PT_IL_DOC_TODO_LIST_STATUS_BEAN = new PT_IL_DOC_TODO_LIST_STATUS();
				resetAllComponent();
				resetSelectedRow();
			} else {
				throw new Exception(Messages.getString(
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

				new CRUDHandler().executeDelete(
						PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
								.getConnection());
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

				throw new Exception(Messages.getString(
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
			if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() == null) {

				if(isINSERT_ALLOWED()){
					new CRUDHandler().executeInsert(
							PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
							.getConnection());
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
					dataList_PT_IL_DOC_TODO_LIST_STATUS
					.add(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
				}
				else{
					throw new Exception(Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$insertnotallowed"));
				}
			} else if (PT_IL_DOC_TODO_LIST_STATUS_BEAN.getROWID() != null){

				if(isUPDATE_ALLOWED()) {
					/*Added by Ram on 31/03/2017 for Update All Functionality*/
					if(PT_IL_DOC_TODO_LIST_STATUS_BEAN.isUPDATE_ALL())
					{
						CommonUtils.updateAllRecords(dataList_PT_IL_DOC_TODO_LIST_STATUS, PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(), dataList_PT_IL_DOC_TODO_LIST_STATUS.size());
					}
					else
					{
					/*End*/
						
					
						new CRUDHandler().executeUpdate(
								PT_IL_DOC_TODO_LIST_STATUS_BEAN, CommonUtils
								.getConnection());
						}
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
						
					}else{
							throw new Exception(Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
						}
					}
			/*added by raja on 06-07-2017*/
			saveRecord();
			
			/*end*/
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
			PT_IL_DOC_TODO_LIST_STATUS_ITR.next().setRowSelected(false);
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

	public List<SelectItem> getListDTLS_MANDATORY_YN() {
		return listDTLS_MANDATORY_YN;
	}

	public void setListDTLS_MANDATORY_YN(List<SelectItem> listDTLS_MANDATORY_YN) {
		this.listDTLS_MANDATORY_YN = listDTLS_MANDATORY_YN;
	}

	public List<SelectItem> getListDTLS_APPR_STS() {
		return listDTLS_APPR_STS;
	}

	public void setListDTLS_APPR_STS(List<SelectItem> listDTLS_APPR_STS) {
		this.listDTLS_APPR_STS = listDTLS_APPR_STS;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void DTLS_SR_NO_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_SR_NO((Integer) value);
			helper.DTLS_SR_NO_WHEN_VALIDATE_ITEM(compositeAction, value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	//Committed by dhinesh For checklist issue SSP Call id is FALCONQC-1714757
	public void DTLS_DOC_REC_DT_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT((Date) value);
			System.out.println("setDTLS_DOC_REC_DT((Date) value):::"+getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_DOC_REC_DT());
			COMP_DTLS_DOC_REC_DT.resetValue();
			
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		 finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		}
	
	//end

	public void DTLS_APPR_STS_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			if("CHKLST".equalsIgnoreCase(compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
    				.getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_GROUP_TYPE()) &&
    				"Y".equalsIgnoreCase((String)value)){
    			if(!helper.isAllowed(PT_IL_DOC_TODO_LIST_STATUS_BEAN)){
    				throw new Exception("Kindly Upload Corresponding Document ");
    			}
    		}
			
			getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_APPR_STS(
					(String) value);
			helper.DTLS_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction, value);
			COMP_DTLS_DOC_REC_DT.resetValue();
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.WHEN_NEW_BLOCK_INSTANCE(compositeAction);
				helper.PRE_QUERY(compositeAction);
				helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
			
/*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
			
			System.out.println("getSMV_APPRV_FLAG                 "+compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG());
			
			
			if(compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG() != null && compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().
					getSMV_APPRV_FLAG().equalsIgnoreCase("a"))
			{
				disableAllComponent(true);
			}
			
			/*End*/
			
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	private void prepareListItemValues(){
		Connection connection = null;
		
		try {
			connection = CommonUtils.getConnection();
			listDTLS_APPR_STS = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "PT_IL_DOC_TODO_LIST_STATUS", "PT_IL_DOC_TODO_LIST_STATUS.DTLS_APPR_STS", null);
			listDTLS_MANDATORY_YN = ListItemUtil.getDropDownListValue_1(connection, 
					"PILT013", "PT_IL_DOC_TODO_LIST_STATUS", "PT_IL_DOC_TODO_LIST_STATUS.DTLS_MANDATORY_YN", null);
		} catch (DBException e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("ERROR_KEY", e.getMessage());
		}
		
	}
	
	public String backToSearch(){
		return "PILT013_PM_IL_DOC_TODO_GROUP";
	}
	
	
	/*Added by Raja on 19/06//2017 for Update All Functionality*/
	public void fireFieldValidationChk(ActionEvent actionEvent) {
		try {

		
				UIInput input = (UIInput) actionEvent.getComponent().getParent();



				System.out.println("Welcome to PACOND_DFLT_YN_ALL_Validator");
				boolean chkFlag = false;
				chkFlag = (boolean)input.getSubmittedValue();
				String defChk = "N";
				if(chkFlag)
				{
					defChk = "Y";
				}
			
				
				/*
				 *COMMENTED BY DHINESH ON 30-05-2017 FOR STATUS FIELD CHANGE IN WHOLE MEDICAL EXAM DATA LIST
				 * 
				 * setDataList_PT_IL_POL_MED_EXAM_DTL(CommonUtils.returnCheckedList(getDataList_PT_IL_POL_MED_EXAM_DTL(), "PMED_STATUS", defChk,
						 PT_IL_POL_MED_EXAM_DTL_BEAN.getStartIndex(),PT_IL_POL_MED_EXAM_DTL_BEAN.getEndindex()));*/

				setDataListPT_IL_DOC_TODO_LIST_STATUS(CommonUtils.returnCheckedList(getDataList_PT_IL_DOC_TODO_LIST_STATUS(), "DTLS_APPR_STS", defChk,
						PT_IL_DOC_TODO_LIST_STATUS_BEAN.getStartIndex(),getDataList_PT_IL_DOC_TODO_LIST_STATUS().size()));

				getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_APPR_STS(defChk);
				COMP_DTLS_APPR_STS.resetValue();


				getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setUPDATE_ALL(true);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}  


	}
	
	public void setPMED_STATUS_Editable(ActionEvent event) {
		try
		{
		CommonUtils.clearMaps(this);
		String status=(String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
		int currentIndex=this.dataTable.getRowIndex();
		PT_IL_DOC_TODO_LIST_STATUS_BEAN=(PT_IL_DOC_TODO_LIST_STATUS)dataList_PT_IL_DOC_TODO_LIST_STATUS.get(currentIndex);
		helper.DTLS_APPR_STS_WHEN_VALIDATE_ITEM(compositeAction, status);
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_APPR_STS(status);
		COMP_DTLS_APPR_STS.resetValue();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("postRecord", e.getMessage());	
		}
	}
	/*End*/


	 /*Added  by Janani on 17.07.2017 for ZBILQC-1724475*/
	 
	 public void disableAllComponent(boolean disabled) {
		 
		 COMP_DTLS_SR_NO.setDisabled(disabled);
		 COMP_DTLS_TODO_LIST_ITEM.setDisabled(disabled);
		 COMP_DTLS_MANDATORY_YN.setDisabled(disabled);
		 COMP_DTLS_APPR_STS.setDisabled(disabled);
		 COMP_DTLS_DOC_REC_DT.setDisabled(disabled);
		 COMP_DTLS_REMARKS.setDisabled(disabled);
	 }
	
	 private void initializeAllComponent() {
		 
		 COMP_DTLS_SR_NO = new HtmlInputText();
		 COMP_DTLS_TODO_LIST_ITEM = new HtmlInputText();
		 COMP_DTLS_MANDATORY_YN = new HtmlSelectOneMenu();
		 COMP_DTLS_APPR_STS = new HtmlSelectOneMenu();
		 COMP_DTLS_DOC_REC_DT = new HtmlCalendar();
		 COMP_DTLS_REMARKS = new HtmlInputText();
	 }
	 
	 /*End*/
	 
	 /*Added by gopi on 17/10/2022 for Aliance IL*/
		public String redirectUpload() {
			 String outcome = null;
			 if (PT_IL_DOC_TODO_LIST_STATUS_BEAN != null && PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SMV_SYS_ID() != null
					 && !(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SMV_SYS_ID().toString().trim().isEmpty())) {

				 FileUploadAction uploadAction = new FileUploadAction(
						 PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SYS_ID().toString(), PELConstants.pelPolicyTrans,
						 "PILT013_PM_IL_DOC_TODO_GROUP", this.getErrorMap());
				 outcome = uploadAction.gotoFileUpload();
				
			 } else {
				 getErrorMap().clear();
				 String fileUploadErrorMessage = Messages.getString(
						 "messageProperties_fileUpload",
						 "fileupload$polreference$error$message");
				 getErrorMap().put("key", fileUploadErrorMessage);
				 getErrorMap().put("current", fileUploadErrorMessage);
			 }
			 return outcome;
			
		}
		/*End*/
	 
	
}
