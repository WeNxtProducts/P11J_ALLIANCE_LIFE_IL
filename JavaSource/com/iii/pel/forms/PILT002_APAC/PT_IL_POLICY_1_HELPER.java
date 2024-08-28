package com.iii.pel.forms.PILT002_APAC;

import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_1_HELPER {

    public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POLICY_1_DELEGATE().executeSelectStatement(compositeAction);
    }

    public  void WHEN_NEW_BLOCK_INSTANCE(PILT002_APAC_COMPOSITE_ACTION compositeAction) {
	String M_CURR_BLK= null;       
	String M_CURR_ITEM= null;       
	String M_TEMP_ITEM= null;       
	          
	 /*	M_CURR_BLK    := :SYSTEM.CURSOR_BLOCK;
	        M_CURR_ITEM   := :SYSTEM.CURSOR_ITEM;*/
	PT_IL_POLICY pt_il_policy_bean = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PT_IL_POLICY_ACTION pt_il_policy_action = compositeAction.getPT_IL_POLICY_ACTION_BEAN();

	try {
	 			
	 			/*IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
	 			   COPY('P','CTRL.M_COMM_DEL') ;
	 			   COPY('20','SYSTEM.MESSAGE_LEVEL');
	 			   POST;                   
	 			   COPY('0','SYSTEM.MESSAGE_LEVEL');
	 			   COPY('','CTRL.M_COMM_DEL') ;
	 			   :PT_IL_POLICY.POL_RES_ADDRESS_1 := :PT_IL_POLICY.POL_RES_ADDRESS_1;   
	 			END IF;*/
	    
	 	if("Y".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_INCORPORATED_YN(),"N"))){
	 		 /*if( M_CURR_ITEM IN ( 'PT_IL_POLICY.POL_FC_BANK_ALLOC_AMT',
	 			 'PT_IL_POLICY.POL_LC_BANK_ALLOC_AMT',
	 		    'PT_IL_POLICY.POL_FC_CLIENT_ALLOC_AMT',
	 		    'PT_IL_POLICY.POL_LC_CLIENT_ALLOC_AMT',
	 			         'PT_IL_POLICY.POL_FC_TOT_SA','PT_IL_POLICY.POL_LC_TOT_SA') {
	 			   		 			M_TEMP_ITEM := 'PT_IL_POLICY_1.POL_FC_BASIC_PREM_1' ;			         
	 		 } else	{		   		 						         
	 			M_TEMP_ITEM := M_CURR_ITEM ;	 						         
	 		 }*/
	 						 
	 	//	 GO_ITEM(M_TEMP_ITEM);
	 			   		
	 		pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT().setDisabled(false);//',ENABLED,PROPERTY_TRUE);
	 		//pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);
	 		
	 		 if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2,1))){
	 		     pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT().setDisabled( false);
	 		 }
	 		 pt_il_policy_action.getCOMP_POL_FC_BANK_ALLOC_AMT().setRequired( true);
	 		 
	 		 pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT().setDisabled( false);
	 		// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_BANK_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);
	 						 
	 		 if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2,1))){
	 		     pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT().setDisabled( false);
	 		 }
	 		 pt_il_policy_action.getCOMP_POL_LC_BANK_ALLOC_AMT().setRequired( true);
	 		 pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT().setDisabled( false);
	 		// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_CLIENT_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);
	 		
	 		 if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2,1))){
	 		     pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT().setDisabled( false);
	 		 }
	 		 pt_il_policy_action.getCOMP_POL_FC_CLIENT_ALLOC_AMT().setRequired( true);
	 		 
	 		 pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT().setDisabled( false);
	 		// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_LC_CLIENT_ALLOC_AMT',NAVIGABLE,PROPERTY_TRUE);
	 		if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2,1))){
	 		     pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT().setDisabled( false);
	 		 } 
	 		 pt_il_policy_action.getCOMP_POL_LC_CLIENT_ALLOC_AMT().setRequired( true);

			 pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled( false);
			// SET_ITEM_PROPERTY('PT_IL_POLICY.POL_FC_TOT_SA',NAVIGABLE,PROPERTY_TRUE);
	 		
	 		if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2,1))){
	 		    pt_il_policy_action.getCOMP_POL_FC_TOT_SA().setDisabled( false);
	 		} 
	 		pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled( false);
			//  pt_il_policy_action.getCOMP_POL_LC_TOT_SA()',NAVIGABLE,PROPERTY_TRUE);
	 		if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(2,1))){
		 	 
			  pt_il_policy_action.getCOMP_POL_LC_TOT_SA().setDisabled( false);
	 		}
	 					   
	 		//			   GO_ITEM(M_CURR_ITEM);
	 	}
	 		//	COPY('20','SYSTEM.MESSAGE_LEVEL');
	 	executeQuery(compositeAction);
	 		 
	 		//	COPY('0','SYSTEM.MESSAGE_LEVEL');
	 
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    public  void PRE_BLOCK() {
	
	/*IF FORM_FAILURE THEN
	   :GLOBAL.M_FAILURE := 'TRUE';
	END IF;
	:CTRL.M_DELETE_MSG_FLAG := 'N';*/
	////CommonUtils.setGlobalVariable( "M_DELETE_MSG_FLAG", "N");
    }
    
}
