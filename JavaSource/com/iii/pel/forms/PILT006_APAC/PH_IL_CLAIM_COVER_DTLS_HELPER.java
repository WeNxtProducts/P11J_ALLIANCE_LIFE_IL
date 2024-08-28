package com.iii.pel.forms.PILT006_APAC;

import java.util.List;

import com.iii.premia.common.utils.DBProcedures;

public class PH_IL_CLAIM_COVER_DTLS_HELPER {

	/**
	 * 
	 * @param PT_IL_CLAIM_COVER_DTLS_BEAN
	 * @param PH_IL_CLAIM_COVER_DTLS_BEAN
	 */
	public void preQuery(PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN,PH_IL_CLAIM_COVER_DTLS PH_IL_CLAIM_COVER_DTLS_BEAN){
		PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_CLAIM_SYS_ID(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CLAIM_SYS_ID());
		PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_SYS_ID(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_SYS_ID());
		PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_COVER_CODE(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE());
		PH_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_RESERVE_GEN_FLAG("N");
		
	}
	
	public void preInsert() {
	}

	public void postInsert() {
	}

	public void preUpdate() {
	}

	public void preBlock() {
	}

	public void whenCreateRecord() {
	}

	public void whenNewRecordInstance() {
	}
	
	/**
	 * 
	 * @param PH_IL_CLAIM_COVER_DTLS_BEAN
	 */
	public void postQuery(PH_IL_CLAIM_COVER_DTLS PH_IL_CLAIM_COVER_DTLS_BEAN) throws Exception{
		
		DBProcedures dbProcedure = new DBProcedures();

		List<String> coverList = dbProcedure.callP_VAL_COVER_PROC(PH_IL_CLAIM_COVER_DTLS_BEAN
				.getCCDH_COVER_CODE(), PH_IL_CLAIM_COVER_DTLS_BEAN
				.getUI_M_CCDH_COVER_CODE_DESC(), null, "N", "N");
		if(coverList!=null){
			PH_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCDH_COVER_CODE_DESC(coverList.get(0));
		}

		List<String> losTypeList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_LOS_TYP", PH_IL_CLAIM_COVER_DTLS_BEAN.getCCDH_LOSS_TYPE(),
				"N", "N");
		if(losTypeList!=null){
			PH_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCDH_LOSS_TYPE_DESC(losTypeList.get(0));
		}


		List<String> disableList = dbProcedure.P_VAL_CODES_PROC_CALL("IL_DIS_TYP", PH_IL_CLAIM_COVER_DTLS_BEAN.getCCDH_DISAB_TYPE(),
				"N", "N");
		if(disableList!=null){
			PH_IL_CLAIM_COVER_DTLS_BEAN.setUI_M_CCDH_DISAB_TYPE_DESC(disableList.get(0));
		}

	}

	public void preDelete() {
	}
	
	/**
	 * 
	 * @param PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN
	 */
	public void whenNewBlockInstance(PH_IL_CLAIM_COVER_DTLS_ACTION PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN) {
		PH_IL_CLAIM_COVER_DTLS_ACTION_BEAN.disableAllComponent(true);
	}

	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PH_IL_CLAIM_COVER_DTLS_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PH_IL_CLAIM_COVER_DTLS> dataList = compositeAction
				.getPH_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getDataList_PH_IL_CLAIM_COVER_DTLS();
		if (dataList != null && dataList.size() > 0) {
			PH_IL_CLAIM_COVER_DTLS PH_IL_CLAIM_COVER_DTLS_BEAN = dataList
					.get(0);
			PH_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);
			compositeAction
					.getPH_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.setPH_IL_CLAIM_COVER_DTLS_BEAN(PH_IL_CLAIM_COVER_DTLS_BEAN);
		}
	}
}
