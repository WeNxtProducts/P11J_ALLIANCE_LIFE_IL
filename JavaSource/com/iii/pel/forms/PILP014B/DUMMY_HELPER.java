package com.iii.pel.forms.PILP014B;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	public void whenNewBlockInstance(DUMMY DUMMY_BEAN) throws Exception {

		try {
			if (DUMMY_BEAN.getUI_M_PROCESS_DT() == null) {
				DUMMY_BEAN.setUI_M_PROCESS_DT(new CommonUtils()
						.getCurrentDate());
			}
			if (DUMMY_BEAN.getUI_M_PROC_TYPE() == null) {
				DUMMY_BEAN.setUI_M_PROC_TYPE("P");
			}
			if (DUMMY_BEAN.getUI_M_PROCESS_TYPE() == null) {
				DUMMY_BEAN.setUI_M_PROCESS_TYPE("1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidateM_POL_NO_FM(DUMMY DUMMY_BEAN) throws Exception {
		// P_SET_FIRST_FIELD('DUMMY.M_POL_NO_FM','DUMMY.M_POL_NO_TO');
		if (!("0".equalsIgnoreCase(DUMMY_BEAN.getUI_M_POL_NO_FM()))) {
			L_CHK_POL_NO(DUMMY_BEAN.getUI_M_POL_NO_FM());
		}
	}

	public void whenValidateM_POL_NO_TO(DUMMY DUMMY_BEAN) throws Exception {
		// P_SET_FIRST_FIELD('DUMMY.M_POL_NO_FM','DUMMY.M_POL_NO_TO');
		if (!("90".equalsIgnoreCase(DUMMY_BEAN.getUI_M_POL_NO_FM()))) {
			L_CHK_POL_NO(DUMMY_BEAN.getUI_M_POL_NO_FM());
		}
	}

	private void L_CHK_POL_NO(String M_POL_NO) throws Exception {

		String C1 = "SELECT 'X' " + "FROM   PT_IL_POLICY "
				+ "WHERE  POL_NO = ?";

		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { M_POL_NO });
			if (rs.next()) {
			} else {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "2411"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_BUT_PRESSED_UI_M_OK_BUT(DUMMY_ACTION DUMMY_ACTION_BEAN) {
		ArrayList<OracleParameter> retList = null;
		String processYN = null;
		DUMMY DUMMY_BEAN = DUMMY_ACTION_BEAN.getDUMMY_BEAN();
		try {
			retList = new PKG_PILP014B().L_INS_DETAIL(DUMMY_BEAN
					.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO(),
					DUMMY_BEAN.getUI_M_PROCESS_DT(), DUMMY_BEAN
							.getUI_M_PROC_TYPE(), DUMMY_BEAN
							.getUI_M_PROCESS_TYPE(), DUMMY_BEAN
							.getUI_M_REF_NO(), "");
			if (retList != null && !(retList.isEmpty())) {
				if (retList.get(0) != null) {
					processYN = retList.get(0).getValueObject().toString();
				}
			}
			if ("Y".equalsIgnoreCase(processYN)) {
				DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_OK().setDisabled(true);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
