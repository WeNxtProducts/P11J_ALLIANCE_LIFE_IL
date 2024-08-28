package com.iii.pel.forms.PM001_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_DIVISION_HELPER {

	public void executeQuery(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_DIVISION_DELEGATE().executeSelectStatement(compositeAction);
	}

	public void L_UNIQUE_DIVN_CODE(PM_DIVISION PM_DIVISION_BEAN,String value)
			throws Exception {

		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT 1 FROM   PM_DIVISION   WHERE  DIVN_CODE =?";
		String M_DIVN_CODE = null;
		try {
			con = CommonUtils.getConnection();
			Object[] OB_C1 = {value};
			rs = handler.executeSelectStatement(C1, con, OB_C1);
			while (rs.next()) {
				M_DIVN_CODE = rs.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "1101"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void postQuery(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_DIVISION PM_DIVISION_BEAN = compositeAction
				.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();

		try {
			/*ArrayList<String> p_val_comp = new DBProcedures().callP_VAL_COMP(
					PM_DIVISION_BEAN.getDIVN_COMP_CODE(), "N", "N");

			if (PM_DIVISION_BEAN.getDIVN_CONTRA_ACNT_CODE() != null) {
				String p_val_class_cust = new DBProcedures().P_VAL_CLASS_CUST(
						"CONTRA", PM_DIVISION_BEAN.getDIVN_CONTRA_ACNT_CODE(),
						PM_DIVISION_BEAN.getUI_M_CONTRA_ACNT_DESC(), "N", "W");
			}*/
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_DIVISION PM_DIVISION_BEAN = compositeAction
					.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
			PM_DIVISION_BEAN.setDIVN_CR_DT(new CommonUtils().getCurrentDate());
			PM_DIVISION_BEAN.setDIVN_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			L_UNIQUE_DIVN_CODE(PM_DIVISION_BEAN,PM_DIVISION_BEAN.getDIVN_CODE());
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PRE_UPDATE(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			PM_DIVISION PM_DIVISION_BEAN = compositeAction
					.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
			PM_DIVISION_BEAN.setDIVN_UPD_DT(new CommonUtils().getCurrentDate());
			PM_DIVISION_BEAN.setDIVN_UPD_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void DIVN_CODE_WHEN_VALIDATE_ITEM(
			PM001_A_COMPOSITE_ACTION compositeAction,String value) throws Exception {
		PM_DIVISION PM_DIVISION_BEAN = compositeAction
				.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		try {
			L_UNIQUE_DIVN_CODE(PM_DIVISION_BEAN,value);
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void DIVN_COMP_CODE_WHEN_VALIDATE_ITEM(
			PM001_A_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_DIVISION PM_DIVISION_BEAN = compositeAction
				.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		ArrayList<String> p_val_comp = new DBProcedures().callP_VAL_COMP(
				PM_DIVISION_BEAN.getDIVN_COMP_CODE(), "N", "E");
		PM_DIVISION_BEAN.setUI_M_COMP_NAME(p_val_comp.get(0));
	}

	public void DIVN_CONTRA_ACNT_CODE_WHEN_VALIDATE_ITEM(
			PM001_A_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_DIVISION PM_DIVISION_BEAN = compositeAction
				.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		if (PM_DIVISION_BEAN.getDIVN_CONTRA_ACNT_CODE() == null) {
			PM_DIVISION_BEAN.setUI_M_CONTRA_ACNT_DESC(null);
		} else {
			String p_val_class_cust = new DBProcedures().P_VAL_CLASS_CUST(
					"CONTRA", PM_DIVISION_BEAN.getDIVN_CONTRA_ACNT_CODE(),
					PM_DIVISION_BEAN.getUI_M_CONTRA_ACNT_DESC(), "N", "E");
			PM_DIVISION_BEAN.setUI_M_CONTRA_ACNT_DESC(p_val_class_cust);
		}
	}

	public void pre_Delete(PM001_A_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_DIVISION PM_DIVISION_BEAN = compositeAction
				.getPM_DIVISION_ACTION_BEAN().getPM_DIVISION_BEAN();
		Connection con = null;
		String c1 = "DELETE FROM PM_DEPARTMENT" + " WHERE DEPT_DIVN_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object[] ob_c1 = { PM_DIVISION_BEAN.getDIVN_CODE() };
			handler.executeDeleteStatement(c1, con, ob_c1);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
}
