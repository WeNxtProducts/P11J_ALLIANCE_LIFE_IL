package com.iii.pel.forms.PILP014;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_FM;

	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;

	private HtmlInputText COMP_UI_M_POL_NO_TO;

	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;

	private HtmlCalendar COMP_UI_M_PROCESS_DT;

	private HtmlOutputLabel COMP_UI_M_POL_CANCEL_PROCESS_LABEL;

	private HtmlSelectOneMenu COMP_UI_M_POL_CANCEL_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO;

	private HtmlCommandButton COMP_UI_M_BUT_OK;
	
	private HtmlCommandButton COMP_UI_M_BUT_SCHD;

	private DUMMY DUMMY_BEAN;
	
	private List<SelectItem> POL_CANCEL_PROCESS = new ArrayList<SelectItem>();
	
	public DUMMY_ACTION() throws Exception{
		DUMMY_BEAN = new DUMMY();
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}

	public void setCOMP_UI_M_POL_NO_FM_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL) {
		this.COMP_UI_M_POL_NO_FM_LABEL = COMP_UI_M_POL_NO_FM_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText COMP_UI_M_POL_NO_FM) {
		this.COMP_UI_M_POL_NO_FM = COMP_UI_M_POL_NO_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}

	public void setCOMP_UI_M_POL_NO_TO_LABEL(HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL) {
		this.COMP_UI_M_POL_NO_TO_LABEL = COMP_UI_M_POL_NO_TO_LABEL;
	}

	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText COMP_UI_M_POL_NO_TO) {
		this.COMP_UI_M_POL_NO_TO = COMP_UI_M_POL_NO_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}

	public void setCOMP_UI_M_PROCESS_DT_LABEL(HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL) {
		this.COMP_UI_M_PROCESS_DT_LABEL = COMP_UI_M_PROCESS_DT_LABEL;
	}

	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar COMP_UI_M_PROCESS_DT) {
		this.COMP_UI_M_PROCESS_DT = COMP_UI_M_PROCESS_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_POL_CANCEL_PROCESS_LABEL() {
		return COMP_UI_M_POL_CANCEL_PROCESS_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_UI_M_POL_CANCEL_PROCESS() {
		return COMP_UI_M_POL_CANCEL_PROCESS;
	}

	public void setCOMP_UI_M_POL_CANCEL_PROCESS_LABEL(HtmlOutputLabel COMP_UI_M_POL_CANCEL_PROCESS_LABEL) {
		this.COMP_UI_M_POL_CANCEL_PROCESS_LABEL = COMP_UI_M_POL_CANCEL_PROCESS_LABEL;
	}

	public void setCOMP_UI_M_POL_CANCEL_PROCESS(HtmlSelectOneMenu COMP_UI_M_POL_CANCEL_PROCESS) {
		this.COMP_UI_M_POL_CANCEL_PROCESS = COMP_UI_M_POL_CANCEL_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_FM(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM) {
		this.COMP_UI_M_BUT_LOV_POL_NO_FM = COMP_UI_M_BUT_LOV_POL_NO_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_TO() {
		return COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_TO(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO) {
		this.COMP_UI_M_BUT_LOV_POL_NO_TO = COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_OK() {
		return COMP_UI_M_BUT_OK;
	}

	public void setCOMP_UI_M_BUT_OK(HtmlCommandButton COMP_UI_M_BUT_OK) {
		this.COMP_UI_M_BUT_OK = COMP_UI_M_BUT_OK;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	
	CommonUtils utility = new CommonUtils();
	CRUDHandler handler = new CRUDHandler();
	HttpSession session = null;
	FacesContext ctx= FacesContext.getCurrentInstance();
	
	//LOV for Policy 
	public  List<LovBean>  UI_M_POLICY_FM_lovAction(Object obj)throws Exception {
		
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		List lovList = new ArrayList();
		ResultSet rs = null;
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT POL_NO FROM pt_il_policy WHERE NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND ROWNUM < 25  ORDER BY 1 ";
		}else{
			String value = obj.toString().toUpperCase(); 
			query = "SELECT POL_NO FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND POL_NO LIKE('"+obj.toString().toUpperCase()+"%') AND ROWNUM < 25  ORDER BY 1";
		}
		try {
			Connection connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection);
			rs.setFetchSize(25);
			while (rs.next()) {
				LovBean bean = new LovBean();
				bean.setCode(rs.getString(1));
				suggestionList.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Policy Num Suggestion", e.getMessage());
		}
		//connection.close();
		return suggestionList;

	}
	
/*	public List<LovBean> UI_M_POLICY_FM_lovAction(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP014",
					"DUMMY", "M_POL_NO_FM", null, null, null, null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}*/
	
	public List<LovBean> UI_M_POLICY_TO_lovAction(Object obj) {
	/*	ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILP014",
					"DUMMY", "M_POL_NO_TO", null, null, null, null,
					null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;*/
		
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		List lovList = new ArrayList();
		ResultSet rs = null;
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT POL_NO FROM pt_il_policy WHERE NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND ROWNUM < 25 ORDER BY 1 ";
		}else{
			String value = obj.toString().toUpperCase(); 
			query = "SELECT POL_NO FROM PT_IL_POLICY WHERE NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND POL_NO LIKE('"+obj.toString().toUpperCase()+"%') AND ROWNUM < 25  ORDER BY 1";
		}
		try {
			Connection connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection);
			rs.setFetchSize(25);
			while (rs.next()) {
				LovBean bean = new LovBean();
				bean.setCode(rs.getString(1));
				suggestionList.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("Policy Num Suggestion", e.getMessage());
		}
		//connection.close();
		return suggestionList;
	}
	
	public List<SelectItem> getPOL_CANCEL_PROCESS() throws Exception {
		if (POL_CANCEL_PROCESS.size() == 0) {
			POL_CANCEL_PROCESS.clear();
			POL_CANCEL_PROCESS = ListItemUtil.getDropDownListValue(utility.getConnection(), "PILP014", "DUMMY",
					"DUMMY.M_POL_CANCEL_PROCESS", "YESNO");
		}
		return POL_CANCEL_PROCESS;
	}

	public void setPOL_CANCEL_PROCESS(List<SelectItem> pol_cancel_process) {
		POL_CANCEL_PROCESS = pol_cancel_process;
	}

// Calling all Triggers
	
	public void UI_M_POLICY_NO_FM_WHEN_VALIDATE(ActionEvent event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.pilp014_dummy_ui_m_policy_no_fm_when_validate_item();
		COMP_UI_M_POL_NO_FM.resetValue();
	}
	
	public void clearMap(){
		getErrorMap().clear();
		getWarningMap().clear();
	}
	public String getCurrentValue(ActionEvent event){
		String value = null;
		UIInput input = null;

		if(event != null){
			input = (UIInput) event.getComponent().getParent();
			if(input != null){
				value = (String) input.getSubmittedValue();
				System.out.println("Value in input field: "+value);
			}
		}
		return value;
	}

	
	public void setErrorMessagesInMap(ActionEvent event){
		clearMap();
		getCurrentValue(event);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validator_M_POL_NO_FM(FacesContext context, UIComponent component,
			Object value) throws ValidatorException,ParseException {
		try{
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) value);
			when_validate_item_M_POL_NO_FM();
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
	
	public void when_validate_item_M_POL_NO_FM()throws Exception{
		Object[] values = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet resultSet = null;
		String M_TEMP = null;
		ResultSet resultSet1 = null;
		String C1_Validate = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_NO = ? ";
		try {
			connection = CommonUtils.getConnection();
			new CommonUtils().SET_REP_FIRST_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FM(),"String");
			if(!DUMMY_BEAN.getUI_M_POL_NO_FM().equals(PELConstants.PROCESS_FROMVALUE) ){
				L_CHK_POL_NO(DUMMY_BEAN.getUI_M_POL_NO_FM());
			}else{
				values = new Object[]{DUMMY_BEAN.getUI_M_POL_NO_FM()};
				rs = handler.executeSelectStatement(C1_Validate, connection,values);
				if (rs.next()) {
				M_TEMP = rs.getString(1);
				} else {
				String message = Messages.getString(
						PELConstants.pelErrorMessagePath, "2411");
				}
			}
			DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_FM());
			COMP_UI_M_POL_NO_TO.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void L_CHK_POL_NO(String M_POL_NO)throws Exception{
		String C1= " SELECT 'X'" +
				" FROM   PT_IL_POLICY" +
				" WHERE  POL_NO = ?";
		String M_TEMP = null;
		ResultSet resultSet = null;
		Connection connection = null;
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{M_POL_NO};
			resultSet = handler.executeSelectStatement(C1, connection,values);
			if(resultSet.next()){
				M_TEMP = resultSet.getString(1);
			}else{
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "2411"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void actionListenerM_POL_NO_FM(ActionEvent actionEvent) 
	{
		UIInput input = (UIInput)actionEvent.getComponent().getParent();
		String inputValue = (String)input.getSubmittedValue();
		if(inputValue.isEmpty()){
			COMP_UI_M_POL_NO_FM.setSubmittedValue(PELConstants.PROCESS_FROMVALUE);
			DUMMY_BEAN.setUI_M_POL_NO_FM(PELConstants.PROCESS_FROMVALUE);
		}
		else{
			DUMMY_BEAN.setUI_M_POL_NO_FM(inputValue);
		}
		COMP_UI_M_POL_NO_FM.resetValue();
		setErrorMessagesInMap(actionEvent);
	}
	
	public void validator_M_POL_NO_TO(FacesContext context, UIComponent component,
			Object value) throws ValidatorException,ParseException {
		try{
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) value);
			when_validate_item_M_POLICY_NO_TO();
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
	
	public void when_validate_item_M_POLICY_NO_TO()throws Exception{
		ResultSet rs = null;
		String M_TEMP;
		Object[] values = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String C1_Validate = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_NO = ?";
		try {
			connection = CommonUtils.getConnection();
			new CommonUtils().SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FM(),DUMMY_BEAN.getUI_M_POL_NO_TO(),"String");
			if(!DUMMY_BEAN.getUI_M_POL_NO_TO().equals(PELConstants.PROCESS_TOVALUE)){
				L_CHK_POL_NO(DUMMY_BEAN.getUI_M_POL_NO_TO());
			}else{
				values = new Object[]{DUMMY_BEAN.getUI_M_POL_NO_TO()};
				rs = handler.executeSelectStatement(C1_Validate,connection,values);
				if (rs.next()) {
					M_TEMP = rs.getString(1);
				} else {
					String message = Messages.getString(
							PELConstants.pelErrorMessagePath, "2411");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void actionListenerM_POL_NO_TO(ActionEvent actionEvent)
	{
		HtmlInputText inputText = (HtmlInputText)actionEvent.getComponent().getParent();
		String inputTextString=(String)inputText.getSubmittedValue();
		if(inputTextString.isEmpty())
		{
			if(!PELConstants.PROCESS_FROMVALUE.equals(DUMMY_BEAN.getUI_M_POL_NO_FM()))
			{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(DUMMY_BEAN.getUI_M_POL_NO_FM());
				DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_FM());
			}else{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				DUMMY_BEAN.setUI_M_POL_NO_TO(PELConstants.PROCESS_TOVALUE);
			}
		}else{
			DUMMY_BEAN.setUI_M_POL_NO_TO(inputTextString);
		}
		setErrorMessagesInMap(actionEvent);
	}
	
	

	public void UI_M_POLICY_NO_TO_WHEN_VALIDATE(ActionEvent event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		pilp014_dummy_ui_m_policy_no_to_when_validate_item();
	}
 
	//pilp014_dummy_ui_m_but_ok_call_proc
	public void UI_M_WHEN_BUTTON_CLICK_VALIDATE() throws Exception
	{
		String message = null;
		try {
			DUMMY_HELPER helper = new DUMMY_HELPER();
			message = helper.pilp014_dummy_ui_m_but_ok_call_proc();
			getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					message);
			getWarningMap().put("UI_M_WHEN_BUTTON_CLICK_VALIDATE", message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Successfully Completed");
			getWarningMap().put("Process", "Process Successfully Completed");
		} catch (RuntimeException e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());

		}
	}
	
	
	public String UI_M_WHEN_BUTTON_PROCESS_SCHD_VALIDATE() throws Exception
	{
		return "PILP014_CTRL1";
	}
	
	Connection connection=null;
	DUMMY_HELPER helper = new DUMMY_HELPER();
	
	
	public String preForm() throws Exception{
				ArrayList<OracleParameter> list =null;
				FacesContext context=FacesContext.getCurrentInstance();
				context.getExternalContext().getSessionMap();
				session = (HttpSession)context.getExternalContext().getSession(true);
				session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
				session.setAttribute("GLOBAL.M_MODULE_NAME", "PILP014");
				return null;
			}
	
	public void onLoad(PhaseEvent event){
		try{
				if(isFormFlag()){
				preForm();
				setFormFlag(false);
			 }
				if(isBlockFlag()){
					when_new_record_instance();
					setBlockFlag(false);
				}
		}catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}

	}
	
	
	public void when_new_record_instance(){
		try {
			DUMMY_BEAN.setUI_M_PROCESS_DT(new CommonUtils().getCurrentDate());
			DUMMY_BEAN.setUI_M_POL_CANCEL_PROCESS("N");
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	// Set Second Field
	public void pilp014_dummy_ui_m_policy_no_to_when_validate_item() {

		ResultSet rs = null;
		String M_TEMP;
		CommonUtils utility = new CommonUtils();
		Object[] values = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		if (COMP_UI_M_POL_NO_TO.getSubmittedValue() == null
				|| ((String) COMP_UI_M_POL_NO_TO
						.getSubmittedValue()).trim().length() == 0) {
			if(!COMP_UI_M_POL_NO_FM.getSubmittedValue().equals(PELConstants.PROCESS_FROMVALUE)){
				COMP_UI_M_POL_NO_TO.setSubmittedValue(DUMMY_BEAN.getUI_M_POL_NO_FM());
				DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_TO());
			  // COMP_UI_M_POL_NO_TO.setSubmittedValue(null);
			}else{
				COMP_UI_M_POL_NO_TO.setSubmittedValue(PELConstants.PROCESS_TOVALUE);
				DUMMY_BEAN.setUI_M_POL_NO_TO(PELConstants.PROCESS_TOVALUE);
			}
		} else {
			String C1_Validate = "SELECT 'X' FROM   PT_IL_POLICY WHERE  POL_NO = ?";
			try {
				connection = CommonUtils.getConnection();
				values = new Object[]{DUMMY_BEAN.getUI_M_POL_NO_TO()};
				rs = handler.executeSelectStatement(C1_Validate,connection,values);
				if (rs.next()) {
					M_TEMP = rs.getString(1);
				} else {
					String message = Messages.getString(
							PELConstants.pelErrorMessagePath, "2411");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			}finally{
				try {
					CommonUtils.closeCursor(rs);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}

		}
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SCHD() {
		return COMP_UI_M_BUT_SCHD;
	}

	public void setCOMP_UI_M_BUT_SCHD(HtmlCommandButton comp_ui_m_but_schd) {
		COMP_UI_M_BUT_SCHD = comp_ui_m_but_schd;
	}
}
