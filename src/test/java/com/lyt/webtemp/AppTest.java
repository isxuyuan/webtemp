package com.lyt.webtemp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.lyt.webtemp.model.TableInfo;
import com.lyt.webtemp.util.DBDaoUtils;
import com.lyt.webtemp.util.FreeMarkerUtil;
import com.lyt.webtemp.util.HibernateUtil;

import freemarker.template.Template;

/**
 * Unit test for simple App.
 */
public class AppTest {

	String sql = "select table_name, column_name, data_type,character_maximum_length,"
			+ "column_comment from information_schema.columns "
			+ "where table_name='user' and table_schema = 'julyedu'";
	
	
	String  db2sql = "select t.tabname as table_name , t.colname as column_name,t.typename as data_type,t.length as character_maximum_length from syscat.COLUMNS t where tabschema='TZXSCM' and tabname=upper('SCM_ORGAN_DAY_REPORT') order by COLNO";

	/**
	 * sql连接测试
	 */
	@Test
	public void mysqlConnTest() {

		List list = HibernateUtil.sqlQuery(db2sql);

		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i).toString());
		}

	}

	@Test
	public void jdbcTest() {

		System.out.println(DBDaoUtils.getTableName());
	}
	
	@Test
	public void db2Test(){
		
		System.out.println(DBDaoUtils.executeQuery(db2sql,TableInfo.class).size());
		
	}

	@Test
	public void ftlTest() {
		
		String tempName = "test.ftl";
		String tempLocation = "/ftl/SSH";
		
		try {

			Template template = FreeMarkerUtil.getTemplate(tempName,tempLocation);
			
			Map root = new HashMap();
			
			root.put("name", "lyt");
			
			root.put("age", 123);
			
			FreeMarkerUtil.printTemp(tempName,tempLocation, root);
		
		} catch (Exception e) {
		}

	}

}
