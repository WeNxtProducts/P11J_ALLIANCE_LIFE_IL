package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY2_HELPER {

    public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POLICY2_DELEGATE().executeSelectStatement(compositeAction);
    }
    
    public void WHEN_NEW_BLOCK_INSTANCE(PILQ003_COMPOSITE_ACTION compositeAction ){
	
	PT_IL_POLICY pt_il_policy_bean = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	PT_IL_POLICY2 pt_il_policy2_bean = compositeAction
	.getPT_IL_POLICY2_ACTION_BEAN().getPT_IL_POLICY2_BEAN();
	
	P9ILPK_POLICY p9ilpk_policy = new P9ILPK_POLICY();
	Connection connection = null;
	ResultSet rs1 = null,rs2=null,rs3=null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();
	 Double M_POL_LC_BASIC_PREM = 0d;
	    Double M_POL_LC_ADDL_PREM = 0d;
	    Double M_POL_LC_DISC_AMT  = 0d;
	    Double M_POL_LC_FIRST_PREM = 0d;
	    Double M_POL_LC_SUM_ASSURED = 0d;
	    Double M_POL_MODE_OF_PYMT_RATE = 0d;
	    Double M_POL_BASIC_RATE = 0d;
	    String  M_PROD_PREM_CALC_MTHD= null;
	   
	    String query1 = "SELECT POL_LINK_SYS_ID   FROM   PT_IL_POLICY" +
	    		"   WHERE  POL_SYS_ID = ? ";
	  	
	    String query2 = " SELECT  POL_LC_BASIC_PREM,POL_LC_ADDL_PREM,POL_LC_SUM_ASSURED," +
	    		"  POL_LC_DISC_AMT,POL_LC_FIRST_PREM, POL_MODE_OF_PYMT_RATE," +
	    		"  POL_BASIC_RATE   FROM   PT_IL_POLICY" +
	    		"   WHERE  POL_SYS_ID= ? ";
	  	   
	    String query3 = "  SELECT PROD_PREM_CALC_MTHD    FROM   PM_IL_PRODUCT" +
	    		"  WHERE  PROD_CODE=? ";

	try {
	    connection = CommonUtils.getConnection();
	   
	     values = new Object[]{ pt_il_policy_bean.getPOL_SYS_ID()};
	     
	     rs1 = new CRUDHandler().executeSelectStatement(query1, connection,values);
	     if(rs1.next()){
		 dummy_bean.setUI_M_POL_LINK_SYS_ID(rs1.getLong(1));
	     }
	     values = new Object[]{ dummy_bean.getUI_M_POL_LINK_SYS_ID()};
	     rs2 = new CRUDHandler().executeSelectStatement(query2, connection,values);
	     if(rs2.next()){
		  pt_il_policy2_bean.setUI_M_POL_LC_BASIC_PREM(rs2.getDouble(1 ));
		  pt_il_policy2_bean.setUI_M_POL_LC_ADDL_PREM(rs2.getDouble( 2));
		  pt_il_policy2_bean.setUI_M_POL_LC_SA(rs2.getDouble( 3));
		  pt_il_policy2_bean.setUI_M_POL_LC_DISC_AMT(rs2.getDouble(4 ));
		  pt_il_policy2_bean.setUI_M_POL_LC_FIRST_PREM(rs2.getDouble(5 ));
		  pt_il_policy2_bean.setUI_M_POL_MODE_OF_PYMT_RATE(rs2.getDouble(6 ));
		  pt_il_policy2_bean.setUI_M_POL_BASIC_RATE(rs2.getDouble( 7));
	     }
	     
	     values = new Object[]{ pt_il_policy_bean.getPOL_PROD_CODE()};
	     
	     rs3 = new CRUDHandler().executeSelectStatement(query3, connection,values);
	     if(rs3.next()){
		 M_PROD_PREM_CALC_MTHD = rs3.getString(1);
	     }
	     
	    if( dummy_bean.getUI_M_CALC_METHOD() == 2 || 
		  (  dummy_bean.getUI_M_CALC_METHOD() == 1 &&
			!"M".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),"X"))) || 
	      	     (dummy_bean.getUI_M_CALC_METHOD() == 1 &&
	      "M".equals(CommonUtils.nvl(dummy_bean.getUI_M_POL_PLAN_TYPE(),"X")) &&
	      "T".equals(CommonUtils.nvl(M_PROD_PREM_CALC_MTHD,"X")))){
	      
	       pValList =  p9ilpk_policy.P_DISPLAY_PREMIUM(dummy_bean.getUI_M_POL_LINK_SYS_ID().toString(),
		       null,null,null,null,null,
		       null,null,null,null,null,
		       null,null,null,null,null,null,
		       null,null,null,null,null,null);
 
					                
	    pt_il_policy2_bean.setUI_M_POL_FC_TOT_PREM(Double.parseDouble(pValList.get(0 ))); 
	    pt_il_policy2_bean.setUI_M_POL_LC_TOT_PREM(Double.parseDouble(pValList.get( 1)));
	    pt_il_policy2_bean.setUI_M_POL_FC_TOT_LOADING(Double.parseDouble(pValList.get(2 )));
	    pt_il_policy2_bean.setUI_M_POL_LC_TOT_LOADING(Double.parseDouble(pValList.get(3) ));
	    pt_il_policy2_bean.setUI_M_POL_FC_TOT_DISCOUNT(Double.parseDouble(pValList.get( 4)));
	    pt_il_policy2_bean.setUI_M_POL_LC_TOT_DISCOUNT(Double.parseDouble(pValList.get( 5)));
	    pt_il_policy2_bean.setUI_M_FC_PCHARGES_BORNE_CUST(Double.parseDouble(pValList.get( 6)));
	    pt_il_policy2_bean.setUI_M_LC_PCHARGES_BORNE_CUST(Double.parseDouble(pValList.get(7)));
	    pt_il_policy2_bean.setUI_M_FC_PCHARGES_BORNE_COMP(Double.parseDouble(pValList.get(8)));
	    pt_il_policy2_bean.setUI_M_LC_PCHARGES_BORNE_COMP(Double.parseDouble(pValList.get(9)));
	    pt_il_policy2_bean.setUI_M_FC_SCHARGES_BORNE_CUST(Double.parseDouble(pValList.get(10)));
	    pt_il_policy2_bean.setUI_M_LC_SCHARGES_BORNE_CUST(Double.parseDouble(pValList.get(11)));
	    pt_il_policy2_bean.setUI_M_FC_SCHARGES_BORNE_COMP(Double.parseDouble(pValList.get(12)));
	    pt_il_policy2_bean.setUI_M_LC_SCHARGES_BORNE_COMP(Double.parseDouble(pValList.get(13)));
	    pt_il_policy2_bean.setUI_M_POL_FC_NET_PREM(Double.parseDouble(pValList.get(14)));
	    pt_il_policy2_bean.setUI_M_POL_LC_NET_PREM(Double.parseDouble(pValList.get(15)));
	    pt_il_policy2_bean.setUI_M_POL_INST_FC_PREM(Double.parseDouble(pValList.get(16)));
	    pt_il_policy2_bean.setUI_M_POL_INST_LC_PREM(Double.parseDouble(pValList.get(17)));
	    pt_il_policy2_bean.setUI_M_POL_FC_MOP(Double.parseDouble(pValList.get(18)));
	    pt_il_policy2_bean.setUI_M_POL_LC_MOP(Double.parseDouble(pValList.get(19)));
	    pt_il_policy2_bean.setUI_M_POL_FC_GR_ANN_PREM(Double.parseDouble(pValList.get(20)));
	    pt_il_policy2_bean.setUI_M_POL_LC_GR_ANN_PREM(Double.parseDouble(pValList.get(21)));
		 	                
		 	                /*EXCEPTION
	   WHEN OTHERS THEN
	      L_DISPLAY_ERROR_MESSAGE;
	      RAISE FORM_TRIGGER_FAILURE;
	   END ;
	   */
	}
	     	IL_ENDT_QUOT_DIFF_PREM(compositeAction) ;
	   
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	finally{
	    try {
		CommonUtils.closeCursor(rs1);
		CommonUtils.closeCursor(rs2);
		CommonUtils.closeCursor(rs3);
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }

    
    public void IL_ENDT_QUOT_DIFF_PREM(PILQ003_COMPOSITE_ACTION compositeAction) {
	
	PT_IL_POLICY pt_il_policy_bean = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	PT_IL_POLICY2 pt_il_policy2_bean = compositeAction
	.getPT_IL_POLICY2_ACTION_BEAN().getPT_IL_POLICY2_BEAN();
	
	String query1 =" SELECT COUNT(PC_SYS_ID)  FROM   PT_IL_PREM_COLL" +
			" WHERE  PC_POL_SYS_ID  = ? " +
			"  AND    CommonUtils.nvl(PC_PAID_FLAG,'N')     =  'A'" +
			"  AND    PC_SCHD_PYMT_DT >=? ";
	
	String query2 =" SELECT PS_CODE   FROM   PP_SYSTEM  WHERE  PS_TYPE = 'IL_OCC_CHG' ";
	String query3 =" SELECT PLAN_TYPE  FROM   PM_IL_PLAN" +
			"  WHERE  PLAN_CODE =? ";
	
	Connection connection = null;
	ResultSet rs1 = null,rs2=null,rs3=null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();
	int M_COUNT=0;
	String M_PS_CODE=null;
	String M_PLAN_TYPE=null;
	
	try {
	
	     values = new Object[]{dummy_bean.getUI_M_POL_LINK_SYS_ID(), pt_il_policy_bean.getPOL_END_EFF_FROM_DT()};
	     rs1 = new CRUDHandler().executeSelectStatement(query1, connection,values);
	     if(rs1.next()){
		 M_COUNT = rs1.getInt(1);
	     }
	     
	     rs2 = new CRUDHandler().executeSelectStatement(query2, connection);
	     if(rs2.next()){
		 M_PS_CODE = rs2.getString(1);
	     }	
	     values = new Object[]{pt_il_policy_bean.getPOL_PLAN_CODE()};
	     rs3 = new CRUDHandler().executeSelectStatement(query3, connection,values);
	     if(rs3.next()){
		 M_PLAN_TYPE = rs3.getString(1);
	     }	
	
		if("002".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_TYPE(),"000")) && 
		   ( M_PS_CODE.equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_CODE(),"000")) ||
		  dummy_bean.getUI_M_PS_CODE().equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_CODE(),"000"))) ||
	     	( "013".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_TYPE(),"000")) ||
	     	"007".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_TYPE(),"000")) || 
	     	"012".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_TYPE(),"000")))) {
	     
	        if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_SA(),0) > 0  &&
	         CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_SA1(),0) != 0 ){
	           pt_il_policy2_bean.setUI_M_POL_LC_SA_DIFF(
	        	   Math.abs( CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_SA(),0)) -
	        	   Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_SA1(),0)));
		}else{
	        	pt_il_policy2_bean.setUI_M_POL_LC_SA_DIFF(0d);
		}
	        
	        if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_BASIC_PREM(),0) > 0 &&
	         CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_BASIC_PREM1(),0d) != 0 ){
	           pt_il_policy2_bean.setUI_M_POL_LC_BASIC_PREM_DIFF(
	        	   Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_BASIC_PREM(),0)) -
	        	   Math.abs(CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_BASIC_PREM1(),0)));
	        }else{
	        	 pt_il_policy2_bean.setUI_M_POL_LC_BASIC_PREM_DIFF(0d);
	        }
	          
	        if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_ADDL_PREM(),0)>0 &&
	        	CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_ADDL_PREM1(),0) != 0 ){
			  pt_il_policy2_bean.setUI_M_POL_LC_ADDL_PREM_DIFF(  
				   Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_ADDL_PREM(),0))  - 
			    Math.abs(CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_ADDL_PREM1(),0)));
		}else{
	        	 pt_il_policy2_bean.setUI_M_POL_LC_ADDL_PREM_DIFF(0d);
		}
	        
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_PREM(),0) >0 &&
		  CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_PREM1(),0)!= 0 ){
		    
			       pt_il_policy2_bean.setUI_M_POL_LC_TOT_PREM_DIFF(
		  Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_PREM(),0))  - 
			  Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_PREM1(),0)));
		}else{
			    	 pt_il_policy2_bean.setUI_M_POL_LC_TOT_PREM_DIFF(0d);
		}
			    
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_LOADING(),0)>0  &&
			CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_LOADING1(),0) != 0){
		    
		       pt_il_policy2_bean.setUI_M_POL_LC_TOT_LOADING_DIFF(
			        Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_LOADING(),0))  - 
				    Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_LOADING1(),0)));
		}else{
		    	 pt_il_policy2_bean.setUI_M_POL_LC_TOT_LOADING_DIFF(0d);
		}
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_DISCOUNT(),0)>0  &&
		CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_DISCOUNT1(),0) != 0 ){
		    pt_il_policy2_bean.setUI_M_POL_LC_TOT_DISCOUNT_DIFF(
			     Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_DISCOUNT(),0)) - 
			 Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_DISCOUNT1(),0)));
		}else{
		    pt_il_policy2_bean.setUI_M_POL_LC_TOT_DISCOUNT_DIFF(0d);
		}
			
		 if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_LC_PCHARGES_BORNE_CUST(),0)>0  &&
		   CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_PCHARGES_BORNE_CUST1(),0) != 0 ){
			pt_il_policy2_bean.setUI_M_LC_PCHARGES_BORNE_CUST_DIFF(
				 Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_LC_PCHARGES_BORNE_CUST(),0)) -
				 Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_PCHARGES_BORNE_CUST1(),0)));
		 }else {
			pt_il_policy2_bean.setUI_M_LC_PCHARGES_BORNE_CUST_DIFF(0d);
		 }
			    
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_LC_SCHARGES_BORNE_CUST(),0)>0  &&
			CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_SCHARGES_BORNE_CUST1(),0) !=0 ){
			        pt_il_policy2_bean.setUI_M_LC_SCHARGES_BORNE_CUST_DIFF(
		  Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_LC_SCHARGES_BORNE_CUST(),0)) - 
			  Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_SCHARGES_BORNE_CUST1(),0)));
		}else{
		    	pt_il_policy2_bean.setUI_M_LC_SCHARGES_BORNE_CUST_DIFF(0d);
		}
			
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_NET_PREM(),0)> 0 &&
			CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_NET_PREM1(),0) != 0 ){
			       pt_il_policy2_bean.setUI_M_POL_LC_NET_PREM_DIFF(
		 Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_NET_PREM(),0))    - 
			 Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_NET_PREM1(),0)));
		}else{
			pt_il_policy2_bean.setUI_M_POL_LC_NET_PREM_DIFF(0d);
		}
			    
		if( CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_MOP(),0)>0 &&
			CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_MOP1(),0) != 0 ){
			       pt_il_policy2_bean.setUI_M_POL_LC_MOP_DIFF(
		     Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_MOP(),0))  - 
			     Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_MOP1(),0)));
		}else{
			    	 pt_il_policy2_bean.setUI_M_POL_LC_MOP_DIFF(0d);
		}
			    
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_GR_ANN_PREM(),0) >0  &&
			CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_GR_ANN_PREM1(),0) != 0 ){
			       pt_il_policy2_bean.setUI_M_POL_LC_GR_ANN_PREM_DIFF(
			 Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_GR_ANN_PREM(),0)) -
			 Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_GR_ANN_PREM1(),0)));
		}else{
			    	 pt_il_policy2_bean.setUI_M_POL_LC_GR_ANN_PREM_DIFF(0d);
		}
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_INST_LC_PREM(),0)>0  &&
		CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_INST_LC_PREM1(),0) != 0 ){
			       pt_il_policy2_bean.setUI_M_POL_INST_LC_PREM_DIFF(
			 Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_INST_LC_PREM(),0)) - 
			 Math.abs(CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_INST_LC_PREM1(),0)));
		}else{
			       pt_il_policy2_bean.setUI_M_POL_INST_LC_PREM_DIFF(0d);
		}
			    
		if(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_DISC_AMT(),0)>0 &&
			CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_DISC_AMT1(),0)!= 0 ){
			 pt_il_policy2_bean.setUI_M_POL_LC_DISC_AMT_DIFF( 
		     Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_DISC_AMT(),0)) - 
		     Math.abs(CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_DISC_AMT1(),0)));
		}else{
			pt_il_policy2_bean.setUI_M_POL_LC_DISC_AMT_DIFF(0d);
		}
			    
		if( CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_FIRST_PREM(),0)> 0 &&
		CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0) != 0 ){
			pt_il_policy2_bean.setUI_M_POL_LC_FIRST_PREM_DIFF(
			 Math.abs(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_FIRST_PREM(),0)) - 
			 Math.abs(CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0)));
		}else{
			pt_il_policy2_bean.setUI_M_POL_LC_FIRST_PREM_DIFF(0d);
		}
			    
		if( CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0) >0 ){		   
			if(( "013".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_TYPE(),"000")) ||
				"007".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_TYPE(),"000")) ||
				"012".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_PROP_END_TYPE(),"000"))) &&
		(CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0) > 
			CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_FIRST_PREM(),0)) ){
			   	      pt_il_policy2_bean.setUI_M_PAYABLE_AMT(CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0)- CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_FIRST_PREM(),0));
			}else{
			       	  pt_il_policy2_bean.setUI_M_PAYABLE_AMT(0d);
			}
		}
	    
		}else{
		    	pt_il_policy2_bean.setUI_M_POL_LC_SA_DIFF(
		    		CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_SA(),0) +
		    		CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_SA1(),0));
		    		pt_il_policy2_bean.setUI_M_POL_LC_BASIC_PREM_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_BASIC_PREM(),0)  +   CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_BASIC_PREM1(),0));
		    		pt_il_policy2_bean.setUI_M_POL_LC_ADDL_PREM_DIFF( CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_ADDL_PREM(),0)   +   CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_ADDL_PREM1(),0));
			   pt_il_policy2_bean.setUI_M_POL_LC_TOT_PREM_DIFF( CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_PREM(),0)    +   CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_PREM1(),0));
			   pt_il_policy2_bean.setUI_M_POL_LC_TOT_LOADING_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_LOADING(),0) +   CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_LOADING1(),0));
			   pt_il_policy2_bean.setUI_M_POL_LC_TOT_DISCOUNT_DIFF (CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_TOT_DISCOUNT(),0)+   CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_TOT_DISCOUNT1(),0));			
			   pt_il_policy2_bean.setUI_M_LC_PCHARGES_BORNE_CUST_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_LC_PCHARGES_BORNE_CUST(),0) + CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_PCHARGES_BORNE_CUST1(),0));			                                                     
			   pt_il_policy2_bean.setUI_M_LC_SCHARGES_BORNE_CUST_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_LC_SCHARGES_BORNE_CUST(),0) + CommonUtils.nvl(pt_il_policy_bean.getUI_M_LC_SCHARGES_BORNE_CUST1(),0));			
			   pt_il_policy2_bean.setUI_M_POL_LC_NET_PREM_DIFF( CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_NET_PREM(),0)      + CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_NET_PREM1(),0));
			   pt_il_policy2_bean.setUI_M_POL_LC_MOP_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_MOP(),0)           + CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_MOP1(),0));
			   pt_il_policy2_bean.setUI_M_POL_LC_GR_ANN_PREM_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_GR_ANN_PREM(),0)   + CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_LC_GR_ANN_PREM1(),0));
			   pt_il_policy2_bean.setUI_M_POL_INST_LC_PREM_DIFF (CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_INST_LC_PREM(),0)     + CommonUtils.nvl(pt_il_policy_bean.getUI_M_POL_INST_LC_PREM1(),0));
			   pt_il_policy2_bean.setUI_M_POL_LC_DISC_AMT_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_DISC_AMT(),0)      + CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_DISC_AMT1(),0));
			   pt_il_policy2_bean.setUI_M_POL_LC_FIRST_PREM_DIFF(CommonUtils.nvl(pt_il_policy2_bean.getUI_M_POL_LC_FIRST_PREM(),0)    + CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0));
	      
			   if( CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0) >0 ){		   
			      if(!"M".equals(M_PLAN_TYPE )){
			         pt_il_policy2_bean.setUI_M_PAYABLE_AMT(CommonUtils.nvl(M_COUNT,0) * 
			        	 CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0));
			      }else{
			   	     pt_il_policy2_bean.setUI_M_PAYABLE_AMT(
			   		     CommonUtils.nvl(pt_il_policy_bean.getPOL_LC_FIRST_PREM1(),0));
			      }
			   }else{
			       pt_il_policy2_bean.setUI_M_PAYABLE_AMT(0d);
			   }
	   
		}
    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	
    }
    

    public void UI_M_POL_BASIC_RATE_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction,
	    Double currValue){
	PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN();
	PT_IL_POLICY pt_il_policy_bean = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	PT_IL_POLICY2 pt_il_policy2_bean = compositeAction
	.getPT_IL_POLICY2_ACTION_BEAN().getPT_IL_POLICY2_BEAN();
	
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	 String query1 = "SELECT   NVL(TAR_RATE_PER,1000) FROM   PM_IL_TARIFF" +
	 		"   WHERE  TAR_PLAN_CODE  = ? " +
	 		"   AND ? BETWEEN TAR_PERIOD_FROM AND TAR_PERIOD_TO" +
	 		"  AND  ?  BETWEEN TAR_AGE_FROM AND TAR_AGE_TO" +
	 		"  AND   TAR_FRZ_FLAG   = 'N' ";
	pt_il_policy2_bean.setUI_M_POL_BASIC_RATE(currValue);
	try {
	    connection = CommonUtils.getConnection();
	  
	   if(pt_il_policy_bean.getPOL_BASIC_RATE() < 0 ) {
	       throw new Exception(
			Messages.getString(
					PELConstants.pelErrorMessagePath,
					"71038",
					new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));

	       
	   }
	   values = new Object[]{  pt_il_policy_bean.getPOL_PLAN_CODE(), pt_il_policy_bean.getPOL_PERIOD(),
		   pt_il_pol_assured_dtls_bean.getPOAD_AGE()  };
	     
	     rs = new CRUDHandler().executeSelectStatement(query1, connection,values);
	     if(rs.next()){
		 dummy_bean.setUI_M_TAR_RATE_PER(rs.getDouble(1));
	     }
  
		 
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	finally{
	    try {
		CommonUtils.closeCursor(rs);
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
    

    public void POL_FC_BASIC_PREM_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction,
    	    String currValue){
    	
    	PT_IL_POLICY pt_il_policy_bean = compositeAction
    	.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
    	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
    	ArrayList<String> pValList = new ArrayList<String>();
    	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
    	
    	try {
	    pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(pt_il_policy_bean
		    .getPOL_CUST_CURR_CODE(), pt_il_policy_bean.getPOL_FC_BASIC_PREM().toString(), "V",
		    pt_il_policy_bean.getPOL_PROD_CODE());

	    pt_il_policy_bean.setPOL_FC_BASIC_PREM(Double.parseDouble(pValList
		    .get(0)));

	    pt_il_policy_bean.setPOL_LC_BASIC_PREM( 
		    CommonUtils.nvl(pt_il_policy_bean.getPOL_FC_BASIC_PREM(), 0)
		    * pt_il_policy_bean.getPOL_CUST_EXCH_RATE());

	    pValList = new ArrayList<String>();
	    pValList = pkg_pilt002_apac.P_VAL_ROUND_AMT(dummy_bean
		    .getUI_M_BASE_CURR(), pt_il_policy_bean
		    .getPOL_LC_BASIC_PREM().toString(), "R", pt_il_policy_bean
		    .getPOL_PROD_CODE());

	    pt_il_policy_bean.setPOL_LC_BASIC_PREM(Double.parseDouble(pValList
		    .get(0)));

    	 
    	} catch (Exception e) {
    	    // TODO: handle exception
    	    e.printStackTrace();
    	}
    	 
        }
    
    public void POL_BASIC_RATE2_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction,
	    String currValue){
	PT_IL_POL_ASSURED_DTLS pt_il_pol_assured_dtls_bean = compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN();
	PT_IL_POLICY pt_il_policy_bean = compositeAction
	.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
	Connection connection = null;
	ResultSet rs = null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();
	String query1 = " SELECT  NVL(TAR_RATE_PER,1000) FROM   PM_IL_TARIFF " +
			" WHERE  TAR_PLAN_CODE  =? " +
			"   AND  ?  BETWEEN TAR_PERIOD_FROM AND TAR_PERIOD_TO" +
			" AND   ?  BETWEEN TAR_AGE_FROM AND TAR_AGE_TO" +
			"   AND    TAR_FRZ_FLAG   = 'N' ";
	
	try {
	    connection = CommonUtils.getConnection();
	    if(pt_il_policy_bean.getPOL_BASIC_RATE() < 0 ) {
		       throw new Exception(
				Messages.getString(
						PELConstants.pelErrorMessagePath,
						"71038",
						new Object[] {
							CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));

		       
		   }
	 
	   values = new Object[]{  pt_il_policy_bean.getPOL_PLAN_CODE(), pt_il_policy_bean.getPOL_PERIOD(),
		   pt_il_pol_assured_dtls_bean.getPOAD_AGE()  };
	     
	     rs = new CRUDHandler().executeSelectStatement(query1, connection,values);
	     if(rs.next()){
		 dummy_bean.setUI_M_TAR_RATE_PER(rs.getDouble(1));
	     }
   
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
	finally{
	    try {
		CommonUtils.closeCursor(rs);
	    } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
    }
    

}
