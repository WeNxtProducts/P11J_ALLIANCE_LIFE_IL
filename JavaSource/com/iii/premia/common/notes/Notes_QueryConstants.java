package com.iii.premia.common.notes;

public interface Notes_QueryConstants {
	
	final String USER_MAIL_ID = "SELECT NVL(USER_EMAIL, 'manojkumar.sahu@3i-infotech.com') FROM MENU_USER WHERE USER_ID = ? ";
	
	final String SELECT_PCOM_NOTES_TAGGED_USERS = "SELECT PNTU_SYS_ID, PNTU_SEQ_NO, PNTU_TAGGED_USER, ROWID " +
			" FROM PCOM_NOTES_TAGGED_USERS WHERE PNTU_SYS_ID = ? ORDER BY PNTU_SEQ_NO";
	
	final String USER_LIST_LOV = "SELECT USER_ID, USER_DESC FROM MENU_USER " +
			" WHERE USER_LOCKED_YN = 'N'";
	
	final String USER_LIST_LOV_LIKE = "SELECT USER_ID, USER_DESC FROM MENU_USER " +
	        " WHERE USER_LOCKED_YN = 'N' AND ( USER_ID LIKE ? OR USER_DESC LIKE ? ) ";
	
	final String preInsert_Query = "SELECT SEQ_PNM_SYS_ID.NEXTVAL FROM DUAL ";

	final String SELECT_PCOM_NOTES_MASTER_BY_TRANS_ID_AND_TRANS_TYP = "SELECT PNM_SYS_ID, " +
			"PNM_SCREEN_ID,PNM_TRANSACTION_ID,PNM_NOTES_CONTENT,PNM_CR_UID,PNM_CR_TIMESTAMP, " +
			"ROWID FROM PCOM_NOTES_MASTER WHERE PNM_TRANSACTION_ID=? AND PNM_SCREEN_ID =? " +
			"ORDER BY PNM_SYS_ID DESC";
	
	final String SELECT_DEFAULT_PCOM_NOTES_TAGGED_USERS = "SELECT DISTINCT PNTU_TAGGED_USER " +
			" FROM PCOM_NOTES_TAGGED_USERS,PCOM_NOTES_MASTER  " +
			" WHERE PNTU_SYS_ID = PNM_SYS_ID " +
			" AND PNM_SCREEN_ID = ? AND PNM_TRANSACTION_ID = ? ";
	
	final String SELECT_TAGGED_USERS_FOR_SYS_ID = "SELECT PNTU_SYS_ID, PNTU_SEQ_NO, " +
			" PNTU_TAGGED_USER, ROWID " +
			" FROM PCOM_NOTES_TAGGED_USERS WHERE PNTU_SYS_ID = ? ORDER BY PNTU_SEQ_NO";
	
	/*final String SELECT_APPLICABLE_NOTES_DATA_FOR_LOGIN_USER = "select PNM_SCREEN_ID,PNM_TRANSACTION_ID,pnm_sys_id, pnm_notes_content " +
			" from PCOM_NOTES_MASTER where pnm_cr_uid = ? " +
			" union all select PNM_SCREEN_ID,PNM_TRANSACTION_ID,pnm_sys_id,pnm_notes_content " +
			" from PCOM_NOTES_MASTER where ? in (select pntu_tagged_user " +
			" from PCOM_NOTES_TAGGED_USERS where pnm_sys_id = pntu_sys_id) ORDER BY pnm_sys_id DESC";*/
	
	/*final String SELECT_APPLICABLE_NOTES_DATA_FOR_LOGIN_USER =  "select PNM_SCREEN_ID,PNM_TRANSACTION_ID," +
			" pnm_sys_id,pnm_notes_content,PNM_CR_UID,PNM_CR_TIMESTAMP from PCOM_NOTES_MASTER " +
			" where pnm_cr_uid = ? and ? in (select pntu_tagged_user " +
			" from PCOM_NOTES_TAGGED_USERS where pnm_sys_id = pntu_sys_id) " +
			" ORDER BY pnm_sys_id DESC ";*/
	
	final String SELECT_APPLICABLE_NOTES_DATA_FOR_LOGIN_USER =  "select PNM_SCREEN_ID,PNM_TRANSACTION_ID," +
			" pnm_sys_id,pnm_notes_content,PNM_CR_UID,PNM_CR_TIMESTAMP " +
			" from PCOM_NOTES_MASTER,PCOM_NOTES_TAGGED_USERS " +
			" where pnm_sys_id =pntu_sys_id and PNTU_TAGGED_USER = ? " +
			" order by PNM_SYS_ID desc ";
	
//	UPDATE table_name
//	SET column1=value, column2=value2,...
//	WHERE some_column=some_value=?,
}
