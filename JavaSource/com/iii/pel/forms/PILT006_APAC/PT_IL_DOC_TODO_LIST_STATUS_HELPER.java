package com.iii.pel.forms.PILT006_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;


public class PT_IL_DOC_TODO_LIST_STATUS_HELPER {
	
	private static final Log log = LogFactory.getLog(PT_IL_DOC_TODO_LIST_STATUS_HELPER.class);
	
	/**
	 * 
	 * @param PT_IL_DOC_TODO_LIST_STATUS_BEAN
	 */
	/* Modified by saranya for Avoidance of POST button required in all screens on 22-02-2017 */	
	public void preInsert(PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception{
		String C1 = "SELECT PIL_DTLS_SYS_ID.NEXTVAL FROM   DUAL";
		
		CTRL CTRL_BEAN =compositeAction.getCTRL_ACTION_BEAN().getCTRL_BEAN();
		PT_IL_CLAIM CLAMBEAN=compositeAction.getPT_IL_CLAIM_ACTION_BEAN().getPT_IL_CLAIM_BEAN();
		PM_IL_DOC_TODO_GROUP groupBean = compositeAction.getPM_IL_DOC_TODO_GROUP_ACTION_BEAN().getPM_IL_DOC_TODO_GROUP_BEAN();
	ResultSet C1_REC = null;
	try{
		CRUDHandler handler = new CRUDHandler();
		Connection con = CommonUtils.getConnection();
		PILT006_APAC_PROCEDURE pilt006_apac_procedure =new PILT006_APAC_PROCEDURE();
		pilt006_apac_procedure.IL_UNIQUE_TODOLIST_SRNO(PT_IL_DOC_TODO_LIST_STATUS_BEAN);//Procedure call

		C1_REC = handler.executeSelectStatement(C1, con);
		if(C1_REC.next()){
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_SYS_ID(C1_REC.getLong(1));
		}
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CLM_SYS_ID(CLAMBEAN.getCLAIM_SYS_ID());
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_POL_SYS_ID(CLAMBEAN.getCLAIM_POL_SYS_ID());
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_GROUP_CODE(groupBean.getDTG_GROUP_CODE());
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_DT(new CommonUtils().getCurrentDate());
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_CR_UID(CTRL_BEAN.getUI_M_USER_ID());
		
		/*Added by Ameen on 26-07-2017 for ZBILQC-1732254*/
		List<PT_IL_DOC_TODO_LIST_STATUS> dataListing = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getDataList_PT_IL_DOC_TODO_LIST_STATUS();
		System.out.println("dataListing :: size ::" + dataListing.size());
		if(dataListing.size() > 0){
		for(int i = 0 ; i < dataListing.size() ; i++ ){
			if(!dataListing.get(i).equals(PT_IL_DOC_TODO_LIST_STATUS_BEAN)){
				if(dataListing.get(i).getDTLS_SR_NO() == PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SR_NO()){
					throw new Exception("Serial No. Duplicated");
					}
				}
			}
		}
		/*End*/
	
	}catch(Exception exception){
		log.debug("Exception"+exception.getMessage());
		throw new Exception(exception.getMessage());
	}finally{
		CommonUtils.closeCursor(C1_REC);
	}
	}
	/*End*/

	public void postInsert() {
	}

/*
 *  Commented by Janani on 19/05/2017 for hands-on-feedback point(checklist) 
 * 
 * 
 * 	public void preUpdate(PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN,CTRL CTRL_BEAN) throws java.text.ParseException {
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_DT(new CommonUtils().getCurrentDate());
		PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_UPD_UID(CTRL_BEAN.getUI_M_USER_ID());
	}*/
	
	/**
	 * 
	 * @param CTRL_BEAN
	 * @param FORM_FAILURE
	 */
	public void preBlock(CTRL CTRL_BEAN,String FORM_FAILURE) {
		CommonUtils.setGlobalVariable("GLOBAL.M_FAILURE", "TRUE");
		CTRL_BEAN.setUI_M_DELETE_MSG_FLAG("N");
	}

	public void whenCreateRecord() {
	}
	
	/**
	 * 
	 */
	public void preQuery(){
		//null;
	}
	/**
	 * 
	 * @param PT_IL_CLAIM_BEAN
	 * @param PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN
	 * @param CTRL_BEAN
	 * @throws Exception
	 */
	public void whenNewRecordInstance(
			PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN,CTRL CTRL_BEAN)  throws Exception{
		
		String C1 = "SELECT CS_STATUS_CODE FROM   PT_IL_CLAIM_STATUS "
				+ "WHERE  CS_SYS_ID = (SELECT MAX(CS_SYS_ID) "
				+ "FROM   PT_IL_CLAIM_STATUS " + "WHERE  CS_CLM_SYS_ID = ? )";
		String M_CS_STATUS_CODE = null;
		ResultSet C1_REC = null;
		try{
			CRUDHandler handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();
			
			/* IF :PT_IL_CLAIM.CLAIM_POL_NO IS NOT NULL THEN
			 IF :SYSTEM.FORM_STATUS = 'CHANGED' OR :SYSTEM.BLOCK_STATUS = 'CHANGED'THEN
			 	 COPY('P','CTRL.M_COMM_DEL') ;
			    COPY('20','SYSTEM.MESSAGE_LEVEL');
			    POST;                   
			    COPY('0','SYSTEM.MESSAGE_LEVEL');
			    COPY('','CTRL.M_COMM_DEL') ;
			   :PT_IL_CLAIM.CLAIM_REF_NO := :PT_IL_CLAIM.CLAIM_REF_NO;
			 END IF;
			 COPY('20','SYSTEM.MESSAGE_LEVEL');
			 EXECUTE_QUERY; 
			 COPY('0','SYSTEM.MESSAGE_LEVEL');
			  END IF;*/
			
			if(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()!=null){
				CTRL_BEAN.setUI_M_COMM_DEL("P");
			}
			
			C1_REC = handler.executeSelectStatement(C1, con,new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()});
			if(C1_REC.next()){
				M_CS_STATUS_CODE = C1_REC.getString(1);
			}
			
			if("CL05".equalsIgnoreCase(M_CS_STATUS_CODE)){
				PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.disableAllComponent(true);
			}else{
				PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.disableAllComponent(false);
			}
			
		}catch(Exception exception){
			log.debug("Exception"+exception.getMessage());
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
		
	}

	public void postQuery() {
	}

	public void preDelete() {
	}
	
	/**
	 * 
	 * @param PT_IL_DOC_TODO_LIST_STATUS_BEAN
	 */
	public void keyDelRec(PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN,CTRL CTRL_BEAN) throws Exception{
		if("Y".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_MANDATORY_YN())){
			throw new Exception(Messages.getString(
					PELConstants.pelErrorMessagePath, "3206",
					new Object[] { "Mandatory Records cannot be deleted" }));
		}
	}
	/**
	 * 
	 */
	public void whenNewBlockInstance(
			PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN,CTRL CTRL_BEAN)  throws Exception{
		
		String C1 = "SELECT CS_STATUS_CODE FROM   PT_IL_CLAIM_STATUS "
				+ "WHERE  CS_SYS_ID = (SELECT MAX(CS_SYS_ID) "
				+ "FROM   PT_IL_CLAIM_STATUS " + "WHERE  CS_CLM_SYS_ID = ? )";
		String M_CS_STATUS_CODE = null;
		ResultSet C1_REC = null;
		try{
			CRUDHandler handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();
			
			/* IF :PT_IL_CLAIM.CLAIM_POL_NO IS NOT NULL THEN
			 IF :SYSTEM.FORM_STATUS = 'CHANGED' OR :SYSTEM.BLOCK_STATUS = 'CHANGED'THEN
			 	 COPY('P','CTRL.M_COMM_DEL') ;
			    COPY('20','SYSTEM.MESSAGE_LEVEL');
			    POST;                   
			    COPY('0','SYSTEM.MESSAGE_LEVEL');
			    COPY('','CTRL.M_COMM_DEL') ;
			   :PT_IL_CLAIM.CLAIM_REF_NO := :PT_IL_CLAIM.CLAIM_REF_NO;
			 END IF;
			 COPY('20','SYSTEM.MESSAGE_LEVEL');
			 EXECUTE_QUERY; 
			 COPY('0','SYSTEM.MESSAGE_LEVEL');
			  END IF;*/
			
			if(PT_IL_CLAIM_BEAN.getCLAIM_POL_NO()!=null){
				CTRL_BEAN.setUI_M_COMM_DEL("P");
			}
			
			C1_REC = handler.executeSelectStatement(C1, con,new Object[]{PT_IL_CLAIM_BEAN.getCLAIM_SYS_ID()});
			if(C1_REC.next()){
				M_CS_STATUS_CODE = C1_REC.getString(1);
			}
			
			if("CL05".equalsIgnoreCase(M_CS_STATUS_CODE)){
				PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.disableAllComponent(true);
			}else{
				PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.disableAllComponent(false);
			}
			
		}catch(Exception exception){
			log.debug("Exception"+exception.getMessage());
			throw new Exception(exception.getMessage());
		}finally{
			CommonUtils.closeCursor(C1_REC);
		}
		
	}
	
