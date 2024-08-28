package com.iii.pel.forms.PILP006;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_PROCEDURE;
import com.iii.pel.forms.PILT007.PILT007_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_CLAIM_NO_LABEL;

	private HtmlInputText COMP_UI_M_CLAIM_NO;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_CLM_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_POL_LOV;

	private HtmlCommandButton PREFORMBUTTON;

	private DUMMY DUMMY_BEAN;

	private List<DUMMY_LOV_BEAN> suggestionList;

	Map<String, Object> session = null;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		PREFORMBUTTON = new HtmlCommandButton();
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_LABEL() {
		return COMP_UI_M_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_LABEL) {
		this.COMP_UI_M_POL_NO_LABEL = COMP_UI_M_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText COMP_UI_M_POL_NO) {
		this.COMP_UI_M_POL_NO = COMP_UI_M_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLAIM_NO_LABEL() {
		return COMP_UI_M_CLAIM_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLAIM_NO() {
		return COMP_UI_M_CLAIM_NO;
	}

	public void setCOMP_UI_M_CLAIM_NO_LABEL(
			HtmlOutputLabel COMP_UI_M_CLAIM_NO_LABEL) {
		this.COMP_UI_M_CLAIM_NO_LABEL = COMP_UI_M_CLAIM_NO_LABEL;
	}

	public void setCOMP_UI_M_CLAIM_NO(HtmlInputText COMP_UI_M_CLAIM_NO) {
		this.COMP_UI_M_CLAIM_NO = COMP_UI_M_CLAIM_NO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton COMP_UI_M_BUT_CANCEL) {
		this.COMP_UI_M_BUT_CANCEL = COMP_UI_M_BUT_CANCEL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CLM_LOV() {
		return COMP_UI_M_BUT_CLM_LOV;
	}

	public void setCOMP_UI_M_BUT_CLM_LOV(HtmlCommandButton COMP_UI_M_BUT_CLM_LOV) {
		this.COMP_UI_M_BUT_CLM_LOV = COMP_UI_M_BUT_CLM_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_LOV() {
		return COMP_UI_M_BUT_POL_LOV;
	}

	public void setCOMP_UI_M_BUT_POL_LOV(HtmlCommandButton COMP_UI_M_BUT_POL_LOV) {
		this.COMP_UI_M_BUT_POL_LOV = COMP_UI_M_BUT_POL_LOV;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public List<DUMMY_LOV_BEAN> getPolNoLov(Object obj) throws Exception {
		suggestionList = new ArrayList<DUMMY_LOV_BEAN>();
		getCOMP_UI_M_POL_NO().setSubmittedValue(null);
		String query = null;
		if (obj.toString().equals("*")) {
			query = "SELECT POL_NO FROM PT_IL_POLICY "
					+ "WHERE POL_NO IN (SELECT DISTINCT CLAIM_POL_NO FROM PT_IL_CLAIM WHERE NVL(CLAIM_CLOSE_FLAG,'N') = 'N' "
					+ "AND EXISTS (SELECT 'X' FROM PT_IL_CLAIM_PAID "
					+ " WHERE CP_CLAIM_SYS_ID = CLAIM_SYS_ID AND  CP_APPR_FLAG = 'R')) "
					+ "AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND ROWNUM<=50";
		} else {
			query = "SELECT POL_NO FROM PT_IL_POLICY "
					+ "WHERE POL_NO IN (SELECT DISTINCT CLAIM_POL_NO FROM PT_IL_CLAIM WHERE NVL(CLAIM_CLOSE_FLAG,'N') = 'N' "
					+ "AND EXISTS (SELECT 'X' FROM PT_IL_CLAIM_PAID "
					+ " WHERE CP_CLAIM_SYS_ID = CLAIM_SYS_ID AND  CP_APPR_FLAG = 'R')) "
					+ "AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND ROWNUM<=50 AND POL_NO LIKE '"
					+ obj.toString() + "%'";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The POL_NO is: " + rs.getString("POL_NO"));
			DUMMY_LOV_BEAN dummyBean = new DUMMY_LOV_BEAN();
			dummyBean.setPOL_NO(rs.getString("POL_NO"));
			suggestionList.add(dummyBean);
		}
		rs.close();
		return suggestionList;
	}

	public void polNoValueSet(ActionEvent ae) {
		System.out.println("The value entered: "
				+ getCOMP_UI_M_POL_NO().getSubmittedValue());
		getDUMMY_BEAN().setUI_M_POL_NO(
				getCOMP_UI_M_POL_NO().getSubmittedValue().toString());
	}

	public List<DUMMY_LOV_BEAN> getClaimNoLov(Object obj) throws Exception {
		suggestionList = new ArrayList<DUMMY_LOV_BEAN>();
		getCOMP_UI_M_POL_NO().setSubmittedValue(null);
		String query = null;
		System.out.println("The obj value is: " + obj.toString()
				+ " and policy number is: "
				+ getCOMP_UI_M_POL_NO().getSubmittedValue()
				+ " and from the bean is: " + getDUMMY_BEAN().getUI_M_POL_NO());
		if (obj.toString().equals("*")) {
			query = "SELECT CLAIM_NO, CLAIM_LOSS_DT FROM PT_IL_CLAIM "
					+ " WHERE CLAIM_POL_NO = '"
					+ getDUMMY_BEAN().getUI_M_POL_NO() + "'"
					+ "   AND NVL(CLAIM_CLOSE_FLAG,'N') = 'N' "
					+ "   AND ROWNUM<=50";
		} else {
			query = "SELECT CLAIM_NO, CLAIM_LOSS_DT FROM PT_IL_CLAIM "
					+ " WHERE CLAIM_POL_NO = '"
					+ getDUMMY_BEAN().getUI_M_POL_NO() + "'"
					+ "   AND NVL(CLAIM_CLOSE_FLAG,'N') = 'N' "
					+ "   AND ROWNUM<=50 AND CLAIM_NO LIKE '" + obj.toString()
					+ "%'";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,
				CommonUtils.getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			System.out.println("The CLAIM NO is: " + rs.getString("CLAIM_NO"));
			DUMMY_LOV_BEAN dummyBean = new DUMMY_LOV_BEAN();
			dummyBean.setCLAIM_NO(rs.getString("CLAIM_NO"));
			dummyBean.setCLAIM_LOSS_DT(rs.getDate("CLAIM_LOSS_DT"));
			suggestionList.add(dummyBean);
		}
		rs.close();
		return suggestionList;
	}

	public List<DUMMY_LOV_BEAN> getSuggestionList() {
		return suggestionList;
	}

	public void setSuggestionList(List<DUMMY_LOV_BEAN> suggestionList) {
		this.suggestionList = suggestionList;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public void preForm(PhaseEvent event) {
		if (isBlockFlag()) {
			session = getSessionMap();
			String callingForm = (String) session.get("CALLING_FORM");
			if (callingForm == null) {
				session.put("GLOBAL.M_FAILURE", "FALSE");
			}
			getDUMMY_BEAN().setUI_M_POL_NO(
					session.get("GLOBAL.POLICY_NO").toString());
			getDUMMY_BEAN().setUI_M_CLAIM_NO(
					session.get("GLOBAL.CLM_NO").toString());
			ControlBean ctrlbean = CommonUtils.getControlBean();
			String M_TITLE = ctrlbean.getM_USER_ID() + " "
					+ ctrlbean.getM_SCR_NAME() + " " + new Date();
			getPREFORMBUTTON().setDisabled(true);
			getCOMP_UI_M_POL_NO().setSubmittedValue(
					session.get("GLOBAL.POLICY_NO").toString());
			getCOMP_UI_M_CLAIM_NO().setSubmittedValue(
					session.get("GLOBAL.CLM_NO").toString());
			setBlockFlag(false);
		}
	}

	public void STD_PRE_FORM() {
	}

	public String whenOkButtonPressed() throws Exception {

		FacesContext ctx = FacesContext.getCurrentInstance();
		Object[] values = new Object[2];
		Object[] values1 = new Object[1];
		ResultSet rs = null;
		
		/*CHANGED BY RAJA ON 15-05-2017*/
		/*String query1 = "SELECT POL_SYS_ID,CLAIM_SYS_ID FROM PT_IL_POLICY,PT_IL_CLAIM WHERE POL_NO = ? "
				+ "AND CLAIM_POL_SYS_ID  = POL_SYS_ID AND CLAIM_NO = ?";*/
		
		String query1 = "SELECT POL_SYS_ID,CLAIM_SYS_ID,POL_PROD_CODE FROM PT_IL_POLICY,PT_IL_CLAIM WHERE POL_NO = ? "
				+ "AND CLAIM_POL_SYS_ID  = POL_SYS_ID AND CLAIM_NO = ?";
		String prod_code=null;
		/*END*/
		
		String query2 = "SELECT CP_CE_SYS_ID FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ?";
		String query3 = " SELECT SUM(NVL(CP_FC_PAID_AMT,0)),CE_FC_NET_EST_AMT " +
				" FROM PT_IL_CLAIM_PAID,PT_IL_CLAIM_ESTIMATE WHERE CP_CLAIM_SYS_ID = ? " +
				" AND CE_CLAIM_SYS_ID = ? AND CP_APPR_FLAG IN ('A','R') GROUP BY CE_FC_NET_EST_AMT " ; 
		String StatusQuery = "SELECT  'X' FROM   PT_IL_CLAIM_PAID WHERE  CP_CLAIM_SYS_ID = ? "
				+ "AND    CP_APPR_FLAG    IN ('Y','R') AND    CP_CLM_PAID_STATUS = 'A' ";
		values[0] = getDUMMY_BEAN().getUI_M_POL_NO();
		values[1] = getDUMMY_BEAN().getUI_M_CLAIM_NO();
		Long CLAIM_SYS_ID = null;
		ResultSet resultSet = null;
		ResultSet rs3 = null;
		Double TotalEstimateAmt = null;
		Double TotalPaidAmt = null;
		try {
			CLAIM_SYS_ID = (Long) getSessionMap().get("GLOBAL.CLAIM_SYS_ID");
			rs = getHandler().executeSelectStatement(query1,
					CommonUtils.getConnection(), values);
			while (rs.next()) {
				getDUMMY_BEAN().setPOL_SYS_ID(rs.getLong("POL_SYS_ID"));
				getDUMMY_BEAN().setCLAIM_SYS_ID(rs.getLong("CLAIM_SYS_ID"));
				/*added BY RAJA ON 15-05-2017*/
				prod_code=rs.getString("POL_PROD_CODE");
				/*end*/
			}

			CommonUtils.closeCursor(rs);
			values1[0] = getDUMMY_BEAN().getCLAIM_SYS_ID();

			if (getSessionMap().get("GLOBAL.CP_CE_SYS_ID") == null) {
				rs = getHandler().executeSelectStatement(query2,
						CommonUtils.getConnection(), values1);
				while (rs.next()) {
					getSessionMap().put("GLOBAL.CP_CE_SYS_ID",
							rs.getLong("CP_CE_SYS_ID"));
				}
			}
			CommonUtils.closeCursor(rs);

			P_CLAIM_BEGIN(
					(Long) getSessionMap().get("GLOBAL.CLAIM_SYS_ID"),
					getDUMMY_BEAN().getPOL_SYS_ID(),
					(String) getSessionMap().get("GLOBAL.POLICY_NO"),
					(String) getSessionMap().get("GLOBAL.CLM_NO"),
					(Long) getSessionMap().get("GLOBAL.CP_CE_SYS_ID")
					/*(Long)CommonUtils.getGlobalObject("GLOBAL.CP_CE_SYS_ID")*/,
					new CommonUtils().getCurrentDate());
			CommonUtils.getConnection().commit();
			/*
			 * newly added for partial settlement
			 */
			rs3 = new CRUDHandler().executeSelectStatement(query3,CommonUtils.getConnection(),
					new Object[]{getDUMMY_BEAN().getCLAIM_SYS_ID(),getDUMMY_BEAN().getCLAIM_SYS_ID()});
			if(rs3.next()){
				TotalEstimateAmt = rs3.getDouble(1);
				TotalPaidAmt = rs3.getDouble(2);
			}
			if(TotalPaidAmt != null && TotalEstimateAmt != null){
			if(TotalEstimateAmt.equals(TotalPaidAmt)){ //ended
			resultSet = new CRUDHandler().executeSelectStatement(StatusQuery,
					CommonUtils.getConnection(), new Object[] { CLAIM_SYS_ID });
			if (resultSet.next()) {
				if ("X".equals(resultSet.getString(1))) {
					new PILT006_APAC_PROCEDURE().P_INSERT_CLAIM_STATUS(
							CLAIM_SYS_ID, "C", new Date(), "Closed", null);
				}
			}
			}
			}
			
			/*commented by raja on 16-05-2017*/
			emailStatusMsg(prod_code,"RISR",getDUMMY_BEAN().getPOL_SYS_ID().toString(),"RS","",getDUMMY_BEAN().getCLAIM_SYS_ID().toString());
			/*end*/
			
			CommonUtils.getConnection().commit();
			/*
			 * getWarningMap().put("current",
			 * Messages.getString(PELConstants.pelErrorMessagePath, "71178"));
			 * PILT007_COMPOSITE_ACTION pilt007CompositeAction =
			 * (PILT007_COMPOSITE_ACTION)CommonUtils.getGlobalObject("PILT007_COMPOSITE_ACTION");
			 * PT_IL_CLAIM_ACTION claimAction =
			 * pilt007CompositeAction.getPILT007_PT_IL_CLAIM_ACTION();
			 * claimAction.getCOMP_UI_M_BUT_PV().setDisabled(false);
			 * claimAction.setBlockFlag(false); new
			 * DUMMY_HELPER().claimsSettlement(pilt007CompositeAction);
			 */

			PILT007_COMPOSITE_ACTION compositeAction = (PILT007_COMPOSITE_ACTION) CommonUtils
					.getGlobalObject("PILT007_COMPOSITE_ACTION");

			// compositeAction.getPT_IL_CLAIM_ACTION_BEAN().setFormFlag(false);
			compositeAction.getPILT007_PT_IL_CLAIM_ACTION().setBlockFlag(true);
			compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getWarningMap()
					.put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelErrorMessagePath, "71178"));
			compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getWarningMap()
					.put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelErrorMessagePath, "71178"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("current", e.getMessage());
			return null;
			/*setErrorMessages(e.getMessage());
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils
					.getConnection(), ctx, getCOMP_UI_M_BUT_OK().getClientId(
					FacesContext.getCurrentInstance()), getErrorMap(),
					getWarningMap());*/
			
			
		}
		return "ClaimsSettlement";
	}

	/**
	 * 
	 * @param P_CLM_SYS_ID-IN
	 * @param P_POL_SYS_ID-IN
	 * @param P_POL_NO-IN
	 * @param P_CLAIM_NO-IN
	 * @param P_CE_SYS_ID-IN
	 * @param P_AS_ON_DT-IN
	 * 
	 * @return ArrayList of type Oracle Parameter
	 * @throws Exception
	 */
	public ArrayList<OracleParameter> P_CLAIM_BEGIN(Object P_CLM_SYS_ID,
			Object P_POL_SYS_ID, Object P_POL_NO, Object P_CLAIM_NO,
			Object P_CE_SYS_ID, Object P_AS_ON_DT) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		try {

			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CLM_SYS_ID);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_POL_NO);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_CLAIM_NO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_CE_SYS_ID);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_AS_ON_DT);
			parameterList.add(param6);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_CLAIM_APPROVAL.P_CLAIM_BEGIN");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			/*ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
					ctx, getCOMP_UI_M_BUT_OK().getClientId(
							FacesContext.getCurrentInstance()), getErrorMap(),
					getWarningMap());*/
			 throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	public Map<String, Object> getSessionMap() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public HtmlCommandButton getPREFORMBUTTON() {
		return PREFORMBUTTON;
	}

	public void setPREFORMBUTTON(HtmlCommandButton preformbutton) {
		PREFORMBUTTON = preformbutton;
	}

	public String whenCancelButtonPressed() {
		System.out.println("I am in cancel button");
		return "PILT007";
	}
	

	 
	 /*ADDED BY RAJA ON 5-05-2017*/
	 public static String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH,String P_CLAIM_SYS_ID, Connection con) throws Exception{
			
			/*Connection con=CommonUtils.getConnection();*/
			System.out.println("P_MAIL_TYPE-->"+P_MAIL_TYPE);
			String out="";
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_PROD_CODE);
			  parameterList.add(param1); 
			OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_MAIL_TYPE);
			  parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",P_POL_SYS_ID);
			  parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", "STRING", "IN",P_CUST_TYPE);
			  parameterList.add(param4);
			  OracleParameter param5 = new OracleParameter("IN5", "STRING", "IN",P_MAIL_PATH);
			  parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("OUT1", "STRING", "OUT",out);
		    parameterList.add(param6);
		    OracleParameter param7 = new OracleParameter("IN6", "STRING", "IN",P_CLAIM_SYS_ID);
			  parameterList.add(param7);
		    OracleProcedureHandler procHandler = new OracleProcedureHandler();
		    outputList = procHandler.execute(parameterList, con,
		            "P_MAIL_TEMP");
		    /*con.commit() Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		    /* CommonUtils.doComitt();*/
		    con.commit();
		   /* End*/
		    Iterator<OracleParameter> iterator = outputList.iterator();
		    while (iterator.hasNext()) {
		        OracleParameter oracleParameter = iterator.next();
		        System.out.println("Output value:::" + oracleParameter.getValue());
				out=(String)oracleParameter.getValue();
		    }
			return out;
			}
	    public String emailStatusMsg(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH, String CLAIM_SYS_ID) throws Exception
	    {
	    	StringBuilder statusMessge =  new StringBuilder(" - ");
	    	/*Modified by Saranya RM018T - FSD_IL_ZB Life_016-Queried Proposals v1 on 27-12-2016*/
	    	/*Handled null exception on 07-07-2017, ZBILQC-1730660*/
	    	String mailFlag = CommonUtils.nvl(emailTriggerProcCall(P_PROD_CODE, P_MAIL_TYPE, P_POL_SYS_ID, P_CUST_TYPE, P_MAIL_PATH,CLAIM_SYS_ID, CommonUtils.getConnection()),"N");
	    	/*END*/
	    	/*End*/
	    	System.out.println("Mail status Flag--->["+mailFlag+"]--- P_CUST_TYPE ["+P_CUST_TYPE+"]");
	    	
	    	if((P_CUST_TYPE.equalsIgnoreCase("B"))){
	    		
	    		if(mailFlag.equals("YY")){
	    			
	    			statusMessge.append("Mail sent sucessfully");
	    			
	    		}else if(mailFlag.equals("T")){
	    			
	    			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));
	    		    			
	    		}else if(mailFlag.equalsIgnoreCase("NN")){
	    			
	    			statusMessge.append("Unable to send the email due to the unavailability of both Customer and Agent email id");
	    				
	    		}else if(mailFlag.equalsIgnoreCase("NY")){
	    			
	    			statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
	    				
	    		}else if(mailFlag.equalsIgnoreCase("YN")){
	    			
	    			statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
	    				
	    		}
	    		
	    	}else{
	    		
	    		if(mailFlag.equals("Y")){
	    			
	    			statusMessge.append("Mail sent sucessfully");
	    			
	    		}else if(mailFlag.equals("T")){
	    			
	    			statusMessge.append("Email template is unavailable in master setup "+templateDescription(P_MAIL_TYPE));
	    		    			
	    		}else {
	    			
	    			if(P_CUST_TYPE.equalsIgnoreCase("C")){
	    				statusMessge.append("Unable to send the email due to the unavailability of Customer email id");
	    			}else if(P_CUST_TYPE.equalsIgnoreCase("A")){
	    				statusMessge.append("Unable to send the email due to the unavailability of Agent email id");
	    			}
	    			
	    		}
	  		
	    		
	    	}
	    	
	    	
	    	return statusMessge.toString();   
	    	
	    	
	    	
	    }
	    
	    private static String templateDescription(String templateCode){
	    	
	    	String selectTemplateDescQuery = "SELECT initcap(LIV_CODE_DESC) FROM PP_LIST_ITEM_VALUES WHERE LIV_CODE = ?";
	    	StringBuilder selectTemplateDesc = null;
	    	CRUDHandler handler =  new CRUDHandler();
	    	Connection con = null;
	    			
	    	try {
	    		con = CommonUtils.getConnection();
	    		selectTemplateDesc = new StringBuilder(""); 
				ResultSet rs1=handler.executeSelectStatement(selectTemplateDescQuery, con, new Object[]{templateCode});
				if(rs1.next()){
					selectTemplateDesc.append("for ").append(rs1.getString(1));
					
				}
				System.out.println("Template Description --->["+selectTemplateDesc+"]");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	return selectTemplateDesc.toString();
	    }

	 /*END*/

}
