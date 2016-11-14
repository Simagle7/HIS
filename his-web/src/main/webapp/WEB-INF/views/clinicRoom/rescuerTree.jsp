<%--
  Created by IntelliJ IDEA.
  User: simagle
  Date: 2016/10/20
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <ul style="padding-left: 15px;">
        <c:forEach items="#{rescuers}" var="el" varStatus="vs">
            <%--<li onclick="selectRescuer(${targetId}, ${el.name})"><label>${el.name}</label></li>--%>
            <li data-target-id="${targetId}" data-rescuer-id="${el.id}" value="${el.name}"><label>${el.name}</label></li>
        </c:forEach>
    </ul>
</div>
<script>
    $(document).ready(function () {
        $('li').click(function (e) {
            var id = $(this).attr('data-target-id');
            var value = $(this).attr('value');
            var rescuerId = $(this).attr('data-rescuer-id');
            $(id).val(value);
            $(id).attr("data-rescuerId",rescuerId);
            $('.popover').popover('hide');
        });
    });

</script>