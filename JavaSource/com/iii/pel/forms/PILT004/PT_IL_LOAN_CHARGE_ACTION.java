package com.iii.pel.forms.PILT004;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_LOAN_CHARGE_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_LC_CHRG_CODE_LABEL;

	private HtmlInputText COMP_LC_CHRG_CODE;

	private HtmlOutputLabel COMP_LC_PERC_LABEL;

	private HtmlInputText COMP_LC_PERC;

	private HtmlOutputLabel COMP_UI_M_LC_CHARGE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_LC_CHARGE_DESC;

	private HtmlOutputLabel COMP_LC_FC_VALUE_LABEL;

	private HtmlInputText COMP_LC_FC_VALUE;

	private HtmlOutputLabel COMP_LC_LC_VALUE_LABEL;

	private HtmlInputText COMP_LC_LC_VALUE;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_CHARGE;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_CHRG;

	private PT_IL_LOAN_CHARGE PT_IL_LOAN_CHARGE_BEAN;

	private List<PT_IL_LOAN_CHARGE> chargeDetailList ;

	private UIDataTable chargeTable;

	private int currPage;

	private int recordsPerPage = 5;

	private int lastUpdatedRowIndex;

	private int prevRowIndex;

	private String currentMode;

	private boolean insertAllowed;

	private boolean updateAllowed;

	private boolean deleteAllowed;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	
	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private String filterByLC_CHRG_CODE;
	
	private String filterByLC_LC_VALUE;
	
	/*Added by Daisy for Loan Disbursal on 11/01/2019*/
	private String filterByUI_M_LC_CHARGE_DESC;
	
	public String getFilterByUI_M_LC_CHARGE_DESC() {
		return filterByUI_M_LC_CHARGE_DESC;
	}

	public void setFilterByUI_M_LC_CHARGE_DESC(String filterByUI_M_LC_CHARGE_DESC) {
		this.filterByUI_M_LC_CHARGE_DESC = filterByUI_M_LC_CHARGE_DESC;
	}
    /*End*/
	
	CommonUtils commonUtils =new CommonUtils() ;
	
	
	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @return the filterByLC_CHRG_CODE
	 */
	public String getFilterByLC_CHRG_CODE() {
		return filterByLC_CHRG_CODE;
	}

	/**
	 * @param filterByLC_CHRG_CODE the filterByLC_CHRG_CODE to set
	 */
	public void setFilterByLC_CHRG_CODE(String filterByLC_CHRG_CODE) {
		this.filterByLC_CHRG_CODE = filterByLC_CHRG_CODE;
	}

	/**
	 * @return the filterByLC_LC_VALUE
	 */
	public String getFilterByLC_LC_VALUE() {
		return filterByLC_LC_VALUE;
	}

	/**
	 * @param filterByLC_LC_VALUE the filterByLC_LC_VALUE to set
	 */
	public void setFilterByLC_LC_VALUE(String filterByLC_LC_VALUE) {
		this.filterByLC_LC_VALUE = filterByLC_LC_VALUE;
	}

	public UIDataTable getChargeTable() {
		return chargeTable;
	}

	public void setChargeTable(UIDataTable chargeTable) {
		this.chargeTable = chargeTable;
	}

	public PT_IL_LOAN_CHARGE_ACTION() {
		chargeDetailList = new ArrayList<PT_IL_LOAN_CHARGE>();
		PT_IL_LOAN_CHARGE_BEAN = new PT_IL_LOAN_CHARGE();
		prevRowIndex = 0;
		currPage = 1;
		/*
		 * Map<String,Object> session =
		 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		 * currentMode = (String) session.get("CURRENT_MODE");
		 * 
		 * if(currentMode.equalsIgnoreCase("INSERT")){ preInsert();
		 * 
		 *  }
		 */

	}

	public HtmlOutputLabel getCOMP_LC_CHRG_CODE_LABEL() {
		return COMP_LC_CHRG_CODE_LABEL;
	}

	public HtmlInputText getCOMP_LC_CHRG_CODE() {
		return COMP_LC_CHRG_CODE;
	}

	public void setCOMP_LC_CHRG_CODE_LABEL(
			HtmlOutputLabel COMP_LC_CHRG_CODE_LABEL) {
		this.COMP_LC_CHRG_CODE_LABEL = COMP_LC_CHRG_CODE_LABEL;
	}

	public void setCOMP_LC_CHRG_CODE(HtmlInputText COMP_LC_CHRG_CODE) {
		this.COMP_LC_CHRG_CODE = COMP_LC_CHRG_CODE;
	}

	public HtmlOutputLabel getCOMP_LC_PERC_LABEL() {
		return COMP_LC_PERC_LABEL;
	}

	public HtmlInputText getCOMP_LC_PERC() {
		return COMP_LC_PERC;
	}

	public void setCOMP_LC_PERC_LABEL(HtmlOutputLabel COMP_LC_PERC_LABEL) {
		this.COMP_LC_PERC_LABEL = COMP_LC_PERC_LABEL;
	}

	public void setCOMP_LC_PERC(HtmlInputText COMP_LC_PERC) {
		this.COMP_LC_PERC = COMP_LC_PERC;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_CHARGE_DESC_LABEL() {
		return COMP_UI_M_LC_CHARGE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_CHARGE_DESC() {
		return COMP_UI_M_LC_CHARGE_DESC;
	}

	public void setCOMP_UI_M_LC_CHARGE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_CHARGE_DESC_LABEL) {
		this.COMP_UI_M_LC_CHARGE_DESC_LABEL = COMP_UI_M_LC_CHARGE_DESC_LABEL;
	}

	public void setCOMP_UI_M_LC_CHARGE_DESC(
			HtmlInputText COMP_UI_M_LC_CHARGE_DESC) {
		this.COMP_UI_M_LC_CHARGE_DESC = COMP_UI_M_LC_CHARGE_DESC;
	}

	public HtmlOutputLabel getCOMP_LC_FC_VALUE_LABEL() {
		return COMP_LC_FC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_LC_FC_VALUE() {
		return COMP_LC_FC_VALUE;
	}

	public void setCOMP_LC_FC_VALUE_LABEL(HtmlOutputLabel COMP_LC_FC_VALUE_LABEL) {
		this.COMP_LC_FC_VALUE_LABEL = COMP_LC_FC_VALUE_LABEL;
	}

	public void setCOMP_LC_FC_VALUE(HtmlInputText COMP_LC_FC_VALUE) {
		this.COMP_LC_FC_VALUE = COMP_LC_FC_VALUE;
	}

	public HtmlOutputLabel getCOMP_LC_LC_VALUE_LABEL() {
		return COMP_LC_LC_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_LC_LC_VALUE() {
		return COMP_LC_LC_VALUE;
	}

	public void setCOMP_LC_LC_VALUE_LABEL(HtmlOutputLabel COMP_LC_LC_VALUE_LABEL) {
		this.COMP_LC_LC_VALUE_LABEL = COMP_LC_LC_VALUE_LABEL;
	}

	public void setCOMP_LC_LC_VALUE(HtmlInputText COMP_LC_LC_VALUE) {
		this.COMP_LC_LC_VALUE = COMP_LC_LC_VALUE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_CHARGE() {
		return COMP_UI_M_BUT_LOV_CHARGE;
	}

	public void setCOMP_UI_M_BUT_LOV_CHARGE(
			HtmlCommandButton COMP_UI_M_BUT_LOV_CHARGE) {
		this.COMP_UI_M_BUT_LOV_CHARGE = COMP_UI_M_BUT_LOV_CHARGE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_CHRG() {
		return COMP_UI_M_BUT_MAIN_CHRG;
	}

	public void setCOMP_UI_M_BUT_MAIN_CHRG(
			HtmlCommandButton COMP_UI_M_BUT_MAIN_CHRG) {
		this.COMP_UI_M_BUT_MAIN_CHRG = COMP_UI_M_BUT_MAIN_CHRG;
	}

	public PT_IL_LOAN_CHARGE getPT_IL_LOAN_CHARGE_BEAN() {
		return PT_IL_LOAN_CHARGE_BEAN;
	}

	public void setPT_IL_LOAN_CHARGE_BEAN(
			PT_IL_LOAN_CHARGE PT_IL_LOAN_CHARGE_BEAN) {
		this.PT_IL_LOAN_CHARGE_BEAN = PT_IL_LOAN_CHARGE_BEAN;
	}

	/*public List LovAction(Object object) {

		String lovQuery_LoanCode = "SELECT * FROM PM_CODES WHERE PC_TYPE = 'IL_CHARGE'";
		List lovList = new ArrayList();
		if ("*".equals(object.toString())) {
			lovList = suggestionList(lovQuery_LoanCode);
		}
		return lovList;

	}*/
	public List<LovBean> LovLC_CHRG_CODE(Object currValue) {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();


		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT004",
					"PT_IL_LOAN_CHARGE", "LC_CHRG_CODE", "IL_CHARGE", null,
					null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	//P_CALL_LOV('PT_IL_LOAN_CHARGE.LC_CHRG_CODE','IL_CHARGE');

	private List suggestionList(String query) {
		List lovList = new ArrayList();

		try {
			Connection con = CommonUtils.getConnection();
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {

				PT_IL_LOAN_CHARGE_CODE_LOV lovbox = new PT_IL_LOAN_CHARGE_CODE_LOV();
				lovbox.setPC_CODE(rs.getString("PC_CODE"));
				lovbox.setPC_DESC(rs.getString("PC_DESC"));
				lovList.add(lovbox);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return lovList;
	}

	/*
	 * private Connection getConnection() { Connection con = null; try {
	 * FacesContext fc = FacesContext.getCurrentInstance(); ServletContext
	 * context = (ServletContext) fc.getExternalContext() .getContext();
	 * SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context
	 * .getAttribute("connectionAgent"); con =
	 * connectionAgent.getConnection("123"); } catch (Exception ex) {
	 * ex.printStackTrace(); }
	 * 
	 * return con; }
	 */
	public String addNew() {
		CommonUtils.clearMaps(this);
		int rowCount = 0;

		if (chargeDetailList == null) {
			chargeDetailList = new ArrayList<PT_IL_LOAN_CHARGE>();
		}
		chargeDetailList.add(whenCreateRecordPT_IL_LOAN_CHARGE());

		// Settings to navigate to last page
		rowCount = getChargeTable().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return "newadded";
	}
	
	 /**
	  * Method to delete row(s)
	  * @return
	  */
	
	/* public String deleteRows() {
		 	CommonUtils.clearMaps(this);
			DelegateDb_DTL dbHelper = new DelegateDb_DTL();
			int deleteCount = 0;

			for (int i = chargeDetailList.size()-1; i>=0; i--) {
				PT_IL_LOAN_CHARGE_BEAN = chargeDetailList.get(i);
				System.out.println(">>>>>>>>>>deleteRows"+PT_IL_LOAN_CHARGE_BEAN.isSelected());
				if (PT_IL_LOAN_CHARGE_BEAN != null && PT_IL_LOAN_CHARGE_BEAN.isSelected()) {
					deleteCount += deleteData(PT_IL_LOAN_CHARGE_BEAN);
					System.out.println("PM_IL_BONUS_SETUP_ACTION.deleteRows()DELETING ROW");
					chargeDetailList.remove(PT_IL_LOAN_CHARGE_BEAN);
				}	
			}	
			if(deleteCount>0)
				{
				getErrorMap().put("somekey", deleteCount+" records deleted.");
				getErrorMap().put("current", deleteCount+" records deleted.");
				}
				lastUpdatedRowIndex = -1;
			
			return "row(s)Deleted";
		}
	 */
	 /**
		 * Method to delete data from the database
		 * @param detailsBean
		 * @return integer
		 */
		public int deleteData(PT_IL_LOAN_CHARGE valueBean)
		{
			CRUDHandler handler = new CRUDHandler();
			Connection connection = null;
			int deletedRows = 0;
			try {
				handler = new CRUDHandler();
				connection = CommonUtils.getConnection();
				deletedRows = handler.executeDelete(valueBean, connection);
				connection.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return deletedRows;
		}
		
		public String checkBoxStatus(ActionEvent actionEvent){
			 CommonUtils.clearMaps(this);
				String currentValue = getCurrentValue(actionEvent);
				
				int currRowIndex = chargeTable.getRowIndex();
				System.out.println("++++++++++++++Comming to check box status: "+currentValue);
				chargeDetailList.get(currRowIndex).setSelected(true);
				return "";
			} 

	public PT_IL_LOAN_CHARGE whenCreateRecordPT_IL_LOAN_CHARGE() {
		PT_IL_LOAN_CHARGE bean = new PT_IL_LOAN_CHARGE();
		return bean;
	}

	/*
	 * public List<PT_IL_LOAN_CHARGE> getChargeDetailList() {
	 * 
	 * CRUDHandler handler = new CRUDHandler(); Map session1 =
	 * FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	 * PT_IL_LOAN_ACTION ptILLoanAction = (PT_IL_LOAN_ACTION)
	 * session1.get("PILT004_PT_IL_LOAN_ACTION"); PT_IL_LOAN ptILLoanBean=
	 * ptILLoanAction.getPT_IL_LOAN_BEAN(); String C1 = "SELECT
	 * ROWID,PT_IL_LOAN_CHARGE.* FROM PT_IL_LOAN_CHARGE where
	 * LC_LOAN_SYS_ID="+ptILLoanBean.getLOAN_SYS_ID();
	 * 
	 * try{ chargeDetailList=handler.fetch(C1,
	 * "com.iii.pel.forms.PILT004.PT_IL_LOAN_CHARGE",
	 * CommonUtils.getConnection());; int size = chargeDetailList.size();
	 * if(size < 5 ) { for(int i=size ; i < 5 ; i++ ) { PT_IL_LOAN_CHARGE bean =
	 * new PT_IL_LOAN_CHARGE(ptILLoanBean.getLOAN_SYS_ID());
	 * chargeDetailList.add(bean); } } }catch(Exception
	 * ex){ex.printStackTrace();} return chargeDetailList; }
	 */

	public void fetchChargeDetails(){
		Connection connection = null;
		ResultSet resultSet = null;
		
		CRUDHandler handler = new CRUDHandler();
		Map session1 = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		PT_IL_LOAN_ACTION ptILLoanAction = (PT_IL_LOAN_ACTION) session1
				.get("PILT004_PT_IL_LOAN_ACTION");
		PT_IL_LOAN ptILLoanBean = ptILLoanAction.getPT_IL_LOAN_BEAN();
		String C1 = "SELECT ROWID,PT_IL_LOAN_CHARGE.* FROM PT_IL_LOAN_CHARGE where LC_LOAN_SYS_ID="
				+ ptILLoanBean.getLOAN_SYS_ID();

		try {
			System.out.println("Query------------------------->"+C1);
			
			//added by akash to solve the issue (record not exist when they quired)
			
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			while(resultSet.next()){
				PT_IL_LOAN_CHARGE chargeBean = new PT_IL_LOAN_CHARGE();
				chargeBean.setROWID(resultSet.getString("ROWID"));
				chargeBean.setLC_SYS_ID(resultSet.getLong("LC_SYS_ID"));
				chargeBean.setLC_LOAN_SYS_ID(resultSet.getLong("LC_LOAN_SYS_ID"));
				chargeBean.setLC_CHRG_CODE(resultSet.getString("LC_CHRG_CODE"));
				chargeBean.setLC_PERC(resultSet.getDouble("LC_PERC"));
				chargeBean.setLC_FC_VALUE(resultSet.getDouble("LC_FC_VALUE"));
				chargeBean.setLC_LC_VALUE(resultSet.getDouble("LC_LC_VALUE"));
				chargeDetailList.add(chargeBean);
			}
			if(chargeDetailList != null && chargeDetailList.size() > 0){
				this.setPT_IL_LOAN_CHARGE_BEAN(chargeDetailList.get(0));
				chargeDetailList.get(0).setRowSelected(true);
				
			}
			/*chargeDetailList = handler.fetch(C1,
					"com.iii.pel.forms.PILT004.PT_IL_LOAN_CHARGE", CommonUtils
							.getConnection());
			System.out.println("Chargelist from db: "+chargeDetailList.size());
			int size = chargeDetailList.size();*/
		/*	if (size < 5) {
				for (int i = 0; i < 5 - size; i++) {
					PT_IL_LOAN_CHARGE bean = null;
					if (ptILLoanBean.getLOAN_SYS_ID() == 0) {
						ptILLoanAction.preInsert();
						System.out.println("getChargeDetailList()"
								+ ptILLoanBean.getLOAN_SYS_ID());
						bean = new PT_IL_LOAN_CHARGE(ptILLoanBean
								.getLOAN_SYS_ID());
					} else {
						System.out.println("getChargeDetailList() else"
								+ ptILLoanBean.getLOAN_SYS_ID());
						bean = new PT_IL_LOAN_CHARGE(ptILLoanBean
								.getLOAN_SYS_ID());
					}
					chargeDetailList.add(bean);
				}
			}*/
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Added By akash 
	
	public void executeQuery() throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		
		CRUDHandler handler = new CRUDHandler();
		Map session1 = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		PT_IL_LOAN_ACTION ptILLoanAction = (PT_IL_LOAN_ACTION) session1
				.get("PILT004_PT_IL_LOAN_ACTION");
		PT_IL_LOAN ptILLoanBean = ptILLoanAction.getPT_IL_LOAN_BEAN();
		String C1 = "SELECT ROWID,PT_IL_LOAN_CHARGE.* FROM PT_IL_LOAN_CHARGE where LC_LOAN_SYS_ID="
				+ ptILLoanBean.getLOAN_SYS_ID();

		try {
			System.out.println("Query------------------------->"+C1);
			
			//added by akash to solve the issue (record not exist when they quired)
			
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			while(resultSet.next()){
				PT_IL_LOAN_CHARGE chargeBean = new PT_IL_LOAN_CHARGE();
				chargeBean.setROWID(resultSet.getString("ROWID"));
				chargeBean.setLC_SYS_ID(resultSet.getLong("LC_SYS_ID"));
				chargeBean.setLC_LOAN_SYS_ID(resultSet.getLong("LC_LOAN_SYS_ID"));
				chargeBean.setLC_CHRG_CODE(resultSet.getString("LC_CHRG_CODE"));
				chargeBean.setLC_PERC(resultSet.getDouble("LC_PERC"));
				chargeBean.setLC_FC_VALUE(resultSet.getDouble("LC_FC_VALUE"));
				chargeBean.setLC_LC_VALUE(resultSet.getDouble("LC_LC_VALUE"));
				
				/*ADDED BY RAJA ON 19-04-2017*/
				if (chargeBean.getLC_CHRG_CODE() != null) {
					
					String descQuery = "SELECT PC_DESC FROM PM_CODES WHERE PC_CODE = ?";

						Connection con = CommonUtils.getConnection();
						PreparedStatement psmt = con.prepareStatement(descQuery);
						psmt.setString(1, chargeBean.getLC_CHRG_CODE());
						ResultSet rs = psmt.executeQuery();
						while (rs.next()) {
							chargeBean.setUI_M_LC_CHARGE_DESC("PC_DESC");
						}
				}
				/*END*/
				
				chargeDetailList.add(chargeBean);
			}
			if(chargeDetailList != null && chargeDetailList.size() > 0){
				this.setPT_IL_LOAN_CHARGE_BEAN(chargeDetailList.get(0));
				chargeDetailList.get(0).setRowSelected(true);
				
			}
		
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	public void onLoad(PhaseEvent ae){
		try{
			if(isBlockFlag()){
				CommonUtils.clearMaps(this);
				executeQuery();
				if(PT_IL_LOAN_CHARGE_BEAN.getROWID() == null){
					
				}else{
					
				}
				setBlockFlag(false);
			}
		}catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public List<PT_IL_LOAN_CHARGE> getChargeDetailList() {
		return chargeDetailList;
	}

	public void setChargeDetailList(List<PT_IL_LOAN_CHARGE> chargeDetailList) {
		this.chargeDetailList = chargeDetailList;
	}

	public void setDescription(ActionEvent event) {
		CommonUtils.clearMaps(this);
		// WhenValidate of "code" field.
		UIInput input = (UIInput) event.getComponent().getParent();
		String desc = null;
		String chargesCode = (String) input.getValue();
		int rowIndex = getChargeTable().getRowIndex();
		PT_IL_LOAN_CHARGE chargeBean = null;
		if (rowIndex >= 0) {
			chargeBean = getChargeDetailList().get(rowIndex);
		}
		if (chargesCode != null) {
			chargeBean.setLC_CHRG_CODE(chargesCode);
			getCOMP_LC_CHRG_CODE().resetValue();
			String descQuery = "SELECT PC_DESC FROM PM_CODES WHERE PC_CODE = ?";
			try {

				Connection con = CommonUtils.getConnection();
				PreparedStatement psmt = con.prepareStatement(descQuery);
				psmt.setString(1, chargesCode);
				ResultSet rs = psmt.executeQuery();
				while (rs.next()) {
					desc = rs.getString("PC_DESC");

				}
				chargeBean.setUI_M_LC_CHARGE_DESC(desc);
				getCOMP_UI_M_LC_CHARGE_DESC().resetValue();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		rowChangeListener(event);
	}

	public void LC_PERC_Validator(ActionEvent event) throws ValidatorException {
		CommonUtils.clearMaps(this);
		
//		int rowIndex = getChargeTable().getRowIndex();
//		PT_IL_LOAN_CHARGE chargeBean = null;
//		if (rowIndex >= 0) {
//			chargeBean = getChargeDetailList().get(rowIndex);
//		}
		PT_IL_LOAN_CHARGE chargeBean=getPT_IL_LOAN_CHARGE_BEAN();
		//PT_IL_LOAN_CHARGE_BEAN
		// Whenvalidate of LC_PERC field//
		Double LC_PERC = (Double) getCOMP_LC_PERC().getValue();
		Double lcPercentage = Double.valueOf(LC_PERC);

		/***********************************************************************
		 * :PT_IL_LOAN_CHARGE.LC_FC_VALUE := (:PT_IL_LOAN.LOAN_FC_AMOUNT
		 * :PT_IL_LOAN_CHARGE.LC_PERC) / 100;
		 */

		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Double LOAN_FC_AMOUNT = (Double) session.get("LOAN_FC_AMOUNT");
		Double LOAN_LC_AMOUNT = (Double) session.get("LOAN_LC_AMOUNT");
		Double LC_FC_VALUE = (LOAN_FC_AMOUNT * lcPercentage) / 100;

		/*
		 * :PT_IL_LOAN_CHARGE.LC_LC_VALUE := :PT_IL_LOAN_CHARGE.LC_FC_VALUE *
		 * :PT_IL_LOAN.LOAN_EXCH_RATE;
		 */

		Double LC_LC_VALUE = (LOAN_LC_AMOUNT * lcPercentage) / 100;

		/*getCOMP_LC_FC_VALUE().setSubmittedValue(String.valueOf(LC_FC_VALUE));
		getCOMP_LC_LC_VALUE().setSubmittedValue(String.valueOf(LC_LC_VALUE));*/
		chargeBean.setLC_PERC(lcPercentage);
		chargeBean.setLC_FC_VALUE(LC_FC_VALUE);
		chargeBean.setLC_LC_VALUE(LC_LC_VALUE);
		getCOMP_LC_PERC().resetValue();
		getCOMP_LC_FC_VALUE().resetValue();
		getCOMP_LC_LC_VALUE().resetValue();
		
		rowChangeListener(event);

	}

	public String mainBtnAction() {

		Double FC_VALUE_SUM = 0.0;
		Double LC_VALUE_SUM = 0.0;

		List<PT_IL_LOAN_CHARGE> list = chargeDetailList;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			PT_IL_LOAN_CHARGE bean = (PT_IL_LOAN_CHARGE) iterator.next();
			if (bean.getLC_FC_VALUE() != null) {
				FC_VALUE_SUM = FC_VALUE_SUM + bean.getLC_FC_VALUE();
			}
			if (bean.getLC_LC_VALUE() != null) {
				LC_VALUE_SUM = LC_VALUE_SUM + bean.getLC_LC_VALUE();
			}
		}
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PT_IL_LOAN_ACTION loanActionBean = (PT_IL_LOAN_ACTION) session
				.get("PILT004_PT_IL_LOAN_ACTION");
		
		/** [ Mallika 18-Mar-09  If charges are included, on saving the main block, the
		 *  charge amount disappears. */
		PT_IL_LOAN loanBean = loanActionBean.getPT_IL_LOAN_BEAN();
		loanActionBean.getCOMP_UI_M_LOAN_LC_CHARGE().setSubmittedValue(
				String.valueOf(LC_VALUE_SUM));
		loanBean.setUI_M_LOAN_LC_CHARGE(LC_VALUE_SUM);
		loanActionBean.getCOMP_UI_M_LOAN_FC_CHARGE().setSubmittedValue(
				String.valueOf(FC_VALUE_SUM));
		loanBean.setUI_M_LOAN_FC_CHARGE(FC_VALUE_SUM);

		if ("Approved".equalsIgnoreCase(loanActionBean.getPT_IL_LOAN_BEAN()
				.getUI_M_APPRV_STATUS())) {
			loanActionBean.setComponentDisableStatus(true);
		} else {
			loanActionBean.setComponentDisableStatus(false);
		}
		
		//  This method calling is Not Allicable here Added by: S.Mallika, Dated: 18- Feb-2009
		//preUpdate();

		return "main";
	}

	private void rowChangeListener(ActionEvent event) {
		CommonUtils.clearMaps(this);
		System.out.println("PT_IL_LOAN_CHARGE_ACTION.rowChangeListener()");
		int currRowIndex = getChargeTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_LOAN_CHARGE gridValueBean = null;
		System.out.println(lastUpdatedRowIndex + "   " + currRowIndex + "  "
				+ prevRowIndex);
		try {
			if (lastUpdatedRowIndex != -1) {
				if (lastUpdatedRowIndex != prevRowIndex) {
					if (currRowIndex != prevRowIndex) {

						// Get the bean based on row index
						gridValueBean = (PT_IL_LOAN_CHARGE) chargeDetailList
								.get(prevRowIndex);
						// Update the record to database
						if (gridValueBean.getROWID() != null) {
							System.out
									.println("PT_IL_LOAN_CHARGE_ACTION.rowChangeListener-----rowID1"
											+ gridValueBean.getROWID());
							rowUpdated = updateData(gridValueBean);
						} else {

							// gridValueBean.setRSA_PLAN_CODE("dee");
							// Setting Bean Values here//

							System.out
									.println("PT_IL_LOAN_CHARGE_ACTION.rowChangeListener-----rowID2"
											+ gridValueBean.getROWID());
							rowUpdated = updateData(gridValueBean);
						}

						// Update previous row index
						prevRowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
		}

	}

	private int updateData(PT_IL_LOAN_CHARGE gridValueBean) throws Exception {
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			Connection connection = CommonUtils.getConnection();
			// dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(gridValueBean, connection);
			// connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}


	public void saveData(ActionEvent event) {
		CommonUtils.clearMaps(this);
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void preInsert(PT_IL_LOAN_CHARGE ptILLoanCharge) throws Exception {
		Map session1 = FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap();
		PT_IL_LOAN_ACTION ptILLoanAction = (PT_IL_LOAN_ACTION) session1
				.get("PILT004_PT_IL_LOAN_ACTION");
		PT_IL_LOAN ptILLoanBean = ptILLoanAction.getPT_IL_LOAN_BEAN();
		
		Long LC_LOAN_SYS_ID = null;
		Long LC_SYS_ID = null;
		LC_LOAN_SYS_ID = ptILLoanBean.getLOAN_SYS_ID();
	/*	int rowIndex = getChargeTable().getRowIndex();
		PT_IL_LOAN_CHARGE chanrgeBean = getChargeDetailList().get(
				rowIndex);*/
		PT_IL_LOAN_CHARGE_BEAN.setLC_LOAN_SYS_ID(LC_LOAN_SYS_ID);
		try {
			String query = "SELECT PIL_LC_SYS_ID.NEXTVAL AS LC_SYS_ID FROM DUAL";
			Connection con = CommonUtils.getConnection();
			PreparedStatement psmt = con.prepareStatement(query);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				LC_SYS_ID = rs.getLong("LC_SYS_ID");

			}
			ptILLoanCharge.setLC_SYS_ID(LC_SYS_ID);
			System.out.println(ptILLoanCharge.getLC_CHRG_CODE());
			System.out.println(ptILLoanCharge.getLC_SYS_ID());

			// P9ILPK_LOAN.UNIQUE_CHARGE_CODE(:PT_IL_LOAN_CHARGE.LC_CHRG_CODE,:PT_IL_LOAN_CHARGE.LC_LOAN_SYS_ID);

			ArrayList<OracleParameter> cparamList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> coutList = new ArrayList<OracleParameter>();

			OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",
					ptILLoanCharge.getLC_CHRG_CODE());
			cparamList.add(p1);
			OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN",
					String.valueOf(LC_LOAN_SYS_ID));
			cparamList.add(p2);

			OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
			coutList = pHandler1.execute(cparamList, CommonUtils
					.getConnection(), "P9ILPK_LOAN.UNIQUE_CHARGE_CODE");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			// ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
			// FacesContext.getCurrentInstance(),
			// input.getClientId(FacesContext.getCurrentInstance()),
			// getErrorMap(), getWarningMap());
		}

	}

	public void lastColumnListener() {
		
		int currRowIndex = getChargeTable().getRowIndex();
		int rowUpdated = 0;
		PT_IL_LOAN_CHARGE gridValueBean = null;

		try {

			// Get the bean based on row index
			gridValueBean = (PT_IL_LOAN_CHARGE) chargeDetailList
					.get(currRowIndex);
			gridValueBean.setLC_CR_UID(CommonUtils
					.getGlobalVariable("PILT004_GLOBAL_M_USER_ID"));
			gridValueBean.setLC_CR_DT(getSystemDate());
			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				preUpdate();
				rowUpdated = updateData(gridValueBean);

			} else {
				preInsert(gridValueBean);
				rowUpdated = updateData(gridValueBean);

			}

			lastUpdatedRowIndex = currRowIndex;

		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
		}

		return;

	}

	public void preUpdate() throws Exception {
		Connection con = null;
		double M_VALUE = 0.0;
		double M_LOAN_GR_LC_AMT = 0.0;
		double M_LOAN_GR_FC_AMT = 0.0;
		double FC_VALUE_SUM = 0.0;
		double LC_VALUE_SUM = 0.0;
		double LC_NET_AMOUNT = 0.0;
		double FC_NET_AMOUNT = 0.0;

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		PT_IL_LOAN_ACTION actionBean = (PT_IL_LOAN_ACTION) sessionMap
				.get("PILT004_PT_IL_LOAN_ACTION");
		PT_IL_LOAN valueBean = actionBean.getPT_IL_LOAN_BEAN();

		String CURR_CODE = CommonUtils.getGlobalVariable("PILT004_BASE_CURR");

		List<PT_IL_LOAN_CHARGE> list = chargeDetailList;
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			PT_IL_LOAN_CHARGE bean = (PT_IL_LOAN_CHARGE) iterator.next();
			if (bean.getLC_FC_VALUE() != null) {
				FC_VALUE_SUM = FC_VALUE_SUM + bean.getLC_FC_VALUE();
			}
			if (bean.getLC_LC_VALUE() != null) {
				LC_VALUE_SUM = LC_VALUE_SUM + bean.getLC_LC_VALUE();
			}
		}

		try {
			ArrayList<OracleParameter> paramList1 = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outList1 = new ArrayList<OracleParameter>();
			OracleParameter p1 = new OracleParameter("IN1", "STRING", "IN",
					"IL_LNINT_DED");
			paramList1.add(p1);
			OracleParameter p2 = new OracleParameter("IN2", "STRING", "IN",
					"ID");
			paramList1.add(p2);
			OracleParameter p3 = new OracleParameter("IN3", "STRING", "IN OUT",
					"");
			paramList1.add(p3);
			OracleParameter p4 = new OracleParameter("IN4", "STRING", "IN", "E");
			paramList1.add(p4);
			OracleParameter p5 = new OracleParameter("IN5", "STRING", "IN OUT",
					"");
			paramList1.add(p5);
			OracleProcedureHandler pHandler1 = new OracleProcedureHandler();
			con = CommonUtils.getConnection();
			outList1 = pHandler1.execute(paramList1, con, "P_VAL_SYSTEM");
			for (Iterator iterator2 = outList1.iterator(); iterator2.hasNext();) {
				OracleParameter name = (OracleParameter) iterator2.next();
				if (name.getFieldName().equals("IN5")) {
					M_VALUE = Double.valueOf(name.getValue());
				}
			}
			System.out.println("VALUE BEAN ********" + valueBean);
			if (M_VALUE == 1) {
				M_LOAN_GR_LC_AMT = valueBean.getLOAN_LC_AMOUNT()
						- (valueBean.getLOAN_LC_INTEREST() + LC_VALUE_SUM);
				M_LOAN_GR_FC_AMT = valueBean.getLOAN_FC_AMOUNT()
						- (valueBean.getLOAN_FC_INTEREST() + FC_VALUE_SUM);
			} else {
				M_LOAN_GR_LC_AMT = valueBean.getLOAN_LC_AMOUNT() - LC_VALUE_SUM;
				M_LOAN_GR_FC_AMT = valueBean.getLOAN_FC_AMOUNT() - FC_VALUE_SUM;
			}

			M_LOAN_GR_LC_AMT = P_VAL_ROUND_AMT(CURR_CODE, M_LOAN_GR_LC_AMT, "R");
			M_LOAN_GR_FC_AMT = P_VAL_ROUND_AMT(CURR_CODE, M_LOAN_GR_FC_AMT, "R");

			valueBean.setUI_M_LOAN_GR_LC_AMT(M_LOAN_GR_LC_AMT);
			valueBean.setUI_M_LOAN_GR_FC_AMT(M_LOAN_GR_FC_AMT);

			if (valueBean.getLOAN_LC_UNPAID_PREM() == null) {
				valueBean.setLOAN_LC_UNPAID_PREM(0.0);
			}
			if (valueBean.getLOAN_FC_UNPAID_PREM() == null) {
				valueBean.setLOAN_FC_UNPAID_PREM(0.0);
			}
			if (valueBean.getLOAN_LC_UNPAID_PREM_INT() == null) {
				valueBean.setLOAN_LC_UNPAID_PREM_INT(0.0);
			}
			if (valueBean.getLOAN_FC_UNPAID_PREM_INT() == null) {
				valueBean.setLOAN_FC_UNPAID_PREM_INT(0.0);
			}
			if (valueBean.getLOAN_LC_OS_AMOUNT() == null) {
				valueBean.setLOAN_LC_OS_AMOUNT(0.0);
			}
			if (valueBean.getLOAN_FC_OS_AMOUNT() == null) {
				valueBean.setLOAN_FC_OS_AMOUNT(0.0);
			}
			if (valueBean.getLOAN_LC_OS_LOAN_INT() == null) {
				valueBean.setLOAN_LC_OS_LOAN_INT(0.0);
			}
			if (valueBean.getLOAN_FC_OS_LOAN_INT() == null) {
				valueBean.setLOAN_FC_OS_LOAN_INT(0.0);
			}
			LC_NET_AMOUNT = M_LOAN_GR_LC_AMT
					- (valueBean.getLOAN_LC_UNPAID_PREM()
							+ valueBean.getLOAN_LC_UNPAID_PREM_INT()
							+ valueBean.getLOAN_LC_OS_AMOUNT() + valueBean
							.getLOAN_FC_OS_LOAN_INT());
			FC_NET_AMOUNT = M_LOAN_GR_FC_AMT
					- (valueBean.getLOAN_FC_UNPAID_PREM()
							+ valueBean.getLOAN_FC_UNPAID_PREM_INT()
							+ valueBean.getLOAN_FC_OS_AMOUNT() + valueBean
							.getLOAN_FC_OS_LOAN_INT());

			LC_NET_AMOUNT = P_VAL_ROUND_AMT(CURR_CODE, LC_NET_AMOUNT, "R");
			FC_NET_AMOUNT = P_VAL_ROUND_AMT(CURR_CODE, FC_NET_AMOUNT, "R");

			valueBean.setLOAN_LC_NET_AMOUNT(LC_NET_AMOUNT);
			valueBean.setLOAN_FC_NET_AMOUNT(FC_NET_AMOUNT);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}

	}

	private Double P_VAL_ROUND_AMT(String CURR_CODE, Double PREM_INT,
			String TYPE) {
		try {
			CallableStatement cs = CommonUtils.getConnection().prepareCall(
					"{call P_VAL_ROUND_AMT(?,?,?)}");
			cs.setString(1, CURR_CODE);
			cs.registerOutParameter(2, java.sql.Types.DOUBLE);
			cs.setDouble(2, PREM_INT);
			cs.setString(3, TYPE);
			boolean flag = cs.execute();
			PREM_INT = cs.getDouble(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return PREM_INT;
	}

	public Date getSystemDate() {
		Date sysDate = null;
		try {
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = handler.executeSelectStatement(query,
					CommonUtils.getConnection());
			while (resultSet.next())
				sysDate = resultSet.getDate(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sysDate;
	}

	public boolean isInsertAllowed() {
		return insertAllowed;
	}

	public void setInsertAllowed(boolean insertAllowed) {
		this.insertAllowed = insertAllowed;
	}

	public boolean isUpdateAllowed() {
		return updateAllowed;
	}

	public void setUpdateAllowed(boolean updateAllowed) {
		this.updateAllowed = updateAllowed;
	}

	public boolean isDeleteAllowed() {
		return deleteAllowed;
	}

	public void setDeleteAllowed(boolean deleteAllowed) {
		this.deleteAllowed = deleteAllowed;
	}

	public String getCurrentValue(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			System.out
					.println("<<<<<<<<<<<<<<<<<INPUT>>>>>>>>>>>>>>>>" + input);
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}


	
	public void whenValidate_LC_LC_VALUE(ActionEvent event) {
		getCOMP_LC_LC_VALUE().resetValue();
		// String value = getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		/*UIInput input = (UIInput) event.getComponent().getParent();
		System.out.println("val-------------------------"
				+ input.getSubmittedValue());*/
	}

	public void validateLC_LC_Value(FacesContext facesContext,
			UIComponent component, Object value) {
		if (value != null) {
			Double LCValue = (Double) value;
			//int rowIndex = getChargeTable().getRowIndex();
			//PT_IL_LOAN_CHARGE pt_il_loan_charge = getChargeDetailList().get(rowIndex);
			PT_IL_LOAN_CHARGE chargeBean=getPT_IL_LOAN_CHARGE_BEAN();
			chargeBean.setLC_LC_VALUE(LCValue);

		}

	}

	// [ Added for grid implementation change, Added by: S.Mallika, Dated:
	// 17-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = chargeTable.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}
	// Added for grid implementation change, Added by: S.Mallika, Dated:
	// 17-Feb-2009 ]

	public void getDetails() {
		try {
			if (chargeDetailList.size() != 0) {				
				PT_IL_LOAN_CHARGE_BEAN = (PT_IL_LOAN_CHARGE)chargeTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			PT_IL_LOAN_CHARGE_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	  }
	
	private void resetSelectedRow() {
		Iterator<PT_IL_LOAN_CHARGE> iterator = chargeDetailList.iterator();
		while (iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void resetAllComponent()
	{
		COMP_LC_CHRG_CODE.resetValue();
		COMP_UI_M_LC_CHARGE_DESC.resetValue();
		COMP_LC_PERC.resetValue();
		COMP_LC_FC_VALUE.resetValue();
		COMP_LC_LC_VALUE.resetValue();
	}
	
	public void AddRow(ActionEvent event){

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			
			if (isINSERT_ALLOWED()){		
				PT_IL_LOAN_CHARGE_BEAN = new PT_IL_LOAN_CHARGE();
				resetAllComponent();
				resetSelectedRow();
				PT_IL_LOAN_CHARGE_BEAN.setRowSelected(true);
			}else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	}
	
public void deleteRow(ActionEvent ae) {
		
		try{
			getErrorMap().clear();
			getWarningMap().clear();

			if(isDELETE_ALLOWED()) {
				if(PT_IL_LOAN_CHARGE_BEAN.getROWID() != null) {
					//executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_LOAN_CHARGE_BEAN, CommonUtils.getConnection());
					chargeDetailList.remove(PT_IL_LOAN_CHARGE_BEAN);
				}
				
				if(chargeDetailList.size() > 0) {
					setPT_IL_LOAN_CHARGE_BEAN(chargeDetailList.get(0));
				} else {
					AddRow(ae);
				}
				
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				getWarningMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put("deleteRow",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	public void post(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		 try{
		if(PT_IL_LOAN_CHARGE_BEAN.getROWID() != null) {
			if(isUPDATE_ALLOWED()) {
				this.preUpdate();
				new CRUDHandler().executeInsert(PT_IL_LOAN_CHARGE_BEAN, CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
			} else {
				getErrorMap().clear();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
			}
		} else {

			if(isINSERT_ALLOWED()) {
				this.preInsert(this.PT_IL_LOAN_CHARGE_BEAN);
				new CRUDHandler().executeInsert(PT_IL_LOAN_CHARGE_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
				Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
				chargeDetailList.add(PT_IL_LOAN_CHARGE_BEAN);
			} else {
				getErrorMap().clear();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
			}
		}
		resetAllComponent();
		PT_IL_LOAN_CHARGE_BEAN.setRowSelected(true);

	  } catch (Exception e) {
		e.printStackTrace();
		getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		getErrorMap().put("post", e.getMessage());
	}
	}
	


	public Connection getConnection() throws Exception {
		Connection connection = CommonUtils.getConnection();
		return connection;
	}


	
	
}
