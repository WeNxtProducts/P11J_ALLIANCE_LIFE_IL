package com.iii.pel.forms.PILQ101;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_PREM_COLL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_POLICY_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_CUST_CODE_LABEL;

	private HtmlInputText COMP_POL_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_NAME;

	private HtmlOutputLabel COMP_POL_CONT_CODE_LABEL;

	private HtmlInputText COMP_POL_CONT_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POL_ASSURED_NAME;

	private HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL;

	private HtmlInputText COMP_POL_ASSRD_REF_ID1;

	private HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL;

	private HtmlInputText COMP_POL_ASSRD_REF_ID2;

	//added
	private HtmlOutputLabel COMP_M_REINST_CODE_LABEL;

	private HtmlInputText COMP_M_REINST_CODE;

	private HtmlOutputLabel COMP_M_REINSTMT_DT_LABEL;

	private HtmlCalendar COMP_M_REINSTMT_DT;

	private HtmlOutputLabel COMP_M_REINST_CHARGE_LABEL;

	private HtmlInputText COMP_M_REINST_CHARGE;

	private HtmlOutputLabel COMP_M_AVAI_DEPOSIT_LABEL;

	private HtmlInputText COMP_M_AVAI_DEPOSIT;

	private HtmlOutputLabel COMP_M_AMT_PAID_LABEL;

	private HtmlInputText COMP_M_AMT_PAID;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	private HtmlInputText COMP_M_TOT_REINS_LC_CHARGE;

	private HtmlOutputLabel COMP_M_AVAIL_LC_DEP_AMT_LABEL;

	private HtmlInputText COMP_M_AVAIL_LC_DEP_AMT;

	private HtmlInputText COMP_M_AVAIL_FC_DEP_AMT;

	private HtmlInputText COMP_UI_M_PC_FC_GROSS_PREM_SUM;

	private HtmlInputText COMP_UI_M_PC_LC_GROSS_PREM_SUM;

	private HtmlInputText COMP_UI_M_PC_FC_CHARGE_SUM;

	private HtmlInputText COMP_UI_M_PC_LC_CHARGE_SUM;

	private HtmlInputText COMP_M_NET_FC_PAID_AMT;

	private HtmlInputText COMP_M_NET_LC_PAID_AMT;

	private HtmlOutputLabel COMP_M_INTEREST_LABEL;

	private HtmlInputText COMP_M_INTEREST;

	List list = new ArrayList();
	
	P9ILPK_PREM_COLL p9ilpk_prem_coll=new P9ILPK_PREM_COLL();

	List<PT_IL_POLICY> BeanList_policy = new ArrayList<PT_IL_POLICY>();

	Map<String, Object> session;

	private UIDataTable datatable;

	private PT_IL_PREM_COLL_ACTION collectionAction;

	// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
	
	private PT_IL_POLICY_HELPER_ACTION helper;


	private PRINT_ACTION PRINT_ACTION_BEAN;

	public PRINT_ACTION getPRINT_ACTION_BEAN() {
		return PRINT_ACTION_BEAN;
	}

	public void setPRINT_ACTION_BEAN(PRINT_ACTION pRINT_ACTION_BEAN) {
		PRINT_ACTION_BEAN = pRINT_ACTION_BEAN;
	}

	
	/*End*/

	String rein_validate;

	public UIDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(UIDataTable datatable) {
		this.datatable = datatable;
	}

	public List<PT_IL_POLICY> getBeanList() {
		return BeanList_policy;
	}

	public void setBeanList(List<PT_IL_POLICY> BeanList_policy) {
		System.out.println("Set Bean List Called...."+BeanList_policy.size());
		BeanList_policy = BeanList_policy;
	}

	public HtmlOutputLabel getCOMP_M_REINST_CHARGE_LABEL() {
		return COMP_M_REINST_CHARGE_LABEL;
	}

	public void setCOMP_M_REINST_CHARGE_LABEL(
			HtmlOutputLabel comp_m_reinst_charge_label) {
		COMP_M_REINST_CHARGE_LABEL = comp_m_reinst_charge_label;
	}

	public HtmlInputText getCOMP_M_REINST_CHARGE() {
		return COMP_M_REINST_CHARGE;
	}

	public void setCOMP_M_REINST_CHARGE(HtmlInputText comp_m_reinst_charge) {
		COMP_M_REINST_CHARGE = comp_m_reinst_charge;
	}

	public HtmlOutputLabel getCOMP_M_AVAI_DEPOSIT_LABEL() {
		return COMP_M_AVAI_DEPOSIT_LABEL;
	}

	public void setCOMP_M_AVAI_DEPOSIT_LABEL(
			HtmlOutputLabel comp_m_avai_deposit_label) {
		COMP_M_AVAI_DEPOSIT_LABEL = comp_m_avai_deposit_label;
	}

	public HtmlInputText getCOMP_M_AVAI_DEPOSIT() {
		return COMP_M_AVAI_DEPOSIT;
	}

	public void setCOMP_M_AVAI_DEPOSIT(HtmlInputText comp_m_avai_deposit) {
		COMP_M_AVAI_DEPOSIT = comp_m_avai_deposit;
	}

	public HtmlOutputLabel getCOMP_M_AMT_PAID_LABEL() {
		return COMP_M_AMT_PAID_LABEL;
	}

	public void setCOMP_M_AMT_PAID_LABEL(HtmlOutputLabel comp_m_amt_paid_label) {
		COMP_M_AMT_PAID_LABEL = comp_m_amt_paid_label;
	}

	public HtmlInputText getCOMP_M_AMT_PAID() {
		return COMP_M_AMT_PAID;
	}

	public void setCOMP_M_AMT_PAID(HtmlInputText comp_m_amt_paid) {
		COMP_M_AMT_PAID = comp_m_amt_paid;
	}

	public PT_IL_POLICY_ACTION() {
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		BeanList_policy.add(new PT_IL_POLICY());
		collectionAction = new PT_IL_PREM_COLL_ACTION();
		PRINT_ACTION_BEAN = new PRINT_ACTION();
		helper=new PT_IL_POLICY_HELPER_ACTION();
		PRINT_ACTION_BEAN.compositeAction=this;
		/*Added by saritha ON 14-Feb-2017 for instantiateAllComponent added ssp call id ZBILQC-1719657 */
		instantiateAllComponent();
		/*End*/
	}

	public HtmlOutputLabel getCOMP_POL_NO_LABEL() {
		return COMP_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_NO() {
		return COMP_POL_NO;
	}

	public void setCOMP_POL_NO_LABEL(HtmlOutputLabel COMP_POL_NO_LABEL) {
		this.COMP_POL_NO_LABEL = COMP_POL_NO_LABEL;
	}

	public void setCOMP_POL_NO(HtmlInputText COMP_POL_NO) {
		this.COMP_POL_NO = COMP_POL_NO;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CODE_LABEL() {
		return COMP_POL_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_CODE() {
		return COMP_POL_CUST_CODE;
	}

	public void setCOMP_POL_CUST_CODE_LABEL(HtmlOutputLabel COMP_POL_CUST_CODE_LABEL) {
		this.COMP_POL_CUST_CODE_LABEL = COMP_POL_CUST_CODE_LABEL;
	}

	public void setCOMP_POL_CUST_CODE(HtmlInputText COMP_POL_CUST_CODE) {
		this.COMP_POL_CUST_CODE = COMP_POL_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_NAME_LABEL() {
		return COMP_UI_M_POL_CUST_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_NAME() {
		return COMP_UI_M_POL_CUST_NAME;
	}

	public void setCOMP_UI_M_POL_CUST_NAME_LABEL(HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL) {
		this.COMP_UI_M_POL_CUST_NAME_LABEL = COMP_UI_M_POL_CUST_NAME_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_NAME(HtmlInputText COMP_UI_M_POL_CUST_NAME) {
		this.COMP_UI_M_POL_CUST_NAME = COMP_UI_M_POL_CUST_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_CONT_CODE_LABEL() {
		return COMP_POL_CONT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CONT_CODE() {
		return COMP_POL_CONT_CODE;
	}

	public void setCOMP_POL_CONT_CODE_LABEL(HtmlOutputLabel COMP_POL_CONT_CODE_LABEL) {
		this.COMP_POL_CONT_CODE_LABEL = COMP_POL_CONT_CODE_LABEL;
	}

	public void setCOMP_POL_CONT_CODE(HtmlInputText COMP_POL_CONT_CODE) {
		this.COMP_POL_CONT_CODE = COMP_POL_CONT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_ASSURED_NAME_LABEL() {
		return COMP_UI_M_POL_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_ASSURED_NAME() {
		return COMP_UI_M_POL_ASSURED_NAME;
	}

	public void setCOMP_UI_M_POL_ASSURED_NAME_LABEL(HtmlOutputLabel COMP_UI_M_POL_ASSURED_NAME_LABEL) {
		this.COMP_UI_M_POL_ASSURED_NAME_LABEL = COMP_UI_M_POL_ASSURED_NAME_LABEL;
	}

	public void setCOMP_UI_M_POL_ASSURED_NAME(HtmlInputText COMP_UI_M_POL_ASSURED_NAME) {
		this.COMP_UI_M_POL_ASSURED_NAME = COMP_UI_M_POL_ASSURED_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID1_LABEL() {
		return COMP_POL_ASSRD_REF_ID1_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSRD_REF_ID1() {
		return COMP_POL_ASSRD_REF_ID1;
	}

	public void setCOMP_POL_ASSRD_REF_ID1_LABEL(HtmlOutputLabel COMP_POL_ASSRD_REF_ID1_LABEL) {
		this.COMP_POL_ASSRD_REF_ID1_LABEL = COMP_POL_ASSRD_REF_ID1_LABEL;
	}

	public void setCOMP_POL_ASSRD_REF_ID1(HtmlInputText COMP_POL_ASSRD_REF_ID1) {
		this.COMP_POL_ASSRD_REF_ID1 = COMP_POL_ASSRD_REF_ID1;
	}

	public HtmlOutputLabel getCOMP_POL_ASSRD_REF_ID2_LABEL() {
		return COMP_POL_ASSRD_REF_ID2_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSRD_REF_ID2() {
		return COMP_POL_ASSRD_REF_ID2;
	}

	public void setCOMP_POL_ASSRD_REF_ID2_LABEL(HtmlOutputLabel COMP_POL_ASSRD_REF_ID2_LABEL) {
		this.COMP_POL_ASSRD_REF_ID2_LABEL = COMP_POL_ASSRD_REF_ID2_LABEL;
	}

	public void setCOMP_POL_ASSRD_REF_ID2(HtmlInputText COMP_POL_ASSRD_REF_ID2) {
		this.COMP_POL_ASSRD_REF_ID2 = COMP_POL_ASSRD_REF_ID2;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}
	public HtmlOutputLabel getCOMP_M_REINST_CODE_LABEL() {
		return COMP_M_REINST_CODE_LABEL;
	}

	public void setCOMP_M_REINST_CODE_LABEL(HtmlOutputLabel comp_m_reinst_code_label) {
		COMP_M_REINST_CODE_LABEL = comp_m_reinst_code_label;
	}

	public HtmlInputText getCOMP_M_REINST_CODE() {
		return COMP_M_REINST_CODE;
	}

	public void setCOMP_M_REINST_CODE(HtmlInputText comp_m_reinst_code) {
		COMP_M_REINST_CODE = comp_m_reinst_code;
	}

	public HtmlOutputLabel getCOMP_M_REINSTMT_DT_LABEL() {
		return COMP_M_REINSTMT_DT_LABEL;
	}

	public void setCOMP_M_REINSTMT_DT_LABEL(HtmlOutputLabel comp_m_reinstmt_dt_label) {
		COMP_M_REINSTMT_DT_LABEL = comp_m_reinstmt_dt_label;
	}

	public HtmlCalendar getCOMP_M_REINSTMT_DT() {
		return COMP_M_REINSTMT_DT;
	}

	public void setCOMP_M_REINSTMT_DT(HtmlCalendar COMP_M_REINSTMT_DT) {
		this.COMP_M_REINSTMT_DT = COMP_M_REINSTMT_DT;
	}



	public HtmlInputText getCOMP_M_TOT_REINS_LC_CHARGE() {
		return COMP_M_TOT_REINS_LC_CHARGE;
	}

	public void setCOMP_M_TOT_REINS_LC_CHARGE(
			HtmlInputText COMP_M_TOT_REINS_LC_CHARGE) {
		this.COMP_M_TOT_REINS_LC_CHARGE = COMP_M_TOT_REINS_LC_CHARGE;
	}


	public HtmlOutputLabel getCOMP_M_AVAIL_LC_DEP_AMT_LABEL() {
		return COMP_M_AVAIL_LC_DEP_AMT_LABEL;
	}

	public void setCOMP_M_AVAIL_LC_DEP_AMT_LABEL(HtmlOutputLabel COMP_M_AVAIL_LC_DEP_AMT_LABEL) {
		this.COMP_M_AVAIL_LC_DEP_AMT_LABEL = COMP_M_AVAIL_LC_DEP_AMT_LABEL;
	}

	public HtmlInputText getCOMP_M_AVAIL_LC_DEP_AMT() {
		return COMP_M_AVAIL_LC_DEP_AMT;
	}

	public void setCOMP_M_AVAIL_LC_DEP_AMT(HtmlInputText COMP_M_AVAIL_LC_DEP_AMT) {
		this.COMP_M_AVAIL_LC_DEP_AMT = COMP_M_AVAIL_LC_DEP_AMT;
	}

	public HtmlInputText getCOMP_M_AVAIL_FC_DEP_AMT() {
		return COMP_M_AVAIL_FC_DEP_AMT;
	}

	public void setCOMP_M_AVAIL_FC_DEP_AMT(HtmlInputText COMP_M_AVAIL_FC_DEP_AMT) {
		this.COMP_M_AVAIL_FC_DEP_AMT = COMP_M_AVAIL_FC_DEP_AMT;
	}

	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	Connection con=null;
	ResultSet rs;
	ResultSet rs1;
	ResultSet rs2;
	ResultSet rs3;
	ResultSet rs4;
	ResultSet rs5;
	ResultSet rs6;
	ResultSet rs7;
	ResultSet rs8;
	ResultSet rs9;
	ResultSet rs10;
	ResultSet rs11;
	ResultSet rs12;
	CommonUtils util= new CommonUtils();
	CRUDHandler handler=new CRUDHandler();

	Map sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();


	public String FORM_PRE_FORM() throws Exception{
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.preForm()-Inside");
		FacesContext facecon = FacesContext.getCurrentInstance();
		Connection connection= null;
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP_ACTION.preForm()");
		// SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);	
		session= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ControlBean ctrlBean = CommonUtils.getControlBean();
		String M_TITLE = ctrlBean.getM_USER_ID()+" "+ctrlBean.getM_SCR_NAME()+" "+new Date();
		System.out.println("M_TITLE Value Isssssssss" + M_TITLE);
		try {
			connection = util.getConnection();
			System.out.println("cONNECTION iS----CONNECCCCCC" + connection );
		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return null;
	}	

	/*	public void STD_PRE_FORM(){
		createCtrlBean();
		ctrlBean = getCtrlBean();
		Map<String, Object> session = getSession();
		ctrlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		ctrlBean.setM_USER_ID((String)session.get("GLOBAL.M_USER_ID"));
		ctrlBean.setM_SCR_NAME(((String)session.get("GLOBAL.M_NAME")).substring(30, 42));
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		ctrlBean.setM_LANG_CODE((String)session.get("GLOBAL.M_LANG_CODE"));
		ctrlBean.setM_COMP_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(0,3));
		ctrlBean.setM_DIVN_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		System.out.println("DUMMY_ACTION.STD_PRE_FORM(!!!! ) "+(String)session.get("GLOBAL.M_DFLT_VALUES"));
		ctrlBean.setM_DEPT_CODE(((String)session.get("GLOBAL.M_DFLT_VALUES")).substring(9,11));

		putCtrlBean(ctrlBean);
		System.out.println("PT_IL_RI_DETL_ACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());

	}*/

	public void WHEN_CREATE_RECORD(){
		LOAD_DFLT_VALUES();

	}
	public void LOAD_DFLT_VALUES(){

	}

	public void WHEN_NEW_RECORD_INSTANCE(){

	}

	public void FORM_PRE_COMMIT(){
		STD_PRE_COMMIT();
	}

	public String nvl(String str, String str1)
	{
		if(str == null || str.trim().isEmpty())
			return str1;
		else
			return str;
	}

	public int nvl(int str, int str1)
	{
		if(str != -1)
			return str;
		else
			return str1;
	}

	private void STD_PRE_COMMIT() {
		System.out.println("PM_ILPILOCY_ACTION.STD_PRE_COMMIT()");
		String M_COMM_DEL = (String)CommonUtils.getControlBean().getM_COMM_DEL();
		String N_COMM_DEL =  nvl(M_COMM_DEL,"X");
		if( N_COMM_DEL.equals("C") || N_COMM_DEL.equals("P") || N_COMM_DEL.equals("D")) {  
			//GET_ALERT_MSG('09',M_MESSAGE);
			//DISP_ALERT(M_MESSAGE);
			//RAISE FORM_TRIGGER_FAILURE;
			//END IF;
		}
	}

	/*public void POST_QUERY(FacesContext context,	
	UIComponent component, Object value) throws ValidatorException {*/
	public void POST_QUERY(ActionEvent actionEvent)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			//UIInput input = (UIInput) actionEvent.getComponent().getParent();
			String pol_no = (String) value;
			// Instantiation of bean to avoid old value conflictions
			PT_IL_POLICY_BEAN = new PT_IL_POLICY();
			PT_IL_POLICY_BEAN.setPOL_NO(pol_no);
			//String pol_no=(String)getCOMP_POL_NO().getSubmittedValue();
			
			/*Modified by Janani on 25.01.2018 for APL issue, as per Gaurav suggestion*/
			/*String sql_query1="SELECT POL_SYS_ID,POL_CUST_CODE,POL_CONT_CODE ,POL_ASSRD_REF_ID1, POL_ASSRD_REF_ID2,POL_STATUS "
					+"FROM PT_IL_POLICY WHERE POL_NO =?";*/
			
			String sql_query1="SELECT POL_SYS_ID,POL_CUST_CODE,POL_CONT_CODE ,POL_ASSRD_REF_ID1, POL_ASSRD_REF_ID2,POL_STATUS,POL_ADDL_STATUS "
					+"FROM PT_IL_POLICY WHERE POL_NO =?";
			
			/*End of */
			
			
			// String sql_query1="SELECT POL_CUST_CODE,POL_CONT_CODE,POL_ASSRD_REF_ID1,POL_ASSRD_REF_ID2 FROM (SELECT PT_IL_POLICY.*, ROWNUM r FROM PT_IL_POLICY)WHERE r <=1 AND r >=1 and POL_NO='"+pol_no+"'";
			rs1 = handler.executeSelectStatement(sql_query1, 
					util.getConnection(), 
					new Object[]{pol_no});

			if (rs1.next()){
				//if(rs.first()){
				
				//if("L".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())){
				PT_IL_POLICY_BEAN.setPOL_STATUS(rs1.getString("POL_STATUS"));
				
				/*Added by Janani on 25.01.2018 for APL issue,as per Gaurav suggestion*/
				PT_IL_POLICY_BEAN.setPOL_ADDL_STATUS(rs1.getString("POL_ADDL_STATUS"));
				
				/*End */
				
				System.out.println("POL_CUST_CODE value is "+rs1.getString("POL_CUST_CODE"));
				PT_IL_POLICY_BEAN.setPOL_CUST_CODE(rs1.getString("POL_CUST_CODE"));
				PT_IL_POLICY_BEAN.setPOL_CONT_CODE(rs1.getString("POL_CONT_CODE"));
				PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID1(rs1.getString("POL_ASSRD_REF_ID1"));
				PT_IL_POLICY_BEAN.setPOL_ASSRD_REF_ID2(rs1.getString("POL_ASSRD_REF_ID2"));
				
				System.out.println(PT_IL_POLICY_BEAN.getPOL_STATUS());
				PT_IL_POLICY_BEAN.setPOL_SYS_ID(rs1.getLong("POL_SYS_ID"));
				
			
				// Reset components
				getCOMP_POL_CUST_CODE().resetValue();
				getCOMP_POL_CONT_CODE().resetValue();
				getCOMP_POL_ASSRD_REF_ID1().resetValue();
				getCOMP_POL_ASSRD_REF_ID2().resetValue();
				
				/*
				 * MODIFIED BY AMEEN ON 27-11-2017 TO PASS REIN END. FOR PAIDUP POLICY
				 * if(!("L".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS())))
				{
					throw new Exception("It is not a Lapsed Policy");
				}*/
				/*Added by ganesh on 25-01-2018 as suggested by gaurav */
				if(!CommonUtils.isIN(PT_IL_POLICY_BEAN.getPOL_STATUS(), "L","P") )
				{
					if(!("PUP".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_ADDL_STATUS()) && "A".equalsIgnoreCase(PT_IL_POLICY_BEAN.getPOL_STATUS()))){
					throw new Exception("It is not a Lapsed Policy");
					}
				}
			}
			rs1.close();			
				/*System.out.println("inside the if conf=dituon");
				throw new Exception("it is not lapsed policy");
			}*/

			String sql_query2 = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE =? ";
			rs2 = handler.executeSelectStatement(sql_query2, 
					util.getConnection(),
					new Object[]{PT_IL_POLICY_BEAN.getPOL_CUST_CODE()});
			if(rs2.next()){
				PT_IL_POLICY_BEAN.setUI_M_POL_CUST_NAME(rs2.getString("CUST_NAME"));
				getCOMP_UI_M_POL_CUST_NAME().resetValue();
			}
			rs2.close();

			String sql_query3="SELECT CONT_NAME,CONT_LC_POL_DEP_AMT,CONT_LC_POL_UTIL_AMT FROM PM_IL_CONTRACTOR "
					+ " WHERE CONT_CODE =? ";
			rs3 = handler.executeSelectStatement(sql_query3, 
					util.getConnection(), 
					new Object[]{PT_IL_POLICY_BEAN.getPOL_CONT_CODE()});
			if(rs3.next()){
				PT_IL_POLICY_BEAN.setUI_M_POL_ASSURED_NAME(rs3.getString("CONT_NAME"));
				if(rs3.getObject("CONT_LC_POL_DEP_AMT") != null){
					PT_IL_POLICY_BEAN.setUI_M_CONT_LC_POL_DEP_AMT(rs3.getDouble("CONT_LC_POL_DEP_AMT"));
				}
				if(rs3.getObject("CONT_LC_POL_UTIL_AMT") != null){
					PT_IL_POLICY_BEAN.setUI_M_CONT_LC_POL_UTIL_AMT(rs3.getDouble("CONT_LC_POL_UTIL_AMT"));
				}

				getCOMP_UI_M_POL_ASSURED_NAME().resetValue();
			}
			rs3.close();


			String sql_query4="SELECT DS_CODE FROM PM_IL_DOC_SETUP WHERE DS_TYPE = 3 AND DS_END_TYPE = '006'";
			rs4 = handler.executeSelectStatement(sql_query4, util.getConnection());
			if(rs4.next()){
				PT_IL_POLICY_BEAN.setUI_M_REINST_CODE(rs4.getString("DS_CODE"));
				getCOMP_M_REINST_CODE().resetValue();
			}
			rs4.close();

			String sql_query5 = "SELECT DDCHG_RATE,DDCHG_CUST_SHARE_PERC FROM PM_IL_DOC_DFLT_CHARGE WHERE" +
					" DDCHG_DS_CODE = ? ";
			rs5 = handler.executeSelectStatement(sql_query5, 
					util.getConnection(), 
					new Object[]{PT_IL_POLICY_BEAN.getUI_M_REINST_CODE()});
			Double M_TOT_REINS_LC_CHARGE = 0.0;
			while(rs5.next()){
				if(rs5.getObject("DDCHG_RATE") != null){
					PT_IL_POLICY_BEAN.setUI_M_DDCHG_RATE(rs5.getDouble("DDCHG_RATE"));
				}
				if(rs5.getObject("DDCHG_CUST_SHARE_PERC") != null){
					PT_IL_POLICY_BEAN.setUI_M_DDCHG_CUST_SHARE_PERC(rs5.getDouble("DDCHG_CUST_SHARE_PERC"));
				}

				Double chgRate = PT_IL_POLICY_BEAN.getUI_M_DDCHG_RATE();
				Double sharePerc = PT_IL_POLICY_BEAN.getUI_M_DDCHG_CUST_SHARE_PERC();

				if(PT_IL_POLICY_BEAN.getUI_M_DDCHG_RATE() != null 
						&& PT_IL_POLICY_BEAN.getUI_M_DDCHG_CUST_SHARE_PERC() != null){ 

					Double M_DFLT_PERC_CHARGE = (Double)(chgRate/100)*sharePerc;
					M_TOT_REINS_LC_CHARGE=MigratingFunctions.nvl(M_TOT_REINS_LC_CHARGE,0);
					Double Result_Lc_Charge  = M_TOT_REINS_LC_CHARGE + M_DFLT_PERC_CHARGE;
					Double Lc_Charge_Result =MigratingFunctions.nvl(Result_Lc_Charge,0);

					//M_TOT_REINS_LC_CHARGE=(nvl(M_TOT_REINS_LC_CHARGE,0))+M_DFLT_PERC_CHARGE;
					PT_IL_POLICY_BEAN.setUI_M_REINST_CHARGE(M_DFLT_PERC_CHARGE);
					PT_IL_POLICY_BEAN.setUI_M_TOT_REINS_LC_CHARGE(Lc_Charge_Result);
					PT_IL_POLICY_BEAN.setResult_Lc_Charge(Result_Lc_Charge);

					getCOMP_M_REINST_CHARGE().resetValue();
					getCOMP_M_TOT_REINS_LC_CHARGE().resetValue();
				}
			}
			rs5.close();

			Double Tot_Rein_Lc_Charge_Bean = PT_IL_POLICY_BEAN.getUI_M_TOT_REINS_LC_CHARGE();
			Double Rein_Lc_Charge_Nvl = CommonUtils.nvl(Tot_Rein_Lc_Charge_Bean, 0);
			PT_IL_POLICY_BEAN.setUI_M_REINS_LC_CHARGE(Rein_Lc_Charge_Nvl);

			String sql_query6= "SELECT POL_CUST_EXCH_RATE FROM PT_IL_POLICY WHERE  POL_NO =? ";
			rs6 = handler.executeSelectStatement(sql_query6, 
					util.getConnection(),
					new Object[]{pol_no});
			if(rs6.next()){
				if(rs6.getObject("POL_CUST_EXCH_RATE") != null){
					PT_IL_POLICY_BEAN.setPOL_CUST_EXCH_RATE(rs6.getDouble("POL_CUST_EXCH_RATE"));
				}
			}
			Double Lc_charge_Res = PT_IL_POLICY_BEAN.getResult_Lc_Charge();
			Double Lc_Cust_Exchange_Rate_Bean = PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();
			Double Lc_charge_Res1 = CommonUtils.nvl(Lc_charge_Res,0);
			Double Lc_Cust_Exchange_Rate = CommonUtils.nvl(Lc_Cust_Exchange_Rate_Bean,1);
			Double M_REINS_FC_CHARGE = Lc_charge_Res1/Lc_Cust_Exchange_Rate;
			PT_IL_POLICY_BEAN.setUI_M_REINS_FC_CHARGE(M_REINS_FC_CHARGE);
			// :DUMMY.M_REINS_FC_CHARGE  := NVL(M_TOT_REINS_LC_CHARGE,0)/NVL(M_POL_CUST_EXCH_RATE,1);
			// :CTRL.M_CUST_EXCH_RATE := NVL(M_POL_CUST_EXCH_RATE,1);
			rs6.close();

			Double Cont_Lc_Pol_Dep_Amt_Bean = PT_IL_POLICY_BEAN.getUI_M_CONT_LC_POL_DEP_AMT();
			Double Cont_Lc_Pol_Util_Amt_Bean = PT_IL_POLICY_BEAN.getUI_M_CONT_LC_POL_UTIL_AMT();
			if(Cont_Lc_Pol_Dep_Amt_Bean != null && Cont_Lc_Pol_Util_Amt_Bean != null ){
				Double M_AVAIL_LC_AMT = Cont_Lc_Pol_Dep_Amt_Bean - Cont_Lc_Pol_Util_Amt_Bean;
				if(M_AVAIL_LC_AMT != null && Lc_Cust_Exchange_Rate_Bean != null){
					Double M_AVAIL_FC_DEP_AMT = M_AVAIL_LC_AMT/Lc_Cust_Exchange_Rate_Bean;
					PT_IL_POLICY_BEAN.setUI_M_AVAIL_FC_DEP_AMT(M_AVAIL_FC_DEP_AMT);
				}
				PT_IL_POLICY_BEAN.setUI_M_AVAIL_LC_DEP_AMT(M_AVAIL_LC_AMT);
			}
			if(PT_IL_POLICY_BEAN.getUI_M_AVAIL_FC_DEP_AMT() != null){
				getCOMP_M_AVAIL_FC_DEP_AMT().resetValue();
			}
			if(PT_IL_POLICY_BEAN.getUI_M_AVAIL_LC_DEP_AMT()!= null){
				getCOMP_M_AVAIL_LC_DEP_AMT().resetValue();
			}
			//calcUnpaidInterest();
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POST", e.getMessage());
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
			
		}
	}

	public String format_Date(java.util.Date date){
		String result=null; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = (String)sdf.format(date);
		System.out.println("Formatted Date is = "+result);
		return result;
	}





	public void POST_QUERY_SUM(){
		System.out.println("PT_IL_POLICY_ACTION.POST_QUERY_SUM()"); 

		FacesContext context = FacesContext.getCurrentInstance();
		ArrayList<OracleParameter> listUnpaid = new ArrayList<OracleParameter>();
		Double m_tot=0.0;
		try{

			/*System.out.println("getCOMP_M_REINST_CODE().getSubmittedValue().toString"+(String)getCOMP_M_REINST_CODE().getSubmittedValue());

				if(getCOMP_M_REINST_CODE().getSubmittedValue().equals("")&&getCOMP_M_REINST_CODE().getSubmittedValue()!=null){

					String msg=getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object [] {"Enter the valid Endorsement Code"}).getDetail());
					System.out.println("msg is "+msg);
				}else{*/

			String Pt_Pol_No=PT_IL_POLICY_BEAN.getPOL_NO();
			System.out.println("Pt_Pol_No   --->"+Pt_Pol_No);
			
			Date Reinstate_Date=(Date)getCOMP_M_REINSTMT_DT().getValue();
			String Reinstate_Date_Format = format_Date(Reinstate_Date);
			/*  This query is taking for single record from DB*/
			/*
			 * query modified by Ameen on 24-11-2017 to put REIN. end. for paid up policies
			 * String sql_query7="SELECT MIN(PC_SCHD_PYMT_DT),MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL " +
					"WHERE  PC_PAID_FLAG = 'N' AND PC_SCHD_PYMT_DT <= '"+Reinstate_Date_Format+"' " +
					"AND PC_POL_SYS_ID IN(SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE  POL_NO = '"+Pt_Pol_No+"')";*/
			String sql_query7="SELECT MIN(PC_SCHD_PYMT_DT),MAX(PC_SCHD_PYMT_DT) FROM PT_IL_PREM_COLL " +
					"WHERE  NVL(PC_PAID_FLAG,'N') <> 'A' AND PC_SCHD_PYMT_DT <= '"+Reinstate_Date_Format+"' " +
					"AND PC_POL_SYS_ID IN(SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE  POL_NO = '"+Pt_Pol_No+"')";
			System.out.println("sql_query7 is "+sql_query7);
			rs7 = handler.executeSelectStatement(sql_query7, util.getConnection());
			if(rs7.next()){
				String Min_Date=rs7.getString("MIN(PC_SCHD_PYMT_DT)");

				Date min_db_date = rs7.getDate("MIN(PC_SCHD_PYMT_DT)");
				Date max_db_date =rs7.getDate("MAX(PC_SCHD_PYMT_DT)");

				System.out.println("PT_IL_POLICY_ACTION.POST_QUERY_SUM()" +min_db_date);
				/*System.out.println("The Min_Date is "+Min_Date);
			          DateFormat formatter ; 
			           formatter = new SimpleDateFormat("dd-MM-yy");
		Date dt_fr_Db = (Date)formatter.parse(Min_Date);
		System.out.println("After Parsing Date "+dt_fr_Db);*/
				PT_IL_POLICY_BEAN.setUI_M_MIN_PC_SCHD_PYMT_DT(min_db_date);
				PT_IL_POLICY_BEAN.setUI_M_MAX_PC_SCHD_PYMT_DT(max_db_date);
				System.out.println("the min date is "+PT_IL_POLICY_BEAN.getUI_M_MIN_PC_SCHD_PYMT_DT());
				System.out.println("the max date is "+PT_IL_POLICY_BEAN.getUI_M_MAX_PC_SCHD_PYMT_DT());
			}
			rs7.close();



			Date M_REINSTMT_DT=(Date)getCOMP_M_REINSTMT_DT().getValue();
			System.out.println("M_REINSTMT_DT is "+M_REINSTMT_DT);
			String M_REINSTMT_DT_FORMAT = format_Date(M_REINSTMT_DT);
			System.out.println("PT_IL_POLICY_ACTION.POST_QUERY_SUM()"+ M_REINSTMT_DT_FORMAT);


			Date M_MAX_PC_SCHD_PYMT_DT=PT_IL_POLICY_BEAN.getUI_M_MAX_PC_SCHD_PYMT_DT();
			if(M_MAX_PC_SCHD_PYMT_DT != null){
				String M_MAX_PC_SCHD_PYMT_DT_FORMAT=format_Date(M_MAX_PC_SCHD_PYMT_DT);
				System.out.println("M_MAX_PC_SCHD_PYMT_DT is "+M_MAX_PC_SCHD_PYMT_DT);


				String sql_query8=" SELECT CEIL(MONTHS_BETWEEN(TO_DATE('"+M_REINSTMT_DT_FORMAT+"', 'DD-MON-YY')+1," +
						"TO_DATE('"+M_MAX_PC_SCHD_PYMT_DT_FORMAT+"', 'DD-MON-YY'))) MONTHS FROM DUAL";

				System.out.println("sql_query8 is "+sql_query8);
				rs8 = handler.executeSelectStatement(sql_query8, util.getConnection());
				if(rs8.next()){

					int  Months_Actual_Diff = rs8.getInt(1);
					PT_IL_POLICY_BEAN.setUI_M_MONTHS_ACTL_DIFF(Months_Actual_Diff);
					System.out.println("temp"+Months_Actual_Diff);
					System.out.println("Actual diff is "+PT_IL_POLICY_BEAN.getUI_M_MONTHS_ACTL_DIFF());
				}
				rs8.close();
			}
			Date M_MIN_PC_SCHD_PYMT_DT=PT_IL_POLICY_BEAN.getUI_M_MIN_PC_SCHD_PYMT_DT();
			if(M_MIN_PC_SCHD_PYMT_DT != null){
				String M_MIN_PC_SCHD_PYMT_DT_FORMAT=format_Date(M_MIN_PC_SCHD_PYMT_DT);

				String sql_query9="SELECT CEIL(MONTHS_BETWEEN(TO_DATE('"+M_REINSTMT_DT_FORMAT+"', 'DD-MON-YY')+1, " +
						"TO_DATE('"+M_MIN_PC_SCHD_PYMT_DT_FORMAT+"', 'DD-MON-YY'))) MONTHS FROM DUAL";

				System.out.println("sql_query9 is"+sql_query9);

				rs9 = handler.executeSelectStatement(sql_query9, util.getConnection());
				if(rs9.next()){

					int  Months_Diff = rs9.getInt(1);
					PT_IL_POLICY_BEAN.setUI_M_MONTHS_DIFF(Months_Diff);
					System.out.println("temp"+Months_Diff);
					System.out.println("Actual diff is "+PT_IL_POLICY_BEAN.getUI_M_MONTHS_DIFF());
				}
				rs8.close();
			}
			if(PT_IL_POLICY_BEAN.getPOL_SYS_ID() != null){
				Long Pol_Sys_Id = PT_IL_POLICY_BEAN.getPOL_SYS_ID();

				/*
				 * query modified by Ameen on 24-11-2017 to put REIN. end. for paid up policies
				 * String sql_query10= "SELECT ROWID,PT_IL_PREM_COLL.* FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = '"+Pol_Sys_Id+"' AND PC_PAID_FLAG = 'N' AND PC_SCHD_PYMT_DT <='"+M_REINSTMT_DT_FORMAT+"' AND ROWNUM<25";*/
				String sql_query10= "SELECT ROWID,PT_IL_PREM_COLL.* FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = '"+Pol_Sys_Id+"' AND NVL(PC_PAID_FLAG,'N') <> 'A' AND PC_SCHD_PYMT_DT <='"+M_REINSTMT_DT_FORMAT+"' AND ROWNUM<25";
				System.out.println("QueryQuery>>>" +sql_query10);                     
				list = handler.fetch(sql_query10, "com.iii.pel.forms.PILQ101.PT_IL_PREM_COLL",util.getConnection());
				System.out.println("list  ++++" +list.size());
			}
			ELResolver resolver = context.getApplication().getELResolver();
			PT_IL_PREM_COLL_ACTION actionBean= (PT_IL_PREM_COLL_ACTION)resolver.getValue(context.getELContext(), null, "PILQ101_PT_IL_PREM_COLL_ACTION");
			System.out.println("PT_IL_POLICY_ACTION.POST_QUERY_SUM()----1"+actionBean); 
			PT_IL_PREM_COLL valueBean = actionBean.getPT_IL_PREM_COLL_BEAN();
		
			if(list!= null && list.size() > 0 ){
				actionBean.setBeanList(list);
				// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
				for(int i=0;i<list.size();i++){
					String PC_FC_GROSS_PREM=actionBean.getBeanList().get(i).getPC_FC_GROSS_PREM().toString();
					String PC_LC_GROSS_PREM=actionBean.getBeanList().get(i).getPC_LC_GROSS_PREM().toString();
					String PC_FC_CHARG=actionBean.getBeanList().get(i).getPC_FC_CHARGE().toString();
					String PC_LC_CHARG=actionBean.getBeanList().get(i).getPC_LC_CHARGE().toString();
					actionBean.getBeanList().get(i).setUI_PC_FC_GROSS_PREM(CommonUtils.Decimal_Convert(PC_FC_GROSS_PREM));
					actionBean.getBeanList().get(i).setUI_PC_LC_GROSS_PREM(CommonUtils.Decimal_Convert(PC_LC_GROSS_PREM));
					actionBean.getBeanList().get(i).setUI_PC_FC_CHARGE(CommonUtils.Decimal_Convert(PC_FC_CHARG));
					actionBean.getBeanList().get(i).setUI_PC_LC_CHARGE(CommonUtils.Decimal_Convert(PC_LC_CHARG));
				}
				//End
				System.out.println("PT_IL_POLICY_ACTION.POST_QUERY_SUM(6666666)"+actionBean.getPT_IL_PREM_COLL_BEAN());
				//System.out.println("PT_IL_POLICY_ACTION.POST_QUERY_SUM()............."+actionBean.getBeanList().get(1).getROWID());
				valueBean.setPC_FC_GROSS_PREM(actionBean.getBeanList().get(0).getPC_FC_GROSS_PREM());
				valueBean.setPC_LC_GROSS_PREM(actionBean.getBeanList().get(0).getPC_LC_GROSS_PREM());
				valueBean.setPC_FC_CHARGE(actionBean.getBeanList().get(0).getPC_FC_CHARGE());
				valueBean.setPC_LC_CHARGE(actionBean.getBeanList().get(0).getPC_LC_CHARGE());
				// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
				String PC_FC_GROSS_PREM=valueBean.getPC_FC_GROSS_PREM().toString();
				String PC_LC_GROSS_PREM=valueBean.getPC_LC_GROSS_PREM().toString();
				String PC_FC_CHARG=valueBean.getPC_FC_CHARGE().toString();
				String PC_LC_CHARG=valueBean.getPC_LC_CHARGE().toString();
				valueBean.setUI_PC_FC_GROSS_PREM(CommonUtils.Decimal_Convert(PC_FC_GROSS_PREM));
				valueBean.setUI_PC_LC_GROSS_PREM(CommonUtils.Decimal_Convert(PC_LC_GROSS_PREM));
				valueBean.setUI_PC_FC_CHARGE(CommonUtils.Decimal_Convert(PC_FC_CHARG));
				valueBean.setUI_PC_LC_CHARGE(CommonUtils.Decimal_Convert(PC_LC_CHARG));
				/*End*/
				//valueBean.setUI_PC_FC_GROSS_PREM(valueBean.getPC_LC_CHARGE());
			}
			String sql_query11 =null;
			Object[] obj = {};
			if(PT_IL_POLICY_BEAN.getPOL_SYS_ID() != null){
				/*
				 * query modified by Ameen on 24-11-2017 to put REIN. end. for paid up policies
				 * sql_query11 = "SELECT PC_LC_GROSS_PREM,PC_FC_GROSS_PREM, " +
						"PC_LC_CHARGE, PC_FC_CHARGE "+     
						" FROM PT_IL_PREM_COLL "+
						" WHERE PC_POL_SYS_ID = ? "+
						" AND PC_PAID_FLAG='N' "+
						"AND PC_SCHD_PYMT_DT <= ? ";*/
				sql_query11 = "SELECT PC_LC_GROSS_PREM,PC_FC_GROSS_PREM, " +
						"PC_LC_CHARGE, PC_FC_CHARGE "+     
						" FROM PT_IL_PREM_COLL "+
						" WHERE PC_POL_SYS_ID = ? "+
						" AND NVL(PC_PAID_FLAG,'N')<>'A' "+
						"AND PC_SCHD_PYMT_DT <= ? ";
				obj = new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID(),PT_IL_POLICY_BEAN.getUI_M_REINSTMT_DT()}; 
			}else{
				sql_query11 = " SELECT GROSS_PREM, FC_GROSS,LC_CHARGE,FC_CHARGE FROM (" +
						" SELECT ROWID,PC_LC_GROSS_PREM GROSS_PREM,PC_FC_GROSS_PREM FC_GROSS," +
						" PC_LC_CHARGE LC_CHARGE,PC_FC_CHARGE FC_CHARGE FROM PT_IL_PREM_COLL WHERE " +
						" PC_PAID_FLAG = 'N' AND PC_SCHD_PYMT_DT <= ? )";
				obj = new Object[]{PT_IL_POLICY_BEAN.getUI_M_REINSTMT_DT()};
			}
			System.out.println("sql_query11 is"+sql_query11);

			rs10 = new CRUDHandler().executeSelectStatement(sql_query11, CommonUtils.getConnection(), obj);
			Double fcgrsprem = 0.0;
			Double lcgrsprem = 0.0;
			Double lcchrg = 0.0;
			Double fcchrg = 0.0;
			while(rs10.next()){
				/*PT_IL_POLICY_BEAN.setUI_M_PC_FC_GROSS_PREM_SUM(Double.parseDouble(rs10.getString("sum(fc_gross)")));
			PT_IL_POLICY_BEAN.setUI_M_PC_LC_GROSS_PREM_SUM(Double.parseDouble(rs10.getString("sum(gross_prem)")));*/		
				fcgrsprem = fcgrsprem + rs10.getDouble("PC_LC_GROSS_PREM");
				lcgrsprem = lcgrsprem + rs10.getDouble("PC_FC_GROSS_PREM");
				lcchrg = lcchrg + rs10.getDouble("PC_LC_CHARGE");
				fcchrg = fcchrg + rs10.getDouble("PC_FC_CHARGE");
			}
			CommonUtils.ROUND(fcchrg,2);
			CommonUtils.ROUND(lcchrg,2);
			CommonUtils.ROUND(fcgrsprem,2);
			CommonUtils.ROUND(lcgrsprem,2);

			valueBean.setUI_M_PC_FC_GROSS_PREM_SUM(fcgrsprem);
			// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
			System.out.println("valueBean.setUI_M_PC_FC_GROSS_PREM_SUM   :"+valueBean.getUI_M_PC_FC_GROSS_PREM_SUM());
			String FcGross=valueBean.getUI_M_PC_FC_GROSS_PREM_SUM().toString();
			CommonUtils.setGlobalVariable("GLOBAL.Global_FC_GROSS", FcGross);
			/*end*/
			valueBean.setUI_M_PC_LC_GROSS_PREM_SUM(lcgrsprem);
			valueBean.setUI_M_PC_LC_CHARGE_SUM(CommonUtils.ROUND(lcchrg,2));
			valueBean.setUI_M_PC_FC_CHARGE_SUM(CommonUtils.ROUND(fcchrg,2));
			/*Added by ganesh on 16-08-2017 for ZBILQC-1719657*/
			CommonUtils.setGlobalVariable("GLOBAL.FC_CHARGE_SUM", valueBean.getUI_M_PC_FC_CHARGE_SUM().toString());
			/*end*/
			//CommonUtils.ROUND(fcchrg, 2);
			Integer Month_Diff = 0;
			Integer Month_Actual = 0;
			if(PT_IL_POLICY_BEAN.getUI_M_MONTHS_ACTL_DIFF() != null){
				Month_Actual=PT_IL_POLICY_BEAN.getUI_M_MONTHS_ACTL_DIFF();
			}
			if(PT_IL_POLICY_BEAN.getUI_M_MONTHS_DIFF() != null){
				Month_Diff=PT_IL_POLICY_BEAN.getUI_M_MONTHS_DIFF();
			}
			Double Pc_Lc_Gross_Prem=valueBean.getPC_LC_GROSS_PREM();
			Double Pc_Lc_Gross_Prem_sum=valueBean.getUI_M_PC_LC_GROSS_PREM_SUM();
			Double Cust_Exch_Rate=PT_IL_POLICY_BEAN.getPOL_CUST_EXCH_RATE();
			Double Pc_Lc_Charge=valueBean.getPC_LC_CHARGE();

			if(Month_Actual != null && Month_Actual>=1){

				Double Lc_Extra_Tot_Amount=Month_Diff*Pc_Lc_Gross_Prem;
				Double Lc_Extra_Amount=Lc_Extra_Tot_Amount-Pc_Lc_Gross_Prem_sum;
				PT_IL_POLICY_BEAN.setLc_Extra_Amount(Lc_Extra_Amount);
				Double Fc_Extra_Amount=Lc_Extra_Amount/Cust_Exch_Rate;
				PT_IL_POLICY_BEAN.setFc_Extra_Amount(Fc_Extra_Amount);
				Double Lc_Extra_Charge= Month_Diff*Pc_Lc_Charge;
				PT_IL_POLICY_BEAN.setLc_Extra_Charge(Lc_Extra_Charge);
				Double Fc_Extra_Charge=Lc_Extra_Charge/Cust_Exch_Rate;
				PT_IL_POLICY_BEAN.setFc_Extra_Charge(Fc_Extra_Charge);
			}	

			Double Fc_Extra_Amount_Bean=PT_IL_POLICY_BEAN.getFc_Extra_Amount();
			Double Fc_Remdr_Nvl_Sum=MigratingFunctions.nvl(Fc_Extra_Amount_Bean,0);	
			valueBean.setUI_M_PC_FC_GROSS_PREM_REMDR_SUM(Fc_Remdr_Nvl_Sum);

			Double lc_Extra_Amount_Bean=PT_IL_POLICY_BEAN.getLc_Extra_Amount(); 
			Double Lc_Remdr_Nvl_Sum=MigratingFunctions.nvl(lc_Extra_Amount_Bean,0);
			valueBean.setUI_M_PC_LC_GROSS_PREM_REMDR_SUM(Lc_Remdr_Nvl_Sum);

			Double Fc_Extra_Charge_Bean=PT_IL_POLICY_BEAN.getFc_Extra_Charge();
			Double Fc_Charge_Remdr_Sum=MigratingFunctions.nvl(Fc_Extra_Charge_Bean,0);
			valueBean.setUI_M_PC_FC_CHARGE_REMDR_SUM(Fc_Charge_Remdr_Sum);

			Double Lc_Extra_Charge_Bean=PT_IL_POLICY_BEAN.getLc_Extra_Charge();
			Double Lc_Charge_Remdr_Sum=MigratingFunctions.nvl(Lc_Extra_Charge_Bean,0);
			valueBean.setUI_M_PC_LC_CHARGE_REMDR_SUM(Lc_Charge_Remdr_Sum);

			Double Fc_Gross_Prem_Sum_ValueBean=valueBean.getUI_M_PC_FC_GROSS_PREM_SUM();
			Double Fc_Gross_Prem_Sum_nvl=MigratingFunctions.nvl(Fc_Gross_Prem_Sum_ValueBean,0);

			Double Fc_Charge_Sum_ValueBean=valueBean.getUI_M_PC_FC_CHARGE_SUM();
			Double Fc_Charge_Sum_nvl=MigratingFunctions.nvl(Fc_Charge_Sum_ValueBean,0);

			Double Rein_Fc_Charge_Bean=PT_IL_POLICY_BEAN.getUI_M_REINS_FC_CHARGE();
			Double Rein_Fc_Charge_nvl=MigratingFunctions.nvl(Rein_Fc_Charge_Bean,0);

			Double Fc_Gross_Prem_Sum_Remdr_ValueBean=valueBean.getUI_M_PC_FC_GROSS_PREM_REMDR_SUM();
			Double Fc_Gross_Prem_Sum_Remdr_nvl=MigratingFunctions.nvl(Fc_Gross_Prem_Sum_Remdr_ValueBean,0);

			Double Fc_Charge_Remdr_Sum_ValueBean=valueBean.getUI_M_PC_FC_CHARGE_REMDR_SUM();
			Double Fc_Charge_Remdr_Sum_nvl=MigratingFunctions.nvl(Fc_Charge_Remdr_Sum_ValueBean,0);

			Double Avail_Fc_Amt_Bean=PT_IL_POLICY_BEAN.getUI_M_AVAIL_FC_DEP_AMT();
			Double Avail_Fc_Amt_nvl=MigratingFunctions.nvl(Avail_Fc_Amt_Bean,0);

			Double Net_Fc_Paid_Amt=Fc_Gross_Prem_Sum_nvl+Fc_Charge_Sum_nvl+Rein_Fc_Charge_nvl+Fc_Gross_Prem_Sum_Remdr_nvl+Fc_Charge_Remdr_Sum_nvl+Avail_Fc_Amt_nvl;
			PT_IL_POLICY_BEAN.setUI_M_NET_FC_PAID_AMT(Net_Fc_Paid_Amt);
			Double Net_Fc_Paid_Amt_Bean=PT_IL_POLICY_BEAN.getUI_M_NET_FC_PAID_AMT();	




			Double Net_Fc_Paid_Amt_Nvl=MigratingFunctions.nvl(Net_Fc_Paid_Amt_Bean,0);

			if(Net_Fc_Paid_Amt_Nvl<=0){
				Double Net_Fc_Paid_Amt_Set=0.0;
				PT_IL_POLICY_BEAN.setUI_M_NET_FC_PAID_AMT(Net_Fc_Paid_Amt_Set);
			}


			Double Lc_Gross_Prem_Sum_ValueBean=valueBean.getUI_M_PC_LC_GROSS_PREM_SUM();
			Double Lc_Gross_Prem_Sum_nvl=MigratingFunctions.nvl(Lc_Gross_Prem_Sum_ValueBean,0);

			Double Lc_Charge_Sum_ValueBean=valueBean.getUI_M_PC_LC_CHARGE_SUM();
			Double Lc_Charge_Sum_nvl=MigratingFunctions.nvl(Lc_Charge_Sum_ValueBean,0);

			Double Rein_Lc_Charge_Bean=PT_IL_POLICY_BEAN.getUI_M_REINS_LC_CHARGE();
			Double Rein_Lc_Charge_nvl=MigratingFunctions.nvl(Rein_Lc_Charge_Bean,0);

			Double Lc_Gross_Prem_Sum_Remdr_ValueBean=valueBean.getUI_M_PC_LC_GROSS_PREM_REMDR_SUM();
			Double Lc_Gross_Prem_Sum_Remdr_nvl=MigratingFunctions.nvl(Lc_Gross_Prem_Sum_Remdr_ValueBean,0);

			Double Lc_Charge_Remdr_Sum_ValueBean=valueBean.getUI_M_PC_LC_CHARGE_REMDR_SUM();
			Double Lc_Charge_Remdr_Sum_nvl=MigratingFunctions.nvl(Lc_Charge_Remdr_Sum_ValueBean,0);

			Double Avail_Lc_Amt_Bean=PT_IL_POLICY_BEAN.getUI_M_AVAIL_LC_DEP_AMT();
			Double Avail_Lc_Amt_nvl=MigratingFunctions.nvl(Avail_Lc_Amt_Bean,0);

			Double Net_Lc_Paid_Amt=Lc_Gross_Prem_Sum_nvl+Lc_Charge_Sum_nvl+Rein_Lc_Charge_nvl+Lc_Gross_Prem_Sum_Remdr_nvl+Lc_Charge_Remdr_Sum_nvl+Avail_Lc_Amt_nvl;
			Double netAmount=
					( CommonUtils.nvl(valueBean.getUI_M_PC_LC_GROSS_PREM_SUM(),0)
					+
					CommonUtils.nvl(valueBean.getUI_M_PC_LC_CHARGE_SUM(),0)
					+
					CommonUtils.nvl(PT_IL_POLICY_BEAN.getUI_M_REINS_LC_CHARGE(),0)
					+
					CommonUtils.nvl(PT_IL_POLICY_BEAN.getUI_M_INTEREST(),0)) - 
					(CommonUtils.nvl(PT_IL_POLICY_BEAN.getUI_M_AVAIL_LC_DEP_AMT(),0));
			CommonUtils.ROUND(netAmount, 2);
			PT_IL_POLICY_BEAN.setUI_M_NET_LC_PAID_AMT(CommonUtils.ROUND(netAmount,2));
			Double Net_Lc_Paid_Amt_Bean=PT_IL_POLICY_BEAN.getUI_M_NET_LC_PAID_AMT();	
			PT_IL_POLICY_BEAN.setUI_M_NET_FC_PAID_AMT(CommonUtils.ROUND(netAmount,2));

			Double Net_Lc_Paid_Amt_Nvl=MigratingFunctions.nvl(Net_Lc_Paid_Amt_Bean,0);

			if(Net_Lc_Paid_Amt_Nvl<=0){
				Double Net_Lc_Paid_Amt_Set=0.0;
				//	PT_IL_POLICY_BEAN.setUI_M_NET_FC_PAID_AMT(Net_Lc_Paid_Amt_Set);
			}
			
			/*Commentted by saritha on 14-Feb-2017 for Re-instatement Quotation(E-mail Trigger) ssp call id ZBILQC-1719657 */

		//	getCOMP_M_NET_FC_PAID_AMT().setSubmittedValue(String.valueOf(PT_IL_POLICY_BEAN.getUI_M_NET_FC_PAID_AMT()));
			//getCOMP_M_NET_LC_PAID_AMT().setSubmittedValue(String.valueOf(PT_IL_POLICY_BEAN.getUI_M_NET_LC_PAID_AMT()));
         //   System.out.println("netamt  --->"+getCOMP_M_NET_FC_PAID_AMT());
         //   System.out.println("netamt  --->"+getCOMP_M_NET_LC_PAID_AMT());
			
			/*End*/

			//			----------------------
			//:DUMMY.M_NET_FC_PAID_AMT := NVL(:PT_IL_PREM_COLL.M_PC_FC_GROSS_PREM_SUM,0)+
			//NVL(:PT_IL_PREM_COLL.M_PC_FC_CHARGE_SUM,0) + NVL(:DUMMY.M_REINS_FC_CHARGE,0) + 
			//NVL(:PT_IL_PREM_COLL.M_PC_FC_GROSS_PREM_REMDR_SUM,0) 
			/*+ NVL(:PT_IL_PREM_COLL.M_PC_FC_CHARGE_REMDR_SUM,0) - NVL(:DUMMY.M_AVAIL_FC_DEP_AMT,0);

IF NVL(:DUMMY.M_NET_FC_PAID_AMT,0) <= 0 THEN
	  :DUMMY.M_NET_FC_PAID_AMT := 0;
END IF;	  

:DUMMY.M_NET_LC_PAID_AMT := NVL(:PT_IL_PREM_COLL.M_PC_LC_GROSS_PREM_SUM,0)+ NVL(:PT_IL_PREM_COLL.M_PC_LC_CHARGE_SUM,0) 
+ NVL(:DUMMY.M_REINS_LC_CHARGE,0) + NVL(:PT_IL_PREM_COLL.M_PC_LC_GROSS_PREM_REMDR_SUM,0) 
+ NVL(:PT_IL_PREM_COLL.M_PC_FC_CHARGE_REMDR_SUM,0) - NVL(:DUMMY.M_AVAIL_LC_DEP_AMT,0);


IF NVL(:DUMMY.M_NET_LC_PAID_AMT,0) <= 0 THEN
	  :DUMMY.M_NET_LC_PAID_AMT 
			 */

			//	}
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("POST_SUM", e.getMessage());
		}

	}

	public void when_validate_rein_code(ActionEvent actionEvent){
		System.out.println("PT_IL_POLICY_ACTION.when_validate_rein_code()");
		String mappedBeanName="PILQ101_PT_IL_POLICY_ACTION";
		PT_IL_POLICY_ACTION actionBean=(PT_IL_POLICY_ACTION)util.getMappedBeanFromSession(mappedBeanName);
		Map<String, String> errMap = actionBean.getErrorMap();
		try{
			ResultSet rs_validate;
			String rein_codevalidate = (String)getCOMP_M_REINST_CODE().getSubmittedValue();
			if(rein_codevalidate.isEmpty()){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Value is Required");
				getErrorMap().put("CURRENT", "Value is Required" );
			}else{
				String sql_validate="SELECT 'X' FROM PM_IL_DOC_SETUP WHERE DS_TYPE = '3' AND " +
						"DS_END_TYPE = '006' AND DS_CODE ='"+rein_codevalidate+"'";
				System.out.println("sql_validate is "+sql_validate);
				rs_validate =handler.executeSelectStatement(sql_validate, util.getConnection());
				if(rs_validate.next()){
					System.out.println("PT_IL_POLICY_ACTION.when_validate_rein_code() for if " );
					System.out.println("rs.getString('X')"+rs_validate.getString(1));
					rein_validate =rs_validate.getString("'X'");
					System.out.println("rein_validate is "+rein_validate);
					getErrorMap().clear();
				}else{
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(
							PELConstants.pelErrorMessagePath, "3206", new Object [] {
							"Enter the valid Endorsement Code"}));
					getErrorMap().put("CURRENT", Messages.getString(PELConstants.pelErrorMessagePath, "3206",
							new Object [] {"Enter the valid Endorsement Code"}));
				}
			}
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put("CURRENT", e.getMessage());
		}

	}


	public List UI_M_POLICY_NO_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		ResultSet rs = null;

		String query =null;
		if(obj.toString().equals("*")){
			/*
			 * modified by Ameen on 20-11-2017 to put paidup policy rein end.
			 * query = "select POL_NO  from PT_IL_POLICY where  POL_STATUS = 'L' AND ROWNUM  <25";*/
			query = "select POL_NO  from PT_IL_POLICY where  POL_STATUS IN ( 'L' , 'P' ) AND ROWNUM  <25";
		}else{
			String value = ((String) obj).toUpperCase(); 
			System.out.println("value   ::"+value);
			/*
			 * modified by Ameen on 20-11-2017 to put paidup policy rein end.
			 * query = "select POL_NO  from PT_IL_POLICY where POL_STATUS = 'L'  AND POL_NO LIKE('"+((String) obj).toUpperCase()+"%')AND ROWNUM  <25";*/
			query = "select POL_NO  from PT_IL_POLICY where POL_STATUS IN ( 'L' , 'P' ) AND POL_NO LIKE('"+((String) obj).toUpperCase()+"%')AND ROWNUM  <25";
			System.out.println("the policy query is"+query);
		}
		Connection connection = util.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			UI_M_POLICY_NO_LOV lovBox = new UI_M_POLICY_NO_LOV(); 
			lovBox.setPOL_NO(rs.getString("POL_NO"));
			lovList.add(lovBox);
		}
		rs.close();
		//connection.close();
		return lovList;

	}


	public void pilq101_pt_il_policy_pol_cust_code_when_validate_item(){
		try{
			String POL_CUST_CODE = (String)getCOMP_POL_CUST_CODE().getSubmittedValue();
			String query = "";


			Connection con = util.getConnection();
			rs = handler.executeSelectStatement(query, con);
			while(rs.next()){
				System.out.println("Inside while Loop");
				COMP_UI_M_POL_CUST_NAME.setSubmittedValue(rs.getString("PC_LONG_DESC"));

			}
			rs.close();
			//con.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_GROSS_PREM_SUM() {
		return COMP_UI_M_PC_FC_GROSS_PREM_SUM;
	}

	public void setCOMP_UI_M_PC_FC_GROSS_PREM_SUM(
			HtmlInputText comp_ui_m_pc_fc_gross_prem_sum) {
		COMP_UI_M_PC_FC_GROSS_PREM_SUM = comp_ui_m_pc_fc_gross_prem_sum;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_GROSS_PREM_SUM() {
		return COMP_UI_M_PC_LC_GROSS_PREM_SUM;
	}

	public void setCOMP_UI_M_PC_LC_GROSS_PREM_SUM(
			HtmlInputText comp_ui_m_pc_lc_gross_prem_sum) {
		COMP_UI_M_PC_LC_GROSS_PREM_SUM = comp_ui_m_pc_lc_gross_prem_sum;
	}

	public HtmlInputText getCOMP_UI_M_PC_FC_CHARGE_SUM() {
		return COMP_UI_M_PC_FC_CHARGE_SUM;
	}

	public void setCOMP_UI_M_PC_FC_CHARGE_SUM(
			HtmlInputText comp_ui_m_pc_fc_charge_sum) {
		COMP_UI_M_PC_FC_CHARGE_SUM = comp_ui_m_pc_fc_charge_sum;
	}

	public HtmlInputText getCOMP_UI_M_PC_LC_CHARGE_SUM() {
		return COMP_UI_M_PC_LC_CHARGE_SUM;
	}

	public void setCOMP_UI_M_PC_LC_CHARGE_SUM(
			HtmlInputText comp_ui_m_pc_lc_charge_sum) {
		COMP_UI_M_PC_LC_CHARGE_SUM = comp_ui_m_pc_lc_charge_sum;
	}

	public HtmlInputText getCOMP_M_NET_FC_PAID_AMT() {
		return COMP_M_NET_FC_PAID_AMT;
	}

	public void setCOMP_M_NET_FC_PAID_AMT(HtmlInputText comp_m_net_fc_paid_amt) {
		COMP_M_NET_FC_PAID_AMT = comp_m_net_fc_paid_amt;
	}

	public HtmlInputText getCOMP_M_NET_LC_PAID_AMT() {
		return COMP_M_NET_LC_PAID_AMT;
	}

	public void setCOMP_M_NET_LC_PAID_AMT(HtmlInputText comp_m_net_lc_paid_amt) {
		COMP_M_NET_LC_PAID_AMT = comp_m_net_lc_paid_amt;
	}

	public void onLoad(PhaseEvent event){
		try{
			if(isBlockFlag()){
				
				System.out.println("inside policy onload");
				//collectionAction.onLoad(event);
				// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
				helper.loadcurrency();
				//End
				//collectionAction.executeSelectStatement();
				if(PT_IL_POLICY_BEAN.getROWID() != null){

				}else{
					whenCreateRecord();
				}
				setBlockFlag(false);	
			}
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("ONLOAD", e.getMessage());
		}
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void whenCreateRecord() throws Exception{
		try {

			PT_IL_POLICY_BEAN.setUI_M_REINSTMT_DT(new CommonUtils().getCurrentDate());


		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void validateUI_M_REINSTMT_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_IL_POLICY_BEAN.setUI_M_REINSTMT_DT(curDate);

			// COMP_POL_LAST_INST_DT.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_REINSTMT_DT", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public HtmlOutputLabel getCOMP_M_INTEREST_LABEL() {
		return COMP_M_INTEREST_LABEL;
	}

	public void setCOMP_M_INTEREST_LABEL(HtmlOutputLabel comp_m_interest_label) {
		COMP_M_INTEREST_LABEL = comp_m_interest_label;
	}

	public HtmlInputText getCOMP_M_INTEREST() {
		return COMP_M_INTEREST;
	}

	public void setCOMP_M_INTEREST(HtmlInputText comp_m_interest) {
		COMP_M_INTEREST = comp_m_interest;
	}

	public void calcUnpaidInterest() throws Exception
	{
		ArrayList<OracleParameter> listUnpaid = new ArrayList<OracleParameter>();
		listUnpaid=	p9ilpk_prem_coll.P_CALC_UNPAID_PREM_INT(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),null,PT_IL_POLICY_BEAN.getUI_M_REINSTMT_DT(),null,null,null,null);
		if(listUnpaid.size() > 0 ){
			if(listUnpaid.get(2).getValueObject() != null ){
				PT_IL_POLICY_BEAN.setUI_M_INTEREST((Double)listUnpaid.get(2).getValueObject());
				System.out.println("Interest--->"+PT_IL_POLICY_BEAN.getUI_M_INTEREST());
			}
		}
	}
	// Added by saranya for ssp call id FALCONQC-1715539 0n 19-07-2016
	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
		int decimalPlaces=3;
		System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		 decimalPlaces=Integer.parseInt(CommonUtils.getGlobalObject("CURRENCY").toString());//(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
		System.out.println("decimalPlaces   : "+decimalPlaces);
		
		
		BigDecimal bd = new BigDecimal(Value);
	    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
	    
	    return bd.toString();
		}
		else
		{
			return "0.000";
		}
	}
	/*end*/
	/*added by saranya for ssp call id FALCONQC-1715539 0n 20-07-2016*/
    public void VALIDATE_ITEM_POLICY_NO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
    	try {
    	String pol_no=(String) value;
    	System.out.println("pol_no    :::::"+pol_no);
    		
    	}
    	catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}
    /*end*/
	/*	String C1=" SELECT SUM(PC_FC_UNPAID_PREM_INT) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID =? " +
				" AND PC_SCHD_PYMT_DT < ?  " ;
		Connection con = null;
		ResultSet rs = null;
		Double M_TOT=0.0;
		Double M_INT=0.0;
		CRUDHandler handler = new CRUDHandler();
		try {
			con=CommonUtils.getConnection();
			rs=handler.executeSelectStatement(C1,con,new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID(),PT_IL_POLICY_BEAN.getUI_M_REINSTMT_DT()});
			if(rs.next())
			{
				 M_INT=rs.getDouble(1);
			}
			PT_IL_POLICY_BEAN.setUI_M_INTEREST(M_INT);
	}catch(Exception e)
	{
		e.printStackTrace();
		throw e;
	}}*/
    
    /*Added by saritha ON 14-Feb-2017 for instantiateAllComponent added ssp call id ZBILQC-1719657 */
    public void instantiateAllComponent() {
    	
    	//HtmlInputText
    	COMP_POL_NO =new HtmlInputText();
    	COMP_POL_CUST_CODE=new HtmlInputText();
    	COMP_UI_M_POL_CUST_NAME=new HtmlInputText();
    	COMP_POL_CONT_CODE=new HtmlInputText();
    	COMP_UI_M_POL_ASSURED_NAME=new HtmlInputText();
    	COMP_POL_ASSRD_REF_ID1=new HtmlInputText();
    	COMP_M_REINST_CODE=new HtmlInputText();
    	COMP_POL_ASSRD_REF_ID2=new HtmlInputText();
    	COMP_M_TOT_REINS_LC_CHARGE=new HtmlInputText();
    	COMP_M_AVAIL_LC_DEP_AMT=new HtmlInputText();
    	COMP_M_NET_LC_PAID_AMT=new HtmlInputText();
    	COMP_M_INTEREST=new HtmlInputText();
    	//HtmlCalendar
    	COMP_M_REINSTMT_DT=new HtmlCalendar();
    	//HtmlOutputLabel
    	COMP_POL_NO_LABEL=new HtmlOutputLabel();
    	COMP_POL_CUST_CODE_LABEL=new HtmlOutputLabel();
    	COMP_POL_CONT_CODE_LABEL=new HtmlOutputLabel();
    	COMP_POL_ASSRD_REF_ID1_LABEL=new HtmlOutputLabel();
    	COMP_M_REINST_CODE_LABEL=new HtmlOutputLabel();
    	COMP_POL_ASSRD_REF_ID2_LABEL=new HtmlOutputLabel();
    	COMP_M_REINSTMT_DT_LABEL=new HtmlOutputLabel();
    	COMP_M_REINST_CHARGE_LABEL=new HtmlOutputLabel();
    	COMP_M_AVAIL_LC_DEP_AMT_LABEL=new HtmlOutputLabel();
    	COMP_M_AMT_PAID_LABEL=new HtmlOutputLabel();
    	COMP_M_INTEREST_LABEL=new HtmlOutputLabel();

    }
    
   /*End*/

}
