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
import com.gdpu.common.domain.BaseDomain;
import com.gdpu.common.service.IPageService;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.sys.Rescuer;
import com.gdpu.his.param.sys.RescuerParam;
import com.gdpu.his.service.IHISBaseService;
import org.springframework.web.servlet.ModelAndView;

;import javax.servlet.http.HttpServletRequest;

/**
 * 《医疗人员基础信息》 业务逻辑服务接口
 * @author 郭旭辉
 *
 */
public interface IRescuerService<D extends IHISBaseDAO<T>, T extends BaseDomain> extends IHISBaseService<D, T>,IPageService<D, T>{

    /**
     * 系统用户登录
     * @param username  用户名
     * @param password  密码
     * @return  返回，系统用户信息实体
     */
    ModelAndView login(HttpServletRequest request,String username, String password);

    /**
     * 分页查询
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，视图模型
     */
    ModelAndView queryPage(RescuerParam param, int pageNo, int pageSize);

    /**
     * 添加一条医护人员信息
     * @param rescuer       医护人员参数
     * @param currentUser   当前操作者
     * @return 返回，视图模型
     */
    ModelAndView addRescuer(Rescuer rescuer, AccountDto currentUser);
}