package com.iii.pel.forms.PILR_REP047;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.model.SelectItem;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "IP_REP_INFO")
public class IP_REP_INFO extends BaseValueBean {

	@Column(name = "REP_KEY_NO")
	private String REP_KEY_NO;

	@Column(name = "REP_ID")
	private String REP_ID;

	@Column(name = "REP_VALUE_1")
	private String REP_VALUE_1; // FROM_DATE

	@Column(name = "REP_VALUE_2")
	private String REP_VALUE_2; // TO_DATE

	@Column(name = "REP_VALUE_3")
	private String REP_VALUE_3;

	@Column(name = "REP_VALUE_4")
	private String REP_VALUE_4;

	@Column(name = "REP_VALUE_5")
	private String REP_VALUE_5;

	@Column(name = "REP_VALUE_6")
	private String REP_VALUE_6;

	@Column(name = "REP_VALUE_7")
	private String REP_VALUE_7;

	@Column(name = "REP_VALUE_8")
	private String REP_VALUE_8;

	@Column(name = "REP_VALUE_9")
	private String REP_VALUE_9;

	@Column(name = "REP_VALUE_10")
	private String REP_VALUE_10;

	@Column(name = "REP_VALUE_11")
	private String REP_VALUE_11;

	@Column(name = "REP_VALUE_12")
	private String REP_VALUE_12;

	@Column(name = "REP_VALUE_13")
	private String REP_VALUE_13;

	@Column(name = "REP_VALUE_14")
	private String REP_VALUE_14;

	@Column(name = "REP_VALUE_15")
	private String REP_VALUE_15;

	@Column(name = "REP_VALUE_16")
	private String REP_VALUE_16;

	@Column(name = "REP_VALUE_17")
	private String REP_VALUE_17;

	@Column(name = "REP_VALUE_18")
	private String REP_VALUE_18;

	@Column(name = "REP_VALUE_19")
	private String REP_VALUE_19;

	@Column(name = "REP_VALUE_20")
	private String REP_VALUE_20;

	@Column(name = "REP_VALUE_21")
	private String REP_VALUE_21;

	@Column(name = "REP_VALUE_22")
	private String REP_VALUE_22;

	@Column(name = "REP_VALUE_23")
	private String REP_VALUE_23;

	@Column(name = "REP_VALUE_24")
	private String REP_VALUE_24;

	@Column(name = "REP_VALUE_25")
	private String REP_VALUE_25;

	@Column(name = "REP_VALUE_26")
	private String REP_VALUE_26;

	@Column(name = "REP_VALUE_27")
	private String REP_VALUE_27;

	@Column(name = "REP_VALUE_28")
	private String REP_VALUE_28;

	@Column(name = "REP_VALUE_29")
	private String REP_VALUE_29;

	@Column(name = "REP_VALUE_30")
	private String REP_VALUE_30;

	@Column(name = "REP_VALUE_31")
	private String REP_VALUE_31;

	@Column(name = "REP_VALUE_32")
	private String REP_VALUE_32;

	@Column(name = "REP_VALUE_33")
	private String REP_VALUE_33;

	@Column(name = "REP_VALUE_34")
	private String REP_VALUE_34;

	@Column(name = "REP_VALUE_35")
	private String REP_VALUE_35;

	@Column(name = "REP_VALUE_36")
	private String REP_VALUE_36;

	@Column(name = "REP_VALUE_37")
	private String REP_VALUE_37;

	@Column(name = "REP_VALUE_38")
	private String REP_VALUE_38;

	@Column(name = "REP_VALUE_39")
	private String REP_VALUE_39;

	@Column(name = "REP_VALUE_40")
	private String REP_VALUE_40;

	@Column(name = "REP_VALUE_41")
	private String REP_VALUE_41;

	@Column(name = "REP_VALUE_42")
	private String REP_VALUE_42;

	@Column(name = "REP_VALUE_43")
	private String REP_VALUE_43;

	@Column(name = "REP_VALUE_44")
	private String REP_VALUE_44;

