package com.iii.pel.forms.PILP018;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.event.ActionEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_CHEQ_DISHONOUR;
import com.iii.pel.utils.PKG_PILP018_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PILP018_HELPER {
    
    public void PT_IL_CHEQUE_BOUNCE_HEADER_when_new_Record_Instance(PT_IL_CHEQUE_BOUNCE_HDR_ACTION pt_il_cheque_bounce_hdr_action){
	PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN = pt_il_cheque_bounce_hdr_action.getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
	if("N".equals(CommonUtils.getGlobalVariable("GLOBAL_M_REVERSAL_FLAG"))){
		String CBH_TXN_TYPE = PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_TXN_TYPE();
		if(CBH_TXN_TYPE!=null){
			if(CBH_TXN_TYPE.equals("PC")){
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(false);
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);

			}else if( CommonUtils.isIN(CBH_TXN_TYPE, "QD","PD","DR")) {
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(false);
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
			}else if(CBH_TXN_TYPE.equals("LR")){
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(false);	
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
			}	
			else{
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
			    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
			}
		}	
	}else{
	    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);
		pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
		pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
	}

	if("FALSE".equals(CommonUtils.getGlobalVariable("GLOBAL.M_CHECK_FLAG"))){
		 CommonUtils.setGlobalVariable("GLOBAL.M_CHECK_FLAG","TRUE");
	}
}
	public void PT_IL_CHEQUE_BOUNCE_HEADER_when_New_Form_Instance(PT_IL_CHEQUE_BOUNCE_HDR_ACTION pt_il_cheque_bounce_hdr_action){
	    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PREM_DTLS().setDisabled(true);
	    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_DEP_REFUND_DTLS().setDisabled(true);
	    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_LOAN_REPAY_DTLS().setDisabled(true);
	    pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PRINT().setDisabled(true);
	}

	public void PT_IL_CHEQUE_BOUNCE_HEADER_When_New_Block_Instance(DUMMY dummy,PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) throws Exception{
		 Connection con = CommonUtils.getConnection();
	        try
	        {
	            String M_WHERE=null;
	            String M_TEMP=null;
	            if(dummy.getUI_M_CHQ_NO() != null && dummy.getUI_M_BANK_CODE() != null)
	            {
	                M_WHERE=" CBH_CHQ_NO = '"+dummy.getUI_M_CHQ_NO()+"' AND CBH_BANK_CODE='"+dummy.getUI_M_BANK_CODE()+"'";
	                PT_IL_CHEQUE_BOUNCE_HDR_BEAN.setM_WHERE(M_WHERE);
	            }
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	    }
	
    public void PT_IL_CHEQUE_BOUNCE_HEADER_POST_QUERY(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) throws DBException{
    	String M_TXN_TYPE_DESC = null;
    	Connection con = CommonUtils.getConnection();
     
    	try {
	    String selectQuery = "SELECT LIV_CODE_DESC FROM  PP_LIST_ITEM_VALUES  "
		    + " WHERE  LIV_SYS_PARAM  = 'IL_TXN_TYPE'  AND LIV_CODE  = ? ";

	    ResultSet rs =  new CRUDHandler().executeSelectStatement(selectQuery, con,
		    new Object[] { PT_IL_CHEQUE_BOUNCE_HDR_BEAN
			    .getCBH_TXN_TYPE() });
	    while (rs.next()) {
		M_TXN_TYPE_DESC = rs.getString("LIV_CODE_DESC");
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN
			.setUI_M_TXN_TYPE_DESC(M_TXN_TYPE_DESC);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }
    
    public void  PT_IL_PREM_COLL_WHEN_NEW_BLOCK_INSTANCE(PT_IL_PREM_COLL PT_IL_PREM_COLL_BEAN, PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) throws  Exception {
	String M_WHERE=null; 
	try {
		    M_WHERE =" PC_SYS_ID = " + PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_PC_SYS_ID()+
		    "  AND PC_POL_SYS_ID = "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_POL_SYS_ID();			 	   	  
		    PT_IL_PREM_COLL_BEAN.setM_WHERE(M_WHERE);
		    
		 //   SET_BLOCK_PROPERTY('PT_IL_PREM_COLL',DEFAULT_WHERE,' PC_SYS_ID = '||
		    //:PT_IL_CHEQUE_BOUNCE_HDR.CBH_PC_SYS_ID ||' AND PC_POL_SYS_ID =' ||:PT_IL_CHEQUE_BOUNCE_HDR.CBH_POL_SYS_ID ) ;
		 //   EXECUTE_QUERY; 
		  //  SET_BLOCK_PROPERTY('PT_IL_PREM_COLL',DEFAULT_WHERE,'') ;
		 
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void  PT_IL_DEPOSIT_WHEN_NEW_BLOCK_INSTANCE( PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR,PT_IL_DEPOSIT PT_IL_DEPOSIT_BEAN) throws  Exception {
	String M_WHERE=null; 
	try {
	    M_WHERE =" DEP_SYS_ID = " + PT_IL_CHEQUE_BOUNCE_HDR.getCBH_DEP_SYS_ID() ;			 	   	  
	    PT_IL_DEPOSIT_BEAN.setM_WHERE(M_WHERE);
	  
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void  PT_IL_LOAN_REPAYMENT_WHEN_NEW_BLOCK_INSTANCE( PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR,PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN) throws  Exception {
	String M_WHERE=null; 
	try {
	    M_WHERE =" LR_SYS_ID = " + PT_IL_CHEQUE_BOUNCE_HDR.getCBH_LR_SYS_ID() ;			 	   	  
	    PT_IL_LOAN_REPAYMENT_BEAN.setM_WHERE(M_WHERE);
	    // 	EXECUTE_QUERY; 
	    //  SET_BLOCK_PROPERTY('PT_IL_LOAN_REPAYMENT',DEFAULT_WHERE,'') ;
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }

    public void PT_IL_LOAN_REPAYMENT_POST_QUERY(PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN) throws Exception{
	Connection connection=null;
	String 	CURSOR_C1 =" SELECT LOAN_POL_NO,LOAN_DT  FROM  PT_IL_LOAN" +
			" WHERE  LOAN_SYS_ID  =? ";
	   ResultSet rs =null;
	try {
	    connection = CommonUtils.getConnection();
	      rs = new CRUDHandler().executeSelectStatement(CURSOR_C1, connection,
		    new Object[]{PT_IL_LOAN_REPAYMENT_BEAN.getLR_LOAN_SYS_ID()});
	    while(rs.next()){
		PT_IL_LOAN_REPAYMENT_BEAN.setUI_M_LOAN_NO(rs.getString(1));
		   PT_IL_LOAN_REPAYMENT_BEAN.setUI_M_LOAN_DT(rs.getString(2));
	    }
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	} 
	finally{
	    CommonUtils.closeCursor(rs);
	}
	    
	}
    public void PT_IL_DEPOSIT_POST_QUERY(PT_IL_DEPOSIT PT_IL_DEPOSIT,PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN) throws Exception{
	Connection connection=null;
	String 	CURSOR_C1 =" SELECT PD_DPD_REF_ID FROM   PT_IL_PYMT_DTLS WHERE " +
			" PD_TXN_SYS_ID =?  AND    PD_TXN_TYPE =? ";
	ResultSet rs =null;
	try {
	    connection = CommonUtils.getConnection();
	    rs = new CRUDHandler().executeSelectStatement(CURSOR_C1, connection,
		    new Object[]{PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_DEP_SYS_ID(),
		    PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getCBH_TXN_TYPE()});
	    while(rs.next()){
		 PT_IL_DEPOSIT.setUI_M_DPD_REF_ID( rs.getString(1));
	    }
	    if(CommonUtils.nvl( (Integer)CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE"),0)> 0 ){
		
		   PT_IL_DEPOSIT.setUI_M_DEP_FC_DEP_AMT(PT_IL_DEPOSIT.getDEP_LC_DEP_AMT() *  
			   (Integer)CommonUtils.getGlobalObject("GLOBAL.EXCH_RATE"));
	    }else{
		PT_IL_DEPOSIT.setUI_M_DEP_FC_DEP_AMT(PT_IL_DEPOSIT.getDEP_LC_DEP_AMT() *  1);
		//  :PT_IL_DEPOSIT.M_DEP_FC_DEP_AMT:=:PT_IL_DEPOSIT.DEP_LC_DEP_AMT * 1;
	    }
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	} 
	finally{
	    CommonUtils.closeCursor(rs);
	}
    }
    
    public void M_CHQ_NO_When_Validate_Item( PILP018_COMPOSITE_ACTION compositeAction) throws Exception{
	   
        Connection con = CommonUtils.getConnection();
        	String   M_REVERSAL_FLAG =null;
      int    M_COUNT	=0;	
      String M_REVERSAL_FLAG_1  =null;		
            String M_DUMMY_RECEIPT	=null;		
            String M_CBH_REASON_CODE=null;
            String M_CBH_REMARKS 	=null;
            String M_DEP_PDC_FLAG    =null;
    String     CURSOR_C1 ="SELECT COUNT(*) FROM  PT_IL_PYMT_DTLS  " +
    		" WHERE  PD_CHQ_NO  = ? " +
    		"  AND PD_PAY_MODE  IN ( 'C'  , 'L'  , 'O'  ) ";
	 
    String  CURSOR_C2 ="SELECT NVL(DPD_CHQ_REVERSED, 'N') FROM  PT_IL_DEPOSIT_PYMT_DTLS" +
    		" WHERE  DPD_REF_ID  =? ";
		 
    String CURSOR_C3 ="SELECT  PD_SYS_ID, PD_TXN_TYPE,PD_TXN_SYS_ID,PD_PAY_MODE,PD_CURR_CODE,PD_FC_AMT," +
    		"PD_LC_AMT, PD_BRANCH_NAME,PD_CUST_NAME,PD_ADDR_01,PD_ADDR_02,PD_ADDR_03," +
    		" PD_DPD_REF_ID FROM  PT_IL_PYMT_DTLS  WHERE  PD_CHQ_NO  =? " +
    		" AND PD_BANK_NAME  = ?  AND PD_PAY_MODE IN ( 'C'  , 'L'  , 'O'  ) " +
    		"  AND PD_PAID_FOR  = 'D' ";
		
   String CURSOR_C4 =" SELECT LIV_CODE_DESC FROM  PP_LIST_ITEM_VALUES  WHERE  " +
   		" LIV_SYS_PARAM  = 'IL_TXN_TYPE'  AND LIV_CODE  = ? " ;
   
   String CURSOR_C5 = "SELECT   CBH_REVERSE_YN,CBH_REASON_CODE,CBH_REMARKS FROM " +
   		" PT_IL_CHEQUE_BOUNCE_HDR  WHERE CBH_CHQ_NO  =?   AND " +
   		" CBH_BANK_CODE  =? " ;
    
   String CURSOR_C6 = "SELECT NVL(DEP_PDC_FLAG,'N') FROM PT_IL_PYMT_DTLS,PT_IL_DEPOSIT  " +
   		" WHERE  PD_CHQ_NO  = ?  AND PD_BANK_NAME  = ? " 
            	+" AND PD_PAY_MODE  IN ( 'C'  , 'L'  , 'O'  )  AND PD_TXN_SYS_ID  = DEP_SYS_ID  AND " 
            	+" PD_TXN_TYPE  = " + "DECODE(DEP_TYPE, 'P', 'PD', 'Q', 'QD') ";
   
   String CURSOR_C8 = " SELECT 'X' FROM  PT_IL_RECEIPT_HEADER  WHERE  RH_CHQ_NO  =?  " +
   		" AND RH_BANK_NAME  =? " ;
   CRUDHandler handler = new CRUDHandler();
   ResultSet rs1=null,rs2=null,rs3=null,rs4=null,rs5=null,rs6=null;
   PT_IL_CHEQUE_BOUNCE_HDR_ACTION pt_il_cheque_bounce_hdr_action = compositeAction.getPT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN();
   DUMMY dummy = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
   PT_IL_PYMT_DTLS  pt_il_pymt_dtls = compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getPT_IL_PYMT_DTLS_BEAN();
        try
        {
            compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getBeanList().clear();
            CommonUtils.setGlobalVariable("GLOBAL.M_REVERSAL_FLAG","N");
            ResultSet rs8=handler.executeSelectStatement(CURSOR_C8, con,
        	    new Object[]{dummy.getUI_M_CHQ_NO(),dummy.getUI_M_BANK_CODE()});
            while(rs8.next())
            {
                M_DUMMY_RECEIPT=rs8.getString(1);
                throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91400"));
            }
              rs1=handler.executeSelectStatement(CURSOR_C1,con,
        	    new Object[]{dummy.getUI_M_CHQ_NO()});
            while(rs1.next())
            {
                M_COUNT=rs1.getInt(1);
            }
            if(M_COUNT==0)
            {
        	 throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91307"));
            } 
              rs6=handler.executeSelectStatement( CURSOR_C6,con,
        	      new Object[]{dummy.getUI_M_CHQ_NO(), dummy.getUI_M_BANK_CODE()});
            while(rs6.next())
            {
                M_DEP_PDC_FLAG=rs6.getString(1);
            } 
            if("Y".equals(CommonUtils.nvl(M_DEP_PDC_FLAG,"N")))
            {
        	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91395"));   
            }
              rs3= handler.executeSelectStatement(CURSOR_C3, con,
        	    new Object[]{dummy.getUI_M_CHQ_NO(),dummy.getUI_M_BANK_CODE()});		 
         while(rs3.next()){
             pt_il_pymt_dtls = new PT_IL_PYMT_DTLS();
            pt_il_pymt_dtls.setPD_SYS_ID(rs3.getInt(1));
            pt_il_pymt_dtls.setPD_TXN_TYPE(rs3.getString(2));
            pt_il_pymt_dtls.setPD_TXN_SYS_ID(rs3.getInt(3));
            pt_il_pymt_dtls.setPD_PAY_MODE(rs3.getString(4));
            pt_il_pymt_dtls.setPD_CURR_CODE(rs3.getString(5));
            pt_il_pymt_dtls.setPD_FC_AMT(rs3.getDouble(6));
            pt_il_pymt_dtls.setPD_LC_AMT(rs3.getDouble(7));
            pt_il_pymt_dtls.setPD_BRANCH_NAME(rs3.getString(8));
            pt_il_pymt_dtls.setPD_CUST_NAME(rs3.getString(9));
            pt_il_pymt_dtls.setPD_ADDR_01(rs3.getString(10));
            pt_il_pymt_dtls.setPD_ADDR_02(rs3.getString(11));
            pt_il_pymt_dtls.setPD_ADDR_03(rs3.getString(12));
            pt_il_pymt_dtls.setPD_DPD_REF_ID(rs3.getString(13));
            compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getBeanList().add(pt_il_pymt_dtls);
         }
         if(compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getBeanList().size()>0){
             compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().setPT_IL_PYMT_DTLS_BEAN(
        	     compositeAction.getPT_IL_PYMT_DTLS_ACTION_BEAN().getBeanList().get(0));
         }
         if(rs3==null && !rs3.next()){
             throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91307"));   
         }
           rs4= handler.executeSelectStatement(CURSOR_C4, con,
        	    new Object[]{  pt_il_pymt_dtls.getPD_TXN_TYPE()}) ;

        	    while(rs4.next()){
        		pt_il_pymt_dtls.setUI_M_PD_TXN_TYPE_DESC(rs4.getString(1));
        	    }
         	 
        	    ArrayList<String> arrList = new DBProcedures().P_VAL_CURR( pt_il_pymt_dtls.getPD_CURR_CODE(),
        		    "N","N",null);
        		    if(arrList.get(0)!=null)
        			pt_il_pymt_dtls.setUI_M_PD_CURR_CODE_DESC(arrList.get(0));

        	    rs2= handler.executeSelectStatement(CURSOR_C2, con,
     	        	    new Object[]{  pt_il_pymt_dtls.getPD_DPD_REF_ID()}) ;
     	        	    while(rs4.next()){
     	        		M_REVERSAL_FLAG = rs2.getString(1);
     	        	    }
     	        	 
     		              if("Y".equals(M_REVERSAL_FLAG))
     		               {
     		        	 CommonUtils.setGlobalVariable("GLOBAL.M_REVERSAL_FLAG","Y");
     		        	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91309"));   
     		               }
     		              else{

     		        	  new P9ILPK_CHEQ_DISHONOUR().INS_AFFECTED_TRANS_DTLS(
     		        		  pt_il_pymt_dtls.getPD_DPD_REF_ID(),
     		        		  dummy.getUI_M_CHQ_NO(),dummy.getUI_M_BANK_CODE());
     		              }
     		           rs5= handler.executeSelectStatement(CURSOR_C5, con,
     		        	 new Object[]{dummy.getUI_M_CHQ_NO(),dummy.getUI_M_BANK_CODE()}) ;
	     	        	    while(rs4.next()){
	     	        		M_REVERSAL_FLAG_1 = rs5.getString(1);
	     	        		M_CBH_REASON_CODE = rs5.getString(2);
	     	        		M_CBH_REMARKS = rs5.getString(3);
	     	        	    }
	     	        	if("Y".equals(M_REVERSAL_FLAG_1))
	     		         {
	     	        	    
         			 pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PRINT().setDisabled(false);
         			 compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_REVERSE().setDisabled(true);
         			 dummy.setUI_M_CBH_REASON_CODE(M_CBH_REASON_CODE);
         			dummy.setUI_M_CBH_REMARKS(M_CBH_REMARKS);
	     		         }else{
         		  	compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_REVERSE().setDisabled(false);
         			 pt_il_cheque_bounce_hdr_action.getCOMP_UI_M_BUT_PRINT().setDisabled(true);
	     		         }
        }
        catch (Exception e) {
	    // TODO: handle exception
            e.printStackTrace();
	}
}
    
    public void M_BUT_REVERSE_WHEN_BUTTON_PRESSED(DUMMY dummy, PT_IL_PYMT_DTLS pt_il_pymt_dtls,
		  PT_IL_CHEQUE_BOUNCE_HDR_ACTION PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN) throws Exception {
		      
		        try
		        { 
		          ArrayList<OracleParameter> orclList =  new PKG_PILP018_APAC().M_BUT_REVERSE_W_B_P(dummy.getUI_M_CHQ_NO(),
		        	    dummy.getUI_M_BANK_CODE(), 
		        	    pt_il_pymt_dtls.getPD_TXN_TYPE(), pt_il_pymt_dtls.getPD_TXN_SYS_ID(), 
		        	    pt_il_pymt_dtls.getPD_SYS_ID(), pt_il_pymt_dtls.getPD_DPD_REF_ID(),
		        	    dummy.getUI_M_CBH_REASON_CODE(),dummy.getUI_M_CBH_REMARKS(),
		        	     null);
		          if("TRUE".equals((String)orclList.get(0).getValueObject())){
		              PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PRINT().setDisabled( false);
		          }
		          else{
		              PT_IL_CHEQUE_BOUNCE_HDR_ACTION_BEAN.getCOMP_UI_M_BUT_PRINT().setDisabled(true );
		              
		          }
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		    
		}

	public void M_CBH_REASON_CODE_when_validate_item(DUMMY dummy ) throws Exception{
	    try {
		if(dummy.getUI_M_CBH_REASON_CODE()!=null){
	         ArrayList<String> arrayList = new DBProcedures().P_VAL_CODES("REV_REASON",                  
	                    dummy.getUI_M_CBH_REASON_CODE(),                  
	                    "N",  "E",    null); 
	         if(arrayList.get(0)!=null){
	             dummy.setUI_M_REASON_CODE_DESC( arrayList.get(0));     
	         }
		} 
		
	    } catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	    }
	}
	    public void M_BANK_CODE_when_validate_item(DUMMY dummy,  
		    PT_IL_PYMT_DTLS pt_il_pymt_dtls) throws Exception{
		String  M_PD_BANK_NAME=null;
		String  M_PD_TXN_TYPE=null;
		String  M_PD_TXN_SYS_ID=null;
		String  M_PD_CURR_CODE=null;
		String  M_PD_SYS_ID=null;
		String  M_PD_PAY_MODE=null;
		
		String CURSOR_C2 =" SELECT LIV_CODE_DESC  FROM   PP_LIST_ITEM_VALUES" +
				" WHERE  LIV_SYS_PARAM = 'IL_TXN_TYPE' AND  " +
				" LIV_CODE =? ";
						  					  					  
		String CURSOR_C3 ="  SELECT DECODE(? ,'ENG',BANK_NAME,BANK_NAME_BL) " +
				" FROM   FM_BANK  WHERE  BANK_CODE=? ";	

		String CURSOR_C5="  SELECT 'X'  FROM   FM_BANK   WHERE  BANK_CODE = ?";	
		Connection con = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs2=null,rs3=null,rs5=null;
			try
			{
				  rs5=handler.executeSelectStatement(CURSOR_C5, con,
					new Object[]{dummy.getUI_M_BANK_CODE()});
				if(rs5.next()){
				    M_PD_BANK_NAME = rs5.getString(1);  
				}else{
				    throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91310"));
				}
				double M_COUNT=-1;
				String  M_CBH_SYS_ID=null;
				  rs2=handler.executeSelectStatement(CURSOR_C2, con,
					new Object[]{pt_il_pymt_dtls.getPD_TXN_TYPE()});
					if(rs2.next())
					{
					    pt_il_pymt_dtls.setUI_M_PD_TXN_TYPE_DESC(rs2.getString(1));
					}
			if(pt_il_pymt_dtls.getPD_CURR_CODE()!=null){
			    ArrayList<String> arrList	=new DBProcedures().P_VAL_CURR(
					pt_il_pymt_dtls.getPD_CURR_CODE(),
					              "N", "N",null);
			    if(arrList!=null && arrList.get(0)!= null)
				 pt_il_pymt_dtls.setUI_M_PD_CURR_CODE_DESC(arrList.get(0));
			}
			if(dummy.getUI_M_BANK_CODE() !=null){
			      rs3=handler.executeSelectStatement(CURSOR_C3, con,
					new Object[]{CommonUtils.getControlBean().getM_LANG_CODE(),
				    dummy.getUI_M_BANK_CODE()});					
    			if(rs3.next()){
    			    dummy.setUI_M_BANK_DESC(rs3.getString(1));
    			}else{
    			    throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206"));    
    			}
    			 
    			dummy.setUI_M_CHQ_NO("");
			}
			}
			 catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			finally
			{
				CommonUtils.closeCursor(rs2); 
				CommonUtils.closeCursor(rs3); 
				CommonUtils.closeCursor(rs5); 
			}

	}

}
