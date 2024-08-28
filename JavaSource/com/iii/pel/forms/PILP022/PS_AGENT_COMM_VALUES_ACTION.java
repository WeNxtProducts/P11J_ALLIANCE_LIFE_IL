package com.iii.pel.forms.PILP022;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;
import org.richfaces.component.html.HtmlPanel;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;
/**
 * 
 * @author 52017
 * This Class Is written Exclusively For PREMIAGDC-327842
 */
public class PS_AGENT_COMM_VALUES_ACTION {
	
	private HtmlOutputLabel COMP_PS_DATE_LABEL;
	
	private HtmlCalendar COMP_PS_DATE;
	
	private HtmlOutputLabel COMP_PS_POL_NO_LABEL;
	
	private HtmlInputText COMP_PS_POL_NO;
	
	private HtmlOutputLabel COMP_PS_END_NO_IDX_LABEL;
	
	private HtmlInputText   COMP_PS_END_NO_IDX;
	
	private HtmlOutputLabel COMP_PS_POL_END_CODE_LABEL;
	
	private HtmlInputText COMP_PS_POL_END_CODE;
	
	private HtmlOutputLabel  COMP_PS_POL_COVER_CODE_LABEL; 
	
	private HtmlInputText COMP_PS_POL_COVER_CODE;
	
	private HtmlOutputLabel COMP_PS_POL_COVER_DESC_LABEL;
	
	private HtmlInputText COMP_PS_POL_COVER_DESC;
	
	private HtmlOutputLabel COMP_PS_POL_ASSURED_NAME_LABEL;
	
	private HtmlInputText COMP_PS_POL_ASSURED_NAME;
	
	private HtmlOutputLabel COMP_PS_POL_COMM_PREM_LC_AMT_LABEL;
	
	private HtmlInputText COMP_PS_POL_COMM_PREM_LC_AMT;
	
	private HtmlOutputLabel COMP_PS_AGENT_CODE_LABEL;
	
	private HtmlInputText COMP_PS_AGENT_CODE;
	
	private HtmlOutputLabel COMP_PS_AGENT_RANK_CODE_LABEL;
	
	private HtmlInputText COMP_PS_AGENT_RANK_CODE;
	
	private HtmlOutputLabel COMP_PS_POL_COMM_TYPE_LABEL;
	
	private HtmlInputText COMP_PS_POL_COMM_TYPE;
	
	private HtmlOutputLabel COMP_PS_LC_AMT_LABEL;
	
	private HtmlInputText COMP_PS_LC_AMT;
	
	private HtmlPanel PANEL_PROCESS_DETAILS;
	
	private Boolean renderedFlag;
	
	private PS_AGENT_COMM_VALUES  PS_AGENT_COMM_VALUES_BEAN; 
	
	private List<PS_AGENT_COMM_VALUES>dataListPS_AGENT_COMM_VALUES= new ArrayList<PS_AGENT_COMM_VALUES>();
	
	private UIDataTable dataTable;
	
	CRUDHandler handler = new CRUDHandler();

	public PILP022_COMPOSITE_ACTION compositeAction;
	
	public PS_AGENT_COMM_VALUES_ACTION(){
		PS_AGENT_COMM_VALUES_BEAN = new PS_AGENT_COMM_VALUES();
	}
	
