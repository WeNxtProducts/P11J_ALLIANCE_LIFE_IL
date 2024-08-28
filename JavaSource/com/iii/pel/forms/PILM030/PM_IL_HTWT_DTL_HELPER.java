package com.iii.pel.forms.PILM030;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PM_IL_HTWT_DTL_HELPER {

	

	public void preInsertTrigger(PM_IL_HTWT_DTL_ACTION pm_il_htwt_dtl_action) {
		PM_IL_HTWT_DTL pm_il_htwt_dtl = pm_il_htwt_dtl_action
				.getDataTableList().get(
						pm_il_htwt_dtl_action.getDataTable().getRowIndex());
		pm_il_htwt_dtl.setHTWT_CR_DT(new Date());
		pm_il_htwt_dtl.setHTWT_CR_UID("PEL_LIFE");// USE OF CONTROL BLOCK
		// INSTEAD OF HARD CODED
		// VALUE
		// L_VALIDATE_HTWT_RANGE.L_VALIDATE_HTWT_RANGE();
	}

	public void preUpdateTrigger(PM_IL_HTWT_DTL_ACTION pm_il_htwt_dtl_action)
			throws Exception {
		PM_IL_HTWT_DTL pm_il_htwt_dtl = pm_il_htwt_dtl_action
				.getDataTableList().get(
						pm_il_htwt_dtl_action.getDataTable().getRowIndex());
		System.out.println("Inside preupdate current row index is"
				+ pm_il_htwt_dtl_action.getDataTable().getRowIndex());
		pm_il_htwt_dtl.setHTWT_UPD_DT(new Date());
		pm_il_htwt_dtl.setHTWT_UPD_UID("PEL_LIFE");// USE OF CONTROL BLOCK
		// INSTEAD OF HARD CODED
		// VALUE
		// L_VALIDATE_HTWT_RANGE.L_VALIDATE_HTWT_RANGE();
	}

// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
    //method  EFF_FM_DT_WHEN_VALIDATE_ITEM modified
	public void EFF_FM_DT_WHEN_VALIDATE_ITEM(Date fromdate,Date toDate) {

		//Date fromdate = (Date)fromDate;//valueBean.getHTWT_EFF_FM_DT();
		//Date toDate = valueBean.getHTWT_EFF_TO_DT();
		//Date toDate = this.getC
		
		if (fromdate != null && toDate != null) {
			if (fromdate.after(toDate)) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91010"));
			}
		}
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
    //method  EFF_TO_DT_WHEN_VALIDATE_ITEM modified
	public void EFF_TO_DT_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL valueBean) {

		Date fromdate = valueBean.getHTWT_EFF_FM_DT();
		Date toDate = valueBean.getHTWT_EFF_TO_DT();
		
		if (fromdate != null && toDate != null) {
			if (fromdate.after(toDate)) {

				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91001"));
			}
		}
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
    //method HEIGHT_FROM_WHEN_VALIDATE_ITEM modified
	public void HEIGHT_FROM_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL valueBean)
			throws ValidatorException, Exception {

		Double heightFrom = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_FM(), 0);
		Double heightTo = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_TO(), 0);
		
		if (heightFrom < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "90007", new Object[]{"From Height"}));

		} else if (heightFrom > heightTo) {

			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "91024"));
		}

	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
    //method HEIGHT_TO_WHEN_VALIDATE_ITEM modified
	public void HEIGHT_TO_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL valueBean)
			throws ValidatorException, Exception {

		Double heightFrom = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_FM(), 0);
		Double heightTo = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_TO(), 0);
		
		if (heightTo < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "90007", new Object[]{"From Height"}));

		} else if (heightTo < heightFrom) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "90008", new Object[]{"To Height", "From Height"}));
		}
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

 // [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
    //method WEIGHT_FROM_WHEN_VALIDATE_ITEM modified
	public void WEIGHT_FROM_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL valueBean) {

		Double weightFrom = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_FM(), 0);
		Double weightTo = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_FM(), 0);
		
		if (weightFrom < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "90007"));
		
		} else if (weightFrom > weightTo) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "91024"));
		} 
	}
	//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

// [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
    //method WEIGHT_TO_WHEN_VALIDATE_ITEM modified
	public void WEIGHT_TO_WHEN_VALIDATE_ITEM(PM_IL_HTWT_DTL valueBean) {

		Double weightFrom = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_FM(), 0);
		Double weightTo = MigratingFunctions.nvl(valueBean.getHTWT_HEIGHT_FM(), 0);
		
		if (weightTo < 0) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "90007"));
		
		} else if (weightTo < weightFrom) {
			throw new ValidatorException(Messages.getMessage(
					"com.iii.premia.common.errorUtil.PELErrorMessages", "90008"));
		}
	}
