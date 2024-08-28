package com.iii.pel.forms.PILM086_APAC;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM086_APAC_SQLSCRIPT_ACTION extends CommonAction {
public PILM086_APAC_COMPOSITE_ACTION compositeAction;

		public PILM086_APAC_COMPOSITE_ACTION getCompositeAction() {
	return compositeAction;
}


public void setCompositeAction(PILM086_APAC_COMPOSITE_ACTION compositeAction) {
	this.compositeAction = compositeAction;
}


	private PILM086_APAC_SQL_HELPER helper;
	private PILM086_APAC_SQL_BEAN APAC_SQL_BEAN;

	public PILM086_APAC_SQL_BEAN getAPAC_SQL_BEAN() {
		return APAC_SQL_BEAN;
	}


	public void setAPAC_SQL_BEAN(PILM086_APAC_SQL_BEAN aPAC_SQL_BEAN) {
		APAC_SQL_BEAN = aPAC_SQL_BEAN;
	}

	

	public UIData getDataTable() {
		return dataTable;
	}
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	private UIData dataTable;

	public PILM086_APAC_SQLSCRIPT_ACTION()
	{ 
		
		APAC_SQL_BEAN= new PILM086_APAC_SQL_BEAN();
		
		helper= new PILM086_APAC_SQL_HELPER();
		
	}
	
	 

		private List<PILM086_APAC_SQL_BEAN> dataList_PILM086_APAC_SQL_BEAN = new ArrayList<PILM086_APAC_SQL_BEAN>();
		
	 
		
		

		public List<PILM086_APAC_SQL_BEAN> getDataList_PILM086_APAC_SQL_BEAN() {
			return dataList_PILM086_APAC_SQL_BEAN;
		}


		public void setDataList_PILM086_APAC_SQL_BEAN(
				List<PILM086_APAC_SQL_BEAN> dataList_PILM086_APAC_SQL_BEAN) {
			this.dataList_PILM086_APAC_SQL_BEAN = dataList_PILM086_APAC_SQL_BEAN;
		}


		public HtmlInputTextarea getCOMP_BRH_WHERE_CLAUSE() {
			return COMP_BRH_WHERE_CLAUSE;
		}


		public void setCOMP_BRH_WHERE_CLAUSE(HtmlInputTextarea cOMP_BRH_WHERE_CLAUSE) {
			COMP_BRH_WHERE_CLAUSE = cOMP_BRH_WHERE_CLAUSE;
		}


		private HtmlInputTextarea COMP_BRH_WHERE_CLAUSE;
		
	
	 public void onload(PhaseEvent event) {
			try {
				
				if (isBlockFlag()) {
					System.out.println("Enter into Applicable onload");
					helper.executeQuery(compositeAction);
					System.out.println("dataList_PP_LIFE_POL_SCH_PRN     "+getDataList_PILM086_APAC_SQL_BEAN());
					if(APAC_SQL_BEAN.getROWID() == null){
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
	 
	 public void deleteRow(ActionEvent event) {

			try {
				getErrorMap().clear();
				getWarningMap().clear();

				if (isDELETE_ALLOWED()) {
					if (APAC_SQL_BEAN.getROWID() != null) {
						new CRUDHandler().executeDelete(APAC_SQL_BEAN,
								CommonUtils.getConnection());
						dataList_PILM086_APAC_SQL_BEAN
								.remove(APAC_SQL_BEAN);
					}

					if (dataList_PILM086_APAC_SQL_BEAN.size() > 0) {
						setAPAC_SQL_BEAN(dataList_PILM086_APAC_SQL_BEAN
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

	 private void resetSelectedRow() {
			Iterator<PILM086_APAC_SQL_BEAN> PILM086_APAC_SQL_BEAN_ITR = dataList_PILM086_APAC_SQL_BEAN.
					iterator();
			while (PILM086_APAC_SQL_BEAN_ITR.hasNext()) {
				PILM086_APAC_SQL_BEAN_ITR.next().setRowSelected(false);
			}
		}
	 
	 public void resetAllComponent() {
		
		 COMP_BRH_WHERE_CLAUSE.resetValue();
	 }
	 
	 
	 public void displayRecords() {
			CommonUtils.clearMaps(this);
			try {
				resetSelectedRow();
				APAC_SQL_BEAN = (PILM086_APAC_SQL_BEAN) dataTable
						.getRowData();
				//PILM086_APAC_APP_BEAN.setRowSelected(true);
				resetAllComponent();
			} catch (Exception exc) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						exc.getMessage());
				getErrorMap().put("displayRecords", exc.getMessage());
			}

		}
	 
	 
	 
	 public void addRow(ActionEvent event) {
			try {
				if (isINSERT_ALLOWED()) {

					APAC_SQL_BEAN = new PILM086_APAC_SQL_BEAN();
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
				if (getAPAC_SQL_BEAN().getROWID() == null && this.isINSERT_ALLOWED() == true) {

					System.out.println("NOT isUPDATE_ALLOWED");
					
					//	helper.preInsert(compositeAction);

					/*( PM_IL_COLUMN_BEAN).setCURR_CR_UID(CommonUtils.getControlBean().getUSER_ID());
					PM_IL_COLUMN_BEAN.setCURR_CR_DT(new CommonUtils().getCurrentDate());
		*/

					String qry = "SELECT PM_RBH_SYS_ID.NEXTVAL FROM DUAL";
					ResultSet rs = null;
					if (getErrorMap().size() == 0) {
						rs = new CRUDHandler().executeSelectStatement(qry, CommonUtils.getConnection());
						if (rs.next()) {
							APAC_SQL_BEAN.setBRH_SYS_ID(rs.getString(1));
						}
					}

					
					new CRUDHandler().executeInsert(APAC_SQL_BEAN,
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

					new CRUDHandler().executeUpdate(APAC_SQL_BEAN,
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
	
	
	 public void postRecord(ActionEvent event) {
	    	getErrorMap().clear();
			getWarningMap().clear();
		try {
			if (APAC_SQL_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				//helper.preInsert(PM_IL_COLUMN_BEAN, compositeAction);
				new CRUDHandler().executeInsert(APAC_SQL_BEAN,
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
				dataList_PILM086_APAC_SQL_BEAN.add(APAC_SQL_BEAN);
			} else if (APAC_SQL_BEAN.getROWID() != null
					&& isUPDATE_ALLOWED()) {
				//helper.preUpdate(compositeAction);
				new CRUDHandler().executeUpdate(APAC_SQL_BEAN,
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

			APAC_SQL_BEAN.setRowSelected(true);
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
	 
	
}
