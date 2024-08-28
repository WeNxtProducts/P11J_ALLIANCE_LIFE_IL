package com.iii.pel.forms.HIERARCHY_REPORT;

import java.util.ArrayList;
import java.util.List;

import javax.faces.event.PhaseEvent;

import org.richfaces.model.TreeNode;
import org.richfaces.model.TreeNodeImpl;

import com.iii.pel.common.workflow.PGIM_WORKFLOW_BUCKET;
import com.iii.pel.forms.GNMNF005_A_APAC.MENU_USER;
import com.iii.pel.forms.GNMNF005_A_APAC.MENU_USER_REPT_HIER;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.utils.CommonUtils;
/* Added by kavitha for RoadMap*/
public class REPORTING_TREE_ACTION extends CommonAction{
	private TreeNode rootNode = null;
	private List<PGIM_WORKFLOW_BUCKET> reportingToList = new ArrayList<PGIM_WORKFLOW_BUCKET>();
	private REPORTING_TREE_HELPER helper;
	private PGIM_WORKFLOW_BUCKET PGIM_WORKFLOW_BUCKET_BEAN;
	private MENU_USER_REPT_HIER MENU_USER_REPT_HIER_BEAN;
	private MENU_USER MENU_USER_BEAN;
	
	public void onLoad(PhaseEvent phaseEvent) {
		if (isBlockFlag()) {
			try {
				String currUserId = (String) CommonUtils.getGlobalVariable("USER_ID");
				setReportingToList(helper.loadReportingList(this, currUserId));
				setRootNode(addNodesToRootNode());
				
				rootNode = addNodesToRootNode();
			} catch (Exception e) {
				e.printStackTrace();
				try {
					throw e;
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			setBlockFlag(false);
		}
	}
	
	
	public REPORTING_TREE_ACTION(){
		MENU_USER_BEAN = new MENU_USER();
		PGIM_WORKFLOW_BUCKET_BEAN = new PGIM_WORKFLOW_BUCKET();
		helper = new REPORTING_TREE_HELPER();
	}

	public String mainButAction() {
		String outCome = null;
		outCome = "GNMNF005_A_APAC_MENU_USER";
		setBlockFlag(true);
		return outCome;
	}
	public TreeNode addNodesToRootNode() {
		TreeNodeImpl rootNode = new TreeNodeImpl();
		TreeNodeImpl childNode = new TreeNodeImpl();

		List<TreeNodeImpl> nodesList = new ArrayList<TreeNodeImpl>();

		TreeNodeImpl node = null;
		String currUserId = (String) CommonUtils.getGlobalVariable("USER_ID");
		System.out.println("currUserId                                      "+currUserId);
		
		for (int i = reportingToList.size()-1 ; i >=0 ; i--) {
			node = new TreeNodeImpl();
			node.setData(reportingToList.get(i).getAssignedTo());
			nodesList.add(node);
		}
		
		if(currUserId != null && currUserId.length() > 0){
			node = new TreeNodeImpl();
			node.setData(currUserId);
			nodesList.add(node);
		}
		for (int i = 0; i < nodesList.size() ; i++) {
			if (i == 0) {
				rootNode.addChild(i + 1, nodesList.get(i));
			} 
			else
			{
				if(i == nodesList.size() -1){
					nodesList.get(i - 1).addChild(i + 1, nodesList.get(i));
				}else {
					if (reportingToList.get(i - 1).getAssignedTo() != reportingToList.get(i)
							.getUSER_ID()) {
						nodesList.get(i - 1).addChild(i + 1, nodesList.get(i));
					}
				}
			}
				
			
		}
		return rootNode;

	}
	public TreeNode getRootNode() {
		return rootNode;
	}

	public void setRootNode(TreeNode rootNode) {
		this.rootNode = rootNode;
	}


	public MENU_USER_REPT_HIER getMENU_USER_REPT_HIER_BEAN() {
		return MENU_USER_REPT_HIER_BEAN;
	}


	public void setMENU_USER_REPT_HIER_BEAN(MENU_USER_REPT_HIER mENU_USER_REPT_HIER_BEAN) {
		MENU_USER_REPT_HIER_BEAN = mENU_USER_REPT_HIER_BEAN;
	}


	public REPORTING_TREE_HELPER getHelper() {
		return helper;
	}


	public void setHelper(REPORTING_TREE_HELPER helper) {
		this.helper = helper;
	}


	public MENU_USER getMENU_USER_BEAN() {
		return MENU_USER_BEAN;
	}


	public void setMENU_USER_BEAN(MENU_USER mENU_USER_BEAN) {
		MENU_USER_BEAN = mENU_USER_BEAN;
	}


	public List<PGIM_WORKFLOW_BUCKET> getReportingToList() {
		return reportingToList;
	}


	public void setReportingToList(List<PGIM_WORKFLOW_BUCKET> reportingToList) {
		this.reportingToList = reportingToList;
	}


	public PGIM_WORKFLOW_BUCKET getPGIM_WORKFLOW_BUCKET_BEAN() {
		return PGIM_WORKFLOW_BUCKET_BEAN;
	}


	public void setPGIM_WORKFLOW_BUCKET_BEAN(PGIM_WORKFLOW_BUCKET pGIM_WORKFLOW_BUCKET_BEAN) {
		PGIM_WORKFLOW_BUCKET_BEAN = pGIM_WORKFLOW_BUCKET_BEAN;
	}

}
