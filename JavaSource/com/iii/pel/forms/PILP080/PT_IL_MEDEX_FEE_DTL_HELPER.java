package com.iii.pel.forms.PILP080;

import java.util.List;

import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_MEDEX_FEE_DTL_HELPER {


	public void executeQuery(PILP080_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_MEDEX_FEE_DTL_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PT_IL_MEDEX_FEE_DTL> dataList = compositeAction.
	getPT_IL_MEDEX_FEE_DTL_ACTION_BEAN().getDataList_PT_IL_MEDEX_FEE_DTL();
	 if(dataList!=null && dataList.size() > 0){
		PT_IL_MEDEX_FEE_DTL PT_IL_MEDEX_FEE_DTL_BEAN = dataList.get(0);
		PT_IL_MEDEX_FEE_DTL_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_MEDEX_FEE_DTL_ACTION_BEAN()
		.setPT_IL_MEDEX_FEE_DTL_BEAN(PT_IL_MEDEX_FEE_DTL_BEAN);
	}
	}
	public void WHEN_NEW_RECORD_INSTANCE(PILP080_COMPOSITE_ACTION compositeAction)throws Exception{
		try{
		PT_IL_PV_MED_HDR_ACTION PT_IL_PV_MED_HDR_ACTION_BEAN=compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN();
		DUMMY_ACTION DUMMY_ACTION_BEAN=compositeAction.getDUMMY_ACTION_BEAN();
		if("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PV_MED_HDR_ACTION_BEAN.getPT_IL_PV_MED_HDR_BEAN().getPMH_APPRV_STATUS(), "N"))){
			PT_IL_PV_MED_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DTLS().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_APPRV_STATUS().setRendered(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ERR_DTLS().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_REP().setDisabled(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_GENERATE().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
		}else{
			PT_IL_PV_MED_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DTLS().setDisabled(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_APPRV_STATUS().setRendered(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_REP().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_GENERATE().setDisabled(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
		}
		/*IF NVL(:PT_IL_PV_MED_HDR.PMH_APPRV_STATUS,'N') = 'A' THEN 
		 SET_ITEM_PROPERTY('PT_IL_PV_MED_HDR.M_BUT_DTLS',ENABLED,PROPERTY_FALSE);
		 SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE',ENABLED,PROPERTY_FALSE);
		 SET_ITEM_PROPERTY('DUMMY.M_BUT_GENERATE',ENABLED,PROPERTY_FALSE);
	 	 SET_ITEM_PROPERTY('DUMMY.M_BUT_REP',ENABLED,PROPERTY_TRUE);
		 SET_ITEM_PROPERTY('DUMMY.M_BUT_ERR_DTLS',ENABLED,PROPERTY_FALSE);
		 SET_ITEM_PROPERTY('DUMMY.M_APPRV_STATUS',VISIBLE,PROPERTY_TRUE);
	ELSE
		 SET_ITEM_PROPERTY('PT_IL_PV_MED_HDR.M_BUT_DTLS',ENABLED,PROPERTY_TRUE);
		 SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE',ENABLED,PROPERTY_TRUE);
		 SET_ITEM_PROPERTY('DUMMY.M_BUT_REP',ENABLED,PROPERTY_FALSE);
		 SET_ITEM_PROPERTY('DUMMY.M_BUT_GENERATE',ENABLED,PROPERTY_TRUE);
		 SET_ITEM_PROPERTY('DUMMY.M_APPRV_STATUS',VISIBLE,PROPERTY_FALSE);
	END IF;	 */
		
	
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
		}
	}
	public void WHEN_NEW_BLOCK_INSTANCE(PILP080_COMPOSITE_ACTION compositeAction)throws Exception{
		try{PT_IL_PV_MED_HDR_ACTION PT_IL_PV_MED_HDR_ACTION_BEAN=compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN();
		DUMMY_ACTION DUMMY_ACTION_BEAN=compositeAction.getDUMMY_ACTION_BEAN();
		if("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_PV_MED_HDR_ACTION_BEAN.getPT_IL_PV_MED_HDR_BEAN().getPMH_APPRV_STATUS(), "N"))){
			PT_IL_PV_MED_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DTLS().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_APPRV_STATUS().setRendered(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_ERR_DTLS().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_REP().setDisabled(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_GENERATE().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
		}else{
			PT_IL_PV_MED_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DTLS().setDisabled(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_APPRV_STATUS().setRendered(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_REP().setDisabled(true);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_GENERATE().setDisabled(false);
			DUMMY_ACTION_BEAN.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
		}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
public void Pre_Query(PILP080_COMPOSITE_ACTION compositeAction){
	if(compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN().getPMH_SYS_ID()!=null){
		compositeAction.getPT_IL_MEDEX_FEE_DTL_ACTION_BEAN().getPT_IL_MEDEX_FEE_DTL_BEAN().setMFD_FLEX_05(compositeAction.getPT_IL_PV_MED_HDR_ACTION_BEAN().getPT_IL_PV_MED_HDR_BEAN().getPMH_SYS_ID());
	}
}	

}