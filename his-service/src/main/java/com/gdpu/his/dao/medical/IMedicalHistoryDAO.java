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

package com.gdpu.his.dao.medical;

import com.gdpu.his.dao.IHISBaseDAO;
import com.gdpu.his.domain.medical.MedicalHistory;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
/**
 * 《病历》 数据访问接口
 * @author 郭旭辉
 *
 */
public interface IMedicalHistoryDAO extends IHISBaseDAO<MedicalHistory> {

 /**
  * 分页查询病人
  *
  * @param condition 查询条件
  * @param offset    偏移量
  * @param rows      行数
  * @return 返回，分页列表
  */
 java.util.List<MedicalHistory> querPageEx(@Param("condition") Map<String, Object> condition, @Param("offset") int offset, @Param("rows") int rows);

 /**
  * 统计分页结果
  *
  * @param condition 查询条件
  * @return 返回，统计结果
  */
 int countEx(@Param("condition") Map<String, Object> condition);
}