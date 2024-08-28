package com.iii.pel.forms.PILM204;

import java.util.ArrayList;
import java.util.List;

import com.iii.premia.common.action.CommonAction;

public class DUMMY_ACTION extends CommonAction {

	private DUMMY DUMMY_BEAN;

	private List<DUMMY> dataList_DUMMY = new ArrayList<DUMMY>();

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public List<DUMMY> getDataList_DUMMY() {
		return dataList_DUMMY;
	}

	public void setDataListDUMMY(List<DUMMY> dataList_DUMMY) {
		this.dataList_DUMMY = dataList_DUMMY;
	}
}
