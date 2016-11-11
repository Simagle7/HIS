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

import com.gdpu.common.domain.BaseDomain;;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.room.IClinicroomDAO;
import com.gdpu.his.domain.room.Clinicroom;
import com.gdpu.his.service.room.IClinicroomService;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《科室》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("ClinicroomServiceImpl")
public class ClinicroomServiceImpl extends AbstractHISPageService<IHISBaseDAO<Clinicroom>, Clinicroom> implements IClinicroomService<IHISBaseDAO<Clinicroom>,Clinicroom>{
    @Autowired
    private IClinicroomDAO clinicroomDAO;

    @Override
    public IHISBaseDAO<Clinicroom> getDao() {
        return clinicroomDAO;
    }

}