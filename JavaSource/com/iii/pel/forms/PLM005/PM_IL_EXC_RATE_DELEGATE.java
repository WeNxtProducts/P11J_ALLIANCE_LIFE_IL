package com.iii.pel.forms.PLM005;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DecimalFormat;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.CommonUtils;

public class PM_IL_EXC_RATE_DELEGATE {

	
	
	
	public void executeExchangeSelectStatement(
			PLM005_COMPOSITE_ACTION PLM005_COMPOSITE_ACTION_BEAN)
					throws Exception {
				
				String selectStatement = "SELECT ROWID,  TO_CHAR(CER_EFF_FRM_DT,'dd/MM/yyyy' ) CER_EFF_FRM_DT_STR,CER_EFF_FRM_DT,"
						+"TO_CHAR(CER_EFF_TO_DT,'dd/MM/yyyy' ) CER_EFF_TO_DT_STR,CER_EFF_TO_DT,"
						+ "CER_EXG_RATE_TYPE,CER_EXG_RATE,CER_AVG_EXGE_RATE,CER_FIX_EXGE_RATE,CER_CONV_FM_CURR_CODE"
						+ " FROM FM_EXCHANGE_RATE WHERE FM_EXCHANGE_RATE.CER_CONV_FM_CURR_CODE  = ?";
				Connection connection = null;
				ResultSet resultSet = null;
				
				System.out.println("getPM_IL_CURRENCY_ACTION_BEAN    :"+PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN());
				
				System.out.println("getFM_EXCHANGE_RATE_BEAN   :"+PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getFM_EXCHANGE_RATE_BEAN());
				
				PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
				.getDataList_FM_EXCHANGE_RATE().clear();
				FM_EXCHANGE_RATE fm_exchange_rate = PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getFM_EXCHANGE_RATE_BEAN();
				try{

					
					//System.out.println("In The Select Statement: "+query);
					connection=CommonUtils.getConnection();
				//	CRUDHandler handler=new CRUDHandler();
					
					resultSet = new CRUDHandler().executeSelectStatement(
							selectStatement, connection,new Object[]{PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE()});
					System.out.println("Value is Printed       :");
					
					 
						while(resultSet.next())
					{
							 
							FM_EXCHANGE_RATE FM_EXCHANGE_RATE_BEAN = new FM_EXCHANGE_RATE();
							
							
							FM_EXCHANGE_RATE_BEAN.setROWID(resultSet.getString("ROWID"));
							
							FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT_STR(resultSet.getString("CER_EFF_FRM_DT_STR"));
							
							System.out.println("CER_EFF_FRM_DT :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT_STR());
							System.out.println(" CER_EFF_FRM_DT_STR              "+resultSet.getString("CER_EFF_FRM_DT_STR"));
							
							/*Added by Jagadeesh*/
							
							FM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT_STR(resultSet.getString("CER_EFF_TO_DT_STR"));
							
							System.out.println("CER_EFF_TO_DT :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_TO_DT_STR());
							System.out.println(" CER_EFF_TO_DT_STR              "+resultSet.getString("CER_EFF_TO_DT_STR"));
							
							/*End*/
							
							FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE(resultSet.getString("CER_EXG_RATE_TYPE"));
											
							
							System.out.println("CER_EXG_RATE_TYPE :"+FM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE_TYPE());
																										
											
							/*Added by Janani on 14.3.2016 for decimal value in exchange rate,average and fixed rate*/
							
							/*
							 * modified by Ameen on 09-03-2018 as per Vikram sir sugg . that to display the values after decimal point also 
							 * FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(decimalFormatted(resultSet.getInt("CER_EXG_RATE"),PLM005_COMPOSITE_ACTION_BEAN));*/
							FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(resultSet.getString("CER_EXG_RATE"));
														
											
							//FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(CER_EXG_RATE);
							
							System.out.println("CER_EXG_RATE :"+FM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE(resultSet.getInt("CER_AVG_EXGE_RATE"));
							
							FM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE(decimalFormatted(resultSet.getInt("CER_AVG_EXGE_RATE"),PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_AVG_EXGE_RATE :"+FM_EXCHANGE_RATE_BEAN.getCER_AVG_EXGE_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE(resultSet.getInt("CER_FIX_EXGE_RATE"));
							
							FM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE(decimalFormatted(resultSet.getInt("CER_FIX_EXGE_RATE"),PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_FIX_EXGE_RATE :"+FM_EXCHANGE_RATE_BEAN.getCER_FIX_EXGE_RATE());
							
							
							/*end*/
							
							FM_EXCHANGE_RATE_BEAN.setCER_CONV_FM_CURR_CODE(resultSet.getString("CER_CONV_FM_CURR_CODE"));
							
							System.out.println("CER_CONV_FM_CURR_CODE :"+FM_EXCHANGE_RATE_BEAN.getCER_CONV_FM_CURR_CODE());
							//System.out.println("CURR_DECIMAL :"+PM_CURRENCY_BEAN.getCURR_DECIMAL());
						//	beanClass.setInsertMode(false);
							
							System.out.println("CER_EFF_FRM_DT date :"+resultSet.getDate("CER_EFF_FRM_DT"));
							FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT(resultSet.getDate("CER_EFF_FRM_DT"));
							
							/*Added by jagadeesh*/
							
							System.out.println("CER_EFF_TO_DT date :"+resultSet.getDate("CER_EFF_TO_DT"));
							FM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT(resultSet.getDate("CER_EFF_TO_DT"));
							
							/*End*/
							
							PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
							.getDataList_FM_EXCHANGE_RATE().add(FM_EXCHANGE_RATE_BEAN);
					}
						if(PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
							.getDataList_FM_EXCHANGE_RATE().size() ==0)
						{

							 
							FM_EXCHANGE_RATE FM_EXCHANGE_RATE_BEAN = new FM_EXCHANGE_RATE();
							
							
							//FM_EXCHANGE_RATE_BEAN.setROWID(resultSet.getString("ROWID"));
							
							FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT_STR(null);
							
							FM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT_STR(null);
							
							//System.out.println("CER_EFF_FRM_DT :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT_STR());
							//System.out.println(" CER_EFF_FRM_DT_STR              "+resultSet.getString("CER_EFF_FRM_DT_STR"));
							FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE("");
											
							
							System.out.println("CER_EXG_RATE_TYPE :"+FM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE_TYPE());
																										
											
							/*Added by Janani on 14.3.2016 for decimal value in exchange rate,average and fixed rate*/
							
							FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE("0"+decimalFormatted(0,PLM005_COMPOSITE_ACTION_BEAN));
														
											
							//FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(CER_EXG_RATE);
							
							System.out.println("CER_EXG_RATE :"+FM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE(resultSet.getInt("CER_AVG_EXGE_RATE"));
							
							FM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE("0"+decimalFormatted(0,PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_AVG_EXGE_RATE :"+FM_EXCHANGE_RATE_BEAN.getCER_AVG_EXGE_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE(resultSet.getInt("CER_FIX_EXGE_RATE"));
							
							FM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE("0"+decimalFormatted(0,PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_FIX_EXGE_RATE :"+FM_EXCHANGE_RATE_BEAN.getCER_FIX_EXGE_RATE());
							
							
							/*end*/
							
							FM_EXCHANGE_RATE_BEAN.setCER_CONV_FM_CURR_CODE(PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE());
							
							System.out.println("CER_CONV_FM_CURR_CODE :"+FM_EXCHANGE_RATE_BEAN.getCER_CONV_FM_CURR_CODE());
							//System.out.println("CURR_DECIMAL :"+PM_CURRENCY_BEAN.getCURR_DECIMAL());
						//	beanClass.setInsertMode(false);
							
							
							FM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT(null);
							
							PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
							.getDataList_FM_EXCHANGE_RATE().add(FM_EXCHANGE_RATE_BEAN);
					
						}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				 finally {
						CommonUtils.closeCursor(resultSet);
					}
			}
	
	
	
	/*Added by Janani on 14.3.2016 for decimal value in exchange rate,average and fixed rate*/
	
	
	public String decimalFormatted(int convertValue,PLM005_COMPOSITE_ACTION PLM005_COMPOSITE_ACTION_BEAN)
	{
		
		System.out.println("PLM005_COMPOSITE_ACTION_BEAN               : "+PLM005_COMPOSITE_ACTION_BEAN );
		
		int decimal = PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_DECIMAL();
		
		
		
		System.out.println("decimal              :"+decimal);
		
		StringBuilder sb = new StringBuilder();
		sb.append(".");
		for(int i=0;i<decimal;i++)
		{
			sb.append("0");
		}
		DecimalFormat df = new DecimalFormat(sb.toString()); // Set your desired format here.
		
		String finalvalue = df.format(convertValue);
		
		System.out.println("value with decimal             "+finalvalue);
		
		return finalvalue;
	}
	
	
	/*end*/
	
	/*Added by Ameen on 06-04-2018 for KIC exchange rate AS PER SIVA SUGG.*/
	public void executeExchangeStatement(
			PLM005_COMPOSITE_ACTION PLM005_COMPOSITE_ACTION_BEAN)
					throws Exception {
				
				String selectStatement = "SELECT ROWID,  TO_CHAR(CER_EFF_FRM_DT,'dd/MM/yyyy' ) CER_EFF_FRM_DT_STR,CER_EFF_FRM_DT,"
						+"TO_CHAR(CER_EFF_TO_DT,'dd/MM/yyyy' ) CER_EFF_TO_DT_STR,CER_EFF_TO_DT,"
						+ "CER_EXG_RATE_TYPE,CER_EXG_RATE,CER_AVG_EXGE_RATE,CER_FIX_EXGE_RATE,CER_CONV_FM_CURR_CODE,CER_CLIENT_ID,CER_CONV_TO_CURR_CODE"
						+ " FROM PM_EXCHANGE_RATE WHERE PM_EXCHANGE_RATE.CER_CONV_FM_CURR_CODE  = ?";
				Connection connection = null;
				ResultSet resultSet = null;
				
				System.out.println("getPM_IL_CURRENCY_ACTION_BEAN    :"+PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN());
				
				System.out.println("getFM_EXCHANGE_RATE_BEAN   :"+PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getFM_EXCHANGE_RATE_BEAN());
				
				PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
				.getDataList_FM_EXCHANGE_RATE().clear();
				FM_EXCHANGE_RATE fm_exchange_rate = PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getFM_EXCHANGE_RATE_BEAN();
				try{

					
					//System.out.println("In The Select Statement: "+query);
					connection=CommonUtils.getConnection();
				//	CRUDHandler handler=new CRUDHandler();
					
					resultSet = new CRUDHandler().executeSelectStatement(
							selectStatement, connection,new Object[]{PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE()});
					System.out.println("Value is Printed       :");
					
					 
						while(resultSet.next())
					{
							 
							PM_EXCHANGE_RATE PM_EXCHANGE_RATE_BEAN = new PM_EXCHANGE_RATE();
							
							
							PM_EXCHANGE_RATE_BEAN.setROWID(resultSet.getString("ROWID"));
							
							PM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT_STR(resultSet.getString("CER_EFF_FRM_DT_STR"));
							
							System.out.println("CER_EFF_FRM_DT :"+PM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT_STR());
							System.out.println(" CER_EFF_FRM_DT_STR              "+resultSet.getString("CER_EFF_FRM_DT_STR"));
							
							/*Added by Jagadeesh*/
							
							PM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT_STR(resultSet.getString("CER_EFF_TO_DT_STR"));
							
							System.out.println("CER_EFF_TO_DT :"+PM_EXCHANGE_RATE_BEAN.getCER_EFF_TO_DT_STR());
							System.out.println(" CER_EFF_TO_DT_STR              "+resultSet.getString("CER_EFF_TO_DT_STR"));
							
							/*End*/
							
							PM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE_TYPE(resultSet.getString("CER_EXG_RATE_TYPE"));
											
							
							System.out.println("CER_EXG_RATE_TYPE :"+PM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE_TYPE());
																										
											
							/*Added by Janani on 14.3.2016 for decimal value in exchange rate,average and fixed rate*/
							
							/*
							 * modified by Ameen on 09-03-2018 as per Vikram sir sugg . that to display the values after decimal point also 
							 * FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(decimalFormatted(resultSet.getInt("CER_EXG_RATE"),PLM005_COMPOSITE_ACTION_BEAN));*/
							PM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(resultSet.getString("CER_EXG_RATE"));
														
											
							//FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(CER_EXG_RATE);
							
							System.out.println("CER_EXG_RATE :"+PM_EXCHANGE_RATE_BEAN.getCER_EXG_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE(resultSet.getInt("CER_AVG_EXGE_RATE"));
							
							PM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE(decimalFormatted(resultSet.getInt("CER_AVG_EXGE_RATE"),PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_AVG_EXGE_RATE :"+PM_EXCHANGE_RATE_BEAN.getCER_AVG_EXGE_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE(resultSet.getInt("CER_FIX_EXGE_RATE"));
							
							PM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE(decimalFormatted(resultSet.getInt("CER_FIX_EXGE_RATE"),PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_FIX_EXGE_RATE :"+PM_EXCHANGE_RATE_BEAN.getCER_FIX_EXGE_RATE());
							
							
							/*end*/
							
							PM_EXCHANGE_RATE_BEAN.setCER_CONV_FM_CURR_CODE(resultSet.getString("CER_CONV_FM_CURR_CODE"));
							
							System.out.println("CER_CONV_FM_CURR_CODE :"+PM_EXCHANGE_RATE_BEAN.getCER_CONV_FM_CURR_CODE());
							//System.out.println("CURR_DECIMAL :"+PM_CURRENCY_BEAN.getCURR_DECIMAL());
						//	beanClass.setInsertMode(false);
							
							System.out.println("CER_EFF_FRM_DT date :"+resultSet.getDate("CER_EFF_FRM_DT"));
							PM_EXCHANGE_RATE_BEAN.setCER_EFF_FRM_DT(resultSet.getDate("CER_EFF_FRM_DT"));
							
							/*Added by jagadeesh*/
							
							System.out.println("CER_EFF_TO_DT date :"+resultSet.getDate("CER_EFF_TO_DT"));
							PM_EXCHANGE_RATE_BEAN.setCER_EFF_TO_DT(resultSet.getDate("CER_EFF_TO_DT"));
							
							/*End*/
							
							/*Newly added*/
							PM_EXCHANGE_RATE_BEAN.setCER_CLIENT_ID(resultSet.getString("CER_CLIENT_ID"));
							PM_EXCHANGE_RATE_BEAN.setCER_CONV_TO_CURR_CODE(resultSet.getString("CER_CONV_TO_CURR_CODE"));
							/*End*/
							
							PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
							.getDataList_PM_EXCHANGE_RATE().add(PM_EXCHANGE_RATE_BEAN);
					}
						/*if(PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
							.getDataList_PM_EXCHANGE_RATE().size() ==0)
						{

							 
							PM_EXCHANGE_RATE pm_exchange_rate_bean = new PM_EXCHANGE_RATE();
							
							
							//FM_EXCHANGE_RATE_BEAN.setROWID(resultSet.getString("ROWID"));
							
							pm_exchange_rate_bean.setCER_EFF_FRM_DT_STR(null);
							
							pm_exchange_rate_bean.setCER_EFF_TO_DT_STR(null);
							
							//System.out.println("CER_EFF_FRM_DT :"+FM_EXCHANGE_RATE_BEAN.getCER_EFF_FRM_DT_STR());
							//System.out.println(" CER_EFF_FRM_DT_STR              "+resultSet.getString("CER_EFF_FRM_DT_STR"));
							pm_exchange_rate_bean.setCER_EXG_RATE_TYPE("");
											
							
							System.out.println("CER_EXG_RATE_TYPE :"+pm_exchange_rate_bean.getCER_EXG_RATE_TYPE());
																										
											
							Added by Janani on 14.3.2016 for decimal value in exchange rate,average and fixed rate
							
							pm_exchange_rate_bean.setCER_EXG_RATE("0"+decimalFormatted(0,PLM005_COMPOSITE_ACTION_BEAN));
														
											
							//FM_EXCHANGE_RATE_BEAN.setCER_EXG_RATE(CER_EXG_RATE);
							
							System.out.println("CER_EXG_RATE :"+pm_exchange_rate_bean.getCER_EXG_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_AVG_EXGE_RATE(resultSet.getInt("CER_AVG_EXGE_RATE"));
							
							pm_exchange_rate_bean.setCER_AVG_EXGE_RATE("0"+decimalFormatted(0,PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_AVG_EXGE_RATE :"+pm_exchange_rate_bean.getCER_AVG_EXGE_RATE());
							
							//FM_EXCHANGE_RATE_BEAN.setCER_FIX_EXGE_RATE(resultSet.getInt("CER_FIX_EXGE_RATE"));
							
							pm_exchange_rate_bean.setCER_FIX_EXGE_RATE("0"+decimalFormatted(0,PLM005_COMPOSITE_ACTION_BEAN));
							
							System.out.println("CER_FIX_EXGE_RATE :"+pm_exchange_rate_bean.getCER_FIX_EXGE_RATE());
							
							
							end
							
							pm_exchange_rate_bean.setCER_CONV_FM_CURR_CODE(PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN().getPM_CURRENCY_BEAN().getCURR_CODE());
							
							System.out.println("CER_CONV_FM_CURR_CODE :"+pm_exchange_rate_bean.getCER_CONV_FM_CURR_CODE());
							//System.out.println("CURR_DECIMAL :"+PM_CURRENCY_BEAN.getCURR_DECIMAL());
						//	beanClass.setInsertMode(false);
							
							
							pm_exchange_rate_bean.setCER_EFF_FRM_DT(null);
							
							PLM005_COMPOSITE_ACTION_BEAN.getPM_IL_CURRENCY_ACTION_BEAN()
							.getDataList_PM_EXCHANGE_RATE().add(pm_exchange_rate_bean);
					
						}*/
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				 finally {
						CommonUtils.closeCursor(resultSet);
					}
			}
	/*End*/
	
}
