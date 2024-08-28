package com.iii.pel.forms.PILT020;

import java.util.ArrayList;

import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_BROKER_VALUES_HELPER {

	//block level triggers 
	public void trig_pre_query_pt_il_broker_values()
	{
		/*SET_BLOCK_PROPERTY('PT_IL_BROKER_VALUES',
                DEFAULT_WHERE,
	           'PT_IL_BROKER_VALUES.BV_PC_SYS_ID = ' ||
                    TO_CHAR(:PT_IL_PREM_COLL.PC_SYS_ID)
               );
*/
	}
	
	public void trig_post_query_pt_il_broker_values()throws Exception{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName); 
		PT_IL_BROKER_VALUES brokerBean = actionBean.getPT_IL_BROKER_VALUES_ACTION_BEAN().getPT_IL_BROKER_VALUES_BEAN();
		
		DBProcedures dbproc = new DBProcedures();
		ArrayList<String >list  = dbproc.callPKG_PILT002_P_VAL_CUST(brokerBean.getBV_BROKER_CODE(),brokerBean.getUI_M_BROKER_DESC(),"N","N");
		brokerBean.setUI_M_BROKER_DESC(list.get(0));

		ArrayList<String>list1  = dbproc.helperP_VAL_COVER(brokerBean.getBV_COVER_CODE(),brokerBean.getUI_M_COVER_DESC(), "N", "N");
		brokerBean.setUI_M_COVER_DESC(list1.get(0));
	}
	
	
}
