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
    //更新广告客户
    $("#update_adsCustomer").click(function () {
        var adClient_name = $("#tf-box-name").val();
        var adClient_address = $("#tf-box-address").val();
        var adClientContact_name = $("#tf-box-poc").val();
        var adClient_contact = $("#tf-box-contact").val();
        var id = $(this).data('id');
        var info = {
            name:adClient_name,
            comment:adClientContact_name,
            address:adClient_address,
            telephone: adClient_contact,
            id:id
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/advertiser/update',
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
    //上传视频文件
    var vedio_url = "";
    $("#upload").click(function () {
        $.ajaxFileUpload({
            url:'https://kuaizan.duodework.com/annexLibrary/fileSave',//需要链接到服务器地址
            secureuri:false,
            fileElementId:'upload_video',//文件选择框的id属性
            type:'POST',
            dataType: 'JSON',   //json
            success: function (data) {
                data = $.parseJSON(data.replace(/<.*?>/ig,""));
                alert(data);
                if(data.statusCode == "02000000"){
                    alert("上传成功");
                    vedio_url = "https://kuaizan.duodework.com" + data.data.fileName;
                }

            }
        })
    });
    //上传图片文件
    var img_url = "";
    $("#upload_img_btn").click(function () {
        $.ajaxFileUpload({
            url:'https://kuaizan.duodework.com/annexLibrary/fileSave',//需要链接到服务器地址
            secureuri:false,
            fileElementId:'upload_img',//文件选择框的id属性
            type:'POST',
            dataType: 'JSON',   //json
            success: function (data) {
                data = $.parseJSON(data.replace(/<.*?>/ig,""));
                alert(data);
                if(data.statusCode == "02000000"){
                    alert("上传成功");
                    vedio_url = "https://kuaizan.duodework.com" + data.data.fileName;
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
    //更新广告项目
    $("#update_adProject").click(function () {
        var adProject_name = $("#tf-box-name").val();
        var adProject_address = $("#tf-box-address").val();
        var info = {
            name:adProject_name,
            advertiser_id:parseInt(selected_id),
            comment:adProject_address,
            advertise_url:vedio_url
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/advertise/update',
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
    //更新项目客户
    $("#update_projectClient").click(function () {
        var projectClient_name = $("#tf-box-name").val();
        var projectClient_address = $("#tf-box-address").val();
        var projectClientContact_name = $("#tf-box-poc").val();
        var projectClient_contact = $("#tf-box-contact").val();
        var id = $("#update_projectClient").data('id');
        var info = {
            name:projectClient_name,
            comment:projectClientContact_name,
            telephone:projectClient_contact,
            address:projectClient_address,
            id:id
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/factory/update',
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
    //添加Banner广告
    $("#commit_addBanner").click(function () {
       var BannerAd_name = $("#tf-box-name").val();
       var playTimes = $("#tf-box-times").val();
       var ad_imgUrl = img_url;
       var ad_videoUrl = vedio_url;
       var client_id = selected_id;
       var comment = $("#tf-box-address").val();
       var info = {

       }
       $.ajax({
            url:'https://kuaizan.duodework.com/',
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
    //添加index广告
    $("#commit_addIndex").click(function () {
        var indexAd_name = $("#tf-box-name").val();
        var playTimes = $("#tf-box-times").val();
        var ad_videoUrl = vedio_url;
        var client_id = selected_id;
        var comment = $("#tf-box-address").val();
        var info = {

        }
        $.ajax({
            url:'https://kuaizan.duodework.com/',
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
    //添加Launch广告
    $("#commit_addLaunch").click(function () {
        var launchAd_name = $("#tf-box-name").val();
        var playTimes = $("#tf-box-times").val();
        var ad_imgUrl = img_url;
        var client_id = selected_id;
        var comment = $("#tf-box-address").val();
        var info = {

        }
        $.ajax({
            url:'https://kuaizan.duodework.com/',
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
    //选择项目客户
    var selected_ClientId = "";
    $("#custom_list").on('click','.custom_selected',function () {
        selected_ClientId = $(this).data("id")
    });
    //选择广告
    var selected_AdProjectId = "";
    var vedio_url = "";
    $("#adProject_list").on('click','.adProject_selected',function () {
        selected_AdProjectId = $(this).data("id");
        vedio_url = $(this).data("url")
    });
    //添加项目
    $("#commit_project").click(function () {
        var projectClient_name = $("#tf-box-name").val();
        var project_address = $("#tf-box-address").val();
        var QR_total = $("#tf-box-qr").val();
        var price = $("#tf-box-price").val();
        var info = {
            name:projectClient_name,
            comment:project_address,
            factory_id:parseInt(selected_ClientId),
            advertise_id:parseInt(selected_AdProjectId)
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
                    var card_info = {
                        product_id:data.data.id,
                        factory_id:parseInt(selected_ClientId),
                        integration_num:parseInt(price),
                        advertise_id: parseInt(selected_AdProjectId),
                        vedio_url:vedio_url,
                        card_num:QR_total,
                        comment:project_address
                    };
                    $.ajax({
                        url:'https://kuaizan.duodework.com/card/add',
                        type:'POST',
                        data:JSON.stringify(card_info),
                        contentType:'application/json',
                        dataType:'json',
                        success:function (data) {
                            console.log(data);
                            if(data.statusCode == "02000000"){
                                alert("添加成功")
                                window.location.href = "../../index.html?id="+id
                            }
                        }
                    });
                }
            }
        })
    });
    $("#update_project").click(function () {
        var projectClient_name = $("#tf-box-name").val();
        var project_address = $("#tf-box-address").val();
        var QR_total = $("#tf-box-qr").val();
        var id = $("#update_project").data('id');
        var info = {
            name:projectClient_name,
            comment:project_address,
            factory_id:parseInt(selected_ClientId),
            advertise_id:parseInt(selected_AdProjectId),
            id:id
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/product/update',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                console.log(data);
                if(data.statusCode == "02000000"){
                    var card_info = {
                        product_id:data.data.id,
                        factory_id:parseInt(selected_ClientId),
                        integration_num:parseInt(QR_total),
                        advertise_id: parseInt(selected_AdProjectId),
                        vedio_url:vedio_url,
                        card_num:QR_total,
                        comment:project_address
                    };
                    $.ajax({
                        url:'https://kuaizan.duodework.com/card/add',
                        type:'POST',
                        data:JSON.stringify(card_info),
                        contentType:'application/json',
                        dataType:'json',
                        success:function (data) {
                            console.log(data);
                            if(data.statusCode == "02000000"){
                                alert("添加成功")
                                window.location.href = "../../index.html?id="+id
                            }
                        }
                    });
                }
            }
        })
    });
    //设置现金分配
    $("#commit_dividend").click(function () {
        var id = getUrlParam("id");
        var cash_total = $("#tf-box-total").val();
        var comment = $("#tf-box-comment").val();
        var info = {
            cash_total:cash_total,
            id:id,
            comment:comment
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/cash/total/add',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                if(data.statusCode == "02000000"){
                    alert("总额设置成功");
                    window.location.href = "cashDividend.html?id="+id
                }
            }
        })
    });
    //选择分配批次
    var cashId = "";
    $("#cash_info").on('click','.cash_selected',function () {
       cashId = $(this).data('id');
    });
    //进行现金分配
    $("#commit_cash").click(function () {
        var id = getUrlParam("id");
        var info = {
            cashTotalId:parseInt(cashId)
        };
        $.ajax({
            url:'https://kuaizan.duodework.com/cash/distribute',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                if(data.statusCode == "02000000"){
                    alert("分配成功");
                    window.location.href = "../../index.html?id="+id
                }
            }
        })
    });
    //提现处理
    $("#table_list").on('click','.withdrawBtn',function () {
        var id = $(this).data('id');
        var info = {
            id:parseInt(id)
        }
        $.ajax({
            url:'https://kuaizan.duodework.com/withdraw/update',
            type:'POST',
            data:JSON.stringify(info),
            contentType:'application/json',
            dataType:'json',
            success:function (data) {
                if(data.statusCode == "02000000"){
                    alert("提现成功");
                }
            }
        })
    });
    //设置Token系数
    $("#commit_coefficient").click(function () {
        var token_coefficient = $("#tf-box-name").val();
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
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/addAdCustom.html?id="+id;
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
    $("#toSetFuture").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/setFuture.html?id="+id;
    });
    $("#toWithdrawList").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/withdrawList.html?id="+id;
    });
    $("#toQRcodeList").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/finance/QRcodeList.html?id="+id;
    });
    $("#toAddLaunchAd").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/launchAdList.html?id="+id;
    });
    $("#toAddBannerAds").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/bannerAdsList.html?id="+id;
    });
    $("#toAddIndexAd").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/indexAdList.html?id="+id;
    });
    $("#toAddBannerAdDetail").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/addBannerAds.html?id="+id;
    });
    $("#toAddIndexAdDetail").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/addIndexAd.html?id="+id;
    });
    $("#toAddLaunchAdDetail").click(function () {
        window.location.href = "/static/swagger/kuaizan_back/pages/ads/addLaunchAd.html?id="+id;
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