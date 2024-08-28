package com.iii.pel.forms.PILT003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.common.dms.DMSUtil;
import com.iii.pel.forms.PILT020.PT_IL_PREM_COLL_ACTION_TRIGGERS;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	private HtmlCommandButton COMP_QUERY;
	
	private HtmlCommandLink COMP_BACK_BUTTON;

	public PILT003_APAC_COMPOSITE_ACTION compositeAction;

	private PT_IL_POLICY_HELPER helper;

	
	/*Added by Ram on 23/02/2017 for fetch Records by Statuswise*/
	private HtmlOutputLabel COMP_STATUS_LABEL;

	public HtmlOutputLabel getCOMP_STATUS_LABEL() {
		return COMP_STATUS_LABEL;
	}

	public void setCOMP_STATUS_LABEL(HtmlOutputLabel cOMP_STATUS_LABEL) {
		COMP_STATUS_LABEL = cOMP_STATUS_LABEL;
	}
	/*End*/
	
	public PT_IL_POLICY_ACTION() {
		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		helper = new PT_IL_POLICY_HELPER();
		instantiateAllComponent();
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

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT003_APAC",
					"PT_IL_POLICY", "POL_NO", "A", null, null, null, null,
					(String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlCommandButton getCOMP_QUERY() {
		return COMP_QUERY;
	}

	public void setCOMP_QUERY(HtmlCommandButton comp_query) {
		COMP_QUERY = comp_query;
	}

	/**
	 * 
	 * @param phaseEvent
	 */
	public void onLoad(PhaseEvent phaseEvent) {
		try {
			if (isFormFlag()) {
				helper.preForm(compositeAction.getDUMMY_ACTION_BEAN()
						.getDUMMY_BEAN());
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				helper.preQuery(compositeAction);
				helper.executeQuery(compositeAction);
				helper.whenNewRecordInstance(compositeAction);
				helper.postQuery(compositeAction);
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/**
	 * Instantiates all components in PT_IL_POLICY_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_POL_NO = new HtmlInputText();

		// Instantiating HtmlCommandButton
		COMP_QUERY = new HtmlCommandButton();
		COMP_BACK_BUTTON = new HtmlCommandLink();

	}

	/**
	 * Fetch Button call.
	 */
	public void fetchBtnAction() {
		
		try {
			System.out.println();
			getErrorMap().clear();
			getWarningMap().clear();
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss SSS");
			Date date = null;
			date = new Date();
			System.out.println("Start Time--->"+dateFormat.format(date)); //2016/11/16 12:08:43
			onLoad(null); // Calling the policy block triggers.	
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().onLoad(null);// Calling
																			// the
																			// prem
																			// coll
																			// action
																			// triggers.
			
			/*Added by Ram on 23/02/2017 for fetch Records by Statuswise*/
			System.out.println("Welcome to FetchButtonAction       "+compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPOL_STS_FLAG());
			if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPOL_STS_FLAG() != null)
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getHelper().executeQuery(compositeAction);
			/*End*/
			
			/*Added by Ram on 03/04/2017 for disable status field by Condition based*/
			disableFunctionality();
			/*End*/
			date = new Date();
			System.out.println("End Time--->"+dateFormat.format(date));
			/*Added by saritha on 26-10-2017 for ssp call id ZBLIFE-1449091*/
			TotalPremiumPaid_Value();
			/*end*/
			/*Commented by Sivarajan for KIC on 21-03-2019 Ajoy Sugg.*/
			/*Newly Added By Dhinesh on 18-06-2018 for KIC Issue
			if("A".equalsIgnoreCase(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_PAID_FLAG()))
			{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FC_PAID_AMOUNT().setDisabled(true);
			}else
			{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FC_PAID_AMOUNT().setDisabled(false);
			}
				
			
			End*/
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_FC_PAID_AMOUNT().setDisabled(true);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	/*Added by Ram on 03/04/2017 for disable status field by Condition based*/
	public void disableFunctionality()
	{
		
		boolean compDisable = false;
		if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_PAID_FLAG() != null && 
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_PAID_FLAG().equals("A"))
		{
			compDisable = true;
		}
		else
		{
			compDisable = false;
		}
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PAID_FLAG().setDisabled(compDisable);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_ADD_BUT().setDisabled(compDisable);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PAID_FLAG().resetValue();
		 
	
	}
	/*End*/
	
	private Boolean isCheck = true;

	public void phaseMethod(PhaseEvent ae) {
		
		try {
			if (isCheck) {
				if (CommonUtils.getGlobalVariable("CALLING_FORM") != null) {
					if ("PILQ002".equals(CommonUtils
							.getGlobalVariable("CALLING_FORM"))) {
						COMP_BACK_BUTTON.setRendered(true);
						compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
								.setBlockFlag(true);
						fetchBtnAction();
						// disablebutton();
					}
				}
				setIsCheck(false);
				// this.setBlockFlag(false);
			}
			if(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getROWID()==null){

				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_PAID_FLAG("N");

				/*Added by Ram on 08/02/2017 for BankCode field capturing*/
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setBANK_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));
				/*End*/
				System.out.println("GLOBAL.M_PARAM_20          "+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20")+"      "
						+compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getBANK_CODE());

				/*Added by Ram on 23/02/2017 for fetch Records by Statuswise*/
				
				String Pol_sts = CommonUtils.getGlobalVariable("PREM_COLL.POL_STS");
				System.out.println("Pol_sts   : "+Pol_sts);
				
				if(Pol_sts == null)
				{
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPOL_STS_FLAG("U");
				}
				
				/*End*/
			}/*Added by Ram on 23/02/2017 for fetch Records by Statuswise*/
			else
			{
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPOL_STS_FLAG(CommonUtils.getGlobalVariable("PREM_COLL.POL_STS"));
				/*Added by Ram on 08/02/2017 for BankCode field capturing*/
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setBANK_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20"));
				System.out.println("GLOBAL.M_PARAM_20          "+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_20")+"      "
						+compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getBANK_CODE());
				/*End*/
				/*Added by saritha on 27-10-2017 for ssp call id ZBLIFE-1449091*/
				TotalPremiumPaid_Value();
				/*End*/
				
			}
			/*End*/
			
			/*Added by Ameen on 18-05-2017 as per Ajoy sugg. to disable all fields when selected pol_type = H*/
			hopitalPlanType();
			/*End*/
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}

	public String backButtonAction() {
		String outcome = null;
		if (CommonUtils.getGlobalVariable("CALLING_FORM") != null) {
			if ("PILQ002".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))) {
				CommonUtils.setGlobalVariable("CALLING_FORM", null);
				new CommonUtils()
						.clearMappedBeanFromSession("PILT003_APAC_COMPOSITE_ACTION");
				outcome = "PILQ002-I01";
			}
		}
		return outcome;
	}

	public void disablebutton() {
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_REINSTATE().setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_CVR_DTL().setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_BROKER_DTLS().setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_CHG_DTL().setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_FAC()
				.setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_LOAN_INT().setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
		compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_FUND_QUERY_DETAILS().setDisabled(true);
		COMP_POL_NO.setDisabled(true);
		COMP_QUERY.setDisabled(true);
	}

	public void validatorPolNo(FacesContext facesContext,
			UIComponent component, Object value)  {
		CommonUtils.clearMaps(this);
		PT_IL_POLICY_BEAN.setPOL_NO((String) value);
		//added by krithika on 30-05-2016
		String values=PT_IL_POLICY_BEAN.getPOL_NO();
		CommonUtils.setGlobalVariable("GLOBAL.M_POL_NUMBER",values);
		
		try {
			if(PT_IL_POLICY_BEAN.getPOL_NO()!=null){
			disablefundquery(PT_IL_POLICY_BEAN.getPOL_NO());
			COMP_POL_NO.setDisabled(true);
			
			}
			//helper.validPolNo((String) value);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "POL_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void disablefundquery(String polno) throws Exception{
		String C1="select plan_type from pm_il_plan where plan_code = ? ";
		String C2="select pol_plan_code from pt_il_policy where pol_no=?";
		String plantype=null;
		String plancode=null;
		Connection con=null;
		ResultSet rs=null;
		ResultSet rs1=null;
		CRUDHandler handler=null;
		try{
			con=CommonUtils.getConnection();
			handler=new CRUDHandler();
			rs1=handler.executeSelectStatement(C2, con, new Object[]{polno});
			if(rs1.next()){
				plancode=rs1.getString(1);
			}	
			
			rs=handler.executeSelectStatement(C1, con, new Object[]{plancode});
		if(rs.next()){
			plantype=rs.getString(1);
		}	
		
		if("U".equalsIgnoreCase(plantype)){
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_FUND_QUERY_DETAILS().setDisabled(false);
		}else{
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_FUND_QUERY_DETAILS().setDisabled(true);
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(rs);
		}
	}
	
	
	public Boolean getIsCheck() {
		return isCheck;
	}

	public void setIsCheck(Boolean isCheck) {
		this.isCheck = isCheck;
	}

	public HtmlCommandLink getCOMP_BACK_BUTTON() {
		return COMP_BACK_BUTTON;
	}

	public void setCOMP_BACK_BUTTON(HtmlCommandLink comp_back_button) {
		COMP_BACK_BUTTON = comp_back_button;
	}
	
	/*Added by Ameen on 18-05-2017 as per Ajoy sugg. to disable all fields when selected pol_type = H*/
	public void hopitalPlanType(){
		String polTypeQry = "SELECT PLAN_TYPE,PROD_INTR_SAVINGS_YN,POL_SRC_OF_BUS FROM PT_IL_POLICY,PM_IL_PRODUCT,"
				+ "PM_IL_PLAN WHERE PLAN_CODE = POL_PLAN_CODE AND PROD_CODE = POL_PROD_CODE AND POL_NO = ?";
		ResultSet rs = null;
		String PLAN_TYPE  = null;
		String PROD_INTR_SAVINGS_YN  = null;
		String POL_SRC_OF_BUS = null;
		try {
			
			rs = new CRUDHandler().executeSelectStatement(polTypeQry, CommonUtils.getConnection(),
												new Object[]{PT_IL_POLICY_BEAN.getPOL_NO()});
			if(rs.next()){
				PLAN_TYPE  = rs.getString(1);
				PROD_INTR_SAVINGS_YN = rs.getString(2);
				POL_SRC_OF_BUS = rs.getString(3);
			}
			System.out.println("PLAN_TYPE ::" + PLAN_TYPE + ":: PROD_INTR_SAVINGS_YN ::" + PROD_INTR_SAVINGS_YN);
			if(PLAN_TYPE != null && "H".equalsIgnoreCase(PLAN_TYPE) && PROD_INTR_SAVINGS_YN != null && "Y".equalsIgnoreCase(PROD_INTR_SAVINGS_YN)){
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().disableHospProdComponent(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_PRINT_BUTTON().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_SAVE_BTN().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_DMS_BTN().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_SAVE_COMD_BTN().setDisabled(true);
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_DMS_COMD_BTN().setDisabled(true);
				if("001".equals(POL_SRC_OF_BUS)){
					compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_BUT_BROKER_DTLS().setDisabled(true);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		/*End*/
	}
	
	/*Added by saritha on 26-10-2017 for ssp call id ZBLIFE-1449091*/
	public void TotalPremiumPaid_Value() {
		Connection connection = null;
		ResultSet resultSet = null;

		try {

			connection = CommonUtils.getConnection();
			/*
			 * modified by Ameen on 25-04-2018 for KIC to show LC total value as per Ajay sugg.
			 * String query = "SELECT NVL(SUM(NVL(PC_FC_BASIC_PREM, 0) + NVL(PC_FC_ADDL_PREM, 0) + NVL(PC_FC_LOAD_AMT, 0) + "
					       + "NVL(PC_FC_DISCOUNT, 0) + NVL(PC_FC_CHARGE, 0)),0) FROM PT_IL_PREM_COLL WHERE "
					       + "NVL(PC_PAID_FLAG, 'N') = 'A' AND PC_POL_SYS_ID = ?";*/
			
			String query = "SELECT NVL(SUM(NVL(PC_LC_BASIC_PREM, 0) + NVL(PC_LC_ADDL_PREM, 0) + NVL(PC_LC_LOAD_AMT, 0) + "
				       + "NVL(PC_LC_DISCOUNT, 0) + NVL(PC_LC_CHARGE, 0)),0) FROM PT_IL_PREM_COLL WHERE "
				       + "NVL(PC_PAID_FLAG, 'N') = 'A' AND PC_POL_SYS_ID = ?";

			System.out.println("pol_sys_id    "+PT_IL_POLICY_BEAN.getPOL_SYS_ID());
			Object[] prod_code = { PT_IL_POLICY_BEAN.getPOL_SYS_ID()};
			resultSet =  new CRUDHandler().executeSelectStatement(query, connection,prod_code);
			if (resultSet.next()) {
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setUI_M_TOTAL_PREM_PAID(resultSet.getDouble(1));
				compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_UI_M_TOTAL_PREM_PAID().resetValue();
			}

		} catch (Exception exp) {
			exp.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	/*End*/
	
	
}