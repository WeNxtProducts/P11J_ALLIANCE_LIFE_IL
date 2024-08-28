package com.iii.pel.forms.PILP080;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
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

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT010.PV_IL_POL_RI_DETL;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_PV_MED_HDR_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_APPRV_STATUS;

	private HtmlOutputLabel COMP_PMH_CLINIC_CODE_LABEL;

	private HtmlInputText COMP_PMH_CLINIC_CODE;

	private HtmlOutputLabel COMP_UI_M_CLINIC_NAME_LABEL;

	private HtmlInputText COMP_UI_M_CLINIC_NAME;

	private HtmlOutputLabel COMP_PMH_VOUCH_NO_LABEL;

	private HtmlInputText COMP_PMH_VOUCH_NO;

	private HtmlOutputLabel COMP_PMH_POL_NO_LABEL;

	private HtmlInputText COMP_PMH_POL_NO;

	private HtmlOutputLabel COMP_PMH_PROD_CODE_LABEL;

	private HtmlInputText COMP_PMH_PROD_CODE;

	private HtmlOutputLabel COMP_UI_M_PMH_PROD_NAME_LABEL;

	private HtmlInputText COMP_UI_M_PMH_PROD_NAME;

	private HtmlOutputLabel COMP_PMH_FM_PAID_DT_LABEL;

	private HtmlCalendar COMP_PMH_FM_PAID_DT;

	private HtmlOutputLabel COMP_PMH_TO_PAID_DT_LABEL;

	private HtmlCalendar COMP_PMH_TO_PAID_DT;

	private HtmlOutputLabel COMP_PMH_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_PMH_PROCESS_DT;

	private HtmlOutputLabel COMP_PMH_TRAN_CODE_LABEL;

	private HtmlInputText COMP_PMH_TRAN_CODE;

	private HtmlOutputLabel COMP_PMH_DOC_NO_LABEL;

	private HtmlInputText COMP_PMH_DOC_NO;

	private HtmlOutputLabel COMP_PMH_ACNT_YEAR_LABEL;

	private HtmlInputText COMP_PMH_ACNT_YEAR;

	private HtmlCommandButton COMP_UI_M_BUT_APPROVE;

	private HtmlCommandButton COMP_UI_M_BUT_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_ERR_DTLS;

	private HtmlCommandButton COMP_UI_M_BUT_GENERATE;

	private HtmlCommandButton COMP_UI_M_BUT_REP;

	private PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN;

	public PILP080_COMPOSITE_ACTION compositeAction;

	private PT_IL_PV_MED_HDR_HELPER helper;

	public PT_IL_PV_MED_HDR_ACTION() {

		PT_IL_PV_MED_HDR_BEAN = new PT_IL_PV_MED_HDR();
		helper = new PT_IL_PV_MED_HDR_HELPER();
	}

	public HtmlOutputLabel getCOMP_UI_M_APPRV_STATUS() {
		return COMP_UI_M_APPRV_STATUS;
	}

	public void setCOMP_UI_M_APPRV_STATUS(HtmlOutputLabel COMP_UI_M_APPRV_STATUS) {
		this.COMP_UI_M_APPRV_STATUS = COMP_UI_M_APPRV_STATUS;
	}

	public HtmlOutputLabel getCOMP_PMH_CLINIC_CODE_LABEL() {
		return COMP_PMH_CLINIC_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PMH_CLINIC_CODE() {
		return COMP_PMH_CLINIC_CODE;
	}

	public void setCOMP_PMH_CLINIC_CODE_LABEL(
			HtmlOutputLabel COMP_PMH_CLINIC_CODE_LABEL) {
		this.COMP_PMH_CLINIC_CODE_LABEL = COMP_PMH_CLINIC_CODE_LABEL;
	}

	public void setCOMP_PMH_CLINIC_CODE(HtmlInputText COMP_PMH_CLINIC_CODE) {
		this.COMP_PMH_CLINIC_CODE = COMP_PMH_CLINIC_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CLINIC_NAME_LABEL() {
		return COMP_UI_M_CLINIC_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CLINIC_NAME() {
		return COMP_UI_M_CLINIC_NAME;
	}

	public void setCOMP_UI_M_CLINIC_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_CLINIC_NAME_LABEL) {
		this.COMP_UI_M_CLINIC_NAME_LABEL = COMP_UI_M_CLINIC_NAME_LABEL;
	}

	public void setCOMP_UI_M_CLINIC_NAME(HtmlInputText COMP_UI_M_CLINIC_NAME) {
		this.COMP_UI_M_CLINIC_NAME = COMP_UI_M_CLINIC_NAME;
	}

	public HtmlOutputLabel getCOMP_PMH_VOUCH_NO_LABEL() {
		return COMP_PMH_VOUCH_NO_LABEL;
	}

	public HtmlInputText getCOMP_PMH_VOUCH_NO() {
		return COMP_PMH_VOUCH_NO;
	}

	public void setCOMP_PMH_VOUCH_NO_LABEL(
			HtmlOutputLabel COMP_PMH_VOUCH_NO_LABEL) {
		this.COMP_PMH_VOUCH_NO_LABEL = COMP_PMH_VOUCH_NO_LABEL;
	}

	public void setCOMP_PMH_VOUCH_NO(HtmlInputText COMP_PMH_VOUCH_NO) {
		this.COMP_PMH_VOUCH_NO = COMP_PMH_VOUCH_NO;
	}

	public HtmlOutputLabel getCOMP_PMH_POL_NO_LABEL() {
		return COMP_PMH_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_PMH_POL_NO() {
		return COMP_PMH_POL_NO;
	}

	public void setCOMP_PMH_POL_NO_LABEL(HtmlOutputLabel COMP_PMH_POL_NO_LABEL) {
		this.COMP_PMH_POL_NO_LABEL = COMP_PMH_POL_NO_LABEL;
	}

	public void setCOMP_PMH_POL_NO(HtmlInputText COMP_PMH_POL_NO) {
		this.COMP_PMH_POL_NO = COMP_PMH_POL_NO;
	}

	public HtmlOutputLabel getCOMP_PMH_PROD_CODE_LABEL() {
		return COMP_PMH_PROD_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PMH_PROD_CODE() {
		return COMP_PMH_PROD_CODE;
	}

	public void setCOMP_PMH_PROD_CODE_LABEL(
			HtmlOutputLabel COMP_PMH_PROD_CODE_LABEL) {
		this.COMP_PMH_PROD_CODE_LABEL = COMP_PMH_PROD_CODE_LABEL;
	}

	public void setCOMP_PMH_PROD_CODE(HtmlInputText COMP_PMH_PROD_CODE) {
		this.COMP_PMH_PROD_CODE = COMP_PMH_PROD_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_PMH_PROD_NAME_LABEL() {
		return COMP_UI_M_PMH_PROD_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_PMH_PROD_NAME() {
		return COMP_UI_M_PMH_PROD_NAME;
	}

	public void setCOMP_UI_M_PMH_PROD_NAME_LABEL(
			HtmlOutputLabel COMP_UI_M_PMH_PROD_NAME_LABEL) {
		this.COMP_UI_M_PMH_PROD_NAME_LABEL = COMP_UI_M_PMH_PROD_NAME_LABEL;
	}

	public void setCOMP_UI_M_PMH_PROD_NAME(HtmlInputText COMP_UI_M_PMH_PROD_NAME) {
		this.COMP_UI_M_PMH_PROD_NAME = COMP_UI_M_PMH_PROD_NAME;
	}

	public HtmlOutputLabel getCOMP_PMH_FM_PAID_DT_LABEL() {
		return COMP_PMH_FM_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMH_FM_PAID_DT() {
		return COMP_PMH_FM_PAID_DT;
	}

	public void setCOMP_PMH_FM_PAID_DT_LABEL(
			HtmlOutputLabel COMP_PMH_FM_PAID_DT_LABEL) {
		this.COMP_PMH_FM_PAID_DT_LABEL = COMP_PMH_FM_PAID_DT_LABEL;
	}

	public void setCOMP_PMH_FM_PAID_DT(HtmlCalendar COMP_PMH_FM_PAID_DT) {
		this.COMP_PMH_FM_PAID_DT = COMP_PMH_FM_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_PMH_TO_PAID_DT_LABEL() {
		return COMP_PMH_TO_PAID_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMH_TO_PAID_DT() {
		return COMP_PMH_TO_PAID_DT;
	}

	public void setCOMP_PMH_TO_PAID_DT_LABEL(
			HtmlOutputLabel COMP_PMH_TO_PAID_DT_LABEL) {
		this.COMP_PMH_TO_PAID_DT_LABEL = COMP_PMH_TO_PAID_DT_LABEL;
	}

	public void setCOMP_PMH_TO_PAID_DT(HtmlCalendar COMP_PMH_TO_PAID_DT) {
		this.COMP_PMH_TO_PAID_DT = COMP_PMH_TO_PAID_DT;
	}

	public HtmlOutputLabel getCOMP_PMH_PROCESS_DT_LABEL() {
		return COMP_PMH_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_PMH_PROCESS_DT() {
		return COMP_PMH_PROCESS_DT;
	}

	public void setCOMP_PMH_PROCESS_DT_LABEL(
			HtmlOutputLabel COMP_PMH_PROCESS_DT_LABEL) {
		this.COMP_PMH_PROCESS_DT_LABEL = COMP_PMH_PROCESS_DT_LABEL;
	}

	public void setCOMP_PMH_PROCESS_DT(HtmlCalendar COMP_PMH_PROCESS_DT) {
		this.COMP_PMH_PROCESS_DT = COMP_PMH_PROCESS_DT;
	}

	public HtmlOutputLabel getCOMP_PMH_TRAN_CODE_LABEL() {
		return COMP_PMH_TRAN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_PMH_TRAN_CODE() {
		return COMP_PMH_TRAN_CODE;
	}

	public void setCOMP_PMH_TRAN_CODE_LABEL(
			HtmlOutputLabel COMP_PMH_TRAN_CODE_LABEL) {
		this.COMP_PMH_TRAN_CODE_LABEL = COMP_PMH_TRAN_CODE_LABEL;
	}

	public void setCOMP_PMH_TRAN_CODE(HtmlInputText COMP_PMH_TRAN_CODE) {
		this.COMP_PMH_TRAN_CODE = COMP_PMH_TRAN_CODE;
	}

	public HtmlOutputLabel getCOMP_PMH_DOC_NO_LABEL() {
		return COMP_PMH_DOC_NO_LABEL;
	}

	public HtmlInputText getCOMP_PMH_DOC_NO() {
		return COMP_PMH_DOC_NO;
	}

	public void setCOMP_PMH_DOC_NO_LABEL(HtmlOutputLabel COMP_PMH_DOC_NO_LABEL) {
		this.COMP_PMH_DOC_NO_LABEL = COMP_PMH_DOC_NO_LABEL;
	}

	public void setCOMP_PMH_DOC_NO(HtmlInputText COMP_PMH_DOC_NO) {
		this.COMP_PMH_DOC_NO = COMP_PMH_DOC_NO;
	}

	public HtmlOutputLabel getCOMP_PMH_ACNT_YEAR_LABEL() {
		return COMP_PMH_ACNT_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_PMH_ACNT_YEAR() {
		return COMP_PMH_ACNT_YEAR;
	}

	public void setCOMP_PMH_ACNT_YEAR_LABEL(
			HtmlOutputLabel COMP_PMH_ACNT_YEAR_LABEL) {
		this.COMP_PMH_ACNT_YEAR_LABEL = COMP_PMH_ACNT_YEAR_LABEL;
	}

	public void setCOMP_PMH_ACNT_YEAR(HtmlInputText COMP_PMH_ACNT_YEAR) {
		this.COMP_PMH_ACNT_YEAR = COMP_PMH_ACNT_YEAR;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_APPROVE() {
		return COMP_UI_M_BUT_APPROVE;
	}

	public void setCOMP_UI_M_BUT_APPROVE(HtmlCommandButton COMP_UI_M_BUT_APPROVE) {
		this.COMP_UI_M_BUT_APPROVE = COMP_UI_M_BUT_APPROVE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DTLS() {
		return COMP_UI_M_BUT_DTLS;
	}

	public void setCOMP_UI_M_BUT_DTLS(HtmlCommandButton COMP_UI_M_BUT_DTLS) {
		this.COMP_UI_M_BUT_DTLS = COMP_UI_M_BUT_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ERR_DTLS() {
		return COMP_UI_M_BUT_ERR_DTLS;
	}

	public void setCOMP_UI_M_BUT_ERR_DTLS(
			HtmlCommandButton COMP_UI_M_BUT_ERR_DTLS) {
		this.COMP_UI_M_BUT_ERR_DTLS = COMP_UI_M_BUT_ERR_DTLS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_GENERATE() {
		return COMP_UI_M_BUT_GENERATE;
	}

	public void setCOMP_UI_M_BUT_GENERATE(
			HtmlCommandButton COMP_UI_M_BUT_GENERATE) {
		this.COMP_UI_M_BUT_GENERATE = COMP_UI_M_BUT_GENERATE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_REP() {
		return COMP_UI_M_BUT_REP;
	}

	public void setCOMP_UI_M_BUT_REP(HtmlCommandButton COMP_UI_M_BUT_REP) {
		this.COMP_UI_M_BUT_REP = COMP_UI_M_BUT_REP;
	}

	public PT_IL_PV_MED_HDR getPT_IL_PV_MED_HDR_BEAN() {
		return PT_IL_PV_MED_HDR_BEAN;
	}

	public void setPT_IL_PV_MED_HDR_BEAN(PT_IL_PV_MED_HDR PT_IL_PV_MED_HDR_BEAN) {
		this.PT_IL_PV_MED_HDR_BEAN = PT_IL_PV_MED_HDR_BEAN;
	}

	/*
	 * public void saveRecord() { try { if
	 * (getPT_IL_PV_MED_HDR_BEAN().getROWID() != null) { new
	 * CRUDHandler().executeUpdate(getPT_IL_PV_MED_HDR_BEAN(),
	 * CommonUtils.getConnection());
	 *  } else { new CRUDHandler().executeInsert(getPT_IL_PV_MED_HDR_BEAN(),
	 * CommonUtils.getConnection()); } CommonUtils.getConnection().commit(); }
	 * catch (Exception e) {
	 * getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
	 * e.getMessage()); getErrorMap().put("SAVE", e.getMessage()); } }
	 */
	public void saveRecord() {
		try {
			if (getPT_IL_PV_MED_HDR_BEAN().getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					helper.PRE_UPDATE(compositeAction);
				}
				new CRUDHandler().executeUpdate(getPT_IL_PV_MED_HDR_BEAN(),
						CommonUtils.getConnection());
				getWarningMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				String message = Messages.getString(
						PELConstants.pelMessagePropertiesPath,
						"errorPanel$message$update");
			} else {
				helper.pre_insert(compositeAction);
				new CRUDHandler().executeInsert(getPT_IL_PV_MED_HDR_BEAN(),
						CommonUtils.getConnection());
				getWarningMap().put(
						"current",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$save"));
				String message = Messages.getString("messageProperties",
						"errorPanel$message$save");
			}
			CommonUtils.getConnection().commit();

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public String backButton() {
		return "PILP080";
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void setProcessDt(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		try {
			PT_IL_PV_MED_HDR_BEAN.setPMH_PROCESS_DT(new CommonUtils().getCurrentDate());
		COMP_PMH_PROCESS_DT.resetValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("process_dt", e.getMessage());
		}
	}
	
	
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {

				helper.executeQuery(compositeAction);
				helper.POST_QUERY(compositeAction);

				setBlockFlag(false);
			}
			helper.preform();
			helper.When_New_Record_Instance(compositeAction);

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public ArrayList<LovBean> prepareSuggestionList_CLINIC_CODE(Object object)  {

		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		Object[] values = null;
		String currentValue = (String) object;

		// String subQry="SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE
		// PS_TYPE='LOV_CUST' AND PS_CODE = ?";
		String mainQry =

		" SELECT CUST_CODE, CUST_NAME, CUST_BL_NAME FROM PM_CUSTOMER "
				+ " WHERE CUST_CLASS IN (  SELECT CCLAS_CODE FROM PM_CUST_CLASS, "
				+ " PP_SYSTEM  WHERE DECODE (PS_VALUE,2,CCLAS_CODE,CCLAS_TYPE) IN (#) "
				+ " AND PS_CODE = ? AND PS_TYPE ='LOV_CUST') AND CUST_FRZ_FLAG = 'N' "
				+ " AND ((CUST_CODE IN (SELECT CDIV_CUST_CODE FROM  PM_CUST_DIVN WHERE "
				+ " CDIV_DIVN_CODE = NVL (?, CDIV_DIVN_CODE)AND CUST_APPL_ALL_BRAN_YN = 'N')) "
				+ " OR (CUST_APPL_ALL_BRAN_YN = 'Y')) AND (CUST_CODE LIKE ?  OR CUST_NAME LIKE ? OR CUST_BL_NAME LIKE ? ) "
				+ " AND ROWNUM < 20 ORDER BY 1 ";

		System.out.println(mainQry);
		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

			mainQry = prepareCustomerQuery(mainQry,
					new Object[] { "HOSPITALS" });
			values = new Object[] { "HOSPITALS",
					CommonUtils.getControlBean().getM_DIVN_CODE(),
					currentValue, currentValue, currentValue };
			suggestionList = ListItemUtil
					.prepareSuggestionList(mainQry, values);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("pol_no", e.getMessage());
		}
		return suggestionList;
	}

	public String prepareCustomerQuery(String CustCodeQuery, Object[] values)  {
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
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("pol_no", e.getMessage());
			}
		}
		CustCodeQuery = CustCodeQuery.replaceFirst("#", query_input);
		return CustCodeQuery;
	}

	public void PMH_CLINIC_CODE_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		String str = null;
		try {
			getPT_IL_PV_MED_HDR_BEAN().setPMH_CLINIC_CODE((String) value);

			helper.WHEN_VALIDATE_PMH_CLINIC_CODE(compositeAction);
			getCOMP_UI_M_CLINIC_NAME().resetValue();
			getWarningMap().put("mess", str);

		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {

		}
	}

	public List<LovBean> lovpol_no(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = " SELECT POL_NO, POL_DIVN_CODE FROM PT_IL_POLICY WHERE"
					+ " ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT POL_NO ,POL_DIVN_CODE FROM PT_IL_POLICY WHERE "
					+ "(POL_NO LIKE ?) AND ROWNUM < ? ORDER BY 1";
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("pol_no", e.getMessage());
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
				 bean.setLovName(resultSet.getString(2));
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

	public List<LovBean> lovprod_code(Object event) {
		String code = (String) event;
		List<LovBean> suggestionList = null;
		Object[] object = {};
		String query = null;
		if ("*".equals(code)) {
			object = new Object[] { PELConstants.suggetionRecordSize };
			query = " SELECT PROD_CODE, PROD_DESC  FROM PM_IL_PRODUCT WHERE"
					+ " ROWNUM < ? ORDER BY 1";
		} else {
			object = new Object[] { code + "%",
					PELConstants.suggetionRecordSize };
			query = "SELECT PROD_CODE ,PROD_DESC  FROM PM_IL_PRODUCT WHERE "
					+ "(PROD_CODE LIKE ?) AND ROWNUM < ? ORDER BY 1";
		}
		try {
			suggestionList = prepareLovList(query, object);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("PROD_CODE", e.getMessage());
		}
		return suggestionList;
	}

public void validatePMH_FM_PAID_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			PT_IL_PV_MED_HDR_BEAN.setPMH_FM_PAID_DT((Date)value);
			if(PT_IL_PV_MED_HDR_BEAN.getPMH_FM_PAID_DT().after(new CommonUtils().getCurrentDate())){
			   throw new Exception (Messages.getString(PELConstants.pelErrorMessagePath, "2181")) ;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_DATE_FM", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();
				
			}
		}
	}
	
	public void validatePMH_TO_PAID_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PT_IL_PV_MED_HDR_BEAN.setPMH_TO_PAID_DT((Date)value);
			if(PT_IL_PV_MED_HDR_BEAN.getPMH_TO_PAID_DT().after(new CommonUtils().getCurrentDate())){
				throw new Exception (Messages.getString(PELConstants.pelErrorMessagePath, "2181")) ;
			}else if (PT_IL_PV_MED_HDR_BEAN.getPMH_TO_PAID_DT().before(PT_IL_PV_MED_HDR_BEAN.getPMH_FM_PAID_DT())){
				throw new Exception ("To date should be greater than From date") ;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_DATE_TO", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();

			}
		}
	}
	

	public String M_BUT_DTLS() throws Exception {
		helper.M_BUT_DTLS(compositeAction);
		return "PILP080_PT_IL_POL_MED_EXAM_DTL";
	}

	public PT_IL_PV_MED_HDR_HELPER getHelper() {
		return helper;
	}

	public void setHelper(PT_IL_PV_MED_HDR_HELPER helper) {
		this.helper = helper;
	}
}