package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_LOAD_TARIFF_HELPER {
	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_APPL_LOAD_TARIFF_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_APPL_LOAD_TARIFF> dataList = compositeAction
					.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
					.getDataList_PM_IL_PROD_APPL_LOAD_TARIFF();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_APPL_LOAD_TARIFF PM_IL_PROD_APPL_LOAD_TARIFF_BEAN = dataList
						.get(0);
				PM_IL_PROD_APPL_LOAD_TARIFF_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.setPM_IL_PROD_APPL_LOAD_TARIFF_BEAN(
								PM_IL_PROD_APPL_LOAD_TARIFF_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_CREATE_RECORD(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws SQLException, DBException {
		ResultSet rs1 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		String M_PLAN_SA_INST_PYMT_YN = null;
		String M_PLAN_TYPE = null;
		String M_PLAN_RED_SA_BASIS = null;
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		String C1 = "SELECT  NVL(PLAN_SA_INST_PYMT_YN,'N'),NVL(PLAN_PERIOD_FROM,0), "
				+ "NVL(PLAN_PERIOD_TO,0),NVL(PLAN_MAX_AGE_ON_MAT,0),PLAN_TYPE, PLAN_RED_SA_BASIS "
				+ "FROM    PM_IL_PLAN " + "WHERE   PLAN_CODE = ?";
		try {
			con = CommonUtils.getConnection();
			Object[] C1values = new Object[] { pm_il_product_bean
					.getPROD_PLAN_CODE() };
			rs1 = handler.executeSelectStatement(C1, con, C1values);
			//pm_il_prod_appl_load_tariff_bean.setPALT_TH_PARAM_TYPE("D");
			//pm_il_prod_appl_load_tariff_bean.setPALT_DEFAULT_YN("N");
			while (rs1.next()) {
				M_PLAN_SA_INST_PYMT_YN = rs1.getString(1);
				dummy_bean.setUI_M_PLAN_PERIOD_FROM(rs1.getInt(2));
				dummy_bean.setUI_M_PLAN_PERIOD_TO(rs1.getInt(3));
				dummy_bean.setUI_M_PLAN_MAX_AGE_ON_MAT(rs1.getInt(4));
				M_PLAN_TYPE = rs1.getString(5);
				M_PLAN_RED_SA_BASIS = rs1.getString(6);
			}
			if (!("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS))) {
				pm_il_prod_appl_load_tariff_bean.setPALT_LOAD_APPL_PERC(100.0);
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getCOMP_PALT_LOAD_APPL_PERC().setDisabled(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_NEW_RECORD_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		try {
			if (("11".equalsIgnoreCase(pm_il_prod_appl_load_tariff_bean
					.getPALT_APPLIED_ON()) || ("12"
					.equalsIgnoreCase(pm_il_prod_appl_load_tariff_bean
							.getPALT_APPLIED_ON())))) {
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getCOMP_PALT_APPL_UPTO().setDisabled(true);
			} else {
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getCOMP_PALT_APPL_UPTO().setDisabled(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			
			System.out.println("bean value of product code in m_il_product table   ::::::::::::  "+pm_il_product_bean.getPROD_CODE());
			pm_il_prod_appl_load_tariff_bean
					.setPALT_PROD_CODE(pm_il_product_bean.getPROD_CODE());
			
			System.out.println("bean value of product code in m_il pm_il_prod_appl_load_tariff table   :::::::::::::  "+pm_il_prod_appl_load_tariff_bean.getPALT_PROD_CODE());
			
			L_UNIQUE_LOADTARIFF_SRNO(compositeAction);
			System.out.println("pm_il_prod_appl_load_tariff_bean.getPALT_DEFAULT_YN()    : "+pm_il_prod_appl_load_tariff_bean.getPALT_DEFAULT_YN());
			
			pm_il_prod_appl_load_tariff_bean.setPALT_CR_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_load_tariff_bean.setPALT_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
 	}

	private boolean checkDupliCateCode(PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean) throws Exception {

        ResultSet resultSet=null;
        CRUDHandler handler = new CRUDHandler();
        String query=null;
		Connection connection=null;
		boolean exist=false;
		int count=0;
		try {
		connection=CommonUtils.getConnection();
		System.out.println("pm_il_prod_appl_load_tariff_bean.getPALT_PROD_CODE()   :"+pm_il_prod_appl_load_tariff_bean.getPALT_PROD_CODE());
		query="SELECT COUNT(PALT_TH_CODE) FROM PM_IL_PROD_APPL_LOAD_TARIFF WHERE PALT_TH_CODE='"+pm_il_prod_appl_load_tariff_bean.getPALT_TH_CODE()+"' AND " +
				"PALT_PROD_CODE='"+pm_il_prod_appl_load_tariff_bean.getPALT_PROD_CODE()+"'AND PALT_COVER_CODE='"+pm_il_prod_appl_load_tariff_bean.getPALT_COVER_CODE()+"'";	
		resultSet=handler.executeSelectStatement(query, connection);
		boolean resultExist=resultSet.next();
		if(resultExist){
			count=resultSet.getInt(1);
		}
		if(count>0){
			exist=true;
		}
        } catch (Exception e) { 
        	throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}
        return exist;
	}

	public void L_UNIQUE_LOADTARIFF_SRNO(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		String M_TARIFFLOAD_SRNO = null;
		String C1 = "SELECT 'X' " + "FROM   PM_IL_PROD_APPL_LOAD_TARIFF "
				+ "WHERE  PALT_SRNO  = ? AND  PALT_PROD_CODE  =  ? ";
		String C2 = "SELECT 'X' " + "FROM   PM_IL_PROD_APPL_LOAD_TARIFF "
				+ "WHERE  PALT_SRNO  = ? AND  PALT_PROD_CODE  = ? "
				+ "AND    ROWID  <> ? ";
		try {
			con = CommonUtils.getConnection();
			Object[] C1values = {
					pm_il_prod_appl_load_tariff_bean.getPALT_SRNO(),
					pm_il_prod_appl_load_tariff_bean.getPALT_PROD_CODE() };
			rs1 = handler.executeSelectStatement(C1, con, C1values);
			if (pm_il_prod_appl_load_tariff_bean.getROWID() == null) {
				while (rs1.next()) {
					M_TARIFFLOAD_SRNO = rs1.getString(1);
				}
				if (M_TARIFFLOAD_SRNO != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90015",
							new Object[] { "Tariff / Loading Serial No" }));
				}
			} else {
				Object[] c2values = {
						pm_il_prod_appl_load_tariff_bean.getPALT_SRNO(),
						pm_il_prod_appl_load_tariff_bean.getPALT_PROD_CODE(),
						pm_il_prod_appl_load_tariff_bean.getROWID() };
				rs2 = handler.executeSelectStatement(C2, con, c2values);
				while (rs2.next()) {
					M_TARIFFLOAD_SRNO = rs2.getString(2);
				}
				if (M_TARIFFLOAD_SRNO != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "90015",
							new Object[] { "Tariff / Loading Serial No" }));
					// STD_MESSAGE_ROUTINE(90015,:CTRL.M_LANG_CODE,'Tariff /
					// Loading Serial No');

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		try {
			L_UNIQUE_LOADTARIFF_SRNO(compositeAction);
			pm_il_prod_appl_load_tariff_bean.setPALT_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_load_tariff_bean.setPALT_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.USER_ID"));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		ResultSet rs = null;
		Connection con = null;
		CRUDHandler handler = new CRUDHandler();
		String c1 = "SELECT  NVL(PLAN_SA_INST_PYMT_YN,'N'),NVL(PLAN_PERIOD_FROM,0), "
				+ "NVL(PLAN_PERIOD_TO,0),NVL(PLAN_MAX_AGE_ON_MAT,0),PLAN_TYPE, PLAN_RED_SA_BASIS "
				+ "FROM    PM_IL_PLAN " + "WHERE   PLAN_CODE = ?";
		String M_PLAN_SA_INST_PYMT_YN = null;
		String M_PLAN_TYPE = null;
		String M_PLAN_RED_SA_BASIS = null;
		try {
			con = CommonUtils.getConnection();

			ArrayList<String> codedesc = new PILM035_APAC().L_VAL_TARIFF(
					pm_il_prod_appl_load_tariff_bean.getPALT_TH_CODE(),
					pm_il_prod_appl_load_tariff_bean
							.getUI_M_PALT_TH_CODE_DESC(),
					pm_il_prod_appl_load_tariff_bean.getPALT_TH_PARAM_TYPE(),
					"N");
			pm_il_prod_appl_load_tariff_bean.setUI_M_PALT_TH_CODE_DESC(codedesc
					.get(0));
			Object[] c1values = { pm_il_product_bean.getPROD_PLAN_CODE() };
			rs = handler.executeSelectStatement(c1, con, c1values);
			while (rs.next()) {
				M_PLAN_SA_INST_PYMT_YN = rs.getString(1);
				dummy_bean.setUI_M_PLAN_PERIOD_FROM(rs.getInt(2));
				dummy_bean.setUI_M_PLAN_PERIOD_TO(rs.getInt(3));
				dummy_bean.setUI_M_PLAN_MAX_AGE_ON_MAT(rs.getInt(4));
				M_PLAN_TYPE = rs.getString(5);
				M_PLAN_RED_SA_BASIS = rs.getString(6);
			}
			if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)) {
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getCOMP_PALT_LOAD_APPL_PERC().setDisabled(false);
			} else {
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getCOMP_PALT_LOAD_APPL_PERC().setDisabled(true);
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PALT_SRNO(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		Integer PALT_SRNO = (Integer) currValue;
		try {
			L_UNIQUE_LOADTARIFF_SRNO(compositeAction);
			if (PALT_SRNO <= 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PALT_APPLIED_ON(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		String PALT_APPLIED_ON = (String) currValue;
		try {
			if ("11".equals(PALT_APPLIED_ON) || ("12".equals(PALT_APPLIED_ON))) {
				pm_il_prod_appl_load_tariff_bean.setPALT_APPL_UPTO("0");
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getCOMP_PALT_APPL_UPTO().setDisabled(true);
			} else {
				compositeAction.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
						.getCOMP_PALT_APPL_UPTO().setDisabled(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PALT_TH_CODE(
			PILM035_APAC_COMPOSITE_ACTION CompositeAction, Object currValue)
			throws Exception {
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		Connection con = null;
		String M_PLAN_SA_INST_PYMT_YN = null;
		String M_PLAN_TYPE = null;
		String M_CODE_DESC = null;
		double M_VALUE = 0.0;
		String M_PLAN_RED_SA_BASIS = null;
		DUMMY dummy_bean = CompositeAction.getDUMMY_ACTION_BEAN()
				.getDUMMY_BEAN();
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = CompositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = CompositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String C1 = "SELECT  NVL(PLAN_SA_INST_PYMT_YN,'N'),NVL(PLAN_PERIOD_FROM,0), "
				+ "NVL(PLAN_PERIOD_TO,0),NVL(PLAN_MAX_AGE_ON_MAT,0),PLAN_TYPE,PLAN_RED_SA_BASIS "
				+ "FROM    PM_IL_PLAN " + "WHERE   PLAN_CODE = ? ";
		String C2 = " SELECT  PS_VALUE " + "FROM  PP_SYSTEM "
				+ "WHERE   PS_TYPE ='IL_MTLD_CODE' "
				+ "AND     PS_CODE IN ('IL_MLOD_DTH','IL_MLOD_TPD') "
				+ "AND     PS_CODE_DESC = ?";
		String PALT_TH_CODE = (String) currValue;
		try {
			con = CommonUtils.getConnection();
			Object[] C1values = { pm_il_product_bean.getPROD_PLAN_CODE() };
			rs1 = handler.executeSelectStatement(C1, con, C1values);
			while (rs1.next()) {
				M_PLAN_SA_INST_PYMT_YN = rs1.getString(1);
				dummy_bean.setUI_M_PLAN_PERIOD_FROM(rs1.getInt(2));
				dummy_bean.setUI_M_PLAN_PERIOD_TO(rs1.getInt(3));
				dummy_bean.setUI_M_PLAN_MAX_AGE_ON_MAT(rs1.getInt(4));
				M_PLAN_TYPE = rs1.getString(5);
				M_PLAN_RED_SA_BASIS = rs1.getString(6);
			}
			new PILM035_APAC().P_VAL_PLAN(pm_il_product_bean
					.getPROD_PLAN_CODE(), pm_il_product_bean
					.getUI_M_PROD_PLAN_CODE_DESC(), "N", "E");
			if ("R".equalsIgnoreCase(M_PLAN_RED_SA_BASIS)) {
				Object[] C2values = { pm_il_prod_appl_load_tariff_bean
						.getPALT_TH_CODE() };
				rs2 = handler.executeSelectStatement(C2, con, C2values);
				while (rs2.next()) {
					M_VALUE = rs2.getDouble(1);
					pm_il_prod_appl_load_tariff_bean
							.setPALT_LOAD_APPL_PERC(CommonUtils.nvl(M_VALUE,
									100));
				}
				if (M_VALUE == 0) {
					pm_il_prod_appl_load_tariff_bean
							.setPALT_LOAD_APPL_PERC(100.0);
				}
			} else {
				pm_il_prod_appl_load_tariff_bean.setPALT_LOAD_APPL_PERC(100.0);
			}
			ArrayList<String> codedesc = new PILM035_APAC().L_VAL_TARIFF(
					PALT_TH_CODE, pm_il_prod_appl_load_tariff_bean
							.getUI_M_PALT_TH_CODE_DESC(),
					pm_il_prod_appl_load_tariff_bean.getPALT_TH_PARAM_TYPE(),
					"E");
			pm_il_prod_appl_load_tariff_bean.setUI_M_PALT_TH_CODE_DESC(codedesc
					.get(0));
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void WHEN_VALIDATE_ITEM_PALT_LOAD_APPL_PERC(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		Double PALT_LOAD_APPL_PERC = (Double) currValue;
		try {
			ArrayList<String> codedesc = new PILM035_APAC().L_VAL_TARIFF(
					pm_il_prod_appl_load_tariff_bean.getPALT_TH_CODE(),
					pm_il_prod_appl_load_tariff_bean
							.getUI_M_PALT_TH_CODE_DESC(),
					pm_il_prod_appl_load_tariff_bean.getPALT_TH_PARAM_TYPE(),
					"E");
			pm_il_prod_appl_load_tariff_bean.setUI_M_PALT_TH_CODE_DESC(codedesc
					.get(0));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PALT_APPL_UPTO(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)
			throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		String PALT_APPL_UPTO = (String) currValue;
		try {
			if (Integer.parseInt(PALT_APPL_UPTO) >= pm_il_prod_appl_load_tariff_bean
					.getPALT_SRNO()) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91083"));
			}
			if (Integer.parseInt(PALT_APPL_UPTO) < 0) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void WHEN_VALIDATE_ITEM_PALT_DEFAULT_YN(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		try {
			System.out.println("pm_il_prod_appl_load_tariff_bean.getPALT_APPL_UPTO()  :  "+pm_il_prod_appl_load_tariff_bean.getPALT_APPL_UPTO());
			System.out.println("pm_il_prod_appl_load_tariff_bean.getPALT_SRNO()       :  "+pm_il_prod_appl_load_tariff_bean.getPALT_SRNO());
			System.out.println("Integer.parseInt(pm_il_prod_appl_load_tariff_bean.getPALT_APPL_UPTO())   "+Integer.parseInt(pm_il_prod_appl_load_tariff_bean
					.getPALT_APPL_UPTO()));
			
			if (Integer.parseInt(pm_il_prod_appl_load_tariff_bean
					.getPALT_APPL_UPTO()) >= pm_il_prod_appl_load_tariff_bean
					.getPALT_SRNO()) {
				System.out.println("1111");
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91083"));
			}
			if (Integer.parseInt(pm_il_prod_appl_load_tariff_bean
					.getPALT_APPL_UPTO()) < 0) {
				System.out.println("2222");				
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "71043"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public boolean duplicateCheck(PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_APPL_LOAD_TARIFF pm_il_prod_appl_load_tariff_bean = compositeAction
				.getPM_IL_PROD_APPL_LOAD_TARIFF_ACTION_BEAN()
				.getPM_IL_PROD_APPL_LOAD_TARIFF_BEAN();
		boolean exist=false;
		try {
			exist=checkDupliCateCode(pm_il_prod_appl_load_tariff_bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return exist; 
 	}
}
