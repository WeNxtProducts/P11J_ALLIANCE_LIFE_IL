package com.iii.pel.forms.PILR244_012;

import java.text.ParseException;
import java.util.Calendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ReportUtils;

public class PILR244_012_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void whenCreateRecord(PILR244_012_IP_REP_INFO_ACTION action)
			throws ParseException {
		Calendar cal = Calendar.getInstance();
		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		IP_REP_INFO_BEAN.setUI_M_AS_ON_DT(action.getDefaultToDate());

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

	

}
