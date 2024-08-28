package com.iii.pel.forms.PILQ101;

import java.sql.Connection;
import java.text.ParseException;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_PREM_COLL")
public class PT_IL_PREM_COL extends BaseValueBean {
	
	public PT_IL_PREM_COL(){
		CommonUtils utils=new CommonUtils();
		Connection con=null;
		try {
			
			M_REINSTMT_DT=utils.getCurrentDate();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Column(name="PC_SCHD_PYMT_DT")
	private Date M_REINSTMT_DT;

	public Date getM_REINSTMT_DT() {
		return M_REINSTMT_DT;
	}

	public void setM_REINSTMT_DT(Date m_reinstmt_dt) {
		M_REINSTMT_DT = m_reinstmt_dt;
	}
	

}
