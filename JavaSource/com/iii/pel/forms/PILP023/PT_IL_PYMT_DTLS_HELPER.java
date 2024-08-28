package com.iii.pel.forms.PILP023;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpSession;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.apps.persistence.OracleParameter;
import com.iii.premia.common.bean.ControlBean;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_HELPER {
	
	Map<String, Object> session = null;
	FacesContext ctx = null;
	
	/*public void createCtrlBean(){
		ControlBean bean = new ControlBean();
		FacesContext context=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession)context.getExternalContext().getSession(false);
		System.out.println("PT_IL_CLAIM_ACTION.createCtrlBean()SESSION"+session);
		session.setAttribute("ctrlbean", bean);
	}
	
	public ControlBean getCtrlBean() {
		session = ctx.getExternalContext().getSessionMap();
		return (ControlBean) session.get("ctrlbean");
	}
	public void putCtrlBean(ControlBean bean){
		FacesContext context=FacesContext.getCurrentInstance();
		HttpSession session=(HttpSession)context.getExternalContext().getSession(false);
		session.setAttribute("ctrlbean", bean);
	}*/
	
	/*public void whenNewBlockInstance(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN){
	
		if(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_NO()!=null &&
				PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_TXN_CODE()!=null){
			String whereCondition = " PD_SYS_ID  IN (SELECT DPD_PD_SYS_ID "+
	                                   "FROM   PT_IL_DEPOSIT_PYMT_DTLS  "+
	                                   "WHERE  DPD_DEP_SYS_ID = "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_SYS_ID()+")";
			
			CommonUtils.setGlobalVariable("PT_IL_PYMT_DTLS_WHERE", whereCondition);
		}
	}
	*/
	public void whenNewBlockInstance(PT_IL_CHEQUE_BOUNCE_HDR PT_IL_CHEQUE_BOUNCE_HDR_BEAN){

		if(PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_DOC_NO()!=null &&
		PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_TXN_CODE()!=null){
		/*String whereCondition = " PD_SYS_ID IN (SELECT DPD_PD_SYS_ID "+
		"FROM PT_IL_DEPOSIT_PYMT_DTLS "+
		"WHERE DPD_DEP_SYS_ID = "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_SYS_ID()+")";*/

		String whereCondition ="PD_TXN_SYS_ID IN (SELECT DPD_DEP_SYS_ID FROM PT_IL_DEPOSIT_PYMT_DTLS WHERE PD_SYS_ID = DPD_PD_SYS_ID AND "
		+ "DPD_DEP_SYS_ID = "+PT_IL_CHEQUE_BOUNCE_HDR_BEAN.getUI_M_DEP_SYS_ID()+")";
		System.out.println("PAYMENT_DETAILS_WHERE_FILTER-----> "+ whereCondition);
		CommonUtils.setGlobalVariable("PT_IL_PYMT_DTLS_WHERE", whereCondition);
		}
		}
	public void pilp023_pt_il_pymt_dtls_on_populate_details() throws SQLException,Exception
    {/*
        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            String RECSTAT=:SYSTEM.RECORD_STATUS;
            String STARTITM=:SYSTEM.CURSOR_ITEM;
            RELATION REL_ID;
            if((RECSTAT.equals(""+"NEW") || RECSTAT.equals(""+"INSERT")))
            {
            }
            if(((:PT_IL_PYMT_DTLS.PD_SYS_ID != null)))
            {
                REL_ID=FIND_RELATION.FIND_RELATION("PT_IL_PYMT_DTLS.PT_IL_PYMT_DTLS_PT_IL_CHEQUE_B");
                QUERY_MASTER_DETAILS.QUERY_MASTER_DETAILS(REL_ID,"PT_IL_CHEQUE_BOUNCE_HDR");
            }
            if((:SYSTEM.CURSOR_ITEM!=STARTITM))
            {
                GO_ITEM.GO_ITEM(STARTITM);
                CHECK_PACKAGE_FAILURE.CHECK_PACKAGE_FAILURE();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
    */}
	
	
	@SuppressWarnings("unchecked")
	public void pilp023_pt_il_pymt_dtls_post_query(PT_IL_PYMT_DTLS PYMT_DTLS_BEAN) throws Exception
    {
		Connection connection = null;
		
		String PD_CURR_CODE = PYMT_DTLS_BEAN.getPD_CURR_CODE();
		String CURR_CODE_DESC = PYMT_DTLS_BEAN.getUI_M_PD_CURR_CODE_DESC();
		
		CRUDHandler handler = new CRUDHandler();
        try
        {
        	connection = CommonUtils.getConnection();
//            final dbms_output dbms_output1=new dbms_output();
//        	SELECT LIV_CODE_DESC FROM PT_IL_PYMT_DTLS A, PP_LIST_ITEM_VALUES B WHERE LIV_SYS_PARAM = 'IL_TXN_TYPE'  AND LIV_CODE  = A.PD_TXN_TYPE  AND A.PD_SYS_ID  = :PT_IL_PYMT_DTLS.PD_SYS_ID 
            String sql_C1="SELECT LIV_CODE_DESC FROM PT_IL_PYMT_DTLS A, PP_LIST_ITEM_VALUES B" +
            				" WHERE LIV_SYS_PARAM = 'IL_TXN_TYPE'" +
            					" AND LIV_CODE  = A.PD_TXN_TYPE  " +
            						"AND A.PD_SYS_ID  = ? ";
            ResultSet rs_C1=null;
//            Statement stmt_C1=vembu_conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            if(rs_C1!=null)
            {
            	rs_C1.close();
            }
//            vembu_C1=stmt_C1.executeQuery(sql_C1);
            System.out.println("PYMT_DTLS_BEAN::"+PYMT_DTLS_BEAN.getPD_SYS_ID());
            rs_C1=handler.executeSelectStatement(sql_C1, connection, new Object[]{PYMT_DTLS_BEAN.getPD_SYS_ID()});
            if(rs_C1.next())
            {
            	PYMT_DTLS_BEAN.setUI_M_PD_TXN_TYPE_DESC(rs_C1.getString("LIV_CODE_DESC"));
            }
            if(rs_C1.isAfterLast() || rs_C1.isBeforeFirst())
            {
            	throw new ValidatorException(Messages.getMessage("com.iii.premia.common.errorUtil.PELErrorMessages", "91307"));
                /*STD_MESSAGE_ROUTINE.STD_MESSAGE_ROUTINE(91307,:CTRL.M_LANG_CODE);
                throw new FORM_TRIGGER_FAILURE();*/
            }
            rs_C1.close();
            /*P_VAL_CURR.P_VAL_CURR(:PT_IL_PYMT_DTLS.PD_CURR_CODE,:PT_IL_PYMT_DTLS.M_PD_CURR_CODE_DESC,"N","N");
            P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:PT_IL_PYMT_DTLS.PD_CURR_CODE);*/
            ArrayList<OracleParameter> outputList = new PILP023_PROCEDURE().P_VAL_CURR(connection, PD_CURR_CODE, CURR_CODE_DESC, "N", "N", null);
			OracleParameter paramOutput1 = outputList.get(0);
			String CLAIM_MED_CODE_NAME = paramOutput1.getValue();
			PYMT_DTLS_BEAN.setUI_M_PD_CURR_CODE_DESC(CLAIM_MED_CODE_NAME);
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        
    }
	public static void pilp023_pt_il_pymt_dtls_when_new_block_instance() 
    {/*
        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
        try
        {
            final dbms_output dbms_output1=new dbms_output();
            if(:DUMMY.M_DEP_TXN_CODE != null && :DUMMY.M_DEP_DOC_NO != null)
            {
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PYMT_DTLS",QUERY_ALLOWED,PROPERTY_TRUE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PYMT_DTLS",DEFAULT_WHERE,"PD_SYS_ID  IN (SELECT DPD_PD_SYS_ID                                      FROM   PT_IL_DEPOSIT_PYMT_DTLS                                      WHERE  DPD_DEP_SYS_ID = "+:DUMMY.M_DEP_SYS_ID+")");
                EXECUTE_QUERY.EXECUTE_QUERY();
                P_SET_FC_NUM_FMT_MASK.P_SET_FC_NUM_FMT_MASK(:PT_IL_PYMT_DTLS.PD_CURR_CODE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PYMT_DTLS",QUERY_ALLOWED,PROPERTY_FALSE);
                SET_BLOCK_PROPERTY.SET_BLOCK_PROPERTY("PT_IL_PYMT_DTLS",DEFAULT_WHERE,"");
            }
        }catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(vembu_conn != null)
            {
                SwisSqlConnection.getInstance().closeConnection(vembu_conn);
            }
        }
    */}
	public void pilp023_pre_form(FacesContext context) 
    {
//        Connection vembu_conn = SwisSqlConnection.getInstance().getConnection();
		Map<String, Object> sessionMap = context.getExternalContext().getSessionMap();
		HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
		String clientID = (String)sessionMap.get("CLIENT_ID");
		String M_FILE=null;
		@SuppressWarnings("unused")
		String M_TITLE=null;
        try
        {
        	Connection connection = CommonUtils.getConnection();
//            final dbms_output dbms_output1=new dbms_output();
//            SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,WINDOW_STATE,MAXIMIZE);
            /*if(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CALLING_FORM)== null)
            {*/
                /*:GLOBAL.M_PRIVILEGE="YYY";
                :GLOBAL.M_FAILURE="FALSE";
                :GLOBAL.M_USER_ID="PREMIA";
                :GLOBAL.M_NAME="COMPANY NAME..................PROGRAM NAME";
                :GLOBAL.M_LANG_CODE="ENG";
                :GLOBAL.M_PARA_1=" ";
                :GLOBAL.M_FOR_LANG_CODE="ARBR1";
                :GLOBAL.M_MODULE_NAME=GET_FORM_PROPERTY.GET_FORM_PROPERTY(GET_APPLICATION_PROPERTY.GET_APPLICATION_PROPERTY(CURRENT_FORM_NAME),FORM_NAME);
                :GLOBAL.M_DFLT_VALUES="00101    01    ";*/
            	
            	//session.setAttribute("GLOBAL.M_PRIVILEGE", "YYY");
        		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
        		//session.setAttribute("GLOBAL.M_USER_ID", "PREMIA");
        		//session.setAttribute("GLOBAL.M_NAME", "COMPANY NAME..................PROGRAM NAME");
        		//session.setAttribute("GLOBAL.M_LANG_CODE", "ENG");
        		//session.setAttribute("GLOBAL.M_DFLT_VALUES", "00101    01");
        		//session.setAttribute("GLOBAL.M_PARA_1", " ");
        		//session.setAttribute("GLOBAL.M_FOR_LANG_CODE", "ARBR1");

        		//session.setAttribute("GLOBAL.M_MODULE_NAME", "PILT007");
//            }
//            STD_PRE_FORM.STD_PRE_FORM();
            STD_PRE_FORM(context);
            /*if(StringFunctions.substr(:GLOBAL.M_FOR_LANG_CODE,5,1)=="1")
            {
            }*/
            if(Integer.parseInt(((String)session.getAttribute("GLOBAL.M_FOR_LANG_CODE")).substring(4,5))== 1 ){
    		}
//            pcopk_sys_vars.pcopk_sys_vars.p_set_para_values(:GLOBAL.M_LANG_CODE,:GLOBAL.M_FOR_LANG_CODE,:GLOBAL.M_USER_ID,:CTRL.M_COMP_CODE,StringFunctions.substr(:GLOBAL.M_DFLT_VALUES,4,6),StringFunctions.substr(:GLOBAL.M_DFLT_VALUES,10,6),:CTRL.M_BASE_CURR,2,"PILP023");
//            M_TITLE=:CTRL.M_USER_ID+"                 "+:CTRL.M_SCR_NAME+"          "+ConvertFunctions.to_char(new java.sql.Date(Calendar.getInstance().getTimeInMillis()),"DD/MM/YY");
//            SET_WINDOW_PROPERTY.SET_WINDOW_PROPERTY(FORMS_MDI_WINDOW,TITLE,M_TITLE);
//            :GLOBAL.M_CHECK_FLAG="FALSE";
//            :GLOBAL.M_REVERSAL_FLAG="N";
            ControlBean ctrlbean = CommonUtils.getControlBean();
    		M_TITLE = ctrlbean.getM_USER_ID()+" "+ctrlbean.getM_SCR_NAME()+" "+new Date();
    		session.setAttribute("GLOBAL.M_CHECK_FLAG", "False");
    		session.setAttribute("", "");
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }
	public void STD_PRE_FORM(FacesContext context){
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		ControlBean ctrlBean = CommonUtils.getControlBean();
		ctrlBean.setM_PARA_1((String)session.getAttribute("GLOBAL.M_PARA_1"));
		//ctrlBean.setM_USER_ID((String)session.getAttribute("GLOBAL.M_USER_ID"));
		ctrlBean.setM_PROG_NAME("PILP023");
		System.out.println("PT_IL_CLAIM_ACTION.STD_PRE_FORM(------)" +(String)session.getAttribute("GLOBAL.M_NAME"));
		//ctrlBean.setM_SCR_NAME(((String)session.getAttribute("GLOBAL.M_NAME")).substring(30, 42));
		session.setAttribute("GLOBAL.M_FAILURE", "FALSE");
		ctrlBean.setM_GOFLD_NAME("NULL");
		//ctrlBean.setM_LANG_CODE((String)session.getAttribute("GLOBAL.M_LANG_CODE"));
		//ctrlBean.setM_COMP_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(0,3));
	//	ctrlBean.setM_DIVN_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(3,6));
		System.out.println("PT_IL_CLAIM_ACTION.STD_PRE_FORM(!!!! ) "+(String)session.getAttribute("GLOBAL.M_DFLT_VALUES"));
		//ctrlBean.setM_DEPT_CODE(((String)session.getAttribute("GLOBAL.M_DFLT_VALUES")).substring(9,11));
		//putCtrlBean(ctrlBean);
		System.out.println("PT_IL_CLAIM_ACTION.STD_PRE_FORM()--- \n "+ctrlBean.getM_LANG_CODE()+"\t"+ctrlBean.getM_COMP_CODE()+"\t"+ctrlBean.getM_PARA_1());
	}
	
	public void chequeBounceHeader(){
		
	}
	
	public List<PT_IL_PYMT_DTLS> pymtSelectQuery(PILP023_COMPOSITE_ACTION compsiteAction) throws Exception
	{
		System.out.println("PAYMENT SELECT QUERY");
		//Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//PILP023_COMPOSITE_ACTION compositeAction =  (PILP023_COMPOSITE_ACTION)sessionMap.get("PILP023_COMPOSITE_ACTION");
		Double sysID = compsiteAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getUI_M_DEP_SYS_ID();
//		Double sysID = compositeAction.getPILP023_PT_IL_DEPOSIT_ACTION().getPT_IL_DEPOSIT_BEAN().get
		
		PT_IL_PYMT_DTLS_ACTION pymtAction = compsiteAction.getPILP023_PT_IL_PYMT_DTLS_ACTION();
		PT_IL_PYMT_DTLS pymtBean = null;
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<PT_IL_PYMT_DTLS> pymtList = new ArrayList<PT_IL_PYMT_DTLS>();
//		:DUMMY.M_DEP_SYS_ID
		String query = "SELECT PD_FC_AMT, PD_LC_AMT, PD_BRANCH_NAME, PD_CHQ_NO," +
						" PD_CUST_NAME, PD_ADDR_01, PD_ADDR_02, PD_ADDR_03, PD_SYS_ID" +
						" FROM PT_IL_PYMT_DTLS" +
						" WHERE PD_SYS_ID  IN (SELECT DPD_PD_SYS_ID " +
												"FROM PT_IL_DEPOSIT_PYMT_DTLS " +
												"WHERE  DPD_DEP_SYS_ID = ?)";
		System.out.println(query);
		System.out.println(sysID);
		if(sysID!=null){
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection, new Object[]{sysID});
			while(rst.next())
			{
				pymtBean = pymtAction.getPT_IL_PYMT_DTLS_BEAN();
				pymtBean.setPD_SYS_ID(rst.getLong("PD_SYS_ID"));
				pymtBean.setPD_FC_AMT(rst.getDouble("PD_FC_AMT"));
				pymtBean.setPD_LC_AMT(rst.getDouble("PD_LC_AMT"));
				pymtBean.setPD_BRANCH_NAME(rst.getString("PD_BRANCH_NAME"));
				pymtBean.setPD_CHQ_NO(rst.getString("PD_CHQ_NO"));
				pymtBean.setPD_CUST_NAME(rst.getString("PD_CUST_NAME"));
				pymtBean.setPD_ADDR_01(rst.getString("PD_ADDR_01"));
				pymtBean.setPD_ADDR_02(rst.getString("PD_ADDR_02"));
				pymtBean.setPD_ADDR_03(rst.getString("PD_ADDR_03"));
				pilp023_pt_il_pymt_dtls_post_query(pymtBean);
				pymtList.add(pymtBean);
				System.out.println("-------------------------------------------->record....");
			}
			pymtAction.setPymtList(pymtList);
			System.out.println("L-->I-->-->S--->T"+pymtList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return pymtList;
		
	}
	public void executeQuery(PILP023_COMPOSITE_ACTION compositeAction)
	{
		//System.out.println("GRRRRRRRRR))))))))))*((((((("+sysID);
		String whereCondition = CommonUtils.getGlobalVariable("PT_IL_PYMT_DTLS_WHERE");
		String query = "SELECT * FROM PT_IL_PYMT_DTLS" +
						  " WHERE "+whereCondition;
		
		/*String query_customerdetatil="SELECT * FROM PM_CUSTOMER WHERE CUST_CODE=(SELECT DEP_CUST_CODE FROM PT_IL_DEPOSIT WHERE DEP_DOC_NO=?)";*/
		String query_customerdetatil="SELECT * FROM PM_CUSTOMER WHERE CUST_CODE IN (SELECT MAX(DEP_CUST_CODE) FROM PT_IL_DEPOSIT WHERE DEP_DOC_NO =? )";
		//PILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION.PT_IL_CHEQUE_BOUNCE_HDR_BEAN.UI_M_DEP_DOC_NO
		int Doc_no=compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION().getPT_IL_CHEQUE_BOUNCE_HDR_BEAN().getUI_M_DEP_DOC_NO();
		System.out.println(query);
		//Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		//PILP023_COMPOSITE_ACTION compositeAction =  (PILP023_COMPOSITE_ACTION)sessionMap.get("PILP023_COMPOSITE_ACTION");
		PT_IL_CHEQUE_BOUNCE_HDR_ACTION bounceAction = compositeAction.getPILP023_PT_IL_CHEQUE_BOUNCE_HDR_ACTION();
	
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		
		PT_IL_PYMT_DTLS pymtBean = null;
		ArrayList<PT_IL_PYMT_DTLS> pymtList = new ArrayList<PT_IL_PYMT_DTLS>();
		
		try {
			connection = CommonUtils.getConnection();
			ResultSet rst = handler.executeSelectStatement(query, connection);
			ResultSet rst2 = new CRUDHandler().executeSelectStatement(query_customerdetatil, connection,new Object[]{Doc_no});
			while(rst.next())
			{
				pymtBean = new PT_IL_PYMT_DTLS();
				if(rst2.next()){
					pymtBean.setPD_CUST_NAME(rst2.getString("CUST_NAME"));
					pymtBean.setPD_ADDR_01(rst2.getString("CUST_ADDR1"));
					pymtBean.setPD_ADDR_02(rst2.getString("CUST_ADDR2"));
					pymtBean.setPD_ADDR_03(rst2.getString("CUST_ADDR3"));
				}
				
				
				pymtBean.setPD_SYS_ID(rst.getLong("PD_SYS_ID"));
				pymtBean.setPD_FC_AMT(rst.getDouble("PD_FC_AMT"));
				pymtBean.setPD_LC_AMT(rst.getDouble("PD_LC_AMT"));
				pymtBean.setPD_BRANCH_NAME(rst.getString("PD_BRANCH_NAME"));
				pymtBean.setPD_CHQ_NO(rst.getString("PD_CHQ_NO"));
				pymtBean.setPD_CURR_CODE(rst.getString("PD_CURR_CODE"));
				//pymtBean.setPD_CUST_NAME(rst.getString("PD_CUST_NAME"));
				//pymtBean.setPD_ADDR_01(rst.getString("PD_ADDR_01"));
			//	pymtBean.setPD_ADDR_02(rst.getString("PD_ADDR_02"));
			//	pymtBean.setPD_ADDR_03(rst.getString("PD_ADDR_03"));
				pymtBean.setPD_TXN_TYPE(rst.getString("PD_TXN_TYPE"));
				pymtBean.setPD_TXN_SYS_ID(rst.getDouble("PD_TXN_SYS_ID"));
				pymtBean.setPD_SR_NO(rst.getDouble("PD_SR_NO"));
				pilp023_pt_il_pymt_dtls_post_query(pymtBean);
				pymtList.add(pymtBean);
				System.out.println("-------------------------------------------->record....");
			}
			compositeAction.getPILP023_PT_IL_PYMT_DTLS_ACTION().setPymtList(pymtList);
			System.out.println("L-->I-->-->S--->T"+pymtList.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
