package com.iii.pel.forms.PILM033;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PREM_INTEREST")
public class PM_IL_PREM_INTEREST extends BaseValueBean {

	@Column(name = "PI_MOP")
	private String PI_MOP;

	@Column(name = "PI_UPTO_MNTH")
	private Double PI_UPTO_MNTH;

	@Column(name = "PI_UPTO_DAYS")
	private Double PI_UPTO_DAYS;

	@Column(name = "PI_RATE")
	private Double PI_RATE;

	@Column(name = "PI_RATE_PER")
	private Double PI_RATE_PER;

	@Column(name = "PI_EFF_FM_DT")
	private Date PI_EFF_FM_DT;

	@Column(name = "PI_EFF_TO_DT")
	private Date PI_EFF_TO_DT;

	@Column(name = "PI_CR_DT")
	private Date PI_CR_DT;

	@Column(name = "PI_CR_UID")
	private String PI_CR_UID;

	@Column(name = "PI_UPD_DT")
	private Date PI_UPD_DT;

	@Column(name = "PI_UPD_UID")
	private String PI_UPD_UID;

	public void setPI_CR_UID(String PI_CR_UID) {
		this.PI_CR_UID = PI_CR_UID;
	}

	public String getPI_CR_UID() {
		return PI_CR_UID;
	}

	public void setPI_EFF_FM_DT(Date PI_EFF_FM_DT) {
		this.PI_EFF_FM_DT = PI_EFF_FM_DT;
	}

	public Date getPI_EFF_FM_DT() {
		return PI_EFF_FM_DT;
	}

	public void setPI_MOP(String PI_MOP) {
		this.PI_MOP = PI_MOP;
	}

	public String getPI_MOP() {
		return PI_MOP;
	}

	public void setPI_UPD_DT(Date PI_UPD_DT) {
		this.PI_UPD_DT = PI_UPD_DT;
	}

	public Date getPI_UPD_DT() {
		return PI_UPD_DT;
	}

	public void setPI_RATE(Double PI_RATE) {
		this.PI_RATE = PI_RATE;
	}

	public Double getPI_RATE() {
		return PI_RATE;
	}

	public void setPI_UPTO_DAYS(Double PI_UPTO_DAYS) {
		this.PI_UPTO_DAYS = PI_UPTO_DAYS;
	}

	public Double getPI_UPTO_DAYS() {
		return PI_UPTO_DAYS;
	}

	public void setPI_UPD_UID(String PI_UPD_UID) {
		this.PI_UPD_UID = PI_UPD_UID;
	}

	public String getPI_UPD_UID() {
		return PI_UPD_UID;
	}

	public void setPI_EFF_TO_DT(Date PI_EFF_TO_DT) {
		this.PI_EFF_TO_DT = PI_EFF_TO_DT;
	}

	public Date getPI_EFF_TO_DT() {
		return PI_EFF_TO_DT;
	}

	public void setPI_RATE_PER(Double PI_RATE_PER) {
		this.PI_RATE_PER = PI_RATE_PER;
	}

	public Double getPI_RATE_PER() {
		return PI_RATE_PER;
	}

	public void setPI_UPTO_MNTH(Double PI_UPTO_MNTH) {
		this.PI_UPTO_MNTH = PI_UPTO_MNTH;
	}

	public Double getPI_UPTO_MNTH() {
		return PI_UPTO_MNTH;
	}

	public void setPI_CR_DT(Date PI_CR_DT) {
		this.PI_CR_DT = PI_CR_DT;
	}

	public Date getPI_CR_DT() {
		return PI_CR_DT;
	}

}