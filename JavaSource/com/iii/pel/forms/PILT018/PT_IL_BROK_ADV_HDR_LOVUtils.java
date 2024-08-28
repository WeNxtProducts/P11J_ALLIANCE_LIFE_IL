package com.iii.pel.forms.PILT018;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;

public class PT_IL_BROK_ADV_HDR_LOVUtils {


	public List prepareCustCodeList(Connection connection,String divisioncode,List divisionlist){
		String query ;
		if("*".equals(divisioncode)){
			query = QueryRepository.PT_IL_BROK_ADV_HDR_CUST_CODE_QUERY;
			System.out
			.println("PT_IL_BROK_ADV_HDR_LOVUtils.prepareCustCodeList()"+query);
		}else{
			query=QueryRepository.PT_IL_BROK_ADV_HDR_CUST_CODE_QUERY +"AND CUST_CODE LIKE '"+ divisioncode + "%'";
		}
		divisionlist = cust_code_Lov(connection,query );
		return divisionlist;
	}

	public String  prepareCustCodeDescList(Connection connection,String divisioncode){
		String query ;

		query=QueryRepository.PT_IL_BROK_ADV_HDR_CUST_CODE_DESC_QUERY + "'"+divisioncode+"'";
		System.out
		.println("PT_IL_BROK_ADV_HDR_LOVUtils.prepareCustCodeList()"+query);

		String custCodeDesc = cust_code_desc_Lov(connection ,query);
		return custCodeDesc;
	}



	public List prepareCurrCodeList(Connection connection,String divisioncode,List divisionlist){
		String query ;
		if("*".equals(divisioncode)){
			query = QueryRepository.PT_IL_BROK_ADV_HDR_CURR_CODE_QUERY;
			System.out
			.println("PT_IL_BROK_ADV_HDR_LOVUtils.prepareCurrCodeList()"+query);
		}else{
			query=QueryRepository.PT_IL_BROK_ADV_HDR_CURR_CODE_QUERY +" AND CURR_CODE LIKE '"+ divisioncode + "%'";
		}
		divisionlist = curr_code_Lov(connection,query );
		return divisionlist;
	}

	public String  prepareCurrCodeDescList(Connection connection,String divisioncode){
		String query ;
		query=QueryRepository.PT_IL_BROK_ADV_HDR_CURR_CODE_DESC_QUERY+ "'"+divisioncode+"'";
		System.out.println("PT_IL_BROK_ADV_HDR_LOVUtils.prepareCustCodeList()"+query);
		String currCodeDesc = curr_code_desc_Lov(connection ,query);
		return currCodeDesc;
	}



	public List curr_code_Lov(Connection connection, String query) {

		List divisionCodeList = new ArrayList();
		CRUDHandler handler = new CRUDHandler();

		try{
			System.out.println("Connection object is" + connection);
			System.out.println("Query String"+query);

			ResultSet rs = handler.executeSelectStatement(query,connection); 
			while(rs.next()){
				PT_IL_BROK_ADV_HDR pt_il_brok_adv_hdr_inst = new PT_IL_BROK_ADV_HDR();
				String code = rs.getString(1);
				String description = rs.getString(2);
				pt_il_brok_adv_hdr_inst.setLOV_CURR_CODE(code);
				pt_il_brok_adv_hdr_inst.setLOV_CURR_CODE_DESC(description);
				divisionCodeList.add(pt_il_brok_adv_hdr_inst);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return divisionCodeList;
	}

	public List cust_code_Lov(Connection connection, String query) {

		List divisionCodeList = new ArrayList();
		CRUDHandler handler = new CRUDHandler();

		try{
			System.out.println("Connection object is" + connection);
			System.out.println("Query String"+query);

			ResultSet rs = handler.executeSelectStatement(query,connection); 
			while(rs.next()){
				PT_IL_BROK_ADV_HDR pt_il_brok_adv_hdr_inst = new PT_IL_BROK_ADV_HDR();
				String code = rs.getString(1);
				String description = rs.getString(2);
				pt_il_brok_adv_hdr_inst.setLOV_CUST_CODE(code);
				pt_il_brok_adv_hdr_inst.setLOV_CUST_CODE_DESC(description);
				divisionCodeList.add(pt_il_brok_adv_hdr_inst);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return divisionCodeList;
	}


	public String cust_code_desc_Lov(Connection connection, String query) {

		String description = null;
		CRUDHandler handler = new CRUDHandler();

		try{
			System.out.println("Connection object is" + connection);
			System.out.println("Query String"+query);

			ResultSet rs = handler.executeSelectStatement(query,connection); 
			while(rs.next()){
				description = rs.getString(1);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return description;
	}



	public String curr_code_desc_Lov(Connection connection, String query) {

		String description = null;
		CRUDHandler handler = new CRUDHandler();

		try{
			System.out.println("Connection object is" + connection);
			System.out.println("Query String"+query);

			ResultSet rs = handler.executeSelectStatement(query,connection); 
			while(rs.next()){
				description = rs.getString(1);
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return description;
	}
}




