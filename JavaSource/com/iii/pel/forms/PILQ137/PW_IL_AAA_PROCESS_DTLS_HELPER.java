package com.iii.pel.forms.PILQ137;

import java.util.List;

public class PW_IL_AAA_PROCESS_DTLS_HELPER {
	public void executeQuery(PILQ137_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PW_IL_AAA_PROCESS_DTLS_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PW_IL_AAA_PROCESS_DTLS> dataList = compositeAction
				.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN()
				.getDataList_PW_IL_AAA_PROCESS_DTLS();
		if (dataList != null && dataList.size() > 0) {
			PW_IL_AAA_PROCESS_DTLS PW_IL_AAA_PROCESS_DTLS_BEAN = dataList.get(0);
			PW_IL_AAA_PROCESS_DTLS_BEAN.setRowSelected(true);
			compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN()
					.setPW_IL_AAA_PROCESS_DTLS_BEAN(PW_IL_AAA_PROCESS_DTLS_BEAN);
		}
		
	}
	public void executeQuery1(PILQ137_COMPOSITE_ACTION compositeAction)
			throws Exception {
		/*Modifed by Saranya on 20/04/2017
		 * 
		 * new PW_IL_AAA_PROCESS_DTLS_DELEGATE()
				.executeSelectStatement(compositeAction);*/
		
		new PW_IL_AAA_PROCESS_DTLS_DELEGATE()
		.executeSelectStatement1(compositeAction);

		/*End*/
		
		List<PW_IL_AAA_PROCESS_DTLS> dataList = compositeAction
				.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN()
				.getDataList_PW_IL_AAA_PROCESS_DTLS_CA();
		if (dataList != null && dataList.size() > 0) {
			PW_IL_AAA_PROCESS_DTLS PW_IL_AAA_PROCESS_DTLS_BEAN = dataList.get(0);
			PW_IL_AAA_PROCESS_DTLS_BEAN.setRowSelected(true);
			compositeAction.getPW_IL_AAA_PROCESS_DTLS_ACTION_BEAN()
					.setPW_IL_AAA_PROCESS_DTLS_BEAN(PW_IL_AAA_PROCESS_DTLS_BEAN);
		}
		
	}

}
