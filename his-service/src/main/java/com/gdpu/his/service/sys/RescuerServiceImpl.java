/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医疗人员基础信息表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-18  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package com.gdpu.his.service.sys;

import com.gdpu.common.domain.AccountDto;
import com.gdpu.common.exception.BizException;
import com.gdpu.common.utils.*;
import com.gdpu.common.utils.User.UserContext;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.sys.ICategoryDAO;
import com.gdpu.his.dao.sys.IRescuerDAO;
import com.gdpu.his.domain.sys.Category;
import com.gdpu.his.domain.sys.Rescuer;
import com.gdpu.his.param.sys.CategoryParam;
import com.gdpu.his.param.sys.RescuerParam;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

;

/**
 * 《医疗人员基础信息》 业务逻辑服务类
 *
 * @author 郭旭辉
 */
@Service("RescuerServiceImpl")
public class RescuerServiceImpl extends AbstractHISPageService<IHISBaseDAO<Rescuer>, Rescuer> implements IRescuerService<IHISBaseDAO<Rescuer>, Rescuer> {
    @Autowired
    private IRescuerDAO rescuerDAO;
    @Autowired
    private ICategoryDAO categoryDAO;

    @Override
    public IHISBaseDAO<Rescuer> getDao() {
        return rescuerDAO;
    }

    @Override
    public ModelAndView login(HttpServletRequest request, String username, String password) {
        Rescuer rescuer = this.findOne(RescuerParam.F_Username, username);
        if (rescuer == null) {
            throw new BizException(ERRORCODE.ACCOUNT_ILLEGAL.getCode(), ERRORCODE.ACCOUNT_ILLEGAL.getMessage());
        }
        if (!rescuer.getPassword().equals(CommonUtils.getPassword(password, rescuer.getSalty()))) {
            throw new BizException(ERRORCODE.ACCOUNT_PASSWD_UNMATCH.getCode(), ERRORCODE.ACCOUNT_PASSWD_UNMATCH.getMessage());
        }
        //设置session
        HttpSession session = request.getSession();
        session.setAttribute("USER", rescuer);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("currentUser", rescuer);
        return modelAndView;
    }

    @Override
    public ModelAndView queryPage(RescuerParam param, int pageNo, int pageSize) {
        List<Rescuer> data = rescuerDAO.queryPageEx(param.toMap(), (pageNo - 1) * pageSize, pageSize);
        int records = rescuerDAO.countEx(param.toMap());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("userManager/rescuer");
        mav.addObject("data", PageUtils.toBizData4Page(data, pageNo, pageSize, records));
        return mav;
    }

    @Override
    public ModelAndView addRescuer(Rescuer rescuer, AccountDto currentUser) {
        rescuer.setCode(CommonUtils.getUUID());
        rescuer.setSalty(rescuer.getCode().substring(0, 8));
        rescuer.setPassword(CommonUtils.getPassword("123456", rescuer.getSalty()));
        rescuer.setCreateDate(System.currentTimeMillis());
        rescuer.setCreator(currentUser.getUid());
        rescuer.setStatus(DataStatusEnum.ENABLED.getValue());
        if (this.add(rescuer) <= 0) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
        return queryPage(new RescuerParam(), 1, 10);
    }

    @Override
    public ModelAndView save(RescuerParam param, AccountDto currentUser) {
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(currentUser.getUid());
        if (this.updateMap(param.toMap()) <= 0) {
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
        //刷新视图
        return queryPage(new RescuerParam(), 1, 10);
    }

    @Override
    public String disabledOrEnabled(long id, Integer status) {
        RescuerParam param = new RescuerParam();
        param.setId(id);
        param.setStatus(status);
        param.setLastModDate(System.currentTimeMillis());
        param.setLastModifier(UserContext.getCurrentUser().getUid());
        if(this.updateMap(param.toMap()) <= 0){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
        return RETURNCODE.UPDATE_COMPLETE.getMessage();
    }

    @Override
    public String deleteOne(long id) {
        if(this.deleteById(id) <= 0){
            throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
        }
        return RETURNCODE.DELETE_COMPLETE.getMessage();
    }

    @Override
    public ModelAndView loadRelation(Long id) {
        ModelAndView mav = new ModelAndView("userManager/addRelation");
        //根据id获取当前用户的信息
        Rescuer rescuer = this.findOne(RescuerParam.F_ID, id);

        //获取专业标签
        List<Category> majorCategory = categoryDAO.findList(CategoryParam.F_Type, 0, null, null);
        //获取职务标签
        List<Category> careerCategory = categoryDAO.findList(CategoryParam.F_Type, 1, null, null);

        //获取已经

        //封装数据
        mav.addObject("rescuer", rescuer);
        mav.addObject("majorCategory", majorCategory);
        mav.addObject("careerCategory", careerCategory);

        return mav;
    }
}