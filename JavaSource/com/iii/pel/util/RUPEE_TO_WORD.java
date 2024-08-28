package com.iii.pel.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class RUPEE_TO_WORD {

	String[] unitdo ={"Zero", " One", " Two", " Three", " Four", " Five",
			" Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve",
			" Thirteen", " Fourteen", " Fifteen",  " Sixteen", " Seventeen", 
			" Eighteen", " Nineteen"};
	String[] tens =  {"Zero", "Ten", " Twenty", " Thirty", " Forty", " Fifty",
			" Sixty", " Seventy", " Eighty"," Ninety"};
	String[] digit = {"Zero", " Hundred", " Thousand", " Lakh", " Crore"};
	int r;
	//added by gopinath on 09/07/2016 for the ssp call no-FALCONQC-1714483
	Boolean flag=false;

//end
	/*public String getRupeeinword(String Rupee){

		//String no="16361.66.";

		String[] sep = Rupee.split("\\.");
		System.out.println(sep.length);
		System.out.println(sep[0]);
		System.out.println(sep[1]);


		int len, q=0, r=0;
		String ltr = " ";
		String Str = "";
		
		for(int i=0;i<sep.length;i++){
			if(!sep[i].equals("0")&&!sep[i].equals("00")&&!sep[i].equals("000")){
				//added by gopinath on 09/07/2016 for the ssp call no-FALCONQC-1714483
				
				char checkzero =sep[i].charAt(0);
				
				if(checkzero=='0'){
					flag=true;
				}
				//end
				int num = Integer.parseInt(sep[i]);
				System.out.println(num);

				if (num <= 0) System.out.println("Zero or Negative number not for conversion");
				
				if(i>=1&&i<sep.length)
				{
					//added by gopinath on 09/07/2016 for the ssp call no-FALCONQC-1714483
					Str=Str+" and"+" "+"Baizas"+" ";
					//end
				}

				while (num>0)
				{
				

					len = numberCount(num);

					//Take the length of the number and do letter conversion

					switch (len)

					{
					case 8:
						q=num/10000000;
						r=num%10000000;
						ltr = twonum(q);
						Str = Str+ltr+digit[4];
						num = r;
						break;

					case 7:
					case 6:
						q=num/100000;
						r=num%100000;
						ltr = twonum(q);
						Str = Str+ltr+digit[3];
						num = r;
						break;

					case 5:
					case 4:

						q=num/1000;
						r=num%1000;
						ltr = twonum(q);
						Str= Str+ltr+digit[2];
						num = r;
						break;

					case 3:


						if (len == 3)
							r = num;
						ltr = threenum(r);
						Str = Str + ltr;
						num = 0;
						break;

					case 2:
						
						if(num>10&&num<=19)
						{
							Str =  Str+unitdo[num];
						}else{
							ltr = twonum(num);
							Str =  Str +ltr ;
						}

						
						//Str =  ltr;
						num=0;
						break;

					case 1:
						Str = Str + unitdo[num];
						num=0;
						break;
					default:

						num=0;
						System.out.println("Exceeding Crore....No conversion");
						System.exit(1);


					}
					if (num==0)
						System.out.println(Str+" Only");
				}
			}
		}
		//added by gopinath on 09/07/2016 for the ssp call no-FALCONQC-1714483
        return Str +" "+"only";
        //end
	    }*/

	/*Modified by Ram on 23/12/2016 for Displaying Proper word value*/
	public String getRupeeinword(String Rupee) throws Exception{
String amountInWords = "";

System.out.println("Rupee      "+Rupee);
String[] RupeeArray = Rupee.split("\\.");
System.out.println("RupeeArray length       "+RupeeArray.length);
String query = null;
if(RupeeArray[1] != null && !RupeeArray[1].equals("000"))
{
	query = "SELECT  (INITCAP(TO_CHAR (TO_DATE ("+RupeeArray[0]+", 'j'), 'jsp'))) || '  Riyals And ' || (INITCAP(TO_CHAR "
			+ "(TO_DATE ("+RupeeArray[1]+", 'j'), 'jsp'))) || ' Baizas Only' FROM DUAL";	
	/*Changed by Ram on 05/01/2017*/ 
	if(RupeeArray[0] != null && RupeeArray[0].equals("0"))
	{
		System.out.println("Zero Rupees");
		query = "SELECT  (INITCAP(TO_CHAR "
				+ "(TO_DATE ("+RupeeArray[1]+", 'j'), 'jsp'))) || ' Baizas Only' FROM DUAL";	
	}
	/*End*/
}
else
{
	query = "SELECT  (INITCAP(TO_CHAR (TO_DATE ("+RupeeArray[0]+", 'j'), 'jsp'))) || '  Riyals Only' FROM DUAL";
}
System.out.println(" query    "+query);
ResultSet rs = new CRUDHandler().executeSelectStatement(query, CommonUtils.getConnection());
while(rs.next())
{
	amountInWords = rs.getString(1);
}
System.out.println("amountInWords      "+amountInWords);
return amountInWords;
	}

	public String getRupeeinword(String Rupee,Connection con) throws Exception{
		String amountInWords = "";

		System.out.println("Rupee      "+Rupee);
		String[] RupeeArray = Rupee.split("\\.");
		System.out.println("RupeeArray length       "+RupeeArray.length);
		String query = null;
		/*Modified by Ram on 28/03/2017 for get Amount value in string format
		 * 
		 * if(RupeeArray[1] != null && !RupeeArray[1].equals("000"))
		{
			query = "SELECT  (INITCAP(TO_CHAR (TO_DATE ("+RupeeArray[0]+", 'j'), 'jsp'))) || '  Riyals And ' || (INITCAP(TO_CHAR "
					+ "(TO_DATE ("+RupeeArray[1]+", 'j'), 'jsp'))) || ' Baizas Only' FROM DUAL";	
		}
		else
		{
			query = "SELECT  (INITCAP(TO_CHAR (TO_DATE ("+RupeeArray[0]+", 'j'), 'jsp'))) || '  Riyals Only' FROM DUAL";
		}*/
		
		System.out.println("Currency Code         "+CommonUtils.getGlobalObject("GLOBAL.M_BASE_CURR"));
		
			query = "SELECT f_amount_to_words_1('"+Rupee+"','"+(CommonUtils.getGlobalObject("GLOBAL.M_BASE_CURR"))+"','','N') FROM DUAL";
			
			/*End*/
			
		System.out.println(" query    "+query);
		ResultSet rs = new CRUDHandler().executeSelectStatement(query, con);
		while(rs.next())
		{
			amountInWords = rs.getString(1);
		}
		System.out.println("amountInWords      "+amountInWords);
		return amountInWords;
			}
	/*End*/
	public String getamtfromtable(String id,String DEP_DOC_NO ,Connection con){

		CRUDHandler handler;
		String query=null;
		String Amt_From_Table =" ";
		ResultSet resultSet = null;
		boolean rs_vlaue=false;
		
		try{
			handler = new CRUDHandler();
			query ="SELECT DEP_LC_DEP_AMT FROM PM_CUSTOMER, PT_IL_POLICY, PT_IL_DEPOSIT  WHERE CUST_CODE = POL_CUST_CODE AND POL_NO = DEP_REF_NO  AND DEP_REF_NO=? AND DEP_DOC_NO =?";
			resultSet = handler.executeSelectStatement(query, con,new Object[] {id,DEP_DOC_NO});
		
			if(resultSet.next() == true){
			do{
						 Amt_From_Table =Double.toString(resultSet.getDouble(1));
			 
			}while(resultSet.next());
		}
			else
			{
				Amt_From_Table="0.00";
			}
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
			
		return Amt_From_Table;




	}

	//added by agalya
	public String getamountfromtable(String PC_REF_NO,String PC_DRCR_DOC_NO ,Connection con){

		System.out.println("teststs");
		CRUDHandler handler;
		String query=null;
		String TOTAL_AMT =" ";
		Double PC_LC_GROSS_PREM;
		Double PC_LC_CHARGE ;
		Double Addition;
		ResultSet resultSet = null;
		
		System.out.println("PC_REF_NO----"+PC_REF_NO);
		System.out.println("PC_DRCR_DOC_NO "+PC_DRCR_DOC_NO);
		
		try{
			handler = new CRUDHandler();
			/*Modifeid by Ram on 14/02/2017 for Waving Process calculation*/
			/*
			 * 
			 * query ="SELECT NVL(PC_FC_PAID_AMT,(nvl(PC_LC_GROSS_PREM, 0) + nvl(PC_LC_CHARGE, 0) +nvl(PC_FC_LOAD_AMT, 0) - nvl(PC_FC_DISCOUNT, 0) +DECODE(PC_WAIVE_PREM_YN, 'Y', 0, nvl(PC_FC_UNPAID_PREM_INT, 0)))) PREM_AMT FROM PM_CUSTOMER, PT_IL_POLICY, PT_IL_PREM_COLL WHERE CUST_CODE = POL_CUST_CODE AND PC_POL_SYS_ID = POL_SYS_ID AND POL_NO = ? AND PC_DRCR_DOC_NO =?";
			 * 
			 * 
			 * */
			/* Newly Added By Dhinesh on 26-7-2017 for ssp call id : ZBILQC-1732117 */
			query ="SELECT (nvl(PC_LC_GROSS_PREM, 0) + nvl(PC_LC_CHARGE, 0) + nvl(PC_FC_LOAD_AMT, 0) - nvl(PC_FC_DISCOUNT, 0) + DECODE(PC_WAIVE_PREM_YN, 'Y', 0, nvl(PC_FC_UNPAID_PREM_INT, 0))) PREM_AMT  FROM PM_CUSTOMER, PT_IL_POLICY, PT_IL_PREM_COLL WHERE CUST_CODE = POL_CUST_CODE   AND PC_POL_SYS_ID = POL_SYS_ID   AND POL_NO = ?  AND PC_DRCR_DOC_NO = ? ";
			/* End */
			
			
			
			/*End*/
			// below query modified by dhinesh on 16.1.2017 suggested by kuzhandaivel sir
			//query ="SELECT (PC_LC_GROSS_PREM+PC_LC_CHARGE) PREM_AMT FROM PM_CUSTOMER, PT_IL_POLICY,PT_IL_PREM_COLL  WHERE CUST_CODE = POL_CUST_CODE   AND POL_NO=? AND PC_DRCR_DOC_NO =?";
			/*query ="SELECT (nvl(PC_LC_GROSS_PREM,0) + nvl(PC_LC_CHARGE,0) + nvl(PC_FC_LOAD_AMT,0) - nvl(PC_FC_DISCOUNT,0) + nvl(PC_FC_UNPAID_PREM_INT,0)) PREM_AMT FROM PM_CUSTOMER, PT_IL_POLICY,PT_IL_PREM_COLL  WHERE CUST_CODE = POL_CUST_CODE AND PC_POL_SYS_ID = POL_SYS_ID  AND POL_NO=? AND PC_DRCR_DOC_NO =?";*/
			/*Reverted by Ram on 02/02/2017 for Premium Collection*/

			/*Modifeid by Ram on 06/02/2017 for Waving Process calculation
			query ="SELECT (nvl(PC_LC_GROSS_PREM,0) + nvl(PC_LC_CHARGE,0) + nvl(PC_FC_LOAD_AMT,0) - nvl(PC_FC_DISCOUNT,0) + DECODE(PC_WAIVE_PREM_YN,'Y',0,nvl(PC_FC_UNPAID_PREM_INT, 0)))  PREM_AMT FROM PM_CUSTOMER, PT_IL_POLICY,PT_IL_PREM_COLL  WHERE CUST_CODE = POL_CUST_CODE AND PC_POL_SYS_ID = POL_SYS_ID  AND POL_NO=? AND PC_DRCR_DOC_NO =?";
			End*/
			/*query ="SELECT PC_FC_PAID_AMT PREM_AMT FROM PM_CUSTOMER, PT_IL_POLICY,PT_IL_PREM_COLL  WHERE CUST_CODE = POL_CUST_CODE AND PC_POL_SYS_ID = POL_SYS_ID  AND POL_NO=? AND PC_DRCR_DOC_NO =?";*/
			/*End*/
			resultSet = handler.executeSelectStatement(query, con,new Object[] {PC_REF_NO,PC_DRCR_DOC_NO});
		
			if(resultSet.next()){
				TOTAL_AMT =Double.toString(resultSet.getDouble(1));
			}
			else
			{
				TOTAL_AMT="0.00";
			}
		
		}catch (Exception e) {
			System.out.println(e);
		}
		
			
		return TOTAL_AMT;




	}



	//Count the number of digits in the input number
	int numberCount(int num)
	{
		int cnt=0;

		while (num>0)
		{
			r = num%10;
			cnt++;
			num = num / 10;
		}

		return cnt;
	}


	//Function for Conversion of two digit

	String twonum(int numq)
	{
		int numr, nq;
		String ltr="";

		nq = numq / 10;
		numr = numq % 10;
		//added by gopinath on 09/07/2016 for the ssp call no-FALCONQC-1714483
		if(flag){
			ltr=ltr+unitdo[0];
		}
//end
		
		/*   commentted By Dhinesh if (numq>19)*/
		if (numq>0)
		{
			if(numr==0)
			{
				ltr=ltr+tens[nq];
				System.out.println("numr==0   "+ltr);
			}
			else
			{
				if(nq==0)
				{
					ltr=ltr+unitdo[numr];	
					System.out.println("nq==0   "+ltr);
				}
				else
				{
					ltr=ltr+tens[nq]+unitdo[numr];
					System.out.println("nq !=0   "+ltr);
				}
			
			}
		
		}
		else
		{
			ltr = ltr+unitdo[numq];
		}

		return ltr;
	}

	//Function for Conversion of three digit

	String threenum(int numq)
	{
		int numr, nq;
		String ltr = "";
		
		nq = numq / 100;
		numr = numq % 100;

		if (numr == 0)
		{
			ltr = ltr + unitdo[nq]+digit[1];
		}
		else
		{
			//ltr = ltr +unitdo[nq]+digit[1]+" and"+twonum(numr);
			
			if(numr>10&&numr<=19)
			{
				ltr = ltr +unitdo[nq]+digit[1]+unitdo[numr];
			}else{
				ltr = ltr +unitdo[nq]+digit[1]+twonum(numr);
			}
			
			
			
			
		}
		return ltr;

	}

	//added by gopi
	public String paymentMode(String id,Connection con) throws Exception
	{
		
		CRUDHandler handler;
		String query=null;
		ResultSet resultSet = null;
		String PAYMENT_MODE="";
		
		
		try{
			handler = new CRUDHandler();
			query="SELECT DISTINCT INITCAP(LIV_CODE_DESC)"
					+ "FROM PT_IL_DEPOSIT_PYMT_DTLS, PP_LIST_ITEM_VALUES, PT_IL_DEPOSIT  WHERE DEP_REF_NO =?"
				   +"AND DPD_DEP_SYS_ID = DEP_SYS_ID   AND LIV_SYS_PARAM = 'GL_PAY_MODE'   AND DPD_PAY_MODE = LIV_CODE";
			resultSet = handler.executeSelectStatement(query, con,new Object[] {id});
					
			
			while(resultSet.next())
			{
			
				PAYMENT_MODE =resultSet.getString(1);
			}
		}catch (Exception e) {
			System.out.println(e);
	
	}
		System.out.println("gopi   "+PAYMENT_MODE);
		return PAYMENT_MODE;
	
	}

	
	//added by Agalya
	
	public String paymentMode1(String PC_REF_NO,Connection con) throws Exception
	{
		
		CRUDHandler handler;
		String query=null;
		ResultSet resultSet = null;
		String PAYMENT_MODE="";
		
		
		try{
			handler = new CRUDHandler();
			query="SELECT DISTINCT INITCAP(LIV_CODE_DESC) FROM PT_IL_PYMT_DTLS, PP_LIST_ITEM_VALUES, PT_IL_PREM_COLL WHERE PD_TXN_SYS_ID = PC_SYS_ID AND LIV_SYS_PARAM = 'GL_PAY_MODE' AND PD_PAY_MODE = LIV_CODE   AND PC_REF_NO =?";
			resultSet = handler.executeSelectStatement(query, con,new Object[] {PC_REF_NO});
					
			
			while(resultSet.next())
			{
			
				PAYMENT_MODE =resultSet.getString(1);
			}
		}catch (Exception e) {
			System.out.println(e);
	
	}
		System.out.println("gopi   "+PAYMENT_MODE);
		return PAYMENT_MODE;
	
	}


}