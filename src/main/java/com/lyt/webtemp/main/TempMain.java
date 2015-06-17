package com.lyt.webtemp.main;

import java.util.List;

import com.lyt.webtemp.util.DBDaoUtils;
import com.lyt.webtemp.util.TempUtil;

public class TempMain {

	// 这个字段需要配置(数据库名称)
	private static final String DBNAME = "julyedu";
	// 模板类型
	private static final String TEMP_TYPE = "SSH";
	// 配置包名前缀
	private static final String PACKAGE_NAME = "com.lyt.web1";
	// 配置mvc模式的包名
	private static final String[] DIR_NAME = { "model", "action", "service",
			"service.impl", "dao", "dao.impl" };
	// 生后的文件夹结构名称
	private static final String[] FOLDER_NAME = { "model", "action", "service",
			"service/impl", "dao", "dao/impl" };
	// 生成java文件后后缀
	private static final String[] FILE_SUFFIX_NAME = { "", "Action", "Service",
			"ServiceImpl", "Dao", "DaoImpl" };
	// 生成代码输出的位置
	//private static final String RESULT_PATH = "F:/web";
	// 生成代码输出的位置(mac)
	private static final String RESULT_PATH = "/Users/lyt/Desktop/webtemp/";
	// 模板位置，相对路径
	private static final String TEMP_LOCATION = "/ftl/SSH";

	// 设置用户信息
	// 暂时不弄

	public static void main(String[] args) {

		// 1.读取数据库的全部表。
		List<String> tableNames = DBDaoUtils.getTableName();
		// 3.获得所有表的元数据,并且制作模板
		TempUtil.getAllTableMetaData(tableNames, DBNAME, PACKAGE_NAME,
				DIR_NAME, TEMP_LOCATION, FOLDER_NAME, FILE_SUFFIX_NAME,
				RESULT_PATH);

	}

}
