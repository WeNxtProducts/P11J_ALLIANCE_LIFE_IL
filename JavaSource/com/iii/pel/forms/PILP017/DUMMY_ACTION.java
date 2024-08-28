package com.iii.pel.forms.PILP017;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlFileUpload;
import org.richfaces.component.html.HtmlInputText;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlInputText COMP_UI_M_CHEQUE_NO;
	
	private HtmlOutputLabel COMP_UI_M_CHEQUE_NO_LABEL;

	private HtmlInputText COMP_UI_M_BANK_CODE;
	
	private HtmlInputText COMP_UI_M_EMP_CODE_DESC;
	
	private HtmlOutputLabel COMP_UI_M_EMP_CODE_DESC_LABEL;
	
	private HtmlInputText COMP_UI_M_MAP_CODE_DESC;
	
	private HtmlOutputLabel COMP_UI_M_TOTAL_DEP_AMT_LABEL;
	
	private HtmlInputText COMP_UI_M_TOTAL_DEP_AMT;
	
	private HtmlOutputLabel COMP_UI_M_PROCESS_TYPE_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_PROCESS_TYPE;
	
	private HtmlOutputLabel COMP_UI_M_MAP_CODE_DESC_LABEL;
	
	private HtmlInputText COMP_UI_M_BANK_NAME;
	
	private HtmlOutputLabel COMP_UI_M_BANK_NAME_LABEL;
	
	private HtmlOutputLabel COMP_UI_M_BANK_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_CC_NAME;
	
	private HtmlOutputLabel COMP_UI_M_CC_NAME_LABEL;
	
	private HtmlInputText COMP_UI_M_CC_NO;
	
	private HtmlOutputLabel COMP_UI_M_CC_NO_LABEL;

	private HtmlCalendar COMP_UI_M_CHEQUE_DT;
	
	private HtmlOutputLabel COMP_UI_M_CHEQUE_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_CC_DATE;
	
	private HtmlOutputLabel COMP_UI_M_CC_DATE_LABEL;

	private HtmlInputText COMP_UI_M_BANK_BRANCH;
	
	private HtmlOutputLabel COMP_UI_M_BANK_BRANCH_LABEL;
	
	private HtmlInputText COMP_UI_M_POL_EMPLOYER_CODE;
	
	private HtmlOutputLabel COMP_UI_M_POL_EMPLOYER_CODE_LABEL;
	
	private HtmlInputText COMP_UI_M_MAP_CODE;
	
	private HtmlOutputLabel COMP_UI_M_MAP_CODE_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_DUE_MONTH;
	
	private HtmlOutputLabel COMP_UI_M_DUE_MONTH_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_CC_TYPE;
	
	private HtmlOutputLabel COMP_UI_M_CC_TYPE_LABEL;
	
	private HtmlInputText COMP_UI_M_DUE_YEAR;
	
	private HtmlOutputLabel COMP_UI_M_DUE_YEAR_LABEL;
	
	private HtmlCalendar COMP_UI_M_PROCESSING_DATE;
	
	private HtmlOutputLabel COMP_UI_M_PROCESSING_DATE_LABEL;
	
	private HtmlInputText COMP_UI_M_REFERENCE;
	
	private HtmlOutputLabel COMP_UI_M_REFERENCE_LABEL;
	
	private HtmlSelectOneMenu COMP_UI_M_PAY_MODE;
	
	private HtmlOutputLabel COMP_UI_M_PAY_MODE_LABEL;
	
	private HtmlCommandButton COMP_UI_M_BUT_UPLOAD;
	
	private HtmlCommandButton COMP_UI_M_BUTTON_PROCESS;
	
	private HtmlCommandButton COMP_UI_M_BUT_MAIN;
	
	private HtmlCommandButton COMP_UI_M_VIEW_LOG;
	
	private List<SelectItem> listUI_M_DUE_MONTH = new ArrayList<SelectItem>();
	
	private List<SelectItem> listUI_M_PAY_MODE = new ArrayList<SelectItem>();
	
	private List<SelectItem> listUI_M_CC_TYPE = new ArrayList<SelectItem>();
	
	private List<SelectItem> listUI_M_PROCESS_TYPE = new ArrayList<SelectItem>();
	
	private List<SelectItem> listUI_M_COMM_YN =  new ArrayList<SelectItem>();

	
	public List<SelectItem> getListUI_M_COMM_YN() {
		return listUI_M_COMM_YN;
	}

	public void setListUI_M_COMM_YN(List<SelectItem> listUI_M_COMM_YN) {
		this.listUI_M_COMM_YN = listUI_M_COMM_YN;
	}


	private DUMMY DUMMY_BEAN;

	public PILP017_COMPOSITE_ACTION compositeAction;

	private DUMMY_HELPER helper;

	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		helper = new DUMMY_HELPER();
		setListItemValues();
		instantiateAllComponent();
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	
	public void setListItemValues() {
		Connection connection = null;
		try {
			connection = CommonUtils.getConnection();

			setListUI_M_DUE_MONTH(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_DUE_MONTH", "MONTHS"));
			
			setListUI_M_CC_TYPE(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_CC_TYPE", "IL_CC_TYPE"));
			
			setListUI_M_PAY_MODE(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_PAY_MODE", "IL_PAY_MODE"));
			setListUI_M_PROCESS_TYPE(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_PROCESS_TYPE", "IL_CHECK_OFF"));
			
			/*Added by saritha on 12-10-2017 for Deposit Commission*/
			setListUI_M_COMM_YN(ListItemUtil.getDropDownListValue(
					connection, "PILP017", "DUMMY",
					"DUMMY.M_COMM_YN", "YESNO"));
			
			/*End*/
 
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	public void saveRecord() {
		//String message = null;
		CommonUtils.clearMaps(this);
		/*try {
			if (DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE() != null) {
				if (isUPDATE_ALLOWED()) {
					new CRUDHandler().executeUpdate(DUMMY_BEAN,
							CommonUtils.getConnection());
					// dummy_action.keycommitButtonAction();
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
					new CRUDHandler().executeInsert(DUMMY_BEAN,
							CommonUtils.getConnection());
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
				}
			}
			CommonUtils.getConnection().commit();*/
			/*getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("SAVE_RECORD", message);*/
		
		/*added by raja on 01-03-2017 foe direct debit */
		
		COMP_UI_M_BUT_UPLOAD.setDisabled(false);
		
		/*end*/
		
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save"));
		/*} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}*/
	}
	
	 public void validateM_POL_EMPLOYER_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_POL_EMPLOYER_CODE((String) value);
			helper.WHEN_VALIDATE_M_POL_EMPLOYER_CODE(DUMMY_BEAN);
			COMP_UI_M_EMP_CODE_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_POL_EMPLOYER_CODE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	 /*Newly added by Dhiensh on 1/11/2017 for Premium due Download/Upload issues */
	
	/*public void validateM_POL_EMPLOYER_CODE(ActionEvent actionEvent)
			throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput uiInput = (UIInput) actionEvent.getComponent().getParent();
		Object value = uiInput.getSubmittedValue();
		try {
			DUMMY_BEAN.setUI_M_POL_EMPLOYER_CODE((String) value);
			helper.WHEN_VALIDATE_M_POL_EMPLOYER_CODE(DUMMY_BEAN);
			COMP_UI_M_EMP_CODE_DESC.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_POL_EMPLOYER_CODE",
						getWarningMap());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}*/
	
	/*End*/
	
	public void validateM_MAP_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_MAP_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_M_MAP_CODE(DUMMY_BEAN);
			System.out.println(DUMMY_BEAN.getUI_M_PAY_MODE());
			COMP_UI_M_PAY_MODE.resetValue();
			System.out.println(DUMMY_BEAN.getUI_M_PAY_MODE());
			
			/*Added by Janani on 24.07.2018 for FLA dynamic upload issues,as suggested by Chandramohan*/
			CommonUtils.setGlobalObject("UI_M_MAP_CODE", DUMMY_BEAN.getUI_M_MAP_CODE());
			
			System.out.println("global obj UI_M_MAP_CODE                   "+CommonUtils.getGlobalObject("UI_M_MAP_CODE"));
			/*End*/
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_MAP_CODE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validateM_DUE_MONTH(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_DUE_MONTH((String) value);
			helper.WHEN_VALIDATE_ITEM_M_DUE_MONTH(DUMMY_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_DUE_MONTH",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validateM_DUE_YEAR(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_DUE_YEAR((Integer) value);
			helper.WHEN_VALIDATE_ITEM_M_DUE_YEAR(DUMMY_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_DUE_YEAR",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validateM_PROCESSING_DATE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_PROCESSING_DATE((Date) value);
			//helper.WHEN_VALIDATE_M_PROCESSING_DATE(DUMMY_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_PROCESSING_DATE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void validateM_CHEQUE_DT(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_CHEQUE_DT((Date) value);
			if(DUMMY_BEAN.getUI_M_CHEQUE_DT().after(DUMMY_BEAN.getUI_M_PROCESSING_DATE())){
				throw new Exception("Cheque date should be with in processing date");
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_PROCESSING_DATE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void validateM_REFERENCE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_REFERENCE((String) value);
			helper.WHEN_VALIDATE_M_REFERENCE(DUMMY_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_REFERENCE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void validateM_PAY_MODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_PAY_MODE((String) value);
			helper.WHEN_VALIDATE_ITEM_M_PAY_MODE(DUMMY_BEAN, compositeAction);
			COMP_UI_M_PROCESS_TYPE.resetValue();
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_PAY_MODE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void listenerM_PAY_CODE(ActionEvent actionEvent) {
		try {
			helper.WHEN_LISTENER_M_PAY_MODE(DUMMY_BEAN);
			UIInput input = (UIInput) actionEvent.getComponent().getParent();
			ErrorHelpUtil.validate(input, getErrorMap());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void validateM_BANK_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			DUMMY_BEAN.setUI_M_BANK_CODE((String) value);
			helper.WHEN_VALIDATE_ITEM_M_BANK_CODE(DUMMY_BEAN);
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_BANK_CODE",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*Modified by ganesh on 31-05-2017, ZBILQC-1724500 */
	/*public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_EMPLOYER_CODE(
			Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//P_CALL_LOV('DUMMY.M_POL_EMPLOYER_CODE');
			suggestionList = listitemutil.P_CALL_LOV("PILP017",
					"DUMMY", "M_POL_EMPLOYER_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	public List<LovBean> lovPOL_EMPLOYER_CODE(Object obj) {
		List<LovBean> suggestionList = null;
		try {
		String empBankCode = (String) obj;		
		ListItemUtil listitemutil = new ListItemUtil();
		Object[] object = {};
		String query = null;
		if ("*".equals(empBankCode)) {
			object = new Object[] { PELConstants.suggetionRecordSize,PELConstants.suggetionRecordSize };
			query = PILP017_QUERYCONSTANTS.POL_EMPLOYER_CODE_LOV;
		} else {
			object = new Object[] { empBankCode + "%", empBankCode + "%",
					PELConstants.suggetionRecordSize, empBankCode + "%", empBankCode + "%",
					PELConstants.suggetionRecordSize };
			query = PILP017_QUERYCONSTANTS.POL_EMPLOYER_CODE_LOV_LIKE;
		}
		
			suggestionList = listitemutil.prepareSuggestionList(query, object);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suggestionList;
	}
	/*end*/
	
	/*Modified by ganesh on 01-06-2017, suggested by Gaurav */
	/*public ArrayList<com.iii.premia.common.bean.LovBean> lovM_MAP_CODE(
			Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//P_CALL_LOV('DUMMY.M_MAP_CODE');
				change parameter by raja on 06-03-2017 for ZBILQC-1719694 
			suggestionList = listitemutil.P_CALL_LOV("PILP017",
					"DUMMY", "M_MAP_CODE", DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE(), null, null,
					null, null, (String) currValue);
			end
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	public ArrayList<LovBean> lovM_MAP_CODE(Object object) {
		ArrayList<LovBean> lovList = new ArrayList<LovBean>();
		/*added by raja on 27-06-2017 for ZBILQC-1729595*/
		/*String query ="SELECT DUM_MAP_CODE, DUM_MAP_CODE_DESC, DUM_MAP_CODE_DESC FROM PM_IL_DATA_UPLOAD_MAPPING WHERE DUM_EMPLOYER_CODE = ? AND (UPPER(DUM_MAP_CODE) LIKE UPPER(?) OR UPPER(DUM_MAP_CODE_DESC) LIKE UPPER(?) OR UPPER(DUM_MAP_CODE_DESC) LIKE UPPER(?)) AND UPPER(DUM_MAP_CODE_DESC) NOT LIKE ('%DOWNLOAD%') AND ROWNUM < ? ORDER BY 1";*/
		/*end*/
		String query ="SELECT DUM_MAP_CODE,DUM_MAP_CODE_DESC FROM PM_IL_DATA_UPLOAD_MAPPING WHERE DUM_EMPLOYER_CODE=? AND DUM_EMPLOYER_TYPE = 'U' AND (UPPER(DUM_MAP_CODE) LIKE UPPER(?) OR UPPER(DUM_MAP_CODE_DESC) LIKE UPPER(?) )  AND ROWNUM < ? ORDER BY 1";
		/*end*/
		Object[] values = null;
		String currentValue = (String) object;

		try {
			currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";
			/*Modified by ganesh on 31-05-2017,ZBILQC-1724500 */
			/*values = new Object[] { currentValue, currentValue,
					PELConstants.suggetionRecordSize };*/
			values = new Object[] { DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE(), currentValue, currentValue,
					PELConstants.suggetionRecordSize };
			/*end*/
			lovList = ListItemUtil.prepareSuggestionList(query, values);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("SUGGETION", e.getMessage());
		}
		return lovList;
	}
	
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovM_BANK_CODE(
			Object currValue) {

		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			//P_CALL_LOV('DUMMY.M_BANK_CODE');
			suggestionList = listitemutil.P_CALL_LOV("PILP017",
					"DUMMY", "M_BANK_CODE", null, null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public String processButtonAction(){
		return "PILP017_DUMMY";
	}
	
	public String viewLog(){
		
		return "PILP017_PT_IL_CHECK_OFF_TRANS_DTL";
		
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				helper.WHEN_NEW_BLOCK_INSTANCE(DUMMY_BEAN);
				helper.WHEN_CREATE_RECORD(DUMMY_BEAN);
				/*added by raja on 01-03-2017 foe direct debit */
				COMP_UI_M_BUT_UPLOAD.setDisabled(true);
				/*end*/
				
				/*Added by saritha on 25-10-2017 for Premium Collection Issues*/ 
				if (("S".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE()))){
					
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_COMM_YN().setDisabled(false);
				}
				
				else {
					
					compositeAction.getDUMMY_ACTION_BEAN().getCOMP_UI_M_COMM_YN().setDisabled(true);
					DUMMY_BEAN.setUI_M_COMM_YN("N");
					COMP_UI_M_COMM_YN.resetValue();
					
				}
				
				/*End*/
				
			}
			setBlockFlag(false);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}

	public HtmlInputText getCOMP_UI_M_CHEQUE_NO() {
		return COMP_UI_M_CHEQUE_NO;
	}

	public void setCOMP_UI_M_CHEQUE_NO(HtmlInputText comp_ui_m_cheque_no) {
		COMP_UI_M_CHEQUE_NO = comp_ui_m_cheque_no;
	}

	public HtmlInputText getCOMP_UI_M_BANK_CODE() {
		return COMP_UI_M_BANK_CODE;
	}

	public void setCOMP_UI_M_BANK_CODE(HtmlInputText comp_ui_m_bank_code) {
		COMP_UI_M_BANK_CODE = comp_ui_m_bank_code;
	}

	public HtmlCalendar getCOMP_UI_M_CHEQUE_DT() {
		return COMP_UI_M_CHEQUE_DT;
	}

	public void setCOMP_UI_M_CHEQUE_DT(HtmlCalendar comp_ui_m_cheque_dt) {
		COMP_UI_M_CHEQUE_DT = comp_ui_m_cheque_dt;
	}

	public HtmlInputText getCOMP_UI_M_BANK_BRANCH() {
		return COMP_UI_M_BANK_BRANCH;
	}

	public void setCOMP_UI_M_BANK_BRANCH(HtmlInputText comp_ui_m_bank_branch) {
		COMP_UI_M_BANK_BRANCH = comp_ui_m_bank_branch;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHEQUE_NO_LABEL() {
		return COMP_UI_M_CHEQUE_NO_LABEL;
	}

	public void setCOMP_UI_M_CHEQUE_NO_LABEL(
			HtmlOutputLabel comp_ui_m_cheque_no_label) {
		COMP_UI_M_CHEQUE_NO_LABEL = comp_ui_m_cheque_no_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_CODE_LABEL() {
		return COMP_UI_M_BANK_CODE_LABEL;
	}

	public void setCOMP_UI_M_BANK_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_bank_code_label) {
		COMP_UI_M_BANK_CODE_LABEL = comp_ui_m_bank_code_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_CHEQUE_DT_LABEL() {
		return COMP_UI_M_CHEQUE_DT_LABEL;
	}

	public void setCOMP_UI_M_CHEQUE_DT_LABEL(
			HtmlOutputLabel comp_ui_m_cheque_dt_label) {
		COMP_UI_M_CHEQUE_DT_LABEL = comp_ui_m_cheque_dt_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_BRANCH_LABEL() {
		return COMP_UI_M_BANK_BRANCH_LABEL;
	}

	public void setCOMP_UI_M_BANK_BRANCH_LABEL(
			HtmlOutputLabel comp_ui_m_bank_branch_label) {
		COMP_UI_M_BANK_BRANCH_LABEL = comp_ui_m_bank_branch_label;
	}

	public HtmlInputText getCOMP_UI_M_POL_EMPLOYER_CODE() {
		return COMP_UI_M_POL_EMPLOYER_CODE;
	}

	public void setCOMP_UI_M_POL_EMPLOYER_CODE(
			HtmlInputText comp_ui_m_pol_employer_code) {
		COMP_UI_M_POL_EMPLOYER_CODE = comp_ui_m_pol_employer_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_EMPLOYER_CODE_LABEL() {
		return COMP_UI_M_POL_EMPLOYER_CODE_LABEL;
	}

	public void setCOMP_UI_M_POL_EMPLOYER_CODE_LABEL(
			HtmlOutputLabel comp_ui_m_pol_employer_code_label) {
		COMP_UI_M_POL_EMPLOYER_CODE_LABEL = comp_ui_m_pol_employer_code_label;
	}

	public HtmlInputText getCOMP_UI_M_MAP_CODE() {
		return COMP_UI_M_MAP_CODE;
	}

	public void setCOMP_UI_M_MAP_CODE(HtmlInputText comp_ui_m_map_code) {
		COMP_UI_M_MAP_CODE = comp_ui_m_map_code;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAP_CODE_LABEL() {
		return COMP_UI_M_MAP_CODE_LABEL;
	}

	public void setCOMP_UI_M_MAP_CODE_LABEL(HtmlOutputLabel comp_ui_m_map_code_label) {
		COMP_UI_M_MAP_CODE_LABEL = comp_ui_m_map_code_label;
	}
 
	public HtmlSelectOneMenu getCOMP_UI_M_DUE_MONTH() {
		return COMP_UI_M_DUE_MONTH;
	}

	public void setCOMP_UI_M_DUE_MONTH(HtmlSelectOneMenu comp_ui_m_due_month) {
		COMP_UI_M_DUE_MONTH = comp_ui_m_due_month;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUE_MONTH_LABEL() {
		return COMP_UI_M_DUE_MONTH_LABEL;
	}

	public void setCOMP_UI_M_DUE_MONTH_LABEL(
			HtmlOutputLabel comp_ui_m_due_month_label) {
		COMP_UI_M_DUE_MONTH_LABEL = comp_ui_m_due_month_label;
	}

	public HtmlInputText getCOMP_UI_M_DUE_YEAR() {
		return COMP_UI_M_DUE_YEAR;
	}

	public void setCOMP_UI_M_DUE_YEAR(HtmlInputText comp_ui_m_due_year) {
		COMP_UI_M_DUE_YEAR = comp_ui_m_due_year;
	}

	public HtmlOutputLabel getCOMP_UI_M_DUE_YEAR_LABEL() {
		return COMP_UI_M_DUE_YEAR_LABEL;
	}

	public void setCOMP_UI_M_DUE_YEAR_LABEL(HtmlOutputLabel comp_ui_m_due_year_label) {
		COMP_UI_M_DUE_YEAR_LABEL = comp_ui_m_due_year_label;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESSING_DATE_LABEL() {
		return COMP_UI_M_PROCESSING_DATE_LABEL;
	}

	public void setCOMP_UI_M_PROCESSING_DATE_LABEL(
			HtmlOutputLabel comp_ui_m_processing_date_label) {
		COMP_UI_M_PROCESSING_DATE_LABEL = comp_ui_m_processing_date_label;
	}

	public HtmlInputText getCOMP_UI_M_REFERENCE() {
		return COMP_UI_M_REFERENCE;
	}

	public void setCOMP_UI_M_REFERENCE(HtmlInputText comp_ui_m_reference) {
		COMP_UI_M_REFERENCE = comp_ui_m_reference;
	}

	public HtmlOutputLabel getCOMP_UI_M_REFERENCE_LABEL() {
		return COMP_UI_M_REFERENCE_LABEL;
	}

	public void setCOMP_UI_M_REFERENCE_LABEL(
			HtmlOutputLabel comp_ui_m_reference_label) {
		COMP_UI_M_REFERENCE_LABEL = comp_ui_m_reference_label;
	}

	 
	public HtmlOutputLabel getCOMP_UI_M_PAY_MODE_LABEL() {
		return COMP_UI_M_PAY_MODE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PAY_MODE() {
		return COMP_UI_M_PAY_MODE;
	}

	public void setCOMP_UI_M_PAY_MODE(HtmlSelectOneMenu comp_ui_m_pay_mode) {
		COMP_UI_M_PAY_MODE = comp_ui_m_pay_mode;
	}

	public void setCOMP_UI_M_PAY_MODE_LABEL(HtmlOutputLabel comp_ui_m_pay_mode_label) {
		COMP_UI_M_PAY_MODE_LABEL = comp_ui_m_pay_mode_label;
	}


	public List<SelectItem> getListUI_M_DUE_MONTH() {
		if (listUI_M_DUE_MONTH.size() == 0) {
			listUI_M_DUE_MONTH.clear();
			try {
				listUI_M_DUE_MONTH = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listUI_M_DUE_MONTH;
	}

	public void setListUI_M_DUE_MONTH(List<SelectItem> listUI_M_DUE_MONTH) {
		this.listUI_M_DUE_MONTH = listUI_M_DUE_MONTH;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_CC_TYPE() {
		return COMP_UI_M_CC_TYPE;
	}

	public void setCOMP_UI_M_CC_TYPE(HtmlSelectOneMenu comp_ui_m_cc_type) {
		COMP_UI_M_CC_TYPE = comp_ui_m_cc_type;
	}

	public HtmlOutputLabel getCOMP_UI_M_CC_TYPE_LABEL() {
		return COMP_UI_M_CC_TYPE_LABEL;
	}

	public void setCOMP_UI_M_CC_TYPE_LABEL(HtmlOutputLabel comp_ui_m_cc_type_label) {
		COMP_UI_M_CC_TYPE_LABEL = comp_ui_m_cc_type_label;
	}

	public List<SelectItem> getListUI_M_CC_TYPE() {
		if (listUI_M_CC_TYPE.size() == 0) {
			listUI_M_CC_TYPE.clear();
			try {
				listUI_M_CC_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listUI_M_CC_TYPE;
	}
	
	public String processButtonActionMethod(){
		String message = null;
		String P_ERROR_YN = null;
		
		/*Added by Janani on 17.01.2018 for Premium upload performance issue,as per Gaurav's sugges.*/
		
		/*String query = "SELECT 'X' FROM PW_IL_CHECK_OFF_ERROR_LOG, PW_IL_UPLOAD_DATA WHERE UPPER(COER_REASON) NOT LIKE '%SUCCESS%' "+
				" AND COER_REF_NO = UD_REFF_NO ";*/
				
		
		String query =	"SELECT 'X' FROM PW_IL_CHECK_OFF_ERROR_LOG, PW_IL_UPLOAD_DATA WHERE COER_TYPE NOT IN ('1', '10') AND COER_REF_NO = UD_REFF_NO";
		
		
		ResultSet rs = null;
		Connection con = null;
		
		/*End*/
		
		try {
			chkContDepAmount();
			/*Added by Shankar on 13/04/2017*/
			/*
			 * Commented by sankara narayanan on 20/04/2017
			 * if("AD".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE())||"S".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE()))*/
			/*Modified by saritha on 25-10-2017 for Premium Collection Issues*/
			PR_SCO_PROCESS(P_ERROR_YN, CommonUtils.dateToStringFormatter(DUMMY_BEAN.getUI_M_PROCESSING_DATE()),
						DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE(), 
						"123456",DUMMY_BEAN.getUI_M_PAY_MODE(),DUMMY_BEAN.getUI_M_COMM_YN());
			/*End*/
			helper.WHEN_BUTTON_PRESSED_M_BUT_PROCESS(DUMMY_BEAN);
			
			/*Added by Janani on 17.01.2018 for Premium upload performance issue,as per Gaurav's sugges.*/
			
			 con = CommonUtils.getConnection();

			 rs = new CRUDHandler().executeSelectStatement(query, con);
			 if(rs.next()){
				 System.out.println("result available");
				 
				 message = "Process Completed Successfully, Please check Premium Allocation Logs.";
				
			 }else
			 {
			
			/*End*/	 
				 message = "Process Completed Successfully";
			 }
			
			
			
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("Process", message);
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Process", e.getMessage());
		}
		return message;
	}
	

	/**
	 * Instantiates all components in DUMMY_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlSelectOneMenu
		COMP_UI_M_DUE_MONTH				 = new HtmlSelectOneMenu();
		COMP_UI_M_CC_TYPE				 = new HtmlSelectOneMenu();
		COMP_UI_M_PAY_MODE  			 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_UI_M_CHEQUE_DT				 = new HtmlCalendar();
		COMP_UI_M_CC_DATE				 = new HtmlCalendar();
		COMP_UI_M_PROCESSING_DATE			 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_UPLOAD				 = new HtmlCommandButton();
		
		COMP_UI_M_EMP_CODE_DESC = new HtmlInputText();
		
		COMP_UI_M_CHEQUE_NO = new HtmlInputText();
		COMP_UI_M_BANK_CODE = new HtmlInputText();
		COMP_UI_M_BANK_BRANCH = new HtmlInputText();
		
		COMP_UI_FILE_BUT_UPLOAD= new HtmlFileUpload();
		
		/*Added by saritha on 25-10-2017 for Premium Collection Issues*/
		COMP_UI_M_COMM_YN_LABEL = new HtmlOutputLabel();
		COMP_UI_M_COMM_YN       = new HtmlSelectOneMenu();
		/*End*/
		
	}
	
	public  String mainButtonAction() {
		return "PILP017_DUMMY";
		
	}
	
	public String uploadButtonAction(){
		/*Added by ganesh on 27-12-2017 for performance issue */
		CommonUtils.setGlobalVariable("ONLOAD_UPD", "Y");
		return "PILP017_PW_IL_UPLOAD_FILE_DTLS";
	}

	public void setListUI_M_CC_TYPE(List<SelectItem> listUI_M_CC_TYPE) {
		this.listUI_M_CC_TYPE = listUI_M_CC_TYPE;
	}

	public HtmlInputText getCOMP_UI_M_CC_NAME() {
		return COMP_UI_M_CC_NAME;
	}

	public void setCOMP_UI_M_CC_NAME(HtmlInputText comp_ui_m_cc_name) {
		COMP_UI_M_CC_NAME = comp_ui_m_cc_name;
	}

	public HtmlOutputLabel getCOMP_UI_M_CC_NAME_LABEL() {
		return COMP_UI_M_CC_NAME_LABEL;
	}

	public void setCOMP_UI_M_CC_NAME_LABEL(HtmlOutputLabel comp_ui_m_cc_name_label) {
		COMP_UI_M_CC_NAME_LABEL = comp_ui_m_cc_name_label;
	}

	public HtmlInputText getCOMP_UI_M_CC_NO() {
		return COMP_UI_M_CC_NO;
	}

	public void setCOMP_UI_M_CC_NO(HtmlInputText comp_ui_m_cc_no) {
		COMP_UI_M_CC_NO = comp_ui_m_cc_no;
	}

	public HtmlOutputLabel getCOMP_UI_M_CC_NO_LABEL() {
		return COMP_UI_M_CC_NO_LABEL;
	}

	public void setCOMP_UI_M_CC_NO_LABEL(HtmlOutputLabel comp_ui_m_cc_no_label) {
		COMP_UI_M_CC_NO_LABEL = comp_ui_m_cc_no_label;
	}

	public HtmlCalendar getCOMP_UI_M_CC_DATE() {
		return COMP_UI_M_CC_DATE;
	}

	public void setCOMP_UI_M_CC_DATE(HtmlCalendar comp_ui_m_cc_date) {
		COMP_UI_M_CC_DATE = comp_ui_m_cc_date;
	}

	public HtmlOutputLabel getCOMP_UI_M_CC_DATE_LABEL() {
		return COMP_UI_M_CC_DATE_LABEL;
	}

	public void setCOMP_UI_M_CC_DATE_LABEL(HtmlOutputLabel comp_ui_m_cc_date_label) {
		COMP_UI_M_CC_DATE_LABEL = comp_ui_m_cc_date_label;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESSING_DATE() {
		return COMP_UI_M_PROCESSING_DATE;
	}

	public void setCOMP_UI_M_PROCESSING_DATE(HtmlCalendar comp_ui_m_processing_date) {
		COMP_UI_M_PROCESSING_DATE = comp_ui_m_processing_date;
	}

	public HtmlInputText getCOMP_UI_M_EMP_CODE_DESC() {
		return COMP_UI_M_EMP_CODE_DESC;
	}

	public void setCOMP_UI_M_EMP_CODE_DESC(HtmlInputText comp_ui_m_emp_code_desc) {
		COMP_UI_M_EMP_CODE_DESC = comp_ui_m_emp_code_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_EMP_CODE_DESC_LABEL() {
		return COMP_UI_M_EMP_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_EMP_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_emp_code_desc_label) {
		COMP_UI_M_EMP_CODE_DESC_LABEL = comp_ui_m_emp_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_MAP_CODE_DESC() {
		return COMP_UI_M_MAP_CODE_DESC;
	}

	public void setCOMP_UI_M_MAP_CODE_DESC(HtmlInputText comp_ui_m_map_code_desc) {
		COMP_UI_M_MAP_CODE_DESC = comp_ui_m_map_code_desc;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAP_CODE_DESC_LABEL() {
		return COMP_UI_M_MAP_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_MAP_CODE_DESC_LABEL(
			HtmlOutputLabel comp_ui_m_map_code_desc_label) {
		COMP_UI_M_MAP_CODE_DESC_LABEL = comp_ui_m_map_code_desc_label;
	}

	public HtmlInputText getCOMP_UI_M_BANK_NAME() {
		return COMP_UI_M_BANK_NAME;
	}

	public void setCOMP_UI_M_BANK_NAME(HtmlInputText comp_ui_m_bank_name) {
		COMP_UI_M_BANK_NAME = comp_ui_m_bank_name;
	}

	public HtmlOutputLabel getCOMP_UI_M_BANK_NAME_LABEL() {
		return COMP_UI_M_BANK_NAME_LABEL;
	}

	public void setCOMP_UI_M_BANK_NAME_LABEL(
			HtmlOutputLabel comp_ui_m_bank_name_label) {
		COMP_UI_M_BANK_NAME_LABEL = comp_ui_m_bank_name_label;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTTON_PROCESS() {
		return COMP_UI_M_BUTTON_PROCESS;
	}

	public void setCOMP_UI_M_BUTTON_PROCESS(
			HtmlCommandButton comp_ui_m_button_process) {
		COMP_UI_M_BUTTON_PROCESS = comp_ui_m_button_process;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_UPLOAD() {
		return COMP_UI_M_BUT_UPLOAD;
	}

	public void setCOMP_UI_M_BUT_UPLOAD(HtmlCommandButton comp_ui_m_but_upload) {
		COMP_UI_M_BUT_UPLOAD = comp_ui_m_but_upload;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton comp_ui_m_but_main) {
		COMP_UI_M_BUT_MAIN = comp_ui_m_but_main;
	}

	public List<SelectItem> getListUI_M_PAY_MODE() {
		if (listUI_M_PAY_MODE.size() == 0) {
			listUI_M_PAY_MODE.clear();
			try {
				listUI_M_PAY_MODE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listUI_M_PAY_MODE;
	}

	public void setListUI_M_PAY_MODE(List<SelectItem> listUI_M_PAY_MODE) {
		this.listUI_M_PAY_MODE = listUI_M_PAY_MODE;
	}

	public List<SelectItem> getListUI_M_PROCESS_TYPE() {
		if (listUI_M_PROCESS_TYPE.size() == 0) {
			listUI_M_PROCESS_TYPE.clear();
			try {
				listUI_M_PROCESS_TYPE = new ArrayList<SelectItem>();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return listUI_M_PROCESS_TYPE;
	}

	public void setListUI_M_PROCESS_TYPE(List<SelectItem> listUI_M_PROCESS_TYPE) {
		this.listUI_M_PROCESS_TYPE = listUI_M_PROCESS_TYPE;
	}

	public HtmlOutputLabel getCOMP_UI_M_TOTAL_DEP_AMT_LABEL() {
		return COMP_UI_M_TOTAL_DEP_AMT_LABEL;
	}

	public void setCOMP_UI_M_TOTAL_DEP_AMT_LABEL(
			HtmlOutputLabel comp_ui_m_total_dep_amt_label) {
		COMP_UI_M_TOTAL_DEP_AMT_LABEL = comp_ui_m_total_dep_amt_label;
	}

	public HtmlInputText getCOMP_UI_M_TOTAL_DEP_AMT() {
		return COMP_UI_M_TOTAL_DEP_AMT;
	}

	public void setCOMP_UI_M_TOTAL_DEP_AMT(HtmlInputText comp_ui_m_total_dep_amt) {
		COMP_UI_M_TOTAL_DEP_AMT = comp_ui_m_total_dep_amt;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_TYPE_LABEL() {
		return COMP_UI_M_PROCESS_TYPE_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_TYPE_LABEL(
			HtmlOutputLabel comp_ui_m_process_type_label) {
		COMP_UI_M_PROCESS_TYPE_LABEL = comp_ui_m_process_type_label;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_PROCESS_TYPE() {
		return COMP_UI_M_PROCESS_TYPE;
	}

	public void setCOMP_UI_M_PROCESS_TYPE(HtmlSelectOneMenu comp_ui_m_process_type) {
		COMP_UI_M_PROCESS_TYPE = comp_ui_m_process_type;
	}

	public HtmlCommandButton getCOMP_UI_M_VIEW_LOG() {
		return COMP_UI_M_VIEW_LOG;
	}

	public void setCOMP_UI_M_VIEW_LOG(HtmlCommandButton comp_ui_m_view_log) {
		COMP_UI_M_VIEW_LOG = comp_ui_m_view_log;
	}
	
	//method added by akash to check whether the Employer have sufficient balance or not.......
	public void chkContDepAmount() throws Exception{
		Connection connection = null;
		ResultSet resultSet = null , resultSet2 = null;
		Double uploadAmt = null;
		Double contAmount = null;
		Double commRate = null;
		CRUDHandler handler = new CRUDHandler();
		
		/*Modified by Janani on 24.07.2018 for FLA dynamic upload issues,as suggested by Chandramohan*/ 
		//String C1 = "SELECT SUM(UD_FLEX_04) FROM PW_IL_UPLOAD_DATA";
		String C1 = "SELECT SUM(UD_FLEX_07) FROM PW_IL_UPLOAD_DATA";
		/*End*/
		
		/*Modified by ganesh on 02-04-2018 as suggested by girish and siva */
		/*String C2 = "SELECT NVL (CONT_LC_POL_DEP_AMT, 0) - NVL (CONT_LC_POL_UTIL_AMT, 0) " +
				     " FROM   PM_IL_CONTRACTOR WHERE  CONT_CODE = ? AND CONT_EMPLOYER_YN = 'Y'";*/
		String C2 = "SELECT NVL (CONT_LC_POL_DEP_AMT, 0) - NVL (CONT_LC_POL_UTIL_AMT, 0),CUST_COMM_RATE" +
			     " FROM   PM_IL_CONTRACTOR,PM_CUSTOMER WHERE  CUST_CODE = CONT_CODE AND CONT_CODE = ? AND CONT_EMPLOYER_YN = 'Y'"; 
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection);
			if(resultSet.next()){
				uploadAmt = resultSet.getDouble(1);
			}
			CommonUtils.closeCursor(resultSet);
			resultSet2 = handler.executeSelectStatement(C2, connection, 
					new Object[]{DUMMY_BEAN.getUI_M_POL_EMPLOYER_CODE()});
			if(resultSet2.next()){
				contAmount = resultSet2.getDouble(1);
				commRate = resultSet2.getDouble(2);
			}
			CommonUtils.closeCursor(resultSet2);
			/*Modified by ganesh on 01-06-2017, suggested by Gaurav to added BS(Bankstanding instruction) in condition*/
			/*if(!"AD".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE())){
			if(uploadAmt > contAmount ){
				throw new Exception("Employer don't have the sufficient balance.!");
			}
			}*/
			System.out.println("UploadAmt-->["+uploadAmt.doubleValue()+"]<-->ContractorAmount["+contAmount+"]");
			System.out.println("EnteredAmt-->["+DUMMY_BEAN.getUI_M_TOTAL_DEP_AMT().doubleValue()+"] Commision->"+DUMMY_BEAN.getUI_M_COMM_YN());
			//Added commision deductible condition by ganesh on 29-03-2018 as suggested by girish*/
			/*if("S".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE()) && "N".equalsIgnoreCase(DUMMY_BEAN.getUI_M_COMM_YN())){
				if(uploadAmt > contAmount ){
					throw new Exception("Employer don't have the sufficient balance.!");
				}
				}*/
			
			if("S".equalsIgnoreCase(DUMMY_BEAN.getUI_M_PAY_MODE())){
				
				if("Y".equalsIgnoreCase(DUMMY_BEAN.getUI_M_COMM_YN())){
					
					contAmount += (uploadAmt*commRate)/100;
					contAmount = Double.valueOf(CommonUtils.Decimal_Convert(String.valueOf(contAmount)));
				}
				
			System.out.println("Inside Stop order UploadAmt-->["+uploadAmt.doubleValue()+"]<-->ContractorAmount["+contAmount+"]");	
				
				if(uploadAmt > contAmount ){
					throw new Exception("Employer don't have the sufficient balance.!");
				}
				}
			/*end*/
			if(uploadAmt.doubleValue()!=DUMMY_BEAN.getUI_M_TOTAL_DEP_AMT().doubleValue()){
				throw new Exception("Total deposit amount does not tally");
			}
			
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally{
			try{CommonUtils.closeCursor(resultSet);}catch (Exception e) {}
			try{CommonUtils.closeCursor(resultSet2);}catch (Exception e) {}
		}
		
		
	}
	
	
	
	
	
	
	/*Added by Shankar on 13/04/2017*/
	
	public ArrayList<OracleParameter> PR_SCO_PROCESS(
			Object P_ERROR_YN,
			Object P_PROC_DT,
			Object P_EMPLOYER_CODE, 
			Object P_PS_REF_NO,
			Object P_PAY_MODE,
			Object P_COMM_FLAG) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("OUT1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.OUT, P_ERROR_YN);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PROC_DT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_EMPLOYER_CODE);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PS_REF_NO);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_PAY_MODE);
			parameterList.add(param5);
			OracleParameter param6 = new OracleParameter("IN6",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, P_COMM_FLAG);
			parameterList.add(param6);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_SALARY_CHKOFF.PR_SCO_PROCESS");
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	
	
	
private HtmlFileUpload COMP_UI_FILE_BUT_UPLOAD;
	
	public HtmlFileUpload getCOMP_UI_FILE_BUT_UPLOAD() {
		return COMP_UI_FILE_BUT_UPLOAD;
	}

	public void setCOMP_UI_FILE_BUT_UPLOAD(HtmlFileUpload cOMP_UI_FILE_BUT_UPLOAD) {
		COMP_UI_FILE_BUT_UPLOAD = cOMP_UI_FILE_BUT_UPLOAD;
	}	
	/*End*/
	
	/*Added by saritha on 25-10-2017 for Premium Collection Issues*/
	private HtmlOutputLabel COMP_UI_M_COMM_YN_LABEL;
	private HtmlSelectOneMenu COMP_UI_M_COMM_YN;

	public HtmlOutputLabel getCOMP_UI_M_COMM_YN_LABEL() {
		return COMP_UI_M_COMM_YN_LABEL;
	}

	public void setCOMP_UI_M_COMM_YN_LABEL(HtmlOutputLabel cOMP_UI_M_COMM_YN_LABEL) {
		COMP_UI_M_COMM_YN_LABEL = cOMP_UI_M_COMM_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_COMM_YN() {
		return COMP_UI_M_COMM_YN;
	}

	public void setCOMP_UI_M_COMM_YN(HtmlSelectOneMenu cOMP_UI_M_COMM_YN) {
		COMP_UI_M_COMM_YN = cOMP_UI_M_COMM_YN;
	}

	
	public void validateUI_M_COMM_YN(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {

			DUMMY_BEAN.setUI_M_COMM_YN((String) value);
			
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "M_COMM_YN",
						getWarningMap());

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/*End*/
	

}
