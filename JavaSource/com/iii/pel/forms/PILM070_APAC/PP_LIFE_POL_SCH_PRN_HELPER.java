package com.iii.pel.forms.PILM070_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PP_LIFE_POL_SCH_PRN_HELPER {

	public void WHEN_NEW_FORM_INSTANCE(DUMMY DUMMY_BEAN ,PP_LIFE_POL_SCH_PRN_ACTION pp_life_pol_sch_prn_action) {
	    try {
		PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN = pp_life_pol_sch_prn_action.getPP_LIFE_POL_SCH_PRN_BEAN();
		//PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_MODULE_ID( CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		DUMMY_BEAN.setUI_M_PLSP_MODULE_ID( CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		UI_M_PLSP_MODULE_ID_WHEN_VALIDATE_ITEM(DUMMY_BEAN.getUI_M_PLSP_MODULE_ID() ,
			DUMMY_BEAN);
		pp_life_pol_sch_prn_action.getCOMP_UI_M_PLSP_MODULE_ID().setDisabled( true);
/*		SET_ITEM_PROPERTY('DUMMY.M_PLSP_MODULE_ID',UPDATE_ALLOWED,PROPERTY_FALSE);
		SET_ITEM_PROPERTY('DUMMY.M_PLSP_MODULE_ID',INSERT_ALLOWED,PROPERTY_FALSE);
*/	    } catch (Exception e) {
		e.printStackTrace();
		// TODO: handle exception
	    }
	}

	    public void PRE_INSERT(DUMMY  DUMMY_BEAN,PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN) throws ParseException {
		
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_CR_UID(CommonUtils.getControlBean()
			.getM_USER_ID())  ;
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_CR_DT(new CommonUtils().getCurrentDate());
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID( DUMMY_BEAN.getUI_M_PLSP_MODULE_ID());
		//PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID( PP_LIFE_POL_SCH_PRN_BEAN.getUI_M_PLSP_MODULE_ID());
		 
	    }
	    
	    public  void UI_M_PLSP_MODULE_ID_WHEN_VALIDATE_ITEM( String currValue,
		    DUMMY  DUMMY_BEAN ) throws Exception {
		try {
		    DUMMY_BEAN.setUI_M_PLSP_MODULE_ID(currValue);
		    DUMMY_BEAN.setUI_M_PLSP_MODULE_ID(currValue);
		    ArrayList<String> list =  new DBProcedures().callP_VAL_SYSTEM ("LIMODCODES" ,
			    DUMMY_BEAN.getUI_M_PLSP_MODULE_ID(),
			    DUMMY_BEAN.getUI_M_PLSP_MODULE_ID_DESC(),
			                "E", null);
			 if(list.get(0)!=null){
			     //PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_MODULE_ID_DESC(list.get(0));
			     DUMMY_BEAN.setUI_M_PLSP_MODULE_ID_DESC(list.get(0));
			 }
		 
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
	    }
	    public  void PLSP_DS_TYPE_WHEN_VALIDATE_ITEM( String currValue,PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN) throws Exception {
		try {
		    PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_CODE(currValue);
		    ArrayList<String> list =  new DBProcedures().callP_VAL_SYSTEM ("IL_DOC_TYP" ,
			    PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE(),
			    PP_LIFE_POL_SCH_PRN_BEAN.getUI_M_PLSP_DS_TYPE_DESC(),
			    "E", null);
		    if(list.get(0)!=null)
			PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_DS_TYPE_DESC(list.get(0));
		    
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
		    throw new ValidatorException(new FacesMessage(e.getMessage()));
		   // throw new Exception(e.getMessage());
		}
	    }
	    public  void PLSP_PROD_CODE_WHEN_VALIDATE_ITEM( String currValue,PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN) throws Exception {
		try {
		    PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_PROD_CODE( currValue);
		    P_VAL_PRODUCT( PP_LIFE_POL_SCH_PRN_BEAN,"E" );
		    checkDuplicate(PP_LIFE_POL_SCH_PRN_BEAN);
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
	    }
	    public  void PLSP_SRNO_WHEN_VALIDATE_ITEM( Integer currValue,PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN) throws Exception {
		try {
		    PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_SRNO(currValue);
		    if(currValue<0){
			throw new Exception("Serial No Should be a positive value");
		    }
		    
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
	    }
	    public  void PLSP_DS_CODE_WHEN_VALIDATE_ITEM( String currValue,PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN) throws Exception {
		Connection connection = null;
		String C1 = "SELECT  DS_DESC FROM  PM_IL_DOC_SETUP WHERE  (DS_TYPE =  ? "
		    + "  OR DS_TYPE = ? ) AND  DS_CODE =  ?";
		String C2 ="SELECT DS_TYPE     FROM 	 PM_IL_DOC_SETUP      WHERE  DS_CODE = ? ";
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_DS_CODE( currValue);
		ResultSet rs=null;
		try {
		    connection = CommonUtils.getConnection();
		    if("1".equals(PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE() )){
			rs= new CRUDHandler().executeSelectStatement(C1, connection,
				new Object[]{PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE(),
					null ,PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_CODE()});
			if(rs.next()) {
			    PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_DS_CODE_DESC( rs.getString( 1));
			}else{
			    throw new Exception(
		   		      Messages.getString(PELConstants.pelErrorMessagePath,
		   		      "3206",new Object[]{"Not a valid document code"}));
			}
				  
		    }else if("2".equals(PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE() )){
			rs= new CRUDHandler().executeSelectStatement(C1, connection,
				new Object[]{PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE(),"3" ,PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_CODE()});
			if(rs.next()) {
			    PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_DS_CODE_DESC( rs.getString( 1));
			}else{
			    throw new Exception(
		   		      Messages.getString(PELConstants.pelErrorMessagePath,
		   		      "3206" ,new Object[]{"Not a valid document code"}));
			}
		    }
		    
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
	    }

	    public void PRE_QUERY(PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN,DUMMY  DUMMY_BEAN) {
		// PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID( PP_LIFE_POL_SCH_PRN_BEAN.getUI_M_PLSP_MODULE_ID());
		 PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID( DUMMY_BEAN.getUI_M_PLSP_MODULE_ID());
	    }
	    
	    public void PRE_UPDATE(PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN,DUMMY  DUMMY_BEAN) {
		//PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID( PP_LIFE_POL_SCH_PRN_BEAN.getUI_M_PLSP_MODULE_ID());
		PP_LIFE_POL_SCH_PRN_BEAN.setPLSP_MODULE_ID( DUMMY_BEAN.getUI_M_PLSP_MODULE_ID());
	    }
	    public void POST_QUERY(PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN,DUMMY DUMMY_BEAN) throws Exception {
		String M_VALUE =null;
		String CURSOR_C1 ="  SELECT  DS_DESC    FROM  PM_IL_DOC_SETUP" +
				"   WHERE  DS_TYPE =? " +
				"   AND  DS_CODE =? ";
	  	  DBProcedures procedures = new DBProcedures();   
	  	Connection connection = null;
		ResultSet rs = null;

		try {
		    connection = CommonUtils.getConnection();
		 ArrayList<String> list =  procedures.callP_VAL_SYSTEM ("LIMODCODES" ,
			 DUMMY_BEAN.getUI_M_PLSP_MODULE_ID(),
			 DUMMY_BEAN.getUI_M_PLSP_MODULE_ID_DESC(),
		                "N", M_VALUE);
		 
		 if(list.get(0)!=null)
		     DUMMY_BEAN.setUI_M_PLSP_MODULE_ID_DESC(list.get(0));
		 
		 ArrayList<String> listDS =  procedures.callP_VAL_SYSTEM ("IL_DOC_TYP" ,
			 PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE(),
			 PP_LIFE_POL_SCH_PRN_BEAN.getUI_M_PLSP_DS_TYPE_DESC(),
		                "N", M_VALUE);
		 if(listDS.get(0)!=null)
		     PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_DS_TYPE_DESC(listDS.get(0));
		 
		                
		  P_VAL_PRODUCT( PP_LIFE_POL_SCH_PRN_BEAN,"N" );
		  rs = new CRUDHandler().executeSelectStatement(CURSOR_C1, connection, 
			  new Object[]{PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE(),
			  PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_CODE()});
		  		
		     if(rs.next()){
			 PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_DS_CODE_DESC(rs.getString(1));
		     }
 

		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
	    }
	    
	    public  void checkDuplicate(PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN) throws Exception {
		
		String C_DUPLICATE = " SELECT ROWID FROM PP_LIFE_POL_SCH_PRN WHERE PLSP_PROD_CODE=?" +
				" AND PLSP_DS_CODE=? AND PLSP_DS_TYPE=? ";
		String beanRowId =  null;
		String dbRowId =  null;
		ResultSet rs = null ;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		try {
		    connection = CommonUtils.getConnection();
		    beanRowId = PP_LIFE_POL_SCH_PRN_BEAN.getROWID();
		    rs = handler.executeSelectStatement(C_DUPLICATE, connection,
			    	new Object[]{PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_PROD_CODE(),
			    PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_CODE(),PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE()});
		    while(rs.next()){
			     dbRowId = rs.getString(1);
			    if(CommonUtils.isDuplicate(beanRowId, dbRowId )){
				throw new Exception("Duplicate Record for the combianation of  Document Type("+
					PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_TYPE()+"), Document Code("+
					PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_DS_CODE()+"), Product Code( "+
					PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_PROD_CODE() + ") is entered ");
			    }
		        }
		    
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		    throw new Exception(e.getMessage());
		}
		
	    }
	    
	    public void P_VAL_PRODUCT( PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN,String P_ERR_FLAG) throws Exception {
		// this.P_PROD_DESC = P_PROD_DESC;
		String Query = null;
		String M_PROD_DESC = null;
		String M_PROD_BL_DESC = null;
		ResultSet p_Val_Prd_Rs = null;
		CRUDHandler handler = new CRUDHandler();
		try {
		 
		    Query = "SELECT PROD_DESC,PROD_BL_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = '"
			    +  PP_LIFE_POL_SCH_PRN_BEAN.getPLSP_PROD_CODE() + "'";

		    p_Val_Prd_Rs = handler.executeSelectStatement(Query, CommonUtils
			    .getConnection());
		    if (p_Val_Prd_Rs.next()) {
			PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_PROD_CODE_DESC(p_Val_Prd_Rs.getString("PROD_DESC"));
			M_PROD_DESC = p_Val_Prd_Rs.getString("PROD_DESC");
			M_PROD_BL_DESC = p_Val_Prd_Rs.getString("PROD_BL_DESC");
			
			//setM_PROD_BL_DESC(p_Val_Prd_Rs.getString("PROD_BL_DESC"));
		    }
		    else{
		   	  if( CommonUtils.isIN(P_ERR_FLAG , "W","E") ){
		   	      if( "E".equals(P_ERR_FLAG )){
		   		  p_Val_Prd_Rs.close();
		   	      }
		   	      throw new Exception(
		   		      Messages.getString(PELConstants.pelErrorMessagePath,
		   		      "91074"));
		   	      
		   	   }
		   	  else{
		   	      if("1".equals(CommonUtils.SUBSTR(CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),5,1))  
		   		  || "ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))){
		   		PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_PROD_CODE_DESC( M_PROD_DESC );
		   	      }else{
		   		PP_LIFE_POL_SCH_PRN_BEAN.setUI_M_PLSP_PROD_CODE_DESC(  M_PROD_BL_DESC);
		   	      }
		   	  }
		    }
		} catch (Exception er) {
		    er.printStackTrace();
		    throw new Exception(er.getMessage());
		}
	    }

	public void executeQuery(  PP_LIFE_POL_SCH_PRN_ACTION PP_LIFE_POL_SCH_PRN_ACTION_BEAN ) throws Exception {
		new PP_LIFE_POL_SCH_PRN_DELEGATE().executeSelectStatement(PP_LIFE_POL_SCH_PRN_ACTION_BEAN);

         	 List<PP_LIFE_POL_SCH_PRN> dataList =  PP_LIFE_POL_SCH_PRN_ACTION_BEAN.getPreQueryResultList();
        	 if(dataList!=null && dataList.size() > 0){
        		PP_LIFE_POL_SCH_PRN PP_LIFE_POL_SCH_PRN_BEAN = dataList.get(0);
        		PP_LIFE_POL_SCH_PRN_BEAN.setRowSelected(true);
        		PP_LIFE_POL_SCH_PRN_ACTION_BEAN.setPP_LIFE_POL_SCH_PRN_BEAN(PP_LIFE_POL_SCH_PRN_BEAN);
        	}
	}


	
}
