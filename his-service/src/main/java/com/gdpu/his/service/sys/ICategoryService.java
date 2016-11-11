/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：分类标签，用户职务标签，专业标签如科室标签，医生专业标签等											
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

package com.gdpu.his.service.sys;

import com.gdpu.common.domain.AccountDto;
import com.gdpu.common.domain.BaseDomain;;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.param.sys.CategoryParam;
import com.gdpu.his.service.IHISBaseService;
import com.gdpu.common.service.IPageService;
import org.springframework.web.servlet.ModelAndView;

/**
 * 《分类标签，用户职务标签，专业标签如科室标签，医生专业标签等》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface ICategoryService<D extends IHISBaseDAO<T>, T extends BaseDomain> extends IHISBaseService<D, T>, IPageService<D, T> {


    /**
     * 分页查询分类标签
     *
     * @param param    查询参数
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return 返回，视图与数据
     */
    ModelAndView queryPage(CategoryParam param, int pageNo, int pageSize);

    /**
     * 保存分类标签
     *
     * @param param       保存参数
     * @param currentUser 当前操作者
     * @return 返回，操作码
     */
    String addCategory(CategoryParam param, AccountDto currentUser);

    /**
     * 更新弹窗
     * @param id    分类标签主键id
     * @return  返回，视图与数据
     */
    ModelAndView update(Long id);

    /**
     * 更新分类标签
     * @param param         更新参数
     * @param currentUser   当前操作者
     * @return  返回，操作码
     */
    String updateCategory(CategoryParam param, AccountDto currentUser);


    /**
     * 启用、停用分类标签
     * @param param         更新参数
     * @param currentUser   操作者
     * @return  返回，操作码
     */
    String disabledOrEnabled(CategoryParam param, AccountDto currentUser);
}