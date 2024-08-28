package com.iii.pel.forms.PILQ003;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_CONDITION")
public class PT_IL_POL_CONDITION extends BaseValueBean {

	@Column(name="PLCOND_SYS_ID")
	private Long PLCOND_SYS_ID;

	@Column(name="PLCOND_POL_SYS_ID")
	private Long PLCOND_POL_SYS_ID;

	@Column(name="PLCOND_CODE")
	private String PLCOND_CODE;

	@Column(name="PLCOND_DESC")
	private String PLCOND_DESC;

	@Column(name="PLCOND_DEL_FLAG")
	private String PLCOND_DEL_FLAG;

	@Column(name="PLCOND_CR_DT")
	private Date PLCOND_CR_DT;

	@Column(name="PLCOND_CR_UID")
	private String PLCOND_CR_UID;

	@Column(name="PLCOND_UPD_DT")
	private Date PLCOND_UPD_DT;

	@Column(name="PLCOND_UPD_UID")
	private String PLCOND_UPD_UID;

	public void setPLCOND_CODE(String PLCOND_CODE) {
		this.PLCOND_CODE = PLCOND_CODE;
	}
	public String getPLCOND_CODE() {
		 return PLCOND_CODE;
	}
	public void setPLCOND_CR_UID(String PLCOND_CR_UID) {
		this.PLCOND_CR_UID = PLCOND_CR_UID;
	}
	public String getPLCOND_CR_UID() {
		 return PLCOND_CR_UID;
	}
	public void setPLCOND_DEL_FLAG(String PLCOND_DEL_FLAG) {
		this.PLCOND_DEL_FLAG = PLCOND_DEL_FLAG;
	}
	public String getPLCOND_DEL_FLAG() {
		 return PLCOND_DEL_FLAG;
	}
	public void setPLCOND_DESC(String PLCOND_DESC) {
		this.PLCOND_DESC = PLCOND_DESC;
	}
	public String getPLCOND_DESC() {
		 return PLCOND_DESC;
	}
	public void setPLCOND_UPD_DT(Date PLCOND_UPD_DT) {
		this.PLCOND_UPD_DT = PLCOND_UPD_DT;
	}
	public Date getPLCOND_UPD_DT() {
		 return PLCOND_UPD_DT;
	}
	public void setPLCOND_SYS_ID(Long PLCOND_SYS_ID) {
		this.PLCOND_SYS_ID = PLCOND_SYS_ID;
	}
	public Long getPLCOND_SYS_ID() {
		 return PLCOND_SYS_ID;
	}
	public void setPLCOND_CR_DT(Date PLCOND_CR_DT) {
		this.PLCOND_CR_DT = PLCOND_CR_DT;
	}
	public Date getPLCOND_CR_DT() {
		 return PLCOND_CR_DT;
	}
	public void setPLCOND_POL_SYS_ID(Long PLCOND_POL_SYS_ID) {
		this.PLCOND_POL_SYS_ID = PLCOND_POL_SYS_ID;
	}
	public Long getPLCOND_POL_SYS_ID() {
		 return PLCOND_POL_SYS_ID;
	}
	public void setPLCOND_UPD_UID(String PLCOND_UPD_UID) {
		this.PLCOND_UPD_UID = PLCOND_UPD_UID;
	}
	public String getPLCOND_UPD_UID() {
		 return PLCOND_UPD_UID;
	}

}
