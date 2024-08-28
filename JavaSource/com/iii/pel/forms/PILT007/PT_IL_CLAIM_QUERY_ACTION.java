package com.iii.pel.forms.PILT007;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM035_APAC.PILM035_APAC_COMPOSITE_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_CLAIM_QUERY_ACTION extends CommonAction implements Serializable, Cloneable {
	
	private HtmlOutputLabel COMP_CLAIM_NUMBER_LABEL;
	private HtmlInputText COMP_CLAIM_NUMBER;
	private HtmlOutputLabel COMP_POLICY_NUMBER_LABEL;
	private HtmlInputText COMP_POLICY_NUMBER;
	private HtmlCommandButton COMP_PT_IL_CLAIM_QUERY_BUTTON;
	private HtmlDataTable COMP_PT_IL_CLAIM_DATA_TABLE;
	private HtmlCommandButton COMP_M_PRE_FORM_BUTTON;
	private PT_IL_CLAIM PT_IL_CLAIM_BEAN;
	private List<PT_IL_CLAIM> CLAIM_QUERY_DATA_TABLE;
	private PT_IL_CLAIM_QUERY PT_IL_CLAIM_QUERY_BEAN;
	
	public PT_IL_CLAIM_QUERY_ACTION(){
		PT_IL_CLAIM_BEAN = new PT_IL_CLAIM();
		CLAIM_QUERY_DATA_TABLE = new ArrayList<PT_IL_CLAIM>();
		PT_IL_CLAIM_QUERY_BEAN = new PT_IL_CLAIM_QUERY();
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		sessionMap.put("PILT007_COMPOSITE_ACTION", new PILT007_COMPOSITE_ACTION());
	}

	public PT_IL_CLAIM_QUERY getPT_IL_CLAIM_QUERY_BEAN() {
		return PT_IL_CLAIM_QUERY_BEAN;
	}

	public void setPT_IL_CLAIM_QUERY_BEAN(PT_IL_CLAIM_QUERY pt_il_claim_query_bean) {
		PT_IL_CLAIM_QUERY_BEAN = pt_il_claim_query_bean;
	}

	public HtmlOutputLabel getCOMP_CLAIM_NUMBER_LABEL() {
		return COMP_CLAIM_NUMBER_LABEL;
	}

	public void setCOMP_CLAIM_NUMBER_LABEL(HtmlOutputLabel comp_claim_number_label) {
		COMP_CLAIM_NUMBER_LABEL = comp_claim_number_label;
	}

	public HtmlInputText getCOMP_CLAIM_NUMBER() {
		return COMP_CLAIM_NUMBER;
	}

	public void setCOMP_CLAIM_NUMBER(HtmlInputText comp_claim_number) {
		COMP_CLAIM_NUMBER = comp_claim_number;
	}

	public HtmlOutputLabel getCOMP_POLICY_NUMBER_LABEL() {
		return COMP_POLICY_NUMBER_LABEL;
	}

	public void setCOMP_POLICY_NUMBER_LABEL(HtmlOutputLabel comp_policy_number_label) {
		COMP_POLICY_NUMBER_LABEL = comp_policy_number_label;
	}

	public HtmlInputText getCOMP_POLICY_NUMBER() {
		return COMP_POLICY_NUMBER;
	}

	public void setCOMP_POLICY_NUMBER(HtmlInputText comp_policy_number) {
		COMP_POLICY_NUMBER = comp_policy_number;
	}

	public HtmlCommandButton getCOMP_PT_IL_CLAIM_QUERY_BUTTON() {
		return COMP_PT_IL_CLAIM_QUERY_BUTTON;
	}

	public void setCOMP_PT_IL_CLAIM_QUERY_BUTTON(
			HtmlCommandButton comp_pt_il_claim_query_button) {
		COMP_PT_IL_CLAIM_QUERY_BUTTON = comp_pt_il_claim_query_button;
	}

	public HtmlDataTable getCOMP_PT_IL_CLAIM_DATA_TABLE() {
		return COMP_PT_IL_CLAIM_DATA_TABLE;
	}

	public void setCOMP_PT_IL_CLAIM_DATA_TABLE(
			HtmlDataTable comp_pt_il_claim_data_table) {
		COMP_PT_IL_CLAIM_DATA_TABLE = comp_pt_il_claim_data_table;
	}

	public PT_IL_CLAIM getPT_IL_CLAIM_BEAN() {
		return PT_IL_CLAIM_BEAN;
	}

	public void setPT_IL_CLAIM_BEAN(PT_IL_CLAIM pt_il_claim_bean) {
		PT_IL_CLAIM_BEAN = pt_il_claim_bean;
	}

	public List<PT_IL_CLAIM> getCLAIM_QUERY_DATA_TABLE() {
		return CLAIM_QUERY_DATA_TABLE;
	}

	public void setCLAIM_QUERY_DATA_TABLE(List<PT_IL_CLAIM> claim_query_data_table) {
		CLAIM_QUERY_DATA_TABLE = claim_query_data_table;
	}
	
	public HtmlCommandButton getCOMP_M_PRE_FORM_BUTTON() {
		return COMP_M_PRE_FORM_BUTTON;
	}
	
	public void setCOMP_M_PRE_FORM_BUTTON(HtmlCommandButton comp_m_pre_form_button) {
		COMP_M_PRE_FORM_BUTTON = comp_m_pre_form_button;
	}
	
	Map<String, Object> session = null;
	//ControlBean ctrlBean  = null;
	FacesContext ctx= FacesContext.getCurrentInstance();
	
	/*public void createCtrlBean(FacesContext ctx){
		ControlBean bean = new ControlBean();
		session = ctx.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}*/
	public ControlBean getCtrlBean(){
		/*session =  ctx.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");*/
		
		return CommonUtils.getControlBean();
	}
	/*public void putCtrlBean(ControlBean bean){
		session =  ctx.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}*/
	
	public void onLoad(){
		COMP_M_PRE_FORM_BUTTON.setDisabled(true);
		
//		createCtrlBean(FacesContext.getCurrentInstance());
	}
	
	public String insertClaim(){
		return "claimInsert";
	}
	
	public void fetchRecords(){
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_CLAIM_QUERY_ACTION claimQueryAction = (PT_IL_CLAIM_QUERY_ACTION) sessionMap.get("PILT007_PT_IL_CLAIM_QUERY_ACTION");
		String claimNumber = claimQueryAction.getPT_IL_CLAIM_QUERY_BEAN().getCLAIM_NUMBER();
		String policyNumber = claimQueryAction.getPT_IL_CLAIM_QUERY_BEAN().getPOLICY_NUMBER();
		if(claimNumber!=null)
			claimNumber = "%"+claimNumber+"%";
		else
			claimNumber = "%";
		if(policyNumber!=null)
			policyNumber = "%"+policyNumber+"%";
		else
			policyNumber = "%";
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = PILT007_SQL_QUERY_CONSTANTS.PT_IL_CLAIM_QUERY_ACTION_QUERY1;
		System.out.println(selectQuery);
		System.out.println(policyNumber+"    "+claimNumber);
		Object[] values={policyNumber, claimNumber};
		List<PT_IL_CLAIM> claimList = null;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			rst = handler.executeSelectStatement(selectQuery, connection, values);
			PT_IL_CLAIM claimBean = null;
			claimList = new ArrayList<PT_IL_CLAIM>();
			while(rst.next()){
				claimBean = new PT_IL_CLAIM();
				claimBean.setCLAIM_SYS_ID(rst.getLong("CLAIM_SYS_ID"));
				claimBean.setCLAIM_POL_SYS_ID(rst.getLong("CLAIM_POL_SYS_ID"));
				claimBean.setCLAIM_POL_NO(rst.getString("CLAIM_POL_NO"));
				claimBean.setCLAIM_NO(rst.getString("CLAIM_NO"));
				claimBean.setCLAIM_ASSURED_CODE(rst.getString("POAD_ASSR_CODE"));
				claimBean.setUI_M_CLAIM_ASSURED_NAME(rst.getString("POAD_ASSURED_NAME"));
				claimList.add(claimBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(rst!= null){
					CommonUtils.closeCursor(rst);
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		claimQueryAction.setCLAIM_QUERY_DATA_TABLE(claimList);
	}
	
	public String updateRecord(){
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String claimNo = request.getParameter("CLAIM_NO");
		String claimSysId = request.getParameter("CLAIM_SYS_ID");
		String claimPolNo = request.getParameter("CLAIM_POL_NO");
		String claimPolSysId = request.getParameter("CLAIM_POL_SYS_ID");
		System.out.println("claimNo: "+claimNo);
		System.out.println("claimSysId: "+claimSysId);
		System.out.println("claimPolNo: "+claimPolNo);
		System.out.println("claimPolSysId: "+claimPolSysId);
		HttpSession session = request.getSession();
		session.setAttribute("GLOBAL.M_CLAIM_NO", claimNo);
		session.setAttribute("GLOBAL.CLAIM_SYS_ID", claimSysId);
		session.setAttribute("GLOBAL.M_CLAIM_POL_NO", claimPolNo);
	//	PILT007_COMPOSITE_ACTION compositeAction = PILT007_ACTION_INSTANCE.getCompositeActionInstance();
		PILT007_COMPOSITE_ACTION compositeAction = new PILT007_COMPOSITE_ACTION();
		PT_IL_CLAIM claimBean = compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN();
		claimBean.setCLAIM_NO(claimNo);
		claimBean.setCLAIM_SYS_ID(new Long(claimSysId==null?"0.0":claimSysId));
		claimBean.setCLAIM_POL_NO(claimPolNo);
		claimBean.setCLAIM_POL_SYS_ID(new Long(claimPolSysId==null?"0.0":claimPolSysId));
		return "claimToBePaid";//compositeAction.claimPaidAction();
	}
	
	public String updateButtonAction(String rowId) throws Exception {
		String outcome = null;
		try {
			PILT007_COMPOSITE_ACTION compositeAction = new PILT007_COMPOSITE_ACTION();
			CommonUtils.setGlobalObject("PILT007_COMPOSITE_ACTION",
					compositeAction);
			compositeAction.getPILT007_PT_IL_CLAIM_ACTION().getPT_IL_CLAIM_BEAN().setROWID(rowId);
			outcome = "GO_TO_PT_IL_CLAIM";

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return outcome;
	}
	
	public void queryData(){
		fetchRecords();
	}
	
	
	/*Added by Janani on 21.02.2017 for ZB search query*/
	
	public StringBuffer customizeQuery(StringBuffer query, ArrayList<Object> valueList){
    	int whereIndex = query.indexOf("WHERE")+6;
        	 
    	query.insert(whereIndex, " CLAIM_ADDL_STATUS IN ( 'CL05' ,'C')  AND ");
        	
    	return query;
    }
	/*End*/
	
}
