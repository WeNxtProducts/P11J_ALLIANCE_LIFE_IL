package com.iii.pel.forms.PILT020;

import java.sql.Connection;

import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PREM_COLL_CHARGE_HELPER {
	
	// block level triggers
	public void trig_when_new_block_instance()
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
	/*	
		SET_BLOCK_PROPERTY('PT_IL_PREM_COLL_CHARGE',UPDATE_ALLOWED, PROPERTY_FALSE);
		SET_BLOCK_PROPERTY('PT_IL_PREM_COLL_CHARGE',INSERT_ALLOWED, PROPERTY_FALSE);
		SET_BLOCK_PROPERTY('PT_IL_PREM_COLL_CHARGE',DELETE_ALLOWED, PROPERTY_FALSE);*/

	}
	
	public void trig_post_query_pt_il_prem_coll_charge(String code,String desc) throws Exception
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		Connection con = utility.getConnection();
		//String code = actionBean.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getPCC_CHARGE_CODE();
		//String desc = actionBean.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().getUI_M_CHARGE_DESC();
		String code2 =  actionBean.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getCOMP_PCC_CHARGE_CODE().getValue().toString();
		System.out.println("Joshuva......"+code2);
		PILT020_DB_PROCEDURES db_proc = new PILT020_DB_PROCEDURES();
		String Desc = db_proc.P_VAL_CODES(con,"IL_CHARGE",code,desc,"N","N",null);
		System.out.println("The charge Desc in post query is=========>"+Desc);
		actionBean.getPT_IL_PREM_COLL_CHARGE_ACTION_BEAN().getPT_IL_PREM_COLL_CHARGE_BEAN().setUI_M_CHARGE_DESC(Desc);
	}
	
	
	 
}
