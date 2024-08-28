package com.iii.pel.forms.PILP047_APAC;


import java.sql.Connection;
import java.sql.ResultSet;
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
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class DUMMY_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_UI_M_POL_NO_FM_LABEL;
	
	private HtmlInputText COMP_UI_M_POL_NO_FM;
	
	private HtmlOutputLabel COMP_UI_M_POL_NO_TO_LABEL;
	
	private HtmlInputText COMP_UI_M_POL_NO_TO;
	
	private HtmlOutputLabel COMP_UI_M_PROCESS_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_PROCESS_DT;
	
	private HtmlOutputLabel COMP_UI_M_PROCESS_TO_DT_LABEL;
	
	private HtmlCalendar COMP_UI_M_PROCESS_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FM;
	
	List<SelectItem> UI_M_PROCESS_TYPE_LIST = new ArrayList<SelectItem>(); 
	
	int ROWCOUNT;
	
	HttpSession session = null; 
	
	
	
	
	
	FacesContext ctx= FacesContext.getCurrentInstance();
	
	
	
	private DUMMY DUMMY_BEAN;

	private DUMMY_HELPER helper;
	
	CRUDHandler handler = null;
	Connection connection =  null;
	
	
	public DUMMY_ACTION() {
		try {
			DUMMY_BEAN = new DUMMY();
			helper = new DUMMY_HELPER();
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			UI_M_PROCESS_TYPE_LIST = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(),"PILP014_A","DUMMY","DUMMY.M_PROCESS_TYPE","PROSTYP");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_NO_FM(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			String curval=(String)currValue;
			curval = "*".equals(curval) ? "%" : curval + "%";
			Connection connection = CommonUtils.getConnection();
			ResultSet resultSet = null;
			LovBean bean = null;
			CRUDHandler handler = new CRUDHandler();
			Object []values = null;
			String Query = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_PLAN_CODE IN (SELECT PLAN_CODE FROM PM_IL_PLAN WHERE "
					+ "PLAN_TYPE = 'U') "
					+ "AND POL_DS_TYPE ='2' "
					+ "AND POL_STATUS IN ('A', 'E') "
					+ "AND POL_NO LIKE ? "
                    + "AND ROWNUM < 20 ORDER BY 1 ";
			values = new Object[]{ curval };
			
			resultSet = handler.executeSelectStatement(Query,connection,values);
			while(resultSet.next()){
				bean = new LovBean();
				bean.setCode(resultSet.getString(1));
				suggestionList.add(bean);
			} 
			/*suggestionList = listitemutil.P_CALL_LOV("PILP047_APAC",
					"DUMMY", "M_POLICY_FM", "PILH039", null, null,
					null, null, (String) currValue);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_NO_TO(
			Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			String curval=(String)currValue;
			curval = "*".equals(curval) ? "%" : curval + "%";
			Connection connection = CommonUtils.getConnection();
			ResultSet resultSet = null;
			CRUDHandler handler = new CRUDHandler();
			Object []values = null;
			LovBean bean = null;
			String Query = "SELECT POL_NO FROM PT_IL_POLICY WHERE POL_PLAN_CODE IN (SELECT PLAN_CODE FROM PM_IL_PLAN WHERE "
					+ "PLAN_TYPE = 'U') "
					+ "AND POL_DS_TYPE ='2' "
					+ "AND POL_STATUS IN ('A', 'E') "
			        + "AND POL_NO LIKE ? "
                    + "AND ROWNUM < 20 ORDER BY 1 ";
			values = new Object[]{ curval };
			resultSet = handler.executeSelectStatement(Query,connection,values);
			while(resultSet.next()){
				bean = new LovBean();
				bean.setCode(resultSet.getString(1));
				suggestionList.add(bean);
			} 
			/*suggestionList = listitemutil.P_CALL_LOV("PILP047_APAC",
					"DUMMY", "M_POLICY_FM", "PILH039", null, null,
					null, null, (String) currValue);*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	/*public void listener_M_POLICY_TO(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_POLICY_TO((String) new CommonUtils()
			.SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POLICY_FM(), input
					.getSubmittedValue(), "String"));
			ErrorHelpUtil.validate(input, getErrorMap());

			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POLICY_To", e.getMessage());
		}
	}

	public void listener_M_POLICY_FM(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(input.getSubmittedValue(), "String"));
			ErrorHelpUtil.validate(input, getErrorMap());

			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POLICY_To", e.getMessage());
		}
	}*/
	
	public void WHEN_VALIDATE_DUMMY_M_POL_NO_FM(FacesContext context,UIComponent  component,Object object) {
		CommonUtils.clearMaps(this);
		try{
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) object);
			//DUMMY_BEAN.setUI_M_POL_NO_TO((String) object);
			//helper.WHEN_VALIDATE_ITEM_M_POLICY_FM((String) object,DUMMY_BEAN.getUI_M_POL_NO_TO());
			/*COMP_UI_M_POL_NO_FM.resetValue();
			COMP_UI_M_POL_NO_TO.resetValue();*/
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		}
	}
	
	public void WHEN_VALIDATE_DUMMY_M_POL_NO_TO(FacesContext context,UIComponent  component,Object object) {
		CommonUtils.clearMaps(this);
		try{
			
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) object);
			//helper.WHEN_VALIDATE_ITEM_M_POLICY_TO(DUMMY_BEAN.getUI_M_POL_NO_FM(),(String) object);
/*			COMP_UI_M_POL_NO_TO.resetValue();
*/			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e
					.getMessage()));
		}
	}
	
	

	
	public void ValidateM_POL_DT_FM(FacesContext context,
			UIComponent component, Object value) {
		try {
			DUMMY_BEAN.setUI_M_PROCESS_DT((Date) value);
			helper.WHEN_VALIDATE_ITEM_M_FM_DT(DUMMY_BEAN);
			//COMP_UI_M_PROCESS_DT.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void ValidateM_POL_DT_TO(FacesContext context,
			UIComponent component, Object value)throws Exception {
		try {
			
			DUMMY_BEAN.setUI_M_PROCESS_TO_DT((Date) value);
			helper.WHEN_VALIDATE_ITEM_M_TO_DT(DUMMY_BEAN);
			/*helper.WHEN_VALIDATE_M_POL_DT_TO(DUMMY_BEAN.getUI_M_PROCESS_DT(),
					DUMMY_BEAN.getUI_M_PROCESS_TO_DT());*/
			//COMP_UI_M_PROCESS_TO_DT.resetValue();
			}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
		

	
	public String okAction(){ 
		try{
			if(!("0".equalsIgnoreCase(DUMMY_BEAN.getUI_M_POL_NO_FM())&& "zzzzzz".equalsIgnoreCase(DUMMY_BEAN.getUI_M_POL_NO_TO())))
			{
				helper.topupCommCheck(DUMMY_BEAN);
			}
			helper.WHEN_BUTTON_PRESSED_OK(DUMMY_BEAN);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process Successfully Completed");
			getWarningMap().put("Process", "Process Successfully Completed");
		}catch(Exception e){
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("validate", e.getMessage());
			
		}
		return null;
	}
	
	public void onLoad(PhaseEvent event)  {
		try {
			if (isBlockFlag()) {
				
				setBlockFlag(false);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("validate", e.getMessage());
		}
	}




	public HtmlOutputLabel getCOMP_UI_M_POL_NO_FM_LABEL() {
		return COMP_UI_M_POL_NO_FM_LABEL;
	}




	public void setCOMP_UI_M_POL_NO_FM_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_fm_label) {
		COMP_UI_M_POL_NO_FM_LABEL = comp_ui_m_pol_no_fm_label;
	}




	public HtmlInputText getCOMP_UI_M_POL_NO_FM() {
		return COMP_UI_M_POL_NO_FM;
	}




	public void setCOMP_UI_M_POL_NO_FM(HtmlInputText comp_ui_m_pol_no_fm) {
		COMP_UI_M_POL_NO_FM = comp_ui_m_pol_no_fm;
	}




	public HtmlOutputLabel getCOMP_UI_M_POL_NO_TO_LABEL() {
		return COMP_UI_M_POL_NO_TO_LABEL;
	}




	public void setCOMP_UI_M_POL_NO_TO_LABEL(
			HtmlOutputLabel comp_ui_m_pol_no_to_label) {
		COMP_UI_M_POL_NO_TO_LABEL = comp_ui_m_pol_no_to_label;
	}




	public HtmlInputText getCOMP_UI_M_POL_NO_TO() {
		return COMP_UI_M_POL_NO_TO;
	}




	public void setCOMP_UI_M_POL_NO_TO(HtmlInputText comp_ui_m_pol_no_to) {
		COMP_UI_M_POL_NO_TO = comp_ui_m_pol_no_to;
	}




	public HtmlOutputLabel getCOMP_UI_M_PROCESS_DT_LABEL() {
		return COMP_UI_M_PROCESS_DT_LABEL;
	}




	public void setCOMP_UI_M_PROCESS_DT_LABEL(
			HtmlOutputLabel comp_ui_m_process_dt_label) {
		COMP_UI_M_PROCESS_DT_LABEL = comp_ui_m_process_dt_label;
	}




	public HtmlCalendar getCOMP_UI_M_PROCESS_DT() {
		return COMP_UI_M_PROCESS_DT;
	}




	public void setCOMP_UI_M_PROCESS_DT(HtmlCalendar comp_ui_m_process_dt) {
		COMP_UI_M_PROCESS_DT = comp_ui_m_process_dt;
	}




	public HtmlOutputLabel getCOMP_UI_M_PROCESS_TO_DT_LABEL() {
		return COMP_UI_M_PROCESS_TO_DT_LABEL;
	}




	public void setCOMP_UI_M_PROCESS_TO_DT_LABEL(
			HtmlOutputLabel comp_ui_m_process_to_dt_label) {
		COMP_UI_M_PROCESS_TO_DT_LABEL = comp_ui_m_process_to_dt_label;
	}




	public HtmlCalendar getCOMP_UI_M_PROCESS_TO_DT() {
		return COMP_UI_M_PROCESS_TO_DT;
	}




	public void setCOMP_UI_M_PROCESS_TO_DT(HtmlCalendar comp_ui_m_process_to_dt) {
		COMP_UI_M_PROCESS_TO_DT = comp_ui_m_process_to_dt;
	}




	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FM;
	}




	public void setCOMP_UI_M_BUT_LOV_POL_NO_FM(
			HtmlCommandButton comp_ui_m_but_lov_pol_no_fm) {
		COMP_UI_M_BUT_LOV_POL_NO_FM = comp_ui_m_but_lov_pol_no_fm;
	}




	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}




	public void setDUMMY_BEAN(DUMMY dummy_bean) {
		DUMMY_BEAN = dummy_bean;
	}
	
	
	public void listener_M_POLICY_FM(ActionEvent event) {
		/*UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_POL_NO_FM((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(input.getSubmittedValue(), "String"));
			ErrorHelpUtil.validate(input, getErrorMap());

			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POLICY_To", e.getMessage());
			
			
		}*/
	
		//cancelModalPanel();
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		
		if(input.getSubmittedValue()==null || "".equals(input.getSubmittedValue())){
			DUMMY_BEAN.setUI_M_POL_NO_FM(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0);
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				DUMMY_BEAN.setUI_M_POL_NO_FM(input.getValue().toString());
			}
		}
		COMP_UI_M_POL_NO_FM.resetValue();
	}

	
	public void listener_M_POLICY_TO(ActionEvent event) {
/*		UIInput input = (UIInput) event.getComponent().getParent();
		try {
			DUMMY_BEAN.setUI_M_POL_NO_TO((String) new CommonUtils()
			.SET_REP_SECOND_FIELD(DUMMY_BEAN.getUI_M_POL_NO_FM(), input
					.getSubmittedValue(), "String"));
			ErrorHelpUtil.validate(input, getErrorMap());

			input.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("M_POLICY_To", e.getMessage());
		}*/
		
		//cancelModalPanel();
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		if(input.getSubmittedValue()==null || input.getSubmittedValue().toString().isEmpty()){
			if(DUMMY_BEAN.getUI_M_POL_NO_FM()!=null){
				if(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0.equals(DUMMY_BEAN.getUI_M_POL_NO_FM())){
					DUMMY_BEAN.setUI_M_POL_NO_TO(REPORT_UTIL_CONSTANTS.SET_SECOND_FIELD_DEFAULT_ZZZZ);
				}else{
					DUMMY_BEAN.setUI_M_POL_NO_TO(DUMMY_BEAN.getUI_M_POL_NO_FM());
				}
			}
			
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				DUMMY_BEAN.setUI_M_POL_NO_TO(input.getValue().toString());
			}
		}
		COMP_UI_M_POL_NO_TO.resetValue();
	}
  
}
