
var validator = $("#updateItem").validate({
    rules: {
        name: {required: true},
        nativePlace: {required: true},
        phone: {required: true},
        nation:{required:true},
        linkman:{required:true},
        dependability:{required:true, min:0}
    },
    messages: {
        name: {required: "姓名不能为空"},
        nativePlace: {required: "籍贯不能为空"},
        phone: {required: "联系电话"},
        nation:{required:"民族不能为空"},
        linkman:{required:"联系人不能为空"},
        dependability:{required:"",min:"请选择可靠程度"}

    },
    errorPlacement: errorPlacement,
    success: "valid"
});

var updateItem = function () {
    if (validator.form()) {
        var data = $("#updateItem").serialize();
        console.log(data);
        $.ajax({
            url: 'updatePatient',
            type: 'POST',
            dataType: 'JSON',
            data:data,
            success: function (result) {
                if(isSuccess(result)){
                    swal({title:"病人信息更新成功！", type:"success"},function(){
                        //todo 回调跳转到列表页
                        $('#update').modal('hide');
                        setTimeout(function () {
                            window.location.href = "/rest/medicalHistory/list";
                        }, 500);
                    });
                }else{
                    swal({title:result.msg,type:"error"});
                }
            }
        })
    }
};
