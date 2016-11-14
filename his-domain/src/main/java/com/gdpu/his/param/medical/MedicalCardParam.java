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

package com.gdpu.his.param.medical;

import com.gdpu.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《诊疗卡，可以有多卡（病人诊疗卡丢失补办卡号不相同，原卡状态审核）》 查询参数实体
 * @author 郭旭辉
 *
 */
public class MedicalCardParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——诊疗卡号
	*/
	public static final String F_Code="code";
	/**
	*字段常量——储值
	*/
	public static final String F_Value="value";
	/**
	*字段常量——初始化日期
	*/
	public static final String F_InitDate="initDate";
	/**
	*字段常量——出卡人
	*/
	public static final String F_Operator="operator";
	/**
	*字段常量——病历主键
	*/
	public static final String F_MhId="mhId";
	
	private String code; //诊疗卡号
	private Double value; //储值
	private Long initDate; //初始化日期
	private String operator; //出卡人
	private Long mhId; //病历主键
    
	/**
	 *默认空构造函数
	 */
	public MedicalCardParam() {
		super();
	}
	 
	/**
	 * @return code 诊疗卡号
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 诊疗卡号
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return value 储值
	 */
	public Double getValue(){
		return this.value;
	}
	/**
	 * @param value 储值
	 */
	public void setValue(Double value){
		this.value = value;
	}
	/**
	 * @return initDate 初始化日期
	 */
	public Long getInitDate(){
		return this.initDate;
	}
	/**
	 * @param initDate 初始化日期
	 */
	public void setInitDate(Long initDate){
		this.initDate = initDate;
	}
	/**
	 * @return operator 出卡人
	 */
	public String getOperator(){
		return this.operator;
	}
	/**
	 * @param operator 出卡人
	 */
	public void setOperator(String operator){
		this.operator = operator;
	}
	/**
	 * @return mhId 病历主键
	 */
	public Long getMhId(){
		return this.mhId;
	}
	/**
	 * @param mhId 病历主键
	 */
	public void setMhId(Long mhId){
		this.mhId = mhId;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("code",getCode())
			.append("value",getValue())
			.append("initDate",getInitDate())
			.append("operator",getOperator())
			.append("mhId",getMhId())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
