package com.iii.pel.forms.PILP007;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
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
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;


public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_FROM_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_FROM;

	private HtmlInputText COMP_UI_M_BASE_CURR;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_FROM_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_FROM_DATE;

	private HtmlOutputLabel COMP_UI_M_TO_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DATE;

	private HtmlOutputLabel COMP_UI_M_SURR_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_SURR_TYPE;

	private HtmlAjaxCommandButton COMP_UI_M_BUT_OK;

	private HtmlAjaxCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FROM;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO;

	private HtmlAjaxCommandButton COMP_UI_M_BUT_REJECT;

	private HtmlAjaxCommandButton COMP_UI_M_BUT_ACCEPT;

	private DUMMY DUMMY_BEAN;

	private List<PT_IL_SURR_MAT_VALUES> tableValuesList = new ArrayList<PT_IL_SURR_MAT_VALUES>();

	private List<SelectItem> repaymentComboList = new ArrayList<SelectItem>();

	private ArrayList<Integer> selectedList = new ArrayList<Integer>();
	private UIDataTable dataTable;
	
	boolean detailsFetched=false;
	private PT_IL_SURR_MAT_VALUES_ACTION PT_IL_SURR_MAT_VALUES_ACTION_BEAN;
	private PRINT_ACTION PRINT_ACTION_BEAN; 
	
	public PRINT_ACTION getPRINT_ACTION_BEAN() {
		return PRINT_ACTION_BEAN;
	}

	public void setPRINT_ACTION_BEAN(PRINT_ACTION pRINT_ACTION_BEAN) {
		PRINT_ACTION_BEAN = pRINT_ACTION_BEAN;
	}

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		PT_IL_SURR_MAT_VALUES_BEAN = new PT_IL_SURR_MAT_VALUES();
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN = new PT_IL_SURR_MAT_VALUES_ACTION();
		PRINT_ACTION_BEAN= new PRINT_ACTION();
		PRINT_ACTION_BEAN.action=this;
		System.out.println("1236"+PRINT_ACTION_BEAN.action);
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN.dummy_action = this;
		COMP_UI_M_POL_NO_FROM=new HtmlInputText();
		COMP_UI_M_FROM_DATE = new HtmlCalendar();
		COMP_UI_M_BUT_ACCEPT = new HtmlAjaxCommandButton();
		/* Newly Added By Dhinesh on 15-06-2017 for ssp call id ZBILQC-1728303 */
		initializeAllComponents();
		/*End*/
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FROM_LABEL() {
		return COMP_UI_M_POL_NO_FROM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FROM() {
		return COMP_UI_M_POL_NO_FROM;
	}

	public void setCOMP_UI_M_POL_NO_FROM_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_NO_FROM_LABEL) {
		this.COMP_UI_M_POL_NO_FROM_LABEL = COMP_UI_M_POL_NO_FROM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FROM(HtmlInputText COMP_UI_M_POL_NO_FROM) {
		this.COMP_UI_M_POL_NO_FROM = COMP_UI_M_POL_NO_FROM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL) {
		this.COMP_UI_M_POL_NO_TO_LABEL = COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText COMP_UI_M_POL_NO_TO) {
		this.COMP_UI_M_POL_NO_TO = COMP_UI_M_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_FROM_DATE_LABEL() {
		return COMP_UI_M_FROM_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_FROM_DATE() {
		return COMP_UI_M_FROM_DATE;
	}

	public void setCOMP_UI_M_FROM_DATE_LABEL(
			HtmlOutputLabel COMP_UI_M_FROM_DATE_LABEL) {
		this.COMP_UI_M_FROM_DATE_LABEL = COMP_UI_M_FROM_DATE_LABEL;
	}

	public void setCOMP_UI_M_FROM_DATE(HtmlCalendar COMP_UI_M_FROM_DATE) {
		this.COMP_UI_M_FROM_DATE = COMP_UI_M_FROM_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_DATE_LABEL() {
		return COMP_UI_M_TO_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DATE() {
		return COMP_UI_M_TO_DATE;
	}

	public void setCOMP_UI_M_TO_DATE_LABEL(
			HtmlOutputLabel COMP_UI_M_TO_DATE_LABEL) {
		this.COMP_UI_M_TO_DATE_LABEL = COMP_UI_M_TO_DATE_LABEL;
	}

	public void setCOMP_UI_M_TO_DATE(HtmlCalendar COMP_UI_M_TO_DATE) {
		this.COMP_UI_M_TO_DATE = COMP_UI_M_TO_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SURR_TYPE_LABEL() {
		return COMP_UI_M_SURR_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_SURR_TYPE() {
		return COMP_UI_M_SURR_TYPE;
	}

	public void setCOMP_UI_M_SURR_TYPE_LABEL(
			HtmlOutputLabel COMP_UI_M_SURR_TYPE_LABEL) {
		this.COMP_UI_M_SURR_TYPE_LABEL = COMP_UI_M_SURR_TYPE_LABEL;
	}

	public void setCOMP_UI_M_SURR_TYPE(HtmlSelectOneMenu COMP_UI_M_SURR_TYPE) {
		this.COMP_UI_M_SURR_TYPE = COMP_UI_M_SURR_TYPE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FROM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FROM;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_FROM(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FROM) {
		this.COMP_UI_M_BUT_LOV_POL_NO_FROM = COMP_UI_M_BUT_LOV_POL_NO_FROM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_TO() {
		return COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_TO(
			HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO) {
		this.COMP_UI_M_BUT_LOV_POL_NO_TO = COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlAjaxCommandButton comp_ui_m_but_ok) {
		COMP_UI_M_BUT_OK = comp_ui_m_but_ok;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(
			HtmlAjaxCommandButton comp_ui_m_but_cancel) {
		COMP_UI_M_BUT_CANCEL = comp_ui_m_but_cancel;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_REJECT() {
		return COMP_UI_M_BUT_REJECT;
	}

	public void setCOMP_UI_M_BUT_REJECT(
			HtmlAjaxCommandButton comp_ui_m_but_reject) {
		COMP_UI_M_BUT_REJECT = comp_ui_m_but_reject;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_ACCEPT() {
		return COMP_UI_M_BUT_ACCEPT;
	}

	public void setCOMP_UI_M_BUT_ACCEPT(
			HtmlAjaxCommandButton comp_ui_m_but_accept) {
		COMP_UI_M_BUT_ACCEPT = comp_ui_m_but_accept;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_FC_RED_SA;

	private HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_FC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_FC_GROSS_VALUE;

	private HtmlOutputLabel COMP_UI_M_STATUS_LABEL;

	private HtmlOutputLabel COMP_B_LC_VALUES;

	private HtmlInputText COMP_UI_M_STATUS;

	private HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL;

	private HtmlInputText COMP_SMV_LC_RED_SA;

	private HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL;

	private HtmlInputText COMP_SMV_LC_ACC_PROFIT;

	private HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL;

	private HtmlInputText COMP_SMV_LC_GROSS_VALUE;

	private PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN;

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

	public HtmlOutputLabel getCOMP_SMV_FC_RED_SA_LABEL() {
		return COMP_SMV_FC_RED_SA_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_RED_SA() {
		return COMP_SMV_FC_RED_SA;
	}

	public void setCOMP_SMV_FC_RED_SA_LABEL(
			HtmlOutputLabel COMP_SMV_FC_RED_SA_LABEL) {
		this.COMP_SMV_FC_RED_SA_LABEL = COMP_SMV_FC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_FC_RED_SA(HtmlInputText COMP_SMV_FC_RED_SA) {
		this.COMP_SMV_FC_RED_SA = COMP_SMV_FC_RED_SA;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_ACC_PROFIT_LABEL() {
		return COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_ACC_PROFIT() {
		return COMP_SMV_FC_ACC_PROFIT;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT_LABEL(
			HtmlOutputLabel COMP_SMV_FC_ACC_PROFIT_LABEL) {
		this.COMP_SMV_FC_ACC_PROFIT_LABEL = COMP_SMV_FC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_FC_ACC_PROFIT(HtmlInputText COMP_SMV_FC_ACC_PROFIT) {
		this.COMP_SMV_FC_ACC_PROFIT = COMP_SMV_FC_ACC_PROFIT;
	}

	public HtmlOutputLabel getCOMP_SMV_FC_GROSS_VALUE_LABEL() {
		return COMP_SMV_FC_GROSS_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SMV_FC_GROSS_VALUE() {
		return COMP_SMV_FC_GROSS_VALUE;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE_LABEL(
			HtmlOutputLabel COMP_SMV_FC_GROSS_VALUE_LABEL) {
		this.COMP_SMV_FC_GROSS_VALUE_LABEL = COMP_SMV_FC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_FC_GROSS_VALUE(HtmlInputText COMP_SMV_FC_GROSS_VALUE) {
		this.COMP_SMV_FC_GROSS_VALUE = COMP_SMV_FC_GROSS_VALUE;
	}

	public HtmlOutputLabel getCOMP_UI_M_STATUS_LABEL() {
		return COMP_UI_M_STATUS_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_STATUS() {
		return COMP_UI_M_STATUS;
	}

	public void setCOMP_UI_M_STATUS_LABEL(HtmlOutputLabel COMP_UI_M_STATUS_LABEL) {
		this.COMP_UI_M_STATUS_LABEL = COMP_UI_M_STATUS_LABEL;
	}

	public void setCOMP_UI_M_STATUS(HtmlInputText COMP_UI_M_STATUS) {
		this.COMP_UI_M_STATUS = COMP_UI_M_STATUS;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_RED_SA_LABEL() {
		return COMP_SMV_LC_RED_SA_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_RED_SA() {
		return COMP_SMV_LC_RED_SA;
	}

	public void setCOMP_SMV_LC_RED_SA_LABEL(
			HtmlOutputLabel COMP_SMV_LC_RED_SA_LABEL) {
		this.COMP_SMV_LC_RED_SA_LABEL = COMP_SMV_LC_RED_SA_LABEL;
	}

	public void setCOMP_SMV_LC_RED_SA(HtmlInputText COMP_SMV_LC_RED_SA) {
		this.COMP_SMV_LC_RED_SA = COMP_SMV_LC_RED_SA;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_ACC_PROFIT_LABEL() {
		return COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_ACC_PROFIT() {
		return COMP_SMV_LC_ACC_PROFIT;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT_LABEL(
			HtmlOutputLabel COMP_SMV_LC_ACC_PROFIT_LABEL) {
		this.COMP_SMV_LC_ACC_PROFIT_LABEL = COMP_SMV_LC_ACC_PROFIT_LABEL;
	}

	public void setCOMP_SMV_LC_ACC_PROFIT(HtmlInputText COMP_SMV_LC_ACC_PROFIT) {
		this.COMP_SMV_LC_ACC_PROFIT = COMP_SMV_LC_ACC_PROFIT;
	}

	public HtmlOutputLabel getCOMP_SMV_LC_GROSS_VALUE_LABEL() {
		return COMP_SMV_LC_GROSS_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_SMV_LC_GROSS_VALUE() {
		return COMP_SMV_LC_GROSS_VALUE;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE_LABEL(
			HtmlOutputLabel COMP_SMV_LC_GROSS_VALUE_LABEL) {
		this.COMP_SMV_LC_GROSS_VALUE_LABEL = COMP_SMV_LC_GROSS_VALUE_LABEL;
	}

	public void setCOMP_SMV_LC_GROSS_VALUE(HtmlInputText COMP_SMV_LC_GROSS_VALUE) {
		this.COMP_SMV_LC_GROSS_VALUE = COMP_SMV_LC_GROSS_VALUE;
	}

	public PT_IL_SURR_MAT_VALUES getPT_IL_SURR_MAT_VALUES_BEAN() {
		return PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public void setPT_IL_SURR_MAT_VALUES_BEAN(
			PT_IL_SURR_MAT_VALUES PT_IL_SURR_MAT_VALUES_BEAN) {
		this.PT_IL_SURR_MAT_VALUES_BEAN = PT_IL_SURR_MAT_VALUES_BEAN;
	}

	public void onLoad(PhaseEvent event){
		if(isBlockFlag()){
			preBlockPT_IL_SURR_MAT_VALUES();
			//COMP_UI_M_BUT_ACCEPT.setDisabled(true);
			setBlockFlag(false);
		}
		
		if(DUMMY_BEAN.getUI_M_SURR_TYPE()!=null && DUMMY_BEAN.getUI_M_SURR_TYPE().equalsIgnoreCase("D"))
		{
			
			
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_RED_SA().setDisabled(true);
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_ACC_PROFIT().setDisabled(true);
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_RED_SA().setDisabled(true);
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_ACC_PROFIT().setDisabled(true);
			COMP_UI_M_BUT_ACCEPT.setDisabled(true);
			
		}
		else
		{
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_RED_SA().setDisabled(false);
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_ACC_PROFIT().setDisabled(false);
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_RED_SA().setDisabled(false);
			PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_ACC_PROFIT().setDisabled(false);
			COMP_UI_M_BUT_ACCEPT.setDisabled(false);
		}
		
		/*Added by Janani on 12.02.2018 for ZB as per Sivaram's sugges.*/
		disableFields();
		/*End*/
		
		
	}
	
	public List<SelectItem> getRepaymentComboList() {
		if (repaymentComboList.size() == 0) {
			repaymentComboList.clear();
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext()
					.getContext();
			Connection con;
			try {
				con = getConnection();
				repaymentComboList = ListItemUtil.getDropDownListValue(con,
						"PILP007", "DUMMY", "DUMMY.M_SURR_TYPE", "ILSURRTYPE");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return repaymentComboList;
	}

	public void setRepaymentComboList(List<SelectItem> repaymentComboList) {
		this.repaymentComboList = repaymentComboList;
	}

	public void whenValidateSMV_LC_RED_SA()throws Exception {
		ArrayList<String> round_amt = new ArrayList<String>();
		try{
			round_amt = new DBProcedures().callP_VAL_ROUND_AMT(CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_BASE_CURR()),
											CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA()),
											"V");
			if(!round_amt.isEmpty()){
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_RED_SA(Double.parseDouble(round_amt.get(0)));
			}
			round_amt.clear();
			round_amt = new DBProcedures().callP_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA()),
																CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA()),
																CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_EXCH_RATE()),
																"E");
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT());
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT());

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidateSMV_LC_ACC_PROFIT()throws Exception {
		ArrayList<String> round_amt = new ArrayList<String>();
		try{
			round_amt = new DBProcedures().callP_VAL_ROUND_AMT(CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_BASE_CURR()),
											CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT()),
											"V");
			if((round_amt !=null) && !(round_amt.isEmpty())){
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_ACC_PROFIT(Double.parseDouble(round_amt.get(0)));
			}
			round_amt.clear();
			round_amt = new DBProcedures().callP_VAL_FC_LC_TOLERANCE(CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT()),
																CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT()),
																CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_EXCH_RATE()),
																"E");
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT());
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT());

		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public ArrayList<String> helperPKG_PILP007$P_VAL_POLICY(
            String P_POL_NO)
            throws SQLException, Exception {
        Connection connection = null;
         connection = CommonUtils.getConnection();

        ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
        ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
        ArrayList<String> returnList = new ArrayList<String>();
        OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
        parameterList.add(param1);

        OracleProcedureHandler procHandler = new OracleProcedureHandler();
        outputList = procHandler.execute(parameterList, connection,
                "PKG_PILP007.P_VAL_POLICY");
        Iterator<OracleParameter> iterator = outputList.iterator();
        while (iterator.hasNext()) {
            OracleParameter oracleParameter = iterator.next();
            System.out.println("Output value:::" + oracleParameter.getValue());
            returnList.add(oracleParameter.getValue());
        }
        return returnList;
    }

	public void whenValidateSMV_FC_RED_SA()throws Exception {
		ArrayList<String> round_amt = new ArrayList<String>();
		try{
			round_amt = new DBProcedures().callP_VAL_ROUND_AMT(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_CURR_CODE(),
					                   CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA()),
					                   "V");
			if(!round_amt.isEmpty()){
				if(round_amt.get(0) != null){
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_RED_SA(Double.parseDouble(round_amt.get(0)));
				}
			}
			if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_EXCH_RATE() != null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT() != null){
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_RED_SA(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA() *
            PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_EXCH_RATE());
			
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT());
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT());
			}
			round_amt.clear();
			round_amt = new DBProcedures().callP_VAL_ROUND_AMT(CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_BASE_CURR()),
													CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA()),
													"R");
			if(!round_amt.isEmpty()){
				if(round_amt.get(0) != null){
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_RED_SA(Double.parseDouble(round_amt.get(0)));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void whenValidateSMV_FC_ACC_PROFIT()throws Exception {
		ArrayList<String> round_amt = new ArrayList<String>();
		try{
			round_amt = new DBProcedures().callP_VAL_ROUND_AMT(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_CURR_CODE(),
					                   CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT()),
					                   "V");
			if(!round_amt.isEmpty()){
				if(round_amt.get(0) != null){
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_ACC_PROFIT(Double.parseDouble(round_amt.get(0)));
				}
			}
			if(PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_EXCH_RATE() != null && PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT() != null){
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_ACC_PROFIT(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT() *
            PT_IL_SURR_MAT_VALUES_BEAN.getUI_M_POL_SA_EXCH_RATE());
			
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT());
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_GROSS_VALUE(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA()
					+ PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT());
			}
			round_amt.clear();
			round_amt = new DBProcedures().callP_VAL_ROUND_AMT(CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_BASE_CURR()),
													CommonUtils.getProcedureValue(PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT()),
													"R");
			if(!round_amt.isEmpty()){
				if(round_amt.get(0) != null){
				PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_ACC_PROFIT(Double.parseDouble(round_amt.get(0)));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

	public void whenButtonPressedUI_M_BUT_OK(ActionEvent event)throws Exception {
		getErrorMap().clear();
		Connection connection = null;
		Object[] values = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String chkQuery = "SELECT COUNT(1) FROM PT_IL_POL_APPL_PROD, PT_IL_POLICY, PM_IL_PLAN WHERE PAPP_POL_SYS_ID = POL_SYS_ID AND PAPP_PLAN_CODE = PLAN_CODE AND PLAN_SURR_YN = 'Y' AND POL_NO = ?";

		try {
			connection = CommonUtils.getConnection();

			/*
			 * Commented by Janani as per Siva suggestion on 08.03.2017 ,since all policies are surrendered 
			 * 
			 * 
			 * CALC_PAIDUP_VALUEProcedureCall(DUMMY_BEAN.getUI_M_POL_NO_FROM(),
					                        DUMMY_BEAN.getUI_M_POL_NO_TO(),
					                       CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_FROM_DATE()),
					                       CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_TO_DATE()),
					                        DUMMY_BEAN.getUI_M_SURR_TYPE(),
					                        CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_TO_DATE()));*/
			
			
			/*Added by Janani on 08.03.2017 as per Siva suggestion on 08.03.2017 ,since all policies are surrendered */
			
			System.out.println("getUI_M_POL_NO_FROM              "+DUMMY_BEAN.getUI_M_POL_NO_FROM());
			
			
			CALC_PAIDUP_VALUEProcedureCall(DUMMY_BEAN.getUI_M_POL_NO_FROM(),
                    DUMMY_BEAN.getUI_M_POL_NO_FROM(),
                   CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_FROM_DATE()),
                   CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_TO_DATE()),
                    DUMMY_BEAN.getUI_M_SURR_TYPE(),
                    CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_TO_DATE()));
			
			/*End*/
			
			
			/*added by raja on 13-05-2017*/
			if(DUMMY_BEAN.getUI_M_SURR_TYPE()!=null && DUMMY_BEAN.getUI_M_SURR_TYPE().equalsIgnoreCase("D"))
			{
				
				accessValidation();
							
				PROCESS_LAPSATION_DIRECTProcedureCall(CommonUtils.getProcedureValue(DUMMY_BEAN.getUI_M_TO_DATE()),
						DUMMY_BEAN.getUI_M_POL_NO_FROM());
				getWarningMap().put("current", "Process Completed Successfully");
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_RED_SA().setDisabled(true);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_ACC_PROFIT().setDisabled(true);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_RED_SA().setDisabled(true);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_ACC_PROFIT().setDisabled(true);
				COMP_UI_M_BUT_ACCEPT.setDisabled(true);
				
			}
			else
			{
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_RED_SA().setDisabled(false);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_ACC_PROFIT().setDisabled(false);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_RED_SA().setDisabled(false);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_ACC_PROFIT().setDisabled(false);
				COMP_UI_M_BUT_ACCEPT.setDisabled(false);
			}
			/*end*/
			
			L_DISPLAY_VALUES("T");
			executeQueryPT_IL_SURR_MAT_VALUES();
			//COMP_UI_M_FROM_DATE.setDisabled(true);
			COMP_UI_M_POL_NO_FROM.setDisabled(true);
			COMP_UI_M_POL_NO_TO.setDisabled(true);
			COMP_UI_M_TO_DATE.setDisabled(true);
			COMP_UI_M_BUT_OK.setDisabled(true);
			/*COMP_UI_M_BUT_ACCEPT.setDisabled(false);*/
		}catch (SQLException se) {
			se.printStackTrace();
			getWarningMap().clear();
			ErrorHelpUtil.getWarningsforProcedureAction(connection,
					FacesContext.getCurrentInstance(),getCOMP_UI_M_BUT_OK()
					.getClientId(FacesContext.getCurrentInstance()),
					 getWarningMap());
			
		} 
		catch(Exception e) {
			getWarningMap().clear(
					);
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put(getCOMP_UI_M_BUT_OK().getId(), e.getMessage());
		} finally {
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
					FacesContext.getCurrentInstance(), getCOMP_UI_M_BUT_OK()
					.getClientId(FacesContext.getCurrentInstance()),
					getErrorMap(), getWarningMap());
			if(getWarningMap().size()==2){
				getWarningMap().remove("current");
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getMessage(PELConstants.pelErrorMessagePath, "930006").getSummary());
			}
		}

	}
	
	public void disableAllComponents(boolean disabled){
		COMP_UI_M_FROM_DATE.setDisabled(disabled);
		COMP_UI_M_POL_NO_FROM.setDisabled(disabled);
		COMP_UI_M_POL_NO_TO.setDisabled(disabled);
		COMP_UI_M_TO_DATE.setDisabled(disabled);
		COMP_UI_M_BUT_OK.setDisabled(disabled);
		
	}
	public void CALC_PAIDUP_VALUEProcedureCall(String fromPolNo,String toPolNo,String M_FROM_DATE,String M_TO_DATE,String surrTYpe, String M_TO_DATE1)throws Exception
	{
		Connection connection = CommonUtils.getConnection();
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN", fromPolNo);
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN", toPolNo);
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN", M_FROM_DATE);
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN", M_TO_DATE);
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN", surrTYpe);
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN", M_TO_DATE1);
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		//paramList.add(param7);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> list = procHandler.execute(paramList,
					connection, "P9ILPK_SURR_PAID.CALC_PAIDUP_VALUE");
		
		
		if(list != null && list.size() > 0) {
			if("N".equals(list.get(0).getValue())) {
				
				Iterator<SelectItem> i = getRepaymentComboList().iterator();
				SelectItem item = null;
				String type = null;
				while(i.hasNext()) {
					item = i.next();
					if(item.getValue().equals(surrTYpe)) {
						type = item.getLabel();
					}
				}
				if(type!=null)
				{
					String warning = Messages.getString(PELConstants.pelErrorMessagePath, "92056", new Object[]{type});
					throw new Exception(warning);
				}													
			}else if("Y".equalsIgnoreCase(list.get(0).getValue()))
			{
				
			}
		}
	}

	public void whenButtonPressedUI_M_BUT_ACCEPT(ActionEvent event) throws DBException {
		String M_COMM_DEL = "C";
		Connection connection = null;
		connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		String product_code=null;
		Long pol_sys_id=null;
		String message = "";
		try {
			COMP_UI_M_POL_NO_FROM.setSubmittedValue("");
			/*/*commentted by saritha on 21-Mar-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
			 email should be sent to finance user.*/
			
			/*DUMMY_BEAN.setUI_M_POL_NO_FROM("");
			COMP_UI_M_POL_NO_FROM.resetValue();*/
			COMP_UI_M_POL_NO_TO.setSubmittedValue("");
			/*DUMMY_BEAN.setUI_M_POL_NO_TO("");
			COMP_UI_M_POL_NO_TO.resetValue();*/
			COMP_UI_M_FROM_DATE.setSubmittedValue("");
			/*DUMMY_BEAN.setUI_M_FROM_DATE(null);
			COMP_UI_M_FROM_DATE.resetValue();*/
			COMP_UI_M_TO_DATE.setSubmittedValue("");
			/*DUMMY_BEAN.setUI_M_TO_DATE(null);
			COMP_UI_M_TO_DATE.resetValue();*/
			//getConnection().commit();
			COMP_UI_M_FROM_DATE.setDisabled(false);
			COMP_UI_M_POL_NO_FROM.setDisabled(false);
			COMP_UI_M_POL_NO_TO.setDisabled(false);
			COMP_UI_M_TO_DATE.setDisabled(false);
			COMP_UI_M_BUT_OK.setDisabled(false);
			COMP_UI_M_BUT_ACCEPT.setDisabled(true);
			String acceptanceMessage=Messages.getString(PELConstants.pelMessagePropertiesPath, "processing$acceptancemessage$success");
			if(detailsFetched){
				getWarningMap().put("current", acceptanceMessage);
			}
			
			/*Added by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
			 email should be sent to finance user.*/
			 
			/*emailTriggerProcCall();*/
			
			System.out.println("pol no::::"+DUMMY_BEAN.getUI_M_POL_NO_FROM());
			String C1 ="SELECT POL_PROD_CODE,POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO=?";
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] {DUMMY_BEAN.getUI_M_POL_NO_FROM()});
			while(resultSet.next()) {
				product_code =resultSet.getString("POL_PROD_CODE");
				pol_sys_id   =resultSet.getLong("POL_SYS_ID");
				System.out.println("product_code--------------"+product_code);
				System.out.println("pol_sys_id----------------"+pol_sys_id);
			}
			String P_CUST_TYPE=" ";
			String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(product_code,"SUR",String.valueOf(pol_sys_id),"U","");
			message = message + emailStatusMessage;
			
			
			/*End*/	
			
			
			
			/*ADDED BY SANKARA NARAYANAN ON 03/04/2017*/
			  /*Modifed by Shankar on 13/04/2017
			   * 
			   * P_UPD_SURR_STS(DUMMY_BEAN.getUI_M_POL_NO_FROM());*/
			
			P_UPD_SURR_STS(DUMMY_BEAN.getUI_M_POL_NO_FROM(),DUMMY_BEAN.getUI_M_SURR_TYPE());
			  /*END*/
			 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 

		M_COMM_DEL = null;

		L_DISPLAY_VALUES("F");

		

	}
	
	

	public int updateData(PT_IL_SURR_MAT_VALUES dataGridBean) throws Exception {
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = getConnection();
			// dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(dataGridBean, connection);
			// connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public void executeQueryPT_IL_SURR_MAT_VALUES() {
		try {
			preBlockPT_IL_SURR_MAT_VALUES();
			String prequery = preQueryPT_IL_SURR_MAT_VALUES();
		System.out.println(" ****** preQueryPT_IL_SURR_MAT_VALUES() prequery      : "+prequery);
			List valueList = getHandler().fetch(prequery,
					"com.iii.pel.forms.PILP007.PT_IL_SURR_MAT_VALUES",
					getConnection());
			
			/*Commented by Ramkumar on 10-08-2016 because of IllegalArgument exceptio isue and this method have no functionality.
			 * 
			 * CommonUtils.objectSysout(valueList);*/
			if (valueList.size() > 0) {
				tableValuesList = postQueryPT_IL_SURR_MAT_VALUES(valueList);
				detailsFetched=true;
				if(tableValuesList.size()>0){
					this.setPT_IL_SURR_MAT_VALUES_BEAN(tableValuesList.get(0));
					tableValuesList.get(0).setRowSelected(true);
				}	
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void L_DISPLAY_VALUES(String M_TRUE_FALSE) {
	}

	private void preUpdatePT_IL_SURR_MAT_VALUES() {
		String query = "";
		Connection conn = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values = null;
		try {
			conn = CommonUtils.getConnection();
			query = "UPDATE PT_IL_POLICY SET POL_STATUS = ?, POL_END_TYPE = '003', " +
					" POL_END_DT = ?, PT_IL_POLICY.POL_FC_CURR_SA = ?, PT_IL_POLICY.POL_LC_CURR_SA = ? WHERE POL_SYS_ID = ?";
			values = new Object[]{DUMMY_BEAN.getUI_M_SURR_TYPE(),DUMMY_BEAN.getUI_M_FROM_DATE(), PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_GROSS_VALUE(),
					PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_GROSS_VALUE(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_POL_SYS_ID()};
			handler.executeUpdateStatement(query, conn, values);

			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UPD_DT(new CommonUtils().getCurrentDate());
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void onUpdatePT_IL_SURR_MAT_VALUES() {
		String query = "";
		String query1 = "";
		Connection conn = null;
		Object[] values = null;
		CRUDHandler handler = new CRUDHandler();
		if (PT_IL_SURR_MAT_VALUES_BEAN.getSMV_SYS_ID() != 0) {
			query = "UPDATE PT_IL_SURR_MAT_VALUES SET SMV_FC_RED_SA=?,  SMV_LC_RED_SA=?,SMV_FC_ACC_PROFIT=?,SMV_LC_ACC_PROFIT=?,"
					+ "SMV_FC_GROSS_VALUE=?,SMV_LC_GROSS_VALUE=?,SMV_UPD_DT=?,SMV_UPD_UID=? WHERE SMV_SYS_ID=?";
		}

		try {
			conn = CommonUtils.getConnection();
			values = new Object[]{PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_RED_SA(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_RED_SA(),
					PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_ACC_PROFIT(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_ACC_PROFIT(),
					PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_GROSS_VALUE(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_GROSS_VALUE(),
					new CommonUtils().getCurrentDate(),CommonUtils.getControlBean().getM_USER_ID(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_SYS_ID()};
			handler.executeUpdateStatement(query, conn,values);
			query1 = "UPDATE PT_IL_POLICY SET POL_STATUS = ?, POL_END_TYPE = '003', POL_END_DT = ?, " +
					" PT_IL_POLICY.POL_FC_CURR_SA = ?, PT_IL_POLICY.POL_LC_CURR_SA=? WHERE POL_SYS_ID = ?";
			values = new Object[]{DUMMY_BEAN.getUI_M_SURR_TYPE(),DUMMY_BEAN.getUI_M_FROM_DATE(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_FC_GROSS_VALUE(),
					   PT_IL_SURR_MAT_VALUES_BEAN.getSMV_LC_GROSS_VALUE(),PT_IL_SURR_MAT_VALUES_BEAN.getSMV_POL_SYS_ID()};
			handler.executeUpdateStatement(query1, conn, values);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<PT_IL_SURR_MAT_VALUES> postQueryPT_IL_SURR_MAT_VALUES(
			List<PT_IL_SURR_MAT_VALUES> valueList) throws DBException, Exception {

		double M_DUMMY = 0;

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		for (Iterator<PT_IL_SURR_MAT_VALUES> iterator = valueList.iterator(); iterator
				.hasNext();) {
			PT_IL_SURR_MAT_VALUES bean = iterator.next();
			System.out.println("bean.getSMV_FC_GROSS_VALUE() : "+bean.getSMV_FC_GROSS_VALUE());
			System.out.println("bean.getSMV_FC_ACC_PROFIT()  : "+bean.getSMV_FC_ACC_PROFIT());
			System.out.println("bean.getSMV_LC_RED_SA()      : "+bean.getSMV_LC_RED_SA());
			System.out.println("bean.getSMV_FC_RED_SA()      : "+bean.getSMV_FC_RED_SA());
			
			/*
			 * commented by dhinesh for apply  common decimal format issues.
			 * 
			 * bean.setUI_SMV_FC_GROSS_VALUE(Decimal_Convert(Double.toString(bean.getSMV_FC_GROSS_VALUE())));
			bean.setUI_SMV_FC_ACC_PROFIT(Decimal_Convert(Double.toString(bean.getSMV_FC_ACC_PROFIT())));
			bean.setUI_SMV_FC_RED_SA(Decimal_Convert(Double.toString(bean.getSMV_FC_RED_SA())));
			bean.setUI_SMV_LC_RED_SA(Decimal_Convert(Double.toString(bean.getSMV_LC_RED_SA())));
			*
			*/
			bean.setUI_SMV_FC_GROSS_VALUE(CommonUtils.Decimal_Convert(Double.toString(bean.getSMV_FC_GROSS_VALUE())));
			bean.setUI_SMV_FC_ACC_PROFIT(CommonUtils.Decimal_Convert(Double.toString(bean.getSMV_FC_ACC_PROFIT())));
			bean.setUI_SMV_FC_RED_SA(CommonUtils.Decimal_Convert(Double.toString(bean.getSMV_FC_RED_SA())));
			bean.setUI_SMV_LC_RED_SA(CommonUtils.Decimal_Convert(Double.toString(bean.getSMV_LC_RED_SA())));
		
			double polSysId = bean.getSMV_POL_SYS_ID();
			double sysId = bean.getSMV_SYS_ID();
			String query = "SELECT POL_NO,POL_SA_CURR_CODE,POL_SA_EXCH_RATE FROM "
					+ "PT_IL_POLICY WHERE POL_SYS_ID = ? ";
			try {
				stmt = conn.prepareStatement(query);
				stmt.setDouble(1, polSysId);
				rs = stmt.executeQuery();
				if (rs.next()) {
					bean.setUI_M_POL_NO(rs.getString("POL_NO"));
					bean.setUI_M_POL_SA_CURR_CODE(rs
							.getString("POL_SA_CURR_CODE"));
					bean.setUI_M_POL_SA_EXCH_RATE(rs
							.getDouble("POL_SA_EXCH_RATE"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			if (sysId != 0) {
				bean.setSMV_UPD_UID(bean.getSMV_UPD_UID());
				try {
					CallableStatement cs = CommonUtils.getConnection()
							.prepareCall("{call P_VAL_SYSTEM(?,?,?,?,?)}");
					cs.setString(1, "IL_REC_STA");
					cs.setString(2, bean.getSMV_TYPE());
					cs.registerOutParameter(3, java.sql.Types.VARCHAR);
					cs.setString(4, "N");
					cs.registerOutParameter(5, java.sql.Types.DOUBLE);
					boolean flag = cs.execute();
					bean.setUI_M_STATUS(cs.getString(3));
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(conn,
							FacesContext.getCurrentInstance(),
							getCOMP_UI_M_BUT_OK().getClientId(
									FacesContext.getCurrentInstance()),
							getErrorMap(), getWarningMap());
				}
			} else {
				try {
					CallableStatement cs = CommonUtils.getConnection()
							.prepareCall("{call P_VAL_SYSTEM(?,?,?,?,?)}");
					cs.setString(1, "IL_REC_STA");
					cs.setString(2, "C");
					cs.registerOutParameter(3, java.sql.Types.VARCHAR);
					cs.setString(4, "N");
					cs.registerOutParameter(5, java.sql.Types.DOUBLE);
					boolean flag = cs.execute();
					bean.setUI_M_STATUS(cs.getString(3));
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(conn,
							FacesContext.getCurrentInstance(),
							getCOMP_UI_M_BUT_OK().getClientId(
									FacesContext.getCurrentInstance()),
							getErrorMap(), getWarningMap());
				}
			}
		}
		return valueList;
	}

	/*Added By Dhinesh 3.7.2016*/

	public String Decimal_Convert(String Value)
	{
		if(Value != null)
		{
		int decimalPlaces=3;
		System.out.println("CommonUtils.getGlobalVariable(CURR_DECIMAL)  : "+CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL"));
		// decimalPlaces=(int)CommonUtils.getGlobalObject("GLOBAL.CURR_DECIMAL");
		System.out.println("decimalPlaces   : "+decimalPlaces);
		
		
		BigDecimal bd = new BigDecimal(Value);
	    bd = bd.setScale(decimalPlaces, BigDecimal.ROUND_DOWN);
	    
	    return bd.toString();
		}
		else
		{
			return "0.00";
		}
	}
	
	
	/*End*/
	
	private String preQueryPT_IL_SURR_MAT_VALUES() throws Exception {

		String M_WHERE = "";
		/*   Added By Dhinesh for ssp call id : FALCONQC-1716774   */
		String M_WHERE1 = "";
		/*end*/
		String M_FMT_MASK = "DD/MM/RRRR";
		double M_GRACE_MONTH = 0;
		double M_GRACE_QUARTER = 0;
		double M_GRACE_HALF_YEAR = 0;
		double M_GRACE_YEAR = 0;
		double M_GRACE_SINGLE = 0;

		String fromCompValue = DUMMY_BEAN.getUI_M_POL_NO_FROM();
		/*
		 * modified by Ameen on 27-11-2017 to put rein end. for paidup policies
		 * String toCompValue = DUMMY_BEAN.getUI_M_POL_NO_TO();*/
		String toCompValue = DUMMY_BEAN.getUI_M_POL_NO_FROM();
				
		String surrendarType = DUMMY_BEAN.getUI_M_SURR_TYPE();
		/*
		 * modified by Ameen on 27-11-2017 to put rein end. for paidup policies
		 * String M_TO_DATE = CommonUtils.dateToStringFormat(DUMMY_BEAN.getUI_M_FROM_DATE());*/
		String M_TO_DATE = CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_TO_DATE());
		String M_FROM_DATE = CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_TO_DATE());

		
		
		System.out.println("DHINESH_TEST M_FROM_DATE    : "+M_FROM_DATE);
		System.out.println("DHINESH_TEST M_TO_DATE      : "+M_TO_DATE);
		/*Date fromDate = CommonUtils.stringToDate(M_FROM_DATE);
		Date dateToDate = CommonUtils.stringToDate(M_TO_DATE);	
		String fmMonth= String.valueOf(fromDate.getMonth()+1);
		String toMonth= String.valueOf(dateToDate.getMonth()+1);
		//End Added for PREMIAGDC-265990
		
		M_FROM_DATE = "" + fromDate.getDate() + "/" + fmMonth + "/"+ (1900 + fromDate.getYear());
		
		M_TO_DATE = "" + dateToDate.getDate() + "/" + toMonth+ "/" + (1900 + dateToDate.getYear());*/

		System.out.println("");
		
		String POL_MODE_OF_PYMT = "H";

		Connection conn = getConnection();

		String query = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_GRACE_PRD' AND PS_CODE = ?";

		/*PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, POL_MODE_OF_PYMT);
		int result = stmt.executeUpdate();
		*/
		
		if ("P".equalsIgnoreCase(surrendarType)) {
			M_WHERE = " WHERE SMV_POL_SYS_ID IN (SELECT POL_SYS_ID FROM PT_IL_POLICY,PT_IL_PREM_COLL "
					+ "WHERE POL_SYS_ID = PT_IL_PREM_COLL.PC_POL_SYS_ID AND SMV_TYPE='P' "
					+ "AND POL_NO BETWEEN '"
					+ fromCompValue
					+ "' AND '"
					+ toCompValue
					+ "' "
					+ "AND POL_STATUS = '"
					+ surrendarType
					+"')" /*"' AND PC_SCHD_PYMT_DT + (DECODE('"
					+ POL_MODE_OF_PYMT
					+ "','M',"
					+ M_GRACE_MONTH
					+ ",'Q',"
					+ M_GRACE_QUARTER
					+ ",'H',"
					+ M_GRACE_HALF_YEAR
					+ ",'Y',"
					+ M_GRACE_YEAR
					+ ",'S',"
					+ M_GRACE_SINGLE
					+ ")) "
					+ "< TO_DATE('"
					+ M_TO_DATE
					+ "','"
					+ M_FMT_MASK
					+ "') AND NVL(PC_PAID_FLAG,'N') != 'A')*/+ "UNION ALL "
					+ "SELECT distinct PT_IL_POLICY.ROWID,0,0,0,0,0,0, to_date(NULL), NULL, 0, POL_SYS_ID,NULL FROM PT_IL_POLICY,PT_IL_PREM_COLL "
					+ "WHERE POL_SYS_ID = PT_IL_PREM_COLL.PC_POL_SYS_ID AND POL_NO BETWEEN '"
					+ fromCompValue
					+ "' AND '"
					+ toCompValue
					+ "' "
					+ "AND POL_STATUS = 'C' "/*AND PC_SCHD_PYMT_DT + (DECODE('"
					+ POL_MODE_OF_PYMT
					+ "','M',"
					+ M_GRACE_MONTH
					+ ",'Q',"
					+ M_GRACE_QUARTER
					+ ",'H',"
					+ M_GRACE_HALF_YEAR
					+ ",'Y',"
					+ M_GRACE_YEAR
					+ ",'S',"
					+ M_GRACE_SINGLE
					+ ")) "
					+ "< TO_DATE('"
					+ M_TO_DATE
					+ "','"
					+ M_FMT_MASK
					+ "') AND NVL(PC_PAID_FLAG,'N') != 'A' "*/
					+ "AND POL_END_DT BETWEEN TO_DATE('"
					+ M_FROM_DATE
					+ "','"
					+ M_FMT_MASK
					+ "') AND TO_DATE('"
					+ M_TO_DATE
					+ "','"
					+ M_FMT_MASK + "')";
		} else if ("S".equalsIgnoreCase(surrendarType)) {
			
			/* Newly Added By Dhinesh on 15-06-2017 for ssp call id  ZBILQC-1728303 - Policy from and to are same */
			
			toCompValue = fromCompValue;
			
			/*End*/
			
			M_WHERE = " WHERE SMV_POL_SYS_ID IN (SELECT DISTINCT POL_SYS_ID FROM PT_IL_POLICY,PT_IL_PREM_COLL "
					+ "WHERE POL_SYS_ID = PT_IL_PREM_COLL.PC_POL_SYS_ID AND SMV_TYPE = 'S' AND POL_NO BETWEEN '"
					+ fromCompValue
					+ "' AND '"
					+ toCompValue
					+ "' "
					+ "AND POL_STATUS = 'A"
					/*Commneted by Ram on 16/11/2016 for 
					 * 
					 * + surrendarType
					 * 
					 * End
					 * */
					+ "'  AND POL_MODE_OF_PYMT <> 'S' AND NVL(PC_PAID_FLAG,'N') != 'A') UNION ALL "
					+ "SELECT distinct PT_IL_POLICY.ROWID,0,0,0,0,0,0, to_date(NULL), NULL, 0, POL_SYS_ID,NULL "
					+ "FROM PT_IL_POLICY,PT_IL_PREM_COLL WHERE POL_SYS_ID = PT_IL_PREM_COLL.PC_POL_SYS_ID "
					+ "AND POL_NO BETWEEN '"
					+ fromCompValue
					+ "' AND '"
					+ toCompValue
					+ "' "
					+ "AND POL_STATUS = 'C' AND NVL(PC_PAID_FLAG,'N') != 'A' "
					+ "AND POL_MODE_OF_PYMT <> 'S'" 	//This code Added By Dhinesh for ssp call id : FALCONQC-1716774				
					+ "AND POL_END_DT BETWEEN TO_DATE('"
					+ M_FROM_DATE
					+ "','"
					+ M_FMT_MASK
					+ "') AND TO_DATE('"
					+ M_TO_DATE
					+ "','"
					+ M_FMT_MASK + "')";
		/*  Added By Dhinesh for the ssp call id   Start   */
			
			M_WHERE1 = " WHERE SMV_POL_SYS_ID IN (SELECT DISTINCT POL_SYS_ID FROM PT_IL_POLICY,PT_IL_PREM_COLL "
					+ "WHERE POL_SYS_ID = PT_IL_PREM_COLL.PC_POL_SYS_ID AND SMV_TYPE = 'S' AND POL_NO BETWEEN '"
					+ fromCompValue
					+ "' AND '"
					+ toCompValue
					+ "' "
					+ "AND POL_STATUS = 'A"
					/*Commneted by Ram on 16/11/2016 for 
					 * 
					 * + surrendarType
					 * 
					 * End
					 * */
					+ "'  AND POL_MODE_OF_PYMT = 'S' AND NVL(PC_PAID_FLAG,'N') = 'A') UNION ALL "
					+ "SELECT distinct PT_IL_POLICY.ROWID,0,0,0,0,0,0, to_date(NULL), NULL, 0, POL_SYS_ID,NULL "
					+ "FROM PT_IL_POLICY,PT_IL_PREM_COLL WHERE POL_SYS_ID = PT_IL_PREM_COLL.PC_POL_SYS_ID "
					+ "AND POL_NO BETWEEN '"
					+ fromCompValue
					+ "' AND '"
					+ toCompValue
					+ "' "
					+ "AND POL_STATUS = 'C' AND NVL(PC_PAID_FLAG,'N') = 'A' "
					+ "AND POL_MODE_OF_PYMT = 'S' "
					+ "AND POL_END_DT BETWEEN TO_DATE('"
					+ M_FROM_DATE
					+ "','"
					+ M_FMT_MASK
					+ "') AND TO_DATE('"
					+ M_TO_DATE
					+ "','"
					+ M_FMT_MASK + "')";
			
			/*    End   */
		}

		/*   Added By Dhinesh for ssp call id : FALCONQC-1716774   */
		if ("S".equalsIgnoreCase(surrendarType))
		{
			query = "select ROWID,SMV_FC_RED_SA,SMV_LC_RED_SA,SMV_FC_ACC_PROFIT,SMV_LC_ACC_PROFIT,SMV_FC_GROSS_VALUE,SMV_LC_GROSS_VALUE,SMV_UPD_DT,SMV_UPD_UID,SMV_SYS_ID,SMV_POL_SYS_ID,SMV_TYPE from PT_IL_SURR_MAT_VALUES";
	 String query1= query;
			query =  "select ROWID,SMV_FC_RED_SA,SMV_LC_RED_SA,SMV_FC_ACC_PROFIT,SMV_LC_ACC_PROFIT,SMV_FC_GROSS_VALUE,SMV_LC_GROSS_VALUE,SMV_UPD_DT,SMV_UPD_UID,SMV_SYS_ID,SMV_POL_SYS_ID,SMV_TYPE from PT_IL_SURR_MAT_VALUES"
					+ M_WHERE;
			query = query+"  UNION ALL  "+query1+M_WHERE1;
		}
		else
		{
			query = "select ROWID,SMV_FC_RED_SA,SMV_LC_RED_SA,SMV_FC_ACC_PROFIT,SMV_LC_ACC_PROFIT,SMV_FC_GROSS_VALUE,SMV_LC_GROSS_VALUE,SMV_UPD_DT,SMV_UPD_UID,SMV_SYS_ID,SMV_POL_SYS_ID,SMV_TYPE from PT_IL_SURR_MAT_VALUES"
					+ M_WHERE;
		}
		
		/*  End */
		
		System.out.println("preQueryPT_IL_SURR_MAT_VALUES query    : "+query);
		
		return query;
	}

	private void preBlockPT_IL_SURR_MAT_VALUES() {
		System.out.println("DUMMY_ACTION.preBlockPT_IL_SURR_MAT_VALUES().....");
	}

	public List displayLovUI_M_POL_NO_FROM(Object obj) throws Exception {
		ArrayList suggesionList = new ArrayList();
		String query = "";
		if (obj.toString().equals("*")) {
			query = "SELECT POL_NO,POL_ISSUE_DT FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A','R') "
				+ "AND POL_STATUS NOT IN ('P','C','M','D','S') AND NVL(POL_NO_YRS_PREM_PAID,0) >=(SELECT PLAN_SURR_YRS FROM PM_IL_PLAN"
				+ " WHERE  PLAN_CODE = POL_PLAN_CODE )"
				+ "AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND rownum < 25 ORDER BY 1 ASC ";
	} else {
		/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
		 * 
		 * query = "SELECT POL_NO,POL_ISSUE_DT FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A','R') "
				+ " AND   POL_STATUS NOT IN ('P','C','M','D','S') AND NVL(POL_NO_YRS_PREM_PAID,0) >=(SELECT PLAN_SURR_YRS FROM PM_IL_PLAN"
				+ " WHERE  PLAN_CODE = POL_PLAN_CODE )"
				+ "AND POL_NO LIKE '"
				+ obj
				+ "%' AND POL_DS_TYPE = '2' AND rownum < 25 ORDER BY 1 ASC ";*/
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
		query = "SELECT POL_NO,POL_ISSUE_DT FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A','R') "
				+ " AND   POL_STATUS NOT IN ('P','C','M','D','S') AND NVL(POL_NO_YRS_PREM_PAID,0) >=(SELECT PLAN_SURR_YRS FROM PM_IL_PLAN"
				+ " WHERE  PLAN_CODE = POL_PLAN_CODE )"
				+ "AND UPPER(POL_NO) LIKE UPPER('"
				+ obj
				+ "%') AND POL_DS_TYPE = '2' AND rownum < 25 ORDER BY 1 ASC ";
		/*end*/
	}
		ResultSet rs = getHandler().executeSelectStatement(query,
				getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("POL_NO"));
			bean.setName(rs.getString("POL_ISSUE_DT"));
			suggesionList.add(bean);
		}
		rs.close();
		return suggesionList;
	}

	public List displayLovUI_M_POL_NO_TO(Object obj) throws Exception {
		ArrayList suggesionList = new ArrayList();
		String query = "";
		if (obj.toString().equals("*")) {
			query = "SELECT POL_NO,POL_ISSUE_DT FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A','R') "
				+ "AND POL_STATUS NOT IN ('P','C','M','D','S') AND NVL(POL_NO_YRS_PREM_PAID,0) >=(SELECT PLAN_SURR_YRS FROM PM_IL_PLAN"
				+ " WHERE  PLAN_CODE = POL_PLAN_CODE )"
				+ "AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND rownum < 25 ORDER BY 1 ASC ";
	} else {
		/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
		 * 
		 * query = "SELECT POL_NO,POL_ISSUE_DT FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A','R') "
				+ " AND   POL_STATUS NOT IN ('P','C','M','D','S') AND NVL(POL_NO_YRS_PREM_PAID,0) >=(SELECT PLAN_SURR_YRS FROM PM_IL_PLAN"
				+ " WHERE  PLAN_CODE = POL_PLAN_CODE )"
				+ "AND POL_NO LIKE '"
				+ obj
				+ "%' AND POL_DS_TYPE = '2' AND rownum < 25 ORDER BY 1 ASC ";*/
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
		query = "SELECT POL_NO,POL_ISSUE_DT FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A','R') "
				+ " AND   POL_STATUS NOT IN ('P','C','M','D','S') AND NVL(POL_NO_YRS_PREM_PAID,0) >=(SELECT PLAN_SURR_YRS FROM PM_IL_PLAN"
				+ " WHERE  PLAN_CODE = POL_PLAN_CODE )"
				+ "AND UPPER(POL_NO) LIKE UPPER('"
				+ obj
				+ "%') AND POL_DS_TYPE = '2' AND rownum < 25 ORDER BY 1 ASC ";
		/*end*/
	}

		ResultSet rs = getHandler().executeSelectStatement(query,
				getConnection());
		rs.setFetchSize(25);
		while (rs.next()) {
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("POL_NO"));
			bean.setName(rs.getString("POL_ISSUE_DT"));
			suggesionList.add(bean);
		}
		rs.close();
		return suggesionList;
	}

	public Connection getConnection() throws Exception {
		return CommonUtils.getConnection();
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}

	public List<PT_IL_SURR_MAT_VALUES> getTableValuesList() {
		
		/*Added by Raja .R on 08-07-2016.SSP Call ID - FALCONQC-1714757
        Start*/  
		
		/*if (tableValuesList.size() == 0) {
			for (int i = 0; i < 5; i++) {
				PT_IL_SURR_MAT_VALUES bean = new PT_IL_SURR_MAT_VALUES();
				tableValuesList.add(bean);
			}
		}*/
		
		 /*End of SSP Call ID - FALCONQC-1714757 */
		
		return tableValuesList;
	}

	public void setTableValuesList(List<PT_IL_SURR_MAT_VALUES> tableValuesList) {
		this.tableValuesList = tableValuesList;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public HtmlInputText getCOMP_UI_M_BASE_CURR() {
		return COMP_UI_M_BASE_CURR;
	}

	public void setCOMP_UI_M_BASE_CURR(HtmlInputText comp_ui_m_base_curr) {
		COMP_UI_M_BASE_CURR = comp_ui_m_base_curr;
	}

	public HtmlOutputLabel getCOMP_B_LC_VALUES() {
		return COMP_B_LC_VALUES;
	}

	public void setCOMP_B_LC_VALUES(HtmlOutputLabel comp_b_lc_values) {
		COMP_B_LC_VALUES = comp_b_lc_values;
	}


	public void clearMap(){
		getErrorMap().clear();
		getWarningMap().clear();
	}
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void valiadteM_POL_NO_FROM(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_FROM((String) value);
			when_validate_item_M_POL_NO_FROM();
			COMP_UI_M_POL_NO_TO.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void when_validate_item_M_POL_NO_FROM()throws Exception{
		try {
			new CommonUtils().SET_REP_FIRST_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FROM(),"String");
			 DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_TO()) ;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void actionListenerM_POL_NO_FROM(ActionEvent actionEvent) throws Exception 
	{
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		try {
			if (inputValue.isEmpty()) {
				/* Modified by Dhinesh on 27/11/2016 for Hide PolicyNumber To field 
				 * 
				 * COMP_UI_M_POL_NO_FROM
						.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
				DUMMY_BEAN.setUI_M_POL_NO_FROM(PELConstants.PROCESS_TOVALUE);
				
				End
				*/
				
				/*Added by Ram on 27/11/2016 for throwing Exception*/ 
				throw new Exception("Policy No Required");
				/*End*/
				
			} else {
				DUMMY_BEAN.setUI_M_POL_NO_FROM(inputValue);
			}

			//chk_Pol_No(DUMMY_BEAN.getUI_M_POL_NO_FROM());
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
			if(!PELConstants.PROCESS_FROMVALUE.equals(DUMMY_BEAN.getUI_M_POL_NO_FROM()))
			{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(DUMMY_BEAN.getUI_M_POL_NO_FROM());
				DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_FROM());
			}else{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				DUMMY_BEAN.setUI_M_POL_NO_TO(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			DUMMY_BEAN.setUI_M_POL_NO_TO(inputTextString);
		}
		
			chk_Pol_No(DUMMY_BEAN.getUI_M_POL_NO_TO());
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}
	}
	
	public void valiadteM_POL_NO_TO(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) value);
			when_validate_item_M_POL_NO_TO();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void when_validate_item_M_POL_NO_TO()throws Exception{
		try {
			new CommonUtils().SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FROM(),DUMMY_BEAN.getUI_M_POL_NO_TO(),"String");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void valiadteM_FROM_DATE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			Date sysdate=new Date();
			if(((Date) value).after(sysdate)){
				throw new Exception("From date should not be greater than current date");
				
			}
			DUMMY_BEAN.setUI_M_FROM_DATE((Date) value);
			when_validate_item_M_FROM_DATE();
			COMP_UI_M_TO_DATE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void when_validate_item_M_FROM_DATE()throws Exception{
		try {
				if(DUMMY_BEAN.getUI_M_TO_DATE() == null){
					DUMMY_BEAN.setUI_M_TO_DATE(DUMMY_BEAN.getUI_M_FROM_DATE());
				}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void valiadteM_TO_DATE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			Date sysdate=new Date();
			if(((Date) value).after(sysdate)){
				throw new Exception("From date should not be greater than current date");
			}	
			
			DUMMY_BEAN.setUI_M_TO_DATE((Date) value);
			
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void getDetails() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PT_IL_SURR_MAT_VALUES_BEAN = (PT_IL_SURR_MAT_VALUES) dataTable
					.getRowData();
			PT_IL_SURR_MAT_VALUES_BEAN.setRowSelected(true);
			resetAllComponents();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	public void resetAllComponents(){
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_UI_M_POL_NO().resetValue();
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE().resetValue();
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_RED_SA().resetValue();
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_ACC_PROFIT().resetValue();
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_ACC_PROFIT().resetValue();
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_GROSS_VALUE().resetValue();
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_UI_M_STATUS().resetValue();
		getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_RED_SA().resetValue();
	    
	}
	
	private void resetSelectedRow() {
		Iterator<PT_IL_SURR_MAT_VALUES> PT_IL_SURR_MAT_VALUES_ITR = tableValuesList
				.iterator();
		while (PT_IL_SURR_MAT_VALUES_ITR.hasNext()) {
			PT_IL_SURR_MAT_VALUES_ITR.next().setRowSelected(false);
		}
	}

	public PT_IL_SURR_MAT_VALUES_ACTION getPT_IL_SURR_MAT_VALUES_ACTION_BEAN() {
		return PT_IL_SURR_MAT_VALUES_ACTION_BEAN;
	}

	public void setPT_IL_SURR_MAT_VALUES_ACTION_BEAN(
			PT_IL_SURR_MAT_VALUES_ACTION pt_il_surr_mat_values_action_bean) {
		PT_IL_SURR_MAT_VALUES_ACTION_BEAN = pt_il_surr_mat_values_action_bean;
	}
	
	public void post(ActionEvent event){
		try{
			if(PT_IL_SURR_MAT_VALUES_BEAN.getROWID() != null){
			preUpdatePT_IL_SURR_MAT_VALUES();
			onUpdatePT_IL_SURR_MAT_VALUES();
			getWarningMap().put(
					PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$Grid$update"));
			getWarningMap().put(
					"postRecord",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$Grid$update"));
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$updatenotallowed"));
			}
			PT_IL_SURR_MAT_VALUES_BEAN.setRowSelected(true);
			
			/*Added by Janani on 12.02.2018 for ZB*/
			CommonUtils.getConnection().commit();
			/*End*/
			
		}catch (Exception exc) {
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}
	
	public void saveRecord() {
		try {
			CommonUtils.clearMaps(this);
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}
	
	public void validate_SMV_FC_RED_SA(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_RED_SA((Double) value);
			whenValidateSMV_FC_RED_SA();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_RED_SA().resetValue();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_GROSS_VALUE().resetValue();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validate_SMV_LC_RED_SA(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_LC_RED_SA((Double) value);
			whenValidateSMV_LC_RED_SA();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE().resetValue();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_GROSS_VALUE().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validate_SMV_FC_ACC_PROFIT(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_ACC_PROFIT((Double) value);
			whenValidateSMV_FC_ACC_PROFIT();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_ACC_PROFIT().resetValue();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE().resetValue();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_GROSS_VALUE().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validate_SMV_LC_ACC_PROFIT(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {

		try {
			PT_IL_SURR_MAT_VALUES_BEAN.setSMV_FC_ACC_PROFIT((Double) value);
			whenValidateSMV_LC_ACC_PROFIT();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_FC_GROSS_VALUE().resetValue();
			getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getCOMP_SMV_LC_GROSS_VALUE().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
   public void chk_Pol_No(String pol_no) throws Exception {
		Connection connection = null;
		ResultSet res = null;
		String query = "SELECT POL_NO_YRS_PREM_PAID,PLAN_SURR_YRS,PLAN_SURR_YN  FROM PT_IL_POLICY ,PM_IL_PLAN WHERE  PLAN_CODE = POL_PLAN_CODE AND POL_NO = ?";
		Double prem_paid_yrs = 0.0;
		Double surr_yrs = 0.0;
		String plan_surr_yn =null;

		try {
			connection = CommonUtils.getConnection();
			res = getHandler().executeSelectStatement(query, connection,
					new Object[] { pol_no });

			if (res.next()) {
				prem_paid_yrs = res.getDouble(1);
				surr_yrs = res.getDouble(2);
				plan_surr_yn=res.getString(3);
			}
			if("Y".equals(CommonUtils.nvl(plan_surr_yn,"X"))){
			if (prem_paid_yrs < surr_yrs) {
				throw new Exception("Invalid Policy");
			}
			}else if("N".equals(CommonUtils.nvl(plan_surr_yn,"X"))){
				throw new Exception("Surrender Not Applicable For this Policy");
				
			}
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}

	}
   
   
   /*public String printButtonAction() {
		String outcome = null;
		try {
			outcome = "PILP007_PRINT";
		} catch (Exception exception) {
			exception.getMessage();
			getErrorMap().put("current", exception.getMessage());
		}
		return outcome;
	}*/
   
   /*Added by Raja .R on 09-07-2016.SSP Call ID -FALCONQC-1714757
   Start*/ 

   public void validateUI_M_SURR_TYPE(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		try {
			
			
			
			DUMMY_BEAN.setUI_M_SURR_TYPE((String) value);
			System.out.println("Surrender Type ;;;;;;;;;; "+DUMMY_BEAN.getUI_M_SURR_TYPE());
			if(DUMMY_BEAN.getUI_M_SURR_TYPE().equalsIgnoreCase("S"))
			{
				
				chk_Pol_No(DUMMY_BEAN.getUI_M_POL_NO_FROM());
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue("FC Surrender Value");
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_GROSS_VALUE_LABEL().setValue("LC Surrender Value");
				
			}
			else if(DUMMY_BEAN.getUI_M_SURR_TYPE().equalsIgnoreCase("P"))
			{
				
				
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_GROSS_VALUE_LABEL().setValue("FC Paid Up Value");
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_GROSS_VALUE_LABEL().setValue("LC Paid Up Value");
			}
			
			/*added by raja on 16-05-2017*/
			if(DUMMY_BEAN.getUI_M_SURR_TYPE()!=null && DUMMY_BEAN.getUI_M_SURR_TYPE().equalsIgnoreCase("D"))
			{
				
				
				COMP_SMV_FC_RED_SA.setDisabled(true);
				COMP_SMV_FC_ACC_PROFIT.setDisabled(true);
				COMP_SMV_LC_RED_SA.setDisabled(true);
				COMP_SMV_LC_ACC_PROFIT.setDisabled(true);
				COMP_UI_M_BUT_ACCEPT.setDisabled(true);
				
			}
			else
			{
				COMP_SMV_FC_RED_SA.setDisabled(false);
				COMP_SMV_FC_ACC_PROFIT.setDisabled(false);
				COMP_SMV_LC_RED_SA.setDisabled(false);
				COMP_SMV_LC_ACC_PROFIT.setDisabled(false);
				COMP_UI_M_BUT_ACCEPT.setDisabled(false);
			}
			/*end*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
   /*End of SSP Call ID - FALCONQC-1714757 */
   
   	/*COmmented by saritha on 16-Feb-2017 for On registration on claim (including surrender, maturity and partial withdrawal) 
	 email should be sent to finance user.
	 *
	 */
	/* public String emailTriggerProcCall() throws Exception{
		   	String subject="SELECT PMT_PROD_CODE,PMT_MAIL_SUB,PMT_MAIL_TEXT FROM PM_LIFE_MAIL_TEMPLATE WHERE PMT_MAIL_TYPE = 'SUR'";
		   	String tomail="SELECT USER_EMAIL_ID FROM MENU_USER WHERE USER_GROUP_ID='FINUSER'";
		   	String insert="INSERT INTO PW_LIFE_EMAIL_DATA (PLED_SRNO, PLED_TYPE, PLED_TO, PLED_SUB, PLED_BODY, PLED_STATUS) VALUES (PIL_MAIL_SYS_ID.NEXTVAL,?,?,?,?,?)";
		   	String out="N";
		   	ResultSet rs2=null;
		   	ResultSet rs3=null;
		   
		   	int seqno = 0;
		   	String productcode = null;
		   	String sub = null;
		   	String body = null;
		   	String mailid = null;
		   	Connection con=CommonUtils.getConnection();
		   	System.out.println("Connection :"+con);

		   	rs2=new CRUDHandler().executeSelectStatement(subject, con);
		   	rs3=new CRUDHandler().executeSelectStatement(tomail, con);
		  
		   	if(rs2.next()){
		   		productcode=rs2.getString("PMT_PROD_CODE");
		   		sub=rs2.getString("PMT_MAIL_SUB");
		   		body=rs2.getString("PMT_MAIL_TEXT");
		   	}
		   	if(rs3.next()){
		   		mailid=rs3.getString("USER_EMAIL_ID");
		   		if(mailid!=null){
		   			Object[] values1 = {"SUR",mailid,sub,body,"N" };
				   	new CRUDHandler().executeInsertStatement(insert, con, values1);
				   	con.commit();
		   			
		   		out="Y";
		   		}
		   	}
		   	System.out.println("seqno  :"+seqno);
		   	System.out.println("mailid  :"+mailid);
			System.out.println("sub  :"+sub);
			System.out.println("body  :"+body);
		   	
			return out;
			}*/

	 		/*End*/
   
   
   /*aDDED BY SANKARA NARAYANAN ON 03/04/2017*/
   public void P_UPD_SURR_STS(
           String P_POL_NO,
           String P_SURR_TYPE)
           throws SQLException, Exception {
       Connection connection = null;
        connection = CommonUtils.getConnection();

       ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
       ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
       ArrayList<String> returnList = new ArrayList<String>();
       OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",P_POL_NO);
       OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",P_SURR_TYPE);
       parameterList.add(param1);
       parameterList.add(param2);

       OracleProcedureHandler procHandler = new OracleProcedureHandler();
       outputList = procHandler.execute(parameterList, connection,
               "P9ILPK_SURR_PAID.P_UPD_SURR_STS");
     
  
   }
   
   /*END*/
   
   /*added by raja on 25-04-2017*/
	public void accessValidation() throws Exception
	{
		try
		{
			int shareRatioSystemParam =0;	
			String flag=null;
		/*int shareRatioSystemParam = ((BigDecimal)CommonUtils.getPPSystemParameterValue("MED_EXAM_INS")).intValue();
		if(shareRatioSystemParam == 2){*/
		String query="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_CODE='DIR_LAP_PRCS'";
		ResultSet rs =new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(rs.next())
		{
			shareRatioSystemParam=rs.getInt("PS_VALUE");
		}
		if(shareRatioSystemParam == 2){
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();

			String userID=session.get("GLOBAL.M_USER_ID").toString();
			String queryUserApprSetup="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET TAB1 WHERE "
					+ "ASD_FLAG = '2' AND ASD_CODE='DIR_LAP_PRCS' AND "
					+ "ASD_USER_ID = ? AND ASD_FM_PROD_CODE = ? AND "
					+ "ASD_TO_PROD_CODE = ?";
			
			ResultSet UserApprSetup=new CRUDHandler().executeSelectStatement(queryUserApprSetup, CommonUtils.getConnection(), new Object[]{userID,
				getPROD_CODE(),
				getPROD_CODE()});
			
			while(UserApprSetup.next())
			{
				flag=UserApprSetup.getString("ASD_CHAR_VALUE");
			}
			
			if(flag!=null && flag.equalsIgnoreCase("N"))
			{
				throw new Exception("User not authorized");
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public String getPROD_CODE()
	{
		String plantype=null;
		try{
			
		String query="SELECT POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO='"+DUMMY_BEAN.getUI_M_POL_NO_FROM()+"'";
		ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(resultset.next())
		{
			plantype=resultset.getString("POL_PROD_CODE");
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return plantype;
		
	}
	
	
	public void PROCESS_LAPSATION_DIRECTProcedureCall(String M_TO_DATE,String fromPolNo)throws Exception
	{
		try
		{
		Connection connection = CommonUtils.getConnection();
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "DATE", "IN", M_TO_DATE);
		
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN", fromPolNo);
		
		
		paramList.add(param1);
		paramList.add(param2);
		
		//paramList.add(param7);
		
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> list = procHandler.execute(paramList,
					connection, "PROCESS_LAPSATION_DIRECT");
					
	}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public void initializeAllComponents()
	{
		COMP_SMV_FC_RED_SA = new HtmlInputText();
		COMP_SMV_FC_ACC_PROFIT= new HtmlInputText();
		COMP_SMV_LC_RED_SA=new HtmlInputText();
		COMP_SMV_LC_ACC_PROFIT=new HtmlInputText();
		COMP_UI_M_BUT_ACCEPT=new HtmlAjaxCommandButton();
		
		/*Added by Janani on 12.02.2018 for ZB as per Sivaram's sugges.*/
		COMP_UI_M_POST_BUT=new HtmlAjaxCommandButton();
		/*End*/
	}
	/*end*/

	/*Added by Janani on 12.02.2018 for ZB as per Sivaram's sugges.*/
	
	
	private HtmlAjaxCommandButton COMP_UI_M_POST_BUT;
	
	public HtmlAjaxCommandButton getCOMP_UI_M_POST_BUT() {
		return COMP_UI_M_POST_BUT;
	}

	public void setCOMP_UI_M_POST_BUT(HtmlAjaxCommandButton cOMP_UI_M_POST_BUT) {
		COMP_UI_M_POST_BUT = cOMP_UI_M_POST_BUT;
	}

	public void disableFields()
	{
		String ps_value = null;
		
		try{
			
		String query="SELECT PS_VALUE FROM PP_SYSTEM1 WHERE PS_TYPE  = 'IL_SURR_SA'";
		ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
		while(resultset.next())
		{
			ps_value = resultset.getString("PS_VALUE");
			
			if(ps_value.equalsIgnoreCase("1"))
			{

				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_RED_SA().setDisabled(true);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_ACC_PROFIT().setDisabled(true);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_RED_SA().setDisabled(true);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_ACC_PROFIT().setDisabled(true);
				COMP_UI_M_POST_BUT.setDisabled(true);

			}else
			{
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_RED_SA().setDisabled(false);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_FC_ACC_PROFIT().setDisabled(false);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_RED_SA().setDisabled(false);
				PT_IL_SURR_MAT_VALUES_ACTION_BEAN.getCOMP_SMV_LC_ACC_PROFIT().setDisabled(false);
				COMP_UI_M_POST_BUT.setDisabled(false);
			}
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	/*End*/
}
