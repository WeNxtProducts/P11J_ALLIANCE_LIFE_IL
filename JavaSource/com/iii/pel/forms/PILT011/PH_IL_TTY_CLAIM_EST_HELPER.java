package com.iii.pel.forms.PILT011;

import java.util.List;



public class PH_IL_TTY_CLAIM_EST_HELPER {
	public void executeQuery(PILT011_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PH_IL_TTY_CLAIM_EST_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PH_IL_TTY_CLAIM_EST> dataList = compositeAction
				.getPH_IL_TTY_CLAIM_EST_ACTION_BEAN()
				.getDataList();
		if (dataList != null && dataList.size() > 0) {
			PH_IL_TTY_CLAIM_EST PH_IL_TTY_CLAIM_EST_BEAN = dataList.get(0);
			PH_IL_TTY_CLAIM_EST_BEAN.setRowSelected(true);
			compositeAction.getPH_IL_TTY_CLAIM_EST_ACTION_BEAN()
					.setPH_IL_TTY_CLAIM_EST_BEAN(PH_IL_TTY_CLAIM_EST_BEAN);
		}
	}

}
