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
import com.gdpu.common.exception.BizException;
import com.gdpu.common.utils.*;
import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.dao.medical.IMedicalCardDAO;
import com.gdpu.his.dao.medical.IMedicalHistoryDAO;
import com.gdpu.his.domain.medical.MedicalCard;
import com.gdpu.his.domain.medical.MedicalHistory;
import com.gdpu.his.param.medical.MedicalHistoryParam;
import com.gdpu.his.service.AbstractHISPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
 /**
 * 《病历》 业务逻辑服务类
 * @author 郭旭辉
 *
 */
@Service("MedicalHistoryServiceImpl")
public class MedicalHistoryServiceImpl extends AbstractHISPageService<IHISBaseDAO<MedicalHistory>, MedicalHistory> implements IMedicalHistoryService<IHISBaseDAO<MedicalHistory>,MedicalHistory>{
    @Autowired
    private IMedicalHistoryDAO medicalHistoryDAO;
     @Autowired
     private IMedicalCardDAO medicalCardDAO;

    @Override
    public IHISBaseDAO<MedicalHistory> getDao() {
        return medicalHistoryDAO;
    }

     @Override
     public ModelAndView queryPage(MedicalHistoryParam param, int pageNo, int pageSize) {
         ModelAndView mav = new ModelAndView("medical/list");
         List<MedicalHistory> data  = medicalHistoryDAO.querPageEx(param.toMap(), (pageNo-1)*pageSize, pageSize);
         int records = medicalHistoryDAO.countEx(param.toMap());
         mav.addObject("data", PageUtils.toBizData4Page(data, pageNo, pageSize, records));
         return mav;
     }

     @Override
     public String addPatient(MedicalHistory medicalHistory, AccountDto currentUser) {
         medicalHistory.setMedicalCard(CommonUtils.getUUID());
         medicalHistory.setCreator(currentUser.getUid());
         medicalHistory.setCreateDate(System.currentTimeMillis());
         medicalHistory.setStatus(DataStatusEnum.ENABLED.getValue());
         if(this.insert(medicalHistory) > 0){//插入数据
             MedicalCard medicalCard = new MedicalCard();
             medicalCard.setCode(medicalHistory.getMedicalCard());
             medicalCard.setInitDate(medicalCard.getCreateDate());
             medicalCard.setMhId(medicalHistory.getId());
             medicalCard.setOperator(currentUser.getName());
             medicalCard.setCreator(currentUser.getUid());
             medicalCard.setCreateDate(medicalHistory.getCreateDate());
             medicalCard.setStatus(DataStatusEnum.ENABLED.getValue());
             if(medicalCardDAO.insert(medicalCard) > 0){
                 return RETURNCODE.ADD_COMPLETE.getMessage();
             }
         }
        throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }

     @Override
     public String disabledOrEnabled(MedicalHistoryParam param, AccountDto currentUser) {
         param.setLastModDate(System.currentTimeMillis());
         param.setLastModifier(currentUser.getUid());
         if(this.updateMap(param.toMap()) > 0){
             return RETURNCODE.UPDATE_COMPLETE.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }

     @Override
     public ModelAndView update(Long id) {
         ModelAndView mav = new ModelAndView("medical/update");
         mav.addObject("item", this.findOne(MedicalHistoryParam.F_ID, id));
         return mav;
     }

     @Override
     public String updatePatient(MedicalHistoryParam param, AccountDto currentUser) {
         param.setLastModDate(System.currentTimeMillis());
         param.setLastModifier(currentUser.getUid());
         if(this.updateMap(param.toMap()) > 0){
             return RETURNCODE.UPDATE_COMPLETE.getMessage();
         }
         throw new BizException(ERRORCODE.OPERATION_FAIL.getCode(), ERRORCODE.OPERATION_FAIL.getMessage());
     }
 }