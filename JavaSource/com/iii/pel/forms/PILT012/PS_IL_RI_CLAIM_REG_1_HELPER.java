package com.iii.pel.forms.PILT012;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PS_IL_RI_CLAIM_REG_1_HELPER {
	CRUDHandler handler = new CRUDHandler();
	public void executeQuery(PILT012_COMPOSITE_ACTION compositeAction) throws Exception {
		// TODO Auto-generated method stub
		String query = "SELECT ROWID, PS_IL_RI_CLAIM_REG.* FROM PS_IL_RI_CLAIM_REG WHERE ROWID= ?";
		Connection connection = null;
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler
					.executeSelectStatement(query, connection,new Object[] { compositeAction
									.getPS_IL_RI_CLAIM_REG_1_ACTION_BEAN().getPS_IL_RI_CLAIM_REG_1_BEAN().getROWID() });
			
			PS_IL_RI_CLAIM_REG_1 PS_IL_RI_CLAIM_REG_1_BEAN = compositeAction.getPS_IL_RI_CLAIM_REG_1_ACTION_BEAN().getPS_IL_RI_CLAIM_REG_1_BEAN();
			while (resultSet.next()) {
				PS_IL_RI_CLAIM_REG_1_BEAN.setROWID(resultSet.getString("ROWID"));
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_DIVN_CODE(resultSet.getString("RCR_DIVN_CODE"));
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_CLASS_CODE(resultSet.getString("RCR_CLASS_CODE"));
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_TREATY_CODE(resultSet.getString("RCR_TREATY_CODE"));
				
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_CLM_COVER_CODE(resultSet.getString("RCR_CLM_COVER_CODE"));
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_CLM_SYS_ID(resultSet.getLong("RCR_CLM_SYS_ID"));
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_CLM_NO(resultSet.getString("RCR_CLM_NO"));
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_POL_NO(resultSet.getString("RCR_POL_NO"));
				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_DT(resultSet.getDate("RCR_DT"));
				//PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_FC_CLM_ESTIMATE(resultSet.getDouble("RCR_FC_CLM_ESTIMATE"));
				//PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_FC_CLM_PAID(resultSet.getString("RCR_FC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_FAC_FC_CLM_EST(resultSet.getString("RCR_FAC_FC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_FAC_FC_CLM_PAID(resultSet.getString("RCR_FAC_FC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_RET_FC_CLM_EST(resultSet.getString("RCR_RET_FC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_RET_FC_CLM_PAID(resultSet.getString("RCR_RET_FC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_1S_FC_CLM_EST(resultSet.getString("RCR_1S_FC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_1S_FC_CLM_PAID(resultSet.getString("RCR_1S_FC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_2S_FC_CLM_EST(resultSet.getString("RCR_2S_FC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_2S_FC_CLM_PAID(resultSet.getString("RCR_2S_FC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_3S_FC_CLM_EST(resultSet.getString("RCR_3S_FC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_3S_FC_CLM_PAID(resultSet.getString("RCR_3S_FC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_SPL_RETN_FC_CLM_EST(resultSet.getString("RCR_SPL_RETN_FC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_SPL_RETN_FC_CLM_PAID(resultSet.getString("RCR_SPL_RETN_FC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_LC_CLM_ESTIMATE(resultSet.getString("RCR_LC_CLM_ESTIMATE"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_LC_CLM_PAID(resultSet.getString("RCR_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_FAC_LC_CLM_EST(resultSet.getString("RCR_FAC_LC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_FAC_LC_CLM_PAID(resultSet.getString("RCR_FAC_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_RET_LC_CLM_EST(resultSet.getString("RCR_RET_LC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_RET_LC_CLM_PAID(resultSet.getString("RCR_RET_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_1S_LC_CLM_EST(resultSet.getString("RCR_1S_LC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_1S_LC_CLM_PAID(resultSet.getString("RCR_1S_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_2S_LC_CLM_EST(resultSet.getString("RCR_2S_LC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_2S_LC_CLM_PAID(resultSet.getString("RCR_2S_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_3S_LC_CLM_EST(resultSet.getString("RCR_3S_LC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_3S_LC_CLM_PAID(resultSet.getString("RCR_3S_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_SPL_RETN_LC_CLM_EST(resultSet.getString("RCR_SPL_RETN_LC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_SPL_RETN_LC_CLM_PAID(resultSet.getString("RCR_SPL_RETN_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_CP_REF_SYS_ID(resultSet.getString("RCR_CP_REF_SYS_ID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_CR_UID(resultSet.getString("RCR_CR_UID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_CR_DT(resultSet.getString("RCR_CR_DT"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_YEAR(resultSet.getString("RCR_YEAR"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_PERIOD_NO(resultSet.getString("RCR_PERIOD_NO"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_QS_LC_CLM_EST(resultSet.getString("RCR_QS_LC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_QS_LC_CLM_PAID(resultSet.getString("RCR_QS_LC_CLM_PAID"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_QS_FC_CLM_EST(resultSet.getString("RCR_QS_FC_CLM_EST"));
//				PS_IL_RI_CLAIM_REG_1_BEAN.setRCR_QS_FC_CLM_PAID(resultSet.getString("RCR_QS_FC_CLM_PAID"));
				postQuery(compositeAction.getPS_IL_RI_CLAIM_REG_1_ACTION_BEAN());

			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public String postQuery(PS_IL_RI_CLAIM_REG_1_ACTION actionBean)throws Exception{
		try{
//			Map m = getSessionMap();
//			PS_IL_RI_CLAIM_REG_1_ACTION psIlRiClaimRegAction = (PS_IL_RI_CLAIM_REG_1_ACTION) m.get("PILT012_PS_IL_RI_CLAIM_REG_1_ACTION");
			String query="SELECT POL_CUST_CURR_CODE FROM PT_IL_POLICY WHERE POL_NO = ?";
			String query1="SELECT NVL(RCA_RI_CLM_CLOSE_FLAG,'N') FROM PT_IL_RI_CLAIM_ALLOC " +
					"WHERE RCA_CLM_SYS_ID = ? AND  RCA_CLAIM_COVER_CODE  = ? AND RCA_DT = ? ";
			String status=null;
			Object[] values = new Object[1];
			Object[] values1 = new Object[3];
			values[0] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_POL_NO();
			ResultSet rs = handler.executeSelectStatement(query, CommonUtils.getConnection(), values);
			while(rs.next()){
				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_POL_CUST_CURR_CODE(rs.getString("POL_CUST_CURR_CODE"));
			}
//			P_SET_FC_NUM_FMT_MASK(:PS_IL_RI_CLAIM_REG_1.M_POL_CUST_CURR_CODE); 
			rs.close();
			values1[0] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_SYS_ID();
			values1[1] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE();
			values1[2] = actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_DT();
			ResultSet rs1 = handler.executeSelectStatement(query1, CommonUtils.getConnection(), values1);
			while(rs1.next()){
//				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setM_RI_CLOSE(rs.getString("NVL(RCA_RI_CLM_CLOSE_FLAG,'N')"));
				status=rs1.getString(1);
			}
			System.out.println("******: "+actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getUI_M_RI_CLOSE());
			/*IF M_RI_CLOSE_FLAG = 'N'  THEN
	        	SET_ITEM_PROPERTY('M_BUT_CLOSE',ENABLED,PROPERTY_TRUE);
	        	:DUMMY.M_RI_CLOSE  := '           ';
	     	ELSE
	        	L_SET_CLOSE_REC_ATTRB('PS_IL_RI_CLAIM_REG');
	        	:DUMMY.M_RI_CLOSE  := 'Claim RI Closed';
	        	SET_ITEM_PROPERTY('M_BUT_CLOSE',ENABLED,PROPERTY_FALSE);
	     	END IF;*/
			rs1.close();
			if(status.equalsIgnoreCase("N")){
//				actionBean.getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_RI_CLOSE(status);
			}else{
//				L_SET_CLOSE_REC_ATTRB('PS_IL_RI_CLAIM_REG');
				actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_RI_CLOSE("Claim RI Closed");
//				actionBean.getCOMP_UI_M_BUT_CLOSE().setDisabled(false);
			}
			System.out.println("getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE(): "+actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE());
			System.out.println("getPS_IL_RI_CLAIM_REG_1_BEAN().getUI_M_COVER_DESC(): "+actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getUI_M_COVER_DESC());
			ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
			OracleParameter param1 = new OracleParameter("in1","STRING","IN",(String)actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getRCR_CLM_COVER_CODE());
			OracleParameter param2 = new OracleParameter("inout1","STRING","IN OUT",(String)actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().getUI_M_COVER_DESC());
			OracleParameter param3 = new OracleParameter("in2","STRING","IN","");
			OracleParameter param4 = new OracleParameter("in3","STRING","IN","N");
			//Hardcoded the CTRL.M_LANG_CODE
			OracleParameter param5 = new OracleParameter("in4","STRING","IN","ENG");
			paramList.add(param1);
			paramList.add(param2);
			paramList.add(param3);
			paramList.add(param4);
			paramList.add(param5);
			OracleProcedureHandler procHandler = new OracleProcedureHandler();
			ArrayList list = procHandler.execute(paramList, CommonUtils.getConnection(), "P_VAL_COVER");
			System.out.println("Output Param: "+list.get(0));
//			actionBean.getCOMP_M_COVER_DESC().setSubmittedValue(list.get(0));
			actionBean.getPS_IL_RI_CLAIM_REG_1_BEAN().setUI_M_COVER_DESC(((OracleParameter)list.get(0)).getValue());
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return null; 
	}
	
	public void WHEN_NEW_RECORD_INSTACE(PS_IL_RI_CLAIM_REG_1_ACTION PS_IL_RI_CLAIM_REG_1_ACTION_BEAN)throws Exception {
		PS_IL_RI_CLAIM_REG_1 PS_IL_RI_CLAIM_REG_1_BEAN = PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.getPS_IL_RI_CLAIM_REG_1_BEAN();
		String M_POL_FAC_YN	= null;
		String C1 ="SELECT NVL(POL_FAC_YN,'N') FROM   PT_IL_POLICY " +
				"WHERE  POL_NO = ?  ";
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = new CRUDHandler().executeSelectStatement(C1, con, new Object[]{PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_POL_NO()});
			while(rs.next()){
				M_POL_FAC_YN = rs.getString(1);
			}
		  if(PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_POL_NO()==null || PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_CLM_NO()==null || 
		     PS_IL_RI_CLAIM_REG_1_BEAN.getRCR_CLM_COVER_CODE() == null || !"Y".equals(CommonUtils.nvl(M_POL_FAC_YN,"N")))
			  PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.getCOMP_UI_M_BUT_FAC_DETAILS().setDisabled(true);
		  else
			  PS_IL_RI_CLAIM_REG_1_ACTION_BEAN.getCOMP_UI_M_BUT_FAC_DETAILS().setDisabled(false);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		  
	}

}
