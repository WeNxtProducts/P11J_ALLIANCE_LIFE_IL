package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.LIFELIB;
import com.iii.pel.utils.P9ILPK_POLICY;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;



public class COPY_HELPER {
    
    public  void  WHEN_CREATE_RECORD(COPY copyBean,COPY_ACTION copy_action) {
	 
	CommonUtils commonUtils = new CommonUtils();
	try {
	copyBean.setUI_M_COPY_PT_IL_POL_ASS_DTL("N");
	copyBean.setUI_M_COPY_PT_IL_POL_ADDL_COVER("N");
	copyBean.setUI_M_COPY_PT_IL_POL_DISC_LOAD("N");
	copyBean.setUI_M_COPY_PT_IL_POL_CHARGE("N");
	copyBean.setUI_M_COPY_PT_IL_POL_BROKER("N");
	copyBean.setUI_M_COPY_PT_IL_POL_BENEF_DTL("N");
	copyBean.setUI_M_COPY_PT_IL_MED_HIST("N");
	copyBean.setUI_M_COPY_PT_IL_CHECK_LIST("N");
	copyBean.setUI_M_COPY_PT_IL_POL_COND("N");
	copyBean.setUI_M_POL_NEW_YN("N");
	copyBean.setUI_SEL_ALL("N");
	    copyBean.setUI_M_COPY_POL_ISSUE_DT(commonUtils.getCurrentDate());
	} catch (ParseException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	copy_action.getCOMP_UI_M_COPY_POL_ISSUE_DT().setDisabled( false);
    }
    
    public String  UI_M_BUT_COPY_WHEN_BUTTON_PRESSED(
		PILT002_APAC_COMPOSITE_ACTION copmAction) throws Exception {
	    
	COPY_ACTION   copy_action = copmAction.getCOPY_ACTION_BEAN();
	PT_IL_POLICY policyBean = copmAction.getPT_IL_POLICY_ACTION_BEAN()
			.getPT_IL_POLICY_BEAN();
	String outcome=null;
	try{
	   /*if( policyBean.getROWID()!=null) {
	       throw new Exception(
			Messages.getString(
					PELConstants.pelErrorMessagePath,
					"71048",
					new Object[] {
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));
	       
	    } */
	  
		if ("1".equals(policyBean.getPOL_DS_TYPE())) {
		    if(!"Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(0,1)) ||
			    !"Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1,2))){
		   
				throw new  Exception( Messages
						.getString(PELConstants.pelErrorMessagePath,
								"91498",  
				 new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"Copy Proposal"  })); 
			}
			  copy_action.getCOMP_UI_M_COPY_POL_NO_LABEL().setValue("PROPOSAL NO.");
		} else {
		    if(!"Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(0,1)) ||
			    !"Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1,2))){
		   
				 
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath,
								"91498")));
			}
		  copy_action.getCOMP_UI_M_COPY_POL_NO_LABEL().setValue("POLICY NO.");
		}

		// TODO needs to verify the copy
		// GO_BLOCK.GO_BLOCK("COPY");
		
	 
	}
	catch (Exception e) {
	    e.printStackTrace();// TODO: handle exception
	}	
	outcome ="PILT002_APAC_COPY";
	return outcome;
}
    
    public String  UI_M_COPY_OK_WHEN_BUTTON_PRESSED(
		PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
	PT_IL_POLICY_ACTION policyAction = compositeAction
			.getPT_IL_POLICY_ACTION_BEAN();
	PT_IL_POLICY policyBean = policyAction.getPT_IL_POLICY_BEAN();
	COPY copyBean = compositeAction.getCOPY_ACTION_BEAN().getCOPY_BEAN();
	String M_NEW_POL_SYS_ID = null;
	String outcome = null;
	Connection connection = null;
	String polNo = copyBean.getUI_M_COPY_POL_NO();
	if (polNo == null) {
		polNo = "";
	}
	try {
		connection = CommonUtils.getConnection();
		//Automatic policy number generating method
		UI_M_BUT_DOC_GEN_NO_WHEN_BUTTON_PRESSED(compositeAction);
		
		ArrayList<OracleParameter> list = new P9ILPK_POLICY().COPY_POLICY(
			CommonUtils.getProcedureValue(
				policyBean.getPOL_SYS_ID()) ,
				copyBean.getUI_M_COPY_POL_NO(), 
				CommonUtils.getProcedureValue(policyBean.getPOL_END_NO_IDX()) , 
				CommonUtils.getProcedureValue(	copyBean.getUI_M_POL_NEW_YN()), 
				CommonUtils.getProcedureValue(	copyBean.getUI_M_COPY_PT_IL_POL_ASS_DTL()), 
                        CommonUtils.getProcedureValue(	copyBean.getUI_M_COPY_PT_IL_POL_ADDL_COVER()), 
                        CommonUtils.getProcedureValue(	copyBean.getUI_M_COPY_PT_IL_POL_CHARGE()), 
                        CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_PT_IL_POL_BROKER()), 
                        CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_PT_IL_POL_DISC_LOAD()), 
                        CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_PT_IL_POL_BENEF_DTL()),
                        CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_PT_IL_CHECK_LIST()), 
                        CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_PT_IL_POL_COND()),
                        CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_PT_IL_MED_HIST()), 
                        CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_UW_YEAR()),
				CommonUtils.getDateAsStringForOracleProcedureCall(copyBean
						.getUI_M_COPY_POL_ISSUE_DT()), "C",
						M_NEW_POL_SYS_ID,CommonUtils.getProcedureValue(copyBean.getUI_M_COPY_PT_IL_POL_ADDL_COVER()));
			if(!(list.isEmpty()) && list != null){
				if(list.get(0) != null){
					M_NEW_POL_SYS_ID = (String)list.get(0).getValueObject();
				}
			}
		/* throw new Exception(
				Messages.getString(
						PELConstants.pelErrorMessagePath,
						"91040",
						new Object[] {
							CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));
	*/
		  
		CommonUtils.setGlobalObject("GLOBAL.M_GLOBAL_POL_SYS_ID",
				String.valueOf(M_NEW_POL_SYS_ID));

		outcome = "PILT002_APAC_PT_IL_POLICY";
	   
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_SYS_ID", CommonUtils
				.getGlobalVariable("GLOBAL.M_GLOBAL_POL_SYS_ID"));
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_COPY", "Y");
		 new PT_IL_POLICY_HELPER().executeQuery(compositeAction);
		 
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (ValidatorException e) {
		e.printStackTrace();
		throw e;
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {

		/*
		 * ErrorHelpUtil.getErrorsAndWarningforProcedure(connection,
		 * FacesContext.getCurrentInstance(),
		 * compAction.getCOPY_ACTION_BEAN().getCOMP_UI_M_COPY_OK().getId(),
		 * compAction.getCOPY_ACTION_BEAN().getWarningMap());
		 */

		ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
				FacesContext.getCurrentInstance(), compositeAction
						.getCOPY_ACTION_BEAN().getCOMP_UI_M_COPY_OK()
						.getId(), compositeAction.getCOPY_ACTION_BEAN()
						.getErrorMap(), compositeAction.getCOPY_ACTION_BEAN()
						.getWarningMap());

	}
	// rest implemented in calling method
	return outcome;
}


    public void UI_M_POL_NEW_YN_WHEN_VALIDATE_ITEM(
		COPY_ACTION copyAction, String currValue) throws Exception {
	COPY copyBean = copyAction.getCOPY_BEAN();
	try{
	if ("E".equals(currValue)) {
		copyAction.getCOMP_UI_M_COPY_POL_ISSUE_DT().setDisabled(true);
		copyAction.getCOMP_UI_M_COPY_POL_NO().setDisabled(false);
		
		/*
		 if("Y".equals(StringFunctions.substr(MigratingFunctions.nvl(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),""),2,1))) {
		 copyAction.getCOMP_UI_M_COPY_POL_NO().setReadonly(true); }
		 */
		 if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1,2))){
		
		    copyAction.getCOMP_UI_M_COPY_POL_NO().setDisabled(false);
			// copyAction.getCOMP_UI_M_COPY_POL_ISSUE_DT().setDisabled(true);
			// copyAction.getCOMP_UI_M_COPY_POL_NO().setReadonly(true);
		}
		 copyBean.setUI_M_COPY_POL_NO(null);
	} else {
		copyBean.setUI_M_COPY_POL_NO(null);
		//Added for PREMIAGDC-277598]
		copyAction.getCOMP_UI_M_COPY_POL_ISSUE_DT().setDisabled(false);
		 if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1,2))){
		     copyAction.getCOMP_UI_M_COPY_POL_ISSUE_DT().setDisabled(false);
		 }
       
		// copyAction.getCOMP_UI_M_COPY_POL_ISSUE_DT().setDisabled(true);
		copyAction.getCOMP_UI_M_COPY_POL_ISSUE_DT().setRequired(true);
		copyAction.getCOMP_UI_M_COPY_POL_ISSUE_DT().validate(
				FacesContext.getCurrentInstance());
	}
		} catch (Exception e) {
		    // TODO: handle exception
		    e.printStackTrace();
		}
    }

    public void  UI_M_COPY_POL_ISSUE_DT_WHEN_VALIDATE_ITEM(COPY_ACTION copyAction,PT_IL_POLICY policyBean	) throws Exception {
	CommonUtils commonUtils = new CommonUtils();
	Connection conn = null;
	Integer M_UW_YEAR = 0;
	ResultSet vembu_C1 = null;
	CRUDHandler handler = new CRUDHandler();
	COPY copyBean = copyAction.getCOPY_BEAN();
	String P_DISABLE_YN = null;
	String M_POL_PROP_NO = null;
	ArrayList<String> pvalList =null;
	ArrayList<OracleParameter> pvalOrclList =null;
	try {
		conn = CommonUtils.getConnection();
		String selectQuery = "SELECT PT_UW_YEAR FROM  PM_IL_PROP_TREATY  WHERE  "
				+ " ? BETWEEN PT_START_DT AND PT_END_DT AND PT_CLASS_CODE  = ?";
		Object[] values = { copyBean.getUI_M_COPY_POL_ISSUE_DT(),
				policyBean.getPOL_CLASS_CODE() };
		if (copyBean.getUI_M_COPY_POL_ISSUE_DT() != null) {

			if (copyBean.getUI_M_COPY_POL_ISSUE_DT().after(
					commonUtils.getCurrentDate())) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71030"));
			}

			vembu_C1 = handler.executeSelectStatement(selectQuery, conn,
					values);
			
			if (vembu_C1.next()) {
				M_UW_YEAR = vembu_C1.getInt(1);
				copyBean.setUI_M_COPY_UW_YEAR(M_UW_YEAR);
				
				if ("N".equals(copyBean.getUI_M_POL_NEW_YN())) {
					pvalOrclList = new ArrayList<OracleParameter>();
					pvalOrclList =  new PKG_PILT002_APAC().P_SET_DOC_NO_PROP(policyBean.getPOL_DS_TYPE(),
	                		      commonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"),
	                		      policyBean.getPOL_DIVN_CODE(), policyBean
						.getPOL_CLASS_CODE(),
						policyBean
						.getPOL_PLAN_CODE(), policyBean
						.getPOL_PROD_CODE(),
						 copyBean.getUI_M_COPY_UW_YEAR(),
	                		      null,
	                		      "COPY",
	                		      "Y",  copyBean.getUI_M_COPY_POL_ISSUE_DT(),
						null,null,policyBean.getROWID(),P_DISABLE_YN);
				 if(!pvalOrclList.isEmpty()){
				     copyBean.setUI_M_COPY_POL_NO((String)pvalOrclList.get(0).getValueObject());
				     P_DISABLE_YN = (String)pvalOrclList.get(1).getValueObject();
				 }
					
				}
			} else {
				// TODO needs to verify the resource bundle
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71171"));
			}
		}
	}  catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		CommonUtils.closeCursor(vembu_C1);
	}
}

    public void  UI_M_COPY_PT_IL_POL_ASS_DTL_WHEN_VALIDATE_ITEM(
		COPY_ACTION copyAction,String currValue) throws Exception {
	
	COPY copyBean = copyAction.getCOPY_BEAN();
	try{
	if ("Y".equals(copyBean.getUI_M_COPY_PT_IL_POL_ASS_DTL())) {
		copyAction.getCOMP_UI_M_COPY_PT_IL_POL_ADDL_COVER().setDisabled( false);
		 if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1,2))){
			copyAction.getCOMP_UI_M_COPY_PT_IL_POL_ADDL_COVER()
					.setDisabled(false);
		}
		copyAction.getCOMP_UI_M_COPY_PT_IL_MED_HIST().setDisabled(false);
		 if("Y".equals( CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE").substring(1,2))){
			copyAction.getCOMP_UI_M_COPY_PT_IL_MED_HIST()
					.setDisabled(false);
		}
	} else {
		 
		copyBean.setUI_M_COPY_PT_IL_MED_HIST("N");
		copyBean.setUI_M_COPY_PT_IL_POL_ADDL_COVER("N");
		copyAction.getCOMP_UI_M_COPY_PT_IL_POL_ADDL_COVER().setDisabled( true);
		copyAction.getCOMP_UI_M_COPY_PT_IL_MED_HIST().setDisabled(true);
	}
	} catch (Exception e) {
	    // TODO: handle exception
	    e.printStackTrace();
	}
    }
    
    public void IL_UNIQUE_COPY_POL_NO(String UI_M_COPY_POL_NO) throws Exception {
	Connection conn = null;
	ResultSet vembu_C1 = null;
	CRUDHandler handler = new CRUDHandler();
	String M_POL_NO = null;
	String query = "SELECT 1 FROM  PT_IL_POLICY  WHERE  POL_NO  = ?";// :COPY.M_COPY_POL_NO
	// ";
	Object[] values = { UI_M_COPY_POL_NO };

	try {
		conn = CommonUtils.getConnection();
		vembu_C1 = handler.executeSelectStatement(query, conn, values);
		if (vembu_C1.next()) {
			M_POL_NO = vembu_C1.getString(1);
		}
		if (vembu_C1.next()) {
			 
			throw new ValidatorException(new FacesMessage(Messages
					.getString(PELConstants.pelErrorMessagePath, "71031")));
		}
	} catch (ValidatorException e) {
		e.printStackTrace();
		throw e;
	} finally {
		CommonUtils.closeCursor(vembu_C1);
	}
    }
 
    public void  UI_M_COPY_POL_NO_WHEN_VALIDATE_ITEM(COPY copyBean,String curValue) throws Exception {
	CommonUtils commonUtils = new CommonUtils();
	Connection conn = null;
	 
	ResultSet vembu_C1 = null;
	String M_POL_APPRV_STATUS = null;
	String M_POL_STATUS = null;
	CRUDHandler handler = new CRUDHandler();
	String query = "SELECT POL_ISSUE_DT, POL_APPRV_STATUS, POL_STATUS "
			+ "FROM  PT_IL_POLICY  WHERE  POL_NO  = ?";


	try {
		conn = CommonUtils.getConnection();
		Object[] values = { curValue};
		if ("N".equals(copyBean.getUI_M_POL_NEW_YN())) {
			IL_UNIQUE_COPY_POL_NO(curValue);
		} else {
			vembu_C1 = handler.executeSelectStatement(query, conn, values);
			if (vembu_C1.next()) {
				M_POL_APPRV_STATUS = vembu_C1.getString(2);
				M_POL_STATUS = vembu_C1.getString(3);
			}
			if (vembu_C1.next()) {
				if ("A".equals(M_POL_APPRV_STATUS)
						|| "A".equals(M_POL_STATUS)) {
					// TODO needs to verify the resource bundle
					throw new ValidatorException(new FacesMessage(Messages
							.getString(PELConstants.pelErrorMessagePath,
									"91014")));
				}
			} else {
				// TODO needs to verify the resource bundle
				throw new ValidatorException(new FacesMessage(Messages
						.getString(PELConstants.pelErrorMessagePath,
								"80209")));
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (DBException e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} catch (ValidatorException e) {
		e.printStackTrace();
		throw e;
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception(e.getMessage());
	} finally {
		CommonUtils.closeCursor(vembu_C1);
	}
}
    
    public void UI_M_BUT_DOC_GEN_NO_WHEN_BUTTON_PRESSED(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
    	PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
    	DUMMY_ACTION dummy_action = compositeAction.getDUMMY_ACTION_BEAN();
    	COPY COPY_BEAN = compositeAction.getCOPY_ACTION_BEAN().getCOPY_BEAN();
		LIFELIB lifelib = new LIFELIB();
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		
		try {
			/*if (pt_il_policy_bean.getPOL_END_NO_IDX() != null
					&& pt_il_policy_bean.getPOL_END_NO_IDX() > 0) {

				pValList = lifelib.P_GEN_DOC_NO("3", pt_il_policy_bean
						.getPOL_END_CODE(), pt_il_policy_bean
						.getPOL_DIVN_CODE(), pt_il_policy_bean
						.getPOL_CLASS_CODE(), pt_il_policy_bean
						.getPOL_PLAN_CODE(), pt_il_policy_bean
						.getPOL_PROD_CODE(), CommonUtils
						.getProcedureValue(CommonUtils
								.getYearFromDate(pt_il_policy_bean
										.getPOL_END_DT())),
						"PT_IL_POLICY.POL_END_NO", "PT_IL_POLICY", "N",
						CommonUtils.getProcedureValue(pt_il_policy_bean
								.getPOL_END_DT()), null, null);
				if (!pValList.isEmpty()) {
					pt_il_policy_bean.setPOL_END_NO(pValList.get(0).getValue());
				}

				dummy_bean.setUI_M_END_IDX_TYPE_NO(pt_il_policy_bean
						.getPOL_END_NO_IDX()
						+ "-"
						+ pt_il_policy_bean.getPOL_END_TYPE()
						+ "-"
						+ pt_il_policy_bean.getPOL_END_NO());
			} else {*/
				if ("1".equals(pt_il_policy_bean.getPOL_DS_TYPE())) {

					pValList = new ArrayList<OracleParameter>();
					pValList = lifelib.P_GEN_DOC_NO("1", CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"),
							pt_il_policy_bean.getPOL_DIVN_CODE(),
							pt_il_policy_bean.getPOL_CLASS_CODE(),
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_policy_bean.getPOL_PROD_CODE(), CommonUtils
									.getProcedureValue(COPY_BEAN
											.getUI_M_COPY_UW_YEAR()),
							"PT_IL_POLICY.POL_NO", "PT_IL_POLICY", "N",
							CommonUtils.getProcedureValue(COPY_BEAN
									.getUI_M_COPY_POL_ISSUE_DT()), null, null,
									
									 /*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
									CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
									/*End*/
									
							);
					if (!pValList.isEmpty()) {
						COPY_BEAN.setUI_M_COPY_POL_NO(pValList.get(0).getValue());
					}
				} else {
					pValList = new ArrayList<OracleParameter>();
					pValList = lifelib.P_GEN_DOC_NO("2", CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"),
							pt_il_policy_bean.getPOL_DIVN_CODE(),
							pt_il_policy_bean.getPOL_CLASS_CODE(),
							pt_il_policy_bean.getPOL_PLAN_CODE(),
							pt_il_policy_bean.getPOL_PROD_CODE(), CommonUtils
									.getProcedureValue(COPY_BEAN
											.getUI_M_COPY_UW_YEAR()),
							"PT_IL_POLICY.POL_NO", "PT_IL_POLICY", "N",
							CommonUtils.getProcedureValue(COPY_BEAN
									.getUI_M_COPY_POL_ISSUE_DT()), null, null,
									/*Added by Janani on 21.05.2018 for Fidelity endorsement setup issue*/
									CommonUtils.nvl(pt_il_policy_bean.getPOL_NO(), null)
									/*End*/		
							);
					if (!pValList.isEmpty()) {
						COPY_BEAN.setUI_M_COPY_POL_NO(pValList.get(0).getValue());
					}
				}
			/*
			 * Start - Code Modified By A.SubbuLakshmi with reference to
			 * PRIL-IMPALY-007-TISB4
			 */
			// GO_ITEM('PT_IL_POLICY.POL_PROD_CODE');
			/*
			 * End - Code Modified By A.SubbuLakshmi with reference to
			 * PRIL-IMPALY-007-TISB4
			 */

			dummy_action.getCOMP_UI_M_BUT_DOC_GEN_NO().setDisabled(true);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

    
}
