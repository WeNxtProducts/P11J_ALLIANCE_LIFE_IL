package com.iii.pel.forms.PILT042_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILT042_APAC_DELEGATE {

	public ArrayList<PT_IL_PRE_CLAIMS_INFO> getLovForPolNo(Object string,PT_IL_PRE_CLAIMS_INFO infoBean) throws Exception {
		/*Modified by Saranya for Hands on points  no 11 claims on 04-02-2017*/
		
		/*String selectQuery = "select POL_NO from PT_IL_POLICY where POL_DS_TYPE ='2' AND (POL_ASSRD_REF_ID1=NVL(?,POL_ASSRD_REF_ID1) OR POL_ASSRD_REF_ID2=NVL(?,POL_ASSRD_REF_ID2))  AND POL_STATUS IN ('A','E','P','R') AND ROWNUM < "+PELConstants.suggetionRecordSize+" ";*/
		
		/*Modified by Janani on 01.09.2017 for ZBILQC-1733746*/
		
		/*String selectQuery = "select POL_NO from PT_IL_POLICY where POL_DS_TYPE ='2' AND (POL_ASSRD_REF_ID1=NVL(?,POL_ASSRD_REF_ID1) "
				+ "OR POL_ASSRD_REF_ID2=NVL(?,POL_ASSRD_REF_ID2))  AND POL_STATUS = 'A' AND POL_ADDL_STATUS NOT IN ('R','S01','D01','S02','D03')"
				+ "AND ROWNUM < "+PELConstants.suggetionRecordSize+" ";*/
		
			
		String selectQuery = "SELECT POL_NO, POL_PROD_CODE, POL_APPRV_STATUS, POL_STATUS"
				+ " FROM PT_IL_POLICY WHERE POL_DS_TYPE = '2' AND (POL_ASSRD_REF_ID1 = NVL(?, POL_ASSRD_REF_ID1) OR"
				+ " POL_ASSRD_REF_ID2 = NVL(?, POL_ASSRD_REF_ID2)) AND NVL(POL_APPRV_STATUS, 'X') = 'A'"
				+ " AND POL_STATUS IN ('A', 'E','P') AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03')"
				+ "	UNION"
				+ "	SELECT POL_NO, POL_PROD_CODE, POL_APPRV_STATUS, POL_STATUS FROM PT_IL_POLICY WHERE POL_DS_TYPE = '2'"
				+ " AND NVL(POL_APPRV_STATUS, 'X') <> 'A' AND (POL_ASSRD_REF_ID1 = NVL(?, POL_ASSRD_REF_ID1) OR"
				+ " POL_ASSRD_REF_ID2 = NVL(?, POL_ASSRD_REF_ID2)) AND NVL(POL_STATUS, 'X') = 'E'"
				+ " AND NVL(POL_APPRV_STATUS, 'X') = 'N' AND POL_ADDL_STATUS NOT IN ('R', 'S01', 'D01', 'S02', 'D03')"
				+ "AND ROWNUM < "+PELConstants.suggetionRecordSize+" ";
				
		/*End of ZBILQC-1733746*/
		
		/*End*/
		
		ArrayList<PT_IL_PRE_CLAIMS_INFO> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;

		String POL_ASSRD_REF_ID1 = infoBean.getPCI_ASSRD_REF_ID1();
		/*Commented by saranya for Hands on point num 11 on 07-02-2017*/
		//String POL_ASSRD_REF_ID2 = infoBean.getPCI_ASSRD_REF_ID2();
		/*End*/
		if(POL_ASSRD_REF_ID1==null){
			POL_ASSRD_REF_ID1 = "";
		}
		/*Commented by saranya for Hands on point num 11 on 07-02-2017*/
		/*if(POL_ASSRD_REF_ID2==null){
			POL_ASSRD_REF_ID2 = "";
		}*/
		/*End*/
		if ("*".equals(string)) {
			selectQuery = selectQuery+" "+"ORDER BY 1 ASC";
			
			/*Modified by Janani on 01.09.2017 for ZBILQC-1733746*/
			
			//values = new Object[2];
			values = new Object[4];
			
			/*End of ZBILQC-1733746*/
			
			values[0] = POL_ASSRD_REF_ID1;
			values[1] = POL_ASSRD_REF_ID1;
			
			/*Added by Janani on 01.09.2017 for ZBILQC-1733746*/
			values[2] = POL_ASSRD_REF_ID1;
			values[3] = POL_ASSRD_REF_ID1;
			
			/*End of ZBILQC-1733746*/
			
		} else {
			
			
/*Modified by Janani on 01.09.2017 for ZBILQC-1733746*/
			
			//values = new Object[3];
			values = new Object[5];
			
			/*End of ZBILQC-1733746*/
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
			 * 
			 * selectQuery = selectQuery + " and POL_NO LIKE ? ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
			selectQuery = selectQuery + " and UPPER(POL_NO) LIKE UPPER(?) ORDER BY 1 ASC";
			/*end*/
			values[0] = POL_ASSRD_REF_ID1;
			/*Modified by saranya for Hands on point num 11 on 07-11-2017*/
			values[1] = POL_ASSRD_REF_ID1;
			/*End*/
			
			/*Added by Janani on 01.09.2017 for ZBILQC-1733746*/
				
			values[2] = POL_ASSRD_REF_ID1;
			values[3] = POL_ASSRD_REF_ID1;
			
			//values[2] = string + "%";
			
			values[4] = string + "%";
			
			/*End of ZBILQC-1733746*/
			
			
		}

		ResultSet resultSet = null;
		PT_IL_PRE_CLAIMS_INFO classBean = null;

		try {
			connection = CommonUtils.getConnection();
System.out.println("VAKUES ===>"+values[0].toString());
			resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			custClassList = new ArrayList<PT_IL_PRE_CLAIMS_INFO>();
			while (resultSet.next()) {
				classBean = new PT_IL_PRE_CLAIMS_INFO();
					classBean.setPCI_POL_NO(resultSet.getString("POL_NO"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return custClassList;
	}
	public ArrayList<PT_IL_PRE_CLAIMS_INFO> getLovForIntimateMode(Object string) throws Exception {
		String selectQuery = "select PS_CODE,PS_CODE_DESC from PP_SYSTEM where PS_TYPE = ? ";
		ArrayList<PT_IL_PRE_CLAIMS_INFO> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;

		if ("*".equals(string)) {
			selectQuery = selectQuery+" "+"ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = "IL_INTI_MODE";
		} else {
			values = new Object[3];
			/*
			 * 
			 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * selectQuery = selectQuery + " AND (PS_CODE LIKE ? OR PS_CODE_DESC LIKE ?) ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
		/*	selectQuery = selectQuery + " AND (UPPER(PC_CODE) LIKE UPPER(UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";*/
			/*end*/
			/*Added by sANKARA NARAYANAN  for lov lower case issue ssp call id FALCONLIFE-1344105 on 16-03-2017*/
			selectQuery = selectQuery + " AND (UPPER(PS_CODE) LIKE UPPER(?) OR UPPER(PS_CODE_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*END*/
			values[0] = "IL_INTI_MODE";
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_IL_PRE_CLAIMS_INFO classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			custClassList = new ArrayList<PT_IL_PRE_CLAIMS_INFO>();
			while (resultSet.next()) {
				classBean = new PT_IL_PRE_CLAIMS_INFO();
					classBean.setPCI_INTIMATION_MODE(resultSet.getString("PS_CODE"));
					classBean.setUI_M_PCI_INTIMATION_MODE(resultSet.getString("PS_CODE_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return custClassList;
	}
	public ArrayList<PT_IL_PRE_CLAIMS_INFO> getLovPostal(Object string) throws Exception {
		String selectQuery = "select PC_CODE,PC_DESC from PM_CODES where PC_TYPE = ? and ROWNUM < 21 {0}  ";
		ArrayList<PT_IL_PRE_CLAIMS_INFO> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;

		if ("*".equals(string)) {
			selectQuery = selectQuery.replace("{0}", "");
			selectQuery = selectQuery+" "+"ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = "POSTAL";
		} else {
			selectQuery = selectQuery.replace("{0}", "");
			values = new Object[3];
			/*
			 * commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * selectQuery = selectQuery + " AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			selectQuery = selectQuery + " AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*end*/
			values[0] = "POSTAL";
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_IL_PRE_CLAIMS_INFO classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			custClassList = new ArrayList<PT_IL_PRE_CLAIMS_INFO>();
			while (resultSet.next()) {
				classBean = new PT_IL_PRE_CLAIMS_INFO();
					classBean.setPCI_RES_AREA_CODE(resultSet.getString("PC_CODE"));
					classBean.setUI_M_RES_AREA_NAME(resultSet.getString("PC_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return custClassList;
	}
	public ArrayList<PT_IL_PRE_CLAIMS_INFO> getLovCityCode(Object string) throws Exception {
		String selectQuery = "select PC_CODE,PC_DESC from PM_CODES where PC_TYPE = ? AND NVL(PC_FRZ_FLAG,'N') = 'N' AND ROWNUM < 21";
		ArrayList<PT_IL_PRE_CLAIMS_INFO> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;

		if ("*".equals(string)) {
			selectQuery = selectQuery+" "+"ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = "CITY";
		} else {
			values = new Object[3];
			/*
			 *commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016 
			 * 
			 * selectQuery = selectQuery + " AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY 1 ASC";*/
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			selectQuery = selectQuery + " AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*end*/
			values[0] = "CITY";
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_IL_PRE_CLAIMS_INFO classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			custClassList = new ArrayList<PT_IL_PRE_CLAIMS_INFO>();
			while (resultSet.next()) {
				classBean = new PT_IL_PRE_CLAIMS_INFO();
					classBean.setPCI_CITY_CODE(resultSet.getString("PC_CODE"));
					classBean.setUI_M_PCI_CITY_NAME(resultSet.getString("PC_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return custClassList;
	}
	public ArrayList<PT_IL_PRE_CLAIMS_INFO> getCountryCode(Object string) throws Exception {
		String selectQuery = "select PC_CODE,PC_DESC from PM_CODES where PC_TYPE = ? AND NVL(PC_FRZ_FLAG,'N') = 'N' and rownum <21";
		ArrayList<PT_IL_PRE_CLAIMS_INFO> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;

		if ("*".equals(string)) {
			selectQuery = selectQuery+" "+"ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = "COUNTRY";
		} else {
			values = new Object[3];
			/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016
			 * 
			 * selectQuery = selectQuery + " AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY 1 ASC";*/
			
			/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 14-10-2016*/
			selectQuery = selectQuery + " AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";
			/*End*/
			values[0] = "COUNTRY";
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_IL_PRE_CLAIMS_INFO classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			custClassList = new ArrayList<PT_IL_PRE_CLAIMS_INFO>();
			while (resultSet.next()) {
				classBean = new PT_IL_PRE_CLAIMS_INFO();
					classBean.setPCI_COUNTRY_CODE(resultSet.getString("PC_CODE"));
					classBean.setUI_M_PCI_COUNTRY_CODE(resultSet.getString("PC_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return custClassList;
	}
	public ArrayList<PT_IL_PRE_CLAIMS_INFO> getStateCode(Object string) throws Exception {
		String selectQuery = "select PC_CODE, PC_DESC from PM_CODES where PC_TYPE = ? AND NVL(PC_FRZ_FLAG,'N') = 'N' AND ROWNUM < 21";
		ArrayList<PT_IL_PRE_CLAIMS_INFO> custClassList = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		Object[] values;

		if ("*".equals(string)) {
			selectQuery = selectQuery+" "+"ORDER BY 1 ASC";
			values = new Object[1];
			values[0] = "STATE";
		} else {
			values = new Object[3];
			/*selectQuery = selectQuery + " AND (PC_CODE LIKE ? OR PC_DESC LIKE ?) ORDER BY 1 ASC";*/
			selectQuery = selectQuery + " AND (UPPER(PC_CODE) LIKE UPPER(?) OR UPPER(PC_DESC) LIKE UPPER(?)) ORDER BY 1 ASC";
			values[0] = "STATE";
			values[1] = string + "%";
			values[2] = string + "%";
		}
		ResultSet resultSet = null;
		PT_IL_PRE_CLAIMS_INFO classBean = null;
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection,values);
			custClassList = new ArrayList<PT_IL_PRE_CLAIMS_INFO>();
			while (resultSet.next()) {
				classBean = new PT_IL_PRE_CLAIMS_INFO();
					classBean.setPCI_STATE_CODE(resultSet.getString("PC_CODE"));
					classBean.setUI_M_PCI_STATE_CODE(resultSet.getString("PC_DESC"));
				custClassList.add(classBean);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
		return custClassList;
	}
	public static List<SelectItem> getDropDownListValue(String formName,
			String blockName, String blockFieldName, String filedName) throws Exception {
		List<SelectItem> listValues = null;
		try {
			listValues = ListItemUtil.getDropDownListValue(CommonUtils.getConnection(), formName, blockName, blockFieldName,filedName);
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return listValues;
	}
	public ArrayList<PT_IL_PRE_CLAIMS_INFO> fetchClaimValues(PILT042_APAC_SEATCH_ACTION claimBean) throws Exception {
		ArrayList<PT_IL_PRE_CLAIMS_INFO> detailList = null;
		PT_IL_PRE_CLAIMS_INFO detailBean = null;
		Connection con = null;
		CRUDHandler handler = null;
		String selectQuery = "SELECT ROWID,PCI_POL_NO,PCI_REF_NO,PCI_ASSRD_REF_ID1,PCI_ASSRD_REF_ID2 FROM PT_IL_PRE_CLAIMS_INFO ";
		ResultSet rst = null;
		boolean whereAdded = false;
		Object tempObject[] = new Object[3];
		Object object[] = null;
		
		String PCI_POL_NO = claimBean.getInitPol_NO();
		String PCI_REF_NO = claimBean.getInitREF_ID();
		String PCI_ASSRD_REF_ID1 = claimBean.getInitNew_IC_No();
		String PCI_ASSRD_REF_ID2 = claimBean.getInitOld_IC_No();
		
		int index = 0;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				if (PCI_POL_NO != null && !PCI_POL_NO.trim().isEmpty()) {
					selectQuery = selectQuery+ " WHERE PCI_POL_NO LIKE ? ";
					tempObject[index++] = PCI_POL_NO + "%";
					whereAdded = true;
				}
				if (PCI_REF_NO != null && !PCI_REF_NO.trim().isEmpty()) {
					if (whereAdded) {
						selectQuery = selectQuery+ " AND PCI_REF_NO LIKE ?";
					} else {
						selectQuery = selectQuery+ " WHERE PCI_REF_NO LIKE ?";
						whereAdded = true;
					}
					tempObject[index++] = PCI_REF_NO + "%";
				}
				if (PCI_ASSRD_REF_ID1 != null && !PCI_ASSRD_REF_ID1.trim().isEmpty()) {
					if (whereAdded) {
						selectQuery = selectQuery+ " AND PCI_ASSRD_REF_ID1 LIKE ?";
					} else {
						selectQuery = selectQuery+ " WHERE PCI_ASSRD_REF_ID1 LIKE ? ";
					}
					tempObject[index++] = PCI_ASSRD_REF_ID1 + "%";
				}
				if (PCI_ASSRD_REF_ID2 != null && !PCI_ASSRD_REF_ID2.trim().isEmpty()) {
					if (whereAdded) {
						selectQuery = selectQuery+ " AND PCI_ASSRD_REF_ID2 LIKE ?";
					} else {
						selectQuery = selectQuery+ " WHERE PCI_ASSRD_REF_ID2 LIKE ? ";
					}
					tempObject[index++] = PCI_ASSRD_REF_ID2 + "%";
				}
				object = new Object[index];
				for (int idx = 0; idx < index; idx++) {
					object[idx] = tempObject[idx];
				}
				handler = new CRUDHandler();
				detailList = new ArrayList<PT_IL_PRE_CLAIMS_INFO>();
				rst = handler.executeSelectStatement(selectQuery, con, object);
				while(rst.next()){
					detailBean = new PT_IL_PRE_CLAIMS_INFO();
						detailBean.setROWID(rst.getString("ROWID"));
						detailBean.setPCI_ASSRD_REF_ID2(rst.getString("PCI_ASSRD_REF_ID2"));
						detailBean.setPCI_ASSRD_REF_ID1(rst.getString("PCI_ASSRD_REF_ID1"));
						detailBean.setPCI_POL_NO(rst.getString("PCI_POL_NO"));
						detailBean.setPCI_REF_NO(rst.getString("PCI_REF_NO"));
					detailList.add(detailBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
		return detailList;
	}
	public PT_IL_PRE_CLAIMS_INFO fetchAllCLaimsDetails(PT_IL_PRE_CLAIMS_INFO detailBean) throws Exception{
		Connection con = null;
		CRUDHandler handler = null;
		String selectQuery = "SELECT TBL.ROWID,TBL.* FROM PT_IL_PRE_CLAIMS_INFO TBL WHERE TBL.ROWID = ?";
		String integrationQuery = "SELECT TBL.ROWID,TBL.* FROM PT_IL_PRE_CLAIMS_INFO TBL WHERE TBL.PCI_REF_NO = ?";
		String integrationQuery1 = "SELECT TBL.ROWID,TBL.* FROM PT_IL_PRE_CLAIMS_INFO TBL WHERE TBL.PCI_SYS_ID = ?";
		ResultSet rst = null;
		Object[] values = null;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				
				// Updated for integration 
				if(detailBean.getROWID() != null){
					values = new Object[]{detailBean.getROWID()};
				}else if(detailBean.getPCI_REF_NO() != null){
					selectQuery = integrationQuery;
					values = new Object[]{detailBean.getPCI_REF_NO()};
				}else if(detailBean.getPCI_SYS_ID() != 0){
					selectQuery = integrationQuery1;
					values = new Object[]{detailBean.getPCI_SYS_ID()};
				}
				
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					detailBean = new PT_IL_PRE_CLAIMS_INFO();
						detailBean.setROWID(rst.getString("ROWID"));
						detailBean.setPCI_ASSRD_REF_ID2(rst.getString("PCI_ASSRD_REF_ID2"));
						detailBean.setPCI_ASSRD_REF_ID1(rst.getString("PCI_ASSRD_REF_ID1"));
						detailBean.setPCI_POL_NO(rst.getString("PCI_POL_NO"));
						detailBean.setPCI_CLAIM_TYPE(rst.getString("PCI_CLAIM_TYPE"));
						detailBean.setPCI_LOSS_DT(rst.getDate("PCI_LOSS_DT"));
						detailBean.setPCI_REPORT_DT(rst.getDate("PCI_REPORT_DT"));
						detailBean.setPCI_INTIMATION_MODE(rst.getString("PCI_INTIMATION_MODE"));
						detailBean.setPCI_REF_NO(rst.getString("PCI_REF_NO"));
						detailBean.setPCI_RES_ADDRESS_1(rst.getString("PCI_RES_ADDRESS_1"));
						detailBean.setPCI_RES_ADDRESS_2(rst.getString("PCI_RES_ADDRESS_2"));
						detailBean.setPCI_RES_ADDRESS_3(rst.getString("PCI_RES_ADDRESS_3"));
						detailBean.setPCI_RES_AREA_CODE(rst.getString("PCI_RES_AREA_CODE"));
						detailBean.setPCI_CITY_CODE(rst.getString("PCI_CITY_CODE"));
						detailBean.setPCI_COUNTRY_CODE(rst.getString("PCI_COUNTRY_CODE"));
						detailBean.setPCI_STATE_CODE(rst.getString("PCI_STATE_CODE"));
						detailBean.setPCI_ACTION_TAKEN(rst.getString("PCI_ACTION_TAKEN"));
						detailBean.setPCI_REMARKS(rst.getString("PCI_REMARKS"));
						detailBean.setPCI_SYS_ID(rst.getInt("PCI_SYS_ID"));
						detailBean.setPCI_ADDL_STATUS(rst.getString("PCI_ADDL_STATUS"));
						detailBean.setPCI_CR_UID(rst.getString("PCI_CR_UID"));
						detailBean.setPCI_CR_DT(rst.getDate("PCI_CR_DT"));
						detailBean.setPCI_UPD_UID(rst.getString("PCI_UPD_UID"));
						detailBean.setPCI_UPD_DT(rst.getDate("PCI_UPD_DT"));
					postQuery1(detailBean);
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
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
		return detailBean;
	}

	public void preQuery(PT_IL_PRE_CLAIMS_INFO claimInfoBean){
		String CALLING_FORM = CommonUtils.getGlobalVariable("CALLING_FORM");

		if(CALLING_FORM != null && CALLING_FORM.startsWith("PILT006_APAC")){
			claimInfoBean.setPCI_REF_NO(CommonUtils.getGlobalVariable("GLOBAL.PRE_CLAIM_NO"));
		}else if(CommonUtils.getGlobalObject("GLOBAL.PCI_SYS_ID") != null){
			claimInfoBean.setPCI_SYS_ID((Integer) CommonUtils.getGlobalObject("GLOBAL.PCI_SYS_ID"));
		}
	}

	public void postQuery2(PT_IL_PRE_CLAIMS_INFO detailBean) throws Exception{
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
		String selectQuery = " SELECT POL_START_DT, POL_EXPIRY_DT,POL_DIVN_CODE,POL_CLASS_CODE,POL_UW_YEAR,POL_PLAN_CODE,POL_PROD_CODE FROM PT_IL_POLICY WHERE POL_NO = ? ";
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				Object[] values = { detailBean.getPCI_POL_NO() };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					detailBean.setUI_M_POL_START_DT(rst.getDate("POL_START_DT"));
					detailBean.setUI_M_POL_EXPIRY_DT(rst.getDate("POL_EXPIRY_DT"));
					detailBean.setUI_M_POL_DIVN_CODE(rst.getString("POL_DIVN_CODE"));
					detailBean.setUI_M_POL_CLASS_CODE(rst.getString("POL_CLASS_CODE"));
					detailBean.setUI_M_POL_UW_YEAR(rst.getInt("POL_UW_YEAR"));
					detailBean.setUI_M_POL_PLAN_CODE(rst.getString("POL_PLAN_CODE"));
					detailBean.setUI_M_POL_PROD_CODE(rst.getString("POL_PROD_CODE"));
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
	}
	public void postQuery1(PT_IL_PRE_CLAIMS_INFO detailBean) throws Exception{
		try {
			String inimateDescQuery = "select PS_CODE_DESC from PP_SYSTEM where PS_TYPE ='IL_INTI_MODE' and PS_CODE = ? ";
			String assignIntimateDesc = fetcgDesc(inimateDescQuery, "PS_CODE_DESC", detailBean.getPCI_INTIMATION_MODE());
			String stateDescQuery = "select PC_DESC from PM_CODES where PC_TYPE = 'STATE' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE = ?";
			String assignStateDesc = fetcgDesc(stateDescQuery, "PC_DESC", detailBean.getPCI_STATE_CODE());
			String countryDescQuery = "select PC_DESC from PM_CODES where PC_TYPE = 'COUNTRY' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE = ?";
			String assignCountryDesc = fetcgDesc(countryDescQuery, "PC_DESC", detailBean.getPCI_COUNTRY_CODE());
			String countryAreaQuery = "select PC_CODE,PC_DESC from PM_CODES where PC_TYPE = 'POSTAL' AND PC_CODE = ? ";
			String assignAreaDesc = fetcgDesc(countryAreaQuery, "PC_DESC", detailBean.getPCI_RES_AREA_CODE());
			String countrCityQuery = "select PC_CODE,PC_DESC from PM_CODES where PC_TYPE = 'CITY' AND NVL(PC_FRZ_FLAG,'N') = 'N' AND PC_CODE = ?";
			String assignCityDesc = fetcgDesc(countrCityQuery, "PC_DESC", detailBean.getPCI_CITY_CODE());
			String selectQuery = " SELECT PS_CODE_DESC FROM   PP_SYSTEM WHERE  PS_TYPE = 'IL_ADDL_STAT' AND    PS_CODE = ?";
			String assignStatus = fetcgDesc(selectQuery, "PS_CODE_DESC", detailBean.getPCI_ADDL_STATUS());
		/*	
		 *  COMMENTED BY SANKARA NARAYANAN ON 17-03-2017
		 * 
		 * String customerNameQuery = "SELECT CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE IN(SELECT POL_CUST_CODE FROM PT_IL_POLICY WHERE POL_NO = ? )";
			String customerName = fetcgDesc(customerNameQuery, "CUST_NAME", detailBean.getPCI_POL_NO());*/
			String customerNameQuery = "SELECT CUST_CODE,CUST_NAME FROM PM_CUSTOMER WHERE CUST_CODE IN(SELECT POL_CUST_CODE FROM PT_IL_POLICY WHERE POL_NO = ? )";
			ResultSet rs4= null;
			rs4= new CRUDHandler().executeSelectStatement(customerNameQuery, CommonUtils.getConnection(),
					new Object[] {detailBean.getPCI_POL_NO()});
			
			if (rs4.next()) {
				detailBean.setUI_M_PCI_CUST_CODE(rs4.getString("CUST_CODE"));
				detailBean.setUI_M_PCI_CUST_NAME(rs4.getString("CUST_NAME"));
				
			}
			
			
				detailBean.setUI_M_PCI_INTIMATION_MODE(assignIntimateDesc);
				detailBean.setUI_M_PCI_STATE_CODE(assignStateDesc);
				detailBean.setUI_M_PCI_COUNTRY_CODE(assignCountryDesc);
				detailBean.setUI_M_RES_AREA_NAME(assignAreaDesc);
				detailBean.setUI_M_PCI_CITY_NAME(assignCityDesc);
				detailBean.setUI_M_PCI_ADDL_STATUS(assignStatus);
				/*
				 *  COMMENTED BY SANKARA NARAYANAN ON 17-03-2017
				 * detailBean.setUI_M_PCI_CUST_NAME(customerName);*/
			
			postQuery2(detailBean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public String fetcgDesc(String selectQuery,String fieldName,String fieldValue) throws Exception{
		String assignDesc = null;
		Connection con = null;
		CRUDHandler handler = null;
		ResultSet rst = null;
			try {
				con= CommonUtils.getConnection();
				if (con != null) {
					handler = new CRUDHandler();
					Object[] values={fieldValue};
					rst = handler.executeSelectStatement(selectQuery, con, values);
					if(rst.next()){
						assignDesc = rst.getString(fieldName);
						assignDesc = assignDesc == null ? "" : assignDesc;
					}
				}
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			return assignDesc;
		} 
	public void claimsUpdate(PT_IL_PRE_CLAIMS_INFO claimsBean) throws Exception {
		CRUDHandler handler = null;
		Connection con = null;
			try {
				con = CommonUtils.getConnection();
				if (con != null) {
					handler = new CRUDHandler();
					handler.executeInsert(claimsBean, con);
				}
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (InstantiationException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}
	public void fetchPolicyAddress(PT_IL_PRE_CLAIMS_INFO claimsBean,String filedName,String fieldVale) throws Exception{
		CRUDHandler handler = null;
		Connection con = null;
		ResultSet rst = null;
		String polNumber = fieldVale;
		/*
		 * Commented by sankara narayanan on 17/03/2017
		 * String selectQuery = "SELECT POL_RES_ADDRESS_1,POL_RES_ADDRESS_2,POL_RES_ADDRESS_3 FROM PT_IL_POLICY WHERE  "+filedName+"= ?";*/
		
		
		String selectQuery ="SELECT CUST_CODE,CUST_NAME,CUST_ADDR1,CUST_ADDR2,CUST_ADDR3,CUST_CITY_CODE,CUST_CITY,CUST_COUNT_CODE,CUST_COUNTRY FROM PM_CUSTOMER WHERE CUST_CODE =(SELECT POL_CUST_CODE "+
		          "FROM PT_IL_POLICY      WHERE "+filedName+"= ?)";

		
		String addr1 = null;
		String addr2 = null;
		String addr3 = null;
		String code = null;
		String name = null;
		try {
			con = CommonUtils.getConnection();
			if(con!= null){
				handler = new CRUDHandler();
				Object[] values = { polNumber };
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
					/*
					 * 
					 * Commented by sankara narayanan on 17/03/2017
					 * addr1 = rst.getString("POL_RES_ADDRESS_1");
					addr2 = rst.getString("POL_RES_ADDRESS_2");
					addr3 = rst.getString("POL_RES_ADDRESS_3");*/
					 addr1 = rst.getString("CUST_ADDR1");
					addr2 = rst.getString("CUST_ADDR2");
					addr3 = rst.getString("CUST_ADDR3");
					code=rst.getString("CUST_CODE");
					name=rst.getString("CUST_NAME");
					addr1 = addr1 == null ? "" : addr1;
					addr2 = addr2 == null ? "" : addr2;
					addr3 = addr3 == null ? "" : addr3;
					claimsBean.setPCI_COUNTRY_CODE(rst.getString("CUST_COUNT_CODE"));
					claimsBean.setUI_M_PCI_COUNTRY_CODE(rst.getString("CUST_COUNTRY"));
					claimsBean.setPCI_CITY_CODE(rst.getString("CUST_CITY_CODE"));
					claimsBean.setUI_M_PCI_CITY_NAME(rst.getString("CUST_CITY"));
				}
				claimsBean.setPCI_RES_ADDRESS_1(addr1);
				claimsBean.setPCI_RES_ADDRESS_2(addr2);
				claimsBean.setPCI_RES_ADDRESS_3(addr3);
				claimsBean.setUI_M_PCI_CUST_CODE(code);
				claimsBean.setUI_M_PCI_CUST_NAME(name);
				
			
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void executeSelectStatement(PT_IL_PRE_CLAIMS_INFO detailBean) throws Exception{
		Connection con = null;
		CRUDHandler handler = null;
		String selectQuery = "SELECT TBL.ROWID,TBL.* FROM PT_IL_PRE_CLAIMS_INFO TBL WHERE TBL.ROWID = ?";
		String integrationQuery = "SELECT TBL.ROWID,TBL.* FROM PT_IL_PRE_CLAIMS_INFO TBL WHERE TBL.PCI_REF_NO = ?";
		String integrationQuery1 = "SELECT TBL.ROWID,TBL.* FROM PT_IL_PRE_CLAIMS_INFO TBL WHERE TBL.PCI_SYS_ID = ?";
		ResultSet rst = null;
		Object[] values = null;
		try {
			con = CommonUtils.getConnection();
			if (con != null) {
				handler = new CRUDHandler();
				
				// Updated for integration 
				if(detailBean.getROWID() != null){
					values = new Object[]{detailBean.getROWID()};
				}else if(detailBean.getPCI_REF_NO() != null){
					selectQuery = integrationQuery;
					values = new Object[]{detailBean.getPCI_REF_NO()};
				}else if(detailBean.getPCI_SYS_ID() != 0){
					selectQuery = integrationQuery1;
					values = new Object[]{detailBean.getPCI_SYS_ID()};
				}
				
				rst = handler.executeSelectStatement(selectQuery, con, values);
				if(rst.next()){
						detailBean.setROWID(rst.getString("ROWID"));
						detailBean.setPCI_ASSRD_REF_ID2(rst.getString("PCI_ASSRD_REF_ID2"));
						detailBean.setPCI_ASSRD_REF_ID1(rst.getString("PCI_ASSRD_REF_ID1"));
						detailBean.setPCI_POL_NO(rst.getString("PCI_POL_NO"));
						detailBean.setPCI_CLAIM_TYPE(rst.getString("PCI_CLAIM_TYPE"));
						detailBean.setPCI_LOSS_DT(rst.getDate("PCI_LOSS_DT"));
						detailBean.setPCI_REPORT_DT(rst.getDate("PCI_REPORT_DT"));
						detailBean.setPCI_INTIMATION_MODE(rst.getString("PCI_INTIMATION_MODE"));
						detailBean.setPCI_REF_NO(rst.getString("PCI_REF_NO"));
						detailBean.setPCI_RES_ADDRESS_1(rst.getString("PCI_RES_ADDRESS_1"));
						detailBean.setPCI_RES_ADDRESS_2(rst.getString("PCI_RES_ADDRESS_2"));
						detailBean.setPCI_RES_ADDRESS_3(rst.getString("PCI_RES_ADDRESS_3"));
						detailBean.setPCI_RES_AREA_CODE(rst.getString("PCI_RES_AREA_CODE"));
						detailBean.setPCI_CITY_CODE(rst.getString("PCI_CITY_CODE"));
						detailBean.setPCI_COUNTRY_CODE(rst.getString("PCI_COUNTRY_CODE"));
						detailBean.setPCI_STATE_CODE(rst.getString("PCI_STATE_CODE"));
						detailBean.setPCI_ACTION_TAKEN(rst.getString("PCI_ACTION_TAKEN"));
						detailBean.setPCI_REMARKS(rst.getString("PCI_REMARKS"));
						detailBean.setPCI_SYS_ID(rst.getInt("PCI_SYS_ID"));
						detailBean.setPCI_ADDL_STATUS(rst.getString("PCI_ADDL_STATUS"));
						detailBean.setPCI_CR_UID(rst.getString("PCI_CR_UID"));
						detailBean.setPCI_CR_DT(rst.getDate("PCI_CR_DT"));
						detailBean.setPCI_UPD_UID(rst.getString("PCI_UPD_UID"));
						detailBean.setPCI_UPD_DT(rst.getDate("PCI_UPD_DT"));
						detailBean.setPCI_ASSRD_CODE(rst.getString("PCI_ASSRD_CODE"));
						
						/*Added by Janani on 25.05.2017 for ZBILQC-1727100*/
						detailBean.setPCI_INTIMATION_SRC(rst.getString("PCI_ASSRD_CODE"));
						detailBean.setPCI_INTIMATOR_NAME(rst.getString("PCI_INTIMATOR_NAME"));
						detailBean.setPCI_INTIMATOR_MOBILE(rst.getString("PCI_INTIMATOR_MOBILE"));
						detailBean.setPCI_INTIMATOR_EMAIL(rst.getString("PCI_INTIMATOR_EMAIL"));
						/*End*/
						
					    postQuery1(detailBean);
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
		}finally{
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
			}
		}
	}
}
