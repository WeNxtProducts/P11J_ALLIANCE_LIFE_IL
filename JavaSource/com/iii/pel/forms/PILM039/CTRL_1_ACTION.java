package com.iii.pel.forms.PILM039;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class CTRL_1_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_CP_USER_ID_LABEL;
	
	private HtmlInputText COMP_UI_M_CP_USER_ID;
	
	private HtmlOutputLabel COMP_UI_M_CP_FM_PROD_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_CP_FM_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_CP_TO_PROD_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_CP_TO_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_USER_ID_LABEL;

	private HtmlInputText COMP_UI_M_CP_DEST_USER_ID;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_FM_PROD_CODE_LABEL;

	private HtmlInputText COMP_UI_M_CP_DEST_FM_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_TO_PROD_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_CP_DEST_TO_PROD_CODE;

	private HtmlInputText COMP_UI_M_CP_USER_ID_DESC;

	private HtmlInputText COMP_UI_M_CP_FM_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CP_TO_PROD_CODE_DESC_LABEL;
	
	private HtmlInputText COMP_UI_M_CP_TO_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_USER_ID_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CP_DEST_USER_ID_DESC;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_FM_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CP_DEST_FM_PROD_DESC;

	private HtmlOutputLabel COMP_UI_M_CP_DEST_TO_PROD_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CP_DEST_TO_PROD_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private HtmlCommandButton COMP_BUT_LOV_CP_DEST_USER_ID;

	private HtmlCommandButton COMP_BUT_LOV_CP_DEST_FM_PROD_CODE;

	private HtmlCommandButton COMP_BUT_LOV_CP_DEST_TO_PROD_CODE;

	private CTRL_1 CTRL_1_BEAN;

	public CTRL_1_ACTION() {
		CTRL_1_BEAN = new CTRL_1();
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_USER_ID_LABEL() {
		return COMP_UI_M_CP_USER_ID_LABEL;
	}

	public void setCOMP_UI_M_CP_USER_ID_LABEL(
			HtmlOutputLabel comp_ui_m_cp_user_id_label) {
		COMP_UI_M_CP_USER_ID_LABEL = comp_ui_m_cp_user_id_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_FM_PROD_CODE_LABEL() {
		return COMP_UI_M_CP_FM_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_CP_FM_PROD_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_cp_fm_prod_code_label) {
		COMP_UI_M_CP_FM_PROD_CODE_LABEL = comp_ui_m_cp_fm_prod_code_label;
	}

	public HtmlInputText getCOMP_UI_M_CP_FM_PROD_CODE() {
		return COMP_UI_M_CP_FM_PROD_CODE;
	}

	public void setCOMP_UI_M_CP_FM_PROD_CODE(HtmlInputText comp_ui_m_cp_fm_prod_code) {
		COMP_UI_M_CP_FM_PROD_CODE = comp_ui_m_cp_fm_prod_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_TO_PROD_CODE_LABEL() {
		return COMP_UI_M_CP_TO_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_CP_TO_PROD_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_cp_to_prod_code_label) {
		COMP_UI_M_CP_TO_PROD_CODE_LABEL = comp_ui_m_cp_to_prod_code_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_USER_ID_LABEL() {
		return COMP_UI_M_CP_DEST_USER_ID_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_USER_ID() {
		return COMP_UI_M_CP_DEST_USER_ID;
	}

	public void setCOMP_UI_M_CP_DEST_USER_ID_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_USER_ID_LABEL) {
		this.COMP_UI_M_CP_DEST_USER_ID_LABEL = COMP_UI_M_CP_DEST_USER_ID_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_USER_ID(HtmlInputText COMP_UI_M_CP_DEST_USER_ID) {
		this.COMP_UI_M_CP_DEST_USER_ID = COMP_UI_M_CP_DEST_USER_ID;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_FM_PROD_CODE_LABEL() {
		return COMP_UI_M_CP_DEST_FM_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_FM_PROD_CODE() {
		return COMP_UI_M_CP_DEST_FM_PROD_CODE;
	}

	public void setCOMP_UI_M_CP_DEST_FM_PROD_CODE_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_FM_PROD_CODE_LABEL) {
		this.COMP_UI_M_CP_DEST_FM_PROD_CODE_LABEL = COMP_UI_M_CP_DEST_FM_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_FM_PROD_CODE(HtmlInputText COMP_UI_M_CP_DEST_FM_PROD_CODE) {
		this.COMP_UI_M_CP_DEST_FM_PROD_CODE = COMP_UI_M_CP_DEST_FM_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_TO_PROD_CODE_LABEL() {
		return COMP_UI_M_CP_DEST_TO_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_TO_PROD_CODE() {
		return COMP_UI_M_CP_DEST_TO_PROD_CODE;
	}

	public void setCOMP_UI_M_CP_DEST_TO_PROD_CODE_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_TO_PROD_CODE_LABEL) {
		this.COMP_UI_M_CP_DEST_TO_PROD_CODE_LABEL = COMP_UI_M_CP_DEST_TO_PROD_CODE_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_TO_PROD_CODE(HtmlInputText COMP_UI_M_CP_DEST_TO_PROD_CODE) {
		this.COMP_UI_M_CP_DEST_TO_PROD_CODE = COMP_UI_M_CP_DEST_TO_PROD_CODE;
	}

	public HtmlInputText getCOMP_UI_M_CP_USER_ID() {
		return COMP_UI_M_CP_USER_ID;
	}

	public void setCOMP_UI_M_CP_USER_ID(HtmlInputText comp_ui_m_cp_user_id) {
		COMP_UI_M_CP_USER_ID = comp_ui_m_cp_user_id;
	}

	public HtmlInputText getCOMP_UI_M_CP_TO_PROD_CODE() {
		return COMP_UI_M_CP_TO_PROD_CODE;
	}

	public void setCOMP_UI_M_CP_TO_PROD_CODE(HtmlInputText comp_ui_m_cp_to_prod_code) {
		COMP_UI_M_CP_TO_PROD_CODE = comp_ui_m_cp_to_prod_code;
	}

	public HtmlInputText getCOMP_UI_M_CP_USER_ID_DESC() {
		return COMP_UI_M_CP_USER_ID_DESC;
	}

	public void setCOMP_UI_M_CP_USER_ID_DESC(HtmlInputText comp_ui_m_cp_user_id_desc) {
		COMP_UI_M_CP_USER_ID_DESC = comp_ui_m_cp_user_id_desc;
	}

	public HtmlInputText getCOMP_UI_M_CP_FM_PROD_CODE_DESC() {
		return COMP_UI_M_CP_FM_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_CP_FM_PROD_CODE_DESC(
			HtmlInputText comp_ui_m_cp_fm_prod_code_desc) {
		COMP_UI_M_CP_FM_PROD_CODE_DESC = comp_ui_m_cp_fm_prod_code_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_TO_PROD_CODE_DESC_LABEL() {
		return COMP_UI_M_CP_TO_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_CP_TO_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_cp_to_prod_code_desc_label) {
		COMP_UI_M_CP_TO_PROD_CODE_DESC_LABEL = comp_ui_m_cp_to_prod_code_desc_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_USER_ID_DESC_LABEL() {
		return COMP_UI_M_CP_DEST_USER_ID_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_USER_ID_DESC() {
		return COMP_UI_M_CP_DEST_USER_ID_DESC;
	}

	public void setCOMP_UI_M_CP_DEST_USER_ID_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_USER_ID_DESC_LABEL) {
		this.COMP_UI_M_CP_DEST_USER_ID_DESC_LABEL = COMP_UI_M_CP_DEST_USER_ID_DESC_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_USER_ID_DESC(HtmlInputText COMP_UI_M_CP_DEST_USER_ID_DESC) {
		this.COMP_UI_M_CP_DEST_USER_ID_DESC = COMP_UI_M_CP_DEST_USER_ID_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_FM_PROD_DESC_LABEL() {
		return COMP_UI_M_CP_DEST_FM_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_FM_PROD_DESC() {
		return COMP_UI_M_CP_DEST_FM_PROD_DESC;
	}

	public void setCOMP_UI_M_CP_DEST_FM_PROD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_FM_PROD_DESC_LABEL) {
		this.COMP_UI_M_CP_DEST_FM_PROD_DESC_LABEL = COMP_UI_M_CP_DEST_FM_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_FM_PROD_DESC(HtmlInputText COMP_UI_M_CP_DEST_FM_PROD_DESC) {
		this.COMP_UI_M_CP_DEST_FM_PROD_DESC = COMP_UI_M_CP_DEST_FM_PROD_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_CP_DEST_TO_PROD_DESC_LABEL() {
		return COMP_UI_M_CP_DEST_TO_PROD_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CP_DEST_TO_PROD_DESC() {
		return COMP_UI_M_CP_DEST_TO_PROD_DESC;
	}

	public void setCOMP_UI_M_CP_DEST_TO_PROD_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CP_DEST_TO_PROD_DESC_LABEL) {
		this.COMP_UI_M_CP_DEST_TO_PROD_DESC_LABEL = COMP_UI_M_CP_DEST_TO_PROD_DESC_LABEL;
	}

	public void setCOMP_UI_M_CP_DEST_TO_PROD_DESC(HtmlInputText COMP_UI_M_CP_DEST_TO_PROD_DESC) {
		this.COMP_UI_M_CP_DEST_TO_PROD_DESC = COMP_UI_M_CP_DEST_TO_PROD_DESC;
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

	public HtmlCommandButton getCOMP_BUT_LOV_CP_DEST_USER_ID() {
		return COMP_BUT_LOV_CP_DEST_USER_ID;
	}

	public void setCOMP_BUT_LOV_CP_DEST_USER_ID(HtmlCommandButton COMP_BUT_LOV_CP_DEST_USER_ID) {
		this.COMP_BUT_LOV_CP_DEST_USER_ID = COMP_BUT_LOV_CP_DEST_USER_ID;
	}

	public HtmlCommandButton getCOMP_BUT_LOV_CP_DEST_FM_PROD_CODE() {
		return COMP_BUT_LOV_CP_DEST_FM_PROD_CODE;
	}

	public void setCOMP_BUT_LOV_CP_DEST_FM_PROD_CODE(HtmlCommandButton COMP_BUT_LOV_CP_DEST_FM_PROD_CODE) {
		this.COMP_BUT_LOV_CP_DEST_FM_PROD_CODE = COMP_BUT_LOV_CP_DEST_FM_PROD_CODE;
	}

	public HtmlCommandButton getCOMP_BUT_LOV_CP_DEST_TO_PROD_CODE() {
		return COMP_BUT_LOV_CP_DEST_TO_PROD_CODE;
	}

	public void setCOMP_BUT_LOV_CP_DEST_TO_PROD_CODE(HtmlCommandButton COMP_BUT_LOV_CP_DEST_TO_PROD_CODE) {
		this.COMP_BUT_LOV_CP_DEST_TO_PROD_CODE = COMP_BUT_LOV_CP_DEST_TO_PROD_CODE;
	}

	public CTRL_1 getCTRL_1_BEAN() {
		return CTRL_1_BEAN;
	}

	public void setCTRL_1_BEAN(CTRL_1 CTRL_1_BEAN) {
		this.CTRL_1_BEAN = CTRL_1_BEAN;
	}

	public HtmlInputText getCOMP_UI_M_CP_TO_PROD_CODE_DESC() {
		return COMP_UI_M_CP_TO_PROD_CODE_DESC;
	}

	public void setCOMP_UI_M_CP_TO_PROD_CODE_DESC(
			HtmlInputText comp_ui_m_cp_to_prod_code_desc) {
		COMP_UI_M_CP_TO_PROD_CODE_DESC = comp_ui_m_cp_to_prod_code_desc;
	}
	
	public String onOkButtonPress() throws ProcedureException, DBException {
		String returnValue = null;
		PILM039_HELPER helper = new PILM039_HELPER();
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_APPR_SETUP_COMPOSITE_ACTION compositeAction = (PM_IL_APPR_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_APPR_SETUP_COMPOSITE_ACTION");
		PM_IL_APPR_SETUP_ACTION headerAction = compositeAction.getPM_IL_APPR_SETUP_ACTION_BEAN();
		try {
			returnValue = helper.pilm039_ctrl_1_m_but_ok_when_button_pressed(headerAction);
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
		System.out.println(returnValue + "returnValue");
		return returnValue;
	}
	
	public String onCancelButtonPress() {
	
		return "PILM039_header";
	}
	
	public void copyUserAutoPopulate(ActionEvent ae) throws ProcedureException, DBException{
		
		//UIInput input = (UIInput) ae.getComponent().getParent();
	//	ErrorHelpUtil.validate(input, getErrorMap());

		
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();

		try {
			if (getCOMP_UI_M_CP_DEST_USER_ID().getSubmittedValue() != null&&!getCOMP_UI_M_CP_DEST_USER_ID().getSubmittedValue().toString().isEmpty()) {
				String USER_ID = (String) getCOMP_UI_M_CP_DEST_USER_ID().getSubmittedValue();
				List list = (ArrayList) newDeligate.P_VAL_USER_ID(USER_ID);
				String ERRORMESSAGE = newDeligate.P_VAL_USER_ID_Validation();
				if (list != null && list.size() > 0) {
					getCOMP_UI_M_CP_DEST_USER_ID_DESC().setSubmittedValue(list.get(0).toString());
				} else {
					getCOMP_UI_M_CP_DEST_USER_ID_DESC().setSubmittedValue("");
					throw new ValidatorException(new FacesMessage(ERRORMESSAGE));
				}
			}
			else{
				getCOMP_UI_M_CP_DEST_USER_ID_DESC().setSubmittedValue("");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			getErrorMap().put("current",
					e.getMessage());
			getErrorMap().put("copy", e.getMessage());
		}
	}
	
	public void copyFromProdCodeAutoPopulate(ActionEvent ae) throws Exception{
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		PILM039_HELPER helper=new PILM039_HELPER();
		Object valueObject = getCOMP_UI_M_CP_DEST_FM_PROD_CODE().getSubmittedValue();

		System.out.println("getCOMP_UI_M_CP_DEST_FM_PROD_CODE().getSubmittedValue(): " + valueObject);
		try {
			if (valueObject != null && !((String) valueObject).trim().equals("")) {
				String USER_ID = (String) getCOMP_UI_M_CP_DEST_FM_PROD_CODE().getSubmittedValue();
				List list = (ArrayList) helper.L_VAL_PROD(USER_ID,CommonUtils.getConnection(),getErrorMap(),getWarningMap());
				if (list != null && list.size() > 0) {
					getCOMP_UI_M_CP_DEST_FM_PROD_DESC().setSubmittedValue(list.get(0).toString());
				} else {
					getCOMP_UI_M_CP_DEST_FM_PROD_DESC().setSubmittedValue("");
					throw new ValidatorException(new FacesMessage("From product code not available"));
				}
			}
			else{
				getCOMP_UI_M_CP_DEST_FM_PROD_DESC().setSubmittedValue("");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}


	}
	
	public void copyToProdCodeAutoPopulate(ActionEvent ae) throws Exception{
		PILM039_DELIGATE newDeligate = new PILM039_DELIGATE();
		PILM039_HELPER helper=new PILM039_HELPER();
		Object valueObject = getCOMP_UI_M_CP_DEST_TO_PROD_CODE().getSubmittedValue();
		System.out.println("getCOMP_UI_M_CP_DEST_TO_PROD_CODE().getSubmittedValue(): " + valueObject);
		
		
			try {
				if (valueObject != null && !((String) valueObject).trim().equals("")) {
					String USER_ID = (String) getCOMP_UI_M_CP_DEST_TO_PROD_CODE().getSubmittedValue();
					List list = (ArrayList) helper.L_VAL_PROD(USER_ID,CommonUtils.getConnection(),getErrorMap(),getWarningMap());
				if (list != null && list.size() > 0) {
					getCOMP_UI_M_CP_DEST_TO_PROD_DESC().setSubmittedValue(list.get(0).toString());
				} else {
					getCOMP_UI_M_CP_DEST_TO_PROD_DESC().setSubmittedValue("");
					throw new ValidatorException(new FacesMessage("From product code not available"));
				}
			}
			else{
				getCOMP_UI_M_CP_DEST_TO_PROD_DESC().setSubmittedValue("");
			}
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			
		
	}
}
