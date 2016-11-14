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

package com.gdpu.his.dao.medical;

import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.medical.MedicalCard;
import com.gdpu.his.domain.medical.MedicalHistory;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 《诊疗卡，可以有多卡（病人诊疗卡丢失补办卡号不相同，原卡状态审核）》 数据访问接口
 *
 * @author 郭旭辉
 */
public interface IMedicalCardDAO extends IHISBaseDAO<MedicalCard> {



}