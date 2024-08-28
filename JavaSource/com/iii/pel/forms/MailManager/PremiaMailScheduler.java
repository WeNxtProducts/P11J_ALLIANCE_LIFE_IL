package com.iii.pel.forms.MailManager;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.iii.pel.forms.sms.SendingSms;
import com.iii.pel.forms.sms.SmsGenerator;
import com.iii.pel.log4j.Log4jServlet;

public class PremiaMailScheduler implements Job {
	private final static Logger log= Logger
			.getLogger(Log4jServlet.class);
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		System.out.println("Premia Mail Scheduler begins...");
		log.info("Testing line...");
		
		SendingSms sendingSms = new SendingSms();
		/*Added by ganesh on 23-04-2018 for sending sms*/
		SmsGenerator generateSMS = new SmsGenerator();
		/*end*/
		try {
			
			/*Commented by ganesh on moved to daily reminder time on 16-08-2017*/
			/*Added by saritha on 19-12-2016 RM018T -DEV_IL_ZB Life_015-Lapsation and commission clawback 2*/
			//sendingSms.lapseremainderMail();
			/*End*/
			
			/*Commented and addded by Saranya RM018T - FSD_IL_ZB Life_016-Queried Proposals v1 on 27-12-2016*/
			
			/*Commented and added by ganesh on 23-06-2017,ZBILQC-1719334*/
			sendingSms.sendMail();
			//sendingSms.remainderMail();
			/*end*/
			/*End*/
			/*Added by ganesh on 23-04-2018 for sending sms*/
			generateSMS.triggerSMS();
			/*end*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
