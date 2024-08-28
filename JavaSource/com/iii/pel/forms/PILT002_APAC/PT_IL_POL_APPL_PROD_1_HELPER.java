package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PCOPK_GENERAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_POL_APPL_PROD_1_HELPER {

    public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	    throws Exception {
	new PT_IL_POL_APPL_PROD_1_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_IL_POL_APPL_PROD_1> dataList = compositeAction
		.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN()
		.getDataList_PT_IL_POL_APPL_PROD_1();
	if (dataList != null && dataList.size() > 0) {
	    PT_IL_POL_APPL_PROD_1 PT_IL_POL_APPL_PROD_1_BEAN = dataList.get(0);
	    PT_IL_POL_APPL_PROD_1_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN()
		    .setPT_IL_POL_APPL_PROD_1_BEAN(PT_IL_POL_APPL_PROD_1_BEAN);
	}
    }
    
    public void postInsert(PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean )
            throws Exception {
        try {
        
            new P9ILPK_POLICY().P_DFLT_COVER_GROUP(
        	    pt_il_pol_appl_prod_1_bean.getPAPP_POL_SYS_ID() ,
        	    pt_il_pol_appl_prod_1_bean.getPAPP_POAD_SYS_ID() ,
        	    pt_il_pol_appl_prod_1_bean.getPAPP_SYS_ID() ,
        	    pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE());
        
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
    
    public void  postUpdate(PT_IL_POLICY pt_il_policy_bean) throws Exception {
	Connection connection = null;
	CommonUtils commonUtils = new CommonUtils();

	try {
	    if (!"A".equals(CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(), "N"))
		&& commonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0
		&& !"Q".equals(commonUtils.nvl(CommonUtils
			.getGlobalVariable("M_PARA_13"), "P"))) {


			new P9ILPK_POLICY().P_INS_DISC_LOAD(

			pt_il_policy_bean.getPOL_PROD_CODE(),
			pt_il_policy_bean.getPOL_SYS_ID(),
			 pt_il_policy_bean.getPOL_START_DT());
	    }   
	}catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
    }

    
    public void  whenNewBlockInstance(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {

	ResultSet rs2 = null;
	CRUDHandler handler = new CRUDHandler();
	Connection connection = null;
	PT_IL_POL_APPL_PROD_1_ACTION pt_il_pol_appl_prod_1_action = compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN();
	String CURSOR_C2 = " SELECT  ASD_CHAR_VALUE  FROM    PM_IL_APPR_SETUP_DET" +
			"  WHERE   ASD_USER_ID =?   AND  ASD_CODE    = 'DEL_APPL_PRD' ";

	    String M_APPL_PROD_YN = null;
	    String M_PGD_MAIN_PROD_YN = null;
	    String M_PGD_MANDATORY_YN = null;
	try {

	    connection = CommonUtils.getConnection();
	    rs2 = handler.executeSelectStatement(CURSOR_C2, connection,
		    new Object[]{CommonUtils.getControlBean().getM_USER_ID()});
	    while (rs2.next()) {
		M_APPL_PROD_YN = rs2.getString(1);
	    }
	    if ("Y".equalsIgnoreCase(CommonUtils.nvl(M_APPL_PROD_YN, "N"))) {
		pt_il_pol_appl_prod_1_action.setDELETE_ALLOWED(true);
	    } else {
		pt_il_pol_appl_prod_1_action.setDELETE_ALLOWED(false);
	    }
	    if(pt_il_pol_appl_prod_1_action.getPT_IL_POL_APPL_PROD_1_BEAN().getROWID() !=null)
	    {
		executeQuery(compositeAction);
	    }
	    
	}   catch ( Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} finally {
	    CommonUtils.closeCursor(rs2);
	}
    }
    

    public void  postQuery(PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean,
	    PT_IL_POLICY pt_il_policy_bean) throws Exception {
  

	try {
	    ArrayList<String> pvalList = new PKG_PILT002_APAC().P_VAL_PRODUCT(
		    pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(),
		    CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_ISSUE_DT()),
				"N"); 
             if(pvalList.get(0)!=null){
        	 pt_il_pol_appl_prod_1_bean.setUI_M_PAPP_PROD_DESC(pvalList.get(0));
             }
             ArrayList<OracleParameter> pvalOrcList = new LIFELIB().P_VAL_PLAN(
        	     pt_il_pol_appl_prod_1_bean.getPAPP_PLAN_CODE(),
        	     		pt_il_pol_appl_prod_1_bean.getUI_M_PAPP_PLAN_DESC(),
        	     			"N",  "N");
             pt_il_pol_appl_prod_1_bean.setUI_M_PAPP_PLAN_DESC((String)pvalOrcList.get(0).getValueObject());
	   
	}   catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}  
    }

    
    public void preInsert(PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean,PILT002_APAC_COMPOSITE_ACTION compositeAction)
                throws Exception {
            
            ResultSet rs1 = null;
            CRUDHandler handler = new CRUDHandler();
            Connection connection = null;
            String CURSOR_C1 ="    SELECT PIL_PAPP_SYS_ID.NEXTVAL   FROM DUAL ";
            try {
        	 
                connection = CommonUtils.getConnection();
                rs1 = handler.executeSelectStatement(CURSOR_C1, connection);
                while (rs1.next()) {
            		pt_il_pol_appl_prod_1_bean.setPAPP_SYS_ID(rs1.getLong(1));
                }
                pt_il_pol_appl_prod_1_bean.setPAPP_POL_SYS_ID(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_POL_SYS_ID());
                pt_il_pol_appl_prod_1_bean.setPAPP_POAD_SYS_ID(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN().getPOAD_SYS_ID());
                pt_il_pol_appl_prod_1_bean.setPAPP_PROD_CODE(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE());
                pt_il_pol_appl_prod_1_bean.setPAPP_CR_DT(new  CommonUtils().getCurrentDate());
                pt_il_pol_appl_prod_1_bean.setPAPP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
            }  catch (Exception e) {
                e.printStackTrace();
                throw new Exception(e.getMessage());
            } finally {
                CommonUtils.closeCursor(rs1);
            }
            
      }

    public void  preUpdate(PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean) {
	 
	try {
	    pt_il_pol_appl_prod_1_bean.setPAPP_UPD_DT(new CommonUtils().getCurrentDate());
	    pt_il_pol_appl_prod_1_bean.setPAPP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
    
    public void  whenNewRecordInstance(  PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean , 
	    PT_IL_POLICY pt_il_policy_bean) throws Exception {
    	try {
        	
    	ArrayList<String> pvalList = new PKG_PILT002_APAC().P_VAL_PRODUCT(
		    pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(),
		    CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_ISSUE_DT()),
				"N"); 
    	if(pvalList.get(0)!=null){	
    	    pt_il_pol_appl_prod_1_bean.setUI_M_PAPP_PROD_DESC(pvalList.get(0));
    	}
            
    	 ArrayList<OracleParameter> pvalOrcList = new LIFELIB().P_VAL_PLAN(
    		 pt_il_pol_appl_prod_1_bean.getPAPP_PLAN_CODE(),
    		 pt_il_pol_appl_prod_1_bean.getUI_M_PAPP_PLAN_DESC(),
    		 "N",  "N");
    	 	pt_il_pol_appl_prod_1_bean.setUI_M_PAPP_PLAN_DESC((String)pvalOrcList.get(0).getValueObject());
           
    	}   catch (Exception e) {
    	    e.printStackTrace();
    	    throw new Exception(e.getMessage());
    	} 
    }
    
    public void  whenCreateRecord(  PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean) {
	pt_il_pol_appl_prod_1_bean.setPAPP_STATUS("P");
    }
    
    public void on_Populate_Detail(PILT002_APAC_COMPOSITE_ACTION compositeAction)
	throws Exception {
	PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean = compositeAction.getPT_IL_POL_APPL_PROD_1_ACTION_BEAN().getPT_IL_POL_APPL_PROD_1_BEAN();
	try {
		if (( pt_il_pol_appl_prod_1_bean.getPAPP_POL_SYS_ID() != null) || 
			(pt_il_pol_appl_prod_1_bean.getPAPP_SYS_ID() != null) ||
		    (pt_il_pol_appl_prod_1_bean.getPAPP_POAD_SYS_ID() != null)) {
		    PT_IL_POL_COVER_GROUP_1_DELEGATE delegate = new PT_IL_POL_COVER_GROUP_1_DELEGATE();
			delegate.executeSelectStatement( compositeAction);
		}
	}
	catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	} 
    }
    public void  onCheckDeleteMaster(
	    PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean) throws Exception {

	CRUDHandler handler = new CRUDHandler();
	Connection connection = null;

	String Dummy_Define = null;
	ResultSet rs1 = null;
	String CURSOR_PT_IL_POL_COVER_GROUP ="  SELECT 1 FROM PT_IL_POL_COVER_GROUP P" +
			"  WHERE P.PCG_POL_SYS_ID = ? " +
			" AND P.PCG_PAPP_SYS_ID = ? " +
			" AND P.PCG_POAD_SYS_ID = ? ";


	try {
	    connection = CommonUtils.getConnection();
	    rs1 = handler.executeSelectStatement(CURSOR_PT_IL_POL_COVER_GROUP, connection,
		    	new Object[]{ pt_il_pol_appl_prod_1_bean.getPAPP_POL_SYS_ID() ,
		    pt_il_pol_appl_prod_1_bean.getPAPP_SYS_ID(), 
		    pt_il_pol_appl_prod_1_bean.getPAPP_POAD_SYS_ID()});
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


	public void  PAPP_PROD_CODE_WHEN_VALIDATE_ITEM(PT_IL_POL_APPL_PROD_1  pt_il_pol_appl_prod_1_bean,
			PT_IL_POLICY pt_il_policy_bean,PT_IL_POL_ASSURED_DTLS_1 pt_il_pol_assured_dtls_1_bean,
				String componentValue) throws Exception {

	CRUDHandler handler = new CRUDHandler();
	Connection connection = null;
	DBProcedures procedures = new DBProcedures();
	ResultSet rs3 =null,rs2=null,rs4=null,rschk_dup=null;
	
	String CURSOR_C1 = " SELECT COVER_CODE, COVER_DESC  FROM PM_IL_COVER" +
			"  WHERE  COVER_CODE  = (SELECT POL_PLAN_CODE   FROM PT_IL_POLICY" +
			"  WHERE POL_SYS_ID = ? )";  
	String CURSOR_C2 = " SELECT PGD_MAIN_PROD_YN  FROM   PM_IL_PROD_GROUP_DTL" +
			"   WHERE  PGD_GROUP_CODE = ? " +
			"   AND    PGD_PROD_CODE  = ? "; 
	String CURSOR_C3 = "   SELECT PROD_PLAN_CODE   FROM   PM_IL_PRODUCT" +
			"  WHERE  PROD_CODE =?  ";
	String CURSOR_C4  = "  SELECT (NVL(POL_LC_SUM_ASSURED,0) + NVL(POL_ORG_LC_SUM_ASSURED,0))" +
			"  FROM   PT_IL_POLICY 	  WHERE  POL_SYS_ID =?";

	String chk_DUPLICATE = " select PCOPK_GENERAL.CHK_DUPLICATE(?,?,?,?,?) from dual ";
	
	Double M_POL_LC_SUM_ASSURED = null;
	String M_DUP_CHK = null;
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
	PCOPK_GENERAL pcopk_general = new PCOPK_GENERAL();
	try {

		connection = CommonUtils.getConnection();

		rs3 = handler.executeSelectStatement(CURSOR_C3, connection,
				new Object[]{pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE()});

		while (rs3.next()) {
			pt_il_pol_appl_prod_1_bean.setPAPP_PLAN_CODE(rs3.getString(1));

		}

		rs2 = handler.executeSelectStatement(CURSOR_C2, connection,
			new Object[]{pt_il_policy_bean.getPOL_PROD_GROUP_CODE(),
				pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE()});
		
		
			if (rs2.next()) {
			    pt_il_pol_appl_prod_1_bean.setPAPP_MAIN_PROD_YN(rs2.getString(1));
			}
			else{
			    throw new  Exception(Messages.getString(
				    PELConstants.pelErrorMessagePath, "91074"));
			    
			}
		 
		//--REV1.0 TO HANDLE DUPLICATE CHECK
		  ArrayList<String> pvalList = pkg_pilt002_apac.P_VAL_PRODUCT(pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(),
			   	CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_ISSUE_DT()),
			   	"E");
		  if(pvalList.get(0) !=null){
		      pt_il_pol_appl_prod_1_bean.setUI_M_PAPP_PROD_DESC(pvalList.get(0));
		  }
		  

	  	  rschk_dup = handler.executeSelectStatement(chk_DUPLICATE, connection,
	  		   		new Object[]{"PT_IL_POL_APPL_PROD",
	                                        "PAPP_PROD_CODE",
	                                        pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(),
	                                        "PAPP_POAD_SYS_ID",
	                                        pt_il_pol_assured_dtls_1_bean.getPOAD_SYS_ID() });
	  	  
	  	  while(rschk_dup.next()){
	  	      M_DUP_CHK = rschk_dup.getString(1);
	  	  }
		  	
		      //--DISP_ALERT('M_DUP_CHK '||M_DUP_CHK);
		     
	  	 if(componentValue !=null && pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE() !=null){
		  	  
		      if(!(componentValue.equalsIgnoreCase(pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE()))){  
       		      if(CommonUtils.nvl(M_DUP_CHK ,"E").equals("T")){
       			  throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
       				  "71012"));
       		      }
		      }
	  	  }
	  	  
		      //--TO FETCH MAX AND MIN VALUES
		      //--Rev 2.2 For New Business the current Policy SA shoule be passed 
		      if(CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(),0) ==0d )  {
			  	ArrayList<OracleParameter> pvalOrclList = new P9ILPK_POLICY().P_CALC_PROD_SA(
		      		 pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(), 
		      		 pt_il_policy_bean.getPOL_LC_SUM_ASSURED(),
		      		 CommonUtils.getProcedureValue(pt_il_policy_bean.getPOL_SA_EXCH_RATE() ), 
		      		 pt_il_pol_appl_prod_1_bean.getPAPP_LC_SA(), 
		      		 pt_il_pol_appl_prod_1_bean.getPAPP_FC_SA() );
			  	
			  	 pt_il_pol_appl_prod_1_bean.setPAPP_LC_SA((Double)pvalOrclList.get(0).getValueObject()); 
		      		 pt_il_pol_appl_prod_1_bean.setPAPP_FC_SA((Double)pvalOrclList.get(1).getValueObject());
			  	
		      }else{ // --For endorsements the Sum of Actual and Org SA should be passed
		      	  
		      	  	rs4 = handler.executeSelectStatement( CURSOR_C4, connection,
		      	  		new Object[]{ pt_il_policy_bean.getPOL_SYS_ID() } );
			    while(rs4.next()){
		      	  	M_POL_LC_SUM_ASSURED = rs4.getDouble(1);
			    }
		      	 
			    ArrayList<OracleParameter> pvalOrclList = new P9ILPK_POLICY().P_CALC_PROD_SA(
		                       pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE(),
		                        M_POL_LC_SUM_ASSURED,
		                       pt_il_policy_bean.getPOL_SA_EXCH_RATE(),
		                       pt_il_pol_appl_prod_1_bean.getPAPP_LC_SA(),
		                       pt_il_pol_appl_prod_1_bean.getPAPP_FC_SA());
			    
			    pt_il_pol_appl_prod_1_bean.setPAPP_LC_SA((Double)pvalOrclList.get(0).getValueObject()); 
			    pt_il_pol_appl_prod_1_bean.setPAPP_FC_SA((Double)pvalOrclList.get(1).getValueObject());
			  	
			}        
		     
 
    		if (pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE() == null
    				|| pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE().trim().isEmpty()) {
    			pt_il_pol_appl_prod_1_bean.setPAPP_PLAN_CODE(null);
    			pt_il_pol_appl_prod_1_bean.setUI_M_PAPP_PLAN_DESC(null);
    		}
    
    	}   catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
    	} finally {
    		CommonUtils.closeCursor(rs2);
    		CommonUtils.closeCursor(rs3);
    
    	}	
     }
    
    public void PAPP_PLAN_CODE_WHEN_VALIDATE_ITEM(
    		PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean) throws Exception {
     
    	try {
    	    	ArrayList<OracleParameter> pvalOrcList = new LIFELIB().P_VAL_PLAN(
    	    		pt_il_pol_appl_prod_1_bean.getPAPP_PLAN_CODE(),
    	    		pt_il_pol_appl_prod_1_bean.getUI_M_PAPP_PLAN_DESC(),
    	                  "N", "N");
    	    	 
    	    	pt_il_pol_appl_prod_1_bean.setUI_M_PAPP_PLAN_DESC((String)pvalOrcList.get(0).getValueObject());
    
    	}  catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
    	}  
    }

    public void  PAPP_FC_SA_WHEN_VALIDATE_ITEM(  PT_IL_POL_APPL_PROD_1 pt_il_pol_appl_prod_1_bean,
    		PT_IL_POLICY pt_il_policy_bean) throws Exception {
    
    	CRUDHandler handler = new CRUDHandler();
    	Connection connection = null;
    
    	String  CURSOR_C1 ="  SELECT PROD_MIN_SA, PROD_MAX_SA  FROM   PM_IL_PRODUCT" +
    			"   WHERE  PROD_CODE = ? ";
    	
    	ResultSet rs1 = null;
    	
    	double M_PROD_MIN_SA = 0;
    	double M_PROD_MAX_SA = 0;
    
    	try {
    	    connection = CommonUtils.getConnection();
    	    rs1 = handler.executeSelectStatement(CURSOR_C1, connection,
    		    new Object[]{ pt_il_pol_appl_prod_1_bean.getPAPP_PROD_CODE()});
    
    	    while (rs1.next()) {
    		M_PROD_MIN_SA = rs1.getDouble(1);
    		M_PROD_MAX_SA = rs1.getDouble(2);
    	    }
    	    if( ( pt_il_pol_appl_prod_1_bean.getPAPP_FC_SA() > M_PROD_MAX_SA ||
    		      pt_il_pol_appl_prod_1_bean.getPAPP_FC_SA() < M_PROD_MIN_SA) &&
    		      !"Y".equalsIgnoreCase(pt_il_pol_appl_prod_1_bean.getPPAP_DEL_FLAG()) ){ //--Rev 2.0 During deltion endorsement this validation is not required
    		throw new Exception(Messages.getString( PELConstants.pelErrorMessagePath,
    			"92022"));
    	    }        	    
    	    pt_il_pol_appl_prod_1_bean.setPAPP_LC_SA(CommonUtils.ROUND(
    		    CommonUtils.nvl(pt_il_policy_bean.getPOL_SA_EXCH_RATE(),1d) *
    		    CommonUtils.nvl(pt_il_pol_appl_prod_1_bean.getPAPP_FC_SA(),0d),2));
    	  
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    throw new  Exception( e.getMessage());
    	} finally {
    	    CommonUtils.closeCursor(rs1);
    	}
        
    }

    
    public void keyDelRec(PT_IL_POL_APPL_PROD_1_ACTION prduct1DetailAction,PT_IL_POLICY policyBean,PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
    	
    		
    	String 	CURSOR_C1 = "SELECT PGD_MAIN_PROD_YN, PGD_MANDATORY_YN FROM   PM_IL_PROD_GROUP_DTL" +
    	"WHERE  PGD_GROUP_CODE = ? AND    PGD_PROD_CODE  = ? ";
    	String CURSOR_C2 = "SELECT  ASD_CHAR_VALUE FROM    PM_IL_APPR_SETUP_DET" +
    	"WHERE   ASD_USER_ID = ? AND  ASD_CODE    = 'DEL_APPL_PRD' ";
    	
    	PT_IL_POL_APPL_PROD_1 prduct1DetailBean = prduct1DetailAction.getPT_IL_POL_APPL_PROD_1_BEAN();
    	String M_APPL_PROD_YN = null;
    	String M_PGD_MAIN_PROD_YN = null;
    	String M_PGD_MANDATORY_YN = null;
    	ResultSet resultSet = null;
    	ResultSet resultSet1 = null;
    	CRUDHandler handler = new CRUDHandler();
    	Connection connection;
		try {
			connection = CommonUtils.getConnection();
	
    	PKG_PILT002_APAC localProcedure = new PKG_PILT002_APAC();
    	resultSet = handler.executeSelectStatement(CURSOR_C2, connection, new Object[]{CommonUtils.getControlBean().getUSER_ID()});
    	if (resultSet.next()) {
			M_APPL_PROD_YN = resultSet.getString(1);
		}
    	resultSet1 = handler.executeSelectStatement(CURSOR_C1, connection,
    			new Object[]{policyBean.getPOL_PROD_GROUP_CODE(),prduct1DetailBean.getPAPP_PROD_CODE()});
    	if (resultSet1.next()) {
			M_PGD_MAIN_PROD_YN = resultSet1.getString(1);
			M_PGD_MANDATORY_YN = resultSet1.getString(2);
		}
    	if ("Y".equals(CommonUtils.nvl(M_APPL_PROD_YN, "N"))) {
			if ("Y".equals(CommonUtils.nvl(M_PGD_MAIN_PROD_YN,"N"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206", new Object[]{"Main Product can't be deleted"}));
			}else if ("Y".equals(CommonUtils.nvl(M_PGD_MANDATORY_YN,"N"))) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"3206", new Object[]{"Mandatory Product can't be deleted"}));
			}else {
				prduct1DetailAction.setDELETE_ALLOWED(true);
			}
		}
    	
    if (!"1".equals(policyBean.getPOL_DS_TYPE())) {
		if (!"000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(),"000"))) {
			 //P_SET_DEL_RECORD_PROPERTY("PT_IL_POL_APPL_PROD_1.PPAP_DEL_FLAG","PT_IL_POL_APPL_PROD_1",?,"D");
		}else {
			localProcedure.P_DEL_APPL_PROD(prduct1DetailBean.getPAPP_POL_SYS_ID(),
								prduct1DetailBean.getPAPP_POAD_SYS_ID(),prduct1DetailBean.getPAPP_SYS_ID(),
								prduct1DetailBean.getPAPP_PROD_CODE(),"1",compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_PCG_SYS_ID(),
	            				compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_POAC_SYS_ID(),
	            				compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_SYS_ID());
		}
		if (!"000".equals(CommonUtils.nvl(policyBean.getPOL_END_TYPE(), "000"))) {
			if ("Y".equals(CommonUtils.nvl(prduct1DetailBean.getPPAP_DEL_FLAG(),"N")) 
					&& policyBean.getPOL_END_TYPE() != null ) {
					prduct1DetailBean.setPAPP_FC_SA(0.00);
					prduct1DetailBean.setPAPP_LC_SA(0.00);
					prduct1DetailBean.setPAPP_FC_BASIC_PREM(0.00);
					prduct1DetailBean.setPAPP_LC_BASIC_PREM(0.00);
					prduct1DetailBean.setPAPP_FC_ADDL_PREM(0.00);	
					prduct1DetailBean.setPAPP_LC_ADDL_PREM(0.00);
			}
			if ("Y".equals(CommonUtils.nvl(prduct1DetailBean.getPPAP_DEL_FLAG(),"N")) 
					&& policyBean.getPOL_END_TYPE() != null ) {
					prduct1DetailBean.setPAPP_FC_SA(prduct1DetailBean.getPAPP_FC_SA() * -1);
					prduct1DetailBean.setPAPP_LC_SA(prduct1DetailBean.getPAPP_LC_SA() * -1);
					prduct1DetailBean.setPAPP_FC_BASIC_PREM(prduct1DetailBean.getPAPP_FC_BASIC_PREM() * -1);
					prduct1DetailBean.setPAPP_LC_BASIC_PREM(prduct1DetailBean.getPAPP_LC_BASIC_PREM() * -1);
					prduct1DetailBean.setPAPP_FC_ADDL_PREM(prduct1DetailBean.getPAPP_FC_ADDL_PREM() * -1);	
					prduct1DetailBean.setPAPP_LC_ADDL_PREM(prduct1DetailBean.getPAPP_LC_ADDL_PREM() * -1);
					
					localProcedure.P_DEL_APPL_PROD(prduct1DetailBean.getPAPP_POL_SYS_ID(),
							prduct1DetailBean.getPAPP_POAD_SYS_ID(),prduct1DetailBean.getPAPP_SYS_ID(),
							prduct1DetailBean.getPAPP_PROD_CODE(),"2",compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_PCG_SYS_ID(),
            				compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_POAC_SYS_ID(),
            				compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_SYS_ID());
			}else {
				localProcedure.P_DEL_APPL_PROD(prduct1DetailBean.getPAPP_POL_SYS_ID(),
						prduct1DetailBean.getPAPP_POAD_SYS_ID(),prduct1DetailBean.getPAPP_SYS_ID(),
						prduct1DetailBean.getPAPP_PROD_CODE(),"3",compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_PCG_SYS_ID(),
        				compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_POAC_SYS_ID(),
        				compositeAction.getPT_IL_POL_BENEFIT_ACTION_BEAN().getPT_IL_POL_BENEFIT_BEAN().getPB_SYS_ID());
			}
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
    }

   
}
