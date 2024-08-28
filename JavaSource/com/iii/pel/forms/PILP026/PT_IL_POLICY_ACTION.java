package com.iii.pel.forms.PILP026;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POLICY_ACTION extends CommonReportAction {

	private HtmlOutputLabel COMP_POL_NO_LABEL;

	private HtmlInputText COMP_POL_NO;

	private HtmlOutputLabel COMP_POL_ASSURED_NAME_LABEL;

	private HtmlInputText COMP_POL_ASSURED_NAME;

	private HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL;

	private HtmlInputText COMP_POL_LC_SUM_ASSURED;

	private HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_POL_FC_BASIC_PREM;

	private HtmlOutputLabel COMP_POL_LC_BASIC_PREM_LABEL;

	private HtmlInputText COMP_POL_LC_BASIC_PREM;

	private HtmlOutputLabel COMP_POL_FC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_POL_FC_ADDL_PREM;

	private HtmlOutputLabel COMP_POL_LC_ADDL_PREM_LABEL;

	private HtmlInputText COMP_POL_LC_ADDL_PREM;

	private HtmlOutputLabel COMP_POL_END_NO_IDX_LABEL;

	private HtmlInputText COMP_POL_END_NO_IDX;

	private HtmlOutputLabel COMP_POL_END_NO_LABEL;

	private HtmlInputText COMP_POL_END_NO;

	private HtmlAjaxCommandButton COMP_UI_M_BUT_DELETE;

	private PT_IL_POLICY PT_IL_POLICY_BEAN;

	public PILP026_COMPOSITE_ACTION compositeAction;

	private PT_IL_POLICY_HELPER helper;

	public PT_IL_POLICY_ACTION() {

		PT_IL_POLICY_BEAN = new PT_IL_POLICY();
		helper = new PT_IL_POLICY_HELPER();
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

	public HtmlOutputLabel getCOMP_POL_LC_SUM_ASSURED_LABEL() {
		return COMP_POL_LC_SUM_ASSURED_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_SUM_ASSURED() {
		return COMP_POL_LC_SUM_ASSURED;
	}

	public void setCOMP_POL_LC_SUM_ASSURED_LABEL(
			HtmlOutputLabel COMP_POL_LC_SUM_ASSURED_LABEL) {
		this.COMP_POL_LC_SUM_ASSURED_LABEL = COMP_POL_LC_SUM_ASSURED_LABEL;
	}

	public void setCOMP_POL_LC_SUM_ASSURED(HtmlInputText COMP_POL_LC_SUM_ASSURED) {
		this.COMP_POL_LC_SUM_ASSURED = COMP_POL_LC_SUM_ASSURED;
	}

	public HtmlOutputLabel getCOMP_POL_FC_BASIC_PREM_LABEL() {
		return COMP_POL_FC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_BASIC_PREM() {
		return COMP_POL_FC_BASIC_PREM;
	}

	public void setCOMP_POL_FC_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_POL_FC_BASIC_PREM_LABEL) {
		this.COMP_POL_FC_BASIC_PREM_LABEL = COMP_POL_FC_BASIC_PREM_LABEL;
	}

	public void setCOMP_POL_FC_BASIC_PREM(HtmlInputText COMP_POL_FC_BASIC_PREM) {
		this.COMP_POL_FC_BASIC_PREM = COMP_POL_FC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_LC_BASIC_PREM_LABEL() {
		return COMP_POL_LC_BASIC_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_BASIC_PREM() {
		return COMP_POL_LC_BASIC_PREM;
	}

	public void setCOMP_POL_LC_BASIC_PREM_LABEL(
			HtmlOutputLabel COMP_POL_LC_BASIC_PREM_LABEL) {
		this.COMP_POL_LC_BASIC_PREM_LABEL = COMP_POL_LC_BASIC_PREM_LABEL;
	}

	public void setCOMP_POL_LC_BASIC_PREM(HtmlInputText COMP_POL_LC_BASIC_PREM) {
		this.COMP_POL_LC_BASIC_PREM = COMP_POL_LC_BASIC_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_FC_ADDL_PREM_LABEL() {
		return COMP_POL_FC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_FC_ADDL_PREM() {
		return COMP_POL_FC_ADDL_PREM;
	}

	public void setCOMP_POL_FC_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_POL_FC_ADDL_PREM_LABEL) {
		this.COMP_POL_FC_ADDL_PREM_LABEL = COMP_POL_FC_ADDL_PREM_LABEL;
	}

	public void setCOMP_POL_FC_ADDL_PREM(HtmlInputText COMP_POL_FC_ADDL_PREM) {
		this.COMP_POL_FC_ADDL_PREM = COMP_POL_FC_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_LC_ADDL_PREM_LABEL() {
		return COMP_POL_LC_ADDL_PREM_LABEL;
	}

	public HtmlInputText getCOMP_POL_LC_ADDL_PREM() {
		return COMP_POL_LC_ADDL_PREM;
	}

	public void setCOMP_POL_LC_ADDL_PREM_LABEL(
			HtmlOutputLabel COMP_POL_LC_ADDL_PREM_LABEL) {
		this.COMP_POL_LC_ADDL_PREM_LABEL = COMP_POL_LC_ADDL_PREM_LABEL;
	}

	public void setCOMP_POL_LC_ADDL_PREM(HtmlInputText COMP_POL_LC_ADDL_PREM) {
		this.COMP_POL_LC_ADDL_PREM = COMP_POL_LC_ADDL_PREM;
	}

	public HtmlOutputLabel getCOMP_POL_END_NO_IDX_LABEL() {
		return COMP_POL_END_NO_IDX_LABEL;
	}

	public HtmlInputText getCOMP_POL_END_NO_IDX() {
		return COMP_POL_END_NO_IDX;
	}

	public void setCOMP_POL_END_NO_IDX_LABEL(
			HtmlOutputLabel COMP_POL_END_NO_IDX_LABEL) {
		this.COMP_POL_END_NO_IDX_LABEL = COMP_POL_END_NO_IDX_LABEL;
	}

	public void setCOMP_POL_END_NO_IDX(HtmlInputText COMP_POL_END_NO_IDX) {
		this.COMP_POL_END_NO_IDX = COMP_POL_END_NO_IDX;
	}

	public HtmlOutputLabel getCOMP_POL_END_NO_LABEL() {
		return COMP_POL_END_NO_LABEL;
	}

	public HtmlInputText getCOMP_POL_END_NO() {
		return COMP_POL_END_NO;
	}

	public void setCOMP_POL_END_NO_LABEL(HtmlOutputLabel COMP_POL_END_NO_LABEL) {
		this.COMP_POL_END_NO_LABEL = COMP_POL_END_NO_LABEL;
	}

	public void setCOMP_POL_END_NO(HtmlInputText COMP_POL_END_NO) {
		this.COMP_POL_END_NO = COMP_POL_END_NO;
	}

	public HtmlAjaxCommandButton getCOMP_UI_M_BUT_DELETE() {
		return COMP_UI_M_BUT_DELETE;
	}

	public void setCOMP_UI_M_BUT_DELETE(
			HtmlAjaxCommandButton comp_ui_m_but_delete) {
		COMP_UI_M_BUT_DELETE = comp_ui_m_but_delete;
	}

	public PT_IL_POLICY getPT_IL_POLICY_BEAN() {
		return PT_IL_POLICY_BEAN;
	}

	public void setPT_IL_POLICY_BEAN(PT_IL_POLICY PT_IL_POLICY_BEAN) {
		this.PT_IL_POLICY_BEAN = PT_IL_POLICY_BEAN;
	}

	public void saveRecord() {
		try {
			if (getPT_IL_POLICY_BEAN().getROWID() != null) {
				new CRUDHandler().executeInsert(getPT_IL_POLICY_BEAN(),
						CommonUtils.getConnection());
			} else {
				new CRUDHandler().executeInsert(getPT_IL_POLICY_BEAN(),
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
				// helper.executeQuery(compositeAction);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public void BUT_DELETE_ENDROS()  {
		try {
			helper.endrosementDeletion(compositeAction);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
					"Endorsement Deleted succesfully");
			getWarningMap().put("delete", "Endorsement Deleted succesfully");
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("delete", e.getMessage());
		}
	}

	public List<LovBean> lovPolno(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = "SELECT POL_NO FROM PT_IL_POLICY WHERE NVL(POL_APPRV_STATUS, 'N') != 'A' AND NVL(POL_END_NO_IDX, 0) > 0  AND POL_DS_TYPE ='2' AND POL_STATUS ='E' AND NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = POL_NO AND CLAIM_TYPE != 'O') AND "
					+ "ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
			 * 
			 * query = "SELECT POL_NO FROM PT_IL_POLICY WHERE NVL(POL_APPRV_STATUS, 'N') != 'A' AND NVL(POL_END_NO_IDX, 0) > 0 AND POL_DS_TYPE ='2' AND POL_STATUS ='E' AND "
					+ "(POL_NO LIKE ? ) AND NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = POL_NO AND CLAIM_TYPE != 'O') "
					+ "AND ROWNUM < ? ORDER BY 1";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
			query = "SELECT POL_NO FROM PT_IL_POLICY WHERE NVL(POL_APPRV_STATUS, 'N') != 'A' AND NVL(POL_END_NO_IDX, 0) > 0 AND POL_DS_TYPE ='2' AND POL_STATUS ='E' AND "
					+ "(UPPER(POL_NO) LIKE UPPER(?) ) AND NOT EXISTS (SELECT 1 FROM PT_IL_CLAIM WHERE CLAIM_POL_NO = POL_NO AND CLAIM_TYPE != 'O') "
					+ "AND ROWNUM < ? ORDER BY 1";
			/*end*/
			
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("POL_NO", e.getMessage());
		}
		return suggestionList;
	}

	public List<LovBean> prepareLovList(String query, Object[] obj) {
		List<LovBean> suggestionList = new ArrayList<LovBean>();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, obj);
			while (resultSet.next()) {
				LovBean bean = new LovBean();
				bean.setLovCode(resultSet.getString(1));
				// bean.setLovName(resultSet.getString(2));
				suggestionList.add(bean);
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
		return suggestionList;
	}

	public void validatePOL_NO(FacesContext context, UIComponent component,
			Object value) throws Exception {

		PT_IL_POLICY_BEAN.setPOL_NO((String) value);
		helper.when_validate_Polno((String) value, PT_IL_POLICY_BEAN);
		COMP_POL_ASSURED_NAME.resetValue();
		COMP_POL_END_NO.resetValue();
		COMP_POL_END_NO_IDX.resetValue();
		COMP_POL_FC_ADDL_PREM.resetValue();
		COMP_POL_FC_BASIC_PREM.resetValue();
		COMP_POL_LC_ADDL_PREM.resetValue();
		COMP_POL_LC_BASIC_PREM.resetValue();
		COMP_POL_LC_SUM_ASSURED.resetValue();

	}
	
}