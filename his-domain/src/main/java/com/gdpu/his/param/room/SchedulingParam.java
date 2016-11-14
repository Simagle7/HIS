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

package com.gdpu.his.param.room;

import com.gdpu.common.param.CreateBaseParam;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * 《医护人员排班》 查询参数实体
 * @author 郭旭辉
 *
 */
public class SchedulingParam extends CreateBaseParam<Long> {
	private static final long serialVersionUID = 1L;

	/**
	 *字段常量——科室主键
	 */
	public static final String F_RoomId="roomId";
	/**
	 *字段常量——医护人员主键
	 */
	public static final String F_RescuerId="rescuerId";
	/**
	 *字段常量——时间点，排班当天时间戳
	 */
	public static final String F_TimePoint="timePoint";
	/**
	 *字段常量——代表一天的早上，下午和晚上，依次值为0,1,2
	 */
	public static final String F_DayPoint="dayPoint";
	/**
	 *字段常量——星期几，0表示星期1，以此类推
	 */
	public static final String F_Day="day";
	/**
	 *字段常量——第几周
	 */
	public static final String F_Week="week";

	private Integer roomId; //科室主键
	private Long rescuerId; //医护人员主键
	private Long timePoint; //时间点，排班当天时间戳
	private Integer dayPoint; //代表一天的早上，下午和晚上，依次值为0,1,2
	private Integer day; //星期几，0表示星期1，以此类推
	private Integer week; //第几周

	/**
	 *默认空构造函数
	 */
	public SchedulingParam() {
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

}