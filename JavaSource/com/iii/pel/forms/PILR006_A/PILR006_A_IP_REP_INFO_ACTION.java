package com.iii.pel.forms.PILR006_A;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.HttpServletResponse;

import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlModalPanel;

import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.action.CommonReportAction;
import com.iii.premia.common.bean.LovBean;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.constants.REPORT_UTIL_CONSTANTS;
import com.iii.premia.common.errorUtil.ErrorHelpUtil;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
import com.iii.premia.common.utils.ListItemUtil;
import com.iii.premia.common.utils.ReportUtils;


public class PILR006_A_IP_REP_INFO_ACTION  extends CommonReportAction{
	
	private HtmlSelectOneRadio COMP_SELECT_FILE_TYPE;
	private HtmlSelectOneRadio COMP_SELECT_POL_STATUS ;
	private HtmlSelectOneRadio COMP_SELECT_CUST_TYPE ;
	private HtmlSelectOneRadio COMP_SELECT_CUST_STATUS ;
		
	private IP_REP_INFO IP_REP_INFO_BEAN;
	
	private String reportsDatePattern=PELConstants.dbDateFormat;
	
	private HtmlOutputLabel COMP_1_LABEL;
	private HtmlOutputLabel COMP_2_LABEL;
	private HtmlOutputLabel COMP_3_LABEL;
	private HtmlOutputLabel COMP_4_LABEL;
	private HtmlOutputLabel COMP_5_LABEL;
	private HtmlOutputLabel COMP_6_LABEL;
	private HtmlOutputLabel COMP_7_LABEL;
	private HtmlOutputLabel COMP_8_LABEL;
	private HtmlOutputLabel COMP_9_LABEL;
	private HtmlOutputLabel COMP_10_LABEL;
	private HtmlOutputLabel COMP_11_LABEL;
	private HtmlOutputLabel COMP_12_LABEL;
	private HtmlOutputLabel COMP_13_LABEL;
	private HtmlOutputLabel COMP_14_LABEL;
	private HtmlOutputLabel COMP_15_LABEL;
	private HtmlOutputLabel COMP_16_LABEL;
	private HtmlOutputLabel COMP_17_LABEL;
	private HtmlOutputLabel COMP_18_LABEL;
	private HtmlOutputLabel COMP_19_LABEL;
	private HtmlOutputLabel COMP_20_LABEL;
	private HtmlOutputLabel COMP_21_LABEL;
	private HtmlOutputLabel COMP_22_LABEL;
	private HtmlOutputLabel COMP_23_LABEL;
	private HtmlOutputLabel COMP_24_LABEL;
	private HtmlOutputLabel COMP_25_LABEL;
	private HtmlOutputLabel COMP_26_LABEL;
	private HtmlOutputLabel COMP_27_LABEL;
	private HtmlOutputLabel COMP_28_LABEL;
	private HtmlOutputLabel COMP_29_LABEL;
	private HtmlOutputLabel COMP_30_LABEL;
	private HtmlOutputLabel COMP_31_LABEL;
	private HtmlOutputLabel COMP_32_LABEL;
	private HtmlOutputLabel COMP_33_LABEL;
	private HtmlOutputLabel COMP_34_LABEL;
	private HtmlOutputLabel COMP_35_LABEL;
	private HtmlOutputLabel COMP_36_LABEL;
	private HtmlOutputLabel COMP_37_LABEL;
	private HtmlOutputLabel COMP_38_LABEL;
	private HtmlOutputLabel COMP_39_LABEL;
	private HtmlOutputLabel COMP_40_LABEL;
	private HtmlOutputLabel COMP_41_LABEL;
	private HtmlOutputLabel COMP_42_LABEL;
	private HtmlOutputLabel COMP_43_LABEL;
	private HtmlOutputLabel COMP_44_LABEL;
	private HtmlOutputLabel COMP_45_LABEL;
	private HtmlOutputLabel COMP_46_LABEL;
	private HtmlOutputLabel COMP_47_LABEL;
	private HtmlOutputLabel COMP_48_LABEL;
	private HtmlOutputLabel COMP_49_LABEL;
	private HtmlOutputLabel COMP_50_LABEL;
	private HtmlOutputLabel COMP_51_LABEL;
	private HtmlOutputLabel COMP_52_LABEL;
	private HtmlOutputLabel COMP_53_LABEL;
	private HtmlOutputLabel COMP_54_LABEL;
	private HtmlOutputLabel COMP_55_LABEL;
	private HtmlOutputLabel COMP_56_LABEL;
	private HtmlOutputLabel COMP_57_LABEL;
	private HtmlOutputLabel COMP_58_LABEL;
	private HtmlOutputLabel COMP_59_LABEL;
	private HtmlOutputLabel COMP_60_LABEL;
	
	
	private HtmlCalendar COMP_1_CALENDER;
	private HtmlCalendar COMP_2_CALENDER;
	private HtmlCalendar COMP_3_CALENDER;
	private HtmlCalendar COMP_4_CALENDER;
	private HtmlCalendar COMP_5_CALENDER;
	private HtmlCalendar COMP_6_CALENDER;
	private HtmlCalendar COMP_7_CALENDER;
	private HtmlCalendar COMP_8_CALENDER;
	private HtmlCalendar COMP_9_CALENDER;
	private HtmlCalendar COMP_10_CALENDER;
	private HtmlCalendar COMP_11_CALENDER;
	private HtmlCalendar COMP_12_CALENDER;
	private HtmlCalendar COMP_13_CALENDER;
	private HtmlCalendar COMP_14_CALENDER;
	private HtmlCalendar COMP_15_CALENDER;
	private HtmlCalendar COMP_16_CALENDER;
	private HtmlCalendar COMP_17_CALENDER;
	private HtmlCalendar COMP_18_CALENDER;
	private HtmlCalendar COMP_19_CALENDER;
	private HtmlCalendar COMP_20_CALENDER;
	private HtmlCalendar COMP_21_CALENDER;
	private HtmlCalendar COMP_22_CALENDER;
	private HtmlCalendar COMP_23_CALENDER;
	private HtmlCalendar COMP_24_CALENDER;
	private HtmlCalendar COMP_25_CALENDER;
	private HtmlCalendar COMP_26_CALENDER;
	private HtmlCalendar COMP_27_CALENDER;
	private HtmlCalendar COMP_28_CALENDER;
	private HtmlCalendar COMP_29_CALENDER;
	private HtmlCalendar COMP_30_CALENDER;
	private HtmlCalendar COMP_31_CALENDER;
	private HtmlCalendar COMP_32_CALENDER;
	private HtmlCalendar COMP_33_CALENDER;
	private HtmlCalendar COMP_34_CALENDER;
	private HtmlCalendar COMP_35_CALENDER;
	private HtmlCalendar COMP_36_CALENDER;
	private HtmlCalendar COMP_37_CALENDER;
	private HtmlCalendar COMP_38_CALENDER;
	private HtmlCalendar COMP_39_CALENDER;
	private HtmlCalendar COMP_40_CALENDER;
	private HtmlCalendar COMP_41_CALENDER;
	private HtmlCalendar COMP_42_CALENDER;
	private HtmlCalendar COMP_43_CALENDER;
	private HtmlCalendar COMP_44_CALENDER;
	private HtmlCalendar COMP_45_CALENDER;
	private HtmlCalendar COMP_46_CALENDER;
	private HtmlCalendar COMP_47_CALENDER;
	private HtmlCalendar COMP_48_CALENDER;
	private HtmlCalendar COMP_49_CALENDER;
	private HtmlCalendar COMP_50_CALENDER;
	private HtmlCalendar COMP_51_CALENDER;
	private HtmlCalendar COMP_52_CALENDER;
	private HtmlCalendar COMP_53_CALENDER;
	private HtmlCalendar COMP_54_CALENDER;
	private HtmlCalendar COMP_55_CALENDER;
	private HtmlCalendar COMP_56_CALENDER;
	private HtmlCalendar COMP_57_CALENDER;
	private HtmlCalendar COMP_58_CALENDER;
	private HtmlCalendar COMP_59_CALENDER;
	private HtmlCalendar COMP_60_CALENDER;
	
	private HtmlInputText COMP_1_INPUT_TEXT;
	private HtmlInputText COMP_2_INPUT_TEXT;
	private HtmlInputText COMP_3_INPUT_TEXT;
	private HtmlInputText COMP_4_INPUT_TEXT;
	private HtmlInputText COMP_5_INPUT_TEXT;
	private HtmlInputText COMP_6_INPUT_TEXT;
	private HtmlInputText COMP_7_INPUT_TEXT;
	private HtmlInputText COMP_8_INPUT_TEXT;
	private HtmlInputText COMP_9_INPUT_TEXT;
	private HtmlInputText COMP_10_INPUT_TEXT;
	private HtmlInputText COMP_11_INPUT_TEXT;
	private HtmlInputText COMP_12_INPUT_TEXT;
	private HtmlInputText COMP_13_INPUT_TEXT;
	private HtmlInputText COMP_14_INPUT_TEXT;
	private HtmlInputText COMP_15_INPUT_TEXT;
	private HtmlInputText COMP_16_INPUT_TEXT;
	private HtmlInputText COMP_17_INPUT_TEXT;
	private HtmlInputText COMP_18_INPUT_TEXT;
	private HtmlInputText COMP_19_INPUT_TEXT;
	private HtmlInputText COMP_20_INPUT_TEXT;
	private HtmlInputText COMP_21_INPUT_TEXT;
	private HtmlInputText COMP_22_INPUT_TEXT;
	private HtmlInputText COMP_23_INPUT_TEXT;
	private HtmlInputText COMP_24_INPUT_TEXT;
	private HtmlInputText COMP_25_INPUT_TEXT;
	private HtmlInputText COMP_26_INPUT_TEXT;
	private HtmlInputText COMP_27_INPUT_TEXT;
	private HtmlInputText COMP_28_INPUT_TEXT;
	private HtmlInputText COMP_29_INPUT_TEXT;
	private HtmlInputText COMP_30_INPUT_TEXT;
	private HtmlInputText COMP_31_INPUT_TEXT;
	private HtmlInputText COMP_32_INPUT_TEXT;
	private HtmlInputText COMP_33_INPUT_TEXT;
	private HtmlInputText COMP_34_INPUT_TEXT;
	private HtmlInputText COMP_35_INPUT_TEXT;
	private HtmlInputText COMP_36_INPUT_TEXT;
	private HtmlInputText COMP_37_INPUT_TEXT;
	private HtmlInputText COMP_38_INPUT_TEXT;
	private HtmlInputText COMP_39_INPUT_TEXT;
	private HtmlInputText COMP_40_INPUT_TEXT;
	private HtmlInputText COMP_41_INPUT_TEXT;
	private HtmlInputText COMP_42_INPUT_TEXT;
	private HtmlInputText COMP_43_INPUT_TEXT;
	private HtmlInputText COMP_44_INPUT_TEXT;
	private HtmlInputText COMP_45_INPUT_TEXT;
	private HtmlInputText COMP_46_INPUT_TEXT;
	private HtmlInputText COMP_47_INPUT_TEXT;
	private HtmlInputText COMP_48_INPUT_TEXT;
	private HtmlInputText COMP_49_INPUT_TEXT;
	private HtmlInputText COMP_50_INPUT_TEXT;
	private HtmlInputText COMP_51_INPUT_TEXT;
	private HtmlInputText COMP_52_INPUT_TEXT;
	private HtmlInputText COMP_53_INPUT_TEXT;
	private HtmlInputText COMP_54_INPUT_TEXT;
	private HtmlInputText COMP_55_INPUT_TEXT;
	private HtmlInputText COMP_56_INPUT_TEXT;
	private HtmlInputText COMP_57_INPUT_TEXT;
	private HtmlInputText COMP_58_INPUT_TEXT;
	private HtmlInputText COMP_59_INPUT_TEXT;
	private HtmlInputText COMP_60_INPUT_TEXT;
	
	private HtmlSelectOneMenu COMP_1_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_2_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_3_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_4_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_5_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_6_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_7_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_8_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_9_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_10_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_11_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_12_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_13_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_14_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_15_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_16_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_17_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_18_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_19_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_20_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_21_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_22_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_23_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_24_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_25_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_26_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_27_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_28_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_29_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_30_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_31_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_32_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_33_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_34_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_35_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_36_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_37_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_38_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_39_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_40_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_41_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_42_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_43_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_44_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_45_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_46_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_47_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_48_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_49_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_50_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_51_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_52_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_53_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_54_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_55_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_56_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_57_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_58_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_59_SELECT_ONE_MENU;
	private HtmlSelectOneMenu COMP_60_SELECT_ONE_MENU;
	
	private boolean COMP_1_CALENDER_RENDERED;
	private boolean COMP_2_CALENDER_RENDERED;
	private boolean COMP_3_CALENDER_RENDERED;
	private boolean COMP_4_CALENDER_RENDERED;
	private boolean COMP_5_CALENDER_RENDERED;
	private boolean COMP_6_CALENDER_RENDERED;
	private boolean COMP_7_CALENDER_RENDERED;
	private boolean COMP_8_CALENDER_RENDERED;
	private boolean COMP_9_CALENDER_RENDERED;
	private boolean COMP_10_CALENDER_RENDERED;
	private boolean COMP_11_CALENDER_RENDERED;
	private boolean COMP_12_CALENDER_RENDERED;
	private boolean COMP_13_CALENDER_RENDERED;
	private boolean COMP_14_CALENDER_RENDERED;
	private boolean COMP_15_CALENDER_RENDERED;
	private boolean COMP_16_CALENDER_RENDERED;
	private boolean COMP_17_CALENDER_RENDERED;
	private boolean COMP_18_CALENDER_RENDERED;
	private boolean COMP_19_CALENDER_RENDERED;
	private boolean COMP_20_CALENDER_RENDERED;
	private boolean COMP_21_CALENDER_RENDERED;
	private boolean COMP_22_CALENDER_RENDERED;
	private boolean COMP_23_CALENDER_RENDERED;
	private boolean COMP_24_CALENDER_RENDERED;
	private boolean COMP_25_CALENDER_RENDERED;
	private boolean COMP_26_CALENDER_RENDERED;
	private boolean COMP_27_CALENDER_RENDERED;
	private boolean COMP_28_CALENDER_RENDERED;
	private boolean COMP_29_CALENDER_RENDERED;
	private boolean COMP_30_CALENDER_RENDERED;
	private boolean COMP_31_CALENDER_RENDERED;
	private boolean COMP_32_CALENDER_RENDERED;
	private boolean COMP_33_CALENDER_RENDERED;
	private boolean COMP_34_CALENDER_RENDERED;
	private boolean COMP_35_CALENDER_RENDERED;
	private boolean COMP_36_CALENDER_RENDERED;
	private boolean COMP_37_CALENDER_RENDERED;
	private boolean COMP_38_CALENDER_RENDERED;
	private boolean COMP_39_CALENDER_RENDERED;
	private boolean COMP_40_CALENDER_RENDERED;
	private boolean COMP_41_CALENDER_RENDERED;
	private boolean COMP_42_CALENDER_RENDERED;
	private boolean COMP_43_CALENDER_RENDERED;
	private boolean COMP_44_CALENDER_RENDERED;
	private boolean COMP_45_CALENDER_RENDERED;
	private boolean COMP_46_CALENDER_RENDERED;
	private boolean COMP_47_CALENDER_RENDERED;
	private boolean COMP_48_CALENDER_RENDERED;
	private boolean COMP_49_CALENDER_RENDERED;
	private boolean COMP_50_CALENDER_RENDERED;
	private boolean COMP_51_CALENDER_RENDERED;
	private boolean COMP_52_CALENDER_RENDERED;
	private boolean COMP_53_CALENDER_RENDERED;
	private boolean COMP_54_CALENDER_RENDERED;
	private boolean COMP_55_CALENDER_RENDERED;
	private boolean COMP_56_CALENDER_RENDERED;
	private boolean COMP_57_CALENDER_RENDERED;
	private boolean COMP_58_CALENDER_RENDERED;
	private boolean COMP_59_CALENDER_RENDERED;
	private boolean COMP_60_CALENDER_RENDERED;
	
	
	private boolean COMP_1_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_2_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_3_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_4_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_5_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_6_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_7_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_8_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_9_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_10_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_11_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_12_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_13_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_14_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_15_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_16_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_17_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_18_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_19_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_20_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_21_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_22_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_23_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_24_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_25_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_26_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_27_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_28_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_29_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_30_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_31_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_32_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_33_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_34_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_35_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_36_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_37_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_38_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_39_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_40_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_41_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_42_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_43_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_44_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_45_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_46_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_47_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_48_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_49_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_50_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_51_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_52_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_53_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_54_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_55_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_56_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_57_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_58_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_59_SELECT_ONE_MENU_RENDERED;
	private boolean COMP_60_SELECT_ONE_MENU_RENDERED;
	
	
	private boolean COMP_1_INPUT_TEXT_RENDERED;
	private boolean COMP_2_INPUT_TEXT_RENDERED;
	private boolean COMP_3_INPUT_TEXT_RENDERED;
	private boolean COMP_4_INPUT_TEXT_RENDERED;
	private boolean COMP_5_INPUT_TEXT_RENDERED;
	private boolean COMP_6_INPUT_TEXT_RENDERED;
	private boolean COMP_7_INPUT_TEXT_RENDERED;
	private boolean COMP_8_INPUT_TEXT_RENDERED;
	private boolean COMP_9_INPUT_TEXT_RENDERED;
	private boolean COMP_10_INPUT_TEXT_RENDERED;
	private boolean COMP_11_INPUT_TEXT_RENDERED;
	private boolean COMP_12_INPUT_TEXT_RENDERED;
	private boolean COMP_13_INPUT_TEXT_RENDERED;
	private boolean COMP_14_INPUT_TEXT_RENDERED;
	private boolean COMP_15_INPUT_TEXT_RENDERED;
	private boolean COMP_16_INPUT_TEXT_RENDERED;
	private boolean COMP_17_INPUT_TEXT_RENDERED;
	private boolean COMP_18_INPUT_TEXT_RENDERED;
	private boolean COMP_19_INPUT_TEXT_RENDERED;
	private boolean COMP_20_INPUT_TEXT_RENDERED;
	private boolean COMP_21_INPUT_TEXT_RENDERED;
	private boolean COMP_22_INPUT_TEXT_RENDERED;
	private boolean COMP_23_INPUT_TEXT_RENDERED;
	private boolean COMP_24_INPUT_TEXT_RENDERED;
	private boolean COMP_25_INPUT_TEXT_RENDERED;
	private boolean COMP_26_INPUT_TEXT_RENDERED;
	private boolean COMP_27_INPUT_TEXT_RENDERED;
	private boolean COMP_28_INPUT_TEXT_RENDERED;
	private boolean COMP_29_INPUT_TEXT_RENDERED;
	private boolean COMP_30_INPUT_TEXT_RENDERED;
	private boolean COMP_31_INPUT_TEXT_RENDERED;
	private boolean COMP_32_INPUT_TEXT_RENDERED;
	private boolean COMP_33_INPUT_TEXT_RENDERED;
	private boolean COMP_34_INPUT_TEXT_RENDERED;
	private boolean COMP_35_INPUT_TEXT_RENDERED;
	private boolean COMP_36_INPUT_TEXT_RENDERED;
	private boolean COMP_37_INPUT_TEXT_RENDERED;
	private boolean COMP_38_INPUT_TEXT_RENDERED;
	private boolean COMP_39_INPUT_TEXT_RENDERED;
	private boolean COMP_40_INPUT_TEXT_RENDERED;
	private boolean COMP_41_INPUT_TEXT_RENDERED;
	private boolean COMP_42_INPUT_TEXT_RENDERED;
	private boolean COMP_43_INPUT_TEXT_RENDERED;
	private boolean COMP_44_INPUT_TEXT_RENDERED;
	private boolean COMP_45_INPUT_TEXT_RENDERED;
	private boolean COMP_46_INPUT_TEXT_RENDERED;
	private boolean COMP_47_INPUT_TEXT_RENDERED;
	private boolean COMP_48_INPUT_TEXT_RENDERED;
	private boolean COMP_49_INPUT_TEXT_RENDERED;
	private boolean COMP_50_INPUT_TEXT_RENDERED;
	private boolean COMP_51_INPUT_TEXT_RENDERED;
	private boolean COMP_52_INPUT_TEXT_RENDERED;
	private boolean COMP_53_INPUT_TEXT_RENDERED;
	private boolean COMP_54_INPUT_TEXT_RENDERED;
	private boolean COMP_55_INPUT_TEXT_RENDERED;
	private boolean COMP_56_INPUT_TEXT_RENDERED;
	private boolean COMP_57_INPUT_TEXT_RENDERED;
	private boolean COMP_58_INPUT_TEXT_RENDERED;
	private boolean COMP_59_INPUT_TEXT_RENDERED;
	private boolean COMP_60_INPUT_TEXT_RENDERED;

	private boolean COMP_1_PANEL;
	private boolean COMP_2_PANEL;
	private boolean COMP_3_PANEL;
	private boolean COMP_4_PANEL;
	private boolean COMP_5_PANEL;
	private boolean COMP_6_PANEL;
	private boolean COMP_7_PANEL;
	private boolean COMP_8_PANEL;
	private boolean COMP_9_PANEL;
	private boolean COMP_10_PANEL;
	private boolean COMP_11_PANEL;
	private boolean COMP_12_PANEL;
	private boolean COMP_13_PANEL;
	private boolean COMP_14_PANEL;
	private boolean COMP_15_PANEL;
	private boolean COMP_16_PANEL;
	private boolean COMP_17_PANEL;
	private boolean COMP_18_PANEL;
	private boolean COMP_19_PANEL;
	private boolean COMP_20_PANEL;
	private boolean COMP_21_PANEL;
	private boolean COMP_22_PANEL;
	private boolean COMP_23_PANEL;
	private boolean COMP_24_PANEL;
	private boolean COMP_25_PANEL;
	private boolean COMP_26_PANEL;
	private boolean COMP_27_PANEL;
	private boolean COMP_28_PANEL;
	private boolean COMP_29_PANEL;
	private boolean COMP_30_PANEL;
	private boolean COMP_31_PANEL;
	private boolean COMP_32_PANEL;
	private boolean COMP_33_PANEL;
	private boolean COMP_34_PANEL;
	private boolean COMP_35_PANEL;
	private boolean COMP_36_PANEL;
	private boolean COMP_37_PANEL;
	private boolean COMP_38_PANEL;
	private boolean COMP_39_PANEL;
	private boolean COMP_40_PANEL;
	private boolean COMP_41_PANEL;
	private boolean COMP_42_PANEL;
	private boolean COMP_43_PANEL;
	private boolean COMP_44_PANEL;
	private boolean COMP_45_PANEL;
	private boolean COMP_46_PANEL;
	private boolean COMP_47_PANEL;
	private boolean COMP_48_PANEL;
	private boolean COMP_49_PANEL;
	private boolean COMP_50_PANEL;
	private boolean COMP_51_PANEL;
	private boolean COMP_52_PANEL;
	private boolean COMP_53_PANEL;
	private boolean COMP_54_PANEL;
	private boolean COMP_55_PANEL;
	private boolean COMP_56_PANEL;
	private boolean COMP_57_PANEL;
	private boolean COMP_58_PANEL;
	private boolean COMP_59_PANEL;
	private boolean COMP_60_PANEL;
	
	private String reportPDFFormat=REPORT_UTIL_CONSTANTS.reportPDFFormat;
	private String reportCSVFormat=REPORT_UTIL_CONSTANTS.reportCSVFormat;
	private String reportHTMLFormat=REPORT_UTIL_CONSTANTS.reportHTMLFormat;
	private String reportExcelFormat=REPORT_UTIL_CONSTANTS.reportExcelFormat;
	
	String P_POLICY_NUMBER_TO;
	String P_POLICY_NUMBER_FM;
	
	private HtmlInputText COMP_1_INPUT_TEXT_DESC;
	private HtmlInputText COMP_2_INPUT_TEXT_DESC;
	private HtmlInputText COMP_3_INPUT_TEXT_DESC;
	private HtmlInputText COMP_4_INPUT_TEXT_DESC;
	private HtmlInputText COMP_5_INPUT_TEXT_DESC;
	private HtmlInputText COMP_6_INPUT_TEXT_DESC;
	private HtmlInputText COMP_7_INPUT_TEXT_DESC;
	private HtmlInputText COMP_8_INPUT_TEXT_DESC;
	private HtmlInputText COMP_9_INPUT_TEXT_DESC;
	private HtmlInputText COMP_10_INPUT_TEXT_DESC;
	private HtmlInputText COMP_11_INPUT_TEXT_DESC;
	private HtmlInputText COMP_12_INPUT_TEXT_DESC;
	
	PILR006_A_HELPER helper;
	PILR006_A_DELEGATE delegate;
	
	private List<SelectItem> listM_MODULE_CODE_FM;
	
	public PILR006_A_IP_REP_INFO_ACTION(){
		
		IP_REP_INFO_BEAN=new IP_REP_INFO();
		rerenderComponents();
		setComboBoxValues();
		helper=new PILR006_A_HELPER();
		delegate=new PILR006_A_DELEGATE();
		
		//prepare list for policy , customer type, customer status
		prepareDropDownList();
	}
	
