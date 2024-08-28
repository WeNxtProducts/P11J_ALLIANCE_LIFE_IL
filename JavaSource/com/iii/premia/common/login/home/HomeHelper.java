package com.iii.premia.common.login.home;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.utils.ReportUtils;
import com.iii.premia.common.commonimpl.chartimpl.bean.ChartQueryBean;
import com.iii.premia.common.commonimpl.chartimpl.helper.ChartHelper;
import com.iii.premia.common.commonimpl.chartimpl.helper.ServletUtility;
import com.iii.premia.common.utils.CommonUtils;

public class HomeHelper {

	public ArrayList<ChartQueryBean> prepareChartListForUser(String userId)
			throws Exception {
		ArrayList<ChartQueryBean> chartList = null;
		ServletUtility servletUtility = new ServletUtility();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();
		String chartTitle = null;
		String chartURL = null;

		chartList = getChartListForUserId(userId);
		for (ChartQueryBean chartBean : chartList) {
			chartURL = servletUtility.generateImageURLForChartCode(chartBean
					.getChartId(), 0, 0, request, response);
			chartTitle = servletUtility.getChartWindowHeader();

			chartBean.setChartURL(chartURL);
			chartBean.setChartDescription(chartTitle);
		}

		return chartList;
	}

	public ArrayList<ChartQueryBean> getChartListForUserId(String userId)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<ChartQueryBean> chartList = new ArrayList<ChartQueryBean>();
		ChartQueryBean chartBean = null;
		ResultSet resultSet = null;
		String query = "SELECT CHART_MAPPING.CHART_ID, CHART_USER_ID, CHART_DISP_SEQ_NO "
				+ " FROM PGIM_PORTAL_CHART_USER_MAPPING  CHART_MAPPING, "
				+ " PGIM_PORTAL_CHART_QUERY CHART_QUERY "
				+ " WHERE CHART_QUERY.CHART_ID=CHART_MAPPING.CHART_ID "
				+ " AND CHART_QUERY.CHART_TYPE <> '3' "
				+ " AND CHART_USER_ID=? ORDER BY CHART_DISP_SEQ_NO";

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { userId });
			while (resultSet.next()) {
				chartBean = new ChartQueryBean();
				chartBean.setChartId(resultSet.getString("CHART_ID"));
				chartList.add(chartBean);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

		return chartList;
	}

	/*
	 * [ Added by Yalamanda for DashBoard Reports
	 */
	public ArrayList<DashBoardBean> prepareReportListForUser(String userId)
			throws Exception {
		ArrayList<DashBoardBean> reportList = null;
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		String reportPDFURL = null;
		String reportExcelURL = null;
		Map<String, String> map = new HashMap<String, String>();
		IP_REP_INFO ip_rep_info = null;
		reportList = getReportListForUserId(userId);
		for (DashBoardBean reportBean : reportList) {
			// map = new HashMap<String, String>();
			// map.put("P_LANG_CODE",
			// CommonUtils.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			// map.put("P_REP_NAME", reportBean.getReportID());
			// ------------------------ PDF Block -------------------------
			ip_rep_info = new IP_REP_INFO();
			ip_rep_info.setREP_ID(reportBean.getReportID());
			ip_rep_info.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			ip_rep_info.setREP_CR_DT(new CommonUtils().getCurrentDate());
			ip_rep_info.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			ip_rep_info.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			ip_rep_info.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			ip_rep_info.setSelectedFileType("PDF");
			executeSaveAction(ip_rep_info);
			reportPDFURL = ReportUtils.getReportRedirectString(ip_rep_info
					.getREP_KEY_NO(), reportBean.getReportID(), null, ip_rep_info.getSelectedFileType());
			// -----------------------------
			// ------------------------ Excel Block -------------------------
			ip_rep_info = new IP_REP_INFO();
			ip_rep_info.setREP_ID(reportBean.getReportID());
			ip_rep_info.setREP_KEY_NO(new ReportUtils().getRepKeyNo());
			ip_rep_info.setREP_CR_DT(new CommonUtils().getCurrentDate());
			ip_rep_info.setREP_VALUE_20(CommonUtils
					.getGlobalVariable("GLOBAL.M_COMP_CODE"));
			ip_rep_info.setREP_VALUE_21(CommonUtils
					.getGlobalVariable("GLOBAL.M_LANG_CODE"));
			ip_rep_info.setREP_CR_UID(CommonUtils
					.getGlobalVariable("GLOBAL.M_USER_ID"));
			ip_rep_info.setSelectedFileType("E");
			executeSaveAction(ip_rep_info);
			reportExcelURL = ReportUtils.getReportRedirectString(ip_rep_info
					.getREP_KEY_NO(), reportBean.getReportID(), null, ip_rep_info.getSelectedFileType());
			// -----------------------------

			// reportPDFURL=
			// ReportUtils.getReportRedirectString(ip_rep_info.getREP_KEY_NO(),reportBean.getReportID(),reportBean.getReportID(),"PDF",map
			// );
			// reportExcelURL =
			// ReportUtils.getReportRedirectString(ip_rep_info.getREP_KEY_NO(),reportBean.getReportID(),reportBean.getReportID(),"excel");

			reportBean.setReportPDFURL(reportPDFURL);
			reportBean.setReportExcelURL(reportExcelURL);

		}

		return reportList;
	}

	public ArrayList<DashBoardBean> getReportListForUserId(String userId)
			throws Exception {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ArrayList<DashBoardBean> reportList = new ArrayList<DashBoardBean>();
		DashBoardBean reportBean = null;
		ResultSet resultSet = null;
		String query = "SELECT CHART_QUERY.CHART_ID, CHART_USER_ID, "
				+ " CHART_DISP_SEQ_NO,CHART_DESC,CHART_QUERY  "
				+ " FROM PGIM_PORTAL_CHART_USER_MAPPING CHART_MAPPING, "
				+ " PGIM_PORTAL_CHART_QUERY CHART_QUERY "
				+ " WHERE CHART_QUERY.CHART_ID=CHART_MAPPING.CHART_ID "
				+ " AND CHART_QUERY.CHART_TYPE='3' AND CHART_MAPPING.CHART_ID IN ('R04','R05','R06') "
				+  " AND CHART_USER_ID=? "
				+ " ORDER BY CHART_DISP_SEQ_NO";

		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(query, connection,
					new Object[] { userId });
			while (resultSet.next()) {
				reportBean = new DashBoardBean();
				reportBean.setChartID(resultSet.getString("CHART_ID"));
				reportBean.setReportCaption(resultSet.getString("CHART_DESC"));
				reportBean.setReportID(resultSet.getString("CHART_QUERY"));
				reportList.add(reportBean);
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} finally {
			try {
				CommonUtils.closeCursor(resultSet);
			} catch (Exception e) {
			}
		}

		return reportList;
	}

	private void executeSaveAction(IP_REP_INFO ip_rep_info_bean) {
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		int i = 0;
		try {
			connection = CommonUtils.getConnection();
			i = handler.executeInsert(ip_rep_info_bean, connection);
		} catch (SQLException exception) {
			exception.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * Added by Yalamanda for DashBoard Reports ]
	 */

	// Added to rebuild the chart if deleted
	public void restoreChartsForUser(ArrayList<ChartQueryBean> chartList)
			throws Exception {

		if (chartList != null && chartList.size() > 0) {
			System.out.println("Restoring chart files..");
			for (ChartQueryBean chartBean : chartList) {
				if (ChartHelper.isChartImageExists(chartBean.getChartURL())) {
					// Considered all charts vanishes together,
					// Assumes if first chart exists, all charts do exist
					System.out.println("Chart files not vanished..");
					break;
				} else {
					System.out
							.println("Creating chartfiles again for chartid: "
									+ chartBean.getChartId());
					generateChart(chartBean);
				}
			}
		}
	}

	public void generateChart(ChartQueryBean chartBean) throws Exception {
		String chartTitle = null;
		String chartURL = null;
		ServletUtility servletUtility = new ServletUtility();
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		HttpServletRequest request = (HttpServletRequest) externalContext
				.getRequest();
		HttpServletResponse response = (HttpServletResponse) externalContext
				.getResponse();

		chartURL = servletUtility.generateImageURLForChartCode(chartBean
				.getChartId(), 0, 0, request, response);
		chartTitle = servletUtility.getChartWindowHeader();
		chartBean.setChartURL(chartURL);
		chartBean.setChartDescription(chartTitle);
	}
}
