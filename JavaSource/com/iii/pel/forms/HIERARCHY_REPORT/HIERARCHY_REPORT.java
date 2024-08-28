package com.iii.pel.forms.HIERARCHY_REPORT;

import java.util.ArrayList;
import java.util.Date;

import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;
/* Added by kavitha for RoadMap*/
public class HIERARCHY_REPORT extends BaseValueBean  {
	private int rowNo;
	private String policyNo;
	private ArrayList<String> usersList;
	private String user;
	private String sysId;
	private String claimNumber;
	private Date taskAssignedDate;
	private Date taskDueDate;
	
	private String UI_M_TASK_ASSIGNED_DT;
	private String UI_M_TASK_DUE_DT;
	
	public int getRowNo() {
		return rowNo;
	}
	public void setRowNo(int rowNo) {
		this.rowNo = rowNo;
	}
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public ArrayList<String> getUsersList() {
		return usersList;
	}
	public void setUsersList(ArrayList<String> usersList) {
		this.usersList = usersList;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSysId() {
		return sysId;
	}
	public void setSysId(String sysId) {
		this.sysId = sysId;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	
	public Date getTaskAssignedDate() {
		return taskAssignedDate;
	}
	public void setTaskAssignedDate(Date taskAssignedDate) {
		UI_M_TASK_ASSIGNED_DT = CommonUtils.dateToPELStringFormatterWithTimeStamp(taskAssignedDate);
		this.taskAssignedDate = taskAssignedDate;
	}
	public Date getTaskDueDate() {
		return taskDueDate;
	}
	public void setTaskDueDate(Date taskDueDate) {
		UI_M_TASK_DUE_DT = CommonUtils.dateToPELStringFormatterWithTimeStamp(taskDueDate);
		this.taskDueDate = taskDueDate;
	}
	public String getUI_M_TASK_DUE_DT() {
		return UI_M_TASK_DUE_DT;
	}
	public void setUI_M_TASK_DUE_DT(String uI_M_TASK_DUE_DT) {
		UI_M_TASK_DUE_DT = uI_M_TASK_DUE_DT;
	}
	public String getUI_M_TASK_ASSIGNED_DT() {
		return UI_M_TASK_ASSIGNED_DT;
	}
	public void setUI_M_TASK_ASSIGNED_DT(String uI_M_TASK_ASSIGNED_DT) {
		UI_M_TASK_ASSIGNED_DT = uI_M_TASK_ASSIGNED_DT;
	}
	
	
	
}
