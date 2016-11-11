/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：科室											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-11-10  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package com.gdpu.his.param.room;

import com.gdpu.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《科室》 查询参数实体
 * @author 郭旭辉
 *
 */
public class ClinicroomParam extends CreateBaseParam<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——科室位置，具体到哪一栋楼那一层那一间
	*/
	public static final String F_Address="address";
	/**
	*字段常量——科室号，如: 3-101
	*/
	public static final String F_ClinicNum="clinicNum";
	/**
	*字段常量——科室名称
	*/
	public static final String F_Name="name";
	/**
	*字段常量——科室代码，uuid
	*/
	public static final String F_Code="code";
	/**
	*字段常量——科室分类标签
	*/
	public static final String F_CategoryId="categoryId";
	/**
	*字段常量——科室描述，科室用途
	*/
	public static final String F_Description="description";
	
	private String address; //科室位置，具体到哪一栋楼那一层那一间
	private String clinicNum; //科室号，如: 3-101
	private String name; //科室名称
	private String code; //科室代码，uuid
	private Integer categoryId; //科室分类标签
	private String description; //科室描述，科室用途
    
	/**
	 *默认空构造函数
	 */
	public ClinicroomParam() {
		super();
	}
	 
	/**
	 * @return address 科室位置，具体到哪一栋楼那一层那一间
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 科室位置，具体到哪一栋楼那一层那一间
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * @return clinicNum 科室号，如: 3-101
	 */
	public String getClinicNum(){
		return this.clinicNum;
	}
	/**
	 * @param clinicNum 科室号，如: 3-101
	 */
	public void setClinicNum(String clinicNum){
		this.clinicNum = clinicNum;
	}
	/**
	 * @return name 科室名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 科室名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return code 科室代码，uuid
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 科室代码，uuid
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return categoryId 科室分类标签
	 */
	public Integer getCategoryId(){
		return this.categoryId;
	}
	/**
	 * @param categoryId 科室分类标签
	 */
	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}
	/**
	 * @return description 科室描述，科室用途
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 科室描述，科室用途
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("address",getAddress())
			.append("clinicNum",getClinicNum())
			.append("name",getName())
			.append("code",getCode())
			.append("categoryId",getCategoryId())
			.append("description",getDescription())
			.append("createDate",getCreateDate())
			.append("creator",getCreator())
			.append("lastModDate",getLastModDate())
			.append("lastModifier",getLastModifier())
			.append("status",getStatus())
			.toString();
	}
	
}
