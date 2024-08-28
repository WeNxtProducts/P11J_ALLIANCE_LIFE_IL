package com.iii.pel.forms.PILT083;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class SRST_HDR_ACTION extends CommonAction {

	private SRST_HDR_HELPER helper;
	private SRST_HDR_DELEGATE delegate;
	private SRST_HDR SRST_HDR_BEAN;
	private PILT083_COMPOSITE_ACTION compositeAction;
	private HtmlOutputLabel COMP_SRST_DT_LABEL;
	private HtmlCalendar COMP_SRST_DT;
	private HtmlOutputLabel COMP_SRST_POL_NO_LABEL;
	private HtmlInputText COMP_SRST_POL_NO;
	private HtmlOutputLabel COMP_SRST_POL_PROD_NAME_LABEL;
	private HtmlInputText COMP_SRST_POL_PROD_NAME;
	private HtmlOutputLabel COMP_SRST_POL_CUST_CODE_LABEL;
	private HtmlInputText COMP_SRST_POL_CUST_CODE;
	private HtmlOutputLabel COMP_SRST_POL_CUST_NAME_LABEL;
	private HtmlInputText COMP_SRST_POL_CUST_NAME;
	private HtmlOutputLabel COMP_SRST_POL_CENTER_LABEL;
	private HtmlInputText COMP_SRST_POL_CENTER;
	private HtmlOutputLabel COMP_SRST_POL_REF_NO_LABEL;
	private HtmlInputText COMP_SRST_POL_REF_NO;
	private HtmlOutputLabel COMP_SRST_REQ_TYPE_LABEL;
	private HtmlSelectOneMenu COMP_SRST_REQ_TYPE;
	private List<String> SRST_REQ_TYPE_Values = new ArrayList<String>();

	private HtmlAjaxCommandButton UI_M_BUT_ADD;
	private HtmlAjaxCommandButton UI_M_BUT_DELETE;
	private HtmlAjaxCommandButton UI_M_BUT_POST;
	private HtmlDataTable datatable;
	private List<SRST_HDR> beanList = new ArrayList<SRST_HDR>();

	public HtmlDataTable getDatatable() {
		return datatable;
	}

	public void setDatatable(HtmlDataTable datatable) {
		this.datatable = datatable;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public SRST_HDR_ACTION() {
		SRST_HDR_BEAN = new SRST_HDR();
		helper = new SRST_HDR_HELPER();
		delegate = new SRST_HDR_DELEGATE();
		// SRST_REQ_TYPE_Values.add(index, element)

	}

	public void saveRecord() {
		String message = null;
		try {
			if (SRST_HDR_BEAN.getROWID() != null) {
				if (isUPDATE_ALLOWED()) {
					new CRUDHandler().executeUpdate(SRST_HDR_BEAN,
							CommonUtils.getConnection());
					getWarningMap().put(
							"current",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$update"));
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$update");
				}
			} else {
				if (isINSERT_ALLOWED()) {
					helper.PRE_INSERT(compositeAction);
					new CRUDHandler().executeInsert(SRST_HDR_BEAN,
							CommonUtils.getConnection());
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
				}
			}
			CommonUtils.getConnection().commit();

		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				if (SRST_HDR_BEAN.getROWID() != null) {
					helper.executeSelectStatement(compositeAction);
				} else {
					SRST_HDR_BEAN.setSRST_REQ_TYPE("Switching");
				}
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public String ShowDetails() {
		String outcome = null;
		try {
			if (SRST_HDR_BEAN.getSRST_REQ_TYPE() != null) {
				if ("Switching".equals(SRST_HDR_BEAN.getSRST_REQ_TYPE())) {
					return "PILT083_SWITCHING";
				} else if ("Subscription".equals(SRST_HDR_BEAN
						.getSRST_REQ_TYPE())) {
					return "PILT083_SUBSCRIPTION";
				} else if ("Redemption"
						.equals(SRST_HDR_BEAN.getSRST_REQ_TYPE())) {
					insertRedemptionDtls();
					return "PILT083_REDEMPTION";
				} else if ("Top-up".equals(SRST_HDR_BEAN.getSRST_REQ_TYPE())) {
					return "PILT083_TOPUP";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
					e.getMessage());
		}
		return outcome;
	}

	public void preClickRedemption() {

	}

	public SRST_HDR_DELEGATE getDelegate() {
		return delegate;
	}

	public void setDelegate(SRST_HDR_DELEGATE delegate) {
		this.delegate = delegate;
	}

	public SRST_HDR getSRST_HDR_BEAN() {
		return SRST_HDR_BEAN;
	}

	public void setSRST_HDR_BEAN(SRST_HDR srst_hdr_bean) {
		SRST_HDR_BEAN = srst_hdr_bean;
	}

	public SRST_HDR_HELPER getHelper() {
		return helper;
	}

	public void setHelper(SRST_HDR_HELPER helper) {
		this.helper = helper;
	}

	public List<SRST_HDR> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<SRST_HDR> beanList) {
		this.beanList = beanList;
	}

	

	private void insertRedemptionDtls() throws DBException {

		String query = "SELECT 'X' FROM SRST_REDEMPTION WHERE RDMP_HDR_SYS_ID = ?";

		String fetchFundDtls = "SELECT POFD_FUND_CODE,POFD_FUND_PERC FROM PT_IL_POL_FUND_DTL WHERE " +
									"POFD_POL_SYS_ID = (SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_NO = ?)";

		String fetchseq = "SELECT P_RDMP_SYS_ID.NEXTVAL FROM DUAL";

		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;

		con = CommonUtils.getConnection();
		Integer seq = null;
		try {

			rs1 = handler.executeSelectStatement(query, con,
					new Object[] { SRST_HDR_BEAN.getSRST_SYS_ID() });
			if (!rs1.next()) {
				rs2 = handler.executeSelectStatement(fetchFundDtls, con,new Object[]{SRST_HDR_BEAN.getSRST_POL_NO()});
				while (rs2.next()) {
					rs3 = handler.executeSelectStatement(fetchseq, con);
					if (rs3.next()) {
						seq = rs3.getInt(1);
					}
					String insertQuery = "INSERT INTO SRST_REDEMPTION (RDMP_SYS_ID,RDMP_HDR_SYS_ID,RDMP_FUND_NAME) "
							+ " VALUES (?,?,?)";
					int i = handler.executeInsertStatement(insertQuery, con,
							new Object[] { seq, SRST_HDR_BEAN.getSRST_SYS_ID(),rs2.getString(2) });
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void addRow(ActionEvent event) {
		try {
			if (isINSERT_ALLOWED()) {
				SRST_HDR_BEAN = new SRST_HDR();
				COMP_SRST_REQ_TYPE.setValue("Switching");
				resetAllComponent();
			} else {
				getErrorMap().put(
						"addRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}
			// Row highlight changes
			resetSelectedRow();
			SRST_HDR_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("addRow", exc.getMessage());
		}

	}

	// to be attached with delete button in the grid
	public void deleteRow(ActionEvent event) {
		try {
			if (isDELETE_ALLOWED()) {

				if (SRST_HDR_BEAN.getROWID() != null) {
					new CRUDHandler().executeDelete(SRST_HDR_BEAN, CommonUtils
							.getConnection());
					getWarningMap().put(
							"deleteRow",
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$delete"));
					getWarningMap().put(
							PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
							Messages.getString(
									PELConstants.pelMessagePropertiesPath,
									"errorPanel$message$delete"));
					COMP_SRST_REQ_TYPE.setValue("Switching");
					beanList.remove(SRST_HDR_BEAN);
				} else {
					COMP_SRST_REQ_TYPE.setValue("Switching");
					beanList.remove(SRST_HDR_BEAN);
				}
				if (beanList.size() > 0) {
					SRST_HDR_BEAN = getBeanList().get(0);
				} else if (getBeanList().size() == 0) {
					addRow(null);
				}
				resetAllComponent();

			} else {
				getErrorMap().put(
						"deleteRow",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
				getErrorMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$deletenotallowed"));
			}
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("deleteRow", exc.getMessage());
		}

	}

	// to be attached with post button in the grid
	public void postRecord(ActionEvent event) {

		String message = "";
		try {
			if (SRST_HDR_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				helper.PRE_INSERT(compositeAction);
				new CRUDHandler().executeInsert(SRST_HDR_BEAN, CommonUtils
						.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insert"));
				beanList.add(SRST_HDR_BEAN);
			} else if (SRST_HDR_BEAN.getROWID() != null && isUPDATE_ALLOWED()) {

				// helper.PRE_UPDATE(compositeAction);
				new CRUDHandler().executeUpdate(SRST_HDR_BEAN, CommonUtils
						.getConnection());
				getWarningMap().put(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
				getWarningMap().put(
						"postRecord",
						Messages.getString(
								PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$update"));
			}
			// Row highlight changes
			resetSelectedRow();
			SRST_HDR_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					"Record not Inserted/Updated :: " + exc.getMessage());
			getErrorMap().put("postRecord",
					"Record not Inserted/Updated :: " + exc.getMessage());
		}
	}

	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			SRST_HDR_BEAN = (SRST_HDR) datatable.getRowData();
			// helper.LOAD_FRZ_UNFRZ_LABEL(this);
			resetAllComponent();
			// Row highlight changes
			resetSelectedRow();
			SRST_HDR_BEAN.setRowSelected(true);
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}

	}

	private void resetAllComponent() {
		COMP_SRST_POL_CENTER.resetValue();
		COMP_SRST_POL_CUST_CODE.resetValue();
		COMP_SRST_POL_CUST_NAME.resetValue();
		COMP_SRST_POL_NO.resetValue();
		COMP_SRST_POL_REF_NO.resetValue();
		COMP_SRST_POL_PROD_NAME.resetValue();
		COMP_SRST_DT.resetValue();
	}

	private void resetSelectedRow() {
		Iterator<SRST_HDR> iterator = beanList.iterator();
		while (iterator.hasNext()) {
			iterator.next().setRowSelected(false);
		}

	}

	public HtmlOutputLabel getCOMP_SRST_POL_NO_LABEL() {
		return COMP_SRST_POL_NO_LABEL;
	}

	public void setCOMP_SRST_POL_NO_LABEL(HtmlOutputLabel comp_srst_pol_no_label) {
		COMP_SRST_POL_NO_LABEL = comp_srst_pol_no_label;
	}

	public HtmlInputText getCOMP_SRST_POL_NO() {
		return COMP_SRST_POL_NO;
	}

	public void setCOMP_SRST_POL_NO(HtmlInputText comp_srst_pol_no) {
		COMP_SRST_POL_NO = comp_srst_pol_no;
	}

	public HtmlOutputLabel getCOMP_SRST_POL_PROD_NAME_LABEL() {
		return COMP_SRST_POL_PROD_NAME_LABEL;
	}

	public void setCOMP_SRST_POL_PROD_NAME_LABEL(
			HtmlOutputLabel comp_srst_pol_prod_name_label) {
		COMP_SRST_POL_PROD_NAME_LABEL = comp_srst_pol_prod_name_label;
	}

	public HtmlInputText getCOMP_SRST_POL_PROD_NAME() {
		return COMP_SRST_POL_PROD_NAME;
	}

	public void setCOMP_SRST_POL_PROD_NAME(HtmlInputText comp_srst_pol_prod_name) {
		COMP_SRST_POL_PROD_NAME = comp_srst_pol_prod_name;
	}

	public HtmlOutputLabel getCOMP_SRST_POL_CUST_CODE_LABEL() {
		return COMP_SRST_POL_CUST_CODE_LABEL;
	}

	public void setCOMP_SRST_POL_CUST_CODE_LABEL(
			HtmlOutputLabel comp_srst_pol_cust_code_label) {
		COMP_SRST_POL_CUST_CODE_LABEL = comp_srst_pol_cust_code_label;
	}

	public HtmlInputText getCOMP_SRST_POL_CUST_CODE() {
		return COMP_SRST_POL_CUST_CODE;
	}

	public void setCOMP_SRST_POL_CUST_CODE(HtmlInputText comp_srst_pol_cust_code) {
		COMP_SRST_POL_CUST_CODE = comp_srst_pol_cust_code;
	}

	public HtmlOutputLabel getCOMP_SRST_POL_CUST_NAME_LABEL() {
		return COMP_SRST_POL_CUST_NAME_LABEL;
	}

	public void setCOMP_SRST_POL_CUST_NAME_LABEL(
			HtmlOutputLabel comp_srst_pol_cust_name_label) {
		COMP_SRST_POL_CUST_NAME_LABEL = comp_srst_pol_cust_name_label;
	}

	public HtmlInputText getCOMP_SRST_POL_CUST_NAME() {
		return COMP_SRST_POL_CUST_NAME;
	}

	public void setCOMP_SRST_POL_CUST_NAME(HtmlInputText comp_srst_pol_cust_name) {
		COMP_SRST_POL_CUST_NAME = comp_srst_pol_cust_name;
	}

	public HtmlOutputLabel getCOMP_SRST_POL_CENTER_LABEL() {
		return COMP_SRST_POL_CENTER_LABEL;
	}

	public void setCOMP_SRST_POL_CENTER_LABEL(
			HtmlOutputLabel comp_srst_pol_center_label) {
		COMP_SRST_POL_CENTER_LABEL = comp_srst_pol_center_label;
	}

	public HtmlInputText getCOMP_SRST_POL_CENTER() {
		return COMP_SRST_POL_CENTER;
	}

	public void setCOMP_SRST_POL_CENTER(HtmlInputText comp_srst_pol_center) {
		COMP_SRST_POL_CENTER = comp_srst_pol_center;
	}

	public HtmlOutputLabel getCOMP_SRST_POL_REF_NO_LABEL() {
		return COMP_SRST_POL_REF_NO_LABEL;
	}

	public void setCOMP_SRST_POL_REF_NO_LABEL(
			HtmlOutputLabel comp_srst_pol_ref_no_label) {
		COMP_SRST_POL_REF_NO_LABEL = comp_srst_pol_ref_no_label;
	}

	public HtmlInputText getCOMP_SRST_POL_REF_NO() {
		return COMP_SRST_POL_REF_NO;
	}

	public void setCOMP_SRST_POL_REF_NO(HtmlInputText comp_srst_pol_ref_no) {
		COMP_SRST_POL_REF_NO = comp_srst_pol_ref_no;
	}

	public HtmlOutputLabel getCOMP_SRST_DT_LABEL() {
		return COMP_SRST_DT_LABEL;
	}

	public void setCOMP_SRST_DT_LABEL(HtmlOutputLabel comp_srst_dt_label) {
		COMP_SRST_DT_LABEL = comp_srst_dt_label;
	}

	public HtmlCalendar getCOMP_SRST_DT() {
		return COMP_SRST_DT;
	}

	public void setCOMP_SRST_DT(HtmlCalendar comp_srst_dt) {
		COMP_SRST_DT = comp_srst_dt;
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public HtmlOutputLabel getCOMP_SRST_REQ_TYPE_LABEL() {
		return COMP_SRST_REQ_TYPE_LABEL;
	}

	public void setCOMP_SRST_REQ_TYPE_LABEL(
			HtmlOutputLabel comp_srst_req_type_label) {
		COMP_SRST_REQ_TYPE_LABEL = comp_srst_req_type_label;
	}

	public HtmlSelectOneMenu getCOMP_SRST_REQ_TYPE() {
		return COMP_SRST_REQ_TYPE;
	}

	public void setCOMP_SRST_REQ_TYPE(HtmlSelectOneMenu comp_srst_req_type) {
		COMP_SRST_REQ_TYPE = comp_srst_req_type;
	}

	public PILT083_COMPOSITE_ACTION getCompositeAction() {
		return compositeAction;
	}

	public void setCompositeAction(PILT083_COMPOSITE_ACTION compositeAction) {
		this.compositeAction = compositeAction;
	}

	public void getDetails() {
		try {
			if (beanList.size() != 0) {
				SRST_HDR_BEAN = (SRST_HDR) datatable.getRowData();
			}
			resetAllComponent();
			resetSelectedRow();
			SRST_HDR_BEAN.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validateSRST_POL_NO(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			SRST_HDR_BEAN.setSRST_POL_NO((String) value);
			helper.WhenValidateSRST_POL_NO(compositeAction);
			COMP_SRST_POL_CUST_CODE.resetValue();
			COMP_SRST_POL_CUST_NAME.resetValue();
			COMP_SRST_POL_PROD_NAME.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public List<LovBean> lovPOL_NO(Object obj) {
		String value = (String) obj;
		List<LovBean> suggestionList = new ArrayList<LovBean>();

		String query = null;
		try {
			if ("*".equals(value)) {
				query = "SELECT POL_NO FROM PT_IL_POLICY WHERE ROWNUM<25";
				Object[] object = {};
				suggestionList = delegate.prepareLovList(query, object);
			} else {
				query = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_NO LIKE ? AND ROWNUM<25";
				Object[] object = { value };
				suggestionList = delegate.prepareLovList(query, object);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return suggestionList;
	}

}
