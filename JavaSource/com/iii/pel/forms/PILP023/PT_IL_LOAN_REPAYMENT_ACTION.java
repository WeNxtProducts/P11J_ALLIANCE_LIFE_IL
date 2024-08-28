package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_REPAYMENT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_LOAN_NO_LABEL;

	private HtmlInputText COMP_UI_M_LOAN_NO;

	private HtmlOutputLabel COMP_UI_M_LOAN_DT_LABEL;

	private HtmlCalendar COMP_UI_M_LOAN_DT;

	private HtmlOutputLabel COMP_LR_PYMT_DT_LABEL;

	private HtmlCalendar COMP_LR_PYMT_DT;

	private HtmlOutputLabel COMP_LR_FC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_PYMT_AMT;

	private HtmlOutputLabel COMP_LR_LC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_PYMT_AMT;

	private HtmlOutputLabel COMP_LR_LC_LOAN_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_LOAN_AMT;

	private HtmlOutputLabel COMP_LR_FC_LOAN_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_LOAN_AMT;

	private HtmlOutputLabel COMP_LR_FC_INT_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_INT_AMT;

	private HtmlOutputLabel COMP_LR_LC_INT_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_INT_AMT;

	private HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK;

	private PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN;
	
	private HtmlAjaxCommandButton COMP_ADDROW_BUT;
	
	private HtmlAjaxCommandButton COMP_DELROW_BUT;
	
	private HtmlAjaxCommandButton COMP_POSTROW_BUT;
	
	private UIData dataTable;
	
	private ArrayList<PT_IL_LOAN_REPAYMENT> tableList; 
	
	public PILP023_COMPOSITE_ACTION compositeAction;

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList<PT_IL_LOAN_REPAYMENT> getTableList() {
		return tableList;
	}

	public void setTableList(ArrayList<PT_IL_LOAN_REPAYMENT> tableList) {
		this.tableList = tableList;
	}

	public PT_IL_LOAN_REPAYMENT_ACTION() {
		PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_NO_LABEL() {
		return COMP_UI_M_LOAN_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LOAN_NO() {
		return COMP_UI_M_LOAN_NO;
	}

	public void setCOMP_UI_M_LOAN_NO_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_NO_LABEL) {
		this.COMP_UI_M_LOAN_NO_LABEL = COMP_UI_M_LOAN_NO_LABEL;
	}

	public void setCOMP_UI_M_LOAN_NO(HtmlInputText COMP_UI_M_LOAN_NO) {
		this.COMP_UI_M_LOAN_NO = COMP_UI_M_LOAN_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_LOAN_DT_LABEL() {
		return COMP_UI_M_LOAN_DT_LABEL;
	}

	public void setCOMP_UI_M_LOAN_DT_LABEL(HtmlOutputLabel COMP_UI_M_LOAN_DT_LABEL) {
		this.COMP_UI_M_LOAN_DT_LABEL = COMP_UI_M_LOAN_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_LOAN_DT() {
		return COMP_UI_M_LOAN_DT;
	}

	public void setCOMP_UI_M_LOAN_DT(HtmlCalendar comp_ui_m_loan_dt) {
		COMP_UI_M_LOAN_DT = comp_ui_m_loan_dt;
	}

	public HtmlOutputLabel getCOMP_LR_PYMT_DT_LABEL() {
		return COMP_LR_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LR_PYMT_DT() {
		return COMP_LR_PYMT_DT;
	}

	public void setCOMP_LR_PYMT_DT_LABEL(HtmlOutputLabel COMP_LR_PYMT_DT_LABEL) {
		this.COMP_LR_PYMT_DT_LABEL = COMP_LR_PYMT_DT_LABEL;
	}

	public void setCOMP_LR_PYMT_DT(HtmlCalendar COMP_LR_PYMT_DT) {
		this.COMP_LR_PYMT_DT = COMP_LR_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_PYMT_AMT_LABEL() {
		return COMP_LR_FC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_PYMT_AMT() {
		return COMP_LR_FC_PYMT_AMT;
	}

	public void setCOMP_LR_FC_PYMT_AMT_LABEL(HtmlOutputLabel COMP_LR_FC_PYMT_AMT_LABEL) {
		this.COMP_LR_FC_PYMT_AMT_LABEL = COMP_LR_FC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LR_FC_PYMT_AMT(HtmlInputText COMP_LR_FC_PYMT_AMT) {
		this.COMP_LR_FC_PYMT_AMT = COMP_LR_FC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_PYMT_AMT_LABEL() {
		return COMP_LR_LC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_PYMT_AMT() {
		return COMP_LR_LC_PYMT_AMT;
	}

	public void setCOMP_LR_LC_PYMT_AMT_LABEL(HtmlOutputLabel COMP_LR_LC_PYMT_AMT_LABEL) {
		this.COMP_LR_LC_PYMT_AMT_LABEL = COMP_LR_LC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LR_LC_PYMT_AMT(HtmlInputText COMP_LR_LC_PYMT_AMT) {
		this.COMP_LR_LC_PYMT_AMT = COMP_LR_LC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_LOAN_AMT_LABEL() {
		return COMP_LR_LC_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_LOAN_AMT() {
		return COMP_LR_LC_LOAN_AMT;
	}

	public void setCOMP_LR_LC_LOAN_AMT_LABEL(HtmlOutputLabel COMP_LR_LC_LOAN_AMT_LABEL) {
		this.COMP_LR_LC_LOAN_AMT_LABEL = COMP_LR_LC_LOAN_AMT_LABEL;
	}

	public void setCOMP_LR_LC_LOAN_AMT(HtmlInputText COMP_LR_LC_LOAN_AMT) {
		this.COMP_LR_LC_LOAN_AMT = COMP_LR_LC_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_LOAN_AMT_LABEL() {
		return COMP_LR_FC_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_LOAN_AMT() {
		return COMP_LR_FC_LOAN_AMT;
	}

	public void setCOMP_LR_FC_LOAN_AMT_LABEL(HtmlOutputLabel COMP_LR_FC_LOAN_AMT_LABEL) {
		this.COMP_LR_FC_LOAN_AMT_LABEL = COMP_LR_FC_LOAN_AMT_LABEL;
	}

	public void setCOMP_LR_FC_LOAN_AMT(HtmlInputText COMP_LR_FC_LOAN_AMT) {
		this.COMP_LR_FC_LOAN_AMT = COMP_LR_FC_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_INT_AMT_LABEL() {
		return COMP_LR_FC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_INT_AMT() {
		return COMP_LR_FC_INT_AMT;
	}

	public void setCOMP_LR_FC_INT_AMT_LABEL(HtmlOutputLabel COMP_LR_FC_INT_AMT_LABEL) {
		this.COMP_LR_FC_INT_AMT_LABEL = COMP_LR_FC_INT_AMT_LABEL;
	}

	public void setCOMP_LR_FC_INT_AMT(HtmlInputText COMP_LR_FC_INT_AMT) {
		this.COMP_LR_FC_INT_AMT = COMP_LR_FC_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_INT_AMT_LABEL() {
		return COMP_LR_LC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_INT_AMT() {
		return COMP_LR_LC_INT_AMT;
	}

	public void setCOMP_LR_LC_INT_AMT_LABEL(HtmlOutputLabel COMP_LR_LC_INT_AMT_LABEL) {
		this.COMP_LR_LC_INT_AMT_LABEL = COMP_LR_LC_INT_AMT_LABEL;
	}

	public void setCOMP_LR_LC_INT_AMT(HtmlInputText COMP_LR_LC_INT_AMT) {
		this.COMP_LR_LC_INT_AMT = COMP_LR_LC_INT_AMT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK() {
		return COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK;
	}

	public void setCOMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK(HtmlCommandButton COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK) {
		this.COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK = COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK;
	}

	public PT_IL_LOAN_REPAYMENT getPT_IL_LOAN_REPAYMENT_BEAN() {
		return PT_IL_LOAN_REPAYMENT_BEAN;
	}

	public void setPT_IL_LOAN_REPAYMENT_BEAN(PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN) {
		this.PT_IL_LOAN_REPAYMENT_BEAN = PT_IL_LOAN_REPAYMENT_BEAN;
	}
	
	public void loanQuery()
	{
		PILP023_COMPOSITE_ACTION compositeAction = (PILP023_COMPOSITE_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILP023_COMPOSITE_ACTION");
		PT_IL_CHEQUE_BOUNCE_HDR chequeBounceBean = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
//		PT_IL_LOAN_REPAYMENT loanBean = compositeAction.getPILP023_PT_IL_LOAN_REPAYMENT_ACTION().getPT_IL_LOAN_REPAYMENT_BEAN();
//		List<PT_IL_LOAN_REPAYMENT> loanList = compositeAction.getPILP023_PT_IL_LOAN_REPAYMENT_ACTION().getTableList();
		ArrayList<PT_IL_LOAN_REPAYMENT> loanList = null;
		Double CBH_LR_SYS_ID=chequeBounceBean.getCBH_LR_SYS_ID();
		
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
//		:PT_IL_CHEQUE_BOUNCE_HDR.CBH_LR_SYS_ID
		String query = "SELECT LR_PYMT_DT,LR_FC_PYMT_AMT,LR_LC_PYMT_AMT,LR_LC_LOAN_AMT," +
							"LR_FC_LOAN_AMT,LR_FC_INT_AMT,LR_LC_INT_AMT FROM PT_IL_LOAN_REPAYMENT " +
								"WHERE LR_SYS_ID LIKE NVL(?,0)";
		if(CBH_LR_SYS_ID != null){
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{CBH_LR_SYS_ID});
			loanList = new ArrayList<PT_IL_LOAN_REPAYMENT>();
			while(rst.next())
			{
				PT_IL_LOAN_REPAYMENT loanBean = new PT_IL_LOAN_REPAYMENT();
				loanBean.setLR_PYMT_DT(rst.getDate("LR_PYMT_DT"));
				loanBean.setLR_FC_PYMT_AMT(rst.getDouble("LR_FC_PYMT_AMT"));
				loanBean.setLR_LC_PYMT_AMT(rst.getDouble("LR_LC_PYMT_AMT"));
				loanBean.setLR_LC_LOAN_AMT(rst.getDouble("LR_LC_LOAN_AMT"));
				loanBean.setLR_FC_LOAN_AMT(rst.getDouble("LR_FC_LOAN_AMT"));
				loanBean.setLR_FC_INT_AMT(rst.getDouble("LR_FC_INT_AMT"));
				loanBean.setLR_LC_INT_AMT(rst.getDouble("LR_LC_INT_AMT"));
				loanList.add(loanBean);
			}
			setTableList(loanList);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}	
		}
	}
	
	public void postQuery(PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN){
		 
		  Connection connection = null;
			CRUDHandler handler = null;
			String C1 = "SELECT LOAN_POL_NO,LOAN_DT  FROM   PT_IL_LOAN  WHERE  LOAN_SYS_ID";
			ResultSet C1_REC = null;
			try{
				handler = new CRUDHandler();
				connection = CommonUtils.getConnection();
				C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_LOAN_REPAYMENT_BEAN.getLR_LOAN_SYS_ID()});
				if(C1_REC.next()){
					PT_IL_LOAN_REPAYMENT_BEAN.setUI_M_LOAN_NO(C1_REC.getString(1));
					PT_IL_LOAN_REPAYMENT_BEAN.setUI_M_LOAN_DT(C1_REC.getDate(2));
				}
				
			}catch(Exception exception){
				exception.getMessage();
			}finally{
				try {
					CommonUtils.closeCursor(C1_REC);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	/**
	 * 
	 * @param PT_IL_CHEQUE_BOUNCE_HDR_BEAN
	 */
	public void whenNewBlockInstance(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN){
		String where = " LR_SYS_ID = '"+CommonUtils.nvl(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_LR_SYS_ID(),0)+"'";
		CommonUtils.setGlobalVariable("REPAYMENT_WHERE", where);
	}
	
	/**
	 * 
	 * @param e
	 */
	public void onLoad(PhaseEvent e) {
		try {
			
			if (isFormFlag()) {
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				whenNewBlockInstance(compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN());
				executeQuery();
				if (PT_IL_LOAN_REPAYMENT_BEAN.getROWID() != null) {
					postQuery(PT_IL_LOAN_REPAYMENT_BEAN);
				}
				setBlockFlag(false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					ex.getMessage());
			getErrorMap().put("onLoad", ex.getMessage());
		}
		// PT_IL_DEPOSIT_BEAN.setApprovalStatus(true);
	}
	
	public String loanRepay()
	{
		setTableList(null);
		return "loanDetails";
	}
	
	/**
	 * 
	 */
	public void executeQuery(){
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		String WHERE_CONDITION = CommonUtils.getGlobalVariable("REPAYMENT_WHERE");
		String query = "SELECT * FROM PT_IL_LOAN_REPAYMENT WHERE "+WHERE_CONDITION;
		try{
			tableList = new ArrayList<PT_IL_LOAN_REPAYMENT>();
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(query, connection);
			if(C1_REC.next()){
				PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_LOAN_SYS_ID(C1_REC.getLong("LR_LOAN_SYS_ID"));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_PYMT_DT(C1_REC.getDate("LR_PYMT_DT"));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_PYMT_AMT(C1_REC.getDouble("LR_FC_PYMT_AMT"));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_LC_PYMT_AMT(C1_REC.getDouble("LR_LC_PYMT_AMT"));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_LC_LOAN_AMT(C1_REC.getDouble("LR_LC_LOAN_AMT"));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_LOAN_AMT(C1_REC.getDouble("LR_FC_LOAN_AMT"));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_INT_AMT(C1_REC.getDouble("LR_FC_INT_AMT"));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_LC_INT_AMT(C1_REC.getDouble("LR_LC_INT_AMT"));
				PT_IL_LOAN_REPAYMENT_BEAN.setUI_M_LOAN_NO("");
				tableList.add(PT_IL_LOAN_REPAYMENT_BEAN);
			}
			
			if(tableList!=null && !tableList.isEmpty()){
				PT_IL_LOAN_REPAYMENT pt_il_loan_repayment = tableList.get(0);
				pt_il_loan_repayment.setRowSelected(true);
				setPT_IL_LOAN_REPAYMENT_BEAN(pt_il_loan_repayment);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	/**
	 * Instantiates all components in PT_IL_LOAN_REPAYMENT_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_LOAN_NO				 = new HtmlInputText();
		COMP_LR_FC_PYMT_AMT				 = new HtmlInputText();
		COMP_LR_LC_PYMT_AMT				 = new HtmlInputText();
		COMP_LR_LC_LOAN_AMT				 = new HtmlInputText();
		COMP_LR_FC_LOAN_AMT				 = new HtmlInputText();
		COMP_LR_FC_INT_AMT				 = new HtmlInputText();
		COMP_LR_LC_INT_AMT				 = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_UI_M_LOAN_DT				 = new HtmlCalendar();
		COMP_LR_PYMT_DT					 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK		 = new HtmlCommandButton();

	}


	/**
	 * Resets all components in PT_IL_LOAN_REPAYMENT_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_UI_M_LOAN_NO.resetValue();
		COMP_LR_FC_PYMT_AMT.resetValue();
		COMP_LR_LC_PYMT_AMT.resetValue();
		COMP_LR_LC_LOAN_AMT.resetValue();
		COMP_LR_FC_LOAN_AMT.resetValue();
		COMP_LR_FC_INT_AMT.resetValue();
		COMP_LR_LC_INT_AMT.resetValue();

		// Reseting HtmlCalendar
		COMP_UI_M_LOAN_DT.resetValue();
		COMP_LR_PYMT_DT.resetValue();

		// Reseting HtmlCommandButton
		//COMP_UI_M_BUT_LOAN_REPAY_DTLS_BACK.resetValue();

	}

	public void addRow() {
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			if (isINSERT_ALLOWED()) {
				
				PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
				//this logic is to make cover code as non-updatable filed
				//but we can insert a record.
				
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

	public void deleteRow() {
		try {
			if (isDELETE_ALLOWED()) {
				new CRUDHandler().executeDelete(PT_IL_LOAN_REPAYMENT_BEAN,
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
				tableList.remove(PT_IL_LOAN_REPAYMENT_BEAN);
				if (tableList.size() > 0) {

					PT_IL_LOAN_REPAYMENT_BEAN = tableList
							.get(0);
				} else if (tableList.size() == 0) {

					addRow();
				}

				resetAllComponent();
				PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
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
	
	public void saveRecord() {
		try {

			String message = null;
			if (isINSERT_ALLOWED()) {
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties",
						"errorPanel$message$save");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("SAVE", message);
			} else {
				CommonUtils.getConnection().commit();
				message = Messages.getString("messageProperties",
						"errorPanel$message$update");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("UPDATE", message);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void postRecord() {
		try {
			if (PT_IL_LOAN_REPAYMENT_BEAN.getROWID() == null){
					if(isINSERT_ALLOWED()) {
					new CRUDHandler().executeInsert(PT_IL_LOAN_REPAYMENT_BEAN,
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
				tableList.add(PT_IL_LOAN_REPAYMENT_BEAN);
					}else {
						throw new Exception(Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
					}
					
			} else if (PT_IL_LOAN_REPAYMENT_BEAN.getROWID() != null){
					if(isUPDATE_ALLOWED()) {
					
				new CRUDHandler().executeUpdate(PT_IL_LOAN_REPAYMENT_BEAN,
						CommonUtils.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$Grid$update"));
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$updatenotallowed"));
			}
			}
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
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
			PT_IL_LOAN_REPAYMENT_BEAN = (PT_IL_LOAN_REPAYMENT) dataTable
					.getRowData();
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetSelectedRow() {
		Iterator<PT_IL_LOAN_REPAYMENT> PT_GL_POL_EMP_COVER_ITR = tableList
				.iterator();
		while (PT_GL_POL_EMP_COVER_ITR.hasNext()) {
			PT_GL_POL_EMP_COVER_ITR.next().setRowSelected(false);
		}
	}

	public HtmlAjaxCommandButton getCOMP_ADDROW_BUT() {
		return COMP_ADDROW_BUT;
	}

	public void setCOMP_ADDROW_BUT(HtmlAjaxCommandButton comp_addrow_but) {
		COMP_ADDROW_BUT = comp_addrow_but;
	}

	public HtmlAjaxCommandButton getCOMP_DELROW_BUT() {
		return COMP_DELROW_BUT;
	}

	public void setCOMP_DELROW_BUT(HtmlAjaxCommandButton comp_delrow_but) {
		COMP_DELROW_BUT = comp_delrow_but;
	}

	public HtmlAjaxCommandButton getCOMP_POSTROW_BUT() {
		return COMP_POSTROW_BUT;
	}

	public void setCOMP_POSTROW_BUT(HtmlAjaxCommandButton comp_postrow_but) {
		COMP_POSTROW_BUT = comp_postrow_but;
	}

	
}
