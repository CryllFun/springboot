$(function () {
    rotate();
    formSubmit();
})

/**
 * 切换登录注册界面
 */
function rotate() {
    document.querySelector('.img__btn').addEventListener('click', function() {
        document.querySelector('.cont').classList.toggle('s--signup');
    });
    $(".img__btn").click(function () {
        var list = $(this).find("span");
        for(var i=0;i<list.length;i++){
            if($(list[i]).attr("dir")=="true"){
                $(list[i]).attr("dir","false");
            }else {
                $(list[i]).attr("dir","true");
            }
        }
    });
}

/**
 * 表单提交
 */
function formSubmit() {
    $("#userName").click(function () {
        $(this).val("").removeClass("errorMsg")
    })
    $("#login").click(function () {
        $("#loginForm").submit();
    })
    $("#register").click(function () {
        submitSign();
    })
    //绑定回车事件
    $(document).keypress(function (event) {
        if(event.keyCode==13){
            if($("#toLogin").attr("dir")=="true"){
                $("#loginForm").submit();
            }
            if($("#toSign").attr("dir")=="true"){
                submitSign();
            }
        }
    });
}
function submitSign() {
    $.ajax({
        type:"post",
        dataType:"text",//返回结果是字符串时text，返回结果非字符串时json
        url:"/register",
        data:$("#registerForm").serialize(),//提交表单
        success:function (data) {
            if(data){
                alert(data);
            }
        }
    })
}