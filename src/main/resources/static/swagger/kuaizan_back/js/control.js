$(document).ready(function () {
    //获取参数
    var id = getUrlParam("id");
    //添加广告客户
    $("#commit_adsCustomer").click(function () {
        var adClient_name = $("#tf-box-name").val();
        var adClient_address = $("#tf-box-address").val();
        var adClientContact_name = $("#tf-box-poc").val();
        var adClient_contact = $("#tf-box-contact").val();
        var info = {
            name:adClient_name,
            comment:adClientContact_name,
            address:adClient_address,
            telephone: adClient_contact
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/advertiser/add',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                console.log(data);
                if(data.statusCode == "02000000"){
                    alert("添加成功");
                    window.location.href = "../../index.html?id="+id
                }
            }
        })
    });
    //上传文件
    var vedio_url = "";
    $("#upload").click(function () {
        $.ajaxFileUpload({
            url:'https://kuaizan.duodework.com/annexLibrary/fileSave',//需要链接到服务器地址
            secureuri:false,
            fileElementId:'upload_video',//文件选择框的id属性
            type:'POST',
            dataType: 'JSON',   //json
            success: function (data) {
                console.log(data);
                if(data.statusCode == "02000000"){
                    alert("上传成功");
                    vedio_url = "https://kuaizan.duodework.com/images/" + data.data.url;
                }

            }
        })
    });
    //添加广告项目中的获取广告客户列表
    var selected_id = "";
    $("#section_info").on('click','.selected',function () {
        selected_id = $(this).data("id");
    });
    //添加广告项目
    $("#commit_adProject").click(function () {
        var adProject_name = $("#tf-box-name").val();
        var adProject_address = $("#tf-box-address").val();
        var info = {
            name:adProject_name,
            advertiser_id:parseInt(selected_id),
            comment:adProject_address,
            advertise_url:vedio_url
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/advertise/add',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                console.log(data);
                if(data.statusCode == "02000000"){
                    alert("添加成功");
                    window.location.href = "../../index.html?id="+id
                }
            }
        })
    });
    //添加项目客户
    $("#commit_projectClient").click(function () {
        var projectClient_name = $("#tf-box-name").val();
        var projectClient_address = $("#tf-box-address").val();
        var projectClientContact_name = $("#tf-box-poc").val();
        var projectClient_contact = $("#tf-box-contact").val();
        var info = {
            name:projectClient_name,
            comment:projectClientContact_name,
            telephone:projectClient_contact,
            address:projectClient_address
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/factory/add',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                console.log(data);
                if(data.statusCode == "02000000"){
                    alert("添加成功");
                    window.location.href = "../../index.html?id="+id
                }
            }
        })
    });
    //添加项目
    $("#commit_project").click(function () {
        var projectClient_name = $("#tf-box-name").val();
        var Project_client = $("#selected_client").data("client");
        var project_address = $("#tf-box-address").val();
        var projectClientContact_name = $("#tf-box-poc").val();
        var projectClient_contact = $("#tf-box-contact").val();
        var QR_total = $("#tf-box-qr").val();
        var prohect_price = $("#tf-box-price").val();
        var info = {
            name:projectClient_name,
            comment:project_address,
            factory_id:1
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/product/add',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                console.log(data);
                if(data.statusCode == "02000000"){
                    alert("添加成功");
                    window.location.href = "../../index.html?id="+id
                }
            }
        })
    });
    //设置现金分配
    $("#commit_dividend").click(function () {
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
    $("#commit_coefficient").click(function () {
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
                alert(data.statusCode);
            }
        })
    });
    //页面跳转控制
    $("#toIndex").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/index.html?id="+id;
    });
    $("#toAdCustomList").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/adCustomList.html?id="+id;
    });
    $("#toAddAdCustom").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/addAdCustomList.html?id="+id;
    });
    $("#toAddAdProject").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/addAdProject.html?id="+id;
    });
    $("#toAdProjectList").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/adProjectList.html?id="+id;
    });
    $("#toAddProjectCustom").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/project/addProjectCustom.html?id="+id;
    });
    $("#toAddProject").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/project/addProject.html?id="+id;
    });
    $("#toProjectCustomList").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/project/projectCustomList.html?id="+id;
    });
    $("#toProjectList").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/project/projectList.html?id="+id;
    });
    $("#toSetTokenCount").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/setTokenCount.html?id="+id;
    });
    $("#toSetTokenCoefficient").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/setTokenCoefficient.html?id="+id;
    });
    $("#toSetCashDividend").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/setCashDividend.html?id="+id;
    });
    $("#toTokenReview").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/tokenReview.html?id="+id;
    });
    $("#toCashReview").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/cashReview.html?id="+id;
    });
    $("#toUserList").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/user/userList.html?id="+id;
    });
    $("#toSetPurview").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/purview/setPurview.html?id="+id;
    });


    //选择用户
    /**
    $("#hero-js-select").click(function () {
        $.ajax({
            url:'https://kuaizan.duodework.com/advertiser/add',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                if(data.statusCode == "02000000"){
                    console.log(data.data)
                }
            }
        })
    });
    ***/
    //获取参数
    function getUrlParam(name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
        var r = window.location.search.substr(1).match(reg);  //匹配目标参数
        if (r != null) return unescape(r[2]); return null; //返回参数值
    }
})