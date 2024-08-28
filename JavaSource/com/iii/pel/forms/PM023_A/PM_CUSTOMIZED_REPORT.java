package com.iii.pel.forms.PM023_A;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

/**
 * @author Pidugu Raj dt: 04-12-2018
 *
 */
@Table(name="PM_CUSTOMIZED_REPORT")
public class PM_CUSTOMIZED_REPORT extends BaseValueBean /*implements Serializable*/{

	/*private static final long serialVersionUID = -2184797197607024048L;*/
	private boolean selected = false;
	
	@Column(name = "REP_ID")
	private String REP_ID;
	
	@Column(name = "REP_DESC")
	private String REP_DESC;

	public String getREP_ID() {
		return REP_ID;
	}

	public void setREP_ID(String rEP_ID) {
		REP_ID = rEP_ID;
	}

	public String getREP_DESC() {
		return REP_DESC;
	}

	public void setREP_DESC(String rEP_DESC) {
		REP_DESC = rEP_DESC;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	

}
