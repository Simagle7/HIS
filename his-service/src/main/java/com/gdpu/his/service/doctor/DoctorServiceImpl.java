/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医生基础信息表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-17  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package com.gdpu.his.service.doctor;

import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.doctor.IDoctorDAO;
import com.gdpu.his.domain.doctor.Doctor;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 /**
 * 《医生基础信息》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("DoctorServiceImpl")
public class DoctorServiceImpl extends AbstractHISPageService<IHISBaseDAO<Doctor>, Doctor> implements IDoctorService<IHISBaseDAO<Doctor>,Doctor>{
    @Autowired
    private IDoctorDAO doctorDAO;

    @Override
    public IHISBaseDAO<Doctor> getDao() {
        return doctorDAO;
    }

}