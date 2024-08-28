package com.iii.pel.forms.PILT027;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_DEPOSIT_CHARGE_DELEGATE {

	public List<PT_IL_DEPOSIT_CHARGE> getBlockDataForDEPOSIT_CHARGE() {
		String queryString="SELECT ROWID,PT_IL_DEPOSIT_CHARGE.* " +
			"FROM PT_IL_DEPOSIT_CHARGE WHERE DCHRG_DEP_SYS_ID=?";
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		String mappedBeanName="PILT027_COMPOSITE_ACTION";
		List <PT_IL_DEPOSIT_CHARGE> dataList=new ArrayList<PT_IL_DEPOSIT_CHARGE>();
		ResultSet result=null;
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> outList = null;
		try {
			Connection connection = CommonUtils.getConnection();
			
			PILT027_COMPOSITE_ACTION compositeActionBean=
				(PILT027_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			Long id=compositeActionBean.getPT_IL_TOP_UP_ACTION_BEAN().
					getPT_IL_TOP_UP_BEAN().getTU_SYS_ID();
			Object []values={id};
			result=handler.executeSelectStatement(queryString, connection, values);
			if(result!=null){
				while(result.next()){
					PT_IL_DEPOSIT_CHARGE bean=new PT_IL_DEPOSIT_CHARGE();
					bean.setDCHRG_CODE(result.getString("DCHRG_CODE"));
					bean.setDCHRG_TYPE(result.getString("DCHRG_TYPE"));
					bean.setDCHRG_DEP_SYS_ID(result.getLong("DCHRG_DEP_SYS_ID"));
					bean.setDCHRG_RATE(result.getDouble("DCHRG_RATE"));
					bean.setDCHRG_FLEX_01(result.getString("DCHRG_FLEX_01"));
					bean.setDCHRG_FLEX_02(result.getString("DCHRG_FLEX_02"));
					bean.setDCHRG_FC_AMT(result.getDouble("DCHRG_FC_AMT"));
					bean.setDCHRG_LC_AMT(result.getDouble("DCHRG_LC_AMT"));
					bean.setDCHRG_RATE_PER(result.getDouble("DCHRG_RATE_PER"));
					bean.setROWID(result.getString("ROWID"));
					
					outList = procedures.helperP_VAL_CODES("IL_CHARGE", 
							bean.getDCHRG_CODE(), "L", "E", null);
					 calcLcAmt(compositeActionBean.getPT_IL_TOP_UP_ACTION_BEAN(), bean);
					System.out.println("outList.get(0)........."+outList.get(0)); 
					bean.setUI_M_CHARGE_DESC(outList.get(0));
					dataList.add(bean);
				}
			}
			PT_IL_DEPOSIT_CHARGE PT_IL_DEPOSIT_CHARGE = null;
			Iterator<PT_IL_DEPOSIT_CHARGE> it = dataList.iterator();
			while(it.hasNext()){
				PT_IL_DEPOSIT_CHARGE = it.next();
				PT_IL_DEPOSIT_CHARGE.setRowSelected(false);
 			}
			
			if (dataList.size()>0){					
				compositeActionBean.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().setPT_IL_DEPOSIT_CHARGE_BEAN(dataList.get(0));
				compositeActionBean.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setRowSelected(true);
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dataList;
	}

	public void preInsert() { 
		String mappedBeanName="PILT027_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();

		try {
			PILT027_COMPOSITE_ACTION compositeActionBean=
				(PILT027_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
			Long id=compositeActionBean.getPT_IL_TOP_UP_ACTION_BEAN().
			getPT_IL_TOP_UP_BEAN().getTU_SYS_ID();	
			compositeActionBean.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setDCHRG_DEP_SYS_ID(id);
			compositeActionBean.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setDCHRG_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			compositeActionBean.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setDCHRG_CR_DT(new CommonUtils().getCurrentDate());
			
		} catch (Exception e) {
		}
	}
	
	public void preUpdate(){
		try{
		String mappedBeanName="PILT027_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT027_COMPOSITE_ACTION compositeActionBean=
			(PILT027_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		compositeActionBean.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setDCHRG_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		compositeActionBean.getPT_IL_DEPOSIT_CHARGE_ACTION_BEAN().getPT_IL_DEPOSIT_CHARGE_BEAN().setDCHRG_CR_DT(new CommonUtils().getCurrentDate());
		}catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	
	public void IL_UNIQUE_CHRG_CODE(
			PT_IL_DEPOSIT_CHARGE PT_IL_DEPOSIT_CHARGE_BEAN,String currValue) throws Exception {

		String M_DCHRG_CODE = null;
		String C1 = "SELECT 'X' FROM PT_IL_DEPOSIT_CHARGE WHERE DCHRG_CODE = ? "
				+ "AND DCHRG_DEP_SYS_ID = ?";
		String C2 = "SELECT 'X' FROM PT_IL_DEPOSIT_CHARGE WHERE DCHRG_CODE = ? "
				+ "AND DCHRG_DEP_SYS_ID = ? AND ROWID <> ?";
		Connection connection = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		CRUDHandler handler = null;

		try {
			connection = CommonUtils.getConnection();
		
		handler = new CRUDHandler();

		if (PT_IL_DEPOSIT_CHARGE_BEAN.getROWID() == null) {
			resultSetC1 = handler.executeSelectStatement(C1, connection,
					new Object[] { currValue, PT_IL_DEPOSIT_CHARGE_BEAN.getDCHRG_DEP_SYS_ID() });
			if (resultSetC1.next()) {
				M_DCHRG_CODE = resultSetC1.getString(1);
			}
			if (M_DCHRG_CODE != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90015",
						new Object[] { "Charge Code is " }));
			}
		} else {
			resultSetC2 = handler.executeSelectStatement(C2, connection,
					new Object[] { currValue, 
							PT_IL_DEPOSIT_CHARGE_BEAN.getDCHRG_DEP_SYS_ID(),
							PT_IL_DEPOSIT_CHARGE_BEAN.getROWID() });
			if (resultSetC2.next()) {
				M_DCHRG_CODE = resultSetC2.getString(1);
			}
			if (M_DCHRG_CODE != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "90015",
						new Object[] { "Charge Code is " }));
			}
		}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	public void validateDCHRG_RATE(PT_IL_DEPOSIT_CHARGE PT_IL_DEPOSIT_CHARGE_BEAN,PT_IL_TOP_UP PT_IL_TOP_UP_BEAN) {
		try {
			if( PT_IL_DEPOSIT_CHARGE_BEAN.getDCHRG_RATE() !=null){
				PT_IL_DEPOSIT_CHARGE_BEAN.setDCHRG_FC_AMT(CommonUtils.nvl(PT_IL_DEPOSIT_CHARGE_BEAN.getDCHRG_RATE() ,0));
				PT_IL_DEPOSIT_CHARGE_BEAN.setUI_M_DCHRG_TOTAL_FC_AMT(CommonUtils.nvl(PT_IL_DEPOSIT_CHARGE_BEAN.getUI_M_DCHRG_TOTAL_LC_AMT() ,0));
		//	 P_VAL_ROUND_AMT(  PT_IL_TOP_UP_BEAN.getUI_M_POL_SA_CURR_CODE(),  :PT_IL_DEPOSIT_CHARGE.M_DCHRG_TOTAL_FC_AMT,'V');
			PT_IL_DEPOSIT_CHARGE_BEAN.setDCHRG_LC_AMT( CommonUtils.nvl(PT_IL_DEPOSIT_CHARGE_BEAN.getDCHRG_FC_AMT(),0)   * 
					CommonUtils.nvl(PT_IL_TOP_UP_BEAN.getUI_M_POL_SA_EXCH_RATE(),0));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
	}
	public void calcLcAmt(PT_IL_TOP_UP_ACTION pt_il_top_up_action,PT_IL_DEPOSIT_CHARGE chargeBean){
		Double lcamt = pt_il_top_up_action
							.getPT_IL_TOP_UP_BEAN().getTU_LC_TOPUP_DEP_AMT();
		Double rate = chargeBean.getDCHRG_RATE();
		Double ratePer = chargeBean.getDCHRG_RATE_PER();
		Double calcAmt = null;
		if("4".equals(chargeBean.getDCHRG_FLEX_01())){
		if(rate != null && ratePer != null && lcamt != null){
			calcAmt = (lcamt*rate)/ratePer;
			chargeBean.setUI_M_DCHRG_TOTAL_LC_AMT(calcAmt);
		}
		}
		else{
			if(rate != null){
				chargeBean.setUI_M_DCHRG_TOTAL_LC_AMT(rate);
			}
		}
	}
	
}
