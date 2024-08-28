package com.iii.pel.forms.PT044_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_AGENT_TRAN_HDR_ACTION extends CommonAction {

	private HtmlOutputText COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_ATH_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ATH_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_ATH_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ATH_AGENT_NAME;

	private HtmlOutputLabel COMP_ATH_PARENT_CODE_LABEL;

	private HtmlInputText COMP_ATH_PARENT_CODE;

	private HtmlOutputLabel COMP_UI_M_ATH_PARENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ATH_PARENT_NAME;

	private HtmlOutputLabel COMP_ATH_DATE_LABEL;

	private HtmlCalendar COMP_ATH_DATE;

	private HtmlOutputLabel COMP_ATH_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_ATH_EFF_FM_DT;

	private HtmlOutputLabel COMP_ATH_TERMINATION_TYPE_LABEL;

	private HtmlInputText COMP_ATH_TERMINATION_TYPE;

	private HtmlOutputLabel COMP_UI_M_ATH_TERMINATION_DESC_LABEL;

	private HtmlInputText COMP_UI_M_ATH_TERMINATION_DESC;

	private HtmlOutputLabel COMP_ATH_AGENT_NEW_RANK_CODE_LABEL;

	private HtmlInputText COMP_ATH_AGENT_NEW_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_AGENT_NEW_RANK_DESC_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_NEW_RANK_DESC;

	private HtmlOutputLabel COMP_ATH_REVIEW1_DT_LABEL;

	private HtmlCalendar COMP_ATH_REVIEW1_DT;

	private HtmlOutputLabel COMP_ATH_REVIEW2_DT_LABEL;

	private HtmlCalendar COMP_ATH_REVIEW2_DT;

	private HtmlOutputLabel COMP_ATH_REVIEW3_DT_LABEL;

	private HtmlCalendar COMP_ATH_REVIEW3_DT;

	private HtmlOutputLabel COMP_ATH_REVIEW4_DT_LABEL;

	private HtmlCalendar COMP_ATH_REVIEW4_DT;

	private HtmlOutputLabel COMP_ATH_NEW_AGENT_CODE_LABEL;

	private HtmlInputText COMP_ATH_NEW_AGENT_CODE;

	private HtmlOutputLabel COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ATH_NEW_AGENT_NAME;

	private HtmlOutputLabel COMP_ATH_PRODN_TRANSFER_YN_LABEL;

	private HtmlSelectOneMenu COMP_ATH_PRODN_TRANSFER_YN;

	private HtmlCommandButton COMP_UI_M_BUT_TERM_TYPE_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_NEW_RANK_LOV;

	private HtmlCommandButton COMP_UI_M_ATH_AGENT_LOV;

	private HtmlCommandButton COMP_UI_M_ATH_PARENT_LOV;

	private HtmlCommandButton COMP_UI_M_ATH_NEW_AGENT_LOV;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private PT_AGENT_TRAN_HDR PT_AGENT_TRAN_HDR_BEAN;

	private PT044_A_DELEGATE delegate;

	private boolean proceedable;

	private PT044_A_HELPER helper;

	public PT044_A_COMPOSITE_ACTION compositeAction;

	List<SelectItem> itemListName = null;

	private List<PT_AGENT_TRAN_HDR> lovHeaderList = null;

	public PT_AGENT_TRAN_HDR_ACTION() {
		PT_AGENT_TRAN_HDR_BEAN = new PT_AGENT_TRAN_HDR();
		helper = new PT044_A_HELPER();
		delegate = new PT044_A_DELEGATE();
		// resetValues();
		itemListName = PT044_A_DELEGATE.getDropDownListValue("PT044_A",
				"PT_AGENT_TRAN_HDR", "PT_AGENT_TRAN_HDR.ATH_PRODN_TRANSFER_YN",
				"YESNO");
		System.out.println("MENU PARAM 1 :"
				+ CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"));
		System.out.println("MENU PARAM 2 :"
				+ CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2"));
		System.out.println("para 1 :"
				+ CommonUtils.getGlobalVariable("GLOBAL.M_PARA_1"));

	}

	public HtmlOutputLabel getCOMP_ATH_AGENT_CODE_LABEL() {
		return COMP_ATH_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATH_AGENT_CODE() {
		return COMP_ATH_AGENT_CODE;
	}

	public void setCOMP_ATH_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_ATH_AGENT_CODE_LABEL) {
		this.COMP_ATH_AGENT_CODE_LABEL = COMP_ATH_AGENT_CODE_LABEL;
	}

	public void setCOMP_ATH_AGENT_CODE(HtmlInputText COMP_ATH_AGENT_CODE) {
		this.COMP_ATH_AGENT_CODE = COMP_ATH_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATH_AGENT_NAME_LABEL() {
		return COMP_UI_M_ATH_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATH_AGENT_NAME() {
		return COMP_UI_M_ATH_AGENT_NAME;
	}

	public void setCOMP_UI_M_ATH_AGENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ATH_AGENT_NAME_LABEL) {
		this.COMP_UI_M_ATH_AGENT_NAME_LABEL = COMP_UI_M_ATH_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ATH_AGENT_NAME(
			HtmlInputText COMP_UI_M_ATH_AGENT_NAME) {
		this.COMP_UI_M_ATH_AGENT_NAME = COMP_UI_M_ATH_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_ATH_PARENT_CODE_LABEL() {
		return COMP_ATH_PARENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATH_PARENT_CODE() {
		return COMP_ATH_PARENT_CODE;
	}

	public void setCOMP_ATH_PARENT_CODE_LABEL(
			HtmlOutputLabel COMP_ATH_PARENT_CODE_LABEL) {
		this.COMP_ATH_PARENT_CODE_LABEL = COMP_ATH_PARENT_CODE_LABEL;
	}

	public void setCOMP_ATH_PARENT_CODE(HtmlInputText COMP_ATH_PARENT_CODE) {
		this.COMP_ATH_PARENT_CODE = COMP_ATH_PARENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATH_PARENT_NAME_LABEL() {
		return COMP_UI_M_ATH_PARENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATH_PARENT_NAME() {
		return COMP_UI_M_ATH_PARENT_NAME;
	}

	public void setCOMP_UI_M_ATH_PARENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ATH_PARENT_NAME_LABEL) {
		this.COMP_UI_M_ATH_PARENT_NAME_LABEL = COMP_UI_M_ATH_PARENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ATH_PARENT_NAME(
			HtmlInputText COMP_UI_M_ATH_PARENT_NAME) {
		this.COMP_UI_M_ATH_PARENT_NAME = COMP_UI_M_ATH_PARENT_NAME;
	}

	public HtmlOutputLabel getCOMP_ATH_DATE_LABEL() {
		return COMP_ATH_DATE_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_DATE() {
		return COMP_ATH_DATE;
	}

	public void setCOMP_ATH_DATE_LABEL(HtmlOutputLabel COMP_ATH_DATE_LABEL) {
		this.COMP_ATH_DATE_LABEL = COMP_ATH_DATE_LABEL;
	}

	public void setCOMP_ATH_DATE(HtmlCalendar COMP_ATH_DATE) {
		this.COMP_ATH_DATE = COMP_ATH_DATE;
	}

	public HtmlOutputLabel getCOMP_ATH_EFF_FM_DT_LABEL() {
		return COMP_ATH_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_EFF_FM_DT() {
		return COMP_ATH_EFF_FM_DT;
	}

	public void setCOMP_ATH_EFF_FM_DT_LABEL(
			HtmlOutputLabel COMP_ATH_EFF_FM_DT_LABEL) {
		this.COMP_ATH_EFF_FM_DT_LABEL = COMP_ATH_EFF_FM_DT_LABEL;
	}

	public void setCOMP_ATH_EFF_FM_DT(HtmlCalendar COMP_ATH_EFF_FM_DT) {
		this.COMP_ATH_EFF_FM_DT = COMP_ATH_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ATH_TERMINATION_TYPE_LABEL() {
		return COMP_ATH_TERMINATION_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_ATH_TERMINATION_TYPE() {
		return COMP_ATH_TERMINATION_TYPE;
	}

	public void setCOMP_ATH_TERMINATION_TYPE_LABEL(
			HtmlOutputLabel COMP_ATH_TERMINATION_TYPE_LABEL) {
		this.COMP_ATH_TERMINATION_TYPE_LABEL = COMP_ATH_TERMINATION_TYPE_LABEL;
	}

	public void setCOMP_ATH_TERMINATION_TYPE(
			HtmlInputText COMP_ATH_TERMINATION_TYPE) {
		this.COMP_ATH_TERMINATION_TYPE = COMP_ATH_TERMINATION_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATH_TERMINATION_DESC_LABEL() {
		return COMP_UI_M_ATH_TERMINATION_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATH_TERMINATION_DESC() {
		return COMP_UI_M_ATH_TERMINATION_DESC;
	}

	public void setCOMP_UI_M_ATH_TERMINATION_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_ATH_TERMINATION_DESC_LABEL) {
		this.COMP_UI_M_ATH_TERMINATION_DESC_LABEL = COMP_UI_M_ATH_TERMINATION_DESC_LABEL;
	}

	public void setCOMP_UI_M_ATH_TERMINATION_DESC(
			HtmlInputText COMP_UI_M_ATH_TERMINATION_DESC) {
		this.COMP_UI_M_ATH_TERMINATION_DESC = COMP_UI_M_ATH_TERMINATION_DESC;
	}

	public HtmlOutputLabel getCOMP_ATH_AGENT_NEW_RANK_CODE_LABEL() {
		return COMP_ATH_AGENT_NEW_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATH_AGENT_NEW_RANK_CODE() {
		return COMP_ATH_AGENT_NEW_RANK_CODE;
	}

	public void setCOMP_ATH_AGENT_NEW_RANK_CODE_LABEL(
			HtmlOutputLabel COMP_ATH_AGENT_NEW_RANK_CODE_LABEL) {
		this.COMP_ATH_AGENT_NEW_RANK_CODE_LABEL = COMP_ATH_AGENT_NEW_RANK_CODE_LABEL;
	}

	public void setCOMP_ATH_AGENT_NEW_RANK_CODE(
			HtmlInputText COMP_ATH_AGENT_NEW_RANK_CODE) {
		this.COMP_ATH_AGENT_NEW_RANK_CODE = COMP_ATH_AGENT_NEW_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_NEW_RANK_DESC_LABEL() {
		return COMP_UI_M_AGENT_NEW_RANK_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_NEW_RANK_DESC() {
		return COMP_UI_M_AGENT_NEW_RANK_DESC;
	}

	public void setCOMP_UI_M_AGENT_NEW_RANK_DESC_LABEL(
			HtmlOutputLabel COMP_UI_M_AGENT_NEW_RANK_DESC_LABEL) {
		this.COMP_UI_M_AGENT_NEW_RANK_DESC_LABEL = COMP_UI_M_AGENT_NEW_RANK_DESC_LABEL;
	}

	public void setCOMP_UI_M_AGENT_NEW_RANK_DESC(
			HtmlInputText COMP_UI_M_AGENT_NEW_RANK_DESC) {
		this.COMP_UI_M_AGENT_NEW_RANK_DESC = COMP_UI_M_AGENT_NEW_RANK_DESC;
	}

	public HtmlOutputLabel getCOMP_ATH_REVIEW1_DT_LABEL() {
		return COMP_ATH_REVIEW1_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_REVIEW1_DT() {
		return COMP_ATH_REVIEW1_DT;
	}

	public void setCOMP_ATH_REVIEW1_DT_LABEL(
			HtmlOutputLabel COMP_ATH_REVIEW1_DT_LABEL) {
		this.COMP_ATH_REVIEW1_DT_LABEL = COMP_ATH_REVIEW1_DT_LABEL;
	}

	public void setCOMP_ATH_REVIEW1_DT(HtmlCalendar COMP_ATH_REVIEW1_DT) {
		this.COMP_ATH_REVIEW1_DT = COMP_ATH_REVIEW1_DT;
	}

	public HtmlOutputLabel getCOMP_ATH_REVIEW2_DT_LABEL() {
		return COMP_ATH_REVIEW2_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_REVIEW2_DT() {
		return COMP_ATH_REVIEW2_DT;
	}

	public void setCOMP_ATH_REVIEW2_DT_LABEL(
			HtmlOutputLabel COMP_ATH_REVIEW2_DT_LABEL) {
		this.COMP_ATH_REVIEW2_DT_LABEL = COMP_ATH_REVIEW2_DT_LABEL;
	}

	public void setCOMP_ATH_REVIEW2_DT(HtmlCalendar COMP_ATH_REVIEW2_DT) {
		this.COMP_ATH_REVIEW2_DT = COMP_ATH_REVIEW2_DT;
	}

	public HtmlOutputLabel getCOMP_ATH_REVIEW3_DT_LABEL() {
		return COMP_ATH_REVIEW3_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_REVIEW3_DT() {
		return COMP_ATH_REVIEW3_DT;
	}

	public void setCOMP_ATH_REVIEW3_DT_LABEL(
			HtmlOutputLabel COMP_ATH_REVIEW3_DT_LABEL) {
		this.COMP_ATH_REVIEW3_DT_LABEL = COMP_ATH_REVIEW3_DT_LABEL;
	}

	public void setCOMP_ATH_REVIEW3_DT(HtmlCalendar COMP_ATH_REVIEW3_DT) {
		this.COMP_ATH_REVIEW3_DT = COMP_ATH_REVIEW3_DT;
	}

	public HtmlOutputLabel getCOMP_ATH_REVIEW4_DT_LABEL() {
		return COMP_ATH_REVIEW4_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ATH_REVIEW4_DT() {
		return COMP_ATH_REVIEW4_DT;
	}

	public void setCOMP_ATH_REVIEW4_DT_LABEL(
			HtmlOutputLabel COMP_ATH_REVIEW4_DT_LABEL) {
		this.COMP_ATH_REVIEW4_DT_LABEL = COMP_ATH_REVIEW4_DT_LABEL;
	}

	public void setCOMP_ATH_REVIEW4_DT(HtmlCalendar COMP_ATH_REVIEW4_DT) {
		this.COMP_ATH_REVIEW4_DT = COMP_ATH_REVIEW4_DT;
	}

	public HtmlOutputLabel getCOMP_ATH_NEW_AGENT_CODE_LABEL() {
		return COMP_ATH_NEW_AGENT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATH_NEW_AGENT_CODE() {
		return COMP_ATH_NEW_AGENT_CODE;
	}

	public void setCOMP_ATH_NEW_AGENT_CODE_LABEL(
			HtmlOutputLabel COMP_ATH_NEW_AGENT_CODE_LABEL) {
		this.COMP_ATH_NEW_AGENT_CODE_LABEL = COMP_ATH_NEW_AGENT_CODE_LABEL;
	}

	public void setCOMP_ATH_NEW_AGENT_CODE(HtmlInputText COMP_ATH_NEW_AGENT_CODE) {
		this.COMP_ATH_NEW_AGENT_CODE = COMP_ATH_NEW_AGENT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_ATH_NEW_AGENT_NAME_LABEL() {
		return COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ATH_NEW_AGENT_NAME() {
		return COMP_UI_M_ATH_NEW_AGENT_NAME;
	}

	public void setCOMP_UI_M_ATH_NEW_AGENT_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL) {
		this.COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL = COMP_UI_M_ATH_NEW_AGENT_NAME_LABEL;
	}

	public void setCOMP_UI_M_ATH_NEW_AGENT_NAME(
			HtmlInputText COMP_UI_M_ATH_NEW_AGENT_NAME) {
		this.COMP_UI_M_ATH_NEW_AGENT_NAME = COMP_UI_M_ATH_NEW_AGENT_NAME;
	}

	public HtmlOutputLabel getCOMP_ATH_PRODN_TRANSFER_YN_LABEL() {
		return COMP_ATH_PRODN_TRANSFER_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ATH_PRODN_TRANSFER_YN() {
		return COMP_ATH_PRODN_TRANSFER_YN;
	}

	public void setCOMP_ATH_PRODN_TRANSFER_YN_LABEL(
			HtmlOutputLabel COMP_ATH_PRODN_TRANSFER_YN_LABEL) {
		this.COMP_ATH_PRODN_TRANSFER_YN_LABEL = COMP_ATH_PRODN_TRANSFER_YN_LABEL;
	}

	public void setCOMP_ATH_PRODN_TRANSFER_YN(
			HtmlSelectOneMenu COMP_ATH_PRODN_TRANSFER_YN) {
		this.COMP_ATH_PRODN_TRANSFER_YN = COMP_ATH_PRODN_TRANSFER_YN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TERM_TYPE_LOV() {
		return COMP_UI_M_BUT_TERM_TYPE_LOV;
	}

	public void setCOMP_UI_M_BUT_TERM_TYPE_LOV(
			HtmlCommandButton COMP_UI_M_BUT_TERM_TYPE_LOV) {
		this.COMP_UI_M_BUT_TERM_TYPE_LOV = COMP_UI_M_BUT_TERM_TYPE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_NEW_RANK_LOV() {
		return COMP_UI_M_BUT_NEW_RANK_LOV;
	}

	public void setCOMP_UI_M_BUT_NEW_RANK_LOV(
			HtmlCommandButton COMP_UI_M_BUT_NEW_RANK_LOV) {
		this.COMP_UI_M_BUT_NEW_RANK_LOV = COMP_UI_M_BUT_NEW_RANK_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_ATH_AGENT_LOV() {
		return COMP_UI_M_ATH_AGENT_LOV;
	}

	public void setCOMP_UI_M_ATH_AGENT_LOV(
			HtmlCommandButton COMP_UI_M_ATH_AGENT_LOV) {
		this.COMP_UI_M_ATH_AGENT_LOV = COMP_UI_M_ATH_AGENT_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_ATH_PARENT_LOV() {
		return COMP_UI_M_ATH_PARENT_LOV;
	}

	public void setCOMP_UI_M_ATH_PARENT_LOV(
			HtmlCommandButton COMP_UI_M_ATH_PARENT_LOV) {
		this.COMP_UI_M_ATH_PARENT_LOV = COMP_UI_M_ATH_PARENT_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_ATH_NEW_AGENT_LOV() {
		return COMP_UI_M_ATH_NEW_AGENT_LOV;
	}

	public void setCOMP_UI_M_ATH_NEW_AGENT_LOV(
			HtmlCommandButton COMP_UI_M_ATH_NEW_AGENT_LOV) {
		this.COMP_UI_M_ATH_NEW_AGENT_LOV = COMP_UI_M_ATH_NEW_AGENT_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public PT_AGENT_TRAN_HDR getPT_AGENT_TRAN_HDR_BEAN() {
		return PT_AGENT_TRAN_HDR_BEAN;
	}

	public void setPT_AGENT_TRAN_HDR_BEAN(
			PT_AGENT_TRAN_HDR PT_AGENT_TRAN_HDR_BEAN) {
		this.PT_AGENT_TRAN_HDR_BEAN = PT_AGENT_TRAN_HDR_BEAN;
	}

	public List<SelectItem> getItemListName() {
		return itemListName;
	}

	public void setItemListName(List<SelectItem> itemListName) {
		this.itemListName = itemListName;
	}

	public String saveRecords() throws Exception {
		String rowId = null;
		CommonUtils commonUtils = new CommonUtils();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		rowId = localHeaderBean.getROWID();
		String successMessage = null;
		try {
			commonSaveRecord(localHeaderBean);
		
			commonUtils.doComitt();
			setProceedable(true);
			
			/*added by raja on 08-02-2017 for ssp id - ZBILQC-1719676 */
			/*if (rowId != null) {*/
				getWarningMap().put(
						"SAVE",
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
/*		} */
				
				/*end*/
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return null;
	}

	public void validateAthAgentCode(ActionEvent event) {
		UIInput inputValue = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(inputValue, getErrorMap());
	}

	public void validateParentCode(FacesContext context, UIComponent component,
			Object value) {

		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		String agentCode = (String) value;
		Connection con = null;
		// CODE MODIFIED AS VALIDATION SHOULD BE THROWN ONLY FOR PARENT CODE
		// OTHER THEN * -- VARUN[50663]

		try {
			if (!"*".equals(agentCode)) {
				localHeaderBean.setATH_PARENT_CODE(agentCode);
				con = CommonUtils.getConnection();
				helper.athParentCode_WhenValidateItem(localHeaderBean);
				getCOMP_UI_M_ATH_PARENT_NAME().resetValue();
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(con,
						FacesContext.getCurrentInstance(),
						PT044_A_APAC_CONSTANTS.PT_AGENT_TRAN_HDR,
						this.getWarningMap());
			} catch (ValidatorException vexc) {
				vexc.printStackTrace();
				getErrorMap().put("details",
						vexc.getFacesMessage().getSummary());
				getErrorMap().put("current",
						vexc.getFacesMessage().getSummary());
				throw new ValidatorException(
						new FacesMessage(vexc.getMessage()));
			}
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			getErrorMap().put("keyError", errorMessage);
			getErrorMap().put("current", errorMessage);
			throw new ValidatorException(new FacesMessage(errorMessage));
		}
	}

	public void validateAthNewAgentCode(FacesContext context,
			UIComponent component, Object value) {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		String agentCode = (String) value;
		try {
			localHeaderBean.setATH_NEW_AGENT_CODE(agentCode);
			helper.athNewAgentCode_WhenValidateItem(localHeaderBean);
			getCOMP_UI_M_ATH_NEW_AGENT_NAME().resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			getErrorMap().put("keyError", errorMessage);
			getErrorMap().put("current", errorMessage);
		}
	}

	public void validateAgentCode(FacesContext context, UIComponent component,
			Object value) throws Exception {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		String agentCode = (String) value;
		localHeaderBean.setATH_AGENT_CODE(agentCode);
		Connection con = null;
		String query1 = null;
		String query2 = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CRUDHandler handler = new CRUDHandler();
		int errorCode = -1;
		String dbRowId = null;
		String messageString = null;
		try {
			con = CommonUtils.getConnection();
			// on pressing * Lov was not displayed and procedure was throwing
			// error this providing check for the same --Varun[50663]
			if (!"*".equals(agentCode)) {

				if (!"Query".equalsIgnoreCase(CommonUtils
						.getGlobalVariable("PT044_A_Mode"))) {
					helper.athAgentCode_WhenValidateItem(this);

					/*
					 * [ BugId:PREMIAGDC-0066 Varun Dayal Mathur 25-Feb-09 THE
					 * DUPLICATE CHECK SHOULD HAPPEN FOR MENU PARAM OTHER THEN R
					 * NOT FOR ALL MENU PARAM'S
					 */
					// ** Duplication check--By Varun[50663] **//

					if ("R".equals(CommonUtils
							.getGlobalVariable("GLOBAL.M_PARAM_1"))) {

						query2 = "  SELECT ROWID  FROM PT_AGENT_TRAN_HDR   WHERE ATH_AGENT_CODE=?"
								+ "  AND ATH_TYPE='R'";

						resultSet2 = handler.executeSelectStatement(query2,
								con, new Object[] { PT_AGENT_TRAN_HDR_BEAN
										.getATH_AGENT_CODE() });

						if (resultSet2.next()) {
							dbRowId = resultSet2.getString(1);
						}

						if (CommonUtils.isDuplicate(
								PT_AGENT_TRAN_HDR_BEAN.getROWID(), dbRowId)) {
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath, "91327"));
						}

					} else {

						query1 = "SELECT ROWID FROM PM_CUSTOMER WHERE CUST_CODE=?"
								+ " AND CUST_STATUS='T'";
						resultSet1 = handler.executeSelectStatement(query1,
								con, new Object[] { PT_AGENT_TRAN_HDR_BEAN
										.getATH_AGENT_CODE() });

						if (resultSet1.next()) {
							dbRowId = resultSet1.getString(1);
						}

						if (CommonUtils.isDuplicate(
								PT_AGENT_TRAN_HDR_BEAN.getROWID(), dbRowId)) {
							messageString = Messages
									.getString("messageProperties_PT044_A",
											"PT044_A$PT_AGENT_TRAN_HDR$ERROR_MESSAGE$AGENT_TERMINATED");
							throw new ValidatorException(Messages.getMessage(
									PELConstants.pelErrorMessagePath, "3206",
									new Object[] { messageString }));
						}
					}

					// ** Duplication check End **//
					/*
					 * BugId:PREMIAGDC-0066 Varun Dayal Mathur 25-Feb-09 THE
					 * DUPLICATE CHECK SHOULD HAPPEN FOR MENU PARAM OTHER THEN R
					 * NOT FOR ALL MENU PARAM'S]
					 */

					getCOMP_UI_M_ATH_AGENT_NAME().resetValue();
					getCOMP_ATH_PARENT_CODE().resetValue();

					// getCOMP_ATH_TERMINATION_TYPE() will be null for agent
					// movement
					if (getCOMP_ATH_TERMINATION_TYPE() != null) {
						getCOMP_ATH_TERMINATION_TYPE().resetValue();
					}
					// added and uncommented by Varun[50663]as these values come
					// from the procedure call

					getCOMP_ATH_DATE().resetValue();
					// getCOMP_UI_M_ATH_TERMINATION_DESC() will be null for
					// agent movement
					if (getCOMP_UI_M_ATH_TERMINATION_DESC() != null) {
						getCOMP_UI_M_ATH_TERMINATION_DESC().resetValue();
					}
					getCOMP_UI_M_ATH_PARENT_NAME().resetValue();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			errorCode = e.getErrorCode();
			/*
			 * try{ ErrorHelpUtil.getErrorsAndWarningforProcedure(con,
			 * FacesContext
			 * .getCurrentInstance(),PT044_A_APAC_CONSTANTS.PT_AGENT_TRAN_HDR,
			 * this.getWarningMap()); }catch(ValidatorException vexc){
			 * vexc.printStackTrace(); getErrorMap().put("details",
			 * vexc.getFacesMessage().getSummary());
			 * getErrorMap().put("current",
			 * vexc.getFacesMessage().getSummary()); throw new
			 * ValidatorException(new FacesMessage(vexc.getMessage())); }
			 */
		} catch (ValidatorException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

			CommonUtils.closeCursor(resultSet1);
			CommonUtils.closeCursor(resultSet2);
			if (errorCode == 20100) {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(con,
						FacesContext.getCurrentInstance(),
						component.getClientId(context), this.getWarningMap());
			}
		}
	}

	public void validationAthTerminitationType(FacesContext context,
			UIComponent component, Object value) {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		String agentCode = (String) value;
		Connection con = null;
		int errorCode = -1;
		try {
			con = CommonUtils.getConnection();
			localHeaderBean.setATH_TERMINATION_TYPE(agentCode);
			helper.athTerminationType_WhenvalidateItem(localHeaderBean);
			getCOMP_UI_M_ATH_TERMINATION_DESC().resetValue();
		} catch (SQLException e) {
			e.printStackTrace();
			errorCode = e.getErrorCode();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (errorCode == 20100) {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(con,
						FacesContext.getCurrentInstance(),
						component.getClientId(context), this.getWarningMap());
			}
		}
	}

	public void validateCUSTDOB(ActionEvent event) {
		HtmlCalendar inputValue = (HtmlCalendar) event.getComponent()
				.getParent();
		ErrorHelpUtil.validate(inputValue, getErrorMap());
	}

	public void validatenNewAgentCodeRank(FacesContext context,
			UIComponent component, Object value) {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		String ATH_AGENT_NEW_RANK_CODE = (String) value;
		localHeaderBean.setATH_AGENT_NEW_RANK_CODE(ATH_AGENT_NEW_RANK_CODE);
		String menuParam = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		HashMap<String, String> outValueMap = null;
		try {
			if ("M".equals(menuParam)
					&& localHeaderBean.getATH_AGENT_NEW_RANK_CODE() != null) {
				outValueMap = helper
						.callATH_AGENT_NEW_RANK_CODE(localHeaderBean);
				if (outValueMap != null) {
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							outValueMap.get("WARNING"));
					getWarningMap().put("Agent Code Rank",
							outValueMap.get("WARNING"));
				}
				getCOMP_UI_M_AGENT_NEW_RANK_DESC().resetValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			String errorMessage = e.getMessage();
			getErrorMap().put("keyError", errorMessage);
			getErrorMap().put("current", errorMessage);
		}
	}

	public void validateAthDate(FacesContext context, UIComponent component,
			Object value) {
		
		System.out.println("************ Enter the validateAthDate Method ************");
		CommonUtils commonUtils = new CommonUtils();
		getPT_AGENT_TRAN_HDR_BEAN().setATH_DATE((Date) value);
		Date date = getPT_AGENT_TRAN_HDR_BEAN().getATH_DATE();
		
		
		Date date1 = null;
		try {
			date1 = commonUtils.getCurrentDate();
			if (date.compareTo(date1) > 0
					&& CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1") == "R") {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "91205");
				throw new ValidatorException(new FacesMessage(message));
			}
			System.out.println("************ Exit the validateAthDate Method ************");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Bug id:86,Rajesh Kundala Feb 27 2009,Added FireField Validation method

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	// Bug id:86,Rajesh Kundala Feb 27 2009,Added FireField Validation method
	// Ends

	// Bug id:86,Rajesh Kundala Feb 27 2009,Added throws exception and removed
	// try catch in the below mentioned for methods
	public void validateReviewDate(FacesContext context, UIComponent component,
			Object value) throws Exception {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		localHeaderBean.setATH_REVIEW1_DT((Date) value);
		helper.athReview1Dt_WhenvalidateItem(localHeaderBean);
	}

	public void validateReviewDate2(FacesContext context,
			UIComponent component, Object value) throws Exception {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		localHeaderBean.setATH_REVIEW2_DT((Date) value);
		helper.athReview2Dt_WhenvalidateItem(localHeaderBean);

	}

	public void validateReviewDate3(FacesContext context,
			UIComponent component, Object value) throws Exception {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		localHeaderBean.setATH_REVIEW3_DT((Date) value);
		helper.athReview3Dt_WhenvalidateItem(localHeaderBean);

	}

	public void validateReviewDate4(FacesContext context,
			UIComponent component, Object value) throws Exception {
		PT044_A_HELPER helper = new PT044_A_HELPER();
		PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
		localHeaderBean.setATH_REVIEW4_DT((Date) value);
		helper.athReview4Dt_WhenvalidateItem(localHeaderBean);

	}

	// Bug id:86,Rajesh Kundala Feb 27 2009,Added throws exception and removed
	// try catch in the below mentioned for methods ends
	public void resetValues() {
		COMP_UI_M_ATH_AGENT_NAME = new HtmlInputText();
		COMP_ATH_PARENT_CODE = new HtmlInputText();
		COMP_ATH_TERMINATION_TYPE = new HtmlInputText();
		COMP_UI_M_ATH_TERMINATION_DESC = new HtmlInputText();
		COMP_UI_M_ATH_PARENT_NAME = new HtmlInputText();
	}

	/* Added By Jagadeesh on 21.4.2016 */

	public void UPD_AGENT_DTLS(String current) throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		parameterList.add(param1);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENCY_MGMT.UPD_AGENT_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void INS_NEW_HIERARCHY(String current, String Param)
			throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				Param);
		parameterList.add(param1);
		parameterList.add(param2);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENCY_MGMT.INS_NEW_HIERARCHY");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void UPD_MOVED_AGENT_DTLS(String current) throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		parameterList.add(param1);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENT_MOVEMENT.UPD_MOVED_AGENT_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void INS_NEW_MOVT_HIERARCHY(String current, String Param)
			throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				Param);
		parameterList.add(param1);
		parameterList.add(param2);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENT_MOVEMENT.INS_NEW_MOVT_HIERARCHY");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void INS_POL_NEW_SELLING_AGENT(String current, String Param)
			throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				Param);
		parameterList.add(param1);
		parameterList.add(param2);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_TERMAGT_SERV_RIGHTS.INS_POL_NEW_SELLING_AGENT");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void UPD_TERM_AGENT_DTLS(String current, String Param)
			throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		SimpleDateFormat simp = new SimpleDateFormat("dd-MMM-yyyy");
		Date d = new Date();
		String date = simp.format(d);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "DATE", "IN", date);
		OracleParameter param3 = new OracleParameter("IN3", "STRING", "IN",
				Param);
		parameterList.add(param1);
		parameterList.add(param2);
		parameterList.add(param3);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENT_TERMINATION.UPD_TERM_AGENT_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void DEL_AGENT_COMM_REC(String current) throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		parameterList.add(param1);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENT_TERMINATION.DEL_AGENT_COMM_REC");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public String approvePolicy() throws Exception {
		System.out.println("Enter into approvePolicy    method");
		String menuParam = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String menuParam2 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2");
		String Query1 = "SELECT SUBSTR(PS_CODE_DESC, 1,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) - 1)),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) - 1 -INSTR(PS_CODE_DESC,',',1,1))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) - 1 -INSTR(PS_CODE_DESC,',',1,2))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) - 1 -INSTR(PS_CODE_DESC,',',1,3))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) - 1 -INSTR(PS_CODE_DESC,',',1,4))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) - 1 -INSTR(PS_CODE_DESC,',',1,5))),SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 7), 0, 999,INSTR(PS_CODE_DESC,',',1,7) - 1 -INSTR(PS_CODE_DESC,',',1,6))) FROM PP_SYSTEM WHERE PS_TYPE = 'INC_CONT_BNF'";
		/*
		 * +
		 * "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 1), 0, 999,INSTR(PS_CODE_DESC,',',1,1) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) - 1 -INSTR(PS_CODE_DESC,',',1,1))),"
		 * +
		 * "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 2), 0, 999,INSTR(PS_CODE_DESC,',',1,2) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) - 1 -INSTR(PS_CODE_DESC,',',1,2))),"
		 * +
		 * "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 3), 0, 999,INSTR(PS_CODE_DESC,',',1,3) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) - 1 -INSTR(PS_CODE_DESC,',',1,3))),"
		 * +
		 * "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 4), 0, 999,INSTR(PS_CODE_DESC,',',1,4) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) - 1 -INSTR(PS_CODE_DESC,',',1,4))),"
		 * +
		 * "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 5), 0, 999,INSTR(PS_CODE_DESC,',',1,5) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) - 1 -INSTR(PS_CODE_DESC,',',1,5))),"
		 * +
		 * "SUBSTR(PS_CODE_DESC,DECODE(INSTR(PS_CODE_DESC, ',', 1, 6), 0, 999,INSTR(PS_CODE_DESC,',',1,6) + 1),DECODE(INSTR(PS_CODE_DESC, ',', 1, 7), 0, 999,INSTR(PS_CODE_DESC,',',1,7) - 1 -INSTR(PS_CODE_DESC,',',1,6)))"
		 * +"FROM PP_SYSTEM" +"WHERE PS_TYPE = 'INC_CONT_BNF'";
		 */
		String Query2 = "SELECT 'X' FROM PM_AGENT_APPL_BENEFIT WHERE AAB_CUST_CODE = ? AND AAB_BNF_CODE IN (?,?,?,?,?,?,?)";

		String Query3 = "SELECT PC_VALUE FROM PM_CODES WHERE PC_TYPE = 'AGTERMIN_TYP' AND PC_CODE = ? ";
		Connection con = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		ResultSet rst3 = null;
		con = CommonUtils.getConnection();
		/* CRUDHandler handler = null; */
		if (menuParam.equals("T")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			/*
			 * Commented by Ramkumar on 23-4-2016 for TISB POC
			 * 
			 * UPD_TERM_AGENT_DTLS(sys, menuParam2);*/
			
			UPD_TERM_AGENT_DTLS(sys, menuParam);
			rst1 = new CRUDHandler().executeSelectStatement(Query1, con);
			while (rst1.next()) {
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_CONT_BNF1(CommonUtils.nvl(
						rst1.getString(1), "***"));
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_CONT_BNF2(CommonUtils.nvl(
						rst1.getString(2), "***"));
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_CONT_BNF3(CommonUtils.nvl(
						rst1.getString(3), "***"));
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_CONT_BNF4(CommonUtils.nvl(
						rst1.getString(4), "***"));
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_CONT_BNF5(CommonUtils.nvl(
						rst1.getString(5), "***"));
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_CONT_BNF6(CommonUtils.nvl(
						rst1.getString(6), "***"));
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_CONT_BNF7(CommonUtils.nvl(
						rst1.getString(7), "***"));
			}
			rst2 = new CRUDHandler().executeSelectStatement(Query2, con,
					new Object[] { PT_AGENT_TRAN_HDR_BEAN.getATH_AGENT_CODE(),
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_CONT_BNF1(),
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_CONT_BNF2(),
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_CONT_BNF3(),
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_CONT_BNF4(),
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_CONT_BNF5(),
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_CONT_BNF6(),
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_CONT_BNF7() });
			while (rst2.next()) {
				PT_AGENT_TRAN_HDR_BEAN.setAM_INC_BNF_EXISTS(rst2.getString(1));
			}
			rst3 = new CRUDHandler().executeSelectStatement(Query3, con,
					new Object[] { PT_AGENT_TRAN_HDR_BEAN
							.getATH_TERMINATION_TYPE() });
			while (rst3.next()) {
				PT_AGENT_TRAN_HDR_BEAN.setPC_VALUE(rst3.getDouble("PC_VALUE"));
			}
			if (CommonUtils.nvl(PT_AGENT_TRAN_HDR_BEAN.getAM_INC_BNF_EXISTS(),
					"Y").equals("Y")
					|| CommonUtils.nvl(
							PT_AGENT_TRAN_HDR_BEAN.getAM_INC_BNF_EXISTS(), "N")
							.equals("N")
					&& CommonUtils.nvl(PT_AGENT_TRAN_HDR_BEAN.getPC_VALUE(), 0) == 0) {
				DEL_AGENT_COMM_REC(sys);
			}

		} else if (menuParam.equals("A")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			UPD_AGENT_DTLS(sys);
			INS_NEW_HIERARCHY(sys, menuParam);
			
			
		} else if (menuParam.equals("M")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			UPD_MOVED_AGENT_DTLS(sys);
			INS_NEW_MOVT_HIERARCHY(sys, menuParam);
		} else if (menuParam.equals("R")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			INS_POL_NEW_SELLING_AGENT(sys, menuParam);
		}
		
		System.out.println("getROWID         "+PT_AGENT_TRAN_HDR_BEAN.getROWID());
		PT_AGENT_TRAN_HDR_BEAN.setATH_APPRV_FLAG("A");
		new CRUDHandler().executeUpdate(PT_AGENT_TRAN_HDR_BEAN, con);
		con.commit();
		
		PT_AGENT_TRAN_HDR_ACTION headerAction = compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN();
		PT_AGENT_TRAN_HDR headerBean = headerAction.getPT_AGENT_TRAN_HDR_BEAN();
		headerAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
		compositeAction.setDisableOnApprovalFlag(true);
		headerBean.setUI_M_APPRV_STATUS("Approved");
		
		
		flagApproved=true;
		/*getWarningMap().put(
				"SAVE",
				Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));
		getWarningMap().put(
				PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));*/
		
		getWarningMap().put(
				"SAVE",
				"Process Approved Successfully");
		getWarningMap().put(
				PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Process Approved Successfully");

		return "";
	}

	/*added by raja on 16-06-2017 for */
	boolean flagProcess=false;
	boolean flagApproved=false;
	
	/*end*/
	
	public String processPolicy() throws Exception {
		try
		{
			System.out.println("Enter into Process Policy Operation");
		String menuParam = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1");
		String menuParam2 = CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_2");

		System.out.println("menuParam      :  "+menuParam);
		System.out.println("menuParam2     :  "+menuParam2);
		System.out.println("");
		
		if (menuParam.equals("T")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			INS_TERM_AGENT_DTLS(sys);
			INS_TERM_AGENT_POL_DTLS(sys, menuParam2);
		} else if (menuParam.equals("A")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			INS_DOWNLINE_HIERARCHY(sys);
			INS_AGENT_POL_DTLS(sys, menuParam);
		} else if (menuParam.equals("M")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			INS_MOVED_AGENT_HIERARCHY(sys);
			INS_AGENT_POL_DTLS(sys, menuParam2);
		} else if (menuParam.equals("R")) {
			String sys = Long.toString(PT_AGENT_TRAN_HDR_BEAN.getATH_SYS_ID());
			INS_TERM_AGENT_POL_DTLS1(sys, menuParam2);
		}
		
		
		flagProcess=true;
		getWarningMap().put(
				"SAVE",
				"Process Completed Successfully.");
		getWarningMap().put(
				PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				"Process Completed Successfully");
		/*getWarningMap().put(
				PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
				Messages.getString(PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$save"));*/
		
		
		}
		catch(Exception e)
		{
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		return "";
	}

	public void INS_TERM_AGENT_DTLS(String current) throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("***** ENTER THE INS_TERM_AGENT_DTLS *****");
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		try
		{
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		parameterList.add(param1);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENT_TERMINATION.INS_TERM_AGENT_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::      " + oracleParameter.getValue());
		}
		}
		catch(Exception e)
		{
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void INS_MOVED_AGENT_HIERARCHY(String current) throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		parameterList.add(param1);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENT_MOVEMENT.INS_MOVED_AGENT_HIERARCHY");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void INS_TERM_AGENT_POL_DTLS(String current, String Param)
			throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("***** ENTER THE INS_TERM_AGENT_POL_DTLS *****");
		System.out.println("current       :  "+current);
		System.out.println("Param         :  "+Param);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				Param);
		parameterList.add(param1);
		parameterList.add(param2);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENT_TERMINATION.INS_TERM_AGENT_POL_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) 
		{
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::     : " + oracleParameter.getValue());
		}
	}

	public void INS_TERM_AGENT_POL_DTLS1(String current, String Param)
			throws Exception {
		try
		{
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				Param);
		parameterList.add(param1);
		parameterList.add(param2);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_TERMAGT_SERV_RIGHTS.INS_TERM_AGENT_POL_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
		}
		catch(Exception e)
		{
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void INS_DOWNLINE_HIERARCHY(String current) throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN", "A");
		parameterList.add(param1);
		parameterList.add(param2);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENCY_MGMT.INS_DOWNLINE_HIERARCHY");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	public void INS_AGENT_POL_DTLS(String current, String Param)
			throws Exception {
		Connection con = CommonUtils.getConnection();
		System.out.println("CURRENT" + current);
		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		/*
		 * OracleParameter param1 = new OracleParameter("IN1", "STRING",
		 * "IN",current);
		 */
		OracleParameter param1 = new OracleParameter("IN1", "INT", "IN",
				current);
		OracleParameter param2 = new OracleParameter("IN2", "STRING", "IN",
				Param);
		parameterList.add(param1);
		parameterList.add(param2);
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, con,
				"P9ILPK_AGENCY_MGMT.INS_AGENT_POL_DTLS");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
		}
	}

	/* End */

	public List<PT_AGENT_TRAN_HDR> getAgentCodeLov(Object string) {
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		lovHeaderList = (List) delegate.getAgentCodeLov(string);
		return lovHeaderList;
	}

	public void renderAgentCode(ActionEvent event) {
		Iterator<PT_AGENT_TRAN_HDR> iterator = null;
		PT_AGENT_TRAN_HDR bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;

		classCode = (String) COMP_ATH_AGENT_CODE.getSubmittedValue();
		if (classCode != null && !classCode.trim().isEmpty()) {
			if (lovHeaderList != null) {
				iterator = lovHeaderList.iterator();
				while (iterator.hasNext() && keepLooking) {
					bean = iterator.next();
					if (bean.getATH_AGENT_CODE().equalsIgnoreCase(classCode)) {
						codeDesc = bean.getUI_M_ATH_AGENT_NAME();
						getPT_AGENT_TRAN_HDR_BEAN()
								.setATH_AGENT_CODE(classCode);
						getPT_AGENT_TRAN_HDR_BEAN().setUI_M_ATH_AGENT_NAME(
								codeDesc);
						getCOMP_ATH_AGENT_CODE().resetValue();
						getCOMP_UI_M_ATH_AGENT_NAME().resetValue();
						keepLooking = false;
					}
				}
			}
		}
	}

	public List<PT_AGENT_TRAN_HDR> getParentCodeLov(Object string) {
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		lovHeaderList = (List) delegate.getParentCodeLov(string);
		return lovHeaderList;
	}

	public void renderParentCode(ActionEvent event) {
		Iterator<PT_AGENT_TRAN_HDR> iterator = null;
		PT_AGENT_TRAN_HDR bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;

		classCode = (String) COMP_ATH_PARENT_CODE.getSubmittedValue();
		if (classCode != null && !classCode.trim().isEmpty()) {
			if (lovHeaderList != null) {
				iterator = lovHeaderList.iterator();
				while (iterator.hasNext() && keepLooking) {
					bean = iterator.next();
					if (bean.getATH_PARENT_CODE().equalsIgnoreCase(classCode)) {
						codeDesc = bean.getUI_M_ATH_PARENT_NAME();
						getPT_AGENT_TRAN_HDR_BEAN().setATH_PARENT_CODE(
								classCode);
						getPT_AGENT_TRAN_HDR_BEAN().setUI_M_ATH_PARENT_NAME(
								codeDesc);
						// getCOMP_ATH_PARENT_CODE().resetValue();
						getCOMP_UI_M_ATH_PARENT_NAME().resetValue();
						keepLooking = false;
					}
				}
			}
		}
	}

	public List<PT_AGENT_TRAN_HDR> getTeriminationLov(Object string) {
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		lovHeaderList = (List) delegate.getTeriminationLov(string);
		return lovHeaderList;
	}

	public void renderTeriminationCode(ActionEvent event) {
		Iterator<PT_AGENT_TRAN_HDR> iterator = null;
		PT_AGENT_TRAN_HDR bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;

		classCode = (String) COMP_ATH_TERMINATION_TYPE.getSubmittedValue();
		if (classCode != null && !classCode.trim().isEmpty()) {
			if (lovHeaderList != null) {
				iterator = lovHeaderList.iterator();
				while (iterator.hasNext() && keepLooking) {
					bean = iterator.next();
					if (bean.getATH_TERMINATION_TYPE().equalsIgnoreCase(
							classCode)) {
						codeDesc = bean.getUI_M_ATH_TERMINATION_DESC();
						getPT_AGENT_TRAN_HDR_BEAN().setATH_TERMINATION_TYPE(
								classCode);
						getPT_AGENT_TRAN_HDR_BEAN()
								.setUI_M_ATH_TERMINATION_DESC(codeDesc);
						// getCOMP_ATH_TERMINATION_TYPE().resetValue();
						getCOMP_UI_M_ATH_TERMINATION_DESC().resetValue();
						keepLooking = false;
					}
				}
			}
		}
	}

	public List<PT_AGENT_TRAN_HDR> getRankCodeLov(Object string) {
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		lovHeaderList = (List) delegate.getRankCodeLov(string);
		return lovHeaderList;
	}

	public void renderRankCode(ActionEvent event) {
		Iterator<PT_AGENT_TRAN_HDR> iterator = null;
		PT_AGENT_TRAN_HDR bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;

		classCode = (String) COMP_ATH_AGENT_NEW_RANK_CODE.getSubmittedValue();
		if (classCode != null && !classCode.trim().isEmpty()) {
			if (lovHeaderList != null) {
				iterator = lovHeaderList.iterator();
				while (iterator.hasNext() && keepLooking) {
					bean = iterator.next();
					if (bean.getATH_AGENT_NEW_RANK_CODE().equalsIgnoreCase(
							classCode)) {
						codeDesc = bean.getUI_M_AGENT_NEW_RANK_DESC();
						getPT_AGENT_TRAN_HDR_BEAN().setATH_AGENT_NEW_RANK_CODE(
								classCode);
						getPT_AGENT_TRAN_HDR_BEAN()
								.setUI_M_AGENT_NEW_RANK_DESC(codeDesc);
						// getCOMP_ATH_AGENT_NEW_RANK_CODE().resetValue();
						getCOMP_UI_M_AGENT_NEW_RANK_DESC().resetValue();
						keepLooking = false;
					}
				}
			}
		}
	}

	public List<PT_AGENT_TRAN_HDR> getNewAgentCodeLov(Object string) {
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		lovHeaderList = (List) delegate.getNewAgentCodeLov(string);
		return lovHeaderList;
	}

	public void renderNewAgentCode(ActionEvent event) {
		Iterator<PT_AGENT_TRAN_HDR> iterator = null;
		PT_AGENT_TRAN_HDR bean = null;
		boolean keepLooking = true;
		String classCode = null;
		String codeDesc = null;

		classCode = (String) COMP_ATH_NEW_AGENT_CODE.getSubmittedValue();
		if (classCode != null && !classCode.trim().isEmpty()) {
			if (lovHeaderList != null) {
				iterator = lovHeaderList.iterator();
				while (iterator.hasNext() && keepLooking) {
					bean = iterator.next();
					if (bean.getATH_NEW_AGENT_CODE()
							.equalsIgnoreCase(classCode)) {
						codeDesc = bean.getUI_M_ATH_NEW_AGENT_NAME();
						getPT_AGENT_TRAN_HDR_BEAN().setATH_NEW_AGENT_CODE(
								classCode);
						getPT_AGENT_TRAN_HDR_BEAN().setUI_M_ATH_NEW_AGENT_NAME(
								codeDesc);
						// getCOMP_ATH_NEW_AGENT_CODE().resetValue();
						getCOMP_UI_M_ATH_NEW_AGENT_NAME().resetValue();
						keepLooking = false;
					}
				}
			}
		}
	}

	public void commonSaveRecord(PT_AGENT_TRAN_HDR localHeaderBean) {
		String rowId = null;
		PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
		rowId = localHeaderBean.getROWID();
		try {
			// Code modified as Checklist was duplicated and new record created
			// after we click o n Process button
			if (rowId == null) {
				delegate.pt_agent_tran_hdr_pre_insert(localHeaderBean);
				delegate.insertAgentHeader(localHeaderBean);
				delegate.pt_agent_tran_hdr_post_insert(localHeaderBean);
			} else {
				
				System.out.println("ELSE BLOCK commonSaveRecord  : ");
				delegate.pt_agent_tran_hdr_pre_update(localHeaderBean);
				delegate.insertAgentHeader(localHeaderBean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				delegate.pt_agent_tran_hdr_when_new_block_instance(PT_AGENT_TRAN_HDR_BEAN);

				/* added by raja on 30.3.2016 to hide and show wizard */

				System.out
						.println("CommonUtils.getGlobalObject(GLOBAL.M_PARAM_1)         "
								+ CommonUtils
										.getGlobalObject("GLOBAL.M_PARAM_1"));
				if (CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1") != null) {
					if (CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1").equals(
							"R")) {
						compositeAction.getWizard().disableWizardItem(
								"agentDetail");
					} else {
						compositeAction.getWizard().enableWizardItem(
								"agentDetail");
					}

					// added by raja

					if (CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1").equals(
							"A")) {
						getCOMP_ATH_PARENT_CODE_LABEL().setValue(
								"New Reporting Parent Code");
					}
					if (CommonUtils.getGlobalObject("GLOBAL.M_PARAM_1").equals(
							"M")) {
						getCOMP_ATH_PARENT_CODE_LABEL().setValue(
								"Agents Old Parent Code");
					}

				}

				/* end */

				if (PT_AGENT_TRAN_HDR_BEAN.getROWID() != null) {
					delegate.pt_agent_tran_hdr_pre_query(PT_AGENT_TRAN_HDR_BEAN);
					helper.executeQuery(compositeAction);
					delegate.pt_agent_tran_hdr_post_query(PT_AGENT_TRAN_HDR_BEAN);
				} else {
					delegate.pt_agent_tran_hdr_when_create_record(PT_AGENT_TRAN_HDR_BEAN);
				}
				delegate.pt_agent_tran_hdr_when_new_record_instance(compositeAction);
				setBlockFlag(false);
			}
			
			
			/*added by raja on 16-06-2017*/
			/*if(flagApproved==true && flagProcess==false)
			{
				compositeAction.getWizard().disableWizardItem("agentDetail");
				compositeAction.getWizard().disableWizardItem("policyDetails");
			}*/
			
			/*end*/
			
			/* Newly added By Dhinesh on 17-06-2017 */ 
			if(!"A".equalsIgnoreCase(compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN().getATH_APPRV_FLAG()))
			{
				compositeAction.getWizard().disableWizardItem("agentDetail");
				compositeAction.getWizard().disableWizardItem("policyDetails");
			}else
			{
				compositeAction.getWizard().enableWizardItem("agentDetail");
				compositeAction.getWizard().enableWizardItem("policyDetails");
			}	
			
			/*end*/
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputText getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputText comp_ui_m_apprv_status) {
		COMP_UI_M_APPRV_STATUS = comp_ui_m_apprv_status;
	}

	public String preBack() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;
	}

	public boolean isProceedable() {
		return proceedable;
	}

	public void setProceedable(boolean proceedable) {
		this.proceedable = proceedable;
	}
	
	/*added by raja on 08-02-2017 for ssp id - ZBILQC-1719676 */
	private HtmlOutputLabel COMP_ATH_AGENT_NEW_CLASS_CODE_LABEL;

	private HtmlInputText COMP_ATH_AGENT_NEW_CLASS_CODE;
	
	private HtmlInputText COMP_ATH_AGENT_NEW_CLASS_CODE_DESC;

	
	
	 public HtmlOutputLabel getCOMP_ATH_AGENT_NEW_CLASS_CODE_LABEL() {
		return COMP_ATH_AGENT_NEW_CLASS_CODE_LABEL;
	}

	public void setCOMP_ATH_AGENT_NEW_CLASS_CODE_LABEL(
			HtmlOutputLabel cOMP_ATH_AGENT_NEW_CLASS_CODE_LABEL) {
		COMP_ATH_AGENT_NEW_CLASS_CODE_LABEL = cOMP_ATH_AGENT_NEW_CLASS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ATH_AGENT_NEW_CLASS_CODE() {
		return COMP_ATH_AGENT_NEW_CLASS_CODE;
	}

	public void setCOMP_ATH_AGENT_NEW_CLASS_CODE(
			HtmlInputText cOMP_ATH_AGENT_NEW_CLASS_CODE) {
		COMP_ATH_AGENT_NEW_CLASS_CODE = cOMP_ATH_AGENT_NEW_CLASS_CODE;
	}

	public HtmlInputText getCOMP_ATH_AGENT_NEW_CLASS_CODE_DESC() {
		return COMP_ATH_AGENT_NEW_CLASS_CODE_DESC;
	}

	public void setCOMP_ATH_AGENT_NEW_CLASS_CODE_DESC(
			HtmlInputText cOMP_ATH_AGENT_NEW_CLASS_CODE_DESC) {
		COMP_ATH_AGENT_NEW_CLASS_CODE_DESC = cOMP_ATH_AGENT_NEW_CLASS_CODE_DESC;
	}

	public ArrayList<LovBean> getClassCodeLov(Object object) {
	    	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			
	    	
	    	String query = "SELECT CCLAS_CODE,CCLAS_CLASS_DESC  FROM    PM_CUST_CLASS WHERE  CCLAS_FRZ_FLAG = 'N' AND CCLAS_TYPE IN ('002','009') AND ( UPPER(CCLAS_CODE) LIKE UPPER(?)  " +
	    								"OR  UPPER(CCLAS_CLASS_DESC) LIKE UPPER(?)   ) AND ROWNUM < ? ORDER BY 1";

			Object[] values = null;
			String currentValue = (String) object;

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

				values = new Object[] { currentValue, currentValue,
						PELConstants.suggetionRecordSize };
				lovList = ListItemUtil.prepareSuggestionList(query, values);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			return lovList;
	    }
	 
	 
	 public void validatenNewAgentClassCode(FacesContext context,
				UIComponent component, Object value) {
		 PT_AGENT_TRAN_HDR localHeaderBean = getPT_AGENT_TRAN_HDR_BEAN();
			
			try {
				localHeaderBean.setATH_AGENT_NEW_CLASS_CODE(value.toString());				
			} catch (Exception e) {
				e.printStackTrace();
				String errorMessage = e.getMessage();
				getErrorMap().put("keyError", errorMessage);
				getErrorMap().put("current", errorMessage);
			}
		}
	 
	 public void validateAgentClassCode(ActionEvent event) {
			UIInput inputValue = (UIInput) event.getComponent().getParent();
			ErrorHelpUtil.validate(inputValue, getErrorMap());
		}
	/*end*/
}

/*
 * public String approvePolicy(){
 * 
 * String returnString = null; PT044_A_HELPER helper = new PT044_A_HELPER();
 * PT_AGENT_TRAN_HDR headerBean = getPT_AGENT_TRAN_HDR_BEAN(); String rowId =
 * null; Connection con = null; try { rowId = headerBean.getROWID();
 * 
 * if (rowId != null) { con = CommonUtils.getConnection();
 * helper.callingApprove(headerBean); //added by Varun[50663]
 * if("A".equals(headerBean.getATH_APPRV_FLAG())){ commonSaveRecord(headerBean);
 * new CommonUtils().doComitt(); }
 * CommonUtils.setGlobalVariable("GLOBAL.M_ATH_SYS_ID",
 * headerBean.getATH_SYS_ID()+""); returnString="gotoMainPage";
 * compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN
 * ().setPT_AGENT_TRAN_HDR_BEAN(headerBean); // Commented by Amit Gupta - 36077
 * //Newly Added if("A".equalsIgnoreCase(headerBean.getATH_APPRV_FLAG())) { //
 * getErrorMap().put("current", "Record Approved");
 * getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
 * getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
 * getCOMP_UI_M_APPRV_STATUS().setValue("Approved"); // Added by Amit Gupta -
 * 36077 getErrorMap().clear(); getWarningMap().clear();
 * getWarningMap().put("current",
 * Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages",
 * "91071").getSummary()); }
 * 
 * //added by Varun to disable all the fields in header and details
 * Block---varun[50663] if("A".equals(headerBean.getATH_APPRV_FLAG())){
 * compositeAction.setDisableOnApprovalFlag(true); }else{
 * compositeAction.setDisableOnApprovalFlag(false); } }else{ String errorMessage
 * = "Before Approve please Process"; getErrorMap().put("details",
 * errorMessage); getErrorMap().put("current", errorMessage); } }catch
 * (SQLException e) { e.printStackTrace(); try{
 * ErrorHelpUtil.getErrorsAndWarningforProcedure(con,
 * FacesContext.getCurrentInstance(),PT044_A_APAC_CONSTANTS.PT_AGENT_TRAN_HDR,
 * this.getWarningMap()); returnString = null; }catch(ValidatorException vexc){
 * vexc.printStackTrace(); getErrorMap().put("details",
 * vexc.getFacesMessage().getSummary()); getErrorMap().put("current",
 * vexc.getFacesMessage().getSummary()); } } catch (Exception e) {
 * e.printStackTrace(); getErrorMap().put("details", e.getMessage());
 * getErrorMap().put("current", e.getMessage()); } // Commented by Amit Gupta -
 * 36077 // getWarningMap().put("current",
 * Messages.getString("messageProperties_PT044_A",
 * "PT044_A$PT_AGENT_TRAN_HDR$APPROVED_SUCCESS_MESSAGE"));
 * System.out.println("size************"+getErrorMap()); return ""; } public
 * String processPolicy(){
 * 
 * String returnString = null; PT044_A_HELPER helper = new PT044_A_HELPER();
 * PT044_A_DELEGATE delegate = new PT044_A_DELEGATE();
 * ArrayList<PT_AGENT_TRAN_DTLS> listValue = null; ArrayList<PT_AGENT_POL_DTLS>
 * polListVal = null; ArrayList<PT_AGENT_CHKLST_STATUS> checkListVal = null;
 * PT_AGENT_TRAN_HDR headerBean = getPT_AGENT_TRAN_HDR_BEAN(); String agentCode
 * = null; // String parenyCode = null; String terminationCode = null;
 * Connection con = null; CommonUtils commonUtils = new CommonUtils(); int
 * globalSysId=-1; boolean goAhead=false;
 * 
 * if(isProceedable()) { String
 * menuParam=CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"); try { agentCode
 * = headerBean.getATH_AGENT_CODE(); // Commented and added by Amit Gupta //
 * parenyCode = headerBean.getATH_PARENT_CODE(); terminationCode =
 * headerBean.getATH_TERMINATION_TYPE(); // FLOW WILL WORK DIFFERENTLY FOR
 * DIFFERENT MENU PARAMS -VARUN[50663]
 * if("M".equals(menuParam)||"A".equals(menuParam) || "U".equals(menuParam)){
 * if(agentCode!=null && !agentCode.trim().isEmpty() ){ goAhead=true; } }else{
 * if (agentCode != null && !agentCode.trim().isEmpty() && terminationCode !=
 * null && !terminationCode.trim().isEmpty()) { goAhead = true; } }
 * 
 * if (goAhead) {
 * 
 * con = CommonUtils.getConnection(); commonSaveRecord(headerBean); String rowId
 * = headerBean.getROWID();
 * 
 * helper.callingProcess(headerBean);//Procedures Calling for inserting the data
 * for details block
 * 
 * listValue = delegate.loadAgentDetailRecord(rowId); if (listValue == null) {
 * listValue = new ArrayList<PT_AGENT_TRAN_DTLS>(); } polListVal =
 * delegate.loadPolicyDetail(rowId); if (polListVal == null) { polListVal = new
 * ArrayList<PT_AGENT_POL_DTLS>(); } //setting APD_ATH_SYS_ID--Varun [50663]
 * if(polListVal!=null){ Iterator<PT_AGENT_POL_DTLS> itr=polListVal.iterator();
 * while(itr.hasNext()){ PT_AGENT_POL_DTLS poldtlsValueBean=itr.next();
 * globalSysId
 * =Integer.parseInt(CommonUtils.getGlobalVariable("GLOBAL.M_ATH_SYS_ID"));
 * poldtlsValueBean.setAPD_ATH_SYS_ID(globalSysId); } } checkListVal =
 * delegate.loadCheckListDetail(rowId); if(checkListVal== null){ checkListVal =
 * new ArrayList<PT_AGENT_CHKLST_STATUS>(); }
 * compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN
 * ().setPT_AGENT_TRAN_HDR_BEAN(headerBean);
 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setList(listValue);
 * 
 * PT_AGENT_TRAN_DTLS PT_AGENT_TRAN_DTLS_BEAN =null;
 * Iterator<PT_AGENT_TRAN_DTLS> listIterator= listValue.iterator();
 * while(listIterator.hasNext()){ PT_AGENT_TRAN_DTLS_BEAN = listIterator.next();
 * PT_AGENT_TRAN_DTLS_BEAN.setRowSelected(false); } if(listValue.size()>0){
 * 
 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().setPT_AGENT_TRAN_DTLS_BEAN
 * (listValue.get(0));
 * compositeAction.getPT_AGENT_TRAN_DTLS_ACTION_BEAN().getPT_AGENT_TRAN_DTLS_BEAN
 * ().setRowSelected(true); }
 * 
 * compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN().setList(polListVal);
 * 
 * PT_AGENT_POL_DTLS PT_AGENT_POL_DTLS_BEAN =null; Iterator<PT_AGENT_POL_DTLS>
 * listIteratorpol= polListVal.iterator(); while(listIteratorpol.hasNext()){
 * PT_AGENT_POL_DTLS_BEAN = listIteratorpol.next();
 * PT_AGENT_POL_DTLS_BEAN.setRowSelected(false); } if(polListVal.size()>0){
 * compositeAction.setRenderPolDtlsFlag(true);
 * compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN
 * ().setPT_AGENT_POL_DTLS_BEAN(polListVal.get(0));
 * compositeAction.getPT_AGENT_POL_DTLS_ACTION_BEAN
 * ().getPT_AGENT_POL_DTLS_BEAN().setRowSelected(true); } else{
 * compositeAction.setRenderPolDtlsFlag(false); }
 * 
 * compositeAction.getPT_AGENT_CHKLST_STATUS_ACTION_BEAN().setList(checkListVal);
 * 
 * PT_AGENT_CHKLST_STATUS PT_AGENT_CHKLST_STATUS_BEAN =null;
 * Iterator<PT_AGENT_CHKLST_STATUS> listIteratorchk= checkListVal.iterator();
 * while(listIteratorchk.hasNext()){ PT_AGENT_CHKLST_STATUS_BEAN =
 * listIteratorchk.next(); PT_AGENT_CHKLST_STATUS_BEAN.setRowSelected(false); }
 * if(checkListVal.size()>0){ compositeAction.setRenderChkListFlag(true);
 * compositeAction
 * .getPT_AGENT_CHKLST_STATUS_ACTION_BEAN().setPT_AGENT_CHKLST_STATUS_BEAN
 * (checkListVal.get(0));
 * compositeAction.getPT_AGENT_CHKLST_STATUS_ACTION_BEAN()
 * .getPT_AGENT_CHKLST_STATUS_BEAN().setRowSelected(true); } else{
 * compositeAction.setRenderChkListFlag(false); } //Newly Added
 * if(checkListVal.size()>0) { for(int index = 0; index<checkListVal.size();
 * index++) { PT_AGENT_CHKLST_STATUS pt_agent_chklst_status =
 * (PT_AGENT_CHKLST_STATUS) checkListVal.get(index);
 * if("Y".equalsIgnoreCase(pt_agent_chklst_status.getACS_MANDATORY_YN()) &&
 * "Y".equalsIgnoreCase(pt_agent_chklst_status.getACS_APPR_STS())) {
 * compositeAction
 * .getPT_AGENT_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().
 * setDisabled(false); }else
 * if("N".equalsIgnoreCase(pt_agent_chklst_status.getACS_MANDATORY_YN())) {
 * compositeAction
 * .getPT_AGENT_TRAN_HDR_ACTION_BEAN().getCOMP_UI_M_BUT_APPROVE().
 * setDisabled(false); }else{
 * compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().
 * getCOMP_UI_M_BUT_APPROVE().setDisabled(true); } } }
 * //CommonUtils.setGlobalObject("PT044_A_COMPOSITE_ACTION", compositeAction);
 * CommonUtils.setGlobalVariable("GLOBAL.M_ATH_SYS_ID",
 * headerBean.getATH_SYS_ID()+""); commonUtils.doComitt(); // Added by Amit
 * Gupta //getCOMP_UI_M_BUT_PROCESS().setDisabled(true); commented by
 * Varun[50663] as process button shud be disabled once approval is done as
 * discussed with Veeraghavan Sir //to highlight Policy Details tab in tabbed
 * bar area for menu param U
 * if("U".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))){
 * //compositeAction
 * .getTabbedBar().setTabClicked(PT044_A_COMPOSITE_ACTION.TAB_AGENT_POLICY_DETAIL
 * ); returnString = "gotoPolicyPage"; }else
 * if("T".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1")) ||
 * "M".equals(CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"))){
 * //compositeAction
 * .getTabbedBar().setTabClicked(PT044_A_COMPOSITE_ACTION.TAB_AGENT_TRAN_DETAIL
 * ); returnString="gotoDetailPage"; }else{ returnString=""; }
 * 
 * //IF PROCESS IS COMPLETED SUCCESSFULLY SHOW SUCCESS MESSAGE
 * //PREMIAGDC-326694 21-08-2009 VIJAY ANAND
 * delegate.pt_agent_tran_hdr_when_new_record_instance(compositeAction);
 * //PREMIAGDC-326694 21-08-2009 VIJAY ANAND
 * 
 * getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
 * Messages.getString(PELConstants.pelErrorMessagePath, "3083")); }else{ String
 * errorMessage = "Agent Code / Termination code should not be empty";
 * getErrorMap().put("details", errorMessage); getErrorMap().put("current",
 * errorMessage); } }catch (SQLException e) { e.printStackTrace(); try{
 * ErrorHelpUtil.getErrorsAndWarningforProcedure(con,
 * FacesContext.getCurrentInstance(),PT044_A_APAC_CONSTANTS.PT_AGENT_TRAN_HDR,
 * this.getWarningMap()); returnString = null; }catch(ValidatorException vexc){
 * vexc.printStackTrace(); getErrorMap().put("details", vexc.getMessage());
 * getErrorMap().put("current", vexc.getMessage());
 * 
 * } } catch (Exception e) { e.printStackTrace(); getErrorMap().put("details",
 * e.getMessage()); getErrorMap().put("current", e.getMessage()); }
 * setProceedable(false); } else { getWarningMap().put("current",
 * "Please save the record before Process"); getWarningMap().put("detail",
 * "Please save the record before Process"); } return ""; }
 */