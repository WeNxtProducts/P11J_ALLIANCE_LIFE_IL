package com.iii.pel.forms.PILQ101;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Id;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name="PT_IL_PREM_COLL")
public class PT_IL_PREM_COLL extends BaseValueBean {

	@Column(name="PC_SCHD_PYMT_DT")
	private Date PC_SCHD_PYMT_DT;

	@Column(name="PC_FC_GROSS_PREM")
	private Double PC_FC_GROSS_PREM;

	@Column(name="PC_LC_GROSS_PREM")
	private Double PC_LC_GROSS_PREM;

	@Column(name="PC_FC_CHARGE")
	private Double PC_FC_CHARGE;

	@Column(name="PC_LC_CHARGE")
	private Double PC_LC_CHARGE;
	
	@Id
	@Column(name="ROWID")
	private String ROWID;

	public String getROWID() {
		return ROWID;
	}

	public void setROWID(String rowid) {
		ROWID = rowid;
	}
	

	private Double UI_M_PC_FC_GROSS_PREM_SUM;

	private Double UI_M_PC_LC_GROSS_PREM_SUM;

	private Double UI_M_PC_FC_CHARGE_SUM;

	private Double UI_M_PC_LC_CHARGE_SUM;

	private Double UI_M_PC_FC_GROSS_PREM_REMDR_SUM;

	private Double UI_M_PC_LC_GROSS_PREM_REMDR_SUM;

	private Double UI_M_PC_FC_CHARGE_REMDR_SUM;

	private Double UI_M_PC_LC_CHARGE_REMDR_SUM;

	private boolean CHECK_BOX;
	
	private Long PC_SYS_ID;
	
	public Long getPC_SYS_ID() {
		return PC_SYS_ID;
	}

	public void setPC_SYS_ID(Long pc_sys_id) {
		PC_SYS_ID = pc_sys_id;
	}

	public String getUI_GRID_DATE(){
		String date  = null; 
		if(PC_SCHD_PYMT_DT != null ){
			date = CommonUtils.dateToStringFormat(PC_SCHD_PYMT_DT);
		}
		return date;
		
	}
	
	public boolean isCHECK_BOX() {
		return CHECK_BOX;
	}

	public void setCHECK_BOX(boolean check_box) {
		CHECK_BOX = check_box;
	}
	

	public Date getPC_SCHD_PYMT_DT() {
		 return PC_SCHD_PYMT_DT;
	}

	public void setPC_SCHD_PYMT_DT(Date PC_SCHD_PYMT_DT) {
		this.PC_SCHD_PYMT_DT = PC_SCHD_PYMT_DT;
	}

	public Double getPC_FC_GROSS_PREM() {
		return PC_FC_GROSS_PREM;
	}

	public void setPC_FC_GROSS_PREM(Double PC_FC_GROSS_PREM) {
		this.PC_FC_GROSS_PREM = PC_FC_GROSS_PREM;
	}

	public Double getPC_LC_GROSS_PREM() {
		return PC_LC_GROSS_PREM;
	}

	public void setPC_LC_GROSS_PREM(Double PC_LC_GROSS_PREM) {
		this.PC_LC_GROSS_PREM = PC_LC_GROSS_PREM;
	}

	public Double getPC_FC_CHARGE() {
		return PC_FC_CHARGE;
	}

	public void setPC_FC_CHARGE(Double PC_FC_CHARGE) {
		this.PC_FC_CHARGE = PC_FC_CHARGE;
	}

	public Double getPC_LC_CHARGE() {
		return PC_LC_CHARGE;
	}

	public void setPC_LC_CHARGE(Double PC_LC_CHARGE) {
		this.PC_LC_CHARGE = PC_LC_CHARGE;
	}

	public Double getUI_M_PC_FC_GROSS_PREM_SUM() {
		return UI_M_PC_FC_GROSS_PREM_SUM;
	}

	public void setUI_M_PC_FC_GROSS_PREM_SUM(Double UI_M_PC_FC_GROSS_PREM_SUM) {
		this.UI_M_PC_FC_GROSS_PREM_SUM = UI_M_PC_FC_GROSS_PREM_SUM;
	}

	public Double getUI_M_PC_LC_GROSS_PREM_SUM() {
		return UI_M_PC_LC_GROSS_PREM_SUM;
	}

