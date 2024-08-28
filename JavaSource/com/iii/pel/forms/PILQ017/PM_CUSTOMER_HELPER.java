package com.iii.pel.forms.PILQ017;

import java.sql.Connection;
import java.util.Map;

import javax.faces.context.FacesContext;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_CUSTOMER_HELPER {
	public Map<String, Object> getSession(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		return ctx.getExternalContext().getSessionMap();
	}
	/*public List getValues()	{
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		List<PP_LIFE_POL_SCH_PRN> list = null;
		try {
			list = new ArrayList<PP_LIFE_POL_SCH_PRN>();
			connection = getConnection();
			PP_LIFE_POL_SCH_PRN_ACTION action = (PP_LIFE_POL_SCH_PRN_ACTION) getSession().get("PILT009_PT_IL_FAC_OUT_ACTION");
			String query = "select PT_IL_FAC_OUT.ROWID,FO_COVER_TYPE,FO_POL_SYS_ID,FO_SYS_ID,FO_COVER_CODE,FO_ASSR_CODE,FO_SA_CURR_CODE,FO_FC_FAC_SI,FO_LC_FAC_SI,FO_FAC_PERC,FO_PC_SYS_ID " +
					" from PT_IL_FAC_OUT , PT_IL_POLICY where POL_SYS_ID=FO_POL_SYS_ID AND POL_NO='"+getSession().get("GLOBAL.M_POL_NO")+"'";
			System.out.println("getValues()> "+query);
			list = dbHandler.fetch(query,"com.iii.pel.forms.PILT009.PT_IL_FAC_OUT",connection);
//			System.out.println("______________Check for rowid: "+((DataGridValueBean)list.get(0)).getROWID());
//			connection.commit();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return list;
	}*/
	
	/*public int updateData(PT_IL_POLICY dtlBean) throws Exception{
		System.out.println("updateData()");
		Connection connection = null;
		CRUDHandler dbHandler = new CRUDHandler();
		System.out.println("The Module Id from the Helper Class is ............."+dtlBean.getPOL_NO());
		int rowUpdated = 0;
		try {
			connection = CommonUtils.getConnection();
			//dataGridBean.setROWID(dataGridBean.getROWID()==null?"":dataGridBean.getROWID());
			rowUpdated = dbHandler.executeInsert(dtlBean, connection);
		} catch (Exception exc) {
			throw exc;
		}
		return rowUpdated;
	}*/
	public int deleteData(PT_IL_POLICY gridValueBean){
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int deletedRows = 0;
		try {
			connection = CommonUtils.getConnection();
			deletedRows = handler.executeDelete(gridValueBean, connection);
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deletedRows;
	}

}
