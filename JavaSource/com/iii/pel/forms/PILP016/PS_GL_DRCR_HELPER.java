package com.iii.pel.forms.PILP016;

import java.sql.Connection;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;



public class PS_GL_DRCR_HELPER {
	
	
	public void preblock(CTRL CTRL_BEAN){
		if("N".equals(CommonUtils.nvl(CTRL_BEAN.getUI_M_POL_APPRV_STATUS(),"N"))){
		  // SET_BLOCK_PROPERTY('PS_DRCR',UPDATE_ALLOWED,PROPERTY_FALSE);
		}else{
		   //SET_BLOCK_PROPERTY('PS_DRCR',UPDATE_ALLOWED,PROPERTY_TRUE);
		}
	}
	
	public void when_button_pressed_ok(PS_GL_DRCR PS_GL_DRCR_BEAN)throws Exception{
		if(PS_GL_DRCR_BEAN.getROWID() != null){
	      String update_ps_gl_drcr = " UPDATE PS_GL_DRCR" +
	      		"	      SET    DRCR_CHQ_NO = ?," +
	      		"	   	         DRCR_CHQ_DT = ?," +
	      		"	             DRCR_BANK_NAME = ?" +
	      		"	      WHERE  DRCR_POL_SYS_ID = ?" +
	      		"	      AND    DRCR_END_NO_IDX   = ? ";	
	      Connection connection = null;
	      CRUDHandler handler = new CRUDHandler();
	      Object[] values = null;
	      try {
			connection = CommonUtils.getConnection();
			values = new Object[]{PS_GL_DRCR_BEAN.getDRCR_CHQ_NO(),
					              PS_GL_DRCR_BEAN.getDRCR_CHQ_DT(),
					              PS_GL_DRCR_BEAN.getDRCR_BANK_NAME(),
					              PS_GL_DRCR_BEAN.getDRCR_POL_SYS_ID(),PS_GL_DRCR_BEAN.getDRCR_END_NO_IDX()};
			handler.executeUpdateStatement(update_ps_gl_drcr, connection, values);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		}
	}
	
	
}

