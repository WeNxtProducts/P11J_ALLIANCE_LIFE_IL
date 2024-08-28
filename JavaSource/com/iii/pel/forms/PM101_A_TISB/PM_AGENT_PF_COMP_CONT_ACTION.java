package com.iii.pel.forms.PM101_A_TISB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PM_AGENT_PF_COMP_CONT_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_APCC_MKT_CODE_LABEL;

	private HtmlInputText COMP_APCC_MKT_CODE;

	private HtmlOutputLabel COMP_UI_M_APCC_MKT_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_APCC_MKT_CODE_DESC;

	private HtmlOutputLabel COMP_APCC_RANK_CODE_LABEL;

	private HtmlInputText COMP_APCC_RANK_CODE;

	private HtmlOutputLabel COMP_UI_M_APCC_RANK_CODE_DESC_LABEL;

	private HtmlInputText COMP_UI_M_APCC_RANK_CODE_DESC;

	private HtmlOutputLabel COMP_APCC_PROD_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_APCC_PROD_TYPE;

	private HtmlOutputLabel COMP_APCC_CONT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_APCC_CONT_TYPE;

	private HtmlOutputLabel COMP_APCC_CONT_FM_LABEL;

	private HtmlInputText COMP_APCC_CONT_FM;

	private HtmlOutputLabel COMP_APCC_CONT_TO_LABEL;

	private HtmlInputText COMP_APCC_CONT_TO;

	private HtmlOutputLabel COMP_APCC_RATE_LABEL;

	private HtmlInputText COMP_APCC_RATE;

	private HtmlOutputLabel COMP_APCC_RATE_PER_LABEL;

	private HtmlInputText COMP_APCC_RATE_PER;

	private HtmlOutputLabel COMP_APCC_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_APCC_EFF_FM_DT;

	private HtmlOutputLabel COMP_APCC_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_APCC_EFF_TO_DT;

	private HtmlCommandButton COMP_UI_M_APCC_MKT_CODE_LOV;

	private HtmlCommandButton COMP_UI_M_APCC_RANK_CODE_LOV;

	private PM_AGENT_PF_COMP_CONT PM_AGENT_PF_COMP_CONT_BEAN;
	
	private HtmlCommandButton dum;
	
	private boolean update;
	
	public PM_AGENT_PF_COMP_CONT_HELPER helper;
	
	Map<String, Object> session = null;
	
	List<APCCSuggestionBean> mktCodeLOV = new ArrayList<APCCSuggestionBean>();
	List<APCCSuggestionBean> rankCodeLOV = new ArrayList<APCCSuggestionBean>();
	private ArrayList<SelectItem> contribTypeList;
	private ArrayList<SelectItem> productTypeList;
	
	
	public HtmlCommandButton getDum() {
		return dum;
	}

	public void setDum(HtmlCommandButton dum) {
		this.dum = dum;
	}

	public PM_AGENT_PF_COMP_CONT_ACTION() {
		helper = new PM_AGENT_PF_COMP_CONT_HELPER();
		PM_AGENT_PF_COMP_CONT_BEAN = new PM_AGENT_PF_COMP_CONT();
		contribTypeList = new PM101_A_TISB_SearchDelegate().selectValueForComboBox("PM101_A_TISB",
				"PM_AGENT_PF_COMP_CONT", "PM_AGENT_PF_COMP_CONT.APCC_CONT_TYPE");
		productTypeList = new PM101_A_TISB_SearchDelegate().selectValueForComboBox("PM101_A_TISB",
			"PM_AGENT_PF_COMP_CONT", "PM_AGENT_PF_COMP_CONT.APCC_PROD_TYPE");
		preForm();
	}

	public HtmlOutputLabel getCOMP_APCC_MKT_CODE_LABEL() {
		return COMP_APCC_MKT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APCC_MKT_CODE() {
		return COMP_APCC_MKT_CODE;
	}

	public void setCOMP_APCC_MKT_CODE_LABEL(HtmlOutputLabel COMP_APCC_MKT_CODE_LABEL) {
		this.COMP_APCC_MKT_CODE_LABEL = COMP_APCC_MKT_CODE_LABEL;
	}

	public void setCOMP_APCC_MKT_CODE(HtmlInputText COMP_APCC_MKT_CODE) {
		this.COMP_APCC_MKT_CODE = COMP_APCC_MKT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_APCC_MKT_CODE_DESC_LABEL() {
		return COMP_UI_M_APCC_MKT_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_APCC_MKT_CODE_DESC() {
		return COMP_UI_M_APCC_MKT_CODE_DESC;
	}

	public void setCOMP_UI_M_APCC_MKT_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_APCC_MKT_CODE_DESC_LABEL) {
		this.COMP_UI_M_APCC_MKT_CODE_DESC_LABEL = COMP_UI_M_APCC_MKT_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_APCC_MKT_CODE_DESC(HtmlInputText COMP_UI_M_APCC_MKT_CODE_DESC) {
		this.COMP_UI_M_APCC_MKT_CODE_DESC = COMP_UI_M_APCC_MKT_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_APCC_RANK_CODE_LABEL() {
		return COMP_APCC_RANK_CODE_LABEL;
	}

	public HtmlInputText getCOMP_APCC_RANK_CODE() {
		return COMP_APCC_RANK_CODE;
	}

	public void setCOMP_APCC_RANK_CODE_LABEL(HtmlOutputLabel COMP_APCC_RANK_CODE_LABEL) {
		this.COMP_APCC_RANK_CODE_LABEL = COMP_APCC_RANK_CODE_LABEL;
	}

	public void setCOMP_APCC_RANK_CODE(HtmlInputText COMP_APCC_RANK_CODE) {
		this.COMP_APCC_RANK_CODE = COMP_APCC_RANK_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_APCC_RANK_CODE_DESC_LABEL() {
		return COMP_UI_M_APCC_RANK_CODE_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_APCC_RANK_CODE_DESC() {
		return COMP_UI_M_APCC_RANK_CODE_DESC;
	}

	public void setCOMP_UI_M_APCC_RANK_CODE_DESC_LABEL(HtmlOutputLabel COMP_UI_M_APCC_RANK_CODE_DESC_LABEL) {
		this.COMP_UI_M_APCC_RANK_CODE_DESC_LABEL = COMP_UI_M_APCC_RANK_CODE_DESC_LABEL;
	}

	public void setCOMP_UI_M_APCC_RANK_CODE_DESC(HtmlInputText COMP_UI_M_APCC_RANK_CODE_DESC) {
		this.COMP_UI_M_APCC_RANK_CODE_DESC = COMP_UI_M_APCC_RANK_CODE_DESC;
	}

	public HtmlOutputLabel getCOMP_APCC_PROD_TYPE_LABEL() {
		return COMP_APCC_PROD_TYPE_LABEL;
	}
 

	public HtmlSelectOneMenu getCOMP_APCC_PROD_TYPE() {
	    return COMP_APCC_PROD_TYPE;
	}

	public void setCOMP_APCC_PROD_TYPE(HtmlSelectOneMenu comp_apcc_prod_type) {
	    COMP_APCC_PROD_TYPE = comp_apcc_prod_type;
	}

	public void setCOMP_APCC_PROD_TYPE_LABEL(HtmlOutputLabel COMP_APCC_PROD_TYPE_LABEL) {
		this.COMP_APCC_PROD_TYPE_LABEL = COMP_APCC_PROD_TYPE_LABEL;
	}

	 
	public HtmlOutputLabel getCOMP_APCC_CONT_TYPE_LABEL() {
		return COMP_APCC_CONT_TYPE_LABEL;
	}

	
	public void setCOMP_APCC_CONT_TYPE_LABEL(HtmlOutputLabel COMP_APCC_CONT_TYPE_LABEL) {
		this.COMP_APCC_CONT_TYPE_LABEL = COMP_APCC_CONT_TYPE_LABEL;
	}

	
	public HtmlOutputLabel getCOMP_APCC_CONT_FM_LABEL() {
		return COMP_APCC_CONT_FM_LABEL;
	}

	public HtmlInputText getCOMP_APCC_CONT_FM() {
		return COMP_APCC_CONT_FM;
	}

	public void setCOMP_APCC_CONT_FM_LABEL(HtmlOutputLabel COMP_APCC_CONT_FM_LABEL) {
		this.COMP_APCC_CONT_FM_LABEL = COMP_APCC_CONT_FM_LABEL;
	}

	public void setCOMP_APCC_CONT_FM(HtmlInputText COMP_APCC_CONT_FM) {
		this.COMP_APCC_CONT_FM = COMP_APCC_CONT_FM;
	}

	public HtmlOutputLabel getCOMP_APCC_CONT_TO_LABEL() {
		return COMP_APCC_CONT_TO_LABEL;
	}

	public HtmlInputText getCOMP_APCC_CONT_TO() {
		return COMP_APCC_CONT_TO;
	}

	public void setCOMP_APCC_CONT_TO_LABEL(HtmlOutputLabel COMP_APCC_CONT_TO_LABEL) {
		this.COMP_APCC_CONT_TO_LABEL = COMP_APCC_CONT_TO_LABEL;
	}

	public void setCOMP_APCC_CONT_TO(HtmlInputText COMP_APCC_CONT_TO) {
		this.COMP_APCC_CONT_TO = COMP_APCC_CONT_TO;
	}

	public HtmlOutputLabel getCOMP_APCC_RATE_LABEL() {
		return COMP_APCC_RATE_LABEL;
	}

	public HtmlInputText getCOMP_APCC_RATE() {
		return COMP_APCC_RATE;
	}

	public void setCOMP_APCC_RATE_LABEL(HtmlOutputLabel COMP_APCC_RATE_LABEL) {
		this.COMP_APCC_RATE_LABEL = COMP_APCC_RATE_LABEL;
	}

	public void setCOMP_APCC_RATE(HtmlInputText COMP_APCC_RATE) {
		this.COMP_APCC_RATE = COMP_APCC_RATE;
	}

	public HtmlOutputLabel getCOMP_APCC_RATE_PER_LABEL() {
		return COMP_APCC_RATE_PER_LABEL;
	}

	public HtmlInputText getCOMP_APCC_RATE_PER() {
		return COMP_APCC_RATE_PER;
	}

	public void setCOMP_APCC_RATE_PER_LABEL(HtmlOutputLabel COMP_APCC_RATE_PER_LABEL) {
		this.COMP_APCC_RATE_PER_LABEL = COMP_APCC_RATE_PER_LABEL;
	}

	public void setCOMP_APCC_RATE_PER(HtmlInputText COMP_APCC_RATE_PER) {
		this.COMP_APCC_RATE_PER = COMP_APCC_RATE_PER;
	}

	public HtmlOutputLabel getCOMP_APCC_EFF_FM_DT_LABEL() {
		return COMP_APCC_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_APCC_EFF_FM_DT() {
		return COMP_APCC_EFF_FM_DT;
	}

	public void setCOMP_APCC_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_APCC_EFF_FM_DT_LABEL) {
		this.COMP_APCC_EFF_FM_DT_LABEL = COMP_APCC_EFF_FM_DT_LABEL;
	}

	public void setCOMP_APCC_EFF_FM_DT(HtmlCalendar COMP_APCC_EFF_FM_DT) {
		this.COMP_APCC_EFF_FM_DT = COMP_APCC_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_APCC_EFF_TO_DT_LABEL() {
		return COMP_APCC_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_APCC_EFF_TO_DT() {
		return COMP_APCC_EFF_TO_DT;
	}

	public void setCOMP_APCC_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_APCC_EFF_TO_DT_LABEL) {
		this.COMP_APCC_EFF_TO_DT_LABEL = COMP_APCC_EFF_TO_DT_LABEL;
	}

	public void setCOMP_APCC_EFF_TO_DT(HtmlCalendar COMP_APCC_EFF_TO_DT) {
		this.COMP_APCC_EFF_TO_DT = COMP_APCC_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_APCC_MKT_CODE_LOV() {
		return COMP_UI_M_APCC_MKT_CODE_LOV;
	}

	public void setCOMP_UI_M_APCC_MKT_CODE_LOV(HtmlCommandButton COMP_UI_M_APCC_MKT_CODE_LOV) {
		this.COMP_UI_M_APCC_MKT_CODE_LOV = COMP_UI_M_APCC_MKT_CODE_LOV;
	}

	public HtmlCommandButton getCOMP_UI_M_APCC_RANK_CODE_LOV() {
		return COMP_UI_M_APCC_RANK_CODE_LOV;
	}

	public void setCOMP_UI_M_APCC_RANK_CODE_LOV(HtmlCommandButton COMP_UI_M_APCC_RANK_CODE_LOV) {
		this.COMP_UI_M_APCC_RANK_CODE_LOV = COMP_UI_M_APCC_RANK_CODE_LOV;
	}

	public PM_AGENT_PF_COMP_CONT getPM_AGENT_PF_COMP_CONT_BEAN() {
		return PM_AGENT_PF_COMP_CONT_BEAN;
	}

	public void setPM_AGENT_PF_COMP_CONT_BEAN(PM_AGENT_PF_COMP_CONT PM_AGENT_PF_COMP_CONT_BEAN) {
		this.PM_AGENT_PF_COMP_CONT_BEAN = PM_AGENT_PF_COMP_CONT_BEAN;
	}
	
	public String preForm(){
		ArrayList<OracleParameter> list =null;
		 
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
				
		System.out.println("PT_IL_RI_DETL_ACTION.preForm() \n--------------- OUTPUTPARAM -------------------\n"+list+"\n----------------");
		STD_PRE_FORM();

		ControlBean ctrlbean = CommonUtils.getControlBean();
		String M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new Date();
		if(!isUpdate()){
		blockWhenCreateRecord();
		}
		//getDum().setDisabled(true);
		return null;
	}
	
	
	
	public void STD_PRE_FORM(){
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_GOFLD_NAME("NULL");
		/** GLOBAL.M_MODULE_NAME IS ADDED IN ORDER TO QUERY HINT DETAILS IN RECORD GROUP **/
		/* M_MODULE_NAME := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME) ;
   COPY(M_MODULE_NAME,'GLOBAL.M_MODULE_NAME') ;
   M_TITLE:= NAME_IN('CTRL.M_USER_ID') ||'                 '||NAME_IN('CTRL.M_SCR_NAME')||'          '||TO_CHAR(SYSDATE,'DD/MM/YY');
   SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
   HIDE_VIEW('ABOUT');
   M_FIRST_BLOCK := GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY(
                         CURRENT_FORM_NAME), FIRSTBLOCK) ;

   LOOP
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,INSERT_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),1,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, INSERT_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,UPDATE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),2,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, UPDATE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      IF GET_BLOCK_PROPERTY(M_FIRST_BLOCK,DELETE_ALLOWED) = 'TRUE' THEN
         IF SUBSTR(NAME_IN('GLOBAL.M_PRIVILEGE'),3,1) = 'Y' THEN
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_TRUE) ;
         ELSE
            SET_BLOCK_PROPERTY(M_FIRST_BLOCK, DELETE_ALLOWED, PROPERTY_FALSE) ;
         END IF ;
      END IF;
      M_FIRST_BLOCK := GET_BLOCK_PROPERTY(M_FIRST_BLOCK, NEXTBLOCK) ;
      IF M_FIRST_BLOCK IN ('DUAL','CTRL','BUTTON_PALETTE') THEN
         EXIT ;
      END IF ;
   END LOOP ;

   RG_ID	:= FIND_GROUP('RG_HINT') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   RG_ID	:= FIND_GROUP('RG_ALERT_MSG') ;
   IF ID_NULL(RG_ID) THEN
      NULL ;
   ELSE
      M_QUERY_OK := POPULATE_GROUP(RG_ID) ;
   END IF ;
   LOAD_BP;
   ENABLE_BUTTONS ;
   IF M_MODULE_NAME NOT LIKE 'GNMNF001%' THEN
      LOAD_BALOON_LABEL;
   END IF;
END;*/
		
	}
	
	
	public void blockWhenCreateRecord(){
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_PROD_TYPE("P");
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_CONT_TYPE("SPK");
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_EFF_FM_DT(new Date());
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_EFF_TO_DT(new Date());
		
		/*getCOMP_APCC_PROD_TYPE().setSubmittedValue(null);
		getCOMP_APCC_CONT_TYPE().setSubmittedValue(null);
		getCOMP_APCC_EFF_FM_DT().setSubmittedValue(null);
		getCOMP_APCC_EFF_TO_DT().setSubmittedValue(null);*/
	}
	
	
	
	public String fetch() throws SQLException{
		System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.fetch()---ENTERED FETCH----");
		Connection con = getConnection();
		SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		List recordList = null;
		try{
		recordList =  getHandler().fetch("select ROWID,PM_AGENT_PF_COMP_CONT.* from PM_AGENT_PF_COMP_CONT", "com.iii.pel.forms.PM101_A_TISB.PM_AGENT_PF_COMP_CONT",con);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		if(!recordList.isEmpty()){
		PM_AGENT_PF_COMP_CONT fetchRecord = (PM_AGENT_PF_COMP_CONT)recordList.get(0);
		String dateString = date.format(fetchRecord.getAPCC_EFF_FM_DT());
		
		System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.fetch()------select-----["+fetchRecord.getAPCC_EFF_FM_DT()+"]-------["+dateString+"]");
		this.setPM_AGENT_PF_COMP_CONT_BEAN(fetchRecord);
		getCOMP_APCC_CONT_FM().setSubmittedValue(String.valueOf(fetchRecord.getAPCC_CONT_FM()));
		getCOMP_APCC_CONT_TO().setSubmittedValue(String.valueOf(fetchRecord.getAPCC_CONT_TO()));
		getCOMP_APCC_CONT_TYPE().setSubmittedValue(fetchRecord.getAPCC_CONT_TYPE());
		getCOMP_APCC_EFF_FM_DT().setSubmittedValue(date.format(fetchRecord.getAPCC_EFF_FM_DT()));
		getCOMP_APCC_EFF_TO_DT().setSubmittedValue(date.format(fetchRecord.getAPCC_EFF_TO_DT()));
		getCOMP_APCC_MKT_CODE().setSubmittedValue(fetchRecord.getAPCC_MKT_CODE());
		getCOMP_APCC_PROD_TYPE().setSubmittedValue(fetchRecord.getAPCC_PROD_TYPE());
		getCOMP_APCC_RANK_CODE().setSubmittedValue(fetchRecord.getAPCC_RANK_CODE());
		getCOMP_APCC_RATE().setSubmittedValue(String.valueOf(fetchRecord.getAPCC_RATE()));
		getCOMP_APCC_RATE_PER().setSubmittedValue(String.valueOf(fetchRecord.getAPCC_RATE_PER()));
		
		}
		popMktCodeDesc();
		popRankCodeDesc();
				
		return null;
	}
	
	
public void deleteRecord() {
		CommonUtils.clearMaps(this);
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		String currentMode = (String)sessionMap.get("CURRENT_MODE");
		Connection con =getConnection();
		System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.deleteRecord()--CURRENT MODE--["+currentMode+"]---["+con+"]");
		try{
			String rowid = getPM_AGENT_PF_COMP_CONT_BEAN().getROWID();
			System.out.println("ROWID === "+rowid);
			if(rowid != null || !rowid.equals("")) {
				int rowDeleted = getHandler().executeDelete(getPM_AGENT_PF_COMP_CONT_BEAN(), con);
				con.commit();
				System.out.println("rOWS DELETD "+rowDeleted);
			}else {
				System.out.println("No row id to delete");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			try {
				con.rollback();
			}catch(SQLException se) {
				se.printStackTrace();
			}
		}
		
	}





public String saveRecord() {
	CommonUtils.clearMaps(this);
    Connection con = null;
	try{
		CRUDHandler handler = getHandler();
		  con = getConnection();
		String rowId = getPM_AGENT_PF_COMP_CONT_BEAN().getROWID();
		if((rowId != null) && (!"".equals(rowId))) {
			preInsert();
			int rowsUpdated = handler.executeUpdate(PM_AGENT_PF_COMP_CONT_BEAN, con);
			con.commit();
			if(rowsUpdated>0)
			{
				getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update"));
				getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$update"));
	
			}
		}else {
			if( rowId == null || "".equals(rowId)) {
				preInsert();
				int  rowsUpdated = handler.executeInsert(PM_AGENT_PF_COMP_CONT_BEAN, con);
				con.commit();
				if(rowsUpdated>0)
				{
					getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save"));
					getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "errorPanel$message$save"));
				}
			
			}
		}
	}catch(Exception e) {
		e.printStackTrace();
		getErrorMap().put("current", e.getMessage());
		getErrorMap().put("DUMMY", e.getMessage());
	}
	return null;
	}

	
	public List<APCCSuggestionBean> popLov4MktCode(Object event) {
		String suggestQuery = null;
		String pc_type = "MKTCODE";
		String textEntered = event.toString();
		ResultSet rsSug=null;
		mktCodeLOV.clear();
		if(event.toString().equals("*")){
			suggestQuery="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE'";
		}
		else
		{
			System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.popLov4MktCode()------------------LOV------------");
			suggestQuery="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' and PC_CODE like '"+textEntered+"%'";
		}
		
		try{
		
		 rsSug = getHandler().executeSelectStatement(suggestQuery, getConnection());
		
		while(rsSug.next()){
		
			APCCSuggestionBean sug1bean = new APCCSuggestionBean();
			sug1bean.setLOV_APCC_MKT_CODE(rsSug.getString(1));
			sug1bean.setLOV_APCC_MKT_CODE_DESC(rsSug.getString(2));
			mktCodeLOV.add(sug1bean);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				
				rsSug.close();
			}
			catch (Exception ev) {
				ev.printStackTrace();
			}
		}
		return mktCodeLOV;
	} 
	
	
	
	public String popMktCodeDesc()throws SQLException {
		
		
		ResultSet rs =null;
		String mktDesc=null;
		String codeValue= getCOMP_APCC_MKT_CODE().getSubmittedValue().toString();
		if(!codeValue.equals("")|| codeValue!=null){
		System.out.println("PM_AGENT_PF_SETUP_ACTION.popMktCodeDesc()----------------------------["+(getCOMP_APCC_MKT_CODE()).getSubmittedValue().toString()+"]");
		String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'MKTCODE' and PC_CODE ='"+
							codeValue+"'";
				
		 rs = getHandler().executeSelectStatement(desc, getConnection());
		if(rs.next()){
			mktDesc = rs.getString(1);
			getCOMP_UI_M_APCC_MKT_CODE_DESC().setSubmittedValue(mktDesc);
		}else{
			
			//WHEN-VALIDATE-ITEM
			/*STD_MESSAGE_ROUTINE(80223,:CTRL.M_LANG_CODE);   
			RAISE FORM_TRIGGER_FAILURE;*/
		}
		
		rs.close();
		}
		return mktDesc;
		
		/*String mktDesc=null;
		String codeValue = (String)getCOMP_APCC_MKT_CODE().getSubmittedValue();
		if(!codeValue.equals("")){
			Iterator<APCCSuggestionBean> iter =mktCodeLOV.iterator();
			while(iter.hasNext()){
				APCCSuggestionBean sugBean = (APCCSuggestionBean)iter.next();
				if(codeValue.equals(sugBean.getLOV_APCC_MKT_CODE())){
					
					mktDesc = sugBean.getLOV_APCC_MKT_CODE_DESC();
					System.out
							.println("PM_AGENT_PF_COMP_CONT_ACTION.popMktCodeDesc()-------------------["+mktDesc+"]");
					getCOMP_UI_M_APCC_MKT_CODE_DESC().setSubmittedValue(mktDesc);
				}
				
			}
		}
		return mktDesc;*/
		
	}
		
	public List<APCCSuggestionBean> popLov4RankCode(Object event) {
		String suggestQuery = null;
		String pc_type = "AGNRANK";
		String textEntered = event.toString();
		ResultSet rsSug=null;
		rankCodeLOV.clear();
		
		if(event.toString().equals("*")){
			suggestQuery="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK'";
		}
		else
		{
			suggestQuery="SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' and PC_CODE like '"+textEntered+"%'";
		}
		
		try{
			System.out
					.println("PM_AGENT_PF_COMP_CONT_ACTION.popLov4RankCode()----["+suggestQuery+"]");
		
		 rsSug = getHandler().executeSelectStatement(suggestQuery, getConnection());
		
		while(rsSug.next()){
		
			APCCSuggestionBean sug1bean = new APCCSuggestionBean();
			sug1bean.setLOV_APCC_RANK_CODE(rsSug.getString(1));
			sug1bean.setLOV_APCC_RANK_CODE_DESC(rsSug.getString(2));
			rankCodeLOV.add(sug1bean);
		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				
				rsSug.close();
			}
			catch (Exception ev) {
				ev.printStackTrace();
			}
		}
		return rankCodeLOV;
	} 
	
	
	
	public String popRankCodeDesc(){
			
		ResultSet rs=null;
		String rankDesc=null;
		String codeValue =getCOMP_APCC_RANK_CODE().getSubmittedValue().toString();
		if(!codeValue.equals("")|| codeValue!=null){
		String desc = "SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE = 'AGNRANK' and PC_CODE ='"+
		getCOMP_APCC_RANK_CODE().getSubmittedValue().toString()+"'";
try{
		rs = getHandler().executeSelectStatement(desc, getConnection());
		if(rs.next()){
			rankDesc=rs.getString(1);
			getCOMP_UI_M_APCC_RANK_CODE_DESC().setSubmittedValue(rankDesc);
		}else{
			//WHEN-VALIDATE-ITEM
			/*STD_MESSAGE_ROUTINE(80223,:CTRL.M_LANG_CODE);   
			RAISE FORM_TRIGGER_FAILURE;*/
		}
}catch (Exception e) {
	e.printStackTrace();
}
		finally{
			try{
				rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			}
		}
		
		return rankDesc;
		/*String rankDesc=null;
		String codeValue = (String)getCOMP_APCC_RANK_CODE().getSubmittedValue();
		if(!codeValue.equals("")){
			Iterator<APCCSuggestionBean> iter =rankCodeLOV.iterator();
			while(iter.hasNext()){
				APCCSuggestionBean sugBean = (APCCSuggestionBean)iter.next();
				if(codeValue.equals(sugBean.getLOV_APCC_RANK_CODE())){
					
					rankDesc = sugBean.getLOV_APCC_RANK_CODE_DESC();
					getCOMP_UI_M_APCC_RANK_CODE_DESC().setSubmittedValue(rankDesc);
				}
				
			}
		}
		
		
		return rankDesc;*/
		
		
		
	}
	
	
	public void preInsert( )throws Exception{
		
	    if(PM_AGENT_PF_COMP_CONT_BEAN.getROWID() == null){
		PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_CR_UID(new CommonUtils().getControlBean().getM_USER_ID());
	  	 PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
	    }else{
	  	 PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_UPD_UID(new CommonUtils().getControlBean().getM_USER_ID());
	  	 PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_UPD_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
	    }
		String TEMPID = new PM101_A_TISB_SearchDelegate().duplicateCheck(PM_AGENT_PF_COMP_CONT_BEAN);
		if(new CommonUtils().isDuplicate(PM_AGENT_PF_COMP_CONT_BEAN.getROWID(), TEMPID))
		{
			throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,"60018"));
		}
		
	}
	
	
	//*****************************Error Handling**********************************************
	
	/*public String getErrorMessages() {
		String messageList;
		if((errorMap == null) || (errorMap.size()== 0)){
			messageList = "";
		}else{
			Map<String,String> error = new HashMap<String, String>();
			error.putAll(errorMap);
			error.remove("current");
			messageList = "<FONT SIZE=1><UL>\n";
			for(String message:error.values()){
	
				messageList = messageList+"<LI>"+message+"\n";
			}
			messageList = messageList + "</UL></FONT>\n"; 
		}
	
		return messageList;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
	
	private void setErrorMessage(FacesContext fc, UIInput input, String key) {
		// set errorMessage to the first message for the zip field
		Iterator it = fc.getMessages(input.getClientId(fc));
		if (it.hasNext()) {
			FacesMessage facesMessage = (FacesMessage) it.next();
			errorMap.put(key, facesMessage.getSummary());
			errorMap.put("current", facesMessage.getSummary());

		}
	}
	
	public Map<String, String> getWarningMap() {		
		return warningMap;
	}

	public void setWarningMap(Map<String, String> warningMap) {
		this.warningMap = warningMap;
	}

	public String getWarningMessages() {
		String messageList;
		//System.out.println("GetWarning Message Called");
		//System.out.println("Warning MAP Size"+warningMap.size());
		if((warningMap == null) || (warningMap.size()== 0)){
			messageList = "";
		}else{
			//Map<String,String> warning = new HashMap<String, String>();
			//System.out.println("WARNING***"+warningMap.values());
			//warning.putAll(warningMap);
			warningMap.remove("PM101_A_TISB_PM_AGENT_PF_COMP_CONT_ACTIONcurrent");		
			messageList = "<FONT SIZE=1><UL>\n";
			for(String message:warningMap.values()){	
				messageList = messageList+"<LI>"+message+"\n";
				//System.out.println("message list in for"+messageList);
			}
			messageList = messageList + "</UL></FONT>\n"; 
		}
		//System.out.println(messageList);
		return messageList;
		
	}

	public void setWarningMessages(String warningMessages) {
		this.warningMessages = warningMessages;
	}*/
	public void fireFieldValidation(ActionEvent event){
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput)event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		
	}
	
	public void validateAPCC_EFF_FM_DT(FacesContext fc,UIComponent component, Object value)throws ValidatorException{
		
		/*HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date fromDate = htmlCalendar.getAsDate(htmlCalendar
				.getSubmittedValue());*/
		if(value != null)
		{
			Date fromDate = (Date)value;
			PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_EFF_FM_DT(fromDate);
			if(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_TO_DT()!=null)
			{
				
				System.out.println("To date::::"+PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_TO_DT()+" from "+fromDate);
				if(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_FM_DT().after(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_TO_DT()))
				{
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71145"));
				}
			}
		}
	}

	
	public void validateAPCC_EFF_TO_DT(FacesContext fc,UIComponent component, Object value)throws ValidatorException{
		System.out.println("FROM DATE:::"+PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_FM_DT()+" TO DATE::::"+PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_TO_DT());
		PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_EFF_TO_DT((Date)value);
		if(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_FM_DT()!=null&&PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_TO_DT()!=null)
		{
			if(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_FM_DT().after(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_TO_DT()))
			{
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71145"));
			}
		}
		
		
		/*HtmlCalendar htmlCalendar = (HtmlCalendar) component;
		Date toDate = htmlCalendar.getAsDate(htmlCalendar
				.getSubmittedValue());
		if(value != null)
		{
			if(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_FM_DT()!=null)
			{
				System.out.println("From date::::"+PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_FM_DT()+" to "+toDate);
				if(toDate.before(PM_AGENT_PF_COMP_CONT_BEAN.getAPCC_EFF_FM_DT()))
				{
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71145"));
				}
			}
		}
*/	}

	public void validateDate(FacesContext fc,UIComponent component, Object value)throws ValidatorException{
		Date fromDate = (java.util.Date)((UIInput)component).getSubmittedValue();
		Date toDate = getPM_AGENT_PF_COMP_CONT_BEAN().getAPCC_EFF_TO_DT();
		System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.validateDate()!!!!!!!!!!!!!!FROM DATE--["+((UIInput)component).getSubmittedValue()+"]--TO DATE--["+toDate+"]");
		if(fromDate!=null && !fromDate.equals("")){
			System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.validateDate()--------------------");
		if(fromDate.after(toDate)){
			throw new ValidatorException(new FacesMessage(" Effective From Date Should Be less than Effective To Date"));
		
			}
		}
		
	}
	
	  public void validatorContrFrom(FacesContext fc,UIComponent component, Object value){
		  String fromComp=(String)((UIInput)component).getSubmittedValue();
		  String toComp = (String)getCOMP_APCC_CONT_TO().getSubmittedValue();
		  if(fromComp!=null&&!"".equals(fromComp)){
			  if(toComp!=null&&!"".equals(toComp)){
				  System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.validatorContrFrom()---fromComp--["+fromComp+"]---toComp---["+toComp+"]");
				  Double dFromComp=Double.parseDouble(fromComp);
				  Double dToComp =Double.parseDouble(toComp);
				  System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.validatorContrFrom()---dfromComp--["+dFromComp+"]---dtoComp---["+dToComp+"]");
				  if(dFromComp>dToComp){
					  throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"Contribution From Value Should Be less than To Value"})); 
					  
				  }else{
					  System.out
							.println("PM_AGENT_PF_COMP_CONT_ACTION.validatorContrFrom()--CONTINUE---");
				  }
			  }
		  }
	  }
	  
	  
	  public void validatorContrTo(FacesContext fc,UIComponent component, Object value){
		  String toComp=(String)((UIInput)component).getSubmittedValue();
		  String fromComp =(String)getCOMP_APCC_CONT_FM().getSubmittedValue();
		  if(toComp!=null&&!"".equals(toComp)){
			  if(fromComp!=null &&!"".equals(fromComp)){
				  Double dFromComp=Double.parseDouble(fromComp);
				  Double dToComp =Double.parseDouble(toComp);
				  if(dToComp<dFromComp){
					  throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "3206", new Object[]{"Contribution To Value Should Be Greater than From Value"}));
				  }
				  
			  }
		  }
	  }
	
	
/*	public void validateNumber(FacesContext fc,UIComponent component, Object value){
		if(component.getId().equals("APCC_CONT_FM")){
			String inComp=(String)((UIInput)component).getSubmittedValue();
			String outComp= (String)getCOMP_APCC_CONT_TO().getSubmittedValue();
			System.out.println("PM_AGENT_PF_COMP_CONT_ACTION.validateNumber()----inComp--["+inComp+"]-----outComp---["+outComp+"]");
			if(inComp!=null||!inComp.equals("") ){
			if(!outComp.equals("")){
				
				System.out
						.println("PM_AGENT_PF_COMP_CONT_ACTION.validateNumber()---INSIDE");
			Double contrFrom=Double.parseDouble(((String)((UIInput)component).getSubmittedValue()));
			Double contrTo= Double.parseDouble((String)getCOMP_APCC_CONT_TO().getSubmittedValue());
			
			if(contrFrom>contrTo){
				throw new ValidatorException(new FacesMessage("Contribution From Value Should Be less than To Value"));
			}else{
				System.out
						.println("PM_AGENT_PF_COMP_CONT_ACTION.validateNumber()--[CONTINUE]");
			}
			}
			}
		}
		else if(component.getId().equals("APCC_CONT_TO")){
			String inComp=(String)((UIInput)component).getSubmittedValue();
			String outComp= (String)getCOMP_APCC_CONT_FM().getSubmittedValue();
			if(inComp!=null||!inComp.equals("") ){
				if(!outComp.equals("")){
			Double contrTo=Double.parseDouble(((String)((UIInput)component).getSubmittedValue()));
			Double contrFrom= Double.parseDouble((String)getCOMP_APCC_CONT_FM().getSubmittedValue());
			if(contrTo<contrFrom){
				throw new ValidatorException(new FacesMessage("Contribution To Value Should Be Greater than From Value"));
			}else{
				System.out
						.println("PM_AGENT_PF_COMP_CONT_ACTION.validateNumber()--[CONTINUE]");
			}
			}
			}
		}
			
	}	*/
	
 
	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}
	
	public Connection getConnection() {
		Connection con =null;
		try{
		con=CommonUtils.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
	return con;
		
	}
	
	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}

	public ArrayList<SelectItem> getContribTypeList() {
		return contribTypeList;
	}

	public void setContribTypeList(ArrayList<SelectItem> contribTypeList) {
		this.contribTypeList = contribTypeList;
	}

	public HtmlSelectOneMenu getCOMP_APCC_CONT_TYPE() {
		return COMP_APCC_CONT_TYPE;
	}

	public void setCOMP_APCC_CONT_TYPE(HtmlSelectOneMenu comp_apcc_cont_type) {
		COMP_APCC_CONT_TYPE = comp_apcc_cont_type;
	}
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				new PM_AGENT_PF_COMP_CONT_DELEGATE().executeSelectStatement(this);
				if(PM_AGENT_PF_COMP_CONT_BEAN.getROWID()!= null){
					setBlockFlag(false);
			}else{
				whenCreateRecord();
			}
			setBlockFlag(false);
			}
		} catch (Exception e) {
		 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
		 getErrorMap().put("onLoad",e.getMessage());
		}
	}			
	public ArrayList<SelectItem> getProductTypeList() {
	    return productTypeList;
	}

	public void setProductTypeList(ArrayList<SelectItem> productTypeList) {
	    this.productTypeList = productTypeList;
	}
	
	public void validateAPCC_MKT_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_MKT_CODE((String) value);
			PM_AGENT_PF_COMP_CONT_BEAN.setUI_M_APCC_MKT_CODE_DESC(helper
					.validateAPCC_MKT_CODE((String) value));
			COMP_UI_M_APCC_MKT_CODE_DESC.resetValue();
		} catch (Exception e) {
			PM_AGENT_PF_COMP_CONT_BEAN.setUI_M_APCC_MKT_CODE_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateAPCC_RANK_CODE(FacesContext context,
			UIComponent component, Object value) {
		try {
			PM_AGENT_PF_COMP_CONT_BEAN.setAPCC_RANK_CODE((String) value);
			PM_AGENT_PF_COMP_CONT_BEAN.setUI_M_APCC_RANK_CODE_DESC(helper
					.validateAPCC_RANK_CODE((String) value));
			COMP_UI_M_APCC_RANK_CODE_DESC.resetValue();
		} catch (Exception e) {
			PM_AGENT_PF_COMP_CONT_BEAN.setUI_M_APCC_RANK_CODE_DESC("");
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void whenCreateRecord(){
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_CONT_FM(Double.parseDouble("0.0"));
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_CONT_TO(Double.parseDouble("1.0"));
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_CONT_TYPE("N");
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_PROD_TYPE("D");
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_RATE(Double.parseDouble("0.0"));
		getPM_AGENT_PF_COMP_CONT_BEAN().setAPCC_RATE_PER(Double.parseDouble("0.0"));
	}
}
	
