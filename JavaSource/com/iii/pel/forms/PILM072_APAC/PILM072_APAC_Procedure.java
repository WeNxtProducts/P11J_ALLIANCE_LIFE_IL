/**
 * 
 */
package com.iii.pel.forms.PILM072_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

/**
 * @author 55368
 *
 */
public class PILM072_APAC_Procedure {
	
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void L_UNIQUE_RANGE(PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
		String M_DUMMY = null;
		String C1 = "SELECT 1 "+
				   "FROM  PM_IL_IF_ACCNT_SETUP_HDR  "+
				   "WHERE NVL(PIFH_MAIN_ACNT_CODE,'X')     = NVL(?,'X') "+
				   "AND   NVL(PIFH_SUB_ACNT_CODE,'X')      = NVL(?,'X') "+
				   "AND   NVL(PIFH_DIVN_CODE,'X')          = NVL(?,'X') "+
				   "AND   NVL(PIFH_DEPT_CODE,'X')          = NVL(?,'X') "+
				   "AND   NVL(PIFH_ANLY_CODE_1,'X')        = NVL(?,'X') "+
				   "AND   NVL(PIFH_ANLY_CODE_2,'X')        = NVL(?,'X') "+
				   "AND   NVL(PIFH_ACTY_CODE_1,'X')        = NVL(?,'X') "+
				   "AND   NVL(PIFH_ACTY_CODE_2,'X')        = NVL(?,'X') "+
				   "AND   NVL(PIFH_DRCR_FLAG,'X')          = NVL(?,'X') "+
				   "AND   NVL(PIFH_FRZ_FLAG, 'N')   = 'N'";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_MAIN_ACNT_CODE(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SUB_ACNT_CODE(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DIVN_CODE(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DEPT_CODE(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_1(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ANLY_CODE_2(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_1(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_ACTY_CODE_2(),
					PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_DRCR_FLAG()
					});
			if (C1_REC.next()) {
				M_DUMMY = C1_REC.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1033",
						new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
	}
	
	/**
	 * 
	 * @param PM_IL_IF_ACCNT_SETUP_HDR_BEAN
	 * @throws Exception
	 */
	public void L_UNIQUE_RANGE_DTL(PM_IL_IF_ACCNT_SETUP_DTL PM_IL_IF_ACCNT_SETUP_DTL_BEAN,PM_IL_IF_ACCNT_SETUP_HDR PM_IL_IF_ACCNT_SETUP_HDR_BEAN) throws Exception{
		String M_DUMMY = null;
		String C1 = " SELECT 1 "+ 
					   "FROM  PM_IL_IF_ACCNT_SETUP_DTL "+
					   "WHERE PIFD_PIFH_SYS_ID                 = ? "+
					   "AND   NVL(PIFD_MAIN_ACNT_CODE,'X')     = NVL(?,'X') "+
					   "AND   NVL(PIFD_SUB_ACNT_CODE,'X')      = NVL(?,'X') "+
					   "AND   NVL(PIFD_DRCR_FLAG,'X')          = NVL(?,'X') "+
					   "AND   NVL(PIFD_DIVN_CODE,'X')          = NVL(?,'X') "+
					   "AND   NVL(PIFD_DEPT_CODE,'X')          = NVL(?,'X') "+
					   "AND   NVL(PIFD_ANLY_CODE_1,'X')        = NVL(?,'X') "+
					   "AND   NVL(PIFD_ANLY_CODE_2,'X')        = NVL(?,'X') "+
					   "AND   NVL(PIFD_ACTY_CODE_1,'X')        = NVL(?,'X') "+
					   "AND   NVL(PIFD_ACTY_CODE_2,'X')        = NVL(?,'X') "+
					   "AND   NVL(PIFD_PS_CODE,'X')            = NVL(?,'X') "+
					   "AND PM_IL_IF_aCCNT_SETUP_dTL.rowid<>rowid";

		Connection conn = null;
		CRUDHandler handler = null;
		ResultSet C1_REC = null;
		try {
			handler = new CRUDHandler();
			conn = CommonUtils.getConnection();
			C1_REC = handler.executeSelectStatement(C1, conn,new Object[]{PM_IL_IF_ACCNT_SETUP_HDR_BEAN.getPIFH_SYS_ID(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_MAIN_ACNT_CODE(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_SUB_ACNT_CODE(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DRCR_FLAG(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DIVN_CODE(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_DEPT_CODE(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_1(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ANLY_CODE_2(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_1(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_ACTY_CODE_2(),
					PM_IL_IF_ACCNT_SETUP_DTL_BEAN.getPIFD_PS_CODE()
					});
			if (C1_REC.next()) {
				M_DUMMY = C1_REC.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1033",
						new Object[] { CommonUtils.getControlBean().getM_LANG_CODE() }));
			}
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw exception;
		} finally {
			try {
				CommonUtils.closeCursor(C1_REC);
			} catch (Exception exception2) {
			}
			
		}
	}
}
