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
import com.gdpu.common.domain.BaseDomain;
import com.gdpu.common.service.IPageService;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.room.Clinicroom;
import com.gdpu.his.param.medical.MedicalHistoryParam;
import com.gdpu.his.param.room.ClinicroomParam;
import com.gdpu.his.service.IHISBaseService;
import org.springframework.web.servlet.ModelAndView;

;

/**
 * 《科室》 业务逻辑服务接口
 *
 * @author 郭旭辉
 */
public interface IClinicroomService<D extends IHISBaseDAO<T>, T extends BaseDomain> extends IHISBaseService<D, T>, IPageService<D, T> {

    /**
     * 分页查询科室情况
     * @param param         查询参数
     * @param pageNo        页码
     * @param pageSize      页大小
     * @return  返回，视图与模型
     */
    ModelAndView queryPage(ClinicroomParam param, int pageNo, int pageSize);

    /**
     * 进入科室添加视图
     * @return  返回，视图与数据
     */
    ModelAndView loadAddBounced();

    /**
     * 新增科室
     * @param param             新增参数
     * @param currentUser       当前操作者
     * @return  返回，操作码
     */
    String addClinicRoom(ClinicroomParam param, AccountDto currentUser);

    /**
     * 进入科室更新视图
     * @param id    科室主键id
     * @return  返回，视图与数据
     */
    ModelAndView update(Long id);

    /**
     * 更新科室信息
     * @param param         更新参数
     * @param currentUser   当前操作者
     * @return  返回，操作码
     */
    String updateClinicRoom(ClinicroomParam param, AccountDto currentUser);

    /**
     * 停用、启用科室
     * @param param             更新参数
     * @param currentUser       当前操作者
     * @return  返回，操作码
     */
    String disabledOrEnabled(ClinicroomParam param, AccountDto currentUser);

    /**
     * 进入医生排班视图
     * @return  返回，视图与数据
     */
    ModelAndView loadDoctorBounced(Clinicroom clinicroom);

    /**
     * 获得科室信息
     * @param param     查询条件
     * @param pageNo    页码
     * @param pageSize  页大小
     * @return  返回，视图与数据
     */
    ModelAndView getRooms(MedicalHistoryParam param, int pageNo, int pageSize);
}