package com.iii.pel.forms.PILT020;

import java.sql.Connection;
import java.sql.ResultSet;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_INT_LOAN_DELEGATE {
	PT_IL_LOAN_INT_COLL collectionBean ;
	public PT_IL_LOAN_INT_COLL populateDetails(PT_IL_PREM_COLL premCollBean) throws Exception{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName); 
		PT_IL_PREM_COLL premBean1 = actionBean.getDUMMY_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		Connection con = null;
		
		ResultSet rst = null;
		CRUDHandler handler = null;
		
		int premColleSysid =premBean1.getPC_SYS_ID();
		
		System.out.println("Chandra  PC_SYS_ID is"+premBean1.getPC_SYS_ID()+"premColleSysid....."+premColleSysid);
		String selectQuery = "select tab1.rowid,tab1.* from PT_IL_LOAN_INT_COLL tab1 where LIC_PC_SYS_ID= "+premBean1.getPC_SYS_ID()+" ";
		System.out.println("Query Called .........."+selectQuery);
		con = CommonUtils.getConnection();
		if(con != null){
			handler = new CRUDHandler();
			/*Object[] values = { premColleSysid };
			rst = handler.executeSelectStatement(selectQuery, con, values);*/
			rst = handler.executeSelectStatement(selectQuery, con);
			collectionBean = new PT_IL_LOAN_INT_COLL();
			if(rst.next()){
				collectionBean.setROWID(rst.getString("ROWID"));
				collectionBean.setLIC_SYS_ID(rst.getInt("LIC_SYS_ID"));
				collectionBean.setLIC_LOAN_SYS_ID(rst.getInt("LIC_LOAN_SYS_ID"));
				collectionBean.setLIC_PC_SYS_ID(rst.getInt("LIC_PC_SYS_ID"));
				collectionBean.setLIC_PYMT_DT(rst.getDate("LIC_PYMT_DT"));
				collectionBean.setLIC_LC_INT_AMT(rst.getDouble("LIC_LC_INT_AMT"));
				collectionBean.setLIC_FC_INT_AMT(rst.getDouble("LIC_FC_INT_AMT"));
				collectionBean.setLIC_PAID_FLAG(rst.getString("LIC_PAID_FLAG"));
				collectionBean.setLIC_CR_DT(rst.getDate("LIC_CR_DT"));
				collectionBean.setLIC_CR_UID(rst.getString("LIC_CR_UID"));
				collectionBean.setLIC_UPD_DT(rst.getDate("LIC_UPD_DT"));
				collectionBean.setLIC_UPD_UID(rst.getString("LIC_UPD_UID"));
				collectionBean.setLIC_INT_RATE(rst.getDouble("LIC_INT_RATE"));
				collectionBean.setUI_M_FC_BAL_LOAN_AMT(1000.0);
				collectionBean.setUI_M_FC_REPAID_AMT(250.0);
				collectionBean.setUI_M_LC_BAL_LOAN_AMT(222.0);
				collectionBean.setUI_M_LC_REPAID_AMT(333.0);
				collectionBean.setUI_M_LOAN_FC_AMOUNT(252.0);
				collectionBean.setUI_M_LOAN_LC_AMOUNT(525.0);
			}
			
		}
		if(rst!= null){
			rst.close();
		}
		double lc_value = collectionBean.getLIC_LC_INT_AMT();
		double fc_value = collectionBean.getLIC_FC_INT_AMT();
		lc_value = java.lang.Math.rint(lc_value);
		fc_value = java.lang.Math.rint(fc_value);
		collectionBean.setLIC_LC_INT_AMT(lc_value);
		collectionBean.setLIC_FC_INT_AMT(fc_value);	
	
		return collectionBean;
	}

}