	@Column(name = "REP_VALUE_45")
	private String REP_VALUE_45;

	@Column(name = "REP_VALUE_46")
	private String REP_VALUE_46;

	@Column(name = "REP_VALUE_47")
	private String REP_VALUE_47;

	@Column(name = "REP_VALUE_48")
	private String REP_VALUE_48;

	@Column(name = "REP_VALUE_49")
	private String REP_VALUE_49;

	@Column(name = "REP_VALUE_50")
	private String REP_VALUE_50;

	@Column(name = "REP_VALUE_51")
	private String REP_VALUE_51;

	@Column(name = "REP_VALUE_52")
	private String REP_VALUE_52;

	@Column(name = "REP_VALUE_53")
	private String REP_VALUE_53;

	@Column(name = "REP_VALUE_54")
	private String REP_VALUE_54;

	@Column(name = "REP_VALUE_55")
	private String REP_VALUE_55;

	@Column(name = "REP_VALUE_56")
	private String REP_VALUE_56;

	@Column(name = "REP_VALUE_57")
	private String REP_VALUE_57;

	@Column(name = "REP_VALUE_58")
	private String REP_VALUE_58;

	@Column(name = "REP_VALUE_59")
	private String REP_VALUE_59;

	@Column(name = "REP_VALUE_60")
	private String REP_VALUE_60;

	@Column(name = "REP_CR_UID")
	private String REP_CR_UID;

	@Column(name = "REP_CR_DT")
	private Date REP_CR_DT;

	@Column(name = "REP_UPD_DT")
	private Date REP_UPD_DT;

	@Column(name = "REP_UPD_UID")
	private String REP_UPD_UID;

	private Date FROM_DATE;

	private Date TO_DATE;

	private String selectedFileType="PDF";

	private String UI_M_FROM_DIVN_DESC;

	private String UI_M_TO_DIVN_DESC;

	private String UI_M_FROM_DEPT_DESC;

	private String UI_M_TO_DEPT_DESC;

	private String UI_M_FROM_CLASS_DESC;

	private String UI_M_TO_CLASS_DESC;

	private String UI_M_FROM_PLAN_DESC;

	private String UI_M_TO_PLAN_DESC;

	private String UI_M_FROM_BRANCH_DESC;

	private String UI_M_TO_BRANCH_DESC;

	private String UI_M_FROM_CLAIM_NO_DESC;

	private String UI_M_TO_CLAIM_NO_DESC;

	private String UI_M_FROM_CLAIM_TYPE_DESC;

	private String UI_M_TO_CLAIM_TYPE_DESC;

	private String BROKER_CODE_FROM;

	private String BROKER_CODE_TO;

	private String BROKER_CODE_FROM_DESC;

	private String BROKER_CODE_TO_DESC;

	private String PREMIUM_TYPE;

	List<SelectItem> PREMIUM_TYPE_LIST = new ArrayList<SelectItem>();

	private String targetValue = null;

	public String getTargetValue() {
		return targetValue;
	}

	public void setTargetValue(String targetValue) {
		this.targetValue = targetValue;
	}

	public List<SelectItem> getPREMIUM_TYPE_LIST() {
		return PREMIUM_TYPE_LIST;
	}

	public void setPREMIUM_TYPE_LIST(List<SelectItem> premium_type_list) {
		PREMIUM_TYPE_LIST = premium_type_list;
	}

	public String getBROKER_CODE_FROM() {
		return BROKER_CODE_FROM;
	}

	public void setBROKER_CODE_FROM(String broker_code_from) {
		BROKER_CODE_FROM = broker_code_from;
	}

	public String getBROKER_CODE_TO() {
		return BROKER_CODE_TO;
	}

	public void setBROKER_CODE_TO(String broker_code_to) {
		BROKER_CODE_TO = broker_code_to;
	}

	public String getPREMIUM_TYPE() {
		return PREMIUM_TYPE;
	}

	public void setPREMIUM_TYPE(String premium_type) {
		PREMIUM_TYPE = premium_type;
	}