	/**
	 * 
	 * @param compositeAction
	 * @throws Exception
	 */
	public void executeQuery(PILT006_APAC_COMPOSITE_ACTION compositeAction)
			throws Exception {
		new PT_IL_DOC_TODO_LIST_STATUS_DELEGATE()
				.executeSelectStatement(compositeAction);

		List<PT_IL_DOC_TODO_LIST_STATUS> dataList = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getDataList_PT_IL_DOC_TODO_LIST_STATUS();
		if (dataList != null && dataList.size() > 0) {
			PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN = dataList
					.get(0);
			PT_IL_DOC_TODO_LIST_STATUS_BEAN.setRowSelected(true);
			compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
					.setPT_IL_DOC_TODO_LIST_STATUS_BEAN(
							PT_IL_DOC_TODO_LIST_STATUS_BEAN);
		}
	}
	
	/**
	 * 
	 * @param PT_IL_CLAIM_BEAN
	 * @param PT_IL_DOC_TODO_LIST_STATUS_BEAN
	 * @param CTRL_BEAN
	 * @throws Exception
	 */
	public void whenValidateSR_NO(PT_IL_CLAIM PT_IL_CLAIM_BEAN,
			PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN,
			CTRL CTRL_BEAN) throws Exception {
		String C1 = "	SELECT DTL_TODO_LIST_ITEM FROM   PM_IL_DOC_TODO_LIST "
				+ "WHERE  DTL_DS_TYPE = '4' AND    DTL_DS_CODE = ? "
				+ "AND    DTL_SR_NO = ?";

		ResultSet C1_REC = null;
		PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
		try {
			CRUDHandler handler = new CRUDHandler();
			Connection con = CommonUtils.getConnection();

			C1_REC = handler.executeSelectStatement(C1, con, new Object[] {
					PT_IL_CLAIM_BEAN.getCLAIM_DS_CODE(),
					PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SR_NO() });
			if (C1_REC.next()) {
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_TODO_LIST_ITEM(C1_REC
						.getString("DTL_TODO_LIST_ITEM"));
			} else {
				PT_IL_DOC_TODO_LIST_STATUS_BEAN.setDTLS_TODO_LIST_ITEM("");
			}

			pilt006_apac_procedure
					.IL_UNIQUE_TODOLIST_SRNO(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			Long doub = PT_IL_DOC_TODO_LIST_STATUS_BEAN.getDTLS_SR_NO();
			if(doub!=null){
				if (doub.intValue() <= 0) {
					/*
					 * Changed by raja on 24-06-2017 for hands on points
					 * 
					 * throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,("91014",
							new Object[] { CTRL_BEAN.getUI_M_LANG_CODE(),
									"Serial Number", "Greater than Zero" }
									.toString()));*/
					
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"91014",
							new Object[] {"Serial Number",
							"", "Greater than Zero" }));
				}
				
			}

		} catch (Exception exception) {
			log.debug("Exception" + exception.getMessage());
			throw new Exception(exception.getMessage());
		} finally {
			CommonUtils.closeCursor(C1_REC);
		}

	}
	/**
	 * 
	 * @param PT_IL_DOC_TODO_LIST_STATUS_BEAN
	 * @throws ParseException 
	 */
	public void whenListChangedApprSTS(PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws Exception{
		if("Y".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_APPR_STS())){
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);
		}else if("N".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_APPR_STS())){
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
		}else if("NA".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_APPR_STS())){
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
		}
		
		PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
		pilt006_apac_procedure.L_VALIDATE_CHECKLIST(PT_IL_CLAIM_BEAN);
	}
	
	/**
	 * 
	 * @param PT_IL_DOC_TODO_LIST_STATUS_BEAN
	 * @throws ParseException 
	 */
	public void whenValidatorApprSTS(PT_IL_DOC_TODO_LIST_STATUS_ACTION PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN,
			PT_IL_CLAIM PT_IL_CLAIM_BEAN) throws Exception{
		if("Y".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_APPR_STS())){
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(new CommonUtils().getCurrentDate());
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getCOMP_DTLS_DOC_REC_DT().setDisabled(false);
		}else if("N".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_APPR_STS())){
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
		}else if("NA".equalsIgnoreCase(PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().getDTLS_APPR_STS())){
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getPT_IL_DOC_TODO_LIST_STATUS_BEAN().setDTLS_DOC_REC_DT(null);
			PT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN.getCOMP_DTLS_DOC_REC_DT().setDisabled(true);
		}
		
		PILT006_APAC_PROCEDURE pilt006_apac_procedure = new PILT006_APAC_PROCEDURE();
		List<String> list = pilt006_apac_procedure.L_VALIDATE_CHECKLIST(PT_IL_CLAIM_BEAN);
	//	String M_CHECK = list.get(1).toString();
	//	String M_UWQ = list.get(2).toString();
	}
	/**
	 * 
	 * @param context
	 * @param CUST_CODE
	 * @return
	 */
	public List<LovBean> lovSlNo(
			FacesContext context,String DS_TYPE,String DS_CODE,
			String GROUP_CODE,
			String DTL_SR_NO) {
		String selectQuery = "SELECT DTL_SR_NO,DTL_TODO_LIST_ITEM FROM " +
				"PM_IL_DOC_TODO_LIST WHERE DTL_DS_TYPE = ? " +
				"AND DTL_DS_CODE = ? AND DTL_DTG_GROUP_CODE = ? " +
				"AND DTL_SR_NO LIKE NVL(?,DTL_SR_NO) " +
				"AND ROWNUM < 21";
		if (DTL_SR_NO != null)
			if (DTL_SR_NO.equals("*"))
				DTL_SR_NO = "%";
			else
				DTL_SR_NO += "%";
		
		Object[] object = new Object[]{DS_TYPE,DS_CODE,GROUP_CODE,DTL_SR_NO};
		
		CRUDHandler handler = new CRUDHandler();
		LovBean lovBean = null;
		List<LovBean> list = new ArrayList<LovBean>();
		try {
			Connection connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(selectQuery,connection,object);
			
			while (rst.next()) {
				lovBean = new LovBean();
				lovBean.setCode(rst.getString(1));
				lovBean.setName(rst.getString(2));
				
				list.add(lovBean);
			}
			try {
				CommonUtils.closeCursor(rst);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
/* Added by Janani on 23/05/2017 for hands-on-feedback point(checklist)*/ 
	
	public void whenCreateRecord(PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN().getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		try{
		listStatusBean.setDTLS_MANDATORY_YN("N");
		listStatusBean.setDTLS_APPR_STS("N");
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	public void preUpdate(PT_IL_DOC_TODO_LIST_STATUS PT_IL_DOC_TODO_LIST_STATUS_BEAN,
			PILT006_APAC_COMPOSITE_ACTION compositeAction) throws Exception {
		PT_IL_DOC_TODO_LIST_STATUS listStatusBean = compositeAction
				.getPT_IL_DOC_TODO_LIST_STATUS_ACTION_BEAN()
				.getPT_IL_DOC_TODO_LIST_STATUS_BEAN();
		CommonUtils commonUtils = new CommonUtils();
		try {
			//IL_UNIQUE_TODOLIST_SNO(listStatusBean);
			
			
			PILT006_APAC_PROCEDURE pilt006_apac_procedure =new PILT006_APAC_PROCEDURE();
			pilt006_apac_procedure.IL_UNIQUE_TODOLIST_SRNO(PT_IL_DOC_TODO_LIST_STATUS_BEAN);
			
			
			listStatusBean.setDTLS_UPD_DT(commonUtils.getCurrentDate());
			listStatusBean.setDTLS_UPD_UID(CommonUtils.getControlBean().getM_USER_ID());
		} catch (ParseException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	
	
	public void IL_UNIQUE_TODOLIST_SNO(PT_IL_DOC_TODO_LIST_STATUS listStatusBean) throws Exception {

		int M_POL_PROP_NO = 0;

		String query1 = " SELECT 'X'  FROM   PT_IL_DOC_TODO_LIST_STATUS WHERE  DTLS_SR_NO  = ? "
						+ " AND DTLS_POL_SYS_ID  = ? AND  NVL(DTLS_END_NO_IDX,0)  = NVL(?,0)  AND  DTLS_GROUP_CODE  = ?	 ";

		String query2 = " SELECT 'X'  FROM   PT_IL_DOC_TODO_LIST_STATUS  WHERE DTLS_SR_NO = ? AND DTLS_POL_SYS_ID  = ? "
						+ " AND NVL(DTLS_END_NO_IDX,0) = NVL(?,0)  AND    DTLS_GROUP_CODE  = ? " + "  AND    ROWID <> ? ";

		Connection connection = null;
		Object[] object1 = null, object2 = null;
		ResultSet rs1 = null, rs2 = null;
		String M_TODOLIST_SRNO = null;
		try {

			connection = CommonUtils.getConnection();
			object1 = new Object[] {
									listStatusBean.getDTLS_SR_NO(),
									listStatusBean.getDTLS_POL_SYS_ID(),
									listStatusBean.getDTLS_END_NO_IDX(),
									listStatusBean.getDTLS_GROUP_CODE() };

			if (listStatusBean.getROWID() == null) {
				rs1 = new CRUDHandler().executeSelectStatement(query1,connection, object1);

				if (rs1.next()) {
					M_TODOLIST_SRNO = rs1.getString(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90015",
											new Object[] {"Check List Serial No" }));
				}
			} else {
				object2 = new Object[] {
										listStatusBean.getDTLS_SR_NO(),
										listStatusBean.getDTLS_POL_SYS_ID(),
										listStatusBean.getDTLS_END_NO_IDX(),
										listStatusBean.getDTLS_GROUP_CODE(),
										listStatusBean.getROWID() };
				rs2 = new CRUDHandler().executeSelectStatement(query2,connection, object2);

				if (rs2.next()) {
					M_TODOLIST_SRNO = rs2.getString(1);
					throw new Exception(Messages.getString(PELConstants.pelErrorMessagePath,"90015",
											new Object[] {"Check List Serial No" }));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(rs1);
				CommonUtils.closeCursor(rs2);
			} catch (Exception e) {
		}
		}
	}
	
	/*End*/
	
	
}
