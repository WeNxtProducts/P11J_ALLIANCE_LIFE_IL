package com.iii.pel.forms.PILR146;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILR146_HELPER {

	CRUDHandler handler = new CRUDHandler();
	public void whenCreateRecord(PILR146_IP_REP_INFO_ACTION PILR069_APAC_IP_REP_INFO_ACTION_BEAN) {
		Calendar cal = Calendar.getInstance();
		IP_REP_INFO IP_REP_INFO_BEAN=PILR069_APAC_IP_REP_INFO_ACTION_BEAN.getIP_REP_INFO_BEAN(); 
		try {
			IP_REP_INFO_BEAN.setUI_M_DATE_FM(PILR069_APAC_IP_REP_INFO_ACTION_BEAN.getDefaultFromDate());
			IP_REP_INFO_BEAN.setUI_M_DATE_TO(PILR069_APAC_IP_REP_INFO_ACTION_BEAN.getDefaultToDate());
		} catch (ParseException e) {
			// Suppressed Format Exception
			e.printStackTrace();
		}
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
		String C1 ="SELECT DIVN_NAME FROM FM_DIVISION WHERE  DIVN_CODE = ?";
		String M_DIVN_NAME = null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{uiDivnFmCode});
			while(rs.next()){
				M_DIVN_NAME = rs.getString(1);
			}
		   
		   return M_DIVN_NAME;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}

	}
	
	public String WHEN_VALIDATE_ITEM_UI_DEPT_CODE(String uiDivnFmCode,
			IP_REP_INFO pbr016ValueBean) throws Exception {

		List<OracleParameter> procedureReturnList = null;
		String C1 ="SELECT DIVN_NAME FROM FM_DIVISION WHERE  DIVN_CODE = ?";
		String M_DIVN_NAME = null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{uiDivnFmCode});
			while(rs.next()){
				M_DIVN_NAME = rs.getString(1);
			}
		   
		   return M_DIVN_NAME;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}

	}

	public String WHEN_VALIDATE_ITEM_UI_M_PROD_CODE(String uiProdFmCode,
			IP_REP_INFO pbr016ValueBean) throws Exception {

		List<OracleParameter> procedureReturnList = null;
		String C1 ="SELECT PROD_DESC FROM   PM_IL_PRODUCT WHERE  PROD_CODE = ?";
		String M_PROD_DESC =null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{uiProdFmCode});
			while(rs.next()){
				M_PROD_DESC = rs.getString(1);
			}
//			 SET_REP_FIRST_FIELD('REP_PARAM.M_PROD_FM','REP_PARAM.M_PROD_TO');
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return M_PROD_DESC;
			 
			
	}


}
