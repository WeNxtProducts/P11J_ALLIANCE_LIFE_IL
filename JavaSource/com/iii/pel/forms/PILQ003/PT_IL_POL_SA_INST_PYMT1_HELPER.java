package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.utils.PKG_PILT002_APAC;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_SA_INST_PYMT1_HELPER {

    public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction)
	    throws Exception {
    	try{
	new PT_IL_POL_SA_INST_PYMT1_DELEGATE()
		.executeSelectStatement(compositeAction);

	List<PT_IL_POL_SA_INST_PYMT1> dataList = compositeAction
		.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
		.getDataList_PT_IL_POL_SA_INST_PYMT1();
	if (dataList != null && dataList.size() > 0) {
	    PT_IL_POL_SA_INST_PYMT1 PT_IL_POL_SA_INST_PYMT1_BEAN = dataList
		    .get(0);
	    PT_IL_POL_SA_INST_PYMT1_BEAN.setRowSelected(true);
	    compositeAction.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
		    .setPT_IL_POL_SA_INST_PYMT1_BEAN(
			    PT_IL_POL_SA_INST_PYMT1_BEAN);
    	}
    	}catch(Exception e){
    		e.printStackTrace();
    		throw new Exception(e.getMessage());
    	}
    }

    public void PRE_INSERT(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {

	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PT_IL_POL_SA_INST_PYMT1 pt_il_pol_sa_inst_pymt1_bean = compositeAction
		.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT1_BEAN();
	PT_IL_POL_SA_INST_PYMT_HEAD pt_il_pol_sa_inst_pymt_head = compositeAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();

	CommonUtils commonUtils = new CommonUtils();
	String query1 = "SELECT PT_IL_POL_SIP_SYS_ID.NEXTVAL FROM DUAL ";
	Connection connection = null;
	ResultSet resultSet = null;
	try {
		connection = CommonUtils.getConnection();
	    resultSet = new CRUDHandler().executeSelectStatement(query1,
		    connection);
	    if (resultSet.next()) {
		pt_il_pol_sa_inst_pymt1_bean.setSIPD_SYS_ID(resultSet
			.getLong(1));
	    }
	  //  pt_il_pol_sa_inst_pymt1_bean.setSIPD_SIPH_SYS_ID(pt_il_pol_sa_inst_pymt_head.getSIPH_SYS_ID());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_POL_SYS_ID(pt_il_policy_bean
		    .getPOL_SYS_ID());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_PROD_CODE(pt_il_policy_bean
		    .getPOL_PROD_CODE());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_PLAN_CODE(pt_il_policy_bean
		    .getPOL_PLAN_CODE());
	    pt_il_pol_sa_inst_pymt1_bean
		    .setSIPD_PROD_MAT_AMT_TYPE(pt_il_pol_sa_inst_pymt_head
			    .getSIPH_PROD_MAT_AMT_TYPE());
	    pt_il_pol_sa_inst_pymt1_bean
		    .setSIPD_NAV_TYPE(pt_il_pol_sa_inst_pymt_head
			    .getSIPH_NAV_TYPE());
	    pt_il_pol_sa_inst_pymt1_bean
		    .setSIPD_SIPH_SYS_ID(pt_il_pol_sa_inst_pymt_head
			    .getSIPH_SYS_ID());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_UPD_DT(commonUtils
		    .getCurrentDate());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_UPD_UID(CommonUtils
		    .getControlBean().getUSER_ID());

	    L_VAL_PYMT_NUM_UNIQUE1(compositeAction);

	} catch (Exception e) {
	      e.printStackTrace();
	    throw new Exception(e.getMessage());
	}finally{
		CommonUtils.closeCursor(resultSet);
	}
    }

    public void L_VAL_PYMT_NUM_UNIQUE1(PILQ003_COMPOSITE_ACTION compositeAction) 
    			throws Exception {

	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PT_IL_POL_SA_INST_PYMT1 pt_il_pol_sa_inst_pymt1_bean = compositeAction
		.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT1_BEAN();
	Connection connection = null;
	Object[] values = {};
	ResultSet resultSet = null;
	String query1 = " SELECT 'X'  FROM   PT_IL_POL_SA_INST_PYMT  "
						+ " WHERE   SIPD_PROD_CODE   = ? "
						+ "   AND	 SIPD_PLAN_CODE   = ? "
						+ "  AND  SIPD_NUMR_PERIOD = ? "
						+ "  AND    SIPD_POL_SYS_ID  = ? ";

	String query2 = "  SELECT 'X'   FROM   PT_IL_POL_SA_INST_PYMT  "
					+ " WHERE  SIPD_PROD_CODE   = ? "
					+ "   AND	  SIPD_PLAN_CODE   = ? "
					+ "  AND    SIPD_NUMR_PERIOD =?  "
					+ " AND    SIPD_POL_SYS_ID  = ?  AND    "
					+ " ROWID          <> ? ";
	String M_DUMMY = null;
	String ROWID = null;
	try {

	    connection = CommonUtils.getConnection();
	    ROWID = compositeAction.getPT_IL_POL_SA_INST_PYMT_ACTION_BEAN()
		    .getPT_IL_POL_SA_INST_PYMT_BEAN().getROWID();
	    values = new Object[] {
		    pt_il_pol_sa_inst_pymt1_bean.getSIPD_PROD_CODE(),
		    pt_il_pol_sa_inst_pymt1_bean.getSIPD_PLAN_CODE(),
		    pt_il_pol_sa_inst_pymt1_bean.getSIPD_NUMR_PERIOD(),
		    pt_il_policy_bean.getPOL_SYS_ID() };
	    if (ROWID == null) {
		resultSet = new CRUDHandler().executeSelectStatement(query1,
			connection, values);
		if (resultSet.next()) {
		    M_DUMMY = resultSet.getString(1);
		    throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91041",new Object[] {
						    CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"Period" }));

		} else {
		    values = new Object[] {
			    pt_il_pol_sa_inst_pymt1_bean.getSIPD_PROD_CODE(),
			    pt_il_pol_sa_inst_pymt1_bean.getSIPD_PLAN_CODE(),
			    pt_il_pol_sa_inst_pymt1_bean.getSIPD_NUMR_PERIOD(),
			    pt_il_policy_bean.getPOL_SYS_ID(), ROWID };
		    resultSet = new CRUDHandler().executeSelectStatement(
			    query2, connection, values);
		    if (resultSet.next()) {
			M_DUMMY = resultSet.getString(1);
			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91041",new Object[] {
							CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),"Period" }));
		    }
		}
	    }

	} catch (Exception e) {
	     e.printStackTrace();
	     throw new Exception(e.getMessage());
	}
    }

    public void PRE_UPDATE(PILQ003_COMPOSITE_ACTION compositeAction)
    			throws Exception {

	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PT_IL_POL_SA_INST_PYMT1 pt_il_pol_sa_inst_pymt1_bean = compositeAction
		.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT1_BEAN();
	PT_IL_POL_SA_INST_PYMT_HEAD pt_il_pol_sa_inst_pymt_head = compositeAction
		.getPT_IL_POL_SA_INST_PYMT_HEAD_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT_HEAD_BEAN();
	CommonUtils commonUtils = new CommonUtils();
	try {
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_POL_SYS_ID(pt_il_policy_bean
		    .getPOL_SYS_ID());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_PROD_CODE(pt_il_policy_bean
		    .getPOL_PROD_CODE());
	    pt_il_pol_sa_inst_pymt1_bean
		    .setSIPD_PROD_MAT_AMT_TYPE(pt_il_pol_sa_inst_pymt_head
			    .getSIPH_PROD_MAT_AMT_TYPE());
	    pt_il_pol_sa_inst_pymt1_bean
		    .setSIPD_NAV_TYPE(pt_il_pol_sa_inst_pymt_head
			    .getSIPH_NAV_TYPE());
	    pt_il_pol_sa_inst_pymt1_bean
		    .setSIPD_PROD_SURR_PLUS_FACTOR(pt_il_pol_sa_inst_pymt_head
			    .getSIPH_PROD_SURR_PLUS_FACTOR());
	    pt_il_pol_sa_inst_pymt1_bean
		    .setSIPD_SIPH_SYS_ID(pt_il_pol_sa_inst_pymt_head
			    .getSIPH_SYS_ID());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_PLAN_CODE(pt_il_policy_bean
		    .getPOL_PLAN_CODE());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_UPD_DT(commonUtils
		    .getCurrentDate());
	    pt_il_pol_sa_inst_pymt1_bean.setSIPD_UPD_UID(CommonUtils
		    .getControlBean().getM_USER_ID());

	    L_VAL_PYMT_NUM_UNIQUE1(compositeAction);
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new Exception(e.getMessage());
	}
    }

    public void whenNewRecordInstance(PILQ003_COMPOSITE_ACTION compositeAction) 
    			throws Exception {
	PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PT_IL_POL_SA_INST_PYMT1 pt_il_pol_sa_inst_pymt1_bean = compositeAction
		.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT1_BEAN();
	PT_IL_POL_SA_INST_PYMT1_ACTION pt_il_pol_sa_inst_pymt1_action = compositeAction
		.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN();
	String M_USER_PERM = null;
	String M_ASD_CHAR_VALUE = null;
	ResultSet rs = null;
	Connection connection = null;
	Object[] values = {};
	ArrayList<String> pValList = new ArrayList<String>();
	String query1 = "  SELECT  ASD_CHAR_VALUE "
					+ " FROM    PM_IL_APPR_SETUP_DET "
					+ " WHERE   ASD_USER_ID = ? "
					+ " AND     ASD_CODE    = 'CHG_MAT_YN' "
					+ " AND     ?  BETWEEN NVL(ASD_FM_PROD_CODE,'0') AND NVL(ASD_TO_PROD_CODE,'zzzzzzzzzzzz') ";
	PKG_PILT002_APAC pkg_pilt002_apac = new PKG_PILT002_APAC();
	try {
	    connection = CommonUtils.getConnection();
	    values = new Object[] { CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID"),
	    												pt_il_policy_bean.getPOL_PROD_CODE() };
	    if (pt_il_pol_sa_inst_pymt1_bean.getROWID() != null) {
		/*
		 * COPY('P','CTRL.M_COMM_DEL') ;
		 * COPY('20','SYSTEM.MESSAGE_LEVEL'); POST;
		 * COPY('','CTRL.M_COMM_DEL') ;
		 * COPY('0','SYSTEM.MESSAGE_LEVEL');
		 */
	    }
	    rs = new CRUDHandler().executeSelectStatement(query1, connection,
		    values);
	    if (rs.next()) {
		M_ASD_CHAR_VALUE = rs.getString(1);
	    }

	    if ("Y".equals(M_ASD_CHAR_VALUE)) {
		if ("Y".equals(CommonUtils.SUBSTR(  CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE") ,1, 1))) {
		    pt_il_pol_sa_inst_pymt1_action.setINSERT_ALLOWED(true);
		}
		if ("Y".equals(CommonUtils.SUBSTR(CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE"),2, 1))) {
		    pt_il_pol_sa_inst_pymt1_action.setUPDATE_ALLOWED(true);
		}
		if ("Y".equals(CommonUtils.SUBSTR(CommonUtils.getGlobalVariable(
			"GLOBAL.M_PRIVILEGE"),3, 1))) {
		    pt_il_pol_sa_inst_pymt1_action.setDELETE_ALLOWED(true);
		}
	    } else {
		pt_il_pol_sa_inst_pymt1_action.setINSERT_ALLOWED(false);
		pt_il_pol_sa_inst_pymt1_action.setUPDATE_ALLOWED(false);
		pt_il_pol_sa_inst_pymt1_action.setDELETE_ALLOWED(false);
	    }

	    if (CommonUtils.nvl(pt_il_policy_bean.getPOL_APPRV_STATUS(), "N")
		    .equals("A")) {

		pt_il_pol_sa_inst_pymt1_action.setINSERT_ALLOWED(false);
		pt_il_pol_sa_inst_pymt1_action.setUPDATE_ALLOWED(false);
		pt_il_pol_sa_inst_pymt1_action.setDELETE_ALLOWED(false);

	    }

	    if (pt_il_policy_bean.getPOL_END_NO_IDX() > 0
		    && pt_il_policy_bean.getPOL_END_TYPE().equals("001")
		    && (!"A".equals(CommonUtils.nvl(pt_il_policy_bean
			    .getPOL_APPRV_STATUS(), "N")))) {

		pValList = pkg_pilt002_apac.P_VAL_ENDT_APPROVAL(CommonUtils
			.getControlBean().getM_USER_ID(), "CHG_MAT_YN",
			pt_il_policy_bean.getPOL_PROD_CODE(), "2", M_USER_PERM,
			pt_il_policy_bean.getPOL_END_CODE());
		if (pValList != null && pValList.size() > 0) {
		    M_USER_PERM = pValList.get(0);
		}

		if ("N".equals(M_USER_PERM)) {
		    pt_il_pol_sa_inst_pymt1_action.setINSERT_ALLOWED(false);
		    pt_il_pol_sa_inst_pymt1_action.setUPDATE_ALLOWED(false);
		    pt_il_pol_sa_inst_pymt1_action.setDELETE_ALLOWED(false);
		} else {
		    pt_il_pol_sa_inst_pymt1_action.setINSERT_ALLOWED(true);
		    pt_il_pol_sa_inst_pymt1_action.setUPDATE_ALLOWED(true);
		    pt_il_pol_sa_inst_pymt1_action.setDELETE_ALLOWED(true);
		}
		if (CommonUtils.nvl(pt_il_policy_bean.getPOL_END_NO_IDX(), 0) > 0
			&& !"001".equals(CommonUtils.nvl(pt_il_policy_bean
				.getPOL_END_TYPE(), "000"))) {
		    pt_il_pol_sa_inst_pymt1_action.setINSERT_ALLOWED(false);
		    pt_il_pol_sa_inst_pymt1_action.setUPDATE_ALLOWED(false);
		    pt_il_pol_sa_inst_pymt1_action.setDELETE_ALLOWED(false);
		}
	    }

	} catch (Exception e) {
	      e.printStackTrace();
	      throw new Exception(e.getMessage());
	}
    }

    public void whenNewBlockInstance(
	    PILQ003_COMPOSITE_ACTION compositeAction) {
	/*PT_IL_POLICY pt_il_policy_bean = compositeAction
		.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
	PT_IL_POL_SA_INST_PYMT1 pt_il_pol_sa_inst_pymt1_bean = compositeAction
		.getPT_IL_POL_SA_INST_PYMT1_ACTION_BEAN()
		.getPT_IL_POL_SA_INST_PYMT1_BEAN();*/
	/*
	 * if(:SYSTEM.FORM_STATUS IN ('CHANGED')){ :CTRL.M_COMM_DEL := 'P';
	 * COPY('20','SYSTEM.MESSAGE_LEVEL'); POST; :CTRL.M_COMM_DEL := NULL; --
	 * EXECUTE_QUERY; COPY('0','SYSTEM.MESSAGE_LEVEL'); }
	 */
    }
    
    public void whenValidateSIPD_NUMR_PERIOD(PT_IL_POL_SA_INST_PYMT1 PT_IL_POL_SA_INST_PYMT1_BEAN ,
    									PT_IL_POLICY PT_IL_POLICY_BEAN ) throws Exception{
    	try{
    	if(PT_IL_POL_SA_INST_PYMT1_BEAN.getSIPD_NUMR_PERIOD() != null){
    		if(CommonUtils.nvl(PT_IL_POL_SA_INST_PYMT1_BEAN.getSIPD_NUMR_PERIOD(),0) < 0 || 
    				CommonUtils.nvl(PT_IL_POL_SA_INST_PYMT1_BEAN.getSIPD_NUMR_PERIOD(),0) >= 
    					CommonUtils.nvl(PT_IL_POLICY_BEAN.getPOL_PERIOD(), 0)){
    			throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",new Object[]{
    			  "Installment Period","Greater than 0 and  Less than or equal to",PT_IL_POLICY_BEAN.getPOL_PERIOD()}));
    			
    		}
    	}
    }catch(Exception e){
    	e.printStackTrace();
    	throw new Exception(e.getMessage());
    }
    }
    	
    	
    	
    
    

}
