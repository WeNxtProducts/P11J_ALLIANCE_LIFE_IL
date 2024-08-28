package com.iii.pel.forms.PP039_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_B_LIFE_INS_LABEL;

	private HtmlOutputLabel COMP_UI_B_M_TO_DT_LABEL;

	private HtmlOutputLabel COMP_UI_B_M_FM_DT_LABEL;

	private HtmlOutputLabel COMP_UI_B_M_PROD_TO_LABEL;

	private HtmlOutputLabel COMP_UI_B_M_PROD_FM_LABEL;

	private HtmlOutputLabel COMP_UI_B_M_POLICY_TO_LABEL;

	private HtmlOutputLabel COMP_UI_B_M_POLICY_FM_LABEL;

	private HtmlOutputLabel COMP_UI_B_POLICY_LABEL_LABEL;

	private HtmlOutputLabel COMP_UI_B_PRODUCT_LABEL;

	private HtmlOutputLabel COMP_UI_B_DATE_LABEL;

	private HtmlOutputLabel COMP_UI_B_DRIP_YN_LABEL;

	private HtmlOutputLabel COMP_UI_B_POL_NO_LABEL;

	private HtmlOutputLabel COMP_UI_B_DRIP_DATE_LABEL;

	private HtmlOutputLabel COMP_UI_B_FUND_ALLO_LABEL;

	private HtmlOutputLabel COMP_UI_B_ACCNT_GEN_YN_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO;

	private HtmlInputText COMP_UI_M_POLICY_TO;

	private HtmlInputText COMP_UI_M_POLICY_FM;

	private HtmlInputText COMP_UI_M_PROD_FM;

	private HtmlInputText COMP_UI_M_PROD_TO;

	private HtmlInputText COMP_UI_M_PREM_IN_SI_CURR;

	private HtmlInputText COMP_UI_M_APPRV_DT_CHK;

	private HtmlInputText COMP_UI_M_POST_BO;

	private HtmlInputText COMP_UI_M_ACC_DOC_GEN_YN;

	private HtmlInputText COMP_UI_M_SRC_BUS_CODE;

	private HtmlInputText COMP_UI_M_PC_SYS_ID;

	private HtmlInputText COMP_UI_M_POL_PLAN_CODE;

	private HtmlCalendar COMP_UI_M_DRIPPING_DT;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlCalendar COMP_UI_M_APPRV_FM_DT;

	private HtmlCalendar COMP_UI_M_APPRV_TO_DT;

	private HtmlCalendar COMP_UI_M_ISS_END_DT;

	private HtmlSelectBooleanCheckbox COMP_GENERAL_INS;

	private HtmlSelectBooleanCheckbox COMP_LIFE_INS;

	private HtmlSelectBooleanCheckbox COMP_UI_M_ACCNT_GEN_YN;

	private HtmlCommandButton COMP_M_BUT_APPRV;

	private HtmlCommandButton COMP_M_BUT_EXIT;

	private ArrayList<LovBean> lovlist = new ArrayList<LovBean>();

	private DUMMY DUMMY_BEAN;

	private DUMMY_HELPER dummy_helper;

	public PP039_A_COMPOSITE_ACTION compositeAction;
	
	private HtmlOutputLabel COMP_CAPTION_LABEL;

	public void setCOMP_CAPTION_LABEL(HtmlOutputLabel comp_caption_label) {
		COMP_CAPTION_LABEL = comp_caption_label;
	}


	public DUMMY_ACTION() {

		DUMMY_BEAN = new DUMMY();
		dummy_helper = new DUMMY_HELPER();
		}
		
		
	public HtmlInputText getCOMP_UI_M_POL_NO() {
		return COMP_UI_M_POL_NO;
	}

	public void setCOMP_UI_M_POL_NO(HtmlInputText comp_ui_m_pol_no) {
		COMP_UI_M_POL_NO = comp_ui_m_pol_no;
	}

	public HtmlInputText getCOMP_UI_M_POLICY_TO() {
		return COMP_UI_M_POLICY_TO;
	}

	public void setCOMP_UI_M_POLICY_TO(HtmlInputText comp_ui_m_policy_to) {
		COMP_UI_M_POLICY_TO = comp_ui_m_policy_to;
	}

	public HtmlInputText getCOMP_UI_M_POLICY_FM() {
		return COMP_UI_M_POLICY_FM;
	}

	public void setCOMP_UI_M_POLICY_FM(HtmlInputText comp_ui_m_policy_fm) {
		COMP_UI_M_POLICY_FM = comp_ui_m_policy_fm;
	}

	public HtmlInputText getCOMP_UI_M_PROD_FM() {
		return COMP_UI_M_PROD_FM;
	}

	public void setCOMP_UI_M_PROD_FM(HtmlInputText comp_ui_m_prod_fm) {
		COMP_UI_M_PROD_FM = comp_ui_m_prod_fm;
	}

	public HtmlInputText getCOMP_UI_M_PROD_TO() {
		return COMP_UI_M_PROD_TO;
	}

	public void setCOMP_UI_M_PROD_TO(HtmlInputText comp_ui_m_prod_to) {
		COMP_UI_M_PROD_TO = comp_ui_m_prod_to;
	}

	public HtmlInputText getCOMP_UI_M_PREM_IN_SI_CURR() {
		return COMP_UI_M_PREM_IN_SI_CURR;
	}

	public void setCOMP_UI_M_PREM_IN_SI_CURR(
			HtmlInputText comp_ui_m_prem_in_si_curr) {
		COMP_UI_M_PREM_IN_SI_CURR = comp_ui_m_prem_in_si_curr;
	}

	public HtmlInputText getCOMP_UI_M_APPRV_DT_CHK() {
		return COMP_UI_M_APPRV_DT_CHK;
	}

	public void setCOMP_UI_M_APPRV_DT_CHK(HtmlInputText comp_ui_m_apprv_dt_chk) {
		COMP_UI_M_APPRV_DT_CHK = comp_ui_m_apprv_dt_chk;
	}

	public HtmlInputText getCOMP_UI_M_POST_BO() {
		return COMP_UI_M_POST_BO;
	}

	public void setCOMP_UI_M_POST_BO(HtmlInputText comp_ui_m_post_bo) {
		COMP_UI_M_POST_BO = comp_ui_m_post_bo;
	}

	public HtmlInputText getCOMP_UI_M_ACC_DOC_GEN_YN() {
		return COMP_UI_M_ACC_DOC_GEN_YN;
	}

	public void setCOMP_UI_M_ACC_DOC_GEN_YN(
			HtmlInputText comp_ui_m_acc_doc_gen_yn) {
		COMP_UI_M_ACC_DOC_GEN_YN = comp_ui_m_acc_doc_gen_yn;
	}

	public HtmlInputText getCOMP_UI_M_SRC_BUS_CODE() {
		return COMP_UI_M_SRC_BUS_CODE;
	}

	public void setCOMP_UI_M_SRC_BUS_CODE(HtmlInputText comp_ui_m_src_bus_code) {
		COMP_UI_M_SRC_BUS_CODE = comp_ui_m_src_bus_code;
	}

	public HtmlInputText getCOMP_UI_M_PC_SYS_ID() {
		return COMP_UI_M_PC_SYS_ID;
	}

	public void setCOMP_UI_M_PC_SYS_ID(HtmlInputText comp_ui_m_pc_sys_id) {
		COMP_UI_M_PC_SYS_ID = comp_ui_m_pc_sys_id;
	}

	public HtmlInputText getCOMP_UI_M_POL_PLAN_CODE() {
		return COMP_UI_M_POL_PLAN_CODE;
	}

	public void setCOMP_UI_M_POL_PLAN_CODE(HtmlInputText comp_ui_m_pol_plan_code) {
		COMP_UI_M_POL_PLAN_CODE = comp_ui_m_pol_plan_code;
	}

	public HtmlCalendar getCOMP_UI_M_DRIPPING_DT() {
		return COMP_UI_M_DRIPPING_DT;
	}

	public void setCOMP_UI_M_DRIPPING_DT(HtmlCalendar comp_ui_m_dripping_dt) {
		COMP_UI_M_DRIPPING_DT = comp_ui_m_dripping_dt;
	}

	public HtmlCalendar getCOMP_UI_M_FM_DT() {
		return COMP_UI_M_FM_DT;
	}

	public void setCOMP_UI_M_FM_DT(HtmlCalendar comp_ui_m_fm_dt) {
		COMP_UI_M_FM_DT = comp_ui_m_fm_dt;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DT() {
		return COMP_UI_M_TO_DT;
	}

	public void setCOMP_UI_M_TO_DT(HtmlCalendar comp_ui_m_to_dt) {
		COMP_UI_M_TO_DT = comp_ui_m_to_dt;
	}

	public HtmlCalendar getCOMP_UI_M_APPRV_FM_DT() {
		return COMP_UI_M_APPRV_FM_DT;
	}

	public void setCOMP_UI_M_APPRV_FM_DT(HtmlCalendar comp_ui_m_apprv_fm_dt) {
		COMP_UI_M_APPRV_FM_DT = comp_ui_m_apprv_fm_dt;
	}

	public HtmlCalendar getCOMP_UI_M_APPRV_TO_DT() {
		return COMP_UI_M_APPRV_TO_DT;
	}

	public void setCOMP_UI_M_APPRV_TO_DT(HtmlCalendar comp_ui_m_apprv_to_dt) {
		COMP_UI_M_APPRV_TO_DT = comp_ui_m_apprv_to_dt;
	}

	public HtmlCalendar getCOMP_UI_M_ISS_END_DT() {
		return COMP_UI_M_ISS_END_DT;
	}

	public void setCOMP_UI_M_ISS_END_DT(HtmlCalendar comp_ui_m_iss_end_dt) {
		COMP_UI_M_ISS_END_DT = comp_ui_m_iss_end_dt;
	}

	public HtmlSelectBooleanCheckbox getCOMP_GENERAL_INS() {
		return COMP_GENERAL_INS;
	}

	public void setCOMP_GENERAL_INS(HtmlSelectBooleanCheckbox comp_general_ins) {
		COMP_GENERAL_INS = comp_general_ins;
	}

	public HtmlSelectBooleanCheckbox getCOMP_LIFE_INS() {
		return COMP_LIFE_INS;
	}

	public void setCOMP_LIFE_INS(HtmlSelectBooleanCheckbox comp_life_ins) {
		COMP_LIFE_INS = comp_life_ins;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}

	public DUMMY_HELPER getDummy_helper() {
		return dummy_helper;
	}

	public void setDummy_helper(DUMMY_HELPER dummy_helper) {
		this.dummy_helper = dummy_helper;
	}

	public PP039_A_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PP039_A_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public List<LovBean> prepareM_POL_NO_LOV(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovlist = itemUtil.P_CALL_LOV("PP039_A", "DUMMY", "M_POL_NO", null,
					null, null, null, null, (String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovlist;
	}

	public List<LovBean> prepareM_POLICY_FM_LOV(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovlist = itemUtil.P_CALL_LOV("PP039_A", "DUMMY", "M_POLICY_FM",
					null, null, null, null, null, (String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovlist;
	}

	public List<LovBean> prepareM_POLICY_TO_LOV(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovlist = itemUtil.P_CALL_LOV("PP039_A", "DUMMY", "M_POLICY_TO",
					null, null, null, null, null, (String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovlist;
	}

	public List<LovBean> prepareM_PROD_FM_LOV(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovlist = itemUtil.P_CALL_LOV("PP039_A", "DUMMY", "M_PROD_FM",
					null, null, null, null, null, (String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovlist;
	}

	public List<LovBean> prepareM_PROD_TO_LOV(Object value) {
		try {
			ListItemUtil itemUtil = new ListItemUtil();
			lovlist = itemUtil.P_CALL_LOV("PP039_A", "DUMMY", "M_PROD_TO",
					null, null, null, null, null, (String) value);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO_SUGGESTION", e.getMessage());
		}
		return lovlist;
	}

	public void listener_M_POLICY_TO(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_POLICY_TO((String) new CommonUtils()
			.SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POLICY_FM(), input
					.getSubmittedValue(), "String"));
			ErrorHelpUtil.validate(input, getErrorMap());

			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POLICY_To", e.getMessage());
		}
	}

	public void listener_M_POLICY_FM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_POLICY_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(input.getSubmittedValue(), "String"));
			ErrorHelpUtil.validate(input, getErrorMap());

			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POLICY_To", e.getMessage());
		}
	}

	public void listener_M_PROD_FM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_PROD_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(input.getSubmittedValue(), "String"));
			ErrorHelpUtil.validate(input, getErrorMap());
			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_PROD_FM", e.getMessage());
		}
	}

	public void listener_M_PROD_TO(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_PROD_TO((String) new CommonUtils()
			.SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_PROD_FM(), input
					.getSubmittedValue(), "String"));
			
			ErrorHelpUtil.validate(input, getErrorMap());
			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_PROD_TO", e.getMessage());
		}
	}
	
	/*Added by Jyoti(55315) as per Ganesh Instruction on 2nd Mar'12*/
	public void validateUI_M_POL_NO(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_POL_NO((String) value);
		try {
			dummy_helper.WHEN_VALIDATE_ITEM_M_POL_NO((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateM_POLICY_FM(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_POLICY_FM((String) value);
		try {
		    dummy_helper.checkValidPOlicy(DUMMY_BEAN.getUI_M_POLICY_FM());
			dummy_helper.WHEN_VALIDATE_ITEM_M_POLICY_FM((String) value,
					DUMMY_BEAN.getUI_M_POLICY_TO());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	

	public void validateM_POLICY_TO(FacesContext context,
			UIComponent component, Object value) {
		DUMMY_BEAN.setUI_M_POLICY_TO((String) value);
		try {
			dummy_helper.WHEN_VALIDATE_ITEM_M_POLICY_TO(DUMMY_BEAN
					.getUI_M_POLICY_FM(), (String) value );
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateM_PROD_FM(FacesContext context, UIComponent component,
			Object value) {
		DUMMY_BEAN.setUI_M_PROD_FM((String) value);
		try {
			dummy_helper.WHEN_VALIDATE_ITEM_M_PROD_FM((String) value,
					DUMMY_BEAN.getUI_M_PROD_TO());
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateM_PROD_TO(FacesContext context, UIComponent component,
			Object value) {
		DUMMY_BEAN.setUI_M_PROD_TO((String) value);
		try {
			dummy_helper.WHEN_VALIDATE_ITEM_M_PROD_TO(DUMMY_BEAN
					.getUI_M_PROD_FM(), (String) value );
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateM_FM_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_FM_DT((Date) value);
			dummy_helper.WHEN_VALIDATE_ITEM_M_FM_DT(this);
			COMP_UI_M_FM_DT.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateM_TO_DT(FacesContext context, UIComponent component,
			Object value) {
		try {
			DUMMY_BEAN.setUI_M_TO_DT((Date) value);
			dummy_helper.WHEN_VALIDATE_ITEM_M_TO_DT(this);
			COMP_UI_M_TO_DT.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateGENERAL_INS(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				DUMMY_BEAN.setGENERAL_INS("Y");
			} else {
				DUMMY_BEAN.setGENERAL_INS("N");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateLIFE_INS(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {
			if ((Boolean) value) {
				DUMMY_BEAN.setLIFE_INS("Y");
			} else {
				DUMMY_BEAN.setLIFE_INS("N");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateUI_M_ACCNT_GEN_YN(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			if ((Boolean) value) {
				DUMMY_BEAN.setUI_M_ACCNT_GEN_YN("Y");
			} else {
				DUMMY_BEAN.setUI_M_ACCNT_GEN_YN("N");
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public String onclickOK() {

		try {
			dummy_helper.WHEN_BUTTON_PRESS_M_BUT_APPRV(this);
			dummy_helper.checkValidPOlicy(DUMMY_BEAN.getUI_M_POLICY_FM());
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Processing Completed");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
			"Processing Completed");

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("COPY_OK", e.getMessage());
		}
		return "";
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				/*Added by Saranya on 07/04/2017*/
				Dripping_Process();
				if(getDRIP_PROCESS()==1){
					COMP_PANEL_GROUP_ID.setRendered(true);
					 
				}else{
					COMP_PANEL_GROUP_ID.setRendered(false);
					 
				}
				/*End*/
				dummy_helper.whenNewRecordInstance();
				dummy_helper.nameChange(compositeAction);
				DUMMY_BEAN.setUI_M_DRIPPING_DT(new CommonUtils()
						.getCurrentDate());
				DUMMY_BEAN.setUI_M_FM_DT(new CommonUtils().getCurrentDate());
				DUMMY_BEAN.setUI_M_TO_DT(new CommonUtils().getCurrentDate());
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();

			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_UI_B_LIFE_INS_LABEL() {
		return COMP_UI_B_LIFE_INS_LABEL;
	}

	public void setCOMP_UI_B_LIFE_INS_LABEL(
			HtmlOutputLabel comp_ui_b_life_ins_label) {
		COMP_UI_B_LIFE_INS_LABEL = comp_ui_b_life_ins_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_M_TO_DT_LABEL() {
		return COMP_UI_B_M_TO_DT_LABEL;
	}

	public void setCOMP_UI_B_M_TO_DT_LABEL(
			HtmlOutputLabel comp_ui_b_m_to_dt_label) {
		COMP_UI_B_M_TO_DT_LABEL = comp_ui_b_m_to_dt_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_M_FM_DT_LABEL() {
		return COMP_UI_B_M_FM_DT_LABEL;
	}

	public void setCOMP_UI_B_M_FM_DT_LABEL(
			HtmlOutputLabel comp_ui_b_m_fm_dt_label) {
		COMP_UI_B_M_FM_DT_LABEL = comp_ui_b_m_fm_dt_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_M_PROD_TO_LABEL() {
		return COMP_UI_B_M_PROD_TO_LABEL;
	}

	public void setCOMP_UI_B_M_PROD_TO_LABEL(
			HtmlOutputLabel comp_ui_b_m_prod_to_label) {
		COMP_UI_B_M_PROD_TO_LABEL = comp_ui_b_m_prod_to_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_M_PROD_FM_LABEL() {
		return COMP_UI_B_M_PROD_FM_LABEL;
	}

	public void setCOMP_UI_B_M_PROD_FM_LABEL(
			HtmlOutputLabel comp_ui_b_m_prod_fm_label) {
		COMP_UI_B_M_PROD_FM_LABEL = comp_ui_b_m_prod_fm_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_M_POLICY_TO_LABEL() {
		return COMP_UI_B_M_POLICY_TO_LABEL;
	}

	public void setCOMP_UI_B_M_POLICY_TO_LABEL(
			HtmlOutputLabel comp_ui_b_m_policy_to_label) {
		COMP_UI_B_M_POLICY_TO_LABEL = comp_ui_b_m_policy_to_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_M_POLICY_FM_LABEL() {
		return COMP_UI_B_M_POLICY_FM_LABEL;
	}

	public void setCOMP_UI_B_M_POLICY_FM_LABEL(
			HtmlOutputLabel comp_ui_b_m_policy_fm_label) {
		COMP_UI_B_M_POLICY_FM_LABEL = comp_ui_b_m_policy_fm_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_POLICY_LABEL_LABEL() {
		return COMP_UI_B_POLICY_LABEL_LABEL;
	}

	public void setCOMP_UI_B_POLICY_LABEL_LABEL(
			HtmlOutputLabel comp_ui_b_policy_label_label) {
		COMP_UI_B_POLICY_LABEL_LABEL = comp_ui_b_policy_label_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_PRODUCT_LABEL() {
		return COMP_UI_B_PRODUCT_LABEL;
	}

	public void setCOMP_UI_B_PRODUCT_LABEL(
			HtmlOutputLabel comp_ui_b_product_label) {
		COMP_UI_B_PRODUCT_LABEL = comp_ui_b_product_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_DATE_LABEL() {
		return COMP_UI_B_DATE_LABEL;
	}

	public void setCOMP_UI_B_DATE_LABEL(HtmlOutputLabel comp_ui_b_date_label) {
		COMP_UI_B_DATE_LABEL = comp_ui_b_date_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_DRIP_YN_LABEL() {
		return COMP_UI_B_DRIP_YN_LABEL;
	}

	public void setCOMP_UI_B_DRIP_YN_LABEL(
			HtmlOutputLabel comp_ui_b_drip_yn_label) {
		COMP_UI_B_DRIP_YN_LABEL = comp_ui_b_drip_yn_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_POL_NO_LABEL() {
		return COMP_UI_B_POL_NO_LABEL;
	}

	public void setCOMP_UI_B_POL_NO_LABEL(HtmlOutputLabel comp_ui_b_pol_no_label) {
		COMP_UI_B_POL_NO_LABEL = comp_ui_b_pol_no_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_DRIP_DATE_LABEL() {
		return COMP_UI_B_DRIP_DATE_LABEL;
	}

	public void setCOMP_UI_B_DRIP_DATE_LABEL(
			HtmlOutputLabel comp_ui_b_drip_date_label) {
		COMP_UI_B_DRIP_DATE_LABEL = comp_ui_b_drip_date_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_FUND_ALLO_LABEL() {
		return COMP_UI_B_FUND_ALLO_LABEL;
	}

	public void setCOMP_UI_B_FUND_ALLO_LABEL(
			HtmlOutputLabel comp_ui_b_fund_allo_label) {
		COMP_UI_B_FUND_ALLO_LABEL = comp_ui_b_fund_allo_label;
	}

	public HtmlOutputLabel getCOMP_UI_B_ACCNT_GEN_YN_LABEL() {
		return COMP_UI_B_ACCNT_GEN_YN_LABEL;
	}

	public void setCOMP_UI_B_ACCNT_GEN_YN_LABEL(
			HtmlOutputLabel comp_ui_b_accnt_gen_yn_label) {
		COMP_UI_B_ACCNT_GEN_YN_LABEL = comp_ui_b_accnt_gen_yn_label;
	}

	public ArrayList<LovBean> getLovlist() {
		return lovlist;
	}

	public void setLovlist(ArrayList<LovBean> lovlist) {
		this.lovlist = lovlist;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_M_ACCNT_GEN_YN() {
		return COMP_UI_M_ACCNT_GEN_YN;
	}

	public void setCOMP_UI_M_ACCNT_GEN_YN(
			HtmlSelectBooleanCheckbox comp_ui_m_accnt_gen_yn) {
		COMP_UI_M_ACCNT_GEN_YN = comp_ui_m_accnt_gen_yn;
	}

	public HtmlCommandButton getCOMP_M_BUT_APPRV() {
		return COMP_M_BUT_APPRV;
	}

	public void setCOMP_M_BUT_APPRV(HtmlCommandButton comp_m_but_apprv) {
		COMP_M_BUT_APPRV = comp_m_but_apprv;
	}

	public HtmlCommandButton getCOMP_M_BUT_EXIT() {
		return COMP_M_BUT_EXIT;
	}

	public void setCOMP_M_BUT_EXIT(HtmlCommandButton comp_m_but_exit) {
		COMP_M_BUT_EXIT = comp_m_but_exit;
	}


	public HtmlOutputLabel getCOMP_CAPTION_LABEL() {
		return COMP_CAPTION_LABEL;
	}

	
	/*Added by sarany for fund allocation process on 07-04-2017*/
	public Integer DRIP_PROCESS;
	public Integer getDRIP_PROCESS() {
		return DRIP_PROCESS;
	}

	public void setDRIP_PROCESS(Integer dRIP_PROCESS) {
		DRIP_PROCESS = dRIP_PROCESS;
	}
	
	public void Dripping_Process() {
		String CURSOR_C1 = "SELECT ps_value FROM PP_SYSTEM WHERE PS_TYPE='IL_CALC_MTHD'";
		ResultSet rs1 = null;
		Connection connection = null;
		int PS_VALUE=0;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			rs1 = handler.executeSelectStatement(CURSOR_C1, connection);
			if (rs1.next()) {
				PS_VALUE = rs1.getInt(1);
				setDRIP_PROCESS(PS_VALUE);
			}
			
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Drip", e.getMessage());
		}
		
	}

	private HtmlGraphicImage COMP_UI_M_SUG_IMG;

	public HtmlGraphicImage getCOMP_UI_M_SUG_IMG() {
		return COMP_UI_M_SUG_IMG;
	}


	public void setCOMP_UI_M_SUG_IMG(HtmlGraphicImage cOMP_UI_M_SUG_IMG) {
		COMP_UI_M_SUG_IMG = cOMP_UI_M_SUG_IMG;
	}
	 private HtmlPanelGroup COMP_PANEL_GROUP_ID;

	public HtmlPanelGroup getCOMP_PANEL_GROUP_ID() {
		return COMP_PANEL_GROUP_ID;
	}


	public void setCOMP_PANEL_GROUP_ID(HtmlPanelGroup cOMP_PANEL_GROUP_ID) {
		COMP_PANEL_GROUP_ID = cOMP_PANEL_GROUP_ID;
	}


	/*End*/

	public void fireFieldValidation1(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

}
