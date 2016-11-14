
var addRelation = function (id) {
    var data = $("#addForm").serialize();
    data += "&rescuerId="+ id;
    $.ajax({
        url: 'addRelation',
        type: 'POST',
        dataType: 'JSON',
        data: data,
        success: function (result) {
            if (isSuccess(result)) {
                swal({title: "标签关系保存成功！", type: "success"}, function () {
                    $('#addRelation').modal('hide');
                });
            } else {
                swal({title: result.msg, type: "error"});
            }
        }
    })
};