	public HtmlOutputLabel getCOMP_PS_DATE_LABEL() {
		return COMP_PS_DATE_LABEL;
	}
	public void setCOMP_PS_DATE_LABEL(HtmlOutputLabel comp_ps_date_label) {
		COMP_PS_DATE_LABEL = comp_ps_date_label;
	}
	public HtmlCalendar getCOMP_PS_DATE() {
		return COMP_PS_DATE;
	}
	public void setCOMP_PS_DATE(HtmlCalendar comp_ps_date) {
		COMP_PS_DATE = comp_ps_date;
	}
	public HtmlOutputLabel getCOMP_PS_POL_NO_LABEL() {
		return COMP_PS_POL_NO_LABEL;
	}
	public void setCOMP_PS_POL_NO_LABEL(HtmlOutputLabel comp_ps_pol_no_label) {
		COMP_PS_POL_NO_LABEL = comp_ps_pol_no_label;
	}
	public HtmlInputText getCOMP_PS_POL_NO() {
		return COMP_PS_POL_NO;
	}
	public void setCOMP_PS_POL_NO(HtmlInputText comp_ps_pol_no) {
		COMP_PS_POL_NO = comp_ps_pol_no;
	}
	public HtmlOutputLabel getCOMP_PS_END_NO_IDX_LABEL() {
		return COMP_PS_END_NO_IDX_LABEL;
	}
	public void setCOMP_PS_END_NO_IDX_LABEL(HtmlOutputLabel comp_ps_end_no_idx_label) {
		COMP_PS_END_NO_IDX_LABEL = comp_ps_end_no_idx_label;
	}
	public HtmlInputText getCOMP_PS_END_NO_IDX() {
		return COMP_PS_END_NO_IDX;
	}
	public void setCOMP_PS_END_NO_IDX(HtmlInputText comp_ps_end_no_idx) {
		COMP_PS_END_NO_IDX = comp_ps_end_no_idx;
	}
	public HtmlOutputLabel getCOMP_PS_POL_END_CODE_LABEL() {
		return COMP_PS_POL_END_CODE_LABEL;
	}
	public void setCOMP_PS_POL_END_CODE_LABEL(
			HtmlOutputLabel comp_ps_pol_end_code_label) {
		COMP_PS_POL_END_CODE_LABEL = comp_ps_pol_end_code_label;
	}
	public HtmlInputText getCOMP_PS_POL_END_CODE() {
		return COMP_PS_POL_END_CODE;
	}
	public void setCOMP_PS_POL_END_CODE(HtmlInputText comp_ps_pol_end_code) {
		COMP_PS_POL_END_CODE = comp_ps_pol_end_code;
	}
	public HtmlOutputLabel getCOMP_PS_POL_COVER_DESC_LABEL() {
		return COMP_PS_POL_COVER_DESC_LABEL;
	}
	public void setCOMP_PS_POL_COVER_DESC_LABEL(
			HtmlOutputLabel comp_ps_pol_cover_desc_label) {
		COMP_PS_POL_COVER_DESC_LABEL = comp_ps_pol_cover_desc_label;
	}
	public HtmlInputText getCOMP_PS_POL_COVER_DESC() {
		return COMP_PS_POL_COVER_DESC;
	}
	public void setCOMP_PS_POL_COVER_DESC(HtmlInputText comp_ps_pol_cover_desc) {
		COMP_PS_POL_COVER_DESC = comp_ps_pol_cover_desc;
	}
	public HtmlOutputLabel getCOMP_PS_POL_ASSURED_NAME_LABEL() {
		return COMP_PS_POL_ASSURED_NAME_LABEL;
	}
	public void setCOMP_PS_POL_ASSURED_NAME_LABEL(
			HtmlOutputLabel comp_ps_pol_assured_name_label) {
		COMP_PS_POL_ASSURED_NAME_LABEL = comp_ps_pol_assured_name_label;
	}
	public HtmlInputText getCOMP_PS_POL_ASSURED_NAME() {
		return COMP_PS_POL_ASSURED_NAME;
	}
	public void setCOMP_PS_POL_ASSURED_NAME(HtmlInputText comp_ps_pol_assured_name) {
		COMP_PS_POL_ASSURED_NAME = comp_ps_pol_assured_name;
	}
	public HtmlOutputLabel getCOMP_PS_POL_COMM_PREM_LC_AMT_LABEL() {
		return COMP_PS_POL_COMM_PREM_LC_AMT_LABEL;
	}
	public void setCOMP_PS_POL_COMM_PREM_LC_AMT_LABEL(
			HtmlOutputLabel comp_ps_pol_comm_prem_lc_amt_label) {
		COMP_PS_POL_COMM_PREM_LC_AMT_LABEL = comp_ps_pol_comm_prem_lc_amt_label;
	}
	public HtmlInputText getCOMP_PS_POL_COMM_PREM_LC_AMT() {
		return COMP_PS_POL_COMM_PREM_LC_AMT;
	}
	public void setCOMP_PS_POL_COMM_PREM_LC_AMT(
			HtmlInputText comp_ps_pol_comm_prem_lc_amt) {
		COMP_PS_POL_COMM_PREM_LC_AMT = comp_ps_pol_comm_prem_lc_amt;
	}
	public HtmlOutputLabel getCOMP_PS_AGENT_CODE_LABEL() {
		return COMP_PS_AGENT_CODE_LABEL;
	}
	public void setCOMP_PS_AGENT_CODE_LABEL(HtmlOutputLabel comp_ps_agent_code_label) {
		COMP_PS_AGENT_CODE_LABEL = comp_ps_agent_code_label;
	}
	public HtmlInputText getCOMP_PS_AGENT_CODE() {
		return COMP_PS_AGENT_CODE;
	}
	public void setCOMP_PS_AGENT_CODE(HtmlInputText comp_ps_agent_code) {
		COMP_PS_AGENT_CODE = comp_ps_agent_code;
	}
	public HtmlOutputLabel getCOMP_PS_AGENT_RANK_CODE_LABEL() {
		return COMP_PS_AGENT_RANK_CODE_LABEL;
	}
	public void setCOMP_PS_AGENT_RANK_CODE_LABEL(
			HtmlOutputLabel comp_ps_agent_rank_code_label) {
		COMP_PS_AGENT_RANK_CODE_LABEL = comp_ps_agent_rank_code_label;
	}
	public HtmlInputText getCOMP_PS_AGENT_RANK_CODE() {
		return COMP_PS_AGENT_RANK_CODE;
	}
	public void setCOMP_PS_AGENT_RANK_CODE(HtmlInputText comp_ps_agent_rank_code) {
		COMP_PS_AGENT_RANK_CODE = comp_ps_agent_rank_code;
	}
	public HtmlOutputLabel getCOMP_PS_POL_COMM_TYPE_LABEL() {
		return COMP_PS_POL_COMM_TYPE_LABEL;
	}
	public void setCOMP_PS_POL_COMM_TYPE_LABEL(
			HtmlOutputLabel comp_ps_pol_comm_type_label) {
		COMP_PS_POL_COMM_TYPE_LABEL = comp_ps_pol_comm_type_label;
	}
	public HtmlInputText getCOMP_PS_POL_COMM_TYPE() {
		return COMP_PS_POL_COMM_TYPE;
	}
	public void setCOMP_PS_POL_COMM_TYPE(HtmlInputText comp_ps_pol_comm_type) {
		COMP_PS_POL_COMM_TYPE = comp_ps_pol_comm_type;
	}
	public HtmlOutputLabel getCOMP_PS_LC_AMT_LABEL() {
		return COMP_PS_LC_AMT_LABEL;
	}
	public void setCOMP_PS_LC_AMT_LABEL(HtmlOutputLabel comp_ps_lc_amt_label) {
		COMP_PS_LC_AMT_LABEL = comp_ps_lc_amt_label;
	}
	public HtmlInputText getCOMP_PS_LC_AMT() {
		return COMP_PS_LC_AMT;
	}
	public void setCOMP_PS_LC_AMT(HtmlInputText comp_ps_lc_amt) {
		COMP_PS_LC_AMT = comp_ps_lc_amt;
	}

