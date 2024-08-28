package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_RI_PREM_ALLOC_HELPER {
	
	public void whenNewRecordInstance(){
		
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:44:47 PM
	 *
	 * user id and date are set before record creation to the object.
	 *
	 * @param riPremAlloc - instance of PT_IL_RI_PREM_ALLOC
	 * @throws ValidatorException
	 */
	public void preInsert(PT_IL_RI_PREM_ALLOC riPremAlloc) throws ValidatorException {
		ControlBean ctrlBean = CommonUtils.getControlBean();
		riPremAlloc.setRPA_CR_UID(ctrlBean.getM_USER_ID());
		riPremAlloc.setRPA_CR_DT(Calendar.getInstance().getTime());
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:46:02 PM
	 *
	 * Not called as insert/update is not done.
	 * 
	 * @param riPremAllocBean
	 * @throws ValidatorException
	 */
	public void whenCreateRecord(PT_IL_RI_PREM_ALLOC riPremAllocBean) throws ValidatorException {
		String M_DIVN_CODE=null;
		String M_CLASS_CODE=null;
		ResultSet vembu_C1=null;
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		PT_IL_RI_DETL_ACTION riDtlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		CRUDHandler handler = new CRUDHandler();
		Long RD_POL_SYS_ID = riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_POL_SYS_ID();
		try {
            String sql_C1="SELECT    POL_DIVN_CODE,    POL_CLASS_CODE FROM  PT_IL_POLICY  " +
            		"WHERE  POL_SYS_ID  = ? ";
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_SYS_ID});
            if(vembu_C1.next()) {
                M_DIVN_CODE=vembu_C1.getString(1);
                M_CLASS_CODE=vembu_C1.getString(2);
            }
            riPremAllocBean.setRPA_POL_SYS_ID(RD_POL_SYS_ID);
            riPremAllocBean.setRPA_DIVN_CODE(M_DIVN_CODE);
            riPremAllocBean.setRPA_CLASS_CODE(M_CLASS_CODE);
            riPremAllocBean.setRPA_POL_NO(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_POL_NO());
            riPremAllocBean.setRPA_END_NO(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_END_NO());
            riPremAllocBean.setRPA_END_NO_IDX(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_END_NO_IDX());
            riPremAllocBean.setRPA_UW_YEAR(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_UW_YEAR());
            riPremAllocBean.setRPA_YEAR(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_YEAR());
            riPremAllocBean.setRPA_COVER_CODE(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_COVER_CODE());
            riPremAllocBean.setRPA_COVER_TYPE(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_COVER_TYPE());
            riPremAllocBean.setRPA_COVER_SYS_ID(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_COVER_SYS_ID());
            riPremAllocBean.setRPA_TREATY_CODE(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_TREATY_CODE());
            riPremAllocBean.setRPA_DT(riDtlAction.getPT_IL_RI_DETL_BEAN().getRD_SCHD_DT());
            riPremAllocBean.setRPA_RI_CLOSE_FLAG("N");
        }catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
        	try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
        }
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:46:56 PM
	 *
	 * Treaty Description is set for a given record.
	 * 
	 * @param riPremAllocBean
	 * @throws ValidatorException
	 */
	public void postQuery(PT_IL_RI_PREM_ALLOC riPremAllocBean) throws ValidatorException {
		String RPA_TREATY_TYPE = riPremAllocBean.getRPA_TREATY_TYPE();
		String M_TTY_DESC = riPremAllocBean.getUI_M_TTY_DESC();
		try {
			M_TTY_DESC = (new DBProcedures().P_VAL_CODES_PROC_CALL("IL_TTY_TYP", RPA_TREATY_TYPE, "N", "N")).get(0);
			riPremAllocBean.setUI_M_TTY_DESC(M_TTY_DESC);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
				"RPA_REINS_PRD_FC_COMM,RPA_RI_GROSS_FC_PREM,RPA_PROCESS_TO_DT,RPA_RI_CLOSE_DT,RPA_RI_CUST_CODE,"
				+ "RPA_RI_CUST_PERC,RPA_CQS_YN FROM PT_IL_RI_PREM_ALLOC WHERE RPA_RD_SYS_ID = ?";
		String cust_desc_query="SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE=? ";
		PT_IL_RI_PREM_ALLOC_ACTION premAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_ACTION_INSTANCE();
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		PT_IL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		int RD_SYS_ID = riDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_SYS_ID();
		premAllocAction.getDataList_PT_IL_RI_PREM_ALLOC().clear();
		CRUDHandler handler = new CRUDHandler();
		ResultSet resultSet = null,resultSet1=null;
		try {
			resultSet = handler.executeSelectStatement(query, connection, new Object[]{RD_SYS_ID});
			while(resultSet.next()){
				PT_IL_RI_PREM_ALLOC riPremAllocBean = new PT_IL_RI_PREM_ALLOC();
				riPremAllocBean.setROWID(resultSet.getString("ROWID"));
				riPremAllocBean.setRPA_DIVN_CODE(resultSet.getString("RPA_DIVN_CODE"));                                   
				riPremAllocBean.setRPA_CLASS_CODE(resultSet.getString("RPA_CLASS_CODE"));                                 
				riPremAllocBean.setRPA_RD_SYS_ID(resultSet.getInt("RPA_RD_SYS_ID"));                                   
				riPremAllocBean.setRPA_POL_SYS_ID(resultSet.getLong("RPA_POL_SYS_ID"));                                 
				riPremAllocBean.setRPA_POL_NO(resultSet.getString("RPA_POL_NO"));                                         
				riPremAllocBean.setRPA_END_NO_IDX(resultSet.getInt("RPA_END_NO_IDX"));                                 
				riPremAllocBean.setRPA_END_NO(resultSet.getString("RPA_END_NO"));                                         
				riPremAllocBean.setRPA_UW_YEAR(resultSet.getInt("RPA_UW_YEAR"));                                       
				riPremAllocBean.setRPA_YEAR(resultSet.getInt("RPA_YEAR"));                                             
				riPremAllocBean.setRPA_COVER_CODE(resultSet.getString("RPA_COVER_CODE"));                                 
				riPremAllocBean.setRPA_COVER_SYS_ID(resultSet.getInt("RPA_COVER_SYS_ID"));                             
				riPremAllocBean.setRPA_COVER_TYPE(resultSet.getString("RPA_COVER_TYPE"));                                 
				riPremAllocBean.setRPA_TREATY_CODE(resultSet.getString("RPA_TREATY_CODE"));                               
				riPremAllocBean.setRPA_TREATY_TYPE(resultSet.getString("RPA_TREATY_TYPE"));                               
				riPremAllocBean.setRPA_SRNO(resultSet.getInt("RPA_SRNO"));                                             
				riPremAllocBean.setRPA_DT(resultSet.getDate("RPA_DT"));                                                   
				riPremAllocBean.setRPA_RET_FC_SA(resultSet.getDouble("RPA_RET_FC_SA"));                                   
				riPremAllocBean.setRPA_RET_FC_PREM(resultSet.getDouble("RPA_RET_FC_PREM"));                               
				riPremAllocBean.setRPA_RI_FC_SA(resultSet.getDouble("RPA_RI_FC_SA"));                                     
				riPremAllocBean.setRPA_RI_FC_PREM(resultSet.getDouble("RPA_RI_FC_PREM"));                                 
				riPremAllocBean.setRPA_RI_CLOSE_FLAG(resultSet.getString("RPA_RI_CLOSE_FLAG"));                           
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
				/*riPremAllocBean.setRPA_RET_FC_SUM_CEDED(resultSet.getDouble("RPA_RET_FC_SUM_CEDED"));                     
				riPremAllocBean.setRPA_RI_FC_SUM_CEDED(resultSet.getDouble("RPA_RI_FC_SUM_CEDED"));                       
				riPremAllocBean.setRPA_ASSURED_CODE(resultSet.getString("RPA_ASSURED_CODE"));                             
				riPremAllocBean.setRPA_ASSR_REF_ID1(resultSet.getString("RPA_ASSR_REF_ID1"));                             
				riPremAllocBean.setRPA_ASSR_REF_ID2(resultSet.getString("RPA_ASSR_REF_ID2"));                             
				riPremAllocBean.setRPA_FRZ_FLAG(resultSet.getString("RPA_FRZ_FLAG"));                                     
				riPremAllocBean.setRPA_PRD_FM_DT(resultSet.getDate("RPA_PRD_FM_DT"));                                     
				riPremAllocBean.setRPA_PRD_TO_DT(resultSet.getDate("RPA_PRD_TO_DT"));                                    
				riPremAllocBean.setRPA_PERIOD_NO(resultSet.getInt("RPA_PERIOD_NO"));*/                                    
				riPremAllocBean.setRPA_RET_LC_PRD_PREM(resultSet.getDouble("RPA_RET_LC_PRD_PREM"));                       
				riPremAllocBean.setRPA_RI_LC_PRD_PREM(resultSet.getDouble("RPA_RI_LC_PRD_PREM"));                         
				riPremAllocBean.setRPA_REINS_PRD_FC_COMM(resultSet.getDouble("RPA_REINS_PRD_FC_COMM"));                   
				riPremAllocBean.setRPA_RI_GROSS_FC_PREM(resultSet.getDouble("RPA_RI_GROSS_FC_PREM"));                     
				/*riPremAllocBean.setRPA_PROCESS_TO_DT(resultSet.getDate("RPA_PROCESS_TO_DT"));                             
				riPremAllocBean.setRPA_RI_CLOSE_DT(resultSet.getDate("RPA_RI_CLOSE_DT"));*/
				riPremAllocBean.setRPA_RI_CUST_CODE(resultSet.getString("RPA_RI_CUST_CODE"));
				riPremAllocBean.setRPA_RI_CUST_PERC(resultSet.getDouble("RPA_RI_CUST_PERC"));
				riPremAllocBean.setRPA_CQS_YN(resultSet.getString("RPA_CQS_YN"));
				resultSet1 = handler.executeSelectStatement(cust_desc_query, connection, new Object[]{
						riPremAllocBean.getRPA_RI_CUST_CODE()});
				if(resultSet1.next()){
					riPremAllocBean.setUI_M_CUST_CODE_DESC(resultSet1.getString("CUST_NAME"));
				}
				postQuery(riPremAllocBean);
				premAllocAction.getDataList_PT_IL_RI_PREM_ALLOC().add(riPremAllocBean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void riDiscLoadWhenButtonPressed() throws ValidatorException {
		try {
			PT_IL_RI_PREM_ALLOC_ACTION premAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_ACTION_INSTANCE();
			List<PT_IL_RI_PREM_ALLOC> premAllocList = premAllocAction.getDataList_PT_IL_RI_PREM_ALLOC();
			int selectCount = 0;
			int selectedIndex = 0;
			premAllocAction.setPT_IL_RI_PREM_ALLOC_BEAN(new PT_IL_RI_PREM_ALLOC());
			for(int i=0;i<premAllocList.size();i++){
				PT_IL_RI_PREM_ALLOC riPremAllocBean = premAllocList.get(i);
				//boolean selected = riPremAllocBean.isSelected();
				//[PREMIAGDC-PREMIUMALLOCATION-0080 : CHARAN 27-Feb-2009 Internal Fix
				if("dataTableSelectedRow".equalsIgnoreCase(riPremAllocBean.getRowSelected())){
					selectCount++;
					selectedIndex = i;
				}
				//PREMIAGDC-PREMIUMALLOCATION-0080 : CHARAN 27-Feb-2009 Internal Fix]
			}
			if(selectCount==1){
				premAllocAction.setPT_IL_RI_PREM_ALLOC_BEAN(premAllocList.get(selectedIndex));
			}else if(selectCount>1){
				throw new ValidatorException(new FacesMessage("Only one row can be selected"));
			}else{
				throw new ValidatorException(new FacesMessage("Atleast one row should be selected"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
	}

}
