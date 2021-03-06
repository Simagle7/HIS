<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/17
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>科室管理管理页面</title>
    <link rel="shortcut icon" href="favicon.ico"/>
    <link href="/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet"/>
    <link href="/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet"/>
    <link href="/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet"/>
    <link href="/css/animate.min.css" rel="stylesheet"/>
    <link href="/css/style.min862f.css?v=4.1.0" rel="stylesheet"/>
    <link rel="stylesheet" href="/css/plugins/sweetalert/sweetalert.css"/>

    <!-- 其他样式库 -->
    <link rel="stylesheet" href="/lib/zTree/css/zTreeStyle/zTreeStyle.css"/>
    <link rel="stylesheet" href="/lib/qtip/jquery.qtip.min.css"/>
    <link rel="stylesheet" href="/js/plugins/wangEditor/css/wangEditor.min.css"/>
    <style>
        .search-label {
            padding-right: 5px;
        }

        .btn-width {
            min-width: 60px;
        }

       .detail table th {
            font-size: 14px;
            background-color: #1ab394;
            color: #ffffff;
        }

        .detail table td {
            background-color: #f3f3f4;
        }

       .detail table td input[type='text'] {
            width: 150px;
        }
        .status{
            color: #fff;
            border: 1px solid;
            padding: 9px;
            font-size: 13px;
            border-radius: 5px;
        }
        .status-info{
            background-color: #23C6C8;
        }
        .status-warning{
            background-color: #F8AC59;
        }
    </style>
