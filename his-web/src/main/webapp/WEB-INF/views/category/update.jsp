<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/20
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .cat {
        font-size: 14px;
        margin-left: 4px;
        border: 1px solid #f5f5f5;
        background-color: #EFB45F;
        padding: 9px;
        color: white;
        border-radius: 5px;
    }
    label{
        margin: 0;
    }
</style>
<div class="modal-dialog">
    <div class="modal-content animated bounceInRight"
         style="width: 670px;">
        <div class="modal-header" style="padding: 10px 15px">
            <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="false">×</span><span class="sr-only">关闭</span>
            </button>
            <span class="pull-left" style="font-size: 14px"> <b>修改分类标签 </b>(注：带 * 号为必填项)</span>
        </div>
        <small class="font-bold">
            <div class="modal-body" style="padding: 0">
                <form class="detail" id="updateCategory">
                    <table class="table table-bordered"
                           style="margin-bottom: 0;">
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>标签名称：</span></th>
                            <td width="35%">
                                <input type="text" name="id" value="${item.id}" hidden>
                                <input type="text" name="name" value="${item.name}">
                            </td>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>创建时间：</span></th>
                            <td width="35%">
                                <jsp:useBean id="createDate" class="java.util.Date"/>
                                <c:set target="${createDate}" property="time" value="${item.createDate}"/>
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${createDate}" type="both"/>
                            </td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>标签类型：</span></th>
                            <td width="35%">
                                <input type="radio" name="type" value="0" <c:if test="${item.type == 0}">checked</c:if>
                                >专业标签&nbsp;
                                <input type="radio" name="type" value="1" <c:if test="${item.type == 1}">checked</c:if>
                                >职务标签

                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;排序：</span></th>
                            <td width="35%">
                                <input type="text" name="priority" value="${item.priority}">
                            </td>
                        </tr>
                        <tr>
                            <th><span class="pull-right">&nbsp;标签描述：</span>
                            </th>
                            <td colspan="3">
                                <textarea name="description" style="width: 484px; height: 80px;">${item.description}</textarea>
                            </td>
                        </tr>

                    </table>
                    <div style="margin: 5px; text-align: center">
                        <button class="btn btn-primary" type="button" onclick="updateCategory()">保存
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
<script type="text/javascript" src="/js/module/category/update.js"></script>