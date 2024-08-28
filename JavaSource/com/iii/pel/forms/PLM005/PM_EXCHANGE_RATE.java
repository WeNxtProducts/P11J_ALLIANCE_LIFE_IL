package com.iii.pel.forms.PLM005;

import java.util.Date;
import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

	@Table(name = "PM_EXCHANGE_RATE")
	public class PM_EXCHANGE_RATE extends BaseValueBean{
		
		@Column(name = "CER_EFF_FRM_DT")
		private Date CER_EFF_FRM_DT;
		
		
		@Column(name = "CER_EFF_TO_DT")
		private Date CER_EFF_TO_DT;

		public Date getCER_EFF_TO_DT() {
			return CER_EFF_TO_DT;
		}

		public void setCER_EFF_TO_DT(Date cER_EFF_TO_DT) {
			CER_EFF_TO_DT = cER_EFF_TO_DT;
		}

		@Column(name = "CER_EXG_RATE_TYPE")
		private String CER_EXG_RATE_TYPE;

		@Column(name = "CER_AVG_EXGE_RATE")
		//private Integer CER_AVG_EXGE_RATE;
		
		private String CER_AVG_EXGE_RATE;

		@Column(name = "CER_FIX_EXGE_RATE")
		//private Integer CER_FIX_EXGE_RATE;

		private String CER_FIX_EXGE_RATE;
		
		@Column(name = "CER_CONV_FM_CURR_CODE")
		private String CER_CONV_FM_CURR_CODE;
		
		
		@Column(name = "CER_UPD_UID")
		private String CER_UPD_UID;
		
		@Column(name = "CER_UPD_DT")
		private Date CER_UPD_DT;
		
		@Column(name = "CER_CR_UID")
		private String CER_CR_UID;
		
		@Column(name = "CER_CR_DT")
		private Date CER_CR_DT;
		
		
		@Column(name = "CER_EXG_RATE")
//		private Integer CER_EXG_RATE;
		
		private String CER_EXG_RATE;
		
		private String CER_EFF_FRM_DT_STR;
		
		/*Added by saritha*/
		
		private String CER_EFF_TO_DT_STR;
		
		public String getCER_EFF_TO_DT_STR() {
			return CER_EFF_TO_DT_STR;
		}

		public void setCER_EFF_TO_DT_STR(String cER_EFF_TO_DT_STR) {
			CER_EFF_TO_DT_STR = cER_EFF_TO_DT_STR;
		}
		
		/*End*/

		private String LIV_DESC;
		
		

		public String getLIV_DESC() {
			return LIV_DESC;
		}

		public void setLIV_DESC(String lIV_DESC) {
			LIV_DESC = lIV_DESC;
		}

		
		
		
		/*public Integer getCER_EXG_RATE() {
			return CER_EXG_RATE;
		}

		public void setCER_EXG_RATE(Integer cER_EXG_RATE) {
			CER_EXG_RATE = cER_EXG_RATE;
		}*/

		public String getCER_EXG_RATE() {
			return CER_EXG_RATE;
		}

		public void setCER_EXG_RATE(String cER_EXG_RATE) {
			CER_EXG_RATE = cER_EXG_RATE;
		}

		public String getCER_UPD_UID() {
			return CER_UPD_UID;
		}

		public void setCER_UPD_UID(String cER_UPD_UID) {
			CER_UPD_UID = cER_UPD_UID;
		}

		public Date getCER_UPD_DT() {
			return CER_UPD_DT;
		}

		public void setCER_UPD_DT(Date cER_UPD_DT) {
			CER_UPD_DT = cER_UPD_DT;
		}

		public String getCER_CR_UID() {
			return CER_CR_UID;
		}

		public void setCER_CR_UID(String cER_CR_UID) {
			CER_CR_UID = cER_CR_UID;
		}

		public Date getCER_CR_DT() {
			return CER_CR_DT;
		}

		public void setCER_CR_DT(Date cER_CR_DT) {
			CER_CR_DT = cER_CR_DT;
		}

		public String getCER_EFF_FRM_DT_STR() {
			return CER_EFF_FRM_DT_STR;
		}

		public void setCER_EFF_FRM_DT_STR(String cER_EFF_FRM_DT_STR) {
			CER_EFF_FRM_DT_STR = cER_EFF_FRM_DT_STR;
		}

		public String getCER_CONV_FM_CURR_CODE() {
			return CER_CONV_FM_CURR_CODE;
		}

		public void setCER_CONV_FM_CURR_CODE(String cER_CONV_FM_CURR_CODE) {
			CER_CONV_FM_CURR_CODE = cER_CONV_FM_CURR_CODE;
		}
	 

		public String getCER_EXG_RATE_TYPE() {
			return CER_EXG_RATE_TYPE;
		}

		public void setCER_EXG_RATE_TYPE(String cER_EXG_RATE_TYPE) {
			CER_EXG_RATE_TYPE = cER_EXG_RATE_TYPE;
		}

		/*public Integer getCER_AVG_EXGE_RATE() {
			return CER_AVG_EXGE_RATE;
		}

		public void setCER_AVG_EXGE_RATE(Integer cER_AVG_EXGE_RATE) {
			CER_AVG_EXGE_RATE = cER_AVG_EXGE_RATE;
		}

		public Integer getCER_FIX_EXGE_RATE() {
			return CER_FIX_EXGE_RATE;
		}

		public void setCER_FIX_EXGE_RATE(Integer cER_FIX_EXGE_RATE) {
			CER_FIX_EXGE_RATE = cER_FIX_EXGE_RATE;
		}*/
		
		

		public Date getCER_EFF_FRM_DT() {
			return CER_EFF_FRM_DT;
		}

		public String getCER_AVG_EXGE_RATE() {
			return CER_AVG_EXGE_RATE;
		}

		public void setCER_AVG_EXGE_RATE(String cER_AVG_EXGE_RATE) {
			CER_AVG_EXGE_RATE = cER_AVG_EXGE_RATE;
		}

		public String getCER_FIX_EXGE_RATE() {
			return CER_FIX_EXGE_RATE;
		}

		public void setCER_FIX_EXGE_RATE(String cER_FIX_EXGE_RATE) {
			CER_FIX_EXGE_RATE = cER_FIX_EXGE_RATE;
		}

		public void setCER_EFF_FRM_DT(Date cER_EFF_FRM_DT) {
			CER_EFF_FRM_DT = cER_EFF_FRM_DT;
		}

		
		private Integer BUY_CER_EXG_RATE;
		private Integer SELL_CER_EXG_RATE;





		public Integer getBUY_CER_EXG_RATE() {
			return BUY_CER_EXG_RATE;
		}

		public void setBUY_CER_EXG_RATE(Integer bUY_CER_EXG_RATE) {
			BUY_CER_EXG_RATE = bUY_CER_EXG_RATE;
		}

		public Integer getSELL_CER_EXG_RATE() {
			return SELL_CER_EXG_RATE;
		}

		public void setSELL_CER_EXG_RATE(Integer sELL_CER_EXG_RATE) {
			SELL_CER_EXG_RATE = sELL_CER_EXG_RATE;
		}
		
		/*Newly added*/
		
		@Column(name = "CER_CLIENT_ID")
		private String CER_CLIENT_ID;
		
		@Column(name = "CER_CONV_TO_CURR_CODE")
		private String CER_CONV_TO_CURR_CODE;

		public String getCER_CLIENT_ID() {
			return CER_CLIENT_ID;
		}

		public void setCER_CLIENT_ID(String cER_CLIENT_ID) {
			CER_CLIENT_ID = cER_CLIENT_ID;
		}
		
		public String getCER_CONV_TO_CURR_CODE() {
			return CER_CONV_TO_CURR_CODE;
		}

		public void setCER_CONV_TO_CURR_CODE(String cER_CONV_TO_CURR_CODE) {
			CER_CONV_TO_CURR_CODE = cER_CONV_TO_CURR_CODE;
		}
		
		/*End*/
		
		
	}