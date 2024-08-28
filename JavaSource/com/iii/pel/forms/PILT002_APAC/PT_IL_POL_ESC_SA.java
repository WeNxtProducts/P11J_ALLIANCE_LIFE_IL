package com.iii.pel.forms.PILT002_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;


@Table(name = "PT_IL_POL_ESC_SA")
public class PT_IL_POL_ESC_SA extends BaseValueBean{

    @Column(name = "PES_SYS_ID")
    private Double PES_SYS_ID;

    @Column(name = "PES_POL_SYS_ID")
    private Long PES_POL_SYS_ID;

    @Column(name = "PES_END_NO_IDX")
    private Double PES_END_NO_IDX;

    @Column(name = "PES_MONTH")
    private Double PES_MONTH;
    
    @Column(name = "PES_PYMT_DT")
    private Date PES_PYMT_DT;

    @Column(name = "PES_FC_SA")
    private Double PES_FC_SA;

    @Column(name = "PES_LC_SA")
    private Double PES_LC_SA;

    @Column(name = "PES_FC_OPEN_BAL")
    private Double PES_FC_OPEN_BAL;

    @Column(name = "PES_LC_OPEN_BAL")
    private Double PES_LC_OPEN_BAL;

    @Column(name = "PES_CR_DT")
    private Date PES_CR_DT;

    @Column(name = "PES_CR_UID")
    private String PES_CR_UID;

    @Column(name = "PES_UPD_DT")
    private Date PES_UPD_DT;
    
    @Column(name = "PES_UPD_UID")
    private String PES_UPD_UID;

    @Column(name = "PES_COVER_CODE")
    private String PES_COVER_CODE;


    public Double getPES_SYS_ID() {
		return PES_SYS_ID;
	}

	public void setPES_SYS_ID(Double pES_SYS_ID) {
		PES_SYS_ID = pES_SYS_ID;
	}

	public Long getPES_POL_SYS_ID() {
		return PES_POL_SYS_ID;
	}

	public void setPES_POL_SYS_ID(Long pES_POL_SYS_ID) {
		PES_POL_SYS_ID = pES_POL_SYS_ID;
	}

	public Double getPES_END_NO_IDX() {
		return PES_END_NO_IDX;
	}

	public void setPES_END_NO_IDX(Double pES_END_NO_IDX) {
		PES_END_NO_IDX = pES_END_NO_IDX;
	}

	public Double getPES_MONTH() {
		return PES_MONTH;
	}

	public void setPES_MONTH(Double pES_MONTH) {
		PES_MONTH = pES_MONTH;
	}

	public Date getPES_PYMT_DT() {
		return PES_PYMT_DT;
	}

	public void setPES_PYMT_DT(Date pES_PYMT_DT) {
		PES_PYMT_DT = pES_PYMT_DT;
	}

	public Double getPES_FC_SA() {
		return PES_FC_SA;
	}

	public Double getPES_FC_OPEN_BAL() {
		return PES_FC_OPEN_BAL;
	}

	public void setPES_FC_OPEN_BAL(Double pES_FC_OPEN_BAL) {
		PES_FC_OPEN_BAL = pES_FC_OPEN_BAL;
	}

	public Double getPES_LC_OPEN_BAL() {
		return PES_LC_OPEN_BAL;
	}

	public void setPES_LC_OPEN_BAL(Double pES_LC_OPEN_BAL) {
		PES_LC_OPEN_BAL = pES_LC_OPEN_BAL;
	}

	public void setPES_FC_SA(Double pES_FC_SA) {
		PES_FC_SA = pES_FC_SA;
	}

	public Double getPES_LC_SA() {
		return PES_LC_SA;
	}

	public void setPES_LC_SA(Double pES_LC_SA) {
		PES_LC_SA = pES_LC_SA;
	}

	public Date getPES_CR_DT() {
		return PES_CR_DT;
	}

	public void setPES_CR_DT(Date pES_CR_DT) {
		PES_CR_DT = pES_CR_DT;
	}

	public String getPES_CR_UID() {
		return PES_CR_UID;
	}

	public void setPES_CR_UID(String pES_CR_UID) {
		PES_CR_UID = pES_CR_UID;
	}

	public Date getPES_UPD_DT() {
		return PES_UPD_DT;
	}

	public void setPES_UPD_DT(Date pES_UPD_DT) {
		PES_UPD_DT = pES_UPD_DT;
	}

	public String getPES_UPD_UID() {
		return PES_UPD_UID;
	}

	public void setPES_UPD_UID(String pES_UPD_UID) {
		PES_UPD_UID = pES_UPD_UID;
	}

	public String getPES_COVER_CODE() {
		return PES_COVER_CODE;
	}

	public void setPES_COVER_CODE(String pES_COVER_CODE) {
		PES_COVER_CODE = pES_COVER_CODE;
	}

	
}
