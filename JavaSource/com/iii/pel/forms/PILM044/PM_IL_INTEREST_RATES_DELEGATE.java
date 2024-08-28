package com.iii.pel.forms.PILM044;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PLM005.PLM005_COMPOSITE_ACTION;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_INTEREST_RATES_DELEGATE {
	public void executeSelectStatement(
			PILM044_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		//String executeQuery = "SELECT ROWID, PM_IL_INTEREST_RATES.* FROM PM_IL_INTEREST_RATES WHERE ROWID=? ";
		String executeQuery = "SELECT ROWID,IR_TOT_CONT_FROM,IR_TOT_CONT_TO,IR_TERM_FM,IR_TERM_TO,IR_TOT_CONT_RATE,IR_TOT_CONT_RATE_PER,IR_EFF_FM_DT,IR_EFF_TO_DT,"
				+ "TO_CHAR(IR_EFF_FM_DT, 'DD/MM/RRRR') EFF_FM_DT,TO_CHAR(IR_EFF_TO_DT, 'DD/MM/RRRR') EFF_TO_DT,IR_PROD_CODE,IR_CR_DT,IR_CR_UID,IR_UPD_DT,IR_UPD_UID "
				+ "FROM PM_IL_INTEREST_RATES";
		String prodDescQry = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
		ResultSet resultSet = null;
		ResultSet prodDescRS = null;

		con = CommonUtils.getConnection();
		PM_IL_INTEREST_RATES PM_IL_INTEREST_RATES_BEAN = null;
		PM_IL_INTEREST_RATES interestBean = compositeAction
				.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN().getPM_IL_INTEREST_RATES_BEAN();

		resultSet = handler.executeSelectStatement(executeQuery, con);

		while (resultSet.next()) {
			PM_IL_INTEREST_RATES_BEAN = new PM_IL_INTEREST_RATES();
			PM_IL_INTEREST_RATES_BEAN.setROWID(resultSet.getString("ROWID"));
			//PM_IL_INTEREST_RATES_BEAN.setIR_INT_TYPE(resultSet.getString("IR_INT_TYPE"));
			PM_IL_INTEREST_RATES_BEAN.setIR_PROD_CODE(resultSet.getString("IR_PROD_CODE"));
			prodDescRS = new CRUDHandler().executeSelectStatement(prodDescQry, con,new Object[]{PM_IL_INTEREST_RATES_BEAN.getIR_PROD_CODE()});
			if(prodDescRS.next()){
				PM_IL_INTEREST_RATES_BEAN.setUI_M_IR_DESC(prodDescRS.getString("PROD_DESC"));
			}
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_FROM(resultSet.getDouble("IR_TOT_CONT_FROM"));
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_TO(resultSet.getDouble("IR_TOT_CONT_TO"));
			
			//PM_IL_INTEREST_RATES_BEAN.setUI_M_IR_TOT_CONT_FROM(decimalFormatted(resultSet.getInt("IR_TOT_CONT_FROM")));
			//PM_IL_INTEREST_RATES_BEAN.setUI_M_IR_TOT_CONT_TO(decimalFormatted(resultSet.getInt("IR_TOT_CONT_FROM")));
			
			PM_IL_INTEREST_RATES_BEAN.setIR_TERM_FM(resultSet.getInt("IR_TERM_FM"));
			PM_IL_INTEREST_RATES_BEAN.setIR_TERM_TO(resultSet.getInt("IR_TERM_TO"));
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_RATE(resultSet.getDouble("IR_TOT_CONT_RATE"));
			//PM_IL_INTEREST_RATES_BEAN.setUI_M_IR_TOT_CONT_RATE(decimalFormatted(resultSet.getInt("IR_TOT_CONT_RATE")));
			PM_IL_INTEREST_RATES_BEAN.setIR_TOT_CONT_RATE_PER(resultSet.getInt("IR_TOT_CONT_RATE_PER"));
			PM_IL_INTEREST_RATES_BEAN.setIR_EFF_FM_DT(resultSet.getDate("IR_EFF_FM_DT"));
			PM_IL_INTEREST_RATES_BEAN.setIR_EFF_TO_DT(resultSet.getDate("IR_EFF_TO_DT"));
			//PM_IL_INTEREST_RATES_BEAN.setUI_M_IR_EFF_FM_DT(resultSet.getString("EFF_FM_DT"));
			//PM_IL_INTEREST_RATES_BEAN.setUI_M_IR_EFF_TO_DT(resultSet.getString("EFF_TO_DT"));
			PM_IL_INTEREST_RATES_BEAN.setIR_CR_DT(resultSet.getDate("IR_CR_DT"));
			PM_IL_INTEREST_RATES_BEAN.setIR_CR_UID(resultSet.getString("IR_CR_UID"));
			PM_IL_INTEREST_RATES_BEAN.setIR_UPD_DT(resultSet.getDate("IR_UPD_DT"));
			PM_IL_INTEREST_RATES_BEAN.setIR_UPD_UID(resultSet.getString("IR_UPD_UID"));
			
			compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN()
					.setPM_IL_INTEREST_RATES_BEAN(PM_IL_INTEREST_RATES_BEAN);
			compositeAction.getPILM044_PM_IL_INTEREST_RATES_ACTION_BEAN()
			.getDataListPM_IL_INTEREST_RATES().add(PM_IL_INTEREST_RATES_BEAN);
			
		}

	}
	
	public String decimalFormatted(int convertValue)
	{
		String basDecQry = "SELECT CURR_DECIMAL FROM PM_CURRENCY WHERE CURR_CODE = ?";
		ResultSet rs = null;
		String finalvalue = "";
		try{
			Map<String, Object> session = FacesContext.getCurrentInstance()
					.getExternalContext().getSessionMap();
			int decimal = 0;
			String curr_code = (String) session.get("GLOBAL.M_BASE_CURR");
			System.out.println("CURR_CODE ::" + curr_code);
			rs = new CRUDHandler().executeSelectStatement(basDecQry, CommonUtils.getConnection(),new Object[]{curr_code});
			if(rs.next()){
				decimal = rs.getInt("CURR_DECIMAL");
			}
			System.out.println("decimal:::::"+decimal);
			StringBuilder sb = new StringBuilder();
			sb.append(".");
			for(int i=0;i<decimal;i++)
			{
				sb.append("0");
			}
			DecimalFormat df = new DecimalFormat(sb.toString()); // Set your desired format here.
			
			finalvalue = df.format(convertValue);
			
			System.out.println("value with decimal             "+finalvalue);
		
		}catch(Exception e){
			e.printStackTrace();
		}
		return finalvalue;
	}
}
