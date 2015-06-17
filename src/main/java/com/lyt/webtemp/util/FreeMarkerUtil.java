package com.lyt.webtemp.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class FreeMarkerUtil {
	
	/**
	 * 通过传入的模板名称返回模板
	 * @param TempName
	 * @param tempLocation 模板位置，相对于src目录的位置（例如;"/ftl/SSH"）
	 * @return
	 */
	public static Template getTemplate(String TempName,String tempLocation){
		
		try {
			
			Configuration configuration = new Configuration();

			configuration.setClassForTemplateLoading(FreeMarkerUtil.class,tempLocation );
			
			Template template = configuration.getTemplate(TempName);
			
			return template;
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 控制台打印模板数据
	 * @param TempName 模板名称
	 * @param root 数据map
	 */
	public static void printTemp(String TempName,String tempLocation,Map<String,Object> root){
		
		try {
			//通过Template可以将模板文件输出到相应的流
			Template temp = FreeMarkerUtil.getTemplate(TempName,tempLocation);
			
			temp.process(root, new PrintWriter(System.out));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 将获得的模板写到文件中
	 * @param TempName
	 * @param root
	 * @param outFile
	 * @param k
	 * @param tempLocation
	 */
	public static void write2File(String TempName,Map<String,Object> root,String outFile,int k,String tempLocation,String[] type,String[] type2,String resultPath){

		FileWriter out = null;
		try {
			//通过一个文件输出流，就可以写到相应的文件中
			
			File foder = new File(resultPath+"\\"+type[k]);

			File file = new File(foder+"\\"+(outFile.replaceFirst(outFile.substring(0, 1), outFile.substring(0, 1).toUpperCase())+type2[k]).trim()+".java");
			
			if (foder.exists()==false) {
				foder.mkdirs();
			}
			if(file.exists()==false){
				file.createNewFile();
			}
			out = new FileWriter(file);
			Template temp = FreeMarkerUtil.getTemplate(TempName,tempLocation);
			temp.process(root, out);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(out!=null) out.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
