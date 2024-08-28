package com.iii.pel.forms.PILT027;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_FUND_DETAIL_DELEGATE {

	public void executeSelectStatement(PILT027_COMPOSITE_ACTION compositeAction) {
		String queryString = "SELECT ROWID,PT_IL_TOPUP_FUND_DTL.* "
				+ " FROM PT_IL_TOPUP_FUND_DTL WHERE TOFD_POL_SYS_ID=? AND TOFD_TU_SYS_ID= ?";
		CommonUtils utility = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		ResultSet result = null;
		DBProcedures procedures = new DBProcedures();
		compositeAction.getPT_IL_FUND_DETAIL_ACTION_BEAN().getDataList().clear();
		ArrayList<String> outList = null;
		try {
			Connection connection = CommonUtils.getConnection();
 
			Integer id = compositeAction.getPT_IL_TOP_UP_ACTION_BEAN()
					.getPT_IL_TOP_UP_BEAN().getTU_POL_SYS_ID();
			Object[] values = { id,compositeAction.getPT_IL_TOP_UP_ACTION_BEAN()
					.getPT_IL_TOP_UP_BEAN().getTU_SYS_ID()
					};

			result = handler.executeSelectStatement(queryString, connection,
					values);
			if (result != null) {
				while (result.next()) {
					PT_IL_FUND_DETAIL bean = new PT_IL_FUND_DETAIL();
					bean.setTOFD_POL_SYS_ID(result.getInt("TOFD_POL_SYS_ID")); // NUMBER(10)
					bean.setTOFD_FUND_CODE(result.getString("TOFD_FUND_CODE")); // VARCHAR2(12)
					bean.setTOFD_FUND_PERC(result.getInt("TOFD_FUND_PERC")); // NUMBER(5,2)
					bean.setTOFD_SYS_ID(result.getInt("TOFD_SYS_ID")); // NUMBER(10)
					bean.setTOFD_TU_SYS_ID(result.getLong("TOFD_TU_SYS_ID")); // NUMBER(10)
					bean.setTOFD_FUND_DIR_TYPE(result
							.getString("TOFD_FUND_DIR_TYPE")); // VARCHAR2(1)
					bean.setTOFD_EFF_FM_DT(result.getDate("TOFD_EFF_FM_DT")); // DATE
					bean.setTOFD_EFF_TO_DT(result.getDate("TOFD_EFF_TO_DT")); // DATE
					bean.setROWID(result.getString("ROWID"));
					bean.setTOFD_FUND_DIR_TYPE("T");
					// outList = procedures.helperP_VAL_CODES("IL_CHARGE",
					// bean.getDCHRG_CODE(), "L", "E", null);
					when_validate_tu_cust_code(bean);
					// System.out.println("outList.get(0)........."+outList.get(0));
					// bean.setUI_M_CHARGE_DESC(outList.get(0));
					compositeAction.getPT_IL_FUND_DETAIL_ACTION_BEAN().getDataList().add(bean);
				}
			}
		 
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				CommonUtils.closeCursor(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
 
	}
	
	
	public void when_validate_tu_cust_code(PT_IL_FUND_DETAIL bean) { 
		ResultSet rs = null;
		String C1 = "SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE  FS_CODE ='"
				+ bean.getTOFD_FUND_CODE() + "' ";
		try {
			if (bean
					.getTOFD_FUND_CODE()!=null) {
				rs = new CRUDHandler().executeSelectStatement(C1, CommonUtils.getConnection());
				if (rs.next()) {
					String FS_DESC = rs.getString("FS_DESC");
					bean.setUI_M_FUND_DESC(FS_DESC);
					
				} else {
					String message = Messages.getString(PELConstants.pelErrorMessagePath, "91423");
					throw new ValidatorException(new FacesMessage(message));
				}
				rs.close();
			}
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void preInsert(PT_IL_FUND_DETAIL pt_il_fund_detail_bean) {
		String query = "SELECT PIL_TOFD_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {

			connection = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(query, connection);
			while (rs.next()) {
				pt_il_fund_detail_bean.setTOFD_SYS_ID(rs.getInt(1));
			}

			pt_il_fund_detail_bean.setTOFD_CR_UID(CommonUtils.getControlBean()
					.getM_USER_ID());
			pt_il_fund_detail_bean.setTOFD_CR_DT(new CommonUtils()
					.getCurrentDate());
			pt_il_fund_detail_bean.setTOFD_FUND_DIR_TYPE("T");
		// pt_il_fund_detail_bean.setTOFD_POL_SYS_ID(compositeActionBean.getPT_IL_TOP_UP_ACTION_BEAN().getPT_IL_TOP_UP_BEAN().getTU_POL_NO());

		} catch (Exception e) {
			throw new ValidatorException(Messages.getMessage("TOFD_SYS_ID", e
					.getMessage()));
		}

	}


	public void setPolDetails(PT_IL_FUND_DETAIL pt_il_fund_detail_bean) {
		
		try {
			new PT_IL_FUND_DETAIL_HELPER().setPolDetails(pt_il_fund_detail_bean);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
		
		
	}

}
