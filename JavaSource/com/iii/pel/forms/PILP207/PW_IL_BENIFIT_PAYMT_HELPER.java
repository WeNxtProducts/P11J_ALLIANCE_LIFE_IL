package com.iii.pel.forms.PILP207;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

public class PW_IL_BENIFIT_PAYMT_HELPER {
	public void executeQuery(PILP207_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PW_IL_BENIFIT_PAYMT_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PW_IL_BENIFIT_PAYMT> dataList = compositeAction
				.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN()
				.getDataList_PW_IL_BENIFIT_PAYMT();
		if (dataList != null && dataList.size() > 0) {
			PW_IL_BENIFIT_PAYMT PW_IL_BENIFIT_PAYMT_BEAN = dataList.get(0);
			PW_IL_BENIFIT_PAYMT_BEAN.setRowSelected(true);
			compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN()
					.setPW_IL_BENIFIT_PAYMT_BEAN(PW_IL_BENIFIT_PAYMT_BEAN);
		}
		
	}
	public void re_generate_executeQuery(PILP207_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PW_IL_BENIFIT_PAYMT_DELEGATE()
				.executeSelectStatement_1(compositeAction);

		
		
	}
	
	public String WHEN_BUTTON_PRESSED_M_BUT_OK()
	{
		

		String url = null;		
		
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		
		url = request.getContextPath() + "/PaynetProcessServlet?";
		
		System.out.println("url   :  "+url);
	return url;	
	}

}
