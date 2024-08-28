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
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.Column;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.pel.forms.PILM003_APAC.PILM003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILM003_APAC.PM_IL_PLAN_MOP;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILM086_APP_CUST_ACTION extends CommonAction{
	
	

	public PILM086_APAC_COMPOSITE_ACTION compositeAction;	
	public PILM086_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}
	public void setCompositeAction(PILM086_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}
	
	
	private PILM086_APAC_BEAN PILM086_BEAN;
	public PILM086_APAC_BEAN getPILM086_BEAN() {
		return PILM086_BEAN;
	}
	public void setPILM086_BEAN(PILM086_APAC_BEAN pILM086_BEAN) {
		PILM086_BEAN = pILM086_BEAN;
	}

	
	//agal
	private List<PILM086_APAC_APP_CUS_BEAN> dataList_PP_LIFE_POL_SCH_PRN = new ArrayList<PILM086_APAC_APP_CUS_BEAN>();
	public List<PILM086_APAC_APP_CUS_BEAN> getDataList_PP_LIFE_POL_SCH_PRN() {
		return dataList_PP_LIFE_POL_SCH_PRN;
	}
	public void setDataList_PP_LIFE_POL_SCH_PRN(
			List<PILM086_APAC_APP_CUS_BEAN> dataList_PP_LIFE_POL_SCH_PRN) {
		this.dataList_PP_LIFE_POL_SCH_PRN = dataList_PP_LIFE_POL_SCH_PRN;
	}



	

	
	
	
	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	private UIData dataTable;
	
	public PILM086_APAC_APP_CUS_BEAN getPILM086_APAC_APP_BEAN() {
		return PILM086_APAC_APP_BEAN;
	}
	public void setPILM086_APAC_APP_BEAN(
			PILM086_APAC_APP_CUS_BEAN pILM086_APAC_APP_BEAN) {
		PILM086_APAC_APP_BEAN = pILM086_APAC_APP_BEAN;
	}

