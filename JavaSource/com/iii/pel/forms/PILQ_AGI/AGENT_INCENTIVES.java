package com.iii.pel.forms.PILQ_AGI;

import java.util.Date;

import com.iii.apps.persistence.Table;
import com.iii.premia.common.bean.BaseValueBean;

@Table(name="")
public class AGENT_INCENTIVES extends BaseValueBean {
	
	
	private String AGENT_CODE;
	private String AGENT_CODE_DESC;
	
	private Date UI_M_EFF_FM_DT;
	private Date UI_M_EFF_TO_DT;
	
	
	//BSC Rates
	Integer UI_M_NOP_UNITS;
	Integer UI_M_AAD_UNITS;
	Integer UI_M_RCG_UNITS;
	Integer UI_M_TAINB_UNITS;
  
    Double UI_M_NOP_WEIGHTAGE;
    Double UI_M_AAD_WEIGHTAGE;
    Double UI_M_RCG_WEIGHTAGE;
    Double UI_M_TAINB_WEIGHTAGE;
    
    //Balance Score Card & Bsc Scores
    Integer UI_M_TOT_NO_OF_POLICIES;
    Integer UI_M_TOT_NO_OF_ACTIVE_AGENTS;
    Double 	UI_M_TOT_REN_COLLECTION;
    Integer UI_M_TOT_NO_OF_AGENTS_BOOK; 
    
    Double UI_M_NOP_SCORE;
    Double UI_M_AAG_SCORE;
    Double UI_M_RCF_SCORE;
    Double UI_M_TAIB_SCORE;
    
    Double UI_M_TOT_BSC_PERC;
    
    //Incentives BreakUp
    
    Double UI_M_TOT_TEAM_COMM_UNITS;
    Double UI_M_DIRECT_REN_PREM_UNITS;
    
    Double  UI_M_TOT_TEAM_COMM;
    Double 	UI_M_PERSISTANCY;
    Double 	UI_M_DIRECT_REN_PREM;
    
    Double UI_M_TOT_INCENTIV;
    
    String AGENT_PERIOD;
    
    Double AGENT_TRGT;
    

	public Double getAGENT_TRGT() {
		return AGENT_TRGT;
	}

	public void setAGENT_TRGT(Double agent_trgt) {
		AGENT_TRGT = agent_trgt;
	}

	public String getAGENT_PERIOD() {
		return AGENT_PERIOD;
	}

	public void setAGENT_PERIOD(String agent_period) {
		AGENT_PERIOD = agent_period;
	}

	public Double getUI_M_TOT_INCENTIV() {
		return UI_M_TOT_INCENTIV;
	}

	public void setUI_M_TOT_INCENTIV(Double ui_m_tot_incentiv) {
		UI_M_TOT_INCENTIV = ui_m_tot_incentiv;
	}

	public Integer getUI_M_NOP_UNITS() {
		return UI_M_NOP_UNITS;
	}

	public void setUI_M_NOP_UNITS(Integer ui_m_nop_units) {
		UI_M_NOP_UNITS = ui_m_nop_units;
	}

	public Integer getUI_M_AAD_UNITS() {
		return UI_M_AAD_UNITS;
	}

	public void setUI_M_AAD_UNITS(Integer ui_m_aad_units) {
		UI_M_AAD_UNITS = ui_m_aad_units;
	}

	public Integer getUI_M_RCG_UNITS() {
		return UI_M_RCG_UNITS;
	}

	public void setUI_M_RCG_UNITS(Integer ui_m_rcg_units) {
		UI_M_RCG_UNITS = ui_m_rcg_units;
	}

	public Integer getUI_M_TAINB_UNITS() {
		return UI_M_TAINB_UNITS;
	}

	public void setUI_M_TAINB_UNITS(Integer ui_m_tainb_units) {
		UI_M_TAINB_UNITS = ui_m_tainb_units;
	}

	public Double getUI_M_NOP_WEIGHTAGE() {
		return UI_M_NOP_WEIGHTAGE;
	}

	public void setUI_M_NOP_WEIGHTAGE(Double ui_m_nop_weightage) {
		UI_M_NOP_WEIGHTAGE = ui_m_nop_weightage;
	}

	public Double getUI_M_AAD_WEIGHTAGE() {
		return UI_M_AAD_WEIGHTAGE;
	}

	public void setUI_M_AAD_WEIGHTAGE(Double ui_m_aad_weightage) {
		UI_M_AAD_WEIGHTAGE = ui_m_aad_weightage;
	}

	public Double getUI_M_RCG_WEIGHTAGE() {
		return UI_M_RCG_WEIGHTAGE;
	}

	public void setUI_M_RCG_WEIGHTAGE(Double ui_m_rcg_weightage) {
		UI_M_RCG_WEIGHTAGE = ui_m_rcg_weightage;
	}

	public Double getUI_M_TAINB_WEIGHTAGE() {
		return UI_M_TAINB_WEIGHTAGE;
	}

	public void setUI_M_TAINB_WEIGHTAGE(Double ui_m_tainb_weightage) {
		UI_M_TAINB_WEIGHTAGE = ui_m_tainb_weightage;
	}

	public Integer getUI_M_TOT_NO_OF_POLICIES() {
		return UI_M_TOT_NO_OF_POLICIES;
	}

