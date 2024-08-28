package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_IL_POL_DISC_LOAD")
public class PT_IL_POL_DISC_LOAD extends BaseValueBean {

	@Column(name="PDL_SYS_ID")
	private Long PDL_SYS_ID;

	@Column(name="PDL_POL_SYS_ID")
	private Long PDL_POL_SYS_ID;

	@Column(name="PDL_SRNO")
	private Integer PDL_SRNO;

	@Column(name="PDL_DISC_LOAD_TYPE")
	private String PDL_DISC_LOAD_TYPE;

	@Column(name="PDL_DISC_LOAD_CODE")
	private String PDL_DISC_LOAD_CODE;

	@Column(name="PDL_APPLIED_ON")
	private String PDL_APPLIED_ON;

	@Column(name="PDL_COVER_CODE")
	private String PDL_COVER_CODE;

	@Column(name="PDL_APPLY_UPTO_SRNO")
	private Integer PDL_APPLY_UPTO_SRNO;

	@Column(name="PDL_RATE")
	private Double PDL_RATE;

	@Column(name="PDL_RATE_PER")
	private Double PDL_RATE_PER;

	@Column(name="PDL_FC_DISC_LOAD_VALUE")
	private Double PDL_FC_DISC_LOAD_VALUE;

	@Column(name="PDL_LC_DISC_LOAD_VALUE")
	private Double PDL_LC_DISC_LOAD_VALUE;

	@Column(name="PDL_ORG_FC_DISC_LOAD_VALUE")
	private Double PDL_ORG_FC_DISC_LOAD_VALUE;

	@Column(name="PDL_ORG_LC_DISC_LOAD_VALUE")
	private Double PDL_ORG_LC_DISC_LOAD_VALUE;

	@Column(name="PDL_DEL_FLAG")
	private String PDL_DEL_FLAG;

	@Column(name="PDL_CR_DT")
	private Date PDL_CR_DT;

	@Column(name="PDL_CR_UID")
	private String PDL_CR_UID;

	@Column(name="PDL_UPD_DT")
	private Date PDL_UPD_DT;

	@Column(name="PDL_UPD_UID")
	private String PDL_UPD_UID;

	@Column(name="PDL_APPL_PERC")
	private Double PDL_APPL_PERC;

	@Column(name="PDL_ORG_APPL_PERC")
	private Double PDL_ORG_APPL_PERC;

	private String UI_M_DISCLOAD_DESC;
	
	private String UI_M_DLCVR_DESC;
	
	private String PDL_APPLIED_ON_DESC;
	
	
	/*ADDED BY DHINESH 7.6.2016*/
	
	private String PDL_RATE_STR;
	private String PDL_FC_DISC_LOAD_VALUE_STR;
	
	
	public String getPDL_RATE_STR() {
		return PDL_RATE_STR;
	}
	public void setPDL_RATE_STR(String pDL_RATE_STR) {
		PDL_RATE_STR = pDL_RATE_STR;
	}
	public String getPDL_FC_DISC_LOAD_VALUE_STR() {
		return PDL_FC_DISC_LOAD_VALUE_STR;
	}
	public void setPDL_FC_DISC_LOAD_VALUE_STR(String pDL_FC_DISC_LOAD_VALUE_STR) {
		PDL_FC_DISC_LOAD_VALUE_STR = pDL_FC_DISC_LOAD_VALUE_STR;
	}
	
	/*END*/
	
	
	
