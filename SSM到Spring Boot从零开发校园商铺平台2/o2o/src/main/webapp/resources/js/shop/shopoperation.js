/*1.从后台获取 商铺分类、所属分类 等信息，并填充到前端页面*/
/*2.获取前端表单，发送到后台注册店铺*/
$(function () {
    var initUrl = '/o2o/shopadmin/getshopinitinfo';
    var registerShopUrl = '/o2o/shopadmin/registershop';
    getShopInitInfo();

    function getShopInitInfo() {
        $.getJSON(initUrl, function (data) {
            console.log(data);
            if (data.success) {
                var tempHtml = '';
                var tempAreaHtml = '';
                data.shopCategoryList.map(function (item, index) {
                    /*<option data-id="1">shopCategory</option>*/
                    tempHtml += '<option data-id="' + item.shopCategoryId + '">' + item.shopCategoryName + '</option>';
                });
                // console.log('tempHtml:' + tempHtml);
                data.areaList.map(function (item, index) {
                    tempAreaHtml += '<option data-id="' + item.areaId + '">' + item.areaName + '</option>';
                });
                // console.log('tempAreaHtml' + tempAreaHtml);
                $('#shop-category').html(tempHtml);
                $('#area').html(tempAreaHtml);
            }

        });

    }

    $('#submit').click(function () {
        var shop = {};
        shop.shopName = $('#shop-name').val();
        shop.shopCategory = {
            shopCategoryId: $('#shop-category').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        shop.shopAddr = $('#shop-addr').val();
        shop.shopDesc = $('#shop-desc').val();
        shop.phone = $('#shop-phone').val();
        shop.area = {
            areaId: $('#area').find('option').not(function () {
                return !this.selected;
            }).data('id')
        };
        var shopImg = $('#shop-img')[0].files[0];
        var formData = new FormData();
        formData.append('shopImg', shopImg);
        formData.append('shopStr', JSON.stringify(shop));
        var verifyCodeActual=$('#j_captcha').val();
        if(!verifyCodeActual){
            $.toast("请输入验证码！");
            return;
        }
        formData.append('verifyCodeActual',verifyCodeActual);
        $.ajax({
            url: registerShopUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data.success) {
                    $.toast('提交成功！');
                } else {
                    $.toast('提交失败！' + data.errMsg);
                }
                $('#captcha_img').click();
            }

        });
    });
});