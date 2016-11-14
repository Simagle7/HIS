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

import com.gdpu.common.domain.AccountDto;
import com.gdpu.common.domain.BaseDomain;
import com.gdpu.common.service.IPageService;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.room.Scheduling;
import com.gdpu.his.param.room.SchedulingParamEx;
import com.gdpu.his.service.IHISBaseService;
import org.springframework.web.servlet.ModelAndView;

;import java.util.List;

/**
 * 《医护人员排班》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface ISchedulingService<D extends IHISBaseDAO<T>, T extends BaseDomain> extends IHISBaseService<D, T>, IPageService<D, T> {

    /**
     * 获取医生树视图
     * @param paramex 查询参数
     * @return  返回，参数
     */
    ModelAndView initDoctorTree(SchedulingParamEx paramex);

    /**
     * 保持医生排班信息
     * @param list          医生列表
     * @param currentUser   当前操作者
     * @return  返回，操作码
     */
    String saveArrange4Doctor(List<Scheduling> list, Integer roomId, AccountDto currentUser);
}