package com.iii.pel.forms.PILP135;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

	@Table(name="PT_IL_POLICY")
	public class DUMMY extends BaseValueBean  {
		
		/*Added by saritha on 04-01-2017 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/	
	
		@Column(name="UI_M_EMP_CODE")
		private String UI_M_EMP_CODE;
		private String UI_M_EMP_DESC;

		@Column(name="POL_NO")
		private String POL_NO;
		
		@Column(name="POL_LAPS_OVR_YN")
		private String POL_LAPS_OVR_YN;
		
	    /*Modified by saritha on 20-07-2017 for ssp call id ZBILQC-1732158*/
		
		/*@Column(name="POL_LAPS_OVR_DT")
		  private Date POL_LAPS_OVR_DT;*/
		@Column(name="POL_LAPS_OVR_FRM_DT")
		private Date POL_LAPS_OVR_FRM_DT;

		public Date getPOL_LAPS_OVR_FRM_DT() {
			return POL_LAPS_OVR_FRM_DT;
		}

		public void setPOL_LAPS_OVR_FRM_DT(Date pOL_LAPS_OVR_FRM_DT) {
			POL_LAPS_OVR_FRM_DT = pOL_LAPS_OVR_FRM_DT;
		}
		
		@Column(name="POL_LAPS_OVR_TO_DT")
		private Date POL_LAPS_OVR_TO_DT;

		public Date getPOL_LAPS_OVR_TO_DT() {
			return POL_LAPS_OVR_TO_DT;
		}

		public void setPOL_LAPS_OVR_TO_DT(Date pOL_LAPS_OVR_TO_DT) {
			POL_LAPS_OVR_TO_DT = pOL_LAPS_OVR_TO_DT;
		}
		
		/*End*/

		public String getUI_M_EMP_CODE() {
			return UI_M_EMP_CODE;
		}

		public void setUI_M_EMP_CODE(String uI_M_EMP_CODE) {
			UI_M_EMP_CODE = uI_M_EMP_CODE;
		}
		
		
		public String getUI_M_EMP_DESC() {
			return UI_M_EMP_DESC;
		}

		public void setUI_M_EMP_DESC(String uI_M_EMP_DESC) {
			UI_M_EMP_DESC = uI_M_EMP_DESC;
		}
		
		public String getPOL_NO() {
			return POL_NO;
		}

		public void setPOL_NO(String pOL_NO) {
			POL_NO = pOL_NO;
		}
		
		public String getPOL_LAPS_OVR_YN() {
			return POL_LAPS_OVR_YN;
		}

		public void setPOL_LAPS_OVR_YN(String pOL_LAPS_OVR_YN) {
			POL_LAPS_OVR_YN = pOL_LAPS_OVR_YN;
		}
	
		/*public Date getPOL_LAPS_OVR_DT() {
			return POL_LAPS_OVR_DT;
		}

		public void setPOL_LAPS_OVR_DT(Date pOL_LAPS_OVR_DT) {
			POL_LAPS_OVR_DT = pOL_LAPS_OVR_DT;
		}*/
		
		/*End*/
		
		/*Added by saritha on 22-01-2018 for Stoping of APL Paid up lapse process for stop order/debit order customer for the selected duration*/
		
		@Column(name="ESP_SYS_ID")
		private Integer ESP_SYS_ID;

		public Integer getESP_SYS_ID() {
			return ESP_SYS_ID;
		}

		public void setESP_SYS_ID(Integer eSP_SYS_ID) {
			ESP_SYS_ID = eSP_SYS_ID;
		}

		
		
		/*End*/
			

	}

