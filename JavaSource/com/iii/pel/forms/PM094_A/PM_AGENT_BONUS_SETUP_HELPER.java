package com.iii.pel.forms.PM094_A;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.functions.ConvertFunctions;


public class PM_AGENT_BONUS_SETUP_HELPER {

	public void when_validate_abs_code(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action) throws Exception {
		
		
		String mTemp=null;
		CRUDHandler handler=new CRUDHandler();
		Connection connection=CommonUtils.getConnection();
		ResultSet resultSet=null;
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		try {
			String abscode=pm_agent_bonus_setup.getABS_CODE();
			if(abscode!=null){
				
				resultSet=handler.executeSelectStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM094_A$PM_AGENT_BONUS$VALIDATE$ABS_CODE,
															connection, new Object[]{abscode});
				if(resultSet.next()){
					mTemp=resultSet.getString(1);
					String bonusCodeString=Messages.getString("messageProperties_PM094_A", "PM094_A$PM_AGENT_BONUS_SETUP$ABS_CODE$VALIDATIION_STRING");
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "90015",
													new Object[]{bonusCodeString}));
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		
		
	}

	public void when_validate_abs_desc(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action) throws Exception{
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		String absDesc=pm_agent_bonus_setup.getABS_DESC();
		
		try {
			String absShortDesc=pm_agent_bonus_setup.getABS_SHORT_DESC();
			System.out.println("absDesc :"+absDesc+" :: absShortDesc :"+absShortDesc);
			if(absDesc.trim()!=null){
				int trimmedSize=absDesc.trim().length();
				if(trimmedSize<30){
					pm_agent_bonus_setup.setABS_SHORT_DESC(absDesc.trim().substring(0, trimmedSize));
				}else{
					pm_agent_bonus_setup.setABS_SHORT_DESC(absDesc.trim().substring(0, 30));
				}
				System.out.println("Short DEsc :"+pm_agent_bonus_setup.getABS_SHORT_DESC());
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void when_validate_abs_bonus_type(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action) throws Exception {
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		DBProcedures procedures=new DBProcedures();
		
		String absBonusType=pm_agent_bonus_setup.getABS_BONUS_TYPE();
		String m_ps_value=null;
		ArrayList<String> bonusTypeDescList=new ArrayList<String>();
		try{
		if(absBonusType!=null){
		
			if(!"*".equalsIgnoreCase(absBonusType))
			{
				bonusTypeDescList=procedures.callP_VAL_SYSTEM("AGT_BONUS", absBonusType, "N");
				if(!bonusTypeDescList.isEmpty()){
					if(bonusTypeDescList.get(0) != null){
					pm_agent_bonus_setup.setUI_M_ABS_BONUS_TYPE_DESC(bonusTypeDescList.get(0));
					}
					if(bonusTypeDescList.get(1) != null){
					m_ps_value=bonusTypeDescList.get(1);
					}
					System.out.println("m_PS_VALUE :"+m_ps_value);
					if("2".equals(m_ps_value)){
						pm_agent_bonus_setup_action.getCOMP_ABS_POL_RENEWAL_YR().setDisabled(false);
					}else{
						if(pm_agent_bonus_setup.getABS_POL_RENEWAL_YR()!=null){
							pm_agent_bonus_setup_action.getCOMP_ABS_POL_RENEWAL_YR().setSubmittedValue("");
							pm_agent_bonus_setup.setABS_POL_RENEWAL_YR(null);
						}
						pm_agent_bonus_setup_action.getCOMP_ABS_POL_RENEWAL_YR().setDisabled(true);
					}
				}
			}
		}
		}catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

	public void when_validate_abs_yrs_fm(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action)throws Exception {
	
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		Integer absYrsFm=pm_agent_bonus_setup.getABS_YRS_FM();
		
		Integer absYrsTo=pm_agent_bonus_setup.getABS_YRS_TO();
		
		try {
			if(absYrsFm == null || MigratingFunctions.nvl(absYrsFm, 0)<0){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91018"));
			}else if(absYrsTo!=null){
				if(MigratingFunctions.nvl(absYrsFm,0)>MigratingFunctions.nvl(absYrsTo, 0)){
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91054"));
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

	public void when_validate_abs_yrs_to(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action) throws Exception {
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		try {
			Integer absYrsFm=pm_agent_bonus_setup.getABS_YRS_FM();
			
			Integer absYrsTo=pm_agent_bonus_setup.getABS_YRS_TO();
			
			if(absYrsTo==null || CommonUtils.nvl(absYrsTo, 0)<0){
				throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91018"));
			}else if(absYrsFm!=null){
				if(MigratingFunctions.nvl(absYrsFm,0)>MigratingFunctions.nvl(absYrsTo, 0)){
					
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "80015"));
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public void when_validate_abs_pol_renewal_yr(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action) throws Exception{
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		Double absPolRenewalYr=pm_agent_bonus_setup.getABS_POL_RENEWAL_YR();
		DBProcedures procedures=new DBProcedures();
		
		String absBonusType=pm_agent_bonus_setup.getABS_BONUS_TYPE();
		String m_ps_value=null;
		String m_ps_desc=null;
		
		try {
			ArrayList<String> bonusTypeList=null;
			if(absBonusType!=null){
				
				bonusTypeList=procedures.P_VAL_SYSTEM("AGT_BONUS", absBonusType, "E");
				if(bonusTypeList!=null && bonusTypeList.size()>0){
					m_ps_desc=bonusTypeList.get(0);
					m_ps_value=bonusTypeList.get(1);
					if("2".equals(m_ps_value)){
						if(MigratingFunctions.nvl(absPolRenewalYr, 0)<1){
							
							throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91026"));
						}
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}	
	}

	public void when_validate_abs_eff_frm_dt(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action)throws Exception {
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		try {
			Date absEffFrmDt=pm_agent_bonus_setup.getABS_EFF_FM_DT();
			Date absEffToDt=pm_agent_bonus_setup.getABS_EFF_TO_DT();
			System.out.println("absEffFrmDt:"+absEffFrmDt+" ::: absEffToDt :"+absEffToDt);
			Date date=new Date(Calendar.getInstance().getTimeInMillis());
			if(absEffToDt!=null){
				if(MigratingFunctions.nvl(absEffFrmDt, ConvertFunctions.to_date("01/01/1900", "DD/MM/RRRR")).after(
					MigratingFunctions.nvl(absEffToDt, ConvertFunctions.to_date("31/12/2999", "DD/MM/RRRR")))){
				
					throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91010"));
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
		
	}
	
	public static void main(String[] args) {
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Date :"+format.parse(format.format(date)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void when_validate_abs_eff_to_dt(
			PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action) throws Exception{
	
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		try {
			Date absEffFrmDt=pm_agent_bonus_setup.getABS_EFF_FM_DT();
			Date absEffToDt=pm_agent_bonus_setup.getABS_EFF_TO_DT();
			System.out.println("absEffFrmDt:"+absEffFrmDt+" ::: absEffToDt :"+absEffToDt);
			 if(MigratingFunctions.nvl(absEffFrmDt, ConvertFunctions.to_date("01/01/1900", "DD/MM/RRRR")).after(
						MigratingFunctions.nvl(absEffToDt, ConvertFunctions.to_date("31/12/2999", "DD/MM/RRRR")))){
				 
				 throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91001"));
			 }
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void post_query(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup) throws Exception{
		
		DBProcedures procedures=new DBProcedures();
		
		String absBonusType=pm_agent_bonus_setup.getABS_BONUS_TYPE();
		String m_ps_value=null;
		ArrayList<String> bonusTypeDescList=null;
		try {
			if(absBonusType!=null){
				
				bonusTypeDescList=procedures.P_VAL_SYSTEM("AGT_BONUS", absBonusType, "E");
				if(bonusTypeDescList!=null && bonusTypeDescList.size()>0){
					
					pm_agent_bonus_setup.setUI_M_ABS_BONUS_TYPE_DESC(bonusTypeDescList.get(0));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void pre_insert(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup)throws Exception{
		
		try {
			pm_agent_bonus_setup.setABS_CR_DT(new CommonUtils().getCurrentDate());
			pm_agent_bonus_setup.setABS_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	
	public void pre_update(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup)throws Exception{
		
		try {
			pm_agent_bonus_setup.setABS_UPD_DT(new CommonUtils().getCurrentDate());
			pm_agent_bonus_setup.setABS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void when_new_record_instance(PM_AGENT_BONUS_SETUP_ACTION pm_agent_bonus_setup_action) throws Exception{
		
		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=pm_agent_bonus_setup_action.getPM_AGENT_BONUS_SETUP_BEAN();
		
		DBProcedures procedures=new DBProcedures();
		
		String absBonusType=pm_agent_bonus_setup.getABS_BONUS_TYPE();
		String m_ps_value=null;
		ArrayList<String> bonusTypeDescList=null;
		try {
			if(absBonusType!=null){
			
				bonusTypeDescList=procedures.P_VAL_SYSTEM("AGT_BONUS", absBonusType, "N");
				if(!bonusTypeDescList.isEmpty()
						&& bonusTypeDescList.size()>0){
					//pm_agent_bonus_setup.setUI_M_ABS_BONUS_TYPE_DESC(bonusTypeDescList.get(0));
					if(bonusTypeDescList.get(1) != null){
						m_ps_value=bonusTypeDescList.get(1);
					}
					pm_agent_bonus_setup_action.setCOMP_ABS_POL_RENEWAL_YR(new HtmlInputText());
					if("2".equals(m_ps_value)){
						pm_agent_bonus_setup_action.getCOMP_ABS_POL_RENEWAL_YR().setDisabled(false);
					}else{
						
						pm_agent_bonus_setup.setABS_POL_RENEWAL_YR(null);
						pm_agent_bonus_setup_action.getCOMP_ABS_POL_RENEWAL_YR().setSubmittedValue("");
						pm_agent_bonus_setup_action.getCOMP_ABS_POL_RENEWAL_YR().setDisabled(true);
					}
				}
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	public void when_create_record(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup){
		
		pm_agent_bonus_setup.setABS_BONUS_FREQ("Q");
		pm_agent_bonus_setup.setABS_PRORATA_YN("N");
		pm_agent_bonus_setup.setABS_TAXABLE_YN("N");
	}
	
	public void pre_delete(PM_AGENT_BONUS_SETUP pm_agent_bonus_setup) throws DBException, SQLException{
		
		CRUDHandler handler=new CRUDHandler();
		Connection connection=CommonUtils.getConnection();
		String absCode=pm_agent_bonus_setup.getABS_CODE();
		
		handler.executeDeleteStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM094_A$PM_AGENT_BONUS_SETUP$PRE_DELETE$BONUS_APPL_PROD_DELETE_BEAN, connection, new Object[]{absCode});
		
		handler.executeDeleteStatement(PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.PM094_A$PM_AGENT_BONUS_SETUP$PRE_DELETE$BONUS_APPL_RANKS_DELETE_BEAN, connection,  new Object[]{absCode});
		
		
		
		
	}

	public List prepareBonusTypeList(String bonusType, List bonusTypeList)throws Exception {
		
		String query = null;
		PM_AGENT_BONUS_SETUP_DELEGATE delegate=new PM_AGENT_BONUS_SETUP_DELEGATE();
		try {
			if ("*".equalsIgnoreCase(bonusType)) {
					query = PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.LOV$PM094_A$PM_AGENT_BONUS_SETUP$ABS_BONUS_TYPE;
					Object[] object={PELConstants.suggetionRecordSize};
					bonusTypeList = delegate.bonusTyepLOV(query,object);

			} else {
					bonusType=bonusType+PM094_A_PM_AGENT_BONUS_CONSTANTS.PERCENTILE_FOR_SELECT_LIKE;
					Object[] object={bonusType,PELConstants.suggetionRecordSize};
					System.out.println("bonusType :"+bonusType);
					query = PM094_A_PM_AGENT_BONUS_QUERY_CONSTANTS.LOV$PM094_A$PM_AGENT_BONUS_SETUP$ABS_BONUS_TYPE$LIKE;
					bonusTypeList = delegate.bonusTyepLOV(query,object);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return bonusTypeList;
	}

	public String getDescforBonusType(String bonustype, List bonusTypeList) {
		Iterator iterator = bonusTypeList.iterator();
		String absBounsTypeDesc = null;
	 	while(iterator.hasNext())
	 	{
	 		PM_AGENT_BONUS_SETUP pm_agent_bonus_setup=(PM_AGENT_BONUS_SETUP)iterator.next();
			
	 		if(bonustype.equalsIgnoreCase(pm_agent_bonus_setup.getABS_CODE()))
	 		{
	 			absBounsTypeDesc = pm_agent_bonus_setup.getUI_M_ABS_BONUS_TYPE_DESC();
	 			System.out.println("absBounsTypeDesc :"+absBounsTypeDesc);
			}
		}
		return absBounsTypeDesc;
	}
	

}
