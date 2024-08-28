package com.iii.pel.forms.PM094_A;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="PM_AGENT_BONUS_PERC_RANGE")
public class PM_AGENT_BONUS_PERC_RANGE extends BaseValueBean{
	
	@Column(name="ABPR_PERC_FM")
	private Integer ABPR_PERC_FM;
	
	@Column(name="ABPR_PERC_TO")
	private Integer ABPR_PERC_TO;
	
	@Column(name="ABPR_VALUE")
	private Integer ABPR_VALUE;

	public Integer getABPR_PERC_FM() {
		return ABPR_PERC_FM;
	}

	public void setABPR_PERC_FM(Integer aBPR_PERC_FM) {
		ABPR_PERC_FM = aBPR_PERC_FM;
	}

	public Integer getABPR_PERC_TO() {
		return ABPR_PERC_TO;
	}

	public void setABPR_PERC_TO(Integer aBPR_PERC_TO) {
		ABPR_PERC_TO = aBPR_PERC_TO;
	}

	public Integer getABPR_VALUE() {
		return ABPR_VALUE;
	}

	public void setABPR_VALUE(Integer aBPR_VALUE) {
		ABPR_VALUE = aBPR_VALUE;
	}
	
}