</head>
<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <!-- Panel Other -->
    <div class="ibox float-e-margins">
        <div class="ibox-title">
            <h5>科室管理</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
                <a class="close-link">
                    <i class="fa fa-times"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <div class="row row-lg">
                <div class="col-sm-12">
                    <div class="example-wrap">
                        <div class="example">
                            <div>
                                <form id="searchForm">
                                    <span><b>科室名称：</b></span>
                                    <label class="search-label"><input class="form-control input-outline" type="text"
                                                                       name="name"></label>
                                    <span><b>科室号：</b></span>
                                    <label class="search-label"><input class="form-control input-outline" type="text"
                                                                       name="name"></label>
                                    <button type="button" class="btn btn-w-m btn-primary btn-width" onclick="queryPage()">查询</button>
                                    <button type="button" class="btn btn-w-m btn-primary btn-width" onclick="clear()">重置</button>
                                </form>
                            </div>
                            <div class="bootstrap-table">
                                <div class="fixed-table-toolbar">
                                    <div class="bars pull-left">
                                        <div class="btn-group hidden-xs" id="exampleTableEventsToolbar" role="group">
                                            <button data-toggle="modal" data-target="#add" type="button"
                                                    class="btn btn-outline btn-default" onclick="loadAddBounced()">
                                                <i class="glyphicon glyphicon-plus" aria-hidden="true"></i>
                                            </button>
                                            <div class="modal fade" id="add" tabindex="-1" role="dialog"
                                                 aria-hidden="true" style="display: none;">
                                            </div>
                                            <button id="deleteAll" type="button" class="btn btn-outline btn-default">
                                                <i class="glyphicon glyphicon-trash" aria-hidden="true"></i>
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <table class="table table-bordered" style="margin-bottom: 0">
                            <thead>
                            <tr>
                                <th width="2%"><input type="checkbox"></th>
                                <th width="15%">科室名称</th>
                                <th width="10%">科室号</th>
                                <th width="10%">科室类型</th>
                                <th width="33%">科室位置</th>
                                <%--<th width="15%">科室代码</th>--%>
                                <th width="5%">状态</th>
                                <th width="25%">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${data.rows}" var="el">
                                <tr>
                                    <td><input type="checkbox" name="id" value="<c:out value='${el.id}'/>"></td>
                                    <td><c:out value="${el.name}" /></td>

                                    <td><c:out value="${el.clinicNum}" /></td>
                                    <td><c:out value="${el.categoryName}" /></td>
                                    <td><c:out value="${el.address}" /></td>
                                    <%--<td><c:out value="${el.code}" /></td>--%>
                                    <td>
                                        <c:if test="${el.status == 0}">
                                            <span class="label label-info"><i class="fa fa-check"></i>启用</span>
                                        </c:if>
                                        <c:if test="${el.status == 1}">
                                            <span class="label label-warning"><i class="fa fa-times"></i>停用</span>
                                        </c:if>
                                    </td>
                                    <td>
                                        <button data-toggle="modal" data-target="#update" type="button" class="btn btn-info" onclick="loadUpdateBounced(<c:out value="${el.id}"/>)">修改</button>
                                        <div class="modal inmodal in" id="update" tabindex="-1" role="dialog"
                                             aria-hidden="true" style="display: none;">
                                        </div>
                                        <c:choose>
                                            <c:when test="${el.status == 1}">
                                                <button type="button" class="btn  btn-info" onclick="disabledOrEnabled(${el.id},0)">
                                                    启用
                                                </button>
                                                <button type="button" class="btn  btn-danger" onclick="deleteOne(${el.id})">
                                                    删除
                                                </button>
                                            </c:when>
                                            <c:when test="${el.status == 0}">
                                                <button type="button" class="btn  btn-warning" onclick="disabledOrEnabled(${el.id},1)">
                                                    停用
                                                </button>
                                            </c:when>
                                        </c:choose>
                                        <button data-toggle="modal" data-target="#arrangeDoctor" type="button" class="btn btn-info" onclick="loadDoctorBounced(${el.id},${el.categoryId}, ${el.status})">医生排班</button>
                                        <div class="modal inmodal in" id="arrangeDoctor" tabindex="-1" role="dialog"
                                             aria-hidden="true" style="display: none;">
                                        </div>
                                        <button data-toggle="modal" data-target="#arrangeNurse" type="button" class="btn btn-info" onclick="loadUpdateBounced(<c:out value="${el.id}"/>)">护士排班</button>
                                        <div class="modal inmodal in" id="arrangeNurse" tabindex="-1" role="dialog"
                                             aria-hidden="true" style="display: none;">
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <div class="example-wrap">
                            <div class="example">
                                <div class="fixed-table-pagination" style="display: block;">
                                    <div class="pull-left pagination-detail">
                                        <span class="pagination-info">显示第 <c:out value="${data.offset}" /> 到第 <c:out value="${data.endOffset}" /> 条记录，总共<c:out value="${data.records}" /> 条记录 每页显示</span>
                                    </div>
                                    <div class="pull-left pagination-detail">
                                        <select id="pageSize" style="width: 75px;float: left; margin-right: 5px;" class="form-control input-sm" >
                                            <option value="10" <c:if test="${data.pageSize == 10}">selected</c:if>>10</option>
                                            <option value="25" <c:if test="${data.pageSize == 25}">selected</c:if>>25</option>
                                            <option value="50" <c:if test="${data.pageSize == 50}">selected</c:if>>50</option>
                                            <option value="100" <c:if test="${data.pageSize == 100}">selected</c:if>>100</option>
                                        </select>
                                        <span class="pagination-info"> 条记录</span>
                                    </div>
                                    <div class="pull-right pagination" style="display: block;">
                                        <ul class="pagination pagination-outline">
                                            <li class="page-first <c:if test='${data.page == 1}'>disabled</c:if>" ><a href="javascript:void(0)" onclick="selectPage(-9999, ${data.total})">«</a></li>
                                            <li class="page-pre <c:if test='${data.page == 1}'>disabled</c:if>"><a href="javascript:void(0)" onclick="selectPage(-1, ${data.total})">‹</a></li>
                                            <li class="page-next <c:if test='${data.page == data.total}'>disabled</c:if>"><a href="javascript:void(0)" onclick="selectPage(1, ${data.total})">›</a></li>
                                            <li class="page-last <c:if test='${data.page == data.total}'>disabled</c:if>"><a href="javascript:void(0)" onclick="selectPage(9999, ${data.total})">»</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>

                <!-- End Example Events -->
            </div>
        </div>
    </div>
</div>
<!-- End Panel Other -->
</div>

<script type="text/javascript" src="/js/jquery.min.js?v=2.1.4"></script>
<script type="text/javascript" src="/js/bootstrap.min.js?v=3.3.6"></script>
<script type="text/javascript" src="/js/content.min.js?v=1.0.0"></script>
<script type="text/javascript" src="/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script type="text/javascript" src="/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script type="text/javascript" src="/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="/js/plugins/sweetalert/sweetalert.min.js"></script>
<script type="text/javascript" src="/lib/zTree/js/jquery.ztree.all-3.5.js"></script>
<script type="text/javascript" src="/lib/zTree/js/jquery.ztree.exhide-3.5.min.js"></script>
<script type="text/javascript" src="/lib/qtip/jquery.qtip.min.js"></script>
<script type="text/javascript" src="/js/plugins/validate/jquery.validate.min.js"></script>
<script type="text/javascript" src="/js/plugins/wangEditor/js/wangEditor.min.js"></script>
<!--引入本地js-->
<script type="text/javascript" src="/js/common.js"></script>
<script type="text/javascript"  src="/js/module/clinicRoom/list.js"></script>
</body>
</html>
