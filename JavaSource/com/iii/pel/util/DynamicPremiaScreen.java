package com.iii.pel.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import com.iii.premia.common.utils.CommonUtils;

/**
 * Servlet implementation class PolicyScreenServlet
 */
public class DynamicPremiaScreen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*Added by ganesh on 25-05-2018 for servlet scheduler */
	private final static ResourceBundle resourceBundleConnection = ResourceBundle
			.getBundle("login");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DynamicPremiaScreen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

		// TODO Auto-generated method stub
		System.out.println("Enter into PolicyScreenServlet doGet");
		
		Connection con = null;
		
		String MODULE_NAME = request.getParameter("MODULE_NAME");
		String BLOCK_NAME = request.getParameter("BLOCK_NAME");
		System.out.println(" BLOCK_NAME      "+BLOCK_NAME+"      MODULE_NAME        "+MODULE_NAME);
		/*added by dhinesh*/
		String clientId = null;
		HttpSession session=request.getSession();
		if(session != null){
			System.out.println("INSIDE SESSION          ");
			System.out.println("clientId         :"+session.getAttribute("CLIENT_ID"));
			clientId = (String) session.getAttribute("CLIENT_ID");
			try {
				
				/*Modified by ganesh on 28-05-2018 for getting instance data to action class*/
				if(clientId!=null){
				con = ((SimpleConnectionAgent) getServletContext()
						.getAttribute("connectionAgent")).getConnection(clientId);
				}else{
					con = getConnectionforXDOCS();
				}
				/*end*/
				
				CRUDHandler handler = new CRUDHandler();
				/*String query = "SELECT PFD_FLD_DESC,PFD_BL_FLD_DESC,PFD_DFLT_VALUE FROM IM_PROG_FIELD_DEFN "
						+ "WHERE PFD_PROG_CODE = ? AND PFD_PB_BLK_NAME = ?  AND PFD_FLD_DESC IS NOT NULL AND PFD_BL_FLD_DESC IS NOT NULL";*/
				
				/*String query = "SELECT PFD_FLD_DESC,PFD_BL_FLD_DESC,PFD_DFLT_VALUE,PFD_HIDE_YN_NUM FROM IM_PROG_FIELD_DEFN "
						+ "WHERE PFD_PROG_CODE = ? AND PFD_PB_BLK_NAME = ?  AND PFD_FLD_DESC IS NOT NULL AND PFD_BL_FLD_DESC IS NOT NULL  "
						+ "AND PFD_SEQ_NO != 0 ORDER BY PFD_SEQ_NO";*/
				
				String query = "SELECT PFD_FLD_DESC,PFD_BL_FLD_DESC,PFD_DFLT_VALUE,PFD_HIDE_YN_NUM,PFD_ENTERABLE_YN_NUM,PFD_MANDATORY_YN_NUM FROM IM_PROG_FIELD_DEFN "
						+ "WHERE PFD_PROG_CODE = ? AND PFD_PB_BLK_NAME = ?  AND PFD_FLD_DESC IS NOT NULL AND PFD_BL_FLD_DESC IS NOT NULL  "
						+ "AND PFD_SEQ_NO != 0 ORDER BY PFD_SEQ_NO";
				/*String query = "SELECT * FROM IM_INSTANCE_FIELD_DEFN";*/
				
				/*ResultSet rs = handler.executeSelectStatement(query, con);*/
				/*PreparedStatement ps = con.prepareStatement(query);
				ResultSet rs = ps.executeQuery();*/
				
				StringBuilder sb = new StringBuilder();
				String hideColumns = null;
				String totalColumns =null;
				ResultSet rs = handler.executeSelectStatement(query, con,new Object[]{MODULE_NAME,BLOCK_NAME});
				while(rs.next())
				{
					String componentId = rs.getString("PFD_FLD_DESC");
					String liId = rs.getString("PFD_BL_FLD_DESC");
					String defaultValue = rs.getString("PFD_DFLT_VALUE");
					String fieldVisibility = rs.getString("PFD_HIDE_YN_NUM");
					//Added by Ameen on 26-12-2017 for kic
					String disabled = rs.getString("PFD_ENTERABLE_YN_NUM");
					//end
					/*String componentId = rs.getString("IFD_FAC_CLASS_CODE");
					String liId = rs.getString("IFD_PBF_FLD_NAME");
					String defaultValue = rs.getString("IFD_DFLT_VALUE");*/
					/*Modified by ganesh on 28-05-2018 for getting instance data to action class*/
					String mandatoryVal = rs.getString("PFD_MANDATORY_YN_NUM");
					/*end*/
					componentId = componentId == null ? "":componentId;
					liId = liId == null ? "":liId;
					defaultValue = defaultValue == null ? "":defaultValue;
					
					/*System.out.println(componentId+"        "+liId+"            "+defaultValue);*/
					System.out.println(componentId+"        "+liId+"            "+defaultValue+"	disabled	"+disabled);
					
					/*sb.append(componentId+"$$$"+liId+"$$$"+defaultValue+"$$$"+fieldVisibility+",");*/
					/*sb.append(componentId+"$$$"+liId+"$$$"+defaultValue+"$$$"+fieldVisibility+"$$$"+disabled+",");*/
					/*Modified by ganesh on 28-05-2018 for getting instance data to action class*/
					sb.append(componentId+"$$$"+liId+"$$$"+defaultValue+"$$$"+fieldVisibility+"$$$"+disabled+"$$$"+mandatoryVal+",");
					//			0 				  1 2 3 4 5
					/*end*/
					 
				}
				
				 totalColumns = sb.toString();
				 if(totalColumns.length() > 0)
				totalColumns = totalColumns.substring(0,(totalColumns.length() - 1));
				System.out.println("totalColumns  FINAL       "+totalColumns);
			 
				PrintWriter out = response.getWriter();
				/*Modified by ganesh on 28-05-2018 for getting instance data to action class*/
				CommonUtils.setInstanceData(totalColumns+"~"+BLOCK_NAME+MODULE_NAME);
				/*end*/
				//out.print("SUB_PLAN,PERIOD_FROM,SA_EXCHANGE_RATE,CUSTOMER_EXCHANGE_RATE,LOCAL_CURRENCY_PREMIUM,FOREIGN_CURRENCY_PREMIUM,NO_OF_UNITS,LC_SUM_ASSURED");
				out.print(totalColumns);
				 
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*Added by ganesh on 28-05-2018 for getting instance data to action class*/
			finally{
				if(clientId==null){
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			/*end*/
			}
		}
		
	
	}
	
	/*Added by ganesh on 28-05-2018 for getting instance data to action class*/
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
