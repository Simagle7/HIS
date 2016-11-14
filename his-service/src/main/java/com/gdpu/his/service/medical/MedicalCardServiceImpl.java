/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：诊疗卡，可以有多卡（病人诊疗卡丢失补办卡号不相同，原卡状态审核）											
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

import com.gdpu.common.domain.BaseDomain;;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.medical.IMedicalCardDAO;
import com.gdpu.his.domain.medical.MedicalCard;
import com.gdpu.his.service.medical.IMedicalCardService;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

 /**
 * 《诊疗卡，可以有多卡（病人诊疗卡丢失补办卡号不相同，原卡状态审核）》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("MedicalCardServiceImpl")
public class MedicalCardServiceImpl extends AbstractHISPageService<IHISBaseDAO<MedicalCard>, MedicalCard> implements IMedicalCardService<IHISBaseDAO<MedicalCard>,MedicalCard>{
    @Autowired
    private IMedicalCardDAO medicalCardDAO;

    @Override
    public IHISBaseDAO<MedicalCard> getDao() {
        return medicalCardDAO;
    }

}