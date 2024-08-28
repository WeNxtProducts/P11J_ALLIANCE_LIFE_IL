package com.iii.pel.forms.PILM037;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILQ003.PILQ003_COMPOSITE_ACTION;
import com.iii.pel.forms.PILQ003.PT_IL_POL_COVER_GROUP_1;
import com.iii.pel.forms.PILQ003.PT_IL_POL_COVER_GROUP_1_DELEGATE;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;



public class PILM037_Helper {
	
	PM_IL_BONUS_SETUP_ACTION setup_action;

	public PILM037_Helper() {
		super();
	}
	
	
	public void pilm037_pm_il_bonus_setup_pre_block(){
        try
        {
        CommonUtils.getControlBean().setM_DELETE_MSG_FLAG("N");
        PM_IL_BONUS_SETUP valueBean = new PM_IL_BONUS_SETUP();    
            if(valueBean.getBSET_PLAN_CODE()== null)
            {
               /* STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91014,:CTRL.M_LANG_CODE,"PLAN CODE","ENTERED","!");
                throw new FORM_TRIGGER_FAILURE();*/
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            
        }
       
    }
	
	
	/**
	 * Pre Insert method
	 * @param valueBean
	 * @throws SQLException
	 * @throws Exception
	 */
	public void pilm037_pm_il_bonus_setup_pre_insert(PM_IL_BONUS_SETUP valueBean, PM_IL_BONUS_SETUP_ACTION valueAction) 
    {
		String uid = null;
        try
        {
        	CommonUtils utils = new CommonUtils();
			HttpSession session = utils.getSession();
			ControlBean ctrlbean = (ControlBean) session
					.getAttribute("ctrlbean");
			uid = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
        	
        	
        	valueBean.setBSET_CR_DT(utils.getCurrentDate());
        	valueBean.setBSET_CR_UID(uid);
            L_DUP_CHECK(valueBean,valueAction);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
	
	/**
	 * Pre Update 
	 * @param valueBean
	 */
	public void pilm037_pm_il_bonus_setup_pre_update(PM_IL_BONUS_SETUP valueBean, PM_IL_BONUS_SETUP_ACTION valueAction) 
    {
		String uid = null;
        try
        {
        	CommonUtils utils = new CommonUtils();
			HttpSession session = utils.getSession();
			ControlBean ctrlbean = (ControlBean) session
					.getAttribute("ctrlbean");
			//uid = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
        	uid = CommonUtils.getGlobalVariable("GLOBAL.M_USER_ID");
        	
        	valueBean.setBSET_UPD_DT(utils.getCurrentDate());
        	valueBean.setBSET_UPD_UID(uid);
            L_DUP_CHECK(valueBean, valueAction);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }    
	
	
	
	
	public void L_DUP_CHECK(PM_IL_BONUS_SETUP valueBean, PM_IL_BONUS_SETUP_ACTION valueAction) throws ValidatorException
    {
		Connection connection = null;
		CRUDHandler handler = null;
		ResultSet rs_C1=null;
		ResultSet rs_C2=null;
		String M_TEMP=null;
		String rowId = null;
		String bsetPcode = null;
		String bsetBcode = null;
		int bsetYear = 0;
		String query  = null;
		Object value[] = null;
		
		try
        {
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			rowId = valueBean.getROWID();
			bsetPcode = valueBean.getBSET_PLAN_CODE();
			bsetBcode = valueBean.getBSET_BONUS_CODE();
			bsetYear = valueBean.getBSET_YEAR();
			
//            String sql_C1="SELECT 'X' FROM  PM_IL_BONUS_SETUP  WHERE  BSET_PLAN_CODE" +
//           	"  = :PM_IL_PLAN.PLAN_CODE AND BSET_BONUS_CODE  = :PM_IL_BONUS_SETUP.BSET_BONUS_CODE" +
//           	" AND BSET_YEAR  = :PM_IL_BONUS_SETUP.BSET_YEAR";
            
//            String sql_C2="SELECT 'X' FROM  PM_IL_BONUS_SETUP  WHERE  BSET_PLAN_CODE" +
//            		" = :PM_IL_PLAN.PLAN_CODE  AND BSET_BONUS_CODE  = :PM_IL_BONUS_SETUP.BSET_BONUS_CODE" +
//            		" AND BSET_YEAR  = :PM_IL_BONUS_SETUP.BSET_YEAR  AND ROWID  != :PM_IL_BONUS_SETUP.ROWID ";
  
			
			
            if(rowId == null){
            
            	query = PILM037_SQLQUERY_CONSTANTS.L_DUP_CHK_q1;
               	value = new Object[3];
            	value[0] = bsetPcode;
            	value[1] = bsetBcode;
            	value[2] = bsetYear;
            	
            	rs_C1 = handler.executeSelectStatement(query, connection, value); 
            	
                if(rs_C1.next())
                {
                    M_TEMP=rs_C1.getString(1);
                    valueAction.getErrorMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91011").getDetail());
                    throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91011"));
                    
                    //STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91011,:CTRL.M_LANG_CODE);
                    //throw new FORM_TRIGGER_FAILURE();
                }
                rs_C1.close();
            }
            else
            {
            	query = PILM037_SQLQUERY_CONSTANTS.L_DUP_CHK_q2;
            	value = new Object[4];
            	value[0] = bsetPcode;
            	value[1] = bsetBcode;
            	value[2] = bsetYear;
            	value[3] = rowId;
            	
            	rs_C2 = handler.executeSelectStatement(query, connection, value);

            	if(rs_C2.next())
                {
                    M_TEMP=rs_C2.getString(1);
                    valueAction.getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91011").getDetail());
                    throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91011"));
                    
//                    STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91011,:CTRL.M_LANG_CODE);
//                    throw new FORM_TRIGGER_FAILURE();
                }
                rs_C2.close();
            }
        }catch(Exception e){
        	valueAction.getWarningMap().put("current", Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91011").getDetail());
            throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "91011"));
        }
	
    }
	
	
	
	
	
	
	public void pilm037_pm_il_bonus_setup_bset_bonus_code_when_validate_item(PM_IL_BONUS_SETUP_ACTION actionBean) throws Exception
    {
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		
		String query_c1 = null;
		String query_c2 = null;
		String query_c3 = null;
		String query_c4 = null;
		String bonusCode = null;
		String planCode = null;
		
		ResultSet rs_C1=null;
		ResultSet rs_C2=null;
		ResultSet rs_C3=null;
		ResultSet rs_C4=null;
		
		String M_BONUS_TYPE=null;
		String M_YEAR=null;
		Double M_RATE_PER=null;
		String code_Desc = null;
		String M_BSET_YEAR=null;
		String  M_PLAN_TYPE=null;
		
        try
        {
			connection = CommonUtils.getConnection();
        	bonusCode = actionBean.getPM_IL_BONUS_SETUP_BEAN().getBSET_BONUS_CODE();
            planCode = actionBean.getPM_IL_BONUS_SETUP_BEAN().getBSET_PLAN_CODE();
            query_c1="SELECT MAX(BSET_YEAR) FROM  PM_IL_BONUS_SETUP WHERE  BSET_BONUS_CODE ='"+bonusCode+"' AND BSET_PLAN_CODE = '"+planCode+"'";
            query_c3="SELECT BONUS_TYPE FROM  PM_IL_BONUS  WHERE BONUS_CODE = '"+bonusCode+"'";
            query_c4 = "SELECT PLAN_TYPE FROM  PM_IL_PLAN WHERE PLAN_CODE  = '"+planCode+"'";
            rs_C4 = handler.executeSelectStatement(query_c4, connection);
            
            if(rs_C4.next()){
            	M_PLAN_TYPE = rs_C4.getString(1);
            }
            
            rs_C4.close();
            
            rs_C3 = handler.executeSelectStatement(query_c3, connection);

            if(rs_C3.next())
            {
                M_BONUS_TYPE=rs_C3.getString(1);
            }
            rs_C3.close();
            
            if("U".equalsIgnoreCase(M_BONUS_TYPE))
            {
                if(M_PLAN_TYPE!="U")
                {
                	actionBean.getWarningMap().put("current", "COUPON BONUS CAN BE SET ONLY FOR UNIT LINK PLANS");
                }
            }
            rs_C1=handler.executeSelectStatement(query_c1, connection);
            if(rs_C1.next())
            {
                M_YEAR=rs_C1.getString(1);
                M_BSET_YEAR = M_YEAR;
                if(M_BSET_YEAR != null){
                query_c2="SELECT BSET_RATE_PER FROM  PM_IL_BONUS_SETUP WHERE BSET_YEAR = '"+M_BSET_YEAR+"' AND BSET_BONUS_CODE  = '"+bonusCode+"' AND BSET_PLAN_CODE ='"+planCode+"'";
                
                rs_C2=handler.executeSelectStatement(query_c2, connection);
                if(rs_C2.next())
                {
                    M_RATE_PER=rs_C2.getDouble(1);
                }
                rs_C2.close();
                }
            }
            rs_C1.close();
            
            PM_IL_BONUS_SETUP valueBean = actionBean.getPM_IL_BONUS_SETUP_BEAN();
            if(M_RATE_PER != null){
            	valueBean.setBSET_RATE_PER(M_RATE_PER);
            }
            code_Desc = L_VAL_BONUS(bonusCode,"E");
            if(code_Desc != null){
            actionBean.getPM_IL_BONUS_SETUP_BEAN().setUI_M_BSET_BONUS_CODE_DESC(code_Desc);
            }
            actionBean.getPM_IL_BONUS_SETUP_BEAN().setBSET_BONUS_GIVEN_IN("A");
            actionBean.getPM_IL_BONUS_SETUP_BEAN().setBSET_APPLIED_ON("S");
            actionBean.getPM_IL_BONUS_SETUP_BEAN().setBSET_UNIT_PUR_YN("N");
        }catch(Exception e)
        {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }
	
	public static String L_VAL_BONUS(String M_BONUS_CODE,String P_ERR_FLAG) 
	throws Exception{
		System.out.println("INSIDE L_VAL_DESC........");
        String M_BONUS_DESC=null;
        String M_TEMP=null;
        ResultSet rs_P1=null;
        String query_P1 = null;
        
        CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
       
			try {
				connection = CommonUtils.getConnection();
			} catch (DBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
			query_P1="SELECT BONUS_DESC FROM PM_IL_BONUS WHERE BONUS_CODE = '"+M_BONUS_CODE+"'";
			
        	rs_P1=handler.executeSelectStatement(query_P1, connection);
            if(rs_P1.next())
            {
                M_TEMP = rs_P1.getString(1);
            }else if(("W").equalsIgnoreCase(P_ERR_FLAG) || ("E").equalsIgnoreCase(P_ERR_FLAG))
                {
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1802"));
            }
            M_BONUS_DESC = M_TEMP;
            rs_P1.close();
        
        return M_BONUS_DESC;
    }
	
	/*
	 * BSET_YEAR-WHEN-VALIDATE-ITEM
	 */
	 public void pilm037_pm_il_bonus_setup_bset_year_when_validate_item(PM_IL_BONUS_SETUP_ACTION action) throws  ValidatorException
	    {
	            if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_YEAR() != null)
	            {
	                if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_YEAR() <= 0 )
	                {
	                	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,
	        					"91014",new Object[]{"YEAR",">","0"}));
	                }
	            }
	            if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_YEAR() < 1999 || 
	            		action.getPM_IL_BONUS_SETUP_BEAN().getBSET_YEAR() > 2999)
	            {
	            	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,
	    					"91014",new Object[]{"YEAR",">=1999","AND <=2999"})); 
	            }
	    }
	
	
	
	/*
	 * BSET_RATE-WHEN-VALIDATE-ITEM
	 */
	public void pilm037_pm_il_bonus_setup_bset_rate_when_validate_item(PM_IL_BONUS_SETUP_ACTION action) throws Exception{
            if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_RATE() != null){
            	if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_RATE() == null){
            		throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "333000"));
            	}
            	else if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_RATE() <= 0){
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "91014",new Object[]{"RATE",">","0"}));
                }
            }
    }

	/*
	 * BSET_RATE_PER-WHEN-VALIDATE-ITEM
	 */
	public void pilm037_pm_il_bonus_setup_bset_rate_per_when_validate_item(PM_IL_BONUS_SETUP_ACTION action) throws  ValidatorException
    {
            if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_RATE_PER() != null)
            {
            	if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_RATE_PER() == null){
            		throw new ValidatorException(Messages.getMessage(
							"com.iii.premia.common.errorUtil.PELErrorMessages", "333000"));
            	}else if(action.getPM_IL_BONUS_SETUP_BEAN().getBSET_RATE_PER() <= 0)
                {
                	throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath,
							"91014",new Object[]{"RATE PER",">","0"}));
                }
            }
    }
	
	public void setAction(PM_IL_BONUS_SETUP_ACTION pm_il_bonus_setup_action_bean) 
	{
		setup_action = pm_il_bonus_setup_action_bean;
	}
	 
	    public void executeQuery(PILM037_COMPOSITE_ACTION compositeAction)
	    throws Exception {
        	new DelegateDb()
        		.executeSelectStatement(compositeAction);
        
        	List<PM_IL_BONUS_SETUP> dataList = compositeAction
        		.getPM_IL_BONUS_SETUP_ACTION_BEAN()
        		.getTableList();
        	if (dataList != null && dataList.size() > 0) {
        	    PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN = dataList
        		    .get(0);
        	    PM_IL_BONUS_SETUP_BEAN.setRowSelected(true);
        	    compositeAction.getPM_IL_BONUS_SETUP_ACTION_BEAN()
        		    .setPM_IL_BONUS_SETUP_BEAN(
        			    PM_IL_BONUS_SETUP_BEAN);
	}
    }
	    
	 //[Added method missing from FMB by Sridhar..
	    
	   public void L_VAL_PLAN(PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN) throws Exception{
		  Connection connection = null;
		  ResultSet resultSet = null;
		  
		  String query ="SELECT  COVER_DESC FROM   PM_IL_COVER WHERE  " +
		  				"  COVER_CODE = ? ";
		  try {
			connection =  CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(query, connection, new Object[]{PM_IL_BONUS_SETUP_BEAN.getBSET_PLAN_CODE()});
			if(resultSet.next()){
				PM_IL_BONUS_SETUP_BEAN.setUI_M_PLAN_CODE_DESC(resultSet.getString(1));
			}else{
				throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71008"));
			}
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally{
			CommonUtils.closeCursor(resultSet);
		}
	   }
	    
	   
	   
	   public void postQuery(PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN) throws Exception{
		
		   try{
				   L_VAL_PLAN(PM_IL_BONUS_SETUP_BEAN);
			  
				  String bonusDesc = L_VAL_BONUS(PM_IL_BONUS_SETUP_BEAN.getBSET_BONUS_CODE(), "N");
				  if(bonusDesc != null){
					  PM_IL_BONUS_SETUP_BEAN.setUI_M_BSET_BONUS_CODE_DESC(bonusDesc);
				  }
		   }catch (Exception e) {
			   e.printStackTrace();
			   throw new Exception(e.getMessage());
		}
	 }
	   
	   
	   public void pilm037_pm_il_bonus_setup_bset_plan_code_when_validate_item(PM_IL_BONUS_SETUP PM_IL_BONUS_SETUP_BEAN) throws Exception
	    {
			try{
	            L_VAL_PLAN(PM_IL_BONUS_SETUP_BEAN);
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw new Exception(e.getMessage());
	        }
	    }
 }
