$(document).ready(function () {
    var day = 0;            //星期几，0表示星期1，以此类推
    var dayPoint = 0;       //代表一天的早上，下午和晚上，依次值为0,1,2
    var week = 0;           //第几周.0：本周，1：下一周，2：后一周
    var roomId = $("input[name='roomId']").val();         //分类标签主键id
    var categoryId = $("input[name='categoryId']").val();         //分类标签主键id
    var targetId;       //单元格id
    var selectWeek = function () {
        week = $("select[name='week']").children('option:selected').val();
    };
    window.selectWeek = selectWeek;
    $(":input[data-day]").click(function (e) {
        day = $(e.target).attr('data-day');
        dayPoint = $(e.target).attr('data-dayPoint');
        targetId = '#' + $(e.target).attr('id');
    });

    $("span[rel='popover']").popover({
        title: '选择医生',
        delay: 0.1,
        html: true,
        content: "<div id='tree'></div>",
        template: '<div class="popover" style="width: 120px;"><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>',
    });
    $("span[rel='popover']").on("shown.bs.popover", function () {
        $("#tree").load('initDoctorTree', {
            day: day,
            dayPoint: dayPoint,
            week: week,
            categoryId: categoryId,
            targetId: targetId
        });
    });


    var saveArrange4Doctor = function () {
        var text = $(":input[data-day]");
        var result = [];        //封装数据
        var data = {day: null, dayPoint: null, rescuerId: null,week: null};
        for (var i = 0; i < text.length; i++) {
            var val = text.eq(i).val();
            if (!isNull(val)) {
                data.day = text.eq(i).attr("data-day");
                data.dayPoint = text.eq(i).attr("data-dayPoint");
                data.rescuerId  =text.eq(i).attr("data-rescuerId");
                data.week = week;
                result.push(data);
                data = {day: null, dayPoint: null, rescuerId: null,week: null};
            }
        }
        $.ajax({
            url: 'saveArrange4Doctor?roomId='+roomId,
            type: 'POST',
            dataType: 'JSON',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(result),
            success: function (result) {
                if (isSuccess(result)) {
                    swal({title: "科室更新成功！", type: "success"}, function () {
                        //todo 回调跳转到列表页
                        $('#update').modal('hide');
                        setTimeout(function () {
                            window.location.href = "/rest/clinicRoom/list";
                        }, 500);
                    });
                } else {
                    swal({title: result.msg, type: "error"});
                }
            }
        })
    };
    window.saveArrange4Doctor = saveArrange4Doctor;

});
$(document).on('click', function (e) {
    $('[data-toggle="popover"],[data-original-title]').each(function () {
        //the 'is' for buttons that trigger popups
        //the 'has' for icons within a button that triggers a popup
        if (!$(this).is(e.target) && $(this).has(e.target).length === 0 && $('.popover').has(e.target).length === 0) {
            (($(this).popover('hide').data('bs.popover') || {}).inState || {}).click = false;  // fix for BS 3.3.6
        }
    });
});


