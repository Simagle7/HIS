package com.gdpu.controller.login;

import com.gdpu.common.utils.User.UserContext;
import com.gdpu.his.domain.sys.Rescuer;
import com.gdpu.his.param.sys.RelationRCParamEx;
import com.gdpu.his.param.sys.RescuerParam;
import com.gdpu.his.service.sys.IRelationRCService;
import com.gdpu.his.service.sys.IRescuerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by 郭旭辉 on 2016/10/17.
 * 用户控制类
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IRelationRCService relationRCService;
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
     * 回显一条医护人员信息
     * @param id    id
     * @return  返回，视图模型
     */
    @RequestMapping(value = "/update")
    public ModelAndView update(long id){
        ModelAndView mav = new ModelAndView("userManager/update");
        mav.addObject("item", rescuerService.findOne(RescuerParam.F_ID, id));
        return mav;
    }


    /**
     * 保存一条医护人员的更新信息
     * @param param     更新参数
     * @return  返回，视图模型
     */
    @RequestMapping(value = "/save")
    public ModelAndView save(RescuerParam param){
        return rescuerService.save(param, UserContext.getCurrentUser());
    }

    /**
     * 启用停职
     * @param id    id
     * @param status    状态
     * @return  返回，数据
     */
    @ResponseBody
    @RequestMapping(value = "/disabledOrEnabled")
    public String disabledOrEnabled(long id,Integer status){
        return rescuerService.disabledOrEnabled(id, status);
    }

    /**
     * 删除一条医护人员信息
     * @param id        医护人员主键
     * @return  返回，操作码
     */
    @ResponseBody
    @RequestMapping(value = "/deleteOne")
    public String deleteOne(long id){
        return rescuerService.deleteOne(id);
    }

    /**
     * 加载分类标签框
     * @param id    医护人员主键
     * @return  返回，视图与数据模型
     */
    @RequestMapping(value = "/loadRelation")
    public ModelAndView loadRelation(Long id){
        return rescuerService.loadRelation(id);
    }

    /**
     * 批量添加关系
     * @param paramEx 关系参数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRelation", method = RequestMethod.POST)
    public String addRelaiton(RelationRCParamEx paramEx){
        return relationRCService.addRelation(paramEx, UserContext.getCurrentUser());
    }

    /**
     * 欢迎页
     * @return  返回视图
     */
    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }


}
