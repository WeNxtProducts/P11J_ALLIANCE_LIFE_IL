package com.iii.pel.forms.PILM013_APAC;

import java.util.List;

import javax.faces.validator.ValidatorException;

import com.iii.premia.common.constants.PELConstants;
import com.iii.premia.common.errorUtil.Messages;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_DOC_NO_SETUP_HELPER {

	
	String bundleName = PM_IL_DOC_SETUP_CONSTANTS.BUNDLE_NAME_PATH;
	public void setDocumentNumberSetupValues(List resultSetList ,PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action)
	{
		PM_IL_DOC_NO_SETUP pm_il_doc_no_setup = (PM_IL_DOC_NO_SETUP) pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN();
		
	}
	
	/*
	 * DNS_LEVEL_1 Triggers.
	 */
	public void DNS_LEVEL_1_WHEN_LIST_CHANGED(String DNS_LEVEL_1_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action) throws ValidatorException, Exception {
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
		if(! "4".equalsIgnoreCase(DS_TYPE)){
			if("007".equalsIgnoreCase(DNS_LEVEL_1_STRING) || "008".equalsIgnoreCase(DNS_LEVEL_1_STRING) || "009".equalsIgnoreCase(DNS_LEVEL_1_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"91453"));
			}
		}
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_1_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_2().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			if(DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING) ||
					DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING) ||
					DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING) ||
					DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
					throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}
		
		if("000".equalsIgnoreCase(DNS_LEVEL_1_STRING)){
			System.out.println("IN IF 2");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_L1_ATTACH_YN("N");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_2("000");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_3("000");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_4("000");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_5("000");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_2().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
		}
	}
	
	public void DNS_LEVEL_1_WHEN_VALIDATE_ITEM(String DNS_LEVEL_1_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
		
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		System.out.println("DNS LEVEL " +DNS_LEVEL_1_STRING);
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_1_STRING)){
			System.out.println("In IF 5");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_2().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L2_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(false);
			if(DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_1_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}else if("000".equalsIgnoreCase(DNS_LEVEL_1_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_2().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L2_ATTACH_YN().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(true);
		}
	}
	
	/*
	 * DNS_LEVEL_2 Trigger.
	 */
	public void DNS_LEVEL_2_WHEN_LIST_CHANGED(String DNS_LEVEL_2_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action) throws ValidatorException, Exception {
	
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	
		if(! "4".equalsIgnoreCase(DS_TYPE)){
			if("007".equalsIgnoreCase(DNS_LEVEL_2_STRING) || "008".equalsIgnoreCase(DNS_LEVEL_2_STRING) || "009".equalsIgnoreCase(DNS_LEVEL_2_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"91453"));
			}
		}
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_2_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L2_ATTACH_YN().setDisabled(false);
			
			if(DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING) ||
					DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING) ||
					DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING) ||
					DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
					throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}
		
		if("000".equalsIgnoreCase(DNS_LEVEL_2_STRING)){
			System.out.println("IN IF 2");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_L2_ATTACH_YN("N");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_3("000");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_4("000");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_5("000");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
		}
	}
	
	public void DNS_LEVEL_2_WHEN_VALIDATE_ITEM(String DNS_LEVEL_2_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
		
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		System.out.println("DNS LEVEL " +DNS_LEVEL_1_STRING);
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_2_STRING)){
			System.out.println("In IF 5");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(false);
			if(DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_2_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}else if("000".equalsIgnoreCase(DNS_LEVEL_2_STRING)){
			System.out.println("IN IF 6");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(true);
		}
	}
	
	
	/*
	 * DNS_LEVEL_3 Trigger.
	 */
	
	public void DNS_LEVEL_3_WHEN_LIST_CHANGED(String DNS_LEVEL_3_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action) throws ValidatorException, Exception {
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	
		if(! "4".equalsIgnoreCase(DS_TYPE)){
			if("007".equalsIgnoreCase(DNS_LEVEL_3_STRING) || "008".equalsIgnoreCase(DNS_LEVEL_3_STRING) || "009".equalsIgnoreCase(DNS_LEVEL_3_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"91453"));
			}
		}
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_3_STRING)){
			System.out.println("In IF 1");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(false);
			
			if(DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING) ||
					DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING) ||
					DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING) ||
					DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
					throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}
		
		if("000".equalsIgnoreCase(DNS_LEVEL_3_STRING)){
			System.out.println("IN IF 2");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_L3_ATTACH_YN("N");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_LEVEL_4("000");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(true);
		}
	}
	
	public void DNS_LEVEL_3_WHEN_VALIDATE_ITEM(String DNS_LEVEL_3_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
		
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		System.out.println("DNS LEVEL " +DNS_LEVEL_1_STRING);
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_3_STRING)){
			System.out.println("In IF 5");
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(false);
			if(DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_3_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}else if("000".equalsIgnoreCase(DNS_LEVEL_3_STRING)){
			System.out.println("IN IF 6");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_4().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(true);
		}
	}
	
	
	/*
	 * DNS_LEVEL_4 Trigger.
	 */
	public void DNS_LEVEL_4_WHEN_LIST_CHANGED(String DNS_LEVEL_4_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action) throws ValidatorException, Exception {
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	
		if(! "4".equalsIgnoreCase(DS_TYPE)){
			if("007".equalsIgnoreCase(DNS_LEVEL_4_STRING) || "008".equalsIgnoreCase(DNS_LEVEL_4_STRING) || "009".equalsIgnoreCase(DNS_LEVEL_4_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"91453"));
			}
		}
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_4_STRING)){
			System.out.println("In IF 1");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(false);
			
			if(DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING) ||
					DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING) ||
					DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING) ||
					DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
					throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}
		
		if("000".equalsIgnoreCase(DNS_LEVEL_4_STRING)){
			System.out.println("IN IF 2");
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_L4_ATTACH_YN("N");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(true);
		}
	}
	
	public void DNS_LEVEL_4_WHEN_VALIDATE_ITEM(String DNS_LEVEL_4_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
		
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_5_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5();
		System.out.println("DNS LEVEL " +DNS_LEVEL_1_STRING);
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_4_STRING)){
			System.out.println("In IF 5");
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(false);
			if(DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_4_STRING.equalsIgnoreCase(DNS_LEVEL_5_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}else if("000".equalsIgnoreCase(DNS_LEVEL_4_STRING)){
			System.out.println("IN IF 6");
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(true);
		}
	}
	
	/*
	 * DNS_LEVEL_5 Trigger.
	 */
	public void DNS_LEVEL_5_WHEN_LIST_CHANGED(String DNS_LEVEL_5_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action) throws ValidatorException, Exception {
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
	
		if(! "4".equalsIgnoreCase(DS_TYPE)){
			if("007".equalsIgnoreCase(DNS_LEVEL_5_STRING) || "008".equalsIgnoreCase(DNS_LEVEL_5_STRING) || "009".equalsIgnoreCase(DNS_LEVEL_5_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"91453"));
			}
		}
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_5_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			
			if(DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING) ||
					DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING) ||
					DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING) ||
					DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING)){
					throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}
		
		if("000".equalsIgnoreCase(DNS_LEVEL_5_STRING)){
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_L5_ATTACH_YN("N");
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(true);
		}
	}
	
	public void DNS_LEVEL_5_WHEN_VALIDATE_ITEM(String DNS_LEVEL_5_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DS_TYPE =  pm_il_doc_setup_composite_action.getPM_IL_DOC_SETUP_ACTION_BEAN().getPM_IL_DOC_SETUP_BEAN().getDS_TYPE();
		
		String DNS_LEVEL_1_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1();
		String DNS_LEVEL_2_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2();
		String DNS_LEVEL_3_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3();
		String DNS_LEVEL_4_STRING = pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4();
		
		if(! "000".equalsIgnoreCase(DNS_LEVEL_5_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_5().setDisabled(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_L5_ATTACH_YN().setDisabled(false);
			if(DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_1_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_2_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_3_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}else if(DNS_LEVEL_5_STRING.equalsIgnoreCase(DNS_LEVEL_4_STRING)){
				throw new ValidatorException(Messages.getMessage(bundleName,"90011"));
			}
		}
	}
	
	/*
	 * DNS_L1_ATTACH_YN Trigger.
	 */
	public void DNS_L1_ATTACH_YN_WHEN_LIST_CHANGED(PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DNS_LEVEL_1_STRING = (String) pm_il_doc_setup_composite_action.getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getCOMP_DNS_LEVEL_1().getSubmittedValue();
		String DNS_L2_ATTACH_YN_STRING = (String) pm_il_doc_setup_composite_action.getPM_IL_DOC_NO_SETUP_ACTION_BEAN().getCOMP_DNS_L2_ATTACH_YN().getSubmittedValue();
		System.out.println(DNS_L2_ATTACH_YN_STRING);
		System.out.println(DNS_LEVEL_1_STRING);
		if("N".equalsIgnoreCase(DNS_L2_ATTACH_YN_STRING)){
			if(! "000".equalsIgnoreCase(DNS_LEVEL_1_STRING)){
				System.out.println("Here12");
				pm_il_doc_no_setup_action.getCOMP_DNS_L2_ATTACH_YN().setDisabled(false);
			}
		}
	}
	
	/*
	 * DNS_L2_ATTACH_YN Trigger.
	 */
	public void DNS_L2_ATTACH_YN_WHEN_LIST_CHANGED(String DNS_L2_ATTACH_YN_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DNS_LEVEL_3_STRING = (String) pm_il_doc_no_setup_action.getCOMP_DNS_LEVEL_3().getSubmittedValue();
		System.out.println(DNS_LEVEL_3_STRING);
		if("N".equalsIgnoreCase(DNS_L2_ATTACH_YN_STRING)){
			if(! "000".equalsIgnoreCase(DNS_LEVEL_3_STRING)){
				System.out.println("Here");
				pm_il_doc_no_setup_action.getCOMP_DNS_L3_ATTACH_YN().setDisabled(false);
			}
		}
	}
	
	/*
	 * DNS_L3_ATTACH_YN Trigger.
	 */
	public void DNS_L3_ATTACH_YN_WHEN_LIST_CHANGED(String DNS_L3_ATTACH_YN_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		if("N".equalsIgnoreCase(DNS_L3_ATTACH_YN_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_L4_ATTACH_YN().setDisabled(false);
		}
	}
	
	/*
	 * DNS_PREFIX_YN Trigger.
	 */
	public void DNS_PREFIX_YN_WHEN_VALIDATE_ITEM(String DNS_PREFIX_YN_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		if("Y".equalsIgnoreCase(DNS_PREFIX_YN_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setRequired(true);
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setDisabled(false);
		}else{
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setRequired(false);
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setSubmittedValue(null);
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setDisabled(true);
		}
	}
	
	public void DNS_PREFIX_YN_WHEN_LIST_CHANGE(String DNS_PREFIX_YN_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		if("Y".equalsIgnoreCase(DNS_PREFIX_YN_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setDisabled(false);
		}else{
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setSubmittedValue(null);
			pm_il_doc_no_setup_action.getCOMP_DNS_PREFIX().setDisabled(true);
		}
	}
	
	/*
	 * DNS_PAD_YN Trigger.
	 */
	
public void DNS_PAD_YN_WHEN_VALIDATE_ITEM(String DNS_PAD_YN_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		String DNS_PAD_LENGTH_STRING = (String) pm_il_doc_no_setup_action.getCOMP_DNS_PAD_LENGTH().getSubmittedValue();
		if("Y".equalsIgnoreCase(DNS_PAD_YN_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_PAD_LENGTH().setDisabled(false);
			//pm_il_doc_no_setup_action.getCOMP_DNS_PAD_LENGTH().setSubmittedValue("");
		}else{
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_PAD_LENGTH(0);
			pm_il_doc_no_setup_action.getCOMP_DNS_PAD_LENGTH().setSubmittedValue(null);
			pm_il_doc_no_setup_action.getCOMP_DNS_PAD_LENGTH().setDisabled(true);
		}
	}
	
	public void DNS_PAD_YN_WHEN_LIST_CHANGE(String DNS_PAD_YN_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		CommonUtils commonUtils = new CommonUtils();
		PM_IL_DOC_SETUP_COMPOSITE_ACTION pm_il_doc_setup_composite_action = (PM_IL_DOC_SETUP_COMPOSITE_ACTION) commonUtils.getMappedBeanFromSession("PM_IL_DOC_SETUP_COMPOSITE_ACTION");
		if("Y".equalsIgnoreCase(DNS_PAD_YN_STRING)){
			pm_il_doc_no_setup_action.getCOMP_DNS_PAD_LENGTH().setDisabled(false);
		}else{
			pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_PAD_LENGTH(0);
			pm_il_doc_no_setup_action.getCOMP_DNS_PAD_LENGTH().setDisabled(true);
		}
	}
	
	/*
	 * DNS_ATTACH_SEQ_LEVEL Trigger.
	 */
	public void DNS_ATTACH_SEQ_LEVEL_WHEN_NEW_ITEM_INSTANCE(PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		String DNS_ATTACH_SEQ_LEVEL_STRING = pm_il_doc_no_setup_action.getCOMP_DNS_ATTACH_SEQ_LEVEL().toString();
		System.out.println(DNS_ATTACH_SEQ_LEVEL_STRING);
		if(! "000".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING)){
			if(! "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5())){
				pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_ATTACH_SEQ_LEVEL("005");
				pm_il_doc_no_setup_action.getCOMP_DNS_ATTACH_SEQ_LEVEL().setSubmittedValue("005");
			}else if(! "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4())){
				pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_ATTACH_SEQ_LEVEL("004");
			}else if(! "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3())){
				pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_ATTACH_SEQ_LEVEL("003");
			}else if(! "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2())){
				pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_ATTACH_SEQ_LEVEL("002");
			}else if(! "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1())){
				pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().setDNS_ATTACH_SEQ_LEVEL("001");
			}
		}
	}
	
	/*Added try catch block and modified validator exception by Janani on 16.05.2018 for validating seq level */
	
	public void DNS_ATTACH_SEQ_LEVEL_WHEN_LIST_CHANGED(String DNS_ATTACH_SEQ_LEVEL_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action)throws Exception
	{
		try
		{
		System.out.println("when list changed..........................");
		System.out.println(DNS_ATTACH_SEQ_LEVEL_STRING+"    level1:::::"+pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1());
		if(("001".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()))
				|| ("002".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2()))
				|| ("003".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3()))
				|| ("004".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4()))
				|| ("005".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5()))
				|| ("006".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "N".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_PREFIX_YN()))){
			//throw new ValidatorException(Messages.getMessage(bundleName,"91453"));
			throw new Exception(
					Messages
							.getString(bundleName,
									"91453"));
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
 			throw new Exception(e.getMessage());
		}
	}
	
	/*End*/
	
	
	public void DNS_ATTACH_SEQ_LEVEL_WHEN_VALIDATE_ITEM(String DNS_ATTACH_SEQ_LEVEL_STRING, PM_IL_DOC_NO_SETUP_ACTION pm_il_doc_no_setup_action){
		
		if(("001".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_1()))
				|| ("002".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_2()))
				|| ("003".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_3()))
				|| ("004".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_4()))
				|| ("005".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "000".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_LEVEL_5()))
				|| ("006".equalsIgnoreCase(DNS_ATTACH_SEQ_LEVEL_STRING) && "N".equalsIgnoreCase(pm_il_doc_no_setup_action.getPM_IL_DOC_NO_SETUP_BEAN().getDNS_PREFIX_YN()))){
			throw new ValidatorException(Messages.getMessage(bundleName,"91453"));
		}
	}
}
