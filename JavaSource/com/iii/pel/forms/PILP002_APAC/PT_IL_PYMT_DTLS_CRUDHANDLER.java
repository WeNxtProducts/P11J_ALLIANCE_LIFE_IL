package com.iii.pel.forms.PILP002_APAC;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PT_IL_PYMT_DTLS_CRUDHANDLER {
	/*public Connection getConnetion()throws Exception{
		ServletContext context = (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
		Connection connection = ((SimpleConnectionAgent)context.getAttribute("connectionAgent")).getConnection("12345");
		return connection;
	}*/
	
	public static void main(String args[]){
		System.out.println("hi!!!!!!!!!!");
	}
	
	public void insertPT_IL_PYMT_DTLS(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN){
		CRUDHandler crudHandler = new CRUDHandler();
		try{
			crudHandler.executeInsert(PT_IL_PYMT_DTLS_BEAN, CommonUtils.getConnection());
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(InvocationTargetException e){
			e.printStackTrace();
		}catch(NoSuchMethodException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				CommonUtils.getConnection().commit();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
/*	public void retreivePT_IL_PYMT_DTLS(PT_IL_PYMT_DTLS PT_IL_PYMT_DTLS_BEAN){
		
		ResultSet resultSet = null;
		System.out.println("in crud !!!!!!");
		String dbQuery = "select PD_SR_NO,PD_PAY_MODE,PD_DPD_REF_ID,PD_FC_AMT,PD_LC_AMT,PD_PAID_FOR,PD_CHQ_NO,PD_CHQ_DT from PT_IL_PYMT_DTLS where ROWNUM<=3";
		CRUDHandler crudHandler = new CRUDHandler();
		try{
			resultSet = crudHandler.executeSelectStatement(dbQuery, getConnetion());
			//PT_IL_PYMT_DTLS_LIST = crudHandler.fetch(dbQuery, "PT_IL_PYMT_DTLS", getConnetion());
			
			if(resultSet != null) {
				while(resultSet.next()) {
					PT_IL_PYMT_DTLS_BEAN.setPD_SR_NO(resultSet.getDouble("PD_SR_NO"));
					PT_IL_PYMT_DTLS_BEAN.setPD_PAY_MODE(resultSet.getString("PD_PAY_MODE"));
					PT_IL_PYMT_DTLS_BEAN.setPD_DPD_REF_ID(resultSet.getString("PD_DPD_REF_ID"));
					PT_IL_PYMT_DTLS_BEAN.setPD_FC_AMT(resultSet.getDouble("PD_FC_AMT"));
					PT_IL_PYMT_DTLS_BEAN.setPD_LC_AMT(resultSet.getDouble("PD_LC_AMT"));
					PT_IL_PYMT_DTLS_BEAN.setPD_PAID_FOR(resultSet.getString("PD_PAID_FOR"));
					PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_NO(resultSet.getString("PD_CHQ_NO"));
					PT_IL_PYMT_DTLS_BEAN.setPD_CHQ_DT(resultSet.getDate("PD_CHQ_DT"));
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(IllegalAccessException e){
			e.printStackTrace();
		}catch(InvocationTargetException e){
			e.printStackTrace();
		}catch(NoSuchMethodException e){
			e.printStackTrace();
		}catch(InstantiationException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				getConnetion().commit();
			}catch(SQLException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}*/
}
