package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_TOP_UP_CHARGE")
public class PM_IL_TOP_UP_CHARGE extends BaseValueBean{

	@Column(name="TUC_PROD_CODE")
	private String TUC_PROD_CODE;

	@Column(name="TUC_AMT_LC_FROM")
	private Double TUC_AMT_LC_FROM;

	@Column(name="TUC_AMT_LC_TO")
	private Double TUC_AMT_LC_TO;

	@Column(name="TUC_RATE")
	private Double TUC_RATE;

	@Column(name="TUC_RATE_PER")
	private Integer TUC_RATE_PER;

	@Column(name="TUC_EFF_FM_DT")
	private Date TUC_EFF_FM_DT;

	@Column(name="TUC_EFF_TO_DT")
	private Date TUC_EFF_TO_DT;

	@Column(name="TUC_CR_DT")
	private Date TUC_CR_DT;

	@Column(name="TUC_CR_UID")
	private String TUC_CR_UID;

	@Column(name="TUC_UPD_DT")
	private Date TUC_UPD_DT;

	@Column(name="TUC_UPD_UID")
	private String TUC_UPD_UID;



	public String getTUC_PROD_CODE() {
		 return TUC_PROD_CODE;
	}

	public void setTUC_PROD_CODE(String TUC_PROD_CODE) {
		this.TUC_PROD_CODE = TUC_PROD_CODE;
	}

	public Double getTUC_AMT_LC_FROM() {
		 return TUC_AMT_LC_FROM;
	}

	public void setTUC_AMT_LC_FROM(Double TUC_AMT_LC_FROM) {
		this.TUC_AMT_LC_FROM = TUC_AMT_LC_FROM;
	}

	public Double getTUC_AMT_LC_TO() {
		 return TUC_AMT_LC_TO;
	}

	public void setTUC_AMT_LC_TO(Double TUC_AMT_LC_TO) {
		this.TUC_AMT_LC_TO = TUC_AMT_LC_TO;
	}

	public Double getTUC_RATE() {
		 return TUC_RATE;
	}

	public void setTUC_RATE(Double TUC_RATE) {
		this.TUC_RATE = TUC_RATE;
	}

	
	public Integer getTUC_RATE_PER() {
		return TUC_RATE_PER;
	}

	public void setTUC_RATE_PER(Integer tuc_rate_per) {
		TUC_RATE_PER = tuc_rate_per;
	}

	public Date getTUC_EFF_FM_DT() {
		 return TUC_EFF_FM_DT;
	}

	public void setTUC_EFF_FM_DT(Date TUC_EFF_FM_DT) {
		this.TUC_EFF_FM_DT = TUC_EFF_FM_DT;
	}

	public Date getTUC_EFF_TO_DT() {
		 return TUC_EFF_TO_DT;
	}

	public void setTUC_EFF_TO_DT(Date TUC_EFF_TO_DT) {
		this.TUC_EFF_TO_DT = TUC_EFF_TO_DT;
	}

	public Date getTUC_CR_DT() {
		 return TUC_CR_DT;
	}

	public void setTUC_CR_DT(Date TUC_CR_DT) {
		this.TUC_CR_DT = TUC_CR_DT;
	}

	public String getTUC_CR_UID() {
		 return TUC_CR_UID;
	}

	public void setTUC_CR_UID(String TUC_CR_UID) {
		this.TUC_CR_UID = TUC_CR_UID;
	}

	public Date getTUC_UPD_DT() {
		 return TUC_UPD_DT;
	}

	public void setTUC_UPD_DT(Date TUC_UPD_DT) {
		this.TUC_UPD_DT = TUC_UPD_DT;
	}

	public String getTUC_UPD_UID() {
		 return TUC_UPD_UID;
	}

	public void setTUC_UPD_UID(String TUC_UPD_UID) {
		this.TUC_UPD_UID = TUC_UPD_UID;
	}

	
}
