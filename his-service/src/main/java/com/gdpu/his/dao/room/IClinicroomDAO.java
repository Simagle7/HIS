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

package com.gdpu.his.dao.room;

import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.room.Clinicroom;
import com.gdpu.his.domain.room.ClinicroomEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《科室》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IClinicroomDAO extends IHISBaseDAO<Clinicroom> {


    /**
     * 分页获取科室列表
     * @param condition     查询条件
     * @param offset        偏移量
     * @param rows          行号
     * @return  返回，分页列表
     */
    List<ClinicroomEx> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 统计
     * @param condition     查询条件
     * @return  返回，统计结果
     */
    int countEx(@Param("condition") Map<String, Object> condition);
}