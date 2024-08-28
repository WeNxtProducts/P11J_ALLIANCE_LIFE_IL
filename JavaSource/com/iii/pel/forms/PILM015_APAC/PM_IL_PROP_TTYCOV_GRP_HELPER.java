package com.iii.pel.forms.PILM015_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.MigratingFunctions;
import com.vembu.plsql.runtime.functions.StringFunctions;

public class PM_IL_PROP_TTYCOV_GRP_HELPER {
	
	/**
	 * WHEN-VALIDATE FOR PTG_COVER_CODE
	 * @param compositeAction
	 * @throws Exception 
	 * @throws SQLException
	 * @throws DBException
	 */
	public void pilm015_apac_pm_il_prop_ttycov_grp_ptg_cover_code_when_validate_item
				(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		PM_IL_PROP_TTYCOV_GRP_ACTION ttyCovGrpAction=compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION();
		String ptgCoverCode=ttyCovGrpAction.getCOMP_PTG_COVER_CODE().getSubmittedValue().toString();
        CRUDHandler handler=new CRUDHandler();
		ResultSet resultset=null;
		String M_COVER_TYPE=null;
		String M_DUMMY=null;
        try{
        	Connection connection=CommonUtils.getConnection();
            String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
            	PILM015_APAC_PM_IL_PROP_TTYCOV_GRP_SELECT_X_FOR_PTG_COVER_CODE;
            Object[] objects={ptgCoverCode};
            if(ptgCoverCode!= null){
            	resultset=handler.executeSelectStatement(sql_C1, connection, objects);
                if(resultset.next()){
                    M_DUMMY=resultset.getString(1);
                }
                resultset.close();
                if(CommonUtils.nvl(M_DUMMY,"Y")!="X"){
                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "1010")); 
                }
                String ptgCoverCodeDesc = P_VAL_COVER_1(ptgCoverCode,"N","E");
                ttyCovGrpAction.getCOMP_UI_M_PTG_COVER_CODE_DESC().setSubmittedValue(ptgCoverCodeDesc);
            }
        } catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}finally
        {
           try {
			CommonUtils.closeCursor(resultset);
		} catch (Exception e) {
			e.printStackTrace();
		}
        }
    }
	
	/**
	 * P_VAL_COVER_1 GIVES DESCRIPTION FOR PTG_COVER_CODE
	 * @param P_COVER_CODE
	 * @param P_NAME_FLAG
	 * @param P_ERR_FLAG
	 * @return
	 * @throws Exception 
	 * @throws ValidatorException
	 * @throws DBException
	 * @throws SQLException
	 */
	 public String P_VAL_COVER_1(String P_COVER_CODE,String P_NAME_FLAG,String P_ERR_FLAG) throws Exception{
		 	ResultSet resultSet=null;
		 	CRUDHandler handler=new CRUDHandler();
		 	CommonUtils commonUtils=new CommonUtils();
		 	String P_COVER_DESC=null;
	        try{
	        	Connection connection=CommonUtils.getConnection();
	            String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            			PILM015_APAC_PM_IL_PROP_TTYCOV_GRP_SELECT_DEATILS_FOR_COVER_CODE;
	            String   M_NAME=null;
	            String   M_BL_NAME=null;
	            String   M_FRZ_FLAG=null;
	            Object[] objects={P_NAME_FLAG,P_NAME_FLAG,P_COVER_CODE};
	            resultSet=handler.executeSelectStatement(sql_C1, connection, objects);
	            if(resultSet.next()){
	                M_NAME=resultSet.getString(1);
	                M_BL_NAME=resultSet.getString(2);
	                M_FRZ_FLAG=resultSet.getString(3);
	            }
	            if(resultSet.next()){
	                if(P_ERR_FLAG.equals("W") || P_ERR_FLAG.equals ("E")){
	                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71006"));
	                }
	            }
	            if(M_FRZ_FLAG.equals("Y")){
	                if(P_ERR_FLAG.equals ("W") || P_ERR_FLAG.equals ("E")){
	                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "71007"));
	                }
	            }
	            if(StringFunctions.substr(commonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE"),5,1)=="1" ||
	            		commonUtils.getGlobalVariable("GLOBAL.M_FOR_LANG_CODE").equals("ENG"))
	            {
	                P_COVER_DESC=M_NAME;
	            }
	            else
	            {
	                P_COVER_DESC=M_BL_NAME;
	            }
	        } catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	        finally
	        {
	            try {
					commonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        return P_COVER_DESC;
	    }
	 
	 /**
	  * When-New -Record Instance Trigger to Be handled later on conbfiramtion with Vishnu
	  */
	 /*public static void pilm015_apac-pm_il_prop_ttycov_grp--when-new-record-instance() throws SQLException,Exception
	    {
	        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
	        try
	        {
	            final dbms_output dbms_output1=new dbms_output();
	            if(:SYSTEM.FORM_STATUS=="CHANGED" && :SYSTEM.RECORD_STATUS=="NEW")
	            {
	                COPY.COPY("P","CTRL.M_COMM_DEL");
	                COPY.COPY("20","SYSTEM.MESSAGE_LEVEL");
	                POST.POST();
	                COPY.COPY("","CTRL.M_COMM_DEL");
	                COPY.COPY("0","SYSTEM.MESSAGE_LEVEL");
	            }
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	        finally
	        {
	            if(vembu_conn != null)
	            {
	                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
	            }
	        }
	    }*/
	 
	 /**
	  * 	WHEN-CREATE-RECORD
	  */
	 public void pilm015_apac_pm_il_prop_ttycov_grp_when_create_record
	 			(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) 
	    {
	       
	       		// calls when Validate of ptg_ptc_cvr_crp_code
		 		// not found
	            //TODO
	           // :PM_IL_PROP_TTYCOV_GRP.PTG_PTC_CVR_GRP_CODE=:PM_IL_PROP_TREATY_COVER.PTC_CVR_GRP_CODE;
	        
	       
	    }
	 
	 /**
	  * PRE-UPDATE
	  * @param compositeAction
	 * @throws Exception 
	 * @throws Exception 
	 * @throws ValidatorException 
	  */
	 public  void pilm015_apac_pm_il_prop_ttycov_grp_pre_update(
			 PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		 	PM_IL_PROP_TTYCOV_GRP_ACTION ttyCovGrpActionBean=compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION();
	        PM_IL_PROP_TTYCOV_GRP ttyCovGrpValueBean=ttyCovGrpActionBean.getPM_IL_PROP_TTYCOV_GRP_BEAN();
	        CommonUtils commonUtils=new CommonUtils();
	        ResultSet resultSet=null;
	        CRUDHandler handler=new CRUDHandler();
	        try{
	        	Connection connection=CommonUtils.getConnection();
	            L_DUP_GROUP_COVER(compositeAction);
	            ttyCovGrpValueBean.setPTG_UPD_UID(commonUtils.getControlBean().getM_USER_ID());
	            ttyCovGrpValueBean.setPTG_UPD_DT(commonUtils.getCurrentDate());
	            String sql_vembu1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            		PILM015_APAC_PM_IL_PROP_TTYCOV_GRP_UPDATE_PM_IL_PROP_TTYCOV_GRP;
	            Object[] objects1={};//plz pass the objects
	            resultSet=handler.executeSelectStatement(sql_vembu1, connection, objects1);
	            if(resultSet.next()){
	            	CommonUtils.setGlobalVariable("ROWCOUNT",resultSet.getString(1));
	            }
	        } catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (ParseException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	        finally
	        {
	            commonUtils.closeCursor(resultSet);
	        }
	    }
	 /**
	  * L_DUP_GROUP_COVER Local Procedure 
	  * @param compositeAction
	 * @throws Exception 
	  * @throws ValidatorException
	  * @throws SQLException
	  * @throws Exception
	  */
	 public void L_DUP_GROUP_COVER(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception{
		 	PM_IL_PROP_TTYCOV_GRP_ACTION ttyCovGrpActionBean=compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION();
	        PM_IL_PROP_TTYCOV_GRP ttyCovGrpValueBean=ttyCovGrpActionBean.getPM_IL_PROP_TTYCOV_GRP_BEAN();
	        PM_IL_PROP_TREATY_COVER treatyCoverValueBean=compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().
	        												getPM_IL_PROP_TREATY_COVER_BEAN();  
	        PM_IL_PROP_TREATY_TYPE treatyTypeValueBean=compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION()
	        												.getPM_IL_PROP_TREATY_TYPE_BEAN();
	        PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION()
	        												.getPM_IL_PROP_TREATY_BEAN();
		 	String M_TEMP=null;
		 	ResultSet vembu_C1=null;
		 	ResultSet vembu_C2=null;
		 	CRUDHandler handler=new CRUDHandler();
	        try
	        {
	        	Connection connection=CommonUtils.getConnection(); 
	            String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            	PILM015_APAC_PM_IL_PROP_TTYCOV_GRP_SELECT_X_FOR_PTT_AND_PTG_SYS_ID;
	            Double ptcSysId=treatyCoverValueBean.getPTC_SYS_ID();
	            Double pttsysId=treatyTypeValueBean.getPTT_SYS_ID();
	            Double ptsysId=treatyValueBean.getPT_SYS_ID();
	            String ptgCoverCode=ttyCovGrpValueBean.getPTG_COVER_CODE();
	            Object[] objects={ptcSysId,pttsysId,ptsysId,ptgCoverCode};
	            vembu_C1=handler.executeSelectStatement(sql_C1, connection, objects);
	            String sql_C2=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            			PILM015_APAC_PM_IL_PROP_TTYCOV_GRP_SELECT_X_FOR_PTT_AND_PTG_SYS_ID_AND_ROWID;
	            String rowId=ttyCovGrpValueBean.getROWID();
	            Object[] objects1={ptcSysId,pttsysId,ptsysId,ptgCoverCode,rowId};
	            if(rowId==null){
	                vembu_C1=handler.executeSelectStatement(sql_C1, connection, objects);
	                if(vembu_C1.next()){
	                    M_TEMP=vembu_C1.getString(1);
	                }
	                if(vembu_C1.next()){
	                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "19028"));
	                }
	                vembu_C1.close();
	            }else{
	            	vembu_C2=handler.executeSelectStatement(sql_C2, connection, objects1);
	                if(vembu_C2.next()){
	                    M_TEMP=vembu_C2.getString(1);
	                }
	                if(!vembu_C2.isLast()){
	                	throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath, "19028"));
	                }
	               
	            }
	        } catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	        finally
	        {
	            try{
	            	CommonUtils.closeCursor(vembu_C1);
	            	}catch(Exception e){}
	            try{
	            	CommonUtils.closeCursor(vembu_C2);
	            	}catch (Exception e) {
				}
	        }
	    }
	 
	 /**
	  *TODO whts this post Query doing juz getting the desc but not setting???? 
	  * @param compositeAction
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws DBException 
	  */
	 public void pilm015_apac_pm_il_prop_ttycov_grp_post_query(
			 PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception {
		 	ResultSet vembu_C2=null;
		 	CRUDHandler handler=new CRUDHandler();
		 	PM_IL_PROP_TTYCOV_GRP_ACTION ttyCovGrpActionBean=compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION();
	        PM_IL_PROP_TTYCOV_GRP ttyCovGrpValueBean=ttyCovGrpActionBean.getPM_IL_PROP_TTYCOV_GRP_BEAN();
	        String coverCode=ttyCovGrpValueBean.getPTG_COVER_CODE();
	        try{
	        	Connection connection = CommonUtils.getConnection();
	            String sql_C2=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            	PILM015_APAC_PM_IL_PROP_TTYCOV_GRP_SELECT_COVER_DESC_FOR_COVER_CODE;
	            Object[] objects={coverCode};
	            vembu_C2=handler.executeSelectStatement(sql_C2, connection, objects);
	            if(vembu_C2.next()){
	            }
	           
	        } catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	        finally
	        {
	            try {
					CommonUtils.closeCursor(vembu_C2);
				} catch (Exception e) {
					e.printStackTrace();
				}
	        }
	    }
	 
	 /**
	  * PRE-INSERT
	 * @throws Exception 
	  * @throws SQLException
	  * @throws Exception
	  */
	 public void pilm015_apac_pm_il_prop_ttycov_grp_pre_insert
	 	(PM_IL_PROP_TREATY_COMPOSITE_ACTION compositeAction) throws Exception  {
		 	ResultSet vembu_C1=null;
		 	CRUDHandler handler=new CRUDHandler();
		 	PM_IL_PROP_TTYCOV_GRP_ACTION ttyCovGrpActionBean=compositeAction.getPM_IL_PROP_TTYCOV_GRP_ACTION();
	        PM_IL_PROP_TTYCOV_GRP ttyCovGrpValueBean=ttyCovGrpActionBean.getPM_IL_PROP_TTYCOV_GRP_BEAN();
	        PM_IL_PROP_TREATY_COVER treatyCoverValueBean=compositeAction.getPM_IL_PROP_TREATY_COVER_ACTION().
																	getPM_IL_PROP_TREATY_COVER_BEAN();  
	        PM_IL_PROP_TREATY_TYPE treatyTypeValueBean=compositeAction.getPM_IL_PROP_TREATY_TYPE_ACTION()
	        														.getPM_IL_PROP_TREATY_TYPE_BEAN();
	       	PM_IL_PROP_TREATY treatyValueBean=compositeAction.getPM_IL_PROP_TREATY_ACTION()
	       												.getPM_IL_PROP_TREATY_BEAN();
	        try{
	        	Connection connection=CommonUtils.getConnection();
	        	Double M_PTG_SYS_ID=null;
	            String sql_C1=PM_IL_PROP_TREATY_QUERY_CONSTANTS.
	            	PILM015_APAC_PM_IL_PROP_TTYCOV_GRP_P9IL_PTG_SYS_ID;
	            Object[] objects={};
	            L_DUP_GROUP_COVER(compositeAction);
	            vembu_C1=handler.executeSelectStatement(sql_C1, connection, objects);
	            if(vembu_C1.next())
	            {
	                M_PTG_SYS_ID=vembu_C1.getDouble(1);
	            }
	            ttyCovGrpValueBean.setPTG_SYS_ID(M_PTG_SYS_ID);
	            ttyCovGrpValueBean.setPTG_PTC_SYS_ID(treatyCoverValueBean.getPTC_SYS_ID());
	            ttyCovGrpValueBean.setPTG_PTT_SYS_ID(treatyTypeValueBean.getPTT_PT_SYS_ID());
	            ttyCovGrpValueBean.setPTG_PTC_CVR_GRP_CODE(treatyCoverValueBean.getPTC_CVR_GRP_CODE());
	            ttyCovGrpValueBean.setPTG_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
	        } catch (DBException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (SQLException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
	        finally{
	        	CommonUtils.closeCursor(vembu_C1);
	        }
	    }
	 
	 public Double getSysIdForGroupCover() throws Exception  {
			CRUDHandler handler = new CRUDHandler();
			Double sysId = null;
			ResultSet resultSet = null;
			try {
				Connection connection = CommonUtils.getConnection();
				String query = "SELECT P9IL_PTG_SYS_ID.NEXTVAL FROM  DUAL  ";
				Object[] objects = {};
				resultSet = handler.executeSelectStatement(query, connection,
						objects);
				if (resultSet.next()) {
					sysId = resultSet.getDouble(1);
				}
				if (resultSet.isAfterLast() || resultSet.isBeforeFirst()) {
				}

			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}finally{
				try {
					CommonUtils.closeCursor(resultSet);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return sysId;
		}
}
