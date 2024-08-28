package com.iii.pel.forms.CHART;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iii.apps.persistence.CRUDHandler;
import com.iii.premia.common.exception.DBException;
import com.iii.premia.common.utils.CommonUtils;

public class ChartQueryResultSet {
	private ArrayList<ChartQueryResultRow> records;
	private ArrayList<String> metaData;
	
	public ChartQueryResultSet(){
		records = new ArrayList<ChartQueryResultRow>();
		metaData = new ArrayList<String>();
		prepareDefaultMetaData(metaData);
	}

	public ArrayList<ChartQueryResultRow> getRecords() {
		return records;
	}

	public void setRecords(ArrayList<ChartQueryResultRow> records) {
		this.records = records;
	}

	public void addRecord(ChartQueryResultRow record) {
		this.records.add(record);
	}

	public ArrayList<String> getMetaData() {
		return metaData;
	}

	public void setMetaData(ArrayList<String> metaData) {
		this.metaData = metaData;
	}
	
	public static ChartQueryResultSet prepareQueryResultSet(ResultSet resultSet) throws Exception{
		ResultSetMetaData resultSetMetaData = null;
		int columnCount = -1;
		ChartQueryResultRow row = null;
		ChartQueryResultSet queryResultSet = new ChartQueryResultSet();
		
		try {
			// Reset the records and metadata for new result set
			queryResultSet.getRecords().clear();
			queryResultSet.getMetaData().clear();
			
			// Process the result set
			if(resultSet != null){
				resultSetMetaData = resultSet.getMetaData();
				columnCount = resultSetMetaData.getColumnCount();
				
				// Prepare meta data
				for(int index=1; index<=columnCount; index++){
					queryResultSet.getMetaData().add(resultSetMetaData.getColumnName(index));
				}
				
				// Processing result set
				if(resultSet.next()){
					do{
						row = new ChartQueryResultRow();
						for(int index=1; index<=columnCount; index++){
							row.addColumnValue(resultSet.getObject(index));
						}
						
						queryResultSet.addRecord(row);
					}while(resultSet.next());
				}
			}else{
				// Prepare default meta data
				prepareDefaultMetaData(queryResultSet.getMetaData());
			}
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		}
		
		return queryResultSet;
	}
	
	private static void prepareDefaultMetaData(ArrayList<String> metadataList){
		metadataList.add("Value1..");
		metadataList.add("Value2..");
		metadataList.add("Value3..");
	}
	
	public static ChartQueryResultSet executeAndPrepareQueryResultSet(String chartId, 
			String chartQuery) throws Exception{
		Connection connection = null;
		CRUDHandler handler = new CRUDHandler();
		ChartQueryResultSet queryResultSet = null;
		ResultSet resultSet = null;
		
		try {
			connection = CommonUtils.getConnection();
			resultSet = handler.executeSelectStatement(chartQuery, connection);
			queryResultSet = prepareQueryResultSet(resultSet);
		} catch (DBException e) {
			throw new Exception(e.getMessage());
		} catch (SQLException e) {
			throw new Exception(e.getMessage());
		} finally{
			try{CommonUtils.closeCursor(resultSet);}catch(Exception e){}
		}
		
		return queryResultSet;
	}
	
	public int getColumnCount(){
		return metaData.size();
	}
}
