package com.iii.pel.forms.PILT009;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PILT009_PROCEDURE {
	
	public void L_UPD_DEL_FLAG() throws Exception {
		String sql_C1 = "SELECT MAX(FO_SYS_ID) FROM PT_IL_FAC_OUT " +
				"WHERE FO_COVER_CODE NOT IN (SELECT   POL_PLAN_CODE " +
				"FROM   PT_IL_POLICY " +
				"WHERE  POL_SYS_ID = ? " +
				"UNION ALL " +
				"SELECT POAC_COVER_CODE " +
				"FROM   PT_IL_POLICY,PT_IL_POL_ADDL_COVER " +
				"WHERE  POL_SYS_ID = ? " +
				"AND    POAC_POL_SYS_ID = POL_SYS_ID) " +
				"AND  FO_POL_SYS_ID = ?";
		
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		Long M_FO_POL_SYS_ID = dummyBean.getUI_M_FO_POL_SYS_ID();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst_C1 = null;
		int ROWCOUNT = 0;
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_FO_POL_SYS_ID, M_FO_POL_SYS_ID, M_FO_POL_SYS_ID});
			Double M_FO_SYS_ID = null;
			while(rst_C1.next()){
				M_FO_SYS_ID = rst_C1.getDouble(1);
			}
			if(M_FO_SYS_ID!=null){
				String sql_C2 = "UPDATE PT_IL_FAC_OUT " +
						"SET    FO_DEL_FLAG = 'Y' " +
						"WHERE  FO_SYS_ID   = ?";
				
				ROWCOUNT += handler.executeUpdateStatement(sql_C2, connection, new Object[]{M_FO_SYS_ID});
				
				String sql_C3 = "UPDATE PT_IL_FAC_DETL " +
						"SET FD_DEL_FLAG    = 'Y' " +
						"WHERE FD_FO_SYS_ID = ?";
				
				ROWCOUNT += handler.executeUpdateStatement(sql_C3, connection, new Object[]{M_FO_SYS_ID});
				
				String sql_C4 = "UPDATE PT_IL_FAC_PART_CUST " +
						"SET FPCU_DEL_FLAG    = 'Y' " +
						"WHERE FPCU_FO_SYS_ID = ?";
				
				ROWCOUNT += handler.executeUpdateStatement(sql_C4, connection, new Object[]{M_FO_SYS_ID});
				
				String sql_C5 = "UPDATE PT_IL_FAC_PART_CUST_DETL " +
						"SET FPCUD_DEL_FLAG    = 'Y' " +
						"WHERE FPCUD_FO_SYS_ID = ?";
				
				ROWCOUNT += handler.executeUpdateStatement(sql_C5, connection, new Object[]{M_FO_SYS_ID});
				
				String sql_C6 = "UPDATE PT_IL_FAC_CUST_RETRO " +
						"SET FCR_DEL_FLAG    = 'Y' " +
						"WHERE FCR_FO_SYS_ID = ?";
				
				ROWCOUNT += handler.executeUpdateStatement(sql_C6, connection, new Object[]{M_FO_SYS_ID});
				
				String sql_C7 = "UPDATE PT_IL_FAC_CUST_RETRO_DETL " +
						"SET FCRD_DEL_FLAG    = 'Y' " +
						"WHERE FCRD_FCR_SYS_ID IN (" +
						"SELECT FCR_SYS_ID " +
						"FROM   PT_IL_FAC_CUST_RETRO " +
						"WHERE  FCR_FO_SYS_ID = ?)";
				
				ROWCOUNT += handler.executeUpdateStatement(sql_C7, connection, new Object[]{M_FO_SYS_ID});
				if(ROWCOUNT > 0)
				{
				facOutAction.getWarningMap().put("current", ROWCOUNT+" record(s) updated.");
				facOutAction.setWarningMessages(ROWCOUNT+" record(s) updated.");
			}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
			}catch(Exception e){
			}
		}
	}
	
	public void L_INSERT_FAC_OUT_RISK() throws Exception {
		PILT009_COMPOSITE_ACTION compositeAction = (PILT009_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PILT009_COMPOSITE_ACTION");
		PT_IL_FAC_OUT_ACTION facOutAction = compositeAction.getPILT009_PT_IL_FAC_OUT_ACTION();
		DUMMY dummyBean = facOutAction.getDUMMY_BEAN();
		Long M_FO_POL_SYS_ID = dummyBean.getUI_M_FO_POL_SYS_ID();
		Long M_PC_SYS_ID = dummyBean.getUI_M_PC_SYS_ID();
		String M_PREM_TYPE = dummyBean.getUI_M_PREM_TYPE();
		String M_PLAN_TYPE = dummyBean.getUI_M_PLAN_TYPE();
		String M_POL_CUST_CURR_CODE = dummyBean.getUI_M_POL_CUST_CURR_CODE();
		Double M_POL_CUST_CURR_RATE = dummyBean.getUI_M_POL_CUST_CURR_RATE();
		Double M_SI_CURR_RATE = dummyBean.getUI_M_SI_CURR_RATE();
		Date M_SCHD_DT = dummyBean.getUI_M_SCHD_DT();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst_C1 = null;
		ResultSet rst_C2 = null;
		int ROWCOUNT = 0;
		
		try {
			connection = CommonUtils.getConnection();
			String sql_C1 = "SELECT 'X' " +
					"FROM   PT_IL_FAC_DETL,PT_IL_FAC_OUT " +
					"WHERE  FD_FO_SYS_ID    = FO_SYS_ID " +
					"AND    FO_POL_SYS_ID   = ? " +
					"AND    FO_PC_SYS_ID	= ?";
			String sql_C2 = "SELECT POL_RI_POOL_CODE " +
					"FROM   PT_IL_POLICY " +
					"WHERE  POL_SYS_ID = ?";
			String M_DUMMY=null;
			String M_POL_RI_POOL_CODE = null;
			
			try {
				rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{M_FO_POL_SYS_ID, M_PC_SYS_ID});
				while(rst_C1.next()){
					M_DUMMY = rst_C1.getString(1);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				throw new ValidatorException(new FacesMessage(e1.getMessage()));
			}
			
			if(M_DUMMY!=null){
				new PT_IL_FAC_OUT_HELPER().fetchRecord(compositeAction);
			}else{
				String M_SCHD_STR = CommonUtils.dateToStringFormatter(M_SCHD_DT);
				try {
					P9ILPK_FAC_ALLOC_P_GEN_FAC_OUT(connection, M_FO_POL_SYS_ID+"", M_PC_SYS_ID+"", M_PREM_TYPE, M_PLAN_TYPE, M_POL_CUST_CURR_CODE, M_POL_CUST_CURR_RATE+"", M_SI_CURR_RATE+"", M_SCHD_STR);
				} catch (Exception e) {
					e.printStackTrace();
					ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), "PT_IL_FAC_OUT", facOutAction.getErrorMap(), facOutAction.getWarningMap());
					String errorMessage = facOutAction.getErrorMap().get("current");
					if(errorMessage!=null){
						throw new ValidatorException(new FacesMessage(errorMessage));
					}else{
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
				new PT_IL_FAC_OUT_HELPER().fetchRecord(compositeAction);
			}
			
			List<PT_IL_FAC_OUT> dataListPT_IL_FAC_OUT = facOutAction.getDataListPT_IL_FAC_OUT();
			for(PT_IL_FAC_OUT facOutBean: dataListPT_IL_FAC_OUT){
				String FO_COVER_CODE = facOutBean.getFO_COVER_CODE();
				if(FO_COVER_CODE!=null){
					try {
						rst_C2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{M_FO_POL_SYS_ID});
						while(rst_C2.next()){
							M_POL_RI_POOL_CODE = rst_C2.getString(1);
						}
					} catch (Exception e) {
						e.printStackTrace();
						throw new ValidatorException(new FacesMessage(e.getMessage()));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst_C1);
				CommonUtils.closeCursor(rst_C2);
			}catch(Exception e){
			}
		}
	}
	
	public void P9ILPK_FAC_ALLOC_P_GEN_FAC_OUT(Connection connection, String M_FO_POL_SYS_ID,
							String M_PC_SYS_ID,
							String M_PREM_TYPE,
							String M_PLAN_TYPE,
							String M_POL_CUST_CURR_CODE,
							String M_POL_CUST_CURR_RATE,
							String M_SI_CURR_RATE,
							String M_SCHD_DT) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", M_FO_POL_SYS_ID);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN", M_PC_SYS_ID);
		OracleParameter param3 = new OracleParameter("in3","STRING","IN", M_PREM_TYPE);
		OracleParameter param4 = new OracleParameter("in4","STRING","IN", M_PLAN_TYPE);
		OracleParameter param5 = new OracleParameter("in5","STRING","IN", M_POL_CUST_CURR_CODE);
		OracleParameter param6 = new OracleParameter("in3","STRING","IN", M_POL_CUST_CURR_RATE);
		OracleParameter param7 = new OracleParameter("in4","STRING","IN", M_SI_CURR_RATE);
		OracleParameter param8 = new OracleParameter("in5","STRING","IN", M_SCHD_DT);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		parameterList.add(param6);
		parameterList.add(param7);
		parameterList.add(param8);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection, "P9ILPK_FAC_ALLOC.P_GEN_FAC_OUT");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void P9ILPK_FAC_ALLOC_P_INS_FAC_PART_CHRG(Connection connection, String FPCUD_SYS_ID, 
			String FO_SYS_ID, 
			String FPCU_CUST_CODE) throws Exception {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", FPCUD_SYS_ID);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN", FO_SYS_ID);
		OracleParameter param3 = new OracleParameter("in3","STRING","IN", FPCU_CUST_CODE);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try {
			handler.execute(parameterList, connection, "P9ILPK_FAC_ALLOC.P_INS_FAC_PART_CHRG");
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void P9ILPK_RI_ALLOC_P_APPRV_FAC(Connection connection, 
						String P_POL_SYS_ID, 
						String P_PC_SYS_ID, 
						String P_PC_SCHD_DATE, 
						String P_FAC_YN, 
						String P_POL_END_FLAG) throws ValidatorException {
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN", P_POL_SYS_ID);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN", P_PC_SYS_ID);
		OracleParameter param3 = new OracleParameter("in3","STRING","IN", P_PC_SCHD_DATE);
		OracleParameter param4 = new OracleParameter("in4","STRING","IN", P_FAC_YN);
		OracleParameter param5 = new OracleParameter("in5","STRING","IN", P_POL_END_FLAG);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		parameterList.add(param4);
		parameterList.add(param5);
		OracleProcedureHandler handler = new OracleProcedureHandler();
		try{
			handler.execute(parameterList, connection, "P9ILPK_RI_ALLOC.P_APPRV_FAC");
		}catch(Exception se){
			throw new ValidatorException(new FacesMessage(se.getMessage()));
		}
	}
}
