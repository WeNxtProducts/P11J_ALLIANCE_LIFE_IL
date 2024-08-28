package com.iii.pel.forms.PM104_A_TISB;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM043.PM_IL_RI_POOL_SETUP;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_WITH_DRAWL_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_AWDS_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_AWDS_TYPE;

	private HtmlOutputLabel COMP_AWDS_JOIN_AGE_FM_LABEL;

	private HtmlInputText COMP_AWDS_JOIN_AGE_FM;

	private HtmlOutputLabel COMP_AWDS_JOIN_AGE_TO_LABEL;

	private HtmlInputText COMP_AWDS_JOIN_AGE_TO;

	private HtmlOutputLabel COMP_AWDS_CURR_AGE_FM_LABEL;

	private HtmlInputText COMP_AWDS_CURR_AGE_FM;

	private HtmlOutputLabel COMP_AWDS_CURR_AGE_TO_LABEL;

	private HtmlInputText COMP_AWDS_CURR_AGE_TO;

	private HtmlOutputLabel COMP_AWDS_NO_YRS_EXP_FM_LABEL;

	private HtmlInputText COMP_AWDS_NO_YRS_EXP_FM;

	private HtmlOutputLabel COMP_AWDS_NO_YRS_EXP_TO_LABEL;

	private HtmlInputText COMP_AWDS_NO_YRS_EXP_TO;

	private HtmlOutputLabel COMP_AWDS_PAY_RATE_LABEL;

	private HtmlInputText COMP_AWDS_PAY_RATE;

	private HtmlOutputLabel COMP_AWDS_PAY_RATE_PER_LABEL;

	private HtmlInputText COMP_AWDS_PAY_RATE_PER;

	private HtmlOutputLabel COMP_AWDS_PAY_SHARE_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_AWDS_PAY_SHARE_TYPE;

	private HtmlOutputLabel COMP_AWDS_LC_FUND_BAL_LABEL;

	private HtmlInputText COMP_AWDS_LC_FUND_BAL;

	/*
	 * The following are declared are not auto created and is declared for
	 * specific operations of this form and some variables to help trigger
	 * functionality
	 */

	PM_AGENT_WITH_DRAWL_SETUP PM_AGENT_WITH_DRAWL_SETUP_BEAN;
	PM_AGENT_WITH_DRAWL_SETUP_ACTION_HELPER helper ;

	private UIData dataTable;

	// Tis variable is used to set the rowid in the bean for delete operation
	private int rowIndex;

	CRUDHandler handler = new CRUDHandler();

	HttpSession session = null;

	private String errMsg;

	private List<SelectItem> listAWDS_PAY_SHARE_TYPE = new ArrayList<SelectItem>();

	private List<SelectItem> listAWDS_TYPE = new ArrayList<SelectItem>();

	private ArrayList<Object> fetchList = new ArrayList<Object>();

	/*
	 * This Boolean is declared for validation checks it is set to true if
	 * validation errors found
	 */

	String validation_Result = "";

	private boolean validate_Error = false;

	CommonUtils utils = new CommonUtils();

	public PM_AGENT_WITH_DRAWL_SETUP_ACTION() {
		PM_AGENT_WITH_DRAWL_SETUP_BEAN = new PM_AGENT_WITH_DRAWL_SETUP();
		helper = new PM_AGENT_WITH_DRAWL_SETUP_ACTION_HELPER();
		prepareDropDowns();
		PRE_FORM_PM104_A_TISB();
		getWarningMap().clear();
		getErrorMap().clear();
	}

	private void prepareDropDowns() {
		try {
			setListAWDS_TYPE(ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), "PM104_A_APAC",
					"PM_AGENT_WITH_DRAWL_SETUP",
					"PM_AGENT_WITH_DRAWL_SETUP.AWDS_TYPE", "APFCLMTYP"));
			setListAWDS_PAY_SHARE_TYPE(ListItemUtil.getDropDownListValue(
					CommonUtils.getConnection(), "PM104_A_APAC",
					"PM_AGENT_WITH_DRAWL_SETUP",
					"PM_AGENT_WITH_DRAWL_SETUP.AWDS_PAY_SHARE_TYPE",
					"PAY_SHR_TYPE"));

		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isFormFlag()) {
				PRE_FORM_PM104_A_TISB();
				setFormFlag(false);
			}
			if (isBlockFlag()) {
				fetch(PM_AGENT_WITH_DRAWL_SETUP_BEAN);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlOutputLabel getCOMP_AWDS_TYPE_LABEL() {
		return COMP_AWDS_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_AWDS_TYPE() {
		return COMP_AWDS_TYPE;
	}

	public void setCOMP_AWDS_TYPE_LABEL(HtmlOutputLabel COMP_AWDS_TYPE_LABEL) {
		this.COMP_AWDS_TYPE_LABEL = COMP_AWDS_TYPE_LABEL;
	}

	public void setCOMP_AWDS_TYPE(HtmlSelectOneMenu COMP_AWDS_TYPE) {
		this.COMP_AWDS_TYPE = COMP_AWDS_TYPE;
	}

	public HtmlOutputLabel getCOMP_AWDS_JOIN_AGE_FM_LABEL() {
		return COMP_AWDS_JOIN_AGE_FM_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_JOIN_AGE_FM() {
		return COMP_AWDS_JOIN_AGE_FM;
	}

	public void setCOMP_AWDS_JOIN_AGE_FM_LABEL(
			HtmlOutputLabel COMP_AWDS_JOIN_AGE_FM_LABEL) {
		this.COMP_AWDS_JOIN_AGE_FM_LABEL = COMP_AWDS_JOIN_AGE_FM_LABEL;
	}

	public void setCOMP_AWDS_JOIN_AGE_FM(HtmlInputText COMP_AWDS_JOIN_AGE_FM) {
		this.COMP_AWDS_JOIN_AGE_FM = COMP_AWDS_JOIN_AGE_FM;
	}

	public HtmlOutputLabel getCOMP_AWDS_JOIN_AGE_TO_LABEL() {
		return COMP_AWDS_JOIN_AGE_TO_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_JOIN_AGE_TO() {
		return COMP_AWDS_JOIN_AGE_TO;
	}

	public void setCOMP_AWDS_JOIN_AGE_TO_LABEL(
			HtmlOutputLabel COMP_AWDS_JOIN_AGE_TO_LABEL) {
		this.COMP_AWDS_JOIN_AGE_TO_LABEL = COMP_AWDS_JOIN_AGE_TO_LABEL;
	}

	public void setCOMP_AWDS_JOIN_AGE_TO(HtmlInputText COMP_AWDS_JOIN_AGE_TO) {
		this.COMP_AWDS_JOIN_AGE_TO = COMP_AWDS_JOIN_AGE_TO;
	}

	public HtmlOutputLabel getCOMP_AWDS_CURR_AGE_FM_LABEL() {
		return COMP_AWDS_CURR_AGE_FM_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_CURR_AGE_FM() {
		return COMP_AWDS_CURR_AGE_FM;
	}

	public void setCOMP_AWDS_CURR_AGE_FM_LABEL(
			HtmlOutputLabel COMP_AWDS_CURR_AGE_FM_LABEL) {
		this.COMP_AWDS_CURR_AGE_FM_LABEL = COMP_AWDS_CURR_AGE_FM_LABEL;
	}

	public void setCOMP_AWDS_CURR_AGE_FM(HtmlInputText COMP_AWDS_CURR_AGE_FM) {
		this.COMP_AWDS_CURR_AGE_FM = COMP_AWDS_CURR_AGE_FM;
	}

	public HtmlOutputLabel getCOMP_AWDS_CURR_AGE_TO_LABEL() {
		return COMP_AWDS_CURR_AGE_TO_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_CURR_AGE_TO() {
		return COMP_AWDS_CURR_AGE_TO;
	}

	public void setCOMP_AWDS_CURR_AGE_TO_LABEL(
			HtmlOutputLabel COMP_AWDS_CURR_AGE_TO_LABEL) {
		this.COMP_AWDS_CURR_AGE_TO_LABEL = COMP_AWDS_CURR_AGE_TO_LABEL;
	}

	public void setCOMP_AWDS_CURR_AGE_TO(HtmlInputText COMP_AWDS_CURR_AGE_TO) {
		this.COMP_AWDS_CURR_AGE_TO = COMP_AWDS_CURR_AGE_TO;
	}

	public HtmlOutputLabel getCOMP_AWDS_NO_YRS_EXP_FM_LABEL() {
		return COMP_AWDS_NO_YRS_EXP_FM_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_NO_YRS_EXP_FM() {
		return COMP_AWDS_NO_YRS_EXP_FM;
	}

	public void setCOMP_AWDS_NO_YRS_EXP_FM_LABEL(
			HtmlOutputLabel COMP_AWDS_NO_YRS_EXP_FM_LABEL) {
		this.COMP_AWDS_NO_YRS_EXP_FM_LABEL = COMP_AWDS_NO_YRS_EXP_FM_LABEL;
	}

	public void setCOMP_AWDS_NO_YRS_EXP_FM(HtmlInputText COMP_AWDS_NO_YRS_EXP_FM) {
		this.COMP_AWDS_NO_YRS_EXP_FM = COMP_AWDS_NO_YRS_EXP_FM;
	}

	public HtmlOutputLabel getCOMP_AWDS_NO_YRS_EXP_TO_LABEL() {
		return COMP_AWDS_NO_YRS_EXP_TO_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_NO_YRS_EXP_TO() {
		return COMP_AWDS_NO_YRS_EXP_TO;
	}

	public void setCOMP_AWDS_NO_YRS_EXP_TO_LABEL(
			HtmlOutputLabel COMP_AWDS_NO_YRS_EXP_TO_LABEL) {
		this.COMP_AWDS_NO_YRS_EXP_TO_LABEL = COMP_AWDS_NO_YRS_EXP_TO_LABEL;
	}

	public void setCOMP_AWDS_NO_YRS_EXP_TO(HtmlInputText COMP_AWDS_NO_YRS_EXP_TO) {
		this.COMP_AWDS_NO_YRS_EXP_TO = COMP_AWDS_NO_YRS_EXP_TO;
	}

	public HtmlOutputLabel getCOMP_AWDS_PAY_RATE_LABEL() {
		return COMP_AWDS_PAY_RATE_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_PAY_RATE() {
		return COMP_AWDS_PAY_RATE;
	}

	public void setCOMP_AWDS_PAY_RATE_LABEL(
			HtmlOutputLabel COMP_AWDS_PAY_RATE_LABEL) {
		this.COMP_AWDS_PAY_RATE_LABEL = COMP_AWDS_PAY_RATE_LABEL;
	}

	public void setCOMP_AWDS_PAY_RATE(HtmlInputText COMP_AWDS_PAY_RATE) {
		this.COMP_AWDS_PAY_RATE = COMP_AWDS_PAY_RATE;
	}

	public HtmlOutputLabel getCOMP_AWDS_PAY_RATE_PER_LABEL() {
		return COMP_AWDS_PAY_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_PAY_RATE_PER() {
		return COMP_AWDS_PAY_RATE_PER;
	}

	public void setCOMP_AWDS_PAY_RATE_PER_LABEL(
			HtmlOutputLabel COMP_AWDS_PAY_RATE_PER_LABEL) {
		this.COMP_AWDS_PAY_RATE_PER_LABEL = COMP_AWDS_PAY_RATE_PER_LABEL;
	}

	public void setCOMP_AWDS_PAY_RATE_PER(HtmlInputText COMP_AWDS_PAY_RATE_PER) {
		this.COMP_AWDS_PAY_RATE_PER = COMP_AWDS_PAY_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_AWDS_PAY_SHARE_TYPE_LABEL() {
		return COMP_AWDS_PAY_SHARE_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_AWDS_PAY_SHARE_TYPE() {
		return COMP_AWDS_PAY_SHARE_TYPE;
	}

	public void setCOMP_AWDS_PAY_SHARE_TYPE_LABEL(
			HtmlOutputLabel COMP_AWDS_PAY_SHARE_TYPE_LABEL) {
		this.COMP_AWDS_PAY_SHARE_TYPE_LABEL = COMP_AWDS_PAY_SHARE_TYPE_LABEL;
	}

	public void setCOMP_AWDS_PAY_SHARE_TYPE(
			HtmlSelectOneMenu COMP_AWDS_PAY_SHARE_TYPE) {
		this.COMP_AWDS_PAY_SHARE_TYPE = COMP_AWDS_PAY_SHARE_TYPE;
	}

	public HtmlOutputLabel getCOMP_AWDS_LC_FUND_BAL_LABEL() {
		return COMP_AWDS_LC_FUND_BAL_LABEL;
	}

	public HtmlInputText getCOMP_AWDS_LC_FUND_BAL() {
		return COMP_AWDS_LC_FUND_BAL;
	}

	public void setCOMP_AWDS_LC_FUND_BAL_LABEL(
			HtmlOutputLabel COMP_AWDS_LC_FUND_BAL_LABEL) {
		this.COMP_AWDS_LC_FUND_BAL_LABEL = COMP_AWDS_LC_FUND_BAL_LABEL;
	}

	public void setCOMP_AWDS_LC_FUND_BAL(HtmlInputText COMP_AWDS_LC_FUND_BAL) {
		this.COMP_AWDS_LC_FUND_BAL = COMP_AWDS_LC_FUND_BAL;
	}

	public PM_AGENT_WITH_DRAWL_SETUP getPM_AGENT_WITH_DRAWL_SETUP_BEAN() {
		return PM_AGENT_WITH_DRAWL_SETUP_BEAN;
	}

	public void setPM_AGENT_WITH_DRAWL_SETUP_BEAN(
			PM_AGENT_WITH_DRAWL_SETUP PM_AGENT_WITH_DRAWL_SETUP_BEAN) {
		this.PM_AGENT_WITH_DRAWL_SETUP_BEAN = PM_AGENT_WITH_DRAWL_SETUP_BEAN;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	List<SelectItem> POPULATE_AWDS_TYPE = new ArrayList<SelectItem>();

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	ArrayList<String> POPULATE_AWDS_SHARE_TYPE = new ArrayList<String>();

	/*
	 * The CRUD Handler operations here Save method takes care of both insert
	 * and update operations and the data is committed Fetch method fetches the
	 * last record from the database
	 */

	public String Save() throws Exception {
		CRUDHandler handler = new CRUDHandler();
		int rowUpdated = 0;
		try {

			if (!validate_Error) {
				if (PM_AGENT_WITH_DRAWL_SETUP_BEAN.getROWID() == null) {
					pm104_a_tisb_pm_agent_with_drawl_setup_pre_insert();
					PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_CR_UID(CommonUtils
							.getControlBean().getM_USER_ID());
					pm104_a_tisb_pm_agent_with_drawl_setup_when_create_record();
					rowUpdated = handler.executeInsert(
							PM_AGENT_WITH_DRAWL_SETUP_BEAN, CommonUtils
									.getConnection());
					CommonUtils.getConnection().commit();
					if (rowUpdated > 0) {
						getWarningMap().put(
								"current",
								Messages.getString("messageProperties",
										"errorPanel$message$save"));
						getWarningMap().put(
								"SAVE",
								Messages.getString("messageProperties",
								"errorPanel$message$save"));
					}

				} else if (PM_AGENT_WITH_DRAWL_SETUP_BEAN.getROWID() != null) {
					PM_AGENT_WITH_DRAWL_SETUP_BEAN
							.setAWDS_UPD_DT(new CommonUtils().getCurrentDate());
					PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_UPD_UID(CommonUtils
							.getControlBean().getM_USER_ID());

					rowUpdated = handler.executeUpdate(
							PM_AGENT_WITH_DRAWL_SETUP_BEAN, CommonUtils
									.getConnection());
					CommonUtils.getConnection().commit();
					if (rowUpdated > 0) {
						getWarningMap().put(
								"current",
								Messages.getString("messageProperties",
										"errorPanel$message$update"));
						getWarningMap().put(
								"UPDATE",
								Messages.getString("messageProperties",
								"errorPanel$message$update"));
					}
				}
			} else {
				validate_Error = true;
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "80001");
				System.out.println("Validation Errors!!!!");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public void fetch(PM_AGENT_WITH_DRAWL_SETUP agentWithDrawlSetupBean) {
		ResultSet result = null;
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = "Select ROWID,PM_AGENT_WITH_DRAWL_SETUP.* from PM_AGENT_WITH_DRAWL_SETUP WHERE ROWID = ?";
		
		try {
			result = handler.executeSelectStatement(selectQuery, CommonUtils
					.getConnection(), new Object[]{agentWithDrawlSetupBean.getROWID()});
			if (result.next()) {

				agentWithDrawlSetupBean.setROWID(result
						.getString("ROWID"));
				agentWithDrawlSetupBean
						.setAWDS_TYPE(result.getString(1));
				agentWithDrawlSetupBean.setAWDS_JOIN_AGE_FM(result
						.getInt((2)));
				agentWithDrawlSetupBean.setAWDS_JOIN_AGE_TO(result
						.getInt(3));
				agentWithDrawlSetupBean.setAWDS_CURR_AGE_FM(result
						.getInt(4));
				agentWithDrawlSetupBean.setAWDS_CURR_AGE_TO(result
						.getInt(5));
				agentWithDrawlSetupBean.setAWDS_NO_YRS_EXP_FM(result
						.getInt(6));
				agentWithDrawlSetupBean.setAWDS_NO_YRS_EXP_TO(result
						.getInt(7));
				agentWithDrawlSetupBean.setAWDS_PAY_RATE(result
						.getDouble(8));
				agentWithDrawlSetupBean.setAWDS_PAY_RATE_PER(result
						.getInt(9));
				agentWithDrawlSetupBean.setAWDS_PAY_SHARE_TYPE(result
						.getString(10));
				agentWithDrawlSetupBean.setAWDS_LC_FUND_BAL(result
						.getDouble("AWDS_LC_FUND_BAL"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

	}

	public String Delete() throws Exception {
	
		try {
			CommonUtils.clearMaps(this);
			new CRUDHandler().executeDelete(PM_AGENT_WITH_DRAWL_SETUP_BEAN, CommonUtils.getConnection());
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			getWarningMap().put("DELETE",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			CommonUtils.getConnection().commit();
			PM_AGENT_WITH_DRAWL_SETUP_BEAN = new PM_AGENT_WITH_DRAWL_SETUP();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();					
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
		}
		return "";
	}
	public ArrayList<Object> getFetchList() {
		return fetchList;
	}

	public void setFetchList(ArrayList<Object> fetchList) {
		this.fetchList = fetchList;
	}

	public UIData getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}
	// Ajax Validations Start Here
	String AWDS_CURR_AGE_FM_HELPER_AJAX;
	String AWDS_CURR_AGE_TO_HELPER_AJAX;
	String AWDS_JOIN_AGE_FM_HELPER_AJAX;
	String AWDS_JOIN_AGE_TO_HELPER_AJAX;
	String AWDS_NO_YRS_EXP_FM_HELPER_AJAX;
	String AWDS_NO_YRS_EXP_TO_HELPER_AJAX;
	String AWDS_LC_FUND_BAL_HELPER_AJAX;
	String AWDS_PAY_RATE_PER_HELPER_AJAX;
	Double AWDS_PAY_RATE_HELPER_AJAX;

	FacesContext test;

	public void fireFieldValidation(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void JOIN_AGE_FM_WHEN_VALIDATE_ITEM(FacesContext fc,
			UIComponent component, Object value) throws ValidatorException,
			SQLException, Exception {
		
		try {
			if (value != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN
						.setAWDS_JOIN_AGE_FM((Integer) value);
				helper
						.pm104_a_tisb_pm_agent_with_drawl_setup_awds_join_age_fm_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN
								.getAWDS_JOIN_AGE_FM());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), fc, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void JOIN_AGE_TO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object value) throws ValidatorException,
			Exception {
		try {
			if (value != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN
						.setAWDS_JOIN_AGE_TO((Integer) value);
				helper
						.pm104_a_tisb_pm_agent_with_drawl_setup_awds_join_age_to_when_validate_item(
								PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_JOIN_AGE_FM(),PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_JOIN_AGE_TO());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CURR_AGE_FM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object object) throws Exception {
		try {
			if (object != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_CURR_AGE_FM((Integer)object);
				helper.pm104_a_tisb_pm_agent_with_drawl_setup_awds_curr_age_fm_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_CURR_AGE_FM());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void CURR_AGE_TO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object object) throws ValidatorException,
			Exception {
		try {
			PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_CURR_AGE_TO((Integer)object);
			if (object != null) {
				helper.pm104_a_tisb_pm_agent_with_drawl_setup_awds_curr_age_to_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_CURR_AGE_FM(),PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_CURR_AGE_TO());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void NO_YRS_EXP_FM_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object object) throws Exception {
		try {
			if (object != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_NO_YRS_EXP_FM((Integer)object);
				helper.pm104_a_tisb_pm_agent_with_drawl_setup_awds_no_yrs_exp_fm_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_NO_YRS_EXP_FM());
			}

		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void validateAWDS_PAY_RATE(FacesContext context,
			UIComponent component, Object object) throws ValidatorException,
			Exception {
		try {
			if (object != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_PAY_RATE((Double)object);
				helper.pm104_a_tisb_pm_agent_with_drawl_setup_AWDS_PAY_RATE_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_PAY_RATE());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAWDS_PAY_RATE_PER(FacesContext context,
			UIComponent component, Object object) throws ValidatorException,
			Exception {
		try {
			if (object != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_PAY_RATE_PER((Integer)object);
				helper.pm104_a_tisb_pm_agent_with_drawl_setup_AWDS_PAY_RATE_PER_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_PAY_RATE_PER());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateAWDS_LC_FUND_BAL(FacesContext context,
			UIComponent component, Object object) throws ValidatorException,
			Exception {
		try {
			if (object != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_LC_FUND_BAL((Double)object);
				helper.pm104_a_tisb_pm_agent_with_drawl_setup_AWDS_LC_FUND_BAL_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_LC_FUND_BAL());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void NO_YRS_EXP_TO_WHEN_VALIDATE_ITEM(FacesContext context,
			UIComponent component, Object object) throws ValidatorException,
			Exception {
		try {
			if (object != null) {
				PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_NO_YRS_EXP_TO((Integer)object);
				helper.pm104_a_tisb_pm_agent_with_drawl_setup_awds_no_yrs_exp_to_when_validate_item(PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_NO_YRS_EXP_FM(),PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_NO_YRS_EXP_TO());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void PRE_FORM_PM104_A_TISB() {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap();
		session = (HttpSession) context.getExternalContext().getSession(true);

		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
	}

	public void pm104_a_tisb_pm_agent_with_drawl_setup_pre_insert()
			throws Exception {
		try {
			String sql_C1 = "SELECT 'X' FROM  PM_AGENT_WITH_DRAWL_SETUP  WHERE  (AWDS_TYPE  = '"
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_TYPE()
					// +"1')AND ((AWDS_JOIN_AGE_FM BETWEEN "
					+ "')AND ((AWDS_JOIN_AGE_FM  BETWEEN "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_JOIN_AGE_FM()
					+ "  AND "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_JOIN_AGE_TO()
					+ ") OR (AWDS_JOIN_AGE_TO BETWEEN "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_JOIN_AGE_FM()
					+ " AND "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_JOIN_AGE_TO()
					+ ")  AND (AWDS_CURR_AGE_FM  BETWEEN "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_CURR_AGE_FM()
					+ " AND "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_CURR_AGE_TO()
					+ ")  OR (AWDS_CURR_AGE_TO  BETWEEN "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_CURR_AGE_FM()
					+ " AND "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_CURR_AGE_TO()
					+ ")  AND (AWDS_NO_YRS_EXP_FM  BETWEEN "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_NO_YRS_EXP_FM()
					+ " AND "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_NO_YRS_EXP_TO()
					+ ")  OR (AWDS_NO_YRS_EXP_TO  BETWEEN "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_NO_YRS_EXP_FM()
					+ " AND "
					+ PM_AGENT_WITH_DRAWL_SETUP_BEAN.getAWDS_NO_YRS_EXP_TO()
					+ "))";
			ResultSet vembu_C1 = null;
			Statement stmt_C1 = CommonUtils.getConnection().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			String M_DUMMY_X = null;
			if (vembu_C1 != null) {
				vembu_C1.close();
			}
			vembu_C1 = stmt_C1.executeQuery(sql_C1);
			if (vembu_C1.next()) {
				M_DUMMY_X = vembu_C1.getString(1);
			}

			vembu_C1.close();
			PM_AGENT_WITH_DRAWL_SETUP_BEAN.setAWDS_CR_DT(new java.sql.Date(
					Calendar.getInstance().getTimeInMillis()));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}
	}

	public void pm104_a_tisb_pm_agent_with_drawl_setup_when_create_record()
			throws SQLException, Exception {
		// Connection connection = CommonUtils.getConnection();
		try {
			String sql_C1 = "SELECT PC_CODE FROM  PM_CODES  WHERE  PC_TYPE  = 'APFCLMTYP' ";

			ResultSet vembu_C1 = null;
			Statement stmt_C1 = CommonUtils.getConnection().createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			if (vembu_C1 != null) {
				vembu_C1.close();
			}
			vembu_C1 = stmt_C1.executeQuery(sql_C1);
			if (vembu_C1.next()) {
			}
			vembu_C1.close();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {

		}
	}

	public String STD_MESSAGE_ROUTINE(int P_LANG_CODE, String errorCode) {
		try {
			String query = "SELECT DECODE('"
					+ P_LANG_CODE
					+ "', 'ENG', EM_ENG_MSG, EM_FOR_MSG),EM_ERR_FLAG FROM PP_ERROR_MESSAGE WHERE EM_ERR_NO = '"
					+ errorCode + "'";
			ResultSet resultSet = handler.executeSelectStatement(query,
					CommonUtils.getConnection());
			while (resultSet.next()) {
				errMsg = resultSet.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return errMsg;
	}

	String PREV_ID;
	String CURR_ID;

	public String validation_Result(String PREV_ID, String CURR_ID) {
		this.PREV_ID = PREV_ID;
		this.CURR_ID = CURR_ID;

		return this.PREV_ID;
	}

	public String getValidation_Result() {
		return validation_Result;
	}

	public void setValidation_Result(String validation_Result) {
		this.validation_Result = validation_Result;
	}

	public String go_Back() {

		String actionClass = "PM104_A_TISB_PM_AGENT_WITH_DRAWL_SETUP_SEARCH_PAGE_ACTION";
		String actionMethod = "fetchButtonClick";
		String returnString = "Go_To_Search";
		CommonUtils commonUtils = new CommonUtils();
		commonUtils.callRetaintion(actionClass, actionMethod);
		return returnString;

	}

	public List<SelectItem> getListAWDS_TYPE() {
		return listAWDS_TYPE;
	}

	public void setListAWDS_TYPE(List<SelectItem> listAWDS_TYPE) {
		this.listAWDS_TYPE = listAWDS_TYPE;
	}

	public List<SelectItem> getListAWDS_PAY_SHARE_TYPE() {
		return listAWDS_PAY_SHARE_TYPE;
	}

	public void setListAWDS_PAY_SHARE_TYPE(
			List<SelectItem> listAWDS_PAY_SHARE_TYPE) {
		this.listAWDS_PAY_SHARE_TYPE = listAWDS_PAY_SHARE_TYPE;
	}
	
	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

}
