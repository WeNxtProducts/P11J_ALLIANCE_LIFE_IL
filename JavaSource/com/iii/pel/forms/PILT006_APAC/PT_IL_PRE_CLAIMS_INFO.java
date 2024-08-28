package com.iii.pel.forms.PILT006_APAC;

import java.util.Date;

import com.iii.apps.persistence.Column;
import com.iii.apps.persistence.Table;

@Table(name="PT_IL_PRE_CLAIMS_INFO")
public class PT_IL_PRE_CLAIMS_INFO {
	
	@Column(name="PCI_CLAIM_TYPE")
	private String PCI_CLAIM_TYPE;
	
	@Column(name="PCI_LOSS_DT")
	private Date PCI_LOSS_DT;
	
	@Column(name="PCI_REPORT_DT")
	private Date PCI_REPORT_DT;
	
	@Column(name="PCI_POL_NO")
	private String PCI_POL_NO;
	
	@Column(name="PCI_ADDL_STATUS")
	private String PCI_ADDL_STATUS;

	public String getPCI_CLAIM_TYPE() {
		return PCI_CLAIM_TYPE;
	}

	public void setPCI_CLAIM_TYPE(String pci_claim_type) {
		PCI_CLAIM_TYPE = pci_claim_type;
	}

	public Date getPCI_LOSS_DT() {
		return PCI_LOSS_DT;
	}

	public void setPCI_LOSS_DT(Date pci_loss_dt) {
		PCI_LOSS_DT = pci_loss_dt;
	}

	public Date getPCI_REPORT_DT() {
		return PCI_REPORT_DT;
	}

	public void setPCI_REPORT_DT(Date pci_report_dt) {
		PCI_REPORT_DT = pci_report_dt;
	}

	public String getPCI_POL_NO() {
		return PCI_POL_NO;
	}

	public void setPCI_POL_NO(String pci_pol_no) {
		PCI_POL_NO = pci_pol_no;
	}

	public String getPCI_ADDL_STATUS() {
		return PCI_ADDL_STATUS;
	}

	public void setPCI_ADDL_STATUS(String pci_addl_status) {
		PCI_ADDL_STATUS = pci_addl_status;
	}

}
