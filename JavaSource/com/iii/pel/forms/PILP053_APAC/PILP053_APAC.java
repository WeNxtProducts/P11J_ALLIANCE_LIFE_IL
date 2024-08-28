package com.iii.pel.forms.PILP053_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILP053_APAC {
	
	public static void L_SURR_BACK_DATE(
			PILP053_APAC_COMPOSITE_ACTION compositeAction) {
		SURRENDER surrender_bean = compositeAction.getSURRENDER_ACTION_BEAN()
				.getSURRENDER_BEAN();
		double M_PC_VALUE = 0.0;
		Date M_DATE = null;

		String C1 = "SELECT PC_VALUE " + "FROM   PM_CODES "
				+ "WHERE  PC_TYPE = 'IL_SUR_BKDAY' AND PC_CODE = ?";
		Connection con = null;
		ResultSet rs1 = null;

		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			Date sysdate = new CommonUtils().getCurrentDate();
			rs1 = handler.executeSelectStatement(C1, con,
					new Object[] { surrender_bean.getUI_M_POL_PROD_CODE() });
			while (rs1.next()) {
				M_PC_VALUE = rs1.getDouble("PC_VALUE");
			}
			if (surrender_bean.getUI_M_R_PC_SCHD_PYMT_DT().before(
					CommonUtils.addDaysToDate(sysdate, -((int) M_PC_VALUE)))) {
				M_DATE = CommonUtils.addDaysToDate(sysdate, -(int) M_PC_VALUE);
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "92269",new Object[]{"Surrender Date Cannot Be Less Than "+ M_DATE + " "}));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
