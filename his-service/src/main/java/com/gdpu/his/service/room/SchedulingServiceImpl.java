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

package com.gdpu.his.service.room;

import com.gdpu.common.domain.BaseDomain;;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.room.ISchedulingDAO;
import com.gdpu.his.domain.room.Scheduling;
import com.gdpu.his.service.room.ISchedulingService;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《医护人员排班》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("SchedulingServiceImpl")
public class SchedulingServiceImpl extends AbstractHISPageService<IHISBaseDAO<Scheduling>, Scheduling> implements ISchedulingService<IHISBaseDAO<Scheduling>,Scheduling>{
    @Autowired
    private ISchedulingDAO schedulingDAO;

    @Override
    public IHISBaseDAO<Scheduling> getDao() {
        return schedulingDAO;
    }

}