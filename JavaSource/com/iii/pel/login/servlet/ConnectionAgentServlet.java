package com.iii.pel.login.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.SimpleConnectionAgent;

public class ConnectionAgentServlet extends HttpServlet {
	
	public void init(ServletConfig conf) throws ServletException{
		super.init(conf);
		try {
		Properties properties = new Properties();
		
		FileInputStream in;
		
//		in = new FileInputStream(new File("E:\\workspace\\Annotations\\src\\com\\iii\\apps\\persistence\\database.properties"));
		properties.load((new FileInputStream((new StringBuilder(String.valueOf((new File(".")).getAbsolutePath()))).append(File.separator).append("config").append(File.separator).append("datasource.properties").toString())));		
		SimpleConnectionAgent connection = new SimpleConnectionAgent(properties);		
		conf.getServletContext().setAttribute("connectionAgent", connection);
		System.out.println("\n\n ConnectionAgent set in the application scope ******" +(SimpleConnectionAgent)getServletContext().getAttribute("connectionAgent"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}
}