	public PS_AGENT_COMM_VALUES getPS_AGENT_COMM_VALUES_BEAN() {
		return PS_AGENT_COMM_VALUES_BEAN;
	}

	public void setPS_AGENT_COMM_VALUES_BEAN(
			PS_AGENT_COMM_VALUES ps_agent_comm_values_bean) {
		PS_AGENT_COMM_VALUES_BEAN = ps_agent_comm_values_bean;
	}

	public HtmlOutputLabel getCOMP_PS_POL_COVER_CODE_LABEL() {
		return COMP_PS_POL_COVER_CODE_LABEL;
	}

	public void setCOMP_PS_POL_COVER_CODE_LABEL(
			HtmlOutputLabel comp_ps_pol_cover_code_label) {
		COMP_PS_POL_COVER_CODE_LABEL = comp_ps_pol_cover_code_label;
	}

	public HtmlInputText getCOMP_PS_POL_COVER_CODE() {
		return COMP_PS_POL_COVER_CODE;
	}

	public void setCOMP_PS_POL_COVER_CODE(HtmlInputText comp_ps_pol_cover_code) {
		COMP_PS_POL_COVER_CODE = comp_ps_pol_cover_code;
	}

	public List<PS_AGENT_COMM_VALUES> getDataListPS_AGENT_COMM_VALUES() {
		return dataListPS_AGENT_COMM_VALUES;
	}

	public void setDataListPS_AGENT_COMM_VALUES(
			List<PS_AGENT_COMM_VALUES> dataListPS_AGENT_COMM_VALUES) {
		this.dataListPS_AGENT_COMM_VALUES = dataListPS_AGENT_COMM_VALUES;
	}

