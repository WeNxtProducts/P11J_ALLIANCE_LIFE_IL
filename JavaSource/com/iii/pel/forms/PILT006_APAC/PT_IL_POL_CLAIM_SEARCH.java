package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIData;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_CLAIM_SEARCH extends CommonAction{

	private HtmlOutputLabel COMP_CLAIM_NO_LABEL;

	private HtmlInputText COMP_CLAIM_NO;
	
	private HtmlOutputLabel COMP_CLAIM_POL_NO_LABEL;

	private HtmlInputText COMP_CLAIM_POL_NO;

	private HtmlCommandButton COMP_CLAIM_SEARCH_BUTTON;

	private HtmlCommandButton COMP_M_PRE_FORM_BUTTON;
	
	private HtmlCommandButton COMP_CLAIM_INSERT_BUTTON;
	
	private HtmlCommandButton COMP_UI_M_BUT_BACK;

	private UIData COMP_PT_IL_CLAIM_SEARCH_DATATABLE;

	private PT_IL_CLAIM PT_IL_CLAIM_BEAN;
	
	private CLAIM_SEARCH CLAIM_SEARCH_BEAN;

	private List<PT_IL_CLAIM> PT_IL_CLAIM_BEAN_LIST;

	public PT_IL_POL_CLAIM_SEARCH() {
		PT_IL_CLAIM_BEAN = new PT_IL_CLAIM();
		CLAIM_SEARCH_BEAN = new CLAIM_SEARCH();
	}
	
	public HtmlCommandButton getCOMP_UI_M_BUT_BACK() {
		return COMP_UI_M_BUT_BACK;
	}

	public void setCOMP_UI_M_BUT_BACK(HtmlCommandButton comp_ui_m_but_back) {
		COMP_UI_M_BUT_BACK = comp_ui_m_but_back;
	}



	public PT_IL_CLAIM getPT_IL_CLAIM_BEAN() {
		return PT_IL_CLAIM_BEAN;
	}

	public void setPT_IL_CLAIM_BEAN(PT_IL_CLAIM pt_il_claim_bean) {
		PT_IL_CLAIM_BEAN = pt_il_claim_bean;
	}

	public CLAIM_SEARCH getCLAIM_SEARCH_BEAN() {
		return CLAIM_SEARCH_BEAN;
	}

	public void setCLAIM_SEARCH_BEAN(CLAIM_SEARCH claim_search_bean) {
		CLAIM_SEARCH_BEAN = claim_search_bean;
	}

	public List<PT_IL_CLAIM> getPT_IL_CLAIM_BEAN_LIST() {
		return PT_IL_CLAIM_BEAN_LIST;
	}

	public void setPT_IL_CLAIM_BEAN_LIST(List<PT_IL_CLAIM> pt_il_claim_bean_list) {
		PT_IL_CLAIM_BEAN_LIST = pt_il_claim_bean_list;
	}

	public HtmlOutputLabel getCOMP_CLAIM_NO_LABEL() {
		return COMP_CLAIM_NO_LABEL;
	}

	public void setCOMP_CLAIM_NO_LABEL(HtmlOutputLabel comp_claim_no_label) {
		COMP_CLAIM_NO_LABEL = comp_claim_no_label;
	}

	public HtmlOutputLabel getCOMP_CLAIM_POL_NO_LABEL() {
		return COMP_CLAIM_POL_NO_LABEL;
	}

	public void setCOMP_CLAIM_POL_NO_LABEL(HtmlOutputLabel comp_claim_pol_no_label) {
		COMP_CLAIM_POL_NO_LABEL = comp_claim_pol_no_label;
	}

	public HtmlInputText getCOMP_CLAIM_NO() {
		return COMP_CLAIM_NO;
	}

	public void setCOMP_CLAIM_NO(HtmlInputText comp_claim_no) {
		COMP_CLAIM_NO = comp_claim_no;
	}

	public HtmlInputText getCOMP_CLAIM_POL_NO() {
		return COMP_CLAIM_POL_NO;
	}

	public void setCOMP_CLAIM_POL_NO(HtmlInputText comp_claim_pol_no) {
		COMP_CLAIM_POL_NO = comp_claim_pol_no;
	}

	public HtmlCommandButton getCOMP_CLAIM_SEARCH_BUTTON() {
		return COMP_CLAIM_SEARCH_BUTTON;
	}

	public void setCOMP_CLAIM_SEARCH_BUTTON(
			HtmlCommandButton comp_claim_search_button) {
		COMP_CLAIM_SEARCH_BUTTON = comp_claim_search_button;
	}

	public HtmlCommandButton getCOMP_M_PRE_FORM_BUTTON() {
		return COMP_M_PRE_FORM_BUTTON;
	}

	public void setCOMP_M_PRE_FORM_BUTTON(
			HtmlCommandButton comp_m_pre_form_button) {
		COMP_M_PRE_FORM_BUTTON = comp_m_pre_form_button;
	}

	public UIData getCOMP_PT_IL_CLAIM_SEARCH_DATATABLE() {
		return COMP_PT_IL_CLAIM_SEARCH_DATATABLE;
	}

	public void setCOMP_PT_IL_CLAIM_SEARCH_DATATABLE(
			UIData comp_pt_il_claim_search_datatable) {
		COMP_PT_IL_CLAIM_SEARCH_DATATABLE = comp_pt_il_claim_search_datatable;
	}

	public void onLoad(PhaseEvent event) {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		fetchRecords();
		sessionMap.put("PILT006_APAC_COMPOSITE_ACTION", new PILT006_APAC_COMPOSITE_ACTION());
		System.out.println("<<<<<<<<<<<<<<<<<<<<<onload>>>>>>>>>>>>>>>>>>>>>>>");
	}

	public void fetchRecords() {
		try {
			ArrayList<PT_IL_CLAIM> claimSearchList = fetchClaimDetails(FacesContext.getCurrentInstance());
			PT_IL_POL_CLAIM_SEARCH claimSearchAction = getCurrentActionInstance();
			claimSearchAction.setPT_IL_CLAIM_BEAN_LIST(claimSearchList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public String clearList() {
		
		PT_IL_CLAIM_BEAN=(PT_IL_CLAIM)COMP_PT_IL_CLAIM_SEARCH_DATATABLE.getRowData();
		PILT006_APAC_COMPOSITE_ACTION compositeAction = new PILT006_APAC_COMPOSITE_ACTION();
		String outcome = null;
		String callingForm = null;
		String callingFormName = CommonUtils.getGlobalVariable("CALLING_FORM");
		callingForm =CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM");
		//if(callingForm != null && callingForm.equalsIgnoreCase("PILT002_APAC")){
			if (((callingFormName.equalsIgnoreCase("PILT002_APAC"))
					 && (null == callingForm))
				|| (callingForm != null && callingForm
						.equalsIgnoreCase("PILT002_APAC"))) {
			FacesContext context =FacesContext.getCurrentInstance();
			Map requestParameterMap=context.getExternalContext().getRequestParameterMap();
			CommonUtils.setGlobalObject("PILT006_APAC_COMPOSITE_ACTION",compositeAction);
			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setROWID(PT_IL_CLAIM_BEAN.getROWID());
			CommonUtils.setGlobalVariable("CLAIM_ROW_ID",PT_IL_CLAIM_BEAN.getROWID());
			outcome = "claimsEntry";
		}else{
			CommonUtils.setGlobalVariable("CALLING_FORM","PILT006_APAC");
		}
		return outcome;
	}

	public ArrayList<PT_IL_CLAIM> fetchClaimDetails(FacesContext context)
			throws Exception {
		PT_IL_POL_CLAIM_SEARCH claimSearchAction = getCurrentActionInstance();
		CLAIM_SEARCH action = claimSearchAction.getCLAIM_SEARCH_BEAN();
		ArrayList<PT_IL_CLAIM> detailsList = null;
		String initClaimNo = null;
		boolean codeFlag = false;
		String initPolNo = null;

		String query = "SELECT PT_IL_CLAIM.ROWID, CLAIM_SYS_ID,CLAIM_POL_NO,CLAIM_NO,CLAIM_CUST_CODE,CLAIM_CLOSE_FLAG "
				+ "FROM PT_IL_CLAIM ";
		// iNITIAL fILTER cONDITION TO QUERY STRING
		if (action != null) {
			initClaimNo = action.getInitClaimNo();
			initPolNo = CommonUtils.getGlobalVariable("GLOBAL.M_POL_CLM_POL_NO");
			if (initClaimNo != null && initClaimNo.trim().length() > 0) {
				query = query + "WHERE UPPER(CLAIM_NO) LIKE '%"
						+ initClaimNo.trim().toUpperCase() + "%'";
				codeFlag = true;
			}
			if (initPolNo != null
					&& initPolNo.trim().length() > 0) {
				if (codeFlag) {
					query = query + "AND CLAIM_POL_NO LIKE '%" + initPolNo+"%'";
				} else {
					query = query + "WHERE CLAIM_POL_NO LIKE '%"
							+ initPolNo+"%'";
				}
			}
		}
		// To fETCH DETAILS
		System.out.println(query);
		Connection connection = PILT006_APAC_ACTION_INSTANCE.getConnection();
		if (connection != null) {
			ResultSet resultSet = null;
			try {
				CRUDHandler handler = new CRUDHandler();
				resultSet = handler.executeSelectStatement(query, connection);
				detailsList = new ArrayList<PT_IL_CLAIM>();
				PT_IL_CLAIM details = null;
				while (resultSet.next()) {
					details = new PT_IL_CLAIM();
					details.setROWID(resultSet.getString(1));
					details.setCLAIM_SYS_ID(resultSet.getLong("CLAIM_SYS_ID"));
					details.setCLAIM_CUST_CODE(resultSet.getString("CLAIM_CUST_CODE"));
					details.setCLAIM_POL_NO(resultSet.getString("CLAIM_POL_NO"));
					details.setCLAIM_NO(resultSet.getString("CLAIM_NO"));
					setStatusInfo(details);
					detailsList.add(details);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try{
					CommonUtils.closeCursor(resultSet);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return detailsList;
	}

	/*public Object xyz(String sysid, Object obj) {
		Connection connection = PILT006_APAC_ACTION_INSTANCE.getConnection();
		PT_IL_CLAIM claim = (PT_IL_CLAIM) obj;
		try {

			String selectQuery = "SELECT CLAIM_PCI_REF_NO, CLAIM_POL_NO, CLAIM_ASSR_CODE,CLAIM_CUST_CODE,"
					+ "CLAIM_ACCNT_PAY_CODE,CLAIM_TYPE,CLAIM_MED_CODE,CLAIM_LOSS_DT,CLAIM_INTM_DT,"
					+ "CLAIM_LC_RLA_AMOUNT,CLAIM_NO,CLAIM_CURR_CODE,CLAIM_REF_NO,CLAIM_REMARKS,"
					+ "CLAIM_CR_DT,CLAIM_RESV_AMT,CLAIM_UTIL_AMT,CLAIM_REOPEN_DT,CLAIM_REOPEN_REASON," +
							"CLAIM_SYS_ID,CLAIM_POL_SYS_ID,CLAIM_DS_CODE,CLAIM_EXCH_RATE,CLAIM_FRZ_FLAG  "
					+ "FROM PT_IL_CLAIM WHERE CLAIM_SYS_ID='" + sysid + "'";

			CRUDHandler handler = new CRUDHandler();
			ResultSet result = handler.executeSelectStatement(selectQuery, connection);
			while (result.next()) {
				claim.setCLAIM_SYS_ID(result.getDouble("CLAIM_SYS_ID"));
				claim.setCLAIM_POL_SYS_ID(result.getDouble("CLAIM_POL_SYS_ID"));
				claim.setUI_M_CLAIM_DS_CODE(result.getString("CLAIM_DS_CODE"));
				claim.setCLAIM_EXCH_RATE(result.getDouble("CLAIM_EXCH_RATE"));
				claim.setCLAIM_FRZ_FLAG(result.getString("CLAIM_FRZ_FLAG"));
				claim.setCLAIM_PCI_REF_NO(result.getString(1));
				claim.setCLAIM_POL_NO(result.getString(2));
				claim.setCLAIM_ASSR_CODE(result.getString(3));
				claim.setCLAIM_CUST_CODE(result.getString(4));

				claim.setCLAIM_ACCNT_PAY_CODE(result.getString(5));
				claim.setCLAIM_TYPE(result.getString(6));
				claim.setCLAIM_MED_CODE(result.getString(7));
				// claim.setUI_M_CLAIM_MED_CODE_NAME(result.getString(8));

				claim.setCLAIM_LOSS_DT(result.getDate(8));
				claim.setCLAIM_INTM_DT(result.getDate(9));
				claim.setCLAIM_LC_RLA_AMOUNT(result.getDouble(10));
				claim.setCLAIM_NO(result.getString(11));

				claim.setCLAIM_CURR_CODE(result.getString(12));
				// claim.setUI_M_CLAIM_CURR_CODE_DESC(result.getString(14));
				claim.setCLAIM_REF_NO(result.getString(13));
				claim.setCLAIM_REMARKS(result.getString(14));

				claim.setCLAIM_CR_DT(result.getDate(15));
				// claim.setUI_M_CLAIM_ASS_NAME(result.getString(18));
				// claim.setUI_M_CLAIM_ACCNT_PAY_CODE_DESC(result.getString(19));
				// claim.setUI_M_CUST_DESC(result.getString(20));

				claim.setCLAIM_RESV_AMT(result.getDouble(16));
				claim.setCLAIM_UTIL_AMT(result.getDouble(17));
				claim.setCLAIM_REOPEN_DT(result.getDate(18));
				claim.setCLAIM_REOPEN_REASON(result.getString(19));

			}
			result.close();
		} catch (Exception e) {
		}
		return claim;
	}
	*/
	public String insertClaim(){
		PILT006_APAC_ACTION_INSTANCE.getClaimActionInstance().setPT_IL_CLAIM_BEAN(new PT_IL_CLAIM());
		//PILT006_APAC_ACTION_INSTANCE.getClaimActionInstance().setSearchMode(false);
		return "claimsEntry";
	}
	
	public PT_IL_POL_CLAIM_SEARCH getCurrentActionInstance(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		return (PT_IL_POL_CLAIM_SEARCH) sessionMap.get("PILT006_APAC_PT_IL_POL_CLAIM_SEARCH_ACTION");
	}
	
	public void setStatusInfo(PT_IL_CLAIM claimBean){
		Long CLAIM_SYS_ID = claimBean.getCLAIM_SYS_ID();
		String sql_C2="SELECT MAX(CS_SYS_ID) FROM  PT_IL_CLAIM_STATUS  " +
 				"WHERE  CS_CLM_SYS_ID  = ? ";
		String sql_C3="SELECT CS_STATUS_CODE FROM  PT_IL_CLAIM_STATUS  " +
		 		"WHERE  CS_CLM_SYS_ID  = ?  " +
		 		"AND CS_SYS_ID  = ? ";
		String sql_C4="SELECT PS_CODE_DESC FROM  PP_SYSTEM  " +
		 		"WHERE  PS_TYPE  = 'IL_ADDL_STAT'  " +
		 		"AND PS_CODE  = ? ";
		CRUDHandler handler = new CRUDHandler();
		Double M_CS_SYS_ID = null;
		Connection connection = PILT006_APAC_ACTION_INSTANCE.getConnection();
		try {
			ResultSet rst = handler.executeSelectStatement(sql_C2, connection, new Object[]{CLAIM_SYS_ID});
			while(rst.next()){
				M_CS_SYS_ID = rst.getDouble(1);
			}
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String M_CS_STATUS_CODE = null;
		try {
			ResultSet rst = handler.executeSelectStatement(sql_C3, connection, new Object[]{CLAIM_SYS_ID, M_CS_SYS_ID});
			while(rst.next()){
				M_CS_STATUS_CODE = rst.getString(1);
			}
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Double M_CALC_METHOD = claimBean.getUI_M_CALC_METHOD();
        if((M_CALC_METHOD==null?1.0:M_CALC_METHOD)==2.0){
	       	 String M_CLAIM_STATUS = null;
	       	 try {
	       		ResultSet rst = handler.executeSelectStatement(sql_C4, connection, new Object[]{M_CS_STATUS_CODE});
					while(rst.next()){
						M_CLAIM_STATUS = rst.getString(1);
					}
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	       	 if(M_CLAIM_STATUS==null){
	       		 claimBean.setUI_M_CLAIM_STATUS("REGISTERED");
	       	 }
        }else{
        	String M_DESC = null;
	       	 try {
	       		ResultSet rst = handler.executeSelectStatement(sql_C4, connection, new Object[]{M_CS_STATUS_CODE});
					while(rst.next()){
						M_DESC = rst.getString(1);
					}
					try {
						CommonUtils.closeCursor(rst);
					} catch (Exception e) {
						e.printStackTrace();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
	       	 if(M_DESC!=null)
	       		 claimBean.setUI_M_CLAIM_ADDL_STATUS(M_CS_STATUS_CODE+" : "+M_DESC);
	       	 else
	       		 claimBean.setUI_M_CLAIM_ADDL_STATUS("REGISTERED");
        }
        
        String CLAIM_CLOSE_FLAG = claimBean.getCLAIM_CLOSE_FLAG();
        if((CLAIM_CLOSE_FLAG==null?"N":CLAIM_CLOSE_FLAG).equals("Y")){
        	claimBean.setUI_M_CLOSE_FLAG("CLOSED");
        }else{
       	 	claimBean.setUI_M_CLOSE_FLAG("");
        }
	}
	
	public String backToPolicy(){
		if("PILT006_APAC".equalsIgnoreCase(CommonUtils.getGlobalVariable("CLAIM_CALLING_FORM"))){
			CommonUtils.setGlobalVariable("CALLING_FORM", "PILT006_APAC");
		}
		return "PILT002_APAC_PT_IL_POLICY";
	}

	public HtmlCommandButton getCOMP_CLAIM_INSERT_BUTTON() {
		return COMP_CLAIM_INSERT_BUTTON;
	}

	public void setCOMP_CLAIM_INSERT_BUTTON(
			HtmlCommandButton comp_claim_insert_button) {
		COMP_CLAIM_INSERT_BUTTON = comp_claim_insert_button;
	}

}
