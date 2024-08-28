package com.iii.pel.forms.PILP_WHA;

import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {

	public String L_VAL_AGENT(String agentCode) throws Exception {
		String CURSOR_C1 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE = ? "
				+ "AND CUST_FRZ_FLAG = 'N'  "
				+ "AND CUST_CLASS IN (SELECT CCLAS_CODE FROM PM_CUST_CLASS WHERE CCLAS_TYPE = '002') ";
		String AGENT_DESC = null;
		ResultSet resultSet = null;
		try {
			resultSet = new CRUDHandler().executeSelectStatement(CURSOR_C1,
					CommonUtils.getConnection(), new Object[] { agentCode });
			if (resultSet.next()) {
				AGENT_DESC = resultSet.getString(1);
			} else {
				throw new Exception("Broker does not Exists!Please Re-enter");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

		return AGENT_DESC;
	}

	public void validateUI_M_TO_DT(DUMMY dummy) throws Exception {
		try {
			if (dummy.getUI_M_TO_DT().before(dummy.getUI_M_FM_DT())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "2181"));
			}
			/*if (dummy.getUI_M_TO_DT() != null) {
				if (dummy.getUI_M_TO_DT().after(
						new CommonUtils().getCurrentDate())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1050"));
				}
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(DUMMY dummy) throws Exception {
		try {
			dummy.setUI_M_FM_DT(new CommonUtils().getCurrentDate());
			dummy.setUI_M_TO_DT(new CommonUtils().getCurrentDate());
			dummy.setUI_M_WH_TYPE("H");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void validateUI_M_FM_DT(DUMMY dummy) throws Exception {
		try {
			if (dummy.getUI_M_TO_DT() != null) {
				if (dummy.getUI_M_TO_DT().before(dummy.getUI_M_FM_DT())) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "1050"));
				}
			}
			if (dummy.getUI_M_FM_DT().after(new CommonUtils().getCurrentDate())) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "2181"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	

}
