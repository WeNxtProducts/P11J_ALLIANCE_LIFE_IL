package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_DTL;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_DTL_DELEGATE;
import com.iii.pel.forms.PILT006_APAC.PILT006_APAC_PROCEDURE;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_RI_DETL_HELPER {
	/**
	 * @author 53058
	 *
	 * userid and time are set to object riDetlBean
	 * 
	 * @param riDetlBean - object of PT_IL_RI_DETL
	 * @throws ValidatorException
	 */
	
	public void execute(PILT010_COMPOSITE_ACTION compositeAction)throws Exception{
		
		try{
			executeQuery1();

			List<PT_IL_RI_DETL> dataList = compositeAction
					.getPILT010_PT_IL_RI_DETL_ACTION().getDataList_PT_IL_RI_DETL();
					
			if (dataList != null && dataList.size() > 0) {
				PT_IL_RI_DETL PT_IL_RI_DETL_BEAN = dataList.get(0);
				PT_IL_RI_DETL_BEAN.setRowSelected(true);
				compositeAction.getPILT010_PT_IL_RI_DETL_ACTION()
						.setPT_IL_RI_DETL_BEAN(PT_IL_RI_DETL_BEAN);
				
			}
			}catch(Exception e){
				throw new Exception(e.getMessage());
			}
			
	}
	
	public void preInsert(PT_IL_RI_DETL riDetlBean) throws ValidatorException {
		try {
			ControlBean ctrlBean = CommonUtils.getControlBean();
			riDetlBean.setRD_CR_UID(ctrlBean.getM_USER_ID());
			riDetlBean.setRD_CR_DT(Calendar.getInstance().getTime());
        } catch(Exception e) {
        	throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	/**
	 * @author 53058
	 * 
	 * Memory variable like TTY_CURR_DESC, CUST_CURR_DESC, POL_SA_CURR_DESC, 
	 *          PC_SYS_ID, PC_FAC_CLOSE_FLAG are set to the object riDetlBean
	 *
	 * @param riDetlBean - instance of type PT_IL_RI_DETL Bean
	 * @throws ValidatorException
	 */
	public PT_IL_RI_DETL postQuery(PT_IL_RI_DETL riDetlBean) throws ValidatorException {
		Double M_POL_LC_CURR_SA=null;
		String M_POL_CLASS_CODE=null;
		int M_PT_CURR_RATE=0;
		String M_PT_CURR_CODE=null;
		int M_POL_UW_YEAR=0;
		String M_RI_CLOSE_FLAG=null;
		ResultSet vembu_C1=null;
		ResultSet vembu_C2=null;
		ResultSet vembu_C3=null;
		ResultSet vembu_C4=null;
		ResultSet rs1=null;
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		CRUDHandler handler = new CRUDHandler();
		String RD_POL_NO = riDetlBean.getRD_POL_NO();
		String RD_TREATY_CODE = riDetlBean.getRD_TREATY_CODE().trim();
		Long RD_POL_SYS_ID  = riDetlBean.getRD_POL_SYS_ID();
		String RD_COVER_CODE = riDetlBean.getRD_COVER_CODE();
		int RD_COVER_SYS_ID = riDetlBean.getRD_COVER_SYS_ID();
		int RD_YEAR = riDetlBean.getRD_YEAR();
		int RD_END_NO_IDX = riDetlBean.getRD_END_NO_IDX();
		Date RD_SCHD_DT = riDetlBean.getRD_SCHD_DT();
		String RD_POL_SA_CURR_CODE = riDetlBean.getRD_POL_SA_CURR_CODE();
		String M_POL_SA_CURR_DESC = riDetlBean.getUI_M_POL_SA_CURR_DESC();
		String RD_CUST_PREM_CURR_CODE = riDetlBean.getRD_CUST_PREM_CURR_CODE();
		String M_CUST_CURR_DESC = riDetlBean.getUI_M_CUST_CURR_DESC();
		String RD_TREATY_CURR_CODE = riDetlBean.getRD_TREATY_CURR_CODE();
		String M_TTY_CURR_DESC = riDetlBean.getUI_M_TTY_CURR_DESC();
		try{
            String sql_C1="SELECT    POL_ASSURED_NAME,    POL_LC_CURR_SA,    POL_CLASS_CODE,    " +
            		"POL_START_DT,    POL_EXPIRY_DT,    POL_UW_YEAR FROM  PT_IL_POLICY  " +
            		"WHERE  POL_NO  = ? ";
            String sql_C2="SELECT    PT_CURR_RATE,    PT_CURR_CODE,    PT_TREATY_DESC " +
            		"FROM  PM_IL_PROP_TREATY  " +
            		"WHERE  PT_TREATY_CODE  = ?  " +
            		"AND PT_UW_YEAR  = ?  " +
            				"AND PT_CLASS_CODE  = ? ";
            String sql_C3="SELECT NVL(FR_FC_SPL_RET_PREM, 0) FROM  PS_IL_FAC_RI  " +
            		"WHERE  FR_POL_SYS_ID  = ?  " +
            		"AND FR_COVER_CODE  = ? " +
            		"AND FR_COVER_SYS_ID  = ? " +
            		"AND FR_YEAR  = ? ";
            String sql_C4="SELECT    NVL(PC_FAC_CLOSE_FLAG, 'N'),    PC_SYS_ID FROM  PT_IL_PREM_COLL  " +
            		"WHERE  PC_POL_SYS_ID  = ?  " +
            		"AND PC_END_NO_IDX  = ? " +
            		"AND PC_SCHD_PYMT_DT  = ?  " +
            		"AND TO_CHAR(PC_PAID_DT, 'YYYY')  = ? ";
            
            String query2="SELECT RPA_RI_CLOSE_FLAG FROM PT_IL_RI_PREM_ALLOC WHERE RPA_POL_SYS_ID=? AND RPA_RD_SYS_ID=?";
            
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_NO});
            String M_ASSR_NAME = null;
            Date M_PERIOD_FM = null;
        	Date M_PERIOD_TO = null;
            if(vembu_C1.next()) {
            	M_ASSR_NAME = vembu_C1.getString(1);
                M_POL_LC_CURR_SA=vembu_C1.getDouble(2);
                M_POL_CLASS_CODE=vembu_C1.getString(3);
                M_PERIOD_FM = vembu_C1.getDate(4);
                M_PERIOD_TO = vembu_C1.getDate(5);
                M_POL_UW_YEAR=vembu_C1.getInt(6);
            }
            riDetlBean.setUI_M_ASSR_NAME(M_ASSR_NAME);
            riDetlBean.setUI_M_PERIOD_FM(M_PERIOD_FM);
            riDetlBean.setUI_M_PERIOD_TO(M_PERIOD_TO);
            vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{RD_TREATY_CODE, M_POL_UW_YEAR, M_POL_CLASS_CODE});
            String M_TTY_CODE_DESC = null;
            if(vembu_C2.next()) {
            	M_PT_CURR_RATE = vembu_C2.getInt(1);
            	M_PT_CURR_CODE = vembu_C2.getString(2);
            	M_TTY_CODE_DESC = vembu_C2.getString(3);
            }
            riDetlBean.setUI_M_TTY_CODE_DESC(M_TTY_CODE_DESC);
            pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_PT_CURR_CODE(M_PT_CURR_CODE);
            pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_PT_CURR_RATE(M_PT_CURR_RATE);
            Double M_ORG_SA=M_POL_LC_CURR_SA/(M_PT_CURR_RATE==0?1:M_PT_CURR_RATE);
            ArrayList<OracleParameter> roundAmtList = new PILT006_APAC_PROCEDURE().P_VAL_ROUND_AMT(M_PT_CURR_CODE, M_ORG_SA, "R");
            Double mOrgSA = (Double)roundAmtList.get(0).getValueObject();
            M_ORG_SA =  mOrgSA;
            riDetlBean.setUI_M_ORG_SA(M_ORG_SA);
            vembu_C3=handler.executeSelectStatement(sql_C3, connection, new Object[]{RD_POL_SYS_ID, RD_COVER_CODE, RD_COVER_SYS_ID, RD_YEAR});
            String M_SPL_RETN_PREM = null;
            if(vembu_C3.next()) {
            	M_SPL_RETN_PREM = vembu_C3.getString(1);
            }
            riDetlBean.setUI_M_SPL_RETN_PREM(M_SPL_RETN_PREM);
            vembu_C4=handler.executeSelectStatement(sql_C4, connection, new Object[]{RD_POL_SYS_ID, RD_END_NO_IDX, CommonUtils.dateToStringFormatter(RD_SCHD_DT), RD_YEAR});
            String M_PC_FAC_CLOSE_FLAG=null;
            Integer M_PC_SYS_ID = null;
            if(vembu_C4.next()) {
            	M_PC_FAC_CLOSE_FLAG = vembu_C4.getString(1);
            	M_PC_SYS_ID = vembu_C4.getInt(2);
            }
            riDetlBean.setUI_M_PC_FAC_CLOSE_FLAG(M_PC_FAC_CLOSE_FLAG);
            pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_PC_SYS_ID(M_PC_SYS_ID);
            ArrayList<String> saCurrCodeList = new PILT006_APAC_PROCEDURE().P_VAL_CURR(RD_POL_SA_CURR_CODE,M_POL_SA_CURR_DESC,"N","N", null);
            riDetlBean.setUI_M_POL_SA_CURR_DESC(saCurrCodeList.get(0));
            ArrayList<String> custCurrCodeList = new PILT006_APAC_PROCEDURE().P_VAL_CURR( RD_CUST_PREM_CURR_CODE,M_CUST_CURR_DESC,"N","N", null);
            riDetlBean.setUI_M_CUST_CURR_DESC(custCurrCodeList.get(0));
            ArrayList<String> treatyCurrCodeList = new PILT006_APAC_PROCEDURE().P_VAL_CURR( RD_TREATY_CURR_CODE,M_TTY_CURR_DESC,"N","N", null);
            riDetlBean.setUI_M_TTY_CURR_DESC(treatyCurrCodeList.get(0));
            
            /*rs1=handler.executeSelectStatement(query2, connection, new Object[]{RD_POL_SYS_ID,riDetlBean.getRD_SYS_ID()});
            if(rs1.next()){
            	M_RI_CLOSE_FLAG=rs1.getString(1);
            	riDetlBean.setUI_M_CLOSEFLAG(CommonUtils.nvl(M_RI_CLOSE_FLAG,"N"));
            }*/  
            if("Y".equalsIgnoreCase(CommonUtils.nvl(riDetlBean.getRD_FRZ_FLAG(),"N"))){
            	riDetlBean.setUI_M_CLOSEFLAG("Y");
            }else{
            	riDetlBean.setUI_M_CLOSEFLAG("N");
            }
            
        }catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
        	try {
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
				CommonUtils.closeCursor(vembu_C3);
				CommonUtils.closeCursor(vembu_C4);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
        }
        return riDetlBean;
	}
	
	/**
	 * @author 53058
	 *
	 * appends additional where clause to executeQuery
	 *
	 * @return
	 * @throws ValidatorException
	 */
	public String preQuery() throws ValidatorException {
		String M_QUERY=null;
		int M_RD_YEAR=0;
		ResultSet vembu_C1=null;
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PV_IL_POL_RI_DETL_ACTION pvRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		String RD_POL_NO = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
		try {
            String sql_C1="SELECT R FROM  PT_IL_RI_DETL  " +
            		"WHERE  RD_POL_NO  = ?  " +
            		"AND RD_FRZ_FLAG  = 'N' ";
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_NO});
            if(vembu_C1.next()) {
                M_RD_YEAR=vembu_C1.getInt(1);
            }
            if(M_RD_YEAR != 0) {
            	 M_QUERY="RD_YEAR = "+M_RD_YEAR;
            } else {
               
                M_QUERY="RD_FRZ_FLAG  IN ('N','U')";
            }
        }catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
        	try {
				CommonUtils.closeCursor(vembu_C1);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
        }
        return M_QUERY;
	}
	
	/**
	 * @author 53058
	 *
	 * @param ptRiDetlBean
	 * @throws ValidatorException
	 */
	public void whenNewRecordInstance(PT_IL_RI_DETL ptRiDetlBean) throws ValidatorException {
		String RD_FRZ_FLAG = ptRiDetlBean.getRD_FRZ_FLAG();
		if((RD_FRZ_FLAG==null?"":RD_FRZ_FLAG).equals("N") || (RD_FRZ_FLAG==null?"":RD_FRZ_FLAG).equals("A")){
			ptRiDetlBean.setRD_REMARKS_DIS(false);
//			:DUMMY.M_ERR_FLAG := 'N';
		}else{
			ptRiDetlBean.setRD_REMARKS_DIS(true);
		}
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:38:12 PM
	 *
	 * retreives data from PV_IL_POL_RI_DETL
	 * 
	 * @throws ValidatorException
	 */
	public void executeQuery() throws ValidatorException {
		//String M_QUERY = preQuery();
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		//ptRiDetlAction.getDataList_PT_IL_RI_DETL().clear();
		ptRiDetlAction.getDataList_PT_IL_RI_DETL1().clear();
		String query = "SELECT ROWID, RD_SYS_ID,RD_POL_SYS_ID,RD_POL_NO,RD_END_NO_IDX,RD_END_NO," +
				"RD_UW_YEAR,RD_COVER_CODE,RD_COVER_SYS_ID,RD_COVER_TYPE,RD_TREATY_CODE," +
				"RD_SCHD_DT,RD_YEAR,RD_ASSURED_AGE,RD_TAR_RATE,RD_FC_SA,RD_FC_PREM,RD_FC_SUM_CEDED," +
				"RD_FC_POL_SA,RD_LC_POL_SA,RD_FC_POL_PREM,RD_LC_POL_PREM,RD_POL_EXCH_RATE," +
				"RD_POL_SA_CURR_CODE,RD_TREATY_CURR_CODE,RD_CUST_PREM_CURR_CODE,RD_CUST_PREM_EXCH_RATE," +
				"RD_TAR_RATE_PER,RD_ASSR_CODE,RD_FRZ_FLAG,RD_PRD_FM_DT,RD_PRD_TO_DT,TO_CHAR(RD_PRD_FM_DT,'DD/MM/RRRR')FM_DT,TO_CHAR(RD_PRD_TO_DT," +
				"'DD/MM/RRRR')TO_DT,RD_LC_PRD_PREM,RD_PRD_YEAR,RD_PRD_NO,RD_USER_UPD_YN,RD_REMARKS " +
				"FROM PT_IL_RI_DETL " +
				"WHERE RD_POL_SYS_ID=? " +
				//"AND RD_END_NO_IDX=? " +
				"AND RD_FRZ_FLAG IN('Y','N')";
		
		
		Long RD_POL_SYS_ID = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID()==null ? 0 : pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
		int RD_END_NO_IDX = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX()==null ? 0 : pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
		ResultSet rst = null;
		ResultSet rst1 = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{RD_POL_SYS_ID});
			while(rst.next()){
				PT_IL_RI_DETL riDetlBean = new PT_IL_RI_DETL();
				riDetlBean.setROWID(rst.getString("ROWID"));
				riDetlBean.setRD_SYS_ID(rst.getInt("RD_SYS_ID"));
				riDetlBean.setRD_POL_SYS_ID(rst.getLong("RD_POL_SYS_ID"));
				riDetlBean.setRD_POL_NO(rst.getString("RD_POL_NO"));
				riDetlBean.setRD_END_NO_IDX(rst.getInt("RD_END_NO_IDX"));
				riDetlBean.setRD_END_NO(rst.getString("RD_END_NO"));
				riDetlBean.setRD_UW_YEAR(rst.getInt("RD_UW_YEAR"));
				riDetlBean.setRD_COVER_CODE(rst.getString("RD_COVER_CODE"));
				riDetlBean.setRD_COVER_SYS_ID(rst.getInt("RD_COVER_SYS_ID"));
				riDetlBean.setRD_COVER_TYPE(rst.getString("RD_COVER_TYPE"));
				riDetlBean.setRD_TREATY_CODE(rst.getString("RD_TREATY_CODE"));
				riDetlBean.setRD_SCHD_DT(rst.getDate("RD_SCHD_DT"));
				riDetlBean.setRD_YEAR(rst.getInt("RD_YEAR"));
				riDetlBean.setRD_ASSURED_AGE(rst.getInt("RD_ASSURED_AGE"));
				riDetlBean.setRD_TAR_RATE(rst.getDouble("RD_TAR_RATE"));
				riDetlBean.setRD_FC_SA(rst.getDouble("RD_FC_SA"));
				riDetlBean.setRD_FC_PREM(rst.getDouble("RD_FC_PREM"));
				/*riDetlBean.setRD_FC_SUM_CEDED(rst.getDouble("RD_FC_SUM_CEDED"));
				riDetlBean.setRD_FC_POL_SA(rst.getDouble("RD_FC_POL_SA"));
				riDetlBean.setRD_LC_POL_SA(rst.getDouble("RD_LC_POL_SA"));
				riDetlBean.setRD_FC_POL_PREM(rst.getDouble("RD_FC_POL_PREM"));
				riDetlBean.setRD_LC_POL_PREM(rst.getDouble("RD_LC_POL_PREM"));*/
				riDetlBean.setRD_POL_EXCH_RATE(rst.getInt("RD_POL_EXCH_RATE"));
				riDetlBean.setRD_POL_SA_CURR_CODE(rst.getString("RD_POL_SA_CURR_CODE"));
				riDetlBean.setRD_TREATY_CURR_CODE(rst.getString("RD_TREATY_CURR_CODE"));
				riDetlBean.setRD_CUST_PREM_CURR_CODE(rst.getString("RD_CUST_PREM_CURR_CODE"));
				riDetlBean.setRD_CUST_PREM_EXCH_RATE(rst.getInt("RD_CUST_PREM_EXCH_RATE"));
				riDetlBean.setRD_TAR_RATE_PER(rst.getInt("RD_TAR_RATE_PER"));
				riDetlBean.setRD_ASSR_CODE(rst.getString("RD_ASSR_CODE"));
				riDetlBean.setRD_FRZ_FLAG(rst.getString("RD_FRZ_FLAG"));
				
				riDetlBean.setRD_PRD_FM_DT(rst.getDate("RD_PRD_FM_DT"));
				riDetlBean.setRD_PRD_TO_DT(rst.getDate("RD_PRD_FM_DT"));
				riDetlBean.setUI_RD_PRD_FM_DT(rst.getString("FM_DT"));
				riDetlBean.setUI_RD_PRD_TO_DT(rst.getString("TO_DT"));
				riDetlBean.setRD_LC_PRD_PREM(rst.getDouble("RD_LC_PRD_PREM"));
//				riDetlBean.setRD_PRD_YEAR(rst.getInt("RD_PRD_YEAR"));
//				riDetlBean.setRD_PRD_NO(rst.getInt("RD_PRD_NO"));
				riDetlBean.setRD_REMARKS(rst.getString("RD_REMARKS"));
				riDetlBean = postQuery(riDetlBean);
				
				//ptRiDetlAction.getDataList_PT_IL_RI_DETL().add(riDetlBean);
				ptRiDetlAction.getDataList_PT_IL_RI_DETL1().add(riDetlBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void executeQuery1() throws ValidatorException {
		//String M_QUERY = preQuery();
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		ptRiDetlAction.getDataList_PT_IL_RI_DETL().clear();
		//ptRiDetlAction.getDataList_PT_IL_RI_DETL1().clear();
		String query = "SELECT ROWID, RD_SYS_ID,RD_POL_SYS_ID,RD_POL_NO,RD_END_NO_IDX,RD_END_NO," +
				"RD_UW_YEAR,RD_COVER_CODE,RD_COVER_SYS_ID,RD_COVER_TYPE,RD_TREATY_CODE," +
				"RD_SCHD_DT,RD_YEAR,RD_ASSURED_AGE,RD_TAR_RATE,RD_FC_SA,RD_FC_PREM,RD_FC_SUM_CEDED," +
				"RD_FC_POL_SA,RD_LC_POL_SA,RD_FC_POL_PREM,RD_LC_POL_PREM,RD_POL_EXCH_RATE," +
				"RD_POL_SA_CURR_CODE,RD_TREATY_CURR_CODE,RD_CUST_PREM_CURR_CODE,RD_CUST_PREM_EXCH_RATE," +
				"RD_TAR_RATE_PER,RD_ASSR_CODE,RD_FRZ_FLAG,RD_PRD_FM_DT,RD_PRD_TO_DT,RD_LC_PRD_PREM," +
				"RD_PRD_YEAR,RD_PRD_NO,RD_USER_UPD_YN,RD_REMARKS " +
				"FROM PT_IL_RI_DETL " +
				"WHERE RD_POL_SYS_ID=? " +
				//"AND RD_END_NO_IDX=? " +
				"AND RD_SYS_ID=? " +
				"AND RD_FRZ_FLAG IN('Y','N')";
		
		int RD_SYS_ID=ptRiDetlAction.getPT_IL_RI_DETL_BEAN1().getRD_SYS_ID();
		Long RD_POL_SYS_ID = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID()==null ? 0 : pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
		int RD_END_NO_IDX = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX()==null ? 0 : pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{RD_POL_SYS_ID, RD_SYS_ID});
			while(rst.next()){
				PT_IL_RI_DETL riDetlBean = new PT_IL_RI_DETL();
				riDetlBean.setROWID(rst.getString("ROWID"));
				riDetlBean.setRD_SYS_ID(rst.getInt("RD_SYS_ID"));
				riDetlBean.setRD_POL_SYS_ID(rst.getLong("RD_POL_SYS_ID"));
				riDetlBean.setRD_POL_NO(rst.getString("RD_POL_NO"));
				riDetlBean.setRD_END_NO_IDX(rst.getInt("RD_END_NO_IDX"));
				riDetlBean.setRD_END_NO(rst.getString("RD_END_NO"));
				riDetlBean.setRD_UW_YEAR(rst.getInt("RD_UW_YEAR"));
				riDetlBean.setRD_COVER_CODE(rst.getString("RD_COVER_CODE"));
				riDetlBean.setRD_COVER_SYS_ID(rst.getInt("RD_COVER_SYS_ID"));
				riDetlBean.setRD_COVER_TYPE(rst.getString("RD_COVER_TYPE"));
				riDetlBean.setRD_TREATY_CODE(rst.getString("RD_TREATY_CODE"));
				riDetlBean.setRD_SCHD_DT(rst.getDate("RD_SCHD_DT"));
				riDetlBean.setRD_YEAR(rst.getInt("RD_YEAR"));
				riDetlBean.setRD_ASSURED_AGE(rst.getInt("RD_ASSURED_AGE"));
				riDetlBean.setRD_TAR_RATE(rst.getDouble("RD_TAR_RATE"));
				riDetlBean.setRD_FC_SA(rst.getDouble("RD_FC_SA"));
				riDetlBean.setRD_FC_PREM(rst.getDouble("RD_FC_PREM"));
				/*riDetlBean.setRD_FC_SUM_CEDED(rst.getDouble("RD_FC_SUM_CEDED"));
				riDetlBean.setRD_FC_POL_SA(rst.getDouble("RD_FC_POL_SA"));
				riDetlBean.setRD_LC_POL_SA(rst.getDouble("RD_LC_POL_SA"));
				riDetlBean.setRD_FC_POL_PREM(rst.getDouble("RD_FC_POL_PREM"));
				riDetlBean.setRD_LC_POL_PREM(rst.getDouble("RD_LC_POL_PREM"));*/
				riDetlBean.setRD_POL_EXCH_RATE(rst.getInt("RD_POL_EXCH_RATE"));
				riDetlBean.setRD_POL_SA_CURR_CODE(rst.getString("RD_POL_SA_CURR_CODE"));
				riDetlBean.setRD_TREATY_CURR_CODE(rst.getString("RD_TREATY_CURR_CODE"));
				riDetlBean.setRD_CUST_PREM_CURR_CODE(rst.getString("RD_CUST_PREM_CURR_CODE"));
				riDetlBean.setRD_CUST_PREM_EXCH_RATE(rst.getInt("RD_CUST_PREM_EXCH_RATE"));
				riDetlBean.setRD_TAR_RATE_PER(rst.getInt("RD_TAR_RATE_PER"));
				riDetlBean.setRD_ASSR_CODE(rst.getString("RD_ASSR_CODE"));
				riDetlBean.setRD_FRZ_FLAG(rst.getString("RD_FRZ_FLAG"));
				riDetlBean.setRD_PRD_FM_DT(rst.getDate("RD_PRD_FM_DT"));
				riDetlBean.setRD_PRD_TO_DT(rst.getDate("RD_PRD_TO_DT"));
				riDetlBean.setRD_LC_PRD_PREM(rst.getDouble("RD_LC_PRD_PREM"));
//				riDetlBean.setRD_PRD_YEAR(rst.getInt("RD_PRD_YEAR"));
//				riDetlBean.setRD_PRD_NO(rst.getInt("RD_PRD_NO"));
				riDetlBean.setRD_REMARKS(rst.getString("RD_REMARKS"));
				riDetlBean = postQuery(riDetlBean);
				ptRiDetlAction.getDataList_PT_IL_RI_DETL().add(riDetlBean);
				//ptRiDetlAction.getDataList_PT_IL_RI_DETL1().add(riDetlBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	
	
	
	
	
	public void populatePremiumAllocationDetails() throws ValidatorException {
		PT_IL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		riDetlAction.setPT_IL_RI_DETL_BEAN(getDataTableRowInstance());
		PT_IL_RI_PREM_ALLOC_HELPER premAllocHelper = new PT_IL_RI_PREM_ALLOC_HELPER();
		premAllocHelper.executeQuery();
	}
	
	public PT_IL_RI_DETL getDataTableRowInstance() throws ValidatorException {
		PT_IL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		int rowIndex = riDetlAction.getCOMP_PT_IL_RI_DETL_DATATABLE().getRowIndex();
		return riDetlAction.getDataList_PT_IL_RI_DETL().get(rowIndex);
	}

}
