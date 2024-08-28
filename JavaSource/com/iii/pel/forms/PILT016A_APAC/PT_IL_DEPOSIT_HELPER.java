package com.iii.pel.forms.PILT016A_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS;
import com.iii.pel.util.P9ILPK_RECEIPT_TRANSFER;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_BULK_RECEIPT;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.P9ILPK_POL_APPROVAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ReportUtils;
import com.iii.premia.runtime.functions.NumericFunctions;


public class PT_IL_DEPOSIT_HELPER {

	public void preUpdate(PT_IL_DEPOSIT depositBean) throws Exception {
		CRUDHandler handler = new CRUDHandler();
		String CURSOR_DS = "SELECT NVL(PROD_DS_CODE,''),PROD_DESC,PROD_PLAN_CODE  FROM   PM_IL_PRODUCT  WHERE  PROD_CODE= ? ";
		try {
			depositBean.setDEP_UPD_DT(new CommonUtils().getCurrentDate());
			depositBean.setDEP_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			ResultSet resultSet = handler.executeSelectStatement(CURSOR_DS,
						CommonUtils.getConnection(), new Object[] { depositBean
								.getDEP_PROD_CODE() });
				if (resultSet.next()) {
					if(depositBean.getDEP_DS_CODE()==null && depositBean.getDEP_DS_CODE().isEmpty())
						depositBean.setDEP_DS_CODE(resultSet.getString(1));
					depositBean.setUI_M_DEP_PROD_CODE_DESC(resultSet
							.getString(2));
					depositBean.setDEP_PLAN_CODE(resultSet.getString(3));
				}
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PT_IL_DEPOSIT depositBean) throws Exception {
		String qC2 = "SELECT PIL_DEP_SYS_ID.NEXTVAL FROM DUAL";
		depositBean.setDEP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		CRUDHandler handler = new CRUDHandler();
		Long dep_sys = null;
		ResultSet rs = null;
		try {
			Connection con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(qC2, con);
			if (rs.next()) {
				dep_sys = rs.getLong(1);
			}
			String CURSOR_DS = "SELECT NVL(PROD_DS_CODE,''),PROD_DESC,PROD_PLAN_CODE  FROM   PM_IL_PRODUCT  WHERE  PROD_CODE= ? ";
			ResultSet resultSet = handler.executeSelectStatement(CURSOR_DS,
						CommonUtils.getConnection(), new Object[] { depositBean
								.getDEP_PROD_CODE() });
				if (resultSet.next()) {
					if(depositBean.getDEP_DS_CODE()==null && depositBean.getDEP_DS_CODE().isEmpty())
						depositBean.setDEP_DS_CODE(resultSet.getString(1));
					depositBean.setUI_M_DEP_PROD_CODE_DESC(resultSet
							.getString(2));
					depositBean.setDEP_PLAN_CODE(resultSet.getString(3));
				}
			depositBean.setDEP_CR_DT(new CommonUtils().getCurrentDate());
			depositBean.setDEP_SYS_ID_INTEGER(dep_sys);
			depositBean.setDEP_SYS_ID(dep_sys);
			
			/*addded by raja on 03-07-2017*/
			String cust_code=null;
			String query="select pol_cust_code from pt_il_policy where pol_no=?";
			ResultSet rsquery=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{depositBean.getDEP_REF_NO()});
			while(rsquery.next())
			{
				cust_code=rsquery.getString("pol_cust_code");
			}
			if(cust_code!=null && cust_code.equalsIgnoreCase(depositBean.getDEP_REF_NO()))
			{
				/*Modified by Janani on 05.02.2018 for ZBLIFE-1456608 */
				//depositBean.setDEP_TYPE("S");
				depositBean.setDEP_TYPE("P");
				/*End of ZBLIFE-1456608*/
			}
			/*end*/
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void whenNewBlockInstance(PT_IL_DEPOSIT depositBean)
			throws Exception {
		String F_PARA = "SELECT PARA_VALUE FROM   FP_PARAMETER  WHERE  PARA_ID = 'BASE.CURR'";
		CRUDHandler handler = new CRUDHandler();
		Long dep_sys = null;
		ResultSet rs = null;
		String P_BASE_CURR_CODE = null;
		try {
			Connection con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(F_PARA, con);
			if (rs.next()) {
				P_BASE_CURR_CODE = rs.getString(1);
				CommonUtils.setGlobalVariable("GLOBAL.CURR_CODE",
						P_BASE_CURR_CODE);
				CommonUtils
						.setGlobalObject("GLOBAL.EXCH_RATE", new Double(1.0));
			}

			depositBean.setDEP_CR_DT(new CommonUtils().getCurrentDate());
			depositBean.setDEP_SYS_ID_INTEGER(dep_sys);
			depositBean.setDEP_SYS_ID(dep_sys);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void preQuery() {
		// null;
	}

	public void postQuery(PILT016A_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		String C1 = "SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME "
				+ "FROM   PM_CUSTOMER "
				+ "WHERE  CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE IN ('006')) "
				+ "AND    CUST_CODE = ?  "
				+ "AND   (SYSDATE BETWEEN  NVL(CUST_EFF_FM_DT,'01-JAN-1900') AND NVL(CUST_EFF_TO_DT ,'31-DEC-2999')) "
				+ "AND    CUST_FRZ_FLAG = 'N'  "
				+ "AND    CUST_CODE IN (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = ?)";

		String C2 = " SELECT CONT_NAME FROM   PM_IL_CONTRACTOR "
				+ "WHERE  CONT_CODE = ?";

		String C3 = "SELECT 'X' FROM   PT_IL_POLICY "
				+ "WHERE  POL_DS_TYPE = '1' AND    POL_NO = ?";

		String C4 = " SELECT POL_LC_NET_PREM,POL_SYS_ID "
				+ "FROM   PT_IL_POLICY " + "WHERE  POL_DS_TYPE = '1' "
				+ "AND    POL_NO = ? "
				+ "AND    POL_END_NO_IDX = (SELECT MAX(POL_END_NO_IDX) "
				+ " FROM   PT_IL_POLICY " + " WHERE  POL_NO = ?)";

		String C5 = "SELECT 'X' " + "FROM   PT_IL_POLICY "
				+ "WHERE  POL_DS_TYPE = '2' " + "AND    POL_NO = ?";

		String C6 = "SELECT POL_LC_NET_PREM,POL_SYS_ID "
				+ "FROM   PT_IL_POLICY " + "WHERE  POL_DS_TYPE = '2' "
				+ "AND    POL_NO = ?";

		String C7 = "SELECT COUNT(*) FROM   PT_IL_DEPOSIT "
				+ " WHERE  (DEP_REF_NO = ? "
				+ " OR DEP_REF_NO IN (SELECT POL_PROP_NO "
				+ " FROM PT_IL_POLICY  WHERE POL_NO = ? )) "
				+ " AND    DEP_DOC_NO IS NOT NULL";

		String C8 = "SELECT PROD_DESC FROM   PM_IL_PRODUCT "
				+ "WHERE  PROD_CODE=?";

		String C9 = "SELECT DS_DESC FROM   PM_IL_DOC_SETUP "
				+ "WHERE  DS_CODE=?";

		String C10 = "SELECT CUST_NAME  FROM   PM_CUSTOMER "
				+ "WHERE  CUST_CODE = ?";

		String C11 = "SELECT PLAN_TYPE FROM   PM_IL_PLAN "
				+ "WHERE  PLAN_CODE= ?";
		String C12 = "SELECT POL_MODE_OF_PYMT FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO = ?";

		String C13 = "SELECT DPD_PAY_MODE,DPD_CHQ_NO,DPD_CHQ_DT "
				+ "FROM   PT_IL_DEPOSIT_PYMT_DTLS "
				+ "WHERE  DPD_DEP_SYS_ID = ? AND    DPD_PAY_MODE   = 'C'";

		String C14 = "SELECT POL_PREM_PAY_YRS,PROD_AGENT_HIRE_YN "
				+ "FROM   PT_IL_POLICY,PM_IL_PRODUCT "
				+ "WHERE  POL_NO        = ? "
				+ "AND    POL_PROD_CODE =  PROD_CODE";

		String C15 = "SELECT PD_LC_CHARGE FROM   PT_IL_PYMT_DTLS "
				+ "WHERE  PD_TXN_TYPE   = ? " + "AND    PD_TXN_SYS_ID = ?";

		CRUDHandler handler = new CRUDHandler();
		Long dep_sys = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet C8_REC = null;
		ResultSet C9_REC = null;
		ResultSet C10_REC = null;
		ResultSet C11_REC = null;
		ResultSet C12_REC = null;
		ResultSet C13_REC = null;
		ResultSet C14_REC = null;
		ResultSet C15_REC = null;

		String P_BASE_CURR_CODE = null;
		Double M_PD_LC_CHARGE = 0.0;
		Integer M_POL_PREM_PAY_YRS = 0;
		String M_PROD_AGENT_HIRE_YN = null;
		String M_NAME1 = null;
		String M_CODE = null;
		String M_NAME = null;
		String M_BL_NAME = null;
		String M_TEMP = null;
		int M_COUNT = 0;
		Connection con = null;
		LIFELIB lifelib = new LIFELIB();
		ArrayList<OracleParameter> list;
		Long M_POL_SYS_ID = null;

		String M_PLAN_TYPE = null;
		String M_POL_MODE_OF_PYMT = null;
		String M_DPD_PAY_MODE = null;
		String M_DPD_CHQ_NO = null;
		Date M_DPD_CHQ_DT = null;

		DBProcedures procedures = new DBProcedures();

		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = compositeAction
				.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		try {
			con = CommonUtils.getConnection();
			list = lifelib.P_VAL_DEPT(PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(),
					PT_IL_DEPOSIT_BEAN.getDEP_DEPT_CODE(), PT_IL_DEPOSIT_BEAN
							.getUI_M_DEP_DEPT_DESC(), "N", "N");

			if (list != null && !list.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DEPT_DESC((String) list.get(0)
						.getValue());
			}
			ArrayList<OracleParameter> list1 = lifelib.P_VAL_DIVN(
					PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(), PT_IL_DEPOSIT_BEAN
							.getUI_M_DEP_DIVN_DESC(), "N", "N");
			if (list1 != null && !list1.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DIVN_DESC((String) list1.get(0)
						.getValue());
			}

			PT_IL_DEPOSIT_BEAN.setUI_M_BANKIN_NAME(L_VAL_BANK(
					PT_IL_DEPOSIT_BEAN.getDEP_BANKIN_CODE(), null, ""));

			C1_REC = handler.executeSelectStatement(C1, con, new Object[] {
					PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE(),
					CommonUtils.getControlBean().getM_DIVN_CODE() });
			if (C1_REC.next()) {
				M_CODE = C1_REC.getString(1);
				M_NAME = C1_REC.getString(2);
				M_BL_NAME = C1_REC.getString(3);
				PT_IL_DEPOSIT_BEAN.setUI_M_CUST_NAME(M_NAME);
			}

			C2_REC = handler.executeSelectStatement(C2, con,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_CONT_CODE() });
			if (C2_REC.next()) {
				M_NAME1 = C2_REC.getString(1);
				PT_IL_DEPOSIT_BEAN.setUI_M_CONT_NAME(M_NAME1);
			}

			if ("Q".equalsIgnoreCase(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN
					.getDEP_TYPE(), "Q"))) {
				C3_REC = handler.executeSelectStatement(C3, con,
						new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
				if (C3_REC.next()) {
					M_TEMP = C3_REC.getString(1);
				}
				if ("X".equalsIgnoreCase(CommonUtils.nvl(M_TEMP, "Y"))) {
					C4_REC = handler.executeSelectStatement(C4, con,
							new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO(),
									PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
					if (C4_REC.next()) {
						PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM(C4_REC
								.getDouble(1));
						M_POL_SYS_ID = C4_REC.getLong(2);
					}
					/*L_GROSS_PREM(M_POL_SYS_ID, null, null, null, null, null,
							null);*/
					ArrayList<OracleParameter> list7 = L_GROSS_PREM(
							M_POL_SYS_ID, CommonUtils.getControlBean()
									.getM_BASE_CURR(), PT_IL_DEPOSIT_BEAN
									.getDEP_PROD_CODE(), PT_IL_DEPOSIT_BEAN
									.getUI_M_POL_LC_GROSS_PREM(), PT_IL_DEPOSIT_BEAN
									.getUI_M_POL_LC_NET_PREM(), PT_IL_DEPOSIT_BEAN
									.getUI_M_POL_LC_COMMISSION(), null, null);
					if (list7 != null && !list7.isEmpty()) {
						PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM((Double) list7
								.get(0).getValueObject());
						/*added by raja on 28-02-2017 */
						
						PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT((Double) list7
								.get(0).getValueObject());
						/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
						/*PT_IL_DEPOSIT_BEAN.setDEP_LC_AMT((Double) list7
								.get(3).getValueObject());*/
						/*End Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
						/*Commeneted by Ram on 05-03-2017.Refer Falcon Source
						 * 
						 * PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT((Double) list7
								.get(0).getValueObject());
						
						PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT((Double) list7
								.get(0).getValueObject());*/
						
						
						
						/*end*/
						PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM((Double) list7.get(
								1).getValueObject());
						PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_COMMISSION((Double) list7
								.get(2).getValueObject());
					}
				} else {
					PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM(0.0);
				}

			} else if ("P".equalsIgnoreCase(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN
					.getDEP_TYPE(), "Q"))) {
				C5_REC = handler.executeSelectStatement(C5, con,
						new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
				if (C5_REC.next()) {
					M_TEMP = C5_REC.getString(1);
				}
				if ("X".equalsIgnoreCase(CommonUtils.nvl(M_TEMP, "Y"))) {
					C6_REC = handler.executeSelectStatement(C6, con,
							new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO()
									});
					if (C6_REC.next()) {
						PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM(C6_REC
								.getDouble(1));
						M_POL_SYS_ID = C6_REC.getLong(2);
					}
					/*L_GROSS_PREM(M_POL_SYS_ID, null, null, null, null, null,
							null);*/
					if(PT_IL_DEPOSIT_BEAN.getDEP_CURR_CODE() != null){
						ArrayList<OracleParameter> list7 = L_GROSS_PREM(
								M_POL_SYS_ID, PT_IL_DEPOSIT_BEAN.getDEP_CURR_CODE(), PT_IL_DEPOSIT_BEAN
										.getDEP_PROD_CODE(), PT_IL_DEPOSIT_BEAN
										.getUI_M_POL_LC_GROSS_PREM(), PT_IL_DEPOSIT_BEAN
										.getUI_M_POL_LC_NET_PREM(), PT_IL_DEPOSIT_BEAN
										.getUI_M_POL_LC_COMMISSION(), null, null);
						if (list7 != null && !list7.isEmpty()) {
							PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM((Double) list7
									.get(0).getValueObject());
	/*added by raja on 28-02-2017 */
							
							PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT((Double) list7
									.get(0).getValueObject());
							
							/*Commeneted by Ram on 05-03-2017.Refer Falcon Source
							 * 
							 * PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT((Double) list7
									.get(0).getValueObject());
							
							PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT((Double) list7
									.get(0).getValueObject());*/
							
							/*end*/
							
							PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM((Double) list7.get(
									1).getValueObject());
							PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_COMMISSION((Double) list7
									.get(2).getValueObject());
						}
					}else{
						ArrayList<OracleParameter> list7 = L_GROSS_PREM(
								M_POL_SYS_ID, CommonUtils.getControlBean()
										.getM_BASE_CURR(), PT_IL_DEPOSIT_BEAN
										.getDEP_PROD_CODE(), PT_IL_DEPOSIT_BEAN
										.getUI_M_POL_LC_GROSS_PREM(), PT_IL_DEPOSIT_BEAN
										.getUI_M_POL_LC_NET_PREM(), PT_IL_DEPOSIT_BEAN
										.getUI_M_POL_LC_COMMISSION(), null, null);
						if (list7 != null && !list7.isEmpty()) {
							PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM((Double) list7
									.get(0).getValueObject());
	/*added by raja on 28-02-2017 */
							
							PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT((Double) list7
									.get(0).getValueObject());
							
							/*Commeneted by Ram on 05-03-2017.Refer Falcon Source
							 * 
							 * PT_IL_DEPOSIT_BEAN.setDEP_LC_TOTAL_AMT((Double) list7
									.get(0).getValueObject());
							
							PT_IL_DEPOSIT_BEAN.setDEP_LC_DEP_AMT((Double) list7
									.get(0).getValueObject());*/
							
							/*end*/
							
							PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM((Double) list7.get(
									1).getValueObject());
							PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_COMMISSION((Double) list7
									.get(2).getValueObject());
						}
					}
					
				}
			}

			C14_REC = handler.executeSelectStatement(C14, con,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
			if (C14_REC.next()) {
				M_POL_PREM_PAY_YRS = C14_REC.getInt(1);
				M_PROD_AGENT_HIRE_YN = C14_REC.getString(2);
			}

			//Commented by Akash to make normal flow(Calc_method 2 ) to work dated 03-feb-2013 
			
			if (/*"1".equalsIgnoreCase(compositeAction.getDUMMY_BEAN()
					.getUI_M_CALC_METHOD())
					&&*/ M_POL_PREM_PAY_YRS == 1
					&& "N".equalsIgnoreCase(M_PROD_AGENT_HIRE_YN)) {
				C7_REC = handler.executeSelectStatement(C7, con, new Object[] {
						PT_IL_DEPOSIT_BEAN.getDEP_REF_NO(),
						PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
				if (C7_REC.next()) {
					M_COUNT = C7_REC.getInt(1);
				}
				if (M_COUNT > 0) {
					compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
							.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(true);
				} else {
					compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
							.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(false);
				}
			}
			

			/*PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_GROSS_PREM(CommonUtils.nvl(
					PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM(), 0));
			PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_COMMISSION(CommonUtils.nvl(
					PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_COMMISSION(), 0));
			PT_IL_DEPOSIT_BEAN.setUI_M_POL_LC_NET_PREM(CommonUtils.nvl(
					PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_NET_PREM(), 0));
*/
			/*
			 * C15_REC = handler.executeSelectStatement(C15, con,new
			 * Object[]{PT_IL_DEPOSIT_BEAN.get,PT_IL_DEPOSIT_BEAN.getDEP_REF_NO()});
			 * if (C15_REC.next()) { M_COUNT = C15_REC.getInt(1); }
			 */// TODO
			if (PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() != null
					&& PT_IL_DEPOSIT_BEAN.getDEP_LC_OTH_AMT() != null) {
				PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(CommonUtils.nvl(
						PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT(), 0));
			} else if (PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT() != null
					&& PT_IL_DEPOSIT_BEAN.getDEP_LC_OTH_AMT() == null) {
				PT_IL_DEPOSIT_BEAN.setDEP_LC_TOT_AMT(CommonUtils.nvl(
						PT_IL_DEPOSIT_BEAN.getDEP_LC_TOTAL_AMT(), 0));
			}

			if ("Q".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_TYPE())
					&& CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT(), 0) > 0) {
				CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "QD");
			} else if ("P".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_TYPE())
					&& CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT(), 0)  > 0) {
				CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
			} else if (("P".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_TYPE()) || "Q"
					.equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_TYPE()))
					&& CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT(), 0) > 0) {
				CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "DR");
			}
			/*added by raja on 04-07-2017*/
			else if ("S".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN.getDEP_TYPE())
					&& CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT(), 0)  > 0) {
				
				/*Modified by Janani on 02.02.2018 for ZBLIFE-1456608 */
				//CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "SD");
				CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
				/*End of ZBLIFE-1456608*/
			}

			/*end*/
			
			ArrayList<String> agentCodeList = lifelib.P_VAL_CLASS_CUST(
					"IL_BROKER", PT_IL_DEPOSIT_BEAN.getDEP_AGENT_CODE(),
					PT_IL_DEPOSIT_BEAN.getUI_M_DEP_AGENT_CODE_DESC(), null,
					"N", null);
			if (agentCodeList != null && !agentCodeList.isEmpty()) {
				PT_IL_DEPOSIT_BEAN
						.setUI_M_DEP_AGENT_CODE_DESC((String) agentCodeList
								.get(0));
			}

			ArrayList<String> colAgentCodeList = lifelib.P_VAL_CLASS_CUST(
					"IL_BROKER", PT_IL_DEPOSIT_BEAN.getDEP_COLL_AGENT_CODE(),
					PT_IL_DEPOSIT_BEAN.getUI_M_DEP_COLL_AGENT_CODE_DESC(),
					null, "N", null);
			if (colAgentCodeList != null && !colAgentCodeList.isEmpty()) {
				PT_IL_DEPOSIT_BEAN
						.setUI_M_DEP_COLL_AGENT_CODE_DESC((String) colAgentCodeList
								.get(0));
			}

			list = lifelib.P_VAL_CLASS(PT_IL_DEPOSIT_BEAN.getDEP_CLASS_CODE(),
					PT_IL_DEPOSIT_BEAN.getUI_M_DEP_CLASS_CODE_DESC(), "N", "N");
			if (list != null && !list.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_CLASS_CODE_DESC((String) list
						.get(0).getValue());
			}

			list = lifelib.P_VAL_PLAN(PT_IL_DEPOSIT_BEAN.getDEP_PLAN_CODE(),
					PT_IL_DEPOSIT_BEAN.getUI_M_DEP_PLAN_CODE_DESC(), "N", "N");
			if (list != null && !list.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_PLAN_CODE_DESC((String) list
						.get(0).getValueObject());
			}

			C10_REC = handler.executeSelectStatement(C10, con,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_CUST_CODE() });
			if (C10_REC.next()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_CUST_NAME(C10_REC.getString(1));
			}

			if (PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE() != null) {
				C8_REC = handler.executeSelectStatement(C8, con,
						new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_PROD_CODE() });
				if (C8_REC.next()) {
					PT_IL_DEPOSIT_BEAN.setUI_M_DEP_PROD_CODE_DESC(C8_REC
							.getString(1));
				}

				C9_REC = handler.executeSelectStatement(C9, con,
						new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_DS_CODE() });
				if (C9_REC.next()) {
					PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DS_CODE_DESC(C9_REC
							.getString(1));
				}
			}

			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_CLASS_CODE().setDisabled(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_PROD_CODE().setDisabled(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_DIVN_CODE().setDisabled(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_DEPT_CODE().setDisabled(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_PLAN_CODE().setDisabled(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_DS_CODE().setDisabled(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_SRC_OF_BUS().setDisabled(true);

			if ("Q".equalsIgnoreCase(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN
					.getDEP_TYPE(), "Q"))) {
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_DEP_AGENT_CODE().setDisabled(false);
			} else if ("Q".equalsIgnoreCase(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN
					.getDEP_TYPE(), "P"))) {
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_DEP_AGENT_CODE().setDisabled(true);
			}

			C11_REC = handler.executeSelectStatement(C11, con,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_PLAN_CODE() });
			if (C11_REC.next()) {
				M_PLAN_TYPE = C11_REC.getString(1);
			}

			if (PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() != null) {
				PT_IL_DEPOSIT_BEAN.setUI_M_POL_FLAG("N");
			} else {
				PT_IL_DEPOSIT_BEAN.setUI_M_POL_FLAG("Y");
			}

			if ("Y".equalsIgnoreCase(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN
					.getDEP_REC_REV_YN(), "N"))) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_REV_STATUS("Reversed");
			} else {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_REV_STATUS(null);
			}

			PT_IL_DEPOSIT_BEAN.setUI_M_DEP_UPD_UID(PT_IL_DEPOSIT_BEAN
					.getDEP_UPD_UID());

			if (PT_IL_DEPOSIT_BEAN.getDEP_SRC_OF_BUS() != null) {
				List<String> srcofBusList = procedures.P_VAL_CODES(
						"SRC_BUS_TY", PT_IL_DEPOSIT_BEAN.getDEP_SRC_OF_BUS(),
						"N", "W", null);
				if (srcofBusList != null && !srcofBusList.isEmpty()) {
					PT_IL_DEPOSIT_BEAN
							.setUI_M_DEP_BUS_DESC(srcofBusList.get(0));
				}
			}

			C12_REC = handler.executeSelectStatement(C12, con,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() });
			if (C12_REC.next()) {
				M_POL_MODE_OF_PYMT = C12_REC.getString(1);
			}

			C13_REC = handler.executeSelectStatement(C13, con,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_SYS_ID() });
			if (C13_REC.next()) {
				M_DPD_PAY_MODE = C13_REC.getString(1);
				M_DPD_CHQ_NO = C13_REC.getString(2);
				M_DPD_CHQ_DT = C13_REC.getDate(3);
			}

			String M_PS_CODE_DESC = null;
			int M_PS_VALUE_DAYS = 0;

			List<String> listVal = DBProcedures.P_VAL_SYSTEM("IL_CHQ_DAYS",
					"IL_CHQ_DAYS", "N");
			if (listVal != null && !listVal.isEmpty()) {
				M_PS_CODE_DESC = (String) list.get(0).getValue();
			}

			if ("S".equalsIgnoreCase(M_POL_MODE_OF_PYMT)
					&& "N".equalsIgnoreCase(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN
							.getDEP_PDC_FLAG(), "Y"))) {
				 if("C".equals(M_DPD_PAY_MODE) && 
						 (CommonUtils.nvl(M_PS_VALUE_DAYS,0) > CommonUtils.subtractDate(new CommonUtils().getCurrentDate(), M_DPD_CHQ_DT))){
		         compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getCOMP_UI_M_CHEQUE().setDisabled(true);
				 } else  if("C".equals(M_DPD_PAY_MODE) &&
						 (CommonUtils.nvl(M_PS_VALUE_DAYS,0) <= CommonUtils.subtractDate(new CommonUtils().getCurrentDate(), M_DPD_CHQ_DT)) &&
						 CommonUtils.nvl(M_PS_VALUE_DAYS,0) != 0){
					 compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getCOMP_UI_M_CHEQUE().setDisabled(false);
				 }
			} else {
				  compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getCOMP_UI_M_CHEQUE().setDisabled(true);
			}

			if ("G"
					.equalsIgnoreCase(PT_IL_DEPOSIT_BEAN
							.getDEP_GROSS_NET_FLAG())) {
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_UI_M_POL_LC_GROSS_PREM().setRendered(true);
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_UI_M_POL_LC_NET_PREM().setRendered(false);
			} else if ("N".equalsIgnoreCase(PT_IL_DEPOSIT_BEAN
					.getDEP_GROSS_NET_FLAG())) {
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_UI_M_POL_LC_GROSS_PREM().setRendered(false);
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_UI_M_POL_LC_NET_PREM().setRendered(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C2_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C3_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C4_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C5_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C6_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C7_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				CommonUtils.closeCursor(C8_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C9_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C10_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C11_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C12_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C13_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C14_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(C15_REC);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void whenCreateRecord(PILT016A_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		String bankQuery = " SELECT PLAN_TYPE  FROM   PM_IL_PLAN  WHERE  PLAN_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		LIFELIB lifelib = new LIFELIB();
		List<OracleParameter> list = null;
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = compositeAction
				.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		try {
			connection = CommonUtils.getConnection();
			PT_IL_DEPOSIT_BEAN.setDEP_DIVN_CODE(CommonUtils.getControlBean()
					.getM_DIVN_CODE());
			PT_IL_DEPOSIT_BEAN.setDEP_DEPT_CODE(CommonUtils.getControlBean()
					.getM_DEPT_CODE());
			PT_IL_DEPOSIT_BEAN.setUI_M_POL_FLAG("N");
			PT_IL_DEPOSIT_BEAN.setDEP_REPL_RCPT_YN("N");
			PT_IL_DEPOSIT_BEAN.setDEP_BANKIN_CODE(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_12"));

			PT_IL_DEPOSIT_BEAN.setUI_M_BANKIN_NAME(L_VAL_BANK(
					PT_IL_DEPOSIT_BEAN.getDEP_BANKIN_CODE(), PT_IL_DEPOSIT_BEAN
							.getUI_M_BANKIN_NAME(), "N"));

			list = lifelib.P_VAL_DEPT(PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(),
					PT_IL_DEPOSIT_BEAN.getDEP_DEPT_CODE(), PT_IL_DEPOSIT_BEAN
							.getUI_M_DEP_DEPT_DESC(), "N", "N");

			if (list != null && !list.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DEPT_DESC((String) list.get(0)
						.getValue());
			}
			ArrayList<OracleParameter> list1 = lifelib.P_VAL_DIVN(
					PT_IL_DEPOSIT_BEAN.getDEP_DIVN_CODE(), PT_IL_DEPOSIT_BEAN
							.getUI_M_DEP_DIVN_DESC(), "N", "N");
			if (list1 != null && !list1.isEmpty()) {
				PT_IL_DEPOSIT_BEAN.setUI_M_DEP_DIVN_DESC((String) list1.get(0)
						.getValue());
			}

			PT_IL_DEPOSIT_BEAN.setDEP_TYPE("Q");
			PT_IL_DEPOSIT_BEAN.setDEP_GROSS_NET_FLAG("G");

			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_UI_M_BUT_APPROVAL().setDisabled(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getCOMP_DEP_REF_NO()
					.setDisabled(false);

			//Commented by Akash to make normal flow(Calc_method 2 ) to work dated 03-feb-2013 
			
			if (/*"1".equalsIgnoreCase(compositeAction.getDUMMY_BEAN()
					.getUI_M_CALC_METHOD())
					&& */"M".equalsIgnoreCase(compositeAction.getDUMMY_BEAN()
							.getUI_M_PLAN_TYPE())
					&& "X".equalsIgnoreCase(CommonUtils
							.nvl(compositeAction.getDUMMY_BEAN()
									.getUI_M_PROD_PREM_CALC_MTHD(), "N"))) {
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(false);
			}

			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_CONT_CODE().setRequired(true);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_LC_DEP_AMT().setRequired(true);
			String M_PLAN_TYPE = null;
			resultSet = handler.executeSelectStatement(bankQuery, connection,
					new Object[] { PT_IL_DEPOSIT_BEAN.getDEP_PLAN_CODE() });
			if (resultSet.next()) {
				M_PLAN_TYPE = resultSet.getString(1);
			}

			if ("M".equalsIgnoreCase(CommonUtils.nvl(M_PLAN_TYPE, ""))
					&& "N".equalsIgnoreCase(CommonUtils
							.nvl(compositeAction.getDUMMY_BEAN()
									.getUI_M_PROD_PREM_CALC_MTHD(), "X"))) {
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(false);
			} else {
				compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(true);
			}

			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_CONT_CODE().setRequired(false);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_CLASS_CODE().setDisabled(false);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_PROD_CODE().setDisabled(false);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_PLAN_CODE().setDisabled(false);
			compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
					.getCOMP_DEP_DS_CODE().setDisabled(false);

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}

	public String L_VAL_BANK(String P_BANK_CODE, String P_BANK_NAME,
			String P_ERR_FLAG) throws Exception {
		String bankQuery = " SELECT BANK_NAME  FROM   FM_BANK  WHERE  BANK_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		String Class_name = null;
		String Class_code = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(bankQuery, connection,
					new Object[] { P_BANK_CODE });
			if (resultSet.next()) {
				P_BANK_NAME = resultSet.getString(1);
			} else {
				if ("E".equalsIgnoreCase(P_ERR_FLAG)
						|| "W".equalsIgnoreCase(P_ERR_FLAG)) {
					/*
					 * throw new Exception(Messages.getString(
					 * PELConstants.pelErrorMessagePath, new
					 * Object[]{"3206","Invalid Bank...Please Re-enter"}));
					 */
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { "Invalid Bank...Please Re-enter" }));
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return P_BANK_NAME;
	}

	public void executeQuery(PILT016A_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		try {
			new PILT016A_APAC_PT_IL_DEPOSIT_DELEGATE()
					.executeQuery(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void preBlock(CTRL CTRL_BEAN) {
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "TRUE");
		CTRL_BEAN.setUI_M_DELETE_MSG_FLAG("Y");
	}

	public String ValidateClassCode(String value) throws Exception {
		String classCodeDescQuery = "SELECT CLASS_CODE, CLASS_NAME  FROM PM_IL_CLASS WHERE CLASS_FRZ_FLAG = 'N'AND CLASS_CODE=?";
		CRUDHandler handler = new CRUDHandler();
		String Class_name = null;
		String Class_code = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(classCodeDescQuery,
					connection, new Object[] { value });
			if (resultSet.next()) {
				Class_code = resultSet.getString(1);
				Class_name = resultSet.getString(2);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

		return Class_name;
	}

	public String validateBankcode(String value) throws Exception {
		String bankCodeDescQuery = "SELECT BANK_CODE,BANK_NAME FROM FM_BANK WHERE BANK_CODE=?";
		CRUDHandler handler = new CRUDHandler();
		String Bank_name = null;
		String Bank_code = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(bankCodeDescQuery,
					connection, new Object[] { value });
			if (resultSet.next()) {
				Bank_code = resultSet.getString(1);
				Bank_name = resultSet.getString(2);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

		return Bank_name;
	}

	public String validatPlanCode(String value) throws Exception {
		String coverCodeDescQuery = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER WHERE COVER_TYPE IN('B') AND COVER_CODE=?";
		CRUDHandler handler = new CRUDHandler();
		String plan_Name = null;
		String plan_Code = null;
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(coverCodeDescQuery,
					connection, new Object[] { value });
			if (resultSet.next()) {
				plan_Code = resultSet.getString(1);
				plan_Name = resultSet.getString(2);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

		return plan_Name;
	}

	private PT_IL_DEPOSIT_DB_CLASS localprocedure = new PT_IL_DEPOSIT_DB_CLASS();

	public void validateDep_Cont_Ref_Id1(PT_IL_DEPOSIT_ACTION depositAction)
			throws Exception {

		Integer M_LENGTH_1 = null;
		Integer M_NEW_IC_NO_LENGTH = null;
		String M_CODE_DESC = null;
		Integer M_REF_ID_1_LENGTH = null;
		Date M_CUST_DOB = null;
		String M_DATE_CHAR = null;
		Date M_TEMP_DATE = null;
		Integer M_LENGTH_2 = null;
		Integer M_REF_ID2_LENGTH = null;
		String M_CONT_REF_ID2 = null;
		Integer M_OLD_IC_NO_LENGTH = null;
		String M_POL_NO = null;
		String M_POL_PROP_NO = null;
		String M_PS_VALUE = null;
		String M_POL_STATUS = null;
		String M_POL_MODE_OF_PYMT = null;
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = depositAction
				.getPT_IL_DEPOSIT_BEAN();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		DBProcedures procedures = new DBProcedures();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ArrayList<String> list = null;
		String CURSOR_C1 = "SELECT     NVL(CONT_REF_ID2 ,'') FROM  PM_IL_CONTRACTOR WHERE  CONT_REF_ID2 =  ? ";
		String LENGHT_QUERY = "SELECT DATA_LENGTH FROM USER_TAB_COLUMNS WHERE TABLE_NAME LIKE ? AND COLUMN_NAME LIKE ? ";
		String CURSOR_C2 = "SELECT POL_NO,POL_PROP_NO,POL_STATUS,POL_MODE_OF_PYMT FROM PT_IL_POLICY"
				+ "  WHERE POL_ASSRD_REF_ID1= ?  AND  (NVL(POL_CONVERT_YN,'N') = 'N' OR POL_DS_TYPE ='2')";

		String CURSOR_C3 = "SELECT SUBSTR(?,1,6) FROM   DUAL";
		ResultSet C3_REC = null;
		try {
			connection = CommonUtils.getConnection();

			if (PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() != null) {
				localprocedure.L_VALIDATE_POLICY(PT_IL_DEPOSIT_BEAN
						.getDEP_CONT_REF_ID1(), "N", PT_IL_DEPOSIT_BEAN
						.getDEP_REF_NO());
			}
			resultSet = handler.executeSelectStatement(LENGHT_QUERY,
					connection, new Object[] { "PT_IL_DEPOSIT",
							"DEP_CONT_REF_ID1" });
			if (resultSet.next()) {
				M_REF_ID_1_LENGTH = resultSet.getInt(1);
			}
			if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1() != null) {
				M_NEW_IC_NO_LENGTH = PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1()
						.length();
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(LENGHT_QUERY,
					connection, new Object[] { "PT_IL_DEPOSIT",
							"DEP_CONT_REF_ID2" });
			if (resultSet.next()) {
				M_REF_ID2_LENGTH = resultSet.getInt(1);
			}

			if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1() != null) {
				list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1",
						M_CODE_DESC, "N", CommonUtils
								.getProcedureValue(M_NEW_IC_NO_LENGTH));
				if (list != null && !list.isEmpty()) {
					M_CODE_DESC = list.get(0);
				}
				M_LENGTH_1 = Math.min(CommonUtils.nvl(M_NEW_IC_NO_LENGTH,
						M_REF_ID_1_LENGTH), M_REF_ID_1_LENGTH);
				if (M_NEW_IC_NO_LENGTH > M_LENGTH_1) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91240"));
				}

				list = null;
				list = DBProcedures.P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT",
						M_CODE_DESC, "N", M_PS_VALUE);
				if (list != null && !list.isEmpty()) {
					M_PS_VALUE = list.get(1);
				}
				if ("1".equals(M_PS_VALUE)) {

					C3_REC = handler.executeSelectStatement(CURSOR_C3,
							connection, new Object[] { PT_IL_DEPOSIT_BEAN
									.getDEP_CONT_REF_ID1() });
					if (C3_REC.next()) {
						M_DATE_CHAR = C3_REC.getString(1);
					}

					/*
					 * M_DATE_CHAR = CommonUtils.SUBSTR(PT_IL_DEPOSIT_BEAN
					 * .getDEP_CONT_REF_ID1(), 1, 6);
					 */

				/*Commented by Sankar on 13.8.2016 for new IC no validation
				 * 
				 * }
				 * end
				 * */
			

				try {
					M_TEMP_DATE = CommonUtils.stringToDate(M_DATE_CHAR,
							"yyMMdd");
					if (M_TEMP_DATE != null
							&& M_TEMP_DATE.getYear() > new CommonUtils()
									.getCurrentDate().getYear()) {
						M_TEMP_DATE = CommonUtils.addMonthsToDate(M_TEMP_DATE,
								-1200);
					}
				} catch (Exception exception) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91173"));
				}

				
				/*added by Sankar on 13.8.2016 for new IC no validation*/
			}
				
				/*end*/

				
			

				resultSet1 = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { PT_IL_DEPOSIT_BEAN
								.getDEP_CONT_REF_ID1() });
				if (resultSet1.next()) {
					M_CONT_REF_ID2 = resultSet1.getString(1);
					if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2() == null) {
						PT_IL_DEPOSIT_BEAN.setDEP_CONT_REF_ID2(M_CONT_REF_ID2);
					}
				}
				list = null;
				list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_2",
						M_CODE_DESC, "N", CommonUtils
								.getProcedureValue(M_OLD_IC_NO_LENGTH));
				if (list != null && !list.isEmpty()) {
					M_CODE_DESC = list.get(0);
					M_OLD_IC_NO_LENGTH = Integer.parseInt(list.get(1));
				}
				M_LENGTH_2 = Math.min(CommonUtils.nvl(M_OLD_IC_NO_LENGTH,
						M_REF_ID2_LENGTH), M_REF_ID2_LENGTH);
				if (M_OLD_IC_NO_LENGTH > M_LENGTH_2) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91240"));
				}
				if ("N".equals(PT_IL_DEPOSIT_BEAN.getUI_M_POL_STATUS())) {
					if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1() != null) {
						resultSet2 = handler.executeSelectStatement(CURSOR_C2,
								connection, new Object[] { PT_IL_DEPOSIT_BEAN
										.getDEP_CONT_REF_ID1() });
						if (resultSet2.next()) {
							M_POL_NO = resultSet2.getString(1);
							M_POL_PROP_NO = resultSet2.getString(2);
							M_POL_STATUS = resultSet2.getString(3);
							M_POL_MODE_OF_PYMT = resultSet2.getString(4);
							if (PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() == null) {

								PT_IL_DEPOSIT_BEAN.setDEP_REF_NO(CommonUtils
										.nvl(M_POL_NO, M_POL_PROP_NO));

							}
						}
					}
				}
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateDep_Cont_Ref_Id2(PT_IL_DEPOSIT_ACTION depositAction)
			throws Exception {

		String M_CODE_DESC = null;
		Integer M_LENGTH_2 = null;
		Integer M_OLD_IC_NO_LENGTH = null;
		Integer M_REF_ID2_LENGTH = null;// NUMBER:=GET_ITEM_PROPERTY('PT_IL_DEPOSIT.DEP_CONT_REF_ID2',MAX_LENGTH);
		String M_CONT_REF_ID1 = null;
		String M_POL_NO = null;
		String M_POL_PROP_NO = null;
		String M_POL_STATUS = null;
		String M_POL_MODE_OF_PYMT = null;
		String CURSOR_C1 = "SELECT   NVL(CONT_REF_ID1 ,'') FROM  PM_IL_CONTRACTOR WHERE  CONT_REF_ID2 = ? ";
		String CURSOR_C2 = "SELECT 	 POL_NO,POL_PROP_NO,POL_STATUS FROM PT_IL_POLICY "
				+ "WHERE POL_ASSRD_REF_ID1= ? AND  (NVL(POL_CONVERT_YN,'N') = 'N' OR POL_DS_TYPE ='2')";
		String CURSOR_C3 = "SELECT POL_NO,POL_PROP_NO,POL_STATUS,POL_MODE_OF_PYMT FROM PT_IL_POLICY "
				+ "WHERE POL_ASSRD_REF_ID2= ? AND  (NVL(POL_CONVERT_YN,'N') = 'N' OR POL_DS_TYPE ='2')";
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = depositAction
				.getPT_IL_DEPOSIT_BEAN();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ArrayList<String> list = null;
		ArrayList<String> list1 = null;
		try {
			connection = CommonUtils.getConnection();

			if (PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() != null) {
				localprocedure.L_VALIDATE_POLICY(PT_IL_DEPOSIT_BEAN
						.getDEP_CONT_REF_ID2(), "O", PT_IL_DEPOSIT_BEAN
						.getDEP_REF_NO());
				if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2() != null) {
					resultSet = handler.executeSelectStatement(CURSOR_C1,
							connection, new Object[] { PT_IL_DEPOSIT_BEAN
									.getDEP_CONT_REF_ID2() });
					if (resultSet.next()) {
						M_CONT_REF_ID1 = resultSet.getString(1);
						if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1() == null) {
							PT_IL_DEPOSIT_BEAN
									.setDEP_CONT_REF_ID1(M_CONT_REF_ID1);
						}
					}
					list = DBProcedures.P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_2",
							M_CODE_DESC, "N", CommonUtils
									.getProcedureValue(M_OLD_IC_NO_LENGTH));
					if (list != null && !list.isEmpty()) {
						M_CODE_DESC = list.get(0);
						M_OLD_IC_NO_LENGTH = Integer.parseInt(list.get(1));
					}
					if (M_OLD_IC_NO_LENGTH != null && M_REF_ID2_LENGTH != null) {
						M_LENGTH_2 = Math.min(CommonUtils.nvl(
								M_OLD_IC_NO_LENGTH, M_REF_ID2_LENGTH),
								M_REF_ID2_LENGTH);
					}

					if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2() != null
							&& M_LENGTH_2 != null
							&& PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2()
									.length() > M_LENGTH_2) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91240"));
					}
					if ("N".equals(PT_IL_DEPOSIT_BEAN.getUI_M_POL_STATUS())) {
						if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID1() != null) {
							resultSet1 = handler.executeSelectStatement(
									CURSOR_C2, connection,
									new Object[] { PT_IL_DEPOSIT_BEAN
											.getDEP_CONT_REF_ID1() });
							if (resultSet1.next()) {
								M_POL_NO = resultSet1.getString(1);
								M_POL_PROP_NO = resultSet1.getString(2);
								M_POL_STATUS = resultSet2.getString(3);
								if (PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() == null) {
									PT_IL_DEPOSIT_BEAN
											.setDEP_REF_NO(CommonUtils.nvl(
													M_POL_NO, M_POL_PROP_NO));
								}
							}
						} else if (PT_IL_DEPOSIT_BEAN.getDEP_CONT_REF_ID2() != null) {
							resultSet2 = handler.executeSelectStatement(
									CURSOR_C3, connection,
									new Object[] { PT_IL_DEPOSIT_BEAN
											.getDEP_CONT_REF_ID2() });
							if (resultSet2.next()) {
								M_POL_NO = resultSet2.getString(1);
								M_POL_PROP_NO = resultSet2.getString(2);
								M_POL_STATUS = resultSet2.getString(3);
								M_POL_MODE_OF_PYMT = resultSet2.getString(4);
								if (PT_IL_DEPOSIT_BEAN.getDEP_REF_NO() == null) {
									PT_IL_DEPOSIT_BEAN
											.setDEP_REF_NO(CommonUtils.nvl(
													M_POL_NO, M_POL_PROP_NO));
								}
							}

						}
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	public void validateDep_Ref_No(PT_IL_DEPOSIT_ACTION depositAction,
			DUMMY dummy) throws Exception {

		Long M_POL_SYS_ID = null;
		String M_DEP_GROSS_NET_FLAG = null;
		String M_AGENT_LEVEL = null;
		String M_POL_CUST_CODE = null;
		Integer M_TEMP_VAL = null;
		String M_POL_ADDL_STATUS = null;
		String M_CODE_DESCRIPTION = null;
		String M_TEMP = null;
		String M_TEMP1 = null;
		String M_TEMP2 = null;
		String M_TEMP3 = null;
		String M_AGENT_CODE = null;
		Double M_LC_FIRST_PREM = null;
		String M_PLAN_TYPE = null;
		String M_DUMMY = null;
		String M_POL_NO = null;
		String M_POL_NET_PREM_YN = null;
		String M_POL_STATUS = null;
		String M_POL_MODE_OF_PYMT = null;
		String M_POL_PROP_NO = null;
		String MAX_POL_END_NO_IDX = null;
		String M_POL_MODE_OF_PYMT_1 = null;
		Integer M_POL_PREM_PAY_YRS = null;
		String M_PROP_FLAG = null;
		String M_PROD_AGENT_HIRE_YN = null;
		ResultSet resultSet = null, resultSet1 = null, resultSet2 = null, resultSet3 = null, resultSet4 = null;
		ResultSet resultSet5 = null, resultSet6 = null, resultSet7 = null;
		String check_value = null;
		Object[] value1 = null;

		String CURSOR_C1 = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '1' AND  POL_NO = ? ";
		String CURSOR_C2A = "SELECT MAX(POL_END_NO_IDX) FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
		String CURSOR_C2 = "SELECT POL_CONT_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0),POL_SYS_ID,POL_ADDL_STATUS FROM   PT_IL_POLICY"
				+ "WHERE  POL_DS_TYPE = '1' AND    POL_NO = ?   AND    POL_END_NO_IDX = ? ";
		// When the deposit type selected is Policy then the deposit reference
		// number to be validated against POL_NO
		// not against the POL_PROP_NO
		// Cursor C3 and C4 modified by SudhaR on 07-Oct-03
		String CURSOR_C3 = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND    POL_NO = ? ";
		String CURSOR_C4 = "SELECT POL_CONT_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0),POL_SYS_ID,POL_ADDL_STATUS"
				+ " FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND    POL_NO = ? ";
		String CURSOR_C5 = " SELECT 'X' FROM   PT_IL_DEPOSIT WHERE  DEP_REF_NO = ? AND  NVL(DEP_REC_REV_YN,'N')= 'N' ";

		String CURSOR_C6 = "SELECT POL_CONT_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0),POL_SYS_ID,POL_CLASS_CODE,POL_DS_CODE,"
				+ "POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,"
				+ "POL_NET_PREM_YN,POL_MODE_OF_PYMT FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND    POL_NO = ? ";
		
		/*
		 * reverted back by Ameen on 21-05-2018 ,Issue Reg. : deposit get updated for customer instead of contractor
		 * String CURSOR_C6 = "SELECT POL_CUST_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0),POL_SYS_ID,POL_CLASS_CODE,POL_DS_CODE,"
				+ "POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,"
				+ "POL_NET_PREM_YN,POL_MODE_OF_PYMT FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND    POL_NO = ? ";*/
		String CURSOR_C7 = "SELECT MAX(POBH_AGENT_LEVEL) FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID = ?  ";
		String CURSOR_C8 = "SELECT  POBH_BROKER_CODE  FROM  PT_IL_POL_BROKER_HEAD WHERE   POBH_POL_SYS_ID = ? AND  POBH_AGENT_LEVEL = ? ";
		String CURSOR_C9 = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND  POL_PROP_NO =  ?  AND POL_APPRV_STATUS ='A'";
		String CURSOR_C9A = "SELECT POL_NO  FROM   PT_IL_POLICY  WHERE  POL_DS_TYPE = '2' AND POL_PROP_NO = ? ";
		
		String CURSOR_C10 = "SELECT POL_CONT_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0), POL_SYS_ID, POL_CLASS_CODE, POL_DS_CODE,"
				+ "POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_NET_PREM_YN,"
				+ "POL_STATUS,POL_MODE_OF_PYMT FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '1'  AND    POL_NO = ? AND    POL_END_NO_IDX = ? ";
		
		/*
		 * reverted back by Ameen on 21-05-2018 ,Issue Reg. : deposit get updated for customer instead of contractor
		 * String CURSOR_C10 = "SELECT POL_CUST_CODE,POL_CUST_CODE,NVL(POL_LC_NET_PREM,0), POL_SYS_ID, POL_CLASS_CODE, POL_DS_CODE,"
				+ "POL_PROD_CODE,POL_PLAN_CODE,POL_ADDL_STATUS,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_SRC_OF_BUS,POL_NET_PREM_YN,"
				+ "POL_STATUS,POL_MODE_OF_PYMT FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '1'  AND    POL_NO = ? AND    POL_END_NO_IDX = ? ";*/
		String CURSOR_C11 = "SELECT CUST_CODE FROM PM_CUSTOMER WHERE CUST_REF_ID1= ? OR CUST_REF_ID2= ? ";
		String CURSOR_C12 = "SELECT PROD_DESC FROM   PM_IL_PRODUCT WHERE  PROD_CODE= ? ";
		String CURSOR_C13 = "SELECT DS_DESC FROM   PM_IL_DOC_SETUP WHERE  DS_CODE= ? ";
		String CURSOR_C14 = "SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = ? ";
		String CURSOR_C15 = "SELECT CONT_NAME FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE =  ? ";
		String CURSOR_C16 = "SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE  PLAN_CODE= ? ";
		String CURSOR_C17 = "SELECT DEP_AGENT_CODE FROM   PT_IL_DEPOSIT WHERE  DEP_REF_NO= ? ";
		// condition 'C' added By Praveen/Indra For “System should not allow
		// user to Do receipting For canceled certs”.
		String CURSOR_C18 = "SELECT 'X' FROM  PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND NVL(POL_STATUS,'N') IN ('S','P','D','M','C') AND POL_NO = ? ";
		String CURSOR_C19 = "SELECT  POL_MODE_OF_PYMT FROM PT_IL_POLICY WHERE(POL_NO =NVL(? ,'X') OR POL_PROP_NO = NVL(? ,'X'))";
		String CURSOR_C20 = "SELECT POL_PREM_PAY_YRS,PROD_AGENT_HIRE_YN FROM   PT_IL_POLICY ,PM_IL_PRODUCT WHERE  POL_NO = ? AND    POL_PROD_CODE = PROD_CODE ";
		String CURSOR_C21 = "SELECT  POL_PROP_NO  FROM   PT_IL_POLICY  WHERE  POL_NO = ? ";
		String CURSOR_C22 = "SELECT DEP_GROSS_NET_FLAG FROM  PT_IL_DEPOSIT WHERE DEP_REF_NO = ?  AND   NVL(DEP_REC_REV_YN,'N')= 'N'";
		String CURSOR_C23 = "SELECT 'X' FROM PM_CUSTOMER, PM_CUST_CLASS WHERE CUST_CLASS = CCLAS_CODE AND CCLAS_TYPE = '001' AND CUST_FLEX_SEL_01 = 'Y' AND CUST_CODE = ?"; 
		//Added by rakesh on 07-03-2020 for currency code default from policy issue
				String CURSOR_C24 = "SELECT POL_SA_CURR_CODE FROM   PT_IL_POLICY WHERE POL_NO = ? ";
				ResultSet rsC24 = null;
				//END
		CRUDHandler handler = new CRUDHandler();
		PT_IL_DEPOSIT depositBean = depositAction.getPT_IL_DEPOSIT_BEAN();

		/*
		 * Added by Anamika for changing the proposal to policy for the
		 * converted proposal
		 */
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C9A, connection,
					new Object[] { depositBean.getDEP_REF_NO() });
			if (resultSet.next()) {
				M_POL_NO = resultSet.getString(1);
				depositBean.setDEP_REF_NO(M_POL_NO);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { depositBean.getDEP_REF_NO() });
			if (resultSet.next()) {
				M_TEMP = resultSet.getString(1);
			}
			CommonUtils.closeCursor(resultSet);
			if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {
				
				/*added by raja on 04-07-2017*/
				String cust_code=null;
				String query="select pol_cust_code from pt_il_policy where pol_no=?";
				ResultSet rsquery=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(), new Object[]{depositBean.getDEP_REF_NO()});
				while(rsquery.next())
				{
					cust_code=rsquery.getString("pol_cust_code");
				}
				if(cust_code!=null && cust_code.equalsIgnoreCase(depositBean.getDEP_REF_NO()))
				{
					/*Modified by Janani on 05.02.2018 for ZBLIFE-1456608 */
					//depositBean.setDEP_TYPE("S");
					depositBean.setDEP_TYPE("P");
					/*End of ZBLIFE-1456608*/
				
				}
				else
				{
				depositBean.setDEP_TYPE("P");
				}
				/*end*/
			} else {
				depositBean.setDEP_TYPE("Q");
			}

			/** ******************************************************************************************************************* */

			if ("Q".equals(CommonUtils.nvl(depositBean.getDEP_TYPE(), "Q"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C3,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet.next()) {
					M_TEMP = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);

				if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {
					resultSet = handler.executeSelectStatement(CURSOR_C6,
							connection, new Object[] { depositBean
									.getDEP_REF_NO() });
					if (resultSet.next()) {
						depositBean.setDEP_CUST_CODE(resultSet.getString(2));
						depositBean.setDEP_CONT_CODE(resultSet.getString(1));
						depositBean.setUI_M_POL_LC_NET_PREM(resultSet
								.getDouble(3));
						M_POL_SYS_ID = resultSet.getLong(4);
						depositBean.setDEP_CLASS_CODE(resultSet.getString(5));
						if(depositBean.getDEP_DS_CODE()==null)
						depositBean.setDEP_DS_CODE(resultSet.getString(6));
						depositBean.setDEP_PROD_CODE(resultSet.getString(7));
						depositBean.setDEP_PLAN_CODE(resultSet.getString(8));
						M_POL_ADDL_STATUS = resultSet.getString(9);
						depositBean
								.setDEP_CONT_REF_ID1(resultSet.getString(10));
						depositBean
								.setDEP_CONT_REF_ID2(resultSet.getString(11));
						depositBean.setDEP_SRC_OF_BUS(resultSet.getString(12));
						//depositBean.setDEP_SYS_ID(M_POL_SYS_ID);
						M_POL_NET_PREM_YN = resultSet.getString(13);
						M_POL_MODE_OF_PYMT = resultSet.getString(14);
					}
					CommonUtils.closeCursor(resultSet);

					resultSet = handler.executeSelectStatement(CURSOR_C7,
							connection, new Object[] { M_POL_SYS_ID });
					if (resultSet.next()) {
						M_AGENT_LEVEL = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);

					resultSet = handler.executeSelectStatement(CURSOR_C8,
							connection, new Object[] { M_POL_SYS_ID,
									M_AGENT_LEVEL });
					if (resultSet.next()) {
						M_AGENT_CODE = resultSet.getString(1);
						depositBean.setDEP_AGENT_CODE(M_AGENT_CODE);
						depositBean.setDEP_COLL_AGENT_CODE(M_AGENT_CODE);
						ArrayList<OracleParameter> list2 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_AGENT_CODE(), depositBean
										.getUI_M_DEP_AGENT_CODE_DESC(), null,
										"N", null);
						if (list2 != null && !list2.isEmpty()) {
							depositBean
									.setUI_M_DEP_AGENT_CODE_DESC((String) list2
											.get(0).getValueObject());
						}
						ArrayList<OracleParameter> list3 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_COLL_AGENT_CODE(), depositBean
										.getUI_M_DEP_COLL_AGENT_CODE_DESC(),
										null, "N", null);
						if (list3 != null && !list3.isEmpty()) {
							depositBean
									.setUI_M_DEP_COLL_AGENT_CODE_DESC((String) list3
											.get(0).getValueObject());
						}
					} else {

						resultSet1 = handler.executeSelectStatement(CURSOR_C17,
								connection, new Object[] { depositBean
										.getDEP_REF_NO() });
						if (resultSet1.next()) {
							M_AGENT_CODE = resultSet1.getString(1);
						}
						depositBean.setDEP_AGENT_CODE(M_AGENT_CODE);
						depositBean.setDEP_COLL_AGENT_CODE(M_AGENT_CODE);
						ArrayList<OracleParameter> list2 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_AGENT_CODE(), depositBean
										.getUI_M_DEP_AGENT_CODE_DESC(), null,
										"N", null);
						if (list2 != null && !list2.isEmpty()) {
							depositBean
									.setUI_M_DEP_AGENT_CODE_DESC((String) list2
											.get(0).getValueObject());
						}
						ArrayList<OracleParameter> list3 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_COLL_AGENT_CODE(), depositBean
										.getUI_M_DEP_COLL_AGENT_CODE_DESC(),
										null, "N", null);
						if (list3 != null && !list3.isEmpty()) {
							depositBean
									.setUI_M_DEP_COLL_AGENT_CODE_DESC((String) list3
											.get(0).getValueObject());

						}

					}

					ArrayList<String> list4 = new DBProcedures().P_VAL_CLASS(
							depositBean.getDEP_CLASS_CODE(), "N", "N");
					if (list4 != null && !list4.isEmpty()) {
						depositBean.setUI_M_DEP_CLASS_CODE_DESC(list4.get(0));
					}
					String list5 = new DBProcedures().P_VAL_PLAN(depositBean
							.getDEP_PLAN_CODE(), "N", "N");
					if (list5 != null && !list5.isEmpty()) {
						depositBean.setUI_M_DEP_PLAN_CODE_DESC(list5);
					}
					if (depositBean.getDEP_SRC_OF_BUS() != null) {
						ArrayList<String> list6 = new DBProcedures()
								.P_VAL_CODES("SRC_BUS_TY", depositBean
										.getDEP_SRC_OF_BUS(), depositBean
										.getUI_M_DEP_BUS_DESC(), "N", "W", null);
						if (list6 != null && list6.isEmpty()) {
							depositBean.setUI_M_DEP_BUS_DESC(list6.get(0));
						}
					}

					resultSet = handler.executeSelectStatement(CURSOR_C12,
							connection, new Object[] { depositBean
									.getDEP_PROD_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_DEP_PROD_CODE_DESC(resultSet
								.getString(1));
					}
					CommonUtils.closeCursor(resultSet);

					resultSet = handler.executeSelectStatement(CURSOR_C13,
							connection, new Object[] { depositBean
									.getDEP_DS_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_DEP_DS_CODE_DESC(resultSet
								.getString(1));
					}
					CommonUtils.closeCursor(resultSet);

					resultSet = handler.executeSelectStatement(CURSOR_C14,
							connection, new Object[] { depositBean
									.getDEP_CUST_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_CUST_NAME(resultSet.getString(1));
					}
					CommonUtils.closeCursor(resultSet);

					resultSet = handler.executeSelectStatement(CURSOR_C15,
							connection, new Object[] { depositBean
									.getDEP_CONT_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_CONT_NAME(resultSet.getString(1));
					}
					CommonUtils.closeCursor(resultSet);

					//depositBean.setDEP_TYPE("P");
					ArrayList<OracleParameter> list7 = L_GROSS_PREM(
							M_POL_SYS_ID, CommonUtils.getControlBean()
									.getM_BASE_CURR(), depositBean
									.getDEP_PROD_CODE(), depositBean
									.getUI_M_POL_LC_GROSS_PREM(), depositBean
									.getUI_M_POL_LC_NET_PREM(), depositBean
									.getUI_M_POL_LC_COMMISSION(), null, null);
					if (list7 != null && !list7.isEmpty()) {
						depositBean.setUI_M_POL_LC_GROSS_PREM((Double) list7
								.get(0).getValueObject());
						
						/*ADDED BY RAJA ON 28-02-2017*/
						depositBean.setDEP_LC_TOT_AMT((Double) list7
								.get(0).getValueObject());
						/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037 */
						
						/*depositBean.setDEP_LC_AMT((Double) list7
								.get(3).getValueObject());
						*/
						/*End Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037 */
						
						/*Commeneted by Ram on 05-03-2017.Refer Falcon Source
						 * 
						 * depositBean.setDEP_LC_TOTAL_AMT((Double) list7
								.get(0).getValueObject());
						
						depositBean.setDEP_LC_DEP_AMT((Double) list7
								.get(0).getValueObject());*/
						/*END*/
						depositBean.setUI_M_POL_LC_NET_PREM((Double) list7.get(
								1).getValueObject());
						depositBean.setUI_M_POL_LC_COMMISSION((Double) list7
								.get(2).getValueObject());
					}
					/*depositBean.setDEP_LC_TOTAL_AMT(depositBean
							.getUI_M_POL_LC_GROSS_PREM());*/
					depositAction.getCOMP_UI_M_BUT_CONTRACTOR().setDisabled(
							true);
					depositAction.getCOMP_DEP_CLASS_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_PROD_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_DIVN_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_DEPT_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_PLAN_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_DS_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_SRC_OF_BUS().setDisabled(true);
					depositAction.getCOMP_DEP_AGENT_CODE().setDisabled(true);
					depositBean.setUI_M_POL_FLAG("N");
				} else {

					resultSet3 = handler.executeSelectStatement(CURSOR_C1,
							connection, new Object[] { depositBean
									.getDEP_REF_NO() });
					if (resultSet3.next()) {
						M_TEMP1 = resultSet3.getString(1);
					}
					CommonUtils.closeCursor(resultSet3);

					if ("X".equals(CommonUtils.nvl(M_TEMP1, "Y"))
							&& depositBean.getDEP_REF_NO() != null) {
						resultSet3 = handler.executeSelectStatement(CURSOR_C9,
								connection, new Object[] { depositBean
										.getDEP_REF_NO() });
						if (resultSet3.next()) {
							M_TEMP2 = resultSet3.getString(1);
						}
						CommonUtils.closeCursor(resultSet3);
						if ("X".equals(CommonUtils.nvl(M_TEMP2, "Y"))) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91335"));
						}
						resultSet4 = handler.executeSelectStatement(CURSOR_C2A,
								connection, new Object[] { depositBean
										.getDEP_REF_NO() });
						if (resultSet4.next()) {
							MAX_POL_END_NO_IDX = resultSet4.getString(1);
						}
						CommonUtils.closeCursor(resultSet4);

						resultSet3 = handler.executeSelectStatement(CURSOR_C10,
								connection, new Object[] {
										depositBean.getDEP_REF_NO(),
										MAX_POL_END_NO_IDX });
						if (resultSet3.next()) {
							depositBean.setDEP_CONT_CODE(resultSet3
									.getString(1));
							depositBean.setDEP_CUST_CODE(resultSet3
									.getString(2));
							depositBean.setUI_M_POL_LC_NET_PREM(resultSet3
									.getDouble(3));
							M_POL_SYS_ID = resultSet3.getLong(4);
							depositBean.setDEP_CLASS_CODE(resultSet3
									.getString(5));
							if(depositBean.getDEP_DS_CODE()==null)
							depositBean.setDEP_DS_CODE(resultSet3.getString(6));
							depositBean.setDEP_PROD_CODE(resultSet3
									.getString(7));
							depositBean.setDEP_PLAN_CODE(resultSet3
									.getString(8));
							M_POL_ADDL_STATUS = resultSet3.getString(9);
							depositBean.setDEP_CONT_REF_ID1(resultSet3
									.getString(10));
							depositBean.setDEP_CONT_REF_ID2(resultSet3
									.getString(11));
							depositBean.setDEP_SRC_OF_BUS(resultSet3
									.getString(12));
							//depositBean.setDEP_SYS_ID(M_POL_SYS_ID);
							M_POL_NET_PREM_YN = resultSet3.getString(13);
							M_POL_STATUS = resultSet3.getString(14);
							M_POL_MODE_OF_PYMT = resultSet3.getString(15);
						}

						if ("C".equals(M_POL_STATUS)) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "004"));
						}
						CommonUtils.closeCursor(resultSet3);
						CommonUtils.closeCursor(resultSet);

						resultSet = handler.executeSelectStatement(CURSOR_C7,
								connection, new Object[] { M_POL_SYS_ID });
						if (resultSet.next()) {
							M_AGENT_LEVEL = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);

						resultSet = handler.executeSelectStatement(CURSOR_C8,
								connection, new Object[] { M_POL_SYS_ID,
										M_AGENT_LEVEL });
						if (resultSet.next()) {
							M_AGENT_CODE = resultSet.getString(1);
							depositBean.setDEP_AGENT_CODE(M_AGENT_CODE);
							depositBean.setDEP_COLL_AGENT_CODE(M_AGENT_CODE);
							ArrayList<OracleParameter> list2 = new DBProcedures()
									.P_VAL_CLASS_CUST("IL_BROKER", depositBean
											.getDEP_AGENT_CODE(), depositBean
											.getUI_M_DEP_AGENT_CODE_DESC(),
											null, "N", null);
							if (list2 != null && !list2.isEmpty()) {
								depositBean
										.setUI_M_DEP_AGENT_CODE_DESC((String) list2
												.get(0).getValueObject());
							}
							ArrayList<OracleParameter> list3 = new DBProcedures()
									.P_VAL_CLASS_CUST(
											"IL_BROKER",
											depositBean
													.getDEP_COLL_AGENT_CODE(),
											depositBean
													.getUI_M_DEP_COLL_AGENT_CODE_DESC(),
											null, "N", null);
							if (list3 != null && !list3.isEmpty()) {
								depositBean
										.setUI_M_DEP_COLL_AGENT_CODE_DESC((String) list3
												.get(0).getValueObject());
							}
						} else {

							resultSet1 = handler
									.executeSelectStatement(CURSOR_C17,
											connection,
											new Object[] { depositBean
													.getDEP_REF_NO() });
							if (resultSet1.next()) {
								M_AGENT_CODE = resultSet1.getString(1);
							}
							depositBean.setDEP_AGENT_CODE(M_AGENT_CODE);
							depositBean.setDEP_COLL_AGENT_CODE(M_AGENT_CODE);
							ArrayList<OracleParameter> list2 = new DBProcedures()
									.P_VAL_CLASS_CUST("IL_BROKER", depositBean
											.getDEP_AGENT_CODE(), depositBean
											.getUI_M_DEP_AGENT_CODE_DESC(),
											null, "N", null);
							if (list2 != null && !list2.isEmpty()) {
								depositBean
										.setUI_M_DEP_AGENT_CODE_DESC((String) list2
												.get(0).getValueObject());
							}
							ArrayList<OracleParameter> list3 = new DBProcedures()
									.P_VAL_CLASS_CUST(
											"IL_BROKER",
											depositBean
													.getDEP_COLL_AGENT_CODE(),
											depositBean
													.getUI_M_DEP_COLL_AGENT_CODE_DESC(),
											null, "N", null);
							if (list3 != null && !list3.isEmpty()) {
								depositBean
										.setUI_M_DEP_COLL_AGENT_CODE_DESC((String) list3
												.get(0).getValueObject());
							}
						}

						ArrayList<String> list4 = new DBProcedures()
								.P_VAL_CLASS(depositBean.getDEP_CLASS_CODE(),
										"N", "N");
						if (list4 != null && !list4.isEmpty()) {
							depositBean.setUI_M_DEP_CLASS_CODE_DESC(list4
									.get(0));
						}
						String list5 = new DBProcedures().P_VAL_PLAN(
								depositBean.getDEP_PLAN_CODE(), "N", "N");
						if (list5 != null && !list5.isEmpty()) {
							depositBean.setUI_M_DEP_PLAN_CODE_DESC(list5);
						}

						if (depositBean.getDEP_SRC_OF_BUS() != null) {
							ArrayList<String> list6 = new DBProcedures()
									.P_VAL_CODES("SRC_BUS_TY", depositBean
											.getDEP_SRC_OF_BUS(), depositBean
											.getUI_M_DEP_BUS_DESC(), "N", "W",
											null);
							if (list6 != null && list6.isEmpty()) {
								depositBean.setUI_M_DEP_BUS_DESC(list6.get(0));
							}
						}

						resultSet = handler.executeSelectStatement(CURSOR_C12,
								connection, new Object[] { depositBean
										.getDEP_PROD_CODE() });
						if (resultSet.next()) {
							depositBean.setUI_M_DEP_PROD_CODE_DESC(resultSet
									.getString(1));
						}
						CommonUtils.closeCursor(resultSet);

						resultSet = handler.executeSelectStatement(CURSOR_C13,
								connection, new Object[] { depositBean
										.getDEP_DS_CODE() });
						if (resultSet.next()) {
							depositBean.setUI_M_DEP_DS_CODE_DESC(resultSet
									.getString(1));
						}
						CommonUtils.closeCursor(resultSet);

						resultSet = handler.executeSelectStatement(CURSOR_C14,
								connection, new Object[] { depositBean
										.getDEP_CUST_CODE() });
						if (resultSet.next()) {
							depositBean.setUI_M_CUST_NAME(resultSet
									.getString(1));
						}
						CommonUtils.closeCursor(resultSet);

						resultSet = handler.executeSelectStatement(CURSOR_C15,
								connection, new Object[] { depositBean
										.getDEP_CONT_CODE() });
						if (resultSet.next()) {
							depositBean.setUI_M_CONT_NAME(resultSet
									.getString(1));
						}
						CommonUtils.closeCursor(resultSet);

						depositBean.setDEP_TYPE("Q");

						ArrayList<OracleParameter> list7 = L_GROSS_PREM(
								M_POL_SYS_ID, CommonUtils.getControlBean()
										.getM_BASE_CURR(), depositBean
										.getDEP_PROD_CODE(), depositBean
										.getUI_M_POL_LC_GROSS_PREM(),
								depositBean.getUI_M_POL_LC_NET_PREM(),
								depositBean.getUI_M_POL_LC_COMMISSION(), null, null);
						if (list7 != null && !list7.isEmpty()) {
							depositBean
									.setUI_M_POL_LC_GROSS_PREM((Double) list7
											.get(0).getValueObject());
							
							/*added by raja on 28-02-2017 */
							
							depositBean.setDEP_LC_TOT_AMT((Double) list7
									.get(0).getValueObject());
							
							/*Commeneted by Ram on 05-03-2017.Refer Falcon Source
							 * 
							 * depositBean.setDEP_LC_TOTAL_AMT((Double) list7
									.get(0).getValueObject());
							
							depositBean.setDEP_LC_DEP_AMT((Double) list7
									.get(0).getValueObject());*/
							
							/*end*/
							depositBean.setUI_M_POL_LC_NET_PREM((Double) list7
									.get(1).getValueObject());
							depositBean
									.setUI_M_POL_LC_COMMISSION((Double) list7
											.get(2).getValueObject());
							//added by Mani on 18July2024 advised by KK Alliance Life
							depositBean.setDEP_LC_DEP_AMT(Double.parseDouble(list7
									.get(5).getValueObject().toString())); 
						}

						/*depositBean.setDEP_LC_TOTAL_AMT(depositBean
								.getUI_M_POL_LC_GROSS_PREM());*/
						depositAction.getCOMP_UI_M_BUT_CONTRACTOR()
								.setDisabled(true);
						depositAction.getCOMP_DEP_CLASS_CODE()
								.setDisabled(true);
						depositAction.getCOMP_DEP_PROD_CODE().setDisabled(true);
						depositAction.getCOMP_DEP_DIVN_CODE().setDisabled(true);
						depositAction.getCOMP_DEP_DEPT_CODE().setDisabled(true);
						depositAction.getCOMP_DEP_PLAN_CODE().setDisabled(true);
						depositAction.getCOMP_DEP_DS_CODE().setDisabled(true);
						depositAction.getCOMP_DEP_SRC_OF_BUS()
								.setDisabled(true);
						depositAction.getCOMP_DEP_AGENT_CODE()
								.setDisabled(true);
					} else {
						if (!("Not approved".equals(depositBean
								.getUI_M_APPRV_STATUS()))) {
							if (depositBean.getDEP_REF_NO() != null
									|| (depositBean.getDEP_CONT_REF_ID1() == null && depositBean
											.getDEP_CONT_REF_ID2() == null)) {
								throw new Exception(Messages.getString(
										PELConstants.pelErrorMessagePath,
										"91169"));
							} else {

								resultSet4 = handler
										.executeSelectStatement(CURSOR_C11,
												connection, new Object[] {});
								if (resultSet4.next()) {
									depositBean.setDEP_CUST_CODE(resultSet4
											.getString(1));
								} else {
									depositBean
											.setDEP_CUST_CODE((String) CommonUtils
													.getGlobalObject("GLOBAL.M_PARAM_11"));
								}
								CommonUtils.closeCursor(resultSet4);

								depositAction.getCOMP_DEP_CONT_CODE()
										.setRequired(false);
								depositAction.getCOMP_DEP_CLASS_CODE()
										.setDisabled(false);
								depositAction.getCOMP_DEP_PROD_CODE()
										.setDisabled(false);
								depositAction.getCOMP_DEP_PLAN_CODE()
										.setDisabled(false);
								depositAction.getCOMP_DEP_DS_CODE()
										.setDisabled(false);
								depositAction.getCOMP_DEP_AGENT_CODE()
										.setDisabled(false);
								depositAction.getCOMP_DEP_SRC_OF_BUS()
										.setDisabled(false);
							}
						}
						depositBean.setUI_M_POL_FLAG("Y");
					}
				}
			} else if ("P".equals(CommonUtils.nvl(depositBean.getDEP_TYPE(),
					"Q")) || "S".equals(CommonUtils.nvl(depositBean.getDEP_TYPE(),
							"Q"))) {

				depositBean.setUI_M_POL_FLAG("N");

				CommonUtils.closeCursor(resultSet);

				resultSet = handler.executeSelectStatement(CURSOR_C3,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet.next()) {
					M_TEMP = resultSet.getString(1);
				}

				if ("X".equals(CommonUtils.nvl(M_TEMP, "Y"))) {

					CommonUtils.closeCursor(resultSet);
					resultSet = handler.executeSelectStatement(CURSOR_C6,
							connection, new Object[] { depositBean
									.getDEP_REF_NO() });
					if (resultSet.next()) {

						depositBean.setDEP_CONT_CODE(resultSet.getString(1));
						depositBean.setDEP_CUST_CODE(resultSet.getString(2));
						depositBean.setUI_M_POL_LC_NET_PREM(resultSet
								.getDouble(3));
						M_POL_SYS_ID = resultSet.getLong(4);
						depositBean.setDEP_CLASS_CODE(resultSet.getString(5));
						if(depositBean.getDEP_DS_CODE()==null)
						depositBean.setDEP_DS_CODE(resultSet.getString(6));
						depositBean.setDEP_PROD_CODE(resultSet.getString(7));
						depositBean.setDEP_PLAN_CODE(resultSet.getString(8));
						M_POL_ADDL_STATUS = resultSet.getString(9);
						depositBean
								.setDEP_CONT_REF_ID1(resultSet.getString(10));
						depositBean
								.setDEP_CONT_REF_ID2(resultSet.getString(11));
						depositBean.setDEP_SRC_OF_BUS(resultSet.getString(12));
						//depositBean.setDEP_SYS_ID(M_POL_SYS_ID);
						M_POL_NET_PREM_YN = resultSet.getString(13);
						M_POL_MODE_OF_PYMT = resultSet.getString(14);
					}
					if(!"S".equalsIgnoreCase(depositBean.getDEP_TYPE()))
					{

					ArrayList<OracleParameter> list7 = L_GROSS_PREM(
							M_POL_SYS_ID, CommonUtils.getControlBean()
									.getM_BASE_CURR(), depositBean
									.getDEP_PROD_CODE(), depositBean
									.getUI_M_POL_LC_GROSS_PREM(), depositBean
									.getUI_M_POL_LC_NET_PREM(), depositBean
									.getUI_M_POL_LC_COMMISSION(), null, null);
					if (list7 != null && !list7.isEmpty()) {
						depositBean.setUI_M_POL_LC_GROSS_PREM((Double) list7
								.get(0).getValueObject());
						
						/*added by raja on 28-02-2017 */
						
						depositBean.setDEP_LC_TOT_AMT((Double) list7
								.get(0).getValueObject());
						/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
						/*depositBean.setDEP_LC_AMT((Double) list7
								.get(3).getValueObject());*/
						/*End Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
						/*Commeneted by Ram on 05-03-2017.Refer Falcon Source
						 * 
						 * depositBean.setDEP_LC_TOTAL_AMT((Double) list7
								.get(0).getValueObject());
						
						depositBean.setDEP_LC_DEP_AMT((Double) list7
								.get(0).getValueObject());*/
						/*end*/
						depositBean.setUI_M_POL_LC_NET_PREM((Double) list7.get(
								1).getValueObject());
						depositBean.setUI_M_POL_LC_COMMISSION((Double) list7
								.get(2).getValueObject());
						
						//added by Mani on 18July2024 advised by KK Alliance Life
						depositBean.setDEP_LC_DEP_AMT(Double.parseDouble(list7
								.get(5).getValueObject().toString())); 
					}
					}
					/*depositBean.setDEP_LC_TOTAL_AMT(depositBean
							.getUI_M_POL_LC_GROSS_PREM());*/

					resultSet = handler.executeSelectStatement(CURSOR_C7,
							connection, new Object[] { M_POL_SYS_ID });
					if (resultSet.next()) {
						M_AGENT_LEVEL = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);

					resultSet = handler.executeSelectStatement(CURSOR_C8,
							connection, new Object[] { M_POL_SYS_ID,
									M_AGENT_LEVEL });
					if (resultSet.next()) {
						M_AGENT_CODE = resultSet.getString(1);
						depositBean.setDEP_AGENT_CODE(M_AGENT_CODE);
						depositBean.setDEP_COLL_AGENT_CODE(M_AGENT_CODE);

						CommonUtils.closeCursor(resultSet);
						ArrayList<OracleParameter> list2 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_AGENT_CODE(), depositBean
										.getUI_M_DEP_AGENT_CODE_DESC(), null,
										"N", null);
						if (list2 != null && !list2.isEmpty()) {
							depositBean
									.setUI_M_DEP_AGENT_CODE_DESC((String) list2
											.get(0).getValueObject());
						}
						ArrayList<OracleParameter> list3 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_COLL_AGENT_CODE(), depositBean
										.getUI_M_DEP_COLL_AGENT_CODE_DESC(),
										null, "N", null);
						if (list3 != null && !list3.isEmpty()) {
							depositBean
									.setUI_M_DEP_COLL_AGENT_CODE_DESC((String) list3
											.get(0).getValueObject());
						}

					} else {

						resultSet1 = handler.executeSelectStatement(CURSOR_C17,
								connection, new Object[] { depositBean
										.getDEP_REF_NO() });
						if (resultSet1.next()) {
							M_AGENT_CODE = resultSet1.getString(1);
						}
						depositBean.setDEP_AGENT_CODE(M_AGENT_CODE);
						depositBean.setDEP_COLL_AGENT_CODE(M_AGENT_CODE);
						ArrayList<OracleParameter> list2 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_AGENT_CODE(), depositBean
										.getUI_M_DEP_AGENT_CODE_DESC(), null,
										"N", null);

						if (list2 != null && !list2.isEmpty()) {
							depositBean
									.setUI_M_DEP_AGENT_CODE_DESC((String) list2
											.get(0).getValueObject());
						}

						ArrayList<OracleParameter> list3 = new DBProcedures()
								.P_VAL_CLASS_CUST("IL_BROKER", depositBean
										.getDEP_COLL_AGENT_CODE(), depositBean
										.getUI_M_DEP_COLL_AGENT_CODE_DESC(),
										null, "N", null);
						if (list3 != null && !list3.isEmpty()) {
							depositBean
									.setUI_M_DEP_COLL_AGENT_CODE_DESC((String) list3
											.get(0).getValueObject());
						}
					}

					ArrayList<String> list4 = new DBProcedures().P_VAL_CLASS(
							depositBean.getDEP_CLASS_CODE(), "N", "N");
					if (list4 != null && !list4.isEmpty()) {
						depositBean.setUI_M_DEP_CLASS_CODE_DESC(list4.get(0));
					}
					String list5 = new DBProcedures().P_VAL_PLAN(depositBean
							.getDEP_PLAN_CODE(), "N", "N");
					if (list5 != null && !list5.isEmpty()) {
						depositBean.setUI_M_DEP_PLAN_CODE_DESC(list5);
					}
					/*if (depositBean.getDEP_SRC_OF_BUS() != null) {
						ArrayList<String> list6 = new DBProcedures()
								.P_VAL_CODES("SRC_BUS_TY", depositBean
										.getDEP_SRC_OF_BUS(), depositBean
										.getUI_M_DEP_BUS_DESC(), "N", "W", null);
						if (list6 != null && list6.isEmpty()) {
							depositBean.setUI_M_DEP_BUS_DESC(list6.get(0));
						}
					}*/
					resultSet = handler.executeSelectStatement(CURSOR_C12,
							connection, new Object[] { depositBean
									.getDEP_PROD_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_DEP_PROD_CODE_DESC(resultSet
								.getString(1));
					}
					CommonUtils.closeCursor(resultSet);
					resultSet = handler.executeSelectStatement(CURSOR_C13,
							connection, new Object[] { depositBean
									.getDEP_DS_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_DEP_DS_CODE_DESC(resultSet
								.getString(1));
					}
					CommonUtils.closeCursor(resultSet);
					resultSet = handler.executeSelectStatement(CURSOR_C14,
							connection, new Object[] { depositBean
									.getDEP_CUST_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_CUST_NAME(resultSet.getString(1));
					}
					CommonUtils.closeCursor(resultSet);
					resultSet = handler.executeSelectStatement(CURSOR_C15,
							connection, new Object[] { depositBean
									.getDEP_CONT_CODE() });
					if (resultSet.next()) {
						depositBean.setUI_M_CONT_NAME(resultSet.getString(1));
					}
					CommonUtils.closeCursor(resultSet);
					/*depositBean.setDEP_LC_TOTAL_AMT(depositBean
							.getUI_M_POL_LC_GROSS_PREM());*/
					depositAction.getCOMP_UI_M_BUT_CONTRACTOR().setDisabled(
							true);
					depositAction.getCOMP_DEP_CLASS_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_PROD_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_DIVN_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_DEPT_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_PLAN_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_DS_CODE().setDisabled(true);
					depositAction.getCOMP_DEP_SRC_OF_BUS().setDisabled(true);
					depositAction.getCOMP_DEP_AGENT_CODE().setDisabled(true);

				} else {
					if (!("Not approved".equals(depositBean
							.getUI_M_APPRV_STATUS()))) {
						if (depositBean.getDEP_REF_NO() != null
								|| (depositBean.getDEP_CONT_REF_ID1() == null && depositBean
										.getDEP_CONT_REF_ID2() == null)) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91169"));
						} else {

							resultSet4 = handler.executeSelectStatement(
									CURSOR_C11, connection,
									new Object[] { depositBean
											.getDEP_CONT_REF_ID1() });
							if (resultSet4.next()) {
								depositBean.setDEP_CUST_CODE(resultSet4
										.getString(1));
							} else {
								depositBean
										.setDEP_CUST_CODE((String) CommonUtils
												.getGlobalObject("GLOBAL.M_PARAM_11"));
							}
							CommonUtils.closeCursor(resultSet4);
							depositAction.getCOMP_DEP_CONT_CODE().setRequired(
									false);
						}
					}
				}

				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C16,
						connection, new Object[] { depositBean
								.getDEP_PLAN_CODE() });
				if (resultSet.next()) {
					M_PLAN_TYPE = resultSet.getString(1);
				}

				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C20,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet.next()) {
					M_POL_PREM_PAY_YRS = resultSet.getInt(1);
					M_PROD_AGENT_HIRE_YN = resultSet.getString(2);
				}

				//Commented by Akash to make normal flow(Calc_method 2 ) to work dated 03-feb-2013 
				
				if (/*"1".equals(dummy.getUI_M_CALC_METHOD())
						&& */"N".equals(M_PROD_AGENT_HIRE_YN)) {
					depositBean.setUI_M_DEP_GROSS_NET_FLAG(null);
					M_PROP_FLAG = null;
					CommonUtils.closeCursor(resultSet);
					resultSet = handler.executeSelectStatement(CURSOR_C21,
							connection, new Object[] { depositBean
									.getDEP_REF_NO() });
					if (resultSet.next()) {
						M_POL_PROP_NO = resultSet.getString(1);
					}
					CommonUtils.closeCursor(resultSet);
					if (M_POL_PROP_NO != null) {
						resultSet = handler.executeSelectStatement(CURSOR_C22,
								connection, new Object[] { M_POL_PROP_NO });
						if (resultSet.next()) {
							M_PROP_FLAG = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);
						if (M_PROP_FLAG == null) {
							resultSet = handler
									.executeSelectStatement(CURSOR_C22,
											connection,
											new Object[] { depositBean
													.getDEP_REF_NO() });
							if (resultSet.next()) {
								M_PROP_FLAG = resultSet.getString(1);
							}
							CommonUtils.closeCursor(resultSet);
						}
						depositBean.setUI_M_DEP_GROSS_NET_FLAG(M_PROP_FLAG);
					} else {
						resultSet = handler.executeSelectStatement(CURSOR_C5,
								connection, new Object[] { depositBean
										.getDEP_REF_NO() });
						if (resultSet.next()) {
							M_DUMMY = resultSet.getString(1);
						}
						CommonUtils.closeCursor(resultSet);
						if ("X".equals(CommonUtils.nvl(M_DUMMY, "Y"))) {
							resultSet = handler
									.executeSelectStatement(CURSOR_C22,
											connection,
											new Object[] { depositBean
													.getDEP_REF_NO() });
							if (resultSet.next()) {
								M_PROP_FLAG = resultSet.getString(1);
							}
							CommonUtils.closeCursor(resultSet);
							depositBean.setUI_M_DEP_GROSS_NET_FLAG(M_PROP_FLAG);
						}
					}
					if (M_DEP_GROSS_NET_FLAG != null) {
						depositBean.setDEP_GROSS_NET_FLAG(M_DEP_GROSS_NET_FLAG);
						depositAction.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(
								true);
					} else {
						depositBean.setDEP_GROSS_NET_FLAG("G");
						depositAction.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(
								false);
					}

					if ("G".equals(depositBean.getDEP_GROSS_NET_FLAG())) {
						depositBean.setUI_M_POL_LC_COMMISSION(depositBean
								.getUI_M_POL_LC_GROSS_PREM()
								- depositBean.getUI_M_POL_LC_NET_PREM());
						depositAction.getCOMP_UI_M_POL_LC_GROSS_PREM()
								.setRendered(true);
						depositAction.getCOMP_UI_M_POL_LC_NET_PREM()
								.setRendered(false);
						/*depositBean.setDEP_LC_TOTAL_AMT(depositBean
								.getUI_M_POL_LC_GROSS_PREM());*/
					} else if ("N".equals(depositBean.getDEP_GROSS_NET_FLAG())) {
						depositBean.setUI_M_POL_LC_COMMISSION(depositBean
								.getUI_M_POL_LC_GROSS_PREM()
								- depositBean.getUI_M_POL_LC_NET_PREM());
						depositAction.getCOMP_UI_M_POL_LC_GROSS_PREM()
								.setRendered(false);
						depositAction.getCOMP_UI_M_POL_LC_NET_PREM()
								.setRendered(true);
						/*depositBean.setDEP_LC_TOTAL_AMT(depositBean
								.getUI_M_POL_LC_NET_PREM());*/
					}
				} else {
					depositAction.getCOMP_DEP_GROSS_NET_FLAG()
							.setDisabled(true);
				}

				ArrayList<String> list11 = new DBProcedures().P_VAL_SYSTEM(
						"IL_ADDL_STAT", M_POL_ADDL_STATUS, M_CODE_DESCRIPTION,
						"N", CommonUtils.getProcedureValue(M_TEMP_VAL));
				if (list11 != null && !list11.isEmpty()) {
					M_CODE_DESCRIPTION = list11.get(0);
				}
				if ("1".equals(dummy.getUI_M_CALC_METHOD())) {
					depositBean.setUI_M_POL_STATUS(M_POL_ADDL_STATUS + " "
							+ " : " + " " + M_CODE_DESCRIPTION);
				}
				resultSet = handler.executeSelectStatement(CURSOR_C18,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet.next()) {
					M_TEMP3 = resultSet.getString(1);
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71153"));
				}
				CommonUtils.closeCursor(resultSet);
				resultSet = handler.executeSelectStatement(CURSOR_C19,
						connection, new Object[] { depositBean.getDEP_REF_NO(),
								depositBean.getDEP_REF_NO() });
				if (resultSet.next()) {
					M_POL_MODE_OF_PYMT_1 = resultSet.getString(1);
				}
				CommonUtils.closeCursor(resultSet);

				if ("S".equals(M_POL_MODE_OF_PYMT_1)) {
					depositAction.getCOMP_UI_M_POL_LC_COMMISSION().setRendered(
							true);
				} else {
					depositAction.getCOMP_UI_M_POL_LC_COMMISSION().setRendered(
							false);
				}

			}
			
			/*aded by raja on 03-07-2017 to discuss with govrav and grish*/
			String cust_code=null;
			String query="select pol_cust_code from pt_il_policy where pol_no=?";
			ResultSet rs=new CRUDHandler().executeSelectStatement(query, connection, new Object[]{depositBean.getDEP_REF_NO()});
			while(rs.next())
			{
				cust_code=rs.getString("pol_cust_code");
			}
			if(cust_code!=null && cust_code.equalsIgnoreCase(depositBean.getDEP_REF_NO()))
			{
				depositAction.getCOMP_DEP_PROD_CODE_LABEL().setStyle("display:none");
				depositAction.getCOMP_DEP_PROD_CODE().setStyle("display:none");
				depositAction.getCOMP_UI_M_DEP_PROD_CODE_DESC().setStyle("display:none");
				depositAction.getCOMP_DEP_PLAN_CODE_LABEL().setStyle("display:none");
				depositAction.getCOMP_DEP_PLAN_CODE().setStyle("display:none");
				depositAction.getCOMP_UI_M_DEP_PLAN_CODE_DESC().setStyle("display:none");
				depositAction.getCOMP_DEP_DS_CODE_LABEL().setStyle("display:none");
				depositAction.getCOMP_DEP_DS_CODE().setStyle("display:none");
				depositAction.getCOMP_UI_M_DEP_DS_CODE_DESC().setStyle("display:none");
							
			}
			else
			{
				depositAction.getCOMP_DEP_PROD_CODE_LABEL().setStyle("display:block");
				depositAction.getCOMP_DEP_PROD_CODE().setStyle("display:block");
				depositAction.getCOMP_UI_M_DEP_PROD_CODE_DESC().setStyle("display:block");
				depositAction.getCOMP_DEP_PLAN_CODE_LABEL().setStyle("display:block");
				depositAction.getCOMP_DEP_PLAN_CODE().setStyle("display:block");
				depositAction.getCOMP_UI_M_DEP_PLAN_CODE_DESC().setStyle("display:block");
				depositAction.getCOMP_DEP_DS_CODE_LABEL().setStyle("display:block");
				depositAction.getCOMP_DEP_DS_CODE().setStyle("display:block");
				depositAction.getCOMP_UI_M_DEP_DS_CODE_DESC().setStyle("display:block");
			}
				
				
				/*end*/
			
			/*Added by saritha on 11-10-2017 for Premium Collection Issues*/
			value1 = new Object[]{depositBean.getDEP_REF_NO()};
			resultSet7 = handler.executeSelectStatement(CURSOR_C23, connection, value1);
			if(resultSet7.next()){
				check_value = resultSet7.getString(1);
				depositAction.getCOMP_DEP_COMM_YN().setRequired(true);
				depositAction.getCOMP_DEP_COMM_YN().setDisabled(false);
				
			}
			
			else {
				
				depositAction.getCOMP_DEP_COMM_YN().setRequired(false);
				depositAction.getCOMP_DEP_COMM_YN().setDisabled(true);
			}
			
			/*End*/
			//Added by rakesh on 07-03-2020 for currency code default from policy issue
			if(CommonUtils.nvl(depositBean.getDEP_CURR_CODE(),"X").equalsIgnoreCase("X"))
			{
				rsC24 = new CRUDHandler().executeSelectStatement(CURSOR_C24, connection, new Object[]{depositBean.getDEP_REF_NO()});
				if(rsC24.next())
				{
					depositBean.setDEP_CURR_CODE(rsC24.getString(1));
				}
				if(depositBean.getDEP_CURR_CODE() != null)
				{
					DBProcedures procedures = new DBProcedures();
	
					List<String> currList = procedures.P_VAL_CURR(depositBean
							.getDEP_CURR_CODE(), "N", "N", depositBean
							.getDEP_CUST_CODE());
					if (currList != null && !currList.isEmpty()) {
						depositBean.setUI_M_DEP_CURR_DESC(currList.get(0));
					}
			}
			}
			
			//END
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		/* Added by Shahbaz khan 12/03/2020 for Close the result Set */
		finally {
					try {
						CommonUtils.closeCursor(rsC24);
						CommonUtils.closeCursor(resultSet);
						CommonUtils.closeCursor(resultSet2);
						CommonUtils.closeCursor(resultSet3);
						CommonUtils.closeCursor(resultSet4);
						CommonUtils.closeCursor(resultSet5);
						CommonUtils.closeCursor(resultSet6);
						CommonUtils.closeCursor(resultSet7);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
	}

	public void validateDep_Gross_Net_Flag(PT_IL_DEPOSIT_ACTION depositAction)
			throws Exception {
		PT_IL_DEPOSIT depositBean = depositAction.getPT_IL_DEPOSIT_BEAN();
		ArrayList<OracleParameter> list = null;
		try {
			if ("G".equalsIgnoreCase(depositBean.getDEP_GROSS_NET_FLAG())) {
				if (depositBean.getUI_M_POL_LC_GROSS_PREM() != null
						&& depositBean.getUI_M_POL_LC_NET_PREM() != null) {
					depositBean.setUI_M_POL_LC_COMMISSION(depositBean
							.getUI_M_POL_LC_GROSS_PREM()
							- depositBean.getUI_M_POL_LC_NET_PREM());
				}
				depositAction.getCOMP_UI_M_POL_LC_GROSS_PREM()
						.setRendered(true);
				depositAction.getCOMP_UI_M_POL_LC_NET_PREM().setRendered(false);
				depositBean.setDEP_LC_TOTAL_AMT(CommonUtils.nvl(depositBean
						.getDEP_LC_TOTAL_AMT(), depositBean
						.getUI_M_POL_LC_GROSS_PREM()));
			} else if ("N"
					.equalsIgnoreCase(depositBean.getDEP_GROSS_NET_FLAG())) {
				if (depositBean.getUI_M_POL_LC_GROSS_PREM() != null
						&& depositBean.getUI_M_POL_LC_NET_PREM() != null) {
					depositBean.setUI_M_POL_LC_COMMISSION(depositBean
							.getUI_M_POL_LC_GROSS_PREM()
							- depositBean.getUI_M_POL_LC_NET_PREM());
				}

				depositBean.setDEP_LC_TOTAL_AMT(CommonUtils.nvl(depositBean
						.getDEP_LC_TOTAL_AMT(), depositBean
						.getUI_M_POL_LC_GROSS_PREM()));
				depositAction.getCOMP_UI_M_POL_LC_NET_PREM().setRendered(true);
				depositAction.getCOMP_UI_M_POL_LC_GROSS_PREM().setRendered(
						false);
			}

			list = new P9ILPK_POL_APPROVAL()
					.ROUND_COMM_AMT(depositBean.getDEP_PROD_CODE(), CommonUtils
							.getControlBean().getM_BASE_CURR(), CommonUtils
							.getProcedureValue(depositBean
									.getUI_M_POL_LC_COMMISSION()));
			if (list != null && !list.isEmpty()) {
				depositBean.setUI_M_POL_LC_COMMISSION((Double) list.get(0)
						.getValueObject());
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateDEP_TEMP_RCPT_NO(PT_IL_DEPOSIT depositBean)
			throws Exception {

		String CURSOR_C1 = "SELECT ROWID FROM PT_IL_DEPOSIT  WHERE DEP_TEMP_RCPT_NO = ? ";
		String CURSOR_C2 = "SELECT ROWID FROM PT_IL_PREM_COLL WHERE PC_TEMP_RCPT_NO = ?  ";
		String M_C1FOUND = null;
		String M_C2FOUND = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;

		Connection connection;
		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { depositBean.getDEP_TEMP_RCPT_NO() });
			if (resultSet.next()) {
				M_C1FOUND = resultSet.getString(1);
			}
			resultSet2 = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { depositBean.getDEP_TEMP_RCPT_NO() });
			if (resultSet2.next()) {
				M_C2FOUND = resultSet2.getString(1);
			}

			if ((CommonUtils.isDuplicate(depositBean.getROWID(), M_C1FOUND)) || (CommonUtils.isDuplicate(depositBean.getROWID(), M_C2FOUND))) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91267"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet2);
		}
	}

	public void validateDEP_CUST_CODE(PT_IL_DEPOSIT depositBean)
			throws Exception {

		String M_CUST_SRC_BUS = null;
		String M_CCLAS_TYPE = null;
		Date M_CUST_EFF_TO_DT = null;
		Date M_CUST_EFF_FM_DT = null;
		String M_NAME = null;
		String M_CUST_APPL_ALL_BRAN_YN = null;
		StringBuffer buffer = new StringBuffer();
		String M_CDIV_CUST_CODE = null;
		String CURSOR_C1AB = "SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN WHERE CDIV_DIVN_CODE = ? ";
		String CURSOR_C1 = "SELECT CUST_NAME ,CUST_SRC_BUS,CCLAS_TYPE,CUST_EFF_FM_DT,CUST_EFF_TO_DT FROM   PM_CUSTOMER,PM_CUST_CLASS"
				+ "  WHERE  CUST_CODE =  ? AND CUST_CLASS = CCLAS_CODE  AND CUST_FRZ_FLAG = 'N' AND CUST_CODE IN (?)";
		String CURSOR_C2 = "SELECT CUST_APPL_ALL_BRAN_YN FROM PM_CUSTOMER WHERE CUST_CODE = ? ";
		String CURSOR_C1A = "SELECT CUST_NAME ,CUST_SRC_BUS,CCLAS_TYPE,CUST_EFF_FM_DT,CUST_EFF_TO_DT "
				+ "FROM   PM_CUSTOMER,PM_CUST_CLASS WHERE  CUST_CODE = ?  AND CUST_CLASS = CCLAS_CODE  AND CUST_FRZ_FLAG = 'N'";

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet1 = null;
		ResultSet CURSOR_C1AB_RS = null;
		Connection connection;
		try {
			connection = CommonUtils.getConnection();

			localprocedure.L_VALIDATE_POLICY(depositBean.getDEP_CUST_CODE(),
					"C", depositBean.getDEP_REF_NO());
			resultSet = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { depositBean.getDEP_CUST_CODE() });
			if (resultSet.next()) {
				M_CUST_APPL_ALL_BRAN_YN = resultSet.getString(1);
			}
			CURSOR_C1AB_RS = handler.executeSelectStatement(CURSOR_C1AB,
					connection, new Object[] { CommonUtils.getControlBean()
							.getM_DIVN_CODE() });
			if (CURSOR_C1AB_RS.next()) {
				M_CDIV_CUST_CODE = CURSOR_C1AB_RS.getString(1);
			}
			resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { depositBean.getDEP_CUST_CODE() });
			if (resultSet1.next()) {
				M_CUST_APPL_ALL_BRAN_YN = resultSet.getString(1);
			}

			if ("N".equalsIgnoreCase(M_CUST_APPL_ALL_BRAN_YN)) {
				resultSet2 = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
								depositBean.getDEP_CUST_CODE(),
								M_CDIV_CUST_CODE });
				if (resultSet2.next()) {
					M_NAME = resultSet2.getString(1);
					M_CUST_SRC_BUS = resultSet2.getString(2);
					M_CCLAS_TYPE = resultSet2.getString(3);
					M_CUST_EFF_FM_DT = resultSet2.getDate(4);
					M_CUST_EFF_TO_DT = resultSet2.getDate(5);
					if (depositBean.getDEP_CUST_CODE() != null
							&& !("002".equals(CommonUtils.nvl(M_CCLAS_TYPE,
									"000")))) {
						if (new CommonUtils().getCurrentDate().after(
								CommonUtils.nvl(M_CUST_EFF_FM_DT, new Date(
										"01-JAN-1900")))
								&& new CommonUtils().getCurrentDate().before(
										CommonUtils.nvl(M_CUST_EFF_TO_DT,
												new Date("31-DEC-2999")))) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91005"));
						}
					}
				} else {
					// throw new
					// Exception(Messages.getString(PELConstants.pelErrorMessagePath,
					// "91005"));
				}
				depositBean.setUI_M_CUST_NAME(M_NAME);
				if (depositBean.getDEP_REF_NO() == null) {
					depositBean.setDEP_SRC_OF_BUS(M_CUST_SRC_BUS);
				}

			} else if ("Y".equals(M_CUST_APPL_ALL_BRAN_YN)) {
				resultSet2 = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] {
								depositBean.getDEP_CUST_CODE(),
								M_CDIV_CUST_CODE });
				if (resultSet2.next()) {
					M_NAME = resultSet2.getString(1);
					M_CUST_SRC_BUS = resultSet2.getString(2);
					M_CCLAS_TYPE = resultSet2.getString(3);
					M_CUST_EFF_FM_DT = resultSet2.getDate(4);
					M_CUST_EFF_TO_DT = resultSet2.getDate(5);
					if (depositBean.getDEP_CUST_CODE() != null
							&& !("002".equals(CommonUtils.nvl(M_CCLAS_TYPE,
									"000")))) {
						if (new CommonUtils().getCurrentDate().after(
								CommonUtils.nvl(M_CUST_EFF_FM_DT, new Date(
										"01-JAN-1900")))
								&& new CommonUtils().getCurrentDate().before(
										CommonUtils.nvl(M_CUST_EFF_TO_DT,
												new Date("31-DEC-2999")))) {
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91005"));
						}
					}
				} else {
					// throw new
					// Exception(Messages.getString(PELConstants.pelErrorMessagePath,
					// "91005"));
				}
				//depositBean.setUI_M_CUST_NAME(M_NAME);
				if (depositBean.getDEP_REF_NO() == null) {
					depositBean.setDEP_SRC_OF_BUS(M_CUST_SRC_BUS);
				}

			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void validateDEP_CONT_CODE(PT_IL_DEPOSIT_ACTION depositAction)
			throws Exception {

		String M_POL_SRC_OF_BUS = null;
		String M_DUMMY_SRC = null;
		String M_POL_STAFF_YN = null;
		String M_DS_BROKER_YN = null;
		String M_CONT_CODE = null;
		String M_NAME = null;
		String M_DUMMY_X = null;
		String MAX_POL_END_NO_IDX = null;
		String M_PROD_DS_CODE = null;
		String CURSOR_C1 = "SELECT CONT_NAME FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE = ? ";
		String CURSOR_C2A = "SELECT MAX(POL_END_NO_IDX) FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
		/*
		 * modified by Ameen on 15-05-2018 for KIC as per Ajay sugg.
		 * String CURSOR_C2 = "SELECT POL_CONT_CODE, POL_SRC_OF_BUS ,POL_STAFF_YN  FROM   PT_IL_POLICY "
				+ "WHERE  POL_DS_TYPE = '1' AND    POL_PROP_QUOT_FLAG = 'P' AND POL_NO = ?  AND POL_END_NO_IDX = ? ";
		String CURSOR_C3 = "SELECT POL_CONT_CODE, POL_SRC_OF_BUS FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND POL_NO = ? ";*/
		String CURSOR_C2 = "SELECT POL_CUST_CODE, POL_SRC_OF_BUS ,POL_STAFF_YN  FROM   PT_IL_POLICY "
				+ "WHERE  POL_DS_TYPE = '1' AND    POL_PROP_QUOT_FLAG = 'P' AND POL_NO = ?  AND POL_END_NO_IDX = ? ";
		String CURSOR_C3 = "SELECT POL_CUST_CODE, POL_SRC_OF_BUS FROM   PT_IL_POLICY WHERE  POL_DS_TYPE = '2' AND POL_NO = ? ";
		String CURSOR_C4 = "SELECT 'X' FROM PT_IL_POLICY  WHERE POL_CONT_CODE= ? AND POL_DS_TYPE IN ('1','2') AND POL_NO <> ? AND NVL(POL_PROP_QUOT_FLAG,'Q') <> 'Q' ";
		String CURSOR_C5 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_CONT_CODE= ? AND POL_DS_TYPE IN ('1','2') AND  NVL(POL_PROP_QUOT_FLAG,'Q') <> 'Q' ";
		String CURSOR_C6A = "SELECT PROD_DS_CODE FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ? ";
		String CURSOR_C6 = " SELECT DS_BROKER_YN  FROM   PM_IL_DOC_SETUP WHERE  DS_CODE = ? ";
		String CURSOR_C7 = "SELECT 'X' FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_EX_SRCBUS' AND PS_CODE = 'IL_EX_SRCBUS'  AND  INSTR (PS_CODE_DESC, ? ) > 0 ";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;
		PT_IL_DEPOSIT depositBean = depositAction.getPT_IL_DEPOSIT_BEAN();

		try {
			connection = CommonUtils.getConnection();
			localprocedure.L_VALIDATE_POLICY(depositBean.getDEP_CONT_CODE(),
					"A", depositBean.getDEP_REF_NO());
			if ("Q".equals(CommonUtils.nvl(depositBean.getDEP_TYPE(), "Q"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C2A,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet.next()) {
					MAX_POL_END_NO_IDX = resultSet.getString(1);
				}
				resultSet1 = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] { depositBean.getDEP_REF_NO(),
								MAX_POL_END_NO_IDX });
				if (resultSet1.next()) {
					M_CONT_CODE = resultSet1.getString(1);
					M_POL_SRC_OF_BUS = resultSet1.getString(2);
					M_POL_STAFF_YN = resultSet1.getString(3);
				}
				if (M_CONT_CODE != null
						&& !(M_CONT_CODE.equals(depositBean.getDEP_CONT_CODE()))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91167",
							new Object[] { "", "proposal" }));
				}
			} else if ("P".equals(CommonUtils.nvl(depositBean.getDEP_TYPE(),
					"Q"))) {
				resultSet = handler.executeSelectStatement(CURSOR_C3,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet.next()) {
					M_CONT_CODE = resultSet.getString(1);
					M_POL_SRC_OF_BUS = resultSet.getString(2);
				}
				if (M_CONT_CODE != null
						&& !(M_CONT_CODE.equals(depositBean.getDEP_CONT_CODE()))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91167",
							new Object[] { " ", "Policy" }));
				}
			}

			resultSet2 = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { depositBean.getDEP_CONT_CODE() });
			if (resultSet2.next()) {
				M_NAME = resultSet2.getString(1);
			} else {
				if (depositBean.getDEP_CONT_CODE() != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91069"));
				}
			}
			depositBean.setUI_M_CUST_NAME(M_NAME);

			if (depositBean.getDEP_REF_NO() == null) {
				if (depositBean.getDEP_CONT_CODE() != null) {
					if (depositBean.getDEP_SYS_ID() != null) {
						resultSet3 = handler.executeSelectStatement(CURSOR_C4,
								connection, new Object[] {
										depositBean.getDEP_CONT_CODE(),
										depositBean.getDEP_SYS_ID() });
						if (resultSet3.next()) {
							M_DUMMY_X = resultSet3.getString(1);
						}
						if ("X".equals(CommonUtils.nvl(M_DUMMY_X, "Y"))) {
							throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
									new Object[] { "","Contractor code already exist policy/proposal" }));
						}
					} else {
						resultSet3 = handler.executeSelectStatement(CURSOR_C5,
								connection, new Object[] { depositBean
										.getDEP_CONT_CODE() });
						if (resultSet3.next()) {
							M_DUMMY_X = resultSet3.getString(1);
						}
						if ("X".equals(CommonUtils.nvl(M_DUMMY_X, "Y"))) {
							throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath,"3206",
									new Object[] { "","Contractor code already exist policy/proposal" }));
						}
					}
				}
			}

			if (depositBean.getDEP_PROD_CODE() != null) {
				resultSet5 = handler.executeSelectStatement(CURSOR_C6A,
						connection, new Object[] { depositBean
								.getDEP_CONT_CODE() });
				if (resultSet5.next()) {
					M_PROD_DS_CODE = resultSet5.getString(1);
				}
				resultSet4 = handler.executeSelectStatement(CURSOR_C6,
						connection, new Object[] { M_PROD_DS_CODE });
				if (resultSet4.next()) {
					M_DS_BROKER_YN = resultSet4.getString(1);
				}
				CommonUtils.closeCursor(resultSet);
				resultSet6 = handler.executeSelectStatement(CURSOR_C7,
						connection, new Object[] { M_POL_SRC_OF_BUS });
				if (resultSet6.next()) {
					M_DUMMY_SRC = resultSet6.getString(1);
				}
				if ("Y".equals(M_DS_BROKER_YN)
						&& !("X".equals(CommonUtils.nvl(M_DUMMY_SRC, "Y")))
						&& "N".equals(CommonUtils.nvl(M_POL_STAFF_YN, "N"))) {
					depositAction.getCOMP_DEP_AGENT_CODE().setRequired(true);
					depositAction.getCOMP_DEP_AGENT_CODE().setDisabled(false);
					depositAction.getCOMP_DEP_COLL_AGENT_CODE().setRequired(
							true);
					depositAction.getCOMP_DEP_COLL_AGENT_CODE().setDisabled(
							false);
				} else {
					depositAction.getCOMP_DEP_AGENT_CODE().setRequired(false);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
				CommonUtils.closeCursor(resultSet4);
				CommonUtils.closeCursor(resultSet5);
				CommonUtils.closeCursor(resultSet6);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}

	public void validateDEP_PROD_CODE(PT_IL_DEPOSIT_ACTION depositAction)
			throws Exception {
		String M_PLAN_TYPE = null;
		String M_DS_BROKER_YN = null;
		Integer M_COUNT = null;
		String M_POL_STAFF_YN = null;
		Integer M_POL_PREM_PAY_YRS = null;
		String M_PROD_AGENT_HIRE_YN = null;
		String M_POL_SRC_OF_BUS = null;
		String M_DUMMY_SRC = null;
		String M_POL_PROP_NO = null;
		String CURSOR_C1 = "SELECT NVL(PROD_DS_CODE,''),PROD_DESC,PROD_PLAN_CODE  FROM   PM_IL_PRODUCT  WHERE  PROD_CODE= ? ";
		String CURSOR_C2 = "SELECT DS_DESC  FROM   PM_IL_DOC_SETUP  WHERE  DS_CODE= ? ";
		String CURSOR_C3 = "SELECT PLAN_TYPE FROM   PM_IL_PLAN WHERE  PLAN_CODE= ? ";
		String CURSOR_C4A = "SELECT PROD_DS_CODE FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ? ";
		String CURSOR_C4 = "SELECT DS_BROKER_YN FROM   PM_IL_DOC_SETUP  WHERE  DS_CODE = ? ";
		String CURSOR_C5 = "SELECT POL_PREM_PAY_YRS,PROD_AGENT_HIRE_YN, POL_SRC_OF_BUS, POL_STAFF_YN  "
				+ " FROM   PT_IL_POLICY,PM_IL_PRODUCT WHERE  POL_NO = ?  AND    POL_PROD_CODE = PROD_CODE ";
		String CURSOR_C7A = "SELECT POL_PROP_NO FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
		String CURSOR_C7 = "SELECT COUNT(*) FROM   PT_IL_DEPOSIT WHERE  (DEP_REF_NO = ? OR DEP_REF_NO = ? ) AND    DEP_DOC_NO IS NOT NULL ";
		String CURSOR_C6 = "SELECT 'X'  FROM  PP_SYSTEM  WHERE  PS_TYPE = 'IL_EX_SRCBUS' AND PS_CODE = 'IL_EX_SRCBUS' AND INSTR (PS_CODE_DESC, ? ) > 0 ";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		ResultSet resultSet5 = null;
		ResultSet resultSet6 = null;
		ResultSet resultSet7 = null;
		ResultSet resultSet8 = null;

		PT_IL_DEPOSIT depositBean = depositAction.getPT_IL_DEPOSIT_BEAN();
		try {
			connection = CommonUtils.getConnection();

			if (depositBean.getDEP_PROD_CODE() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { depositBean
								.getDEP_PROD_CODE() });
				if (resultSet.next()) {
					if(depositBean.getDEP_DS_CODE()==null)
						depositBean.setDEP_DS_CODE(resultSet.getString(1));
					depositBean.setUI_M_DEP_PROD_CODE_DESC(resultSet
							.getString(2));
					depositBean.setDEP_PLAN_CODE(resultSet.getString(3));
				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91074"));
				}

				resultSet1 = handler.executeSelectStatement(CURSOR_C2,
						connection,
						new Object[] { depositBean.getDEP_DS_CODE() });
				if (resultSet1.next()) {
					// depositBean.setUI_M_DEP_DS_CODE_DESC(resultSet1.getString(1));
				}

				resultSet2 = handler.executeSelectStatement(CURSOR_C3,
						connection, new Object[] { depositBean
								.getDEP_PLAN_CODE() });
				if (resultSet2.next()) {
					M_PLAN_TYPE = resultSet2.getString(1);
				}

				// depositBean.setUI_M_DEP_PLAN_CODE_DESC(new
				// DBProcedures().P_VAL_PLAN(depositBean.getDEP_PLAN_CODE(),
				// "N","N"));

				resultSet3 = handler.executeSelectStatement(CURSOR_C5,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet3.next()) {
					M_POL_PREM_PAY_YRS = resultSet3.getInt(1);
					M_PROD_AGENT_HIRE_YN = resultSet3.getString(2);
					M_POL_SRC_OF_BUS = resultSet3.getString(3);
					M_POL_STAFF_YN = resultSet3.getString(4);
				}

				resultSet5 = handler.executeSelectStatement(CURSOR_C7A,
						connection,
						new Object[] { depositBean.getDEP_REF_NO() });
				if (resultSet5.next()) {
					M_POL_PROP_NO = resultSet5.getString(1);
				}
				resultSet4 = handler.executeSelectStatement(CURSOR_C7,
						connection, new Object[] { depositBean.getDEP_REF_NO(),
								M_POL_PROP_NO });
				if (resultSet4.next()) {
					M_COUNT = resultSet4.getInt(1);
				}
				CommonUtils.closeCursor(resultSet4);
				if (M_COUNT == 0) {
					if ("N".equals(M_PROD_AGENT_HIRE_YN)) {
						depositAction.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(
								false);
					} else {
						depositAction.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(
								true);
					}
				}
			}
			String code = null;
			resultSet7 = handler.executeSelectStatement(CURSOR_C4A, connection,
					new Object[] { depositBean.getDEP_PROD_CODE() });
			if (resultSet7.next()) {
				code = resultSet7.getString(1);
			}
			resultSet6 = handler.executeSelectStatement(CURSOR_C4, connection,
					new Object[] { code });
			if (resultSet6.next()) {
				M_DS_BROKER_YN = resultSet6.getString(1);
			}

			resultSet8 = handler.executeSelectStatement(CURSOR_C6, connection,
					new Object[] { M_POL_SRC_OF_BUS });
			if (resultSet8.next()) {
				M_DUMMY_SRC = resultSet8.getString(1);
			}

			if ("Y".equals(M_DS_BROKER_YN)
					&& !("X".equals(CommonUtils.nvl(M_DUMMY_SRC, "Y")))
					&& "N".equals(CommonUtils.nvl(M_POL_STAFF_YN, "N"))) {
				depositAction.getCOMP_DEP_AGENT_CODE().setDisabled(false);
				depositAction.getCOMP_DEP_AGENT_CODE().setRequired(true);
				depositAction.getCOMP_DEP_COLL_AGENT_CODE().setDisabled(false);
				depositAction.getCOMP_DEP_COLL_AGENT_CODE().setRequired(true);

			} else {
				depositAction.getCOMP_DEP_AGENT_CODE().setRequired(false);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
				CommonUtils.closeCursor(resultSet4);
				CommonUtils.closeCursor(resultSet5);
				CommonUtils.closeCursor(resultSet6);
				CommonUtils.closeCursor(resultSet7);
				CommonUtils.closeCursor(resultSet8);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateDEP_AGENT_CODE(PT_IL_DEPOSIT depositBean)
			throws Exception {
		try {
			localprocedure.L_VALIDATE_POLICY(depositBean.getDEP_AGENT_CODE(),
					"G", depositBean.getDEP_REF_NO());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateDEP_LC_TOTAL_AMT(PT_IL_DEPOSIT depositBean)
			throws Exception {
		ArrayList<OracleParameter> list = null;
		try {
			if (depositBean.getDEP_LC_TOTAL_AMT() == 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91004"));
			}

			list = new PKG_PILT002_APAC()
					.P_VAL_ROUND_AMT(CommonUtils.getControlBean()
							.getM_BASE_CURR(), depositBean
							.getDEP_LC_TOTAL_AMT(), "R", depositBean
							.getDEP_PROD_CODE());
			if (list != null && !list.isEmpty()) {
				/*depositBean.setDEP_LC_TOTAL_AMT((Double) list.get(0)
						.getValueObject());*/
			}

			if ("Q".equals(depositBean.getDEP_TYPE())
					&& depositBean.getDEP_LC_TOTAL_AMT() > 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "QD");
			} else if ("P".equals(depositBean.getDEP_TYPE())
					&& depositBean.getDEP_LC_TOTAL_AMT() > 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "PD");
			}

			if (depositBean.getDEP_LC_DEP_AMT() == null) {
				depositBean
						.setDEP_LC_DEP_AMT(depositBean.getDEP_LC_TOTAL_AMT());
				depositBean.setDEP_LC_OTH_AMT(0.00);
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 
	 * @param P_POL_SYS_ID-IN
	 * @param P_GLOBAL_CURR_CODE-IN
	 * @param P_PT_IL_DEPOSIT_DEP_PROD_CODE-IN
	 * @param P_PT_IL_DEPOSIT_M_POL_LC_G_P-IN
	 *            OUT
	 * @param P_PT_IL_DEPOSIT_M_POL_LC_N_P-IN
	 *            OUT
	 * @param P_PT_IL_DEPOSIT_M_POL_LC_COM-IN
	 *            OUT
	 * @param P_DUMMY_M_PROD_PREM_CALC_MTHD-IN
	 *            OUT
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> L_GROSS_PREM(Object P_POL_SYS_ID,
			Object P_GLOBAL_CURR_CODE, Object P_PT_IL_DEPOSIT_DEP_PROD_CODE,
			Object P_PT_IL_DEPOSIT_M_POL_LC_G_P,
			Object P_PT_IL_DEPOSIT_M_POL_LC_N_P,
			Object P_PT_IL_DEPOSIT_M_POL_LC_COM,
			Object P_DUMMY_M_PROD_PREM_CALC_MTHD,
			Object P_DEP_LC_DEP_AMT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			Object P_PT_IL_DEPOSIT_LC_AMT = null;
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_GLOBAL_CURR_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN,
					P_PT_IL_DEPOSIT_DEP_PROD_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN OUT4",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN_OUT,
					P_PT_IL_DEPOSIT_M_POL_LC_G_P);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN OUT5",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN_OUT,
					P_PT_IL_DEPOSIT_M_POL_LC_N_P);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN OUT6",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.IN_OUT,
					P_PT_IL_DEPOSIT_M_POL_LC_COM);
			parameterList.add(param6);
			/*Newly added by pidugu raj dt: 06-07-2020 for Alliance-ACD_IL_037*/
			OracleParameter param7 = new OracleParameter("OUT7",
					OracleParameter.DATA_TYPE.DOUBLE,
					OracleParameter.DIRECTION_TYPE.OUT,
					P_PT_IL_DEPOSIT_LC_AMT);
			parameterList.add(param7);
			//end
			
			OracleParameter param8 = new OracleParameter("IN OUT8",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN_OUT,
					P_DUMMY_M_PROD_PREM_CALC_MTHD);
			parameterList.add(param8);
			
			
			//added by Mani 18July24 suggested by KK
			OracleParameter param9 = new OracleParameter("OUT9",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT,
					P_DEP_LC_DEP_AMT);
			parameterList.add(param9);
			
			

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"L_GROSS_PREM");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	public void validateDEP_REPL_RCPT_YN(PT_IL_DEPOSIT_ACTION depositAction) {
		PT_IL_DEPOSIT depositBean = depositAction.getPT_IL_DEPOSIT_BEAN();

		if ("Y".equals(depositBean.getDEP_REPL_RCPT_YN())) {
			depositAction.getCOMP_DEP_REP_BANK_IN_SLIP_NO().setDisabled(false);
			if (depositBean.getDEP_REP_BANK_IN_SLIP_NO() == null) {
				depositAction.getCOMP_DEP_REPL_TXN_CODE().setDisabled(false);
				depositAction.getCOMP_DEP_REPL_DOC_NO().setDisabled(false);
				depositAction.getCOMP_DEP_REPL_ACC_YR().setDisabled(false);

				depositAction.getCOMP_DEP_REPL_TXN_CODE().setRequired(true);
				depositAction.getCOMP_DEP_REPL_DOC_NO().setRequired(true);
				depositAction.getCOMP_DEP_REPL_ACC_YR().setRequired(true);
			}
		} else {
			depositBean.setDEP_REP_BANK_IN_SLIP_NO(null);
			depositBean.setDEP_REPL_TXN_CODE(null);
			depositBean.setDEP_REPL_DOC_NO(null);
			depositBean.setDEP_REPL_ACC_YR(null);

			depositAction.getCOMP_DEP_REPL_TXN_CODE().setDisabled(true);
			depositAction.getCOMP_DEP_REPL_DOC_NO().setDisabled(true);
			depositAction.getCOMP_DEP_REPL_ACC_YR().setDisabled(true);
			depositAction.getCOMP_DEP_REP_BANK_IN_SLIP_NO().setDisabled(true);

			depositAction.getCOMP_DEP_REPL_TXN_CODE().setRequired(false);
			depositAction.getCOMP_DEP_REPL_DOC_NO().setRequired(false);
			depositAction.getCOMP_DEP_REPL_ACC_YR().setRequired(false);
			depositAction.getCOMP_DEP_REP_BANK_IN_SLIP_NO().setRequired(false);
		}
	}

	public void validateDEP_REP_BANK_IN_SLIP_NO(
			PT_IL_DEPOSIT_ACTION depositAction) {

		PT_IL_DEPOSIT depositBean = depositAction.getPT_IL_DEPOSIT_BEAN();
		if (depositBean.getDEP_REP_BANK_IN_SLIP_NO() == null) {
			if ("Y".equals(depositBean.getDEP_REPL_RCPT_YN())) {
				depositAction.getCOMP_DEP_REPL_TXN_CODE().setDisabled(false);
				depositAction.getCOMP_DEP_REPL_DOC_NO().setDisabled(false);
				depositAction.getCOMP_DEP_REPL_ACC_YR().setDisabled(false);

				depositAction.getCOMP_DEP_REPL_TXN_CODE().setRequired(true);
				depositAction.getCOMP_DEP_REPL_DOC_NO().setRequired(true);
				depositAction.getCOMP_DEP_REPL_ACC_YR().setRequired(true);
			}
		} else if (depositBean.getDEP_REP_BANK_IN_SLIP_NO() == null) {
			if ("Y".equals(depositBean.getDEP_REPL_RCPT_YN())) {
				depositAction.getCOMP_DEP_REPL_TXN_CODE().setDisabled(false);
				depositAction.getCOMP_DEP_REPL_DOC_NO().setDisabled(false);
				depositAction.getCOMP_DEP_REPL_ACC_YR().setDisabled(false);

				depositAction.getCOMP_DEP_REPL_TXN_CODE().setRequired(false);
				depositAction.getCOMP_DEP_REPL_DOC_NO().setRequired(false);
				depositAction.getCOMP_DEP_REPL_ACC_YR().setRequired(false);
			}
		}
	}

	public void validateDEP_DIVN_CODE(PT_IL_DEPOSIT depositBean)
			throws Exception {
		ArrayList<OracleParameter> list = null;
		try {
			list = new LIFELIB().P_VAL_DIVN(depositBean.getDEP_DIVN_CODE(),
					depositBean.getUI_M_DEP_DIVN_DESC(), "N", "E");

			if (list != null && !list.isEmpty()) {
				depositBean.setUI_M_DEP_DIVN_DESC((String) list.get(0)
						.getValueObject());
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateDEP_DEPT_CODE(PT_IL_DEPOSIT depositBean)
			throws Exception {
		ArrayList<OracleParameter> list = null;
		try {
			list = new LIFELIB().P_VAL_DEPT(depositBean.getDEP_DIVN_CODE(),
					depositBean.getDEP_DEPT_CODE(), depositBean
							.getUI_M_DEP_DEPT_DESC(), "N", "E");
			if (list != null && !list.isEmpty()) {
				// depositBean.setUI_M_DEP_DEPT_DESC((String)list.get(0).getValueObject());
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateDEP_BANKIN_CODE(PT_IL_DEPOSIT depositBean)
			throws Exception {

		String CURSOR_C1 = "SELECT DECODE(:CTRL.M_LANG_CODE,'ENG',BANK_NAME,BANK_NAME_BL) FROM   FM_BANK WHERE  BANK_CODE= ? ";
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			if (depositBean.getDEP_BANKIN_CODE() != null) {
				resultSet = handler.executeSelectStatement(CURSOR_C1,
						connection, new Object[] { depositBean
								.getDEP_BANKIN_CODE() });
				if (resultSet.next()) {
					depositBean.setUI_M_BANKIN_NAME(resultSet.getString(1));

				} else {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",
							new Object[] { " ",
									"Invalid Bank...Please Re-enter" }));
				}
			} else {
				depositBean.setUI_M_BANKIN_NAME(null);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void validateDEP_PLAN_CODE(PT_IL_DEPOSIT_ACTION depositAction)
			throws Exception {

		String M_PLAN_TYPE = null;
		String M_PROD_PREM_CALC_MTHD = null;
		Integer M_COUNT = null;
		Integer M_COUNT1 = null;
		String M_POL_PROP_NO = null;
		Integer M_POL_PREM_PAY_YRS = 0;
		String M_PROD_AGENT_HIRE_YN = null;
		String CURSOR_C1 = "SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE PLAN_CODE= ? ";
		String CURSOR_C2 = "SELECT PROD_PREM_CALC_MTHD FROM PM_IL_PRODUCT WHERE PROD_CODE =?";
		String CURSOR_C3 = "SELECT POL_PREM_PAY_YRS,PROD_AGENT_HIRE_YN FROM " +
				"PT_IL_POLICY,PM_IL_PRODUCT WHERE POL_NO = ? AND POL_PROD_CODE = PROD_CODE ";
		String CURSOR_C4 = "SELECT COUNT(*) FROM PT_IL_DEPOSIT WHERE " +
				"(DEP_REF_NO = ? OR DEP_REF_NO = ? ) AND DEP_DOC_NO IS NOT NULL ";
		String CURSOR_C4A = "SELECT POL_PROP_NO FROM PT_IL_POLICY WHERE POL_NO = ?";
		PT_IL_DEPOSIT depositBean = depositAction.getPT_IL_DEPOSIT_BEAN();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			depositBean.setUI_M_DEP_PLAN_CODE_DESC(new DBProcedures()
					.P_VAL_PLAN(depositBean.getDEP_PLAN_CODE(), "N", "N"));

			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { depositBean.getDEP_PLAN_CODE() });
			if (resultSet.next()) {
				M_PLAN_TYPE = resultSet.getString(1);
			}

			resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { depositBean.getDEP_PROD_CODE() });
			if (resultSet1.next()) {
				M_PROD_PREM_CALC_MTHD = resultSet1.getString(1);
			}

			resultSet2 = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { depositBean.getDEP_REF_NO() });
			if (resultSet2.next()) {
				M_POL_PREM_PAY_YRS = resultSet2.getInt(1);
				M_PROD_AGENT_HIRE_YN = resultSet2.getString(2);
			}

			resultSet3 = handler.executeSelectStatement(CURSOR_C4A, connection,
					new Object[] { depositAction.getPT_IL_DEPOSIT_BEAN()
							.getDEP_REF_NO() });
			if (resultSet3.next()) {
				M_POL_PROP_NO = resultSet3.getString(1);
			}

			resultSet4 = handler
					.executeSelectStatement(CURSOR_C4, connection,
							new Object[] { depositBean.getDEP_REF_NO(),
									M_POL_PROP_NO });
			if (resultSet4.next()) {
				M_COUNT = resultSet4.getInt(1);
			}

			CommonUtils.closeCursor(resultSet);

			if (M_COUNT == 0) {
				if (M_POL_PREM_PAY_YRS == 1 && "N".equals(M_PROD_AGENT_HIRE_YN)) {
					depositAction.getCOMP_DEP_GROSS_NET_FLAG().setDisabled(
							false);
				} else {
					depositAction.getCOMP_DEP_GROSS_NET_FLAG()
							.setDisabled(true);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
			CommonUtils.closeCursor(resultSet3);
			CommonUtils.closeCursor(resultSet4);
		}
	}

	public void validateDEP_SRC_OF_BUS(PT_IL_DEPOSIT depositBean)
			throws Exception {
		ArrayList<String> list = null;
		try {
			if (depositBean.getDEP_SRC_OF_BUS() != null) {
				list = new DBProcedures().P_VAL_CODES("SRC_BUS_TY", depositBean
						.getDEP_SRC_OF_BUS(), "N", "E", null);

				if (list != null && !list.isEmpty()) {
					depositBean.setUI_M_DEP_BUS_DESC(list.get(0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateDEP_REV_REMARKS(PT_IL_DEPOSIT depositBean)
			throws Exception {

		String CURSOR_C1 = "SELECT NVL(CONT_LC_PROP_DEP_AMT,0), NVL(CONT_LC_PROP_UTIL_AMT,0),NVL(CONT_LC_POL_DEP_AMT,0),"
				+ "NVL(CONT_LC_POL_UTIL_AMT,0)  FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE = ?  ";

		Double M_PROP_DEP_AMT = null;
		Double M_PROP_UTIL_AMT = null;
		Double M_POL_DEP_AMT = null;
		Double M_POL_UTIL_AMT = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();

			if (depositBean.getDEP_LC_TOTAL_AMT() == 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91004"));
			}

			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { depositBean.getDEP_REF_NO() });
			if (resultSet.next()) {
				M_PROP_DEP_AMT = resultSet.getDouble(1);
				M_PROP_UTIL_AMT = resultSet.getDouble(2);
				M_POL_DEP_AMT = resultSet.getDouble(3);
				M_POL_UTIL_AMT = resultSet.getDouble(4);
			}

			if (depositBean.getDEP_LC_DEP_AMT() < 0) {
				if ("Q".equals(depositBean.getDEP_TYPE())) {
					if (Math.abs(depositBean.getDEP_LC_DEP_AMT()) > (M_PROP_DEP_AMT - M_PROP_UTIL_AMT)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91044"));
					}
				}
				if ("P".equals(depositBean.getDEP_TYPE())) {
					if (Math.abs(depositBean.getDEP_LC_DEP_AMT()) > (M_PROP_DEP_AMT - M_PROP_UTIL_AMT)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91044"));
					}
				}
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "DR");
			}

			if ("Q".equals(depositBean.getDEP_TYPE())
					&& depositBean.getDEP_LC_DEP_AMT() > 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "QD");
			} else if ("P".equals(depositBean.getDEP_TYPE())
					&& depositBean.getDEP_LC_DEP_AMT() > 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "PD");
			} else if (("Q".equals(depositBean.getDEP_TYPE()) || "P"
					.equals(depositBean.getDEP_TYPE()))
					&& depositBean.getDEP_LC_DEP_AMT() > 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "DR");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}

	public void approval(PILT016A_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		String M_DUMMY = null;
		Integer M_POL_UW_YEAR = null;
		String M_PD_DPD_REF_ID = null;
		Double M_BCSH_CUST_SHARE_PERC = null;
		String CURSOR_C1 = "SELECT   DECODE( ? ,'Q','1','P','2') FROM     DUAL";
		String CURSOR_C2 = "SELECT PT_UW_YEAR FROM   PM_IL_PROP_TREATY  WHERE  PT_CLASS_CODE =  ? AND (TRUNC(SYSDATE) BETWEEN TRUNC(PT_START_DT) AND TRUNC(PT_END_DT)) ";
		String CURSOR_C3 = "SELECT PD_DPD_REF_ID FROM   PT_IL_PYMT_DTLS  WHERE  PD_TXN_SYS_ID = ?  AND PD_TXN_TYPE = ? ";
		String CURSOR_C4 = "SELECT BCSH_CUST_SHARE_PERC  FROM  PM_BANK_CHARGE_SETUP_HDR  WHERE BCSH_PAY_MODE= ? ";
		
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		ResultSet resultSet4 = null;
		PT_IL_DEPOSIT depositBean = compositeAction
				.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		String PYMT_QUERY = "SELECT * FROM PT_IL_PYMT_DTLS  WHERE  PD_TXN_SYS_ID  =  ?  ";
		try {
			connection = CommonUtils.getConnection();

			PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN = new PT_IL_PYMT_DTLS();
			/*resultSet = handler.executeSelectStatement(PYMT_QUERY, connection,
					new Object[] { depositBean.getDEP_SYS_ID() });
			if (resultSet.next()) {
				PT_IL_PYMT_DTLS_BEAN.setPD_SYS_ID(resultSet
						.getLong("PD_SYS_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO(resultSet.getInt("PD_SR_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TXN_TYPE(resultSet
						.getString("PD_TXN_TYPE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TXN_SYS_ID(resultSet
						.getLong("PD_TXN_SYS_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE(resultSet
						.getString("PD_PAY_MODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CURR_CODE(resultSet
						.getString("PD_CURR_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(resultSet
						.getDouble("PD_FC_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(resultSet
						.getDouble("PD_LC_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_NO(resultSet
						.getString("PD_CHQ_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_DT(resultSet
						.getDate("PD_CHQ_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BANK_NAME(resultSet
						.getString("PD_BANK_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BRANCH_NAME(resultSet
						.getString("PD_BRANCH_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_NO(resultSet
						.getString("PD_CC_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_NAME(resultSet
						.getString("PD_CC_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_EXP_DT(resultSet
						.getDate("PD_CC_EXP_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_TYPE(resultSet
						.getString("PD_CC_TYPE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CUST_NAME(resultSet
						.getString("PD_CUST_NAME"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_01(resultSet
						.getString("PD_ADDR_01"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_02(resultSet
						.getString("PD_ADDR_02"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ADDR_03(resultSet
						.getString("PD_ADDR_03"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REMARKS(resultSet
						.getString("PD_REMARKS"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_UID(resultSet
						.getString("PD_CR_UID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_DT(resultSet.getDate("PD_CR_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_UPD_UID(resultSet
						.getString("PD_UPD_UID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_UPD_DT(resultSet
						.getDate("PD_UPD_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_DPD_REF_ID(resultSet
						.getString("PD_DPD_REF_ID"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REV_YN(resultSet
						.getString("PD_REV_YN"));
				PT_IL_PYMT_DTLS_BEAN.setPD_LC_CHARGE(resultSet
						.getDouble("PD_LC_CHARGE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_FC_CHARGE(resultSet
						.getDouble("PD_FC_CHARGE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR(resultSet
						.getString("PD_PAID_FOR"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CC_APP_CODE(resultSet
						.getString("PD_CC_APP_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PAYIN_DATE(resultSet
						.getDate("PD_PAYIN_DATE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_OUR_BANK_CODE(resultSet
						.getString("PD_OUR_BANK_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_DATE_OF_CREDIT(resultSet
						.getDate("PD_DATE_OF_CREDIT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TT_REF_NO(resultSet
						.getString("PD_TT_REF_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_TT_CURR_CODE(resultSet
						.getString("PD_TT_CURR_CODE"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REM_SLIP_GEN_YN(resultSet
						.getString("PD_REM_SLIP_GEN_YN"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PO_MO_NO(resultSet
						.getString("PD_PO_MO_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_PO_MO_DT(resultSet
						.getDate("PD_PO_MO_DT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_REM_AMT(resultSet
						.getDouble("PD_REM_AMT"));
				PT_IL_PYMT_DTLS_BEAN.setPD_BANK_REF_NO(resultSet
						.getString("PD_BANK_REF_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_CR_ADVICE_NO(resultSet
						.getString("PD_CR_ADVICE_NO"));
				PT_IL_PYMT_DTLS_BEAN.setPD_ATM_CARD_NO(resultSet
						.getString("PD_ATM_CARD_NO"));

			} else {
				throw new ValidatorException(new FacesMessage(
						"Please make payment before Approval"));
			}*/

			// BCSH_PAY_MODE taking argument from payment detail bean ..i taken
			// same reference from txn_type
			resultSet1 = handler.executeSelectStatement(CURSOR_C4, connection,
					new Object[] { compositeAction
							.getPT_IL_PYMT_DTLS_ACTION_BEAN()
							.getPT_IL_PYMT_DTLS_BEAN().getPD_PAY_MODE() });
			if (resultSet1.next()) {
				M_BCSH_CUST_SHARE_PERC = resultSet1.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);

			if ("I CC C1 C2 C3 C4 C5 C6".contains(PT_IL_PYMT_DTLS_BEAN
					.getPD_PAY_MODE())
					&& PT_IL_PYMT_DTLS_BEAN.getPD_CC_APP_CODE() == null
					&& M_BCSH_CUST_SHARE_PERC != 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91922"));
			}
			resultSet2 = handler.executeSelectStatement(CURSOR_C3, connection,
					new Object[] { depositBean.getDEP_SYS_ID(),
							CommonUtils.getGlobalObject("GLOBAL.TXN_TYPE") });
			if (resultSet2.next()) {
				M_PD_DPD_REF_ID = resultSet2.getString(1);
			}

			/*
			 * if (M_PD_DPD_REF_ID == null) { throw new Exception("Can't approve
			 * because dep ref id is null"); }
			 */

			if (depositBean.getDEP_PROD_CODE() == null
					&& depositBean.getDEP_CLASS_CODE() == null
					&& depositBean.getDEP_DS_CODE() == null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91334"));
			}

			resultSet1 = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] { depositBean.getDEP_TYPE() });
			if (resultSet1.next()) {
				M_DUMMY = resultSet1.getString(1);
			}

			resultSet2 = handler.executeSelectStatement(CURSOR_C2, connection,
					new Object[] { depositBean.getDEP_CLASS_CODE() });
			if (resultSet2.next()) {
				M_POL_UW_YEAR = resultSet2.getInt(1);
			}

			if ("Y".equals(depositBean.getDEP_REPL_RCPT_YN())) {
				if (depositBean.getDEP_REP_BANK_IN_SLIP_NO() != null) {
					if (depositBean.getDEP_REPL_TXN_CODE() != null
							|| depositBean.getDEP_REPL_DOC_NO() != null
							|| depositBean.getDEP_REPL_ACC_YR() != null) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91976"));
					}
				}
			}

			if (depositBean.getDEP_REF_NO() == null) {
				LIFELIB.P_SET_DOC_NO_PROP(M_DUMMY,
						depositBean.getDEP_DS_CODE(), depositBean
								.getDEP_DIVN_CODE(), depositBean
								.getDEP_CLASS_CODE(), depositBean
								.getDEP_PLAN_CODE(), depositBean
								.getDEP_PROD_CODE(), CommonUtils
								.getProcedureValue(M_POL_UW_YEAR),
						"PT_IL_DEPOSIT.DEP_REF_NO", "PT_IL_DEPOSIT.DEP_REF_NO",
						"Y", CommonUtils.getProcedureValue(new CommonUtils()
								.getCurrentDate()), null, null, null, null);
				if (compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN()
						.getPT_IL_DEPOSIT_BEAN().getDEP_REF_NO()  == null) {
					if (depositBean.getDEP_CONT_CODE() == null) {
						new P9ILPK_BULK_RECEIPT().L_INS_CONT(depositBean
								.getDEP_ADTH_BATCH_NO());
					}

					localprocedure.L_DEPOSIT_APPROVAL(compositeAction);
				} else {
					throw new Exception("Proposal Number Setup is not Defined");
				}
			} else {
		
				
				localprocedure.L_DEPOSIT_APPROVAL(compositeAction);
			}
			
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		finally {
			try {
				CommonUtils.closeCursor(resultSet);
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
				CommonUtils.closeCursor(resultSet3);
				CommonUtils.closeCursor(resultSet4);

			} catch (Exception e) {

			}
		}

	}

	public void validateDEP_LC_DEP_AMT(PT_IL_DEPOSIT depositBean)
			throws Exception {

		Double M_PROP_DEP_AMT = 0.0d;
		Double M_PROP_UTIL_AMT = 0.0d;
		Double M_POL_DEP_AMT =0.0d;
		Double M_POL_UTIL_AMT = 0.0d;

		Double M_DPD_LC_DEP_AMT = 0.0d;
		Double M_DPD_LC_UTIL_AMT =0.0d;
		String CURSO_C1 = "SELECT NVL(CONT_LC_PROP_DEP_AMT,0), NVL(CONT_LC_PROP_UTIL_AMT,0), NVL(CONT_LC_POL_DEP_AMT,0),"
				+ "NVL(CONT_LC_POL_UTIL_AMT,0)  FROM   PM_IL_CONTRACTOR  WHERE  CONT_CODE = ? ";
		String CURSOR_C2 = "SELECT NVL(DPD_LC_DEP_AMT,0),NVL(DPD_LC_UTIL_AMT,0)  FROM PT_IL_DEPOSIT_PYMT_DTLS "
				+ "WHERE DPD_CONT_CODE= ? AND DPD_TXN_TYPE=DECODE(? ,'Q','QD','P','PD') AND DPD_CR_UID='ILIFETEST'  ORDER BY DPD_SYS_ID ASC ";

		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(CURSO_C1, connection,
					new Object[] { depositBean.getDEP_CONT_CODE() });
			if (resultSet.next()) {
				M_PROP_DEP_AMT = resultSet.getDouble(1);
				M_PROP_UTIL_AMT = resultSet.getDouble(2);
				M_POL_DEP_AMT = resultSet.getDouble(3);
				M_POL_UTIL_AMT = resultSet.getDouble(4);
			}

			if (depositBean.getDEP_LC_DEP_AMT() < 0.0) {
				if ("Q".equals(depositBean.getDEP_TYPE())) {
					if (Math.abs(depositBean.getDEP_LC_DEP_AMT()) > (M_PROP_DEP_AMT - M_PROP_UTIL_AMT)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91044"));
					}
				}
				if ("P".equals(depositBean.getDEP_TYPE())) {
					if (Math.abs(depositBean.getDEP_LC_DEP_AMT()) > (M_PROP_DEP_AMT - M_PROP_UTIL_AMT)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91044"));
					}
				}
				resultSet1 = handler.executeSelectStatement(CURSOR_C2,
						connection, new Object[] {
								depositBean.getDEP_CONT_CODE(),
								depositBean.getDEP_TYPE() });
				if (resultSet1.next()) {
					M_DPD_LC_DEP_AMT = resultSet1.getDouble(1);
					M_DPD_LC_UTIL_AMT = resultSet1.getDouble(2);
					if (Math.abs(depositBean.getDEP_LC_DEP_AMT()) > (M_DPD_LC_DEP_AMT - M_DPD_LC_UTIL_AMT)) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "3206",
								new Object[] { " ",
										"Old Deposit has been utilized" }));
					}
				} else {
					throw new Exception(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"3206", new Object[] { " ",
											"Old Deposit has been utilized" }));
				}
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "DR");
			}
			if ("Q".equals(depositBean.getDEP_TYPE())
					&& depositBean.getDEP_LC_DEP_AMT() > 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "QD");
			} else if ("P".equals(depositBean.getDEP_TYPE())
					&& depositBean.getDEP_LC_DEP_AMT() > 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "PD");
			}
			if ("Q P".contains(depositBean.getDEP_TYPE())
					&& depositBean.getDEP_LC_DEP_AMT() < 0) {
				CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "DR");
			}

		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void L_POPULATE_POLICY_DETAILS(PILT016A_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		Connection connection =null;
		ResultSet resultSet = null;
		CRUDHandler handler=null;
		Long M_POL_SYS_ID=null;
		String M_POL_MODE_OF_PYMT=null;
		Double M_POL_LC_NET_PREM=null;
		String M_POL_MODE_OF_PYMT_RATE=null;
		String M_POL_PLAN_CODE=null;
		Date M_MIN_PC_SCHD_PYMT_DT = null; 
		String C1 = "SELECT POL_SYS_ID, "
				+ "POL_MODE_OF_PYMT, "
				+ "NVL(POL_LC_NET_PREM,0), "
				+ "NVL(POL_MODE_OF_PYMT_RATE,0), "
				+ "POL_PLAN_CODE "
				+ "FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO             = ? "
				+ "AND    POL_DS_TYPE        = DECODE(?,'Q','1','P','2') "
				+ "AND    POL_CONT_CODE      = ? "
				+ "AND    POL_END_NO_IDX     = (SELECT MAX(POL_END_NO_IDX) "
				+ "FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO = ?)";
		String C2 = "SELECT MIN(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL "
				+ "WHERE  PC_POL_SYS_ID      =  ? "
				+ "AND    PC_PAID_FLAG       = 'N' "
				+ "AND    PC_PAID_DT  IS NULL";
		
		String C3 = "SELECT MAX(POBH_AGENT_LEVEL) FROM   PT_IL_POL_BROKER_HEAD WHERE  POBH_POL_SYS_ID    = ?";
		String C4 ="SELECT POBH_BROKER_CODE      FROM	 PT_IL_POL_BROKER_HEAD  WHERE  POBH_POL_SYS_ID   = ?   AND    POBH_AGENT_LEVEL  = ?";
		String C5="SELECT CUST_NAME  FROM   PM_CUSTOMER   WHERE  CUST_CODE=?";
		
		PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN = compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		int M_MAX_POBH_AGENT_LEVEL = 0;
		String M_POBH_BROKER_CODE = null;
		String M_CUST_NAME = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_REF_NO(),
																				PT_IL_DEPOSIT_BEAN.getDEP_TYPE(),
																				PT_IL_DEPOSIT_BEAN.getDEP_CONT_CODE(),
																				PT_IL_DEPOSIT_BEAN.getDEP_REF_NO()});
			
			if(C1_REC.next()){
				M_POL_SYS_ID = C1_REC.getLong(1);
				M_POL_MODE_OF_PYMT = C1_REC.getString(2);
				M_POL_LC_NET_PREM = C1_REC.getDouble(3);
				M_POL_MODE_OF_PYMT_RATE=C1_REC.getString(4);
				M_POL_PLAN_CODE=C1_REC.getString(5);
			}
			
			C2_REC = handler.executeSelectStatement(C2, connection,new Object[]{M_POL_SYS_ID});
			if(C2_REC.next()){
				M_MIN_PC_SCHD_PYMT_DT = C2_REC.getDate(1);
			}
			
			C3_REC = handler.executeSelectStatement(C3, connection,new Object[]{M_POL_SYS_ID});
			if(C3_REC.next()){
				M_MAX_POBH_AGENT_LEVEL = C3_REC.getInt(1);
			}
			
			C4_REC = handler.executeSelectStatement(C4, connection,new Object[]{M_POL_SYS_ID,M_MAX_POBH_AGENT_LEVEL});
			if(C4_REC.next()){
				M_POBH_BROKER_CODE = C4_REC.getString(1);
			}
			
			C5_REC = handler.executeSelectStatement(C5, connection,new Object[]{M_POBH_BROKER_CODE});
			if(C5_REC.next()){
				M_CUST_NAME = C5_REC.getString(1);
			}
			
			compositeAction.getPOLICY_DET_ACTION_BEAN().getPOLICY_DET_BEAN().setUI_M_POL_NO(PT_IL_DEPOSIT_BEAN.getDEP_REF_NO());
			compositeAction.getPOLICY_DET_ACTION_BEAN().getPOLICY_DET_BEAN().setUI_M_MODE_OF_PYMT(M_POL_MODE_OF_PYMT);
			compositeAction.getPOLICY_DET_ACTION_BEAN().getPOLICY_DET_BEAN().setUI_M_PAY_DUE_DT(M_MIN_PC_SCHD_PYMT_DT);
			compositeAction.getPOLICY_DET_ACTION_BEAN().getPOLICY_DET_BEAN().setUI_M_AGENT_CODE(M_POBH_BROKER_CODE);
			compositeAction.getPOLICY_DET_ACTION_BEAN().getPOLICY_DET_BEAN().setUI_M_AGENT_NAME(M_CUST_NAME);
			L_DISPLAY_PREMIUM(compositeAction,M_POL_SYS_ID);
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			try{
				CommonUtils.closeCursor(C1_REC);
				CommonUtils.closeCursor(C2_REC);
				CommonUtils.closeCursor(C3_REC);
				CommonUtils.closeCursor(C4_REC);
				CommonUtils.closeCursor(C5_REC);
			}catch(Exception exception2){exception2.printStackTrace();}
		}
		
		
	}
	
	/**
	 * 
	 */
	public void L_DISPLAY_PREMIUM(PILT016A_APAC_COMPOSITE_ACTION compositeAction,Long P_POL_SYS_ID) throws Exception{
		CRUDHandler handler = null;
		Connection connection =null;
		ResultSet C0_REC = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet C8_REC = null;
		ResultSet BASE_CURR_REC = null;
		
		Double M_POL_LC_BASIC_PREM = 0.0d;
		Double M_POL_LC_ADDL_PREM = 0.0d;
		String M_POL_MODE_OF_PYMT = null;
		String M_POL_PLAN_CODE = null;
		Double M_POL_MODE_OF_PYMT_RATE = 0.0d;
		Double M_POL_LC_DISC_AMT = 0.0d;
		String M_POL_CUST_CURR_CODE = null;
		Double M_POL_CUST_EXCH_RATE = 0.0d;
		int M_POL_NO_OF_INST = 0;
		int M_POL_ORG_NO_OF_INST = 0;
		String M_POL_INCORPORATED_YN = null;
		Double M_POL_LC_SUM_ASSURED = 0.0d;
		String M_PLAN_TYPE = null;
		Double M_PDL_LC_LOAD_VALUE = 0.0d;
		Double M_PDL_LC_DISC_VALUE = 0.0d;
		Double M_POC_CUST_SHARE_PERC = 0.0d;
		Double M_POC_LC_VALUE=0.0d;
		Double M_MODAL_PREM = 0.0d;
		Double M_LC_SCHARGES_BORNE_CUSTOMER = 0.0d;
		String M_PROD_LOAD_CHARGE = null;
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_BEAN();
		
		String C0="SELECT PLAN_TYPE  FROM   PM_IL_PLAN WHERE  PLAN_CODE = ? ";
		String C1 = "SELECT NVL(POL_LC_BASIC_PREM,0),NVL(POL_LC_ADDL_PREM,0), "
				+ " POL_MODE_OF_PYMT,        POL_PLAN_CODE,              "
				+ " POL_MODE_OF_PYMT_RATE,   NVL(POL_LC_DISC_AMT,0), "
				+ " POL_CUST_CURR_CODE,      POL_CUST_EXCH_RATE, "
				+ " POL_NO_OF_INST,          POL_ORG_NO_OF_INST, "
				+ " POL_INCORPORATED_YN,     POL_LC_SUM_ASSURED, POL_LC_MODAL_PREM "
				+ "FROM   PT_IL_POLICY WHERE  POL_SYS_ID   = ?";
		String C2 = "SELECT NVL(SUM(PDL_LC_DISC_LOAD_VALUE),0) "
				+ "FROM   PT_IL_POL_DISC_LOAD "
				+ "WHERE  PDL_POL_SYS_ID = ? "
				+ "AND    PDL_DISC_LOAD_TYPE = 'L'";
		String C3 = "SELECT NVL(SUM(PDL_LC_DISC_LOAD_VALUE),0) "
				+ "FROM   PT_IL_POL_DISC_LOAD "
				+ "WHERE  PDL_POL_SYS_ID = ? "
				+ "AND    PDL_DISC_LOAD_TYPE = 'D'";
		String C4 = "SELECT POC_CUST_SHARE_PERC,NVL(POC_LC_VALUE,0) "
				+ "FROM   PT_IL_POL_CHARGE "
				+ "WHERE  POC_POL_SYS_ID = ? "
				+ "AND    NVL(POC_APPLY_PERIOD,'P') = 'P'";
		
		String C5 = "SELECT NVL(PDL_LC_DISC_LOAD_VALUE,0) "
				+ "FROM   PT_IL_POL_DISC_LOAD,  " + " PP_SYSTEM "
				+ "WHERE  PS_TYPE        = 'IL_MTLD_CODE' "
				+ "AND    PS_CODE        = ? "
				+ "AND    PS_CODE_DESC   = PDL_DISC_LOAD_CODE "
				+ "AND    PDL_POL_SYS_ID = ?";
		String C6 = "	SELECT NVL(PDL_LC_DISC_LOAD_VALUE,0) "
				+ "FROM   PT_IL_POL_DISC_LOAD, PP_SYSTEM "
				+ "WHERE  PS_TYPE = 'IL_UWOC_LOAD' "
				+ "AND    PS_CODE_DESC = PDL_DISC_LOAD_CODE "
				+ "AND    PDL_POL_SYS_ID = ?";
		String C7 = "SELECT NVL(SUM(POC_LC_VALUE * POC_CUST_SHARE_PERC /100),0) "
				+ "FROM   PT_IL_POL_CHARGE WHERE  POC_POL_SYS_ID = ?";
		String C8 = "SELECT PROD_LOAD_CHARGE_YN FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		
		String BASE_CURR = "SELECT PARA_VALUE  FROM	  FP_PARAMETER	   WHERE  PARA_ID = 'BASE.CURR'";
		String CURRENCY = null;
		PT_IL_DEPOSIT depositBean = compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN();
		Double M_LC_PREMIUM = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			BASE_CURR_REC = handler.executeSelectStatement(BASE_CURR, connection);
			if(BASE_CURR_REC.next()){
				CURRENCY = BASE_CURR_REC.getString(1);
			}
			
			C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{P_POL_SYS_ID});
			if(C1_REC.next()){
				M_POL_LC_BASIC_PREM = C1_REC.getDouble(1);
				M_POL_LC_ADDL_PREM = C1_REC.getDouble(2);
				M_POL_MODE_OF_PYMT = C1_REC.getString(3);
				M_POL_PLAN_CODE = C1_REC.getString(4);
				M_POL_MODE_OF_PYMT_RATE = C1_REC.getDouble(5);
				M_POL_LC_DISC_AMT = C1_REC.getDouble(6);
				M_POL_CUST_CURR_CODE = C1_REC.getString(7);
				M_POL_CUST_EXCH_RATE = C1_REC.getDouble(8);
				M_POL_NO_OF_INST = C1_REC.getInt(9);
				M_POL_ORG_NO_OF_INST = C1_REC.getInt(10);
				M_POL_INCORPORATED_YN = C1_REC.getString(11);
				M_POL_LC_SUM_ASSURED = C1_REC.getDouble(12);
				M_MODAL_PREM =  C1_REC.getDouble(13);
			}
			
			C0_REC = handler.executeSelectStatement(C0, connection,new Object[]{M_POL_PLAN_CODE});
			if(C0_REC.next()){
				M_PLAN_TYPE = C0_REC.getString(1);
			}
			if(!"M".equalsIgnoreCase(M_PLAN_TYPE) || ("M".equalsIgnoreCase(M_PLAN_TYPE) &&
					"T".equalsIgnoreCase(CommonUtils.nvl(DUMMY_BEAN.getUI_M_PROD_PREM_CALC_MTHD(), "N")))){
				C2_REC = handler.executeSelectStatement(C2, connection,new Object[]{P_POL_SYS_ID});
				if(C2_REC.next()){
					M_PDL_LC_LOAD_VALUE = C2_REC.getDouble(1);
				}
				
				C3_REC = handler.executeSelectStatement(C3, connection,new Object[]{P_POL_SYS_ID});
				if(C3_REC.next()){
					M_PDL_LC_DISC_VALUE = C3_REC.getDouble(1);
				}
				
				C4_REC = handler.executeSelectStatement(C4, connection,new Object[]{P_POL_SYS_ID});
				boolean valid = true;
				while(C4_REC.next()){
					M_POC_CUST_SHARE_PERC = C4_REC.getDouble(1);
					M_POC_LC_VALUE = C4_REC.getDouble(2);
					//valid = false;
					M_LC_SCHARGES_BORNE_CUSTOMER = CommonUtils.nvl(M_LC_SCHARGES_BORNE_CUSTOMER, 0) + CommonUtils.nvl(M_POC_CUST_SHARE_PERC, 0) * CommonUtils.nvl(M_POC_LC_VALUE, 0)/100;
				}
				L_VAL_ROUND_AMT(CURRENCY, M_LC_SCHARGES_BORNE_CUSTOMER, "R");
				C8_REC = handler.executeSelectStatement(C8, connection,
						new Object[] { depositBean.getDEP_PROD_CODE() });
				if (C8_REC.next()) {
					M_PROD_LOAD_CHARGE = C8_REC.getString(1);
				}
				if (!("U".equalsIgnoreCase(M_PLAN_TYPE))) {

					if ("Y".equalsIgnoreCase(M_PROD_LOAD_CHARGE)) {
						M_LC_PREMIUM = CommonUtils.nvl(M_POL_LC_BASIC_PREM, 0)
								+ CommonUtils.nvl(M_POL_LC_ADDL_PREM, 0)
								+ CommonUtils.nvl(M_PDL_LC_LOAD_VALUE, 0)
								+ CommonUtils.nvl(M_LC_SCHARGES_BORNE_CUSTOMER,
										0)
								- CommonUtils.nvl(M_PDL_LC_DISC_VALUE, 0);
						M_LC_PREMIUM = M_LC_PREMIUM
								* CommonUtils.nvl(M_POL_MODE_OF_PYMT_RATE, 0);

						L_VAL_ROUND_AMT(CURRENCY, M_LC_PREMIUM, "R");
						M_LC_PREMIUM = M_LC_PREMIUM
								- CommonUtils.nvl(M_POL_LC_DISC_AMT, 0);
						System.out.println("M_LC_PREMIUM Inside If========>"
								+ M_LC_PREMIUM);
						compositeAction.getPOLICY_DET_ACTION_BEAN()
								.getPOLICY_DET_BEAN().setUI_M_MODAL_PREM(
										M_LC_PREMIUM);
					} else {
						M_LC_PREMIUM = CommonUtils.nvl(M_POL_LC_BASIC_PREM, 0)
								+ CommonUtils.nvl(M_POL_LC_ADDL_PREM, 0);
						M_LC_PREMIUM = M_LC_PREMIUM
								* CommonUtils.nvl(M_POL_MODE_OF_PYMT_RATE, 0);
						compositeAction.getPOLICY_DET_ACTION_BEAN()
								.getPOLICY_DET_BEAN().setUI_M_MODAL_PREM(
										M_LC_PREMIUM);
					}
				} else {
					M_LC_PREMIUM = CommonUtils.nvl(M_MODAL_PREM, 0);
					compositeAction.getPOLICY_DET_ACTION_BEAN()
							.getPOLICY_DET_BEAN().setUI_M_MODAL_PREM(
									M_LC_PREMIUM);
				}
			}else{
				if("G".equalsIgnoreCase(CommonUtils.nvl(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getDEP_GROSS_NET_FLAG(), "G"))){
					M_LC_PREMIUM =  CommonUtils.nvl(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getUI_M_POL_LC_GROSS_PREM(),0) * CommonUtils.nvl(M_POL_MODE_OF_PYMT_RATE,0); 
				}else{
					M_LC_PREMIUM = CommonUtils.nvl(compositeAction.getPT_IL_DEPOSIT_ACTION_BEAN().getPT_IL_DEPOSIT_BEAN().getUI_M_POL_LC_NET_PREM(),0) * CommonUtils.nvl(M_POL_MODE_OF_PYMT_RATE,0);            
				}
				L_VAL_ROUND_AMT(CURRENCY, M_LC_PREMIUM, "R");
				System.out.println("M_LC_PREMIUM Inside Else========>"+M_LC_PREMIUM);
				compositeAction.getPOLICY_DET_ACTION_BEAN().getPOLICY_DET_BEAN().setUI_M_MODAL_PREM(M_LC_PREMIUM);
			}
			
		}catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}finally{
			try{
				CommonUtils.closeCursor(C1_REC);
				CommonUtils.closeCursor(C2_REC);
				CommonUtils.closeCursor(C3_REC);
				CommonUtils.closeCursor(C4_REC);
				CommonUtils.closeCursor(C5_REC);
				CommonUtils.closeCursor(C6_REC);
				CommonUtils.closeCursor(C7_REC);
				CommonUtils.closeCursor(BASE_CURR_REC);
			}catch(Exception exception2){}
		}
	}
			
	

	public double L_VAL_ROUND_AMT(String P_CURR_CODE, double P_AMT,
			String P_VAL_ROUND) throws Exception {

		ResultSet resultSet = null;
		int M_DECIMAL = 0;

		try {
			String sql_C1 = "SELECT CURR_DECIMAL FROM FM_CURRENCY WHERE CURR_CODE = ? ";
			Object[] values = { P_CURR_CODE };
			resultSet = new CRUDHandler().executeSelectStatement(sql_C1,
					CommonUtils.getConnection(), values);
			if (resultSet.next()) {
				M_DECIMAL = resultSet.getInt(1);
			} else {
				M_DECIMAL = 2;
			}

			if ("V".equals(P_VAL_ROUND)) {
				if (NumericFunctions.round(P_AMT, M_DECIMAL) != P_AMT) {
					//DISP_ALERT.DISP_ALERT(NAME_IN.NAME_IN("GLOBAL.M_LANG_CODE"));
					//throw new FORM_TRIGGER_FAILURE();
					throw new Exception();
				}
			} else {
				P_AMT = NumericFunctions.round(P_AMT, M_DECIMAL);
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
		return P_AMT;
	}
	
	public void whenValidateBankCode(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			String C1 = "SELECT DECODE(?,'ENG',BANK_NAME,BANK_NAME_BL) "
					+ "FROM   FM_BANK " + "WHERE  BANK_CODE= ? ";
			connection = CommonUtils.getConnection();
			if (PT_IL_DEPOSIT_BEAN.getDEP_BANKIN_CODE() != null) {
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] {
								CommonUtils.getControlBean().getM_LANG_CODE(),
								PT_IL_DEPOSIT_BEAN.getDEP_BANKIN_CODE() });
				if (resultSet.next()) {
					PT_IL_DEPOSIT_BEAN.setUI_M_BANKIN_NAME(resultSet
							.getString(1));
				} else {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Invalid Bank . Please re-enter.." }));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} 
	}
	
	public String buttonM_cheque(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN){
		Double M_PS_VALUE_DAYS = 0.0;
		String M_PS_CODE_DESC = null;
		String M_FLAG = "N";
		String M_POL_MODE_OF_PYMT = null;
		Date   M_DPD_CHQ_DT = null;
		String M_DPD_PAY_MODE = null;
		String outcome = null;
		String C1 = " SELECT POL_MODE_OF_PYMT FROM   PT_IL_POLICY" +
					" WHERE  POL_NO = ?";
		
		String C2 = " SELECT DPD_CHQ_DT,DPD_PAY_MODE    " +
				"  FROM   PT_IL_DEPOSIT_PYMT_DTLS" +
				"      WHERE  DPD_DEP_SYS_ID = ?" +
				"      AND    DPD_PAY_MODE = 'C'";
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try{
			connection = CommonUtils.getConnection();
			values = new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_REF_NO()};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				M_POL_MODE_OF_PYMT = resultSet.getString(1);
			}
			values = new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_SYS_ID()};
			resultSet1 = handler.executeSelectStatement(C2, connection,values);
			if(resultSet1.next()){
				M_DPD_CHQ_DT = resultSet1.getDate(1);
				M_DPD_PAY_MODE = resultSet1.getString(2);
			}
			 if("S".equals(M_POL_MODE_OF_PYMT) && "N".equals(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_PDC_FLAG(),"Y"))){
		      if("C".equals(M_DPD_PAY_MODE)&& (CommonUtils.nvl(M_PS_VALUE_DAYS,0) <= CommonUtils.subtractDate((new CommonUtils().getCurrentDate()),M_DPD_CHQ_DT))){
		    	   outcome = L_EXCESS_PREMIUM_REFUND(PT_IL_DEPOSIT_BEAN);
		      }   
			 }
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
		}
		return outcome;
	}
	
	public String L_EXCESS_PREMIUM_REFUND(PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN){
		String M_POL_MODE_OF_PYMT = null;
		Double M_PS_VALUE_TYPE = 0.0;
		Double M_PS_VALUE_LMT = 0.0;
		Double M_EXCESS_AMT = 0.0;
		Double M_PREM_AMT = 0.0;
		Long M_RTH_SYS_ID = null;
		Long M_POL_SYS_ID = null;
		String M_LIMIT_YN = "N";
		String M_PS_CODE_DESC = null;
		String M_POL_CUST_CURR_CODE = null;
		
		String C1 = "  SELECT POL_SYS_ID,POL_CUST_CURR_CODE,POL_MODE_OF_PYMT     FROM   PT_IL_POLICY " +
				" WHERE  POL_NO = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<OracleParameter> list1 = null;
		String outcome = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PT_IL_DEPOSIT_BEAN.getDEP_REF_NO()};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				M_POL_SYS_ID = resultSet.getLong(1);
				M_POL_CUST_CURR_CODE = resultSet.getString(2);
				M_POL_MODE_OF_PYMT =  resultSet.getString(3);
			}
			if("S".equals(M_POL_MODE_OF_PYMT) && "N".equals(CommonUtils.nvl(PT_IL_DEPOSIT_BEAN.getDEP_PDC_FLAG(),"Y"))){
				list = new DBProcedures().callP_VAL_SYSTEM("IL_TOLL_TYPE",
		                  								"IL_TOLL_TYPE",
		                  								M_PS_CODE_DESC,
		                  								"N",
		                  								CommonUtils.getProcedureValue(M_PS_VALUE_TYPE));
				if(!(list.isEmpty()) && list != null){
					if(list.get(0) != null){
						M_PS_CODE_DESC = list.get(0);
					}
					if(list.get(1) != null){
						M_PS_VALUE_TYPE = Double.parseDouble(list.get(1));
					}
				}
				list.clear();
				list = new DBProcedures().callP_VAL_SYSTEM("IL_TOLL_LMT",
		                  								"IL_TOLL_LMT",
		                  								M_PS_CODE_DESC,
		                  								"N",
		                  								CommonUtils.getProcedureValue(M_PS_VALUE_LMT));
				if(!(list.isEmpty()) && list != null){
					if(list.get(0) != null){
						M_PS_CODE_DESC = list.get(0);
					}
					if(list.get(1) != null){
						M_PS_VALUE_TYPE = Double.parseDouble(list.get(1));
					}
				}
				 if("G".equals(PT_IL_DEPOSIT_BEAN.getDEP_GROSS_NET_FLAG())){ 
			  	    M_EXCESS_AMT  = PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT() - PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM();
			  	    M_PREM_AMT    = PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_GROSS_PREM();
				 } else if("N".equals(PT_IL_DEPOSIT_BEAN.getDEP_GROSS_NET_FLAG())){ 
			  	 	  M_EXCESS_AMT  = PT_IL_DEPOSIT_BEAN.getDEP_LC_DEP_AMT() - PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_NET_PREM();
			  	 	  M_PREM_AMT    = PT_IL_DEPOSIT_BEAN.getUI_M_POL_LC_NET_PREM();
				 }
				 if(M_EXCESS_AMT > 0 ){ 

			  	    if(M_PS_VALUE_TYPE == 1){
			  	 	     if(M_EXCESS_AMT > ((CommonUtils.nvl(M_PS_VALUE_LMT,0) * M_PREM_AMT) / 100 )){
			  	 	        M_LIMIT_YN = "Y";
			  	 	     }
			  	    } else if(M_PS_VALUE_TYPE ==2){
			  	 	     if(M_EXCESS_AMT > (CommonUtils.nvl(M_PS_VALUE_LMT,0))){
			  	 	  	    M_LIMIT_YN = "Y";
			  	 	     }
			  	    }
				 }     
				 if("Y".equals(M_LIMIT_YN)){

					list = new PKG_PILT002_APAC().P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE,
													CommonUtils.getProcedureValue(M_EXCESS_AMT), 
													"R");
					if(!(list.isEmpty()) && list.get(0) != null){
						M_EXCESS_AMT = Double.parseDouble(list.get(0));
					}
		  	 	    list1 = new P9ILPK_RECEIPT_TRANSFER().INS_RECEIPT_EXCESS_PREM(M_POL_SYS_ID,
		  	 	    					PT_IL_DEPOSIT_BEAN.getDEP_REF_NO(),
		  	 	    					M_RTH_SYS_ID,
		  	 	    					M_EXCESS_AMT);
		  	 	    if(!(list1.isEmpty()) && list1 != null){
		  	 	    	M_RTH_SYS_ID = Long.parseLong(list1.get(0).getValue());
		  	 	    }	
		  	 	     	
		  	 	 new P9ILPK_RECEIPT_TRANSFER().APPROVE_EXCESS_REFUND(M_RTH_SYS_ID);
		  	 
		    
	  	 	CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",PT_IL_DEPOSIT_BEAN.getDEP_REF_NO());
	     	CommonUtils.setGlobalVariable("GLOBAL.M_DEP_TYPE",PT_IL_DEPOSIT_BEAN.getDEP_TYPE());
	     	outcome = "payVoucherHeader";
	     	CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",null);
	     	CommonUtils.setGlobalVariable("GLOBAL.M_DEP_TYPE",null);
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		
		return outcome;
	}
	
	
	public void PRE_INSERT(IP_REP_INFO iP_REP_INFO_BEAN) {

		try {

			iP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			iP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			iP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			iP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			iP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			iP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/*Added by Janani on 12.9.2016 for dynamic report config*/
	
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		System.out.println("******* Enter the print helper  WHEN_BUTTON_PRESSED_M_BUT_OK ******** ");
		String url = null;
			
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		/*url = request.getContextPath() + "/ReportServlet?";*/
		url = request.getContextPath() + "/PREMIASchedule?";
		System.out.println("url   :  "+url);
	return url;	
	}

	/*Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion*/
	public int doGetPolicySysId(String dep_REF_NO) {
		CRUDHandler handler = new CRUDHandler();
		String query ="select pol_sys_id from pt_il_policy where pol_no =?"; 
		int pol_Sys_id = 0;
		ResultSet rs = null;
		try{
			ResultSet resultSet = handler.executeSelectStatement(query,
					CommonUtils.getConnection(), new Object[] {dep_REF_NO});
			if(resultSet.next()){
				pol_Sys_id = resultSet.getInt(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return pol_Sys_id;
	}
	

	public String doGetPdd_SysId(int pol_Sys_id) {
		CRUDHandler handler = new CRUDHandler();
		String query ="SELECT NVL(MAX(PDD_STATUS),'DP03') FROM PT_IL_POL_DISPATCH_DTLS WHERE PDD_POL_SYS_ID =?"; 
		ResultSet rs = null;
		String pdd_Sys_id = null;
		try{
			ResultSet resultSet = handler.executeSelectStatement(query,
					CommonUtils.getConnection(), new Object[] {pol_Sys_id});
			if(resultSet.next()){
				pdd_Sys_id = resultSet.getString(1);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return pdd_Sys_id;
	}
	/*End Newly added by pidugu raj dt: 26-11-2018 as per anbarasi suggestion*/
	
	/*Newly added by pidugu raj dt:27-07-2020 as suggested by kk*/
	public String doGetPolicyStatus(String dep_REF_NO) {
		CRUDHandler handler = new CRUDHandler();
		String query ="SELECT POL_STATUS FROM PT_IL_POLICY WHERE POL_NO = ?";
		String pol_status = null;
		ResultSet rs = null;
		try{
			ResultSet resultSet = handler.executeSelectStatement(query,
					CommonUtils.getConnection(), new Object[] {dep_REF_NO});
			if(resultSet.next()){
				pol_status = resultSet.getString("POL_STATUS");
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return pol_status;
	}
	
	public int doGetPolicyEndorsementNoIdx(String dep_REF_NO) {
		CRUDHandler handler = new CRUDHandler();
		String query ="SELECT NVL(POL_END_NO_IDX,?)  FROM PT_IL_POLICY WHERE POL_NO = ?";
		int pol_end_no_idx = 0;
		ResultSet rs = null;
		try{
			ResultSet resultSet = handler.executeSelectStatement(query,
					CommonUtils.getConnection(), new Object[] {pol_end_no_idx,dep_REF_NO});
			if(resultSet.next()){
				pol_end_no_idx = resultSet.getInt(1);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		return pol_end_no_idx;
	}
	/*End Newly added by pidugu raj dt:27-07-2020 as suggested by kk*/
	
	}
