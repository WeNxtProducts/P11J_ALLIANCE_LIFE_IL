package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILM015_APAC.PM_IL_PROP_TREATY_CONSTANTS;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_RI_PREM_ALLOC_1_HELPER {
	
	public void postQuery(PT_IL_RI_PREM_ALLOC_1 PT_IL_RI_PREM_ALLOC_1_BEAN,PT_IL_RI_PREM_ALLOC PT_IL_RI_PREM_ALLOC_BEAN) throws Exception {
		
		String RPA_TREATY_TYPE = PT_IL_RI_PREM_ALLOC_1_BEAN.getRPA_TREATY_TYPE();
		//String M_TTY_DESC = riPremAllocBean.getUI_M_TTY_DESC();	
		DBProcedures procedures = new DBProcedures();
		// Commented to avoid compilation error, Dated: 15-Feb, Commented by: Manoj
		//M_TTY_DESC = new DBProcedures().P_VAL_CODES("IL_TTY_TYP", RPA_TREATY_TYPE, M_TTY_DESC);
		//riPremAllocBean.setUI_M_TTY_DESC(M_TTY_DESC);
		ArrayList<String> treatyDescList = procedures.helperP_VAL_CODES(
				"IL_TTY_TYP", RPA_TREATY_TYPE, "N", "E",
				PT_IL_RI_PREM_ALLOC_BEAN.getRPA_CLASS_CODE());
		if (treatyDescList != null && treatyDescList.size() != 0) {
			PT_IL_RI_PREM_ALLOC_1_BEAN.setUI_M_TTY_DESC(treatyDescList.get(0));
}
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 6:06:53 PM
	 *
	 * retrieves data from PT_IL_RI_PREM_ALLOC
	 * 
	 * @throws ValidatorException
	 */
	public void executeQuery() throws ValidatorException {
		
		String query = "SELECT ROWID, RPA_DIVN_CODE,RPA_CLASS_CODE,RPA_RD_SYS_ID,RPA_POL_SYS_ID,RPA_POL_NO," +
				"RPA_END_NO_IDX,RPA_END_NO,RPA_UW_YEAR,RPA_YEAR,RPA_COVER_CODE,RPA_COVER_SYS_ID," +
				"RPA_COVER_TYPE,RPA_TREATY_CODE,RPA_TREATY_TYPE,RPA_SRNO,RPA_DT,RPA_RET_FC_SA," +
				"RPA_RET_FC_PREM,RPA_RI_FC_SA,RPA_RI_FC_PREM,RPA_RI_CLOSE_FLAG,RPA_REINS_COMM_PERC," +
				"RPA_REINS_FC_COMM,RPA_RI_FC_POL_SA,RPA_RI_FC_POL_PREM,RPA_RET_FC_POL_SA,RPA_RET_FC_POL_PREM," +
				"RPA_RI_LC_POL_SA,RPA_RI_LC_POL_PREM,RPA_RET_LC_POL_SA,RPA_RET_LC_POL_PREM,RPA_FC_EXTRA_PREM," +
				"RPA_RET_FC_SUM_CEDED,RPA_RI_FC_SUM_CEDED,RPA_ASSURED_CODE,RPA_ASSR_REF_ID1,RPA_ASSR_REF_ID2," +
				"RPA_FRZ_FLAG,RPA_PRD_FM_DT,RPA_PRD_TO_DT,RPA_PERIOD_NO,RPA_RET_LC_PRD_PREM,RPA_RI_LC_PRD_PREM," +
				"RPA_REINS_PRD_FC_COMM,RPA_RI_GROSS_FC_PREM,RPA_PROCESS_TO_DT,RPA_RI_CLOSE_DT " +
				"FROM PT_IL_RI_PREM_ALLOC " +
				"WHERE RPA_RD_SYS_ID = ?";
		Connection connection = null;
		PT_IL_RI_DETL_1_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_1_ACTION_INSTANCE();
		PT_IL_RI_PREM_ALLOC_1_ACTION riPremAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_1_ACTION_INSTANCE();
		int RD_SYS_ID = riDetlAction.getPT_IL_RI_DETL_1_BEAN().getRD_SYS_ID();
		riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC_1().clear();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{RD_SYS_ID});
			while(resultSet.next()){
				PT_IL_RI_PREM_ALLOC_1 riPremAllocBean = new PT_IL_RI_PREM_ALLOC_1();
				riPremAllocBean.setROWID(resultSet.getString("ROWID"));
//				riPremAllocBean.setRPA_DIVN_CODE(resultSet.getString("RPA_DIVN_CODE"));                                   
//				riPremAllocBean.setRPA_CLASS_CODE(resultSet.getString("RPA_CLASS_CODE"));                                 
//				riPremAllocBean.setRPA_RD_SYS_ID(resultSet.getInt("RPA_RD_SYS_ID"));                                   
//				riPremAllocBean.setRPA_POL_SYS_ID(resultSet.getInt("RPA_POL_SYS_ID"));                                 
//				riPremAllocBean.setRPA_POL_NO(resultSet.getString("RPA_POL_NO"));                                         
//				riPremAllocBean.setRPA_END_NO_IDX(resultSet.getInt("RPA_END_NO_IDX"));                                 
//				riPremAllocBean.setRPA_END_NO(resultSet.getString("RPA_END_NO"));                                         
//				riPremAllocBean.setRPA_UW_YEAR(resultSet.getInt("RPA_UW_YEAR"));                                       
//				riPremAllocBean.setRPA_YEAR(resultSet.getInt("RPA_YEAR"));                                             
				riPremAllocBean.setRPA_COVER_CODE(resultSet.getString("RPA_COVER_CODE"));                                 
//				riPremAllocBean.setRPA_COVER_SYS_ID(resultSet.getInt("RPA_COVER_SYS_ID"));                             
//				riPremAllocBean.setRPA_COVER_TYPE(resultSet.getString("RPA_COVER_TYPE"));                                 
//				riPremAllocBean.setRPA_TREATY_CODE(resultSet.getString("RPA_TREATY_CODE"));                               
				riPremAllocBean.setRPA_TREATY_TYPE(resultSet.getString("RPA_TREATY_TYPE"));                               
//				riPremAllocBean.setRPA_SRNO(resultSet.getInt("RPA_SRNO"));                                             
//				riPremAllocBean.setRPA_DT(resultSet.getDate("RPA_DT"));                                                   
				riPremAllocBean.setRPA_RET_FC_SA(resultSet.getDouble("RPA_RET_FC_SA"));                                   
				riPremAllocBean.setRPA_RET_FC_PREM(resultSet.getDouble("RPA_RET_FC_PREM"));                               
				riPremAllocBean.setRPA_RI_FC_SA(resultSet.getDouble("RPA_RI_FC_SA"));                                     
				riPremAllocBean.setRPA_RI_FC_PREM(resultSet.getDouble("RPA_RI_FC_PREM"));                                 
//				riPremAllocBean.setRPA_RI_CLOSE_FLAG(resultSet.getString("RPA_RI_CLOSE_FLAG"));                           
				riPremAllocBean.setRPA_REINS_COMM_PERC(resultSet.getDouble("RPA_REINS_COMM_PERC"));                       
				riPremAllocBean.setRPA_REINS_FC_COMM(resultSet.getDouble("RPA_REINS_FC_COMM"));                           
				riPremAllocBean.setRPA_RI_FC_POL_SA(resultSet.getDouble("RPA_RI_FC_POL_SA"));                             
				riPremAllocBean.setRPA_RI_FC_POL_PREM(resultSet.getDouble("RPA_RI_FC_POL_PREM"));                         
				riPremAllocBean.setRPA_RET_FC_POL_SA(resultSet.getDouble("RPA_RET_FC_POL_SA"));                           
				riPremAllocBean.setRPA_RET_FC_POL_PREM(resultSet.getDouble("RPA_RET_FC_POL_PREM"));                       
				riPremAllocBean.setRPA_RI_LC_POL_SA(resultSet.getDouble("RPA_RI_LC_POL_SA"));                             
				riPremAllocBean.setRPA_RI_LC_POL_PREM(resultSet.getDouble("RPA_RI_LC_POL_PREM"));                         
				riPremAllocBean.setRPA_RET_LC_POL_SA(resultSet.getDouble("RPA_RET_LC_POL_SA"));                           
				riPremAllocBean.setRPA_RET_LC_POL_PREM(resultSet.getDouble("RPA_RET_LC_POL_PREM"));                       
				riPremAllocBean.setRPA_FC_EXTRA_PREM(resultSet.getDouble("RPA_FC_EXTRA_PREM"));                           
				riPremAllocBean.setRPA_ASSURED_CODE(resultSet.getString("RPA_ASSURED_CODE"));                             
				/*riPremAllocBean.setRPA_RET_FC_SUM_CEDED(resultSet.getDouble("RPA_RET_FC_SUM_CEDED"));                     
				riPremAllocBean.setRPA_RI_FC_SUM_CEDED(resultSet.getDouble("RPA_RI_FC_SUM_CEDED"));                       
				riPremAllocBean.setRPA_ASSR_REF_ID1(resultSet.getString("RPA_ASSR_REF_ID1"));                             
				riPremAllocBean.setRPA_ASSR_REF_ID2(resultSet.getString("RPA_ASSR_REF_ID2"));                             
				riPremAllocBean.setRPA_FRZ_FLAG(resultSet.getString("RPA_FRZ_FLAG"));                                     
				riPremAllocBean.setRPA_PRD_FM_DT(resultSet.getDate("RPA_PRD_FM_DT"));                                     
				riPremAllocBean.setRPA_PRD_TO_DT(resultSet.getDate("RPA_PRD_TO_DT"));                                    
				riPremAllocBean.setRPA_PERIOD_NO(resultSet.getInt("RPA_PERIOD_NO"));*/                                    
				riPremAllocBean.setRPA_RET_LC_PRD_PREM(resultSet.getDouble("RPA_RET_LC_PRD_PREM"));                       
				riPremAllocBean.setRPA_RI_LC_PRD_PREM(resultSet.getDouble("RPA_RI_LC_PRD_PREM"));                         
				riPremAllocBean.setRPA_REINS_PRD_FC_COMM(resultSet.getDouble("RPA_REINS_PRD_FC_COMM"));                   
//				riPremAllocBean.setRPA_RI_GROSS_FC_PREM(resultSet.getDouble("RPA_RI_GROSS_FC_PREM"));                     
				/*riPremAllocBean.setRPA_PROCESS_TO_DT(resultSet.getDate("RPA_PROCESS_TO_DT"));                             
				riPremAllocBean.setRPA_RI_CLOSE_DT(resultSet.getDate("RPA_RI_CLOSE_DT"));*/
				riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC_1().add(riPremAllocBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(Exception e){
			}
		}
	}

}
