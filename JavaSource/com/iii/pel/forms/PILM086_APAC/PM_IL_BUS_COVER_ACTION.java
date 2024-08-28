package com.iii.pel.forms.PILM086_APAC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_BUS_COVER_ACTION extends CommonAction{

	private PM_IL_BUS_COVER_HELPER helper;
	private PM_IL_BUS_COVER_DELEGATE delegate;
	public PILM086_APAC_COMPOSITE_ACTION compositeAction;	
	private PM_IL_BUS_COVER PM_IL_BUS_COVER_BEAN;
	private UIData dataTable;
	private HtmlOutputLabel COMP_BRCS_COVER_CODE_LABEL;
	private HtmlInputText COMP_BRCS_COVER_CODE;
	private HtmlInputText COMP_BRCS_COVER_CODE_DESC;
	
	public HtmlOutputLabel getCOMP_BRCS_COVER_CODE_LABEL() {
		return COMP_BRCS_COVER_CODE_LABEL;
	}
	public void setCOMP_BRCS_COVER_CODE_LABEL(
			HtmlOutputLabel cOMP_BRCS_COVER_CODE_LABEL) {
		COMP_BRCS_COVER_CODE_LABEL = cOMP_BRCS_COVER_CODE_LABEL;
	}
	public HtmlInputText getCOMP_BRCS_COVER_CODE() {
		return COMP_BRCS_COVER_CODE;
	}
	public void setCOMP_BRCS_COVER_CODE(HtmlInputText cOMP_BRCS_COVER_CODE) {
		COMP_BRCS_COVER_CODE = cOMP_BRCS_COVER_CODE;
	}
	public HtmlInputText getCOMP_BRCS_COVER_CODE_DESC() {
		return COMP_BRCS_COVER_CODE_DESC;
	}
	public void setCOMP_BRCS_COVER_CODE_DESC(HtmlInputText cOMP_BRCS_COVER_CODE_DESC) {
		COMP_BRCS_COVER_CODE_DESC = cOMP_BRCS_COVER_CODE_DESC;
	}
	public PILM086_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILM086_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	public PM_IL_BUS_COVER getPM_IL_BUS_COVER_BEAN() {
		return PM_IL_BUS_COVER_BEAN;
	}
	public void setPM_IL_BUS_COVER_BEAN(PM_IL_BUS_COVER pM_IL_BUS_COVER_BEAN) {
		PM_IL_BUS_COVER_BEAN = pM_IL_BUS_COVER_BEAN;
	}
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	} 
	
	private List<PM_IL_BUS_COVER> dataList_BRCS_COVER_CODE = new ArrayList<PM_IL_BUS_COVER>();
	public List<PM_IL_BUS_COVER> getDataList_BRCS_COVER_CODE() {
		return dataList_BRCS_COVER_CODE;
	}
	public void setDataList_BRCS_COVER_CODE(
			List<PM_IL_BUS_COVER> dataList_BRCS_COVER_CODE) {
		this.dataList_BRCS_COVER_CODE = dataList_BRCS_COVER_CODE;
	}
	
	public PM_IL_BUS_COVER_ACTION()
	{
		

		PM_IL_BUS_COVER_BEAN = new PM_IL_BUS_COVER();
	
		helper= new PM_IL_BUS_COVER_HELPER();
		delegate = new PM_IL_BUS_COVER_DELEGATE();
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			
			if (isBlockFlag()) {
				System.out.println("Enter into Applicable onload");
				helper.executeQuery(compositeAction);
				//helper.postQuery(PM_IL_BUS_COVER_BEAN);
				System.out.println("dataList_PP_LIFE_POL_SCH_PRN     "+getDataList_BRCS_COVER_CODE());
				if(PM_IL_BUS_COVER_BEAN.getROWID() != null){
					//helper.whenCreateRecord(compositeAction);
				}
				
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			System.out.println("indide of displayRecords++++++++++++++");
			
			resetSelectedRow();
		
			PM_IL_BUS_COVER_BEAN = (PM_IL_BUS_COVER) dataTable.getRowData();
			PM_IL_BUS_COVER_BEAN.setRowSelected(true);
			//helper.postQuery(PM_IL_BUS_COVER_BEAN);
			System.out.println("getBRD1_TAB_NAME        "+PM_IL_BUS_COVER_BEAN.getBRCS_COVER_CODE());
			resetAllComponent();
			
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}
	private void resetSelectedRow() {
		System.out.println("indide of resetSelectedRow++++++++++++++");
		
		Iterator<PM_IL_BUS_COVER> PM_IL_COVER_ITR = dataList_BRCS_COVER_CODE.iterator();
		while (PM_IL_COVER_ITR.hasNext()) {
			PM_IL_COVER_ITR.next().setRowSelected(false);
		}
	}
	
	public void resetAllComponent()
	{
		COMP_BRCS_COVER_CODE.resetValue();
		COMP_BRCS_COVER_CODE_DESC.resetValue();
		
	}
	
	
	
	public ArrayList<LovBean> prepareSuggestionBRCS_COVER_CODE(Object object){
		
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		ListItemUtil itemUtil = new ListItemUtil();
		String currentValue = (String) object;
		String moduleName = "PILM086_APAC";
		String blockName = "PM_BUS_RULE_COVER_SETUP";
		String fieldName = "BRCS_COVER_CODE";
		

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			lovList = itemUtil.P_CALL_LOV(moduleName, blockName, fieldName,null, 

null,
					null, null, null, currentValue);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	
	 public void validatorBRCS_COVER_CODE(FacesContext context,
				UIComponent component, Object value) {
			try {
				PM_IL_BUS_COVER_BEAN.setBRCS_COVER_CODE((String) value);
				helper.BRCS_COVER_CODE_WHEN_VALIDATE_ITEM(PM_IL_BUS_COVER_BEAN);
				COMP_BRCS_COVER_CODE_DESC.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	
	
	 
	 
	 public void addRow(ActionEvent event) {
			try {
				if (isINSERT_ALLOWED()) {
					
					System.out.println("insert add row");

					PM_IL_BUS_COVER_BEAN = new PM_IL_BUS_COVER();
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
				System.out.println("insert delete rew");
				
				if (isDELETE_ALLOWED()) {

					new CRUDHandler().executeDelete(PM_IL_BUS_COVER_BEAN,
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
					dataList_BRCS_COVER_CODE.remove(PM_IL_BUS_COVER_BEAN);
					if (dataList_BRCS_COVER_CODE.size() > 0) {

						PM_IL_BUS_COVER_BEAN = dataList_BRCS_COVER_CODE.get(0);
					} else if (dataList_BRCS_COVER_CODE.size() == 0) {

						addRow(null);
					}

					resetAllComponent();
					PM_IL_BUS_COVER_BEAN.setRowSelected(true);
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
	    	getErrorMap().clear();
			getWarningMap().clear();
		try {
			if (PM_IL_BUS_COVER_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.preInsert(PM_IL_COLUMN_BEAN, compositeAction);
				String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
				ResultSet rs = null;
				if (getErrorMap().size() == 0) {
					rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
					if (rs.next()) {
						PM_IL_BUS_COVER_BEAN.setBRCS_SYS_ID(rs.getLong(1));
						
					}
				}
				PM_IL_BUS_COVER_BEAN.setBRCS_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
				
				PM_IL_BUS_COVER_BEAN.setBRCS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				
				System.out.println("M_USER_ID"+CommonUtils.getControlBean().getM_USER_ID());
				PM_IL_BUS_COVER_BEAN.setBRCS_CR_DT(new CommonUtils().getCurrentDate());
				System.out.println("BRD3_CR_DT"+new CommonUtils().getCurrentDate());
				
				
				new CRUDHandler().executeInsert(PM_IL_BUS_COVER_BEAN,
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
				dataList_BRCS_COVER_CODE.add(PM_IL_BUS_COVER_BEAN);
			} else if (PM_IL_BUS_COVER_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				//helper.preUpdate(compositeAction);

				/*Added by Raja on 28-4-2016 for TISB POC*/
				PM_IL_BUS_COVER_BEAN.setBRCS_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());
				/*End*/
				
				PM_IL_BUS_COVER_BEAN.setBRCS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				System.out.println("BRD3_UPD_UID"+CommonUtils.getControlBean().getM_USER_ID());
				PM_IL_BUS_COVER_BEAN.setBRCS_UPD_DT(new CommonUtils().getCurrentDate());
				
				new CRUDHandler().executeUpdate(PM_IL_BUS_COVER_BEAN,
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

			PM_IL_BUS_COVER_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			String temp=extractDBErrorMessage(exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + temp);
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + temp);
		}
	}
	
		
		public static String extractDBErrorMessage(String dbErrorMessage){
			if ((dbErrorMessage != null) ){
				if ((dbErrorMessage.indexOf(":")!=-1) && (dbErrorMessage.indexOf("ORA")!=-1)){
					int index = dbErrorMessage.indexOf(":");
					dbErrorMessage = dbErrorMessage.substring(index+1);
					dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
					return dbErrorMessage;
				}else{
					dbErrorMessage = dbErrorMessage.replaceAll("\\*~#", "<br/>");
					return dbErrorMessage;
				}
			}
			return dbErrorMessage;
		}
	 
		public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	
		
		public void saveRecord() {

			System.out.println("INSIDE saveRecord");


			String message = null;
			CommonUtils.clearMaps(this);
			//PM_IL_CURRENCY_ACTION actionBean = (PM_IL_CURRENCY_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CURRENCY_ACTION");

			try {
				if (getPM_IL_BUS_COVER_BEAN().getROWID() != null && this.isINSERT_ALLOWED() == true) {

					System.out.println("NOT isUPDATE_ALLOWED");

			
					
					new CRUDHandler().executeInsert(PM_IL_BUS_COVER_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					getWarningMap().put(
							"current",
							Messages.getString("messageProperties",
									"errorPanel$message$save"));
					getWarningMap().put(
							"save",
							Messages.getString("messageProperties",
									"errorPanel$message$save"));	


				}else
				{

					System.out.println("ROW ID !=NULL");

					System.out.println("isUPDATE_ALLOWED");
					
					new CRUDHandler().executeUpdate(PM_IL_BUS_COVER_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					getWarningMap().put(
							"current",
							Messages.getString("messageProperties",
									"errorPanel$message$update"));
					getWarningMap().put(
							"update",
							Messages.getString("messageProperties",
									"errorPanel$message$update"));
				}


			}catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
			}


		}

}
