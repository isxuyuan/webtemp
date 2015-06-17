package com.lyt.webtemp.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lyt.webtemp.model.TableInfo;

public class TempUtil {

	/**
	 * 获得所有表的元数据
	 * 
	 * @param tableNames
	 * @param DBNAME
	 * @param PACKAGE_NAME
	 * @param DIR_NAME
	 * @param TEMP_LOCATION
	 * @param FOLDER_NAME
	 * @param FILE_SUFFIX_NAME
	 * @param RESULT_PATH
	 */
	public static void getAllTableMetaData(List<String> tableNames,
			String DBNAME, String PACKAGE_NAME, String[] DIR_NAME,
			String TEMP_LOCATION, String[] FOLDER_NAME,
			String[] FILE_SUFFIX_NAME, String RESULT_PATH) {

		for (int i = 0; i < tableNames.size(); i++) {

			String sql = "select table_name, column_name, data_type,character_maximum_length,"
					+ " column_comment from information_schema.columns"
					+ " where table_name='"
					+ tableNames.get(i)
					+ "' and table_schema = '" + DBNAME + "'";

			List<TableInfo> tableInfoList = DBDaoUtils.executeQuery(sql,
					TableInfo.class);
			// 4.写入模板生成代码。
			TempUtil.makeTemp(tableNames, tableInfoList, i, PACKAGE_NAME,
					DIR_NAME, TEMP_LOCATION, FOLDER_NAME, FILE_SUFFIX_NAME,
					RESULT_PATH);
		}
	}

	/**
	 * 生成模板
	 * 
	 * @param tableInfo
	 */
	public static void makeTemp(List<String> tableNames,
			List<TableInfo> tableInfoList, Integer flag, String PACKAGE_NAME,
			String[] DIR_NAME, String TEMP_LOCATION, String[] FOLDER_NAME,
			String[] FILE_SUFFIX_NAME, String RESULT_PATH) {

		List<TableInfo> tableInfo_new = TempUtil.typeChange(tableInfoList);
		
		TableInfo tableInfoObj = null;
		for (int i = 0; i < tableInfo_new.size(); i++) {
			
			tableInfoObj = tableInfo_new.get(i);
		}

		Map<String, Object> rootMap = new HashMap<String, Object>();
		

		// 1.准备数据
		rootMap.put("className", tableNames.get(flag));
		rootMap.put("packageName", PACKAGE_NAME);
		rootMap.put("listInfo", tableInfo_new);
		// 获得一个对象
		rootMap.put("tableInfo", tableInfoObj);

		System.out.println(rootMap);

		for (int i = 0; i < DIR_NAME.length; i++) {

			FreeMarkerUtil.printTemp(DIR_NAME[i] + ".ftl", TEMP_LOCATION,
					rootMap);

			FreeMarkerUtil.write2File(DIR_NAME[i] + ".ftl", rootMap,
					tableNames.get(flag), i, TEMP_LOCATION, FOLDER_NAME,
					FILE_SUFFIX_NAME, RESULT_PATH);

		}

	}

	public static List<TableInfo> typeChange(List<TableInfo> tableInfo) {

		for (int i = 0; i < tableInfo.size(); i++) {

			// 转换注释
			if (tableInfo.get(i).getCharacter_maximum_length() == null) {
				tableInfo.get(i).setCharacter_maximum_length(" ");
			}
			if (tableInfo.get(i).getColumn_comment() == null) {
				tableInfo.get(i).setColumn_comment(" ");
			}
			// 成员变量转换（驼峰命名是处理）
			String memberVariable = tableInfo.get(i).getColumn_name();

			if (memberVariable.contains("_")) {
				int j = memberVariable.indexOf("_");

				if (j + 1 < memberVariable.length()) {
					char c = memberVariable.charAt(j + 1);
					String temp = (c + "").toUpperCase();
					memberVariable = memberVariable.replace("_" + c, temp);
				}
			}
			// 首字母大写
			// memberVariable = memberVariable.substring(0,1).toUpperCase() +
			// memberVariable.substring(1);

			tableInfo.get(i).setColumn_name(memberVariable);

			// 类型转换
			switch (tableInfo.get(i).getData_type()) {

			case "varchar":
				tableInfo.get(i).setData_type("String");
				break;
			case "longtext":
				tableInfo.get(i).setData_type("String");
				break;
			case "int":
				tableInfo.get(i).setData_type("Integer");
				break;
			case "double":
				tableInfo.get(i).setData_type("Double");
				break;
			case "date":
				tableInfo.get(i).setData_type("Date");
				break;
			case "datetime":
				tableInfo.get(i).setData_type("Date");
				break;
			default:
				break;
			}
		}
		return tableInfo;
	}
}
