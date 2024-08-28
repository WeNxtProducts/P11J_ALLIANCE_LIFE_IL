package com.iii.pel.forms.PT099_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_AGENT_PYMT_REVERSAL_DTLS_HELPER {

	public void execute_query() {
		
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION compositeAction=null;
		PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls=null;
		ArrayList<PT_AGENT_PYMT_REVERSAL_DTLS> agentPymtReversalDtlsList = null;
		
		compositeAction = (PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION) new CommonUtils().getMappedBeanFromSession("PT099_A_PT_AGENT_TRAN_COMPOSITE_ACTION");
		PT_AGENT_TRAN_HDR pt_agent_tran_hdr=compositeAction.getPT_AGENT_TRAN_HDR_ACTION_BEAN().getPT_AGENT_TRAN_HDR_BEAN();
		Double sysId=pt_agent_tran_hdr.getATH_SYS_ID();
		String query=PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_PYMT_REVERSAL_FETCH_SYS_ID_RELATED_DATA;
		
		try {
			connection=CommonUtils.getConnection();
			resultSet=handler.executeSelectStatement(query, connection, new Object[]{sysId});
			agentPymtReversalDtlsList=new ArrayList<PT_AGENT_PYMT_REVERSAL_DTLS>();
			while(resultSet.next()){
				pt_agent_pymt_reversal_dtls=new PT_AGENT_PYMT_REVERSAL_DTLS();
				
				pt_agent_pymt_reversal_dtls.setROWID(resultSet.getString("ROWID"));
				pt_agent_pymt_reversal_dtls.setAPRD_SYS_ID(resultSet.getDouble("APRD_SYS_ID"));
				pt_agent_pymt_reversal_dtls.setAPRD_ATH_SYS_ID(resultSet.getDouble("APRD_ATH_SYS_ID"));
				pt_agent_pymt_reversal_dtls.setAPRD_POL_SYS_ID(resultSet.getDouble("APRD_POL_SYS_ID"));
				pt_agent_pymt_reversal_dtls.setAPRD_PC_SYS_ID(resultSet.getDouble("APRD_PC_SYS_ID"));
				pt_agent_pymt_reversal_dtls.setAPRD_DT(resultSet.getDate("APRD_DT"));
				pt_agent_pymt_reversal_dtls.setAPRD_GEN_FLAG(resultSet.getString("APRD_GEN_FLAG"));
				pt_agent_pymt_reversal_dtls.setAPRD_APPRV_FLAG(resultSet.getString("APRD_APPRV_FLAG"));
				pt_agent_pymt_reversal_dtls.setAPRD_CR_DT(resultSet.getDate("APRD_CR_DT"));
				pt_agent_pymt_reversal_dtls.setAPRD_CR_UID(resultSet.getString("APRD_CR_UID"));
				pt_agent_pymt_reversal_dtls.setAPRD_UPD_DT(resultSet.getDate("APRD_UPD_DT"));
				pt_agent_pymt_reversal_dtls.setAPRD_UPD_UID(resultSet.getString("APRD_UPD_UID"));
				
				post_query(pt_agent_pymt_reversal_dtls,pt_agent_tran_hdr);
				agentPymtReversalDtlsList.add(pt_agent_pymt_reversal_dtls);
			}
			compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN().setBeanList(agentPymtReversalDtlsList);
			compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN().calculatePC_LC_Gross_prem(compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN());
			// [ BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper
			compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN().calculateUI_M_ACV_LC_VALUE(compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN());
			// BugId:PREMIAGDC-AGENCY-0021 Manoj Kumar Sahu 03-Feb-09 Made the form flow proper ]

			Iterator<PT_AGENT_PYMT_REVERSAL_DTLS> it = agentPymtReversalDtlsList.iterator();
			while(it.hasNext()){
				pt_agent_pymt_reversal_dtls = it.next();
				pt_agent_pymt_reversal_dtls.setRowSelected(false);
			}
			
			if (agentPymtReversalDtlsList.size()>0){					
				compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN().setPT_AGENT_PYMT_REVERSAL_DTLS_BEAN(agentPymtReversalDtlsList.get(0));
				compositeAction.getPT_AGENT_PYMT_REVERSAL_DTLS_ACTION_BEAN().getPT_AGENT_PYMT_REVERSAL_DTLS_BEAN().setRowSelected(true);
			}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void post_query(PT_AGENT_PYMT_REVERSAL_DTLS pt_agent_pymt_reversal_dtls,
													PT_AGENT_TRAN_HDR pt_agent_tran_hdr) {
		Connection connection = null;
		ResultSet resultSet1 = null;
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet2=null;
		
		try {
			connection=CommonUtils.getConnection();
			resultSet1=handler.executeSelectStatement(PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_PYMT_REVERSAL_POST_QUERY_1,
															connection, new Object[]{pt_agent_tran_hdr.getATH_POL_SYS_ID(),
																						pt_agent_tran_hdr.getATH_AGENT_CODE(),
																						pt_agent_pymt_reversal_dtls.getAPRD_PC_SYS_ID()});
	
			if(resultSet1.next()){
				pt_agent_pymt_reversal_dtls.setUI_M_PC_ACV_FC_VALUE(resultSet1.getDouble(1));
				//pt_agent_pymt_reversal_dtls.setUI_M_ACV_LC_VALUE(resultSet1.getDouble(2));
			}
			
			resultSet2=handler.executeSelectStatement(PT_AGENT_TRAN_HDR_QUERY_CONSTANTS.PT_AGENT_PYMT_REVERSAL_POST_QUERY_2,
														connection, new Object[]{pt_agent_pymt_reversal_dtls.getAPRD_POL_SYS_ID(),
																					pt_agent_pymt_reversal_dtls.getAPRD_PC_SYS_ID()});
			
			
			if(resultSet2.next()){
				pt_agent_pymt_reversal_dtls.setPC_SCHD_PYMT_DT(resultSet2.getDate(1));
				pt_agent_pymt_reversal_dtls.setPC_PAID_DT(resultSet2.getDate(2));
				pt_agent_pymt_reversal_dtls.setPC_FC_GROSS_PREM(resultSet2.getDouble(3));
				//pt_agent_pymt_reversal_dtls.setPC_LC_GROSS_PREM(resultSet2.getDouble(4));
			}
			
			
			
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(resultSet1);
				CommonUtils.closeCursor(resultSet2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
