package com.iii.pel.forms.PILP236_A;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class AGENT_PROCESS extends BaseValueBean {

	private String UI_M_AGT_FM;

	private String UI_M_AGT_TO;

	@Column(name="UI_M_PROCESS_TYPE")
	private String UI_M_PROCESS_TYPE;

	@Column(name="UI_M_FREQ")
	private String UI_M_FREQ;

	@Column(name="UI_M_QUARTER_PERIOD")
	private String UI_M_QUARTER_PERIOD;

	private String UI_M_BEN_CON_FROM;

	private String UI_M_BEN_CON_TO;

	private Date UI_M_PROD_FM_DT;

	private Date UI_M_PROD_TO_DT;

	private Date UI_M_PROCESS_DT;
	
	private String labelCaption;
	
	private String fromFieldCaption;
	
	private String toFieldCaption;


	public AGENT_PROCESS(){
		
		UI_M_FREQ="M";
		UI_M_PROCESS_TYPE="F";
		
	}
	

	public String getUI_M_AGT_FM() {
		return UI_M_AGT_FM;
	}

	public void setUI_M_AGT_FM(String UI_M_AGT_FM) {
		this.UI_M_AGT_FM = UI_M_AGT_FM;
	}

	public String getUI_M_AGT_TO() {
		return UI_M_AGT_TO;
	}

	public void setUI_M_AGT_TO(String UI_M_AGT_TO) {
		this.UI_M_AGT_TO = UI_M_AGT_TO;
	}

	public String getUI_M_PROCESS_TYPE() {
		return UI_M_PROCESS_TYPE;
	}

	public void setUI_M_PROCESS_TYPE(String UI_M_PROCESS_TYPE) {
		this.UI_M_PROCESS_TYPE = UI_M_PROCESS_TYPE;
	}

	public String getUI_M_FREQ() {
		return UI_M_FREQ;
	}

	public void setUI_M_FREQ(String UI_M_FREQ) {
		this.UI_M_FREQ = UI_M_FREQ;
	}

	public String getUI_M_QUARTER_PERIOD() {
		return UI_M_QUARTER_PERIOD;
	}

	public void setUI_M_QUARTER_PERIOD(String UI_M_QUARTER_PERIOD) {
		this.UI_M_QUARTER_PERIOD = UI_M_QUARTER_PERIOD;
	}

	public String getUI_M_BEN_CON_FROM() {
		return UI_M_BEN_CON_FROM;
	}

	public void setUI_M_BEN_CON_FROM(String UI_M_BEN_CON_FROM) {
		this.UI_M_BEN_CON_FROM = UI_M_BEN_CON_FROM;
	}

	public String getUI_M_BEN_CON_TO() {
		return UI_M_BEN_CON_TO;
	}

	public void setUI_M_BEN_CON_TO(String UI_M_BEN_CON_TO) {
		this.UI_M_BEN_CON_TO = UI_M_BEN_CON_TO;
	}

	public Date getUI_M_PROD_FM_DT() {
		 return UI_M_PROD_FM_DT;
	}

	public void setUI_M_PROD_FM_DT(Date UI_M_PROD_FM_DT) {
		this.UI_M_PROD_FM_DT = UI_M_PROD_FM_DT;
	}

	public Date getUI_M_PROD_TO_DT() {
		 return UI_M_PROD_TO_DT;
	}

	public void setUI_M_PROD_TO_DT(Date UI_M_PROD_TO_DT) {
		this.UI_M_PROD_TO_DT = UI_M_PROD_TO_DT;
	}

	public Date getUI_M_PROCESS_DT() {
		 return UI_M_PROCESS_DT;
	}

	public void setUI_M_PROCESS_DT(Date UI_M_PROCESS_DT) {
		this.UI_M_PROCESS_DT = UI_M_PROCESS_DT;
	}


	public String getLabelCaption() {
		return labelCaption;
	}


	public void setLabelCaption(String labelCaption) {
		this.labelCaption = labelCaption;
	}


	public String getFromFieldCaption() {
		return fromFieldCaption;
	}


	public void setFromFieldCaption(String fromFieldCaption) {
		this.fromFieldCaption = fromFieldCaption;
	}


	public String getToFieldCaption() {
		return toFieldCaption;
	}


	public void setToFieldCaption(String toFieldCaption) {
		this.toFieldCaption = toFieldCaption;
	}
}
