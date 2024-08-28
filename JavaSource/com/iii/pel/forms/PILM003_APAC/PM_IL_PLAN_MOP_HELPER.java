package com.iii.pel.forms.PILM003_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;


public class PM_IL_PLAN_MOP_HELPER {


	public void executeQuery(PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_IL_PLAN_MOP_DELEGATE().executeSelectStatement(compositeAction);

 	 List<PM_IL_PLAN_MOP> dataList = compositeAction.
	getPM_IL_PLAN_MOP_ACTION_BEAN().getDataList_PM_IL_PLAN_MOP();
	 if(dataList!=null && dataList.size() > 0){
		PM_IL_PLAN_MOP PM_IL_PLAN_MOP_BEAN = dataList.get(0);
		PM_IL_PLAN_MOP_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PLAN_MOP_ACTION_BEAN()
		.setPM_IL_PLAN_MOP_BEAN(PM_IL_PLAN_MOP_BEAN);
	}
	}
	

	public void whenCreateRecord(PM_IL_PLAN_MOP PM_IL_PLAN_MOP_BEAN) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		Double M_TEMP = 0.0;
		String C1 = " SELECT PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_PRM_PM' AND    PS_CODE = 'Y' ";
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(C1, connection);
			if(resultSet.next()){
				M_TEMP = resultSet.getDouble(1);
				PM_IL_PLAN_MOP_BEAN.setPMOP_RATE(M_TEMP);
			}
			PM_IL_PLAN_MOP_BEAN.setPMOP_TYPE("Y");
			PM_IL_PLAN_MOP_BEAN.setPMOP_TOLL_TYP("F");
			PM_IL_PLAN_MOP_BEAN.setPMOP_EX_TOLL_TYP("F");
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void L_CHECK_DUP_VALUE(PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		PM_IL_PLAN planBean = null;
		PM_IL_PLAN_MOP mopBean = null;
		String M_TEMP = null;
		String C1 = " SELECT 'X' FROM   PM_IL_PLAN_MOP  WHERE  PMOP_PLAN_CODE  = ? " +
				"  AND    PMOP_TYPE   = ? AND PMOP_TOLL_TYP = ? AND PMOP_EX_TOLL_TYP = ? AND   ((NVL(PMOP_EFF_FM_DT,'01-JAN-1900')" +
				" BETWEEN NVL(? ,'01-JAN-1900') AND " +
				" NVL(? ,'31-DEC-2999')) OR   (NVL(PMOP_EFF_TO_DT,'31-DEC-2999') " +
				" BETWEEN NVL(?,'01-JAN-1900') " +
				"  AND NVL( ? ,'31-DEC-2999'))     OR  " +
				"  (NVL( ? ,'01-JAN-1900') BETWEEN NVL(PMOP_EFF_FM_DT,'01-JAN-1900') " +
				"  AND NVL(PMOP_EFF_TO_DT,'31-DEC-2999'))    OR   " +
				" (NVL( ? ,'31-DEC-2999') BETWEEN NVL(PMOP_EFF_FM_DT,'01-JAN-1900') " +
				" AND NVL(PMOP_EFF_TO_DT,'31-DEC-2999')))";
		planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
		mopBean = compositeAction.getPM_IL_PLAN_MOP_ACTION_BEAN().getPM_IL_PLAN_MOP_BEAN();
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{planBean.getPLAN_CODE(),
										mopBean.getPMOP_TYPE(),mopBean.getPMOP_TOLL_TYP(),mopBean.getPMOP_EX_TOLL_TYP(),mopBean.getPMOP_EFF_FM_DT(),
										mopBean.getPMOP_EFF_TO_DT(),mopBean.getPMOP_EFF_FM_DT(),
										mopBean.getPMOP_EFF_TO_DT(),mopBean.getPMOP_EFF_FM_DT(),
										mopBean.getPMOP_EFF_TO_DT()});
			if(resultSet.next()){
				M_TEMP = resultSet.getString(1);
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91011"));
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
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void preInsert(PM_IL_PLAN_MOP mopBean, PILM003_APAC_COMPOSITE_ACTION compositeAction ) throws Exception{
		try {
			L_CHECK_DUP_VALUE(compositeAction);
			mopBean.setPMOP_PLAN_CODE(compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN().getPLAN_CODE());
			mopBean.setPMOP_CR_DT(new CommonUtils().getCurrentDate());
			mopBean.setPMOP_CR_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void preUpdate(PILM003_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		PM_IL_PLAN planBean = null;
		PM_IL_PLAN_MOP mopBean = null;
		String M_TEMP = null;
		String C1 = " SELECT 'X' FROM   PM_IL_PLAN_MOP WHERE  PMOP_PLAN_CODE = ? " +
				" AND PMOP_TYPE  = ?  AND PMOP_TOLL_TYP = ? AND PMOP_EX_TOLL_TYP = ? AND  ((NVL(PMOP_EFF_FM_DT,'01-JAN-1900')" +
				" BETWEEN NVL( ? ,'01-JAN-1900') AND " +
				" NVL( ?,'31-DEC-2999'))    OR  (NVL(PMOP_EFF_TO_DT,'31-DEC-2999') " +
				" BETWEEN NVL( ? ,'01-JAN-1900') AND " +
				" NVL(? ,'31-DEC-2999'))  OR " +
				" (NVL(? ,'01-JAN-1900') BETWEEN NVL(PMOP_EFF_FM_DT,'01-JAN-1900')" +
				"  AND NVL(PMOP_EFF_TO_DT,'31-DEC-2999')) OR (NVL(?,'31-DEC-2999')" +
				"  BETWEEN NVL(PMOP_EFF_FM_DT,'01-JAN-1900') AND NVL(PMOP_EFF_TO_DT,'31-DEC-2999')))" +
				"   AND    ROWID != ? ";
		try {
			handler = new CRUDHandler();
			planBean = compositeAction.getPM_IL_PLAN_ACTION_BEAN().getPM_IL_PLAN_BEAN();
			mopBean = compositeAction.getPM_IL_PLAN_MOP_ACTION_BEAN().getPM_IL_PLAN_MOP_BEAN();
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{planBean.getPLAN_CODE(),
								mopBean.getPMOP_TYPE(), mopBean.getPMOP_TOLL_TYP(),mopBean.getPMOP_EX_TOLL_TYP(),mopBean.getPMOP_EFF_FM_DT(),
								mopBean.getPMOP_EFF_TO_DT(),mopBean.getPMOP_EFF_FM_DT(),
								mopBean.getPMOP_EFF_TO_DT(),mopBean.getPMOP_EFF_FM_DT(),
								mopBean.getPMOP_EFF_TO_DT() ,mopBean.getROWID()});
			if(resultSet.next()){
				M_TEMP = resultSet.getString(1);
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91011"));
			}
			mopBean.setPMOP_UPD_DT(new CommonUtils().getCurrentDate());
			mopBean.setPMOP_UPD_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
			
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
	}
	
	public void whenValidate_PMOP_TYPE(PM_IL_PLAN_MOP mopBean,String PMOP_TYPE) throws Exception{
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		Double M_TEMP = 0.0;
		String C1 = "SELECT PS_VALUE FROM PP_SYSTEM WHERE  PS_TYPE = 'IL_PRM_PM' AND PS_CODE = ? ";
		try {
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{PMOP_TYPE});
			if(resultSet.next()){
				if(mopBean.getPMOP_RATE() == null){
				M_TEMP = resultSet.getDouble(1);
				mopBean.setPMOP_RATE(M_TEMP);
				}
			}else{
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91021"));
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
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void whenValidate_PMOP_RATE(Double PMOP_RATE) throws Exception{
		try{
		if(PMOP_RATE != null){
			if(PMOP_RATE < 0 ){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91018"));
			}
		}else{
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",new Object[]{"Mode Of Payment Rate','entered"}));
		}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_PMOP_RATE_PER(Double PMOP_RATE_PER) throws Exception{
		try{
			if(CommonUtils.nvl(PMOP_RATE_PER, 0) <= 0){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91026"));
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_PMOP_EFF_FM_DT(PM_IL_PLAN_MOP mopBean , Date PMOP_EFF_FM_DT ) throws Exception{
		try{
			if(mopBean.getPMOP_EFF_TO_DT() != null){
			if(PMOP_EFF_FM_DT != null && PMOP_EFF_FM_DT.after( mopBean.getPMOP_EFF_TO_DT())){
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91010"));
			}
		}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	public void whenValidate_PMOP_EFF_TO_DT(PM_IL_PLAN_MOP mopBean , Date PMOP_EFF_TO_DT) throws Exception{
		try{
			if(mopBean.getPMOP_EFF_FM_DT() != null){
			if(PMOP_EFF_TO_DT != null && PMOP_EFF_TO_DT.before(mopBean.getPMOP_EFF_FM_DT())){
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91010"));
			}
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

}
