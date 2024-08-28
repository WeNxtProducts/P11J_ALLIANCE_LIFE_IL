package com.iii.pel.forms.PILM203;

import java.lang.reflect.InvocationTargetException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ELResolver;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.UISelectBoolean;
import javax.faces.component.html.HtmlGraphicImage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_CVR_BNF_LINK_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_CBL_FRZ_FLAG_LABEL;

	private HtmlSelectBooleanCheckbox COMP_CBL_FRZ_FLAG;

	private HtmlOutputLabel COMP_CBL_BNF_CODE_LABEL;

	private HtmlInputText COMP_CBL_BNF_CODE;

	private HtmlOutputLabel COMP_UI_M_CBL_BNF_DESC_LABEL;

	private HtmlInputText COMP_UI_M_CBL_BNF_DESC;

	private HtmlOutputLabel COMP_CBL_LIMIT_TYP_LABEL;

	private HtmlSelectOneMenu COMP_CBL_LIMIT_TYP;

	private HtmlOutputLabel COMP_CBL_PER_DAY_LC_LIMIT_LABEL;

	private HtmlInputText COMP_CBL_PER_DAY_LC_LIMIT;

	private HtmlOutputLabel COMP_CBL_LIMIT_DAYS_LABEL;

	private HtmlInputText COMP_CBL_LIMIT_DAYS;

	private HtmlOutputLabel COMP_CBL_LIMIT_LC_AMT_LABEL;

	private HtmlInputText COMP_CBL_LIMIT_LC_AMT;

	private PM_IL_CVR_BNF_LINK PM_IL_CVR_BNF_LINK_BEAN;

	private HtmlGraphicImage COMP_MANDATORY_LIMIT_LC_AMT_LOGO;
	private HtmlGraphicImage COMP_MANDATORY_PER_DAY_LC_LIMIT_LOGO;
	private HtmlGraphicImage COMP_MANDATORY_LIMIT_DAYS_LOGO;
	
	private ControlBean ctrlbean ;
	
	private int currPage;
	
	private int lastUpdatedRowIndex;

	private int recordsPerPage = 5;
	private List benefitCodeList;
	
	private HtmlAjaxCommandButton UI_M_BUT_ADD;

	private HtmlAjaxCommandButton UI_M_BUT_DELETE;

	private HtmlAjaxCommandButton UI_M_BUT_POST;
	
	public PM_IL_COVER_ACTION coverAction;