	public String getREP_KEY_NO() {
		return REP_KEY_NO;
	}

	public void setREP_KEY_NO(String rep_key_no) {
		REP_KEY_NO = rep_key_no;
	}

	public String getREP_ID() {
		return REP_ID;
	}

	public void setREP_ID(String rep_id) {
		REP_ID = rep_id;
	}

	public String getREP_VALUE_3() {
		return REP_VALUE_3;
	}

	public void setREP_VALUE_3(String rep_value_3) {
		REP_VALUE_3 = rep_value_3;
	}

	public String getREP_VALUE_4() {
		return REP_VALUE_4;
	}

	public void setREP_VALUE_4(String rep_value_4) {
		REP_VALUE_4 = rep_value_4;
	}

	public String getREP_VALUE_5() {
		return REP_VALUE_5;
	}

	public void setREP_VALUE_5(String rep_value_5) {
		REP_VALUE_5 = rep_value_5;
	}

	public String getREP_VALUE_6() {
		return REP_VALUE_6;
	}

	public void setREP_VALUE_6(String rep_value_6) {
		REP_VALUE_6 = rep_value_6;
	}

	public String getREP_VALUE_7() {
		return REP_VALUE_7;
	}

	public void setREP_VALUE_7(String rep_value_7) {
		REP_VALUE_7 = rep_value_7;
	}

	public String getREP_VALUE_8() {
		return REP_VALUE_8;
	}

	public void setREP_VALUE_8(String rep_value_8) {
		REP_VALUE_8 = rep_value_8;
	}

	public String getREP_VALUE_9() {
		return REP_VALUE_9;
	}

	public void setREP_VALUE_9(String rep_value_9) {
		REP_VALUE_9 = rep_value_9;
	}

	public String getREP_VALUE_10() {
		return REP_VALUE_10;
	}

	public void setREP_VALUE_10(String rep_value_10) {
		REP_VALUE_10 = rep_value_10;
	}

	public String getREP_VALUE_11() {
		return REP_VALUE_11;
	}

	public void setREP_VALUE_11(String rep_value_11) {
		REP_VALUE_11 = rep_value_11;
	}

	public String getREP_VALUE_12() {
		return REP_VALUE_12;
	}

	public void setREP_VALUE_12(String rep_value_12) {
		REP_VALUE_12 = rep_value_12;
	}

	public String getREP_VALUE_13() {
		return REP_VALUE_13;
	}

	public void setREP_VALUE_13(String rep_value_13) {
		REP_VALUE_13 = rep_value_13;
	}

	public String getREP_VALUE_14() {
		return REP_VALUE_14;
	}

	public void setREP_VALUE_14(String rep_value_14) {
		REP_VALUE_14 = rep_value_14;
	}

	public String getREP_VALUE_15() {
		return REP_VALUE_15;
	}

	public void setREP_VALUE_15(String rep_value_15) {
		REP_VALUE_15 = rep_value_15;
	}

	public String getREP_VALUE_16() {
		return REP_VALUE_16;
	}

	public void setREP_VALUE_16(String rep_value_16) {
		REP_VALUE_16 = rep_value_16;
	}

	public String getREP_VALUE_17() {
		return REP_VALUE_17;
	}

	public void setREP_VALUE_17(String rep_value_17) {
		REP_VALUE_17 = rep_value_17;
	}

	public String getREP_VALUE_18() {
		return REP_VALUE_18;
	}

	public void setREP_VALUE_18(String rep_value_18) {
		REP_VALUE_18 = rep_value_18;
	}

	public String getREP_VALUE_19() {
		return REP_VALUE_19;
	}

	public void setREP_VALUE_19(String rep_value_19) {
		REP_VALUE_19 = rep_value_19;
	}

	public String getREP_VALUE_20() {
		return REP_VALUE_20;
	}

	public void setREP_VALUE_20(String rep_value_20) {
		REP_VALUE_20 = rep_value_20;
	}

	public String getREP_VALUE_21() {
		return REP_VALUE_21;
	}

