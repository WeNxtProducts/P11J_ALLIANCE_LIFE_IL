package com.iii.pel.forms.PILR246_012;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILR246_012_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void whenCreateRecord(PILR246_012_IP_REP_INFO_ACTION action)
			throws ParseException {
		Calendar cal = Calendar.getInstance();
		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		IP_REP_INFO_BEAN.setUI_M_FM_CS_DT(action.getDefaultFromDate());
		IP_REP_INFO_BEAN.setUI_M_FM_APR_DT(action.getDefaultFromDate());
		IP_REP_INFO_BEAN.setUI_M_TO_CS_DT(action.getDefaultToDate());
		IP_REP_INFO_BEAN.setUI_M_TO_APR_DT(action.getDefaultToDate());

	}

	public void PRE_INSERT(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {

			IP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public String WHEN_VALIDATE_ITEM_UI_DIVN_CODE(String uiDivnFmCode,
			IP_REP_INFO pbr016ValueBean) throws Exception {

		List<OracleParameter> procedureReturnList = null;
		String C1 = "SELECT DIVN_NAME FROM FM_DIVISION WHERE  DIVN_CODE = ?";
		String M_DIVN_NAME = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { uiDivnFmCode });
			while (rs.next()) {
				M_DIVN_NAME = rs.getString(1);
			}

			return M_DIVN_NAME;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public String WHEN_VALIDATE_ITEM_UI_M_DEPT_CODE(String uiDEPTFmCode,
			IP_REP_INFO pbr016ValueBean) throws Exception {

		List<OracleParameter> procedureReturnList = null;
		String C1 = "SELECT DEPT_NAME FROM   PM_DEPARTMENT WHERE  DEPT_CODE = ?";
		String M_DEPT_DESC = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { uiDEPTFmCode });
			while (rs.next()) {
				M_DEPT_DESC = rs.getString(1);
			}
			// SET_REP_FIRST_FIELD('REP_PARAM.M_DEPT_FM','REP_PARAM.M_DEPT_TO');
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return M_DEPT_DESC;

	}

	public String WHEN_VALIDATE_ITEM_UI_M_CLASS(String uiCLASS,
			IP_REP_INFO ip_rep_info_bean) throws Exception {
		// TODO Auto-generated method stub

		String C1 = "SELECT CLASS_NAME FROM PM_IL_CLASS WHERE CLASS_CODE =?";
		ResultSet rs = null;
		Connection con = null;
		String M_BUS_DESC = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { uiCLASS });
			while (rs.next()) {
				M_BUS_DESC = rs.getString(1);
			}
			// SET_REP_FIRST_FIELD('REP_PARAM.M_CLASS_FM','REP_PARAM.M_CLASS_TO');
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return M_BUS_DESC;
	}

	public String WHEN_VALIDATE_ITEM_UI_M_USER_ID_FM(String uiUSER_ID,
			IP_REP_INFO ip_rep_info_bean) throws Exception {
		// TODO Auto-generated method stub

		String C1 = "SELECT USER_DESC FROM MENU_USER WHERE  USER_ID = ?";
		ResultSet rs = null;
		Connection con = null;
		String M_CUST_DESC = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { uiUSER_ID });
			while (rs.next()) {
				M_CUST_DESC = rs.getString(1);
			}
			// SET_REP_FIRST_FIELD('REP_PARAM.M_CLASS_FM','REP_PARAM.M_CLASS_TO');
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return M_CUST_DESC;
	}

	public String WHEN_VALIDATE_ITEM_UI_M_PROD(String uiPROD,
			IP_REP_INFO ip_rep_info_bean) throws Exception {
		// TODO Auto-generated method stub

		String C1 = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		ResultSet rs = null;
		Connection con = null;
		String M_BUS_DESC = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con,
					new Object[] { uiPROD });
			while (rs.next()) {
				M_BUS_DESC = rs.getString(1);
			}
			// SET_REP_FIRST_FIELD('REP_PARAM.M_CLASS_FM','REP_PARAM.M_CLASS_TO');
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return M_BUS_DESC;
	}
	
	
	
}
