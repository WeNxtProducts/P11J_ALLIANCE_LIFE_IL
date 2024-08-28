package com.iii.pel.forms.PILP206;

import java.io.BufferedWriter;

import com.iii.premia.common.constants.PELConstants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_BALANCE_SUM_DELEGATE {

	public void executeSelectStatement(
			PILP206_COMPOSITE_ACTION compositeAction) throws Exception {
		List<String> data = new ArrayList<String>();
		
		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet rs = null;
		String path=null;
		String Query = "SELECT * FROM  PW_IL_BALANCE_SUM order by PIBS_LINE_NO";
		String Query1="select ps_code_desc from pp_system where ps_type like 'SMART_FILE'";
		compositeAction.getPW_IL_BALANCE_SUM_ACTION_BEAN().getDataList_PW_IL_BALANCE_SUM().clear();
		/*ResourceBundle resourceBundleApp = ResourceBundle.getBundle("messageProperties_PILP206");*/
		try {
			String FileName=null;
			connection = CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(
				Query, connection, new Object[] {});
			/*rs=new CRUDHandler().executeSelectStatement
					(Query1, connection, new Object[] {});
			while (rs.next()) {
				path=rs.getString(1);
			}
			
			data.add("EntityId\tJournalID\tDocDate\t\tJournalSeqno\tLineno\tLDREntityID\tBanch\tMainAcntCode\tProductCode\tAmount\tDRCRFlag\tJournalDesc");*/
			while (resultSet.next()) {
				PW_IL_BALANCE_SUM PW_IL_BALANCE_SUM_BEAN=new PW_IL_BALANCE_SUM();
				/*data.add(resultSet
						.getString("PIBS_ENTITY_ID")+"\t\t"+resultSet
						.getString("PIBS_JRNL_ID")+"\t\t"+CommonUtils.dateToStringFormatter(resultSet
						.getDate("PIBS_DOC_DATE"))+"\t\t"+resultSet
						.getInt("PIBS_JRNL_SEQ_NO")+"\t"+resultSet
						.getInt("PIBS_LINE_NO")+"\t"+resultSet
						.getString("PIBS_LDR_ENTITY_ID")+"\t\t"+resultSet
						.getString("PIBS_BRANCH")+"\t"+resultSet
						.getString("PIBS_MAIN_ACNT_CODE")+"\t\t"+resultSet
						.getString("PIBS_PROD_CODE")+"\t\t"+resultSet
						.getDouble("PIBS_AMOUNT")+"\t\t"+resultSet
						.getString("PIBS_DRCR_FLAG")+"\t"+resultSet
						.getString("PIBS_JRNL_DESC"));*/
				PW_IL_BALANCE_SUM_BEAN.setPIBS_ENTITY_ID(resultSet
						.getString("PIBS_ENTITY_ID"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_JRNL_ID(resultSet
						.getString("PIBS_JRNL_ID"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_DOC_DATE(resultSet
						.getDate("PIBS_DOC_DATE"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_JRNL_SEQ_NO(resultSet
						.getInt("PIBS_JRNL_SEQ_NO"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_LINE_NO(resultSet
						.getInt("PIBS_LINE_NO"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_LDR_ENTITY_ID(resultSet
						.getString("PIBS_LDR_ENTITY_ID"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_BRANCH(resultSet
						.getString("PIBS_BRANCH"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_MAIN_ACNT_CODE(resultSet
						.getString("PIBS_MAIN_ACNT_CODE"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_PROD_CODE(resultSet
						.getString("PIBS_PROD_CODE"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_AMOUNT(resultSet
						.getDouble("PIBS_AMOUNT"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_DRCR_FLAG(resultSet
						.getString("PIBS_DRCR_FLAG"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_JRNL_DESC(resultSet
						.getString("PIBS_JRNL_DESC"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_CURR_CODE(resultSet
								.getString("PIBS_CURR_CODE"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_STATNO(resultSet
								.getString("PIBS_STATNO"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_MISC1(resultSet
						.getString("PIBS_MISC1"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_MISC2(resultSet
						.getString("PIBS_MISC2"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_USER_ALPHA_1(resultSet
						.getString("PIBS_USER_ALPHA_1"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_USER_ALPHA_2(resultSet
						.getString("PIBS_USER_ALPHA_2"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_USER_ALPHA_3(resultSet
						.getString("PIBS_USER_ALPHA_3"));
				PW_IL_BALANCE_SUM_BEAN.setPIBS_PROJECT(resultSet
						.getString("PIBS_PROJECT"));
				FileName=CommonUtils.dateToStringFormatter(PW_IL_BALANCE_SUM_BEAN.getPIBS_DOC_DATE());
				compositeAction.getPW_IL_BALANCE_SUM_ACTION_BEAN()
				.getDataList_PW_IL_BALANCE_SUM().add(PW_IL_BALANCE_SUM_BEAN);
			}
		/*System.out.println("path :"+path);
		if(path!=null){
			File theDir = new File(path);

			// if the directory does not exist, create it
			if (!theDir.exists()) {
			    try{
			        theDir.mkdir();
			        System.out.println("Directry Created  "+path);
			      } 
			    catch(SecurityException se){
			   se.printStackTrace();
			    }        
			   
			}else{
				System.out.println("Directry already thr  "+path);
			}

		}else{
			
			path=resourceBundleApp.getString("DEFAULT_FILE_SAVE");
			File theDir = new File(path);

			// if the directory does not exist, create it
			if (!theDir.exists()) {
			    try{
			        theDir.mkdir();
			        System.out.println("Directry Created  "+path);
			      } 
			    catch(SecurityException se){
			   se.printStackTrace();
			    }        
			   
			}else{
				System.out.println("Directry already thr  "+path);
			}

		
		}
			writeToFile(data,path+"SmartStreamJournal_"+FileName+".txt");
			*/
			
			//throw new ValidationException("Generated text file succesfully to this path "+path+"SmartStreamJournal_"+FileName+".txt");
			/*compositeAction.getPW_IL_BALANCE_SUM_ACTION_BEAN().getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Generated text file succesfully");*/
			
			compositeAction.getPW_IL_BALANCE_SUM_ACTION_BEAN().getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process completed succesfully");
			
	} catch (Exception e) {
		e.printStackTrace();
		throw e;
	} finally {
		CommonUtils.closeCursor(resultSet);
	}
	}
	private static void writeToFile(List<String> list, String path) {
		BufferedWriter out = null;
		try {
			
			File file = new File(path);
			out = new BufferedWriter(new FileWriter(file, false));
			for (String s : list) {
			/*	System.out.println("value        "+s);*/
				out.write(s);
				out.newLine();

			}
			out.close();
		} catch (IOException e) {
		}
	}
	

}
