package com.iii.pel.forms.PILP022;

import java.sql.Connection;
import java.sql.ResultSet;
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
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.GNMNF002.GNMNF002_PILP022;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_ACTION extends CommonAction{

	private ResultSet resultSet = null;
	private String errMsg = "";
	private String M_TITLE;
	private HtmlOutputLabel COMP_UI_M_AGENT_CODE_FM_LABEL;
	private BUTTON_PALETTE buttonPallete = null;
	GNMNF002_PILP022 gnmnfoo2 = null;
	private Connection connection = null;
	
	Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
	ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
	
	private HtmlInputText COMP_UI_M_AGENT_CODE_FM;

	private HtmlOutputLabel COMP_UI_M_UNIT_CODE_FM_LABEL;

	private HtmlInputText COMP_UI_M_UNIT_CODE_FM;

	private HtmlOutputLabel COMP_UI_M_AGENCY_CODE_FM_LABEL;

	private HtmlInputText COMP_UI_M_AGENCY_CODE_FM;

	private HtmlOutputLabel COMP_UI_M_FM_DT_LABEL;

	private HtmlCalendar COMP_UI_M_FM_DT;

	private HtmlOutputLabel COMP_UI_M_AGENT_CODE_TO_LABEL;

	private HtmlInputText COMP_UI_M_AGENT_CODE_TO;

	private HtmlOutputLabel COMP_UI_M_UNIT_CODE_TO_LABEL;

	private HtmlInputText COMP_UI_M_UNIT_CODE_TO;

	private HtmlOutputLabel COMP_UI_M_AGENCY_CODE_TO_LABEL;

	private HtmlInputText COMP_UI_M_AGENCY_CODE_TO;

	private HtmlOutputLabel COMP_UI_M_TO_DT_LABEL;

	private HtmlCalendar COMP_UI_M_TO_DT;

	private HtmlCommandButton COMP_UI_M_AGENCY_LOV_FM;

	private HtmlCommandButton COMP_UI_M_AGENCY_LOV_TO;

	private HtmlCommandButton COMP_UI_M_UNIT_CODE_LOV_FM;

	private HtmlCommandButton COMP_UI_M_UNIT_CODE_LOV_TO;

	private HtmlCommandButton COMP_UI_M_AGENT_CODE_LOV_FM;

	private HtmlCommandButton COMP_UI_M_AGENT_CODE_LOV_TO;

	private HtmlCommandButton COMP_UI_M_BUT_PROCESS;
	
	private HtmlCommandButton testButton;

	private PT_AGENT PT_AGENT_BEAN;
	
	//[Added Newly For PREMIAGDC-327842
	public PILP022_COMPOSITE_ACTION compositeAction;
	//Added Newly For PREMIAGDC-327842]
	public static CRUDHandler handler = null;
	
	public PT_AGENT_ACTION() {;
		PT_AGENT_BEAN = new PT_AGENT();
		handler = new CRUDHandler();
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENT_CODE_FM_LABEL() {
		return COMP_UI_M_AGENT_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_CODE_FM() {
		return COMP_UI_M_AGENT_CODE_FM;
	}

	public void setCOMP_UI_M_AGENT_CODE_FM_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_CODE_FM_LABEL) {
		this.COMP_UI_M_AGENT_CODE_FM_LABEL = COMP_UI_M_AGENT_CODE_FM_LABEL;
	}

	public void setCOMP_UI_M_AGENT_CODE_FM(HtmlInputText COMP_UI_M_AGENT_CODE_FM) {
		this.COMP_UI_M_AGENT_CODE_FM = COMP_UI_M_AGENT_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_UNIT_CODE_FM_LABEL() {
		return COMP_UI_M_UNIT_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_UNIT_CODE_FM() {
		return COMP_UI_M_UNIT_CODE_FM;
	}

	public void setCOMP_UI_M_UNIT_CODE_FM_LABEL(HtmlOutputLabel COMP_UI_M_UNIT_CODE_FM_LABEL) {
		this.COMP_UI_M_UNIT_CODE_FM_LABEL = COMP_UI_M_UNIT_CODE_FM_LABEL;
	}

	public void setCOMP_UI_M_UNIT_CODE_FM(HtmlInputText COMP_UI_M_UNIT_CODE_FM) {
		this.COMP_UI_M_UNIT_CODE_FM = COMP_UI_M_UNIT_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENCY_CODE_FM_LABEL() {
		return COMP_UI_M_AGENCY_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENCY_CODE_FM() {
		return COMP_UI_M_AGENCY_CODE_FM;
	}

	public void setCOMP_UI_M_AGENCY_CODE_FM_LABEL(HtmlOutputLabel COMP_UI_M_AGENCY_CODE_FM_LABEL) {
		this.COMP_UI_M_AGENCY_CODE_FM_LABEL = COMP_UI_M_AGENCY_CODE_FM_LABEL;
	}

	public void setCOMP_UI_M_AGENCY_CODE_FM(HtmlInputText COMP_UI_M_AGENCY_CODE_FM) {
		this.COMP_UI_M_AGENCY_CODE_FM = COMP_UI_M_AGENCY_CODE_FM;
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

	public HtmlOutputLabel getCOMP_UI_M_AGENT_CODE_TO_LABEL() {
		return COMP_UI_M_AGENT_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENT_CODE_TO() {
		return COMP_UI_M_AGENT_CODE_TO;
	}

	public void setCOMP_UI_M_AGENT_CODE_TO_LABEL(HtmlOutputLabel COMP_UI_M_AGENT_CODE_TO_LABEL) {
		this.COMP_UI_M_AGENT_CODE_TO_LABEL = COMP_UI_M_AGENT_CODE_TO_LABEL;
	}

	public void setCOMP_UI_M_AGENT_CODE_TO(HtmlInputText COMP_UI_M_AGENT_CODE_TO) {
		this.COMP_UI_M_AGENT_CODE_TO = COMP_UI_M_AGENT_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_UNIT_CODE_TO_LABEL() {
		return COMP_UI_M_UNIT_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_UNIT_CODE_TO() {
		return COMP_UI_M_UNIT_CODE_TO;
	}

	public void setCOMP_UI_M_UNIT_CODE_TO_LABEL(HtmlOutputLabel COMP_UI_M_UNIT_CODE_TO_LABEL) {
		this.COMP_UI_M_UNIT_CODE_TO_LABEL = COMP_UI_M_UNIT_CODE_TO_LABEL;
	}

	public void setCOMP_UI_M_UNIT_CODE_TO(HtmlInputText COMP_UI_M_UNIT_CODE_TO) {
		this.COMP_UI_M_UNIT_CODE_TO = COMP_UI_M_UNIT_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_UI_M_AGENCY_CODE_TO_LABEL() {
		return COMP_UI_M_AGENCY_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_AGENCY_CODE_TO() {
		return COMP_UI_M_AGENCY_CODE_TO;
	}

	public void setCOMP_UI_M_AGENCY_CODE_TO_LABEL(HtmlOutputLabel COMP_UI_M_AGENCY_CODE_TO_LABEL) {
		this.COMP_UI_M_AGENCY_CODE_TO_LABEL = COMP_UI_M_AGENCY_CODE_TO_LABEL;
	}

	public void setCOMP_UI_M_AGENCY_CODE_TO(HtmlInputText COMP_UI_M_AGENCY_CODE_TO) {
		this.COMP_UI_M_AGENCY_CODE_TO = COMP_UI_M_AGENCY_CODE_TO;
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

	public HtmlCommandButton getCOMP_UI_M_AGENCY_LOV_FM() {
		return COMP_UI_M_AGENCY_LOV_FM;
	}

	public void setCOMP_UI_M_AGENCY_LOV_FM(HtmlCommandButton COMP_UI_M_AGENCY_LOV_FM) {
		this.COMP_UI_M_AGENCY_LOV_FM = COMP_UI_M_AGENCY_LOV_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_AGENCY_LOV_TO() {
		return COMP_UI_M_AGENCY_LOV_TO;
	}

	public void setCOMP_UI_M_AGENCY_LOV_TO(HtmlCommandButton COMP_UI_M_AGENCY_LOV_TO) {
		this.COMP_UI_M_AGENCY_LOV_TO = COMP_UI_M_AGENCY_LOV_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_UNIT_CODE_LOV_FM() {
		return COMP_UI_M_UNIT_CODE_LOV_FM;
	}

	public void setCOMP_UI_M_UNIT_CODE_LOV_FM(HtmlCommandButton COMP_UI_M_UNIT_CODE_LOV_FM) {
		this.COMP_UI_M_UNIT_CODE_LOV_FM = COMP_UI_M_UNIT_CODE_LOV_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_UNIT_CODE_LOV_TO() {
		return COMP_UI_M_UNIT_CODE_LOV_TO;
	}

	public void setCOMP_UI_M_UNIT_CODE_LOV_TO(HtmlCommandButton COMP_UI_M_UNIT_CODE_LOV_TO) {
		this.COMP_UI_M_UNIT_CODE_LOV_TO = COMP_UI_M_UNIT_CODE_LOV_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_AGENT_CODE_LOV_FM() {
		return COMP_UI_M_AGENT_CODE_LOV_FM;
	}

	public void setCOMP_UI_M_AGENT_CODE_LOV_FM(HtmlCommandButton COMP_UI_M_AGENT_CODE_LOV_FM) {
		this.COMP_UI_M_AGENT_CODE_LOV_FM = COMP_UI_M_AGENT_CODE_LOV_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_AGENT_CODE_LOV_TO() {
		return COMP_UI_M_AGENT_CODE_LOV_TO;
	}

	public void setCOMP_UI_M_AGENT_CODE_LOV_TO(HtmlCommandButton COMP_UI_M_AGENT_CODE_LOV_TO) {
		this.COMP_UI_M_AGENT_CODE_LOV_TO = COMP_UI_M_AGENT_CODE_LOV_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_PROCESS() {
		return COMP_UI_M_BUT_PROCESS;
	}

	public void setCOMP_UI_M_BUT_PROCESS(HtmlCommandButton COMP_UI_M_BUT_PROCESS) {
		this.COMP_UI_M_BUT_PROCESS = COMP_UI_M_BUT_PROCESS;
	}

	public PT_AGENT getPT_AGENT_BEAN() {
		return PT_AGENT_BEAN;
	}

	public void setPT_AGENT_BEAN(PT_AGENT PT_AGENT_BEAN) {
		this.PT_AGENT_BEAN = PT_AGENT_BEAN;
	}
	
	public String PILP022_PRE_FORM(PhaseEvent event){
		/*
		         Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            String M_FILE=null;
            String M_TITLE=null;
            try{
                pcopk_sys_vars.pcopk_sys_vars.p_set_para_values(:GLOBAL.M_LANG_CODE,:GLOBAL.M_FOR_LANG_CODE,:GLOBAL.M_USER_ID,:CTRL.M_COMP_CODE,StringFunctions.rTrim(StringFunctions.substr(:GLOBAL.M_DFLT_VALUES,4,6)," "),StringFunctions.rTrim(StringFunctions.substr(:GLOBAL.M_DFLT_VALUES,10,6)," "),null,2,:CTRL.M_PROG_NAME);
                SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);
                if(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM)== null)
                {
                    :GLOBAL.M_PRIVILEGE="YYY";
                    :GLOBAL.M_FAILURE="FALSE";
                    :GLOBAL.M_USER_ID="PREMIA";
                    :GLOBAL.M_NAME="COMPANY NAME..................PROGRAM NAME";
                    :GLOBAL.M_LANG_CODE="ENG";
                    :GLOBAL.M_PARA_1=" ";
                    :GLOBAL.M_FOR_LANG_CODE="ARBR1";
                    :GLOBAL.M_MODULE_NAME=GET_FORM_PROPERTY.GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME);
                }
                STD_PRE_FORM.STD_PRE_FORM();
                if(StringFunctions.substr(:GLOBAL.M_FOR_LANG_CODE,5,1)=="1")
                {
                }
                M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
                SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
            }
            catch(SQLException se){
                L_DISPLAY_ERROR_MESSAGE.L_DISPLAY_ERROR_MESSAGE();
                throw new FORM_TRIGGER_FAILURE();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }

		 */
		gnmnfoo2 = new GNMNF002_PILP022();
		gnmnfoo2.setGlobalParameters();
		FacesContext faces = FacesContext.getCurrentInstance();
		session = faces.getExternalContext().getSessionMap();
		connection = getConnection();
//		Comment when in live
/*		session.put("GLOBAL.M_LANG_CODE", "ENG");
		session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR1");
		session.put("GLOBAL.M_USER_ID", "LIFEALL");
		session.put("GLOBAL.M_COMP_CODE", "001");
		session.put("GLOBAL.M_MODULE_NAME", "PILT011");*/
//		Comment when in live
		session.put("GLOBAL.M_DFLT_VALUES", "001010111111111111111");
		
		/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 BECAUSE OF HARD
		      CODED VALUES OF DIVI, DEPT THROWING ERROR Transaction code
		      not defined for Dvn Dept Payment mode on clicking process*/
		
		/*paramList.clear();
		paramList.add(new OracleParameter("in1","STRING","IN",session.get("GLOBAL.M_LANG_CODE").toString()));
		paramList.add(new OracleParameter("in2","STRING","IN",session.get("GLOBAL.M_FOR_LANG_CODE").toString()));
		paramList.add(new OracleParameter("in3","STRING","IN",session.get("GLOBAL.M_USER_ID").toString()));
		paramList.add(new OracleParameter("in4","STRING","IN",session.get("GLOBAL.M_COMP_CODE").toString()));
		paramList.add(new OracleParameter("in5","STRING","IN",globalM_DEFAULT(4,6)));
		paramList.add(new OracleParameter("in6","STRING","IN",globalM_DEFAULT(10,6)));
		paramList.add(new OracleParameter("in7","STRING","IN",null));
		paramList.add(new OracleParameter("in8","STRING","IN","2"));
		paramList.add(new OracleParameter("in9","STRING","IN",session.get("GLOBAL.M_MODULE_NAME").toString()));*/		

		OracleProcedureHandler ora_Handler = new OracleProcedureHandler();
		
		
		
		PILP022_WHEN_NEW_ITEM_INSTANCE();
		PILP022_WHEN_NEW_BLOCK_INSTANCE();
//		getTestButton().setDisabled(true);
		return "";
	}
	public String globalM_DEFAULT(int startIndex,int length){
//		String def_Values = "12345678911111111";
		String def_Values = session.get("GLOBAL.M_DFLT_VALUES").toString();
		String res_String = def_Values.substring(startIndex-1, (startIndex-1+length));
		while(res_String.endsWith(" ")){
			res_String = res_String.substring(0, res_String.length()-1);
		}
		return res_String;
	}
	
	public void PILP022_STD_PRE_FORM(){
		
		ControlBean controlBean = CommonUtils.getControlBean();
		buttonPallete = new BUTTON_PALETTE();
		buttonPallete.setM_RUN_DATE(getSystemDate());
		controlBean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
		controlBean.setM_PROG_NAME("PILP022");
		buttonPallete.setM_COMP_NAME(getSubStringM_NAME(1, gnmnfoo2.returnGlobalValues().get("GLOBAL.M_COMP_NAME").toString().length()));
//		 COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		controlBean.setM_GOFLD_NAME("NULL");
		gnmnfoo2.setM_MODULE_NAME("PILP022");
		setM_TITLE(controlBean.getM_USER_ID()+controlBean.getM_SCR_NAME()+getSystemDate());
	}
	public String getSubStringM_NAME(int startIndex,int length){
		String def_Values = gnmnfoo2.returnGlobalValues().get("GLOBAL.M_NAME").toString();
		String res_String = def_Values.substring(startIndex-1, (startIndex-1+length));
		while(res_String.endsWith(" ")){
			res_String = res_String.substring(0, res_String.length()-1);
		}
		return res_String;
	}

	public void P_SET_FIRST_FIELD_UI_M_AGENT_CODE_FM(ActionEvent ae){

		if(getCOMP_UI_M_AGENT_CODE_FM().getSubmittedValue() != null && getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue() != null){
			/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED*/
			
			if("".equals(getCOMP_UI_M_AGENT_CODE_FM().getSubmittedValue().toString())){
				getCOMP_UI_M_AGENT_CODE_FM().setSubmittedValue(P_SET_FIRST_FIELD(getCOMP_UI_M_AGENT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue().toString()));
			}else{
					if(!"".equals(getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue().toString())){
						compare_Datas(getCOMP_UI_M_AGENT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue().toString());
					}
			}
			/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED]*/
		}
	}
	
	public void secondFieldMethod_UI_M_AGENT_CODE_TO(ActionEvent ae){
		if(getCOMP_UI_M_AGENT_CODE_FM().getSubmittedValue() != null && getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue() != null){
				/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED*/
			
			if("".equals(getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue().toString())){
				getCOMP_UI_M_AGENT_CODE_TO().setSubmittedValue(P_SET_SECOND_FIELD(getCOMP_UI_M_AGENT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue().toString()));
			}else{
				/*if(!check_Proper_Value(getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue().toString(),"AGENT_CODE")){
//					PT_AGENT_BEAN.setSendFocus("UI_M_AGENT_CODE_TO");
				}*/
			}
				/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED]*/
		}
		L_VAL_FROM_TO(getCOMP_UI_M_AGENT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENT_CODE_TO().getSubmittedValue().toString());
	}
	public String P_SET_FIRST_FIELD(String M_FIELD_NAME,String M_FIELD_NAME2){
		if("".equals(M_FIELD_NAME)){
			M_FIELD_NAME = "0";
		}
		return M_FIELD_NAME;
	} 
	public String P_SET_SECOND_FIELD(String M_FIELD_NAME1,String M_FIELD_NAME2){
		if("".equals(M_FIELD_NAME2)){
			if(M_FIELD_NAME1.equals("0")){
				M_FIELD_NAME2 = "zzzzzzzzz";
			}else{
				M_FIELD_NAME2 = M_FIELD_NAME1;
			}
		}
		return M_FIELD_NAME2;
	}
	public boolean compare_Datas(String M_FIELD_NAME1,String M_FIELD_NAME2){
		boolean status = true;
		if(M_FIELD_NAME2.compareTo(M_FIELD_NAME1) < 0){
			status = false;
			/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				WRONG METHOD WAS CALLED*/
			getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "10064"));
			/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				WRONG METHOD WAS CALLED]*/
		}else{
			getErrorMap().clear();
		}
		return status;
	}
	public boolean L_VAL_FROM_TO (String P_FROM_CODE,String P_TO_CODE){
		if("".equals(P_FROM_CODE)){
		/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				WRONG METHOD WAS CALLED*/
			getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "80033"));
		}else{
			if(P_TO_CODE.compareTo(P_FROM_CODE) < 0){
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "80034"));
			}else{
				getErrorMap().clear();
			}
		}
		/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				WRONG METHOD WAS CALLED]*/	
		return false;
	}
	public boolean check_Proper_Value(String code_Value,String field_Name){
		boolean status = true;
		String query = "";
		if(!(code_Value.equals("0") || code_Value.equals("zzzzzzzzz"))){
			if(field_Name.equals("AGENT_CODE") || field_Name.equals("AGENCY_CODE"))
				query = "select cust_code from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND cust_code = '"+code_Value+"'";
			else if(field_Name.equals("UNIT_CODE"))
				query = "select PC_CODE,PC_BL_DESC from PM_CODES where PC_FRZ_FLAG = 'N' and pc_code ='"+code_Value+"'";
			try {
				resultSet = handler.executeSelectStatement(query, getConnection());
				if(!resultSet.next()){
					status = false;
					/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
						WRONG METHOD WAS CALLED*/
					getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "80302"));
					/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				WRONG METHOD WAS CALLED]*/	
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return status;
	}
	
	public void P_SET_FIRST_FIELD_UI_M_UNIT_CODE_FM(ActionEvent ae){
		
		/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED*/
		if(getCOMP_UI_M_UNIT_CODE_FM().getSubmittedValue() != null && getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue() != null){
			if("".equals(getCOMP_UI_M_UNIT_CODE_FM().getSubmittedValue().toString())){
				getCOMP_UI_M_UNIT_CODE_FM().setSubmittedValue(P_SET_FIRST_FIELD(getCOMP_UI_M_UNIT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue().toString()));
			}else{
					if(!"".equals(getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue().toString())){
						compare_Datas(getCOMP_UI_M_UNIT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue().toString());
					}
			}
		}
		
		/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED]*/
	}

	public void secondFieldMethod_UI_M_UNIT_CODE_TO(ActionEvent ae){
		/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED*/
		
		if(getCOMP_UI_M_UNIT_CODE_FM().getSubmittedValue() != null && getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue() != null){
			if("".equals(getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue().toString())){
				getCOMP_UI_M_UNIT_CODE_TO().setSubmittedValue(P_SET_SECOND_FIELD(getCOMP_UI_M_UNIT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue().toString()));
			}
		}
		/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED]*/
		L_VAL_FROM_TO(getCOMP_UI_M_UNIT_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_UNIT_CODE_TO().getSubmittedValue().toString());
	}
	public void P_SET_FIRST_FIELD_UI_M_AGENCY_CODE_FM(ActionEvent ae){
		/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED*/
		if(getCOMP_UI_M_AGENCY_CODE_FM().getSubmittedValue() != null && getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue() != null){
			if("".equals(getCOMP_UI_M_AGENCY_CODE_FM().getSubmittedValue().toString())){
				getCOMP_UI_M_AGENCY_CODE_FM().setSubmittedValue(P_SET_FIRST_FIELD(getCOMP_UI_M_AGENCY_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue().toString()));
			}else{
					if(!"".equals(getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue().toString())){
						compare_Datas(getCOMP_UI_M_AGENCY_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue().toString());
					}
			}
		}
		/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED]*/
	}
	
	/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED*/
	public void secondFieldMethod_UI_M_AGENCY_CODE_TO(ActionEvent ae){
		if(getCOMP_UI_M_AGENCY_CODE_FM().getSubmittedValue() != null && getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue() != null){
			if("".equals(getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue().toString())){
				getCOMP_UI_M_AGENCY_CODE_TO().setSubmittedValue(P_SET_SECOND_FIELD(getCOMP_UI_M_AGENCY_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue().toString()));
			}
		}
		L_VAL_FROM_TO(getCOMP_UI_M_AGENCY_CODE_FM().getSubmittedValue().toString(),getCOMP_UI_M_AGENCY_CODE_TO().getSubmittedValue().toString());
	}
/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				METHOD CALLED(check_proper_value()) IN ELSE PARTS IF NOT NEEDED]*/	
	
	
	
	public void UI_M_FM_DT_WHEN_VALIDATE(ActionEvent ae){
		Date from_Date = PT_AGENT_BEAN.getUI_M_FM_DT();
		Date to_Date   = PT_AGENT_BEAN.getUI_M_TO_DT();
		if(from_Date == null){
		/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
						WRONG METHOD WAS CALLED*/
			getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "90018"));
		/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				WRONG METHOD WAS CALLED]*/	
		} else{
			getErrorMap().clear();
			if(from_Date != null && to_Date != null)
				compare_Date(from_Date,to_Date);
		}
	}
	

	public void UI_M_TO_DT_WHEN_VALIDATE(ActionEvent ae){
		Date from_Date = PT_AGENT_BEAN.getUI_M_FM_DT();
		Date to_Date   = PT_AGENT_BEAN.getUI_M_TO_DT();
		if(to_Date == null){
//			[Veeramani Told to Set Default value for To Date Field is 31-Dec-2099]
			
			/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				AS DEFAULTING SUCH A LONG PERIOD IS NOT NEEDED
				AS DISCUSSED WITH VEERAGHAVAN SIR*/
			
			//getCOMP_UI_M_TO_DT().setSubmittedValue(new Date(199,11,31));
		
			/*BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				AS DEFAULTING SUCH A LONG PERIOD IS NOT NEEDED
				AS DISCUSSED WITH VEERAGHAVAN SIR]*/
		}
		if(from_Date != null && to_Date != null)
			compare_Date(from_Date,to_Date);
	}
	
	public void compare_Date(Date from_Date,Date to_Date){
		if(from_Date != null && to_Date != null){
			if(from_Date.compareTo(to_Date) > 0){
			/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
						WRONG METHOD WAS CALLED*/
				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "71145"));
				/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
				WRONG METHOD WAS CALLED]*/	
			}else{
				getErrorMap().clear();
			}
		}
	}
	
	/**
	 * This method will get connection.
	 * @return Connection.
	 */
	public Connection getConnection(){
		try {
/*			FacesContext context = FacesContext.getCurrentInstance();
			ServletContext servletContext = (ServletContext)context.getExternalContext().getContext();
			SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent)servletContext.getAttribute("connectionAgent");
			con = connectionAgent.getConnection(""+System.currentTimeMillis());
*/		
			connection = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

	
	public String  M_BUT_PROCESS_WHEN_BUTTON_PRESSED() throws Exception{
				/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
						NO NEED OF CALLING THIS METHOD AND CHANGES FOR getWarningMap()*/
				//P_SET_PARA_VALUES();
				try {
					BROK_ACCOUNTING_ENTRY();
					paramList.clear();
					connection = getConnection();
					paramList.add(new OracleParameter("in1","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_FM().toString()));
					paramList.add(new OracleParameter("in2","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_TO().toString()));
					paramList.add(new OracleParameter("in3","STRING","IN",""));
					paramList.add(new OracleParameter("in4","STRING","IN",""));
					paramList.add(new OracleParameter("in5","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_FM_DT())));//date
					paramList.add(new OracleParameter("in6","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_TO_DT())));//date
					OracleProcedureHandler ora_Handler = new OracleProcedureHandler();
					ora_Handler.execute(paramList, connection, "P9ILPK_AGENT_BENEFITS.BENEFIT_APPROVE");
					paramList.clear();
					paramList.add(new OracleParameter("in1","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_FM().toString()));
					paramList.add(new OracleParameter("in2","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_TO().toString()));
					paramList.add(new OracleParameter("in3","STRING","IN",""));
					paramList.add(new OracleParameter("in4","STRING","IN",""));
					paramList.add(new OracleParameter("in5","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_FM_DT())));//date
					paramList.add(new OracleParameter("in6","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_TO_DT())));//date
					OracleProcedureHandler ora_Handler1 = new OracleProcedureHandler();
					ora_Handler1.execute(paramList, connection, "P9ILPK_AGENT_BONUS.BONUS_APPROVAL");
					Agent_Comm_Process();
					//[Added Newly For PREMIAGDC-327842 VIJAY ANAND
					compositeAction.getPS_AGENT_COMM_VALUES_ACTION_BEAN().populateAgentCommissionValues();
					//Added Newly For PREMIAGDC-327842 VIJAY ANAND]
					getWarningMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "3083"));
					
					/*BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
							NO NEED OF CALLING THIS METHOD AND CHANGES FOR getWarningMap()]*/
				} catch (Exception e) {
					e.printStackTrace();
					//throw new Exception(e.getMessage());
					getErrorMap().put("current", e.getMessage());
				}
		
		return null;
	}
	
	
	
	public String getSubStringM_DFLT_VALUES(int startIndex,int length){
		String def_Values = session.get("GLOBAL.M_DFLT_VALUES").toString();
		String res_String = def_Values.substring(startIndex-1, (startIndex-1+length));
		while(res_String.endsWith(" ")){
			res_String = res_String.substring(0, res_String.length()-1);
		}
		return res_String;
	}
	
	public void BROK_ACCOUNTING_ENTRY() throws Exception{
		paramList.clear();
		try {
			connection = getConnection();
			paramList.add(new OracleParameter("in1","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_FM()));
			paramList.add(new OracleParameter("in2","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_TO()));
			paramList.add(new OracleParameter("in3","STRING","IN",PT_AGENT_BEAN.getUI_M_UNIT_CODE_FM()));
			paramList.add(new OracleParameter("in4","STRING","IN",PT_AGENT_BEAN.getUI_M_UNIT_CODE_TO()));
			paramList.add(new OracleParameter("in5","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENCY_CODE_FM()));
			paramList.add(new OracleParameter("in6","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENCY_CODE_TO()));
			paramList.add(new OracleParameter("in7","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_FM_DT())));//date
			paramList.add(new OracleParameter("in8","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_TO_DT())));//date
			
			OracleProcedureHandler ora_Handler = new OracleProcedureHandler();
			
				list = ora_Handler.execute(paramList, connection, "P9ILPK_BROKER_ADVANCE_PYMT.BROK_ACCOUNTING_ENTRY");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	public String format_Date(Date date){
		String result=null; 
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy");
		result = sdf.format(date).toString();
		return result;
	}
	public void Agent_Comm_Process() throws Exception{
		paramList.clear();
		try {
			connection = getConnection();
			paramList.add(new OracleParameter("in1","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_FM_DT())));//date
			paramList.add(new OracleParameter("in2","STRING","IN",format_Date(PT_AGENT_BEAN.getUI_M_TO_DT())));//date
			paramList.add(new OracleParameter("in3","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_FM().toString()));
			paramList.add(new OracleParameter("in4","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENT_CODE_TO().toString()));
			paramList.add(new OracleParameter("in5","STRING","IN",PT_AGENT_BEAN.getUI_M_UNIT_CODE_FM().toString()));
			paramList.add(new OracleParameter("in6","STRING","IN",PT_AGENT_BEAN.getUI_M_UNIT_CODE_TO().toString()));
			paramList.add(new OracleParameter("in7","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENCY_CODE_FM().toString()));
			paramList.add(new OracleParameter("in8","STRING","IN",PT_AGENT_BEAN.getUI_M_AGENCY_CODE_TO().toString()));
			paramList.add(new OracleParameter("in9","STRING","IN","N"));
			
			OracleProcedureHandler ora_Handler = new OracleProcedureHandler();
			
			list = ora_Handler.execute(paramList, connection, "Agent_Comm_Process");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public HtmlCommandButton getTestButton() {
		return testButton;
	}

	public void setTestButton(HtmlCommandButton testButton) {
		this.testButton = testButton;
	}
	
	public String getSystemDate(){
		String sysDate = "";
		try {
			String query = "SELECT TO_CHAR(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, getConnection());
			while(resultSet.next())
				sysDate = resultSet.getString(1);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				resultSet.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sysDate;
	}

	public String getM_TITLE() {
		return M_TITLE;
	}

	public void setM_TITLE(String m_title) {
		M_TITLE = m_title;
	}
	
	public void LOAD_ITEM_HINT(){
		String query1 = "SELECT LI_SYS_PARAM FROM PP_LIST_ITEM WHERE LI_MODULE_NAME = '"+session.get("GLOBAL.M_MODULE_NAME")+"' AND LI_BLOCK_NAME = M_CUR_BLOCK AND LI_ITEM_NAME = M_CUR_ITEM";
		String query2 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'BG_CLR_REQ'";
	}
	
	public List getAgentCode_M_AGENT_CODE_FM(Object obj){
		List suggesionList = new ArrayList();
		getCOMP_UI_M_AGENT_CODE_FM().setSubmittedValue(null);
		String query = null;
		try {
			if(obj.toString().equals("*")){
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND  rownum < 50 order by cust_code asc";
			}else{
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' and CUST_CODE LIKE '"+obj.toString()+"%' and rownum < 50 order by cust_code asc";
			}	
			connection = getConnection();
			
			resultSet = handler.executeSelectStatement(query,connection);
			resultSet.setFetchSize(25);
			while(resultSet.next()){
				CustomerBean cbean = new CustomerBean();
				cbean.setCUST_BL_ADDR1(resultSet.getString("cust_bl_addr1"));
				cbean.setCUST_BL_NAME(resultSet.getString("cust_bl_name"));
				cbean.setCUST_CODE(resultSet.getString("cust_code"));
				cbean.setCUST_LONG_NAME(resultSet.getString("cust_long_name"));
				cbean.setCUST_NAME(resultSet.getString("cust_name"));
				cbean.setCUST_REF_ID1(resultSet.getString("cust_ref_id1"));
				suggesionList.add(cbean);
			}
			if(suggesionList == null || suggesionList.size() == 0){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("AgentCode From", e.getMessage());
		}
		return suggesionList;
	}
	
	public List getAgentCode_M_AGENT_CODE_TO(Object obj){
		List suggesionList = new ArrayList();
		getCOMP_UI_M_AGENT_CODE_TO().setSubmittedValue(null);
		String query = null;
		try {
			if(obj.toString().equals("*")){
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND  rownum < 50 order by cust_code asc";
			}else{
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' and CUST_CODE LIKE '"+obj.toString()+"%' and rownum < 50 order by cust_code asc";
			}	
			connection = getConnection();
			
			resultSet = handler.executeSelectStatement(query,connection);
			resultSet.setFetchSize(25);
			while(resultSet.next()){
				CustomerBean cbean = new CustomerBean();
				cbean.setCUST_BL_ADDR1(resultSet.getString("cust_bl_addr1"));
				cbean.setCUST_BL_NAME(resultSet.getString("cust_bl_name"));
				cbean.setCUST_CODE(resultSet.getString("cust_code"));
				cbean.setCUST_LONG_NAME(resultSet.getString("cust_long_name"));
				cbean.setCUST_NAME(resultSet.getString("cust_name"));
				cbean.setCUST_REF_ID1(resultSet.getString("cust_ref_id1"));
				suggesionList.add(cbean);
			}
			if(suggesionList == null || suggesionList.size() == 0){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("agentCode To", e.getMessage());
		}
		return suggesionList;
	}
	public List getAgentCode_M_AGENCY_CODE_FM(Object obj){
		List suggesionList = new ArrayList();
		getCOMP_UI_M_AGENCY_CODE_FM().setSubmittedValue(null);
		String query = null;
		try {
			if(obj.toString().equals("*")){
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND  rownum < 50 order by cust_code asc";
			}else{
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' and CUST_CODE LIKE '"+obj.toString()+"%' and rownum < 50 order by cust_code asc";
			}	
			connection = getConnection();
			
			resultSet = handler.executeSelectStatement(query,connection);
			resultSet.setFetchSize(25);
			while(resultSet.next()){
				CustomerBean cbean = new CustomerBean();
				cbean.setCUST_BL_ADDR1(resultSet.getString("cust_bl_addr1"));
				cbean.setCUST_BL_NAME(resultSet.getString("cust_bl_name"));
				cbean.setCUST_CODE(resultSet.getString("cust_code"));
				cbean.setCUST_LONG_NAME(resultSet.getString("cust_long_name"));
				cbean.setCUST_NAME(resultSet.getString("cust_name"));
				cbean.setCUST_REF_ID1(resultSet.getString("cust_ref_id1"));
				suggesionList.add(cbean);
			}
			if(suggesionList == null || suggesionList.size() == 0){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("agencyCode From", e.getMessage());
		}
		return suggesionList;
	}
	public List getAgentCode_M_AGENCY_CODE_TO(Object obj){
		List suggesionList = new ArrayList();
		getCOMP_UI_M_AGENCY_CODE_TO().setSubmittedValue(null);
		String query = null;
		try {
			if(obj.toString().equals("*")){
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' AND  rownum < 50 order by cust_code asc";
			}else{
				query = "select cust_code,cust_name,cust_bl_name,cust_long_name,cust_ref_id1,cust_bl_addr1 from PM_CUSTOMER where PM_CUSTOMER.CUST_FRZ_FLAG = 'N' and CUST_CODE LIKE '"+obj.toString()+"%' and rownum < 50 order by cust_code asc";
			}	
			connection = getConnection();
			
			resultSet = handler.executeSelectStatement(query,connection);
			resultSet.setFetchSize(25);
			while(resultSet.next()){
				CustomerBean cbean = new CustomerBean();
				cbean.setCUST_BL_ADDR1(resultSet.getString("cust_bl_addr1"));
				cbean.setCUST_BL_NAME(resultSet.getString("cust_bl_name"));
				cbean.setCUST_CODE(resultSet.getString("cust_code"));
				cbean.setCUST_LONG_NAME(resultSet.getString("cust_long_name"));
				cbean.setCUST_NAME(resultSet.getString("cust_name"));
				cbean.setCUST_REF_ID1(resultSet.getString("cust_ref_id1"));
				suggesionList.add(cbean);
			}
			if(suggesionList == null || suggesionList.size() == 0){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("agencyCode To", e.getMessage());
		}
		return suggesionList;
	}

	public List getUnitCode_M_UNIT_CODE_FM(Object obj){
		try {
			if(!obj.toString().equals("0")){
				List suggestionList = new ArrayList();
				getCOMP_UI_M_UNIT_CODE_FM().setSubmittedValue(null);
				String query = null;
				if(obj.toString().equals("*")){
					query = "select PC_CODE,PC_BL_DESC from PM_CODES where PC_FRZ_FLAG = 'N' and rownum < 50 order by PC_CODE asc";
				}else{
					query = "select PC_CODE,PC_BL_DESC from PM_CODES where PC_FRZ_FLAG = 'N' and pc_code like '"+obj.toString()+"%' and rownum < 50 order by PC_CODE asc";
				}
				connection = getConnection();
				resultSet = handler.executeSelectStatement(query, connection);
				resultSet.setFetchSize(25);
				while(resultSet.next()){
					CustomerBean cbean = new CustomerBean();
					cbean.setPC_CODE(resultSet.getString("PC_CODE"));
					cbean.setPC_BL_DESC(resultSet.getString("PC_BL_DESC"));
					suggestionList.add(cbean);
				}
				if(suggestionList == null || suggestionList.size() == 0){
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "1010"));
				}
				resultSet.close();
				return suggestionList;
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("unitCodeFm", e.getMessage());
		}
		return null;
	}
	public List getUnitCode_M_UNIT_CODE_TO(Object obj){
		List suggestionList = new ArrayList();
		getCOMP_UI_M_UNIT_CODE_TO().setSubmittedValue(null);
		String query = null;
		try {
			if(obj.toString().equals("*")){
				query = "select PC_CODE,PC_BL_DESC from PM_CODES where PC_FRZ_FLAG = 'N' and rownum < 50 order by PC_CODE asc";
			}else{
				query = "select PC_CODE,PC_BL_DESC from PM_CODES where PC_FRZ_FLAG = 'N' and pc_code like '"+obj.toString()+"%' and rownum < 50 order by PC_CODE asc";
			}
			connection = getConnection();
			resultSet = handler.executeSelectStatement(query, connection);
			resultSet.setFetchSize(25);
			while(resultSet.next()){
				CustomerBean cbean = new CustomerBean();
				cbean.setPC_CODE(resultSet.getString("PC_CODE"));
				cbean.setPC_BL_DESC(resultSet.getString("PC_BL_DESC"));
				suggestionList.add(cbean);
			}
			if(suggestionList == null || suggestionList.size() == 0){
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "1010"));
			}
			resultSet.close();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
    				e.getMessage());
    		getErrorMap().put("unitCodeTo", e.getMessage());
		}
		return suggestionList;
	}

	public void PILP022_WHEN_NEW_ITEM_INSTANCE(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            LOAD_ITEM_HINT.LOAD_ITEM_HINT();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/
	}
	public void PILP022_WHEN_NEW_BLOCK_INSTANCE(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            CHECK_BLK_NAVG.CHECK_BLK_NAVG();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/
	}
	public void PILP022_WHEN_CREATE_RECORD(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            LOAD_DFLT_VALUES.LOAD_DFLT_VALUES();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/
	}
	
	public void PILP022_WHEN_WINDOW_ACTIVATED(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            if(:SYSTEM.EVENT_WINDOW=="REP_ADV_OPTIONS")
            {
                READ_IMAGE_FILE.READ_IMAGE_FILE("PORTRAIT.BMP","BMP","REP_DFLT.M_IMG_PORTRAIT");
                READ_IMAGE_FILE.READ_IMAGE_FILE("LAND.BMP","BMP","REP_DFLT.M_IMG_LAND");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/
	}
	
	public void PILP022_KEY_DUP_ITEM(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            KEY_DUPFLD.KEY_DUPFLD();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/
	}
	public void PILP022_KEY_CLRFRM(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            KEY_CLRFRM.KEY_CLRFRM();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/
	}
	public void PILP022_KEY_CREREC(){
/*        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            KEY_CREREC.KEY_CREREC();
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
*/
	}
	
	public void redirectFocus(ActionEvent ae){
		PT_AGENT_BEAN.setSendFocus("UI_M_AGENT_CODE_FM");
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void UI_M_FM_DT_WHEN_VALIDATE_Validator(FacesContext context, UIComponent component,
			Object value){
		CommonUtils.clearMaps(this);
		try {
			Date from_Date = PT_AGENT_BEAN.getUI_M_FM_DT();
			Date to_Date   = PT_AGENT_BEAN.getUI_M_TO_DT();
			if(from_Date == null){
			/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
							WRONG METHOD WAS CALLED*/
//				getErrorMap().put("current", Messages.getString("com.iii.premia.common.errorUtil.PELErrorMessages", "90018"));
			/* BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
					WRONG METHOD WAS CALLED]*/	
			} else{
				getErrorMap().clear();
				if(from_Date != null && to_Date != null)
					compare_Date(from_Date,to_Date);
			}
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}

	public void UI_M_TO_DT_WHEN_VALIDATE_Validator(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		CommonUtils.clearMaps(this);
		try {
			Date from_Date = PT_AGENT_BEAN.getUI_M_FM_DT();
			Date to_Date   = PT_AGENT_BEAN.getUI_M_TO_DT();
			if(to_Date == null){
//				[Veeramani Told to Set Default value for To Date Field is 31-Dec-2099]
				
				/*[ BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
					AS DEFAULTING SUCH A LONG PERIOD IS NOT NEEDED
					AS DISCUSSED WITH VEERAGHAVAN SIR*/
				
				//getCOMP_UI_M_TO_DT().setSubmittedValue(new Date(199,11,31));
			
				/*BugId:PREMIAGDC-INTERNALFIX-0015 VARUN DM 03-FEB-09 
					AS DEFAULTING SUCH A LONG PERIOD IS NOT NEEDED
					AS DISCUSSED WITH VEERAGHAVAN SIR]*/
			}
			if(from_Date != null && to_Date != null)
				compare_Date(from_Date,to_Date);
			
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), component.getParent().getId(),
						getWarningMap());
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
}