	public String getPDL_APPLIED_ON_DESC() {
		return PDL_APPLIED_ON_DESC;
	}
	public void setPDL_APPLIED_ON_DESC(String pDL_APPLIED_ON_DESC) {
		PDL_APPLIED_ON_DESC = pDL_APPLIED_ON_DESC;
	}
	public void setPDL_APPL_PERC(Double PDL_APPL_PERC) {
		this.PDL_APPL_PERC = PDL_APPL_PERC;
	}
	public Double getPDL_APPL_PERC() {
		 return PDL_APPL_PERC;
	}
	public void setPDL_CR_UID(String PDL_CR_UID) {
		this.PDL_CR_UID = PDL_CR_UID;
	}
	public String getPDL_CR_UID() {
		 return PDL_CR_UID;
	}
	public void setPDL_DISC_LOAD_TYPE(String PDL_DISC_LOAD_TYPE) {
		this.PDL_DISC_LOAD_TYPE = PDL_DISC_LOAD_TYPE;
	}
	public String getPDL_DISC_LOAD_TYPE() {
		 return PDL_DISC_LOAD_TYPE;
	}
	public void setPDL_CR_DT(Date PDL_CR_DT) {
		this.PDL_CR_DT = PDL_CR_DT;
	}
	public Date getPDL_CR_DT() {
		 return PDL_CR_DT;
	}
	public void setPDL_ORG_LC_DISC_LOAD_VALUE(Double PDL_ORG_LC_DISC_LOAD_VALUE) {
		this.PDL_ORG_LC_DISC_LOAD_VALUE = PDL_ORG_LC_DISC_LOAD_VALUE;
	}
	public Double getPDL_ORG_LC_DISC_LOAD_VALUE() {
		 return PDL_ORG_LC_DISC_LOAD_VALUE;
	}
	public void setPDL_APPLY_UPTO_SRNO(Integer PDL_APPLY_UPTO_SRNO) {
		this.PDL_APPLY_UPTO_SRNO = PDL_APPLY_UPTO_SRNO;
	}
	public Integer getPDL_APPLY_UPTO_SRNO() {
		 return PDL_APPLY_UPTO_SRNO;
	}
	public void setPDL_ORG_FC_DISC_LOAD_VALUE(Double PDL_ORG_FC_DISC_LOAD_VALUE) {
		this.PDL_ORG_FC_DISC_LOAD_VALUE = PDL_ORG_FC_DISC_LOAD_VALUE;
	}
	public Double getPDL_ORG_FC_DISC_LOAD_VALUE() {
		 return PDL_ORG_FC_DISC_LOAD_VALUE;
	}
	public void setPDL_SRNO(Integer PDL_SRNO) {
		this.PDL_SRNO = PDL_SRNO;
	}
	public Integer getPDL_SRNO() {
		 return PDL_SRNO;
	}
	public void setPDL_UPD_DT(Date PDL_UPD_DT) {
		this.PDL_UPD_DT = PDL_UPD_DT;
	}
	public Date getPDL_UPD_DT() {
		 return PDL_UPD_DT;
	}
	public void setPDL_UPD_UID(String PDL_UPD_UID) {
		this.PDL_UPD_UID = PDL_UPD_UID;
	}
	public String getPDL_UPD_UID() {
		 return PDL_UPD_UID;
	}
	public void setPDL_SYS_ID(Long PDL_SYS_ID) {
		this.PDL_SYS_ID = PDL_SYS_ID;
	}
	public Long getPDL_SYS_ID() {
		 return PDL_SYS_ID;
	}
	public void setPDL_RATE(Double PDL_RATE) {
		this.PDL_RATE = PDL_RATE;
	}
	public Double getPDL_RATE() {
		 return PDL_RATE;
	}
	public void setUI_M_DISCLOAD_DESC(String UI_M_DISCLOAD_DESC) {
		this.UI_M_DISCLOAD_DESC = UI_M_DISCLOAD_DESC;
	}
	public String getUI_M_DISCLOAD_DESC() {
		 return UI_M_DISCLOAD_DESC;
	}
	public void setUI_M_DLCVR_DESC(String UI_M_DLCVR_DESC) {
		this.UI_M_DLCVR_DESC = UI_M_DLCVR_DESC;
	}
	public String getUI_M_DLCVR_DESC() {
		 return UI_M_DLCVR_DESC;
	}
	public void setPDL_DISC_LOAD_CODE(String PDL_DISC_LOAD_CODE) {
		this.PDL_DISC_LOAD_CODE = PDL_DISC_LOAD_CODE;
	}
	public String getPDL_DISC_LOAD_CODE() {
		 return PDL_DISC_LOAD_CODE;
	}
	public void setPDL_COVER_CODE(String PDL_COVER_CODE) {
		this.PDL_COVER_CODE = PDL_COVER_CODE;
	}
	public String getPDL_COVER_CODE() {
		 return PDL_COVER_CODE;
	}
	public void setPDL_RATE_PER(Double PDL_RATE_PER) {
		this.PDL_RATE_PER = PDL_RATE_PER;
	}
	public Double getPDL_RATE_PER() {
		 return PDL_RATE_PER;
	}
	public void setPDL_ORG_APPL_PERC(Double PDL_ORG_APPL_PERC) {
		this.PDL_ORG_APPL_PERC = PDL_ORG_APPL_PERC;
	}
	public Double getPDL_ORG_APPL_PERC() {
		 return PDL_ORG_APPL_PERC;
	}
	public void setPDL_FC_DISC_LOAD_VALUE(Double PDL_FC_DISC_LOAD_VALUE) {
		this.PDL_FC_DISC_LOAD_VALUE = PDL_FC_DISC_LOAD_VALUE;
	}
	public Double getPDL_FC_DISC_LOAD_VALUE() {
		 return PDL_FC_DISC_LOAD_VALUE;
	}
	public void setPDL_LC_DISC_LOAD_VALUE(Double PDL_LC_DISC_LOAD_VALUE) {
		this.PDL_LC_DISC_LOAD_VALUE = PDL_LC_DISC_LOAD_VALUE;
	}
	public Double getPDL_LC_DISC_LOAD_VALUE() {
		 return PDL_LC_DISC_LOAD_VALUE;
	}
	public void setPDL_APPLIED_ON(String PDL_APPLIED_ON) {
		this.PDL_APPLIED_ON = PDL_APPLIED_ON;
	}
	public String getPDL_APPLIED_ON() {
		 return PDL_APPLIED_ON;
	}
	public void setPDL_POL_SYS_ID(Long PDL_POL_SYS_ID) {
		this.PDL_POL_SYS_ID = PDL_POL_SYS_ID;
	}
	public Long getPDL_POL_SYS_ID() {
		 return PDL_POL_SYS_ID;
	}
	public void setPDL_DEL_FLAG(String PDL_DEL_FLAG) {
		this.PDL_DEL_FLAG = PDL_DEL_FLAG;
	}
	public String getPDL_DEL_FLAG() {
		 return PDL_DEL_FLAG;
	}

