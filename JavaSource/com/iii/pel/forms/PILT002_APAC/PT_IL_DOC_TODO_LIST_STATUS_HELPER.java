package com.iii.pel.forms.PILT002_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DOC_TODO_LIST_STATUS_HELPER {

	CRUDHandler handler = new CRUDHandler();

	public void executeQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE().executeSelectStatement(compositeAction);

			List<PT_IL_DOC_TODO_LIST_STATUS> dataList = compositeAction
					.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getDataList_PT_IL_DOC_TODO_LIST_STATUS();
			
			
			if (dataList != null && dataList.size() > 0) {
				PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = dataList.get(0);
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
				compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
															.setPT_IL_DOC_TODO_LIST_STATUS_BEAN(
																	PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void preInsert(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		PM_IL_DOC_TODO_GROUP groupBean = compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN();
		PT_IL_POLICY policyBean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		
		
		
		Connection connection = null;
		ResultSet rs = null;
		CommonUtils commonUtils = new CommonUtils();
		String query1 = " SELECT PIL_DTLS_SYS_ID.NEXTVAL FROM   DUAL ";
		try {
			connection = CommonUtils.getConnection();
			IL_UNIQUE_TODOLIST_SRNO(listStatusBean);
			rs = handler.executeSelectStatement(query1, connection);
			if (rs.next()) {
				listStatusBean.setDTLS_SYS_ID(rs.getLong(1));
			}
			listStatusBean.setDTLS_CR_DT(commonUtils.getCurrentDate());
			listStatusBean.setDTLS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			listStatusBean.setDTLS_GROUP_CODE(groupBean.getDTG_GROUP_CODE());
			listStatusBean.setDTLS_POL_SYS_ID(policyBean.getPOL_SYS_ID());
			listStatusBean.setDTLS_END_NO_IDX(policyBean.getPOL_END_NO_IDX());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try{CommonUtils.closeCursor(rs);}catch(Exception e){}
		}
	}

	public void preUpdate(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		try {
			IL_UNIQUE_TODOLIST_SRNO(listStatusBean);
			listStatusBean.setDTLS_UPD_DT(commonUtils.getCurrentDate());
			listStatusBean.setDTLS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenNewBlockInstance(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		try {
			executeQuery( compositeAction);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

	

	public void preQuery(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		PM_IL_DOC_TODO_GROUP pm_il_doc_todo_group_bean = compositeAction
				.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN()
				.getPM_IL_DOC_TODO_GROUP_BEAN();
		try{
			pt_il_doc_todo_list_status_bean.setDTLS_GROUP_CODE(pm_il_doc_todo_group_bean.getDTG_GROUP_CODE());
		pt_il_doc_todo_list_status_bean.setDTLS_POL_SYS_ID(pt_il_policy_bean.getPOL_SYS_ID());
		pt_il_doc_todo_list_status_bean.setDTLS_END_NO_IDX(pt_il_policy_bean.getPOL_END_NO_IDX());
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception(e.getMessage());
	}
	}
	public void keyDelrec(PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN) throws Exception {
		try {
		if(CommonUtils.nvl(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_MANDATORY_YN(),"N").equals("Y")){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "3206",
									new Object[]{"Mandatory Records cannot be deleted"}));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void whenCreateRecord(PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
															.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		try{
		listStatusBean.setDTLS_MANDATORY_YN("N");
		listStatusBean.setDTLS_APPR_STS("N");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void DTLS_SR_NO_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PM_IL_DOC_TODO_GROUP groupBean = compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
																.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		String M_DUMMY = null;
		ResultSet rs2 = null;
		Connection connection = null;
		ResultSet rs3 = null;
		String M_DTL_TODO_LIST_ITEM = null;
		String M_DTL_TODO_LIST_ITEM_1 = null;
		Object[] values1 = {};
		Object[] values2 = {};
		Object[] values3 = {};
		
		CommonUtils commonUtils = new CommonUtils();
		String query1 = " SELECT 'X'  FROM PM_IL_DOC_TODO_LIST WHERE  DTL_DS_TYPE = ?   AND    DTL_DS_CODE = ? "
						+ " AND DTL_DTG_GROUP_CODE = ?   AND    DTL_SR_NO   = ? ";

		String query2 = " SELECT DTL_TODO_LIST_ITEM  FROM   PM_IL_DOC_TODO_LIST  WHERE  DTL_DS_TYPE = ? "
						+ " AND DTL_DS_CODE = ?  AND    DTL_DTG_GROUP_CODE = ?  AND    DTL_SR_NO   = ? ";

		String query3 = " SELECT DTL_TODO_LIST_ITEM FROM   PM_IL_DOC_TODO_LIST  WHERE  DTL_DS_TYPE = '3' "
						+ " AND  DTL_DS_CODE = ?  AND    DTL_DTG_GROUP_CODE = ?  AND    DTL_SR_NO   = ?";
		try {
			connection = CommonUtils.getConnection();

			values1 = new Object[] { 
									pt_il_policy_bean.getPOL_DS_TYPE(),
									pt_il_policy_bean.getPOL_DS_CODE(),
									groupBean.getDTG_GROUP_CODE(),
									listStatusBean.getDTLS_SR_NO() };
			values2 = new Object[] { 
									pt_il_policy_bean.getPOL_DS_TYPE(),
									pt_il_policy_bean.getPOL_DS_CODE(),
									groupBean.getDTG_GROUP_CODE(),
									listStatusBean.getDTLS_SR_NO() };
			values3 = new Object[] { 
									pt_il_policy_bean.getPOL_END_CODE(),
									groupBean.getDTG_GROUP_CODE(),
									listStatusBean.getDTLS_SR_NO() };

			if (listStatusBean.getDTLS_SR_NO() <= 0) {
				throw new Exception(Messages.getString(	PELConstants.pelErrorMessagePath,"91014",
						new Object[]{CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
																	"Serial Number ","Greater than Zero" }));
			}
			IL_UNIQUE_TODOLIST_SRNO(listStatusBean);
			if ((CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) == 0)
					|| ((pt_il_policy_bean.getPOL_DS_TYPE() == "1"))) {
				rs2 = handler.executeSelectStatement(query2, connection,values2);
					if (rs2.next()) {
						M_DTL_TODO_LIST_ITEM = rs2.getString(1);
						
						/*Modified by Janani on 19.07.2017 for ZBILQC-1732338*/
						
						//listStatusBean.setDTLS_TODO_LIST_ITEM("M_DTL_TODO_LIST_ITEM");
						listStatusBean.setDTLS_TODO_LIST_ITEM(M_DTL_TODO_LIST_ITEM);
						
						/*End*/
					}
			} else {
				rs3 = handler.executeSelectStatement(query3, connection,values3);
					if (rs3.next()) {
						M_DTL_TODO_LIST_ITEM_1 = rs3.getString(1);
						
						/*Modified by Janani on 19.07.2017 for ZBILQC-1732338*/
						
						//listStatusBean.setDTLS_TODO_LIST_ITEM("M_DTL_TODO_LIST_ITEM_1");
						listStatusBean.setDTLS_TODO_LIST_ITEM(M_DTL_TODO_LIST_ITEM_1);
						
						/*End*/
					}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try{CommonUtils.closeCursor(rs2);}catch(Exception e){}
			try{CommonUtils.closeCursor(rs3);}catch(Exception e){}
		}

	}
	
	
	

	public void IL_UNIQUE_TODOLIST_SRNO(PT_IL_DOC_TODO_LIST_STATUS listStatusBean) throws Exception {

		int M_POL_PROP_NO = 0;

		String query1 = " SELECT 'X'  FROM   PT_IL_DOC_TODO_LIST_STATUS WHERE  DTLS_SR_NO  = ? "
						+ " AND DTLS_POL_SYS_ID  = ? AND  NVL(DTLS_END_NO_IDX,0)  = NVL(?,0)  AND  DTLS_GROUP_CODE  = ?	 ";

		String query2 = " SELECT 'X'  FROM   PT_IL_DOC_TODO_LIST_STATUS  WHERE DTLS_SR_NO = ? AND DTLS_POL_SYS_ID  = ? "
						+ " AND NVL(DTLS_END_NO_IDX,0) = NVL(?,0)  AND    DTLS_GROUP_CODE  = ? " + "  AND    ROWID <> ? ";

		Connection connection = null;
		Object[] object1 = null, object2 = null;
		ResultSet rs1 = null, rs2 = null;
		String M_TODOLIST_SRNO = null;
		try {

			connection = CommonUtils.getConnection();
			object1 = new Object[] {
									listStatusBean.getDTLS_SR_NO(),
									listStatusBean.getDTLS_POL_SYS_ID(),
									listStatusBean.getDTLS_END_NO_IDX(),
									listStatusBean.getDTLS_GROUP_CODE() };

			if (listStatusBean.getROWID() == null) {
				rs1 = new CRUDHandler().executeSelectStatement(query1,connection, object1);

				if (rs1.next()) {
					M_TODOLIST_SRNO = rs1.getString(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90015",
											new Object[] {"Check List Serial No" }));
				}
			} else {
				object2 = new Object[] {
										listStatusBean.getDTLS_SR_NO(),
										listStatusBean.getDTLS_POL_SYS_ID(),
										listStatusBean.getDTLS_END_NO_IDX(),
										listStatusBean.getDTLS_GROUP_CODE(),
										listStatusBean.getROWID() };
				rs2 = new CRUDHandler().executeSelectStatement(query2,connection, object2);

				if (rs2.next()) {
					M_TODOLIST_SRNO = rs2.getString(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90015",
											new Object[] {"Check List Serial No" }));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
		}
		}
	}

	public void DTLS_APPR_STS_WHEN_VALIDATE_ITEM(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION listStatusAction = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		try {
			if ("Y".equals(listStatusBean.getDTLS_APPR_STS())) {
				listStatusBean.setDTLS_DOC_REC_DT(commonUtils.getCurrentDate());
				listStatusAction.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);
				if ("Y".equals(CommonUtils.SUBSTR(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),2, 1))) {
					listStatusAction.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);
				}
			} else {
				if ("N".equals(listStatusBean.getDTLS_APPR_STS())) {
					listStatusBean.setDTLS_DOC_REC_DT(null);
					listStatusAction.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
				} else {
					if ("NA".equals(listStatusBean.getDTLS_APPR_STS())) {
						/*Added by saranya for ssp call id ZBILQC-1719255 on 09-02-2017*/
						String Wav_Apprv_sts=ApprvStsChkList(compositeAction);
						if("N".equalsIgnoreCase(Wav_Apprv_sts))
						{
							
							/*Modified by Janani on 19.07.2017 for ZBILQC-1732338*/
							
							/*throw new Exception(Messages.getString(
											PELConstants.pelErrorMessagePath,"3206",
											new Object[] { "The User is not authorized to waive the mandatory requirement" }));*/

							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath,"3206",
									new Object[] { "The User is not authorized to waive checklist" }));
							/*End*/
						
						}
						
						/*End*/
						listStatusBean.setDTLS_DOC_REC_DT(null);
						listStatusAction.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/*Added by saranya for ssp call id ZBILQC-1719255 on 09-02-2017*/
	public String ApprvStsChkList(PILT002_APAC_COMPOSITE_ACTION compositeAction){
		PT_IL_POLICY pt_il_policy_bean = compositeAction
				.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		 String ASD_CHAR_VALUE = null;
		Connection connection = null;
		Object[] object1 = null;
		ResultSet rs1 = null;
		String query1 ="SELECT ASD_CHAR_VALUE FROM PM_IL_APPR_SETUP_DET WHERE ASD_USER_ID =? AND"
						+ " ASD_CODE = 'IL_CHKLST' AND ? BETWEEN ASD_FM_PROD_CODE AND  ASD_TO_PROD_CODE";
		try {
			connection = CommonUtils.getConnection();
			object1 = new Object[] {
										CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
										pt_il_policy_bean.getPOL_PROD_CODE()
									};
			rs1 = new CRUDHandler().executeSelectStatement(query1,connection, object1);
			if (rs1.next()) {
				ASD_CHAR_VALUE= rs1.getString(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ASD_CHAR_VALUE;
	}
	/*End*/

	/*public void DTLS_APPR_STS_WHEN_LIST_CHANGED(
			PILT002_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS pt_il_doc_todo_list_status_bean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		PT_IL_DOC_TODO_LIST_STATUS_ACTION pt_il_doc_todo_list_status_action = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		try {
			if ("Y".equals(pt_il_doc_todo_list_status_bean.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean.setDTLS_DOC_REC_DT(commonUtils
						.getCurrentDate());
				pt_il_doc_todo_list_status_action.getCOMP_DTLS_DOC_REC_DT()
						.setDisabled(false);
				// SET_ITEM_PROPERTY('PT_IL_DOC_TODO_LIST_STATUS.DTLS_DOC_REC_DT',NAVIGABLE,PROPERTY_TRUE);
				if ("Y".equals(CommonUtils.getGlobalVariable(
						"GLOBAL.M_PRIVILEGE").substring(2, 1))) {
					pt_il_doc_todo_list_status_action.getCOMP_DTLS_DOC_REC_DT()
							.setDisabled(false);
				}
			} else if ("N".equals(pt_il_doc_todo_list_status_bean
					.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean.setDTLS_DOC_REC_DT(null);
				pt_il_doc_todo_list_status_action.getCOMP_DTLS_DOC_REC_DT()
						.setDisabled(true);
			} else if ("NA".equals(pt_il_doc_todo_list_status_bean
					.getDTLS_APPR_STS())) {
				pt_il_doc_todo_list_status_bean.setDTLS_DOC_REC_DT(null);
				pt_il_doc_todo_list_status_action.getCOMP_DTLS_DOC_REC_DT()
						.setDisabled(true);
			}

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}*/
	
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
