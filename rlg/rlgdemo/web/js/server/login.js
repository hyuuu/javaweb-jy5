$("button").click(function () {
   $.post(
       "/manage/user/login.do",
       {
           username : $("input[name='username']").val(),
           password : $("input[name='password']").val()
       },
       function (e) {
           if (e.status === "0" ){
               window.open("/pages/server/home.jsp","_self");
           }else {
               alert(e.msg);
           }
       },
       "JSON"
   )
});