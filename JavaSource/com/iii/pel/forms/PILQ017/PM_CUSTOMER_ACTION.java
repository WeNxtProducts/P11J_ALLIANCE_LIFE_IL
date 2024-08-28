package com.iii.pel.forms.PILQ017;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.GNMNF002.GNMNF002_A_APAC;
import com.iii.pel.login.servlet.ConnectionAgentServlet;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_CUSTOMER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CUST_CODE_LABEL;

	private HtmlInputText COMP_CUST_CODE;

	private HtmlOutputLabel COMP_CUST_SHORT_NAME_LABEL;

	private HtmlInputText COMP_CUST_SHORT_NAME;
	
	private HtmlOutputLabel  COMP_POL_NO_LABEL;
	
	private HtmlInputText COMP_POL_NO;
	
	private HtmlOutputLabel COMP_POL_PROD_CODE_LABEL ;
	
	private HtmlInputText COMP_POL_PROD_CODE;
	
	private HtmlInputText COMP_UI_M_PROD_DESC;
	
	private HtmlOutputLabel  COMP_POL_TRAN_DT_LABEL;
	
	private HtmlCalendar COMP_POL_TRAN_DT;
	
	private HtmlOutputLabel COMP_UI_M_POL_PROP_LABEL ;
	
	private HtmlInputText COMP_UI_M_POL_PROP;
	
	private HtmlOutputLabel  COMP_POL_ADDL_STATUS_LABEL;
	
	private HtmlInputText COMP_POL_ADDL_STATUS;
	
	private HtmlInputText COMP_UI_M_STATUS_DESC;

	private HtmlCommandButton PRE_FORM_BUTTON;
	/*
	 * PREMIAGDC-326705 Changes Done Vijayanand.V 20-08-2009 Buttons added
	 */
	private HtmlAjaxCommandButton COMP_NEXT_RECORD_BUTTON;

	private HtmlAjaxCommandButton COMP_PREV_RECORD_BUTTON;

	private PM_CUSTOMER PM_CUSTOMER_BEAN;

	GNMNF002_A_APAC globalValues = null;

	ControlBean controlBean = null;

	Map<String, Object> session = null;

	private String M_TITLE = null;

	private List fetchList = new ArrayList();

	private int rowIndex;

	private UIData dataTable;

	private String M_PARA_1;

	BUTTON_PALETTE buttonPalette;

	private String M_MODULE_ID;

	private String M_CUST_NAME;

	FacesContext facesContext = FacesContext.getCurrentInstance();

	private int lastRowIdx;

	private int prevRowIdx;
	
	private String filterByPOL_NO;
	private String filterByPOL_PROD_CODE; 
	private String filterByUI_M_PROD_DESC;

	private int currentRow = 0;

	private int prevRowIndex;

	private int rowCount = 0;

	private int currPage = 0;

	private int recordsPerPage = 5;

	private int lastUpdatedRowIndex;


	PM_CUSTOMER_HELPER helper = new PM_CUSTOMER_HELPER();

	private PT_IL_POLICY PT_IL_POLICY_BEAN; 
	PT_IL_POLICY_ACTION pt_il_policy_action = null;

	int rowNum = 1;

	private String M_CUST_CODE;

	List<PT_IL_POLICY> selectedList = null;
	List<PT_IL_POLICY> gridList = null;
	public PM_CUSTOMER_ACTION() {
		session = facesContext.getExternalContext().getSessionMap();
		gridList = new ArrayList<PT_IL_POLICY>();
		PM_CUSTOMER_BEAN = new PM_CUSTOMER();
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
	}

	public HtmlOutputLabel getCOMP_CUST_CODE_LABEL() {
		return COMP_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CUST_CODE() {
		return COMP_CUST_CODE;
	}

	public void setCOMP_CUST_CODE_LABEL(HtmlOutputLabel COMP_CUST_CODE_LABEL) {
		this.COMP_CUST_CODE_LABEL = COMP_CUST_CODE_LABEL;
	}

	public void setCOMP_CUST_CODE(HtmlInputText COMP_CUST_CODE) {
		this.COMP_CUST_CODE = COMP_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_CUST_SHORT_NAME_LABEL() {
		return COMP_CUST_SHORT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_CUST_SHORT_NAME() {
		return COMP_CUST_SHORT_NAME;
	}

	public void setCOMP_CUST_SHORT_NAME_LABEL(
			HtmlOutputLabel COMP_CUST_SHORT_NAME_LABEL) {
		this.COMP_CUST_SHORT_NAME_LABEL = COMP_CUST_SHORT_NAME_LABEL;
	}

	public void setCOMP_CUST_SHORT_NAME(HtmlInputText COMP_CUST_SHORT_NAME) {
		this.COMP_CUST_SHORT_NAME = COMP_CUST_SHORT_NAME;
	}

	public PM_CUSTOMER getPM_CUSTOMER_BEAN() {
		return PM_CUSTOMER_BEAN;
	}

	public void setPM_CUSTOMER_BEAN(PM_CUSTOMER PM_CUSTOMER_BEAN) {
		this.PM_CUSTOMER_BEAN = PM_CUSTOMER_BEAN;
	}

	public List getFetchList() {
		return fetchList;
	}

	public void setFetchList(List fetchList) {
		this.fetchList = fetchList;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}


	public void PRE_FORM(PhaseEvent ae ) {
		selectedList = new ArrayList<PT_IL_POLICY>();
		ResultSet moduleResultSet = null;
		globalValues = new GNMNF002_A_APAC();
		PRE_FORM_BUTTON = new HtmlCommandButton();
		globalValues.executePreFormCursors();
		String moduleIDQuery = "SELECT * FROM MENU_MENUS WHERE MENU_ACTION LIKE 'PILQ017' ";
		try {
			PreparedStatement moduleStatement = CommonUtils.getConnection()
					.prepareStatement(moduleIDQuery);
			moduleResultSet = moduleStatement.executeQuery();
			while (moduleResultSet.next()) {
				M_PARA_1 = moduleResultSet.getString("MENU_PARAMETER_1");
			}
			if (M_PARA_1 != null) {
			} else {
				M_PARA_1 = "NULL";
			}

			Map<String, Object> session = facesContext.getExternalContext()
					.getSessionMap();
			session.put("GLOBAL.M_MODULE_NAME", "PILM070_APAC");
			STD_PRE_FORM();
			getPRE_FORM_BUTTON().setDisabled(true);

		} catch (Exception er) {
			er.printStackTrace();
		}
	}

	public void STD_PRE_FORM() {
		
		buttonPalette = new BUTTON_PALETTE();

		try {

			controlBean = CommonUtils.getControlBean();
			buttonPalette.setM_RUN_DATE(getSystemDate());
			setM_MODULE_ID((String) session.get("GLOBAL.M_MODULE_NAME"));
			setM_TITLE(controlBean.getM_USER_ID() + " "
					+ controlBean.getM_SCR_NAME() + " " + getSystemDate());

			if (((String) session.get("GLOBAL.M_PRIVILEGE")).substring(0, 1).equals("Y")) {
			} else {
				
			}

			if (((String) session.get("GLOBAL.M_PRIVILEGE")).substring(1, 1).equals("Y")) {
			} else {
			}

			if (((String) session.get("GLOBAL.M_PRIVILEGE")).substring(2, 1)
					.equals("Y")) {
			} else {
			}


		} catch (Exception er) {
			er.printStackTrace();
		}
	}

	public void PRE_COMMIT() {
		KEY_COMMIT();
		STD_PRE_COMMIT();
	}

	public void KEY_COMMIT() {
		session.put("SYSTEM.MESSAGE_LEVEL", "0");
		controlBean.setM_COMM_DEL("C");
		CHK_PKG_FAILURE();
	}

	public void CHK_PKG_FAILURE() {
		if ("TRUE".equals(session.get("GLOBAL.M_FAILURE"))) {
			session.put("GLOBAL.M_FAILURE", "FALSE");
			throw new ValidatorException(facesContext.getMessages().next());
		}
	}

	public void STD_PRE_COMMIT() {
		if (!"".equals(controlBean.getM_COMM_DEL())) {
			NVL(controlBean.getM_COMM_DEL());
		} else {
		}
	}

	public String NVL(String value) {
		if ("C".equals(value) || "P".equals(value) || "D".equals(value)) {
			return value;
		} else {
			value = "X";
			getErrorMap().put("current", "");
			// ERROR HAS TO THROW USING GETERROR()
			return value;
		}
	}

	public void POST_DATABASE_COMMIT() {
		session.put("GLOBAL.M_FAILURE", "FALSE");
	}

	public void POST_FORMS_COMMIT() {
		session.put("GLOBAL.M_FAILURE", "FALSE");
	}

	public void POST_QUERY() {
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		if (!"".equals(PM_CUSTOMER_BEAN.getCUST_CODE())) {
			String C1 = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE= ? ";

			try {
				resultSet = handler.executeSelectStatement(C1, CommonUtils.getConnection() , new Object[]{PM_CUSTOMER_BEAN.getCUST_CODE()});
				while (resultSet.next()) {
					setM_CUST_CODE(resultSet.getString(1));
					setM_CUST_NAME(resultSet.getString(2));
					PM_CUSTOMER_BEAN.setCUST_CODE(resultSet.getString(1));
					PM_CUSTOMER_BEAN.setCUST_SHORT_NAME(resultSet.getString(2));
				}
				
				resultSet.close();
			} catch (Exception er) {
				er.printStackTrace();
			}
		}
	}

	public void ON_POPULATE_DETAILS() {
		if (!"".equals(getCOMP_CUST_CODE())) {
			QUERY_MASTER_DETAILS();
		}
	}

	public String EXECUTE_QUERY(String query, Object[] values)throws Exception{
		
			try {
				fetch(query, values);
				POST_QUERY();
				ON_POPULATE_DETAILS();
			} catch (Exception e) {
				e.printStackTrace();
					throw e;
				
			}
		
		return "";
	}

	public void QUERY_MASTER_DETAILS() {
		PT_IL_POLICY bean = null;
		pt_il_policy_action = new PT_IL_POLICY_ACTION();
		
		if (!PM_CUSTOMER_BEAN.getCUST_CODE().trim().isEmpty()) {
			gridList = pt_il_policy_action.Fetch(PM_CUSTOMER_BEAN);
			
			if(gridList.size() > 0){
				this.setPT_IL_POLICY_BEAN(gridList.get(0));
				this.getPT_IL_POLICY_BEAN().setRowSelected(true);
			}else{
				this.setPT_IL_POLICY_BEAN(new PT_IL_POLICY());
			}
			resetAllComponent();
		}
	}
	
	
	public void getDetails() {
		try {
		    	if ( gridList.size() != 0) {				
			   PT_IL_POLICY_BEAN = (PT_IL_POLICY) dataTable.getRowData();
			}	
			resetAllComponent();			
			resetSelectedRow();
			this.PT_IL_POLICY_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
	    COMP_POL_NO.resetValue();
	    COMP_POL_PROD_CODE.resetValue();
	    COMP_UI_M_PROD_DESC.resetValue();
	    COMP_UI_M_POL_PROP.resetValue();
	    COMP_POL_ADDL_STATUS.resetValue();
	    COMP_UI_M_STATUS_DESC.resetValue();
	    COMP_POL_TRAN_DT.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PT_IL_POLICY>  iterator = gridList.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
		// for fetching data of Customer
	public void fetch(String selectQuery, Object[] values)throws Exception {
		ResultSet result = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			result = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection(),values);
		
		if (!result.next()) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "71103"));
		} else {
			
				while (result.next()) {
					getCOMP_CUST_CODE().setSubmittedValue(
							result.getString("CUST_CODE"));
					getCOMP_CUST_SHORT_NAME().setSubmittedValue(
							result.getString("CUST_SHORT_NAME"));
					PM_CUSTOMER_BEAN
							.setCUST_CODE(result.getString("CUST_CODE"));
				}
			}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
		}

	// LOV For the Customer Code Start
	public List CUST_CODE_LOV(Object object) {
		List suggestionList = new ArrayList();
		String LOVQuery = "";
		CRUDHandler handler = new CRUDHandler();
		ResultSet LOVResultSet = null;
		PM_CUSTOMER bean = null;
		try {
			if (object.equals("*")) {
				LOVQuery = "SELECT CUST_CODE,CUST_NAME,CUST_SHORT_NAME,CUST_REF_ID1,CUST_ADDR1 FROM PM_CUSTOMER WHERE ROWNUM<=25 ";
			} else {
				LOVQuery = "SELECT CUST_CODE,CUST_NAME,CUST_SHORT_NAME,CUST_REF_ID1,CUST_ADDR1 FROM PM_CUSTOMER WHERE  ( CUST_CODE LIKE '"
						+ object.toString() + "%' OR CUST_NAME LIKE '"
						+ object.toString() + "%' )   AND ROWNUM<= 25 ";
			}
			LOVResultSet = handler.executeSelectStatement(LOVQuery, CommonUtils.getConnection());
			while (LOVResultSet.next()) {
				bean = new PM_CUSTOMER();
				bean.setCUST_CODE(LOVResultSet.getString(1));
				bean.setCUST_NAME(LOVResultSet.getString(2));
				bean.setCUST_SHORT_NAME(LOVResultSet.getString(3));
				bean.setCUST_REF_ID1(LOVResultSet.getString(4));
				bean.setCUST_ADDR1(LOVResultSet.getString(5));
				suggestionList.add(bean);
			}
			LOVResultSet.close();
		} catch (Exception er) {
			er.printStackTrace();
		}
		return suggestionList;
	}

	// End
	public void description(ActionEvent actionEvent) {
		String selectQuery = "SELECT ROWID,PM_CUSTOMER.* from PM_CUSTOMER WHERE CUST_CODE = ? ";
		String customerCode = (String) getCOMP_CUST_CODE().getSubmittedValue();
		PM_CUSTOMER_BEAN.setCUST_CODE(customerCode);
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String description = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ? ";

		try {
			CommonUtils.clearMaps(this);
			if (!customerCode.trim().isEmpty()) {
				EXECUTE_QUERY(selectQuery, new Object[]{customerCode});

				resultSet = handler.executeSelectStatement(description,
						CommonUtils.getConnection(),
						new Object[]{customerCode});
				if(resultSet.next()) {
					PM_CUSTOMER_BEAN.setCUST_SHORT_NAME(resultSet.getString(1));
				}
			}
		} catch (Exception er) {
			er.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, er.getMessage());
			getErrorMap().put("FETCH", er.getMessage());
		}finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}

	public void ADD_ROW(ActionEvent actionEvent) {
		gridList.add(new PT_IL_POLICY());
	}

	public String DELETE() {
		PT_IL_POLICY bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if (gridList != null) {
			PRE_DELETE();
			deletedRecordList = new ArrayList();
			for (int index = 0; index < gridList.size();) {
				bean = gridList.get(index);
				if (bean.isCHECK_BOX()) {
					gridList.remove(bean);
					deletedRecordIndex = helper.deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				} else {
					index++;
				}
			}
			lastRowIdx = -1;
		}
		return "";
	}

	public String PRE_DELETE() {
		String deleteQuery = "";
		int rowDeleted = 0;
		CRUDHandler handler = new CRUDHandler();
		if (!"".equals(PM_CUSTOMER_BEAN.getCUST_CODE())) {
			deleteQuery = "DELETE FROM PT_IL_POL_BROKER_HEAD P WHERE P.POBH_BROKER_CODE = '"
					+ PM_CUSTOMER_BEAN.getCUST_CODE() + "'";
			try {
				rowDeleted = handler.executeDeleteStatement(deleteQuery,
						CommonUtils.getConnection());
			} catch (Exception er) {
				er.printStackTrace();
			}
		}
		return "" + rowDeleted;
	}

	int tempSize = 0;

	public void checkBoxStatus(ActionEvent actionEvent) {
		selectedList.add((PT_IL_POLICY) getDataTable().getRowData());
		if (tempSize > 0) {
			for (int i = 0; i < tempSize; i++) {
				System.out.println("The Row Index is "
						+ selectedList.get(i).getROWID());
			}
		}

	}

	public void SAVE(ActionEvent actionEvent) {
		PRE_COMMIT();
		try {
			CommonUtils.getConnection().commit();
		} catch (Exception er) {
			er.printStackTrace();
		}
		POST_FORMS_COMMIT();
		POST_DATABASE_COMMIT();
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getValue();
			}
		}
		return value;
	}

	public java.sql.Date getSystemDate() {
		CRUDHandler handler = new CRUDHandler();
		java.sql.Date sysDate = null;
		ResultSet resultSet = null;
		Connection con = null;
		java.sql.Date date = null;
		try {
			con = CommonUtils.getConnection();
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, con);

			while (resultSet.next()) {
				sysDate = resultSet.getDate(1);
				date = sysDate;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return date;
	}

	public HtmlCommandButton getPRE_FORM_BUTTON() {
		return PRE_FORM_BUTTON;
	}

	public void setPRE_FORM_BUTTON(HtmlCommandButton pre_form_button) {
		PRE_FORM_BUTTON = pre_form_button;
	}

	public Map<String, Object> getSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getM_TITLE() {
		return M_TITLE;
	}

	public void setM_TITLE(String m_title) {
		M_TITLE = m_title;
	}

	public String getM_PARA_1() {
		return M_PARA_1;
	}

	public void setM_PARA_1(String m_para_1) {
		M_PARA_1 = m_para_1;
	}

	public String getM_MODULE_ID() {
		return M_MODULE_ID;
	}

	public void setM_MODULE_ID(String m_module_id) {
		M_MODULE_ID = m_module_id;
	}

	public String getM_CUST_NAME() {
		return M_CUST_NAME;
	}

	public void setM_CUST_NAME(String m_cust_name) {
		M_CUST_NAME = m_cust_name;
	}

	public List<PT_IL_POLICY> getGridList() {
		return gridList;
	}

	public void setGridList(List<PT_IL_POLICY> gridList) {
		this.gridList = gridList;
	}

	public int getLastRowIdx() {
		return lastRowIdx;
	}

	public void setLastRowIdx(int lastRowIdx) {
		this.lastRowIdx = lastRowIdx;
	}

	public int getPrevRowIdx() {
		return prevRowIdx;
	}

	public void setPrevRowIdx(int prevRowIdx) {
		this.prevRowIdx = prevRowIdx;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public int getPrevRowIndex() {
		return prevRowIndex;
	}

	public void setPrevRowIndex(int prevRowIndex) {
		this.prevRowIndex = prevRowIndex;
	}

	public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getLastUpdatedRowIndex() {
		return lastUpdatedRowIndex;
	}

	public void setLastUpdatedRowIndex(int lastUpdatedRowIndex) {
		this.lastUpdatedRowIndex = lastUpdatedRowIndex;
	}

	public String getM_CUST_CODE() {
		return M_CUST_CODE;
	}

	public void setM_CUST_CODE(String m_cust_code) {
		M_CUST_CODE = m_cust_code;
	}

	public HtmlAjaxCommandButton getCOMP_NEXT_RECORD_BUTTON() {
		return COMP_NEXT_RECORD_BUTTON;
	}

	public void setCOMP_NEXT_RECORD_BUTTON(
			HtmlAjaxCommandButton comp_next_record_button) {
		COMP_NEXT_RECORD_BUTTON = comp_next_record_button;
	}

	public HtmlAjaxCommandButton getCOMP_PREV_RECORD_BUTTON() {
		return COMP_PREV_RECORD_BUTTON;
	}

	public void setCOMP_PREV_RECORD_BUTTON(
			HtmlAjaxCommandButton comp_prev_record_button) {
		COMP_PREV_RECORD_BUTTON = comp_prev_record_button;
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
	    return COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel comp_pol_no_label) {
	    COMP_POL_NO_LABEL = comp_pol_no_label;
	}

	public HtmlInputText getCOMP_POL_NO() {
	    return COMP_POL_NO;
	}

	public void setCOMP_POL_NO(HtmlInputText comp_pol_no) {
	    COMP_POL_NO = comp_pol_no;
	}

	public HtmlOutputLabel getCOMP_POL_PROD_CODE_LABEL() {
	    return COMP_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_POL_PROD_CODE_LABEL(HtmlOutputLabel comp_pol_prod_code_label) {
	    COMP_POL_PROD_CODE_LABEL = comp_pol_prod_code_label;
	}

	public HtmlInputText getCOMP_POL_PROD_CODE() {
	    return COMP_POL_PROD_CODE;
	}

	public void setCOMP_POL_PROD_CODE(HtmlInputText comp_pol_prod_code) {
	    COMP_POL_PROD_CODE = comp_pol_prod_code;
	}

	public HtmlInputText getCOMP_UI_M_PROD_DESC() {
	    return COMP_UI_M_PROD_DESC;
	}

	public void setCOMP_UI_M_PROD_DESC(HtmlInputText comp_ui_m_prod_desc) {
	    COMP_UI_M_PROD_DESC = comp_ui_m_prod_desc;
	}

	public HtmlOutputLabel getCOMP_POL_TRAN_DT_LABEL() {
	    return COMP_POL_TRAN_DT_LABEL;
	}

	public void setCOMP_POL_TRAN_DT_LABEL(HtmlOutputLabel comp_pol_tran_dt_label) {
	    COMP_POL_TRAN_DT_LABEL = comp_pol_tran_dt_label;
	}

	 
	public HtmlCalendar getCOMP_POL_TRAN_DT() {
	    return COMP_POL_TRAN_DT;
	}

	public void setCOMP_POL_TRAN_DT(HtmlCalendar comp_pol_tran_dt) {
	    COMP_POL_TRAN_DT = comp_pol_tran_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PROP_LABEL() {
	    return COMP_UI_M_POL_PROP_LABEL;
	}

	public void setCOMP_UI_M_POL_PROP_LABEL(HtmlOutputLabel comp_ui_m_pol_prop_label) {
	    COMP_UI_M_POL_PROP_LABEL = comp_ui_m_pol_prop_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_PROP() {
	    return COMP_UI_M_POL_PROP;
	}

	public void setCOMP_UI_M_POL_PROP(HtmlInputText comp_ui_m_pol_prop) {
	    COMP_UI_M_POL_PROP = comp_ui_m_pol_prop;
	}

	public HtmlOutputLabel getCOMP_POL_ADDL_STATUS_LABEL() {
	    return COMP_POL_ADDL_STATUS_LABEL;
	}

	public void setCOMP_POL_ADDL_STATUS_LABEL(
		HtmlOutputLabel comp_pol_addl_status_label) {
	    COMP_POL_ADDL_STATUS_LABEL = comp_pol_addl_status_label;
	}

	public HtmlInputText getCOMP_POL_ADDL_STATUS() {
	    return COMP_POL_ADDL_STATUS;
	}

	public void setCOMP_POL_ADDL_STATUS(HtmlInputText comp_pol_addl_status) {
	    COMP_POL_ADDL_STATUS = comp_pol_addl_status;
	}

	public HtmlInputText getCOMP_UI_M_STATUS_DESC() {
	    return COMP_UI_M_STATUS_DESC;
	}

	public void setCOMP_UI_M_STATUS_DESC(HtmlInputText comp_ui_m_status_desc) {
	    COMP_UI_M_STATUS_DESC = comp_ui_m_status_desc;
	}

	public ControlBean getControlBean() {
	    return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
	    this.controlBean = controlBean;
	}

	public String getFilterByPOL_NO() {
	    return filterByPOL_NO;
	}

	public void setFilterByPOL_NO(String filterByPOL_NO) {
	    this.filterByPOL_NO = filterByPOL_NO;
	}

	public String getFilterByPOL_PROD_CODE() {
	    return filterByPOL_PROD_CODE;
	}

	public void setFilterByPOL_PROD_CODE(String filterByPOL_PROD_CODE) {
	    this.filterByPOL_PROD_CODE = filterByPOL_PROD_CODE;
	}

	public String getFilterByUI_M_PROD_DESC() {
	    return filterByUI_M_PROD_DESC;
	}

	public void setFilterByUI_M_PROD_DESC(String filterByUI_M_PROD_DESC) {
	    this.filterByUI_M_PROD_DESC = filterByUI_M_PROD_DESC;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
	    return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY pt_il_policy_bean) {
	    PT_IL_POLICY_BEAN = pt_il_policy_bean;
	}
	
	public void validateCUST_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String query = "SELECT * FROM PM_CUSTOMER WHERE CUST_CODE = ?";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			if(value != null){
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,new Object[]{value});
			if(resultSet.next()){
				
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71103"));
			}
			}
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
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
}
