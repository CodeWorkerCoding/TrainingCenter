package com.shenmajr.boot.action.item;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shenmajr.boot.domain.item.Item;
import com.shenmajr.boot.service.item.ItemService;
import com.shenmajr.boot.util.UserUtil;

@Controller
@RequestMapping(value="/item")
public class ItemAction {
	
	private static final Logger logger = LoggerFactory.getLogger(ItemAction.class);

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/add", method={RequestMethod.GET,RequestMethod.POST})
	public String addItem(@Valid @ModelAttribute("item") Item item,
			BindingResult result, Map<String, Object> model){
		if (result.hasErrors()) {
			model.put("item", item);
			return "item/add";
		}
		Item addItem = itemService.addObject(item);
		logger.info("add item id {} and name {} by user {}",
				addItem.getId(), addItem.getTitle(), UserUtil.getCurrentUser());
		return "redirect:/home";
	}
	
	@RequestMapping(value="/modify", method={RequestMethod.GET,RequestMethod.POST})
	public String updateItem(@Valid @ModelAttribute("item") Item item,
			BindingResult result, Map<String, Object> model){
		if (result.hasErrors()) {
			model.put("item", item);
			return "item/update";
		}
		itemService.update(item);
		return "redirect:/home";
	}
	
	@RequestMapping(value="/{id}/del")
	public String delItem(@PathVariable Integer id){
		itemService.del(id);
		logger.info("Deleted a {} Item by user {}",id, UserUtil.getCurrentUser());
		return "redirect:/home";
	}
	@RequestMapping(value="/all", method={RequestMethod.GET, RequestMethod.POST})
	public String getAllItems(Map<String, Object> model){
		List<Item> items = itemService.getAll();
		model.put("items", items);
		return "item/all";
	}
	
}
