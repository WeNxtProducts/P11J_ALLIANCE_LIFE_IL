package com.iii.pel.forms.PILQ138;


public class PREMIUM_ENQU_HELPER {

	public void executeQuery(PILQ138_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PREMIUM_ENQU_DELEGATE()
					.executeSelectStatement(compositeAction);
			if(compositeAction.getPREMIUM_ENQU_ACTION_BEAN().getDataList_PREMIUM_ENQU().size()>0){
				compositeAction.getPREMIUM_ENQU_ACTION_BEAN().setPREMIUM_ENQU_BEAN(
						compositeAction.getPREMIUM_ENQU_ACTION_BEAN().getDataList_PREMIUM_ENQU().get(0));
				compositeAction.getPREMIUM_ENQU_ACTION_BEAN().getPREMIUM_ENQU_BEAN().setRowSelected(true);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
