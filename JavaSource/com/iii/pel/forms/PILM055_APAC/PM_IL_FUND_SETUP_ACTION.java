package com.iii.pel.forms.PILM055_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.richfaces.component.html.HtmlCalendar;

import com.adventnet.swissql.b.a.ac.r;
import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.tahoe.appbuilder.manager.migrator.ErrorMessageMigrator;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.commonimpl.tabimpl.TabbedBar;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_FUND_SETUP_ACTION  extends CommonAction {

	private HtmlOutputLabel COMP_FS_MIN_WD_LC_AMT_LABEL;

	private HtmlInputText COMP_FS_MIN_WD_LC_AMT;

	private HtmlOutputLabel COMP_FS_MIN_DAY_WD_LABEL;

	private HtmlInputText COMP_FS_MIN_DAY_WD;

	private HtmlOutputLabel COMP_FS_MIN_WD_BAL_LC_AMT_LABEL;

	private HtmlInputText COMP_FS_MIN_WD_BAL_LC_AMT;

	private HtmlOutputLabel COMP_FS_DUR_FOR_WD_LABEL;

	private HtmlInputText COMP_FS_DUR_FOR_WD;

	private HtmlOutputLabel COMP_FS_SW_MAX_NO_LABEL;

	private HtmlInputText COMP_FS_SW_MAX_NO;

	private HtmlOutputLabel COMP_FS_SW_WAIT_PERIOD_LABEL;

	private HtmlInputText COMP_FS_SW_WAIT_PERIOD;

	private HtmlOutputLabel COMP_FS_SW_MIN_BAL_LC_AMT_LABEL;

	private HtmlInputText COMP_FS_SW_MIN_BAL_LC_AMT;

	private HtmlOutputLabel COMP_FS_DUR_FOR_SW_LABEL;

	private HtmlInputText COMP_FS_DUR_FOR_SW;

	private HtmlOutputLabel COMP_FS_FRZ_YN_LABEL;

	private HtmlSelectBooleanCheckbox COMP_FS_FRZ_YN;

	private HtmlOutputLabel COMP_FS_CODE_LABEL;

	private HtmlInputText COMP_FS_CODE;

	private HtmlOutputLabel COMP_FS_DESC_LABEL;

	private HtmlInputText COMP_FS_DESC;

	private HtmlOutputLabel COMP_FS_SHORT_DESC_LABEL;

	private HtmlInputText COMP_FS_SHORT_DESC;

	private HtmlOutputLabel COMP_FS_LONG_DESC_LABEL;

	private HtmlInputText COMP_FS_LONG_DESC;

	private HtmlOutputLabel COMP_FS_BL_DESC_LABEL;

	private HtmlInputText COMP_FS_BL_DESC;

	private HtmlOutputLabel COMP_FS_BL_SHORT_DESC_LABEL;

	private HtmlInputText COMP_FS_BL_SHORT_DESC;

	private HtmlOutputLabel COMP_FS_FUND_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_FS_FUND_TYPE;

	private HtmlOutputLabel COMP_FS_FRAC_UNIT_YN_LABEL;

	private HtmlSelectOneMenu COMP_FS_FRAC_UNIT_YN;

	private HtmlOutputLabel COMP_FS_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_FS_EFF_FM_DT;

	private HtmlOutputLabel COMP_FS_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_FS_EFF_TO_DT;

	private HtmlOutputLabel COMP_FS_ROUND_OPTION_LABEL;

	private HtmlSelectOneMenu COMP_FS_ROUND_OPTION;

	private HtmlOutputLabel COMP_FS_ROUND_VALUE_LABEL;

	private HtmlInputText COMP_FS_ROUND_VALUE;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_BL_LONG_DESC;

	private HtmlCommandButton COMP_UI_M_BUT_EDITOR_LONG_DESC;
	
	private HtmlCommandButton Testing_Button; 

	private PM_IL_FUND_SETUP PM_IL_FUND_SETUP_BEAN;
	
	private boolean isUpdate;
	
	public CompositeAction PILM055_APAC_CompositeAction;
	
	private String errmsg = null;
	
	private boolean codeFlag;
	
	private TabbedBar tabbedBar;
	
	PM_IL_FUND_SETUP details = null;
	
	PM_IL_FUND_PRICE_DTL child = null;
	
	String FS_CODE = null;
	
	
	//private Map<String, String> errorMap = new HashMap<String, String>();
	
	 
	
	Connection con;
	
	ServletContext context;
	CRUDHandler handler = new CRUDHandler();
	
	Map<String,Object> session;
	
	private List<SelectItem>  FS_FUND_TYPE_LIST  = new  ArrayList<SelectItem>();
	private List<SelectItem>  FS_FRAC_UNIT_YN_LIST = new ArrayList<SelectItem>();
	private List<SelectItem>  FS_ROUND_OPTION_LIST = new ArrayList<SelectItem>();
	
	public List<SelectItem> getFS_FUND_TYPE_LIST() throws Exception {
		//System.out.println("PM_IL_FUND_SETUP_ACTION.getFS_FUND_TYPE_LIST()-Inside" +FS_FUND_TYPE_LIST.size());
		if(FS_FUND_TYPE_LIST.size()==0 ){
			System.out.println("PM_IL_FUND_SETUP_ACTION.getFS_FUND_TYPE_LIST()-Inside_If");
	   	FS_FUND_TYPE_LIST.clear();
		con = CommonUtils.getConnection();
		FS_FUND_TYPE_LIST = ListItemUtil.getDropDownListValue(con, "PILM055_APAC", "PM_IL_FUND_SETUP", "PM_IL_FUND_SETUP.FS_FUND_TYPE", "LI_FUND_TYPE");
		
		}
		return FS_FUND_TYPE_LIST;
	}

	public void setFS_FUND_TYPE_LIST(List<SelectItem> fs_fund_type_list) {
		FS_FUND_TYPE_LIST = fs_fund_type_list;
	}

	public List<SelectItem> getFS_FRAC_UNIT_YN_LIST() throws Exception {
		con = CommonUtils.getConnection();
		if(FS_FRAC_UNIT_YN_LIST.size()==0){
			FS_FRAC_UNIT_YN_LIST.clear();
			FS_FRAC_UNIT_YN_LIST = ListItemUtil.getDropDownListValue(con,"PILM055_APAC" ,"PM_IL_FUND_SETUP", "PM_IL_FUND_SETUP.FS_FRAC_UNIT_YN", "YESNO");
            
           }
		
		return FS_FRAC_UNIT_YN_LIST;
	}

	public void setFS_FRAC_UNIT_YN_LIST(List<SelectItem> fs_frac_unit_yn_list) {
		FS_FRAC_UNIT_YN_LIST = fs_frac_unit_yn_list;
	}

	public List<SelectItem> getFS_ROUND_OPTION_LIST() throws Exception {
		con = CommonUtils.getConnection();
		if(FS_ROUND_OPTION_LIST.size()==0){
			FS_ROUND_OPTION_LIST.clear();
			FS_ROUND_OPTION_LIST = ListItemUtil.getDropDownListValue(con,"PILM055_APAC" ,"PM_IL_FUND_SETUP", "PM_IL_FUND_SETUP.FS_ROUND_OPTION", "IL_ROUND");
            
           }
		
		return FS_ROUND_OPTION_LIST;
	}

	public void setFS_ROUND_OPTION_LIST(List<SelectItem> fs_round_option_list) {
		FS_ROUND_OPTION_LIST = fs_round_option_list;
	}

	public PM_IL_FUND_SETUP_ACTION() {
		
		instantiateAllComponent();
		PM_IL_FUND_SETUP_BEAN = new PM_IL_FUND_SETUP();
		/*handler = new CRUDHandler();
		this.tabbedBar = new TabbedBar();
		try{
			this.tabbedBar.addTab(1, "#{PILM055_APAC_PM_IL_FUND_SETUP_ACTION.goto_PM_IL_FUND_SETUP}", "Fund Master Setup", false);
			this.tabbedBar.addTab(2, "#{PILM055_APAC_PM_IL_FUND_SETUP_ACTION.goto_PM_IL_PRICE_DTL}", "Unit Details", false);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}*/
		
	}		
		//removeDecimalValue();
	

	public void removeDecimalValue(PM_IL_FUND_SETUP PM_IL_FUND_SETUP_BEAN){
		/*System.out.println("**********************************************");
		System.out.println(PM_IL_FUND_SETUP_BEAN.getFS_SW_MIN_BAL_LC_AMT());
		String MIN_BAL_LC_AMT = PM_IL_FUND_SETUP_BEAN.getFS_SW_MIN_BAL_LC_AMT().toString();
		System.out.println("THE STRING VALUE " + MIN_BAL_LC_AMT );
		System.out.println("LENGHT IS" + MIN_BAL_LC_AMT.length());
		int index = MIN_BAL_LC_AMT.indexOf(".");
		System.out.println("THE INDEX IS " +index);
		String Sub_String =MIN_BAL_LC_AMT.substring(index + 1);
		System.out.println("Sub_String"+Sub_String);
		
		System.out.println("**********************************************");
		System.out.println("getCOMP_FS_SW_MIN_BAL_LC_AMT()"+getCOMP_FS_SW_MIN_BAL_LC_AMT());
		getCOMP_FS_SW_MIN_BAL_LC_AMT().setValue(MIN_BAL_LC_AMT);*/ 
		
		
	}
	public HtmlOutputLabel getCOMP_FS_MIN_WD_LC_AMT_LABEL() {
		return COMP_FS_MIN_WD_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_FS_MIN_WD_LC_AMT() {
		return COMP_FS_MIN_WD_LC_AMT;
	}

	public void setCOMP_FS_MIN_WD_LC_AMT_LABEL(HtmlOutputLabel COMP_FS_MIN_WD_LC_AMT_LABEL) {
		this.COMP_FS_MIN_WD_LC_AMT_LABEL = COMP_FS_MIN_WD_LC_AMT_LABEL;
	}

	public void setCOMP_FS_MIN_WD_LC_AMT(HtmlInputText COMP_FS_MIN_WD_LC_AMT) {
		this.COMP_FS_MIN_WD_LC_AMT = COMP_FS_MIN_WD_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_FS_MIN_DAY_WD_LABEL() {
		return COMP_FS_MIN_DAY_WD_LABEL;
	}

	public HtmlInputText getCOMP_FS_MIN_DAY_WD() {
		return COMP_FS_MIN_DAY_WD;
	}

	public void setCOMP_FS_MIN_DAY_WD_LABEL(HtmlOutputLabel COMP_FS_MIN_DAY_WD_LABEL) {
		this.COMP_FS_MIN_DAY_WD_LABEL = COMP_FS_MIN_DAY_WD_LABEL;
	}

	public void setCOMP_FS_MIN_DAY_WD(HtmlInputText COMP_FS_MIN_DAY_WD) {
		this.COMP_FS_MIN_DAY_WD = COMP_FS_MIN_DAY_WD;
	}

	public HtmlOutputLabel getCOMP_FS_MIN_WD_BAL_LC_AMT_LABEL() {
		return COMP_FS_MIN_WD_BAL_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_FS_MIN_WD_BAL_LC_AMT() {
		return COMP_FS_MIN_WD_BAL_LC_AMT;
	}

	public void setCOMP_FS_MIN_WD_BAL_LC_AMT_LABEL(HtmlOutputLabel COMP_FS_MIN_WD_BAL_LC_AMT_LABEL) {
		this.COMP_FS_MIN_WD_BAL_LC_AMT_LABEL = COMP_FS_MIN_WD_BAL_LC_AMT_LABEL;
	}

	public void setCOMP_FS_MIN_WD_BAL_LC_AMT(HtmlInputText COMP_FS_MIN_WD_BAL_LC_AMT) {
		this.COMP_FS_MIN_WD_BAL_LC_AMT = COMP_FS_MIN_WD_BAL_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_FS_DUR_FOR_WD_LABEL() {
		return COMP_FS_DUR_FOR_WD_LABEL;
	}

	public HtmlInputText getCOMP_FS_DUR_FOR_WD() {
		return COMP_FS_DUR_FOR_WD;
	}

	public void setCOMP_FS_DUR_FOR_WD_LABEL(HtmlOutputLabel COMP_FS_DUR_FOR_WD_LABEL) {
		this.COMP_FS_DUR_FOR_WD_LABEL = COMP_FS_DUR_FOR_WD_LABEL;
	}

	public void setCOMP_FS_DUR_FOR_WD(HtmlInputText COMP_FS_DUR_FOR_WD) {
		this.COMP_FS_DUR_FOR_WD = COMP_FS_DUR_FOR_WD;
	}

	public HtmlOutputLabel getCOMP_FS_SW_MAX_NO_LABEL() {
		return COMP_FS_SW_MAX_NO_LABEL;
	}

	public HtmlInputText getCOMP_FS_SW_MAX_NO() {
		return COMP_FS_SW_MAX_NO;
	}

	public void setCOMP_FS_SW_MAX_NO_LABEL(HtmlOutputLabel COMP_FS_SW_MAX_NO_LABEL) {
		this.COMP_FS_SW_MAX_NO_LABEL = COMP_FS_SW_MAX_NO_LABEL;
	}

	public void setCOMP_FS_SW_MAX_NO(HtmlInputText COMP_FS_SW_MAX_NO) {
		this.COMP_FS_SW_MAX_NO = COMP_FS_SW_MAX_NO;
	}

	public HtmlOutputLabel getCOMP_FS_SW_WAIT_PERIOD_LABEL() {
		return COMP_FS_SW_WAIT_PERIOD_LABEL;
	}

	public HtmlInputText getCOMP_FS_SW_WAIT_PERIOD() {
		return COMP_FS_SW_WAIT_PERIOD;
	}

	public void setCOMP_FS_SW_WAIT_PERIOD_LABEL(HtmlOutputLabel COMP_FS_SW_WAIT_PERIOD_LABEL) {
		this.COMP_FS_SW_WAIT_PERIOD_LABEL = COMP_FS_SW_WAIT_PERIOD_LABEL;
	}

	public void setCOMP_FS_SW_WAIT_PERIOD(HtmlInputText COMP_FS_SW_WAIT_PERIOD) {
		this.COMP_FS_SW_WAIT_PERIOD = COMP_FS_SW_WAIT_PERIOD;
	}

	public HtmlOutputLabel getCOMP_FS_SW_MIN_BAL_LC_AMT_LABEL() {
		return COMP_FS_SW_MIN_BAL_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_FS_SW_MIN_BAL_LC_AMT() {
		
		return COMP_FS_SW_MIN_BAL_LC_AMT;
	}

	public void setCOMP_FS_SW_MIN_BAL_LC_AMT_LABEL(HtmlOutputLabel COMP_FS_SW_MIN_BAL_LC_AMT_LABEL) {
		this.COMP_FS_SW_MIN_BAL_LC_AMT_LABEL = COMP_FS_SW_MIN_BAL_LC_AMT_LABEL;
	}

	public void setCOMP_FS_SW_MIN_BAL_LC_AMT(HtmlInputText COMP_FS_SW_MIN_BAL_LC_AMT) {
		this.COMP_FS_SW_MIN_BAL_LC_AMT = COMP_FS_SW_MIN_BAL_LC_AMT;
	}

	public HtmlOutputLabel getCOMP_FS_DUR_FOR_SW_LABEL() {
		return COMP_FS_DUR_FOR_SW_LABEL;
	}

	public HtmlInputText getCOMP_FS_DUR_FOR_SW() {
		return COMP_FS_DUR_FOR_SW;
	}

	public void setCOMP_FS_DUR_FOR_SW_LABEL(HtmlOutputLabel COMP_FS_DUR_FOR_SW_LABEL) {
		this.COMP_FS_DUR_FOR_SW_LABEL = COMP_FS_DUR_FOR_SW_LABEL;
	}

	public void setCOMP_FS_DUR_FOR_SW(HtmlInputText COMP_FS_DUR_FOR_SW) {
		this.COMP_FS_DUR_FOR_SW = COMP_FS_DUR_FOR_SW;
	}

	public HtmlOutputLabel getCOMP_FS_FRZ_YN_LABEL() {
		return COMP_FS_FRZ_YN_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_FS_FRZ_YN() {
		return COMP_FS_FRZ_YN;
	}

	public void setCOMP_FS_FRZ_YN_LABEL(HtmlOutputLabel COMP_FS_FRZ_YN_LABEL) {
		this.COMP_FS_FRZ_YN_LABEL = COMP_FS_FRZ_YN_LABEL;
	}

	public void setCOMP_FS_FRZ_YN(HtmlSelectBooleanCheckbox COMP_FS_FRZ_YN) {
		this.COMP_FS_FRZ_YN = COMP_FS_FRZ_YN;
	}

	public HtmlOutputLabel getCOMP_FS_CODE_LABEL() {
		return COMP_FS_CODE_LABEL;
	}

	public HtmlInputText getCOMP_FS_CODE() {
		return COMP_FS_CODE;
	}

	public void setCOMP_FS_CODE_LABEL(HtmlOutputLabel COMP_FS_CODE_LABEL) {
		this.COMP_FS_CODE_LABEL = COMP_FS_CODE_LABEL;
	}

	public void setCOMP_FS_CODE(HtmlInputText COMP_FS_CODE) {
		this.COMP_FS_CODE = COMP_FS_CODE;
	}

	public HtmlOutputLabel getCOMP_FS_DESC_LABEL() {
		return COMP_FS_DESC_LABEL;
	}

	public HtmlInputText getCOMP_FS_DESC() {
		return COMP_FS_DESC;
	}

	public void setCOMP_FS_DESC_LABEL(HtmlOutputLabel COMP_FS_DESC_LABEL) {
		this.COMP_FS_DESC_LABEL = COMP_FS_DESC_LABEL;
	}

	public void setCOMP_FS_DESC(HtmlInputText COMP_FS_DESC) {
		this.COMP_FS_DESC = COMP_FS_DESC;
	}

	public HtmlOutputLabel getCOMP_FS_SHORT_DESC_LABEL() {
		return COMP_FS_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_FS_SHORT_DESC() {
		return COMP_FS_SHORT_DESC;
	}

	public void setCOMP_FS_SHORT_DESC_LABEL(HtmlOutputLabel COMP_FS_SHORT_DESC_LABEL) {
		this.COMP_FS_SHORT_DESC_LABEL = COMP_FS_SHORT_DESC_LABEL;
	}

	public void setCOMP_FS_SHORT_DESC(HtmlInputText COMP_FS_SHORT_DESC) {
		this.COMP_FS_SHORT_DESC = COMP_FS_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_FS_LONG_DESC_LABEL() {
		return COMP_FS_LONG_DESC_LABEL;
	}

	public HtmlInputText getCOMP_FS_LONG_DESC() {
		return COMP_FS_LONG_DESC;
	}

	public void setCOMP_FS_LONG_DESC_LABEL(HtmlOutputLabel COMP_FS_LONG_DESC_LABEL) {
		this.COMP_FS_LONG_DESC_LABEL = COMP_FS_LONG_DESC_LABEL;
	}

	public void setCOMP_FS_LONG_DESC(HtmlInputText COMP_FS_LONG_DESC) {
		this.COMP_FS_LONG_DESC = COMP_FS_LONG_DESC;
	}

	public HtmlOutputLabel getCOMP_FS_BL_DESC_LABEL() {
		return COMP_FS_BL_DESC_LABEL;
	}

	public HtmlInputText getCOMP_FS_BL_DESC() {
		return COMP_FS_BL_DESC;
	}

	public void setCOMP_FS_BL_DESC_LABEL(HtmlOutputLabel COMP_FS_BL_DESC_LABEL) {
		this.COMP_FS_BL_DESC_LABEL = COMP_FS_BL_DESC_LABEL;
	}

	public void setCOMP_FS_BL_DESC(HtmlInputText COMP_FS_BL_DESC) {
		this.COMP_FS_BL_DESC = COMP_FS_BL_DESC;
	}

	public HtmlOutputLabel getCOMP_FS_BL_SHORT_DESC_LABEL() {
		return COMP_FS_BL_SHORT_DESC_LABEL;
	}

	public HtmlInputText getCOMP_FS_BL_SHORT_DESC() {
		return COMP_FS_BL_SHORT_DESC;
	}

	public void setCOMP_FS_BL_SHORT_DESC_LABEL(HtmlOutputLabel COMP_FS_BL_SHORT_DESC_LABEL) {
		this.COMP_FS_BL_SHORT_DESC_LABEL = COMP_FS_BL_SHORT_DESC_LABEL;
	}

	public void setCOMP_FS_BL_SHORT_DESC(HtmlInputText COMP_FS_BL_SHORT_DESC) {
		this.COMP_FS_BL_SHORT_DESC = COMP_FS_BL_SHORT_DESC;
	}

	public HtmlOutputLabel getCOMP_FS_FUND_TYPE_LABEL() {
		return COMP_FS_FUND_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FS_FUND_TYPE() {
		return COMP_FS_FUND_TYPE;
	}

	public void setCOMP_FS_FUND_TYPE_LABEL(HtmlOutputLabel COMP_FS_FUND_TYPE_LABEL) {
		this.COMP_FS_FUND_TYPE_LABEL = COMP_FS_FUND_TYPE_LABEL;
	}

	public void setCOMP_FS_FUND_TYPE(HtmlSelectOneMenu COMP_FS_FUND_TYPE) {
		this.COMP_FS_FUND_TYPE = COMP_FS_FUND_TYPE;
	}

	public HtmlOutputLabel getCOMP_FS_FRAC_UNIT_YN_LABEL() {
		return COMP_FS_FRAC_UNIT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FS_FRAC_UNIT_YN() {
		return COMP_FS_FRAC_UNIT_YN;
	}

	public void setCOMP_FS_FRAC_UNIT_YN_LABEL(HtmlOutputLabel COMP_FS_FRAC_UNIT_YN_LABEL) {
		this.COMP_FS_FRAC_UNIT_YN_LABEL = COMP_FS_FRAC_UNIT_YN_LABEL;
	}

	public void setCOMP_FS_FRAC_UNIT_YN(HtmlSelectOneMenu COMP_FS_FRAC_UNIT_YN) {
		this.COMP_FS_FRAC_UNIT_YN = COMP_FS_FRAC_UNIT_YN;
	}

	public HtmlOutputLabel getCOMP_FS_EFF_FM_DT_LABEL() {
		return COMP_FS_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FS_EFF_FM_DT() {
		return COMP_FS_EFF_FM_DT;
	}

	public void setCOMP_FS_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_FS_EFF_FM_DT_LABEL) {
		this.COMP_FS_EFF_FM_DT_LABEL = COMP_FS_EFF_FM_DT_LABEL;
	}

	public void setCOMP_FS_EFF_FM_DT(HtmlCalendar COMP_FS_EFF_FM_DT) {
		this.COMP_FS_EFF_FM_DT = COMP_FS_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_FS_EFF_TO_DT_LABEL() {
		return COMP_FS_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_FS_EFF_TO_DT() {
		return COMP_FS_EFF_TO_DT;
	}

	public void setCOMP_FS_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_FS_EFF_TO_DT_LABEL) {
		this.COMP_FS_EFF_TO_DT_LABEL = COMP_FS_EFF_TO_DT_LABEL;
	}

	public void setCOMP_FS_EFF_TO_DT(HtmlCalendar COMP_FS_EFF_TO_DT) {
		this.COMP_FS_EFF_TO_DT = COMP_FS_EFF_TO_DT;
	}

	public HtmlOutputLabel getCOMP_FS_ROUND_OPTION_LABEL() {
		return COMP_FS_ROUND_OPTION_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_FS_ROUND_OPTION() {
		return COMP_FS_ROUND_OPTION;
	}

	public void setCOMP_FS_ROUND_OPTION_LABEL(HtmlOutputLabel COMP_FS_ROUND_OPTION_LABEL) {
		this.COMP_FS_ROUND_OPTION_LABEL = COMP_FS_ROUND_OPTION_LABEL;
	}

	public void setCOMP_FS_ROUND_OPTION(HtmlSelectOneMenu COMP_FS_ROUND_OPTION) {
		this.COMP_FS_ROUND_OPTION = COMP_FS_ROUND_OPTION;
	}

	public HtmlOutputLabel getCOMP_FS_ROUND_VALUE_LABEL() {
		return COMP_FS_ROUND_VALUE_LABEL;
	}

	public HtmlInputText getCOMP_FS_ROUND_VALUE() {
		return COMP_FS_ROUND_VALUE;
	}

	public void setCOMP_FS_ROUND_VALUE_LABEL(HtmlOutputLabel COMP_FS_ROUND_VALUE_LABEL) {
		this.COMP_FS_ROUND_VALUE_LABEL = COMP_FS_ROUND_VALUE_LABEL;
	}

	public void setCOMP_FS_ROUND_VALUE(HtmlInputText COMP_FS_ROUND_VALUE) {
		this.COMP_FS_ROUND_VALUE = COMP_FS_ROUND_VALUE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_BL_LONG_DESC() {
		return COMP_UI_M_BUT_EDITOR_BL_LONG_DESC;
	}

	public void setCOMP_UI_M_BUT_EDITOR_BL_LONG_DESC(HtmlCommandButton COMP_UI_M_BUT_EDITOR_BL_LONG_DESC) {
		this.COMP_UI_M_BUT_EDITOR_BL_LONG_DESC = COMP_UI_M_BUT_EDITOR_BL_LONG_DESC;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_EDITOR_LONG_DESC() {
		return COMP_UI_M_BUT_EDITOR_LONG_DESC;
	}

	public void setCOMP_UI_M_BUT_EDITOR_LONG_DESC(HtmlCommandButton COMP_UI_M_BUT_EDITOR_LONG_DESC) {
		this.COMP_UI_M_BUT_EDITOR_LONG_DESC = COMP_UI_M_BUT_EDITOR_LONG_DESC;
	}

	public PM_IL_FUND_SETUP getPM_IL_FUND_SETUP_BEAN() {
		return PM_IL_FUND_SETUP_BEAN;
	}

	public void setPM_IL_FUND_SETUP_BEAN(PM_IL_FUND_SETUP PM_IL_FUND_SETUP_BEAN) {
		System.out.println("PM_IL_FUND_SETUP_ACTION.setPM_IL_FUND_SETUP_BEAN()");
		this.PM_IL_FUND_SETUP_BEAN = PM_IL_FUND_SETUP_BEAN;
		//removeDecimalValue(PM_IL_FUND_SETUP_BEAN); 
	}
	
	public boolean isUpdate() {
		return isUpdate;
	}

	public void setUpdate(boolean isUpdate) {
		this.isUpdate = isUpdate;
	}
	
	
	/*public Connection getConnection() throws Exception{
		context =(ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		con = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("123456");
		return con;
	}*/
	
	
	

	public void FS_DESC_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_DESC_WHEN_VALIDATE_ITEM()-Inside");

		String FS_DESC = getCOMP_FS_DESC().getSubmittedValue().toString();
		if(FS_DESC != null){
			System.out.println("PM_IL_FUND_SETUP_ACTION.FS_DESC_WHEN_VALIDATE_ITEM()-Inside");
			getCOMP_FS_SHORT_DESC().setSubmittedValue(FS_DESC);
			getCOMP_FS_LONG_DESC().setSubmittedValue(FS_DESC);
		}

	}
	
	
	public void FS_BL_DESC_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_BL_DESC_WHEN_VALIDATE_ITEM()-Inside");
		String FS_BL_DESC = getCOMP_FS_BL_DESC().getSubmittedValue().toString();
		if(FS_BL_DESC!=null){
		  getCOMP_FS_BL_SHORT_DESC().setSubmittedValue(FS_BL_DESC);	
		}
	}
	
	 public void FS_EFF_FM_DT_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_EFF_FM_DT_WHEN_VALIDATE_ITEM()-Inside");
		String STRING_FS_EFF_FM_DT = null;
		java.util.Date val = getCOMP_FS_EFF_FM_DT().getAsDate(getCOMP_FS_EFF_FM_DT().getSubmittedValue());
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_EFF_FM_DT_WHEN_VALIDATE_ITEM()-value"+val);
		STRING_FS_EFF_FM_DT = format_Date(val);
		if(STRING_FS_EFF_FM_DT!=null){
		Date DATE_FS_EFF_FM_DT = StringToDate(STRING_FS_EFF_FM_DT);
		if(DATE_FS_EFF_FM_DT != null){
			java.util.Date SYS_DATE = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
			if(dateGreaterthenOrEqualTo(DATE_FS_EFF_FM_DT,SYS_DATE)){
				System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.FPD_EFF_FM_DT_WHEN_VALIDATE_ITEM()");
				System.out.println("ERRORRRR !!!  FROM DATE GEREATER THAN SYSTEM DATE");
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "60021").getDetail());
			}else{
     		System.out.println("Else Part In Action--------");
			getErrorMap().clear();
			}
		}
		}
		//Added by gopi for kic on 02/04/2019
		else{
			try {
				throw new Exception("Effective From Date: value is required");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("From date", e.getMessage());
			}
		}
		//end
			
		
 	}
	
		public String format_Date(java.util.Date date){
			System.out.println("Date" + date);
			String result=null; 
			if(date!=null){
				SimpleDateFormat sdf = new SimpleDateFormat(PELConstants.pelDateFormat);
				result = sdf.format(date).toString();
				System.out.println("Formatted Date is = "+result);
			}
			return result;
		}
	
		public Date StringToDate(String dateString){
		 	System.out.println("DateString Is" + dateString);
				   
				   java.util.Date date = null;
				   java.sql.Date sqlDate=null;
				   if(!dateString.equals("")|| dateString==null) {
					   try {
						date = new SimpleDateFormat(PELConstants.pelDateFormat).parse(dateString);
						long sqlDateLong=date.getTime();
						sqlDate=new java.sql.Date(sqlDateLong);
						System.out.println("CommonUtils.stringToDate()-sqlDate"+sqlDate);
				      } catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				   }
				return sqlDate;
			   }
			
		public  boolean dateGreaterthenOrEqualTo(java.util.Date date1,java.util.Date date2){
		 	boolean flag=false;
		 	if(date1.after(date2)||date1.equals(date2)){
		 		flag=true;
		 	}
		 	return flag;
		 }
	
	

	public void FS_EFF_TO_DT_WHEN_VALIDATE_ITEM(ActionEvent event){
		
		
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_EFF_TO_DT_WHEN_VALIDATE_ITEM()-Inside");
		
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_EFF_TO_DT_WHEN_VALIDATE_ITEM()");
		String STRING_FS_EFF_TO_DT = getCOMP_FS_EFF_TO_DT().getSubmittedValue().toString();
		String STRING_FS_EFF_FM_DT = getCOMP_FS_EFF_FM_DT().getSubmittedValue().toString();
				
		Date DATE_FPD_EFF_FM_DT = StringToDate(STRING_FS_EFF_FM_DT);
		Date DATE_FPD_EFF_TO_DT = StringToDate(STRING_FS_EFF_TO_DT);
		
		if(DATE_FPD_EFF_TO_DT !=  null){
			if(dateLessthen(DATE_FPD_EFF_TO_DT, DATE_FPD_EFF_FM_DT)){
				errmsg = STD_MESSAGE_ROUTINE("91001",CommonUtils.getControlBean().getM_LANG_CODE());
				System.out.println("PM_IL_FUND_SETUP_ACTION.FS_EFF_TO_DT_WHEN_VALIDATE_ITEM()-errmsg"+errmsg);
				//  RAISE FORM_TRIGGER_FAILURE;
				System.out.println("Sorry To Date Is Less Than From Date !!!!!!");
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				//errorMap.put("current", errmsg);
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91001").getDetail());
				
				
				
			}
			
			else{
				UIInput input = (UIInput) event.getComponent().getParent(); // Ajax4jsf comp
				ErrorHelpUtil.validate(input, getErrorMap());
				getErrorMap().clear();
			}
		}//Added by gopi for kic on 02/04/2019
		else{
			//PILM055_APAC_CompositeAction.getParentAction().getCOMP_FS_EFF_FM_DT().setRequired(true);
			try {
				throw new Exception("Effective To Date: value is required");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("To date", e.getMessage());
			}
		}
		//end
	 }
	
	
	public  boolean dateLessthenOrEqualTo(java.util.Date date1,java.util.Date date2){
		System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.dateLessthenOrEqualTo()");
		boolean flag=false;
		if(date1.before(date2)||date1.equals(date2)){
			flag=true;
		}
		System.out.println("Flag" +flag);
		return flag;
	}
	
	
	public  boolean dateLessthen(java.util.Date date1,java.util.Date date2){
		System.out.println("PM_IL_FUND_PRICE_DTL_ACTION.dateLessthenOrEqualTo()");
		boolean flag=false;
		if(date1.before(date2)){
			flag=true;
		}
		System.out.println("Flag" +flag);
		return flag;
	}
	
	public void BlockNavigationSave(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.BlockNavigationSave()-Inside");
		saveRecord(null);
	}
	
	
	/*public void SaveRecord(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.SaveRecord()-Inside");
		FacesContext context = FacesContext.getCurrentInstance();
		try{
		 con = CommonUtils.getConnection();
		 System.out.println("ROWID IS"+PM_IL_FUND_SETUP_BEAN.getROWID());
		 if("".equals(PM_IL_FUND_SETUP_BEAN.getROWID()) || (PM_IL_FUND_SETUP_BEAN.getROWID()== null)){
			 System.out.println("888888888888888888888888888888888888888888888");
			 PM_IL_FUND_SETUP_PRE_INSERT();
			 ELResolver resolver = context.getApplication().getELResolver();
				PM_IL_FUND_PRICE_DTL_ACTION actionBean= (PM_IL_FUND_PRICE_DTL_ACTION)resolver.getValue(context.getELContext(), null, "PILM055_APAC_PM_IL_FUND_PRICE_DTL_ACTION");
				PM_IL_FUND_PRICE_DTL valueBean = actionBean.getPM_IL_FUND_PRICE_DTL_BEAN();
				System.out.println("**************************************");
                System.out.println("FFFFFFFFF"+getCOMP_FS_CODE().getValue().toString());   		
                String FS_CODE = getCOMP_FS_CODE().getValue().toString();
                System.out.println("FS_CODE==========="+FS_CODE);
                valueBean.setFPD_FS_CODE(FS_CODE);
				System.out.println("**************************************");
			 int n = handler.executeInsert(PM_IL_FUND_SETUP_BEAN,con);
			 System.out.println("PM_IL_FUND_SETUP_ACTION.SaveRecord()-n"+n); 
		 }else{
			 PM_IL_FUND_SEETUP_PRE_UPDATE();
			 int n = handler.executeInsert(PM_IL_FUND_SETUP_BEAN,con);
		 }
		 
		 con.commit();
		 //con.close();
		
		}
		catch(Exception e){
		  e.printStackTrace();	
		}
		
	}*/
	
	
	public String goto_PM_IL_FUND_SETUP() {
		String return_string = "";
			return_string = "PILM055_APAC_goParentBlock";
		return return_string;
	}
		
	public String goto_PM_IL_PRICE_DTL() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException{
		String return_string ="";
		try{
			PM_IL_FUND_PRICE_DTL_ACTION actionChild = PILM055_APAC_CompositeAction.getChildAction();
			//System.out.println(getErrorMap().size());
			//if(getErrorMap().size()==0){
			///System.out.println("PM_IL_FUND_SETUP_ACTION.goto_PM_IL_PRICE_DTL()-Inside");
			//populateValues();
			//BlockNavigationSave();
			actionChild.setBlockFlag(true);
			CommonUtils.setGlobalVariable("FS_CODE", this.getPM_IL_FUND_SETUP_BEAN().getFS_CODE());
			//PILM055_APAC_CompositeAction.getChildAction().setBlockFlag(true);
			return_string = "PILM055_APAC_goChildBlock";
		//}
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		return return_string;
	}
	
	
	public void populateValues() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException{
		FacesContext context = FacesContext.getCurrentInstance();
		String FS_CODE = getCOMP_FS_CODE().getValue().toString();
		System.out.println("PM_IL_FUND_SETUP_ACTION.populateValues()-FS_CODE"+FS_CODE);
		String selectQuery = "SELECT PM_IL_FUND_PRICE_DTL.ROWID,PM_IL_FUND_PRICE_DTL.* FROM PM_IL_FUND_PRICE_DTL where FPD_FS_CODE ='"+FS_CODE+"'";
		System.out.println("selectQuery========"+selectQuery);
		List<PM_IL_FUND_PRICE_DTL> list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM055_APAC.PM_IL_FUND_PRICE_DTL",con);
		
		System.out.println("list  ++++" +list.size());
		ELResolver resolver = context.getApplication().getELResolver();
		PM_IL_FUND_PRICE_DTL_ACTION actionBean= (PM_IL_FUND_PRICE_DTL_ACTION)resolver.getValue(context.getELContext(), null, "PILM055_APAC_PM_IL_FUND_PRICE_DTL_ACTION");
		//PM_IL_FUND_PRICE_DTL valueBean = actionBean.getPM_IL_FUND_PRICE_DTL_BEAN();
        
		/*for(Iterator<PM_IL_FUND_PRICE_DTL>i=list.iterator();i.hasNext();){
			
			PM_IL_FUND_PRICE_DTL listValue = i.next();
			//String productCodeDesc=getProductCodeDesc( listValue.getABNFAP_PROD_CODE(),listValue.getABNFAP_MODULE_ID());
			//listValue.setUI_M_ABNFAP_PROD_CODE_DESC(productCodeDesc);
			listValue.setFPD_FS_CODE(FS_CODE);
			newList.add(listValue);
		}
		//
		*/
		
		actionBean.setBeanList(list);
		
		PM_IL_FUND_PRICE_DTL PM_IL_FUND_PRICE_DTL_BEAN = null;
		Iterator<PM_IL_FUND_PRICE_DTL> it = list.iterator();
		while(it.hasNext()){
			PM_IL_FUND_PRICE_DTL_BEAN = it.next();
			PM_IL_FUND_PRICE_DTL_BEAN.setRowSelected(false);
		}
		
		if (list.size()>0){					
		 actionBean.setPM_IL_FUND_PRICE_DTL_BEAN(list.get(0));
		 actionBean.getCOMP_FPD_EFF_FM_DT().setDisabled(true);
			actionBean.getPM_IL_FUND_PRICE_DTL_BEAN().setRowSelected(true);
		}
		
		//actionBean.setBeanList(newList);
	}
	
	public String SaveAndNext(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.SaveAndNext()-Inside");
		if(getErrorMap().size()==0){
		saveRecord(null);
		return "PILM055_APAC_goChildBlock";
		}else{
			return "";
		}
		
	}
	
	/*public String goto_SEARCH_PAGE(){
		String return_string ="";
		if(getErrorMap().size()==0){
		System.out.println("PM_IL_FUND_SETUP_ACTION.goto_SEARCH_PAGE()");
		return_string ="PILM055_APAC_goSearchPage";
		PM_IL_FUND_SETUP_SEARCH_PAGE action = (PM_IL_FUND_SETUP_SEARCH_PAGE) getSession().get("PILM055_APAC_PM_IL_FUND_SETUP_SEARCH_PAGE");
		action.setINSERT_ALLOWED(true);
		action.setUPDATE_ALLOWED(true);
		action.setDELETE_ALLOWED(true);
		}
		return return_string;
	}*/
	
	public String backToSearch() {
		this.setBlockFlag(true);
		CommonUtils.setGlobalObject("compositeAction",
				null);
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}

	
	public void FS_MIN_WD_LC_AMT_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_MIN_WD_LC_AMT_WHEN_VALIDATE_ITEM()");
		String MIN_WD_LC =  getCOMP_FS_MIN_WD_LC_AMT().getSubmittedValue().toString();
		System.out.println("MIN_WD_BAL_2"+PM_IL_FUND_SETUP_BEAN.getFS_MIN_WD_LC_AMT());
	// For Catching & Throwing Exception 
		vaildateValues(MIN_WD_LC);
	//For Regex
		 /* boolean flag = validateValues(MIN_WD_LC);
		  System.out.println("Flag Is" + flag);
		  if(flag==true){
			  System.out.println("True>>>>>>>>>");
			  getErrorMap().clear();
			 }else{
				 System.out.println("FAlse_____+++++++++");
				 getErrorMap().put("current", "Enter Valid Values");
			 }*/
		  
		}
	
	public void FS_MIN_DAY_WD_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_MIN_DAY_WD_WHEN_VALIDATE_ITEM()");
		String MIN_DAY_WD = getCOMP_FS_MIN_DAY_WD().getSubmittedValue().toString();
		vaildateValues(MIN_DAY_WD);
		
	}
		
	
	public void FS_MIN_WD_BAL_LC_AMT_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_MIN_WD_BAL_LC_AMT_WHEN_VALIDATE_ITEM()");
		String MIN_WD_BAL_LC_AMT =  getCOMP_FS_MIN_WD_BAL_LC_AMT().getSubmittedValue().toString();
		vaildateValues(MIN_WD_BAL_LC_AMT);
	}
	
	public void FS_DUR_FOR_WD_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_DUR_FOR_WD_WHEN_VALIDATE_ITEM()");
		String FS_DUR_FOR_WD = getCOMP_FS_DUR_FOR_WD().getSubmittedValue().toString();
		vaildateValues(FS_DUR_FOR_WD);
	}
		
	public void FS_SW_MAX_NO_WHEN_VALIDATE_ITEM(ActionEvent ae){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_SW_MAX_NO_WHEN_VALIDATE_ITEM()");
		String FS_SW_MAX_NO = getCOMP_FS_SW_MAX_NO().getSubmittedValue().toString();
		vaildateValues(FS_SW_MAX_NO);
	}
	
	public void FS_SW_WAIT_PERIOD_WHEN_VALIDATE_ITEM(ActionEvent ae){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_SW_WAIT_PERIOD_WHEN_VALIDATE_ITEM()");
		String FS_SW_WAIT_PERIOD = getCOMP_FS_SW_WAIT_PERIOD().getSubmittedValue().toString();
		vaildateValues(FS_SW_WAIT_PERIOD);
	}
	
	public void FS_SW_MIN_BAL_LC_AMT_WHEN_VALIDATE_ITEM(ActionEvent ae){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_SW_MIN_BAL_LC_AMT_WHEN_VALIDATE_ITEM()");
		String FS_SW_MIN_BAL_LC_AMT = getCOMP_FS_SW_MIN_BAL_LC_AMT().getSubmittedValue().toString();
		vaildateValues(FS_SW_MIN_BAL_LC_AMT);
	}
		
	
	public void FS_DUR_FOR_SW_WHEN_VALIDATE_ITEM(ActionEvent ae){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_DUR_FOR_SW_WHEN_VALIDATE_ITEM()");
		String FS_DUR_FOR_SW = getCOMP_FS_DUR_FOR_SW().getSubmittedValue().toString();
		vaildateValues(FS_DUR_FOR_SW);
	}
	
	/*public void vaildateValue(String value){
		System.out.println("PM_IL_FUND_SETUP_ACTION.vaildateValue()-STRING IS " + value);
		try{
			Double  D_MIN = Double.parseDouble(value);
		 if(D_MIN < 0){
			System.out.println("Value Less Than Zero");
			getErrorMap().put("current","Value Less Than Zero");
			}else{
			System.out.println("ELse Part In Action__+++++++++++");
			getErrorMap().remove("current");
			//getErrorMap().clear();
		 }
		}catch(NumberFormatException ne){
			getErrorMap().put("current", "Enter Valid Values");
			System.out.println("1: "+ne.getMessage());
			//System.out.println("2: "+ne.getLocalizedMessage());
		  }
		}
		
		*/
	  
			
	
	public void vaildateValues(String value){
		System.out.println("ValueIs"+value );
		
		int length = value.length();
		String restricting_pattern = "[a-z]|[A-Z]|[0-9]|[.]";
		Pattern p = Pattern.compile(restricting_pattern);
		Matcher  m = p.matcher(value);
		int count = 0; 
		while(m.find()){
			System.out.println("Inside While");
			++count;
		}
		if (count!=length){
			System.out.println("WRFWQRRRRRRRR");
			getErrorMap().put("current", "Value Should be Numeric and Non-Negative");
		}else{
			getErrorMap().clear();
		}
	}		
	
	
	public void FS_ROUND_OPTION_WHEN_VALIDATE_ITEM(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_ROUND_OPTION_WHEN_VALIDATE_ITEM()-Inside");
		String FS_ROUND_OPTION = getCOMP_FS_ROUND_OPTION().getSubmittedValue().toString();
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_ROUND_OPTION_WHEN_VALIDATE_ITEM()-FS_ROUND_OPTION"+FS_ROUND_OPTION);
		if(FS_ROUND_OPTION.equals("R")){
			System.out.println("rrrrrrrrrrPM_IL_FUND_SETUP_ACTION.FS_ROUND_OPTION_WHEN_VALIDATE_ITEM()-Inside");
			getCOMP_FS_ROUND_VALUE().setDisabled(false);
			getCOMP_FS_ROUND_VALUE().setReadonly(false);
			getCOMP_FS_ROUND_VALUE().setRequired(true);
		}else{ 
			
			if(FS_ROUND_OPTION.equals("I")){
			System.out.println("1234343434343434343434343434345");
			getCOMP_FS_ROUND_VALUE().setSubmittedValue("1");
		    // Bug fixed : assigling value to bean :added by Shankar Bodduluri : 01/04/2009
		    PM_IL_FUND_SETUP_BEAN.setFS_ROUND_VALUE(1);
		    }else{
			 System.out.println("66666666666666666666666666");
			 getCOMP_FS_ROUND_VALUE().setSubmittedValue("");
			 PM_IL_FUND_SETUP_BEAN.setFS_ROUND_VALUE(0);
		    }
			getCOMP_FS_ROUND_VALUE().setDisabled(true);
			getCOMP_FS_ROUND_VALUE().setReadonly(true);
			getCOMP_FS_ROUND_VALUE().setRequired(false);
    		}
		}
	
	
	
	
	public void FS_ROUND_OPTION_WHEN_LIST_CHANGED(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.FS_ROUND_OPTION_WHEN_LIST_CHANGED()-Inside");
	String FS_ROUND_OPTION = getCOMP_FS_ROUND_OPTION().getSubmittedValue().toString();
	System.out.println("Heyyyyyyyyy: "+FS_ROUND_OPTION);
	 if(FS_ROUND_OPTION.equals("R")){
		 System.out.println("The Value Is >>>>>>>>>>>>"+ FS_ROUND_OPTION);
		 getCOMP_FS_ROUND_VALUE().setDisabled(false);
         getCOMP_FS_ROUND_VALUE().setRequired(true);
	   }else{ 
		   if(FS_ROUND_OPTION.equals("I")){
		   System.out.println("11111111111111111");
		    getCOMP_FS_ROUND_VALUE().setSubmittedValue("1");
		    // Bug fixed : assigling value to bean :added by Shankar Bodduluri : 01/04/2009
		    PM_IL_FUND_SETUP_BEAN.setFS_ROUND_VALUE(1);
           }else{
    	    System.out.println("22222222222222222222");
		     getCOMP_FS_ROUND_VALUE().setSubmittedValue("");
		     PM_IL_FUND_SETUP_BEAN.setFS_ROUND_VALUE(0);
	      }
	   System.out.println("3333333333333333333"); 
	    getCOMP_FS_ROUND_VALUE().setDisabled(false);
		getCOMP_FS_ROUND_VALUE().setReadonly(false);
		getCOMP_FS_ROUND_VALUE().setRequired(false);
	   }
	}
	
	
	//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]
	public void PM_IL_FUND_SETUP_PRE_INSERT() throws ParseException{
		System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IL_FUND_SETUP_PRE_INSERT()-Inside");
		PM_IL_FUND_SETUP_BEAN.setFS_CR_DT(new CommonUtils().getCurrentDate());
		PM_IL_FUND_SETUP_BEAN.setFS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	//[ Removed Hard coded user id: added by: Shankar bodduluri Dated: 19-Mar-2009 ]
	public void PM_IL_FUND_SEETUP_PRE_UPDATE() throws ParseException{
		System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IL_FUND_SEETUP_PRE_UPDATE()");
		PM_IL_FUND_SETUP_BEAN.setFS_UPD_DT(new CommonUtils().getCurrentDate());
		PM_IL_FUND_SETUP_BEAN.setFS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
	}
	public void PM_IL_FUND_SETUP_PRE_BLOCK(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IL_FUND_SETUP_PRE_BLOCK()-Inside");
		CommonUtils.getControlBean().setM_DELETE_MSG_FLAG("Y");
	}
	
	public void PM_IL_FUND_SETUP_WHEN_CREATE_RECORD(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IL_FUND_SETUP_WHEN_CREATE_RECORD()-Inside");
		getCOMP_FS_FUND_TYPE().setValue("F");
		getCOMP_FS_FRAC_UNIT_YN().setValue("N");
		getCOMP_FS_ROUND_OPTION().setValue("N");
	}
	
	public  void PM_IL_FUND_SETUP_WHEN_NEW_RECORD_INSTANCE(){
		/*IF :SYSTEM.RECORD_STATUS <>'NEW' THEN
		 SET_ITEM_PROPERTY('PM_IL_FUND_SETUP.FS_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
	ELSE
		 SET_ITEM_PROPERTY('PM_IL_FUND_SETUP.FS_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
	END IF;*/
		
		if(getCOMP_FS_ROUND_OPTION().getValue().toString().equals("R")){
			getCOMP_FS_ROUND_VALUE().setDisabled(false);
			getCOMP_FS_ROUND_VALUE().setReadonly(false);
			getCOMP_FS_ROUND_VALUE().setRequired(true);
		}else{
			getCOMP_FS_ROUND_VALUE().setDisabled(true);
			getCOMP_FS_ROUND_VALUE().setReadonly(true);
			getCOMP_FS_ROUND_VALUE().setRequired(false);
		}
		
	}
	
	public void PM_IL_FUND_SETUP_POST_QUERY(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IL_FUND_SETUP_POST_QUERY()-Inside");
		if(getCOMP_FS_ROUND_OPTION().getValue().toString().equals("R")){
			getCOMP_FS_ROUND_VALUE().setDisabled(false);
			getCOMP_FS_ROUND_VALUE().setReadonly(true);
			getCOMP_FS_ROUND_VALUE().setRequired(true);
			
		}else{
			getCOMP_FS_ROUND_VALUE().setDisabled(true);
			getCOMP_FS_ROUND_VALUE().setReadonly(false);
			getCOMP_FS_ROUND_VALUE().setRequired(false);
		}
		
	}
	
	public void  PM_IL_FUND_SETUP_ON_POPULATE_DETAILS(){
		
		
	}
	
	public void  ON_CHECK_DELETE_MASTER(){
		
	}
	
	
	public void PM_IL_FUND_SETUP_WHEN_NEW_BLOCK_INSTANCE() throws Exception{/*
		   {
		        Connection con = getConnection();
		        try
		        {
		            String M_USER_MODE_YN = null;
		            String selectQuery="SELECT 'X' FROM  PM_IL_APPR_SETUP_DET  WHERE  ASD_USER_ID  = :CTRL.M_USER_ID  AND ASD_CHAR_VALUE  = 'Y'  AND ASD_CODE  = 'NAV_KEY_YN' ";
		            ResultSet rs=null;
		           // Statement stmt_C1=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		            rs=handler.executeSelectStatement(selectQuery, con);
		            if(rs.next())
		            {
		                M_USER_MODE_YN=rs.getString(1);
		            }
		            rs.close();
		            if(nvl(M_USER_MODE_YN,"N")=="X")
		            {
		                //SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PM_IL_FUND_PRICE_DTL",INSERT_ALLOWED,PROPERTY_TRUE);
		                //SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PM_IL_FUND_PRICE_DTL",UPDATE_ALLOWED,PROPERTY_TRUE);
		            }
		            else
		            {
		                //SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PM_IL_FUND_PRICE_DTL",INSERT_ALLOWED,PROPERTY_FALSE);
		               // SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PM_IL_FUND_PRICE_DTL",UPDATE_ALLOWED,PROPERTY_FALSE);
		            }
		        }catch(Exception e)
		        {
		            e.printStackTrace();
		            throw e;
		        }
		        finally
		        {
		            if(con != null)
		            {
		               con.close();    
		            
		            }
		        
		    }
		
		   }
		
	*/}
	
		
	public void FORM_PRE_FORM(PhaseEvent event) throws Exception{
		
		System.out.println("PM_IL_FUND_SETUP_ACTION.FORM_PRE_FORM()-Inside");
		session= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		session.put("GLOBAL.M_FAILURE", "FALSE");
		STD_PRE_FORM();
		ControlBean ctrlbean = CommonUtils.getControlBean();
		java.util.Date RawDate  = new java.util.Date(Calendar.getInstance().getTimeInMillis());
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
		String  Formatted_Date  =df.format(RawDate);
		System.out.println("PM_IL_FUND_SETUP_ACTION.FORM_PRE_FORM()-Formatted_Date"+Formatted_Date);
		String M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+ Formatted_Date;
		System.out.println("M_TITLE Value Isssssssss" + M_TITLE);
		//getTesting_Button().setDisabled(true);
		
		FORM_WHEN_CREATE_RECORD();
		PM_IL_FUND_SETUP_PRE_BLOCK();
		PM_IL_FUND_SETUP_WHEN_CREATE_RECORD();
		FORM_WHEN_NEW_FORM_INSTANCE();
		PM_IL_FUND_SETUP_WHEN_NEW_BLOCK_INSTANCE();
		PM_IL_FUND_SETUP_WHEN_NEW_RECORD_INSTANCE();
		PM_IL_FUND_SETUP_SEARCH_PAGE action = (PM_IL_FUND_SETUP_SEARCH_PAGE)getSession().get("PILM055_APAC_PM_IL_FUND_SETUP_SEARCH_PAGE");
		if(!action.isINSERT_ALLOWED()){
			getCOMP_FS_CODE().setReadonly(true);
		}
		System.out.println("<<<<<<<<<<<<<<<END OF PRE-FORM>>>>>>>>>>>>>>");
	}
	
	public void beforePhase(PhaseEvent event){
		try {
			if(isBlockFlag()){
				
				/*added by raja for error show even onload on 17-12-2016*/
				getErrorMap().clear();
				getWarningMap().clear();
				/*end*/
				executeSelectStatement();
				if(PM_IL_FUND_SETUP_BEAN.getROWID() != null){
				}
				resetAllComponent();
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}
	
	public void executeSelectStatement() throws Exception{
		String rowId = CommonUtils.getGlobalVariable("FS_ROW_ID");
		if(rowId != null){
		String selectQuery = "Select ROWID, PM_IL_FUND_SETUP.* from PM_IL_FUND_SETUP where ROWID='"+rowId+"'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_FUND_SETUP> list = null;
		
		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery, 
					"com.iii.pel.forms.PILM055_APAC.PM_IL_FUND_SETUP", 
					con);
			setPM_IL_FUND_SETUP_BEAN(list.get(0));
			setUpdate(true);
		CommonUtils.setGlobalVariable("FS_ROW_ID", null);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		}else{
			this.setPM_IL_FUND_SETUP_BEAN(new PM_IL_FUND_SETUP());
		}
	}
	

	/**
	 * Instantiates all components in PM_IL_FUND_SETUP_ACTION
	 */
	public void instantiateAllComponent(){
		// Instantiating HtmlInputText
		COMP_FS_MIN_WD_LC_AMT				 = new HtmlInputText();
		COMP_FS_MIN_DAY_WD				 = new HtmlInputText();
		COMP_FS_MIN_WD_BAL_LC_AMT			 = new HtmlInputText();
		COMP_FS_DUR_FOR_WD				 = new HtmlInputText();
		COMP_FS_SW_MAX_NO				 = new HtmlInputText();
		COMP_FS_SW_WAIT_PERIOD				 = new HtmlInputText();
		COMP_FS_SW_MIN_BAL_LC_AMT			 = new HtmlInputText();
		COMP_FS_DUR_FOR_SW				 = new HtmlInputText();
		COMP_FS_CODE					 = new HtmlInputText();
		COMP_FS_DESC					 = new HtmlInputText();
		COMP_FS_SHORT_DESC				 = new HtmlInputText();
		COMP_FS_LONG_DESC				 = new HtmlInputText();
		COMP_FS_BL_DESC					 = new HtmlInputText();
		COMP_FS_BL_SHORT_DESC				 = new HtmlInputText();
		COMP_FS_ROUND_VALUE				 = new HtmlInputText();

		// Instantiating HtmlSelectOneMenu
		COMP_FS_FUND_TYPE				 = new HtmlSelectOneMenu();
		COMP_FS_FRAC_UNIT_YN				 = new HtmlSelectOneMenu();
		COMP_FS_ROUND_OPTION				 = new HtmlSelectOneMenu();

		// Instantiating HtmlCalendar
		COMP_FS_EFF_FM_DT				 = new HtmlCalendar();
		COMP_FS_EFF_TO_DT				 = new HtmlCalendar();

		// Instantiating HtmlCommandButton
		COMP_UI_M_BUT_EDITOR_BL_LONG_DESC		 = new HtmlCommandButton();
		COMP_UI_M_BUT_EDITOR_LONG_DESC			 = new HtmlCommandButton();
		Testing_Button					 = new HtmlCommandButton();

	}


	public void resetAllComponent(){
		COMP_FS_MIN_WD_LC_AMT.resetValue();
		COMP_FS_MIN_DAY_WD.resetValue();
		COMP_FS_MIN_WD_BAL_LC_AMT.resetValue();
		COMP_FS_DUR_FOR_WD.resetValue();		
		COMP_FS_SW_MAX_NO.resetValue();		
		COMP_FS_SW_WAIT_PERIOD.resetValue();	
		COMP_FS_SW_MIN_BAL_LC_AMT.resetValue();
		COMP_FS_DUR_FOR_SW.resetValue();		
		COMP_FS_CODE.resetValue();			
		COMP_FS_DESC.resetValue();			
		COMP_FS_SHORT_DESC.resetValue();		
		COMP_FS_LONG_DESC.resetValue();		
		COMP_FS_BL_DESC.resetValue();			
		COMP_FS_BL_SHORT_DESC.resetValue();	
		COMP_FS_ROUND_VALUE.resetValue();		

		// Instantiating HtmlSelectOneMenu
		COMP_FS_FUND_TYPE.resetValue();		
		COMP_FS_FRAC_UNIT_YN.resetValue();	
		COMP_FS_ROUND_OPTION.resetValue();	

		// Instantiating HtmlCalendar
		COMP_FS_EFF_FM_DT.resetValue();		
		COMP_FS_EFF_TO_DT.resetValue();		
	}
	
	
	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	
	public void FORM_WHEN_NEW_FORM_INSTANCE(){
		//:GLOBAL.FLAG1:=0;
		//NULL;
	}
	
	public void FORM_POST_FORMS_COMMIT(){
		//:GLOBAL.M_FAILURE := 'FALSE' ;
	}
	
	
	public void FORM_POST_DATABASE_COMMIT(){
		//:GLOBAL.M_FAILURE := 'FALSE' ;
	}
	
	
	public void FORM_WHEN_NEW_ITEM_INSTANCE(){

		//LOAD_ITEM_HINT- omitted for now ;
	}

	public void FORM_WHEN_NEW_BLOCK_INSTANCE(){
		//CHECK_BLK_NAVG-omitted for now
	}
	
	
	public void FORM_WHEN_CREATE_RECORD(){
		//LOAD_DFLT_VALUES ;
	}
	
	public void FORM_WHEN_NEW_RECORD_INSTANCE(){
		//NULL
	}
	
	public void PRE_COMMIT(){
		STD_PRE_COMMIT();
	}
	
	public void STD_PRE_COMMIT(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.STD_PRE_COMMIT()");
        String M_COMM_DEL = CommonUtils.getControlBean().getM_COMM_DEL().toString();
        String N_COMM_DEL =  nvl(M_COMM_DEL,"X");
        if( N_COMM_DEL.equals("C") || N_COMM_DEL.equals("P") || N_COMM_DEL.equals("D")) {  
      	//GET_ALERT_MSG('09',M_MESSAGE);
  	      //DISP_ALERT(M_MESSAGE);
  	      //RAISE FORM_TRIGGER_FAILURE;
  		  //END IF;
        }
	}
        
	
	public void FORM_ON_CLEAR_DETAILS(){
		//Clear_All_Master_Details
	}
	
	public void FORM_WHEN_TAB_PAGE_CHANGED(){
		//GOITEM 
	}
        
	
	
        public String nvl(String  value1 ,int  value2){
    		if("".equals(value1)){
    		  value1 = ""+value2;
    		}
    		return value1;
    		
    	}
    	
    	
    	public String nvl(String value1,String value2){
    		if("".equals(value1)){
    			value1= ""+value2;
    		}
    		return value1;
    	}

    	/*public String CheckFreeze(){
		System.out.println("PM_IL_FUND_SETUP_ACTION.CheckFreeze()-Inside");
		String freeze_value = "N";
		PM_IL_FUND_SETUP_BEAN.setFS_FRZ_YN(freeze_value);
		if(PM_IL_FUND_SETUP_BEAN.isFS_FRZ_YN_VALUE()){
			freeze_value="Y";
			PM_IL_FUND_SETUP_BEAN.setFS_FRZ_YN(freeze_value);
		}
		System.out.println("freeze_value"+freeze_value);
		return freeze_value;*/
		
		public void CheckFreeze(ActionEvent event) {
			String checkValue = (String) ((UIInput)event.getComponent().getParent()).getSubmittedValue();
			if("true".equals(checkValue)) {
				PM_IL_FUND_SETUP_BEAN.setFS_FRZ_YN("Y");
			} else {
				PM_IL_FUND_SETUP_BEAN.setFS_FRZ_YN("N");
			}
		}
	
	
	public void saveRecord(ActionEvent event) {
		CommonUtils.clearMaps(this);
		String rowId = null;
		CommonUtils commonUtils = new CommonUtils();
		rowId = PM_IL_FUND_SETUP_BEAN.getROWID();
		String successMeaage = null;
		try {
			new CRUDHandler().executeInsert(PM_IL_FUND_SETUP_BEAN,
					CommonUtils.getConnection());
			if (rowId == null) {
				successMeaage = Messages.getString("messageProperties","errorPanel$message$save");
				PM_IL_FUND_SETUP_PRE_INSERT();
			} else {
				successMeaage = Messages.getString("messageProperties","errorPanel$message$update");
				PM_IL_FUND_SEETUP_PRE_UPDATE();
			}
			//Added by gopi for kic on 02/04/2019
			if(PM_IL_FUND_SETUP_BEAN.getFS_EFF_FM_DT()==null){
				throw new Exception("Effective From Date: value is required");
			}else if(PM_IL_FUND_SETUP_BEAN.getFS_EFF_TO_DT()==null){
				throw new Exception("Effective To Date: value is required");
			}
			//end
			commonUtils.doComitt();
			if (rowId == null) {
				getWarningMap().put("somekey", successMeaage);
				getWarningMap().put("current", successMeaage);
			} else {
				getWarningMap().put("somekey", successMeaage);
				getWarningMap().put("current", successMeaage);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("From date", e.getMessage());
		}
	}
	
	/*public void DeleteRecord(ActionEvent event){
		System.out.println("PM_IL_FUND_SETUP_ACTION.DeleteRecord()-Inside");
		int n =0;
		try{
			con = CommonUtils.getConnection();
			 n = handler.executeDelete(PM_IL_FUND_SETUP_BEAN, con);
			con.commit();
            //con.close(); 			
		}
		catch(Exception e){
		  e.printStackTrace();	
		}System.out.println("PM_IL_FUND_SETUP_ACTION.delete() No of rows deleted : "+n);
		getWarningMap().put("current", n+" rows Deleted");
		
	}*/
	
	public String deleteRecord() {
		CommonUtils.clearMaps(this);
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_FUND_SETUP pm_il_fund_setup_bean = null;
		pm_il_fund_setup_bean = getPM_IL_FUND_SETUP_BEAN();
		String deleteMeaage = null;
		try {
			if (pm_il_fund_setup_bean == null) {
				getErrorMap().put("key", "not to delete");
				getErrorMap().put("current", "not to delete");
			} else {
				
				// helper.pm_broker_comm_hdr_pre_DELETE(headerBean);
				String var = delete_pm_fund_setup(pm_il_fund_setup_bean);
				if(var != null){
					deleteMeaage = Messages.getString("messageProperties",
							"errorPanel$message$delete");
					commonUtils.doComitt();
					setPM_IL_FUND_SETUP_BEAN(new PM_IL_FUND_SETUP());
					getWarningMap().put("errorKey", deleteMeaage);
					getWarningMap().put("current", deleteMeaage);
					
				}else{
					deleteMeaage = "Child record exist in  transaction table.Can't Delete ";
					getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,deleteMeaage);
					getErrorMap().put("BEFORE_PHASE", deleteMeaage);
				}	
			}
			resetAllComponent();
			pm_il_fund_setup_bean.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * Resets all components in PM_IL_FUND_SETUP_ACTION
	 */
	public void resetAllComponent2(){
		// Reseting HtmlInputText
		COMP_FS_MIN_WD_LC_AMT.resetValue();
		COMP_FS_MIN_DAY_WD.resetValue();
		COMP_FS_MIN_WD_BAL_LC_AMT.resetValue();
		COMP_FS_DUR_FOR_WD.resetValue();
		COMP_FS_SW_MAX_NO.resetValue();
		COMP_FS_SW_WAIT_PERIOD.resetValue();
		COMP_FS_SW_MIN_BAL_LC_AMT.resetValue();
		COMP_FS_DUR_FOR_SW.resetValue();
		COMP_FS_CODE.resetValue();
		COMP_FS_DESC.resetValue();
		COMP_FS_SHORT_DESC.resetValue();
		COMP_FS_LONG_DESC.resetValue();
		COMP_FS_BL_DESC.resetValue();
		COMP_FS_BL_SHORT_DESC.resetValue();
		COMP_FS_ROUND_VALUE.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_FS_FUND_TYPE.resetValue();
		COMP_FS_FRAC_UNIT_YN.resetValue();
		COMP_FS_ROUND_OPTION.resetValue();

		// Reseting HtmlCalendar
		COMP_FS_EFF_FM_DT.resetValue();
		COMP_FS_EFF_TO_DT.resetValue();

	}



	public String delete_pm_fund_setup(PM_IL_FUND_SETUP pm_il_fund_setup_bean) throws DBException, DBException,Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String message = null;
		try {
			connection = CommonUtils.getConnection();
			handler.executeDelete(pm_il_fund_setup_bean, connection);
			message = "Success";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return message;
	}
	
	
	public void STD_PRE_FORM(){
		System.out.println("-------INSIDE -STD-PRE-FORM---");
//		P_GET_LOGO;
//		COPY(TO_CHAR(SYSDATE,'DD/MM/YY'),'BUTTON_PALETTE.M_RUN_DATE');
		ControlBean ctrlbean = CommonUtils.getControlBean();
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP _STD_PRE_FORM()\n---------->\n"+session.toString()+"\n----------");
		ctrlbean.setM_PARA_1((String)session.get("GLOBAL.M_PARA_1"));
//		bean.setM_PROG_NAME(GET_APPLICATION_PROPERTY(CURRENT_FORM));
		ctrlbean.setM_PROG_NAME("PILM055_APAC");
//		COPY(SUBSTR(NAME_IN('GLOBAL.M_NAME'),1,30), 'BUTTON_PALETTE.M_COMP_NAME') ;
		System.out.println("PM_IL_BANK_ACCOUNT_SETUP(------)" +(String)session.get("GLOBAL.M_NAME"));
//		COPY('10','SYSTEM.MESSAGE_LEVEL');
		session.put("GLOBAL.M_FAILURE", "FALSE");
		ctrlbean.setM_GOFLD_NAME("NULL");
		System.out.println("DUMMYACTION.STD_PRE_FORM()--- \n "+ctrlbean.getM_LANG_CODE()+"\t"+ctrlbean.getM_COMP_CODE()+"\t"+ctrlbean.getM_PARA_1());
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

	public HtmlCommandButton getTesting_Button() {
		return Testing_Button;
	}

	public void setTesting_Button(HtmlCommandButton testing_Button) {
		Testing_Button = testing_Button;
	}

	
	public void FS_CODE_WHEN_VALIDATE_ITEM(ActionEvent event) throws Exception{
		System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IKL_FUND_SETUP_FS_CODE_WHEN_VALIDATE_ITEM()--Inside");
	    	 Connection con = CommonUtils.getConnection();
	    	
	        try
	        {
	            String M_DUMMY=null;
	            String FS_CODE = getCOMP_FS_CODE().getSubmittedValue().toString();
	            System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IKL_FUND_SETUP_FS_CODE_WHEN_VALIDATE_ITEM()-FS_CODE"+FS_CODE);
	            String selectQuery="SELECT 1 FROM  PM_IL_FUND_SETUP  WHERE  FS_CODE  = '"+ FS_CODE + "'";
	            System.out.println("SQ"+selectQuery);
	            ResultSet rs=null;
	            
	            rs = handler.executeSelectStatement(selectQuery, con);
	            System.out.println("===============================");
	            System.out.println(FS_CODE.equals(""));
	            System.out.println("===============================");
	            if(FS_CODE != null && !FS_CODE.equals(""))
	            {
	                          	
	               System.out.println("PM_IL_FUND_SETUP_ACTION.FS_CODE_WHEN_VALIDATE_ITEM()-12345677");
	               
	               //System.out.println("rs.next()rs.next()>>>>>>>>"+rs.next());
	              // setCodeFlag(rs.next());
	               
	               
	               if(rs.next())
	                { 	System.out.println("PM_IL_FUND_SETUP_ACTION.FS_CODE_WHEN_VALIDATE_ITEM(-Inside)");
	                    M_DUMMY=rs.getString("1");
	                    System.out.println("PM_IL_FUND_SETUP_ACTION.PM_IKL_FUND_SETUP_FS_CODE_WHEN_VALIDATE_ITEM()-M_DUMMY"+M_DUMMY);
	                
	                                
	                    if(Integer.parseInt(M_DUMMY)> 0)
	                       {
	                	   System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIII");
	                	   //errmsg =  STD_MESSAGE_ROUTINE("91028",ctrlbean.getM_LANG_CODE());
	                	   System.err.println("4444444444444444"+errmsg);
	                	   	//  errorMap.put("current", errmsg);
	                	   	getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91028").getDetail());
	     			       //throw new FORM_TRIGGER_FAILURE();
	                       }
	                }
	               else{
	                    	  System.out.println("NEW VALUE CLEARING ERROR MAP???????????");
	                    	   getErrorMap().clear();
	                  	}
	                    System.out.println("PM_IL_FUND_SETUP_ACTION.FS_CODE_WHEN_VALIDATE_ITEM()-NOTHING TO CHECK");
	                   
	               System.out
						.println("PM_IL_FUND_SETUP_ACTION.FS_CODE_WHEN_VALIDATE_ITEM()-Inside234234");
	               
	               // if(!isCodeFlag()){
	              
	                	//System.out.println("PM_IL_FUND_SETUP_ACTION.FS_CODE_WHEN_VALIDATE_ITEM()-FALSE");
	                	//getErrorMap().clear();
	               
	                //}
	               
	              }
	            else
	            {
	            	//errmsg =   STD_MESSAGE_ROUTINE("71103",ctrlbean.getM_LANG_CODE());
	            	System.out.println("EMPTY CODE ENTEREDE---------------");
	            	getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71103").getDetail());
	            	System.out.println("************************************************");
	            	//System.out.println("ErrorMessage" + errmsg);
	            	System.out.println("************************************************");
	                //throw new FORM_TRIGGER_FAILURE();
	            }
	            
	            
	            System.out.println("THE LLLLLLLLLLLLLLLLLLLLL");
	        }
	        
	        
	        catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	        
	    }
	public void Validator_FScode(FacesContext context, UIComponent component,Object value){
		System.out.println("PM_IL_FUND_SETUP_ACTION.Validator_FScode()-Inside");
		throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "71103"));

	}
	
	public String STD_MESSAGE_ROUTINE(String errorCode,String P_LANG_CODE){
		    try{
			String query = "SELECT DECODE('"+P_LANG_CODE+"', 'ENG', EM_ENG_MSG, EM_FOR_MSG),EM_ERR_FLAG FROM PP_ERROR_MESSAGE WHERE EM_ERR_NO = '"+errorCode+"'";
			System.out.println("query88888888888888"+query);
			ResultSet resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection());
			while(resultSet.next()){
			  errmsg = resultSet.getString(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("PM_IL_FUND_SETUP_ACTION.STD_MESSAGE_ROUTINE()-errmsg"+errmsg);
		return errmsg;
	}

	public boolean isCodeFlag() {
		return codeFlag;
	}

	public void setCodeFlag(boolean codeFlag) {
		this.codeFlag = codeFlag;
	}

	public TabbedBar getTabbedBar() {
		return tabbedBar;
	}

	public void setTabbedBar(TabbedBar tabbedBar) {
		this.tabbedBar = tabbedBar;
	}

	

	/*public Map<String, String> getErrorMap() {
		return errorMap;
	}

	public void setErrorMap(Map<String, String> errorMap) {
		this.errorMap = errorMap;
	}*/

	/*public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		System.out.println("PM_IL_FUND_SETUP_ACTION.getAsObject()-Inside");
		System.out.println("THE CONTEXT OBJECT" + context);
		System.out.println("THE COMPONENT  ID " + component.getId());
		System.out.println("THE VALUE IS" + value);
		StringTokenizer token = new StringTokenizer(value,".");
		
		while(token.hasMoreTokens()){
			System.out.println("inSIDE wHILE");
			String tok = token.nextToken();
			System.out.println("TOK IS SS" +tok);
		}
		
		return token;
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("PM_IL_FUND_SETUP_ACTION.getAsString()--Inside");
	PM_IL_FUND_SETUP PM_IL_FUND_SETUP_BEAN  = null;
		if(value instanceof PM_IL_FUND_SETUP){
			PM_IL_FUND_SETUP_BEAN =  (PM_IL_FUND_SETUP) value;
			StringBuilder sb = new StringBuilder();
			sb.append(PM_IL_FUND_SETUP_BEAN.getFS_MIN_WD_BAL_LC_AMT());
			sb.append(PM_IL_FUND_SETUP_BEAN.getFS_SW_MIN_BAL_LC_AMT());
			sb.append(PM_IL_FUND_SETUP_BEAN.getFS_DUR_FOR_SW());
			return sb.toString();
		}
		
    return "";	
	
 }	*/
	
	//migration newly started
	public void WHEN_VALIDATE_ITEM_FS_CODE(PM_IL_FUND_SETUP pm_il_fund_setup_bean) throws Exception{
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String C1= "SELECT ROWID FROM   PM_IL_FUND_SETUP WHERE  FS_CODE = ? ";
		String dbRowId = null;
		String beanRowid = null;
		Object[] values = null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{pm_il_fund_setup_bean.getFS_CODE()};
			if(pm_il_fund_setup_bean.getFS_CODE() != null){
				beanRowid = pm_il_fund_setup_bean.getROWID();
				resultSet = handler.executeSelectStatement(C1, connection,values);
				if(resultSet.next()){
					dbRowId = resultSet.getString("ROWID");
				}
			  if(CommonUtils.isDuplicate(beanRowid, dbRowId)){
				  throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91028"));
			   }
			}
			 else{   
				 throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "71103"));
			 }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}   
	}
	
	public void WHEN_VALIDATE_ITEM_FS_DESC(PM_IL_FUND_SETUP pm_il_fund_setup_bean){
		 if(pm_il_fund_setup_bean.getFS_DESC() != null){
			 
			 /*changed by R Raja for get 30 letters of fund discription on 17-12-2016*/ 
			 
			 pm_il_fund_setup_bean.setFS_SHORT_DESC(CommonUtils.SUBSTR(pm_il_fund_setup_bean.getFS_DESC(), 1, 30));
			 pm_il_fund_setup_bean.setFS_LONG_DESC(pm_il_fund_setup_bean.getFS_DESC());
			 
			 /*end*/
		 }
	}
	
	
	public void FS_CODE_validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			getPM_IL_FUND_SETUP_BEAN().setFS_CODE((String)value);
			WHEN_VALIDATE_ITEM_FS_CODE(PM_IL_FUND_SETUP_BEAN);
		} catch (Exception e) {
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
	
	
	/*change the method argument by R. Raja on 17-12-2016*/
	public void FS_DESC_validator(ActionEvent event) throws ValidatorException {
		try {
			/*changed by R. Raja on 17-12-2016*/
			getPM_IL_FUND_SETUP_BEAN().setFS_DESC(COMP_FS_DESC.getSubmittedValue().toString());
			WHEN_VALIDATE_ITEM_FS_DESC(PM_IL_FUND_SETUP_BEAN);
			COMP_FS_SHORT_DESC.resetValue();
			COMP_FS_LONG_DESC.resetValue();
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				/*ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), context, component.getId(),
						getWarningMap());*/
			} catch (Exception e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
}	

