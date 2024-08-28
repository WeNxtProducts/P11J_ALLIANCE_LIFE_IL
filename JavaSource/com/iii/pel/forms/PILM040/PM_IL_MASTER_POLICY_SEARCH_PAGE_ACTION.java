package com.iii.pel.forms.PILM040;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.component.html.HtmlDataTable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_MASTER_POLICY_SEARCH_PAGE_ACTION extends CommonAction {

	private List<PM_IL_MASTER_POLICY> recordList;
	private HtmlDataTable dataTable;

	private int deletedIndex;

	// private PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE
	// PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN;

	private PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN;

	private String customerCode;

	private String policyNo;

	private String productCode;

	public PM_IL_MASTER_POLICY_SEARCH_PAGE_ACTION() {
		this.PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN = new PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE();
	}

	public PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE getPM_IL_FUND_ACCOUNT_SETUP_SEARCH_PAGE_BEAN() {
		return PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN;
	}

	public void setPM_IL_FUND_ACCOUNT_SETUP_SEARCH_PAGE_BEAN(
			PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE pm_il_fund_account_setup_search_page_bean) {
		PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN = pm_il_fund_account_setup_search_page_bean;
	}

	public List<PM_IL_MASTER_POLICY> getRecordList() {
		return recordList;
	}

	public void setRecordList(List<PM_IL_MASTER_POLICY> recordList) {
		this.recordList = recordList;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public String fetchButtonClick() throws Exception {
		PM_IL_MASTER_POLICY_SEARCH_PAGE_DELEGATE delegate = new PM_IL_MASTER_POLICY_SEARCH_PAGE_DELEGATE();
		this.recordList = delegate.fetchClassMasterDetails(this);
		// recordList=new ArrayList<PM_IL_MASTER_POLICY>();
		return null;
	}

	public String fetchMasterList() {
		return "";
	}

	public String goToMainScreen() {
		return "";
	}

	public void displayMasterDetails() {

	}

	public String clearSession() {
		getErrorMap().clear();
		getWarningMap().clear();
		FacesContext context = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) context.getExternalContext()
				.getSession(false);
		if (session.getAttribute("PILM040_PM_IL_MASTER_POLICY_ACTION") != null) {
			session.removeAttribute("PILM040_PM_IL_MASTER_POLICY_ACTION");
		}
		try {
			//new PM_IL_PROD_HELPER().pm_il_product_when_create_record();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "pilm040_mainForm";
	}

	public String navigationToMainPage() throws Exception {
		// prepareClassMasterDetails();

		// GetCustomerCode();

		String returnString = "pilm040_mainForm";
		String mappedBeanName = "PILM040_PM_IL_MASTER_POLICY_ACTION";
        String policyNumber=null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_MASTER_POLICY_ACTION actionBean = new PM_IL_MASTER_POLICY_ACTION();
		PM_IL_MASTER_POLICY pm_il_master_policy = actionBean
				.getPM_IL_MASTER_POLICY_BEAN();

		session.setAttribute(mappedBeanName, actionBean);
		String customerCode = request.getParameter("CustomerCode");
		System.out.println("Customercode%%%%" + customerCode);
        
		if (customerCode != null) {
			pm_il_master_policy = (PM_IL_MASTER_POLICY) fetchMasterDetails(
					customerCode, pm_il_master_policy);
			CommonUtils.objectSysout(pm_il_master_policy);
		}

		return returnString;

	}

	public Object fetchMasterDetails(String customerCode,
			PM_IL_MASTER_POLICY pm_il_master_policy) throws DBException {
		CRUDHandler handler = new CRUDHandler();
		System.out.println("****Customer Code Fetching records****");
		String queryString = PILM040_SQLQUERY_CONSTANTS.SELECT_ALL_PM_IL_MASTER_POLICY_SETUP;
		System.out.println("Query String " + queryString);
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			if ((customerCode != null) && (customerCode.trim().length() > 0)) {
				System.out.println("CUSTOMER CODE :" + customerCode);
				Object[] objects = { customerCode };

				resultSet = handler.executeSelectStatement(queryString,
						connection, objects);
				while (resultSet.next()) {
					// PM_IL_MASTER_POLICY pm_il_master_policy = new
					// PM_IL_MASTER_POLICY();
					System.out.println("Inside IF Loop");
					pm_il_master_policy.setROWID(resultSet.getString("ROWID"));
					pm_il_master_policy.setMP_CUST_CODE(resultSet
							.getString("MP_CUST_CODE"));
					pm_il_master_policy.setMP_PROD_CODE(resultSet
							.getString("MP_PROD_CODE"));
					pm_il_master_policy.setMP_POL_NO(resultSet
							.getString("MP_POL_NO"));
					pm_il_master_policy.setMP_ISSUE_DT(resultSet
							.getDate("MP_ISSUE_DT"));
					pm_il_master_policy.setMP_POL_FM_DT(resultSet
							.getDate("MP_POL_FM_DT"));
					pm_il_master_policy.setMP_LC_MAX_TPD_BNF(resultSet
							.getDouble("MP_LC_MAX_TPD_BNF"));
					pm_il_master_policy.setMP_PRE_TPD_BNF_MONTHS(resultSet
							.getInt("MP_PRE_TPD_BNF_MONTHS"));
					pm_il_master_policy.setMP_LC_FUNERAL_EXP_LMT(resultSet
							.getDouble("MP_LC_FUNERAL_EXP_LMT"));
					pm_il_master_policy.setMP_LC_FUNERAL_EXP_AMT(resultSet
							.getDouble("MP_LC_FUNERAL_EXP_AMT"));
					pm_il_master_policy.setMP_CLM_INTM_DAYS(resultSet
							.getInt("MP_CLM_INTM_DAYS"));
					pm_il_master_policy.setMP_NOTICE_PRD(resultSet
							.getInt("MP_NOTICE_PRD"));
					pm_il_master_policy.setMP_LC_FCL(resultSet
							.getDouble("MP_LC_FCL"));
					recordList.add(pm_il_master_policy);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pm_il_master_policy;
	}

	public String GetCustomerCode() {
		CommonUtils commonUtils = new CommonUtils();
		/*PM006_A_APAC_COMPOSITE_ACTION customerCompositeAction = null;
		String customerCode = null;
		customerCompositeAction = (PM006_A_APAC_COMPOSITE_ACTION) commonUtils
				.getMappedBeanFromSession("PM006_A_APAC_COMPOSITE_ACTION");
		customerCode = customerCompositeAction.getPM_CUSTOMER_ACTION_BEAN()
				.getPM_CUSTOMER_BEAN().getCUST_CODE();
		System.out.println("Master Customer Code :" + customerCode);*/
		return customerCode;
	}

	public String deleteButton() {
		PM_IL_MASTER_POLICY_SEARCH_PAGE_DELEGATE delegate = new PM_IL_MASTER_POLICY_SEARCH_PAGE_DELEGATE();
		PM_IL_MASTER_POLICY pm_il_master_policy = null;

		System.out.println("Delete Button Called :");
		if (recordList != null) {
			System.out.println("The Size of Contract Master is"
					+ recordList.size());
			for (int index = 0; index < recordList.size();) {
				pm_il_master_policy = (PM_IL_MASTER_POLICY) recordList
						.get(index);
				if (pm_il_master_policy.isCheckBox()) {
					recordList.remove(pm_il_master_policy);
					deletedIndex = delegate.deleteData(pm_il_master_policy);
					// deletedList.add(deletedIndex);
					// System.out.println("The deleted list is"
					// +deletedList.size());
					// System.out.println("The deleted list is"
					// +classMasterList.size());
					pm_il_master_policy.setCheckBox(false);
				} else {
					index++;
				}
			}

		}
		return "";
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE getPM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN() {
		return PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN;
	}

	public void setPM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN(
			PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE pm_il_master_policy_setup_search_page_bean) {
		PM_IL_MASTER_POLICY_SETUP_SEARCH_PAGE_BEAN = pm_il_master_policy_setup_search_page_bean;
	}

	public int getDeletedIndex() {
		return deletedIndex;
	}

	public void setDeletedIndex(int deletedIndex) {
		this.deletedIndex = deletedIndex;
	}
}
