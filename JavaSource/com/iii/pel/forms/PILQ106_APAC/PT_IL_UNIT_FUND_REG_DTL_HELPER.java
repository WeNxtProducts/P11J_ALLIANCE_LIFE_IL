package com.iii.pel.forms.PILQ106_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_UNIT_FUND_REG_DTL_HELPER {

	public void executeQuery(PILQ106_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_UNIT_FUND_REG_DTL_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_UNIT_FUND_REG_DTL> dataList = compositeAction
				.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN()
				.getDataList_PT_IL_UNIT_FUND_REG_DTL();
		
		if (dataList != null && dataList.size() > 0) {
			compositeAction.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN()
					.setPT_IL_UNIT_FUND_REG_DTL_BEAN(dataList.get(0));
			dataList.get(0).setRowSelected(true);
		}
		compositeAction.getPT_IL_UNIT_FUND_REG_DTL_ACTION_BEAN().resetAllComponent();
	}
	
	public  void preQuery(PT_IL_UNIT_FUND_REG_HDR PT_IL_UNIT_FUND_REG_HDR_BEAN,PT_IL_UNIT_FUND_REG_DTL PT_IL_UNIT_FUND_REG_DTL_BEAN) {
	    String M_WHERE=null; 
	    try {
		 
		if ("H".equals(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TYPE() )&&
			"B".equals(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_BUY_SEL() )){
				 
		      M_WHERE ="UFRD_UFRH_SYS_ID = " + PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_SYS_ID() +" AND  UFRD_UNIT_PUR_LC_AMT IS NOT NULL";
		}else if("H".equals(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TYPE() ) &&
			"S".equals(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_BUY_SEL() )){	
		      M_WHERE ="UFRD_UFRH_SYS_ID = " + PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_SYS_ID() + " AND  UFRD_UNIT_SEL_LC_AMT IS NOT NULL ";
		}
		PT_IL_UNIT_FUND_REG_DTL_BEAN.setM_WHERE(M_WHERE);
		  // SET_BLOCK_PROPERTY('PT_IL_UNIT_FUND_REG_DTL',DEFAULT_WHERE,M_WHERE);
		
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	    
	}
	
	public void postQuery(PT_IL_UNIT_FUND_REG_HDR PT_IL_UNIT_FUND_REG_HDR_BEAN,PT_IL_UNIT_FUND_REG_DTL  PT_IL_UNIT_FUND_REG_DTL){
	    Double M_PS_VALUE =null;
	    String M_UFRH_BUY_SEL =null;
	    
	    String CURSOR_C1 ="  SELECT FS_DESC   FROM   PM_IL_FUND_SETUP " +
	    		"   WHERE  FS_CODE = ? ";
	    String CURSOR_C2 ="   SELECT UFRH_BUY_SEL  FROM   PT_IL_UNIT_FUND_REG_HDR" +
	    		"  WHERE  UFRH_SYS_ID=?  ";
	    String CURSOR_C3 ="	 SELECT BSET_BUY_SELL  FROM   PM_IL_BONUS_SETUP" +
	    		" WHERE  BSET_BONUS_CODE = (SELECT BON_BONUS_CODE " +
	    		" FROM   PT_IL_BONUS  WHERE  BON_SYS_ID = ? ) " +
	    		" AND    BSET_PLAN_CODE = (SELECT POL_PLAN_CODE  FROM   PT_IL_POLICY " +
	    		" WHERE  POL_SYS_ID = ? )";
	    String CURSOR_C4 ="   SELECT PS_VALUE   FROM   PP_SYSTEM   WHERE  PS_TYPE = 'IL_BUYSEL' ";
	    CRUDHandler handler = new CRUDHandler();
	    ResultSet resultSet_C1 = null;
		ResultSet resultSet_C2 = null, resultSet_C3 = null, resultSet_C4 = null;
		Connection connection = null;
		 try { 
		     connection = CommonUtils.getConnection();
		     resultSet_C1 = handler.executeSelectStatement(CURSOR_C1,
				    connection, new Object[]{PT_IL_UNIT_FUND_REG_DTL.getUFRD_FUND_CODE() } );
			    while (resultSet_C1.next()) {
				PT_IL_UNIT_FUND_REG_DTL.setUFRD_FUND_DESC(resultSet_C1.getString(1));
			    } 
			    if (!"B".equals(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TYPE() )&&
					!"H".equals(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TYPE() )){
				 resultSet_C2 = handler.executeSelectStatement(CURSOR_C2,
					    connection, new Object[]{ PT_IL_UNIT_FUND_REG_DTL.getUFRD_UFRH_SYS_ID() } );
				    while (resultSet_C2.next()) {
					M_UFRH_BUY_SEL =resultSet_C2.getString(1) ;
				    } 
				  if("B".equals( M_UFRH_BUY_SEL )){
				      PT_IL_UNIT_FUND_REG_DTL.setUI_M_UNIT_PRICE(PT_IL_UNIT_FUND_REG_DTL.getUFRD_UNIT_PUR_LC_AMT());
				  }else if("S".equals(M_UFRH_BUY_SEL )){
				      PT_IL_UNIT_FUND_REG_DTL.setUI_M_UNIT_PRICE(PT_IL_UNIT_FUND_REG_DTL.getUFRD_UNIT_SEL_LC_AMT());
				  } 
			    }else if("B".equals( PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TYPE())){
				      resultSet_C3 = handler.executeSelectStatement(CURSOR_C3,  connection,
					      new Object[]{ PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TRANS_SYS_ID(),
					      	PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_POL_SYS_ID()  });
					    while (resultSet_C3.next()) {
						M_UFRH_BUY_SEL =resultSet_C3.getString(1) ;
					    } 
					    if("B".equals( M_UFRH_BUY_SEL )){
						 PT_IL_UNIT_FUND_REG_DTL.setUI_M_UNIT_PRICE(PT_IL_UNIT_FUND_REG_DTL.getUFRD_UNIT_PUR_LC_AMT());
					    }else if("S".equals( M_UFRH_BUY_SEL )){
					    	PT_IL_UNIT_FUND_REG_DTL.setUI_M_UNIT_PRICE(PT_IL_UNIT_FUND_REG_DTL.getUFRD_UNIT_SEL_LC_AMT());
					    }
			    }else if("H".equals(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TYPE())){
				      resultSet_C4 = handler.executeSelectStatement(CURSOR_C4,  connection );
					    while (resultSet_C4.next()) {
						M_PS_VALUE =resultSet_C4.getDouble(1) ;
					    } 
				 	 if(M_PS_VALUE==1){
				 	 	  PT_IL_UNIT_FUND_REG_DTL.setUI_M_UNIT_PRICE(
				 	 		  PT_IL_UNIT_FUND_REG_DTL.getUFRD_UNIT_PUR_LC_AMT());
				 	 }else if( M_PS_VALUE ==2 ){
				 	     PT_IL_UNIT_FUND_REG_DTL.setUI_M_UNIT_PRICE(
				 		     PT_IL_UNIT_FUND_REG_DTL.getUFRD_UNIT_SEL_LC_AMT());
				 	 }
				  }

			    PT_IL_UNIT_FUND_REG_DTL.setUI_M_END_UNIT((PT_IL_UNIT_FUND_REG_DTL.getUFRD_START_UNITS())-( PT_IL_UNIT_FUND_REG_DTL.getUFRD_NO_OF_UNITS()));

		if("AJ".equals(CommonUtils.nvl(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_TYPE(),"X")) &&
			"IM50754".equals(CommonUtils.nvl(PT_IL_UNIT_FUND_REG_HDR_BEAN.getUFRH_CR_UID(),"X"))){
					     
			 PT_IL_UNIT_FUND_REG_DTL.setUI_M_UNIT_PRICE(PT_IL_UNIT_FUND_REG_DTL.getUFRD_UNIT_SEL_LC_AMT());
			 resultSet_C2 = handler.executeSelectStatement(CURSOR_C2,
				    connection, new Object[]{ PT_IL_UNIT_FUND_REG_DTL.getUFRD_UFRH_SYS_ID() } );
			    while (resultSet_C2.next()) {
				M_UFRH_BUY_SEL =resultSet_C2.getString(1) ;
			    } 
			    if("B".equals( M_UFRH_BUY_SEL )){
				PT_IL_UNIT_FUND_REG_DTL.setUI_M_END_UNIT( (PT_IL_UNIT_FUND_REG_DTL.getUFRD_START_UNITS())+( PT_IL_UNIT_FUND_REG_DTL.getUFRD_NO_OF_UNITS()));
			    }else if("S".equals(M_UFRH_BUY_SEL )){
				PT_IL_UNIT_FUND_REG_DTL.setUI_M_END_UNIT( (PT_IL_UNIT_FUND_REG_DTL.getUFRD_START_UNITS())-( PT_IL_UNIT_FUND_REG_DTL.getUFRD_NO_OF_UNITS()));
			    }  	 
				 	  
		}	 
		PT_IL_UNIT_FUND_REG_DTL.setUI_M_END_UNIT_VALUE((PT_IL_UNIT_FUND_REG_DTL.getUI_M_UNIT_PRICE())*
					( PT_IL_UNIT_FUND_REG_DTL.getUI_M_END_UNIT()));	
		PT_IL_UNIT_FUND_REG_DTL.setUI_M_END_UNIT_VALUE( new DBProcedures().P_VAL_ROUND_AMT(CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR"),     
			 PT_IL_UNIT_FUND_REG_DTL.getUI_M_END_UNIT_VALUE(),"R",null));  

		    
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		}
	}
	

}
