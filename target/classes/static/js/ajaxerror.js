$.ajax({
    url: "/err/getAjaxerror",
    type: "POST",
    async: false,
    success: function(data){
        if (data.status == 200 && data.msg == "OK"){
            alert("success");
        } else {
            alert("异常发生:" + data.msg);
        }
    },
    error: function (response, ajaxOptions, throwError) {
        alert("error");
    }
})