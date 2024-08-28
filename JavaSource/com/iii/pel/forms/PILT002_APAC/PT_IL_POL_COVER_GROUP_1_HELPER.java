package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_COVER_GROUP_1_HELPER {

    public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POL_COVER_GROUP_1_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_IL_POL_COVER_GROUP_1> dataList = compositeAction
		.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN()
		.getDataList_PT_IL_POL_COVER_GROUP_1();
	if (dataList != null && dataList.size() > 0) {
	    PT_IL_POL_COVER_GROUP_1 PT_IL_POL_COVER_GROUP_1_BEAN = dataList
		    .get(0);
	    PT_IL_POL_COVER_GROUP_1_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN()
		    .setPT_IL_POL_COVER_GROUP_1_BEAN(
			    PT_IL_POL_COVER_GROUP_1_BEAN);
	}
    }
    
    public void  post_update(
	    PT_IL_POLICY  pt_il_policy_bean,
	    PT_IL_POL_ASSURED_DTLS_1 pt_il_pol_assured_dtls_1_bean,
	    PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean,
	    PT_IL_POL_COVER_GROUP_1 pt_il_pol_cover_group_1_bean) throws Exception {
	String M_THRESHOLD_MESSAGE = null;
	
	try {
	    
	    if(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(),0) == 0 &&
		    !"Q".equalsIgnoreCase(CommonUtils.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PARA_13"),"P"))){	
	       new P9ILPK_POLICY().P_INS_ADDL_COVER (pt_il_policy_bean.getPOL_SYS_ID(),
	                                       pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(),
	                                       pt_il_pol_assured_dtls_1_bean.getPOAD_SYS_ID(),
	                                       pt_il_pol_appl_prod_1_bean.getPAPP_SYS_ID(), 
	                                       pt_il_pol_cover_group_1_bean.getPCG_CODE(),
	                                       pt_il_pol_cover_group_1_bean.getPCG_SYS_ID());    													
	      
	   /* EXCEPTION
	       WHEN OTHERS THEN
	       		L_DISPLAY_ERROR_MESSAGE;
	       		RAISE FORM_TRIGGER_FAILURE;*/
		}
	    
	    	 
	}   catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}  
    }
    
    
    
    public void preInsert(
		PT_IL_POL_COVER_GROUP_1  pt_il_pol_cover_group_1_bean,PT_IL_POL_APPL_PROD_1 productBean) throws Exception {
	String CURSOR_C1  = "SELECT PIL_PCG_SYS_ID.NEXTVAL FROM DUAL";
	ResultSet rs1 = null;
	CRUDHandler handler = new CRUDHandler();
	Connection connection=null;
	try {
		connection = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(CURSOR_C1, connection);
			while (rs1.next()) {
				 pt_il_pol_cover_group_1_bean.setPCG_SYS_ID( rs1.getLong(1));
			}
				// Setting default values
				pt_il_pol_cover_group_1_bean.setPCG_POL_SYS_ID(productBean.getPAPP_POL_SYS_ID());
				pt_il_pol_cover_group_1_bean.setPCG_POAD_SYS_ID(productBean.getPAPP_POAD_SYS_ID());
				pt_il_pol_cover_group_1_bean.setPCG_PAPP_SYS_ID(productBean.getPAPP_SYS_ID());
				pt_il_pol_cover_group_1_bean.setPCG_CR_DT(new CommonUtils().getCurrentDate());
				pt_il_pol_cover_group_1_bean.setPCG_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				pt_il_pol_cover_group_1_bean.setPCG_DEL_FLAG("N");
	}   catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		CommonUtils.closeCursor(rs1);
	}
    }

    public void preUpdate(
		PT_IL_POL_COVER_GROUP_1 pt_il_pol_cover_group_1_bean) throws Exception {

	try {
		pt_il_pol_cover_group_1_bean.setPCG_UPD_DT(new CommonUtils().getCurrentDate());
		pt_il_pol_cover_group_1_bean.setPCG_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	} catch ( Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
    }
 
    public void postQuery(
		PT_IL_POL_COVER_GROUP_1 pt_il_pol_cover_group_1_bean) throws Exception {
	 
	String CURSOR_C1 = "SELECT CGH_DESC FROM PM_IL_CVR_GROUP_HDR WHERE CGH_GROUP_CODE=? ";

	Connection connection = null;
	ResultSet rs1 = null;
	CRUDHandler handler = new CRUDHandler();
	try {
		connection = CommonUtils.getConnection();
		rs1 = handler.executeSelectStatement(CURSOR_C1, connection, 
				new Object[]{ pt_il_pol_cover_group_1_bean.getPCG_CODE() });
			while (rs1.next()) {
				 pt_il_pol_cover_group_1_bean.setUI_M_PCD_CODE_DESC(rs1.getString(1));
			}
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}   finally {
		CommonUtils.closeCursor(rs1);
	}
    }


    public void onPopulateDetail(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	throws Exception {
	PT_IL_POL_COVER_GROUP_1 PT_IL_POL_COVER_GROUP_1 = compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN();
	try {
		if (( PT_IL_POL_COVER_GROUP_1.getPCG_SYS_ID()   != null) || 
			(PT_IL_POL_COVER_GROUP_1.getPCG_POL_SYS_ID()  != null) ||
		    (PT_IL_POL_COVER_GROUP_1.getPCG_POAD_SYS_ID()  != null)||
		    (PT_IL_POL_COVER_GROUP_1.getPCG_PAPP_SYS_ID()  != null) ){
		    PT_IL_POL_ADDL_COVER_1_DELEGATE delegate = new PT_IL_POL_ADDL_COVER_1_DELEGATE();
			delegate.executeSelectStatement( compositeAction);
		}
	}
	catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} 
    }

    
    public void  onCheckDeleteMaster(
	    PT_IL_POL_COVER_GROUP_1 pt_il_pol_cover_group_1_bean) throws Exception {

	CRUDHandler handler = new CRUDHandler();
	Connection connection = null;

	String Dummy_Define = null;
	ResultSet rs1 = null;
	String CURSOR_PT_IL_POL_ADDL_COVER ="  SELECT 1 FROM PT_IL_POL_ADDL_COVER P" +
			"  WHERE P.POAC_POL_SYS_ID = ? " +
			" AND P.POAC_PCG_SYS_ID = ? " +
			" AND P.POAC_POAD_SYS_ID = ? " +
			" AND P.POAC_PAPP_SYS_ID = ? ";
	try {
	    connection = CommonUtils.getConnection();
	    rs1 = handler.executeSelectStatement(CURSOR_PT_IL_POL_ADDL_COVER , connection,
		    	new Object[]{ pt_il_pol_cover_group_1_bean.getPCG_POL_SYS_ID(),
		    pt_il_pol_cover_group_1_bean.getPCG_SYS_ID() ,
		    pt_il_pol_cover_group_1_bean.getPCG_POAD_SYS_ID(), 
		    pt_il_pol_cover_group_1_bean.getPCG_PAPP_SYS_ID()});
	    if (rs1.next()) {
		Dummy_Define = rs1.getString(1);
		throw new  Exception( "Cannot delete master record when matching detail records exist");
	    }
	    // resultSet_c1.close();

	} catch ( Exception e) {
	    e.printStackTrace();
	    throw new  Exception( e.getMessage());
	} finally {
	    CommonUtils.closeCursor(rs1);
	}
    }
    
    public void  post_insert(
		PT_IL_POL_COVER_GROUP_1 pt_il_pol_cover_group_1_bean,
		PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean) throws Exception {
	String M_THRESHOLD_MESSAGE = null;
	String qryThresholdMsg = " SELECT P9ILPK_POLICY.F_GET_THR_LIMIT_MSG FROM DUAL";
	CRUDHandler handler = new CRUDHandler();
	Connection connection = null;
	ResultSet rs1 = null;
	try {
	    connection = CommonUtils.getConnection();
	   new  P9ILPK_POLICY().P_INS_ADDL_COVER(
		    pt_il_pol_cover_group_1_bean.getPCG_POL_SYS_ID(),
		    pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(),
			 pt_il_pol_cover_group_1_bean.getPCG_POAD_SYS_ID(),
			 pt_il_pol_cover_group_1_bean.getPCG_PAPP_SYS_ID(),
			 pt_il_pol_cover_group_1_bean.getPCG_CODE(),
			 pt_il_pol_cover_group_1_bean.getPCG_SYS_ID());
	   
	   rs1 = handler.executeSelectStatement( qryThresholdMsg, connection);
	   while(rs1.next()){
	       M_THRESHOLD_MESSAGE =  rs1.getString(1);
	   }
            if( M_THRESHOLD_MESSAGE !=null) {
        	throw new Exception( M_THRESHOLD_MESSAGE);
            }
	}   catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}  
    }
    
 
    public void  whenNewRecordInstance(  PT_IL_POL_COVER_GROUP_1 pt_il_pol_cover_group_1_bean ,
	    PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean) throws Exception {
    	try {
    	    pt_il_pol_cover_group_1_bean.setUI_M_PROD_CODE(pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE());
           
    	}   catch (Exception e) {
    	    e.printStackTrace();
    	    throw new Exception(e.getMessage());
    	} 
    }
    public void  whenNewBlockInstance( PILT002_APAC_COMPOSITE_ACTION  compositeAction  ) throws Exception {
	try {
	    if(compositeAction.getPT_IL_POL_COVER_GROUP_1_ACTION_BEAN().getPT_IL_POL_COVER_GROUP_1_BEAN().getROWID()!=null){
		executeQuery(compositeAction);
	    }
	    
	}   catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} 
    }
    
    public void  PCG_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_COVER_GROUP_1 pt_il_pol_cover_1_group, String componentValue) throws Exception {
	Connection conn = null;
	ResultSet rs1 = null,rschk_dup=null;
	Object[] values = null;
	CRUDHandler handler = new CRUDHandler();

	String CURSOR_C1 = "SELECT CGH_GROUP_CODE,CGH_DESC "
			+ "FROM   PM_IL_CVR_GROUP_HDR "
			+ "WHERE  CGH_GROUP_CODE  =(SELECT DISTINCT PACG_CVR_GROUP_CODE "
			+ "FROM   PM_IL_PROD_APPL_CVR_GRP "
			+ "WHERE  PACG_CVR_GROUP_CODE  = ? )";

	String chk_DUPLICATE = " select PCOPK_GENERAL.CHK_DUPLICATE(?,?,?,?,?,?,?,?,?,null,null) from dual ";
	
	String M_DUP_CHK = null;
	String M_CGH_GROUP_CODE = null;
	
	try {
		// --Rev1.4 Individual Medical Product
		conn = CommonUtils.getConnection();
		if( pt_il_pol_cover_1_group.getPCG_CODE() !=null){
        		rs1 = handler.executeSelectStatement(CURSOR_C1, conn, 
        			new Object[]{ pt_il_pol_cover_1_group.getPCG_CODE()});
        		while (rs1.next()) {
        			M_CGH_GROUP_CODE = rs1.getString(1);
        			pt_il_pol_cover_1_group
        					.setUI_M_PCD_CODE_DESC(rs1.getString(2));
        		}
        
        		if (M_CGH_GROUP_CODE == null) {
        			pt_il_pol_cover_1_group.setUI_M_PCD_CODE_DESC(null);
        			throw new Exception(Messages.getString(
        					PELConstants.pelErrorMessagePath, "92000"));
        		}
        	rschk_dup = handler.executeSelectStatement(chk_DUPLICATE, conn,
	  		   		
        		new Object[]{"PT_IL_POL_COVER_1_GROUP",
                                                    "PCG_CODE",
                                                    pt_il_pol_cover_1_group.getPCG_CODE(),
                                                    "PCG_POL_SYS_ID",
                                                    pt_il_pol_cover_1_group.getPCG_POL_SYS_ID(),
                                                    "PCG_POAD_SYS_ID",
                                                    pt_il_pol_cover_1_group.getPCG_POAD_SYS_ID(),
                                                    "PCG_PAPP_SYS_ID",      
                                                    pt_il_pol_cover_1_group.getPCG_PAPP_SYS_ID()});
	  	  
	  	  while(rschk_dup.next()){
	  	      M_DUP_CHK = rschk_dup.getString(1);
	  	  }
		  	
	  	if(componentValue !=null && pt_il_pol_cover_1_group.getPCG_CODE()!=null){
		  	  
		      if(!(componentValue.equalsIgnoreCase( pt_il_pol_cover_1_group.getPCG_CODE()))){  
    		      if(CommonUtils.nvl(M_DUP_CHK ,"E").equals("T")){
    			throw new Exception(Messages.getString(
				PELConstants.pelErrorMessagePath, "92002"));
    		      }
		      }
	  	  }	 
        		 
		}
	}   catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		CommonUtils.closeCursor(rs1);
	}
    }
    
    public void  PCG_RATE_WHEN_VALIDATE_ITEM(  Double curValue) throws Exception {
	 
	
	if ( curValue < 0) {
		throw new Exception(Messages.getString(
			PELConstants.pelErrorMessagePath, "80001"));
	}
    }
    public void  PCG_RATE_PER_WHEN_VALIDATE_ITEM( Double curValue) throws Exception {
	
	if (  curValue	 < 0) {
	    throw new Exception(Messages.getString(
		    PELConstants.pelErrorMessagePath, "80001"));
	}
    }
    public void keyDelRec(PT_IL_POL_COVER_GROUP_1_ACTION coverGroupAction,PT_IL_POLICY policyBean,PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String  CURSOR_C1 = "SELECT  ASD_CHAR_VALUE FROM    PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID = ? AND  ASD_CODE = 'DEL_CVRGP_YN'";
		String CURSOR_C2 ="SELECT PACG_MANDATORY_YN FROM   PM_IL_PROD_APPL_CVR_GRP WHERE  PACG_PROD_CODE  = ? AND  PACG_CVR_GROUP_CODE = ? ";
		String M_APPL_CVR_GRP_YN = null;
		String M_PACG_MANDATORY_YN = null;
		ResultSet resultSet = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
	
		resultSet = handler.executeSelectStatement(CURSOR_C1,connection,new Object[]{CommonUtils.getControlBean().getUSER_ID()});
		if (resultSet.next()) {
			M_APPL_CVR_GRP_YN = resultSet.getString(1);
		}
		resultSet1 = handler.executeSelectStatement(CURSOR_C2, connection,new Object[]{});
		if (resultSet1.next()) {
			M_PACG_MANDATORY_YN = resultSet1.getString(1);
		}
		if (coverGroupAction.isDELETE_ALLOWED() == true) {
			if ("Y".equals(CommonUtils.nvl(M_APPL_CVR_GRP_YN,"N"))) {
				if ("Y".equals(CommonUtils.nvl(M_PACG_MANDATORY_YN,"N"))) {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "92097"));
				}else if ("N".equals(CommonUtils.nvl(M_PACG_MANDATORY_YN,"N"))) {
					coverGroupAction.setDELETE_ALLOWED(true);
				}
			}else {
				coverGroupAction.setDELETE_ALLOWED(true);
			}
		}
		if (!"000".equals(policyBean.getPOL_END_TYPE())) {
			//P_SET_DEL_RECORD_PROPERTY("PT_IL_POL_COVER_GROUP.PCG_DEL_FLAG","PT_IL_POL_COVER_GROUP",policyBean.getPOL_END_NO_IDX(),"D");

		}else {
			new PKG_PILT002_APAC().P_DEL_COVER_GROUP(coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_POL_SYS_ID(),
					coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_PAPP_SYS_ID(), 
					coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_SYS_ID(), 
					coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_CODE(),"1",
					compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_POAC_SYS_ID(),
					compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_SYS_ID());
		}
		
		if (!"000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),"000"))) {
			if ("Y".equals(CommonUtils.nvl(coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_DEL_FLAG(), "N"))) {
				coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().setPCG_FC_PREM(0.00);
				coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().setPCG_LC_PREM(0.00);
			}else if ("Y".equals(CommonUtils.nvl(coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_DEL_FLAG(), "N")) 
					&&  policyBean.getPOL_END_TYPE() != null) {
				
			}
			if ("Y".equals(CommonUtils.nvl(coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_DEL_FLAG(), "N"))) {
				new PKG_PILT002_APAC().P_DEL_COVER_GROUP(coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_POL_SYS_ID(),
						coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_PAPP_SYS_ID(), 
						coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_SYS_ID(), 
						coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_CODE(),"3",
						compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_POAC_SYS_ID(),
						compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_SYS_ID());
			}else{
				new PKG_PILT002_APAC().P_DEL_COVER_GROUP(coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_POL_SYS_ID(),
						coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_PAPP_SYS_ID(), 
						coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_SYS_ID(), 
						coverGroupAction.getPT_IL_POL_COVER_GROUP_1_BEAN().getPCG_CODE(),"2",
						compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_POAC_SYS_ID(),
						compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_SYS_ID());
			}
		}
	   
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	finally{
		try {
			CommonUtils.closeCursor(resultSet);
			CommonUtils.closeCursor(resultSet1);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

		
}

 
}
