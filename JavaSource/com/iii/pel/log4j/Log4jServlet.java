package com.iii.pel.log4j;


import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


/*@WebServlet(name="log4jservlet",urlPatterns={"/Log4jInitServlet"},
		initParams={@WebInitParam(name="log4j-properties-location",value="WEB-INF/log4j.properties")},
		loadOnStartup=0)*/
public class Log4jServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String WEB_APP_PATH = null; 
	
	private final static Logger log= Logger
			.getLogger(Log4jServlet.class);
	
	public void init(ServletConfig config) throws ServletException {
		log.info("Log4JInitServlet is initializing log4j");
		String log4jLocation = config.getInitParameter("log4j-properties-location");

		ServletContext sc = config.getServletContext();		
		String fileName =sc.getRealPath(File.separator) + "WEB-INF" + File.separator + "logs";
		File f=new File(fileName);
		if(!f.exists()){
			f.mkdir();
		}
		System.out.println(fileName);
		System.setProperty("rootPath", fileName);
		
		if (log4jLocation == null) {
			System.err.println("*** No log4j-properties-location init param, so initializing log4j with BasicConfigurator");
			BasicConfigurator.configure();
		} else {
			WEB_APP_PATH = sc.getRealPath(File.separator);
			String log4jProp = WEB_APP_PATH + log4jLocation;
			System.out.println("log4jProp :"+log4jProp);
			File log4jPropFilepath = new File(log4jProp);
			
			if (log4jPropFilepath.exists()) {
				log.info("Initializing log4j with: " + log4jProp);
				PropertyConfigurator.configure(log4jProp);
				
			} else {
				System.err.println("*** " + log4jProp + " file not found, so initializing log4j with BasicConfigurator");
				BasicConfigurator.configure();
			}
		}
		super.init(config);
	}
	

}
