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

package com.gdpu.his.service.room;

import com.gdpu.common.domain.AccountDto;
import com.gdpu.common.exception.BizException;
import com.gdpu.common.utils.*;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.room.IClinicroomDAO;
import com.gdpu.his.dao.room.ISchedulingDAO;
import com.gdpu.his.dao.sys.ICategoryDAO;
import com.gdpu.his.domain.room.Clinicroom;
import com.gdpu.his.domain.room.ClinicroomEx;
import com.gdpu.his.domain.room.SchedulingEx;
import com.gdpu.his.domain.sys.Category;
import com.gdpu.his.param.medical.MedicalHistoryParam;
import com.gdpu.his.param.room.ClinicroomParam;
import com.gdpu.his.param.sys.CategoryParam;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

;

/**
 * 《科室》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("ClinicroomServiceImpl")
public class ClinicroomServiceImpl extends AbstractHISPageService<IHISBaseDAO<Clinicroom>, Clinicroom> implements IClinicroomService<IHISBaseDAO<Clinicroom>, Clinicroom> {
    @Autowired
    private IClinicroomDAO clinicroomDAO;
    @Autowired
    private ICategoryDAO categoryDAO;
    @Autowired
    private ISchedulingDAO schedulingDAO;

    @Override
    public IHISBaseDAO<Clinicroom> getDao() {
        return clinicroomDAO;
    }

    @Override
    public ModelAndView queryPage(ClinicroomParam param, int pageNo, int pageSize) {
        ModelAndView mav = new ModelAndView("clinicRoom/list");
        List<ClinicroomEx> clinicrooms = clinicroomDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        int records = clinicroomDAO.countEx(param.toMap());
        mav.addObject("data", PageUtils.toBizData4Page(clinicrooms, pageNo, pageSize, records));
        return mav;
    }

    @Override
    public ModelAndView loadAddBounced() {
        ModelAndView mav = new ModelAndView("clinicRoom/add");
        List<Category> categories = categoryDAO.findAll(null, null);
        mav.addObject("categories", categories);
        return mav;
    }

    @Override
    public String addClinicRoom(ClinicroomParam param, AccountDto currentUser) {
        if (this.findOne(ClinicroomParam.F_Name, param) != null) {
            throw new BizException(ERRORCODE.CLINICROOM_NAME_EXISTS.getCode(), ERRORCODE.CLINICROOM_NAME_EXISTS.getMessage());
        }
        param.setCreateDate(System.currentTimeMillis());
        param.setCreator(currentUser.getUid());
        param.setStatus(DataStatusEnum.ENABLED.getValue());
        param.setCode(CommonUtils.getUUID());
        if (this.insertMap(param.toMap()) > 0) {
            return RETURNCODE.ADD_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public ModelAndView update(Long id) {
        ModelAndView mav = new ModelAndView("clinicRoom/update");
        List<Category> categories = categoryDAO.findAll(null, null);
        mav.addObject("categories", categories);
        mav.addObject("item", this.findOne(ClinicroomParam.F_ID, id));
        return mav;
    }

    @Override
    public String updateClinicRoom(ClinicroomParam param, AccountDto currentUser) {
        Clinicroom clinicroom = this.findOne(ClinicroomParam.F_Name, param.getName());
        if (clinicroom != null && !clinicroom.getId().equals(param.getId())) {
            throw new BizException(ERRORCODE.CLINICROOM_NAME_EXISTS.getCode(), ERRORCODE.CLINICROOM_NAME_EXISTS.getMessage());
        }
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        if (this.updateMap(param.toMap()) > 0) {
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public String disabledOrEnabled(ClinicroomParam param, AccountDto currentUser) {
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        if (this.updateMap(param.toMap()) > 0) {
            return RETURNCODE.UPDATE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    @Override
    public ModelAndView loadDoctorBounced(Clinicroom clinicroom) {
        ModelAndView mav = new ModelAndView("clinicRoom/loadDoctorBounced");

        //科室类型主键
        mav.addObject("clinicroom", clinicroom);
        //封装早上的排班数据
        mav.addObject("mooningScheduling", getSchedule4Init(clinicroom.getId(), 0, CommonUtils.calendar.get(Calendar.WEEK_OF_YEAR)));
//        //封装下午的排班数据
        mav.addObject("afternoonScheduling", getSchedule4Init(clinicroom.getId(), 1, CommonUtils.calendar.get(Calendar.WEEK_OF_YEAR)));
//        //封装晚上的排班数据
        mav.addObject("nightScheduling", getSchedule4Init(clinicroom.getId(), 2, CommonUtils.calendar.get(Calendar.WEEK_OF_YEAR)));

        return mav;
    }

    private List<SchedulingEx> getSchedule4Init(Integer roomId, Integer dayPoint, int week) {
        List<SchedulingEx> queryResult = schedulingDAO.findSchedules(roomId, dayPoint, week);
        List<SchedulingEx> result = new ArrayList<>();
        for (int i = 0; true; i++) {
            for (int j = 0; j < queryResult.size(); j++) {
                SchedulingEx scheduling = queryResult.get(j);
                if (i == scheduling.getDay()) {
                    result.add(scheduling);
                } else {
                    fullList(result, scheduling.getDay(), dayPoint);
                    result.add(scheduling);
                }
                i = scheduling.getDay();
            }
            fullList(result, 7, dayPoint);
            break;
        }

        return result;
    }

    private void fullList(List<SchedulingEx> data, int index, int dayPoint) {
        SchedulingEx scheduling;
        for (int i = data.size(); i < index; i++) {
            scheduling = new SchedulingEx();
            scheduling.setDayPoint(dayPoint);
            scheduling.setDay(i);
            data.add(scheduling);
        }
    }

    @Override
    public ModelAndView getRooms(MedicalHistoryParam param, int pageNo, int pageSize) {
        ModelAndView mav = new ModelAndView("appointment/list");
        mav.addObject("categories", categoryDAO.findList(CategoryParam.F_Type, 0, null, null));
        List<ClinicroomEx> clinicrooms = clinicroomDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        for (ClinicroomEx item: clinicrooms){
            item.setWaitingCount(new Random().nextInt(20));
        }
        int records = clinicroomDAO.countEx(param.toMap());
        mav.addObject("data", PageUtils.toBizData4Page(clinicrooms, pageNo, pageSize, records));
        return mav;
    }
}