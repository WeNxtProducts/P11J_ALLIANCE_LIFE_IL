/**
 * 
 */
package com.iii.pel.forms.PILM035_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name = "PM_IL_PROD_APPL_TERM")
public class PM_IL_PROD_INSURER extends BaseValueBean{
	
	@Column(name="PAT_PROD_CODE")
	private String PT_PROD_CODE;
	
	@Column(name="PAT_AGE_FM")
	private int PT_AGE_FROM;
	
	@Column(name="PAT_AGE_TO")
	private int PT_AGE_TO;
	
	@Column(name="PAT_SA_FM")
	private int PT_SUM_ASSR_FROM;
	
	@Column(name="PAT_SA_TO")
	private int PT_SUM_ASSR_TO;
	
	@Column(name="PAT_TERM_FM")
	private int PT_TERM_FROM;
	
	@Column(name="PAT_TERM_TO")
	private int PT_TERM_TO;
	
	@Column(name="PAT_CR_DT")
	private Date PT_CREATED_DATE;
	
	@Column(name="PAT_CR_UID")
	private String PT_CREATED_UID;
	/**
	 * @return the pT_PROD_CODE
	 */
	public String getPT_PROD_CODE() {
		return PT_PROD_CODE;
	}
	/**
	 * @param pt_prod_code the pT_PROD_CODE to set
	 */
	public void setPT_PROD_CODE(String pt_prod_code) {
		PT_PROD_CODE = pt_prod_code;
	}
	/**
	 * @return the pT_AGE_FROM
	 */
	public int getPT_AGE_FROM() {
		return PT_AGE_FROM;
	}
	/**
	 * @param pt_age_from the pT_AGE_FROM to set
	 */
	public void setPT_AGE_FROM(int pt_age_from) {
		PT_AGE_FROM = pt_age_from;
	}
	/**
	 * @return the pT_AGE_TO
	 */
	public int getPT_AGE_TO() {
		return PT_AGE_TO;
	}
	/**
	 * @param pt_age_to the pT_AGE_TO to set
	 */
	public void setPT_AGE_TO(int pt_age_to) {
		PT_AGE_TO = pt_age_to;
	}
	/**
	 * @return the pT_SUM_ASSR_FROM
	 */
	public int getPT_SUM_ASSR_FROM() {
		return PT_SUM_ASSR_FROM;
	}
	/**
	 * @param pt_sum_assr_from the pT_SUM_ASSR_FROM to set
	 */
	public void setPT_SUM_ASSR_FROM(int pt_sum_assr_from) {
		PT_SUM_ASSR_FROM = pt_sum_assr_from;
	}
	/**
	 * @return the pT_SUM_ASSR_TO
	 */
	public int getPT_SUM_ASSR_TO() {
		return PT_SUM_ASSR_TO;
	}
	/**
	 * @param pt_sum_assr_to the pT_SUM_ASSR_TO to set
	 */
	public void setPT_SUM_ASSR_TO(int pt_sum_assr_to) {
		PT_SUM_ASSR_TO = pt_sum_assr_to;
	}
	/**
	 * @return the pT_TERM_FROM
	 */
	public int getPT_TERM_FROM() {
		return PT_TERM_FROM;
	}
	/**
	 * @param pt_term_from the pT_TERM_FROM to set
	 */
	public void setPT_TERM_FROM(int pt_term_from) {
		PT_TERM_FROM = pt_term_from;
	}
	/**
	 * @return the pT_TERM_TO
	 */
	public int getPT_TERM_TO() {
		return PT_TERM_TO;
	}
	/**
	 * @param pt_term_to the pT_TERM_TO to set
	 */
	public void setPT_TERM_TO(int pt_term_to) {
		PT_TERM_TO = pt_term_to;
	}
	/**
	 * @return the pT_CREATED_DATE
	 */
	public Date getPT_CREATED_DATE() {
		return PT_CREATED_DATE;
	}
	/**
	 * @param pt_created_date the pT_CREATED_DATE to set
	 */
	public void setPT_CREATED_DATE(Date pt_created_date) {
		PT_CREATED_DATE = pt_created_date;
	}
	/**
	 * @return the pT_CREATED_UID
	 */
	public String getPT_CREATED_UID() {
		return PT_CREATED_UID;
	}
	/**
	 * @param pt_created_uid the pT_CREATED_UID to set
	 */
	public void setPT_CREATED_UID(String pt_created_uid) {
		PT_CREATED_UID = pt_created_uid;
	}

}
