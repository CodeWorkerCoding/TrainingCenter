package com.shenmajr.boot.action;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.sevices.Ed2kService;
import com.shenmajr.boot.sevices.StarServices;

@Controller
@RequestMapping("/ed2k")
public class Ed2kAction {
	
	private Logger logger = LoggerFactory.getLogger(Ed2kAction.class);
	@Autowired
	private Ed2kService ed2kService;
	@Autowired
	private StarServices starService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String AllEd2k(Model model){
		logger.info("Request All Ed2k......");
		model.addAttribute("ed2ks", ed2kService.getAll());
		return "ed2k/all";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String AddAEd2k(Model model){
		logger.info("Navigate to Add Ed2k Page....");
		model.addAttribute("stars", starService.getAll());
		return "ed2k/add";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String SaveAEd2k(HttpServletRequest request, Ed2k ed2k){
		logger.info("Save the Ed2k that submit by brown ....");
		ed2k.setDesignation(request.getParameter("designation"));
		String starId = request.getParameter("star");
		if (starId != null ) {
			ed2k.setStar(starService.getObj(starId));
		}
		ed2k.setEd2k(request.getParameter("ed2k"));
		ed2k.setRecordStatus(Status.NORMAL);
		ed2kService.create(ed2k);
		return "redirect:/ed2k/all";
	}
	
	@RequestMapping("/{id}/del")
	public String delEd2k(@PathVariable String id){
		Ed2k ed2k = ed2kService.getObj(id);
		ed2k.setRecordStatus(Status.DELETE);
		ed2kService.update(ed2k);
		return "redirect:/ed2k/all";
	}
	
}
