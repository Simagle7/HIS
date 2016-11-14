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
                <form class="detail" id="updateItem">
                    <table class="table table-bordered"
                           style="margin-bottom: 0;">
                        <input type="text" name="id" value="${item.id}" hidden>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>姓名：</span></th>
                            <td width="35%"><input type="text" name="name" value="${item.name}"></td>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>籍贯：</span></th>
                            <td width="35%"><input type="text" name="nativePlace" value="${item.nativePlace}"></td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>联系电话：</span></th>
                            <td width="35%">
                                <input type="text" name="phone" value="${item.phone}">
                            </td>

                            <th width="15%"><span class="pull-right"><b>*</b>&nbsp;民族：</span></th>
                            <td width="35%">
                                <input type="text" name="nation" value="${item.nation}">
                            </td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>联系人：</span></th>
                            <td width="35%"><input type="text" name="linkman" value="${item.linkman}"></td>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>可靠程度：</span></th>
                            <td width="35%">
                                <select name="dependability" style="height: 28px;">
                                    <option value="-1">请选择</option>
                                    <option value="0" <c:if test="${item.dependability == 0}">selected</c:if>>仅供参考</option>
                                    <option value="1" <c:if test="${item.dependability == 1}">selected</c:if>>基本可信</option>
                                    <option value="2" <c:if test="${item.dependability == 2}">selected</c:if>>完全可行</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>性别：</span></th>
                            <td width="35%">
                                <input type="radio" name="sex" value="0" <c:if test="${item.sex == false}">checked</c:if>>男&nbsp;
                                <input type="radio" name="sex" value="1" <c:if test="${item.sex == true}">checked</c:if>>女
                            </td>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>婚姻：</span></th>
                            <td width="35%">
                                <input type="radio" name="isMarried" value="0" <c:if test="${item.isMarried == false}">checked</c:if>>未婚&nbsp;
                                <input type="radio" name="isMarried" value="1" <c:if test="${item.isMarried == false}">checked</c:if>>已婚
                            </td>
                        </tr>
                        <tr>
                            <th><span class="pull-right">&nbsp;年龄：</span>
                            </th>
                            <td ><input type="text" name="age" value="${item.age}"></textarea>
                            </td>
                            <th><span class="pull-right">&nbsp;职业：</span>
                            </th>
                            <td ><input type="text" name="career" value="${item.career}"></textarea>
                            </td>
                        </tr>
                        <tr>
                            <th><span class="pull-right">&nbsp;住址：</span>
                            </th>
                            <td colspan="3"><textarea name="address" style="width: 484px; height: 80px;">${item.address}</textarea>
                            </td>
                        </tr>


                    </table>
                    <div style="margin: 5px; text-align: center">
                        <button class="btn btn-primary" type="button" onclick="updateItem()">保存
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
<script type="text/javascript" src="/js/module/medical/update.js"></script>