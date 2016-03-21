package com.shenmajr.boot.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shenmajr.boot.domain.Attachment;
import com.shenmajr.boot.domain.Star;
import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.sevices.StarServices;
import com.shenmajr.boot.sevices.imp.AttachmentService;
import com.shenmajr.boot.utils.CommonUtils;
import com.shenmajr.boot.utils.UUIDUtil;

@Controller
@RequestMapping(value="/star")
public class StarAction {

	private final static Integer PAGE_MIN = 1;
	private final static Integer PAGE_MAX = 20;
	@Autowired
	private StarServices starServices;
	@Autowired
	private AttachmentService attachmentService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addAStar(Model model, Star star,
			HttpServletResponse response){
		model.addAttribute("star", star);
		return "star/add";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savaAStar(HttpServletRequest request, Star star, HttpServletResponse response,
			@RequestParam("image") MultipartFile file, Attachment attachment) throws IOException{
		star.setName(request.getParameter("name"));
		star.setNickname(request.getParameter("nickname"));
		star.setMensurations(request.getParameter("mensurations"));
		star.setRecordStatus(Status.NORMAL);
		Star saveStar = starServices.create(star);
		
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (saveStar != null) {
			attachment.setStar(saveStar);
			Attachment saveAttach = attachmentService.upload(file,attachment);
			if (saveAttach != null) {
				saveStar.setLately(CommonUtils.subImageUrl(saveAttach.getUrl()));
				starServices.update(saveStar);
				out.print("添加成功明星成功");
				return "redirect:/star/allbypage";
			}
		} else {
			out.print("添加失败");
		}
		out.flush();
		return null;
	}
	
	
	@RequestMapping(value="/allbypage", method={RequestMethod.GET, RequestMethod.POST})
	public String AllStar(@RequestParam(defaultValue = "1", required = false) final Integer page,
			@RequestParam(defaultValue = "10", required = false) final Integer pagesize,
			final Map<String, Object> model, HttpServletRequest request){
		final Map<String, Object> result = starServices.findByPage(
				new PageRequest(page < PAGE_MIN ? 0 : page - 1, 
						pagesize > PAGE_MAX ? PAGE_MAX : pagesize, new Sort(Direction.DESC, "updateTime")), 
				request);
		model.putAll(result);
		return "/star/all";
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String AllStar(Model model){
		List<Star> stars = starServices.getAll();
		model.addAttribute("stars", stars);
		return "star/all";
	}
	/**
	 * Description: 处理删除明星记录，只是做物理删除ß
	 * @param id
	 * @return
	 * Created by fujianjian 2016年1月27日
	 */
	@RequestMapping("/{id}/del")
	public String delStar(@PathVariable(value="id") String id) {
		Star star = starServices.getObj(id);
		star.setRecordStatus(Status.DELETE);
		starServices.update(star);
		return "redirect:/star/allbypage";
	}
	/**
	 * Description: 处理添加明星时上传的图片 (暂时只能使用表单提交，所以这方法暂
	 * 					时不启用，启用时将去掉 @Deprecated)
	 * @return
	 * Created by fujianjian 2016年1月27日
	 * @throws IOException 
	 */
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	@Deprecated
	public String uploadImage(@RequestParam("image") MultipartFile myfile, HttpServletRequest request,
			HttpServletResponse response, Attachment attachment) throws IOException{
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		if (myfile.isEmpty()) {
			out.print("1,请选择文件后上传");
			out.flush();
			return null;
		} else {
			Attachment attach = attachmentService.upload(myfile, attachment);
			if (attach == null) {
				out.print("2,上传失败");
			} else {
				out.println("0, " + attach.get_id() + ", " + attach.getName());
			}
		}
		out.flush();
		return null;
	}
	/**
	 * Description: (暂时只能使用表单提交，所以这
	 * 			方法暂时不启用，启用时将去掉 @Deprecated)
	 * @param files
	 * @param request
	 * @return
	 * Created by fujianjian 2016年1月28日
	 */
	@RequestMapping("/handle")
	@Deprecated
	public String handleUpload(@RequestParam("image") MultipartFile[] files,
			HttpServletRequest request){
		if (files != null && files.length > 0) {
			for (int i = 0; i < files.length; i++) {
				attachmentService.saveUploadFile(request, files[i]);
			}
		}
		return "redirect:/star/all";
	}
	
	@RequestMapping(value="/{id}/look", method={RequestMethod.GET, RequestMethod.POST})
	public String checkStar(@PathVariable("id") String id, Model model){
		Star star = starServices.getObj(id);
		List<Attachment> images = attachmentService.getByStar(star);
		model.addAttribute("star", star);
		model.addAttribute("images", images);
		return "star/info";
	}
	@RequestMapping(value="/{id}/modify", method={RequestMethod.GET, RequestMethod.POST})
	public String modifyStar(@PathVariable("id") String id, Model model){
		Star star = starServices.getObj(id);
		model.addAttribute("star", star);
		return "star/modify";
	}
	
	@RequestMapping(value="/validate", method=RequestMethod.GET)
	@ResponseBody
	public String createStar(Star star){
		star.set_id(UUIDUtil.genUUID());
		star.setAge(15);
		star.setName("sghsaifjso");
		star.setNickname("abc");
		starServices.create(star);
		return "completed";
	}
}
