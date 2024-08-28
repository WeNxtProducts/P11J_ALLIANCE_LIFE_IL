package com.iii.pel.forms.PILT010;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.validator.ValidatorException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_RI_DISC_LOAD_HELPER {
	
	/**
	 * @author 53058
	 *
	 * This method is not called as currently there is no insert/update
	 * 
	 * @param riDiscLoadBean - instance of type PT_IL_RI_DISC_LOAD
	 * @throws ValidatorException
	 */
	public void whenCreateRecord(PT_IL_RI_DISC_LOAD riDiscLoadBean) throws ValidatorException {
		riDiscLoadBean.setRDL_DISC_LOAD_TYPE("D");
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:40:23 PM
	 *
	 * Not called as there is no insert/update 
	 * 
	 * @param riDiscLoadBean
	 * @throws ValidatorException
	 */
	public void whenNewRecordInstance(PT_IL_RI_DISC_LOAD riDiscLoadBean) throws ValidatorException {
		ResultSet vembu_C1=null;
		ResultSet vembu_C2=null;
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		String RDL_COVER_CODE = riDiscLoadBean.getRDL_COVER_CODE();
		String RDL_DISC_LOAD_CODE = riDiscLoadBean.getRDL_DISC_LOAD_CODE();
		try {
            String sql_C1="SELECT COVER_DESC FROM  PM_IL_COVER  " +
            		"WHERE  COVER_CODE  = ? ";
            String sql_C2="SELECT PC_DESC FROM  PM_CODES  " +
            		"WHERE  PC_TYPE  = DECODE(?, 'D', 'IL_DISC', 'IL_LOAD')  " +
            		"AND PC_CODE  = ? ";
            vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RDL_COVER_CODE});
            String M_COVER_CODE_DESC = null;
            if(vembu_C1.next()){
            	M_COVER_CODE_DESC = vembu_C1.getString(1);
            }
            riDiscLoadBean.setUI_M_COVER_CODE_DESC(M_COVER_CODE_DESC);
            if(RDL_DISC_LOAD_CODE != null){
                vembu_C2=handler.executeSelectStatement(sql_C2, connection, new Object[]{RDL_DISC_LOAD_CODE, RDL_DISC_LOAD_CODE});
                String M_DISC_LOAD_CODE_DESC = null;
                if(vembu_C2.next()){
                	M_DISC_LOAD_CODE_DESC = vembu_C2.getString(1);
                }
                riDiscLoadBean.setUI_M_DISC_LOAD_CODE_DESC(M_DISC_LOAD_CODE_DESC);
            }
        }catch(Exception e) {
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
        	try {
				CommonUtils.closeCursor(vembu_C1);
				CommonUtils.closeCursor(vembu_C2);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
        }
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:40:55 PM
	 *
	 * Not called as there is no insert/update
	 * 
	 * @param riDiscLoadBean
	 * @throws ValidatorException
	 */
	public void preInsert(PT_IL_RI_DISC_LOAD riDiscLoadBean) throws ValidatorException {
		try {
            /*String sql_vembu1="SELECT P9IL_RDL_SYS_ID.NEXTVAL FROM  DUAL  ";
            ResultSet vembu0=stmt_vembu1.executeQuery(sql_vembu1);*/
			ControlBean ctrlBean = CommonUtils.getControlBean();
			riDiscLoadBean.setRDL_CR_UID(ctrlBean.getM_USER_ID());
			riDiscLoadBean.setRDL_CR_DT(Calendar.getInstance().getTime());
            L_CHK_DISC_LOAD_DUPLICATE(riDiscLoadBean);
        } catch(Exception e){
            e.printStackTrace();
            throw new ValidatorException(new FacesMessage(e.getMessage()));
        } finally {
        }
	}
	
	/**
	 * @author 53058
	 * Feb 3, 2009 5:41:25 PM
	 *
	 * validates RDL_DISC_LOAD_CODE while creating a new record i.e., before insertion
	 * 
	 * @param riDiscLoadBean
	 * @throws ValidatorException
	 */
	public void L_CHK_DISC_LOAD_DUPLICATE(PT_IL_RI_DISC_LOAD riDiscLoadBean) throws ValidatorException {
		ResultSet vembu_C1=null;
		String M_DUMMY=null;
		String RDL_DISC_LOAD_CODE = riDiscLoadBean.getRDL_DISC_LOAD_CODE();
		int RDL_RD_SYS_ID = riDiscLoadBean.getRDL_RD_SYS_ID();
		int RDL_RPA_SRNO = riDiscLoadBean.getRDL_RPA_SRNO();
		CRUDHandler handler = new CRUDHandler();
		Connection connection = null;
		try {
			connection = PILT010_ACTION_INSTANCE.getConnection();
            String sql_C1="SELECT 'X' FROM  PT_IL_RI_DISC_LOAD  " +
            		"WHERE  RDL_RD_SYS_ID  = ?  " +
            		"AND RDL_RPA_SRNO  = ? " +
            		"AND RDL_DISC_LOAD_CODE  = ? ";
            if(RDL_DISC_LOAD_CODE != null) {
                vembu_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{RDL_RD_SYS_ID, RDL_RPA_SRNO, RDL_DISC_LOAD_CODE});
                if(vembu_C1.next()) {
                    M_DUMMY=vembu_C1.getString(1);
                }
                if(M_DUMMY!=null){
                    throw new ValidatorException(Messages.getMessage(PELConstants.pelErrorMessagePath, "71041"));
                }
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
	}
	
	/**
	 * @author 53058
	 * Feb 4, 2009 4:09:05 PM
	 *
	 *
	 * @throws ValidatorException
	 */
	public void executeQuery() throws ValidatorException {
		String query = "SELECT ROWID,RDL_SYS_ID,RDL_RD_SYS_ID,RDL_COVER_CODE,RDL_COVER_SYS_ID," +
				"RDL_RPA_SRNO,RDL_SRNO,RDL_DISC_LOAD_TYPE,RDL_DISC_LOAD_CODE,RDL_RATE," +
				"RDL_RATE_PER,RDL_APPL_PERC,RDL_FC_DISC_LOAD_VALUE,RDL_LC_DISC_LOAD_VALUE " +
				"FROM PT_IL_RI_DISC_LOAD " +
				"WHERE RDL_RD_SYS_ID = ? " +
				"AND RDL_COVER_CODE = ? " +
				"AND RDL_COVER_SYS_ID  = ? " +
				"AND RDL_RPA_SRNO = ? ";
		PT_IL_RI_PREM_ALLOC_ACTION premAllocAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_PREM_ALLOC_ACTION_INSTANCE();
		PT_IL_RI_DISC_LOAD_ACTION discLoadAction = PILT010_ACTION_INSTANCE.getPT_IL_RI_DISC_LOAD_ACTION_INSTANCE();
		Integer RPA_RD_SYS_ID = premAllocAction.getPT_IL_RI_PREM_ALLOC_BEAN().getRPA_RD_SYS_ID();
		String RPA_COVER_CODE = premAllocAction.getPT_IL_RI_PREM_ALLOC_BEAN().getRPA_COVER_CODE();
		Integer RPA_COVER_SYS_ID = premAllocAction.getPT_IL_RI_PREM_ALLOC_BEAN().getRPA_COVER_SYS_ID();
		Integer RPA_SRNO = premAllocAction.getPT_IL_RI_PREM_ALLOC_BEAN().getRPA_SRNO();
		
		discLoadAction.getDataList_PT_IL_RI_DISC_LOAD().clear();
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rst = null;
		try {
			rst = handler.executeSelectStatement(query, connection, new Object[]{RPA_RD_SYS_ID, RPA_COVER_CODE, RPA_COVER_SYS_ID, RPA_SRNO});
			while(rst.next()){
				PT_IL_RI_DISC_LOAD discLoadBean = new PT_IL_RI_DISC_LOAD();
				discLoadBean.setRDL_SYS_ID(rst.getInt("RDL_SYS_ID"));                                         
				discLoadBean.setRDL_RD_SYS_ID(rst.getInt("RDL_RD_SYS_ID"));                                   
				discLoadBean.setRDL_COVER_CODE(rst.getString("RDL_COVER_CODE"));                                  
				discLoadBean.setRDL_COVER_SYS_ID(rst.getString("RDL_COVER_SYS_ID"));                              
				discLoadBean.setRDL_RPA_SRNO(rst.getInt("RDL_RPA_SRNO"));                                     
				discLoadBean.setRDL_SRNO(rst.getInt("RDL_SRNO"));                                             
				discLoadBean.setRDL_DISC_LOAD_TYPE(rst.getString("RDL_DISC_LOAD_TYPE"));                          
				discLoadBean.setRDL_DISC_LOAD_CODE(rst.getString("RDL_DISC_LOAD_CODE"));                          
				discLoadBean.setRDL_RATE(rst.getDouble("RDL_RATE"));                                             
				discLoadBean.setRDL_RATE_PER(rst.getInt("RDL_RATE_PER"));                                     
				discLoadBean.setRDL_APPL_PERC(rst.getInt("RDL_APPL_PERC"));                                   
				discLoadBean.setRDL_FC_DISC_LOAD_VALUE(rst.getDouble("RDL_FC_DISC_LOAD_VALUE"));                 
				discLoadBean.setRDL_LC_DISC_LOAD_VALUE(rst.getDouble("RDL_LC_DISC_LOAD_VALUE"));
				//[PREMIAGDC-PREMIUMALLOCATION-0080 CHARAN 27-Feb-2009
				whenNewRecordInstance(discLoadBean);
				//PREMIAGDC-PREMIUMALLOCATION-0080 CHARAN 27-Feb-2009]
				discLoadAction.getDataList_PT_IL_RI_DISC_LOAD().add(discLoadBean);
			}
			
			List<PT_IL_RI_DISC_LOAD> list = discLoadAction.getDataList_PT_IL_RI_DISC_LOAD();
			
			if(list!=null && !list.isEmpty()){
				for(int i=0;i<list.size();i++){
					PT_IL_RI_DISC_LOAD pt_il_ri_prem_alloc = list.get(i);
					if(i==0){
						pt_il_ri_prem_alloc.setRowSelected(true);
						discLoadAction.setPT_IL_RI_DISC_LOAD_BEAN(pt_il_ri_prem_alloc);
					}else{
						pt_il_ri_prem_alloc.setRowSelected(false);
					}
				}
			}
			if(list.isEmpty()){
				discLoadAction.setPT_IL_RI_DISC_LOAD_BEAN(new PT_IL_RI_DISC_LOAD());
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
	 * Feb 3, 2009 5:42:18 PM
	 *
	 * This method is called before committing the changes, i.e., pre-commit
	 * But currently not called as no insert/update.
	 * 
	 * @param RDL_COVER_SYS_ID
	 * @param RD_POL_SYS_ID
	 * @throws ValidatorException
	 */
	public void L_RI_INS_LOAD(int RDL_COVER_SYS_ID, int RD_POL_SYS_ID) throws ValidatorException {
		/*int M_POAD_SYS_ID=0;
		String M_RPA_RI_FC_PREM=null;
		String M_RPA_SRNO=null;
		String M_RPA_FC_EXTRA_PREM=null;
		String M_RPA_RI_GROSS_FC_PREM=null;
		String M_RPA_REINS_COMM_PERC=null;
		String M_RPA_REINS_FC_COMM=null;
		String M_RPA_REINS_PRD_FC_COMM=null;
		Date M_RPA_PRD_FM_DT=null;
		Date M_RPA_PRD_TO_DT=null;
		String M_RPA_RI_LC_PRD_PREM=null;
		int M_NO_DAYS=0;
		int M_LC_LOAD_VALUE=0;
		int M_FC_LOAD_VALUE=0;
		int M_LC_DISC_VALUE=0;
		int M_FC_DISC_VALUE=0;
		int M_TOT_FC_DISC_VALUE=0;
		int M_TOT_FC_LOAD_VALUE=0;
		int M_RDL_SYS_ID=0;
		int M_RPA_RD_SYS_ID=0;
		int M_RDL_SRNO=0;
		String M_POL_CUST_CURR_CODE=null;
		String M_POL_CUST_EXCH_RATE=null;
		String M_RDL_RATE=null;
		String M_RDL_RATE_PER=null;
		String M_RDL_APPL_PERC=null;
		String M_RDL_DISC_LOAD_CODE=null;
		String M_RDL_DISC_LOAD_TYPE=null;
		ResultSet vembu_C2=null;
		ResultSet vembu_C3=null;
		ResultSet vembu_C4=null;
		ResultSet vembu_C5=null;
		Connection connection = PILT010_ACTION_INSTANCE.getConnection();
		CRUDHandler handler = new CRUDHandler();
		try {
            String sql_C2="SELECT    RDL_SYS_ID,    RDL_RATE,    RDL_RATE_PER,    " +
            		"RDL_APPL_PERC,    RDL_DISC_LOAD_CODE,    RDL_DISC_LOAD_TYPE " +
            		"FROM  PT_IL_RI_DISC_LOAD  " +
            		"WHERE  RDL_RD_SYS_ID  = ?  " +
            				"AND RDL_COVER_SYS_ID  = ?  " +
            						"AND RDL_RPA_SRNO  = ? ";
            String sql_C3="SELECT POAD_SYS_ID FROM  PT_IL_POL_ASSURED_DTLS  " +
            		"WHERE  POAD_POL_SYS_ID  = "+M_POL_SYS_ID+" ";
            String sql_C4="SELECT    RPA_SRNO,    RPA_RD_SYS_ID,    RPA_RI_GROSS_FC_PREM,    " +
            		"RPA_REINS_COMM_PERC,    RPA_REINS_FC_COMM,    RPA_REINS_PRD_FC_COMM,    " +
            		"RPA_PRD_FM_DT,    RPA_PRD_TO_DT " +
            		"FROM  PT_IL_RI_PREM_ALLOC  " +
            		"WHERE  RPA_POL_SYS_ID  = "+M_POL_SYS_ID+"  " +
            				"AND RPA_COVER_SYS_ID  = "+M_COVER_SYS_ID+" " +
            						"ORDER BY RPA_SRNO  ";
            String sql_C5="SELECT    POL_CUST_CURR_CODE,    POL_CUST_EXCH_RATE " +
            		"FROM  PT_IL_POLICY  WHERE  POL_SYS_ID  = "+M_POL_SYS_ID+" ";
            vembu_C3=handler.executeSelectStatement(sql_C2, connection, new Object[]{M_RPA_RD_SYS_ID,M_COVER_SYS_ID,M_RPA_SRNO});
            if(vembu_C3.next()) {
                M_POAD_SYS_ID=vembu_C3.getInt(1);
            }
            vembu_C5=stmt_C5.executeQuery(sql_C5);
            if(vembu_C5.next()) {
                M_POL_CUST_CURR_CODE=vembu_C5.getString(1);
                M_POL_CUST_EXCH_RATE=vembu_C5.getString(2);
            }
            vembu_C4=stmt_C4.executeQuery(sql_C4);
            while((true)) {
                if(vembu_C4.next()) {
                    M_RPA_SRNO=vembu_C4.getString(1);
                    M_RPA_RD_SYS_ID=vembu_C4.getString(2);
                    M_RPA_RI_GROSS_FC_PREM=vembu_C4.getString(3);
                    M_RPA_REINS_COMM_PERC=vembu_C4.getString(4);
                    M_RPA_REINS_FC_COMM=vembu_C4.getString(5);
                    M_RPA_REINS_PRD_FC_COMM=vembu_C4.getString(6);
                    M_RPA_PRD_FM_DT=vembu_C4.getString(7);
                    M_RPA_PRD_TO_DT=vembu_C4.getString(8);
                }
                if(vembu_C4.isAfterLast() || vembu_C4.isBeforeFirst())
                break;
                M_TOT_FC_DISC_VALUE=0;
                M_TOT_FC_LOAD_VALUE=0;
                vembu_C2=stmt_C2.executeQuery(sql_C2);
                while((true)) {
                    if(vembu_C2.next()) {
                        M_RDL_SYS_ID=vembu_C2.getDouble(1);
                        M_RDL_RATE=vembu_C2.getString(2);
                        M_RDL_RATE_PER=vembu_C2.getString(3);
                        M_RDL_APPL_PERC=vembu_C2.getString(4);
                        M_RDL_DISC_LOAD_CODE=vembu_C2.getString(5);
                        M_RDL_DISC_LOAD_TYPE=vembu_C2.getString(6);
                    }
                    if(vembu_C2.isAfterLast() || vembu_C2.isBeforeFirst())
                    break;
                    if(M_RDL_DISC_LOAD_TYPE=="D"){
                        M_FC_DISC_VALUE=M_RPA_RI_GROSS_FC_PREM*(M_RDL_RATE/M_RDL_RATE_PER)*(M_RDL_APPL_PERC/100);
                        P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE,M_FC_DISC_VALUE,"R");
                        M_LC_DISC_VALUE=M_FC_DISC_VALUE*M_POL_CUST_EXCH_RATE;
                        M_TOT_FC_DISC_VALUE=M_TOT_FC_DISC_VALUE+M_FC_DISC_VALUE;
                    } else {
                        M_FC_LOAD_VALUE=M_RPA_RI_GROSS_FC_PREM*(M_RDL_RATE/M_RDL_RATE_PER)*(M_RDL_APPL_PERC/100);
                        P_VAL_ROUND_AMT.P_VAL_ROUND_AMT(M_POL_CUST_CURR_CODE,M_FC_LOAD_VALUE,"R");
                        M_LC_LOAD_VALUE=M_FC_LOAD_VALUE*M_POL_CUST_EXCH_RATE;
                        M_TOT_FC_LOAD_VALUE=M_TOT_FC_LOAD_VALUE+M_FC_LOAD_VALUE;
                    }
                    String sql_vembu1="UPDATE   PT_IL_RI_DISC_LOAD    SET RDL_FC_DISC_LOAD_VALUE = DECODE("+M_RDL_DISC_LOAD_TYPE+", 'D', "+M_FC_DISC_VALUE+", "+M_FC_LOAD_VALUE+"),      RDL_LC_DISC_LOAD_VALUE = DECODE("+M_RDL_DISC_LOAD_TYPE+", 'D', "+M_LC_DISC_VALUE+", "+M_LC_LOAD_VALUE+")  WHERE  RDL_RD_SYS_ID  = "+M_RPA_RD_SYS_ID+"  AND RDL_COVER_SYS_ID  = "+M_COVER_SYS_ID+"  AND RDL_RPA_SRNO  = "+M_RPA_SRNO+"  AND RDL_DISC_LOAD_CODE  = "+M_RDL_DISC_LOAD_CODE+"  ";
                    GlobalVariables.ROWCOUNT=stmt_vembu1.executeUpdate(sql_vembu1);
                }
                M_RPA_FC_EXTRA_PREM=M_TOT_FC_LOAD_VALUE-M_TOT_FC_DISC_VALUE;
                M_RPA_RI_FC_PREM=M_RPA_RI_GROSS_FC_PREM+M_RPA_FC_EXTRA_PREM;
                M_RPA_REINS_FC_COMM=M_RPA_RI_FC_PREM*(M_RPA_REINS_COMM_PERC/100);
                M_NO_DAYS=NumericFunctions.round(M_RPA_PRD_TO_DT-M_RPA_PRD_FM_DT)+1;
                M_RPA_REINS_PRD_FC_COMM=M_RPA_REINS_FC_COMM*(M_NO_DAYS/365);
                M_RPA_RI_LC_PRD_PREM=M_RPA_RI_FC_PREM*(M_NO_DAYS/365);
                String sql_vembu2="UPDATE   PT_IL_RI_PREM_ALLOC    SET RPA_RI_FC_PREM = "+M_RPA_RI_FC_PREM+",      RPA_RI_LC_PRD_PREM = "+M_RPA_RI_LC_PRD_PREM+",      RPA_FC_EXTRA_PREM = "+M_RPA_FC_EXTRA_PREM+",      RPA_REINS_FC_COMM = "+M_RPA_REINS_FC_COMM+",      RPA_REINS_PRD_FC_COMM = "+M_RPA_REINS_PRD_FC_COMM+"  WHERE  RPA_POL_SYS_ID  = "+M_POL_SYS_ID+"  AND RPA_RD_SYS_ID  = "+M_RPA_RD_SYS_ID+"  AND RPA_COVER_SYS_ID  = "+M_COVER_SYS_ID+"  AND RPA_SRNO  = "+M_RPA_SRNO+"  ";
                GlobalVariables.ROWCOUNT=stmt_vembu2.executeUpdate(sql_vembu2);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally {
        }*/
	}

}
