package com.iii.pel.forms.PILM034;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_TAR_HDR_HELPER {
	CommonUtils utils = new CommonUtils();
	DBProcedures procedure = new DBProcedures();
	public void executeQuery(PILM034_COMPOSITE_ACTION compositeAction) throws Exception {
		new PM_IL_TAR_HDR_DELEGATE().executeSelectStatement(compositeAction);

		List<PM_IL_TAR_HDR> dataHDRList = compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().getDataList();
		if(dataHDRList!=null && dataHDRList.size() > 0){
			PM_IL_TAR_HDR PM_IL_TAR_HDR_BEAN = dataHDRList.get(0);
			PM_IL_TAR_HDR_BEAN.setRowSelected(true);
			compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().setPM_IL_TAR_HDR_BEAN(PM_IL_TAR_HDR_BEAN);

			compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().setDataList(dataHDRList);
		}
	}
	public void preInsert(PM_IL_TAR_HDR pm_il_tar_hdr) throws Exception{
		String M_VAR = null;
		HashMap<String, String> mType1 = null;
		String M_CHECK_VAL = null;
		String M_OUT1 = " ";
		String M_OUT2 = " ";
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			String C1 = "SELECT 'X' FROM PM_IL_TAR_HDR WHERE TH_PARAM_TYPE = ?" +
			"AND TH_CODE = ?";
			resultSet = handler.executeSelectStatement(C1, connection, 
					new Object[]{pm_il_tar_hdr.getTH_PARAM_TYPE(),pm_il_tar_hdr.getTH_CODE()});
			if(resultSet.next()){
				M_VAR = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91029"));
				//	CommonUtils.setGlobalVariable("GLOBAL.X", "1");
			}
			pm_il_tar_hdr.setTH_CR_DT(utils.getCurrentDate());
			pm_il_tar_hdr.setTH_CR_UID(CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"));
			L_PARAM_ENTRY_CHK(pm_il_tar_hdr);
			mType1 = new HashMap<String, String>();
			mType1.put("1", new String("" + pm_il_tar_hdr.getTH_PARA_01()));
			mType1.put("2", new String("" + pm_il_tar_hdr.getTH_PARA_02()));
			mType1.put("3", new String("" + pm_il_tar_hdr.getTH_PARA_03()));
			mType1.put("4", new String("" + pm_il_tar_hdr.getTH_PARA_04()));
			mType1.put("5", new String("" + pm_il_tar_hdr.getTH_PARA_05()));
			mType1.put("6", new String("" + pm_il_tar_hdr.getTH_PARA_06()));
			mType1.put("7", new String("" + pm_il_tar_hdr.getTH_PARA_07()));
			mType1.put("8", new String("" + pm_il_tar_hdr.getTH_PARA_08()));
			mType1.put("9", new String("" + pm_il_tar_hdr.getTH_PARA_09()));
			mType1.put("10", new String("" + pm_il_tar_hdr.getTH_PARA_10()));
			for (int M_VAR1 = 1; M_VAR1 <= 9; M_VAR1++) {
				if (((String) mType1.get("" + M_VAR1)) == null) {
					M_OUT1 = "Y";
				}
				if (((String) mType1.get("" + M_VAR1)) != null) {
					if (M_OUT1.equals("" + "Y")) {
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91037"));
					}
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception exc){}
		}
	}

	public int key_delrec(PM_IL_TAR_HDR pm_il_tar_hdr, String livCode) throws Exception
	{
		int rowCount = 0;
		String M_VAR1 = null;
		String M_VAR2 = null;
		String M_VAR3 = null;
		String sql_C1 = null;
		String sql_C2 = null;
		String sql_C3 = null;
		String sql_C4 = null;
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		ResultSet resultSetC3 = null;
		String CODE = null;
		String hdrThParamType = null;
		Object values[] = null;

		Connection connection = null;
		CRUDHandler handler = null;
		try {
			CODE = pm_il_tar_hdr.getTH_CODE();
			hdrThParamType = pm_il_tar_hdr.getTH_PARAM_TYPE();
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			sql_C1 = "SELECT 'X' FROM PT_IL_POLICY WHERE POL_PLAN_CODE = ?";

			sql_C2 = "SELECT 'X' FROM PT_IL_POL_ADDL_COVER WHERE POAC_COVER_CODE = ?";

			sql_C3 = "SELECT 'X' FROM PM_IL_PROD_APPL_LOAD_TARIFF WHERE  PALT_TH_CODE = ?";

			if ("U".equalsIgnoreCase(livCode)
					|| "RI".equalsIgnoreCase(livCode)
					|| "FAC".equalsIgnoreCase(livCode)
					|| "CQS".equalsIgnoreCase(livCode)) {

				resultSetC1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{CODE});
				if (resultSetC1.next()) {
					M_VAR1 = resultSetC1.getString(1);
				}

				resultSetC2 = handler.executeSelectStatement(sql_C2, connection, new Object[]{CODE});
				if (resultSetC2.next()) {
					M_VAR2 = resultSetC2.getString(1);
				}
				if (M_VAR1 != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91050"));
				} else if (M_VAR2 != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91050"));
				} else {
					sql_C4 = "DELETE FROM PM_IL_TAR_DTL WHERE TD_TH_CODE = ? AND " +
					"TD_PARAM_TYPE = ?";
					values = new Object[2];
					values[0] = CODE;
					values[1] = hdrThParamType;

					rowCount = handler.executeDeleteStatement(sql_C4,
							connection, values);
				}
			} else if ("L".equalsIgnoreCase(livCode)
					|| "D".equalsIgnoreCase(livCode)) {
				resultSetC3 = handler.executeSelectStatement(sql_C3, connection, new Object[]{CODE});
				if (resultSetC3.next()) {
					M_VAR3 = resultSetC3.getString(1);
				}
				if (M_VAR3 != null) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91050"));
				} else {
					sql_C4 = "DELETE FROM PM_IL_TAR_DTL WHERE TD_TH_CODE = ? AND" +
					"TD_PARAM_TYPE = ?";
					values = new Object[2];
					values[0] = CODE;
					values[1] = hdrThParamType;

					rowCount = handler.executeDeleteStatement(sql_C4,
							connection, values);
				}
			}

			connection.commit();
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try {CommonUtils.closeCursor(resultSetC1);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC2);} catch (Exception e) {e.printStackTrace();}
			try {CommonUtils.closeCursor(resultSetC3);} catch (Exception e) {e.printStackTrace();}
		}
		return rowCount;
	}
	public void postQuery(PM_IL_TAR_HDR pm_il_tar_hdr, String livCode) throws Exception{
		ArrayList<String> output = null;
		try {
			output = new ArrayList<String>();
			if (("U".equalsIgnoreCase(livCode))
					|| ("RI".equalsIgnoreCase(livCode))
					|| ("FAC".equalsIgnoreCase(livCode))
					|| ("CQS".equalsIgnoreCase(livCode))) {
				output = procedure.helperP_VAL_COVER(pm_il_tar_hdr.getTH_CODE(), 
						pm_il_tar_hdr.getUI_M_TH_CODE(), "N", "N");
			}else if("D".equalsIgnoreCase(livCode)){
				output = procedure.helperP_VAL_CODES("IL_DISC",pm_il_tar_hdr.getTH_CODE(),
						"N","N",null);
			}else if("L".equalsIgnoreCase(livCode)){
				output = procedure.helperP_VAL_CODES("IL_LOAD",pm_il_tar_hdr.getTH_CODE(),
						"N", "N", null);
			}
			if(output != null && output.size() != 0){
				pm_il_tar_hdr.setUI_M_TH_CODE(output.get(0));
			}
		}catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	public void preBlock(){
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "TRUE");
	}
	public void preUpdate(PM_IL_TAR_HDR pm_il_tar_hdr) throws Exception{
		String M_VAR = null;
		Object values[] = null;
		String th_param_type = null;
		String thCode = null;
		String query = null;
		String M_OUT1 = " ";
		String uid = null;
		ResultSet resultSet = null;
		Connection connection = null;
		CRUDHandler handler = null;
		HashMap<String, String> mType1 = null;
		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			th_param_type = pm_il_tar_hdr.getTH_PARAM_TYPE();
			thCode = pm_il_tar_hdr.getTH_CODE();
			query = "SELECT 'X' FROM PM_IL_TAR_HDR WHERE  TH_PARAM_TYPE = ? AND " +
			"TH_CODE = ? AND ROWID != ?";
			values = new Object[3];
			values[0] = th_param_type;
			values[1] = thCode;
			values[2] = pm_il_tar_hdr.getROWID();
			resultSet = handler.executeSelectStatement(query, connection,
					values);

			if (resultSet.next()) {
				M_VAR = resultSet.getString(1);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91029"));
			}
			CommonUtils utils = new CommonUtils();
			uid = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
			pm_il_tar_hdr.setTH_UPD_DT(utils.getCurrentDate());
			pm_il_tar_hdr.setTH_UPD_UID(uid);

			mType1 = new HashMap<String, String>();
			mType1.put("1", new String("" + pm_il_tar_hdr.getTH_PARA_01()));
			mType1.put("2", new String("" + pm_il_tar_hdr.getTH_PARA_02()));
			mType1.put("3", new String("" + pm_il_tar_hdr.getTH_PARA_03()));
			mType1.put("4", new String("" + pm_il_tar_hdr.getTH_PARA_04()));
			mType1.put("5", new String("" + pm_il_tar_hdr.getTH_PARA_05()));
			mType1.put("6", new String("" + pm_il_tar_hdr.getTH_PARA_06()));
			mType1.put("7", new String("" + pm_il_tar_hdr.getTH_PARA_07()));
			mType1.put("8", new String("" + pm_il_tar_hdr.getTH_PARA_08()));
			mType1.put("9", new String("" + pm_il_tar_hdr.getTH_PARA_09()));
			mType1.put("10", new String("" + pm_il_tar_hdr.getTH_PARA_10()));
			for (int M_VAR1 = 1; M_VAR1 <= 9; M_VAR1++) {
				if (((String) mType1.get("" + M_VAR1)) == null) {
					M_OUT1 = "Y";
				}
				if (((String) mType1.get("" + M_VAR1)) != null) {
					if (M_OUT1.equals("" + "Y")) {
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91037"));
					}
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (ParseException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_NEW_BLOCK_INSTANCE(PM_IL_TAR_HDR_ACTION pm_il_tar_hdr_action) throws Exception{
		String fieldName = "TH_PARA_0";
		Method method = null;
		UIInput input = null;
		try{
		for(int index = 2; index <= 9; index++){
			method = PM_IL_TAR_HDR_ACTION.class.getDeclaredMethod("getCOMP_" + fieldName + index);
			input = (UIInput) method.invoke(pm_il_tar_hdr_action);
			input.setRequired(false);
		}
		pm_il_tar_hdr_action.getCOMP_TH_PARA_10().setRequired(false);
		} catch (SecurityException e) {
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			throw new Exception(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			throw new Exception(e.getMessage());
		}
	}
	private String getDropDownLabel(ArrayList<SelectItem> itemList, String value) {
		String label = null;
		SelectItem selectItem = null;
		if (itemList.size() > 0) {
			for (int index = 0; index < itemList.size(); index++) { 
				selectItem = itemList.get(index);
				if (selectItem.getValue().toString().equals(value)) {
					label = selectItem.getLabel();
					break;
				}
			}
		}
		return label;
	}

	public void ON_POPULATE_DETAILS(PILM034_COMPOSITE_ACTION compositeAction, 
			String TH_CODE, String TH_PARAM_TYPE) throws Exception{
		PM_IL_TAR_HDR pm_il_tar_hdr = compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().
		getPM_IL_TAR_HDR_BEAN();
		if ( pm_il_tar_hdr.getTH_CODE() != null || pm_il_tar_hdr.getTH_PARAM_TYPE() != null) {
			try {
				new PM_IL_TAR_DTL_DELEGATE().executeSelectStatement(compositeAction, TH_CODE, TH_PARAM_TYPE);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
		}
	}

	public void L_PARAM_ENTRY_CHK(PM_IL_TAR_HDR detailBean) throws Exception {
		String M_CHECK_VAL = null;
		String M_OUT1 = null;
		String M_OUT2 = null;
		HashMap<String, String> mType1 = null;
		int count = 0;

		//ArrayList<String>
		CommonUtils.setGlobalVariable("GLOBAL.M_COUNT", "0");

		mType1 = new HashMap<String, String>();
		mType1.put("1", new String("" + detailBean.getTH_PARA_01()));
		mType1.put("2", new String("" + detailBean.getTH_PARA_02()));
		mType1.put("3", new String("" + detailBean.getTH_PARA_03()));
		mType1.put("4", new String("" + detailBean.getTH_PARA_04()));
		mType1.put("5", new String("" + detailBean.getTH_PARA_05()));
		mType1.put("6", new String("" + detailBean.getTH_PARA_06()));
		mType1.put("7", new String("" + detailBean.getTH_PARA_07()));
		mType1.put("8", new String("" + detailBean.getTH_PARA_08()));
		mType1.put("9", new String("" + detailBean.getTH_PARA_09()));
		mType1.put("10", new String("" + detailBean.getTH_PARA_10()));
		for (int M_VAR1 = 1; M_VAR1 <= 9; M_VAR1++) {
			if ("0".equalsIgnoreCase((String) mType1.get("" + M_VAR1))
					&& M_VAR1 == 1) {
				M_OUT2 = "Y";
				break;
			}
			if (!"".equalsIgnoreCase((String) mType1.get("" + M_VAR1))) {
				count = Integer.parseInt(CommonUtils.getGlobalVariable("GLOBAL.M_COUNT"));
				CommonUtils.setGlobalVariable("GLOBAL.M_COUNT", String.valueOf(count+1));
			} else {
				break;
			}
			M_CHECK_VAL = ((String) mType1.get("" + M_VAR1));
			for (int M_VAR2 = M_VAR1 + 1; M_VAR2 <= 10; M_VAR2++) {
				if (!"0".equals((String) mType1.get("" + M_VAR2)) && 
						M_CHECK_VAL.equals("" + ((String) mType1.get("" + M_VAR2)))) {
					M_OUT1 = "Y";
					break;
				} else {
					M_OUT1 = "N";
				}
			}
			if (M_OUT1.equals("Y")) {
				break;
			}
		}
		if (M_OUT2 != null && M_OUT2.equals("Y")) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91035"));
		}
		if (M_OUT1 != null && M_OUT1.equals("Y")) {
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "91030"));
		}
	}

	public void WHEN_VALIDATE_ITEM_TH_CODE(PM_IL_TAR_HDR pm_il_tar_hdr, 
			String value, String liv_code,String TH_Code,String Param_Type) throws Exception{
		//pm_il_tar_hdr.setTH_DESC(" ");
		ArrayList<String> th_description = null;
		
		try {
			if(pm_il_tar_hdr.getROWID()==null||!TH_Code.equalsIgnoreCase(value)||!Param_Type.equalsIgnoreCase(liv_code)){
			String Cursor="SELECT 'X' FROM PM_IL_TAR_HDR WHERE TH_CODE = ? AND TH_PARAM_TYPE = ?";
			Connection con = CommonUtils.getConnection();
			ResultSet rs=new CRUDHandler().executeSelectStatement(Cursor, con, new Object[]{value,liv_code});
			if(rs.next()){
				throw new Exception("Setup for this combination already exist !"); 
			}
			}
			if (("U".equalsIgnoreCase(liv_code))
					|| ("RI".equalsIgnoreCase(liv_code))
					|| ("FAC".equalsIgnoreCase(liv_code))
					|| ("CQS".equalsIgnoreCase(liv_code))) {
				th_description = procedure.helperP_VAL_COVER(value, null, "N", "E");
			}else if("D".equalsIgnoreCase(liv_code)){
				th_description = procedure.helperP_VAL_CODES("IL_DISC",
						value,"N","E",null);
			}else if("ML".equalsIgnoreCase(liv_code)
					|| "L".equalsIgnoreCase(liv_code)){
				th_description = procedure.helperP_VAL_CODES("IL_LOAD",
						value, "N", "E", null);
			}else if ("M".equalsIgnoreCase(liv_code)){
				th_description = procedure.helperP_VAL_CODES("IL_MORT_CODE",
						value, "N", "E", null);
			}else if ("SA".equalsIgnoreCase(liv_code)){
				th_description = procedure.helperP_VAL_CODES("IL_SA_FACTOR",
						value, "N", "E", null);
			}else if ("V".equalsIgnoreCase(liv_code)){
				th_description = procedure.helperP_VAL_CODES("IL_VAL_TAR",
						value, "N", "E", null);
			}
			if(th_description != null){
				pm_il_tar_hdr.setUI_M_TH_CODE(th_description.get(0));
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}	

	public void WHEN_VALIDATE_ITEM_TH_RATE_PER(PM_IL_TAR_HDR pm_il_tar_hdr) throws Exception{
		try {
			if (pm_il_tar_hdr.getTH_RATE_PER() < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91052"));
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public HashMap<String, String> L_NULL_INBETWEEN(UIInput component) {
		HashMap<String, String> outValueMap = new HashMap<String, String>();

		if(component.getValue() == null){
			outValueMap.put("M_YN", "Y");
			outValueMap.put("WARNING", Messages.getString(
					PELConstants.pelErrorMessagePath, "91037"));
		}
		return outValueMap;
	}

	public void WHEN_VALIDATE_ITEM_TH_EFF_FM_DT(
			PM_IL_TAR_HDR pm_il_tar_hdr) throws Exception {

		String d1 = "01/01/1900";
		String d2 = "31/12/2999";

		Date tempFmDt = CommonUtils.stringToPelUtilDate(d1);
		Date tempToDt = CommonUtils.stringToPelUtilDate(d2);
		java.util.Date fromDate = null;
		java.util.Date toDate = null;

		fromDate = pm_il_tar_hdr.getTH_EFF_FM_DT();
		toDate = pm_il_tar_hdr.getTH_EFF_TO_DT();
		if(toDate!=null){
			if (fromDate.after(tempFmDt) && fromDate.before(tempToDt)) {
				if (fromDate.after(toDate)) {
					throw new ValidatorException(Messages.getMessage(
							PELConstants.pelErrorMessagePath, "91010"));
				}
			} 
		}
	}

	public void WHEN_VALIDATE_ITEM_TH_EFF_TO_DT(
			PM_IL_TAR_HDR pm_il_tar_hdr) throws Exception {
		String date1 = "01/01/1900";
		String date2 = "31/12/2999";

		Date tempFmDt = CommonUtils.stringToPelUtilDate(date1);
		Date tempToDt = CommonUtils.stringToPelUtilDate(date2);
		
		Date fromDate = null;
		Date toDate = null;

		fromDate = pm_il_tar_hdr.getTH_EFF_FM_DT();
		toDate = pm_il_tar_hdr.getTH_EFF_TO_DT();

		if (fromDate != null) {
			if (toDate.after(tempFmDt) && toDate.before(tempToDt)) {
				if (toDate.before(fromDate)) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91001"));
				}
			} 
		}
	}
	public ArrayList<PM_IL_TAR_PARAM> getCaptionValues() throws Exception{
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		PM_IL_TAR_PARAM valueBean = null;
		ArrayList<PM_IL_TAR_PARAM> valueBeanList =null;

		try {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			if(connection != null){
				Object[] value={};
				query = PILM034_QUERYCONSTANTS.PM_IL_TAR_HDR_SelectCaptionValues;
				resultSet = handler.executeSelectStatement(query, connection,value);
				valueBeanList = new ArrayList<PM_IL_TAR_PARAM>();
				while(resultSet.next()){
					valueBean = new PM_IL_TAR_PARAM();

					valueBean.setTP_SRNO(resultSet.getInt(1));
					valueBean.setTP_CAPTION(resultSet.getString(2));
					valueBean.setROWID(resultSet.getString(3));
					valueBeanList.add(valueBean);
				}
			}
			connection.commit();
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valueBeanList;
	}
}
