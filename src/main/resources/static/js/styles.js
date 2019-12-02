$(function () {
    $("#date-picker").datepicker({
        autoclose: true,
        todayHighlight: true
    }).datepicker('update', new Date());
});
