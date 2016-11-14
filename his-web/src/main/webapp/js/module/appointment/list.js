/**
 * Created by simagle on 2016/10/17.
 */
var pageNo = 1;         //页码
var pageSize = 10;      //页大小
var searchForm = "";    //查询条件
function appointing(id,categoryId,status) {
    if(status == 1){    //如果科室是被禁用的话将无法进行排班
        swal({title:"当前科室处于停用状态！无法预约！", type:"warning"});
        return;
    }else{
        // todo 进行预约
        swal({title:"预约成功！", type:"success"});

    }
}

/**
 * 选择页码
 */
$("#pageSize").change(function () {
    pageSize = $(this).children('option:selected').val();
    window.location.href = "/rest/clinicRoom/list?pageNo=" + pageNo + "&pageSize=" + pageSize;
});

/**
 * 分页查询
 */
var queryPage = function () {
    searchForm = $("#searchForm").serialize();
    searchForm += "&pageNo=" + pageNo;
    searchForm += "&pageSize=" + pageSize;
    window.location.href = "/rest/clinicRoom/list?" + searchForm;
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
