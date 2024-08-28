package com.iii.pel.forms.PQ124_A;

import java.sql.Connection;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_WAKALAH_DAILY_DRIP_1_DELEGATE {
	/**
	 * 
	 */
	private static final Log log = LogFactory.getLog(PT_WAKALAH_DAILY_DRIP_1_DELEGATE.class);
	/**
	 * 
	 * @param PQ124_A_COMPOSITE_ACTION_BEAN
	 * @throws Exception
	 */
	public void executeSelectStatement(
			PQ124_A_COMPOSITE_ACTION compositeAction)
	throws Exception {

		//StringBuffer stringBuffer = new StringBuffer("SELECT ROWID,PT_IL_POLICY.* FROM PT_IL_POLICY ");
		String qurery = "SELECT PT_IL_POLICY.* FROM PT_IL_POLICY WHERE ROWID = ?";

		Connection connection = null;
		ResultSet resultSet = null;
		Object[] object = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(qurery,
					connection, new Object[] { compositeAction
							.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN()
							.getPT_WAKALAH_DAILY_DRIP_1_BEAN().getROWID() });
			PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN = new PT_WAKALAH_DAILY_DRIP_1();
			while (resultSet.next()) {
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_NO(resultSet.getString("POL_NO"));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_END_NO(resultSet.getString("POL_END_NO"));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_CUST_CODE(resultSet.getString("POL_CUST_CODE"));
				//	PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_WAK_DA_MODULE(resultSet.getString("WAK_DA_MODULE"));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_PROD_CODE(resultSet.getString("POL_PROD_CODE"));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_DIVN_CODE(resultSet.getString("POL_DIVN_CODE"));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_DEPT_CODE(resultSet.getString("POL_DEPT_CODE"));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_CLASS_CODE(resultSet.getString("POL_CLASS_CODE"));
				//PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_WAK_DA_POL_ANALYSIS_1(resultSet.getString("WAK_DA_POL_ANALYSIS_1"));
				PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_SRC_OF_BUS(resultSet.getString("POL_SRC_OF_BUS"));
			}
			compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN()
					.setPT_WAKALAH_DAILY_DRIP_1_BEAN(PT_WAKALAH_DAILY_DRIP_1_BEAN);

		} finally {
			try{
				CommonUtils.closeCursor(resultSet);
			}catch(Exception exception){}
		}

		/*
		StringBuffer stringBuffer = new StringBuffer("SELECT ROWID,PT_WAKALAH_DAILY_DRIP.* FROM PT_WAKALAH_DAILY_DRIP WHERE ");

		String withoutPolicyNo = "WAK_DA_POL_NO IN (SELECT POL_NO FROM "
				+ "PT_POLICY POL, PT_WAKALAH_DAILY_DRIP WAK WHERE  "
				+ "POL.POL_CUST_CODE = ? AND  POL.POL_NO = WAK.WAK_DA_POL_NO )";

		String withPolicyNo = "WAK_DA_POL_NO IN (SELECT POL_NO FROM "
				+ "PT_POLICY POL, PT_WAKALAH_DAILY_DRIP WAK " +
				"WHERE  "+
				"POL.POL_CUST_CODE = ? " +
				"AND  POL.POL_NO = WAK.WAK_DA_POL_NO " +
				"AND POL.POL_NO = ? )";

		boolean valid = false;
		Connection connection = null;
		ResultSet resultSet = null;
		Object[] object = null;//new Object[]{};

		PT_WAKALAH_DAILY_DRIP_1 PT_WAKALAH_DAILY_DRIP_1_BEAN = compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_1_BEAN();

		log.info("=======>POLICY NUMBER========>"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO());
		log.info("=======>CUST CODE========>"+PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE());

		if((PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE()!=null && !"".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE())) 
				&& (PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()==null || "".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()))){
			stringBuffer.append(withoutPolicyNo);
			object = new Object[]{PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE()};
			valid = true;
		}else if(PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()!=null && !"".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO())
				&& PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE()!=null && !"".equalsIgnoreCase(PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE())){
			stringBuffer.append(withPolicyNo);
			object = new Object[]{PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_CUST_CODE(),
									PT_WAKALAH_DAILY_DRIP_1_BEAN.getPOL_NO()};
			valid = true;
		}else{
			PT_WAKALAH_DAILY_DRIP_1_BEAN = new PT_WAKALAH_DAILY_DRIP_1();
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getDataList_PT_WAKALAH_DAILY_DRIP().clear();
			compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().getDataList_PS_IL_CONT_PAID_INVEST().clear();
			compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().setPS_IL_CONT_PAID_INVEST_BEAN(new PS_IL_CONT_PAID_INVEST());
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().setPT_WAKALAH_DAILY_DRIP_BEAN(new PT_WAKALAH_DAILY_DRIP());
			compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().setPT_WAKALAH_DAILY_DRIP_1_BEAN(new PT_WAKALAH_DAILY_DRIP_1());
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().resetAllComponent();
			compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().resetAllComponent();
			compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().resetAllComponent();
		}
		log.info("==QUery======>"+stringBuffer.toString());
		try {
			if(valid){
				connection = CommonUtils.getConnection();
				resultSet = new CRUDHandler().executeSelectStatement(stringBuffer.toString(), connection,object);
				while (resultSet.next()) {
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setROWID(resultSet.getString("ROWID"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_NO(resultSet.getString("WAK_DA_POL_NO"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_END_NO(resultSet.getString("WAK_DA_POL_END_NO_IDX"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_WAK_DA_MODULE(resultSet.getString("WAK_DA_MODULE"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_PROD_CODE(resultSet.getString("WAK_DA_POL_PDS_CODE"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_DIVN_CODE(resultSet.getString("WAK_DA_POL_DIVN_CODE"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_DEPT_CODE(resultSet.getString("WAK_DA_POL_DEPT_CODE"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_CLASS_CODE(resultSet.getString("WAK_DA_POL_CLASS_CODE"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setUI_M_WAK_DA_POL_ANALYSIS_1(resultSet.getString("WAK_DA_POL_ANALYSIS_1"));
					PT_WAKALAH_DAILY_DRIP_1_BEAN.setPOL_SRC_OF_BUS(resultSet.getString("WAK_DA_POL_SRS_BUS_CODE"));
				}
			}

		} finally {
			CommonUtils.closeCursor(resultSet);
		}
		 */}

}
