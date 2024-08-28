package com.iii.pel.forms.PILP003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT003_APAC.PILT003_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT024.P9ILPK_INVEST_PREM_COLL;
import com.iii.pel.forms.PILT024.PILT024_COMPOSITE_ACTION;
import com.iii.pel.utils.P9ILPK_PREM_COLL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;


public class PILP003_APAC_DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_APPRV_DATE;

	private HtmlOutputLabel COMP_UI_M_ACNT_CUST_CODE_LABEL;

	private HtmlInputText COMP_UI_M_ACNT_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_PREM_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PREM_GEN_YN;

	private HtmlOutputLabel COMP_UI_M_BROK_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_BROK_GEN_YN;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_POL_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_ACNT_CUST_CODE;

	private DUMMY DUMMY_BEAN;
	
	private DUMMY1 DUMMY_BEAN1;
	
	
//	private Map<String, String> errorMap = new HashMap<String, String>();
//	private String errorMessages;
	
	private List customerCodeList;
	
	private String P_CODE_DESC ;
	private String P_VALUE ;
	private String M_NAME;
	private String M_BL_NAME;
	private String M_VALUE;
	private String M_CALC_METHOD;
	HttpSession session = null;
	CRUDHandler handler = null;
	ControlBean ctrlBean  = null;
	 
	FacesContext context = FacesContext.getCurrentInstance();
	
	private List<SelectItem> PREM_GEN_YN_LIST = new ArrayList<SelectItem>();
	private List<SelectItem> BROK_GEN_YN_LIST = new ArrayList<SelectItem>();
	private DUMMY_HELPER helper=null;
	public PILP003_APAC_DUMMY_ACTION() {
		try{
			DUMMY_BEAN = new DUMMY();
			DUMMY_BEAN1 = new DUMMY1();
			helper = new DUMMY_HELPER();
			Connection connection = CommonUtils.getConnection();
			//preForm();
			List<SelectItem> listItemPremGen = ListItemUtil.getDropDownListValue(connection, "PILP003_APAC", "DUMMY", "DUMMY.M_PREM_GEN_YN", "YESNO");
			setPREM_GEN_YN_LIST(listItemPremGen);
			List<SelectItem> listItemBrokGen = ListItemUtil.getDropDownListValue(connection, "PILP003_APAC", "DUMMY", "DUMMY.M_BROK_GEN_YN", "YESNO");
			setBROK_GEN_YN_LIST(listItemBrokGen);
		}catch(Exception e){
			e.printStackTrace();
		}
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

	public HtmlOutputLabel getCOMP_UI_M_APPRV_DATE_LABEL() {
		return COMP_UI_M_APPRV_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_APPRV_DATE() {
		return COMP_UI_M_APPRV_DATE;
	}

	public void setCOMP_UI_M_APPRV_DATE_LABEL(HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL) {
		this.COMP_UI_M_APPRV_DATE_LABEL = COMP_UI_M_APPRV_DATE_LABEL;
	}

	public void setCOMP_UI_M_APPRV_DATE(HtmlCalendar COMP_UI_M_APPRV_DATE) {
		this.COMP_UI_M_APPRV_DATE = COMP_UI_M_APPRV_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACNT_CUST_CODE_LABEL() {
		return COMP_UI_M_ACNT_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACNT_CUST_CODE() {
		return COMP_UI_M_ACNT_CUST_CODE;
	}

	public void setCOMP_UI_M_ACNT_CUST_CODE_LABEL(HtmlOutputLabel COMP_UI_M_ACNT_CUST_CODE_LABEL) {
		this.COMP_UI_M_ACNT_CUST_CODE_LABEL = COMP_UI_M_ACNT_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_ACNT_CUST_CODE(HtmlInputText COMP_UI_M_ACNT_CUST_CODE) {
		this.COMP_UI_M_ACNT_CUST_CODE = COMP_UI_M_ACNT_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREM_GEN_YN_LABEL() {
		return COMP_UI_M_PREM_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_PREM_GEN_YN_LABEL(HtmlOutputLabel COMP_UI_M_PREM_GEN_YN_LABEL) {
		this.COMP_UI_M_PREM_GEN_YN_LABEL = COMP_UI_M_PREM_GEN_YN_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_BROK_GEN_YN_LABEL() {
		return COMP_UI_M_BROK_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_BROK_GEN_YN_LABEL(HtmlOutputLabel COMP_UI_M_BROK_GEN_YN_LABEL) {
		this.COMP_UI_M_BROK_GEN_YN_LABEL = COMP_UI_M_BROK_GEN_YN_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_DESC_LABEL() {
		return COMP_UI_M_POL_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_DESC() {
		return COMP_UI_M_POL_CUST_DESC;
	}

	public void setCOMP_UI_M_POL_CUST_DESC_LABEL(HtmlOutputLabel COMP_UI_M_POL_CUST_DESC_LABEL) {
		this.COMP_UI_M_POL_CUST_DESC_LABEL = COMP_UI_M_POL_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_DESC(HtmlInputText COMP_UI_M_POL_CUST_DESC) {
		this.COMP_UI_M_POL_CUST_DESC = COMP_UI_M_POL_CUST_DESC;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_LOV() {
		return COMP_UI_M_BUT_POL_LOV;
	}

	public void setCOMP_UI_M_BUT_POL_LOV(HtmlCommandButton COMP_UI_M_BUT_POL_LOV) {
		this.COMP_UI_M_BUT_POL_LOV = COMP_UI_M_BUT_POL_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACNT_CUST_CODE() {
		return COMP_UI_M_BUT_ACNT_CUST_CODE;
	}

	public void setCOMP_UI_M_BUT_ACNT_CUST_CODE(HtmlCommandButton COMP_UI_M_BUT_ACNT_CUST_CODE) {
		this.COMP_UI_M_BUT_ACNT_CUST_CODE = COMP_UI_M_BUT_ACNT_CUST_CODE;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	

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
	
	public List getCustomerCodeList() {
		return customerCodeList;
	}

	public void setCustomerCodeList(List customerCodeList) {
		this.customerCodeList = customerCodeList;
	}
	
	public List<SelectItem> getPREM_GEN_YN_LIST() {
		return PREM_GEN_YN_LIST;
	}

	public void setPREM_GEN_YN_LIST(List<SelectItem> prem_gen_yn_list) {
		PREM_GEN_YN_LIST = prem_gen_yn_list;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREM_GEN_YN() {
		return COMP_UI_M_PREM_GEN_YN;
	}

	public void setCOMP_UI_M_PREM_GEN_YN(HtmlSelectOneMenu comp_ui_m_prem_gen_yn) {
		COMP_UI_M_PREM_GEN_YN = comp_ui_m_prem_gen_yn;
	}

	public List<SelectItem> getBROK_GEN_YN_LIST() {
		return BROK_GEN_YN_LIST;
	}

	public void setBROK_GEN_YN_LIST(List<SelectItem> brok_gen_yn_list) {
		BROK_GEN_YN_LIST = brok_gen_yn_list;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_BROK_GEN_YN() {
		return COMP_UI_M_BROK_GEN_YN;
	}

	public void setCOMP_UI_M_BROK_GEN_YN(HtmlSelectOneMenu comp_ui_m_brok_gen_yn) {
		COMP_UI_M_BROK_GEN_YN = comp_ui_m_brok_gen_yn;
	}
	
	public DUMMY1 getDUMMY_BEAN1() {
		return DUMMY_BEAN1;
	}

	public void setDUMMY_BEAN1(DUMMY1 dummy_bean1) {
		DUMMY_BEAN1 = dummy_bean1;
	}
	 
	/**
	 * METHOD  CALLED ON VALIDATOR FOR UI_M_POL_NO
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_POL_NO(FacesContext context, UIComponent component,
			Object value) throws ValidatorException, Exception {
		helper.pilp003_apac_dummy_m_pol_no_when_validate_item(DUMMY_BEAN);
	}
	
	/**
	 * METHOD CALLED ON a4j support onblur
	 * actionListener FOR COMP_UI_M_POL_NO
	 * @param e
	 */
	public void COMP_UI_M_POL_NO_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput)e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	 
	 /**
		 * METHOD  CALLED ON VALIDATOR FOR UI_M_APPRV_DATE
		 * @param context
		 * @param component
		 * @param value
		 * @throws Exception
		 */
		public void validateUI_M_APPRV_DATE(FacesContext context, UIComponent component,
				Object value) throws ValidatorException, Exception {
			DUMMY_BEAN.setUI_M_APPRV_DATE((Date)value);
			helper.pilp003_apac_dummy_m_apprv_date_when_validate_item(DUMMY_BEAN);
		}
		 
	 public void fireFieldValidation(ActionEvent ae) {
	     UIInput input = (UIInput) ae.getComponent().getParent();
	     ErrorHelpUtil.validate(input, getErrorMap());
	}
		 public ArrayList<com.iii.premia.common.bean.LovBean> lovUI_M_ACNT_CUST_CODE(
			    Object currValue) {
			ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
			ListItemUtil listitemutil = new ListItemUtil();
			try {
			   if("Y".equals(DUMMY_BEAN.getUI_M_POL_CASH_YN())){
			   // P_CALL_LOV('DUMMY.M_ACNT_CUST_CODE','CASH',:DUMMY.M_POL_DIVN_CODE,'CASH');
			       suggestionList = listitemutil.P_CALL_LOV("PILP003_APAC",
				  "DUMMY", "M_ACNT_CUST_CODE", "CASH", DUMMY_BEAN.getUI_M_POL_DIVN_CODE() ,
				  "CASH", null, null,  (String) currValue);
			   }
			   else{
			       suggestionList = listitemutil.P_CALL_LOV("PILP003_APAC",
					  "DUMMY", "M_ACNT_CUST_CODE", "CUSTOMER", DUMMY_BEAN.getUI_M_POL_DIVN_CODE() ,
					  "CUSTOMER", null, null,  (String) currValue);
			       //P_CALL_LOV('DUMMY.M_ACNT_CUST_CODE','CUSTOMER',:DUMMY.M_POL_DIVN_CODE,'CUSTOMER');	
			   }
			} catch (Exception e) {
			    e.printStackTrace();
			}
			return suggestionList;
		    }
		 public ArrayList<com.iii.premia.common.bean.LovBean> lovUI_M_POL_NO(
			    Object currValue) {
			ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
			ListItemUtil listitemutil = new ListItemUtil();
			try {
			    suggestionList = listitemutil.P_CALL_LOV("PILP003_APAC",
					  "DUMMY", "M_POL_NO", null,null,
					 null, null, null,  (String) currValue);
			       //P_CALL_LOV('DUMMY.M_POL_NO');
	
			   
			} catch (Exception e) {
			    e.printStackTrace();
			}
			return suggestionList;
		    }
		public void validateUI_M_ACNT_CUST_CODE(FacesContext context, UIComponent component,
				Object value) throws ValidatorException {
			try {
				helper.pilp003_apac_dummy_m_acnt_cust_code_when_validate_item(DUMMY_BEAN);
				COMP_UI_M_POL_CUST_DESC.resetValue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
		}
		 
		public String pilp003_apac_dummy_m_but_ok_when_button_pressed(){
			String returnValue = null;
			DBProcedures dbProcedures = new DBProcedures();
			String M_LOAN_STATUS=null;
			ResultSet resultSetsql_C1 = null;
			Connection connection=null;
			String callingForm = null;
			/*Added by Ameen on 19-05-2017 as per gaurav sugg.*/
			String PILT024_callingForm = null;
			P9ILPK_INVEST_PREM_COLL p9ilpk_invest_prem_coll = new P9ILPK_INVEST_PREM_COLL();
			String planQry = "SELECT PLAN_TYPE,PROD_INTR_SAVINGS_YN FROM PT_IL_POLICY,PM_IL_PRODUCT,PM_IL_PLAN WHERE "
					+ "PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
			String PLAN_TYPE = null;
			String PROD_INTR_SAVINGS_YN = null;
			ResultSet rs = null;
			String M_SUCC = null;
			/*End*/
			try{
				connection = CommonUtils.getConnection();
				handler = new CRUDHandler();
				String sql_C1=PILP003_APAC_SQLConstants.OK_WHEN_BUTTON_PRESSED_sql_C1;
				Object[] object = {DUMMY_BEAN.getUI_M_POL_SYS_ID()};
				resultSetsql_C1 = handler.executeSelectStatement(sql_C1, connection, object);
				callingForm = (String)CommonUtils.getGlobalObject("GLOBAL.M_LOAN_CALLING_FORM");
				if(DUMMY_BEAN.getUI_M_POL_NO()!= null && DUMMY_BEAN.getUI_M_APPRV_DATE()!= null){
					if(DUMMY_BEAN.getUI_M_POL_NO()!= null){
						if(resultSetsql_C1.next()){
							M_LOAN_STATUS=resultSetsql_C1.getString(1);
							System.out.println("M_LOAN_STATUS: "+ M_LOAN_STATUS);
						}
						if(resultSetsql_C1!= null){
							System.out.println("inside 4");
							P9ILPK_PREM_COLL.P_CREATE_LOAN_RECS(connection,DUMMY_BEAN.getUI_M_POL_SYS_ID());
						}
						
						resultSetsql_C1.close();
						/*Added by Ameen on 19-05-2017 as per Gaurav sugg.*/
						PILT024_callingForm = (String)CommonUtils.getGlobalObject("CALLING_FORM");
						System.out.println("PILT024_callingForm ::" + PILT024_callingForm);
						if("PILT024".equalsIgnoreCase(PILT024_callingForm)){
							rs = new CRUDHandler().executeSelectStatement(planQry, CommonUtils.getConnection(),
												new Object[]{DUMMY_BEAN.getUI_M_POL_NO()});
							if(rs.next()){
								PLAN_TYPE = rs.getString(1);
								PROD_INTR_SAVINGS_YN = rs.getString(2);
							}
							System.out.println("PLAN_TYPE ::" + PLAN_TYPE + ":: PROD_INTR_SAVINGS_YN ::" + PROD_INTR_SAVINGS_YN);
						if(PLAN_TYPE != null && "H".equalsIgnoreCase(PLAN_TYPE) && PROD_INTR_SAVINGS_YN != null && "Y".equalsIgnoreCase(PROD_INTR_SAVINGS_YN)){
							p9ilpk_invest_prem_coll.APPROVE_PREM_COLL(
																	DUMMY_BEAN.getUI_M_PREM_GEN_YN(), 
																	DUMMY_BEAN.getUI_M_BROK_GEN_YN(),
																	DUMMY_BEAN.getUI_M_APPRV_DATE(),
																	"PILP014A",M_SUCC);
							}
							if("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_SUCC"))){
								ctrlBean = new ControlBean();
								ctrlBean.setM_COMM_DEL("C");
								if(!connection.getAutoCommit())
									connection.commit();
								ctrlBean.setM_COMM_DEL(null);
							}
						}else{/*End*/
						ArrayList<String> appList = dbProcedures.callP9ILPK_PREM_COLL_P_APPROVE_PREM_COLL(
								DUMMY_BEAN.getUI_M_POL_SYS_ID()+"", 
								DUMMY_BEAN.getUI_M_PREM_GEN_YN(), 
								DUMMY_BEAN.getUI_M_BROK_GEN_YN(), 
								CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_APPRV_DATE()), 
								CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_TRAN_DATE()), 
								"P", 
								DUMMY_BEAN.getUI_M_ACNT_CUST_CODE(), 
								"PILP003_APAC", 
								null);
						if(appList != null && appList.size() > 0) {
							CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", appList.get(0));
						}
						if("Y".equals(CommonUtils.getGlobalVariable("GLOBAL.M_SUCC"))){
							ctrlBean = new ControlBean();
							ctrlBean.setM_COMM_DEL("C");
							if(!connection.getAutoCommit())
								connection.commit();
							ctrlBean.setM_COMM_DEL(null);
						}
						//added for loan 
						if(callingForm!=null){
							if("PILT004".equals(callingForm)){
								return "PILT004_APPR_MAIN";
							}else{
								returnValue = navigate();
							}
						}
						returnValue = navigate();
						}
					}
				}
				setBlockFlag(true);
				setFormFlag(true);
				/*Added by Ameen on 19-05-2017 as per gaurav sugg. to approve investment premium collection*/
				if("PILT024".equalsIgnoreCase(PILT024_callingForm)){
					System.out.println("inside PILT024 calling form ::::::" + PILT024_callingForm);
					PILT024_COMPOSITE_ACTION PILT024_COMPOSITE_ACTION_BEAN = (PILT024_COMPOSITE_ACTION)getSession().getAttribute("PILT024_COMPOSITE_ACTION");
					PILT024_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put("current", "Approved Sucessfully");
					PILT024_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN().disableAllComponent(true);
					PILT024_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().disablefieldcomponents(true);
					returnValue = "PILT024_PT_IL_POLICY";
				}
				else{/*End*/
				PILT003_APAC_COMPOSITE_ACTION PILT003_APAC_COMPOSITE_ACTION_BEAN = (PILT003_APAC_COMPOSITE_ACTION)getSession().getAttribute("PILT003_APAC_COMPOSITE_ACTION");
				PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().setBlockFlag(true);
				if(PILT003_APAC_COMPOSITE_ACTION_BEAN!=null){
					System.out.println("INSIDE===========>");
					PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().getWarningMap().put("current", "Approved Sucessfully");
					PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().onLoad(null);
					PILT003_APAC_COMPOSITE_ACTION_BEAN.getPT_IL_PREM_COLL_ACTION_BEAN().setBlockFlag(true);
					getSession().setAttribute("PILT003_APAC_COMPOSITE_ACTION", PILT003_APAC_COMPOSITE_ACTION_BEAN);
				}
				}
			}catch(SQLException sqle){
				sqle.getErrorCode();
				getErrorMap().put("current", sqle.getMessage());
				getErrorMap().put("detail", sqle.getMessage());
				CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", "N");

			}catch(Exception e){
				e.printStackTrace();
				getErrorMap().put("current", e.getMessage());
				getErrorMap().put("detail", e.getMessage());
				CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", "N");
			} finally {
				try {
					if(!connection.getAutoCommit())
						connection.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection, FacesContext.getCurrentInstance(), 
						COMP_UI_M_BUT_OK.getId(),getErrorMap(), getWarningMap());
			}
			
			return returnValue;
		}
		
		/**
		 * Retrieves the HttpSession object
		 * @return	The HttpSession
		 */
		public static HttpSession getSession(){
			ExternalContext externalContext =null;
			HttpServletRequest request=null;
			HttpSession session=null;
			FacesContext context = null;

			context =FacesContext.getCurrentInstance();
			if(context != null){
				externalContext = context.getExternalContext();
				if (externalContext != null) {
					request = (HttpServletRequest) externalContext.getRequest();
					if (request != null) {
						session = request.getSession();
					}
				}
			}
			return session;
		}

	
		public String navigate() {
			 String navigate = null;
				setBlockFlag(true);
				setFormFlag(true);
				/*Added by Ameen on 19-05-2017 as per Gaurav sugg.*/
				if("PILT024".equalsIgnoreCase(CommonUtils.getGlobalObject("CALLING_FORM").toString())){
					//PILT024_COMPOSITE_ACTION PILT024_COMPOSITE_ACTION_BEAN = (PILT024_COMPOSITE_ACTION)getSession().getAttribute("PILT024_COMPOSITE_ACTION");
					//PILT024_COMPOSITE_ACTION_BEAN.getDUMMY_ACTION_BEAN().disableAllComponent(false);
					//PILT024_COMPOSITE_ACTION_BEAN.getPT_IL_POLICY_ACTION_BEAN().disablefieldcomponents(false);
					navigate = "PILT024_PT_IL_POLICY";
				}else{
					navigate = "success";
				}
				/*End*/
				/*modified by Ameen on 19-05-2017 as per Gaurav sugg.*/
			 //return "success";
				return navigate;
		 }
	 
	 public void selectionChanged(ActionEvent ae){
		UIInput input= (UIInput)ae.getComponent().getParent();
		if("N".equalsIgnoreCase((String)input.getSubmittedValue())){
			this.DUMMY_BEAN.setUI_M_BROK_GEN_YN("N");
			getCOMP_UI_M_BROK_GEN_YN().setSubmittedValue(null);
			getCOMP_UI_M_BROK_GEN_YN().setDisabled(true);
			
		}else if("Y".equalsIgnoreCase((String)input.getSubmittedValue())){
			getCOMP_UI_M_BROK_GEN_YN().setDisabled(false);
		}
	 }
	
	 
	 public void onLoad(PhaseEvent pe) {
		    try {
			if(isFormFlag()){
			    helper.pilp003_apac_when_new_form_instance(this,DUMMY_BEAN1);
			    setFormFlag(false);
			}
			  if (isBlockFlag()) {
			      helper.whenCreateRecord(DUMMY_BEAN);
			      helper.policyId(DUMMY_BEAN);
			      setBlockFlag(false); 
			  }
			  instantiateAllComponent();
		    } catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		    }
		}
	 

		/**
		 * Instantiates all components in PILP003_APAC_DUMMY_ACTION
		 */
		public void instantiateAllComponent(){
			// Instantiating HtmlInputText
			COMP_UI_M_POL_NO				 = new HtmlInputText();
			COMP_UI_M_ACNT_CUST_CODE			 = new HtmlInputText();
			COMP_UI_M_POL_CUST_DESC				 = new HtmlInputText();

			// Instantiating HtmlSelectOneMenu
			COMP_UI_M_PREM_GEN_YN				 = new HtmlSelectOneMenu();
			COMP_UI_M_BROK_GEN_YN				 = new HtmlSelectOneMenu();

			// Instantiating HtmlCalendar
			COMP_UI_M_APPRV_DATE				 = new HtmlCalendar();

			// Instantiating HtmlCommandButton
			COMP_UI_M_BUT_OK				 = new HtmlCommandButton();
			COMP_UI_M_BUT_CANCEL				 = new HtmlCommandButton();
			COMP_UI_M_BUT_POL_LOV				 = new HtmlCommandButton();
			COMP_UI_M_BUT_ACNT_CUST_CODE			 = new HtmlCommandButton();

		}


}
