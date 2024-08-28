package com.iii.pel.forms.PILQ138;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT003_APAC.PILT003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT003_APAC.PT_IL_PREM_COLL;
import com.iii.pel.forms.PILT003_APAC.PT_IL_PREM_COLL_HELPER;
import com.iii.pel.utils.P9ILPK_PREM_COLL;
import com.iii.premia.common.utils.CommonUtils;

public class PREMIUM_ENQU_DELEGATE {
	long pol_sys_id=0;
	
	long pc_sys_id;
	public void executeSelectStatement(
			PILQ138_COMPOSITE_ACTION COMPOSITE_ACTION)
			throws Exception {
		
		String selectStatement = null;
		
			selectStatement = "SELECT  * FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID =? AND "
					+ "PC_PAID_FLAG != 'A' AND PC_SCHD_PYMT_DT <= ? ORDER BY PC_SCHD_PYMT_DT";
			
			
		String Query="SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
		
		
		ResultSet resultSetsys_id = null;
		Connection connection = null;
		ResultSet resultSet = null;
		PREMIUM_ENQU BEAN =null;
		COMPOSITE_ACTION.getPREMIUM_ENQU_ACTION_BEAN().getDataList_PREMIUM_ENQU().clear();
		
		try {
			connection = CommonUtils.getConnection();
			
			resultSetsys_id=new CRUDHandler().executeSelectStatement(Query, connection, new 
					Object[]{COMPOSITE_ACTION.getPREMIUM_ENQU_ACTION_BEAN().getPREMIUM_ENQU_BEAN().getUI_M_POL_NO()});
			while(resultSetsys_id.next())
			{
				pol_sys_id=resultSetsys_id.getLong("POL_SYS_ID");
			}
			
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,
					new Object[]{pol_sys_id,new CommonUtils().getCurrentDate()});
			
					while (resultSet.next()) {
				  BEAN = new PREMIUM_ENQU();
				  BEAN.setUI_M_PRE_DUE_DT(CommonUtils.dateToPELStringFormatter(resultSet.getDate("PC_SCHD_PYMT_DT")));
				  BEAN.setUI_M_PRE_DUE(CommonUtils.ROUND(CommonUtils.nvl(
						  resultSet.getDouble("PC_LC_GROSS_PREM"), 0) + 
						  CommonUtils.nvl(resultSet.getDouble("PC_LC_CHARGE"), 0),2));
				  pc_sys_id=resultSet.getLong("PC_SYS_ID");
				  unpaidintrest(BEAN);
				  
				  BEAN.setUI_M_NET_PRE(CommonUtils.ROUND(CommonUtils.nvl(BEAN.getUI_M_PRE_DUE(), 0) + 
						  CommonUtils.nvl(BEAN.getUI_M_PRE_INTE(), 0),2));
			
				  COMPOSITE_ACTION.getPREMIUM_ENQU_ACTION_BEAN().getDataList_PREMIUM_ENQU().add(BEAN);
					}	
		}catch(Exception e)
		{
			e.printStackTrace();
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	public void unpaidintrest(PREMIUM_ENQU BEAN)
	{
		try{
			P9ILPK_PREM_COLL p9ilpk_prem_coll=new P9ILPK_PREM_COLL();
	 ArrayList<OracleParameter> listUnpaid = new ArrayList<OracleParameter>();
		listUnpaid = p9ilpk_prem_coll.P_CALC_UNPAID_PREM_INT(pol_sys_id, pc_sys_id, new CommonUtils().getCurrentDate(), null, null, null, null);
		if(listUnpaid.size() > 0 ){
			if(listUnpaid.get(2).getValueObject() != null ){
				BEAN.setUI_M_PRE_INTE((Double)listUnpaid.get(2).getValueObject());
		}
		
		
		}
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
