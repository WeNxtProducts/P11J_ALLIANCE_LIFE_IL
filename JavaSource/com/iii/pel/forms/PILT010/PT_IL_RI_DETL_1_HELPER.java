package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_RI_DETL_1_HELPER {
	
	public String preQuery() throws ValidatorException {
		String M_WHERE=null;
		String M_CODE_DESC=null;
		String M_VALUE=null;
		String M_DUMMY=null;
		ResultSet vembu_C1=null;
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		String RD_POL_NO = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
		try {
            String sql_C1="SELECT 'X' FROM  PT_IL_RI_DETL  " +
            		"WHERE  RD_FRZ_FLAG  = 'N'  AND RD_POL_NO  = ? ";
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_NO, RD_POL_NO});
            if(vembu_C1.next()) {
                M_DUMMY=vembu_C1.getString(1);
            }
            if(M_DUMMY==null) {
                M_WHERE="RD_FRZ_FLAG = 'Y'";
            }
            else {
                M_WHERE="RD_FRZ_FLAG IN ('Y','E','U')";
            }
        } catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
        	try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
        }
        return M_WHERE;
	}
	
	public void postQuery(PT_IL_RI_DETL_1 ptRiDetl1Bean) throws ValidatorException {
		String M_POL_CLASS_CODE=null;
		String M_POL_UW_YEAR=null;
		ResultSet vembu_C1=null;
		ResultSet vembu_C2=null;
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		String RD_POL_NO = ptRiDetl1Bean.getRD_POL_NO();
		String RD_TREATY_CODE = ptRiDetl1Bean.getRD_TREATY_CODE().trim();
		try {
            String sql_C1="SELECT    POL_CLASS_CODE,    POL_UW_YEAR FROM  PT_IL_POLICY  " +
            		"WHERE  POL_NO  = ? ";
            String sql_C2="SELECT PT_TREATY_DESC FROM  PM_IL_PROP_TREATY  " +
            		"WHERE  PT_TREATY_CODE  = ? " +
            		"AND PT_UW_YEAR  = ?  " +
            				"AND PT_CLASS_CODE  = ? ";
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_NO});
            if(vembu_C1.next()) {
                M_POL_CLASS_CODE=vembu_C1.getString(1);
                M_POL_UW_YEAR=vembu_C1.getString(2);
            }
            vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{RD_TREATY_CODE, M_POL_UW_YEAR, M_POL_CLASS_CODE});
            if(vembu_C2.next()) {
            	ptRiDetl1Bean.setUI_M_TREATY_CODE_DESC(vembu_C2.getString(1));
            }
        }catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
        	try {
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
        }
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 6:12:23 PM
	 *
	 *
	 * @throws ValidatorException
	 */
	public void executeQuery() throws ValidatorException {
		//String M_QUERY = preQuery();
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		PT_IL_RI_DETL_1_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_1_ACTION_INSTANCE();
		riDetlAction.getDataList_PT_IL_RI_DETL_1().clear();
		String query = "SELECT ROWID, RD_SYS_ID,RD_POL_SYS_ID,RD_POL_NO,RD_END_NO_IDX,RD_END_NO," +
				"RD_UW_YEAR,RD_COVER_CODE,RD_COVER_SYS_ID,RD_COVER_TYPE,RD_TREATY_CODE," +
				"RD_SCHD_DT,RD_YEAR,RD_ASSURED_AGE,RD_TAR_RATE,RD_FC_SA,RD_FC_PREM,RD_FC_SUM_CEDED," +
				"RD_FC_POL_SA,RD_LC_POL_SA,RD_FC_POL_PREM,RD_LC_POL_PREM,RD_POL_EXCH_RATE," +
				"RD_POL_SA_CURR_CODE,RD_TREATY_CURR_CODE,RD_CUST_PREM_CURR_CODE,RD_CUST_PREM_EXCH_RATE," +
				"RD_TAR_RATE_PER,RD_ASSR_CODE,RD_FRZ_FLAG,RD_PRD_FM_DT,RD_PRD_TO_DT,RD_LC_PRD_PREM," +
				"RD_PRD_YEAR,RD_PRD_NO,RD_USER_UPD_YN,RD_REMARKS " +
				"FROM PT_IL_RI_DETL " +
				"WHERE RD_POL_SYS_ID=? " +
				"AND RD_FRZ_FLAG='Y'" ;
		Long RD_POL_SYS_ID = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
		Integer RD_END_NO_IDX = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{RD_POL_SYS_ID});
			while(rst.next()){
				PT_IL_RI_DETL_1 riDetlBean = new PT_IL_RI_DETL_1();
				riDetlBean.setROWID(rst.getString("ROWID"));
				riDetlBean.setRD_SYS_ID(rst.getInt("RD_SYS_ID"));
				riDetlBean.setRD_POL_SYS_ID(rst.getDouble("RD_POL_SYS_ID"));
				riDetlBean.setRD_POL_NO(rst.getString("RD_POL_NO"));
				riDetlBean.setRD_END_NO_IDX(rst.getInt("RD_END_NO_IDX"));
				riDetlBean.setRD_END_NO(rst.getString("RD_END_NO"));
				riDetlBean.setRD_UW_YEAR(rst.getInt("RD_UW_YEAR"));
				riDetlBean.setRD_COVER_CODE(rst.getString("RD_COVER_CODE"));
				riDetlBean.setRD_COVER_SYS_ID(rst.getString("RD_COVER_SYS_ID"));
				riDetlBean.setRD_COVER_TYPE(rst.getString("RD_COVER_TYPE"));
				riDetlBean.setRD_TREATY_CODE(rst.getString("RD_TREATY_CODE"));
				riDetlBean.setRD_SCHD_DT(rst.getDate("RD_SCHD_DT"));
				riDetlBean.setRD_YEAR(rst.getInt("RD_YEAR"));
//				riDetlBean.setRD_ASSURED_AGE(rst.getInt("RD_ASSURED_AGE"));
				riDetlBean.setRD_TAR_RATE(rst.getInt("RD_TAR_RATE"));
				riDetlBean.setRD_FC_SA(rst.getDouble("RD_FC_SA"));
				riDetlBean.setRD_FC_PREM(rst.getDouble("RD_FC_PREM"));
				/*riDetlBean.setRD_FC_SUM_CEDED(rst.getDouble("RD_FC_SUM_CEDED"));
				riDetlBean.setRD_FC_POL_SA(rst.getDouble("RD_FC_POL_SA"));
				riDetlBean.setRD_LC_POL_SA(rst.getDouble("RD_LC_POL_SA"));
				riDetlBean.setRD_FC_POL_PREM(rst.getDouble("RD_FC_POL_PREM"));
				riDetlBean.setRD_LC_POL_PREM(rst.getDouble("RD_LC_POL_PREM"));
				riDetlBean.setRD_POL_EXCH_RATE(rst.getInt("RD_POL_EXCH_RATE"));*/
//				riDetlBean.setRD_POL_SA_CURR_CODE(rst.getString("RD_POL_SA_CURR_CODE"));
//				riDetlBean.setRD_TREATY_CURR_CODE(rst.getString("RD_TREATY_CURR_CODE"));
//				riDetlBean.setRD_CUST_PREM_CURR_CODE(rst.getString("RD_CUST_PREM_CURR_CODE"));
//				riDetlBean.setRD_CUST_PREM_EXCH_RATE(rst.getInt("RD_CUST_PREM_EXCH_RATE"));
				riDetlBean.setRD_TAR_RATE_PER(rst.getInt("RD_TAR_RATE_PER"));
				riDetlBean.setRD_ASSR_CODE(rst.getString("RD_ASSR_CODE"));
				riDetlBean.setRD_FRZ_FLAG(rst.getString("RD_FRZ_FLAG"));
				riDetlBean.setRD_PRD_FM_DT(rst.getDate("RD_PRD_FM_DT"));
				riDetlBean.setRD_PRD_TO_DT(rst.getDate("RD_PRD_TO_DT"));
				riDetlBean.setRD_LC_PRD_PREM(rst.getDouble("RD_LC_PRD_PREM"));
//				riDetlBean.setRD_PRD_YEAR(rst.getInt("RD_PRD_YEAR"));
//				riDetlBean.setRD_PRD_NO(rst.getInt("RD_PRD_NO"));
				riDetlBean.setRD_REMARKS(rst.getString("RD_REMARKS"));
				postQuery(riDetlBean);
				riDetlAction.getDataList_PT_IL_RI_DETL_1().add(riDetlBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
	}
	
	public void populatePremiumAllocationDetails() throws ValidatorException {
		try {
			PT_IL_RI_DETL_1_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_1_ACTION_INSTANCE();
			riDetlAction.setPT_IL_RI_DETL_1_BEAN(getDataTableRowInstance());
			PT_IL_RI_PREM_ALLOC_1_HELPER premAllocHelper = new PT_IL_RI_PREM_ALLOC_1_HELPER();
			premAllocHelper.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public PT_IL_RI_DETL_1 getDataTableRowInstance() throws ValidatorException {
		PT_IL_RI_DETL_1_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_1_ACTION_INSTANCE();
		int rowIndex = riDetlAction.getCOMP_PT_IL_RI_DETL_1_DATATABLE().getRowIndex();
		return riDetlAction.getDataList_PT_IL_RI_DETL_1().get(rowIndex);
	}
	
	public void executeHistoryDetails() {
		try {
			
			executeQuery();
			PT_IL_RI_DETL_1_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_1_ACTION_INSTANCE();
			PT_IL_RI_PREM_ALLOC_1_ACTION riPremAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_1_ACTION_INSTANCE();
			ptRiDetlAction.resetAllComponent();
			riPremAllocAction.resetAllComponent();
			List<PT_IL_RI_DETL_1> ptRiDetlList = ptRiDetlAction.getDataList_PT_IL_RI_DETL_1();
			riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC_1().clear();
			if(ptRiDetlList!=null && ptRiDetlList.size()>0){
				PT_IL_RI_DETL_1 riDetlBean = ptRiDetlList.get(0);
				ptRiDetlAction.setPT_IL_RI_DETL_1_BEAN(riDetlBean);
				PT_IL_RI_PREM_ALLOC_1_HELPER riPremAllocHelper = new PT_IL_RI_PREM_ALLOC_1_HELPER();
				riPremAllocHelper.executeQuery();
				List<PT_IL_RI_PREM_ALLOC_1> ptPremAllocList = riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC_1();
				if(ptPremAllocList!=null && ptPremAllocList.size()>0){
					PT_IL_RI_PREM_ALLOC_1 riPremAllocBean = ptPremAllocList.get(0);
					riPremAllocBean.setRowSelected(true);
					riPremAllocAction.setPT_IL_RI_PREM_ALLOC_1_BEAN(riPremAllocBean);
					
					for(int i =0;i< ptPremAllocList.size();i++){
						PT_IL_RI_PREM_ALLOC_1 pt_il_ri_pre_1 = ptPremAllocList.get(i);
						if(i==0){
							pt_il_ri_pre_1.setRowSelected(true);
							riPremAllocAction.setPT_IL_RI_PREM_ALLOC_1_BEAN(pt_il_ri_pre_1);
						}else{
							pt_il_ri_pre_1.setRowSelected(false);
						}
					}
				}
				if(ptPremAllocList.isEmpty()){
					riPremAllocAction.setPT_IL_RI_PREM_ALLOC_1_BEAN(new PT_IL_RI_PREM_ALLOC_1());
				}
				
				for(int i =0;i< ptRiDetlList.size();i++){
					PT_IL_RI_DETL_1 pt_il_ri_detl_1 = ptRiDetlList.get(i);
					if(i==0){
						pt_il_ri_detl_1.setRowSelected(true);
						ptRiDetlAction.setPT_IL_RI_DETL_1_BEAN(pt_il_ri_detl_1);
					}else{
						pt_il_ri_detl_1.setRowSelected(false);
					}
				}
				
				if(ptRiDetlList.isEmpty()){
					ptRiDetlAction.setPT_IL_RI_DETL_1_BEAN(new PT_IL_RI_DETL_1());
				}
				
				
			}else{
				ptRiDetlAction.setPT_IL_RI_DETL_1_BEAN(new PT_IL_RI_DETL_1());
				riPremAllocAction.setPT_IL_RI_PREM_ALLOC_1_BEAN(new PT_IL_RI_PREM_ALLOC_1());
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
public void postQuery(PILT010_COMPOSITE_ACTION compositeAction) throws Exception {
		
		String RPA_TREATY_TYPE = compositeAction.getPILT010_PT_IL_RI_PREM_ALLOC_1_ACTION().getPT_IL_RI_PREM_ALLOC_1_BEAN().getRPA_TREATY_TYPE();
		//String M_TTY_DESC = riPremAllocBean.getUI_M_TTY_DESC();	
		DBProcedures procedures = new DBProcedures();
		// Commented to avoid compilation error, Dated: 15-Feb, Commented by: Manoj
		//M_TTY_DESC = new DBProcedures().P_VAL_CODES("IL_TTY_TYP", RPA_TREATY_TYPE, M_TTY_DESC);
		//riPremAllocBean.setUI_M_TTY_DESC(M_TTY_DESC);
		ArrayList<String> treatyDescList = procedures.helperP_VAL_CODES(
				"IL_TTY_TYP", CommonUtils.nvl(RPA_TREATY_TYPE," "), "N", "E",
				compositeAction.getPILT010_PT_IL_RI_PREM_ALLOC_ACTION().getPT_IL_RI_PREM_ALLOC_BEAN().getRPA_CLASS_CODE());
		if (treatyDescList != null && treatyDescList.size() != 0) {
			compositeAction.getPILT010_PT_IL_RI_PREM_ALLOC_1_ACTION().getPT_IL_RI_PREM_ALLOC_1_BEAN().setUI_M_TTY_DESC(treatyDescList.get(0));
}
	}
	
	
	
	public void executeHistoryDetails_1() throws ValidatorException {
		try {
			///executeQuery();
			//PT_IL_RI_DETL_1_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_1_ACTION_INSTANCE();
			PT_IL_RI_PREM_ALLOC_1_ACTION riPremAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_1_ACTION_INSTANCE();
			//List<PT_IL_RI_DETL_1> ptRiDetlList = ptRiDetlAction.getDataList_PT_IL_RI_DETL_1();
			riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC_1().clear();
			/*if(ptRiDetlList!=null && ptRiDetlList.size()>0){
				PT_IL_RI_DETL_1 riDetlBean = ptRiDetlList.get(0);
				ptRiDetlAction.setPT_IL_RI_DETL_1_BEAN(riDetlBean);*/
				PT_IL_RI_PREM_ALLOC_1_HELPER riPremAllocHelper = new PT_IL_RI_PREM_ALLOC_1_HELPER();
				riPremAllocHelper.executeQuery();
				List<PT_IL_RI_PREM_ALLOC_1> ptPremAllocList = riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC_1();
				if(ptPremAllocList!=null && ptPremAllocList.size()>0){
					PT_IL_RI_PREM_ALLOC_1 riPremAllocBean = ptPremAllocList.get(0);
					riPremAllocBean.setRowSelected(true);
					riPremAllocAction.setPT_IL_RI_PREM_ALLOC_1_BEAN(riPremAllocBean);
					
					for(int i =0;i< ptPremAllocList.size();i++){
						PT_IL_RI_PREM_ALLOC_1 pt_il_ri_pre_1 = ptPremAllocList.get(i);
						if(i==0){
							pt_il_ri_pre_1.setRowSelected(true);
							riPremAllocAction.setPT_IL_RI_PREM_ALLOC_1_BEAN(pt_il_ri_pre_1);
						}else{
							pt_il_ri_pre_1.setRowSelected(false);
						}
					}
				}
				if(ptPremAllocList.isEmpty()){
					riPremAllocAction.setPT_IL_RI_PREM_ALLOC_1_BEAN(new PT_IL_RI_PREM_ALLOC_1());
				}
				
			/*	for(int i =0;i< ptRiDetlList.size();i++){
					PT_IL_RI_DETL_1 pt_il_ri_detl_1 = ptRiDetlList.get(i);
					if(i==0){
						pt_il_ri_detl_1.setRowSelected(true);
						ptRiDetlAction.setPT_IL_RI_DETL_1_BEAN(pt_il_ri_detl_1);
					}else{
						pt_il_ri_detl_1.setRowSelected(false);
					}
				}
				
				if(ptRiDetlList.isEmpty()){
					ptRiDetlAction.setPT_IL_RI_DETL_1_BEAN(new PT_IL_RI_DETL_1());
				}
				*/
				
			//}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

}
