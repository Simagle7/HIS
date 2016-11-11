/*
{*****************************************************************************
{  设备管理 v1.0													
{  版权信息 (c) 2005-2016 郭旭辉. 保留所有权利.
{  创建人：  郭旭辉
{  审查人：
{  模块：医护人员排班											
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

package com.gdpu.his.param.room;

import com.gdpu.common.param.BaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《医护人员排班》 查询参数实体
 * @author 郭旭辉
 *
 */
public class SchedulingParam extends BaseParam<Long> {
	private static final long serialVersionUID = 1L;
	
	/**
	*字段常量——目标类型，0：科室，1：科别，用于医生和护士分配，医生为0；护士为1
	*/
	public static final String F_目标类型="目标类型";
	/**
	*字段常量——目标主键
	*/
	public static final String F_目标主键="目标主键";
	/**
	*字段常量——医护人员主键
	*/
	public static final String F_医护人员主键="医护人员主键";
	/**
	*字段常量——时间点，排班当天时间戳
	*/
	public static final String F_时间点="时间点";
	/**
	*字段常量——星期几，0表示星期1，以此类推
	*/
	public static final String F_星期="星期";
	/**
	*字段常量——第几周
	*/
	public static final String F_第几周="第几周";
	/**
	*字段常量——创建人
	*/
	public static final String F_创建人="创建人";
	/**
	*字段常量——创建时间
	*/
	public static final String F_创建时间="创建时间";
	/**
	*字段常量——修改人
	*/
	public static final String F_修改人="修改人";
	/**
	*字段常量——修改时间
	*/
	public static final String F_修改时间="修改时间";
	/**
	*字段常量——状态，0：正常，1：审核
	*/
	public static final String F_状态="状态";
	
	private Boolean 目标类型; //目标类型，0：科室，1：科别，用于医生和护士分配，医生为0；护士为1
	private Integer 目标主键; //目标主键
	private Long 医护人员主键; //医护人员主键
	private Long 时间点; //时间点，排班当天时间戳
	private Boolean 星期; //星期几，0表示星期1，以此类推
	private Integer 第几周; //第几周
	private String 创建人; //创建人
	private Long 创建时间; //创建时间
	private String 修改人; //修改人
	private Long 修改时间; //修改时间
	private Integer 状态; //状态，0：正常，1：审核
    
	/**
	 *默认空构造函数
	 */
	public SchedulingParam() {
		super();
	}
	 
	/**
	 * @return 目标类型 目标类型，0：科室，1：科别，用于医生和护士分配，医生为0；护士为1
	 */
	public Boolean get目标类型(){
		return this.目标类型;
	}
	/**
	 * @param 目标类型 目标类型，0：科室，1：科别，用于医生和护士分配，医生为0；护士为1
	 */
	public void set目标类型(Boolean 目标类型){
		this.目标类型 = 目标类型;
	}
	/**
	 * @return 目标主键 目标主键
	 */
	public Integer get目标主键(){
		return this.目标主键;
	}
	/**
	 * @param 目标主键 目标主键
	 */
	public void set目标主键(Integer 目标主键){
		this.目标主键 = 目标主键;
	}
	/**
	 * @return 医护人员主键 医护人员主键
	 */
	public Long get医护人员主键(){
		return this.医护人员主键;
	}
	/**
	 * @param 医护人员主键 医护人员主键
	 */
	public void set医护人员主键(Long 医护人员主键){
		this.医护人员主键 = 医护人员主键;
	}
	/**
	 * @return 时间点 时间点，排班当天时间戳
	 */
	public Long get时间点(){
		return this.时间点;
	}
	/**
	 * @param 时间点 时间点，排班当天时间戳
	 */
	public void set时间点(Long 时间点){
		this.时间点 = 时间点;
	}
	/**
	 * @return 星期 星期几，0表示星期1，以此类推
	 */
	public Boolean get星期(){
		return this.星期;
	}
	/**
	 * @param 星期 星期几，0表示星期1，以此类推
	 */
	public void set星期(Boolean 星期){
		this.星期 = 星期;
	}
	/**
	 * @return 第几周 第几周
	 */
	public Integer get第几周(){
		return this.第几周;
	}
	/**
	 * @param 第几周 第几周
	 */
	public void set第几周(Integer 第几周){
		this.第几周 = 第几周;
	}
	/**
	 * @return 创建人 创建人
	 */
	public String get创建人(){
		return this.创建人;
	}
	/**
	 * @param 创建人 创建人
	 */
	public void set创建人(String 创建人){
		this.创建人 = 创建人;
	}
	/**
	 * @return 创建时间 创建时间
	 */
	public Long get创建时间(){
		return this.创建时间;
	}
	/**
	 * @param 创建时间 创建时间
	 */
	public void set创建时间(Long 创建时间){
		this.创建时间 = 创建时间;
	}
	/**
	 * @return 修改人 修改人
	 */
	public String get修改人(){
		return this.修改人;
	}
	/**
	 * @param 修改人 修改人
	 */
	public void set修改人(String 修改人){
		this.修改人 = 修改人;
	}
	/**
	 * @return 修改时间 修改时间
	 */
	public Long get修改时间(){
		return this.修改时间;
	}
	/**
	 * @param 修改时间 修改时间
	 */
	public void set修改时间(Long 修改时间){
		this.修改时间 = 修改时间;
	}
	/**
	 * @return 状态 状态，0：正常，1：审核
	 */
	public Integer get状态(){
		return this.状态;
	}
	/**
	 * @param 状态 状态，0：正常，1：审核
	 */
	public void set状态(Integer 状态){
		this.状态 = 状态;
	}
	
	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
			.append("id",getId())
			.append("目标类型",get目标类型())
			.append("目标主键",get目标主键())
			.append("医护人员主键",get医护人员主键())
			.append("时间点",get时间点())
			.append("星期",get星期())
			.append("第几周",get第几周())
			.append("创建人",get创建人())
			.append("创建时间",get创建时间())
			.append("修改人",get修改人())
			.append("修改时间",get修改时间())
			.append("状态",get状态())
			.toString();
	}
	
}
