package com.iii.pel.forms.PILP206;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class PW_IL_BALANCE_SUM_HELPER {
	public void executeQuery(PILP206_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PW_IL_BALANCE_SUM_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PW_IL_BALANCE_SUM> dataList = compositeAction
				.getPW_IL_BALANCE_SUM_ACTION_BEAN()
				.getDataList_PW_IL_BALANCE_SUM();
		if (dataList != null && dataList.size() > 0) {
			PW_IL_BALANCE_SUM PW_IL_BALANCE_SUM_BEAN = dataList.get(0);
			PW_IL_BALANCE_SUM_BEAN.setRowSelected(true);
			compositeAction.getPW_IL_BALANCE_SUM_ACTION_BEAN()
					.setPW_IL_BALANCE_SUM_BEAN(PW_IL_BALANCE_SUM_BEAN);
		}
		
	}
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		

		String url = null;		
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		url = request.getContextPath() + "/SmartStreamProcessServlet?";
		
		System.out.println("url   :  "+url);
	return url;	
	}

}
