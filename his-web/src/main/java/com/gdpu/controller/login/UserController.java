package com.gdpu.controller.login;

import com.gdpu.common.utils.CommonUtils;
import com.gdpu.his.domain.doctor.Doctor;
import com.gdpu.his.service.doctor.IDoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by 郭旭辉 on 2016/10/17.
 * 用户控制类
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IDoctorService doctorService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        return "index";
    }

    @RequestMapping(value = "/userManager")
    public ModelAndView userManager() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userManager/userManager");
        mav.addObject("doctors", doctorService.findAll());
        return mav;
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
    public ModelAndView addDoctor(Doctor doctor) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userManager/userManager");
        //先添加医生信息
        doctor.setCreator("ADMIN");
        doctor.setCreateDate(System.currentTimeMillis());
        doctor.setCode(CommonUtils.getUUID());
        doctor.setStatus(0);
        if (doctorService.add(doctor) > 0) {
            List doctors = doctorService.findAll();
            mav.addObject("doctors", doctors);
        }
        return mav;
    }
}
