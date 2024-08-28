package com.iii.pel.forms.PILM063_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;

import org.richfaces.component.UIDataTable;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;

public class GroupThresholdLimitSearchPageAction extends CommonAction{
	private HtmlInputText GTH_GROUP_CODE;
	private HtmlInputText GTH_GROUP_DESC;
	private HtmlInputText GTH_GROUP_LONG_DESC;
	private GroupThresholdLimitSearchPageBean thresholdLimitSearchBean;
	private UIDataTable searchTable;
	ArrayList<GroupThresholdLimitSearchPageBean> searchList = new ArrayList<GroupThresholdLimitSearchPageBean>();
	
	public GroupThresholdLimitSearchPageAction() {
		thresholdLimitSearchBean = new GroupThresholdLimitSearchPageBean();
	}
	
	public HtmlInputText getGTH_GROUP_CODE() {
		return GTH_GROUP_CODE;
	}
	public void setGTH_GROUP_CODE(HtmlInputText gth_group_code) {
		GTH_GROUP_CODE = gth_group_code;
	}
	public HtmlInputText getGTH_GROUP_DESC() {
		return GTH_GROUP_DESC;
	}
	public void setGTH_GROUP_DESC(HtmlInputText gth_group_desc) {
		GTH_GROUP_DESC = gth_group_desc;
	}
	public HtmlInputText getGTH_GROUP_LONG_DESC() {
		return GTH_GROUP_LONG_DESC;
	}
	public void setGTH_GROUP_LONG_DESC(HtmlInputText gth_group_long_desc) {
		GTH_GROUP_LONG_DESC = gth_group_long_desc;
	}
	public GroupThresholdLimitSearchPageBean getThresholdLimitSearchBean() {
		return thresholdLimitSearchBean;
	}
	public void setThresholdLimitSearchBean(
			GroupThresholdLimitSearchPageBean thresholdLimitSearchBean) {
		this.thresholdLimitSearchBean = thresholdLimitSearchBean;
	}
	public UIDataTable getSearchTable() {
		return searchTable;
	}
	public void setSearchTable(UIDataTable searchTable) {
		this.searchTable = searchTable;
	}
	public ArrayList<GroupThresholdLimitSearchPageBean> getSearchList() {
		GroupThresholdLimitSearchPageBean bean = new GroupThresholdLimitSearchPageBean();
		searchList.add(bean);
		return searchList;
	}
	public void setSearchList(
			ArrayList<GroupThresholdLimitSearchPageBean> searchList) {
		this.searchList = searchList;
	}
	
