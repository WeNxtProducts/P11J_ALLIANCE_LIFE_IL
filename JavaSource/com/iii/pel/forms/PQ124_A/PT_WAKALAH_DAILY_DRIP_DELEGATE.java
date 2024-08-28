package com.iii.pel.forms.PQ124_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_WAKALAH_DAILY_DRIP_DELEGATE {

	private static final Log log = LogFactory.getLog(PT_WAKALAH_DAILY_DRIP_DELEGATE.class);
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	/*public void executeSelectStatement(
			PQ124_A_COMPOSITE_ACTION compositeAction)
	throws Exception {

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
		Object[] object = null;
		List<PT_WAKALAH_DAILY_DRIP> list = new ArrayList<PT_WAKALAH_DAILY_DRIP>();

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
			//PT_WAKALAH_DAILY_DRIP_1_BEAN = new PT_WAKALAH_DAILY_DRIP_1();
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getDataList_PT_WAKALAH_DAILY_DRIP().clear();
			compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().getDataList_PS_IL_CONT_PAID_INVEST().clear();
			compositeAction.getPS_IL_CONT_PAID_INVEST_ACTION_BEAN().setPS_IL_CONT_PAID_INVEST_BEAN(new PS_IL_CONT_PAID_INVEST());
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().setPT_WAKALAH_DAILY_DRIP_BEAN(new PT_WAKALAH_DAILY_DRIP());
			//	compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().setPT_WAKALAH_DAILY_DRIP_1_BEAN(new PT_WAKALAH_DAILY_DRIP_1());
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
					PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN = new PT_WAKALAH_DAILY_DRIP();
					PT_WAKALAH_DAILY_DRIP_BEAN.setROWID(resultSet
							.getString("ROWID"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_SYS_ID(resultSet.getLong("WAK_DA_POL_SYS_ID"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_COVER_CODE(resultSet.getString("WAK_DA_POL_COVER_CODE"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_END_NO_IDX(resultSet.getDouble("WAK_DA_POL_END_NO_IDX"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_NO(resultSet.getString("WAK_DA_POL_NO"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_SPECIAL_FUND(resultSet.getDouble("WAK_DA_SPECIAL_FUND"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_RISK_FUND(resultSet.getDouble("WAK_DA_RISK_FUND"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_NET_PREMIUM(resultSet.getDouble("WAK_DA_POL_NET_PREMIUM"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LOAD_AMT(resultSet.getDouble("WAK_DA_LOAD_AMT"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_TOT_COMM(resultSet.getDouble("WAK_DA_POL_TOT_COMM"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_COMMISSION(resultSet.getDouble("WAK_DA_COMMISSION"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_EXPENSE(resultSet.getDouble("WAK_DA_EXPENSE"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_APPRV_DT(resultSet.getDate("WAK_DA_PC_APPRV_DT"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_SCHD_PYMT_DT(resultSet.getDate("WAK_DA_PC_SCHD_PYMT_DT"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LC_RISK(resultSet.getDouble("WAK_DA_LC_RISK"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DUE_DATE(resultSet.getDate("WAK_DA_DUE_DATE"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DUE_SCHD_PYMT_DT(resultSet.getDate("WAK_DA_DUE_SCHD_PYMT_DT"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DRIP_DT(resultSet.getDate("WAK_DA_DRIP_DT"));
					PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LC_SUM_RISK(resultSet.getDouble("WAK_DA_LC_SUM_RISK"));
					list.add(PT_WAKALAH_DAILY_DRIP_BEAN);
				}
				compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().setDataListPT_WAKALAH_DAILY_DRIP(list);
			}

		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}*/

	/*String selectStatement = "SELECT ROWID,PT_LIFE_WAKALAH_DAILY_DRIP.* FROM PT_LIFE_WAKALAH_DAILY_DRIP " +
				"WHERE WAK_DA_POL_NO = ? ";
		Connection connection = null;
		ResultSet resultSet = null;

		List<PT_WAKALAH_DAILY_DRIP> list = new ArrayList<PT_WAKALAH_DAILY_DRIP>();

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{compositeAction.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN().getPT_WAKALAH_DAILY_DRIP_1_BEAN().getPOL_NO()});
			while (resultSet.next()) {
				PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN = new PT_WAKALAH_DAILY_DRIP();
				PT_WAKALAH_DAILY_DRIP_BEAN.setROWID(resultSet
						.getString("ROWID"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_SYS_ID(resultSet.getLong("WAK_DA_POL_SYS_ID"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_COVER_CODE(resultSet.getString("WAK_DA_POL_COVER_CODE"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_END_NO_IDX(resultSet.getDouble("WAK_DA_POL_END_NO_IDX"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_NO(resultSet.getString("WAK_DA_POL_NO"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_SPECIAL_FUND(resultSet.getDouble("WAK_DA_SPECIAL_FUND"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_RISK_FUND(resultSet.getDouble("WAK_DA_RISK_FUND"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_NET_PREMIUM(resultSet.getDouble("WAK_DA_POL_NET_PREMIUM"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LOAD_AMT(resultSet.getDouble("WAK_DA_LOAD_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_TOT_COMM(resultSet.getDouble("WAK_DA_POL_TOT_COMM"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_COMMISSION(resultSet.getDouble("WAK_DA_COMMISSION"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_EXPENSE(resultSet.getDouble("WAK_DA_EXPENSE"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_APPRV_DT(resultSet.getDate("WAK_DA_PC_APPRV_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_SCHD_PYMT_DT(resultSet.getDate("WAK_DA_PC_SCHD_PYMT_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LC_RISK(resultSet.getDouble("WAK_DA_LC_RISK"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DUE_DATE(resultSet.getDate("WAK_DA_DUE_DATE"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DUE_SCHD_PYMT_DT(resultSet.getDate("WAK_DA_DUE_SCHD_PYMT_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DRIP_DT(resultSet.getDate("WAK_DA_DRIP_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LC_SUM_RISK(resultSet.getDouble("WAK_DA_LC_SUM_RISK"));

				list.add(PT_WAKALAH_DAILY_DRIP_BEAN);
			}
			compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().setDataListPT_WAKALAH_DAILY_DRIP(list);
		} finally {
			CommonUtils.closeCursor(resultSet);
		}*/

	public void executeSelectStatement (PQ124_A_COMPOSITE_ACTION compositeAction) throws Exception { 
		String selectStatement="SELECT ROWID, PT_LIFE_WAKALAH_DAILY_DRIP.* FROM PT_LIFE_WAKALAH_DAILY_DRIP WHERE " +
				"PT_LIFE_WAKALAH_DAILY_DRIP.WAK_DA_POL_NO = ? ";
		Connection connection=null;
		ResultSet resultSet=null;
		PT_WAKALAH_DAILY_DRIP PT_WAKALAH_DAILY_DRIP_BEAN = null;
		compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getDataList_PT_WAKALAH_DAILY_DRIP().clear();
		try {
			connection=CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection, new Object[] { compositeAction
							.getPT_WAKALAH_DAILY_DRIP_1_ACTION_BEAN()
							.getPT_WAKALAH_DAILY_DRIP_1_BEAN().getPOL_NO() });
			while (resultSet.next()) {
				PT_WAKALAH_DAILY_DRIP_BEAN = new PT_WAKALAH_DAILY_DRIP();
				PT_WAKALAH_DAILY_DRIP_BEAN.setROWID(resultSet.getString("ROWID"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_SYS_ID(resultSet.getLong("WAK_DA_POL_SYS_ID"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_COVER_CODE(resultSet.getString("WAK_DA_POL_COVER_CODE"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_END_NO_IDX(resultSet.getDouble("WAK_DA_POL_END_NO_IDX"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_NO(resultSet.getString("WAK_DA_POL_NO"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_SPECIAL_FUND(resultSet.getDouble("WAK_DA_SPECIAL_FUND"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_RISK_FUND(resultSet.getDouble("WAK_DA_RISK_FUND"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_NET_PREMIUM(resultSet.getDouble("WAK_DA_POL_NET_PREMIUM"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LOAD_AMT(resultSet.getDouble("WAK_DA_LOAD_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_POL_TOT_COMM(resultSet.getDouble("WAK_DA_POL_TOT_COMM"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_COMMISSION(resultSet.getDouble("WAK_DA_COMMISSION"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_EXPENSE(resultSet.getDouble("WAK_DA_EXPENSE"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_APPRV_DT(resultSet.getDate("WAK_DA_PC_APPRV_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PC_SCHD_PYMT_DT(resultSet.getDate("WAK_DA_PC_SCHD_PYMT_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LC_RISK(resultSet.getDouble("WAK_DA_LC_RISK"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DUE_DATE(resultSet.getDate("WAK_DA_DUE_DATE"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DUE_SCHD_PYMT_DT(resultSet.getDate("WAK_DA_DUE_SCHD_PYMT_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DRIP_DT(resultSet.getDate("WAK_DA_DRIP_DT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_LC_SUM_RISK(resultSet.getDouble("WAK_DA_LC_SUM_RISK"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_DATE(resultSet.getInt("WAK_DA_DATE"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_MON(resultSet.getInt("WAK_DA_MON"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_YEAR(resultSet.getInt("WAK_DA_YEAR"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PRIA_BAL_AFTER_TAP(resultSet.getDouble("WAK_DA_PRIA_BAL_AFTER_TAP"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_RISK_FC_AMT(resultSet.getDouble("WAK_DA_RISK_FC_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_RISK_LC_AMT(resultSet.getDouble("WAK_DA_RISK_LC_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_CHARGE_FC_AMT(resultSet.getDouble("WAK_DA_CHARGE_FC_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_CHARGE_LC_AMT(resultSet.getDouble("WAK_DA_CHARGE_LC_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PREM_CONTRI_FC_AMT(resultSet.getDouble("WAK_DA_PREM_CONTRI_FC_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAK_DA_PREM_CONTRI_LC_AMT(resultSet.getDouble("WAK_DA_PREM_CONTRI_LC_AMT"));
				PT_WAKALAH_DAILY_DRIP_BEAN.setWAKALAH_DATE(
						
						String.valueOf(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_DATE())+"/"+
						String.valueOf(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_MON())+"/"+
						String.valueOf(PT_WAKALAH_DAILY_DRIP_BEAN.getWAK_DA_YEAR())
						);
				compositeAction.getPT_WAKALAH_DAILY_DRIP_ACTION_BEAN().getDataList_PT_WAKALAH_DAILY_DRIP().add(PT_WAKALAH_DAILY_DRIP_BEAN);
			}
		} 
		finally { 
			CommonUtils.closeCursor(resultSet);
		} 
	} 
	
	private Date getDate(String str_date) {
		Date date = null;
		try {
			DateFormat formatter;
			formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = (Date) formatter.parse(str_date);
			System.out.println("Today is " + date);
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}
		return date;

	}


}
