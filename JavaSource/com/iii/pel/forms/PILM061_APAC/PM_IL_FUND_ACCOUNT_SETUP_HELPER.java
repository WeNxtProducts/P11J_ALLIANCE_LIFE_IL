package com.iii.pel.forms.PILM061_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.validator.ValidatorException;

import com.adventnet.swissql.b.a.ac.p;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_FUND_ACCOUNT_SETUP_HELPER {

	
	public void L_CHECK_SEQ_NO(PM_IL_FUND_ACCOUNT_SETUP_ACTION action)throws Exception{
		PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN = action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
		try{
			String query = "SELECT  nvl(MAX(FAS_SEQ_NO),0)+1 FROM PM_IL_FUND_ACCOUNT_SETUP " +
			" WHERE FAS_DRCR_FLAG=?" +
			"   AND (? BETWEEN FAS_SRC_BUS_FM AND FAS_SRC_BUS_TO " + // 
			"    OR ? BETWEEN FAS_SRC_BUS_FM AND FAS_SRC_BUS_TO " +
			"    OR FAS_SRC_BUS_FM BETWEEN ? AND ?" +
			"    OR FAS_SRC_BUS_TO BETWEEN ? AND ?)" +
			"   AND (? BETWEEN FAS_DIVN_FM_CODE AND FAS_DIVN_TO_CODE " +
			"    OR ? BETWEEN FAS_DIVN_FM_CODE AND FAS_DIVN_TO_CODE " +
			"    OR FAS_DIVN_FM_CODE BETWEEN ? AND ? " +
			"    OR FAS_DIVN_TO_CODE BETWEEN ? AND ?) " +
			"   AND (? BETWEEN FAS_DEPT_FM_CODE AND FAS_DEPT_TO_CODE " +
			"    OR ? BETWEEN FAS_DEPT_FM_CODE AND FAS_DEPT_TO_CODE" +
			"    OR FAS_DEPT_FM_CODE BETWEEN ? AND ? " +
			"    OR FAS_DEPT_TO_CODE BETWEEN ? AND ?) " +
			"   AND (NVL(LPAD(?,12,'0'),'0') BETWEEN NVL(LPAD(FAS_DOC_FM_TYPE,12,'0'),'0') AND NVL(LPAD(FAS_DOC_TO_TYPE,12,'Z'),'Z') " +
			"    OR NVL(LPAD(?,12,'Z'),'Z') BETWEEN NVL(LPAD(FAS_DOC_FM_TYPE,12,'0'),'0') AND NVL(LPAD(FAS_DOC_TO_TYPE,12,'Z'),'Z') " +
			"    OR NVL(LPAD(FAS_DOC_FM_TYPE,12,'0'),'0') BETWEEN NVL(LPAD(?,12,'0'),'0') AND NVL(LPAD(?,12,'Z'),'Z') " +
			"    OR NVL(LPAD(FAS_DOC_TO_TYPE,12,'Z'),'Z') BETWEEN NVL(LPAD(?,12,'0'),'0') AND NVL(LPAD(?,12,'Z'),'Z')) " +
			"   AND (? = FAS_SETUP_FOR) " +
			"   AND (NVL(?,'0') BETWEEN NVL(FAS_PROD_CODE_FM,'0') AND NVL(FAS_PROD_CODE_TO,'0') " +
			"    OR NVL(?,'0') BETWEEN NVL(FAS_PROD_CODE_FM,'0') AND NVL(FAS_PROD_CODE_TO,'0') " +
			"    OR NVL(FAS_PROD_CODE_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'0') " +
			"    OR NVL(FAS_PROD_CODE_TO,'0') BETWEEN NVL(?,'0') AND NVL(?,'0')) " +
			"   AND (NVL(?,'0') BETWEEN NVL(FAS_FUND_CODE_FM,'0') AND NVL(FAS_FUND_CODE_TO,'0') " +
			"    OR NVL(?,'0') BETWEEN NVL(FAS_FUND_CODE_FM,'0') AND NVL(FAS_FUND_CODE_TO,'0') " +
			"    OR NVL(FAS_FUND_CODE_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'0') " +
			"    OR NVL(FAS_FUND_CODE_TO,'0') BETWEEN NVL(?,'0') AND NVL(?,'0'))" +
			"   AND (NVL(?,0) BETWEEN NVL(FAS_POL_YR_FM,0) AND NVL(FAS_POL_YR_TO,9999)" +
			"    OR NVL(?,9999) BETWEEN NVL(FAS_POL_YR_FM,0) AND NVL(FAS_POL_YR_TO,9999)  " +
			"    OR NVL(FAS_POL_YR_FM,0)   BETWEEN NVL(?,0) AND NVL(?,9999) " +
			"    OR NVL(FAS_POL_YR_TO,9999) BETWEEN NVL(?,0) AND NVL(?,9999))";

			PreparedStatement pstmt = CommonUtils.getConnection().prepareStatement(query);
			pstmt.setString(1, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DRCR_FLAG());
			pstmt.setString(2, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_FM());
			pstmt.setString(3, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_TO());
			pstmt.setString(4, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_FM());
			pstmt.setString(5, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_TO());
			pstmt.setString(6, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_FM());
			pstmt.setString(7, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_TO());
			pstmt.setString(8, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_FM_CODE());
			pstmt.setString(9, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_TO_CODE());
			pstmt.setString(10, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_FM_CODE());
			pstmt.setString(11, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_TO_CODE());
			pstmt.setString(12, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_FM_CODE());
			pstmt.setString(13, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_TO_CODE());
			pstmt.setString(14, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_FM_CODE());
			pstmt.setString(15, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_TO_CODE());
			pstmt.setString(16, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_FM_CODE());
			pstmt.setString(17, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_TO_CODE());
			pstmt.setString(18, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_FM_CODE());
			pstmt.setString(19, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_TO_CODE());
			pstmt.setString(20, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_FM_TYPE());
			pstmt.setString(21, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_TO_TYPE());
			pstmt.setString(22, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_FM_TYPE());
			pstmt.setString(23, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_TO_TYPE());
			pstmt.setString(24, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_FM_TYPE());
			pstmt.setString(25, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_TO_TYPE());
			pstmt.setString(26, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SETUP_FOR());
			pstmt.setString(27, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_FM());
			pstmt.setString(28, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_TO());
			pstmt.setString(29, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_FM());
			pstmt.setString(30, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_TO());
			pstmt.setString(31, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_FM());
			pstmt.setString(32, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_TO());
			pstmt.setString(33, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_FM());
			pstmt.setString(34, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_TO());
			pstmt.setString(35, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_FM());
			pstmt.setString(36, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_TO());
			pstmt.setString(37, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_FM());
			pstmt.setString(38, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_TO());
			pstmt.setString(39, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM().toString());
			pstmt.setString(40, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO().toString());
			pstmt.setString(41, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM().toString());
			pstmt.setString(42, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO().toString());
			pstmt.setString(43, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM().toString());
			pstmt.setString(44, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO().toString());
			Long M_FAS_SEQ_NO = null;
			if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SEQ_NO() != null){
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					M_FAS_SEQ_NO = rs.getLong(1);
					
					if(!(CommonUtils.nvl(M_FAS_SEQ_NO, 1).equals(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SEQ_NO()))){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91460"));
					}
				}
			}
		}catch(Exception sqle){
			sqle.printStackTrace();
			throw sqle;
		}
	}
	
	public void preUpdate(PM_IL_FUND_ACCOUNT_SETUP_ACTION action){
		PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN = action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
		try{
			String query="SELECT 'X' FROM PM_IL_FUND_ACCOUNT_SETUP " +
			"WHERE FAS_DRCR_FLAG = ? " +
			"  AND (? BETWEEN FAS_SRC_BUS_FM AND FAS_SRC_BUS_TO " +
			"   OR ? BETWEEN FAS_SRC_BUS_FM AND FAS_SRC_BUS_TO " +
			"   OR FAS_SRC_BUS_FM BETWEEN ? AND ? " +
			"   OR FAS_SRC_BUS_TO BETWEEN ? AND ?)" +
			"  AND (? BETWEEN FAS_DIVN_FM_CODE AND FAS_DIVN_TO_CODE " +
			"   OR ? BETWEEN FAS_DIVN_FM_CODE AND FAS_DIVN_TO_CODE " +
			"   OR FAS_DIVN_FM_CODE BETWEEN ? AND ?" +
			"   OR FAS_DIVN_TO_CODE BETWEEN ? AND ?)" +
			"  AND (? BETWEEN FAS_DEPT_FM_CODE AND FAS_DEPT_TO_CODE " +
			"   OR ? BETWEEN FAS_DEPT_FM_CODE AND FAS_DEPT_TO_CODE " +
			"   OR FAS_DEPT_FM_CODE BETWEEN ? AND ? " +
			"   OR FAS_DEPT_TO_CODE BETWEEN ? AND ?) " +
			"  AND (NVL(LPAD(?,12,'0'),'0') BETWEEN NVL(LPAD(FAS_DOC_FM_TYPE,12,'0'),'0') AND NVL(LPAD(FAS_DOC_TO_TYPE,12,'Z'),'Z') " +
			"   OR NVL(LPAD(?,12,'Z'),'Z') BETWEEN NVL(LPAD(FAS_DOC_FM_TYPE,12,'0'),'0') AND NVL(LPAD(FAS_DOC_TO_TYPE,12,'Z'),'Z') " +
			"   OR NVL(LPAD(FAS_DOC_FM_TYPE,12,'0'),'0') BETWEEN NVL(LPAD(?,12,'0'),'0') AND NVL(LPAD(?,12,'Z'),'Z') " +
			"   OR NVL(LPAD(FAS_DOC_TO_TYPE,12,'Z'),'Z') BETWEEN NVL(LPAD(?,12,'0'),'0') AND NVL(LPAD(?,12,'Z'),'Z')) " +
			"  AND (? = FAS_SETUP_FOR) " +
			"  AND (NVL(?,'0') BETWEEN NVL(FAS_PROD_CODE_FM,'0') AND NVL(FAS_PROD_CODE_TO,'0')" +
			"   OR NVL(?,'0') BETWEEN NVL(FAS_PROD_CODE_FM,'0') AND NVL(FAS_PROD_CODE_TO,'0') " +
			"   OR NVL(FAS_PROD_CODE_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'0') " +
			"   OR NVL(FAS_PROD_CODE_TO,'0') BETWEEN NVL(?,'0') AND NVL(?,'0')) " +
			"  AND (NVL(?,'0') BETWEEN NVL(FAS_FUND_CODE_FM,'0') AND NVL(FAS_FUND_CODE_TO,'0') " +
			"   OR NVL(?,'0') BETWEEN NVL(FAS_FUND_CODE_FM,'0') AND NVL(FAS_FUND_CODE_TO,'0') " +
			"   OR NVL(FAS_FUND_CODE_FM,'0') BETWEEN NVL(?,'0') AND NVL(?,'0')" +
			"   OR NVL(FAS_FUND_CODE_TO,'0') BETWEEN NVL(?,'0') AND NVL(?,'0')) " +
			"  AND (NVL(?,0) BETWEEN NVL(FAS_POL_YR_FM,0) AND NVL(FAS_POL_YR_TO,9999) " +
			"   OR NVL(?,9999) BETWEEN NVL(FAS_POL_YR_FM,0) AND NVL(FAS_POL_YR_TO,9999)" +
			"   OR NVL(FAS_POL_YR_FM,0) BETWEEN NVL(?,0) AND NVL(?,9999) " +
			"   OR NVL(FAS_POL_YR_TO,9999) BETWEEN NVL(?,0) AND NVL(?,9999))";
			String M_DUMMY="";
			PreparedStatement pstmt = CommonUtils.getConnection().prepareStatement(query);
			pstmt.setString(1, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DRCR_FLAG());
			pstmt.setString(2, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_FM());
			pstmt.setString(3, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_TO());    
			pstmt.setString(4, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_FM());
			pstmt.setString(5, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_TO());
			pstmt.setString(6, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_FM()); 
			pstmt.setString(7, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SRC_BUS_TO()); 
			pstmt.setString(8, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_FM_CODE());          
			pstmt.setString(9, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_TO_CODE());   
			pstmt.setString(10, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_FM_CODE());  
			pstmt.setString(11, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_TO_CODE());         
			pstmt.setString(12, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_FM_CODE());
			pstmt.setString(13, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_TO_CODE());
			pstmt.setString(14, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_FM_CODE());
			pstmt.setString(15, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_TO_CODE());  
			pstmt.setString(16, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_FM_CODE());  
			pstmt.setString(17, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_TO_CODE());
			pstmt.setString(18, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_FM_CODE());  
			pstmt.setString(19, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DEPT_TO_CODE());         
			pstmt.setString(20, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_FM_TYPE());         
			pstmt.setString(21, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_TO_TYPE());
			pstmt.setString(22, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_FM_TYPE());  
			pstmt.setString(23, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_TO_TYPE());    
			pstmt.setString(24, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_FM_TYPE());
			pstmt.setString(25, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DOC_TO_TYPE());
			pstmt.setString(26, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SETUP_FOR());
			pstmt.setString(27, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_FM());
			pstmt.setString(28, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_TO());
			pstmt.setString(29, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_FM());
			pstmt.setString(30, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_TO());
			pstmt.setString(31, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_FM());
			pstmt.setString(32, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_PROD_CODE_TO());
			pstmt.setString(33, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_FM());
			pstmt.setString(34, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_TO());
			pstmt.setString(35, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_FM());
			pstmt.setString(36, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_TO());
			pstmt.setString(37, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_FM());
			pstmt.setString(38, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FUND_CODE_TO());
			pstmt.setString(39, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM().toString());
			pstmt.setString(40, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO().toString());
			pstmt.setString(41, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM().toString());
			pstmt.setString(42, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO().toString());
			pstmt.setString(43, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_FM().toString());
			pstmt.setString(44, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_POL_YR_TO().toString());
			ResultSet rs = pstmt.executeQuery();
			Object[] params = new Object[1];
			params[0]="ENG";
			while(rs.next()){
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "80031",params));
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void postQuery(PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN)throws Exception {
		String mainAccDesc = null;
		String subAccDesc = null;
		String branchAccDesc = null;
		String deptAccDesc = null;
		String analysisCode1Desc = null;
		String analysisCode2Desc = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		ResultSet rs4 = null;
		ResultSet rs5 = null;

		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		PreparedStatement pstmt4 = null;
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = null;
		try {
			pstmt = getConnection()
					.prepareStatement(
							"SELECT MAIN_ACNT_CODE, MAIN_ACNT_NAME from FM_MAIN_ACCOUNT where NVL(MAIN_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25"
									+ "AND MAIN_ACNT_CODE = ?");
			pstmt.setString(1, PM_IL_FUND_ACCOUNT_SETUP_BEAN
					.getFAS_MAIN_ACNT_CODE());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				mainAccDesc = rs.getString("MAIN_ACNT_NAME");
			}
			if (mainAccDesc != null) {
				PM_IL_FUND_ACCOUNT_SETUP_BEAN
						.setUI_M_MAIN_ACNT_NAME(mainAccDesc);
			}
			pstmt1 = getConnection()
					.prepareStatement(
							"SELECT SUB_ACNT_CODE, SUB_ACNT_NAME FROM FM_SUB_ACCOUNT WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE"
									+ " FROM FM_MAIN_SUB WHERE MS_MAIN_ACNT_CODE = ?) AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25"
									+ " AND SUB_ACNT_CODE = ?");
			pstmt1.setString(1, PM_IL_FUND_ACCOUNT_SETUP_BEAN
					.getFAS_MAIN_ACNT_CODE());
			pstmt1.setString(2, PM_IL_FUND_ACCOUNT_SETUP_BEAN
					.getFAS_SUB_ACNT_CODE());
			rs1 = pstmt1.executeQuery();
			while (rs1.next()) {
				subAccDesc = rs1.getString("SUB_ACNT_NAME");
			}
			if (subAccDesc != null) {
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(subAccDesc);
			}
			String companyCode = CommonUtils.getControlBean().getM_COMP_CODE();
			selectQuery = "SELECT DIVN_CODE, DIVN_NAME from FM_DIVISION where DIVN_COMP_CODE = ? AND NVL(DIVN_FRZ_FLAG, 'N') = 'N'"
				+ " AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
				+ " AND ADS_FRZ_FLAG = 'N') AND DIVN_CODE = ? ";
			Object[] values = { companyCode,
					PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_DIVN_CODE() };
			rs2 = handler.executeSelectStatement(selectQuery, getConnection(),
					values);
			if (rs2.next()) {
				branchAccDesc = rs2.getString("DIVN_NAME");
				branchAccDesc = branchAccDesc == null ? "" : branchAccDesc;
			}
			if (branchAccDesc != null) {
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_DIVN_NAME(branchAccDesc);
			}
			pstmt2 = getConnection()
					.prepareStatement(
							"select DEPT_CODE, DEPT_NAME from PM_DEPARTMENT where DEPT_COMP_CODE ='001'"
									+ " AND DEPT_DIVN_CODE = ? AND DEPT_FRZ_FLAG  = 'N' "
									+ "AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE "
									+ "AND ADS_DEPT_CODE = DEPT_CODE AND ADS_USER_ID = NVL('',ADS_USER_ID) "
									+ "AND ADS_FRZ_FLAG = 'N') AND ROWNUM<=25 AND DEPT_CODE=?");
			pstmt2.setString(1, PM_IL_FUND_ACCOUNT_SETUP_BEAN
					.getFAS_DIVN_CODE());
			pstmt2.setString(2, PM_IL_FUND_ACCOUNT_SETUP_BEAN
					.getFAS_DEPT_CODE());
			rs3 = pstmt2.executeQuery();
			while (rs3.next()) {
				deptAccDesc = rs3.getString("DEPT_NAME");
			}
			if (deptAccDesc != null) {
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_DEPT_NAME(deptAccDesc);
			}
			pstmt3 = getConnection()
					.prepareStatement(
							"SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25"
									+ "AND ANLY_CODE = ?");
			pstmt3.setString(1, PM_IL_FUND_ACCOUNT_SETUP_BEAN
					.getFAS_ANLY_CODE_1());
			rs4 = pstmt3.executeQuery();
			while (rs4.next()) {
				analysisCode1Desc = rs4.getString("ANLY_NAME");
			}
			if (analysisCode1Desc != null) {
				PM_IL_FUND_ACCOUNT_SETUP_BEAN
						.setUI_M_ANLY_NAME(analysisCode1Desc);
			}
			 pstmt4 = getConnection().prepareStatement("SELECT ANLY_CODE, ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '2' AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND ROWNUM<=25" +
			  "AND ANLY_CODE = ?");
				pstmt4.setString(1, PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ANLY_CODE_2());
				rs5 = pstmt4.executeQuery();
				while(rs5.next()){
					analysisCode2Desc = rs5.getString("ANLY_NAME");
				}
				if(analysisCode2Desc != null){
					PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ANLY_NAME_1(analysisCode2Desc);
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(rs3);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(rs4);
			} catch (Exception e) {
			}try {
				CommonUtils.closeCursor(rs5);
			} catch (Exception e) {
			}
		}
	}
	
	public void preInsert(PM_IL_FUND_ACCOUNT_SETUP_ACTION action) throws Exception{
		action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setFAS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN().setFAS_CR_DT(new CommonUtils().getCurrentDate());
		L_CHECK_SEQ_NO(action);
	}
	
	public void mainAccountValidation(PM_IL_FUND_ACCOUNT_SETUP_ACTION action)throws Exception {
		PM_IL_FUND_ACCOUNT_SETUP_DELEGATE delegate = new PM_IL_FUND_ACCOUNT_SETUP_DELEGATE();
		PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN = action.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
		String C1 = "  SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2" +
				" 	    FROM   FM_MAIN_ACCOUNT" +
				"	    WHERE  MAIN_ACNT_CODE = ?";
		String C2 = " SELECT ACTY_NAME " +
				"	    FROM   FM_ACTIVITY" +
				"	    WHERE  ACTY_CODE = :DUMMY.M_ACTY_1";
		String C3 = " SELECT ACTY_NAME " +
				"	    FROM   FM_ACTIVITY" +
				"	    WHERE  ACTY_CODE = :DUMMY.M_ACTY_2";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet1 = null;
		Object[] values = null;
		String mainDesc = null;
		try{
			connection = CommonUtils.getConnection();
			mainDesc = new DBProcedures().P_VAL_MAIN_ACNT(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_MAIN_ACNT_CODE(),
					                   PM_IL_FUND_ACCOUNT_SETUP_BEAN.getUI_M_MAIN_ACNT_NAME(),
					                   "N", 
					                   "E");
			if(mainDesc != null){
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(mainDesc);
			}
			delegate.L_VAL_MAIN_ACTIVITY(action);
			values = new Object[]{PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_MAIN_ACNT_CODE()};
			resultSet1 = handler.executeSelectStatement(C1, connection,values);
			if(resultSet1.next()){
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_1(resultSet1.getString(1));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_ACTY_CODE_2(resultSet1.getString(2));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try {
				CommonUtils.closeCursor(resultSet1);
			} catch (Exception e) {
			}
		}
	}
	
	public void subAccountValidation(PM_IL_FUND_ACCOUNT_SETUP_ACTION PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN)throws Exception {
		PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN = PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(null);
		ArrayList<String> pList = new ArrayList<String>();
		try {
			if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SUB_ACNT_CODE() != null){
				pList =  new DBProcedures().P_VAL_SUB_ACNT(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_MAIN_ACNT_CODE(),
						PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_SUB_ACNT_CODE(),
						"N", "E");
				if(!pList.isEmpty() && pList.size() > 0){
					if(pList.get(0) != null){
						PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(pList.get(0));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	
	public void when_new_record_instance(PM_IL_FUND_ACCOUNT_SETUP_ACTION PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN)throws Exception{
		PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN = PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
		String  C1 = "  SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2" +
				" FROM   FM_MAIN_ACCOUNT" +
				" WHERE  MAIN_ACNT_CODE = ? ";
		 	Connection connection = null;
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet1 = null;
			Object[] values = null;
		try{
			connection = CommonUtils.getConnection();
			values= new Object[]{PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_MAIN_ACNT_CODE()};
			resultSet1 = handler.executeSelectStatement(C1, connection,values);
			if(resultSet1.next()){
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_1(resultSet1.getString(1));
				PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_2(resultSet1.getString(2));
			}

			 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_FORCE_DEPT_YN().setDisabled(true);
			 if("Y".equals(CommonUtils.nvl(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FORCE_DIVN_YN(),"N"))){
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DIVN_CODE().setDisabled(true);
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DIVN_CODE().setRequired(false);
			 }
			 if("N".equals(CommonUtils.nvl(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FORCE_DIVN_YN(),"N"))){
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DIVN_CODE().setDisabled(false);
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DIVN_CODE().setRequired(true);
			 }
			 if("Y".equals(CommonUtils.nvl(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FORCE_DEPT_YN(),"N"))){
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DEPT_CODE().setDisabled(true);
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DEPT_CODE().setRequired(false);
			 }
			 if("N".equals(CommonUtils.nvl(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_FORCE_DIVN_YN(),"N"))){
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DEPT_CODE().setDisabled(false);
				 PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DEPT_CODE().setRequired(true);
			 }
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void when_craete_record(PM_IL_FUND_ACCOUNT_SETUP_ACTION PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN){
		PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN = PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getPM_IL_FUND_ACCOUNT_SETUP_BEAN();
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FORCE_DIVN_YN("N");
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FORCE_DEPT_YN("N");
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_SETUP_FOR("P");
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_DRCR_FLAG("C");
		PM_IL_FUND_ACCOUNT_SETUP_BEAN.setFAS_FRZ_FLAG("N");

		PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DIVN_CODE().setRequired(true);
		PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_DEPT_CODE().setRequired(true);
		PM_IL_FUND_ACCOUNT_SETUP_ACTION_BEAN.getCOMP_FAS_FORCE_DEPT_YN().setDisabled(true);
	}
	
	public void when_validate_item_FAS_ACTY_CODE_1(PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN)throws Exception{
		ArrayList<String> pList = new ArrayList<String>();
		try{
			if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ACTY_CODE_1() != null){
				pList =  DBProcedures.P_VAL_ACTY(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_HEAD_1(),
			                    				PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ACTY_CODE_1(),
			                    				"N",
			                   					"E");
				if(!pList.isEmpty() && pList.size() != 0){
					PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME(pList.get(0));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void when_validate_item_FAS_ACTY_CODE_2(PM_IL_FUND_ACCOUNT_SETUP PM_IL_FUND_ACCOUNT_SETUP_BEAN)throws Exception{
		ArrayList<String> pList = new ArrayList<String>();
		try{
			if(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ACTY_CODE_2() != null){
				pList = DBProcedures.P_VAL_ACTY(PM_IL_FUND_ACCOUNT_SETUP_BEAN.getUI_M_ACTY_HEAD_2(),
			                    				PM_IL_FUND_ACCOUNT_SETUP_BEAN.getFAS_ACTY_CODE_2(),
			                    				"N",
			                   					"E");
				if(!pList.isEmpty() && pList.size() != 0){
					PM_IL_FUND_ACCOUNT_SETUP_BEAN.setUI_M_ACTY_NAME_1(pList.get(0));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Connection getConnection() {
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
