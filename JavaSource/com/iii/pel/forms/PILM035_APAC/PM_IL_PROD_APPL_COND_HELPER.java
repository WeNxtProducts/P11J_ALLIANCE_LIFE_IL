package com.iii.pel.forms.PILM035_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PM_IL_PROD_APPL_COND_HELPER {
	DBProcedures dbProcedures = new DBProcedures();

	public void PRE_BLOCK(PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void WHEN_NEW_BLOCK_INSTANCE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) {
	}

	public void PRE_INSERT(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_APPL_COND pm_il_prod_appl_cond_bean = compositeAction
				.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COND_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		try {
			pm_il_prod_appl_cond_bean.setPACOND_PROD_CODE(pm_il_product_bean
					.getPROD_CODE());
			L_VAL_COND_UNIQUE(compositeAction);

			pm_il_prod_appl_cond_bean.setPACOND_CR_DT(new CommonUtils()
					.getCurrentDate());

			pm_il_prod_appl_cond_bean.setPACOND_CR_UID(CommonUtils
					.getControlBean().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_APPL_COND pm_il_prod_appl_cond_bean = compositeAction
				.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COND_BEAN();

		try {
			L_VAL_COND_UNIQUE(compositeAction);
			pm_il_prod_appl_cond_bean.setPACOND_UPD_DT(new CommonUtils()
					.getCurrentDate());
			pm_il_prod_appl_cond_bean.setPACOND_UPD_UID(CommonUtils
					.getControlBean().getUSER_ID());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_DELETE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		Connection con = null;
		ResultSet rs1 = null;
		String M_DUMMY = null;

		PM_IL_PROD_APPL_COND pm_il_prod_appl_cond_bean = compositeAction
				.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COND_BEAN();

		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();

		String c1 = "SELECT 'X'  FROM   PT_IL_POL_CONDITION,PT_IL_POLICY WHERE  PLCOND_CODE = ? AND "
				+ "PLCOND_POL_SYS_ID = POL_SYS_ID AND POL_PROD_CODE = ? ";

		try {
			con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();

			Object[] c1values = {
					pm_il_prod_appl_cond_bean.getPACOND_COND_CODE(),
					pm_il_product_bean.getPROD_CODE() };
			rs1 = handler.executeSelectStatement(c1, con, c1values);
			while (rs1.next()) {
				M_DUMMY = rs1.getString(1);
			}
			if (M_DUMMY != null) {
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91061"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
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

	public void POST_QUERY(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_APPL_COND pm_il_prod_appl_cond_bean = compositeAction
				.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COND_BEAN();
		ArrayList<String> retList = null;
		
		/*added by raja on 21-03-2017 for set description*/
		DBProcedures procedures = new DBProcedures();
		ArrayList<String> list = null;
		/*end*/
		
		
		
		try {
			retList = PILM035_PROCEDURES.P_VAL_CODES("IL_COND",
					pm_il_prod_appl_cond_bean.getPACOND_COND_CODE(),
					pm_il_prod_appl_cond_bean.getUI_M_PACOND_COND_CODE_DESC(),
					"N", "E", null);
			if (retList != null) {
				pm_il_prod_appl_cond_bean.setUI_M_PACOND_COND_CODE_DESC(retList
						.get(0));
			}
			
			
			/*added by raja on 21-03-2017 for set description*/
			if(pm_il_prod_appl_cond_bean.getPACOND_COVER_CODE()!=null)
			{
				/*Referred from Payor Details screen.Added by Raja on 21/03/2017*/
			list = procedures.helperP_VAL_COVER(pm_il_prod_appl_cond_bean.getPACOND_COVER_CODE(),"A", "N", "N");
			/*End*/
			if (list != null  && !list.isEmpty()) {
				pm_il_prod_appl_cond_bean.setUI_M_PACOND_COVER_CODE_DESC(list.get(0));
			}
			}
			/*end*/

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	public void WHEN_VALIDATE_ITEM_PACOND_COND_CODE(
			PILM035_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PM_IL_PROD_APPL_COND pm_il_prod_appl_cond_bean = compositeAction
				.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COND_BEAN();
		try {
			L_VAL_COND_UNIQUE(compositeAction);
			ArrayList<String> desclist = dbProcedures.P_VAL_CODES_PM_CHARGER(
					"IL_COND", pm_il_prod_appl_cond_bean.getPACOND_COND_CODE(),
					pm_il_prod_appl_cond_bean.getUI_M_PACOND_COND_CODE_DESC(),
					"N", "E", null);
			pm_il_prod_appl_cond_bean.setUI_M_PACOND_COND_CODE_DESC(desclist
					.get(0));

		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		}

	}

	public void L_VAL_COND_UNIQUE(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		PM_IL_PROD_APPL_COND pm_il_prod_appl_cond_bean = compositeAction
				.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
				.getPM_IL_PROD_APPL_COND_BEAN();
		PM_IL_PRODUCT pm_il_product_bean = compositeAction
				.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		Connection con = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String M_DUMMY = null;

		String c1 = "SELECT 'X'  FROM   PM_IL_PROD_APPL_COND WHERE  "
				+ "PACOND_PROD_CODE  = ? AND PACOND_COND_CODE =  ?";

		String c2 = "SELECT 'X' FROM   PM_IL_PROD_APPL_COND WHERE  PACOND_PROD_CODE  = ? AND "
				+ "PACOND_COND_CODE = ? AND ROWID <> ?";

		try {
			con = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			if (pm_il_prod_appl_cond_bean.getROWID() == null) {
				Object[] c1values = { pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_appl_cond_bean.getPACOND_COND_CODE() };
				rs1 = handler.executeSelectStatement(c1, con, c1values);
				while (rs1.next()) {
					M_DUMMY = rs1.getString(1);
				}
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "61007"));
				}
			} else {
				Object[] c2values = { pm_il_product_bean.getPROD_CODE(),
						pm_il_prod_appl_cond_bean.getPACOND_COND_CODE(),
						pm_il_prod_appl_cond_bean.getROWID() };

				rs2 = handler.executeSelectStatement(c2, con, c2values);
				while (rs2.next()) {
					M_DUMMY = rs2.getString(1);
				}
				if (M_DUMMY != null) {
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "61007"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (DBException e) {
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

	public void executeQuery(PILM035_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PM_IL_PROD_APPL_COND_DELEGATE()
				.executeSelectStatement(compositeAction);

		try {
			List<PM_IL_PROD_APPL_COND> dataList = compositeAction
					.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
					.getDataList_PM_IL_PROD_APPL_COND();
			if (dataList != null && dataList.size() > 0) {
				PM_IL_PROD_APPL_COND PM_IL_PROD_APPL_COND_BEAN = dataList
						.get(0);
				PM_IL_PROD_APPL_COND_BEAN.setRowSelected(true);
				compositeAction
						.getPM_IL_PROD_APPL_COND_ACTION_BEAN()
						.setPM_IL_PROD_APPL_COND_BEAN(PM_IL_PROD_APPL_COND_BEAN);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	public List<LovBean> prepareLovList(String query, Object[] obj)
			throws Exception {
		List<LovBean> list = new PM_IL_PROD_APPL_COND_DELEGATE()
		.prepareLovList(query, obj);
		return list;
	}
	
	public void WHEN_VALIDATE_ITEM_PACOND_DISP_SEQ_NO(
			PILM035_APAC_COMPOSITE_ACTION compositeAction,int seqNo) throws Exception {
		 ResultSet rs = null;
		 
		try {
			PM_IL_PRODUCT pm_il_product_bean = compositeAction
					.getPM_IL_PRODUCT_ACTION_BEAN().getPM_IL_PRODUCT_BEAN();
		String query = "SELECT COUNT(*) FROM PM_IL_PROD_APPL_COND  WHERE PACOND_PROD_CODE = ?  AND PACOND_DISP_SEQ_NO = ? AND ROWID != ?";	 
		rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection(),
				new Object[]{pm_il_product_bean.getPROD_CODE(),seqNo,
							 compositeAction.getPM_IL_PROD_APPL_COND_ACTION_BEAN().getPM_IL_PROD_APPL_COND_BEAN().getROWID()
		});
		System.out.println("Values are    "+pm_il_product_bean.getPROD_CODE()+"        "+seqNo+"      "+
							 compositeAction.getPM_IL_PROD_APPL_COND_ACTION_BEAN().getPM_IL_PROD_APPL_COND_BEAN().getROWID());
		int existEntry = 0;
		while(rs.next())
		{
			existEntry = rs.getInt(1);
		}
		if(existEntry > 0)
		{
			throw new Exception("Sequence already Exists");
		}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorHelpUtil.getErrorForProcedure(CommonUtils.getConnection());
			throw new Exception(e.getMessage());
		}

	}
}
