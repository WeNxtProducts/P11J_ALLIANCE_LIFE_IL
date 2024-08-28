package com.iii.pel.forms.PILT020;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.apps.persistence.OracleProcedureHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PILT020_BUTTON_LEVEL_PROCEDURES {

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
	//APPROVE BUTTON PENDING
	
	//Facout Button 
	public void pilt020_when_button_press_facout()throws Exception
	{
		ResultSet rs = null;
		CRUDHandler handler = new CRUDHandler();
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY policyBean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getDUMMY_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String selectQuery = "SELECT POL_SYS_ID FROM PT_IL_POLICY WHERE POL_SYS_ID ='"+premBean.getUI_M_PC_POL_NO()+"'";
		System.out.println("The pol_sys_id in facout is................"+selectQuery);
		
		
		String C1 = "SELECT PC_SYS_ID FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID ='"+policyBean.getPOL_SYS_ID()+"' " +
				"AND NVL(PC_PREM_TYPE, 'N') IN ('R', 'N') AND NVL(PC_PAID_FLAG, 'N')= 'A' AND NVL(PC_FAC_CLOSE_FLAG,'N') = 'N'";
		System.out.println("The Query formed for C1-------->"+C1);
		
		rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		if(rs.next())
		{
			session.put("GLOBAL.M_PC_SYS_ID", rs.getInt("PC_SYS_ID"));
		}else
		{
			String message=Messages.getString(PELConstants.pelErrorMessagePath, "71173");
			Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
			errMap.put("current",message);
			errMap.put("someKey",message);
		}
		rs.close();
		getCtrlBean().setM_COMM_DEL("P");
		//POST;
		getCtrlBean().setM_COMM_DEL(null);
		session.put("GLOBAL.M_POL_NO", premBean.getUI_M_PC_POL_NO());
		/* CALL_FORM('PILT009', NO_HIDE, NO_REPLACE);
		   EXECUTE_QUERY;
		*/
		
	}
	
	// Approve Button trigger 
	
	public void pilt_020_when_button_press_approve()throws Exception{
		String M_PC_PREM_TYPE;
		int M_PC_POL_SYS_ID=0;
		int M_PC_SYS_ID;
		String M_POL_FAC_YN = null;
		int M_PC_POL_SYS_ID_1;
		String M_POL_NO = null;
		String M_CONT_CODE;
		ResultSet rs = null;
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CRUDHandler handler = new CRUDHandler();
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		DUMMY1 dummy1Bean = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN();
		PT_IL_POLICY policyBean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT COUNT(*) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = '"+M_PC_POL_SYS_ID+"' " +
				"AND    NVL(PC_PREM_TYPE,'N')  IN ('R', 'N') AND    NVL(PC_PAID_FLAG,'N')  = 'A' " +
				"AND    (NVL(PC_FAC_CLOSE_FLAG,'N') != 'Y' OR     NVL(PC_RI_CLOSE_FLAG,'N') != 'Y')";
		String C2A = "SELECT PC_PREM_TYPE FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID ='"+M_PC_POL_SYS_ID+"' " +
				" AND    PC_PAID_FLAG = 'Y'";
		String C2 = "SELECT 'X' FROM   PT_IL_RI_PREM_ALLOC WHERE  RPA_POL_SYS_ID = '"+M_PC_POL_SYS_ID+"' " +
				"AND    NVL(RPA_RI_CLOSE_FLAG,'N') != 'Y'";
		String C4 = "SELECT PC_POL_SYS_ID, PC_SYS_ID, NVL(POL_FAC_YN,'N'),POL_NO FROM   PT_IL_POLICY, PT_IL_PREM_COLL " +
				"WHERE  POL_SYS_ID = PC_POL_SYS_ID AND    PC_PAID_DT = '"+CommonUtils.dateToPELStringFormatter(dummy1Bean.getUI_M_PAID_DT())+"' AND    NVL(PC_PAID_FLAG,'N') = 'Y'";
		
		String C5 = "SELECT COUNT(*) FROM   PT_IL_PYMT_DTLS WHERE  PD_TXN_SYS_ID=( SELECT MIN(PC_SYS_ID) FROM PT_IL_PREM_COLL " +
				"WHERE  PC_POL_SYS_ID = '"+policyBean.getPOL_SYS_ID()+"' AND NVL(PC_PAID_FLAG,'N')  = 'Y' " +
						"AND    PC_PAID_DT IS NOT NULL) AND PD_TXN_TYPE  ='PC'";
		int M_DUMMY;
		String M_FAC_CFG;
		String M_RI_CFG;
		int M_COUNT;
/*		IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN
		   --   disp_alert ('Please Save all the changes and Choose this Option!');
		      STD_MESSAGE_ROUTINE (71048, :CTRL.M_LANG_CODE);
		      RAISE FORM_TRIGGER_FAILURE;
		   END IF;*/
		rs = handler.executeSelectStatement(C5, CommonUtils.getConnection());
		if(rs.next())
		{
			M_COUNT = rs.getInt(1);
			if(M_COUNT ==0)
			{
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "91171");
				Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
				errMap.put("current",message);
				errMap.put("someKey",message);
			}
		}
		rs.close();
		
		rs = handler.executeSelectStatement(C4,CommonUtils.getConnection());
		if(rs.next())
		{
			M_PC_POL_SYS_ID = rs.getInt("PC_POL_SYS_ID");
			M_PC_SYS_ID = rs.getInt("PC_SYS_ID");
			M_POL_FAC_YN = rs.getString("POL_FAC_YN");
			M_POL_NO = rs.getString("POL_NO");
		}
		rs.close();
		if(M_POL_FAC_YN =="Y")
		{
			rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
			M_DUMMY = rs.getInt(1);
		}
		M_DUMMY = rs.getInt(1);
		rs.close();
		if(premBean.getPC_PREM_TYPE()==null){
			premBean.setPC_PREM_TYPE("N");
     	}else if((premBean.getPC_PREM_TYPE()=="N") ||(premBean.getPC_PREM_TYPE()=="R") && (premBean.getPC_FAC_CLOSE_FLAG()=="Y") ||(premBean.getPC_RI_CLOSE_FLAG()=="Y")&&(M_DUMMY>=1) ){
     		String message=Messages.getString(PELConstants.pelErrorMessagePath, "71151");
			Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
			errMap.put("current",message);
			errMap.put("someKey",message);
     	}
	  rs = handler.executeSelectStatement(C2A, CommonUtils.getConnection());
	  if(rs.next()){
		  M_PC_PREM_TYPE = rs.getString("PC_PREM_TYPE");
		  if("R".equals(M_PC_PREM_TYPE)){
			  rs =handler.executeSelectStatement(C2, CommonUtils.getConnection());
			  if(rs.next()){
				  M_RI_CFG = rs.getString("M_RI_CFG");
			  }else
			  {
				  String message=Messages.getString(PELConstants.pelErrorMessagePath, "71185");
					Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
					errMap.put("current",message);
					errMap.put("someKey",message);
			  }
			  
	  		}
    	}//if
	  OracleProcedureHandler procHandler = new OracleProcedureHandler();
	  ArrayList<OracleParameter> parameterList = new ArrayList<OracleParameter>();
	  OracleParameter param1 = new OracleParameter("IN1", "STRING", "IN",M_PC_POL_SYS_ID+"");
	  OracleParameter param2 = new OracleParameter("IN1", "STRING", "IN","PC");
	  parameterList.add(param1);
	  parameterList.add(param2);
	  procHandler.execute(parameterList, CommonUtils.getConnection(),"P9ILPK_CHEQ_VALIDATION.INS_PREM_PYMT_DTLS");
	  PILT020_DB_PROCEDURES obj = new PILT020_DB_PROCEDURES();
	  obj.L_CHECK_SURR_MAT_VAL_OLD("R");
	  CommonUtils.setGlobalVariable("GLOBAL.M_PAID_DT", dummy1Bean.getUI_M_PAID_DT()+"");
	  CommonUtils.setGlobalVariable("GLOBAL.M_DUE_PERIOD_FM", dummy1Bean.getUI_M_DUE_PERIOD_FM()+"");
	  CommonUtils.setGlobalVariable("GLOBAL.M_DUE_PERIOD_TO", dummy1Bean.getUI_M_DUE_PERIOD_TO()+"");
	  CommonUtils.setGlobalVariable("GLOBAL.M_POL_NO", M_POL_NO);
	 // CALL_FORM('PILP013',NO_HIDE,NO_REPLACE);
	  if(CommonUtils.getGlobalVariable("GLOBAL.M_SUCC")=="Y"){
		  String message=Messages.getString(PELConstants.pelErrorMessagePath, "60315");
			Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
			errMap.put("current",message);
			errMap.put("someKey",message);
		/*	GO_BLOCK ('PT_IL_POLICY');
		      EXECUTE_QUERY;*/	
	  }else{
		  String message=Messages.getString(PELConstants.pelErrorMessagePath, "71078");
			Map<String, String> errMap = actionBean.getDUMMY1_ACTION_BEAN().getErrorMap(); 
			errMap.put("current",message);
			errMap.put("someKey",message);
		  
	  }
	}
}
