package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROD_CASHBACK")
public class PM_IL_PROD_CASHBACK extends BaseValueBean {
	/*Added by saranya on 30/12/2016 for RM018T - FSD_IL_ZB Life_028-Cash Back*/
	@Column(name = "PCB_APPL_ON")
	private String PCB_APPL_ON;
	
	/* Modified PCB_PERC MAX LENGTH from Integer to Double by pidugu raj dt: 22-10-2020 as suggested by sivarajan for Alliance IL
	 * @Column(name = "PCB_PERC")
	private Integer PCB_PERC;*/
	
	@Column(name = "PCB_PERC")
	private Double PCB_PERC;
	
	@Column(name = "PCB_COMP_YRS")
	private Integer PCB_COMP_YRS;
	
	@Column(name = "PCB_PROD_CODE")
	private String PCB_PROD_CODE;
	
	@Column(name = "PCB_CR_UID")
	private String PCB_CR_UID;

	@Column(name = "PCB_CR_DT")
	private Date PCB_CR_DT;
	
	@Column(name = "PCB_UPD_UID")
	private String PCB_UPD_UID;
	
	@Column(name = "PCB_UPD_DT")
	private Date PCB_UPD_DT;

	public String getPCB_CR_UID() {
		return PCB_CR_UID;
	}

	public void setPCB_CR_UID(String pCB_CR_UID) {
		PCB_CR_UID = pCB_CR_UID;
	}

	public Date getPCB_CR_DT() {
		return PCB_CR_DT;
	}

	public void setPCB_CR_DT(Date pCB_CR_DT) {
		PCB_CR_DT = pCB_CR_DT;
	}

	public String getPCB_UPD_UID() {
		return PCB_UPD_UID;
	}

	public void setPCB_UPD_UID(String pCB_UPD_UID) {
		PCB_UPD_UID = pCB_UPD_UID;
	}

	public Date getPCB_UPD_DT() {
		return PCB_UPD_DT;
	}

	public void setPCB_UPD_DT(Date pCB_UPD_DT) {
		PCB_UPD_DT = pCB_UPD_DT;
	}

	public String getPCB_APPL_ON() {
		return PCB_APPL_ON;
	}

	public void setPCB_APPL_ON(String pCB_APPL_ON) {
		PCB_APPL_ON = pCB_APPL_ON;
	}

	/*public Integer getPCB_PERC() {
		return PCB_PERC;
	}

	public void setPCB_PERC(Integer pCB_PERC) {
		PCB_PERC = pCB_PERC;
	}*/
	
	public Double getPCB_PERC() {
		return PCB_PERC;
	}

	public void setPCB_PERC(Double pCB_PERC) {
		PCB_PERC = pCB_PERC;
	}
	/* End Modified PCB_PERC MAX LENGTH from Integer to Double by pidugu raj dt: 22-10-2020 as suggested by sivarajan for Alliance IL*/

	public Integer getPCB_COMP_YRS() {
		return PCB_COMP_YRS;
	}

	
	public void setPCB_COMP_YRS(Integer pCB_COMP_YRS) {
		PCB_COMP_YRS = pCB_COMP_YRS;
	}

	public String getPCB_PROD_CODE() {
		return PCB_PROD_CODE;
	}

	public void setPCB_PROD_CODE(String pCB_PROD_CODE) {
		PCB_PROD_CODE = pCB_PROD_CODE;
	}

	/*END*/
}
