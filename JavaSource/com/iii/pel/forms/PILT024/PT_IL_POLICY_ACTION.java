package com.iii.pel.forms.PILT024;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlTab;
import org.richfaces.component.html.HtmlTabPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_POLICY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_POL_FLEX_30_LABEL;

	private HtmlInputText COMP_POL_FLEX_30;

	private HtmlOutputLabel COMP_POL_FLEX_26_LABEL;

	private HtmlInputText COMP_POL_FLEX_26;

	private HtmlOutputLabel COMP_POL_FLEX_25_LABEL;

	private HtmlInputText COMP_POL_FLEX_25;

	private HtmlOutputLabel COMP_POL_FLEX_24_LABEL;

	private HtmlInputText COMP_POL_FLEX_24;

	private HtmlOutputLabel COMP_POL_FLEX_23_LABEL;

	private HtmlInputText COMP_POL_FLEX_23;

	private HtmlOutputLabel COMP_POL_FLEX_22_LABEL;

	private HtmlInputText COMP_POL_FLEX_22;

	private HtmlOutputLabel COMP_POL_FLEX_27_LABEL;

	private HtmlInputText COMP_POL_FLEX_27;

	private HtmlOutputLabel COMP_POL_FLEX_29_LABEL;

	private HtmlInputText COMP_POL_FLEX_29;

	private HtmlOutputLabel COMP_POL_FLEX_28_LABEL;

	private HtmlInputText COMP_POL_FLEX_28;

	private HtmlOutputLabel COMP_POL_FLEX_01_LABEL;

	private HtmlInputText COMP_POL_FLEX_01;

	private HtmlOutputLabel COMP_POL_FLEX_02_LABEL;

	private HtmlInputText COMP_POL_FLEX_02;

	private HtmlOutputLabel COMP_POL_FLEX_03_LABEL;

	private HtmlInputText COMP_POL_FLEX_03;

	private HtmlOutputLabel COMP_POL_FLEX_04_LABEL;

	private HtmlInputText COMP_POL_FLEX_04;

	private HtmlOutputLabel COMP_POL_FLEX_05_LABEL;

	private HtmlInputText COMP_POL_FLEX_05;

	private HtmlOutputLabel COMP_POL_FLEX_06_LABEL;

	private HtmlInputText COMP_POL_FLEX_06;

	private HtmlOutputLabel COMP_POL_FLEX_07_LABEL;

	private HtmlInputText COMP_POL_FLEX_07;

	private HtmlOutputLabel COMP_POL_FLEX_08_LABEL;

	private HtmlInputText COMP_POL_FLEX_08;

	private HtmlOutputLabel COMP_POL_FLEX_09_LABEL;

	private HtmlInputText COMP_POL_FLEX_09;

	private HtmlOutputLabel COMP_POL_FLEX_10_LABEL;

	private HtmlInputText COMP_POL_FLEX_10;

	private HtmlOutputLabel COMP_POL_FLEX_11_LABEL;

	private HtmlInputText COMP_POL_FLEX_11;

	private HtmlOutputLabel COMP_POL_FLEX_12_LABEL;

	private HtmlInputText COMP_POL_FLEX_12;

	private HtmlOutputLabel COMP_POL_FLEX_13_LABEL;

	private HtmlInputText COMP_POL_FLEX_13;

	private HtmlOutputLabel COMP_POL_FLEX_14_LABEL;

	private HtmlInputText COMP_POL_FLEX_14;

	private HtmlOutputLabel COMP_POL_FLEX_15_LABEL;

	private HtmlInputText COMP_POL_FLEX_15;

	private HtmlOutputLabel COMP_POL_FLEX_16_LABEL;

	private HtmlInputText COMP_POL_FLEX_16;

	private HtmlOutputLabel COMP_POL_FLEX_17_LABEL;

	private HtmlInputText COMP_POL_FLEX_17;

	private HtmlOutputLabel COMP_POL_FLEX_18_LABEL;

	private HtmlInputText COMP_POL_FLEX_18;

	private HtmlOutputLabel COMP_POL_FLEX_19_LABEL;

	private HtmlInputText COMP_POL_FLEX_19;

	private HtmlOutputLabel COMP_POL_FLEX_20_LABEL;

	private HtmlInputText COMP_POL_FLEX_20;

	private HtmlOutputLabel COMP_POL_FLEX_21_LABEL;

	private HtmlInputText COMP_POL_FLEX_21;

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_CUST_CODE_LABEL;

	private HtmlInputText COMP_POL_CUST_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_NAME;

	private HtmlOutputLabel COMP_POL_CONT_CODE_LABEL;

	private HtmlInputText COMP_POL_CONT_CODE;

	private HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_POL_ASSURED_NAME;

	private HtmlOutputLabel COMP_POL_CUST_CURR_CODE_LABEL;

	private HtmlInputText COMP_POL_CUST_CURR_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_CUST_CURR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_CUST_CURR_CODE_DESC;

	private HtmlOutputLabel COMP_POL_PROD_CODE_LABEL;

	private HtmlInputText COMP_POL_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_POL_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POL_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL;

	private HtmlCalendar COMP_POL_ISSUE_DT;

	private HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL;

	private HtmlCalendar COMP_POL_EXPIRY_DT;

	private HtmlOutputLabel COMP_POL_START_DT_LABEL;

	private HtmlCalendar COMP_POL_START_DT;

	private HtmlOutputLabel COMP_POL_MODE_OF_PYMT_LABEL;

	private HtmlInputText COMP_POL_MODE_OF_PYMT;

	private HtmlOutputLabel COMP_UI_M_PAID_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PAID_DT;

	private HtmlOutputLabel COMP_UI_M_PREV_INST_DUE_DT_LABEL;
	private HtmlCalendar COMP_UI_M_PREV_INST_DUE_DT;

	private HtmlOutputLabel COMP_UI_M_CURR_INV_DUE_DT_LABEL;
	private HtmlCalendar COMP_UI_M_CURR_INV_DUE_DT;

	private HtmlOutputLabel COMP_UI_M_PREV_PAY_DT_LABEL;
	private HtmlCalendar COMP_UI_M_PREV_PAY_DT;

	private HtmlTabPanel COMP_TAB_PANEL;

	private HtmlTab COMP_UI_M_BUT_INST_DTLS;

	private HtmlTab COMP_UI_M_BUT_PREM_DTLS;

	private HtmlTab COMP_UI_M_BUT_PREM_SUB_DTL;

	private HtmlCommandButton COMP_UI_M_BUT_GET_DETAILS;

	private HtmlOutputLabel COMP_PC_SCHD_PYMT_DT_LABEL;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	public PILT024_COMPOSITE_ACTION compositeAction;

	private PT_IL_POLICY_HELPER helper;

	ArrayList<LovBean> list = new ArrayList<LovBean>();
	
	public void disablefieldcomponents(boolean disabled){
		COMP_POL_NO.setDisabled(disabled);
		COMP_POL_CUST_CODE.setDisabled(disabled);
		COMP_UI_M_POL_CUST_NAME.setDisabled(disabled);
		COMP_POL_CONT_CODE.setDisabled(disabled);
		COMP_POL_ASSURED_NAME.setDisabled(disabled);
		COMP_POL_CUST_CURR_CODE.setDisabled(disabled);
		COMP_UI_M_POL_CUST_CURR_CODE_DESC.setDisabled(disabled);
		COMP_POL_PROD_CODE.setDisabled(disabled);
		COMP_UI_M_POL_PROD_CODE_DESC.setDisabled(disabled);
		COMP_POL_ISSUE_DT.setDisabled(disabled);
		COMP_POL_EXPIRY_DT.setDisabled(disabled);
		COMP_POL_START_DT.setDisabled(disabled);
		COMP_POL_MODE_OF_PYMT.setDisabled(disabled);
		COMP_UI_M_PAID_DT.setDisabled(disabled);
		COMP_UI_M_PREV_INST_DUE_DT.setDisabled(disabled);
		COMP_UI_M_CURR_INV_DUE_DT.setDisabled(disabled);
		COMP_UI_M_PREV_PAY_DT.setDisabled(disabled);
	}

	public PT_IL_POLICY_ACTION() {

		// Connection connection = CommonUtils.getConnection();

		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		helper = new PT_IL_POLICY_HELPER();

		/*
		 * setListPC_WAIVE_PREM_YN(ListItemUtil.getDropDownListValue(connection,
		 * "PILT002_APAC", "PT_IL_POLICY", "PT_IL_POLICY.POL_FRZ_FLAG",
		 * "YESNO"));
		 */
	}

	public void onLoad(PhaseEvent event) {
			/*TO generate PC_SYS_ID*/
			String pcsysidQry = "SELECT min(PC_SYS_ID) A FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND "
					+ "NVL(PC_PAID_FLAG,'N') IN ('N','Y')";
			String pd_lc_amtQry = "SELECT SUM(NVL(PD_LC_AMT,0)) FROM PT_IL_PYMT_DTLS WHERE PD_TXN_SYS_ID = ? ";
			Long pcsysid = null;
			Double pd_lc_amt = 0.0; 
			ResultSet rs = null;
			ResultSet pcsysidRS = null;
			Connection con = null;
			//String pcPaidFlag = null;
		try {
			con = CommonUtils.getConnection();
			if (isFormFlag()) {
				CommonUtils.clearMaps(this);
				CommonUtils.clearMaps(compositeAction.getDUMMY_ACTION_BEAN());
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				
				helper.whenNewBlockInstance();
				helper.preQuery(PT_IL_POLICY_BEAN);
				helper.executeQuery(compositeAction);
				if (PT_IL_POLICY_BEAN.getROWID() != null) {
					helper.postQuery(PT_IL_POLICY_BEAN, compositeAction
							.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(),
							compositeAction);
					/*ADDED BY RAJA ON 15-07-2017 FOR ZBILQC-1731999*/
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_INVEST_DETAILS().setDisabled(false);
					
					/*END*/
				} else {
					// whenCreateRecord
					/*Added by Ameen on 23-05-2017 as per siva sugg.*/
					helper.premiumDetailsDegaultValue(compositeAction);
					/*End*/
				}
				/*
				 * commented by Ameen on 13-07-2017 as per Tiags sir sugg.
				 * compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_INVEST_DETAILS().setDisabled(true);*/
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_PYMT_DTLS().setDisabled(true);
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_RNEW_PREM_COLL().setDisabled(true);
				
				setBlockFlag(false);
			}
			pcsysidRS = new CRUDHandler().executeSelectStatement(pcsysidQry, con, new Object[] {
					PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
			if (pcsysidRS.next()) {
				pcsysid = pcsysidRS.getLong(1);
			}
			
			rs = new CRUDHandler().executeSelectStatement(pd_lc_amtQry, con, 
						new Object[]{pcsysid});
			if(rs.next()){
				pd_lc_amt = rs.getDouble(1);
			}
			System.out.println("pcsysid ::" + pcsysid + "::PD_LC_AMT ::" + pd_lc_amt 
					+ "::getUI_M_FC_TOBE_PAID_AMOUNT() ::" +compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_FC_TOBE_PAID_AMOUNT() + 
					"::getUI_M_LC_TOBE_PAID_AMOUNT() ::" +compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_LC_TOBE_PAID_AMOUNT());
			if(pd_lc_amt.equals(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_FC_TOBE_PAID_AMOUNT())){
				compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
				//compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_BUT_FAC().setDisabled(false);
			}
			System.out.println("allocateFlag ::::::" + allocateFlag);
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_ALLOCATE_BTN().setDisabled(allocateFlag);
			System.out.println("teeeee ::::" + PT_IL_POLICY_BEAN.getUI_M_PAID_DT());
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public List<LovBean> lovAction(Object value) {
		ListItemUtil listItemUtil = null;
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILT003_APAC", "PT_IL_POLICY",
					"POL_NO", "A", null, null, null, null, (String) value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("prepareLovCommCode", e.getMessage());
		}
		return list;
	}

	public void validatePOL_NO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setPOL_NO((String) value);
			helper.whenValidatePOL_NO(PT_IL_POLICY_BEAN);
			helper.premiumDetails(compositeAction);
			compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().resetPremDtlsComponents();
			COMP_POL_ISSUE_DT.resetValue();
			// COMP_POL_PLAN_CODE.resetValue();
			COMP_POL_CUST_CODE.resetValue();
			/*Added by Ameen on 18-05-2017*/
			COMP_UI_M_POL_CUST_NAME.resetValue();
			COMP_POL_CUST_CURR_CODE.resetValue();
			COMP_UI_M_POL_CUST_CURR_CODE_DESC.resetValue();
			COMP_UI_M_PREV_PAY_DT.resetValue();
			COMP_UI_M_CURR_INV_DUE_DT.resetValue();
			COMP_UI_M_PREV_INST_DUE_DT.resetValue();
			COMP_UI_M_PAID_DT.resetValue();
			/*End*/
			COMP_POL_CONT_CODE.resetValue();
			COMP_POL_ASSURED_NAME.resetValue();
			// COMP_POL_CUST_EXCH_RATE.resetValue();
			COMP_POL_START_DT.resetValue();
			COMP_POL_EXPIRY_DT.resetValue();
			COMP_POL_MODE_OF_PYMT.resetValue();
			COMP_POL_PROD_CODE.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "PC_REF_NO", getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String backButton() {
		String outcome = null;
		String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
		if (null == callingForm || callingForm.trim().isEmpty()
				|| "PILT024".equals(callingForm)
				|| "PILT024".equals(callingForm)) {
			outcome = "PILT024";
		} else {
			outcome = callingForm;
			// Removing integration paramters
			CommonUtils.getSession().removeAttribute("CALLING_FORM");
		}
		return outcome;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	/*Added by Ameen on 24-05-2017*/
	public void fireFieldValidationGross(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().setAllocateFlag(false);
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String wizardCaption = "";

	public String getWizardCaption() {
		return wizardCaption;
	}

	public void setWizardCaption(String wizardCaption) {
		this.wizardCaption = wizardCaption;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_30_LABEL() {
		return COMP_POL_FLEX_30_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_30() {
		return COMP_POL_FLEX_30;
	}

	public void setCOMP_POL_FLEX_30_LABEL(HtmlOutputLabel COMP_POL_FLEX_30_LABEL) {
		this.COMP_POL_FLEX_30_LABEL = COMP_POL_FLEX_30_LABEL;
	}

	public void setCOMP_POL_FLEX_30(HtmlInputText COMP_POL_FLEX_30) {
		this.COMP_POL_FLEX_30 = COMP_POL_FLEX_30;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_26_LABEL() {
		return COMP_POL_FLEX_26_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_26() {
		return COMP_POL_FLEX_26;
	}

	public void setCOMP_POL_FLEX_26_LABEL(HtmlOutputLabel COMP_POL_FLEX_26_LABEL) {
		this.COMP_POL_FLEX_26_LABEL = COMP_POL_FLEX_26_LABEL;
	}

	public void setCOMP_POL_FLEX_26(HtmlInputText COMP_POL_FLEX_26) {
		this.COMP_POL_FLEX_26 = COMP_POL_FLEX_26;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_25_LABEL() {
		return COMP_POL_FLEX_25_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_25() {
		return COMP_POL_FLEX_25;
	}

	public void setCOMP_POL_FLEX_25_LABEL(HtmlOutputLabel COMP_POL_FLEX_25_LABEL) {
		this.COMP_POL_FLEX_25_LABEL = COMP_POL_FLEX_25_LABEL;
	}

	public void setCOMP_POL_FLEX_25(HtmlInputText COMP_POL_FLEX_25) {
		this.COMP_POL_FLEX_25 = COMP_POL_FLEX_25;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_24_LABEL() {
		return COMP_POL_FLEX_24_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_24() {
		return COMP_POL_FLEX_24;
	}

	public void setCOMP_POL_FLEX_24_LABEL(HtmlOutputLabel COMP_POL_FLEX_24_LABEL) {
		this.COMP_POL_FLEX_24_LABEL = COMP_POL_FLEX_24_LABEL;
	}

	public void setCOMP_POL_FLEX_24(HtmlInputText COMP_POL_FLEX_24) {
		this.COMP_POL_FLEX_24 = COMP_POL_FLEX_24;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_23_LABEL() {
		return COMP_POL_FLEX_23_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_23() {
		return COMP_POL_FLEX_23;
	}

	public void setCOMP_POL_FLEX_23_LABEL(HtmlOutputLabel COMP_POL_FLEX_23_LABEL) {
		this.COMP_POL_FLEX_23_LABEL = COMP_POL_FLEX_23_LABEL;
	}

	public void setCOMP_POL_FLEX_23(HtmlInputText COMP_POL_FLEX_23) {
		this.COMP_POL_FLEX_23 = COMP_POL_FLEX_23;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_22_LABEL() {
		return COMP_POL_FLEX_22_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_22() {
		return COMP_POL_FLEX_22;
	}

	public void setCOMP_POL_FLEX_22_LABEL(HtmlOutputLabel COMP_POL_FLEX_22_LABEL) {
		this.COMP_POL_FLEX_22_LABEL = COMP_POL_FLEX_22_LABEL;
	}

	public void setCOMP_POL_FLEX_22(HtmlInputText COMP_POL_FLEX_22) {
		this.COMP_POL_FLEX_22 = COMP_POL_FLEX_22;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_27_LABEL() {
		return COMP_POL_FLEX_27_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_27() {
		return COMP_POL_FLEX_27;
	}

	public void setCOMP_POL_FLEX_27_LABEL(HtmlOutputLabel COMP_POL_FLEX_27_LABEL) {
		this.COMP_POL_FLEX_27_LABEL = COMP_POL_FLEX_27_LABEL;
	}

	public void setCOMP_POL_FLEX_27(HtmlInputText COMP_POL_FLEX_27) {
		this.COMP_POL_FLEX_27 = COMP_POL_FLEX_27;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_29_LABEL() {
		return COMP_POL_FLEX_29_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_29() {
		return COMP_POL_FLEX_29;
	}

	public void setCOMP_POL_FLEX_29_LABEL(HtmlOutputLabel COMP_POL_FLEX_29_LABEL) {
		this.COMP_POL_FLEX_29_LABEL = COMP_POL_FLEX_29_LABEL;
	}

	public void setCOMP_POL_FLEX_29(HtmlInputText COMP_POL_FLEX_29) {
		this.COMP_POL_FLEX_29 = COMP_POL_FLEX_29;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_28_LABEL() {
		return COMP_POL_FLEX_28_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_28() {
		return COMP_POL_FLEX_28;
	}

	public void setCOMP_POL_FLEX_28_LABEL(HtmlOutputLabel COMP_POL_FLEX_28_LABEL) {
		this.COMP_POL_FLEX_28_LABEL = COMP_POL_FLEX_28_LABEL;
	}

	public void setCOMP_POL_FLEX_28(HtmlInputText COMP_POL_FLEX_28) {
		this.COMP_POL_FLEX_28 = COMP_POL_FLEX_28;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_01_LABEL() {
		return COMP_POL_FLEX_01_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_01() {
		return COMP_POL_FLEX_01;
	}

	public void setCOMP_POL_FLEX_01_LABEL(HtmlOutputLabel COMP_POL_FLEX_01_LABEL) {
		this.COMP_POL_FLEX_01_LABEL = COMP_POL_FLEX_01_LABEL;
	}

	public void setCOMP_POL_FLEX_01(HtmlInputText COMP_POL_FLEX_01) {
		this.COMP_POL_FLEX_01 = COMP_POL_FLEX_01;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_02_LABEL() {
		return COMP_POL_FLEX_02_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_02() {
		return COMP_POL_FLEX_02;
	}

	public void setCOMP_POL_FLEX_02_LABEL(HtmlOutputLabel COMP_POL_FLEX_02_LABEL) {
		this.COMP_POL_FLEX_02_LABEL = COMP_POL_FLEX_02_LABEL;
	}

	public void setCOMP_POL_FLEX_02(HtmlInputText COMP_POL_FLEX_02) {
		this.COMP_POL_FLEX_02 = COMP_POL_FLEX_02;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_03_LABEL() {
		return COMP_POL_FLEX_03_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_03() {
		return COMP_POL_FLEX_03;
	}

	public void setCOMP_POL_FLEX_03_LABEL(HtmlOutputLabel COMP_POL_FLEX_03_LABEL) {
		this.COMP_POL_FLEX_03_LABEL = COMP_POL_FLEX_03_LABEL;
	}

	public void setCOMP_POL_FLEX_03(HtmlInputText COMP_POL_FLEX_03) {
		this.COMP_POL_FLEX_03 = COMP_POL_FLEX_03;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_04_LABEL() {
		return COMP_POL_FLEX_04_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_04() {
		return COMP_POL_FLEX_04;
	}

	public void setCOMP_POL_FLEX_04_LABEL(HtmlOutputLabel COMP_POL_FLEX_04_LABEL) {
		this.COMP_POL_FLEX_04_LABEL = COMP_POL_FLEX_04_LABEL;
	}

	public void setCOMP_POL_FLEX_04(HtmlInputText COMP_POL_FLEX_04) {
		this.COMP_POL_FLEX_04 = COMP_POL_FLEX_04;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_05_LABEL() {
		return COMP_POL_FLEX_05_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_05() {
		return COMP_POL_FLEX_05;
	}

	public void setCOMP_POL_FLEX_05_LABEL(HtmlOutputLabel COMP_POL_FLEX_05_LABEL) {
		this.COMP_POL_FLEX_05_LABEL = COMP_POL_FLEX_05_LABEL;
	}

	public void setCOMP_POL_FLEX_05(HtmlInputText COMP_POL_FLEX_05) {
		this.COMP_POL_FLEX_05 = COMP_POL_FLEX_05;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_06_LABEL() {
		return COMP_POL_FLEX_06_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_06() {
		return COMP_POL_FLEX_06;
	}

	public void setCOMP_POL_FLEX_06_LABEL(HtmlOutputLabel COMP_POL_FLEX_06_LABEL) {
		this.COMP_POL_FLEX_06_LABEL = COMP_POL_FLEX_06_LABEL;
	}

	public void setCOMP_POL_FLEX_06(HtmlInputText COMP_POL_FLEX_06) {
		this.COMP_POL_FLEX_06 = COMP_POL_FLEX_06;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_07_LABEL() {
		return COMP_POL_FLEX_07_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_07() {
		return COMP_POL_FLEX_07;
	}

	public void setCOMP_POL_FLEX_07_LABEL(HtmlOutputLabel COMP_POL_FLEX_07_LABEL) {
		this.COMP_POL_FLEX_07_LABEL = COMP_POL_FLEX_07_LABEL;
	}

	public void setCOMP_POL_FLEX_07(HtmlInputText COMP_POL_FLEX_07) {
		this.COMP_POL_FLEX_07 = COMP_POL_FLEX_07;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_08_LABEL() {
		return COMP_POL_FLEX_08_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_08() {
		return COMP_POL_FLEX_08;
	}

	public void setCOMP_POL_FLEX_08_LABEL(HtmlOutputLabel COMP_POL_FLEX_08_LABEL) {
		this.COMP_POL_FLEX_08_LABEL = COMP_POL_FLEX_08_LABEL;
	}

	public void setCOMP_POL_FLEX_08(HtmlInputText COMP_POL_FLEX_08) {
		this.COMP_POL_FLEX_08 = COMP_POL_FLEX_08;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_09_LABEL() {
		return COMP_POL_FLEX_09_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_09() {
		return COMP_POL_FLEX_09;
	}

	public void setCOMP_POL_FLEX_09_LABEL(HtmlOutputLabel COMP_POL_FLEX_09_LABEL) {
		this.COMP_POL_FLEX_09_LABEL = COMP_POL_FLEX_09_LABEL;
	}

	public void setCOMP_POL_FLEX_09(HtmlInputText COMP_POL_FLEX_09) {
		this.COMP_POL_FLEX_09 = COMP_POL_FLEX_09;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_10_LABEL() {
		return COMP_POL_FLEX_10_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_10() {
		return COMP_POL_FLEX_10;
	}

	public void setCOMP_POL_FLEX_10_LABEL(HtmlOutputLabel COMP_POL_FLEX_10_LABEL) {
		this.COMP_POL_FLEX_10_LABEL = COMP_POL_FLEX_10_LABEL;
	}

	public void setCOMP_POL_FLEX_10(HtmlInputText COMP_POL_FLEX_10) {
		this.COMP_POL_FLEX_10 = COMP_POL_FLEX_10;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_11_LABEL() {
		return COMP_POL_FLEX_11_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_11() {
		return COMP_POL_FLEX_11;
	}

	public void setCOMP_POL_FLEX_11_LABEL(HtmlOutputLabel COMP_POL_FLEX_11_LABEL) {
		this.COMP_POL_FLEX_11_LABEL = COMP_POL_FLEX_11_LABEL;
	}

	public void setCOMP_POL_FLEX_11(HtmlInputText COMP_POL_FLEX_11) {
		this.COMP_POL_FLEX_11 = COMP_POL_FLEX_11;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_12_LABEL() {
		return COMP_POL_FLEX_12_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_12() {
		return COMP_POL_FLEX_12;
	}

	public void setCOMP_POL_FLEX_12_LABEL(HtmlOutputLabel COMP_POL_FLEX_12_LABEL) {
		this.COMP_POL_FLEX_12_LABEL = COMP_POL_FLEX_12_LABEL;
	}

	public void setCOMP_POL_FLEX_12(HtmlInputText COMP_POL_FLEX_12) {
		this.COMP_POL_FLEX_12 = COMP_POL_FLEX_12;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_13_LABEL() {
		return COMP_POL_FLEX_13_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_13() {
		return COMP_POL_FLEX_13;
	}

	public void setCOMP_POL_FLEX_13_LABEL(HtmlOutputLabel COMP_POL_FLEX_13_LABEL) {
		this.COMP_POL_FLEX_13_LABEL = COMP_POL_FLEX_13_LABEL;
	}

	public void setCOMP_POL_FLEX_13(HtmlInputText COMP_POL_FLEX_13) {
		this.COMP_POL_FLEX_13 = COMP_POL_FLEX_13;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_14_LABEL() {
		return COMP_POL_FLEX_14_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_14() {
		return COMP_POL_FLEX_14;
	}

	public void setCOMP_POL_FLEX_14_LABEL(HtmlOutputLabel COMP_POL_FLEX_14_LABEL) {
		this.COMP_POL_FLEX_14_LABEL = COMP_POL_FLEX_14_LABEL;
	}

	public void setCOMP_POL_FLEX_14(HtmlInputText COMP_POL_FLEX_14) {
		this.COMP_POL_FLEX_14 = COMP_POL_FLEX_14;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_15_LABEL() {
		return COMP_POL_FLEX_15_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_15() {
		return COMP_POL_FLEX_15;
	}

	public void setCOMP_POL_FLEX_15_LABEL(HtmlOutputLabel COMP_POL_FLEX_15_LABEL) {
		this.COMP_POL_FLEX_15_LABEL = COMP_POL_FLEX_15_LABEL;
	}

	public void setCOMP_POL_FLEX_15(HtmlInputText COMP_POL_FLEX_15) {
		this.COMP_POL_FLEX_15 = COMP_POL_FLEX_15;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_16_LABEL() {
		return COMP_POL_FLEX_16_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_16() {
		return COMP_POL_FLEX_16;
	}

	public void setCOMP_POL_FLEX_16_LABEL(HtmlOutputLabel COMP_POL_FLEX_16_LABEL) {
		this.COMP_POL_FLEX_16_LABEL = COMP_POL_FLEX_16_LABEL;
	}

	public void setCOMP_POL_FLEX_16(HtmlInputText COMP_POL_FLEX_16) {
		this.COMP_POL_FLEX_16 = COMP_POL_FLEX_16;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_17_LABEL() {
		return COMP_POL_FLEX_17_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_17() {
		return COMP_POL_FLEX_17;
	}

	public void setCOMP_POL_FLEX_17_LABEL(HtmlOutputLabel COMP_POL_FLEX_17_LABEL) {
		this.COMP_POL_FLEX_17_LABEL = COMP_POL_FLEX_17_LABEL;
	}

	public void setCOMP_POL_FLEX_17(HtmlInputText COMP_POL_FLEX_17) {
		this.COMP_POL_FLEX_17 = COMP_POL_FLEX_17;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_18_LABEL() {
		return COMP_POL_FLEX_18_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_18() {
		return COMP_POL_FLEX_18;
	}

	public void setCOMP_POL_FLEX_18_LABEL(HtmlOutputLabel COMP_POL_FLEX_18_LABEL) {
		this.COMP_POL_FLEX_18_LABEL = COMP_POL_FLEX_18_LABEL;
	}

	public void setCOMP_POL_FLEX_18(HtmlInputText COMP_POL_FLEX_18) {
		this.COMP_POL_FLEX_18 = COMP_POL_FLEX_18;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_19_LABEL() {
		return COMP_POL_FLEX_19_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_19() {
		return COMP_POL_FLEX_19;
	}

	public void setCOMP_POL_FLEX_19_LABEL(HtmlOutputLabel COMP_POL_FLEX_19_LABEL) {
		this.COMP_POL_FLEX_19_LABEL = COMP_POL_FLEX_19_LABEL;
	}

	public void setCOMP_POL_FLEX_19(HtmlInputText COMP_POL_FLEX_19) {
		this.COMP_POL_FLEX_19 = COMP_POL_FLEX_19;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_20_LABEL() {
		return COMP_POL_FLEX_20_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_20() {
		return COMP_POL_FLEX_20;
	}

	public void setCOMP_POL_FLEX_20_LABEL(HtmlOutputLabel COMP_POL_FLEX_20_LABEL) {
		this.COMP_POL_FLEX_20_LABEL = COMP_POL_FLEX_20_LABEL;
	}

	public void setCOMP_POL_FLEX_20(HtmlInputText COMP_POL_FLEX_20) {
		this.COMP_POL_FLEX_20 = COMP_POL_FLEX_20;
	}

	public HtmlOutputLabel getCOMP_POL_FLEX_21_LABEL() {
		return COMP_POL_FLEX_21_LABEL;
	}

	public HtmlInputText getCOMP_POL_FLEX_21() {
		return COMP_POL_FLEX_21;
	}

	public void setCOMP_POL_FLEX_21_LABEL(HtmlOutputLabel COMP_POL_FLEX_21_LABEL) {
		this.COMP_POL_FLEX_21_LABEL = COMP_POL_FLEX_21_LABEL;
	}

	public void setCOMP_POL_FLEX_21(HtmlInputText COMP_POL_FLEX_21) {
		this.COMP_POL_FLEX_21 = COMP_POL_FLEX_21;
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

	public void setCOMP_POL_CUST_CODE_LABEL(
			HtmlOutputLabel COMP_POL_CUST_CODE_LABEL) {
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

	public void setCOMP_UI_M_POL_CUST_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_NAME_LABEL) {
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

	public void setCOMP_POL_CONT_CODE_LABEL(
			HtmlOutputLabel COMP_POL_CONT_CODE_LABEL) {
		this.COMP_POL_CONT_CODE_LABEL = COMP_POL_CONT_CODE_LABEL;
	}

	public void setCOMP_POL_CONT_CODE(HtmlInputText COMP_POL_CONT_CODE) {
		this.COMP_POL_CONT_CODE = COMP_POL_CONT_CODE;
	}

	public HtmlOutputLabel getCOMP_POL_ASSURED_NAME_LABEL() {
		return COMP_POL_ASSURED_NAME_LABEL;
	}

	public HtmlInputText getCOMP_POL_ASSURED_NAME() {
		return COMP_POL_ASSURED_NAME;
	}

	public void setCOMP_POL_ASSURED_NAME_LABEL(
			HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL) {
		this.COMP_POL_ASSURED_NAME_LABEL = COMP_POL_ASSURED_NAME_LABEL;
	}

	public void setCOMP_POL_ASSURED_NAME(HtmlInputText COMP_POL_ASSURED_NAME) {
		this.COMP_POL_ASSURED_NAME = COMP_POL_ASSURED_NAME;
	}

	public HtmlOutputLabel getCOMP_POL_CUST_CURR_CODE_LABEL() {
		return COMP_POL_CUST_CURR_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_CUST_CURR_CODE() {
		return COMP_POL_CUST_CURR_CODE;
	}

	public void setCOMP_POL_CUST_CURR_CODE_LABEL(
			HtmlOutputLabel COMP_POL_CUST_CURR_CODE_LABEL) {
		this.COMP_POL_CUST_CURR_CODE_LABEL = COMP_POL_CUST_CURR_CODE_LABEL;
	}

	public void setCOMP_POL_CUST_CURR_CODE(HtmlInputText COMP_POL_CUST_CURR_CODE) {
		this.COMP_POL_CUST_CURR_CODE = COMP_POL_CUST_CURR_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CUST_CURR_CODE_DESC_LABEL() {
		return COMP_UI_M_POL_CUST_CURR_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_CUST_CURR_CODE_DESC() {
		return COMP_UI_M_POL_CUST_CURR_CODE_DESC;
	}

	public void setCOMP_UI_M_POL_CUST_CURR_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_CUST_CURR_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_CUST_CURR_CODE_DESC_LABEL = COMP_UI_M_POL_CUST_CURR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_CUST_CURR_CODE_DESC(
			HtmlInputText COMP_UI_M_POL_CUST_CURR_CODE_DESC) {
		this.COMP_UI_M_POL_CUST_CURR_CODE_DESC = COMP_UI_M_POL_CUST_CURR_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_PROD_CODE_LABEL() {
		return COMP_POL_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_POL_PROD_CODE() {
		return COMP_POL_PROD_CODE;
	}

	public void setCOMP_POL_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_POL_PROD_CODE_LABEL) {
		this.COMP_POL_PROD_CODE_LABEL = COMP_POL_PROD_CODE_LABEL;
	}

	public void setCOMP_POL_PROD_CODE(HtmlInputText COMP_POL_PROD_CODE) {
		this.COMP_POL_PROD_CODE = COMP_POL_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_POL_PROD_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_PROD_CODE_DESC() {
		return COMP_UI_M_POL_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_POL_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_POL_PROD_CODE_DESC_LABEL) {
		this.COMP_UI_M_POL_PROD_CODE_DESC_LABEL = COMP_UI_M_POL_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POL_PROD_CODE_DESC(
			HtmlInputText COMP_UI_M_POL_PROD_CODE_DESC) {
		this.COMP_UI_M_POL_PROD_CODE_DESC = COMP_UI_M_POL_PROD_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_POL_ISSUE_DT_LABEL() {
		return COMP_POL_ISSUE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_ISSUE_DT() {
		return COMP_POL_ISSUE_DT;
	}

	public void setCOMP_POL_ISSUE_DT_LABEL(
			HtmlOutputLabel COMP_POL_ISSUE_DT_LABEL) {
		this.COMP_POL_ISSUE_DT_LABEL = COMP_POL_ISSUE_DT_LABEL;
	}

	public void setCOMP_POL_ISSUE_DT(HtmlCalendar COMP_POL_ISSUE_DT) {
		this.COMP_POL_ISSUE_DT = COMP_POL_ISSUE_DT;
	}

	public HtmlOutputLabel getCOMP_POL_EXPIRY_DT_LABEL() {
		return COMP_POL_EXPIRY_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_EXPIRY_DT() {
		return COMP_POL_EXPIRY_DT;
	}

	public void setCOMP_POL_EXPIRY_DT_LABEL(
			HtmlOutputLabel COMP_POL_EXPIRY_DT_LABEL) {
		this.COMP_POL_EXPIRY_DT_LABEL = COMP_POL_EXPIRY_DT_LABEL;
	}

	public void setCOMP_POL_EXPIRY_DT(HtmlCalendar COMP_POL_EXPIRY_DT) {
		this.COMP_POL_EXPIRY_DT = COMP_POL_EXPIRY_DT;
	}

	public HtmlOutputLabel getCOMP_POL_START_DT_LABEL() {
		return COMP_POL_START_DT_LABEL;
	}

	public HtmlCalendar getCOMP_POL_START_DT() {
		return COMP_POL_START_DT;
	}

	public void setCOMP_POL_START_DT_LABEL(
			HtmlOutputLabel COMP_POL_START_DT_LABEL) {
		this.COMP_POL_START_DT_LABEL = COMP_POL_START_DT_LABEL;
	}

	public void setCOMP_POL_START_DT(HtmlCalendar COMP_POL_START_DT) {
		this.COMP_POL_START_DT = COMP_POL_START_DT;
	}

	public HtmlOutputLabel getCOMP_POL_MODE_OF_PYMT_LABEL() {
		return COMP_POL_MODE_OF_PYMT_LABEL;
	}

	public HtmlInputText getCOMP_POL_MODE_OF_PYMT() {
		return COMP_POL_MODE_OF_PYMT;
	}

	public void setCOMP_POL_MODE_OF_PYMT_LABEL(
			HtmlOutputLabel COMP_POL_MODE_OF_PYMT_LABEL) {
		this.COMP_POL_MODE_OF_PYMT_LABEL = COMP_POL_MODE_OF_PYMT_LABEL;
	}

	public void setCOMP_POL_MODE_OF_PYMT(HtmlInputText COMP_POL_MODE_OF_PYMT) {
		this.COMP_POL_MODE_OF_PYMT = COMP_POL_MODE_OF_PYMT;
	}

	public HtmlOutputLabel getCOMP_UI_M_PAID_DT_LABEL() {
		return COMP_UI_M_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PAID_DT() {
		return COMP_UI_M_PAID_DT;
	}

	public void setCOMP_UI_M_PAID_DT_LABEL(
			HtmlOutputLabel COMP_UI_M_PAID_DT_LABEL) {
		this.COMP_UI_M_PAID_DT_LABEL = COMP_UI_M_PAID_DT_LABEL;
	}

	public void setCOMP_UI_M_PAID_DT(HtmlCalendar COMP_UI_M_PAID_DT) {
		this.COMP_UI_M_PAID_DT = COMP_UI_M_PAID_DT;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}

	public PILT024_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT024_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREV_INST_DUE_DT_LABEL() {
		return COMP_UI_M_PREV_INST_DUE_DT_LABEL;
	}

	public void setCOMP_UI_M_PREV_INST_DUE_DT_LABEL(
			HtmlOutputLabel comp_ui_m_prev_inst_due_dt_label) {
		COMP_UI_M_PREV_INST_DUE_DT_LABEL = comp_ui_m_prev_inst_due_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PREV_INST_DUE_DT() {
		return COMP_UI_M_PREV_INST_DUE_DT;
	}

	public void setCOMP_UI_M_PREV_INST_DUE_DT(
			HtmlCalendar comp_ui_m_prev_inst_due_dt) {
		COMP_UI_M_PREV_INST_DUE_DT = comp_ui_m_prev_inst_due_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_CURR_INV_DUE_DT_LABEL() {
		return COMP_UI_M_CURR_INV_DUE_DT_LABEL;
	}

	public void setCOMP_UI_M_CURR_INV_DUE_DT_LABEL(
			HtmlOutputLabel comp_ui_m_curr_inv_due_dt_label) {
		COMP_UI_M_CURR_INV_DUE_DT_LABEL = comp_ui_m_curr_inv_due_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_CURR_INV_DUE_DT() {
		return COMP_UI_M_CURR_INV_DUE_DT;
	}

	public void setCOMP_UI_M_CURR_INV_DUE_DT(
			HtmlCalendar comp_ui_m_curr_inv_due_dt) {
		COMP_UI_M_CURR_INV_DUE_DT = comp_ui_m_curr_inv_due_dt;
	}

	public HtmlOutputLabel getCOMP_UI_M_PREV_PAY_DT_LABEL() {
		return COMP_UI_M_PREV_PAY_DT_LABEL;
	}

	public void setCOMP_UI_M_PREV_PAY_DT_LABEL(
			HtmlOutputLabel comp_ui_m_prev_pay_dt_label) {
		COMP_UI_M_PREV_PAY_DT_LABEL = comp_ui_m_prev_pay_dt_label;
	}

	public HtmlCalendar getCOMP_UI_M_PREV_PAY_DT() {
		return COMP_UI_M_PREV_PAY_DT;
	}

	public void setCOMP_UI_M_PREV_PAY_DT(HtmlCalendar comp_ui_m_prev_pay_dt) {
		COMP_UI_M_PREV_PAY_DT = comp_ui_m_prev_pay_dt;
	}

	public HtmlTabPanel getCOMP_TAB_PANEL() {
		return COMP_TAB_PANEL;
	}

	public void setCOMP_TAB_PANEL(HtmlTabPanel comp_tab_panel) {
		COMP_TAB_PANEL = comp_tab_panel;
	}

	public HtmlTab getCOMP_UI_M_BUT_INST_DTLS() {
		return COMP_UI_M_BUT_INST_DTLS;
	}

	public void setCOMP_UI_M_BUT_INST_DTLS(HtmlTab comp_ui_m_but_inst_dtls) {
		COMP_UI_M_BUT_INST_DTLS = comp_ui_m_but_inst_dtls;
	}

	public HtmlTab getCOMP_UI_M_BUT_PREM_DTLS() {
		return COMP_UI_M_BUT_PREM_DTLS;
	}

	public void setCOMP_UI_M_BUT_PREM_DTLS(HtmlTab comp_ui_m_but_prem_dtls) {
		COMP_UI_M_BUT_PREM_DTLS = comp_ui_m_but_prem_dtls;
	}

	public HtmlTab getCOMP_UI_M_BUT_PREM_SUB_DTL() {
		return COMP_UI_M_BUT_PREM_SUB_DTL;
	}

	public void setCOMP_UI_M_BUT_PREM_SUB_DTL(HtmlTab comp_ui_m_but_prem_sub_dtl) {
		COMP_UI_M_BUT_PREM_SUB_DTL = comp_ui_m_but_prem_sub_dtl;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_GET_DETAILS() {
		return COMP_UI_M_BUT_GET_DETAILS;
	}

	public void setCOMP_UI_M_BUT_GET_DETAILS(
			HtmlCommandButton comp_ui_m_but_get_details) {
		COMP_UI_M_BUT_GET_DETAILS = comp_ui_m_but_get_details;
	}

	public HtmlOutputLabel getCOMP_PC_SCHD_PYMT_DT_LABEL() {
		return COMP_PC_SCHD_PYMT_DT_LABEL;
	}

	public void setCOMP_PC_SCHD_PYMT_DT_LABEL(
			HtmlOutputLabel comp_pc_schd_pymt_dt_label) {
		COMP_PC_SCHD_PYMT_DT_LABEL = comp_pc_schd_pymt_dt_label;
	}

	public String pymtDtlsButAction() {
		try {
			helper.whenButPressPymtDtls(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("paymentDetails", e.getMessage());
		}
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().setFormFlag(true);
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT024");
		return "PILT017_PAYMENTDETAILS";
	}

	public String facButAction() {
		try {
			helper.whenButPressFac(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("paymentDetails", e.getMessage());
		}
		CommonUtils.setGlobalVariable("CALLING_FORM", "PILT009");
		return "PILT009";
	}

	public String investementDtlsButAction() {
		String outCome = null;
		outCome = "PILT024_PS_IL_POL_INVEST_SUMMARY";
		compositeAction.getPT_IL_POLICY_ACTION_BEAN().setFormFlag(true);
		return outCome;
	}

	public String premCollButAction() {
		String outCome = null;
		helper.whenButPressRNEW_PREM_COLL(PT_IL_POLICY_BEAN);
		outCome = "PILT003";
		return outCome;
	}

	public String brokerDtlsButAction() {
		String outCome = null;
		helper.whenButPressRNEW_PREM_COLL(PT_IL_POLICY_BEAN);
		outCome = "PILT024_PT_IL_BROKER_VALUES";
		return outCome;
	}

	/*Added by Ameen on 13-05-2017*/
	
	public void m_but_next_action() {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null, rs2 = null, rs3 = null, rs4 = null, rs5 = null;
		Integer M_PC_LC_BAL_GROSS_PREM = 0; 
		Integer M_PC_FC_BAL_GROSS_PREM = 0;
		Integer M_PC_FC_BAL_BASIC_PREM = 0; 
		Integer M_PC_LC_BAL_BASIC_PREM = 0; 
		Integer M_PC_FC_BAL_ADDL_PREM = 0;
		Integer M_PC_LC_BAL_ADDL_PREM = 0;
		Integer M_PC_FC_BAL_LOAD_AMT = 0;
		Integer M_PC_LC_BAL_LOAD_AMT = 0;
		Integer M_PC_LC_BAL_DISC = 0;
		Integer M_PC_FC_BAL_DISC = 0;
		Integer M_PC_LC_BAL_COMP_CHRG = 0;
		Integer M_PC_FC_BAL_COMP_CHRG = 0;
		Integer M_PC_FC_BAL_CUST_CHRG = 0;
		Integer M_PC_LC_BAL_CUST_CHRG = 0;
		Integer M_PC_FC_BAL_CONTR = 0;
		Integer M_PC_LC_BAL_CONTR = 0;
		Long M_PC_SYS_ID = null;
		String M_PC_PREM_TYPE = null;
		
		String CURSOR_1 = "SELECT MIN(PC_SYS_ID) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND	PC_PAID_FLAG != 'A'";
		
		String CURSOR_2 = "SELECT NVL(PC_LC_BAL_GROSS_PREM,0), NVL(PC_FC_BAL_GROSS_PREM,0), NVL(PC_FC_BAL_BASIC_PREM,0), "
				+ "NVL(PC_LC_BAL_BASIC_PREM,0), NVL(PC_FC_BAL_ADDL_PREM,0), NVL(PC_LC_BAL_ADDL_PREM,0), NVL(PC_FC_BAL_LOAD_AMT,0), "
				+ "NVL(PC_LC_BAL_LOAD_AMT,0), NVL(PC_LC_BAL_DISC,0), NVL(PC_FC_BAL_DISC,0), NVL(PC_LC_BAL_COMP_CHRG,0), "
				+ "NVL(PC_FC_BAL_COMP_CHRG,0), NVL(PC_FC_BAL_CUST_CHRG,0), NVL(PC_LC_BAL_CUST_CHRG,0), NVL(PC_FC_BAL_CONTR,0), "
				+ "NVL(PC_LC_BAL_CONTR,0) FROM PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = ? AND PC_SYS_ID = ?";
		
		String CURSOR_3 = "SELECT MAX(PC_SYS_ID) FROM   PT_IL_PREM_COLL WHERE  PC_SYS_ID < (SELECT MIN(PC_SYS_ID) FROM "
				+ "PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND	  PC_PAID_FLAG != 'A')";
		
		String CURSOR_4 = "SELECT MIN(PC_SYS_ID) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND PC_PAID_FLAG = 'A' "
				+ "AND	 (PC_LC_BAL_GROSS_PREM != 0 OR PC_FC_BAL_GROSS_PREM != 0 OR	PC_FC_BAL_BASIC_PREM != 0 OR PC_LC_BAL_BASIC_PREM != 0 "
				+ "OR PC_FC_BAL_ADDL_PREM != 0 OR PC_LC_BAL_ADDL_PREM != 0 OR PC_FC_BAL_LOAD_AMT != 0 OR PC_LC_BAL_LOAD_AMT	 != 0 OR PC_LC_BAL_DISC != 0 "
				+ "OR PC_FC_BAL_DISC != 0 OR PC_LC_BAL_COMP_CHRG != 0 OR PC_FC_BAL_COMP_CHRG != 0 OR PC_FC_BAL_CUST_CHRG != 0 OR PC_LC_BAL_CUST_CHRG != 0 "
				+ "OR PC_FC_BAL_CONTR != 0 OR PC_LC_BAL_CONTR != 0)";
		
		String CURSOR_5 = "SELECT PC_PREM_TYPE FROM	PT_IL_PREM_COLL WHERE PC_POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID AND PC_SYS_ID = ?";
		P9ILPK_INVEST_PREM_COLL p9ilpk_invest_prem_coll =  new P9ILPK_INVEST_PREM_COLL();
		DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		
		try {
			connection = CommonUtils.getConnection();
			//P11JILPK_INVEST_PREM_COLL p11jilpk_invest_prem_coll = new P11JILPK_INVEST_PREM_COLL();
			if(PT_IL_POLICY_BEAN.getUI_M_PAID_DT() == null){
				
			}
			rs2 = handler.executeSelectStatement(CURSOR_2, connection,new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
												 compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID()});
			if(rs2.next()){
				M_PC_LC_BAL_GROSS_PREM = rs2.getInt(1); 
				M_PC_FC_BAL_GROSS_PREM = rs2.getInt(2);
				M_PC_FC_BAL_BASIC_PREM = rs2.getInt(3); 
				M_PC_LC_BAL_BASIC_PREM = rs2.getInt(4); 
				M_PC_FC_BAL_ADDL_PREM = rs2.getInt(5);
				M_PC_LC_BAL_ADDL_PREM = rs2.getInt(6);
				M_PC_FC_BAL_LOAD_AMT = rs2.getInt(7);
				M_PC_LC_BAL_LOAD_AMT = rs2.getInt(8);
				M_PC_LC_BAL_DISC = rs2.getInt(9);
				M_PC_FC_BAL_DISC = rs2.getInt(10);
				M_PC_LC_BAL_COMP_CHRG = rs2.getInt(11);
				M_PC_FC_BAL_COMP_CHRG = rs2.getInt(12);
				M_PC_FC_BAL_CUST_CHRG = rs2.getInt(13);
				M_PC_LC_BAL_CUST_CHRG = rs2.getInt(14);
				M_PC_FC_BAL_CONTR = rs2.getInt(15);
				M_PC_LC_BAL_CONTR = rs2.getInt(16);
			}
			if(M_PC_LC_BAL_GROSS_PREM == 0 && M_PC_FC_BAL_GROSS_PREM == 0 && M_PC_FC_BAL_BASIC_PREM == 0 &&
				    M_PC_LC_BAL_BASIC_PREM == 0 && M_PC_FC_BAL_ADDL_PREM  == 0	&& M_PC_LC_BAL_ADDL_PREM  == 0 &&
				    M_PC_FC_BAL_LOAD_AMT   == 0 && M_PC_LC_BAL_LOAD_AMT   == 0 && M_PC_LC_BAL_DISC       == 0 && 
				    M_PC_FC_BAL_DISC       == 0 && M_PC_LC_BAL_COMP_CHRG  == 0 && M_PC_FC_BAL_COMP_CHRG  == 0 && 
				    M_PC_FC_BAL_CUST_CHRG  == 0 && M_PC_LC_BAL_CUST_CHRG  == 0 && M_PC_FC_BAL_CONTR 		 == 0 && 
				    M_PC_LC_BAL_CONTR 		 == 0){
				rs4 = handler.executeSelectStatement(CURSOR_4, connection,
										new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
				if(rs4.next()){
					M_PC_SYS_ID = rs4.getLong(1);
				
				if(M_PC_SYS_ID != null){
					DUMMY_BEAN.setUI_M_PC_SYS_ID(M_PC_SYS_ID);
				}else{
					rs1 = handler.executeSelectStatement(CURSOR_1, connection, 
											new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
					if(rs1.next()){
						DUMMY_BEAN.setUI_M_PC_SYS_ID(rs1.getLong(1));
					}
				}
			}
				rs5 = handler.executeSelectStatement(CURSOR_5, connection,
										new Object[]{DUMMY_BEAN.getUI_M_PC_SYS_ID()});
				if(rs5.next()){
					M_PC_PREM_TYPE = rs5.getString(1);
				}
				if("R".equalsIgnoreCase(CommonUtils.nvl(M_PC_PREM_TYPE, "X"))){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "93259"));
				}
				p9ilpk_invest_prem_coll.INITIALIZE_PREM_COLL_RECORD(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),DUMMY_BEAN.getUI_M_PC_SYS_ID());
				CommonUtils.setGlobalVariable("GLOBAL.M_PC_SYS_ID", DUMMY_BEAN.getUI_M_PC_SYS_ID().toString());
				p9ilpk_invest_prem_coll.CALC_DUE_AMOUNTS(PT_IL_POLICY_BEAN.getUI_M_PAID_DT());
				
				/*:CONTROL.M_COMM_DEL := 'P';
			    :SYSTEM.MESSAGE_LEVEL := 25;
			    POST;
			    :SYSTEM.MESSAGE_LEVEL := 15;
			    :CONTROL.M_COMM_DEL := NULL;	
			    :GLOBAL.M_PC_SYS_ID := :DUMMY.M_PC_SYS_ID ;	
				  GO_BLOCK('PT_IL_PREM_COLL');
				  EXECUTE_QUERY;	
				  GO_ITEM('DUMMY.M_FC_TOBE_PAID_AMOUNT');
				  :PT_IL_PREM_COLL.PC_PAID_DT := :PT_IL_POLICY.M_PAID_DT ;*/
			}else{
				rs3 = handler.executeSelectStatement(CURSOR_3, connection,
									new Object[]{PT_IL_POLICY_BEAN.getPOL_SYS_ID()});
				if(rs3.next()){
					DUMMY_BEAN.setUI_M_PC_SYS_ID(rs3.getLong(1));
				}
				rs5 = handler.executeSelectStatement(CURSOR_5, connection,
											new Object[]{DUMMY_BEAN.getUI_M_PC_SYS_ID()});
				if(rs5.next()){
					M_PC_PREM_TYPE = rs3.getString(1);
				}
				
				/*IF NVL(M_PC_PREM_TYPE,'X') = 'R' THEN
					  	 --STD_MESSAGE_ROUTINE (93259, :GLOBAL.M_LANG_CODE);
				       --RAISE FORM_TRIGGER_FAILURE;
				       STD_ERROR(NAME_IN('GLOBAL.M_LOGIN_APP_CODE'),93259,NAME_IN('GLOBAL.M_LANG_CODE'));
					  END IF;	  
					  
					  P9ILPK_INVEST_PREM_COLL.INITIALIZE_PREM_COLL_RECORD(:PT_IL_POLICY.POL_SYS_ID,
				                                                        :DUMMY.M_PC_SYS_ID);   
				    :GLOBAL.M_PC_SYS_ID := :DUMMY.M_PC_SYS_ID ;
				    P9ILPK_INVEST_PREM_COLL.CALC_DUE_AMOUNTS(:PT_IL_POLICY.M_PAID_DT);
				    :CONTROL.M_COMM_DEL := 'P';
				    :SYSTEM.MESSAGE_LEVEL := 25;
				    POST;
				    :SYSTEM.MESSAGE_LEVEL := 15;
				    :CONTROL.M_COMM_DEL := NULL;	
				    :GLOBAL.M_PC_SYS_ID := :DUMMY.M_PC_SYS_ID ;	
					  GO_BLOCK('PT_IL_PREM_COLL');
					  EXECUTE_QUERY;	
					  GO_ITEM('DUMMY.M_FC_TOBE_PAID_AMOUNT');
					  :PT_IL_PREM_COLL.PC_PAID_DT := :PT_IL_POLICY.M_PAID_DT;	  
					END IF;*/
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void saveRecord(){
		CommonUtils.clearMaps(this);
		Connection con= null;
		CRUDHandler handler;
		P9ILPK_INVEST_PREM_COLL p9ilpk_invest_prem_coll = null;
		CommonUtils commonUtils = new CommonUtils();
		Double P_PC_FC_UNPAID_PREM_INT = 0.0;
		Double P_PC_LC_UNPAID_PREM_INT = 0.0;
		List<OracleParameter> retList = null;
		try{
			con = CommonUtils.getConnection();
			p9ilpk_invest_prem_coll = new P9ILPK_INVEST_PREM_COLL();
			
			if("Y".equalsIgnoreCase(compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_WAIVE_PREM_YN())){
				retList = p9ilpk_invest_prem_coll.P_CALC_UNPAID_PREM_INT(PT_IL_POLICY_BEAN.getPOL_SYS_ID(),
						compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID(),
						commonUtils.getCurrentDate(),0.0,0.0,P_PC_FC_UNPAID_PREM_INT,P_PC_LC_UNPAID_PREM_INT);
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_FC_UNPAID_PREM_INT((Double) retList.get(2)
						.getValueObject());
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_LC_UNPAID_PREM_INT((Double) retList.get(3)
						.getValueObject());
				
				System.out.println("list 2"+retList.get(2).getValueObject());
				System.out.println("list 3"+retList.get(3).getValueObject());
			}else{
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_FC_UNPAID_PREM_INT(0.0);
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_LC_UNPAID_PREM_INT(0.0);
			}
			System.out.println("flag1 ::::" +compositeAction.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().getPC_WAIVE_PREM_YN());
			System.out.println("flag2 ::::" +compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_FC_UNPAID_PREM_INT());
			System.out.println("flag3::::" +compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_LC_UNPAID_PREM_INT());
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_FC_UNPAID_PREM_INT().resetValue();
			compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_LC_UNPAID_PREM_INT().resetValue();
			con.commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Saved Successfully");
			}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Boolean allocateFlag = true;

	public Boolean getAllocateFlag() {
		return allocateFlag;
	}

	public void setAllocateFlag(Boolean allocateFlag) {
		this.allocateFlag = allocateFlag;
	}
	
	public void validateUI_M_PAID_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			PT_IL_POLICY_BEAN.setUI_M_PAID_DT((Date) value);

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		}
	}
	
	/*End*/

}