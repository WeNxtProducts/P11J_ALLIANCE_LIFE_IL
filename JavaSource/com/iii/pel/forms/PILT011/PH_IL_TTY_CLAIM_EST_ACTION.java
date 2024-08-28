package com.iii.pel.forms.PILT011;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;

import org.richfaces.component.UIDataTable;
import org.richfaces.component.html.HtmlCalendar;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.pel.forms.PILT002_APAC.PT_IL_POL_BROKER_HEAD;
import com.iii.premia.common.action.CommonAction;
import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.utils.CommonUtils;

public class PH_IL_TTY_CLAIM_EST_ACTION extends CommonAction{

	private HtmlOutputLabel COMP_TCEH_CCD_RESERVE_NO_LABEL;

	private HtmlInputText COMP_TCEH_CCD_RESERVE_NO;

	private HtmlOutputLabel COMP_TCEH_TREATY_CODE_LABEL;

	private HtmlInputText COMP_TCEH_TREATY_CODE;

	private HtmlOutputLabel COMP_TCEH_UW_YEAR_LABEL;

	private HtmlInputText COMP_TCEH_UW_YEAR;

	private HtmlOutputLabel COMP_TCEH_CLAIM_LOSS_DT_LABEL;

	private HtmlCalendar COMP_TCEH_CLAIM_LOSS_DT;

	private HtmlOutputLabel COMP_TCEH_O_RETN_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCEH_O_RETN_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCEH_O_QS_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCEH_O_QS_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCEH_O_1S_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCEH_O_1S_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCEH_O_2S_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCEH_O_2S_LC_CLM_EST;

	private HtmlOutputLabel COMP_TCEH_O_3S_LC_CLM_EST_LABEL;

	private HtmlInputText COMP_TCEH_O_3S_LC_CLM_EST;

	private HtmlOutputLabel COMP_TECH_O_CCD_RESERVE_DT_LABEL;

	private HtmlCalendar COMP_TECH_O_CCD_RESERVE_DT;

	private HtmlCommandButton COMP_UI_M_BUT_MAIN;

	private PH_IL_TTY_CLAIM_EST PH_IL_TTY_CLAIM_EST_BEAN;
	
	public PILT011_COMPOSITE_ACTION compositeAction;
	
	private PH_IL_TTY_CLAIM_EST_HELPER helper= new PH_IL_TTY_CLAIM_EST_HELPER();
	
	private CRUDHandler handler;
	private UIDataTable ttyDataTable;
	private List<PH_IL_TTY_CLAIM_EST> dataList = new ArrayList<PH_IL_TTY_CLAIM_EST>();
	private Map session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
	String query;
	private HtmlSelectBooleanCheckbox checkBox;
	

	public PH_IL_TTY_CLAIM_EST_ACTION() {
		PH_IL_TTY_CLAIM_EST_BEAN = new PH_IL_TTY_CLAIM_EST();
		handler = new CRUDHandler();
		
		//PH_IL_TTY_CLAIM_EST_PRE_QUERY();
		//PH_IL_TTY_CLAIM_EST_WHEN_NEW_BLOCK_INSTANCE();
	}
	
	public HtmlSelectBooleanCheckbox getCheckBox() {
		return checkBox;
	}
	
	public void setCheckBox(HtmlSelectBooleanCheckbox checkBox) {
		this.checkBox = checkBox;
	}

