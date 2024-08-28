package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class SearchHelperClass {

	public ArrayList fetchSearchDetails(SearchValueBean searchBean) {

		Connection connection = null;
		ResultSet resultSet = null;
		ArrayList<PM_IL_PROP_TREATY> beanList = new ArrayList<PM_IL_PROP_TREATY>();
		String selectQuery = "SELECT PT_TREATY_CODE,PT_TREATY_DESC,PT_UW_YEAR,PT_START_DT,PT_END_DT FROM PM_IL_PROP_TREATY";
		boolean flag = false;

		if (searchBean.getIntiTreatyCode() != null
				&& searchBean.getIntiTreatyCode().trim().length() > 0) {
			selectQuery = selectQuery + " WHERE UPPER(PT_TREATY_CODE) LIKE "
					+ "'" + searchBean.getIntiTreatyCode().toUpperCase() + "%'";
			flag = true;
		}
		if (searchBean.getInitUwYear() != null
				&& searchBean.getInitUwYear().trim().length() > 0) {
			if (!flag) {
				selectQuery = selectQuery + " WHERE UPPER(PT_UW_YEAR) LIKE "
						+ "'" + searchBean.getInitUwYear().toUpperCase() + "%'";
			} else {
				selectQuery = selectQuery + " AND UPPER(PT_UW_YEAR) LIKE "
						+ "'" + searchBean.getInitUwYear().toUpperCase() + "%'";
			}
		}

		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(selectQuery, connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY pm_il_prop_treaty = new PM_IL_PROP_TREATY();
				pm_il_prop_treaty.setPT_TREATY_CODE(resultSet.getString(1));
				pm_il_prop_treaty.setPT_TREATY_DESC(resultSet.getString(2));
				pm_il_prop_treaty.setPT_UW_YEAR(resultSet.getInt(3));
				pm_il_prop_treaty.setFmdate(CommonUtils.dateToPELStringFormatter(resultSet.getDate(4)));
				pm_il_prop_treaty.setTodate(CommonUtils.dateToPELStringFormatter(resultSet.getDate(5)));
				

				beanList.add(pm_il_prop_treaty);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return beanList;
	}

	public Object TreatyMasterDetails(PM_IL_PROP_TREATY pm_il_prop_treaty) {
		Connection connection = null;
		ResultSet resultSet = null;
		String query = "SELECT ROWID,PT_SYS_ID,PT_TREATY_CODE,PT_TREATY_DESC,PT_CLASS_CODE,PT_UW_YEAR,PT_UW_YEAR_DESC,PT_START_DT,PT_END_DT,PT_CURR_CODE,PT_CURR_RATE,PT_CQS_YN,PT_CQS_PERC,PT_CASH_CALL_FC_LIMIT,PT_CASH_CALL_LC_LIMIT,PT_SURR_CLAIM_YN,PT_REALLC_ENDT_YN,PT_RIDER_RI_BASIS FROM PM_IL_PROP_TREATY WHERE PT_TREATY_CODE =? ";
		try {
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { pm_il_prop_treaty.getPT_TREATY_CODE() });
			while (resultSet.next()) {
				pm_il_prop_treaty.setROWID(resultSet.getString("ROWID"));
				pm_il_prop_treaty
						.setPT_SYS_ID(resultSet.getDouble("PT_SYS_ID"));
				pm_il_prop_treaty.setPT_TREATY_DESC(resultSet
						.getString("PT_TREATY_DESC"));
				pm_il_prop_treaty.setPT_CLASS_CODE(resultSet
						.getString("PT_CLASS_CODE"));
				pm_il_prop_treaty.setPT_UW_YEAR(resultSet.getInt("PT_UW_YEAR"));
				pm_il_prop_treaty.setPT_UW_YEAR_DESC(resultSet
						.getString("PT_UW_YEAR_DESC"));
				pm_il_prop_treaty.setPT_START_DT(resultSet
						.getDate("PT_START_DT"));
				pm_il_prop_treaty.setPT_END_DT(resultSet.getDate("PT_END_DT"));
				pm_il_prop_treaty.setPT_CURR_CODE(resultSet
						.getString("PT_CURR_CODE"));
				pm_il_prop_treaty.setPT_CURR_RATE(resultSet
						.getDouble("PT_CURR_RATE"));
				pm_il_prop_treaty
						.setPT_CQS_YN(resultSet.getString("PT_CQS_YN"));
				pm_il_prop_treaty.setPT_CQS_PERC(resultSet
						.getDouble("PT_CQS_PERC"));
				pm_il_prop_treaty.setPT_CASH_CALL_FC_LIMIT(resultSet
						.getDouble("PT_CASH_CALL_FC_LIMIT"));
				pm_il_prop_treaty.setPT_CASH_CALL_LC_LIMIT(resultSet
						.getDouble("PT_CASH_CALL_LC_LIMIT"));
				pm_il_prop_treaty.setPT_SURR_CLAIM_YN(resultSet
						.getString("PT_SURR_CLAIM_YN"));
				pm_il_prop_treaty.setPT_REALLC_ENDT_YN(resultSet
						.getString("PT_REALLC_ENDT_YN"));
				pm_il_prop_treaty.setPT_RIDER_RI_BASIS(resultSet
						.getString("PT_RIDER_RI_BASIS"));
				/*
				 * pm_il_prop_treaty.setPT_CORIDOR_LC_LIMIT(resultSet
				 * .getDouble("PT_CORIDOR_LC_LIMIT"));
				 */
				POST_QUERY(pm_il_prop_treaty);

			}
			// pm020_a_tisb_pm_cust_class_post_query(pm_il_prop_treaty);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return pm_il_prop_treaty;
	}

	
	
	public void POST_QUERY(PM_IL_PROP_TREATY pm_il_prop_treaty)
	{
		DBProcedures procedures = new DBProcedures();
		try {
			ArrayList<String> classCodeDescriptionList = procedures.P_VAL_CLASS(pm_il_prop_treaty.getPT_CLASS_CODE(), "N", "N");
			pm_il_prop_treaty.setUI_M_CLASS_CODE_DESC(classCodeDescriptionList.get(0));
			
			ArrayList<String> currencyCodeList = procedures.P_VAL_CURR(pm_il_prop_treaty.getPT_CURR_CODE(), "N", "N",null);
			pm_il_prop_treaty.setUI_M_CURR_DESC(currencyCodeList.get(0));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
