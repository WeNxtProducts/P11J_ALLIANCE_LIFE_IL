package com.iii.pel.forms.PILM007;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_IL_CLM_LATE_FEE")
public class PM_IL_CLM_LATE_FEE extends BaseValueBean {

		@Column(name="CLF_COVER_CODE")
		private String CLF_COVER_CODE;

		@Column(name="CLF_LOSS_TYPE")
		private String CLF_LOSS_TYPE;

		@Column(name="CLF_DISABLE_TYPE")
		private String CLF_DISABLE_TYPE;

		@Column(name="CLF_NO_FM_DAYS")
		private Integer CLF_NO_FM_DAYS;

		@Column(name="CLF_NO_TO_DAYS")
		private Integer CLF_NO_TO_DAYS;

		@Column(name="CLF_RATE")
		private Double CLF_RATE;

		@Column(name="CLF_RATE_PER")
		private Double CLF_RATE_PER;

		@Column(name="CLF_MIN_LC_AMT")
		private Double CLF_MIN_LC_AMT;

		@Column(name="CLF_MAX_LC_AMT")
		private Double CLF_MAX_LC_AMT;

		@Column(name="CLF_EFF_FM_DT")
		private Date CLF_EFF_FM_DT;

		@Column(name="CLF_EFF_TO_DT")
		private Date CLF_EFF_TO_DT;

		@Column(name="CLF_CR_UID")
		private String CLF_CR_UID;

		@Column(name="CLF_CR_DT")
		private Date CLF_CR_DT;

		@Column(name="CLF_UPD_UID")
		private String CLF_UPD_UID;

		@Column(name="CLF_UPD_DT")
		private Date CLF_UPD_DT;



		public String getCLF_COVER_CODE() {
			 return CLF_COVER_CODE;
		}

		public void setCLF_COVER_CODE(String CLF_COVER_CODE) {
			this.CLF_COVER_CODE = CLF_COVER_CODE;
		}

		public String getCLF_LOSS_TYPE() {
			 return CLF_LOSS_TYPE;
		}

		public void setCLF_LOSS_TYPE(String CLF_LOSS_TYPE) {
			this.CLF_LOSS_TYPE = CLF_LOSS_TYPE;
		}

		public String getCLF_DISABLE_TYPE() {
			 return CLF_DISABLE_TYPE;
		}

		public void setCLF_DISABLE_TYPE(String CLF_DISABLE_TYPE) {
			this.CLF_DISABLE_TYPE = CLF_DISABLE_TYPE;
		}

		public Integer getCLF_NO_FM_DAYS() {
			 return CLF_NO_FM_DAYS;
		}

		public void setCLF_NO_FM_DAYS(Integer CLF_NO_FM_DAYS) {
			this.CLF_NO_FM_DAYS = CLF_NO_FM_DAYS;
		}

		public Integer getCLF_NO_TO_DAYS() {
			 return CLF_NO_TO_DAYS;
		}

		public void setCLF_NO_TO_DAYS(Integer CLF_NO_TO_DAYS) {
			this.CLF_NO_TO_DAYS = CLF_NO_TO_DAYS;
		}

		public Double getCLF_RATE() {
			 return CLF_RATE;
		}

		public void setCLF_RATE(Double CLF_RATE) {
			this.CLF_RATE = CLF_RATE;
		}

		public Double getCLF_RATE_PER() {
			 return CLF_RATE_PER;
		}

		public void setCLF_RATE_PER(Double CLF_RATE_PER) {
			this.CLF_RATE_PER = CLF_RATE_PER;
		}

		public Double getCLF_MIN_LC_AMT() {
			 return CLF_MIN_LC_AMT;
		}

		public void setCLF_MIN_LC_AMT(Double CLF_MIN_LC_AMT) {
			this.CLF_MIN_LC_AMT = CLF_MIN_LC_AMT;
		}

		public Double getCLF_MAX_LC_AMT() {
			 return CLF_MAX_LC_AMT;
		}

		public void setCLF_MAX_LC_AMT(Double CLF_MAX_LC_AMT) {
			this.CLF_MAX_LC_AMT = CLF_MAX_LC_AMT;
		}

		public Date getCLF_EFF_FM_DT() {
			 return CLF_EFF_FM_DT;
		}

		public void setCLF_EFF_FM_DT(Date CLF_EFF_FM_DT) {
			this.CLF_EFF_FM_DT = CLF_EFF_FM_DT;
		}

		public Date getCLF_EFF_TO_DT() {
			 return CLF_EFF_TO_DT;
		}

		public void setCLF_EFF_TO_DT(Date CLF_EFF_TO_DT) {
			this.CLF_EFF_TO_DT = CLF_EFF_TO_DT;
		}

		public String getCLF_CR_UID() {
			 return CLF_CR_UID;
		}

		public void setCLF_CR_UID(String CLF_CR_UID) {
			this.CLF_CR_UID = CLF_CR_UID;
		}

		public Date getCLF_CR_DT() {
			 return CLF_CR_DT;
		}

		public void setCLF_CR_DT(Date CLF_CR_DT) {
			this.CLF_CR_DT = CLF_CR_DT;
		}

		public String getCLF_UPD_UID() {
			 return CLF_UPD_UID;
		}

		public void setCLF_UPD_UID(String CLF_UPD_UID) {
			this.CLF_UPD_UID = CLF_UPD_UID;
		}

		public Date getCLF_UPD_DT() {
			 return CLF_UPD_DT;
		}

		public void setCLF_UPD_DT(Date CLF_UPD_DT) {
			this.CLF_UPD_DT = CLF_UPD_DT;
		}
		
	/*Added by saritha on 30-Dec-2016 for RM018T - DEV_IL_ZB Life_014-Interest on delayed claims*/
		
		@Column(name="CLF_INT_TYPE")
		private String CLF_INT_TYPE;
		
		public String getCLF_INT_TYPE() {
			return CLF_INT_TYPE;
		}

		public void setCLF_INT_TYPE(String cLF_INT_TYPE) {
			CLF_INT_TYPE = cLF_INT_TYPE;
		}
		
		/*End*/
		
		
		
	}

