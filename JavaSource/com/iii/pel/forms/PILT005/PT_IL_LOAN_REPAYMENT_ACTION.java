package com.iii.pel.forms.PILT005;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS;
import com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_REPAYMENT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_LR_PYMT_DT_LABEL;

	private HtmlCalendar COMP_LR_PYMT_DT;
	
	private HtmlOutputLabel COMP_LR_REPAY_PAID_DT_LABEL;
	
	private HtmlCalendar COMP_LR_REPAY_PAID_DT;

	private HtmlOutputLabel COMP_LR_FC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_PYMT_AMT;

	private HtmlOutputLabel COMP_LR_LC_PYMT_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_PYMT_AMT;

	private HtmlOutputLabel COMP_LR_FC_INT_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_INT_AMT;

	private HtmlOutputLabel COMP_LR_LC_INT_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_INT_AMT;

	
	private HtmlOutputLabel COMP_LR_FC_LOAN_AMT_LABEL;

	private HtmlInputText COMP_LR_FC_LOAN_AMT;

	private HtmlOutputLabel COMP_LR_LC_LOAN_AMT_LABEL;

	private HtmlInputText COMP_LR_LC_LOAN_AMT;

	private HtmlOutputLabel COMP_LR_PYMT_REF_NO_LABEL;

	private HtmlInputText COMP_LR_PYMT_REF_NO;

	private PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN;

	private PT_IL_LOAN_REPAYMENT_DTL PT_IL_LOAN_REPAYMENT_DTL_BEAN;

	private String filterLR_FC_PYMT_AMT;
	
	private Date filterLR_PYMT_DT;
	
	private Date filterLR_REPAY_PAID_DT;
	
	private String filterLR_STATUS;
	
	private String filterLR_FC_LOAN_AMT;
	
	private String filterByLR_LC_PYMT_AMT;

	private UIDataTable dataTable;

	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;

	private HtmlAjaxCommandButton approveButton;
	
	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	CommonUtils commonUtils = new CommonUtils();

	
	private HtmlCommandButton COMP_BT_LOANSCREEN;
	
	

	/** Focus Mechanism */

	private String LR_PYMT_DT_FOCUS;

	public HtmlCommandButton getCOMP_BT_LOANSCREEN() {
		return COMP_BT_LOANSCREEN;
	}

	public void setCOMP_BT_LOANSCREEN(HtmlCommandButton cOMP_BT_LOANSCREEN) {
		COMP_BT_LOANSCREEN = cOMP_BT_LOANSCREEN;
	}

	/** Focus Mechanism */

	/* These variables are declared for Trigger Validations */

	private HtmlOutputText COMP_LOAN_STATUS;
	private HtmlOutputText COMP_LOAN_DISBURSAL_STATUS;
	ArrayList<PT_IL_LOAN_REPAYMENT> gridDisplay = new ArrayList<PT_IL_LOAN_REPAYMENT>();

	List<PT_IL_LOAN_REPAYMENT> beanList = new ArrayList<PT_IL_LOAN_REPAYMENT>();
	private UIDataTable dT;
	// private HtmlAjaxCommandButton pymtDetails;
	// private HtmlAjaxCommandButton backToLoanDisbursal;
	// private HtmlAjaxCommandButton approve;
	private HtmlAjaxCommandButton addRow1;
	private HtmlAjaxCommandButton deleteRow1;
	PT_IL_LOAN_REPAYMENT_ACTION_DELEGATE delegate = new PT_IL_LOAN_REPAYMENT_ACTION_DELEGATE();
	DataGridDelegate dataGridDelegate = new DataGridDelegate();
	private int lastUpdatedRowIndex;
	private int prevRowIndex;
	private int currPage;
	private int recordsPerPage = 5;
	private String LR_REF_NO_FOCUS;
	private String LR_LC_PYMT_AMT_FOCUS;
	private String LR_FC_PYMT_AMT_FOCUS;

	private boolean backToLoanDisbursal;
	private boolean pymtDetails;
	private boolean approve;

	/* These variables are declared for Trigger Validations */

	public String getLR_REF_NO_FOCUS() {
		return LR_REF_NO_FOCUS;
	}

	public void setLR_REF_NO_FOCUS(String lr_ref_no_focus) {
		LR_REF_NO_FOCUS = lr_ref_no_focus;
	}

	public UIDataTable getDT() {
		return dT;
	}

	public void setDT(UIDataTable dt) {
		dT = dt;
	}

	public PT_IL_LOAN_REPAYMENT_ACTION() {
		PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
		PT_IL_LOAN_REPAYMENT_DTL_BEAN = new PT_IL_LOAN_REPAYMENT_DTL();
		instantiateAllComponent();
		prevRowIndex = 0;
		currPage = 1;
		System.out.println("M_CALLING_FORM: "
				+ CommonUtils.getGlobalVariable("GLOBAL.M_CALLING_FORM"));
		if ("PILT004".equals(CommonUtils
				.getGlobalVariable("GLOBAL.M_CALLING_FORM"))) {
			HtmlAjaxCommandButton button = new HtmlAjaxCommandButton();
			button.setDisabled(false);
			// setBackToLoanDisbursal(button);
			setBackToLoanDisbursal(true);
			// CommonUtils.setGlobalVariable("GLOBAL.M_CALLING_FORM", "");
		} else {
			HtmlAjaxCommandButton button = new HtmlAjaxCommandButton();
			button.setDisabled(true);
			// setBackToLoanDisbursal(button);
			setBackToLoanDisbursal(false);
		}
	}

	public HtmlOutputLabel getCOMP_LR_PYMT_DT_LABEL() {
		return COMP_LR_PYMT_DT_LABEL;
	}

	public HtmlCalendar getCOMP_LR_PYMT_DT() {
		return COMP_LR_PYMT_DT;
	}

	public void setCOMP_LR_PYMT_DT_LABEL(HtmlOutputLabel COMP_LR_PYMT_DT_LABEL) {
		this.COMP_LR_PYMT_DT_LABEL = COMP_LR_PYMT_DT_LABEL;
	}

	public void setCOMP_LR_PYMT_DT(HtmlCalendar COMP_LR_PYMT_DT) {
		this.COMP_LR_PYMT_DT = COMP_LR_PYMT_DT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_PYMT_AMT_LABEL() {
		return COMP_LR_FC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_PYMT_AMT() {
		return COMP_LR_FC_PYMT_AMT;
	}

	public void setCOMP_LR_FC_PYMT_AMT_LABEL(
			HtmlOutputLabel COMP_LR_FC_PYMT_AMT_LABEL) {
		this.COMP_LR_FC_PYMT_AMT_LABEL = COMP_LR_FC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LR_FC_PYMT_AMT(HtmlInputText COMP_LR_FC_PYMT_AMT) {
		this.COMP_LR_FC_PYMT_AMT = COMP_LR_FC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_PYMT_AMT_LABEL() {
		return COMP_LR_LC_PYMT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_PYMT_AMT() {
		return COMP_LR_LC_PYMT_AMT;
	}

	public void setCOMP_LR_LC_PYMT_AMT_LABEL(
			HtmlOutputLabel COMP_LR_LC_PYMT_AMT_LABEL) {
		this.COMP_LR_LC_PYMT_AMT_LABEL = COMP_LR_LC_PYMT_AMT_LABEL;
	}

	public void setCOMP_LR_LC_PYMT_AMT(HtmlInputText COMP_LR_LC_PYMT_AMT) {
		this.COMP_LR_LC_PYMT_AMT = COMP_LR_LC_PYMT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_INT_AMT_LABEL() {
		return COMP_LR_FC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_INT_AMT() {
		return COMP_LR_FC_INT_AMT;
	}

	public void setCOMP_LR_FC_INT_AMT_LABEL(
			HtmlOutputLabel COMP_LR_FC_INT_AMT_LABEL) {
		this.COMP_LR_FC_INT_AMT_LABEL = COMP_LR_FC_INT_AMT_LABEL;
	}

	public void setCOMP_LR_FC_INT_AMT(HtmlInputText COMP_LR_FC_INT_AMT) {
		this.COMP_LR_FC_INT_AMT = COMP_LR_FC_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_INT_AMT_LABEL() {
		return COMP_LR_LC_INT_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_INT_AMT() {
		return COMP_LR_LC_INT_AMT;
	}

	public void setCOMP_LR_LC_INT_AMT_LABEL(
			HtmlOutputLabel COMP_LR_LC_INT_AMT_LABEL) {
		this.COMP_LR_LC_INT_AMT_LABEL = COMP_LR_LC_INT_AMT_LABEL;
	}

	public void setCOMP_LR_LC_INT_AMT(HtmlInputText COMP_LR_LC_INT_AMT) {
		this.COMP_LR_LC_INT_AMT = COMP_LR_LC_INT_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_FC_LOAN_AMT_LABEL() {
		return COMP_LR_FC_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_FC_LOAN_AMT() {
		return COMP_LR_FC_LOAN_AMT;
	}

	public void setCOMP_LR_FC_LOAN_AMT_LABEL(
			HtmlOutputLabel COMP_LR_FC_LOAN_AMT_LABEL) {
		this.COMP_LR_FC_LOAN_AMT_LABEL = COMP_LR_FC_LOAN_AMT_LABEL;
	}

	public void setCOMP_LR_FC_LOAN_AMT(HtmlInputText COMP_LR_FC_LOAN_AMT) {
		this.COMP_LR_FC_LOAN_AMT = COMP_LR_FC_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_LC_LOAN_AMT_LABEL() {
		return COMP_LR_LC_LOAN_AMT_LABEL;
	}

	public HtmlInputText getCOMP_LR_LC_LOAN_AMT() {
		return COMP_LR_LC_LOAN_AMT;
	}

	public void setCOMP_LR_LC_LOAN_AMT_LABEL(
			HtmlOutputLabel COMP_LR_LC_LOAN_AMT_LABEL) {
		this.COMP_LR_LC_LOAN_AMT_LABEL = COMP_LR_LC_LOAN_AMT_LABEL;
	}

	public void setCOMP_LR_LC_LOAN_AMT(HtmlInputText COMP_LR_LC_LOAN_AMT) {
		this.COMP_LR_LC_LOAN_AMT = COMP_LR_LC_LOAN_AMT;
	}

	public HtmlOutputLabel getCOMP_LR_PYMT_REF_NO_LABEL() {
		return COMP_LR_PYMT_REF_NO_LABEL;
	}

	public HtmlInputText getCOMP_LR_PYMT_REF_NO() {
		return COMP_LR_PYMT_REF_NO;
	}

	public void setCOMP_LR_PYMT_REF_NO_LABEL(
			HtmlOutputLabel COMP_LR_PYMT_REF_NO_LABEL) {
		this.COMP_LR_PYMT_REF_NO_LABEL = COMP_LR_PYMT_REF_NO_LABEL;
	}

	public void setCOMP_LR_PYMT_REF_NO(HtmlInputText COMP_LR_PYMT_REF_NO) {
		this.COMP_LR_PYMT_REF_NO = COMP_LR_PYMT_REF_NO;
	}

	public PT_IL_LOAN_REPAYMENT getPT_IL_LOAN_REPAYMENT_BEAN() {
		return PT_IL_LOAN_REPAYMENT_BEAN;
	}

	public void setPT_IL_LOAN_REPAYMENT_BEAN(
			PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN) {
		this.PT_IL_LOAN_REPAYMENT_BEAN = PT_IL_LOAN_REPAYMENT_BEAN;
	}

	/* Field-Level validations for the LOAN_REPAYMENT BLOCK Starts here. */
	public void LR_PYMT_DT_Validation(ActionEvent event) {
		/*
		 * CommonUtils.clearMaps(this); PT_IL_LOAN_REPAYMENT loanRepayment =
		 * (PT_IL_LOAN_REPAYMENT) dT.getRowData();
		 */
		LR_PY_MT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
	}
	
	public void LR_REPAY_PAID_DT_Validation(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		/*
		 * CommonUtils.clearMaps(this); PT_IL_LOAN_REPAYMENT loanRepayment =
		 * (PT_IL_LOAN_REPAYMENT) dT.getRowData();
		 */
		CommonUtils.clearMaps(this);
		Date curDate = (Date) value;
		try {
			PT_IL_LOAN_REPAYMENT_BEAN.setLR_REPAY_PAID_DT(curDate);
			
			System.out.println("LR_REPAY_PAID_DT   : "+PT_IL_LOAN_REPAYMENT_BEAN.getLR_REPAY_PAID_DT());
			System.out.println("LR_PYMT_DT         : "+PT_IL_LOAN_REPAYMENT_BEAN.getLR_PYMT_DT());
			
		if(commonUtils.dateGreaterthenOrEqualTo( PT_IL_LOAN_REPAYMENT_BEAN.getLR_REPAY_PAID_DT(),PT_IL_LOAN_REPAYMENT_BEAN.getLR_PYMT_DT()))
		{
			//LR_FC_INT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
			
			Connection con = null;
			
				String Query ="SELECT FUNC_CALC_LATE_PAY_INT(?,?,?) LATE_PAY_INT  FROM DUAL";
				Double LATE_PAY_INT= 0.0;
				Double M_EXRATE = 0.0;
				Double LR_LC_INT_AMT = 0.0;
				Double LR_FC_INT_AMT = 0.0;
				
				Date LR_PYMT_DT = PT_IL_LOAN_REPAYMENT_BEAN.getLR_PYMT_DT();
				FacesContext ctx = FacesContext.getCurrentInstance();
				Map<String, Object> sessionMap = ctx.getExternalContext()
						.getSessionMap();
				
				String LOAN_REF_NO = (String) sessionMap.get("LOAN_REF_NO");
				// String LOAN_DT = (String) sessionMap.get("LOAN_DT");
				Date LOAN_DT = (Date) CommonUtils.getGlobalObject("LOAN_DT");
				Double M_LC_OS_AMOUNT = (Double) sessionMap.get("M_LC_OS_AMOUNT");
				String M_CUST_CURR_CODE = (String) sessionMap
						.get("M_CUST_CURR_CODE");
				String M_CURR_RATE_BS = (String) sessionMap.get("M_CURR_RATE_BS");
				
			 Long LR_LOAN_SYS_ID = 0L;
			 
			 //LR_LOAN_SYS_ID = Long.parseLong( PT_IL_LOAN_REPAYMENT_BEAN.getLR_LOAN_SYS_ID().toString());
			 LR_LOAN_SYS_ID =new Double(PT_IL_LOAN_REPAYMENT_BEAN.getLR_LOAN_SYS_ID()).longValue(); ;
			  
			 
				CRUDHandler handler = new CRUDHandler();
				con = CommonUtils.getConnection();
				ResultSet resultSet = null;
				resultSet = new CRUDHandler().executeSelectStatement(
						Query, con, new Object[] { LR_LOAN_SYS_ID,PT_IL_LOAN_REPAYMENT_BEAN.getLR_SYS_ID(),PT_IL_LOAN_REPAYMENT_BEAN.getLR_REPAY_PAID_DT() });
				while (resultSet.next())
				{
					LATE_PAY_INT=resultSet.getDouble("LATE_PAY_INT");
				}
				
				DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

				String modified_LR_PYMT_DT = df.format(LR_PYMT_DT);
							sessionMap.put("modified_LR_PYMT_DT", modified_LR_PYMT_DT);
							System.out.println("M_CURR_RATE_BS = " + M_CURR_RATE_BS);
							System.out.println("M_CUST_CURR_CODE = " + M_CUST_CURR_CODE);
							System.out.println("Modified Date = " + modified_LR_PYMT_DT);
							
				M_EXRATE = P_GET_EXCHANGE_RATE_Delegate(M_CUST_CURR_CODE,
						M_CURR_RATE_BS, modified_LR_PYMT_DT, "", "E");
				System.out.println("M_EXRATE = " + M_EXRATE);
				LR_LC_INT_AMT = commonUtils.nvl(PT_IL_LOAN_REPAYMENT_BEAN.getLR_LC_INT_AMT(),0.0) + commonUtils.nvl(LATE_PAY_INT,0.0);
				
				LR_FC_INT_AMT = (LR_LC_INT_AMT / M_EXRATE);

				LR_LC_INT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
						.valueOf(LR_LC_INT_AMT), "R");
				LR_FC_INT_AMT = P_VAL_ROUND_AMT_Delegate(M_CUST_CURR_CODE, String
						.valueOf(LR_FC_INT_AMT), "R");
				
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_INT_AMT(LR_FC_INT_AMT);
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_LC_INT_AMT(LR_LC_INT_AMT);
			
			
			COMP_LR_FC_INT_AMT.resetValue();
			COMP_LR_LC_INT_AMT.resetValue();
			}
	
		PT_IL_LOAN_REPAYMENT_BEAN.getLR_FC_INT_AMT();
			
		}catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	public void LR_FC_INT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) 
	{
		
		Connection con = null;
		try {
			String Query ="select FUNC_CALC_LATE_PAY_INT(?,?) LATE_PAY_INT from dual";
			Double LATE_PAY_INT= 0.0;
			Double M_EXRATE = 0.0;
			Double LR_LC_INT_AMT =0.0;
			Double LR_FC_INT_AMT =0.0;
			
			Date LR_PYMT_DT = obj.getLR_PYMT_DT();
			FacesContext ctx = FacesContext.getCurrentInstance();
			Map<String, Object> sessionMap = ctx.getExternalContext()
					.getSessionMap();
			
			String LOAN_REF_NO = (String) sessionMap.get("LOAN_REF_NO");
			// String LOAN_DT = (String) sessionMap.get("LOAN_DT");
			Date LOAN_DT = (Date) CommonUtils.getGlobalObject("LOAN_DT");
			Double M_LC_OS_AMOUNT = (Double) sessionMap.get("M_LC_OS_AMOUNT");
			String M_CUST_CURR_CODE = (String) sessionMap
					.get("M_CUST_CURR_CODE");
			String M_CURR_RATE_BS = (String) sessionMap.get("M_CURR_RATE_BS");
			
			CRUDHandler handler = new CRUDHandler();
			con = CommonUtils.getConnection();
			ResultSet resultSet = null;
			resultSet = new CRUDHandler().executeSelectStatement(
					Query, con, new Object[] { obj.getLR_LOAN_SYS_ID(),obj.getLR_SYS_ID() });
			while (resultSet.next())
			{
				LATE_PAY_INT=resultSet.getDouble("LATE_PAY_INT");
			}
			
			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");

			String modified_LR_PYMT_DT = df.format(LR_PYMT_DT);
						sessionMap.put("modified_LR_PYMT_DT", modified_LR_PYMT_DT);
						System.out.println("M_CURR_RATE_BS = " + M_CURR_RATE_BS);
						System.out.println("M_CUST_CURR_CODE = " + M_CUST_CURR_CODE);
						System.out.println("Modified Date = " + modified_LR_PYMT_DT);
						
			M_EXRATE = P_GET_EXCHANGE_RATE_Delegate(M_CUST_CURR_CODE,
					M_CURR_RATE_BS, modified_LR_PYMT_DT, "", "E");
			System.out.println("M_EXRATE = " + M_EXRATE);
			LR_LC_INT_AMT = commonUtils.nvl(obj.getLR_LC_INT_AMT(),0.0) + commonUtils.nvl(LATE_PAY_INT,0.0);
			
			LR_FC_INT_AMT = (LR_LC_INT_AMT / M_EXRATE);

			LR_LC_INT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_LC_INT_AMT), "R");
			LR_FC_INT_AMT = P_VAL_ROUND_AMT_Delegate(M_CUST_CURR_CODE, String
					.valueOf(LR_FC_INT_AMT), "R");
			
			obj.setLR_FC_INT_AMT(LR_FC_INT_AMT);
			obj.setLR_LC_INT_AMT(LR_LC_INT_AMT);
		
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	 /* Commented below code on 19.2.2017 by Dhinesh
	public String LR_FC_PYMT_AMT_Validation() {
			// PT_IL_LOAN_REPAYMENT loanRepayment = (PT_IL_LOAN_REPAYMENT)
			// dT.getRowData();
			LR_FC_PYMT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
			return "";
		}	
		
	*/
		
		/*  Newly added below code on 19.2.2017 by Dhinesh */
	public void LR_FC_PYMT_AMT_Validation(FacesContext context,
				UIComponent component, Object value) {
		
			try {
				getErrorMap().clear();
				
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_FC_PYMT_AMT((Double)value);
				
				LR_FC_PYMT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}	
		
	/*END*/
	

	public String LR_LC_PYMT_AMT_Validation() {
		// PT_IL_LOAN_REPAYMENT loanRepayment = (PT_IL_LOAN_REPAYMENT)
		// dT.getRowData();
		LR_LC_PYMT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
		return "";
	}

	public String LR_FC_INT_AMT_Validation() {
		// PT_IL_LOAN_REPAYMENT loanRepayment = (PT_IL_LOAN_REPAYMENT)
		// dT.getRowData();
		LR_FC_INT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
		return "";
	}

	public String LR_LC_INT_AMT_Validation() {
		// PT_IL_LOAN_REPAYMENT loanRepayment = (PT_IL_LOAN_REPAYMENT)
		// dT.getRowData();
		LR_LC_INT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
		return "";
	}

	public String LR_FC_LOAN_AMT_Validation() {
		// PT_IL_LOAN_REPAYMENT loanRepayment = (PT_IL_LOAN_REPAYMENT)
		// dT.getRowData();
		LR_FC_LOAN_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
		return "";
	}

	public String LR_LC_LOAN_AMT_Validation() {
		// PT_IL_LOAN_REPAYMENT loanRepayment = (PT_IL_LOAN_REPAYMENT)
		// dT.getRowData();
		LR_LC_LOAN_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT_BEAN);
		return "";
	}

	/* Field-Level validations for the LOAN_REPAYMENT BLOCK Ends here. */

	public ArrayList<PT_IL_LOAN_REPAYMENT> getGridDisplay() {
		for (int i = 0; i < gridDisplay.size(); i++) {
			PT_IL_LOAN_REPAYMENT repay = gridDisplay.get(i);
			if (NVLString(repay.getLR_STATUS(), "").equals("")) {
				repay.setLR_PYMT_DT_DISABLE(false);
				repay.setLR_FC_PYMT_AMT_DISABLE(false);
				repay.setLR_LC_PYMT_AMT_DISABLE(false);
				repay.setLR_PYMT_REF_NO_DISABLE(false);

			} else if (NVLString(repay.getLR_STATUS(), null) != null) {
				if (NVLString(repay.getLR_STATUS(), "").equals("A")) {
					repay.setLR_PYMT_DT_DISABLE(true);
					repay.setLR_FC_PYMT_AMT_DISABLE(true);
					repay.setLR_LC_PYMT_AMT_DISABLE(true);
					repay.setLR_PYMT_REF_NO_DISABLE(true);

				}
			}
		}
		return gridDisplay;
	}

	public void setGridDisplay(ArrayList<PT_IL_LOAN_REPAYMENT> gridDisplay) {
		this.gridDisplay = gridDisplay;
	}

	/* Field-Level validations for the LOAN_REPAYMENT BLOCK Starts here. */
	
	

	private void LR_PY_MT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) {
		Connection con = null;
		try {

			Date LR_PYMT_DT = obj.getLR_PYMT_DT();
			Date M_LR_PYMT_DT = null;
			Date SYSDATE = null;
			Double LR_LOAN_SYS_ID = null;
			Double M_EXRATE = 0.0;
			Double LR_FC_INT_AMT = 0.0;
			Double LR_LC_INT_AMT = 0.0;

			FacesContext ctx = FacesContext.getCurrentInstance();
			Map<String, Object> sessionMap = ctx.getExternalContext()
					.getSessionMap();
			// Date LR_PYMT_DT = (Date)
			// PT_IL_LOAN_REPAYMENT_BEAN.getLR_PYMT_DT();
			String LOAN_REF_NO = (String) sessionMap.get("LOAN_REF_NO");
			// String LOAN_DT = (String) sessionMap.get("LOAN_DT");
			Date LOAN_DT = (Date) CommonUtils.getGlobalObject("LOAN_DT");
			Double M_LC_OS_AMOUNT = (Double) sessionMap.get("M_LC_OS_AMOUNT");
			String M_CUST_CURR_CODE = (String) sessionMap
					.get("M_CUST_CURR_CODE");
			String M_CURR_RATE_BS = (String) sessionMap.get("M_CURR_RATE_BS");

			DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
			Date LOAN_DT1 = null;
			if (!"".equals(LOAN_DT) || LOAN_DT != null) {
				LOAN_DT1 = LOAN_DT;
			}

			String modified_LR_PYMT_DT = df.format(LR_PYMT_DT);
			sessionMap.put("modified_LR_PYMT_DT", modified_LR_PYMT_DT);
			System.out.println("M_CURR_RATE_BS = " + M_CURR_RATE_BS);
			System.out.println("M_CUST_CURR_CODE = " + M_CUST_CURR_CODE);
			System.out.println("Modified Date = " + modified_LR_PYMT_DT);

			String query1 = "SELECT MAX(LR_PYMT_DT) FROM PT_IL_LOAN_REPAYMENT A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID = B.LOAN_SYS_ID AND B.LOAN_REF_NO = '"
					+ LOAN_REF_NO + "'";
			// String query1 = "SELECT MAX(A.LR_PYMT_DT) FROM
			// PT_IL_LOAN_REPAYMENT A,PT_IL_LOAN B where A.LR_LOAN_SYS_ID =
			// B.LOAN_SYS_ID";
			String sysDateQuery = "SELECT SYSDATE FROM DUAL";

			CRUDHandler handler = new CRUDHandler();
			con = CommonUtils.getConnection();

			ResultSet rs1 = handler.executeSelectStatement(query1, con);
			while (rs1.next()) {
				M_LR_PYMT_DT = rs1.getDate(1);
				System.out.println("M_LR_PYMT_DT = " + M_LR_PYMT_DT);
			}
			rs1.close();

			ResultSet rs2 = handler.executeSelectStatement(sysDateQuery, con);
			while (rs2.next()) {
				SYSDATE = rs2.getDate(1);
				System.out.println("SYSDATE = " + SYSDATE);
			}
			rs2.close();

			LR_LOAN_SYS_ID =  (Double) sessionMap.get("PILT005_LR_LOAN_SYS_ID");
			System.out.println("LR_LOAN_SYS_ID = " + LR_LOAN_SYS_ID);

			if (LOAN_DT1 == null || LR_PYMT_DT.before(LOAN_DT1)) {
				getErrorMap()
						.put(
								"current",
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"71090").getSummary());
				setLR_PYMT_DT_FOCUS("LR_PYMT_DT");
				return;
			} else {
				getErrorMap().clear();
			}

			if (M_LR_PYMT_DT != null) {
				if (LR_PYMT_DT.after(SYSDATE)
						|| LR_PYMT_DT.before(M_LR_PYMT_DT)
						|| (LR_PYMT_DT.equals(M_LR_PYMT_DT))) {
					getErrorMap()
							.put(
									"current",
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"71088").getSummary());
					setLR_PYMT_DT_FOCUS("LR_PYMT_DT");
					return;
				} else {
					getErrorMap().clear();
				}
			}
			String calcLocalIntValue = CALC_LOAN_INTEREST_Delegate(
					CommonUtils.getProcedureValue(LR_LOAN_SYS_ID), modified_LR_PYMT_DT, M_LC_OS_AMOUNT
							.toString(), String.valueOf(LR_LC_INT_AMT));
			if(calcLocalIntValue != null){
			LR_LC_INT_AMT = Double.valueOf(calcLocalIntValue);
			}
			System.out.println("calcLocalIntValue = " + calcLocalIntValue);

			M_EXRATE = P_GET_EXCHANGE_RATE_Delegate(M_CUST_CURR_CODE,
					M_CURR_RATE_BS, modified_LR_PYMT_DT, "", "E");
			System.out.println("M_EXRATE = " + M_EXRATE);
			LR_FC_INT_AMT = (LR_LC_INT_AMT / M_EXRATE);

			// LR_FC_INT_AMT = LR_LC_INT_AMT; // Doubt (For Testing)

			/**
			 * Implementing Triggers of LR_LC_INT_AMT & LR_FC_INT_AMT Starts
			 * Here
			 */
			LR_LC_INT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_LC_INT_AMT), "R");
			LR_FC_INT_AMT = P_VAL_ROUND_AMT_Delegate(M_CUST_CURR_CODE, String
					.valueOf(LR_FC_INT_AMT), "R");

			/*
			 * LR_LC_INT_AMT =
			 * P_VAL_FC_LC_TOLERANCE_Delegate(String.valueOf(LR_FC_INT_AMT),
			 * String.valueOf(LR_LC_INT_AMT), "", "E");
			 * if(obj.getLR_FC_PYMT_AMT()<obj.getLR_FC_INT_AMT()){
			 * getErrorMap().put("current",
			 * Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
			 * "91102").getSummary()); }else{ getErrorMap().clear(); }
			 * 
			 * Double LR_FC_LOAN_AMT =
			 * (obj.getLR_FC_PYMT_AMT()-obj.getLR_FC_INT_AMT());
			 * obj.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);
			 * 
			 * Double LR_LC_LOAN_AMT =
			 * (obj.getLR_LC_PYMT_AMT()-obj.getLR_LC_INT_AMT());
			 * obj.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
			 */

			/** Implementing Triggers of LR_LC_INT_AMT & LR_FC_INT_AMT Ends Here */

			obj.setLR_LC_INT_AMT(LR_LC_INT_AMT);
			obj.setLR_FC_INT_AMT(LR_LC_INT_AMT);
			setLR_PYMT_DT_FOCUS("LR_FC_PYMT_AMT");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void LR_FC_PYMT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) throws Exception {

		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap 
		= ctx.getExternalContext()
				.getSessionMap();
		String M_CUST_CURR_CODE = (String) sessionMap.get("M_CUST_CURR_CODE");
		String M_CURR_RATE_BS = (String) sessionMap.get("M_CURR_RATE_BS");
		Connection con = null;

		Double M_EXRATE = 0.0;
		Double LR_FC_INT_AMT = 0.0;

		Double LR_FC_PYMT_AMT = obj.getLR_FC_PYMT_AMT() == null ? 0.0 : obj
				.getLR_FC_PYMT_AMT();
		// obj.setLR_FC_PYMT_AMT(0.0);

		// Newly added below code on 19.2.2017 by Dhinesh
		if(LR_FC_PYMT_AMT < obj.getLR_FC_INT_AMT())
		{
			throw new Exception ("The Payment amount should be greater than or equal interest/EMI. ");
		} // End
		if (LR_FC_PYMT_AMT <= 0.0) {
			setLR_FC_PYMT_AMT_FOCUS("LR_FC_PYMT_AMT");
			getErrorMap().put("current",
					"LR_FC_PYMT_AMT: Correct Value is Required.");
		} else {
			getErrorMap().clear();
			try {
				con = CommonUtils.getConnection();
				String modified_LR_PYMT_DT = (String) sessionMap
						.get("modified_LR_PYMT_DT");
				LR_FC_INT_AMT = obj.getLR_FC_INT_AMT() == null ? 0.0 : obj
						.getLR_FC_INT_AMT();

				System.out.println("Checking LR_FC_INT_AMT = " + LR_FC_INT_AMT);
				System.out.println("Checking LR_FC_PYMT_AMT = "
						+ LR_FC_PYMT_AMT);

				/**
				 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment details
				 * button should not be disabled for approved record.
				 */
				if (LR_FC_PYMT_AMT > 0.0) {
					// getPymtDetails().setDisabled(false);
				} else {
					// getPymtDetails().setDisabled(true);
				}
				/** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] */

				if (LR_FC_PYMT_AMT < LR_FC_INT_AMT) {
					getErrorMap()
							.put(
									"current",
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"91102").getSummary());
					getErrorMap()
							.put(
									"LR_FC_PYMT_AMT",
									Messages
											.getMessage(
													"com.iii.premia.common.errorUtil.PELErrorMessages",
													"91102").getSummary());
					return;
				} else {
					getErrorMap().clear();
				}
				LR_FC_PYMT_AMT = P_VAL_ROUND_AMT_Delegate(M_CUST_CURR_CODE,
						String.valueOf(LR_FC_PYMT_AMT), "R");
				System.out
						.println("LR_FC_PYMT_AMT_WhenValidateItem - LR_FC_PYMT_AMT = "
								+ LR_FC_PYMT_AMT);

				M_EXRATE = P_GET_EXCHANGE_RATE_Delegate(M_CUST_CURR_CODE,
						M_CURR_RATE_BS, modified_LR_PYMT_DT, "", "E");
				System.out
						.println("LR_FC_PYMT_AMT_WhenValidateItem - M_EXRATE = "
								+ M_EXRATE);

				Double LR_LC_PYMT_AMT = (M_EXRATE * LR_FC_PYMT_AMT);
				LR_LC_PYMT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
						.valueOf(LR_LC_PYMT_AMT), "R");
				// LR_FC_PYMT_AMT = LR_LC_PYMT_AMT;
				obj.setLR_LC_PYMT_AMT(LR_LC_PYMT_AMT);
				obj.setLR_FC_PYMT_AMT(LR_FC_PYMT_AMT);

				
				// Newly added below code on 19.2.2017 by Dhinesh
				
				LR_FC_LOAN_AMT_WhenValidateItem(obj);
				
				// End
				
				
				
				//Double LR_FC_LOAN_AMT = NVLDouble(obj.getLR_FC_PYMT_AMT(), 0.0);
						//- NVLDouble(obj.getLR_FC_INT_AMT(), 0.0);
				/** Added below lines */
				/*LR_FC_LOAN_AMT = P_VAL_ROUND_AMT_Delegate(M_CUST_CURR_CODE,
						String.valueOf(LR_FC_LOAN_AMT), "R");
				obj.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);*/

				Double M_FC_OS_AMOUNT = (Double) sessionMap
						.get("M_FC_OS_AMOUNT");
				System.out.println("M_FC_OS_AMOUNT = " + M_FC_OS_AMOUNT);
				System.out.println("LR_FC_PYMT_AMT+LR_FC_INT_AMT = "
						+ (NVLDouble(obj.getLR_FC_PYMT_AMT(), 0.0) + NVLDouble(
								obj.getLR_FC_INT_AMT(), 0.0)));
				Double allowedAmount = (M_FC_OS_AMOUNT + NVLDouble(obj
						.getLR_FC_INT_AMT(), 0.0));
				if (allowedAmount < (NVLDouble(obj.getLR_FC_PYMT_AMT(), 0.0))) {
					getErrorMap().put("current",
							"Repayment Cannot be more than " + allowedAmount);
					setLR_FC_PYMT_AMT_FOCUS("LR_FC_PYMT_AMT");
				} else {
					getErrorMap().clear();
					setLR_FC_PYMT_AMT_FOCUS("LR_LC_PYMT_AMT");
				}
				/*
				 * System.out.println("LR_SYS_ID = "+obj.getLR_SYS_ID());
				 * System.out.println("LR_LOAN_SYS_ID =
				 * "+obj.getLR_LOAN_SYS_ID());
				 * System.out.println("LOAN_POL_SYS_ID =
				 * "+CommonUtils.getGlobalVariable("LOAN_POL_SYS_ID"));
				 */
				String LOAN_POL_SYS_ID = CommonUtils
						.getGlobalVariable("LOAN_POL_SYS_ID");

				if (!"".equals(obj.getLR_SYS_ID())
						&& String.valueOf(obj.getLR_SYS_ID()) == null) {
					String result = P_UPD_REPAY_DTL_Delegate(String.valueOf(obj
							.getLR_LOAN_SYS_ID()), LOAN_POL_SYS_ID, String
							.valueOf(obj.getLR_SYS_ID()), String
							.valueOf(LR_FC_PYMT_AMT), String
							.valueOf(LR_LC_PYMT_AMT), "BND", M_CUST_CURR_CODE);
					System.out.println("P_UPD_REPAY_DTL RESULT = " + result);
				}
				
				/* Commented below code on 19.2.2017 by Dhinesh
 				
				Double total = obj.getLR_FC_LOAN_AMT() + obj.getLR_FC_INT_AMT();
					if(!(total.equals(obj.getLR_FC_PYMT_AMT()))){
						throw new Exception ("The Paid Amount should be equal to Due Amount");
					}
				 */
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			}
			obj.setLR_LC_PYMT_AMT(LR_FC_PYMT_AMT);
			setLR_FC_PYMT_AMT_FOCUS("LR_LC_PYMT_AMT");
			LR_LC_PYMT_AMT_WhenValidateItem(obj);
		}

		return;

	}	


	private void LR_LC_PYMT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) {

		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();
		Double LR_LC_INT_AMT = obj.getLR_LC_INT_AMT();
		Double LR_LC_PYMT_AMT = obj.getLR_LC_PYMT_AMT();
		Double LR_FC_PYMT_AMT = obj.getLR_FC_PYMT_AMT();
		
		/*Newly added below code on 19.2.2017 by Dhinesh*/

		Double LR_FC_INT_AMT = obj.getLR_FC_INT_AMT();
		
		/*END*/
		
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			if (LR_LC_PYMT_AMT < NVLDouble(LR_LC_INT_AMT, 0.0)) {
				getErrorMap()
						.put(
								"current",
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"91102").getSummary());
			} else {
				getErrorMap().clear();
			}

			LR_LC_PYMT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_LC_PYMT_AMT), "R");
			System.out
					.println("LR_LC_PYMT_AMT_WhenValidateItem - LR_LC_PYMT_AMT-VAL AMT = "
							+ LR_LC_PYMT_AMT);

			/*Newly added below code on 19.2.2017 by Dhinesh*/
			
			LR_FC_PYMT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_FC_PYMT_AMT), "R");
			
			/*END*/
			
			/*
			 * LR_LC_PYMT_AMT =
			 * P_VAL_FC_LC_TOLERANCE_Delegate(String.valueOf(LR_FC_PYMT_AMT),
			 * String.valueOf(LR_LC_PYMT_AMT), "", "E");
			 * System.out.println("LR_LC_PYMT_AMT_WhenValidateItem -
			 * LR_LC_PYMT_AMT-TOL = "+LR_LC_PYMT_AMT);
			 */

			Double LR_LC_LOAN_AMT = (NVLDouble(LR_LC_PYMT_AMT, 0.0) - NVLDouble(
					LR_LC_INT_AMT, 0.0));
			/** Added Below Line */
			LR_LC_LOAN_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_LC_LOAN_AMT), "R");

			/*Newly added below code on 19.2.2017 by Dhinesh*/
			
			Double LR_FC_LOAN_AMT = (NVLDouble(LR_FC_PYMT_AMT, 0.0) - NVLDouble(
					LR_FC_INT_AMT, 0.0));
			LR_FC_LOAN_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_FC_LOAN_AMT), "R");
			
			/*END*/
			
			Double M_LC_OS_AMOUNT = (Double) sessionMap.get("M_LC_OS_AMOUNT");
			Double allowedAmount = (M_LC_OS_AMOUNT + NVLDouble(obj
					.getLR_LC_INT_AMT(), 0.0));
			if (allowedAmount < (NVLDouble(obj.getLR_LC_PYMT_AMT(), 0.0))) {
				getErrorMap().put("current",
						"Repayment Cannot be more than " + allowedAmount);
				setLR_LC_PYMT_AMT_FOCUS("LR_LC_PYMT_AMT");
			} else {
				getErrorMap().clear();
				setLR_LC_PYMT_AMT_FOCUS("LR_PYMT_REF_NO");
			}

			System.out
					.println("LR_LC_PYMT_AMT_WhenValidateItem - LR_LC_PYMT_AMT = "
							+ LR_LC_PYMT_AMT);
			System.out
					.println("LR_LC_PYMT_AMT_WhenValidateItem - LR_LC_INT_AMT = "
							+ LR_LC_INT_AMT);
			System.out
					.println("LR_LC_PYMT_AMT_WhenValidateItem - LR_LC_LOAN_AMT = "
							+ LR_LC_LOAN_AMT);
			obj.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
			obj.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

    /*	Newly added below code on 19.2.2017 by Dhinesh  */
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/* END */
	private void LR_FC_INT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();
		String M_CUST_CURR_CODE = (String) sessionMap.get("M_CUST_CURR_CODE");
		String M_CURR_RATE_BS = (String) sessionMap.get("M_CURR_RATE_BS");
		String modified_LR_PYMT_DT = (String) sessionMap
				.get("modified_LR_PYMT_DT");
		Double LR_FC_INT_AMT = obj.getLR_FC_INT_AMT();
		Double M_EXRATE = 0.0;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			LR_FC_INT_AMT = P_VAL_ROUND_AMT_Delegate(M_CUST_CURR_CODE, String
					.valueOf(LR_FC_INT_AMT), "R");
			System.out
					.println("LR_FC_INT_AMT_WhenValidateItem - LR_FC_INT_AMT = "
							+ LR_FC_INT_AMT);

			M_EXRATE = P_GET_EXCHANGE_RATE_Delegate(M_CUST_CURR_CODE,
					M_CURR_RATE_BS, modified_LR_PYMT_DT, "", "E");
			System.out.println("LR_FC_INT_AMT_WhenValidateItem - M_EXRATE = "
					+ M_EXRATE);

			Double LR_LC_INT_AMT = (M_EXRATE * LR_FC_INT_AMT);
			obj.setLR_LC_INT_AMT(LR_LC_INT_AMT);

			LR_FC_INT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_FC_INT_AMT), "R");
			obj.setLR_FC_INT_AMT(LR_FC_INT_AMT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	private void LR_LC_INT_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();

		Double LR_LC_INT_AMT = obj.getLR_LC_INT_AMT();
		Double LR_FC_INT_AMT = obj.getLR_FC_INT_AMT();
		Double M_EXRATE = 0.0;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			LR_LC_INT_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_LC_INT_AMT), "R");
			// System.out.println("LR_LC_INT_AMT_WhenValidateItem -
			// LR_LC_INT_AMT = "+LR_LC_INT_AMT);

			LR_LC_INT_AMT = P_VAL_FC_LC_TOLERANCE_Delegate(String
					.valueOf(LR_FC_INT_AMT), String.valueOf(LR_LC_INT_AMT), "",
					"E");
			
			System.out
					.println("LR_LC_INT_AMT_WhenValidateItem -LR_LC_INT_AMT = "
							+ LR_LC_INT_AMT);

			if (obj.getLR_FC_PYMT_AMT() < obj.getLR_FC_INT_AMT()) {
				getErrorMap()
						.put(
								"current",
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"91102").getSummary());
			} else {
				getErrorMap().clear();
			}

			Double LR_FC_LOAN_AMT = (obj.getLR_FC_PYMT_AMT() - obj
					.getLR_FC_INT_AMT());
			obj.setLR_FC_LOAN_AMT(LR_FC_LOAN_AMT);

			Double LR_LC_LOAN_AMT = (obj.getLR_LC_PYMT_AMT() - obj
					.getLR_LC_INT_AMT());
			obj.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	private void LR_FC_LOAN_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();

		Double LR_FC_LOAN_AMT = obj.getLR_FC_LOAN_AMT();
		Double M_FC_OS_AMOUNT = (Double) sessionMap.get("M_FC_OS_AMOUNT");
		String M_CUST_CURR_CODE = (String) sessionMap.get("M_CUST_CURR_CODE");
		String M_CURR_RATE_BS = (String) sessionMap.get("M_CURR_RATE_BS");
		String modified_LR_PYMT_DT = (String) sessionMap
				.get("modified_LR_PYMT_DT");
		Double M_EXRATE = 0.0;
		Connection con = null;

		CommonUtils.setGlobalVariable("M_CUST_CURR_CODE", M_CUST_CURR_CODE);

		System.out.println("M_FC_OS_AMOUNT = " + M_FC_OS_AMOUNT);
		try {
			con = CommonUtils.getConnection();
			if (LR_FC_LOAN_AMT > M_FC_OS_AMOUNT) {
				getErrorMap()
						.put(
								"current",
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"71089").getSummary());
			} else {
				getErrorMap().clear();
			}

			LR_FC_LOAN_AMT = P_VAL_ROUND_AMT_Delegate(M_CUST_CURR_CODE, String
					.valueOf(LR_FC_LOAN_AMT), "R");
			System.out
					.println("LR_FC_LOAN_AMT_WhenValidateItem - LR_FC_LOAN_AMT = "
							+ LR_FC_LOAN_AMT);

			M_EXRATE = P_GET_EXCHANGE_RATE_Delegate(M_CUST_CURR_CODE,
					M_CURR_RATE_BS, modified_LR_PYMT_DT, "", "E");
			System.out.println("LR_FC_LOAN_AMT_WhenValidateItem - M_EXRATE = "
					+ M_EXRATE);

			Double LR_LC_LOAN_AMT = (M_EXRATE * LR_FC_LOAN_AMT);
			LR_LC_LOAN_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_LC_LOAN_AMT), "R");
			obj.setLR_LC_LOAN_AMT(LR_LC_LOAN_AMT);
			obj.setLR_FC_LOAN_AMT(LR_LC_LOAN_AMT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	private void LR_LC_LOAN_AMT_WhenValidateItem(PT_IL_LOAN_REPAYMENT obj) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();

		Double LR_LC_LOAN_AMT = obj.getLR_LC_LOAN_AMT();
		Double LR_FC_LOAN_AMT = obj.getLR_FC_LOAN_AMT();
		Double M_LC_OS_AMOUNT = (Double) sessionMap.get("M_LC_OS_AMOUNT");
		Double M_EXRATE = 0.0;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			if ((LR_LC_LOAN_AMT < 0.0) || (LR_LC_LOAN_AMT > M_LC_OS_AMOUNT)) {
				getErrorMap()
						.put(
								"current",
								Messages
										.getMessage(
												"com.iii.premia.common.errorUtil.PELErrorMessages",
												"71089").getSummary());
			} else {
				getErrorMap().clear();
			}

			LR_LC_LOAN_AMT = P_VAL_ROUND_AMT_Delegate("BND", String
					.valueOf(LR_LC_LOAN_AMT), "R");
			System.out
					.println("LR_LC_LOAN_AMT_WhenValidateItem - LR_LC_LOAN_AMT = "
							+ LR_LC_LOAN_AMT);

			LR_LC_LOAN_AMT = P_VAL_FC_LC_TOLERANCE_Delegate(String
					.valueOf(LR_FC_LOAN_AMT), String.valueOf(LR_LC_LOAN_AMT),
					"", "E");
			System.out
					.println("LR_LC_LOAN_AMT_WhenValidateItem - LR_LC_LOAN_AMT = "
							+ LR_LC_LOAN_AMT);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return;
	}

	/*
	 * lic void LR_PYMT_REF_NO_WhenValidateItem(ActionEvent event){
	 * CommonUtils.clearMaps(this); //int rowIndex = dT.getRowIndex(); int x =
	 * 0; // System.out.println("Row Index = "+rowIndex); //PT_IL_LOAN_REPAYMENT
	 * repay = gridDisplay.get(rowIndex); //String PYMT_REF_NO =
	 * repay.getLR_PYMT_REF_NO(); x = testCheck(getGridDisplay(), PYMT_REF_NO); //
	 * System.out.println("PYMT_REF_NO = "+PYMT_REF_NO);
	 * System.out.println("testCheck(getGridDisplay(), PYMT_REF_NO) =
	 * "+testCheck(getGridDisplay(), PYMT_REF_NO)); if("".equals(PYMT_REF_NO)){
	 * getErrorMap().put("current", "Payment Reference No. cannnot be Empty :
	 * Value Required."); setLR_REF_NO_FOCUS("LR_PYMT_REF_NO"); }else if(x>1){
	 * getErrorMap().put("current", "Duplicate Payment Reference No. Please
	 * Re-Enter."); setLR_REF_NO_FOCUS("LR_PYMT_REF_NO"); }else {
	 * getErrorMap().clear(); //lastColumnListener(); setLR_REF_NO_FOCUS("");
	 */

	public void LR_PYMT_REF_NO_WhenValidateItem(ActionEvent event) {

	}

	private int testCheck(List<PT_IL_LOAN_REPAYMENT> list, String ref) {
		int count = 0;
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			PT_IL_LOAN_REPAYMENT object = (PT_IL_LOAN_REPAYMENT) iter.next();
			if (object.getLR_PYMT_REF_NO().equals(ref)) {
				count++;
			}
		}
		return count;
	}

	/* Field-Level validations for the LOAN_REPAYMENT BLOCK Ends here. */

	public String lastColumnListener() {
		int currRowIndex = getDT().getRowIndex();
		System.out.println("Current Row Index = " + currRowIndex);
		int rowUpdated = 0;
		PT_IL_LOAN_REPAYMENT gridValueBean = null;
		// System.out.println("$$$$$$$$$$$$$$$$$ DataTableList Size =
		// "+gridDisplay.size());
		try {
			// Get the bean based on row index
			gridValueBean = (PT_IL_LOAN_REPAYMENT) gridDisplay
					.get(currRowIndex);
			// System.out.println("LR_LOAN_SYSID =
			// "+gridValueBean.getLR_LOAN_SYS_ID());
			// System.out.println("ROWID = "+gridValueBean.getROWID());
			/*
			 * System.out.println("Code Description =
			 * "+gridValueBean.getUI_M_GTD_COVER_CODE_DESC());
			 */
			// Update the record to database
			if (gridValueBean.getROWID() != null) {
				rowUpdated = updateData(gridValueBean);
				getWarningMap()
						.put("current", rowUpdated + " Records Updated.");
			} else {
				rowUpdated = updateData(gridValueBean);
				getWarningMap().put("current",
						rowUpdated + " Records Inserted.");
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			// TODO Put error mechanism to display user that something happened
			// wrong while updating data
			e1.printStackTrace();
			// getErrorMap().put("current", "Error Occured while Inserting or
			// Updating the record.");
		}

		return "";
	}

	public int updateData(PT_IL_LOAN_REPAYMENT dataGridBean) throws Exception {
		CRUDHandler dbHandler = new CRUDHandler();
		Connection con = null;
		int rowUpdated = 0;
		try {
			con = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(dataGridBean, con);
			con.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	/***/
	public String approveActionButton() {
		String approve = "PILT005_APPROVE";
		int count = 0;
		Connection con = null;
		if (gridDisplay != null) {
			for (int index = 0; index < gridDisplay.size(); index++) {
				PT_IL_LOAN_REPAYMENT valueBean = (PT_IL_LOAN_REPAYMENT) getGridDisplay()
						.get(index);
				// if(valueBean.isCheckBoxValue())
				if ("dataTableSelectedRow".equalsIgnoreCase(valueBean
						.getRowSelected())) {
					System.out.println("The Selected RowIndex = " + index);
					count = count + 1;
				}
			}

			if (count == 1) {
				for (int i = 0; i < gridDisplay.size(); i++) {
					PT_IL_LOAN_REPAYMENT valueBean = (PT_IL_LOAN_REPAYMENT) getGridDisplay()
							.get(i);
					if ("dataTableSelectedRow".equalsIgnoreCase(valueBean
							.getRowSelected())) {

						try {
							CRUDHandler handler = new CRUDHandler();
							con = CommonUtils.getConnection();

							String query1 = "SELECT A.LOAN_POL_NO,B.POL_CUST_CODE,B.POL_CASH_YN,B.POL_DIVN_CODE,C.CUST_NAME"
									+ " FROM   PT_IL_LOAN A,PT_IL_POLICY B,PM_CUSTOMER C,PT_IL_LOAN_REPAYMENT D"
									+ " WHERE A.LOAN_SYS_ID = D.LR_LOAN_SYS_ID AND B.POL_NO = A.LOAN_POL_NO AND C.CUST_CODE = B.POL_CUST_CODE AND A.LOAN_SYS_ID = '"
									+ valueBean.getLR_LOAN_SYS_ID() + "'";

							ResultSet resultSet1 = handler
									.executeSelectStatement(query1, con);

							String M_POL_NO = null;
							String M_POL_CUST_CODE = null;
							String M_POL_CASH_YN = null;
							String M_POL_DIVN_CODE = null;
							String M_CUST_DESC = null;

							while (resultSet1.next()) {
								M_POL_NO = resultSet1.getString(1);
								M_POL_CUST_CODE = resultSet1.getString(2);
								M_POL_CASH_YN = resultSet1.getString(3);
								M_POL_DIVN_CODE = resultSet1.getString(4);
								M_CUST_DESC = resultSet1.getString(5);
							}

							String M_TEMP = null;
							Double M_SUM = 0.0;

							Double LR_FC_LOAN_AMT = valueBean
									.getLR_FC_LOAN_AMT();
							Double LR_LC_INT_AMT = valueBean.getLR_FC_INT_AMT();

							String query2 = "SELECT 'X' FROM PT_IL_PYMT_DTLS A, PT_IL_LOAN_REPAYMENT B WHERE A.PD_TXN_TYPE = 'LR' AND A.PD_TXN_SYS_ID = B.LR_SYS_ID AND A.PD_TXN_SYS_ID = '"
									+ valueBean.getLR_SYS_ID() + "'";
							String query3 = "SELECT SUM(A.PD_LC_AMT) FROM PT_IL_PYMT_DTLS A, PT_IL_LOAN_REPAYMENT B WHERE A.PD_TXN_TYPE = 'LR' AND A.PD_TXN_SYS_ID = B.LR_SYS_ID  AND A.PD_TXN_SYS_ID = '"
									+ valueBean.getLR_SYS_ID()
									+ "' GROUP BY A.PD_TXN_SYS_ID";
							ResultSet resultSet2 = handler
									.executeSelectStatement(query2, con);

							while (resultSet2.next()) {
								M_TEMP = resultSet2.getString(1);
							}
							// System.out.println("M_TEMP = "+M_TEMP);

							if (!"".equals(M_TEMP)
									&& String.valueOf(M_TEMP) != null) {
								ResultSet resultSet3 = handler
										.executeSelectStatement(query3, con);
								while (resultSet3.next()) {
									M_SUM = Double.valueOf(resultSet3
											.getString(1));
								}
								/** Commented For Testing */
								if (M_SUM != (LR_FC_LOAN_AMT + (commonUtils
										.nvl(LR_LC_INT_AMT, 0.0)))
										&& (M_SUM != 0.0)) {
									getErrorMap()
											.put(
													"current",
													Messages
															.getMessage(
																	"com.iii.premia.common.errorUtil.PELErrorMessages",
																	"91043")
															.getSummary());
									approve = "";
								} else if (M_SUM == 0.0) {
									getErrorMap()
											.put(
													"current",
													Messages
															.getMessage(
																	"com.iii.premia.common.errorUtil.PELErrorMessages",
																	"91171")
															.getSummary());
									approve = "";
								} else {
									getErrorMap().clear();
								}
							} else {
								getErrorMap()
										.put(
												"current",
												Messages
														.getMessage(
																"com.iii.premia.common.errorUtil.PELErrorMessages",
																"91171")
														.getSummary());
								approve = "";
							}
							/** Commented For Testing */

							if (M_POL_CASH_YN.equalsIgnoreCase("N")) {
								// M_CUST_DESC =
								// P_VAL_CLASS_CUST_Delegate("CUSTOMER",
								// M_POL_CUST_CODE, M_CUST_DESC, "N", "N",
								// M_POL_DIVN_CODE);
								System.out.println("M_CUST_DESC-1 = "
										+ M_CUST_DESC);
							} else {
								// M_CUST_DESC =
								// P_VAL_CLASS_CUST_Delegate("CASH",
								// M_POL_CUST_CODE, M_CUST_DESC, "N", "N",
								// M_POL_DIVN_CODE);
								System.out.println("M_CUST_DESC-2 = "
										+ M_CUST_DESC);
							}

							Date M_APPR_DATE = null;
							String sysDateQuery = "SELECT SYSDATE FROM DUAL";
							ResultSet rs = handler.executeSelectStatement(
									sysDateQuery, con);
							while (rs.next()) {
								M_APPR_DATE = rs.getDate(1);
							}

							/** Setting Global Variables for Approval Page */
							CommonUtils.setGlobalVariable("M_POL_CUST_CODE",
									M_POL_CUST_CODE);
							CommonUtils.setGlobalVariable("M_CUST_DESC",
									M_CUST_DESC);
							CommonUtils.setGlobalObject("M_APPR_DATE",
									M_APPR_DATE);
							/** Setting Global Variables for Approval Page */

							FacesContext ctx = FacesContext
									.getCurrentInstance();
							Map<String, Object> sessMap = ctx
									.getExternalContext().getSessionMap();

							PI_LT_LOAN_APPR_ACTION repayApprove = new PI_LT_LOAN_APPR_ACTION();
							PT_IL_LOAN_APPROVE approveBean = repayApprove
									.getPT_IL_LOAN_APPROVE_BEAN();

							approveBean.setAPPR_DT(M_APPR_DATE);
							approveBean.setCUST_CODE(M_POL_CUST_CODE);
							approveBean.setUI_M_CUST_NAME(M_CUST_DESC);

							sessMap.put("PILT005_PT_IL_LOAN_REPAYMENT_APPROVE",
									repayApprove);
							CommonUtils.setGlobalObject(
									"PILT005_LOAN_REPAYMENT_VALUE_BEAN",
									valueBean);

						} catch (Exception e) {
							e.printStackTrace();
							getErrorMap().put(
									PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									e.getMessage());
							getErrorMap().put("Approve", e.getMessage());
						}
					}
				}
			} else {
				getWarningMap().put("current",
						"Select a CheckBox To Proceed Further.");
				approve = "";
			}
		}
		return approve;
	}

	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated:
	// 16-Feb-2009 ]

	/*
	 * public void gridtabListener(){
	 * 
	 * int currRowIndex = getDT().getRowIndex(); System.out.println("Current Row
	 * Index = "+currRowIndex); int rowUpdated = 0; PT_IL_LOAN_REPAYMENT
	 * gridValueBean = null; //System.out.println(lastUpdatedRowIndex+"
	 * "+currRowIndex+" "+prevRowIndex); try { if(lastUpdatedRowIndex!=-1) {
	 * if(lastUpdatedRowIndex!=prevRowIndex) { if(currRowIndex != prevRowIndex){
	 * System.out.println("GRID TAB LISTENER"); // Get the bean based on row
	 * index gridValueBean =
	 * (PT_IL_LOAN_REPAYMENT)gridDisplay.get(prevRowIndex);
	 *  // Update the record to database if(gridValueBean.getROWID()!=null) {
	 * rowUpdated = dataGridDelegate.updateData(gridValueBean);
	 * //errorMap.put("somekey", rowUpdated+" record updated.");
	 * //errorMap.put("current", rowUpdated+" record updated."); }else { //
	 * gridValueBean.setRSA_PLAN_CODE("dee"); rowUpdated =
	 * dataGridDelegate.updateData(gridValueBean);
	 * 
	 * //errorMap.put("somekey", rowUpdated+" record inserted.");
	 * //errorMap.put("current", rowUpdated+" record inserted.");
	 *  }
	 *  // Update previous row index prevRowIndex = currRowIndex; } } } } catch
	 * (Exception e1) { // TODO Put error mechanism to display user that
	 * something happened wrong while updating data e1.printStackTrace(); }
	 * 
	 * return ; }
	 */

	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated:
	// 16-Feb-2009 ]
	public String prevPage() {
		CommonUtils.setGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION",this);
		String outcome = null;
		String callingForm = CommonUtils.getGlobalVariable("PILT004_CALLING_FORM");
		if ("PILT004".equals(callingForm)) {
			outcome = "PILT004_PT_IL_LOAN";
		} else {
			outcome = "PILT005";
		}
		PT_IL_LOAN_ACTION action = (PT_IL_LOAN_ACTION) CommonUtils.getGlobalObject("PILT005_PT_IL_LOAN_ACTION");
		PT_IL_LOAN_REPAYMENT_ACTION actionRepay = (PT_IL_LOAN_REPAYMENT_ACTION) CommonUtils.getGlobalObject("PILT005_PT_IL_LOAN_REPAYMENT_ACTION");
		action.setBlockFlag(true);
		actionRepay.setBlockFlag(true);
		return outcome;
	}

	public HtmlOutputText getCOMP_LOAN_STATUS() {
		return COMP_LOAN_STATUS;
	}

	public void setCOMP_LOAN_STATUS(HtmlOutputText comp_loan_status) {
		COMP_LOAN_STATUS = comp_loan_status;
	}

	public String moreDetailsAction() {
		return "PILT005_LOAN_REPAYMENT_DTL";
	}

	/** Procedures * */

	public Double P_VAL_ROUND_AMT_Delegate(String var1, String var2, String var3) {
		/*
		 * var1 - IN Parameter var2 - IN OUT Parameter var3 - IN Parameter
		 */

		Double result = 0.0;
		Connection con = null;
		try {
			ArrayList<OracleParameter> inputVarList = new ArrayList<OracleParameter>();

			OracleParameter inputParam1 = new OracleParameter("in1", "STRING",
					"IN", var1);
			OracleParameter inputParam2 = new OracleParameter("in2", "STRING",
					"IN OUT", var2);
			OracleParameter inputParam3 = new OracleParameter("in3", "STRING",
					"IN", var3);
			inputVarList.add(inputParam1);
			inputVarList.add(inputParam2);
			inputVarList.add(inputParam3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			con = CommonUtils.getConnection();

			List resultList = procHandler.execute(inputVarList, con,
					"P_VAL_ROUND_AMT");
			Iterator resultIterator = resultList.iterator();

			while (resultIterator.hasNext()) {
				OracleParameter object = (OracleParameter) resultIterator
						.next();
				if (object.getFieldName().equals("in2")) {
					result = Double.valueOf(object.getValue().toString());
					// System.out.println("Result = "+result);
				}

			}
		} catch (Exception e) {
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con,
					FacesContext.getCurrentInstance(), "current",
					getErrorMap(), getWarningMap());
		}

		return result;
	}

	public Double P_GET_EXCHANGE_RATE_Delegate(String var1, String var2,
			String var3, String var4, String var5) {
		/*
		 * var1 - IN Parameter var2 - IN Parameter var3 - IN Parameter var4 -
		 * OUT Parameter var5 - IN Parameter
		 * 
		 */
		Double result = 0.0;
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			OracleProcedureHandler procHandler = new OracleProcedureHandler();

			ArrayList<OracleParameter> inputVarList = new ArrayList<OracleParameter>();
			OracleParameter inputParam1 = new OracleParameter("in1", "STRING",
					"IN", var1);
			OracleParameter inputParam2 = new OracleParameter("in2", "STRING",
					"IN", var2);
			OracleParameter inputParam3 = new OracleParameter("in3", "STRING",
					"IN", var3);
			OracleParameter inputParam4 = new OracleParameter("in4", "STRING",
					"OUT", var4);
			OracleParameter inputParam5 = new OracleParameter("in5", "STRING",
					"IN", var5);
			inputVarList.add(inputParam1);
			inputVarList.add(inputParam2);
			inputVarList.add(inputParam3);
			inputVarList.add(inputParam4);
			inputVarList.add(inputParam5);

			List exchangeRate = procHandler.execute(inputVarList, con,
					"P_GET_EXCHANGE_RATE");
			Iterator exchangeIter = exchangeRate.iterator();
			while (exchangeIter.hasNext()) {
				OracleParameter object = (OracleParameter) exchangeIter.next();
				if (object.getFieldName().equals("in4")) {
					result = Double.valueOf(object.getValue().toString());
				}
			}
		} catch (Exception e) {
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con,
					FacesContext.getCurrentInstance(), "current",
					getErrorMap(), getWarningMap());
		}

		return result;
	}

	public Double P_VAL_FC_LC_TOLERANCE_Delegate(String var1, String var2,
			String var3, String var4) {
		/*
		 * var1 - IN Parameter var2 - IN Parameter var3 - IN Parameter var4 - IN
		 * Parameter
		 * 
		 */
		Double result = 0.0;
		Connection con = null;
		try {
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			con = CommonUtils.getConnection();

			ArrayList<OracleParameter> toleranceList = new ArrayList<OracleParameter>();
			OracleParameter toleranceParam1 = new OracleParameter("in1",
					"STRING", "IN", var1);
			OracleParameter toleranceParam2 = new OracleParameter("in2",
					"STRING", "IN", var2);
			OracleParameter toleranceParam3 = new OracleParameter("in3",
					"STRING", "OUT", var3);
			OracleParameter toleranceParam4 = new OracleParameter("in4",
					"STRING", "IN", var4);
			toleranceList.add(toleranceParam1);
			toleranceList.add(toleranceParam2);
			toleranceList.add(toleranceParam3);
			toleranceList.add(toleranceParam4);

			List toleranceResult = procHandler.execute(toleranceList, con,
					"P_VAL_FC_LC_TOLERANCE");
			Iterator toleranceIter = toleranceList.iterator();
			while (toleranceIter.hasNext()) {
				OracleParameter object = (OracleParameter) toleranceIter.next();
				if (object.getFieldName().equals("in3")) {
					result = Double.valueOf(object.getValue().toString());
				}
			}
		} catch (Exception e) {
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con,
					FacesContext.getCurrentInstance(), "current",
					getErrorMap(), getWarningMap());
		}
		return result;
	}

	public String CALC_LOAN_INTEREST_Delegate(String var1, String var2,
			String var3, String var4) {
		/*
		 * var1 - IN Parameter var2 - IN Parameter var3 - IN Parameter var4 -
		 * OUT Parameter
		 */
		Connection con = null;
		String calcLocalIntValue = null;
		try {
			con = CommonUtils.getConnection();
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					var1);
			OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
					var2);
			OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
					var3);
			OracleParameter param4 = new OracleParameter("in4", "STRING",
					"OUT", var4);
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);

			List calcLocalInt = new ArrayList();
			calcLocalInt = procHandler.execute(paramList, con,
					"P9ILPK_LOAN.CALC_LOAN_INTEREST");
			Iterator it = calcLocalInt.iterator();
			while (it.hasNext()) {
				OracleParameter type = (OracleParameter) it.next();
				if (type.getFieldName().equals("in4")) {
					calcLocalIntValue = type.getValue();
				}
			}

		} catch (Exception e) {
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(con,
					FacesContext.getCurrentInstance(), "current",
					getErrorMap(), getWarningMap());
		}
		return calcLocalIntValue;
	}

	private String P_VAL_CLASS_CUST_Delegate(String var1, String var2,
			String var3, String var4, String var5, String var6)
			throws Exception {
		Connection con = null;
		String custName = "";
		ArrayList<OracleParameter> custVarList = new ArrayList<OracleParameter>();
		con = CommonUtils.getConnection();
		OracleParameter custVar1 = new OracleParameter("in1", "STRING", "IN",
				var1);
		OracleParameter custVar2 = new OracleParameter("in2", "STRING", "IN",
				var2);
		OracleParameter custVar3 = new OracleParameter("in3", "STRING",
				"IN OUT", var3);
		OracleParameter custVar4 = new OracleParameter("in4", "STRING", "IN",
				var4);
		OracleParameter custVar5 = new OracleParameter("in5", "STRING", "IN",
				var5);
		OracleParameter custVar6 = new OracleParameter("in6", "STRING", "IN",
				var6);

		custVarList.add(custVar1);
		custVarList.add(custVar2);
		custVarList.add(custVar3);
		custVarList.add(custVar4);
		custVarList.add(custVar5);
		custVarList.add(custVar6);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();

		List resultList = procHandler.execute(custVarList, con,
				"P_VAL_CLASS_CUST");
		Iterator resultIterator = resultList.iterator();

		while (resultIterator.hasNext()) {
			OracleParameter object = (OracleParameter) resultIterator.next();
			if (object.getFieldName().equals("in3")) {
				custName = NVLString(object.getValue(), "");
			}
		}

		return custName;
	}

	private String P_UPD_REPAY_DTL_Delegate(String var1, String var2,
			String var3, String var4, String var5, String var6, String var7) {
		Connection con = null;
		String result = "";
		try {
			ArrayList<OracleParameter> custVarList = new ArrayList<OracleParameter>();
			con = CommonUtils.getConnection();
			OracleParameter custVar1 = new OracleParameter("in1", "STRING", "",
					var1);
			OracleParameter custVar2 = new OracleParameter("in2", "STRING", "",
					var2);
			OracleParameter custVar3 = new OracleParameter("in3", "STRING", "",
					var3);
			OracleParameter custVar4 = new OracleParameter("in4", "STRING", "",
					var4);
			OracleParameter custVar5 = new OracleParameter("in5", "STRING", "",
					var5);
			OracleParameter custVar6 = new OracleParameter("in6", "STRING", "",
					var6);
			OracleParameter custVar7 = new OracleParameter("in7", "STRING", "",
					var7);

			custVarList.add(custVar1);
			custVarList.add(custVar2);
			custVarList.add(custVar3);
			custVarList.add(custVar4);
			custVarList.add(custVar5);
			custVarList.add(custVar6);
			custVarList.add(custVar7);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();

			List resultList = procHandler.execute(custVarList, con,
					"P9ilpk_Loan.P_UPD_REPAY_DTL");
			Iterator resultIterator = resultList.iterator();

			while (resultIterator.hasNext()) {
				OracleParameter object = (OracleParameter) resultIterator
						.next();
				if (object.getFieldName().equals("")) {
					result = object.getValue();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String getLR_PYMT_DT_FOCUS() {
		return LR_PYMT_DT_FOCUS;
	}

	public void setLR_PYMT_DT_FOCUS(String lr_pymt_dt_focus) {
		LR_PYMT_DT_FOCUS = lr_pymt_dt_focus;
	}

	Integer NVLInteger(Integer first, Integer second) {
		if (first == null) {
			first = second;
		}
		return first;
	}

	Double NVLDouble(Double first, Double second) {
		if (first == null) {
			first = second;
		}
		return first;
	}

	String NVLString(String first, String second) {
		if ((first == null) || first.equals("")) {
			first = second;
		}
		return first;
	}

	public String paymentDetailsNav() {
		int count = 0;
		PT_IL_PYMT_DTLS_ACTION paymentAction = null;
		String res = "";
		if (gridDisplay != null) {
			for (int index = 0; index < gridDisplay.size(); index++) {
				PT_IL_LOAN_REPAYMENT valueBean = (PT_IL_LOAN_REPAYMENT) getGridDisplay()
						.get(index);
				if ("dataTableSelectedRow".equalsIgnoreCase(valueBean
						.getRowSelected())) {
					System.out.println("The Selected RowIndex = " + index);
					count = count + 1;
				}
			}

			if ((count > 1) || (count != 1)) {
				getErrorMap().put("current",
						"Select One CheckBox To Proceed Further.");
				res = "SELECT_ONE_CHECKBOX";
			} else if (count == 1) {
				for (int i = 0; i < gridDisplay.size(); i++) {
					getErrorMap().clear();
					PT_IL_LOAN_REPAYMENT valueBean = (PT_IL_LOAN_REPAYMENT) getGridDisplay()
							.get(i);
					// if(valueBean.isCheckBoxValue()){
					if ("dataTableSelectedRow".equalsIgnoreCase(valueBean
							.getRowSelected())) {
						PT_IL_PYMT_DTLS paymentBean = new PT_IL_PYMT_DTLS();

						System.out.println("PILT005_LR_SYS_ID = "
								+ valueBean.getLR_SYS_ID());
						System.out.println("GLOBAL.TXN_TYPE = LR");
						System.out.println("GLOBAL.CURR_CODE = "
								+ CommonUtils
										.getGlobalVariable("M_CUST_CURR_CODE"));
						Double FC_AMT = (NVLDouble(valueBean
								.getLR_FC_LOAN_AMT(), 0.0) + NVLDouble(
								valueBean.getLR_FC_INT_AMT(), 0.0));
						System.out.println("GLOBAL.FC_AMT = " + FC_AMT);
						Double LC_AMT = (NVLDouble(valueBean
								.getLR_LC_LOAN_AMT(), 0.0) + NVLDouble(
								valueBean.getLR_LC_INT_AMT(), 0.0));
						System.out.println("GLOBAL.LC_AMT = " + LC_AMT);

						String M_CUST_CURR_CODE = CommonUtils
								.getGlobalVariable("M_CUST_CURR_CODE");
						Double LOAN_EXCH_RATE = 0d;
						/*Commented  by raja on 18-02-2017*/
						/*if (CommonUtils.getGlobalObject("LOAN_EXCH_RATE") instanceof Double) {
							LOAN_EXCH_RATE = (Double) CommonUtils
									.getGlobalObject("LOAN_EXCH_RATE");
						}*/
						/* added by raja on 18-02-2017 */
						System.out.println("GlobalVariable  ---  LOAN_EXCH_RATE  "+CommonUtils.getGlobalVariable("LOAN_EXCH_RATE"));
						System.out.println("getGlobalObject ---  LOAN_EXCH_RATE  "+CommonUtils.getGlobalObject("LOAN_EXCH_RATE"));
						
						if (CommonUtils.getGlobalVariable("LOAN_EXCH_RATE")!=null) {
							LOAN_EXCH_RATE = Double.valueOf(CommonUtils
									.getGlobalObject("LOAN_EXCH_RATE").toString());
						}
						
						
						/*Newly added below code on 19.2.2017 by RAJA*/
						
						CommonUtils.setGlobalObject("GLOBAL.FC_PYMT_AMT",valueBean.getLR_FC_PYMT_AMT());
						CommonUtils.setGlobalObject("GLOBAL.LC_PYMT_AMT",valueBean.getLR_FC_PYMT_AMT());
						
						/*end*/
						
						
						/** Setting Global Variables */
						CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID",
								valueBean.getLR_SYS_ID());
						CommonUtils.setGlobalObject("GLOBAL.TXN_TYPE", "LR");
						CommonUtils.setGlobalObject("GLOBAL.CURR_CODE",
								M_CUST_CURR_CODE);
						CommonUtils.setGlobalObject("GLOBAL.FC_AMT", FC_AMT);
						CommonUtils.setGlobalObject("GLOBAL.LC_AMT", LC_AMT);
						CommonUtils.setGlobalObject("GLOBAL.EXCH_RATE",
								LOAN_EXCH_RATE);
						/** Setting Global Variables */

						paymentBean.setPD_TXN_TYPE("LR");
						// Commented to avoid compilation error, Dated: 15-Feb,
						// Commented by: Manoj
						// paymentBean.setPD_TXN_SYS_ID(Double.valueOf(valueBean.getLR_SYS_ID()));
						paymentBean.setPD_CURR_CODE(M_CUST_CURR_CODE);
						paymentBean.setPD_FC_AMT(FC_AMT);
						paymentBean.setPD_LC_AMT(LC_AMT);
						/**
						 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment
						 * details button should not be disabled for approved
						 * record.
						 */
						String status = getPT_IL_LOAN_REPAYMENT_BEAN()
								.getLOAN_STATUS();
						boolean flag = false;
						if ("A".equals(status)) {
							flag = true;
						} else {
							flag = false;
						}
						if(paymentBean.getPD_SR_NO() != null){
							paymentAction = new PT_IL_PYMT_DTLS_ACTION();
							paymentAction.getCOMP_ADD_BUT().setDisabled(true);
							paymentAction.getCOMP_DEL_BUT().setDisabled(true);
							paymentAction.getCOMP_POST_BUT().setDisabled(true);
						}
						paymentAction = new PT_IL_PYMT_DTLS_ACTION(
								"goBackFromloan", paymentBean, flag);
						/** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] */
						res = paymentAction.gotoPaymentDetails();
					}
				}
			}
		}
		CommonUtils.setGlobalObject("CALLING_FORM", "PILT005");
		CommonUtils.setGlobalObject("LOAN_REPAYMENT_STATUS",getPT_IL_LOAN_REPAYMENT_BEAN()
				.getLR_STATUS());
		return res;
	}

	public String addNew() {
		int rowCount = 0;
		if (gridDisplay == null) {
			gridDisplay = new ArrayList<PT_IL_LOAN_REPAYMENT>();
		}

		Long LR_SYS_ID = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con;
		try {
			con = CommonUtils.getConnection();
			String query = "SELECT PIL_LR_SYS_ID.NEXTVAL FROM DUAL";
			ResultSet rs = handler.executeSelectStatement(query, con);
			PT_IL_LOAN_ACTION action = (PT_IL_LOAN_ACTION) new CommonUtils()
					.getMappedBeanFromSession("PILT005_PT_IL_LOAN_ACTION");
			PT_IL_LOAN bean = action.getPT_IL_LOAN_BEAN();
			while (rs.next()) {
				LR_SYS_ID = rs.getLong(1);
			}

			PT_IL_LOAN_REPAYMENT repay = LOAN_REPAYMENT_WHEN_CREATE_RECORD();
			repay.setLR_SYS_ID(LR_SYS_ID);
			repay.setLR_LOAN_SYS_ID(bean.getLOAN_SYS_ID());

			CommonUtils.setGlobalObject("PILT005_LR_LOAN_SYS_ID", bean
					.getLOAN_SYS_ID());

			gridDisplay.add(repay);
			rowCount = getDT().getRowCount();
			currPage = rowCount / recordsPerPage;
			if (rowCount % recordsPerPage > 0) {
				currPage++;
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String newRow() throws Exception {
		CommonUtils.clearMaps(this);
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();
		int rowCount = 0;
		if (gridDisplay == null) {
			gridDisplay = new ArrayList<PT_IL_LOAN_REPAYMENT>();
		}
		Long LR_SYS_ID = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = CommonUtils.getConnection();
		String query = "SELECT PIL_LR_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet rs = handler.executeSelectStatement(query, con);

		while (rs.next()) {
			LR_SYS_ID = rs.getLong(1);
		}
		PT_IL_LOAN_ACTION action = (PT_IL_LOAN_ACTION) sessionMap
				.get("PILT005_PT_IL_LOAN_ACTION");
		PT_IL_LOAN bean = action.getPT_IL_LOAN_BEAN();

		PT_IL_LOAN_REPAYMENT repay = LOAN_REPAYMENT_WHEN_CREATE_RECORD();
		repay.setLR_SYS_ID(LR_SYS_ID);
		repay.setLR_LOAN_SYS_ID(bean.getLOAN_SYS_ID());

		sessionMap.put("PILT005_LR_LOAN_SYS_ID", bean.getLOAN_SYS_ID());

		gridDisplay.add(repay);
		rowCount = getDT().getRowCount();
		currPage = rowCount / recordsPerPage;
		if (rowCount % recordsPerPage > 0) {
			currPage++;
		}
		return null;
	}

	/*
	 * public void deleteRow(ActionEvent event) { CommonUtils.clearMaps(this);
	 * PT_IL_LOAN_REPAYMENT bean = null; ArrayList deletedRecordList = null; int
	 * deletedRecordIndex = 0; if(gridDisplay!=null) { deletedRecordList = new
	 * ArrayList(); for(int index =0; index<gridDisplay.size();) {
	 * 
	 * bean = gridDisplay.get(index); if(bean.isCheckBoxValue()){
	 * gridDisplay.remove(bean); System.out.println("Remove Bean =
	 * "+bean.getLR_PYMT_REF_NO()); deletedRecordIndex = deleteData(bean);
	 * deletedRecordList.add(deletedRecordIndex); }else { index++; } }
	 * 
	 * if(deletedRecordList.size()>0) { //errorMap.put("somekey",
	 * deletedRecordList.size()+" records deleted."); //errorMap.put("current",
	 * deletedRecordList.size()+" records deleted."); } lastUpdatedRowIndex =
	 * -1;
	 *  } }
	 */

	public void deleteRow(ActionEvent ae) {

		try {
			getErrorMap().clear();
			getWarningMap().clear();

			if (isDELETE_ALLOWED()) {
				if (PT_IL_LOAN_REPAYMENT_BEAN.getROWID() != null) {
					// executeDelete(PM_CUST_DIVN_BEAN);
					new CRUDHandler().executeDelete(PT_IL_LOAN_REPAYMENT_BEAN,
							CommonUtils.getConnection());
					beanList.remove(PT_IL_LOAN_REPAYMENT_BEAN);
				}

				if (beanList.size() > 0) {
					setPT_IL_LOAN_REPAYMENT_BEAN(beanList.get(0));
				} else {
					AddRow(ae);
				}

				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				getWarningMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$delete"));
				resetAllComponent();

			} else {
				getErrorMap().clear();
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
	}

	public void post(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		try {
			if (PT_IL_LOAN_REPAYMENT_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					this.PRE_UPDTAE(PT_IL_LOAN_REPAYMENT_BEAN);
					new CRUDHandler().executeUpdate(PT_IL_LOAN_REPAYMENT_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$updatenotallowed"));
				}
			} else {

				if (isINSERT_ALLOWED()) {

					setPrimaryKey();

					this.PRE_INSERT(this, PT_IL_LOAN_REPAYMENT_BEAN,
							PT_IL_LOAN_REPAYMENT_DTL_BEAN);
					new CRUDHandler().executeInsert(PT_IL_LOAN_REPAYMENT_BEAN,
							CommonUtils.getConnection());
					CommonUtils.getConnection().commit();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insert"));
					beanList.add(PT_IL_LOAN_REPAYMENT_BEAN);
				} else {
					getErrorMap().clear();
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
					getWarningMap().put(
							"post",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$insertnotallowed"));
				}
			}
			resetAllComponent();
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}

	/**
	 * Sets Primary Key.
	 */
	private void setPrimaryKey() {
		Long LR_SYS_ID = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con;
		try {
			con = CommonUtils.getConnection();
			String query = "SELECT PIL_LR_SYS_ID.NEXTVAL FROM DUAL";
			ResultSet rs = handler.executeSelectStatement(query, con);
			PT_IL_LOAN_ACTION action = (PT_IL_LOAN_ACTION) new CommonUtils()
					.getMappedBeanFromSession("PILT005_PT_IL_LOAN_ACTION");
			PT_IL_LOAN bean = action.getPT_IL_LOAN_BEAN();
			while (rs.next()) {
				LR_SYS_ID = rs.getLong(1);
			}
			this.PT_IL_LOAN_REPAYMENT_BEAN.setLR_SYS_ID(LR_SYS_ID);
			this.PT_IL_LOAN_REPAYMENT_BEAN.setLR_LOAN_SYS_ID(bean
					.getLOAN_SYS_ID());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/*
	 * public void pt_il_loan_repayment__pre_update(PT_IL_LOAN_REPAYMENT
	 * divnBean) throws Exception{ String M_USER_ID =
	 * CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
	 * divnBean.setLR_CR_DT(new CommonUtils().getCurrentDate());
	 * divnBean.setLR_CR_UID(M_USER_ID);
	 * 
	 * //divnBean.setCDIV_CUST_CODE(custCode); }
	 * 
	 * public void pt_il_loan_repayment__pre_insert(PT_IL_LOAN_REPAYMENT
	 * divnBean) throws Exception{ String M_USER_ID =
	 * CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
	 * divnBean.setLR_CR_DT(new CommonUtils().getCurrentDate());
	 * divnBean.setLR_CR_UID(M_USER_ID); Connection conn = getConnection();
	 * String sys_id=null; try { // final dbms_output dbms_output1=new
	 * dbms_output(); String sql_C1="SELECT PIL_LR_SYS_ID.NEXTVAL AS LR_SYS_ID
	 * FROM DUAL "; ResultSet vembu_C1=null; Statement
	 * stmt_C1=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	 * vembu_C1=stmt_C1.executeQuery(sql_C1); if(vembu_C1.next()) {
	 * sys_id=vembu_C1.getString(1);
	 *  } int rowIndex = getDataTable().getRowIndex();
	 * beanList.get(rowIndex).setLR_SYS_ID((sys_id));
	 * System.out.println("PT_IL_LOAN_REPAYMENT_ACTION.ASSIGNING LR SYS
	 * ID"+sys_id); PT_IL_LOAN_REPAYMENT_BEAN.setLR_SYS_ID(sys_id);
	 * //divnBean.setCDIV_CUST_CODE(custCode); }catch(Exception e) {
	 * e.printStackTrace();
	 *  }
	 *  }
	 */

	public Connection getConnection() throws Exception {
		Connection connection = CommonUtils.getConnection();
		return connection;
	}

	public int deleteData(PT_IL_LOAN_REPAYMENT gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;

		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: " + value);
			}
		}
		return value;
	}

	public void checkBoxValidation(ActionEvent event) {
		// gridtabListener();
		CommonUtils.clearMaps(this);
		boolean checkBoxValue = Boolean.parseBoolean(getCurrentValue(event));
		int rowIndex = getDT().getRowIndex();
		getGridDisplay().get(rowIndex).setCheckBoxValue(checkBoxValue);
	}

	public String checkBoxStatus(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		boolean checkBoxValue = Boolean
				.parseBoolean(getCurrentValue(actionEvent));
		int rowIndex = getDT().getRowIndex();
		getGridDisplay().get(rowIndex).setCheckBoxValue(checkBoxValue);
		return "";
	}

	public void LoanStatusValidation(ActionEvent ae) throws Exception {
		CommonUtils.clearMaps(this);
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map sessionMap = ctx.getExternalContext().getSessionMap();
		getErrorMap().clear();
		PT_IL_LOAN_REPAYMENT repay = null;
		// Boolean checkBoxSelected =
		// (Boolean)ae.getComponent().getParent().getAttributes().get("value");
		Boolean checkBoxSelected = false;
		for (PT_IL_LOAN_REPAYMENT repay1 : beanList) {
			if ("dataTableSelectedRow"
					.equalsIgnoreCase(repay1.getRowSelected())) {
				repay = repay1;
				checkBoxSelected = true;
			}
		}

		String M_LR_STATUS = "Not Approved";
		if (checkBoxSelected) {
			// PT_IL_LOAN_REPAYMENT repay = (PT_IL_LOAN_REPAYMENT)
			// dT.getRowData();
			System.out.println("LR_SYS_ID = " + repay.getLR_SYS_ID());
			System.out.println("LOAN SYS ID = " + repay.getLR_LOAN_SYS_ID());
			String query = "SELECT LR_STATUS FROM PT_IL_LOAN_REPAYMENT WHERE LR_SYS_ID='"
					+ repay.getLR_SYS_ID() + "'";
			Connection con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			ResultSet rs = handler.executeSelectStatement(query, con);

			while (rs.next()) {
				M_LR_STATUS = rs.getString(1);
				/**
				 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment details
				 * button should not be disabled for approved record.
				 */
				getPT_IL_LOAN_REPAYMENT_BEAN().setLOAN_STATUS(M_LR_STATUS);
				/** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] */
				System.out.println("M_LR_STATUS = " + M_LR_STATUS);
			}
			/*if ("A".equalsIgnoreCase(M_LR_STATUS)) {
				getCOMP_LOAN_STATUS().setValue("Approved");
				*//**
				 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment details
				 * button should not be disabled for approved record.
				 *//*
				// getPymtDetails().setDisabled(true);
				*//** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] *//*
				// getApprove().setDisabled(true);
				setApprove(true);
				// getDeleteRow1().setDisabled(true);
			} else {
				//getCOMP_LOAN_STATUS().setValue("Not Approved");
				*//**
				 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment details
				 * button should not be disabled for approved record.
				 *//*
				// getPymtDetails().setDisabled(false);
				*//** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] *//*
				// getApprove().setDisabled(false);
				setApprove(false);
				// getDeleteRow1().setDisabled(false);
			}*/

			Double M_FC_OS_AMOUNT = (Double) sessionMap.get("M_FC_OS_AMOUNT");
			if (M_FC_OS_AMOUNT <= 0.0) {
				getUI_M_BUT_ADD().setDisabled(true);
				// getAddRow1.setDisabled(true);
				// getDeleteRow1().setDisabled(true);
			} else {
				// getAddRow1().setDisabled(false);
				getUI_M_BUT_ADD().setDisabled(false);
				// getDeleteRow1().setDisabled(false);
			}
			rs.close();
			// con.close();
		} /*else {
			getCOMP_LOAN_STATUS().setValue("");
			*//**
			 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment details
			 * button should not be disabled for approved record.
			 *//*
			// getPymtDetails().setDisabled(false);
			*//** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] *//*
			// getApprove().setDisabled(false);
			setApprove(false);
		}*/
	}

	public String loanRepaymentDetailNav() {
		int count = 0;
		Connection con = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();
		String navgationString = "PILT005_LOAN_REPAYMENT_DETAIL";

		if (gridDisplay != null) {
			for (int index = 0; index < gridDisplay.size(); index++) {
				PT_IL_LOAN_REPAYMENT valueBean = (PT_IL_LOAN_REPAYMENT) getGridDisplay()
						.get(index);
				if (valueBean.isCheckBoxValue()) {
					System.out.println("The Selected RowIndex = " + index);
					count = count + 1;
				}
			}
			if (count == 1) {
				getErrorMap().clear();
				for (int i = 0; i < gridDisplay.size(); i++) {
					PT_IL_LOAN_REPAYMENT valueBean = (PT_IL_LOAN_REPAYMENT) getGridDisplay()
							.get(i);
					if (valueBean.isCheckBoxValue()) {
						try {
							CRUDHandler handler = new CRUDHandler();
							con = CommonUtils.getConnection();

							String query = "SELECT A.LRD_PROD_CODE,A.LRD_FC_PYMT_AMT,A.LRD_LC_PYMT_AMT,B.LR_SYS_ID,A.LRD_LR_SYS_ID from PT_IL_LOAN_REPAYMENT_DTL A,PT_IL_LOAN_REPAYMENT B "
									+ "WHERE B.LR_LOAN_SYS_ID = A.LRD_LOAN_SYS_ID AND B.LR_SYS_ID = A.LRD_LR_SYS_ID AND B.LR_SYS_ID = '"
									+ valueBean.getLR_SYS_ID() + "'";

							PT_IL_LOAN_REPAYMENT_DTL_ACTION detailAction = new PT_IL_LOAN_REPAYMENT_DTL_ACTION();
							ArrayList<PT_IL_LOAN_REPAYMENT_DTL> repayDetailsList = detailAction
									.getRepaymentDetail();

							ResultSet rs = handler.executeSelectStatement(
									query, con);
							while (rs.next()) {
								PT_IL_LOAN_REPAYMENT_DTL repayDetail = new PT_IL_LOAN_REPAYMENT_DTL();
								repayDetail.setLRD_PROD_CODE(rs.getString(1));
								repayDetail.setLRD_FC_PYMT_AMT(NVLDouble(Double
										.valueOf(rs.getDouble(2)), 0.0));
								repayDetail.setLRD_LC_PYMT_AMT(NVLDouble(Double
										.valueOf(rs.getDouble(3)), 0.0));
								repayDetail
										.setUI_M_REPAY_PROD_DESC(productDescription(rs
												.getString(1)));
								repayDetailsList.add(repayDetail);
							}

							sessionMap.put(
									"PILT005_PT_IL_LOAN_REPAYMENT_DTL_ACTION",
									detailAction);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				navgationString = "";
			}
		}
		return navgationString;
	}

	private String productDescription(String LRD_PROD_CODE) {
		String PROD_DESC = null;
		Connection con = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		try {
			con = CommonUtils.getConnection();
			String descQuery = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = '"
					+ LRD_PROD_CODE + "'";
			rs = handler.executeSelectStatement(descQuery, con);
			while (rs.next()) {
				PROD_DESC = rs.getString(1);
			}
		} catch (Exception e) {

		} finally {

		}
		return PROD_DESC;
	}

	private PT_IL_LOAN_REPAYMENT LOAN_REPAYMENT_WHEN_CREATE_RECORD() {
		PT_IL_LOAN_REPAYMENT repay = new PT_IL_LOAN_REPAYMENT();
		repay.setLR_STATUS("N");
		repay.setLR_FLAG("N");
		return repay;
	}

	public String getLR_LC_PYMT_AMT_FOCUS() {
		return LR_LC_PYMT_AMT_FOCUS;
	}

	public void setLR_LC_PYMT_AMT_FOCUS(String lr_lc_pymt_amt_focus) {
		LR_LC_PYMT_AMT_FOCUS = lr_lc_pymt_amt_focus;
	}

	public String getLR_FC_PYMT_AMT_FOCUS() {
		return LR_FC_PYMT_AMT_FOCUS;
	}

	public void setLR_FC_PYMT_AMT_FOCUS(String lr_fc_pymt_amt_focus) {
		LR_FC_PYMT_AMT_FOCUS = lr_fc_pymt_amt_focus;
	}

	public HtmlOutputText getCOMP_LOAN_DISBURSAL_STATUS() {
		return COMP_LOAN_DISBURSAL_STATUS;
	}

	public void setCOMP_LOAN_DISBURSAL_STATUS(
			HtmlOutputText comp_loan_disbursal_status) {
		COMP_LOAN_DISBURSAL_STATUS = comp_loan_disbursal_status;
	}

	public void loanDisbursalStatus(ActionEvent event) {
		CommonUtils.clearMaps(this);
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map sessionMap = ctx.getExternalContext().getSessionMap();
		Double M_FC_OS_AMOUNT = (Double) sessionMap.get("M_FC_OS_AMOUNT");
		System.out.println("M_FC_OS_AMOUNT - Loan Disbursal Status = "
				+ M_FC_OS_AMOUNT);
		// sessionMap.put("", "");

		if (M_FC_OS_AMOUNT <= 0.0) {
			getCOMP_LOAN_DISBURSAL_STATUS().setValue("Loan Status: Closed");
			/**
			 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment details
			 * button should not be disabled for approved record.
			 */
			// getPymtDetails().setDisabled(true);
			/** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] */
			// getApprove().setDisabled(true);
			setApprove(true);
			// getAddRow1().setDisabled(true);
			// getDeleteRow1().setDisabled(true);
		} else {
			getCOMP_LOAN_DISBURSAL_STATUS().setValue("Loan Status: Open");
			/**
			 * [ BugId:PREMIAGDC-0131 Mallika 13-Mar-09 the payment details
			 * button should not be disabled for approved record.
			 */
			// getPymtDetails().setDisabled(true);
			/** BugId:PREMIAGDC-0131 Mallika 13-Mar-09 ] */
			// getApprove().setDisabled(false);
			setApprove(false);
			// getAddRow1().setDisabled(false);
			// getDeleteRow1().setDisabled(false);
		}
	}

	public HtmlAjaxCommandButton getAddRow1() {
		return addRow1;
	}

	public void setAddRow1(HtmlAjaxCommandButton addRow1) {
		this.addRow1 = addRow1;
	}

	public HtmlAjaxCommandButton getDeleteRow1() {
		return deleteRow1;
	}

	public void setDeleteRow1(HtmlAjaxCommandButton deleteRow1) {
		this.deleteRow1 = deleteRow1;
	}

	public String navigateToLoanDisbursalScreen() {
		return "navigateToLoanDisbursalScreen";
	}
	

	/*public String navigateToLoanScreen(){
		
		
		String outcome = null;
		outcome = "goBackFromloan";
			return outcome;
		}

	public String navigationEnabled(){
		// Newly added by dhinesh on 17.09.2017
				getErrorMap().clear();
				CommonUtils.clearMaps(this);
				COMP_BT_LOANSCREEN.setImmediate(true);
		return "goBackFromloan";
	}*/
	
	// End
	
	
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated:
	// 16-Feb-2009 ]
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord() {
		String outcome = null;
		int rowIndex = dT.getRowIndex();

		try {
			if (rowIndex > -1) {
				// Calling last Column listener
				lastColumnListener();
			} else {
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		} catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
		}

		return outcome;
	}

	/*
	 * Commented below code on 19.2.2017 by RAJA
	 * 
	 * public void getDetails() {
		try {
			if (beanList.size() != 0) {
				PT_IL_LOAN_REPAYMENT_BEAN = (PT_IL_LOAN_REPAYMENT) dataTable
						.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
			displayApprovedStatus();
			LoanStatusValidation(null);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Det", e.getMessage());
		}
	}
	*/
	
	/*Newly added below code on 19.2.2017 by RAJA*/
	public void getDetails() {
		String query=null;
		ResultSet resultset=null;
		Connection connection=null;
		Date pymt_date=null;
		Date repay_date=null;
		String Status=null;
		try {
			connection=commonUtils.getConnection();
			if (beanList.size() != 0) {
				
				
				PT_IL_LOAN_REPAYMENT_BEAN = (PT_IL_LOAN_REPAYMENT) dataTable
						.getRowData();
				query=" SELECT MAX(LR_PYMT_DT) FROM PT_IL_LOAN_REPAYMENT WHERE LR_LOAN_SYS_ID = ? AND LR_PYMT_DT < ?";
				resultset=new CRUDHandler().executeSelectStatement(query, connection, 
						new Object[]{PT_IL_LOAN_REPAYMENT_BEAN.getLR_LOAN_SYS_ID(),PT_IL_LOAN_REPAYMENT_BEAN.getLR_PYMT_DT()});
				while(resultset.next())
				{
					pymt_date=resultset.getDate(1);
				}
				query="SELECT NVL(LR_STATUS, 'N'),LR_REPAY_PAID_DT FROM PT_IL_LOAN_REPAYMENT WHERE LR_LOAN_SYS_ID = ? AND LR_PYMT_DT = ?";
				resultset=new CRUDHandler().executeSelectStatement(query, connection, 
						new Object[]{PT_IL_LOAN_REPAYMENT_BEAN.getLR_LOAN_SYS_ID(),pymt_date});
				
				while(resultset.next())
				{
					Status=resultset.getString(1);
					repay_date=resultset.getDate(2);
				}
				if(repay_date==null && "N".equalsIgnoreCase(Status))
				{
					throw new Exception("Kindly check the previous record");
				}

			}
			resetAllComponent();
			resetSelectedRow();
			PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
			displayApprovedStatus();
			LoanStatusValidation(null);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current",e.getMessage());
			getErrorMap().put("Det",e.getMessage());
			
		}
	}
	
	/*  END  */
	
	private void displayApprovedStatus(){
		if("A".equalsIgnoreCase(PT_IL_LOAN_REPAYMENT_BEAN.getLR_STATUS())){
			PT_IL_LOAN_REPAYMENT_BEAN.setUI_M_LOAN_STATUS("Approved");
		
			COMP_UI_M_BUT_APPROVE.setDisabled(true);
			/*Newly Added By Dhinesh on 26.02.2017*/
			disableAllComponent(true);
			/*End*/

		}
		else{
			PT_IL_LOAN_REPAYMENT_BEAN.setUI_M_LOAN_STATUS("Not Approved");
			COMP_UI_M_BUT_APPROVE.setDisabled(false);
			
			/*Newly Added By Dhinesh on 26.02.2017*/
			disableAllComponent(false);
			/*End*/
		}
	}

	private void resetSelectedRow() {
		Iterator<PT_IL_LOAN_REPAYMENT> iterator = beanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}
	}

	public void resetAllComponent() {
		COMP_LR_PYMT_DT.resetValue();
		COMP_LR_FC_PYMT_AMT.resetValue();
		COMP_LR_LC_PYMT_AMT.resetValue();
		COMP_LR_FC_INT_AMT.resetValue();
		COMP_LR_LC_INT_AMT.resetValue();
		COMP_LR_FC_LOAN_AMT.resetValue();
		COMP_LR_LC_LOAN_AMT.resetValue();
		COMP_LR_PYMT_REF_NO.resetValue();
	}

	public void AddRow(ActionEvent event) {
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();
		Long LR_SYS_ID = null;

		try {
			getErrorMap().clear();
			getWarningMap().clear();
			CRUDHandler handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();
			String query = "SELECT PIL_LR_SYS_ID.NEXTVAL FROM DUAL";
			ResultSet rs = handler.executeSelectStatement(query, con);

			while (rs.next()) {
				LR_SYS_ID = rs.getLong(1);
			}
			PT_IL_LOAN_ACTION action = (PT_IL_LOAN_ACTION) sessionMap
					.get("PILT005_PT_IL_LOAN_ACTION");
			PT_IL_LOAN bean = action.getPT_IL_LOAN_BEAN();

			PT_IL_LOAN_REPAYMENT repay = LOAN_REPAYMENT_WHEN_CREATE_RECORD();
			repay.setLR_SYS_ID(LR_SYS_ID);
			repay.setLR_LOAN_SYS_ID(bean.getLOAN_SYS_ID());

			sessionMap.put("PILT005_LR_LOAN_SYS_ID", bean.getLOAN_SYS_ID());
			if (isINSERT_ALLOWED()) {
				PT_IL_LOAN_REPAYMENT_BEAN = new PT_IL_LOAN_REPAYMENT();
				WHEN_CREATE_RECORD(PT_IL_LOAN_REPAYMENT_BEAN);
				resetAllComponent();
				resetSelectedRow();
				PT_IL_LOAN_REPAYMENT_BEAN.setRowSelected(true);
			} else {
				getErrorMap().put(
						"somekey",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}
	}

	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated:
	// 16-Feb-2009 ]

	public boolean isBackToLoanDisbursal() {
		return backToLoanDisbursal;
	}

	public void setBackToLoanDisbursal(boolean backToLoanDisbursal) {
		this.backToLoanDisbursal = backToLoanDisbursal;
	}

	public boolean isPymtDetails() {
		return pymtDetails;
	}

	public void setPymtDetails(boolean pymtDetails) {
		this.pymtDetails = pymtDetails;
	}

	public boolean isApprove() {
		return approve;
	}

	public void setApprove(boolean approve) {
		this.approve = approve;
	}

	public List<PT_IL_LOAN_REPAYMENT> getBeanList() {
		return beanList;
	}

	/**
	 * @param beanList
	 *            the beanList to set
	 */
	public void setBeanList(List<PT_IL_LOAN_REPAYMENT> beanList) {
		this.beanList = beanList;
	}

	/**
	 * @return the filterLR_FC_PYMT_AMT
	 */
	public String getFilterLR_FC_PYMT_AMT() {
		return filterLR_FC_PYMT_AMT;
	}

	/**
	 * @param filterLR_FC_PYMT_AMT
	 *            the filterLR_FC_PYMT_AMT to set
	 */
	public void setFilterLR_FC_PYMT_AMT(String filterLR_FC_PYMT_AMT) {
		this.filterLR_FC_PYMT_AMT = filterLR_FC_PYMT_AMT;
	}

	/**
	 * @return the filterByLR_LC_PYMT_AMT
	 */
	public String getFilterByLR_LC_PYMT_AMT() {
		return filterByLR_LC_PYMT_AMT;
	}

	/**
	 * @param filterByLR_LC_PYMT_AMT
	 *            the filterByLR_LC_PYMT_AMT to set
	 */
	public void setFilterByLR_LC_PYMT_AMT(String filterByLR_LC_PYMT_AMT) {
		this.filterByLR_LC_PYMT_AMT = filterByLR_LC_PYMT_AMT;
	}

	/**
	 * @return the dataTable
	 */
	public UIDataTable getDataTable() {
		return dataTable;
	}

	/**
	 * @param dataTable
	 *            the dataTable to set
	 */
	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	/**
	 * @return the uI_M_BUT_ADD
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	/**
	 * @param ui_m_but_add
	 *            the uI_M_BUT_ADD to set
	 */
	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	/**
	 * @return the uI_M_BUT_DELETE
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	/**
	 * @param ui_m_but_delete
	 *            the uI_M_BUT_DELETE to set
	 */
	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	/**
	 * @return the uI_M_BUT_POST
	 */
	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	/**
	 * @param ui_m_but_post
	 *            the uI_M_BUT_POST to set
	 */
	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	/**
	 * @return the approveButton
	 */
	public HtmlAjaxCommandButton getApproveButton() {
		return approveButton;
	}

	/**
	 * @param approveButton
	 *            the approveButton to set
	 */
	public void setApproveButton(HtmlAjaxCommandButton approveButton) {
		this.approveButton = approveButton;
	}

	public String saveAndCommit(ActionEvent event) {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			String insertMessage = Messages
					.getString(PELConstants.pelErrorMessagePath,
							"errorPanel$message$save");
			getWarningMap().put("current", insertMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	public void PRE_INSERT(
			PT_IL_LOAN_REPAYMENT_ACTION PT_IL_LOAN_REPAYMENT_ACTION_BEAN,
			PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN,
			PT_IL_LOAN_REPAYMENT_DTL PT_IL_LOAN_REPAYMENT_DTL_BEAN)
			throws Exception {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();
			String C1 = "SELECT PIL_LR_SYS_ID.NEXTVAL FROM DUAL";
			PT_IL_LOAN_REPAYMENT_ACTION_BEAN.setINSERT_ALLOWED(true);
			resultSet = handler.executeSelectStatement(C1, connection);
			if (resultSet.next()) {
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_SYS_ID(resultSet.getLong(1));
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_CR_DT(new CommonUtils()
						.getCurrentDate());
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_CR_UID(CommonUtils
						.getControlBean().getM_USER_ID());
				/*PT_IL_LOAN_REPAYMENT_BEAN.setLR_LOAN_SYS_ID(PT_IL_LOAN_REPAYMENT_DTL_BEAN.getLRD_LOAN_SYS_ID());
				PT_IL_LOAN_REPAYMENT_BEAN.setLR_SYS_ID(PT_IL_LOAN_REPAYMENT_DTL_BEAN.getLRD_LR_SYS_ID());*/
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Disables all components in PT_IL_LOAN_REPAYMENT_ACTION
	 */
	public void disableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_LR_FC_PYMT_AMT.setDisabled(disabled);
		/*
		 * commented By Dhinesh on 26.2.2017
		 * 
		 * COMP_LR_LC_PYMT_AMT.setDisabled(disabled);
		COMP_LR_FC_INT_AMT.setDisabled(disabled);
		COMP_LR_LC_INT_AMT.setDisabled(disabled);
		COMP_LR_FC_LOAN_AMT.setDisabled(disabled);
		COMP_LR_LC_LOAN_AMT.setDisabled(disabled);
		COMP_LR_PYMT_REF_NO.setDisabled(disabled);*/

		// Disabling HtmlCalendar
		COMP_LR_PYMT_DT.setDisabled(disabled);
		COMP_LR_REPAY_PAID_DT.setDisabled(disabled);
		COMP_UI_M_BUT_APPROVE.setDisabled(disabled);

	}
	
	
	public void enableAllComponent(boolean disabled) {
		// Disabling HtmlInputText
		COMP_LR_FC_PYMT_AMT.setDisabled(false);
		COMP_LR_LC_PYMT_AMT.setDisabled(false);
		//COMP_LR_FC_INT_AMT.setDisabled(false);
		//COMP_LR_LC_INT_AMT.setDisabled(false);
		//COMP_LR_FC_LOAN_AMT.setDisabled(false);
		//COMP_LR_LC_LOAN_AMT.setDisabled(false);
		COMP_LR_PYMT_REF_NO.setDisabled(false);

		// Disabling HtmlCalendar
		COMP_LR_PYMT_DT.setDisabled(false);

	}

	/**
	 * Instantiates all components in PT_IL_LOAN_REPAYMENT_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_LR_FC_PYMT_AMT = new HtmlInputText();
		COMP_LR_LC_PYMT_AMT = new HtmlInputText();
		COMP_LR_FC_INT_AMT = new HtmlInputText();
		COMP_LR_LC_INT_AMT = new HtmlInputText();
		COMP_LR_FC_LOAN_AMT = new HtmlInputText();
		COMP_LR_LC_LOAN_AMT = new HtmlInputText();
		COMP_LR_PYMT_REF_NO = new HtmlInputText();

		// Instantiating HtmlCalendar
		COMP_LR_PYMT_DT = new HtmlCalendar();
		
		UI_M_BUT_ADD = new HtmlAjaxCommandButton();
		UI_M_BUT_DELETE = new HtmlAjaxCommandButton();
		UI_M_BUT_POST = new HtmlAjaxCommandButton();
		
		COMP_UI_M_BUT_APPROVE = new HtmlCommandButton();
		COMP_BT_LOANSCREEN = new  HtmlCommandButton();
	}

	public void PRE_UPDTAE(PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN)
			throws Exception {
		try {
			PT_IL_LOAN_REPAYMENT_BEAN.setLR_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PT_IL_LOAN_REPAYMENT_BEAN.setLR_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void WHEN_CREATE_RECORD(PT_IL_LOAN_REPAYMENT PT_IL_LOAN_REPAYMENT_BEAN) throws Exception {
		
		/*if(PT_IL_LOAN_REPAYMENT_BEAN.getLR_SYS_ID() != null && 
				!("A".equalsIgnoreCase(CommonUtils.nvl(PT_IL_LOAN_REPAYMENT_BEAN.getLR_STATUS(),"N")))){
			throw new Exception("Unapproved repayment record exist - please approve");
		}*/
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_STATUS("N");
		PT_IL_LOAN_REPAYMENT_BEAN.setLR_FLAG("N");
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext()
				.getSessionMap();
		PT_IL_LOAN_ACTION action = (PT_IL_LOAN_ACTION) sessionMap
				.get("PILT005_PT_IL_LOAN_ACTION");
		PT_IL_LOAN bean = action.getPT_IL_LOAN_BEAN();
		String C1 = "SELECT * FROM PT_IL_LOAN_REPAYMENT WHERE " +
				"(LR_STATUS <> 'A' OR LR_STATUS IS NULL) AND LR_LOAN_SYS_ID = ? ";
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[]{bean.getLOAN_SYS_ID()});
			if(resultSet.next()){
				throw new Exception("Unapproved repayment record exist - please approve");
			}
		}   catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		//this.getCOMP_BUT_PYMT_DTLS',ENABLED,PROPERTY_FALSE);
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton comp_ui_m_but_approve) {
		COMP_UI_M_BUT_APPROVE = comp_ui_m_but_approve;
	}

	public HtmlOutputLabel getCOMP_LR_REPAY_PAID_DT_LABEL() {
		return COMP_LR_REPAY_PAID_DT_LABEL;
	}

	public void setCOMP_LR_REPAY_PAID_DT_LABEL(
			HtmlOutputLabel comp_lr_repay_paid_dt_label) {
		COMP_LR_REPAY_PAID_DT_LABEL = comp_lr_repay_paid_dt_label;
	}

	public HtmlCalendar getCOMP_LR_REPAY_PAID_DT() {
		return COMP_LR_REPAY_PAID_DT;
	}

	public void setCOMP_LR_REPAY_PAID_DT(HtmlCalendar comp_lr_repay_paid_dt) {
		COMP_LR_REPAY_PAID_DT = comp_lr_repay_paid_dt;
	}

	public Date getFilterLR_PYMT_DT() {
		return filterLR_PYMT_DT;
	}

	public void setFilterLR_PYMT_DT(Date filterLR_PYMT_DT) {
		this.filterLR_PYMT_DT = filterLR_PYMT_DT;
	}

	public Date getFilterLR_REPAY_PAID_DT() {
		return filterLR_REPAY_PAID_DT;
	}

	public void setFilterLR_REPAY_PAID_DT(Date filterLR_REPAY_PAID_DT) {
		this.filterLR_REPAY_PAID_DT = filterLR_REPAY_PAID_DT;
	}

	public String getFilterLR_STATUS() {
		return filterLR_STATUS;
	}

	public void setFilterLR_STATUS(String filterLR_STATUS) {
		this.filterLR_STATUS = filterLR_STATUS;
	}

	public String getFilterLR_FC_LOAN_AMT() {
		return filterLR_FC_LOAN_AMT;
	}

	public void setFilterLR_FC_LOAN_AMT(String filterLR_FC_LOAN_AMT) {
		this.filterLR_FC_LOAN_AMT = filterLR_FC_LOAN_AMT;
	}

}
