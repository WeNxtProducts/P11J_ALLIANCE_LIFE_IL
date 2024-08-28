package com.iii.pel.forms.PILP025;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class DUMMY_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_UI_M_POLICY_FM_LABEL;

	private HtmlInputText COMP_UI_M_POLICY_FM;

	private HtmlOutputLabel COMP_UI_M_POLICY_TO_LABEL;

	private HtmlInputText COMP_UI_M_POLICY_TO;

	private HtmlOutputLabel COMP_UI_M_DIVN_FM_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_FM;

	private HtmlOutputLabel COMP_UI_M_DIVN_TO_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_TO;

	private HtmlOutputLabel COMP_UI_M_DEPT_FM_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_FM;

	private HtmlOutputLabel COMP_UI_M_DEPT_TO_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_TO;

	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlOutputLabel COMP_UI_M_CERT_PRINT_YN_LABEL;

	private HtmlSelectBooleanCheckbox COMP_UI_M_CERT_PRINT_YN;

	private HtmlOutputLabel COMP_UI_M_PROP_DRIP_YN_LABEL;

	private HtmlSelectBooleanCheckbox COMP_UI_M_PROP_DRIP_YN;

	private HtmlOutputLabel COMP_UI_M_EXE_PREMIUM_YN_LABEL;

	private HtmlSelectBooleanCheckbox COMP_UI_M_EXE_PREMIUM_YN;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_FM;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_FM;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_TO;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_TO;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private DUMMY DUMMY_BEAN;
	
	//DUMMY_HELPER helper = new DUMMY_HELPER();
	public DUMMY_ACTION() {
		DUMMY_BEAN = new DUMMY();
		PILP025_preform();
	
	}

	public HtmlOutputLabel getCOMP_UI_M_POLICY_FM_LABEL() {
		return COMP_UI_M_POLICY_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POLICY_FM() {
		return COMP_UI_M_POLICY_FM;
	}

	public void setCOMP_UI_M_POLICY_FM_LABEL(HtmlOutputLabel COMP_UI_M_POLICY_FM_LABEL) {
		this.COMP_UI_M_POLICY_FM_LABEL = COMP_UI_M_POLICY_FM_LABEL;
	}

	public void setCOMP_UI_M_POLICY_FM(HtmlInputText COMP_UI_M_POLICY_FM) {
		this.COMP_UI_M_POLICY_FM = COMP_UI_M_POLICY_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_POLICY_TO_LABEL() {
		return COMP_UI_M_POLICY_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_POLICY_TO() {
		return COMP_UI_M_POLICY_TO;
	}

	public void setCOMP_UI_M_POLICY_TO_LABEL(HtmlOutputLabel COMP_UI_M_POLICY_TO_LABEL) {
		this.COMP_UI_M_POLICY_TO_LABEL = COMP_UI_M_POLICY_TO_LABEL;
	}

	public void setCOMP_UI_M_POLICY_TO(HtmlInputText COMP_UI_M_POLICY_TO) {
		this.COMP_UI_M_POLICY_TO = COMP_UI_M_POLICY_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_FM_LABEL() {
		return COMP_UI_M_DIVN_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_FM() {
		return COMP_UI_M_DIVN_FM;
	}

	public void setCOMP_UI_M_DIVN_FM_LABEL(HtmlOutputLabel COMP_UI_M_DIVN_FM_LABEL) {
		this.COMP_UI_M_DIVN_FM_LABEL = COMP_UI_M_DIVN_FM_LABEL;
	}

	public void setCOMP_UI_M_DIVN_FM(HtmlInputText COMP_UI_M_DIVN_FM) {
		this.COMP_UI_M_DIVN_FM = COMP_UI_M_DIVN_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_TO_LABEL() {
		return COMP_UI_M_DIVN_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_TO() {
		return COMP_UI_M_DIVN_TO;
	}

	public void setCOMP_UI_M_DIVN_TO_LABEL(HtmlOutputLabel COMP_UI_M_DIVN_TO_LABEL) {
		this.COMP_UI_M_DIVN_TO_LABEL = COMP_UI_M_DIVN_TO_LABEL;
	}

	public void setCOMP_UI_M_DIVN_TO(HtmlInputText COMP_UI_M_DIVN_TO) {
		this.COMP_UI_M_DIVN_TO = COMP_UI_M_DIVN_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_FM_LABEL() {
		return COMP_UI_M_DEPT_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_FM() {
		return COMP_UI_M_DEPT_FM;
	}

	public void setCOMP_UI_M_DEPT_FM_LABEL(HtmlOutputLabel COMP_UI_M_DEPT_FM_LABEL) {
		this.COMP_UI_M_DEPT_FM_LABEL = COMP_UI_M_DEPT_FM_LABEL;
	}

	public void setCOMP_UI_M_DEPT_FM(HtmlInputText COMP_UI_M_DEPT_FM) {
		this.COMP_UI_M_DEPT_FM = COMP_UI_M_DEPT_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_TO_LABEL() {
		return COMP_UI_M_DEPT_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_TO() {
		return COMP_UI_M_DEPT_TO;
	}

	public void setCOMP_UI_M_DEPT_TO_LABEL(HtmlOutputLabel COMP_UI_M_DEPT_TO_LABEL) {
		this.COMP_UI_M_DEPT_TO_LABEL = COMP_UI_M_DEPT_TO_LABEL;
	}

	public void setCOMP_UI_M_DEPT_TO(HtmlInputText COMP_UI_M_DEPT_TO) {
		this.COMP_UI_M_DEPT_TO = COMP_UI_M_DEPT_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_DT_LABEL() {
		return COMP_UI_M_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_FM_DT() {
		return COMP_UI_M_FM_DT;
	}

	public void setCOMP_UI_M_FM_DT_LABEL(HtmlOutputLabel COMP_UI_M_FM_DT_LABEL) {
		this.COMP_UI_M_FM_DT_LABEL = COMP_UI_M_FM_DT_LABEL;
	}

	public void setCOMP_UI_M_FM_DT(HtmlCalendar COMP_UI_M_FM_DT) {
		this.COMP_UI_M_FM_DT = COMP_UI_M_FM_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_DT_LABEL() {
		return COMP_UI_M_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_UI_M_TO_DT() {
		return COMP_UI_M_TO_DT;
	}

	public void setCOMP_UI_M_TO_DT_LABEL(HtmlOutputLabel COMP_UI_M_TO_DT_LABEL) {
		this.COMP_UI_M_TO_DT_LABEL = COMP_UI_M_TO_DT_LABEL;
	}

	public void setCOMP_UI_M_TO_DT(HtmlCalendar COMP_UI_M_TO_DT) {
		this.COMP_UI_M_TO_DT = COMP_UI_M_TO_DT;
	}

	public HtmlOutputLabel getCOMP_UI_M_CERT_PRINT_YN_LABEL() {
		return COMP_UI_M_CERT_PRINT_YN_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_M_CERT_PRINT_YN() {
		return COMP_UI_M_CERT_PRINT_YN;
	}

	public void setCOMP_UI_M_CERT_PRINT_YN_LABEL(HtmlOutputLabel COMP_UI_M_CERT_PRINT_YN_LABEL) {
		this.COMP_UI_M_CERT_PRINT_YN_LABEL = COMP_UI_M_CERT_PRINT_YN_LABEL;
	}

	public void setCOMP_UI_M_CERT_PRINT_YN(HtmlSelectBooleanCheckbox COMP_UI_M_CERT_PRINT_YN) {
		this.COMP_UI_M_CERT_PRINT_YN = COMP_UI_M_CERT_PRINT_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_PROP_DRIP_YN_LABEL() {
		return COMP_UI_M_PROP_DRIP_YN_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_M_PROP_DRIP_YN() {
		return COMP_UI_M_PROP_DRIP_YN;
	}

	public void setCOMP_UI_M_PROP_DRIP_YN_LABEL(HtmlOutputLabel COMP_UI_M_PROP_DRIP_YN_LABEL) {
		this.COMP_UI_M_PROP_DRIP_YN_LABEL = COMP_UI_M_PROP_DRIP_YN_LABEL;
	}

	public void setCOMP_UI_M_PROP_DRIP_YN(HtmlSelectBooleanCheckbox COMP_UI_M_PROP_DRIP_YN) {
		this.COMP_UI_M_PROP_DRIP_YN = COMP_UI_M_PROP_DRIP_YN;
	}

	public HtmlOutputLabel getCOMP_UI_M_EXE_PREMIUM_YN_LABEL() {
		return COMP_UI_M_EXE_PREMIUM_YN_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_UI_M_EXE_PREMIUM_YN() {
		return COMP_UI_M_EXE_PREMIUM_YN;
	}

	public void setCOMP_UI_M_EXE_PREMIUM_YN_LABEL(HtmlOutputLabel COMP_UI_M_EXE_PREMIUM_YN_LABEL) {
		this.COMP_UI_M_EXE_PREMIUM_YN_LABEL = COMP_UI_M_EXE_PREMIUM_YN_LABEL;
	}

	public void setCOMP_UI_M_EXE_PREMIUM_YN(HtmlSelectBooleanCheckbox COMP_UI_M_EXE_PREMIUM_YN) {
		this.COMP_UI_M_EXE_PREMIUM_YN = COMP_UI_M_EXE_PREMIUM_YN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DIVN_FM() {
		return COMP_UI_M_BUTT_LOV_DIVN_FM;
	}

	public void setCOMP_UI_M_BUTT_LOV_DIVN_FM(HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_FM) {
		this.COMP_UI_M_BUTT_LOV_DIVN_FM = COMP_UI_M_BUTT_LOV_DIVN_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DIVN_TO() {
		return COMP_UI_M_BUTT_LOV_DIVN_TO;
	}

	public void setCOMP_UI_M_BUTT_LOV_DIVN_TO(HtmlCommandButton COMP_UI_M_BUTT_LOV_DIVN_TO) {
		this.COMP_UI_M_BUTT_LOV_DIVN_TO = COMP_UI_M_BUTT_LOV_DIVN_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_POLICY_FM() {
		return COMP_UI_M_BUTT_LOV_POLICY_FM;
	}

	public void setCOMP_UI_M_BUTT_LOV_POLICY_FM(HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_FM) {
		this.COMP_UI_M_BUTT_LOV_POLICY_FM = COMP_UI_M_BUTT_LOV_POLICY_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_POLICY_TO() {
		return COMP_UI_M_BUTT_LOV_POLICY_TO;
	}

	public void setCOMP_UI_M_BUTT_LOV_POLICY_TO(HtmlCommandButton COMP_UI_M_BUTT_LOV_POLICY_TO) {
		this.COMP_UI_M_BUTT_LOV_POLICY_TO = COMP_UI_M_BUTT_LOV_POLICY_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DEPT_FM() {
		return COMP_UI_M_BUTT_LOV_DEPT_FM;
	}

	public void setCOMP_UI_M_BUTT_LOV_DEPT_FM(HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_FM) {
		this.COMP_UI_M_BUTT_LOV_DEPT_FM = COMP_UI_M_BUTT_LOV_DEPT_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUTT_LOV_DEPT_TO() {
		return COMP_UI_M_BUTT_LOV_DEPT_TO;
	}

	public void setCOMP_UI_M_BUTT_LOV_DEPT_TO(HtmlCommandButton COMP_UI_M_BUTT_LOV_DEPT_TO) {
		this.COMP_UI_M_BUTT_LOV_DEPT_TO = COMP_UI_M_BUTT_LOV_DEPT_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public DUMMY getDUMMY_BEAN() {
		return DUMMY_BEAN;
	}

	public void setDUMMY_BEAN(DUMMY DUMMY_BEAN) {
		this.DUMMY_BEAN = DUMMY_BEAN;
	}
	
	public Connection getConnection(){
		try {
			Connection connection = CommonUtils.getConnection();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return null;
		
	}
	
	public void PILP025_preform(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getSessionMap();
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
	}
	
	CRUDHandler handler = new CRUDHandler();
	
	public List UI_M_POLICY_FM_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		ResultSet rs = null;
		String query =null;
		if(obj.toString().equals("*")){
			query = "SELECT /*+ FIRST_ROWS */ POL_NO FROM pt_il_policy WHERE NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' ";
		}else{
			String value = obj.toString().toUpperCase(); 
			query = "select /*+ FIRST_ROWS */ POL_NO from pt_il_policy where NVL(POL_STATUS,'N') IN ('A', 'E', 'P')AND POL_NO IS NOT NULL AND POL_DS_TYPE = '2' AND POL_NO LIKE('"+obj.toString().toUpperCase()+"%')";
		}
		Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,connection);
		rs.setFetchSize(25);
		while(rs.next()){
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV(); 
			lovBox.setPOL_NO(rs.getString("POL_NO"));
			lovList.add(lovBox);
		}
		rs.close();
		//connection.close();
		return lovList;

	}

	//LOV for DIV
	CommonUtils util = new CommonUtils();
	public List UI_M_DIVN_FM_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		ResultSet rs = null;
		String query =null;
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Mallika.S, 01-Apr-2009 */
		if(obj.toString().equals("*")){
			query = "select /*+ FIRST_ROWS */ DEPT_DIVN_CODE from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND ROWNUM < 25 order by 1";
		}else{
			query = "select /*+ FIRST_ROWS */ DEPT_DIVN_CODE from FM_DEPARTMENT where DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE LIKE('"+obj.toString().toUpperCase()+"%') AND ROWNUM < 25";
		}
		//Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,util.getConnection());
		while(rs.next()){
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV(); 
			lovBox.setDIVN(rs.getString("DEPT_DIVN_CODE"));
			lovList.add(lovBox);
		}
		rs.close();
		//util.getConnection().close();
		return lovList;

	}
	// LOV For DEPT_CODE FM and TO
	public List UI_M_DEPT_FM_lovAction(Object obj)throws Exception {
		List lovList = new ArrayList();
		ResultSet rs = null;
		String query =null;
		/*[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Mallika.S, 01-Apr-2009 */
		if(obj.toString().equals("*")){
			query = "select /*+ FIRST_ROWS */ DEPT_CODE from FM_DEPARTMENT where DEPT_COMP_CODE ='001' and DEPT_DIVN_CODE BETWEEN 'A%' and 'Z%' ORDER BY 1"; 
		}else{
			query = "select /*+ FIRST_ROWS */ DEPT_CODE from FM_DEPARTMENT where DEPT_COMP_CODE ='001' and DEPT_DIVN_CODE BETWEEN 'A%' and 'Z%' AND DEPT_CODE LIKE('"+obj.toString().toUpperCase()+"%')";
		}
		//Connection connection = CommonUtils.getConnection();
		rs = handler.executeSelectStatement(query,util.getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			UI_M_POLICY_FM_LOV lovBox = new UI_M_POLICY_FM_LOV(); 
			lovBox.setDEPT_CODE(rs.getString("DEPT_CODE"));
			lovList.add(lovBox);
		}
		rs.close();
		//util.getConnection().close();
		return lovList;
	}
// Calling all Triggers
	
	public void UI_M_POLICY_FM_WHEN_VALIDATE(ActionEvent event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.pilp025_dummy_ui_m_policy_fm_when_validate_item();
	}
	public void UI_M_DIVN_FM_WHEN_VALIDATE(ActionEvent event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.pilp025_dummy_ui_m_divn_fm_when_validate_item();
	}
	public void UI_M_DIVN_TO_WHEN_VALIDATE(ActionEvent event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.pilp025_dummy_ui_m_divn_to_when_validate_item();
	}
	
	public void UI_M_DEPT_FM_WHEN_VALIDATE(ActionEvent event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.pilp025_dummy_ui_m_dept_fm_when_validate_item();
	}
	public void UI_M_DEPT_TO_WHEN_VALIDATE(ActionEvent event)
	{
		DUMMY_HELPER helper = new DUMMY_HELPER();
		helper.pilp025_dummy_ui_m_dept_to_when_validate_item();
	}
	
	public void UI_M_DATE_COMPARIISION(ActionEvent event){
		UIInput component = (UIInput) event.getComponent().getParent();
		String toDate = (String) getCOMP_UI_M_TO_DT().getSubmittedValue();
		String fromDate = (String) getCOMP_UI_M_FM_DT().getSubmittedValue();
		Map<String, String> errMap = getErrorMap(); 
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		Date dateFromDate;
		try {
			Date dateFromDate1= format.parse(fromDate);
			Date dateToDate = format.parse(toDate);
			
			if(dateToDate.before(dateFromDate1)) {
				System.out.println("There is an Error in Date it should not ne greater than Zero");
				   String message=Messages.getString(PELConstants.pelErrorMessagePath, "71145");
						errMap.put("current",message);
						errMap.put("someKey",message);
			}
			else{
				errMap.clear();	
			}

		} catch (ParseException e) {
			e.printStackTrace();
		}
   
	}
	// this will be called on Process Button Pressed
	public String ui_WHEN_BUTTON_PROCESS_CLICKED()	{
		getWarningMap().clear();
		getErrorMap().clear();
		DUMMY_HELPER helper = new DUMMY_HELPER();
		String outCome = null;
		try {
			outCome = helper.when_process_button_pressed(DUMMY_BEAN);
			String message = Messages.getString(PELConstants.pelErrorMessagePath,
			"60315");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, message);
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, message);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("Process", e.getMessage());
		}
		return outCome;
	}
	public void onLoad(PhaseEvent event) {
		if(isBlockFlag()){
			try {
				DUMMY_BEAN.setUI_M_FM_DT(new CommonUtils().getCurrentDate());
				DUMMY_BEAN.setUI_M_TO_DT(new CommonUtils().getCurrentDate());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setBlockFlag(false);
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validateUI_M_CERT_PRINT_YN(FacesContext fc, UIComponent component, Object value) throws ValidatorException, Exception {
		try {
			if((Boolean)value) {
				DUMMY_BEAN.setUI_M_CERT_PRINT_YN("Y");
			} else {
				DUMMY_BEAN.setUI_M_CERT_PRINT_YN("N");
			}
		} catch (Exception e) { 
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateUI_M_PROP_DRIP_YN(FacesContext fc, UIComponent component, Object value) throws ValidatorException, Exception {
		try {
			if((Boolean)value) {
				DUMMY_BEAN.setUI_M_PROP_DRIP_YN("Y");
			} else {
				DUMMY_BEAN.setUI_M_PROP_DRIP_YN("N");
			}
		} catch (Exception e) { 
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateUI_M_EXE_PREMIUM_YN(FacesContext fc, UIComponent component, Object value) throws ValidatorException, Exception {
		try {
			if((Boolean)value) {
				DUMMY_BEAN.setUI_M_EXE_PREMIUM_YN("Y");
			} else {
				DUMMY_BEAN.setUI_M_EXE_PREMIUM_YN("N");
			}
		} catch (Exception e) { 
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
}
