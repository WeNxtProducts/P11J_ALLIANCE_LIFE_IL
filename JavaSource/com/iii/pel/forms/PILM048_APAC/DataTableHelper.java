package com.iii.pel.forms.PILM048_APAC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class DataTableHelper {

	public Connection getConnection() throws Exception{
		Connection connection = CommonUtils.getConnection();
		return connection;
	}
	public Map<String, Object> getSession(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		return ctx.getExternalContext().getSessionMap();
	}
	public List getValues()	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		//List list = null;
		ResultSet resultSet = null;
		ArrayList<PM_BANK_CHARGE_SETUP_DTL> dtlList = new ArrayList<PM_BANK_CHARGE_SETUP_DTL>();
		PM_BANK_CHARGE_SETUP_DTL dtlBean = null;
		try {
			//list = new ArrayList();
			connection = getConnection();
			PM_BANK_CHARGE_SETUP_HDR_ACTION action = (PM_BANK_CHARGE_SETUP_HDR_ACTION) getSession().get("PILM048_APAC_PM_BANK_CHARGE_SETUP_HDR_ACTION");
			System.out.println("DataTableHelper.getValues() "+action.getCOMP_BCSH_SYS_ID());
			String query = "SELECT ROWID,PM_BANK_CHARGE_SETUP_DTL.* FROM PM_BANK_CHARGE_SETUP_DTL WHERE BCSD_BCSH_SYS_ID="+action.getPM_BANK_CHARGE_SETUP_HDR_BEAN().getBCSH_SYS_ID();
			System.out.println("DataTableHelper.getValues()> "+query);
			resultSet = dbHandler.executeSelectStatement(query, connection);
			if(resultSet.next()){
				dtlBean = new PM_BANK_CHARGE_SETUP_DTL();
				dtlBean.setBCSD_SYS_ID(resultSet.getDouble("BCSD_SYS_ID"));                                                                                                                                                                                        
				dtlBean.setBCSD_BCSH_SYS_ID(resultSet.getDouble("BCSD_BCSH_SYS_ID"));                                                                                                                                                                                        
				dtlBean.setBCSD_AMT_LC_FM(resultSet.getDouble("BCSD_AMT_LC_FM"));                                                                                                                                                                                        
				dtlBean.setBCSD_AMT_LC_TO(resultSet.getDouble("BCSD_AMT_LC_TO"));                                                                                                                                                                                        
				dtlBean.setBCSD_RATE_PER(resultSet.getDouble("BCSD_RATE_PER"));                                                                                                                                                                                        
				dtlBean.setBCSD_RATE(resultSet.getDouble("BCSD_RATE"));                                                                                                                                                                                        
				dtlBean.setBCSD_MAX_CHG_LC(resultSet.getDouble("BCSD_MAX_CHG_LC"));                                                                                                                                                                                        
				dtlBean.setBCSD_MIN_CHG_LC(resultSet.getDouble("BCSD_MIN_CHG_LC"));                                                                                                                                                                                        
				dtlBean.setBCSD_EFF_FM_DT(resultSet.getDate("BCSD_EFF_FM_DT"));                                                                                                                                                                                          
				dtlBean.setBCSD_EFF_TO_DT(resultSet.getDate("BCSD_EFF_TO_DT"));
				dtlBean.setROWID(resultSet.getString("ROWID"));
				dtlList.add(dtlBean);
				
			}
			//action.setDtlList(dtlList);
			//list = dbHandler.fetch(query,"com.iii.pel.forms.PILM048_APAC.PM_BANK_CHARGE_SETUP_DTL",connection);
//			System.out.println("______________Check for rowid: "+((DataGridValueBean)list.get(0)).getROWID());
//			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return dtlList;
	}
	
	public int updateData(PM_BANK_CHARGE_SETUP_DTL dtlBean) throws Exception{
		System.out.println("DataTableHelper.updateData()");
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		int rowUpdated = 0;
		System.out.println("DataTableHelper.updateData()\n-------"+dtlBean.getBCSD_AMT_LC_FM()+"\t"+dtlBean.getBCSD_AMT_LC_TO()+"\t"+dtlBean.getBCSD_MIN_CHG_LC()+"\t"
				+dtlBean.getBCSD_MAX_CHG_LC()+"\t"+dtlBean.getBCSD_RATE()+"\t"+dtlBean.getBCSD_RATE_PER());
		try {
			connection = getConnection();
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(dtlBean, connection);
			//connection.commit();
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}
	public int deleteData(PM_BANK_CHARGE_SETUP_DTL gridValueBean){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}
}
