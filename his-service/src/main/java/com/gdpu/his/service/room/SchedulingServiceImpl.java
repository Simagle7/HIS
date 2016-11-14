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
import com.gdpu.common.exception.BizException;
import com.gdpu.common.utils.CommonUtils;
import com.gdpu.common.utils.DataStatusEnum;
import com.gdpu.common.utils.ERRORCODE;
import com.gdpu.common.utils.RETURNCODE;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.room.ISchedulingDAO;
import com.gdpu.his.dao.sys.ICategoryDAO;
import com.gdpu.his.dao.sys.IRescuerDAO;
import com.gdpu.his.domain.room.Scheduling;
import com.gdpu.his.param.room.SchedulingParam;
import com.gdpu.his.param.room.SchedulingParamEx;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

;

/**
 * 《医护人员排班》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("SchedulingServiceImpl")
public class SchedulingServiceImpl extends AbstractHISPageService<IHISBaseDAO<Scheduling>, Scheduling> implements ISchedulingService<IHISBaseDAO<Scheduling>, Scheduling> {
    @Autowired
    private ISchedulingDAO schedulingDAO;
    @Autowired
    private ICategoryDAO categoryDAO;
    @Autowired
    private IRescuerDAO rescuerDAO;

    private Calendar calendar = Calendar.getInstance();

    @Override
    public IHISBaseDAO<Scheduling> getDao() {
        return schedulingDAO;
    }


    @Override
    public ModelAndView initDoctorTree(SchedulingParamEx paramEx) {
        ModelAndView mav = new ModelAndView("clinicRoom/rescuerTree");
        mav.addObject("targetId", paramEx.getTargetId());
        mav.addObject("rescuers", rescuerDAO.queryRescuers(paramEx.getCategoryId(), paramEx.getWeek(), paramEx.getDay(), paramEx.getDayPoint(), false));
        return mav;
    }

    @Override
    public String saveArrange4Doctor(List<Scheduling> list, Integer roomId, AccountDto currentUser) {
        int week = calendar.get(Calendar.WEEK_OF_YEAR);
        List<Scheduling> data = new ArrayList<>(list.size());
        Scheduling scheduling;
        //封装数据
        for (Scheduling item : list) {
            scheduling = new Scheduling();
            scheduling.setDay(item.getDay());
            scheduling.setRescuerId(item.getRescuerId());
            scheduling.setDayPoint(item.getDayPoint());
            scheduling.setRoomId(roomId);
            scheduling.setTimePoint(CommonUtils.getTime(item.getDay()));
            switch (item.getWeek()) {
                case 0:
                    scheduling.setWeek(week);
                    break;
                case 1:
                    scheduling.setWeek(week + 1);
                    break;
                case 2:
                    scheduling.setWeek(week + 2);
                    break;
                default:
                    throw new BizException(ERRORCODE.PARAM_ISERROR.getCode(), ERRORCODE.PARAM_ISERROR.getMessage());
            }
            scheduling.setCreator(currentUser.getUid());
            scheduling.setCreateDate(System.currentTimeMillis());
            scheduling.setStatus(DataStatusEnum.ENABLED.getValue());
            data.add(scheduling);
        }
//        //插入之前先进行删除
        this.deleteByProperty(SchedulingParam.F_RoomId, roomId);
        //插入数据
        if (schedulingDAO.addSchedules(data) > 0) {
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }
}