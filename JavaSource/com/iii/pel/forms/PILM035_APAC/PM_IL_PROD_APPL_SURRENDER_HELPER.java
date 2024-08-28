package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_PROD_APPL_SURRENDER_HELPER {
	
	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		try {
			new PM_IL_PROD_APPL_SURRENDER_DELEGATE()
					.executeSelectStatement(compositeAction);
			List<PM_IL_PROD_APPL_SURRENDER> dataList = compositeAction.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN().getDataList_PM_IL_PROD_SURRENDER();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN = dataList
						.get(0);
				PM_IL_PROD_APPL_SURRENDER_BEAN.setRowSelected(true);
				compositeAction.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN()
						.setPM_IL_PROD_APPL_SURRENDER_BEAN(
								PM_IL_PROD_APPL_SURRENDER_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)throws Exception {
		PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN = compositeAction.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN().getPM_IL_PROD_APPL_SURRENDER_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_CR_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
			L_UNIQUE_MODETERM(compositeAction);

		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN = compositeAction
				.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_SURRENDER_BEAN();
		try {
		  
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_UPD_DT(new CommonUtils()
					.getCurrentDate());
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_CR_DT(new CommonUtils()
			.getCurrentDate());
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_UPD_UID(CommonUtils
					.getControlBean().getM_USER_ID());
			PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_CR_UID("PREMIADMIN");
			 L_UNIQUE_MODETERM(compositeAction);
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}
	}
	public void L_UNIQUE_MODETERM(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		CRUDHandler handler = new CRUDHandler();
		Connection con = null;
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN = compositeAction
				.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_SURRENDER_BEAN();

		String query= " SELECT 'X' FROM   PM_IL_PROD_SURR_DTL"
                       + " WHERE   PSD_PROD_CODE    = ? "
				       + " AND  ( (?      BETWEEN  PSD_TERM_FM AND PSD_TERM_TO)" 
				       + " OR(?  BETWEEN  PSD_TERM_FM AND PSD_TERM_TO))";
		String query1 = " SELECT 'X' FROM  PM_IL_PROD_SURR_DTL "
			    + "WHERE PSD_PROD_CODE	  = ? "
				+ "AND ( (?  BETWEEN  PSD_TERM_FM AND PSD_TERM_TO) "
				+ "OR  ( ?   BETWEEN  PSD_TERM_FM AND PSD_TERM_TO)) "
				+ "AND  ROWID  <> ? ";
		
		//String query= "SELECT COUNT(*) FROM PM_IL_PROD_SURR_DTL WHERE PSD_PROD_CODE =? AND PSD_TERM_FM BETWEEN ? AND ? AND PSD_TERM_TO BETWEEN ? AND ? AND PSD_SURR_YRS =?";
         //int count=0;
		
		System.out.println("dnf  "+query);
		
		try {
			con = CommonUtils.getConnection();

			if(PM_IL_PROD_APPL_SURRENDER_BEAN.getROWID() == null){
				Object[] c1values = new Object[] {
						pm_il_product_bean.getPROD_CODE(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_FM(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_TO()};
			/* Object[] c1values = new Object[] {
						pm_il_product_bean.getPROD_CODE(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_FM(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_TO(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_SURR_YRS()};*/
				rs1 = handler.executeSelectStatement(query, con, c1values);
				if (rs1.next()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60018",
							new Object[] { "The  combination already exists . Please  re-enter." }));
				}
			}else {
				Object[] c2values = new Object[] {
						pm_il_product_bean.getPROD_CODE(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_FM(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_TO(),
						PM_IL_PROD_APPL_SURRENDER_BEAN.getROWID() };
				rs2 = handler.executeSelectStatement(query1, con, c2values);
				if (rs2.next()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "60018",
							new Object[] { "The  combination already exists . Please  re-enter." }));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();throw e;
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void WHEN_VALIDATE_ITEM_PSD_TERM_FM(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN = compositeAction
				.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_SURRENDER_BEAN();
		int PSD_TERM_FM = (Integer) currValue;
		try {
			if(PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_FM() != null){
				if (PSD_TERM_FM != 0 
						&& PSD_TERM_FM > PM_IL_PROD_APPL_SURRENDER_BEAN
								.getPSD_TERM_FM()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Minimum term is", "greater than",
									"Maximum term" }));
				} else if (PSD_TERM_FM == 0) {
					PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_TERM_FM(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}
	public void WHEN_VALIDATE_ITEM_PSD_TERM_TO(
			PILM035_APAC_COMPOSITE_ACTION compositeAction, Object currValue)throws Exception {
		PM_IL_PROD_APPL_SURRENDER PM_IL_PROD_APPL_SURRENDER_BEAN = compositeAction
				.getPM_IL_PROD_APPL_SURRENDER_ACTION_BEAN()
				.getPM_IL_PROD_APPL_SURRENDER_BEAN();
		int PSD_TERM_FM = (Integer) currValue;
		try {
			if(PM_IL_PROD_APPL_SURRENDER_BEAN.getPSD_TERM_FM() != null){
				if (PSD_TERM_FM != 0 
						&& PSD_TERM_FM < PM_IL_PROD_APPL_SURRENDER_BEAN
								.getPSD_TERM_FM()) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91014",
							new Object[] { "Maximum term is", "less than",
									"Minimum term" }));
				} else if (PSD_TERM_FM == 0) {
					PM_IL_PROD_APPL_SURRENDER_BEAN.setPSD_TERM_FM(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();throw e;
		}

	}

}
