package com.iii.pel.forms.PILM002_APAC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.faces.component.UIComponent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_CVR_WAITING_PRD_HELPER {

	/**
	 * This trigger is fired just before inserting a record. It is used to set 
	 * some values in the bean to be inserted before inserting the record. Method
	 * will get the current row index of the data table component which will give
	 * the index of the record to be inserted. Using the index the record to be
	 * inserted is retrieved from the record List. The method will then set the
	 * CWP_CR_DT and CWP_CR_UID fields 
	 * 
	 * @param event
	 * @return
	 * @throws 
	 */
	public void preInsert(PM_IL_CVR_WAITING_PRD PM_IL_CVR_WAITING_PRD_BEAN){
		System.out.println("*******In PRE-INSERT trigger************");
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();
		
		//get current index of the table and fetching the record to be inserted
		//int currentIndex=actionBean.getCOMP_PM_IL_CVR_WAITING_PRD_TABLE().getRowIndex();
		//List recordList=actionBean.getRecordList();
		
		PM_IL_CVR_WAITING_PRD recordListValueBean=PM_IL_CVR_WAITING_PRD_BEAN;
		try {
			recordListValueBean.setCWP_CR_DT(utility.getCurrentDate());
			recordListValueBean.setCWP_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-INSERT trigger ends************");
	}
	
	/**
	 * This trigger is fired just before updating a record. It is used to set 
	 * some values in the bean to be inserted before inserting the record. Method
	 * will get the current row index of the data table component which will give
	 * the index of the record to be inserted. Using the index the record to be
	 * inserted is retrieved from the record List. The method will then set the
	 * AWCVR_CR_DT and AWCVR_CR_UID fields 
	 * 
	 * @param event
	 * @return
	 * @throws 
	 */
	public void preUpdate(PM_IL_CVR_WAITING_PRD PM_IL_CVR_WAITING_PRD_BEAN){
		System.out.println("*******In PRE-UPDATE trigger************");
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();
		
		//get current index of the table and fetching the record to be inserted
		//int currentIndex=actionBean.getCOMP_PM_IL_CVR_WAITING_PRD_TABLE().getRowIndex();
		List recordList=actionBean.getRecordList();
		PM_IL_CVR_WAITING_PRD recordListValueBean=PM_IL_CVR_WAITING_PRD_BEAN;
		try {
			recordListValueBean.setCWP_UPD_DT(utility.getCurrentDate());
			recordListValueBean.setCWP_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-UPDATE trigger ends************");
	}
	
	public void whenValidateItemCWP_ILLNESS_TYP(UIComponent component,
			Object value) throws Exception{
		System.out.println("*******validating CWP_ILLNESS_TYP************");
		CommonUtils utility = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		ResultSet rs=null;
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();
		String CWP_ILLNESS_TYP=null;
		String ILLNESS_TYP =(String)value;
	    System.out.println("The selected Code is>>>>>>>>>>>>"+ILLNESS_TYP);
		String C1 = PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_CODES_BY_PC_TYPE_PC_CODE;
		Object [] C1values={ILLNESS_TYP};
		System.out.println("The Select Query for Cursor>>>>>>>"+C1);
		try{
			rs=handler.executeSelectStatement(C1, utility.getConnection(),C1values);
			if(rs.next()) {
				CWP_ILLNESS_TYP	 = rs.getString("PC_CODE");
				System.out.println("THe Value of CWP_ILLNESS_TYP inside------"+CWP_ILLNESS_TYP);
			}else{
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "91998");
				throw new Exception(message);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			try {
				CommonUtils.closeCursor(rs);
//				result.close();
//				result=null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			System.out.println("*******validating CWP_ILLNESS_TYP end************");	
	}

	public void whenValidateItemCWP_WAITING_PRD(UIComponent component,
			Object value) throws Exception
	{
		System.out.println("*******validating CWP_WAITING_PRD************");
		CommonUtils utility = new CommonUtils();
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_CVR_WAITING_PRD_ACTION actionBean=compositeActionBean.getPM_IL_CVR_WAITING_PRD_ACTION_BEAN();
		Double waitingPeriod=(Double)value;
		if(waitingPeriod!=null)
		{
			System.out.println("CWP_WAITING_PRD Value is ----------------->"+waitingPeriod);
			if(waitingPeriod < 0 || waitingPeriod > 999)
			{
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "91997");
				throw new Exception(message);
			}
		}
		System.out.println("*******validating CWP_WAITING_PRD end************");
	}

}