	public void setREP_VALUE_21(String rep_value_21) {
		REP_VALUE_21 = rep_value_21;
	}

	public String getREP_VALUE_22() {
		return REP_VALUE_22;
	}

	public void setREP_VALUE_22(String rep_value_22) {
		REP_VALUE_22 = rep_value_22;
	}

	public String getREP_VALUE_23() {
		return REP_VALUE_23;
	}

	public void setREP_VALUE_23(String rep_value_23) {
		REP_VALUE_23 = rep_value_23;
	}

	public String getREP_VALUE_24() {
		return REP_VALUE_24;
	}

	public void setREP_VALUE_24(String rep_value_24) {
		REP_VALUE_24 = rep_value_24;
	}

	public String getREP_VALUE_25() {
		return REP_VALUE_25;
	}

	public void setREP_VALUE_25(String rep_value_25) {
		REP_VALUE_25 = rep_value_25;
	}

	public String getREP_VALUE_26() {
		return REP_VALUE_26;
	}

	public void setREP_VALUE_26(String rep_value_26) {
		REP_VALUE_26 = rep_value_26;
	}

	public String getREP_VALUE_27() {
		return REP_VALUE_27;
	}

	public void setREP_VALUE_27(String rep_value_27) {
		REP_VALUE_27 = rep_value_27;
	}

	public String getREP_VALUE_28() {
		return REP_VALUE_28;
	}

	public void setREP_VALUE_28(String rep_value_28) {
		REP_VALUE_28 = rep_value_28;
	}

	public String getREP_VALUE_29() {
		return REP_VALUE_29;
	}

	public void setREP_VALUE_29(String rep_value_29) {
		REP_VALUE_29 = rep_value_29;
	}

	public String getREP_VALUE_30() {
		return REP_VALUE_30;
	}

	public void setREP_VALUE_30(String rep_value_30) {
		REP_VALUE_30 = rep_value_30;
	}

	public String getREP_VALUE_31() {
		return REP_VALUE_31;
	}

	public void setREP_VALUE_31(String rep_value_31) {
		REP_VALUE_31 = rep_value_31;
	}

	public String getREP_VALUE_32() {
		return REP_VALUE_32;
	}

	public void setREP_VALUE_32(String rep_value_32) {
		REP_VALUE_32 = rep_value_32;
	}

	public String getREP_VALUE_33() {
		return REP_VALUE_33;
	}

	public void setREP_VALUE_33(String rep_value_33) {
		REP_VALUE_33 = rep_value_33;
	}

	public String getREP_VALUE_34() {
		return REP_VALUE_34;
	}

	public void setREP_VALUE_34(String rep_value_34) {
		REP_VALUE_34 = rep_value_34;
	}

	public String getREP_VALUE_35() {
		return REP_VALUE_35;
	}

	public void setREP_VALUE_35(String rep_value_35) {
		REP_VALUE_35 = rep_value_35;
	}

	public String getREP_VALUE_36() {
		return REP_VALUE_36;
	}

	public void setREP_VALUE_36(String rep_value_36) {
		REP_VALUE_36 = rep_value_36;
	}

	public String getREP_VALUE_37() {
		return REP_VALUE_37;
	}

	public void setREP_VALUE_37(String rep_value_37) {
		REP_VALUE_37 = rep_value_37;
	}

	public String getREP_VALUE_38() {
		return REP_VALUE_38;
	}

	public void setREP_VALUE_38(String rep_value_38) {
		REP_VALUE_38 = rep_value_38;
	}

	public String getREP_VALUE_39() {
		return REP_VALUE_39;
	}

	public void setREP_VALUE_39(String rep_value_39) {
		REP_VALUE_39 = rep_value_39;
	}

	public String getREP_VALUE_40() {
		return REP_VALUE_40;
	}

	public void setREP_VALUE_40(String rep_value_40) {
		REP_VALUE_40 = rep_value_40;
	}

	public String getREP_VALUE_41() {
		return REP_VALUE_41;
	}

