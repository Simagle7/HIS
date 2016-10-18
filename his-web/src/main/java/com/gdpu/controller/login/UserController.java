package com.gdpu.controller.login;

import com.gdpu.common.utils.User.UserContext;
import com.gdpu.his.domain.sys.Rescuer;
import com.gdpu.his.param.sys.RescuerParam;
import com.gdpu.his.service.doctor.IDoctorService;
import com.gdpu.his.service.sys.IRescuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 郭旭辉 on 2016/10/17.
 * 用户控制类
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IDoctorService doctorService;
    @Autowired
    private IRescuerService rescuerService;

    /**
     * 登录
     *
     * @param request  请求流
     * @param username 用户名
     * @param password 密码
     * @return 返回，视图模型
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, String username, String password) {
        return rescuerService.login(request, username, password);
    }

    /**
     * 用户登出
     *
     * @param request 请求流
     * @return  返回，视图
     */
    @RequestMapping(value = "/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(1);      //设置session 1秒后过期
        return "login";
    }

    /**
     * 进入医护人员页面列表页面
     * @return 返回，模型与视图
     */
    @RequestMapping(value = "/rescuer")
    public ModelAndView userManager(RescuerParam param, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        return rescuerService.queryPage(param, pageNo, pageSize);
    }

    /**
     * 添加一条医护人员信息
     * @param rescuer   医护人员参数
     * @return  返回，医护人员信息
     */
    @RequestMapping(value = "/addRescuer", method = RequestMethod.POST)
    public ModelAndView addRescuer(Rescuer rescuer) {
        return rescuerService.addRescuer(rescuer, UserContext.getCurrentUser());
    }

    /**
     * 回显信息
     * @param id    id
     * @return  返回，视图模型
     */
    @RequestMapping(value = "/queryOne")
    public Map<String, Object> queryOne(httlong id){
        Map<String, Object> map = new HashMap<>();
        map.put("item", rescuerService.findOne(RescuerParam.F_ID, id));
        return map;
    }


    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }


}
