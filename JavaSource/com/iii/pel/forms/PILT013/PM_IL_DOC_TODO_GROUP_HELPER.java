package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.exception.ProcedureException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_TODO_GROUP_HELPER {
	CRUDHandler handler = new CRUDHandler();

	public void POST_QUERY(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
		.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN();
		String M_DTG_GROUP_CODE_DESC = null;
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String query = "SELECT PS_CODE_DESC FROM PP_SYSTEM WHERE PS_TYPE ='IL_TODO_GRP' AND PS_CODE = ? ";
		String query2 = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS WHERE DTLS_SMV_SYS_ID = ? AND DTLS_GROUP_CODE = ?";
		
		try {
			con = CommonUtils.getConnection();

			Object[] rsObj1 = new Object[1];
			rsObj1[0] = pm_il_doc_todo_group_bean.getDTG_GROUP_TYPE();

			rs1 = handler.executeSelectStatement(query,con, rsObj1);
			while (rs1.next()) {
				M_DTG_GROUP_CODE_DESC = rs1.getString(1);
			}
			pm_il_doc_todo_group_bean
					.setUI_M_DTG_GROUP_CODE_DESC(M_DTG_GROUP_CODE_DESC);
			
			// added for check list 
			rs2 = handler.executeSelectStatement(query2,con, new Object[]{pt_il_surr_mat_values_bean.getSMV_SYS_ID(),pm_il_doc_todo_group_bean.getDTG_GROUP_CODE()});
			if(!(rs2.next())){
				P_INS_SUR_DOLIST(pm_il_doc_todo_group_bean.getDTG_DS_TYPE(),
						pm_il_doc_todo_group_bean.getDTG_DS_CODE(),
						new CommonUtils().getCurrentDate(),
						pt_il_surr_mat_values_bean.getSMV_SYS_ID(), CommonUtils
								.getControlBean().getM_USER_ID());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		} finally {
			CommonUtils.closeCursor(rs1);
		}
	}

	//added by saranya
	public void executeQuery1(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
			new PM_IL_DOC_TODO_GROUP_DELEGATE()
			.executeSelectStatement1(compositeAction);
			List<PT_IL_DOC_TODO_LIST_STATUS> dataList = compositeAction
					.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
					.getDataList_PT_IL_DOC_TODO_LIST_STATUS();
			if (dataList != null && dataList.size() > 0) {
				PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = dataList
						.get(0);
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.setPT_IL_DOC_TODO_LIST_STATUS_BEAN(
								PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			}
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	
	
	//end
	
	public void PRE_DELETE(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			/*--*/
			/*-- Begin default relation program section*/
			/*--*/
			/*--*/
			/*-- Begin PT_IL_DOC_TODO_LIST_STATUS detail program section*/
			/*--*/
			Object[] objs1 = new Object[1];
			objs1[0] = pm_il_doc_todo_group_bean.getDTG_GROUP_CODE();

			handler.executeDeleteStatement(
					PILT013_QUERYCONSTANTS.PRE_DELETE_DELETE_QRY_1, con, objs1);
			/*--*/
			/*-- End PT_IL_DOC_TODO_LIST_STATUS detail program section*/
			/*--*/
			/*--*/
			/*-- End default relation program section*/
			/*--*/

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();

			// if(("CHANGED").equals(system_bean.getFORM_STATUS()) ||
			// (system_bean.getBLOCK_STATUS().equals("CHANGED") )) {
			// 'ctrl_bean.setM_COMM_DEL')("P");
			// 'system_bean.setMESSAGE_LEVEL'("20");
			// POST;
			// 'ctrl_bean.setM_COMM_DEL')("");
			// 'system_bean.setMESSAGE_LEVEL'("0");
			// }
			// new PM_IL_DOC_TODO_GROUP_HELPER().executeQuery();

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void PRE_QUERY(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		try {
			if ("S".equals(pt_il_surr_mat_values_bean.getSMV_TYPE()))
				pm_il_doc_todo_group_bean.setDTG_DS_TYPE("8");
			else if ("M".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())
					/*|| "R".equals(pt_il_surr_mat_values_bean.getSMV_TYPE())*/)
				pm_il_doc_todo_group_bean.setDTG_DS_TYPE("M");
			else if ("P".equals(pt_il_surr_mat_values_bean.getSMV_TYPE()))
					pm_il_doc_todo_group_bean.setDTG_DS_TYPE("P");
			else if ("R".equals(pt_il_surr_mat_values_bean.getSMV_TYPE()))
				pm_il_doc_todo_group_bean.setDTG_DS_TYPE("R");

		} catch (Exception ex) {
			ex.printStackTrace();
			throw ex;
		}
	}

	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_DOC_TODO_GROUP_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PM_IL_DOC_TODO_GROUP> dataList = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getDataList_PM_IL_DOC_TODO_GROUP();
		if (dataList != null && dataList.size() > 0) {
			PM_IL_DOC_TODO_GROUP PM_IL_DOC_TODO_GROUP_BEAN = dataList.get(0);
			PM_IL_DOC_TODO_GROUP_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
					.setPM_IL_DOC_TODO_GROUP_BEAN(PM_IL_DOC_TODO_GROUP_BEAN);
		}
	}


	  public ArrayList<OracleParameter> P_INS_SUR_DOLIST(String M_POL_DS_TYPE,
			String M_POL_DS_CODE, Date P_EFF_DT, Long P_SMV_SYS_ID,
			String CTRL_M_USER_ID) throws ProcedureException {
		Connection connection = null;
		ArrayList<OracleParameter> parameterList = null;
		ArrayList<OracleParameter> outputList = null;
		try {
			connection = CommonUtils.getConnection();
			parameterList = new ArrayList<OracleParameter>();
			outputList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("IN1",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_POL_DS_TYPE);
			parameterList.add(param1);
			OracleParameter param2 = new OracleParameter("IN2",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, M_POL_DS_CODE);
			parameterList.add(param2);
			OracleParameter param3 = new OracleParameter("IN3",
					OracleParameter.DATA_TYPE.DATE,
					OracleParameter.DIRECTION_TYPE.IN, P_EFF_DT);
			parameterList.add(param3);
			OracleParameter param4 = new OracleParameter("IN4",
					OracleParameter.DATA_TYPE.LONG,
					OracleParameter.DIRECTION_TYPE.IN, P_SMV_SYS_ID);
			parameterList.add(param4);
			OracleParameter param5 = new OracleParameter("IN5",
					OracleParameter.DATA_TYPE.STRING,
					OracleParameter.DIRECTION_TYPE.IN, CTRL_M_USER_ID);
			parameterList.add(param5);

			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			outputList = procHandler.executeProc(parameterList, connection,
					"P_INS_SUR_DOLIST");
		} catch (Exception e) {
			ErrorHelpUtil.getErrorForProcedure(connection);
			throw new ProcedureException(e.getMessage());
		}
		return outputList;
	}
}
