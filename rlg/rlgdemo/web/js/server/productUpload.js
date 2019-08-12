$(document).ready(function () {
    $(document).on("click","#selectBtn",function(){
        $("#uploadInput").click();
    });
    /*$(document).on("change","#uploadInput",function () {
        // Get a reference to the fileList
        var files = !!this.files ? this.files : [];

        // If no files were selected, or no FileReader support, return
        if (!files.length || !window.FileReader){
            alert("没有图片or浏览器不支持")
            return;
        }

        // Only proceed if the selected file is an image
        if (/^image/.test( files[0].type)){

            // Create a new instance of the FileReader
            var reader = new FileReader();

            // Read the local file as a DataURL
            reader.readAsDataURL(files[0]);

            // When loaded, set image data as background of div
            reader.onloadend = function(){

                $("#uploadPreview").src(this.result);

            }

        }
    });*/
    $(document).on("click","#uploadBtn",function(){
        var formData = new FormData($("#uploadForm")[0]); //创建一个forData
        formData.append('upimg', $('#uploadInput')[0].files[0]);//把file添加进去  name命名为img
        formData.append("testText",$("#testText").val());
        $.ajax({
            url: "/manage/product/uploadTest.do",
            data: formData,
            type: "POST",
            async: false,
            cache: false,
            contentType: false,
            processData: false,
            success: function(data) {
                alert(0);
            },
            error: function() {
                alert(1);
            }
        });
    });
});