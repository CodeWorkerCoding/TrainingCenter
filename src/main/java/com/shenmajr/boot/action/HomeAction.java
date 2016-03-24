package com.shenmajr.boot.action;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shenmajr.boot.domain.item.Item;
import com.shenmajr.boot.service.item.ItemService;

@Controller
public class HomeAction {

	private Logger logger = LoggerFactory.getLogger(HomeAction.class);
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/home")
	public String greet(Map<String, Object> model) {
		logger.info("this is greet Method");
		List<Item> items = itemService.getAll();
		model.put("items", items);
		return "home";
	}
	
	@RequestMapping(value="/login" ,method=RequestMethod.GET)
	public String sendLogin(@RequestParam(name="error",required=false) String error,
			@RequestParam(name="logout",required=false) String logout,
			Model model){
		if (error != null) {
			model.addAttribute("error", "Invalid UserName and Password");
		}
		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully");
		}
		if (logger.isInfoEnabled()) {
			logger.info("send the login Page to clients");
		}
		return "login";
	}
}
