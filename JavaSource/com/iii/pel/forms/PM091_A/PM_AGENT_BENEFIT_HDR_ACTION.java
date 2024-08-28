package com.iii.pel.forms.PM091_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.richfaces.component.UICalendar;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_AGENT_BENEFIT_HDR_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_ABH_BNF_CODE_LABEL;

	private HtmlInputText COMP_ABH_BNF_CODE;

	private HtmlOutputLabel COMP_ABH_DESC_LABEL;

	private HtmlInputText COMP_ABH_DESC;

	private HtmlOutputLabel COMP_ABH_SHORT_DESC_LABEL;

	private HtmlInputText COMP_ABH_SHORT_DESC;

	private HtmlOutputLabel COMP_ABH_LONG_DESC_LABEL;

	private HtmlInputText COMP_ABH_LONG_DESC;

	private HtmlOutputLabel COMP_ABH_BNF_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ABH_BNF_TYPE;

	private HtmlOutputLabel COMP_ABH_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_ABH_EFF_FM_DT;

	private HtmlOutputLabel COMP_ABH_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_ABH_EFF_TO_DT;

	private HtmlOutputLabel COMP_ABH_TAXABLE_YN_LABEL;

	private HtmlSelectOneMenu COMP_ABH_TAXABLE_YN;

	private HtmlOutputLabel COMP_ABH_BL_DESC_LABEL;

	private HtmlInputText COMP_ABH_BL_DESC;

	private HtmlOutputLabel COMP_ABH_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_ABH_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_ABH_BL_LONG_DESC_LABEL;

	private HtmlInputText COMP_ABH_BL_LONG_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_BILINGUAL;

	private HtmlCommandButton COMP_UI_M_BUT_EDI_ABH_LONG_DESC;

	private PM_AGENT_BENEFIT_HDR PM_AGENT_BENEFIT_HDR_BEAN;

	private HtmlCommandButton onloadButton;

	//**********************combobox***************************************

	private List<SelectItem> LIST_ABH_TAXABLE_YN = new ArrayList<SelectItem>();

	private List<SelectItem>LIST_ABH_BNF_TYPE= new ArrayList<SelectItem>();


	private boolean update;


	public PM091_A_COMPOSITE_ACTION compositeAction;

	public PM_AGENT_BENEFIT_HDR_ACTION()  {
		PM_AGENT_BENEFIT_HDR_BEAN = new PM_AGENT_BENEFIT_HDR();
		instantiateAllComponent();
		Connection con;
		try {
			con = CommonUtils.getConnection();
			LIST_ABH_TAXABLE_YN = ListItemUtil.getDropDownListValue(con, "PM091_A", "PM_AGENT_BENEFIT_HDR", "PM_AGENT_BENEFIT_HDR.ABH_TAXABLE_YN", "YESNO");
			LIST_ABH_BNF_TYPE = ListItemUtil.getDropDownListValue(con, "PM091_A", "PM_AGENT_BENEFIT_HDR" ,"PM_AGENT_BENEFIT_HDR.ABH_BNF_TYPE",null);
			
		} catch (DBException e1) {
			// TODO Auto-generated catch block
		   e1.printStackTrace();
		}
		
	}


	

	public List<SelectItem> getLIST_ABH_TAXABLE_YN() {
		return LIST_ABH_TAXABLE_YN;
	}

	public void setLIST_ABH_TAXABLE_YN(List<SelectItem> list_abh_taxable_yn) {
		LIST_ABH_TAXABLE_YN = list_abh_taxable_yn;
	}

	public List<SelectItem> getLIST_ABH_BNF_TYPE() {
		return LIST_ABH_BNF_TYPE;
	}

	public void setLIST_ABH_BNF_TYPE(List<SelectItem> list_abh_bnf_type) {
		LIST_ABH_BNF_TYPE = list_abh_bnf_type;
	}


	public HtmlOutputLabel getCOMP_ABH_BNF_CODE_LABEL() {
		return COMP_ABH_BNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ABH_BNF_CODE() {
		return COMP_ABH_BNF_CODE;
	}

	public void setCOMP_ABH_BNF_CODE_LABEL(HtmlOutputLabel COMP_ABH_BNF_CODE_LABEL) {
		this.COMP_ABH_BNF_CODE_LABEL = COMP_ABH_BNF_CODE_LABEL;
	}

	public void setCOMP_ABH_BNF_CODE(HtmlInputText COMP_ABH_BNF_CODE) {
		this.COMP_ABH_BNF_CODE = COMP_ABH_BNF_CODE;
	}

	public HtmlOutputLabel getCOMP_ABH_DESC_LABEL() {
		return COMP_ABH_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABH_DESC() {
		return COMP_ABH_DESC;
	}

	public void setCOMP_ABH_DESC_LABEL(HtmlOutputLabel COMP_ABH_DESC_LABEL) {
		this.COMP_ABH_DESC_LABEL = COMP_ABH_DESC_LABEL;
	}

	public void setCOMP_ABH_DESC(HtmlInputText COMP_ABH_DESC) {
		this.COMP_ABH_DESC = COMP_ABH_DESC;
	}

	public HtmlOutputLabel getCOMP_ABH_SHORT_DESC_LABEL() {
		return COMP_ABH_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABH_SHORT_DESC() {
		return COMP_ABH_SHORT_DESC;
	}

	public void setCOMP_ABH_SHORT_DESC_LABEL(HtmlOutputLabel COMP_ABH_SHORT_DESC_LABEL) {
		this.COMP_ABH_SHORT_DESC_LABEL = COMP_ABH_SHORT_DESC_LABEL;
	}

	public void setCOMP_ABH_SHORT_DESC(HtmlInputText COMP_ABH_SHORT_DESC) {
		this.COMP_ABH_SHORT_DESC = COMP_ABH_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_ABH_LONG_DESC_LABEL() {
		return COMP_ABH_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABH_LONG_DESC() {
		return COMP_ABH_LONG_DESC;
	}

	public void setCOMP_ABH_LONG_DESC_LABEL(HtmlOutputLabel COMP_ABH_LONG_DESC_LABEL) {
		this.COMP_ABH_LONG_DESC_LABEL = COMP_ABH_LONG_DESC_LABEL;
	}

	public void setCOMP_ABH_LONG_DESC(HtmlInputText COMP_ABH_LONG_DESC) {
		this.COMP_ABH_LONG_DESC = COMP_ABH_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_ABH_BNF_TYPE_LABEL() {
		return COMP_ABH_BNF_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABH_BNF_TYPE() {
		return COMP_ABH_BNF_TYPE;
	}

	public void setCOMP_ABH_BNF_TYPE_LABEL(HtmlOutputLabel COMP_ABH_BNF_TYPE_LABEL) {
		this.COMP_ABH_BNF_TYPE_LABEL = COMP_ABH_BNF_TYPE_LABEL;
	}

	public void setCOMP_ABH_BNF_TYPE(HtmlSelectOneMenu COMP_ABH_BNF_TYPE) {
		this.COMP_ABH_BNF_TYPE = COMP_ABH_BNF_TYPE;
	}

	public HtmlOutputLabel getCOMP_ABH_EFF_FM_DT_LABEL() {
		return COMP_ABH_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABH_EFF_FM_DT() {
		return COMP_ABH_EFF_FM_DT;
	}

	public void setCOMP_ABH_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_ABH_EFF_FM_DT_LABEL) {
		this.COMP_ABH_EFF_FM_DT_LABEL = COMP_ABH_EFF_FM_DT_LABEL;
	}

	public void setCOMP_ABH_EFF_FM_DT(HtmlCalendar COMP_ABH_EFF_FM_DT) {
		this.COMP_ABH_EFF_FM_DT = COMP_ABH_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_ABH_EFF_TO_DT_LABEL() {
		return COMP_ABH_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_ABH_EFF_TO_DT() {
		return COMP_ABH_EFF_TO_DT;
	}

	public void setCOMP_ABH_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_ABH_EFF_TO_DT_LABEL) {
		this.COMP_ABH_EFF_TO_DT_LABEL = COMP_ABH_EFF_TO_DT_LABEL;
	}

	public void setCOMP_ABH_EFF_TO_DT(HtmlCalendar COMP_ABH_EFF_TO_DT) {
		this.COMP_ABH_EFF_TO_DT = COMP_ABH_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_ABH_TAXABLE_YN_LABEL() {
		return COMP_ABH_TAXABLE_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ABH_TAXABLE_YN() {
		return COMP_ABH_TAXABLE_YN;
	}

	public void setCOMP_ABH_TAXABLE_YN_LABEL(HtmlOutputLabel COMP_ABH_TAXABLE_YN_LABEL) {
		this.COMP_ABH_TAXABLE_YN_LABEL = COMP_ABH_TAXABLE_YN_LABEL;
	}

	public void setCOMP_ABH_TAXABLE_YN(HtmlSelectOneMenu COMP_ABH_TAXABLE_YN) {
		this.COMP_ABH_TAXABLE_YN = COMP_ABH_TAXABLE_YN;
	}

	public HtmlOutputLabel getCOMP_ABH_BL_DESC_LABEL() {
		return COMP_ABH_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABH_BL_DESC() {
		return COMP_ABH_BL_DESC;
	}

	public void setCOMP_ABH_BL_DESC_LABEL(HtmlOutputLabel COMP_ABH_BL_DESC_LABEL) {
		this.COMP_ABH_BL_DESC_LABEL = COMP_ABH_BL_DESC_LABEL;
	}

	public void setCOMP_ABH_BL_DESC(HtmlInputText COMP_ABH_BL_DESC) {
		this.COMP_ABH_BL_DESC = COMP_ABH_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_ABH_BL_SHORT_DESC_LABEL() {
		return COMP_ABH_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABH_BL_SHORT_DESC() {
		return COMP_ABH_BL_SHORT_DESC;
	}

	public void setCOMP_ABH_BL_SHORT_DESC_LABEL(HtmlOutputLabel COMP_ABH_BL_SHORT_DESC_LABEL) {
		this.COMP_ABH_BL_SHORT_DESC_LABEL = COMP_ABH_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_ABH_BL_SHORT_DESC(HtmlInputText COMP_ABH_BL_SHORT_DESC) {
		this.COMP_ABH_BL_SHORT_DESC = COMP_ABH_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_ABH_BL_LONG_DESC_LABEL() {
		return COMP_ABH_BL_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_ABH_BL_LONG_DESC() {
		return COMP_ABH_BL_LONG_DESC;
	}

	public void setCOMP_ABH_BL_LONG_DESC_LABEL(HtmlOutputLabel COMP_ABH_BL_LONG_DESC_LABEL) {
		this.COMP_ABH_BL_LONG_DESC_LABEL = COMP_ABH_BL_LONG_DESC_LABEL;
	}

	public void setCOMP_ABH_BL_LONG_DESC(HtmlInputText COMP_ABH_BL_LONG_DESC) {
		this.COMP_ABH_BL_LONG_DESC = COMP_ABH_BL_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_BILINGUAL() {
		return COMP_UI_M_BUT_BILINGUAL;
	}

	public void setCOMP_UI_M_BUT_BILINGUAL(HtmlCommandButton COMP_UI_M_BUT_BILINGUAL) {
		this.COMP_UI_M_BUT_BILINGUAL = COMP_UI_M_BUT_BILINGUAL;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDI_ABH_LONG_DESC() {
		return COMP_UI_M_BUT_EDI_ABH_LONG_DESC;
	}

	public void setCOMP_UI_M_BUT_EDI_ABH_LONG_DESC(HtmlCommandButton COMP_UI_M_BUT_EDI_ABH_LONG_DESC) {
		this.COMP_UI_M_BUT_EDI_ABH_LONG_DESC = COMP_UI_M_BUT_EDI_ABH_LONG_DESC;
	}

	public PM_AGENT_BENEFIT_HDR getPM_AGENT_BENEFIT_HDR_BEAN() {
		return PM_AGENT_BENEFIT_HDR_BEAN;
	}

	public void setPM_AGENT_BENEFIT_HDR_BEAN(PM_AGENT_BENEFIT_HDR PM_AGENT_BENEFIT_HDR_BEAN) {
		this.PM_AGENT_BENEFIT_HDR_BEAN = PM_AGENT_BENEFIT_HDR_BEAN;
	}


	public void preForm(){
		Connection con =getConnection();
		ArrayList<OracleParameter> list =null;
		Map<String, Object> session = getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		STD_PRE_FORM();
		LIST_ABH_TAXABLE_YN = ListItemUtil.getDropDownListValue(con, "PM091_A", "PM_AGENT_BENEFIT_HDR", "PM_AGENT_BENEFIT_HDR.ABH_TAXABLE_YN", "YESNO");
		LIST_ABH_BNF_TYPE = ListItemUtil.getDropDownListValue(con, "PM091_A", "PM_AGENT_BENEFIT_HDR" ,"PM_AGENT_BENEFIT_HDR.ABH_BNF_TYPE",null);
		getOnloadButton().setDisabled(true);
	}


	public void STD_PRE_FORM() {

		ControlBean ctrlBean = CommonUtils.getControlBean();

		// bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		// ctrlBean.setM_PROG_NAME("PILT010");
		// COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30),
		// 'BUTTON_PALETTE.M_COMP_NAME') ;
		// COPY('10','SYSTEM.MESSAGE_LEVEL');
		Map<String, Object> session = getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		System.out.println("STD_PRE_FORM()--- \n " + ctrlBean.getM_LANG_CODE()
				+ "\t" + ctrlBean.getM_COMP_CODE() + "\t"
				+ ctrlBean.getM_PARA_1());
		FacesContext context = FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		if (sessionMap.get("CURRENT_MODE").equals("INSERT")) {
			getSysDate();
			whenCreateRecord();
		}
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

	public void preUpdate(){

	}

	public void whenCreateRecord(){
		getPM_AGENT_BENEFIT_HDR_BEAN().setABH_TAXABLE_YN("Y");

	}

//	*****************Error Handling*********************************************************************


	
	public void fireFieldValidation(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		CommonUtils.clearMaps(this);
		ErrorHelpUtil.validate(input, getErrorMap());
	}


	
	
	
	public void benefitCodeValidator(FacesContext context, UIComponent component, Object value) throws ValidatorException{
		String benefitCode = value.toString();
		String dummy = null;
		ResultSet rs =null;
		String query ="SELECT 'X',ROWID FROM PM_AGENT_BENEFIT_HDR WHERE  ABH_BNF_CODE = ? ";
		try{
			PM_AGENT_BENEFIT_HDR_BEAN.setABH_BNF_CODE(benefitCode);
			rs = getHandler().executeSelectStatement(query, getConnection(), new Object[]{benefitCode});
			if(rs.next()){
				if (PM_AGENT_BENEFIT_HDR_BEAN.getROWID() ==  null) {
					if (rs.getString(2) != null) {
						getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, Messages.getString(PELConstants.pelErrorMessagePath, "61001"));
					}
				}
			}
			CommonUtils.closeCursor(rs);
		}
		catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} 
	}



	
	public void populateDescription(ActionEvent ae){
		UIInput input = (UIInput) ae.getComponent().getParent();
		String descValue = (String)input.getSubmittedValue();
		if((getCOMP_ABH_LONG_DESC().getValue()==null)||(getCOMP_ABH_LONG_DESC().getValue().equals("")) ){
			getCOMP_ABH_LONG_DESC().setSubmittedValue(descValue);
			getCOMP_ABH_SHORT_DESC().setSubmittedValue(descValue);
		}
	}



	public void validateFromDateAction(ActionEvent ae){
		UIInput input = (UIInput) ae.getComponent().getParent(); // input comp
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	
	public void validateFromDate(FacesContext fc,UIComponent component, Object value) throws ValidatorException{
	     PM_AGENT_BENEFIT_HDR_BEAN.setABH_EFF_FM_DT((Date) value);
	     Date fromDate = (Date) value;
		if(PM_AGENT_BENEFIT_HDR_BEAN.getABH_EFF_FM_DT() != null){
			Date toDate=(java.util.Date)((UICalendar)getCOMP_ABH_EFF_TO_DT()).getAsDate(getCOMP_ABH_EFF_TO_DT().getSubmittedValue());
			if (toDate != null) {
				if(fromDate.after(toDate)){
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "3206",new Object[]{"Effective From date Should not be greater than Effective to Date"}));
				}
			}
		}
	}

				





	public void validateToDateAction(ActionEvent ae){
		UIInput input = (UIInput) ae.getComponent().getParent(); // input comp

		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void validateToDate(FacesContext fc,UIComponent component, Object value) throws ParseException{
		
		UICalendar cala= (UICalendar) component;
		PM_AGENT_BENEFIT_HDR_BEAN.setABH_EFF_TO_DT((Date) value);
		Date fromDate = null;
		if(PM_AGENT_BENEFIT_HDR_BEAN.getABH_EFF_TO_DT() != null ){
			
			if(getCOMP_ABH_EFF_FM_DT().getSubmittedValue()!=null)
				fromDate=(java.util.Date)((UICalendar)getCOMP_ABH_EFF_FM_DT()).getAsDate(getCOMP_ABH_EFF_FM_DT().getSubmittedValue());
			else if(getCOMP_ABH_EFF_FM_DT().getValue()!=null){
				fromDate=(java.util.Date)((UICalendar)getCOMP_ABH_EFF_FM_DT()).getAsDate(getCOMP_ABH_EFF_FM_DT().getValue());
			}
			if(PM_AGENT_BENEFIT_HDR_BEAN.getABH_EFF_TO_DT().before(fromDate)){
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelErrorMessagePath, "91001"));
			}
		}			
		

	}



	public String trvrsToMasterBlock(){
		return "MasterBlock";
	}


	public String trvrsToDtLBlock(){		
		FacesContext context = FacesContext.getCurrentInstance();
		String benefitCode = getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE(); 
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_AGENT_BENEFIT_HDR_ACTION sessionBean =null;
		PM_AGENT_BENEFIT_DTL_ACTION actionBean = null;
		if(session.getAttribute("PM091_A_PM_AGENT_BENEFIT_DTL_ACTION")!=null){
			actionBean=(PM_AGENT_BENEFIT_DTL_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_DTL_ACTION");
		}else{
			if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
				sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
				benefitCode =sessionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
			}


			try{
				String selectQuery = "select ROWID,PM_AGENT_BENEFIT_DTL.* from PM_AGENT_BENEFIT_DTL where ABD_ABH_BNF_CODE ='"+benefitCode+"'";
				System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrsToDtLBlock()---SELCTQUERY--["+selectQuery+"]");
				List<PM_AGENT_BENEFIT_DTL> list = getHandler().fetch(selectQuery,"com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_DTL",
						getConnection());

				ELResolver resolver = context.getApplication().getELResolver();
				actionBean = (PM_AGENT_BENEFIT_DTL_ACTION )resolver.getValue(context.getELContext(), null, "PM091_A_PM_AGENT_BENEFIT_DTL_ACTION");

				if(actionBean == null) {
					System.out.println("actionbean null");
				}
				actionBean.setDtlTableList(list);
				for(Iterator<PM_AGENT_BENEFIT_DTL>i=list.iterator();i.hasNext();){
					PM_AGENT_BENEFIT_DTL DTL_BEAN = i.next();
					DTL_BEAN.setRowSelected(false);
				}
				if(list.size()>0){
					actionBean.setPM_AGENT_BENEFIT_DTL_BEAN(list.get(0));
					actionBean.getPM_AGENT_BENEFIT_DTL_BEAN().setRowSelected(true);
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return"PM_AGENT_BENEFIT_DTL";
	}
	public String trvrslToRankBlock(){
		System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrslToRankBlock()");
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_AGENT_BENEFIT_HDR_ACTION sessionBean =null;
		String benefitCode = getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE(); 
		PM_AGENT_BENEFIT_APPL_RANK_ACTION actionBean =null;
		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION") != null) {
			actionBean = (PM_AGENT_BENEFIT_APPL_RANK_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION");
		}else{
			if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
				sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
				benefitCode =sessionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
			}
		}
//			List<PM_AGENT_BENEFIT_APPL_RANK> newList = new ArrayList<PM_AGENT_BENEFIT_APPL_RANK>();
			
			/*if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
			 sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
			 benefitCode =sessionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
		}

		if(sessionBean==null){
			System.out
					.println("PM_AGENT_BENEFIT_DTL_ACTION.goToApplicableRankBlock(--SESSIONBEAN NULL)");
		}*/

			try{
				String selectQuery = "select ROWID,PM_AGENT_BENEFIT_APPL_RANK.* from PM_AGENT_BENEFIT_APPL_RANK where ABAR_ABH_BNF_CODE ='"+benefitCode+"'";
				System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrsToDtLBlock()---SELCTQUERY--["+selectQuery+"]");
				List<PM_AGENT_BENEFIT_APPL_RANK> list = getHandler().fetch(selectQuery,"com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_APPL_RANK",
						getConnection());
				ELResolver resolver = context.getApplication().getELResolver();
				actionBean = (PM_AGENT_BENEFIT_APPL_RANK_ACTION)resolver.getValue(context.getELContext(), null, "PM091_A_PM_AGENT_BENEFIT_APPL_RANK_ACTION");

				String rankCodeDesc = null;
				
				/*for(Iterator<PM_AGENT_BENEFIT_APPL_RANK> i = list.iterator();i.hasNext();){
					PM_AGENT_BENEFIT_APPL_RANK listValue = i.next();
					rankCodeDesc = getRankCodeDesc(listValue.getABAR_RANK_CODE());
					listValue.setUI_M_ABAR_RANK_CODE_DESC(rankCodeDesc);
					listValue.setRowSelected(false);
					list.add(listValue);
				}*/
				actionBean.setRankTableList(list);
				for(Iterator<PM_AGENT_BENEFIT_APPL_RANK>i=list.iterator();i.hasNext();){
					PM_AGENT_BENEFIT_APPL_RANK listValue = i.next();
					rankCodeDesc = getRankCodeDesc(listValue.getABAR_RANK_CODE());
					listValue.setUI_M_ABAR_RANK_CODE_DESC(rankCodeDesc);
					listValue.setRowSelected(false);
				}
				if(list.size()>0){
					actionBean.setPM_AGENT_BENEFIT_APPL_RANK_BEAN(list.get(0));
					actionBean.getPM_AGENT_BENEFIT_APPL_RANK_BEAN().setRowSelected(true);
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		
		return "RankBlock";
	}

	public String getRankCodeDesc( String rankCode){
		ResultSet rs =null;
		String rankDesc=null;
		String codeValue=rankCode;
		if(!codeValue.equals("")|| codeValue!=null){
			String desc = "select PC_DESC from pm_codes where PC_TYPE = 'AGNRANK' AND PC_FRZ_FLAG = 'N' AND PC_CLASS_CODE IS NULL and PC_CODE ='"+codeValue+"'";
			try{		
				rs = getHandler().executeSelectStatement(desc, getConnection());
				if(rs.next()){
					rankDesc = rs.getString(1);
				}
			}catch(Exception ex){ex.printStackTrace();}
			finally{try{rs.close();}catch(Exception ex){}}
		}
		return rankDesc;
	}
    public String trvrslToProductBlock(){
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		String benefitCode = null;
		List newList = new ArrayList<PM_AGENT_BENEFIT_APPL_PROD>();
		PM_AGENT_BENEFIT_HDR_ACTION sessionBean =null;
		PM_AGENT_BENEFIT_APPL_PROD_ACTION actionBean =null;

		if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION") != null) {
			actionBean = (PM_AGENT_BENEFIT_APPL_PROD_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION");
		}else{
			if (session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION") != null) {
				sessionBean = (PM_AGENT_BENEFIT_HDR_ACTION) session.getAttribute("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
				benefitCode =sessionBean.getPM_AGENT_BENEFIT_HDR_BEAN().getABH_BNF_CODE();
			}

			if(sessionBean==null){
				System.out
				.println("PM_AGENT_BENEFIT_DTL_ACTION.goToApplicableRankBlock(--SESSIONBEAN NULL)");
			}

			try{
				String selectQuery = "select ROWID,PM_AGENT_BENEFIT_APPL_PROD.* from PM_AGENT_BENEFIT_APPL_PROD where ABNFAP_ABH_BNF_CODE ='"+benefitCode+"'";
				System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.trvrsToDtLBlock()---SELCTQUERY--["+selectQuery+"]");
				List<PM_AGENT_BENEFIT_APPL_PROD> list = getHandler().fetch(selectQuery,"com.iii.pel.forms.PM091_A.PM_AGENT_BENEFIT_APPL_PROD",
						getConnection());

				ELResolver resolver = context.getApplication().getELResolver();
				actionBean = (PM_AGENT_BENEFIT_APPL_PROD_ACTION)resolver.getValue(context.getELContext(), null, "PM091_A_PM_AGENT_BENEFIT_APPL_PROD_ACTION");


				for(PM_AGENT_BENEFIT_APPL_PROD listValue : list){

					String productCodeDesc = getProductCodeDesc(listValue.getABNFAP_PROD_CODE(),listValue.getABNFAP_MODULE_ID());
					listValue.setUI_M_ABNFAP_PROD_CODE_DESC(productCodeDesc);
					newList.add(listValue);
				}
				actionBean.setProdTableList(newList);
				for(Iterator<PM_AGENT_BENEFIT_APPL_PROD>i = newList.iterator();i.hasNext();){
					PM_AGENT_BENEFIT_APPL_PROD APPL_PROD_BEAN = i.next();
					APPL_PROD_BEAN.setRowSelected(false);
				}
				if(newList.size() > 0){
					actionBean.setPM_AGENT_BENEFIT_APPL_PROD_BEAN(list.get(0));
					actionBean.getPM_AGENT_BENEFIT_APPL_PROD_BEAN().setRowSelected(true);
					
				}
				
			}
			catch(Exception ex){
				ex.printStackTrace();
			}
		}

		return "ProductBlock";
	}


	public String getProductCodeDesc(String productcode,String moduleid){
		ResultSet rs =null;
		String productDesc=null;
		String ModuleId = moduleid;
		String codeValue= productcode;
		try{		
			if(codeValue != null && !codeValue.equals("")){
				String desc = "SELECT PROD_DESC FROM   PV_LIFE_PRODUCTS WHERE  MODULE_ID ='"+ModuleId+"' and  PROD_CODE ='"+codeValue+"'";

				System.out
				.println("PM_AGENT_BENEFIT_APPL_RANK_ACTION.getProductCodeDesc()--QQQQQUERY--["+desc+"]");
				rs = getHandler().executeSelectStatement(desc, getConnection());
				if(rs.next()){
					productDesc = rs.getString(1);
				}else{

					//WHEN-VALIDATE-ITEM
					/*STD_MESSAGE_ROUTINE(80223,:CTRL.M_LANG_CODE);   
						RAISE FORM_TRIGGER_FAILURE;*/
				}

			}
		}catch(Exception ex){
			ex.printStackTrace();

		} finally {
			try{
				CommonUtils.closeCursor(rs);
			}catch(Exception ex){
				ex.printStackTrace();

			}
		}
		return productDesc;
	}


	public String trvrslToDetailBlock(){
		return "DetailBlock";
	}
	//********************************CRUD*********************************************

	public String gotoSearchScreen()
	{
		CommonUtils utils = new CommonUtils();
		utils.clearMappedBeanFromSession("PM091_A_PM_AGENT_BENEFIT_HDR_ACTION");
		return "SearchScreen";
	}

	public String saveRecord() {
		try{
			
			Connection con = CommonUtils.getConnection();
			if (PM_AGENT_BENEFIT_HDR_BEAN.getROWID() == null && isINSERT_ALLOWED()) {
				PM_AGENT_BENEFIT_HDR_BEAN.setABH_CR_DT(new CommonUtils().getCurrentDate());
				PM_AGENT_BENEFIT_HDR_BEAN.setABH_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				new CRUDHandler().executeInsert(PM_AGENT_BENEFIT_HDR_BEAN, con);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Saved SuccessFully");
				getWarningMap().put("SAVE", "Record Saved SuccessFully");
				
			}else if(PM_AGENT_BENEFIT_HDR_BEAN.getROWID() != null){
				PM_AGENT_BENEFIT_HDR_BEAN.setABH_UPD_DT(new CommonUtils().getCurrentDate());
				PM_AGENT_BENEFIT_HDR_BEAN.setABH_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
				new CRUDHandler().executeUpdate(PM_AGENT_BENEFIT_HDR_BEAN, con);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Updated SuccessFully");
				getWarningMap().put("SAVE", "Record Updated SuccessFully");
			}
			CommonUtils.getConnection().commit();
		}catch(Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		return null;
	}



	public void deleteRecord() {
		try{
			String detailDelQuery = "DELETE FROM PM_AGENT_BENEFIT_APPL_PROD WHERE ABNFAP_ABH_BNF_CODE = ? ";
			
			new CRUDHandler().executeDeleteStatement(detailDelQuery, CommonUtils.getConnection(),new Object[]{PM_AGENT_BENEFIT_HDR_BEAN.getABH_BNF_CODE()});
			new CRUDHandler().executeDelete(PM_AGENT_BENEFIT_HDR_BEAN, CommonUtils.getConnection());
			resetAllComponent();
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Record Deleted Successfully");
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, "Record Deleted Successfully");
		}catch(Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY, e.getMessage());
			getErrorMap().put("DELETE", e.getMessage());
			resetAllComponent();
		}

	}







	//****************************utils**********************************************




	public java.util.Date getSysDate(){
		Connection con =getConnection();
		String query = "select sysdate from dual";
		java.util.Date jDate=null;
		ResultSet rs=null;
		try{
			rs= getHandler().executeSelectStatement(query, con);
			while(rs.next()){
				Date date = rs.getDate("SYSDATE");
				jDate = (java.util.Date)date;
				System.out.println("PM_AGENT_BENEFIT_HDR_ACTION.getSysDate()----["+date+"]--Java--["+jDate+"]");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();

			}
		}
		return jDate;
	}
	public Connection getConnection() {
		Connection con =null;

		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;

	}

	public CRUDHandler getHandler(){
		return new CRUDHandler();
	}

	public HtmlCommandButton getOnloadButton() {
		return onloadButton;
	}

	public void setOnloadButton(HtmlCommandButton onloadButton) {
		this.onloadButton = onloadButton;
	}
	public Map<String, Object> getSessionMap(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
	
	
	
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				new PM_AGENT_BENEFIT_HDR_DELEGATE().executeSelectStatement(compositeAction);
				setBlockFlag(false);
			}

			if (PM_AGENT_BENEFIT_HDR_BEAN.getROWID() == null) {
				whenCreateRecord();
			}
			
		} catch (Exception e) {
		 getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
		 getErrorMap().put("onLoad",e.getMessage());
		}
	}
	
	
	
	

	/**
	 * Instantiates all components in PM_AGENT_BENEFIT_HDR_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_ABH_BNF_CODE				 = new HtmlInputText();
		COMP_ABH_DESC					 = new HtmlInputText();
		COMP_ABH_SHORT_DESC				 = new HtmlInputText();
		COMP_ABH_LONG_DESC				 = new HtmlInputText();
		COMP_ABH_BL_DESC				 = new HtmlInputText();
		COMP_ABH_BL_SHORT_DESC				 = new HtmlInputText();
		COMP_ABH_BL_LONG_DESC				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_ABH_BNF_TYPE				 = new HtmlSelectOneMenu();
		COMP_ABH_TAXABLE_YN				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_ABH_EFF_FM_DT				 = new HtmlCalendar();
		COMP_ABH_EFF_TO_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_BILINGUAL				 = new HtmlCommandButton();
		COMP_UI_M_BUT_EDI_ABH_LONG_DESC			 = new HtmlCommandButton();
		onloadButton					 = new HtmlCommandButton();

	}

	/**
	 * Resets all components in PM_AGENT_BENEFIT_HDR_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_ABH_BNF_CODE.resetValue();
		COMP_ABH_DESC.resetValue();
		COMP_ABH_SHORT_DESC.resetValue();
		COMP_ABH_LONG_DESC.resetValue();
		COMP_ABH_BL_DESC.resetValue();
		COMP_ABH_BL_SHORT_DESC.resetValue();
		COMP_ABH_BL_LONG_DESC.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_ABH_BNF_TYPE.resetValue();
		COMP_ABH_TAXABLE_YN.resetValue();

		// Reseting HtmlCalendar
		COMP_ABH_EFF_FM_DT.resetValue();
		COMP_ABH_EFF_TO_DT.resetValue();

		

	}

	/**
	 * Disables all components in PM_AGENT_BENEFIT_HDR_ACTION
	 */
	public void disableAllComponent(boolean disabled){
		// Disabling HtmlInputText
		COMP_ABH_BNF_CODE.setDisabled(disabled);
		COMP_ABH_DESC.setDisabled(disabled);
		COMP_ABH_SHORT_DESC.setDisabled(disabled);
		COMP_ABH_LONG_DESC.setDisabled(disabled);
		COMP_ABH_BL_DESC.setDisabled(disabled);
		COMP_ABH_BL_SHORT_DESC.setDisabled(disabled);
		COMP_ABH_BL_LONG_DESC.setDisabled(disabled);

		// Disabling HtmlSelectOneMenu
		COMP_ABH_BNF_TYPE.setDisabled(disabled);
		COMP_ABH_TAXABLE_YN.setDisabled(disabled);

		// Disabling HtmlCalendar
		COMP_ABH_EFF_FM_DT.setDisabled(disabled);
		COMP_ABH_EFF_TO_DT.setDisabled(disabled);

		// Disabling HtmlCommandButton
		COMP_UI_M_BUT_BILINGUAL.setDisabled(disabled);
		COMP_UI_M_BUT_EDI_ABH_LONG_DESC.setDisabled(disabled);
		onloadButton.setDisabled(disabled);
	}





}
