
var validator = $("#updateCategory").validate({
    rules: {
        name: {required: true},
        type: {required: true, min: 0},
        priority: {min: 0}
    },
    messages: {
        name: {required: "标签名称不能为空"},
        type: {required: "未选择分类", min: "未选择分类"},
        priority: {min: "排序值不能为负数"}

    },
    errorPlacement: errorPlacement,
    success: "valid"
});

var updateCategory = function () {
    if (validator.form()) {
        var data = $("#updateCategory").serialize();
        console.log(data);
        $.ajax({
            url: 'updateCategory',
            type: 'POST',
            dataType: 'JSON',
            data:data,
            success: function (result) {
                if(isSuccess(result)){
                    swal({title:"分类标签更新成功！", type:"success"},function(){
                        //todo 回调跳转到列表页
                        $('#update').modal('hide');
                        setTimeout(function () {
                            window.location.href = "/rest/category/list";
                        }, 500);
                    });
                }else{
                    swal({title:result.msg,type:"error"});
                }
            }
        })
    }
};
