package com.iii.pel.forms.PILP200;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.GNMNF002.GNMNF002_PLM006_APAC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class REN_PREM_PROCESS_ACTION extends CommonAction {
	
	private Connection connection;
	private ResultSet resultSet;
	private CRUDHandler handler = new CRUDHandler();
	OracleProcedureHandler ora_handler = new OracleProcedureHandler();
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap(); 
	GNMNF002_PLM006_APAC gnmnfoo2 = null;
	private BUTTON_PALETTE buttonPallete = null;
	private String M_TITLE;
	private String query;
	private String M_DUMMY;
	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> data_List = new ArrayList<OracleParameter>();

	private HtmlOutputLabel COMP_UI_M_FM_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_FM_POL_NO;

	private HtmlOutputLabel COMP_UI_M_TO_POL_NO_LABEL;

	private HtmlInputText COMP_UI_M_TO_POL_NO;

	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FROM;

	private HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO;

	private REN_PREM_PROCESS REN_PREM_PROCESS_BEAN;

	public REN_PREM_PROCESS_ACTION() {
		REN_PREM_PROCESS_BEAN = new REN_PREM_PROCESS();
		PILP200_PRE_FORM();
		REN_PREM_PROCESS_WHEN_CREATE_RECORD();
	}

	public HtmlOutputLabel getCOMP_UI_M_FM_POL_NO_LABEL() {
		return COMP_UI_M_FM_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_FM_POL_NO() {
		return COMP_UI_M_FM_POL_NO;
	}

	public void setCOMP_UI_M_FM_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_FM_POL_NO_LABEL) {
		this.COMP_UI_M_FM_POL_NO_LABEL = COMP_UI_M_FM_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_FM_POL_NO(HtmlInputText COMP_UI_M_FM_POL_NO) {
		this.COMP_UI_M_FM_POL_NO = COMP_UI_M_FM_POL_NO;
	}

	public HtmlOutputLabel getCOMP_UI_M_TO_POL_NO_LABEL() {
		return COMP_UI_M_TO_POL_NO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_TO_POL_NO() {
		return COMP_UI_M_TO_POL_NO;
	}

	public void setCOMP_UI_M_TO_POL_NO_LABEL(HtmlOutputLabel COMP_UI_M_TO_POL_NO_LABEL) {
		this.COMP_UI_M_TO_POL_NO_LABEL = COMP_UI_M_TO_POL_NO_LABEL;
	}

	public void setCOMP_UI_M_TO_POL_NO(HtmlInputText COMP_UI_M_TO_POL_NO) {
		this.COMP_UI_M_TO_POL_NO = COMP_UI_M_TO_POL_NO;
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

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_FROM() {
		return COMP_UI_M_BUT_LOV_POL_NO_FROM;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_FROM(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_FROM) {
		this.COMP_UI_M_BUT_LOV_POL_NO_FROM = COMP_UI_M_BUT_LOV_POL_NO_FROM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_LOV_POL_NO_TO() {
		return COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public void setCOMP_UI_M_BUT_LOV_POL_NO_TO(HtmlCommandButton COMP_UI_M_BUT_LOV_POL_NO_TO) {
		this.COMP_UI_M_BUT_LOV_POL_NO_TO = COMP_UI_M_BUT_LOV_POL_NO_TO;
	}

	public REN_PREM_PROCESS getREN_PREM_PROCESS_BEAN() {
		return REN_PREM_PROCESS_BEAN;
	}

	public void setREN_PREM_PROCESS_BEAN(REN_PREM_PROCESS REN_PREM_PROCESS_BEAN) {
		this.REN_PREM_PROCESS_BEAN = REN_PREM_PROCESS_BEAN;
	}
	
	public String getM_TITLE() {
		return M_TITLE;
	}

	public void setM_TITLE(String m_title) {
		M_TITLE = m_title;
	}
	public String PILP200_PRE_FORM(){
		connection = getConnection();
		gnmnfoo2 = new GNMNF002_PLM006_APAC();
		gnmnfoo2.setGlobalParameters();
		FacesContext faces = FacesContext.getCurrentInstance();
		session = faces.getExternalContext().getSessionMap();
		
//		if(session.get("GLOBAL.CALLING_FORM") == null){
//			session.put("GLOBAL.M_PRIVILEGE" , "YYY");
//			session.put("GLOBAL.M_FAILURE" , "FALSE");
//			session.put("GLOBAL.M_USER_ID", "PREMIA");
//			session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
//			session.put("GLOBAL.M_LANG_CODE", "ENG");
//			session.put("GLOBAL.M_PARA_1", " ");
//			session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
//			session.put("GLOBAL.M_MODULE_NAME", "PILP200");
//			session.put("GLOBAL.M_DFLT_VALUES", "00101    011111111111");
//			session.put("GLOBAL.POL_SYS_ID", "13");
//			session.put("GLOBAL.CLM_SYS_ID", "222");
//		}
//		PILP200_APAC_STD_PRE_FORM();
//		if(session.get("GLOBAL.M_FOR_LANG_CODE").toString().substring(4, 5).equals("1")){
//			return null;
//		}
//		setM_TITLE(controlBean.getM_USER_ID()+controlBean.getM_SCR_NAME()+getSystemDate());
//		getTestButton().setDisabled(true);
		return "";
	}
	
	public void PILP200_APAC_STD_PRE_FORM(){
		ControlBean controlBean = CommonUtils.getControlBean();
		buttonPallete = new BUTTON_PALETTE();
		buttonPallete.setM_RUN_DATE(getSystemDate().toString());
		controlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		controlBean.setM_PROG_NAME("PILP200");
		buttonPallete.setM_COMP_NAME(getSubStringM_NAME(1, gnmnfoo2.returnGlobalValues().get("GLOBAL.M_COMP_NAME").toString().length()));
//		 COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		controlBean.setM_GOFLD_NAME(null);
		gnmnfoo2.setM_MODULE_NAME("PILP200");
		setM_TITLE(controlBean.getM_USER_ID()+controlBean.getM_SCR_NAME()+getSystemDate());

	}
	
	public void PILP200_POST_DATABASE_COMMIT(){
		session.put("GLOBAL.M_FAILURE", "FALSE");
	}
	public void PILP200_POST_FORMS_COMMIT(){
		session.put("GLOBAL.M_FAILURE","FALSE");
	}
	
	public void REN_PREM_PROCESS_WHEN_CREATE_RECORD(){
		REN_PREM_PROCESS_BEAN.setUI_M_FM_DT(getSystemDate());
		REN_PREM_PROCESS_BEAN.setUI_M_TO_DT(REN_PREM_PROCESS_BEAN.getUI_M_FM_DT());
	}
	
	public void M_FM_POL_NO_WHEN_VALIDATE_ITEM(ActionEvent ae){
		String C1 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_DS_TYPE = '2' AND POL_NO = '"+getCOMP_UI_M_FM_POL_NO().getSubmittedValue().toString()+"'";
		try {
			resultSet = handler.executeSelectStatement(C1, getConnection());
			if(resultSet.next()){
				setM_DUMMY(resultSet.getString(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				resultSet.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		if(getCOMP_UI_M_FM_POL_NO().getSubmittedValue() != null && !getCOMP_UI_M_FM_POL_NO().getSubmittedValue().equals("")){
			if(getM_DUMMY() == null || getM_DUMMY().equals("")){
				setM_DUMMY("Y");
			}
			if(!getM_DUMMY().equals("X")){
			//	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71153"));
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "71153"));
			}else{
				getErrorMap().clear();
			}
		}
		getCOMP_UI_M_FM_POL_NO().setSubmittedValue(SET_REP_FIRST_FIELD(getCOMP_UI_M_FM_POL_NO().getSubmittedValue().toString(),REN_PREM_PROCESS_BEAN.getUI_M_TO_POL_NO()));
		REN_PREM_PROCESS_BEAN.setUI_M_TO_POL_NO(REN_PREM_PROCESS_BEAN.getUI_M_TO_POL_NO());
		setM_DUMMY("");
	}

	public void M_TO_POL_NO_WHEN_VALIDATE_ITEM(ActionEvent ae){
		String C1 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_DS_TYPE = '2' AND POL_NO = '"+REN_PREM_PROCESS_BEAN.getUI_M_TO_POL_NO()+"'";
		try{
			resultSet = handler.executeSelectStatement(C1, getConnection());
			if(resultSet.next()){
				setM_DUMMY(resultSet.getString(1));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				resultSet.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}

		if(getCOMP_UI_M_TO_POL_NO().getSubmittedValue() != null && !getCOMP_UI_M_TO_POL_NO().getSubmittedValue().toString().equals("")){
			if(getM_DUMMY() == null || getM_DUMMY().equals("")){
				setM_DUMMY("Y");
			}
			if(!getM_DUMMY().equals("X")){
//				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71153"));
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "71153"));
			}else{
				getErrorMap().clear();
			}
		}
		getCOMP_UI_M_TO_POL_NO().setSubmittedValue(SET_REP_SECOND_FIELD(getCOMP_UI_M_FM_POL_NO().getSubmittedValue().toString(),getCOMP_UI_M_TO_POL_NO().getSubmittedValue().toString()));
		setM_DUMMY("");
	}
	
	public List M_FM_POL_NO_LIST(Object obj) throws Exception{
		List policyList = new ArrayList();
		getCOMP_UI_M_FM_DT().setSubmittedValue(null);
		if(obj.toString().equals("*")){
			query="SELECT POL_NO,TO_CHAR(POL_ISSUE_DT),TO_CHAR(POL_ISSUE_DT) from PT_IL_POLICY WHERE POL_DS_TYPE = '2' AND ROWNUM < 50 order by POL_NO asc";
		}else{
			query="SELECT POL_NO,TO_CHAR(POL_ISSUE_DT),TO_CHAR(POL_ISSUE_DT) from PT_IL_POLICY WHERE POL_DS_TYPE = '2' AND POL_NO LIKE '"+obj.toString()+"%' AND ROWNUM < 50 order by POL_NO asc";
		}
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			PolicyBean pbean = new PolicyBean();
			pbean.setPOL_NO(resultSet.getString(1));
			pbean.setPOL_ISSUE_DT(resultSet.getString(2));
			pbean.setPOL_ISSUE_DT(resultSet.getString(3));
			policyList.add(pbean);
		}
		resultSet.close();
		return policyList;
	}

	public List M_TO_POL_NO_LIST(Object obj) throws Exception{
		List policyList = new ArrayList();
		getCOMP_UI_M_TO_DT().setSubmittedValue(null);
		if(obj.toString().equals("*")){
		query="SELECT POL_NO,TO_CHAR(POL_ISSUE_DT),TO_CHAR(POL_ISSUE_DT) from PT_IL_POLICY WHERE POL_DS_TYPE = '2' AND ROWNUM < 50 order by POL_NO asc";
		}else{
			query="SELECT POL_NO,TO_CHAR(POL_ISSUE_DT),TO_CHAR(POL_ISSUE_DT) from PT_IL_POLICY WHERE POL_DS_TYPE = '2' AND POL_NO LIKE '"+obj.toString()+"%' AND ROWNUM < 50 order by POL_NO asc";
		}
		resultSet = handler.executeSelectStatement(query, connection);
		resultSet.setFetchSize(25);
		while(resultSet.next()){
			PolicyBean pbean = new PolicyBean();
			pbean.setPOL_NO(resultSet.getString(1));
			pbean.setPOL_ISSUE_DT(resultSet.getString(2));
			pbean.setPOL_ISSUE_DT(resultSet.getString(3));
			policyList.add(pbean);
		}
		resultSet.close();
		return policyList;
	}
	
	public void M_FM_DT_WHEN_VALIDATE_ITEM(ActionEvent ae){
		getCOMP_UI_M_TO_DT().setSubmittedValue(getCOMP_UI_M_FM_DT().getSubmittedValue());
		compare_Date(REN_PREM_PROCESS_BEAN.getUI_M_FM_DT(), REN_PREM_PROCESS_BEAN.getUI_M_TO_DT());
	}
	
	public void M_TO_DT_WHEN_VALIDATE_ITEM(ActionEvent ae) throws ValidatorException{
		compare_Date(REN_PREM_PROCESS_BEAN.getUI_M_FM_DT(), REN_PREM_PROCESS_BEAN.getUI_M_TO_DT());
	}
	
	
	public void policyNoFrom(FacesContext facesContext,UIComponent component,Object value){
		
		if(value!=null){
			
			String policyNoFrom = (String)value;
			REN_PREM_PROCESS_BEAN.setUI_M_FM_POL_NO(policyNoFrom);
			
			
			
		}
		
		
		
	}
	
	
	public void M_BUT_PROCESS_WHEN_BUTTON_PRESSED(ActionEvent ae){
		paramList.clear();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",REN_PREM_PROCESS_BEAN.getUI_M_FM_POL_NO());
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",REN_PREM_PROCESS_BEAN.getUI_M_TO_POL_NO());
		OracleParameter param3 = new OracleParameter("in3","STRING","IN",format_Date(REN_PREM_PROCESS_BEAN.getUI_M_FM_DT()));
		OracleParameter param4 = new OracleParameter("in4","STRING","IN",format_Date(REN_PREM_PROCESS_BEAN.getUI_M_TO_DT()));
		
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		
		try {
			data_List = ora_handler.execute(paramList, getConnection(), "P9ILPK_PREM_COLL.P_CALC_REN_PREM");
			getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
			getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3083").getSummary());
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningsforProcedureAction(getConnection(), FacesContext.getCurrentInstance(), ((UICommand) getCOMP_UI_M_BUT_PROCESS()).getClientId(FacesContext.getCurrentInstance()), getErrorMap(), getWarningMap());
		}
	}
	
	public String format_Date(Date date){
		String result=null; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		result = sdf.format(date).toString();
		return result;
	}
	
	public String SET_REP_FIRST_FIELD(String M_FIELD_NAME,String M_FIELD_NAME2){
		if(M_FIELD_NAME != null && M_FIELD_NAME.equals("")){
			M_FIELD_NAME = "0";
		}else if(M_FIELD_NAME2 != null && !M_FIELD_NAME2.equals("")){
			compare_Ranges(M_FIELD_NAME,M_FIELD_NAME2);
		}
		return M_FIELD_NAME;
	}
	
	public String SET_REP_SECOND_FIELD(String M_FIELD_NAME1,String M_FIELD_NAME2){
		if(M_FIELD_NAME2 != null && M_FIELD_NAME2.equals("")){
			if(M_FIELD_NAME1.equals("0")){
				M_FIELD_NAME2 = "zzzzzzzzzz";
			}else{
				M_FIELD_NAME2 = M_FIELD_NAME1;
			}
		}else{
			compare_Ranges(M_FIELD_NAME1,M_FIELD_NAME2);
		}
		return M_FIELD_NAME2;
	}
	
	public void compare_Ranges(String M_FIELD_NAME1,String M_FIELD_NAME2){
		if(M_FIELD_NAME2.compareTo(M_FIELD_NAME1) < 0){
			getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
//			getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "10064").getDetail());
		}else{
			getErrorMap().clear();
		}
	}
	
	public void compare_Date(Date from_Date,Date to_Date){
		if(from_Date != null && to_Date != null){
			if(from_Date.compareTo(to_Date) > 0){
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "71145"));
//				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71145").getDetail());
			}else{
				getErrorMap().clear();
			}
		}
	}

	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public Date getSystemDate(){
		Date sysDate = null;
		try {
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next())
				sysDate = resultSet.getDate(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				resultSet.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return sysDate;
	}
	public String getSubStringM_NAME(int startIndex,int length){
		String def_Values = gnmnfoo2.returnGlobalValues().get("GLOBAL.M_NAME").toString();
		String res_String = def_Values.substring(startIndex-1, (startIndex-1+length));
		while(res_String.endsWith(" ")){
			res_String = res_String.substring(0, res_String.length()-1);
		}
		return res_String;
	}
	public String getSubStringM_DFLT_VALUES(int startIndex,int length){
		String def_Values = session.get("GLOBAL.M_DFLT_VALUES").toString();
		String res_String = def_Values.substring(startIndex-1, (startIndex-1+length));
		while(res_String.endsWith(" ")){
			res_String = res_String.substring(0, res_String.length()-1);
		}
		return res_String;
	}

	public String getM_DUMMY() {
		return M_DUMMY;
	}

	public void setM_DUMMY(String m_dummy) {
		M_DUMMY = m_dummy;
	}
}
