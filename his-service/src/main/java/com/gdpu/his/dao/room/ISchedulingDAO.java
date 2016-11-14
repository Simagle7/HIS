/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医护人员排班											
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
import com.gdpu.his.domain.room.Scheduling;
import com.gdpu.his.domain.room.SchedulingEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 《医护人员排班》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface ISchedulingDAO extends IHISBaseDAO<Scheduling> {


    /**
     * 批量保存排班信息
     *
     * @param data 待保存排班列表
     * @return 返回，非零：成功插入条数，0：失败
     */
    int addSchedules(@Param("list") List<Scheduling> data);

    /**
     * 查询医护人员排班信息（用于回显）
     * @param roomId        科室主键
     * @param dayPoint      代表一天的早上，下午和晚上，依次值为0,1,2
     * @param week 周数
     * @return 返回，排班信息列表
     */
    List<SchedulingEx> findSchedules(@Param("roomId") Integer roomId, @Param("dayPoint") Integer dayPoint, @Param("week") int week);
}