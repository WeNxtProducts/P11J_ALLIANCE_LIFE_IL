package com.iii.pel.forms.filedownload;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.pel.forms.PILP207.PW_IL_BENIFIT_PAYMT_ACTION;
import com.iii.premia.common.utils.CommonUtils;

public class PaynetProcessDownloadImpl implements FileDownload {

	List<String> headercaptionList = null;
	String DataQuery = null;

	public void writeCSVToResponse(HttpServletResponse response,
			StringBuffer baos, String fileName, Connection connection) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void createCSV(String fileName, HttpServletRequest request,
			HttpServletResponse response) {
		Connection con = null;
		String schedulerDate = request.getParameter("sysdate");	
		if(schedulerDate==null){			
			schedulerDate = CommonUtils.dateToStringFormatter(new Date());
			System.out.println("Date null-Optional Date"+schedulerDate);
			
		}
		try {
			con = DBUtils.getJDBCConnection();
			System.out.println("Paynet Process Download generation...");

			PW_IL_BENIFIT_PAYMT_ACTION.writePaynetProcess(con,schedulerDate,schedulerDate,"Y");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
