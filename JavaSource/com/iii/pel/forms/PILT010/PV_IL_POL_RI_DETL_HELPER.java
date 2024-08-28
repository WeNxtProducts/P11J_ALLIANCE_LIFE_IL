package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PV_IL_POL_RI_DETL_HELPER {
	
	public void preForm() throws ValidatorException {
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		try{
			String callingForm = CommonUtils.getGlobalVariable("CALLING_FORM");
            if(callingForm== null){
            	sessionMap.put("GLOBAL.M_FAILURE", "FALSE");
            	sessionMap.put("GLOBAL.M_DFLT_VALUES", "00101    01");
//                :GLOBAL.M_MODULE_NAME=GET_FORM_PROPERTY.GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME);
            }
//            STD_PRE_FORM.STD_PRE_FORM();
            String mForLangCode = (String) sessionMap.get("GLOBAL.M_FOR_LANG_CODE");
            if(mForLangCode!=null && mForLangCode.length()>5){
            	if((mForLangCode.substring(0, 5)).equals("1")){
            		
            	}
            }
            PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
            riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_PT_IL_RI_DETL_CF("P");
            riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_PT_IL_RI_PREM_ALLOC_CF("P");
            riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setUI_M_PV_IL_POL_RI_DETL_CF("N");
            if(!("PILT002_APAC".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))))
            {
            	CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",null);
            	//sessionMap.put("GLOBAL.M_POL_NO", null);
            }
        }catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
	}
	
	/**
	 * 
	 * @author 53058
	 * Feb 3, 2009 5:25:25 PM
	 *
	 *
	 * @throws ValidatorException
	 */
	public void whenNewFormInstance() throws ValidatorException {
		
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:25:25 PM
	 * 
	 * called every time a record is created or modified.
	 * @throws ValidatorException
	 * 
	 * currently this method is not called as no insert/update is done
	 */
	public void PV_IL_POL_RI_DETL_whenNewRecordInstance() throws ValidatorException {
		String M_POL_START_DT=null;
		String M_DUMMY=null;
		String M_CLOSE_FLAG=null;
		String M_FAC_YN=null;
		ResultSet vembu_C1=null;
		ResultSet vembu_C2=null;
		ResultSet vembu_C3=null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		PV_IL_POL_RI_DETL_ACTION pvIlPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		PT_IL_RI_DETL_ACTION ptIlRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
		Long RD_POL_SYS_ID = pvIlPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
		int RD_YEAR = pvIlPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_YEAR();
		int RD_END_NO_IDX = ptIlRiDetlAction.getPT_IL_RI_DETL_BEAN().getRD_END_NO_IDX();
		int PV_RD_END_NO_IDX = pvIlPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
		try {
			connection = PILT010_ACTION_INSTANCE.getConnection();
            String sql_C1="SELECT NVL(RPA_RI_CLOSE_FLAG, 'N') " +
            		"FROM  PT_IL_RI_PREM_ALLOC  " +
            		"WHERE  RPA_POL_SYS_ID  = ?  " +
            		"AND RPA_YEAR  = ?  " +
            		"AND RPA_END_NO_IDX  = ? ";
            String sql_C2="SELECT    NVL(POL_FAC_YN, 'N'),    POL_START_DT " +
            		"FROM  PT_IL_POLICY  " +
            		"WHERE  POL_SYS_ID  = ? ";
            String sql_C3="SELECT 'X' FROM  PT_IL_RI_DETL  " +
            		"WHERE  RD_POL_SYS_ID  = ?  " +
            		"AND RD_END_NO_IDX  = ?  " +
            		"AND ?  BETWEEN RD_PRD_FM_DT  AND  RD_PRD_TO_DT  " +
            				"AND RD_FRZ_FLAG  = 'N' ";
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_SYS_ID, RD_YEAR, RD_END_NO_IDX});
            if(vembu_C1.next()) {
                M_CLOSE_FLAG=vembu_C1.getString(1);
            }
            if(M_CLOSE_FLAG.equals("Y")) {
                /*:DUMMY.B_RI_CLOSE=" ";
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_RI_PREM_ALLOC",UPDATE_ALLOWED,PROPERTY_FALSE);*/
            }
            else {
                /*:DUMMY.B_RI_CLOSE="      ";
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_RI_PREM_ALLOC",UPDATE_ALLOWED,PROPERTY_FALSE);*/
            }
            vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{RD_POL_SYS_ID});
            if(vembu_C2.next())
            {
                M_FAC_YN=vembu_C2.getString(1);
                M_POL_START_DT=vembu_C2.getString(2);
            }
            vembu_C3=handler.executeSelectStatement(sql_C3, connection, new Object[]{RD_POL_SYS_ID, PV_RD_END_NO_IDX, M_POL_START_DT});
            if(vembu_C3.next())
            {
                M_DUMMY=vembu_C3.getString(1);
            }
        }catch(Exception e) {
        	throw new ValidatorException(new FacesMessage(e.getMessage()));
        }
        finally {
            try {
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
				CommonUtils.closeCursor(vembu_C3);
			} catch (Exception e) {
			}
        }
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:25:25 PM
	 *  
	 * calls executeQuery(), if the calling form is PILT002_APAC
	 * @throws ValidatorException
	 */
	public void PV_IL_POL_RI_DETL_whenNewBlockInstance(PILT010_COMPOSITE_ACTION compositeAction) throws ValidatorException {
		System.out.println("Welcoem to PV_IL_POL_RI_DETL_whenNewBlockInstance");
		Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		Connection connection = null;
		ResultSet rst = null,rs=null;
		String qur ="SELECT PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE='IL_CALC_MTHD'";
		Double M_PS_VALUE = null;
		try {
			rs= new CRUDHandler().executeSelectStatement(qur, CommonUtils.getConnection());
			if(rs.next()){
				M_PS_VALUE = rs.getDouble(1);
			}
			System.out.println("M_PS_VALUE        "+M_PS_VALUE);
			if(M_PS_VALUE == 2.0){
				compositeAction.getPILT010_DUMMY_ACTION().getCOMP_SYS_CALC().setRendered(false);
				compositeAction.getPILT010_DUMMY_ACTION().getCOMP_USR_CALC().setRendered(false);
			}else{
				compositeAction.getPILT010_DUMMY_ACTION().getCOMP_SYS_CALC().setRendered(true);
				compositeAction.getPILT010_DUMMY_ACTION().getCOMP_USR_CALC().setRendered(true);
			}
			//String callingForm = (String) sessionMap.get("CALLING_FORM");
			if("PILT002_APAC".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))){
			//if((callingForm==null?"":callingForm).equals("PILT002_APAC")){
				executeQuery();
			}else{
				String query = "SELECT COUNT(DISTINCT(RD_POL_NO)) FROM PV_IL_POL_RI_DETL";
				PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
				connection = PILT010_ACTION_INSTANCE.getConnection();
				CRUDHandler handler = new CRUDHandler();
				rst = handler.executeSelectStatement(query, connection, new Object[]{});
				while(rst.next()){
					riDetlAction.getPV_IL_POL_RI_DETL_BEAN().setDB_POL_COUNT(rst.getInt(1));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:25:25 PM
	 *  
	 * Policy No is set from session if the calling form is PILT002_APAC
	 * @throws ValidatorException
	 */
	public void preQuery(PV_IL_POL_RI_DETL PV_IL_POL_RI_DETL_BEAN) throws ValidatorException {
		
		if("PILT002_APAC".equals(CommonUtils.getGlobalVariable("CALLING_FORM"))){
			PV_IL_POL_RI_DETL_BEAN.setRD_POL_NO(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));
		}
		else if("PILQ003_APAC".equals(CommonUtils.getGlobalObject("CALLING_FORM"))){ 
		//SET_BLOCK_PROPERTY('PV_IL_POL_RI_DETL',DEFAULT_WHERE,'RD_POL_NO='||''''||:GLOBAL.M_POL_NO||'''');
			String DEFAULT_WHERE = " PV_IL_POL_RI_DETL.RD_POL_NO = '"+CommonUtils.
									getGlobalVariable("GLOBAL.M_POL_NO").toString()+"'";
			
		}
		else if(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO") != null && PV_IL_POL_RI_DETL_BEAN.getRD_POL_NO() == null){
		   PV_IL_POL_RI_DETL_BEAN.setRD_POL_NO(CommonUtils.getGlobalVariable("GLOBAL.M_POL_NO"));		
		}
		
		/*else if(null==(CommonUtils.getGlobalVariable("CALLING_FORM"))){
			CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO",PV_IL_POL_RI_DETL_BEAN.getRD_POL_NO());
			
		}*/
		
		/*Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		try {
			String callingForm = (String) sessionMap.get("CALLING_FORM");
			String M_POL_NO = (String) sessionMap.get("GLOBAL.M_POL_NO");
			if((callingForm==null?"":callingForm).equals("PILT002_APAC") && M_POL_NO!=null){
				pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_POL_NO(M_POL_NO);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}*/
	}
	
	public void postQuery() throws ValidatorException {
		String M_POL_START_DT=null;
		String M_DUMMY=null;
		ResultSet vembu_C1=null;
		ResultSet vembu_C2=null;
		PV_IL_POL_RI_DETL_ACTION pvPolRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		Long RD_POL_SYS_ID = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_SYS_ID();
		int PV_RD_END_NO_IDX = pvPolRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		try {
            String sql_C1="SELECT POL_START_DT FROM  PT_IL_POLICY  " +
            		"WHERE  POL_SYS_ID  = ? ";
            String sql_C2="SELECT 'X' FROM  PT_IL_RI_DETL  " +
            		"WHERE  RD_POL_SYS_ID  = ?  " +
            		"AND RD_END_NO_IDX  = ? " +
            		"AND ?  BETWEEN RD_PRD_FM_DT  AND  RD_PRD_TO_DT  " +
            				"AND RD_FRZ_FLAG  = 'N' ";
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RD_POL_SYS_ID});
            if(vembu_C1.next()) {
                M_POL_START_DT=vembu_C1.getString(1);
            }
            vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{RD_POL_SYS_ID, PV_RD_END_NO_IDX, M_POL_START_DT});
            if(vembu_C2.next()) {
                M_DUMMY=vembu_C2.getString(1);
            }
        } catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
            try {
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
			} catch (Exception e) {
			}
        }
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:25:25 PM
	 * 
	 * For a Policy No and Endorsement Index retreives data from PV_IL_POL_RI_DETL
	 * @throws ValidatorException
	 * 
	 * postQuery() is commented as there is no validation in it.
	 */
	public void executeQuery() throws ValidatorException {
		/* added by raja on 18-08-2017 for ZBILQC-1735458 */
		PV_IL_POL_RI_DETL_ACTION pvRiDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		
		preQuery(pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN());
		String RD_POL_NO = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
		Integer RD_END_NO_IDX = pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_END_NO_IDX();
		/*end*/
		if(pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO() == null){
			throw new ValidatorException(new FacesMessage("Policy No should be specified first"));
		}
		//if(RD_END_NO_IDX==null){
			RD_END_NO_IDX  = getEndorsementNoIdx();
		//}
		String query = "SELECT RD_POL_NO,RD_POL_SYS_ID,RD_END_NO_IDX,RD_END_NO,RD_UW_YEAR,RD_YEAR," +
				"POL_CLASS_CODE,POL_CONT_CODE,POL_PERIOD,POL_START_DT,POL_EXPIRY_DT,POL_PROD_CODE " +
				"FROM PV_IL_POL_RI_DETL " +
				"WHERE RD_POL_NO = ? " +
				"AND RD_END_NO_IDX = ? " +
				"ORDER BY RD_YEAR";
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		
		PV_IL_POL_RI_DETL bean=new PV_IL_POL_RI_DETL();
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{RD_POL_NO, RD_END_NO_IDX});
			bean.setRD_POL_NO(RD_POL_NO);
			while(rst.next()){
				
				/* added by raja on 18-08-2017 for ZBILQC-1735458 */
				/*pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_POL_SYS_ID(rst.getLong("RD_POL_SYS_ID"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_POL_NO(rst.getString("RD_POL_NO"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_END_NO_IDX(rst.getInt("RD_END_NO_IDX"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_END_NO(rst.getString("RD_END_NO"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_UW_YEAR(rst.getInt("RD_UW_YEAR"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setRD_YEAR(rst.getInt("RD_YEAR"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setPOL_CLASS_CODE(rst.getString("POL_CLASS_CODE"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setPOL_CONT_CODE(rst.getString("POL_CONT_CODE"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setPOL_PERIOD(rst.getInt("POL_PERIOD"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setPOL_START_DT(rst.getDate("POL_START_DT"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setPOL_EXPIRY_DT(rst.getDate("POL_EXPIRY_DT"));
				pvRiDetlAction.getPV_IL_POL_RI_DETL_BEAN().setPOL_PROD_CODE(rst.getString("POL_PROD_CODE"));*/
				
				bean.setRD_POL_SYS_ID(rst.getLong("RD_POL_SYS_ID"));
				bean.setRD_POL_NO(rst.getString("RD_POL_NO"));
				bean.setRD_END_NO_IDX(rst.getInt("RD_END_NO_IDX"));
				bean.setRD_END_NO(rst.getString("RD_END_NO"));
				bean.setRD_UW_YEAR(rst.getInt("RD_UW_YEAR"));
				bean.setRD_YEAR(rst.getInt("RD_YEAR"));
				bean.setPOL_CLASS_CODE(rst.getString("POL_CLASS_CODE"));
				bean.setPOL_CONT_CODE(rst.getString("POL_CONT_CODE"));
				bean.setPOL_PERIOD(rst.getInt("POL_PERIOD"));
				bean.setPOL_START_DT(rst.getDate("POL_START_DT"));
				bean.setPOL_EXPIRY_DT(rst.getDate("POL_EXPIRY_DT"));
				bean.setPOL_PROD_CODE(rst.getString("POL_PROD_CODE"));
			
			/*end*/
			}
			pvRiDetlAction.setPV_IL_POL_RI_DETL_BEAN(bean);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
