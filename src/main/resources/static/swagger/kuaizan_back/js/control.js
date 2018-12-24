$(document).ready(function () {
    //添加广告客户
    $("#commit_adsCustomer").onclick(function () {
        var adClient_name = $("#tf-box-name").val();
        var adClient_address = $("#tf-box-address").val();
        var adClientContact_name = $("#tf-box-poc").val();
        var adClient_contact = $("#tf-box-contact").val();
        var info = {

        };
        $.ajax({
            url:'https://kuaizan.duodework.com/manager/getByTelephone',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                alert("ajax");
                alert(data.data.statusCode);
            }
        })
    });
    //添加广告项目
    $("#commit_adProject").onclick(function () {
        var adClient_name = $("#tf-box-name").val();
        var adClient_address = $("#tf-box-address").val();
        var adClientContact_name = $("#tf-box-poc").val();
        var adClient_contact = $("#tf-box-contact").val();
        var info = {

        };
        $.ajax({
            url:'https://kuaizan.duodework.com/manager/getByTelephone',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                alert("ajax");
                alert(data.data.statusCode);
            }
        })
    })
})