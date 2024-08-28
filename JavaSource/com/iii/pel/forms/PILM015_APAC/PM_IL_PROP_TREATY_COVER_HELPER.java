package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PM_IL_PROP_TREATY_COVER_HELPER {

	public void stdTreatyWhenValidateItem(
			PM_IL_PROP_TREATY_COVER_ACTION pm_il_prop_treaty_cover_action,
			double stdTreatyLimit) throws Exception {
		Object value1[] = { "STANDARD TREATY LIMIT", ">=", "0" };
		Object value2[] = { "STANDARD TREATY LIMIT", "ENTERED", "!" };
		try{
			if (stdTreatyLimit < 0) {
				throw new Exception(Messages.getString(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "91014", value1));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void subStandardTreatyLimitWhenValidateItem(
			PM_IL_PROP_TREATY_COVER_ACTION pm_il_prop_treaty_cover_action,
			double subStdTreatyLimit) throws Exception {
		try{
			Object value1[] = { "SUB STANDARD TREATY LIMIT", ">=", "0" };
			Object value2[] = { "SUB STANDARD TREATY LIMIT", "ENTERED", "!" };
			if (subStdTreatyLimit < 0) {
				throw new Exception(Messages.getString(
						PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, "91014", value1));
			} 
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void stdMaxRetention(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, 
			PM_IL_PROP_TREATY_COVER_ACTION pm_il_prop_treaty_cover_action,
			double StdMaxRetn, double StdTreatyLimit) throws Exception {
		double M_PTC_STD_MAX_RETN = 1D;
		double sNo = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
				.getTempTreaty_TypeBean().getPTT_SRNO();
		PM_IL_PROP_TREATY_COVER PM_IL_PROP_TREATY_COVER_BEAN =  pm_il_prop_treaty_cover_action.getPM_IL_PROP_TREATY_COVER_BEAN();
		Double M_PTC_RETN_PERC= PM_IL_PROP_TREATY_COVER_BEAN.getPTC_RETN_PERC();
		Double M_STDMAX_RETN = null;
		try{
			if (StdMaxRetn > MigratingFunctions.nvl(StdTreatyLimit, 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91190"));
			}
			if (sNo == 1) {
				M_PTC_STD_MAX_RETN = (MigratingFunctions.nvl(StdTreatyLimit, 0) * StdMaxRetn) / 100;
				if (StdMaxRetn > M_PTC_STD_MAX_RETN) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80260"));
				} M_STDMAX_RETN= (MigratingFunctions.nvl(StdTreatyLimit, 0) * M_PTC_RETN_PERC) / 100;
					
				System.out.println("M_STDMAX_RETN   : "+M_STDMAX_RETN);
				System.out.println("StdMaxRetn      : "+StdMaxRetn);
				/*
				 * COMMENTED BY DHINESH ON 3.10.2016
				 * 
				 * if(M_STDMAX_RETN !=StdMaxRetn){
						throw new Exception("Retention Premium Should be :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_RETN_PERC()+" % of Standard Treaty Limit for Cover :"+PM_IL_PROP_TREATY_COVER_BEAN.getPTC_COVER_CODE());
					}*/
				
				}
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void subStandardMaxReten(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction,
			PM_IL_PROP_TREATY_COVER_ACTION pm_il_prop_treaty_cover_action,
			double subStdMaxRetn, double subStdTreatyLimit) throws Exception {
		double M_PTC_SSTD_MAX_RETN = 1D;
		double sNo = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
				.getTempTreaty_TypeBean().getPTT_SRNO();
		try{
			if (subStdMaxRetn > MigratingFunctions.nvl(subStdTreatyLimit, 0)) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91191"));
			}
	
			if (sNo == 1) {
				M_PTC_SSTD_MAX_RETN = (MigratingFunctions.nvl(subStdTreatyLimit, 0) * subStdMaxRetn) / 100;
				if (subStdTreatyLimit > M_PTC_SSTD_MAX_RETN) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80260"));
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void commPerc1stYearWhenValidate(
			PM_IL_PROP_TREATY_COVER_ACTION pm_il_prop_treaty_cover_action,
			double perc1stYear) throws Exception  {
		try{
			Object value1[] = { "COMMISSION PERCENTAGE", ">=0", "!" };
			if (perc1stYear < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014", value1));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void commPercSubYearsWhenValidate(
			PM_IL_PROP_TREATY_COVER_ACTION pm_il_prop_treaty_cover_action,
			double percSubYear) throws Exception  {
		try{
			Object value1[] = { "COMMISSION PERCENTAGE SUB YEARS", ">=0", "!" };
			if (percSubYear < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91014", value1));
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix
	public void coverCodeWhenValidateItem(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, String coverCode, PM_IL_PROP_TREATY_TYPE treatyTypeBean)
			throws Exception {
		double sNo = treatyTypeBean.getPTT_SRNO();
		Connection connection = CommonUtils.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PM_IL_PROP_TREATY treatyBean = compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN();
		String riderBasis = treatyBean.getPT_RIDER_RI_BASIS();
		ResultSet vembu_C1 = null;
		ResultSet vembu_C2 = null;
		ResultSet rs = null;
		try {
			String M_COVER_TYPE = null;
			String sql_C1 = "SELECT  COVER_DESC,COVER_TYPE "
					+ "FROM  PM_IL_COVER  " + "WHERE  COVER_CODE  = ? ";
			Object value[] = { coverCode };
			String sql_C2 = "SELECT 'X' " + "FROM  PM_IL_COVER  "
					+ "WHERE  COVER_TYPE  IN ( 'A'  )  "
					+ "AND COVER_CODE  = ? ";
			String checkDuplicate = "SELECT 'X' FROM PM_IL_PROP_TREATY_COVER "
					+ "WHERE PTC_COVER_CODE = ? " + "AND PTC_PTT_SYS_ID = ? ";
			String M_DUMMY = null;
			rs = handler.executeSelectStatement(checkDuplicate, connection , new Object[]{coverCode,compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION().getPM_IL_PROP_TREATY_TYPE_BEAN().getPTT_SYS_ID()});
			if(rs.next()){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71039"));
			}
			if (vembu_C2 != null) {
				vembu_C2.close();
			}
			vembu_C1 = handler
					.executeSelectStatement(sql_C1, connection, value);
			if (vembu_C1.next()) {
				/* CHANGED BY RAJA ON 19-08-2017 FRO ZBILQC-1735236 */
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setUI_M_COVER_DESC(vembu_C1.getString(1));
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_UI_M_COVER_DESC().resetValue();
				/*END*/
				M_COVER_TYPE = vembu_C1.getString(2);
			}
			if (M_COVER_TYPE==null) {
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setUI_M_COVER_DESC(null);
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71006"));
			} else if ("B".equalsIgnoreCase(M_COVER_TYPE)) {
				
				/*Modified by Janani on 31.01.2018 for ZBLIFE-1468859*/
				System.out.println("sNo       "+sNo);
				
				//if (sNo == 1)
				if (sNo == 1 && sNo == 2)
				{
					
				/*End of ZBLIFE-1468859*/ 
					
					compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_GROUP_COVER_YN_DIS(false);
				} else {
					compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_GROUP_COVER_YN_DIS(true);
				}
			} else {
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_GROUP_COVER_YN_DIS(true);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setPTC_CVR_GRP_CODE_DIS(true);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getPM_IL_PROP_TREATY_COVER_BEAN().setUI_M_COVER_DESC_DIS(true);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			CommonUtils.closeCursor(vembu_C1);
			CommonUtils.closeCursor(vembu_C2);
		}
	}

	/* Cover Triggers */

	/**
	 * post-query
	 */
	public void postQuery(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, PM_IL_PROP_TREATY_COVER treatyCoverValueBean)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = CommonUtils.getConnection();
		ResultSet vembu_C1 = null;
		ResultSet vembu_C2 = null;
		PM_IL_PROP_TREATY_COVER_ACTION treatyCoverAction = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION();
		String groupCode = treatyCoverValueBean.getPTC_CVR_GRP_CODE();
		try {
			if (treatyCoverValueBean.getPTC_COVER_CODE() != null) {
				String M_COVER_TYPE = null;
				String ptcCoverCode = treatyCoverValueBean.getPTC_COVER_CODE();
				String sql_C1 = "SELECT COVER_DESC " + "FROM  PM_IL_COVER "
						+ " WHERE  COVER_CODE  = '" + ptcCoverCode + "' ";
				String sql_C2 = "SELECT COVER_TYPE " + "FROM  PM_IL_COVER  "
						+ "WHERE  COVER_CODE  = '" + ptcCoverCode + "' ";
				double sno = treatyCoverAction.getTempTreaty_TypeBean().getPTT_SRNO();
				String groupYN = treatyCoverAction.getPM_IL_PROP_TREATY_COVER_BEAN()
						.getPTC_GROUP_COVER_YN();
				vembu_C1 = handler.executeSelectStatement(sql_C1, connection);
				if (vembu_C1.next()) {
					treatyCoverValueBean.setUI_M_COVER_DESC(vembu_C1
							.getString(1));
				}
				vembu_C1.close();
				DBProcedures procedures = new DBProcedures();
				ArrayList<String> subTariffDescList = procedures
						.helperP_VAL_CODES("IL_VAL_TAR", treatyCoverValueBean
								.getPTC_SUB_STD_TARIFF(), "N", "N", null);
				if (subTariffDescList != null && subTariffDescList.size() != 0) {
					treatyCoverValueBean
							.setUI_M_PTC_SUB_STD_TARIFF_DESC(subTariffDescList
									.get(0));
				}
				ArrayList<String> groupCodeDescList = procedures
						.helperP_VAL_CODES("IL_RI_GR_CVR", groupCode, "N", "N",
								null);
				if (groupCodeDescList != null && groupCodeDescList.size() != 0) {
					treatyCoverValueBean
							.setUI_M_PTC_CVR_GRP_CODE_DESC(groupCodeDescList
									.get(0));
				}
				if (sno != 1) {
					treatyCoverValueBean.setPTC_SUB_STD_TARIFF_DIS(true);
				} else if (sno == 1) {
					treatyCoverValueBean.setPTC_SUB_STD_TARIFF_DIS(false);
				}
				vembu_C2 = handler.executeSelectStatement(sql_C2, connection);
				if (vembu_C2.next()) {
					M_COVER_TYPE = vembu_C2.getString(1);
				}
				vembu_C2.close();
				if (("B".equals(M_COVER_TYPE) && sno == 1)) {
					treatyCoverValueBean.setPTC_GROUP_COVER_YN_DIS(false);
				} else {
					treatyCoverValueBean.setPTC_GROUP_COVER_YN_DIS(true);
				}
				if ("Y".equalsIgnoreCase(groupYN)) {
					treatyCoverValueBean.setPTC_CVR_GRP_CODE_DIS(false);
				} else {
					treatyCoverValueBean.setPTC_CVR_GRP_CODE_DIS(true);
				}
				if (groupCode != null) {
					compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(false);
				} else {
					compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(true);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * create -new record
	 * 
	 * @param compositeAction
	 */
	 //[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix
	public void createNewRecord(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction,
			PM_IL_PROP_TREATY_COVER treatyCoverBean) {
		//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix]
		if (compositeAction.getPM_IL_PROP_TREATY_ACTION()
				.getPM_IL_PROP_TREATY_BEAN().getPT_CQS_PERC() != null) {
			double cqsPerc = compositeAction.getPM_IL_PROP_TREATY_ACTION()
					.getPM_IL_PROP_TREATY_BEAN().getPT_CQS_PERC();
			if (cqsPerc != 0) {
				treatyCoverBean.setPTC_RETN_PERC(
								cqsPerc);
			}
		}
	}

	/**
	 * NEW-RECORD-INSTANCE
	 * 
	 * @param compositeAction
	 * @throws SQLException
	 * @throws Exception
	 */
	//[PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix
	public static void newRecordInstance(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction,
			PM_IL_PROP_TREATY_COVER treatyCoverBean)
			throws Exception {
		String groupYN = treatyCoverBean.getPTC_GROUP_COVER_YN();
		//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix]
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet vembu_C2 = null;
		connection = CommonUtils.getConnection();
		try {
			String M_COVER_TYPE = null;
			if (treatyCoverBean.getPTC_COVER_CODE() != null) {
				String ptcCoverCode = treatyCoverBean.getPTC_COVER_CODE();
				String sql_C2 = "SELECT COVER_TYPE " + "FROM  PM_IL_COVER  "
						+ "WHERE  COVER_CODE  = '" + ptcCoverCode + "' ";
				vembu_C2 = handler.executeSelectStatement(sql_C2, connection);
				if (vembu_C2.next()) {
					M_COVER_TYPE = vembu_C2.getString(1);
				}
				if (M_COVER_TYPE == "B") {
					double sno = compositeAction
							.getPM_IL_PROP_TREATY_TYPE_ACTION()
							.getPM_IL_PROP_TREATY_TYPE_BEAN().getPTT_SRNO();
					if (sno == 1) {
						treatyCoverBean.setPTC_GROUP_COVER_YN_DIS(false);
					} else {
						treatyCoverBean.setPTC_GROUP_COVER_YN("N");
						treatyCoverBean.setPTC_GROUP_COVER_YN_DIS(true);
					}
				} else {
					treatyCoverBean.setPTC_GROUP_COVER_YN("N");
					treatyCoverBean.setPTC_GROUP_COVER_YN_DIS(true);
				}
				if (treatyCoverBean.getPTC_GROUP_COVER_YN() == "Y") {
					treatyCoverBean.setPTC_GROUP_COVER_YN_DIS(true);
					if (treatyCoverBean.getPTC_CVR_GRP_CODE() != null) {
						compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(false);
					}
					else {
						compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(true);
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {
				CommonUtils.closeCursor(vembu_C2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//PREMIAGDC-TREATYMASTER-0054: CHARAN 25-Feb-09 Internal Fix]
	}
	
	public void getCoverDetailsList(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		double sysId = compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION()
		.getPM_IL_PROP_TREATY_TYPE_BEAN().getPTT_SYS_ID();
		String selectQuery = "SELECT P.*,PC.*,P.ROWID AS P_ROWID,PC.ROWID AS PC_ROWID	"
			+ "FROM PM_IL_PROP_TREATY_TYPE P,PM_IL_PROP_TREATY_COVER PC "
			+ "WHERE PC.PTC_PTT_SYS_ID=P.PTT_SYS_ID AND PC.PTC_PTT_SYS_ID = '"
			+ sysId + "' ";
		compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getDataTableList().clear();
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			resultSet = handler.executeSelectStatement(selectQuery, connection);
			while (resultSet.next()) {
				PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = new PM_IL_PROP_TREATY_COVER();
				pm_il_prop_treaty_cover.setPTC_SYS_ID(resultSet
						.getDouble("PTC_SYS_ID"));
				pm_il_prop_treaty_cover.setPTC_PTT_SYS_ID(resultSet
						.getDouble("PTC_PTT_SYS_ID"));
				pm_il_prop_treaty_cover.setPTC_COVER_CODE(resultSet
						.getString("PTC_COVER_CODE"));
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_1ST_YR(resultSet
						.getDouble("PTC_COMM_PERC_1ST_YR"));
				pm_il_prop_treaty_cover.setPTC_COMM_PERC_SUB_YRS(resultSet
						.getDouble("PTC_COMM_PERC_SUB_YRS"));
				pm_il_prop_treaty_cover.setPTC_UPD_DT(resultSet
						.getDate("PTC_UPD_DT"));
				pm_il_prop_treaty_cover.setPTC_UPD_UID(resultSet
						.getString("PTC_UPD_UID"));
				pm_il_prop_treaty_cover.setPTC_STD_TREATY_LIMIT(resultSet
						.getDouble("PTC_STD_TREATY_LIMIT"));
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TREATY_LIMIT(resultSet
						.getDouble("PTC_SUB_STD_TREATY_LIMIT"));
				pm_il_prop_treaty_cover.setPTC_RETN_PERC(resultSet
						.getDouble("PTC_RETN_PERC"));
				pm_il_prop_treaty_cover.setPTC_STD_MAX_RETN(resultSet
						.getDouble("PTC_STD_MAX_RETN"));
				pm_il_prop_treaty_cover.setPTC_SSTD_MAX_RETN(resultSet
						.getDouble("PTC_SSTD_MAX_RETN"));
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_1ST_YR(resultSet
						.getDouble("PTC_SSTD_COMM_PERC_1ST_YR"));
				pm_il_prop_treaty_cover.setPTC_SSTD_COMM_PERC_SUB_YRS(resultSet
						.getDouble("PTC_SSTD_COMM_PERC_SUB_YRS"));
				pm_il_prop_treaty_cover.setPTC_SUB_STD_TARIFF(resultSet
						.getString("PTC_SUB_STD_TARIFF"));
				pm_il_prop_treaty_cover.setPTC_GROUP_COVER_YN(resultSet
						.getString("PTC_GROUP_COVER_YN"));
				pm_il_prop_treaty_cover.setPTC_CVR_GRP_CODE(resultSet
						.getString("PTC_CVR_GRP_CODE"));
				pm_il_prop_treaty_cover.setROWID(resultSet
						.getString("PC_ROWID"));
				postQuery(compositeAction, pm_il_prop_treaty_cover);
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getDataTableList().add(pm_il_prop_treaty_cover);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void L_DUP_COVER(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, String code) throws Exception{
		CRUDHandler handler = new CRUDHandler();
		CommonUtils commonUtils = new CommonUtils();
		ResultSet vembu_C1 = null;
		ResultSet vembu_C2 = null;
		double sysid = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
				.getTempTreaty_TypeBean().getPTT_SYS_ID();
		String rowid = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION()
				.getPM_IL_PROP_TREATY_COVER_BEAN().getROWID();
		try {
			Connection connection = CommonUtils.getConnection();
			String sql_C1 = "SELECT 'X' " + "FROM PM_IL_PROP_TREATY_COVER "
					+ "WHERE PTC_PTT_SYS_ID = '" + sysid + "' "
					+ "AND  PM_IL_PROP_TREATY_COVER.PTC_COVER_CODE = '" + code
					+ "'";
			String sql_C2 = "SELECT 'X' " + "FROM PM_IL_PROP_TREATY_COVER "
					+ "WHERE  PTC_PTT_SYS_ID = '" + sysid + "' "
					+ "AND  PM_IL_PROP_TREATY_COVER.PTC_COVER_CODE = '" + code
					+ "' " + "AND PM_IL_PROP_TREATY_COVER.ROWID != '" + rowid
					+ "' ";
			String M_TEMP = null;
			if (rowid == null) {
				vembu_C1 = handler.executeSelectStatement(sql_C1, connection);
				if (vembu_C1.next()) {
					M_TEMP = vembu_C1.getString(1);
				}
				if (vembu_C1.next()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "19028"));
				}
			} else {
				vembu_C2 = handler.executeSelectStatement(sql_C2, connection);
				if (vembu_C2.next()) {
					M_TEMP = vembu_C2.getString(1);
				}
				if (vembu_C2.next()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath , "19028"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
			 CommonUtils.closeCursor(vembu_C1);
			 CommonUtils.closeCursor(vembu_C2);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	//[PREMIAGDC-TREATYMASTER-0087:CHARAN 28-Feb-09 Internal Fix
	public void PTC_CVR_GRP_CODEWhenValidateItem(
			PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction, 
			String PTC_CVR_GRP_CODE) throws Exception {
		String sql_C1 = "SELECT PM_IL_PROP_TREATY_COVER.ROWID " +
				"FROM   PM_IL_PROP_TREATY_COVER,PM_IL_PROP_TREATY_TYPE " +
				"WHERE  PTC_PTT_SYS_ID  = PTT_SYS_ID " +
				"AND    PTC_PTT_SYS_ID = ? " +
				"AND    PTT_PT_SYS_ID  = ? " +
				"AND    PTC_CVR_GRP_CODE = ?";
		PM_IL_PROP_TREATY_TYPE_ACTION treatyTypeAction = compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION();
		PM_IL_PROP_TREATY_ACTION treatyAction = compositeAction.getPM_IL_PROP_TREATY_ACTION();
		PM_IL_PROP_TREATY_COVER_ACTION treatyCoverAction = compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION();
		PM_IL_PROP_TREATY_COVER pm_il_prop_treaty_cover = treatyCoverAction.getPM_IL_PROP_TREATY_COVER_BEAN();
		pm_il_prop_treaty_cover.setPTC_CVR_GRP_CODE(PTC_CVR_GRP_CODE);
		Double PTT_SYS_ID = treatyTypeAction.getPM_IL_PROP_TREATY_TYPE_BEAN().getPTT_SYS_ID();
		Double PT_SYS_ID = treatyAction.getPM_IL_PROP_TREATY_BEAN().getPT_SYS_ID();
		String PT_TREATY_CODE = treatyAction.getPM_IL_PROP_TREATY_BEAN().getPT_TREATY_CODE();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		ResultSet rst_C1 = null;
		String M_DUMMY = null;
		ArrayList<String> resultList = null;
		try {
			connection = CommonUtils.getConnection();
			rst_C1 = handler.executeSelectStatement(sql_C1, connection, new Object[]{PTT_SYS_ID,PT_SYS_ID,PTC_CVR_GRP_CODE});
			while(rst_C1.next()){
				M_DUMMY = rst_C1.getString(1);
			}
			if(CommonUtils.isDuplicate(pm_il_prop_treaty_cover.getROWID(), M_DUMMY)){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91461", new Object[]{PT_TREATY_CODE}));
			}
			if(PTC_CVR_GRP_CODE!=null){
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(false);
			}else{
				compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().getCOMP_BUTTON_GRP_CVR().setDisabled(true);
			}
			resultList = new DBProcedures().P_VAL_CODES(
					"IL_RI_GR_CVR", 
					PTC_CVR_GRP_CODE, null, "N", "E", null);
			if(resultList != null && resultList.size() > 0){
				treatyCoverAction.getPM_IL_PROP_TREATY_COVER_BEAN().setUI_M_PTC_CVR_GRP_CODE_DESC(
						resultList.get(0));
				treatyCoverAction.getCOMP_UI_M_PTC_CVR_GRP_CODE_DESC().setSubmittedValue(resultList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	//PREMIAGDC-TREATYMASTER-0087:CHARAN 28-Feb-09 Internal Fix]

	/*Added by Janani on 07.02.2018 for ZBLIFE-1468859*/
	
	public void executeQuery(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction)
			throws Exception {

		new PM_IL_PROP_TREATY_COVER_DELEGATE().executeSelectStatement(compositeAction);
				

		List<PM_IL_PROP_TTYCOV_GRP> dataList = compositeAction
				.getPM_IL_PROP_TTYCOV_GRP_ACTION()
				.getDataTableList();
		System.out.println("dataList Size=======>"+dataList.size());
		if (dataList != null && dataList.size() > 0) {
			PM_IL_PROP_TTYCOV_GRP PM_IL_PROP_TTYCOV_GRP_BEAN = dataList
					.get(0);
			PM_IL_PROP_TTYCOV_GRP_BEAN.setRowSelected(true);
			compositeAction
					.getPM_IL_PROP_TTYCOV_GRP_ACTION()
					.setPM_IL_PROP_TTYCOV_GRP_BEAN(PM_IL_PROP_TTYCOV_GRP_BEAN);
		}
	}
	

	/*End of ZBLIFE-1468859*/


}
