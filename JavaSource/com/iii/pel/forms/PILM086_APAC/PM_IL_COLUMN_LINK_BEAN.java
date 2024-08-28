package com.iii.pel.forms.PILM086_APAC;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;



	
	@Table(name = "PM_BUS_RULE_DTL1")
	public class PM_IL_COLUMN_LINK_BEAN extends BaseValueBean{
		
		@Column(name="BRD1_DTL_SNO")
		private int BRD1_DTL_SNO;
		@Column(name="BRD1_TAB_NAME")
		private String BRD1_TAB_NAME;
		@Column(name="BRD1_COL_NAME")
		private String BRD1_COL_NAME;
		@Column(name="BRD1_COL_FUNC")
		private String BRD1_COL_FUNC;
		@Column(name="BRD1_LINKED_TO_TAB")
		private String BRD1_LINKED_TO_TAB;
		@Column(name="BRD1_LINKED_BY_COL")
		private String BRD1_LINKED_BY_COL;
		@Column(name="BRD1_BRH_SYS_ID")
		private long BRD1_BRH_SYS_ID;
		
		
		public long getBRD1_BRH_SYS_ID() {
			return BRD1_BRH_SYS_ID;
		}
		public void setBRD1_BRH_SYS_ID(long bRD1_BRH_SYS_ID) {
			BRD1_BRH_SYS_ID = bRD1_BRH_SYS_ID;
		}
		public String getBRD1_LINKED_BY_COL() {
			return BRD1_LINKED_BY_COL;
		}
		public void setBRD1_LINKED_BY_COL(String bRD1_LINKED_BY_COL) {
			BRD1_LINKED_BY_COL = bRD1_LINKED_BY_COL;
		}
		public int getBRD1_DTL_SNO() {
			return BRD1_DTL_SNO;
		}
		public void setBRD1_DTL_SNO(int bRD1_DTL_SNO) {
			BRD1_DTL_SNO = bRD1_DTL_SNO;
		}
		public String getBRD1_TAB_NAME() {
			return BRD1_TAB_NAME;
		}
		public void setBRD1_TAB_NAME(String bRD1_TAB_NAME) {
			BRD1_TAB_NAME = bRD1_TAB_NAME;
		}
		public String getBRD1_COL_NAME() {
			return BRD1_COL_NAME;
		}
		public void setBRD1_COL_NAME(String bRD1_COL_NAME) {
			BRD1_COL_NAME = bRD1_COL_NAME;
		}
		public String getBRD1_COL_FUNC() {
			return BRD1_COL_FUNC;
		}
		public void setBRD1_COL_FUNC(String bRD1_COL_FUNC) {
			BRD1_COL_FUNC = bRD1_COL_FUNC;
		}
		public String getBRD1_LINKED_TO_TAB() {
			return BRD1_LINKED_TO_TAB;
		}
		public void setBRD1_LINKED_TO_TAB(String bRD1_LINKED_TO_TAB) {
			BRD1_LINKED_TO_TAB = bRD1_LINKED_TO_TAB;
		}
		public void setCURR_CR_UID(String user_ID) {
			// TODO Auto-generated method stub
			
		}
		
	
}
