package com.iii.pel.forms.HIERARCHY_REPORT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.common.workflow.PGIM_WORKFLOW_BUCKET;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class HIERARCHY_REPORT_ACTION extends CommonAction{
	private List<PGIM_WORKFLOW_BUCKET> taskList;
	private List<HIERARCHY_REPORT> pendingList;
	private HIERARCHY_REPORT HIERARCHY_REPORT_BEAN;
	private UIData dataTable;
	private UIData taskDataTable;
	private List<SelectItem> assignedToList = new ArrayList<SelectItem>();
	HIERARCHY_REPORT_HELPER helper;
	private HtmlOutputText COMP_TASK_COUNT;
	private PGIM_WORKFLOW_BUCKET PGIM_WORKFLOW_BUCKET_BEAN;
	private boolean visible = false;
	private HtmlCommandButton COMP_SAVE_BUTTON;
	/*Added by kavitha on 31.10.2019 for RoadMap*/
	private UIData unAssignedTaskDataTable;
	private List<PGIM_WORKFLOW_BUCKET> unAssignedTaskList;
	public HIERARCHY_REPORT_ACTION(){
		HIERARCHY_REPORT_BEAN = new HIERARCHY_REPORT();
		PGIM_WORKFLOW_BUCKET_BEAN = new PGIM_WORKFLOW_BUCKET();
		helper= new HIERARCHY_REPORT_HELPER();
		
	}
	
	public void setUser(ActionEvent event) {
		try{
			CommonUtils.clearMaps(this);
			String labelName = (String)((UIInput)(event.getComponent().getParent())).getSubmittedValue();
			int currentIndex = this.dataTable.getRowIndex();
			HIERARCHY_REPORT_BEAN = (HIERARCHY_REPORT) pendingList.get(currentIndex);
			getUser(labelName);
			
			HIERARCHY_REPORT_BEAN.setUser(labelName);
			pendingList.set(currentIndex, HIERARCHY_REPORT_BEAN);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void onLoad(PhaseEvent event){
		try {
			FacesContext ctx = FacesContext.getCurrentInstance();
			HttpServletRequest req = (HttpServletRequest) ctx.getExternalContext().getRequest();
			String PWB_WORKSTEP_ID = req.getParameter("PWB_WORKSTEP_ID");
			String userId = req.getParameter("USER_ID");
			String deptCode = req.getParameter("DEPT_CODE");
			String sysId = req.getParameter("PWTH_SYS_ID");
			if(userId!=null){
				Connection connection = CommonUtils.getConnection();
				setAssignedToList(getDropDownListValue(connection,userId));
				CommonUtils.getConnection().commit();
			  pendingList = helper.pendingList(PWB_WORKSTEP_ID, userId, deptCode,sysId, HIERARCHY_REPORT_BEAN);
			  if(pendingList.get(0).getClaimNumber()!= null){
					visible = true;
			  }else{
				    visible = false;
			  }
			}
			taskList=helper.getTaskBucket();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String onDisplay(){
		String output = null;
		try{
			output ="HIERARCHY_REPORT_DETAILS";
		}catch(Exception e){
			e.printStackTrace();
		}
		return output;
	}

	public static List<SelectItem> getDropDownListValue(Connection connection,String userId){
		List<SelectItem> listValues = null;
		String query = "SELECT * FROM MENU_USER WHERE USER_GROUP_ID IN (SELECT USER_GROUP_ID FROM MENU_USER WHERE USER_ID ='"+userId+"')" ;
		CRUDHandler handler = null;
			try {
				handler = new CRUDHandler();
				ResultSet rst = handler.executeSelectStatement(query, connection);
				listValues = new ArrayList<SelectItem>();
				
				while(rst.next()){
					listValues.add(new SelectItem(rst.getString("USER_ID")));
				}
				rst.close();
				rst.getStatement().close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		return listValues;
	}
	
	public String backButton() throws Exception{
		getErrorMap().clear();
		getWarningMap().clear();
		System.out.println("getTaskList              "+getPendingList().size());
		return "login";
		
	}
	
    public void saveRecord(){
		
		String message = null;
		CommonUtils.clearMaps(this);
		getErrorMap().clear();
		getWarningMap().clear();
		String UpdateQuery="UPDATE PGIW_WF_TRAN_HDR SET PWTH_USER_ID = ? WHERE PWTH_SYS_ID = ?";
		String UpdateQuery1="UPDATE PGIW_WF_TRAN_DTLS SET PWTD_CR_DT = SYSDATE WHERE PWTD_PWTH_SYS_ID = ?";
		try {
					System.out.println("HIERARCHY_REPORT_BEAN.getUser()                             "+HIERARCHY_REPORT_BEAN.getUser());
					System.out.println("HIERARCHY_REPORT_BEAN.getSysId()                                "+HIERARCHY_REPORT_BEAN.getSysId());
					
					new CRUDHandler().executeUpdateStatement(UpdateQuery,CommonUtils.getConnection(),
							new Object[]{HIERARCHY_REPORT_BEAN.getUser(),HIERARCHY_REPORT_BEAN.getSysId()});
					
					new CRUDHandler().executeUpdateStatement(UpdateQuery1,CommonUtils.getConnection(),
							new Object[]{HIERARCHY_REPORT_BEAN.getSysId()});
					
					CommonUtils.getConnection().commit();
					message = Messages.getString("messageProperties",
							"errorPanel$message$save");
					getWarningMap()
							.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
									message);
					getWarningMap().put("SAVE", message);
					
	    } catch (Exception e) {
			e.printStackTrace();
			String error = ErrorHelpUtil
					.getUserErrorMessageFromDBErrorMessage(e.getMessage());
			getErrorMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, error);
			getErrorMap().put("SAVE", error);

		}
	}
    
    
    
	
	
	public void getUser(String labelName){
		String user = null;
		Connection con = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		try {
				String C1 = "SELECT * FROM PGIW_WF_TRAN_HDR WHERE PWTH_SYS_ID= ? ";
				con = CommonUtils.getConnection();
				rs1 = handler.executeSelectStatement(C1, con,
						new Object[] {HIERARCHY_REPORT_BEAN.getSysId()});
				while (rs1.next()) {
					user = rs1.getString("PWTH_USER_ID");
					//System.out.println("#########################################"+user);
				}
				if(labelName.equals(user)){
					COMP_SAVE_BUTTON.setDisabled(true);
				}else{
					COMP_SAVE_BUTTON.setDisabled(false);
				}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
					
	}
	
	public List<PGIM_WORKFLOW_BUCKET> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<PGIM_WORKFLOW_BUCKET> taskList) {
		this.taskList = taskList;
	}
	
	public List<HIERARCHY_REPORT> getPendingList() {
		return pendingList;
	}

	public void setPendingList(List<HIERARCHY_REPORT> pendingList) {
		this.pendingList = pendingList;
	}
	
	public HIERARCHY_REPORT getHIERARCHY_REPORT_BEAN() {
		return HIERARCHY_REPORT_BEAN;
	}

	public void setHIERARCHY_REPORT_BEAN(HIERARCHY_REPORT hIERARCHY_REPORT_BEAN) {
		HIERARCHY_REPORT_BEAN = hIERARCHY_REPORT_BEAN;
	}
	
	public UIData getDataTable() {
		return dataTable;
	}
	
	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getTaskDataTable() {
		return taskDataTable;
	}

	public void setTaskDataTable(UIData taskDataTable) {
		this.taskDataTable = taskDataTable;
	}

	public HtmlOutputText getCOMP_TASK_COUNT() {
		return COMP_TASK_COUNT;
	}

	public void setCOMP_TASK_COUNT(HtmlOutputText cOMP_TASK_COUNT) {
		COMP_TASK_COUNT = cOMP_TASK_COUNT;
	}

	public PGIM_WORKFLOW_BUCKET getPGIM_WORKFLOW_BUCKET_BEAN() {
		return PGIM_WORKFLOW_BUCKET_BEAN;
	}

	public void setPGIM_WORKFLOW_BUCKET_BEAN(
			PGIM_WORKFLOW_BUCKET pGIM_WORKFLOW_BUCKET_BEAN) {
		PGIM_WORKFLOW_BUCKET_BEAN = pGIM_WORKFLOW_BUCKET_BEAN;
	}
	
	public List<SelectItem> getAssignedToList() {
		return assignedToList;
	}

	public void setAssignedToList(List<SelectItem> assignedToList) {
		this.assignedToList = assignedToList;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public HtmlCommandButton getCOMP_SAVE_BUTTON() {
		return COMP_SAVE_BUTTON;
	}

	public void setCOMP_SAVE_BUTTON(HtmlCommandButton cOMP_SAVE_BUTTON) {
		COMP_SAVE_BUTTON = cOMP_SAVE_BUTTON;
	}

	public UIData getUnAssignedTaskDataTable() {
		return unAssignedTaskDataTable;
	}

	public void setUnAssignedTaskDataTable(UIData unAssignedTaskDataTable) {
		this.unAssignedTaskDataTable = unAssignedTaskDataTable;
	}

	public List<PGIM_WORKFLOW_BUCKET> getUnAssignedTaskList() {
		return unAssignedTaskList;
	}

	public void setUnAssignedTaskList(List<PGIM_WORKFLOW_BUCKET> unAssignedTaskList) {
		this.unAssignedTaskList = unAssignedTaskList;
	}

}
