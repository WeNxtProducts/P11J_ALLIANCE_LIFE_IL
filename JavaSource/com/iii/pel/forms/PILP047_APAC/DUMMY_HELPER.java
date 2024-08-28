package com.iii.pel.forms.PILP047_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PP039_A.DUMMY_ACTION;
import com.iii.pel.utils.P9ILPK_AGENCY_MGMT;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {
	CommonUtils commonUtils = new CommonUtils();
	CRUDHandler handler = new CRUDHandler();

	public void WHEN_VALIDATE_M_POL_DT_TO(Date UI_M_POL_DT_FM,
			Date UI_M_POL_DT_TO) throws Exception {

		try {
			if (UI_M_POL_DT_FM.after(UI_M_POL_DT_TO)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71145",
						new Object[] { CommonUtils
								.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_VALIDATE_M_POL_NO_FM(String UI_M_POL_NO_FM,String UI_M_POL_NO_TO) throws Exception {
		try {
			UI_M_POL_NO_FM = (String) commonUtils.SET_REP_FIRST_FIELD(UI_M_POL_NO_FM, "String");
			WHEN_VALIDATE_M_POL_NO_TO(UI_M_POL_NO_FM, UI_M_POL_NO_TO);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_VALIDATE_M_POL_NO_TO(String UI_M_POL_NO_FM,
			String UI_M_POL_NO_TO) throws Exception {
		try {
			if (UI_M_POL_NO_TO != null) {
				UI_M_POL_NO_TO = (String) commonUtils.SET_REP_SECOND_FIELD(UI_M_POL_NO_FM, UI_M_POL_NO_TO, "String");
				if (UI_M_POL_NO_FM.compareTo(UI_M_POL_NO_TO) > 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71144",new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_BUTTON_PRESSED_OK(DUMMY DUMMY_BEAN) throws Exception {

		try {
			new P9ILPK_AGENCY_MGMT().CALC_AGENT_TOPUP_COMM(DUMMY_BEAN
					.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO(),
					DUMMY_BEAN.getUI_M_PROCESS_DT(), DUMMY_BEAN
							.getUI_M_PROCESS_TO_DT());

			CommonUtils.getConnection().commit();
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_VALIDATE_ITEM_M_POLICY_FM(String UI_M_POLICY_FM,
			String UI_M_POLICY_TO) throws Exception {
		try {
			UI_M_POLICY_FM = (String) commonUtils.SET_REP_FIRST_FIELD(
					UI_M_POLICY_FM, "String");
			WHEN_VALIDATE_ITEM_M_POLICY_TO(UI_M_POLICY_FM, UI_M_POLICY_TO );
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void WHEN_VALIDATE_ITEM_M_POLICY_TO(String UI_M_POLICY_FM,
			String UI_M_POLICY_TO) throws Exception {

		try {
			UI_M_POLICY_TO = (String) commonUtils.SET_REP_SECOND_FIELD(
					UI_M_POLICY_FM, UI_M_POLICY_TO, "String");
			L_VAL_FROM_TO(UI_M_POLICY_FM, UI_M_POLICY_TO);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	
	public void L_VAL_FROM_TO(String P_FROM_CODE, String P_TO_CODE)
	throws Exception {
		if (P_FROM_CODE == null) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "80033")));
		}
		if (P_TO_CODE.compareTo(P_FROM_CODE) < 0) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "80034")));
		}
}
	
	public void WHEN_VALIDATE_ITEM_M_FM_DT(DUMMY DUMMY_BEAN)
	throws Exception {
		if (DUMMY_BEAN.getUI_M_PROCESS_DT().after(
				commonUtils.getCurrentDate())) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "2181")));
		}
		if (DUMMY_BEAN.getUI_M_PROCESS_TO_DT() != null) {
			if (DUMMY_BEAN.getUI_M_PROCESS_TO_DT().before(
					DUMMY_BEAN.getUI_M_PROCESS_DT())) {
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath, "1050")));

			}
		}

	}
	
	public void WHEN_VALIDATE_ITEM_M_TO_DT(DUMMY DUMMY_BEAN)
	throws Exception {

		if (DUMMY_BEAN.getUI_M_PROCESS_TO_DT().before(
				DUMMY_BEAN.getUI_M_PROCESS_DT())) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "1050")));
		}
		if (DUMMY_BEAN.getUI_M_PROCESS_TO_DT().after(
				commonUtils.getCurrentDate())) {
			throw new ValidatorException(new FacesMessage(Messages.getString(
					PELConstants.pelErrorMessagePath, "2181")));
		}
	}
	
	
	public boolean topupCommCheck(DUMMY DUMMY_BEAN) throws Exception
	{
		String query = "SELECT 'X' FROM PT_IL_TOP_UP"
				+ " WHERE TU_POL_NO BETWEEN ? AND ?"
				+ " AND TU_APPRV_STATUS = 'Y'"

				+ " AND TU_DOC_DT BETWEEN ? AND ?"
				+ " AND NVL2(TU_COMM_FLAG, 'N','Y')= 'Y'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String M_COMM_FLAG = null;
		boolean chkFlag = false;
		List<String> orclList = new ArrayList<String>();

		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, con, new Object[] {
					DUMMY_BEAN.getUI_M_POL_NO_FM(),
					DUMMY_BEAN.getUI_M_POL_NO_TO(),
					DUMMY_BEAN.getUI_M_PROCESS_DT(),
					DUMMY_BEAN.getUI_M_PROCESS_TO_DT() });
			while(rs.next()) {
				M_COMM_FLAG = rs.getString(1);
				orclList.add(M_COMM_FLAG);
			}
			if(orclList.isEmpty() )
			{
				throw new Exception(
				"Topup Commission processing already done for this Policy on this specific date/ Topup Commission processing  not applicable for these dates");
				/*if (!orclList.contains("X")) {
					chkFlag = true;
				} else {
					chkFlag = false;
				}*/
			}
				orclList.clear();
			/*if (chkFlag) {
			}*/
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		return chkFlag;
	}
	
}

