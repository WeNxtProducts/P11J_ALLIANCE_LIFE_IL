package com.iii.pel.forms.PILP135;

import java.sql.ResultSet;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;


public class DUMMY_HELPER {

	/*Added by saritha on 04-01-2017 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/	
	public void fetch_when_validate_item(PILP135_COMPOSITE_ACTION compositeAction,Integer sysid) throws Exception {

		Connection connection = null;
		ResultSet resultSet=  null;
		ResultSet rstempDescQuery=  null;
		CRUDHandler handler = new CRUDHandler();
		connection = CommonUtils.getConnection();

		/*Modified by saritha on 20-07-2017 for ssp call id ZBILQC-1732158*/
		/*String C1="SELECT POL_NO, POL_LAPS_OVR_YN, POL_LAPS_OVR_DT  FROM PT_IL_POLICY WHERE POL_EMPLOYER_CODE =?  AND POL_DS_TYPE='2' AND POL_STATUS NOT IN 'L'";*/

		/*Modified by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/

		String C1="SELECT ESP_SYS_ID,ESP_POL_NO, ESP_LAPS_OVR_YN, ESP_LAPS_OVR_FRM_DT,ESP_LAPS_OVR_TO_DT FROM PW_IL_EMP_STO_PRCS WHERE ESP_EMPLOYER_CODE =? AND ESP_SYS_ID=? ";
		String empDescQuery="SELECT CONT_NAME FROM PM_IL_CONTRACTOR WHERE CONT_EMPLOYER_YN = 'Y' AND CONT_CODE=?";

		try {
			compositeAction.getDUMMY_ACTION_BEAN().getDataList_DUMMY().clear();
			System.out.println("Employer Code***********"+compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_EMP_CODE());
			System.out.println("inside execute query ");

			resultSet = handler.executeSelectStatement(C1, connection, 
					new Object[] {compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_EMP_CODE(),sysid});
			

			DUMMY bean = null;
			while(resultSet.next())
			{

				bean=new DUMMY();
			/*bean.setPOL_NO(resultSet.getString("POL_NO"));
			bean.setPOL_LAPS_OVR_YN(resultSet.getString("POL_LAPS_OVR_YN"));
			bean.setPOL_LAPS_OVR_YN("Y");
			bean.setPOL_LAPS_OVR_FRM_DT(resultSet.getDate("POL_LAPS_OVR_FRM_DT"));
			bean.setPOL_LAPS_OVR_TO_DT(resultSet.getDate("POL_LAPS_OVR_TO_DT"));*/
				bean.setESP_SYS_ID(resultSet.getInt("ESP_SYS_ID"));
				bean.setPOL_NO(resultSet.getString("ESP_POL_NO"));
				bean.setPOL_LAPS_OVR_YN(resultSet.getString("ESP_LAPS_OVR_YN"));
				bean.setPOL_LAPS_OVR_FRM_DT(resultSet.getDate("ESP_LAPS_OVR_FRM_DT"));
				bean.setPOL_LAPS_OVR_TO_DT(resultSet.getDate("ESP_LAPS_OVR_TO_DT"));

				bean.setPOL_LAPS_OVR_FRM_DT(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOL_LAPS_OVR_FRM_DT());
				bean.setPOL_LAPS_OVR_TO_DT(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getPOL_LAPS_OVR_TO_DT());
				bean.setUI_M_EMP_CODE(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_EMP_CODE());
				
				rstempDescQuery = handler.executeSelectStatement(empDescQuery, connection, 
						new Object[] {compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getUI_M_EMP_CODE()});
				if(rstempDescQuery.next()){
					bean.setUI_M_EMP_DESC(rstempDescQuery.getString("CONT_NAME"));
				}

				compositeAction.getDUMMY_ACTION_BEAN().getDataList_DUMMY().add(bean);
			}

			

			/*End*/

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void PRE_UPDATE(PILP135_COMPOSITE_ACTION compositeAction) throws Exception{
		try
		{
			DUMMY DUMMY_BEAN = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
			Connection connection = null;
			connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			/*Modified by saritha on 20-07-2017 for ssp call id ZBILQC-1732158*/
			//String query = "UPDATE PT_IL_POLICY SET POL_LAPS_OVR_YN = ?,POL_LAPS_OVR_FRM_DT =?,POL_LAPS_OVR_TO_DT=? WHERE POL_NO = ?";

			/*Modified by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
			String query = "UPDATE PW_IL_EMP_STO_PRCS SET ESP_LAPS_OVR_YN = ?,ESP_LAPS_OVR_FRM_DT =?,ESP_LAPS_OVR_TO_DT=? WHERE ESP_SYS_ID=? AND ESP_POL_NO=?";

			int i = handler.executeUpdateStatement(query, connection,new Object[] {DUMMY_BEAN.getPOL_LAPS_OVR_YN(),DUMMY_BEAN.getPOL_LAPS_OVR_FRM_DT(),
					DUMMY_BEAN.getPOL_LAPS_OVR_TO_DT(),DUMMY_BEAN.getESP_SYS_ID(),DUMMY_BEAN.getPOL_NO()});

			/*End*/

			connection.commit();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}
	
	
	/*Added by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
	
	public ArrayList<OracleParameter> callP_EMP_STP_ODR(
			String P_POL_EMPLOYER_CODE,
			Date P_POL_LAPS_OVR_FRM_DT,
			Date P_POL_LAPS_OVR_TO_DT,
			Integer P_SEQ_NO) throws Exception {

		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_EMPLOYER_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LAPS_OVR_FRM_DT);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3", OracleParameter.DATA_TYPE.DATE, OracleParameter.DIRECTION_TYPE.IN, P_POL_LAPS_OVR_TO_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("OUT1", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.OUT, P_SEQ_NO);
			parameterList.add(param4);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_EMP_STP_ODR");

		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}

	
	public ArrayList<OracleParameter> callP_EMP_STP_ODR_UPD(
			String P_POL_EMPLOYER_CODE,
			Integer P_SEQ_NO,
			String P_UPD_FLG) throws Exception {

		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.IN, P_POL_EMPLOYER_CODE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2", OracleParameter.DATA_TYPE.INTEGER, OracleParameter.DIRECTION_TYPE.IN, P_SEQ_NO);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("OUT1", OracleParameter.DATA_TYPE.STRING, OracleParameter.DIRECTION_TYPE.OUT, P_UPD_FLG);
			parameterList.add(param3);


			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_EMP_STP_ODR_UPD");

		} catch(Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			e.printStackTrace();
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
	
	/*End*/

}
	