	public void setUI_M_TOT_NO_OF_POLICIES(Integer ui_m_tot_no_of_policies) {
		UI_M_TOT_NO_OF_POLICIES = ui_m_tot_no_of_policies;
	}

	public Integer getUI_M_TOT_NO_OF_ACTIVE_AGENTS() {
		return UI_M_TOT_NO_OF_ACTIVE_AGENTS;
	}

	public void setUI_M_TOT_NO_OF_ACTIVE_AGENTS(Integer ui_m_tot_no_of_active_agents) {
		UI_M_TOT_NO_OF_ACTIVE_AGENTS = ui_m_tot_no_of_active_agents;
	}

	public Double getUI_M_TOT_REN_COLLECTION() {
		return UI_M_TOT_REN_COLLECTION;
	}

	public void setUI_M_TOT_REN_COLLECTION(Double ui_m_tot_ren_collection) {
		UI_M_TOT_REN_COLLECTION = ui_m_tot_ren_collection;
	}

	public Integer getUI_M_TOT_NO_OF_AGENTS_BOOK() {
		return UI_M_TOT_NO_OF_AGENTS_BOOK;
	}

	public void setUI_M_TOT_NO_OF_AGENTS_BOOK(Integer ui_m_tot_no_of_agents_book) {
		UI_M_TOT_NO_OF_AGENTS_BOOK = ui_m_tot_no_of_agents_book;
	}

	public Double getUI_M_NOP_SCORE() {
		return UI_M_NOP_SCORE;
	}

	public void setUI_M_NOP_SCORE(Double ui_m_nop_score) {
		UI_M_NOP_SCORE = ui_m_nop_score;
	}

	public Double getUI_M_AAG_SCORE() {
		return UI_M_AAG_SCORE;
	}

	public void setUI_M_AAG_SCORE(Double ui_m_aag_score) {
		UI_M_AAG_SCORE = ui_m_aag_score;
	}

	public Double getUI_M_RCF_SCORE() {
		return UI_M_RCF_SCORE;
	}

	public void setUI_M_RCF_SCORE(Double ui_m_rcf_score) {
		UI_M_RCF_SCORE = ui_m_rcf_score;
	}

	public Double getUI_M_TAIB_SCORE() {
		return UI_M_TAIB_SCORE;
	}

	public void setUI_M_TAIB_SCORE(Double ui_m_taib_score) {
		UI_M_TAIB_SCORE = ui_m_taib_score;
	}

	public Double getUI_M_TOT_BSC_PERC() {
		return UI_M_TOT_BSC_PERC;
	}

	public void setUI_M_TOT_BSC_PERC(Double ui_m_tot_bsc_perc) {
		UI_M_TOT_BSC_PERC = ui_m_tot_bsc_perc;
	}

	public Double getUI_M_TOT_TEAM_COMM() {
		return UI_M_TOT_TEAM_COMM;
	}

	public void setUI_M_TOT_TEAM_COMM(Double ui_m_tot_team_comm) {
		UI_M_TOT_TEAM_COMM = ui_m_tot_team_comm;
	}

	public Double getUI_M_DIRECT_REN_PREM() {
		return UI_M_DIRECT_REN_PREM;
	}

	public void setUI_M_DIRECT_REN_PREM(Double ui_m_direct_ren_prem) {
		UI_M_DIRECT_REN_PREM = ui_m_direct_ren_prem;
	}

	public Double getUI_M_PERSISTANCY() {
		return UI_M_PERSISTANCY;
	}

	public void setUI_M_PERSISTANCY(Double ui_m_persistancy) {
		UI_M_PERSISTANCY = ui_m_persistancy;
	}

	

	public String getAGENT_CODE_DESC() {
		return AGENT_CODE_DESC;
	}

	public void setAGENT_CODE_DESC(String agent_code_desc) {
		AGENT_CODE_DESC = agent_code_desc;
	}

	public String getAGENT_CODE() {
		return AGENT_CODE;
	}

	public void setAGENT_CODE(String agent_code) {
		AGENT_CODE = agent_code;
	}

	public Double getUI_M_TOT_TEAM_COMM_UNITS() {
		return UI_M_TOT_TEAM_COMM_UNITS;
	}

	public void setUI_M_TOT_TEAM_COMM_UNITS(Double ui_m_tot_team_comm_units) {
		UI_M_TOT_TEAM_COMM_UNITS = ui_m_tot_team_comm_units;
	}

	public Double getUI_M_DIRECT_REN_PREM_UNITS() {
		return UI_M_DIRECT_REN_PREM_UNITS;
	}

	public void setUI_M_DIRECT_REN_PREM_UNITS(Double ui_m_direct_ren_prem_units) {
		UI_M_DIRECT_REN_PREM_UNITS = ui_m_direct_ren_prem_units;
	}

	public Date getUI_M_EFF_FM_DT() {
		return UI_M_EFF_FM_DT;
	}

	public void setUI_M_EFF_FM_DT(Date ui_m_eff_fm_dt) {
		UI_M_EFF_FM_DT = ui_m_eff_fm_dt;
	}

	public Date getUI_M_EFF_TO_DT() {
		return UI_M_EFF_TO_DT;
	}

	public void setUI_M_EFF_TO_DT(Date ui_m_eff_to_dt) {
		UI_M_EFF_TO_DT = ui_m_eff_to_dt;
	}

	
}
