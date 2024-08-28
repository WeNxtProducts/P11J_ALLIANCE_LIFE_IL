package com.iii.pel.forms.PILM013_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_DOC_DFLT_CHARGE")
public class PM_IL_DOC_DFLT_CHARGE extends BaseValueBean {

	@Column(name="DDCHG_SR_NO")
	private Integer DDCHG_SR_NO;

	@Column(name="DDCHG_CODE")
	private String DDCHG_CODE;

	@Column(name="DDCHG_RATE")
	private Double DDCHG_RATE;

	@Column(name="DDCHG_RATE_PER")
	private Double DDCHG_RATE_PER;

	@Column(name="DDCHG_APPLIED_ON")
	private String DDCHG_APPLIED_ON;

	@Column(name="DDCHG_CUST_SHARE_PERC")
	private Double DDCHG_CUST_SHARE_PERC;

	@Column(name="DDCHG_APPLY_PERIOD")
	private String DDCHG_APPLY_PERIOD;

	@Column(name="DDCHG_EFF_FM_DT")
	private Date DDCHG_EFF_FM_DT;

	@Column(name="DDCHG_EFF_TO_DT")
	private Date DDCHG_EFF_TO_DT;
	
	@Column(name="DDCHG_DS_TYPE")
	private String DDCHG_DS_TYPE;
	
	@Column(name="DDCHG_DS_CODE")
	private String DDCHG_DS_CODE;

	private String UI_M_DDCHG_CODE_DESC;
	
	@Column(name="DDCHG_CR_DT")
	private Date DDCHG_CR_DT;
	
	@Column(name="DDCHG_CR_UID")
	private String DDCHG_CR_UID;

	private boolean CHECKBOX;
	
	private double UI_M_SR_NO;
	
	@Column(name="DDCHG_DS_CHG_TAR_CODE")
	private String DDCHG_DS_CHG_TAR_CODE;
	
	/*Newly added by pidugu raj dt: 24-09-2018 as suggested by vaitheeswaran and sivaraman*/
	@Column(name="DDCHG_CHARGE_MAX_LMT")
	private int DDCHG_CHARGE_MAX_LMT;
	/*End Newly added by pidugu raj dt: 24-09-2018 as suggested by vaitheeswaran and sivaraman*/	
	
	/*added by janani on 18.3.2016
	
	
	@Column(name="DDCHG_PROD_CODE_FM")
	private String DDCHG_PROD_CODE_FM;

	
	@Column(name="DDCHG_PROD_CODE_TO ")
	private String DDCHG_PROD_CODE_TO ;
	
	
	private String UI_M_DDCHG_PROD_CODE_FM_DESC;
	
	private String UI_M_DDCHG_PROD_CODE_TO_DESC;
		
	
	public String getUI_M_DDCHG_PROD_CODE_FM_DESC() {
		return UI_M_DDCHG_PROD_CODE_FM_DESC;
	}

	public void setUI_M_DDCHG_PROD_CODE_FM_DESC(String uI_M_DDCHG_PROD_CODE_FM_DESC) {
		UI_M_DDCHG_PROD_CODE_FM_DESC = uI_M_DDCHG_PROD_CODE_FM_DESC;
	}

	public String getUI_M_DDCHG_PROD_CODE_TO_DESC() {
		return UI_M_DDCHG_PROD_CODE_TO_DESC;
	}

	public void setUI_M_DDCHG_PROD_CODE_TO_DESC(String uI_M_DDCHG_PROD_CODE_TO_DESC) {
		UI_M_DDCHG_PROD_CODE_TO_DESC = uI_M_DDCHG_PROD_CODE_TO_DESC;
	}

	public String getDDCHG_PROD_CODE_FM() {
		return DDCHG_PROD_CODE_FM;
	}

	public void setDDCHG_PROD_CODE_FM(String dDCHG_PROD_CODE_FM) {
		DDCHG_PROD_CODE_FM = dDCHG_PROD_CODE_FM;
	}

	public String getDDCHG_PROD_CODE_TO() {
		return DDCHG_PROD_CODE_TO;
	}

	public void setDDCHG_PROD_CODE_TO(String dDCHG_PROD_CODE_TO) {
		DDCHG_PROD_CODE_TO = dDCHG_PROD_CODE_TO;
	}

	
	end
	*/
	/*Newly added by pidugu raj dt: 24-09-2018 as suggested by vaitheeswaran and sivaraman*/
	public int getDDCHG_CHARGE_MAX_LMT() {
		return DDCHG_CHARGE_MAX_LMT;
	}

	public void setDDCHG_CHARGE_MAX_LMT(int dDCHG_CHARGE_MAX_LMT) {
		DDCHG_CHARGE_MAX_LMT = dDCHG_CHARGE_MAX_LMT;
	}
	/*End Newly added by pidugu raj dt: 24-09-2018 as suggested by vaitheeswaran and sivaraman*/
	
	public Integer getDDCHG_SR_NO() {
		return DDCHG_SR_NO;
	}

	

	public void setDDCHG_SR_NO(Integer ddchg_sr_no) {
		DDCHG_SR_NO = ddchg_sr_no;
	}

	public String getDDCHG_CODE() {
		return DDCHG_CODE;
	}

	public void setDDCHG_CODE(String DDCHG_CODE) {
		this.DDCHG_CODE = DDCHG_CODE;
	}

	public Double getDDCHG_RATE() {
		return DDCHG_RATE;
	}

	public void setDDCHG_RATE(Double DDCHG_RATE) {
		this.DDCHG_RATE = DDCHG_RATE;
	}

	public Double getDDCHG_RATE_PER() {
		return DDCHG_RATE_PER;
	}

	public void setDDCHG_RATE_PER(Double DDCHG_RATE_PER) {
		this.DDCHG_RATE_PER = DDCHG_RATE_PER;
	}

