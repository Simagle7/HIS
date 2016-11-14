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

package com.gdpu.his.param.sys;

/**
 * 《医疗人员标签关系（fs_sys_relationRC）》 查询参数实体
 * @author 郭旭辉
 *
 */
public class RelationRCParamEx extends RelationRCParam {
	private static final long serialVersionUID = 1L;
	
	//针对RelationRCParam实体在这里增加额外的属性和对应的get和set方法

	private Long rescuerId;	//当前医护人员的主键id
	private Integer[] categoryIds;			//分类标签列表

	@Override
	public Long getRescuerId() {
		return rescuerId;
	}

	@Override
	public void setRescuerId(Long rescuerId) {
		this.rescuerId = rescuerId;
	}

	public Integer[] getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(Integer[] categoryIds) {
		this.categoryIds = categoryIds;
	}
}