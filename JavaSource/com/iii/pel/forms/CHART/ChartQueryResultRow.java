package com.iii.pel.forms.CHART;

import java.util.ArrayList;

import com.iii.premia.common.bean.BaseValueBean;

public class ChartQueryResultRow extends BaseValueBean{
	private ArrayList<Object> row;

	public ChartQueryResultRow(){
		row = new ArrayList<Object>();
	}
	
	public ArrayList<Object> getRow() {
		return row;
	}

	public void setRow(ArrayList<Object> row) {
		this.row = row;
	}
	
	public Object getColumnValue(int index){
		Object columnValue = null;
		
		if(row != null && index < row.size()){
			columnValue = row.get(index);
		}else{
			throw new RuntimeException("Invalid index");
		}
		
		return columnValue;
	}
	
	public void addColumnValue(Object value){
		if(row != null){
			row.add(value);
		}
	}
}
