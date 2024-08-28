package com.iii.pel.forms.PILM035_APAC;
import java.util.Date;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name = "PM_IL_PROD_INTREST")
public class PM_IL_PROD_INTREST extends BaseValueBean  {
	@Column(name = "PRI_PROD_CODE")
	private String PRI_PROD_CODE;	
	@Column(name = "PRI_RATE")
	private Integer PRI_RATE;	
	@Column(name = "PRI_RATE_PER")
	private Integer PRI_RATE_PER;	
	@Column(name = "PRI_EFF_FM_DT")
	private Date PRI_EFF_FM_DT;	
	@Column(name = "PRI_EFF_TO_DT")
	private Date PRI_EFF_TO_DT;		
	@Column(name = "PRI_CR_DT")
	private Date PRI_CR_DT;	
	@Column(name = "PRI_CR_UID")
	private String PRI_CR_UID;		
	@Column(name = "PRI_UPD_DT")
	private Date PRI_UPD_DT;
	@Column(name = "PRI_UPD_UID")
	private String PRI_UPD_UID;
	public String getPRI_PROD_CODE() {
		return PRI_PROD_CODE;
	}
	public void setPRI_PROD_CODE(String pRI_PROD_CODE) {
		PRI_PROD_CODE = pRI_PROD_CODE;
	}
	public Integer getPRI_RATE() {
		return PRI_RATE;
	}
	public void setPRI_RATE(Integer pRI_RATE) {
		PRI_RATE = pRI_RATE;
	}
	public Integer getPRI_RATE_PER() {
		return PRI_RATE_PER;
	}
	public void setPRI_RATE_PER(Integer pRI_RATE_PER) {
		PRI_RATE_PER = pRI_RATE_PER;
	}
	public Date getPRI_EFF_FM_DT() {
		return PRI_EFF_FM_DT;
	}
	public void setPRI_EFF_FM_DT(Date pRI_EFF_FM_DT) {
		PRI_EFF_FM_DT = pRI_EFF_FM_DT;
	}
	public Date getPRI_EFF_TO_DT() {
		return PRI_EFF_TO_DT;
	}
	public void setPRI_EFF_TO_DT(Date pRI_EFF_TO_DT) {
		PRI_EFF_TO_DT = pRI_EFF_TO_DT;
	}
	public Date getPRI_CR_DT() {
		return PRI_CR_DT;
	}
	public void setPRI_CR_DT(Date pRI_CR_DT) {
		PRI_CR_DT = pRI_CR_DT;
	}
	public String getPRI_CR_UID() {
		return PRI_CR_UID;
	}
	public void setPRI_CR_UID(String pRI_CR_UID) {
		PRI_CR_UID = pRI_CR_UID;
	}
	public Date getPRI_UPD_DT() {
		return PRI_UPD_DT;
	}
	public void setPRI_UPD_DT(Date pRI_UPD_DT) {
		PRI_UPD_DT = pRI_UPD_DT;
	}
	public String getPRI_UPD_UID() {
		return PRI_UPD_UID;
	}
	public void setPRI_UPD_UID(String pRI_UPD_UID) {
		PRI_UPD_UID = pRI_UPD_UID;
	}	
	
	
	
	
	

}
