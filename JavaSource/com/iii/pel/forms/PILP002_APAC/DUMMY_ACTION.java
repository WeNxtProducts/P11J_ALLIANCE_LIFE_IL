package com.iii.pel.forms.PILP002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILT002_APAC.PILT002_APAC_COMPOSITE_ACTION;
import com.iii.pel.forms.PILT017.PT_IL_PYMT_DTLS_ACTION;
import com.iii.pel.util.Email_Procedure_Call;
import com.iii.pel.utils.PILPK_POLICY_APPROVAL;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.runtime.functions.MigratingFunctions;
import com.iii.premia.runtime.functions.NumericFunctions;

public class DUMMY_ACTION extends CommonAction {

	private ControlBean controlBean = null;
	Connection connection = null;
	ResultSet resultset_Poldtls = null;
	HttpSession session = null;
	CRUDHandler handler = null;
	String M_TITLE = null;

	private List<SelectItem> PREM_GEN_YN_LIST = new ArrayList<SelectItem>();
	private List<SelectItem> BROK_GEN_YN_LIST = new ArrayList<SelectItem>();
	private List<SelectItem> RE_UW_REQ_YN_LIST = new ArrayList<SelectItem>();

	// FacesContext fc = FacesContext.getCurrentInstance();
	// FacesContext ctx= FacesContext.getCurrentInstance();

	public COMPOSITE_ACTION_BEAN compositeAction_PILP002;

	private List<DUMMY> customerCodeList;

	private HtmlOutputLabel COMP_UI_M_RE_UW_REQ_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_RE_UW_REQ_YN;

	private HtmlOutputLabel COMP_UI_M_RE_UW_REQ_REASON_LABEL;

	private HtmlInputText COMP_UI_M_RE_UW_REQ_REASON;

	private HtmlOutputLabel COMP_UI_M_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_APPRV_DATE;

	private HtmlOutputLabel COMP_UI_M_TRAN_DATE_LABEL;

	private HtmlCalendar COMP_UI_M_TRAN_DATE;

	private HtmlOutputLabel COMP_UI_M_CUST_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_FC_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_FC_AMOUNT;

	private HtmlOutputLabel COMP_UI_M_LC_AMOUNT_LABEL;

	private HtmlInputText COMP_UI_M_LC_AMOUNT;

	private HtmlOutputLabel COMP_UI_M_PREM_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_PREM_GEN_YN;

	private HtmlOutputLabel COMP_UI_M_BROK_GEN_YN_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_BROK_GEN_YN;

	private HtmlOutputLabel COMP_UI_M_POL_PREM_WAIVE_YN_LABEL;

	private HtmlOutputLabel COMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL;

	private HtmlOutputLabel COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_POL_PREM_WAIVE_YN;

	private HtmlSelectOneMenu COMP_UI_M_POL_PREM_WAIVE_TYPE;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_DESC;

	private HtmlOutputLabel COMP_UI_M_POL_PREM_WAIVE_INT_RATE_LABEL;
	
	

	private HtmlInputText COMP_UI_M_POL_PREM_WAIVE_INT_RATE;

	private HtmlInputText COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT;

	private HtmlCommandButton COMP_UI_M_BUT_CUST_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_PREFORMBUTTON;

	private HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_UI_M_BUT_POL_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_ENDT;
	private HtmlCommandButton COMP_UI_M_BUT_APPROVAL;
	private HtmlCommandButton COMP_UI_M_BUT_CUSTOMER;
	private HtmlCommandButton COMP_UI_M_BUT_CONTRACTOR;
	private HtmlCommandButton COMP_UI_M_BUT_HOLD;
	private HtmlCommandButton COMP_UI_M_BUT_FUND_DTL;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_RATE_PAYOR;
	private HtmlCommandButton COMP_UI_M_BUT_OCC_RATE_PAYEE;
	private HtmlCommandButton COMP_UI_M_BUT_DOC_GEN_NO;
	private HtmlCommandButton COMP_UI_M_BUT_FUND_QUERY;
	private HtmlCommandButton COMP_UI_M_BUT_ADD_DETAILS;
	private HtmlCommandButton COMP_UI_M_BUT_MORE_COVER;
	private HtmlCommandButton COMP_UI_M_BUT_UDDATE_STAT;
	private HtmlCommandButton COMP_UI_M_BUT_PRMDTLS;
	private HtmlCommandButton COMP_UI_M_BUT_POL_AMDT;
	private HtmlCommandButton COMP_UI_M_BUT_CALC_DISC_LOAD;
	private HtmlCommandButton COMP_UI_M_BUT_ANN_DTLS;
	private HtmlCommandButton COMP_UI_M_BUT_CONVERT;
	private HtmlCommandButton COMP_UI_M_BUS_RUL;
	
	/*NEWLY ADDED BY DHINESH ON 12-06-2017*/
	private HtmlInputText COMP_UI_POL_END_ISSUANCE;

	public HtmlInputText getCOMP_UI_POL_END_ISSUANCE() {
		return COMP_UI_POL_END_ISSUANCE;
	}

	public void setCOMP_UI_POL_END_ISSUANCE(HtmlInputText cOMP_UI_POL_END_ISSUANCE) {
		COMP_UI_POL_END_ISSUANCE = cOMP_UI_POL_END_ISSUANCE;
	}
	
	/*END*/

	

	private DUMMY DUMMY_BEAN;
	private DUMMY1 DUMMY_BEAN1;

	private List<SelectItem> POL_PREM_WAIVE_YN_LIST;

	private List<SelectItem> POL_PREM_WAIVE_TYPE_LIST;

	// Map<String, Object> session =
	// FacesContext.getCurrentInstance().getExternalContext().getSessionMap();

	public List<SelectItem> getPOL_PREM_WAIVE_TYPE_LIST() {
		return POL_PREM_WAIVE_TYPE_LIST;
	}

	public void setPOL_PREM_WAIVE_TYPE_LIST(
			List<SelectItem> pol_prem_waive_type_list) {
		POL_PREM_WAIVE_TYPE_LIST = pol_prem_waive_type_list;
	}

	public List<SelectItem> getPOL_PREM_WAIVE_YN_LIST() {
		return POL_PREM_WAIVE_YN_LIST;
	}

	public void setPOL_PREM_WAIVE_YN_LIST(
			List<SelectItem> pol_prem_waive_yn_list) {
		POL_PREM_WAIVE_YN_LIST = pol_prem_waive_yn_list;
	}
/*added by saranya for email capture on 8-04-16*/
    
    private HtmlOutputLabel COMP_MAIL_SEND_TO_LABEL;
    private HtmlSelectOneMenu  COMP_MAIL_SEND_TO_TYPE;
	public HtmlOutputLabel getCOMP_MAIL_SEND_TO_LABEL() {
		return COMP_MAIL_SEND_TO_LABEL;
	}

	public void setMAIL_SEND_TO_LABEL(
			HtmlOutputLabel cOMP_MAIL_SEND_TO_LABEL) {
		COMP_MAIL_SEND_TO_LABEL = cOMP_MAIL_SEND_TO_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_MAIL_SEND_TO_TYPE() {
		return COMP_MAIL_SEND_TO_TYPE;
	}

	public void setCOMP_MAIL_SEND_TO_TYPE(
			HtmlSelectOneMenu cOMP_MAIL_SEND_TO_TYPE) {
		COMP_MAIL_SEND_TO_TYPE = cOMP_MAIL_SEND_TO_TYPE;
	}
	private String MAIL_SEND_TO;

    public String getMAIL_SEND_TO() {
		return MAIL_SEND_TO;
	}

	public void setMAIL_SEND_TO(String mAIL_SEND_TO) {
		MAIL_SEND_TO = mAIL_SEND_TO;
	}
	private List<SelectItem> listMAIL_SEND_TO = new ArrayList<SelectItem>();
	

	public List<SelectItem> getListMAIL_SEND_TO() {
		listMAIL_SEND_TO=MAIL_SEND_TO_LIST();
		return listMAIL_SEND_TO;
	}

	public void setListMAIL_SEND_TO(List<SelectItem> listMAIL_SEND_TO) {
		this.listMAIL_SEND_TO = listMAIL_SEND_TO;
	}

	
    /*end*/

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		DUMMY_BEAN1 = new DUMMY1();
		//added by saranya
		getListMAIL_SEND_TO();
		//end
		controlBean = (ControlBean) CommonUtils.getControlBean().clone();
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			// preForm();
			List<SelectItem> listItemPremGen = ListItemUtil
					.getDropDownListValue(connection, "PILP002_APAC", "DUMMY",
							"DUMMY.M_PREM_GEN_YN", "YESNO");
			setPREM_GEN_YN_LIST(listItemPremGen);

			List<SelectItem> listItemBrokGen = ListItemUtil
					.getDropDownListValue(connection, "PILP002_APAC", "DUMMY",
							"DUMMY.M_BROK_GEN_YN", "YESNO");
			setBROK_GEN_YN_LIST(listItemBrokGen);

			List<SelectItem> listItemReReqYN = ListItemUtil
					.getDropDownListValue(connection, "PILP002_APAC", "DUMMY",
							"DUMMY.M_RE_UW_REQ_YN", "YESNO");
			setRE_UW_REQ_YN_LIST(listItemReReqYN);

			List<SelectItem> list = ListItemUtil.getDropDownListValue(
					connection, "PILP002_APAC", "DUMMY",
					"DUMMY.M_POL_PREM_WAIVE_YN", "YESNO");
			setPOL_PREM_WAIVE_YN_LIST(list);

			List<SelectItem> waiveTypeList = ListItemUtil.getDropDownListValue(
					connection, "PILP002_APAC", "DUMMY",
					"DUMMY.M_PREM_WAIVE_TYPE", "PREM_WV_TYPE");
			setPOL_PREM_WAIVE_TYPE_LIST(waiveTypeList);

			preForm();
			pilp002_apac_when_new_form_instance();
			instantiateAllComponent();
			// COMP_UI_M_POL_NO.setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVAL() {
		return COMP_UI_M_BUT_APPROVAL;
	}

