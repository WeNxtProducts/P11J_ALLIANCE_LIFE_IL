package com.iii.pel.forms.PILP042_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILQ106_APAC.PS_IL_UNIT_FUND_REG;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_FUND_TRAN_DTL_DELEGATE {

	public int updateData(PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl)
			throws Exception {

		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pt_il_fund_tran_dtl,
					connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int updateData(PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl)
			throws Exception {

		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;

		try {
			connection = CommonUtils.getConnection();
			rowUpdated = dbHandler.executeInsert(pt_il_fund_tran_dtl,
					connection);
			connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}

	public int deleteData(PT_IL_FUND_TRAN_DTL gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

	public int deleteData(PT_IL_FUND_TRAN_DTL_1 gridValueBean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
	/* for medical detail block */

	public List fetchCodeList(String code, List CodeList) {
		String query;
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
		.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		String productCode= compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().getPT_IL_FUND_TRAN_HDR_BEAN().getUI_M_FTH_PROD_CODE();
		if ("*".equalsIgnoreCase(code)) {
         /*   query=  " SELECT PAF_FUND_CODE,FS_DESC" +
            		" FROM PM_IL_PROD_APPL_FUND,PM_IL_FUND_SETUP "+
                    " WHERE  FS_CODE = PAF_FUND_CODE "+
                    " AND PAF_PROD_CODE = '"+productCode+"'";*/
			query=  " SELECT FS_CODE,FS_DESC"+
           " FROM   PM_IL_FUND_SETUP"+
           " WHERE  FS_CODE IN " +
           " (SELECT PAF_FUND_CODE " +
           " FROM PM_IL_PROD_APPL_FUND"+
           " WHERE  PAF_PROD_CODE = '"+productCode+"')";
          

			CodeList = codeLOV(query);
		} else {
			
			query=  " SELECT FS_CODE,FS_DESC"+
	           " FROM   PM_IL_FUND_SETUP"+
	           " WHERE  FS_CODE IN " +
	           " (SELECT PAF_FUND_CODE " +
	           " FROM PM_IL_PROD_APPL_FUND"+
	           " WHERE  PAF_PROD_CODE = '"+productCode+"')"+
	           " AND  UPPER(FS_CODE) LIKE '" + code.toUpperCase()+ "%'";
			
           /* query = " SELECT PAF_FUND_CODE,FS_DESC" +
            		" FROM PM_IL_PROD_APPL_FUND,PM_IL_FUND_SETUP "+
                    " WHERE  FS_CODE = PAF_FUND_CODE "+
                    " AND PAF_PROD_CODE = '"+productCode+"'"+
                    " AND UPPER(FS_CODE) LIKE '" + code.toUpperCase()+ "%'";*/
                   
		
			CodeList = codeLOV(query);

		}

		return CodeList;
	}

	public String getCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = (PT_IL_FUND_TRAN_DTL) iterator
					.next();
			if (Code.equalsIgnoreCase(pt_il_fund_tran_dtl.getFTD_FUND_CODE())) {
				codedesc = pt_il_fund_tran_dtl.getUI_M_PFTD_FUND_DESC();
			}
		}
		return codedesc;
	}

	public List<PT_IL_FUND_TRAN_DTL> codeLOV(String query) {
		List<PT_IL_FUND_TRAN_DTL> codeList = new ArrayList<PT_IL_FUND_TRAN_DTL>();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl = new PT_IL_FUND_TRAN_DTL();
				pt_il_fund_tran_dtl.setFTD_FUND_CODE(resultSet.getString(1));
				pt_il_fund_tran_dtl.setUI_M_PFTD_FUND_DESC(resultSet
						.getString(2));

				codeList.add(pt_il_fund_tran_dtl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
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

	/**
	 * This method returns fundList values for PT_IL_FUND_TRAN_DTL_1 bean
	 * 
	 * @return
	 */
	public List getFundValues() {
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		Long polSysId = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_SYS_ID();
		Long hdrSysId = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
		.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_SYS_ID();
	
		/*Long ftdSysId = compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN().getPT_IL_FUND_TRAN_DTL_1_BEAN()
		.getFTD_*/
		PT_IL_FUND_TRAN_DTL_1_ACTION existingDtls=compAction.getPT_IL_FUND_TRAN_DTL_1_ACTION_BEAN();
		System.out.println("hdr Sys Id :" + hdrSysId);
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String query2=null;
		List<PT_IL_FUND_TRAN_DTL_1> fundList = new ArrayList<PT_IL_FUND_TRAN_DTL_1>();
		try {
			 /*query2 =" SELECT PC.ROWID AS MROWID,PC.* FROM PT_IL_FUND_TRAN_DTL PC " +
		       " WHERE PC.FTD_TRAN_SYS_ID = '"+hdrSysId+"'"+
		       " AND PC.FTD_TRAN_TYPE = 'H' " +
             " AND PC.FTD_SELECT_YN IS NOT NULL ";*/
			 
			 
			 query2 ="SELECT ROWID, PT_IL_FUND_TRAN_DTL.* FROM  PT_IL_FUND_TRAN_DTL " +   
                      " WHERE FTD_TRAN_SYS_ID = '"+hdrSysId+"' " +
                      " AND  FTD_TRAN_TYPE = 'H' AND FTD_POL_SYS_ID  = '" +polSysId+"' " +
                      " AND FTD_SELECT_YN IS NOT NULL ";
			 
			 
			resultSet = handler.executeSelectStatement(query2, CommonUtils.getConnection());
			while (resultSet.next()) {

				PT_IL_FUND_TRAN_DTL_1 pt_il_fund_tran_dtl = new PT_IL_FUND_TRAN_DTL_1();

				pt_il_fund_tran_dtl.setROWID(resultSet.getString("ROWID"));
				pt_il_fund_tran_dtl.setFTD_FUND_CODE_1(resultSet
						.getString("FTD_FUND_CODE"));
				pt_il_fund_tran_dtl.setFTD_UNIT_TYPE_1(resultSet
						.getString("FTD_UNIT_TYPE"));
				pt_il_fund_tran_dtl.setFTD_SELECT_YN(resultSet
						.getString("FTD_SELECT_YN"));
				
				
				/*pt_il_fund_tran_dtl.setFTD_NO_OF_UNITS_1(CommonUtils.ROUND(resultSet
						.getDouble("FTD_NO_OF_UNITS"),2));
				pt_il_fund_tran_dtl.setFTD_UNIT_SEL_PRICE_1(CommonUtils.ROUND(resultSet
						.getDouble("FTD_UNIT_SEL_PRICE"),2));
				pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT_1(CommonUtils.ROUND(resultSet
						.getDouble("FTD_UNIT_LC_AMT"),2));*/
				
				pt_il_fund_tran_dtl.setFTD_NO_OF_UNITS_1(resultSet
						.getDouble("FTD_NO_OF_UNITS"));
				/*pt_il_fund_tran_dtl.setFTD_UNIT_SEL_PRICE_1(resultSet
						.getDouble("FTD_UNIT_SEL_PRICE"));
				pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT_1(resultSet
						.getDouble("FTD_UNIT_LC_AMT"));*/
				postQuery(pt_il_fund_tran_dtl);				
				
				pt_il_fund_tran_dtl.setFTD_NO_ALLOC_LC_AMT_1(resultSet.getDouble("FTD_NO_ALLOC_LC_AMT"));
				pt_il_fund_tran_dtl.setFTD_NO_SEL_UNITS_1(resultSet.getDouble("FTD_NO_SEL_UNITS"));
				pt_il_fund_tran_dtl.setFTD_TRAN_TYPE(resultSet.getString("FTD_TRAN_TYPE"));
				pt_il_fund_tran_dtl.setFTD_BEF_SWT_PERC(resultSet.getDouble("FTD_BEF_SWT_PERC"));
				pt_il_fund_tran_dtl.setFTD_TRAN_FLAG(resultSet.getString("FTD_TRAN_FLAG"));
				pt_il_fund_tran_dtl.setFTD_FUND_PERC(resultSet.getDouble("FTD_FUND_PERC"));
				
				pt_il_fund_tran_dtl.setFTD_SWITCH_BASED_ON(resultSet.getString("FTD_SWITCH_BASED_ON"));
				
				if("P".equalsIgnoreCase(pt_il_fund_tran_dtl.getFTD_UNIT_TYPE_1()))
				{
					pt_il_fund_tran_dtl.setUI_M_SUM_ALLOC_LC_VALUE_P(resultSet.getDouble("FTD_NO_ALLOC_LC_AMT"));
					pt_il_fund_tran_dtl.setUI_M_SUM_ALLOC_LC_VALUE_T(0.0);
				}
				else
				{
					pt_il_fund_tran_dtl.setUI_M_SUM_ALLOC_LC_VALUE_T(resultSet.getDouble("FTD_NO_ALLOC_LC_AMT"));
					pt_il_fund_tran_dtl.setUI_M_SUM_ALLOC_LC_VALUE_P(0.0);
				}	
				
				pt_il_fund_tran_dtl.setUI_M_SUM_ALLOC_LC_VALUE(resultSet.getDouble("FTD_NO_ALLOC_LC_AMT"));
				
				
				
				
				pt_il_fund_tran_dtl.setRowSelected(false);
				PT_IL_FUND_TRAN_DTL_HELPER helper = new PT_IL_FUND_TRAN_DTL_HELPER();
				pt_il_fund_tran_dtl.setUI_M_FUND_DESC_1(helper
						.getFundDescription(pt_il_fund_tran_dtl));
				fundList.add(pt_il_fund_tran_dtl);
		
			}
			existingDtls.setDataTableList1(fundList);
			if(fundList.size()>0)
			{
				existingDtls.setPT_IL_FUND_TRAN_DTL_1_BEAN(fundList.get(0));
				existingDtls.getPT_IL_FUND_TRAN_DTL_1_BEAN().setRowSelected(true);
				
			}
			else
			{
				existingDtls.setPT_IL_FUND_TRAN_DTL_1_BEAN(new PT_IL_FUND_TRAN_DTL_1());
				
			}
			existingDtls.resetAllComponent();

		} catch (Exception exception) {
			exception.printStackTrace();

		}
		System.out.println("lIST SIZE IS :" + fundList.size());
		return fundList;
	}
	public List getNewAllo(){
		PILP042_APAC_COMPOSITE_ACTION compAction=(PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
		                                            .getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
       Long polSysId=compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN().
                       getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_SYS_ID();	
        PT_IL_FUND_TRAN_DTL_ACTION newallocation=compAction.getPT_IL_FUND_TRAN_DTL_ACTION();
        List<PT_IL_FUND_TRAN_DTL> alloList=new ArrayList<PT_IL_FUND_TRAN_DTL>();
        //System.out.println("FTD SYS ID is:"+SysId);
        Long hdrSysId = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
		.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_SYS_ID();
        Connection connection=null;
        ResultSet resultSet=null;
        CRUDHandler handler=new CRUDHandler();
        PT_IL_FUND_TRAN_DTL_HELPER helper = new PT_IL_FUND_TRAN_DTL_HELPER();
        String SelectQuery="SELECT ROWID,PT_IL_FUND_TRAN_DTL.* FROM PT_IL_FUND_TRAN_DTL " +
					        		" WHERE  FTD_POL_SYS_ID  = '" +polSysId+"'"+
					        		//"AND FTD_SELECT_YN  IS NULL ORDER BY FTD_FUND_CODE";
        								" AND FTD_SELECT_YN  IS NULL " +
        								" AND FTD_TRAN_SYS_ID = '"+hdrSysId+"' " +
        								" ORDER BY FTD_FUND_CODE ";
        PT_IL_FUND_TRAN_DTL pt_il_fund_tran_dtl=null;
        try{
           	connection=CommonUtils.getConnection();
        	resultSet=handler.executeSelectStatement(SelectQuery, connection);
        	while(resultSet.next()){
        		pt_il_fund_tran_dtl=new PT_IL_FUND_TRAN_DTL();
        		pt_il_fund_tran_dtl.setROWID(resultSet.getString("ROWID"));
        		pt_il_fund_tran_dtl.setFTD_FUND_CODE(resultSet.getString("FTD_FUND_CODE"));
        		pt_il_fund_tran_dtl.setFTD_TRAN_SYS_ID(resultSet.getLong("FTD_TRAN_SYS_ID"));
        		pt_il_fund_tran_dtl.setFTD_SYS_ID(resultSet.getLong("FTD_SYS_ID"));
        	//	pt_il_fund_tran_dtl.setUI_M_PFTD_FUND_DESC(resultSet.getString("UI_M_PFTD_FUND_DESC"));
        		pt_il_fund_tran_dtl.setFTD_UNIT_TYPE(resultSet.getString("FTD_UNIT_TYPE"));
        		pt_il_fund_tran_dtl.setFTD_FUND_PERC(resultSet.getDouble("FTD_FUND_PERC"));
        		/*pt_il_fund_tran_dtl.setFTD_UNIT_PUR_PRICE(CommonUtils.ROUND(resultSet.getDouble("FTD_UNIT_PUR_PRICE"),2));*/
        		pt_il_fund_tran_dtl.setFTD_NO_OF_UNITS(CommonUtils.ROUND(resultSet.getDouble("FTD_NO_OF_UNITS"),2));
        		
        		pt_il_fund_tran_dtl.setFTD_UNIT_PUR_PRICE(resultSet.getDouble("FTD_UNIT_PUR_PRICE"));
        		pt_il_fund_tran_dtl.setFTD_UNIT_SEL_PRICE(resultSet.getDouble("FTD_UNIT_SEL_PRICE"));
        		
        		/*pt_il_fund_tran_dtl.setFTD_UNIT_SEL_PRICE(CommonUtils.ROUND(resultSet.getDouble("FTD_UNIT_SEL_PRICE"),2));*/
        		
        		pt_il_fund_tran_dtl.setFTD_UNIT_LC_AMT(CommonUtils.ROUND(resultSet.getDouble("FTD_UNIT_LC_AMT"),2));
        		
        		pt_il_fund_tran_dtl.setRowSelected(false);
        		helper.postQuey(compAction);
						
        		alloList.add(pt_il_fund_tran_dtl);        		
        	}
        	newallocation.setDataTableList(alloList);
        	if(alloList.size()>0)
        	{
        		newallocation.setPT_IL_FUND_TRAN_DTL_BEAN(alloList.get(0));
        		newallocation.getPT_IL_FUND_TRAN_DTL_BEAN().setRowSelected(true);
        	}
        }
        catch(Exception e){
      
        }
        System.out.println("new Allocation list Size "+alloList.size());
        return alloList;
        
	}

	public List getStatusDetails() {
		PILP042_APAC_COMPOSITE_ACTION compAction = (PILP042_APAC_COMPOSITE_ACTION) new CommonUtils()
				.getMappedBeanFromSession("PILP042_APAC_COMPOSITE_ACTION");
		Long FTH_SYS_ID = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_SYS_ID();

		Long FTH_POL_SYS_ID = compAction.getPT_IL_FUND_TRAN_HDR_ACTION_BEAN()
				.getPT_IL_FUND_TRAN_HDR_BEAN().getFTH_POL_SYS_ID();
		PT_IL_TRAN_STATUS_ACTION statusAction=compAction.getPT_IL_TRAN_STATUS_ACTION();
		List<PT_IL_TRAN_STATUS> statusList = new ArrayList<PT_IL_TRAN_STATUS>();
		Connection connection = null;
		PT_IL_TRAN_STATUS pt_il_tran_status=null;
		ResultSet resultSet = null;
		CRUDHandler handler = new CRUDHandler();
		String selectQuery = " SELECT PC.ROWID AS MROWID,PC.* FROM PT_IL_TRAN_STATUS PC "
		                     + " WHERE PC.TS_POL_SYS_ID='"+ FTH_POL_SYS_ID+ "'" + " AND TS_TRAN_SYS_ID ='  "+FTH_SYS_ID +"'" +
		                     " ORDER BY TS_STATUS_DT DESC ";	
			
			
			
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(selectQuery, connection);
			while (resultSet.next()) {

				 pt_il_tran_status = new PT_IL_TRAN_STATUS();
				PT_IL_FUND_TRAN_DTL_HELPER helper = new PT_IL_FUND_TRAN_DTL_HELPER();
				pt_il_tran_status.setTS_STATUS_DT(resultSet
						.getDate("TS_STATUS_DT"));
				pt_il_tran_status.setTS_STATUS_CODE(resultSet
						.getString("TS_STATUS_CODE"));
				pt_il_tran_status.setUI_M_STATUS_CODE_DESC(helper.getStatusDescription(pt_il_tran_status));
				pt_il_tran_status.setTS_REASON_CODE(resultSet
						.getString("TS_REASON_CODE"));
			    pt_il_tran_status.setUI_M_REASON_CODE_DESC(helper.getReasonDescription(pt_il_tran_status));
				pt_il_tran_status.setTS_REMARKS(resultSet
						.getString("TS_REMARKS"));
				pt_il_tran_status.setTS_STATUS_UID(resultSet.getString("TS_STATUS_UID"));
				pt_il_tran_status.setROWID(resultSet.getString("MROWID"));
				pt_il_tran_status.setRowSelected(false);
				statusList.add(pt_il_tran_status);
			}
			statusAction.setDataTableList(statusList);
			if(statusList.size()>0){
				statusAction.setPT_IL_TRAN_STATUS_BEAN(statusList.get(0));
				statusAction.getPT_IL_TRAN_STATUS_BEAN().setRowSelected(true);
			}else{
				statusAction.setPT_IL_TRAN_STATUS_BEAN(new PT_IL_TRAN_STATUS());
			}
           
        	statusAction.resetAllComponent();
		} catch (Exception exception) {

		}
		System.out.println("status List size is :" + statusList.size());
		return statusList;
	}

	public List getStatusCode(String code, List CodeList) {
		String query;
		/*Modified by pidugu raj dt: 22-11-2018 for status code lov not showing in switching
		 *  if ("*".equalsIgnoreCase(code)) {*/
		if ("".equalsIgnoreCase(code)) {
		/*End Modified by pidugu raj dt: 22-11-2018 for status code lov not showing in switching*/

			query = "SELECT PS_CODE,PS_CODE_DESC " + "FROM PP_SYSTEM"
					+ " WHERE PS_TYPE='IL_TRAN_STAT' AND PS_VALUE = '1'"
					+ " ORDER BY 1ASC";

			CodeList = statusCodeListLov(query);
		} /*
			 * else {
			 * 
			 * query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES " + "WHERE
			 * PC_TYPE = 'IL_MED_EXM' " + "AND NVL(PC_FRZ_FLAG,'N') = 'N'" +
			 * "AND UPPER(PC_CODE) LIKE '" + code.toUpperCase() + "%'" + "ORDER
			 * BY 1ASC";
			 * 
			 * 
			 * 
			 * CodeList = statusCodeListLov(query); }
			 */

		return CodeList;
	}

	public String getStatusCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PT_IL_TRAN_STATUS pt_il_tran_status = (PT_IL_TRAN_STATUS) iterator
					.next();
			if (Code.equalsIgnoreCase(pt_il_tran_status
					.getUI_M_WD_STATUS_CODE())) {
				codedesc = pt_il_tran_status.getUI_M_WD_STATUS_CODE_DESC();
			}
		}
		return codedesc;
	}

	public List<PT_IL_TRAN_STATUS> statusCodeListLov(String query) {
		List<PT_IL_TRAN_STATUS> codeList = new ArrayList<PT_IL_TRAN_STATUS>();
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_TRAN_STATUS pt_il_tran_status = new PT_IL_TRAN_STATUS();
				pt_il_tran_status
						.setUI_M_WD_STATUS_CODE(resultSet.getString(1));
				pt_il_tran_status.setUI_M_WD_STATUS_CODE_DESC(resultSet
						.getString(2));

				codeList.add(pt_il_tran_status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}

	public List getReasonCode(String code, List CodeList) {
		String query;
		/*Modified by pidugu raj dt: 22-11-2018 for reason code lov not showing in switching
		 *  if ("*".equalsIgnoreCase(code)) {*/
		if ("".equalsIgnoreCase(code)) {
		/*End Modified by pidugu raj dt: 22-11-2018 for reason code lov not showing in switching*/

			query = "SELECT PC_CODE,PC_DESC" + " FROM PM_CODES"
					+ " WHERE PC_TYPE = 'IL_REASON' "
					+ " AND NVL(PC_FRZ_FLAG,'N') = 'N'" + " ORDER BY 1ASC";

			CodeList = reasonCodeListLov(query);
		} /*
			 * else {
			 * 
			 * query = "SELECT PC_CODE,PC_DESC " + "FROM PM_CODES " + "WHERE
			 * PC_TYPE = 'IL_MED_EXM' " + "AND NVL(PC_FRZ_FLAG,'N') = 'N'" +
			 * "AND UPPER(PC_CODE) LIKE '" + code.toUpperCase() + "%'" + "ORDER
			 * BY 1ASC";
			 * 
			 * 
			 * 
			 * CodeList = statusCodeListLov(query); }
			 */

		return CodeList;
	}

	public String getReasonCodeDesc(String Code, List codeList) {
		Iterator iterator = codeList.iterator();
		String codedesc = null;
		while (iterator.hasNext()) {
			PT_IL_TRAN_STATUS pt_il_tran_status = (PT_IL_TRAN_STATUS) iterator
					.next();
			if (Code.equalsIgnoreCase(pt_il_tran_status
					.getUI_M_WD_REASON_CODE())) {
				codedesc = pt_il_tran_status.getUI_M_WD_REASON_CODE_DESC();
			}
		}
		return codedesc;
	}

	public List<PT_IL_TRAN_STATUS> reasonCodeListLov(String query) {
		List<PT_IL_TRAN_STATUS> codeList = new ArrayList<PT_IL_TRAN_STATUS>();
		CommonUtils commonUtils = new CommonUtils();
		ResultSet resultSet = null;

		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {

				PT_IL_TRAN_STATUS pt_il_tran_status = new PT_IL_TRAN_STATUS();
				pt_il_tran_status
						.setUI_M_WD_REASON_CODE(resultSet.getString(1));
				pt_il_tran_status.setUI_M_WD_REASON_CODE_DESC(resultSet
						.getString(2));

				codeList.add(pt_il_tran_status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("LIST SIZE*********" + codeList.size());
		return codeList;
	}


public void  postQuery(PT_IL_FUND_TRAN_DTL_1 PT_IL_FUND_TRAN_DTL_1_BEAN) throws Exception {
	    
	    Double M_PT_IL_FUND_TRAN_DTL=null;
	    Double M_PT_IL_FUND_TOTAL_VALUE=null;
	    String CURSOR_C1 ="   SELECT FS_DESC   FROM   PM_IL_FUND_SETUP" +
	    		"   WHERE  FS_CODE = ? ";
	   
	    String function_GetUnitPrice = " SELECT P9ILPK_FUND_ALLOC.P_GET_UNIT_PRICE_1(?,?,?,?)  FROM DUAL  ";
	    CRUDHandler handler = new CRUDHandler();
	    ResultSet resultSet_C1 = null,resultSet_Func=null;
	    Connection connection = null;
	    P9ILPK_FUND_ALLOC p9ilpk_fund_alloc = new P9ILPK_FUND_ALLOC();
		ArrayList<OracleParameter> list = new ArrayList<OracleParameter>();
		 try { 
		     connection = CommonUtils.getConnection();
		     resultSet_C1 = handler.executeSelectStatement(CURSOR_C1,
				    connection, new Object[]{ PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_FUND_CODE_1() } );
			    while (resultSet_C1.next()) {
			    	PT_IL_FUND_TRAN_DTL_1_BEAN.setUI_M_FUND_DESC_1(resultSet_C1.getString(1));
			    } 
			    
			    resultSet_Func = handler.executeSelectStatement(function_GetUnitPrice,
				    connection, new Object[]{  PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_FUND_CODE_1(), 
				    new CommonUtils().getCurrentDate(),"N","N" } );
			    while (resultSet_Func.next()) {
			    	PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_UNIT_SEL_PRICE_1(resultSet_Func.getDouble(1));
			    } 
			 
			 M_PT_IL_FUND_TRAN_DTL = PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_UNIT_SEL_PRICE_1() *
			 CommonUtils.nvl(PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_NO_OF_UNITS_1(),0);
			  
			 list.clear();
			 list = p9ilpk_fund_alloc.P_VAL_FUND_ROUND(CommonUtils.getGlobalVariable("GLOBAL.M_BASE_CURR"), 
					 CommonUtils.getProcedureValue(M_PT_IL_FUND_TRAN_DTL), PT_IL_FUND_TRAN_DTL_1_BEAN.getFTD_FUND_CODE_1(), "R",
						CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),
						CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"));
			 System.out.println("check unit value after P_VAL_FUND_ROUND ::" + list.get(0).getValue());
			 PT_IL_FUND_TRAN_DTL_1_BEAN.setFTD_UNIT_LC_AMT_1(Double.parseDouble(list.get(0).getValue()));
		
	    } catch (Exception e) {
		// TODO: handle exception
	    	e.printStackTrace();
		    throw new Exception(e.getMessage());
	    }
	    finally{
		try {
		    CommonUtils.closeCursor(resultSet_C1);
		    CommonUtils.closeCursor(resultSet_Func);
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}

}
