package com.iii.pel.forms.PILT020;

import java.sql.ResultSet;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_HELPER {

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
	// block level triggers
	public void trig_pre_block_pt_il_pymt_details()
	{/*
		IF FORM_FAILURE THEN
		   :GLOBAL.M_FAILURE := 'TRUE';
		END IF;*/
	
		getCtrlBean().setM_DELETE_MSG_FLAG("N");

	}
	public void trig_pre_update_pt_il_pymt_dtls()
	{
	/*	L_DUP_SERIAL_NO;
		:PT_IL_PYMT_DTLS.PD_UPD_DT	  := SYSDATE;
		:PT_IL_PYMT_DTLS.PD_UPD_UID	  := :CTRL.M_USER_ID;*/
		
		
	}
	public void trig_pre_insert_pt_il_pymt_dtls()throws Exception 
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_PYMT_DTLS pymtBean = actionBean.getPT_IL_PYMT_DTLS_ACTION_BEAN().getPT_IL_PYMT_DTLS_BEAN();
		PILT020_DB_PROCEDURES dbproc = new PILT020_DB_PROCEDURES();
		ResultSet rs =null;
		CRUDHandler handler = new CRUDHandler();
		String C1 = "SELECT PIL_PD_SYS_ID.NEXTVAL FROM DUAL";
		//dbproc.L_DUP_SERIAL_NO(pymtBean);
		rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		if(rs.next())
		{
			pymtBean.setPD_SYS_ID(rs.getLong("PIL_PD_SYS_ID"));
		}
		pymtBean.setPD_CR_DT(utility.getCurrentDate());
		pymtBean.setPD_CR_UID(getCtrlBean().getM_USER_ID());
		
	}
	
   
}
