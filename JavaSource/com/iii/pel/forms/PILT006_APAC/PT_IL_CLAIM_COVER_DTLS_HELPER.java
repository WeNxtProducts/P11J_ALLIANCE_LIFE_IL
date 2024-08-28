package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.utils.P9ILPK_CLAIM;
import com.iii.pel.utils.P9ILPK_FUND_ALLOC;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;

public class PT_IL_CLAIM_COVER_DTLS_HELPER extends CommonAction {
	/**
	 * 
	 */
	private static final Log log = LogFactory.getLog(PT_IL_CLAIM_HELPER.class); 
	
	
	public void preInsert(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String C1 = "SELECT PIL_CCD_SYS_ID.NEXTVAL FROM DUAL";
		ResultSet C1_REC = null;
		PILT006_APAC_PROCEDURE pilt006_apac_helper = new PILT006_APAC_PROCEDURE();
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			C1_REC = handler.executeSelectStatement(C1, connection);
			if (C1_REC.next()) {
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_SYS_ID(C1_REC.getLong(1));
			}
			
			pilt006_apac_helper.L_UNIQUE_SET_CODES(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN(),
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN());
			pilt006_apac_helper.L_CLM_EST_COVER_VALID(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), 
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN());
			pilt006_apac_helper.L_CLM_EST_LOSS_VALID(null);
			pilt006_apac_helper.L_CLM_EST_DISABLE_VALID(null);
			
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_CLAIM_SYS_ID(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID());
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_CR_DT(new CommonUtils().getCurrentDate());
			compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_CR_UID(compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN().getUSER_ID());
			
