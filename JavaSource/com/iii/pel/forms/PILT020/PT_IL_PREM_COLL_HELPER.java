package com.iii.pel.forms.PILT020;

import java.sql.ResultSet;
import java.util.Date;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.vembu.plsql.runtime.functions.MigratingFunctions;

public class PT_IL_PREM_COLL_HELPER extends CommonAction {

	Map<String, Object> session = getSession();

	public void createCtrlBean() {
		ControlBean bean = new ControlBean();
		getSession().put("ctrlbean", bean);
	}

	public Map<String, Object> getSession() {
		FacesContext fc = FacesContext.getCurrentInstance();
		return fc.getExternalContext().getSessionMap();
	}

	public ControlBean getCtrlBean() {
		return (ControlBean) getSession().get("ctrlbean");
	}

	public void putCtrlBean(ControlBean bean) {
		getSession().put("ctrlbean", bean);
	}

	CRUDHandler handler = new CRUDHandler();

	public String trig_pre_query_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		String query = " SELECT PC_SCHD_PYMT_DT,PC_PAID_DT,PC_FC_AVLB_BAL_AMT,PC_FC_PAID_AMT,PC_LC_PAID_AMT,PC_PAID_FLAG,PC_REF_NO,PC_FC_BASIC_PREM,PC_LC_BASIC_PREM,PC_FC_CHARGE_AMT,PC_LC_CHARGE_AMT,PC_FC_ADDL_PREM,PC_LC_ADDL_PREM,PC_FC_CHARGE,PC_LC_CHARGE,PC_FC_LOAD_AMT,PC_LC_LOAD_AMT,PC_FC_DISCOUNT,PC_LC_DISCOUNT,PC_FC_GROSS_PREM,PC_LC_GROSS_PREM,PC_FC_UNPAID_PREM_INT,PC_LC_UNPAID_PREM_INT,PC_LC_AVLB_BAL_AMT FROM PT_IL_PREM_COLL";
		DUMMY1_ACTION dummyBean = (DUMMY1_ACTION) actionBean
				.getDUMMY1_ACTION_BEAN();
		String where = null;
		// Before Approval
		if ("N".equals(MigratingFunctions.nvl(CommonUtils
				.getGlobalVariable("GLOBAL.M_SUCC"), "N"))) {

			if (dummyBean.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue() != null) {
				where = "PC_EMPLOYER_CODE = '"
						+ dummyBean.getCOMP_UI_M_EMPLOYER_CODE()
								.getSubmittedValue()
						+ "' AND PC_PAID_FLAG != 'A'";
			} else {
				where = "PC_CONT_CODE = '"
						+ dummyBean.getCOMP_UI_M_CONTRACTOR_CODE()
								.getSubmittedValue()
						+ "' AND PC_PAID_FLAG !='A' AND PC_SCHD_PYMT_DT BETWEEN='"
						+ dummyBean.getCOMP_UI_M_DUE_PERIOD_FM()
								.getSubmittedValue()
						+ "' AND '"
						+ dummyBean.getCOMP_UI_M_DUE_PERIOD_TO()
								.getSubmittedValue() + "'";
			}
		}// After Approval
		else if (dummyBean.getCOMP_UI_M_EMPLOYER_CODE().getSubmittedValue() != null) {
			where = "PC_EMPLOYER_CODE = '"
					+ dummyBean.getCOMP_UI_M_EMPLOYER_CODE()
							.getSubmittedValue() + "' AND PC_PAID_FLAG != 'A'";
		} else {
			where = "PC_CONT_CODE = '"
					+ dummyBean.getCOMP_UI_M_CONTRACTOR_CODE()
							.getSubmittedValue()
					+ "' AND PC_PAID_FLAG !='A' AND PC_SCHD_PYMT_DT BETWEEN='"
					+ dummyBean.getCOMP_UI_M_DUE_PERIOD_FM()
							.getSubmittedValue()
					+ "' AND '"
					+ dummyBean.getCOMP_UI_M_DUE_PERIOD_TO()
							.getSubmittedValue() + "'";
		}
		query = query + " " + where;
		System.out.println("Formed Query is ............." + query);

