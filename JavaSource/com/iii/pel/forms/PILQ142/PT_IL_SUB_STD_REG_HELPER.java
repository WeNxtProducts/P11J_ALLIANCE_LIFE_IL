package com.iii.pel.forms.PILQ142;

public class PT_IL_SUB_STD_REG_HELPER {

	public void executeQuery(PILQ142_COMPOSITE_ACTION compositeAction) throws Exception{
		new PT_IL_SUB_STD_REG_DELEGATE().executeSelectStatement(compositeAction);
	}
}
