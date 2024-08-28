package com.iii.pel.forms.PILQ016;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_BUDGET_ACTION  extends CommonAction{

	private HtmlOutputLabel COMP_ABGT_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ABGT_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_ABGT_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ABGT_AGENT_NAME;

	private HtmlOutputLabel COMP_UI_M_ABGT_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_ABGT_FM_DT;

	private HtmlOutputLabel COMP_UI_M_ABGT_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_ABGT_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_AGENT_CODE_LOV;

	private PT_AGENT_BUDGET PT_AGENT_BUDGET_BEAN;
	
	private boolean renderBackButton;
	
	private boolean flag = true;
	
	private UIData dataTable;
	
	public PILQ016_COMPOSITE_ACTION compositeAction;

	/** Below Code is Added for Functionality*/

	CRUDHandler handler = new CRUDHandler();
	private HtmlCommandButton preformButton;
	
	List<AGENT_CODE_LOVBean> lov=null;
	
	Map<String, Object> sessionMap = null;
	FacesContext facesCtx = null;
	
	public Map<String, Object> getSessionMap(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	
	/** Below Code is Added for Functionality*/
	
	public HtmlCommandButton getPreformButton() {
		return preformButton;
	}

	public void setPreformButton(HtmlCommandButton preformButton) {
		this.preformButton = preformButton;
	}

	public PT_AGENT_BUDGET_ACTION() {
		PT_AGENT_BUDGET_BEAN = new PT_AGENT_BUDGET();
		setFinancialYearDts(PT_AGENT_BUDGET_BEAN);
		intiateAll();
	}

	public void intiateAll()
	{
		
		COMP_UI_M_ABGT_AGENT_NAME=new HtmlInputText();
		COMP_ABGT_AGENT_CODE=new HtmlInputText();
		COMP_UI_M_ABGT_AGENT_NAME=new HtmlInputText();
		COMP_UI_M_ABGT_FM_DT=new HtmlCalendar();
		COMP_UI_M_ABGT_TO_DT=new HtmlCalendar();
	}
	

	public HtmlOutputLabel getCOMP_ABGT_AGENT_CODE_LABEL() {
		return COMP_ABGT_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABGT_AGENT_CODE() {
		return COMP_ABGT_AGENT_CODE;
	}

	public void setCOMP_ABGT_AGENT_CODE_LABEL(HtmlOutputLabel COMP_ABGT_AGENT_CODE_LABEL) {
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

	public void setCOMP_UI_M_ABGT_AGENT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ABGT_AGENT_NAME_LABEL) {
		this.COMP_UI_M_ABGT_AGENT_NAME_LABEL = COMP_UI_M_ABGT_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ABGT_AGENT_NAME(HtmlInputText COMP_UI_M_ABGT_AGENT_NAME) {
		this.COMP_UI_M_ABGT_AGENT_NAME = COMP_UI_M_ABGT_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABGT_FM_DT_LABEL() {
		return COMP_UI_M_ABGT_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_ABGT_FM_DT() {
		return COMP_UI_M_ABGT_FM_DT;
	}

	public void setCOMP_UI_M_ABGT_FM_DT_LABEL(HtmlOutputLabel COMP_UI_M_ABGT_FM_DT_LABEL) {
		this.COMP_UI_M_ABGT_FM_DT_LABEL = COMP_UI_M_ABGT_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_ABGT_FM_DT(HtmlCalendar COMP_UI_M_ABGT_FM_DT) {
		this.COMP_UI_M_ABGT_FM_DT = COMP_UI_M_ABGT_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_ABGT_TO_DT_LABEL() {
		return COMP_UI_M_ABGT_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_ABGT_TO_DT() {
		return COMP_UI_M_ABGT_TO_DT;
	}

	public void setCOMP_UI_M_ABGT_TO_DT_LABEL(HtmlOutputLabel COMP_UI_M_ABGT_TO_DT_LABEL) {
		this.COMP_UI_M_ABGT_TO_DT_LABEL = COMP_UI_M_ABGT_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_ABGT_TO_DT(HtmlCalendar COMP_UI_M_ABGT_TO_DT) {
		this.COMP_UI_M_ABGT_TO_DT = COMP_UI_M_ABGT_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_AGENT_CODE_LOV() {
		return COMP_UI_M_BUT_AGENT_CODE_LOV;
	}

	public void setCOMP_UI_M_BUT_AGENT_CODE_LOV(HtmlCommandButton COMP_UI_M_BUT_AGENT_CODE_LOV) {
		this.COMP_UI_M_BUT_AGENT_CODE_LOV = COMP_UI_M_BUT_AGENT_CODE_LOV;
	}

	public PT_AGENT_BUDGET getPT_AGENT_BUDGET_BEAN() {
		return PT_AGENT_BUDGET_BEAN;
	}

	public void setPT_AGENT_BUDGET_BEAN(PT_AGENT_BUDGET PT_AGENT_BUDGET_BEAN) {
		this.PT_AGENT_BUDGET_BEAN = PT_AGENT_BUDGET_BEAN;
	}

	public List lovList(Object obj) throws Exception{
		String query=null;
		 lov= new ArrayList<AGENT_CODE_LOVBean>();
		Connection con = getConnection();

		String value = obj.toString();
		ResultSet rs=null;
		//REFACTORED BY VARUN[50663]
		try{
		
			if("*".equals(value)){
				
				query = "SELECT CUST_CODE,CUST_NAME  FROM PM_CUSTOMER WHERE " +
					"PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND ROWNUM<21 ORDER BY CUST_CODE ";
			
			}else{
				
				query = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE " +
					"PM_CUSTOMER.CUST_FRZ_FLAG = 'N'AND (CUST_CODE LIKE " +
					"'"+value+"%' OR CUST_NAME LIKE '"+value+"%') AND ROWNUM<21 ORDER BY CUST_CODE ";
			}
			
			rs = handler.executeSelectStatement(query, con);
			while(rs.next()){
				AGENT_CODE_LOVBean bean = new AGENT_CODE_LOVBean();
				bean.setCUST_CODE(rs.getString(1));
				bean.setCUST_NAME(rs.getString(2));
				lov.add(bean);
			}
		}catch(Exception  exception){
			exception.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return lov;
	}

	/** Database Connection*/
	private Connection getConnection() throws Exception{
		Connection con=CommonUtils.getConnection();
		return con;
	}
	
	public void formOnLoad(ActionEvent event){
		getPreformButton().setDisabled(true);
		PREFORM();
	}

	private void PREFORM(){
		facesCtx = FacesContext.getCurrentInstance();
		sessionMap = getSessionMap();
		sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
		
		STD_PRE_FORM();
		
		if(Integer.parseInt(((String)sessionMap.get("GLOBAL.M_FOR_LANG_CODE")).substring(4,5))== 1 ){
		}
		String M_TITLE = CommonUtils.getControlBean().getM_USER_ID()+" "+CommonUtils.getControlBean().getM_SCR_NAME()+" "+new Date();
		return;
	}
	
	private void STD_PRE_FORM() {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String)sessionMap.get("GLOBAL.M_PARA_1"));
		ctrlBean.setM_PROG_NAME("PILT005");
		sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
	}
	
	public void PILQ016_PREQUERY() throws Exception{
		String query = "SELECT CAY_FRM_DT,CAY_TO_DT FROM FM_COMP_ACNT_YEAR WHERE CAY_PREV_CURR_NEXT='C'";
		Date fromDT = PT_AGENT_BUDGET_BEAN.getUI_M_ABGT_FM_DT();
		Date toDT = PT_AGENT_BUDGET_BEAN.getUI_M_ABGT_TO_DT();

		if((fromDT == null) && (toDT == null)){
			Connection con = getConnection();
			ResultSet rs = handler.executeSelectStatement(query, con);
			while(rs.next()){
				fromDT = rs.getDate(1);
				toDT = rs.getDate(2);
			}
		}
		return;
	}
	
	public void PILQ016_POSTQUERY(String agentCode) throws Exception{
		String query = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE='"+agentCode+"'";
		String CUST_NAME = "";
		
		Connection con = getConnection();
		ResultSet rs = handler.executeSelectStatement(query, con);
		try{
			
			while(rs.next()){
				CUST_NAME = rs.getString(1);
			}
			getCOMP_UI_M_ABGT_AGENT_NAME().setSubmittedValue(CUST_NAME);
			
			/*:PT_AGENT_BUDGET.M_ABGT_FM_DT:=:GLOBAL.M_FM_DT;
		:PT_AGENT_BUDGET.M_ABGT_TO_DT:=:GLOBAL.M_TO_DT;*/
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return;
	}
	/** FORM-LEVEL Triggers are handled Here. */
	//ADDED BY VARUN[50663]
	
	private void setFinancialYearDts(PT_AGENT_BUDGET pt_agent_budget_bean2) {
		CRUDHandler handler=new CRUDHandler();
		ResultSet resultSet=null;
		Connection connection=null;
		String query=null;
		try {
			connection=CommonUtils.getConnection();
			query="	SELECT CAY_FRM_DT,CAY_TO_DT	FROM   FM_COMP_ACNT_YEAR WHERE CAY_PREV_CURR_NEXT='C'";
			resultSet=handler.executeSelectStatement(query, connection, new Object[]{});
			if(resultSet.next()){
				pt_agent_budget_bean2.setUI_M_ABGT_FM_DT(resultSet.getDate(1));
				pt_agent_budget_bean2.setUI_M_ABGT_TO_DT(resultSet.getDate(2));
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void getAgentName(ActionEvent event) {
		CommonUtils.clearMaps(this);
		COMP_UI_M_ABGT_AGENT_NAME.setSubmittedValue(null);
		String agentCode = (String) CommonUtils
				.getCurrentValue(COMP_ABGT_AGENT_CODE);
		String query = "SELECT CUST_NAME  FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		String agentname = null;
		try {
			 connection = CommonUtils.getConnection();
			 resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{agentCode});
			 if(resultSet.next()){
				 agentname = resultSet.getString(1);
				 PT_AGENT_BUDGET_BEAN.setUI_M_ABGT_AGENT_NAME(agentname);
			 }
			 if(agentname == null){
				 throw new Exception("Agent Code not exist");
			 }
			getCOMP_UI_M_ABGT_AGENT_NAME().resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("getAgentName", e.getMessage());
		}
	}
	
	/*public void populatePanelData(ActionEvent e) {
		try {
			queryAction();
		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e1.getMessage());
		}
	
	}*/
	
	public boolean is_Flag() {
		flag = !flag;
		return flag;
	}

	public boolean isRenderBackButton() {
		return renderBackButton;
	}

	public void setRenderBackButton(boolean renderBackButton) {
		this.renderBackButton = renderBackButton;
	}
	
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
