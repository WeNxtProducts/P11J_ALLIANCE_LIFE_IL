package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;

import org.omg.CORBA.OBJ_ADAPTER;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILM035_APAC_PROCS_HELPER {

	CRUDHandler handler = new CRUDHandler();
	public void L_CHECK_UNIQUE_CLM_LATE_FEE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_CASHBCK_INT PM_IL_PROD_CASHBCK_INT_bean = compositeAction
				.getPM_IL_PROD_CASHBCK_INT_ACTION_BEAN()
				.getPM_IL_PROD_CASHBCK_INT_BEAN();
		/*PM_IL_CLM_REPAY pm_il_clm_repay_bean = compositeAction
				.getPM_IL_CLM_REPAY_ACTION_BEAN().getPM_IL_CLM_REPAY_BEAN();*/

		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		try {
			con = CommonUtils.getConnection();
			// if (("INSERT").equals(system_bean.getRECORD_STATUS())) {
			if (PM_IL_PROD_CASHBCK_INT_bean.getROWID() == null) {
				String M_DUMMY = null;

				Object[] rsObj1 = new Object[11];
				rsObj1[0] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS();
				rsObj1[1] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS();
				rsObj1[2] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS();
				rsObj1[3] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS();
				rsObj1[4] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT();
				rsObj1[5] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT();
				rsObj1[6] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT();
				rsObj1[7] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT();
				rsObj1[8] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_PROD_CODE();
				

				rs1 = handler
						.executeSelectStatement(
								" SELECT ROWID FROM PM_IL_PROD_CASHBCK_INT WHERE ( CASHBCK_NO_FM_DAYS  BETWEEN  ?  AND  ?  OR       CASHBCK_NO_TO_DAYS  BETWEEN  ?  AND  ? ) AND     (CASHBCK_EFF_FM_DT   BETWEEN  ?   AND  ?  OR       CASHBCK_EFF_TO_DT   BETWEEN  ?   AND  ? ) AND      CASHBCK_PROD_CODE     =  ?   ",
								con,new Object[] {
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_PROD_CODE()
								}
								);
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
					if (CommonUtils.isDuplicate(PM_IL_PROD_CASHBCK_INT_bean
							.getROWID(), M_DUMMY))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91049"));
				}

			} else {
				String M_DUMMY = null;

				Object[] rsObj2 = new Object[12];
				rsObj2[0] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS();
				rsObj2[1] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS();
				rsObj2[2] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS();
				rsObj2[3] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS();
				rsObj2[4] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT();
				rsObj2[5] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT();
				rsObj2[6] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT();
				rsObj2[7] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT();
				rsObj2[8] = PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_PROD_CODE();
			/*	rsObj2[9] = pm_il_clm_repay_bean.getCR_LOSS_TYPE();
				rsObj2[10] = pm_il_clm_repay_bean.getCR_DISABLE_TYPE();*/
				rsObj2[9] = PM_IL_PROD_CASHBCK_INT_bean.getROWID();

				rs2 = handler
						.executeSelectStatement(
								" SELECT ROWID FROM    PM_IL_PROD_CASHBCK_INT WHERE   ( CASHBCK_NO_FM_DAYS BETWEEN  ?  AND  ?  OR       CASHBCK_NO_TO_DAYS BETWEEN  ?  AND  ? ) AND     ( CASHBCK_EFF_FM_DT   BETWEEN  ?   AND  ?  OR       CASHBCK_EFF_TO_DT   BETWEEN  ?   AND  ? ) AND      CASHBCK_PROD_CODE     =  ?   AND      ROWID <>  ? ",
								con, new Object[] {
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_FM_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_NO_TO_DAYS(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_FM_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_EFF_TO_DT(),
										PM_IL_PROD_CASHBCK_INT_bean.getCASHBCK_PROD_CODE(),
										PM_IL_PROD_CASHBCK_INT_bean.getROWID()
								});
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
					if (CommonUtils.isDuplicate(PM_IL_PROD_CASHBCK_INT_bean
							.getROWID(), M_DUMMY))
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91049"));
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
			CommonUtils.closeCursor(rs2);
		}
	}

	
	
}
