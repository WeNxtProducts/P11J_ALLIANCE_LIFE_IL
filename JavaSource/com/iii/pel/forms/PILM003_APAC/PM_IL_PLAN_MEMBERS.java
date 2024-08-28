package com.iii.pel.forms.PILM003_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;
@Table(name="PM_IL_PLAN_MEMB")
public class PM_IL_PLAN_MEMBERS extends BaseValueBean{
	@Column(name="PMEM_RELATION_TYPE")
	private String PMEM_RELATION_TYPE;

	public String getPMEM_RELATION_TYPE() {
		return PMEM_RELATION_TYPE;
	}

	public void setPMEM_RELATION_TYPE(String pMEM_RELATION_TYPE) {
		PMEM_RELATION_TYPE = pMEM_RELATION_TYPE;
	}
	@Column(name="PMEM_NO_OF_LIFE")
	private Integer PMEM_NO_OF_LIFE;

	public Integer getPMEM_NO_OF_LIFE() {
		return PMEM_NO_OF_LIFE;
	}

	public void setPMEM_NO_OF_LIFE(Integer pMEM_NO_OF_LIFE) {
		PMEM_NO_OF_LIFE = pMEM_NO_OF_LIFE;
	}
	@Column(name="PMEM_MIN_SA")
	private Double PMEM_MIN_SA;

	public Double getPMEM_MIN_SA() {
		return PMEM_MIN_SA;
	}

	public void setPMEM_MIN_SA(Double pMEM_MIN_SA) {
		PMEM_MIN_SA = pMEM_MIN_SA;
	}
	@Column(name="PMEM_MAX_SA")
	private Double PMEM_MAX_SA;

	public Double getPMEM_MAX_SA() {
		return PMEM_MAX_SA;
	}

	public void setPMEM_MAX_SA(Double pMEM_MAX_SA) {
		PMEM_MAX_SA = pMEM_MAX_SA;
	}
	@Column(name="PMEM_MAX_AGE_ENTRY")
	private Integer PMEM_MAX_AGE_ENTRY;

	public Integer getPMEM_MAX_AGE_ENTRY() {
		return PMEM_MAX_AGE_ENTRY;
	}

	public void setPMEM_MAX_AGE_ENTRY(Integer pMEM_MAX_AGE_ENTRY) {
		PMEM_MAX_AGE_ENTRY = pMEM_MAX_AGE_ENTRY;
	}
	@Column(name="PMEM_PLAN_CODE")
	private String PMEM_PLAN_CODE;

	public String getPMEM_PLAN_CODE() {
		return PMEM_PLAN_CODE;
	}

	public void setPMEM_PLAN_CODE(String pMEM_PLAN_CODE) {
		PMEM_PLAN_CODE = pMEM_PLAN_CODE;
	}
	@Column(name="PMEM_CR_DT")
	private Date PMEM_CR_DT;

	public Date getPMEM_CR_DT() {
		return PMEM_CR_DT;
	}

	public void setPMEM_CR_DT(Date pMEM_CR_DT) {
		PMEM_CR_DT = pMEM_CR_DT;
	}
	@Column(name="PMEM_CR_UID")
	private String PMEM_CR_UID;

	public String getPMEM_CR_UID() {
		return PMEM_CR_UID;
	}

	public void setPMEM_CR_UID(String pMEM_CR_UID) {
		PMEM_CR_UID = pMEM_CR_UID;
	}
	@Column(name="PMEM_UPD_DT")
	private Date PMEM_UPD_DT;

	public Date getPMEM_UPD_DT() {
		return PMEM_UPD_DT;
	}

	public void setPMEM_UPD_DT(Date pMEM_UPD_DT) {
		PMEM_UPD_DT = pMEM_UPD_DT;
	}
	@Column(name="PMEM_UPD_UID")
	private String PMEM_UPD_UID;

	public String getPMEM_UPD_UID() {
		return PMEM_UPD_UID;
	}

	public void setPMEM_UPD_UID(String pMEM_UPD_UID) {
		PMEM_UPD_UID = pMEM_UPD_UID;
	}
	/*Added by sankara narayanan on 21/04/2017 for hospital cash plan*/
	@Column(name="PMEN_NO_OF_DAYS")
	private Integer PMEN_NO_OF_DAYS;

	public Integer getPMEN_NO_OF_DAYS() {
		return PMEN_NO_OF_DAYS;
	}

	public void setPMEN_NO_OF_DAYS(Integer pMEN_NO_OF_DAYS) {
		PMEN_NO_OF_DAYS = pMEN_NO_OF_DAYS;
	}
	
	
	/*end*/
	
	/*added by Ameen on 10-07-2017 for ZBILQC-1731204*/
	@Column(name="PMEM_DEP_TYPE")
	private String PMEM_DEP_TYPE;
	
	private String PMEM_DEP_TYPE_DESC;

	public String getPMEM_DEP_TYPE() {
		return PMEM_DEP_TYPE;
	}

	public void setPMEM_DEP_TYPE(String pMEM_DEP_TYPE) {
		PMEM_DEP_TYPE = pMEM_DEP_TYPE;
	}

	public String getPMEM_DEP_TYPE_DESC() {
		return PMEM_DEP_TYPE_DESC;
	}

	public void setPMEM_DEP_TYPE_DESC(String pMEM_DEP_TYPE_DESC) {
		PMEM_DEP_TYPE_DESC = pMEM_DEP_TYPE_DESC;
	}
	
	
	
	/*end*/
	
	/*added by raja on 18-07-2017 for ZBILQC-1731514*/
	@Column(name="PMEM_MIN_COVER_AGE")
	private int PMEM_MIN_COVER_AGE;

	public int getPMEM_MIN_COVER_AGE() {
		return PMEM_MIN_COVER_AGE;
	}

	public void setPMEM_MIN_COVER_AGE(int pMEM_MIN_COVER_AGE) {
		PMEM_MIN_COVER_AGE = pMEM_MIN_COVER_AGE;
	}

	
	
	/*end*/
	

	/*added by raja on 24-07-2017 for  ZBILQC-1732855*/
	@Column(name="PMEM_MIN_AGE_ENTRY")
	private int PMEM_MIN_AGE_ENTRY;

	public int getPMEM_MIN_AGE_ENTRY() {
		return PMEM_MIN_AGE_ENTRY;
	}

	public void setPMEM_MIN_AGE_ENTRY(int pMEM_MIN_AGE_ENTRY) {
		PMEM_MIN_AGE_ENTRY = pMEM_MIN_AGE_ENTRY;
	}
	
	
	/*end*/
}
