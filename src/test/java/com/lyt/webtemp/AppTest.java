package com.lyt.webtemp;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.lyt.webtemp.util.DBConnUtil;
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

	/**
	 * sql连接测试
	 */
	@Test
	public void mysqlConnTest() {

		List list = HibernateUtil.sqlQuery(sql);

		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(list.get(i));
		}

	}

	@Test
	public void jdbcTest() {

		System.out.println(DBDaoUtils.getTableName());
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
