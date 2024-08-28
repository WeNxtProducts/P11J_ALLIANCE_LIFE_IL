package com.iii.pel.forms.PILM106;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class PILM106_EMAIL_DELEGATE {
	public PILM106_EMAIL_BEAN emailbean;
	String frezeeValue=null;
	String attachmentValue=null;
	public void executeSelectStatement(PILM106_EMAIL_COMPOSITE_ACTION compositeAction,String product) throws Exception

	{

		List<PILM106_EMAIL_LIST> emailList = new ArrayList<PILM106_EMAIL_LIST>();
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			query = PILM106_A_QUERYCONSTANTS.Data_Table_List_Key;
			resultSet = handler.executeSelectStatement(query, connection);

			while(resultSet.next()){
				PILM106_EMAIL_LIST bean = new PILM106_EMAIL_LIST();
				System.out.println("dsdsadsad"+resultSet.getString(1));
				bean.setEMAIL_KEY(resultSet.getString(1));
				bean.setEMAIL_LABEL(resultSet.getString(2));
				emailList.add(bean);
			}

		}catch (DBException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		compositeAction.getEMAIL_ACTION_BEAN().setFlist_list(emailList);
	}


	public ArrayList<SelectItem> MAIL_TYPE_LIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PILM106_A_QUERYCONSTANTS.Select_Menu_Values;
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				list.add(selectItem);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}









	public void executeLoadData(PILM106_EMAIL_COMPOSITE_ACTION compositeAction)throws Exception {
		System.out.println("indise deeeeeelegate");
		compositeAction.getEMAIL_ACTION_BEAN().getCOMP_PROD_CODE().setDisabled(true);
		String rowId = compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getROWID();
		System.out.println("ROW ID : "+rowId);
		//String selectStatement = "SELECT * FROM PM_COMPANY WHERE ROWID = ? ";
		String selectStatement =PILM106_A_QUERYCONSTANTS.LoadData;
		Connection connection = null;
		ResultSet resultSet = null;
		
		ResultSet resultSet1 = null;

		try {
			connection = CommonUtils.getConnection();
			resultSet = new CRUDHandler().executeSelectStatement(
					selectStatement, connection,new Object[]{rowId});
			emailbean = new PILM106_EMAIL_BEAN();
			while (resultSet.next()) {
				System.out.println("ENTER THE RESULTSET");

				emailbean.setROWID(rowId);
				emailbean.setPMT_PROD_CODE(resultSet.getString("PMT_PROD_CODE"));
				emailbean.setPMT_MAIL_FM(resultSet.getString("PMT_MAIL_FM"));
				System.out.println("resultSet.getString(COMP_CODE) =================>>>>>"+resultSet.getString("PMT_MAIL_FM"));
				System.out.println("mail............"+emailbean.getPMT_MAIL_FM());
				emailbean.setPMT_MAIL_TYPE(resultSet.getString("PMT_MAIL_TYPE"));
				emailbean.setPMT_MAIL_SUB(resultSet.getString("PMT_MAIL_SUB"));
				emailbean.setPMT_MAIL_TEXT(resultSet.getString("PMT_MAIL_TEXT"));
				emailbean.setPMT_EFF_FM_DT((resultSet.getDate("PMT_EFF_FM_DT")));
				emailbean.setPMT_EFF_TO_DT((resultSet.getDate("PMT_EFF_TO_DT")));
				
				/*Added by ganesh on 28-06-2017,ZBILQC-1725181 */
				emailbean.setPMT_KEY_MAIL_TO((resultSet.getString("PMT_KEY_MAIL_TO")));
				emailbean.setPMT_KEY_MAIL_CC((resultSet.getString("PMT_KEY_MAIL_CC")));
				if(emailbean.getPMT_KEY_MAIL_TO()!=null){					
					emailbean.setUI_KEY_MAIL_TO(Arrays.asList(emailbean.getPMT_KEY_MAIL_TO().split(",")));
				}
				if(emailbean.getPMT_KEY_MAIL_CC()!=null){					
					emailbean.setUI_KEY_MAIL_CC(Arrays.asList(emailbean.getPMT_KEY_MAIL_CC().split(",")));
				}
				/*end*/
				
				
				System.out.println("EXIT RESULT SET ");
				frezeeValue=resultSet.getString("PMT_FRZ_FLAG");
				System.out.println("oooooooooooo"+frezeeValue);
				if(!frezeeValue.equals(null)){
					System.out.println("frease");
					if(frezeeValue.equals("Y")){
						System.out.println("i am in y");
						emailbean.setFRZ_FLAG(true);}
					else if(frezeeValue.equals("N"))
						emailbean.setFRZ_FLAG(false);
				}
				attachmentValue=resultSet.getString("PMT_ATTACH_YN");
				System.out.println("oooooooooooo"+attachmentValue);
				if(!frezeeValue.equals(null)){	
					System.out.println("frease");
					if(attachmentValue.equals("Y")){
						System.out.println("i am in y");
						emailbean.setATTACHMENT_FLAG(true);}
					else if(attachmentValue.equals("N"))
						emailbean.setATTACHMENT_FLAG(false);
				}
				if(resultSet.getString("PMT_MAIL_TYPE")!=null){
					if(resultSet.getString("PMT_MAIL_TYPE").equals("FGP")){					
						compositeAction.getEMAIL_ACTION_BEAN().getCOMP_PROD_CODE().setDisabled(true);
					}else{					
						compositeAction.getEMAIL_ACTION_BEAN().getCOMP_PROD_CODE().setDisabled(false);
					}
				}
				
				
				/*Added by janani on 27.02.2018 for SMS as discussed with Girirsh*/
				String getDesc = "SELECT PROD_DESC FROM PM_IL_PRODUCT WHERE PROD_CODE = ?";
				
				System.out.println("getPMT_PROD_CODE                  "+emailbean.getPMT_PROD_CODE());
				
				resultSet1 = new CRUDHandler().executeSelectStatement(
						getDesc, connection,new Object[]{emailbean.getPMT_PROD_CODE()});
				
				while (resultSet1.next()) {
					
					emailbean.setPROD_CODE_DESC(resultSet1.getString("PROD_DESC"));
					System.out.println("getPROD_CODE_DESC                  "+emailbean.getPROD_CODE_DESC());
				}
				/*End*/
				

				/*Added by saritha on 09-04-2018 for KIC E-Mail Template Issue*/
				emailbean.setPMT_TYPE((resultSet.getString("PMT_TYPE")));
				/*End*/
				
			}
			compositeAction.getEMAIL_ACTION_BEAN().setEmailBean(emailbean);
			System.out.println("indise deeeeeelegate end");
		} finally {
			CommonUtils.closeCursor(resultSet);
		}

	}


	public void preDelete(PILM106_EMAIL_COMPOSITE_ACTION compositeAction, 
			PILM106_EMAIL_BEAN pm_il_prop_treaty) throws Exception {
		Connection connection = null;
		CRUDHandler handler = null;
		try {
			String rowId = compositeAction.getEMAIL_ACTION_BEAN().getEmailBean().getROWID();
			System.out.println("delete rowID"+rowId);
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			String companyMasterDelete = "DELETE FROM PM_LIFE_MAIL_TEMPLATE WHERE ROWID  ='"+ rowId + "'";

			handler.executeDeleteStatement(companyMasterDelete, connection);

			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	/*Added by janani on 23.02.2018 for SMS as discussed with Girirsh*/
	public ArrayList<SelectItem> NOTF_TYPE_LIST() throws Exception{
		ArrayList<SelectItem> list = null;
		CRUDHandler handler;
		Connection connection = null;
		String query=null;
		ResultSet resultSet = null;
		try{
			connection = CommonUtils.getConnection();
			handler = new CRUDHandler();
			list = new ArrayList<SelectItem>();
			query = PILM106_A_QUERYCONSTANTS.Select_notf_type_Values;
			resultSet = handler.executeSelectStatement(query, connection);
			while(resultSet.next()){
				SelectItem selectItem = new SelectItem();
				selectItem.setValue(resultSet.getString(1));
				selectItem.setLabel(resultSet.getString(2));
				list.add(selectItem);
			}
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}finally{
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/*End*/

	
	
}
