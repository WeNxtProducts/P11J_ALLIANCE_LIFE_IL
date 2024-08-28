package com.iii.premia.common.notes;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table (name = "PCOM_NOTES_TAGGED_USERS")
public class PCOM_NOTES_TAGGED_USERS extends BaseValueBean{
	
	@Column(name = "PNTU_SYS_ID")
	private Long PNTU_SYS_ID ;
	
	@Column(name = "PNTU_SEQ_NO")
	private Integer PNTU_SEQ_NO;
	
	@Column(name = "PNTU_TAGGED_USER")
	private String PNTU_TAGGED_USER;
	
	/*public PCOM_NOTES_TAGGED_USERS(){
		
	}*/
	
	/*public PCOM_NOTES_TAGGED_USERS(Long psysid, Integer seqNo, String user){
		PNTU_SYS_ID = psysid;
		PNTU_SEQ_NO = seqNo;
		PNTU_TAGGED_USER = user;
	}*/
	
	public Long getPNTU_SYS_ID() {
		return PNTU_SYS_ID;
	}
	public void setPNTU_SYS_ID(Long pntu_sys_id) {
		PNTU_SYS_ID = pntu_sys_id;
	}
	
	public Integer getPNTU_SEQ_NO() {
		return PNTU_SEQ_NO;
	}

	public void setPNTU_SEQ_NO(Integer pntu_seq_no) {
		PNTU_SEQ_NO = pntu_seq_no;
	}

	public String getPNTU_TAGGED_USER() {
		return PNTU_TAGGED_USER;
	}
	public void setPNTU_TAGGED_USER(String pntu_tagged_user) {
		PNTU_TAGGED_USER = pntu_tagged_user;
	}
	
}
