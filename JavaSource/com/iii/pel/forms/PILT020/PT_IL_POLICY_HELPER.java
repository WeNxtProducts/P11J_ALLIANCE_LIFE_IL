package com.iii.pel.forms.PILT020;

import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.runtime.functions.MigratingFunctions;

public class PT_IL_POLICY_HELPER {

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
	// Block level triggers
	public void trig_when_new_block_instance_pt_il_policy()
	{
	/*	SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE',ENABLED, PROPERTY_FALSE);

		IF NVL(:PT_IL_POLICY.POL_STATUS, 'N') IN ('P','C') THEN
		   SET_ITEM_PROPERTY('M_BUT_REINSTATE', ENABLED, PROPERTY_TRUE);
		ELSE
		   SET_ITEM_PROPERTY('M_BUT_REINSTATE', ENABLED, PROPERTY_FALSE);
		END IF;*/
	}
	
	public void trig_post_query_pt_il_policy() throws Exception
	{
		String M_DUMMY;
		ResultSet rs=null;
		CRUDHandler handler = new CRUDHandler();
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY policyBean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT 'X' FROM  PT_IL_SURR_MAT_VALUES,PT_IL_POLICY WHERE SMV_POL_SYS_ID='"+policyBean.getPOL_SYS_ID()+"' " +
				"AND   SMV_POL_SYS_ID = '"+premBean.getPC_POL_SYS_ID()+"' AND   SMV_TYPE = 'M' AND   NVL(SMV_APPRV_FLAG,'N') = 'A' AND   NVL(POL_STATUS,'N') = 'M'" ;
		
		if(MigratingFunctions.nvl(policyBean.getPOL_STATUS(), "N")=="A"||MigratingFunctions.nvl(policyBean.getPOL_STATUS(), "N")=="E"||MigratingFunctions.nvl(policyBean.getPOL_STATUS(), "N")=="R")
		{
			//SET_BLOCK_PROPERTY ('PT_IL_PREM_COLL', UPDATE_ALLOWED, PROPERTY_TRUE);
		}
		else if(MigratingFunctions.nvl(policyBean.getPOL_STATUS(), "N")=="M")
		{
			rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
			if(rs.next())
			{
				//SET_BLOCK_PROPERTY ('PT_IL_PREM_COLL', UPDATE_ALLOWED, PROPERTY_FALSE); 
				
				
			}else
			{
				//SET_BLOCK_PROPERTY ('PT_IL_PREM_COLL', UPDATE_ALLOWED, PROPERTY_TRUE);
			}
		}else
		{
			//SET_BLOCK_PROPERTY ('PT_IL_PREM_COLL', UPDATE_ALLOWED, PROPERTY_FALSE);
		}
		
		rs.close();
		
		// sec Declare
		/*Double M_DEPOSIT_AMT=0.0;
		String M_PS_VALUE;
		String M_PS_CODE_DESC;
		int CONT_LC_PROP_DEP_AMT = MigratingFunctions.nvl(CONT_LC_PROP_DEP_AMT, 0);
		int CON
		String C1 ="SELECT DECODE('"+premBean.getPC_PREM_TYPE()+"','N',CONT_LC_PROP_DEP_AMT - )  ";*/
		
	}//trig close
	
	public void trig_pre_query_pt_il_policy()
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY policyBean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		DUMMY1 dummyBean = actionBean.getDUMMY1_ACTION_BEAN().getDUMMY1_BEAN();
		if(session.get("GLOBAL.M_POL_NO")!=null)
		{
			String pol_no = session.get("GLOBAL.M_POL_NO").toString();
			policyBean.setPOL_NO(pol_no);
	     }
		if(dummyBean.getUI_M_EMPLOYER_CODE()!=null)
		{
		/*	SET_BLOCK_PROPERTY('PT_IL_PREM_COLL',DEFAULT_WHERE,'POL_EMPLOYER_CODE = ' ||:DUMMY1.M_EMPLOYER_CODE 
	                   || ' AND PC_PAID_FLAG != ''A''');*/
		}else
		{
			//SET_BLOCK_PROPERTY('PT_IL_POLICY',DEFAULT_WHERE,'POL_CONT_CODE = ''' || :DUMMY1.M_CONTRACTOR_CODE || '''');
		}
	}
}
