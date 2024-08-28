package com.iii.pel.forms.PILP028_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class RI_CLOSING_DELEGATE {

	public List treatyCodeLov(String code, List treatyCodeList) {
		String query;
		if ("*".equalsIgnoreCase(code)) {

			query = "SELECT DISTINCT PT_TREATY_CODE "
					+ "FROM PM_IL_PROP_TREATY "
					+ "WHERE PM_IL_PROP_TREATY.PT_FRZ_FLAG = 'N'"
                    +"ORDER BY 1ASC";

			treatyCodeList = LovForTreaty(query);
		} else {

			query = "SELECT DISTINCT PT_TREATY_CODE "
					+ "FROM PM_IL_PROP_TREATY "
					+ "WHERE PM_IL_PROP_TREATY.PT_FRZ_FLAG = 'N'"
					+ "AND PT_TREATY_CODE LIKE '" + code.toUpperCase() + "%' "
					+"ORDER BY 1ASC";
			treatyCodeList = LovForTreaty(query);
		}

		return treatyCodeList;
	}

	public List<RI_CLOSING> LovForTreaty(String query) {
		List<RI_CLOSING> codeList = new ArrayList<RI_CLOSING>();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			 resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				RI_CLOSING riClosingBean = new RI_CLOSING();
				riClosingBean.setUI_M_TREATY_CODE(resultSet.getString(1));
				codeList.add(riClosingBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{try {CommonUtils.closeCursor(resultSet);} catch (Exception e) {}}
		
		return codeList;
	}

	public List sNoLov(String sNo, List sNoList, String ttyCode) {
		String query;
		if ("*".equalsIgnoreCase(sNo)) {

			query = "SELECT DISTINCT PPTP_SUB_NO "
					+ "FROM  PM_IL_PROP_TREATY_PERIOD WHERE PPTP_PT_TREATY_CODE = ? ORDER BY PPTP_SUB_NO";
			
			sNoList = LovForsNo(query,ttyCode);
		} /*else {
			query = "SELECT DISTINCT PPTP_SUB_NO "
					+ "FROM  PM_IL_PROP_TREATY_PERIOD WHERE PPTP_SUB_NO LIKE '"
					+ sNo.toUpperCase() + "%' ";

			sNoList = LovForsNo(query);
		}*/

		return sNoList;

	}

	public List LovForsNo(String query,String ttyCode) {
		List<RI_CLOSING> sNoList = new ArrayList<RI_CLOSING>();
        ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object[] values = {ttyCode};
			 resultSet = handler.executeSelectStatement(query,
					connection ,values);
			while (resultSet.next()) {
				RI_CLOSING riClosingBean = new RI_CLOSING();
				riClosingBean.setUI_M_SRNO(resultSet.getInt(1));
				sNoList.add(riClosingBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + sNoList.size());
		return sNoList;

	}

	public List assrCodeFmLov(String assrFmcode, List assrCodeList) {
		String query;
		if ("*".equalsIgnoreCase(assrFmcode)) {
			query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
					+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<100"
                    +"ORDER BY 1ASC";
			assrCodeList = LovForassrCode(query);
		} else {
			query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
					+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<100"
					+ "AND CONT_CODE LIKE '" + assrFmcode.toUpperCase() + "%'"
					+"ORDER BY 1ASC";
			assrCodeList = LovForassrCode(query);
		}

		return assrCodeList;
	}

	public List<RI_CLOSING> LovForassrCode(String query) {
		List<RI_CLOSING> codeList = new ArrayList<RI_CLOSING>();
		ResultSet resultSet = null;
		System.out.println("Query for Assured Code >>> "+query);
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			 resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {
				RI_CLOSING riClosingBean = new RI_CLOSING();
				riClosingBean.setUI_M_ASSR_CODE_FM(resultSet.getString(1));
				codeList.add(riClosingBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				 CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

	public List assrCodeToLov(String assrTocode, List assrCodeList) {
		String query;
		if ("*".equalsIgnoreCase(assrTocode)) {

			query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
					+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<100"
					+"ORDER BY 1ASC";

			/*
			 * query = "SELECT DISTINCT POAD_ASSR_CODE " + "FROM
			 * PT_IL_POL_ASSURED_DTLS " + "WHERE ROWNUM<100 ";
			 */
			assrCodeList = LovForassrToCodeTo(query);
		}

		else {

			query = " SELECT CONT_CODE,CONT_NAME FROM PM_IL_CONTRACTOR"
					+ " WHERE CONT_FRZ_FLAG = 'N'" + "AND ROWNUM<100"
					+ "AND CONT_CODE LIKE '" + assrTocode.toUpperCase() + "%'"
					+"ORDER BY 1ASC";
			/*
			 * query = "SELECT DISTINCT POAD_ASSR_CODE " + "FROM
			 * PT_IL_POL_ASSURED_DTLS " + "WHERE ROWNUM<100 " + "AND
			 * POAD_ASSR_CODE LIKE '" + assrTocode.toUpperCase() + "%'";
			 */
			assrCodeList = LovForassrToCodeTo(query);

		}

		return assrCodeList;
	}

	public List<RI_CLOSING> LovForassrToCodeTo(String query) {
		List<RI_CLOSING> codeList = new ArrayList<RI_CLOSING>();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			 resultSet = handler.executeSelectStatement(query,
					connection);
			while (resultSet.next()) {

				RI_CLOSING riClosingBean = new RI_CLOSING();
				riClosingBean.setUI_M_ASSR_CODE_TO(resultSet.getString(1));
				codeList.add(riClosingBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return codeList;
	}

	public List<SelectItem> comboBoxValues(String formName, String blockname,
			String component, String componentId) {
		Connection connection = null;
		List<SelectItem> listItem = new java.util.ArrayList<SelectItem>();
		try {
			connection = CommonUtils.getConnection();
			listItem = (List<SelectItem>) ListItemUtil.getDropDownListValue(
					connection, formName, blockname, component, componentId);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return listItem;
	}

}
