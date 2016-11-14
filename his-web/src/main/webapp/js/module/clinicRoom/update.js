
var validator = $("#updateForm").validate({
    rules: {
        name: {required: true},
        clinicNum: {required: true},
        categoryId:{required: true,min:1},
        address: {required: true}
    },
    messages: {
        name: {required: "科室名称不能为空"},
        clinicNum: {required: "科室号不能为空"},
        categoryId: {required: "未选择分类", min: "未选择分类"},
        address:{required: "地址不能为空"}
    },
    errorPlacement: errorPlacement,
    success: "valid"
});

var updateClinicRoom = function () {
    if (validator.form()) {
        var data = $("#updateForm").serialize();
        $.ajax({
            url: 'updateClinicRoom',
            type: 'POST',
            dataType: 'JSON',
            data:data,
            success: function (result) {
                if(isSuccess(result)){
                    swal({title:"科室更新成功！", type:"success"},function(){
                        //todo 回调跳转到列表页
                        $('#update').modal('hide');
                        setTimeout(function () {
                            window.location.href = "/rest/clinicRoom/list";
                        }, 500);
                    });
                }else{
                    swal({title:result.msg,type:"error"});
                }
            }
        })
    }
};