//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

 // [ BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 
    //method L_VALIDATE_HTWT_RANGE declaratuion changed
	public void L_VALIDATE_HTWT_RANGE(PM_IL_HTWT_DTL pm_il_htwt_dtl)
			throws Exception {
//  BugId:PREMIAGDC-0013 Ashutosh Sharma 03-feb-09 ]

		CRUDHandler handler = new CRUDHandler();
		String M_DUMMY = null;
		double htFrom, htTo;
		htFrom = pm_il_htwt_dtl.getHTWT_HEIGHT_FM();
		htTo = pm_il_htwt_dtl.getHTWT_HEIGHT_TO();
		Date dateFrom = pm_il_htwt_dtl.getHTWT_EFF_FM_DT();
		Date dateTo = pm_il_htwt_dtl.getHTWT_EFF_TO_DT();
		String rowId = pm_il_htwt_dtl.getROWID();
		Object value1[] = { htFrom, htTo, htFrom, htTo, htFrom, htTo, dateFrom,
				dateTo, dateFrom, dateTo, dateFrom, dateTo };
		Object value2[] = { htFrom, htTo, htFrom, htTo, htFrom, htTo, dateFrom,
				dateTo, dateFrom, dateTo, dateFrom, dateTo, rowId };

		Connection connection = null;
		ResultSet resultSet1 = null;
		ResultSet resultSet2 = null;
		CommonUtils commonUtils = new CommonUtils();
		
		try{
		connection = commonUtils.getConnection();
		String query = PM_IL_HTWT_DTL_CONSTANTS.htwtRangeQuery;
		
		if (pm_il_htwt_dtl.getROWID() != null
				&& !"".equals(pm_il_htwt_dtl.getROWID().trim())) {
			
			query += PM_IL_HTWT_DTL_CONSTANTS.htwtRangeQueryCompletionUpdate;
			resultSet2 = handler.executeSelectStatement(query, connection,
					value2);

			if (resultSet2.next()) {
				M_DUMMY = resultSet2.getString(1);
			}

			if (M_DUMMY != null) {
				if (resultSet2.next() || M_DUMMY.equals("" + "X")) {

					throw new ValidatorException(Messages.getMessage("",
							"91011"));

				}
			}

		} else {

			resultSet1 = handler.executeSelectStatement(query, connection,
					value1);

			if (resultSet1.next()) {
				M_DUMMY = resultSet1.getString(1);
			}
			if (M_DUMMY != null) {
				if (resultSet1.next() || M_DUMMY.equals("" + "X")) {

					throw new ValidatorException(Messages.getMessage("",
							"91011"));

				}
			}
		}
		}catch(Exception exception)
		{
			exception.printStackTrace();
		}
		finally{
			try {
				new CommonUtils().closeCursor(resultSet1);
				new CommonUtils().closeCursor(resultSet2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public void L_VALIDATE_HTWT_RANGE(PM_IL_HTWT_DTL pm_il_htwt_dtl,
			PM_IL_HTWT_DTL_ACTION pm_il_htwt_dtl_action, double heightFrom,
			double heightTo, Date fromdate, Date toDate) throws SQLException,
			Exception {
		CommonUtils commonUtils = new CommonUtils();
		Connection connection = commonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PM_IL_HTWT_DTL pm_il_htwt_dtl1 = new PM_IL_HTWT_DTL();

		String M_DUMMY = null;
		String sql_C1 = "SELECT 'X' "
				+ "FROM  PM_IL_HTWT_DTL  "
				+ "WHERE  (HTWT_HEIGHT_FM  BETWEEN ?  AND  ?  "
				+ "OR HTWT_HEIGHT_TO  BETWEEN ?  AND  ?  OR ?  BETWEEN HTWT_HEIGHT_FM  AND  HTWT_HEIGHT_TO  OR ?  "
				+ "BETWEEN HTWT_HEIGHT_FM  AND  HTWT_HEIGHT_TO)  "
				+ "AND ((NVL(HTWT_EFF_FM_DT, '01-JAN-1900')  "
				+ "BETWEEN NVL(?, '01-JAN-1900')  "
				+ "AND  NVL(?, '31-DEC-2999'))  OR (NVL(HTWT_EFF_TO_DT, '31-DEC-2999') "
				+ " BETWEEN NVL(?, '01-JAN-1900')  "
				+ "AND  NVL(?, '31-DEC-2999'))  OR (NVL(?, '01-JAN-1900')  "
				+ "BETWEEN NVL(HTWT_EFF_FM_DT, '01-JAN-1900')  AND  NVL(HTWT_EFF_TO_DT, '31-DEC-2999'))  "
				+ "OR (NVL(?, '31-DEC-2999')  BETWEEN NVL(HTWT_EFF_FM_DT, '01-JAN-1900')  AND  NVL(HTWT_EFF_TO_DT, '31-DEC-2999'))) ";

		ResultSet resultSet1 = null;

		String sql_C2 = "SELECT 'X' FROM  PM_IL_HTWT_DTL "
				+ "WHERE  (HTWT_HEIGHT_FM  BETWEEN ? "
				+ "AND  ?  OR HTWT_HEIGHT_TO  BETWEEN ? "
				+ "AND  ?  OR ?  BETWEEN HTWT_HEIGHT_FM "
				+ "AND HTWT_HEIGHT_TO  OR ?  BETWEEN HTWT_HEIGHT_FM "
				+ "AND  HTWT_HEIGHT_TO)  AND ((NVL(HTWT_EFF_FM_DT, '01-JAN-1900') "
				+ "BETWEEN NVL(?, '01-JAN-1900')  AND  NVL(?, '31-DEC-2999')) "
				+ "OR (NVL(HTWT_EFF_TO_DT, '31-DEC-2999')"
				+ "BETWEEN NVL(?, '01-JAN-1900')  AND  NVL(?, '31-DEC-2999'))"
				+ "OR (NVL(?, '01-JAN-1900')  BETWEEN NVL(HTWT_EFF_FM_DT, '01-JAN-1900') "
				+ "AND  NVL(HTWT_EFF_TO_DT, '31-DEC-2999'))  OR (NVL(?, '31-DEC-2999')"
				+ "BETWEEN NVL(HTWT_EFF_FM_DT, '01-JAN-1900')  AND  NVL(HTWT_EFF_TO_DT, '31-DEC-2999'))) "
				+ "AND ROWID  != ?";
		ResultSet resultSet2 = null;

		/*
		 * if (pm_il_htwt_dtl_action.isINSERT_ALLOWED()) INSERTION {
		 */

		if (pm_il_htwt_dtl1.getROWID() == null) {
			Object[] objects = { heightFrom, heightTo, heightFrom, heightTo,
					heightFrom, heightTo, fromdate, toDate, fromdate, toDate,
					fromdate, toDate, };
			resultSet1 = handler.executeSelectStatement(sql_C1, connection,
					objects);
			System.out.println("Object:-" + objects.length);
			if (resultSet1.next()) {
				M_DUMMY = resultSet1.getString(1);
			}
			if (resultSet1.next() || M_DUMMY.equals("" + "X")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91011"));

			}
			new CommonUtils().closeCursor(resultSet1);
//			resultSet1.close();
		} else if (pm_il_htwt_dtl1.getROWID() != null)

		{

			Object[] objects2 = { heightFrom, heightTo, heightFrom, heightTo,
					heightFrom, heightTo, fromdate, toDate, fromdate, toDate,
					fromdate, toDate, pm_il_htwt_dtl1.getROWID() };
			resultSet2 = handler.executeSelectStatement(sql_C2, connection,
					objects2);
			if (resultSet2.next()) {
				M_DUMMY = resultSet2.getString(1);
			}
			if (resultSet2.next() || M_DUMMY.equals("" + "X")) {
				throw new ValidatorException(Messages.getMessage(
						"com.iii.premia.common.errorUtil.PELErrorMessages", "91011"));

			}
			new CommonUtils().closeCursor(resultSet2);
//			resultSet2.close();
		}

	}
	
	public void executeQuery(PM_IL_HTWT_DTL_ACTION action){
		List resultList = null;
		ArrayList<PM_IL_HTWT_DTL> dataTableList = new ArrayList<PM_IL_HTWT_DTL>();
		PM_IL_HTWT_DTL_DELEGATE pm_il_htwt_dtl_delegate = new PM_IL_HTWT_DTL_DELEGATE();
		try {
			resultList = pm_il_htwt_dtl_delegate.getValues();
			if(resultList!=null){
				for (int index = 0; index < resultList.size(); index++) {
					PM_IL_HTWT_DTL gridValueBean = (PM_IL_HTWT_DTL) resultList
							.get(index);
					dataTableList.add(gridValueBean);
				}
				for(int i=0;i<dataTableList.size();i++){
					PM_IL_HTWT_DTL pm_il_htwt_dtl = (PM_IL_HTWT_DTL)dataTableList.get(i);
					if(i==0){
						pm_il_htwt_dtl.setRowSelected(true);
						action.setPM_IL_HTWT_DTL(pm_il_htwt_dtl);
					}else{
						pm_il_htwt_dtl.setRowSelected(false);
					}
				}
		/*			if(dataTableList!=null && dataTableList.size()>0){
					PM_IL_HTWT_DTL = dataTableList.get(0);
					PM_IL_HTWT_DTL.setRowSelected(true);
				}*/
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		action.setDataTableList(dataTableList);
		//return dataTableList;
	}
	
}
