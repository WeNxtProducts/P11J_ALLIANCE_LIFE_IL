package com.iii.pel.forms.PILM041;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILQ003;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ConnectionAgent;

public class PM_IL_DATA_UPLOAD_SEARCH_PAGE_DELEGATE {

	public List listAllRecords() {
		List recordList = new ArrayList<PM_IL_DATA_UPLOAD_MAPPING>();
		ConnectionAgent agent = new ConnectionAgent();
		CRUDHandler handler = new CRUDHandler();
		CommonUtils util = new CommonUtils();
		// String queryString="Select ROWID,PM_IL_DATA_UPLOAD_MAPPING.* from
		// PM_IL_DATA_UPLOAD_MAPPING";
		StringBuffer queryString = new StringBuffer(
				PILM041_SQLQUERY_CONSTANTS.SELECT_ALL_PM_IL_DATA_UPLOAD_MAPPING);
		ResultSet result = null;
		String mappedBeanName = "PILM041_PM_IL_DATA_UPLOAD_SEARCH_PAGE_ACTION";
		boolean firstConditionAdded = false;
		PM_IL_DATA_UPLOAD_SEARCH_PAGE_ACTION actionbean = (PM_IL_DATA_UPLOAD_SEARCH_PAGE_ACTION) util
				.getMappedBeanFromSession(mappedBeanName);
		// getting the initial search criteria

		String searchCondition1 = actionbean
				.getPM_IL_DATA_UPLOAD_SEARCH_PAGE_BEAN().getSEARCH_BY_VALUE1();
		if (!(searchCondition1 == null)
				&& !(searchCondition1.trim().length() == 0)) {
			// add criteria 1
			queryString = queryString.append(" WHERE UPPER(DUM_MAP_CODE)LIKE"
					+ " '" + searchCondition1.toUpperCase() + "%'");
			firstConditionAdded = true;
		}

		try {
			result = handler.executeSelectStatement(queryString.toString(),
					agent.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (result != null) {
				while (result.next()) {
					PM_IL_DATA_UPLOAD_MAPPING bean = new PM_IL_DATA_UPLOAD_MAPPING();
					bean.setDUM_DEF_CODE(result.getString("DUM_DEF_CODE"));
					/*
					 * bean.setDUM_FIELD_01(result.getDouble("DUM_FIELD_01"));
					 * bean.setDUM_FIELD_02(result.getDouble("DUM_FIELD_02"));
					 * bean.setDUM_FIELD_03(result.getDouble("DUM_FIELD_03"));
					 * bean.setDUM_FIELD_04(result.getDouble("DUM_FIELD_04"));
					 * bean.setDUM_FIELD_05(result.getDouble("DUM_FIELD_05"));
					 * bean.setDUM_FIELD_06(result.getDouble("DUM_FIELD_06"));
					 * bean.setDUM_FIELD_07(result.getDouble("DUM_FIELD_07"));
					 * bean.setDUM_FIELD_08(result.getDouble("DUM_FIELD_08"));
					 * bean.setDUM_FIELD_09(result.getDouble("DUM_FIELD_09"));
					 * bean.setDUM_FIELD_10(result.getDouble("DUM_FIELD_10"));
					 * bean.setDUM_FIELD_11(result.getDouble("DUM_FIELD_11"));
					 * bean.setDUM_FIELD_12(result.getDouble("DUM_FIELD_12"));
					 * bean.setDUM_FIELD_13(result.getDouble("DUM_FIELD_13"));
					 * bean.setDUM_FIELD_14(result.getDouble("DUM_FIELD_14"));
					 * bean.setDUM_FIELD_15(result.getDouble("DUM_FIELD_15"));
					 * bean.setDUM_FIELD_16(result.getDouble("DUM_FIELD_16"));
					 * bean.setDUM_FIELD_17(result.getDouble("DUM_FIELD_17"));
					 * bean.setDUM_FIELD_18(result.getDouble("DUM_FIELD_18"));
					 * bean.setDUM_FIELD_19(result.getDouble("DUM_FIELD_19"));
					 * bean.setDUM_FIELD_20(result.getDouble("DUM_FIELD_20"));
					 */
					bean.setDUM_MAP_CODE(result.getString("DUM_MAP_CODE"));
					bean.setDUM_MAP_CODE_DESC(result
							.getString("DUM_MAP_CODE_DESC"));
					bean.setROWID(result.getString("ROWID"));
					recordList.add(bean);
				}
				System.out.println("Bean Size \t" + recordList.size());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return recordList;
	}

	public void executeQuery(
			PM_IL_DATA_UPLOAD_MAPPING_ACTION PM_IL_DATA_UPLOAD_MAPPING_ACTION_BEAN) throws Exception {
		CRUDHandler handler = null;
		Connection connection = null;
		String queryString = "SELECT ROWID,PM_IL_DATA_UPLOAD_MAPPING.* FROM PM_IL_DATA_UPLOAD_MAPPING WHERE ROWID = ? ";
		ResultSet result = null;

		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			result = handler.executeSelectStatement(queryString.toString(),
					connection,
					new Object[] { PM_IL_DATA_UPLOAD_MAPPING_ACTION_BEAN
							.getPM_IL_DATA_UPLOAD_MAPPING_BEAN().getROWID() });

			if (result != null) {
				while (result.next()) {
					PM_IL_DATA_UPLOAD_MAPPING bean = new PM_IL_DATA_UPLOAD_MAPPING();
					bean.setDUM_DEF_CODE(result.getString("DUM_DEF_CODE"));
					bean
							.setDUM_FIELD_01(result.getInt("DUM_FIELD_01") == 0 ? null
									: result.getInt("DUM_FIELD_01"));
					bean
							.setDUM_FIELD_02(result.getInt("DUM_FIELD_02") == 0 ? null
									: result.getInt("DUM_FIELD_02"));
					bean
							.setDUM_FIELD_03(result.getInt("DUM_FIELD_03") == 0 ? null
									: result.getInt("DUM_FIELD_03"));
					bean
							.setDUM_FIELD_04(result.getInt("DUM_FIELD_04") == 0 ? null
									: result.getInt("DUM_FIELD_04"));
					bean
							.setDUM_FIELD_05(result.getInt("DUM_FIELD_05") == 0 ? null
									: result.getInt("DUM_FIELD_05"));
					bean
							.setDUM_FIELD_06(result.getInt("DUM_FIELD_06") == 0 ? null
									: result.getInt("DUM_FIELD_06"));
					bean
							.setDUM_FIELD_07(result.getInt("DUM_FIELD_07") == 0 ? null
									: result.getInt("DUM_FIELD_07"));
					bean
							.setDUM_FIELD_08(result.getInt("DUM_FIELD_08") == 0 ? null
									: result.getInt("DUM_FIELD_08"));
					bean
							.setDUM_FIELD_09(result.getInt("DUM_FIELD_09") == 0 ? null
									: result.getInt("DUM_FIELD_09"));
					bean
							.setDUM_FIELD_10(result.getInt("DUM_FIELD_10") == 0 ? null
									: result.getInt("DUM_FIELD_10"));
					bean
							.setDUM_FIELD_11(result.getInt("DUM_FIELD_11") == 0 ? null
									: result.getInt("DUM_FIELD_11"));
					bean
							.setDUM_FIELD_12(result.getInt("DUM_FIELD_12") == 0 ? null
									: result.getInt("DUM_FIELD_12"));
					bean
							.setDUM_FIELD_13(result.getInt("DUM_FIELD_13") == 0 ? null
									: result.getInt("DUM_FIELD_13"));
					bean
							.setDUM_FIELD_14(result.getInt("DUM_FIELD_14") == 0 ? null
									: result.getInt("DUM_FIELD_14"));
					bean
							.setDUM_FIELD_15(result.getInt("DUM_FIELD_15") == 0 ? null
									: result.getInt("DUM_FIELD_15"));
					bean
							.setDUM_FIELD_16(result.getInt("DUM_FIELD_16") == 0 ? null
									: result.getInt("DUM_FIELD_16"));
					bean
							.setDUM_FIELD_17(result.getInt("DUM_FIELD_17") == 0 ? null
									: result.getInt("DUM_FIELD_17"));
					bean
							.setDUM_FIELD_18(result.getInt("DUM_FIELD_18") == 0 ? null
									: result.getInt("DUM_FIELD_18"));
					bean
							.setDUM_FIELD_19(result.getInt("DUM_FIELD_19") == 0 ? null
									: result.getInt("DUM_FIELD_19"));
					bean
							.setDUM_FIELD_20(result.getInt("DUM_FIELD_20") == 0 ? null
									: result.getInt("DUM_FIELD_20"));
					bean.setDUM_MAP_CODE(result.getString("DUM_MAP_CODE"));
					bean.setDUM_MAP_CODE_DESC(result
							.getString("DUM_MAP_CODE_DESC"));
					bean.setROWID(result.getString("ROWID"));
					bean.setDUM_CR_DT(result.getDate("DUM_CR_DT"));
					bean.setDUM_CR_UID(result.getString("DUM_CR_UID"));
					// recordList.add(bean);
					setFieldDesc(bean);
					
					/*	added by raja on 06-03-2017 for ZBILQC-1719694 */
					
					bean.setDUM_EMPLOYER_CODE(result.getString("DUM_EMPLOYER_CODE"));
				
					
					PKG_PILQ003 pkg_pilt002_apac = new PKG_PILQ003();
					ArrayList<String> pValList = new ArrayList<String>();
					
					if (bean.getDUM_EMPLOYER_CODE() != null) {
						pValList = pkg_pilt002_apac.P_VAL_CONT_CODE(bean
								.getDUM_EMPLOYER_CODE(), bean
								.getDUM_EMPLOYER_CODE_DESC(), "E");
						bean.setDUM_EMPLOYER_CODE_DESC(pValList.get(0));
					}
					
					bean.setDUM_PAYMENT_MODE(result.getString("DUM_PAYMENT_MODE"));
					
					/*end*/
					
					
					/*added by sankara narayanan on 03/04/2017*/
					bean.setDUM_UPLOAD_TYPE(result.getString("DUM_UPLOAD_TYPE"));
					/*end*/

					bean.setDUM_DUE_DT(result.getDate("DUM_DUE_DT"));
					bean.setDUM_EFF_FM_DT(result.getDate("DUM_EFF_FM_DT"));
					bean.setDUM_EFF_TO_DT(result.getDate("DUM_EFF_TO_DT"));
					
					/*added by raja on 27-06-2017 for ZBILQC-1729595*/
					bean.setDUM_EMPLOYER_TYPE(result.getString("DUM_EMPLOYER_TYPE"));
					/*end*/
					PM_IL_DATA_UPLOAD_MAPPING_ACTION_BEAN
							.setPM_IL_DATA_UPLOAD_MAPPING_BEAN(bean);
				}
				// System.out.println("Bean Size \t" + recordList.size());
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException exception) {
			exception.printStackTrace();
		}
		// return recordList;
	}

	/**
	 * @param bean
	 */
	private void setFieldDesc(PM_IL_DATA_UPLOAD_MAPPING bean) {
		if (bean.getDUM_FIELD_01() != null) {
			bean.setUI_M_DUM_FIELD_01_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_01()));
		}
		if (bean.getDUM_FIELD_02() != null) {
			bean.setUI_M_DUM_FIELD_02_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_02()));
		}
		if (bean.getDUM_FIELD_03() != null) {
			bean.setUI_M_DUM_FIELD_03_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_03()));
		}

		if (bean.getDUM_FIELD_04() != null) {
			bean.setUI_M_DUM_FIELD_04_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_04()));
		}

		if (bean.getDUM_FIELD_05() != null) {
			bean.setUI_M_DUM_FIELD_05_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_05()));
		}

		if (bean.getDUM_FIELD_06() != null) {
			bean.setUI_M_DUM_FIELD_06_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_06()));
		}
		if (bean.getDUM_FIELD_07() != null) {
			bean.setUI_M_DUM_FIELD_07_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_07()));
		}
		if (bean.getDUM_FIELD_08() != null) {
			bean.setUI_M_DUM_FIELD_08_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_08()));
		}
		if (bean.getDUM_FIELD_09() != null) {
			bean.setUI_M_DUM_FIELD_09_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_09()));
		}

		if (bean.getDUM_FIELD_10() != null) {
			bean.setUI_M_DUM_FIELD_10_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_10()));
		}

		if (bean.getDUM_FIELD_11() != null) {
			bean.setUI_M_DUM_FIELD_11_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_11()));
		}

		if (bean.getDUM_FIELD_12() != null) {
			bean.setUI_M_DUM_FIELD_12_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_12()));
		}

		if (bean.getDUM_FIELD_13() != null) {
			bean.setUI_M_DUM_FIELD_13_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_13()));
		}

		if (bean.getDUM_FIELD_14() != null) {
			bean.setUI_M_DUM_FIELD_14_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_14()));
		}

		if (bean.getDUM_FIELD_15() != null) {
			bean.setUI_M_DUM_FIELD_15_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_15()));
		}

		if (bean.getDUM_FIELD_16() != null) {
			bean.setUI_M_DUM_FIELD_16_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_16()));
		}
		if (bean.getDUM_FIELD_17() != null) {
			bean.setUI_M_DUM_FIELD_17_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_17()));
		}
		if (bean.getDUM_FIELD_18() != null) {
			bean.setUI_M_DUM_FIELD_18_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_18()));
		}
		if (bean.getDUM_FIELD_19() != null) {
			bean.setUI_M_DUM_FIELD_19_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_19()));
		}
		if (bean.getDUM_FIELD_20() != null) {
			bean.setUI_M_DUM_FIELD_20_DESC(getFieldDesc(bean.getDUM_DEF_CODE(),
					bean.getDUM_FIELD_20()));
		}

		bean.setUI_M_DEF_CODE_DESC(getDefinitionIdDesc(bean.getDUM_DEF_CODE()));
	}

	private String getFieldDesc(String DUDD_DUDH_DEF_CODE, int DUDD_SERIAL_NO) {
		CRUDHandler handler = null;
		Connection connection = null;
		String desc = null;
		String queryString = "SELECT DUDD_PARA_NAME FROM PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUDD_PARA_TYPE ='P' "
				+ "AND DUDD_DUDH_DEF_CODE = ? AND DUDD_SERIAL_NO = ? ";
		ResultSet result = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			result = handler.executeSelectStatement(queryString.toString(),
					connection, new Object[] { DUDD_DUDH_DEF_CODE,
							DUDD_SERIAL_NO });
			if (result != null) {
				while (result.next()) {
					desc = result.getString(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException exception) {
			exception.printStackTrace();
		}
		return desc;
	}

	/**
	 * 
	 * @param DUDD_DUDH_DEF_CODE
	 * @param DUDD_SERIAL_NO
	 * @return
	 */
	private String getDefinitionIdDesc(String DUDH_DEF_CODE) {
		CRUDHandler handler = null;
		Connection connection = null;
		String desc = null;
		String queryString = "SELECT DUDH_DESC FROM PM_IL_DATA_UPLOAD_DEFN_HDR WHERE DUDH_DEF_CODE= ?";
		ResultSet result = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			result = handler.executeSelectStatement(queryString.toString(),
					connection, new Object[] { DUDH_DEF_CODE });
			if (result != null) {
				while (result.next()) {
					desc = result.getString(1);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBException exception) {
			exception.printStackTrace();
		}
		return desc;
	}

}
