package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_POL_DISPATCH_DTLS_HELPER {
	
	CommonUtils commonUtils = new CommonUtils();
	
	public PT_IL_POL_DISPATCH_DTLS_ACTION actionBean;

	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		
		System.out.println("executeQuery for PT_IL_POL_DISPATCH_DTLS_HELPER class");
		new PT_IL_POL_DISPATCH_DTLS_DELEGATE()
		.executeSelectStatement(compositeAction);
		
      
		List<PT_IL_POL_DISPATCH_DTLS> dataList = compositeAction.
		getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN().getDataList_PT_IL_POL_DISPATCH_DTLS();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN = dataList.get(0);
			
			System.out.println("PDD_CR_DT        "+PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_CR_DT()+"   "+PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()+"      "
					+new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()));
			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_CR_DT(new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(PT_IL_POL_DISPATCH_DTLS_BEAN.getUI_M_PDD_DATE()));
			System.out.println("After PDD_CR_DT        "+PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_CR_DT());
			
			
			PT_IL_POL_DISPATCH_DTLS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN()
			.setPT_IL_POL_DISPATCH_DTLS_BEAN(PT_IL_POL_DISPATCH_DTLS_BEAN);
		}
	
		
		
		
	}

	public void WHEN_CREATE_RECORD(PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN,
			PILT002_APAC_COMPOSITE_ACTION compositeAction) {
		
		try {
		
			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_DATE(commonUtils.getCurrentDateAndTimeNew());
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void preInsert(PILT002_APAC_COMPOSITE_ACTION compositeAction,
			PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN) throws Exception{
		String C1 = "SELECT PIL_PAFD_SYS_ID.NEXTVAL FROM DUAL";
		Connection connection = null;
		ResultSet resultSetC1 = null;
		
		CRUDHandler handler = new CRUDHandler();
		
		try {
			
			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_POL_SYS_ID(compositeAction.getPT_IL_POL_ASSURED_DTLS_ACTION_BEAN().getPT_IL_POL_ASSURED_DTLS_BEAN().getPOAD_POL_SYS_ID());
			
			
			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_CR_DT(commonUtils.getCurrentDate());
			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_CR_UID(CommonUtils.getControlBean().getUSER_ID());
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally {
			try {
				CommonUtils.closeCursor(resultSetC1);
			}
			catch (Exception e)
			{
				e.printStackTrace();}
			}
	}


	public void postInsert(PILT002_APAC_COMPOSITE_ACTION compositeAction,
			PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN) throws Exception{
		


		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
				
		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		
		String query ="select ps_code_desc from pp_system where ps_type = 'IL_DISP_STS' and ps_code = ?";
		try {
			connection = CommonUtils.getConnection();
			
			rs = handler.executeSelectStatement(query, connection,new Object[] {PT_IL_POL_DISPATCH_DTLS_BEAN.getPDD_STATUS()});
			if (rs.next()) {
				
				PT_IL_POL_DISPATCH_DTLS_BEAN.setUI_M_PDD_STATUS_DESC(rs.getString("ps_code_desc"));		
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	
		
		
		
	}
	
	
	public void preUpdate(PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN) throws Exception{
		try {
			
			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_UPD_DT(commonUtils.getCurrentDate());
			PT_IL_POL_DISPATCH_DTLS_BEAN.setPDD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void PDD_STATUS_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction, String currValue)
			throws Exception {

		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_POL_DISPATCH_DTLS PT_IL_POL_DISPATCH_DTLS_BEAN = compositeAction
				.getPT_IL_POL_DISPATCH_DTLS_ACTION_BEAN().getPT_IL_POL_DISPATCH_DTLS_BEAN();

		ArrayList<OracleParameter> pValList = new ArrayList<OracleParameter>();
		
		String query ="select ps_code_desc from pp_system where ps_type = 'IL_DISP_STS' and ps_code = ?";
		try {
			connection = CommonUtils.getConnection();
			
			rs = handler.executeSelectStatement(query, connection,new Object[] {currValue});
			if (rs.next()) {
				
				PT_IL_POL_DISPATCH_DTLS_BEAN.setUI_M_PDD_STATUS_DESC(rs.getString("ps_code_desc"));		
				
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());

		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public int doGetValue(Long polSysId) {
		Connection connection = null;
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		int MFD_FC_VALUE = 0;
		String query ="SELECT nvl(SUM(MFD_FC_VALUE),0) FROM PT_IL_MEDEX_FEE_DTL WHERE MFD_POL_SYS_ID = ? AND MFD_PAID_FLAG = ? AND MFD_FRZ_FLAG = ?";
		try{
			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection,new Object[] {polSysId,"Y","Y"});
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return MFD_FC_VALUE;
	}
	/*Newly added by pidugu raj dt: 10-10-2018 as suggested by vaitheeswaran for kic*/
	public void PROCESS_PROP_CANCEL(Date currentDate, String pol_NO,
			String pol_NO_From, String pol_NO_To, int value) throws ProcedureException{
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		ArrayList<String> returnList = null;
		try {
			connection = CommonUtils.getConnection();
			returnList = new ArrayList<String>();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN,currentDate);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN, pol_NO_From);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.STRING,OracleParameter.DIRECTION_TYPE.IN, pol_NO_To);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN2",OracleParameter.DATA_TYPE.INTEGER,OracleParameter.DIRECTION_TYPE.IN, value);
			parameterList.add(param4);
			
			
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P9ILPK_LAPSE_CONV.PROCESS_PROP_CANCEL");
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	/*Newly added by pidugu raj dt: 10-10-2018 as suggested by vaitheeswaran for kic*/

	
	
} 