	public String executeQuery() throws Exception{
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
		System.out.println("Parameter ROWID = "+req.getParameter("rowID"));
		String query = "SELECT GTH_GROUP_CODE FROM PM_IL_GROUP_THRESHOLD_HDR WHERE ROWID = '"+req.getParameter("rowID")+"'";
		String GTH_GROUP_CODE = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = handler.executeSelectStatement(query, getConnection());
		while(rs.next()){
			GTH_GROUP_CODE = rs.getString(1);
		}

		CommonUtils.closeCursor(rs);
		/** Hearder Block Code Starts Here */
		String headerQuery = "SELECT ROWID,GTH_GROUP_DESC,GTH_GROUP_SHORT_DESC,GTH_GROUP_LONG_DESC,GTH_VALIDATION_CODE from PM_IL_GROUP_THRESHOLD_HDR WHERE GTH_GROUP_CODE='"+GTH_GROUP_CODE+"'";
		ResultSet headerResult = handler.executeSelectStatement(headerQuery, getConnection());
		
		String GTH_GROUP_DESC = null;
		String GTH_GROUP_SHORT_DESC = null;
		String GTH_GROUP_LONG_DESC = null;
		String GTH_VALIDATION_CODE = null;
		String ROWID = null;
		
		while(headerResult.next()){
			ROWID = headerResult.getString(1);
			GTH_GROUP_DESC = headerResult.getString(2);
			GTH_GROUP_SHORT_DESC = headerResult.getString(3);
			GTH_GROUP_LONG_DESC = headerResult.getString(4);
			GTH_VALIDATION_CODE = headerResult.getString(5);
		}
		CommonUtils.closeCursor(headerResult);
		PM_IL_GROUP_THRESHOLD_HDR_ACTION headerAction = new PM_IL_GROUP_THRESHOLD_HDR_ACTION();
		PM_IL_GROUP_THRESHOLD_HDR thresholdHdrBean = headerAction.getPM_IL_GROUP_THRESHOLD_HDR_BEAN();
		thresholdHdrBean.setGTH_GROUP_CODE(GTH_GROUP_CODE);
		thresholdHdrBean.setGTH_GROUP_DESC(GTH_GROUP_DESC);
		thresholdHdrBean.setGTH_GROUP_SHORT_DESC(GTH_GROUP_SHORT_DESC);
		thresholdHdrBean.setGTH_GROUP_LONG_DESC(GTH_GROUP_LONG_DESC);
		thresholdHdrBean.setGTH_VALIDATION_CODE(GTH_VALIDATION_CODE);
		thresholdHdrBean.setUI_M_GTH_VALIDATION_CODE_DESC(HDR_POST_QUERY(GTH_VALIDATION_CODE));
		thresholdHdrBean.setROWID(ROWID);
		
		sessionMap.put("PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION", headerAction);
		
		/** Hearder Block Code Ends Here */
		
		/** Detail Block Code Starts Here */
//		String detailQuery = "select A.GTD_COVER_CODE from PM_IL_GROUP_THRESHOLD_DTL A,PM_IL_GROUP_THRESHOLD_HDR B where A.GTD_GROUP_CODE = '"+GTH_GROUP_CODE+"'";
		
		/*String detailQuery = "select distinct A.GTD_COVER_CODE,C.COVER_DESC,C.COVER_CODE " +
		"from PM_IL_GROUP_THRESHOLD_DTL A,PM_IL_GROUP_THRESHOLD_HDR B,PM_IL_COVER C "+ 
		"where A.GTD_GROUP_CODE = '"+GTH_GROUP_CODE+"' AND C.COVER_CODE = A.GTD_COVER_CODE";*/
		
		String detailQuery = "select distinct A.GTD_COVER_CODE,C.COVER_DESC,C.COVER_CODE,A.ROWID,A.GTD_GROUP_CODE " +
				"from PM_IL_GROUP_THRESHOLD_DTL A,PM_IL_GROUP_THRESHOLD_HDR B,PM_IL_COVER C "+ 
				"where A.GTD_GROUP_CODE = '"+GTH_GROUP_CODE+"' AND C.COVER_CODE = A.GTD_COVER_CODE";
		
		ResultSet detailResult = handler.executeSelectStatement(detailQuery, getConnection());
		String GTD_COVER_CODE = null;
		String COVER_DESC = null;
		String rowid = null;
		String GTD_GROUP_CODE = null;
		PM_IL_GROUP_THRESHOLD_DTL_ACTION detailAction = new PM_IL_GROUP_THRESHOLD_DTL_ACTION();
		ArrayList<PM_IL_GROUP_THRESHOLD_DTL> detailList = detailAction.getDetailsList();
		
		while(detailResult.next()){
			GTD_COVER_CODE = detailResult.getString(1);
			COVER_DESC = detailResult.getString(2);
			rowid = detailResult.getString(4);
			GTD_GROUP_CODE = detailResult.getString(5);
			PM_IL_GROUP_THRESHOLD_DTL detailBean = new PM_IL_GROUP_THRESHOLD_DTL();
			detailBean.setGTD_COVER_CODE(GTD_COVER_CODE);
			detailBean.setUI_M_GTD_COVER_CODE_DESC(COVER_DESC);
			detailBean.setROWID(rowid);
			detailBean.setGTD_GROUP_CODE(GTD_GROUP_CODE);
			detailBean.setRowSelected(false);
			detailList.add(detailBean);
		}
		
		detailAction.setDetailsList(detailList);
		if (detailList.size() !=0){					
			detailAction.setPM_IL_GROUP_THRESHOLD_DTL_BEAN(detailList.get(0));
			detailAction.getPM_IL_GROUP_THRESHOLD_DTL_BEAN().setRowSelected(true);
		}
		CommonUtils.closeCursor(detailResult);
		sessionMap.put("PILM063_APAC_PM_IL_GROUP_THRESHOLD_DTL_ACTION", detailAction);
		
		return "PILM063_APAC_GroupThresholdHdr";
	}	
	/** Detail Block Code Ends Here */
	public void searchedData(ActionEvent ae){
		ResultSet rs = null;
		try {
			searchList.clear();
			String query = "SELECT ROWID,GTH_GROUP_CODE,GTH_GROUP_DESC,GTH_GROUP_LONG_DESC FROM PM_IL_GROUP_THRESHOLD_HDR WHERE GTH_GROUP_CODE LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_CODE()+"%' AND GTH_GROUP_DESC LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_DESC()+"%'";
			System.out.println("Query = "+query);
//			String query = "SELECT ROWID,GTH_GROUP_CODE,GTH_GROUP_DESC,GTH_GROUP_LONG_DESC FROM PM_IL_GROUP_THRESHOLD_HDR WHERE GTH_GROUP_CODE LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_CODE()+"%' AND GTH_GROUP_DESC LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_DESC()+"%' AND GTH_GROUP_LONG_DESC LIKE '"+thresholdLimitSearchBean.getGTH_GROUP_LONG_DESC()+"%'";
			CRUDHandler handler = new CRUDHandler();
			rs = handler.executeSelectStatement(query, getConnection());
			while(rs.next()){
				GroupThresholdLimitSearchPageBean bean = new GroupThresholdLimitSearchPageBean();
				bean.setRowId(rs.getString(1));
				bean.setGTH_GROUP_CODE(rs.getString(2));
				bean.setGTH_GROUP_DESC(rs.getString(3));
//				bean.setGTH_GROUP_LONG_DESC(rs.getString(4));
				searchList.add(bean);
			}
			
			if(searchList.size() == 0){
				getWarningMap().put("current", "There is no record for this search criteria");
			}else{
				getWarningMap().clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/** Database Connection*/
	private Connection getConnection() throws Exception{
		Connection con = CommonUtils.getConnection();
		return con;
	}
	/** Database Connection*/
	
	/** Navigation To Insert Data is Handled Here. */
	public String insertNavigation(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap = ctx.getExternalContext().getSessionMap();
		
		PM_IL_GROUP_THRESHOLD_HDR_ACTION headerAct = new PM_IL_GROUP_THRESHOLD_HDR_ACTION();
		sessionMap.put("PILM063_APAC_PM_IL_GROUP_THRESHOLD_HDR_ACTION", headerAct);
		return "PILM063_APAC_GTLHDRInsert";
	}
	/** Navigation To Insert Data is Handled Here. 
	 * @throws Exception 
	 * @throws Exception */
	
	private String HDR_POST_QUERY(String code) throws Exception{
		String codeDesc = P_VAL_CODES("IL_VAL_TAR", code, "", "N", "E", null);
		return codeDesc;
	}
	
	private String P_VAL_CODES(String var1,String var2,String var3,String var4,String var5,String var6) throws Exception{
		OracleProcedureHandler procHandler = new OracleProcedureHandler();
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		String result = "";
		
		Connection con = getConnection();
		OracleParameter param1 = new OracleParameter("in1","STRING","IN",var1);
		OracleParameter param2 = new OracleParameter("in2","STRING","IN",var2);
		OracleParameter param3 = new OracleParameter("in3","STRING","IN OUT",var3);
		OracleParameter param4 = new OracleParameter("in4","STRING","IN",var4);
		OracleParameter param5 = new OracleParameter("in5","STRING","IN",var5);
		OracleParameter param6 = new OracleParameter("in6","STRING","IN",var6);
		
		paramList.add(param1);paramList.add(param2);paramList.add(param3);
		paramList.add(param4);paramList.add(param5);paramList.add(param6);
		try{
			List resultList = procHandler.execute(paramList, con, "P_VAL_CODES");
			Iterator iterator = resultList.iterator();
			while(iterator.hasNext()){
				OracleParameter object = (OracleParameter) iterator.next();
				if(object.getFieldName().equals("in3")){
					result = object.getValue();
				}
			}
		}catch (Exception e) {}
		return result;
	}
}
