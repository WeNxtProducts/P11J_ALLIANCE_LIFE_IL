package com.iii.pel.forms.PILM033;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Currency;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PREM_INTEREST_HELPER {

	public void executeQuery(PILM033_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PREM_INTEREST_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_PREM_INTEREST> dataList = compositeAction
				.getPM_IL_PREM_INTEREST_ACTION_BEAN()
				.getDataList_PM_IL_PREM_INTEREST();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN = dataList.get(0);
			PM_IL_PREM_INTEREST_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_PREM_INTEREST_ACTION_BEAN()
					.setPM_IL_PREM_INTEREST_BEAN(PM_IL_PREM_INTEREST_BEAN);
		}
	}
	
	public void preInsert(PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN) {
		
		try{

			   LP_CHECK_UNIQUE(PM_IL_PREM_INTEREST_BEAN,"PI");
			    PM_IL_PREM_INTEREST_BEAN.setPI_CR_DT(new CommonUtils().getCurrentDate());
			    PM_IL_PREM_INTEREST_BEAN.setPI_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
		public void preUpdate(PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN) {
			
			try{
				LP_CHECK_UNIQUE(PM_IL_PREM_INTEREST_BEAN,"PU");
				PM_IL_PREM_INTEREST_BEAN.setPI_UPD_DT(new CommonUtils().getCurrentDate());
				PM_IL_PREM_INTEREST_BEAN.setPI_UPD_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		public void whenCreateRecord(PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN) {
			
			try{
				 PM_IL_PREM_INTEREST_BEAN.setPI_MOP("Y");
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}

	public void LP_CHECK_UNIQUE(PM_IL_PREM_INTEREST PM_IL_PREM_INTEREST_BEAN,String P_TRG) {
	 
		Integer M_UNIQUE=null;   
		String CURSOR_C1 = "  SELECT COUNT(1) FROM   PM_IL_PREM_INTEREST" +
				"  WHERE  PI_MOP = ?   AND  PI_UPTO_MNTH = ? " +
				"  AND    PI_UPTO_DAYS = ? " +
				"  AND   (   NVL(PI_EFF_FM_DT,TO_DATE('01-01-1900','DD-MM-YYYY')) " +
				"  BETWEEN NVL( ? ,TO_DATE('01-01-1900','DD-MM-YYYY')) AND NVL(? ,TO_DATE('12-12-2100','DD-MM-YYYY'))" +
				"   OR  NVL(PI_EFF_TO_DT,TO_DATE('12-12-2100','DD-MM-YYYY')) BETWEEN " +
				" NVL( ? ,TO_DATE('01-01-1900','DD-MM-YYYY'))  AND NVL(? ,TO_DATE('12-12-2100','DD-MM-YYYY'))" +
				"  OR  NVL(?,TO_DATE('01-01-1900','DD-MM-YYYY')) BETWEEN " +
				" NVL(PI_EFF_FM_DT,TO_DATE('01-01-1900','DD-MM-YYYY')) AND " +
				" NVL(PI_EFF_TO_DT,TO_DATE('12-12-2100','DD-MM-YYYY'))  OR " +
				" NVL(? ,TO_DATE('12-12-2100','DD-MM-YYYY')) BETWEEN" +
				"  NVL(PI_EFF_FM_DT,TO_DATE('01-01-1900','DD-MM-YYYY')) AND NVL(PI_EFF_TO_DT,TO_DATE('12-12-2100','DD-MM-YYYY'))   )  AND ROWNUM < 3 ";
		 ResultSet rs = null;
		 
		try{
			rs = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
					new Object[]{PM_IL_PREM_INTEREST_BEAN.getPI_MOP(),
				PM_IL_PREM_INTEREST_BEAN.getPI_UPTO_MNTH(),
				 PM_IL_PREM_INTEREST_BEAN.getPI_UPTO_DAYS(),
				 PM_IL_PREM_INTEREST_BEAN.getPI_EFF_FM_DT(),
				 PM_IL_PREM_INTEREST_BEAN.getPI_EFF_TO_DT(),
				 PM_IL_PREM_INTEREST_BEAN.getPI_EFF_FM_DT(),
				 PM_IL_PREM_INTEREST_BEAN.getPI_EFF_TO_DT(),
				 PM_IL_PREM_INTEREST_BEAN.getPI_EFF_FM_DT(),
				 PM_IL_PREM_INTEREST_BEAN.getPI_EFF_TO_DT()			});
		   if(rs.next()){
				  M_UNIQUE = rs.getInt(1);
		   }
		   if(("PI".equals(P_TRG) && M_UNIQUE > 0) ||
		   	  ("PU".equals(P_TRG)  && M_UNIQUE > 1)) {

			    throw new Exception(Messages.getString(
				    PELConstants.pelErrorMessagePath, "91011",
				    new Object[] { CommonUtils.getControlBean()
					    .getM_LANG_CODE() }));
		   } 
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}