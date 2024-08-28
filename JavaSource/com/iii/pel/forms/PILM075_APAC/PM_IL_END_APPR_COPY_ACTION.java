package com.iii.pel.forms.PILM075_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_END_APPR_COPY_ACTION extends CommonAction {
	
	
	private HtmlOutputLabel COMP_EAS_AS_USER_ID_LABEL;

	private HtmlInputText COMP_EAS_AS_USER_ID;

	private HtmlOutputLabel COMP_UI_M_USER_DESC_LABEL;

	private HtmlInputText COMP_UI_M_USER_DESC;

	private HtmlOutputLabel COMP_EAS_AS_FM_PROD_CODE_LABEL;

	private HtmlInputText COMP_EAS_AS_FM_PROD_CODE;

	private HtmlOutputLabel COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_AS_FM_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_AS_TO_PROD_CODE_LABEL;

	private HtmlInputText COMP_EAS_AS_TO_PROD_CODE;

	private HtmlOutputLabel COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_AS_TO_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_FM_END_CODE_LABEL;

	private HtmlInputText COMP_EAS_FM_END_CODE;

	private HtmlOutputLabel COMP_EAS_FM_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_FM_END_CODE_DESC;

	private HtmlOutputLabel COMP_EAS_TO_END_CODE_LABEL;

	private HtmlInputText COMP_EAS_TO_END_CODE;

	private HtmlOutputLabel COMP_EAS_TO_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_EAS_TO_END_CODE_DESC;

	private PM_IL_END_APPR_COPY PM_IL_END_APPR_COPY_BEAN;
	
	
	private HtmlOutputLabel COMP_DEST_EAS_AS_USER_ID_LABEL;

	private HtmlInputText COMP_DEST_EAS_AS_USER_ID;

	private HtmlOutputLabel COMP_DEST_UI_M_USER_DESC_LABEL;

	private HtmlInputText COMP_DEST_UI_M_USER_DESC;

	private HtmlOutputLabel COMP_DEST_EAS_AS_FM_PROD_CODE_LABEL;

	private HtmlInputText COMP_DEST_EAS_AS_FM_PROD_CODE;

	private HtmlOutputLabel COMP_DEST_EAS_AS_FM_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_DEST_EAS_AS_FM_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_DEST_EAS_AS_TO_PROD_CODE_LABEL;

	private HtmlInputText COMP_DEST_EAS_AS_TO_PROD_CODE;

	private HtmlOutputLabel COMP_DEST_EAS_AS_TO_PROD_CODE_DESC_LABEL;

	private HtmlInputText COMP_DEST_EAS_AS_TO_PROD_CODE_DESC;

	private HtmlOutputLabel COMP_DEST_EAS_FM_END_CODE_LABEL;

	private HtmlInputText COMP_DEST_EAS_FM_END_CODE;

	private HtmlOutputLabel COMP_DEST_EAS_FM_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_DEST_EAS_FM_END_CODE_DESC;

	private HtmlOutputLabel COMP_DEST_EAS_TO_END_CODE_LABEL;

	private HtmlInputText COMP_DEST_EAS_TO_END_CODE;

	private HtmlOutputLabel COMP_DEST_EAS_TO_END_CODE_DESC_LABEL;

	private HtmlInputText COMP_DEST_EAS_TO_END_CODE_DESC;

	
	public PM_IL_END_APPR_COPY_ACTION()
	{
		PM_IL_END_APPR_COPY_BEAN = new PM_IL_END_APPR_COPY();
	}

	public PM_IL_END_APPR_COPY getPM_IL_END_APPR_COPY_BEAN() {
		return PM_IL_END_APPR_COPY_BEAN;
	}

	public void setPM_IL_END_APPR_COPY_BEAN(
			PM_IL_END_APPR_COPY pm_il_end_appr_copy_bean) {
		PM_IL_END_APPR_COPY_BEAN = pm_il_end_appr_copy_bean;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_USER_ID_LABEL() {
		return COMP_EAS_AS_USER_ID_LABEL;
	}

	public void setCOMP_EAS_AS_USER_ID_LABEL(
			HtmlOutputLabel comp_eas_as_user_id_label) {
		COMP_EAS_AS_USER_ID_LABEL = comp_eas_as_user_id_label;
	}

	public HtmlInputText getCOMP_EAS_AS_USER_ID() {
		return COMP_EAS_AS_USER_ID;
	}

	public void setCOMP_EAS_AS_USER_ID(HtmlInputText comp_eas_as_user_id) {
		COMP_EAS_AS_USER_ID = comp_eas_as_user_id;
	}

	public HtmlOutputLabel getCOMP_UI_M_USER_DESC_LABEL() {
		return COMP_UI_M_USER_DESC_LABEL;
	}

	public void setCOMP_UI_M_USER_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_user_desc_label) {
		COMP_UI_M_USER_DESC_LABEL = comp_ui_m_user_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_USER_DESC() {
		return COMP_UI_M_USER_DESC;
	}

	public void setCOMP_UI_M_USER_DESC(HtmlInputText comp_ui_m_user_desc) {
		COMP_UI_M_USER_DESC = comp_ui_m_user_desc;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_FM_PROD_CODE_LABEL() {
		return COMP_EAS_AS_FM_PROD_CODE_LABEL;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE_LABEL(
			HtmlOutputLabel comp_eas_as_fm_prod_code_label) {
		COMP_EAS_AS_FM_PROD_CODE_LABEL = comp_eas_as_fm_prod_code_label;
	}

	public HtmlInputText getCOMP_EAS_AS_FM_PROD_CODE() {
		return COMP_EAS_AS_FM_PROD_CODE;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE(HtmlInputText comp_eas_as_fm_prod_code) {
		COMP_EAS_AS_FM_PROD_CODE = comp_eas_as_fm_prod_code;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_FM_PROD_CODE_DESC_LABEL() {
		return COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_eas_as_fm_prod_code_desc_label) {
		COMP_EAS_AS_FM_PROD_CODE_DESC_LABEL = comp_eas_as_fm_prod_code_desc_label;
	}

	public HtmlInputText getCOMP_EAS_AS_FM_PROD_CODE_DESC() {
		return COMP_EAS_AS_FM_PROD_CODE_DESC;
	}

	public void setCOMP_EAS_AS_FM_PROD_CODE_DESC(
			HtmlInputText comp_eas_as_fm_prod_code_desc) {
		COMP_EAS_AS_FM_PROD_CODE_DESC = comp_eas_as_fm_prod_code_desc;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_TO_PROD_CODE_LABEL() {
		return COMP_EAS_AS_TO_PROD_CODE_LABEL;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE_LABEL(
			HtmlOutputLabel comp_eas_as_to_prod_code_label) {
		COMP_EAS_AS_TO_PROD_CODE_LABEL = comp_eas_as_to_prod_code_label;
	}

	public HtmlInputText getCOMP_EAS_AS_TO_PROD_CODE() {
		return COMP_EAS_AS_TO_PROD_CODE;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE(HtmlInputText comp_eas_as_to_prod_code) {
		COMP_EAS_AS_TO_PROD_CODE = comp_eas_as_to_prod_code;
	}

	public HtmlOutputLabel getCOMP_EAS_AS_TO_PROD_CODE_DESC_LABEL() {
		return COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_eas_as_to_prod_code_desc_label) {
		COMP_EAS_AS_TO_PROD_CODE_DESC_LABEL = comp_eas_as_to_prod_code_desc_label;
	}

	public HtmlInputText getCOMP_EAS_AS_TO_PROD_CODE_DESC() {
		return COMP_EAS_AS_TO_PROD_CODE_DESC;
	}

	public void setCOMP_EAS_AS_TO_PROD_CODE_DESC(
			HtmlInputText comp_eas_as_to_prod_code_desc) {
		COMP_EAS_AS_TO_PROD_CODE_DESC = comp_eas_as_to_prod_code_desc;
	}

	public HtmlOutputLabel getCOMP_EAS_FM_END_CODE_LABEL() {
		return COMP_EAS_FM_END_CODE_LABEL;
	}

	public void setCOMP_EAS_FM_END_CODE_LABEL(
			HtmlOutputLabel comp_eas_fm_end_code_label) {
		COMP_EAS_FM_END_CODE_LABEL = comp_eas_fm_end_code_label;
	}

	public HtmlInputText getCOMP_EAS_FM_END_CODE() {
		return COMP_EAS_FM_END_CODE;
	}

	public void setCOMP_EAS_FM_END_CODE(HtmlInputText comp_eas_fm_end_code) {
		COMP_EAS_FM_END_CODE = comp_eas_fm_end_code;
	}

	public HtmlOutputLabel getCOMP_EAS_FM_END_CODE_DESC_LABEL() {
		return COMP_EAS_FM_END_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_FM_END_CODE_DESC_LABEL(
			HtmlOutputLabel comp_eas_fm_end_code_desc_label) {
		COMP_EAS_FM_END_CODE_DESC_LABEL = comp_eas_fm_end_code_desc_label;
	}

	public HtmlInputText getCOMP_EAS_FM_END_CODE_DESC() {
		return COMP_EAS_FM_END_CODE_DESC;
	}

	public void setCOMP_EAS_FM_END_CODE_DESC(HtmlInputText comp_eas_fm_end_code_desc) {
		COMP_EAS_FM_END_CODE_DESC = comp_eas_fm_end_code_desc;
	}

	public HtmlOutputLabel getCOMP_EAS_TO_END_CODE_LABEL() {
		return COMP_EAS_TO_END_CODE_LABEL;
	}

	public void setCOMP_EAS_TO_END_CODE_LABEL(
			HtmlOutputLabel comp_eas_to_end_code_label) {
		COMP_EAS_TO_END_CODE_LABEL = comp_eas_to_end_code_label;
	}

	public HtmlInputText getCOMP_EAS_TO_END_CODE() {
		return COMP_EAS_TO_END_CODE;
	}

	public void setCOMP_EAS_TO_END_CODE(HtmlInputText comp_eas_to_end_code) {
		COMP_EAS_TO_END_CODE = comp_eas_to_end_code;
	}

	public HtmlOutputLabel getCOMP_EAS_TO_END_CODE_DESC_LABEL() {
		return COMP_EAS_TO_END_CODE_DESC_LABEL;
	}

	public void setCOMP_EAS_TO_END_CODE_DESC_LABEL(
			HtmlOutputLabel comp_eas_to_end_code_desc_label) {
		COMP_EAS_TO_END_CODE_DESC_LABEL = comp_eas_to_end_code_desc_label;
	}

	public HtmlInputText getCOMP_EAS_TO_END_CODE_DESC() {
		return COMP_EAS_TO_END_CODE_DESC;
	}

	public void setCOMP_EAS_TO_END_CODE_DESC(HtmlInputText comp_eas_to_end_code_desc) {
		COMP_EAS_TO_END_CODE_DESC = comp_eas_to_end_code_desc;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_AS_USER_ID_LABEL() {
		return COMP_DEST_EAS_AS_USER_ID_LABEL;
	}

	public void setCOMP_DEST_EAS_AS_USER_ID_LABEL(
			HtmlOutputLabel comp_dest_eas_as_user_id_label) {
		COMP_DEST_EAS_AS_USER_ID_LABEL = comp_dest_eas_as_user_id_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_AS_USER_ID() {
		return COMP_DEST_EAS_AS_USER_ID;
	}

	public void setCOMP_DEST_EAS_AS_USER_ID(HtmlInputText comp_dest_eas_as_user_id) {
		COMP_DEST_EAS_AS_USER_ID = comp_dest_eas_as_user_id;
	}

	public HtmlOutputLabel getCOMP_DEST_UI_M_USER_DESC_LABEL() {
		return COMP_DEST_UI_M_USER_DESC_LABEL;
	}

	public void setCOMP_DEST_UI_M_USER_DESC_LABEL(
			HtmlOutputLabel comp_dest_ui_m_user_desc_label) {
		COMP_DEST_UI_M_USER_DESC_LABEL = comp_dest_ui_m_user_desc_label;
	}

	public HtmlInputText getCOMP_DEST_UI_M_USER_DESC() {
		return COMP_DEST_UI_M_USER_DESC;
	}

	public void setCOMP_DEST_UI_M_USER_DESC(HtmlInputText comp_dest_ui_m_user_desc) {
		COMP_DEST_UI_M_USER_DESC = comp_dest_ui_m_user_desc;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_AS_FM_PROD_CODE_LABEL() {
		return COMP_DEST_EAS_AS_FM_PROD_CODE_LABEL;
	}

	public void setCOMP_DEST_EAS_AS_FM_PROD_CODE_LABEL(
			HtmlOutputLabel comp_dest_eas_as_fm_prod_code_label) {
		COMP_DEST_EAS_AS_FM_PROD_CODE_LABEL = comp_dest_eas_as_fm_prod_code_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_AS_FM_PROD_CODE() {
		return COMP_DEST_EAS_AS_FM_PROD_CODE;
	}

	public void setCOMP_DEST_EAS_AS_FM_PROD_CODE(
			HtmlInputText comp_dest_eas_as_fm_prod_code) {
		COMP_DEST_EAS_AS_FM_PROD_CODE = comp_dest_eas_as_fm_prod_code;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_AS_FM_PROD_CODE_DESC_LABEL() {
		return COMP_DEST_EAS_AS_FM_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_DEST_EAS_AS_FM_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_dest_eas_as_fm_prod_code_desc_label) {
		COMP_DEST_EAS_AS_FM_PROD_CODE_DESC_LABEL = comp_dest_eas_as_fm_prod_code_desc_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_AS_FM_PROD_CODE_DESC() {
		return COMP_DEST_EAS_AS_FM_PROD_CODE_DESC;
	}

	public void setCOMP_DEST_EAS_AS_FM_PROD_CODE_DESC(
			HtmlInputText comp_dest_eas_as_fm_prod_code_desc) {
		COMP_DEST_EAS_AS_FM_PROD_CODE_DESC = comp_dest_eas_as_fm_prod_code_desc;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_AS_TO_PROD_CODE_LABEL() {
		return COMP_DEST_EAS_AS_TO_PROD_CODE_LABEL;
	}

	public void setCOMP_DEST_EAS_AS_TO_PROD_CODE_LABEL(
			HtmlOutputLabel comp_dest_eas_as_to_prod_code_label) {
		COMP_DEST_EAS_AS_TO_PROD_CODE_LABEL = comp_dest_eas_as_to_prod_code_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_AS_TO_PROD_CODE() {
		return COMP_DEST_EAS_AS_TO_PROD_CODE;
	}

	public void setCOMP_DEST_EAS_AS_TO_PROD_CODE(
			HtmlInputText comp_dest_eas_as_to_prod_code) {
		COMP_DEST_EAS_AS_TO_PROD_CODE = comp_dest_eas_as_to_prod_code;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_AS_TO_PROD_CODE_DESC_LABEL() {
		return COMP_DEST_EAS_AS_TO_PROD_CODE_DESC_LABEL;
	}

	public void setCOMP_DEST_EAS_AS_TO_PROD_CODE_DESC_LABEL(
			HtmlOutputLabel comp_dest_eas_as_to_prod_code_desc_label) {
		COMP_DEST_EAS_AS_TO_PROD_CODE_DESC_LABEL = comp_dest_eas_as_to_prod_code_desc_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_AS_TO_PROD_CODE_DESC() {
		return COMP_DEST_EAS_AS_TO_PROD_CODE_DESC;
	}

	public void setCOMP_DEST_EAS_AS_TO_PROD_CODE_DESC(
			HtmlInputText comp_dest_eas_as_to_prod_code_desc) {
		COMP_DEST_EAS_AS_TO_PROD_CODE_DESC = comp_dest_eas_as_to_prod_code_desc;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_FM_END_CODE_LABEL() {
		return COMP_DEST_EAS_FM_END_CODE_LABEL;
	}

	public void setCOMP_DEST_EAS_FM_END_CODE_LABEL(
			HtmlOutputLabel comp_dest_eas_fm_end_code_label) {
		COMP_DEST_EAS_FM_END_CODE_LABEL = comp_dest_eas_fm_end_code_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_FM_END_CODE() {
		return COMP_DEST_EAS_FM_END_CODE;
	}

	public void setCOMP_DEST_EAS_FM_END_CODE(HtmlInputText comp_dest_eas_fm_end_code) {
		COMP_DEST_EAS_FM_END_CODE = comp_dest_eas_fm_end_code;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_FM_END_CODE_DESC_LABEL() {
		return COMP_DEST_EAS_FM_END_CODE_DESC_LABEL;
	}

	public void setCOMP_DEST_EAS_FM_END_CODE_DESC_LABEL(
			HtmlOutputLabel comp_dest_eas_fm_end_code_desc_label) {
		COMP_DEST_EAS_FM_END_CODE_DESC_LABEL = comp_dest_eas_fm_end_code_desc_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_FM_END_CODE_DESC() {
		return COMP_DEST_EAS_FM_END_CODE_DESC;
	}

	public void setCOMP_DEST_EAS_FM_END_CODE_DESC(
			HtmlInputText comp_dest_eas_fm_end_code_desc) {
		COMP_DEST_EAS_FM_END_CODE_DESC = comp_dest_eas_fm_end_code_desc;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_TO_END_CODE_LABEL() {
		return COMP_DEST_EAS_TO_END_CODE_LABEL;
	}

	public void setCOMP_DEST_EAS_TO_END_CODE_LABEL(
			HtmlOutputLabel comp_dest_eas_to_end_code_label) {
		COMP_DEST_EAS_TO_END_CODE_LABEL = comp_dest_eas_to_end_code_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_TO_END_CODE() {
		return COMP_DEST_EAS_TO_END_CODE;
	}

	public void setCOMP_DEST_EAS_TO_END_CODE(HtmlInputText comp_dest_eas_to_end_code) {
		COMP_DEST_EAS_TO_END_CODE = comp_dest_eas_to_end_code;
	}

	public HtmlOutputLabel getCOMP_DEST_EAS_TO_END_CODE_DESC_LABEL() {
		return COMP_DEST_EAS_TO_END_CODE_DESC_LABEL;
	}

	public void setCOMP_DEST_EAS_TO_END_CODE_DESC_LABEL(
			HtmlOutputLabel comp_dest_eas_to_end_code_desc_label) {
		COMP_DEST_EAS_TO_END_CODE_DESC_LABEL = comp_dest_eas_to_end_code_desc_label;
	}

	public HtmlInputText getCOMP_DEST_EAS_TO_END_CODE_DESC() {
		return COMP_DEST_EAS_TO_END_CODE_DESC;
	}

	public void setCOMP_DEST_EAS_TO_END_CODE_DESC(
			HtmlInputText comp_dest_eas_to_end_code_desc) {
		COMP_DEST_EAS_TO_END_CODE_DESC = comp_dest_eas_to_end_code_desc;
	}

	
	public List lovEAS_AS_USER_ID(Object obj) throws Exception {
		ResultSet resultSet = null;
		ArrayList suggesionList = new ArrayList();
		try {
			Vector objVector = new Vector();
			String query = "";
			if (obj.toString().equals("*")) {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_USER_ID_QUERY_STAR;
			} else {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_USER_ID_QUERY_SEARCH;
				objVector
						.add(obj + "%");
			}
			Object[] objects = (Object[]) objVector.toArray();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection(), objects);
			while (resultSet.next()) {
				PM_IL_END_APPR_COPY pm_il_end_appr_copy = new PM_IL_END_APPR_COPY();
				pm_il_end_appr_copy.setEAS_DEST_AS_USER_ID(resultSet.getString(1));
				pm_il_end_appr_copy.setDEST_UI_M_USER_DESC(resultSet.getString(2));
				suggesionList.add(pm_il_end_appr_copy);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return suggesionList;
	}
	public void actionListnerCommonItems(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}
	
	public void validateEAS_AS_USER_ID(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		try {	
			PM_IL_END_APPR_COPY_BEAN.setEAS_DEST_AS_USER_ID(value.toString());
			ArrayList<String> descList =callP_VAL_USER_ID(value
					.toString(), "E");
			PM_IL_END_APPR_COPY_BEAN.setDEST_UI_M_USER_DESC(descList.get(0));
			COMP_DEST_UI_M_USER_DESC.setSubmittedValue(descList.get(0));
			
		} catch (Exception e) {
			throw e;
		} finally {
			ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
					.getConnection(), FacesContext.getCurrentInstance(),
					component.getClientId(FacesContext.getCurrentInstance()),
					getWarningMap());
		}
	}
	
	private ArrayList<String> callP_VAL_USER_ID(String P_USER_ID,
			String P_ERR_FLAG) throws SQLException, Exception {
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();
		connection = commonUtils.getConnection();

		ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
		ArrayList<String> returnList = new ArrayList<String>();
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				P_USER_ID);
		parameterList.add(param1);
		OracleParameter param2 = new OracleParameter("in1", "STRING", "OUT",
				P_USER_ID);
		parameterList.add(param2);
		OracleParameter param3 = new OracleParameter("in1", "STRING", "OUT",
				P_USER_ID);
		parameterList.add(param3);
		OracleParameter param4 = new OracleParameter("in2", "STRING", "IN",
				P_ERR_FLAG);
		parameterList.add(param4);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		outputList = procHandler.execute(parameterList, connection,
		"P_VAL_USER_ID");
		Iterator<OracleParameter> iterator = outputList.iterator();
		while (iterator.hasNext()) {
			OracleParameter oracleParameter = iterator.next();
			System.out.println("Output value:::" + oracleParameter.getValue());
			if (oracleParameter.getValue() != null) {
				returnList.add(oracleParameter.getValue());
			}
		}
		return returnList;
	}
	
	
	
	public void validateEAS_AS_FM_PROD_CODE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			// :PM_IL_END_APPR_SETUP.EAS_AS_FM_PROD_CODE :=:PM_IL_END_APPR_SETUP.EAS_AS_FM_PROD_CODE;
			PM_IL_END_APPR_COPY_BEAN.setEAS_DEST_AS_FM_PROD_CODE((String)value);
			String FM_PROD_CODE_DESC = callL_VAL_PROD(PM_IL_END_APPR_COPY_BEAN
					.getEAS_DEST_AS_FM_PROD_CODE());
			PM_IL_END_APPR_COPY_BEAN
					.setEAS_DEST_AS_FM_PROD_CODE_DESC(FM_PROD_CODE_DESC);
			if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_TO_PROD_CODE() != null ){
				if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_FM_PROD_CODE().compareTo(
						PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_TO_PROD_CODE()) > 0 ){
					throw new Exception("Start value can not be greater then end value");
				}
			}
			COMP_DEST_EAS_AS_FM_PROD_CODE_DESC.setSubmittedValue(FM_PROD_CODE_DESC);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	private String callL_VAL_PROD(String P_PROD_CODE) {
		String P_PROD_DESC = "";
		try {
			ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
			ArrayList<OracleParameter> outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
					P_PROD_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("in2", "STRING",
					"OUT", "");
			parameterList.add(param2);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.execute(parameterList, CommonUtils
					.getConnection(), "L_VAL_PROD");
			Iterator<OracleParameter> iterator = outputList.iterator();
			while (iterator.hasNext()) {
				OracleParameter oracleParameter = iterator.next();
				System.out.println("Output value:::"
						+ oracleParameter.getValue());
				P_PROD_DESC = oracleParameter.getValue();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return P_PROD_DESC;
	}
	
	
	public void actionListnerEAS_AS_FM_PROD_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		int M_FIELD_LENGTH = 0;
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "String";
		if ((String) getCOMP_DEST_EAS_AS_FM_PROD_CODE().getSubmittedValue() == "") {
			Map attributes = getCOMP_DEST_EAS_AS_FM_PROD_CODE().getAttributes();
			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				/*M_FIELD_DATA = "0";*/
				M_FIELD_DATA = "";
			}
			getCOMP_DEST_EAS_AS_FM_PROD_CODE().setSubmittedValue(M_FIELD_DATA);
		}
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}
	
	
	public List lovEAS_AS_FM_PROD_CODE(Object obj) throws Exception {
		ResultSet resultSet = null;
		ArrayList suggesionList = new ArrayList();
		try {
			Vector objVector = new Vector();
			String query = "";
			if (obj.toString().equals("*")) {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_FM_PROD_CODE_QUERY_STAR;
			} else {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_AS_FM_PROD_CODE_QUERY_SEARCH;
				objVector
						.add(obj + "%");
			}
			Object[] objects = (Object[]) objVector.toArray();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection(), objects);
			while (resultSet.next()) {
				PM_IL_END_APPR_COPY pm_il_end_appr_copy = new PM_IL_END_APPR_COPY();
				pm_il_end_appr_copy.setEAS_DEST_AS_FM_PROD_CODE(resultSet.getString(1));
				pm_il_end_appr_copy.setEAS_DEST_AS_FM_PROD_CODE_DESC(resultSet.getString(2));
				suggesionList.add(pm_il_end_appr_copy);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return suggesionList;
	}
	
	
	public void validateEAS_AS_TO_PROD_CODE(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			String TO_PROD_CODE_DESC = callL_VAL_PROD(PM_IL_END_APPR_COPY_BEAN
					.getEAS_DEST_AS_TO_PROD_CODE());
			PM_IL_END_APPR_COPY_BEAN
					.setEAS_DEST_AS_TO_PROD_CODE_DESC(TO_PROD_CODE_DESC);
			System.out.println("PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_FM_PROD_CODE()      "+PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_FM_PROD_CODE());
			System.out.println("PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_TO_PROD_CODE()      "+PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_TO_PROD_CODE());
			if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_FM_PROD_CODE() != null && PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_TO_PROD_CODE() != null ){
				if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_FM_PROD_CODE().compareTo(
						PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_TO_PROD_CODE()) > 0 ){
					throw new Exception("Start value can not be greater then end value");
				}
			}
			COMP_DEST_EAS_AS_TO_PROD_CODE_DESC.setSubmittedValue(TO_PROD_CODE_DESC);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public void actionListnerEAS_AS_TO_PROD_CODE(ActionEvent ae) {
		int M_FIELD_LENGTH = -1;
		String M_DATA_TYPE = "String", M_FIELD_DATA = "";
		UIInput input = (UIInput) ae.getComponent().getParent(); 
		if ("".equals(((String) (getCOMP_DEST_EAS_AS_TO_PROD_CODE()
				.getSubmittedValue())).trim())) {
			Map attributes = getCOMP_DEST_EAS_AS_TO_PROD_CODE().findComponent(
					"PM_IL_END_APPR_COPY:EAS_DEST_AS_TO_PROD_CODE").getAttributes();
			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				/*M_FIELD_DATA = "0";*/
				M_FIELD_DATA = "";
			}
			if (M_DATA_TYPE.equalsIgnoreCase("String")) {
				if (((String) (getCOMP_DEST_EAS_AS_FM_PROD_CODE()).getSubmittedValue())
						.trim().equalsIgnoreCase(M_FIELD_DATA.trim())) {
					System.out.println("***********"+M_FIELD_LENGTH);
					/*M_FIELD_DATA = "zzzzzzzzzzzzzzzzzzzzzz".substring(0,
							M_FIELD_LENGTH);*/
					M_FIELD_DATA = "";
					getCOMP_DEST_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							M_FIELD_DATA);
				} else if (M_DATA_TYPE.equalsIgnoreCase("String")) {
					getCOMP_DEST_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							getCOMP_DEST_EAS_AS_FM_PROD_CODE().getSubmittedValue());
				}
			} else if (M_DATA_TYPE.equalsIgnoreCase("int")) {
				if (Integer.parseInt(((String) (getCOMP_DEST_EAS_FM_END_CODE())
						.getSubmittedValue())) == Integer
						.parseInt(M_FIELD_DATA)) {
					/*M_FIELD_DATA = "9999999999999999999999".substring(0,
							M_FIELD_LENGTH);*/
					M_FIELD_DATA = "";
					getCOMP_DEST_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							M_FIELD_DATA);
				} else {
					getCOMP_DEST_EAS_AS_TO_PROD_CODE().setSubmittedValue(
							(getCOMP_DEST_EAS_FM_END_CODE()).getSubmittedValue());
				}
			}
			PM_IL_END_APPR_COPY_BEAN
					.setEAS_DEST_AS_TO_PROD_CODE((String) getCOMP_DEST_EAS_AS_TO_PROD_CODE()
							.getSubmittedValue());
		} else {
			M_FIELD_DATA = ((String) (getCOMP_DEST_EAS_AS_TO_PROD_CODE())
					.getSubmittedValue());
			getCOMP_DEST_EAS_AS_TO_PROD_CODE().setSubmittedValue(M_FIELD_DATA);
		}
		PM_IL_END_APPR_COPY_BEAN.setEAS_DEST_AS_TO_PROD_CODE(getCOMP_DEST_EAS_AS_TO_PROD_CODE().getSubmittedValue().toString());
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}
	
	
	
	public void validateEAS_FM_END_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		ResultSet rs = null;
		Connection con = null;
		try {
				con = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				PM_IL_END_APPR_COPY_BEAN
				.setEAS_DEST_FM_END_CODE(value.toString());
				rs = handler
						.executeSelectStatement(
								PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$POST_QUERY_C2,
								con, new Object[] { PM_IL_END_APPR_COPY_BEAN
										.getEAS_DEST_FM_END_CODE() });
				while (rs.next()) {
					PM_IL_END_APPR_COPY_BEAN.setEAS_DEST_FM_END_CODE_DESC(rs
							.getString(1));
					COMP_DEST_EAS_FM_END_CODE_DESC.setSubmittedValue(rs.getString(1));
				}
				if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_TO_END_CODE() != null ){
					if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_FM_END_CODE().compareTo(
							PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_TO_END_CODE()) > 0 ){
						throw new Exception("Start value can not be greater then end value");
					}
				}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void actionListnerEAS_FM_END_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		int M_FIELD_LENGTH = 0;
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "String";
		if ((String) getCOMP_DEST_EAS_FM_END_CODE().getSubmittedValue() == "") {
			Map attributes = getCOMP_DEST_EAS_FM_END_CODE().getAttributes();
			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			getCOMP_DEST_EAS_FM_END_CODE().setSubmittedValue(M_FIELD_DATA);
		}
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());
	}
	
	public List lovEAS_FM_END_CODE(Object obj) throws Exception {
		ResultSet resultSet = null;
		ArrayList suggesionList = new ArrayList();
		try {
			Vector objVector = new Vector();
			String query = "";
			if (obj.toString().equals("*")) {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_FM_END_CODE_QUERY_STAR;
			} else {
				query = PILM075_APAC_SQL_CONSTANTS.LOV_EAS_FM_END_CODE_QUERY_SEARCH;
				objVector
						.add(obj + "%");
			}
			Object[] objects = (Object[]) objVector.toArray();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, CommonUtils
					.getConnection(), objects);
			while (resultSet.next()) {
				PM_IL_END_APPR_COPY pm_il_end_appr_copy = new PM_IL_END_APPR_COPY();
				pm_il_end_appr_copy.setEAS_DEST_FM_END_CODE(resultSet.getString(1));
				pm_il_end_appr_copy.setEAS_DEST_TO_END_CODE_DESC(resultSet.getString(2));
				suggesionList.add(pm_il_end_appr_copy);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		return suggesionList;
	}
	
	
	public void validateEAS_TO_END_CODE(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception {
		ResultSet rs = null;
		Connection con = null;
		try {
				con = CommonUtils.getConnection();
				CRUDHandler handler = new CRUDHandler();
				rs = handler
						.executeSelectStatement(
								PILM075_APAC_SQL_CONSTANTS.PM_IL_END_APPR_SETUP$POST_QUERY_C3,
								con, new Object[] { PM_IL_END_APPR_COPY_BEAN
										.getEAS_DEST_TO_END_CODE() });
				while (rs.next()) {
					PM_IL_END_APPR_COPY_BEAN.setEAS_DEST_TO_END_CODE_DESC(rs
							.getString(1));
					COMP_DEST_EAS_TO_END_CODE_DESC.setSubmittedValue(rs.getString(1));
				}
				if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_FM_END_CODE() != null ){
					if(PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_FM_END_CODE().compareTo(
							PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_TO_END_CODE()) > 0 ){
						throw new Exception("Start value can not be greater then end value");
					}
				}

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	public void actionListnerEAS_TO_END_CODE(ActionEvent ae) {
		int M_FIELD_LENGTH = -1;
		String M_DATA_TYPE = "String", M_FIELD_DATA = "";
		UIInput input = (UIInput) ae.getComponent().getParent(); 
		if ("".equals(((String) (getCOMP_DEST_EAS_TO_END_CODE()
						.getSubmittedValue())).trim())) {

			Map attributes = getCOMP_DEST_EAS_TO_END_CODE().findComponent(
					"PM_IL_END_APPR_COPY:EAS_DEST_TO_END_CODE").getAttributes();

			M_FIELD_LENGTH = ((Integer) attributes.get("maxlength"));
			if (M_DATA_TYPE.equalsIgnoreCase("String")
					|| M_DATA_TYPE.equalsIgnoreCase("int")) {
				M_FIELD_DATA = "0";
			}
			if (M_DATA_TYPE.equalsIgnoreCase("String")) {

				if (((String) (getCOMP_DEST_EAS_FM_END_CODE()).getSubmittedValue())
						.trim().equalsIgnoreCase(M_FIELD_DATA.trim())) {					
					M_FIELD_DATA = "zzzzzzzzzzzzzzzzzzzzzz".substring(0,
							M_FIELD_LENGTH);
					getCOMP_DEST_EAS_TO_END_CODE().setSubmittedValue(M_FIELD_DATA);

				} else if (M_DATA_TYPE.equalsIgnoreCase("String")) {

					getCOMP_DEST_EAS_TO_END_CODE().setSubmittedValue(
							getCOMP_DEST_EAS_FM_END_CODE().getSubmittedValue());
				}
			} else if (M_DATA_TYPE.equalsIgnoreCase("int")) {
				if (Integer.parseInt(((String) (getCOMP_DEST_EAS_FM_END_CODE())
						.getSubmittedValue())) == Integer
						.parseInt(M_FIELD_DATA)) {
					M_FIELD_DATA = "9999999999999999999999".substring(0,
							M_FIELD_LENGTH);
					getCOMP_DEST_EAS_TO_END_CODE().setSubmittedValue(M_FIELD_DATA);
				} else {
					getCOMP_DEST_EAS_TO_END_CODE().setSubmittedValue(
							(getCOMP_DEST_EAS_FM_END_CODE()).getSubmittedValue());
				}
			}
			PM_IL_END_APPR_COPY_BEAN
					.setEAS_DEST_TO_END_CODE((String) getCOMP_DEST_EAS_TO_END_CODE()
							.getSubmittedValue());
			//return;
		} else {

			M_FIELD_DATA = ((String) (getCOMP_DEST_EAS_TO_END_CODE())
					.getSubmittedValue());

			getCOMP_DEST_EAS_TO_END_CODE().setSubmittedValue(M_FIELD_DATA);

		}
		PM_IL_END_APPR_COPY_BEAN
		.setEAS_DEST_TO_END_CODE(getCOMP_DEST_EAS_TO_END_CODE().getSubmittedValue().toString());
		ErrorHelpUtil.validate(input, input.getId(), getErrorMap());

	}
	
	
	public String okButtonAction()throws Exception
	{
		String returnValue = null;
		try {
			PM_IL_END_SETUP_DET_DELEGATE pm_il_end_setup_det_delegate = new PM_IL_END_SETUP_DET_DELEGATE();
			pm_il_end_setup_det_delegate.L_COPY_USER_DTLS(PM_IL_END_APPR_COPY_BEAN);
			returnValue ="PILM075_APAC_PM_IL_END_APPR_SETUP";
			PM_IL_END_APPR_SETUP_ACTION pm_il_end_appr_setup_action = (PM_IL_END_APPR_SETUP_ACTION)new CommonUtils().getMappedBeanFromSession("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION");
			new PILM075_APAC_DELEGATE().fetchMasterDetails(pm_il_end_appr_setup_action.getPM_IL_END_APPR_SETUP_BEAN(), PM_IL_END_APPR_COPY_BEAN.getEAS_DEST_AS_USER_ID());
			PM_IL_END_APPR_SETUP_ACTION setUpAction = (PM_IL_END_APPR_SETUP_ACTION) CommonUtils.getGlobalObject("PILM075_APAC_PM_IL_END_APPR_SETUP_ACTION");
			setUpAction.getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Copy Process Completed Sucessfully");
			setUpAction.getWarningMap().put("CURRENT", "Copy Process Completed Sucessfully");
		} catch (SQLException e) {
			returnValue = "";
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		} catch (Exception e) {
			returnValue = "";
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("CURRENT", e.getMessage());
		}finally{
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(CommonUtils.getConnection(),
					FacesContext.getCurrentInstance(), "UI_M_BUT_OK",
					getErrorMap(), getWarningMap());
		}
		return returnValue;
	}
	
	public String cancelButtonAction()
	{
		
		return "PILM075_APAC_PM_IL_END_APPR_SETUP";
	}
	
}
