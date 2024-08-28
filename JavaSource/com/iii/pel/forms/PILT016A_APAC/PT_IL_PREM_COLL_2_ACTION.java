package com.iii.pel.forms.PILT016A_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PREM_COLL_2_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_PC_LC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_BASIC_PREM;

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private HtmlCalendar COMP_PC_SCHD_PYMT_DT;

	private HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_AVLB_BAL_AMT;

	private HtmlOutputLabel COMP_PC_LC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_PC_LC_ADDL_PREM;

	private HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL;

	private HtmlInputText COMP_UI_M_LC_NET_PREM;

	private HtmlOutputLabel COMP_PC_LC_LOAD_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_LOAD_AMT;

	private HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL;

	private HtmlInputText COMP_PC_LC_PAID_AMT;

	private HtmlOutputLabel COMP_PC_LC_DISCOUNT_LABEL;

	private HtmlInputText COMP_PC_LC_DISCOUNT;

	private HtmlOutputLabel COMP_PC_DRCR_DOC_NO_LABEL;

	private HtmlInputText COMP_PC_DRCR_DOC_NO;

	private HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL;

	private HtmlInputText COMP_PC_LC_CHARGE;

	private HtmlOutputLabel COMP_PC_DRCR_DOC_DT_LABEL;

	private HtmlCalendar COMP_PC_DRCR_DOC_DT;

	private HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_PC_PAID_FLAG;

	private HtmlOutputLabel COMP_PC_PREM_HOLIDAY_YN_LABEL;

	private HtmlSelectOneMenu COMP_PC_PREM_HOLIDAY_YN;

	private PT_IL_PREM_COLL_2 PT_IL_PREM_COLL_2_BEAN;
	
	PILT016A_APAC_COMPOSITE_ACTION compositeAction;

	/* The Following Variables are Added for the Block Functionality*/
	
	private UIData PT_IL_PREM_COLL2_DataTable;
	List<PT_IL_PREM_COLL_2> PT_IL_PREM_COLL2_List = new ArrayList<PT_IL_PREM_COLL_2>();
	List<SelectItem> flagList = new ArrayList<SelectItem>();
	List<SelectItem> holidayList = new ArrayList<SelectItem>();
	/* The Following Variables are Added for the Block Functionality*/
	
	public List<SelectItem> getFlagList() {
		try {
			if (flagList.size() ==0){
				flagList.clear();
				flagList = ListItemUtil.getDropDownListValue(getConnection(), "PILT016A_APAC", "PT_IL_PREM_COLL_2", "PT_IL_PREM_COLL_2.PC_PAID_FLAG", "IL_PREM_STAT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flagList;
	}

	public void setFlagList(List<SelectItem> flagList) {
		this.flagList = flagList;
	}


	public void setPT_IL_PREM_COLL2_List(ArrayList<PT_IL_PREM_COLL_2> list) {
		PT_IL_PREM_COLL2_List = list;
	}

	

	
	
	public PT_IL_PREM_COLL_2_ACTION() {
		PT_IL_PREM_COLL_2_BEAN = new PT_IL_PREM_COLL_2();
	}

	public HtmlOutputLabel getCOMP_PC_LC_BASIC_PREM_LABEL() {
		return COMP_PC_LC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_BASIC_PREM() {
		return COMP_PC_LC_BASIC_PREM;
	}

	public void setCOMP_PC_LC_BASIC_PREM_LABEL(HtmlOutputLabel COMP_PC_LC_BASIC_PREM_LABEL) {
		this.COMP_PC_LC_BASIC_PREM_LABEL = COMP_PC_LC_BASIC_PREM_LABEL;
	}

	public void setCOMP_PC_LC_BASIC_PREM(HtmlInputText COMP_PC_LC_BASIC_PREM) {
		this.COMP_PC_LC_BASIC_PREM = COMP_PC_LC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_SCHD_PYMT_DT() {
		return COMP_PC_SCHD_PYMT_DT;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL) {
		this.COMP_PC_SCHD_PYMT_DT_LABEL = COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT(HtmlCalendar COMP_PC_SCHD_PYMT_DT) {
		this.COMP_PC_SCHD_PYMT_DT = COMP_PC_SCHD_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_AVLB_BAL_AMT_LABEL() {
		return COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_AVLB_BAL_AMT() {
		return COMP_PC_LC_AVLB_BAL_AMT;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT_LABEL(HtmlOutputLabel COMP_PC_LC_AVLB_BAL_AMT_LABEL) {
		this.COMP_PC_LC_AVLB_BAL_AMT_LABEL = COMP_PC_LC_AVLB_BAL_AMT_LABEL;
	}

	public void setCOMP_PC_LC_AVLB_BAL_AMT(HtmlInputText COMP_PC_LC_AVLB_BAL_AMT) {
		this.COMP_PC_LC_AVLB_BAL_AMT = COMP_PC_LC_AVLB_BAL_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_ADDL_PREM_LABEL() {
		return COMP_PC_LC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_ADDL_PREM() {
		return COMP_PC_LC_ADDL_PREM;
	}

	public void setCOMP_PC_LC_ADDL_PREM_LABEL(HtmlOutputLabel COMP_PC_LC_ADDL_PREM_LABEL) {
		this.COMP_PC_LC_ADDL_PREM_LABEL = COMP_PC_LC_ADDL_PREM_LABEL;
	}

	public void setCOMP_PC_LC_ADDL_PREM(HtmlInputText COMP_PC_LC_ADDL_PREM) {
		this.COMP_PC_LC_ADDL_PREM = COMP_PC_LC_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_NET_PREM_LABEL() {
		return COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_NET_PREM() {
		return COMP_UI_M_LC_NET_PREM;
	}

	public void setCOMP_UI_M_LC_NET_PREM_LABEL(HtmlOutputLabel COMP_UI_M_LC_NET_PREM_LABEL) {
		this.COMP_UI_M_LC_NET_PREM_LABEL = COMP_UI_M_LC_NET_PREM_LABEL;
	}

	public void setCOMP_UI_M_LC_NET_PREM(HtmlInputText COMP_UI_M_LC_NET_PREM) {
		this.COMP_UI_M_LC_NET_PREM = COMP_UI_M_LC_NET_PREM;
	}

	public HtmlOutputLabel getCOMP_PC_LC_LOAD_AMT_LABEL() {
		return COMP_PC_LC_LOAD_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_LOAD_AMT() {
		return COMP_PC_LC_LOAD_AMT;
	}

	public void setCOMP_PC_LC_LOAD_AMT_LABEL(HtmlOutputLabel COMP_PC_LC_LOAD_AMT_LABEL) {
		this.COMP_PC_LC_LOAD_AMT_LABEL = COMP_PC_LC_LOAD_AMT_LABEL;
	}

	public void setCOMP_PC_LC_LOAD_AMT(HtmlInputText COMP_PC_LC_LOAD_AMT) {
		this.COMP_PC_LC_LOAD_AMT = COMP_PC_LC_LOAD_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_PAID_AMT_LABEL() {
		return COMP_PC_LC_PAID_AMT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_PAID_AMT() {
		return COMP_PC_LC_PAID_AMT;
	}

	public void setCOMP_PC_LC_PAID_AMT_LABEL(HtmlOutputLabel COMP_PC_LC_PAID_AMT_LABEL) {
		this.COMP_PC_LC_PAID_AMT_LABEL = COMP_PC_LC_PAID_AMT_LABEL;
	}

	public void setCOMP_PC_LC_PAID_AMT(HtmlInputText COMP_PC_LC_PAID_AMT) {
		this.COMP_PC_LC_PAID_AMT = COMP_PC_LC_PAID_AMT;
	}

	public HtmlOutputLabel getCOMP_PC_LC_DISCOUNT_LABEL() {
		return COMP_PC_LC_DISCOUNT_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_DISCOUNT() {
		return COMP_PC_LC_DISCOUNT;
	}

	public void setCOMP_PC_LC_DISCOUNT_LABEL(HtmlOutputLabel COMP_PC_LC_DISCOUNT_LABEL) {
		this.COMP_PC_LC_DISCOUNT_LABEL = COMP_PC_LC_DISCOUNT_LABEL;
	}

	public void setCOMP_PC_LC_DISCOUNT(HtmlInputText COMP_PC_LC_DISCOUNT) {
		this.COMP_PC_LC_DISCOUNT = COMP_PC_LC_DISCOUNT;
	}

	public HtmlOutputLabel getCOMP_PC_DRCR_DOC_NO_LABEL() {
		return COMP_PC_DRCR_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_PC_DRCR_DOC_NO() {
		return COMP_PC_DRCR_DOC_NO;
	}

	public void setCOMP_PC_DRCR_DOC_NO_LABEL(HtmlOutputLabel COMP_PC_DRCR_DOC_NO_LABEL) {
		this.COMP_PC_DRCR_DOC_NO_LABEL = COMP_PC_DRCR_DOC_NO_LABEL;
	}

	public void setCOMP_PC_DRCR_DOC_NO(HtmlInputText COMP_PC_DRCR_DOC_NO) {
		this.COMP_PC_DRCR_DOC_NO = COMP_PC_DRCR_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_PC_LC_CHARGE_LABEL() {
		return COMP_PC_LC_CHARGE_LABEL;
	}

	public HtmlInputText getCOMP_PC_LC_CHARGE() {
		return COMP_PC_LC_CHARGE;
	}

	public void setCOMP_PC_LC_CHARGE_LABEL(HtmlOutputLabel COMP_PC_LC_CHARGE_LABEL) {
		this.COMP_PC_LC_CHARGE_LABEL = COMP_PC_LC_CHARGE_LABEL;
	}

	public void setCOMP_PC_LC_CHARGE(HtmlInputText COMP_PC_LC_CHARGE) {
		this.COMP_PC_LC_CHARGE = COMP_PC_LC_CHARGE;
	}

	public HtmlOutputLabel getCOMP_PC_DRCR_DOC_DT_LABEL() {
		return COMP_PC_DRCR_DOC_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PC_DRCR_DOC_DT() {
		return COMP_PC_DRCR_DOC_DT;
	}

	public void setCOMP_PC_DRCR_DOC_DT_LABEL(HtmlOutputLabel COMP_PC_DRCR_DOC_DT_LABEL) {
		this.COMP_PC_DRCR_DOC_DT_LABEL = COMP_PC_DRCR_DOC_DT_LABEL;
	}

	public void setCOMP_PC_DRCR_DOC_DT(HtmlCalendar COMP_PC_DRCR_DOC_DT) {
		this.COMP_PC_DRCR_DOC_DT = COMP_PC_DRCR_DOC_DT;
	}

	public HtmlOutputLabel getCOMP_PC_PAID_FLAG_LABEL() {
		return COMP_PC_PAID_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PC_PAID_FLAG() {
		return COMP_PC_PAID_FLAG;
	}

	public void setCOMP_PC_PAID_FLAG_LABEL(HtmlOutputLabel COMP_PC_PAID_FLAG_LABEL) {
		this.COMP_PC_PAID_FLAG_LABEL = COMP_PC_PAID_FLAG_LABEL;
	}

	public void setCOMP_PC_PAID_FLAG(HtmlSelectOneMenu COMP_PC_PAID_FLAG) {
		this.COMP_PC_PAID_FLAG = COMP_PC_PAID_FLAG;
	}

	public HtmlOutputLabel getCOMP_PC_PREM_HOLIDAY_YN_LABEL() {
		return COMP_PC_PREM_HOLIDAY_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_PC_PREM_HOLIDAY_YN() {
		return COMP_PC_PREM_HOLIDAY_YN;
	}

	public void setCOMP_PC_PREM_HOLIDAY_YN_LABEL(HtmlOutputLabel COMP_PC_PREM_HOLIDAY_YN_LABEL) {
		this.COMP_PC_PREM_HOLIDAY_YN_LABEL = COMP_PC_PREM_HOLIDAY_YN_LABEL;
	}

	public void setCOMP_PC_PREM_HOLIDAY_YN(HtmlSelectOneMenu COMP_PC_PREM_HOLIDAY_YN) {
		this.COMP_PC_PREM_HOLIDAY_YN = COMP_PC_PREM_HOLIDAY_YN;
	}

	public PT_IL_PREM_COLL_2 getPT_IL_PREM_COLL_2_BEAN() {
		return PT_IL_PREM_COLL_2_BEAN;
	}

	public void setPT_IL_PREM_COLL_2_BEAN(PT_IL_PREM_COLL_2 PT_IL_PREM_COLL_2_BEAN) {
		this.PT_IL_PREM_COLL_2_BEAN = PT_IL_PREM_COLL_2_BEAN;
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void preQuery(PILT016A_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String C1="	SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  " +
				"POL_NO =? AND    POL_DS_TYPE='2'";
		ResultSet set = null;
		CRUDHandler handler = null;
		Connection connection = null;
		Long M_POL_SYS_ID = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			set = handler.executeSelectStatement(C1, connection,new Object[]{compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()});
			if(set.next()){
				M_POL_SYS_ID = set.getLong(1);
			}else{
				M_POL_SYS_ID = 0L;
			}
			
			String M_WHERE = "PC_POL_SYS_ID ='"+M_POL_SYS_ID+"' AND PC_PAID_FLAG IN ('A','Y')";
			CommonUtils.setGlobalVariable("COL2_M_WHERE",M_WHERE);
			
		}catch(Exception exception){
			exception.printStackTrace(); 
			throw exception;
		}finally{
			CommonUtils.closeCursor(set);
		}
	}
	
	
	public String populateDetails() throws Exception{
		
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		PT_IL_DEPOSIT_ACTION mainBlockAction = (PT_IL_DEPOSIT_ACTION) sessionMap.get("PILT016A_APAC_PT_IL_DEPOSIT_ACTION");
		String dep_ref_no = mainBlockAction.getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO();
		System.out.println("called");
		
		
		String testQuery = "SELECT DISTINCT A.PC_SCHD_PYMT_DT,A.PC_LC_AVLB_BAL_AMT,A.PC_LC_PAID_AMT,A.PC_DRCR_DOC_NO,"+
		"A.PC_DRCR_DOC_DT,A.PC_PAID_FLAG,A.PC_PREM_HOLIDAY_YN,A.PC_LC_BASIC_PREM,"+
		"A.PC_LC_ADDL_PREM,A.PC_LC_LOAD_AMT,A.PC_LC_DISCOUNT,A.PC_LC_CHARGE FROM "+
		"PT_IL_PREM_COLL A,PT_IL_POLICY B, PT_IL_DEPOSIT C "+
		"WHERE A.PC_PAID_FLAG IN ('A','R') AND "+
		"B.POL_NO = C.DEP_REF_NO AND "+
		"A.PC_POL_SYS_ID = B.POL_SYS_ID AND "+
		"B.POL_DS_TYPE='2' AND B.POL_NO='"+dep_ref_no+"'";

		/**
		 * Below Query Should be used after the integration of other blocks.
		 * */
	/*	String POL_NO = dep_ref_no ;
		String actualQuery = "SELECT DISTINCT A.PC_POL_SYS_ID,A.PC_SCHD_PYMT_DT,A.PC_LC_AVLB_BAL_AMT,A.PC_LC_PAID_AMT,A.PC_DRCR_DOC_NO,"+
		"A.PC_DRCR_DOC_DT,A.PC_PAID_FLAG,A.PC_PREM_HOLIDAY_YN,A.PC_LC_BASIC_PREM,"+
		"A.PC_LC_ADDL_PREM,A.PC_LC_LOAD_AMT,A.PC_LC_DISCOUNT,A.PC_LC_CHARGE FROM "+
		"PT_IL_PREM_COLL A,PT_IL_POLICY B, PT_IL_DEPOSIT C "+
		"WHERE A.PC_PAID_FLAG IN ('A','Y') AND "+
		"B.POL_NO = C.DEP_REF_NO AND "+
		"A.PC_POL_SYS_ID = B.POL_SYS_ID AND "+
		"B.POL_DS_TYPE='2' AND B.POL_NO='"+POL_NO+"'";*/
		
		CRUDHandler handler = new CRUDHandler();
		Connection con = CommonUtils.getConnection();
		
		ArrayList<PT_IL_PREM_COLL_2> result = (ArrayList<PT_IL_PREM_COLL_2>) handler.fetch(testQuery,"com.iii.pel.forms.PILT016A_APAC.PT_IL_PREM_COLL_2", con);
//		System.out.println("RESULT = "+result.size());
		//getPT_IL_PREM_COLL2_List().clear();
		setPT_IL_PREM_COLL2_List(result);
		return "";
	}
	
	/**
	 * 
	 * @param e
	 */
	public void loadingBaseValues(PhaseEvent e) {
		try {
			
			if (isFormFlag()) {
				//preForm();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				CommonUtils.clearMaps(this);
				preQuery(compositeAction);
				executeQuery(compositeAction);
				///chkHolidayYN();
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
	
	
	public void chkHolidayYN() throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		String planType = null;
		String query = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE IN " +
					" (SELECT POL_PLAN_CODE FROM PT_IL_POLICY WHERE POL_NO=?)";
		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection,
					new Object[]{compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()});
			if(resultSet.next()){
				planType = resultSet.getString(1);
			}
			if("U".equals(planType)){
				COMP_PC_PREM_HOLIDAY_YN.setDisabled(false);
			}else{
				COMP_PC_PREM_HOLIDAY_YN.setDisabled(true);
			}
			
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
		
		
	}
	/**
	 * 
	 * @param compositeAction
	 */
	public void executeQuery(PILT016A_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		Connection connection = null;
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String WHERE = CommonUtils.getGlobalVariable("COL2_M_WHERE");
			String query1 = "SELECT DISTINCT A.*,ROWID FROM PT_IL_PREM_COLL A WHERE "+WHERE;
			
			List<PT_IL_PREM_COLL_2> fetchList = handler.fetch(query1, "com.iii.pel.forms.PILT016A_APAC.PT_IL_PREM_COLL_2",getConnection());
			setPT_IL_PREM_COLL2_List(fetchList);
			
			if(getPT_IL_PREM_COLL2_List()!=null && !getPT_IL_PREM_COLL2_List().isEmpty()){
				PT_IL_PREM_COLL_2 PT_IL_PREM_COLL_2_2 = getPT_IL_PREM_COLL2_List().get(0);
				PT_IL_PREM_COLL_2_2.setRowSelected(true);
				setPT_IL_PREM_COLL_2_BEAN(PT_IL_PREM_COLL_2_2);
			}
			
		}catch(Exception exception){
			throw exception;
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	private Connection getConnection() throws Exception{
//		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
//		Connection con = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("12345");
		/*FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		Connection con = (Connection)sessionMap.get("CLIENT_CON");
		*/
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
		}
		
		return con;
	}
	
	public String nextPage() {
		
		return "nextpage";
	}
	
	public List<SelectItem> getHolidayList() {
		try {
			if (holidayList.size() ==0){
				holidayList.clear();
				holidayList = ListItemUtil.getDropDownListValue(getConnection(), "PILT016A_APAC", "PT_IL_PREM_COLL_2", "PT_IL_PREM_COLL_2.PC_PREM_HOLIDAY_YN", "YESNO");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return holidayList;
	}

	public void setHolidayList(List<SelectItem> holidayList) {
		this.holidayList = holidayList;
	}

	/**
	 * @return the pT_IL_PREM_COLL2_List
	 */
	public List<PT_IL_PREM_COLL_2> getPT_IL_PREM_COLL2_List() {
		return PT_IL_PREM_COLL2_List;
	}

	/**
	 * @param list the pT_IL_PREM_COLL2_List to set
	 */
	public void setPT_IL_PREM_COLL2_List(List<PT_IL_PREM_COLL_2> list) {
		PT_IL_PREM_COLL2_List = list;
	}

	/**
	 * @return the pT_IL_PREM_COLL2_DataTable
	 */
	public UIData getPT_IL_PREM_COLL2_DataTable() {
		return PT_IL_PREM_COLL2_DataTable;
	}

	/**
	 * @param dataTable the pT_IL_PREM_COLL2_DataTable to set
	 */
	public void setPT_IL_PREM_COLL2_DataTable(UIData dataTable) {
		PT_IL_PREM_COLL2_DataTable = dataTable;
	}
	
	/**
	 * 
	 */
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_PREM_COLL_2_BEAN = (PT_IL_PREM_COLL_2) PT_IL_PREM_COLL2_DataTable
					.getRowData();
			PT_IL_PREM_COLL_2_BEAN.setRowSelected(true);
			resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_PREM_COLL_2> PT_GL_POL_EMP_COVER_ITR = PT_IL_PREM_COLL2_List
				.iterator();
		while (PT_GL_POL_EMP_COVER_ITR.hasNext()) {
			PT_GL_POL_EMP_COVER_ITR.next().setRowSelected(false);
		}
	}
	

	/**
	 * Resets all components in PT_IL_PREM_COLL_2_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_PC_LC_BASIC_PREM.resetValue();
		COMP_PC_LC_AVLB_BAL_AMT.resetValue();
		COMP_PC_LC_ADDL_PREM.resetValue();
		COMP_UI_M_LC_NET_PREM.resetValue();
		COMP_PC_LC_LOAD_AMT.resetValue();
		COMP_PC_LC_PAID_AMT.resetValue();
		COMP_PC_LC_DISCOUNT.resetValue();
		COMP_PC_DRCR_DOC_NO.resetValue();
		COMP_PC_LC_CHARGE.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_PC_PAID_FLAG.resetValue();
		COMP_PC_PREM_HOLIDAY_YN.resetValue();

		// Reseting HtmlCalendar
		COMP_PC_SCHD_PYMT_DT.resetValue();
		COMP_PC_DRCR_DOC_DT.resetValue();

	}


}
