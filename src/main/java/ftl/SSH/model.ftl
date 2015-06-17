package ${packageName}.model;

import java.io.Serializable;

public class ${className?cap_first} implements Serializable {

<#list listInfo as listInfo>
	//${listInfo.column_comment}  length = ${listInfo.character_maximum_length}
	private ${listInfo.data_type} ${listInfo.column_name};
</#list>

<#list listInfo as listInfo>
	public ${listInfo.data_type} get${listInfo.column_name?cap_first}() {
	
		return ${listInfo.column_name};
	}
	public void set${listInfo.column_name?cap_first}( ${listInfo.data_type}  ${listInfo.column_name}) {
		
		this.${listInfo.column_name} = ${listInfo.column_name};
	}
</#list>
}	