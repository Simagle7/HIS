package com.gdpu.controller.clinicRoom;

import com.gdpu.common.exception.BizException;
import com.gdpu.common.utils.ERRORCODE;
import com.gdpu.common.utils.RETURNCODE;
import com.gdpu.common.utils.User.UserContext;
import com.gdpu.his.domain.room.Clinicroom;
import com.gdpu.his.domain.room.Scheduling;
import com.gdpu.his.param.room.ClinicroomParam;
import com.gdpu.his.param.room.SchedulingParamEx;
import com.gdpu.his.service.room.IClinicroomService;
import com.gdpu.his.service.room.ISchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * Created by 郭旭辉 on 2016/11/10.
 * 分类标签控制类
 */
@Controller
@RequestMapping(value = "/clinicRoom")
public class ClinicRoomController {

    @Autowired
    private IClinicroomService clinicroomService;

    @Autowired
    private ISchedulingService schedulingService;

    /**
     * 进入科室页面列表页面
     *
     * @return 返回，模型与视图
     */
    @RequestMapping(value = "/list")
    public ModelAndView queryPage(ClinicroomParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return clinicroomService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 进入分类标签添加页面
     *
     * @return 返回，视图
     */
    @RequestMapping(value = "/add")
    public ModelAndView loadAddBounced() {
        return clinicroomService.loadAddBounced();
    }

    /**
     * 保存科室
     *
     * @param param 保存参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/addClinicRoom", method = RequestMethod.POST)
    public String addClinicRoom(ClinicroomParam param) {
        return clinicroomService.addClinicRoom(param, UserContext.getCurrentUser());
    }

    /**
     * 获取科室更新视图
     *
     * @param id 标签主键id
     * @return 返回，视图与数据
     */
    @RequestMapping(value = "update")
    public ModelAndView update(Long id) {
        return clinicroomService.update(id);
    }

    /**
     * 更新科室
     *
     * @param param 更新参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/updateClinicRoom", method = RequestMethod.POST)
    public String updateClinicRoom(ClinicroomParam param) {
        return clinicroomService.updateClinicRoom(param, UserContext.getCurrentUser());
    }

    /**
     * 启用、停用科室
     *
     * @param param 更新参数
     * @return 返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/disabledOrEnabled")
    public String disabledOrEnabled(ClinicroomParam param) {
        return clinicroomService.disabledOrEnabled(param, UserContext.getCurrentUser());
    }

    /**
     * 删除一个标签
     * @param id    标签主键
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(Long id){
        if(clinicroomService.deleteById(id) > 0){
            return RETURNCODE.DELETE_COMPLETE.getMessage();
        }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
    }

    /**
     * 加载医生排班视图
     * @return  返回，操作码
     */
    @RequestMapping(value = "/loadDoctorBounced")
    public ModelAndView loadDoctorBounced(Clinicroom clinicroom){
        return clinicroomService.loadDoctorBounced(clinicroom);
    }


    /**
     * 初始化医生视图
     * @param paramEx   查询参数
     * @return  返回，视图与数据
     */
    @RequestMapping(value = "/initDoctorTree")
    public ModelAndView initDoctorTree(SchedulingParamEx paramEx){
        return  schedulingService.initDoctorTree(paramEx);
    }

    /**
     * 保存医生排班信息
     * @param list      排班信息列表
     * @param roomId    科室主键
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/saveArrange4Doctor",method = RequestMethod.POST)
    public String saveArrange4Doctor(@RequestBody Scheduling[] list, Integer roomId){
        return schedulingService.saveArrange4Doctor(Arrays.asList(list), roomId, UserContext.getCurrentUser()) ;
    }

}
