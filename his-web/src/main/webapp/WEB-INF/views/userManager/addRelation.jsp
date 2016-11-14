<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/20
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<style>

    label{
        margin: 0;
    }
    .cat-span{
        padding: 1px;
        display: -moz-inline-box;
        display: inline-block;
        width: 120px;
    }
</style>
<div class="modal-dialog">
    <div class="modal-content animated bounceInRight"
         style="width: 780px;">
        <div class="modal-header" style="padding: 10px 15px">
            <button type="button" class="close" data-dismiss="modal">
                <span aria-hidden="false">×</span><span class="sr-only">关闭</span>
            </button>
            <span class="pull-left" style="font-size: 14px"> <b>添加医生标签 </b>(注：带 * 号为必填项)</span>
        </div>
        <small class="font-bold">
            <div class="modal-body" style="padding: 0">
                <form id="addForm" class="detail" >
                    <table class="table table-bordered" style="margin-bottom: 0;">
                        <tr>
                            <th width="15%"><span class="pull-right">姓名：</span></th>
                            <td width="35%">${rescuer.name}</td>
                            <th width="15%"><span class="pull-right">工号：</span></th>
                            <td width="35%">${rescuer.jobNumber}<input type="text"name="jobNumber" value="${rescuer.jobNumber}" hidden></td>
                        </tr>
                        <tr>
                            <th width="15%"><span class="pull-right"><b>*&nbsp;</b>专业标签：</span></th>
                            <td colspan="3">
                                <c:forEach items="${majorCategory}" var="el" varStatus = 'cl'>
                                   <span class="cat-span">
                                        <input type="checkbox" name="categoryIds" value="<c:out value='${el.id}'/>"> <c:out value='${el.name}'/>
                                   </span>
                                    <c:if test="${(cl.index+1) % 5 == 0}"><br/></c:if>
                                </c:forEach>
                            </td>
                        </tr>
                        <tr>
                            <th><span class="pull-right"><b>*&nbsp;</b>职务标签：</span>
                            </th>
                            <td colspan="3">
                                <c:forEach items="${careerCategory}" var="el" varStatus = 'cl'>
                                   <span class="cat-span">
                                        <input type="checkbox" name="categoryIds" value="<c:out value='${el.id}'/>"> <c:out value='${el.name}'/>
                                   </span>
                                    <c:if test="${(cl.index+1) % 5 == 0}"><br/></c:if>
                                </c:forEach>
                             </td>
                        </tr>
                    </table>
                    <div style="margin: 5px; text-align: center">
                        <button class="btn btn-primary" type="button" onclick="addRelation(${rescuer.id})">保存</button>
                        <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
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
<script type="text/javascript" src="/js/module/userManager/addRelation.js"></script>