	public void setUI_M_PC_LC_GROSS_PREM_SUM(Double UI_M_PC_LC_GROSS_PREM_SUM) {
		this.UI_M_PC_LC_GROSS_PREM_SUM = UI_M_PC_LC_GROSS_PREM_SUM;
	}

	public Double getUI_M_PC_FC_CHARGE_SUM() {
		return UI_M_PC_FC_CHARGE_SUM;
	}

	public void setUI_M_PC_FC_CHARGE_SUM(Double UI_M_PC_FC_CHARGE_SUM) {
		this.UI_M_PC_FC_CHARGE_SUM = UI_M_PC_FC_CHARGE_SUM;
	}

	public Double getUI_M_PC_LC_CHARGE_SUM() {
		return UI_M_PC_LC_CHARGE_SUM;
	}

	public void setUI_M_PC_LC_CHARGE_SUM(Double UI_M_PC_LC_CHARGE_SUM) {
		this.UI_M_PC_LC_CHARGE_SUM = UI_M_PC_LC_CHARGE_SUM;
	}

	public Double getUI_M_PC_FC_GROSS_PREM_REMDR_SUM() {
		return UI_M_PC_FC_GROSS_PREM_REMDR_SUM;
	}

	public void setUI_M_PC_FC_GROSS_PREM_REMDR_SUM(Double UI_M_PC_FC_GROSS_PREM_REMDR_SUM) {
		this.UI_M_PC_FC_GROSS_PREM_REMDR_SUM = UI_M_PC_FC_GROSS_PREM_REMDR_SUM;
	}

	public Double getUI_M_PC_LC_GROSS_PREM_REMDR_SUM() {
		return UI_M_PC_LC_GROSS_PREM_REMDR_SUM;
	}

	public void setUI_M_PC_LC_GROSS_PREM_REMDR_SUM(Double UI_M_PC_LC_GROSS_PREM_REMDR_SUM) {
		this.UI_M_PC_LC_GROSS_PREM_REMDR_SUM = UI_M_PC_LC_GROSS_PREM_REMDR_SUM;
	}

	public Double getUI_M_PC_FC_CHARGE_REMDR_SUM() {
		return UI_M_PC_FC_CHARGE_REMDR_SUM;
	}

	public void setUI_M_PC_FC_CHARGE_REMDR_SUM(Double UI_M_PC_FC_CHARGE_REMDR_SUM) {
		this.UI_M_PC_FC_CHARGE_REMDR_SUM = UI_M_PC_FC_CHARGE_REMDR_SUM;
	}

	public Double getUI_M_PC_LC_CHARGE_REMDR_SUM() {
		return UI_M_PC_LC_CHARGE_REMDR_SUM;
	}

	public void setUI_M_PC_LC_CHARGE_REMDR_SUM(Double UI_M_PC_LC_CHARGE_REMDR_SUM) {
		this.UI_M_PC_LC_CHARGE_REMDR_SUM = UI_M_PC_LC_CHARGE_REMDR_SUM;
	}
	/*Added By saranya For The ssp Call ID : FALCONQC-1715539 */ 
    private String UI_PC_FC_GROSS_PREM;
	
	private String UI_PC_LC_GROSS_PREM;
	
	private String UI_PC_FC_CHARGE;
	
	private String UI_PC_LC_CHARGE;

	public String getUI_PC_FC_GROSS_PREM() {
		return UI_PC_FC_GROSS_PREM;
	}

	public void setUI_PC_FC_GROSS_PREM(String uI_PC_FC_GROSS_PREM) {
		UI_PC_FC_GROSS_PREM = uI_PC_FC_GROSS_PREM;
	}

	public String getUI_PC_LC_GROSS_PREM() {
		return UI_PC_LC_GROSS_PREM;
	}

	public void setUI_PC_LC_GROSS_PREM(String uI_PC_LC_GROSS_PREM) {
		UI_PC_LC_GROSS_PREM = uI_PC_LC_GROSS_PREM;
	}

	public String getUI_PC_FC_CHARGE() {
		return UI_PC_FC_CHARGE;
	}

	public void setUI_PC_FC_CHARGE(String uI_PC_FC_CHARGE) {
		UI_PC_FC_CHARGE = uI_PC_FC_CHARGE;
	}

	public String getUI_PC_LC_CHARGE() {
		return UI_PC_LC_CHARGE;
	}

	public void setUI_PC_LC_CHARGE(String uI_PC_LC_CHARGE) {
		UI_PC_LC_CHARGE = uI_PC_LC_CHARGE;
	}
	/*end*/
}