	public UIDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(UIDataTable dataTable) {
		this.dataTable = dataTable;
	}
	
	public void populateAgentCommissionValues() throws Exception{
		ResultSet rs = null;
		try {
			String P_FM_AGENT_CODE = compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_AGENT_CODE_FM();
			String P_TO_AGENT_CODE = compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_AGENT_CODE_TO();
			String P_AGENCY_FM = compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_AGENCY_CODE_FM();
			String P_AGENCY_TO = compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_AGENCY_CODE_TO();
			String P_FM_UNIT_CODE =compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_UNIT_CODE_FM();
			String P_TO_UNIT_CODE =compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_UNIT_CODE_TO();
			String P_FM_DT = CommonUtils.dateToStringFormatter(compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_FM_DT());
			String P_TO_DT = CommonUtils.dateToStringFormatter(compositeAction.getPT_AGENT_ACTION_BEAN().getPT_AGENT_BEAN().getUI_M_TO_DT());
			
			PS_AGENT_COMM_VALUES  valueBean;
			String Query = "SELECT  * FROM    PS_AGENT_COMM_VALUES WHERE   PS_AGENT_CODE BETWEEN NVL (?, '0')" 
			  + "AND NVL (?, 'ZZZZZZZZZZ') AND     PS_AGENT_AGENCY_CODE BETWEEN NVL (?, '0')"
			  + "AND NVL (?, 'ZZZZZZZZZZ') AND     PS_AGENT_UNIT_CODE  BETWEEN NVL (?, '0')"
			  + "AND NVL (?, 'ZZZZZZZZZZ') AND     PS_DATE BETWEEN TO_DATE(?,'DD-MON-YYYY')"
			  + "AND     TO_DATE(?,'DD-MON-YYYY')";
			rs = handler.executeSelectStatement(Query,CommonUtils.getConnection(),new Object[]{P_FM_AGENT_CODE,P_TO_AGENT_CODE,P_AGENCY_FM,P_AGENCY_TO,P_FM_UNIT_CODE,P_TO_UNIT_CODE,P_FM_DT,P_TO_DT});
			while(rs.next()){
				valueBean = new PS_AGENT_COMM_VALUES();
				valueBean.setPS_AGENT_CODE(rs.getString("PS_AGENT_CODE"));
				valueBean.setPS_AGENT_RANK_CODE(rs.getString("PS_AGENT_RANK_CODE"));
				valueBean.setPS_DATE(rs.getDate("PS_DATE"));
				valueBean.setPS_END_NO_IDX(rs.getLong("PS_END_NO_IDX"));
				valueBean.setPS_LC_AMT(rs.getDouble("PS_LC_AMT"));
				valueBean.setPS_POL_ASSURED_NAME(rs.getString("PS_POL_ASSURED_NAME"));
				valueBean.setPS_POL_COMM_PREM_LC_AMT(rs.getDouble("PS_POL_COMM_PREM_LC_AMT"));
				valueBean.setPS_POL_COMM_TYPE(rs.getString("PS_POL_COMM_TYPE"));
				valueBean.setPS_POL_COVER_CODE(rs.getString("PS_POL_COVER_CODE"));
				valueBean.setPS_POL_COVER_DESC(rs.getString("PS_POL_COVER_DESC"));
				valueBean.setPS_POL_END_CODE(rs.getString("PS_POL_END_CODE"));
				valueBean.setPS_POL_NO(rs.getString("PS_POL_NO"));
				dataListPS_AGENT_COMM_VALUES.add(valueBean);
			}
			if(dataListPS_AGENT_COMM_VALUES.size()>0){
				setRenderedFlag(true);
			}else{
				setRenderedFlag(false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		} catch (DBException e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	public HtmlPanel getPANEL_PROCESS_DETAILS() {
		return PANEL_PROCESS_DETAILS;
	}

	public void setPANEL_PROCESS_DETAILS(HtmlPanel panel_process_details) {
		PANEL_PROCESS_DETAILS = panel_process_details;
	}

	public Boolean getRenderedFlag() {
		return renderedFlag;
	}

	public void setRenderedFlag(Boolean renderedFlag) {
		this.renderedFlag = renderedFlag;
	}
}
