package com.iii.pel.forms.PILR110;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILR110_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void whenCreateRecord(PILR110_IP_REP_INFO_ACTION action)
			throws Exception {

		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		try {
			IP_REP_INFO_BEAN.setUI_M_FM_DT(action.getDefaultFromDate());
			IP_REP_INFO_BEAN.setUI_M_TO_DT(action.getDefaultToDate());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_INSERT(
			com.iii.pel.forms.PILR110.IP_REP_INFO IP_REP_INFO_BEAN) {

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

	public void PRE_UPDATE(
			com.iii.pel.forms.PILR110.IP_REP_INFO IP_REP_INFO_BEAN) {

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

	public void whenValidateUI_M_FM_PLAN_CODE(PILR110_IP_REP_INFO_ACTION action)
			throws Exception {
		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = { IP_REP_INFO_BEAN.getUI_M_FM_PLAN_CODE() };
		String M_PLAN_DESC = null;
		String C1 = "	SELECT PS_TYPE_DESC FROM PP_SYSTEM WHERE  PS_TYPE = 'ILPLANTYPE'"
				+ " AND    PS_CODE =  ?";
		try {
			connection=CommonUtils.getConnection();	
			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				IP_REP_INFO_BEAN.setUI_M_FM_PLAN_DESC(resultSet.getString(1));
			} else {
				IP_REP_INFO_BEAN.setUI_M_FM_PLAN_DESC("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidateUI_M_TO_PLAN_CODE(PILR110_IP_REP_INFO_ACTION action)
			throws Exception {
		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = { IP_REP_INFO_BEAN.getUI_M_TO_PLAN_CODE() };
		String M_PLAN_DESC = null;
		String C1 = "	SELECT PS_TYPE_DESC FROM PP_SYSTEM WHERE  PS_TYPE = 'ILPLANTYPE'"
				+ " AND    PS_CODE =  ?";
		try {

			resultSet = handler.executeSelectStatement(C1, connection, values);
			if (resultSet.next()) {
				IP_REP_INFO_BEAN.setUI_M_TO_PLAN_DESC(resultSet.getString(1));
			} else {
				IP_REP_INFO_BEAN.setUI_M_TO_PLAN_DESC("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidateUI_M_FM_PROD_CODE(PILR110_IP_REP_INFO_ACTION action)
			throws Exception {
		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		String M_PLAN_DESC = null;

		try {
			P_VAL_PRODUCT(IP_REP_INFO_BEAN.getUI_M_FM_PROD_CODE(),
					new CommonUtils().getCurrentDate(), IP_REP_INFO_BEAN
							.getUI_M_FM_PROD_DESC(), "N");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void whenValidateUI_M_TO_PROD_CODE(PILR110_IP_REP_INFO_ACTION action)
			throws Exception {
		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		String M_PLAN_DESC = null;

		try {
			P_VAL_PRODUCT(IP_REP_INFO_BEAN.getUI_M_TO_PROD_CODE(),
					new CommonUtils().getCurrentDate(), IP_REP_INFO_BEAN
							.getUI_M_TO_PROD_DESC(), "N");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	private void P_VAL_PRODUCT(String prod_code, Date currentDate,
			String prod_desc, String P_ERR_FLAG) throws Exception {

		String c1 = "  SELECT PROD_DESC,PROD_BL_DESC  FROM   PM_IL_PRODUCT WHERE  PROD_CODE =?"
				+ " AND    ? BETWEEN NVL(PROD_EFF_FM_DT, TO_DATE('01/01/1900','DD/MM/RRRR')) "
				+ " AND NVL(PROD_EFF_TO_DT,TO_DATE('31/12/2999','DD/MM/RRRR'))";

		String M_PROD_DESC = null;
		String M_PROD_BL_DESC = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = { prod_code, currentDate };

		try {
			connection=CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(c1, connection, values);
			if (resultSet.next()) {
				M_PROD_DESC = resultSet.getString(1);
				M_PROD_BL_DESC = resultSet.getString(2);
			} else {
				/*if(("w".equalsIgnoreCase(P_ERR_FLAG)) ||("e".equalsIgnoreCase(P_ERR_FLAG))){
				   throw new Exception();
				   throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91074"));
				  if("E".equalsIgnoreCase(P_ERR_FLAG)){
				 	 
				  	  CLOSE C1;
				     RAISE FORM_TRIGGER_FAILURE;
				  END IF ;
				  END IF;
				  ELSE
				IF SUBSTR(NAME_IN('GLOBAL.M_FOR_LANG_CODE'),5,1) = '1' OR
				   NAME_IN('GLOBAL.M_LANG_CODE') = 'ENG' THEN
				 P_PROD_DESC := M_PROD_DESC;
				ELSE
				 P_PROD_DESC := M_PROD_BL_DESC;
				END IF;
				END IF;
				 */
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
