package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_BROKER_DTL")
public class PT_IL_POL_BROKER_DTL extends BaseValueBean {

	@Column(name="POBD_SYS_ID")
	private Long POBD_SYS_ID;

	@Column(name="POBD_POBH_SYS_ID")
	private Long POBD_POBH_SYS_ID;

	@Column(name="POBD_YEAR_FROM")
	private Integer POBD_YEAR_FROM;

	@Column(name="POBD_YEAR_TO")
	private Integer POBD_YEAR_TO;

	@Column(name="POBD_DEL_FLAG")
	private String POBD_DEL_FLAG;

	@Column(name="POBD_CR_DT")
	private Date POBD_CR_DT;

	@Column(name="POBD_CR_UID")
	private String POBD_CR_UID;

	@Column(name="POBD_UPD_DT")
	private Date POBD_UPD_DT;

	@Column(name="POBD_UPD_UID")
	private String POBD_UPD_UID;

	@Column(name="POBD_RATE")
	private Double POBD_RATE;

	@Column(name="POBD_RATE_PER")
	private Double POBD_RATE_PER;

	//Thhis field is not available in DB
	
	/*@Column(name="POBD_RANK_CODE")
	private String POBD_RANK_CODE;*/

	/*public void setPOBD_RANK_CODE(String POBD_RANK_CODE) {
		this.POBD_RANK_CODE = POBD_RANK_CODE;
	}
	public String getPOBD_RANK_CODE() {
		 return POBD_RANK_CODE;
	}*/
	public void setPOBD_RATE(Double POBD_RATE) {
		this.POBD_RATE = POBD_RATE;
	}
	public Double getPOBD_RATE() {
		 return POBD_RATE;
	}
	public void setPOBD_DEL_FLAG(String POBD_DEL_FLAG) {
		this.POBD_DEL_FLAG = POBD_DEL_FLAG;
	}
	public String getPOBD_DEL_FLAG() {
		 return POBD_DEL_FLAG;
	}
	public void setPOBD_RATE_PER(Double POBD_RATE_PER) {
		this.POBD_RATE_PER = POBD_RATE_PER;
	}
	public Double getPOBD_RATE_PER() {
		 return POBD_RATE_PER;
	}
	public void setPOBD_CR_DT(Date POBD_CR_DT) {
		this.POBD_CR_DT = POBD_CR_DT;
	}
	public Date getPOBD_CR_DT() {
		 return POBD_CR_DT;
	}
	public void setPOBD_YEAR_TO(Integer POBD_YEAR_TO) {
		this.POBD_YEAR_TO = POBD_YEAR_TO;
	}
	public Integer getPOBD_YEAR_TO() {
		 return POBD_YEAR_TO;
	}
	public void setPOBD_POBH_SYS_ID(Long POBD_POBH_SYS_ID) {
		this.POBD_POBH_SYS_ID = POBD_POBH_SYS_ID;
	}
	public Long getPOBD_POBH_SYS_ID() {
		 return POBD_POBH_SYS_ID;
	}
	public void setPOBD_UPD_DT(Date POBD_UPD_DT) {
		this.POBD_UPD_DT = POBD_UPD_DT;
	}
	public Date getPOBD_UPD_DT() {
		 return POBD_UPD_DT;
	}
	public void setPOBD_SYS_ID(Long POBD_SYS_ID) {
		this.POBD_SYS_ID = POBD_SYS_ID;
	}
	public Long getPOBD_SYS_ID() {
		 return POBD_SYS_ID;
	}
	public void setPOBD_UPD_UID(String POBD_UPD_UID) {
		this.POBD_UPD_UID = POBD_UPD_UID;
	}
	public String getPOBD_UPD_UID() {
		 return POBD_UPD_UID;
	}
	public void setPOBD_CR_UID(String POBD_CR_UID) {
		this.POBD_CR_UID = POBD_CR_UID;
	}
	public String getPOBD_CR_UID() {
		 return POBD_CR_UID;
	}
	public void setPOBD_YEAR_FROM(Integer POBD_YEAR_FROM) {
		this.POBD_YEAR_FROM = POBD_YEAR_FROM;
	}
	public Integer getPOBD_YEAR_FROM() {
		 return POBD_YEAR_FROM;
	}
	
	
	/* Newly added By Dhinesh on 26-06-2017 */
	@Column(name="POBD_COMM_CODE")
	private String POBD_COMM_CODE;

	public String getPOBD_COMM_CODE() {
		return POBD_COMM_CODE;
	}
	public void setPOBD_COMM_CODE(String pOBD_COMM_CODE) {
		POBD_COMM_CODE = pOBD_COMM_CODE;
	}	
	
	
	
	/* End */

}
