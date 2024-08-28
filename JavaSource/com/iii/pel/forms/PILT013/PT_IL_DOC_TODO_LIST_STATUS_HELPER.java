package com.iii.pel.forms.PILT013;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DOC_TODO_LIST_STATUS_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void M_BUT_EDI_TODO_REMARKS_WHEN_BUTTON_PRESSED(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {

		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void M_BUT_LOV_DTLS_SR_NO_WHEN_BUTTON_PRESSED(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		try {
			String query = "SELECT DTL_SR_NO,DTL_TODO_LIST_ITEM,DTL_BL_TODO_LIST_ITEM FROM PM_IL_DOC_TODO_LIST ";
			String WHERE_CLAUSE = " WHERE DTL_DS_TYPE = '"
					+ pt_il_policy_bean.getPOL_DS_TYPE()
					+ "' AND DTL_DS_CODE = '"
					+ pt_il_policy_bean.getPOL_DS_CODE()
					+ "' AND DTL_DTG_GROUP_CODE = '"
					+ pm_il_doc_todo_group_bean.getDTG_GROUP_CODE() + "'";
			query = query + WHERE_CLAUSE;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void DTLS_APPR_STS_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		//committed by Dhinesh For checklist issue SSP Call id is FALCONQC-1714757
		Date UI_DTLS_APPR_STS = null;
		try {
			System.out.println("pt_il_doc_todo_list_status_bean.getDTLS_APPR_STS() ::::"+pt_il_doc_todo_list_status_bean.getDTLS_APPR_STS());
			if ("Y".equals(pt_il_doc_todo_list_status_bean.getDTLS_APPR_STS())) {
				/*pt_il_doc_todo_list_status_bean
						.setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);*/
				String selectStatement = " SELECT ROWID,PT_IL_DOC_TODO_LIST_STATUS.* FROM PT_IL_DOC_TODO_LIST_STATUS "
						+ " WHERE PT_IL_DOC_TODO_LIST_STATUS.DTLS_SMV_SYS_ID = ?  "
						//+ " AND  PT_IL_DOC_TODO_LIST_STATUS.DTLS_END_NO_IDX =?  " +
						+" AND DTLS_GROUP_CODE = ?"; 

				Connection connection = null;
				ResultSet resultSet = null;

				PT_IL_POLICY PT_IL_POLICY_BEAN = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();


				Long DTLS_SMV_SYS_ID = compositeAction.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN().getPT_IL_SURR_MAT_VALUES_BEAN().getSMV_SYS_ID();
				System.out.println("polSysid  :"+DTLS_SMV_SYS_ID);

				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(
						selectStatement, connection, new Object[] {
								DTLS_SMV_SYS_ID,
								//PT_IL_POLICY_BEAN.getPOL_END_NO_IDX(),
								compositeAction
								.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
								.getPM_IL_DOC_TODO_GROUP_BEAN()
								.getDTG_GROUP_CODE() });
				
				while (resultSet.next()) {

					UI_DTLS_APPR_STS=resultSet.getDate("DTLS_DOC_REC_DT");
				}
				//compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getCOMP_DTLS_DOC_REC_DT().resetValue();
				if(pt_il_doc_todo_list_status_bean
						.getDTLS_DOC_REC_DT()==null){

					/*pt_il_doc_todo_list_status_bean
					.setDTLS_DOC_REC_DT(UI_DTLS_APPR_STS);
					System.out.println("pt_il_doc_todo_list_status_bean :::    "+pt_il_doc_todo_list_status_bean.getDTLS_DOC_REC_DT());
				}else
				{*/
					pt_il_doc_todo_list_status_bean
					.setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
				}
//End
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);
			} else if ("N".equals(pt_il_doc_todo_list_status_bean
					.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean.setDTLS_DOC_REC_DT(null);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
			} else if ("NA".equals(pt_il_doc_todo_list_status_bean
					.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean.setDTLS_DOC_REC_DT(null);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void DTLS_APPR_STS_WHEN_LIST_CHANGED(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		try {
			if ("Y".equals(pt_il_doc_todo_list_status_bean.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean
						.setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);
			} else if ("N".equals(pt_il_doc_todo_list_status_bean
					.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean.setDTLS_DOC_REC_DT(null);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
			} else if ("NA".equals(pt_il_doc_todo_list_status_bean
					.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean.setDTLS_DOC_REC_DT(null);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
						.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void M_BUT_EDI_TODO_LIST_ITEM_WHEN_BUTTON_PRESSED(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void DTLS_SR_NO_WHEN_VALIDATE_ITEM(
			PILT013_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();

		Connection con = null;
		ResultSet rs2 = null;
		try {
			con = CommonUtils.getConnection();
			if ((Integer)currValue <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014",
						new Object[] { "Serial Number ", "Greater than Zero" }));
			}
			String M_DTL_TODO_LIST_ITEM = null;
			Object[] rsObj2 = new Object[4];
			rsObj2[0] = pt_il_policy_bean.getPOL_DS_TYPE();
			rsObj2[1] = pt_il_policy_bean.getPOL_DS_CODE();
			rsObj2[2] = pm_il_doc_todo_group_bean.getDTG_GROUP_CODE();
			rsObj2[3] = pt_il_doc_todo_list_status_bean.getDTLS_SR_NO();

			rs2 = handler
					.executeSelectStatement(
							PILT013_QUERYCONSTANTS.DTLS_SR_NO$WHEN_VALIDATE_ITEM_CURSOR_QRY_2,
							con, rsObj2);
			while (rs2.next()) {
				M_DTL_TODO_LIST_ITEM = rs2.getString(1);
				pt_il_doc_todo_list_status_bean
						.setDTLS_TODO_LIST_ITEM(M_DTL_TODO_LIST_ITEM);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		} finally {
			CommonUtils.closeCursor(rs2);
		}
	}

	public void KEY_DELREC(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		try {
			if (CommonUtils
					.nvl(
							pt_il_doc_todo_list_status_bean
									.getDTLS_MANDATORY_YN(), "N").equals("Y"))
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "3206",
						new Object[] { "Mandatory Records cannot be deleted" }));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void PRE_QUERY(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		PT_IL_SURR_MAT_VALUES pt_il_surr_mat_values_bean = compositeAction
				.getPT_IL_SURR_MAT_VALUES_ACTION_BEAN()
				.getPT_IL_SURR_MAT_VALUES_BEAN();
		try {
			pt_il_doc_todo_list_status_bean
					.setDTLS_SMV_SYS_ID(pt_il_surr_mat_values_bean
							.getSMV_SYS_ID());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {

		Connection con = null;
		try {
			compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
					.getCOMP_DTLS_MANDATORY_YN().setDisabled(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage());
		}
	}

	public void executeQuery(PILT013_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try{
			new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE()
					.executeSelectStatement(compositeAction);
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
	
	
	public boolean isAllowed(PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN){
		boolean temp = false;
		Connection connection = null;
		ResultSet rs1 = null;
		
		String query1 ="SELECT * FROM PM_IL_IMAGES WHERE LIMG_TRANSACTION_ID = ?";
		try {
			connection = CommonUtils.getConnection();
			rs1 = new CRUDHandler().executeSelectStatement(query1,connection, new Object[]{PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SYS_ID().toString()});
			if (rs1.next()) {
				temp = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	
	
}
