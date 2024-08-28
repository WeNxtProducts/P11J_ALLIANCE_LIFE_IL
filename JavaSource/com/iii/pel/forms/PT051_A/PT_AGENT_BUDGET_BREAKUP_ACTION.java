package com.iii.pel.forms.PT051_A;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;
import com.iii.premia.runtime.functions.NumericFunctions;

public class PT_AGENT_BUDGET_BREAKUP_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_ABGTB_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ABGTB_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_ABGTB_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ABGTB_AGENT_NAME;

	private HtmlOutputLabel COMP_ABGTB_SHARE_PERC_LABEL;

	private HtmlInputText COMP_ABGTB_SHARE_PERC;

	private HtmlOutputLabel COMP_ABGTB_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ABGTB_NO_OF_POL;

	private HtmlOutputLabel COMP_ABGTB_LC_PREM_LABEL;

	private HtmlInputText COMP_ABGTB_LC_PREM;

	private HtmlOutputLabel COMP_ABGTB_ACT_NO_OF_POL_LABEL;

	private HtmlInputText COMP_ABGTB_ACT_NO_OF_POL;

	private HtmlOutputLabel COMP_ABGTB_ACT_LC_PREM_LABEL;

	private HtmlInputText COMP_ABGTB_ACT_LC_PREM;

	private PT_AGENT_BUDGET_BREAKUP PT_AGENT_BUDGET_BREAKUP_BEAN;
	
	public PT051_A_COMPOSITE_ACTION compositeAction;

	private UIData breakupDataTable;
	private ArrayList<PT_AGENT_BUDGET_BREAKUP> breakupList=new ArrayList<PT_AGENT_BUDGET_BREAKUP>();
	private int prevRowIndex;
	private int currPage;
	private int lastUpdatedRowIndex;
	private int recordsPerPage = 5;

	/**
	 * 
	 */
	public PT_AGENT_BUDGET_BREAKUP_ACTION() {
		PT_AGENT_BUDGET_BREAKUP_BEAN = new PT_AGENT_BUDGET_BREAKUP();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_ABGTB_AGENT_CODE_LABEL() {
		return COMP_ABGTB_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABGTB_AGENT_CODE() {
		return COMP_ABGTB_AGENT_CODE;
	}

	public void setCOMP_ABGTB_AGENT_CODE_LABEL(HtmlOutputLabel COMP_ABGTB_AGENT_CODE_LABEL) {
		this.COMP_ABGTB_AGENT_CODE_LABEL = COMP_ABGTB_AGENT_CODE_LABEL;
	}

	public void setCOMP_ABGTB_AGENT_CODE(HtmlInputText COMP_ABGTB_AGENT_CODE) {
		this.COMP_ABGTB_AGENT_CODE = COMP_ABGTB_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABGTB_AGENT_NAME_LABEL() {
		return COMP_UI_M_ABGTB_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ABGTB_AGENT_NAME() {
		return COMP_UI_M_ABGTB_AGENT_NAME;
	}

	public void setCOMP_UI_M_ABGTB_AGENT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ABGTB_AGENT_NAME_LABEL) {
		this.COMP_UI_M_ABGTB_AGENT_NAME_LABEL = COMP_UI_M_ABGTB_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ABGTB_AGENT_NAME(HtmlInputText COMP_UI_M_ABGTB_AGENT_NAME) {
		this.COMP_UI_M_ABGTB_AGENT_NAME = COMP_UI_M_ABGTB_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_ABGTB_SHARE_PERC_LABEL() {
		return COMP_ABGTB_SHARE_PERC_LABEL;
	}

	public HtmlInputText getCOMP_ABGTB_SHARE_PERC() {
		return COMP_ABGTB_SHARE_PERC;
	}

	public void setCOMP_ABGTB_SHARE_PERC_LABEL(HtmlOutputLabel COMP_ABGTB_SHARE_PERC_LABEL) {
		this.COMP_ABGTB_SHARE_PERC_LABEL = COMP_ABGTB_SHARE_PERC_LABEL;
	}

	public void setCOMP_ABGTB_SHARE_PERC(HtmlInputText COMP_ABGTB_SHARE_PERC) {
		this.COMP_ABGTB_SHARE_PERC = COMP_ABGTB_SHARE_PERC;
	}

	public HtmlOutputLabel getCOMP_ABGTB_NO_OF_POL_LABEL() {
		return COMP_ABGTB_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ABGTB_NO_OF_POL() {
		return COMP_ABGTB_NO_OF_POL;
	}

	public void setCOMP_ABGTB_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ABGTB_NO_OF_POL_LABEL) {
		this.COMP_ABGTB_NO_OF_POL_LABEL = COMP_ABGTB_NO_OF_POL_LABEL;
	}

	public void setCOMP_ABGTB_NO_OF_POL(HtmlInputText COMP_ABGTB_NO_OF_POL) {
		this.COMP_ABGTB_NO_OF_POL = COMP_ABGTB_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ABGTB_LC_PREM_LABEL() {
		return COMP_ABGTB_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_ABGTB_LC_PREM() {
		return COMP_ABGTB_LC_PREM;
	}

	public void setCOMP_ABGTB_LC_PREM_LABEL(HtmlOutputLabel COMP_ABGTB_LC_PREM_LABEL) {
		this.COMP_ABGTB_LC_PREM_LABEL = COMP_ABGTB_LC_PREM_LABEL;
	}

	public void setCOMP_ABGTB_LC_PREM(HtmlInputText COMP_ABGTB_LC_PREM) {
		this.COMP_ABGTB_LC_PREM = COMP_ABGTB_LC_PREM;
	}

	public HtmlOutputLabel getCOMP_ABGTB_ACT_NO_OF_POL_LABEL() {
		return COMP_ABGTB_ACT_NO_OF_POL_LABEL;
	}

	public HtmlInputText getCOMP_ABGTB_ACT_NO_OF_POL() {
		return COMP_ABGTB_ACT_NO_OF_POL;
	}

	public void setCOMP_ABGTB_ACT_NO_OF_POL_LABEL(HtmlOutputLabel COMP_ABGTB_ACT_NO_OF_POL_LABEL) {
		this.COMP_ABGTB_ACT_NO_OF_POL_LABEL = COMP_ABGTB_ACT_NO_OF_POL_LABEL;
	}

	public void setCOMP_ABGTB_ACT_NO_OF_POL(HtmlInputText COMP_ABGTB_ACT_NO_OF_POL) {
		this.COMP_ABGTB_ACT_NO_OF_POL = COMP_ABGTB_ACT_NO_OF_POL;
	}

	public HtmlOutputLabel getCOMP_ABGTB_ACT_LC_PREM_LABEL() {
		return COMP_ABGTB_ACT_LC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_ABGTB_ACT_LC_PREM() {
		return COMP_ABGTB_ACT_LC_PREM;
	}

	public void setCOMP_ABGTB_ACT_LC_PREM_LABEL(HtmlOutputLabel COMP_ABGTB_ACT_LC_PREM_LABEL) {
		this.COMP_ABGTB_ACT_LC_PREM_LABEL = COMP_ABGTB_ACT_LC_PREM_LABEL;
	}

	public void setCOMP_ABGTB_ACT_LC_PREM(HtmlInputText COMP_ABGTB_ACT_LC_PREM) {
		this.COMP_ABGTB_ACT_LC_PREM = COMP_ABGTB_ACT_LC_PREM;
	}

	public PT_AGENT_BUDGET_BREAKUP getPT_AGENT_BUDGET_BREAKUP_BEAN() {
		return PT_AGENT_BUDGET_BREAKUP_BEAN;
	}

	public void setPT_AGENT_BUDGET_BREAKUP_BEAN(PT_AGENT_BUDGET_BREAKUP PT_AGENT_BUDGET_BREAKUP_BEAN) {
		this.PT_AGENT_BUDGET_BREAKUP_BEAN = PT_AGENT_BUDGET_BREAKUP_BEAN;
	}

	public UIData getBreakupDataTable() {
		return breakupDataTable;
	}

	public void setBreakupDataTable(UIData breakupDataTable) {
		this.breakupDataTable = breakupDataTable;
	}

	public ArrayList<PT_AGENT_BUDGET_BREAKUP> getBreakupList() {

		/*if(breakupList.size()==0){     //for empty 5 rows
			for(int i=0;i<5;i++){
				PT_AGENT_BUDGET_BREAKUP breakup=new PT_AGENT_BUDGET_BREAKUP();
				breakupList.add(breakup);
			}
		}*/
		return breakupList;
	}

	public void setBreakupList(ArrayList<PT_AGENT_BUDGET_BREAKUP> breakupList) {
		this.breakupList = breakupList;
	}

	public List agentCodeLov(Object obj) {
		System.out.println("+++++++++++++PT_AGENT_BUDGET_BREAKUP_ACTION.agentCodeLov()+++++++++++++");
		List list=new ArrayList();
		String query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER "
			+ "WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004' ))"
			+ " AND NVL(CUST_FRZ_FLAG,'N') = 'N' AND ROWNUM <10 ORDER BY CUST_CODE DESC";
		try {
			if (obj!=null && obj.toString().equals("*")) {
				Connection con = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				ResultSet rs = handler.executeSelectStatement(query, con);
				while (rs.next()) {
					PT_AGENT_BUDGET_BREAKUP_LOV lovBean = new PT_AGENT_BUDGET_BREAKUP_LOV();
					lovBean.setCUST_CODE(rs.getString("CUST_CODE"));
					lovBean.setCUST_NAME(rs.getString("CUST_NAME"));
					list.add(lovBean);
				}
				System.out.println("LIST SIZE = " + list.size());

			}else{
				query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER "
					+ "WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('002','020','CAGT','DBRL','FINT','EPTK','STFF','005','009','004' ))"
					+ " AND NVL(CUST_FRZ_FLAG,'N') = 'N' AND (CUST_CODE LIKE '%"+obj.toString()+"%' OR CUST_NAME LIKE '%"+obj.toString()+"%' ) AND ROWNUM <10 ORDER BY CUST_CODE DESC";
				Connection con = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				ResultSet rs = handler.executeSelectStatement(query, con);
				while (rs.next()) {
					PT_AGENT_BUDGET_BREAKUP_LOV lovBean = new PT_AGENT_BUDGET_BREAKUP_LOV();
					lovBean.setCUST_CODE(rs.getString("CUST_CODE"));
					lovBean.setCUST_NAME(rs.getString("CUST_NAME"));
					list.add(lovBean);
				}
				System.out.println("LIST SIZE = " + list.size());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return list;

	}

	public void newRow(ActionEvent ae) throws Exception{
		//[Method implemented for the Grid implementation by the Phanikumar dated 16-feb-2009]
		CommonUtils.clearMaps(this);
		//[Method implemented for the Grid implementation by the Phanikumar dated 16-feb-2009]
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String,Object> sessionMap = ctx.getExternalContext().getSessionMap();
		int rowCount = 0;

		//PT_AGENT_BUDGET_BREAKUP dtl = preInsert();
		//breakupList.add(dtl);
		rowCount = getBreakupDataTable().getRowCount();
		/*currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}*/
	}

	public String  lastColumnListener(){
		System.out.println("LAST COLUMN LISTENER...............");
		int currRowIndex = getBreakupDataTable().getRowIndex();
		System.out.println("Current Row Index = "+currRowIndex);
		int rowUpdated = 0;
		PT_AGENT_BUDGET_BREAKUP gridValueBean = null;
		System.out.println("$$$$$$$$$$$$$$$$$ DataTableList Size = "+breakupList.size());
		String message=null;
		CommonUtils utils=new CommonUtils();
		String sysValQuery=null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		ResultSet resultSet=null;
		try {
			connection=CommonUtils.getConnection();
			// Get the bean based on row index
			gridValueBean = (PT_AGENT_BUDGET_BREAKUP)breakupList.get(currRowIndex);
			L_CHK_AGT_BUDGET_BREAKUP();
			if(gridValueBean.getROWID()!=null){
				System.out.println("Row Updated.");
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update");
				//pre-update added by Varun[50663]
				gridValueBean.setABGTB_UPD_DT(utils.getCurrentDate());
				gridValueBean.setABGTB_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				rowUpdated =updateData(gridValueBean);
			}else{
				System.out.println("New Row Added");
				
				//pre-insert added byVarun[50663]
				sysValQuery=" SELECT PAG_ABGTB_SYS_ID.NEXTVAL  FROM   DUAL";
				resultSet=handler.executeSelectStatement(sysValQuery, connection, new Object[]{});
				if(resultSet.next()){
					gridValueBean.setABGTB_SYS_ID(resultSet.getDouble(1));
				}
				gridValueBean.setABGTB_CR_DT(utils.getCurrentDate());
				gridValueBean.setABGTB_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert");
				rowUpdated =insertData(gridValueBean);
			}
			if (rowUpdated >0) {
//				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
				getWarningMap().put("details", message);
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return "" ;
	}


	public int updateData(PT_AGENT_BUDGET_BREAKUP dataGridBean) throws Exception{
		System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.updateData()");
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			preUpdate();
			Connection connection=CommonUtils.getConnection();
			rowUpdated = dbHandler.executeUpdate(dataGridBean, connection);

			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int insertData(PT_AGENT_BUDGET_BREAKUP dataGridBean) throws Exception{
		System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.insertData()");
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		try {
			Connection connection=CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);

			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	/*******************************   BLOCK  TRIGGERS   ************************************/

	public void postQuery() throws Exception{
		/*System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.postQuery()");
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rss=handler.executeSelectStatement("SELECT PAG_ABGTB_SYS_ID.NEXTVAL FROM DUAL;", connection);
		if(rss.next())
			PT_AGENT_BUDGET_BREAKUP_BEAN.setUI_M_ABGTB_AGENT_NAME(rss.getString(1));*/
		String query = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		ResultSet rs = null;
		try{
			for(int i=0; i< breakupList.size(); i++){
				Object[] values = {breakupList.get(i).getABGTB_AGENT_CODE()}; 
				rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection(), values);
				if(rs.next()){
					breakupList.get(i).setUI_M_ABGTB_AGENT_NAME(rs.getString(1));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void onLoad(PhaseEvent ae) throws Exception {
		try{
			if(isFormFlag()){
				setFormFlag(false);
			}
			if(isBlockFlag()){
				preBlock();
				whenNewBlockInstance(null);
				executeQuery();
				if(PT_AGENT_BUDGET_BREAKUP_BEAN.getROWID()!=null){
					postQuery();
				}else{
					
				}
				setBlockFlag(false);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}
	}	

	public void preInsert() throws Exception{
		System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.preInsert()");
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_ABGT_SYS_ID(compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID());

		ResultSet rsSys=handler.executeSelectStatement("SELECT PAG_ABGT_SYS_ID.NEXTVAL FROM DUAL", connection);
		if(rsSys.next()){
			PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_SYS_ID(rsSys.getDouble(1));
		}

		ResultSet rsDate=handler.executeSelectStatement("SELECT SYSDATE FROM DUAL", connection);
		if(rsDate.next()){
			PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_CR_DT(rsDate.getDate(1));
		}
		PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_CR_UID(CommonUtils.getControlBean().getM_USER_ID());

		//return breakupBean;
	}

	public void preUpdate() throws Exception{
		System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.preUpdate()");
		Connection connection=CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rsDate=handler.executeSelectStatement("SELECT SYSDATE FROM DUAL", connection);
		if(rsDate.next())
			PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_UPD_DT(rsDate.getDate(1));

		PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		//:PT_AGENT_BUDGET_BREAKUP.ABGTB_UPD_UID := :CTRL.M_USER_ID;
	}
	public void preBlock() {
		System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.preBlock()");
//		IF FORM_FAILURE THEN
//		:GLOBAL.M_FAILURE := 'TRUE';
//		END IF;
//		:CTRL.M_DELETE_MSG_FLAG := 'Y';
	}
	public void whenNewBlockInstance(Double sysId) {
		CommonUtils.clearMaps(this);
		System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.whenNewBlockInstance()");
//		DECLARE

//		M_DUMMY    VARCHAR2(1);
//		CURSOR C1 IS
//		SELECT 'X'
//		FROM   PT_AGENT_BUDGET_BREAKUP
//		WHERE  ABGTB_ABGT_SYS_ID = :PT_AGENT_BUDGET.ABGT_SYS_ID ;

//		BEGIN	    
//		IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN 
//		COPY('P','CTRL.M_COMM_DEL') ;
//		COPY('20','SYSTEM.MESSAGE_LEVEL');
//		POST;                   
//		COPY('0','SYSTEM.MESSAGE_LEVEL');
//		COPY('','CTRL.M_COMM_DEL') ;
//		:PT_AGENT_BUDGET.ABGT_NO_OF_POL := :PT_AGENT_BUDGET.ABGT_NO_OF_POL;    
//		END IF;
//		IF C1%ISOPEN THEN
//		CLOSE C1;
//		END IF;
//		OPEN C1;
//		FETCH C1 INTO M_DUMMY ;
//		CLOSE C1;
//		IF M_DUMMY = 'X' THEN
//		EXECUTE_QUERY;
//		END IF;   
//		END ;    

		String query = "SELECT ROWID, PT_AGENT_BUDGET_BREAKUP.* FROM PT_AGENT_BUDGET_BREAKUP WHERE ABGTB_ABGT_SYS_ID = '"+sysId+"' ORDER BY ABGTB_AGENT_CODE ";
		ResultSet rs = null;
		try{
			/*List<PT_AGENT_BUDGET_BREAKUP> list = getHandler().fetch(query, "com.iii.pel.forms.PT051_A.PT_AGENT_BUDGET_BREAKUP", CommonUtils.getConnection());
			if(!list.isEmpty()){
				System.out.println("The size of list for RANK Block: "+list.size());
				setBreakupList(list);
			}*/
			System.out.println("The sys Id in Budget Rank is: "+sysId);
			PT051_A_COMPOSITE_ACTION compositeAction = (PT051_A_COMPOSITE_ACTION) (new CommonUtils().getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION"));
			PT_AGENT_BUDGET_BREAKUP_ACTION budgetAction4 = compositeAction.getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN();
			ArrayList<PT_AGENT_BUDGET_BREAKUP> budgetBreakupList=budgetAction4.getBreakupList();
			rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection());
			
			if(!budgetAction4.getBreakupList().isEmpty()){
				budgetAction4.getBreakupList().clear();
			}
			
			while(rs.next()){
				PT_AGENT_BUDGET_BREAKUP breakup=new PT_AGENT_BUDGET_BREAKUP();
				breakup.setROWID(rs.getString("ROWID"));
				breakup.setABGTB_AGENT_CODE(rs.getString("ABGTB_AGENT_CODE"));
				breakup.setABGTB_SHARE_PERC(rs.getDouble("ABGTB_SHARE_PERC"));
				breakup.setABGTB_NO_OF_POL(rs.getDouble("ABGTB_NO_OF_POL"));
				breakup.setABGTB_LC_PREM(rs.getDouble("ABGTB_LC_PREM"));
				breakup.setABGTB_ACT_NO_OF_POL(rs.getDouble("ABGTB_ACT_NO_OF_POL"));
				breakup.setABGTB_ACT_LC_PREM(rs.getDouble("ABGTB_ACT_LC_PREM"));
				breakup.setABGTB_SYS_ID(rs.getDouble("ABGTB_SYS_ID"));
//				breakup.setUI_M_ABGTB_AGENT_NAME(rs.getString(9));
				breakup.setABGTB_CR_DT(rs.getDate("ABGTB_CR_DT"));
				breakup.setABGTB_CR_UID(rs.getString("ABGTB_CR_UID"));
				breakup.setABGTB_ABGT_SYS_ID(rs.getDouble("ABGTB_ABGT_SYS_ID"));
				breakup.setRowSelected(false);
				System.out.println("AGENT NAME---"+breakup.getUI_M_ABGTB_AGENT_NAME());
				System.out.println("BREAK UP SYSID>>>>>>>"+breakup.getABGTB_SYS_ID());
				budgetBreakupList.add(breakup);
			}
			budgetAction4.setBreakupList(budgetBreakupList);
			if(budgetBreakupList.size()>0)
			{
				budgetAction4.setPT_AGENT_BUDGET_BREAKUP_BEAN(budgetBreakupList.get(0));
				budgetAction4.getPT_AGENT_BUDGET_BREAKUP_BEAN().setRowSelected(true);					
			}
			budgetAction4.resetAllComponent();
			System.out.println("The size of Budget Rank is: "+budgetAction4.getBreakupList().size());
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("PT051_A_COMPOSITE_ACTION", compositeAction);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void executeQuery() {
		CommonUtils.clearMaps(this);
		
		String query = "SELECT ROWID, PT_AGENT_BUDGET_BREAKUP.* FROM PT_AGENT_BUDGET_BREAKUP WHERE ABGTB_ABGT_SYS_ID = ? ORDER BY ABGTB_AGENT_CODE ";
		ResultSet rs = null;
		try{
			//PT051_A_COMPOSITE_ACTION compositeAction = (PT051_A_COMPOSITE_ACTION) (new CommonUtils().getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION"));
			//PT_AGENT_BUDGET_BREAKUP_ACTION budgetAction4 = compositeAction.getPT_AGENT_BUDGET_BREAKUP_ACTION_BEAN();
			//ArrayList<PT_AGENT_BUDGET_BREAKUP> budgetBreakupList=budgetAction4.getBreakupList();
			rs = getHandler().executeSelectStatement(query, CommonUtils.getConnection(),new Object[]{
						compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID()});
			
			if(breakupList!=null && !breakupList.isEmpty()){
				breakupList.clear();
			}
			
			while(rs.next()){
				PT_AGENT_BUDGET_BREAKUP breakup=new PT_AGENT_BUDGET_BREAKUP();
				breakup.setROWID(rs.getString("ROWID"));
				breakup.setABGTB_AGENT_CODE(rs.getString("ABGTB_AGENT_CODE"));
				breakup.setABGTB_SHARE_PERC(rs.getDouble("ABGTB_SHARE_PERC"));
				breakup.setABGTB_NO_OF_POL(rs.getDouble("ABGTB_NO_OF_POL"));
				breakup.setABGTB_LC_PREM(rs.getDouble("ABGTB_LC_PREM"));
				breakup.setABGTB_ACT_NO_OF_POL(rs.getDouble("ABGTB_ACT_NO_OF_POL"));
				breakup.setABGTB_ACT_LC_PREM(rs.getDouble("ABGTB_ACT_LC_PREM"));
				breakup.setABGTB_SYS_ID(rs.getDouble("ABGTB_SYS_ID"));
//				breakup.setUI_M_ABGTB_AGENT_NAME(rs.getString(9));
				breakup.setABGTB_CR_DT(rs.getDate("ABGTB_CR_DT"));
				breakup.setABGTB_CR_UID(rs.getString("ABGTB_CR_UID"));
				breakup.setABGTB_ABGT_SYS_ID(rs.getDouble("ABGTB_ABGT_SYS_ID"));
				breakup.setRowSelected(false);
				System.out.println("AGENT NAME---"+breakup.getUI_M_ABGTB_AGENT_NAME());
				System.out.println("BREAK UP SYSID>>>>>>>"+breakup.getABGTB_SYS_ID());
				breakupList.add(breakup);
			}
//			budgetAction4.setBreakupList(budgetBreakupList);
			if(breakupList!=null &&
					breakupList.size()>0)
			{	
				PT_AGENT_BUDGET_BREAKUP budgetAction4 = (PT_AGENT_BUDGET_BREAKUP)breakupList.get(0);
				budgetAction4.setRowSelected(true);
				setPT_AGENT_BUDGET_BREAKUP_BEAN(budgetAction4);
			}
			resetAllComponent();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
	/*******************************   FIELD (ITEM)  TRIGGERS   ************************************/

	public void ABGTB_AGENT_CODE_WhenValidateItem(ActionEvent event){
		//[Method implemented for the Grid implementation by the Phanikumar dated 16-feb-2009]
		CommonUtils.clearMaps(this);
		//[Method implemented for the Grid implementation by the Phanikumar dated 16-feb-2009]
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
		/*if(input.isValid()){
		
			getBreakupList().get(getBreakupDataTable().getRowIndex()).setABGTB_AGENT_CODE(input.getValue().toString());
		}*/
	}
	
	/**
	 * 
	 * @param context
	 * @param component
	 * @param value
	 */
	public void ABGTB_AGENT_CODE_validator(FacesContext context, UIComponent component,	Object value){
		PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_AGENT_CODE((String)value);
		String cursorQuery1 = "SELECT 'X' FROM PM_CUSTOMER " +
		                      "WHERE CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS " +
		                                            "WHERE  CCLAS_TYPE = '002')" +
		                      "AND NVL(CUST_FRZ_FLAG,'N') = 'N' " +
		                      "AND NVL(CUST_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) >= ? " +
		                      "AND CUST_CODE = ? AND NVL(CUST_STATUS,'A') = 'A'";
		String cursorQuery2 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		String cursorQuery3 = "SELECT CAA_AGENT_CODE FROM PM_CUST_APPL_AGENT " +
							  "WHERE  NVL(CAA_DFLT_YN,'N') = 'Y' " +
		                      "AND TO_DATE(TRUNC(SYSDATE),'DD/MM/RRRR') BETWEEN NVL(CAA_EFF_FM_DT,TO_DATE('01/01/1900','DD/MM/RRRR')) " +
		                      "AND NVL(CAA_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR')) " +
		                      "CONNECT BY PRIOR CAA_AGENT_CODE = CAA_CUST_CODE START WITH CAA_CUST_CODE = ?";
		String cursorQuery4 = "SELECT PC_CODE FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' " +
		                      "AND PC_VALUE IN (SELECT MIN(PC_VALUE) FROM PM_CODES WHERE  PC_TYPE = 'AGNRANK')";
		String cursorQuery5 = "SELECT CUST_AGENT_RANK_CODE FROM PM_CUSTOMER WHERE CUST_CODE =  ?";
		String cursorQuery6 = "SELECT ROWID FROM PT_AGENT_BUDGET_BREAKUP WHERE ABGTB_ABGT_SYS_ID = ? " +
		                      "AND ABGTB_AGENT_CODE = ?";
		String M_C1FOUND = null, M_CUST_NAME = null, M_RANK_CODE = null, M_AM_CODE = null, M_AGENT_CODE = null, M_HIGHEST_RANK_CODE = null, M_DUMMY = null;
		ResultSet resultSet_C1 = null, resultSet_C2 = null, resultSet_C3 = null, resultSet_C4 = null, resultSet_C5 = null, resultSet_C6 = null;
		try{
			if(value != null){
				
				Double agentBudgetSysId = compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID();
				String ABGT_AGENT_CODE = compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_AGENT_CODE();
				String agentCode = ((UIInput)component).getSubmittedValue().toString();
				System.out.println("The agent Code from data Table: "+agentCode);
				System.out.println("The value being passed in validator is: "+value);
				Object[] values6 = {agentBudgetSysId, value};
				resultSet_C6 = getHandler().executeSelectStatement(cursorQuery6, CommonUtils.getConnection(), values6);
				if(resultSet_C6.next()) {
					M_DUMMY = resultSet_C6.getString("ROWID");
//					if(CommonUtils.isDuplicate(breakupList.get(getBreakupDataTable().getRowIndex()).getROWID(), M_DUMMY)){
					if(CommonUtils.isDuplicate(this.getPT_AGENT_BUDGET_BREAKUP_BEAN().getROWID(), M_DUMMY)){	
						throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71046"));
					}
				}
			
				Object[] values1 = {new CommonUtils().getCurrentDate(),value};
				resultSet_C1 = getHandler().executeSelectStatement(cursorQuery1, CommonUtils.getConnection(), values1);
				if(resultSet_C1.next()) {
					M_C1FOUND = resultSet_C1.getString(1);
				}
				
				if("Y".equals(MigratingFunctions.nvl(M_C1FOUND,"Y"))){
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91005"));
				}
				
				resultSet_C4 = getHandler().executeSelectStatement(cursorQuery4, CommonUtils.getConnection());
				if(resultSet_C4.next()) {
					M_HIGHEST_RANK_CODE = resultSet_C4.getString(1);
				}
				
				Object[] values3 = {value};
				resultSet_C3 = getHandler().executeSelectStatement(cursorQuery3, CommonUtils.getConnection(),values3);
				if(resultSet_C3.next()) {
					M_AGENT_CODE = resultSet_C3.getString(1);
					
					Object[] values5 = {M_AGENT_CODE};
					resultSet_C5 = getHandler().executeSelectStatement(cursorQuery5, CommonUtils.getConnection(),values5);
					if(resultSet_C5.next()) {
						M_RANK_CODE = resultSet_C5.getString(1);
					}
					if(M_RANK_CODE!=null && M_RANK_CODE.equals(M_HIGHEST_RANK_CODE)){
						//if(!M_AGENT_CODE.equals(value.toString())){
						// added By Shankar Bodduluri[CCHN1148]. 
						// Compare M_AGENT_CODE with :PT_AGENT_BUDGET.ABGT_AGENT_CODE .
						if(!M_AGENT_CODE.equals(ABGT_AGENT_CODE)){
							throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91279", new Object[]{ABGT_AGENT_CODE}));
						}
					}
				}
				
				Object[] values2 = {value};
				resultSet_C2 = getHandler().executeSelectStatement(cursorQuery2, CommonUtils.getConnection(), values2);
				if(resultSet_C2.next()) {
					M_CUST_NAME = resultSet_C2.getString(1);
				}
				PT_AGENT_BUDGET_BREAKUP_BEAN.setUI_M_ABGTB_AGENT_NAME(M_CUST_NAME);
			}
		}catch(ValidatorException vexc){
			vexc.printStackTrace();
			throw vexc;
		}catch(Exception e){
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
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
				PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_NO_OF_POL((Double)value);
				
				if(PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_NO_OF_POL() < 0){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91341"));
				}
				
			}
		} catch (Exception exc) {
			getErrorMap().put("current",  Messages.getString("messageProperties_PT051_A", "PT051_A$PT_AGENT_BUDGET$ABGT_LC_PREM$numbermessage"));
			throw new ValidatorException(new FacesMessage(exc.getMessage()));
		}

	}
	
	public void noOfACTPolicy_WhenValidateItem(FacesContext context, UIComponent component, Object value){
		try {
			if(value != null){
				PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_ACT_NO_OF_POL((Double)value);
				
				if(PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_ACT_NO_OF_POL() < 0){
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91341"));
				}
				
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
	 * @throws Exception
	 */
	public void ABGTB_SHARE_PERC_WhenValidateItem(FacesContext context, UIComponent component, Object value) throws Exception  {
		PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_SHARE_PERC((Double)value);
		try{
			if(PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_SHARE_PERC() != null)
				if(PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_SHARE_PERC() > 100)
					throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "2179"));
			
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	public void ABGTB_LC_PREM_WhenValidateItem(FacesContext context, UIComponent component, Object value) throws Exception  {
		CommonUtils.clearMaps(this);
		PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_LC_PREM((Double)value);
		try{
			if(PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_LC_PREM() < 0){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91341"));
			}
			System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.ABGTB_LC_PREM_WhenValidateItem()");
			L_VAL_ROUND_AMT (CommonUtils.getGlobalVariable("DUMMY.M_BASE_CURR"),PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_LC_PREM(),"V");
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	public void ABGTB_ACT_LC_PREM_WhenValidateItem(FacesContext context, UIComponent component, Object value) throws Exception  {
		CommonUtils.clearMaps(this);
		PT_AGENT_BUDGET_BREAKUP_BEAN.setABGTB_ACT_LC_PREM((Double)value);
		try{
			if(PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_ACT_LC_PREM() < 0){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91341"));
			}
			System.out.println("PT_AGENT_BUDGET_BREAKUP_ACTION.ABGTB_LC_PREM_WhenValidateItem()");
			L_VAL_ROUND_AMT (CommonUtils.getGlobalVariable("DUMMY.M_BASE_CURR"),PT_AGENT_BUDGET_BREAKUP_BEAN.getABGTB_ACT_LC_PREM(),"V");
		}catch(Exception exception){
			throw new ValidatorException(new FacesMessage(exception.getMessage()));
		}
	}
	
	public double L_VAL_ROUND_AMT(String P_CURR_CODE,double P_AMT,String P_VAL_ROUND) throws Exception{
        
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
                if(NumericFunctions.round(P_AMT,M_DECIMAL) != P_AMT){
                    //DISP_ALERT.DISP_ALERT(NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"));
                    //throw new FORM_TRIGGER_FAILURE();
                	throw new Exception();
                }
            }else{
                P_AMT = NumericFunctions.round(P_AMT, M_DECIMAL);
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

	
	public String addRow() throws Exception{
		int rowCount = 0;
		getWarningMap().clear();
		getErrorMap().clear();
		PT_AGENT_BUDGET_BREAKUP addBean = null;
		if (breakupList == null) {
			breakupList = new ArrayList<PT_AGENT_BUDGET_BREAKUP>();
		}
		addBean = new PT_AGENT_BUDGET_BREAKUP();
		PT051_A_COMPOSITE_ACTION compositeAction=(PT051_A_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION");
		Double agentBudgetSysId=compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID();
		System.out.println("agentBudgetSysId :"+agentBudgetSysId);
		addBean.setABGTB_ABGT_SYS_ID(agentBudgetSysId);
		breakupList.add(addBean);

		rowCount = breakupList.size();
		currPage = rowCount / recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}
		return "";
	}
	
	public String removeRow() {
		PT_AGENT_BUDGET_BREAKUP bean = null;
		ArrayList<Integer> deletedRecordList = null;
		int deletedRecordIndex = 0;
		getWarningMap().clear();
		getErrorMap().clear();

		try{
			if (breakupList != null && breakupList.size()>0) {
				deletedRecordList = new ArrayList<Integer>();
				for (int index = 0; index < breakupList.size();) {
					bean = breakupList.get(index);
					if (bean.isCheckBoxSelected()) {
						breakupList.remove(bean);
						deletedRecordIndex = deleteBudgetBrkupDetails(bean);
						deletedRecordList.add(deletedRecordIndex);
					} else {
						index++;
					}
				}
				if (deletedRecordList.size() > 0) {
					getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$delete"));
				}
				lastUpdatedRowIndex = -1;
			}
		}catch (Exception exc){
			getErrorMap().put("current", exc.getMessage());
		}

		return "";
	}
	
	public int deleteBudgetBrkupDetails(PT_AGENT_BUDGET_BREAKUP bean) {

		Connection connection;
		CRUDHandler handler =null;

		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			if(connection != null){
				handler = new CRUDHandler();
				deletedRows = handler.executeDelete(bean, connection);
			}
		} catch (DBException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	
	
	public void checkBoxStatus(ActionEvent actionEvent)
	{
		//[Method implemented for the Grid implementation by the Phanikumar dated 16-feb-2009]
		CommonUtils.clearMaps(this);
		//[Method implemented for the Grid implementation by the Phanikumar dated 16-feb-2009]
		UIInput input=(UIInput) actionEvent.getComponent().getParent();	
		boolean check = Boolean.parseBoolean((String)input.getSubmittedValue());
		int rowIndex = getBreakupDataTable().getRowIndex();
		breakupList.get(rowIndex).setCheckBoxSelected(check);
	}
	
	/*public String doCommit(){
		
		CommonUtils commonUtils=new CommonUtils();
		String message=null;
		try {
			commonUtils.doComitt();
			message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			getWarningMap().clear();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}*/
	public void doCommit() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put(
					"SAVE",
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	
	
	
	
	
	public void L_CHK_AGT_BUDGET_BREAKUP(){
		Double M_ABGT_LC_PREM = 0.0, M_ABGTB_LC_PREM_SUM = 0.0, M_ABGTB_NO_OF_POL_SUM =0.0, M_ABGT_NO_OF_POL = 0.0; 
		String query1 = "SELECT ABGT_LC_PREM, ABGT_NO_OF_POL FROM PT_AGENT_BUDGET WHERE ABGT_SYS_ID = ?";
		String query2 = "SELECT SUM(NVL(ABGTB_LC_PREM,0)), SUM(NVL(ABGTB_NO_OF_POL,0)) " +
				        "FROM PT_AGENT_BUDGET_BREAKUP WHERE  ABGTB_ABGT_SYS_ID = ?";
		ResultSet rs1 = null, rs2 = null;
		try{
			PT051_A_COMPOSITE_ACTION compositeAction=(PT051_A_COMPOSITE_ACTION)new CommonUtils().getMappedBeanFromSession("PT051_A_COMPOSITE_ACTION");
			Double agentBudgetSysId = compositeAction.getPT_AGENT_BUDGET_ACTION_BEAN().getPT_AGENT_BUDGET_BEAN().getABGT_SYS_ID();
			
			Object[] values1 = {agentBudgetSysId};
			rs1 = getHandler().executeSelectStatement(query1, CommonUtils.getConnection(), values1);
			if(rs1.next()) {
				M_ABGT_LC_PREM = rs1.getDouble(1);
				M_ABGT_NO_OF_POL = rs1.getDouble(2);
			}
			
			rs2 = getHandler().executeSelectStatement(query2, CommonUtils.getConnection(), values1);
			if(rs2.next()) {
				M_ABGTB_LC_PREM_SUM = rs2.getDouble(1);
				M_ABGTB_NO_OF_POL_SUM = rs2.getDouble(2);
			}			
			
			if(Math.round(MigratingFunctions.nvl(M_ABGTB_LC_PREM_SUM,0.0)) != Math.round(MigratingFunctions.nvl(M_ABGT_LC_PREM,0.0))){
				getWarningMap().put("current",Messages.getMessage(PELConstants.pelErrorMessagePath, "91272").getSummary());
			}
			
			if(Math.round(MigratingFunctions.nvl(M_ABGTB_NO_OF_POL_SUM, 0.0)) !=  Math.round(MigratingFunctions.nvl(M_ABGT_NO_OF_POL, 0.0))){
				getWarningMap().put("current", Messages.getMessage(PELConstants.pelErrorMessagePath, "91276").getSummary());
			}
			
		}catch(ValidatorException vce){
			vce.printStackTrace();
			throw vce;
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}catch(DBException dbe){
			dbe.printStackTrace();
		}
	}
	// [ Added for grid implementation change, Added by: Phanikumar, Dated: 16-Feb-2009
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = breakupDataTable.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnListener();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by:Phanikumar, Dated: 16-Feb-2009 ]
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		
		try {
			if (breakupList.size() != 0) {
				PT_AGENT_BUDGET_BREAKUP_BEAN = (PT_AGENT_BUDGET_BREAKUP) breakupDataTable
						.getRowData();
			}
			resetAllComponent();
			// Reset selection for other beans
			resetSelectedRow();
			PT_AGENT_BUDGET_BREAKUP_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap()
					.put(com.iii.premia.common.constants.PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_AGENT_BUDGET_BREAKUP> iterator = breakupList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_ABGTB_AGENT_CODE.resetValue();
		COMP_UI_M_ABGTB_AGENT_NAME.resetValue();
		COMP_ABGTB_SHARE_PERC.resetValue();
		COMP_ABGTB_NO_OF_POL.resetValue();
		COMP_ABGTB_LC_PREM.resetValue();
		COMP_ABGTB_ACT_NO_OF_POL.resetValue();
		COMP_ABGTB_ACT_LC_PREM.resetValue();

	}
	public void addRow(ActionEvent event) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isINSERT_ALLOWED()) {
				PT_AGENT_BUDGET_BREAKUP_BEAN = new PT_AGENT_BUDGET_BREAKUP();
				resetAllComponent();
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_AGENT_BUDGET_BREAKUP_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_AGENT_BUDGET_BREAKUP_BEAN,
							CommonUtils.getConnection());
					breakupList.remove(PT_AGENT_BUDGET_BREAKUP_BEAN);
				}

				if (breakupList.size() > 0) {
					setPT_AGENT_BUDGET_BREAKUP_BEAN(breakupList.get(0));
					PT_AGENT_BUDGET_BREAKUP_BEAN.setRowSelected(true);
				} else {
					addRow(ae);
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

	public void post(ActionEvent ae) {
		
		try {
			if (PT_AGENT_BUDGET_BREAKUP_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					preUpdate();
					new CRUDHandler().executeInsert(PT_AGENT_BUDGET_BREAKUP_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {
					preInsert();
					new CRUDHandler().executeInsert(PT_AGENT_BUDGET_BREAKUP_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					breakupList.add(PT_AGENT_BUDGET_BREAKUP_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PT_AGENT_BUDGET_BREAKUP_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	

	/**
	 * Instantiates all components in PT_AGENT_BUDGET_BREAKUP_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_ABGTB_AGENT_CODE				 = new HtmlInputText();
		COMP_UI_M_ABGTB_AGENT_NAME			 = new HtmlInputText();
		COMP_ABGTB_SHARE_PERC				 = new HtmlInputText();
		COMP_ABGTB_NO_OF_POL				 = new HtmlInputText();
		COMP_ABGTB_LC_PREM				 = new HtmlInputText();
		COMP_ABGTB_ACT_NO_OF_POL			 = new HtmlInputText();
		COMP_ABGTB_ACT_LC_PREM				 = new HtmlInputText();

	}


}
