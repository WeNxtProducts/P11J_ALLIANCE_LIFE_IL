package com.iii.pel.forms.PILR_REP070_DEB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.common.utils.ReportUtils;

public class PILR_REP070_DEB_HELPER {

	CRUDHandler handler = new CRUDHandler();
	public void PRE_INSERT(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {

			IP_REP_INFO_BEAN.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_CR_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
	
	public void whenCreaterecord(PILR_REP070_DEB_IP_REP_INFO_ACTION action) throws Exception{
		IP_REP_INFO IP_REP_INFO_BEAN = action.getIP_REP_INFO_BEAN();
		try{/*
			IP_REP_INFO_BEAN.setUI_M_FM_DT(action.getDefaultFromDate());
			IP_REP_INFO_BEAN.setUI_M_TO_DT(action.getDefaultToDate());*/
			IP_REP_INFO_BEAN.setUI_TO_DT(new CommonUtils().getCurrentDate());
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void PRE_UPDATE(IP_REP_INFO IP_REP_INFO_BEAN) {

		try {
			IP_REP_INFO_BEAN.setREP_ID(CommonUtils
					.getGlobalVariable("GLOBAL.M_PARAM_1"));
			IP_REP_INFO_BEAN.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			IP_REP_INFO_BEAN.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			IP_REP_INFO_BEAN.setREP_UPD_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			IP_REP_INFO_BEAN.setREP_UPD_DT(new CommonUtils().getCurrentDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	

	public String WHEN_VALIDATE_ITEM_UI_DIVN_CODE(String uiDivnFmCode,
			IP_REP_INFO pbr016ValueBean) throws Exception {

		List<OracleParameter> procedureReturnList = null;
		String C1 ="SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ? ";
		String M_DIVN_NAME = null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{uiDivnFmCode});
			while(rs.next()){
				M_DIVN_NAME = rs.getString(1);
			}
		   
		   return M_DIVN_NAME;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}

	}

	public String WHEN_VALIDATE_ITEM_UI_M_PROD_CODE(String uiProdFmCode,
			IP_REP_INFO pbr016ValueBean) throws Exception {

		List<OracleParameter> procedureReturnList = null;
		String C1 ="SELECT PROD_DESC FROM   PM_GL_PRODUCT WHERE  PROD_CODE = ?";
		String M_PROD_DESC =null;
		ResultSet rs = null;
		Connection con = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{uiProdFmCode});
			while(rs.next()){
				M_PROD_DESC = rs.getString(1);
			}
//			 SET_REP_FIRST_FIELD('REP_PARAM.M_PROD_FM','REP_PARAM.M_PROD_TO');
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return M_PROD_DESC;
			 
			
	}

	public String WHEN_VALIDATE_ITEM_UI_M_COVER_FM(String cvr,
			IP_REP_INFO ip_rep_info_bean)throws Exception {
		// TODO Auto-generated method stub

			String C1="SELECT COVER_DESC FROM PM_GL_COVER WHERE COVER_CODE=?";
			ResultSet rs = null;
			Connection con = null;
			String cvrName = null;
			try{
				con = CommonUtils.getConnection();
				rs = handler.executeSelectStatement(C1, con, new Object[]{cvr});
				while(rs.next()){
					cvrName = rs.getString(1);
				}
//		SET_REP_FIRST_FIELD('REP_PARAM.M_SRC_BUS_FM','REP_PARAM.M_SRC_BUS_TO');
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
			return cvrName;
	}

	public String WHEN_VALIDATE_ITEM_UI_M_CUST_CODE_FM(String uiCust_Code,
			IP_REP_INFO ip_rep_info_bean)throws Exception {
		// TODO Auto-generated method stub

		String C1="SELECT CUST_NAME FROM   PM_CUSTOMER WHERE  CUST_CODE = ?";
		ResultSet rs = null;
		Connection con = null;
		String M_CUST_DESC = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{uiCust_Code});
			while(rs.next()){
				M_CUST_DESC = rs.getString(1);
			}
//	SET_REP_FIRST_FIELD('REP_PARAM.M_SRC_BUS_FM','REP_PARAM.M_SRC_BUS_TO');
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return M_CUST_DESC;
}

	public String WHEN_VALIDATE_ITEM_UI_M_AGENT_FM(String uiAgent_Code,
			IP_REP_INFO ip_rep_info_bean)throws Exception {
		// TODO Auto-generated method stub

		String C1="SELECT CUST_NAME FROM   PM_CUSTOMER  WHERE  CUST_CODE = ?";
		ResultSet rs = null;
		Connection con = null;
		String M_AGENT_DESC = null;
		try{
			con = CommonUtils.getConnection();
			rs = handler.executeSelectStatement(C1, con, new Object[]{uiAgent_Code});
			while(rs.next()){
				M_AGENT_DESC = rs.getString(1);
			}
//	SET_REP_FIRST_FIELD('REP_PARAM.M_SRC_BUS_FM','REP_PARAM.M_SRC_BUS_TO');
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return M_AGENT_DESC;
}

	public String WHEN_VALIDATE_ITEM_UI_M_FM_STATUS(String stsCode,
			IP_REP_INFO ip_rep_info_bean)throws Exception {
		// TODO Auto-generated method stub
		String stsName = null;
		try{
			ArrayList<String> list = new DBProcedures().P_VAL_SYSTEM("GL_ADDL_STAT",stsCode,"","N","");
			if(list.size()>0){
				stsName = list.get(0);
			}
//	SET_REP_FIRST_FIELD('REP_PARAM.M_SRC_BUS_FM','REP_PARAM.M_SRC_BUS_TO');
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return stsName;
	}
	public void WHEN_VALIDATE_ITEM_UI_M_FM_DT(IP_REP_INFO ip_rep_info_bean)throws Exception {
		// TODO Auto-generated method stub
		try{
			if(ip_rep_info_bean.getUI_M_TO_DT()!=null){
				if(ip_rep_info_bean.getUI_M_FM_DT()!=null)
					if(ip_rep_info_bean.getUI_M_TO_DT().after(ip_rep_info_bean.getUI_M_TO_DT()))
						throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145"));
			}

		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
	
	public void WHEN_VALIDATE_ITEM_UI_M_TO_DT(IP_REP_INFO ip_rep_info_bean)throws Exception {
		try{
		if (ip_rep_info_bean.getUI_M_FM_DT()!=null)
		  if(ip_rep_info_bean.getUI_M_FM_DT().after(ip_rep_info_bean.getUI_M_TO_DT()))
			  throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71145")); 
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	public String WHEN_VALIDATE_ITEM_UI_M_SRC_BUS(String uiSrc_Bus,
			IP_REP_INFO ip_rep_info_bean)throws Exception {
		// TODO Auto-generated method stub

			String C1="SELECT PC_DESC FROM PM_CODES WHERE PC_TYPE='SRC_BUS_TY' AND PC_CODE =?";
			ResultSet rs = null;
			Connection con = null;
			String M_BUS_DESC = null;
			try{
				con = CommonUtils.getConnection();
				rs = handler.executeSelectStatement(C1, con, new Object[]{uiSrc_Bus});
				while(rs.next()){
					M_BUS_DESC = rs.getString(1);
				}
//		SET_REP_FIRST_FIELD('REP_PARAM.M_SRC_BUS_FM','REP_PARAM.M_SRC_BUS_TO');
			}catch(Exception e){
				e.printStackTrace();
				throw e;
			}
			return M_BUS_DESC;
	}
	

}
