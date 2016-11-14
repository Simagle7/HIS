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

package com.gdpu.his.param.medical;

import com.gdpu.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《病历》 查询参数实体
 * @author 郭旭辉
 *
 */
public class MedicalHistoryParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——姓名
	*/
	public static final String F_Name="name";
	/**
	*字段常量——性别
	*/
	public static final String F_Sex="sex";
	/**
	*字段常量——年龄
	*/
	public static final String F_Age="age";
	/**
	*字段常量——职业
	*/
	public static final String F_Career="career";
	/**
	*字段常量——住址
	*/
	public static final String F_Address="address";
	/**
	*字段常量——婚姻，0：未婚，1：已婚
	*/
	public static final String F_IsMarried="isMarried";
	/**
	*字段常量——可靠程度，0：仅供参考，1：基本可靠，2：完全可靠
	*/
	public static final String F_Dependability="dependability";
	/**
	*字段常量——籍贯
	*/
	public static final String F_NativePlace="nativePlace";
	/**
	*字段常量——联系人
	*/
	public static final String F_Linkman="linkman";
	/**
	*字段常量——民族
	*/
	public static final String F_Nation="nation";
	/**
	*字段常量——联系电话
	*/
	public static final String F_Phone="phone";
	/**
	*字段常量——诊疗卡
	*/
	public static final String F_MedicalCard="medicalCard";
	/**
	*字段常量——病历详情表主键
	*/
	public static final String F_DetailId="detailId";
	
	private String name; //姓名
	private Boolean sex; //性别
	private Integer age; //年龄
	private String career; //职业
	private String address; //住址
	private Boolean isMarried; //婚姻，0：未婚，1：已婚
	private Integer dependability; //可靠程度，0：仅供参考，1：基本可靠，2：完全可靠
	private String nativePlace; //籍贯
	private String linkman; //联系人
	private String nation; //民族
	private String phone; //联系电话
	private String medicalCard; //诊疗卡
	private Long detailId; //病历详情表主键
    
	/**
	 *默认空构造函数
	 */
	public MedicalHistoryParam() {
		super();
	}
	 
	/**
	 * @return name 姓名
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * @param name 姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * @return sex 性别
	 */
	public Boolean getSex(){
		return this.sex;
	}
	/**
	 * @param sex 性别
	 */
	public void setSex(Boolean sex){
		this.sex = sex;
	}
	/**
	 * @return age 年龄
	 */
	public Integer getAge(){
		return this.age;
	}
	/**
	 * @param age 年龄
	 */
	public void setAge(Integer age){
		this.age = age;
	}
	/**
	 * @return career 职业
	 */
	public String getCareer(){
		return this.career;
	}
	/**
	 * @param career 职业
	 */
	public void setCareer(String career){
		this.career = career;
	}
	/**
	 * @return address 住址
	 */
	public String getAddress(){
		return this.address;
	}
	/**
	 * @param address 住址
	 */
	public void setAddress(String address){
		this.address = address;
	}
	/**
	 * @return isMarried 婚姻，0：未婚，1：已婚
	 */
	public Boolean getIsMarried(){
		return this.isMarried;
	}
	/**
	 * @param isMarried 婚姻，0：未婚，1：已婚
	 */
	public void setIsMarried(Boolean isMarried){
		this.isMarried = isMarried;
	}
	/**
	 * @return dependability 可靠程度，0：仅供参考，1：基本可靠，2：完全可靠
	 */
	public Integer getDependability(){
		return this.dependability;
	}
	/**
	 * @param dependability 可靠程度，0：仅供参考，1：基本可靠，2：完全可靠
	 */
	public void setDependability(Integer dependability){
		this.dependability = dependability;
	}
	/**
	 * @return nativePlace 籍贯
	 */
	public String getNativePlace(){
		return this.nativePlace;
	}
	/**
	 * @param nativePlace 籍贯
	 */
	public void setNativePlace(String nativePlace){
		this.nativePlace = nativePlace;
	}
	/**
	 * @return linkman 联系人
	 */
	public String getLinkman(){
		return this.linkman;
	}
	/**
	 * @param linkman 联系人
	 */
	public void setLinkman(String linkman){
		this.linkman = linkman;
	}
	/**
	 * @return nation 民族
	 */
	public String getNation(){
		return this.nation;
	}
	/**
	 * @param nation 民族
	 */
	public void setNation(String nation){
		this.nation = nation;
	}
	/**
	 * @return phone 联系电话
	 */
	public String getPhone(){
		return this.phone;
	}
	/**
	 * @param phone 联系电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * @return medicalCard 诊疗卡
	 */
	public String getMedicalCard(){
		return this.medicalCard;
	}
	/**
	 * @param medicalCard 诊疗卡
	 */
	public void setMedicalCard(String medicalCard){
		this.medicalCard = medicalCard;
	}
	/**
	 * @return detailId 病历详情表主键
	 */
	public Long getDetailId(){
		return this.detailId;
	}
	/**
	 * @param detailId 病历详情表主键
	 */
	public void setDetailId(Long detailId){
		this.detailId = detailId;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("name",getName())
			.append("sex",getSex())
			.append("age",getAge())
			.append("career",getCareer())
			.append("address",getAddress())
			.append("isMarried",getIsMarried())
			.append("dependability",getDependability())
			.append("nativePlace",getNativePlace())
			.append("linkman",getLinkman())
			.append("nation",getNation())
			.append("phone",getPhone())
			.append("medicalCard",getMedicalCard())
			.append("detailId",getDetailId())
			.append("creator",getCreator())
			.append("createDate",getCreateDate())
			.append("lastModifier",getLastModifier())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
