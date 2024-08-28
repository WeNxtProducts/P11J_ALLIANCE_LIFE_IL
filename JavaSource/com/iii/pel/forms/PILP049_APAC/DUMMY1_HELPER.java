package com.iii.pel.forms.PILP049_APAC;

import java.sql.Connection;
import java.util.ArrayList;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILP021.DUMMY;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY1_HELPER {
	
	public void validateUI_M_FM_DT(DUMMY1 dummy1) throws Exception{
		try {
			if (dummy1.getUI_M_TO_DT() != null) {
				if (dummy1.getUI_M_TO_DT().before(dummy1.getUI_M_FM_DT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1050"));
				}
			}
			if (new CommonUtils().getCurrentDate().after(dummy1.getUI_M_TO_DT())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2181"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateUI_M_TO_DT(DUMMY1 dummy1) throws Exception{
		try {
			if (dummy1.getUI_M_FM_DT().before(new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "2181"));
			}
			if (dummy1.getUI_M_TO_DT() != null) {
				if (dummy1.getUI_M_TO_DT().before(dummy1.getUI_M_FM_DT())) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1050"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenCreateRecord(DUMMY1 dummy1) throws Exception {
		try {
			dummy1.setUI_M_FM_DT(new CommonUtils().getCurrentDate());
			dummy1.setUI_M_TO_DT(new CommonUtils().getCurrentDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public ArrayList<OracleParameter> UNIT_PRICE(
			Object P_FM_FUND_CODE,
			Object P_TO_FUND_CODE,
			Object P_FM_DT,
			Object P_TO_DT) throws ProcedureException {
	Connection connection = null;
	 ArrayList<OracleParameter> parameterList = null;
	 ArrayList<OracleParameter> outputList = null;
	 try {
	 	connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
   OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_FM_FUND_CODE);
   parameterList.add(param1);
   OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_TO_FUND_CODE);
   parameterList.add(param2);
   OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_FM_DT);
   parameterList.add(param3);
   OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_TO_DT);
   parameterList.add(param4);

  OracleProcedureHandler procHandler = new OracleProcedureHandler();
   outputList = procHandler.executeProc(parameterList, connection,
          "P9ILPK_UNIT_PRICE.P_INS_PT_IL_UNIT_VAL_NAV");
} catch(Exception e) {
	ErrorHelpUtil.getErrorForProcedure(connection);
       throw new ProcedureException(e.getMessage());
}
return outputList;
}
}