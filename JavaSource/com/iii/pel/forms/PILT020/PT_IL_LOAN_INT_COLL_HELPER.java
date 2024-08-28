package com.iii.pel.forms.PILT020;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.DBProcedures;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_LOAN_INT_COLL_HELPER {
	
	
	Map<String, Object> session = getSession();
	public void createCtrlBean(){
		ControlBean bean = new ControlBean();
		getSession().put("ctrlbean", bean);
		}
	public Map<String, Object> getSession(){
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}
	public ControlBean getCtrlBean(){
		return (ControlBean) getSession().get("ctrlbean");
	}
	public void putCtrlBean(ControlBean bean){
		getSession().put("ctrlbean", bean);
	}
  //block level triggers..........................
	CRUDHandler handler = new CRUDHandler();
	public void trig_pre_query_pt_il_loan_coll()
	{
		/*SET_BLOCK_PROPERTY('PT_IL_LOAN_INT_COLL',
                DEFAULT_WHERE,
	           'PT_IL_LOAN_INT_COLL.LIC_PC_SYS_ID = ' ||
                TO_CHAR(:PT_IL_PREM_COLL.PC_SYS_ID)
         );
*/
	}
	
	public void trig_post_query_pt_il_loan_coll() throws Exception
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		ResultSet rs = null;
		Connection con = CommonUtils.getConnection();
		PT_IL_LOAN_INT_COLL loanBean = actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN();
		String C2 = "SELECT LOAN_DT, LOAN_CURR_CODE, LOAN_EXCH_RATE FROM   PT_IL_LOAN WHERE  LOAN_SYS_ID = '"+loanBean.getLIC_PC_SYS_ID()+"'";
		try
		{
			rs = handler.executeSelectStatement(C2, con);
			if(rs.next())
			{
				loanBean.setUI_M_LOAN_DT(rs.getDate("LOAN_DT"));
				loanBean.setUI_LOAN_CURR_CODE(rs.getString("LOAN_CURR_CODE"));
				loanBean.setUI_M_LOAN_EXCH_RATE(rs.getDouble("LOAN_EXCH_RATE"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//WHEN_NEW_BLOCK_INSTANCE
	public void trig_when_new_block_instance_pt_il_loan_coll()throws Exception
		{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		ResultSet rs = null;
		Connection con = CommonUtils.getConnection();
		PT_IL_LOAN_INT_COLL loanBean = actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN();
		//String C2 = "SELECT LOAN_DT,LOAN_CURR_CODE,LOAN_EXCH_RATE FROM PT_IL_LOAN WHERE LOAN_SYS_ID ='"+loanBean.getLIC_LOAN_SYS_ID()+"'";
		String C2 = "SELECT LOAN_DT,LOAN_CURR_CODE,LOAN_EXCH_RATE FROM PT_IL_LOAN WHERE LOAN_SYS_ID =803";
		try
		{
			rs=handler.executeSelectStatement(C2, con);
			System.out.println("The resultset size............."+rs);
			if(rs.next())
			{
				loanBean.setUI_M_LOAN_DT(rs.getDate("LOAN_DT"));
				loanBean.setUI_LOAN_CURR_CODE(rs.getString("LOAN_CURR_CODE"));
				loanBean.setUI_M_LOAN_EXCH_RATE(rs.getDouble("LOAN_EXCH_RATE"));
//				   L_CHECK_LOAN_DTLS;
				}
		}catch (Exception e) {
		 e.printStackTrace();	
		}
		trig_l_check_loan_dtls();
		}

	public void trig_pre_update_pt_il_loan_coll() throws Exception
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_LOAN_INT_COLL loanBean = actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		loanBean.setLIC_UPD_DT(utility.getCurrentDate());
		loanBean.setLIC_UPD_UID(getCtrlBean().getM_USER_ID());
		premBean.setUI_M_FC_LOAN_INT(loanBean.getLIC_FC_INT_AMT());
		premBean.setUI_M_LC_LOAN_INT(loanBean.getLIC_LC_INT_AMT());
		
	}
	 	
	// item level triggers.....................................
/*	public void trig_when_validate_item_lic_int_rate()throws Exception
	{
		//L_CALC_LOAN_INT
		int L_CALC_LOAN_INT;
		int M_MODE_OF_PYMT;
		Date M_CURR_PYMT_DT;
		Date M_NEXT_PYMT_DT;
		int M_DURATION;
		int M_LOAN_SYS_ID;
		Date M_POL_EXPIRY_DT;
		ResultSet rs=null;
		Connection con;
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_LOAN_INT_COLL loanBean = actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		PT_IL_POLICY  policybean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY1 dummy1bean = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN();
		DUMMY dummyBean = actionBean.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		String C1 = "SELECT LOAN_SYS_ID FROM   PT_IL_LOAN WHERE  LOAN_POL_SYS_ID ='"+policybean.getPOL_SYS_ID()+"' " +
				"AND    LOAN_STATUS     = 'A' AND    LOAN_SYS_ID     ='"+loanBean.getLIC_LOAN_SYS_ID()+"' AND    LOAN_DT< '"+premBean.getPC_SCHD_PYMT_DT()+"'";
		
		String C3 = "SELECT DECODE (POL_MODE_OF_PYMT,'Y',12,'H',6,'Q',3,'M',1), POL_EXPIRY_DT FROM   PT_IL_POLICY WHERE  POL_SYS_ID='"+policybean.getPOL_SYS_ID()+"'";
		con=utility.getConnection();
		rs = handler.executeSelectStatement(C1, con);
		if(rs.next())
		{
			M_LOAN_SYS_ID=rs.getInt("LOAN_SYS_ID");
		}
		rs.close();
		
		rs = handler.executeSelectStatement(C3, con);
		if(rs.next())
		{
			M_MODE_OF_PYMT = rs.getInt("POL_MODE_OF_PYMT");
			M_POL_EXPIRY_DT = rs.getDate("POL_EXPIRY_DT");	
			if(MigratingFunctions.nvl(premBean.getPC_PAID_FLAG(), "N")=="N")
			{
				M_CURR_PYMT_DT = premBean.getPC_SCHD_PYMT_DT();
				M_NEXT_PYMT_DT = ADD_MONTHS(M_CURR_PYMT_DT,M_MODE_OF_PYMT);
				if(M_NEXT_PYMT_DT > M_POL_EXPIRY_DT)
				{
					M_NEXT_PYMT_DT = M_POL_EXPIRY_DT;
				}
			M_DURATION = (M_NEXT_PYMT_DT - M_CURR_PYMT_DT)/(ADD_MONTHS(M_CURR_PYMT_DT,12) - M_CURR_PYMT_DT );
			String LOAN_FC_AMOUNT = loanBean.getM_LOAN_FC_AMOUNT().toString();
            Double amt = MigratingFunctions.nvl(loanBean.getUI_M_LOAN_FC_AMOUNT(), 0.0)*(loanBean.getLIC_INT_RATE()/100)*MigratingFunctions.nvl(M_DURATION, 0);
			//Double amt = MigratingFunctions.nvl("LOAN_FC_AMOUNT", "0.0")*(loanBean.getLIC_INT_RATE()/100)*MigratingFunctions.nvl("M_DURATION", "0");
			loanBean.setLIC_FC_INT_AMT(amt);
			DBProcedures dbProcedures = new DBProcedures();
			Double value = 0.0;
			if(loanBean.getLIC_FC_INT_AMT()==null){
				value = 0.0;
			}else{
				value = loanBean.getLIC_FC_INT_AMT();
			}ArrayList<String> list = dbProcedures.callP_VAL_ROUND_AMT(dummyBean.getUI_BASE_CURR_CODE(), value+"", "R");
	         value = Double.valueOf(list.get(0));
		   
	         
	         Double value1 = MigratingFunctions.nvl(loanBean.getLIC_FC_INT_AMT(), 0) * MigratingFunctions.nvl(loanBean.getUI_M_LOAN_EXCH_RATE(), 0);
 		    loanBean.setLIC_LC_INT_AMT(value1);
 		    if(loanBean.getLIC_LC_INT_AMT()==null){
 				value1 = 0.0;
 			}else{
 				value1 = loanBean.getLIC_LC_INT_AMT();
 			}
 			ArrayList<String> list1 = dbProcedures.callP_VAL_ROUND_AMT(dummy1bean.getUI_M_POL_CURR_CODE(), value1+"", "R");
 			value = Double.valueOf(list1.get(0));
 			loanBean.setLIC_LC_INT_AMT(value);
 		    
		    	}
				
		}
	con.close();
	}*/
	Double value1 = 0.0;
	public void trig_when_validate_item_lic_fc_int_amt()throws Exception
	{
		Date M_NEXT_SCHD_DT ;
		int M_DURATION;
		String M_LOAN_CURR_CODE;
		Double M_LOAN_EXCH_RATE=0.0;
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_LOAN_INT_COLL loanBean = actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN();
		DUMMY1  dummy1bean = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN();
		DUMMY dummyBean = actionBean.getDUMMY_ACTION_BEAN().getDUMMY_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT MIN(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID ='"+premBean.getPC_POL_SYS_ID()+"' AND NVL(PC_PAID_FLAG,'N')!= 'A' AND PC_SCHD_PYMT_DT >= '"+loanBean.getUI_M_LOAN_DT()+"'";
		
		M_DURATION =dummyBean.getUI_M_LOAN_DURATION() ;
		
		//loanBean.setLIC_LC_INT_AMT(MigratingFunctions.nvl(loanBean.getLIC_FC_INT_AMT().toString(),"0.0")*(MigratingFunctions.nvl(loanBean.getM_LOAN_EXCH_RATE().toString(),"0.0"))
		Double var1= Double.parseDouble(MigratingFunctions.nvl(Double.toString(loanBean.getLIC_FC_INT_AMT()),"0.0"));
		Double var2 = Double.parseDouble(MigratingFunctions.nvl(loanBean.getUI_M_LOAN_EXCH_RATE().toString(), "0.0"));
		loanBean.setLIC_FC_INT_AMT((var1)*(var2));
		//loanBean.setLIC_LC_INT_AMT(LIC_LC_INT_AMT)
		Double value1 = 0.0;
		if(loanBean.getLIC_FC_INT_AMT()==null){
			value1 = 0.0;
		}else{
			value1 = loanBean.getLIC_FC_INT_AMT();
		}
	    DBProcedures dbProcedures = new DBProcedures();
       //dbProcedures.callP_VAL_ROUND_AMT(dummyBean.getUI_BASE_CURR_CODE(),loanBean.getLIC_LC_INT_AMT().toString());
       ArrayList<String> list = dbProcedures.callP_VAL_ROUND_AMT(dummyBean.getUI_BASE_CURR_CODE(), value+"", "R");
       value1 = Double.valueOf(list.get(0));
       loanBean.setLIC_FC_INT_AMT(value1);
		
	}
	
	Double value = 0.0;
	public void trig_when_validate_item_lic_lc_int_amt()throws Exception
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_LOAN_INT_COLL loanBean = actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN();
		DUMMY1  dummy1bean = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		DBProcedures dbProcedures = new DBProcedures();
	/*	System.out.println("loanBean.getLIC_LC_INT_AMT()........"+loanBean.getLIC_LC_INT_AMT());
		
		if(loanBean.getLIC_LC_INT_AMT().equals(null)){
			value = 0.0;
		}else{
			value = loanBean.getLIC_LC_INT_AMT();
			System.out.println("Helper Value inside.............."+value);
			}*/
		dummy1bean.getUI_M_POL_CURR_CODE();
		ArrayList<String> list = dbProcedures.callP_VAL_ROUND_AMT("dummy1bean.getUI_M_POL_CURR_CODE()", value+"", "R");
		   
		value = Double.valueOf(list.get(0));
		
		 
		loanBean.setLIC_LC_INT_AMT(value);
		PILT020_DB_PROCEDURES.callP_VAL_FC_LC_TOLERANCE(CommonUtils.getConnection(), loanBean.getLIC_FC_INT_AMT().toString(), loanBean.getLIC_LC_INT_AMT().toString(), loanBean.getUI_M_LOAN_EXCH_RATE().toString(), "E");  
		System.out.println("Helper Value Outside.............."+list.get(0));
		System.out.println("........................"+list.get(0));
		System.out.println("\n\nHelper Value value.............."+value);
	}
 // L_CHECK_LOAN_DTLS for populating some fields
	
	public void trig_l_check_loan_dtls()throws Exception{
		int M_LOAN_SYS_ID;
		double M_LOAN_FC_AMOUNT=0.0;
		double M_LOAN_LC_AMOUNT=0.0;
		double M_FC_REPAID_AMT=0.0;
		double M_LC_REPAID_AMT=0.0;
		double M_LOAN_INT_RATE=0.0;
		int M_MODE_OF_PYMT;
		Date M_CURR_PYMT_DT;
		Date M_NEXT_PYMT_DT;
		int M_DURATION;
		int M_EXCH_RATE;
		ResultSet rs = null;
		ResultSet rst = null;
		CRUDHandler handler = new CRUDHandler();
		String M_LOAN_CURR_CODE;
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY polBean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		PT_IL_LOAN_INT_COLL loanBean = actionBean.getPT_IL_LOAN_INT_COLL_ACTION_BEAN().getPT_IL_LOAN_INT_COLL_BEAN();
		String C1 ="SELECT LOAN_SYS_ID, LOAN_INT_RATE,LOAN_CURR_CODE,LOAN_EXCH_RATE,NVL(LOAN_FC_AMOUNT,0),(LOAN_LC_AMOUNT,0) FROM   PT_IL_LOAN " +
				"WHERE  LOAN_POL_SYS_ID = '"+polBean.getPOL_SYS_ID()+"' AND    NVL(LOAN_STATUS,'N') != 'N' AND    LOAN_DT < " +
						"'"+premBean.getPC_SCHD_PYMT_DT()+"' AND LOAN_SYS_ID = '"+loanBean.getLIC_LOAN_SYS_ID()+"'";
		System.out.println("C1 query output is>>>>>>>>>>"+C1);
		String C2 = "SELECT SUM(LR_LC_LOAN_AMT),  SUM(LR_FC_LOAN_AMT) FROM   PT_IL_LOAN_REPAYMENT WHERE  LR_LOAN_SYS_ID " +
				"= M_LOAN_SYS_ID AND    LR_PYMT_DT = '"+premBean.getPC_PAID_DT()+"' AND LR_STATUS  =   'A' ";
		
		rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		while(rs.next()){
			M_LOAN_SYS_ID =rs.getInt("LOAN_SYS_ID");
			M_LOAN_INT_RATE=rs.getDouble("LOAN_INT_RATE");
			M_LOAN_CURR_CODE=rs.getString("LOAN_CURR_CODE");
			M_EXCH_RATE=rs.getInt("LOAN_EXCH_RATE");
			M_LOAN_FC_AMOUNT=rs.getDouble("LOAN_FC_AMOUNT");
			M_LOAN_LC_AMOUNT=rs.getDouble("LOAN_LC_AMOUNT");
		}
		if(rs!=null){
			rst = handler.executeSelectStatement(C2, CommonUtils.getConnection());
			while(rs.next()){
				M_LC_REPAID_AMT= rst.getDouble("LR_LC_LOAN_AMT");
				M_FC_REPAID_AMT = rst.getDouble("LR_FC_LOAN_AMT");
			}
		}
		loanBean.setUI_M_LOAN_FC_AMOUNT(M_LOAN_FC_AMOUNT);
		loanBean.setUI_M_LOAN_LC_AMOUNT(M_LOAN_LC_AMOUNT);
		loanBean.setUI_M_FC_REPAID_AMT(M_FC_REPAID_AMT);
		loanBean.setUI_M_LC_REPAID_AMT(M_LC_REPAID_AMT);
		loanBean.setUI_M_FC_BAL_LOAN_AMT(M_LOAN_FC_AMOUNT-MigratingFunctions.nvl(M_FC_REPAID_AMT, 0));
		loanBean.setUI_M_LC_BAL_LOAN_AMT(M_LOAN_LC_AMOUNT-MigratingFunctions.nvl(M_LC_REPAID_AMT, 0));
		loanBean.setUI_M_LOAN_INT_RATE(M_LOAN_INT_RATE);
		
	rs.close();
	rst.close();
	  
	}
	

}
