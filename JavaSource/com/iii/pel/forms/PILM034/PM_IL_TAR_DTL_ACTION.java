package com.iii.pel.forms.PILM034;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.el.MethodExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.validator.ValidatorException;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlSuggestionBox;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;

public class PM_IL_TAR_DTL_ACTION extends CommonAction {

	private HtmlOutputLabel COMP_TD_TH_CODE_LABEL;

	private HtmlInputText COMP_TD_TH_CODE;

	private HtmlOutputLabel COMP_TD_PARAM_TYPE_LABEL;

	private HtmlInputText COMP_TD_PARAM_TYPE;

	private HtmlOutputLabel COMP_TD_MINIMUM_LABEL;

	private HtmlInputText COMP_TD_MINIMUM;

	private HtmlOutputLabel COMP_TD_MAXIMUM_LABEL;

	private HtmlInputText COMP_TD_MAXIMUM;

	private HtmlOutputLabel COMP_TD_CHAR_RATE_LABEL;

	private HtmlInputText COMP_TD_CHAR_RATE;

	private HtmlOutputLabel COMP_TD_PARA_01_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_01_FM;

	private HtmlOutputLabel COMP_TD_PARA_01_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_01_TO;

	private HtmlOutputLabel COMP_TD_PARA_02_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_02_FM;

	private HtmlOutputLabel COMP_TD_PARA_02_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_02_TO;

	private HtmlOutputLabel COMP_TD_PARA_03_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_03_FM;

	private HtmlOutputLabel COMP_TD_PARA_03_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_03_TO;

	private HtmlOutputLabel COMP_TD_PARA_04_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_04_FM;

	private HtmlOutputLabel COMP_TD_PARA_04_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_04_TO;

	private HtmlOutputLabel COMP_TD_PARA_05_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_05_FM;

	private HtmlOutputLabel COMP_TD_PARA_05_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_05_TO;

	private HtmlOutputLabel COMP_TD_PARA_06_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_06_FM;

	private HtmlOutputLabel COMP_TD_PARA_06_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_06_TO;

	private HtmlOutputLabel COMP_TD_PARA_07_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_07_FM;

	private HtmlOutputLabel COMP_TD_PARA_07_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_07_TO;

	private HtmlOutputLabel COMP_TD_PARA_08_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_08_FM;

	private HtmlOutputLabel COMP_TD_PARA_08_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_08_TO;

	private HtmlOutputLabel COMP_TD_PARA_09_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_09_FM;

	private HtmlOutputLabel COMP_TD_PARA_09_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_09_TO;

	private HtmlOutputLabel COMP_TD_PARA_10_FM_LABEL;

	private HtmlInputText COMP_TD_PARA_10_FM;

	private HtmlOutputLabel COMP_TD_PARA_10_TO_LABEL;

	private HtmlInputText COMP_TD_PARA_10_TO;

	private HtmlOutputLabel COMP_TD_RATE_LABEL;

	private HtmlInputText COMP_TD_RATE;

	private HtmlOutputLabel COMP_TD_EFF_FM_DT_LABEL;

	private HtmlCalendar COMP_TD_EFF_FM_DT;

	private HtmlOutputLabel COMP_TD_EFF_TO_DT_LABEL;

	private HtmlCalendar COMP_TD_EFF_TO_DT;

	private HtmlCommandButton COMP_UI_M_BUT_DTL_TO_HDR;

	private PM_IL_TAR_DTL PM_IL_TAR_DTL_BEAN;

	private PM_IL_TAR_DTL_DUMMY PM_IL_TAR_DTL_DUMMY_BEAN;

	public PILM034_COMPOSITE_ACTION compositeAction;

	private PM_IL_TAR_DTL_HELPER helper;

	private List<PM_IL_TAR_DTL> dataList_PM_IL_TAR_DTL = new ArrayList<PM_IL_TAR_DTL>();

	private UIData dataTable;
	
	//added by gopinath for tarrif lov on 27-05-2016
	private HtmlSuggestionBox COMP_TD_PARA_01_SUGG;

	public HtmlSuggestionBox getCOMP_TD_PARA_01_SUGG() {
			return COMP_TD_PARA_01_SUGG;
		}

		public void setCOMP_TD_PARA_01_SUGG(HtmlSuggestionBox cOMP_TD_PARA_01_SUGG) {
			COMP_TD_PARA_01_SUGG = cOMP_TD_PARA_01_SUGG;
		}

	private HtmlSuggestionBox COMP_TD_PARA_01_SUGG_TO;

	public HtmlSuggestionBox getCOMP_TD_PARA_01_SUGG_TO() {
			return COMP_TD_PARA_01_SUGG_TO;
		}

