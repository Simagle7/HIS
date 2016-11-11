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

package com.gdpu.his.dao.sys;

import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.sys.Category;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《分类标签，用户职务标签，专业标签如科室标签，医生专业标签等》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface ICategoryDAO extends IHISBaseDAO<Category> {

    /**
     * 分页获取分类标签列表
     *
     * @param condition 查询参数
     * @param offset    偏移量
     * @param rows      行数
     * @return 返回，分页列表
     */
    List<Category> queryPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);

    /**
     * 统计分页总条数
     *
     * @param condition 查询参数
     * @return 返回，统计结果
     */
    int countEx(@Param("condition") Map<String, Object> condition);
}