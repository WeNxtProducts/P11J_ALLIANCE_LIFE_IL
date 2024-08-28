package com.iii.pel.forms.PILP207;

import java.io.BufferedWriter;

import com.iii.premia.common.constants.PELConstants;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ValidationException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PW_IL_BENIFIT_PAYMT_DELEGATE {

	public void executeSelectStatement(
			PILP207_COMPOSITE_ACTION compositeAction) throws Exception {
		List<String> data = new ArrayList<String>();

		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet rs = null;
		String path=null;
		String Query = "SELECT * FROM  PW_IL_BENIFIT_PAYMT where trunc(PIBP_PAYMENT_DT) between  to_date(?,'dd/mm/yyyy')  and  to_date(?,'dd/mm/yyyy')  AND PIBP_FILE_NAME IS NULL";
		//String Query1="select ps_code_desc from pp_system where ps_type like 'SMART_FILE'";
		compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getDataList_PW_IL_BENIFIT_PAYMT().clear();

		try {
			String FileName=null;
			connection = CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(
					Query, connection, new Object[] {CommonUtils.dateToStringFormatter(compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getPW_IL_BENIFIT_PAYMT_BEAN().getUI_M_PIBP_PAYMENT_FM_DT()) ,
							CommonUtils.dateToStringFormatter(compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getPW_IL_BENIFIT_PAYMT_BEAN().getUI_M_PIBP_PAYMENT_TO_DT()) });


			while (resultSet.next()) {
				PW_IL_BENIFIT_PAYMT PW_IL_BENIFIT_PAYMT_BEAN=new PW_IL_BENIFIT_PAYMT();

				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_CLIENT_ID(resultSet
						.getString("PIBP_CLIENT_ID"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_POLICY_ID(resultSet
						.getString("PIBP_POLICY_ID"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_CLIENT_NAME(resultSet
						.getString("PIBP_CLIENT_NAME"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_ACC_NUMBER(resultSet
						.getString("PIBP_ACC_NUMBER"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_ACC_TYPE(resultSet
						.getString("PIBP_ACC_TYPE"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_BANK_CODE(resultSet
						.getString("PIBP_BANK_CODE"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_BRANCH_SHORT_CODE(resultSet
						.getString("PIBP_BRANCH_SHORT_CODE"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_ACC_NAME(resultSet
						.getString("PIBP_ACC_NAME"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_PAYMENT_DT(resultSet
						.getDate("PIBP_PAYMENT_DT"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_AMOUNT(resultSet
						.getDouble("PIBP_AMOUNT"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_LIFE_TYPE(resultSet
						.getString("PIBP_LIFE_TYPE"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_PROD_CODE(resultSet
						.getString("PIBP_PROD_CODE"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_COMPANY(resultSet
						.getString("PIBP_COMPANY"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_GROSS_AMOUNT(resultSet
						.getDouble("PIBP_GROSS_AMOUNT"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_MED_AID_DEDUCTION(resultSet
						.getDouble("PIBP_MED_AID_DEDUCTION"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_POL_PREMIUM(resultSet
						.getDouble("PIBP_POL_PREMIUM"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_PAYE(resultSet
						.getDouble("PIBP_PAYE"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_LOST_POL_FEES(resultSet
						.getDouble("PIBP_LOST_POL_FEES"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_PROCSS_FEES(resultSet
						.getDouble("PIBP_PROCSS_FEES"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_BANK_TRANSFER_FEES(resultSet
						.getDouble("PIBP_BANK_TRANSFER_FEES"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_OUT_STANDING_LOAN(resultSet
						.getDouble("PIBP_OUT_STANDING_LOAN"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_OTHRS_CHARGE(resultSet
						.getDouble("PIBP_OTHRS_CHARGE"));
				PW_IL_BENIFIT_PAYMT_BEAN.setPIBP_NET_AMOUNT(resultSet
						.getDouble("PIBP_NET_AMOUNT"));
				FileName=CommonUtils.dateToStringFormatter(PW_IL_BENIFIT_PAYMT_BEAN.getPIBP_PAYMENT_DT());
				compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN()
				.getDataList_PW_IL_BENIFIT_PAYMT().add(PW_IL_BENIFIT_PAYMT_BEAN);
			}
			compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process completed succesfully");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	public void executeSelectStatement_1(
			PILP207_COMPOSITE_ACTION compositeAction) throws Exception {
		List<String> data = new ArrayList<String>();

		Connection connection = null;
		ResultSet resultSet = null;
		ResultSet rs = null;
		String path=null;
		String Query = "SELECT distinct PIBP_FILE_NAME FROM  PW_IL_BENIFIT_PAYMT where trunc(PIBP_PAYMENT_DT) between  to_date(?,'dd/mm/yyyy')  and  to_date(?,'dd/mm/yyyy') ";
		//String Query1="select ps_code_desc from pp_system where ps_type like 'SMART_FILE'";
		compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getDataList_PW_IL_BENIFIT_PAYMT().clear();
		if(compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getListRE_GEN_FILE_NAME()!=null)
		{
			compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getListRE_GEN_FILE_NAME().clear();
		}
		ArrayList<SelectItem> list = null;
		SelectItem selectItem =null;

		try {
			list = new ArrayList<SelectItem>();

			String FileName=null;
			connection = CommonUtils.getConnection();
			resultSet=new CRUDHandler().executeSelectStatement(
					Query, connection, new Object[] {
							CommonUtils.dateToStringFormatter(compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getPW_IL_BENIFIT_PAYMT_BEAN().getUI_M_PIBP_RE_GEN_FM_DT()) ,
							CommonUtils.dateToStringFormatter(compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getPW_IL_BENIFIT_PAYMT_BEAN().getUI_M_PIBP_RE_GEN_TO_DT()) });


			while (resultSet.next()) {
				/* Newly Added By Dhinesh on 12-8-2017 for ssp call id : ZBILQC-1732129 */
				if(resultSet.getString("PIBP_FILE_NAME")!=null){
					selectItem = new SelectItem();
					selectItem.setLabel(resultSet.getString("PIBP_FILE_NAME"));
					selectItem.setValue(resultSet.getString("PIBP_FILE_NAME"));
					list.add(selectItem);
				}
				/* End */
			}
			compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN()
			.getListRE_GEN_FILE_NAME().addAll(list);

			System.out.println("compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getListRE_GEN_FILE_NAME()   "  + compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN()
					.getListRE_GEN_FILE_NAME().size());
			/*compositeAction.getPW_IL_BENIFIT_PAYMT_ACTION_BEAN().getWarningMap()
			.put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "Process completed succesfully");*/

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			CommonUtils.closeCursor(resultSet);
		}
	}
	private static void writeToFile(List<String> list, String path) {
		BufferedWriter out = null;
		try {

			File file = new File(path);
			out = new BufferedWriter(new FileWriter(file, false));
			for (String s : list) {
				out.write(s);
				out.newLine();

			}
			out.close();
		} catch (IOException e) {
		}
	}


}
