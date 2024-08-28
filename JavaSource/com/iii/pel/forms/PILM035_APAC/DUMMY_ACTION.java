package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_M_SRC_PROD_CODE_LABEL;

	private HtmlInputText COMP_M_SRC_PROD_CODE;

	private HtmlInputText COMP_M_SRC_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_M_DEST_PROD_CODE_LABEL;

	private HtmlInputText COMP_M_DEST_PROD_CODE;

	private HtmlOutputLabel COMP_M_DEST_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_M_DEST_PROD_CODE_DESC;

	private HtmlInputText COMP_UI_M_PLAN_PERIOD_FROM;

	private HtmlInputText COMP_UI_M_PLAN_PERIOD_TO;

	private HtmlInputText COMP_UI_M_PLAN_MAX_AGE_ON_MAT;

	private HtmlInputText COMP_UI_M_PROD_SA_INST_PYMT_TYPE;
	
	//[ADDED BY AKASH TO IMPLEMENT PRODUCT COPY FROM P10 DATED 26.NOV.2012
	
	private HtmlOutputLabel COMP_UI_OLD_CVR_CODE_LABEL;
	
	private HtmlInputText COMP_UI_OLD_CVR_CODE;
	
	private HtmlOutputLabel COMP_UI_NEW_CVR_CODE_LABEL;
	
	private HtmlInputText COMP_UI_NEW_CVR_CODE;
	
	private HtmlOutputLabel COMP_UI_CVR_CHECK_LABEL;
	
	private HtmlOutputLabel COMP_UI_PLAN_CHECK_LABEL;
	
	private HtmlOutputLabel COMP_UI_TRF_CHECK_LABEL;
	
	private HtmlSelectBooleanCheckbox COMP_UI_CVR_CHECK;
	
	private HtmlSelectBooleanCheckbox COMP_UI_PLAN_CHECK;
	
	private HtmlSelectBooleanCheckbox COMP_UI_TRF_CHECK;
	
	//ADDED BY AKASH TO IMPLEMENT PRODUCT COPY FROM P10 ]

	private HtmlInputText COMP_UI_M_DUMMY;

	private HtmlInputText COMP_UI_M_DUMMY1;

	private HtmlCommandButton COMP_APPL_SUB_PLANS;

	private HtmlCommandButton COMP_M_BUT_TOPUP_PARAM;

	private HtmlCommandButton COMP_UI_M_COPY_BUTT;
	
	
	private HtmlCommandButton COMP_UI_M_UPLOAD_BUTT;
	public HtmlCommandButton getCOMP_UI_M_UPLOAD_BUTT() {
		return COMP_UI_M_UPLOAD_BUTT;
	}

	public void setCOMP_UI_M_UPLOAD_BUTT(HtmlCommandButton cOMP_UI_M_UPLOAD_BUTT) {
		COMP_UI_M_UPLOAD_BUTT = cOMP_UI_M_UPLOAD_BUTT;
	}

	
	
	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;

	private HtmlInputText COMP_UI_M_PAC_SA_FACTOR;
	private HtmlInputText COMP_UI_M_PAC_SA_TARIFF;
	private HtmlInputText COMP_UI_M_PAC_PREM_TARIFF;
	private HtmlInputText COMP_UI_M_PAC_SA_ADD_FACTOR;

	public DUMMY DUMMY_BEAN;
	public PILM035_APAC_COMPOSITE_ACTION compositeAction;

	public DUMMY_ACTION() {

		DUMMY_BEAN = new DUMMY();
		COMP_APPL_SUB_PLANS = new HtmlCommandButton();
		COMP_M_BUT_TOPUP_PARAM = new HtmlCommandButton();
		COMP_UI_M_PLAN_PERIOD_FROM = new HtmlInputText();
		COMP_UI_M_PLAN_PERIOD_TO = new HtmlInputText();
		COMP_UI_M_PLAN_MAX_AGE_ON_MAT = new HtmlInputText();
	}

	public List<LovBean> lovM_SRC_PROD_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM035_APAC", "DUMMY",
					"M_SRC_PROD_CODE", null, null, null, null, null,
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

	public void M_SRC_PROD_CODE_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getDUMMY_BEAN().setUI_M_SRC_PROD_CODE((String) value);
			WHEN_VALIDATE_M_SRC_PROD_CODE(compositeAction);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void WHEN_VALIDATE_M_SRC_PROD_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {

		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		String M_PROD_DESC = null;

		String C1 = "SELECT  PROD_DESC " + "FROM  PM_IL_PRODUCT "
				+ "WHERE  PROD_CODE = ?";
		Connection con = null;
		ResultSet rs1 = null;
		Object[] c1values = null;
		CRUDHandler handler = new CRUDHandler();

		try {
			con = CommonUtils.getConnection();
			if (dummy_bean.getUI_M_SRC_PROD_CODE() != null) {
				c1values = new Object[] { dummy_bean.getUI_M_SRC_PROD_CODE() };
				rs1 = handler.executeSelectStatement(C1, con, c1values);
				while (rs1.next()) {
					M_PROD_DESC = rs1.getString(1);
				}
				if (M_PROD_DESC == null || "".equalsIgnoreCase(M_PROD_DESC)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91074"));
				} else {
					dummy_bean.setUI_M_SRC_PROD_CODE_DESC(M_PROD_DESC);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				defaultOnloadValues();
				setBlockFlag(false);
			}
			System.out.println("onLoad");
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String okAction() {
		String M_WHERE = null;
		// PILM035_APAC_COMPOSITE_ACTION comp
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] c1values = null;
		String ROW_ID = null;
		String outcome = null;
		try {
			con = CommonUtils.getConnection();
			if (DUMMY_BEAN.getUI_M_DEST_PROD_CODE() != null) {
				new P9ILPK_PRODUCT_COPY().L_COPY_PRODUCT(
						DUMMY_BEAN.getUI_M_SRC_PROD_CODE(), 
						DUMMY_BEAN.getUI_OLD_CVR_CODE(), 
						DUMMY_BEAN.getUI_M_DEST_PROD_CODE(), 
						DUMMY_BEAN.getUI_NEW_CVR_CODE(), 
						DUMMY_BEAN.getUI_M_DEST_PROD_CODE_DESC(), 
						DUMMY_BEAN.getCvrCheck(), 
						DUMMY_BEAN.getPlanCheck(), 
						DUMMY_BEAN.getTrfCheck());
				System.out.println("1"+DUMMY_BEAN.getUI_M_SRC_PROD_CODE());
				System.out.println("2"+DUMMY_BEAN.getUI_OLD_CVR_CODE());
				System.out.println("3"+DUMMY_BEAN.getUI_M_DEST_PROD_CODE());
				System.out.println("4"+DUMMY_BEAN.getUI_NEW_CVR_CODE());
				System.out.println("5"+DUMMY_BEAN.getUI_M_DEST_PROD_CODE_DESC());
				System.out.println("6"+DUMMY_BEAN.getCvrCheck());
				System.out.println("7"+DUMMY_BEAN.getPlanCheck());
				System.out.println("8"+DUMMY_BEAN.getTrfCheck());
				
				
				//L_COPY_PRODUCT(compositeAction);
				//CommonUtils.getConnection().commit();
				String rowid_query = "SELECT ROWID FROM PM_IL_PRODUCT where prod_code = ?";
				c1values = new Object[] { DUMMY_BEAN.getUI_M_DEST_PROD_CODE() };
				rs1 = handler
						.executeSelectStatement(rowid_query, con, c1values);
				while (rs1.next()) {
					ROW_ID = rs1.getString(1);
				}

				// Preparing to query new copied product
				compositeAction = new PILM035_APAC_COMPOSITE_ACTION();
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
						.getPM_IL_PRODUCT_BEAN().setROWID(ROW_ID);
				CommonUtils.setGlobalObject("PILM035_APAC_COMPOSITE_ACTION",
						compositeAction);
				outcome = "PILM035_APAC_PM_IL_PRODUCT";
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getWarningMap()
						.put("current", "Copied Done Successfully");
				compositeAction.getPM_IL_PRODUCT_ACTION_BEAN().getWarningMap()
						.put("current", "Copied Done Successfully");
			}
		} catch (Exception e) {
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("current", e.getMessage());
		}
		return outcome;
	}

	public String cancelAction() {

		return "PILM035_APAC_PM_IL_PRODUCT";
	}

	public HtmlInputText getCOMP_UI_M_PAC_SA_FACTOR() {
		return COMP_UI_M_PAC_SA_FACTOR;
	}

	public void setCOMP_UI_M_PAC_SA_FACTOR(HtmlInputText comp_ui_m_pac_sa_factor) {
		COMP_UI_M_PAC_SA_FACTOR = comp_ui_m_pac_sa_factor;
	}

	public HtmlInputText getCOMP_UI_M_PAC_SA_TARIFF() {
		return COMP_UI_M_PAC_SA_TARIFF;
	}

	public void setCOMP_UI_M_PAC_SA_TARIFF(HtmlInputText comp_ui_m_pac_sa_tariff) {
		COMP_UI_M_PAC_SA_TARIFF = comp_ui_m_pac_sa_tariff;
	}

	public HtmlInputText getCOMP_UI_M_PAC_PREM_TARIFF() {
		return COMP_UI_M_PAC_PREM_TARIFF;
	}

	public void setCOMP_UI_M_PAC_PREM_TARIFF(
			HtmlInputText comp_ui_m_pac_prem_tariff) {
		COMP_UI_M_PAC_PREM_TARIFF = comp_ui_m_pac_prem_tariff;
	}

	public HtmlInputText getCOMP_UI_M_PAC_SA_ADD_FACTOR() {
		return COMP_UI_M_PAC_SA_ADD_FACTOR;
	}

	public void setCOMP_UI_M_PAC_SA_ADD_FACTOR(
			HtmlInputText comp_ui_m_pac_sa_add_factor) {
		COMP_UI_M_PAC_SA_ADD_FACTOR = comp_ui_m_pac_sa_add_factor;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(
			HtmlCommandButton comp_ui_m_but_bilingual) {
		COMP_UI_M_BUT_BILINGUAL = comp_ui_m_but_bilingual;
	}

	public HtmlCommandButton getCOMP_UI_M_COPY_BUTT() {
		return COMP_UI_M_COPY_BUTT;
	}

	public void setCOMP_UI_M_COPY_BUTT(HtmlCommandButton comp_ui_m_copy_butt) {
		COMP_UI_M_COPY_BUTT = comp_ui_m_copy_butt;
	}

	public HtmlOutputLabel getCOMP_M_DEST_PROD_CODE_LABEL() {
		return COMP_M_DEST_PROD_CODE_LABEL;
	}

	public void setCOMP_M_DEST_PROD_CODE_LABEL(
			HtmlOutputLabel comp_m_dest_prod_code_label) {
		COMP_M_DEST_PROD_CODE_LABEL = comp_m_dest_prod_code_label;
	}

	public HtmlInputText getCOMP_M_DEST_PROD_CODE() {
		return COMP_M_DEST_PROD_CODE;
	}

	public void setCOMP_M_DEST_PROD_CODE(HtmlInputText comp_m_dest_prod_code) {
		COMP_M_DEST_PROD_CODE = comp_m_dest_prod_code;
	}

	public HtmlOutputLabel getCOMP_M_DEST_PROD_CODE_DESC_LABEL() {
		return COMP_M_DEST_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_M_DEST_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_m_dest_prod_code_desc_label) {
		COMP_M_DEST_PROD_CODE_DESC_LABEL = comp_m_dest_prod_code_desc_label;
	}

	public HtmlInputText getCOMP_M_DEST_PROD_CODE_DESC() {
		return COMP_M_DEST_PROD_CODE_DESC;
	}

	public void setCOMP_M_DEST_PROD_CODE_DESC(
			HtmlInputText comp_m_dest_prod_code_desc) {
		COMP_M_DEST_PROD_CODE_DESC = comp_m_dest_prod_code_desc;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}

	public HtmlCommandButton getCOMP_APPL_SUB_PLANS() {
		return COMP_APPL_SUB_PLANS;
	}

	public void setCOMP_APPL_SUB_PLANS(HtmlCommandButton comp_appl_sub_plans) {
		COMP_APPL_SUB_PLANS = comp_appl_sub_plans;
	}

	public HtmlCommandButton getCOMP_M_BUT_TOPUP_PARAM() {
		return COMP_M_BUT_TOPUP_PARAM;
	}

	public void setCOMP_M_BUT_TOPUP_PARAM(
			HtmlCommandButton comp_m_but_topup_param) {
		COMP_M_BUT_TOPUP_PARAM = comp_m_but_topup_param;
	}

	public HtmlOutputLabel getCOMP_M_SRC_PROD_CODE_LABEL() {
		return COMP_M_SRC_PROD_CODE_LABEL;
	}

	public void setCOMP_M_SRC_PROD_CODE_LABEL(
			HtmlOutputLabel comp_m_src_prod_code_label) {
		COMP_M_SRC_PROD_CODE_LABEL = comp_m_src_prod_code_label;
	}

	public HtmlInputText getCOMP_M_SRC_PROD_CODE() {
		return COMP_M_SRC_PROD_CODE;
	}

	public void setCOMP_M_SRC_PROD_CODE(HtmlInputText comp_m_src_prod_code) {
		COMP_M_SRC_PROD_CODE = comp_m_src_prod_code;
	}

	public HtmlInputText getCOMP_M_SRC_PROD_CODE_DESC() {
		return COMP_M_SRC_PROD_CODE_DESC;
	}

	public void setCOMP_M_SRC_PROD_CODE_DESC(
			HtmlInputText comp_m_src_prod_code_desc) {
		COMP_M_SRC_PROD_CODE_DESC = comp_m_src_prod_code_desc;
	}

	public void L_COPY_PRODUCT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();

		int M_P9IL_PWPH_SYS_ID = 0;
		int M_PWPH_SYS_ID = 0;

		String M_DEST_PROD_CODE = dummy_bean.getUI_M_DEST_PROD_CODE();
		String M_SRC_PROD_CODE = dummy_bean.getUI_M_SRC_PROD_CODE();
		String M_DEST_PROD_CODE_DESC = dummy_bean.getUI_M_DEST_PROD_CODE_DESC();

		String C1 = "SELECT P9IL_PWPH_SYS_ID.CURRVAL " + "FROM DUAL";

		String C2 = "SELECT PWPH_SYS_ID " + "FROM PM_IL_PROD_WD_PARAM_HDR "
				+ "WHERE PWPH_PROD_CODE =?";

		String PM_IL_PROD_APPL_FUND_INS_QRY = "INSERT INTO PM_IL_PROD_APPL_FUND "
				+ "(PAF_PROD_CODE, PAF_FUND_CODE, PAF_FUND_PERC, PAF_DEFAULT_YN, "
				+ "PAF_CR_DT, PAF_CR_UID, PAF_UPD_DT, PAF_UPD_UID, PAF_FUND_DIR_TYPE) "
				+ "SELECT "
				+ M_DEST_PROD_CODE
				+ ", PAF_FUND_CODE, PAF_FUND_PERC, "
				+ "PAF_DEFAULT_YN, PAF_CR_DT, PAF_CR_UID, PAF_UPD_DT, PAF_UPD_UID, PAF_FUND_DIR_TYPE "
				+ "FROM  PM_IL_PROD_APPL_FUND "
				+ "WHERE PAF_PROD_CODE = "
				+ M_DEST_PROD_CODE + " ";

		String PM_IL_PROD_PREM_LIMIT_INS_QRY = "INSERT INTO PM_IL_PROD_PREM_LIMIT "
				+ "(PPL_PROD_CODE, "
				+ "PPL_MODE_OF_PYMT, "
				+ "PPL_LC_MIN_PREM, "
				+ "PPL_LC_MAX_PREM, "
				+ "PPL_CR_DT, "
				+ "PPL_CR_UID, "
				+ "PPL_UPD_DT, "
				+ "PPL_UPD_UID, "
				+ "PPL_CHECK_BASIS, "
				+ "PPL_FM_TERM, "
				+ "PPL_TO_TERM) "
				+ "SELECT "
				+ ""
				+ M_DEST_PROD_CODE
				+ ", "
				+ "PPL_MODE_OF_PYMT, "
				+ "PPL_LC_MIN_PREM, "
				+ "PPL_LC_MAX_PREM, "
				+ "PPL_CR_DT, "
				+ "PPL_CR_UID, "
				+ "PPL_UPD_DT, "
				+ "PPL_UPD_UID, "
				+ "PPL_CHECK_BASIS, "
				+ "PPL_FM_TERM, "
				+ "PPL_TO_TERM "
				+ "FROM  PM_IL_PROD_PREM_LIMIT "
				+ "WHERE PPL_PROD_CODE = "
				+ M_DEST_PROD_CODE + "";

		String PM_IL_PROD_APPL_LOAD_TARIFF_INS_QRY = "INSERT INTO PM_IL_PROD_APPL_LOAD_TARIFF "
				+ "(PALT_PROD_CODE, "
				+ "PALT_TH_CODE, "
				+ "PALT_CR_DT, "
				+ "PALT_CR_UID, "
				+ "PALT_UPD_DT, "
				+ "PALT_UPD_UID, "
				+ "PALT_TH_PARAM_TYPE, "
				+ "PALT_LOAD_APPL_PERC, "
				+ "PALT_SRNO, "
				+ "PALT_APPLIED_ON, "
				+ "PALT_APPL_UPTO, "
				+ "PALT_DEFAULT_YN) "
				+ "SELECT "
				+ ""
				+ M_DEST_PROD_CODE
				+ ", "
				+ "PALT_TH_CODE, "
				+ "PALT_CR_DT, "
				+ "PALT_CR_UID, "
				+ "PALT_UPD_DT, "
				+ "PALT_UPD_UID, "
				+ "PALT_TH_PARAM_TYPE, "
				+ "PALT_LOAD_APPL_PERC, "
				+ "PALT_SRNO, "
				+ "PALT_APPLIED_ON, "
				+ "PALT_APPL_UPTO, "
				+ "PALT_DEFAULT_YN "
				+ "FROM PM_IL_PROD_APPL_LOAD_TARIFF "
				+ "WHERE PALT_PROD_CODE = " + M_DEST_PROD_CODE + "";

		String PM_IL_PROD_APPL_BONUS_INS_QRY = "INSERT INTO PM_IL_PROD_APPL_BONUS "
				+ "(PAB_PROD_CODE, "
				+ "PAB_BONUS_CODE, "
				+ "PAB_CR_DT, "
				+ "PAB_CR_UID, "
				+ "PAB_UPD_DT, "
				+ "PAB_UPD_UID) "
				+ "SELECT "
				+ ""
				+ M_DEST_PROD_CODE
				+ " "
				+ "PAB_BONUS_CODE, "
				+ "PAB_CR_DT, "
				+ "PAB_CR_UID, "
				+ "PAB_UPD_DT, "
				+ "PAB_UPD_UID "
				+ "FROM PM_IL_PROD_APPL_BONUS "
				+ "WHERE PAB_PROD_CODE = " + M_DEST_PROD_CODE + "";

		String PM_IL_SA_INST_PYMT_INS_QRY = "INSERT INTO PM_IL_SA_INST_PYMT "
				+ "(SIP_PLAN_CODE, " + "SIP_PERC, " + "SIP_NUMR_PERIOD, "
				+ "SIP_DEMR_PERIOD, " + "SIP_REMARKS, " + "SIP_BL_REMARKS, "
				+ "SIP_CR_DT, " + "SIP_CR_UID, " + "SIP_UPD_DT, "
				+ "SIP_UPD_UID, " + "SIP_PROD_CODE) " + "SELECT "
				+ "SIP_PLAN_CODE, " + "SIP_PERC, " + "SIP_NUMR_PERIOD, "
				+ "SIP_DEMR_PERIOD, " + "SIP_REMARKS, " + "SIP_BL_REMARKS, "
				+ "SIP_CR_DT, " + "SIP_CR_UID, " + "SIP_UPD_DT, "
				+ "SIP_UPD_UID, " + "" + M_DEST_PROD_CODE + " "
				+ "FROM PM_IL_SA_INST_PYMT " + "WHERE SIP_PROD_CODE = "
				+ M_DEST_PROD_CODE + "";

		String PM_IL_PROD_APPL_COND_INS_QRY = "INSERT INTO PM_IL_PROD_APPL_COND "
				+ "(PACOND_PROD_CODE, "
				+ "PACOND_COND_CODE, "
				+ "PACOND_CR_DT, "
				+ "PACOND_CR_UID, "
				+ "PACOND_UPD_DT, "
				+ "PACOND_UPD_UID) "
				+ "SELECT "
				+ ""
				+ M_DEST_PROD_CODE
				+ ", "
				+ "PACOND_COND_CODE, "
				+ "PACOND_CR_DT, "
				+ "PACOND_CR_UID, "
				+ "PACOND_UPD_DT, "
				+ "PACOND_UPD_UID "
				+ "FROM  PM_IL_PROD_APPL_COND "
				+ "WHERE PACOND_PROD_CODE = "
				+ M_DEST_PROD_CODE + "";

		String PM_IL_PROD_APPL_COVER_INS_QRY = "INSERT INTO PM_IL_PROD_APPL_COVER "
				+ "(PAC_PROD_CODE, "
				+ "PAC_COVER_CODE, "
				+ "PAC_MANDATORY_YN, "
				+ "PAC_DEFAULT_YN, "
				+ "PAC_TARIFF_TERM_FLAG, "
				+ "PAC_CR_DT, "
				+ "PAC_CR_UID, "
				+ "PAC_UPD_DT, "
				+ "PAC_UPD_UID, "
				+ "PAC_MAX_AGE_ON_MAT, "
				+ "PAC_PERIOD, "
				+ "PAC_PREM_PAY_YRS, "
				+ "PAC_BCH_CODE, "
				+ "PAC_BCH_TERM, "
				+ "PAC_PRODUCTION_PERC, "
				+ "PAC_THRESHOLD_PERC, "
				+ "PAC_MED_DAYS, "
				+ "PAC_MED_AMT, "
				+ "PAC_MASTER_COVER_CODE, "
				+ "PAC_GRP_THRESHOLD_PERC, "
				+ "PAC_RSA_CALC_YN, "
				+ "PAC_COVER_ASSR_TYPE, "
				+ "PAC_AGE_BASIS, "
				+ "PAC_COVER_START_AGE_VAL_YN, "
				+ "PAC_COVER_START_AGE, "
				+ "PAC_MAT_PAYER_AGE, "
				+ "PAC_MAT_PAYEE_AGE, "
				+ "PAC_SA_TARIFF,PAC_PREM_TARIFF,PAC_SA_FACTOR  ) "
				+ "SELECT "
				+ ""
				+ M_DEST_PROD_CODE
				+ ", "
				+ "PAC_COVER_CODE, "
				+ "PAC_MANDATORY_YN, "
				+ "PAC_DEFAULT_YN, "
				+ "PAC_TARIFF_TERM_FLAG, "
				+ "PAC_CR_DT, "
				+ "PAC_CR_UID, "
				+ "PAC_UPD_DT, "
				+ "PAC_UPD_UID, "
				+ "PAC_MAX_AGE_ON_MAT, "
				+ "PAC_PERIOD, "
				+ "PAC_PREM_PAY_YRS, "
				+ "PAC_BCH_CODE, "
				+ "PAC_BCH_TERM, "
				+ "PAC_PRODUCTION_PERC, "
				+ "PAC_THRESHOLD_PERC, "
				+ "PAC_MED_DAYS, "
				+ "PAC_MED_AMT, "
				+ "PAC_MASTER_COVER_CODE, "
				+ "PAC_GRP_THRESHOLD_PERC, "
				+ "PAC_RSA_CALC_YN, "
				+ "PAC_COVER_ASSR_TYPE, "
				+ "PAC_AGE_BASIS, "
				+ "PAC_COVER_START_AGE_VAL_YN, "
				+ "PAC_COVER_START_AGE, "
				+ "PAC_MAT_PAYER_AGE, "
				+ "PAC_MAT_PAYEE_AGE,PAC_SA_TARIFF,PAC_PREM_TARIFF,PAC_SA_FACTOR "
				+ "FROM  PM_IL_PROD_APPL_COVER "
				+ "WHERE PAC_PROD_CODE = "
				+ M_SRC_PROD_CODE + "";

		String PM_IL_PROD_WD_PARAM_HDR_INS_QRY = "INSERT INTO PM_IL_PROD_WD_PARAM_HDR "
				+ "(PWPH_SYS_ID, "
				+ "PWPH_PROD_CODE, "
				+ "PWPH_WITHDRAW_MIN_YRS, "
				+ "PWPH_WITHDRAW_INTERVAL, "
				+ "PWPH_MAX_NO_WITHDRAW, "
				+ "PWPH_CR_UID, "
				+ "PWPH_CR_DT, "
				+ "PWPH_UPD_UID, "
				+ "PWPH_UPD_DT, "
				+ "PWPH_TOPUP_MIN_YRS) "
				+ "SELECT "
				+ "P9IL_PWPH_SYS_ID.NEXTVAL, "
				+ ""
				+ M_DEST_PROD_CODE
				+ ", "
				+ "PWPH_WITHDRAW_MIN_YRS, "
				+ "PWPH_WITHDRAW_INTERVAL, "
				+ "PWPH_MAX_NO_WITHDRAW, "
				+ "PWPH_CR_UID, "
				+ "PWPH_CR_DT, "
				+ "PWPH_UPD_UID, "
				+ "PWPH_UPD_DT, "
				+ "PWPH_TOPUP_MIN_YRS "
				+ "FROM PM_IL_PROD_WD_PARAM_HDR "
				+ "WHERE PWPH_PROD_CODE =  "
				+ M_SRC_PROD_CODE + "";

		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] c2values = null;

		Object[] PM_IL_PROD_APPL_FUND_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_PREM_LIMIT_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_APPL_LOAD_TARIFF_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_APPL_BONUS_INS_QRY_VALUES = null;
		Object[] PM_IL_SA_INST_PYMT_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_APPL_COND_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_APPL_COVER_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_WD_PARAM_HDR_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_WD_PARAM_DTL_INS_QRY_VALUES = null;
		Object[] PM_IL_PROD_TOPUP_PARAM_INS_QRY_VALUES = null;
		Object[] PM_IL_TOP_UP_CHARGE_INS_QRY_VALUES = null;
		Object[] PM_IL_PRODUCT_INSERT_QRY_VALUES = null;
		try {
			con = CommonUtils.getConnection();
			/*
			 * rs1 = handler.executeSelectStatement(C1, con); while (rs1.next()) {
			 * M_P9IL_PWPH_SYS_ID = rs1.getInt(1); } c2values = new Object[] {
			 * dummy_bean.getUI_M_SRC_PROD_CODE() }; rs2 =
			 * handler.executeSelectStatement(C2, con, c2values); while
			 * (rs2.next()) { M_PWPH_SYS_ID = rs2.getInt(1); }
			 */

			// EXCEPTION
			// WHEN OTHERS THEN
			// NULL;
			// END;
			String PM_IL_PROD_WD_PARAM_DTL_INS_QRY = "INSERT INTO PM_IL_PROD_WD_PARAM_DTL "
					+ "(PWPD_SYS_ID, "
					+ "PWPD_PWPH_SYS_ID, "
					+ "PWPD_FM_PREM_PAY_YRS, "
					+ "PWPD_TO_PREM_PAY_YRS, "
					+ "PWPD_LIMIT_RATE, "
					+ "PWPD_LIMIT_RATE_PER, "
					+ "PWPD_TOPUP_LIMIT_RATE, "
					+ "PWPD_TOPUP_LIMIT_RATE_PER, "
					+ "PWPD_NO_OF_TRANS, "
					+ "PWPD_LC_MIN_AMT, "
					+ "PWPD_LC_MAX_AMT, "
					+ "PWPD_CR_UID, "
					+ "PWPD_CR_DT, "
					+ "PWPD_UPD_UID, "
					+ "PWPD_UPD_DT) "
					+ "SELECT "
					+ "P9IL_PWPD_SYS_ID.NEXTVAL, "
					+ ""
					+ M_P9IL_PWPH_SYS_ID
					+ ", "
					+ "PWPD_FM_PREM_PAY_YRS, "
					+ "PWPD_TO_PREM_PAY_YRS, "
					+ "PWPD_LIMIT_RATE, "
					+ "PWPD_LIMIT_RATE_PER, "
					+ "PWPD_TOPUP_LIMIT_RATE, "
					+ "PWPD_TOPUP_LIMIT_RATE_PER, "
					+ "PWPD_NO_OF_TRANS, "
					+ "PWPD_LC_MIN_AMT, "
					+ "PWPD_LC_MAX_AMT, "
					+ "PWPD_CR_UID, "
					+ "PWPD_CR_DT, "
					+ "PWPD_UPD_UID, "
					+ "PWPD_UPD_DT "
					+ "FROM PM_IL_PROD_WD_PARAM_DTL "
					+ "WHERE PWPD_PWPH_SYS_ID IN (?)";

			String PM_IL_PROD_TOPUP_PARAM_INS_QRY = "INSERT INTO PM_IL_PROD_TOPUP_PARAM "
					+ "(PTP_PROD_CODE, "
					+ "PTP_MODE_OF_PYMT, "
					+ "PTP_LC_MIN_AMT, "
					+ "PTP_LC_MAX_AMT, "
					+ "PTP_CR_UID, "
					+ "PTP_CR_DT, "
					+ "PTP_UPD_UID, "
					+ "PTP_UPD_DT) "
					+ "SELECT "
					+ ""
					+ M_DEST_PROD_CODE
					+ ", "
					+ "PTP_MODE_OF_PYMT, "
					+ "PTP_LC_MIN_AMT, "
					+ "PTP_LC_MAX_AMT, "
					+ "PTP_CR_UID, "
					+ "PTP_CR_DT, "
					+ "PTP_UPD_UID, "
					+ "PTP_UPD_DT "
					+ "FROM PM_IL_PROD_TOPUP_PARAM "
					+ "WHERE  PTP_PROD_CODE = " + M_SRC_PROD_CODE + "";

			String PM_IL_TOP_UP_CHARGE_INS_QRY = "INSERT INTO PM_IL_TOP_UP_CHARGE "
					+ "(TUC_PROD_CODE, "
					+ "TUC_AMT_LC_FROM, "
					+ "TUC_AMT_LC_TO, "
					+ "TUC_RATE, "
					+ "TUC_RATE_PER, "
					+ "TUC_EFF_FM_DT, "
					+ "TUC_EFF_TO_DT, "
					+ "TUC_CR_DT, "
					+ "TUC_CR_UID, "
					+ "TUC_UPD_DT, "
					+ "TUC_UPD_UID) "
					+ "SELECT "
					+ ""
					+ M_DEST_PROD_CODE
					+ ", "
					+ "TUC_AMT_LC_FROM, "
					+ "TUC_AMT_LC_TO, "
					+ "TUC_RATE, "
					+ "TUC_RATE_PER, "
					+ "TUC_EFF_FM_DT, "
					+ "TUC_EFF_TO_DT, "
					+ "TUC_CR_DT, "
					+ "TUC_CR_UID, "
					+ "TUC_UPD_DT, "
					+ "TUC_UPD_UID "
					+ "FROM PM_IL_TOP_UP_CHARGE "
					+ "WHERE TUC_PROD_CODE = " + M_SRC_PROD_CODE + "";

			String PM_IL_PRODUCT_INSERT_QRY = "INSERT INTO PM_IL_PRODUCT "
					+ "(PROD_CODE,                  PROD_DESC,               PROD_SHORT_DESC, "
					+ "PROD_LONG_DESC,              PROD_BL_DESC,            PROD_BL_SHORT_DESC, "
					+ "PROD_BL_LONG_DESC,         PROD_PLAN_CODE,          PROD_PERIOD, "
					+ "PROD_PREM_PAY_YRS,          PROD_AGE_CALC_FLAG,      PROD_JOINT_LIFE_YN, "
					+ "PROD_TARIFF_TERM_FLAG,      PROD_PERIOD_MULTIPLE,    PROD_SA_INST_PYMT_TYPE, "
					+ "PROD_EFF_FM_DT,             PROD_EFF_TO_DT,          PROD_CR_DT, "
					+ "PROD_CR_UID,                PROD_UPD_DT,             PROD_UPD_UID, "
					+ "PROD_ENDT_VAL_DAYS,         PROD_MAX_DEFER_MONTHS,   PROD_COOLOFF_DAYS, "
					+ "PROD_EXP_LOAD_RATE,         PROD_EXP_LOAD_RATE_PER,  PROD_CONT_LOAD_RATE, "
					+ "PROD_CONT_LOAD_RATE_PER,    PROD_MORT_CODE,          PROD_EMI_TOLERANCE, "
					+ "PROD_CBC_YN,                PROD_AGE_SET_BACK,       PROD_WITHDRAW_YN, "
					+ "PROD_TOPUP_YN,              PROD_TOPUP_MIN_YRS,      PROD_BCH_CODE, "
					+ "PROD_COMM_RND_DEC,          PROD_COMM_RND_TYPE,      PROD_BROK_CALC_MTHD, "
					+ "PROD_PRODUCTION_PERC,       PROD_THRESHOLD_PERC,     PROD_DS_CODE, "
					+ "PROD_TOPUP_PROD_PERC,       PROD_PREM_CALC_MTHD,     PROD_INST_BASIS, "
					+ "PROD_INST_PERC,             PROD_AUTO_APPROV,        PROD_INST_RATE_PER, "
					+ "PROD_TOPUP_COMM_CODE,       PROD_ALLOC_TYPE,         PROD_BUY_BASIS, "
					+ "PROD_AUTO_UW,               PROD_PREM_TARIFF,        PROD_SA_TARIFF, "
					+ "PROD_CALC_ALLOC,            PROD_SA_FACTOR,          PROD_ROUND_OPTION, "
					+ "PROD_ROUND_VALUE,           PROD_MAT_AMT_TYPE,       PROD_MAT_RATE, "
					+ "PROD_MAT_RATE_PER,          PROD_FUND_FEE,           PROD_FUND_FEE_RATE_PER, "
					+ "PROD_MRTA_RATE_CALC_YN,     PROD_TOPUP_CHARGE_TYPE,  PROD_PREM_HOLIDAY_CODE, "
					+ "PROD_LOAD_CHARGE_YN,        PROD_PRODUCT_TYPE,       PROD_GRP_THRESHOLD_PERC, "
					+ "PROD_MODE_OF_CALC,          PROD_THR_BASIS,          PROD_SURR_CALC_TYPE, "
					+ "PROD_PRS_YN,                PROD_SURR_PLUS_FACTOR,   PROD_AGENT_HIRE_YN, "
					+ "PROD_MATU_DT,               PROD_DEF_PERIOD_FLAG,    PROD_RSA_CALC_TYP, "
					+ "PROD_SURRENDER_FACTOR,      PROD_WAKFEE_FACTOR,      PROD_TOLL_LIMIT_YN, "
					+ "PROD_INTER_FUND_YN,         PROD_WITHDRAW_AMT_MULTIPLE, "
					+ "PROD_RI_RECOV_BASIS,     PROD_SERVICE_TAX_YN,  "
					+ "PROD_DEF_PERIOD_FM,PROD_DEF_PERIOD_TO,PROD_WAQAF_PERIOD_FM,PROD_WAQAF_PERIOD_TO, "
					+ "PROD_DRIP_MTHD, "
					+ "PROD_MASTER_CERT_YN, "
					+ "PROD_FUND_ALLOWED, "
					+ "PROD_SA_BY_PLAN_BASIS_YN, "
					+ "PROD_TOPUP_MULTIPLE,PROD_TOPUP_WAK_CODE,PROD_AFTWD_LC_MINBAL,PROD_TRAN_RATE_YN ) "
					+ "SELECT '"
					+ M_DEST_PROD_CODE
					+ "' PROD_CODE, "
					+ "SUBSTR( '"
					+ M_DEST_PROD_CODE_DESC
					+ "' ,1,60) PROD_DESC, "
					+ "SUBSTR( '"
					+ M_DEST_PROD_CODE_DESC
					+ "' ,1,30) PROD_SHORT_DESC , "
					+ "SUBSTR( '"
					+ M_DEST_PROD_CODE_DESC
					+ "' ,1,60) PROD_LONG_DESC , PROD_BL_DESC,            PROD_BL_SHORT_DESC, "
					+ "PROD_BL_LONG_DESC,         PROD_PLAN_CODE,          PROD_PERIOD, "
					+ "PROD_PREM_PAY_YRS,          PROD_AGE_CALC_FLAG,      PROD_JOINT_LIFE_YN, "
					+ "PROD_TARIFF_TERM_FLAG,      PROD_PERIOD_MULTIPLE,    PROD_SA_INST_PYMT_TYPE, "
					+ "PROD_EFF_FM_DT,             PROD_EFF_TO_DT,          PROD_CR_DT, "
					+ "PROD_CR_UID,                PROD_UPD_DT,             PROD_UPD_UID, "
					+ "PROD_ENDT_VAL_DAYS,         PROD_MAX_DEFER_MONTHS,   PROD_COOLOFF_DAYS, "
					+ "PROD_EXP_LOAD_RATE,         PROD_EXP_LOAD_RATE_PER,  PROD_CONT_LOAD_RATE, "
					+ "PROD_CONT_LOAD_RATE_PER,    PROD_MORT_CODE,          PROD_EMI_TOLERANCE, "
					+ "PROD_CBC_YN,                PROD_AGE_SET_BACK,       PROD_WITHDRAW_YN, "
					+ "PROD_TOPUP_YN,              PROD_TOPUP_MIN_YRS,      PROD_BCH_CODE, "
					+ "PROD_COMM_RND_DEC,          PROD_COMM_RND_TYPE,      PROD_BROK_CALC_MTHD, "
					+ "PROD_PRODUCTION_PERC,       PROD_THRESHOLD_PERC,     PROD_DS_CODE, "
					+ "PROD_TOPUP_PROD_PERC,       PROD_PREM_CALC_MTHD,     PROD_INST_BASIS, "
					+ "PROD_INST_PERC,             PROD_AUTO_APPROV,        PROD_INST_RATE_PER, "
					+ "PROD_TOPUP_COMM_CODE,       PROD_ALLOC_TYPE,         PROD_BUY_BASIS, "
					+ "PROD_AUTO_UW,               PROD_PREM_TARIFF,        PROD_SA_TARIFF, "
					+ "PROD_CALC_ALLOC,            PROD_SA_FACTOR,          PROD_ROUND_OPTION, "
					+ "PROD_ROUND_VALUE,           PROD_MAT_AMT_TYPE,       PROD_MAT_RATE, "
					+ "PROD_MAT_RATE_PER,          PROD_FUND_FEE,           PROD_FUND_FEE_RATE_PER, "
					+ "PROD_MRTA_RATE_CALC_YN,     PROD_TOPUP_CHARGE_TYPE,  PROD_PREM_HOLIDAY_CODE, "
					+ "PROD_LOAD_CHARGE_YN,        PROD_PRODUCT_TYPE,       PROD_GRP_THRESHOLD_PERC, "
					+ "PROD_MODE_OF_CALC,          PROD_THR_BASIS,          PROD_SURR_CALC_TYPE, "
					+ "PROD_PRS_YN,                PROD_SURR_PLUS_FACTOR,   PROD_AGENT_HIRE_YN, "
					+ "PROD_MATU_DT,               PROD_DEF_PERIOD_FLAG,    PROD_RSA_CALC_TYP, "
					+ "PROD_SURRENDER_FACTOR,      PROD_WAKFEE_FACTOR ,     PROD_TOLL_LIMIT_YN, "
					+ "PROD_INTER_FUND_YN,         PROD_WITHDRAW_AMT_MULTIPLE, PROD_RI_RECOV_BASIS, "
					+ "PROD_SERVICE_TAX_YN,  PROD_DEF_PERIOD_FM,PROD_DEF_PERIOD_TO,PROD_WAQAF_PERIOD_FM,PROD_WAQAF_PERIOD_TO, "
					+ "PROD_DRIP_MTHD, "
					+ "PROD_MASTER_CERT_YN, "
					+ "PROD_FUND_ALLOWED, "
					+ "PROD_SA_BY_PLAN_BASIS_YN,PROD_TOPUP_MULTIPLE,PROD_TOPUP_WAK_CODE,PROD_AFTWD_LC_MINBAL,PROD_TRAN_RATE_YN "
					+ "FROM PM_IL_PRODUCT " + "WHERE PROD_CODE = ?";

			PM_IL_PROD_APPL_FUND_INS_QRY_VALUES = new Object[] { dummy_bean
					.getUI_M_SRC_PROD_CODE() };
			PM_IL_PROD_PREM_LIMIT_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_PROD_APPL_LOAD_TARIFF_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_PROD_APPL_BONUS_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_SA_INST_PYMT_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_PROD_APPL_COND_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_PROD_APPL_COVER_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_PROD_WD_PARAM_HDR_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };

			// PM_IL_PROD_WD_PARAM_DTL_INS_QRY_VALUES = new Object[] {
			// M_PWPH_SYS_ID };
			PM_IL_PROD_TOPUP_PARAM_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_TOP_UP_CHARGE_INS_QRY_VALUES = new Object[] {
					dummy_bean.getUI_M_DEST_PROD_CODE(),
					dummy_bean.getUI_M_SRC_PROD_CODE() };
			PM_IL_PRODUCT_INSERT_QRY_VALUES = new Object[] { dummy_bean
					.getUI_M_SRC_PROD_CODE() };

			// handler.executeInsertStatement(PM_IL_PROD_APPL_FUND_INS_QRY,
			// con);
			// handler.executeInsertStatement(PM_IL_PROD_PREM_LIMIT_INS_QRY,
			// con);
			// handler.executeInsertStatement(PM_IL_PROD_APPL_LOAD_TARIFF_INS_QRY,
			// con);
			// handler.executeInsertStatement(PM_IL_PROD_APPL_BONUS_INS_QRY,
			// con);
			// handler.executeInsertStatement(PM_IL_SA_INST_PYMT_INS_QRY, con);
			// handler.executeInsertStatement(PM_IL_PROD_APPL_COND_INS_QRY,
			// con);
			// handler.executeInsertStatement(PM_IL_PROD_APPL_COVER_INS_QRY,
			// con);
			/*
			 * handler .executeInsertStatement(PM_IL_PROD_WD_PARAM_HDR_INS_QRY,
			 * con);
			 */

			/*
			 * handler.executeInsertStatement(PM_IL_PROD_WD_PARAM_DTL_INS_QRY,
			 * con, PM_IL_PROD_WD_PARAM_DTL_INS_QRY_VALUES);
			 */

			// handler.executeInsertStatement(PM_IL_PROD_TOPUP_PARAM_INS_QRY,
			// con);
			// handler.executeInsertStatement(PM_IL_TOP_UP_CHARGE_INS_QRY, con);
			handler.executeInsertStatement(PM_IL_PRODUCT_INSERT_QRY, con,
					PM_IL_PRODUCT_INSERT_QRY_VALUES);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public HtmlInputText getCOMP_UI_M_PLAN_PERIOD_FROM() {
		return COMP_UI_M_PLAN_PERIOD_FROM;
	}

	public void setCOMP_UI_M_PLAN_PERIOD_FROM(
			HtmlInputText comp_ui_m_plan_period_from) {
		COMP_UI_M_PLAN_PERIOD_FROM = comp_ui_m_plan_period_from;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_PERIOD_TO() {
		return COMP_UI_M_PLAN_PERIOD_TO;
	}

	public void setCOMP_UI_M_PLAN_PERIOD_TO(
			HtmlInputText comp_ui_m_plan_period_to) {
		COMP_UI_M_PLAN_PERIOD_TO = comp_ui_m_plan_period_to;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_MAX_AGE_ON_MAT() {
		return COMP_UI_M_PLAN_MAX_AGE_ON_MAT;
	}

	public void setCOMP_UI_M_PLAN_MAX_AGE_ON_MAT(
			HtmlInputText comp_ui_m_plan_max_age_on_mat) {
		COMP_UI_M_PLAN_MAX_AGE_ON_MAT = comp_ui_m_plan_max_age_on_mat;
	}

	public HtmlInputText getCOMP_UI_M_PROD_SA_INST_PYMT_TYPE() {
		return COMP_UI_M_PROD_SA_INST_PYMT_TYPE;
	}

	public void setCOMP_UI_M_PROD_SA_INST_PYMT_TYPE(
			HtmlInputText comp_ui_m_prod_sa_inst_pymt_type) {
		COMP_UI_M_PROD_SA_INST_PYMT_TYPE = comp_ui_m_prod_sa_inst_pymt_type;
	}

	public HtmlInputText getCOMP_UI_M_DUMMY1() {
		return COMP_UI_M_DUMMY1;
	}

	public void setCOMP_UI_M_DUMMY1(HtmlInputText comp_ui_m_dummy1) {
		COMP_UI_M_DUMMY1 = comp_ui_m_dummy1;
	}

	public HtmlInputText getCOMP_UI_M_DUMMY() {
		return COMP_UI_M_DUMMY;
	}

	public void setCOMP_UI_M_DUMMY(HtmlInputText comp_ui_m_dummy) {
		COMP_UI_M_DUMMY = comp_ui_m_dummy;
	}

	public void validateUI_M_DEST_PROD_CODE(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_DEST_PROD_CODE((String) value);
		try {
			validateUI_M_DEST_PROD_CODE(DUMMY_BEAN.getUI_M_DEST_PROD_CODE());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_DEST_PROD_CODE(String value) throws Exception {
		String M_DUMMY = null;
		String C1 = "SELECT 'X' FROM  PM_IL_PRODUCT WHERE PROD_CODE  = ?";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if (value != null) {
				resultSet = handler.executeSelectStatement(C1, connection,
						new Object[] { value });
				if (resultSet.next()) {
					M_DUMMY = resultSet.getString(1);
				}
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "19001"));
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	
	
	
	
	//[Added By Aaksh to implement Copy Functionality From P10.
	
	public void validateNewCvrCode(FacesContext context ,UIComponent component,Object value ){
		try{
			String cvrCode = (String)value;
			DUMMY_BEAN.setUI_NEW_CVR_CODE(cvrCode);
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public void valdateChkCvr(FacesContext context,UIComponent component,Object value){
		try{
			String chkValue = value.toString();
			System.out.println("value cvr check"+chkValue);
			if("true".equals(chkValue)){
				DUMMY_BEAN.setCvrCheck("Y");
			}else{
				DUMMY_BEAN.setCvrCheck("N");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void valdatePlanChk(FacesContext context,UIComponent component,Object value){
		try{
			String planChk = value.toString();
			
			System.out.println("value plan check"+planChk);
			
			if("true".equals(planChk)){
				DUMMY_BEAN.setPlanCheck("Y");
			}else{
				DUMMY_BEAN.setPlanCheck("N");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void valdateTrfChk(FacesContext context,UIComponent component,Object value){
		try{
			String trfChk = value.toString();
			
			System.out.println("value Tarif chk check"+trfChk);
			
			if("true".equals(trfChk)){
				DUMMY_BEAN.setTrfCheck("Y");
			}else{
				DUMMY_BEAN.setTrfCheck("N");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	public void defaultOnloadValues(){
		DUMMY_BEAN.setUI_M_SRC_PROD_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getPM_IL_PRODUCT_BEAN().getPROD_CODE());
		DUMMY_BEAN.setUI_M_SRC_PROD_CODE_DESC(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getPM_IL_PRODUCT_BEAN().getPROD_DESC());
		DUMMY_BEAN.setUI_OLD_CVR_CODE(compositeAction.getPM_IL_PRODUCT_ACTION_BEAN()
				.getPM_IL_PRODUCT_BEAN().getPROD_PLAN_CODE());
	}
	
	

	public HtmlOutputLabel getCOMP_UI_OLD_CVR_CODE_LABEL() {
		return COMP_UI_OLD_CVR_CODE_LABEL;
	}

	public void setCOMP_UI_OLD_CVR_CODE_LABEL(
			HtmlOutputLabel comp_ui_old_cvr_code_label) {
		COMP_UI_OLD_CVR_CODE_LABEL = comp_ui_old_cvr_code_label;
	}

	public HtmlInputText getCOMP_UI_OLD_CVR_CODE() {
		return COMP_UI_OLD_CVR_CODE;
	}

	public void setCOMP_UI_OLD_CVR_CODE(HtmlInputText comp_ui_old_cvr_code) {
		COMP_UI_OLD_CVR_CODE = comp_ui_old_cvr_code;
	}

	public HtmlOutputLabel getCOMP_UI_NEW_CVR_CODE_LABEL() {
		return COMP_UI_NEW_CVR_CODE_LABEL;
	}

	public void setCOMP_UI_NEW_CVR_CODE_LABEL(
			HtmlOutputLabel comp_ui_new_cvr_code_label) {
		COMP_UI_NEW_CVR_CODE_LABEL = comp_ui_new_cvr_code_label;
	}

	public HtmlInputText getCOMP_UI_NEW_CVR_CODE() {
		return COMP_UI_NEW_CVR_CODE;
	}

	public void setCOMP_UI_NEW_CVR_CODE(HtmlInputText comp_ui_new_cvr_code) {
		COMP_UI_NEW_CVR_CODE = comp_ui_new_cvr_code;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_CVR_CHECK() {
		return COMP_UI_CVR_CHECK;
	}

	public void setCOMP_UI_CVR_CHECK(HtmlSelectBooleanCheckbox comp_ui_cvr_check) {
		COMP_UI_CVR_CHECK = comp_ui_cvr_check;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_PLAN_CHECK() {
		return COMP_UI_PLAN_CHECK;
	}

	public void setCOMP_UI_PLAN_CHECK(HtmlSelectBooleanCheckbox comp_ui_plan_check) {
		COMP_UI_PLAN_CHECK = comp_ui_plan_check;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_TRF_CHECK() {
		return COMP_UI_TRF_CHECK;
	}

	public void setCOMP_UI_TRF_CHECK(HtmlSelectBooleanCheckbox comp_ui_trf_check) {
		COMP_UI_TRF_CHECK = comp_ui_trf_check;
	}

	public PILM035_APAC_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlOutputLabel getCOMP_UI_CVR_CHECK_LABEL() {
		return COMP_UI_CVR_CHECK_LABEL;
	}

	public void setCOMP_UI_CVR_CHECK_LABEL(HtmlOutputLabel comp_ui_cvr_check_label) {
		COMP_UI_CVR_CHECK_LABEL = comp_ui_cvr_check_label;
	}

	public HtmlOutputLabel getCOMP_UI_PLAN_CHECK_LABEL() {
		return COMP_UI_PLAN_CHECK_LABEL;
	}

	public void setCOMP_UI_PLAN_CHECK_LABEL(HtmlOutputLabel comp_ui_plan_check_label) {
		COMP_UI_PLAN_CHECK_LABEL = comp_ui_plan_check_label;
	}

	public HtmlOutputLabel getCOMP_UI_TRF_CHECK_LABEL() {
		return COMP_UI_TRF_CHECK_LABEL;
	}

	public void setCOMP_UI_TRF_CHECK_LABEL(HtmlOutputLabel comp_ui_trf_check_label) {
		COMP_UI_TRF_CHECK_LABEL = comp_ui_trf_check_label;
	}
}
