package com.iii.pel.forms.PILM002_APAC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_APPL_WOP_COVER_HELPER {
	
	/**
	 * This trigger is fired just before inserting a record. It is used to set 
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
	public void preInsert(){
		System.out.println("*******In PRE-INSERT trigger************");
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_APPL_WOP_COVER_ACTION actionBean=compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN();
		
		//get current index of the table and fetching the record to be inserted
		int currentIndex=actionBean.getCOMP_PM_IL_APPL_WOP_COVER_TABLE().getRowIndex();
		List recordList=actionBean.getRecordList();
		PM_IL_APPL_WOP_COVER recordListValueBean=
			(PM_IL_APPL_WOP_COVER)recordList.get(currentIndex);
		try {
			recordListValueBean.setAWCVR_CR_DT(utility.getCurrentDate());
			recordListValueBean.setAWCVR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-INSERT trigger ends************");
	}
	
	public void preInsert(PM_IL_APPL_WOP_COVER PM_IL_APPL_WOP_COVER_BEAN) throws Exception{
		try {
			PM_IL_APPL_WOP_COVER_BEAN.setAWCVR_CR_DT(new CommonUtils().getCurrentDate());
			PM_IL_APPL_WOP_COVER_BEAN.setAWCVR_CR_UID(CommonUtils.getControlBean().getM_USER_ID());
			pilp0002_apac_l_val_cover_unique(PM_IL_APPL_WOP_COVER_BEAN.getAWCVR_COVER_CODE());
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
	public void preUpdate(){
		System.out.println("*******In PRE-UPDATE trigger************");
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_APPL_WOP_COVER_ACTION actionBean=compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN();
		
		//get current index of the table and fetching the record to be inserted
		int currentIndex=actionBean.getCOMP_PM_IL_APPL_WOP_COVER_TABLE().getRowIndex();
		List recordList=actionBean.getRecordList();
		PM_IL_APPL_WOP_COVER recordListValueBean=
			(PM_IL_APPL_WOP_COVER)recordList.get(currentIndex);
		try {
			recordListValueBean.setAWCVR_UPD_DT(utility.getCurrentDate());
			
			recordListValueBean.setAWCVR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-UPDATE trigger ends************");
	}
	
	
	public void preUpdate(PM_IL_APPL_WOP_COVER PM_IL_APPL_WOP_COVER_BEAN){
		System.out.println("*******In PRE-UPDATE trigger************");
		try {
			PM_IL_APPL_WOP_COVER_BEAN.setAWCVR_UPD_DT(new CommonUtils().getCurrentDate());
			PM_IL_APPL_WOP_COVER_BEAN.setAWCVR_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println("*******In PRE-UPDATE trigger ends************");
	}

	/**
	 * This trigger is fired when the PM_IL_APPL_WOP_COVER jsp is loaded.It will be called 
	 * before WHEN-NEW-RECORD-INSTANCE trigger.Method will make the block PM_IL_APPL_WOP_COVER
	 * insert/update/delete enabled or disabled based on value in COVER_CLASS
	 * @param event
	 * @return
	 * @throws 
	 */
	public void whenNewBlockInstanceForPM_IL_APPL_WOP_COVER(){
		System.out.println("********In whenNewBlockInstance trigger************");
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility=new CommonUtils();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_APPL_WOP_COVER_ACTION actionBean=compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN();
		
		if("WS".contains(compositeActionBean.getPM_IL_COVER_ACTION_BEAN().
				getPM_IL_COVER_BEAN().getCOVER_CLASS())){
			//setting the flgas which will allow/block CRUD on a block
			actionBean.setINSERT_ALLOWED(true);
			actionBean.setUPDATE_ALLOWED(true);
			actionBean.setDELETE_ALLOWED(true);
		}else{
			
			actionBean.setINSERT_ALLOWED(false);
			actionBean.setUPDATE_ALLOWED(false);
			actionBean.setDELETE_ALLOWED(false);
		}
		
		System.out.println("********whenNewBlockInstance trigger end************");
	}
	
	/**
	 * This trigger is fired for validating AWCVR_COVER_CODE field.
	 * 
	 * @param UIComponent component
	 * @param Object value
	 * @return
	 * @throws Exception 
	 */
	public void whenValidateItemAWCVR_COVER_CODE(UIComponent component,
			Object value) throws Exception {
		System.out.println("********Validating AWCVR_COVER_CODE************");
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		String selectQuery=PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_COVER_BY_COVER_CODE_AND_COVER_CLASS;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		Object [] queryValues=new Object[2];
		ResultSet resultSet=null;
		//get current index of the table and fetching the current record 
//		int currentIndex=actionBean.getCOMP_PM_IL_APPL_WOP_COVER_TABLE().getRowIndex();
//		List recordList=actionBean.getRecordList();
//		System.out
//				.println("PM_IL_APPL_WOP_COVER_HELPER.whenValidateItemAWCVR_COVER_CODE-----[currentIndex]"+currentIndex);
//		PM_IL_APPL_WOP_COVER recordListValueBean=
//			(PM_IL_APPL_WOP_COVER)recordList.get(currentIndex);
		
		queryValues[0]=value;
		queryValues[1]=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CLASS();
		String awcvrCoverCode=(String)value;
		String coverCode=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
		if(coverCode.equals(awcvrCoverCode)){
			String message=Messages.getString(PELConstants.pelErrorMessagePath, "3206");
			throw new Exception(message+"Same Cover Should not be added...");
		}
		try {
			resultSet=handler.executeSelectStatement(selectQuery,utility.getConnection(), queryValues);
			if(resultSet != null && resultSet.next()){
				String message=Messages.getString(PELConstants.pelErrorMessagePath, "91408");
				throw new Exception(message);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally{
			try {
				//resultSet.close();
				//resultSet=null;
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		pilp0002_apac_l_val_cover_unique((String)value);
		System.out.println("********Validating AWCVR_COVER_CODE ends************");
	}
	
	/**
	 * This trigger is fired after querying the details for PM_IL_APPL_WOP_COVER
	 * It is used to set AWCVR_COVER_DESC field for the AWCVR_COVER_CODE. If there
	 * is no description is found or the COVER_FRZ_FLAG is Y for the cover code it 
	 * will throw exception
	 * 
	 * @return
	 * @throws Exception 
	 */
	public void postQueryPM_IL_APPL_WOP_COVER() throws Exception{
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		String selectQuery=PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_COVER_BY_COVER_TYPE;
		CommonUtils utility=new CommonUtils();
		CRUDHandler handler=new CRUDHandler();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_APPL_WOP_COVER_ACTION actionBean=compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN();
		List recordList=actionBean.getRecordList();
		int iCount=0;
		ResultSet resultSet=null;
		Map <String,PM_IL_COVER> codeDescriptionMap=new HashMap<String,PM_IL_COVER>();
		try {
			resultSet=handler.executeSelectStatement(selectQuery, utility.getConnection());
			if(resultSet != null){
				while(resultSet.next()){
					PM_IL_COVER bean=new PM_IL_COVER();
					bean.setCOVER_FRZ_FLAG(resultSet.getString("COVER_FRZ_FLAG"));
					bean.setCOVER_DESC(resultSet.getString("COVER_DESC"));
					bean.setCOVER_LONG_DESC(resultSet.getString("COVER_LONG_DESC"));
					bean.setCOVER_CODE(resultSet.getString("COVER_CODE"));
					String key=resultSet.getString("COVER_CODE");
					codeDescriptionMap.put(key,bean);
				}
				if(recordList != null){
					while(iCount < recordList.size()){
						String coverCode=((PM_IL_APPL_WOP_COVER)recordList.get(iCount)).getAWCVR_COVER_CODE();
						if(codeDescriptionMap.get(coverCode)== null){
							String message=Messages.getString(PELConstants.pelErrorMessagePath, "71006");
							throw new Exception(message);
						}else{
							String coverFreezeflag=((PM_IL_COVER)codeDescriptionMap.get(coverCode)).getCOVER_FRZ_FLAG();
							if("Y".equals(coverFreezeflag)){
								String message=Messages.getString(PELConstants.pelErrorMessagePath, "71007");
								throw new Exception(message);
							}else{
								((PM_IL_APPL_WOP_COVER)recordList.get(iCount)).setUI_M_AWCVR_COVER_DESC
									(((PM_IL_COVER)codeDescriptionMap.get(coverCode)).getCOVER_DESC());
							}
							iCount++;
						}
					}
				}	
			}				
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				//resultSet.close();
				//resultSet=null;
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}


	public void pilp0002_apac_l_val_cover_unique(String value) throws Exception
	{
		String mappedBeanName="PILM002_APAC_COMPOSITE_ACTION";
		CommonUtils utility = new CommonUtils();
		CRUDHandler handler = new CRUDHandler();
		PILM002_APAC_COMPOSITE_ACTION compositeActionBean=
			(PILM002_APAC_COMPOSITE_ACTION)utility.getMappedBeanFromSession(mappedBeanName);
		PM_IL_APPL_WOP_COVER_ACTION actionBean=compositeActionBean.getPM_IL_APPL_WOP_COVER_ACTION_BEAN();
		ResultSet rs=null;
		//get current index of the table and fetching the record
		//int currentIndex=actionBean.getCOMP_PM_IL_APPL_WOP_COVER_TABLE().getRowIndex();
		//List recordList=actionBean.getRecordList();
//		System.out.println("Fetcing current record to validate[current index]----->"+ currentIndex);
		/*
		PM_IL_APPL_WOP_COVER recordListValueBean=
			(PM_IL_APPL_WOP_COVER)recordList.get(currentIndex);
	*/
		
		PM_IL_APPL_WOP_COVER recordListValueBean=(PM_IL_APPL_WOP_COVER)actionBean.getPM_IL_APPL_WOP_COVER_BEAN();
		String C1 =PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_APPL_WOP_COVER_BY_AWCVR_CODE_AWCVR_COVER_CODE;
		Object[] C1values=new Object[2];
		C1values[0]=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
		C1values[1]=value;
		String C2 =PILM002_APAC_SQLQUERY_CONSTANTS.SELECT_PM_IL_APPL_WOP_COVER_BY_AWCVR_CODE_AWCVR_COVER_CODE_ROW_ID;
		Object[] C2values=new Object[3];
		C2values[0]=compositeActionBean.getPM_IL_COVER_ACTION_BEAN().getPM_IL_COVER_BEAN().getCOVER_CODE();
		C2values[1]=value;
		C2values[2]= recordListValueBean.getROWID();
		try {
			if(recordListValueBean.getROWID() == null){
				rs = handler.executeSelectStatement(C1, utility.getConnection(),C1values);
				if(rs.next()){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "91407");
					throw new Exception(message);
				}
			}else{
				rs = handler.executeSelectStatement(C2, utility.getConnection(),C2values);
				if(rs.next()){
					String message=Messages.getString(PELConstants.pelErrorMessagePath, "91407");
					System.out.println("ERROR MSG::::::::::::::"+message);
					throw new Exception(message);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			e.printStackTrace();
		}finally{
			try {
				//resultSet.close();
				//resultSet=null;
				CommonUtils.closeCursor(rs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