	public HtmlOutputLabel getCOMP_TCEH_CCD_RESERVE_NO_LABEL() {
		return COMP_TCEH_CCD_RESERVE_NO_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_CCD_RESERVE_NO() {
		return COMP_TCEH_CCD_RESERVE_NO;
	}

	public void setCOMP_TCEH_CCD_RESERVE_NO_LABEL(HtmlOutputLabel COMP_TCEH_CCD_RESERVE_NO_LABEL) {
		this.COMP_TCEH_CCD_RESERVE_NO_LABEL = COMP_TCEH_CCD_RESERVE_NO_LABEL;
	}

	public void setCOMP_TCEH_CCD_RESERVE_NO(HtmlInputText COMP_TCEH_CCD_RESERVE_NO) {
		this.COMP_TCEH_CCD_RESERVE_NO = COMP_TCEH_CCD_RESERVE_NO;
	}

	public HtmlOutputLabel getCOMP_TCEH_TREATY_CODE_LABEL() {
		return COMP_TCEH_TREATY_CODE_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_TREATY_CODE() {
		return COMP_TCEH_TREATY_CODE;
	}

	public void setCOMP_TCEH_TREATY_CODE_LABEL(HtmlOutputLabel COMP_TCEH_TREATY_CODE_LABEL) {
		this.COMP_TCEH_TREATY_CODE_LABEL = COMP_TCEH_TREATY_CODE_LABEL;
	}

	public void setCOMP_TCEH_TREATY_CODE(HtmlInputText COMP_TCEH_TREATY_CODE) {
		this.COMP_TCEH_TREATY_CODE = COMP_TCEH_TREATY_CODE;
	}

	public HtmlOutputLabel getCOMP_TCEH_UW_YEAR_LABEL() {
		return COMP_TCEH_UW_YEAR_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_UW_YEAR() {
		return COMP_TCEH_UW_YEAR;
	}

	public void setCOMP_TCEH_UW_YEAR_LABEL(HtmlOutputLabel COMP_TCEH_UW_YEAR_LABEL) {
		this.COMP_TCEH_UW_YEAR_LABEL = COMP_TCEH_UW_YEAR_LABEL;
	}

	public void setCOMP_TCEH_UW_YEAR(HtmlInputText COMP_TCEH_UW_YEAR) {
		this.COMP_TCEH_UW_YEAR = COMP_TCEH_UW_YEAR;
	}

	public HtmlOutputLabel getCOMP_TCEH_CLAIM_LOSS_DT_LABEL() {
		return COMP_TCEH_CLAIM_LOSS_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TCEH_CLAIM_LOSS_DT() {
		return COMP_TCEH_CLAIM_LOSS_DT;
	}

	public void setCOMP_TCEH_CLAIM_LOSS_DT_LABEL(HtmlOutputLabel COMP_TCEH_CLAIM_LOSS_DT_LABEL) {
		this.COMP_TCEH_CLAIM_LOSS_DT_LABEL = COMP_TCEH_CLAIM_LOSS_DT_LABEL;
	}

	public void setCOMP_TCEH_CLAIM_LOSS_DT(HtmlCalendar COMP_TCEH_CLAIM_LOSS_DT) {
		this.COMP_TCEH_CLAIM_LOSS_DT = COMP_TCEH_CLAIM_LOSS_DT;
	}

	public HtmlOutputLabel getCOMP_TCEH_O_RETN_LC_CLM_EST_LABEL() {
		return COMP_TCEH_O_RETN_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_O_RETN_LC_CLM_EST() {
		return COMP_TCEH_O_RETN_LC_CLM_EST;
	}

	public void setCOMP_TCEH_O_RETN_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCEH_O_RETN_LC_CLM_EST_LABEL) {
		this.COMP_TCEH_O_RETN_LC_CLM_EST_LABEL = COMP_TCEH_O_RETN_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCEH_O_RETN_LC_CLM_EST(HtmlInputText COMP_TCEH_O_RETN_LC_CLM_EST) {
		this.COMP_TCEH_O_RETN_LC_CLM_EST = COMP_TCEH_O_RETN_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCEH_O_QS_LC_CLM_EST_LABEL() {
		return COMP_TCEH_O_QS_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_O_QS_LC_CLM_EST() {
		return COMP_TCEH_O_QS_LC_CLM_EST;
	}

	public void setCOMP_TCEH_O_QS_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCEH_O_QS_LC_CLM_EST_LABEL) {
		this.COMP_TCEH_O_QS_LC_CLM_EST_LABEL = COMP_TCEH_O_QS_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCEH_O_QS_LC_CLM_EST(HtmlInputText COMP_TCEH_O_QS_LC_CLM_EST) {
		this.COMP_TCEH_O_QS_LC_CLM_EST = COMP_TCEH_O_QS_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCEH_O_1S_LC_CLM_EST_LABEL() {
		return COMP_TCEH_O_1S_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_O_1S_LC_CLM_EST() {
		return COMP_TCEH_O_1S_LC_CLM_EST;
	}

	public void setCOMP_TCEH_O_1S_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCEH_O_1S_LC_CLM_EST_LABEL) {
		this.COMP_TCEH_O_1S_LC_CLM_EST_LABEL = COMP_TCEH_O_1S_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCEH_O_1S_LC_CLM_EST(HtmlInputText COMP_TCEH_O_1S_LC_CLM_EST) {
		this.COMP_TCEH_O_1S_LC_CLM_EST = COMP_TCEH_O_1S_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCEH_O_2S_LC_CLM_EST_LABEL() {
		return COMP_TCEH_O_2S_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_O_2S_LC_CLM_EST() {
		return COMP_TCEH_O_2S_LC_CLM_EST;
	}

	public void setCOMP_TCEH_O_2S_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCEH_O_2S_LC_CLM_EST_LABEL) {
		this.COMP_TCEH_O_2S_LC_CLM_EST_LABEL = COMP_TCEH_O_2S_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCEH_O_2S_LC_CLM_EST(HtmlInputText COMP_TCEH_O_2S_LC_CLM_EST) {
		this.COMP_TCEH_O_2S_LC_CLM_EST = COMP_TCEH_O_2S_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TCEH_O_3S_LC_CLM_EST_LABEL() {
		return COMP_TCEH_O_3S_LC_CLM_EST_LABEL;
	}

	public HtmlInputText getCOMP_TCEH_O_3S_LC_CLM_EST() {
		return COMP_TCEH_O_3S_LC_CLM_EST;
	}

	public void setCOMP_TCEH_O_3S_LC_CLM_EST_LABEL(HtmlOutputLabel COMP_TCEH_O_3S_LC_CLM_EST_LABEL) {
		this.COMP_TCEH_O_3S_LC_CLM_EST_LABEL = COMP_TCEH_O_3S_LC_CLM_EST_LABEL;
	}

	public void setCOMP_TCEH_O_3S_LC_CLM_EST(HtmlInputText COMP_TCEH_O_3S_LC_CLM_EST) {
		this.COMP_TCEH_O_3S_LC_CLM_EST = COMP_TCEH_O_3S_LC_CLM_EST;
	}

	public HtmlOutputLabel getCOMP_TECH_O_CCD_RESERVE_DT_LABEL() {
		return COMP_TECH_O_CCD_RESERVE_DT_LABEL;
	}

	public HtmlCalendar getCOMP_TECH_O_CCD_RESERVE_DT() {
		return COMP_TECH_O_CCD_RESERVE_DT;
	}

	public void setCOMP_TECH_O_CCD_RESERVE_DT_LABEL(HtmlOutputLabel COMP_TECH_O_CCD_RESERVE_DT_LABEL) {
		this.COMP_TECH_O_CCD_RESERVE_DT_LABEL = COMP_TECH_O_CCD_RESERVE_DT_LABEL;
	}

	public void setCOMP_TECH_O_CCD_RESERVE_DT(HtmlCalendar COMP_TECH_O_CCD_RESERVE_DT) {
		this.COMP_TECH_O_CCD_RESERVE_DT = COMP_TECH_O_CCD_RESERVE_DT;
	}

	public HtmlCommandButton getCOMP_UI_M_BUT_MAIN() {
		return COMP_UI_M_BUT_MAIN;
	}

	public void setCOMP_UI_M_BUT_MAIN(HtmlCommandButton COMP_UI_M_BUT_MAIN) {
		this.COMP_UI_M_BUT_MAIN = COMP_UI_M_BUT_MAIN;
	}

	public PH_IL_TTY_CLAIM_EST getPH_IL_TTY_CLAIM_EST_BEAN() {
		return PH_IL_TTY_CLAIM_EST_BEAN;
	}

	public void setPH_IL_TTY_CLAIM_EST_BEAN(PH_IL_TTY_CLAIM_EST PH_IL_TTY_CLAIM_EST_BEAN) {
		this.PH_IL_TTY_CLAIM_EST_BEAN = PH_IL_TTY_CLAIM_EST_BEAN;
	}
	
	public UIDataTable getTtyDataTable() {
		return ttyDataTable;
	}

	public void setTtyDataTable(UIDataTable ttyDataTable) {
		this.ttyDataTable = ttyDataTable;
	}

	public List<PH_IL_TTY_CLAIM_EST> getDataList() {
		return dataList;
	}

	public void setDataList(List<PH_IL_TTY_CLAIM_EST> dataList) {
		this.dataList = dataList;
	}
	/*Added by saranya for RI recovery details to be shown at Claim registration stage itself on 17/02/2017*/
	public void onLoad(PhaseEvent event) {
		try {
			if (isBlockFlag()) {
				
				helper.executeQuery(compositeAction);
			
				setBlockFlag(false);
			}
		} catch (Exception e) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					e.getMessage());
			getErrorMap().put("onLoad", e.getMessage());
		}
	}
	/*End*/

	public void PH_IL_TTY_CLAIM_EST_WHEN_NEW_BLOCK_INSTANCE(){
//		EXECUTE_QUERY;
		session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
//		PT_IL_TTY_CLAIM_EST claimTTYBean = getPT_IL_TTY_CLAIM_EST_BEAN();
		query = "SELECT * FROM PH_IL_TTY_CLAIM_EST WHERE TCEH_TREATY_CODE = '"+ session.get("TREATY_CODE").toString()+"' AND TCEH_CCD_SYS_ID = "+session.get("TCEH_CCD_SYS_ID");
		try {
			dataList =  handler.fetch(query, "com.iii.pel.forms.PILT011.PH_IL_TTY_CLAIM_EST", getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void PH_IL_TTY_CLAIM_EST_PRE_QUERY(){
		PT_IL_TTY_CLAIM_EST claimTTYBean = getPT_IL_TTY_CLAIM_EST_BEAN();
		PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CLAIM_SYS_ID(claimTTYBean.getTCE_CLAIM_SYS_ID());
		PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CCD_SYS_ID(claimTTYBean.getTCE_CCD_SYS_ID());
		PH_IL_TTY_CLAIM_EST_BEAN.setTCEH_CCD_COVER_CODE(claimTTYBean.getTCE_CCD_COVER_CODE());
	}
	public PT_IL_TTY_CLAIM_EST getPT_IL_TTY_CLAIM_EST_BEAN(){
		Map sessionMap= FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		PT_IL_TTY_CLAIM_EST_ACTION claimEstAction = (PT_IL_TTY_CLAIM_EST_ACTION) sessionMap.get("PILT011_PT_IL_TTY_CLAIM_EST_ACTION");
		PT_IL_TTY_CLAIM_EST claimTTYBean= claimEstAction.getClaimEstList().get(0);
		return claimTTYBean;
	}
	
	public Connection getConnection(){
		Connection con = null;
		try {
			con = CommonUtils.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	
	public String M_BUT_MAIN_WHEN_BUTTON_PRESSED(){
		return "RIDetailsPage";
	}
	
	/*Added by saranya for RI recovery details to be shown at Claim registration stage itself on 17/02/2017*/
	
	public void displayRecords() {
		CommonUtils.clearMaps(this);
		try {
			resetSelectedRow();
			PH_IL_TTY_CLAIM_EST_BEAN = (PH_IL_TTY_CLAIM_EST) ttyDataTable
					.getRowData();
			PH_IL_TTY_CLAIM_EST_BEAN.setRowSelected(true);
			
			//resetAllComponent();
		} catch (Exception exc) {
			getErrorMap().put(PELConstants.PEL_ERROR_WARNING_CURRENT_KEY,
					exc.getMessage());
			getErrorMap().put("displayRecords", exc.getMessage());
		}
	}
	
	
	private void resetSelectedRow() {
		Iterator<PH_IL_TTY_CLAIM_EST> PH_IL_TTY_CLAIM_EST_ITR = dataList
				.iterator();
		while (PH_IL_TTY_CLAIM_EST_ITR.hasNext()) {
			PH_IL_TTY_CLAIM_EST_ITR.next().setRowSelected(false);
		}
	}
	/*End*/
}