	public void setREP_VALUE_41(String rep_value_41) {
		REP_VALUE_41 = rep_value_41;
	}

	public String getREP_VALUE_42() {
		return REP_VALUE_42;
	}

	public void setREP_VALUE_42(String rep_value_42) {
		REP_VALUE_42 = rep_value_42;
	}

	public String getREP_VALUE_43() {
		return REP_VALUE_43;
	}

	public void setREP_VALUE_43(String rep_value_43) {
		REP_VALUE_43 = rep_value_43;
	}

	public String getREP_VALUE_44() {
		return REP_VALUE_44;
	}

	public void setREP_VALUE_44(String rep_value_44) {
		REP_VALUE_44 = rep_value_44;
	}

	public String getREP_VALUE_45() {
		return REP_VALUE_45;
	}

	public void setREP_VALUE_45(String rep_value_45) {
		REP_VALUE_45 = rep_value_45;
	}

	public String getREP_VALUE_46() {
		return REP_VALUE_46;
	}

	public void setREP_VALUE_46(String rep_value_46) {
		REP_VALUE_46 = rep_value_46;
	}

	public String getREP_VALUE_47() {
		return REP_VALUE_47;
	}

	public void setREP_VALUE_47(String rep_value_47) {
		REP_VALUE_47 = rep_value_47;
	}

	public String getREP_VALUE_48() {
		return REP_VALUE_48;
	}

	public void setREP_VALUE_48(String rep_value_48) {
		REP_VALUE_48 = rep_value_48;
	}

	public String getREP_VALUE_49() {
		return REP_VALUE_49;
	}

	public void setREP_VALUE_49(String rep_value_49) {
		REP_VALUE_49 = rep_value_49;
	}

	public String getREP_VALUE_50() {
		return REP_VALUE_50;
	}

	public void setREP_VALUE_50(String rep_value_50) {
		REP_VALUE_50 = rep_value_50;
	}

	public String getREP_VALUE_51() {
		return REP_VALUE_51;
	}

	public void setREP_VALUE_51(String rep_value_51) {
		REP_VALUE_51 = rep_value_51;
	}

	public String getREP_VALUE_52() {
		return REP_VALUE_52;
	}

	public void setREP_VALUE_52(String rep_value_52) {
		REP_VALUE_52 = rep_value_52;
	}

	public String getREP_VALUE_53() {
		return REP_VALUE_53;
	}

	public void setREP_VALUE_53(String rep_value_53) {
		REP_VALUE_53 = rep_value_53;
	}

	public String getREP_VALUE_54() {
		return REP_VALUE_54;
	}

	public void setREP_VALUE_54(String rep_value_54) {
		REP_VALUE_54 = rep_value_54;
	}

	public String getREP_VALUE_55() {
		return REP_VALUE_55;
	}

	public void setREP_VALUE_55(String rep_value_55) {
		REP_VALUE_55 = rep_value_55;
	}

	public String getREP_VALUE_56() {
		return REP_VALUE_56;
	}

	public void setREP_VALUE_56(String rep_value_56) {
		REP_VALUE_56 = rep_value_56;
	}

	public String getREP_VALUE_57() {
		return REP_VALUE_57;
	}

	public void setREP_VALUE_57(String rep_value_57) {
		REP_VALUE_57 = rep_value_57;
	}

	public String getREP_VALUE_58() {
		return REP_VALUE_58;
	}

	public void setREP_VALUE_58(String rep_value_58) {
		REP_VALUE_58 = rep_value_58;
	}

	public String getREP_VALUE_59() {
		return REP_VALUE_59;
	}

	public void setREP_VALUE_59(String rep_value_59) {
		REP_VALUE_59 = rep_value_59;
	}

	public String getREP_VALUE_60() {
		return REP_VALUE_60;
	}

	public void setREP_VALUE_60(String rep_value_60) {
		REP_VALUE_60 = rep_value_60;
	}

	public String getREP_CR_UID() {
		return REP_CR_UID;
	}

	public void setREP_CR_UID(String rep_cr_uid) {
		REP_CR_UID = rep_cr_uid;
	}

