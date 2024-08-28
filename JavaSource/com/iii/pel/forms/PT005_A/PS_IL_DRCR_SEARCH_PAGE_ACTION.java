package com.iii.pel.forms.PT005_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_DRCR_SEARCH_PAGE_ACTION extends CommonAction {

	private UIDataTable dataTable;
	private ArrayList accountsQueryList;
	private String policyNo;
	private String custCode;
	private String claimNo;
	private String endNo;
	private String docNo;

	private String storedPolicyNo;
	private String storedCustCode;
	private String storedClaimNo;
	private String storedEndNo;
	private String storedDocNo;
	private String storedLcAmount;
	POLICY_LEDGER_QUERY_SEARCH searchBean;
	private ArrayList<POLICY_LEDGER_QUERY_SEARCH> searchList = new ArrayList<POLICY_LEDGER_QUERY_SEARCH>();

	public ArrayList<POLICY_LEDGER_QUERY_SEARCH> getSearchList() {
		return searchList;
	}

	public void setSearchList(ArrayList<POLICY_LEDGER_QUERY_SEARCH> searchList) {
		this.searchList = searchList;
	}

	public POLICY_LEDGER_QUERY_SEARCH getSearchBean() {
		return searchBean;
	}

	public void setSearchBean(POLICY_LEDGER_QUERY_SEARCH searchBean) {
		this.searchBean = searchBean;
	}

	public PS_IL_DRCR_SEARCH_PAGE_ACTION() {
		searchBean = new POLICY_LEDGER_QUERY_SEARCH();
		accountsQueryList = new ArrayList();
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public ArrayList getAccountsQueryList() {
		return accountsQueryList;
	}

	public void setAccountsQueryList(ArrayList accountsQueryList) {
		this.accountsQueryList = accountsQueryList;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getStoredPolicyNo() {
		return storedPolicyNo;
	}

	public void setStoredPolicyNo(String storedPolicyNo) {
		this.storedPolicyNo = storedPolicyNo;
	}

	public String getStoredCustCode() {
		return storedCustCode;
	}

	public void setStoredCustCode(String storedCustCode) {
		this.storedCustCode = storedCustCode;
	}

	public String getStoredClaimNo() {
		return storedClaimNo;
	}

	public void setStoredClaimNo(String storedClaimNo) {
		this.storedClaimNo = storedClaimNo;
	}

	public String getStoredEndNo() {
		return storedEndNo;
	}

	public void setStoredEndNo(String storedEndNo) {
		this.storedEndNo = storedEndNo;
	}

	public String getStoredDocNo() {
		return storedDocNo;
	}

	public void setStoredDocNo(String storedDocNo) {
		this.storedDocNo = storedDocNo;
	}

	public String fetchDataBaseDetails() throws DBException,
			SQLException {
		PS_IL_DRCR_DELEAGTE ps_il_drcr_deleagte = new PS_IL_DRCR_DELEAGTE();
		FacesContext ctx = FacesContext.getCurrentInstance();
		PS_IL_DRCR_ACTION ps_il_drcr_action = new PS_IL_DRCR_ACTION();
		// accountsQueryList =
		// ps_il_drcr_deleagte.fetchAccountsQueryDetailsFromDatabase(this);

		String formattedDate = null;
		searchList.clear();
		CRUDHandler handler = new CRUDHandler();
		String POL_CUST_CODE = searchBean.getPOL_CUST_CODE();
		String POL_CUST_NAME = searchBean.getPOL_CUST_NAME();
		String POL_NO = searchBean.getPOL_NO();
		String POL_QUOT_NO = searchBean.getPOL_QUOT_NO();
		String POL_END_NO = searchBean.getPOL_END_NO();
		String DRCR_CLAIM_NO = searchBean.getDRCR_CLAIM_NO();

		String DRCR_TXN_CODE = searchBean.getDRCR_TXN_CODE();
		String DRCR_DOC_NO = searchBean.getDRCR_DOC_NO();
		Date DRCR_DOC_DATE = searchBean.getDRCR_DOC_DT();
		/*
		 * String date1=CommonUtils.dateToPELStringFormatter(DRCR_DOC_DATE);
		 * String
		 * date2=CommonUtils.dateToStringFormatter(DRCR_DOC_DATE).toUpperCase();
		 * System.out.println(date1.toUpperCase());
		 * System.out.println(date2.toUpperCase());
		 */
		if (DRCR_DOC_DATE != null && !"".equals(DRCR_DOC_DATE)) {
			formattedDate = new SimpleDateFormat("dd-MMM-yy").format(
					DRCR_DOC_DATE).toUpperCase();
		}
		// String date=CommonUtils.dateToStringFormat(DRCR_DOC_DATE);
		Long DRCR_SEQ_NO = searchBean.getDRCR_SEQ_NO();
		if (CommonUtils.nvl(DRCR_SEQ_NO, 0) == 0) {
			DRCR_SEQ_NO = null;
		}
		String DRCR_DOC_TYPE = searchBean.getDRCR_DOC_TYPE();
		String DRCR_DRCR_FLAG = searchBean.getDRCR_DRCR_FLAG();
		String DRCR_CURR_CODE = searchBean.getDRCR_CURR_CODE();
		try {
			Connection con = CommonUtils.getConnection();
			// String searchQuery = PGLQ015Constants.searchQuery;
			// String searchQuery = PGLQ015Constants.searchQuery1;

			/*Commented as per vaitheeswaran and sivaraman suggestion dt: 21-09-2018 
			 * 
			 * String searchQuery = "SELECT D.ROWID, D.DRCR_POL_SYS_ID, D.DRCR_CUST_CODE, D.DRCR_POL_NO,D.DRCR_CLAIM_NO,D.DRCR_END_NO,"
					+ "  D.DRCR_TXN_CODE,D.DRCR_DOC_NO, D.DRCR_DOC_DT, D.DRCR_SEQ_NO,D.DRCR_DOC_TYPE,D.DRCR_DRCR_FLAG,"
					+ "  D.DRCR_CURR_CODE, D.DRCR_LC_AMT,D.DRCR_MAIN_ACNT_CODE, D.DRCR_SUB_ACNT_CODE,D.DRCR_ACNT_YEAR FROM PS_IL_DRCR D "
					+ " WHERE (NVL(D.DRCR_TXN_CODE, '*') LIKE nvl(?, '%'))"
					+ "  AND (NVL(D.DRCR_DOC_NO, 0) LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_DOC_DT, '01/jan/1990') LIKE NVL(?, '%'))"
					+ "  AND (NVL(D.DRCR_SEQ_NO, 0) LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_CUST_CODE, '*') LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_POL_NO, '*') LIKE NVL(?, '%'))"
					+ "  AND (NVL(D.DRCR_CLAIM_NO, '*') LIKE NVL(?, '%'))"
					+ "   AND ROWNUM < 50 ORDER BY D.DRCR_TXN_CODE, D.DRCR_DOC_NO, D.DRCR_DOC_DT, D.DRCR_SEQ_NO";*/
			
			
			
			/*String searchQuery = "SELECT D.ROWID, D.DRCR_POL_SYS_ID,D.DRCR_CUST_CODE,D.DRCR_POL_NO,D.DRCR_CLAIM_NO,D.DRCR_END_NO,D.DRCR_TXN_CODE,D.DRCR_DOC_NO,D.DRCR_DOC_DT,D.DRCR_SEQ_NO,D.DRCR_DOC_TYPE,D.DRCR_DRCR_FLAG,D.DRCR_CURR_CODE,D.DRCR_LC_AMT,D.DRCR_MAIN_ACNT_CODE,D.DRCR_SUB_ACNT_CODE,D.DRCR_ACNT_YEAR,D.DRCR_NARRATION  FROM PS_IL_DRCR D "
									+" WHERE (NVL(D.DRCR_TXN_CODE, '*') LIKE nvl(?, '%'))"
									+ "   AND (NVL(D.DRCR_DOC_NO, 0) LIKE NVL(?, '%'))"
									+ "   AND (NVL(D.DRCR_DOC_DT, '01/jan/1990') LIKE NVL(?, '%'))"
									+ "   AND (NVL(D.DRCR_SEQ_NO, 0) LIKE NVL(?, '%'))"
									+ "   AND (NVL(D.DRCR_CUST_CODE, '*') LIKE NVL(?, '%'))"
									+ "   AND (NVL(D.DRCR_POL_NO, '*') LIKE NVL(?, '%'))"
									+ "   AND (NVL(D.DRCR_CLAIM_NO, '*') LIKE NVL(?, '%'))"
									+ "   AND ROWNUM < 50"
									+ " ORDER BY D.DRCR_TXN_CODE, D.DRCR_DOC_NO, D.DRCR_DOC_DT, D.DRCR_SEQ_NO";
			
			*/
			
		/*	String searchQuery = 	"SELECT D.ROWID,"
					+ "		       D.DRCR_POL_SYS_ID,"
					+ "		       D.DRCR_CUST_CODE,"
					+ "		       D.DRCR_POL_NO,"
					+ "		       D.DRCR_CLAIM_NO,"
					+ "		       D.DRCR_END_NO,"
					+ "		       D.DRCR_TXN_CODE,"
					+ "		       D.DRCR_DOC_NO,"
					+ "		       D.DRCR_DOC_DT,"
					+ "		       D.DRCR_SEQ_NO,"
					+ "		       D.DRCR_DOC_TYPE,"
					+ "		       D.DRCR_DRCR_FLAG,"
					+ "		       D.DRCR_CURR_CODE,"
					+ "		       D.DRCR_LC_AMT,"
					+ "		       D.DRCR_MAIN_ACNT_CODE,"
					+ "		       D.DRCR_SUB_ACNT_CODE,"
					+ "		       D.DRCR_ACNT_YEAR,"
					+ "		       D.DRCR_NARRATION,"
					+ "		       D.DRCR_bl_NARRATION"
					+ "		  FROM PS_IL_DRCR D"
					+ "		 WHERE (NVL(D.DRCR_TXN_CODE, '*') LIKE nvl(?, '%'))"
					+ "		   AND (NVL(D.DRCR_DOC_NO, 0) LIKE NVL(?, '%'))"
					+ "		   AND (NVL(D.DRCR_DOC_DT, '01/jan/1990') LIKE NVL(?, '%'))"
					+ "		   AND (NVL(D.DRCR_SEQ_NO, 0) LIKE NVL(?, '%'))"
					+ "		   AND (NVL(D.DRCR_CUST_CODE, '*') LIKE NVL(?, '%'))"
					+ "		   AND (NVL(D.DRCR_POL_NO, '*') LIKE NVL(?, '%'))"
					+ "		   AND (NVL(D.DRCR_CLAIM_NO, '*') LIKE NVL(?, '%'))"
					+ "		   AND ROWNUM < 50"
					+ "		 ORDER BY D.DRCR_TXN_CODE, D.DRCR_DOC_NO, D.DRCR_DOC_DT, D.DRCR_SEQ_NO";
			*/

			/*
			 * "SELECT
			 * D.ROWID,P.POL_SYS_ID,P.POL_CUST_CODE,P.POL_NO,D.DRCR_CLAIM_NO,D.DRCR_END_NO,D.DRCR_TXN_CODE,D.DRCR_DOC_NO,D.DRCR_DOC_DT,D.DRCR_SEQ_NO,D.DRCR_DOC_TYPE, " + "
			 * D.DRCR_DRCR_FLAG,D.DRCR_CURR_CODE,D.DRCR_LC_AMT,D.DRCR_MAIN_ACNT_CODE,D.DRCR_SUB_ACNT_CODE, " + "
			 * D.DRCR_ACNT_YEAR FROM PT_IL_POLICY P, PS_IL_DRCR D,PM_CUSTOMER C " + "
			 * WHERE P.POL_SYS_ID = D.DRCR_POL_SYS_ID " + " AND P.POL_CUST_CODE =
			 * C.CUST_CODE " + " AND (NVL(D.DRCR_TXN_CODE,'*') LIKE nvl(?,'%')) "+ "
			 * AND (NVL(D.DRCR_DOC_NO,0) LIKE NVL(?,'%')) " + " AND
			 * (NVL(D.DRCR_DOC_DT,'01/jan/1990') LIKE NVL(?,'%')) " + " AND
			 * (NVL(D.DRCR_SEQ_NO,0) LIKE NVL(?,'%')) " + " AND
			 * (NVL(P.POL_CUST_CODE,'*') LIKE NVL(?,'%')) " + // " AND
			 * (NVL(D.DRCR_DRCR_FLAG,'*') LIKE NVL(?,'%')) " + " AND
			 * (NVL(P.POL_NO,'*') LIKE NVL(?,'%')) " + " AND
			 * (NVL(D.DRCR_CLAIM_NO,'*') LIKE NVL(?,'%')) " + " AND ROWNUM<25
			 * ORDER BY
			 * D.DRCR_TXN_CODE,D.DRCR_DOC_NO,D.DRCR_DOC_DT,D.DRCR_SEQ_NO";
			 */
			
			
			
			/*Commented and modified by pidugu raj as suggested by Sitrarasan for Surrender values not coming
			 * String searchQuery = "SELECT D.ROWID,"
					+ " D.DRCR_POL_SYS_ID,"
					+ " D.DRCR_CUST_CODE,"
					+ " D.DRCR_POL_NO,"
					+ " D.DRCR_CLAIM_NO,"
					+ " D.DRCR_END_NO,"
					+ " D.DRCR_TXN_CODE,"
					+ " D.DRCR_DOC_NO,"
					+ " D.DRCR_DOC_DT,"
					+ " D.DRCR_SEQ_NO,"
					+ " D.DRCR_DOC_TYPE,"
					+ " D.DRCR_DRCR_FLAG,"
					+ " D.DRCR_CURR_CODE,"
					+ " D.DRCR_LC_AMT,"
					+ " D.DRCR_MAIN_ACNT_CODE,"
					+ " D.DRCR_SUB_ACNT_CODE,"
					+ " D.DRCR_ACNT_YEAR,"
					+ " (select main_acnt_name"
					+ " from fm_main_account"
					+ " where main_acnt_code = D.DRCR_MAIN_ACNT_CODE) as main_acnt_code,"
					+ " (select sub_acnt_name"
					+ " from fm_sub_account"
					+ " where sub_acnt_code = D.DRCR_SUB_ACNT_CODE) as sub_acnt_code"
					+ " FROM PS_IL_DRCR D"
					+ " WHERE (NVL(D.DRCR_TXN_CODE, '*') LIKE nvl(?, '%'))"
					+ " AND (NVL(D.DRCR_DOC_NO, 0) LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_DOC_DT, '01/jan/1990') LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_SEQ_NO, 0) LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_CUST_CODE, '*') LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_POL_NO, '*') LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_CLAIM_NO, '*') LIKE NVL(?, '%'))"
					+ " AND ROWNUM < 50"
					+ " ORDER BY D.DRCR_TXN_CODE, D.DRCR_DOC_NO, D.DRCR_DOC_DT, D.DRCR_SEQ_NO";*/
			
			
			String searchQuery = "SELECT D.ROWID,"
					+ " D.DRCR_POL_SYS_ID,"
					+ " D.DRCR_CUST_CODE,"
					+ " D.DRCR_POL_NO,"
					+ " D.DRCR_CLAIM_NO,"
					+ " D.DRCR_END_NO,"
					+ " D.DRCR_TXN_CODE,"
					+ " D.DRCR_DOC_NO,"
					+ " D.DRCR_DOC_DT,"
					+ " D.DRCR_SEQ_NO,"
					+ " D.DRCR_DOC_TYPE,"
					+ " D.DRCR_DRCR_FLAG,"
					+ " D.DRCR_CURR_CODE,"
					+ " D.DRCR_LC_AMT,"
					+ " D.DRCR_MAIN_ACNT_CODE,"
					+ " D.DRCR_SUB_ACNT_CODE,"
					+ " D.DRCR_ACNT_YEAR,"
					+ " (select main_acnt_name"
					+ " from fm_main_account"
					+ " where main_acnt_code = D.DRCR_MAIN_ACNT_CODE) as main_acnt_code,"
					+ " (select sub_acnt_name"
					+ " from fm_sub_account"
					+ " where sub_acnt_code = D.DRCR_SUB_ACNT_CODE) as sub_acnt_code"
					+ " FROM PS_IL_DRCR D"
					+ " WHERE (NVL(D.DRCR_TXN_CODE, '*') LIKE nvl(?, '%'))"
					+ " AND (NVL(D.DRCR_DOC_NO, 0) LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_DOC_DT, '01/jan/1990') LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_SEQ_NO, 0) LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_CUST_CODE, '*') LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_POL_NO, '*') LIKE NVL(?, '%'))"
					+ " AND (NVL(D.DRCR_CLAIM_NO, '*') LIKE NVL(?, '%'))"
					+ " ORDER BY D.DRCR_TXN_CODE, D.DRCR_DOC_NO, D.DRCR_DOC_DT, D.DRCR_SEQ_NO";
					/*End Newly added by pidugu raj dt: 14-10-2020 for Surrender values not coming*/
					
			Object[] queryConditions = new Object[7];
			queryConditions[0] = (DRCR_TXN_CODE == null || ""
					.equalsIgnoreCase(DRCR_TXN_CODE)) ? null : "%"
					+ DRCR_TXN_CODE + "%";
			queryConditions[1] = (DRCR_DOC_NO == null || ""
					.equalsIgnoreCase(DRCR_DOC_NO)) ? null : "%" + DRCR_DOC_NO
					+ "%";
			queryConditions[2] = DRCR_DOC_DATE == null ? null : "%"
					+ formattedDate + "%";
			queryConditions[3] = (DRCR_SEQ_NO == null) ? null : "%"
					+ DRCR_SEQ_NO + "%";
			queryConditions[4] = (POL_CUST_CODE == null || ""
					.equalsIgnoreCase(POL_CUST_CODE)) ? null : "%"
					+ POL_CUST_CODE + "%";
			// queryConditions[5] = (DRCR_DRCR_FLAG==null ||
			// "".equalsIgnoreCase(DRCR_DRCR_FLAG))?null:"%"+DRCR_DRCR_FLAG+"%";
			queryConditions[5] = (POL_NO == null || "".equalsIgnoreCase(POL_NO)) ? null
					: "%" + POL_NO + "%";
			queryConditions[6] = (DRCR_CLAIM_NO == null || ""
					.equalsIgnoreCase(DRCR_CLAIM_NO)) ? null : "%"
					+ DRCR_CLAIM_NO + "%";
			/*
			 * queryConditions[1] = "%"+DRCR_DOC_NO+"%"; queryConditions[2] =
			 * "%"+DRCR_DOC_DATE+"%"; queryConditions[3] = "%"+DRCR_SEQ_NO+"%";
			 * queryConditions[4] = "%"+DRCR_DOC_TYPE+"%"; queryConditions[5] =
			 * "%"+DRCR_DRCR_FLAG+"%"; queryConditions[6] =
			 * "%"+DRCR_CURR_CODE+"%";
			 */

			ResultSet rs = handler.executeSelectStatement(searchQuery, con,
					queryConditions);
			while (rs.next()) {
				POLICY_LEDGER_QUERY_SEARCH search = new POLICY_LEDGER_QUERY_SEARCH();
				/*
				 * 
				 * 
				 * 
				 * 
				 * search.setPOL_END_NO(rs.getString("DRCR_END_NO"));
				 * search.setDRCR_CLAIM_NO(rs.getString("DRCR_CLAIM_NO"));
				 */
				search.setRowId(rs.getString("ROWID"));
				search.setPOL_CUST_CODE(rs.getString("DRCR_CUST_CODE"));
				search.setPOL_NO(rs.getString("DRCR_POL_NO"));
				search.setDRCR_TXN_CODE(rs.getString("DRCR_TXN_CODE"));
				search.setDRCR_DOC_NO(rs.getString("DRCR_DOC_NO"));
				search.setDRCR_DOC_DT(rs.getDate("DRCR_DOC_DT"));
				search.setDRCR_SEQ_NO(rs.getLong("DRCR_SEQ_NO"));
				search.setDRCR_DOC_TYPE(rs.getString("DRCR_DOC_TYPE"));
				search.setDRCR_DRCR_FLAG(rs.getString("DRCR_DRCR_FLAG"));
				search.setDRCR_CURR_CODE(rs.getString("DRCR_CURR_CODE"));
				search.setDRCR_LC_AMT(rs.getDouble("DRCR_LC_AMT"));
				search.setDRCR_MAIN_ACNT_CODE(rs
						.getString("DRCR_MAIN_ACNT_CODE"));
				search
						.setDRCR_SUB_ACNT_CODE(rs
								.getString("DRCR_SUB_ACNT_CODE"));
				search.setDRCR_ACNT_YEAR(rs.getLong("DRCR_ACNT_YEAR"));
				search.setDRCR_CLAIM_NO(rs.getString("DRCR_CLAIM_NO"));
				search.setPOL_END_NO(rs.getString("DRCR_END_NO"));
				search.setDRCR_NARRATION(rs.getString("main_acnt_code"));
				search.setDRCR_BL_NARRATION(rs.getString("sub_acnt_code"));
				searchList.add(search);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String navigateToAccountsQuery() throws Exception {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) facesContext
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PS_IL_DRCR_ACTION ps_il_drcr_action = new PS_IL_DRCR_ACTION();

		PS_IL_DRCR_DELEAGTE ps_il_drcr_deleagte = new PS_IL_DRCR_DELEAGTE();
		session.setAttribute("PT005_A_PS_IL_DRCR_ACTION", ps_il_drcr_action);
		String rowId = request.getParameter("rowid");
		System.out.println("ROW ID: " + rowId);
		String polNo = request.getParameter("polNo");
		System.out.println("polNo: " + polNo);
		PS_IL_DRCR accountingBean = (PS_IL_DRCR) getDataTable().getRowData();

		// [PREMIAGDC-Accounting Query-000099:Shankar Bodduluri 03-Mar-09
		// [fetching records based on rowid]Internal Fix
		List<PS_IL_DRCR> beanList = ps_il_drcr_deleagte
				.fetchAccountQueryDetails(accountingBean, this);
		Iterator<PS_IL_DRCR> iterator = beanList.iterator();
		PS_IL_DRCR PS_IL_DRCR_BEAN = null;
		while (iterator.hasNext()) {
			PS_IL_DRCR_BEAN = iterator.next();
			PS_IL_DRCR_BEAN.setRowSelected(false);
		}
		ps_il_drcr_action.setDataListPS_IL_DRCR(beanList);
		if (beanList.size() > 0) {
			ps_il_drcr_action.setPS_IL_DRCR_BEAN(beanList.get(0));
			ps_il_drcr_action.getPS_IL_DRCR_BEAN().setRowSelected(true);
		}
		// ps_il_drcr_action.resetAllComponent();

		this.accountsQueryList = null;
		// return "navigateToAccountQuery";
		return "GO_TO_PT005_A_PS_IL_DRCR";
	}

	public String executeQuery() throws Exception {
		FacesContext ctx = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext()
				.getRequest();
		String POL_CUST_CODE = req.getParameter("POL_CUST_CODE");
		String ROWID = req.getParameter("rowID");
		/*
		 * POLICY_LEDGER_QUERY_SEARCH selectedSearchBean =
		 * (POLICY_LEDGER_QUERY_SEARCH) dataTable.getRowData();
		 * CommonUtils.setGlobalObject("PT005_SELECTED_SEARCH",
		 * selectedSearchBean);
		 * CommonUtils.setGlobalVariable("GLOBAL.POLICY_POL_CUST_CODE",
		 * POL_CUST_CODE); CommonUtils.setGlobalVariable("GLOBAL.POLICY_ROWID",
		 * ROWID); CommonUtils.setGlobalObject("PGLQ015_PT_GL_POLICY_ACTION",
		 * new PS_IL_DRCR_ACTION()); return "GO_TO_PT005_A_PS_IL_DRCR";
		 */
		PS_IL_DRCR_ACTION action = new PS_IL_DRCR_ACTION();
		String outcome = null;
		CommonUtils.setGlobalObject("PT005_A_PS_IL_DRCR_ACTION", action);
		action.getPS_IL_DRCR_BEAN().setROWID(ROWID);
		outcome = "GO_TO_PT005_A_PS_IL_DRCR";
		return outcome;
	}

	public String getCustCode() {
		return custCode;
	}

	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}

	public String getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(String claimNo) {
		this.claimNo = claimNo;
	}

	public String getEndNo() {
		return endNo;
	}

	public void setEndNo(String endNo) {
		this.endNo = endNo;
	}

	public String getDocNo() {
		return docNo;
	}

	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}

	public String getStoredLcAmount() {
		return storedLcAmount;
	}

	public void setStoredLcAmount(String storedLcAmount) {
		this.storedLcAmount = storedLcAmount;
	}

}
