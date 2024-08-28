package com.iii.pel.forms.PILT042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM;
import com.iii.pel.forms.PILT006_APAC.PT_IL_CLAIM_ACTION;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PILT042_APAC_HELPER {
	public void executeQuery(PT_IL_PRE_CLAIMS_INFO pt_il_pre_claims_info) throws Exception  {
		try {
			new PILT042_APAC_DELEGATE().executeSelectStatement(pt_il_pre_claims_info);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void PILT042_APAC_when_create_record(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception {
		CommonUtils commonUtils = new CommonUtils();
		try {
			ControlBean controlBean = CommonUtils.getControlBean();
			claimsBean.setPCI_CR_UID(controlBean.getM_USER_ID());
			claimsBean.setPCI_REPORT_DT(commonUtils.getCurrentDate());
			// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
			claimsBean.setPCI_LOSS_DT(commonUtils.getCurrentDate());
			//end
			claimsBean.setPCI_CLAIM_TYPE("D");
			claimsBean.setUI_M_PCI_ADDL_STATUS("");
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void PILT042_APAC_pre_insert(PT_IL_PRE_CLAIMS_INFO claimsBean,ControlBean controlBean) throws Exception{
		CRUDHandler handler = null;
		ResultSet rst = null;
		Connection con = null;
		CommonUtils commonUtils = new CommonUtils();
		int sysId = 0;
		String sysIdQuery = "SELECT P9IL_PCI_SYS_ID.NEXTVAL	FROM DUAL";
		String P_DISABLE_YN = null;
		ArrayList<OracleParameter> stringValue = null;
		String P_ROWID =null; 
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				P_ROWID = claimsBean.getROWID();
				/*if (P_ROWID == null) {
					P_ROWID = "";
				}*/
				L_CLAIM_VALID_POL_NO(claimsBean);
				if (claimsBean.getPCI_ADDL_STATUS() == null) {
					claimsBean.setPCI_ADDL_STATUS("CL01");
				}
				String MENUPARAM = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
				if(claimsBean.getPCI_REF_NO() == null || claimsBean.getPCI_REF_NO().isEmpty()){
					stringValue = P_GEN_DOC_NO("7", MENUPARAM,claimsBean.getUI_M_POL_DIVN_CODE(), 
							claimsBean.getUI_M_POL_CLASS_CODE(),claimsBean.getUI_M_POL_PLAN_CODE(), 
							claimsBean.getUI_M_POL_PROD_CODE(), commonUtils.integerToString(claimsBean.getUI_M_POL_UW_YEAR()), 
							"","PT_IL_PRE_CLAIMS_INFO", 
							"N",commonUtils.getProcedureValue(claimsBean.getPCI_REPORT_DT()),claimsBean.getPCI_CLAIM_TYPE(), 
							commonUtils.getProcedureValue(claimsBean.getPCI_REPORT_DT()),
							
							/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
							CommonUtils.nvl(claimsBean.getPCI_POL_NO(), null)
							/*End*/			
							
							);

					claimsBean.setPCI_REF_NO((String)stringValue.get(0).getValue());
					
					
					
					
				}
				rst = handler.executeSelectStatement(sysIdQuery, con);
				if(rst.next()){
					sysId = rst.getInt(1);
				}
				claimsBean.setPCI_SYS_ID(sysId);
				claimsBean.setPCI_CR_DT(commonUtils.getCurrentDate());
				claimsBean.setPCI_CR_UID(controlBean.getM_USER_ID());
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
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void L_CLAIM_VALID_POL_NO(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception{
		String M_TEMP = null;
		String M_TEMP1 = null;
		String M_TEMP2 = null ;
		String M_CLAIM_TYPE=null;
		String M_COVER_CODE=null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		ResultSet rst3 = null;
		ResultSet rst4 = null;
		String PCI_POL_NO = claimsBean.getPCI_POL_NO();
		Object[] values = { PCI_POL_NO };
		/*Added by saritha on 05-10-2017 for ssp call id ZBLIFE-1445282*/
		String PCI_ASSRD_CODE = claimsBean.getPCI_ASSRD_CODE();
		Object[] value = { PCI_ASSRD_CODE };
		/*End*/
		
		String selectQuery = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_NO  = ? " +
				"AND POL_DS_TYPE  = 2 AND POL_STATUS IN ('A','E','P','R')";
		String selectQuery1 ="SELECT 'X' FROM PT_IL_CLAIM_COVER_DTLS A," +
				"PM_IL_CLM_REPAY B WHERE  A.CCD_COVER_CODE = B.CR_COVER_CODE " +
				"AND A.CCD_LOSS_TYPE = B.CR_LOSS_TYPE AND A.CCD_DISAB_TYPE = B.CR_DISABLE_TYPE " +
				"AND NVL(CR_POLICY_VALID_YN,'N') = 'N' AND NVL(CR_APPLIED_ON,'X') !='W' " +
				"AND A.CCD_CLAIM_SYS_ID IN ( SELECT CLAIM_SYS_ID  FROM PT_IL_CLAIM " +
				"WHERE  CLAIM_POL_NO = ? AND    CLAIM_TYPE IN('A','D'))";
		
		/*Added by saritha on 05-10-2017 for ssp call id ZBLIFE-1445282*/
		/*String selectQuery2 ="SELECT ROWID FROM PT_IL_PRE_CLAIMS_INFO WHERE PCI_POL_NO = ? " +
				"AND PCI_CLAIM_TYPE IN ('A','D')";*/
		
		String selectQuery2 ="SELECT ROWID FROM PT_IL_PRE_CLAIMS_INFO WHERE PCI_POL_NO = ? AND PCI_ASSRD_CODE = ? AND PCI_CLAIM_TYPE IN ('A','D')";
		/*End*/
		
		String selectQuery3 = "SELECT POL_JOINT_LIFE_YN FROM PT_IL_POLICY WHERE POL_NO = ? ";
		
		String jointYN = null;
		

		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst3 = handler.executeSelectStatement(selectQuery3, con,values);
				if(rst3.next()){
					jointYN = rst3.getString(1);
				}
				// if condition changed  by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
				//if((!(jointYN.isEmpty())) && null != jointYN){
				if(null != jointYN){
					if("Y".equalsIgnoreCase(jointYN)){
					  	
					}
					else{
						rst = handler.executeSelectStatement(selectQuery, con, values);
						if(rst.next()){
							M_TEMP2 = rst.getString(1);
						}
						if (M_TEMP2 == null) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71081"));
						}
						rst1 = handler.executeSelectStatement(selectQuery1, con, values);
						if(rst.next()){
							M_TEMP = rst.getString(1);
						}
						
						/*Commentted &Modified by saritha on 05-10-2017 for ssp call id ZBLIFE-1445282*/
						/*if (M_TEMP != null) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91179",new Object[]{PCI_POL_NO, "Registered", "Death"}));
						}*/
						
						if (M_TEMP != null) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91179",new Object[]{PCI_POL_NO, "Registered", "Death"}));
						}
						rst2 = handler.executeSelectStatement(selectQuery2, con,new Object[]{claimsBean.getPCI_POL_NO(),claimsBean.getPCI_ASSRD_CODE()});
						if(rst2.next()){
							M_TEMP1 = rst2.getString(1);
						}
						/*if (M_TEMP1 != null && CommonUtils.isDuplicate(claimsBean.getROWID(), M_TEMP1)) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91179",new Object[]{PCI_POL_NO, "Registered", "Death Pre"}));
						}*/
						
						if (M_TEMP1 != null && CommonUtils.isDuplicate(claimsBean.getROWID(), M_TEMP1)) {
							throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91179",new Object[]{PCI_POL_NO,PCI_ASSRD_CODE, "Registered", "Death Pre"}));
						}
						/*End*/
					}
				}
				
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	/**
    *
    * @param P_DOC_TYPE-IN
    * @param P_DOC_CODE-IN
    * @param P_DIVN_CODE-IN
    * @param P_CLASS_CODE-IN
    * @param P_PLAN_CODE-IN
    * @param P_PROD_CODE-IN
    * @param P_UW_YEAR-IN
    * @param P_DOC_NO_FN-IN OUT
    * @param P_BLOCK_NAME-IN
    * @param P_DUMMY_YN-IN
    * @param P_DATE-IN
    * @param P_CLAIM_TYPE-IN
    * @param P_REG_DATE-IN
    * @param P_ROWID-IN
    * @param P_DISABLE_YN-OUT
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  
  
  public ArrayList<OracleParameter> P_GEN_DOC_NO(String P_DOC_TYPE,
			String P_DOC_CODE, String P_DIVN_CODE, String P_CLASS_CODE,
			String P_PLAN_CODE, String P_PROD_CODE, String P_UW_YEAR,
			String P_DOC_NO_FN, String P_BLOCK_NAME, String P_DUMMY_YN,
			String P_DATE, String P_CLAIM_TYPE, String P_REG_DATE,
			
			  /*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
		       String P_POL_NO
		       /*End*/
		  )
			throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",
					P_DOC_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
					P_DOC_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
					P_DIVN_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",
					P_CLASS_CODE);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",
					P_PLAN_CODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",
					P_PROD_CODE);
			parameterList.add(param6);
			OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",
					P_UW_YEAR);
			parameterList.add(param7);
			OracleParameter param8 = new OracleParameter("IN OUT8", "STRING",
					"IN OUT", P_DOC_NO_FN);
			parameterList.add(param8);
			OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",
					P_BLOCK_NAME);
			parameterList.add(param9);
			OracleParameter param10 = new OracleParameter("IN10", "STRING",
					"IN", P_DUMMY_YN);
			parameterList.add(param10);
			OracleParameter param11 = new OracleParameter("IN11", "STRING",
					"IN", P_DATE);
			parameterList.add(param11);
			OracleParameter param12 = new OracleParameter("IN12", "STRING",
					"IN", P_CLAIM_TYPE);
			parameterList.add(param12);
			OracleParameter param13 = new OracleParameter("IN13", "STRING",
					"IN", P_REG_DATE);
			parameterList.add(param13);
			
			/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/

			OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_POL_NO);
			parameterList.add(param14);

			/*End*/
			

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, connection,
					"LIFELIB.P_GEN_DOC_NO");
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

  


	
	public void PILT042_APAC_post_query(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception{
		DBProcedures procCall = new DBProcedures();
		String M_PS_CODE_DESC = null;
		String RES_AREA_NAME = null;
		ArrayList<String> stringValue = null;
		String M_DUMMY = null;
		String M_PS_VALUE = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		String selectQuery =" SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_ADDL_STAT' AND    PS_CODE = ? ";
		String selectQuery1 =" SELECT 'X' FROM   PT_IL_CLAIM WHERE  CLAIM_PCI_REF_NO = ?";
		String selectQuery2 = " SELECT POL_START_DT, POL_EXPIRY_DT,POL_DIVN_CODE,POL_CLASS_CODE,POL_UW_YEAR,POL_PLAN_CODE,POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = ? ";
		String status = claimsBean.getPCI_ADDL_STATUS() ;
		String rfcNo = claimsBean.getPCI_REF_NO();
		String polNo = claimsBean.getPCI_POL_NO();

		if (status == null) {
			status = "";
		}
		if (rfcNo == null) {
			rfcNo = "";
		}
		if (polNo == null) {
			polNo = "";
		}
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				Object[] values = { status };
				Object[] values1 = { rfcNo };
				Object[] values2 = { polNo };

				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if (rst.next()) {
					M_PS_CODE_DESC = rst.getString("PS_CODE_DESC");
				}
				claimsBean.setUI_M_PCI_ADDL_STATUS(claimsBean.getPCI_ADDL_STATUS() + ":" + M_PS_CODE_DESC);
				if (claimsBean.getPCI_RES_AREA_CODE() != null) {
					stringValue = procCall.helperPKG_PILT002$P_VAL_CODES("POSTAL", claimsBean.getPCI_RES_AREA_CODE(),claimsBean.getUI_M_RES_AREA_NAME(), "N", "E", null);
					if (stringValue != null) {
						RES_AREA_NAME = stringValue.get(0);
						claimsBean.setUI_M_RES_AREA_NAME(RES_AREA_NAME);
					}
				}else{
					claimsBean.setUI_M_RES_AREA_NAME(null);
				}
				if (claimsBean.getPCI_CITY_CODE() != null) {
					stringValue = procCall.helperPKG_PILT002$P_VAL_CODES("CITY", claimsBean.getPCI_CITY_CODE(), claimsBean.getUI_M_PCI_CITY_NAME(), "N", "E", null);
					if (stringValue != null) {
						RES_AREA_NAME = stringValue.get(0);
						claimsBean.setUI_M_PCI_CITY_NAME(RES_AREA_NAME);
					}
				}else{
					claimsBean.setUI_M_PCI_CITY_NAME(null);
				}
				if (claimsBean.getPCI_STATE_CODE() != null) {
					stringValue = procCall.helperPKG_PILT002$P_VAL_CODES("STATE", claimsBean.getPCI_STATE_CODE(), claimsBean.getUI_M_PCI_STATE_CODE(), "N", "E", null);
					if (stringValue != null) {
						RES_AREA_NAME = stringValue.get(0);
						claimsBean.setUI_M_PCI_STATE_CODE(RES_AREA_NAME);
					}
				}else{
					claimsBean.setUI_M_PCI_STATE_CODE(null);
				}
				if (claimsBean.getPCI_INTIMATION_MODE() != null) {
					stringValue = procCall.callPCOPK_GENERAL_P_VAL_SYSTEM("IL_INTI_MODE", claimsBean.getPCI_INTIMATION_MODE(), claimsBean.getUI_M_PCI_INTIMATION_MODE(), "E", M_PS_VALUE+"");
					if (stringValue != null) {
						RES_AREA_NAME = stringValue.get(0);
						M_PS_VALUE = stringValue.get(1);
						claimsBean.setUI_M_PCI_INTIMATION_MODE(RES_AREA_NAME);
					}
				}else{
					claimsBean.setUI_M_PCI_INTIMATION_MODE(null);
				}
				rst1 = handler.executeSelectStatement(selectQuery1, con,values1);
				if (rst1.next()) {
					M_DUMMY = rst.getString(1);
				}
				if (M_DUMMY == null) {
					claimsBean.setUPDATE_ALLOWED(false);
					claimsBean.setDELETE_ALLOWED(false);
				}
				rst2 = handler.executeSelectStatement(selectQuery2, con,values2);
				if (rst2.next()) {
					claimsBean.setUI_M_POL_START_DT(rst2.getDate("POL_START_DT"));
					claimsBean.setUI_M_POL_EXPIRY_DT(rst2.getDate("POL_EXPIRY_DT"));
					claimsBean.setUI_M_POL_DIVN_CODE(rst2.getString("POL_DIVN_CODE"));
					claimsBean.setUI_M_POL_CLASS_CODE(rst2.getString("POL_CLASS_CODE"));
					claimsBean.setUI_M_POL_UW_YEAR(rst2.getInt("POL_UW_YEAR"));
					claimsBean.setUI_M_POL_PLAN_CODE(rst2.getString("POL_PLAN_CODE"));
					claimsBean.setUI_M_POL_PROD_CODE(rst2.getString("POL_PROD_CODE"));
				}
				L_CLAIM_ASSR_DESC(claimsBean);
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
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void when_new_record_instance(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception {
		String M_PS_CODE_DESC = null;
		String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		String selectQuery = "SELECT PS_CODE_DESC FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_ADDL_STAT' AND    PS_CODE = '"+claimsBean.getPCI_ADDL_STATUS()+"'";
		String selectQuery1 = " SELECT 'X' FROM   PT_IL_CLAIM WHERE  CLAIM_PCI_REF_NO = '"+claimsBean.getPCI_REF_NO()+"'";

		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con);
				if(rst.next()){
					M_PS_CODE_DESC = rst.getString(1);
				}
				claimsBean.setUI_M_PCI_ADDL_STATUS(claimsBean.getPCI_ADDL_STATUS()+ ":" + M_PS_CODE_DESC);
				rst1 = handler.executeSelectStatement(selectQuery1, con);
				if(rst1.next()){
					M_DUMMY = rst.getString(1);
				}
				if (M_DUMMY == null) {
					claimsBean.setUPDATE_ALLOWED(false);
					claimsBean.setDELETE_ALLOWED(false);
				}else{
					claimsBean.setUPDATE_ALLOWED(true);
					claimsBean.setDELETE_ALLOWED(true);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void pre_query(PT_IL_PRE_CLAIMS_INFO claimsBean) {
		claimsBean.setPCI_REF_NO(CommonUtils.getGlobalVariable("GLOBAL.PRE_CLAIM_NO"));
		String PCI_SYS_ID = (String) CommonUtils.getGlobalObject("GLOBAL.PCI_SYS_ID");
		if(PCI_SYS_ID!= null){
			claimsBean.setPCI_SYS_ID(Integer.parseInt(PCI_SYS_ID));
			CommonUtils.setGlobalVariable("GLOBAL.PCI_SYS_ID", null);
		}
	}
	public void pre_update(PT_IL_PRE_CLAIMS_INFO claimsBean) {
		ControlBean controlBean = CommonUtils.getControlBean();
		CommonUtils commonUtils = new CommonUtils();
		try {
			if (claimsBean.getPCI_ADDL_STATUS() == null) {
				claimsBean.setPCI_ADDL_STATUS("CL01");
			}
			claimsBean.setPCI_UPD_DT(commonUtils.getCurrentDate());
			claimsBean.setPCI_UPD_UID(controlBean.getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	public void pci_assrd_ref_id1_when_validate(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception{
		DBProcedures procCall = new DBProcedures();
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null,rst1 = null,rst2 = null,rst3 = null;
		int M_LENGTH_1;
		int M_NEW_IC_NO_LENGTH = 0;
		int M_REF_ID_1_LENGTH = 0;
		String M_CODE_DESC = null;
		String M_CUST_DOB;
		String M_DATE_CHAR = null;
		Date M_TEMP_DATE;
		int M_LENGTH_2;
		int M_OLD_IC_NO_LENGTH = 0;
		int M_REF_ID2_LENGTH = 0;
		String M_CONT_REF_ID2 = null;
		String M_POL_NO = null;
		String M_POL_PROP_NO;
		String M_POL_STATUS = null;
		String M_PS_VALUE = null;
		String M_POL_ASSRD_REF_ID1 = null;
		String PCI_ASSRD_REF_ID1 = claimsBean.getPCI_ASSRD_REF_ID1();
		String polNo = claimsBean.getPCI_POL_NO() ;
		//String selectQuery = "SELECT NVL(CONT_REF_ID2 ,'') FROM  PM_IL_CONTRACTOR WHERE CONT_REF_ID2 = ?";
		String selectQuery = "select CONT_REF_ID2 from PM_IL_CONTRACTOR where CONT_REF_ID1 = ?";
		String selectQuery1 = " SELECT POL_NO,POL_STATUS FROM  PT_IL_POLICY WHERE    POL_ASSRD_REF_ID1= ? AND     (NVL(POL_CONVERT_YN,'N') = 'N' OR POL_DS_TYPE ='2') AND POL_STATUS IN ('A','E','P','R')";
		String selectQuery2 = " SELECT SUBSTR(?,1,6) FROM   DUAL";
		String selectQuery3 = " SELECT POL_ASSRD_REF_ID1 FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
		if(PCI_ASSRD_REF_ID1==null){
			PCI_ASSRD_REF_ID1 = "";
		}
		if(polNo==null){
			polNo = "";
		}
		Object[] values = { PCI_ASSRD_REF_ID1 };
		Object[] values3 = { polNo };
		ArrayList<String> stringValue = null;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				if (PCI_ASSRD_REF_ID1 != null) {
					stringValue = procCall.callPCOPK_GENERAL_P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_1", M_CODE_DESC, "N", M_NEW_IC_NO_LENGTH+"");
					if (stringValue != null) {
						//M_CODE_DESC = stringValue.get(0);
						/*Modified by saranya for Hands on point num11 on 07-02-2017*/
						M_NEW_IC_NO_LENGTH = Integer.parseInt(stringValue.get(1));
					}/*End*/
					int value = MigratingFunctions.nvl(M_NEW_IC_NO_LENGTH,M_REF_ID_1_LENGTH);
					M_LENGTH_1 = value < M_REF_ID_1_LENGTH ? value: M_NEW_IC_NO_LENGTH;
					if(PCI_ASSRD_REF_ID1.length() > M_LENGTH_1){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91240",new Object[]{M_LENGTH_1+""}));
					}
					stringValue = procCall.callPCOPK_GENERAL_P_VAL_SYSTEM("CUSTREFFMT", "CUSTREFFMT", M_CODE_DESC, "N", M_PS_VALUE);
					if (stringValue != null) {
						M_CODE_DESC = stringValue.get(0);
						M_PS_VALUE = stringValue.get(1);
					}
					if ("1".equals(M_PS_VALUE) ) {
						rst3 = handler.executeSelectStatement(selectQuery2, con,values);
						if(rst3.next()){
							M_DATE_CHAR = rst3.getString(1);
						}
						
						
						M_TEMP_DATE = CommonUtils.stringToDate(M_DATE_CHAR, "yyMMdd");
						
						CommonUtils commonUtils = new CommonUtils();
						int valueDate = CommonUtils.getYearFromDate(M_TEMP_DATE);
						int currDateValue = CommonUtils.getYearFromDate(commonUtils.getCurrentDate());
						if(!(valueDate > currDateValue)){
							//	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91173"));
						}
					}
				}
				rst = handler.executeSelectStatement(selectQuery, con,values);
				if (rst.next()) {
					M_CONT_REF_ID2 = rst.getString(1);
					if (claimsBean.getPCI_ASSRD_REF_ID2() == null) {
						claimsBean.setPCI_ASSRD_REF_ID2(M_CONT_REF_ID2);
					}
				}
				stringValue = procCall.callPCOPK_GENERAL_P_VAL_SYSTEM("LEN_REF_ID", "REF_ID_2", M_CODE_DESC, "N", M_OLD_IC_NO_LENGTH+"");
				if (stringValue != null) {
					//M_CODE_DESC = stringValue.get(0);
					/*Modified by saranya for hands on point num 11 on 05-02-17*/ 
					/*M_OLD_IC_NO_LENGTH = Integer.parseInt(stringValue.get(0));*/
					M_OLD_IC_NO_LENGTH = Integer.parseInt(stringValue.get(1));
					/*End*/
				}
				int value = MigratingFunctions.nvl(M_OLD_IC_NO_LENGTH,M_REF_ID2_LENGTH);
				M_LENGTH_2 = value < M_REF_ID2_LENGTH ? value: M_OLD_IC_NO_LENGTH;
				if (claimsBean.getPCI_ASSRD_REF_ID2() != null) {
					if(claimsBean.getPCI_ASSRD_REF_ID2().length() > M_LENGTH_2){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91240"));
					}
				}
				
				/*commented by saranya for Hands on point num 11 on 07-02-2017*/
				/*if(claimsBean.getPCI_ASSRD_REF_ID1()!= null){
					rst1 = handler.executeSelectStatement(selectQuery1, con,values);
					if (rst1.next()) {
						M_POL_NO = rst1.getString(1);
						M_POL_STATUS = rst1.getString(2);
						if(claimsBean.getPCI_POL_NO() == null){
							claimsBean.setPCI_POL_NO(M_POL_NO);
						}
					}
				}*/
				if(claimsBean.getPCI_POL_NO()!=null){
					Object[] valuesp = { claimsBean.getPCI_POL_NO() };
					rst2 = handler.executeSelectStatement(selectQuery3, con, valuesp);
					if(rst2.next()){
						M_POL_ASSRD_REF_ID1 = rst2.getString(1);
					}
					if(M_POL_ASSRD_REF_ID1 == PCI_ASSRD_REF_ID1){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91173"));
					}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst3);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void pci_assrd_ref_id2_when_validate(PT_IL_PRE_CLAIMS_INFO claimsBean, int id2Length) throws Exception{
		DBProcedures procCall = new DBProcedures();
		String M_CODE_DESC = null;
		int M_LENGTH_2 = 0;
		int M_OLD_IC_NO_LENGTH = 0;
		int M_REF_ID2_LENGTH = id2Length;
		String M_CONT_REF_ID1 = null;
		String M_POL_NO = null;
		String M_POL_STATUS = null;
		String M_POL_ASSRD_REF_ID2 = null;
		Connection con = null;
		ResultSet rst1 = null, rst2 = null, rst3 = null, rst4 = null;
		CRUDHandler handler = null;
		String PCI_ASSRD_REF_ID1 = claimsBean.getPCI_ASSRD_REF_ID1();
		ArrayList<String> stringValue = null;
		Object[] values = null;
		String c1 = " SELECT NVL(CONT_REF_ID1 ,'') FROM PM_IL_CONTRACTOR WHERE  CONT_REF_ID2 = ?";
		String c2 = " SELECT POL_NO,POL_STATUS FROM PT_IL_POLICY WHERE POL_ASSRD_REF_ID1= ? AND  (NVL(POL_CONVERT_YN,'N') = 'N' OR POL_DS_TYPE ='2') AND POL_STATUS IN ('A','E','P','R')";
		String c3 = " SELECT POL_NO,POL_STATUS FROM PT_IL_POLICY WHERE POL_ASSRD_REF_ID2= ? AND  (NVL(POL_CONVERT_YN,'N') = 'N' OR POL_DS_TYPE ='2') AND POL_STATUS IN ('A','E','P','R')";
		String c4 = " SELECT POL_ASSRD_REF_ID2 FROM   PT_IL_POLICY WHERE  POL_NO = ? ";

		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(claimsBean.getPCI_ASSRD_REF_ID2() != null){
				values = new Object[]{claimsBean.getPCI_ASSRD_REF_ID2()};
				rst1 = handler.executeSelectStatement(c1, con, values);
				if(rst1.next()){
					M_CONT_REF_ID1 = rst1.getString(1);
					
					if(claimsBean.getPCI_ASSRD_REF_ID1() == null){
						claimsBean.setPCI_ASSRD_REF_ID1(M_CONT_REF_ID1);
					}
				}
				
				stringValue = procCall.callPCOPK_GENERAL_P_VAL_SYSTEM(
						"LEN_REF_ID", 
						"REF_ID_2", 
						M_CODE_DESC, 
						"N", 
						String.valueOf(M_OLD_IC_NO_LENGTH));
				if(stringValue.size() > 0){
					M_OLD_IC_NO_LENGTH = Integer.parseInt(stringValue.get(0));
				}
				
				M_LENGTH_2 = Math.min(CommonUtils.nvl(M_OLD_IC_NO_LENGTH, M_REF_ID2_LENGTH), M_REF_ID2_LENGTH);
				
				if(claimsBean.getPCI_ASSRD_REF_ID2().length() > M_LENGTH_2){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, 
							"91240", 
							new Object[]{M_LENGTH_2}));
				}
				
				if(claimsBean.getPCI_ASSRD_REF_ID1() != null){
					values = new Object[]{claimsBean.getPCI_ASSRD_REF_ID1()};
					rst2 = handler.executeSelectStatement(c2, con, values);
					if(rst2.next()){
						M_POL_NO = rst2.getString(1);
						M_POL_STATUS = rst2.getString(2);
					}
					if(claimsBean.getPCI_POL_NO() == null){
						claimsBean.setPCI_POL_NO(M_POL_NO);
					}
				}else if(claimsBean.getPCI_ASSRD_REF_ID2() != null){
					values = new Object[]{claimsBean.getPCI_ASSRD_REF_ID2()};
					rst3 = handler.executeSelectStatement(c3, con, values);
					if(rst3.next()){
						M_POL_NO = rst3.getString(1);
						M_POL_STATUS = rst3.getString(2);
					}
					if(claimsBean.getPCI_POL_NO() == null){
						claimsBean.setPCI_POL_NO(M_POL_NO);
					}
				}
			}

			if(claimsBean.getPCI_POL_NO() != null){
				values = new Object[]{claimsBean.getPCI_POL_NO()};
				rst4 = handler.executeSelectStatement(c4, con, values);
				if(rst4.next()){
					M_POL_ASSRD_REF_ID2 = rst4.getString(1);
				}
				if(!claimsBean.getPCI_ASSRD_REF_ID2().equals(M_POL_ASSRD_REF_ID2)){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91173"));
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
				CommonUtils.closeCursor(rst1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst3);
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(rst4);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void PCI_POL_NO_key_listener(PT_IL_PRE_CLAIMS_INFO claimsBean){
		String M_REF_ID1;
		String M_REF_ID2;
try{
		String PCI_ASSRD_REF_ID1 = claimsBean.getPCI_ASSRD_REF_ID1();
		String PCI_ASSRD_REF_ID2 = claimsBean.getPCI_ASSRD_REF_ID2();
		if (PCI_ASSRD_REF_ID1 == null && PCI_ASSRD_REF_ID2 == null) {
			M_REF_ID1 = MigratingFunctions.nvl(PCI_ASSRD_REF_ID1, "");
			M_REF_ID2 = MigratingFunctions.nvl(PCI_ASSRD_REF_ID2, "");
		}else{
			M_REF_ID1 = MigratingFunctions.nvl(PCI_ASSRD_REF_ID1, "PCI_ASSRD_REF_ID1");
			M_REF_ID2 = MigratingFunctions.nvl(PCI_ASSRD_REF_ID2, "PCI_ASSRD_REF_ID2");
		}
}catch (Exception e) {
	e.printStackTrace();
}

	}
	public void PCI_POL_NO_when_validate(PT_IL_PRE_CLAIMS_INFO claimsBean,String value,PT_IL_PRE_CLAIMS_INFO_ACTION preclaiminfoact) throws Exception{
		Connection con = null;
		ResultSet rst = null;
		CRUDHandler handler = null;
		Object values[] = null;
		/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		handler=new CRUDHandler();
		ResultSet rs1 = null; 
		ResultSet rs2 = null; 
		ResultSet rs3= null; 
	
		String ASD_CHAR_VALUE =null;
		String POL_ADDL_STATUS = null;
		String POL_PROD_CODE= null;	
		String POL_SYS_ID =null;
		/*End*/
		String selectQuery = " SELECT POL_START_DT, POL_EXPIRY_DT,POL_DIVN_CODE,POL_CLASS_CODE,POL_UW_YEAR,POL_PLAN_CODE,POL_PROD_CODE, POL_ASSRD_REF_ID1, POL_ASSRD_REF_ID2,POL_CUST_CODE	FROM PT_IL_POLICY	WHERE POL_NO = ?";
		/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/ 
			String C1 = "SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO= ?";
			String C2 = "SELECT POL_ADDL_STATUS FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
			String C3 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =?  AND" +
						" ASD_CODE = 'PRE_LAP_POL' AND " +
						" ? BETWEEN ASD_FM_PROD_CODE AND ASD_TO_PROD_CODE";
			
			//END
		/*End*/
		try {
			con = CommonUtils.getConnection();
			
			
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			rs1= handler.executeSelectStatement(C1, con,
					new Object[] {value});
			System.out.println("policy no"+value);
			while (rs1.next()) {
				POL_PROD_CODE = rs1.getString("POL_PROD_CODE");
				POL_SYS_ID= rs1.getString("POL_SYS_ID");
				System.out.println("Product Code****************"+POL_PROD_CODE);
			}
		
			rs2 = handler.executeSelectStatement(C2, con,
					new Object[] {POL_SYS_ID});
			while (rs2.next()) {
				POL_ADDL_STATUS = rs2.getString("POL_ADDL_STATUS");
				System.out.println("Additional Status****************"+POL_ADDL_STATUS);
			}

			String Userid=CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID");
			System.out.println("User Id*************"+CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			
			rs3 = handler.executeSelectStatement(C3, con,
					new Object[] { Userid,POL_PROD_CODE});
			System.out.println("User id"+Userid);
			System.out.println("Product Code"+POL_PROD_CODE);
			if (rs3.next()) {
				ASD_CHAR_VALUE = rs3.getString(1);
				System.out.println("ASD_CHAR_VALUE::::::::::::::::::::::::"+ASD_CHAR_VALUE);
			}
			
			if(("N".equalsIgnoreCase(ASD_CHAR_VALUE))&&(("L01".equalsIgnoreCase(POL_ADDL_STATUS))||("L02".equalsIgnoreCase(POL_ADDL_STATUS)))){
				throw new Exception(
						"The policy is in Pre-lapse state,only authorized User is allowed to do the Claim Registration.");
				
				}
					
			/*End*/	
			
			if(con!= null){
				handler = new CRUDHandler();
				L_CLAIM_VALID_POL_NO(claimsBean);
				//COMMENTTED BY SARITHA
				values = new Object[]{claimsBean.getPCI_POL_NO()};
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					claimsBean.setUI_M_POL_START_DT(rst.getDate("POL_START_DT"));
					claimsBean.setUI_M_POL_EXPIRY_DT(rst.getDate("POL_EXPIRY_DT"));
					claimsBean.setUI_M_POL_DIVN_CODE(rst.getString("POL_DIVN_CODE"));
					claimsBean.setUI_M_POL_CLASS_CODE(rst.getString("POL_CLASS_CODE"));
					claimsBean.setUI_M_POL_UW_YEAR(rst.getInt("POL_UW_YEAR"));
					claimsBean.setUI_M_POL_PLAN_CODE(rst.getString("POL_PLAN_CODE"));
					claimsBean.setUI_M_POL_PROD_CODE(rst.getString("POL_PROD_CODE"));
					/*Commented by saranya for HAns on point num 11 on 05-02-2017*/
					//claimsBean.setPCI_ASSRD_REF_ID1(rst.getString("POL_ASSRD_REF_ID1"));    
					/*End*/
					claimsBean.setPCI_ASSRD_REF_ID2(rst.getString("POL_ASSRD_REF_ID2"));
				}
				
				// // added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
				
				String ASSUREDQUERY ="SELECT POL_SYS_ID,POL_PLAN_CODE,POL_CONT_CODE,POL_ASSURED_NAME FROM PT_IL_POLICY  WHERE POL_NO = ?";
			ResultSet rs5= null; 
	
	rs5= handler.executeSelectStatement(ASSUREDQUERY, con,
			new Object[] {value});

	if (rs5.next()) {
		// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
		CommonUtils.setGlobalVariable("PCI_POL_PLAN_CODE", rs5.getString("POL_PLAN_CODE"));
		CommonUtils.setGlobalVariable("PCI_POL_SYS_ID", rs5.getString("POL_SYS_ID"));
		//end
		
		/*Modified by saritha on 26-10-2017 for ssp call id ZBLIFE-1445282 as per thiag sir sugg*/
		if("207".equalsIgnoreCase(rs5.getString("POL_PLAN_CODE"))||"210".equalsIgnoreCase(rs5.getString("POL_PLAN_CODE"))||
				"211".equalsIgnoreCase(rs5.getString("POL_PLAN_CODE"))||"212".equalsIgnoreCase(rs5.getString("POL_PLAN_CODE"))){
			
			//claimsBean.setPCI_ASSRD_CODE(rs5.getString("POL_CONT_CODE"));
			//claimsBean.setUI_M_PCI_ASSRD_NAME(rs5.getString("POL_ASSURED_NAME"));
			preclaiminfoact.getCOMP_PCI_ASSRD_CODE().setDisabled(false);
		
		/*End*/
		}else{
			claimsBean.setPCI_ASSRD_CODE(rs5.getString("POL_CONT_CODE"));
			claimsBean.setUI_M_PCI_ASSRD_NAME(rs5.getString("POL_ASSURED_NAME"));
			preclaiminfoact.getCOMP_PCI_ASSRD_CODE().setDisabled(true);
			
		}
		
	}
//end
	
	
				
			}
			
		}catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		finally
		{
			CommonUtils.closeCursor(rs1);
			CommonUtils.closeCursor(rs2);
			CommonUtils.closeCursor(rs3);
		}
		
		/*End*/
	}
	public void PCI_CLAIM_TYPE_when_validate(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception{
		try {
			L_CLAIM_VALID_POL_NO(claimsBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage()); 
		}
	}
	public void PCI_LOSS_DT_when_validate(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception{
		ControlBean controlBean = CommonUtils.getControlBean();
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		int M_ANS;
		String M_PS_CODE_DESC;
		String selectQuery = "SELECT PS_CODE_DESC FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_ADDL_STAT' AND    PS_CODE = '"+claimsBean.getPCI_ADDL_STATUS()+"'";
		String P_ROWID = null;
		String P_DISABLE_YN = null;
		ArrayList<String> stringValue = null;
		try {
			con = CommonUtils.getConnection();
			if(con != null){
				handler = new CRUDHandler();
				if(claimsBean.getPCI_REPORT_DT()!=null){
					if(claimsBean.getPCI_LOSS_DT().after(claimsBean.getPCI_REPORT_DT())){
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71100"));
					}
				}
				//[MQC111
				//if(claimsBean.getPCI_LOSS_DT().after(claimsBean.getUI_M_POL_START_DT())&& claimsBean.getPCI_LOSS_DT().before(claimsBean.getUI_M_POL_EXPIRY_DT())){
				//MQC111]

				//[MQC111
				
				// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
				if(null!=claimsBean.getUI_M_POL_START_DT()){
					//end
				
				
				if(claimsBean.getPCI_LOSS_DT().before(claimsBean.getUI_M_POL_START_DT()) || claimsBean.getPCI_LOSS_DT().after(claimsBean.getUI_M_POL_EXPIRY_DT())){
					//[MQC111
					claimsBean.setPCI_ADDL_STATUS("R");
					throw new Exception("Loss date is outside the policy period. Do you want to reject? ");
				}
				
				}
				rst = handler.executeSelectStatement(selectQuery, con);
				if(rst.next()){
					M_PS_CODE_DESC = rst.getString(1);
				}
				P_ROWID = claimsBean.getROWID();
				/*if(P_ROWID == null){
				P_ROWID = "";
			}*/
				SimpleDateFormat sdf = new SimpleDateFormat(PELConstants.dbDateFormat);
				String reportDate = null;
				if(claimsBean.getPCI_REPORT_DT()==null){
					reportDate="";
				}else{
					reportDate = sdf.format(claimsBean.getPCI_REPORT_DT());
				}
				System.out.println("controlBean.getM_PARA_1()"+controlBean.getM_PARA_1());
				String MENUPARAM = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
				claimsBean.setUI_M_PCI_ADDL_STATUS(claimsBean.getPCI_ADDL_STATUS()+ ":"+claimsBean.getUI_M_PS_CODE_DESC());
				stringValue = helperPKG_PILT002$P_SET_DOC_NO_PROP("7", 
						MENUPARAM, 
						claimsBean.getUI_M_POL_DIVN_CODE(), 
						claimsBean.getUI_M_POL_CLASS_CODE(), 
						claimsBean.getUI_M_POL_PLAN_CODE(), 
						claimsBean.getUI_M_POL_PROD_CODE(), 
						claimsBean.getUI_M_POL_UW_YEAR()+"", 
						"PT_IL_PRE_CLAIMS_INFO.PCI_REF_NO", 
						"PT_IL_PRE_CLAIMS_INFO", 
						"Y", reportDate, 
						claimsBean.getPCI_CLAIM_TYPE(), 
						reportDate, 
						P_ROWID,P_DISABLE_YN);
				if(stringValue!= null || !stringValue.isEmpty()){
					P_DISABLE_YN = stringValue.get(1);
					claimsBean.setM_DISABLE_YN(P_DISABLE_YN);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public ArrayList<String> helperPKG_PILT002$P_SET_DOC_NO_PROP(String P_DOC_TYPE,String P_DOC_CODE,
			String P_DIVN_CODE,String P_CLASS_CODE,String P_PLAN_CODE,String P_PROD_CODE,String P_UW_YEAR,
			String P_DOC_NO_FN,String P_BLOCK_NAME,String P_DUMMY_YN,String P_DATE,String P_CLAIM_TYPE,
			String P_REG_DATE,String P_ROWID,String P_DISABLE_YN)
			throws Exception {
		Connection connection = null;
		connection = CommonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_DOC_TYPE);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_DOC_CODE);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_DIVN_CODE);
		OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CLASS_CODE);
		OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_PLAN_CODE);
		OracleParameter param6 = new OracleParameter("IN6", "STRING", "IN",P_PROD_CODE);
		OracleParameter param7 = new OracleParameter("IN7", "STRING", "IN",P_UW_YEAR);
		OracleParameter param8 = new OracleParameter("IN OUT8", "STRING", "IN OUT",P_DOC_NO_FN);
		OracleParameter param9 = new OracleParameter("IN9", "STRING", "IN",P_BLOCK_NAME);
		OracleParameter param10 = new OracleParameter("IN10", "STRING", "IN",P_DUMMY_YN);
		OracleParameter param11 = new OracleParameter("IN11", "STRING", "IN",P_DATE);
		OracleParameter param12 = new OracleParameter("IN12", "STRING", "IN",P_CLAIM_TYPE);
		OracleParameter param13 = new OracleParameter("IN13", "STRING", "IN",P_REG_DATE);
		OracleParameter param14 = new OracleParameter("IN14", "STRING", "IN",P_ROWID);
		OracleParameter param15 = new OracleParameter("OUT15", "STRING", "OUT","");

		parameterList.add(param1);       parameterList.add(param2);       parameterList.add(param3);
		parameterList.add(param4);       parameterList.add(param5);       parameterList.add(param6);
		parameterList.add(param7);       parameterList.add(param8);       parameterList.add(param9);
		parameterList.add(param10);      parameterList.add(param11);      parameterList.add(param12);
		parameterList.add(param13);      parameterList.add(param14);      parameterList.add(param15);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,"PKG_PILT002.P_SET_DOC_NO_PROP");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			returnList.add(oracleParameter.getValue());
		}
		return returnList;
	}
	public void PCI_INTIMATION_MODE_when_validate(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception{
		DBProcedures procCall = new DBProcedures();
		String PCI_INTIMATION_MODE = claimsBean.getPCI_INTIMATION_MODE();
		String M_PCI_INTIMATION_MODE = null;
		ArrayList<String> stringValue = null;
		String M_PS_VALUE = null;
		try {
			if(PCI_INTIMATION_MODE == null){
				stringValue = procCall.callPCOPK_GENERAL_P_VAL_SYSTEM("IL_INTI_MODE", PCI_INTIMATION_MODE, M_PCI_INTIMATION_MODE, "N", M_PS_VALUE+"");
				if(stringValue!= null){
					claimsBean.setUI_M_PCI_INTIMATION_MODE(stringValue.get(0));
					claimsBean.setUI_M_PS_VALUE(stringValue.get(1));
				}
			}else{
				claimsBean.setPCI_INTIMATION_MODE(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void PCI_RES_AREA_CODE_when_validate(PT_IL_PRE_CLAIMS_INFO_ACTION claimsAction) throws Exception{
		DBProcedures procCall = new DBProcedures();
		ArrayList<String> stringValue = null;
		PT_IL_PRE_CLAIMS_INFO claimsBean = claimsAction.getPT_IL_PRE_CLAIMS_INFO_BEAN();
		String PCI_RES_AREA_CODE = (String) CommonUtils.getCurrentValue(claimsAction.getCOMP_PCI_RES_AREA_CODE());

		try {
			if(PCI_RES_AREA_CODE!= null){
				stringValue = procCall.helperPKG_PILT002$P_VAL_CODES("POSTAL", PCI_RES_AREA_CODE,claimsBean.getUI_M_RES_AREA_NAME(), "N", "E", null);
				if (stringValue != null) {
					claimsBean.setUI_M_RES_AREA_NAME(stringValue.get(0));
				}
			}else{
				claimsBean.setUI_M_RES_AREA_NAME(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					claimsAction.getCOMP_PCI_RES_AREA_CODE().getId(),  claimsAction.getWarningMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void PCI_CITY_CODE_when_validate(PT_IL_PRE_CLAIMS_INFO_ACTION claimsAction) throws Exception{
		DBProcedures procCall = new DBProcedures();
		ArrayList<String> stringValue = null;
		PT_IL_PRE_CLAIMS_INFO claimsBean = claimsAction.getPT_IL_PRE_CLAIMS_INFO_BEAN();
		String PCI_CITY_CODE = (String) CommonUtils.getCurrentValue(claimsAction.getCOMP_PCI_CITY_CODE());
		try {
			if(PCI_CITY_CODE!= null){
				stringValue = procCall.helperPKG_PILT002$P_VAL_CODES("CITY", PCI_CITY_CODE,claimsBean.getUI_M_PCI_CITY_NAME(), "N", "E", null);
				if (stringValue != null) {
					claimsBean.setUI_M_PCI_CITY_NAME(stringValue.get(0));
				}
			}else{
				claimsBean.setUI_M_PCI_CITY_NAME(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					claimsAction.getCOMP_PCI_CITY_CODE().getId(), claimsAction.getErrorMap(), claimsAction.getWarningMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
	}
	public void PCI_COUNTRY_CODE_when_validate(PT_IL_PRE_CLAIMS_INFO_ACTION claimsAction) throws Exception{
		DBProcedures procCall = new DBProcedures();
		ArrayList<String> stringValue = null;
		PT_IL_PRE_CLAIMS_INFO claimsBean = claimsAction.getPT_IL_PRE_CLAIMS_INFO_BEAN();
		String PCI_COUNTRY_CODE = (String) CommonUtils.getCurrentValue(claimsAction.getCOMP_PCI_COUNTRY_CODE());
		try {
			if(PCI_COUNTRY_CODE!= null){
				stringValue = procCall.helperPKG_PILT002$P_VAL_CODES("COUNTRY", PCI_COUNTRY_CODE,claimsBean.getUI_M_PCI_COUNTRY_CODE(), "N", "E", null);
				if (stringValue != null) {
					claimsBean.setUI_M_PCI_COUNTRY_CODE(stringValue.get(0));
				}
			}else{
				claimsBean.setUI_M_PCI_COUNTRY_CODE(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					claimsAction.getCOMP_PCI_COUNTRY_CODE().getId(), claimsAction.getErrorMap(), claimsAction.getWarningMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
	}
	public void PCI_STATE_CODE_when_validate(PT_IL_PRE_CLAIMS_INFO_ACTION claimsAction) throws Exception{
		DBProcedures procCall = new DBProcedures();
		ArrayList<String> stringValue = null;
		PT_IL_PRE_CLAIMS_INFO claimsBean = claimsAction.getPT_IL_PRE_CLAIMS_INFO_BEAN();
		String PCI_STATE_CODE = (String) CommonUtils.getCurrentValue(claimsAction.getCOMP_PCI_STATE_CODE());
		try {
			if(PCI_STATE_CODE!= null){
				stringValue = procCall.helperPKG_PILT002$P_VAL_CODES("STATE", PCI_STATE_CODE,claimsBean.getUI_M_PCI_STATE_CODE(), "N", "E", null);
				if (stringValue != null) {
					claimsBean.setUI_M_PCI_STATE_CODE(stringValue.get(0));
				}
			}else{
				claimsBean.setUI_M_PCI_STATE_CODE(null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(), FacesContext.getCurrentInstance(),
					claimsAction.getCOMP_PCI_STATE_CODE().getId(), claimsAction.getErrorMap(), claimsAction.getWarningMap());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} 
	}
	public Date getPolicyIssuedDate(String policyNo){
		Date issuedDate = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		String selectQuery = "select POL_ISSUE_DT from PT_IL_POLICY WHERE POL_NO  = ? ";
		Object[] values = { policyNo };
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if (rst.next()) {
					issuedDate = rst.getDate(1);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return issuedDate;
	}
	
	public Long getPolSysId(String polNo) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Long polSysid = null;
		String C1 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,new Object[]{polNo});
			if(resultSet.next()){
				polSysid = resultSet.getLong(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return polSysid;
	}
	
	public void L_CLAIM_ASSR_DESC(PT_IL_PRE_CLAIMS_INFO PT_IL_PRE_CLAIMS_INFO_BEAN)
			throws Exception {
		String selectQuery = "SELECT POAD_ASSURED_NAME "
				+ "FROM   PT_IL_POL_ASSURED_DTLS "
				+ "WHERE  POAD_POL_SYS_ID    = ? "
				+ "AND    POAD_ASSR_CODE     = ?";
		Long CLAIM_POL_SYS_ID = null;
		String assrCode = PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_ASSRD_CODE();
		CRUDHandler handler = new CRUDHandler();
		String POAD_ASSURED_NAME = null;
		ResultSet rst = null;
		try {
			CLAIM_POL_SYS_ID = getPolSysId(PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_POL_NO());
			rst = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection(),
					new Object[] { CLAIM_POL_SYS_ID, assrCode });
			while (rst.next()) {
				POAD_ASSURED_NAME = rst.getString("POAD_ASSURED_NAME");
			}
			PT_IL_PRE_CLAIMS_INFO_BEAN.setUI_M_PCI_ASSRD_NAME(POAD_ASSURED_NAME);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validAssuredCode(PT_IL_PRE_CLAIMS_INFO PT_IL_PRE_CLAIMS_INFO_BEAN) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		Long polSysId = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		ResultSet resultSet3 = null;
		boolean flag=false;
		String PCI_POL_NO = PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_POL_NO();
		String C1 = "SELECT POL_JOINT_LIFE_YN FROM PT_IL_POLICY WHERE POL_NO = ? ";
		
		String C2 = "SELECT * FROM PT_IL_PRE_CLAIMS_INFO WHERE PCI_POL_NO  = ? " +
		"AND EXISTS (SELECT 1 FROM PT_IL_POL_ASSURED_DTLS " +
		"WHERE POAD_POL_SYS_ID = ? AND POAD_ASSR_CODE  = ? " +
		"AND POAD_ASSR_CODE  = PCI_ASSRD_CODE) AND PCI_CLAIM_TYPE != 'O' ";
		
		/*Added by saritha on 05-10-2017 for ssp call id ZBLIFE-1445282*/
		String C3 ="SELECT 'X' FROM PT_IL_PRE_CLAIMS_INFO WHERE PCI_POL_NO = ? AND PCI_ASSRD_CODE=? ";
		/*End*/
		
		try {
			connection = CommonUtils.getConnection();
			polSysId = getPolSysId(PCI_POL_NO);
			String jointYN = null;
			resultSet1 = handler.executeSelectStatement(C1, connection,new Object[]{PCI_POL_NO});
			if(resultSet1.next()){
				jointYN = resultSet1.getString(1);
			}
			if((!(jointYN.isEmpty())) && null != jointYN){
				if("Y".equalsIgnoreCase(jointYN)){
					resultSet2 = handler.executeSelectStatement(C2, connection,new Object[]{PCI_POL_NO,polSysId,
							PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_ASSRD_CODE()});
					if(resultSet2.next()){
						throw new Exception("Claim Already registered for this assured");
					}
				}
				  	
			}
			
			/*Added by saritha on 05-10-2017 for ssp call id ZBLIFE-1445282*/
			resultSet3=handler.executeSelectStatement(C3, CommonUtils.getConnection(), 
					new Object[]{PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_POL_NO(),PT_IL_PRE_CLAIMS_INFO_BEAN.getPCI_ASSRD_CODE()});
			
			while(resultSet3.next())
			{
				flag=true;
			}
			if(flag)
			{
				throw new Exception("Already claim registered for this Member");
			}
			/*End*/			
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

	
	public void whenValidatePCI_TYPE(PT_IL_PRE_CLAIMS_INFO claimsBean,String value) throws Exception{
			
		String selectQuery4 = "SELECT 'X' FROM PM_IL_CLAIM_COVER WHERE CC_CLAIM_TYPE = ?"
				+ " AND EXISTS (SELECT '1' FROM PT_IL_POL_ADDL_COVER WHERE POAC_POL_SYS_ID = (SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ? )"
				+ " AND POAC_COVER_CODE = CC_COVER_CODE)";

		String M_CHAR = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			con = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(selectQuery4, con,
					new Object[] { value, claimsBean.getPCI_POL_NO() });

			if (rst.next()) {
				M_CHAR = rst.getString(1);
			}

			if (!("D".equalsIgnoreCase(value))) {

				if (!("X".equalsIgnoreCase(CommonUtils.nvl(M_CHAR, "Y")))) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "98401"));
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
	}
	// COMMENTED BY : SHANKAR BODDULURI [20-MAR-2009]
	/* public Date getSysdateDate(){
		Date issuedDate = null;
			Connection con = null;
			CRUDHandler handler = null;
			ResultSet rst = null;
			String selectQuery = "SELECT SYSDATE FROM DUAL ";
			try {
				con = CommonUtils.getConnection();
				if(con!= null){
					handler = new CRUDHandler();
					rst = handler.executeSelectStatement(selectQuery, con);
					if (rst.next()) {
						issuedDate = rst.getDate(1);
					}
				}
			} catch (DBException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return issuedDate;
	   }*/
	//select POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2,POL_NO from PT_IL_POLICY where POL_DS_TYPE ='2' AND (POL_ASSRD_REF_ID1=NVL(?,POL_ASSRD_REF_ID1) OR POL_ASSRD_REF_ID2=NVL(?,POL_ASSRD_REF_ID2))
	
	
	
	
	
	
	
	
	
	// added by sankara narayanan for ZBILQC-1720515 &	ZBILQC-1719141 on 16/03/2017
	
	public List<PT_IL_CLAIM> lovCustCode(FacesContext context, String CUST_CODE) {
		
		String selectQuery = "SELECT CUST_CODE,CUST_NAME,CUST_LONG_NAME,CUST_REF_ID1,CUST_ADDR1 FROM PT_IL_POLICY,PM_CUSTOMER "
						+ "WHERE CUST_CLASS IN ("
						+ "SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
						+ "WHERE DECODE (PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) "
						+ "IN ('001','002','003','004','005','006','009','020') "
						+ "AND PS_CODE ='CUSTOMER' AND PS_TYPE ='LOV_CUST') "
						+ "AND CUST_FRZ_FLAG = 'N' "
						+ "AND  (CUST_APPL_ALL_BRAN_YN = 'Y' OR CUST_CODE IN ("
						+ "SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
						+ "WHERE CDIV_DIVN_CODE = NVL ('YHW04', CDIV_DIVN_CODE))) "
						+ "AND UPPER(CUST_CODE) LIKE UPPER(NVL(?, CUST_CODE))"
						+ "AND POL_CUST_CODE = CUST_CODE "
						+ "AND POL_NO = ? AND ROWNUM<21";
						
		String CLAIM_POL_NO = CommonUtils.getGlobalVariable("GLOBAL.CLAIM_POL_NO");
	
		if (CUST_CODE != null)
			if (CUST_CODE.equals("*"))
				CUST_CODE = "%";
			else
				CUST_CODE += "%";
		CRUDHandler handler = new CRUDHandler();
		List<PT_IL_CLAIM> claimList = null;
		try {
			Connection connection = CommonUtils.getConnection();
			
		
			ResultSet rst = handler.executeSelectStatement(selectQuery,
					connection, new Object[] { CUST_CODE,CLAIM_POL_NO });
			
			PT_IL_CLAIM claimBean = null;
			claimList = new ArrayList<PT_IL_CLAIM>();
			while (rst.next()) {
				claimBean = new PT_IL_CLAIM();
				claimBean.setCLAIM_CUST_CODE(rst.getString(1));
				claimBean.setUI_M_CUST_DESC(rst.getString(2));
				claimBean.setCustFullName(rst.getString(3));
				claimBean.setCustICNO(rst.getString(4));
				claimBean.setCustAddress(rst.getString(5));

				claimList.add(claimBean);
			}
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return claimList;
	}
	
	
	
	//end
	
	
	/*Added by Janani on 25.05.2017 for ZBILQC-1727100*/
	
	 public void vaildateValues(String value)throws Exception{
			
		 System.out.println("enters into vaildateValues");
		 try {
			
			int length = value.length();
			String restricting_pattern = "\\d+";
			Pattern p = Pattern.compile(restricting_pattern);
			Matcher  m = p.matcher(value);
			
			System.out.println("value         :"+value);
			System.out.println("Pattern         :"+p);
			System.out.println("matcher         :"+m);
			
			if (!(m.matches())){
				System.out.println("WRFWQRRRRRRRR");
				throw new Exception("Value Should be Numeric. ");
			}
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
	
	/*End*/
	
	
	
}
