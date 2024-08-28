package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_TTY_CLAIM_EST_DELEGATE {
	public void executeSelectStatement(
			PILT011_COMPOSITE_ACTION compositeAction) throws Exception {
		 int cover_count=compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN().CVR_GROUP_CODE();
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN()
		.getClaimEstList().clear();
		Long CLM_SYS_ID = null;
		String CLM_COVER_CODE=null;
		String selectStatement ;
		try {
			connection = CommonUtils.getConnection();
			if(!"".equals(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString())){
				CLM_SYS_ID = Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString());
				System.out.println("CLM_SYS_ID  :"+CLM_SYS_ID);
				}
			CLM_COVER_CODE=(String) CommonUtils.getGlobalVariable("GLOBAL.COVER_CODE");
			System.out.println("CLM_COVER_CODE  :"+CLM_COVER_CODE);
			/*added by gopi for kic on 23/03/2019*/
			if(cover_count>1 ){
				 selectStatement ="SELECT TCE_CCD_COVER_CODE,TCE_TREATY_CODE,TCE_UW_YEAR,"
						+ "TCE_CLAIM_LOSS_DT,TCE_RETN_LC_CLM_EST,TCE_QS_LC_CLM_EST"
						+ ",TCE_1S_LC_CLM_EST,TCE_2S_LC_CLM_EST,TCE_3S_LC_CLM_EST "
						+ "FROM PT_IL_TTY_CLAIM_EST WHERE TCE_CLAIM_SYS_ID = ? ";
				 resultSet = new CRUDHandler().executeSelectStatement(
							selectStatement, connection, new Object[] {CLM_SYS_ID});
			}else{
				 selectStatement ="SELECT TCE_CCD_COVER_CODE,TCE_TREATY_CODE,TCE_UW_YEAR,"
						+ "TCE_CLAIM_LOSS_DT,TCE_RETN_LC_CLM_EST,TCE_QS_LC_CLM_EST"
						+ ",TCE_1S_LC_CLM_EST,TCE_2S_LC_CLM_EST,TCE_3S_LC_CLM_EST "
						+ "FROM PT_IL_TTY_CLAIM_EST WHERE TCE_CLAIM_SYS_ID = ? AND TCE_CCD_COVER_CODE = ?";	
				 resultSet = new CRUDHandler().executeSelectStatement(
							selectStatement, connection, new Object[] {CLM_SYS_ID, CLM_COVER_CODE});
			}
			
			
			
			while (resultSet.next()) {
				PT_IL_TTY_CLAIM_EST PT_IL_TTY_CLAIM_EST_BEAN=new PT_IL_TTY_CLAIM_EST();
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_CCD_COVER_CODE(resultSet
						.getString("TCE_CCD_COVER_CODE"));
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_TREATY_CODE(resultSet
						.getString("TCE_TREATY_CODE"));
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_UW_YEAR(resultSet
						.getInt("TCE_UW_YEAR"));
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_CLAIM_LOSS_DT(resultSet
						.getDate("TCE_CLAIM_LOSS_DT"));
				
				/* added by raja on 18-08-2017 for ZBILQC-1722999 */
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_RETN_LC_CLM_EST(resultSet
						.getDouble("TCE_RETN_LC_CLM_EST"));
				
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_QS_LC_CLM_EST(resultSet
						.getDouble("TCE_QS_LC_CLM_EST"));
				/*end*/
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_1S_LC_CLM_EST(resultSet
						.getDouble("TCE_1S_LC_CLM_EST"));
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_2S_LC_CLM_EST(resultSet
						.getDouble("TCE_2S_LC_CLM_EST"));
				PT_IL_TTY_CLAIM_EST_BEAN.setTCE_3S_LC_CLM_EST(resultSet
						.getDouble("TCE_3S_LC_CLM_EST"));
				compositeAction.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN().setPT_IL_TTY_CLAIM_EST_BEAN(PT_IL_TTY_CLAIM_EST_BEAN);

				compositeAction
				.getPT_IL_TTY_CLAIM_EST_ACTION_BEAN()
				.getClaimEstList().add(PT_IL_TTY_CLAIM_EST_BEAN);
			}
			
		
	}finally {
	CommonUtils.closeCursor(resultSet);
	}
	}
}
