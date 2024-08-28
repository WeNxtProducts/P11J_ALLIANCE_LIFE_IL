package com.iii.pel.forms.PILQ142;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class PT_IL_SUB_STD_REG_DELEGATE {
	public void executeSelectStatement(
			PILQ142_COMPOSITE_ACTION COMPOSITE_ACTION)
			throws Exception {
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String executeQuery = "SELECT ROWID,PSSR_SURNAME,PSSR_FIRST_NAME,PSSR_NATIONAL_ID,TO_CHAR(PSSR_DOB, 'DD/MM/RRRR') PSSR_DOB_STR,PSSR_OFCO,"
						+ "TO_CHAR(PSSR_DEC_DATE, 'DD/MM/RRRR') PSSR_DEC_DATE_STR,PSSR_REFNO,PSSR_MEM_DTLS,PSSR_CR_DT,PSSR_CR_UID FROM PT_IL_SUB_STD_REG";
		ResultSet resultSet = null;

		con = CommonUtils.getConnection();
		PT_IL_SUB_STD_REG PT_IL_SUB_STD_REG_bean = null;

		resultSet = handler.executeSelectStatement(executeQuery, con);

		while (resultSet.next()) {
			PT_IL_SUB_STD_REG_bean = new PT_IL_SUB_STD_REG();
			PT_IL_SUB_STD_REG_bean.setROWID(resultSet.getString("ROWID"));

			PT_IL_SUB_STD_REG_bean.setPSSR_SURNAME(resultSet.getString("PSSR_SURNAME"));
			
			PT_IL_SUB_STD_REG_bean.setPSSR_FIRST_NAME(resultSet.getString("PSSR_FIRST_NAME"));
			PT_IL_SUB_STD_REG_bean.setPSSR_NATIONAL_ID(resultSet.getString("PSSR_NATIONAL_ID"));
			
			
			PT_IL_SUB_STD_REG_bean.setPSSR_DOB(resultSet.getString("PSSR_DOB_STR"));
			PT_IL_SUB_STD_REG_bean.setPSSR_OFCO(resultSet.getString("PSSR_OFCO"));
			PT_IL_SUB_STD_REG_bean.setPSSR_DEC_DATE(resultSet.getString("PSSR_DEC_DATE_STR"));

			
			PT_IL_SUB_STD_REG_bean.setPSSR_REFNO(resultSet.getString("PSSR_REFNO"));
			PT_IL_SUB_STD_REG_bean.setPSSR_MEM_DTLS(resultSet.getString("PSSR_MEM_DTLS"));
			PT_IL_SUB_STD_REG_bean.setPSSR_CR_DT(resultSet.getString("PSSR_CR_DT"));
			PT_IL_SUB_STD_REG_bean.setPSSR_CR_UID(resultSet.getString("PSSR_CR_UID"));
			
			
			COMPOSITE_ACTION.getPILQ142_PT_IL_SUB_STD_REG_ACTION_BEAN().
			getDataListPT_IL_SUB_STD_REG().add(PT_IL_SUB_STD_REG_bean);
			
			
		}

	}
}
