package com.iii.pel.forms.PILR_REP009;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;



public class IP_REP_INFO_DELEGATE {
	
	
		
	public List prepareFromBranchCodeList(String fromBranchCode, List fromBranchList) {

		String query = null;
		if ("*".equalsIgnoreCase(fromBranchCode)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_BRANCH_CODE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				fromBranchList = fromBranchCodeLOV(query,object);

		} else {
			fromBranchCode=fromBranchCode+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("fromDivnCode :"+fromBranchCode);
				Object[] object={fromBranchCode,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_BRANCH_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				fromBranchList = fromBranchCodeLOV(query,object);
		}
		return fromBranchList;
	}
	
	
	public List<IP_REP_INFO> fromBranchCodeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> fromBranchList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
	
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_3(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_3());
				ip_rep_info.setUI_M_FROM_BRANCH_DESC(resultSet.getString(2));
				fromBranchList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fromBranchList;
	}
	
	public List prepareToBranchCodeList(String toBranchCode, List toBranchList) {

		String query = null;
		if ("*".equalsIgnoreCase(toBranchCode)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_BRANCH_CODE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				toBranchList = toBranchCodeLOV(query,object);

		} else {
			toBranchCode=toBranchCode+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("fromDivnCode :"+toBranchCode);
				Object[] object={toBranchCode,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_BRANCH_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				toBranchList = toBranchCodeLOV(query,object);
		}
		return toBranchList;
	}
	
	public List<IP_REP_INFO> toBranchCodeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> fromDivnList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_4(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_4());
				ip_rep_info.setUI_M_TO_BRANCH_DESC(resultSet.getString(2));
				fromDivnList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fromDivnList;
	}
	
	
	public List prepareFromClaimCodeList(String fromClaimCode, List fromClaimList) {

		String query = null;
		if ("*".equalsIgnoreCase(fromClaimCode)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_CODE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				fromClaimList = fromClaimCodeLOV(query,object);

		} else {
			fromClaimCode=fromClaimCode+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("fromDivnCode :"+fromClaimCode);
				Object[] object={fromClaimCode,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				fromClaimList = fromClaimCodeLOV(query,object);
		}
		return fromClaimList;
	}
	
	
	public List<IP_REP_INFO> fromClaimCodeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> fromClaimList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
	
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_5(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_3());
				ip_rep_info.setUI_M_FROM_CLAIM_NO_DESC(resultSet.getString(2));
				fromClaimList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fromClaimList;
	}
	
	public List prepareToClaimCodeList(String toClaimCode, List toClaimList) {

		String query = null;
		if ("*".equalsIgnoreCase(toClaimCode)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_CODE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				toClaimList = toClaimCodeLOV(query,object);

		} else {
			toClaimCode=toClaimCode+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("fromDivnCode :"+toClaimCode);
				Object[] object={toClaimCode,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				toClaimList = toClaimCodeLOV(query,object);
		}
		return toClaimList;
	}
	
	
	public List<IP_REP_INFO> toClaimCodeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> fromClaimList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
	
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_6(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_6());
				ip_rep_info.setUI_M_TO_CLAIM_NO_DESC(resultSet.getString(2));
				fromClaimList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fromClaimList;
	}
	
	
	public List prepareFromClaimTypeList(String fromClaimType, List fromClaimTypeList) {

		String query = null;
		if ("*".equalsIgnoreCase(fromClaimType)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_TYPE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				fromClaimTypeList = fromClaimTypeLOV(query,object);

		} else {
			fromClaimType=fromClaimType+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("fromDivnCode :"+fromClaimType);
				Object[] object={fromClaimType,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_TYPE_LOV_LIKE;
				System.out.println("Query :"+query);
				fromClaimTypeList = fromClaimTypeLOV(query,object);
		}
		return fromClaimTypeList;
	}
	
	
	public List<IP_REP_INFO> fromClaimTypeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> fromClaimList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
	
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_7(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_3());
				ip_rep_info.setUI_M_FROM_CLAIM_TYPE_DESC(resultSet.getString(2));
				fromClaimList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fromClaimList;
	}
	
	public List prepareToClaimTypeList(String toClaimType, List toClaimTypeList) {

		String query = null;
		if ("*".equalsIgnoreCase(toClaimType)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_TYPE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				toClaimTypeList = toClaimTypeLOV(query,object);

		} else {
			toClaimType=toClaimType+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("fromDivnCode :"+toClaimType);
				Object[] object={toClaimType,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_CLAIM_TYPE_LOV_LIKE;
				System.out.println("Query :"+query);
				toClaimTypeList = toClaimTypeLOV(query,object);
		}
		return toClaimTypeList;
	}
	
	
	public List<IP_REP_INFO> toClaimTypeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> fromClaimList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
	
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_8(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_3());
				ip_rep_info.setUI_M_TO_CLAIM_TYPE_DESC(resultSet.getString(2));
				fromClaimList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fromClaimList;
	}
	