//my bean class
	
	private PILM086_APAC_APP_CUS_BEAN PILM086_APAC_APP_BEAN;
	
	
	private PILM086_APP_CUST_HELPER helper;
	
	public HtmlOutputLabel getCOMP_BRAC_CUST_CLASS_LABEL() {
		return COMP_BRAC_CUST_CLASS_LABEL;
	}
	public void setCOMP_BRAC_CUST_CLASS_LABEL(
			HtmlOutputLabel cOMP_BRAC_CUST_CLASS_LABEL) {
		COMP_BRAC_CUST_CLASS_LABEL = cOMP_BRAC_CUST_CLASS_LABEL;
	}
	public HtmlInputText getCOMP_BRAC_CUST_CLASS() {
		return COMP_BRAC_CUST_CLASS;
	}
	public void setCOMP_BRAC_CUST_CLASS(HtmlInputText cOMP_BRAC_CUST_CLASS) {
		COMP_BRAC_CUST_CLASS = cOMP_BRAC_CUST_CLASS;
	}


	private HtmlOutputLabel COMP_BRAC_CUST_CLASS_LABEL;

	private HtmlInputText COMP_BRAC_CUST_CLASS;
	
	
	
	
	public static StringBuffer sb=new StringBuffer(); 
	
	
	
	private HtmlOutputLabel COMP_BRAC_CUST_CLASS_DESC_LABEL;

	private HtmlInputText COMP_BRAC_CUST_CLASS_DESC;
	
	
	private PILM086_APAC_SQL_BEAN PILM086_APAC_SQL_BEAN_OBJ;
	
	public PILM086_APP_CUST_HELPER getHelper() {
		return helper;
	}
	public void setHelper(PILM086_APP_CUST_HELPER helper) {
		this.helper = helper;
	}
	public static StringBuffer getSb() {
		return sb;
	}
	public static void setSb(StringBuffer sb) {
		PILM086_APP_CUST_ACTION.sb = sb;
	}
	public HtmlOutputLabel getCOMP_BRAC_CUST_CLASS_DESC_LABEL() {
		return COMP_BRAC_CUST_CLASS_DESC_LABEL;
	}
	public void setCOMP_BRAC_CUST_CLASS_DESC_LABEL(
			HtmlOutputLabel cOMP_BRAC_CUST_CLASS_DESC_LABEL) {
		COMP_BRAC_CUST_CLASS_DESC_LABEL = cOMP_BRAC_CUST_CLASS_DESC_LABEL;
	}
	public HtmlInputText getCOMP_BRAC_CUST_CLASS_DESC() {
		return COMP_BRAC_CUST_CLASS_DESC;
	}
	public void setCOMP_BRAC_CUST_CLASS_DESC(HtmlInputText cOMP_BRAC_CUST_CLASS_DESC) {
		COMP_BRAC_CUST_CLASS_DESC = cOMP_BRAC_CUST_CLASS_DESC;
	}
	public PILM086_APAC_SQL_BEAN getPILM086_APAC_SQL_BEAN_OBJ() {
		return PILM086_APAC_SQL_BEAN_OBJ;
	}
	public void setPILM086_APAC_SQL_BEAN_OBJ(
			PILM086_APAC_SQL_BEAN pILM086_APAC_SQL_BEAN_OBJ) {
		PILM086_APAC_SQL_BEAN_OBJ = pILM086_APAC_SQL_BEAN_OBJ;
	}
	//end
	public PILM086_APP_CUST_ACTION()
	{
		

		PILM086_BEAN = new PILM086_APAC_BEAN();
		PILM086_APAC_APP_BEAN = new PILM086_APAC_APP_CUS_BEAN();
		helper= new PILM086_APP_CUST_HELPER();
		PILM086_APAC_SQL_BEAN_OBJ = new PILM086_APAC_SQL_BEAN();
	}
	
	
	
	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	 
	 
	
	 public void onLoad(PhaseEvent event) {
			try {
				
				if (isBlockFlag()) {
					System.out.println("Enter into Applicable onload");
					helper.executeQuery(compositeAction);
					System.out.println("dataList_PP_LIFE_POL_SCH_PRN     "+getDataList_PP_LIFE_POL_SCH_PRN());
					if(PILM086_APAC_APP_BEAN.getROWID() != null){
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
	

	 
	 public void saveRecord() {

			System.out.println("INSIDE saveRecord");


			String message = null;
			CommonUtils.clearMaps(this);
			//PM_IL_CURRENCY_ACTION actionBean = (PM_IL_CURRENCY_ACTION) new CommonUtils().getMappedBeanFromSession("PM_IL_CURRENCY_ACTION");

			try {
				if (getPILM086_APAC_APP_BEAN().getROWID() == null && this.isINSERT_ALLOWED() == true) {

					System.out.println("NOT isUPDATE_ALLOWED");
					
					//	helper.preInsert(compositeAction);

					/*( PM_IL_COLUMN_BEAN).setCURR_CR_UID(CommonUtils.getControlBean().getUSER_ID());
					PM_IL_COLUMN_BEAN.setCURR_CR_DT(new CommonUtils().getCurrentDate());
		*/

				
					
					new CRUDHandler().executeInsert(PILM086_APAC_APP_BEAN,
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
					//	helper.PRE_UPDATE(compositeAction);

				/*	PM_CURRENCY_BEAN.setCURR_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
					PM_CURRENCY_BEAN.setCURR_UPD_DT(new CommonUtils().getCurrentDate());*/

					new CRUDHandler().executeUpdate(PILM086_APAC_APP_BEAN,
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
	 
	
	 
	 public void displayRecords() {
			CommonUtils.clearMaps(this);
			try {
				
				System.out.println("inside display record");
				
				
				resetSelectedRow();
				PILM086_APAC_APP_BEAN = (PILM086_APAC_APP_CUS_BEAN) dataTable
						.getRowData();
				PILM086_APAC_APP_BEAN.setRowSelected(true);
				resetAllComponent();
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
				getErrorMap().put("displayRecords", exc.getMessage());
			}

		}
	 
	 
	 private void resetSelectedRow() {
			Iterator<PILM086_APAC_APP_CUS_BEAN> PP_LIFE_POL_SCH_PRN_ITR = dataList_PP_LIFE_POL_SCH_PRN.
					iterator();
			while (PP_LIFE_POL_SCH_PRN_ITR.hasNext()) {
				PP_LIFE_POL_SCH_PRN_ITR.next().setRowSelected(false);
			}
		}
		
	 
	 public void validatorBRAC_CUST_CLASS(FacesContext context,
				UIComponent component, Object value) {
			try {
				PILM086_APAC_APP_BEAN.setBRAC_CUST_CLASS((String) value);
				helper.PBEN_RELATION_CODE_WHEN_VALIDATE_ITEM(PILM086_APAC_APP_BEAN);
				COMP_BRAC_CUST_CLASS_DESC.resetValue();
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}

	 
	 public void resetAllComponent() {
		 COMP_BRAC_CUST_CLASS.resetValue();
		 COMP_BRAC_CUST_CLASS_DESC.resetValue();
		 
	 }
	 
		public void fireFieldValidation(ActionEvent actionEvent) {
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		}
	 
		
		
		public ArrayList<LovBean> prepareSuggestionBRAC_CUST_CLASS(Object object){
			
			ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			ListItemUtil itemUtil = new ListItemUtil();
			String currentValue = (String) object;
			String moduleName = "PILM086_APAC";
			String blockName = "PM_BUS_RULE_APPL_CUST";
			String fieldName = "BRAC_CUST_CLASS";
			

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
		
		
	 
	 public void addRow(ActionEvent event) {
			try {
				if (isINSERT_ALLOWED()) {

					PILM086_APAC_APP_BEAN = new PILM086_APAC_APP_CUS_BEAN();
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
				getErrorMap().clear();
				getWarningMap().clear();

				if (isDELETE_ALLOWED()) {
					if (PILM086_APAC_APP_BEAN.getROWID() != null) {
						new CRUDHandler().executeDelete(PILM086_APAC_APP_BEAN,
								CommonUtils.getConnection());
						dataList_PP_LIFE_POL_SCH_PRN
								.remove(PILM086_APAC_APP_BEAN);
					}

					if (dataList_PP_LIFE_POL_SCH_PRN.size() > 0) {
						setPILM086_APAC_APP_BEAN(dataList_PP_LIFE_POL_SCH_PRN
								.get(0));
						//PILM086_APAC_APP_BEAN.setRowSelected(true);
					}

					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$delete"));
					getWarningMap().put(
							"deleteRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$delete"));
					resetAllComponent();

				} else {
					getErrorMap().clear();
					getErrorMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$deletenotallowed"));
					getErrorMap().put(
							"deleteRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$deletenotallowed"));
				}

			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("deleteRow", e.getMessage());
			}
		}
	 

	 //new
	 
	 
	 public void postRecord(ActionEvent event) {
	    	getErrorMap().clear();
			getWarningMap().clear();
		try {
			if (PILM086_APAC_APP_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				
				
				String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
				ResultSet rs = null;
				if (getErrorMap().size() == 0) {
					rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
					if (rs.next()) {
						PILM086_APAC_APP_BEAN.setBRAC_SYS_ID(rs.getLong(1));
				
						
					}
				}
				
				PILM086_APAC_APP_BEAN.setBRAC_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());	
				
				//helper.preInsert(PM_IL_COLUMN_BEAN, compositeAction);
				new CRUDHandler().executeInsert(PILM086_APAC_APP_BEAN,
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
				dataList_PP_LIFE_POL_SCH_PRN.add(PILM086_APAC_APP_BEAN);
			} else if (PILM086_APAC_APP_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				//helper.preUpdate(compositeAction);
				/*Added by Raja on 28-4-2016 for TISB POC*/
				PILM086_APAC_APP_BEAN.setBRAC_BRH_SYS_ID(compositeAction.getPILM086_ACTION_BEAN().getPILM086_BEAN().getBRH_SYS_ID());	
				/*End*/
				new CRUDHandler().executeUpdate(PILM086_APAC_APP_BEAN,
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

			PILM086_APAC_APP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
		/*	String temp=extractDBErrorMessage(exc.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + temp);
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + temp);*/
			
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("post", exc.getMessage());
		}
	}
	 
	
	
	
		
		
		 public void  addcontent(ActionEvent actionEvent){
				System.out.println("i am here");
				 sb.delete(0, sb.length());
				UIInput input = (UIInput) actionEvent.getComponent().getParent();
				System.out.println((String)input.getSubmittedValue());
				sb.append((String)input.getSubmittedValue());
				PILM086_APAC_SQL_BEAN_OBJ.setBRH_WHERE_CLAUSE(sb.toString());
			}
		
		 
	 
}
