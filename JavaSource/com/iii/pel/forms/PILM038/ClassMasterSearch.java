package com.iii.pel.forms.PILM038;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.el.ELResolver;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.premia.common.utils.CommonUtils;

public class ClassMasterSearch {
	private HtmlDataTable comp_class_code;
	private ArrayList<PM_IL_CLAIM_COVER> nameList;
	private List<SelectItem> claim_Type_List;
	private PM_IL_CLAIM_COVER name;
	private String initClasscode;
	private String initClassname;
	private String storedclasscode;
	
	private HtmlInputText CLAIM_TYPE_DESC;
	PM_IL_CLAIM_COVER bean = null;
	CRUDHandler handler = new CRUDHandler();

	public ClassMasterSearch() {
		bean = new PM_IL_CLAIM_COVER();
		claim_Type_List = new ArrayList<SelectItem>();
		String query = "SELECT PS_CODE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_CLM_TYPE'";
		System.out.println("select Query >>> "+query);
		claim_Type_List.clear();
		claim_Type_List.add(new SelectItem(""));
		ResultSet resultSet = null;
		try {
			resultSet = handler.executeSelectStatement(query, CommonUtils.getConnection());
			while(resultSet.next()){
				claim_Type_List.add(new SelectItem(resultSet.getString(1)));
			}
			CommonUtils.closeCursor(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HtmlInputText getCLAIM_TYPE_DESC() {
		return CLAIM_TYPE_DESC;
	}

	public void setCLAIM_TYPE_DESC(HtmlInputText claim_type_desc) {
		CLAIM_TYPE_DESC = claim_type_desc;
	}

	public HtmlDataTable getComp_class_code() {
		return comp_class_code;
	}

	public String getInitClasscode() {
		return initClasscode;
	}

	public String getInitClassname() {
		return initClassname;
	}

	public String getStoredclasscode() {
		return storedclasscode;
	}

	public void setComp_class_code(HtmlDataTable comp_class_code) {
		this.comp_class_code = comp_class_code;
	}

	public void setInitClasscode(String initClasscode) {
		this.initClasscode = initClasscode;
	}

	public void setInitClassname(String initClassname) {
		this.initClassname = initClassname;
	}

	public void setStoredclasscode(String storedclasscode) {
		this.storedclasscode = storedclasscode;
	}

	public String clearList() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest req = (HttpServletRequest) context
				.getExternalContext().getRequest();
		String code = req.getParameter("ClassCode");
		System.out.println("ClassMasterSearch.clearList()Code*****" + code);
		prepareClassMasterDetails(code);
		nameList = null;
		String returnStr = "openscreen";
		return returnStr;
	}

	public String fetchClassDetails() {
		try {
			/*
			 * this.classMasterRecordList = new PILM001_CRUD()
			 * .fetchClassMasterDetails(this);
			 */
			nameList = (ArrayList<PM_IL_CLAIM_COVER>) new PILM038_CRUD()
					.fetchClassMasterDetails(this);
		} catch (Exception e) {
			// TODO do appropriate settings for the message to display to the
			// user
			e.printStackTrace();
		}

		return null;
	}

	public String clearSession() {
		/*
		 * FacesContext context = FacesContext.getCurrentInstance();
		 * HttpServletRequest request = (HttpServletRequest) context
		 * .getExternalContext().getRequest();
		 * System.out.println("GetCC_COVER_CODE"+bean.getCC_CLAIM_TYPE());
		 * System.out.println("BEAN"+bean); HttpSession session =
		 * request.getSession(); if
		 * (session.getAttribute("PM_IL_CLAIM_COVER_ACTION") != null) {
		 * session.removeAttribute("PM_IL_CLAIM_COVER_ACTION"); } return
		 * "openscreen";
		 */
		//System.out.println("Name List size == "+nameList.size());
		Connection connection = null;
		
		//PM_IL_CLAIM_COVER_ACTION action = new PM_IL_CLAIM_COVER_ACTION();
		// name.setCC_COVER_CODE(initClasscode);
		bean.setCC_COVER_CODE(initClasscode);
		System.out.println("init class code>>>>>> "+initClasscode);
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=(HttpSession)request.getSession();
		PM_IL_CLAIM_COVER_ACTION pm_il_claim_cover=new PM_IL_CLAIM_COVER_ACTION();
		session.setAttribute("PILM038_PM_IL_CLAIM_COVER_ACTION",pm_il_claim_cover);
		//String prod_code =(String)pm_il_claim_cover.getCOMP_CC_COVER_CODE().getSubmittedValue();
		//System.out.println(">>>>>>>>>>>>>>>"+getM1("A").size());
		
		
		//pm_il_claim_cover.setBeanList(getM1(initClasscode));
		
		//search = (ClassMasterSearch) session.getAttribute("ClassMasterSearch");
		
		/*String query = "select CC_COVER_CODE from PM_IL_CLAIM_COVER where upper(CC_CLAIM_TYPE) =?";
		if(getInitClasscode().equals(null) && getInitClasscode().equals("")){
			System.out.println("NULL CLASS CODE VALUE ");
		}
		else if(initClasscode != null && !getInitClasscode().equals("")){
		
		CRUDHandler handler = new CRUDHandler();
		try{
			connection = pm_il_claim_cover.getConnection();
			System.out.println(">>>>>>>>connection: "+connection);
			//beanList = PM_IL_CLAIM_COVER_BEAN.getPreQueryResultList();
				//PM_IL_CLAIM_COVER pp_life_pol_sch_prn = beanList.get(rowNum2delete);
			System.out.println("storedclasscode>>>>>>>>>>"+storedclasscode);
			System.out.println("initClasscode>>>>>>>>>>>"+initClasscode);
			System.out.println("initClassname>>>>>>>>>"+initClassname);
			query = query.replace("{0}", initClasscode.toUpperCase());
			nameList = (ArrayList<PM_IL_CLAIM_COVER>) handler.fetch(query, "com.iii.pel.forms.PILM038.PM_IL_CLAIM_COVER",connection);
			System.out.println(">>>>>>>>>>>>>>>mylist: "+nameList);
			
		}
		catch(Exception er){
			er.printStackTrace();
		}
		}*/
		/*ArrayList<PM_IL_CLAIM_COVER> applPlanList=new PM_IL_PROD_DELEGATE().appl_Sub_PlanList(prod_code);
		if(applPlanList.size()>0)
		{
			pm_il_claim_cover.set
			nam(applPlanList);
			action.getBeanList().add(applPlanList);
		}
		else
		{
			pm_il_claim_cover.getProd_appl_list().add(new PM_IL_PROD_APPL_PLANS());
		}*/
		//pm_il_claim_cover.getBeanList().add(new PM_IL_CLAIM_COVER());
		
		return "openscreen";
		
	}
	
	public String update() throws Exception
	{
		PM_IL_CLAIM_COVER_ACTION action = new PM_IL_CLAIM_COVER_ACTION();
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		String code = request.getParameter("CoverCode");
		
		ELResolver resolver = context.getApplication().getELResolver();
		PM_IL_CLAIM_COVER_ACTION actionBean= (PM_IL_CLAIM_COVER_ACTION)resolver.getValue(context.getELContext(), null, "PILM038_PM_IL_CLAIM_COVER_ACTION");
		prepareDetails(code,actionBean);
		action.getBeanList().add(new PM_IL_CLAIM_COVER());
		String returnStr = "goMainPage";
		
		/*System.out.println("INSIDE UPDATE"+bean.getCC_COVER_CODE());
		bean.setCC_COVER_CODE(initClasscode);
		System.out.println("INSIDE UPDATE"+bean.getCC_COVER_CODE());
		System.out.println("init class UPDAtecode>>>>>> "+initClasscode);
		FacesContext context=FacesContext.getCurrentInstance();
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=(HttpSession)request.getSession();
		PM_IL_CLAIM_COVER_ACTION pm_il_claim_cover=new PM_IL_CLAIM_COVER_ACTION();
		session.setAttribute("PILM038_PM_IL_CLAIM_COVER_ACTION",pm_il_claim_cover);
		System.out.println(">>>>>>>>>SIZE OF GET M1>>>>>>"+getM1("A").size());
		System.out.println("comp_class_code>>>>>"+comp_class_code);
		pm_il_claim_cover.getBeanList().add(name);*/
		//pm_il_claim_cover.setBeanList(getM1(initClasscode));
		//pm_il_claim_cover.getBeanList();
		
		return "openscreen";
	}
	
	private void  prepareDetails(String code,PM_IL_CLAIM_COVER_ACTION actionBean) throws Exception {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_CLAIM_COVER_ACTION action = new PM_IL_CLAIM_COVER_ACTION();
		if(actionBean == null) {
			System.out.println("bean null");
		}
		session.setAttribute("PILM038_PM_IL_CLAIM_COVER_ACTION", actionBean);
		PM_IL_CLAIM_COVER claimcoversetup=actionBean.getPM_IL_CLAIM_COVER_BEAN();
		
		
		//String ROWID = getRowId(code);
		String selectQuery = "select ROWID,CC_COVER_CODE,CC_EFF_FM_DT,CC_EFF_TO_DT,CC_CLAIM_TYPE FROM PM_IL_CLAIM_COVER where CC_COVER_CODE= '" +code + "'"; 
		//String selectQuery  = "select ROWID,CC_COVER_CODE,COVER_DESC,CC_EFF_FM_DT,CC_EFF_TO_DT FROM PM_IL_CLAIM_COVER,PM_IL_COVER where ROWID= '" +code + "'";
		System.out.println("selectQuery"+selectQuery);
		Connection con = CommonUtils.getConnection();
		System.out.println("CODE **********"+code);
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM038.PM_IL_CLAIM_COVER",con);
		System.out.println("List>>>>>>"+list);
		claimcoversetup = (PM_IL_CLAIM_COVER)list.get(0);
		System.out.println("pm_il_bank_account_setup>>>>>>>>>>>>"+claimcoversetup);
		actionBean.setPM_IL_CLAIM_COVER_BEAN(claimcoversetup);
		
		String CC_COVER_CODE = actionBean.getPM_IL_CLAIM_COVER_BEAN().getCC_COVER_CODE();
		System.out.println("CC_COVER_CODE>>>>>>>>>>>>>>>>>>"+CC_COVER_CODE);
		//String COVER_DESC =Bring_BAS_OUR_BANK_CODE_DESC(OUR_BANK_CODE);
		claimcoversetup.setCC_COVER_CODE(CC_COVER_CODE);
		actionBean.setPM_IL_CLAIM_COVER_BEAN(claimcoversetup);
		
		Date CC_EFF_FM_DT = actionBean.getPM_IL_CLAIM_COVER_BEAN().getCC_EFF_FM_DT();
		//String CUST_BANK_DESC = Bring_BAS_CUST_BANK_CODE_DESC(CUST_BANK_CODE);
		claimcoversetup.setCC_EFF_FM_DT(CC_EFF_FM_DT);
		actionBean.setPM_IL_CLAIM_COVER_BEAN(claimcoversetup);
		
		String CLAIM_TYPE = actionBean.getPM_IL_CLAIM_COVER_BEAN().getCC_CLAIM_TYPE();
		claimcoversetup.setCC_CLAIM_TYPE(CLAIM_TYPE);
		actionBean.setPM_IL_CLAIM_COVER_BEAN(claimcoversetup);
		/*String MAIN_ACNT_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_MAIN_ACNT_CODE();
		String MAIN_ACNT_DESC = Bring_BAS_MAIN_ACNT_CODE_DESC(MAIN_ACNT_CODE);
		pm_il_bank_account_setup.setUI_M_MAIN_ACNT_DESC(MAIN_ACNT_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);*/
		
		
		/*String SUB_ACNT_CODE = actionBean.getPM_IL_BANK_ACCOUNT_SETUP_BEAN().getBAS_SUB_ACNT_CODE();
		String SUB_ACNT_DESC = Bring_BAS_MAIN_ACNT_CODE_DESC(SUB_ACNT_CODE);
		pm_il_bank_account_setup.setUI_M_MAIN_ACNT_DESC(SUB_ACNT_DESC);
		actionBean.setPM_IL_BANK_ACCOUNT_SETUP_BEAN(pm_il_bank_account_setup);
		*/
		
	}
	
	
	public List lovAction(Object obj) {

		List lovList = new ArrayList();
		if (obj.toString().equals("*")) {
			//String query = "select rownum,POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM PT_IL_POLICY where rownum < 51";
			//select PS_CODE,PS_CODE_DESC from PP_SYSTEM where PS_TYPE = 'IL_CLM_TYPE'
			String query = "select PS_CODE,PS_CODE_DESC from PP_SYSTEM where PS_TYPE = 'IL_CLM_TYPE'";
			lovList = suggestionList(query);
		}
		/*else{
			String query = "select rownum,POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM PT_IL_POLICY where POL_NO like '"+obj.toString()+"%' and rownum<51" ;
			lovList = suggestionList(query);
		}*/
		return lovList;
	}
 
 public List suggestionList(String query) {
		// String query="SELECT POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM
		// PT_IL_POLICY";
		//String query = "select rownum,POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM PT_IL_POLICY where rownum < 51";
		// String query = "SELECT POL_NO,POL_SYS_ID,POL_ISSUE_DT FROM
		// PT_IL_POLICY WHERE POL_NO IS NOT NULL AND POL_DS_TYPE = '2'";
		Statement stmt = null;
		List list = new ArrayList();
		ResultSet rs;
		try {
			FacesContext fc = FacesContext.getCurrentInstance();
			ServletContext context = (ServletContext) fc.getExternalContext()
					.getContext();
			SimpleConnectionAgent connectionAgent = (SimpleConnectionAgent) context
					.getAttribute("connectionAgent");
			Connection con = connectionAgent.getConnection("123");
			
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				SEARCH_CLAIM_COVER_LOV lovBox = new SEARCH_CLAIM_COVER_LOV(); 
				lovBox.setPS_CODE(rs.getString("PS_CODE"));
				lovBox.setPS_CODE_DESC(rs.getString("PS_CODE_DESC"));
				//getInitClassname().
				list.add(lovBox);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
 public List getM1(String classCode) {
		List list = new ArrayList();
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			String query = "select CC_COVER_CODE from PM_IL_CLAIM_COVER,PM_IL_COVER where CC_COVER_CODE=COVER_CODE AND upper(CC_CLAIM_TYPE) =?";
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { classCode.toUpperCase() });
			while (resultSet.next()) 
			{
				PM_IL_CLAIM_COVER cover = new PM_IL_CLAIM_COVER();
				cover.setCC_COVER_CODE(resultSet.getString("CC_COVER_CODE"));
				cover.setCC_CLAIM_TYPE(resultSet.getString("CC_CLAIM_TYPE"));
				System.out.println("CC_CLAIM_TYPE >>:::::"+resultSet.getString("CC_CLAIM_TYPE"));
				list.add(cover);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	public Object prepareClassMasterDetails(String code) {
		FacesContext context = FacesContext.getCurrentInstance();
		System.out.println(context.getExternalContext().getSessionMap());
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();
		HttpSession session = request.getSession();
		PM_IL_CLAIM_COVER_ACTION pi_lm_action = new PM_IL_CLAIM_COVER_ACTION();
		session.setAttribute("PILM038_PM_IL_CLAIM_COVER_ACTION", pi_lm_action);

		/* 
		 * new PILM038_CRUD().fetchClassDetails(code, pi_lm_action
		 * .getPM_IL_CLAIM_COVER_BEAN());
		 */
		return "";
	}

	public void deleteRow(ActionEvent event) throws Exception{
		System.out.println("SearchPageDetailsAction.DeleteRow()");
		//PolicyDetails valuebean = null;
		
		PM_IL_CLAIM_COVER valuebean = null;
		int DeletedRecordIndex = 0;
		Connection connection = CommonUtils.getConnection();
		System.out.println("************************");
		System.out.println(nameList.size()); 
		System.out.println("************************");
		if(nameList != null){
			for(int index =0 ;index<nameList.size();){
				valuebean = nameList.get(index);
				System.out.println("ValueBean" +valuebean.toString());
				System.out.println("DataGridAction.deleteRow()-(bean.isCHECK_BOX()"+valuebean.isCHECK_BOX());
				if(valuebean.isCHECK_BOX()){
					nameList.remove(valuebean);
					int n = handler.executeDelete(valuebean, connection);
					System.out.println("PM_IL_CLAIM_COVER_ACTION.deleteRow()-n"+n);
					connection.commit();
				}else{
					System.out.println("Else_Part_In_Action");
					index++;
				}
			}

		}
	}

	public ArrayList<PM_IL_CLAIM_COVER> getNameList() {
		return nameList;
	}

	public PM_IL_CLAIM_COVER getName() {
		return name;
	}

	public void setNameList(ArrayList<PM_IL_CLAIM_COVER> nameList) {
		this.nameList = nameList;
	}

	public void setName(PM_IL_CLAIM_COVER name) {
		this.name = name;
	}

	public List getClaim_Type_List() {
		return claim_Type_List;
	}

	public void setClaim_Type_List(List<SelectItem> claim_Type_List) {
		this.claim_Type_List = claim_Type_List;
	}
	
	public void setDescription(ActionEvent event){
		UIInput input = (UIInput) event.getComponent().getParent();
		String CLAIM_TYPE = (String) input.getSubmittedValue();
		String query = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE = 'IL_CLM_TYPE' AND PS_CODE = ?";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		String claimTypeDesc = null;
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{CLAIM_TYPE});
			while(rst.next()){
				claimTypeDesc = rst.getString(1);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
		}
		getCLAIM_TYPE_DESC().setSubmittedValue(claimTypeDesc);
		setInitClassname(claimTypeDesc);
	}

}
