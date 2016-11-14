/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：病历表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-11-14  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package com.gdpu.his.service.medical;

import com.gdpu.common.domain.AccountDto;
import com.gdpu.common.domain.BaseDomain;
import com.gdpu.common.service.IPageService;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.medical.MedicalHistory;
import com.gdpu.his.param.medical.MedicalHistoryParam;
import com.gdpu.his.service.IHISBaseService;
import org.springframework.web.servlet.ModelAndView;

;

/**
 * 《病历》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IMedicalHistoryService<D extends IHISBaseDAO<T>, T extends BaseDomain> extends IHISBaseService<D, T>, IPageService<D, T> {

    /**
     * 分页查询病人信息
     * @param param     查询参数
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，视图与数据
     */
    ModelAndView queryPage(MedicalHistoryParam param, int pageNo, int pageSize);

    /**
     * 保存一条病人信息
     * @param medicalHistory         保存参数
     * @param currentUser   当前操作者
     * @return  返回，视图与数据
     */
    String addPatient(MedicalHistory medicalHistory, AccountDto currentUser);

    /**
     * 启用、审核病人
     * @param param         参数
     * @param currentUser   当前操作者
     * @return  返回，操作码
     */
    String disabledOrEnabled(MedicalHistoryParam param, AccountDto currentUser);

    /**
     * 获取病人信息更新视图
     * @param id    病人主键id
     * @return  返回，视图与数据
     */
    ModelAndView update(Long id);

    /**
     * 更新一条病人信息
     * @param param
     * @param currentUser
     * @return
     */
    String updatePatient(MedicalHistoryParam param, AccountDto currentUser);
}