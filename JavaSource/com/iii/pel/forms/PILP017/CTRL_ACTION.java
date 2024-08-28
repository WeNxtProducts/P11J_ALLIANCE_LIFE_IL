package com.iii.pel.forms.PILP017;

import java.awt.event.ActionEvent;

import javax.faces.component.UIInput;
import javax.faces.event.PhaseEvent;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
 

public class CTRL_ACTION extends CommonAction {

	private CTRL CTRL_BEAN;

	public PILP017_COMPOSITE_ACTION compositeAction;

	private CTRL_HELPER helper;



public CTRL_ACTION(){


CTRL_BEAN = new CTRL();
helper = new CTRL_HELPER();
}

	public CTRL getCTRL_BEAN() {
		return CTRL_BEAN;
	}

	public void setCTRL_BEAN(CTRL CTRL_BEAN) {
		this.CTRL_BEAN = CTRL_BEAN;
	}
	public void saveRecord() {
		try {
			if (getCTRL_BEAN().getROWID() != null) {
				
			}
		}
		catch (Exception e) {
		}
	}
}


	 
	 
