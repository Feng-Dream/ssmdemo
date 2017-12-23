package com.zking.ssm.controller;

import com.zking.ssm.model.Item;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class ItemController1 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		List<Item> items = new ArrayList<Item>();

		Item item1 = new Item();
		item1.setId(1);
		item1.setName("小米机械键盘");
		item1.setPrice(666.6f);

		Item item2 = new Item();
		item2.setId(2);
		item2.setName("小米移动电源");
		item2.setPrice(188.8f);

		Item item3 = new Item();
		item3.setId(3);
		item3.setName("小米6代手机");
		item3.setPrice(5999.9f);

		Item item4 = new Item();
		item4.setId(4);
		item4.setName("小米6代手机");
		item4.setPrice(5999.9f);

		items.add(item1);
		items.add(item2);
		items.add(item3);
		items.add(item4);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("items", items);
		modelAndView.setViewName("item/itemList");

		return modelAndView;
	}

}
