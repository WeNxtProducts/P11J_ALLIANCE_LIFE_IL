package com.iii.pel.forms.PILP004;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_PROCESS;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class MATURITY_HELPER {
	CommonUtils commonUtils = new CommonUtils();
	CRUDHandler handler = new CRUDHandler();
	P9ILPK_PROCESS p9ilpk_process = new P9ILPK_PROCESS();
	PKG_PILP004 pkg_pilp004 = new PKG_PILP004();

	public void WHEN_CREATE_RECORD(MATURITY maturity) throws Exception {
		maturity.setUI_M_POL_DT_FM(commonUtils.getCurrentDate());
		maturity.setUI_M_POL_DT_TO(commonUtils.getCurrentDate());

	}

	public void WHEN_VALIDATE_M_POL_NO_FM(String UI_M_POL_NO_FM,String UI_M_POL_NO_TO) throws Exception {
		try {
			
			UI_M_POL_NO_FM = (String) commonUtils.SET_REP_FIRST_FIELD(UI_M_POL_NO_FM, "String");
			WHEN_VALIDATE_M_POL_NO_TO(UI_M_POL_NO_FM, UI_M_POL_NO_TO);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_M_POL_NO_TO(String UI_M_POL_NO_FM,
			String UI_M_POL_NO_TO) throws Exception {
		try {
			if (UI_M_POL_NO_TO != null) {
				UI_M_POL_NO_TO = (String) commonUtils.SET_REP_SECOND_FIELD(UI_M_POL_NO_FM, UI_M_POL_NO_TO, "String");
				if (UI_M_POL_NO_FM.compareTo(UI_M_POL_NO_TO) > 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71144",new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_VALIDATE_M_POL_DT_TO(Date UI_M_POL_DT_FM,
			Date UI_M_POL_DT_TO) throws Exception {

		try {
			if (UI_M_POL_DT_FM.after(UI_M_POL_DT_TO)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71145",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public String WHEN_VALIDATE_ITEM_M_COPY_OK(DUMMY dummy_bean,
			MATURITY_ACTION maturity_action_bean) throws Exception {
		MATURITY maturity_bean = maturity_action_bean.getMATURITY_BEAN();
		String M_DUMMY = null;
	String PROD_SA_INST_PYMT_TYPE=null;
		String pt_il_process = null;
		int M_PS_VALUE = 0;
		ResultSet resultSetC00 = null;
		ResultSet resultSetC0 = null;
		ResultSet resultSetC01 = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		ResultSet resultSetC4 = null;
		ResultSet resultSetC5 = null;
		
		ArrayList<OracleParameter> list = null;
		Connection connection = null;
		String matType = null;
		String C1 = "  SELECT PS_VALUE " + " FROM   PP_SYSTEM "
				+ " WHERE  PS_TYPE = 'IL_CALC_MTHD' ";
		String C2 = " SELECT 'X' "
				+ " FROM PT_IL_PROCESS WHERE PR_PROCESS_TYPE='M' ";
		String delquery = "  DELETE FROM PT_IL_PROCESS WHERE PR_PROCESS_TYPE='M' ";
		String deleteLog = "DELETE FROM PT_IL_BATCH_PROC_ERROR";
		String message = null;
		String matDateType = "SELECT PROD_MATU_DT FROM PM_IL_PRODUCT WHERE PROD_CODE = (SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = ?)";
		String validateO ="SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = ? AND POL_EXPIRY_DT NOT BETWEEN ? AND ? ";
		String validateS ="SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO = ? AND POL_EXPIRY_DT+1 NOT BETWEEN ? AND ? ";
		String fallDate = "SELECT 'X' FROM PT_IL_POLICY WHERE ((POL_EXPIRY_DT BETWEEN ? AND ?) OR ((POL_EXPIRY_DT+1) "
						  +"BETWEEN ? AND ?)) AND POL_NO = ?";
		String C3 = "SELECT 'X' FROM PT_IL_POLICY, PM_IL_PLAN, PM_IL_SA_INST_PYMT "
					 +"WHERE PLAN_CODE = SIP_PLAN_CODE AND POL_PROD_CODE = SIP_PROD_CODE "
					 +"AND NVL(PLAN_SA_INST_PYMT_YN, 'N') = 'Y' AND POL_NO BETWEEN NVL(?, '0') AND "
					 +"NVL(?, 'ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ') "
					 +" AND DECODE(ADD_MONTHS(POL_START_DT,(POL_PERIOD * SIP_NUMR_PERIOD /SIP_DEMR_PERIOD) * 12), "
                     +"POL_EXPIRY_DT + 1,POL_EXPIRY_DT, "
                     +"ADD_MONTHS(POL_START_DT,(POL_PERIOD * SIP_NUMR_PERIOD /SIP_DEMR_PERIOD) * 12)) BETWEEN ? AND "
                     +"? AND NVL(POL_APPRV_STATUS, 'N') = 'A' AND NVL(POL_STATUS, 'X') NOT IN "
                     +"('S', 'M', 'N', 'D', 'C', 'F', 'L') "
                     +"AND POL_PLAN_CODE IN (SELECT PLAN_CODE FROM PM_IL_PLAN "
                     +"WHERE NVL(PLAN_PYMT_ON_MAT_YN, 'N') = 'Y')";
		
		
	String C4=" SELECT 'X' FROM pt_il_policy, pm_il_plan, pt_il_pol_sa_inst_pymt WHERE plan_code = pol_plan_code "+
	        " AND pol_sys_id = sipd_pol_sys_id AND (NVL(plan_sa_inst_pymt_yn, 'N') = 'Y' OR "+
	        " sipd_nav_type IN ('I', 'B', 'D'))  AND pol_no BETWEEN NVL(?, '0') AND NVL(?, 'ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ')"+
	        " AND DECODE(ADD_MONTHS(pol_start_dt,(pol_period - sipd_numr_period) * 12), pol_expiry_dt,  pol_expiry_dt, "+
	     "  ADD_MONTHS(pol_start_dt,(pol_period - sipd_numr_period) * 12)) - 1 BETWEEN  ? AND ?  "+
	        " AND NVL(pol_apprv_status, 'N') = 'A' AND NVL(pol_status, 'X') NOT IN ('S', 'M', 'N', 'D', 'C') "+
	         " AND pol_plan_code IN (SELECT plan_code FROM pm_il_plan WHERE NVL(plan_pymt_on_mat_yn, 'N') = 'Y') "+
	       "  AND pol_sys_id NOT IN (SELECT pr_pol_sys_id FROM pt_il_process  WHERE pr_process_type = 'M')";
		
		String C5="SELECT PROD_SA_INST_PYMT_TYPE FROM   PM_IL_PRODUCT "+
         " WHERE  PROD_CODE IN (   SELECT POL_PROD_CODE FROM   PT_IL_POLICY "+
                  " WHERE  POL_NO BETWEEN NVL (?, POL_NO) AND NVL (?, POL_NO)) ";

		try {
			connection = CommonUtils.getConnection();
			resultSetC1 = handler.executeSelectStatement(C1, connection);
			// added for date validation
			if (maturity_bean.getUI_M_POL_NO_FM().equalsIgnoreCase(
					maturity_bean.getUI_M_POL_NO_FM())) {
				resultSetC00 = handler.executeSelectStatement(fallDate,
						connection, new Object[] {
								maturity_bean.getUI_M_POL_DT_FM(),
								maturity_bean.getUI_M_POL_DT_TO(),
								maturity_bean.getUI_M_POL_DT_FM(),
								maturity_bean.getUI_M_POL_DT_TO(),
								maturity_bean.getUI_M_POL_NO_FM()});
				if (resultSetC00.next()) {
					resultSetC01 = handler.executeSelectStatement(matDateType,
							connection, new Object[] { maturity_bean
									.getUI_M_POL_NO_FM() });
					if (resultSetC01.next()) {
						matType = resultSetC01.getString(1);
					}
				}
					/*
					 * COMMENTED BY AMEEN ON 24-11-2017 FOR UAT MATURITY SAME DATE ISSUE
					 * if ("O".equalsIgnoreCase(matType)) {
						resultSetC0 = handler.executeSelectStatement(validateO,
								connection, new Object[] {
										maturity_bean.getUI_M_POL_NO_FM(),
										maturity_bean.getUI_M_POL_DT_FM(),
										maturity_bean.getUI_M_POL_DT_TO() });
						if (resultSetC0.next()) {
							throw new Exception(
									"Policy Expiry date is not Between Maturity From and To Date");
						}
					} else if ("S".equalsIgnoreCase(matType)) {
						resultSetC0 = handler.executeSelectStatement(validateS,
								connection, new Object[] {
										maturity_bean.getUI_M_POL_NO_FM(),
										maturity_bean.getUI_M_POL_DT_FM(),
										maturity_bean.getUI_M_POL_DT_TO() });
						if (resultSetC0.next()) {
							throw new Exception(
									"Policy Expiry date is not Between Maturity From and To Date");
						}
					}*/
				if (matType != null && CommonUtils.isIN(matType, "O","S")) {
					resultSetC0 = handler.executeSelectStatement(validateO,
							connection, new Object[] {
									maturity_bean.getUI_M_POL_NO_FM(),
									maturity_bean.getUI_M_POL_DT_FM(),
									maturity_bean.getUI_M_POL_DT_TO() });
					if (resultSetC0.next()) {
						throw new Exception(
								"Policy Expiry date is not Between Maturity From and To Date");
					}
				}
				 else {
					resultSetC5 = handler.executeSelectStatement(C5,
							connection, new Object[] {
									maturity_bean.getUI_M_POL_NO_FM(),
									maturity_bean.getUI_M_POL_NO_TO()
									});
					if (resultSetC5.next()) {
						
						PROD_SA_INST_PYMT_TYPE=resultSetC5.getString(1);
						}
//					if("A".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE))
					/*if(5<=1){
					resultSetC3 = handler.executeSelectStatement(C3,
							connection, new Object[] {
									maturity_bean.getUI_M_POL_NO_FM(),
									maturity_bean.getUI_M_POL_NO_TO(),
									maturity_bean.getUI_M_POL_DT_FM(),
									maturity_bean.getUI_M_POL_DT_TO() });
					if (!resultSetC3.next()) {
						throw new Exception(
								"Survival Maturity Date is not Between Maturity From and To Date");
						}
					}else if(5<=1){
//					else if("B".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)||"D".equalsIgnoreCase(PROD_SA_INST_PYMT_TYPE)){
						resultSetC4 = handler.executeSelectStatement(C4,
								connection, new Object[] {
										maturity_bean.getUI_M_POL_NO_FM(),
										maturity_bean.getUI_M_POL_NO_TO(),
										maturity_bean.getUI_M_POL_DT_FM(),
										maturity_bean.getUI_M_POL_DT_TO() });
						System.out.println(maturity_bean.getUI_M_POL_NO_FM().toString());
						System.out.println(maturity_bean.getUI_M_POL_NO_TO().toString());
						System.out.println(maturity_bean.getUI_M_POL_DT_FM().toString());
						System.out.println(maturity_bean.getUI_M_POL_DT_TO().toString());
						if (!resultSetC4.next()) {
							ResultSetMetaData rsmd = resultSetC4.getMetaData();
							int columnsNumber = rsmd.getColumnCount();
							while (resultSetC4.next()) {
							    for (int i = 1; i <= columnsNumber; i++) {
							        if (i > 1) System.out.print(",  ");
							        String columnValue = resultSetC4.getString(i);
							        System.out.print(columnValue + " " + rsmd.getColumnName(i));
							    }
							    System.out.println("");
							}
							
							
							throw new Exception(
									"Survival Maturity Date is not Between Maturity From and To Date");
							}
					}*/
				}
			}
			// date validation ends
			if (resultSetC1.next()) {
				M_PS_VALUE = resultSetC1.getInt(1);
			}
			handler.executeDeleteStatement(delquery, connection);
			handler.executeDeleteStatement(deleteLog, connection);
			pkg_pilp004.L_CHECK_DOC_SETUP(maturity_bean.getUI_M_POL_NO_FM(),
					maturity_bean.getUI_M_POL_NO_TO(), CommonUtils
							.getProcedureValue(maturity_bean
									.getUI_M_POL_DT_FM()), CommonUtils
							.getProcedureValue(maturity_bean
									.getUI_M_POL_DT_TO()), CommonUtils
							.getProcedureValue(M_PS_VALUE),
							 CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2")  );
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] {});
			while (resultSetC2.next()) {
				M_DUMMY = resultSetC2.getString(1);
			}
			if ("X".equals(CommonUtils.nvl(M_DUMMY, "N"))) {
				pt_il_process = "PILP004_PT_IL_PROCESS";
			}
			
			//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
			
			if (M_PS_VALUE == 1 || M_PS_VALUE == 2) {
				
				
				list = new ArrayList<OracleParameter>();

				list = p9ilpk_process.CALC_PART_MAT_AMT(maturity_bean
						.getUI_M_POL_NO_FM(),
						maturity_bean.getUI_M_POL_NO_TO(), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_FM()), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_TO()), dummy_bean
								.getUI_M_FLAG_2(), CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_2"));
				dummy_bean.setUI_M_FLAG_2(list.get(0).getValue());
				

				list = new ArrayList<OracleParameter>();
				list = p9ilpk_process.CALC_MAT_AMT(maturity_bean
						.getUI_M_POL_NO_FM(),
						maturity_bean.getUI_M_POL_NO_TO(), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_FM()), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_TO()), dummy_bean
								.getUI_M_FLAG_1(), CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_2"));
				dummy_bean.setUI_M_FLAG_1(list.get(0).getValue());

				
				/*
				list = p9ilpk_process.CALC_MAT_AMT_TIBB(maturity_bean
						.getUI_M_POL_NO_FM(),
						maturity_bean.getUI_M_POL_NO_TO(), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_FM()), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_TO()), dummy_bean
								.getUI_M_FLAG_1(), CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_2"));
				dummy_bean.setUI_M_FLAG_1((String)list.get(0).getValueObject());

				list = new ArrayList<OracleParameter>();
				list = p9ilpk_process.CALC_PART_MAT_AMT(maturity_bean
						.getUI_M_POL_NO_FM(),
						maturity_bean.getUI_M_POL_NO_TO(), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_FM()), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_TO()), dummy_bean
								.getUI_M_FLAG_2(), CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_2"));
				dummy_bean.setUI_M_FLAG_2((String)list.get(0).getValueObject());
			*/} else {
				list = new ArrayList<OracleParameter>();
				list = p9ilpk_process.CALC_MAT_AMT(maturity_bean
						.getUI_M_POL_NO_FM(),
						maturity_bean.getUI_M_POL_NO_TO(), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_FM()), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_TO()), dummy_bean
								.getUI_M_FLAG_1(), CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_2"));
				dummy_bean.setUI_M_FLAG_1(list.get(0).getValue());

				list = new ArrayList<OracleParameter>();

				list = p9ilpk_process.CALC_PART_MAT_AMT(maturity_bean
						.getUI_M_POL_NO_FM(),
						maturity_bean.getUI_M_POL_NO_TO(), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_FM()), CommonUtils
								.getProcedureValue(maturity_bean
										.getUI_M_POL_DT_TO()), dummy_bean
								.getUI_M_FLAG_2(), CommonUtils
								.getGlobalVariable("GLOBAL.M_PARAM_2"));
				dummy_bean.setUI_M_FLAG_2(list.get(0).getValue());
			}
			if ("Y".equals(CommonUtils.nvl(dummy_bean.getUI_M_FLAG_1(), "N"))
					|| "Y".equals(CommonUtils.nvl(dummy_bean.getUI_M_FLAG_2(),
							"N"))) {
				maturity_action_bean.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Successfully Completed");
				maturity_action_bean.getWarningMap().put("Process", "Process Successfully Completed");
				/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3083"));*/
			}else{
				/*if (!"X".equalsIgnoreCase(CommonUtils.nvl(M_DUMMY, "N"))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91130", new Object[]{maturity_bean.getUI_M_POL_DT_FM(),maturity_bean.getUI_M_POL_DT_TO()}));
				}*/
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
				CommonUtils.closeCursor(resultSetC2);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
		return pt_il_process;
	}
	public void chkpolNO(String polno)throws Exception{
		
		long M_polsysid = 0;
		String VALUE=null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		Connection connection = null;
		CRUDHandler handler=new CRUDHandler();
		String C1="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO LIKE ? ";
		
		String C2 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_SYS_ID = ? AND (POL_ADDL_STATUS IN ('D01', 'D02', 'D03') "
				+ "OR POL_APPRV_STATUS = 'N' "
				+ "OR POL_STATUS IN ('P', 'S', 'D', 'M', 'C', 'L'))";
		

		try {
			connection = CommonUtils.getConnection();
			resultSetC1 = handler.executeSelectStatement(C1, connection, new Object[]{polno});
			if (resultSetC1.next()) {
				M_polsysid = resultSetC1.getInt(1);
			}
		
			resultSetC2 = handler.executeSelectStatement(C2, connection, new Object[]{M_polsysid});
			if (resultSetC2.next()) {
				VALUE = resultSetC2.getString(1);
				throw new Exception("Please enter valid policy no.");
			}
			/*if("M".equalsIgnoreCase(smvtype)){
				throw new Exception("Please enter valid policy no.");
			}*/
				
			}catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	
}


