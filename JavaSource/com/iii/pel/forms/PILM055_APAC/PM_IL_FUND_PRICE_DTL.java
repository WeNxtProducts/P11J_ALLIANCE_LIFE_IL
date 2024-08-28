package com.iii.pel.forms.PILM055_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PM_IL_FUND_PRICE_DTL")
public class PM_IL_FUND_PRICE_DTL extends BaseValueBean {

	@Column(name="FPD_SELL_UNIT_RATE")
	private Double FPD_SELL_UNIT_RATE;

	@Column(name="FPD_BUY_UNIT_RATE")
	private Double FPD_BUY_UNIT_RATE;

	@Column(name="FPD_UNIT_RATE_PER")
	private Double FPD_UNIT_RATE_PER;

	@Column(name="FPD_EFF_FM_DT")
	private Date FPD_EFF_FM_DT;

	@Column(name="FPD_EFF_TO_DT")
	private Date FPD_EFF_TO_DT;
	
		
	private boolean CHECK_BOX;
	
	@Id
	@Column(name="ROWID") 
	private String ROWID;
	
	@Column(name="FPD_CR_UID")
	private String FPD_CR_UID;
	
	@Column(name="FPD_CR_DT")
	private Date FPD_CR_DT;
	
	@Column(name="FPD_FS_CODE")
	private String FPD_FS_CODE; 
	
	private String UI_FPD_EFF_FM_DT;
	private String UI_FPD_EFF_TO_DT;



	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}

	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}

	public Double getFPD_SELL_UNIT_RATE() {
		return FPD_SELL_UNIT_RATE;
	}

	public void setFPD_SELL_UNIT_RATE(Double FPD_SELL_UNIT_RATE) {
		this.FPD_SELL_UNIT_RATE = FPD_SELL_UNIT_RATE;
	}

	public Double getFPD_BUY_UNIT_RATE() {
		return FPD_BUY_UNIT_RATE;
	}

	public void setFPD_BUY_UNIT_RATE(Double FPD_BUY_UNIT_RATE) {
		System.out.println("PM_IL_FUND_PRICE_DTL.setFPD_BUY_UNIT_RATE()-FPD_BUY_UNIT_RATE"+FPD_BUY_UNIT_RATE);
		this.FPD_BUY_UNIT_RATE = FPD_BUY_UNIT_RATE;
	}

	public Double getFPD_UNIT_RATE_PER() {
		return FPD_UNIT_RATE_PER;
	}

	public void setFPD_UNIT_RATE_PER(Double FPD_UNIT_RATE_PER) {
		this.FPD_UNIT_RATE_PER = FPD_UNIT_RATE_PER;
	}

	public Date getFPD_EFF_FM_DT() {
		 return FPD_EFF_FM_DT;
	}

	public void setFPD_EFF_FM_DT(Date FPD_EFF_FM_DT) {
		setUI_FPD_EFF_FM_DT(CommonUtils.dateToPELStringFormatter(FPD_EFF_FM_DT )); 
		this.FPD_EFF_FM_DT = FPD_EFF_FM_DT;
	}

	public Date getFPD_EFF_TO_DT() {
		 return FPD_EFF_TO_DT;
	}

	public void setFPD_EFF_TO_DT(Date FPD_EFF_TO_DT) {
		setUI_FPD_EFF_TO_DT(CommonUtils.dateToPELStringFormatter(FPD_EFF_TO_DT));
		this.FPD_EFF_TO_DT = FPD_EFF_TO_DT;
	}

	public String getFPD_CR_UID() {
		return FPD_CR_UID;
	}

	public void setFPD_CR_UID(String fpd_cr_uid) {
		FPD_CR_UID = fpd_cr_uid;
	}

	public Date getFPD_CR_DT() {
		return FPD_CR_DT;
	}

	public void setFPD_CR_DT(Date fpd_cr_dt) {
		FPD_CR_DT = fpd_cr_dt;
	}

	public String getFPD_FS_CODE() {
		return FPD_FS_CODE;
	}

	public void setFPD_FS_CODE(String fpd_fs_code) {
		System.out.println("PM_IL_FUND_PRICE_DTL.setFPD_FS_CODE()-1111111"+fpd_fs_code);
		FPD_FS_CODE = fpd_fs_code;
	}

	public String getUI_FPD_EFF_FM_DT() {
		return UI_FPD_EFF_FM_DT;
	}

	public void setUI_FPD_EFF_FM_DT(String ui_fpd_eff_fm_dt) {
		UI_FPD_EFF_FM_DT = ui_fpd_eff_fm_dt;
	}

	public String getUI_FPD_EFF_TO_DT() {
		return UI_FPD_EFF_TO_DT;
	}

	public void setUI_FPD_EFF_TO_DT(String ui_fpd_eff_to_dt) {
		UI_FPD_EFF_TO_DT = ui_fpd_eff_to_dt;
	}
	/*Added by saranya for  Fund unit price allocation - Hands on point on 27-02-2017*/
	@Column(name="FPD_APPRV_FLAG")
	private String FPD_APPRV_FLAG;

	public String getFPD_APPRV_FLAG() {
		return FPD_APPRV_FLAG;
	}

	public void setFPD_APPRV_FLAG(String fPD_APPRV_FLAG) {
		FPD_APPRV_FLAG = fPD_APPRV_FLAG;
	}
	
	@Column(name="FPD_APPRV_DT")
	private Date FPD_APPRV_DT;

	public Date getFPD_APPRV_DT() {
		return FPD_APPRV_DT;
	}

	public void setFPD_APPRV_DT(Date fPD_APPRV_DT) {
		FPD_APPRV_DT = fPD_APPRV_DT;
	}
	@Column(name="FPD_UPD_DT")
	private Date FPD_UPD_DT;

	@Column(name="FPD_UPD_UID")
	private String FPD_UPD_UID;

	public Date getFPD_UPD_DT() {
		return FPD_UPD_DT;
	}

	public void setFPD_UPD_DT(Date fPD_UPD_DT) {
		FPD_UPD_DT = fPD_UPD_DT;
	}

	public String getFPD_UPD_UID() {
		return FPD_UPD_UID;
	}

	public void setFPD_UPD_UID(String fPD_UPD_UID) {
		FPD_UPD_UID = fPD_UPD_UID;
	}
	
	/*End*/
	
	/*Added by saritha on 29-03-2018 for KIC Rates to be captured under unit details to be Bid price(buy), Offer price(sell) and unit price. 
	 *The Unit price rate capturing provision to be required. This will be revised whenever buy and sell rate change
	 *
	 */
	
	@Column(name="FPD_UNIT_PRICE_RATE")
	private Double FPD_UNIT_PRICE_RATE;

	public Double getFPD_UNIT_PRICE_RATE() {
		return FPD_UNIT_PRICE_RATE;
	}

	public void setFPD_UNIT_PRICE_RATE(Double fPD_UNIT_PRICE_RATE) {
		FPD_UNIT_PRICE_RATE = fPD_UNIT_PRICE_RATE;
	}

	
	
	

	/*End*/

	
}
