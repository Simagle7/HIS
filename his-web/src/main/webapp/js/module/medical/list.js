/**
 * Created by simagle on 2016/10/17.
 */
var pageNo = 1;         //页码
var pageSize = 10;      //页大小
var searchForm = "";    //查询条件
function loadAddBounced() {
    $("#add").load('add');
}
function loadUpdateBounced(id) {
    $("#update").load('update', {id: id});
}
function disabledOrEnabled(id, status) {
    var text = status == 1 ? "审核" : "启用";
    swal({
        title: "确定要" + text + "该标签？",
        type: "warning",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: text,
        cancelButtonText: "取消"
    }, function () {
        $.ajax({
            url: 'disabledOrEnabled',
            data: {id: id, status: status},
            type: "GET",
            async: false,
            success: function (result) {
                if (isSuccess(result)) {
                    //todo 回调跳转到列表页
                    setTimeout(function () {
                        window.location.href = "/rest/medicalHistory/list";
                    }, 500);
                } else {
                    swal({title: result.msg, type: "error"});
                }
            }
        });
    });
}
function deleteOne(id) {
    swal({
        title: "确定删除该病人？",
        text: "删除后将无法恢复，请谨慎操作！",
        type: "error",
        showCancelButton: true,
        confirmButtonColor: "#DD6B55",
        confirmButtonText: "删除",
        cancelButtonText: "取消"
    }, function () {
        $.ajax({
            url: 'deleteOne',
            data: {id: id},
            type: "GET",
            async: false,
            success: function (result) {
                //重新加载页面
                if (isSuccess(result)) {
                    //todo 回调跳转到列表页
                    setTimeout(function () {
                        window.location.href = "/rest/medicalHistory/list";
                    }, 500);
                } else {
                    swal({title: result.msg, type: "error"});
                }

            }
        });
    });
}

/**
 * 选择页码
 */
$("#pageSize").change(function () {
    pageSize = $(this).children('option:selected').val();
    window.location.href = "/rest/medicalHistory/list?pageNo=" + pageNo + "&pageSize=" + pageSize;
});

/**
 * 分页查询
 */
var queryPage = function () {
    searchForm = $("#searchForm").serialize();
    searchForm += "&pageNo=" + pageNo;
    searchForm += "&pageSize=" + pageSize;
    window.location.href = encodeURI("/rest/medicalHistory/list?" + searchForm);
    // window.location.href = "/rest/medicalHistory/list?" + searchForm;
};

/**
 * 重置
 */
var clear = function () {
    //重置
    $("#searchForm")[0].reset();
    pageNo = 1;
    pageSize = 10;
    searchForm = "";
    queryPage();
};


//首页，上下页，尾页
var selectPage= function (value,total) {
    pageNo += parseInt(value);
    if (pageNo < 1) {
        pageNo = 1;
    }
    if (pageNo > total) {
        pageNo = total;
    }
    queryPage();
};
