package com.iii.pel.forms.HIERARCHY_REPORT;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.common.workflow.PGIM_WORKFLOW_BUCKET;
import com.iii.premia.common.utils.CommonUtils;
/* Added by kavitha for RoadMap*/
public class REPORTING_TREE_HELPER {
	public List<PGIM_WORKFLOW_BUCKET> loadReportingList(REPORTING_TREE_ACTION treeActionBean, String currUserId) throws Exception {
		List<PGIM_WORKFLOW_BUCKET> headerList = new ArrayList<PGIM_WORKFLOW_BUCKET>();
		String query = null;
		Connection con = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		try{
			con = CommonUtils.getConnection();
			query = "SELECT * FROM MENU_USER_REPT_HIER WHERE RH_USER_ID=? AND (TRUNC(SYSDATE) BETWEEN RH_EFF_DT_FM AND RH_EFF_DT_TO)";
			
			rs = handler.executeSelectStatement(query, con,new Object[]{currUserId});
			if(rs.next()){
				PGIM_WORKFLOW_BUCKET tempBean = new PGIM_WORKFLOW_BUCKET();
				tempBean.setAssignedTo(rs.getString("RH_REPORT_TO"));
				tempBean.setUSER_ID(rs.getString("RH_USER_ID"));
					headerList.add(tempBean);
					boolean test = true;
					System.out.println("headerList      "+headerList);
					System.out.println("Reporting to--------------------------->"+rs.getString("RH_REPORT_TO"));
					String reportingTo = rs.getString("RH_REPORT_TO");
					while(test){
						rs1= handler.executeSelectStatement(query, con,new Object[]{reportingTo});
	 					if(rs1.next()){
							PGIM_WORKFLOW_BUCKET tempBean1 = new PGIM_WORKFLOW_BUCKET();
							tempBean1.setAssignedTo(rs1.getString("RH_REPORT_TO"));
							tempBean1.setUSER_ID(rs1.getString("RH_USER_ID"));
							reportingTo = rs1.getString("RH_REPORT_TO");
							if(reportingTo == null || !checkDuplicate(headerList,reportingTo)){
								test = false;
							}else{
								headerList.add(tempBean1);	
							}
							
							System.out.println("Reporting to1--------------------------->"+rs1.getString("RH_REPORT_TO"));
						}else{
							test = false;
						}
					}
					
						System.out.println("headerList2      "+headerList);
			 }
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("headerList2      "+headerList.size());
		return headerList;
	}
	

	public boolean checkDuplicate(List<PGIM_WORKFLOW_BUCKET> headerList, String assignto){
		boolean retrunValue = true;
		try{
			for(int i = 0 ; i < headerList.size(); i++){
				if(assignto.equals(headerList.get(i).getAssignedTo())){
					retrunValue = false;
				}
			}
		}catch(Exception e ){
			e.printStackTrace();
		}
		return retrunValue;
	}
}
