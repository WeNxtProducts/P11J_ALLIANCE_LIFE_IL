package com.iii.pel.forms.PILM203;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_COVER_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_COVER_CODE_LABEL;

	private HtmlInputText COMP_COVER_CODE;

	private HtmlOutputLabel COMP_COVER_DESC_LABEL;

	private HtmlInputText COMP_COVER_DESC;

	private HtmlOutputLabel COMP_COVER_LIMIT_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_COVER_LIMIT_TYPE;

	private HtmlOutputLabel COMP_COVER_PER_DAY_LC_AMT_LABEL;

	private HtmlInputText COMP_COVER_PER_DAY_LC_AMT;

	private HtmlOutputLabel COMP_COVER_LIMIT_DAYS_LABEL;

	private HtmlInputText COMP_COVER_LIMIT_DAYS;

	private HtmlOutputLabel COMP_COVER_LC_LIMIT_LABEL;

	private HtmlInputText COMP_COVER_LC_LIMIT;
	
	private HtmlGraphicImage COMP_MANDATORY_COVER_LIMIT_DAYS;
	private HtmlGraphicImage COMP_MANDATORY_COVER_PER_DAY_LC_AMT;
	private HtmlGraphicImage COMP_MANDATORY_COVER_LC_LIMIT;
	private HtmlCommandButton COMP_PREFORM_BUTTON;
	
	private ControlBean ctrlBean;  
	
	private PM_IL_COVER PM_IL_COVER_BEAN;
	
	private PM_IL_BNF_AGE_SETUP_ACTION PM_IL_BNF_AGE_SETUP_ACTION_BEAN;
	private PM_IL_BNF_DEDB_LINK_ACTION PM_IL_BNF_DEDB_LINK_ACTION_BEAN;
	private PM_IL_CVR_BNF_LINK_ACTION PM_IL_CVR_BNF_LINK_ACTION_BEAN;
	private PM_IL_CVR_SBNF_LINK_ACTION PM_IL_CVR_SBNF_LINK_ACTION_BEAN;
	private DUMMY_ACTION DUMMY_ACTION_BEAN;
	
	private TabbedBar tabbedBar;
	private List coverCodeList;
	
	List<SelectItem> LIST_COVER_LIMIT_TYPE = new ArrayList<SelectItem>();

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	public PM_IL_COVER_ACTION() {
		this.tabbedBar=new TabbedBar();
		PM_IL_COVER_BEAN = new PM_IL_COVER();
		
		PM_IL_BNF_AGE_SETUP_ACTION_BEAN = new PM_IL_BNF_AGE_SETUP_ACTION();
		PM_IL_BNF_DEDB_LINK_ACTION_BEAN = new PM_IL_BNF_DEDB_LINK_ACTION();
		PM_IL_CVR_BNF_LINK_ACTION_BEAN = new PM_IL_CVR_BNF_LINK_ACTION();
		PM_IL_CVR_SBNF_LINK_ACTION_BEAN = new PM_IL_CVR_SBNF_LINK_ACTION();
		DUMMY_ACTION_BEAN = new DUMMY_ACTION();
		
		
		PM_IL_BNF_AGE_SETUP_ACTION_BEAN.coverAction = this;
		PM_IL_BNF_DEDB_LINK_ACTION_BEAN.coverAction = this;
		PM_IL_CVR_BNF_LINK_ACTION_BEAN.coverAction = this;
		PM_IL_CVR_SBNF_LINK_ACTION_BEAN.coverAction = this;
		DUMMY_ACTION_BEAN.coverAction = this;
		try {
			this.tabbedBar.addTab(1, "#{PILM203_PM_IL_COVER_ACTION.goBlock_PM_IL_MAIN_BLOCK}", "Cover Benefit Setup", false);
			this.tabbedBar.addTab(2, "#{PILM203_PM_IL_COVER_ACTION.goBlock_CVR_BNF}", "Applicable Benefits", false);
			this.tabbedBar.addTab(3, "#{PILM203_PM_IL_COVER_ACTION.goBlock_CVR_SBNF}", "Sub Benefits", false);
			this.tabbedBar.addTab(4, "#{PILM203_PM_IL_COVER_ACTION.goBlock_DEDUCTABLE}", "Deductables", false);
			this.tabbedBar.addTab(5, "#{PILM203_PM_IL_COVER_ACTION.goBlock_CATAGORY}", "Applicable Catagory", false);
			setLIST_COVER_LIMIT_TYPE(
					ListItemUtil.getDropDownListValue_1(CommonUtils.getConnection(),
							"PILM203", "PM_IL_COVER",
							"PM_IL_COVER.COVER_LIMIT_TYPE", "COVER_LIMIT_TYPE"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

	public String goBlock_PM_IL_MAIN_BLOCK() {
		postQuery();
		return "WD_MAIN_BLOCK";
	}
	
	public String goBlock_CVR_BNF() {
		nextBlock_PM_IL_CVR_BNF_LINK();
		return "CVR_BNF";
	}
	
	public String goBlock_CVR_SBNF() {
		System.out.println("PM_IL_COVER_ACTION.goBlock_CVR_SBNF()");
		
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_CVR_BNF_LINK_ACTION bnfLinkAction = (PM_IL_CVR_BNF_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_CVR_BNF_LINK_ACTION");
		//bnfLinkAction.nextBlock_PM_IL_CVR_SBNF_LINK(); 
		
		
		return "CVR_SBNF";
	}
	public String goBlock_DEDUCTABLE() {
		System.out.println("PM_IL_COVER_ACTION.goBlock_DEDUCTABLE()");
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_CVR_SBNF_LINK_ACTION sbnfLinkAction = (PM_IL_CVR_SBNF_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_CVR_SBNF_LINK_ACTION");
		//sbnfLinkAction.nextBlock_PM_IL_BNF_DEDB_LINK();
		
		return "DEDUCTABLES";
	}
	public String goBlock_CATAGORY() {
		System.out.println("PM_IL_COVER_ACTION.goBlock_CATAGORY()");
		
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		
		PM_IL_BNF_DEDB_LINK_ACTION deductableLinkAction = (PM_IL_BNF_DEDB_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_BNF_DEDB_LINK_ACTION");
		deductableLinkAction.nextBlock_PM_IL_BNF_AGE_SETUP();
		
		return "CATAGORY";
	}
	
	
	
	public HtmlOutputLabel getCOMP_COVER_CODE_LABEL() {
		return COMP_COVER_CODE_LABEL;
	}

	public HtmlInputText getCOMP_COVER_CODE() {
		return COMP_COVER_CODE;
	}

	public void setCOMP_COVER_CODE_LABEL(HtmlOutputLabel COMP_COVER_CODE_LABEL) {
		this.COMP_COVER_CODE_LABEL = COMP_COVER_CODE_LABEL;
	}

	public void setCOMP_COVER_CODE(HtmlInputText COMP_COVER_CODE) {
		this.COMP_COVER_CODE = COMP_COVER_CODE;
	}

	public HtmlOutputLabel getCOMP_COVER_DESC_LABEL() {
		return COMP_COVER_DESC_LABEL;
	}

	public HtmlInputText getCOMP_COVER_DESC() {
		return COMP_COVER_DESC;
	}

	public void setCOMP_COVER_DESC_LABEL(HtmlOutputLabel COMP_COVER_DESC_LABEL) {
		this.COMP_COVER_DESC_LABEL = COMP_COVER_DESC_LABEL;
	}

	public void setCOMP_COVER_DESC(HtmlInputText COMP_COVER_DESC) {
		this.COMP_COVER_DESC = COMP_COVER_DESC;
	}

	public HtmlOutputLabel getCOMP_COVER_LIMIT_TYPE_LABEL() {
		return COMP_COVER_LIMIT_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_COVER_LIMIT_TYPE() {
		return COMP_COVER_LIMIT_TYPE;
	}

	public void setCOMP_COVER_LIMIT_TYPE_LABEL(HtmlOutputLabel COMP_COVER_LIMIT_TYPE_LABEL) {
		this.COMP_COVER_LIMIT_TYPE_LABEL = COMP_COVER_LIMIT_TYPE_LABEL;
	}

	public void setCOMP_COVER_LIMIT_TYPE(HtmlSelectOneMenu COMP_COVER_LIMIT_TYPE) {
		this.COMP_COVER_LIMIT_TYPE = COMP_COVER_LIMIT_TYPE;
	}

	public HtmlOutputLabel getCOMP_COVER_PER_DAY_LC_AMT_LABEL() {
		return COMP_COVER_PER_DAY_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_COVER_PER_DAY_LC_AMT() {
		return COMP_COVER_PER_DAY_LC_AMT;
	}

	public void setCOMP_COVER_PER_DAY_LC_AMT_LABEL(HtmlOutputLabel COMP_COVER_PER_DAY_LC_AMT_LABEL) {
		this.COMP_COVER_PER_DAY_LC_AMT_LABEL = COMP_COVER_PER_DAY_LC_AMT_LABEL;
	}

	public void setCOMP_COVER_PER_DAY_LC_AMT(HtmlInputText COMP_COVER_PER_DAY_LC_AMT) {
		this.COMP_COVER_PER_DAY_LC_AMT = COMP_COVER_PER_DAY_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_COVER_LIMIT_DAYS_LABEL() {
		return COMP_COVER_LIMIT_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_COVER_LIMIT_DAYS() {
		return COMP_COVER_LIMIT_DAYS;
	}

	public void setCOMP_COVER_LIMIT_DAYS_LABEL(HtmlOutputLabel COMP_COVER_LIMIT_DAYS_LABEL) {
		this.COMP_COVER_LIMIT_DAYS_LABEL = COMP_COVER_LIMIT_DAYS_LABEL;
	}

	public void setCOMP_COVER_LIMIT_DAYS(HtmlInputText COMP_COVER_LIMIT_DAYS) {
		this.COMP_COVER_LIMIT_DAYS = COMP_COVER_LIMIT_DAYS;
	}

	public HtmlOutputLabel getCOMP_COVER_LC_LIMIT_LABEL() {
		return COMP_COVER_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_COVER_LC_LIMIT() {
		return COMP_COVER_LC_LIMIT;
	}

	public void setCOMP_COVER_LC_LIMIT_LABEL(HtmlOutputLabel COMP_COVER_LC_LIMIT_LABEL) {
		this.COMP_COVER_LC_LIMIT_LABEL = COMP_COVER_LC_LIMIT_LABEL;
	}

	public void setCOMP_COVER_LC_LIMIT(HtmlInputText COMP_COVER_LC_LIMIT) {
		this.COMP_COVER_LC_LIMIT = COMP_COVER_LC_LIMIT;
	}

	public PM_IL_COVER getPM_IL_COVER_BEAN() {
		return PM_IL_COVER_BEAN;
	}

	public void setPM_IL_COVER_BEAN(PM_IL_COVER PM_IL_COVER_BEAN) {
		this.PM_IL_COVER_BEAN = PM_IL_COVER_BEAN;
	}

	public HtmlGraphicImage getCOMP_MANDATORY_COVER_LIMIT_DAYS() {
		return COMP_MANDATORY_COVER_LIMIT_DAYS;
	}

	public void setCOMP_MANDATORY_COVER_LIMIT_DAYS(
			HtmlGraphicImage comp_mandatory_cover_limit_days) {
		COMP_MANDATORY_COVER_LIMIT_DAYS = comp_mandatory_cover_limit_days;
	}

	public HtmlGraphicImage getCOMP_MANDATORY_COVER_PER_DAY_LC_AMT() {
		return COMP_MANDATORY_COVER_PER_DAY_LC_AMT;
	}

	public void setCOMP_MANDATORY_COVER_PER_DAY_LC_AMT(
			HtmlGraphicImage comp_mandatory_cover_per_day_lc_amt) {
		COMP_MANDATORY_COVER_PER_DAY_LC_AMT = comp_mandatory_cover_per_day_lc_amt;
	}

	public HtmlGraphicImage getCOMP_MANDATORY_COVER_LC_LIMIT() {
		return COMP_MANDATORY_COVER_LC_LIMIT;
	}

	public void setCOMP_MANDATORY_COVER_LC_LIMIT(
			HtmlGraphicImage comp_mandatory_cover_lc_limit) {
		COMP_MANDATORY_COVER_LC_LIMIT = comp_mandatory_cover_lc_limit;
	}
	
	public List<PM_IL_COVER> popLovForCoverCode(Object event) {
		List<PM_IL_COVER> list_lov = new ArrayList<PM_IL_COVER>(); 
		String textEntered = event.toString();
		System.out.println("textentered "+textEntered);
		String query = null;
		if(textEntered.equals("*")) {
//			query = "SELECT COVER_CODE, COVER_LONG_DESC FROM PM_IL_COVER";
			query = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER " +
					"WHERE COVER_FRZ_FLAG='N' AND COVER_TYPE IN ('A','B') ORDER BY 1" ;
		}else {
//			query = "SELECT COVER_CODE, COVER_LONG_DESC FROM PM_IL_COVER WHERE COVER_CODE LIKE '"+textEntered+"%'";
			query = "SELECT COVER_CODE, COVER_DESC FROM PM_IL_COVER " +
						"WHERE COVER_FRZ_FLAG='N' AND COVER_TYPE IN ('A','B') AND COVER_CODE LIKE '"+textEntered+"%' ORDER BY 1";
		}
		CRUDHandler handler = new CRUDHandler();
		try {
			Connection con = CommonUtils.getConnection();
			ResultSet rs = handler.executeSelectStatement(query, con);
			while(rs.next()) {
				PM_IL_COVER lovBean = new PM_IL_COVER();
				lovBean.setCOVER_CODE(rs.getString("COVER_CODE"));
				lovBean.setCOVER_DESC(rs.getString("COVER_DESC"));
				list_lov.add(lovBean);
			}
			coverCodeList = list_lov;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return coverCodeList;
	}
	
	public void getCoverCodeDesc(ActionEvent event)
	{
		System.out.println("On select***********************"+COMP_COVER_CODE.getSubmittedValue());
		COMP_COVER_DESC.setSubmittedValue(null);
		if(COMP_COVER_CODE.getSubmittedValue()!=null)
		{
		String coverCode=(String)COMP_COVER_CODE.getSubmittedValue();
		String coverdesc=getCoverDesc(coverCode,coverCodeList);
		System.out.println("DESC:::::::::"+coverdesc);
		COMP_COVER_DESC.setSubmittedValue(coverdesc);
		}
	}
	
	public String getCoverDesc(String coverCode, List coverCodeList) {
		Iterator iterator = coverCodeList.iterator();
		String coverdesc = null;
		while (iterator.hasNext()) {
			PM_IL_COVER pm_il_cover = (PM_IL_COVER) iterator.next();
			if (coverCode.equalsIgnoreCase(pm_il_cover.getCOVER_CODE())) {
				coverdesc = pm_il_cover.getCOVER_DESC();
			}
		}
		return coverdesc;
	}
	public void populateCoverDesc(ActionEvent ae) {
		UIInput input = (UIInput)ae.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
		/*String cover_code = input.getSubmittedValue().toString();
		System.out.println("PM_IL_COVER_ACTION.populateCoverDesc() covercode "+cover_code);
		CRUDHandler ha = new CRUDHandler();
		try {
			Connection con = CommonUtils.getConnection();
			String query = "select cover_long_desc from pm_il_cover where cover_code = '"+cover_code+"'";
			ResultSet rs = ha.executeSelectStatement(query, con);
			while(rs.next()){
			String cover_desc = rs.getString("COVER_LONG_DESC");
			getCOMP_COVER_DESC().setSubmittedValue(cover_desc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	public void setSessionParameters() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> session = context.getExternalContext().getSessionMap();
		
		session.put("GLOBAL.M_PRIVILEGE", "YYY");
		session.put("GLOBAL.M_FAILURE", "FALSE");
//		session.put("GLOBAL.M_USER_ID", "PREMIA");
//		session.put("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
//		session.put("GLOBAL.M_LANG_CODE", "ENG");
//		session.put("GLOBAL.M_PARA_1", "");
//		session.put("GLOBAL.M_PARA_2", "WDNO");
//		session.put("GLOBAL.M_FOR_LANG_CODE", "ARBR2");
		session.put("GLOBAL.M_MODULE_NAME", "PILM203");
//		session.put("GLOBAL.M_DFLT_VALUES", "00101    01    ");
		
	}
	
	
	
	public void std_pre_form(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		Map<String, Object> session = context.getExternalContext().getSessionMap();
		
		ControlBean ctrlBean = getCtrlBean();
		if(ctrlBean == null) {
			ctrlBean = new ControlBean();
			System.out.println("Control bean null");
		}
		
		System.out.println("session STD_PRE_FORM "+session.toString());

		ctrlBean.setM_PROG_NAME("PILM203");
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		setCtrlBean(ctrlBean);
	}

	
	public void preForm(PhaseEvent event) {
		System.out.println("PM_IL_COVER_ACTION.preForm() called");
		
		PM_IL_COVER_DELEGATE delegate = new PM_IL_COVER_DELEGATE();   
		if(isBlockFlag()){
		delegate.setExistingValues(PM_IL_COVER_BEAN);
		postQuery();
		whenNewFormInstance();
		setBlockFlag(false);
		}
		
		//setSessionParameters();
		//std_pre_form();
		//load_dflt_values();
		//preBlock();
		
		//return null;
	}
	
	private void preBlock() {
		getCtrlBean().setM_DELETE_MSG_FLAG("N");
	}
	
	public void whenvalidate_LIMIT_DAYS(ActionEvent event){
		
		UIInput input = (UIInput) event.getComponent().getParent();
		String LIMIT_DAYS = (String) input.getSubmittedValue();
		LIMIT_DAYS = "".equals(LIMIT_DAYS)?"0.0":LIMIT_DAYS;
		getPM_IL_COVER_BEAN().setCOVER_LIMIT_DAYS(Double.valueOf(LIMIT_DAYS));
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	private void whenNewFormInstance() {
	
//		Populating combo box
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		String cover_limit_type = getPM_IL_COVER_BEAN().getCOVER_LIMIT_TYPE();
		System.out.println("PM_IL_COVER_ACTION.whenNewFormInstance() limit_type "+cover_limit_type);
//	Combobox over
		
		if( "D".equalsIgnoreCase(cover_limit_type)) {
			//getCOMP_MANDATORY_COVER_PER_DAY_LC_AMT().setRendered(true);
			getCOMP_COVER_PER_DAY_LC_AMT().setRequired(true);
			getCOMP_COVER_LC_LIMIT().setDisabled(true);
			
			//getCOMP_MANDATORY_COVER_LIMIT_DAYS().setRendered(true);
			getCOMP_COVER_LIMIT_DAYS().setRequired(true);
			
			//getCOMP_MANDATORY_COVER_LC_LIMIT().setRendered(false);
		}else {
			//getCOMP_MANDATORY_COVER_PER_DAY_LC_AMT().setRendered(false);
		//	getCOMP_MANDATORY_COVER_LIMIT_DAYS().setRendered(false);
			
			getCOMP_COVER_PER_DAY_LC_AMT().setDisabled(true);
			getCOMP_COVER_LIMIT_DAYS().setDisabled(true);
			
			//getCOMP_MANDATORY_COVER_LC_LIMIT().setRendered(true);
			getCOMP_COVER_LC_LIMIT().setRequired(true);
		}
	}
	
	private void postQuery() {
		System.out.println("PM_IL_COVER_ACTION.postQuery()");
		PM_IL_COVER coverBean = getPM_IL_COVER_BEAN();
		String cover_limit_type = coverBean.getCOVER_LIMIT_TYPE();
		System.out.println("PM_IL_COVER_ACTION.postQuery() cover_limit_type "+cover_limit_type);
		if( "D".equalsIgnoreCase(cover_limit_type)) {
			getCOMP_COVER_PER_DAY_LC_AMT().setRequired(true);
			getCOMP_COVER_PER_DAY_LC_AMT().setDisabled(false);
			getCOMP_COVER_LIMIT_DAYS().setRequired(true);
			getCOMP_COVER_LIMIT_DAYS().setDisabled(false);
			getCOMP_COVER_LC_LIMIT().setDisabled(true);
			getCOMP_COVER_LC_LIMIT().setRequired(false);
			//getCOMP_MANDATORY_COVER_LC_LIMIT().setRendered(false);
		}else {
			getCOMP_COVER_PER_DAY_LC_AMT().setDisabled(true);
			getCOMP_COVER_PER_DAY_LC_AMT().setRequired(false);
			getCOMP_COVER_LIMIT_DAYS().setDisabled(true);
			getCOMP_COVER_LIMIT_DAYS().setRequired(false);
			getCOMP_COVER_LC_LIMIT().setDisabled(false);
			getCOMP_COVER_LC_LIMIT().setRequired(true);
			//getCOMP_MANDATORY_COVER_PER_DAY_LC_AMT().setRendered(false);
			//getCOMP_MANDATORY_COVER_LIMIT_DAYS().setRendered(false);
		}
	}

	
	private void load_dflt_values() {
		FacesContext context = FacesContext.getCurrentInstance();
		Map map = context.getExternalContext().getSessionMap();
		
		String curr_mode = (String)map.get("CURRENT_MODE");
		if(curr_mode.equalsIgnoreCase("QUERY")) {
			return;
		}else if(curr_mode.equalsIgnoreCase("INSERT")){
//			 INSERT NOT ALLOWED ON PM_IL_COVER BLOCK
		}
	}
	
	public HtmlCommandButton getCOMP_PREFORM_BUTTON() {
		return COMP_PREFORM_BUTTON;
	}

	public void setCOMP_PREFORM_BUTTON(HtmlCommandButton comp_preform_button) {
		COMP_PREFORM_BUTTON = comp_preform_button;
	}

	public ControlBean getCtrlBean() {
		return ctrlBean;
	}

	public void setCtrlBean(ControlBean ctrlBean) {
		this.ctrlBean = ctrlBean;
	}

	
	public List<SelectItem> getLIST_COVER_LIMIT_TYPE() {
		return LIST_COVER_LIMIT_TYPE;
	}

	public void setLIST_COVER_LIMIT_TYPE(List<SelectItem> list_cover_limit_type) {
		LIST_COVER_LIMIT_TYPE = list_cover_limit_type;
	}

	public void validate_COVER_CODE(FacesContext context, UIComponent comp, Object value) throws ValidatorException {
//		P_VAL_CVR(:PM_IL_COVER.COVER_CODE,:PM_IL_COVER.COVER_DESC,'N','E');
		/*try {
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_CVR(?,?,?,?)}");
			cs.setString(1, getPM_IL_COVER_BEAN().getCOVER_CODE());
			cs.setString(2, getPM_IL_COVER_BEAN().getCOVER_DESC());
			cs.setString(3, "N");
			cs.setString(4, "E");
			boolean flag = cs.execute();
			System.out.println("PM_IL_COVER_ACTION.validate_COVER_CODE() flag "+flag);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		
/*		
		PROCEDURE P_VAL_CVR(   P_CVR_CODE IN     VARCHAR2,
                P_CVR_DESC IN OUT VARCHAR2,
                P_NAME_FLAG  IN     VARCHAR2,
                P_ERR_FLAG   IN     VARCHAR2) IS
CURSOR C1 IS
SELECT DECODE(P_NAME_FLAG, 'N', COVER_DESC, COVER_LONG_DESC),
       DECODE(P_NAME_FLAG,'N',COVER_BL_DESC,COVER_BL_LONG_DESC)
FROM   PM_IL_COVER
WHERE  COVER_CODE = P_CVR_CODE;

M_NAME     PM_IL_COVER.COVER_DESC%TYPE;
M_BL_NAME  PM_IL_COVER.COVER_BL_DESC%TYPE;
BEGIN
OPEN C1;
FETCH C1 INTO M_NAME,M_BL_NAME;
IF C1%NOTFOUND THEN
IF P_ERR_FLAG IN ('W','E') THEN
  STD_MESSAGE_ROUTINE(71006, NAME_IN('GLOBAL.M_LANG_CODE')); --JMDKAPOOR 16102008
  IF P_ERR_FLAG = 'E' THEN
     RAISE FORM_TRIGGER_FAILURE;
  END IF ;
END IF;
END IF;
CLOSE C1;


IF SUBSTR(NAME_IN('GLOBAL.M_FOR_LANG_CODE'),5,1) = '1' OR
NAME_IN('GLOBAL.M_LANG_CODE') = 'ENG' THEN
P_CVR_DESC := M_NAME;
ELSE
P_CVR_DESC := M_BL_NAME;
END IF;


END;*/
		if(value!=null)
		{
			String cover_code = value.toString();
			String cover_desc = null;
			System.out.println("PM_IL_COVER_ACTION.populateCoverDesc() covercode "+cover_code);
			CRUDHandler ha = new CRUDHandler();
			try {
				Connection con = CommonUtils.getConnection();
				String query = "select cover_long_desc from pm_il_cover where cover_code = '"+cover_code+"' ";
				ResultSet rs = ha.executeSelectStatement(query, con);
				while(rs.next()){
				cover_desc = rs.getString("COVER_LONG_DESC");
				getCOMP_COVER_DESC().setSubmittedValue(cover_desc);
				}
				if(cover_desc==null)
				{
				//	throw new ValidatorException(Messages.getMessage(PELConstants.pelMessagePropertiesPath, "71006"));
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71006"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void valueChange_LIMIT_TYPE(FacesContext context, UIComponent comp, Object value) throws Exception {
		
		String LIMIT_TYPE = (String) value;
		getPM_IL_COVER_BEAN().setCOVER_LIMIT_TYPE(LIMIT_TYPE);
		/*getPM_IL_COVER_BEAN().setCOVER_LC_LIMIT(0.0);
		getPM_IL_COVER_BEAN().setCOVER_PER_DAY_LC_AMT(0.0);
		getPM_IL_COVER_BEAN().setCOVER_LIMIT_DAYS(0.0);*/
		
		try {
			if(getPM_IL_COVER_BEAN().getCOVER_LIMIT_TYPE().equalsIgnoreCase("D")) {
			getCOMP_COVER_PER_DAY_LC_AMT().setDisabled(false);
			getCOMP_COVER_PER_DAY_LC_AMT().setRequired(true);
			//getCOMP_MANDATORY_COVER_PER_DAY_LC_AMT().setRendered(true);

			getCOMP_COVER_LIMIT_DAYS().setDisabled(false);
			getCOMP_COVER_LIMIT_DAYS().setRequired(true);
			//getCOMP_MANDATORY_COVER_LIMIT_DAYS().setRendered(true);
			
			getCOMP_COVER_LC_LIMIT().setDisabled(true);
			getCOMP_COVER_LC_LIMIT().setRequired(false);
			//getCOMP_MANDATORY_COVER_LC_LIMIT().setRendered(false);
			
			//getCOMP_COVER_PER_DAY_LC_AMT().setSubmittedValue(getPM_IL_COVER_BEAN().getCOVER_PER_DAY_LC_AMT().toString());
			//getCOMP_COVER_LIMIT_DAYS().setSubmittedValue(getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS().toString());
			//getCOMP_COVER_LC_LIMIT().setSubmittedValue(getPM_IL_COVER_BEAN().getCOVER_LC_LIMIT().toString());

			
		} else {
			
			getCOMP_COVER_PER_DAY_LC_AMT().setDisabled(true);
			getCOMP_COVER_PER_DAY_LC_AMT().setRequired(false);
			//getCOMP_MANDATORY_COVER_PER_DAY_LC_AMT().setRendered(false);
			
			getCOMP_COVER_LIMIT_DAYS().setDisabled(true);
			getCOMP_COVER_LIMIT_DAYS().setRequired(false);
			//getCOMP_MANDATORY_COVER_LIMIT_DAYS().setRendered(false);
			
			
			getCOMP_COVER_LC_LIMIT().setDisabled(false);
			getCOMP_COVER_LC_LIMIT().setRequired(true);
			//getCOMP_COVER_LC_LIMIT().setRendered(true);
			
			//getCOMP_MANDATORY_COVER_LC_LIMIT().setRendered(true);
			//getCOMP_COVER_PER_DAY_LC_AMT().setSubmittedValue("");
			//getCOMP_COVER_LIMIT_DAYS().setSubmittedValue("");
		//	getCOMP_COVER_LC_LIMIT().setSubmittedValue("");
			
		}
	/*	COMP_COVER_PER_DAY_LC_AMT.resetValue();
		COMP_COVER_LIMIT_DAYS.resetValue();
		COMP_COVER_LC_LIMIT.resetValue();*/
		}
		catch (Exception e) {
		e.printStackTrace();
		throw e;
		}
		
	}
	
	public void validate_PER_DAY_LC_AMT(FacesContext context, UIComponent comp,
			Object value) throws Exception {
		System.out.println("PM_IL_COVER_ACTION.validate_PER_DAY_LC_AMT()");

		// double amt = getPM_IL_COVER_BEAN().getCOVER_PER_DAY_LC_AMT();	
		double amt = Double.parseDouble(value.toString());
		getPM_IL_COVER_BEAN().setCOVER_PER_DAY_LC_AMT(amt);
		/*
		 * double lc_amt =0.0; if(amt < 0) { FacesMessage
		 * errorMessage=Messages.getMessage(PELConstants.pelErrorMessagePath,
		 * "59005"); throw new ValidatorException(errorMessage); }
		 * if(getPM_IL_COVER_BEAN().getCOVER_LIMIT_TYPE().equalsIgnoreCase("D")) {
		 * lc_amt = amt * getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS();
		 * getPM_IL_COVER_BEAN().setCOVER_LC_LIMIT(lc_amt); } }
		 */
		try {

			if (( CommonUtils.nvl(PM_IL_COVER_BEAN.getCOVER_PER_DAY_LC_AMT(), 0) < 0)) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "59005"));
			}
			if ("D".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_LIMIT_TYPE())) {
				PM_IL_COVER_BEAN.setCOVER_LC_LIMIT((CommonUtils.nvl(PM_IL_COVER_BEAN.getCOVER_LIMIT_DAYS(), 0))
						* (CommonUtils.nvl(PM_IL_COVER_BEAN.getCOVER_PER_DAY_LC_AMT(), 0)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}


	
	
	public void whenvalidate_PER_DAY_LC_AMT(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String PER_DAY_LC_AMT = (String) input.getSubmittedValue();
		PER_DAY_LC_AMT = "".equals(PER_DAY_LC_AMT)?"0.0":PER_DAY_LC_AMT;
		getPM_IL_COVER_BEAN().setCOVER_PER_DAY_LC_AMT(Double.valueOf(PER_DAY_LC_AMT));
		
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void validate_LIMIT_DAYS(FacesContext context, UIComponent comp,
			Object value) throws Exception {
		try{
			if (new CommonUtils().nvl(PM_IL_COVER_BEAN.getCOVER_LIMIT_DAYS(), 0) < 0) {
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "59005"));
		}
		if ("D".equalsIgnoreCase(PM_IL_COVER_BEAN.getCOVER_LIMIT_TYPE())) {
			PM_IL_COVER_BEAN.setCOVER_LC_LIMIT((CommonUtils.nvl(PM_IL_COVER_BEAN.getCOVER_LIMIT_DAYS(), 0))
					* (CommonUtils.nvl(PM_IL_COVER_BEAN.getCOVER_PER_DAY_LC_AMT(), 0)));
		}
	}catch (Exception e) {
		e.printStackTrace();
		throw new ValidatorException(new FacesMessage(e.getMessage()));
	
	}
	   
	}
	
	
	
	
	/*public void validate_LIMIT_DAYS(FacesContext context, UIComponent comp, Object value) {
		System.out.println("PM_IL_COVER_ACTION.validate_LIMIT_DAYS()");
//		double days = getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS();
		double days = Double.parseDouble(value.toString());
		double amt = getPM_IL_COVER_BEAN().getCOVER_PER_DAY_LC_AMT();
		double lc_amt = 0.0;
		
		if(days < 0) {
			FacesMessage error = Messages.getMessage(PELConstants.pelErrorMessagePath, "59005");
			throw new ValidatorException(error);
		}
		if(getPM_IL_COVER_BEAN().getCOVER_LIMIT_TYPE().equalsIgnoreCase("D")) {
			lc_amt = amt * getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS();
			getPM_IL_COVER_BEAN().setCOVER_LC_LIMIT(lc_amt);
		}

	}*/
	public void validate_LC_LIMIT(FacesContext context, UIComponent comp, Object value)throws ValidatorException {
		System.out.println("PM_IL_COVER_ACTION.validate_LC_LIMIT()");
		
/*		   CURSOR C1 IS
		      SELECT COUNT(1)
		      FROM   PM_IL_CVR_BNF_LINK
		      WHERE  CBL_COVER_CODE  = :PM_IL_COVER.COVER_CODE
		      AND    CBL_LIMIT_LC_AMT > :PM_IL_COVER.COVER_LC_LIMIT;
*/
		try {
		String cover_code = getPM_IL_COVER_BEAN().getCOVER_CODE();
		double lc_limit = Double.parseDouble(value.toString());
		
		String qC1 = "select count(1) from PM_IL_CVR_BNF_LINK " +
				"WHERE  CBL_COVER_CODE  = '"+cover_code+"'" +
				"AND    CBL_LIMIT_LC_AMT > '"+lc_limit+"'";
		
		System.out.println("querty "+qC1);
		if(lc_limit < 0) {
			FacesMessage error = Messages.getMessage(PELConstants.pelErrorMessagePath, "59005");
			throw new ValidatorException(error);
		}
		CRUDHandler handler = new CRUDHandler();
		
			ResultSet rs = handler.executeSelectStatement(qC1, CommonUtils.getConnection());
			rs.next();
			int m_count = rs.getInt(1);
			if(m_count > 0) {
				FacesMessage error = Messages.getMessage(PELConstants.pelErrorMessagePath, "92021");
				throw new ValidatorException(error);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			getErrorMap().put("current", "Error while validating COVER_LC_LIMIT ");
			e.printStackTrace();
		}
	}
	
	private void preUpdate() {

		getPM_IL_COVER_BEAN().setCOVER_UPD_DT(new java.util.Date());
		getPM_IL_COVER_BEAN().setCOVER_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		
	}
	
	
	public String save() {
		CRUDHandler handler = new CRUDHandler();
		PM_IL_COVER_DELEGATE pm_il_cover_delegate = new PM_IL_COVER_DELEGATE();
		int rowsUpdated = 0;
		try {
			Connection con = CommonUtils.getConnection();
			if (getPM_IL_COVER_BEAN().getCOVER_FRZ_FLAG() == null) {
				getPM_IL_COVER_BEAN().setCOVER_FRZ_FLAG("N");
			}
			String rowid = pm_il_cover_delegate.getRowId(getPM_IL_COVER_BEAN());
			getPM_IL_COVER_BEAN().setROWID(rowid);
			/*if (getPM_IL_COVER_BEAN().getROWID() == null) {
				if (getPM_IL_COVER_BEAN().getCOVER_FRZ_FLAG() == null) {
					getPM_IL_COVER_BEAN().setCOVER_FRZ_FLAG("N");
				}
				rowsUpdated = pm_il_cover_delegate.insertData(getPM_IL_COVER_BEAN());
				//rowsUpdated = handler.executeInsert(getPM_IL_COVER_BEAN(), con);
				String message=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save");
				System.out.println("INSERT------------------------>"+message);
				getWarningMap().put("current",message);
				getWarningMap().put("details",message);
				System.out.println("UPDATED ROWS:::::"+rowsUpdated);
				if(rowsUpdated>0)
				{
					getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
					getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
				}
			} else {*/
				// PRE_UPDATE
				preUpdate();
				rowsUpdated = pm_il_cover_delegate.insertData(getPM_IL_COVER_BEAN());
				//rowsUpdated = handler.executeInsert(getPM_IL_COVER_BEAN(), con);
				/*String message=Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update");
				System.out.println("UPDATE------------------------>"+message);
				getWarningMap().put("current",message);
				getWarningMap().put("details",message);*/
				if(rowsUpdated>0)
				{
					getWarningMap().put("current",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
					getWarningMap().put("somekey",Messages.getString(PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
				}
		//}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	public String saveNext() {
		
		save();
		nextBlock_PM_IL_CVR_BNF_LINK();
		return "nextpage";
	}
	
	public String prevPage() {
		return "prevpage";
	}
	
	public String nextPage() {
		
		CRUDHandler handler = new CRUDHandler();
		try {
			int i = handler.executeInsert(getPM_IL_COVER_BEAN(), CommonUtils.getConnection());
			System.out.println("PM_IL_COVER_ACTION.nextPage() i "+i);
			nextBlock_PM_IL_CVR_BNF_LINK();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "nextpage";
	}
	
	public String first() {
		return "firstpage";
	}
	public String last() {
		return "lastpage";
	}
	
	public void delete() {
		FacesMessage warning = new FacesMessage();
		warning.setSeverity(FacesMessage.SEVERITY_INFO);
		warning.setDetail("Delete record is not allowed on this block");
		warning.setSummary("Delete record is not allowed on this block");
		try{
			getErrorMap().put("current", "Delete record is not allowed on this block");
		}catch (Exception e) {
			
		}
		
	}
	
	public void nextBlock_PM_IL_CVR_BNF_LINK() {
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_CVR_BNF_LINK_ACTION bnfLinkAction = (PM_IL_CVR_BNF_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_CVR_BNF_LINK_ACTION");
		
		String cover_code = getPM_IL_COVER_BEAN().getCOVER_CODE();
		
		String queryForBnfLink = "select ROWID,PM_IL_CVR_BNF_LINK.*  from PM_IL_CVR_BNF_LINK " +
				"where CBL_COVER_CODE = '"+cover_code+"'";
		System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_BNF_LINK() query "+queryForBnfLink);
//	 POPULATING COMBO BOX	
		
		try{
			List<SelectItem> list =  ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM203", "PM_IL_CVR_BNF_LINK", "PM_IL_CVR_BNF_LINK.CBL_LIMIT_TYP", "CVRLMTTYP");
			bnfLinkAction.setLIST_LIMIT_TYPE(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
//  COMBOBOX DONE		
		List<PM_IL_CVR_BNF_LINK> listBeanValue = null;
		
		CRUDHandler handler = new CRUDHandler();
		try {
			/*if(  listBeanValue !=null && listBeanValue.size()!=0)
				listBeanValue.clear();
			*/
			listBeanValue =   handler.fetch(queryForBnfLink, "com.iii.pel.forms.PILM203.PM_IL_CVR_BNF_LINK", CommonUtils.getConnection());
			System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_BNF_LINK() list size "+listBeanValue.size());
 			
			if(listBeanValue != null && listBeanValue.size() > 0) {
				bnfLinkAction.getLIST_dataTable().clear(); 
			
				PM_IL_CVR_BNF_LINK valueBean = listBeanValue.get(0);
				System.out.println(valueBean.getCBL_BNF_CODE()+"  "+valueBean.getCBL_LIMIT_DAYS()+" LIMIT AMOUNT:::"+valueBean.getCBL_LIMIT_LC_AMT());
				bnfLinkAction.setLIST_dataTable(listBeanValue);
				 
				int length = listBeanValue.size();
				for(int i=0;i<length;i++){
					PM_IL_CVR_BNF_LINK bnfLinkBean = listBeanValue.get(i);
					String LIMIT_TYPE = bnfLinkBean.getCBL_LIMIT_TYP();
					System.out.println("LIMIT TYPE:::::"+LIMIT_TYPE);
					if(LIMIT_TYPE.equals("F")){
						bnfLinkBean.setCBL_LIMIT_DAYS_DISABLE(true);
						bnfLinkBean.setCBL_PER_DAY_LC_LIMIT_DISABLE(true);
						//bnfLinkBean.setCBL_LIMIT_DAYS(null);
						//bnfLinkBean.setCBL_PER_DAY_LC_LIMIT(null);
					}else{
						bnfLinkBean.setCBL_LIMIT_LC_AMT_DISABLE(true);
						//bnfLinkBean.setCBL_LIMIT_LC_AMT(null);
					}
					bnfLinkAction.postQuery(bnfLinkBean);
					bnfLinkAction.getPM_IL_CVR_BNF_LINK_BEAN().setRowSelected(false);
				}
				PM_IL_CVR_BNF_LINK PM_IL_CVR_BNF_LINK_BEAN =null;
				Iterator<PM_IL_CVR_BNF_LINK> listIterator= listBeanValue.iterator();
				while(listIterator.hasNext()){
					PM_IL_CVR_BNF_LINK_BEAN  = listIterator.next();
					PM_IL_CVR_BNF_LINK_BEAN.setRowSelected(false);
				}
				bnfLinkAction.setPM_IL_CVR_BNF_LINK_BEAN(valueBean);
				bnfLinkAction.getPM_IL_CVR_BNF_LINK_BEAN().setRowSelected(true);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

	public List getCoverCodeList() {
		return coverCodeList;
	}

	public void setCoverCodeList(List coverCodeList) {
		this.coverCodeList = coverCodeList;
	}
	
	 public String backToSearch() {
			return SearchConstants.BACK_TO_SEARCH_PAGE;
	    }
	
	

	
}