	public void prepareDropDownList() {
		Connection connection;
		try {
			connection = CommonUtils.getConnection();
			listM_MODULE_CODE_FM = new ArrayList<SelectItem>();
			listM_MODULE_CODE_FM = ListItemUtil.getDropDownListValue(connection, "PILR107", 
					"REP_PARAM", "REP_PARAM.M_MODULE_CODE_FM", "WAK_MODULE");
			
		} catch (DBException e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY, e.getMessage());
			getErrorMap().put("prepareDropDownList", e.getMessage());
		}
	}
	
	/*public void prepareCustTypeList(){
		try{
			custTypeList = new ArrayList<SelectItem>();
			custTypeList.add(new SelectItem( Messages.getString("messageProperties_PBR016", 
			"PBR016$IP_REP_INFO$COMP_13_INPUT$ITEM$INDIVIDUAL$value"), 
			Messages.getString("messageProperties_PBR016", 
			"PBR016$IP_REP_INFO$COMP_13_INPUT$ITEM$INDIVIDUAL$caption")));
		
			custTypeList.add(new SelectItem( Messages.getString("messageProperties_PBR016", 
			"PBR016$IP_REP_INFO$COMP_13_INPUT$ITEM$CORPORATE$value"), 
			Messages.getString("messageProperties_PBR016", 
			"PBR016$IP_REP_INFO$COMP_13_INPUT$ITEM$CORPORATE$caption")));
			
			custTypeList.add(new SelectItem( Messages.getString("messageProperties_PBR016", 
			"PBR016$IP_REP_INFO$COMP_13_INPUT$ITEM$ALL$value"), 
			Messages.getString("messageProperties_PBR016", 
			"PBR016$IP_REP_INFO$COMP_13_INPUT$ITEM$ALL$caption")));
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	


	private void setComboBoxValues() {
		
		try {
		
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void rerenderComponents() {
		
		//render Panel Group
		setCOMP_1_PANEL(true);
		setCOMP_2_PANEL(true);
		setCOMP_3_PANEL(true);
		setCOMP_4_PANEL(true);
		setCOMP_5_PANEL(true);
		setCOMP_6_PANEL(true);
		setCOMP_7_PANEL(true);
		setCOMP_8_PANEL(true);
		setCOMP_9_PANEL(true);
		setCOMP_10_PANEL(true);
		setCOMP_11_PANEL(true);
		setCOMP_12_PANEL(true);
		setCOMP_13_PANEL(true);
		setCOMP_14_PANEL(true);
		setCOMP_15_PANEL(true);
		setCOMP_16_PANEL(true);
		setCOMP_17_PANEL(false);
		setCOMP_18_PANEL(false);
		setCOMP_19_PANEL(false);
		setCOMP_20_PANEL(false);
		setCOMP_21_PANEL(false);
		setCOMP_22_PANEL(false);
		setCOMP_23_PANEL(false);
		setCOMP_24_PANEL(false);
		setCOMP_25_PANEL(false);
		setCOMP_26_PANEL(false);
		setCOMP_27_PANEL(false);
		setCOMP_28_PANEL(false);
		setCOMP_29_PANEL(false);
		setCOMP_30_PANEL(false);
		setCOMP_31_PANEL(false);
		setCOMP_32_PANEL(false);
		setCOMP_33_PANEL(false);
		setCOMP_34_PANEL(false);
		setCOMP_35_PANEL(false);
		setCOMP_36_PANEL(false);
		setCOMP_37_PANEL(false);
		setCOMP_38_PANEL(false);
		setCOMP_39_PANEL(false);
		setCOMP_40_PANEL(false);
		setCOMP_41_PANEL(false);
		setCOMP_42_PANEL(false);
		setCOMP_43_PANEL(false);
		setCOMP_44_PANEL(false);
		setCOMP_45_PANEL(false);
		setCOMP_46_PANEL(false);
		setCOMP_47_PANEL(false);
		setCOMP_48_PANEL(false);
		setCOMP_49_PANEL(false);
		setCOMP_50_PANEL(false);
		setCOMP_51_PANEL(false);
		setCOMP_52_PANEL(false);
		setCOMP_53_PANEL(false);
		setCOMP_54_PANEL(false);
		setCOMP_55_PANEL(false);
		setCOMP_56_PANEL(false);
		setCOMP_57_PANEL(false);
		setCOMP_58_PANEL(false);
		setCOMP_59_PANEL(false);
		setCOMP_60_PANEL(false);
		
		//render Calendar Components
		setCOMP_1_CALENDER_RENDERED(false);
		setCOMP_2_CALENDER_RENDERED(false);
		setCOMP_3_CALENDER_RENDERED(false);
		setCOMP_4_CALENDER_RENDERED(false);
		setCOMP_5_CALENDER_RENDERED(false);
		setCOMP_6_CALENDER_RENDERED(false);
		setCOMP_7_CALENDER_RENDERED(false);
		setCOMP_8_CALENDER_RENDERED(false);
		setCOMP_9_CALENDER_RENDERED(false);
		setCOMP_10_CALENDER_RENDERED(false);
		setCOMP_11_CALENDER_RENDERED(true);
		setCOMP_12_CALENDER_RENDERED(false);
		setCOMP_13_CALENDER_RENDERED(false);
		setCOMP_14_CALENDER_RENDERED(false);
		setCOMP_15_CALENDER_RENDERED(false);
		setCOMP_16_CALENDER_RENDERED(false);
		setCOMP_17_CALENDER_RENDERED(false);
		setCOMP_18_CALENDER_RENDERED(false);
		setCOMP_19_CALENDER_RENDERED(false);
		setCOMP_20_CALENDER_RENDERED(false);
		setCOMP_21_CALENDER_RENDERED(false);
		setCOMP_22_CALENDER_RENDERED(false);
		setCOMP_23_CALENDER_RENDERED(false);
		setCOMP_24_CALENDER_RENDERED(false);
		setCOMP_25_CALENDER_RENDERED(false);
		setCOMP_26_CALENDER_RENDERED(false);
		setCOMP_27_CALENDER_RENDERED(false);
		setCOMP_28_CALENDER_RENDERED(false);
		setCOMP_29_CALENDER_RENDERED(false);
		setCOMP_30_CALENDER_RENDERED(false);
		setCOMP_31_CALENDER_RENDERED(false);
		setCOMP_32_CALENDER_RENDERED(false);
		setCOMP_33_CALENDER_RENDERED(false);
		setCOMP_34_CALENDER_RENDERED(false);
		setCOMP_35_CALENDER_RENDERED(false);
		setCOMP_36_CALENDER_RENDERED(false);
		setCOMP_37_CALENDER_RENDERED(false);
		setCOMP_38_CALENDER_RENDERED(false);
		setCOMP_39_CALENDER_RENDERED(false);
		setCOMP_40_CALENDER_RENDERED(false);
		setCOMP_41_CALENDER_RENDERED(false);
		setCOMP_42_CALENDER_RENDERED(false);
		setCOMP_43_CALENDER_RENDERED(false);
		setCOMP_44_CALENDER_RENDERED(false);
		setCOMP_45_CALENDER_RENDERED(false);
		setCOMP_46_CALENDER_RENDERED(false);
		setCOMP_47_CALENDER_RENDERED(false);
		setCOMP_48_CALENDER_RENDERED(false);
		setCOMP_49_CALENDER_RENDERED(false);
		setCOMP_50_CALENDER_RENDERED(false);
		setCOMP_51_CALENDER_RENDERED(false);
		setCOMP_52_CALENDER_RENDERED(false);
		setCOMP_53_CALENDER_RENDERED(false);
		setCOMP_54_CALENDER_RENDERED(false);
		setCOMP_55_CALENDER_RENDERED(false);
		setCOMP_56_CALENDER_RENDERED(false);
		setCOMP_57_CALENDER_RENDERED(false);
		setCOMP_58_CALENDER_RENDERED(false);
		setCOMP_59_CALENDER_RENDERED(false);
		setCOMP_60_CALENDER_RENDERED(false);
		
		//render Input Text Components
		setCOMP_1_INPUT_TEXT_RENDERED(true);
		setCOMP_2_INPUT_TEXT_RENDERED(true);
		setCOMP_3_INPUT_TEXT_RENDERED(true);
		setCOMP_4_INPUT_TEXT_RENDERED(true);
		setCOMP_5_INPUT_TEXT_RENDERED(true);
		setCOMP_6_INPUT_TEXT_RENDERED(true);
		setCOMP_7_INPUT_TEXT_RENDERED(true);
		setCOMP_8_INPUT_TEXT_RENDERED(true);
		setCOMP_9_INPUT_TEXT_RENDERED(true);
		setCOMP_10_INPUT_TEXT_RENDERED(true);
		setCOMP_11_INPUT_TEXT_RENDERED(true);
		setCOMP_12_INPUT_TEXT_RENDERED(true);
		setCOMP_13_INPUT_TEXT_RENDERED(true);
		setCOMP_14_INPUT_TEXT_RENDERED(true);
		setCOMP_15_INPUT_TEXT_RENDERED(false);
		setCOMP_16_INPUT_TEXT_RENDERED(false);
		setCOMP_17_INPUT_TEXT_RENDERED(false);
		setCOMP_18_INPUT_TEXT_RENDERED(false);
		setCOMP_19_INPUT_TEXT_RENDERED(false);
		setCOMP_20_INPUT_TEXT_RENDERED(false);
		setCOMP_21_INPUT_TEXT_RENDERED(false);
		setCOMP_22_INPUT_TEXT_RENDERED(false);
		setCOMP_23_INPUT_TEXT_RENDERED(false);
		setCOMP_24_INPUT_TEXT_RENDERED(false);
		setCOMP_25_INPUT_TEXT_RENDERED(false);
		setCOMP_26_INPUT_TEXT_RENDERED(false);
		setCOMP_27_INPUT_TEXT_RENDERED(false);
		setCOMP_28_INPUT_TEXT_RENDERED(false);
		setCOMP_29_INPUT_TEXT_RENDERED(false);
		setCOMP_30_INPUT_TEXT_RENDERED(false);
		setCOMP_31_INPUT_TEXT_RENDERED(false);
		setCOMP_32_INPUT_TEXT_RENDERED(false);
		setCOMP_33_INPUT_TEXT_RENDERED(false);
		setCOMP_34_INPUT_TEXT_RENDERED(false);
		setCOMP_35_INPUT_TEXT_RENDERED(false);
		setCOMP_36_INPUT_TEXT_RENDERED(false);
		setCOMP_37_INPUT_TEXT_RENDERED(false);
		setCOMP_38_INPUT_TEXT_RENDERED(false);
		setCOMP_39_INPUT_TEXT_RENDERED(false);
		setCOMP_40_INPUT_TEXT_RENDERED(false);
		setCOMP_41_INPUT_TEXT_RENDERED(false);
		setCOMP_42_INPUT_TEXT_RENDERED(false);
		setCOMP_43_INPUT_TEXT_RENDERED(false);
		setCOMP_44_INPUT_TEXT_RENDERED(false);
		setCOMP_45_INPUT_TEXT_RENDERED(false);
		setCOMP_46_INPUT_TEXT_RENDERED(false);
		setCOMP_47_INPUT_TEXT_RENDERED(false);
		setCOMP_48_INPUT_TEXT_RENDERED(false);
		setCOMP_49_INPUT_TEXT_RENDERED(false);
		setCOMP_50_INPUT_TEXT_RENDERED(false);
		setCOMP_51_INPUT_TEXT_RENDERED(false);
		setCOMP_52_INPUT_TEXT_RENDERED(false);
		setCOMP_53_INPUT_TEXT_RENDERED(false);
		setCOMP_54_INPUT_TEXT_RENDERED(false);
		setCOMP_55_INPUT_TEXT_RENDERED(false);
		setCOMP_56_INPUT_TEXT_RENDERED(false);
		setCOMP_57_INPUT_TEXT_RENDERED(false);
		setCOMP_58_INPUT_TEXT_RENDERED(false);
		setCOMP_59_INPUT_TEXT_RENDERED(false);
		setCOMP_60_INPUT_TEXT_RENDERED(false);
		
		//render Select One Menu Components
		setCOMP_1_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_2_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_3_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_4_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_5_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_6_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_7_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_8_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_9_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_10_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_11_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_12_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_13_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_14_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_15_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_16_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_17_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_18_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_19_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_20_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_21_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_22_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_23_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_24_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_25_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_26_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_27_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_28_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_29_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_30_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_31_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_32_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_33_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_34_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_35_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_36_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_37_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_38_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_39_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_40_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_41_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_42_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_43_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_44_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_45_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_46_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_47_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_48_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_49_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_50_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_51_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_52_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_53_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_54_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_55_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_56_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_57_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_58_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_59_SELECT_ONE_MENU_RENDERED(false);
		setCOMP_60_SELECT_ONE_MENU_RENDERED(false);

	}

		
	

	public HtmlSelectOneRadio getCOMP_SELECT_FILE_TYPE() {
		return COMP_SELECT_FILE_TYPE;
	}

	public void setCOMP_SELECT_FILE_TYPE(HtmlSelectOneRadio comp_select_file_type) {
		COMP_SELECT_FILE_TYPE = comp_select_file_type;
	}
	
	public String getReportsDatePattern() {
		return reportsDatePattern;
	}

	public void setReportsDatePattern(String reportsDatePattern) {
		this.reportsDatePattern = reportsDatePattern;
	}
	


	public HtmlCalendar getCOMP_1_CALENDER() {
		return COMP_1_CALENDER;
	}

	public void setCOMP_1_CALENDER(HtmlCalendar comp_1_calender) {
		COMP_1_CALENDER = comp_1_calender;
	}

	public HtmlOutputLabel getCOMP_1_LABEL() {
		return COMP_1_LABEL;
	}

	public void setCOMP_1_LABEL(HtmlOutputLabel comp_1_label) {
		COMP_1_LABEL = comp_1_label;
	}

	public HtmlInputText getCOMP_1_INPUT_TEXT() {
		return COMP_1_INPUT_TEXT;
	}

	public void setCOMP_1_INPUT_TEXT(HtmlInputText comp_1_input_text) {
		COMP_1_INPUT_TEXT = comp_1_input_text;
	}

	public HtmlSelectOneMenu getCOMP_1_SELECT_ONE_MENU() {
		return COMP_1_SELECT_ONE_MENU;
	}

	public void setCOMP_1_SELECT_ONE_MENU(HtmlSelectOneMenu comp_1_select_one_menu) {
		COMP_1_SELECT_ONE_MENU = comp_1_select_one_menu;
	}

	public boolean isCOMP_1_CALENDER_RENDERED() {
		return COMP_1_CALENDER_RENDERED;
	}

	public void setCOMP_1_CALENDER_RENDERED(boolean comp_1_calender_rendered) {
		COMP_1_CALENDER_RENDERED = comp_1_calender_rendered;
	}

	public boolean isCOMP_1_SELECT_ONE_MENU_RENDERED() {
		return COMP_1_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_1_SELECT_ONE_MENU_RENDERED(
			boolean comp_1_select_one_menu_rendered) {
		COMP_1_SELECT_ONE_MENU_RENDERED = comp_1_select_one_menu_rendered;
	}

	public boolean isCOMP_1_INPUT_TEXT_RENDERED() {
		return COMP_1_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_1_INPUT_TEXT_RENDERED(boolean comp_1_input_text_rendered) {
		COMP_1_INPUT_TEXT_RENDERED = comp_1_input_text_rendered;
	}

	public HtmlOutputLabel getCOMP_2_LABEL() {
		return COMP_2_LABEL;
	}

	public void setCOMP_2_LABEL(HtmlOutputLabel comp_2_label) {
		COMP_2_LABEL = comp_2_label;
	}

	public HtmlOutputLabel getCOMP_3_LABEL() {
		return COMP_3_LABEL;
	}

	public void setCOMP_3_LABEL(HtmlOutputLabel comp_3_label) {
		COMP_3_LABEL = comp_3_label;
	}

	public HtmlOutputLabel getCOMP_4_LABEL() {
		return COMP_4_LABEL;
	}

	public void setCOMP_4_LABEL(HtmlOutputLabel comp_4_label) {
		COMP_4_LABEL = comp_4_label;
	}

	public HtmlOutputLabel getCOMP_5_LABEL() {
		return COMP_5_LABEL;
	}

	public void setCOMP_5_LABEL(HtmlOutputLabel comp_5_label) {
		COMP_5_LABEL = comp_5_label;
	}

	public HtmlOutputLabel getCOMP_6_LABEL() {
		return COMP_6_LABEL;
	}

	public void setCOMP_6_LABEL(HtmlOutputLabel comp_6_label) {
		COMP_6_LABEL = comp_6_label;
	}

	public HtmlOutputLabel getCOMP_7_LABEL() {
		return COMP_7_LABEL;
	}

	public void setCOMP_7_LABEL(HtmlOutputLabel comp_7_label) {
		COMP_7_LABEL = comp_7_label;
	}

	public HtmlOutputLabel getCOMP_8_LABEL() {
		return COMP_8_LABEL;
	}

	public void setCOMP_8_LABEL(HtmlOutputLabel comp_8_label) {
		COMP_8_LABEL = comp_8_label;
	}

	public HtmlOutputLabel getCOMP_9_LABEL() {
		return COMP_9_LABEL;
	}

	public void setCOMP_9_LABEL(HtmlOutputLabel comp_9_label) {
		COMP_9_LABEL = comp_9_label;
	}

	public HtmlOutputLabel getCOMP_10_LABEL() {
		return COMP_10_LABEL;
	}

	public void setCOMP_10_LABEL(HtmlOutputLabel comp_10_label) {
		COMP_10_LABEL = comp_10_label;
	}

	public HtmlOutputLabel getCOMP_11_LABEL() {
		return COMP_11_LABEL;
	}

	public void setCOMP_11_LABEL(HtmlOutputLabel comp_11_label) {
		COMP_11_LABEL = comp_11_label;
	}

	public HtmlOutputLabel getCOMP_12_LABEL() {
		return COMP_12_LABEL;
	}

	public void setCOMP_12_LABEL(HtmlOutputLabel comp_12_label) {
		COMP_12_LABEL = comp_12_label;
	}

	public HtmlOutputLabel getCOMP_13_LABEL() {
		return COMP_13_LABEL;
	}

	public void setCOMP_13_LABEL(HtmlOutputLabel comp_13_label) {
		COMP_13_LABEL = comp_13_label;
	}

	public HtmlOutputLabel getCOMP_14_LABEL() {
		return COMP_14_LABEL;
	}

	public void setCOMP_14_LABEL(HtmlOutputLabel comp_14_label) {
		COMP_14_LABEL = comp_14_label;
	}

	public HtmlOutputLabel getCOMP_15_LABEL() {
		return COMP_15_LABEL;
	}

	public void setCOMP_15_LABEL(HtmlOutputLabel comp_15_label) {
		COMP_15_LABEL = comp_15_label;
	}

	public HtmlOutputLabel getCOMP_16_LABEL() {
		return COMP_16_LABEL;
	}

	public void setCOMP_16_LABEL(HtmlOutputLabel comp_16_label) {
		COMP_16_LABEL = comp_16_label;
	}

	public HtmlOutputLabel getCOMP_17_LABEL() {
		return COMP_17_LABEL;
	}

	public void setCOMP_17_LABEL(HtmlOutputLabel comp_17_label) {
		COMP_17_LABEL = comp_17_label;
	}

	public HtmlOutputLabel getCOMP_18_LABEL() {
		return COMP_18_LABEL;
	}

	public void setCOMP_18_LABEL(HtmlOutputLabel comp_18_label) {
		COMP_18_LABEL = comp_18_label;
	}

	public HtmlOutputLabel getCOMP_19_LABEL() {
		return COMP_19_LABEL;
	}

	public void setCOMP_19_LABEL(HtmlOutputLabel comp_19_label) {
		COMP_19_LABEL = comp_19_label;
	}

	public HtmlOutputLabel getCOMP_20_LABEL() {
		return COMP_20_LABEL;
	}

	public void setCOMP_20_LABEL(HtmlOutputLabel comp_20_label) {
		COMP_20_LABEL = comp_20_label;
	}

	public HtmlOutputLabel getCOMP_21_LABEL() {
		return COMP_21_LABEL;
	}

	public void setCOMP_21_LABEL(HtmlOutputLabel comp_21_label) {
		COMP_21_LABEL = comp_21_label;
	}

	public HtmlOutputLabel getCOMP_22_LABEL() {
		return COMP_22_LABEL;
	}

	public void setCOMP_22_LABEL(HtmlOutputLabel comp_22_label) {
		COMP_22_LABEL = comp_22_label;
	}

	public HtmlOutputLabel getCOMP_23_LABEL() {
		return COMP_23_LABEL;
	}

	public void setCOMP_23_LABEL(HtmlOutputLabel comp_23_label) {
		COMP_23_LABEL = comp_23_label;
	}

	public HtmlOutputLabel getCOMP_24_LABEL() {
		return COMP_24_LABEL;
	}

	public void setCOMP_24_LABEL(HtmlOutputLabel comp_24_label) {
		COMP_24_LABEL = comp_24_label;
	}

	public HtmlOutputLabel getCOMP_25_LABEL() {
		return COMP_25_LABEL;
	}

	public void setCOMP_25_LABEL(HtmlOutputLabel comp_25_label) {
		COMP_25_LABEL = comp_25_label;
	}

	public HtmlOutputLabel getCOMP_26_LABEL() {
		return COMP_26_LABEL;
	}

	public void setCOMP_26_LABEL(HtmlOutputLabel comp_26_label) {
		COMP_26_LABEL = comp_26_label;
	}

	public HtmlOutputLabel getCOMP_27_LABEL() {
		return COMP_27_LABEL;
	}

	public void setCOMP_27_LABEL(HtmlOutputLabel comp_27_label) {
		COMP_27_LABEL = comp_27_label;
	}

	public HtmlOutputLabel getCOMP_28_LABEL() {
		return COMP_28_LABEL;
	}

	public void setCOMP_28_LABEL(HtmlOutputLabel comp_28_label) {
		COMP_28_LABEL = comp_28_label;
	}

	public HtmlOutputLabel getCOMP_29_LABEL() {
		return COMP_29_LABEL;
	}

	public void setCOMP_29_LABEL(HtmlOutputLabel comp_29_label) {
		COMP_29_LABEL = comp_29_label;
	}

	public HtmlOutputLabel getCOMP_30_LABEL() {
		return COMP_30_LABEL;
	}

	public void setCOMP_30_LABEL(HtmlOutputLabel comp_30_label) {
		COMP_30_LABEL = comp_30_label;
	}

	public HtmlOutputLabel getCOMP_31_LABEL() {
		return COMP_31_LABEL;
	}

	public void setCOMP_31_LABEL(HtmlOutputLabel comp_31_label) {
		COMP_31_LABEL = comp_31_label;
	}

	public HtmlOutputLabel getCOMP_32_LABEL() {
		return COMP_32_LABEL;
	}

	public void setCOMP_32_LABEL(HtmlOutputLabel comp_32_label) {
		COMP_32_LABEL = comp_32_label;
	}

	public HtmlOutputLabel getCOMP_33_LABEL() {
		return COMP_33_LABEL;
	}

	public void setCOMP_33_LABEL(HtmlOutputLabel comp_33_label) {
		COMP_33_LABEL = comp_33_label;
	}

	public HtmlOutputLabel getCOMP_34_LABEL() {
		return COMP_34_LABEL;
	}

	public void setCOMP_34_LABEL(HtmlOutputLabel comp_34_label) {
		COMP_34_LABEL = comp_34_label;
	}

	public HtmlOutputLabel getCOMP_35_LABEL() {
		return COMP_35_LABEL;
	}

	public void setCOMP_35_LABEL(HtmlOutputLabel comp_35_label) {
		COMP_35_LABEL = comp_35_label;
	}

	public HtmlOutputLabel getCOMP_36_LABEL() {
		return COMP_36_LABEL;
	}

	public void setCOMP_36_LABEL(HtmlOutputLabel comp_36_label) {
		COMP_36_LABEL = comp_36_label;
	}

	public HtmlOutputLabel getCOMP_37_LABEL() {
		return COMP_37_LABEL;
	}

	public void setCOMP_37_LABEL(HtmlOutputLabel comp_37_label) {
		COMP_37_LABEL = comp_37_label;
	}

	public HtmlOutputLabel getCOMP_38_LABEL() {
		return COMP_38_LABEL;
	}

	public void setCOMP_38_LABEL(HtmlOutputLabel comp_38_label) {
		COMP_38_LABEL = comp_38_label;
	}

	public HtmlOutputLabel getCOMP_39_LABEL() {
		return COMP_39_LABEL;
	}

	public void setCOMP_39_LABEL(HtmlOutputLabel comp_39_label) {
		COMP_39_LABEL = comp_39_label;
	}

	public HtmlOutputLabel getCOMP_40_LABEL() {
		return COMP_40_LABEL;
	}

	public void setCOMP_40_LABEL(HtmlOutputLabel comp_40_label) {
		COMP_40_LABEL = comp_40_label;
	}

	public HtmlOutputLabel getCOMP_41_LABEL() {
		return COMP_41_LABEL;
	}

	public void setCOMP_41_LABEL(HtmlOutputLabel comp_41_label) {
		COMP_41_LABEL = comp_41_label;
	}

	public HtmlOutputLabel getCOMP_42_LABEL() {
		return COMP_42_LABEL;
	}

	public void setCOMP_42_LABEL(HtmlOutputLabel comp_42_label) {
		COMP_42_LABEL = comp_42_label;
	}

	public HtmlOutputLabel getCOMP_43_LABEL() {
		return COMP_43_LABEL;
	}

	public void setCOMP_43_LABEL(HtmlOutputLabel comp_43_label) {
		COMP_43_LABEL = comp_43_label;
	}

	public HtmlOutputLabel getCOMP_44_LABEL() {
		return COMP_44_LABEL;
	}

	public void setCOMP_44_LABEL(HtmlOutputLabel comp_44_label) {
		COMP_44_LABEL = comp_44_label;
	}

	public HtmlOutputLabel getCOMP_45_LABEL() {
		return COMP_45_LABEL;
	}

	public void setCOMP_45_LABEL(HtmlOutputLabel comp_45_label) {
		COMP_45_LABEL = comp_45_label;
	}

	public HtmlOutputLabel getCOMP_46_LABEL() {
		return COMP_46_LABEL;
	}

	public void setCOMP_46_LABEL(HtmlOutputLabel comp_46_label) {
		COMP_46_LABEL = comp_46_label;
	}

	public HtmlOutputLabel getCOMP_47_LABEL() {
		return COMP_47_LABEL;
	}

	public void setCOMP_47_LABEL(HtmlOutputLabel comp_47_label) {
		COMP_47_LABEL = comp_47_label;
	}

	public HtmlOutputLabel getCOMP_48_LABEL() {
		return COMP_48_LABEL;
	}

	public void setCOMP_48_LABEL(HtmlOutputLabel comp_48_label) {
		COMP_48_LABEL = comp_48_label;
	}

	public HtmlOutputLabel getCOMP_49_LABEL() {
		return COMP_49_LABEL;
	}

	public void setCOMP_49_LABEL(HtmlOutputLabel comp_49_label) {
		COMP_49_LABEL = comp_49_label;
	}

	public HtmlOutputLabel getCOMP_50_LABEL() {
		return COMP_50_LABEL;
	}

	public void setCOMP_50_LABEL(HtmlOutputLabel comp_50_label) {
		COMP_50_LABEL = comp_50_label;
	}

	public HtmlOutputLabel getCOMP_51_LABEL() {
		return COMP_51_LABEL;
	}

	public void setCOMP_51_LABEL(HtmlOutputLabel comp_51_label) {
		COMP_51_LABEL = comp_51_label;
	}

	public HtmlOutputLabel getCOMP_52_LABEL() {
		return COMP_52_LABEL;
	}

	public void setCOMP_52_LABEL(HtmlOutputLabel comp_52_label) {
		COMP_52_LABEL = comp_52_label;
	}

	public HtmlOutputLabel getCOMP_53_LABEL() {
		return COMP_53_LABEL;
	}

	public void setCOMP_53_LABEL(HtmlOutputLabel comp_53_label) {
		COMP_53_LABEL = comp_53_label;
	}

	public HtmlOutputLabel getCOMP_54_LABEL() {
		return COMP_54_LABEL;
	}

	public void setCOMP_54_LABEL(HtmlOutputLabel comp_54_label) {
		COMP_54_LABEL = comp_54_label;
	}

	public HtmlOutputLabel getCOMP_55_LABEL() {
		return COMP_55_LABEL;
	}

	public void setCOMP_55_LABEL(HtmlOutputLabel comp_55_label) {
		COMP_55_LABEL = comp_55_label;
	}

	public HtmlOutputLabel getCOMP_56_LABEL() {
		return COMP_56_LABEL;
	}

	public void setCOMP_56_LABEL(HtmlOutputLabel comp_56_label) {
		COMP_56_LABEL = comp_56_label;
	}

	public HtmlOutputLabel getCOMP_57_LABEL() {
		return COMP_57_LABEL;
	}

	public void setCOMP_57_LABEL(HtmlOutputLabel comp_57_label) {
		COMP_57_LABEL = comp_57_label;
	}

	public HtmlOutputLabel getCOMP_58_LABEL() {
		return COMP_58_LABEL;
	}

	public void setCOMP_58_LABEL(HtmlOutputLabel comp_58_label) {
		COMP_58_LABEL = comp_58_label;
	}

	public HtmlOutputLabel getCOMP_59_LABEL() {
		return COMP_59_LABEL;
	}

	public void setCOMP_59_LABEL(HtmlOutputLabel comp_59_label) {
		COMP_59_LABEL = comp_59_label;
	}

	public HtmlOutputLabel getCOMP_60_LABEL() {
		return COMP_60_LABEL;
	}

	public void setCOMP_60_LABEL(HtmlOutputLabel comp_60_label) {
		COMP_60_LABEL = comp_60_label;
	}

	public boolean isCOMP_2_CALENDER_RENDERED() {
		return COMP_2_CALENDER_RENDERED;
	}

	public void setCOMP_2_CALENDER_RENDERED(boolean comp_2_calender_rendered) {
		COMP_2_CALENDER_RENDERED = comp_2_calender_rendered;
	}

	public boolean isCOMP_3_CALENDER_RENDERED() {
		return COMP_3_CALENDER_RENDERED;
	}

	public void setCOMP_3_CALENDER_RENDERED(boolean comp_3_calender_rendered) {
		COMP_3_CALENDER_RENDERED = comp_3_calender_rendered;
	}

	public boolean isCOMP_4_CALENDER_RENDERED() {
		return COMP_4_CALENDER_RENDERED;
	}

	public void setCOMP_4_CALENDER_RENDERED(boolean comp_4_calender_rendered) {
		COMP_4_CALENDER_RENDERED = comp_4_calender_rendered;
	}

	public boolean isCOMP_5_CALENDER_RENDERED() {
		return COMP_5_CALENDER_RENDERED;
	}

	public void setCOMP_5_CALENDER_RENDERED(boolean comp_5_calender_rendered) {
		COMP_5_CALENDER_RENDERED = comp_5_calender_rendered;
	}

	public boolean isCOMP_6_CALENDER_RENDERED() {
		return COMP_6_CALENDER_RENDERED;
	}

	public void setCOMP_6_CALENDER_RENDERED(boolean comp_6_calender_rendered) {
		COMP_6_CALENDER_RENDERED = comp_6_calender_rendered;
	}

	public boolean isCOMP_7_CALENDER_RENDERED() {
		return COMP_7_CALENDER_RENDERED;
	}

	public void setCOMP_7_CALENDER_RENDERED(boolean comp_7_calender_rendered) {
		COMP_7_CALENDER_RENDERED = comp_7_calender_rendered;
	}

	public boolean isCOMP_8_CALENDER_RENDERED() {
		return COMP_8_CALENDER_RENDERED;
	}

	public void setCOMP_8_CALENDER_RENDERED(boolean comp_8_calender_rendered) {
		COMP_8_CALENDER_RENDERED = comp_8_calender_rendered;
	}

	public boolean isCOMP_9_CALENDER_RENDERED() {
		return COMP_9_CALENDER_RENDERED;
	}

	public void setCOMP_9_CALENDER_RENDERED(boolean comp_9_calender_rendered) {
		COMP_9_CALENDER_RENDERED = comp_9_calender_rendered;
	}

	public boolean isCOMP_10_CALENDER_RENDERED() {
		return COMP_10_CALENDER_RENDERED;
	}

	public void setCOMP_10_CALENDER_RENDERED(boolean comp_10_calender_rendered) {
		COMP_10_CALENDER_RENDERED = comp_10_calender_rendered;
	}

	public boolean isCOMP_11_CALENDER_RENDERED() {
		return COMP_11_CALENDER_RENDERED;
	}

	public void setCOMP_11_CALENDER_RENDERED(boolean comp_11_calender_rendered) {
		COMP_11_CALENDER_RENDERED = comp_11_calender_rendered;
	}

	public boolean isCOMP_12_CALENDER_RENDERED() {
		return COMP_12_CALENDER_RENDERED;
	}

	public void setCOMP_12_CALENDER_RENDERED(boolean comp_12_calender_rendered) {
		COMP_12_CALENDER_RENDERED = comp_12_calender_rendered;
	}

	public boolean isCOMP_13_CALENDER_RENDERED() {
		return COMP_13_CALENDER_RENDERED;
	}

	public void setCOMP_13_CALENDER_RENDERED(boolean comp_13_calender_rendered) {
		COMP_13_CALENDER_RENDERED = comp_13_calender_rendered;
	}

	public boolean isCOMP_14_CALENDER_RENDERED() {
		return COMP_14_CALENDER_RENDERED;
	}

	public void setCOMP_14_CALENDER_RENDERED(boolean comp_14_calender_rendered) {
		COMP_14_CALENDER_RENDERED = comp_14_calender_rendered;
	}

	public boolean isCOMP_15_CALENDER_RENDERED() {
		return COMP_15_CALENDER_RENDERED;
	}

	public void setCOMP_15_CALENDER_RENDERED(boolean comp_15_calender_rendered) {
		COMP_15_CALENDER_RENDERED = comp_15_calender_rendered;
	}

	public boolean isCOMP_16_CALENDER_RENDERED() {
		return COMP_16_CALENDER_RENDERED;
	}

	public void setCOMP_16_CALENDER_RENDERED(boolean comp_16_calender_rendered) {
		COMP_16_CALENDER_RENDERED = comp_16_calender_rendered;
	}

	public boolean isCOMP_17_CALENDER_RENDERED() {
		return COMP_17_CALENDER_RENDERED;
	}

	public void setCOMP_17_CALENDER_RENDERED(boolean comp_17_calender_rendered) {
		COMP_17_CALENDER_RENDERED = comp_17_calender_rendered;
	}

	public boolean isCOMP_18_CALENDER_RENDERED() {
		return COMP_18_CALENDER_RENDERED;
	}

	public void setCOMP_18_CALENDER_RENDERED(boolean comp_18_calender_rendered) {
		COMP_18_CALENDER_RENDERED = comp_18_calender_rendered;
	}

	public boolean isCOMP_19_CALENDER_RENDERED() {
		return COMP_19_CALENDER_RENDERED;
	}

	public void setCOMP_19_CALENDER_RENDERED(boolean comp_19_calender_rendered) {
		COMP_19_CALENDER_RENDERED = comp_19_calender_rendered;
	}

	public boolean isCOMP_20_CALENDER_RENDERED() {
		return COMP_20_CALENDER_RENDERED;
	}

	public void setCOMP_20_CALENDER_RENDERED(boolean comp_20_calender_rendered) {
		COMP_20_CALENDER_RENDERED = comp_20_calender_rendered;
	}

	public boolean isCOMP_21_CALENDER_RENDERED() {
		return COMP_21_CALENDER_RENDERED;
	}

	public void setCOMP_21_CALENDER_RENDERED(boolean comp_21_calender_rendered) {
		COMP_21_CALENDER_RENDERED = comp_21_calender_rendered;
	}

	public boolean isCOMP_22_CALENDER_RENDERED() {
		return COMP_22_CALENDER_RENDERED;
	}

	public void setCOMP_22_CALENDER_RENDERED(boolean comp_22_calender_rendered) {
		COMP_22_CALENDER_RENDERED = comp_22_calender_rendered;
	}

	public boolean isCOMP_23_CALENDER_RENDERED() {
		return COMP_23_CALENDER_RENDERED;
	}

	public void setCOMP_23_CALENDER_RENDERED(boolean comp_23_calender_rendered) {
		COMP_23_CALENDER_RENDERED = comp_23_calender_rendered;
	}

	public boolean isCOMP_24_CALENDER_RENDERED() {
		return COMP_24_CALENDER_RENDERED;
	}

	public void setCOMP_24_CALENDER_RENDERED(boolean comp_24_calender_rendered) {
		COMP_24_CALENDER_RENDERED = comp_24_calender_rendered;
	}

	public boolean isCOMP_25_CALENDER_RENDERED() {
		return COMP_25_CALENDER_RENDERED;
	}

	public void setCOMP_25_CALENDER_RENDERED(boolean comp_25_calender_rendered) {
		COMP_25_CALENDER_RENDERED = comp_25_calender_rendered;
	}

	public boolean isCOMP_26_CALENDER_RENDERED() {
		return COMP_26_CALENDER_RENDERED;
	}

	public void setCOMP_26_CALENDER_RENDERED(boolean comp_26_calender_rendered) {
		COMP_26_CALENDER_RENDERED = comp_26_calender_rendered;
	}

	public boolean isCOMP_27_CALENDER_RENDERED() {
		return COMP_27_CALENDER_RENDERED;
	}

	public void setCOMP_27_CALENDER_RENDERED(boolean comp_27_calender_rendered) {
		COMP_27_CALENDER_RENDERED = comp_27_calender_rendered;
	}

	public boolean isCOMP_28_CALENDER_RENDERED() {
		return COMP_28_CALENDER_RENDERED;
	}

	public void setCOMP_28_CALENDER_RENDERED(boolean comp_28_calender_rendered) {
		COMP_28_CALENDER_RENDERED = comp_28_calender_rendered;
	}

	public boolean isCOMP_29_CALENDER_RENDERED() {
		return COMP_29_CALENDER_RENDERED;
	}

	public void setCOMP_29_CALENDER_RENDERED(boolean comp_29_calender_rendered) {
		COMP_29_CALENDER_RENDERED = comp_29_calender_rendered;
	}

	public boolean isCOMP_30_CALENDER_RENDERED() {
		return COMP_30_CALENDER_RENDERED;
	}

	public void setCOMP_30_CALENDER_RENDERED(boolean comp_30_calender_rendered) {
		COMP_30_CALENDER_RENDERED = comp_30_calender_rendered;
	}

	public boolean isCOMP_31_CALENDER_RENDERED() {
		return COMP_31_CALENDER_RENDERED;
	}

	public void setCOMP_31_CALENDER_RENDERED(boolean comp_31_calender_rendered) {
		COMP_31_CALENDER_RENDERED = comp_31_calender_rendered;
	}

	public boolean isCOMP_32_CALENDER_RENDERED() {
		return COMP_32_CALENDER_RENDERED;
	}

	public void setCOMP_32_CALENDER_RENDERED(boolean comp_32_calender_rendered) {
		COMP_32_CALENDER_RENDERED = comp_32_calender_rendered;
	}

	public boolean isCOMP_33_CALENDER_RENDERED() {
		return COMP_33_CALENDER_RENDERED;
	}

	public void setCOMP_33_CALENDER_RENDERED(boolean comp_33_calender_rendered) {
		COMP_33_CALENDER_RENDERED = comp_33_calender_rendered;
	}

	public boolean isCOMP_34_CALENDER_RENDERED() {
		return COMP_34_CALENDER_RENDERED;
	}

	public void setCOMP_34_CALENDER_RENDERED(boolean comp_34_calender_rendered) {
		COMP_34_CALENDER_RENDERED = comp_34_calender_rendered;
	}

	public boolean isCOMP_35_CALENDER_RENDERED() {
		return COMP_35_CALENDER_RENDERED;
	}

	public void setCOMP_35_CALENDER_RENDERED(boolean comp_35_calender_rendered) {
		COMP_35_CALENDER_RENDERED = comp_35_calender_rendered;
	}

	public boolean isCOMP_36_CALENDER_RENDERED() {
		return COMP_36_CALENDER_RENDERED;
	}

	public void setCOMP_36_CALENDER_RENDERED(boolean comp_36_calender_rendered) {
		COMP_36_CALENDER_RENDERED = comp_36_calender_rendered;
	}

	public boolean isCOMP_37_CALENDER_RENDERED() {
		return COMP_37_CALENDER_RENDERED;
	}

	public void setCOMP_37_CALENDER_RENDERED(boolean comp_37_calender_rendered) {
		COMP_37_CALENDER_RENDERED = comp_37_calender_rendered;
	}

	public boolean isCOMP_38_CALENDER_RENDERED() {
		return COMP_38_CALENDER_RENDERED;
	}

	public void setCOMP_38_CALENDER_RENDERED(boolean comp_38_calender_rendered) {
		COMP_38_CALENDER_RENDERED = comp_38_calender_rendered;
	}

	public boolean isCOMP_39_CALENDER_RENDERED() {
		return COMP_39_CALENDER_RENDERED;
	}

	public void setCOMP_39_CALENDER_RENDERED(boolean comp_39_calender_rendered) {
		COMP_39_CALENDER_RENDERED = comp_39_calender_rendered;
	}

	public boolean isCOMP_40_CALENDER_RENDERED() {
		return COMP_40_CALENDER_RENDERED;
	}

	public void setCOMP_40_CALENDER_RENDERED(boolean comp_40_calender_rendered) {
		COMP_40_CALENDER_RENDERED = comp_40_calender_rendered;
	}

	public boolean isCOMP_41_CALENDER_RENDERED() {
		return COMP_41_CALENDER_RENDERED;
	}

	public void setCOMP_41_CALENDER_RENDERED(boolean comp_41_calender_rendered) {
		COMP_41_CALENDER_RENDERED = comp_41_calender_rendered;
	}

	public boolean isCOMP_42_CALENDER_RENDERED() {
		return COMP_42_CALENDER_RENDERED;
	}

	public void setCOMP_42_CALENDER_RENDERED(boolean comp_42_calender_rendered) {
		COMP_42_CALENDER_RENDERED = comp_42_calender_rendered;
	}

	public boolean isCOMP_43_CALENDER_RENDERED() {
		return COMP_43_CALENDER_RENDERED;
	}

	public void setCOMP_43_CALENDER_RENDERED(boolean comp_43_calender_rendered) {
		COMP_43_CALENDER_RENDERED = comp_43_calender_rendered;
	}

	public boolean isCOMP_44_CALENDER_RENDERED() {
		return COMP_44_CALENDER_RENDERED;
	}

	public void setCOMP_44_CALENDER_RENDERED(boolean comp_44_calender_rendered) {
		COMP_44_CALENDER_RENDERED = comp_44_calender_rendered;
	}

	public boolean isCOMP_45_CALENDER_RENDERED() {
		return COMP_45_CALENDER_RENDERED;
	}

	public void setCOMP_45_CALENDER_RENDERED(boolean comp_45_calender_rendered) {
		COMP_45_CALENDER_RENDERED = comp_45_calender_rendered;
	}

	public boolean isCOMP_46_CALENDER_RENDERED() {
		return COMP_46_CALENDER_RENDERED;
	}

	public void setCOMP_46_CALENDER_RENDERED(boolean comp_46_calender_rendered) {
		COMP_46_CALENDER_RENDERED = comp_46_calender_rendered;
	}

	public boolean isCOMP_47_CALENDER_RENDERED() {
		return COMP_47_CALENDER_RENDERED;
	}

	public void setCOMP_47_CALENDER_RENDERED(boolean comp_47_calender_rendered) {
		COMP_47_CALENDER_RENDERED = comp_47_calender_rendered;
	}

	public boolean isCOMP_48_CALENDER_RENDERED() {
		return COMP_48_CALENDER_RENDERED;
	}

	public void setCOMP_48_CALENDER_RENDERED(boolean comp_48_calender_rendered) {
		COMP_48_CALENDER_RENDERED = comp_48_calender_rendered;
	}

	public boolean isCOMP_49_CALENDER_RENDERED() {
		return COMP_49_CALENDER_RENDERED;
	}

	public void setCOMP_49_CALENDER_RENDERED(boolean comp_49_calender_rendered) {
		COMP_49_CALENDER_RENDERED = comp_49_calender_rendered;
	}

	public boolean isCOMP_50_CALENDER_RENDERED() {
		return COMP_50_CALENDER_RENDERED;
	}

	public void setCOMP_50_CALENDER_RENDERED(boolean comp_50_calender_rendered) {
		COMP_50_CALENDER_RENDERED = comp_50_calender_rendered;
	}

	public boolean isCOMP_51_CALENDER_RENDERED() {
		return COMP_51_CALENDER_RENDERED;
	}

	public void setCOMP_51_CALENDER_RENDERED(boolean comp_51_calender_rendered) {
		COMP_51_CALENDER_RENDERED = comp_51_calender_rendered;
	}

	public boolean isCOMP_52_CALENDER_RENDERED() {
		return COMP_52_CALENDER_RENDERED;
	}

	public void setCOMP_52_CALENDER_RENDERED(boolean comp_52_calender_rendered) {
		COMP_52_CALENDER_RENDERED = comp_52_calender_rendered;
	}

	public boolean isCOMP_53_CALENDER_RENDERED() {
		return COMP_53_CALENDER_RENDERED;
	}

	public void setCOMP_53_CALENDER_RENDERED(boolean comp_53_calender_rendered) {
		COMP_53_CALENDER_RENDERED = comp_53_calender_rendered;
	}

	public boolean isCOMP_54_CALENDER_RENDERED() {
		return COMP_54_CALENDER_RENDERED;
	}

	public void setCOMP_54_CALENDER_RENDERED(boolean comp_54_calender_rendered) {
		COMP_54_CALENDER_RENDERED = comp_54_calender_rendered;
	}

	public boolean isCOMP_55_CALENDER_RENDERED() {
		return COMP_55_CALENDER_RENDERED;
	}

	public void setCOMP_55_CALENDER_RENDERED(boolean comp_55_calender_rendered) {
		COMP_55_CALENDER_RENDERED = comp_55_calender_rendered;
	}

	public boolean isCOMP_56_CALENDER_RENDERED() {
		return COMP_56_CALENDER_RENDERED;
	}

	public void setCOMP_56_CALENDER_RENDERED(boolean comp_56_calender_rendered) {
		COMP_56_CALENDER_RENDERED = comp_56_calender_rendered;
	}

	public boolean isCOMP_57_CALENDER_RENDERED() {
		return COMP_57_CALENDER_RENDERED;
	}

	public void setCOMP_57_CALENDER_RENDERED(boolean comp_57_calender_rendered) {
		COMP_57_CALENDER_RENDERED = comp_57_calender_rendered;
	}

	public boolean isCOMP_58_CALENDER_RENDERED() {
		return COMP_58_CALENDER_RENDERED;
	}

	public void setCOMP_58_CALENDER_RENDERED(boolean comp_58_calender_rendered) {
		COMP_58_CALENDER_RENDERED = comp_58_calender_rendered;
	}

	public boolean isCOMP_59_CALENDER_RENDERED() {
		return COMP_59_CALENDER_RENDERED;
	}

	public void setCOMP_59_CALENDER_RENDERED(boolean comp_59_calender_rendered) {
		COMP_59_CALENDER_RENDERED = comp_59_calender_rendered;
	}

	public boolean isCOMP_60_CALENDER_RENDERED() {
		return COMP_60_CALENDER_RENDERED;
	}

	public void setCOMP_60_CALENDER_RENDERED(boolean comp_60_calender_rendered) {
		COMP_60_CALENDER_RENDERED = comp_60_calender_rendered;
	}

	public boolean isCOMP_2_SELECT_ONE_MENU_RENDERED() {
		return COMP_2_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_2_SELECT_ONE_MENU_RENDERED(
			boolean comp_2_select_one_menu_rendered) {
		COMP_2_SELECT_ONE_MENU_RENDERED = comp_2_select_one_menu_rendered;
	}

	public boolean isCOMP_3_SELECT_ONE_MENU_RENDERED() {
		return COMP_3_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_3_SELECT_ONE_MENU_RENDERED(
			boolean comp_3_select_one_menu_rendered) {
		COMP_3_SELECT_ONE_MENU_RENDERED = comp_3_select_one_menu_rendered;
	}

	public boolean isCOMP_4_SELECT_ONE_MENU_RENDERED() {
		return COMP_4_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_4_SELECT_ONE_MENU_RENDERED(
			boolean comp_4_select_one_menu_rendered) {
		COMP_4_SELECT_ONE_MENU_RENDERED = comp_4_select_one_menu_rendered;
	}

	public boolean isCOMP_5_SELECT_ONE_MENU_RENDERED() {
		return COMP_5_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_5_SELECT_ONE_MENU_RENDERED(
			boolean comp_5_select_one_menu_rendered) {
		COMP_5_SELECT_ONE_MENU_RENDERED = comp_5_select_one_menu_rendered;
	}

	public boolean isCOMP_6_SELECT_ONE_MENU_RENDERED() {
		return COMP_6_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_6_SELECT_ONE_MENU_RENDERED(
			boolean comp_6_select_one_menu_rendered) {
		COMP_6_SELECT_ONE_MENU_RENDERED = comp_6_select_one_menu_rendered;
	}

	public boolean isCOMP_7_SELECT_ONE_MENU_RENDERED() {
		return COMP_7_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_7_SELECT_ONE_MENU_RENDERED(
			boolean comp_7_select_one_menu_rendered) {
		COMP_7_SELECT_ONE_MENU_RENDERED = comp_7_select_one_menu_rendered;
	}

	public boolean isCOMP_8_SELECT_ONE_MENU_RENDERED() {
		return COMP_8_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_8_SELECT_ONE_MENU_RENDERED(
			boolean comp_8_select_one_menu_rendered) {
		COMP_8_SELECT_ONE_MENU_RENDERED = comp_8_select_one_menu_rendered;
	}

	public boolean isCOMP_9_SELECT_ONE_MENU_RENDERED() {
		return COMP_9_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_9_SELECT_ONE_MENU_RENDERED(
			boolean comp_9_select_one_menu_rendered) {
		COMP_9_SELECT_ONE_MENU_RENDERED = comp_9_select_one_menu_rendered;
	}

	public boolean isCOMP_10_SELECT_ONE_MENU_RENDERED() {
		return COMP_10_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_10_SELECT_ONE_MENU_RENDERED(
			boolean comp_10_select_one_menu_rendered) {
		COMP_10_SELECT_ONE_MENU_RENDERED = comp_10_select_one_menu_rendered;
	}

	public boolean isCOMP_11_SELECT_ONE_MENU_RENDERED() {
		return COMP_11_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_11_SELECT_ONE_MENU_RENDERED(
			boolean comp_11_select_one_menu_rendered) {
		COMP_11_SELECT_ONE_MENU_RENDERED = comp_11_select_one_menu_rendered;
	}

	public boolean isCOMP_12_SELECT_ONE_MENU_RENDERED() {
		return COMP_12_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_12_SELECT_ONE_MENU_RENDERED(
			boolean comp_12_select_one_menu_rendered) {
		COMP_12_SELECT_ONE_MENU_RENDERED = comp_12_select_one_menu_rendered;
	}

	public boolean isCOMP_13_SELECT_ONE_MENU_RENDERED() {
		return COMP_13_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_13_SELECT_ONE_MENU_RENDERED(
			boolean comp_13_select_one_menu_rendered) {
		COMP_13_SELECT_ONE_MENU_RENDERED = comp_13_select_one_menu_rendered;
	}

	public boolean isCOMP_14_SELECT_ONE_MENU_RENDERED() {
		return COMP_14_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_14_SELECT_ONE_MENU_RENDERED(
			boolean comp_14_select_one_menu_rendered) {
		COMP_14_SELECT_ONE_MENU_RENDERED = comp_14_select_one_menu_rendered;
	}

	public boolean isCOMP_15_SELECT_ONE_MENU_RENDERED() {
		return COMP_15_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_15_SELECT_ONE_MENU_RENDERED(
			boolean comp_15_select_one_menu_rendered) {
		COMP_15_SELECT_ONE_MENU_RENDERED = comp_15_select_one_menu_rendered;
	}

	public boolean isCOMP_16_SELECT_ONE_MENU_RENDERED() {
		return COMP_16_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_16_SELECT_ONE_MENU_RENDERED(
			boolean comp_16_select_one_menu_rendered) {
		COMP_16_SELECT_ONE_MENU_RENDERED = comp_16_select_one_menu_rendered;
	}

	public boolean isCOMP_17_SELECT_ONE_MENU_RENDERED() {
		return COMP_17_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_17_SELECT_ONE_MENU_RENDERED(
			boolean comp_17_select_one_menu_rendered) {
		COMP_17_SELECT_ONE_MENU_RENDERED = comp_17_select_one_menu_rendered;
	}

	public boolean isCOMP_18_SELECT_ONE_MENU_RENDERED() {
		return COMP_18_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_18_SELECT_ONE_MENU_RENDERED(
			boolean comp_18_select_one_menu_rendered) {
		COMP_18_SELECT_ONE_MENU_RENDERED = comp_18_select_one_menu_rendered;
	}

	public boolean isCOMP_19_SELECT_ONE_MENU_RENDERED() {
		return COMP_19_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_19_SELECT_ONE_MENU_RENDERED(
			boolean comp_19_select_one_menu_rendered) {
		COMP_19_SELECT_ONE_MENU_RENDERED = comp_19_select_one_menu_rendered;
	}

	public boolean isCOMP_20_SELECT_ONE_MENU_RENDERED() {
		return COMP_20_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_20_SELECT_ONE_MENU_RENDERED(
			boolean comp_20_select_one_menu_rendered) {
		COMP_20_SELECT_ONE_MENU_RENDERED = comp_20_select_one_menu_rendered;
	}

	public boolean isCOMP_21_SELECT_ONE_MENU_RENDERED() {
		return COMP_21_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_21_SELECT_ONE_MENU_RENDERED(
			boolean comp_21_select_one_menu_rendered) {
		COMP_21_SELECT_ONE_MENU_RENDERED = comp_21_select_one_menu_rendered;
	}

	public boolean isCOMP_22_SELECT_ONE_MENU_RENDERED() {
		return COMP_22_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_22_SELECT_ONE_MENU_RENDERED(
			boolean comp_22_select_one_menu_rendered) {
		COMP_22_SELECT_ONE_MENU_RENDERED = comp_22_select_one_menu_rendered;
	}

	public boolean isCOMP_23_SELECT_ONE_MENU_RENDERED() {
		return COMP_23_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_23_SELECT_ONE_MENU_RENDERED(
			boolean comp_23_select_one_menu_rendered) {
		COMP_23_SELECT_ONE_MENU_RENDERED = comp_23_select_one_menu_rendered;
	}

	public boolean isCOMP_24_SELECT_ONE_MENU_RENDERED() {
		return COMP_24_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_24_SELECT_ONE_MENU_RENDERED(
			boolean comp_24_select_one_menu_rendered) {
		COMP_24_SELECT_ONE_MENU_RENDERED = comp_24_select_one_menu_rendered;
	}

	public boolean isCOMP_25_SELECT_ONE_MENU_RENDERED() {
		return COMP_25_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_25_SELECT_ONE_MENU_RENDERED(
			boolean comp_25_select_one_menu_rendered) {
		COMP_25_SELECT_ONE_MENU_RENDERED = comp_25_select_one_menu_rendered;
	}

	public boolean isCOMP_26_SELECT_ONE_MENU_RENDERED() {
		return COMP_26_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_26_SELECT_ONE_MENU_RENDERED(
			boolean comp_26_select_one_menu_rendered) {
		COMP_26_SELECT_ONE_MENU_RENDERED = comp_26_select_one_menu_rendered;
	}

	public boolean isCOMP_27_SELECT_ONE_MENU_RENDERED() {
		return COMP_27_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_27_SELECT_ONE_MENU_RENDERED(
			boolean comp_27_select_one_menu_rendered) {
		COMP_27_SELECT_ONE_MENU_RENDERED = comp_27_select_one_menu_rendered;
	}

	public boolean isCOMP_28_SELECT_ONE_MENU_RENDERED() {
		return COMP_28_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_28_SELECT_ONE_MENU_RENDERED(
			boolean comp_28_select_one_menu_rendered) {
		COMP_28_SELECT_ONE_MENU_RENDERED = comp_28_select_one_menu_rendered;
	}

	public boolean isCOMP_29_SELECT_ONE_MENU_RENDERED() {
		return COMP_29_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_29_SELECT_ONE_MENU_RENDERED(
			boolean comp_29_select_one_menu_rendered) {
		COMP_29_SELECT_ONE_MENU_RENDERED = comp_29_select_one_menu_rendered;
	}

	public boolean isCOMP_30_SELECT_ONE_MENU_RENDERED() {
		return COMP_30_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_30_SELECT_ONE_MENU_RENDERED(
			boolean comp_30_select_one_menu_rendered) {
		COMP_30_SELECT_ONE_MENU_RENDERED = comp_30_select_one_menu_rendered;
	}

	public boolean isCOMP_31_SELECT_ONE_MENU_RENDERED() {
		return COMP_31_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_31_SELECT_ONE_MENU_RENDERED(
			boolean comp_31_select_one_menu_rendered) {
		COMP_31_SELECT_ONE_MENU_RENDERED = comp_31_select_one_menu_rendered;
	}

	public boolean isCOMP_32_SELECT_ONE_MENU_RENDERED() {
		return COMP_32_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_32_SELECT_ONE_MENU_RENDERED(
			boolean comp_32_select_one_menu_rendered) {
		COMP_32_SELECT_ONE_MENU_RENDERED = comp_32_select_one_menu_rendered;
	}

	public boolean isCOMP_33_SELECT_ONE_MENU_RENDERED() {
		return COMP_33_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_33_SELECT_ONE_MENU_RENDERED(
			boolean comp_33_select_one_menu_rendered) {
		COMP_33_SELECT_ONE_MENU_RENDERED = comp_33_select_one_menu_rendered;
	}

	public boolean isCOMP_34_SELECT_ONE_MENU_RENDERED() {
		return COMP_34_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_34_SELECT_ONE_MENU_RENDERED(
			boolean comp_34_select_one_menu_rendered) {
		COMP_34_SELECT_ONE_MENU_RENDERED = comp_34_select_one_menu_rendered;
	}

	public boolean isCOMP_35_SELECT_ONE_MENU_RENDERED() {
		return COMP_35_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_35_SELECT_ONE_MENU_RENDERED(
			boolean comp_35_select_one_menu_rendered) {
		COMP_35_SELECT_ONE_MENU_RENDERED = comp_35_select_one_menu_rendered;
	}

	public boolean isCOMP_36_SELECT_ONE_MENU_RENDERED() {
		return COMP_36_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_36_SELECT_ONE_MENU_RENDERED(
			boolean comp_36_select_one_menu_rendered) {
		COMP_36_SELECT_ONE_MENU_RENDERED = comp_36_select_one_menu_rendered;
	}

	public boolean isCOMP_37_SELECT_ONE_MENU_RENDERED() {
		return COMP_37_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_37_SELECT_ONE_MENU_RENDERED(
			boolean comp_37_select_one_menu_rendered) {
		COMP_37_SELECT_ONE_MENU_RENDERED = comp_37_select_one_menu_rendered;
	}

	public boolean isCOMP_38_SELECT_ONE_MENU_RENDERED() {
		return COMP_38_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_38_SELECT_ONE_MENU_RENDERED(
			boolean comp_38_select_one_menu_rendered) {
		COMP_38_SELECT_ONE_MENU_RENDERED = comp_38_select_one_menu_rendered;
	}

	public boolean isCOMP_39_SELECT_ONE_MENU_RENDERED() {
		return COMP_39_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_39_SELECT_ONE_MENU_RENDERED(
			boolean comp_39_select_one_menu_rendered) {
		COMP_39_SELECT_ONE_MENU_RENDERED = comp_39_select_one_menu_rendered;
	}

	public boolean isCOMP_40_SELECT_ONE_MENU_RENDERED() {
		return COMP_40_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_40_SELECT_ONE_MENU_RENDERED(
			boolean comp_40_select_one_menu_rendered) {
		COMP_40_SELECT_ONE_MENU_RENDERED = comp_40_select_one_menu_rendered;
	}

	public boolean isCOMP_41_SELECT_ONE_MENU_RENDERED() {
		return COMP_41_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_41_SELECT_ONE_MENU_RENDERED(
			boolean comp_41_select_one_menu_rendered) {
		COMP_41_SELECT_ONE_MENU_RENDERED = comp_41_select_one_menu_rendered;
	}

	public boolean isCOMP_42_SELECT_ONE_MENU_RENDERED() {
		return COMP_42_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_42_SELECT_ONE_MENU_RENDERED(
			boolean comp_42_select_one_menu_rendered) {
		COMP_42_SELECT_ONE_MENU_RENDERED = comp_42_select_one_menu_rendered;
	}

	public boolean isCOMP_43_SELECT_ONE_MENU_RENDERED() {
		return COMP_43_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_43_SELECT_ONE_MENU_RENDERED(
			boolean comp_43_select_one_menu_rendered) {
		COMP_43_SELECT_ONE_MENU_RENDERED = comp_43_select_one_menu_rendered;
	}

	public boolean isCOMP_44_SELECT_ONE_MENU_RENDERED() {
		return COMP_44_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_44_SELECT_ONE_MENU_RENDERED(
			boolean comp_44_select_one_menu_rendered) {
		COMP_44_SELECT_ONE_MENU_RENDERED = comp_44_select_one_menu_rendered;
	}

	public boolean isCOMP_45_SELECT_ONE_MENU_RENDERED() {
		return COMP_45_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_45_SELECT_ONE_MENU_RENDERED(
			boolean comp_45_select_one_menu_rendered) {
		COMP_45_SELECT_ONE_MENU_RENDERED = comp_45_select_one_menu_rendered;
	}

	public boolean isCOMP_46_SELECT_ONE_MENU_RENDERED() {
		return COMP_46_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_46_SELECT_ONE_MENU_RENDERED(
			boolean comp_46_select_one_menu_rendered) {
		COMP_46_SELECT_ONE_MENU_RENDERED = comp_46_select_one_menu_rendered;
	}

	public boolean isCOMP_47_SELECT_ONE_MENU_RENDERED() {
		return COMP_47_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_47_SELECT_ONE_MENU_RENDERED(
			boolean comp_47_select_one_menu_rendered) {
		COMP_47_SELECT_ONE_MENU_RENDERED = comp_47_select_one_menu_rendered;
	}

	public boolean isCOMP_48_SELECT_ONE_MENU_RENDERED() {
		return COMP_48_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_48_SELECT_ONE_MENU_RENDERED(
			boolean comp_48_select_one_menu_rendered) {
		COMP_48_SELECT_ONE_MENU_RENDERED = comp_48_select_one_menu_rendered;
	}

	public boolean isCOMP_49_SELECT_ONE_MENU_RENDERED() {
		return COMP_49_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_49_SELECT_ONE_MENU_RENDERED(
			boolean comp_49_select_one_menu_rendered) {
		COMP_49_SELECT_ONE_MENU_RENDERED = comp_49_select_one_menu_rendered;
	}

	public boolean isCOMP_50_SELECT_ONE_MENU_RENDERED() {
		return COMP_50_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_50_SELECT_ONE_MENU_RENDERED(
			boolean comp_50_select_one_menu_rendered) {
		COMP_50_SELECT_ONE_MENU_RENDERED = comp_50_select_one_menu_rendered;
	}

	public boolean isCOMP_51_SELECT_ONE_MENU_RENDERED() {
		return COMP_51_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_51_SELECT_ONE_MENU_RENDERED(
			boolean comp_51_select_one_menu_rendered) {
		COMP_51_SELECT_ONE_MENU_RENDERED = comp_51_select_one_menu_rendered;
	}

	public boolean isCOMP_52_SELECT_ONE_MENU_RENDERED() {
		return COMP_52_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_52_SELECT_ONE_MENU_RENDERED(
			boolean comp_52_select_one_menu_rendered) {
		COMP_52_SELECT_ONE_MENU_RENDERED = comp_52_select_one_menu_rendered;
	}

	public boolean isCOMP_53_SELECT_ONE_MENU_RENDERED() {
		return COMP_53_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_53_SELECT_ONE_MENU_RENDERED(
			boolean comp_53_select_one_menu_rendered) {
		COMP_53_SELECT_ONE_MENU_RENDERED = comp_53_select_one_menu_rendered;
	}

	public boolean isCOMP_54_SELECT_ONE_MENU_RENDERED() {
		return COMP_54_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_54_SELECT_ONE_MENU_RENDERED(
			boolean comp_54_select_one_menu_rendered) {
		COMP_54_SELECT_ONE_MENU_RENDERED = comp_54_select_one_menu_rendered;
	}

	public boolean isCOMP_55_SELECT_ONE_MENU_RENDERED() {
		return COMP_55_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_55_SELECT_ONE_MENU_RENDERED(
			boolean comp_55_select_one_menu_rendered) {
		COMP_55_SELECT_ONE_MENU_RENDERED = comp_55_select_one_menu_rendered;
	}

	public boolean isCOMP_56_SELECT_ONE_MENU_RENDERED() {
		return COMP_56_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_56_SELECT_ONE_MENU_RENDERED(
			boolean comp_56_select_one_menu_rendered) {
		COMP_56_SELECT_ONE_MENU_RENDERED = comp_56_select_one_menu_rendered;
	}

	public boolean isCOMP_57_SELECT_ONE_MENU_RENDERED() {
		return COMP_57_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_57_SELECT_ONE_MENU_RENDERED(
			boolean comp_57_select_one_menu_rendered) {
		COMP_57_SELECT_ONE_MENU_RENDERED = comp_57_select_one_menu_rendered;
	}

	public boolean isCOMP_58_SELECT_ONE_MENU_RENDERED() {
		return COMP_58_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_58_SELECT_ONE_MENU_RENDERED(
			boolean comp_58_select_one_menu_rendered) {
		COMP_58_SELECT_ONE_MENU_RENDERED = comp_58_select_one_menu_rendered;
	}

	public boolean isCOMP_59_SELECT_ONE_MENU_RENDERED() {
		return COMP_59_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_59_SELECT_ONE_MENU_RENDERED(
			boolean comp_59_select_one_menu_rendered) {
		COMP_59_SELECT_ONE_MENU_RENDERED = comp_59_select_one_menu_rendered;
	}

	public boolean isCOMP_60_SELECT_ONE_MENU_RENDERED() {
		return COMP_60_SELECT_ONE_MENU_RENDERED;
	}

	public void setCOMP_60_SELECT_ONE_MENU_RENDERED(
			boolean comp_60_select_one_menu_rendered) {
		COMP_60_SELECT_ONE_MENU_RENDERED = comp_60_select_one_menu_rendered;
	}

	public boolean isCOMP_2_INPUT_TEXT_RENDERED() {
		return COMP_2_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_2_INPUT_TEXT_RENDERED(boolean comp_2_input_text_rendered) {
		COMP_2_INPUT_TEXT_RENDERED = comp_2_input_text_rendered;
	}

	public boolean isCOMP_3_INPUT_TEXT_RENDERED() {
		return COMP_3_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_3_INPUT_TEXT_RENDERED(boolean comp_3_input_text_rendered) {
		COMP_3_INPUT_TEXT_RENDERED = comp_3_input_text_rendered;
	}

	public boolean isCOMP_4_INPUT_TEXT_RENDERED() {
		return COMP_4_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_4_INPUT_TEXT_RENDERED(boolean comp_4_input_text_rendered) {
		COMP_4_INPUT_TEXT_RENDERED = comp_4_input_text_rendered;
	}

	public boolean isCOMP_5_INPUT_TEXT_RENDERED() {
		return COMP_5_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_5_INPUT_TEXT_RENDERED(boolean comp_5_input_text_rendered) {
		COMP_5_INPUT_TEXT_RENDERED = comp_5_input_text_rendered;
	}

	public boolean isCOMP_6_INPUT_TEXT_RENDERED() {
		return COMP_6_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_6_INPUT_TEXT_RENDERED(boolean comp_6_input_text_rendered) {
		COMP_6_INPUT_TEXT_RENDERED = comp_6_input_text_rendered;
	}

	public boolean isCOMP_7_INPUT_TEXT_RENDERED() {
		return COMP_7_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_7_INPUT_TEXT_RENDERED(boolean comp_7_input_text_rendered) {
		COMP_7_INPUT_TEXT_RENDERED = comp_7_input_text_rendered;
	}

	public boolean isCOMP_8_INPUT_TEXT_RENDERED() {
		return COMP_8_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_8_INPUT_TEXT_RENDERED(boolean comp_8_input_text_rendered) {
		COMP_8_INPUT_TEXT_RENDERED = comp_8_input_text_rendered;
	}

	public boolean isCOMP_9_INPUT_TEXT_RENDERED() {
		return COMP_9_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_9_INPUT_TEXT_RENDERED(boolean comp_9_input_text_rendered) {
		COMP_9_INPUT_TEXT_RENDERED = comp_9_input_text_rendered;
	}

	public boolean isCOMP_10_INPUT_TEXT_RENDERED() {
		return COMP_10_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_10_INPUT_TEXT_RENDERED(boolean comp_10_input_text_rendered) {
		COMP_10_INPUT_TEXT_RENDERED = comp_10_input_text_rendered;
	}

	public boolean isCOMP_11_INPUT_TEXT_RENDERED() {
		return COMP_11_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_11_INPUT_TEXT_RENDERED(boolean comp_11_input_text_rendered) {
		COMP_11_INPUT_TEXT_RENDERED = comp_11_input_text_rendered;
	}

	public boolean isCOMP_12_INPUT_TEXT_RENDERED() {
		return COMP_12_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_12_INPUT_TEXT_RENDERED(boolean comp_12_input_text_rendered) {
		COMP_12_INPUT_TEXT_RENDERED = comp_12_input_text_rendered;
	}

	public boolean isCOMP_13_INPUT_TEXT_RENDERED() {
		return COMP_13_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_13_INPUT_TEXT_RENDERED(boolean comp_13_input_text_rendered) {
		COMP_13_INPUT_TEXT_RENDERED = comp_13_input_text_rendered;
	}

	public boolean isCOMP_14_INPUT_TEXT_RENDERED() {
		return COMP_14_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_14_INPUT_TEXT_RENDERED(boolean comp_14_input_text_rendered) {
		COMP_14_INPUT_TEXT_RENDERED = comp_14_input_text_rendered;
	}

	public boolean isCOMP_15_INPUT_TEXT_RENDERED() {
		return COMP_15_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_15_INPUT_TEXT_RENDERED(boolean comp_15_input_text_rendered) {
		COMP_15_INPUT_TEXT_RENDERED = comp_15_input_text_rendered;
	}

	public boolean isCOMP_16_INPUT_TEXT_RENDERED() {
		return COMP_16_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_16_INPUT_TEXT_RENDERED(boolean comp_16_input_text_rendered) {
		COMP_16_INPUT_TEXT_RENDERED = comp_16_input_text_rendered;
	}

	public boolean isCOMP_17_INPUT_TEXT_RENDERED() {
		return COMP_17_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_17_INPUT_TEXT_RENDERED(boolean comp_17_input_text_rendered) {
		COMP_17_INPUT_TEXT_RENDERED = comp_17_input_text_rendered;
	}

	public boolean isCOMP_18_INPUT_TEXT_RENDERED() {
		return COMP_18_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_18_INPUT_TEXT_RENDERED(boolean comp_18_input_text_rendered) {
		COMP_18_INPUT_TEXT_RENDERED = comp_18_input_text_rendered;
	}

	public boolean isCOMP_19_INPUT_TEXT_RENDERED() {
		return COMP_19_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_19_INPUT_TEXT_RENDERED(boolean comp_19_input_text_rendered) {
		COMP_19_INPUT_TEXT_RENDERED = comp_19_input_text_rendered;
	}

	public boolean isCOMP_20_INPUT_TEXT_RENDERED() {
		return COMP_20_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_20_INPUT_TEXT_RENDERED(boolean comp_20_input_text_rendered) {
		COMP_20_INPUT_TEXT_RENDERED = comp_20_input_text_rendered;
	}

	public boolean isCOMP_21_INPUT_TEXT_RENDERED() {
		return COMP_21_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_21_INPUT_TEXT_RENDERED(boolean comp_21_input_text_rendered) {
		COMP_21_INPUT_TEXT_RENDERED = comp_21_input_text_rendered;
	}

	public boolean isCOMP_22_INPUT_TEXT_RENDERED() {
		return COMP_22_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_22_INPUT_TEXT_RENDERED(boolean comp_22_input_text_rendered) {
		COMP_22_INPUT_TEXT_RENDERED = comp_22_input_text_rendered;
	}

	public boolean isCOMP_23_INPUT_TEXT_RENDERED() {
		return COMP_23_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_23_INPUT_TEXT_RENDERED(boolean comp_23_input_text_rendered) {
		COMP_23_INPUT_TEXT_RENDERED = comp_23_input_text_rendered;
	}

	public boolean isCOMP_24_INPUT_TEXT_RENDERED() {
		return COMP_24_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_24_INPUT_TEXT_RENDERED(boolean comp_24_input_text_rendered) {
		COMP_24_INPUT_TEXT_RENDERED = comp_24_input_text_rendered;
	}

	public boolean isCOMP_25_INPUT_TEXT_RENDERED() {
		return COMP_25_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_25_INPUT_TEXT_RENDERED(boolean comp_25_input_text_rendered) {
		COMP_25_INPUT_TEXT_RENDERED = comp_25_input_text_rendered;
	}

	public boolean isCOMP_26_INPUT_TEXT_RENDERED() {
		return COMP_26_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_26_INPUT_TEXT_RENDERED(boolean comp_26_input_text_rendered) {
		COMP_26_INPUT_TEXT_RENDERED = comp_26_input_text_rendered;
	}

	public boolean isCOMP_27_INPUT_TEXT_RENDERED() {
		return COMP_27_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_27_INPUT_TEXT_RENDERED(boolean comp_27_input_text_rendered) {
		COMP_27_INPUT_TEXT_RENDERED = comp_27_input_text_rendered;
	}

	public boolean isCOMP_28_INPUT_TEXT_RENDERED() {
		return COMP_28_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_28_INPUT_TEXT_RENDERED(boolean comp_28_input_text_rendered) {
		COMP_28_INPUT_TEXT_RENDERED = comp_28_input_text_rendered;
	}

	public boolean isCOMP_29_INPUT_TEXT_RENDERED() {
		return COMP_29_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_29_INPUT_TEXT_RENDERED(boolean comp_29_input_text_rendered) {
		COMP_29_INPUT_TEXT_RENDERED = comp_29_input_text_rendered;
	}

	public boolean isCOMP_30_INPUT_TEXT_RENDERED() {
		return COMP_30_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_30_INPUT_TEXT_RENDERED(boolean comp_30_input_text_rendered) {
		COMP_30_INPUT_TEXT_RENDERED = comp_30_input_text_rendered;
	}

	public boolean isCOMP_31_INPUT_TEXT_RENDERED() {
		return COMP_31_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_31_INPUT_TEXT_RENDERED(boolean comp_31_input_text_rendered) {
		COMP_31_INPUT_TEXT_RENDERED = comp_31_input_text_rendered;
	}

	public boolean isCOMP_32_INPUT_TEXT_RENDERED() {
		return COMP_32_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_32_INPUT_TEXT_RENDERED(boolean comp_32_input_text_rendered) {
		COMP_32_INPUT_TEXT_RENDERED = comp_32_input_text_rendered;
	}

	public boolean isCOMP_33_INPUT_TEXT_RENDERED() {
		return COMP_33_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_33_INPUT_TEXT_RENDERED(boolean comp_33_input_text_rendered) {
		COMP_33_INPUT_TEXT_RENDERED = comp_33_input_text_rendered;
	}

	public boolean isCOMP_34_INPUT_TEXT_RENDERED() {
		return COMP_34_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_34_INPUT_TEXT_RENDERED(boolean comp_34_input_text_rendered) {
		COMP_34_INPUT_TEXT_RENDERED = comp_34_input_text_rendered;
	}

	public boolean isCOMP_35_INPUT_TEXT_RENDERED() {
		return COMP_35_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_35_INPUT_TEXT_RENDERED(boolean comp_35_input_text_rendered) {
		COMP_35_INPUT_TEXT_RENDERED = comp_35_input_text_rendered;
	}

	public boolean isCOMP_36_INPUT_TEXT_RENDERED() {
		return COMP_36_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_36_INPUT_TEXT_RENDERED(boolean comp_36_input_text_rendered) {
		COMP_36_INPUT_TEXT_RENDERED = comp_36_input_text_rendered;
	}

	public boolean isCOMP_37_INPUT_TEXT_RENDERED() {
		return COMP_37_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_37_INPUT_TEXT_RENDERED(boolean comp_37_input_text_rendered) {
		COMP_37_INPUT_TEXT_RENDERED = comp_37_input_text_rendered;
	}

	public boolean isCOMP_38_INPUT_TEXT_RENDERED() {
		return COMP_38_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_38_INPUT_TEXT_RENDERED(boolean comp_38_input_text_rendered) {
		COMP_38_INPUT_TEXT_RENDERED = comp_38_input_text_rendered;
	}

	public boolean isCOMP_39_INPUT_TEXT_RENDERED() {
		return COMP_39_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_39_INPUT_TEXT_RENDERED(boolean comp_39_input_text_rendered) {
		COMP_39_INPUT_TEXT_RENDERED = comp_39_input_text_rendered;
	}

	public boolean isCOMP_40_INPUT_TEXT_RENDERED() {
		return COMP_40_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_40_INPUT_TEXT_RENDERED(boolean comp_40_input_text_rendered) {
		COMP_40_INPUT_TEXT_RENDERED = comp_40_input_text_rendered;
	}

	public boolean isCOMP_41_INPUT_TEXT_RENDERED() {
		return COMP_41_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_41_INPUT_TEXT_RENDERED(boolean comp_41_input_text_rendered) {
		COMP_41_INPUT_TEXT_RENDERED = comp_41_input_text_rendered;
	}

	public boolean isCOMP_42_INPUT_TEXT_RENDERED() {
		return COMP_42_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_42_INPUT_TEXT_RENDERED(boolean comp_42_input_text_rendered) {
		COMP_42_INPUT_TEXT_RENDERED = comp_42_input_text_rendered;
	}

	public boolean isCOMP_43_INPUT_TEXT_RENDERED() {
		return COMP_43_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_43_INPUT_TEXT_RENDERED(boolean comp_43_input_text_rendered) {
		COMP_43_INPUT_TEXT_RENDERED = comp_43_input_text_rendered;
	}

	public boolean isCOMP_44_INPUT_TEXT_RENDERED() {
		return COMP_44_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_44_INPUT_TEXT_RENDERED(boolean comp_44_input_text_rendered) {
		COMP_44_INPUT_TEXT_RENDERED = comp_44_input_text_rendered;
	}

	public boolean isCOMP_45_INPUT_TEXT_RENDERED() {
		return COMP_45_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_45_INPUT_TEXT_RENDERED(boolean comp_45_input_text_rendered) {
		COMP_45_INPUT_TEXT_RENDERED = comp_45_input_text_rendered;
	}

	public boolean isCOMP_46_INPUT_TEXT_RENDERED() {
		return COMP_46_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_46_INPUT_TEXT_RENDERED(boolean comp_46_input_text_rendered) {
		COMP_46_INPUT_TEXT_RENDERED = comp_46_input_text_rendered;
	}

	public boolean isCOMP_47_INPUT_TEXT_RENDERED() {
		return COMP_47_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_47_INPUT_TEXT_RENDERED(boolean comp_47_input_text_rendered) {
		COMP_47_INPUT_TEXT_RENDERED = comp_47_input_text_rendered;
	}

	public boolean isCOMP_48_INPUT_TEXT_RENDERED() {
		return COMP_48_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_48_INPUT_TEXT_RENDERED(boolean comp_48_input_text_rendered) {
		COMP_48_INPUT_TEXT_RENDERED = comp_48_input_text_rendered;
	}

	public boolean isCOMP_49_INPUT_TEXT_RENDERED() {
		return COMP_49_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_49_INPUT_TEXT_RENDERED(boolean comp_49_input_text_rendered) {
		COMP_49_INPUT_TEXT_RENDERED = comp_49_input_text_rendered;
	}

	public boolean isCOMP_50_INPUT_TEXT_RENDERED() {
		return COMP_50_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_50_INPUT_TEXT_RENDERED(boolean comp_50_input_text_rendered) {
		COMP_50_INPUT_TEXT_RENDERED = comp_50_input_text_rendered;
	}

	public boolean isCOMP_51_INPUT_TEXT_RENDERED() {
		return COMP_51_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_51_INPUT_TEXT_RENDERED(boolean comp_51_input_text_rendered) {
		COMP_51_INPUT_TEXT_RENDERED = comp_51_input_text_rendered;
	}

	public boolean isCOMP_52_INPUT_TEXT_RENDERED() {
		return COMP_52_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_52_INPUT_TEXT_RENDERED(boolean comp_52_input_text_rendered) {
		COMP_52_INPUT_TEXT_RENDERED = comp_52_input_text_rendered;
	}

	public boolean isCOMP_53_INPUT_TEXT_RENDERED() {
		return COMP_53_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_53_INPUT_TEXT_RENDERED(boolean comp_53_input_text_rendered) {
		COMP_53_INPUT_TEXT_RENDERED = comp_53_input_text_rendered;
	}

	public boolean isCOMP_54_INPUT_TEXT_RENDERED() {
		return COMP_54_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_54_INPUT_TEXT_RENDERED(boolean comp_54_input_text_rendered) {
		COMP_54_INPUT_TEXT_RENDERED = comp_54_input_text_rendered;
	}

	public boolean isCOMP_55_INPUT_TEXT_RENDERED() {
		return COMP_55_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_55_INPUT_TEXT_RENDERED(boolean comp_55_input_text_rendered) {
		COMP_55_INPUT_TEXT_RENDERED = comp_55_input_text_rendered;
	}

	public boolean isCOMP_56_INPUT_TEXT_RENDERED() {
		return COMP_56_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_56_INPUT_TEXT_RENDERED(boolean comp_56_input_text_rendered) {
		COMP_56_INPUT_TEXT_RENDERED = comp_56_input_text_rendered;
	}

	public boolean isCOMP_57_INPUT_TEXT_RENDERED() {
		return COMP_57_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_57_INPUT_TEXT_RENDERED(boolean comp_57_input_text_rendered) {
		COMP_57_INPUT_TEXT_RENDERED = comp_57_input_text_rendered;
	}

	public boolean isCOMP_58_INPUT_TEXT_RENDERED() {
		return COMP_58_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_58_INPUT_TEXT_RENDERED(boolean comp_58_input_text_rendered) {
		COMP_58_INPUT_TEXT_RENDERED = comp_58_input_text_rendered;
	}

	public boolean isCOMP_59_INPUT_TEXT_RENDERED() {
		return COMP_59_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_59_INPUT_TEXT_RENDERED(boolean comp_59_input_text_rendered) {
		COMP_59_INPUT_TEXT_RENDERED = comp_59_input_text_rendered;
	}

	public boolean isCOMP_60_INPUT_TEXT_RENDERED() {
		return COMP_60_INPUT_TEXT_RENDERED;
	}

	public void setCOMP_60_INPUT_TEXT_RENDERED(boolean comp_60_input_text_rendered) {
		COMP_60_INPUT_TEXT_RENDERED = comp_60_input_text_rendered;
	}

	public HtmlCalendar getCOMP_2_CALENDER() {
		return COMP_2_CALENDER;
	}

	public void setCOMP_2_CALENDER(HtmlCalendar comp_2_calender) {
		COMP_2_CALENDER = comp_2_calender;
	}

	public HtmlCalendar getCOMP_3_CALENDER() {
		return COMP_3_CALENDER;
	}

	public void setCOMP_3_CALENDER(HtmlCalendar comp_3_calender) {
		COMP_3_CALENDER = comp_3_calender;
	}

	public HtmlCalendar getCOMP_4_CALENDER() {
		return COMP_4_CALENDER;
	}

	public void setCOMP_4_CALENDER(HtmlCalendar comp_4_calender) {
		COMP_4_CALENDER = comp_4_calender;
	}

	public HtmlCalendar getCOMP_5_CALENDER() {
		return COMP_5_CALENDER;
	}

	public void setCOMP_5_CALENDER(HtmlCalendar comp_5_calender) {
		COMP_5_CALENDER = comp_5_calender;
	}

	public HtmlCalendar getCOMP_6_CALENDER() {
		return COMP_6_CALENDER;
	}

	public void setCOMP_6_CALENDER(HtmlCalendar comp_6_calender) {
		COMP_6_CALENDER = comp_6_calender;
	}

	public HtmlCalendar getCOMP_7_CALENDER() {
		return COMP_7_CALENDER;
	}

	public void setCOMP_7_CALENDER(HtmlCalendar comp_7_calender) {
		COMP_7_CALENDER = comp_7_calender;
	}

	public HtmlCalendar getCOMP_8_CALENDER() {
		return COMP_8_CALENDER;
	}

	public void setCOMP_8_CALENDER(HtmlCalendar comp_8_calender) {
		COMP_8_CALENDER = comp_8_calender;
	}

	public HtmlCalendar getCOMP_9_CALENDER() {
		return COMP_9_CALENDER;
	}

	public void setCOMP_9_CALENDER(HtmlCalendar comp_9_calender) {
		COMP_9_CALENDER = comp_9_calender;
	}

	public HtmlCalendar getCOMP_10_CALENDER() {
		return COMP_10_CALENDER;
	}

	public void setCOMP_10_CALENDER(HtmlCalendar comp_10_calender) {
		COMP_10_CALENDER = comp_10_calender;
	}

	public HtmlCalendar getCOMP_11_CALENDER() {
		return COMP_11_CALENDER;
	}

	public void setCOMP_11_CALENDER(HtmlCalendar comp_11_calender) {
		COMP_11_CALENDER = comp_11_calender;
	}

	public HtmlCalendar getCOMP_12_CALENDER() {
		return COMP_12_CALENDER;
	}

	public void setCOMP_12_CALENDER(HtmlCalendar comp_12_calender) {
		COMP_12_CALENDER = comp_12_calender;
	}

	public HtmlCalendar getCOMP_13_CALENDER() {
		return COMP_13_CALENDER;
	}

	public void setCOMP_13_CALENDER(HtmlCalendar comp_13_calender) {
		COMP_13_CALENDER = comp_13_calender;
	}

	public HtmlCalendar getCOMP_14_CALENDER() {
		return COMP_14_CALENDER;
	}

	public void setCOMP_14_CALENDER(HtmlCalendar comp_14_calender) {
		COMP_14_CALENDER = comp_14_calender;
	}

	public HtmlCalendar getCOMP_15_CALENDER() {
		return COMP_15_CALENDER;
	}

	public void setCOMP_15_CALENDER(HtmlCalendar comp_15_calender) {
		COMP_15_CALENDER = comp_15_calender;
	}

	public HtmlCalendar getCOMP_16_CALENDER() {
		return COMP_16_CALENDER;
	}

	public void setCOMP_16_CALENDER(HtmlCalendar comp_16_calender) {
		COMP_16_CALENDER = comp_16_calender;
	}

	public HtmlCalendar getCOMP_17_CALENDER() {
		return COMP_17_CALENDER;
	}

	public void setCOMP_17_CALENDER(HtmlCalendar comp_17_calender) {
		COMP_17_CALENDER = comp_17_calender;
	}

	public HtmlCalendar getCOMP_18_CALENDER() {
		return COMP_18_CALENDER;
	}

	public void setCOMP_18_CALENDER(HtmlCalendar comp_18_calender) {
		COMP_18_CALENDER = comp_18_calender;
	}

	public HtmlCalendar getCOMP_19_CALENDER() {
		return COMP_19_CALENDER;
	}

	public void setCOMP_19_CALENDER(HtmlCalendar comp_19_calender) {
		COMP_19_CALENDER = comp_19_calender;
	}

	public HtmlCalendar getCOMP_20_CALENDER() {
		return COMP_20_CALENDER;
	}

	public void setCOMP_20_CALENDER(HtmlCalendar comp_20_calender) {
		COMP_20_CALENDER = comp_20_calender;
	}

	public HtmlCalendar getCOMP_21_CALENDER() {
		return COMP_21_CALENDER;
	}

	public void setCOMP_21_CALENDER(HtmlCalendar comp_21_calender) {
		COMP_21_CALENDER = comp_21_calender;
	}

	public HtmlCalendar getCOMP_22_CALENDER() {
		return COMP_22_CALENDER;
	}

	public void setCOMP_22_CALENDER(HtmlCalendar comp_22_calender) {
		COMP_22_CALENDER = comp_22_calender;
	}

	public HtmlCalendar getCOMP_23_CALENDER() {
		return COMP_23_CALENDER;
	}

	public void setCOMP_23_CALENDER(HtmlCalendar comp_23_calender) {
		COMP_23_CALENDER = comp_23_calender;
	}

	public HtmlCalendar getCOMP_24_CALENDER() {
		return COMP_24_CALENDER;
	}

	public void setCOMP_24_CALENDER(HtmlCalendar comp_24_calender) {
		COMP_24_CALENDER = comp_24_calender;
	}

	public HtmlCalendar getCOMP_25_CALENDER() {
		return COMP_25_CALENDER;
	}

	public void setCOMP_25_CALENDER(HtmlCalendar comp_25_calender) {
		COMP_25_CALENDER = comp_25_calender;
	}

	public HtmlCalendar getCOMP_26_CALENDER() {
		return COMP_26_CALENDER;
	}

	public void setCOMP_26_CALENDER(HtmlCalendar comp_26_calender) {
		COMP_26_CALENDER = comp_26_calender;
	}

	public HtmlCalendar getCOMP_27_CALENDER() {
		return COMP_27_CALENDER;
	}

	public void setCOMP_27_CALENDER(HtmlCalendar comp_27_calender) {
		COMP_27_CALENDER = comp_27_calender;
	}

	public HtmlCalendar getCOMP_28_CALENDER() {
		return COMP_28_CALENDER;
	}

	public void setCOMP_28_CALENDER(HtmlCalendar comp_28_calender) {
		COMP_28_CALENDER = comp_28_calender;
	}

	public HtmlCalendar getCOMP_29_CALENDER() {
		return COMP_29_CALENDER;
	}

	public void setCOMP_29_CALENDER(HtmlCalendar comp_29_calender) {
		COMP_29_CALENDER = comp_29_calender;
	}

	public HtmlCalendar getCOMP_30_CALENDER() {
		return COMP_30_CALENDER;
	}

	public void setCOMP_30_CALENDER(HtmlCalendar comp_30_calender) {
		COMP_30_CALENDER = comp_30_calender;
	}

	public HtmlCalendar getCOMP_31_CALENDER() {
		return COMP_31_CALENDER;
	}

	public void setCOMP_31_CALENDER(HtmlCalendar comp_31_calender) {
		COMP_31_CALENDER = comp_31_calender;
	}

	public HtmlCalendar getCOMP_32_CALENDER() {
		return COMP_32_CALENDER;
	}

	public void setCOMP_32_CALENDER(HtmlCalendar comp_32_calender) {
		COMP_32_CALENDER = comp_32_calender;
	}

	public HtmlCalendar getCOMP_33_CALENDER() {
		return COMP_33_CALENDER;
	}

	public void setCOMP_33_CALENDER(HtmlCalendar comp_33_calender) {
		COMP_33_CALENDER = comp_33_calender;
	}

	public HtmlCalendar getCOMP_34_CALENDER() {
		return COMP_34_CALENDER;
	}

	public void setCOMP_34_CALENDER(HtmlCalendar comp_34_calender) {
		COMP_34_CALENDER = comp_34_calender;
	}

	public HtmlCalendar getCOMP_35_CALENDER() {
		return COMP_35_CALENDER;
	}

	public void setCOMP_35_CALENDER(HtmlCalendar comp_35_calender) {
		COMP_35_CALENDER = comp_35_calender;
	}

	public HtmlCalendar getCOMP_36_CALENDER() {
		return COMP_36_CALENDER;
	}

	public void setCOMP_36_CALENDER(HtmlCalendar comp_36_calender) {
		COMP_36_CALENDER = comp_36_calender;
	}

	public HtmlCalendar getCOMP_37_CALENDER() {
		return COMP_37_CALENDER;
	}

	public void setCOMP_37_CALENDER(HtmlCalendar comp_37_calender) {
		COMP_37_CALENDER = comp_37_calender;
	}

	public HtmlCalendar getCOMP_38_CALENDER() {
		return COMP_38_CALENDER;
	}

	public void setCOMP_38_CALENDER(HtmlCalendar comp_38_calender) {
		COMP_38_CALENDER = comp_38_calender;
	}

	public HtmlCalendar getCOMP_39_CALENDER() {
		return COMP_39_CALENDER;
	}

	public void setCOMP_39_CALENDER(HtmlCalendar comp_39_calender) {
		COMP_39_CALENDER = comp_39_calender;
	}

	public HtmlCalendar getCOMP_40_CALENDER() {
		return COMP_40_CALENDER;
	}

	public void setCOMP_40_CALENDER(HtmlCalendar comp_40_calender) {
		COMP_40_CALENDER = comp_40_calender;
	}

	public HtmlCalendar getCOMP_41_CALENDER() {
		return COMP_41_CALENDER;
	}

	public void setCOMP_41_CALENDER(HtmlCalendar comp_41_calender) {
		COMP_41_CALENDER = comp_41_calender;
	}

	public HtmlCalendar getCOMP_42_CALENDER() {
		return COMP_42_CALENDER;
	}

	public void setCOMP_42_CALENDER(HtmlCalendar comp_42_calender) {
		COMP_42_CALENDER = comp_42_calender;
	}

	public HtmlCalendar getCOMP_43_CALENDER() {
		return COMP_43_CALENDER;
	}

	public void setCOMP_43_CALENDER(HtmlCalendar comp_43_calender) {
		COMP_43_CALENDER = comp_43_calender;
	}

	public HtmlCalendar getCOMP_44_CALENDER() {
		return COMP_44_CALENDER;
	}

	public void setCOMP_44_CALENDER(HtmlCalendar comp_44_calender) {
		COMP_44_CALENDER = comp_44_calender;
	}

	public HtmlCalendar getCOMP_45_CALENDER() {
		return COMP_45_CALENDER;
	}

	public void setCOMP_45_CALENDER(HtmlCalendar comp_45_calender) {
		COMP_45_CALENDER = comp_45_calender;
	}

	public HtmlCalendar getCOMP_46_CALENDER() {
		return COMP_46_CALENDER;
	}

	public void setCOMP_46_CALENDER(HtmlCalendar comp_46_calender) {
		COMP_46_CALENDER = comp_46_calender;
	}

	public HtmlCalendar getCOMP_47_CALENDER() {
		return COMP_47_CALENDER;
	}

	public void setCOMP_47_CALENDER(HtmlCalendar comp_47_calender) {
		COMP_47_CALENDER = comp_47_calender;
	}

	public HtmlCalendar getCOMP_48_CALENDER() {
		return COMP_48_CALENDER;
	}

	public void setCOMP_48_CALENDER(HtmlCalendar comp_48_calender) {
		COMP_48_CALENDER = comp_48_calender;
	}

	public HtmlCalendar getCOMP_49_CALENDER() {
		return COMP_49_CALENDER;
	}

	public void setCOMP_49_CALENDER(HtmlCalendar comp_49_calender) {
		COMP_49_CALENDER = comp_49_calender;
	}

	public HtmlCalendar getCOMP_50_CALENDER() {
		return COMP_50_CALENDER;
	}

	public void setCOMP_50_CALENDER(HtmlCalendar comp_50_calender) {
		COMP_50_CALENDER = comp_50_calender;
	}

	public HtmlCalendar getCOMP_51_CALENDER() {
		return COMP_51_CALENDER;
	}

	public void setCOMP_51_CALENDER(HtmlCalendar comp_51_calender) {
		COMP_51_CALENDER = comp_51_calender;
	}

	public HtmlCalendar getCOMP_52_CALENDER() {
		return COMP_52_CALENDER;
	}

	public void setCOMP_52_CALENDER(HtmlCalendar comp_52_calender) {
		COMP_52_CALENDER = comp_52_calender;
	}

	public HtmlCalendar getCOMP_53_CALENDER() {
		return COMP_53_CALENDER;
	}

	public void setCOMP_53_CALENDER(HtmlCalendar comp_53_calender) {
		COMP_53_CALENDER = comp_53_calender;
	}

	public HtmlCalendar getCOMP_54_CALENDER() {
		return COMP_54_CALENDER;
	}

	public void setCOMP_54_CALENDER(HtmlCalendar comp_54_calender) {
		COMP_54_CALENDER = comp_54_calender;
	}

	public HtmlCalendar getCOMP_55_CALENDER() {
		return COMP_55_CALENDER;
	}

	public void setCOMP_55_CALENDER(HtmlCalendar comp_55_calender) {
		COMP_55_CALENDER = comp_55_calender;
	}

	public HtmlCalendar getCOMP_56_CALENDER() {
		return COMP_56_CALENDER;
	}

	public void setCOMP_56_CALENDER(HtmlCalendar comp_56_calender) {
		COMP_56_CALENDER = comp_56_calender;
	}

	public HtmlCalendar getCOMP_57_CALENDER() {
		return COMP_57_CALENDER;
	}

	public void setCOMP_57_CALENDER(HtmlCalendar comp_57_calender) {
		COMP_57_CALENDER = comp_57_calender;
	}

	public HtmlCalendar getCOMP_58_CALENDER() {
		return COMP_58_CALENDER;
	}

	public void setCOMP_58_CALENDER(HtmlCalendar comp_58_calender) {
		COMP_58_CALENDER = comp_58_calender;
	}

	public HtmlCalendar getCOMP_59_CALENDER() {
		return COMP_59_CALENDER;
	}

	public void setCOMP_59_CALENDER(HtmlCalendar comp_59_calender) {
		COMP_59_CALENDER = comp_59_calender;
	}

	public HtmlCalendar getCOMP_60_CALENDER() {
		return COMP_60_CALENDER;
	}

	public void setCOMP_60_CALENDER(HtmlCalendar comp_60_calender) {
		COMP_60_CALENDER = comp_60_calender;
	}

	public HtmlInputText getCOMP_2_INPUT_TEXT() {
		return COMP_2_INPUT_TEXT;
	}

	public void setCOMP_2_INPUT_TEXT(HtmlInputText comp_2_input_text) {
		COMP_2_INPUT_TEXT = comp_2_input_text;
	}

	public HtmlInputText getCOMP_3_INPUT_TEXT() {
		return COMP_3_INPUT_TEXT;
	}

	public void setCOMP_3_INPUT_TEXT(HtmlInputText comp_3_input_text) {
		COMP_3_INPUT_TEXT = comp_3_input_text;
	}

	public HtmlInputText getCOMP_4_INPUT_TEXT() {
		return COMP_4_INPUT_TEXT;
	}

	public void setCOMP_4_INPUT_TEXT(HtmlInputText comp_4_input_text) {
		COMP_4_INPUT_TEXT = comp_4_input_text;
	}

	public HtmlInputText getCOMP_5_INPUT_TEXT() {
		return COMP_5_INPUT_TEXT;
	}

	public void setCOMP_5_INPUT_TEXT(HtmlInputText comp_5_input_text) {
		COMP_5_INPUT_TEXT = comp_5_input_text;
	}

	public HtmlInputText getCOMP_6_INPUT_TEXT() {
		return COMP_6_INPUT_TEXT;
	}

	public void setCOMP_6_INPUT_TEXT(HtmlInputText comp_6_input_text) {
		COMP_6_INPUT_TEXT = comp_6_input_text;
	}

	public HtmlInputText getCOMP_7_INPUT_TEXT() {
		return COMP_7_INPUT_TEXT;
	}

	public void setCOMP_7_INPUT_TEXT(HtmlInputText comp_7_input_text) {
		COMP_7_INPUT_TEXT = comp_7_input_text;
	}

	public HtmlInputText getCOMP_8_INPUT_TEXT() {
		return COMP_8_INPUT_TEXT;
	}

	public void setCOMP_8_INPUT_TEXT(HtmlInputText comp_8_input_text) {
		COMP_8_INPUT_TEXT = comp_8_input_text;
	}

	public HtmlInputText getCOMP_9_INPUT_TEXT() {
		return COMP_9_INPUT_TEXT;
	}

	public void setCOMP_9_INPUT_TEXT(HtmlInputText comp_9_input_text) {
		COMP_9_INPUT_TEXT = comp_9_input_text;
	}

	public HtmlInputText getCOMP_10_INPUT_TEXT() {
		return COMP_10_INPUT_TEXT;
	}

	public void setCOMP_10_INPUT_TEXT(HtmlInputText comp_10_input_text) {
		COMP_10_INPUT_TEXT = comp_10_input_text;
	}

	public HtmlInputText getCOMP_11_INPUT_TEXT() {
		return COMP_11_INPUT_TEXT;
	}

	public void setCOMP_11_INPUT_TEXT(HtmlInputText comp_11_input_text) {
		COMP_11_INPUT_TEXT = comp_11_input_text;
	}

	public HtmlInputText getCOMP_12_INPUT_TEXT() {
		return COMP_12_INPUT_TEXT;
	}

	public void setCOMP_12_INPUT_TEXT(HtmlInputText comp_12_input_text) {
		COMP_12_INPUT_TEXT = comp_12_input_text;
	}

	public HtmlInputText getCOMP_13_INPUT_TEXT() {
		return COMP_13_INPUT_TEXT;
	}

	public void setCOMP_13_INPUT_TEXT(HtmlInputText comp_13_input_text) {
		COMP_13_INPUT_TEXT = comp_13_input_text;
	}

	public HtmlInputText getCOMP_14_INPUT_TEXT() {
		return COMP_14_INPUT_TEXT;
	}

	public void setCOMP_14_INPUT_TEXT(HtmlInputText comp_14_input_text) {
		COMP_14_INPUT_TEXT = comp_14_input_text;
	}

	public HtmlInputText getCOMP_15_INPUT_TEXT() {
		return COMP_15_INPUT_TEXT;
	}

	public void setCOMP_15_INPUT_TEXT(HtmlInputText comp_15_input_text) {
		COMP_15_INPUT_TEXT = comp_15_input_text;
	}

	public HtmlInputText getCOMP_16_INPUT_TEXT() {
		return COMP_16_INPUT_TEXT;
	}

	public void setCOMP_16_INPUT_TEXT(HtmlInputText comp_16_input_text) {
		COMP_16_INPUT_TEXT = comp_16_input_text;
	}

	public HtmlInputText getCOMP_17_INPUT_TEXT() {
		return COMP_17_INPUT_TEXT;
	}

	public void setCOMP_17_INPUT_TEXT(HtmlInputText comp_17_input_text) {
		COMP_17_INPUT_TEXT = comp_17_input_text;
	}

	public HtmlInputText getCOMP_18_INPUT_TEXT() {
		return COMP_18_INPUT_TEXT;
	}

	public void setCOMP_18_INPUT_TEXT(HtmlInputText comp_18_input_text) {
		COMP_18_INPUT_TEXT = comp_18_input_text;
	}

	public HtmlInputText getCOMP_19_INPUT_TEXT() {
		return COMP_19_INPUT_TEXT;
	}

	public void setCOMP_19_INPUT_TEXT(HtmlInputText comp_19_input_text) {
		COMP_19_INPUT_TEXT = comp_19_input_text;
	}

	public HtmlInputText getCOMP_20_INPUT_TEXT() {
		return COMP_20_INPUT_TEXT;
	}

	public void setCOMP_20_INPUT_TEXT(HtmlInputText comp_20_input_text) {
		COMP_20_INPUT_TEXT = comp_20_input_text;
	}

	public HtmlInputText getCOMP_21_INPUT_TEXT() {
		return COMP_21_INPUT_TEXT;
	}

	public void setCOMP_21_INPUT_TEXT(HtmlInputText comp_21_input_text) {
		COMP_21_INPUT_TEXT = comp_21_input_text;
	}

	public HtmlInputText getCOMP_22_INPUT_TEXT() {
		return COMP_22_INPUT_TEXT;
	}

	public void setCOMP_22_INPUT_TEXT(HtmlInputText comp_22_input_text) {
		COMP_22_INPUT_TEXT = comp_22_input_text;
	}

	public HtmlInputText getCOMP_23_INPUT_TEXT() {
		return COMP_23_INPUT_TEXT;
	}

	public void setCOMP_23_INPUT_TEXT(HtmlInputText comp_23_input_text) {
		COMP_23_INPUT_TEXT = comp_23_input_text;
	}

	public HtmlInputText getCOMP_24_INPUT_TEXT() {
		return COMP_24_INPUT_TEXT;
	}

	public void setCOMP_24_INPUT_TEXT(HtmlInputText comp_24_input_text) {
		COMP_24_INPUT_TEXT = comp_24_input_text;
	}

	public HtmlInputText getCOMP_25_INPUT_TEXT() {
		return COMP_25_INPUT_TEXT;
	}

	public void setCOMP_25_INPUT_TEXT(HtmlInputText comp_25_input_text) {
		COMP_25_INPUT_TEXT = comp_25_input_text;
	}

	public HtmlInputText getCOMP_26_INPUT_TEXT() {
		return COMP_26_INPUT_TEXT;
	}

	public void setCOMP_26_INPUT_TEXT(HtmlInputText comp_26_input_text) {
		COMP_26_INPUT_TEXT = comp_26_input_text;
	}

	public HtmlInputText getCOMP_27_INPUT_TEXT() {
		return COMP_27_INPUT_TEXT;
	}

	public void setCOMP_27_INPUT_TEXT(HtmlInputText comp_27_input_text) {
		COMP_27_INPUT_TEXT = comp_27_input_text;
	}

	public HtmlInputText getCOMP_28_INPUT_TEXT() {
		return COMP_28_INPUT_TEXT;
	}

	public void setCOMP_28_INPUT_TEXT(HtmlInputText comp_28_input_text) {
		COMP_28_INPUT_TEXT = comp_28_input_text;
	}

	public HtmlInputText getCOMP_29_INPUT_TEXT() {
		return COMP_29_INPUT_TEXT;
	}

	public void setCOMP_29_INPUT_TEXT(HtmlInputText comp_29_input_text) {
		COMP_29_INPUT_TEXT = comp_29_input_text;
	}

	public HtmlInputText getCOMP_30_INPUT_TEXT() {
		return COMP_30_INPUT_TEXT;
	}

	public void setCOMP_30_INPUT_TEXT(HtmlInputText comp_30_input_text) {
		COMP_30_INPUT_TEXT = comp_30_input_text;
	}

	public HtmlInputText getCOMP_31_INPUT_TEXT() {
		return COMP_31_INPUT_TEXT;
	}

	public void setCOMP_31_INPUT_TEXT(HtmlInputText comp_31_input_text) {
		COMP_31_INPUT_TEXT = comp_31_input_text;
	}

	public HtmlInputText getCOMP_32_INPUT_TEXT() {
		return COMP_32_INPUT_TEXT;
	}

	public void setCOMP_32_INPUT_TEXT(HtmlInputText comp_32_input_text) {
		COMP_32_INPUT_TEXT = comp_32_input_text;
	}

	public HtmlInputText getCOMP_33_INPUT_TEXT() {
		return COMP_33_INPUT_TEXT;
	}

	public void setCOMP_33_INPUT_TEXT(HtmlInputText comp_33_input_text) {
		COMP_33_INPUT_TEXT = comp_33_input_text;
	}

	public HtmlInputText getCOMP_34_INPUT_TEXT() {
		return COMP_34_INPUT_TEXT;
	}

	public void setCOMP_34_INPUT_TEXT(HtmlInputText comp_34_input_text) {
		COMP_34_INPUT_TEXT = comp_34_input_text;
	}

	public HtmlInputText getCOMP_35_INPUT_TEXT() {
		return COMP_35_INPUT_TEXT;
	}

	public void setCOMP_35_INPUT_TEXT(HtmlInputText comp_35_input_text) {
		COMP_35_INPUT_TEXT = comp_35_input_text;
	}

	public HtmlInputText getCOMP_36_INPUT_TEXT() {
		return COMP_36_INPUT_TEXT;
	}

	public void setCOMP_36_INPUT_TEXT(HtmlInputText comp_36_input_text) {
		COMP_36_INPUT_TEXT = comp_36_input_text;
	}

	public HtmlInputText getCOMP_37_INPUT_TEXT() {
		return COMP_37_INPUT_TEXT;
	}

	public void setCOMP_37_INPUT_TEXT(HtmlInputText comp_37_input_text) {
		COMP_37_INPUT_TEXT = comp_37_input_text;
	}

	public HtmlInputText getCOMP_38_INPUT_TEXT() {
		return COMP_38_INPUT_TEXT;
	}

	public void setCOMP_38_INPUT_TEXT(HtmlInputText comp_38_input_text) {
		COMP_38_INPUT_TEXT = comp_38_input_text;
	}

	public HtmlInputText getCOMP_39_INPUT_TEXT() {
		return COMP_39_INPUT_TEXT;
	}

	public void setCOMP_39_INPUT_TEXT(HtmlInputText comp_39_input_text) {
		COMP_39_INPUT_TEXT = comp_39_input_text;
	}

	public HtmlInputText getCOMP_40_INPUT_TEXT() {
		return COMP_40_INPUT_TEXT;
	}

	public void setCOMP_40_INPUT_TEXT(HtmlInputText comp_40_input_text) {
		COMP_40_INPUT_TEXT = comp_40_input_text;
	}

	public HtmlInputText getCOMP_41_INPUT_TEXT() {
		return COMP_41_INPUT_TEXT;
	}

	public void setCOMP_41_INPUT_TEXT(HtmlInputText comp_41_input_text) {
		COMP_41_INPUT_TEXT = comp_41_input_text;
	}

	public HtmlInputText getCOMP_42_INPUT_TEXT() {
		return COMP_42_INPUT_TEXT;
	}

	public void setCOMP_42_INPUT_TEXT(HtmlInputText comp_42_input_text) {
		COMP_42_INPUT_TEXT = comp_42_input_text;
	}

	public HtmlInputText getCOMP_43_INPUT_TEXT() {
		return COMP_43_INPUT_TEXT;
	}

	public void setCOMP_43_INPUT_TEXT(HtmlInputText comp_43_input_text) {
		COMP_43_INPUT_TEXT = comp_43_input_text;
	}

	public HtmlInputText getCOMP_44_INPUT_TEXT() {
		return COMP_44_INPUT_TEXT;
	}

	public void setCOMP_44_INPUT_TEXT(HtmlInputText comp_44_input_text) {
		COMP_44_INPUT_TEXT = comp_44_input_text;
	}

	public HtmlInputText getCOMP_45_INPUT_TEXT() {
		return COMP_45_INPUT_TEXT;
	}

	public void setCOMP_45_INPUT_TEXT(HtmlInputText comp_45_input_text) {
		COMP_45_INPUT_TEXT = comp_45_input_text;
	}

	public HtmlInputText getCOMP_46_INPUT_TEXT() {
		return COMP_46_INPUT_TEXT;
	}

	public void setCOMP_46_INPUT_TEXT(HtmlInputText comp_46_input_text) {
		COMP_46_INPUT_TEXT = comp_46_input_text;
	}

	public HtmlInputText getCOMP_47_INPUT_TEXT() {
		return COMP_47_INPUT_TEXT;
	}

	public void setCOMP_47_INPUT_TEXT(HtmlInputText comp_47_input_text) {
		COMP_47_INPUT_TEXT = comp_47_input_text;
	}

	public HtmlInputText getCOMP_48_INPUT_TEXT() {
		return COMP_48_INPUT_TEXT;
	}

	public void setCOMP_48_INPUT_TEXT(HtmlInputText comp_48_input_text) {
		COMP_48_INPUT_TEXT = comp_48_input_text;
	}

	public HtmlInputText getCOMP_49_INPUT_TEXT() {
		return COMP_49_INPUT_TEXT;
	}

	public void setCOMP_49_INPUT_TEXT(HtmlInputText comp_49_input_text) {
		COMP_49_INPUT_TEXT = comp_49_input_text;
	}

	public HtmlInputText getCOMP_50_INPUT_TEXT() {
		return COMP_50_INPUT_TEXT;
	}

	public void setCOMP_50_INPUT_TEXT(HtmlInputText comp_50_input_text) {
		COMP_50_INPUT_TEXT = comp_50_input_text;
	}

	public HtmlInputText getCOMP_51_INPUT_TEXT() {
		return COMP_51_INPUT_TEXT;
	}

	public void setCOMP_51_INPUT_TEXT(HtmlInputText comp_51_input_text) {
		COMP_51_INPUT_TEXT = comp_51_input_text;
	}

	public HtmlInputText getCOMP_52_INPUT_TEXT() {
		return COMP_52_INPUT_TEXT;
	}

	public void setCOMP_52_INPUT_TEXT(HtmlInputText comp_52_input_text) {
		COMP_52_INPUT_TEXT = comp_52_input_text;
	}

	public HtmlInputText getCOMP_53_INPUT_TEXT() {
		return COMP_53_INPUT_TEXT;
	}

	public void setCOMP_53_INPUT_TEXT(HtmlInputText comp_53_input_text) {
		COMP_53_INPUT_TEXT = comp_53_input_text;
	}

	public HtmlInputText getCOMP_54_INPUT_TEXT() {
		return COMP_54_INPUT_TEXT;
	}

	public void setCOMP_54_INPUT_TEXT(HtmlInputText comp_54_input_text) {
		COMP_54_INPUT_TEXT = comp_54_input_text;
	}

	public HtmlInputText getCOMP_55_INPUT_TEXT() {
		return COMP_55_INPUT_TEXT;
	}

	public void setCOMP_55_INPUT_TEXT(HtmlInputText comp_55_input_text) {
		COMP_55_INPUT_TEXT = comp_55_input_text;
	}

	public HtmlInputText getCOMP_56_INPUT_TEXT() {
		return COMP_56_INPUT_TEXT;
	}

	public void setCOMP_56_INPUT_TEXT(HtmlInputText comp_56_input_text) {
		COMP_56_INPUT_TEXT = comp_56_input_text;
	}

	public HtmlInputText getCOMP_57_INPUT_TEXT() {
		return COMP_57_INPUT_TEXT;
	}

	public void setCOMP_57_INPUT_TEXT(HtmlInputText comp_57_input_text) {
		COMP_57_INPUT_TEXT = comp_57_input_text;
	}

	public HtmlInputText getCOMP_58_INPUT_TEXT() {
		return COMP_58_INPUT_TEXT;
	}

	public void setCOMP_58_INPUT_TEXT(HtmlInputText comp_58_input_text) {
		COMP_58_INPUT_TEXT = comp_58_input_text;
	}

	public HtmlInputText getCOMP_59_INPUT_TEXT() {
		return COMP_59_INPUT_TEXT;
	}

	public void setCOMP_59_INPUT_TEXT(HtmlInputText comp_59_input_text) {
		COMP_59_INPUT_TEXT = comp_59_input_text;
	}

	public HtmlInputText getCOMP_60_INPUT_TEXT() {
		return COMP_60_INPUT_TEXT;
	}

	public void setCOMP_60_INPUT_TEXT(HtmlInputText comp_60_input_text) {
		COMP_60_INPUT_TEXT = comp_60_input_text;
	}

	public HtmlSelectOneMenu getCOMP_2_SELECT_ONE_MENU() {
		return COMP_2_SELECT_ONE_MENU;
	}

	public void setCOMP_2_SELECT_ONE_MENU(HtmlSelectOneMenu comp_2_select_one_menu) {
		COMP_2_SELECT_ONE_MENU = comp_2_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_3_SELECT_ONE_MENU() {
		return COMP_3_SELECT_ONE_MENU;
	}

	public void setCOMP_3_SELECT_ONE_MENU(HtmlSelectOneMenu comp_3_select_one_menu) {
		COMP_3_SELECT_ONE_MENU = comp_3_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_4_SELECT_ONE_MENU() {
		return COMP_4_SELECT_ONE_MENU;
	}

	public void setCOMP_4_SELECT_ONE_MENU(HtmlSelectOneMenu comp_4_select_one_menu) {
		COMP_4_SELECT_ONE_MENU = comp_4_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_5_SELECT_ONE_MENU() {
		return COMP_5_SELECT_ONE_MENU;
	}

	public void setCOMP_5_SELECT_ONE_MENU(HtmlSelectOneMenu comp_5_select_one_menu) {
		COMP_5_SELECT_ONE_MENU = comp_5_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_6_SELECT_ONE_MENU() {
		return COMP_6_SELECT_ONE_MENU;
	}

	public void setCOMP_6_SELECT_ONE_MENU(HtmlSelectOneMenu comp_6_select_one_menu) {
		COMP_6_SELECT_ONE_MENU = comp_6_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_7_SELECT_ONE_MENU() {
		return COMP_7_SELECT_ONE_MENU;
	}

	public void setCOMP_7_SELECT_ONE_MENU(HtmlSelectOneMenu comp_7_select_one_menu) {
		COMP_7_SELECT_ONE_MENU = comp_7_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_8_SELECT_ONE_MENU() {
		return COMP_8_SELECT_ONE_MENU;
	}

	public void setCOMP_8_SELECT_ONE_MENU(HtmlSelectOneMenu comp_8_select_one_menu) {
		COMP_8_SELECT_ONE_MENU = comp_8_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_9_SELECT_ONE_MENU() {
		return COMP_9_SELECT_ONE_MENU;
	}

	public void setCOMP_9_SELECT_ONE_MENU(HtmlSelectOneMenu comp_9_select_one_menu) {
		COMP_9_SELECT_ONE_MENU = comp_9_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_10_SELECT_ONE_MENU() {
		return COMP_10_SELECT_ONE_MENU;
	}

	public void setCOMP_10_SELECT_ONE_MENU(HtmlSelectOneMenu comp_10_select_one_menu) {
		COMP_10_SELECT_ONE_MENU = comp_10_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_11_SELECT_ONE_MENU() {
		return COMP_11_SELECT_ONE_MENU;
	}

	public void setCOMP_11_SELECT_ONE_MENU(HtmlSelectOneMenu comp_11_select_one_menu) {
		COMP_11_SELECT_ONE_MENU = comp_11_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_12_SELECT_ONE_MENU() {
		return COMP_12_SELECT_ONE_MENU;
	}

	public void setCOMP_12_SELECT_ONE_MENU(HtmlSelectOneMenu comp_12_select_one_menu) {
		COMP_12_SELECT_ONE_MENU = comp_12_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_13_SELECT_ONE_MENU() {
		return COMP_13_SELECT_ONE_MENU;
	}

	public void setCOMP_13_SELECT_ONE_MENU(HtmlSelectOneMenu comp_13_select_one_menu) {
		COMP_13_SELECT_ONE_MENU = comp_13_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_14_SELECT_ONE_MENU() {
		return COMP_14_SELECT_ONE_MENU;
	}

	public void setCOMP_14_SELECT_ONE_MENU(HtmlSelectOneMenu comp_14_select_one_menu) {
		COMP_14_SELECT_ONE_MENU = comp_14_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_15_SELECT_ONE_MENU() {
		return COMP_15_SELECT_ONE_MENU;
	}

	public void setCOMP_15_SELECT_ONE_MENU(HtmlSelectOneMenu comp_15_select_one_menu) {
		COMP_15_SELECT_ONE_MENU = comp_15_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_16_SELECT_ONE_MENU() {
		return COMP_16_SELECT_ONE_MENU;
	}

	public void setCOMP_16_SELECT_ONE_MENU(HtmlSelectOneMenu comp_16_select_one_menu) {
		COMP_16_SELECT_ONE_MENU = comp_16_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_17_SELECT_ONE_MENU() {
		return COMP_17_SELECT_ONE_MENU;
	}

	public void setCOMP_17_SELECT_ONE_MENU(HtmlSelectOneMenu comp_17_select_one_menu) {
		COMP_17_SELECT_ONE_MENU = comp_17_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_18_SELECT_ONE_MENU() {
		return COMP_18_SELECT_ONE_MENU;
	}

	public void setCOMP_18_SELECT_ONE_MENU(HtmlSelectOneMenu comp_18_select_one_menu) {
		COMP_18_SELECT_ONE_MENU = comp_18_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_19_SELECT_ONE_MENU() {
		return COMP_19_SELECT_ONE_MENU;
	}

	public void setCOMP_19_SELECT_ONE_MENU(HtmlSelectOneMenu comp_19_select_one_menu) {
		COMP_19_SELECT_ONE_MENU = comp_19_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_20_SELECT_ONE_MENU() {
		return COMP_20_SELECT_ONE_MENU;
	}

	public void setCOMP_20_SELECT_ONE_MENU(HtmlSelectOneMenu comp_20_select_one_menu) {
		COMP_20_SELECT_ONE_MENU = comp_20_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_21_SELECT_ONE_MENU() {
		return COMP_21_SELECT_ONE_MENU;
	}

	public void setCOMP_21_SELECT_ONE_MENU(HtmlSelectOneMenu comp_21_select_one_menu) {
		COMP_21_SELECT_ONE_MENU = comp_21_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_22_SELECT_ONE_MENU() {
		return COMP_22_SELECT_ONE_MENU;
	}

	public void setCOMP_22_SELECT_ONE_MENU(HtmlSelectOneMenu comp_22_select_one_menu) {
		COMP_22_SELECT_ONE_MENU = comp_22_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_23_SELECT_ONE_MENU() {
		return COMP_23_SELECT_ONE_MENU;
	}

	public void setCOMP_23_SELECT_ONE_MENU(HtmlSelectOneMenu comp_23_select_one_menu) {
		COMP_23_SELECT_ONE_MENU = comp_23_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_24_SELECT_ONE_MENU() {
		return COMP_24_SELECT_ONE_MENU;
	}

	public void setCOMP_24_SELECT_ONE_MENU(HtmlSelectOneMenu comp_24_select_one_menu) {
		COMP_24_SELECT_ONE_MENU = comp_24_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_25_SELECT_ONE_MENU() {
		return COMP_25_SELECT_ONE_MENU;
	}

	public void setCOMP_25_SELECT_ONE_MENU(HtmlSelectOneMenu comp_25_select_one_menu) {
		COMP_25_SELECT_ONE_MENU = comp_25_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_26_SELECT_ONE_MENU() {
		return COMP_26_SELECT_ONE_MENU;
	}

	public void setCOMP_26_SELECT_ONE_MENU(HtmlSelectOneMenu comp_26_select_one_menu) {
		COMP_26_SELECT_ONE_MENU = comp_26_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_27_SELECT_ONE_MENU() {
		return COMP_27_SELECT_ONE_MENU;
	}

	public void setCOMP_27_SELECT_ONE_MENU(HtmlSelectOneMenu comp_27_select_one_menu) {
		COMP_27_SELECT_ONE_MENU = comp_27_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_28_SELECT_ONE_MENU() {
		return COMP_28_SELECT_ONE_MENU;
	}

	public void setCOMP_28_SELECT_ONE_MENU(HtmlSelectOneMenu comp_28_select_one_menu) {
		COMP_28_SELECT_ONE_MENU = comp_28_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_29_SELECT_ONE_MENU() {
		return COMP_29_SELECT_ONE_MENU;
	}

	public void setCOMP_29_SELECT_ONE_MENU(HtmlSelectOneMenu comp_29_select_one_menu) {
		COMP_29_SELECT_ONE_MENU = comp_29_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_30_SELECT_ONE_MENU() {
		return COMP_30_SELECT_ONE_MENU;
	}

	public void setCOMP_30_SELECT_ONE_MENU(HtmlSelectOneMenu comp_30_select_one_menu) {
		COMP_30_SELECT_ONE_MENU = comp_30_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_31_SELECT_ONE_MENU() {
		return COMP_31_SELECT_ONE_MENU;
	}

	public void setCOMP_31_SELECT_ONE_MENU(HtmlSelectOneMenu comp_31_select_one_menu) {
		COMP_31_SELECT_ONE_MENU = comp_31_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_32_SELECT_ONE_MENU() {
		return COMP_32_SELECT_ONE_MENU;
	}

	public void setCOMP_32_SELECT_ONE_MENU(HtmlSelectOneMenu comp_32_select_one_menu) {
		COMP_32_SELECT_ONE_MENU = comp_32_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_33_SELECT_ONE_MENU() {
		return COMP_33_SELECT_ONE_MENU;
	}

	public void setCOMP_33_SELECT_ONE_MENU(HtmlSelectOneMenu comp_33_select_one_menu) {
		COMP_33_SELECT_ONE_MENU = comp_33_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_34_SELECT_ONE_MENU() {
		return COMP_34_SELECT_ONE_MENU;
	}

	public void setCOMP_34_SELECT_ONE_MENU(HtmlSelectOneMenu comp_34_select_one_menu) {
		COMP_34_SELECT_ONE_MENU = comp_34_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_35_SELECT_ONE_MENU() {
		return COMP_35_SELECT_ONE_MENU;
	}

	public void setCOMP_35_SELECT_ONE_MENU(HtmlSelectOneMenu comp_35_select_one_menu) {
		COMP_35_SELECT_ONE_MENU = comp_35_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_36_SELECT_ONE_MENU() {
		return COMP_36_SELECT_ONE_MENU;
	}

	public void setCOMP_36_SELECT_ONE_MENU(HtmlSelectOneMenu comp_36_select_one_menu) {
		COMP_36_SELECT_ONE_MENU = comp_36_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_37_SELECT_ONE_MENU() {
		return COMP_37_SELECT_ONE_MENU;
	}

	public void setCOMP_37_SELECT_ONE_MENU(HtmlSelectOneMenu comp_37_select_one_menu) {
		COMP_37_SELECT_ONE_MENU = comp_37_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_38_SELECT_ONE_MENU() {
		return COMP_38_SELECT_ONE_MENU;
	}

	public void setCOMP_38_SELECT_ONE_MENU(HtmlSelectOneMenu comp_38_select_one_menu) {
		COMP_38_SELECT_ONE_MENU = comp_38_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_39_SELECT_ONE_MENU() {
		return COMP_39_SELECT_ONE_MENU;
	}

	public void setCOMP_39_SELECT_ONE_MENU(HtmlSelectOneMenu comp_39_select_one_menu) {
		COMP_39_SELECT_ONE_MENU = comp_39_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_40_SELECT_ONE_MENU() {
		return COMP_40_SELECT_ONE_MENU;
	}

	public void setCOMP_40_SELECT_ONE_MENU(HtmlSelectOneMenu comp_40_select_one_menu) {
		COMP_40_SELECT_ONE_MENU = comp_40_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_41_SELECT_ONE_MENU() {
		return COMP_41_SELECT_ONE_MENU;
	}

	public void setCOMP_41_SELECT_ONE_MENU(HtmlSelectOneMenu comp_41_select_one_menu) {
		COMP_41_SELECT_ONE_MENU = comp_41_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_42_SELECT_ONE_MENU() {
		return COMP_42_SELECT_ONE_MENU;
	}

	public void setCOMP_42_SELECT_ONE_MENU(HtmlSelectOneMenu comp_42_select_one_menu) {
		COMP_42_SELECT_ONE_MENU = comp_42_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_43_SELECT_ONE_MENU() {
		return COMP_43_SELECT_ONE_MENU;
	}

	public void setCOMP_43_SELECT_ONE_MENU(HtmlSelectOneMenu comp_43_select_one_menu) {
		COMP_43_SELECT_ONE_MENU = comp_43_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_44_SELECT_ONE_MENU() {
		return COMP_44_SELECT_ONE_MENU;
	}

	public void setCOMP_44_SELECT_ONE_MENU(HtmlSelectOneMenu comp_44_select_one_menu) {
		COMP_44_SELECT_ONE_MENU = comp_44_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_45_SELECT_ONE_MENU() {
		return COMP_45_SELECT_ONE_MENU;
	}

	public void setCOMP_45_SELECT_ONE_MENU(HtmlSelectOneMenu comp_45_select_one_menu) {
		COMP_45_SELECT_ONE_MENU = comp_45_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_46_SELECT_ONE_MENU() {
		return COMP_46_SELECT_ONE_MENU;
	}

	public void setCOMP_46_SELECT_ONE_MENU(HtmlSelectOneMenu comp_46_select_one_menu) {
		COMP_46_SELECT_ONE_MENU = comp_46_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_47_SELECT_ONE_MENU() {
		return COMP_47_SELECT_ONE_MENU;
	}

	public void setCOMP_47_SELECT_ONE_MENU(HtmlSelectOneMenu comp_47_select_one_menu) {
		COMP_47_SELECT_ONE_MENU = comp_47_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_48_SELECT_ONE_MENU() {
		return COMP_48_SELECT_ONE_MENU;
	}

	public void setCOMP_48_SELECT_ONE_MENU(HtmlSelectOneMenu comp_48_select_one_menu) {
		COMP_48_SELECT_ONE_MENU = comp_48_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_49_SELECT_ONE_MENU() {
		return COMP_49_SELECT_ONE_MENU;
	}

	public void setCOMP_49_SELECT_ONE_MENU(HtmlSelectOneMenu comp_49_select_one_menu) {
		COMP_49_SELECT_ONE_MENU = comp_49_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_50_SELECT_ONE_MENU() {
		return COMP_50_SELECT_ONE_MENU;
	}

	public void setCOMP_50_SELECT_ONE_MENU(HtmlSelectOneMenu comp_50_select_one_menu) {
		COMP_50_SELECT_ONE_MENU = comp_50_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_51_SELECT_ONE_MENU() {
		return COMP_51_SELECT_ONE_MENU;
	}

	public void setCOMP_51_SELECT_ONE_MENU(HtmlSelectOneMenu comp_51_select_one_menu) {
		COMP_51_SELECT_ONE_MENU = comp_51_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_52_SELECT_ONE_MENU() {
		return COMP_52_SELECT_ONE_MENU;
	}

	public void setCOMP_52_SELECT_ONE_MENU(HtmlSelectOneMenu comp_52_select_one_menu) {
		COMP_52_SELECT_ONE_MENU = comp_52_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_53_SELECT_ONE_MENU() {
		return COMP_53_SELECT_ONE_MENU;
	}

	public void setCOMP_53_SELECT_ONE_MENU(HtmlSelectOneMenu comp_53_select_one_menu) {
		COMP_53_SELECT_ONE_MENU = comp_53_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_54_SELECT_ONE_MENU() {
		return COMP_54_SELECT_ONE_MENU;
	}

	public void setCOMP_54_SELECT_ONE_MENU(HtmlSelectOneMenu comp_54_select_one_menu) {
		COMP_54_SELECT_ONE_MENU = comp_54_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_55_SELECT_ONE_MENU() {
		return COMP_55_SELECT_ONE_MENU;
	}

	public void setCOMP_55_SELECT_ONE_MENU(HtmlSelectOneMenu comp_55_select_one_menu) {
		COMP_55_SELECT_ONE_MENU = comp_55_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_56_SELECT_ONE_MENU() {
		return COMP_56_SELECT_ONE_MENU;
	}

	public void setCOMP_56_SELECT_ONE_MENU(HtmlSelectOneMenu comp_56_select_one_menu) {
		COMP_56_SELECT_ONE_MENU = comp_56_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_57_SELECT_ONE_MENU() {
		return COMP_57_SELECT_ONE_MENU;
	}

	public void setCOMP_57_SELECT_ONE_MENU(HtmlSelectOneMenu comp_57_select_one_menu) {
		COMP_57_SELECT_ONE_MENU = comp_57_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_58_SELECT_ONE_MENU() {
		return COMP_58_SELECT_ONE_MENU;
	}

	public void setCOMP_58_SELECT_ONE_MENU(HtmlSelectOneMenu comp_58_select_one_menu) {
		COMP_58_SELECT_ONE_MENU = comp_58_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_59_SELECT_ONE_MENU() {
		return COMP_59_SELECT_ONE_MENU;
	}

	public void setCOMP_59_SELECT_ONE_MENU(HtmlSelectOneMenu comp_59_select_one_menu) {
		COMP_59_SELECT_ONE_MENU = comp_59_select_one_menu;
	}

	public HtmlSelectOneMenu getCOMP_60_SELECT_ONE_MENU() {
		return COMP_60_SELECT_ONE_MENU;
	}

	public void setCOMP_60_SELECT_ONE_MENU(HtmlSelectOneMenu comp_60_select_one_menu) {
		COMP_60_SELECT_ONE_MENU = comp_60_select_one_menu;
	}

	
	public boolean isCOMP_1_PANEL() {
		return COMP_1_PANEL;
	}

	public void setCOMP_1_PANEL(boolean comp_1_panel) {
		COMP_1_PANEL = comp_1_panel;
	}

	public boolean isCOMP_2_PANEL() {
		return COMP_2_PANEL;
	}

	public void setCOMP_2_PANEL(boolean comp_2_panel) {
		COMP_2_PANEL = comp_2_panel;
	}

	public boolean isCOMP_3_PANEL() {
		return COMP_3_PANEL;
	}

	public void setCOMP_3_PANEL(boolean comp_3_panel) {
		COMP_3_PANEL = comp_3_panel;
	}

	public boolean isCOMP_4_PANEL() {
		return COMP_4_PANEL;
	}

	public void setCOMP_4_PANEL(boolean comp_4_panel) {
		COMP_4_PANEL = comp_4_panel;
	}

	public boolean isCOMP_5_PANEL() {
		return COMP_5_PANEL;
	}

	public void setCOMP_5_PANEL(boolean comp_5_panel) {
		COMP_5_PANEL = comp_5_panel;
	}

	public boolean isCOMP_6_PANEL() {
		return COMP_6_PANEL;
	}

	public void setCOMP_6_PANEL(boolean comp_6_panel) {
		COMP_6_PANEL = comp_6_panel;
	}

	public boolean isCOMP_7_PANEL() {
		return COMP_7_PANEL;
	}

	public void setCOMP_7_PANEL(boolean comp_7_panel) {
		COMP_7_PANEL = comp_7_panel;
	}

	public boolean isCOMP_8_PANEL() {
		return COMP_8_PANEL;
	}

	public void setCOMP_8_PANEL(boolean comp_8_panel) {
		COMP_8_PANEL = comp_8_panel;
	}

	public boolean isCOMP_9_PANEL() {
		return COMP_9_PANEL;
	}

	public void setCOMP_9_PANEL(boolean comp_9_panel) {
		COMP_9_PANEL = comp_9_panel;
	}

	public boolean isCOMP_10_PANEL() {
		return COMP_10_PANEL;
	}

	public void setCOMP_10_PANEL(boolean comp_10_panel) {
		COMP_10_PANEL = comp_10_panel;
	}

	public boolean isCOMP_11_PANEL() {
		return COMP_11_PANEL;
	}

	public void setCOMP_11_PANEL(boolean comp_11_panel) {
		COMP_11_PANEL = comp_11_panel;
	}

	public boolean isCOMP_12_PANEL() {
		return COMP_12_PANEL;
	}

	public void setCOMP_12_PANEL(boolean comp_12_panel) {
		COMP_12_PANEL = comp_12_panel;
	}

	public boolean isCOMP_13_PANEL() {
		return COMP_13_PANEL;
	}

	public void setCOMP_13_PANEL(boolean comp_13_panel) {
		COMP_13_PANEL = comp_13_panel;
	}

	public boolean isCOMP_14_PANEL() {
		return COMP_14_PANEL;
	}

	public void setCOMP_14_PANEL(boolean comp_14_panel) {
		COMP_14_PANEL = comp_14_panel;
	}

	public boolean isCOMP_15_PANEL() {
		return COMP_15_PANEL;
	}

	public void setCOMP_15_PANEL(boolean comp_15_panel) {
		COMP_15_PANEL = comp_15_panel;
	}

	public boolean isCOMP_16_PANEL() {
		return COMP_16_PANEL;
	}

	public void setCOMP_16_PANEL(boolean comp_16_panel) {
		COMP_16_PANEL = comp_16_panel;
	}

	public boolean isCOMP_17_PANEL() {
		return COMP_17_PANEL;
	}

	public void setCOMP_17_PANEL(boolean comp_17_panel) {
		COMP_17_PANEL = comp_17_panel;
	}

	public boolean isCOMP_18_PANEL() {
		return COMP_18_PANEL;
	}

	public void setCOMP_18_PANEL(boolean comp_18_panel) {
		COMP_18_PANEL = comp_18_panel;
	}

	public boolean isCOMP_19_PANEL() {
		return COMP_19_PANEL;
	}

	public void setCOMP_19_PANEL(boolean comp_19_panel) {
		COMP_19_PANEL = comp_19_panel;
	}

	public boolean isCOMP_20_PANEL() {
		return COMP_20_PANEL;
	}

	public void setCOMP_20_PANEL(boolean comp_20_panel) {
		COMP_20_PANEL = comp_20_panel;
	}

	public boolean isCOMP_21_PANEL() {
		return COMP_21_PANEL;
	}

	public void setCOMP_21_PANEL(boolean comp_21_panel) {
		COMP_21_PANEL = comp_21_panel;
	}

	public boolean isCOMP_22_PANEL() {
		return COMP_22_PANEL;
	}

	public void setCOMP_22_PANEL(boolean comp_22_panel) {
		COMP_22_PANEL = comp_22_panel;
	}

	public boolean isCOMP_23_PANEL() {
		return COMP_23_PANEL;
	}

	public void setCOMP_23_PANEL(boolean comp_23_panel) {
		COMP_23_PANEL = comp_23_panel;
	}

	public boolean isCOMP_24_PANEL() {
		return COMP_24_PANEL;
	}

	public void setCOMP_24_PANEL(boolean comp_24_panel) {
		COMP_24_PANEL = comp_24_panel;
	}

	public boolean isCOMP_25_PANEL() {
		return COMP_25_PANEL;
	}

	public void setCOMP_25_PANEL(boolean comp_25_panel) {
		COMP_25_PANEL = comp_25_panel;
	}

	public boolean isCOMP_26_PANEL() {
		return COMP_26_PANEL;
	}

	public void setCOMP_26_PANEL(boolean comp_26_panel) {
		COMP_26_PANEL = comp_26_panel;
	}

	public boolean isCOMP_27_PANEL() {
		return COMP_27_PANEL;
	}

	public void setCOMP_27_PANEL(boolean comp_27_panel) {
		COMP_27_PANEL = comp_27_panel;
	}

	public boolean isCOMP_28_PANEL() {
		return COMP_28_PANEL;
	}

	public void setCOMP_28_PANEL(boolean comp_28_panel) {
		COMP_28_PANEL = comp_28_panel;
	}

	public boolean isCOMP_29_PANEL() {
		return COMP_29_PANEL;
	}

	public void setCOMP_29_PANEL(boolean comp_29_panel) {
		COMP_29_PANEL = comp_29_panel;
	}

	public boolean isCOMP_30_PANEL() {
		return COMP_30_PANEL;
	}

	public void setCOMP_30_PANEL(boolean comp_30_panel) {
		COMP_30_PANEL = comp_30_panel;
	}

	public boolean isCOMP_31_PANEL() {
		return COMP_31_PANEL;
	}

	public void setCOMP_31_PANEL(boolean comp_31_panel) {
		COMP_31_PANEL = comp_31_panel;
	}

	public boolean isCOMP_32_PANEL() {
		return COMP_32_PANEL;
	}

	public void setCOMP_32_PANEL(boolean comp_32_panel) {
		COMP_32_PANEL = comp_32_panel;
	}

	public boolean isCOMP_33_PANEL() {
		return COMP_33_PANEL;
	}

	public void setCOMP_33_PANEL(boolean comp_33_panel) {
		COMP_33_PANEL = comp_33_panel;
	}

	public boolean isCOMP_34_PANEL() {
		return COMP_34_PANEL;
	}

	public void setCOMP_34_PANEL(boolean comp_34_panel) {
		COMP_34_PANEL = comp_34_panel;
	}

	public boolean isCOMP_35_PANEL() {
		return COMP_35_PANEL;
	}

	public void setCOMP_35_PANEL(boolean comp_35_panel) {
		COMP_35_PANEL = comp_35_panel;
	}

	public boolean isCOMP_36_PANEL() {
		return COMP_36_PANEL;
	}

	public void setCOMP_36_PANEL(boolean comp_36_panel) {
		COMP_36_PANEL = comp_36_panel;
	}

	public boolean isCOMP_37_PANEL() {
		return COMP_37_PANEL;
	}

	public void setCOMP_37_PANEL(boolean comp_37_panel) {
		COMP_37_PANEL = comp_37_panel;
	}

	public boolean isCOMP_38_PANEL() {
		return COMP_38_PANEL;
	}

	public void setCOMP_38_PANEL(boolean comp_38_panel) {
		COMP_38_PANEL = comp_38_panel;
	}

	public boolean isCOMP_39_PANEL() {
		return COMP_39_PANEL;
	}

	public void setCOMP_39_PANEL(boolean comp_39_panel) {
		COMP_39_PANEL = comp_39_panel;
	}

	public boolean isCOMP_40_PANEL() {
		return COMP_40_PANEL;
	}

	public void setCOMP_40_PANEL(boolean comp_40_panel) {
		COMP_40_PANEL = comp_40_panel;
	}

	public boolean isCOMP_41_PANEL() {
		return COMP_41_PANEL;
	}

	public void setCOMP_41_PANEL(boolean comp_41_panel) {
		COMP_41_PANEL = comp_41_panel;
	}

	public boolean isCOMP_42_PANEL() {
		return COMP_42_PANEL;
	}

	public void setCOMP_42_PANEL(boolean comp_42_panel) {
		COMP_42_PANEL = comp_42_panel;
	}

	public boolean isCOMP_43_PANEL() {
		return COMP_43_PANEL;
	}

	public void setCOMP_43_PANEL(boolean comp_43_panel) {
		COMP_43_PANEL = comp_43_panel;
	}

	public boolean isCOMP_44_PANEL() {
		return COMP_44_PANEL;
	}

	public void setCOMP_44_PANEL(boolean comp_44_panel) {
		COMP_44_PANEL = comp_44_panel;
	}

	public boolean isCOMP_45_PANEL() {
		return COMP_45_PANEL;
	}

	public void setCOMP_45_PANEL(boolean comp_45_panel) {
		COMP_45_PANEL = comp_45_panel;
	}

	public boolean isCOMP_46_PANEL() {
		return COMP_46_PANEL;
	}

	public void setCOMP_46_PANEL(boolean comp_46_panel) {
		COMP_46_PANEL = comp_46_panel;
	}

	public boolean isCOMP_47_PANEL() {
		return COMP_47_PANEL;
	}

	public void setCOMP_47_PANEL(boolean comp_47_panel) {
		COMP_47_PANEL = comp_47_panel;
	}

	public boolean isCOMP_48_PANEL() {
		return COMP_48_PANEL;
	}

	public void setCOMP_48_PANEL(boolean comp_48_panel) {
		COMP_48_PANEL = comp_48_panel;
	}

	public boolean isCOMP_49_PANEL() {
		return COMP_49_PANEL;
	}

	public void setCOMP_49_PANEL(boolean comp_49_panel) {
		COMP_49_PANEL = comp_49_panel;
	}

	public boolean isCOMP_50_PANEL() {
		return COMP_50_PANEL;
	}

	public void setCOMP_50_PANEL(boolean comp_50_panel) {
		COMP_50_PANEL = comp_50_panel;
	}

	public boolean isCOMP_51_PANEL() {
		return COMP_51_PANEL;
	}

	public void setCOMP_51_PANEL(boolean comp_51_panel) {
		COMP_51_PANEL = comp_51_panel;
	}

	public boolean isCOMP_52_PANEL() {
		return COMP_52_PANEL;
	}

	public void setCOMP_52_PANEL(boolean comp_52_panel) {
		COMP_52_PANEL = comp_52_panel;
	}

	public boolean isCOMP_53_PANEL() {
		return COMP_53_PANEL;
	}

	public void setCOMP_53_PANEL(boolean comp_53_panel) {
		COMP_53_PANEL = comp_53_panel;
	}

	public boolean isCOMP_54_PANEL() {
		return COMP_54_PANEL;
	}

	public void setCOMP_54_PANEL(boolean comp_54_panel) {
		COMP_54_PANEL = comp_54_panel;
	}

	public boolean isCOMP_55_PANEL() {
		return COMP_55_PANEL;
	}

	public void setCOMP_55_PANEL(boolean comp_55_panel) {
		COMP_55_PANEL = comp_55_panel;
	}

	public boolean isCOMP_56_PANEL() {
		return COMP_56_PANEL;
	}

	public void setCOMP_56_PANEL(boolean comp_56_panel) {
		COMP_56_PANEL = comp_56_panel;
	}

	public boolean isCOMP_57_PANEL() {
		return COMP_57_PANEL;
	}

	public void setCOMP_57_PANEL(boolean comp_57_panel) {
		COMP_57_PANEL = comp_57_panel;
	}

	public boolean isCOMP_58_PANEL() {
		return COMP_58_PANEL;
	}

	public void setCOMP_58_PANEL(boolean comp_58_panel) {
		COMP_58_PANEL = comp_58_panel;
	}

	public boolean isCOMP_59_PANEL() {
		return COMP_59_PANEL;
	}

	public void setCOMP_59_PANEL(boolean comp_59_panel) {
		COMP_59_PANEL = comp_59_panel;
	}

	public boolean isCOMP_60_PANEL() {
		return COMP_60_PANEL;
	}

	public void setCOMP_60_PANEL(boolean comp_60_panel) {
		COMP_60_PANEL = comp_60_panel;
	}
	
	public IP_REP_INFO getIP_REP_INFO_BEAN() {
		return IP_REP_INFO_BEAN;
	}

	public void setIP_REP_INFO_BEAN(IP_REP_INFO ip_rep_info_bean) {
		IP_REP_INFO_BEAN = ip_rep_info_bean;
	}


	
	
	public void getSelectedFileType(ActionEvent e) {
		HtmlSelectOneRadio input = (HtmlSelectOneRadio) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		if(inputString!=null){
			IP_REP_INFO_BEAN.setSelectedFileType(inputString);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void getSelectedCustStatus(ActionEvent e) {
		HtmlSelectOneRadio input = (HtmlSelectOneRadio) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		if(inputString!=null){
			IP_REP_INFO_BEAN.setSelectedCustStatus(inputString);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	
	public void getSelectedCustType(ActionEvent e) {
		HtmlSelectOneRadio input = (HtmlSelectOneRadio) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		if(inputString!=null){
			IP_REP_INFO_BEAN.setSelectedCustType(inputString);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	public void getSelectedPolicyStatus(ActionEvent e) {
		HtmlSelectOneRadio input = (HtmlSelectOneRadio) e.getComponent().getParent();
		String inputString = (String) input.getValue();
		if(inputString!=null){
			IP_REP_INFO_BEAN.setSelectedPolicyStatus(inputString);
		}
		ErrorHelpUtil.validate(input, getErrorMap());
	}
	
	 /*public String runAction() {
		CommonUtils.clearMaps(this);
		String redirectUrl = null;
		HttpServletResponse response=null;
		String moduleCode=CommonUtils.getGlobalVariable("GLOBAL.M_MODULE_CODE");
		Map<String, String> parameterMap=new HashMap<String, String>();
		try {
			if (IP_REP_INFO_BEAN.getSelectedFileType() != null) {
				
				response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

				parameterMap.put("P_FM_DATE",new ReportUtils().changeDatetoString(IP_REP_INFO_BEAN.getUI_M_FM_DT(),PELConstants.pelDateFormat));
				parameterMap.put("P_TO_DATE",new ReportUtils().changeDatetoString(IP_REP_INFO_BEAN.getUI_M_TO_DT(),PELConstants.pelDateFormat));
				parameterMap.put("P_FM_DIVN_CODE",IP_REP_INFO_BEAN.getUI_FM_DIVN_CODE());
				parameterMap.put("P_TO_DIVN_CODE",IP_REP_INFO_BEAN.getUI_TO_DIVN_CODE());
				parameterMap.put("P_FM_DEPT_CODE",IP_REP_INFO_BEAN.getUI_M_FM_DEPT_CODE());
				parameterMap.put("P_TO_DEPT_CODE",IP_REP_INFO_BEAN.getUI_M_TO_DEPT_CODE());
				parameterMap.put("P_FM_CLASS_CODE",IP_REP_INFO_BEAN.getUI_M_FM_CLASS_CODE());
				parameterMap.put("P_TO_CLASS_CODE",IP_REP_INFO_BEAN.getUI_M_TO_CLASS_CODE());
				parameterMap.put("P_FM_SC_CODE",IP_REP_INFO_BEAN.getUI_M_FM_SC_CODE());
				parameterMap.put("P_TO_SC_CODE",IP_REP_INFO_BEAN.getUI_M_TO_CLASS_CODE());
				parameterMap.put("P_FM_CUST_CODE",IP_REP_INFO_BEAN.getUI_M_FM_CUST_CLASS());
				parameterMap.put("P_TO_CUST_CODE",IP_REP_INFO_BEAN.getUI_M_TO_CUST_CLASS());
				parameterMap.put("P_FM_INS_CODE",IP_REP_INFO_BEAN.getUI_M_FM_CUST_INS());
				parameterMap.put("P_TO_INS_CODE",IP_REP_INFO_BEAN.getUI_M_TO_CUST_INS());
				parameterMap.put("P_FM_AGENT_CODE",IP_REP_INFO_BEAN.getUI_M_FM_AGENT_CODE());
				parameterMap.put("P_TO_AGENT_CODE",IP_REP_INFO_BEAN.getUI_M_TO_AGENT_CODE());
				
				redirectUrl = ReportUtils.getReportRedirectString("PBR016", 
																			moduleCode,
																			IP_REP_INFO_BEAN.getSelectedFileType(),
																			parameterMap);
				response.sendRedirect(redirectUrl);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return redirectUrl;
	}*/
	
	public String runAction() {
		CommonUtils.clearMaps(this);
		String redirectUrl = null;
 		setRedirectUrl(null);
		HttpServletResponse response = null;
		String moduleCode = CommonUtils
				.getGlobalVariable("GLOBAL.M_MODULE_NAME");
		Map<String, String> map = new HashMap<String, String>();

		try
		{
			if (IP_REP_INFO_BEAN.getSelectedFileType() != null) {

				if (IP_REP_INFO_BEAN.getROWID() == null) {

					helper.PRE_INSERT(this.IP_REP_INFO_BEAN);

				} else {

					helper.PRE_UPDATE(this.IP_REP_INFO_BEAN);
				}
//				new PGLR039_012_DELEGATE().executeSaveAction(this.IP_REP_INFO_BEAN);
				response = (HttpServletResponse) FacesContext
						.getCurrentInstance().getExternalContext()
						.getResponse();
				map.put("P_PR_DIVN_FM_CODE",IP_REP_INFO_BEAN.getUI_M_PR_DIVN_FM_CODE());
				map.put("P_PR_DIVN_TO_CODE",IP_REP_INFO_BEAN.getUI_M_PR_DIVN_TO_CODE());
				map.put("P_PR_DEPT_FM_CODE",IP_REP_INFO_BEAN.getUI_M_DEPT_FM_CODE());
				map.put("P_PR_DEPT_TO_CODE",IP_REP_INFO_BEAN.getUI_M_DEPT_TO_CODE());
				map.put("P_COMP_NAME",CommonUtils.getGlobalVariable("GLOBAL.M_NAME"));   
				map.put("P_FM_POL_CLASS_CODE",IP_REP_INFO_BEAN.getUI_M_FM_POL_CLASS_CODE());
				map.put("P_TO_POL_CLASS_CODE",IP_REP_INFO_BEAN.getUI_M_TO_POL_CLASS_CODE());
				
				map.put("P_PR_TXN_FM_DT",IP_REP_INFO_BEAN.getREP_VALUE_7());
				map.put("P_PROD_CODE",IP_REP_INFO_BEAN.getUI_M_FM_PROD_CODE());
				map.put("P_GRANTEE_CODE",IP_REP_INFO_BEAN.getUI_M_GRANTEE_CODE());
				map.put("P_DEVELOPER_CODE",IP_REP_INFO_BEAN.getUI_M_DEVELOPER_CODE());
				map.put("P_PROJECT_CODE",IP_REP_INFO_BEAN.getUI_M_PROJECT_CODE());
				map.put("P_PR_TXN_TO_DT",IP_REP_INFO_BEAN.getREP_VALUE_8());
				map.put("MAXIMIZE","YES");

				
				redirectUrl = ReportUtils.getReportRedirectString(
						IP_REP_INFO_BEAN.getREP_KEY_NO(), IP_REP_INFO_BEAN.getREP_ID(), 
						IP_REP_INFO_BEAN.getREP_ID(),
						IP_REP_INFO_BEAN.getSelectedFileType(),map);
//				response.sendRedirect(redirectUrl);
		    	setRedirectUrl(redirectUrl);
			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}

		return redirectUrl;
	}
	 
	 public void onLoad(PhaseEvent phaseEvent){
		
		 PILR006_A_HELPER helper=new PILR006_A_HELPER();
		 
		 if(isFormFlag()){
			 
			 setFormFlag(false);
		 }
		 
		 if(isBlockFlag()){
			
				//prepare list for policy , customer type, customer status
				
//				prepareCustStatusList();
//				prepareCustTypeList();
//				preparePolicyStatusList();
			 prepareDropDownList();
				
			 helper.whenCreateRecord(IP_REP_INFO_BEAN);
			 IP_REP_INFO_BEAN.setSelectedFileType(getReportPDFFormat());
//			 IP_REP_INFO_BEAN.setSelectedPolicyStatus(getPolStatusList().get(0).getValue().toString());
//			 IP_REP_INFO_BEAN.setSelectedCustType(getCustTypeList().get(1).getValue().toString());
//			 IP_REP_INFO_BEAN.setSelectedCustStatus(getCustStatusList().get(0).getValue().toString());
			 setBlockFlag(false);
		 }
	 }

	public String getReportPDFFormat() {
		return reportPDFFormat;
	}

	public void setReportPDFFormat(String reportPDFFormat) {
		this.reportPDFFormat = reportPDFFormat;
	}

	public String getReportCSVFormat() {
		return reportCSVFormat;
	}

	public void setReportCSVFormat(String reportCSVFormat) {
		this.reportCSVFormat = reportCSVFormat;
	}

	public String getReportHTMLFormat() {
		return reportHTMLFormat;
	}

	public void setReportHTMLFormat(String reportHTMLFormat) {
		this.reportHTMLFormat = reportHTMLFormat;
	}

	public String getReportExcelFormat() {
		return reportExcelFormat;
	}

	public void setReportExcelFormat(String reportExcelFormat) {
		this.reportExcelFormat = reportExcelFormat;
	}

	public String getP_POLICY_NUMBER_TO() {
		return P_POLICY_NUMBER_TO;
	}

	public void setP_POLICY_NUMBER_TO(String p_policy_number_to) {
		P_POLICY_NUMBER_TO = p_policy_number_to;
	}

	public String getP_POLICY_NUMBER_FM() {
		return P_POLICY_NUMBER_FM;
	}

	public void setP_POLICY_NUMBER_FM(String p_policy_number_fm) {
		P_POLICY_NUMBER_FM = p_policy_number_fm;
	}
	 
	public HtmlInputText getCOMP_1_INPUT_TEXT_DESC() {
		return COMP_1_INPUT_TEXT_DESC;
	}

	public void setCOMP_1_INPUT_TEXT_DESC(HtmlInputText comp_1_input_text_desc) {
		COMP_1_INPUT_TEXT_DESC = comp_1_input_text_desc;
	}

	public HtmlInputText getCOMP_2_INPUT_TEXT_DESC() {
		return COMP_2_INPUT_TEXT_DESC;
	}

	public void setCOMP_2_INPUT_TEXT_DESC(HtmlInputText comp_2_input_text_desc) {
		COMP_2_INPUT_TEXT_DESC = comp_2_input_text_desc;
	}

	public HtmlInputText getCOMP_3_INPUT_TEXT_DESC() {
		return COMP_3_INPUT_TEXT_DESC;
	}

	public void setCOMP_3_INPUT_TEXT_DESC(HtmlInputText comp_3_input_text_desc) {
		COMP_3_INPUT_TEXT_DESC = comp_3_input_text_desc;
	}

	public HtmlInputText getCOMP_4_INPUT_TEXT_DESC() {
		return COMP_4_INPUT_TEXT_DESC;
	}

	public void setCOMP_4_INPUT_TEXT_DESC(HtmlInputText comp_4_input_text_desc) {
		COMP_4_INPUT_TEXT_DESC = comp_4_input_text_desc;
	}

	public HtmlInputText getCOMP_5_INPUT_TEXT_DESC() {
		return COMP_5_INPUT_TEXT_DESC;
	}

	public void setCOMP_5_INPUT_TEXT_DESC(HtmlInputText comp_5_input_text_desc) {
		COMP_5_INPUT_TEXT_DESC = comp_5_input_text_desc;
	}

	public HtmlInputText getCOMP_6_INPUT_TEXT_DESC() {
		return COMP_6_INPUT_TEXT_DESC;
	}

	public void setCOMP_6_INPUT_TEXT_DESC(HtmlInputText comp_6_input_text_desc) {
		COMP_6_INPUT_TEXT_DESC = comp_6_input_text_desc;
	}

	public HtmlInputText getCOMP_7_INPUT_TEXT_DESC() {
		return COMP_7_INPUT_TEXT_DESC;
	}

	public void setCOMP_7_INPUT_TEXT_DESC(HtmlInputText comp_7_input_text_desc) {
		COMP_7_INPUT_TEXT_DESC = comp_7_input_text_desc;
	}

	public HtmlInputText getCOMP_8_INPUT_TEXT_DESC() {
		return COMP_8_INPUT_TEXT_DESC;
	}

	public void setCOMP_8_INPUT_TEXT_DESC(HtmlInputText comp_8_input_text_desc) {
		COMP_8_INPUT_TEXT_DESC = comp_8_input_text_desc;
	}
	
	public void whenValidateUI_M_PR_DIVN_FM_CODE(ActionEvent actionEvent) {
		cancelModalPanel();
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		if(input.getSubmittedValue()==null || "".equals(input.getSubmittedValue())){
			this.IP_REP_INFO_BEAN.setUI_M_PR_DIVN_FM_CODE(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0);
			getIP_REP_INFO_BEAN().setUI_M_FM_DIVN_NAME(null);
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				this.IP_REP_INFO_BEAN.setUI_M_PR_DIVN_FM_CODE(input.getValue().toString());
			}
		}
		COMP_1_INPUT_TEXT.resetValue();
		COMP_1_INPUT_TEXT_DESC.resetValue();
	}
	
	public void whenValidateUI_M_DEPT_FM_CODE(ActionEvent actionEvent) {
		cancelModalPanel();
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		if(input.getSubmittedValue()==null || "".equals(input.getSubmittedValue())){
			this.IP_REP_INFO_BEAN.setUI_M_DEPT_FM_CODE(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0);
			getIP_REP_INFO_BEAN().setUI_M_DEPT_FM_NAME(null);
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				this.IP_REP_INFO_BEAN.setUI_M_DEPT_FM_CODE(input.getValue().toString());
			}
		}
		COMP_5_INPUT_TEXT.resetValue();
		COMP_5_INPUT_TEXT_DESC.resetValue();
	}
	
	public void whenValidateUI_M_DEPT_TO_CODE(ActionEvent actionEvent) {
		cancelModalPanel();

		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if(input.getSubmittedValue()==null || input.getSubmittedValue().toString().isEmpty()){
			if(IP_REP_INFO_BEAN.getUI_M_DEPT_FM_CODE()!=null){
				if(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0.equals(IP_REP_INFO_BEAN.getUI_M_DEPT_FM_CODE())){
					this.IP_REP_INFO_BEAN.setUI_M_DEPT_TO_CODE(REPORT_UTIL_CONSTANTS.SET_SECOND_FIELD_DEFAULT_ZZZZ);
					getIP_REP_INFO_BEAN().setUI_M_DEPT_TO_DESC(null);
				}else{
					this.IP_REP_INFO_BEAN.setUI_M_DEPT_TO_CODE(IP_REP_INFO_BEAN.getUI_M_DEPT_FM_CODE());
					this.IP_REP_INFO_BEAN.setUI_M_DEPT_TO_DESC(IP_REP_INFO_BEAN.getUI_M_DEPT_FM_NAME());
				}
			}
			
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				this.IP_REP_INFO_BEAN.setUI_M_DEPT_TO_CODE(input.getValue().toString());
			}
		}
		COMP_6_INPUT_TEXT.resetValue();
		COMP_6_INPUT_TEXT_DESC.resetValue();
	}

	public void whenValidateUI_M_FM_POL_CLASS_CODE(ActionEvent actionEvent) {
		cancelModalPanel();
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		if(input.getSubmittedValue()==null || "".equals(input.getSubmittedValue())){
			this.IP_REP_INFO_BEAN.setUI_M_FM_POL_CLASS_CODE(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0);
			getIP_REP_INFO_BEAN().setUI_M_FM_POL_CLASS_NAME(null);
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				this.IP_REP_INFO_BEAN.setUI_M_FM_POL_CLASS_CODE(input.getValue().toString());
			}
		}
		COMP_7_INPUT_TEXT.resetValue();
		COMP_7_INPUT_TEXT_DESC.resetValue();
	}
	
	public void whenValidateUI_M_TO_POL_CLASS_CODE(ActionEvent actionEvent) {
		cancelModalPanel();

		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if(input.getSubmittedValue()==null || input.getSubmittedValue().toString().isEmpty()){
			if(IP_REP_INFO_BEAN.getUI_M_FM_POL_CLASS_CODE()!=null){
				if(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0.equals(IP_REP_INFO_BEAN.getUI_M_FM_POL_CLASS_CODE())){
					this.IP_REP_INFO_BEAN.setUI_M_TO_POL_CLASS_CODE(REPORT_UTIL_CONSTANTS.SET_SECOND_FIELD_DEFAULT_ZZZZ);
					getIP_REP_INFO_BEAN().setUI_M_TO_POL_CLASS_NAME(null);
				}else{
					this.IP_REP_INFO_BEAN.setUI_M_TO_POL_CLASS_CODE(IP_REP_INFO_BEAN.getUI_M_FM_POL_CLASS_CODE());
					this.IP_REP_INFO_BEAN.setUI_M_TO_POL_CLASS_NAME(IP_REP_INFO_BEAN.getUI_M_FM_POL_CLASS_NAME());
				}
			}
			
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				this.IP_REP_INFO_BEAN.setUI_M_TO_POL_CLASS_CODE(input.getValue().toString());
			}
		}
		COMP_8_INPUT_TEXT.resetValue();
		COMP_8_INPUT_TEXT_DESC.resetValue();
	}
	public void validateUI_M_PR_DIVN_FM_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		String uiDivnFmCode = (String) value;
		try {
			if(!"*".equals(uiDivnFmCode)){
				String divnCodeName = helper.WHEN_VALIDATE_ITEM_UI_DIVN_CODE(uiDivnFmCode,IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setUI_M_FM_DIVN_NAME(divnCodeName);
			}
			COMP_1_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_FM_DIVN_CODE", getWarningMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}
	public void validateUI_M_DEPT_FM_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		String uiDeptFmCode = (String) value;
		try {
			if(!"*".equals(uiDeptFmCode)){
				String deptCodeName = helper.WHEN_VALIDATE_ITEM_UI_DEPT_CODE(uiDeptFmCode,IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setUI_M_DEPT_FM_CODE(deptCodeName);
			}
			COMP_1_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_FM_DIVN_CODE", getWarningMap());
			} catch (DBException e) {
				e.printStackTrace();
			}
		}
	}
	 
	public List<LovBean> lovUI_M_DIVISION(Object obj){
		String code = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object={};
		String query=null;
		if("*".equals(code)){
			object=new Object[]{PELConstants.suggetionRecordSize};
			query=PILR006_A_QUERY_CONSTANTS.DIVISION_QUERY ;
		}else{
			object=new Object[]{code+"%",code+"%",PELConstants.suggetionRecordSize};
			query=PILR006_A_QUERY_CONSTANTS.DIVISION_QUERY_LIKE;
		}
		suggestionList = delegate.prepareLovList(query, object);
		return suggestionList;
	}
	
	public void whenValidateUI_M_PR_DIVN_TO_CODE(ActionEvent actionEvent) {
		cancelModalPanel();

		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		if(input.getSubmittedValue()==null || input.getSubmittedValue().toString().isEmpty()){
			if(IP_REP_INFO_BEAN.getUI_M_PR_DIVN_FM_CODE()!=null){
				if(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0.equals(IP_REP_INFO_BEAN.getUI_M_PR_DIVN_FM_CODE())){
					this.IP_REP_INFO_BEAN.setUI_M_PR_DIVN_TO_CODE(REPORT_UTIL_CONSTANTS.SET_SECOND_FIELD_DEFAULT_ZZZZ);
					getIP_REP_INFO_BEAN().setUI_M_TO_DIVN_NAME(null);
				}else{
					this.IP_REP_INFO_BEAN.setUI_M_PR_DIVN_TO_CODE(IP_REP_INFO_BEAN.getUI_M_PR_DIVN_FM_CODE());
					this.IP_REP_INFO_BEAN.setUI_M_TO_DIVN_NAME(IP_REP_INFO_BEAN.getUI_M_FM_DIVN_NAME());
				}
			}
			
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				this.IP_REP_INFO_BEAN.setUI_M_PR_DIVN_TO_CODE(input.getValue().toString());
			}
		}
		COMP_2_INPUT_TEXT.resetValue();
		COMP_2_INPUT_TEXT_DESC.resetValue();
	}

	public void validateUI_M_PR_DIVN_TO_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		String uiDivnToCode = (String) value;
		try {
			String divnCodeName = helper.WHEN_VALIDATE_ITEM_UI_DIVN_CODE(uiDivnToCode,IP_REP_INFO_BEAN);
			IP_REP_INFO_BEAN.setUI_M_TO_DIVN_NAME(divnCodeName);
			COMP_2_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_TO_DIVN_CODE", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();

			}
		}
	}
	
	public List<LovBean> lovDivnCode(Object value){
		ListItemUtil listItemUtil = null;
		ArrayList<LovBean> list = new ArrayList<LovBean>();
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILR107", "REP_PARAM", "M_PR_DIVN_FM_CODE", 
					null, null, null, null, null, (String)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("prepareLovCommCode",e.getMessage());
		}
		return list;
	}
	public List<LovBean> lovDeptCode(Object value){
		ListItemUtil listItemUtil = null;
		ArrayList<LovBean> list = new ArrayList<LovBean>();
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILR107", "REP_PARAM", "M_DEPT_FM_CODE", 
					null, null, null, null, null, (String)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("prepareLovCommCode",e.getMessage());
		}
		return list;
	}
	public List<LovBean> lovProdCode(Object value){
		ListItemUtil listItemUtil = null;
		ArrayList<LovBean> list = new ArrayList<LovBean>();
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILR107", "REP_PARAM", "M_FM_PROD_CODE", 
					null, null, null, null, null, (String)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("prepareLovCommCode",e.getMessage());
		}
		return list;
	}
	
	public List<LovBean> lovDeveloperCode(Object value){
		ListItemUtil listItemUtil = null;
		ArrayList<LovBean> list = new ArrayList<LovBean>();
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILR069", "REP_PARAM", "M_DEVELOPER_CODE", 
					"IL_DVP_CODE", null, null, null, null, (String)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("prepareLovCommCode",e.getMessage());
		}
		return list;
	}
	


	public void validateUI_M_GRANTEE_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		String uiGranteeCode = (String) value;
		try {
			String granteeCodeName = helper.WHEN_VALIDATE_ITEM_UI_M_GRANTEE_CODE(uiGranteeCode,IP_REP_INFO_BEAN);
			IP_REP_INFO_BEAN.setUI_M_GRANTEE_NAME(granteeCodeName);
			COMP_4_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), facesContext, component.getId(),
						getWarningMap());
			} catch (DBException e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateUI_M_PROJECT_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		String uiProjectCode = (String) value;
		try {
			String projectCodeName = helper.WHEN_VALIDATE_ITEM_UI_M_PROJECT_CODE(uiProjectCode,IP_REP_INFO_BEAN);
			IP_REP_INFO_BEAN.setUI_M_PROJ_DESC(projectCodeName);
			COMP_10_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {
				ErrorHelpUtil.getErrorsAndWarningforProcedure(CommonUtils
						.getConnection(), facesContext, component.getId(),
						getWarningMap());
			} catch (DBException e) {
				throw new ValidatorException(new FacesMessage(e.getMessage()));
			}
		}
	}
	
	public void validateUI_M_DEVELOPER_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		String uiDeveloperCode = (String) value;
		try {
			String projectCodeName = helper.WHEN_VALIDATE_ITEM_UI_M_DEVELOPER_CODE(uiDeveloperCode,IP_REP_INFO_BEAN);
			IP_REP_INFO_BEAN.setUI_M_DEV_DESC(projectCodeName);
			COMP_9_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_TO_DIVN_CODE", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();

			}
		}
	}
	
	public List<LovBean> lovGranteeCode(Object value){
		ListItemUtil listItemUtil = null;
		ArrayList<LovBean> list = new ArrayList<LovBean>();
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILR069", "REP_PARAM", "M_GRANTEE_CODE", 
					"BANK", null, "BANK", null, null, (String)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("prepareLovCommCode",e.getMessage());
		}
		return list;
	}
	
	public List<LovBean> lovGranteeCode1(Object obj){
		String code = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object={};
		String query=null;
		if("*".equals(code)){
			object=new Object[]{PELConstants.suggetionRecordSize};
			query=PILR006_A_QUERY_CONSTANTS.CUST_CLASS;
		}else{
			object=new Object[]{code+"%",code+"%",PELConstants.suggetionRecordSize};
			query=PILR006_A_QUERY_CONSTANTS.CUST_CLASS_LIKE;
		}
		suggestionList = delegate.prepareLovList(query, object);
		return suggestionList;
	}
	public List<LovBean> lovProjectCode(Object value){
		ListItemUtil listItemUtil = null;
		ArrayList<LovBean> list = new ArrayList<LovBean>();
		try {
			listItemUtil = new ListItemUtil();
			list = listItemUtil.P_CALL_LOV("PILR069", "REP_PARAM", "M_PROJECT_CODE", 
					"IL_PROJ_CODE", null, null, null, null, (String)value);
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,e.getMessage());
			getErrorMap().put("prepareLovCommCode",e.getMessage());
		}
		return list;
	}
	

	public void whenValidateUI_M_FM_PROD_CODE(ActionEvent actionEvent) {
		cancelModalPanel();
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		
		if(input.getSubmittedValue()==null || "".equals(input.getSubmittedValue())){
			this.IP_REP_INFO_BEAN.setUI_M_FM_PROD_CODE(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0);
			getIP_REP_INFO_BEAN().setUI_M_FM_PROD_DESC(null);
		}else{
			ErrorHelpUtil.validate(input, getErrorMap());
			if (input.isValid()) {
				this.IP_REP_INFO_BEAN.setUI_M_FM_PROD_CODE(input.getValue().toString());
			}
		}
		COMP_3_INPUT_TEXT.resetValue();
		COMP_3_INPUT_TEXT_DESC.resetValue();
	}	

	public void validateUI_M_FM_PROD_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		String uiDeptFmCode = (String) value;
		try {
			/*If the branch code is zero it will not validate the dept code.because for 
			   zero record  there is no any dept code*/  
				String productName  = helper.WHEN_VALIDATE_ITEM_UI_M_PROD_CODE(uiDeptFmCode,IP_REP_INFO_BEAN);
				IP_REP_INFO_BEAN.setUI_M_FM_PROD_DESC(productName);
				COMP_3_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_FM_DEPT_CODE", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();

			}
		}
	}
	
	public void whenValidateUI_M_TO_PROD_CODE(ActionEvent actionEvent) {
		cancelModalPanel();
		CommonUtils.clearMaps(this);
		UIInput input = (UIInput) actionEvent.getComponent().getParent();
		String submittedValue=(String)input.getSubmittedValue();
		if(submittedValue==null ||submittedValue.toString().isEmpty()){
			
			if(IP_REP_INFO_BEAN.getUI_M_FM_PROD_CODE()!=null){
				
				if(REPORT_UTIL_CONSTANTS.SET_FIRST_FIELD_DEFAULT_0.equals(IP_REP_INFO_BEAN.getUI_M_FM_PROD_CODE())){
					
					this.IP_REP_INFO_BEAN.setUI_M_TO_PROD_CODE(REPORT_UTIL_CONSTANTS.SET_SECOND_FIELD_DEFAULT_ZZZZ);
					getIP_REP_INFO_BEAN().setUI_M_TO_PROD_DESC(null);
				
				}else{
					this.IP_REP_INFO_BEAN.setUI_M_TO_PROD_CODE(IP_REP_INFO_BEAN.getUI_M_FM_PROD_CODE());
					this.IP_REP_INFO_BEAN.setUI_M_TO_PROD_DESC(IP_REP_INFO_BEAN.getUI_M_FM_PROD_DESC());
				}
			}
			
		}else{
			
			ErrorHelpUtil.validate(input, getErrorMap());
			
		//	if (input.isValid()) {
				
				this.IP_REP_INFO_BEAN.setUI_M_TO_PROD_CODE(submittedValue);
				
		//	}
		}
		COMP_4_INPUT_TEXT.resetValue();
		COMP_4_INPUT_TEXT_DESC.resetValue();
	}

	public void validateUI_M_TO_PROD_CODE(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		String uiDivnToCode = (String) value;
		try {

			String prodName = helper.WHEN_VALIDATE_ITEM_UI_M_PROD_CODE(uiDivnToCode,IP_REP_INFO_BEAN);
			IP_REP_INFO_BEAN.setUI_M_TO_PROD_DESC(prodName);
			COMP_4_INPUT_TEXT_DESC.resetValue();

		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_TO_DEPT_CODE", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();

			}
		}
	}
	
	
	public void validateUI_M_DATE_FM(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {

		try {
			IP_REP_INFO_BEAN.setUI_M_DATE_FM((Date)value);
			if(IP_REP_INFO_BEAN.getUI_M_DATE_FM().after(new CommonUtils().getCurrentDate())){
			   throw new Exception (Messages.getString(PELConstants.pelErrorMessagePath, "2181")) ;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_DATE_FM", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();

			}
		}
	}
	
	public void validateUI_M_DATE_TO(FacesContext facesContext,
			UIComponent component, Object value) throws ValidatorException {
		try {
			IP_REP_INFO_BEAN.setUI_M_DATE_TO((Date)value);
			if(IP_REP_INFO_BEAN.getUI_M_DATE_TO().after(new CommonUtils().getCurrentDate())){
				throw new Exception (Messages.getString(PELConstants.pelErrorMessagePath, "2181")) ;
			}else if (IP_REP_INFO_BEAN.getUI_M_DATE_TO().before(IP_REP_INFO_BEAN.getUI_M_DATE_FM())){
				throw new Exception (Messages.getString(PELConstants.pelErrorMessagePath, "1902")) ;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			throw new ValidatorException(new FacesMessage(exception
					.getMessage()));
		} finally {
			try {

				ErrorHelpUtil.getWarningForProcedure(CommonUtils
						.getConnection(), "UI_M_DATE_TO", getWarningMap());

			} catch (DBException e) {

				e.printStackTrace();

			}
		}
	}

	public HtmlInputText getCOMP_9_INPUT_TEXT_DESC() {
		return COMP_9_INPUT_TEXT_DESC;
	}

	public void setCOMP_9_INPUT_TEXT_DESC(HtmlInputText comp_9_input_text_desc) {
		COMP_9_INPUT_TEXT_DESC = comp_9_input_text_desc;
	}

	public HtmlInputText getCOMP_10_INPUT_TEXT_DESC() {
		return COMP_10_INPUT_TEXT_DESC;
	}

	public void setCOMP_10_INPUT_TEXT_DESC(HtmlInputText comp_10_input_text_desc) {
		COMP_10_INPUT_TEXT_DESC = comp_10_input_text_desc;
	}

	public List<LovBean> lovClassCode(Object obj){
		String code = (String) obj;
		List<LovBean> suggestionList = null;
		Object[] object={};
		String query=null;
		 if("*".equals(code)){
			object=new Object[]{PELConstants.suggetionRecordSize};
			query=PILR006_A_QUERY_CONSTANTS.CLASS_QUERY ;
		}else{
			object=new Object[]{code+"%",code+"%",PELConstants.suggetionRecordSize};
			query=PILR006_A_QUERY_CONSTANTS.CLASS_QUERY_LIKE;
		}
		suggestionList = delegate.prepareDepttLovList(query, object);
		return suggestionList;
	}
	
	
	
	public HtmlInputText getCOMP_11_INPUT_TEXT_DESC() {
		return COMP_11_INPUT_TEXT_DESC;
	}

	public void setCOMP_11_INPUT_TEXT_DESC(HtmlInputText comp_11_input_text_desc) {
		COMP_11_INPUT_TEXT_DESC = comp_11_input_text_desc;
	}

	public HtmlInputText getCOMP_12_INPUT_TEXT_DESC() {
		return COMP_12_INPUT_TEXT_DESC;
	}

	public void setCOMP_12_INPUT_TEXT_DESC(HtmlInputText comp_12_input_text_desc) {
		COMP_12_INPUT_TEXT_DESC = comp_12_input_text_desc;
	}
	
	
	
	

	public HtmlSelectOneRadio getCOMP_SELECT_POL_STATUS() {
		return COMP_SELECT_POL_STATUS;
	}

	public void setCOMP_SELECT_POL_STATUS(HtmlSelectOneRadio comp_select_pol_status) {
		COMP_SELECT_POL_STATUS = comp_select_pol_status;
	}

	public HtmlSelectOneRadio getCOMP_SELECT_CUST_TYPE() {
		return COMP_SELECT_CUST_TYPE;
	}

	public void setCOMP_SELECT_CUST_TYPE(HtmlSelectOneRadio comp_select_cust_type) {
		COMP_SELECT_CUST_TYPE = comp_select_cust_type;
	}

	public HtmlSelectOneRadio getCOMP_SELECT_CUST_STATUS() {
		return COMP_SELECT_CUST_STATUS;
	}

	public void setCOMP_SELECT_CUST_STATUS(
			HtmlSelectOneRadio comp_select_cust_status) {
		COMP_SELECT_CUST_STATUS = comp_select_cust_status;
	}

	public List<SelectItem> getListM_MODULE_CODE_FM() {
		return listM_MODULE_CODE_FM;
	}

	public void setListM_MODULE_CODE_FM(List<SelectItem> listM_MODULE_CODE_FM) {
		this.listM_MODULE_CODE_FM = listM_MODULE_CODE_FM;
	}

	
	
	
}