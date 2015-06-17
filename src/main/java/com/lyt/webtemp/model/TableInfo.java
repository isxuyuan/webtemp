package com.lyt.webtemp.model;

public class TableInfo {

	//表名
	private String table_name;
	//列名
	private String column_name;
	//数据类型
	private String data_type;
	//数值长度
	private String character_maximum_length;
	//注释
	private String column_comment;
	
	
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getCharacter_maximum_length() {
		return character_maximum_length;
	}
	public void setCharacter_maximum_length(String character_maximum_length) {
		this.character_maximum_length = character_maximum_length;
	}
	public String getColumn_comment() {
		return column_comment;
	}
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	@Override
	public String toString() {
		return "TableInfo [table_name=" + table_name + ", column_name="
				+ column_name + ", data_type=" + data_type
				+ ", character_maximum_length=" + character_maximum_length
				+ ", column_comment=" + column_comment + "]";
	}
	
	
}