//		postQuery();
	}
	
	public void fetchData(){
		
	}
	
	public Integer getEndorsementNoIdx() throws ValidatorException {
		PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		String polNo = riDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
		//String query = "SELECT MAX(RD_END_NO_IDX) FROM PV_IL_POL_RI_DETL WHERE RD_POL_NO = ?";
		String query = "SELECT MAX(RPA_END_NO_IDX) FROM PT_IL_RI_PREM_ALLOC WHERE RPA_POL_NO = ?";
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		Integer endNoIdx = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{polNo});
			while(rst.next()){
				endNoIdx = rst.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try{
				CommonUtils.closeCursor(rst);
			}catch(Exception e){
			}
		}
		return endNoIdx;
	}
	
	public List<PV_IL_POL_RI_DETL> RD_POL_NOList(String polNo) throws ValidatorException {
		if(polNo!=null){
			if(polNo.equals("*"))
				polNo = "%";
			else
				polNo += "%";
		}
		/*commented by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016
		 * 
		 * String query = "SELECT DISTINCT(RD_POL_NO) FROM PV_IL_POL_RI_DETL " +
				"WHERE RD_POL_NO LIKE NVL(?, RD_POL_NO) " +
				"AND ROWNUM<26";*/
		/*Added by Ameen for lov lower case issue ssp call id FALCONLIFE-1344105 on 15-10-2016*/
		String query = "SELECT DISTINCT(RD_POL_NO) FROM PV_IL_POL_RI_DETL " +
				"WHERE UPPER(RD_POL_NO) LIKE NVL(UPPER(?), RD_POL_NO) " +
				"AND ROWNUM<26";
		/*end*/
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		List<PV_IL_POL_RI_DETL> riDetlList = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{polNo});
			riDetlList = new ArrayList<PV_IL_POL_RI_DETL>();
			while(rst.next()){
				PV_IL_POL_RI_DETL riDetlBean = new PV_IL_POL_RI_DETL();
				riDetlBean.setRD_POL_NO(rst.getString(1));
				riDetlList.add(riDetlBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		} finally {
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
		return riDetlList;
	}
	
	public List<PV_IL_POL_RI_DETL> RD_END_NO_IDXList(String endNoIdx) throws ValidatorException {
		if(endNoIdx!=null){
			if(endNoIdx.equals("*"))
				endNoIdx = "%";
			else
				endNoIdx += "%";
		}
		PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		String RD_POL_NO = riDetlAction.getPV_IL_POL_RI_DETL_BEAN().getRD_POL_NO();
		List<PV_IL_POL_RI_DETL> riDetlList = null;
		if(RD_POL_NO!=null){
			String query = "SELECT DISTINCT RD_END_NO_IDX FROM PV_IL_POL_RI_DETL " +
					"WHERE RD_POL_NO = ? " +
					"AND RD_END_NO_IDX LIKE NVL(?, RD_END_NO_IDX) " +
					"ORDER BY RD_END_NO_IDX";
			CRUDHandler handler = new CRUDHandler();
			Connection connection = PILT010_ACTION_INSTANCE.getConnection();
			ResultSet rst = null;
			try {
				rst = handler.executeSelectStatement(query, connection, new Object[]{RD_POL_NO, endNoIdx});
				riDetlList = new ArrayList<PV_IL_POL_RI_DETL>();
				while(rst.next()){
					PV_IL_POL_RI_DETL riDetlBean = new PV_IL_POL_RI_DETL();
					riDetlBean.setRD_END_NO_IDX(rst.getInt(1));
					riDetlList.add(riDetlBean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			} finally {
				try {
					CommonUtils.closeCursor(rst);
				} catch (Exception e) {
					e.printStackTrace();
					throw new ValidatorException(new FacesMessage(e.getMessage()));
				}
			}
		} else {
			throw new ValidatorException(new FacesMessage("Policy No should be specified first"));
		}
		return riDetlList;
	}
	
	public void refreshComponents(){
		PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		riDetlAction.getCOMP_RD_END_NO_IDX().setSubmittedValue(null);
		riDetlAction.getCOMP_RD_END_NO().setSubmittedValue(null);
		riDetlAction.getCOMP_RD_UW_YEAR().setSubmittedValue(null);
		riDetlAction.getCOMP_RD_YEAR().setSubmittedValue(null);
		riDetlAction.getCOMP_POL_CLASS_CODE().setSubmittedValue(null);
		riDetlAction.getCOMP_POL_CONT_CODE().setSubmittedValue(null);
		riDetlAction.getCOMP_POL_START_DT().setSubmittedValue(null);
		riDetlAction.getCOMP_POL_EXPIRY_DT().setSubmittedValue(null);
		riDetlAction.getCOMP_POL_PERIOD().setSubmittedValue(null);
		riDetlAction.getCOMP_POL_PROD_CODE().setSubmittedValue(null);
	}
	
	public void clearErrorMap(){
		PV_IL_POL_RI_DETL_ACTION riDetlAction = PILT010_ACTION_INSTANCE.getPV_IL_POL_RI_DETL_ACTION_INSTANCE();
		riDetlAction.getErrorMap().clear();
		riDetlAction.getWarningMap().clear();
		riDetlAction.setErrorMessages(null);
		riDetlAction.setWarningMessages(null);
	}
	
	
	
	
	public void executeForm() throws ValidatorException {
		try {
			refreshComponents();
			executeQuery();
			/*PT_IL_RI_DETL_HELPER ptRiDetlHelper = new PT_IL_RI_DETL_HELPER();
			ptRiDetlHelper.executeQuery();*/
			
			PT_IL_RI_DETL_ACTION ptRiDetlAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DETL_ACTION_INSTANCE();
			PT_IL_RI_PREM_ALLOC_ACTION riPremAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_ACTION_INSTANCE();
			//List<PT_IL_RI_DETL> ptRiDetlList = ptRiDetlAction.getDataList_PT_IL_RI_DETL1();
			riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC().clear();
			/*if(ptRiDetlList!=null && ptRiDetlList.size()>0){
				PT_IL_RI_DETL riDetlBean = ptRiDetlList.get(0);
				ptRiDetlAction.setPT_IL_RI_DETL_BEAN1(riDetlBean);
				PT_IL_RI_PREM_ALLOC_HELPER riPremAllocHelper = new PT_IL_RI_PREM_ALLOC_HELPER();
				riPremAllocHelper.executeQuery();
				List<PT_IL_RI_PREM_ALLOC> ptPremAllocList = riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC();
				if(ptPremAllocList!=null && ptPremAllocList.size()>0){
					PT_IL_RI_PREM_ALLOC riPremAllocBean = ptPremAllocList.get(0);
					riPremAllocAction.setPT_IL_RI_PREM_ALLOC_BEAN(riPremAllocBean);
				}else{
					// Added for testing
					riPremAllocAction.setPT_IL_RI_PREM_ALLOC_BEAN(new PT_IL_RI_PREM_ALLOC());
				}
			}else{
				// Added for testing
				ptRiDetlAction.setPT_IL_RI_DETL_BEAN(new PT_IL_RI_DETL());
				riPremAllocAction.setPT_IL_RI_PREM_ALLOC_BEAN(new PT_IL_RI_PREM_ALLOC());
			}*/
		/*	//For Default Select RiDetail List
			for(int i =0; i<ptRiDetlList.size();i++){
				PT_IL_RI_DETL pt_il_ri_detl = ptRiDetlList.get(i);
				if(i==0){
					pt_il_ri_detl.setRowSelected(true);
					ptRiDetlAction.setPT_IL_RI_DETL_BEAN1(pt_il_ri_detl);
				}else{
					pt_il_ri_detl.setRowSelected(false);
				}
			}*/
			
			// Premium Allocation
			/*for(int i=0;i<riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC().size();i++){
				PT_IL_RI_PREM_ALLOC pt_il_ri_prem_alloc = riPremAllocAction.getDataList_PT_IL_RI_PREM_ALLOC().get(i);
				if(i==0){
					pt_il_ri_prem_alloc.setRowSelected(true);
					riPremAllocAction.setPT_IL_RI_PREM_ALLOC_BEAN(pt_il_ri_prem_alloc);
				}else{
					pt_il_ri_prem_alloc.setRowSelected(false);
				}
			}
			*/
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

}
