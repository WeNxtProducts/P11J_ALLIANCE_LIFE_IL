package com.iii.pel.forms.PILP018;

import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CHEQUE_BOUNCE_HDR_HELPER {

    public void WHEN_NEW_FORM_INSTANCE(PT_IL_CHEQUE_BOUNCE_HDR_ACTION PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN) {
	try {
	     PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
	     PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
	     PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);
	     PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PRINT().setDisabled(true);
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void WHEN_NEW_RECORD_INSTANCE(PT_IL_CHEQUE_BOUNCE_HDR_ACTION PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN) {
	try {
	    PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
	    if("N".equals(CommonUtils.getGlobalVariable("GLOBAL.M_REVERSAL_FLAG"))){
		if("PC".equals( PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_TXN_TYPE())){ 
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(false);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);
			 
		}else if(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_TXN_TYPE()!=null && CommonUtils.isIN(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_TXN_TYPE(), "QD","PD","DR")){
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(false);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
		}
		else if("LR".equals( PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_TXN_TYPE())){ 	 
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(false);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
		}else{
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true );
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
		}
	    }
	    else{
		 PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true );
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
		    PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
	    }
	    if("FALSE".equals(CommonUtils.getGlobalVariable("GLOBAL.M_CHECK_FLAG"))){
		 //GO_ITEM('DUMMY.M_CBH_REASON_CODE');	
		 CommonUtils.setGlobalVariable("GLOBAL.M_CHECK_FLAG","TRUE");
	    }

	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void  WHEN_NEW_BLOCK_INSTANCE(PILP018_COMPOSITE_ACTION  compositeAction ) throws  Exception {
	String M_WHERE=null; 
	String M_TEMP=null; 
	try {
	    DUMMY DUMMY_BEAN=compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	    PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		if(DUMMY_BEAN.getUI_M_CHQ_NO() !=null &&
			DUMMY_BEAN.getUI_M_BANK_CODE() !=null){
		    M_WHERE =" CBH_CHQ_NO = '" + DUMMY_BEAN.getUI_M_CHQ_NO() +
		    		"' AND CBH_BANK_CODE= '" + DUMMY_BEAN.getUI_M_BANK_CODE()+"'";			 	   	  
		 PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setM_WHERE(M_WHERE);
		 new PT_IL_CHEQUE_BOUNCE_HDR_DELEGATE().executeSelectStatement(compositeAction);
		}
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public void POST_QUERY(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) throws Exception {
	String CURSOR_C1 =" SELECT LIV_CODE_DESC  FROM   PP_LIST_ITEM_VALUES  WHERE " +
			" LIV_SYS_PARAM	 = 'IL_TXN_TYPE'  AND  LIV_CODE  = ? ";
	ResultSet rs=null;
	
	try {
	    rs = new CRUDHandler().executeSelectStatement(CURSOR_C1, CommonUtils.getConnection(),
		    		new Object[]{PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_TXN_TYPE()});
	    while(rs.next()){
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setUI_M_TXN_TYPE_DESC(rs.getString(1));
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	finally{
	    CommonUtils.closeCursor(rs);
	}
    }
    
}
