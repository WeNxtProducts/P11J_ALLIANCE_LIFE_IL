package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILM003;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class COPY_PLAN_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_PLAN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_PLAN_DESC;

	private HtmlOutputLabel COMP_UI_M_NEW_PLAN_CODE_LABEL;

	private HtmlInputText COMP_UI_M_NEW_PLAN_CODE;

	private HtmlOutputLabel COMP_UI_M_NEW_PLAN_DESC_LABEL;

	private HtmlInputText COMP_UI_M_NEW_PLAN_DESC;


	private HtmlCommandButton COMP_UI_M_BUT_OK;

	private HtmlCommandButton COMP_UI_M_BUT_CANCEL;

	private COPY_PLAN COPY_PLAN_BEAN;
	
	private ArrayList<LovBean> lovList = new ArrayList<LovBean>();

	public PILM003_APAC_COMPOSITE_ACTION compositeAction;

	private COPY_PLAN_HELPER helper;

	public COPY_PLAN_ACTION() {

		COPY_PLAN_BEAN = new COPY_PLAN();
		helper = new COPY_PLAN_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_PLAN_CODE_LABEL() {
		return COMP_UI_M_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_CODE() {
		return COMP_UI_M_PLAN_CODE;
	}

	public void setCOMP_UI_M_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_PLAN_CODE_LABEL) {
		this.COMP_UI_M_PLAN_CODE_LABEL = COMP_UI_M_PLAN_CODE_LABEL;
	}

	public void setCOMP_UI_M_PLAN_CODE(HtmlInputText COMP_UI_M_PLAN_CODE) {
		this.COMP_UI_M_PLAN_CODE = COMP_UI_M_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PLAN_DESC_LABEL() {
		return COMP_UI_M_PLAN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PLAN_DESC() {
		return COMP_UI_M_PLAN_DESC;
	}

	public void setCOMP_UI_M_PLAN_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_PLAN_DESC_LABEL) {
		this.COMP_UI_M_PLAN_DESC_LABEL = COMP_UI_M_PLAN_DESC_LABEL;
	}

	public void setCOMP_UI_M_PLAN_DESC(HtmlInputText COMP_UI_M_PLAN_DESC) {
		this.COMP_UI_M_PLAN_DESC = COMP_UI_M_PLAN_DESC;
	}

	public HtmlOutputLabel getCOMP_UI_M_NEW_PLAN_CODE_LABEL() {
		return COMP_UI_M_NEW_PLAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_NEW_PLAN_CODE() {
		return COMP_UI_M_NEW_PLAN_CODE;
	}

	public void setCOMP_UI_M_NEW_PLAN_CODE_LABEL(
			HtmlOutputLabel COMP_UI_M_NEW_PLAN_CODE_LABEL) {
		this.COMP_UI_M_NEW_PLAN_CODE_LABEL = COMP_UI_M_NEW_PLAN_CODE_LABEL;
	}

	public void setCOMP_UI_M_NEW_PLAN_CODE(HtmlInputText COMP_UI_M_NEW_PLAN_CODE) {
		this.COMP_UI_M_NEW_PLAN_CODE = COMP_UI_M_NEW_PLAN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_NEW_PLAN_DESC_LABEL() {
		return COMP_UI_M_NEW_PLAN_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_NEW_PLAN_DESC() {
		return COMP_UI_M_NEW_PLAN_DESC;
	}

	public void setCOMP_UI_M_NEW_PLAN_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_NEW_PLAN_DESC_LABEL) {
		this.COMP_UI_M_NEW_PLAN_DESC_LABEL = COMP_UI_M_NEW_PLAN_DESC_LABEL;
	}

	public void setCOMP_UI_M_NEW_PLAN_DESC(HtmlInputText COMP_UI_M_NEW_PLAN_DESC) {
		this.COMP_UI_M_NEW_PLAN_DESC = COMP_UI_M_NEW_PLAN_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public COPY_PLAN getCOPY_PLAN_BEAN() {
		return COPY_PLAN_BEAN;
	}

	public void setCOPY_PLAN_BEAN(COPY_PLAN COPY_PLAN_BEAN) {
		this.COPY_PLAN_BEAN = COPY_PLAN_BEAN;
	}

	public void saveRecord() {
		try {
			if (getCOPY_PLAN_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getCOPY_PLAN_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getCOPY_PLAN_BEAN(),
						CommonUtils.getConnection());
			}
			CommonUtils.getConnection().commit();
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
				copyDetails();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CANCEL() {
		return COMP_UI_M_BUT_CANCEL;
	}

	public void setCOMP_UI_M_BUT_CANCEL(HtmlCommandButton comp_ui_m_but_cancel) {
		COMP_UI_M_BUT_CANCEL = comp_ui_m_but_cancel;
	}

	
	public void copyDetails(){
		COPY_PLAN_BEAN.setUI_M_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
		COPY_PLAN_BEAN.setUI_M_PLAN_DESC(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getUI_M_PLAN_DESC());
		COPY_PLAN_BEAN.setUI_M_NEW_PLAN_CODE(null);
		COPY_PLAN_BEAN.setUI_M_NEW_PLAN_DESC(null);
	}
	
	public void validateM_NEW_PLAN_CODE(FacesContext context,
			UIComponent component, Object value){
		try{
			String M_NEW_PLAN_CODE = (String)value;
			COPY_PLAN_BEAN.setUI_M_NEW_PLAN_CODE(M_NEW_PLAN_CODE);
			helper.validate_M_NEW_PLAN_CODE(COPY_PLAN_BEAN, M_NEW_PLAN_CODE);
			COMP_UI_M_NEW_PLAN_DESC.resetValue();
		}catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public String M_BUT_OK() throws Exception {

		try {
			if (COPY_PLAN_BEAN.getUI_M_NEW_PLAN_CODE() != null) {
				new PKG_PILM003().L_COPY_PLAN_DTLS(COPY_PLAN_BEAN
						.getUI_M_NEW_PLAN_CODE(), COPY_PLAN_BEAN
						.getUI_M_PLAN_CODE());
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().
							setROWID(getRowId(COPY_PLAN_BEAN.getUI_M_NEW_PLAN_CODE()));
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().setBlockFlag(true);
				compositeAction.getPM_IL_PLAN_ACTION_BEAN().setFormFlag(true);
			}
		} catch (ProcedureException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

		return "PILM003_APAC_PM_IL_PLAN";
	}
	
	private String getRowId(String code) throws Exception{
		Connection con  = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String query = "SELECT ROWID FROM PM_IL_PLAN WHERE PLAN_CODE = ?";
		String rowId = null;
		try {
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, con,
					new Object[] { code });
			if (rs.next()) {
				rowId = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return rowId;
		
	}
	
	public String M_BUT_CANCEL(){
		return "PILM003_APAC_PM_IL_PLAN";
	}
	
}
