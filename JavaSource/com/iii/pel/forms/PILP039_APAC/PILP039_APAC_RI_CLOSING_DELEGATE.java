package com.iii.pel.forms.PILP039_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PILP039_APAC_RI_CLOSING_DELEGATE {

	public List getLovForProdCode(Object string) {
		List<RI_CLOSING_LOV> riCloseLovList = null;
		RI_CLOSING_LOV closeBean = null;
		Connection con = null;
		ResultSet rst = null; 
		CRUDHandler handler = null;
		String selectQuery = PILP039_APAC_RI_CLOSING_CONSTANTS.PILP039_APAC_RI_CLOSING_M_PROD_FM_LOV;
		
		try {
			con = CommonUtils.getConnection();
			if ("*".equals(string)) {
				selectQuery = selectQuery.replace("{0}", " ");
			}else{
				/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
				 * 
				 * selectQuery = selectQuery.replace("{0}", " WHERE PROD_CODE LIKE '"+string+"%' ");*/
				/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
				selectQuery = selectQuery.replace("{0}", " WHERE UPPER(PROD_CODE) LIKE UPPER('"+string+"%') ");
				/*end*/
			}
			if(con != null){
				handler = new CRUDHandler();
				riCloseLovList = new ArrayList<RI_CLOSING_LOV>();
				rst = handler.executeSelectStatement(selectQuery, con);
				while(rst.next()){
					closeBean = new RI_CLOSING_LOV();
						closeBean.setPROD_FM(rst.getString(1));
						closeBean.setPROD_FM_DESC(rst.getString(2));
					riCloseLovList.add(closeBean);
				}
			}
		} catch (DBException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(rst!=null){
				try {
					CommonUtils.closeCursor(rst);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return riCloseLovList;
	}
	public static List<SelectItem> getDropDownListValue(String formName,
			String blockName, String blockFieldName, String filedName) {
		List<SelectItem> listValues = null;
		try {
			listValues = ListItemUtil.getDropDownListValue(CommonUtils
					.getConnection(), formName, blockName, blockFieldName,
					filedName);
		} catch (DBException e) {
			e.printStackTrace();
		}

		return listValues;
	}

}
