package com.iii.pel.forms.PILP014_A;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.P9ILPK_ENDORSE;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction implements SQLQueryInterface {

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_PROCESS_TYPE;
	
	private HtmlInputText COMP_UI_M_POL_NO_FM;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_PROCESS_DT;

	private HtmlOutputLabel COMP_UI_M_PROCESS_TYPE_LABEL;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton test;
	
	private HtmlOutputText COMP_UI_TEXT;
	
	List<SelectItem> UI_M_PROCESS_TYPE_LIST = new ArrayList<SelectItem>(); 
	
	int ROWCOUNT;
	
	HttpSession session = null; 
	
	
	
	
	
	FacesContext ctx= FacesContext.getCurrentInstance();
	
	
	
	private DUMMY DUMMY_BEAN;
	private String  M_CALC_METHOD;
	private String P_CODE_DESC;
	private String P_VALUE;
	private String M_NAME;
	private String M_BL_NAME;
	private String M_VALUE;
	private String M_PROCESS_TYPE;
	
	private ResultSet resultSet=null;
	CommonUtils commonUtils = new CommonUtils();
	public String getP_CODE_DESC() {
		return P_CODE_DESC;
	}

	public void setP_CODE_DESC(String p_code_desc) {
		P_CODE_DESC = p_code_desc;
	}

	public String getP_VALUE() {
		return P_VALUE;
	}

	public void setP_VALUE(String p_value) {
		P_VALUE = p_value;
	}
	
	CRUDHandler handler = null;
	Connection connection =  null;
	
	
	public DUMMY_ACTION() {
		try {
			DUMMY_BEAN = new DUMMY();
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			UI_M_PROCESS_TYPE_LIST = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(),"PILP014_A","DUMMY","DUMMY.M_PROCESS_TYPE","PROSTYP");
			UI_M_MED_FEE_YN_LIST = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(),"PILP014_A","DUMMY","DUMMY.UI_M_MED_FEE_YN","YESNO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL) {
		this.COMP_UI_M_POL_NO_FM_LABEL = COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText COMP_UI_M_POL_NO_FM) {
		this.COMP_UI_M_POL_NO_FM = COMP_UI_M_POL_NO_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL) {
		this.COMP_UI_M_POL_NO_TO_LABEL = COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText COMP_UI_M_POL_NO_TO) {
		this.COMP_UI_M_POL_NO_TO = COMP_UI_M_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL) {
		this.COMP_UI_M_PROCESS_DT_LABEL = COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar COMP_UI_M_PROCESS_DT) {
		this.COMP_UI_M_PROCESS_DT = COMP_UI_M_PROCESS_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_TYPE_LABEL() {
		return COMP_UI_M_PROCESS_TYPE_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_TYPE_LABEL(HtmlOutputLabel COMP_UI_M_PROCESS_TYPE_LABEL) {
		this.COMP_UI_M_PROCESS_TYPE_LABEL = COMP_UI_M_PROCESS_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PROCESS_TYPE() {
		return COMP_UI_M_PROCESS_TYPE;
	}

	public void setCOMP_UI_M_PROCESS_TYPE(HtmlSelectOneMenu comp_ui_m_process_type) {
		COMP_UI_M_PROCESS_TYPE = comp_ui_m_process_type;
	}
	
	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_FM(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM) {
		this.COMP_UI_M_BUT_LOV_POL_NO_FM = COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_TO() {
		return COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_TO(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO) {
		this.COMP_UI_M_BUT_LOV_POL_NO_TO = COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public String getM_NAME() {
		return M_NAME;
	}

	public void setM_NAME(String m_name) {
		M_NAME = m_name;
	}

	public String getM_BL_NAME() {
		return M_BL_NAME;
	}

	public void setM_BL_NAME(String m_bl_name) {
		M_BL_NAME = m_bl_name;
	}

	public String getM_VALUE() {
		return M_VALUE;
	}

	public void setM_VALUE(String m_value) {
		M_VALUE = m_value;
	}

	public String getM_CALC_METHOD() {
		return M_CALC_METHOD;
	}

	public void setM_CALC_METHOD(String m_calc_method) {
		M_CALC_METHOD = m_calc_method;
	}

	public String getM_PROCESS_TYPE() {
		return M_PROCESS_TYPE;
	}

	public void setM_PROCESS_TYPE(String m_process_type) {
		M_PROCESS_TYPE = m_process_type;
	}

	public HtmlCommandButton getTest() {
		return test;
	}

	public void setTest(HtmlCommandButton test) {
		this.test = test;
	}

	public Map<String, Object> getSession() {
		return (Map<String, Object>) session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = (HttpSession) session;
	}
	
	
	public void WHEN_VALIDATE_DUMMY_M_POL_NO_FM(ActionEvent ae){
		CommonUtils.clearMaps(this);
		try {
			WHEN_VALIDATE_M_POL_NO_FM();
			if("".equals(((String)getCOMP_UI_M_POL_NO_FM().getSubmittedValue()).trim()) || getCOMP_UI_M_POL_NO_FM().getSubmittedValue() == null){
				getCOMP_UI_M_POL_NO_FM().setSubmittedValue("0");
				getCOMP_UI_M_POL_NO_FM().updateModel(FacesContext.getCurrentInstance());
			}else {
				
				ResultSet resultSet = null;
				String selectQuery = "SELECT 'X'  FROM PT_IL_POLICY WHERE POL_NO = ? ";
				resultSet = new CRUDHandler().executeSelectStatement(selectQuery,CommonUtils.getConnection(), new Object[]{getCOMP_UI_M_POL_NO_FM().getSubmittedValue()});
				if (resultSet.next()) {
				}else {
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Policy Code Does not Exists.please Re-enter");
					getErrorMap().put("validate", "Policy Code Does not Exists.please Re-enter");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		
			getErrorMap().put("validate", e.getMessage());
		}
	}
	//ADDRD BY SARANYA FOR LAPSE PROCEESSING ON 18-07-2016
	
	public void WHEN_VALIDATE_M_POL_NO_FM()throws Exception{
		try {
			new CommonUtils().SET_REP_FIRST_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FM(),"String");
			 DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_TO()) ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void when_validate_item_M_POL_NO_TO()throws Exception{
		try {
			new CommonUtils().SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO(),"String");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	//END
	public void WHEN_VALIDATE_DUMMY_M_POL_NO_FM(FacesContext context,UIComponent  component,Object object) {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) object);
			new CommonUtils().SET_REP_FIRST_FIELD((String)object, "String");
			ResultSet resultSet = null;
			ResultSet resultSet1 = null;
			ResultSet rs1 = null;
			if(!object.equals("0")){
				String claimReg = "SELECT 'X' FROM PT_IL_CLAIM WHERE CLAIM_TYPE ='D' AND CLAIM_POL_NO = ?";
				String validate ="SELECT 'X' FROM PT_IL_POLICY WHERE POL_STATUS IN ('C','M','P','S','N','D','L') AND POL_NO =?";
				String selectQuery = "SELECT 'X'  FROM PT_IL_POLICY WHERE POL_NO = ? ";
				resultSet = new CRUDHandler().executeSelectStatement(selectQuery,CommonUtils.getConnection(), new Object[] {object});
				if (!(resultSet.next())) {
					throw new ValidatorException(new FacesMessage("Policy No Does not Exists.please Re-enter"));
					/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Policy No Does not Exists.please Re-enter");
					getErrorMap().put("validate", "Policy No Does not Exists.please Re-enter");*/
				}
				
				if("2".equalsIgnoreCase(getDUMMY_BEAN().getUI_M_PROCESS_TYPE())){
					rs1 = handler.executeSelectStatement(validate, connection, new Object[]{object});
					resultSet1 = new CRUDHandler().executeSelectStatement(
							claimReg, CommonUtils.getConnection(),
							new Object[] { DUMMY_BEAN.getUI_M_POL_NO_FM() });
					resultSet = new CRUDHandler().executeSelectStatement(
							validate, CommonUtils.getConnection(),
							new Object[] { object });
					if(rs1.next()){
						throw new ValidatorException(new FacesMessage(
						"Not a valid Policy for Lapsation")); 
						/*throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "80251"));*/
					}
	
					if (resultSet1.next()) {
						throw new ValidatorException(new FacesMessage(
								"Not a valid Policy for Lapsation")); 
					}
					
					 /*
																		 * No Does
																		 * not
																		 * Exists.please
																		 * Re-enter"
																		 */
						/*
						 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						 * "Policy No Does not Exists.please Re-enter");
						 * getErrorMap().put("validate", "Policy No Does not
						 * Exists.please Re-enter");
						 */
					}
				}
				//DUMMY_BEAN.setUI_M_POL_NO_TO((String) object);
				COMP_UI_M_POL_NO_TO.setSubmittedValue((String) object);
				COMP_UI_M_POL_NO_TO.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		}
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
		
	public void WHEN_VALIDATE_DUMMY_M_POL_NO_TO(FacesContext context,UIComponent  component,Object object){
		getWarningMap().clear();
		try {
			//when_validate_item_M_POL_NO_TO();
			String polNo = (String)new CommonUtils().SET_REP_SECOND_FIELD( DUMMY_BEAN.getUI_M_POL_NO_FM(),
								(String)object, "String");
			DUMMY_BEAN.setUI_M_POL_NO_TO(polNo);
		
					ResultSet resultSet = null;
					String selectQuery = "SELECT 'X'  FROM PT_IL_POLICY WHERE POL_NO = ? ";
					resultSet = new CRUDHandler().executeSelectStatement(selectQuery,CommonUtils.getConnection(), new Object[] {polNo});
					if (!(resultSet.next())) {
						throw new ValidatorException(new FacesMessage("Policy No Does not Exists.please Re-enter"));
						/*getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Policy No Does not Exists.please Re-enter");
						getErrorMap().put("validate", "Policy No Does not Exists.please Re-enter");*/
					}
		when_validate_item_M_POL_NO_TO();	
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		}
	}

	public boolean P_SET_SECOND_FIELD(HtmlInputText fromText,HtmlInputText toText){
		boolean status = true;
		if("".equals(toText.getSubmittedValue().toString().trim())){
			if(fromText.getSubmittedValue().toString().equals("0") && "".equals(toText.getSubmittedValue().toString().trim())){
				toText.setSubmittedValue("zzzzzzzzzz");
				toText.updateModel(FacesContext.getCurrentInstance());
				status = false;
			}
		}else{
			if((fromText.getSubmittedValue().toString().compareTo(toText.getSubmittedValue().toString()) > 0)){
				//errMsg = STD_MESSAGE_ROUTINE("ENG","10064"); 
				getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "10064"));
				
				status = false;
			}
		}
		return status;
	}

	public String error(){
		return "PILP014_A_CTRL";
	}
	
	public String WHENBUTTONPRESSED() throws SQLException,Exception{
		getWarningMap().clear();
		String  M_PS_CODE_DESC=null;
		String  M_RS_REPORT_NAME=null;
		Long  M_DSRC_SYS_ID=null;
		String  M_FLAG=null;
		String  M_PS_VALUE=null;
		String  M_POL_SYS_ID=null;
		ResultSet rs_C1A=null;
		ResultSet rs_C1=null;
		ResultSet rs_C9=null;
		double M_DUMMY=0;
		try{
			String sql_C1A="SELECT  DISTINCT  RS_REPORT_NAME  FROM   PW_IL_REMINDER_SUMMARY  WHERE  RS_REPORT_NAME IS NOT NULL AND RS_POL_SYS_ID IN( SELECT POL_SYS_ID  FROM PT_IL_POLICY  WHERE  POL_PLAN_CODE IN( SELECT PLAN_CODE FROM PM_IL_PLAN WHERE PLAN_TYPE <>'M') AND POL_NO BETWEEN ?  AND  ? )GROUP BY RS_REPORT_NAME ";
			String sql_C1="SELECT DISTINCT RS_REPORT_NAME,RS_POL_SYS_ID FROM  PW_IL_REMINDER_SUMMARY  WHERE  RS_POL_SYS_ID  IN  (SELECT POL_SYS_ID  FROM  PT_IL_POLICY   WHERE  POL_PLAN_CODE  IN (SELECT PLAN_CODE   FROM  PM_IL_PLAN    WHERE  PLAN_TYPE  <> 'M'   )   AND POL_NO  BETWEEN ?  AND ? AND RS_REPORT_NAME  = ? )";
			String stmt_C9 = "SELECT DSRC_SYS_ID.NEXTVAL FROM DUAL ";

			P_VAL_SYSTEM("IL_CALC_MTHD","IL_CALC_MTHD",null,"E",M_CALC_METHOD);
			
			if(getM_CALC_METHOD().equals("1") || getM_CALC_METHOD().equals("2") )  {
				
				System.out.println("---->IL_CALC_METHD ------> " + getM_CALC_METHOD() );
				
				if (DUMMY_BEAN.getUI_M_PROCESS_TYPE() != null) {
					if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("1")){
						DEPOSIT_MOVEMENT(DUMMY_BEAN.getUI_M_PROCESS_DT(), DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO());
						WOP_PROCESS(DUMMY_BEAN.getUI_M_PROCESS_DT(), DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO());
					} else if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("2") && getM_CALC_METHOD().equals("1")){
						PROCESS_LAPSATION(DUMMY_BEAN.getUI_M_PROCESS_DT(), DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO());
 					}else if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("2") && getM_CALC_METHOD().equals("2")){
 						PROCESS_LAPSATION_CONV(DUMMY_BEAN.getUI_M_PROCESS_DT(), DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO());
 					}
 				}
 			}
 						
		
			if (DUMMY_BEAN.getUI_M_PROCESS_TYPE() != null) {
				if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("2"))   {
					DUMMY_BEAN.setM_PRINT_TYPE("B");
					rs_C1A=handler.executeSelectStatement(sql_C1A, connection , new Object[]{DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO()});
					while(rs_C1A.next()){
						M_RS_REPORT_NAME =rs_C1A.getString(1);
					rs_C9=new CRUDHandler().executeSelectStatement(stmt_C9, CommonUtils.getConnection());
					if(rs_C9.next()){
						M_DSRC_SYS_ID=rs_C9.getLong(1);
					}
					rs_C9.close();
					M_DUMMY=0;
					rs_C1=handler.executeSelectStatement(sql_C1, connection , new Object[]{DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO(),M_RS_REPORT_NAME});
					while(rs_C1.next()){
						M_RS_REPORT_NAME = rs_C1.getString(1);
						M_POL_SYS_ID=rs_C1.getString(2);
						if (M_RS_REPORT_NAME != null) {
							if(M_RS_REPORT_NAME.indexOf("I05")!= -1){
								M_DUMMY=1;
								ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
								GEN_PS_LAPSED_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
								if (list != null && !list.isEmpty()) {
									M_DSRC_SYS_ID = (Long)list.get(0).getValueObject();
								}
							}else if(M_RS_REPORT_NAME.indexOf("I06")!= -1){
								M_DUMMY=1;
								ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
								GEN_PS_PIA_NOTICE(M_DSRC_SYS_ID, M_RS_REPORT_NAME, M_POL_SYS_ID);
								if (list != null && !list.isEmpty()) {
									M_DSRC_SYS_ID = (Long)list.get(0).getValueObject();
					
								}
							}
						}
						int returnvalue = new CRUDHandler().executeInsertStatement(SQLQueryInterface.sql_dummy1, CommonUtils.getConnection(),new Object[]{M_RS_REPORT_NAME,M_POL_SYS_ID});
						int returnvalue1 = new CRUDHandler().executeDeleteStatement(SQLQueryInterface.sql_dummy2, CommonUtils.getConnection(),new Object[]{M_RS_REPORT_NAME,M_POL_SYS_ID});
					}
					if(M_DUMMY==1){
						int returnvalue2 = new CRUDHandler().executeDeleteStatement(SQLQueryInterface.sql_dummy3, CommonUtils.getConnection(),new Object[]{M_DSRC_SYS_ID});
					}
					}

					int returnvalue3 = new CRUDHandler().executeDeleteStatement(SQLQueryInterface.sql_dummy4, CommonUtils.getConnection());
						
					int returnvalue4 = new CRUDHandler().executeDeleteStatement(SQLQueryInterface.sql_dummy5, CommonUtils.getConnection());
				}
			}
			
				
		
		L_BULK_ONLINE_POSTING(DUMMY_BEAN.getUI_M_POL_NO_FM(), DUMMY_BEAN.getUI_M_POL_NO_TO());
		CommonUtils.getControlBean().setM_COMM_DEL("C");
		if(!connection.getAutoCommit())
			CommonUtils.getControlBean().setM_COMM_DEL("");
		if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("1")){
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
					Messages.getString(PELConstants.pelErrorMessagePath, "3206",new Object[]{"Premium Recognition from Deposit is Completed"}));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "3206",
					new Object[]{"Premium Recognition from Deposit is Completed"}));
			}else if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("2")){
				//	System.out.println("LAPSE PROCESS IS COMPLETED");
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
							Messages.getString(PELConstants.pelErrorMessagePath, "3206",new Object[]{"Lapse Process is Completed"}));
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "3206",
							new Object[]{"Lapse Process is Completed"}));		
			}else{
				System.out.println("DUMMY_ACTION.WHENBUTTONPRESSED()ELSE................");
			}
		/*added by saranya on 13-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried Proposals v1.0*/
		System.out.println("Process Type :"+DUMMY_BEAN.getUI_M_PROCESS_TYPE());
		if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("3")){
			/*
			 * modified by Ameen on 22-07-2017 for ZBILQC-1720395 as per Chandramohan sugg.
			 * PROCESS_PROP_CANCEL(DUMMY_BEAN.getUI_M_PROCESS_DT(),DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO());*/
			PROCESS_PROP_CANCEL(DUMMY_BEAN.getUI_M_PROCESS_DT(),DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO(),DUMMY_BEAN.getUI_M_MED_FEE_YN(),DUMMY_BEAN.getUI_M_PROCESSING_FEE());
            if(Count==1)
            {
            	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Proposal Cancellation Processs Successfully");
            }
		}
		/*End*/
		
		/*added by saranya on 07-04-2016 for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS*/
		if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("6")){
			P_AAA_BENF_PROCESS(DUMMY_BEAN.getUI_M_PROCESS_DT(),
					 DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO());
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
					Messages.getString(PELConstants.pelErrorMessagePath, "3206",new Object[]{"AAA Benefit process is Completed"}));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "3206",
					new Object[]{"AAA Benefit process is Completed"}));	
				
			}
		/*End*/

		
		/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/ 
		if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("4")){
		P_COMM_CLBCK_PROCESS();
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
				Messages.getString(PELConstants.pelErrorMessagePath, "3206",new Object[]{"Clawback Process is Completed"}));
		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "3206",
				new Object[]{"Clawback Process is Completed"}));	
			
		}
		
		if(DUMMY_BEAN.getUI_M_PROCESS_TYPE().equals("7")){
		
			PROCESS_PROP_CANCEL_CIC(DUMMY_BEAN.getUI_M_PROCESS_DT(),DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO(),DUMMY_BEAN.getUI_M_MED_FEE_YN(),DUMMY_BEAN.getUI_M_PROCESSING_FEE(),DUMMY_BEAN.getUI_M_PROCESS_TYPE());
            if(Counts==1)
            {
            	getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Customer Initiated Cancellation Completed");
            }
		}
	
		/*End*/		
								
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("validate", e.getMessage());
			
		}
		return null;
	}
	
	public void onLoad(PhaseEvent event)  {
		try {
			if (isBlockFlag()) {
				preForm();
				checkProcessType();
				/*Added by Ameen on 21-07-2017 for ZBILQC-1720395 as per Chandramohan sugg.*/
				if("PC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"))){
					COMP_UI_M_MED_FEE_YN_LABEL.setRendered(true);
					COMP_UI_M_MED_FEE_YN.setRendered(true);
					COMP_UI_M_PROCESSING_FEE_LABEL.setRendered(true);
					COMP_UI_M_PROCESSING_FEE.setRendered(true);
				}
				/*Newly added by pidugu raj dt: 16-10-2018 as suggested by chandramohan*/
				else if("CIC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"))){
					COMP_UI_M_MED_FEE_YN_LABEL.setRendered(true);
					COMP_UI_M_MED_FEE_YN.setRendered(true);
					COMP_UI_M_PROCESSING_FEE_LABEL.setRendered(true);
					COMP_UI_M_PROCESSING_FEE.setRendered(true);
				}
				/*End 
				 * Newly added by pidugu raj dt: 16-10-2018 as suggested by chandramohan*/
				else{
					COMP_UI_M_MED_FEE_YN_LABEL.setRendered(false);
					COMP_UI_M_MED_FEE_YN.setRendered(false);
					COMP_UI_M_PROCESSING_FEE_LABEL.setRendered(false);
					COMP_UI_M_PROCESSING_FEE.setRendered(false);
				}
				/*End*/
				setBlockFlag(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("validate", e.getMessage());
		}
	}
	
	//added to create menu for lapse processing by santoshi on 5/2/13
	public void checkProcessType(){
 		if("LP".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"))){
			getDUMMY_BEAN().setUI_M_PROCESS_TYPE("2");
			/*Added by saritha on 17-Feb-2017 Cosmetic changes Lapse processing to be changed as Lapse and Paid-up Processing*/
			/*COMP_UI_TEXT.setValue("Lapse Processing");*/
			COMP_UI_TEXT.setValue("Lapse And Paid-Up Processing");
			/*End*/
			System.out.println("------>"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			COMP_UI_M_PROCESS_TYPE.setDisabled(true);	

		}
		/*added by saranya on 13-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried Proposals v1.0*/
		else if("PC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"))){
			getDUMMY_BEAN().setUI_M_PROCESS_TYPE("3");
			COMP_UI_TEXT.setValue("Proposal Cancellation Processing");
			System.out.println("------>"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			/*Commented by pidugu raj dt: 16-10-2018 since sivaraman asked processing type should be enabled
			 * COMP_UI_M_PROCESS_TYPE.setDisabled(true);*/	
		}
		/*End*/
		/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
		else if("CC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"))){
			getDUMMY_BEAN().setUI_M_PROCESS_TYPE("4");
			COMP_UI_TEXT.setValue("Clawback Processing");
			System.out.println("clawback"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			COMP_UI_M_PROCESS_TYPE.setDisabled(true);			
		}

		/*End*/
		/*added by saranya on 27-01-2016 for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS*/
		else if("AAA".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"))){
			getDUMMY_BEAN().setUI_M_PROCESS_TYPE("6");
			COMP_UI_TEXT.setValue("AAA Benefit Processing");
			System.out.println("AAA Processing------>"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			COMP_UI_M_PROCESS_TYPE.setDisabled(true);	
		}
 		
 		/*Newly added by pidugu raj dt: 16-10-2018 as suggested by chandramohan */
		else if("CIC".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"))){
			getDUMMY_BEAN().setUI_M_PROCESS_TYPE("7");
			COMP_UI_TEXT.setValue("Customer Initiated Cancellation");
			System.out.println("------>"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			COMP_UI_M_PROCESS_TYPE.setDisabled(true);
		}
 		/*End Newly added by pidugu raj dt: 16-10-2018 as suggested by chandramohan */

 		
		/*End*/
		else{
			getDUMMY_BEAN().setUI_M_PROCESS_TYPE("1");
			COMP_UI_TEXT.setValue(" Auto Renewal Premium Recognition");
			System.out.println("------>----->1"+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
			COMP_UI_M_PROCESS_TYPE.setDisabled(true);	
		}


	}

	public void preForm() throws Exception{
 
		ArrayList<OracleParameter> list =null;
		FacesContext context=FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap();
		session = (HttpSession)context.getExternalContext().getSession(true);
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		session.setAttribute("GLOBAL.M_MODULE_NAME", "PILP014_A");
 		STD_PRE_FORM();
 		try {
 		ControlBean ctrlbean = CommonUtils.getControlBean();
 		String M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new Date();
 		OracleProcedureHandler procHandler = new OracleProcedureHandler();
 		
 		} catch (Exception e1) {
			e1.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e1.getMessage());
			getErrorMap().put("validate", e1.getMessage());
		}
	}
		

	public void STD_PRE_FORM(){
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String)session.getAttribute("GLOBAL.M_PARA_1"));
		ctrlBean.setM_PROG_NAME("PIL014_A");
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
	}

	

	public ArrayList<OracleParameter> prepareOracleParam(HttpSession session2){
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		paramList.add(new OracleParameter("in1","STRING","IN",(String)session2.getAttribute("GLOBAL.M_LANG_CODE")));
		paramList.add(new OracleParameter("in2","STRING","IN",(String)session2.getAttribute("GLOBAL.M_FOR_LANG_CODE")));
		paramList.add(new OracleParameter("in3","STRING","IN",CommonUtils.getControlBean().getM_USER_ID()));
		paramList.add(new OracleParameter("in4","STRING","IN", CommonUtils.getControlBean().getM_COMP_CODE()));
		paramList.add(new OracleParameter("in5","STRING","IN",(CommonUtils.getControlBean().getM_COMP_CODE())));
		paramList.add(new OracleParameter("in6","STRING","IN",(CommonUtils.getControlBean().getM_COMP_CODE())));
		paramList.add(new OracleParameter("in7","STRING","IN",CommonUtils.getControlBean().getM_BASE_CURR()));
		paramList.add(new OracleParameter("in8","STRING","IN","2"));
		paramList.add(new OracleParameter("in9","STRING","IN",CommonUtils.getControlBean().getM_PROG_NAME()));
		OracleProcedureHandler handler = new OracleProcedureHandler();

	return paramList;
	}

	public void P_VAL_SYSTEM(String P_TYPE , String P_CODE , String P_CODE_DESC , String P_ERR_FLAG, String P_VALUE)throws Exception{
		
		this.P_CODE_DESC = P_CODE_DESC;
		this.P_VALUE = P_VALUE;
		ResultSet pvsrs;
		String found ="N"; 
		PreparedStatement pvstmt;
		String pvsQuery;
		connection =CommonUtils.getConnection();
			pvsQuery = "SELECT PS_CODE_DESC,PS_BL_CODE_DESC,PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='"+P_TYPE +"' AND PS_CODE='"+P_CODE+"'";
			pvstmt = connection.prepareStatement(pvsQuery);
			pvsrs = pvstmt.executeQuery();
			while(pvsrs.next()){
				setM_NAME(pvsrs.getString("PS_CODE_DESC"));
				setM_BL_NAME(pvsrs.getString("PS_BL_CODE_DESC"));
				setM_VALUE(""+pvsrs.getInt("PS_VALUE"));
				found ="Y";
			}

			if (! found.equals("Y") ) {
				if(P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals("E")){
					getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "1000"));
					if(P_ERR_FLAG.equals(""+"E")){
					}
				}
			}
			pvsrs.close();
			if(session.getAttribute("GLOBAL.M_FOR_LANG_CODE").toString().substring(1, 3).equals("1") || CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE").equals("ENG")){
				setP_CODE_DESC(getM_NAME());
			}else{
				setP_CODE_DESC(getM_NAME());
			}
			setP_VALUE(M_VALUE);
			setM_CALC_METHOD(getP_VALUE());
	}

	
	public void L_VAL_FROM_TO(HtmlInputText fromText,HtmlInputText toText){
		try{
			if("".equals(fromText.getSubmittedValue().toString().trim())){
				getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "80033"));
			}else {
				if(Integer.parseInt(toText.getSubmittedValue().toString().trim()) < Integer.parseInt(fromText.getSubmittedValue().toString().trim())){
					getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "80034"));
				}
				if((toText.getSubmittedValue().toString().trim().compareTo(fromText.getSubmittedValue().toString().trim()) < 0)){
					getErrorMap().put("current", Messages.getString(PELConstants.pelErrorMessagePath, "80034"));
				}
			}
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
	}
					

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP014",
					"DUMMY", "M_POL_NO_FM", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	//ADDED BY SARANYA
	public void actionListenerM_POL_NO_FROM(ActionEvent actionEvent) throws Exception 
	{
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		try {
			if (inputValue.isEmpty()) {
				COMP_UI_M_POL_NO_FM
						.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
				DUMMY_BEAN.setUI_M_POL_NO_FM(PELConstants.PROCESS_TOVALUE);
			} else {
				DUMMY_BEAN.setUI_M_POL_NO_FM(inputValue);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	public void actionListenerM_POL_NO_TO(ActionEvent actionEvent) throws Exception
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)inputText.getSubmittedValue();
		try{
		if(inputTextString == "")
		{
			if(!PELConstants.PROCESS_FROMVALUE.equals(DUMMY_BEAN.getUI_M_POL_NO_FM()))
			{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(DUMMY_BEAN.getUI_M_POL_NO_FM());
				DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_FM());
			}else{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				DUMMY_BEAN.setUI_M_POL_NO_TO(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			DUMMY_BEAN.setUI_M_POL_NO_TO(inputTextString);
		}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	
		
 
		public List<SelectItem> getUI_M_PROCESS_TYPE_LIST() throws Exception {
			
			if (UI_M_PROCESS_TYPE_LIST.size() ==0){ 
				UI_M_PROCESS_TYPE_LIST.clear();
				UI_M_PROCESS_TYPE_LIST = new ArrayList<SelectItem>();
			  }
			return UI_M_PROCESS_TYPE_LIST;
		}
		
		public void setUI_M_PROCESS_TYPE_LIST(List<SelectItem> ui_m_process_type_list) {
			UI_M_PROCESS_TYPE_LIST = ui_m_process_type_list;
		}

 

	public void validateUI_M_PROCESS_DT(FacesContext context, UIComponent component,Object value)  {
	//	CommonUtils.clearMaps(this);
		try {
			if (value == null) {
			DUMMY_BEAN.setUI_M_PROCESS_DT(new CommonUtils().getCurrentDate());
			COMP_UI_M_PROCESS_DT.resetValue();
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void validate_UI_M_PROCESS_TYPE(ActionEvent event){
		UIInput input = (UIInput)event.getComponent().getParent();
		if(input.getValue()!=null){
			DUMMY_BEAN.setUI_M_PROCESS_TYPE((String)input.getValue());
			System.out.println("Process type***************"+DUMMY_BEAN.getUI_M_PROCESS_TYPE());
		}
	}
	
	
	
	/**
    *
    * @param P_DATE-IN
    * @param P_POL_FM_NO-IN
    * @param P_POL_TO_NO-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> WOP_PROCESS(
                    Object P_DATE,
         Object P_POL_FM_NO,
         Object P_POL_TO_NO) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
          parameterList.add(param3);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_END_OF_DAY_PROC.WOP_PROCESS");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
  
  
  
		  /**
		  *
		  * @param P_DATE-IN
		  * @param P_POL_FM_NO-IN
		  * @param P_POL_TO_NO-IN
		  *
		  * @return ArrayList of type Oracle Parameter
		  * @throws Exception
		  */
		public ArrayList<OracleParameter> DEPOSIT_MOVEMENT(
		                  Object P_DATE,
		       Object P_POL_FM_NO,
		       Object P_POL_TO_NO) throws ProcedureException {
		     Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
		        OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
		        parameterList.add(param1);
		        OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
		        parameterList.add(param2);
		        OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
		        parameterList.add(param3);
		
		       OracleProcedureHandler procHandler = new OracleProcedureHandler();
		        outputList = procHandler.executeProc(parameterList, connection,
		               "P9ILPK_END_OF_DAY_PROC.DEPOSIT_MOVEMENT");
		     } catch(Exception e) {
		     	ErrorHelpUtil.getErrorForProcedure(connection);
		            throw new ProcedureException(e.getMessage());
		     }
		    return outputList;
		}



		/**
		*
		* @param P_DSRC_SYS_ID-IN OUT
		* @param P_RS_REPORT_NAME-IN
		* @param P_POL_SYS_ID-IN
		*
		* @return ArrayList of type Oracle Parameter
		* @throws Exception
		*/
		public ArrayList<OracleParameter> GEN_PS_LAPSED_NOTICE(
		                Object P_DSRC_SYS_ID,
		     Object P_RS_REPORT_NAME,
		     Object P_POL_SYS_ID) throws ProcedureException {
		   Connection connection = null;
			 ArrayList<OracleParameter> parameterList = null;
			 ArrayList<OracleParameter> outputList = null;
			 try {
			 	connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
		      OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
		      parameterList.add(param1);
		      OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
		      parameterList.add(param2);
		      OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
		      parameterList.add(param3);
		
		     OracleProcedureHandler procHandler = new OracleProcedureHandler();
		      outputList = procHandler.executeProc(parameterList, connection,
		             "P9ILPK_PS_LETTERS.GEN_PS_LAPSED_NOTICE");
		   } catch(Exception e) {
		   	ErrorHelpUtil.getErrorForProcedure(connection);
		          throw new ProcedureException(e.getMessage());
		   }
		  return outputList;
		}

		/**
		*
		* @param P_DSRC_SYS_ID-IN OUT
		* @param P_RS_REPORT_NAME-IN
		* @param P_POL_SYS_ID-IN
		*
		* @return ArrayList of type Oracle Parameter
		* @throws Exception
		*/
		public ArrayList<OracleParameter> GEN_PS_PIA_NOTICE(Object P_DSRC_SYS_ID,
		     Object P_RS_REPORT_NAME,Object P_POL_SYS_ID) throws ProcedureException {
			Connection connection = null;
			ArrayList<OracleParameter> parameterList = null;
			ArrayList<OracleParameter> outputList = null;
			try {
				connection = CommonUtils.getConnection();
				parameterList = new ArrayList<OracleParameter>();
				outputList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("IN OUT1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN_OUT, P_DSRC_SYS_ID);
				parameterList.add(param1);
				OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_RS_REPORT_NAME);
				parameterList.add(param2);
				OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
				parameterList.add(param3);
				
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_PS_LETTERS.GEN_PS_PIA_NOTICE");
			} catch(Exception e) {
				ErrorHelpUtil.getErrorForProcedure(connection);
				throw new ProcedureException(e.getMessage());
		   }
		  return outputList;
		}
		

	/**
	*
	* @param P_M_POL_NO_FM-IN
	* @param P_M_POL_NO_TO-IN
	*
	* @return ArrayList of type Oracle Parameter
	* @throws Exception
	*/
	   
		public ArrayList<OracleParameter> L_BULK_ONLINE_POSTING(Object P_M_POL_NO_FM,Object P_M_POL_NO_TO) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_NO_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_M_POL_NO_TO);
			parameterList.add(param2);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_ONLINE_POSTING.L_BULK_ONLINE_POSTING");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}


	
	/**
    *
    * @param P_DATE-IN
    * @param P_POL_FM_NO-IN
    * @param P_POL_TO_NO-IN
    *
    * @return ArrayList of type Oracle Parameter
    * @throws Exception
    */
  public ArrayList<OracleParameter> PROCESS_LAPSATION(
                    Object P_DATE,
         Object P_POL_FM_NO,
         Object P_POL_TO_NO) throws ProcedureException {
       Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
          parameterList.add(param2);
          OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
          parameterList.add(param3);

         OracleProcedureHandler procHandler = new OracleProcedureHandler();
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_LAPSE_CONV.PROCESS_LAPSATION");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }

  
  
  
  
  public ArrayList<OracleParameter> PROCESS_LAPSATION_CONV(
          Object P_DATE,
	Object P_POL_FM_NO,
	Object P_POL_TO_NO) throws ProcedureException {
	Connection connection = null;
	ArrayList<OracleParameter> parameterList = null;
	ArrayList<OracleParameter> outputList = null;
	try {
		connection = CommonUtils.getConnection();
		parameterList = new ArrayList<OracleParameter>();
		outputList = new ArrayList<OracleParameter>();
	OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
	parameterList.add(param1);
	OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
	parameterList.add(param2);
	OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
	parameterList.add(param3);
	
	OracleProcedureHandler procHandler = new OracleProcedureHandler();
	outputList = procHandler.executeProc(parameterList, connection,
	       "P9ILPK_LAPSE_CONV.PROCESS_LAPSATION");
	} catch(Exception e) {
		ErrorHelpUtil.getErrorForProcedure(connection);
	    throw new ProcedureException(e.getMessage());
	}
	return outputList;
	}
  
	public HtmlOutputText getCOMP_UI_TEXT() {
		return COMP_UI_TEXT;
	}

	public void setCOMP_UI_TEXT(HtmlOutputText comp_ui_text) {
		COMP_UI_TEXT = comp_ui_text;
	}

	/*added by saranya on 13-12-2016 for RM018T - FSD_IL_ZB Life_016-Queried Proposals v1.0*/
	int Count;
	public ArrayList<OracleParameter> PROCESS_PROP_CANCEL(
			Object P_DATE,
			Object P_POL_FM_NO,
			Object P_POL_TO_NO,
			Object M_MED_FEE_YN,
			Object PROCESSING_FEE) throws ProcedureException {
		Connection connection = null;
		Count=0;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
			parameterList.add(param3);
			/*Added by Ameen on 22-07-2017 for ZBILQC-1720395 as per Chandramohan sugg.*/
			OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, M_MED_FEE_YN);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, PROCESSING_FEE);
			parameterList.add(param5);
			/*End*/
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_LAPSE_CONV.PROCESS_PROP_CANCEL");
			Count++;
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	/*End*/
	
	
	/*Newly added by pidugu raj dt: 16-10-2018 as suggested by chandramohan for customer initiated cancellation*/
	int Counts;
	public ArrayList<OracleParameter> PROCESS_PROP_CANCEL_CIC(
			Object P_DATE,
			Object P_POL_FM_NO,
			Object P_POL_TO_NO,
			Object M_MED_FEE_YN,
			Object PROCESSING_FEE, String UI_M_PROCESS_TYPE) throws ProcedureException {
		Connection connection = null;
		Counts=0;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, M_MED_FEE_YN);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5", OracleParameter.DATA_TYPE.DOUBLE, OracleParameter.DIRECTION_TYPE.IN, PROCESSING_FEE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, UI_M_PROCESS_TYPE);
			parameterList.add(param6);
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_LAPSE_CONV.PROCESS_PROP_CANCEL_CIC");
			Counts++;
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	/*End*/
	
	
	
	
	
	/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	
	public ArrayList<OracleParameter>P_COMM_CLBCK_PROCESS() throws ProcedureException {
		ArrayList<OracleParameter> outputList = null;
		try {	 
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		
		String POLICY_FM="0";
		String POLICY_TO="ZZZZZZZZZZZZ";
		Integer POL_SYS_ID=0;
		Date dt =new Date();
		String Current_date =(new SimpleDateFormat("dd-MM-yyyy").format(dt));
		SimpleDateFormat df = new SimpleDateFormat( "dd-MM-yyyy" );  
		Date curr_date = df.parse(Current_date);  
			System.out.println("inside clawback procedure calling"); 
		 	connection = CommonUtils.getConnection();
		 	
		 	parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,POLICY_FM);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN,POLICY_TO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN,curr_date);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN,POL_SYS_ID);
			parameterList.add(param4);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			System.out.println("Clawback procedure::::::::::::");
			outputList = procHandler.executeProc(parameterList, connection,"P9ILPK_LAPSE_CONV.P_COMM_CLBCK_PROCESS");
	   } catch(Exception e) {
	   	ErrorHelpUtil.getErrorForProcedure(connection);
	          throw new ProcedureException(e.getMessage());
	   }
	  return outputList;
	}
	
	/*End*/

	/*added by saranya on 07-04-2016 for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS*/
	public ArrayList<OracleParameter> P_AAA_BENF_PROCESS(
			Object P_DATE,
			Object P_POL_FM_NO,
			Object P_POL_TO_NO) throws ProcedureException {
		Connection connection = null;
		Count=0;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_FM_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_TO_NO);
			parameterList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_LAPSE_CONV.P_AAA_BENF_PROCESS");
			Count++;
		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	/*End*/
  
	/*Added by Ameen on 21-07-2017 for ZBILQC-1720395 as per Chandramohan sugg.*/
	private HtmlOutputLabel COMP_UI_M_MED_FEE_YN_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_MED_FEE_YN;
	
	private HtmlOutputLabel COMP_UI_M_PROCESSING_FEE_LABEL;
	
	private HtmlInputText COMP_UI_M_PROCESSING_FEE;
	
	public HtmlOutputLabel getCOMP_UI_M_MED_FEE_YN_LABEL() {
		return COMP_UI_M_MED_FEE_YN_LABEL;
	}

	public void setCOMP_UI_M_MED_FEE_YN_LABEL(
			HtmlOutputLabel cOMP_UI_M_MED_FEE_YN_LABEL) {
		COMP_UI_M_MED_FEE_YN_LABEL = cOMP_UI_M_MED_FEE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_MED_FEE_YN() {
		return COMP_UI_M_MED_FEE_YN;
	}

	public void setCOMP_UI_M_MED_FEE_YN(HtmlSelectOneMenu cOMP_UI_M_MED_FEE_YN) {
		COMP_UI_M_MED_FEE_YN = cOMP_UI_M_MED_FEE_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESSING_FEE_LABEL() {
		return COMP_UI_M_PROCESSING_FEE_LABEL;
	}

	public void setCOMP_UI_M_PROCESSING_FEE_LABEL(
			HtmlOutputLabel cOMP_UI_M_PROCESSING_FEE_LABEL) {
		COMP_UI_M_PROCESSING_FEE_LABEL = cOMP_UI_M_PROCESSING_FEE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PROCESSING_FEE() {
		return COMP_UI_M_PROCESSING_FEE;
	}

	public void setCOMP_UI_M_PROCESSING_FEE(HtmlInputText cOMP_UI_M_PROCESSING_FEE) {
		COMP_UI_M_PROCESSING_FEE = cOMP_UI_M_PROCESSING_FEE;
	}
	
	List<SelectItem> UI_M_MED_FEE_YN_LIST = new ArrayList<SelectItem>();
	
	public List<SelectItem> getUI_M_MED_FEE_YN_LIST() {
		return UI_M_MED_FEE_YN_LIST;
	}

	public void setUI_M_MED_FEE_YN_LIST(List<SelectItem> uI_M_MED_FEE_YN_LIST) {
		UI_M_MED_FEE_YN_LIST = uI_M_MED_FEE_YN_LIST;
	}
	
	public void validateUI_M_MED_FEE_YN(FacesContext context, 
			UIComponent component,Object value)  {
			try {
				DUMMY_BEAN.setUI_M_MED_FEE_YN((String)value);
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	
	public void validateUI_M_PROCESSING_FEE(FacesContext context, 
			UIComponent component,Object value)  {
		try {
			DUMMY_BEAN.setUI_M_PROCESSING_FEE((Double)value);
		} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	
	/*End*/
}
