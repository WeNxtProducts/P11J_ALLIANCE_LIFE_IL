package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_DEPOSIT_HELPER {

	public ArrayList<PT_IL_DEPOSIT> deposit_query(PILP023_COMPOSITE_ACTION compositeAction) throws Exception
	{
		PT_IL_CHEQUE_BOUNCE_HDR chequeHdr = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PT_IL_DEPOSIT> depositList = new ArrayList<PT_IL_DEPOSIT>();
		PT_IL_DEPOSIT depositBean = null;
		/*Added by sankara narayanan for deposit Derail on 05/03/201 ref : ZBILQC-1720414 */
		/*
		 * modified by Ameen on 20-06-2017 for ZBILQC-1720414
		 * String query = "SELECT * FROM PT_IL_DEPOSIT" +
						" WHERE DEP_SYS_ID = NVL(?,0)";*/
		String query = "SELECT TO_CHAR(TO_DATE(DEP_FLEX_01,'DD/MM/RRRR'),'DD/MM/RRRR') REVERSAL_DATE, PT_IL_DEPOSIT.* FROM PT_IL_DEPOSIT" +
				" WHERE DEP_SYS_ID = NVL(?,0)";
		//end
		try {
			//chequeHdr = new PT_IL_CHEQUE_BOUNCE_HDR();
			connection = CommonUtils.getConnection();
			System.out.println("getUI_M_DEP_SYS_ID() : "+chequeHdr.getUI_M_DEP_SYS_ID());
			if(chequeHdr.getUI_M_DEP_SYS_ID() != null)
			{
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{chequeHdr.getUI_M_DEP_SYS_ID()});
			
			while(rst.next())
			{
				depositBean = new PT_IL_DEPOSIT();
				/*Added by sankara narayanan for deposit Derail on 05/03/201 ref : ZBILQC-1720414 */
				depositBean.setDEP_LC_DEP_AMT(rst.getDouble("DEP_LC_DEP_AMT"));
				depositBean.setUI_M_DPD_REF_ID(rst.getString("DEP_REF_NO"));
				depositBean.setUI_M_DEP_FC_DEP_AMT(rst.getDouble("DEP_LC_DEP_AMT"));
				//end
				/*Added by Ameen on 20-06-2017 for ZBILQC-1720414 */
				depositBean.setDEP_FLEX_01(rst.getString("REVERSAL_DATE"));//REVERSAL DATE
				depositBean.setDEP_FLEX_02(rst.getString("DEP_FLEX_02"));//REVERSAL TXN CODE
				depositBean.setDEP_FLEX_03(rst.getString("DEP_FLEX_03"));//REVERSAL DOC NO
				depositBean.setDEP_FLEX_04(rst.getString("DEP_FLEX_04"));//REVERSAL ACNT YEAR
				/*end*/
				pilp023_pt_il_deposit_post_query(compositeAction);
				depositList.add(depositBean);
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return depositList;
	}
	
	 public void pilp023_pt_il_deposit_post_query(PILP023_COMPOSITE_ACTION compositeAction) throws Exception
	    {
		// Map<String, Object> sessionMap =  FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		// PILP023_COMPOSITE_ACTION compositeAction = (PILP023_COMPOSITE_ACTION)sessionMap.get("PILP023_COMPOSITE_ACTION");
		 PT_IL_CHEQUE_BOUNCE_HDR BOUNCE_BEAN = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN();
		 
		 PT_IL_DEPOSIT depositBean = compositeAction.getPILP023_PT_IL_DEPOSIT_ACTION().getPT_IL_DEPOSIT_BEAN();
//	        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		 
		 Connection connection = null;
		 CRUDHandler handler = new CRUDHandler();
	
		 String REF_ID = null;
		 ResultSet rs_C1=null;
	        try
	        {
	        	connection = CommonUtils.getConnection();
	            String sql_C1="SELECT PD_DPD_REF_ID FROM PT_IL_PYMT_DTLS" +
	            				 "  WHERE  PD_TXN_SYS_ID  = ?" +
	            					"  AND PD_TXN_TYPE  = ? ";
	            rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{BOUNCE_BEAN.getCBH_DEP_SYS_ID(), BOUNCE_BEAN.getCBH_TXN_TYPE()});
	            if(rs_C1.next())
	            {
	            	REF_ID = rs_C1.getString("PD_DPD_REF_ID");
	            	
	            }
	            rs_C1.close();
	            depositBean.setUI_M_DPD_REF_ID(REF_ID);
	            if(depositBean.getDEP_LC_DEP_AMT()!=null){
	            	depositBean.setUI_M_DEP_FC_DEP_AMT(depositBean.getDEP_LC_DEP_AMT()*1);
	            }
	            
	        }catch(Exception e)
	        {
	            e.printStackTrace();
	            throw e;
	        }
	        
	    }
}
