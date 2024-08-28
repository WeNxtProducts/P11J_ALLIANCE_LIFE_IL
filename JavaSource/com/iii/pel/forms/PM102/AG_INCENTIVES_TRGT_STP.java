package com.iii.pel.forms.PM102;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PT_AG_INCENTIVES_TRGT_STP")
public class AG_INCENTIVES_TRGT_STP extends BaseValueBean {

	
	
	@Column(name="TSD_LEVEL")
	private String TSD_LEVEL;

	@Column(name="TSD_MODE")
	private String TSD_MODE;
	
	@Column(name="TSD_TARGET")
	private Double TSD_TARGET;
	
	
	private String TSD_LEVEL_DESC;
	
	
	private String TSD_MODE_DESC;

	public String getTSD_LEVEL_DESC() {
		return TSD_LEVEL_DESC;
	}

	public void setTSD_LEVEL_DESC(String tsd_level_desc) {
		TSD_LEVEL_DESC = tsd_level_desc;
	}

	public String getTSD_MODE_DESC() {
		return TSD_MODE_DESC;
	}

	public void setTSD_MODE_DESC(String tsd_mode_desc) {
		TSD_MODE_DESC = tsd_mode_desc;
	}

	

	public String getTSD_LEVEL() {
		return TSD_LEVEL;
	}

	public void setTSD_LEVEL(String tSD_LEVEL) {
		TSD_LEVEL = tSD_LEVEL;
	}

	public String getTSD_MODE() {
		return TSD_MODE;
	}

	public void setTSD_MODE(String tSD_MODE) {
		TSD_MODE = tSD_MODE;
	}

	public Double getTSD_TARGET() {
		return TSD_TARGET;
	}

	public void setTSD_TARGET(Double tSD_TARGET) {
		TSD_TARGET = tSD_TARGET;
	}
	
	

}