	/*Added by dhinesh 13.4.2016*/

	private Double POL_FC_SUM_ASSURED;

	public Double getPOL_FC_SUM_ASSURED() {
		return POL_FC_SUM_ASSURED;
	}
	public void setPOL_FC_SUM_ASSURED(Double pOL_FC_SUM_ASSURED) {
		POL_FC_SUM_ASSURED = pOL_FC_SUM_ASSURED;
	}
	//added by saranya
		@Column(name="PDL_EMR_RATE")
		private Double PDL_EMR_RATE;

		public Double getPDL_EMR_RATE() {
			return PDL_EMR_RATE;
		}
		public void setPDL_EMR_RATE(Double pDL_EMR_RATE) {
			PDL_EMR_RATE = pDL_EMR_RATE;
		}
		@Column(name="PDL_FLEX_01")
		private String PDL_FLEX_01;

		public String getPDL_FLEX_01() {
			return PDL_FLEX_01;
		}
		public void setPDL_FLEX_01(String PDL_FLEX_01) {
			this.PDL_FLEX_01 = PDL_FLEX_01;
		}
		
		
		//end
		
		/* Newly added By Dhinesh on 6-7-2017 */
		private String FIELD1_ENABLE;
		public String getFIELD1_ENABLE() {
			return FIELD1_ENABLE;
		}
		public void setFIELD1_ENABLE(String fIELD1_ENABLE) {
			FIELD1_ENABLE = fIELD1_ENABLE;
		}
		
		/* End */


		/*Added by Janani on 29.12.2017 for */
		
		@Column(name="PDL_FLEX_02")
		private String PDL_FLEX_02;


		public String getPDL_FLEX_02() {
			return PDL_FLEX_02;
		}
		public void setPDL_FLEX_02(String pDL_FLEX_02) {
			PDL_FLEX_02 = pDL_FLEX_02;
		}


		
		
		
		/*End*/
		
		/*Added by rakesh on 02-08-2019 for disc/loading applied*/
		@Column(name="PDL_LOAD_APPL_ON")
		private String PDL_LOAD_APPL_ON;


		public String getPDL_LOAD_APPL_ON() {
			return PDL_LOAD_APPL_ON;
		}
		public void setPDL_LOAD_APPL_ON(String pDL_LOAD_APPL_ON) {
			PDL_LOAD_APPL_ON = pDL_LOAD_APPL_ON;
		}

		//END
}
