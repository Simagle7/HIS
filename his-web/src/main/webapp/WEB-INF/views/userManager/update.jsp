<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/19
  Time: 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal-dialog">
    <div class="modal-content animated bounceInRight"
         style="width: 600px;">
        <div class="modal-header" style="padding: 10px 15px">
            <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="true">×</span><span class="sr-only">关闭</span>
            </button>

                                                            <span class="pull-left"
                                                                  style="font-size: 14px"> <b>修改 </b>(注：带 * 号为必填项,重置后密码默认为123456)</span>
        </div>
        <small class="font-bold">
            <div class="modal-body" style="padding: 0">
                <form class="detail" action="save" method="post">
                    <input type="text" value="${item.id}" name="id" hidden>
                    <table class="table table-bordered"
                           style="margin-bottom: 0;">
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>姓名：</span></th>
                            <td width="35%"><input type="text" name="name" value="${item.name}"></td>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp; 职务：</span></th>
                            <td width="35%"><input type="text" name="position" value="${item.position}"></td>

                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;账号：</span></th>
                            <td width="35%"><input type="text" name="username" value="${item.username}"></td>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;密码：</span></th>
                            <td width="35%"><button type="button" class="btn btn-warning">重置密码</button></td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;电话：</span></th>
                            <td width="35%"><input type="text" name="phone" value="${item.phone}"></td>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;类别：</span></th>
                            <td width="35%">
                                <input type="radio" name="category" value="0" <c:if test="${item.category == false}">checked</c:if>
                                       >医生&nbsp;
                                <input type="radio" name="category" value="1" <c:if test="${item.category == true}">checked</c:if>
                                       >护士
                            </td>
                        </tr>

                        <tr>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;年龄：</span>
                            </th>
                            <td width="35%"><input type="text" name="age" value="${item.age}"></td>
                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;性别：</span>
                            </th>
                            <td width="35%">
                                <input type="radio" name="sex" value="0" <c:if test="${item.sex == false}">checked</c:if>
                                       >男&nbsp;
                                <input type="radio" name="sex" value="1" <c:if test="${item.sex == true}">checked</c:if>
                                >女
                            </td>
                        </tr>

                        <tr>
                            <th><span class="pull-right"><b>*</b>&nbsp;专长：</span>
                            </th>
                            <td colspan="3">
                                <textarea name="major" style="width: 400px; height: 80px;" value="${item.major}"></textarea>
                            </td>
                        </tr>

                    </table>
                    <div style="margin: 5px; text-align: center">
                        <button class="btn btn-primary" type="submit">保存
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