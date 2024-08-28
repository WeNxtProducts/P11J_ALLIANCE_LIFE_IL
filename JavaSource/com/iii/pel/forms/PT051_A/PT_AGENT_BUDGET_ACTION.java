package com.iii.pel.forms.PT051_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
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

import org.richfaces.component.UICalendar;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.MigratingFunctions;
import com.iii.premia.runtime.functions.NumericFunctions;

public class PT_AGENT_BUDGET_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ABGT_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ABGT_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_ABGT_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ABGT_AGENT_NAME;

	private HtmlOutputLabel COMP_UI_M_ABGT_AGENCY_CODE_LABEL;

	private HtmlInputText COMP_UI_M_ABGT_AGENCY_CODE;

	private HtmlOutputLabel COMP_UI_M_ABGT_AGENCY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ABGT_AGENCY_NAME;

	private HtmlOutputLabel COMP_ABGT_MODULE_ID_LABEL;

	private HtmlSelectOneMenu COMP_ABGT_MODULE_ID;

	private HtmlOutputLabel COMP_ABGT_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ABGT_NO_OF_POL;

	private HtmlOutputLabel COMP_ABGT_LC_PREM_LABEL;

	private HtmlInputText COMP_ABGT_LC_PREM;

	private HtmlOutputLabel COMP_ABGT_FM_DT_LABEL;

	private HtmlCalendar COMP_ABGT_FM_DT;

	private HtmlOutputLabel COMP_ABGT_TO_DT_LABEL;

	private HtmlCalendar COMP_ABGT_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_ABGT_AGENT_CODE_LOV;

	private PT_AGENT_BUDGET PT_AGENT_BUDGET_BEAN;

	List<SelectItem> ABGT_MODULE_ID_LIST = new ArrayList<SelectItem>();
	
	Map<String,Object> sessionMap = null;
	
	DUMMY DUMMY_BEAN;
	
	FacesContext ctx = FacesContext.getCurrentInstance();
	
	private HtmlCommandButton PREFORMBUTTON;
	
	public PT051_A_COMPOSITE_ACTION compositeAction;


	public PT_AGENT_BUDGET_ACTION() {
		DUMMY_BEAN = new DUMMY();
		PT_AGENT_BUDGET_BEAN = new PT_AGENT_BUDGET();
	}

	public HtmlOutputLabel getCOMP_ABGT_AGENT_CODE_LABEL() {
		return COMP_ABGT_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABGT_AGENT_CODE() {
		return COMP_ABGT_AGENT_CODE;
	}

	public void setCOMP_ABGT_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_ABGT_AGENT_CODE_LABEL) {
		this.COMP_ABGT_AGENT_CODE_LABEL = COMP_ABGT_AGENT_CODE_LABEL;
	}

	public void setCOMP_ABGT_AGENT_CODE(HtmlInputText COMP_ABGT_AGENT_CODE) {
		this.COMP_ABGT_AGENT_CODE = COMP_ABGT_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABGT_AGENT_NAME_LABEL() {
		return COMP_UI_M_ABGT_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABGT_AGENT_NAME() {
		return COMP_UI_M_ABGT_AGENT_NAME;
	}

	public void setCOMP_UI_M_ABGT_AGENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ABGT_AGENT_NAME_LABEL) {
		this.COMP_UI_M_ABGT_AGENT_NAME_LABEL = COMP_UI_M_ABGT_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ABGT_AGENT_NAME(
			HtmlInputText COMP_UI_M_ABGT_AGENT_NAME) {
		this.COMP_UI_M_ABGT_AGENT_NAME = COMP_UI_M_ABGT_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABGT_AGENCY_CODE_LABEL() {
		return COMP_UI_M_ABGT_AGENCY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABGT_AGENCY_CODE() {
		return COMP_UI_M_ABGT_AGENCY_CODE;
	}

	public void setCOMP_UI_M_ABGT_AGENCY_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_ABGT_AGENCY_CODE_LABEL) {
		this.COMP_UI_M_ABGT_AGENCY_CODE_LABEL = COMP_UI_M_ABGT_AGENCY_CODE_LABEL;
	}

	public void setCOMP_UI_M_ABGT_AGENCY_CODE(
			HtmlInputText COMP_UI_M_ABGT_AGENCY_CODE) {
		this.COMP_UI_M_ABGT_AGENCY_CODE = COMP_UI_M_ABGT_AGENCY_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABGT_AGENCY_NAME_LABEL() {
		return COMP_UI_M_ABGT_AGENCY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABGT_AGENCY_NAME() {
		return COMP_UI_M_ABGT_AGENCY_NAME;
	}

	public void setCOMP_UI_M_ABGT_AGENCY_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ABGT_AGENCY_NAME_LABEL) {
		this.COMP_UI_M_ABGT_AGENCY_NAME_LABEL = COMP_UI_M_ABGT_AGENCY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ABGT_AGENCY_NAME(
			HtmlInputText COMP_UI_M_ABGT_AGENCY_NAME) {
		this.COMP_UI_M_ABGT_AGENCY_NAME = COMP_UI_M_ABGT_AGENCY_NAME;
	}

	public HtmlOutputLabel getCOMP_ABGT_MODULE_ID_LABEL() {
		return COMP_ABGT_MODULE_ID_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABGT_MODULE_ID() {
		return COMP_ABGT_MODULE_ID;
	}

	public void setCOMP_ABGT_MODULE_ID_LABEL(
			HtmlOutputLabel COMP_ABGT_MODULE_ID_LABEL) {
		this.COMP_ABGT_MODULE_ID_LABEL = COMP_ABGT_MODULE_ID_LABEL;
	}

	public void setCOMP_ABGT_MODULE_ID(HtmlSelectOneMenu COMP_ABGT_MODULE_ID) {
		this.COMP_ABGT_MODULE_ID = COMP_ABGT_MODULE_ID;
	}

	public HtmlOutputLabel getCOMP_ABGT_NO_OF_POL_LABEL() {
		return COMP_ABGT_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ABGT_NO_OF_POL() {
		return COMP_ABGT_NO_OF_POL;
	}

	public void setCOMP_ABGT_NO_OF_POL_LABEL(
			HtmlOutputLabel COMP_ABGT_NO_OF_POL_LABEL) {
		this.COMP_ABGT_NO_OF_POL_LABEL = COMP_ABGT_NO_OF_POL_LABEL;
	}

	public void setCOMP_ABGT_NO_OF_POL(HtmlInputText COMP_ABGT_NO_OF_POL) {
		this.COMP_ABGT_NO_OF_POL = COMP_ABGT_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ABGT_LC_PREM_LABEL() {
		return COMP_ABGT_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_ABGT_LC_PREM() {
		return COMP_ABGT_LC_PREM;
	}

	public void setCOMP_ABGT_LC_PREM_LABEL(
			HtmlOutputLabel COMP_ABGT_LC_PREM_LABEL) {
		this.COMP_ABGT_LC_PREM_LABEL = COMP_ABGT_LC_PREM_LABEL;
	}

	public void setCOMP_ABGT_LC_PREM(HtmlInputText COMP_ABGT_LC_PREM) {
		this.COMP_ABGT_LC_PREM = COMP_ABGT_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_ABGT_FM_DT_LABEL() {
		return COMP_ABGT_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABGT_FM_DT() {
		return COMP_ABGT_FM_DT;
	}

	public void setCOMP_ABGT_FM_DT_LABEL(HtmlOutputLabel COMP_ABGT_FM_DT_LABEL) {
		this.COMP_ABGT_FM_DT_LABEL = COMP_ABGT_FM_DT_LABEL;
	}

	public void setCOMP_ABGT_FM_DT(HtmlCalendar COMP_ABGT_FM_DT) {
		this.COMP_ABGT_FM_DT = COMP_ABGT_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ABGT_TO_DT_LABEL() {
		return COMP_ABGT_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABGT_TO_DT() {
		return COMP_ABGT_TO_DT;
	}

	public void setCOMP_ABGT_TO_DT_LABEL(HtmlOutputLabel COMP_ABGT_TO_DT_LABEL) {
		this.COMP_ABGT_TO_DT_LABEL = COMP_ABGT_TO_DT_LABEL;
	}

	public void setCOMP_ABGT_TO_DT(HtmlCalendar COMP_ABGT_TO_DT) {
		this.COMP_ABGT_TO_DT = COMP_ABGT_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ABGT_AGENT_CODE_LOV() {
		return COMP_UI_M_BUT_ABGT_AGENT_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_ABGT_AGENT_CODE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_ABGT_AGENT_CODE_LOV) {
		this.COMP_UI_M_BUT_ABGT_AGENT_CODE_LOV = COMP_UI_M_BUT_ABGT_AGENT_CODE_LOV;
	}

	public PT_AGENT_BUDGET getPT_AGENT_BUDGET_BEAN() {
		return PT_AGENT_BUDGET_BEAN;
	}

	public void setPT_AGENT_BUDGET_BEAN(PT_AGENT_BUDGET PT_AGENT_BUDGET_BEAN) {
		this.PT_AGENT_BUDGET_BEAN = PT_AGENT_BUDGET_BEAN;
	}

	// lov for Agency Manager Code
	public List amCodeLov(Object obj) {
		/*
		 * 
		 * Commented By Dhinesh on 03-06-2018 
		 * 
		 * String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE " 
			+ "FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004')) AND CUST_FRZ_FLAG ='N' " 
			+ "AND CUST_AGENT_RANK_CODE IN (SELECT PC_CODE " 
			+ "FROM   PM_CODES WHERE  PC_TYPE  = 'AGNRANK' " 
			+ "AND PC_VALUE  < 2 ) AND ROWNUM < 20 ORDER BY CUST_CODE";*/
		
		/*
		 * modified by Ameen on 17-06-2018 for KIC ,show managers rank agents in lov as per Vaithi sugg.
		 * String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE " 
				+ "FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004')) AND CUST_FRZ_FLAG ='N' " 
				+ "AND CUST_AGENT_RANK_CODE IN (SELECT PC_CODE " 
				+ "FROM   PM_CODES WHERE  PC_TYPE  = 'AGNRANK' " 
				+ "AND PC_VALUE  = 2 ) AND ROWNUM < 20 ORDER BY CUST_CODE";*/
		
		String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE " 
				+ "FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004')) AND CUST_FRZ_FLAG ='N' " 
				+ "AND CUST_AGENT_RANK_CODE IN (SELECT PC_CODE " 
				+ "FROM   PM_CODES WHERE  PC_TYPE  = 'AGNRANK' " 
				+ "AND PC_VALUE  IN (02 , 03 , 04)) AND ROWNUM < 20 ORDER BY CUST_CODE";
	
		List list = new ArrayList();
		ResultSet rs = null;
		
			/*String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER "
					+ "WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE = '002')"
					+ " AND NVL(CUST_FRZ_FLAG,'N') = 'N' AND CUST_AGENT_RANK_CODE = '01' AND ROWNUM < 21 ORDER BY CUST_CODE ASC";*/
			
		Connection con = null;
		CRUDHandler handler = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(obj !=null){
				if (obj.toString().equals("*")) {
					rs = handler.executeSelectStatement(query, con);
					while (rs.next()) {
						PT_AGENT_BUDGET_LOV lovBean = new PT_AGENT_BUDGET_LOV();
						lovBean.setCUST_CODE(rs.getString("CUST_CODE"));
						lovBean.setCUST_NAME(rs.getString("CUST_NAME"));
						list.add(lovBean);
					}
				} else {
					/*
					 * 
					 * commented by Dhinesh on 03-06-2018 
					 * 
					 * String queryCondition = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE " 
						+ "FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004')) " 
						+ "AND CUST_AGENT_RANK_CODE IN (SELECT PC_CODE " 
						+ "FROM   PM_CODES WHERE  PC_TYPE  = 'AGNRANK' " 
						+ "AND PC_VALUE  = < 2) AND CUST_CODE LIKE '%"+obj.toString()+"%' OR CUST_NAME LIKE '%"+obj.toString()+"%' AND ROWNUM < 20 ORDER BY CUST_CODE";*/
					
					/*
					 * modified by Ameen on 17-06-2018 for KIC ,show managers rank agents in lov as per Vaithi sugg.
					 * String queryCondition = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE " 
							+ "FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004')) " 
							+ "AND CUST_AGENT_RANK_CODE IN (SELECT PC_CODE " 
							+ "FROM   PM_CODES WHERE  PC_TYPE  = 'AGNRANK' " 
							+ "AND PC_VALUE  =  2) AND CUST_CODE LIKE '%"+obj.toString()+"%' OR CUST_NAME LIKE '%"+obj.toString()+"%' AND ROWNUM < 20 ORDER BY CUST_CODE";*/
					
					String queryCondition = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CLASS IN (SELECT CCLAS_CODE " 
							+ "FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004')) " 
							+ "AND CUST_AGENT_RANK_CODE IN (SELECT PC_CODE " 
							+ "FROM   PM_CODES WHERE  PC_TYPE  = 'AGNRANK' " 
							+ "AND PC_VALUE  IN (02 , 03 , 04)) AND CUST_CODE LIKE '%"+obj.toString()+"%' OR CUST_NAME LIKE '%"+obj.toString()+"%' AND ROWNUM < 20 ORDER BY CUST_CODE";
					
					rs = handler.executeSelectStatement(queryCondition, con);
					while (rs.next()) {
						PT_AGENT_BUDGET_LOV lovBean = new PT_AGENT_BUDGET_LOV();
						lovBean.setCUST_CODE(rs.getString("CUST_CODE"));
						lovBean.setCUST_NAME(rs.getString("CUST_NAME"));
						list.add(lovBean);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return list;
	}

	// get data after selecting Agency Manager Code LOV
	public void amCodeShow() throws Exception {
		String str = (String) getCOMP_ABGT_AGENT_CODE().getSubmittedValue();
		System.out.println("PT_AGENT_BUDGET_ACTION.amCodeShow......---" + str);
		String query2 = "SELECT A.ABGT_AGENT_CODE,A.ABGT_MODULE_ID,A.ABGT_NO_OF_POL,A.ABGT_LC_PREM,A.ABGT_FM_DT,"
				+ "A.ABGT_TO_DT,C.CUST_NAME FROM PT_AGENT_BUDGET A,PM_CUSTOMER C "
				+ "WHERE A.ABGT_AGENT_CODE = '"
				+ str
				+ "' AND C.CUST_CODE='"
				+ str + "'";

		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs2 = handler.executeSelectStatement(query2, con);
		while (rs2.next()) {
			getCOMP_UI_M_ABGT_AGENCY_CODE().setSubmittedValue(getCOMP_ABGT_AGENT_CODE().getSubmittedValue());
			getCOMP_UI_M_ABGT_AGENCY_NAME().setSubmittedValue(rs2.getString("CUST_NAME"));
			getCOMP_ABGT_MODULE_ID().setSubmittedValue(rs2.getString("ABGT_MODULE_ID"));
			getCOMP_ABGT_LC_PREM().setSubmittedValue(String.valueOf(rs2.getDouble("ABGT_LC_PREM")));
			getCOMP_ABGT_NO_OF_POL().setSubmittedValue(String.valueOf(rs2.getDouble("ABGT_NO_OF_POL")));
			getCOMP_ABGT_FM_DT().setSubmittedValue(rs2.getDate("ABGT_FM_DT"));
			getCOMP_ABGT_TO_DT().setSubmittedValue(rs2.getDate("ABGT_TO_DT"));
		}
	}

	/**
	 * 
	 * @return
	 */
	public String saveRecord() {
		String message = null;
		/*added by Ameen on 18-06-2018 for agent setup validation*/
		String existAgent = "SELECT 'X' FROM PT_AGENT_BUDGET WHERE ABGT_AGENT_CODE = ? AND ((? BETWEEN ABGT_FM_DT "
						+ "AND ABGT_TO_DT AND ? BETWEEN ABGT_FM_DT AND ABGT_TO_DT) OR (? "
						+ "BETWEEN ABGT_FM_DT AND ABGT_TO_DT OR ? BETWEEN ABGT_FM_DT AND ABGT_TO_DT))";
		ResultSet rs = null;
		/*End*/
		try {
			/*added by Ameen on 18-06-2018 for agent setup validation*/
			rs = new CRUDHandler().executeSelectStatement(existAgent, CommonUtils.getConnection(), 
											new Object[]{PT_AGENT_BUDGET_BEAN.getABGT_AGENT_CODE(),PT_AGENT_BUDGET_BEAN.getABGT_FM_DT(),
														 PT_AGENT_BUDGET_BEAN.getABGT_TO_DT(),PT_AGENT_BUDGET_BEAN.getABGT_FM_DT(),
														 PT_AGENT_BUDGET_BEAN.getABGT_TO_DT()});
			if(rs.next()){
				throw new Exception("Setup Already Exists");
			}
			/*End*/
			if (PT_AGENT_BUDGET_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					preUpdate();
					new CRUDHandler().executeInsert(PT_AGENT_BUDGET_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$update");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("UPDATE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$updatenotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("UPDATE", message);
				}
			} else {
				if (isINSERT_ALLOWED()) {
					preInsert();
					new CRUDHandler().executeInsert(PT_AGENT_BUDGET_BEAN,
							CommonUtils.getConnection());
						CommonUtils.getConnection().commit();

					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
				} else {
					message = Messages.getString("messageProperties",
							"errorPanel$message$insertnotallowed");
					getErrorMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getErrorMap().put("SAVE", message);
				}
			}

		} catch (Exception e) {
			try {
				CommonUtils.getConnection().commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}

		return null;
	}

	// SAVE AND NEXT
	public String saveNextRecord() throws Exception {
		System.out
				.println("++++++++PT_AGENT_BUDGET_ACTION.SaveNextRecord()+++++++++");
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		if (PT_AGENT_BUDGET_BEAN.getROWID() == null) {
			preInsert();
			handler.executeInsert(getPT_AGENT_BUDGET_BEAN(), connection);
		} else {
			preUpdate();
			handler.executeUpdate(getPT_AGENT_BUDGET_BEAN(), connection);
		}
		connection.commit();
		return "NAVIGATE_TO_AGENT_BUDGET_RANK";
	}

	public String deleteRecord() {
		String message = null;

		try {
			if (isDELETE_ALLOWED()) {
				if (PT_AGENT_BUDGET_BEAN.getROWID() != null) {
					preDelete();
					new CRUDHandler().executeDelete(PT_AGENT_BUDGET_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
				}

				PT_AGENT_BUDGET_BEAN = new PT_AGENT_BUDGET();
				message = Messages.getString("messageProperties",
						"errorPanel$message$delete");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getWarningMap().put("DELETE", message);
			} else {
				message = Messages.getString("messageProperties",
						"errorPanel$message$deletenotallowed");
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						message);
				getErrorMap().put("DELETE", message);
			}

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
		}

		return null;
	}

	public List<SelectItem> getABGT_MODULE_ID_LIST() throws DBException {
		if (ABGT_MODULE_ID_LIST.size() == 0) {
			ABGT_MODULE_ID_LIST.clear();
			ABGT_MODULE_ID_LIST = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PT051_A", "PT_AGENT_BUDGET",
					"PT_AGENT_BUDGET.ABGT_MODULE_ID", null);
		}
		return ABGT_MODULE_ID_LIST;
	}

	public void setABGT_MODULE_ID_LIST(List<SelectItem> abgt_module_id_list) {
		ABGT_MODULE_ID_LIST = abgt_module_id_list;
	}

	// INSERT NAVIGATION
	/*public String insertNavigation() throws Exception {
		System.out.println("PT_AGENT_BUDGET_ACTION.insertNavigation()");
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();
		PT_AGENT_BUDGET_ACTION budgetAction = new PT_AGENT_BUDGET_ACTION();
		sessionMap.put("PT051_A_PT_AGENT_BUDGET_ACTION", budgetAction);

		PT_AGENT_BUDGET_RANK_ACTION rankAction = new PT_AGENT_BUDGET_RANK_ACTION();
		sessionMap.put("PT051_A_PT_AGENT_BUDGET_RANK_ACTION", rankAction);

		PT_AGENT_BUDGET_BREAKUP_ACTION breakupAction = new PT_AGENT_BUDGET_BREAKUP_ACTION();
		sessionMap.put("PT051_A_PT_AGENT_BUDGET_BREAKUP_ACTION", breakupAction);
		whenCreateRecord();

		return "NAVIGATE_TO_AGENT_BUDGET";
	}*/

	/** *************** FForm Triggers START ************************************ */
	
	public void onLoad(PhaseEvent ae) throws Exception {
		try{
			if(isFormFlag()){
				preForm();
				setFormFlag(false);
			}
			if(isBlockFlag()){
				preBlock();
				whenNewBlockInstance();
				executeQuery();
				if(PT_AGENT_BUDGET_BEAN.getROWID()!=null){
					//postQuery(agentCode);
				}else{
					whenCreateRecord();
				}
				setBlockFlag(false);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}
	public void preForm() throws Exception {
		System.out.println("PT_AGENT_BUDGET_ACTION.preForm()---------START");
		
		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		DBProcedures procedures = new DBProcedures();
		
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
		CommonUtils.setGlobalVariable("DUMMY.PT_AGENT_BUDGET_CF", "P");
		CommonUtils.setGlobalVariable("DUMMY.PT_AGENT_BUDGET_RANK_CF", "N");
		CommonUtils.setGlobalVariable("DUMMY.PT_AGENT_BUDGET_BREAKUP_CF", "N");
		try{
			
			ArrayList<String> list = procedures.helperF_GET_BASE_CURRENCY(CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N", P_CURR_CODE, P_NAME, P_DECIMAL+"", "E");
			if(list!= null && list.size()>0){
				P_CURR_CODE = list.get(0);
				P_NAME = list.get(1);
				P_DECIMAL = CommonUtils.parseToInt(list.get(2));
				CommonUtils.setGlobalVariable("DUMMY.M_BASE_CURR", P_CURR_CODE);
//				getSessionMap().put("DUMMY.M_BASE_CURR", P_CURR_CODE);
			}
			if(list!= null && list.size()>0){
				//getSessionMap().put("DUMMY.M_BASE_CURR", list.get(0));
				CommonUtils.setGlobalVariable("DUMMY.M_BASE_CURR", list.get(0));
			}
		}catch(Exception exception){
			throw exception;
		}
	}

	/*public void STD_PRE_FORM() {
		System.out.println("PT_AGENT_BUDGET_ACTION.STD_PRE_FORM()");
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PROG_NAME("PT051_A");
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
	}*/

	/*public void whenNewFormInstance() {
		System.out.println("PT_AGENT_BUDGET_ACTION.whenNewFormInstance()");
		// NULL;
	}*/

	public void onClearDetails() {
		System.out.println("PT_AGENT_BUDGET_ACTION.onClearDetails()");
		// BEGIN Clear_details; END;
	}

	/** *************** Block Triggers START ************************************ */

	public void preBlock() {
		System.out.println("PT_AGENT_BUDGET_ACTION.preBlock()");
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "N");
	}

	public void whenCreateRecord() {
		System.out.println("PT_AGENT_BUDGET_ACTION.whenCreateRecord()");
		PT_AGENT_BUDGET_BEAN.setABGT_MODULE_ID("IL");
		COMP_ABGT_MODULE_ID.resetValue();
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	public void preInsert() throws Exception {
		System.out.println("PT_AGENT_BUDGET_ACTION.preInsert()");
		String str = null;
		ResultSet rsSys = null;
		try{
			L_BUDGET_OVERLAP_CHK();
			
			rsSys = getHandler().executeSelectStatement("SELECT PAG_ABGT_SYS_ID.NEXTVAL FROM DUAL", CommonUtils.getConnection());
			if (rsSys.next()) {
				str = rsSys.getString(1);
				PT_AGENT_BUDGET_BEAN.setABGT_SYS_ID(rsSys.getDouble(1));
			}
			
			//FacesContext context = FacesContext.getCurrentInstance();
			//Map<String, Object> map = context.getExternalContext().getSessionMap();
			CommonUtils.setGlobalVariable("ABGT_SYS_ID", str);
						
			PT_AGENT_BUDGET_BEAN.setABGT_CR_DT(new Date());
			PT_AGENT_BUDGET_BEAN.setABGT_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN", getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID()+"");
			paramList.add(param1);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			procHandler.execute(paramList, CommonUtils.getConnection(), "P9ILPK_AGENCY_BUDGET.INS_AGENT_BUDGET_RANK_REC");

		}catch(Exception e){
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(), FacesContext.getCurrentInstance(), "PT051_A", getErrorMap(), getWarningMap());
			e.printStackTrace();
			throw e;
		}finally{
			CommonUtils.closeCursor(rsSys);
		}
	}

	public void L_BUDGET_OVERLAP_CHK() throws ValidatorException{
		String cursor1Query = "SELECT 'X' FROM PT_AGENT_BUDGET " +
				"WHERE (( NVL (?,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(ABGT_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(ABGT_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR " +
				"( NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(ABGT_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(ABGT_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR " +
				"( NVL (PT_AGENT_BUDGET.ABGT_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR " +
				"( NVL (PT_AGENT_BUDGET.ABGT_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				") " +
				"AND ABGT_AGENT_CODE = ? ";
		
		String cursor2Query = "SELECT 'X' FROM PT_AGENT_BUDGET " +
				"WHERE (( NVL (?,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(ABGT_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(ABGT_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR " +
				"( NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(ABGT_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(ABGT_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR " +
				"( NVL (PT_AGENT_BUDGET.ABGT_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				"OR " +
				"( NVL (PT_AGENT_BUDGET.ABGT_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) BETWEEN NVL(?,TO_DATE('01/01/1900','DD/MM/RRRR')) AND NVL(?,TO_DATE('31/12/2999','DD/MM/RRRR'))) " +
				") " +
				"AND ABGT_AGENT_CODE = ? " +
				"AND ROWID != ?";
		ResultSet rsC1 = null, rsC2 = null;
		try{
			if("INSERT".equalsIgnoreCase(CommonUtils.getGlobalVariable("PT051_A_MODE"))){
					Object[] values1 = {getPT_AGENT_BUDGET_BEAN().getABGT_FM_DT(), getPT_AGENT_BUDGET_BEAN().getABGT_TO_DT(), 
							            getPT_AGENT_BUDGET_BEAN().getABGT_FM_DT(), getPT_AGENT_BUDGET_BEAN().getABGT_TO_DT(),
							            getPT_AGENT_BUDGET_BEAN().getABGT_FM_DT(), getPT_AGENT_BUDGET_BEAN().getABGT_TO_DT(),
							            getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE()};
					rsC1 = getHandler().executeSelectStatement(cursor1Query, CommonUtils.getConnection(), values1);
					if(rsC1.next()){
						/*getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91278").getSummary());
						getErrorMap().put("details", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91278").getSummary());*/
						throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91278"));
					}
			}else{
				/*ELSIF :SYSTEM.RECORD_STATUS = 'CHANGED' THEN
			      FOR CUR_REC IN C3
			      LOOP	    	       	  
			      IF C3%FOUND THEN    	
			         STD_MESSAGE_ROUTINE(91278,:CTRL.M_LANG_CODE);
			         RAISE FORM_TRIGGER_FAILURE;
			      END IF;
			      END LOOP;
			   END IF;*/
				Object[] values2 = {getPT_AGENT_BUDGET_BEAN().getABGT_FM_DT(), getPT_AGENT_BUDGET_BEAN().getABGT_TO_DT(), 
									getPT_AGENT_BUDGET_BEAN().getABGT_FM_DT(), getPT_AGENT_BUDGET_BEAN().getABGT_TO_DT(),
									getPT_AGENT_BUDGET_BEAN().getABGT_FM_DT(), getPT_AGENT_BUDGET_BEAN().getABGT_TO_DT(),
									getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE(), getPT_AGENT_BUDGET_BEAN().getROWID()};
				rsC2 = getHandler().executeSelectStatement(cursor2Query, CommonUtils.getConnection(), values2);
				if(rsC2.next()){
					/*getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91278").getSummary());
					getErrorMap().put("details", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91278").getSummary());*/
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91278"));
				}
			}
		}catch(ValidatorException ve){
			ve.printStackTrace();
			throw ve;
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch(DBException dbe){
			dbe.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rsC1);
				CommonUtils.closeCursor(rsC2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void preUpdate() {
		System.out.println("PT_AGENT_BUDGET_ACTION.preUpdate()");
		L_BUDGET_OVERLAP_CHK(); //commented as in Form Code this check is not happening on pre-update --Varun[50663]
		PT_AGENT_BUDGET_BEAN.setABGT_UPD_DT(new Date());
		PT_AGENT_BUDGET_BEAN.setABGT_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	
	/**
	 * 
	 */
	public void executeQuery(){
			System.out.println("Parameter ROWID = "+PT_AGENT_BUDGET_BEAN.getROWID());
			ResultSet rs1 = null;
			try{
				String selectQuery1 = "SELECT ROWID, PT_AGENT_BUDGET.* FROM PT_AGENT_BUDGET WHERE ROWID LIKE ?";
				rs1 = getHandler().executeSelectStatement(selectQuery1, CommonUtils.getConnection(),new Object[]{PT_AGENT_BUDGET_BEAN.getROWID()});
				while(rs1.next()){
					PT_AGENT_BUDGET_BEAN = new PT_AGENT_BUDGET();
					PT_AGENT_BUDGET_BEAN.setROWID(rs1.getString("ROWID"));
					PT_AGENT_BUDGET_BEAN.setABGT_AGENT_CODE(rs1.getString("ABGT_AGENT_CODE"));
					PT_AGENT_BUDGET_BEAN.setABGT_MODULE_ID(rs1.getString("ABGT_MODULE_ID"));
					PT_AGENT_BUDGET_BEAN.setABGT_NO_OF_POL(rs1.getLong("ABGT_NO_OF_POL"));
					PT_AGENT_BUDGET_BEAN.setABGT_LC_PREM(rs1.getDouble("ABGT_LC_PREM"));
					PT_AGENT_BUDGET_BEAN.setABGT_FM_DT(rs1.getDate("ABGT_FM_DT"));
					PT_AGENT_BUDGET_BEAN.setABGT_TO_DT(rs1.getDate("ABGT_TO_DT"));
					PT_AGENT_BUDGET_BEAN.setABGT_SYS_ID(rs1.getDouble("ABGT_SYS_ID"));
					PT_AGENT_BUDGET_BEAN.setABGT_CR_DT(rs1.getDate("ABGT_CR_DT"));
					PT_AGENT_BUDGET_BEAN.setABGT_CR_UID(rs1.getString("ABGT_CR_UID"));
					postQuery();
				}
				CommonUtils.setGlobalVariable("PT051_A_MODE", "QUERY_UPDATE");
			}catch(Exception e){
				e.printStackTrace();
			}
	}
	
	/**
	 * 
	 * @param agentCode
	 * @throws Exception
	 */
	public void postQuery() throws Exception {
		System.out.println("PT_AGENT_BUDGET_ACTION.postQuery()");
		String M_CUST_AGENCY_CODE = "";
		ResultSet rsC1 = null, rsC2 = null;
		try{
			String sql_C1 = "SELECT CUST_NAME, CUST_AGENCY_CODE FROM PM_CUSTOMER WHERE CUST_CODE = ?";
			String sql_C2 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
			Object[] values1 ={PT_AGENT_BUDGET_BEAN.getABGT_AGENT_CODE()};
			rsC1 = getHandler().executeSelectStatement(sql_C1, CommonUtils.getConnection(), values1);
			if(rsC1.next()){
				PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENT_NAME(rsC1.getString(1));
				M_CUST_AGENCY_CODE = rsC1.getString(2);
			}

			
			Object[] values2 ={M_CUST_AGENCY_CODE};
			rsC2 = getHandler().executeSelectStatement(sql_C2, CommonUtils.getConnection(), values2);
			if(rsC2.next()){
				getPT_AGENT_BUDGET_BEAN().setUI_M_ABGT_AGENCY_NAME(rsC1.getString(1));
			}

			if (M_CUST_AGENCY_CODE == null) {
				PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENCY_CODE(PT_AGENT_BUDGET_BEAN.getABGT_AGENT_CODE());
				PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENCY_NAME(PT_AGENT_BUDGET_BEAN.getUI_M_ABGT_AGENT_NAME());
			} else {
				PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENCY_CODE(M_CUST_AGENCY_CODE);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(rsC1);
			CommonUtils.closeCursor(rsC2);
		}
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
	
	public void whenNewBlockInstance() {
		System.out.println("PT_AGENT_BUDGET_ACTION.whenNewBlockInstance()");
	}

	/*public void onPopulateDetails() throws Exception {
		System.out.println("PT_AGENT_BUDGET_ACTION.onPopulateDetails()");
	}*/

	public void preDelete() throws Exception {
		System.out.println("PT_AGENT_BUDGET_ACTION.preDelete()");
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		String deleteQuery1 = "DELETE FROM PT_AGENT_BUDGET_RANK WHERE ABGTR_ABGT_SYS_ID ='"
				+ PT_AGENT_BUDGET_BEAN.getABGT_SYS_ID() + "' ";
		String deleteQuery2 = "DELETE FROM PT_AGENT_BUDGET_BREAKUP WHERE ABGTB_ABGT_SYS_ID ='"
				+ PT_AGENT_BUDGET_BEAN.getABGT_SYS_ID() + "'";
		handler.executeDeleteStatement(deleteQuery1, connection);
		handler.executeDeleteStatement(deleteQuery2, connection);
		connection.commit();

	}

	/**
	 * *************** Field(ITEM)Triggers START
	 * ************************************
	 */

	public void ABGT_AGENT_CODE_WhenValidateItem(ActionEvent event){
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGTR_AGENT_CODE_WhenValidateItem()...");
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void ABGT_AGENT_CODE_Validator(FacesContext context, UIComponent component, Object value) throws Exception {
		PT_AGENT_BUDGET_BEAN.setABGT_AGENT_CODE((String)value);
		Double M_MIN_PC_VALUE = null, M_AGENT_RANK_LEVEL = null;
		String M_CUST_AGENT_RANK_CODE = null, M_CUST_AGENCY_CODE = null, M_CUST_NAME = null, 
		       M_AGENCY_NAME = null;
		ResultSet vembu_C1 = null, vembu_C2 = null, vembu_C3 = null, vembu_C4 = null, vembu_C5 = null; 
		          /*,rs = null;*/
		
		/*
		 * modified by Ameen on 17-06-2018 for KIC ,to add manager agents also as per Vaithi sugg.
		 * String sql_C1 = "SELECT MIN(PC_VALUE) FROM PM_CODES WHERE  PC_TYPE = 'AGNRANK'";*/
		
		String sql_C1 = "SELECT MAX(PC_VALUE) FROM PM_CODES WHERE  PC_TYPE = 'AGNRANK'";
		
		String sql_C2 = "SELECT CUST_AGENT_RANK_CODE FROM PM_CUSTOMER " +
				        "WHERE  CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE = '002') " +
				        "AND    NVL(CUST_FRZ_FLAG,'N') = 'N' " +
				        "AND    NVL(CUST_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) >= SYSDATE " +
				        "AND    CUST_CODE = ? AND NVL(CUST_STATUS,'A') = 'A'";

		String sql_C3 = "SELECT CUST_NAME, CUST_AGENCY_CODE FROM PM_CUSTOMER " +
				        "WHERE  CUST_CODE = ?";

		String sql_C4 = "SELECT CUST_NAME FROM PM_CUSTOMER " +
				        "WHERE CUST_CODE = ? AND CUST_STATUS = 'A' AND NVL(CUST_FRZ_FLAG,'N') = 'N'";
		
		String sql_C5 = "SELECT PC_VALUE FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' AND PC_CODE = ?";

		try{
			if(CommonUtils.getCurrentValue(getCOMP_ABGT_AGENT_CODE()) != null){
				
				String agentCode = (String) getCOMP_ABGT_AGENT_CODE().getSubmittedValue();
				PT_AGENT_BUDGET_BEAN.setABGT_AGENT_CODE(agentCode);
				
				vembu_C1 = getHandler().executeSelectStatement(sql_C1, CommonUtils.getConnection());
				if (vembu_C1.next()) {
					M_MIN_PC_VALUE = vembu_C1.getDouble(1);
				}

				Object[] values2 = {agentCode};
				vembu_C2 = getHandler().executeSelectStatement(sql_C2, CommonUtils.getConnection(),values2);
				if (vembu_C2.next()) {
					M_CUST_AGENT_RANK_CODE = vembu_C2.getString(1);
				}
				
				Object[] values3 = {agentCode};
				vembu_C3 = getHandler().executeSelectStatement(sql_C3, CommonUtils.getConnection(),values3);
				if (vembu_C3.next()) {
					M_CUST_NAME = vembu_C3.getString(1);
					M_CUST_AGENCY_CODE = vembu_C3.getString(2);
				}

				PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENT_NAME(M_CUST_NAME);
				
				
				Object[] values5 = {M_CUST_AGENT_RANK_CODE};
				vembu_C5 = getHandler().executeSelectStatement(sql_C5, CommonUtils.getConnection(),values5);
				if (vembu_C5.next()) {
					M_AGENT_RANK_LEVEL = vembu_C5.getDouble(1);
				}
				
				if(MigratingFunctions.nvl(M_AGENT_RANK_LEVEL, 4.0) > MigratingFunctions.nvl(M_MIN_PC_VALUE, 1.0)){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91275"));
				}
				
				if(M_CUST_AGENCY_CODE == null){
					PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENCY_CODE(getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE());
					
					
					PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENCY_NAME(getPT_AGENT_BUDGET_BEAN().getUI_M_ABGT_AGENT_NAME());
					getCOMP_UI_M_ABGT_AGENCY_NAME().resetValue();					
				}else{
					Object[] values4 = {M_CUST_AGENCY_CODE};
					vembu_C4 = getHandler().executeSelectStatement(sql_C4, CommonUtils.getConnection(),values4);
					if (vembu_C4.next()) {
						M_AGENCY_NAME = vembu_C4.getString(1);
					}
					PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENCY_CODE(M_CUST_AGENCY_CODE);
					PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENCY_NAME(M_AGENCY_NAME);
				}
				
				COMP_UI_M_ABGT_AGENCY_CODE.setSubmittedValue(PT_AGENT_BUDGET_BEAN.getUI_M_ABGT_AGENCY_CODE());
				COMP_UI_M_ABGT_AGENCY_NAME.setSubmittedValue(PT_AGENT_BUDGET_BEAN.getUI_M_ABGT_AGENT_NAME());

				COMP_UI_M_ABGT_AGENCY_CODE.resetValue();
				COMP_UI_M_ABGT_AGENT_NAME.resetValue();
			}
		}/*catch(ValidatorException vexc){
			throw vexc;
		}*/catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}finally{
			try {
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
				CommonUtils.closeCursor(vembu_C3);
				CommonUtils.closeCursor(vembu_C4);
				CommonUtils.closeCursor(vembu_C5);
//				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void ABGT_MODULE_ID_WhenValidateItem(ActionEvent event) throws Exception {
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGT_MODULE_ID_WhenValidateItem()...");
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void ABGT_MODULE_ID_Validator(FacesContext context, UIComponent component, Object value) throws Exception {
		PT_AGENT_BUDGET_BEAN.setABGT_MODULE_ID((String)value);
		System.out.println("PT_AGENT_BUDGET_ACTION.ABGT_MODULE_ID_WhenValidateItem()");
		Integer M_PS_VALUE = 0;
		String M_CODE_DESC = null;
		try{
			if(CommonUtils.getCurrentValue(getCOMP_ABGT_MODULE_ID())!= null){
				getPT_AGENT_BUDGET_BEAN().setABGT_MODULE_ID(CommonUtils.getCurrentValue(getCOMP_ABGT_MODULE_ID()).toString());
				L_VAL_SYSTEM("LIMODCODES",PT_AGENT_BUDGET_BEAN.getABGT_MODULE_ID(),M_CODE_DESC,"E",M_PS_VALUE);
				
				if(PT_AGENT_BUDGET_BEAN.getABGT_MODULE_ID() == null){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "20326"));
				}
			}
		}catch(ValidatorException vexc){
			throw vexc;
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		/*
		 * Connection connection=CommonUtils.getConnection(); String
		 * M_PS_VALUE=null; String M_CODE_DESC=null;
		 * 
		 * ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		 * ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		 * paramList.add(new OracleParameter("in1","STRING","IN",
		 * "LIMODCODES")); paramList.add(new
		 * OracleParameter("in2","STRING","IN",
		 * PT_AGENT_BUDGET_BEAN.getABGT_MODULE_ID())); paramList.add(new
		 * OracleParameter("in3","STRING","IN OUT", M_CODE_DESC));
		 * paramList.add(new OracleParameter("in4","STRING","IN", "E"));
		 * paramList.add(new OracleParameter("in5","STRING","IN OUT",
		 * M_PS_VALUE)); OracleProcedureHandler ora_Handler = new
		 * OracleProcedureHandler(); try { list = ora_Handler.execute(paramList,
		 * connection, "L_VAL_SYSTEM"); System.out.println("NO OF
		 * LIST>>>>>>>---"+list.get(0)); } catch (SQLException e) {
		 * e.printStackTrace(); }
		 * 
		 * if(PT_AGENT_BUDGET_BEAN.getABGT_MODULE_ID() == null)
		 * getErrorMap().put("current",Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91275").getDetail());
		 */
	}
	
	private ArrayList<Object> L_VAL_SYSTEM(String P_TYPE, String P_CODE, String P_CODE_DESC, String P_ERR_FLAG, int P_VALUE) 
	throws Exception{
		
		ResultSet resultSet = null;
		String message = null;

		String M_NAME = null;
		String M_BL_NAME = null;
		int M_VALUE = -1;
		ArrayList<Object> resultList = null;
		Object[] values = {P_TYPE, P_CODE};
		String query = "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE  = ? " +
		"AND PS_CODE  = ?";
		try{
			resultSet = getHandler().executeSelectStatement(query, CommonUtils.getConnection(), values);
			if(resultSet.next()){
				M_NAME = resultSet.getString("PS_CODE_DESC");
				M_BL_NAME = resultSet.getString("PS_BL_CODE_DESC");
				M_VALUE = resultSet.getInt("PS_VALUE");
			}else{
				if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)){
					/*message = Messages.getString(PELConstants.pelErrorMessagePath, "1000", new String[]{P_TYPE, P_CODE} );
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);*/
					if("E".equals(P_ERR_FLAG)){
						throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1000"));
					}
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "1000"));
				}
			}
			ControlBean controlBean=CommonUtils.getControlBean();
//			if("ENG".equals(CommonUtils.getGlobalVariable("M_LANG_CODE")) || 
//			"1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").substring(4, 5))){
			if("ENG".equals(controlBean.getM_LANG_CODE())){			
				P_CODE_DESC = M_NAME;
			}
			else{
				P_CODE_DESC = M_BL_NAME;
			}

			/*if("1".equals(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").substring(4, 5))
		|| "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))){
	P_CODE_DESC = M_NAME;
}else{
	P_CODE_DESC = M_BL_NAME;
}*/

			P_VALUE = M_VALUE;

			resultList = new ArrayList<Object>();
			resultList.add(P_CODE_DESC);
			resultList.add(P_VALUE);
		}catch(ValidatorException ve){
			ve.printStackTrace();
			throw ve;
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch(DBException dbe){
			dbe.printStackTrace();
		}finally{
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(Exception e){
				e.printStackTrace();
			}
		}

		return resultList;
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 */
	public void ABGT_LC_PREM_WhenValidateItem(FacesContext context, UIComponent component, Object value){
		PT_AGENT_BUDGET_BEAN.setABGT_LC_PREM((Double)value);

		try {
			if(value != null){
				String P_CURR_CODE = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("DUMMY.M_BASE_CURR").toString();
				proc_L_VAL_ROUND_AMT(P_CURR_CODE, getPT_AGENT_BUDGET_BEAN().getABGT_LC_PREM(), "V");
			}
		} catch (Exception exc) {
			getErrorMap().put("current",  Messages.getString("messageProperties_PT051_A", "PT051_A$PT_AGENT_BUDGET$ABGT_LC_PREM$numbermessage"));
			throw new ValidatorException(new FacesMessage(exc.getMessage()));
		}
	}

		/**
		 * 
		 * @param context
		 * @param component
		 * @param value
		 */
		public void noOfAgentPolicy_WhenValidateItem(FacesContext context, UIComponent component, Object value){
			try {
				if(value != null){
					PT_AGENT_BUDGET_BEAN.setABGT_NO_OF_POL((Long)value);
					
					if(PT_AGENT_BUDGET_BEAN.getABGT_NO_OF_POL() < 0){
						throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91341"));
					}
					
				}
			} catch (Exception exc) {
				getErrorMap().put("current",  Messages.getString("messageProperties_PT051_A", "PT051_A$PT_AGENT_BUDGET$ABGT_LC_PREM$numbermessage"));
				throw new ValidatorException(new FacesMessage(exc.getMessage()));
			}

		}
		
	public void ABGT_FM_DT_WhenValidateItem(ActionEvent ae) {
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGT_MODULE_ID_WhenValidateItem()...");
		UIInput input = (UIInput)ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void ABGT_FM_DT_Validator(FacesContext context, UIComponent component, Object value) throws Exception {
		try{
			PT_AGENT_BUDGET_BEAN.setABGT_FM_DT((Date)value);
			Date fromDate=((UICalendar)getCOMP_ABGT_FM_DT()).getAsDate(getCOMP_ABGT_FM_DT().getSubmittedValue());
			
			if((CommonUtils.nvl(fromDate, new Date("01/01/1999")).before(new Date("01/01/1900"))) ||
					(CommonUtils.nvl(fromDate, new Date("01/01/1999")).after(new Date("31/12/2999")))){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91063"));
			}
			
			if(CommonUtils.nvl(fromDate, new Date("01/01/1999")).after(CommonUtils.nvl(getPT_AGENT_BUDGET_BEAN().getABGT_TO_DT(), new Date("31/12/2999")))){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91010"));
			}
			
			if(fromDate != null){
				PT_AGENT_BUDGET_BEAN.setABGT_TO_DT(CommonUtils.addMonthsToDate(fromDate, 12));
			}
			
		}catch(ValidatorException ve){
			throw ve;
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Date stringToUtilDate(String stringDate){
		java.util.Date date = null;
		try {
			date = new SimpleDateFormat(PELConstants.pelDateFormat).parse(stringDate);
		}catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	
	
	/*public void ABGT_FM_DT_WhenValidateItem(ActionEvent ae)	throws ParseException, Exception {
		System.out.println("PT_AGENT_BUDGET_ACTION.ABGT_FM_DT_WhenValidateItem()-"+ PT_AGENT_BUDGET_BEAN.getABGT_FM_DT());
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();

		if (PT_AGENT_BUDGET_BEAN.getABGT_FM_DT() == null) {
			ResultSet rsDate = handler.executeSelectStatement(
					"SELECT SYSDATE FROM DUAL", connection);
			if (rsDate.next()) {
				getCOMP_ABGT_FM_DT().setSubmittedValue(rsDate.getDate(1));
				PT_AGENT_BUDGET_BEAN.setABGT_FM_DT(rsDate.getDate(1));
			}
		}
		Date fromDate = PT_AGENT_BUDGET_BEAN.getABGT_FM_DT();
		if (!(PT_AGENT_BUDGET_BEAN.getABGT_FM_DT() == null)) {
			PT_AGENT_BUDGET_BEAN.setABGT_TO_DT(date_plus(fromDate));
		}
	}*/

	public void ABGT_TO_DT_WhenValidateItem(ActionEvent ae) {
		System.out.println("PT_AGENT_BUDGET_RANK_ACTION.ABGT_MODULE_ID_WhenValidateItem()...");
		UIInput input = (UIInput)ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void ABGT_TO_DT_Validator(FacesContext context, UIComponent component, Object value) throws Exception {
		PT_AGENT_BUDGET_BEAN.setABGT_TO_DT((Date)value);
		System.out.println("PT_AGENT_BUDGET_ACTION.ABGT_TO_DT_WhenValidateItem()-"+getCOMP_ABGT_TO_DT().getSubmittedValue());
		try{
			Date toDate=((UICalendar)getCOMP_ABGT_TO_DT()).getAsDate(getCOMP_ABGT_TO_DT().getSubmittedValue());
			if(toDate != null){
				if((CommonUtils.nvl(toDate, new Date("31/12/2999")).before(new Date("01/01/1900")))
				   || (CommonUtils.nvl(toDate, new Date("31/12/2999")).after(new Date("31/12/2999")))){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91063"));
				}
				
				if((CommonUtils.nvl(toDate, new Date("01/01/1999"))).before(CommonUtils.nvl(getPT_AGENT_BUDGET_BEAN().getABGT_FM_DT(), new Date("01/01/1999")))){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91001"));
				}
				
			}
		}catch(ValidatorException ve){
			throw ve;
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public boolean compare_Date(Date from_Date, Date to_Date) {
		boolean status = false;
		if (from_Date != null && to_Date != null) {
			if (from_Date.compareTo(to_Date) <= 0) {
				status = true;
			}
		}
		return status;
	}

	public String date_Format(Date date) {
		String result = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			result = sdf.format(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// Method which returns date( +1 year)
	public Date date_plus(Date date) throws ParseException {
		DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
		String str1 = df.format(date);
		String str2 = str1.substring(0, str1.lastIndexOf("-") + 1);
		String splitStr1 = str1.substring(str1.lastIndexOf("-") + 1);
		int modYear = Integer.parseInt(splitStr1) + 1;
		Date finalDate = df.parse(str2.concat(String.valueOf(modYear)));
		return finalDate;
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}
	
	 public Double proc_L_VAL_ROUND_AMT(String P_CURR_CODE,Double P_AMT,String P_VAL_ROUND) throws Exception{
	        
	        ResultSet resultSet = null;
	        int M_DECIMAL = 0;
	        
	        try{
	            String sql_C1="SELECT CURR_DECIMAL FROM FM_CURRENCY WHERE CURR_CODE = ? ";
	            Object[] values = {P_CURR_CODE};
	            resultSet = getHandler().executeSelectStatement(sql_C1, CommonUtils.getConnection(), values);
	            if(resultSet.next()){
	            	M_DECIMAL = resultSet.getInt(1);
	            }else{
	            	M_DECIMAL = 2;
	            }
	            
	            if("V".equals(P_VAL_ROUND)){
	                if(!P_AMT.equals(CommonUtils.ROUND(P_AMT,M_DECIMAL))){
	                    //DISP_ALERT.DISP_ALERT(NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"));
	                    //throw new FORM_TRIGGER_FAILURE();
	                	throw new Exception();
	                }
	            }else{
	                P_AMT = CommonUtils.ROUND(P_AMT, M_DECIMAL);
	            }
	        }catch(Exception e){
	            e.printStackTrace();
	            throw e;
	        }finally{
	            try{
	            	CommonUtils.closeCursor(resultSet);
	            }catch (Exception e) {
					e.printStackTrace();
				}
	        }
	        return P_AMT;
	    }

	 public void No_Of_POLICIES_WhenValidateItem(FacesContext context, UIComponent component, Object value){
			try {
				if(value != null){
					PT_AGENT_BUDGET_BEAN.setABGT_NO_OF_POL((Long)value);
					
					if(PT_AGENT_BUDGET_BEAN.getABGT_NO_OF_POL() < 0){
						throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91341"));
					}
					
				}
			} catch (Exception exc) {
				getErrorMap().put("current",  Messages.getString("messageProperties_PT051_A", "PT051_A$PT_AGENT_BUDGET$ABGT_LC_PREM$numbermessage"));
				throw new ValidatorException(new FacesMessage(exc.getMessage()));
			}

		}
	 
	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
}
