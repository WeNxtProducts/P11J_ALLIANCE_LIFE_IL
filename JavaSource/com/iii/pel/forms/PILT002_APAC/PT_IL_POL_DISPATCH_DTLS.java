package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
import com.iii.premia.common.utils.CommonUtils;

@Table(name = "PT_IL_POL_DISPATCH_DTLS")
public class PT_IL_POL_DISPATCH_DTLS extends BaseValueBean {

    @Column(name = "PDD_POL_SYS_ID")
    private Long PDD_POL_SYS_ID;
 
    @Column(name = "PDD_DATE")
    private Date PDD_DATE;

    @Column(name = "PDD_STATUS")
    private String PDD_STATUS;

    @Column(name = "PDD_REMARKS")
    private String PDD_REMARKS;

    @Column(name = "PDD_CR_UID")
    private String PDD_CR_UID;

    @Column(name = "PDD_CR_DT")
    private Date PDD_CR_DT;

    @Column(name = "PDD_UPD_UID")
    private String PDD_UPD_UID;

    @Column(name = "PDD_UPD_DT")
    private Date PDD_UPD_DT;
    
    private String UI_M_PDD_DATE;
    
    private String UI_M_PDD_STATUS_DESC;
    
	
    
	public Long getPDD_POL_SYS_ID() {
		return PDD_POL_SYS_ID;
	}
	public void setPDD_POL_SYS_ID(Long pDD_POL_SYS_ID) {
		PDD_POL_SYS_ID = pDD_POL_SYS_ID;
	}
	public Date getPDD_DATE() {
		return PDD_DATE;
	}
	public void setPDD_DATE(Date pDD_DATE) {
		PDD_DATE = pDD_DATE;
		//UI_M_PDD_DATE = CommonUtils.dateToPELStringFormatter(PDD_DATE);
	}
	public String getPDD_STATUS() {
		return PDD_STATUS;
	}
	public void setPDD_STATUS(String pDD_STATUS) {
		PDD_STATUS = pDD_STATUS;
	}
	public String getPDD_REMARKS() {
		return PDD_REMARKS;
	}
	public void setPDD_REMARKS(String pDD_REMARKS) {
		PDD_REMARKS = pDD_REMARKS;
	}
	public String getPDD_CR_UID() {
		return PDD_CR_UID;
	}
	public void setPDD_CR_UID(String pDD_CR_UID) {
		PDD_CR_UID = pDD_CR_UID;
	}
	public Date getPDD_CR_DT() {
		return PDD_CR_DT;
	}
	public void setPDD_CR_DT(Date pDD_CR_DT) {
		PDD_CR_DT = pDD_CR_DT;
	}
	public String getPDD_UPD_UID() {
		return PDD_UPD_UID;
	}
	public void setPDD_UPD_UID(String pDD_UPD_UID) {
		PDD_UPD_UID = pDD_UPD_UID;
	}
	public Date getPDD_UPD_DT() {
		return PDD_UPD_DT;
	}
	public void setPDD_UPD_DT(Date pDD_UPD_DT) {
		PDD_UPD_DT = pDD_UPD_DT;
	}

	public String getUI_M_PDD_STATUS_DESC() {
		return UI_M_PDD_STATUS_DESC;
	}
	public void setUI_M_PDD_STATUS_DESC(String uI_M_PDD_STATUS_DESC) {
		UI_M_PDD_STATUS_DESC = uI_M_PDD_STATUS_DESC;
	}
	public String getUI_M_PDD_DATE() {
		return UI_M_PDD_DATE;
	}
	public void setUI_M_PDD_DATE(String uI_M_PDD_DATE) {
		UI_M_PDD_DATE = uI_M_PDD_DATE;
	}
    
 
	
}