	public Date getREP_CR_DT() {
		return REP_CR_DT;
	}

	public void setREP_CR_DT(Date rep_cr_dt) {
		REP_CR_DT = rep_cr_dt;
	}

	public Date getREP_UPD_DT() {
		return REP_UPD_DT;
	}

	public void setREP_UPD_DT(Date rep_upd_dt) {
		REP_UPD_DT = rep_upd_dt;
	}

	public String getREP_UPD_UID() {
		return REP_UPD_UID;
	}

	public void setREP_UPD_UID(String rep_upd_uid) {
		REP_UPD_UID = rep_upd_uid;
	}

	public Date getFROM_DATE() {
		return FROM_DATE;
	}

	public void setFROM_DATE(Date from_date) {
		FROM_DATE = from_date;
	}

	public Date getTO_DATE() {
		return TO_DATE;
	}

	public void setTO_DATE(Date to_date) {
		TO_DATE = to_date;
	}

	public String getUI_M_FROM_DIVN_DESC() {
		return UI_M_FROM_DIVN_DESC;
	}

	public void setUI_M_FROM_DIVN_DESC(String ui_m_from_divn_desc) {
		UI_M_FROM_DIVN_DESC = ui_m_from_divn_desc;
	}

	public String getUI_M_TO_DIVN_DESC() {
		return UI_M_TO_DIVN_DESC;
	}

	public void setUI_M_TO_DIVN_DESC(String ui_m_to_divn_desc) {
		UI_M_TO_DIVN_DESC = ui_m_to_divn_desc;
	}

	public String getUI_M_FROM_DEPT_DESC() {
		return UI_M_FROM_DEPT_DESC;
	}

	public void setUI_M_FROM_DEPT_DESC(String ui_m_from_dept_desc) {
		UI_M_FROM_DEPT_DESC = ui_m_from_dept_desc;
	}

	public String getUI_M_TO_DEPT_DESC() {
		return UI_M_TO_DEPT_DESC;
	}

	public void setUI_M_TO_DEPT_DESC(String ui_m_to_dept_desc) {
		UI_M_TO_DEPT_DESC = ui_m_to_dept_desc;
	}

	public String getUI_M_FROM_CLASS_DESC() {
		return UI_M_FROM_CLASS_DESC;
	}

	public void setUI_M_FROM_CLASS_DESC(String ui_m_from_class_desc) {
		UI_M_FROM_CLASS_DESC = ui_m_from_class_desc;
	}

	public String getUI_M_TO_CLASS_DESC() {
		return UI_M_TO_CLASS_DESC;
	}

	public void setUI_M_TO_CLASS_DESC(String ui_m_to_class_desc) {
		UI_M_TO_CLASS_DESC = ui_m_to_class_desc;
	}

	public String getUI_M_FROM_PLAN_DESC() {
		return UI_M_FROM_PLAN_DESC;
	}

	public void setUI_M_FROM_PLAN_DESC(String ui_m_from_plan_desc) {
		UI_M_FROM_PLAN_DESC = ui_m_from_plan_desc;
	}

	public String getUI_M_TO_PLAN_DESC() {
		return UI_M_TO_PLAN_DESC;
	}

	public void setUI_M_TO_PLAN_DESC(String ui_m_to_plan_desc) {
		UI_M_TO_PLAN_DESC = ui_m_to_plan_desc;
	}

	public String getSelectedFileType() {
		return selectedFileType;
	}

	public void setSelectedFileType(String selectedFileType) {
		this.selectedFileType = selectedFileType;
	}

	public String getREP_VALUE_1() {
		/*
		 * DateFormat format=new SimpleDateFormat(PELConstants.pelDateFormat);
		 * String dateString=format.format(REP_VALUE_1);
		 * System.out.println("Date String :"+dateString); try {
		 * REP_VALUE_1=format.parse(dateString); } catch (ParseException e) {
		 * e.printStackTrace(); }
		 */
		return REP_VALUE_1;
	}

