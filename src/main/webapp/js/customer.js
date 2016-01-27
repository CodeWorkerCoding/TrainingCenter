function loadByClass(src,classname){
	$(".nav-sidebar li").removeClass("active");
	$(classname).addClass("active");
	$(".table-responsive .myiframe").attr("src",src);
}