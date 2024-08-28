package com.iii.pel.forms.PILT020;

import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PILT020_REINSTATEMENT_HELPER {

	//ok button
//	UPDATE PT_IL_POLICY
//	SET POL_STATUS = 'R',
//	    POL_END_TYPE = '006',
//	    POL_END_DT = :DUMMY.M_REINS_DATE,
//	    POL_FC_CURR_SA = POL_FC_SUM_ASSURED,
//	    POL_LC_CURR_SA = POL_LC_SUM_ASSURED
//	WHERE POL_SYS_ID = :PT_IL_POLICY.POL_SYS_ID;
//
//	:CTRL.M_COMM_DEL := 'P';
//	POST;
//	:CTRL.M_COMM_DEL := NULL;
//
//	L_UPDATE_UNPAID_PREM_DTLS;
//
//	L_UPDATE_LOAN_DETLS;
//
//	--L_CREATE_RECORDS;
//
//	:CTRL.M_COMM_DEL := 'C';
//	COMMIT;
//	:CTRL.M_COMM_DEL := NULL;
//
//	:GLOBAL.M_POL_NO := :PT_IL_PREM_COLL.M_PC_POL_NO;
//	GO_BLOCK('PT_IL_POLICY');
//	EXECUTE_QUERY;
	Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	/*public void createCtrlBean(){
		ControlBean bean = new ControlBean();
		FacesContext faces = FacesContext.getCurrentInstance();
		session = faces.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}*/

	/*public void putCtrlBean(ControlBean bean){
		FacesContext faces1 = FacesContext.getCurrentInstance();
		session =  faces1.getExternalContext().getSessionMap();
		session.put("ctrlbean", bean);
	}*/


	public ControlBean getCtrlBean(){
		/*FacesContext faces2 = FacesContext.getCurrentInstance();
		session =  faces2.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");*/
		
		return CommonUtils.getControlBean();
	}
	CommonUtils utility = new CommonUtils();
	public void ok_pt_il_policy_when_update()
	{
	getCtrlBean().setM_COMM_DEL("P");
	String mappedBeanName="PILT020_DUMMY_ACTION";
	String mappedBeanName1 = "PILT020_PT_IL_POLICY_ACTION";
	DUMMY_ACTION actionBean=(DUMMY_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
	PT_IL_POLICY_ACTION actionBean1 = (PT_IL_POLICY_ACTION)utility.getMappedBeanFromSession(mappedBeanName1);
	String Upd_Qry = "UPDATE PT_IL_POLICY SET POL_STATUS = 'R' POL_END_TYPE = '006',POL_END_DT = '"+actionBean.getDUMMY_BEAN().getUI_M_REINS_DATE()+"',POL_FC_CURR_SA = POL_FC_SUM_ASSURED,POL_LC_CURR_SA = POL_LC_SUM_ASSURED WHERE POL_SYS_ID ='"+actionBean1.getPT_IL_POLICY_BEAN().getPOL_SYS_ID()+"' ";
	
	}
}
