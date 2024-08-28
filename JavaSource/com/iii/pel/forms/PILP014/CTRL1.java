package com.iii.pel.forms.PILP014;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PP_BATCH_DTLS")
public class CTRL1 extends BaseValueBean {

	
	@Column(name="BD_BM_SL_NO")
	private int BD_BM_SL_NO;
	
	@Column(name="BD_BM_EXEC_SEQ")
	private int BD_BM_EXEC_SEQ;
	
	@Column(name="BD_SYS_ID")
	private int BD_SYS_ID;
	

/*	@Column(name="BD_BM_PROC_CALL")
	private String BD_BM_PROC_CALL;*/
	
	@Column(name="BD_STATUS")
	private String BD_STATUS;
	
	@Column(name="BD_RESULT")
	private String BD_RESULT;
	       
	private String UI_M_BD_PROC_DESC;
	
	private Date UI_M_PROCESS_DT;
	
	private String UI_M_GROUP_ID;

	public int getBD_BM_SL_NO() {
		return BD_BM_SL_NO;
	}

	public void setBD_BM_SL_NO(int bd_bm_sl_no) {
		BD_BM_SL_NO = bd_bm_sl_no;
	}

	public int getBD_BM_EXEC_SEQ() {
		return BD_BM_EXEC_SEQ;
	}

	public void setBD_BM_EXEC_SEQ(int bd_bm_exec_seq) {
		BD_BM_EXEC_SEQ = bd_bm_exec_seq;
	}

/*	public String getBD_BM_PROC_CALL() {
		return BD_BM_PROC_CALL;
	}

	public void setBD_BM_PROC_CALL(String bd_bm_proc_call) {
		BD_BM_PROC_CALL = bd_bm_proc_call;
	}*/

	public String getBD_STATUS() {
		return BD_STATUS;
	}

	public void setBD_STATUS(String bd_status) {
		BD_STATUS = bd_status;
	}


	public String getBD_RESULT() {
		return BD_RESULT;
	}

	public void setBD_RESULT(String bd_result) {
		BD_RESULT = bd_result;
	}

	public String getUI_M_BD_PROC_DESC() {
		return UI_M_BD_PROC_DESC;
	}

	public void setUI_M_BD_PROC_DESC(String ui_m_bd_proc_desc) {
		UI_M_BD_PROC_DESC = ui_m_bd_proc_desc;
	}

	public Date getUI_M_PROCESS_DT() {
		return UI_M_PROCESS_DT;
	}

	public void setUI_M_PROCESS_DT(Date ui_m_process_dt) {
		UI_M_PROCESS_DT = ui_m_process_dt;
	}

	public int getBD_SYS_ID() {
		return BD_SYS_ID;
	}

	public void setBD_SYS_ID(int bd_sys_id) {
		BD_SYS_ID = bd_sys_id;
	}

	public String getUI_M_GROUP_ID() {
		return UI_M_GROUP_ID;
	}

	public void setUI_M_GROUP_ID(String ui_m_group_id) {
		UI_M_GROUP_ID = ui_m_group_id;
	}
	
	
	}
