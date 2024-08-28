package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.PKG_PILM003;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class COPY_PLAN_HELPER {

	public void validate_M_NEW_PLAN_CODE(COPY_PLAN copyBean, String planCode) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		ArrayList<OracleParameter> list = null;
		String M_TEMP = null;
		String C1 = " SELECT 'X' FROM  PM_IL_PLAN WHERE  PLAN_CODE = ? ";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{planCode});
			if(resultSet.next()){
				M_TEMP = resultSet.getString(1);
			}
			if(CommonUtils.nvl(M_TEMP, "N").equals("S")){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71012"));
			}
			
			list = new PKG_PILM003().L_VAL_PLAN_CODE(planCode, null, "B", "N", "E");
			if(list.size() > 0 && list.get(0).getValueObject() != null){
				copyBean.setUI_M_NEW_PLAN_DESC(list.get(0).getValueObject().toString());
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
}
