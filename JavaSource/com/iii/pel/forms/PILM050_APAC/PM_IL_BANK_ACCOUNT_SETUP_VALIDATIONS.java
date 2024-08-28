package com.iii.pel.forms.PILM050_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;

public class PM_IL_BANK_ACCOUNT_SETUP_VALIDATIONS {

	
	public List prepareDivisonCodeList(Connection connection,String divisioncode,List divisionlist){
		String query ;
		if("*".equals(divisioncode)){
		 query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_DIVISION_LOV;
		 System.out.println("PM_IL_BANK_ACCOUNT_SETUP_VALIDATIONS.prepareDivisonCodeList()-query"+query);
		}else{
		query=QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_DIVISION_LOV + divisioncode + "%'";
		}
		divisionlist = divisionLov(connection,query );
    	return divisionlist;
  }
	
	
	public List prepareDepartmentCodeList(Connection connection,String departmentcode,List departmentlist){
		String query ;
		if("*".equals(departmentcode)){
		 query = QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_DEPARTMENT_LOV;
		 System.out.println("PM_IL_BANK_ACCOUNT_SETUP_VALIDATIONS.prepareDivisonCodeList()-query"+query);
		}else{
		query=QueryRepository.PM_IL_BANK_ACCOUNT_SETUP_DEPARTMENT_LOV_LIKE + departmentcode + "%'";
		}
		departmentlist = departmentLov(connection,query);
		departmentlist.size();
    	return departmentlist;
  }

	public List divisionLov(Connection connection, String query) {
		
		List divisionCodeList = new ArrayList();
		CRUDHandler handler = new CRUDHandler();
		
		try{
			System.out.println("Connection object is" + connection);
			System.out.println("Query String"+query);
			
		    ResultSet rs = handler.executeSelectStatement(query,connection); 
		    while(rs.next()){
		    	PM_IL_BANK_ACCOUNT_SETUP bank_setup = new PM_IL_BANK_ACCOUNT_SETUP();
		    	String code = rs.getString(1);
		    	String description = rs.getString(2);
		    	bank_setup.setDIVN_CODE(code);
		    	bank_setup.setDIVN_CODE_DESC(description);
		    	divisionCodeList.add(bank_setup);
		     }
				
		}catch(Exception e){
		    e.printStackTrace();
		}
		
		return divisionCodeList;
	}
	
	
public List departmentLov(Connection connection, String query) {
		
		List departmentcodeList = new ArrayList();
		CRUDHandler handler = new CRUDHandler();
		
		try{
			System.out.println("Connection object is" + connection);
			System.out.println("Query String"+query);
			
		    ResultSet rs = handler.executeSelectStatement(query,connection); 
		    while(rs.next()){
		    	PM_IL_BANK_ACCOUNT_SETUP bank_setup = new PM_IL_BANK_ACCOUNT_SETUP();
		    	String code = rs.getString(1);
		    	String description = rs.getString(2);
		    	bank_setup.setDIVN_CODE(code);
		    	bank_setup.setDIVN_CODE_DESC(description);
		    	departmentcodeList.add(bank_setup);
		     }
				
		}catch(Exception e){
		    e.printStackTrace();
		}
		
		return departmentcodeList;
	}

public String getdeptdescforcode(String deptcode,List deptcodelist){
	String deptDesc=null;
	Iterator iterator=deptcodelist.iterator();
 	while(iterator.hasNext())
 	{
         System.out.println("PM_IL_BANK_ACCOUNT_SETUP_VALIDATIONS.getdeptdescforcode()-Inside_While");
                  
 		PM_IL_BANK_ACCOUNT_SETUP pm_il_bank_account_setup=(PM_IL_BANK_ACCOUNT_SETUP)iterator.next();
 		System.out.println("PM_IL_BANK_ACCOUNT_SETUP_VALIDATIONS.getdeptdescforcode()-deptcode"+deptcode);
 		System.out.println("PM_IL_BANK_ACCOUNT_SETUP_VALIDATIONS.getdeptdescforcode()-----"+pm_il_bank_account_setup.getBAS_DEPT_FM_CODE());
 		if(deptcode.equalsIgnoreCase(pm_il_bank_account_setup.getBAS_DEPT_FM_CODE()))
 		{
 			deptDesc=pm_il_bank_account_setup.getBAS_DEPT_FM_CODE();
 		}
 	}
 	return deptDesc;

}
}
