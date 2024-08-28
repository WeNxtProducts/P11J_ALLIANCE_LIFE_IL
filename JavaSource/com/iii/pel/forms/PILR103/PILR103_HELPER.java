package com.iii.pel.forms.PILR103;

import java.text.ParseException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILR103_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void whenCreateRecord(
			PILR103_IP_REP_INFO_ACTION action) throws Exception {
		
		IP_REP_INFO IP_REP_INFO_BEAN=action.getIP_REP_INFO_BEAN();
		try{
			IP_REP_INFO_BEAN.setUI_M_FM_DT(action.getDefaultFromDate());
			IP_REP_INFO_BEAN.setUI_M_TO_DT(action.getDefaultToDate());
		}catch (Exception e) {
		e.printStackTrace();
		throw e;
		}
	}
	
	
	public void PRE_INSERT(com.iii.pel.forms.PILR103.IP_REP_INFO IP_REP_INFO_BEAN) {

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

	public void PRE_UPDATE(com.iii.pel.forms.PILR103.IP_REP_INFO IP_REP_INFO_BEAN) {

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
	
}
