package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_BR_QUESTION")
public class PT_IL_POL_BR_QUESTION extends BaseValueBean  {
	@Column(name="PBQ_SYS_ID")
	private Long PBQ_SYS_ID;
	
	@Column(name="PBQ_POL_SYS_ID")
	private Long PBQ_POL_SYS_ID;
	
	@Column(name="PBQ_QUEST_TYPE")
	private String PBQ_QUEST_TYPE;
	
	@Column(name="PBQ_QUEST_REP_NAME")
	private String PBQ_QUEST_REP_NAME;
	
	@Column(name="PBQ_CR_UID")
	private String PBQ_CR_UID;

	@Column(name="PBQ_CR_DT")
	private Date PBQ_CR_DT;

	@Column(name="PBQ_UPD_UID")
	private String PBQ_UPD_UID;

	@Column(name="PBQ_UPD_DT")
	private Date PBQ_UPD_DT;

	public Long getPBQ_SYS_ID() {
		return PBQ_SYS_ID;
	}

	public void setPBQ_SYS_ID(Long pBQ_SYS_ID) {
		PBQ_SYS_ID = pBQ_SYS_ID;
	}

	public Long getPBQ_POL_SYS_ID() {
		return PBQ_POL_SYS_ID;
	}

	public void setPBQ_POL_SYS_ID(Long pBQ_POL_SYS_ID) {
		PBQ_POL_SYS_ID = pBQ_POL_SYS_ID;
	}

	public String getPBQ_QUEST_TYPE() {
		return PBQ_QUEST_TYPE;
	}

	public void setPBQ_QUEST_TYPE(String pBQ_QUEST_TYPE) {
		PBQ_QUEST_TYPE = pBQ_QUEST_TYPE;
	}

	public String getPBQ_QUEST_REP_NAME() {
		return PBQ_QUEST_REP_NAME;
	}

	public void setPBQ_QUEST_REP_NAME(String pBQ_QUEST_REP_NAME) {
		PBQ_QUEST_REP_NAME = pBQ_QUEST_REP_NAME;
	}

	public String getPBQ_CR_UID() {
		return PBQ_CR_UID;
	}

	public void setPBQ_CR_UID(String pBQ_CR_UID) {
		PBQ_CR_UID = pBQ_CR_UID;
	}

	public Date getPBQ_CR_DT() {
		return PBQ_CR_DT;
	}

	public void setPBQ_CR_DT(Date pBQ_CR_DT) {
		PBQ_CR_DT = pBQ_CR_DT;
	}

	public String getPBQ_UPD_UID() {
		return PBQ_UPD_UID;
	}

	public void setPBQ_UPD_UID(String pBQ_UPD_UID) {
		PBQ_UPD_UID = pBQ_UPD_UID;
	}

	public Date getPBQ_UPD_DT() {
		return PBQ_UPD_DT;
	}

	public void setPBQ_UPD_DT(Date pBQ_UPD_DT) {
		PBQ_UPD_DT = pBQ_UPD_DT;
	}
	
	
}
