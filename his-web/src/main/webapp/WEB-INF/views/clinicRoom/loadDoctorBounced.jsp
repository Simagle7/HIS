<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/20
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" buffer="none" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    label{
        margin: 0;
    }
    .table td {
        width: 55px;
    }
    .table th {
        text-align: center;
    }
    .detail table td input[type='text'] {
        border: 0;
        width: 100%;
    }
</style>
<div class="modal-dialog">
    <div class="modal-content animated bounceInRight"
         style="width: 670px;">
        <div class="modal-header" style="padding: 10px 15px">
            <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="false">×</span><span class="sr-only">关闭</span>
            </button>
            <span class="pull-left" style="font-size: 14px"> <b>医生排班 </b></span>
            <span class="pull-left" >
                <select name="week" style=" height: 20px; margin-left: 5px;" onchange="selectWeek()">
                <option value="0">本周</option>
                <option value="1">下一周</option>
                <option value="2">后一周</option>
            </select>
            </span>
        </div>
        <small class="font-bold">
            <div class="modal-body" style="padding: 0">
                <form class="detail" id="addDcotorForm">
                    <input type="text" name="roomId" value="${clinicroom.id}" hidden>
                    <input type="text" name="categoryId" value="${clinicroom.categoryId}" hidden>
                    <table class="table table-bordered" style="margin-bottom: 0;">
                        <tr>
                            <td></td>
                            <th>星期一</th>
                            <th>星期二</th>
                            <th>星期三</th>
                            <th>星期四</th>
                            <th>星期五</th>
                            <th>星期六</th>
                            <th>星期日</th>
                        </tr>
                        <tr>
                            <th>上午</th>
                            <c:forEach items="${mooningScheduling}" var="el" varStatus="vs">
                                <td >
                                    <span rel="popover">
                                         <input id="rescuers0${vs.index}" type="text" value="<c:out value="${el.rescuerName}"/>" data-day="${vs.index}" data-dayPoint ="0" data-rescuerId="${el.rescuerId}">
                                    </span>
                                </td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th>下午</th>
                            <c:forEach items="${afternoonScheduling}" var="el" varStatus="vs">
                                <td>
                                    <span rel="popover">
                                         <input id="rescuers1${vs.index}" type="text" value="<c:out value="${el.rescuerName}"/>" data-day="${vs.index}" data-dayPoint ="1" data-rescuerId="${el.rescuerId}">
                                    </span>
                                </td>
                            </c:forEach>
                        </tr>
                        <tr>
                            <th>晚上</th>
                            <c:forEach items="${nightScheduling}" var="el" varStatus="vs">
                                <td>
                                     <span rel="popover">
                                         <input id="rescuers2${vs.index}" type="text" value="<c:out value="${el.rescuerName}"/>" data-day="${vs.index}" data-dayPoint ="2" data-rescuerId="${el.rescuerId}">
                                    </span>
                                </td>
                            </c:forEach>

                        </tr>
                    </table>
                    <div style="margin: 5px; text-align: center">
                        <button class="btn btn-primary" type="button" onclick="saveArrange4Doctor()">保存
                        </button>
                        <button type="button" class="btn btn-white"
                                data-dismiss="modal">关闭
                        </button>
                    </div>
                </form>
            </div>

        </small>
    </div>
    <small class="font-bold">
    </small>
</div>
<small class="font-bold">
</small>
<script type="text/javascript" src="/js/module/clinicRoom/loadDoctorBounced.js"></script>