package com.iii.pel.forms.PILQ003;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_POL_FUND_DTL_1_HELPER {


	public void executeQuery(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		new PT_IL_POL_FUND_DTL_1_DELEGATE().executeSelectStatement(compositeAction);

		List<PT_IL_POL_FUND_DTL_1> dataList = compositeAction.
		getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getDataList_PT_IL_POL_FUND_DTL_1();
		if(dataList!=null && dataList.size() > 0){
			PT_IL_POL_FUND_DTL_1 PT_IL_POL_FUND_DTL_1_BEAN = dataList.get(0);
			PT_IL_POL_FUND_DTL_1_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN()
			.setPT_IL_POL_FUND_DTL_1_BEAN(PT_IL_POL_FUND_DTL_1_BEAN);
		}
	}

	public void POST_QUERY(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = 
			compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		String query1 = " SELECT FS_DESC FROM PM_IL_FUND_SETUP WHERE FS_CODE =? ";
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{pt_il_pol_fund_dtl_1_bean.getPOFD_FUND_CODE()};
			rs = new CRUDHandler().executeSelectStatement(query1, connection,values);
			if(rs.next()){
				pt_il_pol_fund_dtl_1_bean.setUI_M_FUND_DESC(rs.getString(1));
			}
			// PENDING
			/*	 P_GET_DEL_RECORD_PROPERTY('PT_IL_POL_FUND_DTL_1',
		                             'PT_IL_POL_FUND_DTL_1.POFD_DEL_FLAG',
		                             :PT_IL_POLICY.POL_END_NO_IDX);*/
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {CommonUtils.closeCursor( rs);} catch (Exception e) {e.printStackTrace();}
		}
	}
	public  void   PRE_INSERT(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = 
			compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		PT_IL_POLICY pt_il_policy_bean = 
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ResultSet rs = null;
		Connection connection = null;
		CommonUtils commonUtils = new CommonUtils();
		String query1 = " SELECT PIL_POAD_SYS_ID.NEXTVAL FROM DUAL";
		try {
			connection = CommonUtils.getConnection();
			pt_il_pol_fund_dtl_1_bean.setPOFD_POL_SYS_ID( pt_il_policy_bean.getPOL_SYS_ID());
			pt_il_pol_fund_dtl_1_bean.setPOFD_CR_DT(commonUtils.getCurrentDate());
			pt_il_pol_fund_dtl_1_bean.setPOFD_CR_UID(CommonUtils.getControlBean().getM_USER_ID());; 
			pt_il_pol_fund_dtl_1_bean.setPOFD_FUND_DIR_TYPE("T");   

			rs = new CRUDHandler().executeSelectStatement(query1, connection);
			if(rs.next()){
				pt_il_pol_fund_dtl_1_bean.setPOFD_SYS_ID(rs.getLong(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		finally{
			try {CommonUtils.closeCursor( rs);} catch (Exception e) {e.printStackTrace();}
		}
	}
	public  void   PRE_UPDATE(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = 
			compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		try {

			pt_il_pol_fund_dtl_1_bean.setPOFD_UPD_DT(commonUtils.getCurrentDate());
			pt_il_pol_fund_dtl_1_bean.setPOFD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());  
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void PRE_BLOCK(PILQ003_COMPOSITE_ACTION compositeAction) {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = 
			compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		try {
			/* IF FORM_FAILURE THEN
                       :GLOBAL.M_FAILURE := 'TRUE';
                    END IF;
                    :CTRL.M_DELETE_MSG_FLAG := 'N';*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public  void   WHEN_NEW_BLOCK_INSTANCE(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL_1_ACTION pt_il_pol_fund_dtl_1_action = compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN();
		DUMMY dummy_bean = compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();

		try {
			/* IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
		    COPY('P','CTRL.M_COMM_DEL') ;
	      COPY('20','SYSTEM.MESSAGE_LEVEL');
	      POST;                   
	      COPY('0','SYSTEM.MESSAGE_LEVEL');
	      COPY('','CTRL.M_COMM_DEL') ;
	   END IF;*/
			if("N".equals(dummy_bean.getUI_M_PROD_TOPUP_YN())){
				pt_il_pol_fund_dtl_1_action.setINSERT_ALLOWED( false);	
				pt_il_pol_fund_dtl_1_action.setUPDATE_ALLOWED( false);	
				pt_il_pol_fund_dtl_1_action.setDELETE_ALLOWED( false);	
			}
			else{
				if("Y".equals( CommonUtils.SUBSTR(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE") , 1, 1) )){
					pt_il_pol_fund_dtl_1_action.setINSERT_ALLOWED( true);	
				}
				if("Y".equals( CommonUtils.SUBSTR(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE"),2,1))){
					pt_il_pol_fund_dtl_1_action.setUPDATE_ALLOWED( true);	
				}
				if("Y".equals( CommonUtils.SUBSTR(CommonUtils.getGlobalVariable("GLOBAL.M_PRIVILEGE") ,3,1))){
					pt_il_pol_fund_dtl_1_action.setDELETE_ALLOWED( true);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	public void PRE_QUERY(PILQ003_COMPOSITE_ACTION compositeAction) {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = 
			compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		PT_IL_POLICY pt_il_policy_bean = 
			compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		pt_il_pol_fund_dtl_1_bean.setPOFD_POL_SYS_ID(pt_il_policy_bean.getPOL_SYS_ID());
		pt_il_pol_fund_dtl_1_bean.setPOFD_FUND_DIR_TYPE("T");
	}
	public  void  WHEN_NEW_RECORD_INSTANCE(PT_IL_POL_FUND_DTL_1_ACTION pt_il_pol_fund_dtl_1_action) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = 
			pt_il_pol_fund_dtl_1_action.getPT_IL_POL_FUND_DTL_1_BEAN();

		try {
			//PENDINF POST
			/*IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
		   COPY('P','CTRL.M_COMM_DEL') ;
		   COPY('20','SYSTEM.MESSAGE_LEVEL');
		   POST;                   
		   COPY('','CTRL.M_COMM_DEL') ;
		   COPY('0','SYSTEM.MESSAGE_LEVEL'); 
		END IF;*/
			if (pt_il_pol_fund_dtl_1_bean.getPOFD_FUND_CODE() !=null){
				pt_il_pol_fund_dtl_1_action.getCOMP_POFD_FUND_PERC().setRequired( true);
				pt_il_pol_fund_dtl_1_action.getCOMP_POFD_EFF_FM_DT().setRequired( true);
				pt_il_pol_fund_dtl_1_action.getCOMP_POFD_EFF_TO_DT().setRequired( true);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public  void WHEN_CREATE_RECORD(PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean) {
		pt_il_pol_fund_dtl_1_bean.setPOFD_FUND_DIR_TYPE("T");
	}
	//PENDING
	public  void KEY_DELREC(PILQ003_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();

		try {

			/*IF :PT_IL_POLICY.POL_END_TYPE = '001' AND :PT_IL_POLICY.POL_APPRV_STATUS <> 'A' THEN 

		  P_SET_DEL_RECORD_PROPERTY('PT_IL_POL_FUND_DTL_1.POFD_DEL_FLAG',
		                           'PT_IL_POL_FUND_DTL_1',
		                           :PT_IL_POLICY.POL_END_NO_IDX,
		                           'D');
		ELSE 

			IF (:PT_IL_POLICY.POL_END_TYPE IN ('000') OR :PT_IL_POLICY.POL_DS_TYPE = '1') AND :PT_IL_POLICY.POL_APPRV_STATUS <> 'A' THEN 
		       KEY_DELREC;
			END IF;

		END IF;*/


		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public  void   POFD_FUND_CODE_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction,String currValue) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		PT_IL_POL_FUND_DTL_1_ACTION pt_il_pol_fund_dtl_1_action = compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		pt_il_pol_fund_dtl_1_bean.setPOFD_FUND_CODE( currValue);
		String query1 = "  SELECT FS_DESC  FROM   PM_IL_FUND_SETUP WHERE  FS_CODE = ?   ";

		String query2 = " SELECT PROD_FUND_ALLOWED FROM PM_IL_PRODUCT" +
		"   WHERE PROD_CODE = ? ";	
		String M_PROD_FUND_ALLOWED =null;
		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{ pt_il_policy_bean.getPOL_PROD_CODE()};
			rs = new CRUDHandler().executeSelectStatement(query2, connection,values);
			if(rs.next()){
				M_PROD_FUND_ALLOWED = rs.getString(1);
			}
			if(pt_il_pol_fund_dtl_1_bean.getPOFD_FUND_CODE() != null){
				if("M".equals(M_PROD_FUND_ALLOWED)) { //         -- IF AONDITION ADDED BY ABHINAV FOR STM FSD 22
					pt_il_pol_fund_dtl_1_action.getCOMP_POFD_FUND_PERC().setRequired( true);
					pt_il_pol_fund_dtl_1_bean.setPOFD_FUND_PERC( null);

				}
				else if( "S".equals(M_PROD_FUND_ALLOWED )){                           
					pt_il_pol_fund_dtl_1_bean.setPOFD_FUND_PERC( 100d);                      
					pt_il_pol_fund_dtl_1_action.getCOMP_POFD_FUND_PERC().setDisabled( true);
				}
				pt_il_pol_fund_dtl_1_action.getCOMP_POFD_EFF_FM_DT().setRequired( true);
				pt_il_pol_fund_dtl_1_bean.setPOFD_EFF_FM_DT( null);
				pt_il_pol_fund_dtl_1_action.getCOMP_POFD_EFF_TO_DT().setRequired( true);
				pt_il_pol_fund_dtl_1_bean.setPOFD_EFF_TO_DT( null);

				values = new Object[]{  pt_il_pol_fund_dtl_1_bean.getPOFD_FUND_CODE()};
				rs = new CRUDHandler().executeSelectStatement(query1, connection,values);
				if(rs.next()){
					pt_il_pol_fund_dtl_1_bean.setUI_M_FUND_DESC( rs.getString(1));
				}    
				else if(rs==null){
					throw new Exception(
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"91423",
									new Object[] {
											CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));
				}

			}
			values = new Object[]{};
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			try {CommonUtils.closeCursor( rs);} catch (Exception e) {e.printStackTrace();}
		}
	}

	public  void   POFD_FUND_PERC_WHEN_VALIDATE_ITEM( Double currValue) throws Exception {
		try {
			if(  currValue <= 0 ||  currValue  > 100) {
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,
						"71070",new Object[] {CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")}));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public  void    POFD_EFF_FM_DT_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction,Date currValue) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		ResultSet rs = null;
		Object[] values = {};
		Connection connection = null;
		String M_DUMMY =null;
		Date M_POFD_EFF_TO_DT =null;

		String query1 = "  SELECT MAX(POFD_EFF_TO_DT) + 1  FROM   PT_IL_POL_FUND_DTL " +
		" WHERE  POFD_FUND_CODE  = ? " +
		"  AND    POFD_POL_SYS_ID =? " + 
		"   AND    POFD_FUND_DIR_TYPE = 'T' ";

		String query2 = "  SELECT 'X'  FROM   PT_IL_POL_FUND_DTL " +
		" WHERE  POFD_FUND_CODE  = ? " +
		"  AND    POFD_POL_SYS_ID = ? " +
		"     AND    POFD_FUND_DIR_TYPE = 'T'     AND" +
		"    POFD_EFF_TO_DT = ? ";

		pt_il_pol_fund_dtl_1_bean.setPOFD_EFF_FM_DT( currValue);

		try {
			connection = CommonUtils.getConnection();
			values = new Object[]{};
			if(  currValue !=null){
				if( currValue.after(pt_il_pol_fund_dtl_1_bean.getPOFD_EFF_TO_DT())){
					throw new Exception(
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"91010",
									new Object[] {
											CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));
					/* STD_MESSAGE_ROUTINE(91010,:CTRL.M_LANG_CODE);
		         RAISE FORM_TRIGGER_FAILURE;*/
				}
				else if( currValue.before(pt_il_policy_bean.getPOL_START_DT())){
					throw new Exception(
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"91439",
									new Object[] {
											CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),pt_il_policy_bean.getPOL_START_DT()  }));
				}
			}
			values = new Object[]{pt_il_pol_fund_dtl_1_bean.getPOFD_FUND_CODE(), pt_il_policy_bean.getPOL_SYS_ID()  ,
					pt_il_policy_bean.getPOL_EXPIRY_DT() };

			rs = new CRUDHandler().executeSelectStatement(query2, connection, values);
			if(rs.next()){
				M_DUMMY =rs.getString(1);
				throw new Exception(
						Messages.getString(
								PELConstants.pelErrorMessagePath,
								"91438",
								new Object[] {
										CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),pt_il_pol_fund_dtl_1_bean.getPOFD_FUND_CODE()  }));
			}    
			else{ 
				values = new Object[]{ pt_il_pol_fund_dtl_1_bean.getPOFD_FUND_CODE(),
						pt_il_policy_bean.getPOL_SYS_ID() };
				rs = new CRUDHandler().executeSelectStatement(query1, connection, values);
				if(rs.next()){ 
					M_POFD_EFF_TO_DT =rs.getDate(1);
				}
				if( !M_POFD_EFF_TO_DT.equals(pt_il_pol_fund_dtl_1_bean.getPOFD_EFF_FM_DT())){
					throw new Exception(
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"91437",
									new Object[] {
											CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE") }));
				}
			}



		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public  void  POFD_EFF_TO_DT_WHEN_VALIDATE_ITEM(PILQ003_COMPOSITE_ACTION compositeAction,Date currValue) throws Exception {
		PT_IL_POL_FUND_DTL_1 pt_il_pol_fund_dtl_1_bean = compositeAction.getPT_IL_POL_FUND_DTL_1_ACTION_BEAN().getPT_IL_POL_FUND_DTL_1_BEAN();
		PT_IL_POLICY pt_il_policy_bean = compositeAction.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		//  pt_il_pol_fund_dtl_1_bean.setPOFD_EFF_TO_DT( currValue);
		try {

			if(currValue !=null){
				if( currValue.before(pt_il_pol_fund_dtl_1_bean.getPOFD_EFF_FM_DT())){
					throw new Exception(
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"91001",
									new Object[] {
											CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE")  }));
					/*STD_MESSAGE_ROUTINE(91001,:CTRL.M_LANG_CODE);
		      RAISE FORM_TRIGGER_FAILURE;*/
				}
				else if (currValue.after( pt_il_policy_bean.getPOL_EXPIRY_DT())){
					throw new Exception(
							Messages.getString(
									PELConstants.pelErrorMessagePath,
									"71196",
									new Object[] {
											CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"),pt_il_policy_bean.getPOL_EXPIRY_DT()  }));

					/*STD_MESSAGE_ROUTINE(71196,:CTRL.M_LANG_CODE,:PT_IL_POLICY.POL_EXPIRY_DT);
		      RAISE FORM_TRIGGER_FAILURE;*/
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}


}
