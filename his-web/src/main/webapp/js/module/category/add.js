/**
 * Created by simagle on 2016/10/20.
 */


//$(document).ready(function () {
//    $("#catBounced").popover({
//        title: '选择分类',
//        delay: 0.1,
//        html: true,
//        content: "<div id='tree'></div>",
//        template: '<div class="popover"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>',
//    });
//    $("#catBounced").on("shown.bs.popover", function () {
//        $("#tree").load('catTree');
//    });
//    $("#addImages").popover({
//        title: '添加图片',
//        delay: 0.1,
//        html: true,
//        content: "<div id='images'></div>",
//        template: '<div class="popover"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>',
//    });
//    $("#addImages").on("shown.bs.popover", function () {
//        $("#images").load('addImages');
//    });
//
//});
var validator = $("#addItem").validate({
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
////加入富文本编辑器
//var editor = new wangEditor('textarea1');
//editor.config.menus = [
//    'bold', 'underline', 'italic', 'strikethrough', 'eraser', 'forecolor', 'bgcolor', '|', 'link', 'unlink', 'emotion', '|', 'img', '|', 'undo', 'redo', '|', 'quote', 'fontfamily', 'fontsize', 'head', 'unorderlist', 'orderlist', 'alignleft', 'aligncenter', 'alignright'
//];
//editor.create();

var addItem = function () {
    if (validator.form()) {
        var data = $("#addItem").serialize();
        console.log(data);
        $.ajax({
            url: 'addCategory',
            type: 'POST',
            dataType: 'JSON',
            data:data,
            success: function (result) {
                if(isSuccess(result)){
                    swal({title:"分类标签添加成功！", type:"success"},function(){
                        //todo 回调跳转到列表页
                        $('#add').modal('hide');
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




//$(document).on('click', function (e) {
//    $('[data-toggle="popover"],[data-original-title]').each(function () {
//        //the 'is' for buttons that trigger popups
//        //the 'has' for icons within a button that triggers a popup
//        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
//            (($(this).popover('hide').data('bs.popover') || {}).inState || {}).click = false;  // fix for BS 3.3.6
//        }
//    });
//});