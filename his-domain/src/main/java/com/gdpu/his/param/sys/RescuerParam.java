/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医疗人员基础信息表											
{  功能描述:										
{															
{  ---------------------------------------------------------------------------	
{  维护历史:													
{  日期        维护人        维护类型						
{  ---------------------------------------------------------------------------	
{  2016-10-18  郭旭辉        新建	
{ 	                                                                     
{*****************************************************************************
*/

package com.gdpu.his.param.sys;

import com.gdpu.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《医疗人员基础信息》 查询参数实体
 * @author 郭旭辉
 *
 */
public class RescuerParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——账号
	*/
	public static final String F_Username="username";
	/**
	*字段常量——密码
	*/
	public static final String F_Password="password";
	/**
	*字段常量——姓名
	*/
	public static final String F_Name="name";
	/**
	*字段常量——性别，0：男，1：女
	*/
	public static final String F_Sex="sex";
	/**
	*字段常量——年龄
	*/
	public static final String F_Age="age";
	/**
	*字段常量——职务
	*/
	public static final String F_Position="position";
	/**
	*字段常量——专长
	*/
	public static final String F_Major="major";
	/**
	*字段常量——工龄
	*/
	public static final String F_Seniority="seniority";
	/**
	*字段常量——工号
	*/
	public static final String F_JobNumber="jobNumber";
	/**
	*字段常量——联系电话
	*/
	public static final String F_Phone="phone";
	/**
	*字段常量——类别，0：医生，1：护士
	*/
	public static final String F_Category="category";
	/**
	*字段常量——代码
	*/
	public static final String F_Code="code";
	/**
	*字段常量——加密盐，用于权限管理
	*/
	public static final String F_Salty="salty";
	
	private String username; //账号
	private String password; //密码
	private String name; //姓名
	private Boolean sex; //性别，0：男，1：女
	private Integer age; //年龄
	private String position; //职务
	private String major; //专长
	private Integer seniority; //工龄
	private String jobNumber; //工号
	private String phone; //联系电话
	private Boolean category; //类别，0：医生，1：护士
	private String code; //代码
	private String salty; //加密盐，用于权限管理
    
	/**
	 *默认空构造函数
	 */
	public RescuerParam() {
		super();
	}
	 
	/**
	 * @return username 账号
	 */
	public String getUsername(){
		return this.username;
	}
	/**
	 * @param username 账号
	 */
	public void setUsername(String username){
		this.username = username;
	}
	/**
	 * @return password 密码
	 */
	public String getPassword(){
		return this.password;
	}
	/**
	 * @param password 密码
	 */
	public void setPassword(String password){
		this.password = password;
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
	 * @return sex 性别，0：男，1：女
	 */
	public Boolean getSex(){
		return this.sex;
	}
	/**
	 * @param sex 性别，0：男，1：女
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
	 * @return position 职务
	 */
	public String getPosition(){
		return this.position;
	}
	/**
	 * @param position 职务
	 */
	public void setPosition(String position){
		this.position = position;
	}
	/**
	 * @return major 专长
	 */
	public String getMajor(){
		return this.major;
	}
	/**
	 * @param major 专长
	 */
	public void setMajor(String major){
		this.major = major;
	}
	/**
	 * @return seniority 工龄
	 */
	public Integer getSeniority(){
		return this.seniority;
	}
	/**
	 * @param seniority 工龄
	 */
	public void setSeniority(Integer seniority){
		this.seniority = seniority;
	}
	/**
	 * @return jobNumber 工号
	 */
	public String getJobNumber(){
		return this.jobNumber;
	}
	/**
	 * @param jobNumber 工号
	 */
	public void setJobNumber(String jobNumber){
		this.jobNumber = jobNumber;
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
	 * @return category 类别，0：医生，1：护士
	 */
	public Boolean getCategory(){
		return this.category;
	}
	/**
	 * @param category 类别，0：医生，1：护士
	 */
	public void setCategory(Boolean category){
		this.category = category;
	}
	/**
	 * @return code 代码
	 */
	public String getCode(){
		return this.code;
	}
	/**
	 * @param code 代码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * @return salty 加密盐，用于权限管理
	 */
	public String getSalty(){
		return this.salty;
	}
	/**
	 * @param salty 加密盐，用于权限管理
	 */
	public void setSalty(String salty){
		this.salty = salty;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("username",getUsername())
			.append("password",getPassword())
			.append("name",getName())
			.append("sex",getSex())
			.append("age",getAge())
			.append("position",getPosition())
			.append("major",getMajor())
			.append("seniority",getSeniority())
			.append("jobNumber",getJobNumber())
			.append("phone",getPhone())
			.append("category",getCategory())
			.append("code",getCode())
			.append("salty",getSalty())
			.append("creator",getCreator())
			.append("lastModifier",getLastModifier())
			.append("createDate",getCreateDate())
			.append("lastModDate",getLastModDate())
			.append("status",getStatus())
			.toString();
	}
	
}
