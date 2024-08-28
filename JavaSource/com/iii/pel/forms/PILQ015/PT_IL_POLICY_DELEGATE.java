package com.iii.pel.forms.PILQ015;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_DELEGATE {

	public List<SelectItem> comboBoxValues(String formName, String blockname,
			String component, String componentId) {
		Connection connection = null;
		List<SelectItem> listItem = new java.util.ArrayList<SelectItem>();
		try {
			connection = CommonUtils.getConnection();
			listItem = (List<SelectItem>) ListItemUtil.getDropDownListValue(
					connection, formName, blockname, component, componentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listItem;
	}

	public List fetchNewCodeList(String code, List CodeList) {
		String query;

		if ("*".equalsIgnoreCase(code)) {

			query = "SELECT CUST_REF_ID1" + " FROM   PM_CUSTOMER"
					+ " WHERE  CUST_REF_ID1 IS NOT NULL"
					+ " AND    CUST_FRZ_FLAG = 'N'" + " AND ROWNUM<20";

			CodeList = newICcodeLOV(query);
		} else {

			query = "SELECT CUST_REF_ID1" + " FROM   PM_CUSTOMER"
					+ " WHERE  CUST_REF_ID1 IS NOT NULL"
					+ " AND    CUST_FRZ_FLAG = 'N'"
					+ " AND UPPER(CUST_REF_ID1) LIKE '" + code.toUpperCase()
					+ "%'" + " AND ROWNUM<20";

			CodeList = newICcodeLOV(query);

		}

		return CodeList;
	}

	public List<PT_IL_POLICY> newICcodeLOV(String query) {
		List<PT_IL_POLICY> codeList = new ArrayList<PT_IL_POLICY>();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_POLICY pt_il_policy = new PT_IL_POLICY();
				pt_il_policy.setCUST_REF_ID1(resultSet.getString(1));

				codeList.add(pt_il_policy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

	public List fetchOldCodeList(String code, List CodeList) {
		String query;

		if ("*".equalsIgnoreCase(code)) {

			query = "SELECT CUST_REF_ID2" + " FROM   PM_CUSTOMER"
					+ " WHERE  CUST_REF_ID2 IS NOT NULL"
					+ " AND    CUST_FRZ_FLAG = 'N'" + " AND ROWNUM<20";

			CodeList = oldICcodeLOV(query);
		} else {

			query = "SELECT CUST_REF_ID2" + " FROM   PM_CUSTOMER"
					+ " WHERE  CUST_REF_ID2 IS NOT NULL"
					+ " AND    CUST_FRZ_FLAG = 'N'"
					+ " AND UPPER(CUST_REF_ID2) LIKE '" + code.toUpperCase()
					+ "%'" + " AND ROWNUM<20";

			CodeList = oldICcodeLOV(query);

		}

		return CodeList;
	}

	public List<PT_IL_POLICY> oldICcodeLOV(String query) {
		List<PT_IL_POLICY> codeList = new ArrayList<PT_IL_POLICY>();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_POLICY pt_il_policy = new PT_IL_POLICY();
				pt_il_policy.setCUST_REF_ID2(resultSet.getString(1));

				codeList.add(pt_il_policy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

	public List fetchPolicyList(String code, List CodeList) {
		String query;
		try {
			if ("*".equalsIgnoreCase(code)) {

				query = "SELECT POL_NO FROM PT_IL_POLICY "
						+ " WHERE  NVL(POL_APPRV_STATUS,'N') = 'A' "
						+ " AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' "
						+ " AND ROWNUM<20 ";

				CodeList = policycodeLOV(query);
			} else {

				query = "SELECT POL_NO " + "FROM   PT_IL_POLICY "
						+ "WHERE  NVL(POL_APPRV_STATUS,'N') = 'A' "
						+ "AND POL_NO IS NOT NULL " + "AND POL_DS_TYPE = '2'"
						+ " AND UPPER(POL_NO) LIKE '" + code.toUpperCase()
						+ "%'" + " AND ROWNUM<20 ";

				CodeList = policycodeLOV(query);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return CodeList;
	}

	public List<PT_IL_POLICY> policycodeLOV(String query) {
		List<PT_IL_POLICY> codeList = new ArrayList<PT_IL_POLICY>();
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_POLICY pt_il_policy = new PT_IL_POLICY();
				pt_il_policy.setPOL_NO(resultSet.getString(1));

				codeList.add(pt_il_policy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

	public List fetchProposalList(String code, List CodeList) {
		String query;

		if ("*".equalsIgnoreCase(code)) {

			query = "SELECT POL_NO " + " FROM PT_IL_POLICY "
					+ " WHERE  NVL(POL_APPRV_STATUS,'N') = 'A' "
					+ " AND POL_NO IS NOT NULL " + " AND POL_DS_TYPE = '1'"
					+ " AND ROWNUM<20 ";

			CodeList = proposalcodeLOV(query);
		} else {

			query = "SELECT POL_NO " + "FROM PT_IL_POLICY "
					+ "WHERE  NVL(POL_APPRV_STATUS,'N') = 'A' "
					+ "AND POL_NO IS NOT NULL " + "AND POL_DS_TYPE = '1' "
					+ " AND UPPER(POL_NO) LIKE '" + code.toUpperCase() + "%'"
					+ " AND ROWNUM<20 ";

			CodeList = proposalcodeLOV(query);

		}

		return CodeList;
	}

	public List<PT_IL_POLICY> proposalcodeLOV(String query) {
		List<PT_IL_POLICY> codeList = new ArrayList<PT_IL_POLICY>();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_POLICY pt_il_policy = new PT_IL_POLICY();
				pt_il_policy.setPOL_PROP_NO(resultSet.getString(1));

				codeList.add(pt_il_policy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

	public List fetchCustCodeList(String code, List CodeList) {
		String query;

		if (null != code) {

			if ("*".equalsIgnoreCase(code)) {

				query = "SELECT CUST_CODE,CUST_NAME " + " FROM  PM_CUSTOMER "
						+ " WHERE  CUST_CLASS IN "
						+ "(SELECT CCLAS_CODE FROM PM_CUST_CLASS)"
						+ " AND CUST_FRZ_FLAG = 'N' "
						+ " AND CUST_TYPE = 'C'  AND ROWNUM<25 ";

				CodeList = custCodeLOV(query);
			} else {

				query = " SELECT CUST_CODE, CUST_NAME" + " FROM PM_CUSTOMER "
						+ " WHERE  CUST_CLASS IN "
						+ " (SELECT CCLAS_CODE FROM PM_CUST_CLASS)"
						+ " AND CUST_FRZ_FLAG = 'N'" + " AND CUST_TYPE = 'C'"
						+ " AND UPPER(CUST_CODE) LIKE '" + code.toUpperCase()
						+ "%'   AND ROWNUM<25";

				CodeList = custCodeLOV(query);

			}
		}
		return CodeList;
	}

	public List<PT_IL_POLICY> custCodeLOV(String query) {
		List<PT_IL_POLICY> codeList = new ArrayList<PT_IL_POLICY>();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_POLICY pt_il_policy = new PT_IL_POLICY();
				pt_il_policy.setPOL_CUST_CODE(resultSet.getString(1));
				pt_il_policy.setCUST_NAME(resultSet.getString(2));

				codeList.add(pt_il_policy);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

	public String getCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PT_IL_POLICY pt_il_policy = (PT_IL_POLICY) iterator.next();
			if (Code.equalsIgnoreCase(pt_il_policy.getPOL_CUST_CODE())) {
				codedesc = pt_il_policy.getCUST_NAME();
			}
		}
		return codedesc;
	}

	public List fetchDetails() {

		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		PS_IL_DRCR PS_IL_DRCR_BEAN = null;

		PT_IL_POLICY_COMPOSITE compAction = (PT_IL_POLICY_COMPOSITE) new CommonUtils()
				.getMappedBeanFromSession("PT_IL_POLICY_COMPOSITE");

		String polNo = compAction.getPT_IL_POLICY_ACTION()
				.getPT_IL_POLICY_BEAN().getPOL_NO();
		System.out.println("Policy no is :" + polNo);
		double polSysId = 0D;
		/*
		 * String polQuery=" SELECT POL_SYS_ID"+ " FROM PT_IL_POLICY"+ " WHERE
		 * POL_NO ='"+polNo+"'";
		 */

		List detailsList = new ArrayList();
		try {
			connection = CommonUtils.getConnection();
			/*
			 * resultSet1 = handler.executeSelectStatement(polQuery,
			 * connection); while(resultSet1.next()){
			 * polSysId=resultSet1.getDouble(1); System.out.println("policy sys
			 * id is :"+polSysId); }
			 */
			String query = " SELECT PS_IL_DRCR.ROWID,PS_IL_DRCR.* FROM PS_IL_DRCR, PT_IL_POLICY "
					+ "WHERE PS_IL_DRCR.DRCR_POL_SYS_ID = PT_IL_POLICY.POL_SYS_ID AND PS_IL_DRCR.DRCR_POL_NO=?";
			resultSet2 = handler.executeSelectStatement(query, connection,
					new Object[] { polNo });
			while (resultSet2.next()) {

				PS_IL_DRCR ps_il_drcr = new PS_IL_DRCR();

				ps_il_drcr.setROWID(resultSet2.getString("ROWID"));
				ps_il_drcr.setDRCR_ACTY_CODE_1(resultSet2
						.getString("DRCR_ACTY_CODE_1"));
				ps_il_drcr.setDRCR_ACTY_CODE_2(resultSet2
						.getString("DRCR_ACTY_CODE_2"));
				ps_il_drcr.setDRCR_ANLY_CODE_1(resultSet2
						.getString("DRCR_ANLY_CODE_1"));
				ps_il_drcr.setDRCR_ANLY_CODE_2(resultSet2
						.getString("DRCR_ANLY_CODE_2"));
				ps_il_drcr.setDRCR_CLAIM_NO(resultSet2
						.getString("DRCR_CLAIM_NO"));
				ps_il_drcr.setDRCR_CUST_CODE(resultSet2
						.getString("DRCR_CUST_CODE"));
				ps_il_drcr.setDRCR_DEPT_CODE(resultSet2
						.getString("DRCR_DEPT_CODE"));
				ps_il_drcr.setDRCR_DIVN_CODE(resultSet2
						.getString("DRCR_DIVN_CODE"));
				ps_il_drcr.setDRCR_DOC_DT(resultSet2.getDate("DRCR_DOC_DT"));
				ps_il_drcr.setDRCR_DOC_NO(resultSet2.getInt("DRCR_DOC_NO"));
				ps_il_drcr.setDRCR_END_NO(resultSet2.getString("DRCR_END_NO"));
				ps_il_drcr.setDRCR_LC_AMT(resultSet2.getDouble("DRCR_LC_AMT"));
				ps_il_drcr.setDRCR_NARRATION(resultSet2
						.getString("DRCR_NARRATION"));
				ps_il_drcr.setDRCR_POL_NO(resultSet2.getString("DRCR_POL_NO"));
				ps_il_drcr
						.setDRCR_POST_YN(resultSet2.getString("DRCR_POST_YN"));
				ps_il_drcr.setDRCR_SEQ_NO(resultSet2.getInt("DRCR_SEQ_NO"));
				ps_il_drcr.setDRCR_SUB_ACNT_CODE(resultSet2
						.getString("DRCR_SUB_ACNT_CODE"));
				ps_il_drcr.setDRCR_TXN_CODE(resultSet2
						.getString("DRCR_TXN_CODE"));
				ps_il_drcr
						.setDRCR_POST_YN(resultSet2.getString("DRCR_POST_YN"));
				ps_il_drcr.setDRCR_MAIN_ACNT_CODE(resultSet2
						.getString("DRCR_MAIN_ACNT_CODE"));
				ps_il_drcr.setDRCR_SUB_ACNT_CODE(resultSet2
						.getString("DRCR_SUB_ACNT_CODE"));
				ps_il_drcr.setDRCR_DRCR_FLAG(resultSet2
						.getString("DRCR_DRCR_FLAG"));
				/*
				 * ps_il_drcr.setUI_M_DRCR_LC_TOT_CR(resultSet2.getDouble("UI_M_DRCR_LC_TOT_CR"));
				 * ps_il_drcr.setUI_M_DRCR_LC_TOT_DR(resultSet2.getDouble("UI_M_DRCR_LC_TOT_DR"));
				 */
				detailsList.add(ps_il_drcr);
				System.out.println("lIST SIZE OF DETAIL TABLE IS :"
						+ detailsList.size());
			}
			if (detailsList != null) {

				Iterator<PS_IL_DRCR> list = detailsList.iterator();
				while (list.hasNext()) {
					PS_IL_DRCR_BEAN = list.next();
					PS_IL_DRCR_BEAN.setRowSelected(false);
				}

				if (detailsList.size() > 0) {
					PS_IL_DRCR_BEAN = (PS_IL_DRCR) detailsList.get(0);
					compAction.getPS_IL_DRCR_ACTION().setPS_IL_DRCR_BEAN(
							PS_IL_DRCR_BEAN);
					PS_IL_DRCR_BEAN.setDRCR_CUST_CODE(PS_IL_DRCR_BEAN
							.getDRCR_CUST_CODE());
					compAction.getPS_IL_DRCR_ACTION().getPS_IL_DRCR_BEAN()
							.setRowSelected(true);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return detailsList;
	}

	public void validateItem(String query, Object[] object) throws Exception {
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					object);
			if (resultSet.next()) {
			} else {
				throw new Exception("Invalid Code Please re-enter");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Inside Validate Item=======>");
	}

}
