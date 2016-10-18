/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医疗人员基础信息表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-18  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package com.gdpu.his.dao.sys;


import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.sys.Rescuer;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《医疗人员基础信息》 数据访问接口
 * @author 郭旭辉
 *
 */
public interface IRescuerDAO extends IHISBaseDAO<Rescuer> {


    /**
     * 分页查询数据
     * @param condition     查询条件
     * @param offset        偏移量
     * @param rows          行号
     * @return  返回，分页结果集
     */
    List<Rescuer> queryPageEx(@Param("condition")Map<String, Object> condition, @Param("offset") Integer offset, @Param("rows") Integer rows);

    /**
     * 统计分页
     * @param condition      查询条件
     * @return  返回，统计结果
     */
    int countEx(@Param("condition")Map<String, Object> condition);
}