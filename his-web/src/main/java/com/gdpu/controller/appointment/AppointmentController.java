package com.gdpu.controller.appointment;

import com.gdpu.his.param.medical.MedicalHistoryParam;
import com.gdpu.his.service.room.IClinicroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by 郭旭辉 on 2016/11/10.
 * 分类标签控制类
 */
@Controller
@RequestMapping(value = "/appoint")
public class AppointmentController {

    @Autowired
    private IClinicroomService iClinicroomService;

    /**
     * 进入病人页面列表页面
     *
     * @return 返回，模型与视图
     */
    @RequestMapping(value = "/list")
    public ModelAndView queryPage(MedicalHistoryParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return iClinicroomService.getRooms(param, pageNo, pageSize);
    }

//    /**
//     * 进入病人添加页面
//     *
//     * @return 返回，视图
//     */
//    @RequestMapping(value = "/add")
//    public String loadAddBounced() {
//        return "medical/add";
//    }
//
//    /**
//     * 保存病人信息
//     *
//     * @param medicalHistory 保存参数
//     * @return 返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
//    public String addPatient(MedicalHistory medicalHistory) {
//        return medicalHistoryService.addPatient(medicalHistory, UserContext.getCurrentUser());
//    }
//
//    /**
//     * 获取病人更新视图
//     *
//     * @param id 标签主键id
//     * @return 返回，视图与数据
//     */
//    @RequestMapping(value = "/update")
//    public ModelAndView update(Long id) {
//        return medicalHistoryService.update(id);
//    }
//
//    /**
//     * 更新病人
//     *
//     * @param param 更新参数
//     * @return 返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/updatePatient", method = RequestMethod.POST)
//    public String updatePatient(MedicalHistoryParam param) {
//        return medicalHistoryService.updatePatient(param, UserContext.getCurrentUser());
//    }
//
//    /**
//     * 启用、审核用户
//     *
//     * @param param 更新参数
//     * @return 返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/disabledOrEnabled")
//    public String disabledOrEnabled(MedicalHistoryParam param) {
//        return medicalHistoryService.disabledOrEnabled(param, UserContext.getCurrentUser());
//    }
//
//    /**
//     * 删除一个用户
//     * @param id    标签主键
//     * @return  返回，操作码
//     */
//    @ResponseBody
//    @RequestMapping(value = "/deleteOne")
//    public String deleteOne(Long id){
//        if(medicalHistoryService.deleteById(id) > 0){
//            return RETURNCODE.DELETE_COMPLETE.getMessage();
//        }
//        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
//    }
}
