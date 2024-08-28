package com.iii.pel.forms.PILT003_APAC;

import java.util.ArrayList;
import java.util.Iterator;

import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILT003_PROCEDURES {

	private String P_VAL_ROUND_AMT(String var1, String var2, String var3)
			throws Exception {
		String output = null;
		ArrayList<OracleParameter> paramList = new ArrayList<OracleParameter>();
		ArrayList<OracleParameter> resultList = new ArrayList<OracleParameter>();

		OracleParameter p14 = new OracleParameter("IN1", "STRING", "IN", var1);
		paramList.add(p14);
		OracleParameter p24 = new OracleParameter("IN2", "STRING", "IN OUT",
				var2);
		paramList.add(p24);
		OracleParameter p34 = new OracleParameter("IN3", "STRING", "IN", var3);
		paramList.add(p34);

		OracleProcedureHandler procedureHandler = new OracleProcedureHandler();
		resultList = procedureHandler.execute(paramList, CommonUtils
				.getConnection(), "P_VAL_ROUND_AMT");

		for (Iterator iterator11 = resultList.iterator(); iterator11.hasNext();) {
			OracleParameter name = (OracleParameter) iterator11.next();
			if (name.getFieldName().equals("IN2")) {
				output = name.getValue();
			}
		}
		return output;
	}
	
	public void calL_CALC_UNPAID_PREM_INT(PT_IL_PREM_COLL valueBean,
			PT_IL_POLICY pt_il_policy) {
		OracleParameter param1 = new OracleParameter("in1", "STRING", "IN",
				String.valueOf(valueBean.getPC_POL_SYS_ID()));
		OracleParameter param2 = new OracleParameter("in2", "STRING", "IN",
				String.valueOf(valueBean.getPC_SYS_ID()));
		OracleParameter param3 = new OracleParameter("in3", "STRING", "IN",
				CommonUtils.dateToStringFormatter(valueBean.getPC_PAID_DT()));
		OracleParameter param4 = new OracleParameter("in4", "STRING", "IN",
				String.valueOf(valueBean.getPC_LC_GROSS_PREM()));
		OracleParameter param5 = new OracleParameter("in5", "STRING", "IN",
				String.valueOf(valueBean.getPC_LC_CHARGE()));
		OracleParameter param6 = new OracleParameter("in6", "STRING", "IN",
				String.valueOf(valueBean.getPC_LC_DISCOUNT()));
		OracleParameter param7 = new OracleParameter("in7", "STRING", "IN",
				String.valueOf(valueBean.getPC_FC_GROSS_PREM()));
		OracleParameter param8 = new OracleParameter("in8", "STRING", "IN",
				String.valueOf(valueBean.getPC_FC_CHARGE()));
		OracleParameter param9 = new OracleParameter("in9", "STRING", "IN",
				String.valueOf(valueBean.getPC_FC_DISCOUNT()));
		OracleParameter param10 = new OracleParameter("in10", "STRING", "IN",
				CommonUtils.dateToStringFormatter(valueBean
						.getPC_SCHD_PYMT_DT()));
		OracleParameter param11 = new OracleParameter("in11", "STRING", "IN",
				valueBean.getUI_M_BASE_CURR_CODE());
		OracleParameter param12 = new OracleParameter("out1", "STRING", "OUT",
				"");
		OracleParameter param13 = new OracleParameter("out2", "STRING", "OUT",
				"");
		OracleParameter param14 = new OracleParameter("out3", "STRING", "OUT",
				"");
		OracleParameter param15 = new OracleParameter("out4", "STRING", "OUT",
				"");
		ArrayList<OracleParameter> unPaidPremList = new ArrayList<OracleParameter>();
		unPaidPremList.add(param1);
		unPaidPremList.add(param2);
		unPaidPremList.add(param3);
		unPaidPremList.add(param4);
		unPaidPremList.add(param5);
		unPaidPremList.add(param6);
		unPaidPremList.add(param7);
		unPaidPremList.add(param8);
		unPaidPremList.add(param9);
		unPaidPremList.add(param10);
		unPaidPremList.add(param11);
		unPaidPremList.add(param12);
		unPaidPremList.add(param13);
		unPaidPremList.add(param14);
		unPaidPremList.add(param15);
		try {
			new OracleProcedureHandler().execute(unPaidPremList, CommonUtils
					.getConnection(),
					"P9ILPK_PILT003_APAC.L_CALC_UNPAID_PREM_INT");
		} catch (DBException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
