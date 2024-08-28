package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class PH_IL_TTY_CLAIM_EST_DELEGATE {
	public void executeSelectStatement(
			PILT011_COMPOSITE_ACTION compositeAction) throws Exception {
		String selectStatement ="SELECT TCE_CCD_COVER_CODE,TCE_TREATY_CODE,TCE_UW_YEAR,"
				+ "TCE_CLAIM_LOSS_DT,TCE_RETN_LC_CLM_EST,TCE_QS_LC_CLM_EST"
				+ ",TCEH_1S_LC_CLM_EST,TCEH_2S_LC_CLM_EST,TCE_3S_LC_CLM_EST "
				+ "FROM PT_IL_TTY_CLAIM_EST WHERE TCE_CLAIM_SYS_ID = ? AND TCE_CCD_COVER_CODE = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		compositeAction.getPH_IL_TTY_CLAIM_EST_ACTION_BEAN()
		.getDataList().clear();
		Long CLM_SYS_ID = null;
		String CLM_COVER_CODE=null;
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		System.out.println("COVER_CODE  "+session.getAttribute("COVER_CODE").toString());
		CLM_COVER_CODE=session.getAttribute("COVER_CODE").toString();
		try {
			connection = CommonUtils.getConnection();
			if(!"".equals(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString())){
				CLM_SYS_ID = Long.valueOf(CommonUtils.getGlobalObject("GLOBAL.CLM_SYS_ID").toString());
				System.out.println("CLM_SYS_ID  :"+CLM_SYS_ID);
				}
		System.out.println("");
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] {CLM_SYS_ID, CLM_COVER_CODE});

			while (resultSet.next()) {
				PH_IL_TTY_CLAIM_EST PH_IL_TTY_CLAIM_EST_BEAN=new PH_IL_TTY_CLAIM_EST();
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CCD_COVER_CODE(resultSet
						.getString("TCEH_CCD_COVER_CODE"));
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_TREATY_CODE(resultSet
						.getString("TCEH_TREATY_CODE"));
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_UW_YEAR(resultSet
						.getDouble("TCEH_UW_YEAR"));
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CLAIM_LOSS_DT(resultSet
						.getDate("TCEH_CLAIM_LOSS_DT"));
				/*PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_RETN_LC_CLM_EST(resultSet
						.getDouble("TCEH_RETN_LC_CLM_EST"));*/
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CCD_COVER_CODE(resultSet
						.getString("TCEH_CCD_COVER_CODE"));
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CCD_COVER_CODE(resultSet
						.getString("TCEH_CCD_COVER_CODE"));
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CCD_COVER_CODE(resultSet
						.getString("TCEH_CCD_COVER_CODE"));
				PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CCD_COVER_CODE(resultSet
						.getString("TCEH_CCD_COVER_CODE"));
			}
			
		
	}finally {
	CommonUtils.closeCursor(resultSet);
	}
	}
}
