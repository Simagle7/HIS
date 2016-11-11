/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医疗人员标签关系（fs_sys_relationRC）											
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

import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.sys.IRelationRCDAO;
import com.gdpu.his.domain.sys.RelationRC;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

;

 /**
 * 《医疗人员标签关系（fs_sys_relationRC）》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("RelationRCServiceImpl")
public class RelationRCServiceImpl extends AbstractHISPageService<IHISBaseDAO<RelationRC>, RelationRC> implements IRelationRCService<IHISBaseDAO<RelationRC>,RelationRC>{
    @Autowired
    private IRelationRCDAO relationRCDAO;

    @Override
    public IHISBaseDAO<RelationRC> getDao() {
        return relationRCDAO;
    }

}