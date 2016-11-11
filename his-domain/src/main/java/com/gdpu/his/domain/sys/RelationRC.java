/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医疗人员标签关系（fs_sys_relationRC）											
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

package com.gdpu.his.domain.sys;

import com.gdpu.common.domain.HISCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《医疗人员标签关系（fs_sys_relationRC）》 实体
 * @author 郭旭辉
 *
 */
public class RelationRC extends HISCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;
	
	private Integer categoryId; //分类标签id
	private Long rescuerId; //医护人员主键
    
	/**
	 *默认空构造函数
	 */
	public RelationRC() {
		super();
	}
	 
	/**
	 * @return categoryId 分类标签id
	 */
	public Integer getCategoryId(){
		return this.categoryId;
	}
	/**
	 * @param categoryId 分类标签id
	 */
	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}
	/**
	 * @return rescuerId 医护人员主键
	 */
	public Long getRescuerId(){
		return this.rescuerId;
	}
	/**
	 * @param rescuerId 医护人员主键
	 */
	public void setRescuerId(Long rescuerId){
		this.rescuerId = rescuerId;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("categoryId",getCategoryId())
			.append("rescuerId",getRescuerId())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getId())
			.append(getCategoryId())
			.append(getRescuerId())
			.append(getCreator())
			.append(getCreateDate())
			.append(getLastModifier())
			.append(getLastModDate())
			.append(getStatus())
			.toHashCode();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof RelationRC == false) return false;
		if(this == obj) return true;
		RelationRC other = (RelationRC)obj;
		return new EqualsBuilder()
			.append(getId(),other.getId())
			.isEquals();
	}
}
