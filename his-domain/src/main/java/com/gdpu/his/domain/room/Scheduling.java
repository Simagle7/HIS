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
{  2016-11-13  郭旭辉        新建
{
{*****************************************************************************
*/

package com.gdpu.his.domain.room;

import com.gdpu.common.domain.HISCreateBaseDomain;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《医护人员排班》 实体
 * @author 郭旭辉
 *
 */
public class Scheduling extends HISCreateBaseDomain<Long> {
	private static final long serialVersionUID = 1L;

	private Integer roomId; //科室主键
	private Long rescuerId; //医护人员主键
	private Long timePoint; //时间点，排班当天时间戳
	private Integer dayPoint; //代表一天的早上，下午和晚上，依次值为0,1,2
	private Integer day; //星期几，0表示星期1，以此类推
	private Integer week; //第几周

	/**
	 *默认空构造函数
	 */
	public Scheduling() {
		super();
	}

	/**
	 * @return roomId 科室主键
	 */
	public Integer getRoomId(){
		return this.roomId;
	}
	/**
	 * @param roomId 科室主键
	 */
	public void setRoomId(Integer roomId){
		this.roomId = roomId;
	}
	/**
	 * @return rescuerId 医护人员主键
	 */
	public Long getRescuerId(){
		return this.rescuerId;
	}
	/**
	 * @param rescuerId 医护人员主键
	 */
	public void setRescuerId(Long rescuerId){
		this.rescuerId = rescuerId;
	}
	/**
	 * @return timePoint 时间点，排班当天时间戳
	 */
	public Long getTimePoint(){
		return this.timePoint;
	}
	/**
	 * @param timePoint 时间点，排班当天时间戳
	 */
	public void setTimePoint(Long timePoint){
		this.timePoint = timePoint;
	}
	/**
	 * @return dayPoint 代表一天的早上，下午和晚上，依次值为0,1,2
	 */
	public Integer getDayPoint(){
		return this.dayPoint;
	}
	/**
	 * @param dayPoint 代表一天的早上，下午和晚上，依次值为0,1,2
	 */
	public void setDayPoint(Integer dayPoint){
		this.dayPoint = dayPoint;
	}
	/**
	 * @return day 星期几，0表示星期1，以此类推
	 */
	public Integer getDay(){
		return this.day;
	}
	/**
	 * @param day 星期几，0表示星期1，以此类推
	 */
	public void setDay(Integer day){
		this.day = day;
	}
	/**
	 * @return week 第几周
	 */
	public Integer getWeek(){
		return this.week;
	}
	/**
	 * @param week 第几周
	 */
	public void setWeek(Integer week){
		this.week = week;
	}

	public String toString() {
		return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
				.append("id",getId())
				.append("roomId",getRoomId())
				.append("rescuerId",getRescuerId())
				.append("timePoint",getTimePoint())
				.append("dayPoint",getDayPoint())
				.append("day",getDay())
				.append("week",getWeek())
				.append("creator",getCreator())
				.append("createDate",getCreateDate())
				.append("lastModifier",getLastModifier())
				.append("lastModDate",getLastModDate())
				.append("status",getStatus())
				.toString();
	}

	public int hashCode() {
		return new HashCodeBuilder()
				.append(getId())
				.append(getRoomId())
				.append(getRescuerId())
				.append(getTimePoint())
				.append(getDayPoint())
				.append(getDay())
				.append(getWeek())
				.append(getCreator())
				.append(getCreateDate())
				.append(getLastModifier())
				.append(getLastModDate())
				.append(getStatus())
				.toHashCode();
	}

	public boolean equals(Object obj) {
		if(obj instanceof Scheduling == false) return false;
		if(this == obj) return true;
		Scheduling other = (Scheduling)obj;
		return new EqualsBuilder()
				.append(getId(),other.getId())
				.isEquals();
	}
}