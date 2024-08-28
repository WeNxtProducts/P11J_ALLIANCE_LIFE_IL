package com.iii.pel.forms.PILP014_A;

import java.util.Date;


import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="")
public class DUMMY {

	private String  UI_M_POL_NO_FM;

	private String UI_M_POL_NO_TO;

	private Date UI_M_PROCESS_DT;

	@Column(name="UI_M_PROCESS_TYPE")
	private String UI_M_PROCESS_TYPE;
	
	//changes by joshuva
	private String M_PRINT_TYPE;
	
	public String getM_PRINT_TYPE() {
		return M_PRINT_TYPE;
	}

	public void setM_PRINT_TYPE(String m_print_type) {
		M_PRINT_TYPE = m_print_type;
	}

	
	public String getUI_M_POL_NO_FM() {
		return UI_M_POL_NO_FM;
	}

	public void setUI_M_POL_NO_FM(String ui_m_pol_no_fm) {
		UI_M_POL_NO_FM = ui_m_pol_no_fm;
	}

	public String getUI_M_POL_NO_TO() {
		return UI_M_POL_NO_TO;
	}

	public void setUI_M_POL_NO_TO(String ui_m_pol_no_to) {
		UI_M_POL_NO_TO = ui_m_pol_no_to;
	}

	public Date getUI_M_PROCESS_DT() {
		 return UI_M_PROCESS_DT;
	}

	public void setUI_M_PROCESS_DT(Date UI_M_PROCESS_DT) {
		this.UI_M_PROCESS_DT = UI_M_PROCESS_DT;
	}

	public String getUI_M_PROCESS_TYPE() {
		return UI_M_PROCESS_TYPE;
	}

	public void setUI_M_PROCESS_TYPE(String UI_M_PROCESS_TYPE) {
		this.UI_M_PROCESS_TYPE = UI_M_PROCESS_TYPE;
	}
	
	/*Added by Ameen on 21-07-2017 for ZBILQC-1720395 as per Chandramohan sugg.*/
	
	private String UI_M_MED_FEE_YN;
	
	private Double UI_M_PROCESSING_FEE;

	public String getUI_M_MED_FEE_YN() {
		return UI_M_MED_FEE_YN;
	}

	public void setUI_M_MED_FEE_YN(String uI_M_MED_FEE_YN) {
		UI_M_MED_FEE_YN = uI_M_MED_FEE_YN;
	}

	public Double getUI_M_PROCESSING_FEE() {
		return UI_M_PROCESSING_FEE;
	}

	public void setUI_M_PROCESSING_FEE(Double uI_M_PROCESSING_FEE) {
		UI_M_PROCESSING_FEE = uI_M_PROCESSING_FEE;
	}
	
	
	/*End*/
}