		return "query";
	}

	// PRE_DELETE TRIGGER
	public void trig_pre_delete_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		String del_qry = "DELETE FROM PT_IL_LOAN_INT_COLL WHERE LIC_PC_SYS_ID='"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_SYS_ID() + "'";
		try {
			handler
					.executeDeleteStatement(del_qry, CommonUtils
							.getConnection());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	// WHEN CREATE INSTANCE
	public void trig_when_create_record_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getCOMP_PC_PAID_DT()
				.setSubmittedValue(
						actionBean.getDUMMY1_ACTION_BEAN()
								.getCOMP_UI_M_PAID_DT().getSubmittedValue());

	}

	// WHEN_NEW_BLOCK_INSTANCE
	public void trig_when_new_block_instance_pt_it_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		/*
		 * IF :SYSTEM.FORM_STATUS = 'CHANGED' THEN :SYSTEM.MESSAGE_LEVEL :=
		 * '10'; :CTRL.M_COMM_DEL := 'P'; POST; :CTRL.M_COMM_DEL := NULL;
		 * :PT_IL_PREM_COLL.M_POL_CUST_CURR_CODE :=
		 * :PT_IL_PREM_COLL.M_POL_CUST_CURR_CODE ; :SYSTEM.MESSAGE_LEVEL := 0;
		 * END IF;
		 */

		getCtrlBean().setM_COMM_DEL("P");
		// POST
		getCtrlBean().setM_COMM_DEL(null);
		String POL_CUST_CURR_CODE = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getPT_IL_PREM_COLL_BEAN().getUI_M_POL_CUST_CURR_CODE();
		actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getCOMP_UI_M_POL_CUST_CURR_CODE().setSubmittedValue(
						POL_CUST_CURR_CODE);

	}

	// ON_POPULATE_DETAILS
	public void trig_on_populate_details_pt_il_prem_comm() {
		// has to be implemented
		System.out.println("Has to be implemented");
	}

	// POST_QUERY
	public void trig_post_query_pt_il_prem_coll()throws Exception {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);

		String C1 = "SELECT POL_CUST_CURR_CODE, POL_CUST_EXCH_RATE, POL_NO FROM   PT_IL_POLICY WHERE  POL_SYS_ID = '"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_POL_SYS_ID() + "'";
		String M_IL_RND_TYPE = null;
		String C2 = "SELECT  PS_VALUE FROM PP_SYSTEM WHERE PS_TYPE = 'IL_RND_TYPE'";
		helperL_LOAN_APPBL();
		

	}

	// WHEN_NEW_RECORD_INSTANCE
	public void trig_when_new_record_instance_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		Double M_PC_SYS_ID;
		String M_PC_PAID_FLAG;
		String M_DUMMY;
		Date M_PC_SCHD_PYMT_DT;
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs = null;
		String C1 = "SELECT MAX(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID ='"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_POL_SYS_ID()
				+ "' AND  PC_SCHD_PYMT_DT < '"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_SCHD_PYMT_DT() + "'";
		String C2 = "SELECT MAX(PC_SCHD_PYMT_DT) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID ='"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_POL_SYS_ID()
				+ "' AND  PC_SCHD_PYMT_DT > '"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_SCHD_PYMT_DT() + "'";
		String C3 = "SELECT NVL(PC_PAID_FLAG,'N') FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = '"
				+ actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
						.getPT_IL_PREM_COLL_BEAN().getPC_POL_SYS_ID()
				+ "' AND PC_SCHD_PYMT_DT = 'M_PC_SCHD_PYMT_DT'";

		if (actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
				.getPT_IL_PREM_COLL_BEAN().getPC_PREM_TYPE() != "A") {
			try {
				rs = handler.executeSelectStatement(C1, CommonUtils
						.getConnection());
				if (rs.next()) {
					M_PC_SCHD_PYMT_DT = rs.getDate("PC_SCHD_PYMT_DT");
				}
				rs.close();

				rs = handler.executeSelectStatement(C3, CommonUtils
						.getConnection());
				if (rs.next()) {
					M_PC_PAID_FLAG = rs.getString("PC_PAID_FLAG");
				}
				rs.close();
				if (MigratingFunctions.nvl("M_PC_PAID_FLAG", "N") == "N") {
					rs = handler.executeSelectStatement(C2, CommonUtils
							.getConnection());
					if (rs.next()) {
						rs = handler.executeSelectStatement(C2, CommonUtils
								.getConnection());
						M_PC_SCHD_PYMT_DT = rs.getDate("PC_SCHD_PYMT_DT");
					}
					rs.close();

					rs = handler.executeSelectStatement(C3, CommonUtils
							.getConnection());
					if (rs.next()) {
						M_PC_PAID_FLAG = rs.getString("PC_PAID_FLAG");
					} else {
						M_PC_PAID_FLAG = "N";
					}
					rs.close();
				}// end if
				if (MigratingFunctions.nvl("M_PC_PAID_FLAG", "N") == "N") {
					String PC_PAID_FLAG = actionBean
							.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getPT_IL_PREM_COLL_BEAN().getPC_PAID_FLAG();
					if (MigratingFunctions.nvl("PC_PAID_FLAG", "N") == "A") {
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_PAID_DT().setDisabled(true);
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_PAID_FLAG().setDisabled(true);
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(
										true);
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(
										true);
					} else {
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_PAID_DT().setDisabled(false);
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_PAID_FLAG().setDisabled(false);
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_LC_PAID_AMT().setDisabled(false);
						actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
								.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(
										false);
					}// END

				} else {
					actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_PAID_DT().setDisabled(true);
					actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_PAID_FLAG().setDisabled(true);
					actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_FC_UNPAID_PREM_INT().setDisabled(true);
					actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_LC_UNPAID_PREM_INT().setDisabled(true);
					actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_FC_PAID_AMT().setDisabled(true);
					actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
							.getCOMP_PC_LC_PAID_AMT().setDisabled(true);
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}// first if
		/*
		 * IF NVL(:PT_IL_POLICY.POL_STATUS,'N') NOT IN ('P','C') THEN
		 * SET_ITEM_PROPERTY('M_BUT_REINSTATE', ENABLED, PROPERTY_FALSE); IF
		 * NVL(:PT_IL_PREM_COLL.PC_PAID_FLAG,'N') = 'A' THEN
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE', ENABLED, PROPERTY_FALSE);
		 * ELSE SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE', ENABLED,
		 * PROPERTY_TRUE); END IF; ELSE SET_ITEM_PROPERTY('DUMMY.M_BUT_APPROVE',
		 * ENABLED, PROPERTY_FALSE); SET_ITEM_PROPERTY('M_BUT_REINSTATE',
		 * ENABLED, PROPERTY_TRUE); END IF; -- Commented on 14/01/01 IF
		 * :PT_IL_PREM_COLL.PC_PREM_TYPE IN ('N', 'R') AND
		 * NVL(:PT_IL_PREM_COLL.PC_FAC_CLOSE_FLAG,'N') = 'N' AND
		 * NVL(:PT_IL_POLICY.POL_FAC_YN,'N') = 'Y' THEN
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_FAC', ENABLED, PROPERTY_TRUE); ELSE
		 * SET_ITEM_PROPERTY('DUMMY.M_BUT_FAC', ENABLED, PROPERTY_FALSE); END
		 * IF;
		 * 
		 * IF NVL(:PT_IL_PREM_COLL.M_FC_LOAN_INT ,0) !=
		 * :PT_IL_LOAN_INT_COLL.LIC_FC_INT_AMT THEN
		 * :PT_IL_PREM_COLL.M_FC_LOAN_INT :=
		 * :PT_IL_LOAN_INT_COLL.LIC_FC_INT_AMT; END IF;
		 */
	}
	
	// end of trigger

	public void trig_pre_update_pt_il_prem_coll() {
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		/*
		 * L_VAL_REF_NO; :PT_IL_PREM_COLL.PC_UPD_DT := SYSDATE;
		 * :PT_IL_PREM_COLL.PC_UPD_UID := :CTRL.M_USER_ID;
		 */
		try {
			Date sys_date = utility.getCurrentDate();

			// actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN().setPC_UPD_DT(sys_date);
			actionBean.getPT_IL_PREM_COLL_ACTION_BEAN()
					.getPT_IL_PREM_COLL_BEAN().setPC_UPD_UID(
							getCtrlBean().getM_USER_ID());
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	//Written by Shasi Sekar
	
	public void trig_pre_record_pt_il_prem_coll()throws Exception {
	
		String mappedBeanName = "PILT020_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		PILT020_COMPOSITE_ACTION actionBean = (PILT020_COMPOSITE_ACTION) utility
				.getMappedBeanFromSession(mappedBeanName);
		PT_IL_PREM_COLL premBean = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String M_PC_SYS_ID =null ;
		String M_PC_PAID_FLAG=null;
		
		ResultSet rs = null;
	
	String C1 ="SELECT MAX(PC_SYS_ID) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = '"+premBean.getPC_POL_SYS_ID()+"' AND  PC_SYS_ID  < '"+premBean.getPC_SYS_ID()+"' " ;
	String C2 ="SELECT MIN(PC_SYS_ID) FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = '"+premBean.getPC_POL_SYS_ID()+"' AND    PC_SYS_ID     > '"+premBean.getPC_SYS_ID()+"'";
	String C3 ="SELECT NVL(PC_PAID_FLAG,'N') FROM   PT_IL_PREM_COLL WHERE  PC_SYS_ID = '"+M_PC_SYS_ID+"'"; 
	
	rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
	
	while(rs.next()){
		M_PC_SYS_ID = rs.getString(1);
	}
	rs.close();
	
	rs = handler.executeSelectStatement(C3, CommonUtils.getConnection()); 
	   
	while(rs.next()){
		M_PC_PAID_FLAG = rs.getString(1);
	
	}
	rs.close();
	
	if(M_PC_PAID_FLAG != "N"){
		rs = handler.executeSelectStatement(C2, CommonUtils.getConnection());
		
		while(rs.next()){
			M_PC_SYS_ID = rs.getString(1);
		}
		rs.close();
		
		rs = handler.executeSelectStatement(C3, CommonUtils.getConnection()); 
		   
		while(rs.next()){
			M_PC_PAID_FLAG = rs.getString(1);
		
		}
		rs.close();
		
		if(M_PC_PAID_FLAG =="N"){		
			//  Comment Found in D2K--  Previous record is paid and next record is not paid, so updateable
		
			/* IF :PT_IL_PREM_COLL.PC_PAID_FLAG = 'A' THEN
	          SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_DT'  , UPDATEABLE, PROPERTY_FALSE);
	          SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_FLAG', UPDATEABLE, PROPERTY_FALSE);
	       ELSE
	          SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_DT'  , UPDATEABLE, PROPERTY_TRUE);
	          SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_FLAG', UPDATEABLE, PROPERTY_TRUE);
	       END IF;*/
		
		}else{
			//--  Previous record is paid and next record is also paid, so cannot update the current record;		
		       /*SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_DT'  , UPDATEABLE, PROPERTY_FALSE);
		       SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_FLAG', UPDATEABLE, PROPERTY_FALSE);*/
		}
	
	}else{
		 // -- Previous record is not paid, so current record is not updateable
		   /* SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_DT'  , UPDATEABLE, PROPERTY_FALSE);
		    SET_ITEM_PROPERTY ('PT_IL_PREM_COLL.PC_PAID_FLAG', UPDATEABLE, PROPERTY_FALSE);*/
	}
	rs.close();
	}
	
	public void when_Validate_Record(){
		
		/*IF :SYSTEM.MODE != 'QUERY' THEN
		   IF (:PT_IL_PREM_COLL.PC_PAID_DT IS NOT NULL AND
		         :PT_IL_PREM_COLL.PC_PAID_FLAG = 'N') OR
		         (:PT_IL_PREM_COLL.PC_PAID_DT IS NULL AND 
		         :PT_IL_PREM_COLL.PC_PAID_FLAG != 'N') THEN
		     STD_MESSAGE_ROUTINE (71124, :CTRL.M_LANG_CODE);
		     RAISE FORM_TRIGGER_FAILURE;
		   END IF;
		END IF;*/
	}
	
	
	public void oncheck_Delete_Master(){
		
		ResultSet rs = null;
		
		String Dummy_Define;
		
		String PT_IL_PREM_COLL_CHARGE_cur ="SELECT 1 FROM PT_IL_PREM_COLL_CHARGE P WHERE P.PCC_PC_SYS_ID = :PT_IL_PREM_COLL.PC_SYS_ID";
		
		try{
			rs = handler.executeSelectStatement(PT_IL_PREM_COLL_CHARGE_cur, CommonUtils.getConnection());
		
			while(rs.next()){
				Dummy_Define = rs.getString(1);
			 
			}
		
			if ( rs.getFetchSize()<=0){      
				//Message('Cannot delete master record when matching detail records exist.');
			}
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
}
	
	
	
	//Shasi Sekar Ends Here

	/*public Date getSystemDate() {
		CRUDHandler handler = new CRUDHandler();
		java.sql.Date sysDate = null;
		ResultSet resultSet = null;
		try {
			Connection connection = CommonUtils.getConnection();
			String query = "SELECT TO_DATE(SYSDATE,'DD/MM/RR') FROM DUAL";
			resultSet = handler.executeSelectStatement(query, connection);
			while (resultSet.next()) {
				System.out.println("Result is " + resultSet.getDate(1));
				sysDate = resultSet.getDate(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("The SYS Date == " + sysDate);
		return sysDate;
	}*/

	// /////////////////////////////////////////////item level
	// triggers///////////////////////////////////////////

	public void trig_item_pc_lc_basic_prem()
	{
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler= new CRUDHandler();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY bean  =actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN(); 
		PT_IL_PREM_COLL bean_prem = actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT 'X' FROM   PT_IL_PREM_COLL WHERE  PC_POL_SYS_ID = '"+bean.getPOL_SYS_ID()+" AND PC_PAID_DT > '"+bean_prem.getPC_PAID_DT()+"' AND PC_SYS_ID = '"+bean_prem.getPC_SYS_ID()+"'";
		
		String M_DUMMY = null;
		ResultSet rs = null;
		if(bean_prem.getPC_PAID_DT()!= null){
			try{
				rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
				if(rs.next()){
					M_DUMMY = rs.getNString("X");
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "71075");
					Map<String, String> errMap = getErrorMap(); 
					errMap.put("current",message);
					errMap.put("someKey",message);
				}
				/*if(bean_prem.getPC_PAID_DT() > ){
					
				}*/
			}catch (Exception e) {
				e.printStackTrace();
			}			
		}
	
	}
	//L_LOAN_APPBL
	public void helperL_LOAN_APPBL()throws Exception{
		int M_LOAN_SYS_ID;
		double M_LC_LOAN_INT_AMT=0.0;
		double M_FC_LOAN_INT_AMT=0.0;
		ResultSet rs = null;
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler= new CRUDHandler();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY policyBean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL premBean =actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT LOAN_SYS_ID FROM   PT_IL_LOAN  WHERE  LOAN_POL_SYS_ID  ='"+policyBean.getPOL_SYS_ID()+"'";
		String C2 = " SELECT LIC_LC_INT_AMT,LIC_FC_INT_AMT FROM   PT_IL_LOAN_INT_COLL WHERE  LIC_PC_SYS_ID = '"+premBean.getPC_SYS_ID()+"'";
		
		rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		while(rs.next()){
			M_LOAN_SYS_ID = rs.getInt("LOAN_SYS_ID");
		}
		rs.close();
		rs = handler.executeSelectStatement(C2, CommonUtils.getConnection());
		while(rs.next()){
			premBean.setUI_M_LC_LOAN_INT(rs.getDouble("LIC_LC_INT_AMT"));
			premBean.setUI_M_FC_LOAN_INT(rs.getDouble("LIC_FC_INT_AMT"));
			
		}
		rs.close();
	}
//L_BROK_APPBL
	public void helperL_BROK_APPBL()throws Exception{
		int M_POL_SYS_ID;
		ResultSet rs = null;
		String mappedBeanName="PILT020_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler= new CRUDHandler();
		PILT020_COMPOSITE_ACTION actionBean=(PILT020_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PT_IL_POLICY policyBean = actionBean.getPT_IL_POLICY_ACTION_BEAN().getPT_IL_POLICY_BEAN();
		PT_IL_PREM_COLL premBean =actionBean.getPT_IL_PREM_COLL_ACTION_BEAN().getPT_IL_PREM_COLL_BEAN();
		String C1 = "SELECT BV_POL_SYS_ID FROM PT_IL_BROKER_VALUES WHERE  BV_POL_SYS_ID ='"+policyBean.getPOL_SYS_ID()+"' AND BV_PC_SYS_ID='"+premBean.getPC_SYS_ID()+"'";
		rs = handler.executeSelectStatement(C1, CommonUtils.getConnection());
		while(rs.next()){
			M_POL_SYS_ID = rs.getInt("BV_POL_SYS_ID");
		}
		
	}
}
