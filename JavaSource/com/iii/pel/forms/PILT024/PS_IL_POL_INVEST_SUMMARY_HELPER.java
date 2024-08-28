package com.iii.pel.forms.PILT024;

import java.util.List;

public class PS_IL_POL_INVEST_SUMMARY_HELPER {
	public void preInsert(PS_IL_POL_INVEST_SUMMARY PS_IL_POL_INVEST_SUMMARY_BEAN) {
	}

	public void postInsert(
			PS_IL_POL_INVEST_SUMMARY PS_IL_POL_INVEST_SUMMARY_BEAN) {
	}

	public void preUpdate(PS_IL_POL_INVEST_SUMMARY PS_IL_POL_INVEST_SUMMARY_BEAN) {
	}

	public void preBlock() {
	}

	public void whenCreateRecord() {
	}

	public void whenNewRecordInstance() {
	}

	public void postQuery() {
	}

	public void preDelete() {
	}

	public void whenNewBlockInstance() {
	}

	public void executeQuery(PILT024_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PS_IL_POL_INVEST_SUMMARY_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PS_IL_POL_INVEST_SUMMARY> dataList = compositeAction
					.getPS_IL_POL_INVEST_SUMMARY_ACTION_BEAN()
					.getDataList_PS_IL_POL_INVEST_SUMMARY();
			if (dataList != null && dataList.size() > 0) {
				PS_IL_POL_INVEST_SUMMARY PS_IL_POL_INVEST_SUMMARY_BEAN = dataList
						.get(0);
				PS_IL_POL_INVEST_SUMMARY_BEAN.setRowSelected(true);
				compositeAction.getPS_IL_POL_INVEST_SUMMARY_ACTION_BEAN()
						.setPS_IL_POL_INVEST_SUMMARY_BEAN(
								PS_IL_POL_INVEST_SUMMARY_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}