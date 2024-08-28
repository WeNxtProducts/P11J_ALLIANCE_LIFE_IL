package com.iii.pel.forms.PM078_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM078_A_Procedures {
	public String L_VAL_PRODUCT(String P_PROD_CODE, String P_ERR_FLAG) throws Exception{
		String C1 = null;
		String M_PROD_DESC = null;
		String P_PROD_DESC = null;
		String M_PROD_BL_DESC = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String M_FOR_LANG_CODE = null;
		try{
			M_FOR_LANG_CODE = CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1 = "SELECT PROD_DESC,PROD_BL_DESC FROM PM_IL_PRODUCT WHERE " +
				"PROD_CODE = ?";
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{P_PROD_CODE});
			while(resultSet.next()){
				M_PROD_DESC = resultSet.getString(1);
				M_PROD_BL_DESC = resultSet.getString(2);
			}
			if(M_PROD_DESC == null){
				if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)){
					if("E".equals(P_ERR_FLAG)){
						throw new Exception(Messages.getString(
								PELConstants.pelErrorMessagePath, "91074"));
					}
				}
			}else{
				if("1".equals(M_FOR_LANG_CODE.substring(4, M_FOR_LANG_CODE.length())) || 
						"ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))){
					P_PROD_DESC = M_PROD_DESC;
				}else{
					P_PROD_DESC = M_PROD_BL_DESC;
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return P_PROD_DESC;
	}
	
	public String L_VAL_COVER(String P_COVER_CODE, String P_ERR_FLAG) throws Exception{
		String C1 = null;
		String M_COVER_DESC = null;
		String P_COVER_DESC = null;
		String M_COVER_BL_DESC = null;
		Connection connection = null;
		ResultSet resultSet = null;
		CRUDHandler handler = null;
		String M_FOR_LANG_CODE = null;
		try{
			M_FOR_LANG_CODE = CommonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE");
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			C1 = "SELECT COVER_DESC,COVER_BL_DESC FROM PM_IL_COVER WHERE COVER_CODE = ?";
			resultSet = handler.executeSelectStatement(C1, connection, new Object[]{P_COVER_CODE});
			while(resultSet.next()){
				M_COVER_DESC = resultSet.getString(1);
				M_COVER_BL_DESC = resultSet.getString(2);
			}
			if(M_COVER_DESC == null){
				if("W".equals(P_ERR_FLAG) || "E".equals(P_ERR_FLAG)){
					if("E".equals(P_ERR_FLAG)){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "91074"));
					}
				}
			}else{
				if("1".equals(M_FOR_LANG_CODE.substring(4, M_FOR_LANG_CODE.length())) || 
						"ENG".equals(CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"))){
					P_COVER_DESC = M_COVER_DESC;
				}else{
					P_COVER_DESC = M_COVER_BL_DESC;
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return P_COVER_DESC;
	}
	
	public void L_UPDATE_TO_DT(String M_UPD, PM_LIFE_WAKALAH_HDR pm_life_wakalah_hdr, 
			PM_LIFE_WAKALAH_SETUP pm_life_wakalah_setup) throws Exception{
		String M_VAR = null;
		Date M_WAKS_EFF_FM_DT = null;
		String C1 = null;
		String C2 = null;
		String C3 = null;
		String date = "31-12-2999";
		ResultSet resultSetC1 = null;
		ResultSet resultSetC2 = null;
		CRUDHandler handler = null;
		Connection connection = null;
		int updated = 0;
		Object[] values = null;
		try{
			handler = new CRUDHandler();
			connection = CommonUtils.getConnection();
			values = new Object[2];
			values[0] = pm_life_wakalah_hdr.getWAKS_MODULE();
			values[1] = pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE();
			C1 = "SELECT MAX(WAKS_EFF_FM_DT) FROM PM_LIFE_WAKALAH_SETUP WHERE " +
					"WAKS_MODULE = ? AND WAKS_PRODUCT_CODE = ?";
			
			C2 = "SELECT MIN(WAKS_EFF_FM_DT) FROM PM_LIFE_WAKALAH_SETUP WHERE " +
					"WAKS_MODULE = ? AND WAKS_PRODUCT_CODE = ? AND WAKS_EFF_FM_DT > ?";
			// L_WAKS_EFF_TO_DT;
			resultSetC1 = handler.executeSelectStatement(C1, connection, values);
			if(resultSetC1.next()){
				M_WAKS_EFF_FM_DT = resultSetC1.getDate(1);
			}
			if("U".equals(M_UPD)){
				if("31-12-2999".equals(pm_life_wakalah_setup.getWAKS_EFF_TO_DT()) 
						&& M_WAKS_EFF_FM_DT.after(pm_life_wakalah_setup.getWAKS_EFF_FM_DT())){
					values = new Object[3];
					values[0] = pm_life_wakalah_hdr.getWAKS_MODULE();
					values[1] = pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE();
					values[2] = pm_life_wakalah_setup.getWAKS_EFF_FM_DT();
					resultSetC2 = handler.executeSelectStatement(C2, connection, values);
					if(resultSetC2.next()){
						M_WAKS_EFF_FM_DT = resultSetC1.getDate(1);
					}
					pm_life_wakalah_setup.setWAKS_EFF_TO_DT(CommonUtils.addDaysToDate(M_WAKS_EFF_FM_DT, -1));
				}else if(!"31-12-2999".equals(pm_life_wakalah_setup.getWAKS_EFF_TO_DT())
						&& M_WAKS_EFF_FM_DT.after(pm_life_wakalah_setup.getWAKS_EFF_FM_DT())){
					
				}else{
					C3 = "UPDATE PM_LIFE_WAKALAH_SETUP SET WAKS_EFF_TO_DT = (?) " +
							"WHERE WAKS_EFF_FM_DT = M_WAKS_EFF_FM_DT AND " +
							"WAKS_EFF_TO_DT = ? AND WAKS_MODULE = ? AND WAKS_PRODUCT_CODE = ?";
					values = new Object[4];
					values[0] = CommonUtils.addDaysToDate(pm_life_wakalah_setup.getWAKS_EFF_FM_DT(), -1);
					values[1] = date;
					values[2] = pm_life_wakalah_hdr.getWAKS_MODULE();
					values[3] = pm_life_wakalah_hdr.getWAKS_PRODUCT_CODE();
					updated = handler.executeUpdateStatement(C3, connection, values);
				}
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSetC1);
				CommonUtils.closeCursor(resultSetC2);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void L_WAKS_EFF_TO_DT(){
		Date M_WAKS_EFF_FM_DT = null;
		Date M_WAKS_EFF_TO_DT = null;
		String M_ERR_STR = null;
		String M_ERR_MESSAGE = null;
		String C1 = null;
		
		C1 = "SELECT WAKS_EFF_FM_DT, DECODE(WAKS_EFF_TO_DT, TO_DATE('31/12/2999','DD/MM/YYYY'), " +
				"WAKS_EFF_FM_DT,WAKS_EFF_TO_DT) FROM PM_LIFE_WAKALAH_SETUP WHERE WAKS_MODULE = ? " +
				"AND WAKS_PRODUCT_CODE = ? AND ROWID != ? AND (? BETWEEN WAKS_EFF_FM_DT AND " +
				"DECODE(WAKS_EFF_TO_DT, TO_DATE('31/12/2999','DD/MM/YYYY'),WAKS_EFF_FM_DT, " +
				"WAKS_EFF_TO_DT) OR ? BETWEEN WAKS_EFF_FM_DT AND DECODE(WAKS_EFF_TO_DT, " +
				"TO_DATE('31/12/2999','DD/MM/YYYY'),WAKS_EFF_FM_DT, WAKS_EFF_TO_DT) OR " +
				"WAKS_EFF_FM_DT BETWEEN ? AND DECODE(?, TO_DATE('31/12/2999','DD/MM/YYYY'),?,?) " +
				"OR DECODE(WAKS_EFF_TO_DT, TO_DATE('31/12/2999','DD/MM/YYYY'),WAKS_EFF_FM_DT, " +
				"WAKS_EFF_TO_DT) BETWEEN ? AND DECODE(?, TO_DATE('31/12/2999','DD/MM/YYYY'),?,?) )";
	}
}
