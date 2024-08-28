package com.iii.pel.forms.PILM202;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM085_APAC.PM_IL_ANNUITY_PYMT_SETUP_ACTION;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.commonimpl.searchpageimpl.SearchConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_AGE_SLAB_SEARCH_ACTION extends CommonAction {
	private HtmlOutputLabel COMP_AS_CODE_LABEL;

	private HtmlInputText COMP_AS_CODE;

	private List<PM_IL_AGE_SLAB_SEARCH_BEAN> classMasterList;	

	PM_IL_AGE_SLAB_SEARCH_BEAN bean;
	PM_IL_AGE_SLAB_ACTION action = null;

	public PM_IL_AGE_SLAB_SEARCH_ACTION(){
		action = new PM_IL_AGE_SLAB_ACTION();
		bean=new PM_IL_AGE_SLAB_SEARCH_BEAN();
		classMasterList= new ArrayList<PM_IL_AGE_SLAB_SEARCH_BEAN>();

	}
	public HtmlOutputLabel getCOMP_AS_CODE_LABEL() {
		return COMP_AS_CODE_LABEL;
	}
	public void setCOMP_AS_CODE_LABEL(HtmlOutputLabel comp_as_code_label) {
		COMP_AS_CODE_LABEL = comp_as_code_label;
	}
	public HtmlInputText getCOMP_AS_CODE() {
		return COMP_AS_CODE;
	}
	public void setCOMP_AS_CODE(HtmlInputText comp_as_code) {
		COMP_AS_CODE = comp_as_code;
	}

	public String fetchDetails() throws Exception{
		classMasterList.clear();
		System.out.println("PM_IL_AGE_SLAB_SEARCH_ACTION.fetchDetails( from beannn "+bean.getASS_CODE());
		String query="SELECT PM_IL_AGE_SLAB.ROWID,PM_IL_AGE_SLAB.* FROM PM_IL_AGE_SLAB";
		String code=bean.getASS_CODE();
		if(! "".equals(code.trim()) || code.trim().length()>0){
			query=query+" WHERE UPPER(AS_CODE) LIKE "+ "'"+ code.toUpperCase() + "%'";
		}
		CRUDHandler handler =new CRUDHandler();
		System.out.println("PM_IL_AGE_SLAB_SEARCH_ACTION.fetchDetails() in if loppppppppppp "+query);
		ResultSet rs=handler.executeSelectStatement(query,CommonUtils.getConnection());
		PM_IL_AGE_SLAB_SEARCH_BEAN table;
		while(rs.next()){
			table=new PM_IL_AGE_SLAB_SEARCH_BEAN();
			table.setASS_CODE(rs.getString("AS_CODE"));
			table.setASS_DESC(rs.getString("AS_DESC"));
			table.setASS_MIN_AGE(rs.getInt("AS_MIN_AGE"));
			table.setASS_MAX_AGE(rs.getInt("AS_MAX_AGE"));
			table.setROWID(rs.getString("ROWID"));
			classMasterList.add(table);

		}
		if(this.classMasterList.size()==0){
			getWarningMap().put("current", "There is no record for this search criteria");
			}else{
				getWarningMap().clear();
			}
		return "";
	}
	public String showDetails(String rowid,PM_IL_AGE_SLAB_ACTION actionBean)  {
		try{
		String selectQuery = "Select PM_IL_AGE_SLAB.ROWID,PM_IL_AGE_SLAB.* FROM PM_IL_AGE_SLAB where ROWID='"+rowid+"'";
		CRUDHandler handler = new CRUDHandler();
		List list = handler.fetch(selectQuery, "com.iii.pel.forms.PILM202.PM_IL_AGE_SLAB", CommonUtils.getConnection());
		PM_IL_AGE_SLAB dtl = (PM_IL_AGE_SLAB) list.get(0);
		if(dtl.getAS_FRZ_FLAG().trim().equals("Y")){
			dtl.setCHECK_BOX(true);
			//getCOMP_AS_FRZ_FLAG().setSelected(true);
		}
		actionBean.setPM_IL_AGE_SLAB_BEAN(dtl);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "PILM202_MASTER";
	}
	public String forInsertion(){
		System.out.println("PM_IL_AGE_SLAB_SEARCH_ACTION.forInsertion() entered ?//********");
		FacesContext context=FacesContext.getCurrentInstance();
		Map<String, Object> sessionMap =context.getExternalContext().getSessionMap();
		sessionMap.put("mode", "insert");
		HttpServletRequest request=(HttpServletRequest)context.getExternalContext().getRequest();
		HttpSession session=request.getSession();
		if(session.getAttribute("PILM202_PM_IL_AGE_SLAB_ACTION")!=null){
			System.out.println("PM_IL_AGE_SLAB_SEARCH_ACTION.forInsertion()>>?????********");
			session.removeAttribute("PILM202_PM_IL_AGE_SLAB_ACTION");
		}
		return "PILM202_MASTER";	
	}
	public List<PM_IL_AGE_SLAB_SEARCH_BEAN> getClassMasterList() {
		return classMasterList;
	}
	public void setClassMasterList(List<PM_IL_AGE_SLAB_SEARCH_BEAN> classMasterList) {
		this.classMasterList = classMasterList;
	}
	public PM_IL_AGE_SLAB_SEARCH_BEAN getBean() {
		return bean;
	}
	public void setBean(PM_IL_AGE_SLAB_SEARCH_BEAN bean) {
		this.bean = bean;
	}
	public void delete(ActionEvent ae) throws Exception{
		System.out.println("PM_IL_AGE_SLAB_SEARCH_ACTION.delete() beginningg");
		PM_IL_AGE_SLAB_SEARCH_BEAN bean = null;
		if(classMasterList!=null){
			for(int index =0; index<classMasterList.size();){
				bean = classMasterList.get(index);
				if(bean.isCHECK_BOX()){
					classMasterList.remove(bean);
					CRUDHandler handler=new CRUDHandler();
					String deleteQuery="DELETE FROM PM_IL_AGE_SLAB WHERE ROWID='"+bean.getROWID()+"'";
					System.out.println("PM_IL_AGE_SLAB_SEARCH_ACTION.delete() "+deleteQuery);
					handler.executeDeleteStatement(deleteQuery,CommonUtils.getConnection() );
				}else{
					index++;
				}

			}
		}
		CommonUtils.getConnection().commit();
	}
	public void checkBoxStatus(ActionEvent ae){
		System.out.println("PM_IL_AGE_SLAB_SEARCH_ACTION.checkBoxStatus() ^^^^******");
	}
	
	public String updateButtonAction(String rowId){
		String outcome = null;
		try{
		PM_IL_AGE_SLAB_ACTION action = new PM_IL_AGE_SLAB_ACTION();
		action.getPM_IL_AGE_SLAB_BEAN().setROWID(rowId);
		//showDetails(rowId, action);
		//action.setBlockFlag(true);
		CommonUtils.setGlobalObject("PILM202_PM_IL_AGE_SLAB_ACTION", action);
		outcome = "PILM202_MASTER";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return outcome;
	}
	
	public String insertButtonAction() throws Exception{
		PM_IL_AGE_SLAB_ACTION action = new PM_IL_AGE_SLAB_ACTION();
		String outcome = null;
		//action.setBlockFlag(true);
		CommonUtils.setGlobalObject("PILM202_PM_IL_AGE_SLAB_ACTION", action);
		outcome = "PILM202_MASTER";
		return outcome;

	}
	public String backToSearch() {
		CommonUtils.setGlobalObject("PILM202_PM_IL_AGE_SLAB_ACTION", null);
		return SearchConstants.BACK_TO_SEARCH_PAGE;

	}
}
