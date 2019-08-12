$(document).ready(function () {
   //add
   $(document).on("click","#addSubmit",function () {
       var formData = new FormData($("#uploadForm")[0]);
       formData.append('addMainImage', $("input[name='addMainImage']")[0].files[0]);
       formData.append("addName",$("input[name='addName']").val());
       formData.append("addCategoryId",$("input[name='addCategoryId']").val());
       formData.append("addSubtitle",$("input[name='addSubtitle']").val());
       formData.append("addDetail",$("textarea[name='addDetail']").val());
       formData.append("addPrice",$("input[name='addPrice']").val());
       formData.append("addStatus",$("input[name='addStatus']").val());
       $.ajax({
           url: "/manage/product/uploadImgByAjax.do",
           data: formData,
           type: "POST",
           async: false,
           cache: false,
           contentType: false,
           processData: false,
           success: function(e) {
               if (e.status==="0"){
                   alert("添加成功！！")
                   $("#productList").click();
               }
           },
           error: function() {
               alert("ajax提交表单上传图片出错了！！！");
           }
       });
   });
});