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

package com.gdpu.his.dao.sys;

import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.sys.RelationRC;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《医疗人员标签关系（fs_sys_relationRC）》 数据访问接口
 * @author 郭旭辉
 *
 */
public interface IRelationRCDAO extends IHISBaseDAO<RelationRC> {

    /**
     * 添加医护人员-分类标签关系
     * @param saveLists 医护人员-分类标签关系集合
     * @return  返回，非零：成功插入条数，0:失败
     */
     int addRelations(@Param("list") List<RelationRC> saveLists);
 }