	public void setREP_VALUE_1(String rep_value_1) {
		/*
		 * DateFormat format=new SimpleDateFormat(PELConstants.dbDateFormat);
		 * String dateString=format.format(rep_value_1);
		 * System.out.println("Date String :"+dateString); try {
		 * REP_VALUE_1=format.parse(dateString); } catch (ParseException e) {
		 * 
		 * e.printStackTrace(); } System.out.println("Date REP_VALUE_1
		 * :"+REP_VALUE_1);
		 */
		REP_VALUE_1 = rep_value_1;
	}

	public String getREP_VALUE_2() {
		/*
		 * DateFormat format=new SimpleDateFormat(PELConstants.pelDateFormat);
		 * String dateString=format.format(REP_VALUE_2);
		 * System.out.println("Date String :"+dateString); try {
		 * REP_VALUE_2=format.parse(dateString); } catch (ParseException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		return REP_VALUE_2;
	}

	public void setREP_VALUE_2(String rep_value_2) {
		/*
		 * DateFormat format=new SimpleDateFormat(PELConstants.dbDateFormat);
		 * String dateString=format.format(rep_value_2);
		 * System.out.println("Date String :"+dateString); try {
		 * REP_VALUE_2=format.parse(dateString); } catch (ParseException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		System.out.println("Date  REP_VALUE_2 :" + REP_VALUE_2);
		REP_VALUE_2 = rep_value_2;
	}

	public String getUI_M_FROM_BRANCH_DESC() {
		return UI_M_FROM_BRANCH_DESC;
	}

	public void setUI_M_FROM_BRANCH_DESC(String ui_m_from_branch_desc) {
		UI_M_FROM_BRANCH_DESC = ui_m_from_branch_desc;
	}

	public String getUI_M_TO_BRANCH_DESC() {
		return UI_M_TO_BRANCH_DESC;
	}

	public void setUI_M_TO_BRANCH_DESC(String ui_m_to_branch_desc) {
		UI_M_TO_BRANCH_DESC = ui_m_to_branch_desc;
	}

	public String getUI_M_FROM_CLAIM_NO_DESC() {
		return UI_M_FROM_CLAIM_NO_DESC;
	}

	public void setUI_M_FROM_CLAIM_NO_DESC(String ui_m_from_claim_no_desc) {
		UI_M_FROM_CLAIM_NO_DESC = ui_m_from_claim_no_desc;
	}

	public String getUI_M_TO_CLAIM_NO_DESC() {
		return UI_M_TO_CLAIM_NO_DESC;
	}

	public void setUI_M_TO_CLAIM_NO_DESC(String ui_m_to_claim_no_desc) {
		UI_M_TO_CLAIM_NO_DESC = ui_m_to_claim_no_desc;
	}

	public String getUI_M_FROM_CLAIM_TYPE_DESC() {
		return UI_M_FROM_CLAIM_TYPE_DESC;
	}

	public void setUI_M_FROM_CLAIM_TYPE_DESC(String ui_m_from_claim_type_desc) {
		UI_M_FROM_CLAIM_TYPE_DESC = ui_m_from_claim_type_desc;
	}

	public String getUI_M_TO_CLAIM_TYPE_DESC() {
		return UI_M_TO_CLAIM_TYPE_DESC;
	}

	public void setUI_M_TO_CLAIM_TYPE_DESC(String ui_m_to_claim_type_desc) {
		UI_M_TO_CLAIM_TYPE_DESC = ui_m_to_claim_type_desc;
	}

	public String getBROKER_CODE_FROM_DESC() {
		return BROKER_CODE_FROM_DESC;
	}

	public void setBROKER_CODE_FROM_DESC(String broker_code_from_desc) {
		BROKER_CODE_FROM_DESC = broker_code_from_desc;
	}

	public String getBROKER_CODE_TO_DESC() {
		return BROKER_CODE_TO_DESC;
	}

	public void setBROKER_CODE_TO_DESC(String broker_code_to_desc) {
		BROKER_CODE_TO_DESC = broker_code_to_desc;
	}

}
