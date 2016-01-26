package com.shenmajr.boot.action;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.sevices.Ed2kService;

@Controller
@RequestMapping("/ed2k")
public class Ed2kAction {
	
	private Logger logger = LoggerFactory.getLogger(Ed2kAction.class);
	@Autowired
	private Ed2kService ed2kService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public String AllEd2k(Model model){
		logger.info("Request All Ed2k......");
		model.addAttribute("ed2ks", ed2kService.getAll());
		return "ed2k/all";
	}
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String AddAEd2k(){
		logger.info("Navigate to Add Ed2k Page....");
		return "ed2k/add";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String SaveAEd2k(HttpServletRequest request, Ed2k ed2k){
		logger.info("Save the Ed2k that submit by brown ....");
		ed2kService.create(ed2k);
		return "redirect:/ed2k/all";
	}
	
}
