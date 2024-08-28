package com.iii.pel.forms.PILP060_APAC;

import java.text.ParseException;
import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="")
public class DUMMY extends BaseValueBean {

	private String UI_M_PROD_CODE_FM;

	private String UI_M_PROD_FM_DESC;

	private String UI_M_PROD_CODE_TO;

	private String UI_M_PROD_TO_DESC;

	private String UI_M_POL_NO_FM;

	private String UI_M_POL_NO_TO;

	private String UI_M_BON_CODE_FM;

	private String UI_M_BON_FM_DESC;

	private String UI_M_BON_CODE_TO;

	private String UI_M_BON_TO_DESC;

	private Date UI_M_PROCESS_DATE;

	private String polAssuredName;
	
	private Double polSysId;
	
	private Double sumAssuredExchngRate;
	
	private String papProdCode;
	
	public Double getPolSysId() {
		return polSysId;
	}

	public void setPolSysId(Double polSysId) {
		this.polSysId = polSysId;
	}

	public Double getSumAssuredExchngRate() {
		return sumAssuredExchngRate;
	}

	public void setSumAssuredExchngRate(Double sumAssuredExchngRate) {
		this.sumAssuredExchngRate = sumAssuredExchngRate;
	}

	public String getPapProdCode() {
		return papProdCode;
	}

	public void setPapProdCode(String papProdCode) {
		this.papProdCode = papProdCode;
	}

	public String getPolAssuredName() {
		return polAssuredName;
	}

	public DUMMY() {
		CommonUtils utility=new CommonUtils();
		try {
			this.UI_M_PROCESS_DATE=utility.getCurrentDate();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	public void setPolAssuredName(String polAssuredName) {
		this.polAssuredName = polAssuredName;
	}

	public String getUI_M_PROD_CODE_FM() {
		return UI_M_PROD_CODE_FM;
	}

	public void setUI_M_PROD_CODE_FM(String UI_M_PROD_CODE_FM) {
		this.UI_M_PROD_CODE_FM = UI_M_PROD_CODE_FM;
	}

	public String getUI_M_PROD_FM_DESC() {
		return UI_M_PROD_FM_DESC;
	}

	public void setUI_M_PROD_FM_DESC(String UI_M_PROD_FM_DESC) {
		this.UI_M_PROD_FM_DESC = UI_M_PROD_FM_DESC;
	}

	public String getUI_M_PROD_CODE_TO() {
		return UI_M_PROD_CODE_TO;
	}

	public void setUI_M_PROD_CODE_TO(String UI_M_PROD_CODE_TO) {
		this.UI_M_PROD_CODE_TO = UI_M_PROD_CODE_TO;
	}

	public String getUI_M_PROD_TO_DESC() {
		return UI_M_PROD_TO_DESC;
	}

	public void setUI_M_PROD_TO_DESC(String UI_M_PROD_TO_DESC) {
		this.UI_M_PROD_TO_DESC = UI_M_PROD_TO_DESC;
	}

	public String getUI_M_POL_NO_FM() {
		return UI_M_POL_NO_FM;
	}

	public void setUI_M_POL_NO_FM(String UI_M_POL_NO_FM) {
		this.UI_M_POL_NO_FM = UI_M_POL_NO_FM;
	}

	public String getUI_M_POL_NO_TO() {
		return UI_M_POL_NO_TO;
	}

	public void setUI_M_POL_NO_TO(String UI_M_POL_NO_TO) {
		this.UI_M_POL_NO_TO = UI_M_POL_NO_TO;
	}

	public String getUI_M_BON_CODE_FM() {
		return UI_M_BON_CODE_FM;
	}

	public void setUI_M_BON_CODE_FM(String UI_M_BON_CODE_FM) {
		this.UI_M_BON_CODE_FM = UI_M_BON_CODE_FM;
	}

	public String getUI_M_BON_FM_DESC() {
		return UI_M_BON_FM_DESC;
	}

	public void setUI_M_BON_FM_DESC(String UI_M_BON_FM_DESC) {
		this.UI_M_BON_FM_DESC = UI_M_BON_FM_DESC;
	}

	public String getUI_M_BON_CODE_TO() {
		return UI_M_BON_CODE_TO;
	}

	public void setUI_M_BON_CODE_TO(String UI_M_BON_CODE_TO) {
		this.UI_M_BON_CODE_TO = UI_M_BON_CODE_TO;
	}

	public String getUI_M_BON_TO_DESC() {
		return UI_M_BON_TO_DESC;
	}

	public void setUI_M_BON_TO_DESC(String UI_M_BON_TO_DESC) {
		this.UI_M_BON_TO_DESC = UI_M_BON_TO_DESC;
	}

	public Date getUI_M_PROCESS_DATE() {
		 return UI_M_PROCESS_DATE;
	}

	public void setUI_M_PROCESS_DATE(Date UI_M_PROCESS_DATE) {
		this.UI_M_PROCESS_DATE = UI_M_PROCESS_DATE;
	}
}