	public void setCOMP_UI_M_BUT_APPROVAL(
			HtmlCommandButton comp_ui_m_but_approval) {
		COMP_UI_M_BUT_APPROVAL = comp_ui_m_but_approval;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUSTOMER() {
		return COMP_UI_M_BUT_CUSTOMER;
	}

	public void setCOMP_UI_M_BUT_CUSTOMER(
			HtmlCommandButton comp_ui_m_but_customer) {
		COMP_UI_M_BUT_CUSTOMER = comp_ui_m_but_customer;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CONTRACTOR() {
		return COMP_UI_M_BUT_CONTRACTOR;
	}

	public void setCOMP_UI_M_BUT_CONTRACTOR(
			HtmlCommandButton comp_ui_m_but_contractor) {
		COMP_UI_M_BUT_CONTRACTOR = comp_ui_m_but_contractor;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_HOLD() {
		return COMP_UI_M_BUT_HOLD;
	}

	public void setCOMP_UI_M_BUT_HOLD(HtmlCommandButton comp_ui_m_but_hold) {
		COMP_UI_M_BUT_HOLD = comp_ui_m_but_hold;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_DTL() {
		return COMP_UI_M_BUT_FUND_DTL;
	}

	public void setCOMP_UI_M_BUT_FUND_DTL(
			HtmlCommandButton comp_ui_m_but_fund_dtl) {
		COMP_UI_M_BUT_FUND_DTL = comp_ui_m_but_fund_dtl;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OCC_RATE_PAYOR() {
		return COMP_UI_M_BUT_OCC_RATE_PAYOR;
	}

	public void setCOMP_UI_M_BUT_OCC_RATE_PAYOR(
			HtmlCommandButton comp_ui_m_but_occ_rate_payor) {
		COMP_UI_M_BUT_OCC_RATE_PAYOR = comp_ui_m_but_occ_rate_payor;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OCC_RATE_PAYEE() {
		return COMP_UI_M_BUT_OCC_RATE_PAYEE;
	}

	public void setCOMP_UI_M_BUT_OCC_RATE_PAYEE(
			HtmlCommandButton comp_ui_m_but_occ_rate_payee) {
		COMP_UI_M_BUT_OCC_RATE_PAYEE = comp_ui_m_but_occ_rate_payee;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ENDT() {
		return COMP_UI_M_BUT_ENDT;
	}

	public void setCOMP_UI_M_BUT_ENDT(HtmlCommandButton comp_ui_m_but_endt) {
		COMP_UI_M_BUT_ENDT = comp_ui_m_but_endt;
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

	public void setCOMP_UI_M_APPRV_DATE_LABEL(
			HtmlOutputLabel COMP_UI_M_APPRV_DATE_LABEL) {
		this.COMP_UI_M_APPRV_DATE_LABEL = COMP_UI_M_APPRV_DATE_LABEL;
	}

	public void setCOMP_UI_M_APPRV_DATE(HtmlCalendar COMP_UI_M_APPRV_DATE) {
		this.COMP_UI_M_APPRV_DATE = COMP_UI_M_APPRV_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TRAN_DATE_LABEL() {
		return COMP_UI_M_TRAN_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TRAN_DATE() {
		return COMP_UI_M_TRAN_DATE;
	}

	public void setCOMP_UI_M_TRAN_DATE_LABEL(
			HtmlOutputLabel COMP_UI_M_TRAN_DATE_LABEL) {
		this.COMP_UI_M_TRAN_DATE_LABEL = COMP_UI_M_TRAN_DATE_LABEL;
	}

	public void setCOMP_UI_M_TRAN_DATE(HtmlCalendar COMP_UI_M_TRAN_DATE) {
		this.COMP_UI_M_TRAN_DATE = COMP_UI_M_TRAN_DATE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CUST_CODE_LABEL() {
		return COMP_UI_M_CUST_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CUST_CODE() {
		return COMP_UI_M_CUST_CODE;
	}

	public void setCOMP_UI_M_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_CUST_CODE_LABEL) {
		this.COMP_UI_M_CUST_CODE_LABEL = COMP_UI_M_CUST_CODE_LABEL;
	}

	public void setCOMP_UI_M_CUST_CODE(HtmlInputText COMP_UI_M_CUST_CODE) {
		this.COMP_UI_M_CUST_CODE = COMP_UI_M_CUST_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_FC_AMOUNT_LABEL() {
		return COMP_UI_M_FC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FC_AMOUNT() {
		return COMP_UI_M_FC_AMOUNT;
	}

	public void setCOMP_UI_M_FC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_UI_M_FC_AMOUNT_LABEL) {
		this.COMP_UI_M_FC_AMOUNT_LABEL = COMP_UI_M_FC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_FC_AMOUNT(HtmlInputText COMP_UI_M_FC_AMOUNT) {
		this.COMP_UI_M_FC_AMOUNT = COMP_UI_M_FC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_LC_AMOUNT_LABEL() {
		return COMP_UI_M_LC_AMOUNT_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_LC_AMOUNT() {
		return COMP_UI_M_LC_AMOUNT;
	}

	public void setCOMP_UI_M_LC_AMOUNT_LABEL(
			HtmlOutputLabel COMP_UI_M_LC_AMOUNT_LABEL) {
		this.COMP_UI_M_LC_AMOUNT_LABEL = COMP_UI_M_LC_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_LC_AMOUNT(HtmlInputText COMP_UI_M_LC_AMOUNT) {
		this.COMP_UI_M_LC_AMOUNT = COMP_UI_M_LC_AMOUNT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREM_GEN_YN_LABEL() {
		return COMP_UI_M_PREM_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_PREM_GEN_YN_LABEL(
			HtmlOutputLabel COMP_UI_M_PREM_GEN_YN_LABEL) {
		this.COMP_UI_M_PREM_GEN_YN_LABEL = COMP_UI_M_PREM_GEN_YN_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_BROK_GEN_YN_LABEL() {
		return COMP_UI_M_BROK_GEN_YN_LABEL;
	}

	public void setCOMP_UI_M_BROK_GEN_YN_LABEL(
			HtmlOutputLabel COMP_UI_M_BROK_GEN_YN_LABEL) {
		this.COMP_UI_M_BROK_GEN_YN_LABEL = COMP_UI_M_BROK_GEN_YN_LABEL;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_DESC_LABEL() {
		return COMP_UI_M_POL_CUST_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_DESC() {
		return COMP_UI_M_POL_CUST_DESC;
	}

	public void setCOMP_UI_M_POL_CUST_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_DESC_LABEL) {
		this.COMP_UI_M_POL_CUST_DESC_LABEL = COMP_UI_M_POL_CUST_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_DESC(HtmlInputText COMP_UI_M_POL_CUST_DESC) {
		this.COMP_UI_M_POL_CUST_DESC = COMP_UI_M_POL_CUST_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CUST_CODE() {
		return COMP_UI_M_BUT_CUST_CODE;
	}

	public void setCOMP_UI_M_BUT_CUST_CODE(
			HtmlCommandButton COMP_UI_M_BUT_CUST_CODE) {
		this.COMP_UI_M_BUT_CUST_CODE = COMP_UI_M_BUT_CUST_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PYMT_DTLS() {
		return COMP_UI_M_BUT_PYMT_DTLS;
	}

	public void setCOMP_UI_M_BUT_PYMT_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_PYMT_DTLS) {
		this.COMP_UI_M_BUT_PYMT_DTLS = COMP_UI_M_BUT_PYMT_DTLS;
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

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PREFORMBUTTON() {
		return COMP_UI_M_BUT_PREFORMBUTTON;
	}

	public void setCOMP_UI_M_BUT_PREFORMBUTTON(
			HtmlCommandButton comp_ui_m_but_preformbutton) {
		COMP_UI_M_BUT_PREFORMBUTTON = comp_ui_m_but_preformbutton;
	}

	public void pilp002_apac_dummy_m_pol_no_when_validate_item() {
		ResultSet resultset_C1 = null;
		ResultSet resultset_C2 = null;
		String M_PS_VALUE = null;
		String M_POL_STATUS = null;
		String selectPSVALUE = PILP002_APAC_SQLConstants.selectPS_VALUE;

		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			Object[] selectPSVALUEObject = {};
			resultset_C1 = handler.executeSelectStatement(selectPSVALUE,
					connection, selectPSVALUEObject);
			if (resultset_C1.next()) {
				M_PS_VALUE = resultset_C1.getString(1);
			}
			L_VALIDATE_POL_NO();
			Long validator = (Long) CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID");

			String query = PILP002_APAC_SQLConstants.selectPOL_STATUS;
			Object[] queryObject = { validator };
			resultset_C2 = handler.executeSelectStatement(query, connection,
					queryObject);
			if (resultset_C2.next()) {
				M_POL_STATUS = resultset_C2.getString(1);
			}
			if ("E".equals(MigratingFunctions.nvl(M_POL_STATUS, "N"))) {
				DUMMY_BEAN.setUI_M_APPRV_DATE(new java.sql.Date(Calendar
						.getInstance().getTimeInMillis()));
			} else {
				if ("1".equals(M_PS_VALUE)) {
					DUMMY_BEAN.setUI_M_APPRV_DATE((Date) CommonUtils
							.getGlobalObject("GLOBAL.M_POL_START_DT"));
				} else if ("2".equals(M_PS_VALUE)) {
					DUMMY_BEAN.setUI_M_APPRV_DATE(new CommonUtils()
							.getCurrentDate());
				}
			}

			COMP_UI_M_APPRV_DATE.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(resultset_C1);
				CommonUtils.closeCursor(resultset_C2);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	public ArrayList<com.iii.premia.common.bean.LovBean> lovM_POL_NO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			// P_CALL_LOV('DUMMY.M_POL_NO' , 'N');
			suggestionList = listitemutil
					.P_CALL_LOV("PILP002_APAC", "DUMMY", "M_POL_NO", "N", null,
							null, null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}

	public String L_VALIDATE_POL_NO() throws ValidatorException {
		ResultSet resultset_c1 = null;
		ResultSet resultset_C2 = null;
		ResultSet resultset_C3 = null;
		String M_POL_SYS_ID = null;
		String M_POL_PROP_NO = null;
		String M_STATUS = null;
		String M_PLAN_CODE = null;
		try {

			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String UI_M_POL_NO = CommonUtils
					.getGlobalVariable("GLOBAL.M_POL_NO");
			String sql_C1 = PILP002_APAC_SQLConstants.sql_C1;
			Object[] sql_C1Object = { UI_M_POL_NO };

			resultset_c1 = handler.executeSelectStatement(sql_C1, connection,
					sql_C1Object);
			if (resultset_c1.next()) {
				DUMMY_BEAN.setUI_M_POL_SYS_ID(resultset_c1.getLong(1));
				M_STATUS = resultset_c1.getString(2);
				DUMMY_BEAN.setUI_M_APPRV_DATE(resultset_c1.getDate(3));
				M_PLAN_CODE = resultset_c1.getString(4);
				DUMMY_BEAN.setUI_M_POL_END_NO_IDX(resultset_c1.getString(5));
				DUMMY_BEAN.setUI_M_POL_PROP_NO(resultset_c1.getString(6));
				DUMMY_BEAN.setUI_M_FC_FIRST_PREM(resultset_c1.getDouble(7));
				DUMMY_BEAN.setUI_M_LC_FIRST_PREM(resultset_c1.getDouble(8));
				DUMMY_BEAN.setUI_M_CUST_EXCH_RATE(resultset_c1.getDouble(9));
				DUMMY_BEAN.setUI_M_POL_ISSUE_DT(resultset_c1.getDate(10));
			} else {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71071"));
			}

			if (!"N".equals(M_STATUS)) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "71073"));
			}
			CommonUtils.setGlobalVariable("GLOBAL.M_PLAN_CODE", M_PLAN_CODE);
			System.out.println("M_PLAN_CODE_global: " + M_PLAN_CODE);
			String sql_C2 = PILP002_APAC_SQLConstants.sql_C2;
			Object[] sql_C2Object = { M_PLAN_CODE };
			resultset_C2 = handler.executeSelectStatement(sql_C2, connection,
					sql_C2Object);
			if (resultset_C2.next()) {
				DUMMY_BEAN.setUI_M_PLAN_TYPE(resultset_C2.getString(1));
			}
			String sql_C3 = PILP002_APAC_SQLConstants.sql_C3;
			Object[] sql_C3Object = { DUMMY_BEAN.getUI_M_POL_PROP_NO() };
			resultset_C3 = handler.executeSelectStatement(sql_C3, connection,
					sql_C3Object);
			if (resultset_C3.next()) {
				DUMMY_BEAN
						.setUI_M_DEP_GROSS_NET_FLAG(resultset_C3.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(resultset_c1);
				CommonUtils.closeCursor(resultset_C2);
				CommonUtils.closeCursor(resultset_C3);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		return null;
	}

	// Base_Curr changes PREMIAGDC-0030 : Added by Shankar Bodduluri : 25/03/09
	/*
	 * private String preForm() { handler = new CRUDHandler(); ResultSet r1 =
	 * null; ResultSet r2 = null;
	 * 
	 * OracleProcedureHandler procHandler = new OracleProcedureHandler();
	 * ArrayList<OracleParameter> list = null; Date UI_M_APPRV_DATE = null;
	 * String UI_M_CUST_CODE = null; CommonUtils commonUtils = new
	 * CommonUtils(); try{ connection = CommonUtils.getConnection(); String
	 * selectParaValueQuery = PILP002_APAC_SQLConstants.selectParaValue;
	 * Object[] objectSelectParaValue = {}; r1 =
	 * handler.executeSelectStatement(selectParaValueQuery, connection,
	 * objectSelectParaValue);
	 * 
	 *//**
		 * Default values set to YES for the following combo-boxes as suggested
		 * by internal testing team Updated by Sourav 50192 - 10/12/08
		 */
	/*
	 * DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y"); DUMMY_BEAN.setUI_M_BROK_GEN_YN("Y");
	 * 
	 * if(r1.next()){ DUMMY_BEAN1.setUI_M_BASE_CURR_CODE(r1.getString(1));
	 * System.out.println("M_BASE_CURR_CODE :"+
	 * DUMMY_BEAN1.getUI_M_BASE_CURR_CODE());
	 * System.out.println("GLOBAL.M_PARAM_3 :"+
	 * CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3")); }
	 * 
	 * String selectPlanType = PILP002_APAC_SQLConstants.selectPlanType;
	 * Object[] objectPlan =
	 * {CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3")}; r2 =
	 * handler.executeSelectStatement(selectPlanType, connection, objectPlan);
	 * if(r2.next()){ DUMMY_BEAN1.setUI_M_PLAN_TYPE(r2.getString(1)); }
	 * 
	 * if(CommonUtils.getGlobalVariable("GLOBAL.M_FAILURE") == null){
	 * CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE"); }
	 * if(CommonUtils.getGlobalVariable("GLOBAL.M_NAME") == null) {
	 * CommonUtils.setGlobalVariable("GLOBAL.M_NAME", "COMPANY
	 * NAME..................PROGRAM NAME"); }
	 * if(CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES") == null) {
	 * CommonUtils.setGlobalVariable("GLOBAL.M_DFLT_VALUES", "00101 01"); }
	 * 
	 * CommonUtils.setGlobalVariable("GLOBAL.M_MODULE_NAME", "PILP002_APAC");
	 * 
	 * 
	 * String UI_M_POL_NO = CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO");
	 * 
	 * System.out.println("UI_M_POL_NO: " + UI_M_POL_NO);
	 * 
	 * STD_PRE_FORM(); // COMP_UI_M_PREM_GEN_YN.setSubmittedValue("Y"); //
	 * COMP_UI_M_BROK_GEN_YN.setSubmittedValue("Y");
	 * 
	 * String fetchPolDetails = PILP002_APAC_SQLConstants.fetchPolDetails;
	 * Object[] fetchPolDetailsObject = {UI_M_POL_NO};
	 * System.out.println("fetchPolDetailsObject: "+ fetchPolDetailsObject);
	 * resultset_Poldtls = handler.executeSelectStatement(fetchPolDetails,
	 * connection, fetchPolDetailsObject); if(resultset_Poldtls.next()) {
	 * UI_M_POL_NO = resultset_Poldtls.getString(1);
	 * System.out.println("resultset_Poldtls.UI_M_POL_NO: "+ UI_M_POL_NO);
	 * 
	 * UI_M_APPRV_DATE = resultset_Poldtls.getDate(2);
	 * System.out.println("resultset_Poldtls.UI_M_APPRV_DATE: " +
	 * UI_M_APPRV_DATE);
	 * 
	 * UI_M_CUST_CODE = resultset_Poldtls.getString(3);
	 * System.out.println("resultset_Poldtls.UI_M_CUST_CODE: "+ UI_M_CUST_CODE); }
	 * Date date = new Date(); DUMMY_BEAN.setUI_M_POL_NO(UI_M_POL_NO); //
	 * DUMMY_BEAN.setUI_M_APPRV_DATE(UI_M_APPRV_DATE); //
	 * DUMMY_BEAN.setUI_M_CUST_CODE(UI_M_CUST_CODE);
	 * DUMMY_BEAN.setUI_M_TRAN_DATE(date);
	 * 
	 * 
	 * 
	 * getCOMP_UI_M_POL_NO().setSubmittedValue(UI_M_POL_NO);
	 * getCOMP_UI_M_APPRV_DATE().setSubmittedValue(UI_M_APPRV_DATE);
	 * getCOMP_UI_M_TRAN_DATE().setSubmittedValue(date);
	 * getCOMP_UI_M_CUST_CODE().setSubmittedValue(UI_M_CUST_CODE);
	 * getCOMP_UI_M_PREM_GEN_YN().setSubmittedValue("Y");
	 * getCOMP_UI_M_BROK_GEN_YN().setSubmittedValue("Y");
	 * getCOMP_UI_M_FC_AMOUNT().setSubmittedValue("0");
	 * getCOMP_UI_M_LC_AMOUNT().setSubmittedValue("0"); //TODO Commneted needs
	 * to remove //getCOMP_UI_M_APPRV_DATE().setDisabled(true); }catch(Exception
	 * e){ e.printStackTrace(); throw new ValidatorException(new
	 * FacesMessage(e.getMessage())); }finally{ try {
	 * CommonUtils.closeCursor(r1); CommonUtils.closeCursor(r2); } catch
	 * (Exception e) { e.printStackTrace(); } } // getSysDate();
	 * //getCOMP_UI_M_BUT_PREFORMBUTTON().setDisabled(true); return null; }
	 */
	private String preForm() {
		handler = new CRUDHandler();
		// ResultSet r1 = null;
		ResultSet r2 = null;

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> list = null;
		Date UI_M_APPRV_DATE = null;
		String UI_M_CUST_CODE = null;
		CommonUtils commonUtils = new CommonUtils();

		// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added

		String P_CURR_CODE = null;
		String P_NAME = null;
		int P_DECIMAL = -1;
		DBProcedures procedures = new DBProcedures();

		try {
			connection = CommonUtils.getConnection();
			ArrayList<String> list1 = procedures.helperF_GET_BASE_CURRENCY(
					CommonUtils.getGlobalVariable("GLOBAL.M_COMP_CODE"), "N",
					P_CURR_CODE, P_NAME, P_DECIMAL + "", "E");
			if (list1 != null && list1.size() > 0) {
				P_CURR_CODE = list1.get(0);
				P_NAME = list1.get(1);
				P_DECIMAL = CommonUtils.parseToInt(list1.get(2));
				DUMMY_BEAN1.setUI_M_BASE_CURR_CODE(P_CURR_CODE);
			}
			// Base_Curr changes PREMIAGDC-0030 helperF_GET_BASE_CURRENCY added
			// Shankar Bodduluri :20-04-2009
			/*
			 * String selectParaValueQuery =
			 * PILP002_APAC_SQLConstants.selectParaValue; Object[]
			 * objectSelectParaValue = {P_CURR_CODE}; r1 =
			 * handler.executeSelectStatement(selectParaValueQuery, connection,
			 * objectSelectParaValue);
			 */

			/**
			 * Default values set to YES for the following combo-boxes as
			 * suggested by internal testing team Updated by Sourav 50192 -
			 * 10/12/08
			 */
			DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
			DUMMY_BEAN.setUI_M_BROK_GEN_YN("Y");

			/*
			 * if(r1.next()){
			 * DUMMY_BEAN1.setUI_M_BASE_CURR_CODE(r1.getString(1));
			 * System.out.println("M_BASE_CURR_CODE :"+
			 * DUMMY_BEAN1.getUI_M_BASE_CURR_CODE());
			 * System.out.println("GLOBAL.M_PARAM_3 :"+
			 * CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_3")); }
			 */

			String selectPlanType = PILP002_APAC_SQLConstants.selectPlanType;
			Object[] objectPlan = { CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_3") };
			r2 = handler.executeSelectStatement(selectPlanType, connection,
					objectPlan);
			if (r2.next()) {
				DUMMY_BEAN1.setUI_M_PLAN_TYPE(r2.getString(1));
			}

			if (CommonUtils.getGlobalVariable("GLOBAL.M_FAILURE") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "FALSE");
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_NAME") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_NAME",
						"COMPANY NAME..................PROGRAM NAME");
			}
			if (CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES") == null) {
				CommonUtils.setGlobalVariable("GLOBAL.M_DFLT_VALUES",
						"00101    01");
			}

			CommonUtils.setGlobalVariable("GLOBAL.M_MODULE_NAME",
					"PILP002_APAC");

			String UI_M_POL_NO = CommonUtils
					.getGlobalVariable("GLOBAL.M_POL_NO");

			STD_PRE_FORM();
			// COMP_UI_M_PREM_GEN_YN.setSubmittedValue("Y");
			// COMP_UI_M_BROK_GEN_YN.setSubmittedValue("Y");

			/*
			 * String fetchPolDetails =
			 * PILP002_APAC_SQLConstants.fetchPolDetails; Object[]
			 * fetchPolDetailsObject = {UI_M_POL_NO};
			 * System.out.println("fetchPolDetailsObject: "+
			 * fetchPolDetailsObject); resultset_Poldtls =
			 * handler.executeSelectStatement(fetchPolDetails, connection,
			 * fetchPolDetailsObject); if(resultset_Poldtls.next()) {
			 * UI_M_POL_NO = resultset_Poldtls.getString(1);
			 * System.out.println("resultset_Poldtls.UI_M_POL_NO: "+
			 * UI_M_POL_NO);
			 * 
			 * UI_M_APPRV_DATE = resultset_Poldtls.getDate(2);
			 * System.out.println("resultset_Poldtls.UI_M_APPRV_DATE: " +
			 * UI_M_APPRV_DATE);
			 * 
			 * UI_M_CUST_CODE = resultset_Poldtls.getString(3);
			 * System.out.println("resultset_Poldtls.UI_M_CUST_CODE: "+
			 * UI_M_CUST_CODE); }
			 */
			Date date = new Date();
			DUMMY_BEAN.setUI_M_POL_NO(UI_M_POL_NO);
			// DUMMY_BEAN.setUI_M_APPRV_DATE(UI_M_APPRV_DATE);
			// DUMMY_BEAN.setUI_M_CUST_CODE(UI_M_CUST_CODE);
			DUMMY_BEAN.setUI_M_TRAN_DATE(date);

			/*
			 * getCOMP_UI_M_POL_NO().setSubmittedValue(UI_M_POL_NO);
			 * getCOMP_UI_M_APPRV_DATE().setSubmittedValue(UI_M_APPRV_DATE);
			 * getCOMP_UI_M_TRAN_DATE().setSubmittedValue(date);
			 * getCOMP_UI_M_CUST_CODE().setSubmittedValue(UI_M_CUST_CODE);
			 * getCOMP_UI_M_PREM_GEN_YN().setSubmittedValue("Y");
			 * getCOMP_UI_M_BROK_GEN_YN().setSubmittedValue("Y");
			 * getCOMP_UI_M_FC_AMOUNT().setSubmittedValue("0");
			 * getCOMP_UI_M_LC_AMOUNT().setSubmittedValue("0");
			 */
			// TODO Commented needs to remove
			// getCOMP_UI_M_APPRV_DATE().setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				// ResultSet r1 not using
				// CommonUtils.closeCursor(r1);
				CommonUtils.closeCursor(r2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// getSysDate();
		// getCOMP_UI_M_BUT_PREFORMBUTTON().setDisabled(true);
		return null;
	}

	public void STD_PRE_FORM() {
		try {
			String CUR_FORM = null;
			String M_FIRST_BLOCK = null;
			String M_MODULE_NAME = null;
			// RECORDGROUP RG_ID;
			double M_QUERY_OK = -1;

			/*
			 * ctrlBean.setM_PARA_1(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1")); //
			 * ctrlBean.setM_PARA_1((String)session.getAttribute("GLOBAL.M_PARA_1"));
			 * ctrlBean.setM_USER_ID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			 */
			getControlBean().setM_PROG_NAME("PILP002_APAC");
			/*
			 * ctrlBean.setM_SCR_NAME(CommonUtils.getGlobalVariable("GLOBAL.M_NAME"));
			 * ctrlBean.setM_LANG_CODE(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			 */
			getControlBean().setM_GOFLD_NAME("NULL");
			/*
			 * ctrlBean.setM_COMP_CODE((CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES")).substring(1,
			 * 3));
			 * ctrlBean.setM_DIVN_CODE((CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES")).substring(4,
			 * 6));
			 * ctrlBean.setM_DEPT_CODE((CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES")).substring(6,
			 * 10));
			 */
			/*
			 * M_TITLE=NAME_IN.NAME_IN("CTRL.M_USER_ID")+"
			 * "+NAME_IN.NAME_IN("CTRL.M_SCR_NAME")+"
			 * "+ConvertFunctions.to_char(new
			 * java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
			 * SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
			 * HIDE_VIEW.HIDE_VIEW("ABOUT");
			 * M_FIRST_BLOCK=GET_FORM_PROPERTY.GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FIRSTBLOCK);
			 * while((true)) {
			 * if(GET_BLOCK_PROPERTY.GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED)=="TRUE") {
			 * if(StringFunctions.substr(NAME_IN.NAME_IN("GLOBAL.M_PRIVILEGE"),1,1)=="Y") {
			 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED,PROPERTY_TRUE); }
			 * else {
			 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED,PROPERTY_FALSE); } }
			 * if(GET_BLOCK_PROPERTY.GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED)=="TRUE") {
			 * if(StringFunctions.substr(NAME_IN.NAME_IN("GLOBAL.M_PRIVILEGE"),2,1)=="Y") {
			 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED,PROPERTY_TRUE); }
			 * else {
			 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED,PROPERTY_FALSE); } }
			 * if(GET_BLOCK_PROPERTY.GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED)=="TRUE") {
			 * if(StringFunctions.substr(NAME_IN.NAME_IN("GLOBAL.M_PRIVILEGE"),3,1)=="Y") {
			 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED,PROPERTY_TRUE); }
			 * else {
			 * SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED,PROPERTY_FALSE); } }
			 * M_FIRST_BLOCK=GET_BLOCK_PROPERTY.GET_BLOCK_PROPERTY(M_FIRST_BLOCK,NEXTBLOCK);
			 * if(M_FIRST_BLOCK == ("DUAL") || M_FIRST_BLOCK == ("CTRL") ||
			 * M_FIRST_BLOCK == ("BUTTON_PALETTE")) { break; } }
			 * RG_ID=FIND_GROUP.FIND_GROUP("RG_HINT");
			 * if(ID_NULL.ID_NULL(RG_ID)) { } else {
			 * M_QUERY_OK=POPULATE_GROUP.POPULATE_GROUP(RG_ID); }
			 * RG_ID=FIND_GROUP.FIND_GROUP("RG_ALERT_MSG");
			 * if(ID_NULL.ID_NULL(RG_ID)) { } else {
			 * M_QUERY_OK=POPULATE_GROUP.POPULATE_GROUP(RG_ID); }
			 * LOAD_BP.LOAD_BP(); ENABLE_BUTTONS.ENABLE_BUTTONS();
			 * if(!M_MODULE_NAME.startsWith("GNMNF001")) {
			 * LOAD_BALOON_LABEL.LOAD_BALOON_LABEL(); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<OracleParameter> prepareOracleParam(HttpSession httpSession) {
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"));
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				getControlBean().getM_COMP_CODE());
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				((CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"))
						.substring(3, 6)).trim());
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				((CommonUtils.getGlobalVariable("GLOBAL.M_DFLT_VALUES"))
						.substring(9, 11)).trim());
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				getControlBean().getM_BASE_CURR());
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN", "2");
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				getControlBean().getM_PROG_NAME());
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);
		paramList.add(param6);
		paramList.add(param7);
		paramList.add(param8);
		paramList.add(param9);
		return paramList;
	}

	/*
	 * public Connection getConnection() { FacesContext fc =
	 * FacesContext.getCurrentInstance(); ServletContext context =
	 * (ServletContext)fc.getExternalContext().getContext();
	 * SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent)
	 * context.getAttribute("connectionAgent"); try { return
	 * connectionAgent.getConnection("12345"); } catch (Exception e) {
	 * e.printStackTrace(); } return connection; }
	 */
	public void pilp002_apac_dummy_m_fc_amount_when_validate_item()
			throws Exception {
		DB_Procedures db_Procedures = new DB_Procedures();
		try {
			connection = CommonUtils.getConnection();
			Double UI_M_FC_AMOUNT = DUMMY_BEAN.getUI_M_FC_AMOUNT();
			if (UI_M_FC_AMOUNT != null) {
				if (UI_M_FC_AMOUNT < 0) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91052"));
				}
				// if(DUMMY_BEAN.getUI_M_FC_AMOUNT()<
				// DUMMY_BEAN.getUI_M_DUMMY_FC_AMOUNT())
				if (UI_M_FC_AMOUNT < DUMMY_BEAN.getUI_M_DUMMY_FC_AMOUNT()) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91122"));
					// DUMMY_BEAN.setUI_M_FC_AMOUNT(DUMMY_BEAN.getUI_M_DUMMY_FC_AMOUNT());

				}
			}

			ArrayList<String> list = db_Procedures
					.callPCOPK_GENERAL_P_VAL_ROUND_AMT(DUMMY_BEAN1
							.getUI_M_CUST_CURR_CODE(), UI_M_FC_AMOUNT + "",
							"R", "ENG", null);
			if (list != null && list.size() > 0) {
				DUMMY_BEAN.setUI_M_FC_AMOUNT(Double.parseDouble(list.get(0)));
			}
			DUMMY_BEAN.setUI_M_LC_AMOUNT(null);
			COMP_UI_M_LC_AMOUNT.resetValue();
			DUMMY_BEAN.setUI_M_LC_AMOUNT(DUMMY_BEAN.getUI_M_FC_AMOUNT()
					* DUMMY_BEAN1.getUI_M_CUST_EXCH_RATE());
			DUMMY_BEAN.setUI_M_LC_AMOUNT(P_VAL_ROUND_AMT(DUMMY_BEAN1
					.getUI_M_BASE_CURR_CODE(), DUMMY_BEAN.getUI_M_LC_AMOUNT(),
					"R"));

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
			// throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void pilp002_apac_dummy_m_lc_amount_when_validate_item(
			DUMMY dummy_bean) throws Exception {
		ResultSet resultSetsql_C1 = null;
		ResultSet resultSetsql_C2 = null;
		try {

			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();

			int M_POL_END_NO_IDX = -1;
			String M_POL_END_TYPE = null;
			String M_PROD_PREM_CALC_MTHD = null;
			String M_POL_PROD_CODE = null;
			Double UI_M_LC_AMOUNT = DUMMY_BEAN.getUI_M_LC_AMOUNT();

			P_VAL_FC_LC_TOLERANCE.callP_VAL_FC_LC_TOLERANCE(DUMMY_BEAN
					.getUI_M_FC_AMOUNT()
					+ "", UI_M_LC_AMOUNT + "", DUMMY_BEAN1
					.getUI_M_CUST_EXCH_RATE()
					+ "", "E");

			String sql_C1 = PILP002_APAC_SQLConstants.UI_M_LC_AMOUNT_WHEN_VALIDATE_SQLC1;
			Object[] objectsql_C1 = { CommonUtils
					.getGlobalVariable("GLOBAL.M_POL_SYS_ID") };
			resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
					connection, objectsql_C1);
			if (resultSetsql_C1.next()) {
				M_POL_END_NO_IDX = resultSetsql_C1.getInt(1);
				M_POL_END_TYPE = resultSetsql_C1.getString(2);
				M_POL_PROD_CODE = resultSetsql_C1.getString(3);
			}

			String sql_C2 = PILP002_APAC_SQLConstants.UI_M_LC_AMOUNT_WHEN_VALIDATE_SQLC2;
			Object[] objectsql_C2 = { M_POL_PROD_CODE };
			resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
					connection, objectsql_C2);

			if (resultSetsql_C2.next()) {
				M_PROD_PREM_CALC_MTHD = resultSetsql_C2.getString(1);
			}

			if ("M".equals(MigratingFunctions.nvl(DUMMY_BEAN
					.getUI_M_PLAN_TYPE(), "0"))
					&& "X".equals(M_PROD_PREM_CALC_MTHD)) {

				ArrayList<String> list = DB_Procedures
						.P9ILPK_CHEQ_VALIDATION_L_GET_FIRST_PREM(
								connection,
								CommonUtils
										.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
								DUMMY_BEAN.getUI_M_DEP_GROSS_NET_FLAG());
				if (list != null && list.size() > 0) {
					DUMMY_BEAN.setUI_M_FC_FIRST_PREM(Double.parseDouble(list
							.get(0)));
					DUMMY_BEAN.setUI_M_LC_FIRST_PREM(Double.parseDouble(list
							.get(1)));

				}
				// L_DISPLAY_ERROR_MESSAGE.L_DISPLAY_ERROR_MESSAGE();
			}
			if ("000".equals(MigratingFunctions.nvl(M_POL_END_TYPE, "000"))
					&& M_POL_END_NO_IDX == 0) {
				DB_Procedures.P9ILPK_CHEQ_VALIDATION_P_INS_DEFAULT_PYMT(
						CommonUtils.getGlobalVariable("GLOBAL.M_POL_SYS_ID"),
						DUMMY_BEAN.getUI_M_LC_FIRST_PREM() + "", UI_M_LC_AMOUNT
								+ "", "D", "PT", DUMMY_BEAN
								.getUI_M_CUST_EXCH_RATE()
								+ "");
				// L_DISPLAY_ERROR_MESSAGE.L_DISPLAY_ERROR_MESSAGE();
			}
		} catch (SQLException se) {
			se.printStackTrace();
			throw se;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSetsql_C1);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			try {
				CommonUtils.closeCursor(resultSetsql_C2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void pilp002_apac_dummy_m_apprv_date_when_validate_item()
			throws ValidatorException {
		ResultSet rssql_C1 = null;
		ResultSet rssql_C2 = null;
		ResultSet rssql_C3 = null;
		ResultSet rssql_C4 = null;
		ResultSet rssql_C16 = null;
		String M_POL_CONT_CODE = null;
		String M_POL_CUST_CODE = null;
		String M_POL_CUST_CURR_CODE = null;
		Double M_POL_CUST_EXCH_RATE = null;
		String M_POL_FC_FIRST_PREM = null;
		String M_POL_LC_FIRST_PREM = null;
		String M_POL_DIVN_CODE = null;
		String M_POL_END_TYPE = null;
		String M_POL_MODE_OF_PYMT = null;
		String M_POL_PLAN_CODE = null;
		Double M_CONT_LC_PROP_DEP_AMT = null;
		Double M_CONT_LC_PROP_UTIL_AMT = null;
		Double M_CONT_LC_POL_DEP_AMT = null;
		Double M_CONT_LC_POL_UTIL_AMT = null;
		String M_IL_TOLL_TYPE = null;
		String M_IL_SHORT_COLL = null;
		Double M_TOTAL_PREMIUM = null;
		Double M_LC_SHORT_COLL = null;
		String M_POL_CASH_YN = null;
		double M_AVLB_BAL_LC_AMT = -1;
		double M_AVLB_BAL_FC_AMT = -1;
		double M_PMOP_SHORT_RATE = -1;
		double M_PMOP_SHORT_RATE_PER = -1;
		String M_CODE_DESC = null;
		String M_CO_VALUE = null;
		String M_NO_MODES = null;
		String M_PMOP_TOLL_TYP = null;
		String M_POL_CUST_DESC = null;

		DB_Procedures db_Procedures = new DB_Procedures();
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {

			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();

			// HttpSession session = (HttpSession)
			// FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			Long M_POL_SYS_ID = DUMMY_BEAN.getUI_M_POL_SYS_ID();
			String sql_C1 = PILP002_APAC_SQLConstants.policyApproveDateQuery1;
			Object[] objectsql_C1 = { M_POL_SYS_ID };
			rssql_C1 = handler.executeSelectStatement(sql_C1, connection,
					objectsql_C1);
			if (DUMMY_BEAN.getUI_M_APPRV_DATE() != null) {
				// L_VALIDATE_APPRV_DATE.L_VALIDATE_APPRV_DATE();
			
				/* Newly Added By Dhinesh on 28-03-2018 */
			    String IL_APRV_EFDT = CommonUtils.getPPSystemParameterValue("IL_APRV_EFDT").toString();
				System.out.println("IL_APRV_EFDT    : "+IL_APRV_EFDT);
				if("1".equalsIgnoreCase(IL_APRV_EFDT))
				{
					L_VALIDATE_APPRV_DATE();
			    }
				/*End*/
				
				
				if (rssql_C1.next()) {
					M_POL_CUST_CODE = rssql_C1.getString(1);
					M_POL_CONT_CODE = rssql_C1.getString(2);
					M_POL_CUST_CURR_CODE = rssql_C1.getString(3);
					M_POL_CUST_EXCH_RATE = rssql_C1.getDouble(4);
					M_POL_FC_FIRST_PREM = rssql_C1.getString(5);
					M_POL_LC_FIRST_PREM = rssql_C1.getString(6);
					M_POL_CASH_YN = rssql_C1.getString(7);
					M_POL_DIVN_CODE = rssql_C1.getString(8);
					M_POL_END_TYPE = rssql_C1.getString(9);
					M_POL_MODE_OF_PYMT = rssql_C1.getString(10);
					M_POL_PLAN_CODE = rssql_C1.getString(11);
				}
				String sql_C2 = PILP002_APAC_SQLConstants.policyApproveDateQuery2;
				Object[] objectsql_C2 = { M_POL_CONT_CODE };
				rssql_C2 = handler.executeSelectStatement(sql_C2, connection,
						objectsql_C2);

				if (rssql_C2.next()) {
					M_CONT_LC_PROP_DEP_AMT = rssql_C2.getDouble(1);
					M_CONT_LC_PROP_UTIL_AMT = rssql_C2.getDouble(2);
					M_CONT_LC_POL_DEP_AMT = rssql_C2.getDouble(3);
					M_CONT_LC_POL_UTIL_AMT = rssql_C2.getDouble(4);
				}
				M_AVLB_BAL_LC_AMT = CommonUtils.nvl(M_CONT_LC_PROP_DEP_AMT, 0)
						- CommonUtils.nvl(M_CONT_LC_PROP_UTIL_AMT, 0);
				M_AVLB_BAL_LC_AMT = P_VAL_ROUND_AMT(DUMMY_BEAN1
						.getUI_M_BASE_CURR_CODE(), M_AVLB_BAL_LC_AMT, "R");

				if (CommonUtils.nvl(M_AVLB_BAL_LC_AMT, 0) == 0) {
					// M_AVLB_BAL_LC_AMT =
					// MigratingFunctions.nvl(M_CONT_LC_POL_DEP_AMT,0) -
					// MigratingFunctions.nvl(M_CONT_LC_POL_UTIL_AMT,0);
					// code modified By Praveen for PREMIAGDC-278143
					M_AVLB_BAL_LC_AMT = (CommonUtils.nvl(
							M_CONT_LC_PROP_DEP_AMT, 0) - CommonUtils.nvl(
							M_CONT_LC_PROP_UTIL_AMT, 0))
							+ (CommonUtils.nvl(M_CONT_LC_POL_DEP_AMT, 0) - CommonUtils
									.nvl(M_CONT_LC_POL_UTIL_AMT, 0));

				}
				M_AVLB_BAL_FC_AMT = M_AVLB_BAL_LC_AMT / M_POL_CUST_EXCH_RATE;
				M_AVLB_BAL_FC_AMT = P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE,
						M_AVLB_BAL_FC_AMT, "R");
				if ("CO".equals(DUMMY_BEAN.getUI_M_PROCESS_TYPE())) {
					ArrayList list = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
							"MODESPRMYN", DUMMY_BEAN.getUI_M_PROCESS_TYPE(),
							"E");
					M_CODE_DESC = list.get(0).toString();
					M_CO_VALUE = list.get(1).toString();

					if ("1".equals(M_CO_VALUE)) {
						ArrayList list1 = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
								"CONUMMODES", M_POL_MODE_OF_PYMT, "E");
						M_CODE_DESC = list1.get(0).toString();
						M_NO_MODES = list1.get(1).toString();
						if (CommonUtils.nvl(Double.parseDouble(M_NO_MODES), 0) > 0) {
							M_TOTAL_PREMIUM = Double.parseDouble(M_NO_MODES)
									* Double.parseDouble(M_POL_LC_FIRST_PREM);
							P_VAL_ROUND_AMT(DUMMY_BEAN1
									.getUI_M_BASE_CURR_CODE(), M_TOTAL_PREMIUM,
									"R");
							String sql_C4 = PILP002_APAC_SQLConstants.policyApproveDateQuery4;
							Object[] objectsql_C4 = {};
							rssql_C4 = handler.executeSelectStatement(sql_C4,
									connection, objectsql_C4);
							if (rssql_C4.next()) {
								M_IL_TOLL_TYPE = rssql_C4.getString(1);
							}
							String sql_C3 = PILP002_APAC_SQLConstants.policyApproveDateQuery3;
							Object[] objectsql_C3 = { M_POL_PLAN_CODE,
									M_POL_MODE_OF_PYMT };
							rssql_C3 = handler.executeSelectStatement(sql_C3,
									connection, objectsql_C3);
							if (rssql_C3.next()) {
								M_IL_SHORT_COLL = rssql_C3.getString(1);
							}
							if (CommonUtils.nvl(Double
									.parseDouble(M_IL_TOLL_TYPE), 0) == 1) {
								M_LC_SHORT_COLL = CommonUtils.nvl(
										M_TOTAL_PREMIUM, 0)
										* CommonUtils.nvl(Double
												.parseDouble(M_IL_SHORT_COLL),
												0) / 100;
							} else {
								M_LC_SHORT_COLL = CommonUtils.nvl(Double
										.parseDouble(M_IL_SHORT_COLL), 0)
										* Double.parseDouble(M_NO_MODES);
							}
							String sql_C16 = PILP002_APAC_SQLConstants.policyApproveDateQuery16;
							Object[] objectsql_C16 = { M_POL_PLAN_CODE,
									M_POL_MODE_OF_PYMT };
							rssql_C16 = handler.executeSelectStatement(sql_C16,
									connection, objectsql_C16);
							if (rssql_C16.next()) {
								M_PMOP_SHORT_RATE = rssql_C16.getDouble(1);
								M_PMOP_SHORT_RATE_PER = rssql_C16.getDouble(2);
								M_PMOP_TOLL_TYP = rssql_C16.getString(3);
							}
							if ("P".equals(M_PMOP_TOLL_TYP)) {
								M_LC_SHORT_COLL = (CommonUtils.nvl(
										M_TOTAL_PREMIUM, 0) * (CommonUtils.nvl(
										M_PMOP_SHORT_RATE, 0) / CommonUtils
										.nvl(M_PMOP_SHORT_RATE_PER, 0)));
							} else {
								M_LC_SHORT_COLL = CommonUtils.nvl(
										M_PMOP_SHORT_RATE, 0);
							}
							P_VAL_ROUND_AMT(DUMMY_BEAN1
									.getUI_M_BASE_CURR_CODE(), M_LC_SHORT_COLL,
									"R");
							if (M_TOTAL_PREMIUM > M_AVLB_BAL_LC_AMT
									+ M_LC_SHORT_COLL) {

								throw new Exception(
										"Deposit not enough to meet the premium");

							}
						}
					}
				}
				if ("000".equals(M_POL_END_TYPE)) {/*
													 * if
													 * (MigratingFunctions.nvl(Double
													 * .parseDouble(M_POL_FC_FIRST_PREM),
													 * 0) >= M_AVLB_BAL_FC_AMT &&
													 * M_AVLB_BAL_FC_AMT >= 0) {
													 * DUMMY_BEAN.setUI_M_FC_AMOUNT(0.0);
													 * DUMMY_BEAN.setUI_M_AVLB_BAL_LC_AMT(M_AVLB_BAL_LC_AMT);
													 * DUMMY_BEAN.setUI_M_AVLB_BAL_FC_AMT(M_AVLB_BAL_FC_AMT); }
													 * else {
													 * DUMMY_BEAN.setUI_M_FC_AMOUNT(0.0);
													 * DUMMY_BEAN.setUI_M_AVLB_BAL_LC_AMT(M_AVLB_BAL_LC_AMT);
													 * DUMMY_BEAN.setUI_M_AVLB_BAL_FC_AMT(M_AVLB_BAL_FC_AMT); }
													 *  // ArrayList<String>
													 * list_amt = //
													 * P_VAL_ROUND_AMT.callP9GLPK_GENERAL_P_VAL_ROUND_AMT(connection, //
													 * M_POL_CUST_CURR_CODE,
													 * DUMMY_BEAN.getUI_M_FC_AMOUNT(), //
													 * "R", "ENG", null);
													 * ArrayList<String>
													 * list_amt = db_Procedures
													 * .callPCOPK_GENERAL_P_VAL_ROUND_AMT(
													 * M_POL_CUST_CURR_CODE,
													 * DUMMY_BEAN
													 * .getUI_M_FC_AMOUNT().toString(),
													 * "R", "ENG", null);
													 * 
													 * Integer tempvalue=0; if
													 * (list_amt != null &&
													 * list_amt.size() > 0) {
													 * 
													 * tempvalue=Integer.parseInt(list_amt.get(0));
													 * if(tempvalue>0){
													 * DUMMY_BEAN.setUI_M_FC_AMOUNT(CommonUtils
													 * .parseToDouble(list_amt.get(0))); } }
													 * if(tempvalue>0){
													 * DUMMY_BEAN.setUI_M_LC_AMOUNT(DUMMY_BEAN.getUI_M_FC_AMOUNT()
													 * M_POL_CUST_EXCH_RATE);
													 * 
													 * DUMMY_BEAN.setUI_M_LC_AMOUNT(P_VAL_ROUND_AMT(DUMMY_BEAN1
													 * .getUI_M_BASE_CURR_CODE(),
													 * DUMMY_BEAN
													 * .getUI_M_LC_AMOUNT(),
													 * "R"));
													 * DUMMY_BEAN.setUI_M_DUMMY_FC_AMOUNT(DUMMY_BEAN
													 * .getUI_M_FC_AMOUNT());
													 * DUMMY_BEAN.setUI_M_DUMMY_LC_AMOUNT(DUMMY_BEAN
													 * .getUI_M_LC_AMOUNT()); }
													 */
				}
				DUMMY_BEAN1.setUI_M_CUST_CURR_CODE(M_POL_CUST_CURR_CODE);
				DUMMY_BEAN1.setUI_M_CUST_EXCH_RATE(M_POL_CUST_EXCH_RATE);
				DUMMY_BEAN.setUI_M_CUST_CODE(M_POL_CUST_CODE);
				DUMMY_BEAN.setUI_M_POL_DIVN_CODE(M_POL_DIVN_CODE);
				DUMMY_BEAN.setUI_M_POL_CASH_YN(M_POL_CASH_YN);

				if ("N".equals(M_POL_CASH_YN)) {
					// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CUST_CODE",ENABLED,PROPERTY_FALSE);
					getCOMP_UI_M_CUST_CODE().setDisabled(true);
					ArrayList<String> list_amt1 = pkg_pilt002_apac
							.P_VAL_CLASS_CUST("CUSTOMER", DUMMY_BEAN
									.getUI_M_CUST_CODE(), M_POL_CUST_DESC, "N",
									"N", DUMMY_BEAN.getUI_M_POL_DIVN_CODE());
					if (list_amt1 != null && list_amt1.size() > 0) {
						M_POL_CUST_DESC = list_amt1.get(0);
					}
					// SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_CUST_CODE",ENABLED,PROPERTY_FALSE);
				} else {
					// COMP_UI_M_CUST_CODE.setDisabled(false); [ Commented by
					// Vinoj to fix Issue P11JLIFEQC-1677077 ]
					COMP_UI_M_CUST_CODE.setReadonly(false);
					ArrayList<String> list_amt = pkg_pilt002_apac
							.P_VAL_CLASS_CUST("CASH", DUMMY_BEAN
									.getUI_M_CUST_CODE(), M_POL_CUST_DESC, "N",
									"N", DUMMY_BEAN.getUI_M_POL_DIVN_CODE());
					if (list_amt != null && list_amt.size() > 0) {
						M_POL_CUST_DESC = list_amt.get(0);
					}
				}
				if ("000".equals(M_POL_END_TYPE)) {
					COMP_UI_M_FC_AMOUNT.setDisabled(false);
					COMP_UI_M_FC_AMOUNT.setReadonly(false);
					COMP_UI_M_LC_AMOUNT.setDisabled(false);
					COMP_UI_M_LC_AMOUNT.setReadonly(false);
					COMP_UI_M_PREM_GEN_YN.setDisabled(false);
					COMP_UI_M_PREM_GEN_YN.setReadonly(false);
					COMP_UI_M_BROK_GEN_YN.setDisabled(false);
					COMP_UI_M_BROK_GEN_YN.setReadonly(false);

				} else {
					COMP_UI_M_FC_AMOUNT.setDisabled(true);
					COMP_UI_M_LC_AMOUNT.setDisabled(true);
					DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
					COMP_UI_M_PREM_GEN_YN.setDisabled(true);
					COMP_UI_M_BROK_GEN_YN.setDisabled(true);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rssql_C1);
				CommonUtils.closeCursor(rssql_C2);
				CommonUtils.closeCursor(rssql_C3);
				CommonUtils.closeCursor(rssql_C16);

			} catch (Exception e) {
				e.printStackTrace();
				// throw new ValidatorException(new
				// FacesMessage(e.getMessage()));
			}
		}
	}

	public void pilp002_apac_dummy_m_cust_code_when_validate_item()
			throws ValidatorException {
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {
			if (getCOMP_UI_M_CUST_CODE().getSubmittedValue() != null
					&& "Y".equals(DUMMY_BEAN.getUI_M_POL_CASH_YN())) {
				ArrayList<String> list = pkg_pilt002_apac.P_VAL_CLASS_CUST(
						"CASH", DUMMY_BEAN.getUI_M_CUST_CODE(), DUMMY_BEAN
								.getUI_M_POL_CUST_DESC(), "N", "E", DUMMY_BEAN
								.getUI_M_POL_DIVN_CODE());
				if (list != null && list.size() > 0) {
					DUMMY_BEAN.setUI_M_POL_CUST_DESC(list.get(0));
				}
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public String gotoPaymentAction() {
		String returnString = null;
		Long M_POL_SYS_ID = (Long) CommonUtils
				.getGlobalObject("GLOBAL.M_POL_SYS_ID");
		CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PD");
		CommonUtils.setGlobalObject("GLOBAL.TXN_SYS_ID", M_POL_SYS_ID);

		returnString = "backFromPaymentScreentoPILP002_APAC";
		PT_IL_PYMT_DTLS_ACTION paymentDetailAction = new PT_IL_PYMT_DTLS_ACTION(
				returnString, null, true);
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILP002_APAC");
		return paymentDetailAction.gotoPaymentDetails();
		// return "PT_IL_PYMT_DTLS";
	}

	/*
	 * When Pymt Dtls button is clicked
	 */
	/*
	 * public String gotoPaymentAction() {
	 * compositeAction.getPILP002_APAC_PT_IL_PYMT_DTLS_ACTION().setINSERT_ALLOWED(
	 * false);
	 * compositeAction.getPILP002_APAC_PT_IL_PYMT_DTLS_ACTION().setUPDATE_ALLOWED(
	 * false);
	 * compositeAction.getPILP002_APAC_PT_IL_PYMT_DTLS_ACTION().setDELETE_ALLOWED(
	 * false); return "PT_IL_PYMT_DTLS"; }
	 */

	/*
	 * When Ok Button Pressed
	 */
	/*
	 * public String pilp002_apac_dummy_m_but_ok_when_button_pressed() { // TODO
	 * hardCoding FC & LC amt // Commenting HardCoded UI_M_FC_AMOUNT and
	 * UI_M_LC_AMOUNT
	 *  // DUMMY_BEAN.setUI_M_FC_AMOUNT(100.0); //
	 * DUMMY_BEAN.setUI_M_LC_AMOUNT(100.0);
	 * 
	 * DBProcedures procedures = new DBProcedures(); handler = new
	 * CRUDHandler(); DB_Procedures dbProcedures = new DB_Procedures(); String
	 * M_PLAN_TYPE = null; String M_CSVSD_PARA_CODE_DESC = null; String
	 * M_POL_PROD_CODE = null; String M_CODE_DESC = null; String M_PS_VALUE =
	 * null; String M_APPR_TXN_DT = null; String M_POL_STD_RISK_YN = null;
	 * String M_POFD_FUND_CODE = null; double M_PRICE_EXISTS = 0; java.sql.Date
	 * M_DATE = null; java.sql.Date M_POL_END_DATE = null; String M_BUF_PS_DESC =
	 * null; String M_BUF_PS_VALUE = null; String M_BCD_COMM_RATE = null; String
	 * M_POBH_AGENT_RANK_CODE = null; String M_POBH_AGENT_LEVEL = null; String
	 * M_POBH_BROKER_CODE = null; String M_POBH_COMM_CODE = null; String
	 * M_PERIOD = null; String M_REP_CODE = null; String M_REP_VALUE = null;
	 * String M_POAD_REF_ID1 = null; String M_POAD_REF_ID2 = null; String
	 * M_NO_MONTH = null; String M_REP_COUNT = null; String M_MON_DESC = null;
	 * String M_REP_DESC = null; String M_END_CODE = null; double M_POL_COUNT =
	 * -1; double M_ANS = -1; String M_POL_CLASS_CODE = null; String
	 * M_CUST_BLACK_LIST_COUNT = null; String M_POL_MED_FEE_RECOVER_YN = null;
	 * String M_MED_PAID = null; String M_MFD_CLINIC_CODE = null; String
	 * M_MFD_EXAM_CODE = null; String M_POL_ORG_LC_SUM_ASSURED = null;
	 * java.sql.Date M_POL_NL_FM_DT = null; String M_CALC_METHOD = null; String
	 * M_FC_AMAN_INST_PREM = null; String M_FC_SENABEL_INST_PREM = null; String
	 * M_LC_AMAN_INST_PREM = null; String M_LC_SENABEL_INST_PREM = null; String
	 * M_POL_BASIC_RATE = null; int M_POL_END_NO_IDX = 0; String M_POL_END_TYPE =
	 * null; Date M_POL_FIRST_INST_DT = null; String M_POL_END_CODE = null;
	 * String M_SMV_ENDT_YN = "N"; String M_SUM = null; String M_TEMP = null;
	 * Date M_SCH_DT = null; String M_ASD_CHAR_VALUE = null; String
	 * M_ASD_NUM_VALUE = null; String M_POL_LC_SUM_ASSURED = null; String
	 * M_DP_AMT = null; String M_OTHER_AMT = null; int M_POL_PERIOD = 0; Date
	 * M_POL_EXPIRY_DT = null; String M_POL_MODE_OF_PYMT = null; String
	 * M_POL_LAST_INST_DT = null; String M_POL_PREM_PAY_YRS = null; double M_SUB =
	 * -1; String M_POL_FC_BASIC_PREM = null; String M_POL_LC_BASIC_PREM = null;
	 * String M_PDL_FC_DISC_LOAD_VALUE = null; String M_PDL_LC_DISC_LOAD_VALUE =
	 * null; String M_POL_CONT_CODE = null; String M_CONT_PREFERRED_LANG = null;
	 * String M_PC_DESC = null; String M_PC_BL_DESC = null; String M_REP_NAME =
	 * null; String M_DSRC_SYS_ID = null; String M_PS_CODE_DESC = null; String
	 * M_DR_REPORT_CODE = null; String M_POL_DS_CODE = null; String M_APPROVED =
	 * "N"; double M_DIFF_AMT = -1; String M_PROD_COOLOFF_DAYS = null; String
	 * M_PROD_PREM_CALC_MTHD = null; String M_PROD_MATU_DT = null; int
	 * M_POL_END_NO_IDX_1 = -1; String M_POL_PROD_CODE_1 = null; String
	 * M_POL_END_CODE_1 = null; String M_EAS_END_APPR_YN = null; String
	 * M_PROD_DRIP_MTHD = null; Date M_POL_TRAN_DT = null; String M_POL_DS_TYPE1 =
	 * null; String M_POL_DS_CODE1 = null; String M_DS_POST_BO = null; // String
	 * M_POL_CONT_CODE=null;
	 * 
	 * String M_POL_END_TYPE=null; java.sql.Date M_POL_FIRST_INST_DT=null;
	 * 
	 *  // session.setAttribute("GLOBAL.M_SITE", "key");
	 * CommonUtils.setGlobalVariable("GLOBAL.M_SITE", "key");
	 * 
	 * ResultSet resultSetsql_C1 = null; ResultSet resultSetsql_C2 = null;
	 * ResultSet resultSetsql_C16 = null; ResultSet resultSetsql_C3 = null;
	 * ResultSet resultSetsql_C4 = null; ResultSet resultSetsql_C5 = null;
	 * ResultSet resultSetsql_C6 = null; ResultSet resultSetsql_C7 = null;
	 * ResultSet resultSetsql_C8 = null; ResultSet resultSetsql_C9 = null;
	 * ResultSet resultSetsql_C10 = null; ResultSet resultSetsql_C11 = null;
	 * ResultSet resultSetsql_C12 = null; ResultSet resultSetsql_C13 = null;
	 * ResultSet resultSetsql_C14 = null; ResultSet resultSetsql_C15 = null;
	 * ResultSet resultSetsql_C17 = null; ResultSet resultSetsql_C18 = null;
	 * ResultSet resultSetsql_C19 = null; ResultSet resultSetsql_C20 = null;
	 * ResultSet resultSetsql_C21 = null; ResultSet resultSetsql_C22 = null;
	 * ResultSet resultSetsql_C23 = null; ResultSet resultSetsql_C24 = null;
	 * ResultSet resultSetsql_C25 = null; ResultSet resultSetsql_C26 = null;
	 * ResultSet resultSetsql_C27 = null; ResultSet resultSetsql_C28 = null;
	 * ResultSet resultSetsql_C29 = null; ResultSet resultSetsql_C30 = null;
	 * ResultSet resultSetsql_C35 = null; ResultSet resultSetsql_C36 = null;
	 * ResultSet resultSetsql_C38 = null; ResultSet resultSetsql_C37 = null;
	 * ResultSet resultSetsql_C39 = null; ResultSet resultSetsql_C40 = null;
	 * 
	 * int update1; int update2; int update3; int update4; int update5; int
	 * update6; int update7; int update8; int update9; int update10; int
	 * update11; int update12; int update13; int update14; int update15; int
	 * update16; int update17; int update18; int update19; int update20; int
	 * update21; int update22;
	 * 
	 * FacesMessage msg = null; String returnValue = null; String M_POL_SYS_ID =
	 * CommonUtils .getGlobalVariable("GLOBAL.M_POL_SYS_ID"); // [Bug id
	 * -PREMIAGDC-000158 : assigning last instalment date: Shankar // bodduluri
	 * Dated: 18-Mar-2009 ] CommonUtils commonUtils1 = new CommonUtils();
	 * PILT002_APAC_COMPOSITE_ACTION compositeAction1 =
	 * (PILT002_APAC_COMPOSITE_ACTION) commonUtils1
	 * .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION"); Date date =
	 * compositeAction1.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().getPOL_LAST_INST_DT(); String rowId =
	 * compositeAction1.getPT_IL_POLICY_ACTION_BEAN()
	 * .getPT_IL_POLICY_BEAN().getROWID(); try {
	 * 
	 * connection = CommonUtils.getConnection();
	 * 
	 * getErrorMap().clear(); getWarningMap().clear(); String sql_C41 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY41; Object[]
	 * objectsql_C18 = { M_POL_SYS_ID }; resultSetsql_C18 =
	 * handler.executeSelectStatement(sql_C41, connection, objectsql_C41);
	 * 
	 * if (resultSetsql_C41.next()) { M_POL_PROD_CODE =
	 * resultSetsql_C18.getString(1); M_POL_NL_FM_DT =
	 * resultSetsql_C18.getDate(2); M_POL_END_DATE =
	 * resultSetsql_C18.getDate(3); M_POL_TRAN_DT = resultSetsql_C18.getDate(4); }
	 * 
	 * 
	 * 
	 * String sql_C18 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY18; Object[]
	 * objectsql_C18 = { M_POL_SYS_ID }; resultSetsql_C18 =
	 * handler.executeSelectStatement(sql_C18, connection, objectsql_C18);
	 * 
	 * if (resultSetsql_C18.next()) { M_POL_PROD_CODE =
	 * resultSetsql_C18.getString(1); M_POL_NL_FM_DT =
	 * resultSetsql_C18.getDate(2); M_POL_END_DATE =
	 * resultSetsql_C18.getDate(3); M_POL_TRAN_DT = resultSetsql_C18.getDate(4); }
	 * 
	 * String sql_C39 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY39; Object[]
	 * objectsql_C39 = { M_POL_PROD_CODE }; resultSetsql_C39 =
	 * handler.executeSelectStatement(sql_C39, connection, objectsql_C39);
	 * 
	 * if (resultSetsql_C39.next()) { M_PROD_DRIP_MTHD =
	 * resultSetsql_C39.getString(1); }
	 * 
	 * String sql_C38 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY38; Object[]
	 * objectsql_C38 = { M_POL_SYS_ID }; resultSetsql_C38 =
	 * handler.executeSelectStatement(sql_C38, connection, objectsql_C38);
	 * 
	 * if (resultSetsql_C38.next()) { M_POL_DS_TYPE1 =
	 * resultSetsql_C38.getString(1); M_POL_DS_CODE1 =
	 * resultSetsql_C38.getString(2); }
	 * 
	 * String sql_C37 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY37; Object[]
	 * objectsql_C37 = { M_POL_DS_TYPE1, M_POL_DS_CODE1 }; resultSetsql_C37 =
	 * handler.executeSelectStatement(sql_C37, connection, objectsql_C37);
	 * 
	 * if (resultSetsql_C37.next()) { M_DS_POST_BO =
	 * resultSetsql_C37.getString(1); }
	 * 
	 * String sql_C28 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY28; Object[]
	 * objectsql_C28 = { M_POL_SYS_ID }; resultSetsql_C28 =
	 * handler.executeSelectStatement(sql_C28, connection, objectsql_C28);
	 * 
	 * if (resultSetsql_C28.next()) { M_PERIOD = resultSetsql_C28.getString(1);
	 * M_POL_END_NO_IDX_1 = resultSetsql_C28.getInt(2); M_POL_PROD_CODE_1 =
	 * resultSetsql_C28.getString(3); M_POL_END_CODE_1 =
	 * resultSetsql_C28.getString(4); M_POL_MED_FEE_RECOVER_YN =
	 * resultSetsql_C28.getString(5); }
	 * 
	 * String sql_C16 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY16; Object[]
	 * objectsql_C16 = { M_POL_SYS_ID };
	 * 
	 * String sql_C3 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY3; Object[]
	 * objectsql_C3 = { M_POL_SYS_ID }; resultSetsql_C3 =
	 * handler.executeSelectStatement(sql_C3, connection, objectsql_C3);
	 * 
	 * 
	 * String sql_C4=PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY4;
	 * Object[] objectsql_C4 =
	 * {M_POL_END_TYPE,M_POL_FIRST_INST_DT,DUMMY_BEAN.getUI_M_APPRV_DATE()};
	 * resultSetsql_C4 = handler.executeSelectStatement(sql_C4, connection,
	 * objectsql_C4);
	 * 
	 * 
	 * 
	 * String
	 * sql_C20=PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY20;
	 * Object[] objectsql_C20 = {M_POFD_FUND_CODE,M_DATE}; resultSetsql_C20 =
	 * handler.executeSelectStatement(sql_C20, connection, objectsql_C20);
	 * 
	 * 
	 * if re-underwriting is required
	 * 
	 * if ("Y".equals(DUMMY_BEAN.getUI_M_RE_UW_REQ_YN())) { CommonUtils
	 * commonUtils = new CommonUtils(); PILT002_APAC_COMPOSITE_ACTION
	 * compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
	 * .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
	 * 
	 * if (DUMMY_BEAN.getUI_M_RE_UW_REQ_REASON() == null) { throw new
	 * ValidatorException(Messages.getMessage( PELConstants.pelErrorMessagePath,
	 * "91991")); }
	 * 
	 * DB_Procedures.P9ILPK_POLICY_P_INS_UPD_RUW_STS(M_POL_SYS_ID,
	 * M_POL_END_NO_IDX + "", DUMMY_BEAN .getUI_M_RE_UW_REQ_REASON(),
	 * CommonUtils .dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE())); //
	 * <!--[ BugId:PREMIAGDC-000048 Shankar Bodduluri 25-Feb-09 If //
	 * UI_M_RE_UW_REQ_YN is Y and if error is '91989'[refer //
	 * PELErrorMessages.properties] need to enable Status button and // Modified
	 * error code 91994 in PELErrorMessages.properties-->
	 * 
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN()
	 * .getCOMP_UI_M_BUT_HOLD().setDisabled(false);
	 * CommonUtils.setGlobalObject("PILT002_APAC_COMPOSITE_ACTION",
	 * compositeAction); // [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009
	 * -Replaced // validator with warning map
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap() .put(
	 * PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91989").getSummary());
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap() .put(
	 * PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91989").getSummary()); //
	 * PREMIAGDC-317794 -VijayAnand.V - 30-07-2009]
	 *  } else {
	 * 
	 * Finish for re-underwriting is required
	 * 
	 * 
	 * if (MigratingFunctions.nvl(M_POL_END_NO_IDX_1, 0) > 0) { String sql_C35 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY35; Object[]
	 * objectsql_C35 = { getControlBean().getM_USER_ID(), M_POL_PROD_CODE_1,
	 * M_POL_END_CODE_1 }; resultSetsql_C35 =
	 * handler.executeSelectStatement(sql_C35, connection, objectsql_C35);
	 * 
	 * if (resultSetsql_C35.next()) { M_EAS_END_APPR_YN =
	 * resultSetsql_C35.getString(1); }
	 * 
	 * if ("N".equals(MigratingFunctions.nvl(M_EAS_END_APPR_YN, "N"))) { throw
	 * new ValidatorException(Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91565")); } }
	 * CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", "PT"); //
	 * session.setAttribute("GLOBAL.TXN_TYPE", "PT"); // :GLOBAL.TXN_TYPE="PT"; //
	 * COPY.COPY("P","CTRL.M_COMM_DEL"); //
	 * COPY.COPY("20","SYSTEM.MESSAGE_LEVEL");
	 *  // Need to know why calling this procedure PR_FETCH_DPD_REF_ID
	 * procedures.callPR_FETCH_DPD_REF_ID(MigratingFunctions.nvl(
	 * DUMMY_BEAN.getUI_M_POL_SYS_ID(), 0) + "",
	 * CommonUtils.getGlobalVariable("GLOBAL.TXN_TYPE"),
	 * MigratingFunctions.nvl(DUMMY_BEAN.getUI_M_POL_SYS_ID(), 0) + "",
	 * MigratingFunctions.nvl(DUMMY_BEAN .getUI_M_FC_AMOUNT(), 0) + "",
	 * MigratingFunctions.nvl(DUMMY_BEAN .getUI_M_LC_AMOUNT(), 0) + "");
	 * 
	 * 
	 * handler.executeInsertStatement(PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_INSERT_QUERY23,
	 * connection, new
	 * Object[]{CommonUtils.getGlobalVariable("GLOBAL.TXN_TYPE"),
	 * DUMMY_BEAN.getUI_M_POL_SYS_ID()+"",
	 * CommonUtils.getGlobalVariable("GLOBAL.M_CUST_CURR_CODE"),
	 * DUMMY_BEAN.getUI_M_FC_AMOUNT(), DUMMY_BEAN.getUI_M_LC_AMOUNT(),
	 * ctrlBean.getM_USER_ID(), refId});
	 * 
	 *  // POST.POST(); // COPY.COPY("0","SYSTEM.MESSAGE_LEVEL"); //
	 * COPY.COPY("","CTRL.M_COMM_DEL"); if
	 * (MigratingFunctions.nvl(DUMMY_BEAN.getUI_M_FC_AMOUNT(), 0) >= 0) { String
	 * sql_C1 = PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY1;
	 * Object[] objectsql_C1 = { M_POL_SYS_ID }; resultSetsql_C1 =
	 * handler.executeSelectStatement(sql_C1, connection, objectsql_C1);
	 * 
	 * if (resultSetsql_C1.next()) { M_TEMP = resultSetsql_C1.getString(1); }
	 * else { throw new ValidatorException(Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91171")); } }
	 * CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", "Y");
	 * 
	 * String sql_C8 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY8; Object[]
	 * objectsql_C8 = {}; resultSetsql_C8 =
	 * handler.executeSelectStatement(sql_C8, connection, objectsql_C8);
	 * 
	 * if (resultSetsql_C8.next()) { M_CALC_METHOD =
	 * resultSetsql_C8.getString(1); }
	 * 
	 * String sql_C7 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY7; Object[]
	 * objectsql_C7 = { M_POL_SYS_ID }; resultSetsql_C7 =
	 * handler.executeSelectStatement(sql_C7, connection, objectsql_C7);
	 * 
	 * if (resultSetsql_C7.next()) { M_POL_LC_SUM_ASSURED =
	 * resultSetsql_C7.getString(1); M_POL_STD_RISK_YN =
	 * resultSetsql_C7.getString(2); M_POL_ORG_LC_SUM_ASSURED =
	 * resultSetsql_C7.getString(3); }
	 * 
	 * ArrayList<String> list = dbProcedures .callP_VAL_SYSTEM("IL_B21_MON",
	 * "IL_B21_MON", M_MON_DESC, "E", M_NO_MONTH); if (list != null &&
	 * list.size() > 0) { M_MON_DESC = list.get(0); M_NO_MONTH = list.get(1); }
	 * 
	 * ArrayList<String> list1 = dbProcedures.callP_VAL_SYSTEM( "IL_REPL_POL",
	 * "IL_REPL_POL", M_REP_DESC, "E", M_REP_COUNT); if (list1 != null &&
	 * list1.size() > 0) { M_REP_DESC = list1.get(0); M_REP_COUNT =
	 * list1.get(1); }
	 * 
	 * String sql_C24 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY24; Object[]
	 * objectsql_C24 = {}; resultSetsql_C24 =
	 * handler.executeSelectStatement(sql_C24, connection, objectsql_C24);
	 * 
	 * if (resultSetsql_C24.next()) { M_REP_CODE =
	 * resultSetsql_C24.getString(1); }
	 * 
	 * String sql_C25 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY25; Object[]
	 * objectsql_C25 = {}; resultSetsql_C25 =
	 * handler.executeSelectStatement(sql_C25, connection, objectsql_C25);
	 * 
	 * if (resultSetsql_C25.next()) { M_END_CODE =
	 * resultSetsql_C25.getString(1); }
	 * 
	 * String sql_C22 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY22; Object[]
	 * objectsql_C22 = { M_POL_SYS_ID }; resultSetsql_C22 =
	 * handler.executeSelectStatement(sql_C22, connection, objectsql_C22);
	 * 
	 * if (resultSetsql_C22.next()) { M_POBH_BROKER_CODE =
	 * resultSetsql_C22.getString(1); M_POBH_AGENT_RANK_CODE =
	 * resultSetsql_C22.getString(2); M_POBH_AGENT_LEVEL =
	 * resultSetsql_C22.getString(3); M_POBH_COMM_CODE =
	 * resultSetsql_C22.getString(4); }
	 * 
	 * resultSetsql_C28 = handler.executeSelectStatement(sql_C28, connection,
	 * objectsql_C28); if (resultSetsql_C28.next()) { M_PERIOD =
	 * resultSetsql_C28.getString(1); M_POL_END_NO_IDX_1 =
	 * resultSetsql_C28.getInt(2); M_POL_PROD_CODE_1 =
	 * resultSetsql_C28.getString(3); M_POL_END_CODE_1 =
	 * resultSetsql_C28.getString(4); M_POL_MED_FEE_RECOVER_YN =
	 * resultSetsql_C28.getString(5); }
	 * 
	 * String sql_C23 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY23; Object[]
	 * objectsql_C23 = { M_POBH_COMM_CODE, M_POBH_AGENT_LEVEL,
	 * M_POBH_AGENT_RANK_CODE, M_PERIOD }; resultSetsql_C23 =
	 * handler.executeSelectStatement(sql_C23, connection, objectsql_C23);
	 * 
	 * if (resultSetsql_C23.next()) { M_BCD_COMM_RATE =
	 * resultSetsql_C23.getString(1); }
	 * 
	 * String sql_C26 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY26; Object[]
	 * objectsql_C26 = { M_POL_SYS_ID }; resultSetsql_C26 =
	 * handler.executeSelectStatement(sql_C26, connection, objectsql_C26);
	 * 
	 * if (resultSetsql_C26.next()) { M_POAD_REF_ID1 =
	 * resultSetsql_C26.getString(1); M_POAD_REF_ID2 =
	 * resultSetsql_C26.getString(2); }
	 * 
	 * String sql_C27 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY27; Object[]
	 * objectsql_C27 = { M_POAD_REF_ID1, M_POAD_REF_ID2,
	 * DUMMY_BEAN.getUI_M_POL_ISSUE_DT(), M_NO_MONTH, M_POAD_REF_ID1,
	 * M_POAD_REF_ID2, M_END_CODE, DUMMY_BEAN.getUI_M_POL_ISSUE_DT(),
	 * M_NO_MONTH, M_POAD_REF_ID1, M_POAD_REF_ID2,
	 * DUMMY_BEAN.getUI_M_POL_ISSUE_DT(), M_NO_MONTH, M_POAD_REF_ID1,
	 * M_POAD_REF_ID2, DUMMY_BEAN.getUI_M_POL_ISSUE_DT(), M_NO_MONTH,
	 * M_POAD_REF_ID1, M_POAD_REF_ID2, DUMMY_BEAN.getUI_M_POL_ISSUE_DT(),
	 * M_NO_MONTH }; resultSetsql_C27 = handler.executeSelectStatement(sql_C27,
	 * connection, objectsql_C27); if (resultSetsql_C27.next()) { M_POL_COUNT =
	 * resultSetsql_C27.getDouble(1); }
	 * 
	 * resultSetsql_C18 = handler.executeSelectStatement(sql_C18, connection,
	 * objectsql_C18); if (resultSetsql_C18.next()) { M_POL_PROD_CODE =
	 * resultSetsql_C18.getString(1); M_POL_NL_FM_DT =
	 * resultSetsql_C18.getDate(2); M_POL_END_DATE =
	 * resultSetsql_C18.getDate(3); M_POL_TRAN_DT = resultSetsql_C18.getDate(4); }
	 * 
	 * if (MigratingFunctions.nvl(M_POL_END_NO_IDX_1, 0) == 0) { String sql_C5 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY5; Object[]
	 * objectsql_C5 = { getControlBean().getM_USER_ID(), M_POL_STD_RISK_YN,
	 * M_POL_PROD_CODE }; resultSetsql_C5 =
	 * handler.executeSelectStatement(sql_C5, connection, objectsql_C5);
	 * 
	 * if (resultSetsql_C5.next()) { M_ASD_CHAR_VALUE =
	 * resultSetsql_C5.getString(1); }
	 * 
	 * if ("N".equals(MigratingFunctions .nvl(M_ASD_CHAR_VALUE, "N"))) {
	 * 
	 * throw new ValidatorException(Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "71182")); } else { String sql_C6 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY6; Object[]
	 * objectsql_C6 = { getControlBean().getM_USER_ID(), M_POL_STD_RISK_YN,
	 * M_POL_PROD_CODE }; resultSetsql_C6 = handler.executeSelectStatement(
	 * sql_C6, connection, objectsql_C6);
	 * 
	 * if (resultSetsql_C6.next()) { M_ASD_NUM_VALUE =
	 * resultSetsql_C6.getString(1); }
	 * 
	 * if (Double.parseDouble(MigratingFunctions.nvl( M_POL_LC_SUM_ASSURED,
	 * "0")) > Double .parseDouble(MigratingFunctions.nvl( M_ASD_NUM_VALUE,
	 * "0"))) { throw new ValidatorException(Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "80329")); } } } else if
	 * (MigratingFunctions.nvl(M_POL_END_NO_IDX_1, 0) > 0) {
	 * 
	 * String sql_C40 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY40; Object[]
	 * objectsql_C40 = { getControlBean().getM_USER_ID(), M_POL_PROD_CODE_1,
	 * M_POL_END_CODE_1, M_POL_PROD_CODE_1, getControlBean().getM_USER_ID(),
	 * M_POL_STD_RISK_YN }; resultSetsql_C40 =
	 * handler.executeSelectStatement(sql_C40, connection, objectsql_C40); if
	 * (resultSetsql_C40.next()) { M_ASD_NUM_VALUE =
	 * resultSetsql_C40.getString(1); }
	 * 
	 * if (Double.parseDouble(MigratingFunctions.nvl( M_POL_LC_SUM_ASSURED,
	 * "0")) + Double.parseDouble(MigratingFunctions.nvl(
	 * M_POL_ORG_LC_SUM_ASSURED, "0")) > Double
	 * .parseDouble(MigratingFunctions.nvl( M_ASD_NUM_VALUE, "0"))) { throw new
	 * ValidatorException(Messages.getMessage( PELConstants.pelErrorMessagePath,
	 * "80329")); } }
	 * 
	 * CommonUtils.setGlobalVariable("GLOBAL.M_CUST_CODE", DUMMY_BEAN
	 * .getUI_M_CUST_CODE()); // session.setAttribute("GLOBAL.M_CUST_CODE", //
	 * DUMMY_BEAN.getUI_M_CUST_CODE()); //
	 * :GLOBAL.M_CUST_CODE=:DUMMY.M_CUST_CODE;
	 * 
	 * String sql_C1 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY1; Object[]
	 * objectsql_C1 = { M_POL_SYS_ID }; resultSetsql_C1 =
	 * handler.executeSelectStatement(sql_C1, connection, objectsql_C1);
	 * 
	 * if (resultSetsql_C1.next()) { M_TEMP = resultSetsql_C1.getString(1); }
	 * 
	 * if (M_TEMP != null) {
	 * 
	 * resultSetsql_C16 = handler.executeSelectStatement(sql_C16, connection,
	 * objectsql_C16); if (resultSetsql_C16.next()) { M_DP_AMT =
	 * resultSetsql_C16.getString(1); }
	 * 
	 * String sql_C2 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY2; Object[]
	 * objectsql_C2 = { M_POL_SYS_ID }; resultSetsql_C2 =
	 * handler.executeSelectStatement(sql_C2, connection, objectsql_C2);
	 * 
	 * if (resultSetsql_C2.next()) { M_OTHER_AMT = resultSetsql_C2.getString(1); }
	 * 
	 * if (Double.parseDouble(MigratingFunctions .nvl(M_DP_AMT, "0")) == 0 &&
	 * Double.parseDouble(MigratingFunctions.nvl( M_OTHER_AMT, "0")) == 0) { //
	 * [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 // -Replaced validator with
	 * errorMap] getErrorMap().put( PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * Messages.getMessage( PELConstants.pelErrorMessagePath,
	 * "91171").getSummary()); getErrorMap().put(
	 * PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91171").getSummary()); return ""; //
	 * PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 -Replaced // validator with
	 * errorMap] } else if (Double.parseDouble(MigratingFunctions.nvl( M_DP_AMT,
	 * "0")) == 0 && Double.parseDouble(MigratingFunctions.nvl( M_OTHER_AMT,
	 * "0")) > 0) {
	 * 
	 * if (java.lang.Math.abs(MigratingFunctions.nvl(
	 * DUMMY_BEAN.getUI_M_FC_AMOUNT(), 0)) > Double
	 * .parseDouble(MigratingFunctions.nvl( M_OTHER_AMT, "0"))) { //
	 * [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 // -Replaced validator with
	 * errorMap] getErrorMap().put( PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * Messages.getMessage( PELConstants.pelErrorMessagePath,
	 * "91043").getSummary()); getErrorMap().put(
	 * PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91043").getSummary()); return ""; //
	 * PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 // -Replaced validator with
	 * errorMap] } } else if (Double.parseDouble(MigratingFunctions.nvl(
	 * M_DP_AMT, "0")) > 0 && Double.parseDouble(MigratingFunctions.nvl(
	 * M_OTHER_AMT, "0")) == 0) {
	 * 
	 * if (java.lang.Math.abs(MigratingFunctions.nvl(
	 * DUMMY_BEAN.getUI_M_FC_AMOUNT(), 0)) > Double
	 * .parseDouble(MigratingFunctions.nvl(M_DP_AMT, "0"))) { //
	 * [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 // -Replaced validaotor with
	 * errorMap] getErrorMap().put( PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * Messages.getMessage( PELConstants.pelErrorMessagePath,
	 * "91043").getSummary()); getErrorMap().put(
	 * PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91043").getSummary()); return ""; //
	 * PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 // -Replaced validaotor with
	 * errorMap] } } else if (Double.parseDouble(MigratingFunctions.nvl(
	 * M_DP_AMT, "0")) > 0 && Double.parseDouble(MigratingFunctions.nvl(
	 * M_OTHER_AMT, "0")) > 0) {
	 * 
	 * if (java.lang.Math.abs(MigratingFunctions.nvl(
	 * DUMMY_BEAN.getUI_M_FC_AMOUNT(), 0)) > (Double
	 * .parseDouble(MigratingFunctions.nvl(M_DP_AMT, "0")) + Double
	 * .parseDouble(MigratingFunctions.nvl( M_OTHER_AMT, "0")))) { //
	 * [PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 // -Replaced validaotor with
	 * errorMap] getErrorMap().put( PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * Messages.getMessage( PELConstants.pelErrorMessagePath,
	 * "91043").getSummary()); getErrorMap().put(
	 * PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "91043").getSummary()); return ""; //
	 * PREMIAGDC-317794 -VijayAnand.V - 30-07-2009 // -Replaced validaotor with
	 * errorMap] } } }
	 * 
	 * if (resultSetsql_C3.next()) {
	 * 
	 * M_POL_BASIC_RATE = resultSetsql_C3.getString(1); M_FC_AMAN_INST_PREM =
	 * resultSetsql_C3.getString(2); M_FC_SENABEL_INST_PREM =
	 * resultSetsql_C3.getString(3); M_LC_AMAN_INST_PREM =
	 * resultSetsql_C3.getString(4); M_LC_SENABEL_INST_PREM =
	 * resultSetsql_C3.getString(5); M_POL_END_NO_IDX =
	 * resultSetsql_C3.getInt(6); M_POL_END_TYPE = resultSetsql_C3.getString(7);
	 * M_POL_FIRST_INST_DT = resultSetsql_C3.getDate(8); M_POL_PERIOD =
	 * resultSetsql_C3.getInt(9); M_POL_MODE_OF_PYMT =
	 * resultSetsql_C3.getString(10); M_POL_PREM_PAY_YRS =
	 * resultSetsql_C3.getString(11); M_POL_END_CODE =
	 * resultSetsql_C3.getString(12); M_POL_DS_CODE =
	 * resultSetsql_C3.getString(13); M_POL_CLASS_CODE =
	 * resultSetsql_C3.getString(14); }
	 * 
	 * if (DUMMY_BEAN.getUI_M_POL_NO() != null) {
	 * 
	 * CommonUtils.setGlobalVariable("GLOBAL.M_SUCCESS", "TRUE"); //
	 * session.setAttribute("GLOBAL.M_SUCCESS", "TRUE"); //
	 * :GLOBAL.M_SUCCESS="TRUE"; // try{ // DUMMY1 dummy1 = new DUMMY1();
	 * 
	 * if ("S".equals(DUMMY_BEAN1.getUI_M_PLAN_TYPE())) {
	 * 
	 * DUMMY_BEAN1.setUI_M_AMAN_SHARE((Integer .parseInt(MigratingFunctions.nvl(
	 * M_FC_AMAN_INST_PREM, "0")) / (Integer .parseInt(MigratingFunctions.nvl(
	 * M_FC_SENABEL_INST_PREM, "0")) + Integer .parseInt(MigratingFunctions.nvl(
	 * M_FC_AMAN_INST_PREM, "0"))))); DUMMY_BEAN1.setUI_M_SENABEL_SHARE(Integer
	 * .parseInt(MigratingFunctions.nvl( M_FC_SENABEL_INST_PREM, "0")) /
	 * (Integer.parseInt(MigratingFunctions.nvl( M_FC_SENABEL_INST_PREM, "0")) +
	 * Integer .parseInt(MigratingFunctions.nvl( M_FC_AMAN_INST_PREM, "0"))));
	 *  } else if ("A".equals(DUMMY_BEAN1.getUI_M_PLAN_TYPE())) {
	 * 
	 * DUMMY_BEAN1.setUI_M_AMAN_SHARE(1); DUMMY_BEAN1.setUI_M_SENABEL_SHARE(0); }
	 * 
	 * if (DUMMY_BEAN1.getUI_M_PLAN_TYPE() != ("A") &&
	 * DUMMY_BEAN1.getUI_M_PLAN_TYPE() != ("S") &&
	 * Integer.parseInt(MigratingFunctions.nvl( M_CALC_METHOD, "1")) == 2) {
	 * 
	 * if (Double.parseDouble(MigratingFunctions.nvl( M_POL_BASIC_RATE, "0")) ==
	 * 0) {
	 * 
	 * throw new ValidatorException(Messages.getMessage(
	 * PELConstants.pelErrorMessagePath, "71038")); } }
	 * 
	 * if ("000".equals(M_POL_END_TYPE)) {
	 * 
	 * M_SCH_DT = M_POL_FIRST_INST_DT; } else { M_SCH_DT =
	 * DUMMY_BEAN.getUI_M_APPRV_DATE(); }
	 * 
	 * if ("1".equals(M_CALC_METHOD) && "000".equals(M_POL_END_TYPE)) {
	 * 
	 * String sql_C9 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY9; Object[]
	 * objectsql_C9 = { M_POL_SYS_ID }; resultSetsql_C9 =
	 * handler.executeSelectStatement( sql_C9, connection, objectsql_C9);
	 * 
	 * if (resultSetsql_C9.next()) {
	 * 
	 * M_POL_FC_BASIC_PREM = resultSetsql_C9.getString(1); M_POL_LC_BASIC_PREM =
	 * resultSetsql_C9.getString(2); }
	 * 
	 * String sql_C10 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY10; Object[]
	 * objectsql_C10 = { M_POL_SYS_ID }; resultSetsql_C10 =
	 * handler.executeSelectStatement( sql_C10, connection, objectsql_C10);
	 * 
	 * if (resultSetsql_C10.next()) {
	 * 
	 * M_PDL_FC_DISC_LOAD_VALUE = resultSetsql_C10 .getString(1);
	 * M_PDL_LC_DISC_LOAD_VALUE = resultSetsql_C10 .getString(2); }
	 * 
	 * String sql_update1 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY1; Object[]
	 * objectsql_update1 = { DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_EXPIRY_DT,
	 * DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_LAST_INST_DT,
	 * DUMMY_BEAN.getUI_M_TRAN_DATE(), getControlBean().getM_USER_ID(),
	 * M_POL_SYS_ID }; update1 = handler.executeUpdateStatement(sql_update1,
	 * connection, objectsql_update1);
	 * 
	 * if (M_POL_COUNT >= Double.parseDouble(M_REP_COUNT) &&
	 * Double.parseDouble(MigratingFunctions.nvl( M_BCD_COMM_RATE, "0")) == 0) {
	 * 
	 * if (M_POL_CLASS_CODE != "2" && DUMMY_BEAN1.getUI_M_PLAN_TYPE() != "M") {
	 * 
	 * String sql_update2 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY2; Object[]
	 * objectsql_update2 = { M_REP_CODE, M_POL_SYS_ID }; update2 =
	 * handler.executeUpdateStatement( sql_update2, connection,
	 * objectsql_update2);
	 * 
	 * String sql_C29 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY29; Object[]
	 * objectsql_C29 = { M_POBH_BROKER_CODE }; resultSetsql_C29 = handler
	 * .executeSelectStatement(sql_C29, connection, objectsql_C29);
	 * 
	 * if (resultSetsql_C29.next()) {
	 * 
	 * M_CUST_BLACK_LIST_COUNT = resultSetsql_C29 .getString(1); }
	 * 
	 * String sql_update3 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY3; Object[]
	 * objectsql_update3 = { M_CUST_BLACK_LIST_COUNT, M_POBH_BROKER_CODE };
	 * update3 = handler.executeUpdateStatement( sql_update3, connection,
	 * objectsql_update3); } else {
	 * 
	 * String sql_update4 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY4; Object[]
	 * objectsql_update4 = { M_POL_SYS_ID }; update4 =
	 * handler.executeUpdateStatement( sql_update4, connection,
	 * objectsql_update4); } } else {
	 * 
	 * String sql_update5 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY5; Object[]
	 * objectsql_update5 = { M_POL_SYS_ID }; update5 =
	 * handler.executeUpdateStatement( sql_update5, connection,
	 * objectsql_update5); }
	 * 
	 * String sql_update6 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY6; Object[]
	 * objectsql_update6 = { DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_EXPIRY_DT,
	 * M_POL_SYS_ID }; update6 = handler.executeUpdateStatement(sql_update6,
	 * connection, objectsql_update6);
	 * 
	 * String sql_update7 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY7; Object[]
	 * objectsql_update7 = { DUMMY_BEAN.getUI_M_APPRV_DATE(),
	 * DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_SYS_ID }; update7 =
	 * handler.executeUpdateStatement(sql_update7, connection,
	 * objectsql_update7);
	 * 
	 * dbProcedures.callP9ILPK_POL_APPROVAL_P_POLICY_APPROVAL( M_POL_SYS_ID,
	 * DUMMY_BEAN.getUI_M_BROK_GEN_YN(), DUMMY_BEAN.getUI_M_PREM_GEN_YN(),
	 * CommonUtils .dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE()),
	 * CommonUtils.dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE()),
	 * MigratingFunctions.nvl(DUMMY_BEAN .getUI_M_FC_AMOUNT(), 0) + "",
	 * MigratingFunctions.nvl(DUMMY_BEAN .getUI_M_LC_AMOUNT(), 0) + "",
	 * MigratingFunctions.nvl(DUMMY_BEAN .getUI_M_AVLB_BAL_FC_AMT(), 0) + "",
	 * MigratingFunctions.nvl(DUMMY_BEAN .getUI_M_AVLB_BAL_LC_AMT(), 0) + ""); //
	 * p9ilpk_pol_approval.p9ilpk_pol_approval.p_policy_approval(:DUMMY.M_POL_SYS_ID,:DUMMY.M_BROK_GEN_YN,:DUMMY.M_PREM_GEN_YN,:DUMMY.M_APPRV_DATE,:DUMMY.M_APPRV_DATE,:DUMMY.M_FC_AMOUNT,:DUMMY.M_LC_AMOUNT,:DUMMY.M_AVLB_BAL_FC_AMT,:DUMMY.M_AVLB_BAL_LC_AMT);
	 * M_APPROVED = "Y"; CommonUtils.setGlobalVariable("GLOBAL.M_TRAN_DATE",
	 * CommonUtils.dateToStringFormatter(DUMMY_BEAN .getUI_M_TRAN_DATE())); //
	 * :GLOBAL.M_TRAN_DATE=:DUMMY.M_TRAN_DATE; } else {
	 * 
	 * if ("U".equals(M_PLAN_TYPE)) {
	 * 
	 * ArrayList<String> listP = dbProcedures .callP_VAL_SYSTEM("IL_UPUR_DATE",
	 * "IL_UPUR_DATE", M_CODE_DESC, "E", M_APPR_TXN_DT); if (listP != null &&
	 * listP.size() > 0) { M_CODE_DESC = listP.get(0); M_APPR_TXN_DT =
	 * listP.get(1); } //
	 * P_VAL_SYSTEM.P_VAL_SYSTEM("IL_UPUR_DATE","IL_UPUR_DATE",M_CODE_DESC,"E",M_APPR_TXN_DT);
	 * if ("1".equals(M_APPR_TXN_DT)) { M_DATE = (java.sql.Date) DUMMY_BEAN
	 * .getUI_M_APPRV_DATE(); } else if ("2".equals(M_APPR_TXN_DT)) { M_DATE =
	 * (java.sql.Date) DUMMY_BEAN .getUI_M_TRAN_DATE(); }
	 * 
	 * ArrayList<String> list_1 = dbProcedures
	 * .callP_VAL_SYSTEM("IL_APPR_RTYN", "IL_APPR_RTYN", M_CODE_DESC, "E",
	 * M_PS_VALUE); if (list_1 != null && list_1.size() > 0) { M_CODE_DESC =
	 * list_1.get(0); M_PS_VALUE = list_1.get(1); }
	 *  //
	 * P_VAL_SYSTEM.P_VAL_SYSTEM("IL_APPR_RTYN","IL_APPR_RTYN",M_CODE_DESC,"E",M_PS_VALUE);
	 * if ("1".equals(M_PS_VALUE)) { while ((true)) { resultSetsql_C18 = handler
	 * .executeSelectStatement(sql_C18, connection, objectsql_C18); if
	 * (resultSetsql_C18.next()) { M_POFD_FUND_CODE = resultSetsql_C18
	 * .getString(1); M_POL_NL_FM_DT = resultSetsql_C18 .getDate(2);
	 * M_POL_END_DATE = resultSetsql_C18 .getDate(3); M_POL_TRAN_DT =
	 * resultSetsql_C18 .getDate(4); } if (!resultSetsql_C18.next()) break;
	 * String sql_C19 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY19; Object[]
	 * objectsql_C19 = { M_POL_SYS_ID }; resultSetsql_C19 = handler
	 * .executeSelectStatement(sql_C19, connection, objectsql_C19); if
	 * (resultSetsql_C19.next()) { M_PRICE_EXISTS = resultSetsql_C19
	 * .getDouble(1); }
	 * 
	 * if (M_PRICE_EXISTS == 0) { throw new ValidatorException( Messages
	 * .getMessage( PELConstants.pelErrorMessagePath, "91424")); } else {
	 * M_PRICE_EXISTS = 0; } } } }
	 * 
	 * if ("000".equals(M_POL_END_TYPE)) { M_SCH_DT = M_POL_FIRST_INST_DT; }
	 * else { M_SCH_DT = DUMMY_BEAN.getUI_M_APPRV_DATE(); } // <!--[
	 * BugId:PREMIAGDC-000048 Shankar Bodduluri // 25-Feb-09 While calling
	 * procedure , UI_M_FC_AMOUNT // and UI_M_LC_AMOUNT is going null --> Double
	 * fcAmount = DUMMY_BEAN.getUI_M_FC_AMOUNT() == null ? 0.0 :
	 * DUMMY_BEAN.getUI_M_FC_AMOUNT(); Double lcAmount =
	 * DUMMY_BEAN.getUI_M_LC_AMOUNT() == null ? 0.0 :
	 * DUMMY_BEAN.getUI_M_LC_AMOUNT(); dbProcedures
	 * .callP9ILPK_POL_APPROVAL_P_POLICY_APPROVAL( M_POL_SYS_ID,
	 * DUMMY_BEAN.getUI_M_BROK_GEN_YN(), DUMMY_BEAN.getUI_M_PREM_GEN_YN(),
	 * CommonUtils .dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE()),
	 * CommonUtils .dateToStringFormatter(M_SCH_DT), fcAmount + "", lcAmount +
	 * "", (DUMMY_BEAN.getUI_M_AVLB_BAL_FC_AMT() == null) ? "0" : DUMMY_BEAN
	 * .getUI_M_AVLB_BAL_FC_AMT() + "", (DUMMY_BEAN.getUI_M_AVLB_BAL_LC_AMT() ==
	 * null) ? "0" : DUMMY_BEAN .getUI_M_AVLB_BAL_LC_AMT() + ""); //
	 * p9ilpk_pol_approval.p9ilpk_pol_approval.p_policy_approval(:DUMMY.M_POL_SYS_ID,:DUMMY.M_BROK_GEN_YN,:DUMMY.M_PREM_GEN_YN,:DUMMY.M_APPRV_DATE,M_SCH_DT,:DUMMY.M_FC_AMOUNT,:DUMMY.M_LC_AMOUNT,:DUMMY.M_AVLB_BAL_FC_AMT,:DUMMY.M_AVLB_BAL_LC_AMT);
	 * M_APPROVED = "Y"; } if ("Y".equals(M_APPROVED)) { if
	 * (Double.parseDouble(MigratingFunctions.nvl( M_OTHER_AMT, "0")) == 0) {
	 * M_DIFF_AMT = MigratingFunctions.nvl(DUMMY_BEAN
	 * .getUI_M_AVLB_BAL_FC_AMT(), 0) - Double.parseDouble(MigratingFunctions
	 * .nvl(M_DP_AMT, "0")); } else { M_DIFF_AMT =
	 * MigratingFunctions.nvl(DUMMY_BEAN .getUI_M_AVLB_BAL_FC_AMT(), 0) -
	 * Double.parseDouble(MigratingFunctions .nvl(M_OTHER_AMT, "0")); } if
	 * (M_DIFF_AMT >= 0) {
	 * 
	 * procedures .callP9ILPK_CHEQ_VALIDATION_INS_DEP_PYMT_DTLS( M_POL_SYS_ID,
	 * CommonUtils .getGlobalVariable("GLOBAL.TXN_TYPE"));
	 * 
	 * procedures .callP9ILPK_DEP_APPROVAL_UPD_CONT_DEPOSIT( M_POL_CONT_CODE,
	 * M_DIFF_AMT + "", CommonUtils .getGlobalVariable("GLOBAL.TXN_TYPE")); } }
	 * 
	 * String sql_C21 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY21; Object[]
	 * objectsql_C21 = { M_POL_PROD_CODE }; resultSetsql_C21 =
	 * handler.executeSelectStatement(sql_C21, connection, objectsql_C21); if
	 * (resultSetsql_C21.next()) { M_PROD_COOLOFF_DAYS =
	 * resultSetsql_C21.getString(1); M_PROD_PREM_CALC_MTHD =
	 * resultSetsql_C21.getString(2); }
	 * 
	 * if ("1".equals(M_CALC_METHOD)) { if
	 * ("002".equals(MigratingFunctions.nvl(M_POL_END_TYPE, "000")) &&
	 * "X".equals(MigratingFunctions.nvl( M_PROD_PREM_CALC_MTHD, "T"))) { String
	 * sql_C15 = PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY15;
	 * Object[] objectsql_C15 = {}; resultSetsql_C15 =
	 * handler.executeSelectStatement( sql_C15, connection, objectsql_C15); if
	 * (resultSetsql_C15.next()) { M_PS_CODE_DESC =
	 * resultSetsql_C15.getString(1); }
	 * 
	 * if ("M".equals(MigratingFunctions.nvl(DUMMY_BEAN1 .getUI_M_PLAN_TYPE(),
	 * "N")) && MigratingFunctions.nvl(M_PS_CODE_DESC, "000") ==
	 * MigratingFunctions.nvl( M_POL_END_CODE, "000")) { procedures
	 * .callP9ILPK_POL_APPROVAL_POL_RED_SUM_COVER_ENDORSE( M_POL_SYS_ID,
	 * CommonUtils .dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE())); } } }
	 * if (M_POL_END_NO_IDX == 0 || "002".equals(M_POL_END_TYPE) ||
	 * "007".equals(M_POL_END_TYPE) || "009".equals(M_POL_END_TYPE) ||
	 * "010".equals(M_POL_END_TYPE) || "006".equals(M_POL_END_TYPE) ||
	 * "012".equals(M_POL_END_TYPE) || "013".equals(M_POL_END_TYPE) ||
	 * "Y".equals(M_SMV_ENDT_YN)) {
	 * CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",
	 * DUMMY_BEAN.getUI_M_POL_NO());
	 * CommonUtils.setGlobalVariable("GLOBAL.M_APPRV_DATE",
	 * CommonUtils.dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE()));
	 * CommonUtils.setGlobalVariable("GLOBAL.M_SUCCESS", "TRUE");
	 * CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", "T");
	 * CommonUtils.setGlobalVariable("GLOBAL.M_PREM_GEN_YN",
	 * DUMMY_BEAN.getUI_M_PREM_GEN_YN());
	 * CommonUtils.setGlobalVariable("GLOBAL.M_BROK_GEN_YN",
	 * DUMMY_BEAN.getUI_M_BROK_GEN_YN());
	 * 
	 * ResultSet rs = handler .executeSelectStatement(
	 * PILP002_APAC_SQLConstants.M_TRANSACTION_DATE_WHEN_VAL_QUERY, connection,
	 * new Object[] { DUMMY_BEAN .getUI_M_POL_SYS_ID() }); if (rs.next()) {
	 * DUMMY_BEAN.setUI_M_CUST_CODE(rs.getString(1)); }
	 * 
	 * ArrayList<String> valueList1 = procedures
	 * .callP9ILPK_PREM_COLL_P_APPROVE_PREM_COLL(
	 * DUMMY_BEAN.getUI_M_POL_SYS_ID() + "", DUMMY_BEAN.getUI_M_PREM_GEN_YN(),
	 * DUMMY_BEAN.getUI_M_BROK_GEN_YN(), CommonUtils
	 * .dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE()), CommonUtils
	 * .dateToStringFormatter(DUMMY_BEAN .getUI_M_TRAN_DATE()), "P",
	 * DUMMY_BEAN.getUI_M_CUST_CODE(), "PILP002_APAC", null);
	 * 
	 * if (valueList1 != null && valueList1.size() > 0) {
	 * CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", valueList1.get(0)); }
	 * 
	 * if ("009".equals(M_POL_END_TYPE)) { CommonUtils.setGlobalVariable(
	 * "GLOBAL.M_PREM_GEN_YN", "Y"); CommonUtils.setGlobalVariable(
	 * "GLOBAL.M_BROK_GEN_YN", "Y"); }
	 * CommonUtils.setGlobalVariable("GLOBAL.M_TRAN_DATE",
	 * CommonUtils.dateToStringFormatter(DUMMY_BEAN .getUI_M_TRAN_DATE())); //
	 * session.setAttribute("GLOBAL.M_TRAN_DATE", //
	 * DUMMY_BEAN.getUI_M_TRAN_DATE()); //
	 * :GLOBAL.M_TRAN_DATE=:DUMMY.M_TRAN_DATE; //
	 * CALL_FORM.CALL_FORM("PILP003_APAC",NO_HIDE,NO_REPLACE); }
	 *  } catch(SQLException se){ se.printStackTrace();
	 * L_RESTORE_DEFAULT.L_RESTORE_DEFAULT();
	 * L_DISPLAY_ERROR_MESSAGE.L_DISPLAY_ERROR_MESSAGE();
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
	 * throw new FORM_TRIGGER_FAILURE(); }
	 * 
	 * if ("Y".equals(CommonUtils .getGlobalVariable("GLOBAL.M_SUCC"))) { if
	 * ("000".equals(M_POL_END_TYPE)) { if ("2".equals(M_CALC_METHOD)) { //
	 * P9ILPK_POLICY.PASS_JOURNAL_PROP_DEPOSIT(:DUMMY.M_POL_SYS_ID,:DUMMY.M_APPRV_DATE);
	 * dbProcedures .callP9ILPK_POLICY_PASS_JOURNAL_PROP_DEPOSIT( M_POL_SYS_ID,
	 * CommonUtils .dateToStringFormatter(DUMMY_BEAN .getUI_M_APPRV_DATE())); }
	 * if ("1".equals(M_CALC_METHOD)) { String sql_C30 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY30; Object[]
	 * objectsql_C30 = { M_POL_PROD_CODE }; resultSetsql_C30 = handler
	 * .executeSelectStatement(sql_C30, connection, objectsql_C30); if
	 * (resultSetsql_C30.next()) { M_PROD_MATU_DT = resultSetsql_C30
	 * .getString(1); }
	 * 
	 * Calendar cl = Calendar.getInstance();
	 * cl.setTime(DUMMY_BEAN.getUI_M_APPRV_DATE()); cl.add(Calendar.MONTH,
	 * M_POL_PERIOD * 12);
	 * 
	 * if ("O".equals(M_PROD_MATU_DT)) { cl.add(Calendar.DAY_OF_MONTH, -1);
	 * M_POL_EXPIRY_DT = cl.getTime(); } else { M_POL_EXPIRY_DT = cl.getTime(); }
	 * if ("Y".equals(M_POL_MODE_OF_PYMT)) { M_SUB = -12; } else if
	 * ("H".equals(M_POL_MODE_OF_PYMT)) { M_SUB = -6; } else if
	 * ("Q".equals(M_POL_MODE_OF_PYMT)) { M_SUB = -3; } else if
	 * ("M".equals(M_POL_MODE_OF_PYMT)) { M_SUB = -1; } else { M_SUB = -1; } //
	 * M_POL_LAST_INST_DT=DateFunctions.add_months(DateFunctions.add_months(DUMMY_BEAN.getUI_M_APPRV_DATE(),Integer.parseInt(M_POL_PREM_PAY_YRS)*12),M_SUB);
	 * 
	 * String sql_update8 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY8; Object[]
	 * objectsql_update8 = { DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_EXPIRY_DT,
	 * DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_LAST_INST_DT,
	 * getControlBean().getM_USER_ID(), M_POL_SYS_ID }; update8 =
	 * handler.executeUpdateStatement( sql_update8, connection,
	 * objectsql_update8);
	 * 
	 * String sql_update9 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY9; Object[]
	 * objectsql_update9 = { DUMMY_BEAN.getUI_M_APPRV_DATE(), M_POL_EXPIRY_DT,
	 * M_POL_SYS_ID }; update9 = handler.executeUpdateStatement( sql_update9,
	 * connection, objectsql_update9);
	 * 
	 * if (M_POL_COUNT >= Double .parseDouble(M_REP_COUNT) && Double
	 * .parseDouble(MigratingFunctions .nvl(M_BCD_COMM_RATE, "0")) == 0) { if
	 * (M_POL_CLASS_CODE != "2" && DUMMY_BEAN1.getUI_M_PLAN_TYPE() != "M") {
	 * String sql_update10 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY10; Object[]
	 * objectsql_update10 = { M_REP_CODE, M_POL_SYS_ID }; update10 = handler
	 * .executeUpdateStatement( sql_update10, connection, objectsql_update10); }
	 * else { String sql_update11 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY11; Object[]
	 * objectsql_update11 = { M_POL_SYS_ID }; update11 = handler
	 * .executeUpdateStatement( sql_update11, connection, objectsql_update11); } }
	 * else { String sql_update12 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY12; Object[]
	 * objectsql_update12 = { M_POL_SYS_ID }; update12 =
	 * handler.executeUpdateStatement( sql_update12, connection,
	 * objectsql_update12);
	 *  }
	 * 
	 * String sql_update13 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY13; Object[]
	 * objectsql_update13 = { DUMMY_BEAN.getUI_M_APPRV_DATE(),
	 * DUMMY_BEAN.getUI_M_APPRV_DATE(), M_PROD_MATU_DT, M_POL_SYS_ID }; update13 =
	 * handler.executeUpdateStatement( sql_update13, connection,
	 * objectsql_update13);
	 * 
	 * String sql_update14 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_INSERT_QUERY14; Object[]
	 * objectsql_update14 = { M_POL_SYS_ID, M_POL_END_NO_IDX,
	 * getControlBean().getM_USER_ID(), getControlBean().getM_USER_ID() };
	 * update14 = handler.executeInsertStatement( sql_update14, connection,
	 * objectsql_update14); if (M_POL_COUNT >= Double .parseDouble(M_REP_COUNT) &&
	 * Double .parseDouble(MigratingFunctions .nvl(M_BCD_COMM_RATE, "0")) == 0) //
	 * if(M_POL_COUNT // >=Double.parseDouble(M_REP_COUNT) && //
	 * Double.parseDouble(M_BCD_COMM_RATE) == 0) { if (M_POL_CLASS_CODE != "2" &&
	 * DUMMY_BEAN1.getUI_M_PLAN_TYPE() != "M") { String sql_update15 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY15; Object[]
	 * objectsql_update15 = { M_REP_CODE, M_POL_SYS_ID }; update15 = handler
	 * .executeUpdateStatement( sql_update15, connection, objectsql_update15); }
	 * else { String sql_update16 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY16; Object[]
	 * objectsql_update16 = { M_POL_SYS_ID }; update16 = handler
	 * .executeUpdateStatement( sql_update16, connection, objectsql_update16); } }
	 * else { String sql_update17 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY17; Object[]
	 * objectsql_update17 = { M_POL_SYS_ID }; update17 =
	 * handler.executeUpdateStatement( sql_update17, connection,
	 * objectsql_update17); } } getControlBean().setM_COMM_DEL("C"); //
	 * COPY.COPY("20","SYSTEM.MESSAGE_LEVEL"); // connection.commit(); //
	 * COPY.COPY("0","SYSTEM.MESSAGE_LEVEL"); // :CTRL.M_COMM_DEL=null;
	 * getControlBean().setM_COMM_DEL(null); msg = Messages .getMessage(
	 * PELConstants.pelErrorMessagePath, "71076", new Object[] { DUMMY_BEAN
	 * .getUI_M_POL_NO() }); //
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71076,:CTRL.M_LANG_CODE,:DUMMY.M_POL_NO);
	 * if ("O".equals(M_DS_POST_BO)) { //
	 * session.setAttribute("GLOBAL.M_POL_SYS_ID", //
	 * DUMMY_BEAN.getUI_M_POL_NO()); CommonUtils.setGlobalVariable(
	 * "GLOBAL.M_CLM_SYS_ID", "0"); //
	 * session.setAttribute("GLOBAL.M_POL_SYS_ID", //
	 * session.getAttribute("GLOBAL.M_POL_SYS_ID")); //
	 * session.setAttribute("GLOBAL.M_CLM_SYS_ID", // 0);
	 * 
	 * :GLOBAL.M_POL_SYS_ID=:DUMMY.M_POL_SYS_ID; :GLOBAL.M_CLM_SYS_ID=0;
	 * SYNCHRONIZE.SYNCHRONIZE();
	 * CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
	 *  } } else if ("009".equals(M_POL_END_TYPE)) { if
	 * ("Y".equals(MigratingFunctions.nvl( M_POL_MED_FEE_RECOVER_YN, "N")) &&
	 * Integer.parseInt(M_CALC_METHOD) == 1) {
	 * 
	 * String sql_C36 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY36; Object[]
	 * objectsql_C36 = { M_POL_SYS_ID, DUMMY_BEAN.getUI_M_POL_PROP_NO() };
	 * resultSetsql_C36 = handler .executeSelectStatement(sql_C36, connection,
	 * objectsql_C36); if (resultSetsql_C36.next()) { M_MFD_CLINIC_CODE =
	 * resultSetsql_C36 .getString(1); M_MFD_EXAM_CODE = resultSetsql_C36
	 * .getString(2); } else { throw new ValidatorException( Messages
	 * .getMessage( PELConstants.pelErrorMessagePath, "91573")); } }
	 * 
	 * String sql_update18 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY18; Object[]
	 * objectsql_update18 = { DUMMY_BEAN.getUI_M_APPRV_DATE(),
	 * getControlBean().getM_USER_ID(), M_POL_SYS_ID }; update18 =
	 * handler.executeUpdateStatement( sql_update18, connection,
	 * objectsql_update18);
	 * 
	 * resultSetsql_C18 = handler.executeSelectStatement( sql_C18, connection,
	 * objectsql_C18); if (resultSetsql_C18.next()) { M_POL_PROD_CODE =
	 * resultSetsql_C18.getString(1); M_POL_NL_FM_DT =
	 * resultSetsql_C18.getDate(2); M_POL_END_DATE =
	 * resultSetsql_C18.getDate(3); M_POL_TRAN_DT = resultSetsql_C18.getDate(4); } //
	 * String //
	 * sql_C21=PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY21; //
	 * objectsql_C21 = {M_POL_PROD_CODE}; resultSetsql_C21 =
	 * handler.executeSelectStatement( sql_C21, connection, new Object[] {
	 * M_POL_PROD_CODE }); if (resultSetsql_C21.next()) { M_PROD_COOLOFF_DAYS =
	 * resultSetsql_C21 .getString(1); M_PROD_PREM_CALC_MTHD = resultSetsql_C21
	 * .getString(2); }
	 * 
	 * ArrayList<String> list_p_val = dbProcedures
	 * .callPCOPK_GENERAL_P_VAL_SYSTEM( "IL_BUF_DAY", "IL_BUF_DAY", "E",
	 * getControlBean().getM_LANG_CODE(), getControlBean().getM_LANG_CODE()); if
	 * (list_p_val != null && list_p_val.size() > 0) { M_BUF_PS_DESC =
	 * list_p_val.get(0); M_BUF_PS_VALUE = list_p_val.get(1);
	 *  } //
	 * pcopk_general.pcopk_general.p_val_system("IL_BUF_DAY","IL_BUF_DAY",M_BUF_PS_DESC,"E",M_BUF_PS_VALUE,:CTRL.M_LANG_CODE,:CTRL.M_LANG_CODE);
	 * 
	 * if (CommonUtils.subtractDate(M_POL_END_DATE,
	 * MigratingFunctions.nvl(M_POL_NL_FM_DT, M_POL_TRAN_DT)) <= (Integer
	 * .parseInt(MigratingFunctions.nvl( M_PROD_COOLOFF_DAYS, "0")) + Integer
	 * .parseInt(MigratingFunctions.nvl( M_BUF_PS_VALUE, "0")))) { String
	 * sql_upadte19 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY19; Object[]
	 * objectsql_upadte19 = { M_POL_SYS_ID }; update19 =
	 * handler.executeUpdateStatement( sql_upadte19, connection,
	 * objectsql_upadte19);
	 * 
	 * String sql_update20 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_INSERT_QUERY20; Object[]
	 * objectsql_update20 = { M_POL_SYS_ID, M_POL_END_NO_IDX,
	 * getControlBean().getM_USER_ID(), getControlBean().getM_USER_ID() };
	 * update20 = handler.executeInsertStatement( sql_update20, connection,
	 * objectsql_update20);
	 *  }
	 * 
	 * getControlBean().setM_COMM_DEL("C"); // :CTRL.M_COMM_DEL="C"; //
	 * COPY.COPY("20","SYSTEM.MESSAGE_LEVEL"); // connection.commit(); //
	 * COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
	 * getControlBean().setM_COMM_DEL(null); // :CTRL.M_COMM_DEL=null; msg =
	 * Messages .getMessage( PELConstants.pelErrorMessagePath, "20330", new
	 * Object[] { DUMMY_BEAN .getUI_M_POL_NO() }); //
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(20330,:CTRL.M_LANG_CODE,:DUMMY.M_POL_NO);
	 * if ("O".equals(M_DS_POST_BO)) { //
	 * session.setAttribute("GLOBAL.M_POL_SYS_ID", //
	 * session.getAttribute("GLOBAL.M_POL_SYS_ID"));
	 * CommonUtils.setGlobalVariable( "GLOBAL.M_CLM_SYS_ID", "0");
	 *  // :GLOBAL.M_POL_SYS_ID=:DUMMY.M_POL_SYS_ID; // :GLOBAL.M_CLM_SYS_ID=0;
	 * 
	 * SYNCHRONIZE.SYNCHRONIZE();
	 * CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
	 *  } } else if ("001".equals(M_POL_END_TYPE) ||
	 * "010".equals(M_POL_END_TYPE) || "007".equals(M_POL_END_TYPE) ||
	 * "011".equals(M_POL_END_TYPE)) { String sql_update21 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY21; Object[]
	 * objectsql_update21 = { DUMMY_BEAN.getUI_M_APPRV_DATE(),
	 * getControlBean().getM_USER_ID(), M_POL_SYS_ID }; update21 =
	 * handler.executeUpdateStatement( sql_update21, connection,
	 * objectsql_update21);
	 * 
	 * getControlBean().setM_COMM_DEL("C"); // :CTRL.M_COMM_DEL="C"; //
	 * COPY.COPY("20","SYSTEM.MESSAGE_LEVEL"); // connection.commit(); //
	 * COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
	 * getControlBean().setM_COMM_DEL(null); // :CTRL.M_COMM_DEL=null; msg =
	 * Messages .getMessage( PELConstants.pelErrorMessagePath, "71076", new
	 * Object[] { DUMMY_BEAN .getUI_M_POL_NO() }); //
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71076,:CTRL.M_LANG_CODE,:DUMMY.M_POL_NO);
	 * if ("O".equals(M_DS_POST_BO)) { //
	 * session.setAttribute("GLOBAL.M_POL_SYS_ID", //
	 * session.getAttribute("GLOBAL.M_POL_SYS_ID"));
	 * CommonUtils.setGlobalVariable( "GLOBAL.M_CLM_SYS_ID", "0");
	 * 
	 * 
	 * :GLOBAL.M_POL_SYS_ID=:DUMMY.M_POL_SYS_ID; :GLOBAL.M_CLM_SYS_ID=0;
	 * SYNCHRONIZE.SYNCHRONIZE();
	 * CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
	 *  } } else { String sql_update22 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_UPDATE_QUERY22; Object[]
	 * objectsql_update22 = { M_POL_SYS_ID }; update22 =
	 * handler.executeUpdateStatement( sql_update22, connection,
	 * objectsql_update22);
	 * 
	 * getControlBean().setM_COMM_DEL("C"); // :CTRL.M_COMM_DEL="C"; //
	 * COPY.COPY("20","SYSTEM.MESSAGE_LEVEL"); // connection.commit(); //
	 * COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
	 * getControlBean().setM_COMM_DEL(null); // :CTRL.M_COMM_DEL=null; msg =
	 * Messages .getMessage( PELConstants.pelErrorMessagePath, "71076", new
	 * Object[] { DUMMY_BEAN .getUI_M_POL_NO() }); //
	 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71076,:CTRL.M_LANG_CODE,:DUMMY.M_POL_NO);
	 * if ("O".equals(M_DS_POST_BO)) { //
	 * session.setAttribute("GLOBAL.M_POL_SYS_ID", //
	 * session.getAttribute("GLOBAL.M_POL_SYS_ID"));
	 * CommonUtils.setGlobalVariable( "GLOBAL.M_CLM_SYS_ID", "0");
	 * 
	 * 
	 * :GLOBAL.M_POL_SYS_ID=:DUMMY.M_POL_SYS_ID; :GLOBAL.M_CLM_SYS_ID=0;
	 * SYNCHRONIZE.SYNCHRONIZE();
	 * CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
	 *  } } } else {
	 * 
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
	 * throw new FORM_TRIGGER_FAILURE();
	 *  } //
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT");
	 * if ("1".equals(M_CALC_METHOD)) { if
	 * ("006".equals(MigratingFunctions.nvl(M_POL_END_TYPE, "000")) ||
	 * "011".equals(MigratingFunctions.nvl( M_POL_END_TYPE, "000"))) {
	 * DUMMY_BEAN.setM_PRINT_TYPE("B");
	 * 
	 * String sql_C11 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY11; Object[]
	 * objectsql_C11 = { M_POL_SYS_ID }; resultSetsql_C11 =
	 * handler.executeSelectStatement( sql_C11, connection, objectsql_C11); if
	 * (resultSetsql_C11.next()) { M_POL_CONT_CODE =
	 * resultSetsql_C11.getString(1); }
	 * 
	 * String sql_C12 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY12; Object[]
	 * objectsql_C12 = { M_POL_CONT_CODE }; resultSetsql_C12 =
	 * handler.executeSelectStatement( sql_C12, connection, objectsql_C12); if
	 * (resultSetsql_C12.next()) { M_CONT_PREFERRED_LANG = resultSetsql_C12
	 * .getString(1); }
	 * 
	 * if ("006".equals(MigratingFunctions.nvl( M_POL_END_TYPE, "000"))) {
	 * String sql_C13 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY13; Object[]
	 * objectsql_C13 = {}; resultSetsql_C13 = handler
	 * .executeSelectStatement(sql_C13, connection, objectsql_C13);
	 * 
	 * if (resultSetsql_C13.next()) { M_PC_DESC = resultSetsql_C13.getString(1);
	 * M_PC_BL_DESC = resultSetsql_C13 .getString(2); }
	 * 
	 * if ("E".equals(MigratingFunctions.nvl( M_CONT_PREFERRED_LANG, "E"))) {
	 * M_REP_NAME = M_PC_DESC; } else { M_REP_NAME = M_PC_BL_DESC; } ArrayList<String>
	 * list_end = dbProcedures .callP9ILPK_UW_LETTERS_GEN_JE_ENDORSEMENT_LETTER(
	 * M_REP_NAME, M_POL_SYS_ID); if (list_end != null && list_end.size() > 0) {
	 * M_DSRC_SYS_ID = list_end.get(0); }
	 * 
	 * p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_endorsement_letter(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_POL_SYS_ID);
	 * P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_PRINT_TYPE,"PS");
	 *  } if ("011".equals(MigratingFunctions.nvl( M_POL_END_TYPE, "000"))) {
	 * String sql_C14 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY14; Object[]
	 * objectsql_C14 = {}; resultSetsql_C14 = handler
	 * .executeSelectStatement(sql_C14, connection, objectsql_C14); if
	 * (resultSetsql_C14.next()) { M_PC_DESC = resultSetsql_C14.getString(1);
	 * M_PC_BL_DESC = resultSetsql_C14 .getString(2); }
	 * 
	 * if ("E".equals(MigratingFunctions.nvl( M_CONT_PREFERRED_LANG, "E"))) {
	 * M_REP_NAME = M_PC_DESC; } else { M_REP_NAME = M_PC_BL_DESC; }
	 * 
	 * ArrayList<String> list_uw = dbProcedures
	 * .callP9ILPK_UW_LETTERS_GEN_JE_ASSIGNMENT_LETTER( M_REP_NAME,
	 * M_POL_SYS_ID); if (list_uw != null && list_uw.size() > 0) { M_DSRC_SYS_ID =
	 * list_uw.get(0); }
	 * 
	 * p9ilpk_uw_letters.p9ilpk_uw_letters.gen_je_assignment_letter(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_POL_SYS_ID);
	 * P_LIFE_LETTER.P_LIFE_LETTER(M_DSRC_SYS_ID,M_REP_NAME,:DUMMY.M_PRINT_TYPE,"PS");
	 *  } } } if ("M".equals(DUMMY_BEAN1.getUI_M_PLAN_TYPE()) &&
	 * "W".equals(M_PROD_DRIP_MTHD) && "000".equals(MigratingFunctions.nvl(
	 * M_POL_END_TYPE, "000")) || "002".equals(MigratingFunctions.nvl(
	 * M_POL_END_TYPE, "000")) || "009".equals(MigratingFunctions.nvl(
	 * M_POL_END_TYPE, "000")) || "012".equals(MigratingFunctions.nvl(
	 * M_POL_END_TYPE, "000")) || "013".equals(MigratingFunctions.nvl(
	 * M_POL_END_TYPE, "000"))) { if
	 * ("000".equals(MigratingFunctions.nvl(M_POL_END_TYPE, "000")) ||
	 * "002".equals(MigratingFunctions.nvl( M_POL_END_TYPE, "000")) ||
	 * "012".equals(MigratingFunctions.nvl( M_POL_END_TYPE, "000")) ||
	 * "013".equals(MigratingFunctions.nvl( M_POL_END_TYPE, "000"))) {
	 * dbProcedures .callP9ILPK_WAK_DRIP_IL_DAILY_DRIP( CommonUtils
	 * .dateToStringFormatter(NumericFunctions .trunc(new java.sql.Date(
	 * Calendar .getInstance() .getTimeInMillis()))),
	 * DUMMY_BEAN.getUI_M_POL_NO()); //
	 * p9ilpk_wak_drip.p9ilpk_wak_drip.il_daily_drip(NumericFunctions.trunc(new //
	 * java.sql.Date(Calendar.getInstance().getTimeInMillis())),:DUMMY.M_POL_NO); }
	 * else if ("009".equals(MigratingFunctions.nvl( M_POL_END_TYPE, "000"))) {
	 * dbProcedures .callP9ILPK_WAK_DRIP_IL_CANCEL_DRIP( CommonUtils
	 * .dateToStringFormatter(NumericFunctions .trunc(new java.sql.Date(
	 * Calendar .getInstance() .getTimeInMillis()))),
	 * DUMMY_BEAN.getUI_M_POL_NO()); //
	 * p9ilpk_wak_drip.p9ilpk_wak_drip.il_cancel_drip(NumericFunctions.trunc(new //
	 * java.sql.Date(Calendar.getInstance().getTimeInMillis())),:DUMMY.M_POL_NO); }
	 * if ("O".equals(M_DS_POST_BO)) { //
	 * session.setAttribute("GLOBAL.M_POL_SYS_ID", //
	 * session.getAttribute("GLOBAL.M_POL_SYS_ID"));
	 * CommonUtils.setGlobalVariable( "GLOBAL.M_CLM_SYS_ID", "0");
	 * 
	 * 
	 * :GLOBAL.M_POL_SYS_ID=:DUMMY.M_POL_SYS_ID; :GLOBAL.M_CLM_SYS_ID=0;
	 * SYNCHRONIZE.SYNCHRONIZE();
	 * CALL_FORM.CALL_FORM("PILP010",NO_HIDE,NO_REPLACE);
	 *  } } if (MigratingFunctions.nvl(M_POL_END_TYPE, "000") != "009" &&
	 * MigratingFunctions.nvl(M_POL_END_TYPE, "000") != "001") { String
	 * CALLING_FORM = "CALLING_FORM"; //
	 * if(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM) // ==
	 * ("PILT002_APAC") || //
	 * GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM) // ==
	 * ("PILP001_APAC")) if (CALLING_FORM == ("CALLING_FORM") || CALLING_FORM ==
	 * ("PILP001_APAC")) { if ("Y".equals(CommonUtils
	 * .getGlobalVariable("GLOBAL.M_SUCC"))) { resultSetsql_C18 = handler
	 * .executeSelectStatement(sql_C18, connection, objectsql_C18); if
	 * (resultSetsql_C18.next()) { M_POL_PROD_CODE = resultSetsql_C18
	 * .getString(1); M_POL_NL_FM_DT = resultSetsql_C18 .getDate(2);
	 * M_POL_END_DATE = resultSetsql_C18 .getDate(3); M_POL_TRAN_DT =
	 * resultSetsql_C18.getDate(4); }
	 * 
	 * String sql_C17 =
	 * PILP002_APAC_SQLConstants.OK_BUTTON_PRESSED_SELECT_QUERY17; Object[]
	 * objectsql_C17 = { M_POL_PROD_CODE, CommonUtils
	 * .getGlobalVariable("GLOBAL.M_SITE") }; resultSetsql_C17 = handler
	 * .executeSelectStatement(sql_C17, connection, objectsql_C17); if
	 * (resultSetsql_C17.next()) { M_CSVSD_PARA_CODE_DESC = resultSetsql_C17
	 * .getString(1); }
	 * 
	 * if (M_CSVSD_PARA_CODE_DESC != null) { //
	 * CALL_FORM.CALL_FORM(M_CSVSD_PARA_CODE_DESC,NO_HIDE,NO_REPLACE); } //
	 * EXIT_FORM.EXIT_FORM(NO_VALIDATE); } } else {
	 * 
	 * GO_ITEM.GO_ITEM("DUMMY.M_POL_NO"); CLEAR_BLOCK.CLEAR_BLOCK(NO_VALIDATE);
	 *  } } else { // EXIT_FORM.EXIT_FORM(NO_VALIDATE); } } }
	 *  } catch (DBException e) { e.printStackTrace();
	 * getErrorMap().put("current", e.getMessage()); getErrorMap().put("detail",
	 * e.getMessage()); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } catch (SQLException e) { e.printStackTrace();
	 * getErrorMap().put("current", e.getMessage()); getErrorMap().put("detail",
	 * e.getMessage()); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); }
	 * 
	 * ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
	 * FacesContext.getCurrentInstance(), COMP_UI_M_BUT_OK.getId(),
	 * getErrorMap(), getWarningMap());
	 *  } catch (ValidatorException e) { e.printStackTrace();
	 * getErrorMap().put("current", e.getMessage()); getErrorMap().put("detail",
	 * e.getMessage()); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } catch (Exception e) { e.printStackTrace();
	 * getErrorMap().put("current", e.getMessage()); getErrorMap().put("detail",
	 * e.getMessage()); try { connection.rollback(); } catch (SQLException e1) {
	 * e1.printStackTrace(); } } finally { try {
	 * 
	 * if(msg != null) { CommonUtils commonUtils = new CommonUtils();
	 * PILT002_APAC_COMPOSITE_ACTION compositeAction =
	 * (PILT002_APAC_COMPOSITE_ACTION)
	 * commonUtils.getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().loadingBaseValues(); //[Bug
	 * id -PREMIAGDC-000158 : assigning last instalment date: Shankar bodduluri
	 * Dated: 18-Mar-2009 ]
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().setPOL_LAST_INST_DT(date);
	 * new PILT002_APAC_HELPER().updateLstInstalDate(date, rowId);
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put("current",
	 * msg.getSummary());
	 * compositeAction.getPT_IL_POLICY_ACTION_BEAN().getWarningMap().put("detail",
	 * msg.getSummary()); if(getErrorMap().size()>0){ returnValue = ""; }else{
	 * returnValue = navigateToPolicyEntryScreen(); } } //PREMIAGDC-317794
	 * -VijayAnand.V - 30-07-2009]
	 * 
	 * else{ if(getErrorMap().size()>0){ returnValue = ""; }else{ returnValue =
	 * navigateToPolicyEntryScreen(); } }
	 *  // PREMIAGDC-317794 -VijayAnand.V - 30-07-2009] connection.commit();
	 * CommonUtils.closeCursor(resultSetsql_C1);
	 * CommonUtils.closeCursor(resultSetsql_C10);
	 * CommonUtils.closeCursor(resultSetsql_C11);
	 * CommonUtils.closeCursor(resultSetsql_C12);
	 * CommonUtils.closeCursor(resultSetsql_C13);
	 * CommonUtils.closeCursor(resultSetsql_C14);
	 * CommonUtils.closeCursor(resultSetsql_C15);
	 * CommonUtils.closeCursor(resultSetsql_C16);
	 * CommonUtils.closeCursor(resultSetsql_C17);
	 * CommonUtils.closeCursor(resultSetsql_C18);
	 * CommonUtils.closeCursor(resultSetsql_C19);
	 * CommonUtils.closeCursor(resultSetsql_C2);
	 * CommonUtils.closeCursor(resultSetsql_C20);
	 * CommonUtils.closeCursor(resultSetsql_C21);
	 * CommonUtils.closeCursor(resultSetsql_C22);
	 * CommonUtils.closeCursor(resultSetsql_C23);
	 * CommonUtils.closeCursor(resultSetsql_C24);
	 * CommonUtils.closeCursor(resultSetsql_C25);
	 * CommonUtils.closeCursor(resultSetsql_C26);
	 * CommonUtils.closeCursor(resultSetsql_C27);
	 * CommonUtils.closeCursor(resultSetsql_C28);
	 * CommonUtils.closeCursor(resultSetsql_C29);
	 * CommonUtils.closeCursor(resultSetsql_C3);
	 * CommonUtils.closeCursor(resultSetsql_C30);
	 * CommonUtils.closeCursor(resultSetsql_C35);
	 * CommonUtils.closeCursor(resultSetsql_C36);
	 * CommonUtils.closeCursor(resultSetsql_C37);
	 * CommonUtils.closeCursor(resultSetsql_C38);
	 * CommonUtils.closeCursor(resultSetsql_C39);
	 * CommonUtils.closeCursor(resultSetsql_C4);
	 * CommonUtils.closeCursor(resultSetsql_C40);
	 * CommonUtils.closeCursor(resultSetsql_C5);
	 * CommonUtils.closeCursor(resultSetsql_C6);
	 * CommonUtils.closeCursor(resultSetsql_C7);
	 * CommonUtils.closeCursor(resultSetsql_C8);
	 * CommonUtils.closeCursor(resultSetsql_C9);
	 * ErrorHelpUtil.getErrorsAndWarningsforProcedureAction( connection,
	 * FacesContext.getCurrentInstance(), COMP_UI_M_BUT_OK.getId(),
	 * getErrorMap(), getWarningMap()); } catch (Exception e) {
	 * e.printStackTrace(); } } return returnValue; //
	 * SET_APPLICATION_PROPERTY.SET_APPLICATION_PROPERTY(CURSOR_STYLE,"DEFAULT"); }
	 * 
	 *//* ACTION methods for CustomerCode_LOV */

	public List suggestionActionCustomerCode(Object event) {

		String customerCode = (String) event;

		String query = null;

		if ("*".equals(customerCode)) {
			query = PILP002_APAC_SQLConstants.CUSTOMER_CODE_LOV_QUERY;
			Object[] object = {};
			customerCodeList = customerCodeLOV(query, object);

		} else {
			query = PILP002_APAC_SQLConstants.CUSTOMER_CODE_SUGGESTION_LOV_QUERY;
			customerCode = customerCode + "%";
			Object[] object = { customerCode };
			customerCodeList = customerCodeLOV(query, object);
		}
		return customerCodeList;
	}

	public List customerCodeLOV(String query, Object[] object) {
		List customerCodeList = new ArrayList();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		Connection connection = null;

		try {
			connection = CommonUtils.getConnection();

			resultSet = handler.executeSelectStatement(query, connection,
					object);
			while (resultSet.next()) {

				// PT_IL_POL_BENEFICIARY beneficiary = new
				// PT_IL_POL_BENEFICIARY();
				DUMMY_BEAN.setUI_M_CUST_CODE(resultSet.getString(1));
				DUMMY_BEAN.setUI_M_POL_CUST_DESC(resultSet.getString(2));
				// System.out.println("DUMMY_BEAN: "+DUMMY_BEAN);
				// System.out.println("customerCodeList: "+ customerCodeList);
				customerCodeList.add(DUMMY_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		}
		return customerCodeList;
	}

	public void getCustomerCodeDesc(ActionEvent event) {

		// COMP_UI_M_POL_CUST_DESC.setSubmittedValue(null);
		if (COMP_UI_M_CUST_CODE.getSubmittedValue() != null) {
			String customerCode = (String) COMP_UI_M_CUST_CODE
					.getSubmittedValue();
			// String categoryDesc = getCategoryDescforCode(categoryCode,
			// categoryCodelist);
			Iterator iterator = customerCodeList.iterator();
			String customerDesc = null;
			while (iterator.hasNext()) {
				DUMMY bean = (DUMMY) iterator.next();
				// PT_IL_POL_BENEFICIARY
				// beneficiary=(PT_IL_POL_BENEFICIARY)iterator.next();
				// PM_IL_PLAN pm_il_plan=(PM_IL_PLAN)iterator.next();
				if (customerCode.equals(bean.getUI_M_CUST_CODE())) {
					customerDesc = bean.getUI_M_POL_CUST_DESC();
				}
			}
			COMP_UI_M_POL_CUST_DESC.setSubmittedValue(customerDesc);
		}
	}

	public void L_VALIDATE_APPRV_DATE() throws Exception {
		ResultSet rssql_C1 = null;
		Date M_ISS_ENDT_DT = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String sql_C1 = PILP002_APAC_SQLConstants.L_VALIDATE_APPRV_DATEQuery;
			Object[] objectsql_C1 = { CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
			rssql_C1 = handler.executeSelectStatement(sql_C1, connection,
					objectsql_C1);
			if (rssql_C1.next()) {
				M_ISS_ENDT_DT = rssql_C1.getDate(1);
			}
			// vembu_C1.close();
			Date sysDate = new CommonUtils().getCurrentDate();

			//if condition added by ameen for policy date null issue on 03-06-2016
			if(M_ISS_ENDT_DT!=null){
			
			
				if (DUMMY_BEAN.getUI_M_APPRV_DATE().after(sysDate)
						/*|| (DUMMY_BEAN.getUI_M_APPRV_DATE().before(M_ISS_ENDT_DT))*/) {
					throw new Exception("Enter Valid Date");
				}
			}

			// DUMMY_BEAN.getUI_M_APPRV_DATE()> NumericFunctions.trunc(new
			// java.sql.Date(Calendar.getInstance().getTimeInMillis()))

			{
				/*
				 * STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(71072,:CTRL.M_LANG_CODE);
				 * L_RESTORE_DEFAULT.L_RESTORE_DEFAULT(); throw new
				 * FORM_TRIGGER_FAILURE();
				 */
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			try {
				CommonUtils.closeCursor(rssql_C1);
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		}
	}

	public double P_VAL_ROUND_AMT(String P_CURR_CODE, double P_AMT,
			String P_VAL_ROUND) throws ValidatorException, Exception {
		connection = CommonUtils.getConnection();
		handler = new CRUDHandler();
		ResultSet resultSetsql_C1 = null;
		ResultSet resultSetsql_C2 = null;
		int M_DECIMAL = -1;
		String M_PS_CODE = null;
		int M_PS_VALUE = -1;
		String sql_C1 = PILP002_APAC_SQLConstants.P_VAL_ROUND_AMT_sql_C1;
		Object[] objectsql_C1 = { P_CURR_CODE };

		try {
			resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
					connection, objectsql_C1);
			if (resultSetsql_C1.next()) {
				M_DECIMAL = resultSetsql_C1.getInt(1);
			}
			if (resultSetsql_C1.isAfterLast()
					|| resultSetsql_C1.isBeforeFirst()) {
				M_DECIMAL = 2;
			}
			String sql_C2 = PILP002_APAC_SQLConstants.P_VAL_ROUND_AMT_sql_C2;
			Object[] objectsql_C2 = {};
			resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
					connection, objectsql_C2);
			if (resultSetsql_C2.next()) {
				M_PS_CODE = resultSetsql_C2.getString(1);
				M_PS_VALUE = resultSetsql_C2.getInt(2);
			}
			if (M_PS_VALUE == 0) {
				if ("V".equals(P_VAL_ROUND)) {
					if (NumericFunctions.round(P_AMT, M_DECIMAL) != P_AMT) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "1039"));
					}
				} else {
					P_AMT = NumericFunctions.round(P_AMT, M_DECIMAL);
				}
			} else {
				M_DECIMAL = M_PS_VALUE;
				if ("V".equals(P_VAL_ROUND)) {
					if (NumericFunctions.round(P_AMT, M_DECIMAL) != P_AMT) {
						throw new ValidatorException(Messages.getMessage(
								PELConstants.pelErrorMessagePath, "1039"));
					}
				} else {
					P_AMT = NumericFunctions.round(P_AMT, M_DECIMAL);
				}
			}
		} catch (SQLException e) {

		} finally {

			try {
				CommonUtils.closeCursor(resultSetsql_C1);
				CommonUtils.closeCursor(resultSetsql_C2);
			} catch (Exception exc) {
				exc.printStackTrace();
			}

		}
		return P_AMT;
	}

	public List<SelectItem> getPREM_GEN_YN_LIST() {
		return PREM_GEN_YN_LIST;
	}

	public void setPREM_GEN_YN_LIST(List<SelectItem> prem_gen_yn_list) {
		PREM_GEN_YN_LIST = prem_gen_yn_list;
	}

	public List<SelectItem> getBROK_GEN_YN_LIST() {
		return BROK_GEN_YN_LIST;
	}

	public void setBROK_GEN_YN_LIST(List<SelectItem> brok_gen_yn_list) {
		BROK_GEN_YN_LIST = brok_gen_yn_list;
	}

	public List<DUMMY> getCustomerCodeList() {
		return customerCodeList;
	}

	public void setCustomerCodeList(List<DUMMY> customerCodeList) {
		this.customerCodeList = customerCodeList;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PREM_GEN_YN() {
		return COMP_UI_M_PREM_GEN_YN;
	}

	public void setCOMP_UI_M_PREM_GEN_YN(HtmlSelectOneMenu comp_ui_m_prem_gen_yn) {
		COMP_UI_M_PREM_GEN_YN = comp_ui_m_prem_gen_yn;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_BROK_GEN_YN() {
		return COMP_UI_M_BROK_GEN_YN;
	}

	public void setCOMP_UI_M_BROK_GEN_YN(HtmlSelectOneMenu comp_ui_m_brok_gen_yn) {
		COMP_UI_M_BROK_GEN_YN = comp_ui_m_brok_gen_yn;
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR
	 * COMP_UI_M_FC_AMOUNT
	 * 
	 * @param e
	 */
	public void COMP_UI_M_FC_AMOUNT_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		/*
		 * Double inputValue =
		 * Double.parseDouble(input.getSubmittedValue().toString());
		 * DUMMY_BEAN.setUI_M_FC_AMOUNT(inputValue);
		 */
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR
	 * COMP_UI_M_LC_AMOUNT
	 * 
	 * @param e
	 */
	public void COMP_UI_M_LC_AMOUNT_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR UI_M_LC_AMOUNT
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_LC_AMOUNT(FacesContext context,
			UIComponent component, Object value) {
		try {
			DUMMY_BEAN.setUI_M_LC_AMOUNT((Double) value);
			pilp002_apac_dummy_m_lc_amount_when_validate_item(DUMMY_BEAN);
		} catch (SQLException se) {
			se.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(connection,
					FacesContext.getCurrentInstance(), COMP_UI_M_LC_AMOUNT
							.getId(), getErrorMap(), getWarningMap());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}

	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR UI_M_FC_AMOUNT
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_FC_AMOUNT(FacesContext context,
			UIComponent component, Object value) {
		try {
			DUMMY_BEAN.setUI_M_FC_AMOUNT((Double) value);
			pilp002_apac_dummy_m_fc_amount_when_validate_item();
			COMP_UI_M_FC_AMOUNT.resetValue();
			COMP_UI_M_LC_AMOUNT.resetValue();
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR
	 * COMP_UI_M_CUST_CODE
	 * 
	 * @param e
	 */
	public void COMP_UI_M_CUST_CODE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR UI_M_CUST_CODE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_CUST_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		pilp002_apac_dummy_m_cust_code_when_validate_item();
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR COMP_UI_M_POL_NO
	 * 
	 * @param e
	 */
	public void COMP_UI_M_POL_NO_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR UI_M_POL_NO
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_POL_NO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		pilp002_apac_dummy_m_pol_no_when_validate_item();
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR
	 * COMP_UI_M_APPRV_DATE
	 * 
	 * @param e
	 */
	public void COMP_UI_M_APPRV_DATE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR UI_M_APPRV_DATE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_APPRV_DATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		
		try {
			PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
			DUMMY_BEAN.setUI_M_APPRV_DATE((Date) value);
			pilp002_apac_dummy_m_apprv_date_when_validate_item();
			if (getCOMP_UI_M_CUST_CODE().getSubmittedValue() != null
					&& "Y".equals(DUMMY_BEAN.getUI_M_POL_CASH_YN())) {
				ArrayList<String> list = pkg_pilt002_apac.P_VAL_CLASS_CUST(
						"CASH", DUMMY_BEAN.getUI_M_CUST_CODE(), DUMMY_BEAN
								.getUI_M_POL_CUST_DESC(), "N", "E", DUMMY_BEAN
								.getUI_M_POL_DIVN_CODE());
				if (list != null && list.size() > 0) {
					DUMMY_BEAN.setUI_M_POL_CUST_DESC(list.get(0));
				}
			}
			COMP_UI_M_CUST_CODE.resetValue();
			COMP_UI_M_POL_CUST_DESC.resetValue();
		}  catch (ValidatorException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
		
		
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR
	 * COMP_UI_M_TRAN_DATE
	 * 
	 * @param e
	 */
	public void COMP_UI_M_TRAN_DATE_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR UI_M_TRAN_DATE
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_TRAN_DATE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		pilp002_apac_dummy_m_tran_date_when_validate_item();
	}

	public void pilp002_apac_dummy_m_tran_date_when_validate_item()
			throws ValidatorException {
		ResultSet resultSetsql_C1 = null;
		ResultSet resultSetsql_C2 = null;
		ResultSet resultSetsql_C3 = null;
		ResultSet resultSetsql_C4 = null;
		ResultSet resultSetsql_C16 = null;
		String M_CODE_DESC = null;
		String M_CO_VALUE = null;
		String M_NO_MODES = null;
		double M_TOTAL_PREMIUM = -1;
		String M_IL_TOLL_TYPE = null;
		String M_IL_SHORT_COLL = null;
		double M_LC_SHORT_COLL = 0;
		String M_POL_MODE_OF_PYMT = null;
		String M_POL_CUST_CURR_CODE = null;
		String M_POL_CONT_CODE = null;
		String M_POL_CUST_CODE = null;
		String M_POL_DIVN_CODE = null;
		String M_POL_END_TYPE = null;
		String M_POL_CUST_EXCH_RATE = null;
		String M_POL_FC_FIRST_PREM = null;
		String M_POL_LC_FIRST_PREM = null;
		Double M_CONT_LC_PROP_DEP_AMT = null;
		Double M_CONT_LC_PROP_UTIL_AMT = null;
		String M_POL_CASH_YN = null;
		double M_AVLB_BAL_LC_AMT = -1;
		double M_AVLB_BAL_FC_AMT = -1;
		String M_POL_PLAN_CODE = null;
		Double M_CONT_LC_POL_DEP_AMT = null;
		Double M_CONT_LC_POL_UTIL_AMT = null;
		double M_PMOP_SHORT_RATE = -1;
		double M_PMOP_SHORT_RATE_PER = -1;
		String M_PMOP_TOLL_TYP = null;
		String M_POL_CUST_DESC = null;
		PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
		try {

			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			System.out.println("------>"
					+ CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID"));
			String sql_C1 = PILP002_APAC_SQLConstants.M_TRANSACTION_DATE_WHEN_VAL_QUERY;
			Object[] objectsql_C1 = { CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID") };
			resultSetsql_C1 = handler.executeSelectStatement(sql_C1,
					connection, objectsql_C1);
			if (DUMMY_BEAN.getUI_M_APPRV_DATE() != null) {
				// L_VALIDATE_TRANSACTION_DT.L_VALIDATE_TRANSACTION_DT();

				if (resultSetsql_C1.next()) {
					M_POL_CUST_CODE = resultSetsql_C1.getString(1);
					M_POL_CONT_CODE = resultSetsql_C1.getString(2);
					M_POL_CUST_CURR_CODE = resultSetsql_C1.getString(3);
					M_POL_CUST_EXCH_RATE = resultSetsql_C1.getString(4);
					M_POL_FC_FIRST_PREM = resultSetsql_C1.getString(5);
					M_POL_LC_FIRST_PREM = resultSetsql_C1.getString(6);
					M_POL_CASH_YN = resultSetsql_C1.getString(7);
					M_POL_DIVN_CODE = resultSetsql_C1.getString(8);
					M_POL_END_TYPE = resultSetsql_C1.getString(9);
					M_POL_MODE_OF_PYMT = resultSetsql_C1.getString(10);
					M_POL_PLAN_CODE = resultSetsql_C1.getString(11);
				}

				String sql_C2 = PILP002_APAC_SQLConstants.M_TRANSACTION_DATE_WHEN_VAL_QUERY2;
				Object[] objectsql_C2 = { M_POL_CONT_CODE };
				resultSetsql_C2 = handler.executeSelectStatement(sql_C2,
						connection, objectsql_C2);

				if (resultSetsql_C2.next()) {
					M_CONT_LC_PROP_DEP_AMT = resultSetsql_C2.getDouble(1);
					M_CONT_LC_PROP_UTIL_AMT = resultSetsql_C2.getDouble(2);
					M_CONT_LC_POL_DEP_AMT = resultSetsql_C2.getDouble(3);
					M_CONT_LC_POL_UTIL_AMT = resultSetsql_C2.getDouble(4);
				}

				M_AVLB_BAL_LC_AMT = CommonUtils.nvl(M_CONT_LC_PROP_DEP_AMT, 0)
						- CommonUtils.nvl(M_CONT_LC_PROP_UTIL_AMT, 0);
				P_VAL_ROUND_AMT(DUMMY_BEAN1.getUI_M_BASE_CURR_CODE(),
						M_AVLB_BAL_LC_AMT, "R");
				if (CommonUtils.nvl(M_AVLB_BAL_LC_AMT, 0) == 0) {
					M_AVLB_BAL_LC_AMT = MigratingFunctions.nvl(
							M_CONT_LC_POL_DEP_AMT, 0)
							- CommonUtils.nvl(M_CONT_LC_POL_UTIL_AMT, 0);
				}
				M_AVLB_BAL_FC_AMT = M_AVLB_BAL_LC_AMT
						/ Double.parseDouble(M_POL_CUST_EXCH_RATE);
				P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE, M_AVLB_BAL_FC_AMT, "R");
				if ("CO".equals(DUMMY_BEAN.getUI_M_PROCESS_TYPE())) {
					ArrayList list = P_VAL_SYSTEM
							.P_VAL_SYSTEM(
									connection,
									"MODESPRMYN",
									CommonUtils
											.getGlobalVariable("GLOBAL.M_PROCESS_TYPE"),
									"E");
					M_CODE_DESC = list.get(0).toString();
					M_CO_VALUE = list.get(1).toString();

					if ("1".equals(M_CO_VALUE)) {
						ArrayList list1 = P_VAL_SYSTEM.P_VAL_SYSTEM(connection,
								"CONUMMODES", M_POL_MODE_OF_PYMT, "E");
						M_CODE_DESC = list1.get(0).toString();
						M_NO_MODES = list1.get(1).toString();

						if (MigratingFunctions.nvl(Double
								.parseDouble(M_NO_MODES), 0) > 0) {
							M_TOTAL_PREMIUM = Double.parseDouble(M_NO_MODES)
									* Double.parseDouble(M_POL_LC_FIRST_PREM);
							P_VAL_ROUND_AMT(DUMMY_BEAN1
									.getUI_M_BASE_CURR_CODE(), M_TOTAL_PREMIUM,
									"R");
							String sql_C4 = PILP002_APAC_SQLConstants.M_TRANSACTION_DATE_WHEN_VAL_QUERY4;
							Object[] objectsql_C4 = {};
							resultSetsql_C4 = handler.executeSelectStatement(
									sql_C4, connection, objectsql_C4);
							if (resultSetsql_C4.next()) {
								M_IL_TOLL_TYPE = resultSetsql_C4.getString(1);
							}

							String sql_C3 = PILP002_APAC_SQLConstants.M_TRANSACTION_DATE_WHEN_VAL_QUERY3;
							Object[] objectsql_C3 = { M_POL_MODE_OF_PYMT };
							resultSetsql_C3 = handler.executeSelectStatement(
									sql_C3, connection, objectsql_C3);
							if (resultSetsql_C3.next()) {
								M_IL_SHORT_COLL = resultSetsql_C3.getString(1);
							}

							if (MigratingFunctions.nvl(Double
									.parseDouble(M_IL_TOLL_TYPE), 0) == 1) {
								M_LC_SHORT_COLL = MigratingFunctions.nvl(
										M_TOTAL_PREMIUM, 0)
										* MigratingFunctions.nvl(Double
												.parseDouble(M_IL_SHORT_COLL),
												0) / 100;
							} else {
								M_LC_SHORT_COLL = MigratingFunctions.nvl(Double
										.parseDouble(M_IL_SHORT_COLL), 0)
										* Double.parseDouble(M_NO_MODES);
							}
							String sql_C16 = PILP002_APAC_SQLConstants.M_TRANSACTION_DATE_WHEN_VAL_QUERY16;
							Object[] objectsql_C16 = { M_POL_PLAN_CODE,
									M_POL_MODE_OF_PYMT };
							resultSetsql_C16 = handler.executeSelectStatement(
									sql_C16, connection, objectsql_C16);
							if (resultSetsql_C16.next()) {
								M_PMOP_SHORT_RATE = resultSetsql_C16
										.getDouble(1);
								M_PMOP_SHORT_RATE_PER = resultSetsql_C16
										.getDouble(2);
								M_PMOP_TOLL_TYP = resultSetsql_C16.getString(3);
							}

							if ("P".equals(M_PMOP_TOLL_TYP)) {
								M_LC_SHORT_COLL = (MigratingFunctions.nvl(
										M_TOTAL_PREMIUM, 0) * (MigratingFunctions
										.nvl(M_PMOP_SHORT_RATE, 0) / MigratingFunctions
										.nvl(M_PMOP_SHORT_RATE_PER, 0)));
							} else {
								M_LC_SHORT_COLL = MigratingFunctions.nvl(
										M_PMOP_SHORT_RATE, 0);
							}
							P_VAL_ROUND_AMT(DUMMY_BEAN1
									.getUI_M_BASE_CURR_CODE(), M_LC_SHORT_COLL,
									"R");
							if (M_TOTAL_PREMIUM > M_AVLB_BAL_LC_AMT
									+ M_LC_SHORT_COLL) {
								throw new ValidatorException(
										new FacesMessage(
												"Deposit not enough to meet the premium"));
							}
						}
					}
				}
				if ("000".equals(M_POL_END_TYPE)) {
					if (MigratingFunctions.nvl(Double
							.parseDouble(M_POL_FC_FIRST_PREM), 0) >= M_AVLB_BAL_FC_AMT
							&& M_AVLB_BAL_FC_AMT >= 0) {
						DUMMY_BEAN.setUI_M_FC_AMOUNT(0.0);
						DUMMY_BEAN.setUI_M_AVLB_BAL_LC_AMT(M_AVLB_BAL_LC_AMT);
						DUMMY_BEAN.setUI_M_AVLB_BAL_FC_AMT(M_AVLB_BAL_FC_AMT);
					} else {
						DUMMY_BEAN.setUI_M_FC_AMOUNT(0.0);
						DUMMY_BEAN.setUI_M_AVLB_BAL_LC_AMT(M_AVLB_BAL_LC_AMT);
						DUMMY_BEAN.setUI_M_AVLB_BAL_FC_AMT(M_AVLB_BAL_FC_AMT);
					}
					ArrayList<String> list1 = PCPOK_GENERAL.p_val_round_amt(
							connection, DUMMY_BEAN.getUI_M_FC_AMOUNT() + "",
							"R", "ENG", null);
					if (list1 != null && list1.size() > 0) {
						M_POL_CUST_CURR_CODE = list1.get(0);
					}
					DUMMY_BEAN.setUI_M_LC_AMOUNT(DUMMY_BEAN.getUI_M_FC_AMOUNT()
							* Double.parseDouble(M_POL_CUST_EXCH_RATE));
					P_VAL_ROUND_AMT(DUMMY_BEAN1.getUI_M_BASE_CURR_CODE(),
							DUMMY_BEAN.getUI_M_LC_AMOUNT(), "R");
					DUMMY_BEAN.setUI_M_DUMMY_FC_AMOUNT(DUMMY_BEAN
							.getUI_M_FC_AMOUNT());
					DUMMY_BEAN.setUI_M_DUMMY_FC_AMOUNT(DUMMY_BEAN
							.getUI_M_LC_AMOUNT());
				}
				// :DUMMY1.M_CUST_CURR_CODE=M_POL_CUST_CURR_CODE;
				// :DUMMY1.M_CUST_EXCH_RATE=M_POL_CUST_EXCH_RATE;
				DUMMY_BEAN.setUI_M_CUST_CODE(M_POL_CUST_CODE);
				// DUMMY_BEAN.M_POL_DIVN_CODE=M_POL_DIVN_CODE;
				// :DUMMY.M_POL_CASH_YN=M_POL_CASH_YN;
				if ("N".equals(M_POL_CASH_YN)) {
					COMP_UI_M_CUST_CODE.setDisabled(true);
					COMP_UI_M_BUT_CUST_CODE = COMP_UI_M_BUT_CUST_CODE == null ? new HtmlCommandButton()
							: COMP_UI_M_BUT_CUST_CODE;
					COMP_UI_M_BUT_CUST_CODE.setDisabled(true);
					/*
					 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_CUST_CODE",ENABLED,PROPERTY_FALSE);
					 * SET_ITEM_PROPERTY.SET_ITEM_PROPERTY("DUMMY.M_BUT_CUST_CODE",ENABLED,PROPERTY_FALSE);
					 */
					ArrayList<String> list_amt = pkg_pilt002_apac
							.P_VAL_CLASS_CUST("CUSTOMER", DUMMY_BEAN
									.getUI_M_CUST_CODE(), M_POL_CUST_DESC, "N",
									"N", DUMMY_BEAN.getUI_M_POL_DIVN_CODE());
					if (list_amt != null && list_amt.size() > 0) {
						M_POL_CUST_DESC = list_amt.get(0);
					}
				} else {
					COMP_UI_M_CUST_CODE.setDisabled(false);
					COMP_UI_M_CUST_CODE.setReadonly(false);
					ArrayList<String> list_amt = pkg_pilt002_apac
							.P_VAL_CLASS_CUST("CASH", DUMMY_BEAN
									.getUI_M_CUST_CODE(), M_POL_CUST_DESC, "N",
									"N", DUMMY_BEAN.getUI_M_POL_DIVN_CODE());
					if (list_amt != null && list_amt.size() > 0) {
						M_POL_CUST_DESC = list_amt.get(0);
					}
				}
				if ("000".equals(M_POL_END_TYPE)) {

					COMP_UI_M_FC_AMOUNT.setDisabled(false);
					COMP_UI_M_FC_AMOUNT.setReadonly(false);
					COMP_UI_M_LC_AMOUNT.setDisabled(false);
					COMP_UI_M_LC_AMOUNT.setReadonly(false);
					COMP_UI_M_PREM_GEN_YN.setDisabled(false);
					COMP_UI_M_PREM_GEN_YN.setReadonly(false);
					COMP_UI_M_BROK_GEN_YN.setDisabled(false);
					COMP_UI_M_BROK_GEN_YN.setReadonly(false);
				} else {
					COMP_UI_M_FC_AMOUNT.setDisabled(true);
					COMP_UI_M_LC_AMOUNT.setDisabled(true);
					DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
					COMP_UI_M_PREM_GEN_YN.setDisabled(true);
					COMP_UI_M_BROK_GEN_YN.setDisabled(true);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(resultSetsql_C1);
				CommonUtils.closeCursor(resultSetsql_C2);
				CommonUtils.closeCursor(resultSetsql_C3);
				CommonUtils.closeCursor(resultSetsql_C4);
				CommonUtils.closeCursor(resultSetsql_C16);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_RE_UW_REQ_YN_LABEL() {
		return COMP_UI_M_RE_UW_REQ_YN_LABEL;
	}

	public void setCOMP_UI_M_RE_UW_REQ_YN_LABEL(
			HtmlOutputLabel comp_ui_m_re_uw_req_yn_label) {
		COMP_UI_M_RE_UW_REQ_YN_LABEL = comp_ui_m_re_uw_req_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_RE_UW_REQ_YN() {
		return COMP_UI_M_RE_UW_REQ_YN;
	}

	public void setCOMP_UI_M_RE_UW_REQ_YN(
			HtmlSelectOneMenu comp_ui_m_re_uw_req_yn) {
		COMP_UI_M_RE_UW_REQ_YN = comp_ui_m_re_uw_req_yn;
	}

	public HtmlOutputLabel getCOMP_UI_M_RE_UW_REQ_REASON_LABEL() {
		return COMP_UI_M_RE_UW_REQ_REASON_LABEL;
	}

	public void setCOMP_UI_M_RE_UW_REQ_REASON_LABEL(
			HtmlOutputLabel comp_ui_m_re_uw_req_reason_label) {
		COMP_UI_M_RE_UW_REQ_REASON_LABEL = comp_ui_m_re_uw_req_reason_label;
	}

	public HtmlInputText getCOMP_UI_M_RE_UW_REQ_REASON() {
		return COMP_UI_M_RE_UW_REQ_REASON;
	}

	public void setCOMP_UI_M_RE_UW_REQ_REASON(
			HtmlInputText comp_ui_m_re_uw_req_reason) {
		COMP_UI_M_RE_UW_REQ_REASON = comp_ui_m_re_uw_req_reason;
	}

	public List<SelectItem> getRE_UW_REQ_YN_LIST() {
		return RE_UW_REQ_YN_LIST;
	}

	public void setRE_UW_REQ_YN_LIST(List<SelectItem> re_uw_req_yn_list) {
		RE_UW_REQ_YN_LIST = re_uw_req_yn_list;
	}

	/*
	 * M_RE_UW_REQ_YN When_List_changed
	 */
	public void pilp002_apac_dummy_m_re_uw_req_yn_when_list_changed() {
		if (COMP_UI_M_RE_UW_REQ_YN.getSubmittedValue().equals("Y")) {
			getCOMP_UI_M_RE_UW_REQ_REASON().setDisabled(false);
		} else {
			getCOMP_UI_M_RE_UW_REQ_REASON().setDisabled(true);
		}
	}

	/**
	 * METHOD CALLED ON VALIDATOR FOR UI_M_RE_UW_REQ_YN
	 * 
	 * @param context
	 * @param component
	 * @param value
	 * @throws Exception
	 */
	public void validateUI_M_RE_UW_REQ_YN(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		pilp002_apac_dummy_m_re_uw_req_yn_when_list_changed();
	}

	/**
	 * METHOD CALLED ON a4j support onblur actionListener FOR
	 * COMP_UI_M_TRAN_DATE
	 * 
	 * @param e
	 */
	public void COMP_UI_M_RE_UW_REQ_YN_WHEN_LIST_CHANGED(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String navigateToPolicyEntryScreen() {
		CommonUtils.setGlobalVariable("CALLING_FORM", null);
		PILT002_APAC_COMPOSITE_ACTION pilt002_apacCompositeAction = (PILT002_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
		pilt002_apacCompositeAction.getPT_IL_POLICY_ACTION_BEAN().setBlockFlag(
				true);
		setBlockFlag(true);
		return "toPolicyEntry";
	}

	public DUMMY1 getDUMMY_BEAN1() {
		return DUMMY_BEAN1;
	}

	public void setDUMMY_BEAN1(DUMMY1 dummy_bean1) {
		DUMMY_BEAN1 = dummy_bean1;
	}

	private void pilp002_apac_when_new_form_instance() {
		String M_PS_VALUE = null;
		String M_POL_STATUS = null;

		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		Object[] values = null;
		String M_UI_BROK_YN = null;
		handler = new CRUDHandler();

		try {
			connection = CommonUtils.getConnection();

			resultSet1 = handler.executeSelectStatement(
					PILP002_APAC_SQLConstants.NEW_FORM_INSTANCE_QUERY1,
					connection);
			if (resultSet1.next()) {
				M_PS_VALUE = resultSet1.getString(1);
			}

			// DUMMY_BEAN.setUI_M_RE_UW_REQ_YN("N");
			if (CommonUtils.getGlobalVariable("CALLING_FORM").equalsIgnoreCase(
					"PILT002_APAC")
					|| CommonUtils.getGlobalVariable("CALLING_FORM")
							.equalsIgnoreCase("PILP001_APAC")) {

				DUMMY_BEAN.setUI_M_POL_NO(CommonUtils
						.getGlobalVariable("GLOBAL.M_POL_NO"));

				values = new Object[1];
				values[0] = DUMMY_BEAN.getUI_M_POL_SYS_ID();
				resultSet2 = handler.executeSelectStatement(
						PILP002_APAC_SQLConstants.NEW_FORM_INSTANCE_QUERY2,
						connection, values);
				if (resultSet2.next()) {
					M_POL_STATUS = resultSet2.getString(1);
				}
				// PREMIAGDC-0124 - The Approval Date should be defaulted with
				// Period from date of Policy entry block. Now it is defaulted
				// with
				// system date.

				/*
				 * CommonUtils commonUtils = new CommonUtils();
				 * PILT002_APAC_COMPOSITE_ACTION compositeAction =
				 * (PILT002_APAC_COMPOSITE_ACTION) commonUtils
				 * .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
				 * Date approvalDate =
				 * compositeAction.getPT_IL_POLICY_ACTION_BEAN()
				 * .getPT_IL_POLICY_BEAN().getPOL_START_DT();
				 */

				if ("E".equals(MigratingFunctions.nvl(M_POL_STATUS, "N"))) {
					// DUMMY_BEAN.setUI_M_APPRV_DATE(new Date());
					DUMMY_BEAN.setUI_M_APPRV_DATE(new CommonUtils()
							.getCurrentDate());
					COMP_UI_M_APPRV_DATE.resetValue();
				} else {
					if ("1".equals(M_PS_VALUE)) {
						DUMMY_BEAN.setUI_M_APPRV_DATE((Date) (CommonUtils
								.getGlobalObject("GLOBAL.M_POL_START_DT")));
					} else if ("2".equals(M_PS_VALUE)) {
						// PREMIAGDC-0124 - The Approval Date should be
						// defaulted
						// with Period from date of Policy entry block. Now it
						// is
						// defaulted with system date.
						DUMMY_BEAN.setUI_M_APPRV_DATE(new CommonUtils()
								.getCurrentDate());
					}
				}
				/*
				 * String query_DOC_BROK_YN =
				 * PILP002_APAC_SQLConstants.query_DOC_BROK_YN; String
				 * M_PROD_CODE = null; String M_CUST_CODE = null; String
				 * M_CUST_DESC = null; String query_PROD_CODE =
				 * PILP002_APAC_SQLConstants.query_POL_DETAILS;
				 * 
				 * String query_USER_APPROV =
				 * PILP002_APAC_SQLConstants.query_USER_APPROV; resultSet1 =
				 * handler.executeSelectStatement(query_DOC_BROK_YN, connection,
				 * new Object[] { CommonUtils
				 * .getGlobalVariable("GLOBAL.M_POL_NO") }); while
				 * (resultSet1.next()) { M_UI_BROK_YN = resultSet1.getString(1); }
				 * 
				 * resultSet2 = handler.executeSelectStatement(query_PROD_CODE,
				 * connection, new Object[] { CommonUtils
				 * .getGlobalVariable("GLOBAL.M_POL_NO") }); if
				 * (resultSet2.next()) { M_PROD_CODE = resultSet2.getString(1);
				 * M_CUST_CODE = resultSet2.getString(2); }
				 */
				// DUMMY_BEAN.setUI_M_BROK_GEN_YN(M_UI_BROK_YN);
				// PREMIAGDC-0124 - The Approval Date should be defaulted with
				// Period from date of Policy entry block. Now it is defaulted
				// with
				// system date.
				DUMMY_BEAN.setUI_M_APPRV_DATE(new CommonUtils()
						.getCurrentDate());
				DUMMY_BEAN
						.setUI_M_TRAN_DATE(new CommonUtils().getCurrentDate());
				DUMMY_BEAN.setUI_M_PROCESS_TYPE(CommonUtils
						.getGlobalVariable("GLOBAL.M_PROCESS_TYPE"));

				// this.getCOMP_UI_M_BUT_POL_LOV().setDisabled( true);
				this.getCOMP_UI_M_POL_NO().setDisabled(true);
			}

			/*
			 * DUMMY_BEAN.setUI_M_CUST_CODE(M_CUST_CODE); ArrayList<String>
			 * M_CUST_DESC_LIST = new DBProcedures()
			 * .callP_VAL_CUST(M_CUST_CODE, "N", "N", "HO"); if
			 * (M_CUST_DESC_LIST != null && M_CUST_DESC_LIST.size() > 0) {
			 * M_CUST_DESC = M_CUST_DESC_LIST.get(0); }
			 * DUMMY_BEAN.setUI_M_POL_CUST_DESC(M_CUST_DESC); resultSet3 =
			 * handler.executeSelectStatement(query_USER_APPROV, connection, new
			 * Object[] { CommonUtils.getControlBean().getM_USER_ID(),
			 * M_PROD_CODE }); String M_ASD_CHAR_VALUE = null; if
			 * (resultSet3.next()) { M_ASD_CHAR_VALUE = resultSet3.getString(1); }
			 *  // Setting components if they are not initialized if
			 * (getCOMP_UI_M_PREM_GEN_YN() == null) {
			 * setCOMP_UI_M_PREM_GEN_YN(new HtmlSelectOneMenu()); } if
			 * (getCOMP_UI_M_BROK_GEN_YN() == null) {
			 * setCOMP_UI_M_BROK_GEN_YN(new HtmlSelectOneMenu()); }
			 * 
			 * if ("N".equals(M_ASD_CHAR_VALUE)) {
			 * DUMMY_BEAN.setUI_M_PREM_GEN_YN("Y");
			 * COMP_UI_M_PREM_GEN_YN.setDisabled(true);
			 * COMP_UI_M_BROK_GEN_YN.setDisabled(true); } else {
			 * COMP_UI_M_PREM_GEN_YN.setDisabled(false);
			 * COMP_UI_M_BROK_GEN_YN.setDisabled(false); }
			 */
			// GO_ITEM.GO_ITEM("DUMMY.M_APPRV_DATE");
			// TODO disable the field
			// getCOMP_UI_M_POL_NO().setDisabled(true);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		} finally {

			try {

				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception exc) {
				exc.printStackTrace();
			}
		}
	}

	public ControlBean getControlBean() {
		return controlBean;
	}

	public void setControlBean(ControlBean controlBean) {
		this.controlBean = controlBean;
	}

	public void selectionChanged(ActionEvent ae) {
		UIInput input = (UIInput) ae.getComponent().getParent();
		if ("N".equalsIgnoreCase((String) input.getSubmittedValue())) {
			this.DUMMY_BEAN.setUI_M_BROK_GEN_YN("N");
			getCOMP_UI_M_BROK_GEN_YN().setSubmittedValue(null);
			getCOMP_UI_M_BROK_GEN_YN().setDisabled(true);

		} else if ("Y".equalsIgnoreCase((String) input.getSubmittedValue())) {
			// this.DUMMY_BEAN.setUI_M_BROK_GEN_YN("N");
			getCOMP_UI_M_BROK_GEN_YN().setDisabled(false);
		}

	}

	public void CHECK_PAYMENT_BUTTON_ENABLE() {
		CRUDHandler handler = null;
		ResultSet rst = null;
		String UI_M_POL_END_TYPE = null;
		String UI_M_POL_END_NO_IDX = null;
		String pol_cust_exch_rate = null;
		String UI_M_FC_FIRST_PREM = null;
		Connection connection = null;
		String SELECTQUERY = "SELECT POL_END_TYPE,POL_END_NO_IDX,POL_CUST_EXCH_RATE FROM PT_IL_POLICY WHERE POL_SYS_ID = ?";
		try {
			Long M_POL_SYS_ID = (Long) CommonUtils
					.getGlobalObject("GLOBAL.M_POL_SYS_ID");
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();

			Object[] values = { M_POL_SYS_ID };
			rst = handler.executeSelectStatement(SELECTQUERY, connection,
					values);
			if (rst.next()) {
				UI_M_POL_END_TYPE = rst.getString("POL_END_TYPE");
				UI_M_POL_END_NO_IDX = rst.getString("POL_END_NO_IDX");
				pol_cust_exch_rate = rst.getString("POL_CUST_EXCH_RATE");
			}

			
			
			UI_M_POL_END_TYPE = UI_M_POL_END_TYPE == null ? "000"
					: UI_M_POL_END_TYPE;
			pol_cust_exch_rate = pol_cust_exch_rate == null ? "1"
					: pol_cust_exch_rate;

			if ("000".equals(UI_M_POL_END_TYPE)
					&& "0".equals(UI_M_POL_END_NO_IDX)) {
				COMP_UI_M_BUT_PYMT_DTLS.setDisabled(false);
			} else {
				COMP_UI_M_BUT_PYMT_DTLS.setDisabled(true);
			}
			if ("006".equals(UI_M_POL_END_TYPE)) {
				COMP_UI_M_POL_PREM_WAIVE_INT_RATE.setRendered(true);
				COMP_UI_M_POL_PREM_WAIVE_INT_RATE_LABEL.setRendered(true);
				COMP_UI_M_POL_PREM_WAIVE_YN.setRendered(true);
				COMP_UI_M_POL_PREM_WAIVE_YN_LABEL.setRendered(true);
				COMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL.setRendered(true);
				COMP_UI_M_POL_PREM_WAIVE_TYPE.setRendered(true);
				COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL.setRendered(true);
				COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT.setRendered(true);

			} else {
				COMP_UI_M_POL_PREM_WAIVE_INT_RATE.setRendered(false);
				COMP_UI_M_POL_PREM_WAIVE_INT_RATE_LABEL.setRendered(false);
				COMP_UI_M_POL_PREM_WAIVE_YN.setRendered(false);
				COMP_UI_M_POL_PREM_WAIVE_YN_LABEL.setRendered(false);
				COMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL.setRendered(false);
				COMP_UI_M_POL_PREM_WAIVE_TYPE.setRendered(false);
				COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL.setRendered(false);
				COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT.setRendered(false);

			}
			ArrayList<String> list = DB_Procedures
					.P9ILPK_CHEQ_VALIDATION_L_GET_FIRST_PREM(connection, String
							.valueOf((Long) CommonUtils
									.getGlobalObject("GLOBAL.M_POL_SYS_ID")),
							DUMMY_BEAN.getUI_M_DEP_GROSS_NET_FLAG());

			if (list != null && list.size() > 0) {
				UI_M_FC_FIRST_PREM = list.get(0);
			}

			Double UI_M_LC_AMOUNT = DUMMY_BEAN.getUI_M_LC_AMOUNT();
			if (UI_M_LC_AMOUNT == null) {
				UI_M_LC_AMOUNT = 0.0;
			}
			DB_Procedures.P9ILPK_CHEQ_VALIDATION_P_INS_DEFAULT_PYMT(String
					.valueOf((Long) CommonUtils
							.getGlobalObject("GLOBAL.M_POL_SYS_ID")),
					UI_M_FC_FIRST_PREM, UI_M_LC_AMOUNT + "", "D", "PT",
					pol_cust_exch_rate);

		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void loadingBaseValues(PhaseEvent event) {
		if (isBlockFlag()) {
			CommonUtils.clearMaps(this);
			CHECK_PAYMENT_BUTTON_ENABLE();
			this.getDUMMY_BEAN().setUI_M_CUST_CODE(
					CommonUtils.getGlobalVariable("POL_CUST_CODE"));
			
			try {
				
				pilp002_apac_dummy_m_pol_no_when_validate_item();  
				String cust_name = fetchDesc(this.getDUMMY_BEAN()
						.getUI_M_CUST_CODE());
				this.getDUMMY_BEAN().setUI_M_POL_CUST_DESC(cust_name);

				CommonUtils.setGlobalVariable("POL_CUST_CODE", null);
				if (getWarningMap() != null && getWarningMap().size() > 0) {
					this.getWarningMap().clear();
				}
				CommonUtils.setGlobalObject("COMP_UI_M_BUT_PYMT_DTLS",
						Boolean.TRUE);
				
				/*NEWLY ADDED BY DHINESH ON 12-06-2017*/
				this.getDUMMY_BEAN().setUI_M_END_IDX_TYPE_NO(CommonUtils.getGlobalVariable("GLOBAL.APPRV_SCRN_END_IDX_NO"));
				/*END*/
				
				setBlockFlag(false);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private String fetchDesc(String Code) throws Exception {
		String desc = null;
		String CURSOR_1 = "select cust_name from pm_customer where cust_code=?";
		Connection connection = null;
		ResultSet resultSet = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_1, connection,
					new Object[] { Code });
			if (resultSet.next()) {
				desc = resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return desc;
	}

	public void COMP_UI_M_RE_UW_REQ_REASON_WHEN_VALIDATE_ITEM(ActionEvent e) {
		UIInput input = (UIInput) e.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateUI_M_RE_UW_REQ_REASON(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_RE_UW_REQ_REASON((String) value);
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_GEN_NO() {
		return COMP_UI_M_BUT_DOC_GEN_NO;
	}

	public void setCOMP_UI_M_BUT_DOC_GEN_NO(
			HtmlCommandButton comp_ui_m_but_doc_gen_no) {
		COMP_UI_M_BUT_DOC_GEN_NO = comp_ui_m_but_doc_gen_no;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_FUND_QUERY() {
		return COMP_UI_M_BUT_FUND_QUERY;
	}

	public void setCOMP_UI_M_BUT_FUND_QUERY(
			HtmlCommandButton comp_ui_m_but_fund_query) {
		COMP_UI_M_BUT_FUND_QUERY = comp_ui_m_but_fund_query;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ADD_DETAILS() {
		return COMP_UI_M_BUT_ADD_DETAILS;
	}

	public void setCOMP_UI_M_BUT_ADD_DETAILS(
			HtmlCommandButton comp_ui_m_but_add_details) {
		COMP_UI_M_BUT_ADD_DETAILS = comp_ui_m_but_add_details;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MORE_COVER() {
		return COMP_UI_M_BUT_MORE_COVER;
	}

	public void setCOMP_UI_M_BUT_MORE_COVER(
			HtmlCommandButton comp_ui_m_but_more_cover) {
		COMP_UI_M_BUT_MORE_COVER = comp_ui_m_but_more_cover;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_UDDATE_STAT() {
		return COMP_UI_M_BUT_UDDATE_STAT;
	}

	public void setCOMP_UI_M_BUT_UDDATE_STAT(
			HtmlCommandButton comp_ui_m_but_uddate_stat) {
		COMP_UI_M_BUT_UDDATE_STAT = comp_ui_m_but_uddate_stat;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PRMDTLS() {
		return COMP_UI_M_BUT_PRMDTLS;
	}

	public void setCOMP_UI_M_BUT_PRMDTLS(HtmlCommandButton comp_ui_m_but_prmdtls) {
		COMP_UI_M_BUT_PRMDTLS = comp_ui_m_but_prmdtls;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_POL_AMDT() {
		return COMP_UI_M_BUT_POL_AMDT;
	}

	public void setCOMP_UI_M_BUT_POL_AMDT(
			HtmlCommandButton comp_ui_m_but_pol_amdt) {
		COMP_UI_M_BUT_POL_AMDT = comp_ui_m_but_pol_amdt;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CALC_DISC_LOAD() {
		return COMP_UI_M_BUT_CALC_DISC_LOAD;
	}

	public void setCOMP_UI_M_BUT_CALC_DISC_LOAD(
			HtmlCommandButton comp_ui_m_but_calc_disc_load) {
		COMP_UI_M_BUT_CALC_DISC_LOAD = comp_ui_m_but_calc_disc_load;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANN_DTLS() {
		return COMP_UI_M_BUT_ANN_DTLS;
	}

	public void setCOMP_UI_M_BUT_ANN_DTLS(
			HtmlCommandButton comp_ui_m_but_ann_dtls) {
		COMP_UI_M_BUT_ANN_DTLS = comp_ui_m_but_ann_dtls;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CONVERT() {
		return COMP_UI_M_BUT_CONVERT;
	}

	public void setCOMP_UI_M_BUT_CONVERT(HtmlCommandButton comp_ui_m_but_convert) {
		COMP_UI_M_BUT_CONVERT = comp_ui_m_but_convert;
	}

	public HtmlCommandButton getCOMP_UI_M_BUS_RUL() {
		return COMP_UI_M_BUS_RUL;
	}

	public void setCOMP_UI_M_BUS_RUL(HtmlCommandButton comp_ui_m_bus_rul) {
		COMP_UI_M_BUS_RUL = comp_ui_m_bus_rul;
	}

	public String pilp002_apac_dummy_m_but_ok_when_button_pressed() {
		return "";
	}

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent() {
		// Instantiating HtmlInputText
		COMP_UI_M_RE_UW_REQ_REASON = new HtmlInputText();
		COMP_UI_M_POL_NO = new HtmlInputText();
		COMP_UI_M_CUST_CODE = new HtmlInputText();
		COMP_UI_M_FC_AMOUNT = new HtmlInputText();
		COMP_UI_M_LC_AMOUNT = new HtmlInputText();
		COMP_UI_M_POL_CUST_DESC = new HtmlInputText();
		COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT = new HtmlInputText();
		COMP_UI_POL_END_ISSUANCE = new HtmlInputText();
		
		// Instantiating HtmlOutputLabel
		COMP_UI_M_RE_UW_REQ_YN_LABEL = new HtmlOutputLabel();
		COMP_UI_M_RE_UW_REQ_REASON_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_NO_LABEL = new HtmlOutputLabel();
		COMP_UI_M_APPRV_DATE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_TRAN_DATE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_CUST_CODE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_FC_AMOUNT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_LC_AMOUNT_LABEL = new HtmlOutputLabel();
		COMP_UI_M_PREM_GEN_YN_LABEL = new HtmlOutputLabel();
		COMP_UI_M_BROK_GEN_YN_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_CUST_DESC_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL = new HtmlOutputLabel();
		COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL = new HtmlOutputLabel();
		
		
		// Instantiating HtmlSelectOneMenu
		COMP_UI_M_RE_UW_REQ_YN = new HtmlSelectOneMenu();
		COMP_UI_M_PREM_GEN_YN = new HtmlSelectOneMenu();
		COMP_UI_M_BROK_GEN_YN = new HtmlSelectOneMenu();
		COMP_UI_M_POL_PREM_WAIVE_TYPE = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_UI_M_APPRV_DATE = new HtmlCalendar();
		COMP_UI_M_TRAN_DATE = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_CUST_CODE = new HtmlCommandButton();
		COMP_UI_M_BUT_PREFORMBUTTON = new HtmlCommandButton();
		COMP_UI_M_BUT_PYMT_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_OK = new HtmlCommandButton();
		COMP_UI_M_BUT_CANCEL = new HtmlCommandButton();
		COMP_UI_M_BUT_POL_LOV = new HtmlCommandButton();
		COMP_UI_M_BUT_ENDT = new HtmlCommandButton();
		COMP_UI_M_BUT_APPROVAL = new HtmlCommandButton();
		COMP_UI_M_BUT_CUSTOMER = new HtmlCommandButton();
		COMP_UI_M_BUT_CONTRACTOR = new HtmlCommandButton();
		COMP_UI_M_BUT_HOLD = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_DTL = new HtmlCommandButton();
		COMP_UI_M_BUT_OCC_RATE_PAYOR = new HtmlCommandButton();
		COMP_UI_M_BUT_OCC_RATE_PAYEE = new HtmlCommandButton();
		COMP_UI_M_BUT_DOC_GEN_NO = new HtmlCommandButton();
		COMP_UI_M_BUT_FUND_QUERY = new HtmlCommandButton();
		COMP_UI_M_BUT_ADD_DETAILS = new HtmlCommandButton();
		COMP_UI_M_BUT_MORE_COVER = new HtmlCommandButton();
		COMP_UI_M_BUT_UDDATE_STAT = new HtmlCommandButton();
		COMP_UI_M_BUT_PRMDTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_POL_AMDT = new HtmlCommandButton();
		COMP_UI_M_BUT_CALC_DISC_LOAD = new HtmlCommandButton();
		COMP_UI_M_BUT_ANN_DTLS = new HtmlCommandButton();
		COMP_UI_M_BUT_CONVERT = new HtmlCommandButton();
		COMP_UI_M_BUS_RUL = new HtmlCommandButton();

	}

	public String okButtonAction() throws DBException, ProcedureException {
		PILPK_POLICY_APPROVAL pilpk_policy_approval = new PILPK_POLICY_APPROVAL();
		ArrayList<OracleParameter> list = null;
		CommonUtils.clearMaps(this);
		String P_CALL_FORM_OUT = null;
		String message = "";
		ResultSet agentStatusRS=null;
		ResultSet cust_statusRS=null;
		
		ResultSet maxagentRS   =null;
		

		try {
			
			//Added by Ameen for Agent termination scenario on 30-08-2016
			CommonUtils commonUtil = new CommonUtils();
			PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtil
				    .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
			
			System.out.println("Pol_Sys_id"+CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString());
			
			/*commented by ganesh on 24-10-2017 for ZBLIFE-1447438 as suggested by ajoy. No need to restrict agent on approval */
			/*String BROKER_CODE_Query="SELECT POBH_BROKER_CODE FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID=?";
			agentStatusRS=new CRUDHandler().executeSelectStatement(BROKER_CODE_Query, CommonUtils.getConnection(),new Object[]{
				CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID").toString()});
			String POBH_BROKER_CODE=null;
			while(agentStatusRS.next()){
				POBH_BROKER_CODE=agentStatusRS.getString("POBH_BROKER_CODE");
			}
			System.out.println("POBH_BROKER_CODE     :   "+POBH_BROKER_CODE);
			
			String CUST_STATUS_Query="SELECT CUST_STATUS FROM PM_CUSTOMER WHERE CUST_CODE=?";
			cust_statusRS=new CRUDHandler().executeSelectStatement(CUST_STATUS_Query, CommonUtils.getConnection(),new Object[]{
				POBH_BROKER_CODE});
			String CUST_STATUS=null;
			while(cust_statusRS.next()){
				CUST_STATUS=cust_statusRS.getString("CUST_STATUS");
			}
			System.out.println("CUST_STATUS     :   "+CUST_STATUS);
			
			if(POBH_BROKER_CODE!=null && !(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_NO_IDX()>0 ))
			{
				if((CUST_STATUS!=null)&& CUST_STATUS.equalsIgnoreCase("T"))
				{
					throw new Exception("Agent has been terminated, kindly check and proceed");
				}
			}*/
			/*end*/
			
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			/*
			 * commented By Dhinesh on 10/10/2017 suggested By Ganesh
			 * 
			 * CommonUtils commonUtil = new CommonUtils();
			PILT002_APAC_COMPOSITE_ACTION compositeAction = (PILT002_APAC_COMPOSITE_ACTION) commonUtil
				    .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");*/
			String POL_END_TYPE=compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_END_TYPE();
			System.out.println("Endorsement Type "+POL_END_TYPE);
			if("006".equalsIgnoreCase(POL_END_TYPE)){
			P_CLBCK_REINSTATE(DUMMY_BEAN.getUI_M_POL_SYS_ID(),DUMMY_BEAN.getUI_M_APPRV_DATE());  
			}
			
			/*End*/
			//end for agent termination			
			
			endrosementApprovalFACYN();
			// message = "Policy Approved Successfully";
			new DBProcedures().PCOPK_SYS_VARS(CommonUtils.getConnection());
			list = pilpk_policy_approval.PR_PILP002_APAC(DUMMY_BEAN
					.getUI_M_POL_SYS_ID(), DUMMY_BEAN.getUI_M_FC_AMOUNT(),
					DUMMY_BEAN.getUI_M_LC_AMOUNT(), DUMMY_BEAN
							.getUI_M_AVLB_BAL_FC_AMT(), DUMMY_BEAN
							.getUI_M_AVLB_BAL_LC_AMT(), DUMMY_BEAN
							.getUI_M_POL_ISSUE_DT(), DUMMY_BEAN
							.getUI_M_POL_PROP_NO(),
					DUMMY_BEAN.getUI_M_POL_NO()/* P_POL_NO */, DUMMY_BEAN
							.getUI_M_PLAN_TYPE(), DUMMY_BEAN
							.getUI_M_CUST_CODE(), DUMMY_BEAN
							.getUI_M_BROK_GEN_YN(), DUMMY_BEAN
							.getUI_M_PREM_GEN_YN(), DUMMY_BEAN
							.getUI_M_TRAN_DATE(), null, null, null, null, null,
					null, null, null, P_CALL_FORM_OUT, DUMMY_BEAN
							.getUI_M_APPRV_DATE(), DUMMY_BEAN
							.getUI_M_TRAN_DATE(), DUMMY_BEAN
							.getUI_M_POL_PREM_WAIVE_YN(), DUMMY_BEAN
							.getUI_M_POL_PREM_WAIVE_INT_RATE(), DUMMY_BEAN
							.getUI_M_POL_PREM_WAIVE_TYPE(), DUMMY_BEAN
							.getUI_M_POL_PREM_WAIVE_FIX_AMOUNT());

			if (list != null && !list.isEmpty()) {

				DUMMY_BEAN.setUI_M_BROK_GEN_YN((String) list.get(0)
						.getValueObject());
				DUMMY_BEAN.setUI_M_PREM_GEN_YN((String) list.get(1)
						.getValueObject());
				DUMMY_BEAN.setUI_M_TRAN_DATE((Date) list.get(2)
						.getValueObject());
				/* CHANGED BY RAJA ON 19-08-2017 FRO ZBILQC-1719674 */
				if(DUMMY_BEAN.getUI_M_TRAN_DATE()==null)
				{
					DUMMY_BEAN.setUI_M_TRAN_DATE(new CommonUtils().getCurrentDate());
				}
				/*END*/
				if (null != list.get(3).getValueObject()) {
					DUMMY_BEAN1.setUI_M_AMAN_SHARE((Integer) list.get(3)
							.getValueObject());
				}
				if (null != list.get(4).getValueObject()) {
					DUMMY_BEAN1.setUI_M_SENABEL_SHARE((Integer) list.get(4)
							.getValueObject());
				}
				CommonUtils.setGlobalVariable("GLOBAL.TXN_TYPE", (String) list
						.get(5).getValueObject());
				CommonUtils.setGlobalVariable("GLOBAL.M_SUCCESS", (String) list
						.get(6).getValueObject());
				CommonUtils.setGlobalVariable("GLOBAL.M_SUCC", (String) list
						.get(7).getValueObject());
				DUMMY_BEAN.setM_PRINT_TYPE((String) list.get(8).

				getValueObject());
				DUMMY_BEAN.setUI_M_ERR_IDX((String) list.get(9)
						.getValueObject());
				DUMMY_BEAN.setUI_M_STATUS((String) list.get(10)
						.getValueObject());
				P_CALL_FORM_OUT = (String) list.get(11).getValueObject();
			}
			
			
			
			//added for email trigger  
			CommonUtils commonUtils = new CommonUtils();
			PILT002_APAC_COMPOSITE_ACTION compositeActionsa = (PILT002_APAC_COMPOSITE_ACTION) commonUtils
				    .getMappedBeanFromSession("PILT002_APAC_COMPOSITE_ACTION");
			String pro=compositeActionsa.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_PROD_CODE();
			
			
			/*Added by sankara narayanan for ZBILQC-1721052 on 27/03/2017*/
			String POL_DISP_MTD=compositeActionsa.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_DISPATCH_MTD();
			
			if("P".equalsIgnoreCase(POL_DISP_MTD)){
				/*end*/
				
			long pol_sys_id = DUMMY_BEAN.getUI_M_POL_SYS_ID();
			
			 String P_CUST_TYPE=" ";
				if(getMAIL_SEND_TO().equalsIgnoreCase("CUSTOMER")){
					P_CUST_TYPE="C";
		    	}else if(getMAIL_SEND_TO().equalsIgnoreCase("BROKER")){
		    		P_CUST_TYPE="A";
		    	}else if(getMAIL_SEND_TO().equalsIgnoreCase("BOTH")){
		    		P_CUST_TYPE="B";;
		    	}
				
		/*
		 * Added by ganesh on 06-03-2017 for sending mail with attachment 
		 * of policy schedule on approval button
		 */
				compositeAction_PILP002.getPRINT_ACTION_BEAN().runAction();
				compositeAction_PILP002.getPRINT_ACTION_BEAN().runActionAfterValidate();
				
				/*end*/
		
				
//FALCONQC-1716214 added for email validation message display
				/*Commented the below line for mail purpose
				String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(pro,"POL",String.valueOf(pol_sys_id),P_CUST_TYPE,"");
				End*/
				//Added a new line by ganesh for for sending mail with attachment
				/*
				 * commented by Ameen on 18-07-2017 for ZBILQC-1731923 ,vikram sir suggestted to send mail without policy schedule attachment
				 * String emailStatusMessage = compositeAction_PILP002.getPRINT_ACTION_BEAN().sendGet(compositeAction_PILP002.getPRINT_ACTION_BEAN().getRedirectUrl(),pro,P_CUST_TYPE,"POL");*/
				/*Commented and Modified by pidugu raj dt: 03-12-2020 as suggested by kuzhandaivel
				 * String emailStatusMessage = Email_Procedure_Call.emailStatusMsg(pro,
						"POL", CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")
						.toString(), P_CUST_TYPE, "");
				//end
*/		
				
				String emailStatusMessage = null;
				if(compositeActionsa.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_STATUS().equalsIgnoreCase("R")){
					emailStatusMessage = Email_Procedure_Call.emailStatusMsg(pro,
							"REI", CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")
							.toString(), P_CUST_TYPE, "");
				}else{
				
				emailStatusMessage = Email_Procedure_Call.emailStatusMsg(pro,
						"POL", CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")
						.toString(), P_CUST_TYPE, "");
				}
				//end
				System.out.println("EMAIL STATUS MESSAGE-->"+emailStatusMessage);
			   message = message + emailStatusMessage;
			
		/*
				if("Y".equalsIgnoreCase(emailTriggerProcCall(pro,"POL",String.valueOf(pol_sys_id),P_CUST_TYPE,""))){
					message=message+"\n"+"Mail Sent Sucessfully";		
				}else{
					if(P_CUST_TYPE.equalsIgnoreCase("C"))
						message=message+"\n"+"- Unable to send mail to Customer due to emailId is not available";	
					else if(P_CUST_TYPE.equalsIgnoreCase("A"))
						message=message+"\n"+"- Unable to send mail to Agent due to emailId is not available";	
					else
						message=message+"\n"+"- Unable to send mail to Agent OR Customer due to emailId is not available";	
				}
			*/
			   		getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						message);
			
			// getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
			// message);
			// getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
			// message);
			}else if("D".equalsIgnoreCase(POL_DISP_MTD)){
				String emailStatusMessage =Email_Procedure_Call.emailStatusMsg(pro,
						"EDC", CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")
								.toString(), "C", "");
				  message = message + emailStatusMessage;
				  getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
							message);
				
				  
			}else if("A".equalsIgnoreCase(POL_DISP_MTD)){
				String emailStatusMessage =Email_Procedure_Call.emailStatusMsg(pro,
						"ETA", CommonUtils.getGlobalObject("GLOBAL.M_POL_SYS_ID")
								.toString(), "B", "");
				 message = message + emailStatusMessage;
				  getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
							message);
				
			}
			
			/* Newly added by Dhinesh on 29.3.2017 */ 
			if("075".equalsIgnoreCase(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SRC_OF_BUS()))
					{
						String Max_AgentCODE_Query="SELECT POBH_BROKER_CODE FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ? AND "
							+ "POBH_AGENT_LEVEL = (SELECT MAX(POBH_AGENT_LEVEL)"
							+ "FROM PT_IL_POL_BROKER_HEAD WHERE POBH_POL_SYS_ID = ?)";
					
						maxagentRS=new CRUDHandler().executeSelectStatement(Max_AgentCODE_Query, CommonUtils.getConnection(),new Object[]{
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_SYS_ID()});
					String MAX_POBH_BROKER_CODE=null;
					while(maxagentRS.next()){
						MAX_POBH_BROKER_CODE=maxagentRS.getString("POBH_BROKER_CODE");
					}	
					
					if(MAX_POBH_BROKER_CODE != null)
					{
					list = pilpk_policy_approval.PR_PRODUCT_WISE_BROKER(MAX_POBH_BROKER_CODE,commonUtil.getCurrentDate());
					}
					
					}
					
			/* End */		
			
			/*Newly added by pidugu raj and commented dt: 11-10-2018 for kic excess comission issue as suggested by vaitheeswaran*/
			CommonUtils utils = new CommonUtils();
			/*CALC_AGENT_TOPUP_COMM_EXCESS(compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO(),
					compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN().getPOL_NO(),
					utils.getCurrentDate(),
					utils.getCurrentDate());*/
			/*End*/
		} catch (Exception e) {
 			e.printStackTrace();
			// ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());

		} finally {
			System.out.println("enter finally ");
			ErrorHelpUtil.getWarningsforProcedureAction(connection,
					FacesContext.getCurrentInstance(), "convertOKButtonAction",
					getWarningMap());
			System.out.println("after error thrown-->"+getWarningMap().get("current"));
			getWarningMap().put("current",getWarningMap().get("current")+" "+message);
			
			
		}
		return P_CALL_FORM_OUT;
	}
	private void CALC_AGENT_TOPUP_COMM_EXCESS(String pol_NO, String pol_NO2,
			Date currentDate, Date currentDate2) {
		try{
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	    OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",pol_NO);
	    parameterList.add(param1);
	    OracleParameter param2 = new OracleParameter("IN1", "STRING", "IN",pol_NO2);
	    parameterList.add(param2);
	    OracleParameter param3 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, currentDate);
	    parameterList.add(param3);
	    OracleParameter param4 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, currentDate2);
	    parameterList.add(param4);
	  
	
	    OracleProcedureHandler procHandler = new OracleProcedureHandler();
	    procHandler.execute(parameterList, connection, "P9ILPK_AGENCY_MGMT.CALC_AGENT_TOPUP_COMM_EXCESS");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	/*
	 * public String mainButtonAction(){ setBlockFlag(true); return
	 * "PILT002_APAC_PT_IL_POLICY"; }
	 */

	public ArrayList<LovBean> lovUI_M_CUST_CODE(Object object) {
		Connection connection = null;
		ResultSet rs = null;
		String M_POL_CASH_YN = null;
		String M_POL_DIVN_CODE = null;
		String mainQry = "SELECT CUST_CODE,CUST_NAME,CUST_BL_NAME "
				+ " FROM PM_CUSTOMER WHERE CUST_CLASS IN "
				+ " (SELECT CCLAS_CODE FROM PM_CUST_CLASS, PP_SYSTEM "
				+ " WHERE DECODE(PS_VALUE,2,CCLAS_CODE, CCLAS_TYPE) IN "
				+ " (?)) AND CUST_FRZ_FLAG = 'N' AND (CUST_APPL_ALL_BRAN_YN = 'Y'"
				+ " OR CUST_CODE IN "
				+ " (SELECT CDIV_CUST_CODE FROM PM_CUST_DIVN "
				+ " WHERE CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE))) AND "
				+ "(CUST_CODE LIKE ? OR CUST_NAME LIKE ? OR  CUST_BL_NAME LIKE ?)AND  ROWNUM < 25 order by 1";

		String C1 = "  SELECT   POL_CASH_YN ,POL_DIVN_CODE FROM     PT_IL_POLICY   WHERE      POL_SYS_ID = ?";
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		Object[] values = null;
		String currentValue = (String) object;
		try {
			connection = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(C1, connection,
					new Object[] { DUMMY_BEAN.getUI_M_POL_SYS_ID() });

			while (rs.next()) {
				M_POL_CASH_YN = rs.getString(1);
				M_POL_DIVN_CODE = rs.getString(2);
			}
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			mainQry = prepareCustomerQuery(mainQry, new Object[] { "CASH" });
			values = new Object[] { M_POL_DIVN_CODE, currentValue,
					currentValue, currentValue };
			if ("Y".equals(M_POL_CASH_YN)) {
				suggestionList = ListItemUtil.prepareSuggestionList(mainQry,
						values);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return suggestionList;
	}

	public String prepareCustomerQuery(String CustCodeQuery, Object[] values) {
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String query_input = "";
		String subQry = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(subQry, connection,
					values);
			if (resultSet.next()) {
				query_input = resultSet.getString("PS_CODE_DESC");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		CustCodeQuery = CustCodeQuery.replaceFirst("\\?", query_input);
		return CustCodeQuery;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PREM_WAIVE_YN_LABEL() {
		return COMP_UI_M_POL_PREM_WAIVE_YN_LABEL;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_YN_LABEL(
			HtmlOutputLabel comp_ui_m_pol_prem_waive_yn_label) {
		COMP_UI_M_POL_PREM_WAIVE_YN_LABEL = comp_ui_m_pol_prem_waive_yn_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_POL_PREM_WAIVE_YN() {
		return COMP_UI_M_POL_PREM_WAIVE_YN;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_YN(
			HtmlSelectOneMenu comp_ui_m_pol_prem_waive_yn) {
		COMP_UI_M_POL_PREM_WAIVE_YN = comp_ui_m_pol_prem_waive_yn;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PREM_WAIVE_INT_RATE_LABEL() {
		return COMP_UI_M_POL_PREM_WAIVE_INT_RATE_LABEL;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_INT_RATE_LABEL(
			HtmlOutputLabel comp_ui_m_pol_prem_waive_int_rate_label) {
		COMP_UI_M_POL_PREM_WAIVE_INT_RATE_LABEL = comp_ui_m_pol_prem_waive_int_rate_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_PREM_WAIVE_INT_RATE() {
		return COMP_UI_M_POL_PREM_WAIVE_INT_RATE;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_INT_RATE(
			HtmlInputText comp_ui_m_pol_prem_waive_int_rate) {
		COMP_UI_M_POL_PREM_WAIVE_INT_RATE = comp_ui_m_pol_prem_waive_int_rate;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL() {
		return COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL(
			HtmlOutputLabel comp_ui_m_pol_prem_waive_fix_amount_label) {
		COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT_LABEL = comp_ui_m_pol_prem_waive_fix_amount_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_POL_PREM_WAIVE_TYPE() {
		return COMP_UI_M_POL_PREM_WAIVE_TYPE;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_TYPE(
			HtmlSelectOneMenu comp_ui_m_pol_prem_waive_type) {
		COMP_UI_M_POL_PREM_WAIVE_TYPE = comp_ui_m_pol_prem_waive_type;
	}

	public HtmlInputText getCOMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT() {
		return COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT(
			HtmlInputText comp_ui_m_pol_prem_waive_fix_amount) {
		COMP_UI_M_POL_PREM_WAIVE_FIX_AMOUNT = comp_ui_m_pol_prem_waive_fix_amount;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL() {
		return COMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL;
	}

	public void setCOMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_pol_prem_waive_type_label) {
		COMP_UI_M_POL_PREM_WAIVE_TYPE_LABEL = comp_ui_m_pol_prem_waive_type_label;
	}

public void endrosementApprovalFACYN() throws Exception{
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
	ArrayList<String> pValList = new ArrayList<String>();
	ResultSet resultSet = null;
	CRUDHandler handler = new CRUDHandler();
	String M_USER_PERM = null;
	String PRODCODE = null;
	String ENDCODE = null;
	Integer endidx=0;
	String FACyn = null;
	String subQry = "SELECT POL_PROD_CODE,POL_END_CODE,POL_END_NO_IDX,POL_FAC_YN FROM PT_IL_POLICY WHERE POL_NO=?";
	try{
		Connection connection = CommonUtils.getConnection();
		resultSet = handler.executeSelectStatement(subQry, connection,
				new Object[]{DUMMY_BEAN.getUI_M_POL_NO()});
		if (resultSet.next()) {
			PRODCODE = resultSet.getString(1);
			ENDCODE = resultSet.getString(2);
			endidx = resultSet.getInt(3);
			FACyn= resultSet.getString(4);
		}
		if(endidx>0){
		pValList = new ArrayList<String>();

		pValList = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(CommonUtils
				.getControlBean().getM_USER_ID(), "FAC_YN",
				PRODCODE, "2", M_USER_PERM,
				ENDCODE);
		if (!pValList.isEmpty() && pValList.get(0) != null){
			M_USER_PERM = pValList.get(0);
		
		}
			if("N".equalsIgnoreCase(M_USER_PERM)){
				if("Y".equalsIgnoreCase(FACyn)){
					throw new Exception("The user is not authorized to approve this record");
				}
				
			}
		}
	
		
	}catch (Exception e) {
	// TODO: handle exception
	e.printStackTrace();
	throw new Exception(e.getMessage());
}
	
}
//added by saranya on 8-4-16 for email capture
public void validatorMAIL_SEND_TO_TYPE(FacesContext context,
		UIComponent component, Object value) {
	try {
		System.out.println("*********** Enter the validatorQUESTIONNAIRE_TYPE *************");
		setMAIL_SEND_TO(value.toString());
		System.out.println("getMAIL_SEND_TO : "+getMAIL_SEND_TO());
	} catch (Exception e) {
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	}
}

public ArrayList<SelectItem> MAIL_SEND_TO_LIST(){

	ArrayList<SelectItem> list = null;
	SelectItem selectItem =null;
	try {
		list = new ArrayList<SelectItem>();

		System.out.println("****************   BROKER_MAIL_ID_LIST   *****************");
		
		selectItem = new SelectItem();
		selectItem.setLabel("CUSTOMER");
		selectItem.setValue("CUSTOMER");
		list.add(selectItem);
		
		selectItem = new SelectItem();
		selectItem.setLabel("BROKER");
		selectItem.setValue("BROKER");
		list.add(selectItem);
		
		selectItem = new SelectItem();
		selectItem.setLabel("BOTH");
		selectItem.setValue("BOTH");
		list.add(selectItem);		
	}catch(Exception e)
	{
		e.printStackTrace();
	}return list;
	}
//end
public String emailTriggerProcCall(String P_PROD_CODE,String P_MAIL_TYPE, String P_POL_SYS_ID, String P_CUST_TYPE,String P_MAIL_PATH) throws Exception{
	
	System.out.println("pol_sus_id"+P_POL_SYS_ID);
	Connection con=CommonUtils.getConnection();
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
    OracleProcedureHandler procHandler = new OracleProcedureHandler();
    outputList = procHandler.execute(parameterList, con,
            "P_MAIL_TEMP");
    CommonUtils.doComitt();
    Iterator<OracleParameter> iterator = outputList.iterator();
    while (iterator.hasNext()) {
        OracleParameter oracleParameter = iterator.next();
        System.out.println("Output value:::" + oracleParameter.getValue());
		out=(String)oracleParameter.getValue();
    }
	return out;
	}
	/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
	public ArrayList<OracleParameter> P_CLBCK_REINSTATE(Long P_POL_SYS_ID, Date P_DATE)throws ProcedureException {
		 Connection connection = null;
		 ArrayList<OracleParameter> parameterList = null;
		 ArrayList<OracleParameter> outputList = null;
		 try {
		 	connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
          OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.LONG, OracleParameter.DIRECTION_TYPE.IN, P_POL_SYS_ID);
          parameterList.add(param1);
          OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_DATE);
          parameterList.add(param2);
         OracleProcedureHandler procHandler = new OracleProcedureHandler();
         System.out.println("Clawback re-instate procedure");
          outputList = procHandler.executeProc(parameterList, connection,
                 "P9ILPK_PREM_COLL.P_CLBCK_REINSTATE");
       } catch(Exception e) {
       	ErrorHelpUtil.getErrorForProcedure(connection);
              throw new ProcedureException(e.getMessage());
       }
      return outputList;
  }
	
	/*End*/
	
}