	public String getDDCHG_APPLIED_ON() {
		return DDCHG_APPLIED_ON;
	}

	public void setDDCHG_APPLIED_ON(String DDCHG_APPLIED_ON) {
		this.DDCHG_APPLIED_ON = DDCHG_APPLIED_ON;
	}

	public Double getDDCHG_CUST_SHARE_PERC() {
		return DDCHG_CUST_SHARE_PERC;
	}

	public void setDDCHG_CUST_SHARE_PERC(Double DDCHG_CUST_SHARE_PERC) {
		this.DDCHG_CUST_SHARE_PERC = DDCHG_CUST_SHARE_PERC;
	}

	public String getDDCHG_APPLY_PERIOD() {
		return DDCHG_APPLY_PERIOD;
	}

	public void setDDCHG_APPLY_PERIOD(String DDCHG_APPLY_PERIOD) {
		this.DDCHG_APPLY_PERIOD = DDCHG_APPLY_PERIOD;
	}

	public Date getDDCHG_EFF_FM_DT() {
		 return DDCHG_EFF_FM_DT;
	}

	public void setDDCHG_EFF_FM_DT(Date DDCHG_EFF_FM_DT) {
		this.DDCHG_EFF_FM_DT = DDCHG_EFF_FM_DT;
	}

	public Date getDDCHG_EFF_TO_DT() {
		 return DDCHG_EFF_TO_DT;
	}

	public void setDDCHG_EFF_TO_DT(Date DDCHG_EFF_TO_DT) {
		this.DDCHG_EFF_TO_DT = DDCHG_EFF_TO_DT;
	}

	public String getUI_M_DDCHG_CODE_DESC() {
		return UI_M_DDCHG_CODE_DESC;
	}

	public void setUI_M_DDCHG_CODE_DESC(String UI_M_DDCHG_CODE_DESC) {
		this.UI_M_DDCHG_CODE_DESC = UI_M_DDCHG_CODE_DESC;
	}

	public boolean isCHECKBOX() {
		return CHECKBOX;
	}

	public void setCHECKBOX(boolean checkbox) {
		CHECKBOX = checkbox;
	}

	public String getDDCHG_DS_TYPE() {
		return DDCHG_DS_TYPE;
	}

	public void setDDCHG_DS_TYPE(String ddchg_ds_type) {
		DDCHG_DS_TYPE = ddchg_ds_type;
	}

	public String getDDCHG_DS_CODE() {
		return DDCHG_DS_CODE;
	}

	public void setDDCHG_DS_CODE(String ddchg_ds_code) {
		DDCHG_DS_CODE = ddchg_ds_code;
	}

	public Date getDDCHG_CR_DT() {
		return DDCHG_CR_DT;
	}

	public void setDDCHG_CR_DT(Date ddchg_cr_dt) {
		DDCHG_CR_DT = ddchg_cr_dt;
	}

	public String getDDCHG_CR_UID() {
		return DDCHG_CR_UID;
	}

	public void setDDCHG_CR_UID(String ddchg_cr_uid) {
		DDCHG_CR_UID = ddchg_cr_uid;
	}

	public double getUI_M_SR_NO() {
		return UI_M_SR_NO;
	}

	public void setUI_M_SR_NO(double ui_m_sr_no) {
		UI_M_SR_NO = ui_m_sr_no;
	}

	public String getDDCHG_DS_CHG_TAR_CODE() {
		return DDCHG_DS_CHG_TAR_CODE;
	}

	public void setDDCHG_DS_CHG_TAR_CODE(String ddchg_ds_chg_tar_code) {
		DDCHG_DS_CHG_TAR_CODE = ddchg_ds_chg_tar_code;
	}
	
	/*Added by Raja on 18-3-2016 for Product Code From and To field addtion*/
	
	//added by raja
		@Column(name="DDCHG_PROD_CODE_FM")
		private String DDCHG_PROD_CODE_FM;
		
		private String DDCHG_PROD_CODE_FM_DESC;

		public String getDDCHG_PROD_CODE_FM_DESC() {
			return DDCHG_PROD_CODE_FM_DESC;
		}

		public void setDDCHG_PROD_CODE_FM_DESC(String dDCHG_PROD_CODE_FM_DESC) {
			DDCHG_PROD_CODE_FM_DESC = dDCHG_PROD_CODE_FM_DESC;
		}





		public String getDDCHG_PROD_CODE_FM() {
			return DDCHG_PROD_CODE_FM;
		}

		public void setDDCHG_PROD_CODE_FM(String dDCHG_PROD_CODE_FM) {
			DDCHG_PROD_CODE_FM = dDCHG_PROD_CODE_FM;
		}


		public void add(PM_IL_DOC_DFLT_CHARGE listBean) {
			// TODO Auto-generated method stub
			
		}

		



			@Column(name="DDCHG_PROD_CODE_TO")
			private String DDCHG_PROD_CODE_TO;
			private String  DDCHG_PROD_CODE_TO_DESC;
			public String getDDCHG_PROD_CODE_TO_DESC() {
				return DDCHG_PROD_CODE_TO_DESC;
			}

			public void setDDCHG_PROD_CODE_TO_DESC(String dDCHG_PROD_CODE_TO_DESC) {
				DDCHG_PROD_CODE_TO_DESC = dDCHG_PROD_CODE_TO_DESC;
			}

			public String getDDCHG_PROD_CODE_TO() {
				return DDCHG_PROD_CODE_TO;
			}

			public void setDDCHG_PROD_CODE_TO(String dDCHG_PROD_CODE_TO) {
				DDCHG_PROD_CODE_TO = dDCHG_PROD_CODE_TO;
		
	}
			/*End*/
	
}
