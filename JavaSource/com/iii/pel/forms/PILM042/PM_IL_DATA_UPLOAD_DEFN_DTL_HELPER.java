package com.iii.pel.forms.PILM042;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_DISC_LOAD;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DATA_UPLOAD_DEFN_DTL_HELPER {
	public void L_UNIQUE_SERIAL_NO(String DUDH_DEF_CODE, String DUDD_SERIAL_NO,String ROWID) throws Exception {
		String sql_C1 = "SELECT 'X' FROM  PM_IL_DATA_UPLOAD_DEFN_DTL  WHERE  DUDD_DUDH_DEF_CODE  = '" + DUDH_DEF_CODE+ "'  AND DUDD_SERIAL_NO  = '" + DUDD_SERIAL_NO + "' ";
		String sql_C2 = "SELECT 'X' FROM  PM_IL_DATA_UPLOAD_DEFN_DTL  WHERE  DUDD_DUDH_DEF_CODE  = '"+ DUDH_DEF_CODE+ "'  AND DUDD_SERIAL_NO  = '"+ DUDD_SERIAL_NO + "'  AND ROWID  != '" + ROWID + "' ";
		String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		ResultSet rst1 = null;

		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if (ROWID == null) {
				rst = handler.executeSelectStatement(sql_C1, con);
				if(rst.next()){
					M_DUMMY=rst.getString(1);
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91250"));
				}
			}else{
				rst1 = handler.executeSelectStatement(sql_C2, con);
				if(rst1.next()){
					M_DUMMY=rst1.getString(1);
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91250"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try {CommonUtils.closeCursor(rst);CommonUtils.closeCursor(rst1);} catch (Exception e) {}}
	}
    public void preInsert(PM_IL_DATA_UPLOAD_DEFN_DTL detailBean,PM_IL_DATA_UPLOAD_DEFN_HDR headerBean) throws Exception{
    	try {
    		String DUDD_DUDH_DEF_CODE = headerBean.getDUDH_DEF_CODE();
    		detailBean.setDUDD_CR_DT(new CommonUtils().getCurrentDate());
    		detailBean.setDUDD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
    		detailBean.setDUDD_DUDH_DEF_CODE(DUDD_DUDH_DEF_CODE);
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
		}
    }
    
    public void preUpdate(PM_IL_DATA_UPLOAD_DEFN_DTL detailBean,PM_IL_DATA_UPLOAD_DEFN_HDR headerBean) throws Exception{
    	try {
    		detailBean.setDUDD_UPD_DT(new CommonUtils().getCurrentDate());
    		detailBean.setDUDD_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
    }
    
    public void whenCreateRecord(PM_IL_DATA_UPLOAD_DEFN_DTL detailBean){
    	detailBean.setDUDD_PARA_TYPE("P");
    	detailBean.setDUDD_INPUT_DATA_TYPE("C");
    	detailBean.setDUDD_RET_PARA("5");
    	detailBean.setDUDD_STORAGE_YN("N");
    }
    

    public void executeQuery(PILM042_COMPOSITE_ACTION compositeAction){
    	PM_IL_DATA_UPLOAD_DEFN_DTL_DELEGATE pm_il_data_upload_defn_dtl_delegate = new PM_IL_DATA_UPLOAD_DEFN_DTL_DELEGATE();
    	pm_il_data_upload_defn_dtl_delegate.executeQuery(compositeAction);
    	List<PM_IL_DATA_UPLOAD_DEFN_DTL> dataList = compositeAction
		.getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN()
		.getDataList_PM_IL_DATA_UPLOAD_DEFN_DTL();
if (dataList != null && dataList.size() > 0) {
	PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = dataList.get(0);
	PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setRowSelected(true);
	compositeAction.getPM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN()
			.setPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN);
}
    	
    }
    
    
    public void validateTableName(String tableName) throws Exception {
		String sql_C1 = "SELECT 1 FROM USER_TABLES WHERE TABLE_NAME = ?";
		String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rst = handler.executeSelectStatement(sql_C1, con,new Object[]{tableName});
			if(rst.next()){
				M_DUMMY=rst.getString(1);
			}else{
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91253",new Object[]{tableName}));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{try {CommonUtils.closeCursor(rst);} catch (Exception e) {}}
	}
    

    public void validateDuddFormat(String DUDD_FORMAT) throws ValidatorException {
		String sql_C1 = "SELECT 'X' FROM PM_CODES WHERE PC_CODE = ?";
		String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		String M_VAL =null;

		try {
			con = CommonUtils.getConnection();
			if (DUDD_FORMAT != null) {
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(sql_C1, con,
						new Object[] { DUDD_FORMAT });
				if (rst.next()) {
					M_VAL = rst.getString(1);
				} else {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91258",
							new Object[] { CommonUtils.getControlBean()
									.getM_LANG_CODE() }));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{try {CommonUtils.closeCursor(rst);} catch (Exception e) {e.printStackTrace();}}
	}
    
    
    public void validateDuddFieldName(String fieldName,String tableName, PILM042_COMPOSITE_ACTION compositeAction) throws Exception{
		String sql_C1 = "SELECT 1 FROM USER_TAB_COLS  WHERE COLUMN_NAME = ? AND TABLE_NAME = ?";
		String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		String M_VAL =null;

		try {
			con = CommonUtils.getConnection();
			if (fieldName != null) {
				handler = new CRUDHandler();
				
				String queryOutput=null;
				String Query="SELECT DUM_EMPLOYER_TYPE FROM PM_IL_DATA_UPLOAD_MAPPING,PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUM_DEF_CODE = DUDD_DUDH_DEF_CODE AND DUDD_DUDH_DEF_CODE = ?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{
					compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN().getDUDH_DEF_CODE()});
				while(rs.next())
				{
					queryOutput=rs.getString("DUM_EMPLOYER_TYPE");	
				}
				if(!queryOutput.equalsIgnoreCase(null) && queryOutput.equalsIgnoreCase("U"))
				{
				rst = handler.executeSelectStatement(sql_C1, con,new Object[] { fieldName,tableName });
				if (rst.next()) {
					M_VAL = rst.getString(1);
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91254",new Object[] { fieldName,tableName }));
				}
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try {CommonUtils.closeCursor(rst);} catch (Exception e) {}}
	}
    
    public void validateDuddLink(String linkColoumn,String tableName, PILM042_COMPOSITE_ACTION compositeAction) throws Exception {
		String sql_C1 = "SELECT 1 FROM USER_TAB_COLS  WHERE COLUMN_NAME = ? AND TABLE_NAME = ?";
		String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		String M_VAL =null;

		try {
			con = CommonUtils.getConnection();
				handler = new CRUDHandler();
				
				String queryOutput=null;
				String Query="SELECT DUM_EMPLOYER_TYPE FROM PM_IL_DATA_UPLOAD_MAPPING,PM_IL_DATA_UPLOAD_DEFN_DTL WHERE DUM_DEF_CODE = DUDD_DUDH_DEF_CODE AND DUDD_DUDH_DEF_CODE = ?";
				ResultSet rs=new CRUDHandler().executeSelectStatement(Query, CommonUtils.getConnection(), new Object[]{
					compositeAction.getPM_IL_DATA_UPLOAD_DEFN_HDR_ACTION_BEAN().getPM_IL_DATA_UPLOAD_DEFN_HDR_BEAN().getDUDH_DEF_CODE()});
				while(rs.next())
				{
					queryOutput=rs.getString("DUM_EMPLOYER_TYPE");	
				}
				if(!queryOutput.equalsIgnoreCase(null) && queryOutput.equalsIgnoreCase("U"))
				{
					
				
				rst = handler.executeSelectStatement(sql_C1, con,new Object[] { linkColoumn,tableName });
				if (rst.next()) {
					M_VAL = rst.getString(1);
				} else {
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91254",new Object[] { linkColoumn,tableName }));
				}
				}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try {CommonUtils.closeCursor(rst);} catch (Exception e) {}}
	}
    
    public void retParaWhenListChanged(PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN,
    		PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN) throws Exception{
    	
    	String sql_C1 = "SELECT DUDD_RET_PARA,DUDD_LINK_SERIAL_NO "
				+ "FROM   PM_IL_DATA_UPLOAD_DEFN_DTL "
				+ "WHERE  DUDD_DUDH_DEF_CODE = ? "
				+ "AND    DUDD_PARA_TYPE = 'P'";
    	
    	PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN();
		String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		String M_VAL =null;
		String M_DUDD_RET_PARA =null;
		int M_DUDD_LINK_SERIAL_NO=0;
		try {
			con = CommonUtils.getConnection();
				handler = new CRUDHandler();
				rst = handler.executeSelectStatement(sql_C1, con,new Object[] { PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getDUDH_DEF_CODE() });
				while (rst.next()) {
					M_DUDD_RET_PARA = rst.getString(1);
					M_DUDD_LINK_SERIAL_NO = rst.getInt(2);
				}
				if(M_DUDD_LINK_SERIAL_NO!=0){
					if(M_DUDD_LINK_SERIAL_NO==PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_SERIAL_NO()){
						PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_RET_PARA(M_DUDD_RET_PARA);
						PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_RET_PARA().setDisabled(true);
					}else{
						PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_RET_PARA().setDisabled(false);
					}
				}

				if("1".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA()) ||
						"2".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA()) ||
						"3".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA())){
					PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_STORAGE_YN("N");
					PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().setDisabled(true);
				}else if("4".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA())){
					PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_STORAGE_YN("Y");
					PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().setDisabled(true);
				}else if("5".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA())){
					PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_STORAGE_YN("Y");
					PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().setDisabled(true);
				}
				PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().resetValue();
				
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try {CommonUtils.closeCursor(rst);} catch (Exception e) {}}
    }
		
		 /**
	     * 
	     * @param PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN
	     * @param PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN
	     */
	    public void retParaWhenValidator(PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN,
	    		PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN){
	    	
	    	PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN = PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getPM_IL_DATA_UPLOAD_DEFN_DTL_BEAN();

			if("1".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA()) ||
					"2".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA()) ||
					"3".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA())){
				PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_STORAGE_YN("N");
				PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().setDisabled(true);
			}else if("4".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA())){
				PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_STORAGE_YN("Y");
				PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().setDisabled(true);
			}else if("5".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA())){
				PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.setDUDD_STORAGE_YN("Y");
				PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().setDisabled(true);
			}
			
			PM_IL_DATA_UPLOAD_DEFN_DTL_ACTION_BEAN.getCOMP_DUDD_STORAGE_YN().resetValue();
	    }
	    

	    
	    public void whenValidateDUDDLinkSerialNo(PM_IL_DATA_UPLOAD_DEFN_HDR PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN,PM_IL_DATA_UPLOAD_DEFN_DTL PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN) throws Exception{
	    	String sql_C1 = "SELECT DUDD_PARA_TYPE,DUDD_LINK_SERIAL_NO "
				+ "FROM PM_IL_DATA_UPLOAD_DEFN_DTL  "
				+ "WHERE DUDD_DUDH_DEF_CODE = ? "
				+ "AND   DUDD_LINK_SERIAL_NO = ?";
	    	
	    	String sql_C2 = "SELECT DUDD_PARA_TYPE,DUDD_SERIAL_NO "
				+ "FROM   PM_IL_DATA_UPLOAD_DEFN_DTL  "
				+ "WHERE DUDD_DUDH_DEF_CODE = ? AND   DUDD_SERIAL_NO = ?";
    	
    	String M_DUMMY = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst1 = null;
		ResultSet rst2 = null;
		String M_VAL =null;
		String M_DUDD_PARA_TYPE =null;
		int M_DUDD_LINK_SERIAL_NO=0;
		int M1_DUDD_SERIAL_NO = 0;
		String M1_DUDD_PARA_TYPE = null;
		int M_CNT = 0;
		
		try {
			con = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rst1 = handler.executeSelectStatement(sql_C1, con,
					new Object[] { PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getDUDH_DEF_CODE(),PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_LINK_SERIAL_NO() });
			while (rst1.next()) {
				M_DUDD_PARA_TYPE = rst1.getString(1);
				M_DUDD_LINK_SERIAL_NO = rst1.getInt(2);
			}
			if(M_DUDD_PARA_TYPE!=null){

				rst2 = handler.executeSelectStatement(sql_C2, con,new Object[] { PM_IL_DATA_UPLOAD_DEFN_HDR_BEAN.getDUDH_DEF_CODE(),M_DUDD_LINK_SERIAL_NO });
				while(rst2.next()){
					M1_DUDD_PARA_TYPE = rst2.getString(1);
					M1_DUDD_SERIAL_NO = rst2.getInt(2);
					if(M_DUDD_LINK_SERIAL_NO == M1_DUDD_SERIAL_NO &&
							M_DUDD_PARA_TYPE!=null && M_DUDD_PARA_TYPE.equalsIgnoreCase(M1_DUDD_PARA_TYPE)){
						M_CNT = 1;
					}
				}
			}
			if(M_CNT==1){
				throw new Exception("Duplicate Retrun Parameter Selected..");
			}
			if("5".equalsIgnoreCase(PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_RET_PARA()) &&
					PM_IL_DATA_UPLOAD_DEFN_DTL_BEAN.getDUDD_LINK_SERIAL_NO()!=0.0){
				throw new Exception("Can not Enter Link Serial No ");
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{try {CommonUtils.closeCursor(rst1);CommonUtils.closeCursor(rst2);} catch (Exception e) {}}
	    }
	    
    
}
