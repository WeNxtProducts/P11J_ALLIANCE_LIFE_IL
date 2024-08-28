package com.iii.pel.forms.PILP060_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PT_IL_BONUS_DELEGATE {

	public List <SelectItem> getSelectItems(String fieldName,String comboFieldId) {
		CommonUtils utility= new CommonUtils();
		Connection connection=null;
		List selectItems=null;
		try {
			connection = utility.getConnection();
			selectItems=ListItemUtil.getDropDownListValue
			(connection,"PILP060_APAC" , "PT_IL_BONUS", fieldName, comboFieldId);
		} catch (DBException e) {
			e.printStackTrace();
		}
		return selectItems;
	}
	
	public void updateRecord(PT_IL_BONUS PT_IL_BONUS_BEAN ,boolean doCommit) throws Exception{
		Connection connection=null;
		
		
		CRUDHandler handler=new CRUDHandler();
		try {
			connection=CommonUtils.getConnection();
			handler.executeInsert(PT_IL_BONUS_BEAN, connection);
			System.out.println("Insert/Update  successful");
			if(doCommit){
				connection.commit();
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
}