// For Filter by
	
	private String filterByCBL_BNF_CODE;
	
	private String filterByCBL_LIMIT_TYP;
	
	private List<SelectItem> LIST_LIMIT_TYPE = new ArrayList<SelectItem>();
	
	private List<PM_IL_CVR_BNF_LINK> LIST_dataTable = new ArrayList<PM_IL_CVR_BNF_LINK>();
	
	private UISelectBoolean COMP_CHECKBOX;
	
	private UIDataTable LIST_COMP_DATATABLE;


	public UIDataTable getLIST_COMP_DATATABLE() {
		return LIST_COMP_DATATABLE;
	}

	public void setLIST_COMP_DATATABLE(UIDataTable list_comp_datatable) {
		LIST_COMP_DATATABLE = list_comp_datatable;
	}

	public UISelectBoolean getCOMP_CHECKBOX() {
		return COMP_CHECKBOX;
	}

	public void setCOMP_CHECKBOX(UISelectBoolean comp_checkbox) {
		COMP_CHECKBOX = comp_checkbox;
	}

	public List<PM_IL_CVR_BNF_LINK> getLIST_dataTable() {
		return LIST_dataTable;
	}

	public void setLIST_dataTable(List<PM_IL_CVR_BNF_LINK> table) {
		LIST_dataTable = table;
	}

	public PM_IL_CVR_BNF_LINK_ACTION() {
		PM_IL_CVR_BNF_LINK_BEAN = new PM_IL_CVR_BNF_LINK();
		prepareDropDowns();
	}

	public void prepareDropDowns(){
		try {
			Connection connection = CommonUtils.getConnection();
			setLIST_LIMIT_TYPE(ListItemUtil.getDropDownListValue_1(
					connection, "PILM203", "PM_IL_CVR_BNF_LINK",
					"PM_IL_CVR_BNF_LINK.CBL_LIMIT_TYP", null));

		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	

	public HtmlOutputLabel getCOMP_CBL_FRZ_FLAG_LABEL() {
		return COMP_CBL_FRZ_FLAG_LABEL;
	}

	public HtmlSelectBooleanCheckbox getCOMP_CBL_FRZ_FLAG() {
		return COMP_CBL_FRZ_FLAG;
	}

	public void setCOMP_CBL_FRZ_FLAG_LABEL(HtmlOutputLabel COMP_CBL_FRZ_FLAG_LABEL) {
		this.COMP_CBL_FRZ_FLAG_LABEL = COMP_CBL_FRZ_FLAG_LABEL;
	}

	public void setCOMP_CBL_FRZ_FLAG(HtmlSelectBooleanCheckbox COMP_CBL_FRZ_FLAG) {
		this.COMP_CBL_FRZ_FLAG = COMP_CBL_FRZ_FLAG;
	}

	public HtmlOutputLabel getCOMP_CBL_BNF_CODE_LABEL() {
		return COMP_CBL_BNF_CODE_LABEL;
	}

	public HtmlInputText getCOMP_CBL_BNF_CODE() {
		return COMP_CBL_BNF_CODE;
	}

	public void setCOMP_CBL_BNF_CODE_LABEL(HtmlOutputLabel COMP_CBL_BNF_CODE_LABEL) {
		this.COMP_CBL_BNF_CODE_LABEL = COMP_CBL_BNF_CODE_LABEL;
	}

	public void setCOMP_CBL_BNF_CODE(HtmlInputText COMP_CBL_BNF_CODE) {
		this.COMP_CBL_BNF_CODE = COMP_CBL_BNF_CODE;
	}

	public HtmlOutputLabel getCOMP_UI_M_CBL_BNF_DESC_LABEL() {
		return COMP_UI_M_CBL_BNF_DESC_LABEL;
	}

	public HtmlInputText getCOMP_UI_M_CBL_BNF_DESC() {
		return COMP_UI_M_CBL_BNF_DESC;
	}

	public void setCOMP_UI_M_CBL_BNF_DESC_LABEL(HtmlOutputLabel COMP_UI_M_CBL_BNF_DESC_LABEL) {
		this.COMP_UI_M_CBL_BNF_DESC_LABEL = COMP_UI_M_CBL_BNF_DESC_LABEL;
	}

	public void setCOMP_UI_M_CBL_BNF_DESC(HtmlInputText COMP_UI_M_CBL_BNF_DESC) {
		this.COMP_UI_M_CBL_BNF_DESC = COMP_UI_M_CBL_BNF_DESC;
	}

	public HtmlOutputLabel getCOMP_CBL_LIMIT_TYP_LABEL() {
		return COMP_CBL_LIMIT_TYP_LABEL;
	}

	public HtmlSelectOneMenu getCOMP_CBL_LIMIT_TYP() {
		return COMP_CBL_LIMIT_TYP;
	}

	public void setCOMP_CBL_LIMIT_TYP_LABEL(HtmlOutputLabel COMP_CBL_LIMIT_TYP_LABEL) {
		this.COMP_CBL_LIMIT_TYP_LABEL = COMP_CBL_LIMIT_TYP_LABEL;
	}

	public void setCOMP_CBL_LIMIT_TYP(HtmlSelectOneMenu COMP_CBL_LIMIT_TYP) {
		this.COMP_CBL_LIMIT_TYP = COMP_CBL_LIMIT_TYP;
	}

	public HtmlOutputLabel getCOMP_CBL_PER_DAY_LC_LIMIT_LABEL() {
		return COMP_CBL_PER_DAY_LC_LIMIT_LABEL;
	}

	public HtmlInputText getCOMP_CBL_PER_DAY_LC_LIMIT() {
		return COMP_CBL_PER_DAY_LC_LIMIT;
	}

	public void setCOMP_CBL_PER_DAY_LC_LIMIT_LABEL(HtmlOutputLabel COMP_CBL_PER_DAY_LC_LIMIT_LABEL) {
		this.COMP_CBL_PER_DAY_LC_LIMIT_LABEL = COMP_CBL_PER_DAY_LC_LIMIT_LABEL;
	}

	public void setCOMP_CBL_PER_DAY_LC_LIMIT(HtmlInputText COMP_CBL_PER_DAY_LC_LIMIT) {
		this.COMP_CBL_PER_DAY_LC_LIMIT = COMP_CBL_PER_DAY_LC_LIMIT;
	}

	public HtmlOutputLabel getCOMP_CBL_LIMIT_DAYS_LABEL() {
		return COMP_CBL_LIMIT_DAYS_LABEL;
	}

	public HtmlInputText getCOMP_CBL_LIMIT_DAYS() {
		return COMP_CBL_LIMIT_DAYS;
	}

	public void setCOMP_CBL_LIMIT_DAYS_LABEL(HtmlOutputLabel COMP_CBL_LIMIT_DAYS_LABEL) {
		this.COMP_CBL_LIMIT_DAYS_LABEL = COMP_CBL_LIMIT_DAYS_LABEL;
	}

	public void setCOMP_CBL_LIMIT_DAYS(HtmlInputText COMP_CBL_LIMIT_DAYS) {
		this.COMP_CBL_LIMIT_DAYS = COMP_CBL_LIMIT_DAYS;
	}

	public HtmlOutputLabel getCOMP_CBL_LIMIT_LC_AMT_LABEL() {
		return COMP_CBL_LIMIT_LC_AMT_LABEL;
	}

	public HtmlInputText getCOMP_CBL_LIMIT_LC_AMT() {
		return COMP_CBL_LIMIT_LC_AMT;
	}

	public void setCOMP_CBL_LIMIT_LC_AMT_LABEL(HtmlOutputLabel COMP_CBL_LIMIT_LC_AMT_LABEL) {
		this.COMP_CBL_LIMIT_LC_AMT_LABEL = COMP_CBL_LIMIT_LC_AMT_LABEL;
	}

	public void setCOMP_CBL_LIMIT_LC_AMT(HtmlInputText COMP_CBL_LIMIT_LC_AMT) {
		this.COMP_CBL_LIMIT_LC_AMT = COMP_CBL_LIMIT_LC_AMT;
	}

	public PM_IL_CVR_BNF_LINK getPM_IL_CVR_BNF_LINK_BEAN() {
		return PM_IL_CVR_BNF_LINK_BEAN;
	}

	public void setPM_IL_CVR_BNF_LINK_BEAN(PM_IL_CVR_BNF_LINK PM_IL_CVR_BNF_LINK_BEAN) {
		this.PM_IL_CVR_BNF_LINK_BEAN = PM_IL_CVR_BNF_LINK_BEAN;
	}

	public List getLIST_LIMIT_TYPE() {
		return LIST_LIMIT_TYPE;
	}

	public void setLIST_LIMIT_TYPE(List list_limit_type) {
		LIST_LIMIT_TYPE = list_limit_type;
	}

	public void postQuery(PM_IL_CVR_BNF_LINK pm_il_cvr_bnf_link) {
		String bnf_code = pm_il_cvr_bnf_link.getCBL_BNF_CODE();
		/*  P_VAL_CODES('IL_BNF_CODE',
	               :PM_IL_CVR_BNF_LINK.CBL_BNF_CODE,
	               :PM_IL_CVR_BNF_LINK.M_CBL_BNF_DESC,
	               'N',
	               'N',NULL);*/
		try{
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_CODES(?,?,?,?,?,?)}");
			cs.setString(1, "IL_BNF_CODE");
			cs.setString(2, bnf_code);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.setString(4, "N");
			cs.setString(5, "N");
			cs.setNull(6, java.sql.Types.NULL);
			boolean flag = cs.execute();
			String bnf_code_desc = cs.getString(3);
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.postQuery() desc "+bnf_code_desc);
			pm_il_cvr_bnf_link.setUI_M_CBL_BNF_DESC(bnf_code_desc);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*public List popLovForBN_CODE(Object event){
		List<PM_IL_CVR_BNF_LINK> lovList = new ArrayList<PM_IL_CVR_BNF_LINK>();
		String textEntered = event.toString();
		//String query = "select CBL_BNF_CODE from PM_IL_CVR_BNF_LINK ";
		String query="SELECT PC_CODE, PC_DESC	FROM PM_CODES WHERE PC_TYPE = 'IL_BNF_CODE'";
		String lovQuery = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		try{
			con = CommonUtils.getConnection();
			String where = null;
			if(textEntered.equalsIgnoreCase("*")) {
				lovQuery = query;
			}else {
				lovQuery = query + " AND PC_CODE = '"+textEntered+"'";
			}
			rs = handler.executeSelectStatement(lovQuery, con);
			while(rs.next()) {
				PM_IL_CVR_BNF_LINK bnf = new PM_IL_CVR_BNF_LINK();
				bnf.setCBL_BNF_CODE(rs.getString("PC_CODE"));
				lovList.add(bnf);
			}
			benefitCodeList  =lovList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return lovList;
	}
	
	*/
	
	public List<LovBean> popLovForBN_CODE(Object currValue) {
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM203",
					"PM_IL_CVR_BNF_LINK", "CBL_BNF_CODE",
					"IL_BNF_CODE",null, null,null, null, (String) currValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return suggestionList;
	}
	
	
	public void getBenefitCodeDesc(ActionEvent event)
	{
		CommonUtils.clearMaps(this);
		COMP_UI_M_CBL_BNF_DESC.setSubmittedValue(null);
		if(COMP_CBL_BNF_CODE.getSubmittedValue()!=null)
		{
		String benefitCode=(String)COMP_CBL_BNF_CODE.getSubmittedValue();
		String benefitdesc=getBenefitDesc(benefitCode,benefitCodeList);
		System.out.println("DESC:::::::::"+benefitdesc);
		COMP_UI_M_CBL_BNF_DESC.setSubmittedValue(benefitdesc);
		}
	}
	
	public String getBenefitDesc(String benefitCode, List benefitCodeList) {
		Iterator iterator = benefitCodeList.iterator();
		String benefitdesc = null;
		while (iterator.hasNext()) {
			PM_IL_CVR_BNF_LINK pm_il_cvr_bnf_link = (PM_IL_CVR_BNF_LINK) iterator.next();
			if (benefitCode.equalsIgnoreCase(pm_il_cvr_bnf_link.getCBL_BNF_CODE())) {
				benefitdesc = pm_il_cvr_bnf_link.getUI_M_CBL_BNF_DESC();
			}
		}
		return benefitdesc;
	}
	int currentRowIndex = 0;
	int prevrowIndex = 0;

	public void supportForBNF_CODE(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput)ae.getComponent().getParent();
		String bnf_code = (String) input.getSubmittedValue();
		
//		int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
//		PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;

		
		try{
			CallableStatement cs = CommonUtils.getConnection().prepareCall("{call P_VAL_CODES(?,?,?,?,?,?)}");
			cs.setString(1, "IL_BNF_CODE");
			cs.setString(2, bnf_code);
			cs.registerOutParameter(3, java.sql.Types.VARCHAR);
			cs.setString(4, "N");
			cs.setString(5, "N");
			cs.setNull(6, java.sql.Types.NULL);
			boolean flag = cs.execute();
			String bnf_code_desc = cs.getString(3);
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.supportForBNF_CODE() desc: "+bnf_code_desc);
			PM_IL_CVR_BNF_LINK_BEAN.setUI_M_CBL_BNF_DESC(bnf_code_desc);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	Object prevRowData = null;
	Object currRowData = null;
	
	public void prevRowIndex(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		UIDataTable dataTable = (UIDataTable) ae.getComponent().getParent().getParent().getParent();
		prevrowIndex = dataTable.getRowIndex();
		prevRowData = dataTable.getRowData();
		System.out.println("PM_IL_CVR_BNF_LINK_ACTION.prevRowIndex() prevRowIndex "+prevrowIndex);
		saveRowData();
	}
	
	public void currentRowIndex(ActionEvent ae) {
		CommonUtils.clearMaps(this);
		System.out.println("PM_IL_CVR_BNF_LINK_ACTION.currentRowIndex()");
	try{	
		UIInput input = (UIInput)ae.getComponent().getParent();
		UIDataTable dataTable = (UIDataTable)input.getParent().getParent();
		currentRowIndex = dataTable.getRowIndex();
		currRowData = dataTable.getRowData();
		
		setPM_IL_CVR_BNF_LINK_BEAN((PM_IL_CVR_BNF_LINK) currRowData);
		
		System.out.println(input.getClass().getSimpleName()+" "+input.getParent().getClass().getSimpleName()
				+" "+input.getParent().getParent().getClass().getSimpleName()+"  "
				+input.getParent().getParent().getParent().getClass().getSimpleName());
		System.out.println(getLIST_COMP_DATATABLE().getRowIndex()+" "+getLIST_COMP_DATATABLE().getRows()
				+"  "+getLIST_COMP_DATATABLE().getRowCount());
		
		String clientId =  dataTable.getClientId(FacesContext.getCurrentInstance());
		
		System.out.println("clientId "+clientId);
		
		if(currentRowIndex == prevrowIndex) {
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.currentRowIndex() same row");
		}else if(currentRowIndex > prevrowIndex){
			System.out.println("current row greater");
			saveRowData();
		}else if((currentRowIndex == prevrowIndex) && (currentRowIndex == (dataTable.getRowCount() - 1))) {
			System.out.println("last row");
			UIComponent comp  = dataTable.findComponent("#{PILM203_PM_IL_CVR_BNF_LINK_ACTION.COMP_CBL_LIMIT_LC_AMT}");
			FacesContext context = FacesContext.getCurrentInstance();
			
			if(ae.getComponent().getClientId(context).equals(comp.getClientId(context))) {
				System.out.println("same comp ");
				saveLastRowData();
			} 
		}

	}catch(Exception e) {
		e.printStackTrace();
	}
	
	
}
	
	public void whenClickCheckBox(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput checkBox = (UIInput) event.getComponent().getParent();
		String checkBoxValue = (String) checkBox.getSubmittedValue();
		int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;

		if("true".equals(checkBoxValue)) {
			gridValueBean.setCheckBoxFirst(true);
		} else {
			gridValueBean.setCheckBoxFirst(false);
		}
	}

	
	public void saveRowData() {
		System.out.println("PM_IL_CVR_BNF_LINK_ACTION.saveRowData() saving data for rowIndex "+getLIST_COMP_DATATABLE().getRowIndex());
		Object rowData = getLIST_COMP_DATATABLE().getRowData();
//		PM_IL_CVR_BNF_LINK valueBean = (PM_IL_CVR_BNF_LINK) rowData;
		
		if(prevRowData != null) {
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.saveRowData() prev rowdata not null ");
		}else {
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.saveRowData() prevRowData null");
		}
			PM_IL_CVR_BNF_LINK valueBean = (PM_IL_CVR_BNF_LINK) prevRowData;
		
		preInsert(valueBean);
		whenNewBlockInstance(valueBean);
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
			try {
				con.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (DBException e) {
			e.printStackTrace();
		}
		try{
			int i = handler.executeInsert(valueBean, con);
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.saveRowData() rowindex saved "+prevrowIndex);
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void saveLastRowData() {
		System.out.println("PM_IL_CVR_BNF_LINK_ACTION.saveLastRowData()");
		Object rowData = getLIST_COMP_DATATABLE().getRowData();
		PM_IL_CVR_BNF_LINK valueBean = (PM_IL_CVR_BNF_LINK) rowData;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		try{
			int i = handler.executeInsert(valueBean, con);
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.saveRowData() rowindex saved "+i);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void preInsert(PM_IL_CVR_BNF_LINK valueBean) {
		
//		:PM_IL_CVR_BNF_LINK.CBL_UPD_DT  := SYSDATE;
//		:PM_IL_CVR_BNF_LINK.CBL_UPD_UID := :CTRL.M_USER_ID;
		
		whenCreateRecord(valueBean);
		
		valueBean.setCBL_CR_DT(new java.util.Date());
		valueBean.setCBL_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		
	}
	public void preUpdate() {
//	  same as preInsert 
	}

	private void whenNewBlockInstance(PM_IL_CVR_BNF_LINK valueBean) {
		if(valueBean.getCBL_LIMIT_TYP().equalsIgnoreCase("D")) {
//			getCOMP_MANDATORY_PER_DAY_LC_LIMIT_LOGO().setRendered(true);
//			getCOMP_CBL_PER_DAY_LC_LIMIT().setRequired(true);
//			getCOMP_CBL_LIMIT_DAYS().setRequired(true);
			
			getCOMP_CBL_LIMIT_LC_AMT().setDisabled(true);
			getCOMP_MANDATORY_LIMIT_LC_AMT_LOGO().setRendered(false);
			
		}else {
			getCOMP_CBL_LIMIT_DAYS().setDisabled(true);
			getCOMP_CBL_PER_DAY_LC_LIMIT().setDisabled(true);
			
			getCOMP_MANDATORY_LIMIT_DAYS_LOGO().setRendered(false);
			getCOMP_MANDATORY_PER_DAY_LC_LIMIT_LOGO().setRendered(false);
			
//			getCOMP_CBL_LIMIT_LC_AMT().setRequired(true);
		}
	}
	
	public void whenValidateBNF_CODE(FacesContext context, UIComponent comp , Object value) {
		if(value!=null)
		{
		/*	int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		 	PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;
			gridValueBean.setCBL_BNF_CODE(value.toString());
			//gridtabListener(); */
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_BNF_CODE(value.toString());
		}
	}
	
	public void validatevaluChangeLIMIT_TYP(ActionEvent event) {
		CommonUtils.clearMaps(this);
		//int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		UIInput component = (UIInput) event.getComponent().getParent();
		String BSBL_LIMIT_TYP = (String) component.getSubmittedValue();
		/*if(currRowIndex>=0)
		{
		PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;
		gridValueBean.setCBL_LIMIT_TYP(BSBL_LIMIT_TYP);
		}*/
		PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_TYP(BSBL_LIMIT_TYP);
		
		ErrorHelpUtil.validate(component, getErrorMap());
	}
	
	public void getDetails() {
		try {
			if ( LIST_dataTable.size() != 0) {				
				 this.PM_IL_CVR_BNF_LINK_BEAN = (PM_IL_CVR_BNF_LINK) LIST_COMP_DATATABLE.getRowData();
			}
				String LIMIT_TYPE = PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_TYP();
				System.out.println("LIMIT TYPE:::::"+LIMIT_TYPE);
				if(LIMIT_TYPE.equals("F")){
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS_DISABLE(true);
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT_DISABLE(true);
				}else{
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_DISABLE(true);
				}
				postQuery(PM_IL_CVR_BNF_LINK_BEAN);
	 
			resetAllComponent();			
			resetSelectedRow();
			this.PM_IL_CVR_BNF_LINK_BEAN.setRowSelected(true);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void resetAllComponent(){
		// Reseting HtmlInputText
			COMP_CBL_BNF_CODE.resetValue();
			COMP_CBL_LIMIT_DAYS.resetValue();
			COMP_CBL_LIMIT_LC_AMT.resetValue();
			COMP_CBL_LIMIT_TYP.resetValue();
			COMP_UI_M_CBL_BNF_DESC.resetValue();
			COMP_CBL_FRZ_FLAG.resetValue();
	}
	
	// Added to apply row selection
	private void resetSelectedRow() {
		Iterator<PM_IL_CVR_BNF_LINK>  iterator = LIST_dataTable.iterator();
		while(iterator.hasNext()){
			iterator.next().setRowSelected(false);
		}
	}
	
	public void valuChangeLIMIT_TYP(ActionEvent event) {
		CommonUtils.clearMaps(this);
		boolean updateAllowed = false;
		UIInput component = (UIInput) event.getComponent().getParent();
		String CBL_LIMIT_TYP = (String) component.getSubmittedValue();
	
		/*int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;
		*/
		PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_TYP(CBL_LIMIT_TYP);

		PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_TYP(CBL_LIMIT_TYP);

		if(!"".equals(PM_IL_CVR_BNF_LINK_BEAN.getROWID()) && PM_IL_CVR_BNF_LINK_BEAN.getROWID() != null ) {
			updateAllowed = true;
		}
		System.out.println("TYPE::::::::"+PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_TYP());
		if("D".equalsIgnoreCase(PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_TYP())) {
			
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT_DISABLE(false);
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS_DISABLE(false);

			if(updateAllowed) {
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT_DISABLE(false);
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS_DISABLE(false);
			}
			
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT_REQUIRED(true);
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS_REQUIRED(true);
			
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_DISABLE(true);
			
			if(updateAllowed) {
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_DISABLE(true);
			}
			
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_REQUIRED(false);

		} else {
			
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT_DISABLE(true);
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS_DISABLE(true);
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT(null);
			getCOMP_CBL_PER_DAY_LC_LIMIT().setSubmittedValue(null);
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS(null);
			getCOMP_CBL_LIMIT_DAYS().setSubmittedValue(null);
			
			if(updateAllowed) {
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT_DISABLE(true);
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS_DISABLE(true);
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT(null);
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS(null);
			}
			
			/*gridValueBean.setCBL_PER_DAY_LC_LIMIT_REQUIRED(false);
			gridValueBean.setCBL_LIMIT_DAYS_REQUIRED(false);*/
			
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_DISABLE(false);
			if(updateAllowed) {
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_DISABLE(false);
			}
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_REQUIRED(true);
		}
		
	}
	
	public void validatewhenValidateLIMIT_LC_AMT(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void whenValidateLIMIT_LC_AMT(FacesContext context, UIComponent comp , Object value)throws ValidatorException{

		CRUDHandler handle = new CRUDHandler();
		ResultSet rs = null;
		/*int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;*/
		
		String selectQuery = null;
		Map sessionMap = context.getExternalContext().getSessionMap();
		PM_IL_COVER_ACTION coverAction = (PM_IL_COVER_ACTION)sessionMap.get("PILM203_PM_IL_COVER_ACTION");
		if(value!=null)
		{
			selectQuery = "SELECT COUNT(1) FROM PM_IL_CVR_SBNF_LINK WHERE  " +
			"BSBL_COVER_CODE = '"+PM_IL_CVR_BNF_LINK_BEAN.getCBL_COVER_CODE()+"' " +
			"AND BSBL_BNF_CODE = '"+PM_IL_CVR_BNF_LINK_BEAN.getCBL_BNF_CODE()+"' " +
			"AND BSBL_LIMIT_LC_AMT > "+(Double)value+"";
			if((Double)value!= -1 && coverAction.getPM_IL_COVER_BEAN().getCOVER_LC_LIMIT() != null){
			{
				if((Double)value > coverAction.getPM_IL_COVER_BEAN().getCOVER_LC_LIMIT() || (Double)value < 0 ) {
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT(coverAction.getPM_IL_COVER_BEAN().getCOVER_LC_LIMIT());
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS(coverAction.getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS());
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT(coverAction.getPM_IL_COVER_BEAN().getCOVER_PER_DAY_LC_AMT());
					
					FacesMessage error = Messages.getMessage(PELConstants.pelErrorMessagePath, "92012");
					throw new ValidatorException(error);
				}/*else{
					lastColumnOperation();
				}*/
				}
			}
			try {
				rs = handle.executeSelectStatement(selectQuery, CommonUtils.getConnection());
				if(rs.next()) {
					if(rs.getInt(1) > 0) {
						FacesMessage error = Messages.getMessage(PELConstants.pelErrorMessagePath, "92020");
						throw new ValidatorException(error);
					}else{
						//lastColumnOperation();
					}
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (DBException e) {
				e.printStackTrace();
			}finally{
				try {
					CommonUtils.closeCursor(rs);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void validatewhenValidateLIMIT_DAYS(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void whenValidateLIMIT_DAYS(FacesContext context, UIComponent comp , Object value){
	/*	int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;*/
		PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS((Double)value);

		Map sessionMap = context.getExternalContext().getSessionMap();
		PM_IL_COVER_ACTION coverAction = (PM_IL_COVER_ACTION)sessionMap.get("PILM203_PM_IL_COVER_ACTION");

		if("D".equalsIgnoreCase(coverAction.getPM_IL_COVER_BEAN().getCOVER_LIMIT_TYPE()))
		{
			if (coverAction.getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS() != null) {
				if (PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_DAYS() < 0
						|| PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_DAYS() > coverAction
								.getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS()) {
					FacesMessage error = Messages.getMessage(PELConstants.pelErrorMessagePath, "91997");
					throw new ValidatorException(error);
				}else{
					if(getErrorMap().isEmpty())
					{
						//lastColumnOperation();
					}
				}
			}
		}
		
		if("D".equalsIgnoreCase(PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_TYP())) {
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT(PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_DAYS()
					* PM_IL_CVR_BNF_LINK_BEAN.getCBL_PER_DAY_LC_LIMIT());
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT_DISABLE(true);
			if((PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_DAYS()
					* PM_IL_CVR_BNF_LINK_BEAN.getCBL_PER_DAY_LC_LIMIT()) > coverAction.getPM_IL_COVER_BEAN().getCOVER_LC_LIMIT())
			{
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92012"));
			}
		}
		PM_IL_CVR_BNF_LINK_BEAN.setCBL_BNF_CODE(PM_IL_CVR_BNF_LINK_BEAN.getCBL_BNF_CODE());
		
		
	}
	
	public void validatewhenValidatePER_DAY_LC_LIMIT(ActionEvent event)throws ValidatorException {
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) event.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void whenValidatePER_DAY_LC_LIMIT(FacesContext context, UIComponent comp , Object value) throws ValidatorException{
	
		/*int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		PM_IL_CVR_BNF_LINK gridValueBean = LIST_dataTable.get(currRowIndex) ;*/
		
		Double doubleCBL_PER_DAY_LC_LIMIT = (Double)value;
		
		Double doubleCBL_LIMIT_DAYS = PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_DAYS() == null?0.0:PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_DAYS();  
		PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_DAYS(doubleCBL_LIMIT_DAYS);
		
		PM_IL_CVR_BNF_LINK_BEAN.setCBL_PER_DAY_LC_LIMIT(doubleCBL_PER_DAY_LC_LIMIT);
		//try{
			Map sessionMap = context.getExternalContext().getSessionMap();
			PM_IL_COVER_ACTION coverAction = (PM_IL_COVER_ACTION)sessionMap.get("PILM203_PM_IL_COVER_ACTION");
			if("D".equalsIgnoreCase(coverAction.getPM_IL_COVER_BEAN().getCOVER_LIMIT_TYPE()))
			{
				if (coverAction.getPM_IL_COVER_BEAN().getCOVER_PER_DAY_LC_AMT() != null) {
					if ((doubleCBL_PER_DAY_LC_LIMIT < 0)
							|| doubleCBL_PER_DAY_LC_LIMIT > coverAction
									.getPM_IL_COVER_BEAN()
									.getCOVER_PER_DAY_LC_AMT()) {
	
						FacesMessage error = Messages.getMessage(PELConstants.pelErrorMessagePath, "92012");
						throw new ValidatorException(error);
	
					}else{
						//gridtabListener();
					}
				}
			}
			
			if("D".equalsIgnoreCase(PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_TYP())) {
				Double days = PM_IL_CVR_BNF_LINK_BEAN.getCBL_LIMIT_DAYS();
				Double lc_limit = PM_IL_CVR_BNF_LINK_BEAN.getCBL_PER_DAY_LC_LIMIT();
				Double lc_amt = days * lc_limit;
				PM_IL_CVR_BNF_LINK_BEAN.setCBL_LIMIT_LC_AMT(lc_amt);
				
				if(lc_amt > coverAction.getPM_IL_COVER_BEAN().getCOVER_LC_LIMIT())
				{
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "92012"));
				}
			}
			 
		/*}catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}*/
	}
	
	private void whenCreateRecord(PM_IL_CVR_BNF_LINK valueBean) {
		FacesContext context = FacesContext.getCurrentInstance();
		Map sessionMap = context.getExternalContext().getSessionMap();
		PM_IL_COVER_ACTION coverAction = (PM_IL_COVER_ACTION)sessionMap.get("PILM203_PM_IL_COVER_ACTION");
		
		valueBean.setCBL_COVER_CODE(coverAction.getPM_IL_COVER_BEAN().getCOVER_CODE());
		
		
		//if(getPM_IL_CVR_BNF_LINK_BEAN().getCBL_FRZ_FLAG().equalsIgnoreCase("N")) {
			valueBean.setCBL_LIMIT_TYP(coverAction.getPM_IL_COVER_BEAN().getCOVER_LIMIT_TYPE());
			valueBean.setCBL_PER_DAY_LC_LIMIT(coverAction.getPM_IL_COVER_BEAN().getCOVER_PER_DAY_LC_AMT());
			valueBean.setCBL_LIMIT_DAYS(coverAction.getPM_IL_COVER_BEAN().getCOVER_LIMIT_DAYS());
			valueBean.setCBL_LIMIT_LC_AMT(coverAction.getPM_IL_COVER_BEAN().getCOVER_LC_LIMIT());
			valueBean.setBOOLEAN_CBL_FRZ_FLAG(false);
		//}
		
	}
	
	
	public void whenValidateCBL_FRZ_FLAG(ActionEvent event) {
		CommonUtils.clearMaps(this);
		UIInput component = (UIInput) event.getComponent().getParent();
		String CBL_FRZ_FLAG = (String) component.getSubmittedValue();
		//PM_IL_CVR_BNF_LINK bean = (PM_IL_CVR_BNF_LINK) getLIST_COMP_DATATABLE().getRowData();
		if("true".equals(CBL_FRZ_FLAG)) {
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_FRZ_FLAG("Y");
		} else {
			PM_IL_CVR_BNF_LINK_BEAN.setCBL_FRZ_FLAG("N");
		}
	}
	
	private void preDelete(PM_IL_CVR_BNF_LINK rowObject) {
		
		String q1 = "DELETE FROM PM_IL_BNF_DEDB_LINK P " +
				"WHERE P.BDL_COVER_CODE = "+ rowObject.getCBL_COVER_CODE()+" and " +
						"P.BDL_BNF_CODE = "+rowObject.getCBL_BNF_CODE();
		
		String q2 = "DELETE FROM PM_IL_BNF_AGE_SETUP P where " +
				"P.BAS_COVER_CODE = " +rowObject.getCBL_COVER_CODE()+" " +
						" and P.BAS_BNF_CODE = "+rowObject.getCBL_BNF_CODE();
		
		String q3 = " DELETE FROM PM_IL_CVR_SBNF_LINK P " +
				" WHERE P.BSBL_COVER_CODE = "+rowObject.getCBL_COVER_CODE()+" and " +
						"P.BSBL_BNF_CODE = "+rowObject.getCBL_BNF_CODE() ;
		
		Connection con = null;
		
		try {
			con =CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		
		CRUDHandler handler = new CRUDHandler();
		try{
			int i1 = handler.executeDeleteStatement(q1, con);
			int i2 = handler.executeDeleteStatement(q2, con);
			int i3 = handler.executeDeleteStatement(q3, con);
			con.commit();
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.preDelete() success");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private void postInsert() {
		
		String flag = null;
		Connection con = null;
		
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		try{
			CallableStatement cs = con.prepareCall("{call  P9ILPK_FMB_PILM203.DEFAULT_SUB_BENEFITS(?,?)}");
			cs.setString(1, getPM_IL_CVR_BNF_LINK_BEAN().getCBL_BNF_CODE());
			cs.registerOutParameter(2, java.sql.Types.VARCHAR);
			cs.execute();
			flag = cs.getString(2);
			System.out.println("PM_IL_CVR_BNF_LINK_ACTION.postInsert() flag "+flag);
			
			
			
			if(flag.equals("Y")) {
				
				String query= " INSERT INTO PM_IL_CVR_SBNF_LINK (BSBL_COVER_CODE, BSBL_BNF_CODE," +  
				" BSBL_SBNF_CODE, BSBL_LIMIT_TYP," + 
				" BSBL_PER_DAY_LC_LIMIT, BSBL_LIMIT_DAYS, " + 
				" BSBL_LIMIT_LC_AMT, BSBL_FRZ_FLAG, " + 
				" BSBL_CR_DT, BSBL_CR_UID) " +
				" VALUES('"+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_COVER_CODE()+"', '"+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_BNF_CODE()+"'," + 
				" '"+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_BNF_CODE()+"','"+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_LIMIT_TYP()+"'," + 
				" "+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_PER_DAY_LC_LIMIT()+", "+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_LIMIT_DAYS()+", "+ 
				" "+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_LIMIT_LC_AMT()+", '"+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_FRZ_FLAG()+"', " + 
				" sysdate, '"+getPM_IL_CVR_BNF_LINK_BEAN().getCBL_CR_UID()+"') "; 
				
				CRUDHandler handler = new CRUDHandler();
				int i =handler.executeInsertStatement(query, con);
				System.out.println("PM_IL_CVR_BNF_LINK_ACTION.postInsert() i "+i); 
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ControlBean getCtrlbean() {
		return ctrlbean;
	}

	public void setCtrlbean(ControlBean ctrlbean) {
		this.ctrlbean = ctrlbean;
	}

	public HtmlGraphicImage getCOMP_MANDATORY_LIMIT_LC_AMT_LOGO() {
		return COMP_MANDATORY_LIMIT_LC_AMT_LOGO;
	}

	public void setCOMP_MANDATORY_LIMIT_LC_AMT_LOGO(
			HtmlGraphicImage comp_mandatory_limit_lc_amt_logo) {
		COMP_MANDATORY_LIMIT_LC_AMT_LOGO = comp_mandatory_limit_lc_amt_logo;
	}

	public HtmlGraphicImage getCOMP_MANDATORY_PER_DAY_LC_LIMIT_LOGO() {
		return COMP_MANDATORY_PER_DAY_LC_LIMIT_LOGO;
	}

	public void setCOMP_MANDATORY_PER_DAY_LC_LIMIT_LOGO(
			HtmlGraphicImage comp_mandatory_per_day_lc_limit_logo) {
		COMP_MANDATORY_PER_DAY_LC_LIMIT_LOGO = comp_mandatory_per_day_lc_limit_logo;
	}

	public HtmlGraphicImage getCOMP_MANDATORY_LIMIT_DAYS_LOGO() {
		return COMP_MANDATORY_LIMIT_DAYS_LOGO;
	}

	public void setCOMP_MANDATORY_LIMIT_DAYS_LOGO(
			HtmlGraphicImage comp_mandatory_limit_days_logo) {
		COMP_MANDATORY_LIMIT_DAYS_LOGO = comp_mandatory_limit_days_logo;
	}
		
	public void save() {
		CommonUtils commonUtils = new CommonUtils();
		try {
			commonUtils.doComitt();
			getWarningMap().put("current", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$save"));
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("detail", e.getMessage());
		}
	}
	
	public String saveNext() {
		save();
		//nextBlock_PM_IL_CVR_SBNF_LINK();
		return "nextpage";
	}
	
	public void delete() {
		
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (DBException e) {
			e.printStackTrace();
		}
		CRUDHandler handler = new CRUDHandler();
		try{
			Iterator<PM_IL_CVR_BNF_LINK> itr =  getLIST_dataTable().iterator();
			while(itr.hasNext()) {
				PM_IL_CVR_BNF_LINK rowObject = itr.next();
				boolean checkBox = rowObject.isCheckBoxFirst();
				System.out.println("PM_IL_CVR_BNF_LINK_ACTION.delete() checkbox "+checkBox);
				if(checkBox == true) {
					preDelete(rowObject);
					int  i = handler.executeDelete(rowObject, con);
					getLIST_dataTable().remove(rowObject);
					System.out.println("PM_IL_CVR_BNF_LINK_ACTION.delete() rowRemoved " +i);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String next() {
		
		//nextBlock_PM_IL_CVR_SBNF_LINK();
		return "nextpage";
	}
	public String last() {
		return "lastpage";
	}
	public String prevPage() {
		return "prevpage";
	}
	
	private PM_IL_CVR_BNF_LINK_ACTION getPM_IL_CVR_BNF_LINK_ACTION() {
		return (PM_IL_CVR_BNF_LINK_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM203_PM_IL_CVR_BNF_LINK_ACTION");
	} 
	
	private PM_IL_COVER_ACTION getPM_IL_COVER_ACTION() {
		return (PM_IL_COVER_ACTION) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("PILM203_PM_IL_COVER_ACTION");
	}
	
	public void nextBlock_PM_IL_CVR_SBNF_LINK(String code) {
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_CVR_SBNF_LINK_ACTION sbnfLinkAction = (PM_IL_CVR_SBNF_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_CVR_SBNF_LINK_ACTION");
		
		
		
		String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
		
		String queryForBnfLink = "select ROWID,PM_IL_CVR_SBNF_LINK.* from PM_IL_CVR_SBNF_LINK where BSBL_COVER_CODE = '"+cover_code+"' and " +
				"BSBL_BNF_CODE='"+code+"'";
		System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_SBNF_LINK() query "+queryForBnfLink);
	
//	 POPULATING COMBO BOX	
		
		try{
//			List<SelectItem> list =  ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), "PILM203", "PM_IL_CVR_BNF_LINK", "PM_IL_CVR_BNF_LINK.CBL_LIMIT_TYP", "CVRLMTTYP");
//			bnfLinkAction.setLIST_LIMIT_TYPE(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		 
//  COMBOBOX DONE		
		
		CRUDHandler handler = new CRUDHandler();
		try {
			List<PM_IL_CVR_SBNF_LINK> list = handler.fetch(queryForBnfLink, "com.iii.pel.forms.PILM203.PM_IL_CVR_SBNF_LINK", CommonUtils.getConnection());
			System.out
					.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_BNF_LINK() list size "+list.size());
			
			if(list != null && list.size() > 0) {
				
				sbnfLinkAction.getListdataTablePM_IL_CVR_SBNF_LINK().clear();
				sbnfLinkAction.setListdataTablePM_IL_CVR_SBNF_LINK(list);
				for(int i=0;i<list.size();i++) {
					PM_IL_CVR_SBNF_LINK gridValueBean = list.get(i);

					if("D".equalsIgnoreCase(gridValueBean.getBSBL_LIMIT_TYP())) {

						gridValueBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(false);
						gridValueBean.setBSBL_LIMIT_DAYS_DISABLE(false);
						
						if(!"".equals(gridValueBean.getROWID()) && gridValueBean.getROWID() != null) {
							gridValueBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(false);
							gridValueBean.setBSBL_LIMIT_DAYS_DISABLE(false);
						}
						
						gridValueBean.setBSBL_PER_DAY_LC_LIMIT_REQUIRED(true);
						gridValueBean.setBSBL_LIMIT_DAYS_REQUIRED(true);
						gridValueBean.setBSBL_LIMIT_LC_AMT_DISABLE(true);
						
						if(!"".equals(gridValueBean.getROWID()) && gridValueBean.getROWID() != null) {
							gridValueBean.setBSBL_LIMIT_LC_AMT_DISABLE(true);
						}
						
						gridValueBean.setBSBL_LIMIT_LC_AMT_REQUIRED(false);
					}
					if("F".equalsIgnoreCase(gridValueBean.getBSBL_LIMIT_TYP())){
						gridValueBean.setBSBL_PER_DAY_LC_LIMIT(null);
						gridValueBean.setBSBL_LIMIT_DAYS(null);
						gridValueBean.setBSBL_PER_DAY_LC_LIMIT_DISABLE(true);
						gridValueBean.setBSBL_LIMIT_DAYS_DISABLE(true);
					}
					sbnfLinkAction.postQueryPM_IL_CVR_SBNF_LINK(gridValueBean);
					sbnfLinkAction.getPM_IL_CVR_SBNF_LINK_BEAN().setRowSelected(false);
				}
				PM_IL_CVR_SBNF_LINK PM_IL_CVR_SBNF_LINK_BEAN =null;
				Iterator<PM_IL_CVR_SBNF_LINK> listIterator= list.iterator();
				while(listIterator.hasNext()){
					 PM_IL_CVR_SBNF_LINK_BEAN  = listIterator.next();
					 PM_IL_CVR_SBNF_LINK_BEAN.setRowSelected(false);
				}
				sbnfLinkAction.setPM_IL_CVR_SBNF_LINK_BEAN(list.get(0));
				sbnfLinkAction.getPM_IL_CVR_SBNF_LINK_BEAN().setRowSelected(true);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String addNew(ActionEvent ae) {
		int rowCount = 0;
		try {
			getErrorMap().clear();
			getWarningMap().clear();
			PM_IL_CVR_BNF_LINK_BEAN=null;
			if (isINSERT_ALLOWED()){
				PM_IL_CVR_BNF_LINK_BEAN = new PM_IL_CVR_BNF_LINK();
				whenCreateRecord(PM_IL_CVR_BNF_LINK_BEAN);
					resetAllComponent();
			}
			else{
				getErrorMap().put("somekey",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
				getErrorMap().put("current",
						Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put("current", e.getMessage());
			getErrorMap().put("details", e.getMessage());
		}	
	/* 
		LIST_dataTable.add(PM_IL_CVR_BNF_LINK_BEAN);

		// Settings to navigate to last page
		rowCount = getLIST_COMP_DATATABLE().getRowCount();
		currPage = rowCount/recordsPerPage;
		if(rowCount%recordsPerPage>0){
			currPage++;
		}*/
		return "newadded";
	}
	
	
	public String deleteRow(ActionEvent ae) {
		PM_IL_CVR_BNF_LINK bean = null;
		ArrayList deletedRecordList = null;
		int deletedRecordIndex = 0;
		if(LIST_dataTable!=null)
		{
			deletedRecordList = new ArrayList();
			for(int index =0; index<LIST_dataTable.size();)	{
				bean = LIST_dataTable.get(index);
				System.out.println("PM_IL_CVR_BNF_LINK_ACTION.deleteRow() bean.isCheckBoxFirst(): "+bean.isCheckBoxFirst());				

				if("dataTableSelectedRow".equalsIgnoreCase(bean.getRowSelected())){
					LIST_dataTable.remove(bean);
					/* Pre Delete Calling */
					new PM_IL_COVER_DELEGATE().cacadeDelete(bean.getCBL_COVER_CODE(),bean.getCBL_BNF_CODE());
					deletedRecordIndex = deleteData(bean);
					deletedRecordList.add(deletedRecordIndex);
				}else {
					index++;
				}
			}

			if(deletedRecordList.size()>0)
			{
				getErrorMap().put("somekey", deletedRecordList.size()+" records deleted.");
				getErrorMap().put("current", deletedRecordList.size()+" records deleted.");
			} 
			lastUpdatedRowIndex = -1;
		}
		return "";
	}
	
	
	public int deleteData(Object gridValueBean)	{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public List getBenefitCodeList() {
		return benefitCodeList;
	}

	public void setBenefitCodeList(List benefitCodeList) {
		this.benefitCodeList = benefitCodeList;
	}

	//save or update the record
	public void post(ActionEvent ae) {
		int rowUpdated=0;
		try{
			 
			if(PM_IL_CVR_BNF_LINK_BEAN.getROWID()!=null){
				if(isUPDATE_ALLOWED()) {
					rowUpdated = new PM_IL_COVER_DELEGATE().updateBenefitDetails(PM_IL_CVR_BNF_LINK_BEAN);
					if(rowUpdated>0)
					{
						getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$update"));
						getWarningMap().put("post", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$update"));
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$updatenotallowed") );
				}
			}else{
				if(isINSERT_ALLOWED()) {
					PM_IL_COVER_ACTION pm_il_cover_action = (PM_IL_COVER_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_COVER_ACTION");
					String coverCode = pm_il_cover_action.getPM_IL_COVER_BEAN().getCOVER_CODE();
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_COVER_CODE(coverCode);
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
					PM_IL_CVR_BNF_LINK_BEAN.setCBL_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
					rowUpdated = new PM_IL_COVER_DELEGATE().updateBenefitDetails( PM_IL_CVR_BNF_LINK_BEAN);
					if(rowUpdated>0)
					{
						LIST_dataTable.add(PM_IL_CVR_BNF_LINK_BEAN);
						getWarningMap().put("current",Messages.getString("messageProperties", "errorPanel$message$insert"));
						getWarningMap().put("post", Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insert"));
					}
				} else {
					getErrorMap().clear();
					getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed"));
					getWarningMap().put("post",Messages.getString(PELConstants.pelMessagePropertiesPath, "errorPanel$message$insertnotallowed") );
				}
			}
			resetAllComponent();
			resetSelectedRow();
			PM_IL_CVR_BNF_LINK_BEAN.setRowSelected(true);

		} catch (Exception e) {
			e.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("post", e.getMessage());
		}
	}
	

	public void lastColumnOperation() {
		int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		int rowUpdated = 0;
		PM_IL_CVR_BNF_LINK pm_il_cvr_bnf_link = null;
		try {
			// Get the bean based on row index
			pm_il_cvr_bnf_link = (PM_IL_CVR_BNF_LINK) getLIST_dataTable().get(currRowIndex);
			// Update the record to database
			
			if (pm_il_cvr_bnf_link.getROWID() == null) {
				
				/*try {
					pre_insert(pm_il_plan_mop);
				} catch (ValidatorException ve) {
					throw ve;
				}*/
				
				PM_IL_COVER_ACTION pm_il_cover_action = (PM_IL_COVER_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_COVER_ACTION");
				String coverCode = pm_il_cover_action.getPM_IL_COVER_BEAN().getCOVER_CODE();
				pm_il_cvr_bnf_link.setCBL_COVER_CODE(coverCode);
				pm_il_cvr_bnf_link.setCBL_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
				pm_il_cvr_bnf_link.setCBL_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
				
				rowUpdated = new PM_IL_COVER_DELEGATE().updateBenefitDetails(pm_il_cvr_bnf_link);
				if(rowUpdated>0)
				{
					getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
					getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
				}
				
			}else{
				rowUpdated = new PM_IL_COVER_DELEGATE().updateBenefitDetails(pm_il_cvr_bnf_link);
				if(rowUpdated>0)
				{
					getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
					getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
					
				}
			}
			lastUpdatedRowIndex = currRowIndex;
		} catch (Exception e1) {
			getWarningMap().put("current", e1.getMessage());
		}
		return;
	}
	
	public void nextBlock_PM_IL_BNF_AGE_SETUP(String code) {
		
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_BNF_AGE_SETUP_ACTION ageSetupAction = (PM_IL_BNF_AGE_SETUP_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_BNF_AGE_SETUP_ACTION");
		
		String bas_cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
		
		String queryForageSetupAction = "SELECT ROWID,PM_IL_BNF_AGE_SETUP.* FROM PM_IL_BNF_AGE_SETUP WHERE BAS_COVER_CODE = '"+bas_cover_code+"' and " +
				"BAS_BNF_CODE='"+code+"'";
		System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_BNF_AGE_SETUP() query "+queryForageSetupAction);
		
		CRUDHandler handler = new CRUDHandler();
		try {
			List<PM_IL_BNF_AGE_SETUP> list = handler.fetch(queryForageSetupAction, "com.iii.pel.forms.PILM203.PM_IL_BNF_AGE_SETUP", CommonUtils.getConnection());
			System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_BNF_LINK() list size "+list.size());
			for(int i=0 ; i < list.size() ; i++) {
				PM_IL_BNF_AGE_SETUP valueBean = list.get(i);
				ageSetupAction.postQueryPM_IL_BNF_AGE_SETUP(valueBean);
				ageSetupAction.getPM_IL_BNF_AGE_SETUP_BEAN().setRowSelected(false);
			}
			
			PM_IL_BNF_AGE_SETUP PM_IL_BNF_AGE_SETUP_BEAN =null;
			Iterator<PM_IL_BNF_AGE_SETUP> listIterator= list.iterator();
			while(listIterator.hasNext()){
				PM_IL_BNF_AGE_SETUP_BEAN  = listIterator.next();
				PM_IL_BNF_AGE_SETUP_BEAN.setRowSelected(false);
			}
			ageSetupAction.setListdataTablePM_IL_BNF_AGE_SETUP(list);
			if(list.size()>0){
				ageSetupAction.setPM_IL_BNF_AGE_SETUP_BEAN(list.get(0));
				ageSetupAction.getPM_IL_BNF_AGE_SETUP_BEAN().setRowSelected(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 
	/*public void gridtabListener(){
		int currRowIndex = getLIST_COMP_DATATABLE().getRowIndex();
		int rowUpdated = 0;
		PM_IL_CVR_BNF_LINK pm_il_cvr_bnf_link = null;
		
//		DataGridValueBean gridValueBean = null;
		try {
			if(lastUpdatedRowIndex!=-1)
			{
				if(lastUpdatedRowIndex!=prevrowIndex)
				{
					if(currRowIndex != prevrowIndex){
						// Get the bean based on row index
						pm_il_cvr_bnf_link = (PM_IL_CVR_BNF_LINK) getLIST_dataTable().get(currRowIndex);
						// Update the record to database
						
						if (pm_il_cvr_bnf_link.getROWID() == null) {
								
								rowUpdated = new PM_IL_COVER_DELEGATE().updateBenefitDetails(pm_il_cvr_bnf_link);
								if(rowUpdated>0)
								{
									getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
									getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "UPDATE_MESSAGE"));
									
								}
							}else
							{
								
								PM_IL_COVER_ACTION pm_il_cover_action = (PM_IL_COVER_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_COVER_ACTION");
								String coverCode = pm_il_cover_action.getPM_IL_COVER_BEAN().getCOVER_CODE();
								pm_il_cvr_bnf_link.setCBL_COVER_CODE(coverCode);
								pm_il_cvr_bnf_link.setCBL_CR_DT(new java.sql.Date(Calendar.getInstance().getTimeInMillis()));
								pm_il_cvr_bnf_link.setCBL_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
								
								rowUpdated = new PM_IL_COVER_DELEGATE().updateBenefitDetails(pm_il_cvr_bnf_link);
								if(rowUpdated>0)
								{
									getWarningMap().put("current",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
									getWarningMap().put("somekey",Messages.getString(PELConstants.pelErrorMessagePath, "SAVE_MESSAGE"));
								}
								
								
							}
						
						// Update previous row index
							prevrowIndex = currRowIndex;
					}
				}
			}
		} catch (Exception e1) {
			getWarningMap().put("current", e1.getMessage());
		}
		
		return ; 
	}	
	*/
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 
	/**
	 * @param pm_il_cvr_bnf_link
	 */
	public void nextBlock_PM_IL_BNF_DEDB_LINK(PM_IL_CVR_BNF_LINK pm_il_cvr_bnf_link) {
		ResultSet resultSet = null;
		
		FacesContext context = FacesContext.getCurrentInstance();
		ELResolver resolver = context.getELContext().getELResolver();
		PM_IL_BNF_DEDB_LINK_ACTION sbnfLinkAction = (PM_IL_BNF_DEDB_LINK_ACTION)resolver.getValue(context.getELContext(), null, "PILM203_PM_IL_BNF_DEDB_LINK_ACTION");

		String cover_code = getPM_IL_COVER_ACTION().getPM_IL_COVER_BEAN().getCOVER_CODE();
		String code = pm_il_cvr_bnf_link.getCBL_BNF_CODE();
		String queryForBnfLink = "SELECT ROWID,PM_IL_BNF_DEDB_LINK.* FROM PM_IL_BNF_DEDB_LINK WHERE BDL_COVER_CODE = ? AND BDL_BNF_CODE= ?";
		System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_BNF_DEDB_LINK() query "+queryForBnfLink);

		CRUDHandler handler = new CRUDHandler();
		List<PM_IL_BNF_DEDB_LINK> list = null;//new ArrayList<PM_IL_BNF_DEDB_LINK>();
		PM_IL_BNF_DEDB_LINK bean = null;
		 
		try {
			//List<PM_IL_BNF_DEDB_LINK> list = handler.fetch(queryForBnfLink, "com.iii.pel.forms.PILM203.PM_IL_BNF_DEDB_LINK", CommonUtils.getConnection());
			 
			Object[] values = {cover_code, code};
			resultSet = handler.executeSelectStatement(queryForBnfLink, CommonUtils.getConnection(), values);
			list = new ArrayList<PM_IL_BNF_DEDB_LINK>();
			while(resultSet.next()) {
				bean = new PM_IL_BNF_DEDB_LINK();
				
				bean.setROWID(resultSet.getString(1));
				bean.setBDL_COVER_CODE(resultSet.getString(2));
				bean.setBDL_BNF_CODE(resultSet.getString(3));
				bean.setBDEL_DEDB_CODE(resultSet.getString(4));
				bean.setBDL_DEDB_NO_OF_DAYS(resultSet.getDouble(5));
				bean.setBDL_DEDB_PERC(resultSet.getDouble(6));
				bean.setBDL_DEDB_MIN_AMT(resultSet.getDouble(7));
				bean.setBDL_DEDB_DFLT_YN(resultSet.getString(8));
				bean.setBDL_FRZ_FLAG(resultSet.getString(9));
				bean.setBDL_CR_DT(resultSet.getDate(10));
				bean.setBDL_CR_UID(resultSet.getString(11));
				bean.setBDL_UPD_DT(resultSet.getDate(12));
				bean.setBDL_UPD_UID(resultSet.getString(13));
				if("D".equals(pm_il_cvr_bnf_link.getCBL_LIMIT_TYP())) {
					bean.setDaysDisabled(false);
					bean.setPercDisabled(true);
				} else {
					bean.setDaysDisabled(true);
					bean.setPercDisabled(false);
				}
				list.add(bean);
			}
			
			//list = handler.fetch(queryForageSetupAction, "com.iii.pel.forms.PILM203.PM_IL_BNF_AGE_SETUP", CommonUtils.getConnection());
			
			System.out.println("PM_IL_COVER_ACTION.nextBlock_PM_IL_CVR_BNF_LINK() list size "+list.size());

//			if(list != null && list.size() > 0) {
//				sbnfLinkAction.getListdataTablePM_IL_BNF_DEDB_LINK().clear();
//				PM_IL_BNF_DEDB_LINK valueBean = list.get(0);
//				System.out.println(valueBean.getBDEL_DEDB_CODE()+"  "+valueBean.getBDL_DEDB_NO_OF_DAYS());
//				sbnfLinkAction.setListdataTablePM_IL_BNF_DEDB_LINK(list);
//
//				for(int i=0;i<4;i++) {
//					PM_IL_CVR_BNF_LINK dummylist = new PM_IL_CVR_BNF_LINK();
////					bnfLinkAction.getLIST_dataTable().add(dummylist);
//				}
//
//				sbnfLinkAction.setPM_IL_BNF_DEDB_LINK_BEAN(valueBean);
//				sbnfLinkAction.postQueryPM_IL_BNF_DEDB_LINK(valueBean);
//			}
			
			for(int i=0 ; i < list.size() ; i++) {
				PM_IL_BNF_DEDB_LINK valueBean = list.get(i);
				sbnfLinkAction.postQueryPM_IL_BNF_DEDB_LINK(valueBean);
				//sbnfLinkAction.getPM_IL_BNF_DEDB_LINK_BEAN().setRowSelected(false);
			}
			PM_IL_BNF_DEDB_LINK PM_IL_BNF_DEDB_LINK_BEAN= null;
			
			Iterator<PM_IL_BNF_DEDB_LINK> iterator = list.iterator();
			while(iterator.hasNext())
			{
				PM_IL_BNF_DEDB_LINK_BEAN = iterator.next();
				PM_IL_BNF_DEDB_LINK_BEAN.setRowSelected(false);
			}
			
			sbnfLinkAction.setListdataTablePM_IL_BNF_DEDB_LINK(list);
			if(list.size()>0)
			{
				sbnfLinkAction.setPM_IL_BNF_DEDB_LINK_BEAN(list.get(0));
				sbnfLinkAction.getPM_IL_BNF_DEDB_LINK_BEAN().setRowSelected(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public String subBenefitButtonAction()
	{
		int rowIndex = getLIST_COMP_DATATABLE().getRowCount();
		int count = 0;
		String code = null;
		
		PM_IL_CVR_SBNF_LINK_ACTION pm_il_cvr_sbnf_link_action = new PM_IL_CVR_SBNF_LINK_ACTION();
		HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("PILM203_PM_IL_CVR_SBNF_LINK_ACTION",pm_il_cvr_sbnf_link_action);
		
		for(int index = 0; index<rowIndex; index++)
		{
			 PM_IL_CVR_BNF_LINK_BEAN= (PM_IL_CVR_BNF_LINK)getLIST_dataTable().get(index);
			 System.out.println(" PM_IL_CVR_BNF_LINK_BEAN.getRowSelected() > " +PM_IL_CVR_BNF_LINK_BEAN.getRowSelected());
			if(("dataTableSelectedRow").equalsIgnoreCase(PM_IL_CVR_BNF_LINK_BEAN.getRowSelected()))
			{
				count = count+1;
				code = PM_IL_CVR_BNF_LINK_BEAN.getCBL_BNF_CODE();
				//pm_il_cvr_bnf_link.setSelectedBenefitCode(pm_il_cvr_bnf_link.getCBL_BNF_CODE());
				pm_il_cvr_sbnf_link_action.setTempBean(PM_IL_CVR_BNF_LINK_BEAN);
			}
		}
		
		if(count>0)
		{
			PM_IL_CVR_BNF_LINK_ACTION bnfLinkAction = (PM_IL_CVR_BNF_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_CVR_BNF_LINK_ACTION");
			bnfLinkAction.nextBlock_PM_IL_CVR_SBNF_LINK(code); 
			return "CVR_SBNF";
		}else{
			getErrorMap().put("current", "Please select one record");
			getErrorMap().put("somekey", "Please select one record");
			return "";
		}
			
	}
	
	public String applicableCategoryButtonAction()
	{
		int rowIndex = getLIST_COMP_DATATABLE().getRowCount();
		int count = 0;
		String code = null;
		PM_IL_BNF_AGE_SETUP_ACTION  pm_il_bnf_age_setup_action = new PM_IL_BNF_AGE_SETUP_ACTION();
		HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("PILM203_PM_IL_BNF_AGE_SETUP_ACTION",pm_il_bnf_age_setup_action);
		for(int index = 0; index<rowIndex; index++)
		{
			PM_IL_CVR_BNF_LINK_BEAN = (PM_IL_CVR_BNF_LINK)getLIST_dataTable().get(index);
			if(("dataTableSelectedRow").equalsIgnoreCase(PM_IL_CVR_BNF_LINK_BEAN.getRowSelected()))
			{
				count = count+1;
				code = PM_IL_CVR_BNF_LINK_BEAN.getCBL_BNF_CODE();
				pm_il_bnf_age_setup_action.setTempBean(PM_IL_CVR_BNF_LINK_BEAN);
			}
		}
		if(count>0)
		{
			PM_IL_CVR_BNF_LINK_ACTION bnfLinkAction = (PM_IL_CVR_BNF_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_CVR_BNF_LINK_ACTION");
			System.out.println("code::::::::::"+code);
			bnfLinkAction.nextBlock_PM_IL_BNF_AGE_SETUP(code);
			return "CATAGORY";
		}else{
			getErrorMap().put("current", "Please select one record");
			getErrorMap().put("somekey", "Please select one record");
			return "";
		}
	}
	public String deductableButtonAction()
	{
		PM_IL_BNF_DEDB_LINK_ACTION pm_il_bnf_dedb_link_action = new PM_IL_BNF_DEDB_LINK_ACTION();
		HttpSession session=(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("PILM203_PM_IL_BNF_DEDB_LINK_ACTION",pm_il_bnf_dedb_link_action);
		
		//PM_IL_BNF_DEDB_LINK_ACTION pm_il_bnf_dedb_link_action=(PM_IL_BNF_DEDB_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_BNF_DEDB_LINK_ACTION");
		int rowIndex = getLIST_COMP_DATATABLE().getRowCount();
		int count = 0;
		String code = null;
		for(int index = 0; index<rowIndex; index++)
		{
			PM_IL_CVR_BNF_LINK_BEAN = (PM_IL_CVR_BNF_LINK)getLIST_dataTable().get(index);
			if(("dataTableSelectedRow").equalsIgnoreCase(PM_IL_CVR_BNF_LINK_BEAN.getRowSelected()))
			{
				count = count+1;
				code = PM_IL_CVR_BNF_LINK_BEAN.getCBL_BNF_CODE();
				pm_il_bnf_dedb_link_action.setTempBean(PM_IL_CVR_BNF_LINK_BEAN);
			}
		}
		if(count>0)
		{
			PM_IL_CVR_BNF_LINK_ACTION bnfLinkAction = (PM_IL_CVR_BNF_LINK_ACTION)new CommonUtils().getMappedBeanFromSession("PILM203_PM_IL_CVR_BNF_LINK_ACTION");
			bnfLinkAction.nextBlock_PM_IL_BNF_DEDB_LINK(pm_il_bnf_dedb_link_action.getTempBean());
			return "DEDUCTABLES";
		}else{
			getErrorMap().put("current", "Please select one record");
			getErrorMap().put("somekey", "Please select one record");
			return "";
		}
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 
	/**
	 * Saves a record for which Save button is clicked
	 */
	public String saveCurrentRecord(){
		String outcome = null;
		int rowIndex = LIST_COMP_DATATABLE.getRowIndex();

		try{
			if(rowIndex > -1){
				// Calling last Column listener
				lastColumnOperation();
			}else{
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
						"IL_GRID$INVALID_ROW_INDEX$message"));
			}
		}catch(Exception exc){
			exc.printStackTrace();
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, exc.getMessage());
		}
		
		return outcome;
	}
	// Added for grid implementation change, Added by: Shankar Bodduluri, Dated: 17-Feb-2009 ] 

	public HtmlAjaxCommandButton getUI_M_BUT_ADD() {
		return UI_M_BUT_ADD;
	}

	public void setUI_M_BUT_ADD(HtmlAjaxCommandButton ui_m_but_add) {
		UI_M_BUT_ADD = ui_m_but_add;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_DELETE() {
		return UI_M_BUT_DELETE;
	}

	public void setUI_M_BUT_DELETE(HtmlAjaxCommandButton ui_m_but_delete) {
		UI_M_BUT_DELETE = ui_m_but_delete;
	}

	public HtmlAjaxCommandButton getUI_M_BUT_POST() {
		return UI_M_BUT_POST;
	}

	public void setUI_M_BUT_POST(HtmlAjaxCommandButton ui_m_but_post) {
		UI_M_BUT_POST = ui_m_but_post;
	}

	public String getFilterByCBL_BNF_CODE() {
		return filterByCBL_BNF_CODE;
	}

	public void setFilterByCBL_BNF_CODE(String filterByCBL_BNF_CODE) {
		this.filterByCBL_BNF_CODE = filterByCBL_BNF_CODE;
	}

	public String getFilterByCBL_LIMIT_TYP() {
		return filterByCBL_LIMIT_TYP;
	}

	public void setFilterByCBL_LIMIT_TYP(String filterByCBL_LIMIT_TYP) {
		this.filterByCBL_LIMIT_TYP = filterByCBL_LIMIT_TYP;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	
}