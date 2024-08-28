package com.iii.pel.forms.PILQ003;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_ASSR_MED_HIST_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POAD_ASSR_CODE_LABEL;

	private HtmlInputText COMP_UI_M_POAD_ASSR_CODE;

	private HtmlOutputLabel COMP_UI_M_POAD_ASSR_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_POAD_ASSR_CODE_DESC;

	private HtmlOutputLabel COMP_PAMH_FIELD_01_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_01;

	private HtmlOutputLabel COMP_PAMH_FIELD_02_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_02;

	private HtmlOutputLabel COMP_PAMH_FIELD_03_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_03;

	private HtmlOutputLabel COMP_PAMH_FIELD_04_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_04;

	private HtmlOutputLabel COMP_PAMH_FIELD_05_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_05;

	private HtmlOutputLabel COMP_PAMH_FIELD_06_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_06;

	private HtmlOutputLabel COMP_PAMH_FIELD_07_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_07;

	private HtmlOutputLabel COMP_PAMH_FIELD_08_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_08;

	private HtmlOutputLabel COMP_PAMH_FIELD_09_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_09;

	private HtmlOutputLabel COMP_PAMH_FIELD_10_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_10;

	private HtmlOutputLabel COMP_PAMH_FIELD_11_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_11;

	private HtmlOutputLabel COMP_PAMH_FIELD_12_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_12;

	private HtmlOutputLabel COMP_PAMH_FIELD_13_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_13;

	private HtmlOutputLabel COMP_PAMH_FIELD_14_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_14;

	private HtmlOutputLabel COMP_PAMH_FIELD_15_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_15;

	private HtmlOutputLabel COMP_PAMH_FIELD_16_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_16;

	private HtmlOutputLabel COMP_PAMH_FIELD_17_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_17;

	private HtmlOutputLabel COMP_PAMH_FIELD_18_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_18;

	private HtmlOutputLabel COMP_PAMH_FIELD_19_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_19;

	private HtmlOutputLabel COMP_PAMH_FIELD_20_LABEL;

	private HtmlInputText COMP_PAMH_FIELD_20;

	private PT_IL_POL_ASSR_MED_HIST_1 PT_IL_POL_ASSR_MED_HIST_1_BEAN;

	public PILQ003_COMPOSITE_ACTION compositeAction;

	private PT_IL_POL_ASSR_MED_HIST_1_HELPER helper;

	public PT_IL_POL_ASSR_MED_HIST_1_ACTION() {

		PT_IL_POL_ASSR_MED_HIST_1_BEAN = new PT_IL_POL_ASSR_MED_HIST_1();
		helper = new PT_IL_POL_ASSR_MED_HIST_1_HELPER();
		instantiateAllComponent();
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_11_LABEL() {
		return COMP_PAMH_FIELD_11_LABEL;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_11() {
		return COMP_PAMH_FIELD_11;
	}

	public void setCOMP_PAMH_FIELD_11_LABEL(
			HtmlOutputLabel COMP_PAMH_FIELD_11_LABEL) {
		this.COMP_PAMH_FIELD_11_LABEL = COMP_PAMH_FIELD_11_LABEL;
	}

	public void setCOMP_PAMH_FIELD_11(HtmlInputText COMP_PAMH_FIELD_11) {
		this.COMP_PAMH_FIELD_11 = COMP_PAMH_FIELD_11;
	}

	public PT_IL_POL_ASSR_MED_HIST_1 getPT_IL_POL_ASSR_MED_HIST_1_BEAN() {
		return PT_IL_POL_ASSR_MED_HIST_1_BEAN;
	}

	public void setPT_IL_POL_ASSR_MED_HIST_1_BEAN(
			PT_IL_POL_ASSR_MED_HIST_1 PT_IL_POL_ASSR_MED_HIST_1_BEAN) {
		this.PT_IL_POL_ASSR_MED_HIST_1_BEAN = PT_IL_POL_ASSR_MED_HIST_1_BEAN;
	}

	public void saveRecord() {
		String message = null;
		try {
			if (getPT_IL_POL_ASSR_MED_HIST_1_BEAN().getROWID() != null) {
				helper.preInsert(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
						.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
						compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(),
						getPT_IL_POL_ASSR_MED_HIST_1_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());

				new CRUDHandler().executeInsert(getPT_IL_POL_ASSR_MED_HIST_1_BEAN(), CommonUtils.getConnection());
				message = Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$save");
			} else {
				helper.preUpdate(getPT_IL_POL_ASSR_MED_HIST_1_BEAN(),
						compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN());
				new CRUDHandler().executeInsert(
						getPT_IL_POL_ASSR_MED_HIST_1_BEAN(), CommonUtils
								.getConnection());
				message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			}

			CommonUtils.getConnection().commit();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.executeQuery(compositeAction);
				if(PT_IL_POL_ASSR_MED_HIST_1_BEAN != null){
					helper.postQuery(compositeAction.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
							PT_IL_POL_ASSR_MED_HIST_1_BEAN);
				}else{
					
					helper.whenCreateRecord(compositeAction
							.getPT_IL_POL_ASSURED_DTLS_1_ACTION_BEAN()
							.getPT_IL_POL_ASSURED_DTLS_1_BEAN(),
							getPT_IL_POL_ASSR_MED_HIST_1_BEAN());
				}
				helper.whenNewBlockInstance(compositeAction);
				 setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void PAMH_FIELD_01_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_01 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_01(PAMH_FIELD_01);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_01);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_02_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_02 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_02(PAMH_FIELD_02);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_02);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_03_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_03 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_03(PAMH_FIELD_03);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_03);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_04_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_04 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_04(PAMH_FIELD_04);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_04);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_05_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_05 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_05(PAMH_FIELD_05);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_05);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_06_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_06 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_06(PAMH_FIELD_06);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_06);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_07_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_07 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_07(PAMH_FIELD_07);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_07);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_08_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_08 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_08(PAMH_FIELD_08);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_08);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_09_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_09 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_09(PAMH_FIELD_09);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_09);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_10_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_10 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_10(PAMH_FIELD_10);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_10);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_11_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_11 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_11(PAMH_FIELD_11);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_11);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_12_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_12 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_12(PAMH_FIELD_12);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_12);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_13_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_13 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_13(PAMH_FIELD_13);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_13);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_14_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_14 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_14(PAMH_FIELD_14);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_14);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_15_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_15 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_15(PAMH_FIELD_15);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_15);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_16_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_16 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_16(PAMH_FIELD_16);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_16);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_17_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_17 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_17(PAMH_FIELD_17);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_17);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_18_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_18 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_18(PAMH_FIELD_18);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_18);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_19_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_19 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_19(PAMH_FIELD_19);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_19);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void PAMH_FIELD_20_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String PAMH_FIELD_20 = (String) value;
		String fieldName = component.getId();
		try {
			getPT_IL_POL_ASSR_MED_HIST_1_BEAN().setPAMH_FIELD_20(PAMH_FIELD_20);
			helper.PAMH_FIELD_WHEN_VALIDATE_ITEM(fieldName, PAMH_FIELD_20);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_ASSR_CODE_LABEL() {
		return COMP_UI_M_POAD_ASSR_CODE_LABEL;
	}

	public void setCOMP_UI_M_POAD_ASSR_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_poad_assr_code_label) {
		COMP_UI_M_POAD_ASSR_CODE_LABEL = comp_ui_m_poad_assr_code_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_ASSR_CODE() {
		return COMP_UI_M_POAD_ASSR_CODE;
	}

	public void setCOMP_UI_M_POAD_ASSR_CODE(HtmlInputText comp_ui_m_poad_assr_code) {
		COMP_UI_M_POAD_ASSR_CODE = comp_ui_m_poad_assr_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POAD_ASSR_CODE_DESC_LABEL() {
		return COMP_UI_M_POAD_ASSR_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_POAD_ASSR_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_poad_assr_code_desc_label) {
		COMP_UI_M_POAD_ASSR_CODE_DESC_LABEL = comp_ui_m_poad_assr_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_POAD_ASSR_CODE_DESC() {
		return COMP_UI_M_POAD_ASSR_CODE_DESC;
	}

	public void setCOMP_UI_M_POAD_ASSR_CODE_DESC(
			HtmlInputText comp_ui_m_poad_assr_code_desc) {
		COMP_UI_M_POAD_ASSR_CODE_DESC = comp_ui_m_poad_assr_code_desc;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_01_LABEL() {
		return COMP_PAMH_FIELD_01_LABEL;
	}

	public void setCOMP_PAMH_FIELD_01_LABEL(HtmlOutputLabel comp_pamh_field_01_label) {
		COMP_PAMH_FIELD_01_LABEL = comp_pamh_field_01_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_01() {
		return COMP_PAMH_FIELD_01;
	}

	public void setCOMP_PAMH_FIELD_01(HtmlInputText comp_pamh_field_01) {
		COMP_PAMH_FIELD_01 = comp_pamh_field_01;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_02_LABEL() {
		return COMP_PAMH_FIELD_02_LABEL;
	}

	public void setCOMP_PAMH_FIELD_02_LABEL(HtmlOutputLabel comp_pamh_field_02_label) {
		COMP_PAMH_FIELD_02_LABEL = comp_pamh_field_02_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_02() {
		return COMP_PAMH_FIELD_02;
	}

	public void setCOMP_PAMH_FIELD_02(HtmlInputText comp_pamh_field_02) {
		COMP_PAMH_FIELD_02 = comp_pamh_field_02;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_03_LABEL() {
		return COMP_PAMH_FIELD_03_LABEL;
	}

	public void setCOMP_PAMH_FIELD_03_LABEL(HtmlOutputLabel comp_pamh_field_03_label) {
		COMP_PAMH_FIELD_03_LABEL = comp_pamh_field_03_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_03() {
		return COMP_PAMH_FIELD_03;
	}

	public void setCOMP_PAMH_FIELD_03(HtmlInputText comp_pamh_field_03) {
		COMP_PAMH_FIELD_03 = comp_pamh_field_03;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_04_LABEL() {
		return COMP_PAMH_FIELD_04_LABEL;
	}

	public void setCOMP_PAMH_FIELD_04_LABEL(HtmlOutputLabel comp_pamh_field_04_label) {
		COMP_PAMH_FIELD_04_LABEL = comp_pamh_field_04_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_04() {
		return COMP_PAMH_FIELD_04;
	}

	public void setCOMP_PAMH_FIELD_04(HtmlInputText comp_pamh_field_04) {
		COMP_PAMH_FIELD_04 = comp_pamh_field_04;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_05_LABEL() {
		return COMP_PAMH_FIELD_05_LABEL;
	}

	public void setCOMP_PAMH_FIELD_05_LABEL(HtmlOutputLabel comp_pamh_field_05_label) {
		COMP_PAMH_FIELD_05_LABEL = comp_pamh_field_05_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_05() {
		return COMP_PAMH_FIELD_05;
	}

	public void setCOMP_PAMH_FIELD_05(HtmlInputText comp_pamh_field_05) {
		COMP_PAMH_FIELD_05 = comp_pamh_field_05;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_06_LABEL() {
		return COMP_PAMH_FIELD_06_LABEL;
	}

	public void setCOMP_PAMH_FIELD_06_LABEL(HtmlOutputLabel comp_pamh_field_06_label) {
		COMP_PAMH_FIELD_06_LABEL = comp_pamh_field_06_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_06() {
		return COMP_PAMH_FIELD_06;
	}

	public void setCOMP_PAMH_FIELD_06(HtmlInputText comp_pamh_field_06) {
		COMP_PAMH_FIELD_06 = comp_pamh_field_06;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_07_LABEL() {
		return COMP_PAMH_FIELD_07_LABEL;
	}

	public void setCOMP_PAMH_FIELD_07_LABEL(HtmlOutputLabel comp_pamh_field_07_label) {
		COMP_PAMH_FIELD_07_LABEL = comp_pamh_field_07_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_07() {
		return COMP_PAMH_FIELD_07;
	}

	public void setCOMP_PAMH_FIELD_07(HtmlInputText comp_pamh_field_07) {
		COMP_PAMH_FIELD_07 = comp_pamh_field_07;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_08_LABEL() {
		return COMP_PAMH_FIELD_08_LABEL;
	}

	public void setCOMP_PAMH_FIELD_08_LABEL(HtmlOutputLabel comp_pamh_field_08_label) {
		COMP_PAMH_FIELD_08_LABEL = comp_pamh_field_08_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_08() {
		return COMP_PAMH_FIELD_08;
	}

	public void setCOMP_PAMH_FIELD_08(HtmlInputText comp_pamh_field_08) {
		COMP_PAMH_FIELD_08 = comp_pamh_field_08;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_09_LABEL() {
		return COMP_PAMH_FIELD_09_LABEL;
	}

	public void setCOMP_PAMH_FIELD_09_LABEL(HtmlOutputLabel comp_pamh_field_09_label) {
		COMP_PAMH_FIELD_09_LABEL = comp_pamh_field_09_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_09() {
		return COMP_PAMH_FIELD_09;
	}

	public void setCOMP_PAMH_FIELD_09(HtmlInputText comp_pamh_field_09) {
		COMP_PAMH_FIELD_09 = comp_pamh_field_09;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_10_LABEL() {
		return COMP_PAMH_FIELD_10_LABEL;
	}

	public void setCOMP_PAMH_FIELD_10_LABEL(HtmlOutputLabel comp_pamh_field_10_label) {
		COMP_PAMH_FIELD_10_LABEL = comp_pamh_field_10_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_10() {
		return COMP_PAMH_FIELD_10;
	}

	public void setCOMP_PAMH_FIELD_10(HtmlInputText comp_pamh_field_10) {
		COMP_PAMH_FIELD_10 = comp_pamh_field_10;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_12_LABEL() {
		return COMP_PAMH_FIELD_12_LABEL;
	}

	public void setCOMP_PAMH_FIELD_12_LABEL(HtmlOutputLabel comp_pamh_field_12_label) {
		COMP_PAMH_FIELD_12_LABEL = comp_pamh_field_12_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_12() {
		return COMP_PAMH_FIELD_12;
	}

	public void setCOMP_PAMH_FIELD_12(HtmlInputText comp_pamh_field_12) {
		COMP_PAMH_FIELD_12 = comp_pamh_field_12;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_13_LABEL() {
		return COMP_PAMH_FIELD_13_LABEL;
	}

	public void setCOMP_PAMH_FIELD_13_LABEL(HtmlOutputLabel comp_pamh_field_13_label) {
		COMP_PAMH_FIELD_13_LABEL = comp_pamh_field_13_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_13() {
		return COMP_PAMH_FIELD_13;
	}

	public void setCOMP_PAMH_FIELD_13(HtmlInputText comp_pamh_field_13) {
		COMP_PAMH_FIELD_13 = comp_pamh_field_13;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_14_LABEL() {
		return COMP_PAMH_FIELD_14_LABEL;
	}

	public void setCOMP_PAMH_FIELD_14_LABEL(HtmlOutputLabel comp_pamh_field_14_label) {
		COMP_PAMH_FIELD_14_LABEL = comp_pamh_field_14_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_14() {
		return COMP_PAMH_FIELD_14;
	}

	public void setCOMP_PAMH_FIELD_14(HtmlInputText comp_pamh_field_14) {
		COMP_PAMH_FIELD_14 = comp_pamh_field_14;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_15_LABEL() {
		return COMP_PAMH_FIELD_15_LABEL;
	}

	public void setCOMP_PAMH_FIELD_15_LABEL(HtmlOutputLabel comp_pamh_field_15_label) {
		COMP_PAMH_FIELD_15_LABEL = comp_pamh_field_15_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_15() {
		return COMP_PAMH_FIELD_15;
	}

	public void setCOMP_PAMH_FIELD_15(HtmlInputText comp_pamh_field_15) {
		COMP_PAMH_FIELD_15 = comp_pamh_field_15;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_16_LABEL() {
		return COMP_PAMH_FIELD_16_LABEL;
	}

	public void setCOMP_PAMH_FIELD_16_LABEL(HtmlOutputLabel comp_pamh_field_16_label) {
		COMP_PAMH_FIELD_16_LABEL = comp_pamh_field_16_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_16() {
		return COMP_PAMH_FIELD_16;
	}

	public void setCOMP_PAMH_FIELD_16(HtmlInputText comp_pamh_field_16) {
		COMP_PAMH_FIELD_16 = comp_pamh_field_16;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_17_LABEL() {
		return COMP_PAMH_FIELD_17_LABEL;
	}

	public void setCOMP_PAMH_FIELD_17_LABEL(HtmlOutputLabel comp_pamh_field_17_label) {
		COMP_PAMH_FIELD_17_LABEL = comp_pamh_field_17_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_17() {
		return COMP_PAMH_FIELD_17;
	}

	public void setCOMP_PAMH_FIELD_17(HtmlInputText comp_pamh_field_17) {
		COMP_PAMH_FIELD_17 = comp_pamh_field_17;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_18_LABEL() {
		return COMP_PAMH_FIELD_18_LABEL;
	}

	public void setCOMP_PAMH_FIELD_18_LABEL(HtmlOutputLabel comp_pamh_field_18_label) {
		COMP_PAMH_FIELD_18_LABEL = comp_pamh_field_18_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_18() {
		return COMP_PAMH_FIELD_18;
	}

	public void setCOMP_PAMH_FIELD_18(HtmlInputText comp_pamh_field_18) {
		COMP_PAMH_FIELD_18 = comp_pamh_field_18;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_19_LABEL() {
		return COMP_PAMH_FIELD_19_LABEL;
	}

	public void setCOMP_PAMH_FIELD_19_LABEL(HtmlOutputLabel comp_pamh_field_19_label) {
		COMP_PAMH_FIELD_19_LABEL = comp_pamh_field_19_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_19() {
		return COMP_PAMH_FIELD_19;
	}

	public void setCOMP_PAMH_FIELD_19(HtmlInputText comp_pamh_field_19) {
		COMP_PAMH_FIELD_19 = comp_pamh_field_19;
	}

	public HtmlOutputLabel getCOMP_PAMH_FIELD_20_LABEL() {
		return COMP_PAMH_FIELD_20_LABEL;
	}

	public void setCOMP_PAMH_FIELD_20_LABEL(HtmlOutputLabel comp_pamh_field_20_label) {
		COMP_PAMH_FIELD_20_LABEL = comp_pamh_field_20_label;
	}

	public HtmlInputText getCOMP_PAMH_FIELD_20() {
		return COMP_PAMH_FIELD_20;
	}

	public void setCOMP_PAMH_FIELD_20(HtmlInputText comp_pamh_field_20) {
		COMP_PAMH_FIELD_20 = comp_pamh_field_20;
	}

	public PILQ003_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILQ003_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public PT_IL_POL_ASSR_MED_HIST_1_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_POL_ASSR_MED_HIST_1_HELPER helper) {
		this.helper = helper;
	}


	/**
	 * Disables all components in PT_IL_POL_ASSR_MED_HIST_1_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_UI_M_POAD_ASSR_CODE.setDisabled(disabled);
		COMP_UI_M_POAD_ASSR_CODE_DESC.setDisabled(disabled);
		COMP_PAMH_FIELD_01.setDisabled(disabled);
		COMP_PAMH_FIELD_02.setDisabled(disabled);
		COMP_PAMH_FIELD_03.setDisabled(disabled);
		COMP_PAMH_FIELD_04.setDisabled(disabled);
		COMP_PAMH_FIELD_05.setDisabled(disabled);
		COMP_PAMH_FIELD_06.setDisabled(disabled);
		COMP_PAMH_FIELD_07.setDisabled(disabled);
		COMP_PAMH_FIELD_08.setDisabled(disabled);
		COMP_PAMH_FIELD_09.setDisabled(disabled);
		COMP_PAMH_FIELD_10.setDisabled(disabled);
		COMP_PAMH_FIELD_11.setDisabled(disabled);
		COMP_PAMH_FIELD_12.setDisabled(disabled);
		COMP_PAMH_FIELD_13.setDisabled(disabled);
		COMP_PAMH_FIELD_14.setDisabled(disabled);
		COMP_PAMH_FIELD_15.setDisabled(disabled);
		COMP_PAMH_FIELD_16.setDisabled(disabled);
		COMP_PAMH_FIELD_17.setDisabled(disabled);
		COMP_PAMH_FIELD_18.setDisabled(disabled);
		COMP_PAMH_FIELD_19.setDisabled(disabled);
		COMP_PAMH_FIELD_20.setDisabled(disabled);

	}


	/**
	 * Instantiates all components in PT_IL_POL_ASSR_MED_HIST_1_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_UI_M_POAD_ASSR_CODE			 = new HtmlInputText();
		COMP_UI_M_POAD_ASSR_CODE_DESC			 = new HtmlInputText();
		COMP_PAMH_FIELD_01				 = new HtmlInputText();
		COMP_PAMH_FIELD_02				 = new HtmlInputText();
		COMP_PAMH_FIELD_03				 = new HtmlInputText();
		COMP_PAMH_FIELD_04				 = new HtmlInputText();
		COMP_PAMH_FIELD_05				 = new HtmlInputText();
		COMP_PAMH_FIELD_06				 = new HtmlInputText();
		COMP_PAMH_FIELD_07				 = new HtmlInputText();
		COMP_PAMH_FIELD_08				 = new HtmlInputText();
		COMP_PAMH_FIELD_09				 = new HtmlInputText();
		COMP_PAMH_FIELD_10				 = new HtmlInputText();
		COMP_PAMH_FIELD_11				 = new HtmlInputText();
		COMP_PAMH_FIELD_12				 = new HtmlInputText();
		COMP_PAMH_FIELD_13				 = new HtmlInputText();
		COMP_PAMH_FIELD_14				 = new HtmlInputText();
		COMP_PAMH_FIELD_15				 = new HtmlInputText();
		COMP_PAMH_FIELD_16				 = new HtmlInputText();
		COMP_PAMH_FIELD_17				 = new HtmlInputText();
		COMP_PAMH_FIELD_18				 = new HtmlInputText();
		COMP_PAMH_FIELD_19				 = new HtmlInputText();
		COMP_PAMH_FIELD_20				 = new HtmlInputText();

		// Instantiating HtmlOutputLabel
		COMP_UI_M_POAD_ASSR_CODE_LABEL			 = new HtmlOutputLabel();
		COMP_UI_M_POAD_ASSR_CODE_DESC_LABEL		 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_01_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_02_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_03_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_04_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_05_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_06_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_07_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_08_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_09_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_10_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_11_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_12_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_13_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_14_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_15_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_16_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_17_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_18_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_19_LABEL			 = new HtmlOutputLabel();
		COMP_PAMH_FIELD_20_LABEL			 = new HtmlOutputLabel();

	}


}
