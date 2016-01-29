function loadByClass(src,classname){
	$(".nav-sidebar li").removeClass("active");
	$(classname).addClass("active");
	$(".table-responsive .myiframe").attr("src",src);
}

function upload(id, attach, isrequired){
	var attachid=$("#"+attach).val();
	if("" == attachid){
		ajaxFileUpload(id, attach, isrequired)
	} else {
		if(confirm("是否删除文件...")){
			deleteAttachment(id, attach, attachid, isrequired);
			$("#"+id).change(function(){
				upload(id, attach,isrequired);
			});
		}
	}
}
function deleteAttachment(id, attach, attachid, isrequired){
	$("#"+id).show();
	$("#"+attach).val("");
	
}
function ajaxFileUpload(id, attach, isrequired){
	$.ajax({
		url: "/star/upload",
		
	})
}

/**
 * 提交表单时校验数据的完整性
 */
function checkStar(){
	var starname=$("#starname").val();
	var starimge=$("#starimage").val();
	if("" == starname){
		$("#starname").bind("onchange",function(e){
			alert("bind the Event successful");
			if("" != $("#starname").val()){
				$("#submit").removeAttr("disabled");
			}
		});
		alert("请输入明星姓名再提交...");
		$("#starname").focus();
		return ;
	}
	if("" == starimge){
		alert("请上传明星图片再提交...");
		$("#starimage").focus();
		return ;
	}
	$("#submit").removeAttr("disabled");
	return true;
}

/**
 * 
 */
function checkEd2k(){
	var designation = $("#designation").val();
	var areaed2k = $("#areaed2k").val();
	if("" == designation){
		$("#designation").bind("onblur",function(e){
			if("" != $("#designation").val()){
				$("#submit").removeAttr("disabled");
			}
		});
		alert("请填写作品名称后再提交...");
		$("#designation").focus();
		return false;
	}
	if("" == areaed2k){
		alert("请填写Ed2k地址后在提交...");
		$("#areaed2k").focus();
		return false;
	}
	$("#submit").removeAttr("disabled");
	return true;
}
