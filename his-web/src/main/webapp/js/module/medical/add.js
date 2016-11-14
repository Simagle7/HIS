/**
 * Created by simagle on 2016/10/20.
 */


var validator = $("#addItem").validate({
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

var addItem = function () {
    if (validator.form()) {
        var data = $("#addItem").serialize();
        $.ajax({
            url: 'addPatient',
            type: 'POST',
            dataType: 'JSON',
            data:data,
            success: function (result) {
                if(isSuccess(result)){
                    swal({title:"病人添加成功！", type:"success"},function(){
                        //todo 回调跳转到列表页
                        $('#add').modal('hide');
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




//$(document).on('click', function (e) {
//    $('[data-toggle="popover"],[data-original-title]').each(function () {
//        //the 'is' for buttons that trigger popups
//        //the 'has' for icons within a button that triggers a popup
//        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
//            (($(this).popover('hide').data('bs.popover') || {}).inState || {}).click = false;  // fix for BS 3.3.6
//        }
//    });
//});