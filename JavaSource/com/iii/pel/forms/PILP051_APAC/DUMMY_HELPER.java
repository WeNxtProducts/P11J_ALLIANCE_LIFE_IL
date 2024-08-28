package com.iii.pel.forms.PILP051_APAC;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {

	public void when_Validate_UI_M_CLAIM_NO_FM(DUMMY_ACTION DUMMY_ACTION_BEAN)
			throws Exception {

		DUMMY DUMMY_BEAN = DUMMY_ACTION_BEAN.getDUMMY_BEAN();
		try {
			if (DUMMY_BEAN.getUI_M_CLAIM_NO_TO() != null&& !(DUMMY_BEAN.getUI_M_CLAIM_NO_TO().isEmpty())) {
				if ((DUMMY_BEAN.getUI_M_CLAIM_NO_FM()).compareTo(DUMMY_BEAN.getUI_M_CLAIM_NO_TO()) > 0) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91046"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void when_Validate_UI_M_CLAIM_NO_TO(DUMMY_ACTION DUMMY_ACTION_BEAN)
			throws Exception {

		DUMMY DUMMY_BEAN = DUMMY_ACTION_BEAN.getDUMMY_BEAN();
		try {
			if ((DUMMY_BEAN.getUI_M_CLAIM_NO_FM()).compareTo(DUMMY_BEAN.getUI_M_CLAIM_NO_TO()) > 0) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91046"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(DUMMY_ACTION DUMMY_ACTION_BEAN)
			throws Exception {

		DUMMY DUMMY_BEAN = DUMMY_ACTION_BEAN.getDUMMY_BEAN();
		try {

			DUMMY_BEAN.setUI_M_AS_ON_DT((new CommonUtils().getCurrentDate()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}