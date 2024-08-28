package com.iii.pel.forms.PILP001_APAC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_LOCAL_PROCEDURES;
import com.iii.pel.forms.PM020_A_APAC.P9GIPK_GENERAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_HELPER {

    CRUDHandler handler = null;
    Map session = null;

    public void ui_m_prop_no_when_validate_item( DUMMY_ACTION DUMMY_ACTION, DUMMY DUMMY_BEAN)
	    throws SQLException, Exception {

	int M_PS_VALUE = 0;
	String CURSOR_C1 = "  SELECT PS_VALUE  FROM PP_SYSTEM   WHERE PS_TYPE = 'IL_DEF_DT'";
	ResultSet rs_C1 = null;
	Connection connection = null;
	CommonUtils commonUtils = new CommonUtils();
	try {
	    connection = CommonUtils.getConnection();
	    handler = new CRUDHandler();
	    rs_C1 = handler.executeSelectStatement(CURSOR_C1, connection);

	    while (rs_C1.next()) {

		M_PS_VALUE = rs_C1.getInt(1);
	    }

	    L_VALIDATE_PROP_NO(DUMMY_ACTION,DUMMY_BEAN);

	    Date apprvDate = (Date) commonUtils
		    .getGlobalObject("GLOBAL.M_POL_START_DT");
	    if (M_PS_VALUE == 1) {
		DUMMY_BEAN.setUI_M_APPRV_DATE(apprvDate);

	    } else if (M_PS_VALUE == 2) {
		DUMMY_BEAN.setUI_M_APPRV_DATE(commonUtils.getCurrentDate());
	    }

	} catch (Exception ee) {
	    ee.printStackTrace();
	}
    }

    public void L_VALIDATE_PROP_NO(DUMMY_ACTION DUMMY_ACTION, DUMMY DUMMY_BEAN) {
	String CURSOR_C1 = "  SELECT POL_SYS_ID, NVL(POL_APPRV_STATUS,'N'), POL_ISSUE_DT, POL_PLAN_CODE"
		+ "    FROM   PT_IL_POLICY  WHERE POL_SYS_ID =?   AND    POL_DS_TYPE = '1' ";

	String M_SYS_ID = null;
	String M_STATUS = null;
	String M_PLAN_CODE = null;

	ResultSet rs_C1 = null;
	Connection connection = null;
	try {
	    connection = CommonUtils.getConnection();
	    handler = new CRUDHandler();
	    rs_C1 = handler.executeSelectStatement(CURSOR_C1, connection,
		    new Object[] { DUMMY_BEAN.getUI_M_POL_SYS_ID() });
	    while (rs_C1.next()) {
		M_SYS_ID = rs_C1.getString(1);
		M_STATUS = rs_C1.getString(2);
		DUMMY_BEAN.setUI_M_APPRV_DATE(rs_C1.getDate(3));
		M_PLAN_CODE = rs_C1.getString(4);

	    }
	    if (rs_C1 == null) {
		DUMMY_ACTION.getCOMP_UI_M_BUT_CANCEL().setDisabled(false);
		throw new Exception(Messages.getString(
			PELConstants.pelErrorMessagePath, "71074"));
		// L_RESTORE_DEFAULT;

	    } else if (!"N".equals(M_STATUS)) {
		DUMMY_ACTION.getCOMP_UI_M_BUT_CANCEL().setDisabled(false);
		// L_RESTORE_DEFAULT;
	    }

	    CommonUtils.setGlobalVariable("GLOBAL.M_PLAN_CODE", M_PLAN_CODE);

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}

    }

    public void ui_m_apprv_date_when_validate_item(
	    DUMMY_ACTION DUMMY_ACTION, DUMMY DUMMY_BEAN) throws SQLException,
	    Exception {
	String sql_C1 = "SELECT    POL_DIVN_CODE,    POL_CLASS_CODE,  "
		+ "  POL_PLAN_CODE,    POL_PROD_CODE,  "
		+ "  POL_UW_YEAR FROM  PT_IL_POLICY  " + " WHERE  POL_NO  =? ";

	ResultSet rs_C1 = null;

	String M_POL_DIVN_CODE = null;
	String M_POL_CLASS_CODE = null;
	String M_POL_PLAN_CODE = null;
	Integer M_POL_UW_YEAR = 0;
	String M_PROD_CODE = null;
	Connection connection = null;
	try {
	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();
	    
	    /* Newly Added By Dhinesh on 28-03-2018 */
	    String IL_APRV_EFDT = CommonUtils.getPPSystemParameterValue("IL_APRV_EFDT").toString();
		System.out.println("IL_APRV_EFDT    : "+IL_APRV_EFDT);
		if("1".equalsIgnoreCase(IL_APRV_EFDT))
		{
	    	L_VALIDATE_APPRV_DATE(DUMMY_BEAN);	
	    }
		/*End*/

		if (DUMMY_BEAN.getUI_M_POL_DOCCODE() != null) {
		rs_C1 = handler.executeSelectStatement(sql_C1, connection,
			new Object[] { DUMMY_BEAN.getUI_M_POL_NO() });
		if (rs_C1.next()) {
		    M_POL_DIVN_CODE = rs_C1.getString(1);
		    M_POL_CLASS_CODE = rs_C1.getString(2);
		    M_POL_PLAN_CODE = rs_C1.getString(3);
		    M_PROD_CODE = rs_C1.getString(4);
		    M_POL_UW_YEAR = rs_C1.getInt(5);
		}
		ArrayList<OracleParameter> pvallist = new PKG_PILT002_APAC()
			.P_SET_DOC_NO_PROP("2", DUMMY_BEAN
				.getUI_M_POL_DOCCODE(), M_POL_DIVN_CODE,
				M_POL_CLASS_CODE, M_POL_PLAN_CODE, M_PROD_CODE,
				 M_POL_UW_YEAR ,
				"DUMMY.M_POLICY_NO", "DUMMY", "Y", null, null,
				null, DUMMY_BEAN.getROWID(), null);
		if ("Y".equals((String)pvallist.get(1).getValueObject())) {
		    DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setDisabled(false);
		    //DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setRequired(true);

		}

	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    CommonUtils.closeCursor(rs_C1);
	}
    }

    public void L_VALIDATE_APPRV_DATE(DUMMY DUMMY_BEAN) throws SQLException,
	    Exception {
   /* Commented by saritha on 09-Dec-2016 for POL_ISSUE_DT to change POL_START_DT RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
	/*String sql_C1 = "SELECT POL_ISSUE_DT FROM  PT_IL_POLICY  WHERE"
		+ "  POL_SYS_ID  = ?  AND POL_DS_TYPE  = '1' ";*/
    /*End*/	
    	
   /* Added by saritha on 09-Dec-2016 POL_ISSUE_DT to change POL_START_DT RM018T - DEV_IL_ZB Life_012b_Claims waiting period v1.0.doc*/
    	String sql_C1 = "SELECT POL_START_DT FROM  PT_IL_POLICY  WHERE"
    			+ "  POL_SYS_ID  = ?  AND POL_DS_TYPE  = '1' ";
    /*End*/
	ResultSet rs_C1 = null;
	Connection connection = null;
	Date M_APPRV_DT = null;
 
	try {
	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();
	    rs_C1 = handler.executeSelectStatement(sql_C1, connection,
		    new Object[] { DUMMY_BEAN.getUI_M_POL_SYS_ID() });
	    if (rs_C1.next()) {
		M_APPRV_DT = rs_C1.getDate(1);
	    }
	    
	    if (M_APPRV_DT!=null && DUMMY_BEAN.getUI_M_APPRV_DATE().before(M_APPRV_DT) 
		    || DUMMY_BEAN.getUI_M_APPRV_DATE().after(new CommonUtils().getCurrentDate())) {
		
		throw new Exception(Messages.getString(
			PELConstants.pelErrorMessagePath, "71055"));
		/*
		 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71055,:CTRL.M_LANG_CODE);
		 * L_RESTORE_DEFAULT.L_RESTORE_DEFAULT(); throw new
		 * FORM_TRIGGER_FAILURE();
		 */

	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    CommonUtils.closeCursor(rs_C1);
	}
    }

    public void pilp001_apac_when_new_form_instance(DUMMY_ACTION DUMMY_ACTION,
	    DUMMY DUMMY_BEAN) throws Exception {
	String M_PS_VALUE = null;
	String sql_C1 = "SELECT PS_VALUE FROM  PP_SYSTEM  WHERE  PS_TYPE  = 'IL_DEF_DT' ";
	ResultSet rs_C1 = null;
	Connection connection = null;
	try {
	    connection = CommonUtils.getConnection();
	    PreparedStatement stmt_C1 = connection.prepareStatement(sql_C1);
	    if (rs_C1 != null) {
		CommonUtils.closeCursor(rs_C1);
		// rs_C1.close();
	    }
	    rs_C1 = stmt_C1.executeQuery(sql_C1);
	    if (rs_C1.next()) {
		M_PS_VALUE = rs_C1.getString(1);
	    }
	    CommonUtils.closeCursor(rs_C1);
	    // rs_C1.close();
	    if ("PILT002_APAC".equals(CommonUtils
		    .getGlobalVariable("CALLING"))
		    || "PILT002B".equals(CommonUtils
			    .getGlobalVariable("CALLING_FORM"))) {

		DUMMY_BEAN.setUI_M_POL_NO(CommonUtils
			.getGlobalVariable("GLOBAL.M_POL_NO"));
		DUMMY_BEAN.setUI_M_PROP_NO(CommonUtils
			.getGlobalVariable("GLOBAL.M_POL_NO"));

		if (M_PS_VALUE.equals("1")) {  
		    DUMMY_BEAN
			    .setUI_M_APPRV_DATE((Date) CommonUtils.getGlobalObject("GLOBAL.M_POL_START_DT"));
		} else {
		    DUMMY_BEAN.setUI_M_APPRV_DATE(new CommonUtils()
			    .getCurrentDate());

		}
		DUMMY_BEAN.setUI_M_POL_SYS_ID( (Long) CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID"));
		if ("PILT002B".equals(CommonUtils
			.getGlobalVariable("CALLING_FORM"))) {
		    DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setDisabled(true); // ',ENABLED,PROPERTY_FALSE);
		} else {
		   /* DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setDisabled(false);*/// ().setDisabled( false);
		    // DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT',NAVIGABLE,PROPERTY_TRUE);
		    // DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT',UPDATE_ALLOWED,PROPERTY_TRUE);
		}

	    }

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    CommonUtils.closeCursor(rs_C1);
	}
    }

   /*Commentted by saritha on 16-05-2018 for KIC Need to default No in Convert Policy Yes/No*/
    
  /*public void pilp001_apac_dummy_when_create_record(DUMMY DUMMY_BEAN)
	    throws Exception {
	Connection connection = CommonUtils.getConnection();
	try {

	    DUMMY_BEAN.setUI_M_PROP_STATUS("A");
	    DUMMY_BEAN.setUI_M_PROP_CONVERT("N");
	    DUMMY_BEAN.setUI_M_DEPPREM_REFUND_YN("N");
	    DUMMY_BEAN.setUI_M_MED_FEE_RECOVER_YN("N");
	    DUMMY_BEAN.setM_FLAG("Y");

	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {

	}
    }*/
    
    /*Modified by saritha on 16-05-2018 for KIC Need to default No in Convert Policy Yes/No*/
    
    public void pilp001_apac_dummy_when_create_record(DUMMY DUMMY_BEAN)
    		throws Exception {
    	String LI_DFLT_VALUE = null;
    	
    	try {

    		DUMMY_BEAN.setUI_M_PROP_STATUS("A");
    		DUMMY_BEAN.setUI_M_PROP_CONVERT("N");
    		DUMMY_BEAN.setUI_M_DEPPREM_REFUND_YN("N");
    		DUMMY_BEAN.setUI_M_MED_FEE_RECOVER_YN("N");
    		DUMMY_BEAN.setM_FLAG("Y");
    		
    		LI_DFLT_VALUE = new P9GIPK_GENERAL().P_GET_DEFAULT_VALUE(
    				"PILP001_APAC", "DUMMY", "DUMMY.M_PROP_CONVERT", null);
    		if(LI_DFLT_VALUE != null){
    			DUMMY_BEAN.setUI_M_PROP_CONVERT(LI_DFLT_VALUE);
    		}
    		
    		

    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	} finally {

    	}
        }
    
    /*End*/
    

    public void pilp001_apac_dummy_when_new_record_instance(DUMMY_ACTION DUMMY_ACTION ,DUMMY DUMMY_BEAN)
	    throws SQLException, Exception {
	Connection connection = CommonUtils.getConnection();
	String sql_C1 = "SELECT DS_POL_CODE FROM  PM_IL_DOC_SETUP,  " +
			" PT_IL_POLICY  WHERE  POL_NO  = ? " +
			" AND POL_DS_CODE  = DS_CODE  AND DS_TYPE  = '1' ";
	ResultSet rs_C1 = null;
	try {
	    handler = new CRUDHandler();
	    
	    if ("C".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())) {
		DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setDisabled(false);
		DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setRequired(true);
		if ("N".equals(DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN() )) {
		    DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setDisabled(  true);
		    DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setRequired( false);
		} else if ("Y".equals(DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN() )) {
		    DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setDisabled( false);
		    DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setRequired(true);
		}
		DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_PC_CODE().setDisabled(false);
		DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setDisabled(false);
		DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setRequired(true);
		DUMMY_ACTION.getCOMP_UI_M_REASON_DESC().setDisabled(false);
		DUMMY_ACTION.getCOMP_UI_M_PS_REMARKS().setDisabled(false);
		DUMMY_ACTION.getCOMP_UI_M_BUT_PS_REMARKS().setDisabled(false);
		DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setDisabled(true);

		DUMMY_BEAN.setUI_M_PROP_CONVERT("N");
		DUMMY_BEAN.setUI_M_POL_DOCCODE(null);
		DUMMY_BEAN.setUI_M_DS_DESC(null);
		DUMMY_BEAN.setUI_M_POLICY_NO(null);
		
	    } else if ("A".equals(DUMMY_BEAN.getUI_M_PROP_STATUS() )) {
		 
		DUMMY_BEAN.setUI_M_PS_REASON_CODE(null);
		DUMMY_BEAN.setUI_M_PS_REMARKS(null);
		DUMMY_BEAN.setUI_M_REASON_DESC(null);
		
		/*Newly Added By Dhiensh on 31.3.2017*/
		DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setDisabled(true);
		DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setRequired(false);
		DUMMY_ACTION.getCOMP_UI_M_REASON_DESC().setDisabled(true);
		DUMMY_ACTION.getCOMP_UI_M_PS_REMARKS().setDisabled(true);
		/*End*/

	    }
	    if ("Y".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT() )) {

		rs_C1 = handler.executeSelectStatement(sql_C1,connection,
					new Object[]{ DUMMY_BEAN.getUI_M_PROP_NO() });
		
			if(rs_C1.next()){
				DUMMY_BEAN.setUI_M_POL_DOCCODE(rs_C1.getString(1)); 
			}
	    } else if ("N".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT() )) {
		DUMMY_BEAN.setUI_M_POL_DOCCODE(null);
		DUMMY_BEAN.setUI_M_DS_DESC(null);
		DUMMY_BEAN.setUI_M_POLICY_NO(null);
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {
	    CommonUtils.closeCursor(rs_C1);
	}
    }

    public void pilp001_apac_dummy_post_query(DUMMY DUMMY_BEAN)
	    throws SQLException, Exception {
	Connection connection = CommonUtils.getConnection();
	try {
	    L_DOC_DESC(DUMMY_BEAN);
	    ArrayList<OracleParameter> pvalList = new PKG_PILT002_APAC()
		    .P_VAL_CODES("IL_REASON", DUMMY_BEAN
			    .getUI_M_PS_REASON_CODE(), DUMMY_BEAN
			    .getUI_M_REASON_DESC(), "N", "N", null);
	    if (pvalList.get(0).getValue() != null) {
		DUMMY_BEAN.setUI_M_REASON_DESC(pvalList.get(0).getValue());
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw e;
	} finally {

	}
    }

    public void L_DOC_DESC(DUMMY DUMMY_BEAN) {
	ResultSet rs_C1 = null;
	Connection connection = null;
	try {
	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();
	    String CURSOR_C1 = "    SELECT    DS_DESC    FROM       PM_IL_DOC_SETUP    WHERE"
		    + "   DS_CODE = ? ";
	    rs_C1 = handler.executeSelectStatement(CURSOR_C1, connection,
		    new Object[] { DUMMY_BEAN.getUI_M_POL_DOCCODE() });
	    if (rs_C1.next()) {
		DUMMY_BEAN.setUI_M_DS_DESC(rs_C1.getString(1));
	    }

	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}

    }
    
    public void ui_m_re_uw_req_yn_when_list_changed(DUMMY_ACTION dummy_action,DUMMY DUMMY_BEAN) {
	// if(COMP_UI_M_RE_UW_REQ_YN.getSubmittedValue().equals("Y"))
	if ("Y".equals(DUMMY_BEAN.getUI_M_RE_UW_REQ_YN())) {
	    dummy_action.getCOMP_UI_M_RE_UW_REQ_REASON().setDisabled(false);
	} else {
	    dummy_action.getCOMP_UI_M_RE_UW_REQ_REASON().setDisabled(true);
	}
    }
    
    public  void ui_m_prop_status_when_list_changed(DUMMY_ACTION DUMMY_ACTION,DUMMY DUMMY_BEAN) {
	int M_DUMMY =0;
	
	String  CURSOR_C1 =" SELECT NVL(POL_LC_DEPOSIT_AMOUNT,0) FROM   PT_IL_POLICY" +
			"  WHERE  POL_NO = ? ";
	
	String updateQuery = "UPDATE PT_IL_POLICY SET POL_APPRV_STATUS = ? WHERE POL_NO = ? ";
	
	ResultSet rs_C1 = null;
	Connection connection = null;
	try {
	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();
	    
	       if("C".equals(DUMMY_BEAN.getUI_M_PROP_STATUS()) || 
		       "I".equals(DUMMY_BEAN.getUI_M_PROP_STATUS()) ||
			       "O".equals(DUMMY_BEAN.getUI_M_PROP_STATUS()) ||
				       "W".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())){
		       rs_C1 = handler.executeSelectStatement( CURSOR_C1, connection,
			       		new Object[]{DUMMY_BEAN.getUI_M_PROP_NO()});
	    	    
		       while(rs_C1.next()){
	    		 M_DUMMY = rs_C1.getInt(1);
		       }
	    		 
	     	  if( M_DUMMY > 0 )    {  
	     	   	 DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setDisabled( false);
	     	   	 DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setRequired( true);
	     	   	 DUMMY_BEAN.setUI_M_DEPPREM_REFUND_YN("Y");
	     	  }

	          DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_PC_CODE().setDisabled( false);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setDisabled( false);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setRequired( true);
	          /*
	           * commented by Dhinesh on 31.3.2017
	           * DUMMY_ACTION.getCOMP_UI_M_REASON_DESC().setDisabled( false);*/
	          /*modified by Dhinesh on 31.3.2017*/
	          DUMMY_ACTION.getCOMP_UI_M_REASON_DESC().setDisabled(true);
	          /*End*/
	          DUMMY_ACTION.getCOMP_UI_M_BUT_PS_REMARKS().setDisabled( false);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REMARKS().setDisabled( false);
	          DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_POL_DOCCODE().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_DOC_CODE().setDisabled( true);
	         // DUMMY_ACTION.getCOMP_UI_M_DS_DESC().setDisabled( true);
	          
	          
	          DUMMY_ACTION.getCOMP_UI_M_DS_DESC().setDisabled(true);
	          
	          DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_BUT_POLICY_NO().setDisabled( true);
	          DUMMY_BEAN.setUI_M_POL_DOCCODE(null);
	          DUMMY_BEAN.setUI_M_DS_DESC(null);
	          DUMMY_BEAN.setUI_M_POLICY_NO(null);
	          DUMMY_BEAN.setUI_M_PROP_CONVERT("N");
	        
	       }
	       else if("A".equals(DUMMY_BEAN.getUI_M_PROP_STATUS())){
	       	  DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setDisabled( true);
	       	  DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_PC_CODE().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_REASON_DESC().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REMARKS().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_BUT_PS_REMARKS().setDisabled( true);
	         
	          DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN ().setDisabled( true);// --ADDED BY AMAN  
	         
	          if(!"PILT002B".equals( CommonUtils.getGlobalVariable("CALLING_FORM")  )){
        	          /*DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setDisabled( false);
        	          DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setRequired( true);*/
	          }
	          
	          DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_DOC_CODE().setDisabled( false);
	          DUMMY_ACTION.getCOMP_UI_M_POL_DOCCODE().setDisabled( false);
	          //DUMMY_ACTION.getCOMP_UI_M_DS_DESC().setDisabled( false);
	         /*Newly added by Dhinesh on 31.3.2017*/
	          DUMMY_ACTION.getCOMP_UI_M_DS_DESC().setDisabled(false);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REMARKS().setDisabled(true);
	          /*End*/
	          
	          DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setDisabled( false);
	          DUMMY_ACTION.getCOMP_UI_M_BUT_POLICY_NO().setDisabled( false);
	          
	         /* DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setDisabled( false);*/

	          DUMMY_BEAN.setUI_M_PS_REASON_CODE(null);
	          DUMMY_BEAN.setUI_M_PS_REMARKS(null);
	          DUMMY_BEAN.setUI_M_REASON_DESC(null);
	        
	         DUMMY_BEAN.setUI_M_DEPPREM_REFUND_YN("N");  
	         DUMMY_BEAN.setUI_M_MED_FEE_RECOVER_YN("N");  
	       }
	       else if("P".equals( DUMMY_BEAN.getUI_M_PROP_STATUS())){
	       	  DUMMY_ACTION.getCOMP_UI_M_DEPPREM_REFUND_YN().setDisabled( true);
	       	  DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_PC_CODE().setDisabled( true);
	          /* COMMENTED BY DHINESH ON 31.3.2017
	       	   * 
	       	   * DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setDisabled( true);
	       	   */
	       	
	       	  /*Newly added by Dhinesh on 31.3.2017*/
	       	  DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setDisabled( false);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REASON_CODE().setRequired(true);
	          DUMMY_ACTION.getCOMP_UI_M_REASON_DESC().setDisabled(true);
	          /*End*/
	          DUMMY_ACTION.getCOMP_UI_M_REASON_DESC().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_PS_REMARKS().setDisabled( true);
	          DUMMY_ACTION.getCOMP_UI_M_BUT_PS_REMARKS().setDisabled( true);    
	          
	          DUMMY_ACTION.getCOMP_UI_M_PROP_CONVERT().setDisabled( true);
	          DUMMY_BEAN.setUI_M_DEPPREM_REFUND_YN("N"); 
	          DUMMY_BEAN.setUI_M_MED_FEE_RECOVER_YN("N"); 
	          
	       }
	      
	    if("Y".equals(CommonUtils.nvl(DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN(),"N"))){ 
	       DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setDisabled( false);
	       DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setRequired( true); 
	    }else{ 
	    	DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setDisabled( true);
	      DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setRequired(false);
	      DUMMY_BEAN.setUI_M_MED_FEE_RECOVER_YN( "N");
	    }	  
	  
	    /* 
	    * Commented By Dhinesh on 02.4.2017
	    * 
	    * if("I".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PROP_STATUS())){
	    	handler.executeUpdateStatement(updateQuery, connection,
	    			new Object[]{"I",DUMMY_BEAN.getUI_M_PROP_NO()}); 
	    	CommonUtils.getConnection().commit();
	    }
	    else if("W".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PROP_STATUS())){
	    	handler.executeUpdateStatement(updateQuery, connection,
	    			new Object[]{"W",DUMMY_BEAN.getUI_M_PROP_NO()}); 
	    	CommonUtils.getConnection().commit();
	    }
	    else if("O".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PROP_STATUS())){
	    	handler.executeUpdateStatement(updateQuery, connection,
	    			new Object[]{"O",DUMMY_BEAN.getUI_M_PROP_NO()}); 
	    	CommonUtils.getConnection().commit();
	    }*/
	    
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    

    public  void ui_m_prop_convert_when_list_changed(DUMMY_ACTION DUMMY_ACTION,DUMMY DUMMY_BEAN) {
	int M_DUMMY =0;
	
	String  CURSOR_C1 =" SELECT  DS_POL_CODE  FROM   PM_IL_DOC_SETUP,PT_IL_POLICY  WHERE" +
			"   POL_NO = ?  AND  POL_DS_CODE = DS_CODE  AND" +
			"      DS_TYPE = '1' ";
	
	ResultSet rs_C1 = null;
	Connection connection = null;
	try {
	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();
	    if("Y".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT())){
	      DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setDisabled( false);
	      //DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setRequired( true);
	      DUMMY_ACTION.getCOMP_UI_M_BUT_POLICY_NO().setDisabled( false);
	      DUMMY_ACTION.getCOMP_UI_M_POL_DOCCODE().setDisabled( false);
	      DUMMY_ACTION.getCOMP_UI_M_POL_DOCCODE().setRequired( true);
	     // DUMMY_ACTION.getCOMP_UI_M_DS_DESC().setDisabled(false);
	      DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_DOC_CODE().setDisabled( false);
	      
	      rs_C1 = handler.executeSelectStatement( CURSOR_C1, connection,
	       		new Object[]{DUMMY_BEAN.getUI_M_PROP_NO()});
	    
                 while(rs_C1.next()){
            		 DUMMY_BEAN.setUI_M_POL_DOCCODE( rs_C1.getString(1));
                 }
	    }
	    else if("N".equals(DUMMY_BEAN.getUI_M_PROP_CONVERT())){  
		    DUMMY_BEAN.setUI_M_POL_DOCCODE(null);
	    		DUMMY_BEAN.setUI_M_DS_DESC(null);
			DUMMY_BEAN.setUI_M_POLICY_NO(null);
	   	  DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setDisabled( true);
	   	  DUMMY_ACTION.getCOMP_UI_M_BUT_POLICY_NO().setDisabled( true);
	      DUMMY_ACTION.getCOMP_UI_M_POL_DOCCODE().setDisabled( true);
	     // DUMMY_ACTION.getCOMP_UI_M_DS_DESC().setDisabled( true);
	      DUMMY_ACTION.getCOMP_UI_M_BUT_LOV_DOC_CODE().setDisabled( true);
	    }


	 
    	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    public void  ui_m_pol_doccode_when_validate_item(
	    DUMMY_ACTION DUMMY_ACTION, DUMMY DUMMY_BEAN) throws SQLException,
	    Exception {
	String sql_C1 = "SELECT    POL_DIVN_CODE,    POL_CLASS_CODE,  "
		+ " POL_PLAN_CODE,POL_UW_YEAR,POL_ISSUE_DT,POL_PROD_CODE " +
				" FROM  PT_IL_POLICY  WHERE  POL_NO  =? ";
	 
	ResultSet rs_C1 = null;

	String M_POL_DIVN_CODE = null;
	String M_POL_CLASS_CODE = null;
	String M_POL_PLAN_CODE = null;
	Integer M_POL_UW_YEAR = 0;
	Date M_POL_ISSUE_DT = null;
	String M_PROD_CODE = null;
	Connection connection = null;
	try {
	    handler = new CRUDHandler();
	    connection = CommonUtils.getConnection();
	    L_DOC_DESC(DUMMY_BEAN);
	    if (DUMMY_BEAN.getUI_M_POL_DOCCODE() != null) {
		rs_C1 = handler.executeSelectStatement(sql_C1, connection,
			new Object[] { DUMMY_BEAN.getUI_M_POL_NO() });
		if (rs_C1.next()) {
		    M_POL_DIVN_CODE = rs_C1.getString(1);
		    M_POL_CLASS_CODE = rs_C1.getString(2);
		    M_POL_PLAN_CODE = rs_C1.getString(3);
		    M_POL_UW_YEAR = rs_C1.getInt(4);
		    M_POL_ISSUE_DT = rs_C1.getDate(5);
		    M_PROD_CODE = rs_C1.getString(6);
		}
		ArrayList<OracleParameter> pvallist = new PKG_PILT002_APAC()
			.P_SET_DOC_NO_PROP("2", 
					DUMMY_BEAN.getUI_M_POL_DOCCODE(),
					M_POL_DIVN_CODE,
				M_POL_CLASS_CODE, 
				M_POL_PLAN_CODE,
				M_PROD_CODE,
				 M_POL_UW_YEAR,
				"DUMMY.M_POLICY_NO",
				"DUMMY", 
				"Y",
				M_POL_ISSUE_DT, 
				null,
				null, 
				DUMMY_BEAN.getROWID(), 
				null);
		   
		if ("Y".equals((String)pvallist.get(1).getValueObject())) {
		    DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setDisabled(false);
		   // DUMMY_ACTION.getCOMP_UI_M_POLICY_NO().setRequired(true);

		}

	    }
	} catch (Exception e) {
		e.printStackTrace();
	    throw e;
	} finally {
	    CommonUtils.closeCursor(rs_C1);
	}
    }

    
    public void  ui_m_policy_no_when_validate_item(
	    DUMMY DUMMY_BEAN) throws SQLException,
	    Exception {
	CommonUtils commonUtils =new CommonUtils();
	try {
	    PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
		.getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
	    
        	 if("Y".equals(DUMMY_BEAN.getUI_M_FLAG())){
        	    new PILT002_APAC_LOCAL_PROCEDURES().IL_UNIQUE_POL_NO(
        		    compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DS_TYPE(),
        		    	DUMMY_BEAN.getUI_M_POLICY_NO());
        	 }
        	 
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    public void  ui_m_depprem_refund_yn_when_list_changed(DUMMY_ACTION DUMMY_ACTION,
	    DUMMY DUMMY_BEAN) throws SQLException,
	    Exception {
	try {
	    if("Y".equals(DUMMY_BEAN.getUI_M_DEPPREM_REFUND_YN() )){ 
        	    DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setDisabled( false);//',ENABLED,PROPERTY_TRUE);
        	    DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setRequired( true);
        	  //  SET_ITEM_PROPERTY('DUMMY.M_MED_FEE_RECOVER_YN',REQUIRED,PROPERTY_TRUE); 
	    }else{
		 DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setDisabled( true);
     	    	DUMMY_ACTION.getCOMP_UI_M_MED_FEE_RECOVER_YN().setRequired( false);
	 	/*SET_ITEM_PROPERTY('DUMMY.M_MED_FEE_RECOVER_YN',ENABLED,PROPERTY_FALSE);
        	   SET_ITEM_PROPERTY('DUMMY.M_MED_FEE_RECOVER_YN',REQUIRED,PROPERTY_FALSE); */
        	 DUMMY_BEAN.setUI_M_MED_FEE_RECOVER_YN("N");
	    }
        	 
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    public void ui_m_ps_reason_code_when_list_changed(
	    DUMMY_ACTION DUMMY_ACTION, DUMMY DUMMY_BEAN) throws SQLException,
	    Exception {
	try {
	    if (DUMMY_BEAN.getUI_M_PS_REASON_CODE() != null) {
		ArrayList<OracleParameter> pvallist = new PKG_PILT002_APAC()
			.P_VAL_CODES("IL_REASON", DUMMY_BEAN
				.getUI_M_PS_REASON_CODE(), DUMMY_BEAN
				.getUI_M_REASON_DESC(), "N", "E", null);
		if(pvallist.get(0).getValue() !=null){
		    DUMMY_BEAN.setUI_M_REASON_DESC(pvallist.get(0).getValue());
		}
	    }
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    /*Added by Sivarajan on 28/04/2021 for Allaince IL*/
	public String toConvertButtonED(String POL_NO) {
			 Connection connection = null;
			 ResultSet rs = null;
			 String returnValue = "N";
			String query="SELECT P9ILPK_POL_DETAILS.FUNC_QUOT_CNT_YN(?) FROM DUAL";	
				try {
				 connection = CommonUtils.getConnection();
				 rs = new CRUDHandler().executeSelectStatement(query, connection,
						 new Object[] {POL_NO});
				 if(rs.next()){
					 returnValue = rs.getString(1);
				 }
				
				} catch (Exception e) {
				 e.printStackTrace();
			 }
			 return returnValue;
		 }
		/*End*/

}