			if("Y".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FRZ_FLAG()) &&
					"Y".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CONFIRM_FLAG())){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_RESERVE_DT(new CommonUtils().getCurrentDate());
			}
			
		}catch(DBException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch(SQLException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch(ParseException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}

	public void postInsert() {
	}
	

	
	public void preUpdate(PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN) throws Exception {
		String C1 = "SELECT CCDH_O_LC_EST_AMT "
				+ "FROM   PH_IL_CLAIM_COVER_DTLS WHERE  CCDH_SYS_ID  =  ? "
				+ "AND CCDH_CLAIM_SYS_ID  = ? AND    CCDH_COVER_CODE	  = ? "
				+ "AND CCDH_REF_NO  = (SELECT MAX(CCDH_REF_NO) FROM PH_IL_CLAIM_COVER_DTLS "
				+ "WHERE CCDH_SYS_ID = ? AND CCDH_CLAIM_SYS_ID  = ? "
				+ "AND CCDH_COVER_CODE = ?)";
		ResultSet C1_REC = null;
		Double M_CCDH_O_LC_EST_AMT = 0.0;
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object [] obj = new Object[] {PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_SYS_ID(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CLAIM_SYS_ID(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_SYS_ID(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CLAIM_SYS_ID(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE()};
	
			
			C1_REC = handler.executeSelectStatement(C1, connection,obj);
			if (C1_REC.next()) {
				M_CCDH_O_LC_EST_AMT = C1_REC.getDouble("CCDH_O_LC_EST_AMT");
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCDH_O_LC_EST_AMT(M_CCDH_O_LC_EST_AMT);
			}
			
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_UPD_DT(new CommonUtils().getCurrentDate());
			PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_UPD_UID(CommonUtils.getControlBean().getUSER_ID());
			
			Double CCD_LC_EST_AMT = PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LC_EST_AMT();
			
			if((M_CCDH_O_LC_EST_AMT!=CCD_LC_EST_AMT)  || (PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RESERVE_DT()==null)){
				if("Y".equalsIgnoreCase(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FRZ_FLAG()) && 
						"Y".equalsIgnoreCase(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_CONFIRM_FLAG())){
					PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_RESERVE_DT(new CommonUtils().getCurrentDate());
				}
			}
			
		}catch(DBException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch(SQLException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch(ParseException e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(C1_REC!=null){
				C1_REC.close();
			}
		}
	}
	
	
	
	public void preBlock(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String M_TEMP =null;
		ResultSet C1_REC = null;
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			
			String C1 = "SELECT 'X' FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ? "
					+ "AND NVL(CP_APPR_FLAG,'N')IN ('A' ,'R') "
					+ "AND NVL(CP_CLM_PAID_STATUS,'N')='A'";
			if(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()!=null){
				Object [] obj = new Object[] {compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()};

				C1_REC = handler.executeSelectStatement(C1, connection,obj);
				if (C1_REC.next()) {
					M_TEMP = C1_REC.getString(1);
				}
				
				if("X".equals(CommonUtils.nvl(M_TEMP, "N"))){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().disableAllComponent(true);
				}
				
				
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
	}

	/**
	 * It calls when new record create.
	 * @throws Exception 
	 */
	public void whenCreateRecord(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_FRZ_FLAG("N");
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_CLOSE_FLAG("N");
		//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_PERIOD_UNIT("W");
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_CONFIRM_FLAG("N");
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_RESERVE_GEN_FLAG("N");
		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().setCCD_CLAIM_PAY_TO("A");
	}
	
	/**
	 * When new record instance.
	 */
	public void whenNewRecordInstance(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
		
		String M_TEMP=null;
		String M_DUMMY = null;
		String M_CURR_BLK = null;
		String M_CURR_ITEM = null;
		String M_TEMP_ITEM = null;
		String  M_HIST_REC = null;
		String  M_FAC_REC = null;
		String  M_RI_REC = null;
		
		String C1 = "SELECT 'X' FROM PT_IL_CLAIM_COVER_DTLS WHERE  "
				+ "CCD_CLAIM_SYS_ID = ? AND CCD_SYS_ID = ? "
				+ "AND CCD_LOSS_TYPE =(SELECT PS_CODE_DESC "
				+ "FROM PP_SYSTEM  WHERE PS_TYPE = 'IL_FEB_LOSTY')";
		
		String C2 = "SELECT 'X' FROM   PT_IL_CLAIM_COVER_DTLS "
				+ "WHERE  CCD_CLAIM_SYS_ID = ? AND    CCD_SYS_ID = ? "
				+ "AND    CCD_LOSS_TYPE =  (SELECT PS_CODE_DESC  "
				+ " FROM   PP_SYSTEM  WHERE  PS_TYPE = 'IL_PTPD_LOTY')";
		
		String C3 = "SELECT POL_MASTER_POL_NO FROM   PT_IL_POLICY "+
					"WHERE  POL_SYS_ID = ? ";
		
		String C4 = "SELECT COVER_CLASS,COVER_SA_CALC FROM PM_IL_COVER "+
					"WHERE  COVER_CODE = ?";
		
		String C5 = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE  POL_NO = ?";
		
		String C6 = "SELECT  POAC_MED_DAYS FROM    PT_IL_POL_ADDL_COVER WHERE " +
				"POAC_COVER_CODE = ? AND POAC_POL_SYS_ID = M_POL_SYS_ID";
		
		String C7 = "SELECT SUM(CCD_NO_OF_DAYS) "
				+ "FROM   PT_IL_CLAIM_COVER_DTLS  WHERE  CCD_COVER_CODE  = ? "
				+ "AND    CCD_CLAIM_SYS_ID  IN (SELECT CLAIM_SYS_ID " +
				"FROM   PT_IL_CLAIM WHERE  CLAIM_POL_NO = ? "
				+ "AND    CLAIM_ADDL_STATUS = 'CL05')";
		
		String C8 = "SELECT 'X' FROM  PH_IL_CLAIM_COVER_DTLS "
				+ "WHERE CCDH_CLAIM_SYS_ID = ? AND CCDH_COVER_CODE = ?";
		
		String C9 = "SELECT 'X' FROM   PT_IL_FAC_CLAIM_EST "
				+ "WHERE  FCE_CLAIM_SYS_ID = ? AND FCE_CCD_COVER_CODE = ?";
		
		String C10 ="SELECT 'X' FROM PT_IL_TTY_CLAIM_EST WHERE  "+
			"TCE_CLAIM_SYS_ID = ? AND TCE_CCD_COVER_CODE = ?";
		
		String C11 = "SELECT   CR_WAITING_YN,CR_LIEN_YN "+
						"FROM   PM_IL_CLM_REPAY "+
						"WHERE  CR_COVER_CODE   = ? "+
						"AND    CR_LOSS_TYPE    = ? "+
						"AND    CR_DISABLE_TYPE = ? ";
		
		ResultSet C1_REC=null;
		ResultSet C2_REC=null;
		ResultSet C3_REC=null;
		ResultSet C4_REC=null;
		ResultSet C5_REC=null;
		ResultSet C6_REC=null;
		ResultSet C7_REC=null;
		ResultSet C8_REC=null;
		ResultSet C9_REC=null;
		ResultSet C10_REC=null;
		ResultSet C11_REC=null;
		Double M_POL_SYS_ID = 0.0;
		String M_POL_MASTER_POL_NO = null;
		
		try{
			/*M_CURR_BLK    := :SYSTEM.CURSOR_BLOCK;
			M_CURR_ITEM   := :SYSTEM.CURSOR_ITEM;*/
			
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object [] obj_c1 = new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID(),
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_CLAIM_SYS_ID()};
			
			C1_REC = handler.executeSelectStatement(C1, connection,obj_c1);
			if (C1_REC.next()) {
				M_TEMP = C1_REC.getString(1);
			}
			
			//Object [] obj_c2 = new Object[]{};
			C2_REC = handler.executeSelectStatement(C2, connection,obj_c1);
			if (C2_REC.next()) {
				M_DUMMY = C2_REC.getString(1);
			}
			
			Object [] obj_c3 = new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()};
			C3_REC = handler.executeSelectStatement(C3, connection,obj_c3);
			if (C3_REC.next()) {
				M_POL_MASTER_POL_NO = C3_REC.getString("POL_MASTER_POL_NO");
			}
			
			Object [] obj_c5 = new Object[]{compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_NO()};
			C5_REC = handler.executeSelectStatement(C5, connection,obj_c5);
			if (C5_REC.next()) {
				M_POL_SYS_ID = C5_REC.getDouble("POL_SYS_ID");
			}
			
			if("X".equals(CommonUtils.nvl(M_DUMMY, "Y")) && M_POL_MASTER_POL_NO!=null 
					|| "X".equals(CommonUtils.nvl(M_TEMP,"Y"))){
				
			/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/		
			//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
			//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
			String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
			if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}//end
			}else{
			
				
				if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							}else{
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
							}//end
				}
				if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
							}else{
								compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
							}//end
				}
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}else{
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
						}//end
			}
			/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/	
			if("Y".equals(CommonUtils.nvl(pt_il_claim.getCLAIM_CLOSE_FLAG(), "N"))
					||  ("CL05".equalsIgnoreCase(pt_il_claim.getCLAIM_ADDL_STATUS()))){
				// end
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}else{
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
							compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CONFIRM_FLAG().setDisabled(true);
			}else{
				if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					}//end
				}
				if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					}//end
				}
				if(!compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					}//end
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setRequired(false);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setRequired(false);
				}
				
				if(!(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().isDisabled())){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().setDisabled(false);
				}
				if(!(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CONFIRM_FLAG().isDisabled())){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CONFIRM_FLAG().setDisabled(false);
				}
			}
			
			if("PA".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_SET_FLAG(), "X"))){
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);	
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				}//end
			}
			if("Y".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_FRZ_FLAG(), "X"))){
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_COVER_CODE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LOSS_TYPE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_DISAB_TYPE().setDisabled(true);
			}else{
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);	
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				}//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_COVER_CODE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LOSS_TYPE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_DISAB_TYPE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_PERIOD_UNIT().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CLAIM_PAY_TO().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_PERIOD().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_NO_OF_DAYS().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RESERVE_DT().setDisabled(false);
			}
			Object [] obj_c4 = new Object[]{pt_il_claim_cover_dtls.getCCD_COVER_CODE()};
			String M_COVER_CLASS = null;
			String M_COVER_SA_CALC = null;
			String M_CR_WAITING_YN = null;
			String M_CR_LIEN_YN = null;
			
			C4_REC = handler.executeSelectStatement(C4, connection,obj_c4);
			if (C4_REC.next()) {
				M_COVER_CLASS = C4_REC.getString(1);
				M_COVER_SA_CALC = C4_REC.getString(2);
			}
			if("M".equals(CommonUtils.nvl(M_COVER_CLASS, "X"))){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_NO_OF_DAYS().setDisabled(false);
			}else{
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_NO_OF_DAYS().setDisabled(false);
			}
		
			Object [] obj_c8 = new Object[]{pt_il_claim.getCLAIM_SYS_ID(),
									pt_il_claim_cover_dtls.getCCD_COVER_CODE()};
			C8_REC = handler.executeSelectStatement(C8, connection,obj_c8);
			if (C8_REC.next()) {
				M_HIST_REC = C8_REC.getString(1);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_HISTORY().setDisabled(false);
			}else{
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_HISTORY().setDisabled(true);
			}
			
			Object [] obj_c9 = new Object[]{pt_il_claim.getCLAIM_SYS_ID(),
					pt_il_claim_cover_dtls.getCCD_COVER_CODE()};
			C9_REC = handler.executeSelectStatement(C9, connection, obj_c9);
			if (C9_REC.next()) {
				M_FAC_REC = C9_REC.getString(1);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_UI_M_BUT_FAC().setDisabled(false);
			} else {
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_UI_M_BUT_FAC().setDisabled(true);
			}
			
			Object [] obj_c10 = new Object[]{pt_il_claim.getCLAIM_SYS_ID(),
					pt_il_claim_cover_dtls.getCCD_COVER_CODE()};
			C10_REC = handler.executeSelectStatement(C10, connection, obj_c10);
			if (C10_REC.next()) {
				M_RI_REC = C10_REC.getString(1);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_UI_M_BUT_RI().setDisabled(false);
			} else {
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
						.getCOMP_UI_M_BUT_RI().setDisabled(true);
			}
			
			if("O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE())){
				if(pt_il_claim_cover_dtls.getCCD_COVER_CODE()!=null 
						&& pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()!=null
						&& pt_il_claim_cover_dtls.getCCD_DISAB_TYPE()!=null){
					Object [] obj_c11 = new Object[]{pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
													 pt_il_claim_cover_dtls.getCCD_LOSS_TYPE(),
													 pt_il_claim_cover_dtls.getCCD_DISAB_TYPE()};
					C11_REC = handler.executeSelectStatement(C11, connection, obj_c11);
					if (C11_REC.next()) {
						M_CR_WAITING_YN = C11_REC.getString(1);
						M_CR_LIEN_YN =  C11_REC.getString(2);
					}
				}
			}
			
			if("O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE()) &&
					( "D".equals(CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_PLAN_TYPE(), "X")) || 
							"G".equals(CommonUtils.nvl(M_COVER_SA_CALC, "X")))){
				if(!compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().isDisabled()
						&& !compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}//end
				}
			}else{
				if(!compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().isDisabled()
						&& !compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					}//end
				}
			}
			
			if("Y".equals(CommonUtils.nvl(M_CR_WAITING_YN, "N")) &&
					"Y".equals(CommonUtils.nvl(M_CR_LIEN_YN, "N"))){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE_PER().setDisabled(true);
			}else{
			/*added by raja on 15-06-2017 for ZBILQC-1728216*/
				
				/*uncommented by Janani on 08.03.2019 for KIC */
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE_PER().setDisabled(false);
				/*End*/
				
				/*end*/
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C8_REC);
			CommonUtils.closeCursor(C9_REC);
			CommonUtils.closeCursor(C10_REC);
			CommonUtils.closeCursor(C11_REC);
		}
		
	}

	/**
	 * It used when call the post query.
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void postQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		PT_IL_CLAIM_COVER_DTLS coverBean = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
		PT_IL_CLAIM claimBean = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		
		int M_PS_VALUE;
		String M_HIST_REC = null;
		String M_FAC_REC = null;
		String M_RI_REC = null;
		String C1 = "SELECT 'X' FROM  PH_IL_CLAIM_COVER_DTLS WHERE CCDH_CLAIM_SYS_ID = ? ";
		String C2 = "SELECT 'X' FROM   PT_IL_FAC_CLAIM_EST WHERE  FCE_CLAIM_SYS_ID = ? ";
		String C3 = " SELECT 'X' FROM   PT_IL_TTY_CLAIM_EST WHERE  TCE_CLAIM_SYS_ID = ? ";
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ArrayList<String> pList = new ArrayList<String>();
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			
			DBProcedures procedures = new DBProcedures();
			PILT006_APAC_PROCEDURE claimProcedure = new PILT006_APAC_PROCEDURE();
			
			pList = procedures.callP_VAL_COVER_PROC(coverBean.getCCD_COVER_CODE(), 
					coverBean.getUI_M_CCD_COVER_CODE_DESC(), 
					null, "N", "N");
			if(!pList.isEmpty() && pList.size() > 0){
				coverBean.setUI_M_CCD_COVER_CODE_DESC(pList.get(0));
			}
			pList.clear();
			pList = procedures.P_VAL_CODES_PROC_CALL("IL_LOS_TYP",
												coverBean.getCCD_LOSS_TYPE(), 
												"N", 
												"N");
			if(!pList.isEmpty() && pList.size() > 0){
				coverBean.setUI_M_CCD_LOSS_TYPE_DESC(pList.get(0));
			}
			pList.clear();
			pList = procedures.P_VAL_CODES_PROC_CALL("IL_DIS_TYP",
					coverBean.getCCD_DISAB_TYPE(),
					"N", 
					"N");
			if(!pList.isEmpty() && pList.size() > 0){
				coverBean.setUI_M_CCD_DISAB_TYPE_DESC(pList.get(0));
			}
			claimProcedure.L_CLOSE_FLAG_CHK();//Call Procedure
			/*aDDED BY SANKARA NARAYANAN FOR DISABLE ALL COMPONENT AFTER APPROVAL 05-03-207*/
			if("Y".equals(CommonUtils.nvl(claimBean.getCLAIM_CLOSE_FLAG(), "N"))
					||  ("CL05".equalsIgnoreCase(claimBean.getCLAIM_ADDL_STATUS()))){
				//end
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				String ps_value_1=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CONFIRM_FLAG().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CLOSE_DT().setDisabled(true);
			}else{
				/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
				//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
				String ps_value_1=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
				if(ps_value_1!=null && ps_value_1.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
				}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
						}//end
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setRequired(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setRequired(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().setDisabled(false);
				if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().isDisabled()){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().setDisabled(false);
				}
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FRZ_FLAG().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CONFIRM_FLAG().setDisabled(false);
			}
			
				Object[] obj_C1 = new Object[]{claimBean.getCLAIM_SYS_ID()};
				
				C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);
				if (C1_REC.next()) {
					M_HIST_REC = C1_REC.getString(1);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_HISTORY().setDisabled(false);
				}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_HISTORY().setDisabled(true);
				}
				
				C2_REC = handler.executeSelectStatement(C2, connection,obj_C1);
				if (C2_REC.next()) {
					M_FAC_REC = C2_REC.getString(1);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_FAC().setDisabled(false);
				}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_FAC().setDisabled(true);
				}
				
				C3_REC = handler.executeSelectStatement(C1, connection,obj_C1);
				if (C3_REC.next()) {
					M_RI_REC = C3_REC.getString(1);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_RI().setDisabled(false);
				}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_UI_M_BUT_RI().setDisabled(true);
				}
				
			}catch(Exception e){
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{
				CommonUtils.closeCursor(C1_REC);
				CommonUtils.closeCursor(C2_REC);
				CommonUtils.closeCursor(C3_REC);
			}
		
		
	}
	

	public void preDelete() {
	}
	
		/*commentted by saritha on 08-02-2017 for RM018T - FSD_IL_ZB Life_012b_Claim Waiting period COMMENTS*/
		/*public void whenNewBlockInstance() throws DBException,ValidatorException,Exception{*/
		public void whenNewBlockInstance() throws Exception{
		String M_DUMMY = null;
		String M_TEMP = null;
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PILT006_APAC_COMPOSITE_ACTION compositeAction = ((PILT006_APAC_COMPOSITE_ACTION)sessionMap.get("PILT006_APAC_COMPOSITE_ACTION"));
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
		
		String C1 = " SELECT PLAN_TYPE FROM PM_IL_PLAN WHERE  NVL(PLAN_FRZ_FLAG,'N') = 'N' "
				+ "AND PLAN_CODE = (SELECT POL_PLAN_CODE FROM PT_IL_POLICY "
				+ "WHERE POL_NO = ? AND POL_DS_TYPE = '2')";

		String C2 = "SELECT POL_INCORPORATED_YN FROM   PT_IL_POLICY WHERE  "
				+ "POL_NO = ? AND POL_DS_TYPE = '2'";

		String C3 = "SELECT 'X' FROM PT_IL_CLAIM_COVER_DTLS WHERE  NVL(CCD_SET_FLAG,'SA') = 'PA' "
				+ "AND CCD_CLAIM_SYS_ID = ? ";

		String C4 = " SELECT 'X' FROM PT_IL_CLAIM_PAID WHERE CP_CLAIM_SYS_ID = ? "
				+ "AND NVL(CP_APPR_FLAG,'N')IN ('A' ,'R') AND NVL(CP_CLM_PAID_STATUS,'N')='A'";
		
		String C5 = "SELECT DISTINCT CLAIM_SYS_ID "
				+ "FROM   PT_IL_CLAIM,PT_IL_CLAIM_COVER_DTLS,PT_IL_POLICY,PM_IL_CLM_REPAY "
				+ "WHERE  CLAIM_POL_NO = ? "
				+ "AND CLAIM_POL_NO = POL_NO "
				+ "AND CCD_CLAIM_SYS_ID = CLAIM_SYS_ID "
				+ "AND CCD_FRZ_FLAG = 'Y' "
				+ "AND CCD_CONFIRM_FLAG = 'Y' "
				+ "AND CR_COVER_CODE = CCD_COVER_CODE "
				+ "AND CR_APPLIED_ON IN ('ANSA','ANSP','ASPP') "
				+ "AND CLAIM_TYPE = 'O' "
				+ "AND POL_DS_TYPE  = '2' "
				+ "AND POL_STATUS = 'A' "
				+ "AND NVL(CLAIM_CLOSE_FLAG, 'N') = 'N'";
		
		String C6 = "SELECT SUM(CP_FC_PAID_AMT),SUM(CP_LC_PAID_AMT) "
				+ "FROM   PT_IL_CLAIM_PAID  "
				+ "WHERE  CP_CLAIM_SYS_ID  = ? "
				+ "AND CP_SET_FLAG = ? "
				+ "AND CP_APPR_DT IS NOT NULL "
				+ "AND NVL(CP_APPR_FLAG,'N') IN ('R', 'A') "
				+ "AND NVL(CP_CLM_PAID_STATUS,'N') = 'A' "
				+ "GROUP BY CP_CLAIM_SYS_ID,CP_SET_FLAG";
		
		ResultSet C1_REC=null;
		ResultSet C2_REC=null;
		ResultSet C3_REC=null;
		ResultSet C4_REC=null;
		ResultSet C5_REC=null;
		ResultSet C6_REC=null;
		Double M_FC_CIC_AMT = null;
		Double M_LC_CIC_AMT = null;
		String M_ANN_EXIST=null;
		Double M_ANN_CLAIM_SYS_ID = 0.0;   
		Double M_FC_SA_PAID_AMT = 0.0;
		Double M_LC_SA_PAID_AMT = 0.0;
		Double M_FC_PA_PAID_AMT = 0.0;
		Double M_LC_PA_PAID_AMT  = 0.0;
		String M_POL_INCORPORATED_YN = null;
		Connection connection = CommonUtils.getConnection();
		PILT006_APAC_PROCEDURE procedure = new PILT006_APAC_PROCEDURE();
		try{
			
			CRUDHandler handler = new CRUDHandler();
			Object [] obj_C1 = new Object[]{ pt_il_claim.getCLAIM_POL_NO()};
			
			if(pt_il_claim.getCLAIM_POL_NO()!=null){
				C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);
				if (C1_REC.next()) {
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setM_PLAN_TYPE(C1_REC.getString("PLAN_TYPE"));
				}
				
				C2_REC = handler.executeSelectStatement(C2, connection,obj_C1);
				if (C2_REC.next()) {
					M_POL_INCORPORATED_YN = C2_REC.getString("POL_INCORPORATED_YN");
				}
				
				if(M_POL_INCORPORATED_YN==null){
					M_POL_INCORPORATED_YN = "N";
				}
				
				if(!"O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE())){
					List<OracleParameter> outputList = null;
					outputList = procedure.P_CALC_CIC_COVER(pt_il_claim.getCLAIM_POL_SYS_ID(),
																		 M_FC_CIC_AMT,
																		 M_LC_CIC_AMT);
					if (!(outputList.isEmpty()) && outputList != null) {
						M_FC_CIC_AMT = (Double) outputList.get(0).getValueObject();
						M_LC_CIC_AMT = (Double) outputList.get(1).getValueObject();
					}
				}
						
				if(pt_il_claim_cover_dtls.getROWID()==null){      
					if("M".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_PLAN_TYPE())){

						procedure.INS_CLM_CVR_RSA(
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_TYPE(), 
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT(),
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID(),
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID(),
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getUI_M_POL_SA_CURR_CODE(),
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_CURR_CODE(),
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_EXCH_RATE(),
								M_FC_CIC_AMT,
								M_LC_CIC_AMT, 
								compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ASSR_CODE(),
								M_POL_INCORPORATED_YN);
							
						/*changed by raja for funeral benifit fsd*/	
					}
					else if("L".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_PLAN_TYPE()) ||
							"H".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_PLAN_TYPE()))
							{
						PT_IL_CLAIM claimBean = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
						procedure.P_INS_CLM_CVR_DTLS(claimBean.getCLAIM_TYPE(),
																  claimBean.getCLAIM_LOSS_DT(),
																  claimBean.getCLAIM_POL_SYS_ID(), 
																  claimBean.getCLAIM_SYS_ID(),
																  claimBean.getUI_M_POL_SA_CURR_CODE(),
																  claimBean.getCLAIM_CURR_CODE(),
																  claimBean.getCLAIM_EXCH_RATE(),
																  M_FC_CIC_AMT,
																  M_LC_CIC_AMT,
																  claimBean.getCLAIM_ASSR_CODE()
																  ,claimBean.getCLAIM_MEMB_CODE());
							}
					else{
						
						/*end*/
												
							
							
							PT_IL_CLAIM claimBean = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
							procedure.P_INS_CLM_CVR_DTLS(claimBean.getCLAIM_TYPE(),
																	  claimBean.getCLAIM_LOSS_DT(),
																	  claimBean.getCLAIM_POL_SYS_ID(), 
																	  claimBean.getCLAIM_SYS_ID(),
																	  claimBean.getUI_M_POL_SA_CURR_CODE(),
																	  claimBean.getCLAIM_CURR_CODE(),
																	  claimBean.getCLAIM_EXCH_RATE(),
																	  M_FC_CIC_AMT,
																	  M_LC_CIC_AMT,
																	  claimBean.getCLAIM_ASSR_CODE(),null);
						}
				}
				Object [] obj_C5 = new Object[]{ pt_il_claim.getCLAIM_POL_NO()};
				C5_REC = handler.executeSelectStatement(C5, connection,obj_C5);
				if (C5_REC.next()) {
					M_ANN_CLAIM_SYS_ID = C5_REC.getDouble("CLAIM_SYS_ID");
				}
							
				String M_FLAG = "SA";
					
				if(1!=CommonUtils.nvl(M_ANN_CLAIM_SYS_ID, 1)){
					Object [] obj_C6 = new Object[]{ M_ANN_CLAIM_SYS_ID,M_FLAG};
					C6_REC = handler.executeSelectStatement(C6, connection,obj_C6);
					if (C6_REC.next()) {
						M_FC_SA_PAID_AMT = C6_REC.getDouble(1);
						M_LC_SA_PAID_AMT = C6_REC.getDouble(2);
					}

					Object [] obj_C6_A = new Object[]{ M_ANN_CLAIM_SYS_ID,"PA"};
					C6_REC = handler.executeSelectStatement(C6, connection,obj_C6_A);
					if (C6_REC.next()) {
						M_FC_PA_PAID_AMT = C6_REC.getDouble(1);
						M_LC_PA_PAID_AMT = C6_REC.getDouble(2);
					}
						
					if (0 > CommonUtils.nvl(M_FC_SA_PAID_AMT, 0)) {
						String updateQuery = "UPDATE PT_IL_CLAIM_COVER_DTLS "
							+ "SET CCD_FC_EST_AMT = CCD_FC_EST_AMT - NVL(?,0), "
							+ "CCD_LC_EST_AMT = CCD_LC_EST_AMT - NVL(?,0) "
							+ "WHERE  CCD_CLAIM_SYS_ID  = ? "
							+ "AND CCD_SET_FLAG      = 'SA'";
						Object[] obj = new Object[] { M_FC_SA_PAID_AMT,
													  M_LC_SA_PAID_AMT,
													  pt_il_claim.getCLAIM_SYS_ID() };
						int i = handler.executeUpdateStatement(updateQuery,connection, obj);
							if (i == 1) {
								log.info("UPDATE SA PAID SUCESSS");
							}
						}
						
						if (0 > CommonUtils.nvl(M_FC_PA_PAID_AMT, 0)) {
							String updateQuery = "UPDATE PT_IL_CLAIM_COVER_DTLS "
									+ "SET CCD_FC_EST_AMT = CCD_FC_EST_AMT - NVL(?,0), "
									+ "CCD_LC_EST_AMT = CCD_LC_EST_AMT - NVL(?,0) "
									+ "WHERE  CCD_CLAIM_SYS_ID  = ? "
									+ "AND CCD_SET_FLAG      = 'PA'";
							Object[] obj = new Object[] { M_FC_SA_PAID_AMT,
														  M_LC_SA_PAID_AMT,
														  pt_il_claim.getCLAIM_SYS_ID() };
							int i = handler.executeUpdateStatement(updateQuery,connection, obj);
							if (i == 1) {
								log.info("UPDATE PA VALUE SUCESSS");
							}
						}
							
						/*plantype condition handled by Ameen on 21-07-2017 for ZBILQC-1732301 as per Gaurav sugg.*/
						if(!"H".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_PLAN_TYPE())){
						String deleteQuery = "DELETE FROM PT_IL_CLAIM_COVER_DTLS WHERE " +
								"CCD_CLAIM_SYS_ID  = ? AND" +
								" CCD_SET_FLAG IN ('PA','SA') AND  CCD_FC_EST_AMT <= 0";
						Object[] obj = new Object[] { pt_il_claim.getCLAIM_SYS_ID() };
						
						int i = handler.executeDeleteStatement(deleteQuery, connection, obj);
						if (i == 1) {
							log.info("DELETE SUCCESS ");
						}
						}
					}
					
					
					Object [] obj_C3 = new Object[]{ M_ANN_CLAIM_SYS_ID};
					C3_REC = handler.executeSelectStatement(C3, connection,obj_C3);
					if (C3_REC.next()) {
						M_DUMMY = C3_REC.getString(1);
					}
					
					if("X".equalsIgnoreCase(CommonUtils.nvl(M_DUMMY, "Y")) && 
								"U".equalsIgnoreCase(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_PLAN_TYPE())){
						
					}
					Date date = pt_il_claim.getCLAIM_INTM_DT();
					
					procedure.INS_PT_IL_FUND_TRAN_DTL(
							pt_il_claim.getCLAIM_POL_SYS_ID(), 
						pt_il_claim.getCLAIM_SYS_ID(),
							"C",
							"S",
							date);//Need to check
					
					
					if("O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE())){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().disableAllComponent(false);
					}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().disableAllComponent(true);
					}
					
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_TYPE().setDisabled(true);
					
				}
				
				if(pt_il_claim.getCLAIM_SYS_ID()!=null){
					C4_REC = handler.executeSelectStatement(C4, connection,new Object[]{pt_il_claim.getCLAIM_SYS_ID()});
					if (C4_REC.next()) {
						M_TEMP = C4_REC.getString(1);
					}
					if("X".equalsIgnoreCase(CommonUtils.nvl(M_TEMP, "N"))){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().disableAllComponent(true);
					}
				}
		
		

           }catch(Exception e){
			/*throw new Exception("Eroorrrrrrrrr"+e.getMessage());*/
			/*Added by saritha on 08-02-2017 for RM018T - FSD_IL_ZB Life_012b_Claim Waiting period COMMENTS*/
			e.printStackTrace();
			e.getMessage();
			throw new Exception(e.getMessage());
			/*End*/
			//getErrorMap().put("current", e.getMessage());
		}finally{
			if(C1_REC!=null){
				C1_REC.close();
			}
			if(C2_REC!=null){
				C2_REC.close();
			}
			if(C3_REC!=null){
				C3_REC.close();
			}
			if(C4_REC!=null){
				C4_REC.close();
			}
			if(C5_REC!=null){
				C5_REC.close();
			}
			if(C6_REC!=null){
				C6_REC.close();
			}
			
			if(connection!=null){
				connection.commit();
			}
		}
	}
	
	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {

		new PT_IL_CLAIM_COVER_DTLS_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_CLAIM_COVER_DTLS> dataList = compositeAction
				.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
				.getDataList_PT_IL_CLAIM_COVER_DTLS();
		log.info("dataList Size=======>"+dataList.size());
		if (dataList != null && dataList.size() > 0) {
			PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN = dataList
					.get(0);
			PT_IL_CLAIM_COVER_DTLS_BEAN.setRowSelected(true);
			compositeAction
					.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN()
					.setPT_IL_CLAIM_COVER_DTLS_BEAN(PT_IL_CLAIM_COVER_DTLS_BEAN);
		}
	}
	
	/**
	 * Validate CCD Disable Type Item.
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateItemCCDDISABLETYPE(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		ResultSet C2_REC = null;
		ResultSet C1_REC =null;
		String plantype=null;
		try {
			String M_CR_PAY_TO =null;;
			String M_CR_WAITING_YN = null;
			String M_CR_LIEN_YN = null;
		  
			PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
			PT_IL_CLAIM PT_IL_CLAIM_BEAN = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			
			String C1 = "SELECT CR_PAY_TO,CR_WAITING_YN,CR_LIEN_YN "+
			"FROM   PM_IL_CLM_REPAY "+
			"WHERE  CR_COVER_CODE   = ? "+
			"AND    CR_LOSS_TYPE    =  ? "+
			"AND    CR_DISABLE_TYPE =  ? ";
			
			String C2 = "SELECT CR_WAITING_YN,CR_LIEN_YN "+
						"FROM   PM_IL_CLM_REPAY "+
						"WHERE  CR_COVER_CODE   =  ? "+
						"AND    CR_LOSS_TYPE    =  ? "+
						"AND    CR_DISABLE_TYPE = ? ";
			
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			Object [] c1_obj = new Object[]{PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE()
					};
			if("O".equalsIgnoreCase(PT_IL_CLAIM_BEAN.getCLAIM_TYPE())){
				if(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE()!=null && PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE()!=null &&
						PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE()!=null){
					
					C1_REC = handler.executeSelectStatement(C1, connection,c1_obj);
					if (C1_REC.next()) {
						PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_CLAIM_PAY_TO(C1_REC.getString("CR_PAY_TO"));
						M_CR_WAITING_YN = C1_REC.getString("CR_WAITING_YN");
						M_CR_LIEN_YN = C1_REC.getString("CR_LIEN_YN");
					}
				}
				
			}else{
				C2_REC = handler.executeSelectStatement(C2, connection,c1_obj);
				if (C2_REC.next()) {
					M_CR_WAITING_YN = C2_REC.getString("CR_WAITING_YN");
					M_CR_LIEN_YN = C2_REC.getString("CR_LIEN_YN");
				}
			}

			if("Y".equals(CommonUtils.nvl(M_CR_WAITING_YN, "N")) &&
					"Y".equals(CommonUtils.nvl(M_CR_LIEN_YN, "N"))){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE_PER().setDisabled(true);
			}else{
				/*added by raja on 15-06-2017 for ZBILQC-1728216*/
				/*uncommented by Janani on 08.03.2019 for KIC */
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_RATE_PER().setDisabled(false);
				/*End*/
				/*end*/
			}
			PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
			pilt006_apac_procedure.L_CLM_EST_DISABLE_VALID(null);
			DBProcedures procedures = new DBProcedures();
			procedures.P_VAL_CODES_PROC_CALL("IL_DIS_TYP", PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE(), 
					"N", "E");
			
			pilt006_apac_procedure.L_UNIQUE_SET_CODES(PT_IL_CLAIM_COVER_DTLS_BEAN,
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN());
			/*Added by R Raja on 24.01.2017 for RM018T - FSD_IL_ZB Life_010-Maximum Funeral  Benefit Limit*/

			
			/*pilt006_apac_procedure.PROC_CALL_CALC_CLM_CVR_EST_AMT_F(PT_IL_CLAIM_BEAN.getCLAIM_MEMB_CODE(),
					PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(),PT_IL_CLAIM_BEAN.getCLAIM_TYPE(),PT_IL_CLAIM_BEAN.getCLAIM_EXCH_RATE(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE(),PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT(),PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE(),
					PT_IL_CLAIM_BEAN.getCLAIM_CURR_CODE(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LC_EST_AMT(),
					PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RATE(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RATE_PER(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_PERIOD());*/
			
			
			
			if (compositeAction.getPT_IL_CLAIM_ACTION_BEAN().
					getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID() != null) {
				String query="select plan_type from pm_il_plan,pt_il_policy where pol_plan_code=plan_code and pol_sys_id="+
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_POL_SYS_ID()+"";
				ResultSet resultset=new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
				while(resultset.next())
				{
					plantype=resultset.getString("plan_type");
					System.out.println("plan type ============== > "+plantype);
				}
				
				if(plantype.equalsIgnoreCase("L"))
				{
					pilt006_apac_procedure.PROC_CALL_CALC_CLM_CVR_EST_AMT_F(PT_IL_CLAIM_BEAN.getCLAIM_MED_CODE(),
							PT_IL_CLAIM_BEAN.getCLAIM_POL_NO(),PT_IL_CLAIM_BEAN.getCLAIM_TYPE(),PT_IL_CLAIM_BEAN.getCLAIM_EXCH_RATE(),
							PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LOSS_TYPE(),
							PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_DISAB_TYPE(),PT_IL_CLAIM_BEAN.getCLAIM_LOSS_DT(),PT_IL_CLAIM_BEAN.getCLAIM_ASSR_CODE(),
							PT_IL_CLAIM_BEAN.getCLAIM_CURR_CODE(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_LC_EST_AMT(),
							PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RATE(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_RATE_PER(),PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_PERIOD());
				}
			}
			/*end*/
			//L_CALC_CLM_CVR_EST_AMT Need to TODO
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(C1_REC!=null){
				C1_REC.close();
			}
			if(C2_REC!=null){
				C2_REC.close();
			}
		}
		
	}
	
	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateClaimCoverLossType(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		String M_DEATH = null;
		String M_PS_CODE_DESC = null;
		String C_DEATH = "SELECT  PS_CODE  FROM	PP_SYSTEM  WHERE  PS_TYPE = 'IL_DEATH' AND PS_CODE=?";
		String C1 = " SELECT PS_CODE_DESC FROM   PP_SYSTEM WHERE  PS_TYPE = ?";
		PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
		pilt006_apac_procedure.L_CLM_EST_LOSS_VALID(null);
		try{	
				ResultSet C1_REC =null;
				ResultSet M_DEATH_REC =null;
				
				PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
				PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
				
				Connection connection = CommonUtils.getConnection();
				
				CRUDHandler handler = new CRUDHandler();
				
				M_DEATH_REC = handler.executeSelectStatement(C_DEATH, connection,new Object[]{pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()});
				if(M_DEATH_REC.next()){
					M_DEATH = M_DEATH_REC.getString("PS_CODE");
				}
				
				/*if(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CALC_METHOD()==2){
					if("O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE())){
						if(M_DEATH!=null && M_DEATH.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE())){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "71147"));
						}
					}else{
						if(M_DEATH!=null && !M_DEATH.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE())){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "71146"));
						}
					}
				}*/
				
				/*if(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CALC_METHOD()==1){
					C1_REC = handler.executeSelectStatement(C1, connection,new Object[]{"IL_FEB_LOSTY"});
					if(C1_REC.next()){
						M_PS_CODE_DESC = C1_REC.getString("PS_CODE_DESC");
					}
					
					if("O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE())){
						if(M_DEATH!=null && M_PS_CODE_DESC!=null && (M_DEATH.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()) || 
								M_PS_CODE_DESC.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()))){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "71147"));
						}
					}else{
						if(M_DEATH!=null && M_PS_CODE_DESC!=null && (!M_DEATH.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()) || 
								!M_PS_CODE_DESC.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()))){
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "71146"));
						}
					}
				}*/
				DBProcedures procedures = new DBProcedures();
				procedures.P_VAL_CODES_PROC_CALL("IL_LOS_TYP", 
						pt_il_claim_cover_dtls.getCCD_LOSS_TYPE(), 
						"N", "E");
				
				//ADDED BY AKASH TO MAKE NORMAL FLOW TO BE WORK.
				
				if(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CALC_METHOD()==1 || 
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CALC_METHOD()==2) {
					pilt006_apac_procedure.L_CALC_FEB_EST();
					pilt006_apac_procedure.L_CALC_PTPD_EST();
				}
				//pilt006_apac_procedure.L_CALC_CLM_CVR_EST_AMT TODO Need to Discuss
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		

	}
	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateCoverCode(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		
		
		Double M_POL_SYS_ID =0.0;
		String M_COVER_CLASS =null;
		Double M_POAC_MED_DAYS =0.0;
		Double M_CCD_NO_OF_DAYS =0.0;
		
		String C1 = "SELECT SUM(CCD_FC_EST_AMT) "
				+ "FROM  PT_IL_CLAIM_COVER_DTLS,PT_IL_CLAIM "
				+ "WHERE CLAIM_POL_SYS_ID = ? "
				+ "AND   CLAIM_SYS_ID     = CCD_CLAIM_SYS_ID "
				+ "AND   CLAIM_ASSR_CODE  = ? AND   CCD_COVER_CODE   = ?";
		
		String C2 = "SELECT POAC_FC_SA "+
      "FROM PT_IL_POL_ADDL_COVER "+
      "WHERE POAC_COVER_CODE = ? "+
	    "AND   POAC_ASSR_CODE  = ? "+
      "AND   POAC_POL_SYS_ID = ?";
		
		String C3 = "SELECT DECODE(POL_INCORPORATED_YN,'N',POL_FC_SUM_ASSURED ,'Y', POL_LC_TOT_SA) "+
      "FROM   PT_IL_POLICY  "+
      "WHERE  POL_PLAN_CODE = ? "+ 
      "AND    POL_SYS_ID    = ? "+
      "AND    POL_DS_TYPE   = '2'";
		
		String C4 = "SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_NO = ? AND    POL_DS_TYPE = '2'";
		
		String C5 = "SELECT COVER_CLASS FROM   PM_IL_COVER WHERE  COVER_CODE = ?";
		
		String C6 = "SELECT  POAC_MED_DAYS "+
      "FROM    PT_IL_POL_ADDL_COVER "+
      "WHERE   POAC_COVER_CODE = ? "+  
      "AND     POAC_POL_SYS_ID  = ? ";
		
		String C7 = "SELECT SUM(CCD_NO_OF_DAYS) "+
       "FROM   PT_IL_CLAIM_COVER_DTLS  "+  
       "WHERE  CCD_COVER_CODE  = ? "+
       "AND    CCD_CLAIM_SYS_ID IN (SELECT CLAIM_SYS_ID "+
                                   "FROM   PT_IL_CLAIM "+
		                               "WHERE  CLAIM_POL_NO = ? "+
					                    	   "AND    CLAIM_ADDL_STATUS = 'CL05')";
		
		String C8 = "SELECT PAC_MASTER_COVER_CODE "
				+ "FROM PM_IL_PROD_APPL_COVER " + "WHERE PAC_COVER_CODE = ? "
				+ "AND PAC_PROD_CODE =  ? UNION "
				+ "SELECT PAC_COVER_CODE FROM PM_IL_PROD_APPL_COVER "
				+ "WHERE PAC_MASTER_COVER_CODE = ? AND PAC_PROD_CODE =  ?";

		String C9 = "SELECT NVL(SUM(CCD_LC_EST_AMT),0) "
				+ "FROM   PT_IL_CLAIM_COVER_DTLS, PT_IL_CLAIM "
				+ "WHERE  CCD_CLAIM_SYS_ID =  CLAIM_SYS_ID "
				+ "AND    CLAIM_POL_NO     = ? "
				+ "AND    CCD_COVER_CODE   in (M_PAC_COVER_CODE,?) "
				+ "AND    (CLAIM_SYS_ID <> ?  OR ? IS NULL) "
				+ "AND    NVL(CLAIM_ADDL_STATUS,'N') <> 'R' "
				+ "AND    CLAIM_TYPE       = 'O' "
				+ "AND    CCD_FRZ_FLAG     = 'Y' "
				+ "AND    CCD_CONFIRM_FLAG = 'Y'";
		
		String C10 = "SELECT POACH_N_DEL_FLAG,POACH_O_FC_SA FROM PH_IL_POL_ADDL_COVER WHERE " +
				"POACH_POL_SYS_ID=  ? AND POACH_O_ASSR_CODE = ? " +
				"AND POACH_O_COVER_CODE  = ?";
		
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet C8_REC = null;
		ResultSet C9_REC = null;
		ResultSet C10_REC = null;
		
		String M_PAC_MASTER_COVER_CODE =null;
		Double M_CCD_LC_EST_AMT_1=0.0;
		String M_PAC_COVER_CODE =null;
		Double M_POL_LC_SUM_ASSURED =0.0;
		String m_del_flag = null;
		Double end_fc_sa = null;
		
		
		try{
			PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
			
			Connection connection = CommonUtils.getConnection();
			
			CRUDHandler handler = new CRUDHandler();
			Object [] obj_C4 = new Object[]{ pt_il_claim.getCLAIM_POL_NO()};
			
			C4_REC = handler.executeSelectStatement(C4, connection,obj_C4);
			if(C4_REC.next()){
				M_POL_SYS_ID = C4_REC.getDouble(1);
			}
			
			Object [] obj_C1 = new Object[]{ pt_il_claim.getCLAIM_SYS_ID(),
											pt_il_claim.getCLAIM_ASSR_CODE(),
											pt_il_claim_cover_dtls.getCCD_COVER_CODE()};
			
			C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);
			if(C1_REC.next()){
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setM_CCD_FC_EST_AMT(C1_REC.getDouble(1));
			}
			
			C10_REC = handler.executeSelectStatement(C10, connection,new Object[]{pt_il_claim.getCLAIM_POL_SYS_ID(),
					pt_il_claim.getCLAIM_ASSR_CODE(),pt_il_claim_cover_dtls.getCCD_COVER_CODE()});
			
			if(C10_REC.next()){
				m_del_flag = C10_REC.getString(1);
				end_fc_sa = C10_REC.getDouble(2);
			}
				
			Object [] obj_C2 = new Object[]{ 
					pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
					pt_il_claim.getCLAIM_ASSR_CODE(),
					pt_il_claim.getCLAIM_SYS_ID()};
			
			C2_REC = handler.executeSelectStatement(C2, connection, obj_C2);
			if (m_del_flag == null) {
				if (C2_REC.next()) {
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
							.setM_POAC_FC_SA(C2_REC.getDouble(1));
				}
			} else if("Y".equalsIgnoreCase(m_del_flag)){
					if (end_fc_sa != null) {
						compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN()
								.setM_POAC_FC_SA(end_fc_sa);
				}
			}
			
			Object [] obj_C3 = new Object[]{pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
										M_POL_SYS_ID};
			
			C3_REC = handler.executeSelectStatement(C3, connection,obj_C3);
			if(C3_REC.next()){
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setM_POL_FC_SUM_ASSURED_1(C3_REC.getDouble(1));
			}
			
			Object [] obj_C6 = new Object[]{pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
					M_POL_SYS_ID};
			
			C6_REC = handler.executeSelectStatement(C6, connection,obj_C6);
			if(C6_REC.next()){
					M_POAC_MED_DAYS = C6_REC.getDouble(1);
			}
			
			Object [] obj_C7 = new Object[]{pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
					pt_il_claim.getCLAIM_POL_NO()};
			
			C7_REC = handler.executeSelectStatement(C7, connection,obj_C7);
			if(C7_REC.next()){
					M_POAC_MED_DAYS = C7_REC.getDouble(1);
			}
			
			Object [] obj_C5 = new Object[]{pt_il_claim_cover_dtls.getCCD_COVER_CODE()};
			
			C5_REC = handler.executeSelectStatement(C5, connection,obj_C5);
			if(C5_REC.next()){
				M_COVER_CLASS = C5_REC.getString(1);
			}
			
			/*changed by raja on 10-05-2017 for hospital cash fsd*/
			if("M".equals(CommonUtils.nvl(M_COVER_CLASS, "X"))){
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_NO_OF_DAYS().setDisabled(false);
			/*}*/
			if(M_POAC_MED_DAYS==M_CCD_NO_OF_DAYS){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91531"));
			}else if(M_CCD_NO_OF_DAYS + CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_NO_OF_DAYS(), 0) > M_POAC_MED_DAYS){
				throw new Exception(Messages.getString(
						PELConstants.pelErrorMessagePath, "91532"));
			}
			}
			else{
				compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_NO_OF_DAYS().setDisabled(true);
			}
			
			PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
			pilt006_apac_procedure.L_CLM_EST_COVER_VALID(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN(),
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN(), 
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN());
			
			DBProcedures procedures = new DBProcedures();
			if(pt_il_claim_cover_dtls.getCCD_COVER_CODE() != null){
			ArrayList<String> list = procedures.helperP_VAL_COVER(pt_il_claim_cover_dtls.getCCD_COVER_CODE(), 
					pt_il_claim_cover_dtls.getCOVER_TYPE(), 
					"N", "E");
			}
			
			
			//L_CALC_CLM_CVR_EST_AMT TODO
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C8_REC);
			CommonUtils.closeCursor(C10_REC);
		}
		
	}
	
	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateCCDNoOfDays(PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN,
			Object value) throws Exception{
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		
		Double M_POL_SYS_ID = 0.0;
		Double M_POAC_MED_DAYS = 0.0;
		Double M_CCD_NO_OF_DAYS = 0.0;
		String M_COVER_CLASS = null;
		
		String C1 = "SELECT POL_SYS_ID FROM   PT_IL_POLICY WHERE  POL_NO = ?";
		String C2 = "SELECT  POAC_MED_DAYS FROM    PT_IL_POL_ADDL_COVER "
				+ "WHERE   POAC_COVER_CODE = ? AND POAC_POL_SYS_ID = ?";
		String C3 = "SELECT SUM(CCD_NO_OF_DAYS) "
				+ "FROM   PT_IL_CLAIM_COVER_DTLS "
				+ "WHERE  CCD_COVER_CODE  = ? "
				+ "AND    CCD_CLAIM_SYS_ID  IN (SELECT CLAIM_SYS_ID "
				+ "FROM   PT_IL_CLAIM WHERE  CLAIM_POL_NO = ? "
				+ "AND    CLAIM_ADDL_STATUS = 'CL05')";

		String C4 = "SELECT COVER_CLASS FROM PM_IL_COVER WHERE COVER_CODE = ?";
		
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			
			Object [] obj_C1 = new Object[]{ PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()};
			
			C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);
			if(C1_REC.next()){
				M_POL_SYS_ID = C1_REC.getDouble(1);
			}
			
			Object [] obj_C2 = new Object[]{ PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),M_POL_SYS_ID};
			
			C2_REC = handler.executeSelectStatement(C2, connection,obj_C2);
			if(C2_REC.next()){
				M_POAC_MED_DAYS = C2_REC.getDouble(1);
			}
			
			Object [] obj_C3 = new Object[]{ PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE(),PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()};
			
			C3_REC = handler.executeSelectStatement(C3, connection,obj_C3);
			if(C3_REC.next()){
				M_CCD_NO_OF_DAYS = C3_REC.getDouble(1);
			}
			
			Object [] obj_C4 = new Object[]{ PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_COVER_CODE()};
			
			C4_REC = handler.executeSelectStatement(C4, connection,obj_C4);
			if(C4_REC.next()){
				M_COVER_CLASS = C4_REC.getString(1);
			}
			
			if("M".equals(CommonUtils.nvl(M_COVER_CLASS, "N"))){
				if(M_POAC_MED_DAYS <= CommonUtils.nvl(M_CCD_NO_OF_DAYS, 0)){
					
				}else if ((CommonUtils.nvl(M_CCD_NO_OF_DAYS, 0.0)) + (CommonUtils.nvl(PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_NO_OF_DAYS(), 0)) > M_POAC_MED_DAYS){
					
				}
			}
			
			/* IF NVL(M_COVER_CLASS,'N') = 'M' THEN
			 IF  M_POAC_MED_DAYS <= NVL(M_CCD_NO_OF_DAYS,0) THEN
			 STD_MESSAGE_ROUTINE(91531,NAME_IN('GLOBAL.M_LANG_CODE'));
		   RAISE FORM_TRIGGER_FAILURE;
			 ELSIF (NVL(M_CCD_NO_OF_DAYS,0) + NVL(:PT_IL_CLAIM_COVER_DTLS.CCD_NO_OF_DAYS,0)) >  M_POAC_MED_DAYS THEN
			 STD_MESSAGE_ROUTINE(91532,NAME_IN('GLOBAL.M_LANG_CODE'),M_CCD_NO_OF_DAYS,M_POAC_MED_DAYS);
		   RAISE FORM_TRIGGER_FAILURE;
			 END IF;
			 END IF;*/
			
			//L_CALC_CLM_CVR_EST_AMT TODO
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
		}
	}
	
	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateCCPERIOD(PT_IL_CLAIM_COVER_DTLS PT_IL_CLAIM_COVER_DTLS_BEAN,
			Object value) throws Exception{
			try {
				Double fcAmt = PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_FC_EST_AMT();
				Integer ccPeriod = PT_IL_CLAIM_COVER_DTLS_BEAN.getCCD_PERIOD();
				fcAmt = fcAmt!=null ? fcAmt: 0.0;
				ccPeriod = ccPeriod!=null ? ccPeriod :0;
				PT_IL_CLAIM_COVER_DTLS_BEAN.setCCD_FC_EST_AMT(fcAmt * ccPeriod);
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	}

	

	public void whenValidateFC_EST_AMOUNT(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		
		ResultSet C0_REC = null;
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		ResultSet C3_REC = null;
		ResultSet C4_REC = null;
		ResultSet C5_REC = null;
		ResultSet C6_REC = null;
		ResultSet C7_REC = null;
		ResultSet CLAIM_REM = null;
		
		Double M_SA = 0.0;
		Double M_SUM_VALUE = 0.0;
		Double M_POL_SYS_ID = 0.0;
		Double M_CALC_MONTH = 0.0;
		String M_POL_INCORPORATED_YN = null;
		Double M_PRS_FC_SA = 0.0;
		Double M_PRS_LC_SA = 0.0;
		Date M_POL_START_DT = null;
		String M_PLAN_TYPE = null;
		String M_PS_CODE_DESC_1 = null;
		String M_PS_CODE_DESC_2 = null;
		double rfhAmount = 0d;
        double percentageAmt = 0d;
		

		String C0 = "SELECT PLAN_TYPE " + "FROM   PM_IL_PLAN "
				+ "WHERE  NVL(PLAN_FRZ_FLAG,'N') = 'N' "
				+ "AND    PLAN_CODE = (SELECT POL_PLAN_CODE "
				+ "FROM   PT_IL_POLICY  " + "WHERE  POL_NO = ? "
				+ "AND    POL_DS_TYPE = '2')";

		String C1 = "SELECT SUM(CCD_FC_EST_AMT) "
				+ "FROM  PT_IL_CLAIM_COVER_DTLS,PT_IL_CLAIM "
				+ "WHERE CLAIM_POL_SYS_ID = ? "
				+ "AND   CLAIM_SYS_ID     = CCD_CLAIM_SYS_ID "
				+ "AND   CLAIM_ASSR_CODE  = ? " + "AND   CCD_COVER_CODE   = ? "
				+ "AND   CCD_SET_FLAG <>'PA' " + "AND   CCD_SYS_ID   <> ?";

		String C2 = "SELECT POAC_FC_SA " + "FROM   PT_IL_POL_ADDL_COVER "
				+ "WHERE POAC_COVER_CODE = ? " + "AND   POAC_ASSR_CODE  = ? "
				+ "AND   POAC_POL_SYS_ID = ? ";

		String C3 = "SELECT POL_FC_SUM_ASSURED,NVL(POL_INCORPORATED_YN,'N'),POL_START_DT "
				+ "FROM   PT_IL_POLICY  "
				+ "WHERE  POL_SYS_ID    = ? "
				+ "AND    POL_DS_TYPE   = '2'";

		String C4 = "SELECT POL_SYS_ID " + "FROM   PT_IL_POLICY  "
				+ "WHERE  POL_NO = ? " + "AND    POL_DS_TYPE = '2'";

		String C5 = "SELECT  DECODE(?,'Y',PRS_INCOR_FC_SA,'N',NULL), "
				+ "DECODE(?,'Y',PRS_INCOR_LC_SA,'N',NULL) "
				+ "FROM    PT_IL_POL_RED_SA "
				+ "WHERE   PRS_POL_SYS_ID = ? "
				+ "AND     PRS_MONTH = ? ";

		String C6 = "SELECT ROUND(MONTHS_BETWEEN(TO_DATE(?," +
				"'DD/MM/RRRR'),TO_DATE(?,'DD/MM/RRRR'))) FROM DUAL";

		String C7 = "SELECT PS_CODE_DESC FROM   PP_SYSTEM WHERE  PS_TYPE = ?";
		
		String CLAIM_RE="SELECT NVL(AVR_RHF_AMT,0) FROM PS_IL_ANIVR_PROCESS WHERE AVR_POL_SYS_ID = ? ";
		
		String C10 = "SELECT POACH_N_DEL_FLAG,POACH_O_FC_SA FROM PH_IL_POL_ADDL_COVER WHERE " +
		"POACH_POL_SYS_ID=  ? AND POACH_O_ASSR_CODE = ? " +
		"AND POACH_O_COVER_CODE  = ?";
		
		
		ResultSet C10_REC = null;
		String m_del_flag = null;
		Double end_fc_sa = null;
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
			
			
			Object [] obj_C4 = new Object[]{ pt_il_claim.getCLAIM_POL_NO()};
			C4_REC = handler.executeSelectStatement(C4, connection,obj_C4);
			if(C4_REC.next()){
				M_POL_SYS_ID = C4_REC.getDouble(1);
			}
			
			Object [] obj_C1 = new Object[]{ M_POL_SYS_ID,pt_il_claim.getCLAIM_ASSR_CODE(),pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
					pt_il_claim_cover_dtls.getCCD_SYS_ID()};
			
			C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);
			if(C1_REC.next()){
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setM_CCD_FC_EST_AMT(C1_REC.getDouble(1));
			}
			C10_REC = handler.executeSelectStatement(C10, connection,
					new Object[]{pt_il_claim.getCLAIM_POL_SYS_ID(),
					pt_il_claim.getCLAIM_ASSR_CODE(),
					pt_il_claim_cover_dtls.getCCD_COVER_CODE()});
			
			if(C10_REC.next()){
				m_del_flag = C10_REC.getString(1);
				end_fc_sa = C10_REC.getDouble(2);
			}		
			Object [] obj_C2 = new Object[]{pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
					pt_il_claim.getCLAIM_ASSR_CODE(),M_POL_SYS_ID};
			C2_REC = handler.executeSelectStatement(C2, connection,obj_C2);
			if(m_del_flag == null){
			if(C2_REC.next()){
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setM_POAC_FC_SA(C2_REC.getDouble(1));
			}
			}
			else if("Y".equalsIgnoreCase(m_del_flag)){
					if(end_fc_sa!= null){
					compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().
					     setM_POAC_FC_SA(end_fc_sa);
				}
			}
			
			Object [] obj_C3 = new Object[]{M_POL_SYS_ID};
				C3_REC = handler.executeSelectStatement(C3, connection,obj_C3);
			if(C3_REC.next()){
				compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setM_POL_FC_SUM_ASSURED_1(C3_REC.getDouble("POL_FC_SUM_ASSURED"));
				M_POL_INCORPORATED_YN = C3_REC.getString(2);
				M_POL_START_DT = C3_REC.getDate("POL_START_DT");
			}
			
			
			/*Modified by Janani on 22.06.2017 for ZBILQC-1721754*/
			
			//Object [] obj_C6 = new Object[]{pt_il_claim.getCLAIM_LOSS_DT(),pt_il_claim.getCLAIM_LOSS_DT()};
			Object [] obj_C6 = new Object[]{CommonUtils.dateToStringFormat(pt_il_claim.getCLAIM_LOSS_DT()),CommonUtils.dateToStringFormat(pt_il_claim.getCLAIM_LOSS_DT())};
			
			/*End*/
			C6_REC = handler.executeSelectStatement(C6, connection,obj_C6);
			if(C6_REC.next()){
				M_CALC_MONTH = C6_REC.getDouble(1);
			}
			
			Object [] obj_C5 = new Object[]{M_POL_INCORPORATED_YN,M_POL_INCORPORATED_YN,
					M_POL_SYS_ID,M_CALC_MONTH};
			C5_REC = handler.executeSelectStatement(C5, connection,obj_C5);
			if(C5_REC.next()){
				M_PRS_FC_SA = C5_REC.getDouble(1);
				M_PRS_LC_SA  = C5_REC.getDouble(2);
			}
			
			Object [] obj_C0 = new Object[]{pt_il_claim.getCLAIM_POL_NO()};
			C0_REC = handler.executeSelectStatement(C0, connection,obj_C0);
			if(C0_REC.next()){
				M_PLAN_TYPE = C0_REC.getString(1);
			}
			
			M_SA = CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POAC_FC_SA(), 0 ) + 
			CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_FC_SUM_ASSURED_1(), 0 );
			
			if(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CALC_METHOD()==2){
				Double FC_AMT = CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CCD_FC_EST_AMT(),0.0);
				if(CommonUtils.nvl((M_SA-FC_AMT), 0) <0){
					String message = "No more Claim for the Cover" + pt_il_claim_cover_dtls.getCCD_COVER_CODE() + "for the Assured"  +  pt_il_claim.getCLAIM_ASSR_CODE();
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "3206",new Object[] {message}));
				}
			}
			
			if("O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE())){
				Object [] obj_C7 = new Object[]{"IL_PTPD_LOTY"};
				C7_REC = handler.executeSelectStatement(C7, connection,obj_C7);
				if(C7_REC.next()){
					M_PS_CODE_DESC_1 = C7_REC.getString(1);
				}
				C7_REC.close();
				
				C7_REC = handler.executeSelectStatement(C7, connection,new Object[]{"IL_FEB_LOSTY"});
				if(C7_REC.next()){
					M_PS_CODE_DESC_2 = C7_REC.getString(1);
				}
				C7_REC.close();
				
				if("W".equalsIgnoreCase(pt_il_claim_cover_dtls.getM_CCD_COVER_CLASS())){
					//M_SA:=ROUND(:PT_IL_CLAIM_COVER_DTLS.M_CCD_WOP_SA,2);
					M_SA = CommonUtils.ROUND(pt_il_claim_cover_dtls.getM_CCD_WOP_SA(),2);
				}
				
				if(M_PS_CODE_DESC_1!=null && M_PS_CODE_DESC_1.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE())
						&& M_PS_CODE_DESC_2!=null && M_PS_CODE_DESC_2.equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE())){
					if("M".equalsIgnoreCase(M_PLAN_TYPE)){
//						IF :PT_IL_CLAIM_COVER_DTLS.CCD_FC_EST_AMT > NVL(:PT_IL_CLAIM_COVER_DTLS.M_EST_CHECK,(M_SA - NVL(:DUMMY.M_CCD_FC_EST_AMT,0))) THEN
						if(pt_il_claim_cover_dtls.getCCD_FC_EST_AMT() > CommonUtils.nvl(pt_il_claim_cover_dtls.getM_EST_CHECK(), M_SA - CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CCD_FC_EST_AMT(), 0))){
							M_SUM_VALUE = CommonUtils.nvl(pt_il_claim_cover_dtls.getM_EST_CHECK(), CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CCD_FC_EST_AMT(), 0));
							String message = "Claim amount Less than or Equal to" + M_SUM_VALUE;
							throw new Exception(Messages.getString(
									PELConstants.pelErrorMessagePath, "91014",
									new Object[] {"001","91014", message}));
						}else{
							if("PA".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_SET_FLAG())){
								if(pt_il_claim_cover_dtls.getCCD_FC_EST_AMT() > CommonUtils.nvl(M_SA, CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_CCD_FC_EST_AMT(), 0))){
									String message = "Claim amount Less than or Equal to" + M_SUM_VALUE;
									throw new Exception(Messages.getString(
											PELConstants.pelErrorMessagePath, "91014",
											new Object[] {"001","91014", message}));	
								}
							}
						}
					}
				}
			}
			PILT006_APAC_PROCEDURE dbProcedure = new PILT006_APAC_PROCEDURE();
			
			pt_il_claim_cover_dtls.setCCD_RESERVE_GEN_FLAG("N");
			ArrayList<OracleParameter> outputList = dbProcedure.P_VAL_ROUND_AMT(pt_il_claim.getCLAIM_CURR_CODE(),
														pt_il_claim_cover_dtls.getCCD_FC_EST_AMT(),"V");
			
            Double CCD_FC_EST_AMT =  (Double)outputList.get(0).getValueObject();
            System.out.println("**********************************pt_il_claim.getCLAIM_EXCH_RATE()"+pt_il_claim.getCLAIM_EXCH_RATE());
            /*Added by kavitha on 20.03.2019 for KIC */
            if(pt_il_claim.getCLAIM_EXCH_RATE()!= null){
            	pt_il_claim_cover_dtls.setCCD_LC_EST_AMT(CCD_FC_EST_AMT * pt_il_claim.getCLAIM_EXCH_RATE());
            }
            /*End*/
            
            ArrayList<OracleParameter> outputList1 = dbProcedure.P_VAL_ROUND_AMT(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getCLAIM_CURR_CODE(),
					pt_il_claim_cover_dtls.getCCD_LC_EST_AMT(),"R");
            pt_il_claim_cover_dtls.setCCD_LC_EST_AMT(outputList1.get(0)!=null?(Double)outputList1.get(0).getValueObject():null);
			
            /**
             * Claim Reimebursement code
             */
            
            CLAIM_REM = handler.executeSelectStatement(CLAIM_RE, connection,new Object[]{pt_il_claim.getCLAIM_POL_SYS_ID()}); 
            if(CLAIM_REM.next()){
            	rfhAmount = CLAIM_REM.getDouble(1);
            	System.out.println("===============>pt_il_claim=======>"+pt_il_claim);
            }
            
            if("10103".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_COVER_CODE()) 
            		&& "PPD".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()) 
            		&& "EDU001".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_DISAB_TYPE())){//Medical Reimebursement validation is .5% of health fund.
            	
            	percentageAmt = (rfhAmount * 0.5)/100;
            	System.out.println("Percnetage Amount=======>"+percentageAmt);
            	if(pt_il_claim_cover_dtls.getCCD_FC_EST_AMT() > percentageAmt){
            		throw new Exception("Entered Amount exceeds the permissble amount");
            	}
            	
            }else if("10103".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_COVER_CODE()) 
            		&& "PPD".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()) 
            		&& "CI_006".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_DISAB_TYPE())){//Doctor fee Reimebursement validation 1% of health fund.
            	
            	percentageAmt = (rfhAmount * 1)/100;
            	System.out.println("Percnetage Amount=======>"+percentageAmt);
            	if(pt_il_claim_cover_dtls.getCCD_FC_EST_AMT() > percentageAmt){
            		throw new Exception("Entered Amount exceeds the permissble amount");
            	}
            	
            }else if("10103".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_COVER_CODE()) 
            		&& "PPD".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_LOSS_TYPE()) 
            		&& "CI_007".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_DISAB_TYPE())){//Surgical Reimebursement validation 2.5 % of health fund.
            	
            	percentageAmt = (rfhAmount * 2.5)/100;
            	System.out.println("Percnetage Amount=======>"+percentageAmt);
            	if(pt_il_claim_cover_dtls.getCCD_FC_EST_AMT() > percentageAmt){
            		throw new Exception("Entered Amount exceeds the permissble amount");
            	}
            }
            //NEWLY ADDED FOR ESTIMATE AMOUNT SHOOULD BE <= COVER FC_SA
			
			
			/*if("D".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_TYPE())){
				if(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_FC_SUM_ASSURED_1() < pt_il_claim_cover_dtls.getCCD_FC_EST_AMT()){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80383",
							new Object[] {pt_il_claim_cover_dtls.getCCD_FC_EST_AMT(),compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_FC_SUM_ASSURED_1()}));
				}
			}else{
				if((CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POAC_FC_SA(),0) < pt_il_claim_cover_dtls.getCCD_FC_EST_AMT())){
					throw new Exception(Messages.getString(
							PELConstants.pelErrorMessagePath, "80383",
							new Object[] {pt_il_claim_cover_dtls.getCCD_FC_EST_AMT(),CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POAC_FC_SA(),0)}));
				}

			}
*/            //End
            
            
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(C0_REC);
			CommonUtils.closeCursor(C1_REC);
			CommonUtils.closeCursor(C2_REC);
			CommonUtils.closeCursor(C3_REC);
			CommonUtils.closeCursor(C4_REC);
			CommonUtils.closeCursor(C5_REC);
			CommonUtils.closeCursor(C6_REC);
			CommonUtils.closeCursor(C7_REC);
			CommonUtils.closeCursor(C10_REC);
		}
	}
	
	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateCCD_LC_EST_AMT(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
		
		PILT006_APAC_PROCEDURE dbProcedure = new PILT006_APAC_PROCEDURE();
		
        ArrayList<OracleParameter> outputList1 = dbProcedure.P_VAL_ROUND_AMT(
        		compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getCLAIM_CURR_CODE(),
				pt_il_claim_cover_dtls.getCCD_LC_EST_AMT(),"R");
        DBProcedures procedures = new DBProcedures();
        
        String FC_AMOUNT = null;
        String LC_AMOUNT = null;
        String EXCH_RATE = null;
        
        if(pt_il_claim_cover_dtls.getCCD_FC_EST_AMT()!=null){
        	FC_AMOUNT = String.valueOf(pt_il_claim_cover_dtls.getCCD_FC_EST_AMT());
        }
        
        if(pt_il_claim_cover_dtls.getCCD_LC_EST_AMT()!=null){
        	LC_AMOUNT = String.valueOf(pt_il_claim_cover_dtls.getCCD_LC_EST_AMT());
        }
        
        if(pt_il_claim.getCLAIM_EXCH_RATE()!=null){
        	EXCH_RATE =  String.valueOf(pt_il_claim.getCLAIM_EXCH_RATE());
        }

        
        procedures.callP_VAL_FC_LC_TOLERANCE(FC_AMOUNT, 
        		LC_AMOUNT, 
        		EXCH_RATE, "E");
		
	}
	
	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenListChangedCCD_FRZ_FLAG(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		String C1 = "SELECT COVER_SA_CALC FROM   PM_IL_COVER WHERE  COVER_CODE = ? ";
		Double M_TEMP=null;
		String M_COVER_SA_CALC = null;
		ResultSet C1_REC = null;
		
/*Added by Janani on 22.05.2017 for ZB Factory testing feed-back point*/
		
		String C2 = "SELECT 'X' FROM PT_IL_DOC_TODO_LIST_STATUS,PM_IL_DOC_TODO_GROUP WHERE DTLS_MANDATORY_YN = 'Y' "
				+ "AND DTLS_APPR_STS = 'N' AND DTLS_CLM_SYS_ID = ? AND PT_IL_DOC_TODO_LIST_STATUS.DTLS_GROUP_CODE = PM_IL_DOC_TODO_GROUP.DTG_GROUP_CODE "
				+ " AND PM_IL_DOC_TODO_GROUP.DTG_DS_CODE = ?  AND   PM_IL_DOC_TODO_GROUP.DTG_DS_TYPE = ? ";
		
		ResultSet resultSet2 = null;
		String M_STATUS = null;
		
		/*End*/
		
		
		
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
			
			
			if(value!=null){
				if("Y".equals(CommonUtils.nvl(value.toString(), "N"))){
					
					
					System.out.println("freeze flag is Y");
					
					
					
					if("N".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CLOSE_FLAG(), "N"))){
						/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
						//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
						if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}else{
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
						}//end
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_COVER_CODE().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LOSS_TYPE().setDisabled(true);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_DISAB_TYPE().setDisabled(true);
					}
					/*added by raja on 07-06-2017 for hands on points*/
					/*compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().setCLAIM_ADDL_STATUS("CL02");
					 compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().setUI_M_CLAIM_ADDL_STATUS(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()+" :- "+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().addilStatusDesc());
					 String query="UPDATE PT_IL_CLAIM SET CLAIM_ADDL_STATUS=? WHERE CLAIM_SYS_ID=?";
						new CRUDHandler().executeUpdateStatement(query, CommonUtils.getConnection(), new Object[]{
							compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_ADDL_STATUS()
							,compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()});
						CommonUtils.getConnection().commit();*/
					/*end*/
					 
					 
					 /*Added by Janani on 16.06.2017 for ZBILQC-1723136*/ 
					 
					 compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().disableAllComponentForFreeze(true);
					 
					 /*End*/
					 
					
				}else if("N".equals(CommonUtils.nvl(value.toString(), "N"))){
					if("N".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CLOSE_FLAG(), "N"))){
						M_TEMP = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FC_EST_AMT();						
						if(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FC_EST_AMT()!=null){
							M_TEMP = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FC_EST_AMT();
						}
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_COVER_CODE().setDisabled(false);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LOSS_TYPE().setDisabled(false);
						compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_DISAB_TYPE().setDisabled(false);
					}
				}
			}
			
			
			Object [] obj_C1 = new Object[]{ pt_il_claim_cover_dtls.getCCD_COVER_CODE()};
			
			C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);
			if(C1_REC.next()){
				M_COVER_SA_CALC = C1_REC.getString(1);
			}
			String M_COVER_SA_CALC_S = null;
			if(M_COVER_SA_CALC!=null){
				M_COVER_SA_CALC_S = M_COVER_SA_CALC;
			}
			if("O".equalsIgnoreCase(pt_il_claim.getCLAIM_TYPE()) && "D".equals(CommonUtils.nvl(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_PLAN_TYPE(), "X")) 
					|| "G".equals(CommonUtils.nvl(M_COVER_SA_CALC_S, "X"))){
				if(!compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().isDisabled() 
						&& !compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}//end
				}
			}else{
				if(!compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().isDisabled() 
						&& !compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().isDisabled()){
					/*added by gopi for RM018T - DEV_IL_ZB Life_006_ExGratia and Overrides on 28/12/16*/
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					//compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					String ps_value_2=compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPS_VALUE();
					if(ps_value_2!=null && ps_value_2.equalsIgnoreCase("2")){
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(true);	
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(true);
					}else{
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_FC_EST_AMT().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_LC_EST_AMT().setDisabled(false);
					}//end
				}
			}
			
			
			/*Added by Janani on 22.05.2017 for ZB Factory testing feed-back point*/
			if(value!=null && value.equals("Y")){
				System.out.println("getCLAIM_SYS_ID         "+compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID()+
						"    getDTG_DS_CODE         "+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1")+
						"    getDTG_DS_TYPE         "+CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11"));
				
				resultSet2 = handler.executeSelectStatement(C2, connection,
						new Object[] {compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_SYS_ID(),
						
						/*changed by raja on 24-206-2017 for hand on points*/
						/*compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_CODE(),
						compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN().getDTG_DS_TYPE()*/
						CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_1"),CommonUtils.getGlobalVariable("GLOBAL.M_PARAM_11")
						 });
				if (resultSet2.next()) {
					M_STATUS = resultSet2.getString(1);
				}
				
				System.out.println("M_STATUS              "+M_STATUS);
				
				if (CommonUtils.nvl(M_STATUS, "N").equals("X")) {
					throw new Exception(
							Messages
									.getString(
											PELConstants.pelErrorMessagePath,
											"3206",
											new Object[] { "Mandatory Checklist verification is pending." }));
				}
				
			}
				/*End*/
			

			/*Added by saritha on 10-11-2017 for ssp call id ZBLIFE-1445721*/

			if(("H".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPLAN_TYPE()))&&
					("HB".equalsIgnoreCase(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_TYPE())))
			{

				if(value!=null && value.equals("N")){
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_HOSP_ADDM_DT().setDisabled(false);
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_HOSP_DSCHG_DT().setDisabled(false);


				}

				else if(value!=null && value.equals("Y")) {
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_HOSP_ADDM_DT().setDisabled(true);
					compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_HOSP_DSCHG_DT().setDisabled(true);

				}

			}

			else {

				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_HOSP_ADDM_DT().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getCOMP_CLAIM_HOSP_DSCHG_DT().setDisabled(true);
			}

			/*End*/
			
			/*Added by saritha on 21-02-2018 for Claim Charge Screen Create,Delete &Post button enable/disable as per siva sir sugg.*/
			
			if("N".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_FRZ_FLAG()) &&
					"N".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_CONFIRM_FLAG())){
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_ADD().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_DEL().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_POST().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_RATE().setDisabled(false);
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getCOMP_CC_RATE_PER().setDisabled(false);
				
			}
			
			/*End*/
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	private void setPlanType(String plan_TYPE) {
		// TODO Auto-generated method stub
		
	}

	public void whenListChangedCCD_CONFIRM_FLAG(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		String C1 = "SELECT POL_FAC_YN FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ? ";
		String C2 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND PC_SCHD_PYMT_DT <= ? AND NVL(PC_FAC_CLOSE_FLAG,'N') = 'N' AND PC_PREM_TYPE != 'I'";
		String M_TEMP=null;
		String M_POL_FAC_YN = null;
		String M_DUMMY = null;
		
		ResultSet C1_REC = null;
		ResultSet C2_REC = null;
		
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
			
			Object [] obj_C1 = new Object[]{ pt_il_claim.getCLAIM_SYS_ID()};
	
			C1_REC = handler.executeSelectStatement(C1, connection,obj_C1);
			if(C1_REC.next()){
				M_POL_FAC_YN = C1_REC.getString(1);
			}
			
			if("Y".equalsIgnoreCase(M_POL_FAC_YN)){
				Object [] obj_C2 = new Object[]{ pt_il_claim.getCLAIM_SYS_ID(),pt_il_claim.getCLAIM_LOSS_DT()};
	
				C2_REC = handler.executeSelectStatement(C2, connection,obj_C2);
				if(C2_REC.next()){
					M_DUMMY = C2_REC.getString(1);
					pt_il_claim_cover_dtls.setCCD_CONFIRM_FLAG("Y");
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",new Object[] {"001","80274"}));	
				}
			}
			
			if("Y".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_FRZ_FLAG(), "N"))){
				if("N".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CLOSE_FLAG(), "N"))){
					if("Y".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CONFIRM_FLAG(), "N"))){
						PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
						pilt006_apac_procedure.P_INSERT_FAC_CLM_EST(
								pt_il_claim.getCLAIM_POL_SYS_ID(), 
								pt_il_claim.getCLAIM_SYS_ID(), 
								pt_il_claim.getCLAIM_CURR_CODE(), 
								pt_il_claim.getCLAIM_LOSS_DT(), 
								pt_il_claim_cover_dtls.getCCD_COVER_CODE(), 
								pt_il_claim_cover_dtls.getCCD_SYS_ID(), 
								pt_il_claim_cover_dtls.getCCD_FC_EST_AMT(), 
								pt_il_claim_cover_dtls.getCCD_LC_EST_AMT(), 
								pt_il_claim.getCLAIM_ASSR_CODE());
					}	
					
					if("SA".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_SET_FLAG())){
						PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
						pilt006_apac_procedure.INS_TREATY_ESTIMATE( 
								pt_il_claim.getCLAIM_POL_SYS_ID(),
								pt_il_claim.getCLAIM_SYS_ID(), 
								pt_il_claim.getCLAIM_CURR_CODE(), 
								pt_il_claim.getCLAIM_LOSS_DT(), 
								pt_il_claim_cover_dtls.getCCD_COVER_CODE(),
								pt_il_claim_cover_dtls.getCCD_SYS_ID(),
								pt_il_claim_cover_dtls.getCCD_FC_EST_AMT(), 
								pt_il_claim_cover_dtls.getCCD_LC_EST_AMT(), 
								pt_il_claim.getCLAIM_ASSR_CODE());
						
						/*Added by Saranya on 13/04//2017
*/						/*Commented by Saranya on 20/04/2017
*
*getSYS_ID_VALUE(compositeAction);
						P9ILPK_CLAIM.GENERATE_WOP_RESERVE(pt_il_claim.getCLAIM_SYS_ID().toString());
						UPDATE_RESERVE_GEN_FLAG(compositeAction);*/
						/*End*/
						
					}
				}
			}
			
			if(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_SETL_START_DT()==null){
				compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_SETL_START_DT(pt_il_claim.getCLAIM_LOSS_DT());
			}
			
			if("Y".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_FRZ_FLAG()) &&
					"Y".equalsIgnoreCase(pt_il_claim_cover_dtls.getCCD_CONFIRM_FLAG())){
				pt_il_claim_cover_dtls.setCCD_RESERVE_DT(new CommonUtils().getCurrentDate());
				
				/*Added by saritha on 21-02-2018 for Claim Charge Screen Create,Delete &Post button enable/disable as per siva sir sugg.*/
				
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_ADD().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_DEL().setDisabled(true);
				compositeAction.getPT_IL_CLAIM_CHRG_ACTION_BEAN().getUI_CHA_BUT_POST().setDisabled(true);
				
				/*End*/
				
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			if(C1_REC!=null){
				C1_REC.close();
			}
			if(C2_REC!=null){
				C2_REC.close();
			}
			CommonUtils.getConnection().commit();
		}
	}
	
	
	public void whenListChangedCCD_CLOSE_FLAG(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		String C1 = "SELECT POL_FAC_YN FROM   PT_IL_POLICY WHERE  POL_SYS_ID = ? ";
		String C2 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = ? AND PC_SCHD_PYMT_DT <= ? AND NVL(PC_FAC_CLOSE_FLAG,'N') = 'N' AND PC_PREM_TYPE != 'I'";
		String M_TEMP=null;
		String M_POL_FAC_YN = null;
		String M_DUMMY = null;
		
		PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
		
		try{
			Connection connection = CommonUtils.getConnection();
			CRUDHandler handler = new CRUDHandler();
			PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();

		   	if(value!=null && "Y".equals(CommonUtils.nvl(value.toString(), "N"))){
				if("Y".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_FRZ_FLAG(), "N"))){
					if("Y".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CONFIRM_FLAG(), "N"))){
						compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_FC_EST_AMT( CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_EST_AMT(), 0) - CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FC_EST_AMT(), 0));
						compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_LC_EST_AMT( CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_LC_EST_AMT(), 0) - CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_LC_EST_AMT(), 0));
						
						pilt006_apac_procedure.P_INSERT_FAC_CLM_EST(
								pt_il_claim.getCLAIM_POL_SYS_ID(), 
								pt_il_claim.getCLAIM_SYS_ID(), 
								pt_il_claim.getCLAIM_CURR_CODE(), 
								String.valueOf(pt_il_claim.getCLAIM_LOSS_DT()), 
								pt_il_claim_cover_dtls.getCCD_COVER_CODE(), 
								pt_il_claim_cover_dtls.getCCD_SYS_ID(), 
								pt_il_claim_cover_dtls.getCCD_FC_EST_AMT(), 
								pt_il_claim_cover_dtls.getCCD_LC_EST_AMT(), 
								pt_il_claim.getCLAIM_ASSR_CODE());

					}	
				}
			}else if("N".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CLOSE_FLAG(), "N"))){
				if("Y".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_FRZ_FLAG(), "N"))){
					if("N".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CONFIRM_FLAG(), "N"))){
						compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_FC_EST_AMT( CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_EST_AMT(), 0) - CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_FC_EST_AMT(), 0));
						compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_LC_EST_AMT( CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_LC_EST_AMT(), 0) - CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN().getCCD_LC_EST_AMT(), 0));
						
						pilt006_apac_procedure.P_INSERT_FAC_CLM_EST( 
								pt_il_claim.getCLAIM_POL_SYS_ID(), 
								pt_il_claim.getCLAIM_SYS_ID(), 
								pt_il_claim.getCLAIM_CURR_CODE(), 
								String.valueOf(pt_il_claim.getCLAIM_LOSS_DT()), 
								pt_il_claim_cover_dtls.getCCD_COVER_CODE(), 
								pt_il_claim_cover_dtls.getCCD_SYS_ID(), 
								pt_il_claim_cover_dtls.getCCD_FC_EST_AMT(), 
								pt_il_claim_cover_dtls.getCCD_LC_EST_AMT(), 
								pt_il_claim.getCLAIM_ASSR_CODE());

					}
				}
			}
			/*Modified by saranya for Hands on point num 23 on 14/02/2017*/
		   	compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_FC_NET_EST_AMT( 
		   			CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_EST_AMT(), 0)-  
		   			CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_PREM_OS(), 0)-
		   			CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_LOAN_OS(), 0)-
		   			CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_LOAN_INT(), 0)+
		   			//CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_CLM_PROC_FEE(), 0)-
		   					/*Added by gopi for Hands on feed back point num 16 in ZB on 15/02/2017*/
		   			//CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_FEE_PAID_HOSP(), 0)+
				/*end*/

		   			CommonUtils.nvl(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_ACC_PROFIT(), 0));
			/*end*/
		   	pilt006_apac_procedure.P_VAL_ROUND_AMT(
		   			pt_il_claim.getCLAIM_CURR_CODE(), 
		   			compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_NET_EST_AMT(), 
		   			"R");
		   	
		   	compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_FC_NET_EST_AMT(
		   			compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_NET_EST_AMT() *
		   			compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_EXCH_RATE());
		   	
		 	pilt006_apac_procedure.P_VAL_ROUND_AMT(
		 			compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_BASE_CURR(), 
		   			compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_FC_NET_EST_AMT(), 
		   			"R");
		 	
		 	if(compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().getCE_SETL_START_DT()==null){
		 		compositeAction.getPT_IL_CLAIM_ESTIMATE_ACTION_BEAN().getPT_IL_CLAIM_ESTIMATE_BEAN().setCE_SETL_START_DT(compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN().getCLAIM_LOSS_DT());
		 	}
		 	
		 	pilt006_apac_procedure.L_CLOSE_FLAG_CHK();
		 	
		 	if("Y".equals(CommonUtils.nvl(pt_il_claim_cover_dtls.getCCD_CLOSE_FLAG(), "N"))){
		 		 compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CLOSE_DT().setRequired(true);
		 		 pt_il_claim_cover_dtls.setCCD_CLOSE_DT(new CommonUtils().getCurrentDate());
		 	 }else{
		 		compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getCOMP_CCD_CLOSE_DT().setRequired(false);
		 		 pt_il_claim_cover_dtls.setCCD_CLOSE_DT(null);
		 	 }
		   	
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @param pilt006_apac_composite_action
	 * @param value
	 * @throws Exception
	 */
	public void whenValidateCCD_CLOSE_DATE(PILT006_APAC_COMPOSITE_ACTION compositeAction,
			Object value) throws Exception{
		try {
			PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
			PT_IL_CLAIM_COVER_DTLS pt_il_claim_cover_dtls = compositeAction.getPT_IL_CLAIM_COVER_DTLS_ACTION_BEAN().getPT_IL_CLAIM_COVER_DTLS_BEAN();
			
				Date date = CommonUtils.stringToDate(value.toString());
				if(date.before(compositeAction.getDUMMY_ACTION_BEAN().getDUMMY_BEAN().getM_POL_START_DT()) ||
						date.after(new CommonUtils().getCurrentDate())){
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"71099"));
				}
				
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	
	/*Added by saranya for RM018T - FSD_IL_ZB Life_001-Education Endowment Plan COMMENTS on 13-04-2017*/
	public long SYSID;
	
	public long getSYSID() {
		return SYSID;
	}

	public void setSYSID(long sYSID) {
		SYSID = sYSID;
	}
	public void getSYS_ID_VALUE(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = "SELECT CCD_SYS_ID FROM PT_IL_CLAIM_COVER_DTLS, PM_IL_COVER WHERE CCD_COVER_CODE = COVER_CODE"
				+ " AND NVL(CCD_FRZ_FLAG, 'N') = 'Y' AND NVL(CCD_CONFIRM_FLAG, 'N') = 'Y'"
				+ " AND NVL(CCD_RESERVE_GEN_FLAG, 'N') = 'N'  AND COVER_CLASS = 'W' "
				+ " AND CCD_CLAIM_SYS_ID = ?";
		ResultSet resultSet = null;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,new Object[] {pt_il_claim.getCLAIM_SYS_ID()});
			while (resultSet.next()) {
				CCD_SYS_ID_VALUE= resultSet.getLong("CCD_SYS_ID");
				setSYSID(CCD_SYS_ID_VALUE);
				System.out.println("COVER_CLASS   :"+getSYSID());
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	public void UPDATE_RESERVE_GEN_FLAG(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = " UPDATE PT_IL_CLAIM_COVER_DTLS SET CCD_RESERVE_GEN_FLAG = 'Y'"
				+ " WHERE CCD_CLAIM_SYS_ID = ? AND    CCD_SYS_ID =?";
		ResultSet resultSet = null;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] {pt_il_claim.getCLAIM_SYS_ID(),getSYSID()});
			connection.commit();
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	/*End*/

	public void CLM_EST_OS_AMTS(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_CLAIM pt_il_claim = compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		String CURSOR_C1 = " SELECT POL_SYS_ID,POL_STATUS,NVL(POL_SA_CURR_CODE,'001') POL_SA_CURR_CODE ,NVL(POL_CUST_CURR_CODE,'001') POL_CUST_CURR_CODE FROM PT_IL_POLICY  WHERE POL_NO = ? ";
		ResultSet resultSet = null;
		Connection connection = null;
		Long CCD_SYS_ID_VALUE=null;
		CRUDHandler handler = new CRUDHandler();
		String POL_SYS_ID = null;
		String POL_STATUS = null;
		String POL_SA_CURR_CODE = null;
		String POL_CUST_CURR_CODE = null;
		P9ILPK_CLAIM claim = new P9ILPK_CLAIM();
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(CURSOR_C1, connection,
					new Object[] {pt_il_claim.getCLAIM_POL_NO()});

			while (resultSet.next()) {
				POL_SYS_ID         =  resultSet.getString("POL_SYS_ID");
				POL_STATUS         =  resultSet.getString("POL_STATUS");
				POL_SA_CURR_CODE   =  resultSet.getString("POL_SA_CURR_CODE");
				POL_CUST_CURR_CODE =  resultSet.getString("POL_CUST_CURR_CODE");
			}
			
			
			
			claim.P_CLM_EST_OS_AMTS(pt_il_claim.getCLAIM_SYS_ID().toString(),
										   CommonUtils.dateToStringFormat(pt_il_claim.getCLAIM_LOSS_DT()),
										   POL_STATUS,
										   POL_SYS_ID,
										   pt_il_claim.getCLAIM_EXCH_RATE().toString(),
										   pt_il_claim.getCLAIM_CURR_CODE().toString(),
										   POL_SA_CURR_CODE,
										   POL_CUST_CURR_CODE,
										   CommonUtils.dateToStringFormat(pt_il_claim.getCLAIM_LOSS_DT()),
										   POL_CUST_CURR_CODE);
			
			System.out.println("P_CLM_EST_OS_AMTS -- Procedure Executed Successfully");
		
		
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	
	
	
}
