$(".L-show").click(
	function(){
		$(".L-hidden li").slideUp(400,function(){
			$(this).parent().parent().prev().find(".i-right").removeClass("fa-caret-up");
			$(this).parent().parent().prev().find(".i-right").addClass("fa-caret-down");
		});
		$(this).next().find("li").slideDown(400,function(){
			// $(this).find(".i-right").removeClass("fa-caret-down");
			$(this).parent().parent().prev().find(".i-right").removeClass("fa-caret-down");
			$(this).parent().parent().prev().find(".i-right").addClass("fa-caret-up");
		});
		// $(this).next().children().children().slideToggle(400);
		
		
		// 点击模块时清除li的选中状态
		// $(".L-hidden li").removeClass("clicked");
	}
);

// 点击功能时增加背景
$(".L-hidden li").click(function(){
	$(".L-hidden li").removeClass("clicked");
    $(this).addClass("clicked");
});

// 单击伸缩菜单栏
$("#activeMenu").click(function(){
	
});

