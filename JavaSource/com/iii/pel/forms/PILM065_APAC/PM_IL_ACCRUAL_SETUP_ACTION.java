package com.iii.pel.forms.PILM065_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.forms.PILM023.PM_IL_CODES_ACCOUNT_SETUP_ACTION;
import com.iii.pel.forms.PILM054_APAC.DB_PROCEDURES;
import com.iii.pel.forms.PILM064_APAC.PM_MISC_ITEM_SETUP;
import com.iii.pel.forms.PILM064_APAC.PM_MISC_ITEM_SETUP_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ListItemUtil;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PM_IL_ACCRUAL_SETUP_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_ACC_SRC_BUS_FM_LABEL;

	private HtmlInputText COMP_ACC_SRC_BUS_FM;

	private HtmlOutputLabel COMP_ACC_SRC_BUS_TO_LABEL;

	private HtmlInputText COMP_ACC_SRC_BUS_TO;

	private HtmlOutputLabel COMP_ACC_BUS_FM_CODE_LABEL;

	private HtmlInputText COMP_ACC_BUS_FM_CODE;

	private HtmlOutputLabel COMP_ACC_BUS_TO_CODE_LABEL;

	private HtmlInputText COMP_ACC_BUS_TO_CODE;

	private HtmlOutputLabel COMP_ACC_DIVN_FM_CODE_LABEL;

	private HtmlInputText COMP_ACC_DIVN_FM_CODE;

	private HtmlOutputLabel COMP_ACC_DIVN_TO_CODE_LABEL;

	private HtmlInputText COMP_ACC_DIVN_TO_CODE;

	private HtmlOutputLabel COMP_ACC_DEPT_FM_CODE_LABEL;

	private HtmlInputText COMP_ACC_DEPT_FM_CODE;

	private HtmlOutputLabel COMP_ACC_DEPT_TO_CODE_LABEL;

	private HtmlInputText COMP_ACC_DEPT_TO_CODE;

	private HtmlOutputLabel COMP_ACC_DOC_FM_TYPE_LABEL;

	private HtmlInputText COMP_ACC_DOC_FM_TYPE;

	private HtmlOutputLabel COMP_ACC_DOC_TO_TYPE_LABEL;

	private HtmlInputText COMP_ACC_DOC_TO_TYPE;

	private HtmlOutputLabel COMP_ACC_SETUP_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ACC_SETUP_TYPE;

	private HtmlOutputLabel COMP_ACC_DRCR_FLAG_LABEL;

	private HtmlSelectOneMenu COMP_ACC_DRCR_FLAG;

	private HtmlOutputLabel COMP_ACC_SETUP_FOR_LABEL;

	private HtmlSelectOneMenu COMP_ACC_SETUP_FOR;

	private HtmlOutputLabel COMP_ACC_PROD_CODE_FM_LABEL;

	private HtmlInputText COMP_ACC_PROD_CODE_FM;

	private HtmlOutputLabel COMP_ACC_PROD_CODE_TO_LABEL;

	private HtmlInputText COMP_ACC_PROD_CODE_TO;

	private HtmlOutputLabel COMP_ACC_COVER_CODE_FM_LABEL;

	private HtmlInputText COMP_ACC_COVER_CODE_FM;

	private HtmlOutputLabel COMP_ACC_COVER_CODE_TO_LABEL;

	private HtmlInputText COMP_ACC_COVER_CODE_TO;

	private HtmlOutputLabel COMP_ACC_ASSURED_TYPE_LABEL;

	private HtmlSelectOneMenu COMP_ACC_ASSURED_TYPE;

	private HtmlOutputLabel COMP_ACC_TYPE_FM_CODE_LABEL;

	private HtmlInputText COMP_ACC_TYPE_FM_CODE;

	private HtmlOutputLabel COMP_ACC_TYPE_TO_CODE_LABEL;

	private HtmlInputText COMP_ACC_TYPE_TO_CODE;

	private HtmlOutputLabel COMP_ACC_YRS_FM_LABEL;

	private HtmlInputText COMP_ACC_YRS_FM;

	private HtmlOutputLabel COMP_ACC_YRS_TO_LABEL;

	private HtmlInputText COMP_ACC_YRS_TO;

	private HtmlOutputLabel COMP_ACC_FORCE_DIVN_YN_LABEL;

	private HtmlSelectOneMenu COMP_ACC_FORCE_DIVN_YN;

	private HtmlOutputLabel COMP_ACC_FORCE_DEPT_YN_LABEL;

	private HtmlSelectOneMenu COMP_ACC_FORCE_DEPT_YN;

	private HtmlOutputLabel COMP_ACC_MAIN_ACNT_CODE_LABEL;

	private HtmlInputText COMP_ACC_MAIN_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_MAIN_ACNT_NAME;

	private HtmlOutputLabel COMP_ACC_SUB_ACNT_CODE_LABEL;

	private HtmlInputText COMP_ACC_SUB_ACNT_CODE;

	private HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_SUB_ACNT_NAME;

	private HtmlOutputLabel COMP_ACC_DIVN_CODE_LABEL;

	private HtmlInputText COMP_ACC_DIVN_CODE;

	private HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DIVN_NAME;

	private HtmlOutputLabel COMP_ACC_DEPT_CODE_LABEL;

	private HtmlInputText COMP_ACC_DEPT_CODE;

	private HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL;

	private HtmlInputText COMP_UI_M_DEPT_NAME;

	private HtmlOutputLabel COMP_ACC_ANLY_CODE_1_LABEL;

	private HtmlInputText COMP_ACC_ANLY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME;

	private HtmlOutputLabel COMP_ACC_ANLY_CODE_2_LABEL;

	private HtmlInputText COMP_ACC_ANLY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ANLY_NAME_1;

	private HtmlOutputLabel COMP_ACC_ACTY_CODE_1_LABEL;

	private HtmlInputText COMP_ACC_ACTY_CODE_1;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME;

	private HtmlOutputLabel COMP_ACC_ACTY_CODE_2_LABEL;

	private HtmlInputText COMP_ACC_ACTY_CODE_2;

	private HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL;

	private HtmlInputText COMP_UI_M_ACTY_NAME_1;

	private HtmlOutputLabel COMP_ACC_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_ACC_FRZ_FLAG;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_FM;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_FM_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_TO_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_2;

	private HtmlCommandButton COMP_UI_M_BUT_ACTY_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_1;

	private HtmlCommandButton COMP_UI_M_BUT_ANAL_2;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN;

	private HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT;

	private HtmlCommandButton COMP_UI_M_BUT_TYPE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_TYPE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_FM_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_TO_CODE;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DEPT_FM;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_TO;

	private HtmlCommandButton COMP_UI_M_BUT_DIVN_FM;
	
	private boolean update = false;

	private List<SelectItem> listACC_SETUP_TYPE = new ArrayList<SelectItem>();
	private List<SelectItem> listACC_DRCR_FLAG = new ArrayList<SelectItem>();
	private List<SelectItem> listACC_SETUP_FOR = new ArrayList<SelectItem>();
	private List<SelectItem> listACC_ASSURED_TYPE = new ArrayList<SelectItem>();
	private List<SelectItem> listACC_FORCE_DIVN_YN = new ArrayList<SelectItem>();
	private List<SelectItem> listACC_FORCE_DEPT_YN = new ArrayList<SelectItem>();

	private PM_IL_ACCRUAL_SETUP PM_IL_ACCRUAL_SETUP_BEAN;
	
	private PM_IL_ACCRUAL_SETUP_HELPER helper=null;
 
	public PM_IL_ACCRUAL_SETUP_ACTION() {
		PM_IL_ACCRUAL_SETUP_BEAN = new PM_IL_ACCRUAL_SETUP();
		helper=new PM_IL_ACCRUAL_SETUP_HELPER();	
		whenCreateRecord();

		getListACC_SETUP_TYPE();
		getListACC_DRCR_FLAG();
		getListACC_SETUP_FOR();
		getListACC_ASSURED_TYPE();
		getListACC_FORCE_DIVN_YN();
		getListACC_FORCE_DEPT_YN();

		//loadValues();
	}
	
	public void beforePhase(PhaseEvent event){
		try {
			if(isBlockFlag()){
				if(PM_IL_ACCRUAL_SETUP_BEAN.getROWID() != null){
					executeSelectStatement(PM_IL_ACCRUAL_SETUP_BEAN.getROWID());
					postQuery(PM_IL_ACCRUAL_SETUP_BEAN);
				getCOMP_ACC_FORCE_DEPT_YN().setDisabled(true);
				}
				setBlockFlag(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("BEFORE_PHASE", e.getMessage());
		}
	}
	
	public void validateDivnDept(FacesContext facesContext,
    		UIComponent component, Object value){
		if("Y".equalsIgnoreCase(PM_IL_ACCRUAL_SETUP_BEAN.getACC_FORCE_DEPT_YN())){
			this.getCOMP_ACC_DEPT_CODE().setDisabled(true);
		}
		else{
			this.getCOMP_ACC_DEPT_CODE().setDisabled(false);
		}
		if("Y".equalsIgnoreCase(PM_IL_ACCRUAL_SETUP_BEAN.getACC_FORCE_DIVN_YN())){
			this.getCOMP_ACC_DIVN_CODE().setDisabled(true);
		}
		else{
			this.getCOMP_ACC_DIVN_CODE().setDisabled(false);
		}
	}
	
	public void executeSelectStatement(String rowId) throws Exception{
		String selectQuery = "SELECT ROWID, PM_IL_ACCRUAL_SETUP.* FROM PM_IL_ACCRUAL_SETUP WHERE ROWID='"+rowId+"'";
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_ACCRUAL_SETUP> list = null;
		
		try {
			con = CommonUtils.getConnection();
			list = handler.fetch(selectQuery, 
					"com.iii.pel.forms.PILM065_APAC.PM_IL_ACCRUAL_SETUP", 
					con);
			setPM_IL_ACCRUAL_SETUP_BEAN(list.get(0));
			setUpdate(true);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
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
	}


	public List<SelectItem> getListACC_SETUP_TYPE() {

		if (listACC_SETUP_TYPE.size() == 0) {
			listACC_SETUP_TYPE.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listACC_SETUP_TYPE = ListItemUtil.getDropDownListValue(con,
						"PILM065_APAC", "PM_IL_ACCRUAL_SETUP", "PM_IL_ACCRUAL_SETUP.ACC_SETUP_TYPE",
				"ACCSETUP");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listACC_SETUP_TYPE;
	}

	public void setListACC_SETUP_TYPE(List<SelectItem> listACC_SETUP_TYPE) {
		this.listACC_SETUP_TYPE = listACC_SETUP_TYPE;
	}

	public List<SelectItem> getListACC_DRCR_FLAG() {

		if (listACC_DRCR_FLAG.size() == 0) {
			listACC_DRCR_FLAG.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listACC_DRCR_FLAG = ListItemUtil.getDropDownListValue(con,
						"PILM065_APAC", "PM_IL_ACCRUAL_SETUP", "PM_IL_ACCRUAL_SETUP.ACC_DRCR_FLAG",	"DEB_CRE");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return listACC_DRCR_FLAG;
	}

	public void setListACC_DRCR_FLAG(List<SelectItem> listACC_DRCR_FLAG) {
		this.listACC_DRCR_FLAG = listACC_DRCR_FLAG;
	}

	public List<SelectItem> getListACC_SETUP_FOR() {

		if (listACC_SETUP_FOR.size() == 0) {
			listACC_SETUP_FOR.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listACC_SETUP_FOR = ListItemUtil.getDropDownListValue(con,
						"PILM065_APAC", "PM_IL_ACCRUAL_SETUP", "PM_IL_ACCRUAL_SETUP.ACC_SETUP_FOR",	"ACCTYPE");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listACC_SETUP_FOR;
	}

	public void setListACC_SETUP_FOR(List<SelectItem> listACC_SETUP_FOR) {
		this.listACC_SETUP_FOR = listACC_SETUP_FOR;
	}

	public List<SelectItem> getListACC_ASSURED_TYPE() {

		if (listACC_ASSURED_TYPE.size() == 0) {
			listACC_ASSURED_TYPE.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listACC_ASSURED_TYPE = ListItemUtil.getDropDownListValue(con,
						"PILM065_APAC", "PM_IL_ACCRUAL_SETUP", "PM_IL_ACCRUAL_SETUP.ACC_ASSURED_TYPE",
				"ASSRTYPE");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listACC_ASSURED_TYPE;
	}

	public void setListACC_ASSURED_TYPE(List<SelectItem> listACC_ASSURED_TYPE) {
		this.listACC_ASSURED_TYPE = listACC_ASSURED_TYPE;
	}

	public List<SelectItem> getListACC_FORCE_DIVN_YN() {

		if (listACC_FORCE_DIVN_YN.size() == 0) {
			listACC_FORCE_DIVN_YN.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listACC_FORCE_DIVN_YN = ListItemUtil.getDropDownListValue(con,
						"PILM065_APAC", "PM_IL_ACCRUAL_SETUP", "PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN",	"YESNO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}


		return listACC_FORCE_DIVN_YN;
	}

	public void setListACC_FORCE_DIVN_YN(List<SelectItem> listACC_FORCE_DIVN_YN) {
		this.listACC_FORCE_DIVN_YN = listACC_FORCE_DIVN_YN;
	}

	public List<SelectItem> getListACC_FORCE_DEPT_YN() {
		if (listACC_FORCE_DEPT_YN.size() == 0) {
			listACC_FORCE_DEPT_YN.clear();
			Connection con;
			try {
				con = CommonUtils.getConnection();
				listACC_FORCE_DEPT_YN = ListItemUtil.getDropDownListValue(con,
						"PILM065_APAC", "PM_IL_ACCRUAL_SETUP", "PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN",	"YESNO");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listACC_FORCE_DEPT_YN;
	}

	public void setListACC_FORCE_DEPT_YN(List<SelectItem> listACC_FORCE_DEPT_YN) {
		this.listACC_FORCE_DEPT_YN = listACC_FORCE_DEPT_YN;
	}

	public String backToSearch() {
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}


	private void loadValues() {
		FacesContext ctx = FacesContext.getCurrentInstance();		
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		String rowId = req.getParameter("ROWID");
		String query = "SELECT ROWID, PM_IL_ACCRUAL_SETUP.* FROM PM_IL_ACCRUAL_SETUP WHERE ROWID='"+rowId+"'";
		try {
			List<PM_IL_ACCRUAL_SETUP> list = getHandler().fetch(query,"com.iii.pel.forms.PILM065_APAC.PM_IL_ACCRUAL_SETUP",getConnection());
			PM_IL_ACCRUAL_SETUP_BEAN = list.get(0);
			loadMainAccountDescription(PM_IL_ACCRUAL_SETUP_BEAN);
			loadSubAccountDescription(PM_IL_ACCRUAL_SETUP_BEAN);
			loadACC_DIVN_CODEDescription(PM_IL_ACCRUAL_SETUP_BEAN);
			loadACC_DEPT_CODEDescription(PM_IL_ACCRUAL_SETUP_BEAN);
			loadACC_ANLY_CODE_1Description(PM_IL_ACCRUAL_SETUP_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	private void loadMainAccountDescription(PM_IL_ACCRUAL_SETUP bean) throws Exception {
		try{
			String desc = new DBProcedures().P_VAL_MAIN_ACNT(bean.getACC_MAIN_ACNT_CODE(),null, "N", "E");
			if(desc != null ){
				bean.setUI_M_MAIN_ACNT_NAME(desc);
			}
		} catch(Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	

	private void loadSubAccountDescription(PM_IL_ACCRUAL_SETUP bean) throws Exception {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription().....................");
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() SUB Acc Code: "+bean.getACC_SUB_ACNT_CODE());
		String UI_M_SUB_ACNT_NAME = "";
		try{
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_SUB_ACNT(?,?,?,?,?)}");
			cs.setString(1,bean.getACC_MAIN_ACNT_CODE());
			cs.setString(2, bean.getACC_SUB_ACNT_CODE());
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.setString(3, bean.getUI_M_SUB_ACNT_NAME());
			cs.setString(4, "N");
			cs.setString(5, "E");
			boolean flag = cs.execute();
			UI_M_SUB_ACNT_NAME = cs.getString(3);
			System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() Desc: "+UI_M_SUB_ACNT_NAME);
			bean.setUI_M_SUB_ACNT_NAME(UI_M_SUB_ACNT_NAME);
			getErrorMap().clear();
		} catch(Exception e) {
			ErrorHelpUtil.getErrorsAndWarningforProcedure(getConnection(), FacesContext.getCurrentInstance(),"UI_M_SUB_ACNT_NAME",getWarningMap());
			e.printStackTrace();
		}
	}
	//[BugId:TRACK_PREMIAGDC_GL.10.5-00163  : Modified method for calling dept desc instated of calling F_VAL_DIVN to P_VAL_DIVN . : Added by : Shankar Bodduluri 30-Mar-2009
	private void loadACC_DIVN_CODEDescription(PM_IL_ACCRUAL_SETUP bean)  {
		ArrayList<String> arrayList = new ArrayList<String>();
		DBProcedures proceduresCall = new DBProcedures();
		try {
			arrayList = proceduresCall.callP_VAL_DIVN(bean.getACC_DIVN_CODE(),"N","E");
			if(arrayList != null && arrayList.size() > 0) {
				bean.setUI_M_DIVN_NAME(arrayList.get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(getConnection(), FacesContext.getCurrentInstance(),"UI_M_DIVN_NAME",getWarningMap());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	/*private void loadACC_DIVN_CODEDescription(PM_IL_ACCRUAL_SETUP bean) throws Exception {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription().....................");
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() SUB Acc Code: "+bean.getACC_SUB_ACNT_CODE());
		String UI_M_DIVN_NAME = "";
		try {
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call F_VAL_DIVN(?,?,?,?)}");
			cs.setString(1,bean.getACC_DIVN_CODE());
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.setString(2, bean.getUI_M_DIVN_NAME());
			cs.setString(3, "N");
			cs.setString(4, "E");
			boolean flag = cs.execute();
			UI_M_DIVN_NAME = cs.getString(2);
			System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() Desc: "+UI_M_DIVN_NAME);
			if(UI_M_DIVN_NAME!=null){
			bean.setUI_M_DIVN_NAME(UI_M_DIVN_NAME);
			COMP_UI_M_DIVN_NAME.setSubmittedValue(UI_M_DIVN_NAME);
			}else{
				bean.setUI_M_DIVN_NAME(null);
				COMP_UI_M_DIVN_NAME.setSubmittedValue(null);
			}
			getErrorMap().clear();
		} catch(Exception e) {
			ErrorHelpUtil.getErrorsAndWarningforProcedure(getConnection(), FacesContext.getCurrentInstance(),"UI_M_SUB_ACNT_NAME",getWarningMap());
			e.printStackTrace();
		}
	}*/
	
	
		/*private void loadACC_DEPT_CODEDescription(PM_IL_ACCRUAL_SETUP bean) throws Exception {
			System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription().....................");
			System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() SUB Acc Code: "+bean.getACC_SUB_ACNT_CODE());
			String UI_M_DEPT_NAME = "";
			try {
				CallableStatement cs = CommonUtils.getConnection().prepareCall("{call F_VAL_DEPT(?,?,?,?,?)}");
				cs.setString(1,bean.getACC_DIVN_CODE());
				cs.setString(2,bean.getACC_DEPT_CODE());
				cs.registerOutParameter(3, java.sql.Types.VARCHAR);
				cs.setString(3, bean.getUI_M_DEPT_NAME());
				cs.setString(4, "N");
				cs.setString(5, "E");
				boolean flag = cs.execute();
				UI_M_DEPT_NAME = cs.getString(3);
				System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() Desc: "+UI_M_DEPT_NAME);
				bean.setUI_M_DEPT_NAME(UI_M_DEPT_NAME);
				getErrorMap().clear();
			} catch(Exception e) {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(getConnection(), FacesContext.getCurrentInstance(),"UI_M_SUB_ACNT_NAME",getWarningMap());
				e.printStackTrace();
			}
		}*/
//	[BugId:TRACK_PREMIAGDC_GL.10.5-00163  : Modified method for calling dept desc instated of calling F_VAL_DEPT to P_VAL_DEPT . : Added by : Shankar Bodduluri 30-Mar-2009
	private void loadACC_DEPT_CODEDescription(PM_IL_ACCRUAL_SETUP bean){
		DBProcedures proceduresCall = new DBProcedures();
		String POL_DIVN_CODE = bean.getACC_DIVN_CODE();
		try {
			ArrayList<String> DEPT_DESC = proceduresCall.callP_VAL_DEPT(POL_DIVN_CODE, bean.getUI_M_DEPT_NAME(), "N", "E");
			if (DEPT_DESC != null && DEPT_DESC.size() > 0) {
				bean.setUI_M_DEPT_NAME(DEPT_DESC.get(0));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		private void loadACC_ANLY_CODE_1Description(PM_IL_ACCRUAL_SETUP bean) throws Exception {
			System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription().....................");
			System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() SUB Acc Code: "+bean.getACC_SUB_ACNT_CODE());
			String UI_M_ANLY_NAME = "";
			try {
				CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_ANLY(?,?,?,?,?)}");
				cs.setString(1,"1");
				cs.setString(2,bean.getACC_ANLY_CODE_1());
				cs.registerOutParameter(3, java.sql.Types.VARCHAR);
				cs.setString(3, bean.getUI_M_ANLY_NAME());
				cs.setString(4, "N");
				cs.setString(5, "E");
				boolean flag = cs.execute();
				UI_M_ANLY_NAME = cs.getString(3);
				System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.loadSubAccountDescription() Desc: "+UI_M_ANLY_NAME);
				bean.setUI_M_ANLY_NAME(UI_M_ANLY_NAME);
				getErrorMap().clear();
			} catch(Exception e) {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(getConnection(), FacesContext.getCurrentInstance(),"UI_M_SUB_ACNT_NAME",getWarningMap());
				e.printStackTrace();
			}
			
		}
		
	public HtmlOutputLabel getCOMP_ACC_SRC_BUS_FM_LABEL() {
		return COMP_ACC_SRC_BUS_FM_LABEL;
	}

	public HtmlInputText getCOMP_ACC_SRC_BUS_FM() {
		return COMP_ACC_SRC_BUS_FM;
	}

	public void setCOMP_ACC_SRC_BUS_FM_LABEL(HtmlOutputLabel COMP_ACC_SRC_BUS_FM_LABEL) {
		this.COMP_ACC_SRC_BUS_FM_LABEL = COMP_ACC_SRC_BUS_FM_LABEL;
	}

	public void setCOMP_ACC_SRC_BUS_FM(HtmlInputText COMP_ACC_SRC_BUS_FM) {
		this.COMP_ACC_SRC_BUS_FM = COMP_ACC_SRC_BUS_FM;
	}

	public HtmlOutputLabel getCOMP_ACC_SRC_BUS_TO_LABEL() {
		return COMP_ACC_SRC_BUS_TO_LABEL;
	}

	public HtmlInputText getCOMP_ACC_SRC_BUS_TO() {
		return COMP_ACC_SRC_BUS_TO;
	}

	public void setCOMP_ACC_SRC_BUS_TO_LABEL(HtmlOutputLabel COMP_ACC_SRC_BUS_TO_LABEL) {
		this.COMP_ACC_SRC_BUS_TO_LABEL = COMP_ACC_SRC_BUS_TO_LABEL;
	}

	public void setCOMP_ACC_SRC_BUS_TO(HtmlInputText COMP_ACC_SRC_BUS_TO) {
		this.COMP_ACC_SRC_BUS_TO = COMP_ACC_SRC_BUS_TO;
	}

	public HtmlOutputLabel getCOMP_ACC_BUS_FM_CODE_LABEL() {
		return COMP_ACC_BUS_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_BUS_FM_CODE() {
		return COMP_ACC_BUS_FM_CODE;
	}

	public void setCOMP_ACC_BUS_FM_CODE_LABEL(HtmlOutputLabel COMP_ACC_BUS_FM_CODE_LABEL) {
		this.COMP_ACC_BUS_FM_CODE_LABEL = COMP_ACC_BUS_FM_CODE_LABEL;
	}

	public void setCOMP_ACC_BUS_FM_CODE(HtmlInputText COMP_ACC_BUS_FM_CODE) {
		this.COMP_ACC_BUS_FM_CODE = COMP_ACC_BUS_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_BUS_TO_CODE_LABEL() {
		return COMP_ACC_BUS_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_BUS_TO_CODE() {
		return COMP_ACC_BUS_TO_CODE;
	}

	public void setCOMP_ACC_BUS_TO_CODE_LABEL(HtmlOutputLabel COMP_ACC_BUS_TO_CODE_LABEL) {
		this.COMP_ACC_BUS_TO_CODE_LABEL = COMP_ACC_BUS_TO_CODE_LABEL;
	}

	public void setCOMP_ACC_BUS_TO_CODE(HtmlInputText COMP_ACC_BUS_TO_CODE) {
		this.COMP_ACC_BUS_TO_CODE = COMP_ACC_BUS_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_DIVN_FM_CODE_LABEL() {
		return COMP_ACC_DIVN_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DIVN_FM_CODE() {
		return COMP_ACC_DIVN_FM_CODE;
	}

	public void setCOMP_ACC_DIVN_FM_CODE_LABEL(HtmlOutputLabel COMP_ACC_DIVN_FM_CODE_LABEL) {
		this.COMP_ACC_DIVN_FM_CODE_LABEL = COMP_ACC_DIVN_FM_CODE_LABEL;
	}

	public void setCOMP_ACC_DIVN_FM_CODE(HtmlInputText COMP_ACC_DIVN_FM_CODE) {
		this.COMP_ACC_DIVN_FM_CODE = COMP_ACC_DIVN_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_DIVN_TO_CODE_LABEL() {
		return COMP_ACC_DIVN_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DIVN_TO_CODE() {
		return COMP_ACC_DIVN_TO_CODE;
	}

	public void setCOMP_ACC_DIVN_TO_CODE_LABEL(HtmlOutputLabel COMP_ACC_DIVN_TO_CODE_LABEL) {
		this.COMP_ACC_DIVN_TO_CODE_LABEL = COMP_ACC_DIVN_TO_CODE_LABEL;
	}

	public void setCOMP_ACC_DIVN_TO_CODE(HtmlInputText COMP_ACC_DIVN_TO_CODE) {
		this.COMP_ACC_DIVN_TO_CODE = COMP_ACC_DIVN_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_DEPT_FM_CODE_LABEL() {
		return COMP_ACC_DEPT_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DEPT_FM_CODE() {
		return COMP_ACC_DEPT_FM_CODE;
	}

	public void setCOMP_ACC_DEPT_FM_CODE_LABEL(HtmlOutputLabel COMP_ACC_DEPT_FM_CODE_LABEL) {
		this.COMP_ACC_DEPT_FM_CODE_LABEL = COMP_ACC_DEPT_FM_CODE_LABEL;
	}

	public void setCOMP_ACC_DEPT_FM_CODE(HtmlInputText COMP_ACC_DEPT_FM_CODE) {
		this.COMP_ACC_DEPT_FM_CODE = COMP_ACC_DEPT_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_DEPT_TO_CODE_LABEL() {
		return COMP_ACC_DEPT_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DEPT_TO_CODE() {
		return COMP_ACC_DEPT_TO_CODE;
	}

	public void setCOMP_ACC_DEPT_TO_CODE_LABEL(HtmlOutputLabel COMP_ACC_DEPT_TO_CODE_LABEL) {
		this.COMP_ACC_DEPT_TO_CODE_LABEL = COMP_ACC_DEPT_TO_CODE_LABEL;
	}

	public void setCOMP_ACC_DEPT_TO_CODE(HtmlInputText COMP_ACC_DEPT_TO_CODE) {
		this.COMP_ACC_DEPT_TO_CODE = COMP_ACC_DEPT_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_DOC_FM_TYPE_LABEL() {
		return COMP_ACC_DOC_FM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DOC_FM_TYPE() {
		return COMP_ACC_DOC_FM_TYPE;
	}

	public void setCOMP_ACC_DOC_FM_TYPE_LABEL(HtmlOutputLabel COMP_ACC_DOC_FM_TYPE_LABEL) {
		this.COMP_ACC_DOC_FM_TYPE_LABEL = COMP_ACC_DOC_FM_TYPE_LABEL;
	}

	public void setCOMP_ACC_DOC_FM_TYPE(HtmlInputText COMP_ACC_DOC_FM_TYPE) {
		this.COMP_ACC_DOC_FM_TYPE = COMP_ACC_DOC_FM_TYPE;
	}

	public HtmlOutputLabel getCOMP_ACC_DOC_TO_TYPE_LABEL() {
		return COMP_ACC_DOC_TO_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DOC_TO_TYPE() {
		return COMP_ACC_DOC_TO_TYPE;
	}

	public void setCOMP_ACC_DOC_TO_TYPE_LABEL(HtmlOutputLabel COMP_ACC_DOC_TO_TYPE_LABEL) {
		this.COMP_ACC_DOC_TO_TYPE_LABEL = COMP_ACC_DOC_TO_TYPE_LABEL;
	}

	public void setCOMP_ACC_DOC_TO_TYPE(HtmlInputText COMP_ACC_DOC_TO_TYPE) {
		this.COMP_ACC_DOC_TO_TYPE = COMP_ACC_DOC_TO_TYPE;
	}

	public HtmlOutputLabel getCOMP_ACC_SETUP_TYPE_LABEL() {
		return COMP_ACC_SETUP_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACC_SETUP_TYPE() {
		return COMP_ACC_SETUP_TYPE;
	}

	public void setCOMP_ACC_SETUP_TYPE_LABEL(HtmlOutputLabel COMP_ACC_SETUP_TYPE_LABEL) {
		this.COMP_ACC_SETUP_TYPE_LABEL = COMP_ACC_SETUP_TYPE_LABEL;
	}

	public void setCOMP_ACC_SETUP_TYPE(HtmlSelectOneMenu COMP_ACC_SETUP_TYPE) {
		this.COMP_ACC_SETUP_TYPE = COMP_ACC_SETUP_TYPE;
	}

	public HtmlOutputLabel getCOMP_ACC_DRCR_FLAG_LABEL() {
		return COMP_ACC_DRCR_FLAG_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACC_DRCR_FLAG() {
		return COMP_ACC_DRCR_FLAG;
	}

	public void setCOMP_ACC_DRCR_FLAG_LABEL(HtmlOutputLabel COMP_ACC_DRCR_FLAG_LABEL) {
		this.COMP_ACC_DRCR_FLAG_LABEL = COMP_ACC_DRCR_FLAG_LABEL;
	}

	public void setCOMP_ACC_DRCR_FLAG(HtmlSelectOneMenu COMP_ACC_DRCR_FLAG) {
		this.COMP_ACC_DRCR_FLAG = COMP_ACC_DRCR_FLAG;
	}

	public HtmlOutputLabel getCOMP_ACC_SETUP_FOR_LABEL() {
		return COMP_ACC_SETUP_FOR_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACC_SETUP_FOR() {
		return COMP_ACC_SETUP_FOR;
	}

	public void setCOMP_ACC_SETUP_FOR_LABEL(HtmlOutputLabel COMP_ACC_SETUP_FOR_LABEL) {
		this.COMP_ACC_SETUP_FOR_LABEL = COMP_ACC_SETUP_FOR_LABEL;
	}

	public void setCOMP_ACC_SETUP_FOR(HtmlSelectOneMenu COMP_ACC_SETUP_FOR) {
		this.COMP_ACC_SETUP_FOR = COMP_ACC_SETUP_FOR;
	}

	public HtmlOutputLabel getCOMP_ACC_PROD_CODE_FM_LABEL() {
		return COMP_ACC_PROD_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_ACC_PROD_CODE_FM() {
		return COMP_ACC_PROD_CODE_FM;
	}

	public void setCOMP_ACC_PROD_CODE_FM_LABEL(HtmlOutputLabel COMP_ACC_PROD_CODE_FM_LABEL) {
		this.COMP_ACC_PROD_CODE_FM_LABEL = COMP_ACC_PROD_CODE_FM_LABEL;
	}

	public void setCOMP_ACC_PROD_CODE_FM(HtmlInputText COMP_ACC_PROD_CODE_FM) {
		this.COMP_ACC_PROD_CODE_FM = COMP_ACC_PROD_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_ACC_PROD_CODE_TO_LABEL() {
		return COMP_ACC_PROD_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_ACC_PROD_CODE_TO() {
		return COMP_ACC_PROD_CODE_TO;
	}

	public void setCOMP_ACC_PROD_CODE_TO_LABEL(HtmlOutputLabel COMP_ACC_PROD_CODE_TO_LABEL) {
		this.COMP_ACC_PROD_CODE_TO_LABEL = COMP_ACC_PROD_CODE_TO_LABEL;
	}

	public void setCOMP_ACC_PROD_CODE_TO(HtmlInputText COMP_ACC_PROD_CODE_TO) {
		this.COMP_ACC_PROD_CODE_TO = COMP_ACC_PROD_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_ACC_COVER_CODE_FM_LABEL() {
		return COMP_ACC_COVER_CODE_FM_LABEL;
	}

	public HtmlInputText getCOMP_ACC_COVER_CODE_FM() {
		return COMP_ACC_COVER_CODE_FM;
	}

	public void setCOMP_ACC_COVER_CODE_FM_LABEL(HtmlOutputLabel COMP_ACC_COVER_CODE_FM_LABEL) {
		this.COMP_ACC_COVER_CODE_FM_LABEL = COMP_ACC_COVER_CODE_FM_LABEL;
	}

	public void setCOMP_ACC_COVER_CODE_FM(HtmlInputText COMP_ACC_COVER_CODE_FM) {
		this.COMP_ACC_COVER_CODE_FM = COMP_ACC_COVER_CODE_FM;
	}

	public HtmlOutputLabel getCOMP_ACC_COVER_CODE_TO_LABEL() {
		return COMP_ACC_COVER_CODE_TO_LABEL;
	}

	public HtmlInputText getCOMP_ACC_COVER_CODE_TO() {
		return COMP_ACC_COVER_CODE_TO;
	}

	public void setCOMP_ACC_COVER_CODE_TO_LABEL(HtmlOutputLabel COMP_ACC_COVER_CODE_TO_LABEL) {
		this.COMP_ACC_COVER_CODE_TO_LABEL = COMP_ACC_COVER_CODE_TO_LABEL;
	}

	public void setCOMP_ACC_COVER_CODE_TO(HtmlInputText COMP_ACC_COVER_CODE_TO) {
		this.COMP_ACC_COVER_CODE_TO = COMP_ACC_COVER_CODE_TO;
	}

	public HtmlOutputLabel getCOMP_ACC_ASSURED_TYPE_LABEL() {
		return COMP_ACC_ASSURED_TYPE_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACC_ASSURED_TYPE() {
		return COMP_ACC_ASSURED_TYPE;
	}

	public void setCOMP_ACC_ASSURED_TYPE_LABEL(HtmlOutputLabel COMP_ACC_ASSURED_TYPE_LABEL) {
		this.COMP_ACC_ASSURED_TYPE_LABEL = COMP_ACC_ASSURED_TYPE_LABEL;
	}

	public void setCOMP_ACC_ASSURED_TYPE(HtmlSelectOneMenu COMP_ACC_ASSURED_TYPE) {
		this.COMP_ACC_ASSURED_TYPE = COMP_ACC_ASSURED_TYPE;
	}

	public HtmlOutputLabel getCOMP_ACC_TYPE_FM_CODE_LABEL() {
		return COMP_ACC_TYPE_FM_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_TYPE_FM_CODE() {
		return COMP_ACC_TYPE_FM_CODE;
	}

	public void setCOMP_ACC_TYPE_FM_CODE_LABEL(HtmlOutputLabel COMP_ACC_TYPE_FM_CODE_LABEL) {
		this.COMP_ACC_TYPE_FM_CODE_LABEL = COMP_ACC_TYPE_FM_CODE_LABEL;
	}

	public void setCOMP_ACC_TYPE_FM_CODE(HtmlInputText COMP_ACC_TYPE_FM_CODE) {
		this.COMP_ACC_TYPE_FM_CODE = COMP_ACC_TYPE_FM_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_TYPE_TO_CODE_LABEL() {
		return COMP_ACC_TYPE_TO_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_TYPE_TO_CODE() {
		return COMP_ACC_TYPE_TO_CODE;
	}

	public void setCOMP_ACC_TYPE_TO_CODE_LABEL(HtmlOutputLabel COMP_ACC_TYPE_TO_CODE_LABEL) {
		this.COMP_ACC_TYPE_TO_CODE_LABEL = COMP_ACC_TYPE_TO_CODE_LABEL;
	}

	public void setCOMP_ACC_TYPE_TO_CODE(HtmlInputText COMP_ACC_TYPE_TO_CODE) {
		this.COMP_ACC_TYPE_TO_CODE = COMP_ACC_TYPE_TO_CODE;
	}

	public HtmlOutputLabel getCOMP_ACC_YRS_FM_LABEL() {
		return COMP_ACC_YRS_FM_LABEL;
	}

	public HtmlInputText getCOMP_ACC_YRS_FM() {
		return COMP_ACC_YRS_FM;
	}

	public void setCOMP_ACC_YRS_FM_LABEL(HtmlOutputLabel COMP_ACC_YRS_FM_LABEL) {
		this.COMP_ACC_YRS_FM_LABEL = COMP_ACC_YRS_FM_LABEL;
	}

	public void setCOMP_ACC_YRS_FM(HtmlInputText COMP_ACC_YRS_FM) {
		this.COMP_ACC_YRS_FM = COMP_ACC_YRS_FM;
	}

	public HtmlOutputLabel getCOMP_ACC_YRS_TO_LABEL() {
		return COMP_ACC_YRS_TO_LABEL;
	}

	public HtmlInputText getCOMP_ACC_YRS_TO() {
		return COMP_ACC_YRS_TO;
	}

	public void setCOMP_ACC_YRS_TO_LABEL(HtmlOutputLabel COMP_ACC_YRS_TO_LABEL) {
		this.COMP_ACC_YRS_TO_LABEL = COMP_ACC_YRS_TO_LABEL;
	}

	public void setCOMP_ACC_YRS_TO(HtmlInputText COMP_ACC_YRS_TO) {
		this.COMP_ACC_YRS_TO = COMP_ACC_YRS_TO;
	}

	public HtmlOutputLabel getCOMP_ACC_FORCE_DIVN_YN_LABEL() {
		return COMP_ACC_FORCE_DIVN_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACC_FORCE_DIVN_YN() {
		return COMP_ACC_FORCE_DIVN_YN;
	}

	public void setCOMP_ACC_FORCE_DIVN_YN_LABEL(HtmlOutputLabel COMP_ACC_FORCE_DIVN_YN_LABEL) {
		this.COMP_ACC_FORCE_DIVN_YN_LABEL = COMP_ACC_FORCE_DIVN_YN_LABEL;
	}

	public void setCOMP_ACC_FORCE_DIVN_YN(HtmlSelectOneMenu COMP_ACC_FORCE_DIVN_YN) {
		this.COMP_ACC_FORCE_DIVN_YN = COMP_ACC_FORCE_DIVN_YN;
	}

	public HtmlOutputLabel getCOMP_ACC_FORCE_DEPT_YN_LABEL() {
		return COMP_ACC_FORCE_DEPT_YN_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_ACC_FORCE_DEPT_YN() {
		return COMP_ACC_FORCE_DEPT_YN;
	}

	public void setCOMP_ACC_FORCE_DEPT_YN_LABEL(HtmlOutputLabel COMP_ACC_FORCE_DEPT_YN_LABEL) {
		this.COMP_ACC_FORCE_DEPT_YN_LABEL = COMP_ACC_FORCE_DEPT_YN_LABEL;
	}

	public void setCOMP_ACC_FORCE_DEPT_YN(HtmlSelectOneMenu COMP_ACC_FORCE_DEPT_YN) {
		this.COMP_ACC_FORCE_DEPT_YN = COMP_ACC_FORCE_DEPT_YN;
	}

	public HtmlOutputLabel getCOMP_ACC_MAIN_ACNT_CODE_LABEL() {
		return COMP_ACC_MAIN_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_MAIN_ACNT_CODE() {
		return COMP_ACC_MAIN_ACNT_CODE;
	}

	public void setCOMP_ACC_MAIN_ACNT_CODE_LABEL(HtmlOutputLabel COMP_ACC_MAIN_ACNT_CODE_LABEL) {
		this.COMP_ACC_MAIN_ACNT_CODE_LABEL = COMP_ACC_MAIN_ACNT_CODE_LABEL;
	}

	public void setCOMP_ACC_MAIN_ACNT_CODE(HtmlInputText COMP_ACC_MAIN_ACNT_CODE) {
		this.COMP_ACC_MAIN_ACNT_CODE = COMP_ACC_MAIN_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_MAIN_ACNT_NAME_LABEL() {
		return COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_MAIN_ACNT_NAME() {
		return COMP_UI_M_MAIN_ACNT_NAME;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_MAIN_ACNT_NAME_LABEL) {
		this.COMP_UI_M_MAIN_ACNT_NAME_LABEL = COMP_UI_M_MAIN_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_MAIN_ACNT_NAME(HtmlInputText COMP_UI_M_MAIN_ACNT_NAME) {
		this.COMP_UI_M_MAIN_ACNT_NAME = COMP_UI_M_MAIN_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_ACC_SUB_ACNT_CODE_LABEL() {
		return COMP_ACC_SUB_ACNT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_SUB_ACNT_CODE() {
		return COMP_ACC_SUB_ACNT_CODE;
	}

	public void setCOMP_ACC_SUB_ACNT_CODE_LABEL(HtmlOutputLabel COMP_ACC_SUB_ACNT_CODE_LABEL) {
		this.COMP_ACC_SUB_ACNT_CODE_LABEL = COMP_ACC_SUB_ACNT_CODE_LABEL;
	}

	public void setCOMP_ACC_SUB_ACNT_CODE(HtmlInputText COMP_ACC_SUB_ACNT_CODE) {
		this.COMP_ACC_SUB_ACNT_CODE = COMP_ACC_SUB_ACNT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_SUB_ACNT_NAME_LABEL() {
		return COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_SUB_ACNT_NAME() {
		return COMP_UI_M_SUB_ACNT_NAME;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_SUB_ACNT_NAME_LABEL) {
		this.COMP_UI_M_SUB_ACNT_NAME_LABEL = COMP_UI_M_SUB_ACNT_NAME_LABEL;
	}

	public void setCOMP_UI_M_SUB_ACNT_NAME(HtmlInputText COMP_UI_M_SUB_ACNT_NAME) {
		this.COMP_UI_M_SUB_ACNT_NAME = COMP_UI_M_SUB_ACNT_NAME;
	}

	public HtmlOutputLabel getCOMP_ACC_DIVN_CODE_LABEL() {
		return COMP_ACC_DIVN_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DIVN_CODE() {
		return COMP_ACC_DIVN_CODE;
	}

	public void setCOMP_ACC_DIVN_CODE_LABEL(HtmlOutputLabel COMP_ACC_DIVN_CODE_LABEL) {
		this.COMP_ACC_DIVN_CODE_LABEL = COMP_ACC_DIVN_CODE_LABEL;
	}

	public void setCOMP_ACC_DIVN_CODE(HtmlInputText COMP_ACC_DIVN_CODE) {
		this.COMP_ACC_DIVN_CODE = COMP_ACC_DIVN_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DIVN_NAME_LABEL() {
		return COMP_UI_M_DIVN_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DIVN_NAME() {
		return COMP_UI_M_DIVN_NAME;
	}

	public void setCOMP_UI_M_DIVN_NAME_LABEL(HtmlOutputLabel COMP_UI_M_DIVN_NAME_LABEL) {
		this.COMP_UI_M_DIVN_NAME_LABEL = COMP_UI_M_DIVN_NAME_LABEL;
	}

	public void setCOMP_UI_M_DIVN_NAME(HtmlInputText COMP_UI_M_DIVN_NAME) {
		this.COMP_UI_M_DIVN_NAME = COMP_UI_M_DIVN_NAME;
	}

	public HtmlOutputLabel getCOMP_ACC_DEPT_CODE_LABEL() {
		return COMP_ACC_DEPT_CODE_LABEL;
	}

	public HtmlInputText getCOMP_ACC_DEPT_CODE() {
		return COMP_ACC_DEPT_CODE;
	}

	public void setCOMP_ACC_DEPT_CODE_LABEL(HtmlOutputLabel COMP_ACC_DEPT_CODE_LABEL) {
		this.COMP_ACC_DEPT_CODE_LABEL = COMP_ACC_DEPT_CODE_LABEL;
	}

	public void setCOMP_ACC_DEPT_CODE(HtmlInputText COMP_ACC_DEPT_CODE) {
		this.COMP_ACC_DEPT_CODE = COMP_ACC_DEPT_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_DEPT_NAME_LABEL() {
		return COMP_UI_M_DEPT_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_DEPT_NAME() {
		return COMP_UI_M_DEPT_NAME;
	}

	public void setCOMP_UI_M_DEPT_NAME_LABEL(HtmlOutputLabel COMP_UI_M_DEPT_NAME_LABEL) {
		this.COMP_UI_M_DEPT_NAME_LABEL = COMP_UI_M_DEPT_NAME_LABEL;
	}

	public void setCOMP_UI_M_DEPT_NAME(HtmlInputText COMP_UI_M_DEPT_NAME) {
		this.COMP_UI_M_DEPT_NAME = COMP_UI_M_DEPT_NAME;
	}

	public HtmlOutputLabel getCOMP_ACC_ANLY_CODE_1_LABEL() {
		return COMP_ACC_ANLY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_ACC_ANLY_CODE_1() {
		return COMP_ACC_ANLY_CODE_1;
	}

	public void setCOMP_ACC_ANLY_CODE_1_LABEL(HtmlOutputLabel COMP_ACC_ANLY_CODE_1_LABEL) {
		this.COMP_ACC_ANLY_CODE_1_LABEL = COMP_ACC_ANLY_CODE_1_LABEL;
	}

	public void setCOMP_ACC_ANLY_CODE_1(HtmlInputText COMP_ACC_ANLY_CODE_1) {
		this.COMP_ACC_ANLY_CODE_1 = COMP_ACC_ANLY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_LABEL() {
		return COMP_UI_M_ANLY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME() {
		return COMP_UI_M_ANLY_NAME;
	}

	public void setCOMP_UI_M_ANLY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ANLY_NAME_LABEL) {
		this.COMP_UI_M_ANLY_NAME_LABEL = COMP_UI_M_ANLY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME(HtmlInputText COMP_UI_M_ANLY_NAME) {
		this.COMP_UI_M_ANLY_NAME = COMP_UI_M_ANLY_NAME;
	}

	public HtmlOutputLabel getCOMP_ACC_ANLY_CODE_2_LABEL() {
		return COMP_ACC_ANLY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_ACC_ANLY_CODE_2() {
		return COMP_ACC_ANLY_CODE_2;
	}

	public void setCOMP_ACC_ANLY_CODE_2_LABEL(HtmlOutputLabel COMP_ACC_ANLY_CODE_2_LABEL) {
		this.COMP_ACC_ANLY_CODE_2_LABEL = COMP_ACC_ANLY_CODE_2_LABEL;
	}

	public void setCOMP_ACC_ANLY_CODE_2(HtmlInputText COMP_ACC_ANLY_CODE_2) {
		this.COMP_ACC_ANLY_CODE_2 = COMP_ACC_ANLY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ANLY_NAME_1_LABEL() {
		return COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ANLY_NAME_1() {
		return COMP_UI_M_ANLY_NAME_1;
	}

	public void setCOMP_UI_M_ANLY_NAME_1_LABEL(HtmlOutputLabel COMP_UI_M_ANLY_NAME_1_LABEL) {
		this.COMP_UI_M_ANLY_NAME_1_LABEL = COMP_UI_M_ANLY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ANLY_NAME_1(HtmlInputText COMP_UI_M_ANLY_NAME_1) {
		this.COMP_UI_M_ANLY_NAME_1 = COMP_UI_M_ANLY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_ACC_ACTY_CODE_1_LABEL() {
		return COMP_ACC_ACTY_CODE_1_LABEL;
	}

	public HtmlInputText getCOMP_ACC_ACTY_CODE_1() {
		return COMP_ACC_ACTY_CODE_1;
	}

	public void setCOMP_ACC_ACTY_CODE_1_LABEL(HtmlOutputLabel COMP_ACC_ACTY_CODE_1_LABEL) {
		this.COMP_ACC_ACTY_CODE_1_LABEL = COMP_ACC_ACTY_CODE_1_LABEL;
	}

	public void setCOMP_ACC_ACTY_CODE_1(HtmlInputText COMP_ACC_ACTY_CODE_1) {
		this.COMP_ACC_ACTY_CODE_1 = COMP_ACC_ACTY_CODE_1;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_LABEL() {
		return COMP_UI_M_ACTY_NAME_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME() {
		return COMP_UI_M_ACTY_NAME;
	}

	public void setCOMP_UI_M_ACTY_NAME_LABEL(HtmlOutputLabel COMP_UI_M_ACTY_NAME_LABEL) {
		this.COMP_UI_M_ACTY_NAME_LABEL = COMP_UI_M_ACTY_NAME_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME(HtmlInputText COMP_UI_M_ACTY_NAME) {
		this.COMP_UI_M_ACTY_NAME = COMP_UI_M_ACTY_NAME;
	}

	public HtmlOutputLabel getCOMP_ACC_ACTY_CODE_2_LABEL() {
		return COMP_ACC_ACTY_CODE_2_LABEL;
	}

	public HtmlInputText getCOMP_ACC_ACTY_CODE_2() {
		return COMP_ACC_ACTY_CODE_2;
	}

	public void setCOMP_ACC_ACTY_CODE_2_LABEL(HtmlOutputLabel COMP_ACC_ACTY_CODE_2_LABEL) {
		this.COMP_ACC_ACTY_CODE_2_LABEL = COMP_ACC_ACTY_CODE_2_LABEL;
	}

	public void setCOMP_ACC_ACTY_CODE_2(HtmlInputText COMP_ACC_ACTY_CODE_2) {
		this.COMP_ACC_ACTY_CODE_2 = COMP_ACC_ACTY_CODE_2;
	}

	public HtmlOutputLabel getCOMP_UI_M_ACTY_NAME_1_LABEL() {
		return COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_ACTY_NAME_1() {
		return COMP_UI_M_ACTY_NAME_1;
	}

	public void setCOMP_UI_M_ACTY_NAME_1_LABEL(HtmlOutputLabel COMP_UI_M_ACTY_NAME_1_LABEL) {
		this.COMP_UI_M_ACTY_NAME_1_LABEL = COMP_UI_M_ACTY_NAME_1_LABEL;
	}

	public void setCOMP_UI_M_ACTY_NAME_1(HtmlInputText COMP_UI_M_ACTY_NAME_1) {
		this.COMP_UI_M_ACTY_NAME_1 = COMP_UI_M_ACTY_NAME_1;
	}

	public HtmlOutputLabel getCOMP_ACC_FRZ_FLAG_LABEL() {
		return COMP_ACC_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_ACC_FRZ_FLAG() {
		return COMP_ACC_FRZ_FLAG;
	}

	public void setCOMP_ACC_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_ACC_FRZ_FLAG_LABEL) {
		this.COMP_ACC_FRZ_FLAG_LABEL = COMP_ACC_FRZ_FLAG_LABEL;
	}

	public void setCOMP_ACC_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_ACC_FRZ_FLAG) {
		this.COMP_ACC_FRZ_FLAG = COMP_ACC_FRZ_FLAG;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_SRC_BUS_FM() {
		return COMP_UI_M_BUT_CACS_SRC_BUS_FM;
	}

	public void setCOMP_UI_M_BUT_CACS_SRC_BUS_FM(HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_FM) {
		this.COMP_UI_M_BUT_CACS_SRC_BUS_FM = COMP_UI_M_BUT_CACS_SRC_BUS_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_SRC_BUS_TO() {
		return COMP_UI_M_BUT_CACS_SRC_BUS_TO;
	}

	public void setCOMP_UI_M_BUT_CACS_SRC_BUS_TO(HtmlCommandButton COMP_UI_M_BUT_CACS_SRC_BUS_TO) {
		this.COMP_UI_M_BUT_CACS_SRC_BUS_TO = COMP_UI_M_BUT_CACS_SRC_BUS_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_BUS_FM_CODE() {
		return COMP_UI_M_BUT_CACS_BUS_FM_CODE;
	}

	public void setCOMP_UI_M_BUT_CACS_BUS_FM_CODE(HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_FM_CODE) {
		this.COMP_UI_M_BUT_CACS_BUS_FM_CODE = COMP_UI_M_BUT_CACS_BUS_FM_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_BUS_TO_CODE() {
		return COMP_UI_M_BUT_CACS_BUS_TO_CODE;
	}

	public void setCOMP_UI_M_BUT_CACS_BUS_TO_CODE(HtmlCommandButton COMP_UI_M_BUT_CACS_BUS_TO_CODE) {
		this.COMP_UI_M_BUT_CACS_BUS_TO_CODE = COMP_UI_M_BUT_CACS_BUS_TO_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_2() {
		return COMP_UI_M_BUT_ACTY_2;
	}

	public void setCOMP_UI_M_BUT_ACTY_2(HtmlCommandButton COMP_UI_M_BUT_ACTY_2) {
		this.COMP_UI_M_BUT_ACTY_2 = COMP_UI_M_BUT_ACTY_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ACTY_1() {
		return COMP_UI_M_BUT_ACTY_1;
	}

	public void setCOMP_UI_M_BUT_ACTY_1(HtmlCommandButton COMP_UI_M_BUT_ACTY_1) {
		this.COMP_UI_M_BUT_ACTY_1 = COMP_UI_M_BUT_ACTY_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANAL_1() {
		return COMP_UI_M_BUT_ANAL_1;
	}

	public void setCOMP_UI_M_BUT_ANAL_1(HtmlCommandButton COMP_UI_M_BUT_ANAL_1) {
		this.COMP_UI_M_BUT_ANAL_1 = COMP_UI_M_BUT_ANAL_1;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_ANAL_2() {
		return COMP_UI_M_BUT_ANAL_2;
	}

	public void setCOMP_UI_M_BUT_ANAL_2(HtmlCommandButton COMP_UI_M_BUT_ANAL_2) {
		this.COMP_UI_M_BUT_ANAL_2 = COMP_UI_M_BUT_ANAL_2;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT() {
		return COMP_UI_M_BUT_DEPT;
	}

	public void setCOMP_UI_M_BUT_DEPT(HtmlCommandButton COMP_UI_M_BUT_DEPT) {
		this.COMP_UI_M_BUT_DEPT = COMP_UI_M_BUT_DEPT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN() {
		return COMP_UI_M_BUT_DIVN;
	}

	public void setCOMP_UI_M_BUT_DIVN(HtmlCommandButton COMP_UI_M_BUT_DIVN) {
		this.COMP_UI_M_BUT_DIVN = COMP_UI_M_BUT_DIVN;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_SUB_ACNT() {
		return COMP_UI_M_BUT_SUB_ACNT;
	}

	public void setCOMP_UI_M_BUT_SUB_ACNT(HtmlCommandButton COMP_UI_M_BUT_SUB_ACNT) {
		this.COMP_UI_M_BUT_SUB_ACNT = COMP_UI_M_BUT_SUB_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN_ACNT() {
		return COMP_UI_M_BUT_MAIN_ACNT;
	}

	public void setCOMP_UI_M_BUT_MAIN_ACNT(HtmlCommandButton COMP_UI_M_BUT_MAIN_ACNT) {
		this.COMP_UI_M_BUT_MAIN_ACNT = COMP_UI_M_BUT_MAIN_ACNT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TYPE_TO() {
		return COMP_UI_M_BUT_TYPE_TO;
	}

	public void setCOMP_UI_M_BUT_TYPE_TO(HtmlCommandButton COMP_UI_M_BUT_TYPE_TO) {
		this.COMP_UI_M_BUT_TYPE_TO = COMP_UI_M_BUT_TYPE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_TYPE_FM() {
		return COMP_UI_M_BUT_TYPE_FM;
	}

	public void setCOMP_UI_M_BUT_TYPE_FM(HtmlCommandButton COMP_UI_M_BUT_TYPE_FM) {
		this.COMP_UI_M_BUT_TYPE_FM = COMP_UI_M_BUT_TYPE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_TYPE_FM_CODE() {
		return COMP_UI_M_BUT_DOC_TYPE_FM_CODE;
	}

	public void setCOMP_UI_M_BUT_DOC_TYPE_FM_CODE(HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_FM_CODE) {
		this.COMP_UI_M_BUT_DOC_TYPE_FM_CODE = COMP_UI_M_BUT_DOC_TYPE_FM_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_PROD_CODE_FM() {
		return COMP_UI_M_BUT_CACS_PROD_CODE_FM;
	}

	public void setCOMP_UI_M_BUT_CACS_PROD_CODE_FM(HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_FM) {
		this.COMP_UI_M_BUT_CACS_PROD_CODE_FM = COMP_UI_M_BUT_CACS_PROD_CODE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_COVER_CODE_FM() {
		return COMP_UI_M_BUT_CACS_COVER_CODE_FM;
	}

	public void setCOMP_UI_M_BUT_CACS_COVER_CODE_FM(HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_FM) {
		this.COMP_UI_M_BUT_CACS_COVER_CODE_FM = COMP_UI_M_BUT_CACS_COVER_CODE_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DOC_TYPE_TO_CODE() {
		return COMP_UI_M_BUT_DOC_TYPE_TO_CODE;
	}

	public void setCOMP_UI_M_BUT_DOC_TYPE_TO_CODE(HtmlCommandButton COMP_UI_M_BUT_DOC_TYPE_TO_CODE) {
		this.COMP_UI_M_BUT_DOC_TYPE_TO_CODE = COMP_UI_M_BUT_DOC_TYPE_TO_CODE;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_PROD_CODE_TO() {
		return COMP_UI_M_BUT_CACS_PROD_CODE_TO;
	}

	public void setCOMP_UI_M_BUT_CACS_PROD_CODE_TO(HtmlCommandButton COMP_UI_M_BUT_CACS_PROD_CODE_TO) {
		this.COMP_UI_M_BUT_CACS_PROD_CODE_TO = COMP_UI_M_BUT_CACS_PROD_CODE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_CACS_COVER_CODE_TO() {
		return COMP_UI_M_BUT_CACS_COVER_CODE_TO;
	}

	public void setCOMP_UI_M_BUT_CACS_COVER_CODE_TO(HtmlCommandButton COMP_UI_M_BUT_CACS_COVER_CODE_TO) {
		this.COMP_UI_M_BUT_CACS_COVER_CODE_TO = COMP_UI_M_BUT_CACS_COVER_CODE_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT_TO() {
		return COMP_UI_M_BUT_DEPT_TO;
	}

	public void setCOMP_UI_M_BUT_DEPT_TO(HtmlCommandButton COMP_UI_M_BUT_DEPT_TO) {
		this.COMP_UI_M_BUT_DEPT_TO = COMP_UI_M_BUT_DEPT_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DEPT_FM() {
		return COMP_UI_M_BUT_DEPT_FM;
	}

	public void setCOMP_UI_M_BUT_DEPT_FM(HtmlCommandButton COMP_UI_M_BUT_DEPT_FM) {
		this.COMP_UI_M_BUT_DEPT_FM = COMP_UI_M_BUT_DEPT_FM;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN_TO() {
		return COMP_UI_M_BUT_DIVN_TO;
	}

	public void setCOMP_UI_M_BUT_DIVN_TO(HtmlCommandButton COMP_UI_M_BUT_DIVN_TO) {
		this.COMP_UI_M_BUT_DIVN_TO = COMP_UI_M_BUT_DIVN_TO;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DIVN_FM() {
		return COMP_UI_M_BUT_DIVN_FM;
	}

	public void setCOMP_UI_M_BUT_DIVN_FM(HtmlCommandButton COMP_UI_M_BUT_DIVN_FM) {
		this.COMP_UI_M_BUT_DIVN_FM = COMP_UI_M_BUT_DIVN_FM;
	}

	public PM_IL_ACCRUAL_SETUP getPM_IL_ACCRUAL_SETUP_BEAN() {
		return PM_IL_ACCRUAL_SETUP_BEAN;
	}

	public void setPM_IL_ACCRUAL_SETUP_BEAN(PM_IL_ACCRUAL_SETUP PM_IL_ACCRUAL_SETUP_BEAN) {
		this.PM_IL_ACCRUAL_SETUP_BEAN = PM_IL_ACCRUAL_SETUP_BEAN;
	}

	public List lovACC_SRC_BUS_FM(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String query = "";
		System.out.println("abj---------------------------------->"+(String)obj);
		if(obj.toString().equals("*")){
			query = "SELECT PC_CODE,PC_DESC from PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND  rownum < 25 ORDER BY 1 ASC";
		}else{
			query = "SELECT PC_CODE,PC_DESC FROM PM_CODES WHERE PC_CODE LIKE '"+obj.toString()+"%' AND PC_TYPE='SRC_BUS_TY' AND NVL(PC_FRZ_FLAG,'N') = 'N' and rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("PC_CODE"));
			bean.setName(rs.getString("PC_DESC"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}


	public List lovACC_BUS_FM_CODE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
//		SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES'
		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE='IL_BUSINES' AND  rownum < 25 ORDER BY 1 ASC";
		}else{
			query = "SELECT PS_CODE,PS_CODE_DESC FROM PP_SYSTEM WHERE PS_CODE LIKE '"+obj+"%' AND PS_TYPE='IL_BUSINES' AND  rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("PS_CODE"));
			bean.setName(rs.getString("PS_CODE_DESC"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public void whenListChangedACC_SETUP_TYPE(ActionEvent e) {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.whenListChangedACC_SETUP_TYPE()...");		
		UIInput component = (UIInput) e.getComponent().getParent();
		String compValue = (String) component.getSubmittedValue();
		String M_CODE_DESC = "";
		double M_VALUE = 0;
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.whenListChangedACC_SETUP_TYPE() component value: "+compValue);
		String query = "SELECT PS_CODE_DESC FROM   PP_SYSTEM  WHERE  PS_TYPE = 'IL_MISC_SET' " +
		"AND PS_CODE = '"+compValue+"'";

		Connection conn = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			rs = getHandler().executeSelectStatement(query, conn);
			while(rs.next()) {
				M_CODE_DESC = rs.getString("PS_CODE_DESC");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}

		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN","IL_MISC_SET");
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",compValue);
		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",M_CODE_DESC);
		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'E'");
		OracleParameter param5 = new OracleParameter("in5","STRING","IN OUT",String.valueOf(M_VALUE));
		paramList.add(param1);
		paramList.add(param2);
		paramList.add(param3);
		paramList.add(param4);
		paramList.add(param5);

		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		try {
			ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_CODES");


		} catch (Exception ex) {
//			e.printStackTrace();
			ErrorHelpUtil.getErrorsAndWarningforProcedure(conn, FacesContext.getCurrentInstance(),getCOMP_ACC_SETUP_TYPE().getClientId(FacesContext.getCurrentInstance()),getWarningMap());
		}
	}

	public void whenValidateACC_SETUP_FOR(ActionEvent event) throws ValidatorException {
		UIInput component = (UIInput) event.getComponent().getParent();
		if("".equals(component.getSubmittedValue())) {
			getErrorMap().put("current",Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91022").getSummary());
//			getErrorMap().put(component.getClientId(FacesContext.getCurrentInstance()), "")
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91022"));
		}
	}

	public void whenValidateACC_PROD_CODE_FM(ActionEvent event) {
		P_SET_FIRST_FIELD(getCOMP_ACC_PROD_CODE_FM(),"ACC_PROD_CODE_FM",getCOMP_ACC_PROD_CODE_TO());
		L_VAL_FROM_TO(getCOMP_ACC_PROD_CODE_FM(),getCOMP_ACC_PROD_CODE_TO());
	}

	public void whenValidateACC_PROD_CODE_TO(ActionEvent event) {
		P_SET_SECOND_FIELD(getCOMP_ACC_PROD_CODE_FM(), "ACC_PROD_CODE_FM", getCOMP_ACC_PROD_CODE_TO());
		L_VAL_FROM_TO(getCOMP_ACC_PROD_CODE_FM(),getCOMP_ACC_PROD_CODE_TO());
	}

	public void whenValidateACC_COVER_CODE_FM(ActionEvent event ) {
		P_SET_FIRST_FIELD(getCOMP_ACC_COVER_CODE_FM(),"ACC_COVER_CODE_FM",getCOMP_ACC_COVER_CODE_TO());
		L_VAL_FROM_TO(getCOMP_ACC_COVER_CODE_FM(),getCOMP_ACC_COVER_CODE_TO());
	}

	public void whenValidateACC_COVER_CODE_TO(ActionEvent event ) {
		P_SET_SECOND_FIELD(getCOMP_ACC_COVER_CODE_FM(),"ACC_COVER_CODE_FM",getCOMP_ACC_COVER_CODE_TO());
		L_VAL_FROM_TO(getCOMP_ACC_COVER_CODE_FM(),getCOMP_ACC_COVER_CODE_TO());
	}

	public void whenValidateACC_ASSURED_TYPE(ActionEvent event) throws ValidatorException {
		UIInput component = (UIInput) event.getComponent().getParent();
		if("".equals(component.getSubmittedValue())) {
			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91022"));
		}
	}

	public void whenValidateACC_TYPE_FM_CODE(ActionEvent event) throws ValidatorException {
		getCOMP_ACC_TYPE_TO_CODE().setSubmittedValue(getCOMP_ACC_TYPE_TO_CODE().getSubmittedValue());
	}

	public void whenValidateACC_TYPE_TO_CODE(ActionEvent event) throws ValidatorException {
		UIInput component = (UIInput) event.getComponent().getParent();
		if("".equals(component.getSubmittedValue())) {
			L_VAL_FROM_TO(getCOMP_ACC_TYPE_FM_CODE(), getCOMP_ACC_TYPE_TO_CODE());
		}
	}
	
	public void listenerACC_TYPE_FM_CODE(ActionEvent event) {
		String currentValue = (String) COMP_ACC_TYPE_FM_CODE.getSubmittedValue();

		try {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_TYPE_FM_CODE((String) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "String"));
			COMP_ACC_TYPE_FM_CODE.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ACC_TYPE_FM_CODE", e.getMessage());
		}
	}

	public void listenerACC_TYPE_TO_CODE(ActionEvent event) {
		String currentValue = (String) COMP_ACC_TYPE_TO_CODE.getSubmittedValue();
		try {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_TYPE_TO_CODE((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(PM_IL_ACCRUAL_SETUP_BEAN.getACC_TYPE_FM_CODE(),
							currentValue, "String"));
			COMP_ACC_TYPE_TO_CODE.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ACC_TYPE_TO_CODE", e.getMessage());
		}
	}
	
/*	public void whenValidateACC_YRS_FM(ActionEvent event) {
		Integer currentValue = (Integer) COMP_ACC_YRS_FM.getSubmittedValue();

		try {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_YRS_FM((Integer) new CommonUtils()
					.SET_REP_FIRST_FIELD(currentValue, "Integer"));
			COMP_ACC_YRS_FM.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ACC_YRS_FM", e.getMessage());
		}
	}


	public void ValidateACC_YRS_FM() throws ValidatorException {
		Integer ACC_YRS_FM = (Integer) getCOMP_ACC_YRS_FM().getSubmittedValue();
		String ACC_YRS_TO = (String) getCOMP_ACC_YRS_TO().getSubmittedValue();
		if(!"".equals(ACC_YRS_FM) && ACC_YRS_FM != null ) {
			if(Double.valueOf(ACC_YRS_FM) > 0) {
//				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91018"));
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91018").getSummary());
			}
		}


		if(!"".equals(ACC_YRS_FM) && ACC_YRS_FM != null &&  !"".equals(ACC_YRS_TO) && ACC_YRS_TO != null)  {
			if(Double.valueOf(ACC_YRS_FM) < Double.valueOf(ACC_YRS_TO)) {
//				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91031"));
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91031").getSummary());

			}
		}
	}

	*/
	
	public void validateACC_YRS_FM(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		getErrorMap().clear();
		if (inputValue.isEmpty()) {
			getCOMP_ACC_YRS_FM().setSubmittedValue("0");
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_YRS_FM(0);
		} else {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_YRS_FM(Integer
					.parseInt(inputValue));

		}

		if (inputValue != null && !inputValue.isEmpty()) {
			Integer yrsFm = PM_IL_ACCRUAL_SETUP_BEAN.getACC_YRS_FM();
			Integer yrsTo = PM_IL_ACCRUAL_SETUP_BEAN.getACC_YRS_TO();
			if (yrsFm < 0) {
				throw new ValidatorException(Messages.getMessage(
						PELConstants.pelErrorMessagePath, "91018"));
			}
			if (yrsTo != null) {
				if (yrsFm > yrsTo) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91031"));
				}
			}
		}
	}

	public void validateACC_YRS_TO(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String inputValue = (String) input.getSubmittedValue();
		Integer yrsFm = PM_IL_ACCRUAL_SETUP_BEAN.getACC_YRS_FM();
		if (inputValue.isEmpty()) {
			if (yrsFm != 0) {
				getCOMP_ACC_YRS_TO().setSubmittedValue(yrsFm.toString());
				PM_IL_ACCRUAL_SETUP_BEAN.setACC_YRS_TO(yrsFm);
			} else {
				getCOMP_ACC_YRS_TO().setSubmittedValue("9999");
				PM_IL_ACCRUAL_SETUP_BEAN.setACC_YRS_TO(Integer
						.parseInt("9999"));
			}
		} else {
			//PM_IL_ACCRUAL_SETUP_BEAN.setCACS_PROD_CODE_TO(inputValue);
			ErrorHelpUtil.validate(input, getErrorMap());
		}

	}

	
	
	
/*	public void whenValidateACC_YRS_TO(ActionEvent event) {
		String currentValue = (String) COMP_ACC_YRS_TO.getSubmittedValue();
		try {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_YRS_TO((Integer) new CommonUtils()
			.SET_REP_SECOND_FIELD(PM_IL_ACCRUAL_SETUP_BEAN.getACC_YRS_FM(),
					currentValue, "String"));
			COMP_ACC_YRS_TO.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ACC_YRS_TO", e.getMessage());
		}
	}
	public void ValidateACC_YRS_TO() {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.whenValidateACC_YRS_TO()...");		
		String ACC_YRS_FM = (String) getCOMP_ACC_YRS_FM().getSubmittedValue();
		if(ACC_YRS_FM == null) {
			ACC_YRS_FM = (String) getCOMP_ACC_YRS_FM().getValue();
			if(PM_IL_ACCRUAL_SETUP_BEAN.getACC_YRS_FM()==0){
				PM_IL_ACCRUAL_SETUP_BEAN.setACC_YRS_TO(Integer.parseInt("9999"));
				COMP_ACC_YRS_TO.resetValue();
				}
		}

		String ACC_YRS_TO = (String) getCOMP_ACC_YRS_TO().getSubmittedValue();

		if(!"".equals(ACC_YRS_FM) && ACC_YRS_FM != null ) { 
			if(Double.valueOf(ACC_YRS_FM) > 0) {
//				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91018"));
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91018").getSummary());
			} 
		}
		if(!"".equals(ACC_YRS_FM) && ACC_YRS_FM != null &&  !"".equals(ACC_YRS_TO) && ACC_YRS_TO != null)  {
			if(Double.valueOf(ACC_YRS_FM) < Double.valueOf(ACC_YRS_TO) ) {
//				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91031"));
				getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","91031").getSummary());
			}
		}
		
	}
*/
	public void whenListChangedACC_FORCE_DIVN_YN(ActionEvent event) {
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN,'N') = 'Y' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',INSERT_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',NAVIGABLE,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',REQUIRED,PROPERTY_FALSE);
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN,'N') = 'N' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',REQUIRED,PROPERTY_TRUE);
//		END IF;
//		:PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE     := :PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE;
//		:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN := :PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN;

		getCOMP_ACC_DIVN_CODE().setSubmittedValue(getCOMP_ACC_DIVN_CODE().getSubmittedValue());
		getCOMP_ACC_FORCE_DEPT_YN().setSubmittedValue(getCOMP_ACC_FORCE_DEPT_YN().getSubmittedValue());
	}

	public void whenValidateACC_FORCE_DIVN_YN(ActionEvent event) {
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN,'N') = 'Y' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',INSERT_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',NAVIGABLE,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',REQUIRED,PROPERTY_FALSE);
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN,'N') = 'N' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',REQUIRED,PROPERTY_TRUE);
//		END IF;
//		:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN := :PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN;
		getCOMP_ACC_FORCE_DEPT_YN().setSubmittedValue(getCOMP_ACC_FORCE_DEPT_YN().getSubmittedValue());
	}

	public void whenListChangedACC_FORCE_DEPT_YN(ActionEvent event) {

//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN,'N') = 'Y' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',INSERT_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',NAVIGABLE,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_FALSE);
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN,'N') = 'N' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_TRUE);
//		END IF;

	}

	public void whenValidateACC_FORCE_DEPT_YN(ActionEvent event) {
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN,'N') = 'Y' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',INSERT_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',NAVIGABLE,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_FALSE);
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN,'N') = 'N' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_TRUE);
//		END IF;
//		:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN := :PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN;
		getCOMP_ACC_FORCE_DEPT_YN().setSubmittedValue(getCOMP_ACC_FORCE_DEPT_YN().getSubmittedValue());

	}

	
	
	/*public void whenValidateACC_MAIN_ACNT_CODE(ActionEvent event) {
		//UIInput component = (UIInput) event.getComponent().getParent();
		String ACC_MAIN_ACNT_CODE = (String)COMP_ACC_MAIN_ACNT_CODE.getSubmittedValue();
		
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_MAIN_ACNT_CODE(ACC_MAIN_ACNT_CODE);
		try {
			loadMainAccountDescription(PM_IL_ACCRUAL_SETUP_BEAN);
			//getCOMP_UI_M_MAIN_ACNT_NAME().setSubmittedValue(PM_IL_ACCRUAL_SETUP_BEAN.getUI_M_MAIN_ACNT_NAME());
			COMP_UI_M_MAIN_ACNT_NAME.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
		*/
		/*String ACC_FORCE_DIVN_YN = "".equals(getCOMP_ACC_FORCE_DIVN_YN().getSubmittedValue())?"N":(String)getCOMP_ACC_FORCE_DIVN_YN().getSubmittedValue();
		if("N".equals(ACC_FORCE_DIVN_YN)) {

		}

		String query1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 " +
		"FROM FM_MAIN_ACCOUNT WHERE  MAIN_ACNT_CODE = '"+ACC_MAIN_ACNT_CODE+"'";
		String query2 = "SELECT ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE = :DUMMY.M_ACTY_1";
		String query3 =  "SELECT ACTY_NAME FROM FM_ACTIVITY WHERE ACTY_CODE = :DUMMY.M_ACTY_2";

		System.out
				.println("PM_IL_ACCRUAL_SETUP_ACTION.whenValidateACC_MAIN_ACNT_CODE()-> "+ACC_MAIN_ACNT_CODE);
		
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_MAIN_ACNT_CODE(ACC_MAIN_ACNT_CODE);
		
		loadMainAccountDescription(PM_IL_ACCRUAL_SETUP_BEAN);*/

//		P_VAL_MAIN_ACNT(:PM_IL_ACCRUAL_SETUP.ACC_MAIN_ACNT_CODE,
//		:PM_IL_ACCRUAL_SETUP.M_MAIN_ACNT_NAME,
//		'N',
//		'E');

//		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
//		OracleParameter param1 = new OracleParameter("in1","STRING","IN",ACC_MAIN_ACNT_CODE);
//		OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",(String)getCOMP_UI_M_MAIN_ACNT_NAME().getSubmittedValue());
//		OracleParameter param3 = new OracleParameter("in3","STRING","IN","'N'");
//		OracleParameter param4 = new OracleParameter("in4","STRING","IN","'E'");
//		paramList.add(param1);
//		paramList.add(param2);
//		paramList.add(param3);
//		paramList.add(param4);
//
//		OracleProcedureHandler procHandler = new OracleProcedureHandler();
//		Connection conn = null;
//
//		try {
//			conn = getConnection();
//			ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_MAIN_ACNT");
//			if(list.size() > 0) {
//				getCOMP_UI_M_MAIN_ACNT_NAME().setSubmittedValue(list.get(0).getValue());
//			}
//
//		} catch (Exception ex) {
////			e.printStackTrace();
//			ErrorHelpUtil.getErrorsAndWarningforProcedure(conn, FacesContext.getCurrentInstance(),getCOMP_ACC_MAIN_ACNT_CODE().getClientId(FacesContext.getCurrentInstance()),getWarningMap());
//		}
		
	public void whenValidateACC_SUB_ACNT_CODE(ActionEvent event) {
		String ACC_SUB_ACNT_CODE = (String) getCOMP_ACC_SUB_ACNT_CODE().getSubmittedValue();
		String ACC_MAIN_ACNT_CODE = (String) getCOMP_ACC_MAIN_ACNT_CODE().getValue();
		if(ACC_SUB_ACNT_CODE == null) {
			ACC_SUB_ACNT_CODE = (String) getCOMP_ACC_SUB_ACNT_CODE().getValue();
		}
		if("".equals(ACC_SUB_ACNT_CODE)) {
//			P_VAL_SUB_ACNT (:PM_IL_ACCRUAL_SETUP.ACC_MAIN_ACNT_CODE,
//			:PM_IL_ACCRUAL_SETUP.ACC_SUB_ACNT_CODE,
//			:PM_IL_ACCRUAL_SETUP.M_SUB_ACNT_NAME,
//			'N',
//			'E');

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",ACC_MAIN_ACNT_CODE);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",ACC_SUB_ACNT_CODE);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",(String)getCOMP_UI_M_SUB_ACNT_NAME().getSubmittedValue());
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			Connection conn = null;

			try {
				conn = getConnection();
				COMP_UI_M_SUB_ACNT_NAME.resetValue();
				ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_SUB_ACNT");
				if(list.size() > 0) {
					getCOMP_UI_M_SUB_ACNT_NAME().setSubmittedValue(list.get(0).getValue());
				}else{
					getCOMP_UI_M_SUB_ACNT_NAME().setSubmittedValue(null);
				}

			} catch (Exception ex) {
//				e.printStackTrace();
				ErrorHelpUtil.getErrorsAndWarningforProcedure(conn, FacesContext.getCurrentInstance(),getCOMP_ACC_SUB_ACNT_CODE().getClientId(FacesContext.getCurrentInstance()),getWarningMap());
			}
		}
	}

	public void whenValidateACC_DIVN_CODE(ActionEvent event) {
		//UIInput component = (UIInput) event.getComponent().getParent();
		String ACC_DIVN_CODE = (String) COMP_ACC_DIVN_CODE.getSubmittedValue();
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_DIVN_CODE(ACC_DIVN_CODE);
		try {
			loadACC_DIVN_CODEDescription(PM_IL_ACCRUAL_SETUP_BEAN);
			getCOMP_UI_M_DIVN_NAME().setSubmittedValue(PM_IL_ACCRUAL_SETUP_BEAN.getUI_M_DIVN_NAME());
			COMP_UI_M_DIVN_NAME.resetValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String ACC_FORCE_DIVN_YN = "".equals(getCOMP_ACC_FORCE_DIVN_YN().getSubmittedValue())?"N":(String)getCOMP_ACC_FORCE_DIVN_YN().getSubmittedValue();
		if("N".equals(ACC_FORCE_DIVN_YN)) {

		}
	}
//	[BugId:TRACK_PREMIAGDC_GL.10.5-00163  : Modified method for calling dept desc instated of calling F_VAL_DEPT to P_VAL_DEPT . : Added by : Shankar Bodduluri 30-Mar-2009
	public void whenValidateACC_DEPT_CODE(ActionEvent event) {
		String ACC_DEPT_CODE = getCurrentValue(event);
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_DEPT_CODE(ACC_DEPT_CODE);
		loadACC_DEPT_CODEDescription(PM_IL_ACCRUAL_SETUP_BEAN);	
		COMP_UI_M_DEPT_NAME.resetValue();
	}
	/*public void whenValidateACC_DEPT_CODE(ActionEvent event) {

		//UIInput component = (UIInput) event.getComponent().getParent();
		String ACC_DEPT_CODE = (String) COMP_ACC_DEPT_CODE.getSubmittedValue();
		String ACC_DIVN_CODE = (String) getCOMP_ACC_DIVN_CODE().getValue();

		if(ACC_DEPT_CODE == null) {
			ACC_DEPT_CODE = (String) COMP_ACC_DEPT_CODE.getValue();
		}


		if("".equals(ACC_DEPT_CODE)) {

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",ACC_DIVN_CODE);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",ACC_DEPT_CODE);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",(String) getCOMP_UI_M_DEPT_NAME().getSubmittedValue());
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			Connection conn = null;

			try {
				conn = getConnection();
				//[BugId:TRACK_PREMIAGDC_GL.10.5-00163  : Modified method for calling dept desc instated of calling F_VAL_DEPT to P_VAL_DEPT . : Added by : Shankar Bodduluri 30-Mar-2009
				ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_DEPT");
				if(list.size() > 0) {
					getCOMP_UI_M_DEPT_NAME().setSubmittedValue(list.get(0).getValue());
				}else{
					getCOMP_UI_M_DEPT_NAME().setSubmittedValue(null);
				}

			} catch (Exception ex) {
//				e.printStackTrace();
				ErrorHelpUtil.getErrorsAndWarningforProcedure(conn, FacesContext.getCurrentInstance(),getCOMP_ACC_DEPT_CODE().getClientId(FacesContext.getCurrentInstance()),getWarningMap());
			}

		}


//		:PM_IL_ACCRUAL_SETUP.M_DEPT_NAME := NULL;
//		IF :PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE IS NOT NULL THEN
//		F_VAL_DEPT  (:PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE,
//		:PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE,
//		:PM_IL_ACCRUAL_SETUP.M_DEPT_NAME,
//		'N',
//		'E');
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN,'N') = 'N' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_TRUE);
//		END IF;


	}
	 */

	public void whenValidateACC_ANLY_CODE_1(ActionEvent event) {

		//UIInput component = (UIInput) event.getComponent().getParent();
		String ACC_ANLY_CODE_1 = (String) COMP_ACC_ANLY_CODE_1.getSubmittedValue();

		if(ACC_ANLY_CODE_1 == null) {
			ACC_ANLY_CODE_1 = (String) COMP_ACC_ANLY_CODE_1.getValue(); 
		}

		if(!"".equals(ACC_ANLY_CODE_1)) {

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN","1");
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",ACC_ANLY_CODE_1);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",(String) getCOMP_UI_M_ANLY_NAME().getSubmittedValue());
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			Connection conn = null;

			try {
				COMP_UI_M_ANLY_NAME.resetValue();
				conn = getConnection();
				ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_ANLY");
				if(list.size() > 0) {
					getCOMP_UI_M_ANLY_NAME().setSubmittedValue(list.get(0).getValue());
				}else{
					getCOMP_UI_M_ANLY_NAME().setSubmittedValue(null);
				}

			} catch (Exception ex) {
//				e.printStackTrace();
				ErrorHelpUtil.getErrorsAndWarningforProcedure(conn, FacesContext.getCurrentInstance(),getCOMP_ACC_ANLY_CODE_1().getClientId(FacesContext.getCurrentInstance()),getWarningMap());
			}

		}

//		:PM_IL_ACCRUAL_SETUP.M_ANLY_NAME := NULL;
//		IF :PM_IL_ACCRUAL_SETUP.ACC_ANLY_CODE_1 IS NOT NULL THEN
//		P_VAL_ANLY     ('1',
//		:PM_IL_ACCRUAL_SETUP.ACC_ANLY_CODE_1,
//		:PM_IL_ACCRUAL_SETUP.M_ANLY_NAME,
//		'N',
//		'E');
//		END IF;
//		L_SET_ANALYSIS_ATTR;

	}

	public void whenValidateACC_ANLY_CODE_2(ActionEvent event) {
//		L_SET_ANALYSIS_ATTR;
	}


	public void whenValidateACC_ACTY_CODE_1(ActionEvent event ) {

	//	UIInput component = (UIInput) event.getComponent().getParent();
		String ACC_ACTY_CODE_1 = (String) COMP_ACC_ACTY_CODE_1.getSubmittedValue();

		if(ACC_ACTY_CODE_1 == null) {
			ACC_ACTY_CODE_1 = (String) COMP_ACC_ACTY_CODE_1.getValue(); 
		}

		if(!"".equals(ACC_ACTY_CODE_1)) {

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",null);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",ACC_ACTY_CODE_1);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",(String) getCOMP_UI_M_ACTY_NAME().getSubmittedValue());
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			Connection conn = null;

			try {
				COMP_UI_M_ACTY_NAME_1.resetValue();
				conn = getConnection();
				ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_ACTY");
				if(list.size() > 0) {
					getCOMP_UI_M_ACTY_NAME().setSubmittedValue(list.get(0).getValue());
				}else{
					getCOMP_UI_M_ACTY_NAME().setSubmittedValue(null);
				}

			} catch (Exception ex) {
//				e.printStackTrace();
				ErrorHelpUtil.getErrorsAndWarningforProcedure(conn, FacesContext.getCurrentInstance(),getCOMP_ACC_ANLY_CODE_2().getClientId(FacesContext.getCurrentInstance()),getWarningMap());
			}

		}
//		:PM_IL_ACCRUAL_SETUP.M_ACTY_NAME := NULL;
//		IF :PM_IL_ACCRUAL_SETUP.ACC_ACTY_CODE_1 IS NOT NULL THEN
//		P_VAL_ACTY    ( :DUMMY.M_ACTY_1,
//		:PM_IL_ACCRUAL_SETUP.ACC_ACTY_CODE_1,
//		:PM_IL_ACCRUAL_SETUP.M_ACTY_NAME,
//		'N',
//		'E');
//		END IF;
	}
	
	public void when_validate_M_ANLY_NAME() throws Exception{
		try {
			PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ANLY_NAME(null);
			if(PM_IL_ACCRUAL_SETUP_BEAN.getACC_ANLY_CODE_1() != null){
				ArrayList<String> list = new DBProcedures().P_VAL_ANLY ("1",
			                   PM_IL_ACCRUAL_SETUP_BEAN.getACC_ANLY_CODE_1(),
			                   "N",
			                   "E");
				if(!list.isEmpty()){
					 PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ANLY_NAME(list.get(0));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}

	public void ACC_ANLY_CODE_1_Validator(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		try {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_ANLY_CODE_1((String) value);
			when_validate_M_ANLY_NAME();
			COMP_UI_M_ANLY_NAME.resetValue();
			
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
	

	public void saveRecord() {
			String message = "";
			try {
				if (getPM_IL_ACCRUAL_SETUP_BEAN().getROWID() != null) {
					preUpdate();
					new CRUDHandler().executeUpdate(getPM_IL_ACCRUAL_SETUP_BEAN(),
							CommonUtils.getConnection());
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$update");
				} else {
					preInsert();
					new CRUDHandler().executeInsert(getPM_IL_ACCRUAL_SETUP_BEAN(),
							CommonUtils.getConnection());
					message = Messages.getString(
							PELConstants.pelMessagePropertiesPath,
					"errorPanel$message$save");
				}
				CommonUtils.getConnection().commit();
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						message);
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_DETAILS_KEY,
						e.getMessage());
				getErrorMap().put("SAVE", e.getMessage());
				getErrorMap().put("CURRENT", e.getMessage());
			}
		}

	public String deleteRecord() {
		Connection conn = null;
		try {
			conn = getConnection();
			getHandler().executeDelete(PM_IL_ACCRUAL_SETUP_BEAN, conn);
			conn.commit();
			PM_IL_ACCRUAL_SETUP_BEAN = new PM_IL_ACCRUAL_SETUP();
			resetAllComponent();
			getWarningMap().put("deleteRow",
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(
							PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$delete"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("deleteRow", e.getMessage());
		}
		return "";
	}

	public void checkBoxACC_FRZ_FLAG(ActionEvent event) {
		String checkValue = (String) ((UIInput)event.getComponent().getParent()).getSubmittedValue();
		if("true".equals(checkValue)) {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_FRZ_FLAG("Y");
		} else {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_FRZ_FLAG("N");
		}
	}


	private void preUpdate() {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String userName = (String) sessionMap.get("GLOBAL.M_USER_ID");
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_UPD_UID(userName);
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_UPD_DT(new java.util.Date());
	}

	private void whenCreateRecord() {
//		:PM_IL_ACCRUAL_SETUP.ACC_SETUP_TYPE    := 'A';
//		:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN := 'N';
//		:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN := 'N';
//		:PM_IL_ACCRUAL_SETUP.ACC_SETUP_FOR     := 'P';
//		:PM_IL_ACCRUAL_SETUP.ACC_ASSURED_TYPE  := 'R';
//		:PM_IL_ACCRUAL_SETUP.ACC_DRCR_FLAG     := 'C';
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',REQUIRED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN',ENABLED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY('PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN',NAVIGABLE,PROPERTY_FALSE);

		PM_IL_ACCRUAL_SETUP_BEAN.setACC_SETUP_TYPE("A");
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_FORCE_DIVN_YN("N");
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_FORCE_DEPT_YN("N");
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_SETUP_FOR("P");
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_ASSURED_TYPE("R");
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_DRCR_FLAG("C");

	}

	private void preInsert() {
//		:PM_IL_ACCRUAL_SETUP.ACC_CR_UID := :CTRL.M_USER_ID;
//		:PM_IL_ACCRUAL_SETUP.ACC_CR_DT  := SYSDATE;
//		L_OVERLAP_CHECK;

		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		String userName = (String) sessionMap.get("GLOBAL.M_USER_ID");
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_CR_UID(userName);
		PM_IL_ACCRUAL_SETUP_BEAN.setACC_CR_DT(new java.util.Date());
		
	}

	private void whenNewRecordInstance() {
//		DECLARE
//		CURSOR C1 IS
//		SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2
//		FROM   FM_MAIN_ACCOUNT
//		WHERE  MAIN_ACNT_CODE = :PM_IL_ACCRUAL_SETUP.ACC_MAIN_ACNT_CODE;
//		CURSOR C2 IS 
//		SELECT ACTY_NAME 
//		FROM   FM_ACTIVITY
//		WHERE  ACTY_CODE = :DUMMY.M_ACTY_1;
//		CURSOR C3 IS 
//		SELECT ACTY_NAME 
//		FROM   FM_ACTIVITY
//		WHERE  ACTY_CODE = :DUMMY.M_ACTY_2;
//		CURSOR C4 IS
//		SELECT PS_CODE_DESC,PS_VALUE
//		FROM   PP_SYSTEM
//		WHERE  PS_TYPE = 'IL_MISC_SET'
//		AND    PS_CODE = :PM_IL_ACCRUAL_SETUP.ACC_SETUP_TYPE;
//		M_TEMP1   FM_ACTIVITY.ACTY_NAME%TYPE;
//		M_TEMP2   FM_ACTIVITY.ACTY_NAME%TYPE;   
//		M_DESC    PP_SYSTEM.PS_CODE_DESC%TYPE;
//		M_VALUE   PP_SYSTEM.PS_VALUE%TYPE;
//		BEGIN
//		/*IF :PM_IL_ACCRUAL_SETUP.ACC_SETUP_TYPE IN ('C') THEN
//		SET_ITEM_PROPERTY('ACC_SETUP_FOR',ENABLED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_SETUP_FOR',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_SETUP_FOR',INSERT_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_SETUP_FOR',UPDATE_ALLOWED,PROPERTY_TRUE);
//		ELSE
//		SET_ITEM_PROPERTY('ACC_SETUP_FOR',ENABLED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY('ACC_SETUP_FOR',NAVIGABLE,PROPERTY_FALSE);
//		END IF;*/
//		L_SET_TYPE_BL;
//		IF C1%ISOPEN THEN
//		CLOSE C1;
//		END IF;
//		OPEN C1;
//		FETCH C1 INTO :DUMMY.M_ACTY_1,:DUMMY.M_ACTY_2;
//		IF :DUMMY.M_ACTY_1 IS NOT NULL THEN
//		OPEN C2;
//		FETCH C2 INTO M_TEMP1;
//		:BP.B_CACS_ACTY_CODE_1 := INITCAP(M_TEMP1);
//		CLOSE C2;
//		ELSE
//		:BP.B_CACS_ACTY_CODE_1 := 'Activity code1';
//		END IF;
//		IF :DUMMY.M_ACTY_2 IS NOT NULL THEN
//		OPEN C3;
//		FETCH C3 INTO M_TEMP2;
//		:BP.B_CACS_ACTY_CODE_2 := INITCAP(M_TEMP2);
//		CLOSE C3;
//		ELSE
//		:BP.B_CACS_ACTY_CODE_2 := 'Activity code2';
//		END IF;
//		CLOSE C1;
//		IF C4%ISOPEN THEN
//		CLOSE C4;
//		END IF;
//		OPEN C4;
//		FETCH C4 INTO M_DESC,M_VALUE;
//		:BP.B_CACS_YRS_FM := M_DESC || ' ' || 'years fm';

//		IF M_VALUE = 1 THEN
//		SET_ITEM_PROPERTY('ACC_TYPE_FM_CODE',ENABLED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_TYPE_FM_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_TYPE_FM_CODE',UPDATEABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_TYPE_TO_CODE',ENABLED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_TYPE_TO_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY('ACC_TYPE_TO_CODE',UPDATEABLE,PROPERTY_TRUE);
//		ELSE
//		SET_ITEM_PROPERTY('ACC_TYPE_FM_CODE',ENABLED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY('ACC_TYPE_FM_CODE',NAVIGABLE,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY('ACC_TYPE_TO_CODE',ENABLED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY('ACC_TYPE_TO_CODE',NAVIGABLE,PROPERTY_FALSE);
//		END IF;
//		CLOSE C4;
//		SET_ITEM_PROPERTY('PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN',ENABLED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY('PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN',NAVIGABLE,PROPERTY_FALSE);
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN,'N') = 'Y' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',INSERT_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',NAVIGABLE,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',REQUIRED,PROPERTY_FALSE);
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DIVN_YN,'N') = 'N' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DIVN_CODE',REQUIRED,PROPERTY_TRUE);
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN,'N') = 'Y' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',UPDATE_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',INSERT_ALLOWED,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',NAVIGABLE,PROPERTY_FALSE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_FALSE);
//		END IF;
//		IF NVL(:PM_IL_ACCRUAL_SETUP.ACC_FORCE_DEPT_YN,'N') = 'N' THEN
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',UPDATE_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',INSERT_ALLOWED,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',NAVIGABLE,PROPERTY_TRUE);
//		SET_ITEM_PROPERTY( 'PM_IL_ACCRUAL_SETUP.ACC_DEPT_CODE',REQUIRED,PROPERTY_TRUE);
//		END IF;
//		END; 

	}

	public void whenValidateACC_ACTY_CODE_2(ActionEvent event) {

	//	UIInput component = (UIInput) event.getComponent().getParent();
		String ACC_ACTY_CODE_2 = (String) COMP_ACC_ACTY_CODE_2.getSubmittedValue();

		if(!"".equals(ACC_ACTY_CODE_2)) {

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",null);
			OracleParameter param2 = new OracleParameter("in2","STRING","IN OUT",ACC_ACTY_CODE_2);
			OracleParameter param3 = new OracleParameter("in3","STRING","IN",(String) getCOMP_UI_M_ACTY_NAME_1().getSubmittedValue());
			OracleParameter param4 = new OracleParameter("in4","STRING","IN","'N'");
			OracleParameter param5 = new OracleParameter("in5","STRING","IN","'E'");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			Connection conn = null;

			try {
				conn = getConnection();
				ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "P_VAL_ACTY");
				if(list.size() > 0) {
					getCOMP_UI_M_ACTY_NAME_1().setSubmittedValue(list.get(0).getValue());
				}else{
					getCOMP_UI_M_ACTY_NAME_1().setSubmittedValue(null);
				}

			} catch (Exception ex) {
//				e.printStackTrace();
				ErrorHelpUtil.getErrorsAndWarningforProcedure(conn, FacesContext.getCurrentInstance(),getCOMP_ACC_ACTY_CODE_2().getClientId(FacesContext.getCurrentInstance()),getWarningMap());
			}

		}

//		:PM_IL_ACCRUAL_SETUP.M_ACTY_NAME_1 := NULL;
//		IF :PM_IL_ACCRUAL_SETUP.ACC_ACTY_CODE_2 IS NOT NULL THEN
//		P_VAL_ACTY     (:DUMMY.M_ACTY_2,
//		:PM_IL_ACCRUAL_SETUP.ACC_ACTY_CODE_2,
//		:PM_IL_ACCRUAL_SETUP.M_ACTY_NAME_1,
//		'N',
//		'E');
//		END IF;
	}

	public List lovAACC_DIVN_FM_CODE_old(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
//		SELECT DIVN_CODE,DIVN_NAME FROM PM_DIVISION 
//		WHERE DIVN_COMP_CODE = '' AND 
//		NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND
//		EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP
//		WHERE ADS_DIVN_CODE = DIVN_CODE
//		AND ADS_USER_ID = NVL('LIFEALL',ADS_USER_ID)
//		AND ADS_FRZ_FLAG = 'N') 

		String query = "";
		if(obj.toString().equals("*")){
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DIVISION to FM_DIVISION. Added by : Shankar.B 31-Mar-2009
			query = "SELECT DIVN_CODE,DIVN_NAME FROM FM_DIVISION WHERE DIVN_COMP_CODE is not null and NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = NVL('LIFEALL',ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') AND  rownum < 25 ORDER BY 1 ASC";
		}else{
			query = "SELECT DIVN_CODE,DIVN_NAME FROM FM_DIVISION WHERE DIVN_COMP_CODE is not null AND DIVN_CODE LIKE '"+obj+"%' AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND ADS_USER_ID = NVL('LIFEALL',ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') AND  rownum < 25 ORDER BY 1 ASC";		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("DIVN_CODE"));
			bean.setName(rs.getString("DIVN_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}
	
	/*
	 * Force Branch Y/N
	 */
	public void validateACC_FORCE_DIVN_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String ACC_FORCE_DIVN_YN_STRING = (String)input.getSubmittedValue();
		ACC_DIVN_CODE_YN_WHEN_VALIDATE_ITEM(ACC_FORCE_DIVN_YN_STRING, this);
	}
	
	public void ACC_DIVN_CODE_YN_WHEN_VALIDATE_ITEM(String ACC_FORCE_DIVN_YN_STRING, PM_IL_ACCRUAL_SETUP_ACTION pm_il_accural_setup_action){
		
		if ("Y".equalsIgnoreCase(MigratingFunctions.nvl(
				ACC_FORCE_DIVN_YN_STRING, "N"))) {
			pm_il_accural_setup_action.getCOMP_ACC_DIVN_CODE()
					.setRequired(false);
			pm_il_accural_setup_action.getCOMP_ACC_DIVN_CODE()
					.setDisabled(true);
		}
		if ("N".equalsIgnoreCase(MigratingFunctions.nvl(
				ACC_FORCE_DIVN_YN_STRING, "N"))) {
			pm_il_accural_setup_action.getCOMP_ACC_DIVN_CODE()
					.setDisabled(false);
			pm_il_accural_setup_action.getCOMP_ACC_DIVN_CODE()
					.setRequired(true);
		}
		pm_il_accural_setup_action.getCOMP_ACC_FORCE_DEPT_YN().setSubmittedValue(ACC_FORCE_DIVN_YN_STRING);
		pm_il_accural_setup_action.getCOMP_ACC_FORCE_DEPT_YN().setDisabled(true);

}
	
	/*
	 * Force Department Y/N
	 */
	public void validateACC_FORCE_DEPT_YN(FacesContext fc, UIComponent component,
			Object value) throws ValidatorException, Exception
	{
		UIInput input = (UIInput) component;
		String ACC_FORCE_DEPT_YN_STRING = (String)input.getSubmittedValue();
		ACC_DEPT_CODE_YN_WHEN_VALIDATE_ITEM(ACC_FORCE_DEPT_YN_STRING, this);
	}
	
	public void ACC_DEPT_CODE_YN_WHEN_VALIDATE_ITEM(String ACC_FORCE_DEPT_YN_STRING
			, PM_IL_ACCRUAL_SETUP_ACTION pm_il_accrual_setup_action){
		try {
			if ("Y".equalsIgnoreCase(MigratingFunctions.nvl(
					ACC_FORCE_DEPT_YN_STRING, "N"))) {
				pm_il_accrual_setup_action.getCOMP_ACC_DEPT_CODE()
						.setRequired(false);
				pm_il_accrual_setup_action.getCOMP_ACC_DEPT_CODE()
						.setDisabled(true);
			}
			if ("N".equalsIgnoreCase(MigratingFunctions.nvl(
					ACC_FORCE_DEPT_YN_STRING, "N"))) {
				pm_il_accrual_setup_action.getCOMP_ACC_DEPT_CODE()
						.setDisabled(false);
				pm_il_accrual_setup_action.getCOMP_ACC_DEPT_CODE()
						.setRequired(true);
			}
			pm_il_accrual_setup_action.getCOMP_ACC_FORCE_DEPT_YN().setSubmittedValue(PM_IL_ACCRUAL_SETUP_BEAN.getACC_FORCE_DIVN_YN());
			//:PM_IL_PREM_ACCOUNT_SETUP.PAS_FORCE_DEPT_YN := :PM_IL_PREM_ACCOUNT_SETUP.PAS_FORCE_DIVN_YN;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	 public List<LovBean> lovACC_DIVN_FM_CODE(Object obj){
		 String code = (String) obj;
		 List<LovBean> suggestionList = null;
		 Object[] object={};
		 String query=null;
		 if("*".equals(code)){
			 object=new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(),PELConstants.suggetionRecordSize};
			 query ="SELECT  DIVN_CODE,DIVN_NAME FROM FM_DIVISION " +
			 		"WHERE DIVN_COMP_CODE = ? " +
			 		"AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS " +
			 		"(SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND " +
			 		"ADS_USER_ID = NVL('PREMIADMIN',ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') " +
			 		"AND ROWNUM < ? ORDER BY 1 ASC ";
		 }else{
			 object=new Object[]{code+"%",code+"%",PELConstants.suggetionRecordSize};
			 query ="SELECT  DIVN_CODE,DIVN_NAME FROM FM_DIVISION " +
		 		"WHERE DIVN_COMP_CODE = '001' " +
		 		"AND NVL(DIVN_FRZ_FLAG, 'N') = 'N' AND EXISTS " +
		 		"(SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE ADS_DIVN_CODE = DIVN_CODE AND " +
		 		"ADS_USER_ID = NVL('PREMIADMIN',ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') " +
		 		"AND (DIVN_CODE LIKE ? OR DIVN_NAME LIKE ?)AND ROWNUM < ? ORDER BY 1 ASC ";
		 }
		 suggestionList = prepareLovList(query, object);
		 return suggestionList;
	 }
	 
	
	public List<LovBean> lovACC_DEPT_FM_CODE(Object obj){
		 String code = (String) obj;
		 List<LovBean> suggestionList = null;
		 Object[] object={};
		 String query=null;
		 if("*".equals(code)){
			 object=new Object[]{CommonUtils.getControlBean().getM_COMP_CODE(),
					 PM_IL_ACCRUAL_SETUP_BEAN.getACC_DIVN_FM_CODE(),
					 PELConstants.suggetionRecordSize};
			 query ="SELECT DEPT_CODE,DEPT_NAME FROM FM_DEPARTMENT " +
			 		"WHERE DEPT_COMP_CODE = ? AND DEPT_DIVN_CODE = ? AND " +
			 		"DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE    " +
			 		"ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND  " +
			 		"ADS_USER_ID = NVL(NULL,ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') AND ROWNUM < ? ORDER BY 1 ASC";
		 }else{
			 object=new Object[]{code+"%",code+"%",PELConstants.suggetionRecordSize};
			 query ="SELECT DEPT_CODE,DEPT_NAME FROM FM_DEPARTMENT " +
		 		"WHERE DEPT_COMP_CODE = ? AND DEPT_DIVN_CODE = ? AND " +
		 		"DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE    " +
		 		"ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE AND  " +
		 		"ADS_USER_ID = NVL(NULL,ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') " +
		 		"AND (DEPT_CODE LIKE ? OR DEPT_NAME LIKE ?)AND ROWNUM < ? ORDER BY 1 ASC";
		 }
		 suggestionList = prepareLovList(query, object);
		 return suggestionList;
	 }


	public List lovACC_DEPT_FM_CODE_old(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String ACC_DIVN_FM_CODE = (String) getCOMP_ACC_DIVN_FM_CODE().getValue();
//		SELECT DEPT_CODE, DEPT_NAME FROM PM_DEPARTMENT 
//		WHERE 
//		DEPT_COMP_CODE = '001' AND 
//		DEPT_DIVN_CODE = '"+ACC_DIVN_FM_CODE+"' AND 
//		DEPT_FRZ_FLAG  = 'N' AND EXISTS 
//		(SELECT 1 FROM PM_APPR_DEPT_SETUP WHERE 
//		ADS_DIVN_CODE = DEPT_DIVN_CODE AND 
//		ADS_DEPT_CODE = DEPT_CODE AND 
//		ADS_USER_ID = NVL('LIFEALL',ADS_USER_ID) AND
//		ADS_FRZ_FLAG = 'N')

		String query = "";
		if(obj.toString().equals("*")){
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			query = " SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT " +
			"WHERE DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+ACC_DIVN_FM_CODE+"' " +
			"AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP " +
			"WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE " +
			"AND ADS_USER_ID = NVL('LIFEALL',ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') " +
			"AND  rownum < 25 ORDER BY 1 ASC";
		} else {
			//[BugId:TRACK_PREMIAGDC_GL.10.5-00168: modified PM_DEPARTMENT to FM_DEPARTMENT. Added by : Shankar.B 31-Mar-2009
			query = " SELECT DEPT_CODE, DEPT_NAME FROM FM_DEPARTMENT " +
			"WHERE DEPT_CODE LIKE '"+obj+"%' AND DEPT_COMP_CODE = '001' AND DEPT_DIVN_CODE = '"+ACC_DIVN_FM_CODE+"' " +
			"AND DEPT_FRZ_FLAG  = 'N' AND EXISTS (SELECT 1 FROM PM_APPR_DEPT_SETUP " +
			"WHERE ADS_DIVN_CODE = DEPT_DIVN_CODE AND ADS_DEPT_CODE = DEPT_CODE " +
			"AND ADS_USER_ID = NVL('LIFEALL',ADS_USER_ID) AND ADS_FRZ_FLAG = 'N') " +
			"AND  rownum < 25 ORDER BY 1 ASC";
		}

		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("DEPT_CODE"));
			bean.setName(rs.getString("DEPT_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}
	
	 public List<LovBean> lovACC_TYPE_FM_CODE(Object obj){
		 String code = (String) obj;
		 List<LovBean> suggestionList = null;
		 Object[] object={};
		 String query=null;
		 if("*".equals(code)){
			 object=new Object[]{PELConstants.suggetionRecordSize};
			 query = "SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
			 		"WHERE DS_TYPE = '2' OR DS_TYPE = '2'  " +
			 		"AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND ROWNUM < ? ";
		 }else{
			 object=new Object[]{code+"%",code+"%",PELConstants.suggetionRecordSize};
			 query = "SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
		 		"WHERE DS_TYPE = '2' OR DS_TYPE = '2'  " +
		 		"AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND (DS_CODE LIKE ? OR DS_DESC LIKE ?)" +
		 		"AND ROWNUM < ?";
		 }
		 suggestionList = prepareLovList(query, object);
		 return suggestionList;
	 }
	 
	 public List<LovBean> prepareLovList(String query, Object[] obj) {
			List<LovBean> suggestionList = new ArrayList<LovBean>();
			CRUDHandler handler = new CRUDHandler();
			ResultSet resultSet = null;
			try {
				Connection connection = CommonUtils.getConnection();
				resultSet = handler.executeSelectStatement(query, connection, obj);
				while (resultSet.next()) {
					LovBean bean = new LovBean();
					bean.setLovCode(resultSet.getString(1));
					bean.setLovName(resultSet.getString(2));
					suggestionList.add(bean);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}  finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return suggestionList;
		}

	public List lovACC_TYPE_FM_CODE_old(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();

		String ACC_ASSURED_TYPE = (String) getCOMP_ACC_ASSURED_TYPE().getValue();

//		SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP
//		WHERE DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N'


		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
			"WHERE DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = " SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
			"WHERE DS_CODE LIKE '"+obj+"%' AND DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND rownum < 25 ORDER BY 1 ASC";
		}

		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("DS_CODE"));
			bean.setName(rs.getString("DS_DESC"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}
	
	public List lovACC_TYPE_TO_CODE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		
		String ACC_ASSURED_TYPE = (String) getCOMP_ACC_ASSURED_TYPE().getValue();
		
//		SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP
//		WHERE DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N'
		
		
		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
			"WHERE DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = " SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
			"WHERE DS_CODE LIKE '"+obj+"%' AND DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND rownum < 25 ORDER BY 1 ASC";
		}
		
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("DS_CODE"));
			bean.setName(rs.getString("DS_DESC"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}



	public List lovACC_DOC_FM_TYPE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();

//		SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP
//		WHERE DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N'


		String query = "";
		if(obj.toString().equals("*")){
			query = " SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
			"WHERE DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = " SELECT DS_CODE,DS_DESC FROM PM_IL_DOC_SETUP " +
			"WHERE DS_CODE LIKE '"+obj+"%' AND DS_TYPE = '2' OR DS_TYPE = '2'  AND  NVL(DS_FRZ_FLAG ,'N') ='N' AND rownum < 25 ORDER BY 1 ASC";
		}

		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("DS_CODE"));
			bean.setName(rs.getString("DS_DESC"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List lovACC_PROD_CODE_FM(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();

//		SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE  PROD_CODE IS NOT NULL		

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE  PROD_CODE IS NOT NULL AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT PROD_CODE,PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE LIKE '"+obj+"%' AND PROD_CODE IS NOT NULL AND rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("PROD_CODE"));
			bean.setName(rs.getString("PROD_DESC"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List lovACC_COVER_CODE_FM(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();

//		SELECT COVER_CODE,COVER_DESC FROM PM_IL_COVER WHERE COVER_FRZ_FLAG='N'		

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT COVER_CODE,COVER_DESC FROM PM_IL_COVER WHERE COVER_FRZ_FLAG='N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT COVER_CODE,COVER_DESC FROM PM_IL_COVER WHERE COVER_CODE LIKE '"+obj+"%' AND COVER_FRZ_FLAG='N' AND rownum < 25 ORDER BY 1 ASC";


		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("COVER_CODE"));
			bean.setName(rs.getString("COVER_DESC"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List lovACC_MAIN_ACNT_CODE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();

//		SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE NVL(MAIN_FRZ_FLAG,'N') = 'N'		

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE NVL(MAIN_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT MAIN_ACNT_CODE,MAIN_ACNT_NAME FROM FM_MAIN_ACCOUNT WHERE MAIN_ACNT_CODE LIKE '"+obj+"%' AND NVL(MAIN_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("MAIN_ACNT_CODE"));
			bean.setName(rs.getString("MAIN_ACNT_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List lovACC_SUB_ACNT_CODE(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String ACC_MAIN_ACNT_CODE = (String) getCOMP_ACC_MAIN_ACNT_CODE().getValue();

//		SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT 
//		WHERE SUB_ACNT_CODE IN 
//		(SELECT MS_SUB_ACNT_CODE
//		FROM  FM_MAIN_SUB
//		WHERE MS_MAIN_ACNT_CODE = '') AND
//		NVL(SUB_FRZ_FLAG,'N') = 'N'"		

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT " +
			"WHERE SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE FROM FM_MAIN_SUB " +
			"WHERE MS_MAIN_ACNT_CODE = '"+ACC_MAIN_ACNT_CODE+"') AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT SUB_ACNT_CODE,SUB_ACNT_NAME FROM FM_SUB_ACCOUNT " +
			"WHERE SUB_ACNT_CODE LIKE '"+obj+"%' AND SUB_ACNT_CODE IN (SELECT MS_SUB_ACNT_CODE FROM FM_MAIN_SUB " +
			"WHERE MS_MAIN_ACNT_CODE = '"+ACC_MAIN_ACNT_CODE+"') AND NVL(SUB_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("SUB_ACNT_CODE"));
			bean.setName(rs.getString("SUB_ACNT_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}


	public List lovACC_ANLY_CODE_1(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String ACC_MAIN_ACNT_CODE = (String) getCOMP_ACC_MAIN_ACNT_CODE().getValue();

//		SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS 
//		WHERE ANLY_HEAD_NO = '1' AND
//		NVL(ANLY_FRZ_FLAG,'N') = 'N'

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '1' " +
			"AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC ";
		} else {
			query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_CODE='"+obj+"%' AND ANLY_HEAD_NO = '1' " +
			"AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("ANLY_CODE"));
			bean.setName(rs.getString("ANLY_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List lovACC_ANLY_CODE_2(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String ACC_MAIN_ACNT_CODE = (String) getCOMP_ACC_MAIN_ACNT_CODE().getValue();

//		SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS 
//		WHERE ANLY_HEAD_NO = '1' AND
//		NVL(ANLY_FRZ_FLAG,'N') = 'N'

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_HEAD_NO = '2' " +
			"AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT ANLY_CODE,ANLY_NAME FROM FM_ANALYSIS WHERE ANLY_CODE='"+obj+"%' AND ANLY_HEAD_NO = '2' " +
			"AND NVL(ANLY_FRZ_FLAG,'N') = 'N' AND rownum < 25 ORDER BY 1 ASC";
		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("ANLY_CODE"));
			bean.setName(rs.getString("ANLY_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	} 

	public List lovACC_ACTY_CODE_1(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String ACC_MAIN_ACNT_CODE = (String) getCOMP_ACC_MAIN_ACNT_CODE().getValue();

//		SELECT * FROM FM_ACTY_VALUE
//		AVAL_ACTY_CODE='&M_PARA_1'			

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_CODE = '"+obj+"%' AND  rownum < 25 ORDER BY 1 ASC";		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("AVAL_CODE"));
			bean.setName(rs.getString("AVAL_VALUE_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}

	public List lovACC_ACTY_CODE_2(Object obj)throws Exception {
		ArrayList suggesionList = new ArrayList();
		String ACC_MAIN_ACNT_CODE = (String) getCOMP_ACC_MAIN_ACNT_CODE().getValue();

//		SELECT * FROM FM_ACTY_VALUE
//		AVAL_ACTY_CODE='&M_PARA_1'			

		String query = "";
		if(obj.toString().equals("*")){
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE rownum < 25 ORDER BY 1 ASC";
		} else {
			query = "SELECT AVAL_CODE,AVAL_VALUE_NAME FROM FM_ACTY_VALUE WHERE AVAL_CODE = '"+obj+"%' AND  rownum < 25 ORDER BY 1 ASC";		}
		ResultSet rs = getHandler().executeSelectStatement(query,getConnection());
		rs.setFetchSize(25);
		while(rs.next()){
			LovBean bean = new LovBean();
			bean.setCode(rs.getString("AVAL_CODE"));
			bean.setName(rs.getString("AVAL_VALUE_NAME"));
			suggesionList.add(bean);
		}
		CommonUtils.closeCursor(rs);
		return suggesionList;
	}


	public void whenValidateACC_SRC_BUS_FM(ActionEvent event) {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.whenValidateACC_SRC_BUS_FM()...");
		P_SET_FIRST_FIELD(getCOMP_ACC_SRC_BUS_FM(),"ACC_SRC_BUS_FM",getCOMP_ACC_SRC_BUS_TO());
		getCOMP_ACC_SRC_BUS_TO().setSubmittedValue(getCOMP_ACC_SRC_BUS_TO().getSubmittedValue());
	}


	public void whenValidateACC_SRC_BUS_TO(ActionEvent event) {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.whenValidateACC_SRC_BUS_TO()...");

		P_SET_SECOND_FIELD(getCOMP_ACC_SRC_BUS_FM(),"ACC_SRC_BUS_FM",getCOMP_ACC_SRC_BUS_TO());
//		L_VAL_FROM_TO (:PM_IL_ACCRUAL_SETUP.ACC_SRC_BUS_FM, :PM_IL_ACCRUAL_SETUP.ACC_SRC_BUS_TO);
		L_VAL_FROM_TO(getCOMP_ACC_SRC_BUS_FM(),getCOMP_ACC_SRC_BUS_TO());
	}




	private void L_VAL_FROM_TO(HtmlInputText P_FROM_CODE, HtmlInputText P_TO_CODE) throws ValidatorException {
		try{
			if("".equals(P_FROM_CODE.getSubmittedValue())) {
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","80033"));
			} 

			if(Double.valueOf((String)P_TO_CODE.getSubmittedValue()) < Double.valueOf((String)P_FROM_CODE.getSubmittedValue()) ) {
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","80034"));
			} 

			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",(String)P_FROM_CODE.getSubmittedValue());
			OracleParameter param2 = new OracleParameter("in2","STRING","IN",(String) P_TO_CODE.getSubmittedValue());
			OracleParameter param3 = new OracleParameter("in3","STRING","OUT","OUTVALUE");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "PR_VALIDATE_FM_TO");
			int result = Integer.parseInt(list.get(0).getValue());
			if(result == 1) {
				throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","80034"));
			}
		}
		catch(Exception ex) {
//			throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages","80034"));
//			throw new ValidatorException(Messages.getMessage("messageProperties_PILM065_APAC","NUMBEREX"));
//			getErrorMap().put("current", "Please give the value as a NUMBER" );
//			ex.printStackTrace();
		}
	}

	public void whenValidateACC_BUS_FM_CODE(ActionEvent event) {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.whenValidateACC_BUS_FM_CODE()...");
		P_SET_FIRST_FIELD(getCOMP_ACC_BUS_FM_CODE(),"ACC_BUS_FM_CODE",getCOMP_ACC_BUS_TO_CODE());
		getCOMP_ACC_BUS_TO_CODE().setSubmittedValue(getCOMP_ACC_BUS_TO_CODE().getSubmittedValue());
	}

	public void whenValidateACC_BUS_TO_CODE(ActionEvent event) {

//		P_SET_SECOND_FIELD('PM_IL_ACCRUAL_SETUP.ACC_BUS_FM_CODE','PM_IL_ACCRUAL_SETUP.ACC_BUS_TO_CODE');
//		L_VAL_FROM_TO (:PM_IL_ACCRUAL_SETUP.ACC_BUS_FM_CODE,
//		:PM_IL_ACCRUAL_SETUP.ACC_BUS_TO_CODE);

		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.whenValidateACC_BUS_TO_CODE()...");
		P_SET_SECOND_FIELD(getCOMP_ACC_BUS_FM_CODE(),"ACC_BUS_FM_CODE",getCOMP_ACC_BUS_TO_CODE());
		L_VAL_FROM_TO(getCOMP_ACC_BUS_FM_CODE(),getCOMP_ACC_BUS_TO_CODE());

	}

	public void whenValidateACC_DIVN_TO_CODE(ActionEvent event) {
		getCOMP_ACC_DIVN_TO_CODE().setSubmittedValue(((UIInput)event.getComponent().getParent()).getValue());
		L_VAL_FROM_TO(getCOMP_ACC_DIVN_FM_CODE(), getCOMP_ACC_DIVN_TO_CODE());
		getCOMP_ACC_DIVN_TO_CODE().setSubmittedValue(getCOMP_ACC_DIVN_TO_CODE().getSubmittedValue());
		P_SET_SECOND_FIELD(getCOMP_ACC_DIVN_FM_CODE(),"ACC_DIVN_FM_CODE",getCOMP_ACC_DIVN_TO_CODE());
	}

	public void whenValidateACC_DEPT_FM_CODE(ActionEvent event) {
		getCOMP_ACC_DEPT_TO_CODE().setSubmittedValue(getCOMP_ACC_DEPT_TO_CODE().getSubmittedValue());
		P_SET_FIRST_FIELD(getCOMP_ACC_DEPT_FM_CODE(), "ACC_DEPT_FM_CODE", getCOMP_ACC_DEPT_TO_CODE());

	}

	public void whenValidateACC_DOC_FM_TYPE(ActionEvent event) {
			String currentValue = (String) COMP_ACC_DOC_FM_TYPE.getSubmittedValue();

			try {
				PM_IL_ACCRUAL_SETUP_BEAN.setACC_DOC_FM_TYPE((String) new CommonUtils()
						.SET_REP_FIRST_FIELD(currentValue, "String"));
				COMP_ACC_DOC_FM_TYPE.resetValue();
			} catch (Exception e) {
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("ACC_DOC_FM_TYPE", e.getMessage());
			}
	}

	public void whenValidateACC_DOC_TO_TYPE(ActionEvent event) {
		String currentValue = (String) COMP_ACC_DOC_TO_TYPE.getSubmittedValue();
		try {
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_DOC_TO_TYPE((String) new CommonUtils()
					.SET_REP_SECOND_FIELD(PM_IL_ACCRUAL_SETUP_BEAN.getACC_DOC_FM_TYPE(),
							currentValue, "String"));
			COMP_ACC_DOC_TO_TYPE.resetValue();
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("ACC_DOC_TO_TYPE", e.getMessage());
		}
	}

	public void whenValidateACC_DEPT_TO_CODE(ActionEvent e) {
		L_VAL_FROM_TO(getCOMP_ACC_DEPT_FM_CODE(), getCOMP_ACC_DEPT_TO_CODE());
		getCOMP_ACC_TYPE_TO_CODE().setSubmittedValue(getCOMP_ACC_TYPE_TO_CODE().getSubmittedValue());
		P_SET_SECOND_FIELD(getCOMP_ACC_DEPT_FM_CODE(), "ACC_DEPT_FM_CODE", getCOMP_ACC_DEPT_TO_CODE());
//		getCOMP_ACC_TYPE_TO_CODE().setSubmittedValue("1");
//		getCOMP_ACC_TYPE_TO_CODE().updateModel(FacesContext.getCurrentInstance());
	}

	public void whenValidateACC_DIVN_FM_CODE(ActionEvent event) {
		System.out
		.println("PM_IL_ACCRUAL_SETUP_ACTION.whenValidateACC_DIVN_FM_CODE()...");
		getCOMP_ACC_DIVN_FM_CODE().setSubmittedValue(((UIInput)event.getComponent().getParent()).getValue());
//		:PM_IL_ACCRUAL_SETUP.ACC_DIVN_TO_CODE := :PM_IL_ACCRUAL_SETUP.ACC_DIVN_TO_CODE;
//		:PM_IL_ACCRUAL_SETUP.ACC_TYPE_TO_CODE := :PM_IL_ACCRUAL_SETUP.ACC_TYPE_TO_CODE;
//		P_SET_FIRST_FIELD('PM_IL_ACCRUAL_SETUP.ACC_DIVN_FM_CODE','PM_IL_ACCRUAL_SETUP.ACC_DIVN_TO_CODE');
		getCOMP_ACC_DIVN_TO_CODE().setSubmittedValue(getCOMP_ACC_DIVN_TO_CODE().getSubmittedValue());
		getCOMP_ACC_TYPE_TO_CODE().setSubmittedValue(getCOMP_ACC_TYPE_TO_CODE().getSubmittedValue());
		P_SET_FIRST_FIELD(getCOMP_ACC_DIVN_FM_CODE(),"ACC_DIVN_FM_CODE",getCOMP_ACC_DIVN_TO_CODE());
	}


	private void P_SET_FIRST_FIELD(HtmlInputText fromComponent,String fromComponentId, HtmlInputText toComponent) {

		if(fromComponent == null ) {
			fromComponent.setSubmittedValue(fromComponent.getValue());
		}

		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.P_SET_FIRST_FIELD().... FromComponentId:  "+fromComponentId);
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "";

		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.P_SET_FIRST_FIELD() Component value: "+fromComponent.getSubmittedValue());
		if("".equals(fromComponent.getSubmittedValue()) || fromComponent.getSubmittedValue() == null ) {
			try {
				M_DATA_TYPE = PM_IL_ACCRUAL_SETUP_BEAN.getClass().getDeclaredField(fromComponentId).getType().getSimpleName();
				System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.P_SET_FIRST_FIELD().... M_DATA_TYPE: "+M_DATA_TYPE);				
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				e.printStackTrace();
			}

			if("String".equalsIgnoreCase(M_DATA_TYPE) || "Double".equalsIgnoreCase(M_DATA_TYPE)) {
				M_FIELD_DATA = "0" ;
			}

			fromComponent.setSubmittedValue(M_FIELD_DATA);
		}

		if("Date".equalsIgnoreCase(M_DATA_TYPE)) {
			toComponent.setSubmittedValue(toComponent.getSubmittedValue());
		}
	}

	public void P_SET_SECOND_FIELD(HtmlInputText fromComponent,String fromComponentId, HtmlInputText toComponent) {
		System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.P_SET_SECOND_FIELD().... ID: "+toComponent.getClientId(FacesContext.getCurrentInstance()));
		String fromCompValue = (String) fromComponent.getSubmittedValue();
		if(fromCompValue == null) {
			fromCompValue = (String) fromComponent.getValue();
		}
		String toCompValue = (String) toComponent.getSubmittedValue();
		int M_FIELD_LENGTH = 0;
		String M_FIELD_DATA = "";
		String M_DATA_TYPE = "";

		try {
			M_DATA_TYPE = PM_IL_ACCRUAL_SETUP_BEAN.getClass().getDeclaredField(fromComponentId).getType().getSimpleName();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		if("".equals(toCompValue) || toCompValue == null) {
//			M_FIELD_LENGTH = (Integer)getCOMP_UI_M_POL_NO_FROM().getAttributes().get("field-length");
			M_FIELD_LENGTH = 40;
			if("String".equalsIgnoreCase(M_DATA_TYPE) || "Double".equalsIgnoreCase(M_DATA_TYPE) ) {
				M_FIELD_DATA = "0";
			}

			System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.P_SET_SECOND_FIELD() fromCompValue: "+fromCompValue);

			if("String".equalsIgnoreCase(M_DATA_TYPE)) {
				System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.P_SET_SECOND_FIELD() fromCompValue: "+fromCompValue);
				System.out.println("PM_IL_ACCRUAL_SETUP_ACTION.P_SET_SECOND_FIELD() M_FIELD_DATA: "+M_FIELD_DATA);
				if(fromCompValue.equalsIgnoreCase(M_FIELD_DATA)) {
					M_FIELD_DATA = "zzzzzzzzzz";
					toComponent.setSubmittedValue(M_FIELD_DATA);
					toComponent.setValue(M_FIELD_DATA);
				} else 	if("String".equalsIgnoreCase(M_DATA_TYPE)) {
					toComponent.setSubmittedValue(fromCompValue);
				}
			} else if("double".equalsIgnoreCase(M_DATA_TYPE)) {
				if(Double.parseDouble(fromCompValue) == Double.parseDouble(M_FIELD_DATA)) {
					M_FIELD_DATA = "9999";
					toComponent.setSubmittedValue(M_FIELD_DATA);					
				} else {
					toComponent.setSubmittedValue(fromComponent.getSubmittedValue());
				}
			}
		} else {
			M_FIELD_DATA = (String) toComponent.getSubmittedValue();
			toComponent.setSubmittedValue(M_FIELD_DATA);
		}

		if("String".equalsIgnoreCase(M_DATA_TYPE)) {
			try{
				ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1","STRING","IN",(String)fromComponent.getSubmittedValue());
				OracleParameter param2 = new OracleParameter("in2","STRING","IN",(String)toComponent.getSubmittedValue());
				OracleParameter param3 = new OracleParameter("in3","STRING","OUT","OUTVALUE");
				paramList.add(param1);
				paramList.add(param2);
				paramList.add(param3);

				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				ArrayList<OracleParameter> list = procHandler.execute(paramList, getConnection(), "PR_VALIDATE_FM_TO");
				int result = Integer.parseInt(list.get(0).getValue());
				if(result == 1) {
					getErrorMap().put("current", "End Value cannot be less than Start Value");
//					throw new ValidatorException(Messages.getMessage("messageProperties_PILM011", "TODATE"));
				} 				
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	public Connection getConnection() throws Exception {
		Connection con = CommonUtils.getConnection();
		return con;
	}

	public CRUDHandler getHandler() {
		return new CRUDHandler();
	}
	public String getCurrentValue(ActionEvent event) {
		String value = null;
		UIInput input = null;
		if (event != null) {
			input = (UIInput) event.getComponent().getParent();
			if (input != null) {
				value = (String) input.getSubmittedValue();
			}
		}
		return value;
	}
	
	public List<LovBean> lovACC_SRC_BUS_FM_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_SRC_BUS_FM","SRC_BUS_TY",null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovACC_SRC_BUS_TO_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_SRC_BUS_TO","SRC_BUS_TY",null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_BUS_FM_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_BUS_FM_CODE","IL_BUSINES",null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_BUS_TO_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_BUS_TO_CODE","IL_BUSINES",null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_DIVN_FM_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DIVN_FM_CODE",CommonUtils.getControlBean().getM_COMP_CODE(),null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovACC_DIVN_TO_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DIVN_TO_CODE",CommonUtils.getControlBean().getM_COMP_CODE(),null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_DEPT_FM_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DEPT_FM_CODE",CommonUtils.getControlBean().getM_COMP_CODE(),
					PM_IL_ACCRUAL_SETUP_BEAN.getACC_DIVN_FM_CODE(), null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_DEPT_TO_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DEPT_TO_CODE",CommonUtils.getControlBean().getM_COMP_CODE(),
					PM_IL_ACCRUAL_SETUP_BEAN.getACC_DIVN_TO_CODE(), null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_DOC_FM_TYPE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DOC_FM_TYPE","2",
					null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_DOC_TO_TYPE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DOC_TO_TYPE","2",
					null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_PROD_CODE_FM_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_PROD_CODE_FM",null,
					null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_PROD_CODE_TO_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_PROD_CODE_TO",null,
					null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_COVER_CODE_FM_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_COVER_CODE_FM","A",
					"S", "B",
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_COVER_CODE_TO_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_COVER_CODE_TO","A",
					"S", "B",
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovACC_MAIN_ACNT_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_MAIN_ACNT_CODE",null,
					null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_SUB_ACNT_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_SUB_ACNT_CODE",PM_IL_ACCRUAL_SETUP_BEAN.getACC_MAIN_ACNT_CODE(),
					null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_DIVN_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DIVN_CODE",CommonUtils.getControlBean().getM_COMP_CODE(),
					null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_DEPT_CODE_1(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_DEPT_CODE",CommonUtils.getControlBean().getM_COMP_CODE(),
					PM_IL_ACCRUAL_SETUP_BEAN.getACC_DIVN_CODE(), null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	public List<LovBean> lovACC_ANLY_CODE(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_ANLY_CODE_1","1",
				    null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public List<LovBean> lovACC_ANLY_CODE_3(Object currValue) {
		ArrayList<LovBean> suggestionList = new ArrayList<LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM065_APAC",
					"PM_IL_ACCRUAL_SETUP", "ACC_ANLY_CODE_2","2",
				    null, null,
					null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	public String deleteAction(){
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_ACCRUAL_SETUP accrualBean = null;
		accrualBean = getPM_IL_ACCRUAL_SETUP_BEAN();
		
		try {
			if (accrualBean == null) {
				getErrorMap().put("key", "not to delete");
				getErrorMap().put("current", "not to delete");
			}else{
				String deleteMeaage = Messages.getString("messageProperties","errorPanel$message$delete");
				delete_pm_comm_hdr(accrualBean);
				commonUtils.doComitt();
				accrualBean = new PM_IL_ACCRUAL_SETUP();
				resetAllComponent();				
				getWarningMap().put("errorKey", deleteMeaage);
				getWarningMap().put("current", deleteMeaage);
				}
			accrualBean.setRowSelected(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void delete_pm_comm_hdr(PM_IL_ACCRUAL_SETUP accrualBean) throws DBException {
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			handler.executeDelete(accrualBean, connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		
	}
	
	public void listenerACC_MAIN_ACNT_CODE(ActionEvent event) {
		UIInput input = (UIInput) event.getComponent().getParent();
		String submittedValue = (String) ((HtmlInputText) input)
				.getSubmittedValue();

		if (submittedValue == null || submittedValue.trim().isEmpty()) {
			this.PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(null);
			COMP_UI_M_MAIN_ACNT_NAME.resetValue();
		} else {
			ErrorHelpUtil.validate(input, getErrorMap());
		}

	}

	public boolean isUpdate() {
		return update;
	}

	public void setUpdate(boolean update) {
		this.update = update;
	}
	

	/**
	 * Resets all components in PM_IL_ACCRUAL_SETUP_ACTION
	 */
	public void resetAllComponent(){
		// Reseting HtmlInputText
		COMP_ACC_SRC_BUS_FM.resetValue();
		COMP_ACC_SRC_BUS_TO.resetValue();
		COMP_ACC_BUS_FM_CODE.resetValue();
		COMP_ACC_BUS_TO_CODE.resetValue();
		COMP_ACC_DIVN_FM_CODE.resetValue();
		COMP_ACC_DIVN_TO_CODE.resetValue();
		COMP_ACC_DEPT_FM_CODE.resetValue();
		COMP_ACC_DEPT_TO_CODE.resetValue();
		COMP_ACC_DOC_FM_TYPE.resetValue();
		COMP_ACC_DOC_TO_TYPE.resetValue();
		COMP_ACC_PROD_CODE_FM.resetValue();
		COMP_ACC_PROD_CODE_TO.resetValue();
		COMP_ACC_COVER_CODE_FM.resetValue();
		COMP_ACC_COVER_CODE_TO.resetValue();
		COMP_ACC_TYPE_FM_CODE.resetValue();
		COMP_ACC_TYPE_TO_CODE.resetValue();
		COMP_ACC_YRS_FM.resetValue();
		COMP_ACC_YRS_TO.resetValue();
		COMP_ACC_MAIN_ACNT_CODE.resetValue();
		COMP_UI_M_MAIN_ACNT_NAME.resetValue();
		COMP_ACC_SUB_ACNT_CODE.resetValue();
		COMP_UI_M_SUB_ACNT_NAME.resetValue();
		COMP_ACC_DIVN_CODE.resetValue();
		COMP_UI_M_DIVN_NAME.resetValue();
		COMP_ACC_DEPT_CODE.resetValue();
		COMP_UI_M_DEPT_NAME.resetValue();
		COMP_ACC_ANLY_CODE_1.resetValue();
		COMP_UI_M_ANLY_NAME.resetValue();
		COMP_ACC_ANLY_CODE_2.resetValue();
		COMP_UI_M_ANLY_NAME_1.resetValue();
		COMP_ACC_ACTY_CODE_1.resetValue();
		COMP_UI_M_ACTY_NAME.resetValue();
		COMP_ACC_ACTY_CODE_2.resetValue();
		COMP_UI_M_ACTY_NAME_1.resetValue();

		// Reseting HtmlSelectOneMenu
		COMP_ACC_SETUP_TYPE.resetValue();
		COMP_ACC_DRCR_FLAG.resetValue();
		COMP_ACC_SETUP_FOR.resetValue();
		COMP_ACC_ASSURED_TYPE.resetValue();
		COMP_ACC_FORCE_DIVN_YN.resetValue();
		COMP_ACC_FORCE_DEPT_YN.resetValue();

	}

	public void postQuery(PM_IL_ACCRUAL_SETUP PM_IL_ACCRUAL_SETUP_BEAN) {

		DUMMY DUMMY_BEAN = null;
		ArrayList<String> list = new ArrayList<String>();
		try {

			list = new DBProcedures().P_VAL_MAIN_ACNT(PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_MAIN_ACNT_CODE(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_MAIN_ACNT_NAME(list.get(0));
				list.clear();
			}
			list = new DBProcedures().P_VAL_SUB_ACNT(PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_MAIN_ACNT_CODE(), PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_SUB_ACNT_CODE(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_SUB_ACNT_NAME(list.get(0));
				// :PM_IL_ACCRUAL_SETUP.M_SUB_ACNT_NAME,
				list.clear();
			}

			L_GET_ACTY_DETAILS();

			list = new DBProcedures().P_VAL_ANLY("1", PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_ANLY_CODE_1(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ANLY_NAME(list.get(0));
				list.clear();
			}
			list = new DBProcedures().P_VAL_ANLY("2", PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_ANLY_CODE_2(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ANLY_NAME_1(list.get(0));
				// :PM_IL_ACCRUAL_SETUP.M_ANLY_NAME_1,
				list.clear();
			}
			/*
			 * list=new DBProcedures().P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_1(),
			 * PM_IL_ACCRUAL_SETUP_BEAN.getACC_ACTY_CODE_1(),"N","N");
			 * if(list!=null &&!(list.isEmpty())){
			 * PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ACTY_NAME(list.get(0));
			 * list.clear(); } list=new
			 * DBProcedures().P_VAL_ACTY(DUMMY_BEAN.getUI_M_ACTY_2(),
			 * PM_IL_ACCRUAL_SETUP_BEAN.getACC_ACTY_CODE_2(),"N","N");
			 * if(list!=null &&!(list.isEmpty())){
			 * PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_ACTY_NAME_1(list.get(0));
			 * list.clear(); }
			 */
			list = new DBProcedures().callP_VAL_DIVN(PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_DIVN_CODE(), "N", "N");
			if (list != null && !(list.isEmpty())) {
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_DIVN_NAME(list.get(0));
				list.clear();
			}
			String deptName = new DBProcedures().P_VAL_DEPT(PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_DIVN_CODE(), PM_IL_ACCRUAL_SETUP_BEAN
					.getACC_DEPT_CODE(), "N", "N");

			if (deptName != null) {
				PM_IL_ACCRUAL_SETUP_BEAN.setUI_M_DEPT_NAME(deptName);
				}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void L_GET_ACTY_DETAILS() {
		String C1 = "SELECT MAIN_ACTY_CODE_1,MAIN_ACTY_CODE_2 FROM FM_MAIN_ACCOUNT"
				+ " WHERE  MAIN_ACNT_CODE  = ?";
		DUMMY DUMMY_BEAN = null;
		String M_ACTY_HEAD_1 = null;// FM_MAIN_ACCOUNT.MAIN_ACTY_CODE_1%TYPE;
		String M_ACTY_HEAD_2 = null; // FM_MAIN_ACCOUNT.MAIN_ACTY_CODE_2%TYPE;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet=null;
		Connection connection=null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection,
					new Object[] { PM_IL_ACCRUAL_SETUP_BEAN
							.getACC_MAIN_ACNT_CODE() });
			if (resultSet.next()) {

				M_ACTY_HEAD_1 = resultSet.getString(1);
				M_ACTY_HEAD_2 = resultSet.getString(2);
			}
			DUMMY_BEAN.setUI_M_ACTY_HEAD_1(M_ACTY_HEAD_1);
			DUMMY_BEAN.setUI_M_ACTY_HEAD_2(M_ACTY_HEAD_2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void validateACCS_MAIN_ACNT_CODE(FacesContext context,
			UIComponent component, Object value) throws ValidatorException {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_CODES_ACCOUNT_SETUP_ACTION accountSetupAction = (PM_IL_CODES_ACCOUNT_SETUP_ACTION) (commonUtils
				.getMappedBeanFromSession("PILM023_PM_IL_CODES_ACCOUNT_SETUP_ACTION"));
			PM_IL_ACCRUAL_SETUP_BEAN.setACC_MAIN_ACNT_CODE((String) value);
		try {

			String query = "SELECT 'X' FROM FM_MAIN_ACCOUNT WHERE MAIN_ACNT_CODE = ?";
			Boolean flag = null;
			flag = helper.isValidateLovCode(query, new Object[] { value });
			if (flag == false) {
				throw new Exception("Code does not Exists.Please Re-enter");
			}
			helper.validateCACS_MAIN_ACNT_CODE(this);
			/*COMP_UI_M_MAIN_ACNT_NAME.resetValue();
			//COMP_CACS_SUB_ACNT_CODE.resetValue();
			COMP_UI_M_SUB_ACNT_NAME.resetValue();
			COMP_CACS_ACTY_CODE_1.resetValue();
			COMP_UI_M_ACTY_NAME.resetValue();
			COMP_CACS_ACTY_CODE_2.resetValue();
			COMP_UI_M_ACTY_NAME_1.resetValue();*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	
}