	public List prepareFromPlanCodeList(String fromPlanCode, List fromPlanList) {

		String query = null;
		if ("*".equalsIgnoreCase(fromPlanCode)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_PLAN_CODE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				fromPlanList = fromPlanCodeLOV(query,object);

		} else {
				fromPlanCode=fromPlanCode+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("fromPlanCode :"+fromPlanCode);
				Object[] object={fromPlanCode,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_PLAN_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				fromPlanList = fromPlanCodeLOV(query,object);
		}
		return fromPlanList;
	}
	
	
	public List<IP_REP_INFO> fromPlanCodeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> fromPlanList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_9(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_9());
				fromPlanList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return fromPlanList;
	}
	
	public List prepareToPlanCodeList(String toPlanCode, List toPlanList) {

		String query = null;
		if ("*".equalsIgnoreCase(toPlanCode)) {
			query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_PLAN_CODE_LOV;
				Object[] object={IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				toPlanList = toPlanCodeLOV(query,object);

		} else {
				toPlanCode=toPlanCode+IP_REP_INFO_CONSTANTS.IP_REP_INFO_PERCENTILE_FOR_SELECT_LIKE;
				System.out.println("toPlanCode :"+toPlanCode);
				Object[] object={toPlanCode,IP_REP_INFO_CONSTANTS.IP_REP_INFO_ROW_NUM_TO_DIPLAY_LESS_THEN};
				query = IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_PLAN_CODE_LOV_LIKE;
				System.out.println("Query :"+query);
				toPlanList = toPlanCodeLOV(query,object);
		}
		return toPlanList;
	}
	
	public List<IP_REP_INFO> toPlanCodeLOV(String query,Object[] object)
	{
	List<IP_REP_INFO> toPlanList = new ArrayList<IP_REP_INFO>();
	CRUDHandler handler = new CRUDHandler();
	ResultSet resultSet = null;
		try
		{
			Connection connection=CommonUtils.getConnection();

			resultSet=handler.executeSelectStatement(query,connection,object);
			while(resultSet.next())
			{
				IP_REP_INFO ip_rep_info= new IP_REP_INFO();
				ip_rep_info.setREP_VALUE_10(resultSet.getString(1));
				System.out.println("ip_rep_info :"+ip_rep_info.getREP_VALUE_10());
				toPlanList.add(ip_rep_info);
				
			}
		}
			catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		return toPlanList;
	}


	public void executeSaveAction(IP_REP_INFO ip_rep_info_bean) {
		Connection connection=null;
		CRUDHandler handler=new CRUDHandler();
		int i=0;
		try{
			connection=CommonUtils.getConnection();
			if(ip_rep_info_bean.getROWID()==null){
				i=handler.executeInsert(ip_rep_info_bean, connection);
			}else{
				i=handler.executeUpdate(ip_rep_info_bean, connection);
			}
			
			System.out.println("No. of Inserted Rows :"+i);
		}catch(SQLException exception){
			exception.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}


	public String getRepKeyNo() {
		String repKeyNo=null;
		ResultSet resultSet=null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=null;
		
		try {
			connection=CommonUtils.getConnection();
			String sqlQuery=IP_REP_INFO_SQL_QUERY_CONSTANTS.IP_REP_INFO_REP_KEY_NO_SEQUENCE;
			Object[] objects={};
			resultSet=handler.executeSelectStatement(sqlQuery, connection,objects);
			if(resultSet.next()){
				repKeyNo=resultSet.getString(1);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return repKeyNo;
	}

	public void pilr_rep009_ui_m_branch_fm_when_validate_item() {
		String mappedBeanName="PILR_REP009_IP_REP_INFO_ACTION";
		System.out.println("in helper");
		CommonUtils utility=new CommonUtils();
		IP_REP_INFO_ACTION actionBean=(IP_REP_INFO_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		
		if(actionBean.getCOMP_FROM_BRANCH().getSubmittedValue()==null|| 
				((String)actionBean.getCOMP_FROM_BRANCH().getSubmittedValue()).trim().length()==0){
			
			System.out.println("Policy From value is "+actionBean.getCOMP_FROM_BRANCH().getSubmittedValue()+" Setting from product code value to 0");
			actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_3("0");
			//actionBean.getDUMMY_BEAN().setUI_M_FM_PROD_DESC("");
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_FROM_BRANCH().setSubmittedValue(null);
			//actionBean.getCOMP_UI_M_FM_PROD_DESC().setSubmittedValue(null);
		}
	}
	public void pilr_rep009_ui_m_branch_to_when_validate_item() {
		String mappedBeanName="PILR_REP009_IP_REP_INFO_ACTION";
		List resultList=null;
		CommonUtils utility=new CommonUtils();
		
		IP_REP_INFO_ACTION actionBean=(IP_REP_INFO_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String fromBranchCode=(String)actionBean.getCOMP_FROM_BRANCH().getSubmittedValue();
		String toBranchCode=(String)actionBean.getCOMP_TO_BRANCH().getSubmittedValue();
		
		
		if(toBranchCode==null || toBranchCode.trim().length()==0){
			
			if(fromBranchCode.equals("0")){
				actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_4("zzzzzzzzzzzzzzz");
				//actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC("");
			}else{
				actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_4(fromBranchCode);
//				actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC
//					((String)actionBean.getCOMP_UI_M_FM_PROD_DESC().getSubmittedValue());
				
			}
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_TO_BRANCH().setSubmittedValue(null);
//			
			}else{
				//procedure call to compare fromCode and toCode
				List<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromBranchCode);
				OracleParameter param2 = new OracleParameter("in2","STRING","IN",toBranchCode);
				OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
				paramList.add(param1);
				paramList.add(param2);	
				paramList.add(param3);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				try {
					resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), 
	"PR_VALIDATE_FM_TO");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Map<String, String> errMap = actionBean.getErrorMap(); 
				System.out.println("PILR_REP009.to_BRANCH action \n--------------- OUTPUTPARAM -----------------	--\n"+((OracleParameter)resultList.get(0)).getValue()+"\n----------------");
				if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
					String msg=ResourceBundle.getBundle("messageProperties_PILR_REP009").getString("PILR_REP009$INT_REP_INFO$TO_BRANCH$caption");
					message = msg+":"+message;
					errMap.put("current",message);
					errMap.put("someKey",message);
				}else{
					errMap.clear();
				}
			}
		}
	
	public void pilr_rep009_ui_m_claim_fm_when_validate_item() {
		String mappedBeanName="PILR_REP009_IP_REP_INFO_ACTION";
		System.out.println("in helper");
		CommonUtils utility=new CommonUtils();
		IP_REP_INFO_ACTION actionBean=(IP_REP_INFO_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		
		if(actionBean.getCOMP_FROM_CLAIM_NO().getSubmittedValue()==null|| 
				((String)actionBean.getCOMP_FROM_CLAIM_NO().getSubmittedValue()).trim().length()==0){
			
			System.out.println("Policy From value is "+actionBean.getCOMP_FROM_CLAIM_NO().getSubmittedValue()+" Setting from product code value to 0");
			actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_5("0");
			//actionBean.getDUMMY_BEAN().setUI_M_FM_PROD_DESC("");
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_FROM_CLAIM_NO().setSubmittedValue(null);
			//actionBean.getCOMP_UI_M_FM_PROD_DESC().setSubmittedValue(null);
		}
	}
	public void pilr_rep009_ui_m_claim_to_when_validate_item() {
		String mappedBeanName="PILR_REP009_IP_REP_INFO_ACTION";
		List resultList=null;
		CommonUtils utility=new CommonUtils();
		
		IP_REP_INFO_ACTION actionBean=(IP_REP_INFO_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String fromClaimCode=(String)actionBean.getCOMP_FROM_CLAIM_NO().getSubmittedValue();
		String toClaimCode=(String)actionBean.getCOMP_TO_CLAIM_NO().getSubmittedValue();
		
		
		if(toClaimCode==null || toClaimCode.trim().length()==0){
			
			if(fromClaimCode.equals("0")){
				actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_6("zzzzzzzzzzzzzzz");
				//actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC("");
			}else{
				actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_6(fromClaimCode);
//				actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC
//					((String)actionBean.getCOMP_UI_M_FM_PROD_DESC().getSubmittedValue());
				
			}
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_TO_CLAIM_NO().setSubmittedValue(null);
//			
			}else{
				//procedure call to compare fromCode and toCode
				List<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromClaimCode);
				OracleParameter param2 = new OracleParameter("in2","STRING","IN",toClaimCode);
				OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
				paramList.add(param1);
				paramList.add(param2);	
				paramList.add(param3);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				try {
					resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), 
	"PR_VALIDATE_FM_TO");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Map<String, String> errMap = actionBean.getErrorMap(); 
				System.out.println("PILR_REP009.to_Claim action \n--------------- OUTPUTPARAM -----------------	--\n"+((OracleParameter)resultList.get(0)).getValue()+"\n----------------");
				if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
					String msg=ResourceBundle.getBundle("messageProperties_PILR_REP009").getString("PILR_REP009$INT_REP_INFO$TO_CLAIM_NO$caption");
					message = msg+":"+message;
					errMap.put("current",message);
					errMap.put("someKey",message);
				}else{
					errMap.clear();
				}
			}
		}
	
	
	public void pilr_rep009_ui_m_claim_type_fm_when_validate_item() {
		String mappedBeanName="PILR_REP009_IP_REP_INFO_ACTION";
		System.out.println("in helper");
		CommonUtils utility=new CommonUtils();
		IP_REP_INFO_ACTION actionBean=(IP_REP_INFO_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		
		if(actionBean.getCOMP_FROM_CLAIM_TYPE().getSubmittedValue()==null|| 
				((String)actionBean.getCOMP_FROM_CLAIM_TYPE().getSubmittedValue()).trim().length()==0){
			
			System.out.println("Policy From value is "+actionBean.getCOMP_FROM_CLAIM_TYPE().getSubmittedValue()+" Setting from product code value to 0");
			actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_7("0");
			//actionBean.getDUMMY_BEAN().setUI_M_FM_PROD_DESC("");
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_FROM_CLAIM_TYPE().setSubmittedValue(null);
			//actionBean.getCOMP_UI_M_FM_PROD_DESC().setSubmittedValue(null);
		}
	}
	public void pilr_rep009_ui_m_claim_type_to_when_validate_item() {
		String mappedBeanName="PILR_REP009_IP_REP_INFO_ACTION";
		List resultList=null;
		CommonUtils utility=new CommonUtils();
		
		IP_REP_INFO_ACTION actionBean=(IP_REP_INFO_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		String fromClaimTypeCode=(String)actionBean.getCOMP_FROM_CLAIM_TYPE().getSubmittedValue();
		String toClaimTypeCode=(String)actionBean.getCOMP_TO_CLAIM_TYPE().getSubmittedValue();
		
		
		if(toClaimTypeCode==null || toClaimTypeCode.trim().length()==0){
			
			if(fromClaimTypeCode.equals("0")){
				actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_8("zzzzzzzzzzzzzzz");
				//actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC("");
			}else{
				actionBean.getIP_REP_INFO_BEAN().setREP_VALUE_8(fromClaimTypeCode);
//				actionBean.getDUMMY_BEAN().setUI_M_TO_PROD_DESC
//					((String)actionBean.getCOMP_UI_M_FM_PROD_DESC().getSubmittedValue());
				
			}
			//setting submitted values to null so that JSF will pick values for
			//the fields from value bean
			actionBean.getCOMP_TO_CLAIM_TYPE().setSubmittedValue(null);
//			
			}else{
				//procedure call to compare fromCode and toCode
				List<OracleParameter> paramList = new ArrayList<OracleParameter>();
				OracleParameter param1 = new OracleParameter("in1","STRING","IN",fromClaimTypeCode);
				OracleParameter param2 = new OracleParameter("in2","STRING","IN",toClaimTypeCode);
				OracleParameter param3 = new OracleParameter("in3","STRING","OUT","");
				paramList.add(param1);
				paramList.add(param2);	
				paramList.add(param3);
				OracleProcedureHandler procHandler = new OracleProcedureHandler();
				try {
					resultList = procHandler.execute((ArrayList)paramList, utility.getConnection(), 
	"PR_VALIDATE_FM_TO");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Map<String, String> errMap = actionBean.getErrorMap(); 
				System.out.println("PILR_REP009.to_Claim action \n--------------- OUTPUTPARAM -----------------	--\n"+((OracleParameter)resultList.get(0)).getValue()+"\n----------------");
				if(Integer.parseInt(((OracleParameter)resultList.get(0)).getValue())==1){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "10064");
					String msg=ResourceBundle.getBundle("messageProperties_PILR_REP009").getString("PILR_REP009$INT_REP_INFO$TO_CLAIM_TYPE$caption");
					message = msg+":"+message;
					errMap.put("current",message);
					errMap.put("someKey",message);
				}else{
					errMap.clear();
				}
			}
		}
	

	
	
	

}
