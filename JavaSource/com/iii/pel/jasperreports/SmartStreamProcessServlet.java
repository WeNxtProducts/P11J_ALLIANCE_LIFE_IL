package com.iii.pel.jasperreports;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.ConnectionManager;
import com.iii.apps.persistence.PremiaCryptograph;
import com.iii.apps.persistence.SimpleConnectionAgent;
import com.iii.pel.forms.PILP206.PW_IL_BALANCE_SUM;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

/**
 * Servlet implementation class SmartStreamProcessServlet
 */
	public class SmartStreamProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final static ResourceBundle resourceBundleDatabase = ResourceBundle
			.getBundle("messageProperties_PILP206");
	/*Added by ganesh on 26-02-2018 for servlet scheduler */
	private final static ResourceBundle resourceBundleConnection = ResourceBundle
			.getBundle("login");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SmartStreamProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Get Method");
		doPost(request, response);
	}
    


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Welcome to POST Method");
    	List<String> data = new ArrayList<String>();
    	Connection connection = null;
    	ResultSet resultSet = null;
    	ResultSet rs = null;
    	ResultSet rs1 = null;
    	String path=null;
    	int n=0;
    	int count=0;
		String col_lable=null;
		/*String Col_value_len=null;*/
		/*String value=null;*/
		String value="",space = "";
		String DATA_TYPE=null;
		int DATA_LENGTH=0;
		int DATA_PRECISION=0;
    	String Query = "SELECT * FROM  PW_IL_BALANCE_SUM order by PIBS_LINE_NO";
    	
    	String Query1="select ps_code_desc from pp_system where ps_type like 'SMART_FILE'";
    	
    	String Query2="SELECT DATA_TYPE,DATA_LENGTH,DATA_PRECISION FROM user_tab_columns"
    			+ " WHERE  table_name='PW_IL_BALANCE_SUM' AND COLUMN_NAME = ? ";
    	 String clientId=null;   	
    	 
    	 /*Added by ganesh on 10-03-2018 */
    	 String pathFlag = request.getParameter("pathflag");
    	 
    	 if(pathFlag!=null){
    		 Query1="select ps_code_desc from pp_system where ps_type = 'EOD_REP_PATH'";
    	 }
    	 
    	 /*end*/
    	 
    	HttpSession session=request.getSession();
		if(session != null){
			//System.out.println("INSIDE SESSION IN Premia Schedule         ");
			//System.out.println("clientId         :"+session.getAttribute("CLIENT_ID"));
			clientId = (String) session.getAttribute("CLIENT_ID");
    	try {
    		String FileName=null;
    		int dataCount = 0;
    		/*Modified by ganesh on 26-02-2018 for servlet scheduler */
    		if(clientId!=null){
    			connection = ((SimpleConnectionAgent) getServletContext()
					.getAttribute("connectionAgent")).getConnection(clientId);
    		}else{
    			connection = getConnectionforXDOCS();
    		}
    		/*end*/
    		resultSet=new CRUDHandler().executeSelectStatement(
    				Query, connection, new Object[] {});
    		rs=new CRUDHandler().executeSelectStatement
    				(Query1, connection, new Object[] {});
    		while (rs.next()) {
    			path=rs.getString(1);
    		}
    		
    		/*data.add("EntityId,JournalID,DocDate,JournalSeqno,Lineno,LDREntityID,Banch,MainAcntCode,ProductCode,Amount,DRCRFlag,JournalDesc,CurrCode");*/
    		/*data.add("EntityId\tJournalID\tDocDate\t\tJournalSeqno\tLineno\tLDREntityID\tBanch\tMainAcntCode\tProductCode\tAmount\tDRCRFlag\tJournalDesc\tCurrCode");*/
    		
    		while (resultSet.next()) {
    			count= resultSet.getMetaData().getColumnCount();
    			String rowString = "";
    			dataCount++;
    			 
    		for(int i=1;i<=count;i++){
    			
    			col_lable=resultSet.getMetaData().getColumnLabel(i);
    			/*System.out.println("col_lable  :"+col_lable);*/
    			
    			
    			//System.out.println("Length is:::" + col_lable.length());
    			rs1=new CRUDHandler().executeSelectStatement
        				(Query2, connection, new Object[] {col_lable});
    			while (rs1.next()) {
    				DATA_TYPE=rs1.getString("DATA_TYPE");
    				DATA_LENGTH=rs1.getInt("DATA_LENGTH");
    				DATA_PRECISION=rs1.getInt("DATA_PRECISION");
    				/*System.out.println("DATA_TYPE   :"+DATA_TYPE);*/
    			}

    			if(DATA_TYPE.equalsIgnoreCase("DATE")){
    				value=CommonUtils.dateToStringFormat(resultSet.getDate(col_lable));
    				/*System.out.println("Date value  :"+value);*/
    			}else{
    				value=resultSet.getString(col_lable);
    			}
    			
    			if(DATA_TYPE.equals("NUMBER")){
    				
    				value = padRight(value, DATA_PRECISION,DATA_TYPE,col_lable);
    				
    			}else{
    				value = padRight(value, DATA_LENGTH,DATA_TYPE,col_lable);
    			}
    			
    			 
    			/*if(col_lable != null && col_lable.equals("PIBS_BRANCH"))
    			{
    				System.out.println("first value:"+value+"         "+DATA_LENGTH+"        "+DATA_TYPE);	
    			}*/
    			
    			if(value == null)
    			{
    				value = space;
    			}
    			else if(value != null)
    			{
    				if(value.equals("null"))
    				{
    					
    					
    					value = space;
    				}
    				else if(value.contains("null"))
    				{
    					value = value.replaceAll("null", space);
    				}
    			}
    			/*if(col_lable != null && col_lable.equals("PIBS_BRANCH"))
    			{
    				System.out.println("value:"+value);	
    			}*/
    			
    			rowString =rowString+","+value; 
    		}
    		//System.out.println("my whole string-->"+rowString);
    			/*data.add(resultSet
    					.getString("PIBS_ENTITY_ID")+",   "+resultSet
    					.getString("PIBS_JRNL_ID")+",   "+CommonUtils.dateToStringFormat(resultSet
    							.getDate("PIBS_DOC_DATE"))+",   "+resultSet
    							.getInt("PIBS_JRNL_SEQ_NO")+",   "+resultSet
    							.getInt("PIBS_LINE_NO")+",   "+resultSet
    							.getString("PIBS_LDR_ENTITY_ID")+",   "+resultSet
    							.getString("PIBS_BRANCH")+",   "+resultSet
    							.getString("PIBS_MAIN_ACNT_CODE")+",   "+resultSet
    							.getString("PIBS_PROD_CODE")+",   "+resultSet
    							.getDouble("PIBS_AMOUNT")+",   "+resultSet
    							.getString("PIBS_DRCR_FLAG")+",   "+resultSet
    							.getString("PIBS_JRNL_DESC")+",   "+resultSet
								.getString("PIBS_CURR_CODE"));
    	*/
    		FileName=CommonUtils.dateToStringFormat(resultSet
					.getDate("PIBS_DOC_DATE"));
    		data.add(rowString.substring(1)+"\n");
    		 
    		}
    		FileName = FileName.replace("/","-");
    		
    		if(path!=null){
    			File theDir = new File(path);

    			// if the directory does not exist, create it
    			if (!theDir.exists()) {
    				try{
    					theDir.mkdir();
    					 
    				} 
    				catch(SecurityException se){
    					se.printStackTrace();
    				}        

    			}/*else{
    				System.out.println("Directry already thr  "+path);
    			}*/

    		}else{

    			path=resourceBundleDatabase.getString("DEFAULT_FILE_SAVE");
    			File theDir = new File(path);

    			// if the directory does not exist, create it
    			if (!theDir.exists()) {
    				try{
    					theDir.mkdir();
    					 
    				} 
    				catch(SecurityException se){
    					se.printStackTrace();
    				}        

    			} 


    		}
    		//writeToFile(data,path+"SmartStreamJournal_"+FileName+".txt",response);
    		path=path+"SmartStreamJournal_"+FileName+".txt";
    			BufferedWriter out = null;
    			File file = new File(path);
    			out = new BufferedWriter(new FileWriter(file, false));
    			for (String s : data) {
    			/*	System.out.println("value        "+s);*/
    				out.write(s);
    				out.newLine();

    			}
    			out.close();
    			FileInputStream inStream = new FileInputStream(path);
    			response.setContentType("text/csv");
    			response.setHeader("Content-disposition",
    					"attachment;filename=" +"SmartStreamJournal_"+FileName+".txt");
    			OutputStream outStream = response.getOutputStream();
    			byte[] buffer = new byte[4096];
    			int bytesRead = -1;
    				while ((bytesRead = inStream.read(buffer)) != -1) {
    				outStream.write(buffer, 0, bytesRead);
    				}			
    			
    				 
    				
    				
    	
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    	}
    	/*Added by ganesh on 26-02-2018 for servlet scheduler */
    	finally{
    		if(clientId==null){
    			try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
    		
    	}
    	/*end*/
		}
	}

	private static void writeToFile(List<String> list, String path,HttpServletResponse response) {
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
			
			FileInputStream inStream = new FileInputStream(path);
			
			
			response.setContentType("text/csv");
			response.setHeader("Content-disposition",
					"attachment;filename=" + path);
			OutputStream outStream = response.getOutputStream();
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			
				while ((bytesRead = inStream.read(buffer)) != -1) {
				outStream.write(buffer, 0, bytesRead);}			
			
		} catch (IOException e) {
		}
	}
	private void writeTextToResponse(HttpServletResponse response,
			StringBuffer baos, String fileName) {/*
		try {
			response.reset();
			response.setContentType("text/csv");
			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control",
					"must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setHeader("Content-disposition",
					"attachment;filename=" + fileName + ".txt");
			response.setContentLength(baos.length());
			InputStream in  =  new ByteArrayInputStream(baos.toString().getBytes());
			OutputStream out = response.getOutputStream();
			byte[] outputByte = new byte[4096];
			while(in.read(outputByte, 0, 4096) != -1)
			{
				out.write(outputByte, 0, 4096);
			}
			in.close();
			out.flush();
			out.close();
			response.flushBuffer();			
		} catch (Exception e) {
			e.printStackTrace();
		}


	*/}
	public static String padRight(String actualContent, int length,String dataType,String col_lable) {
		int dynamicSpace = 0;
		if(actualContent != null)
		{
			//System.out.println("actualContent        "+actualContent+"         length       "+length+"      "+String.format("%1$-" + length + "s", actualContent));	
		if(!actualContent.equalsIgnoreCase("null"))
		{
			dynamicSpace = length - actualContent.length();	
		}
		else
		{
			dynamicSpace = length;
		}
		}
		else
		{
			dynamicSpace = length;
		}
		
		for(int space=0;space<dynamicSpace;space++)
		{
			if(col_lable != null && col_lable.equals("PIBS_AMOUNT"))
			{
				actualContent = actualContent;
			}
			else
			{
			
			if(dataType != null && dataType.equalsIgnoreCase("NUMBER"))
			{
				actualContent = " "+actualContent;
			}
			else
			{
				actualContent = actualContent + " ";
			}	
			}
		}
		//System.out.println("length       "+length+"   actualContent.LENGTH       "+actualContent.length()+"       dynamicSpace          "+dynamicSpace+"       "+actualContent+"   dataType     "+dataType);
		
	    //return String.format("%1$-" + length + "s", actualContent);
		return actualContent;
	  }
	
	/*Added by ganesh on 26-02-2018 for servlet scheduler*/
	public Connection getConnectionforXDOCS() throws  Exception {
		Connection dbCon=null;
		String userName = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleConnection.getString("login_db_user_name"));
		String passWord = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleConnection.getString("login_db_password"));
		String jdbcURL = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleConnection.getString("login_db_url"));
		String jdbcDriver = PremiaCryptograph.decrypt(ConnectionManager.ENCRYPTION_KEY, resourceBundleConnection.getString("jdbc.datasource.driver"));
	
		
		try{
			System.out.println("welcome to getConnectionforXDOCS      "+userName+"  "+passWord+"  "+jdbcURL+"  "+jdbcDriver+"  ");
			Class.forName(jdbcDriver);
			dbCon = DriverManager.getConnection(jdbcURL,userName,passWord);
			dbCon.setAutoCommit(false);
			
			System.out.println("dbCon     "+dbCon);
			
		}catch(Exception e){
			
			
			e.printStackTrace();
		}
		return dbCon;
	}
/*End*/
}
