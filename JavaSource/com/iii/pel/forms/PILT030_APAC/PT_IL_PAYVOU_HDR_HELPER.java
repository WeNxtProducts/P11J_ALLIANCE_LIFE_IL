package com.iii.pel.forms.PILT030_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT021.PT_IL_WITHDRAWAL;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PAYVOU_HDR_HELPER {

	public void executeQuery(){
		String query = "SELECT ROWID, PAH_SYS_ID,PAH_CONTROL_NO,PAH_TYPE,PAH_FM_DT,PAH_TO_DT,PAH_PRO_DT," +
							"PAH_FREEZE_FLAG,PAH_APPRV_DT,PAH_APPRV_STATUS,PAH_MATCH_STATUS,PAH_REF_NO " +
							"FROM PT_IL_PAYVOU_HDR " +
							"WHERE PAH_TYPE=? " +
							"AND ROWID=?";
		System.out.println(query);
		CRUDHandler handler = new CRUDHandler();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		PT_IL_PAYVOU_HDR_ACTION pt_il_payvou_hdr_action =PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		String rowID=pt_il_payvou_hdr_action.getPT_IL_PAYVOU_HDR_BEAN().getROWID();
		
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		String pahType = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
		Double M_PAH_SYS_ID = dummyAction.getDUMMY_BEAN().getUI_M_PAH_SYS_ID();
		System.out.println(pahType+"        "+M_PAH_SYS_ID);
		try {
			ResultSet rst = handler.executeSelectStatement(query, connection,new Object[]{pahType,rowID});
			boolean resultExist=rst.next();
			if(resultExist){
				PT_IL_PAYVOU_HDR hdrBean = new PT_IL_PAYVOU_HDR();
				hdrBean.setROWID(rst.getString(1));
				hdrBean.setPAH_SYS_ID(rst.getInt("PAH_SYS_ID"));
				hdrBean.setPAH_CONTROL_NO(rst.getString("PAH_CONTROL_NO"));
				hdrBean.setPAH_TYPE(rst.getString("PAH_TYPE"));
				hdrBean.setPAH_FM_DT(rst.getDate("PAH_FM_DT"));
				hdrBean.setPAH_TO_DT(rst.getDate("PAH_TO_DT"));
				hdrBean.setPAH_PRO_DT(rst.getDate("PAH_PRO_DT"));
				hdrBean.setPAH_FREEZE_FLAG(rst.getString("PAH_FREEZE_FLAG"));
				hdrBean.setPAH_APPRV_DT(rst.getDate("PAH_APPRV_DT"));
				hdrBean.setPAH_APPRV_STATUS(rst.getString("PAH_APPRV_STATUS"));
				hdrBean.setPAH_MATCH_STATUS(rst.getString("PAH_MATCH_STATUS"));
				hdrBean.setPAH_REF_NO(rst.getString("PAH_REF_NO"));
				postQuery(hdrBean);
				hdrAction.setPT_IL_PAYVOU_HDR_BEAN(hdrBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void postQuery(PT_IL_PAYVOU_HDR hdrBean) throws ValidatorException {
		String M_DUMMY=null;
		String PAH_CONTROL_NO = hdrBean.getPAH_CONTROL_NO();
		String c1="SELECT 'X' FROM   PT_IL_PAYVOU_HDR  " +
				"WHERE  PAH_CONTROL_NO = ? AND PAH_APPRV_STATUS = 'A'";
		CRUDHandler handler = new CRUDHandler();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		try {
			ResultSet rst = handler.executeSelectStatement(c1, connection, new Object[]{PAH_CONTROL_NO});
			while(rst.next()){
				M_DUMMY=rst.getString(1);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void whenNewRecordInstance() throws ValidatorException {
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		String PAH_APPRV_STATUS = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_APPRV_STATUS();
		String PAH_FREEZE_FLAG = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_FREEZE_FLAG();
		Date PAH_PRO_DT = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_PRO_DT();
		String PAH_CONTROL_NO = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_CONTROL_NO();
		Integer PAH_SYS_ID = hdrAction.getPT_IL_PAYVOU_HDR_BEAN().getPAH_SYS_ID();
		CRUDHandler handler = new CRUDHandler();
		try
        {
            String M_DUMMY=null;
            String M_DUMMY1=null;
            String M_DRCR_DUMMY=null;
            String  /** METADATA NOT FOUND *********/ M_PAH_MATCH_STATUS=null;
            String  /** METADATA NOT FOUND *********/ M_PAH_APPRV_STATUS=null;
            String sql_C1="SELECT 'X' FROM  PM_IL_APPR_SETUP_DET  " +
            		"WHERE  ASD_USER_ID  = :GLOBAL.M_USER_ID  " +
            		"AND ASD_CODE  = 'PAY_POST_MAT' ";
            ResultSet vembu_C1=null;
            String sql_C2="SELECT 'X' FROM  PT_IL_PAYVOU_HDR  " +
            		"WHERE  PAH_CONTROL_NO  = ? " +
            		"AND PAH_APPRV_STATUS  = 'A' ";
            ResultSet vembu_C2=null;
            String sql_C3="SELECT 'X' FROM  PS_IL_DRCR  " +
            		"WHERE  (DRCR_DOC_NO  , DRCR_DOC_DT  , DRCR_TXN_CODE  , DRCR_ACNT_YEAR  ) " +
            		"IN  (   " +
            		"SELECT     PADD_DOC_NO,     PADD_DOC_DT,     PADD_TXN_CODE,     PADD_ACNT_YEAR  " +
            		"FROM  PT_IL_PAYVOU_DRCR_DTL   " +
            		"WHERE  PADD_PAH_SYS_ID  = ? " +
            		"AND NVL(PADD_SELECTED_YN, 'N')  = 'Y'  )  " +
            		"AND NVL(DRCR_POST_YN, 'N')  = 'N' ";
            ResultSet vembu_C3=null;
            String sql_C4="SELECT PAH_MATCH_STATUS FROM  PT_IL_PAYVOU_HDR  " +
            		"WHERE  PAH_SYS_ID  = ? ";
            ResultSet vembu_C4=null;
            String sql_C5="SELECT PAH_APPRV_STATUS FROM  PT_IL_PAYVOU_HDR  " +
            		"WHERE  PAH_SYS_ID  = ? ";
            ResultSet vembu_C5=null;
            if((PAH_APPRV_STATUS==null?"N":PAH_APPRV_STATUS).equals("N"))
            {
                hdrAction.getPT_IL_PAYVOU_HDR_BEAN().setUI_M_APPRV_STATUS("NOT APPROVED");
                /*SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",UPDATE_ALLOWED,PROPERTY_FALSE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_HDR",DELETE_ALLOWED,PROPERTY_FALSE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_PAY_DTL",UPDATE_ALLOWED,PROPERTY_TRUE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_PAY_DTL",DELETE_ALLOWED,PROPERTY_TRUE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_DRCR_DTL",UPDATE_ALLOWED,PROPERTY_TRUE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PAYVOU_DRCR_DTL",DELETE_ALLOWED,PROPERTY_FALSE);*/
                dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
                dummyAction.getCOMP_UI_M_BUT_FREEZE().setDisabled(false);
                dummyAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
                dummyAction.getCOMP_UI_M_BUT_MATCH().setDisabled(true);
                if(PAH_PRO_DT != null)
                {
                    dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
                }
                else
                {
                    dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(false);
                }
                if((PAH_FREEZE_FLAG==null?"N":PAH_FREEZE_FLAG).equals("N"))
                {
                    dummyAction.getCOMP_UI_M_BUT_UNFREEZE().setDisabled(true);
                }
                else if((PAH_FREEZE_FLAG==null?"N":PAH_FREEZE_FLAG).equals("Y"))
                {
                	dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
                    dummyAction.getCOMP_UI_M_BUT_FREEZE().setDisabled(true);
                    dummyAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(false);
                    dummyAction.getCOMP_UI_M_BUT_UNFREEZE().setDisabled(false);
                }
            }
            else if((PAH_FREEZE_FLAG==null?"N":PAH_FREEZE_FLAG).equals("Y") && (PAH_APPRV_STATUS==null?"N":PAH_APPRV_STATUS).equals("A"))
            {
                hdrAction.getPT_IL_PAYVOU_HDR_BEAN().setUI_M_APPRV_STATUS("APPROVED");
                dummyAction.getCOMP_UI_M_BUT_PROCESS().setDisabled(true);
                dummyAction.getCOMP_UI_M_BUT_FREEZE().setDisabled(true);
                dummyAction.getCOMP_UI_M_BUT_APPROVE().setDisabled(true);
                dummyAction.getCOMP_UI_M_BUT_UNFREEZE().setDisabled(true);
            }
            vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{PAH_CONTROL_NO});
            if(vembu_C2.next())
            {
                M_DUMMY1=vembu_C2.getString(1);
            }
            if(M_DUMMY1!=null)
            {
                dummyAction.getCOMP_UI_M_BUT_REPORT().setDisabled(false);
            }
            else
            {
            	dummyAction.getCOMP_UI_M_BUT_REPORT().setDisabled(false);
            }
            CommonUtils.closeCursor(vembu_C2);
            vembu_C5=handler.executeSelectStatement(sql_C5, connection, new Object[]{PAH_SYS_ID});
            if(vembu_C5.next()){
                M_PAH_APPRV_STATUS=vembu_C5.getString(1);
            }
            CommonUtils.closeCursor(vembu_C5);
            if((M_PAH_APPRV_STATUS==null?"":M_PAH_APPRV_STATUS).equals("A")){
                vembu_C3=handler.executeSelectStatement(sql_C3, connection, new Object[]{PAH_SYS_ID});
                if(vembu_C3.next()){
                    M_DRCR_DUMMY=vembu_C3.getString(1);
                }
                CommonUtils.closeCursor(vembu_C3);
                if((M_DRCR_DUMMY==null?"N":M_DRCR_DUMMY).equals("X")){
                    dummyAction.getCOMP_UI_M_BUT_POST().setDisabled(false);
                }
                else{
                    dummyAction.getCOMP_UI_M_BUT_POST().setDisabled(true);
                }
                vembu_C4=handler.executeSelectStatement(sql_C4, connection, new Object[]{PAH_SYS_ID});
                if(vembu_C4.next())
                {
                    M_PAH_MATCH_STATUS=vembu_C4.getString(1);
                }
                CommonUtils.closeCursor(vembu_C4);
                if((M_PAH_MATCH_STATUS==null?"N":M_PAH_MATCH_STATUS).equals("N") && (M_DRCR_DUMMY==null?"N":M_DRCR_DUMMY).equals("N"))
                {
                    dummyAction.getCOMP_UI_M_BUT_MATCH().setDisabled(false);
                }
            }
        }catch(Exception e){
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	public void whenNewBlockInstance() throws ValidatorException {
		executeQuery();
		PT_IL_PAYVOU_AMT_DTL_HELPER amtHelper = new PT_IL_PAYVOU_AMT_DTL_HELPER();
		amtHelper.executeQuery();
		PT_IL_PAYVOU_PAY_DTL_HELPER dtlHelper = new PT_IL_PAYVOU_PAY_DTL_HELPER();
		dtlHelper.executeQuery();
		PT_IL_PAYVOU_DRCR_DTL_HELPER drcrHelper = new PT_IL_PAYVOU_DRCR_DTL_HELPER();
		drcrHelper.executeQuery();
	}

	public void executeQuery(PILT030_APAC_COMPOSITE_ACTION compositeAction) throws SQLException { 
		PT_IL_PAYVOU_HDR pt_il_payvou_hdr = compositeAction
				.getPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION().getPT_IL_PAYVOU_HDR_BEAN();
		String selectStatement = "SELECT ROWID, PT_IL_PAYVOU_HDR.* FROM PT_IL_PAYVOU_HDR WHERE ROWID= ? and PAH_TYPE='CL' ";
		Connection connection = null;
		ResultSet rst = null;
		try {
			connection = CommonUtils.getConnection();
			rst = new CRUDHandler().executeSelectStatement(selectStatement,connection,new Object[] { pt_il_payvou_hdr.getROWID() });
			PT_IL_PAYVOU_HDR hdrBean = new PT_IL_PAYVOU_HDR();
			while (rst.next()) {
				hdrBean.setROWID(rst.getString(1));
				hdrBean.setPAH_SYS_ID(rst.getInt("PAH_SYS_ID"));
				hdrBean.setPAH_CONTROL_NO(rst.getString("PAH_CONTROL_NO"));
				hdrBean.setPAH_TYPE(rst.getString("PAH_TYPE"));
				hdrBean.setPAH_FM_DT(rst.getDate("PAH_FM_DT"));
				hdrBean.setPAH_TO_DT(rst.getDate("PAH_TO_DT"));
				hdrBean.setPAH_PRO_DT(rst.getDate("PAH_PRO_DT"));
				hdrBean.setPAH_FREEZE_FLAG(rst.getString("PAH_FREEZE_FLAG"));
				hdrBean.setPAH_APPRV_DT(rst.getDate("PAH_APPRV_DT"));
				hdrBean.setPAH_APPRV_STATUS(rst.getString("PAH_APPRV_STATUS"));
				hdrBean.setPAH_MATCH_STATUS(rst.getString("PAH_MATCH_STATUS"));
				hdrBean.setPAH_REF_NO(rst.getString("PAH_REF_NO"));
				postQuery(hdrBean);
			}
			compositeAction.getPILT030_APAC_PT_IL_PAYVOU_HDR_ACTION().setPT_IL_PAYVOU_HDR_BEAN(hdrBean);
		}catch(Exception e){
			
		}finally {
			rst.close();
		}
}
	
	public void executeProcessQuery(){
		String query = "SELECT ROWID, PAH_SYS_ID,PAH_CONTROL_NO,PAH_TYPE,PAH_FM_DT,PAH_TO_DT,PAH_PRO_DT," +
							"PAH_FREEZE_FLAG,PAH_APPRV_DT,PAH_APPRV_STATUS,PAH_MATCH_STATUS,PAH_REF_NO " +
							"FROM PT_IL_PAYVOU_HDR ";
		System.out.println(query);
		CRUDHandler handler = new CRUDHandler();
		Connection connection = PILT030_APAC_ACTION_INSTANCE.getConnection();
		DUMMY_ACTION dummyAction = PILT030_APAC_ACTION_INSTANCE.getDummyActionInstance();
		PT_IL_PAYVOU_HDR_ACTION pt_il_payvou_hdr_action =PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		String rowID=pt_il_payvou_hdr_action.getPT_IL_PAYVOU_HDR_BEAN().getROWID();
		
		PT_IL_PAYVOU_HDR_ACTION hdrAction = PILT030_APAC_ACTION_INSTANCE.getPayVouHdrActionInstance();
		String pahType = dummyAction.getDUMMY_BEAN().getUI_M_PAH_TYPE();
		Double M_PAH_SYS_ID = dummyAction.getDUMMY_BEAN().getUI_M_PAH_SYS_ID();
		System.out.println(pahType+"        "+M_PAH_SYS_ID);
		try {
			ResultSet rst = handler.executeSelectStatement(query, connection);
			boolean resultExist=rst.next();
			if(resultExist){
				PT_IL_PAYVOU_HDR hdrBean = new PT_IL_PAYVOU_HDR();
				hdrBean.setROWID(rst.getString(1));
				hdrBean.setPAH_SYS_ID(rst.getInt("PAH_SYS_ID"));
				hdrBean.setPAH_CONTROL_NO(rst.getString("PAH_CONTROL_NO"));
				hdrBean.setPAH_TYPE(rst.getString("PAH_TYPE"));
				hdrBean.setPAH_FM_DT(rst.getDate("PAH_FM_DT"));
				hdrBean.setPAH_TO_DT(rst.getDate("PAH_TO_DT"));
				hdrBean.setPAH_PRO_DT(rst.getDate("PAH_PRO_DT"));
				hdrBean.setPAH_FREEZE_FLAG(rst.getString("PAH_FREEZE_FLAG"));
				hdrBean.setPAH_APPRV_DT(rst.getDate("PAH_APPRV_DT"));
				hdrBean.setPAH_APPRV_STATUS(rst.getString("PAH_APPRV_STATUS"));
				hdrBean.setPAH_MATCH_STATUS(rst.getString("PAH_MATCH_STATUS"));
				hdrBean.setPAH_REF_NO(rst.getString("PAH_REF_NO"));
				postQuery(hdrBean);
				hdrAction.setPT_IL_PAYVOU_HDR_BEAN(hdrBean);
			}
			CommonUtils.closeCursor(rst);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
}