		public void setCOMP_TD_PARA_01_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_01_SUGG_TO) {
			COMP_TD_PARA_01_SUGG_TO = cOMP_TD_PARA_01_SUGG_TO;
		}

	private HtmlSuggestionBox COMP_TD_PARA_02_SUGG;

		public HtmlSuggestionBox getCOMP_TD_PARA_02_SUGG() {
			return COMP_TD_PARA_02_SUGG;
		}

		public void setCOMP_TD_PARA_02_SUGG(HtmlSuggestionBox cOMP_TD_PARA_02_SUGG) {
			COMP_TD_PARA_02_SUGG = cOMP_TD_PARA_02_SUGG;
		}

		private HtmlSuggestionBox COMP_TD_PARA_02_SUGG_TO;
		
		
		
		public HtmlSuggestionBox getCOMP_TD_PARA_02_SUGG_TO() {
			return COMP_TD_PARA_02_SUGG_TO;
		}

		public void setCOMP_TD_PARA_02_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_02_SUGG_TO) {
			COMP_TD_PARA_02_SUGG_TO = cOMP_TD_PARA_02_SUGG_TO;
		}

		
		private HtmlSuggestionBox COMP_TD_PARA_03_SUGG;
		
		
		
		public HtmlSuggestionBox getCOMP_TD_PARA_03_SUGG() {
			return COMP_TD_PARA_03_SUGG;
		}

		public void setCOMP_TD_PARA_03_SUGG(HtmlSuggestionBox cOMP_TD_PARA_03_SUGG) {
			COMP_TD_PARA_03_SUGG = cOMP_TD_PARA_03_SUGG;
		}
		
		private HtmlSuggestionBox COMP_TD_PARA_03_SUGG_TO;

		public HtmlSuggestionBox getCOMP_TD_PARA_03_SUGG_TO() {
			return COMP_TD_PARA_03_SUGG_TO;
		}

		public void setCOMP_TD_PARA_03_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_03_SUGG_TO) {
			COMP_TD_PARA_03_SUGG_TO = cOMP_TD_PARA_03_SUGG_TO;
		}
		
		private HtmlSuggestionBox COMP_TD_PARA_04_SUGG;

		public HtmlSuggestionBox getCOMP_TD_PARA_04_SUGG() {
			return COMP_TD_PARA_04_SUGG;
		}

		public void setCOMP_TD_PARA_04_SUGG(HtmlSuggestionBox cOMP_TD_PARA_04_SUGG) {
			COMP_TD_PARA_04_SUGG = cOMP_TD_PARA_04_SUGG;
		}
		
		private HtmlSuggestionBox COMP_TD_PARA_04_SUGG_TO;

		public HtmlSuggestionBox getCOMP_TD_PARA_04_SUGG_TO() {
			return COMP_TD_PARA_04_SUGG_TO;
		}

		public void setCOMP_TD_PARA_04_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_04_SUGG_TO) {
			COMP_TD_PARA_04_SUGG_TO = cOMP_TD_PARA_04_SUGG_TO;
		}
		
		
		private HtmlSuggestionBox COMP_TD_PARA_05_SUGG;

		public HtmlSuggestionBox getCOMP_TD_PARA_05_SUGG() {
			return COMP_TD_PARA_05_SUGG;
		}

		public void setCOMP_TD_PARA_05_SUGG(HtmlSuggestionBox cOMP_TD_PARA_05_SUGG) {
			COMP_TD_PARA_05_SUGG = cOMP_TD_PARA_05_SUGG;
		}
		
		private HtmlSuggestionBox COMP_TD_PARA_05_SUGG_TO;

		public HtmlSuggestionBox getCOMP_TD_PARA_05_SUGG_TO() {
			return COMP_TD_PARA_05_SUGG_TO;
		}

		public void setCOMP_TD_PARA_05_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_05_SUGG_TO) {
			COMP_TD_PARA_05_SUGG_TO = cOMP_TD_PARA_05_SUGG_TO;
		}

		
		private HtmlSuggestionBox COMP_TD_PARA_06_SUGG;
		
		public HtmlSuggestionBox getCOMP_TD_PARA_06_SUGG() {
			return COMP_TD_PARA_06_SUGG;
		}

		public void setCOMP_TD_PARA_06_SUGG(HtmlSuggestionBox cOMP_TD_PARA_06_SUGG) {
			COMP_TD_PARA_06_SUGG = cOMP_TD_PARA_06_SUGG;
		}
		
		private HtmlSuggestionBox COMP_TD_PARA_06_SUGG_TO;

		public HtmlSuggestionBox getCOMP_TD_PARA_06_SUGG_TO() {
			return COMP_TD_PARA_06_SUGG_TO;
		}

		public void setCOMP_TD_PARA_06_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_06_SUGG_TO) {
			COMP_TD_PARA_06_SUGG_TO = cOMP_TD_PARA_06_SUGG_TO;
		}
		//end
	
      //added by saranya
		private HtmlSuggestionBox COMP_TD_PARA_07_SUGG; 
		
		private HtmlSuggestionBox COMP_TD_PARA_07_SUGG_TO;
		
		private HtmlSuggestionBox COMP_TD_PARA_08_SUGG;
		
		private HtmlSuggestionBox COMP_TD_PARA_08_SUGG_TO;
		
		public HtmlSuggestionBox getCOMP_TD_PARA_08_SUGG_TO() {
			return COMP_TD_PARA_08_SUGG_TO;
		}

		public void setCOMP_TD_PARA_08_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_08_SUGG_TO) {
			COMP_TD_PARA_08_SUGG_TO = cOMP_TD_PARA_08_SUGG_TO;
		}

		public HtmlSuggestionBox getCOMP_TD_PARA_08_SUGG() {
			return COMP_TD_PARA_08_SUGG;
		}

		public void setCOMP_TD_PARA_08_SUGG(HtmlSuggestionBox cOMP_TD_PARA_08_SUGG) {
			COMP_TD_PARA_08_SUGG = cOMP_TD_PARA_08_SUGG;
		} 
		
	   public HtmlSuggestionBox getCOMP_TD_PARA_07_SUGG() {
			return COMP_TD_PARA_07_SUGG;
		}

		public void setCOMP_TD_PARA_07_SUGG(HtmlSuggestionBox cOMP_TD_PARA_07_SUGG) {
			COMP_TD_PARA_07_SUGG = cOMP_TD_PARA_07_SUGG;
		}
		
      public HtmlSuggestionBox getCOMP_TD_PARA_07_SUGG_TO() {
			return COMP_TD_PARA_07_SUGG_TO;
		}

		public void setCOMP_TD_PARA_07_SUGG_TO(HtmlSuggestionBox cOMP_TD_PARA_07_SUGG_TO) {
			COMP_TD_PARA_07_SUGG_TO = cOMP_TD_PARA_07_SUGG_TO;
		}
      //end
	public PM_IL_TAR_DTL_ACTION(){
		PM_IL_TAR_DTL_DUMMY_BEAN = new PM_IL_TAR_DTL_DUMMY();
		PM_IL_TAR_DTL_BEAN = new PM_IL_TAR_DTL();
		helper = new PM_IL_TAR_DTL_HELPER();
		initalizecomponent();
	}

	public HtmlOutputLabel getCOMP_TD_TH_CODE_LABEL() {
		return COMP_TD_TH_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TD_TH_CODE() {
		return COMP_TD_TH_CODE;
	}

	public void setCOMP_TD_TH_CODE_LABEL(HtmlOutputLabel COMP_TD_TH_CODE_LABEL) {
		this.COMP_TD_TH_CODE_LABEL = COMP_TD_TH_CODE_LABEL;
	}

	public void setCOMP_TD_TH_CODE(HtmlInputText COMP_TD_TH_CODE) {
		this.COMP_TD_TH_CODE = COMP_TD_TH_CODE;
	}

	public HtmlOutputLabel getCOMP_TD_PARAM_TYPE_LABEL() {
		return COMP_TD_PARAM_TYPE_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARAM_TYPE() {
		return COMP_TD_PARAM_TYPE;
	}

	public void setCOMP_TD_PARAM_TYPE_LABEL(HtmlOutputLabel COMP_TD_PARAM_TYPE_LABEL) {
		this.COMP_TD_PARAM_TYPE_LABEL = COMP_TD_PARAM_TYPE_LABEL;
	}

	public void setCOMP_TD_PARAM_TYPE(HtmlInputText COMP_TD_PARAM_TYPE) {
		this.COMP_TD_PARAM_TYPE = COMP_TD_PARAM_TYPE;
	}

	public HtmlOutputLabel getCOMP_TD_MINIMUM_LABEL() {
		return COMP_TD_MINIMUM_LABEL;
	}

	public HtmlInputText getCOMP_TD_MINIMUM() {
		return COMP_TD_MINIMUM;
	}

	public void setCOMP_TD_MINIMUM_LABEL(HtmlOutputLabel COMP_TD_MINIMUM_LABEL) {
		this.COMP_TD_MINIMUM_LABEL = COMP_TD_MINIMUM_LABEL;
	}

	public void setCOMP_TD_MINIMUM(HtmlInputText COMP_TD_MINIMUM) {
		this.COMP_TD_MINIMUM = COMP_TD_MINIMUM;
	}

	public HtmlOutputLabel getCOMP_TD_MAXIMUM_LABEL() {
		return COMP_TD_MAXIMUM_LABEL;
	}

	public HtmlInputText getCOMP_TD_MAXIMUM() {
		return COMP_TD_MAXIMUM;
	}

	public void setCOMP_TD_MAXIMUM_LABEL(HtmlOutputLabel COMP_TD_MAXIMUM_LABEL) {
		this.COMP_TD_MAXIMUM_LABEL = COMP_TD_MAXIMUM_LABEL;
	}

	public void setCOMP_TD_MAXIMUM(HtmlInputText COMP_TD_MAXIMUM) {
		this.COMP_TD_MAXIMUM = COMP_TD_MAXIMUM;
	}

	public HtmlOutputLabel getCOMP_TD_CHAR_RATE_LABEL() {
		return COMP_TD_CHAR_RATE_LABEL;
	}

	public HtmlInputText getCOMP_TD_CHAR_RATE() {
		return COMP_TD_CHAR_RATE;
	}

	public void setCOMP_TD_CHAR_RATE_LABEL(HtmlOutputLabel COMP_TD_CHAR_RATE_LABEL) {
		this.COMP_TD_CHAR_RATE_LABEL = COMP_TD_CHAR_RATE_LABEL;
	}

	public void setCOMP_TD_CHAR_RATE(HtmlInputText COMP_TD_CHAR_RATE) {
		this.COMP_TD_CHAR_RATE = COMP_TD_CHAR_RATE;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_01_FM_LABEL() {
		return COMP_TD_PARA_01_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_01_FM() {
		return COMP_TD_PARA_01_FM;
	}

	public void setCOMP_TD_PARA_01_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_01_FM_LABEL) {
		this.COMP_TD_PARA_01_FM_LABEL = COMP_TD_PARA_01_FM_LABEL;
	}

	public void setCOMP_TD_PARA_01_FM(HtmlInputText COMP_TD_PARA_01_FM) {
		this.COMP_TD_PARA_01_FM = COMP_TD_PARA_01_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_01_TO_LABEL() {
		return COMP_TD_PARA_01_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_01_TO() {
		return COMP_TD_PARA_01_TO;
	}

	public void setCOMP_TD_PARA_01_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_01_TO_LABEL) {
		this.COMP_TD_PARA_01_TO_LABEL = COMP_TD_PARA_01_TO_LABEL;
	}

	public void setCOMP_TD_PARA_01_TO(HtmlInputText COMP_TD_PARA_01_TO) {
		this.COMP_TD_PARA_01_TO = COMP_TD_PARA_01_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_02_FM_LABEL() {
		return COMP_TD_PARA_02_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_02_FM() {
		return COMP_TD_PARA_02_FM;
	}

	public void setCOMP_TD_PARA_02_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_02_FM_LABEL) {
		this.COMP_TD_PARA_02_FM_LABEL = COMP_TD_PARA_02_FM_LABEL;
	}

	public void setCOMP_TD_PARA_02_FM(HtmlInputText COMP_TD_PARA_02_FM) {
		this.COMP_TD_PARA_02_FM = COMP_TD_PARA_02_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_02_TO_LABEL() {
		return COMP_TD_PARA_02_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_02_TO() {
		return COMP_TD_PARA_02_TO;
	}

	public void setCOMP_TD_PARA_02_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_02_TO_LABEL) {
		this.COMP_TD_PARA_02_TO_LABEL = COMP_TD_PARA_02_TO_LABEL;
	}

	public void setCOMP_TD_PARA_02_TO(HtmlInputText COMP_TD_PARA_02_TO) {
		this.COMP_TD_PARA_02_TO = COMP_TD_PARA_02_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_03_FM_LABEL() {
		return COMP_TD_PARA_03_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_03_FM() {
		return COMP_TD_PARA_03_FM;
	}

	public void setCOMP_TD_PARA_03_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_03_FM_LABEL) {
		this.COMP_TD_PARA_03_FM_LABEL = COMP_TD_PARA_03_FM_LABEL;
	}

	public void setCOMP_TD_PARA_03_FM(HtmlInputText COMP_TD_PARA_03_FM) {
		this.COMP_TD_PARA_03_FM = COMP_TD_PARA_03_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_03_TO_LABEL() {
		return COMP_TD_PARA_03_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_03_TO() {
		return COMP_TD_PARA_03_TO;
	}

	public void setCOMP_TD_PARA_03_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_03_TO_LABEL) {
		this.COMP_TD_PARA_03_TO_LABEL = COMP_TD_PARA_03_TO_LABEL;
	}

	public void setCOMP_TD_PARA_03_TO(HtmlInputText COMP_TD_PARA_03_TO) {
		this.COMP_TD_PARA_03_TO = COMP_TD_PARA_03_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_04_FM_LABEL() {
		return COMP_TD_PARA_04_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_04_FM() {
		return COMP_TD_PARA_04_FM;
	}

	public void setCOMP_TD_PARA_04_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_04_FM_LABEL) {
		this.COMP_TD_PARA_04_FM_LABEL = COMP_TD_PARA_04_FM_LABEL;
	}

	public void setCOMP_TD_PARA_04_FM(HtmlInputText COMP_TD_PARA_04_FM) {
		this.COMP_TD_PARA_04_FM = COMP_TD_PARA_04_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_04_TO_LABEL() {
		return COMP_TD_PARA_04_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_04_TO() {
		return COMP_TD_PARA_04_TO;
	}

	public void setCOMP_TD_PARA_04_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_04_TO_LABEL) {
		this.COMP_TD_PARA_04_TO_LABEL = COMP_TD_PARA_04_TO_LABEL;
	}

	public void setCOMP_TD_PARA_04_TO(HtmlInputText COMP_TD_PARA_04_TO) {
		this.COMP_TD_PARA_04_TO = COMP_TD_PARA_04_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_05_FM_LABEL() {
		return COMP_TD_PARA_05_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_05_FM() {
		return COMP_TD_PARA_05_FM;
	}

	public void setCOMP_TD_PARA_05_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_05_FM_LABEL) {
		this.COMP_TD_PARA_05_FM_LABEL = COMP_TD_PARA_05_FM_LABEL;
	}

	public void setCOMP_TD_PARA_05_FM(HtmlInputText COMP_TD_PARA_05_FM) {
		this.COMP_TD_PARA_05_FM = COMP_TD_PARA_05_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_05_TO_LABEL() {
		return COMP_TD_PARA_05_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_05_TO() {
		return COMP_TD_PARA_05_TO;
	}

	public void setCOMP_TD_PARA_05_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_05_TO_LABEL) {
		this.COMP_TD_PARA_05_TO_LABEL = COMP_TD_PARA_05_TO_LABEL;
	}

	public void setCOMP_TD_PARA_05_TO(HtmlInputText COMP_TD_PARA_05_TO) {
		this.COMP_TD_PARA_05_TO = COMP_TD_PARA_05_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_06_FM_LABEL() {
		return COMP_TD_PARA_06_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_06_FM() {
		return COMP_TD_PARA_06_FM;
	}

	public void setCOMP_TD_PARA_06_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_06_FM_LABEL) {
		this.COMP_TD_PARA_06_FM_LABEL = COMP_TD_PARA_06_FM_LABEL;
	}

	public void setCOMP_TD_PARA_06_FM(HtmlInputText COMP_TD_PARA_06_FM) {
		this.COMP_TD_PARA_06_FM = COMP_TD_PARA_06_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_06_TO_LABEL() {
		return COMP_TD_PARA_06_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_06_TO() {
		return COMP_TD_PARA_06_TO;
	}

	public void setCOMP_TD_PARA_06_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_06_TO_LABEL) {
		this.COMP_TD_PARA_06_TO_LABEL = COMP_TD_PARA_06_TO_LABEL;
	}

	public void setCOMP_TD_PARA_06_TO(HtmlInputText COMP_TD_PARA_06_TO) {
		this.COMP_TD_PARA_06_TO = COMP_TD_PARA_06_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_07_FM_LABEL() {
		return COMP_TD_PARA_07_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_07_FM() {
		return COMP_TD_PARA_07_FM;
	}

	public void setCOMP_TD_PARA_07_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_07_FM_LABEL) {
		this.COMP_TD_PARA_07_FM_LABEL = COMP_TD_PARA_07_FM_LABEL;
	}

	public void setCOMP_TD_PARA_07_FM(HtmlInputText COMP_TD_PARA_07_FM) {
		this.COMP_TD_PARA_07_FM = COMP_TD_PARA_07_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_07_TO_LABEL() {
		return COMP_TD_PARA_07_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_07_TO() {
		return COMP_TD_PARA_07_TO;
	}

	public void setCOMP_TD_PARA_07_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_07_TO_LABEL) {
		this.COMP_TD_PARA_07_TO_LABEL = COMP_TD_PARA_07_TO_LABEL;
	}

	public void setCOMP_TD_PARA_07_TO(HtmlInputText COMP_TD_PARA_07_TO) {
		this.COMP_TD_PARA_07_TO = COMP_TD_PARA_07_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_08_FM_LABEL() {
		return COMP_TD_PARA_08_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_08_FM() {
		return COMP_TD_PARA_08_FM;
	}

	public void setCOMP_TD_PARA_08_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_08_FM_LABEL) {
		this.COMP_TD_PARA_08_FM_LABEL = COMP_TD_PARA_08_FM_LABEL;
	}

	public void setCOMP_TD_PARA_08_FM(HtmlInputText COMP_TD_PARA_08_FM) {
		this.COMP_TD_PARA_08_FM = COMP_TD_PARA_08_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_08_TO_LABEL() {
		return COMP_TD_PARA_08_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_08_TO() {
		return COMP_TD_PARA_08_TO;
	}

	public void setCOMP_TD_PARA_08_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_08_TO_LABEL) {
		this.COMP_TD_PARA_08_TO_LABEL = COMP_TD_PARA_08_TO_LABEL;
	}

	public void setCOMP_TD_PARA_08_TO(HtmlInputText COMP_TD_PARA_08_TO) {
		this.COMP_TD_PARA_08_TO = COMP_TD_PARA_08_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_09_FM_LABEL() {
		return COMP_TD_PARA_09_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_09_FM() {
		return COMP_TD_PARA_09_FM;
	}

	public void setCOMP_TD_PARA_09_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_09_FM_LABEL) {
		this.COMP_TD_PARA_09_FM_LABEL = COMP_TD_PARA_09_FM_LABEL;
	}

	public void setCOMP_TD_PARA_09_FM(HtmlInputText COMP_TD_PARA_09_FM) {
		this.COMP_TD_PARA_09_FM = COMP_TD_PARA_09_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_09_TO_LABEL() {
		return COMP_TD_PARA_09_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_09_TO() {
		return COMP_TD_PARA_09_TO;
	}

	public void setCOMP_TD_PARA_09_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_09_TO_LABEL) {
		this.COMP_TD_PARA_09_TO_LABEL = COMP_TD_PARA_09_TO_LABEL;
	}

	public void setCOMP_TD_PARA_09_TO(HtmlInputText COMP_TD_PARA_09_TO) {
		this.COMP_TD_PARA_09_TO = COMP_TD_PARA_09_TO;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_10_FM_LABEL() {
		return COMP_TD_PARA_10_FM_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_10_FM() {
		return COMP_TD_PARA_10_FM;
	}

	public void setCOMP_TD_PARA_10_FM_LABEL(HtmlOutputLabel COMP_TD_PARA_10_FM_LABEL) {
		this.COMP_TD_PARA_10_FM_LABEL = COMP_TD_PARA_10_FM_LABEL;
	}

	public void setCOMP_TD_PARA_10_FM(HtmlInputText COMP_TD_PARA_10_FM) {
		this.COMP_TD_PARA_10_FM = COMP_TD_PARA_10_FM;
	}

	public HtmlOutputLabel getCOMP_TD_PARA_10_TO_LABEL() {
		return COMP_TD_PARA_10_TO_LABEL;
	}

	public HtmlInputText getCOMP_TD_PARA_10_TO() {
		return COMP_TD_PARA_10_TO;
	}

	public void setCOMP_TD_PARA_10_TO_LABEL(HtmlOutputLabel COMP_TD_PARA_10_TO_LABEL) {
		this.COMP_TD_PARA_10_TO_LABEL = COMP_TD_PARA_10_TO_LABEL;
	}

	public void setCOMP_TD_PARA_10_TO(HtmlInputText COMP_TD_PARA_10_TO) {
		this.COMP_TD_PARA_10_TO = COMP_TD_PARA_10_TO;
	}

	public HtmlOutputLabel getCOMP_TD_RATE_LABEL() {
		return COMP_TD_RATE_LABEL;
	}

	public HtmlInputText getCOMP_TD_RATE() {
		return COMP_TD_RATE;
	}

	public void setCOMP_TD_RATE_LABEL(HtmlOutputLabel COMP_TD_RATE_LABEL) {
		this.COMP_TD_RATE_LABEL = COMP_TD_RATE_LABEL;
	}

	public void setCOMP_TD_RATE(HtmlInputText COMP_TD_RATE) {
		this.COMP_TD_RATE = COMP_TD_RATE;
	}

	public HtmlOutputLabel getCOMP_TD_EFF_FM_DT_LABEL() {
		return COMP_TD_EFF_FM_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TD_EFF_FM_DT() {
		return COMP_TD_EFF_FM_DT;
	}

	public void setCOMP_TD_EFF_FM_DT_LABEL(HtmlOutputLabel COMP_TD_EFF_FM_DT_LABEL) {
		this.COMP_TD_EFF_FM_DT_LABEL = COMP_TD_EFF_FM_DT_LABEL;
	}

	public void setCOMP_TD_EFF_FM_DT(HtmlCalendar COMP_TD_EFF_FM_DT) {
		this.COMP_TD_EFF_FM_DT = COMP_TD_EFF_FM_DT;
	}

	public HtmlOutputLabel getCOMP_TD_EFF_TO_DT_LABEL() {
		return COMP_TD_EFF_TO_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TD_EFF_TO_DT() {
		return COMP_TD_EFF_TO_DT;
	}

	public void setCOMP_TD_EFF_TO_DT_LABEL(HtmlOutputLabel COMP_TD_EFF_TO_DT_LABEL) {
		this.COMP_TD_EFF_TO_DT_LABEL = COMP_TD_EFF_TO_DT_LABEL;
	}

	public void setCOMP_TD_EFF_TO_DT(HtmlCalendar COMP_TD_EFF_TO_DT) {
		this.COMP_TD_EFF_TO_DT = COMP_TD_EFF_TO_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_DTL_TO_HDR() {
		return COMP_UI_M_BUT_DTL_TO_HDR;
	}

	public void setCOMP_UI_M_BUT_DTL_TO_HDR(HtmlCommandButton COMP_UI_M_BUT_DTL_TO_HDR) {
		this.COMP_UI_M_BUT_DTL_TO_HDR = COMP_UI_M_BUT_DTL_TO_HDR;
	}

	public PM_IL_TAR_DTL getPM_IL_TAR_DTL_BEAN() {
		return PM_IL_TAR_DTL_BEAN;
	}

	public void setPM_IL_TAR_DTL_BEAN(PM_IL_TAR_DTL PM_IL_TAR_DTL_BEAN) {
		this.PM_IL_TAR_DTL_BEAN = PM_IL_TAR_DTL_BEAN;
	}

	public List<PM_IL_TAR_DTL> getDataList_PM_IL_TAR_DTL() {
		return dataList_PM_IL_TAR_DTL;
	}

	public void setDataListPM_IL_TAR_DTL(List<PM_IL_TAR_DTL> dataList_PM_IL_TAR_DTL) {
		this.dataList_PM_IL_TAR_DTL = dataList_PM_IL_TAR_DTL;
	}

	public void addRow(ActionEvent event){
		try{
			if (isINSERT_ALLOWED()){

				PM_IL_TAR_DTL_BEAN = new PM_IL_TAR_DTL();
				resetAllComponent();
				resetSelectedRow();
			}else{

				getErrorMap().put("addRow",Messages.getString(PELConstants.pelMessagePropertiesPath, 
						"errorPanel$message$insertnotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath,
								"errorPanel$message$insertnotallowed"));
			}

		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("addRow",exc.getMessage());
		}

	}

	public void deleteRow(ActionEvent event){
		try{
			if (isDELETE_ALLOWED()){
				new CRUDHandler().executeDelete(PM_IL_TAR_DTL_BEAN,CommonUtils.getConnection());
				getWarningMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$delete"));
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
								"errorPanel$message$delete"));
				dataList_PM_IL_TAR_DTL.remove(PM_IL_TAR_DTL_BEAN);
				CommonUtils.getConnection().commit();
				if(dataList_PM_IL_TAR_DTL.size()>0){

					PM_IL_TAR_DTL_BEAN=dataList_PM_IL_TAR_DTL.get(0);
				}else if(dataList_PM_IL_TAR_DTL.size()==0){

					addRow(null);
				}
				resetAllComponent();
				PM_IL_TAR_DTL_BEAN.setRowSelected(true);
			}else{
				getErrorMap().put("deleteRow",Messages.getString(
						PELConstants.pelMessagePropertiesPath, "errorPanel$message$deletenotallowed"));
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
								"errorPanel$message$deletenotallowed"));
			}
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("deleteRow",exc.getMessage());
		}
	}

	public void postRecord(ActionEvent event){
		String paramType = null;
		String code = null;
		try{
			PM_IL_TAR_DTL_BEAN.setTD_PARAM_TYPE(compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().getPM_IL_TAR_HDR_BEAN().getTH_PARAM_TYPE());
			PM_IL_TAR_DTL_BEAN.setTD_TH_CODE(compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().getPM_IL_TAR_HDR_BEAN().getTH_CODE());
			if(PM_IL_TAR_DTL_BEAN.getROWID()==null && isINSERT_ALLOWED()){
				helper.preInsert(PM_IL_TAR_DTL_BEAN);
				new CRUDHandler().executeInsert(PM_IL_TAR_DTL_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
								"errorPanel$message$insert"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$insert"));
				dataList_PM_IL_TAR_DTL.add(PM_IL_TAR_DTL_BEAN);
			}else if(PM_IL_TAR_DTL_BEAN.getROWID()!=null&& isUPDATE_ALLOWED()){
				helper.preUpdate(PM_IL_TAR_DTL_BEAN);
				PM_IL_TAR_DTL_BEAN.setTD_CR_UID(CommonUtils.getControlBean().getUSER_ID());
				
				System.out.println("**********setting value of td_cr_uid**************"+PM_IL_TAR_DTL_BEAN.getTD_CR_UID());
				PM_IL_TAR_DTL_BEAN.setTD_CR_DT(new Date());
				
				new CRUDHandler().executeUpdate(PM_IL_TAR_DTL_BEAN,CommonUtils.getConnection());
				getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
						Messages.getString(PELConstants.pelMessagePropertiesPath, 
								"errorPanel$message$update"));
				getWarningMap().put("postRecord",Messages.getString(
						PELConstants.pelMessagePropertiesPath,"errorPanel$message$update"));
			}
			PM_IL_TAR_DTL_BEAN.setRowSelected(true);
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, 
					"Record not Inserted/Updated :: "+exc.getMessage());
			getErrorMap().put("postRecord","Record not Inserted/Updated :: "+exc.getMessage());
		}
	}

	private int setTD_CR_UID(String user_ID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void displayRecords(){
		CommonUtils.clearMaps(this);
		try{
			resetSelectedRow();
			PM_IL_TAR_DTL_BEAN = (PM_IL_TAR_DTL)dataTable.getRowData();
			PM_IL_TAR_DTL_BEAN.setRowSelected(true);
			resetAllComponent();
		}catch(Exception exc){
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,exc.getMessage());
			getErrorMap().put("displayRecords",exc.getMessage());
		}
	}

	private void resetSelectedRow(){
		Iterator<PM_IL_TAR_DTL> PM_IL_TAR_DTL_ITR = dataList_PM_IL_TAR_DTL.iterator();
		while (PM_IL_TAR_DTL_ITR.hasNext()) {
			PM_IL_TAR_DTL_ITR.next().setRowSelected(false);}
	}

	public void resetAllComponent(){
		COMP_TD_TH_CODE.resetValue();
		COMP_TD_PARAM_TYPE.resetValue();
		COMP_TD_MINIMUM.resetValue();
		COMP_TD_MAXIMUM.resetValue();
		COMP_TD_CHAR_RATE.resetValue();
		COMP_TD_PARA_01_FM.resetValue();
		COMP_TD_PARA_01_TO.resetValue();
		COMP_TD_PARA_02_FM.resetValue();
		COMP_TD_PARA_02_TO.resetValue();
		COMP_TD_PARA_03_FM.resetValue();
		COMP_TD_PARA_03_TO.resetValue();
		COMP_TD_PARA_04_FM.resetValue();
		COMP_TD_PARA_04_TO.resetValue();
		COMP_TD_PARA_05_FM.resetValue();
		COMP_TD_PARA_05_TO.resetValue();
		COMP_TD_PARA_06_FM.resetValue();
		COMP_TD_PARA_06_TO.resetValue();
		COMP_TD_PARA_07_FM.resetValue();
		COMP_TD_PARA_07_TO.resetValue();
		COMP_TD_PARA_08_FM.resetValue();
		COMP_TD_PARA_08_TO.resetValue();
		COMP_TD_PARA_09_FM.resetValue();
		COMP_TD_PARA_09_TO.resetValue();
		COMP_TD_PARA_10_FM.resetValue();
		COMP_TD_PARA_10_TO.resetValue();
		COMP_TD_RATE.resetValue();
		COMP_TD_EFF_FM_DT.resetValue();
		COMP_TD_EFF_TO_DT.resetValue();
	}

	public void setDataTable(UIData dataTable) {
		this.dataTable = dataTable;
	}

	public UIData getDataTable() {
		return dataTable;
	}
	public void saveRecord() {
		try {
			CommonUtils.getConnection().commit();
			getWarningMap().put("SAVE",Messages.getString(
					PELConstants.pelMessagePropertiesPath,"errorPanel$message$save"));
			getWarningMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					Messages.getString(PELConstants.pelMessagePropertiesPath,
							"errorPanel$message$save"));
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("SAVE", e.getMessage());
		}
	}

	public void fireFieldValidation(ActionEvent actionEvent) {
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	public void onLoad(PhaseEvent event) {
		String TH_CODE = null; 
		String TH_PARAM_TYPE = null;
		try {
			if (isBlockFlag()) {
				TH_CODE = compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().
					getPM_IL_TAR_HDR_BEAN().getTH_CODE();
				TH_PARAM_TYPE = compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().
					getPM_IL_TAR_HDR_BEAN().getTH_PARAM_TYPE();
				
				// Setting param type to tariff detail bean for new block instance
				PM_IL_TAR_DTL_BEAN.setTD_PARAM_TYPE(TH_PARAM_TYPE);
				PM_IL_TAR_DTL_BEAN.setTD_TH_CODE(TH_CODE);
				helper.WHEN_NEW_BLOCK_INSTANCE(
						compositeAction.getPM_IL_TAR_HDR_ACTION_BEAN().getPM_IL_TAR_HDR_BEAN(),
						compositeAction.getBP_ACTION_BEAN().getBP_BEAN(), this, 
						compositeAction.getPP_LIST_ITEM_VALUES_ACTION_BEAN().getPP_LIST_ITEM_VALUES_BEAN(),
						compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN());
				helper.executeQuery(compositeAction, TH_CODE, TH_PARAM_TYPE);
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("onLoad",e.getMessage());
		}
	}
	public void validateTD_MINIMUM(FacesContext context, UIComponent component, 
			Object value){
		try {
			PM_IL_TAR_DTL_BEAN.setTD_MINIMUM((Double) value);
			helper.WHEN_VALIDATE_ITEM_TD_MIN(this.PM_IL_TAR_DTL_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTD_EFF_FM_DT(FacesContext context, UIComponent component, 
			Object value){
		try {
			PM_IL_TAR_DTL_BEAN.setTD_EFF_FM_DT((Date) value);
			helper.WHEN_VALIDATE_ITEM_TD_EFF_FM_DT(this.PM_IL_TAR_DTL_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTD_EFF_TO_DT(FacesContext context, UIComponent component, 
			Object value){
		try {
			PM_IL_TAR_DTL_BEAN.setTD_EFF_TO_DT((Date) value);
			helper.WHEN_VALIDATE_ITEM_TD_EFF_TO_DT(this.PM_IL_TAR_DTL_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTD_MAXIMUM(FacesContext context, UIComponent component, 
			Object value){
		try {
			PM_IL_TAR_DTL_BEAN.setTD_MAXIMUM((Double) value);
			helper.WHEN_VALIDATE_ITEM_TD_MAX(this.PM_IL_TAR_DTL_BEAN);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTD_RATE(FacesContext context, UIComponent component, 
			Object value){
		try {
			helper.WHEN_VALIDATE_ITEM_TD_RATE(this.PM_IL_TAR_DTL_BEAN);
			PM_IL_TAR_DTL_BEAN.setTD_RATE((Double) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}
	
	public void validateTD_CHAR_RATE(FacesContext context, UIComponent component, 
			Object value){
		try {
			helper.WHEN_VALIDATE_ITEM_TD_CHAR_RATE(this.PM_IL_TAR_DTL_BEAN);
			PM_IL_TAR_DTL_BEAN.setTD_CHAR_RATE((String) value);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateTO_PARA(FacesContext context, UIComponent component, 
			Object value){
		String TD_PARA_FM = null;
		String TD_PARA_TO = null;
		String dummyValue = null;
		String compId = component.getId();
		String tovalue = (String) value;
		try {
			if(compId.equals(getCOMP_TD_PARA_01_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_01_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_01();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_01_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_02_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_02_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_02();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_02_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_03_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_03_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_03();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_03_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_04_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_04_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_04();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_04_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_05_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_05_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_05();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_05_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_06_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_06_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_06();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_06_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_07_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_07_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_07();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_07_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_08_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_08_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_08();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_08_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_09_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_09_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_09();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_09_TO(TD_PARA_TO);
			}else if(compId.equals(getCOMP_TD_PARA_10_TO().getId())){
				TD_PARA_FM = PM_IL_TAR_DTL_BEAN.getTD_PARA_10_FM();
				TD_PARA_TO = tovalue;
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_10();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_10_TO(TD_PARA_TO);
			}
			helper.WHEN_VALIDATE_ITEMTD_PARA_TO(TD_PARA_FM, TD_PARA_TO, dummyValue);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public void validateFROM_PARA(FacesContext context, UIComponent component, 
			Object value){
		String TD_PARA_FM = null;
		String TD_PARA_TO = null;
		String dummyValue = null;
		String compId = null;
		String fmvalue = (String) value;
		try {
			compId = component.getId();
			if(compId.equals(getCOMP_TD_PARA_01_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_01_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_01();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_01_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_02_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_02_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_02();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_02_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_03_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_03_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_03();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_03_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_04_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_04_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_04();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_04_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_05_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_05_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_05();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_05_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_06_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_06_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_06();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_06_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_07_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_07_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_07();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_07_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_08_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_08_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_08();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_08_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_09_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_09_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_09();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_09_FM(TD_PARA_FM);
			}else if(compId.equals(getCOMP_TD_PARA_10_FM().getId())){
				TD_PARA_FM = fmvalue;
				TD_PARA_TO = PM_IL_TAR_DTL_BEAN.getTD_PARA_10_TO();
				dummyValue = compositeAction.getPM_IL_TAR_DTL_DUMMY_BEAN().getTH_PARA_DAT_10();
				PM_IL_TAR_DTL_BEAN.setTD_PARA_10_FM(TD_PARA_FM);
			}
			helper.WHEN_VALIDATE_ITEMTD_PARA_FM(TD_PARA_FM, TD_PARA_TO, dummyValue);
		} catch (Exception e) {
			throw new ValidatorException(new FacesMessage(e.getMessage()));
		}
	}

	public PM_IL_TAR_DTL_DUMMY getPM_IL_TAR_DTL_DUMMY_BEAN() {
		return PM_IL_TAR_DTL_DUMMY_BEAN;
	}

	public void setPM_IL_TAR_DTL_DUMMY_BEAN(
			PM_IL_TAR_DTL_DUMMY pm_il_tar_dtl_dummy_bean) {
		PM_IL_TAR_DTL_DUMMY_BEAN = pm_il_tar_dtl_dummy_bean;
	}
	
	/*added for tariff lov on 27-05-2016*/
	//added by krithika
	public ArrayList<com.iii.premia.common.bean.LovBean> lovTreaty_code(
			Object currValue) {
		System.out.println("Welcome to lovPOL_PROD_CODE method");
		String name=(String)CommonUtils.getGlobalObject("LOV");
		
		System.out.println("Title  :"+name);
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM015_APAC",
					"PM_IL_PROP_TREATY", "PT_TREATY_CODE", null, null, null, null,
					null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------lovPOL_PROD_CODE---------------------->"+suggestionList);
		return suggestionList;
	}
	//end
	/*added by gopi*/
	public ArrayList<com.iii.premia.common.bean.LovBean> lovCover_code(
			Object currValue) {
		System.out.println("Welcome to lovCover_codeE method");
		String name=(String)CommonUtils.getGlobalObject("LOV");
		
		System.out.println("Title  :"+name);
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILM007",
					"PM_IL_CLM_REPAY", "CR_COVER_CODE","B","A", null, null,null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------lovCover_codeE---------------------->"+suggestionList);
		return suggestionList;
	}
	
	

	public ArrayList<com.iii.premia.common.bean.LovBean> lovPOL_PROD_CODE(
			Object currValue) {
		System.out.println("Welcome to lovPOL_PROD_CODE method");
		String name=(String)CommonUtils.getGlobalObject("LOV");
		
		System.out.println("Title  :"+name);
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POLICY", "POL_PROD_CODE", null, null, null, null,
					null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------lovPOL_PROD_CODE---------------------->"+suggestionList);
		return suggestionList;
	}
	
	/*Added by saritha*/
	
	/*public ArrayList<com.iii.premia.common.bean.LovBean> lovMOP(
			Object currValue) {
		System.out.println("Welcome to lovMOP method");
		String name=(String)CommonUtils.getGlobalObject("LOV");
		System.out.println("Title  :"+name);
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PM_IL_TAR_HDR","TH_PARA_03","PAYMODE",null, null, null,null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------lov Mode of Payment ---------------------->"+suggestionList);
		return suggestionList;
	}*/
	
	 public ArrayList<LovBean> lovMOP(Object object) {
		 System.out.println("Welcome to lovMOP method");
	    	ArrayList<LovBean> lovList = new ArrayList<LovBean>();
			String query = "SELECT LIV_CODE,LIV_CODE_DESC FROM PP_LIST_ITEM_VALUES WHERE LIV_SYS_PARAM='PAYMODE' AND LIV_CODE LIKE ?";
			Object[] values = null;
			String currentValue = (String) object;

			try {
				currentValue = "*".equals(currentValue) ? "%" : currentValue + "%";

				values = new Object[] { currentValue};
				lovList = ListItemUtil.prepareSuggestionList(query, values);
			} catch (Exception e) {
				e.printStackTrace();
				getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
						e.getMessage());
				getErrorMap().put("SUGGETION", e.getMessage());
			}
			System.out.println("-------lov Mode of Payment ---------------------->"+lovList);
			return lovList;
	    }


	 public ArrayList<com.iii.premia.common.bean.LovBean> lovOcc_code(
			Object currValue) {
		System.out.println("Welcome to lovOcc_code method");
		String name=(String)CommonUtils.getGlobalObject("LOV");
		
		System.out.println("Title  :"+name);
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS", "POAD_OCC_CODE","IL_OCCU",null,null, null,null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------lovOcc_code---------------------->"+suggestionList);
		return suggestionList;
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovOccupation_Class(
			Object currValue) {
		System.out.println("Welcome to lovOccupation_Class method");
		String name=(String)CommonUtils.getGlobalObject("LOV");
		
		System.out.println("Title  :"+name);
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PILT002_APAC",
					"PT_IL_POL_ASSURED_DTLS", "POAD_OCC_CLASS","IL_OCC_CLASS",null,null, null,null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------lovOccupation_Class---------------------->"+suggestionList);
		return suggestionList;
	}
	
	public ArrayList<com.iii.premia.common.bean.LovBean> lovCategory(
			Object currValue) {
		System.out.println("Welcome to lovCategory method");
		String name=(String)CommonUtils.getGlobalObject("LOV");
		
		System.out.println("Title  :"+name);
		ArrayList<com.iii.premia.common.bean.LovBean> suggestionList = new ArrayList<com.iii.premia.common.bean.LovBean>();
		ListItemUtil listitemutil = new ListItemUtil();
		try {
			suggestionList = listitemutil.P_CALL_LOV("PM075_A",
					"PM_CUSTOMER", "CUST_CATG_CODE","CATG",null,null, null,null, (String) currValue);
			System.out.println("suggestionList     "+suggestionList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("-------lovCategory---------------------->"+suggestionList);
		return suggestionList;
	}
	
	public void PARA_01_SUGG() throws Exception{
		COMP_TD_PARA_01_SUGG.setRendered(true);
		COMP_TD_PARA_01_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_01_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_01_FM.getTitle());
		//COMP_TD_PARA_01_SUGG.setSuggestionAction(call(COMP_TD_PARA_01_FM.getTitle()));
		//COMP_TD_PARA_01_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_01_FM.getTitle()));
		COMP_TD_PARA_01_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_01_SUGG_TO.setSuggestionAction(call());
		System.out.println("hai");

	}
	public void PARA_02_SUGG(){
		COMP_TD_PARA_02_SUGG.setRendered(true);
		COMP_TD_PARA_02_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_02_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_02_FM.getTitle());
		//COMP_TD_PARA_02_SUGG.setSuggestionAction(call(COMP_TD_PARA_02_FM.getTitle()));
		//COMP_TD_PARA_02_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_02_FM.getTitle()));
		
		COMP_TD_PARA_02_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_02_SUGG_TO.setSuggestionAction(call());
	}
	public void PARA_03_SUGG(){
		COMP_TD_PARA_03_SUGG.setRendered(true);
		COMP_TD_PARA_03_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_03_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_03_FM.getTitle());
		//COMP_TD_PARA_03_SUGG.setSuggestionAction(call(COMP_TD_PARA_03_FM.getTitle()));
		//COMP_TD_PARA_03_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_03_FM.getTitle()));
		COMP_TD_PARA_03_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_03_SUGG_TO.setSuggestionAction(call());
	}
	public void PARA_04_SUGG(){
		COMP_TD_PARA_04_SUGG.setRendered(true);
		COMP_TD_PARA_04_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_04_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_04_FM.getTitle());
		//COMP_TD_PARA_04_SUGG.setSuggestionAction(call(COMP_TD_PARA_04_FM.getTitle()));
		//COMP_TD_PARA_04_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_04_FM.getTitle()));
		COMP_TD_PARA_04_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_04_SUGG_TO.setSuggestionAction(call());
	}
	public void PARA_05_SUGG(){
		COMP_TD_PARA_05_SUGG.setRendered(true);
		COMP_TD_PARA_05_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_05_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_05_FM.getTitle());
		//COMP_TD_PARA_05_SUGG.setSuggestionAction(call(COMP_TD_PARA_05_FM.getTitle()));
		//COMP_TD_PARA_05_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_05_FM.getTitle()));
		COMP_TD_PARA_05_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_05_SUGG_TO.setSuggestionAction(call());
	}
	public void PARA_06_SUGG(){
		COMP_TD_PARA_06_SUGG.setRendered(true);
		COMP_TD_PARA_06_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_06_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_06_FM.getTitle());
		//COMP_TD_PARA_06_SUGG.setSuggestionAction(call(COMP_TD_PARA_06_FM.getTitle()));
		//COMP_TD_PARA_06_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_06_FM.getTitle()));
		COMP_TD_PARA_06_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_06_SUGG_TO.setSuggestionAction(call());
	}
	//added by saranya
	public void PARA_07_SUGG(){
		COMP_TD_PARA_07_SUGG.setRendered(true);
		COMP_TD_PARA_07_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_07_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_07_FM.getTitle());
		//COMP_TD_PARA_06_SUGG.setSuggestionAction(call(COMP_TD_PARA_06_FM.getTitle()));
		//COMP_TD_PARA_06_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_06_FM.getTitle()));
		COMP_TD_PARA_07_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_07_SUGG_TO.setSuggestionAction(call());
	}
	public void PARA_08_SUGG(){
		COMP_TD_PARA_08_SUGG.setRendered(true);
		COMP_TD_PARA_08_SUGG_TO.setRendered(true);
		System.out.println("Title eeee :"+COMP_TD_PARA_08_FM.getTitle());
		CommonUtils.setGlobalObject("LOV", COMP_TD_PARA_08_FM.getTitle());
		//COMP_TD_PARA_06_SUGG.setSuggestionAction(call(COMP_TD_PARA_06_FM.getTitle()));
		//COMP_TD_PARA_06_SUGG_TO.setSuggestionAction(call(COMP_TD_PARA_06_FM.getTitle()));
		COMP_TD_PARA_08_SUGG.setSuggestionAction(call());
		COMP_TD_PARA_08_SUGG_TO.setSuggestionAction(call());
	}
	//end
	
	public MethodExpression call(){
		System.out.println("***********************************WELCOME TO call********************");
			
			FacesContext ctx=FacesContext.getCurrentInstance();
			String Exp =null;
			
			String ip=(String)CommonUtils.getGlobalVariable("KEY");
			if(ip.equals("48")){
				Exp="#{PILM034_COMPOSITE_ACTION.PM_IL_TAR_DTL_ACTION_BEAN.lovPOL_PROD_CODE}";
			}
			else if(ip.equals("14")){
				Exp="#{PILM034_COMPOSITE_ACTION.PM_IL_TAR_DTL_ACTION_BEAN.lovMOP}";
			}
			else if(ip.equals("50")){
				Exp="#{PILM034_COMPOSITE_ACTION.PM_IL_TAR_DTL_ACTION_BEAN.lovCover_code}";
			}
			else if(ip.equals("4")){
				Exp="#{PILM034_COMPOSITE_ACTION.PM_IL_TAR_DTL_ACTION_BEAN.lovOcc_code}";
			}
			else if(ip.equals("11")){
				Exp="#{PILM034_COMPOSITE_ACTION.PM_IL_TAR_DTL_ACTION_BEAN.lovCategory}";
			}
			else if(ip.equals("25")){
				Exp="#{PILM034_COMPOSITE_ACTION.PM_IL_TAR_DTL_ACTION_BEAN.lovOccupation_Class}";
			}
			else if(ip.equals("94")){
				Exp="#{PILM034_COMPOSITE_ACTION.PM_IL_TAR_DTL_ACTION_BEAN.lovTreaty_code}";
			}
			return ctx.getApplication().getExpressionFactory().createMethodExpression(ctx.getELContext(),Exp,null,new Class[]{java.lang.Object.class});
		}
	
	//end
	//added by saranya
	public void initalizecomponent(){
		COMP_TD_PARA_01_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_01_SUGG_TO = new HtmlSuggestionBox();
		COMP_TD_PARA_02_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_02_SUGG_TO = new HtmlSuggestionBox();
		COMP_TD_PARA_03_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_03_SUGG_TO = new HtmlSuggestionBox();
		COMP_TD_PARA_04_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_04_SUGG_TO = new HtmlSuggestionBox();
		COMP_TD_PARA_05_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_05_SUGG_TO = new HtmlSuggestionBox();
		COMP_TD_PARA_06_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_06_SUGG_TO = new HtmlSuggestionBox();
		COMP_TD_PARA_07_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_07_SUGG_TO = new HtmlSuggestionBox();
		COMP_TD_PARA_08_SUGG = new HtmlSuggestionBox();
		COMP_TD_PARA_08_SUGG_TO = new HtmlSuggestionBox();
		
	}
	//end
	
}
