/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：分类标签，用户职务标签，专业标签如科室标签，医生专业标签等											
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

package com.gdpu.his.param.sys;

import com.gdpu.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《分类标签，用户职务标签，专业标签如科室标签，医生专业标签等》 查询参数实体
 * @author 郭旭辉
 *
 */
public class CategoryParam extends CreateBaseParam<Integer> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——标签名称
	*/
	public static final String F_Name="name";
	/**
	*字段常量——标签类型，0：专业标签，1：职务标签
	*/
	public static final String F_Type="type";
	/**
	*字段常量——排序
	*/
	public static final String F_Priority="priority";
	/**
	*字段常量——标签描述
	*/
	public static final String F_Description="description";
	
	private String name; //标签名称
	private Integer type; //标签类型，0：专业标签，1：职务标签
	private Integer priority; //排序
	private String description; //标签描述
    
	/**
	 *默认空构造函数
	 */
	public CategoryParam() {
		super();
	}
	 
	/**
	 * @return name 标签名称
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 标签名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return type 标签类型，0：专业标签，1：职务标签
	 */
	public Integer getType(){
		return this.type;
	}
	/**
	 * @param type 标签类型，0：专业标签，1：职务标签
	 */
	public void setType(Integer type){
		this.type = type;
	}
	/**
	 * @return priority 排序
	 */
	public Integer getPriority(){
		return this.priority;
	}
	/**
	 * @param priority 排序
	 */
	public void setPriority(Integer priority){
		this.priority = priority;
	}
	/**
	 * @return description 标签描述
	 */
	public String getDescription(){
		return this.description;
	}
	/**
	 * @param description 标签描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("name",getName())
			.append("type",getType())
			.append("priority",getPriority())
			.append("description",getDescription())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
