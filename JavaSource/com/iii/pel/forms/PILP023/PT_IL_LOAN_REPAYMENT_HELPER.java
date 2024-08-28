package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_LOAN_REPAYMENT_HELPER {
	
	public static void pilp023_pt_il_loan_repayment_post_query(FacesContext context) 
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		Map<String, Object> sessionMAp = context.getExternalContext().getSessionMap();
		PILP023_COMPOSITE_ACTION COMPOSITE_ACTION = (PILP023_COMPOSITE_ACTION)sessionMAp.get("PILP023_COMPOSITE_ACTION");
		PT_IL_LOAN_REPAYMENT LOAN_REPAY_BEAN = COMPOSITE_ACTION.getPILP023_PT_IL_LOAN_REPAYMENT_ACTION().getPT_IL_LOAN_REPAYMENT_BEAN();
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
        try
        {
//            final dbms_output dbms_output1=new dbms_output();
        	connection = CommonUtils.getConnection();
//        	:PT_IL_LOAN_REPAYMENT.LR_LOAN_SYS_ID
            String sql_C1="SELECT LOAN_POL_NO, LOAN_DT FROM PT_IL_LOAN" +
            				" WHERE  LOAN_SYS_ID  = ? ";
            ResultSet rs_C1=null;
//            Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            if(rs_C1!=null)
            {
            	rs_C1.close();
            }
//            vembu_C1=stmt_C1.executeQuery(sql_C1);
            rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{LOAN_REPAY_BEAN.getLR_LOAN_SYS_ID()});
            if(rs_C1.next())
            {
            }
            rs_C1.close();
//            P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:PT_IL_PYMT_DTLS.PD_CURR_CODE);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
	public static void pilp023_pt_il_loan_repayment_when_new_block_instance() 
    {/*
        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_LOAN_REPAYMENT",DEFAULT_WHERE," LR_SYS_ID = "+MigratingFunctions.nvl(:PT_IL_CHEQUE_BOUNCE_HDR.CBH_LR_SYS_ID,0));
            EXECUTE_QUERY.EXECUTE_QUERY();
            SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_LOAN_REPAYMENT",DEFAULT_WHERE,"");
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
    */}
	public static void pilp023_pt_il_loan_repayment_m_but_loan_repay_dtls_back_when_button_pressed() 
    {/*
        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            HIDE_VIEW.HIDE_VIEW("PT_IL_LOAN_REPAYMENT");
            GO_ITEM.GO_ITEM("DUMMY.M_DEP_DOC_NO");
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
    */}
		
}








