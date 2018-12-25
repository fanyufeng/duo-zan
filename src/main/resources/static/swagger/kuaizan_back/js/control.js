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
            url:'https://kuaizan.duodework.com/manager/',
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
        var adProject_name = $("#tf-box-name").val();
        var adProject_url = $("#tf-box-upload").val();
        var adProject_client = $("#selected_client").data("client");
        var adProject_address = $("#tf-box-address").val();
        var adProjectContact_name = $("#tf-box-poc").val();
        var adProject_contact = $("#tf-box-contact").val();
        var info = {

        };
        $.ajax({
            url:'https://kuaizan.duodework.com/manager/',
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
    //添加项目客户
    $("#commit_projectClient").onclick(function () {
        var projectClient_name = $("#tf-box-name").val();
        var projectClient_address = $("#tf-box-address").val();
        var projectClientContact_name = $("#tf-box-poc").val();
        var projectClient_contact = $("#tf-box-contact").val();
        var info = {

        };
        $.ajax({
            url:'https://kuaizan.duodework.com/manager/',
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
    //添加项目
    $("#commit_project").onclick(function () {
        var projectClient_name = $("#tf-box-name").val();
        var Project_client = $("#selected_client").data("client");
        var project_address = $("#tf-box-address").val();
        var projectClientContact_name = $("#tf-box-poc").val();
        var projectClient_contact = $("#tf-box-contact").val();
        var QR_total = $("#tf-box-qr").val();
        var prohect_price = $("#tf-box-price").val();
        var info = {

        };
        $.ajax({
            url:'https://kuaizan.duodework.com/manager/',
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
    //设置现金分配
    $("#commit_dividend").onclick(function () {
        var cash_total = $("#tf-box-name").val();
        var info = {

        }
        $.ajax({
            url:'https://kuaizan.duodework.com/manager/',
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
    //设置Token系数
    $("#commit_coefficient").onclick(function () {
        var token_coefficient = $("#tf-box-name").val();
        var info = {

        }
        $.ajax({
            url:'https://kuaizan.duodework.com/manager/',
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
})