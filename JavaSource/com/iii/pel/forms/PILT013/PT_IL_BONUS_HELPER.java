package com.iii.pel.forms.PILT013;

import java.util.List;

public class PT_IL_BONUS_HELPER {
	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_BONUS_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_BONUS> dataList = compositeAction
				.getPT_IL_BONUS_ACTION_BEAN().getDataList_PT_IL_BONUS();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_BONUS PT_IL_BONUS_BEAN = dataList.get(0);
			PT_IL_BONUS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().setPT_IL_BONUS_BEAN(
					PT_IL_BONUS_BEAN);
		}else{
			/*compositeAction.getPT_IL_BONUS_ACTION_BEAN().getCOMP_BON_BONUS_CODE().setValue("");
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().getCOMP_BON_FC_BONUS_AMT().setValue("");
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().getCOMP_BON_LC_BONUS_AMT().setValue("");
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().getCOMP_BON_BONUS_DESC().setValue("");*/
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().getPT_IL_BONUS_BEAN().setBON_BONUS_CODE("");
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().getPT_IL_BONUS_BEAN().setUI_BON_BONUS_DESC("");
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().getPT_IL_BONUS_BEAN().setBON_FC_BONUS_AMT(0.00);
			compositeAction.getPT_IL_BONUS_ACTION_BEAN().getPT_IL_BONUS_BEAN().setBON_LC_BONUS_AMT(0.00);
		}
	}

}
