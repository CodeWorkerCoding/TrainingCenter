package com.shenmajr.boot.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shenmajr.boot.domain.Star;
import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.sevices.StarServices;
import com.shenmajr.boot.utils.CommonUtils;

@Controller
@RequestMapping(value="/star")
public class StarAction {

	@Autowired
	private StarServices starServices;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String AddAStar(Model model, Star star){
		model.addAttribute("star", star);
		return "star/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String SaveAStar(Star star){
		starServices.create(star);
		return "redirect:/star/all";
	}
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String savaAStar(HttpServletRequest request, Star star){
		star.setName(request.getParameter("name"));
		star.setNickname(request.getParameter("nickname"));
		star.setMensurations(request.getParameter("mensurations").split(","));
//		star.setMensurations(CommonUtils.stringToInt(mensurations));
		star.setRecordStatus(Status.NORMAL);
		starServices.create(star);
		return "redirect:/star/all";
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public String AllStar(Model model){
		List<Star> stars = starServices.getAll();
		model.addAttribute("stars", stars);
		return "star/all";
	}
	
}
